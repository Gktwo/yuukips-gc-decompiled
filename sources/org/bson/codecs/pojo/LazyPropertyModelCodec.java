package org.bson.codecs.pojo;

import java.util.ArrayList;
import java.util.List;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.RepresentationConfigurable;
import org.bson.codecs.configuration.CodecConfigurationException;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:org/bson/codecs/pojo/LazyPropertyModelCodec.class */
class LazyPropertyModelCodec<T> implements Codec<T> {
    private final PropertyModel<T> propertyModel;
    private final CodecRegistry registry;
    private final PropertyCodecRegistry propertyCodecRegistry;
    private final DiscriminatorLookup discriminatorLookup;
    private Codec<T> codec;

    /* access modifiers changed from: package-private */
    public LazyPropertyModelCodec(PropertyModel<T> propertyModel, CodecRegistry registry, PropertyCodecRegistry propertyCodecRegistry, DiscriminatorLookup discriminatorLookup) {
        this.propertyModel = propertyModel;
        this.registry = registry;
        this.propertyCodecRegistry = propertyCodecRegistry;
        this.discriminatorLookup = discriminatorLookup;
    }

    @Override // org.bson.codecs.Decoder
    public T decode(BsonReader reader, DecoderContext decoderContext) {
        return getPropertyModelCodec().decode(reader, decoderContext);
    }

    @Override // org.bson.codecs.Encoder
    public void encode(BsonWriter writer, T value, EncoderContext encoderContext) {
        getPropertyModelCodec().encode(writer, value, encoderContext);
    }

    @Override // org.bson.codecs.Encoder
    public Class<T> getEncoderClass() {
        return this.propertyModel.getTypeData().getType();
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: org.bson.codecs.pojo.PropertyModel<T>, org.bson.codecs.pojo.PropertyModel<V> */
    private synchronized Codec<T> getPropertyModelCodec() {
        if (this.codec == null) {
            Codec<T> localCodec = getCodecFromPropertyRegistry(this.propertyModel);
            boolean z = localCodec instanceof PojoCodec;
            Codec<T> localCodec2 = localCodec;
            if (z) {
                PojoCodec<T> pojoCodec = (PojoCodec) localCodec;
                localCodec2 = new PojoCodecImpl<>(getSpecializedClassModel(pojoCodec.getClassModel(), (PropertyModel<T>) this.propertyModel), this.registry, this.propertyCodecRegistry, pojoCodec.getDiscriminatorLookup(), true);
            }
            this.codec = localCodec2;
        }
        return this.codec;
    }

    private Codec<T> getCodecFromPropertyRegistry(PropertyModel<T> propertyModel) {
        try {
            Codec<T> localCodec = this.propertyCodecRegistry.get(propertyModel.getTypeData());
            if (localCodec == null) {
                localCodec = new LazyMissingCodec(propertyModel.getTypeData().getType(), new CodecConfigurationException("Unexpected missing codec for: " + propertyModel.getName()));
            }
            BsonType representation = propertyModel.getBsonRepresentation();
            if (representation == null) {
                return localCodec;
            }
            if (localCodec instanceof RepresentationConfigurable) {
                return ((RepresentationConfigurable) localCodec).withRepresentation(representation);
            }
            throw new CodecConfigurationException("Codec must implement RepresentationConfigurable to support BsonRepresentation");
        } catch (CodecConfigurationException e) {
            return new LazyMissingCodec(propertyModel.getTypeData().getType(), e);
        }
    }

    private <V> ClassModel<T> getSpecializedClassModel(ClassModel<T> clazzModel, PropertyModel<V> propertyModel) {
        boolean changeTheDiscriminator = (propertyModel.useDiscriminator() == null ? clazzModel.useDiscriminator() : propertyModel.useDiscriminator().booleanValue()) != clazzModel.useDiscriminator() && (clazzModel.getDiscriminatorKey() != null && clazzModel.getDiscriminator() != null);
        if (propertyModel.getTypeData().getTypeParameters().isEmpty() && !changeTheDiscriminator) {
            return clazzModel;
        }
        ArrayList<PropertyModel<?>> concretePropertyModels = new ArrayList<>(clazzModel.getPropertyModels());
        PropertyModel<?> concreteIdProperty = clazzModel.getIdPropertyModel();
        List<TypeData<?>> propertyTypeParameters = propertyModel.getTypeData().getTypeParameters();
        for (int i = 0; i < concretePropertyModels.size(); i++) {
            PropertyModel<?> propertyModel2 = concretePropertyModels.get(i);
            String propertyName = propertyModel2.getName();
            TypeParameterMap typeParameterMap = clazzModel.getPropertyNameToTypeParameterMap().get(propertyName);
            if (typeParameterMap.hasTypeParameters()) {
                PropertyModel<V> specializedPropertyModel = getSpecializedPropertyModel(propertyModel2, propertyTypeParameters, typeParameterMap);
                concretePropertyModels.set(i, specializedPropertyModel);
                if (concreteIdProperty != null && concreteIdProperty.getName().equals(propertyName)) {
                    concreteIdProperty = specializedPropertyModel;
                }
            }
        }
        return new ClassModel<>(clazzModel.getType(), clazzModel.getPropertyNameToTypeParameterMap(), clazzModel.getInstanceCreatorFactory(), Boolean.valueOf(changeTheDiscriminator ? propertyModel.useDiscriminator().booleanValue() : clazzModel.useDiscriminator()), clazzModel.getDiscriminatorKey(), clazzModel.getDiscriminator(), IdPropertyModelHolder.create(clazzModel, concreteIdProperty), concretePropertyModels);
    }

    private <V> PropertyModel<V> getSpecializedPropertyModel(PropertyModel<V> propertyModel, List<TypeData<?>> propertyTypeParameters, TypeParameterMap typeParameterMap) {
        TypeData<V> specializedPropertyType = PojoSpecializationHelper.specializeTypeData(propertyModel.getTypeData(), propertyTypeParameters, typeParameterMap);
        if (propertyModel.getTypeData().equals(specializedPropertyType)) {
            return propertyModel;
        }
        return new PropertyModel<>(propertyModel.getName(), propertyModel.getReadName(), propertyModel.getWriteName(), specializedPropertyType, null, propertyModel.getPropertySerialization(), propertyModel.useDiscriminator(), propertyModel.getPropertyAccessor(), propertyModel.getError(), propertyModel.getBsonRepresentation());
    }
}
