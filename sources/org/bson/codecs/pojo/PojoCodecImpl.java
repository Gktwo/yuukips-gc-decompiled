package org.bson.codecs.pojo;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.bson.BsonInvalidOperationException;
import org.bson.BsonReader;
import org.bson.BsonReaderMark;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecConfigurationException;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.diagnostics.Logger;
import org.bson.diagnostics.Loggers;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/codecs/pojo/PojoCodecImpl.class */
public final class PojoCodecImpl<T> extends PojoCodec<T> {
    private static final Logger LOGGER = Loggers.getLogger("PojoCodec");
    private final ClassModel<T> classModel;
    private final CodecRegistry registry;
    private final PropertyCodecRegistry propertyCodecRegistry;
    private final DiscriminatorLookup discriminatorLookup;
    private final boolean specialized;

    /* access modifiers changed from: package-private */
    public PojoCodecImpl(ClassModel<T> classModel, CodecRegistry codecRegistry, List<PropertyCodecProvider> propertyCodecProviders, DiscriminatorLookup discriminatorLookup) {
        this.classModel = classModel;
        this.registry = codecRegistry;
        this.discriminatorLookup = discriminatorLookup;
        this.propertyCodecRegistry = new PropertyCodecRegistryImpl(this, this.registry, propertyCodecProviders);
        this.specialized = shouldSpecialize(classModel);
        specialize();
    }

    /* access modifiers changed from: package-private */
    public PojoCodecImpl(ClassModel<T> classModel, CodecRegistry codecRegistry, PropertyCodecRegistry propertyCodecRegistry, DiscriminatorLookup discriminatorLookup, boolean specialized) {
        this.classModel = classModel;
        this.registry = codecRegistry;
        this.discriminatorLookup = discriminatorLookup;
        this.propertyCodecRegistry = propertyCodecRegistry;
        this.specialized = specialized;
        specialize();
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<S> */
    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: java.lang.Class<T>, java.lang.Class<V> */
    /* JADX DEBUG: Type inference failed for r4v2. Raw type applied. Possible types: org.bson.codecs.pojo.IdPropertyModelHolder<?>, org.bson.codecs.pojo.IdPropertyModelHolder<S> */
    @Override // org.bson.codecs.Encoder
    public void encode(BsonWriter writer, T value, EncoderContext encoderContext) {
        if (!this.specialized) {
            throw new CodecConfigurationException(String.format("%s contains generic types that have not been specialised.%nTop level classes with generic types are not supported by the PojoCodec.", this.classModel.getName()));
        } else if (areEquivalentTypes(value.getClass(), (Class<T>) this.classModel.getType())) {
            writer.writeStartDocument();
            encodeIdProperty(writer, value, encoderContext, this.classModel.getIdPropertyModelHolder());
            if (this.classModel.useDiscriminator()) {
                writer.writeString(this.classModel.getDiscriminatorKey(), this.classModel.getDiscriminator());
            }
            for (PropertyModel propertyModel : this.classModel.getPropertyModels()) {
                if (!propertyModel.equals(this.classModel.getIdPropertyModel())) {
                    encodeProperty(writer, value, encoderContext, propertyModel);
                }
            }
            writer.writeEndDocument();
        } else {
            this.registry.get(value.getClass()).encode(writer, value, encoderContext);
        }
    }

    @Override // org.bson.codecs.Decoder
    public T decode(BsonReader reader, DecoderContext decoderContext) {
        if (!decoderContext.hasCheckedDiscriminator()) {
            return getCodecFromDocument(reader, this.classModel.useDiscriminator(), this.classModel.getDiscriminatorKey(), this.registry, this.discriminatorLookup, this).decode(reader, DecoderContext.builder().checkedDiscriminator(true).build());
        }
        if (!this.specialized) {
            throw new CodecConfigurationException(String.format("%s contains generic types that have not been specialised.%nTop level classes with generic types are not supported by the PojoCodec.", this.classModel.getName()));
        }
        InstanceCreator<T> instanceCreator = this.classModel.getInstanceCreator();
        decodeProperties(reader, decoderContext, instanceCreator);
        return instanceCreator.getInstance();
    }

    @Override // org.bson.codecs.Encoder
    public Class<T> getEncoderClass() {
        return this.classModel.getType();
    }

    public String toString() {
        return String.format("PojoCodec<%s>", this.classModel);
    }

    /* access modifiers changed from: package-private */
    @Override // org.bson.codecs.pojo.PojoCodec
    public ClassModel<T> getClassModel() {
        return this.classModel;
    }

    private <S> void encodeIdProperty(BsonWriter writer, T instance, EncoderContext encoderContext, IdPropertyModelHolder<S> propertyModelHolder) {
        if (propertyModelHolder.getPropertyModel() == null) {
            return;
        }
        if (propertyModelHolder.getIdGenerator() == null) {
            encodeProperty(writer, instance, encoderContext, propertyModelHolder.getPropertyModel());
            return;
        }
        S id = propertyModelHolder.getPropertyModel().getPropertyAccessor().get(instance);
        if (id == null && encoderContext.isEncodingCollectibleDocument()) {
            id = propertyModelHolder.getIdGenerator().generate();
            try {
                propertyModelHolder.getPropertyModel().getPropertyAccessor().set(instance, id);
            } catch (Exception e) {
            }
        }
        encodeValue(writer, encoderContext, propertyModelHolder.getPropertyModel(), id);
    }

    private <S> void encodeProperty(BsonWriter writer, T instance, EncoderContext encoderContext, PropertyModel<S> propertyModel) {
        if (propertyModel != null && propertyModel.isReadable()) {
            encodeValue(writer, encoderContext, propertyModel, propertyModel.getPropertyAccessor().get(instance));
        }
    }

    private <S> void encodeValue(BsonWriter writer, EncoderContext encoderContext, PropertyModel<S> propertyModel, S propertyValue) {
        if (propertyModel.shouldSerialize(propertyValue)) {
            writer.writeName(propertyModel.getReadName());
            if (propertyValue == null) {
                writer.writeNull();
                return;
            }
            try {
                encoderContext.encodeWithChildContext(propertyModel.getCachedCodec(), writer, propertyValue);
            } catch (CodecConfigurationException e) {
                throw new CodecConfigurationException(String.format("Failed to encode '%s'. Encoding '%s' errored with: %s", this.classModel.getName(), propertyModel.getReadName(), e.getMessage()), e);
            }
        }
    }

    /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: org.bson.codecs.pojo.PropertyModel<?>, org.bson.codecs.pojo.PropertyModel<S> */
    private void decodeProperties(BsonReader reader, DecoderContext decoderContext, InstanceCreator<T> instanceCreator) {
        reader.readStartDocument();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            String name = reader.readName();
            if (!this.classModel.useDiscriminator() || !this.classModel.getDiscriminatorKey().equals(name)) {
                decodePropertyModel(reader, decoderContext, instanceCreator, name, getPropertyModelByWriteName(this.classModel, name));
            } else {
                reader.readString();
            }
        }
        reader.readEndDocument();
    }

    private <S> void decodePropertyModel(BsonReader reader, DecoderContext decoderContext, InstanceCreator<T> instanceCreator, String name, PropertyModel<S> propertyModel) {
        if (propertyModel != null) {
            try {
                Object obj = null;
                if (reader.getCurrentBsonType() == BsonType.NULL) {
                    reader.readNull();
                } else {
                    Codec<S> codec = propertyModel.getCachedCodec();
                    if (codec == null) {
                        throw new CodecConfigurationException(String.format("Missing codec in '%s' for '%s'", this.classModel.getName(), propertyModel.getName()));
                    }
                    obj = decoderContext.decodeWithChildContext(codec, reader);
                }
                if (propertyModel.isWritable()) {
                    instanceCreator.set(obj, propertyModel);
                }
            } catch (BsonInvalidOperationException | CodecConfigurationException e) {
                throw new CodecConfigurationException(String.format("Failed to decode '%s'. Decoding '%s' errored with: %s", this.classModel.getName(), name, e.getMessage()), e);
            }
        } else {
            if (LOGGER.isTraceEnabled()) {
                LOGGER.trace(String.format("Found property not present in the ClassModel: %s", name));
            }
            reader.skipValue();
        }
    }

    private void specialize() {
        if (this.specialized) {
            this.classModel.getPropertyModels().forEach(this::cachePropertyModelCodec);
        }
    }

    private <S> void cachePropertyModelCodec(PropertyModel<S> propertyModel) {
        if (propertyModel.getCachedCodec() == null) {
            propertyModel.cachedCodec(propertyModel.getCodec() != null ? propertyModel.getCodec() : new LazyPropertyModelCodec<>(propertyModel, this.registry, this.propertyCodecRegistry, this.discriminatorLookup));
        }
    }

    private <S, V> boolean areEquivalentTypes(Class<S> t1, Class<V> t2) {
        if (t1.equals(t2)) {
            return true;
        }
        if (Collection.class.isAssignableFrom(t1) && Collection.class.isAssignableFrom(t2)) {
            return true;
        }
        if (!Map.class.isAssignableFrom(t1) || !Map.class.isAssignableFrom(t2)) {
            return false;
        }
        return true;
    }

    private Codec<T> getCodecFromDocument(BsonReader reader, boolean useDiscriminator, String discriminatorKey, CodecRegistry registry, DiscriminatorLookup discriminatorLookup, Codec<T> defaultCodec) {
        Codec<T> codec = defaultCodec;
        if (useDiscriminator) {
            BsonReaderMark mark = reader.getMark();
            reader.readStartDocument();
            boolean discriminatorKeyFound = false;
            while (!discriminatorKeyFound && reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
                if (discriminatorKey.equals(reader.readName())) {
                    discriminatorKeyFound = true;
                    try {
                        Class<?> discriminatorClass = discriminatorLookup.lookup(reader.readString());
                        if (!codec.getEncoderClass().equals(discriminatorClass)) {
                            codec = registry.get(discriminatorClass);
                        }
                    } catch (Exception e) {
                        throw new CodecConfigurationException(String.format("Failed to decode '%s'. Decoding errored with: %s", this.classModel.getName(), e.getMessage()), e);
                    }
                } else {
                    reader.skipValue();
                }
            }
            mark.reset();
        }
        return codec;
    }

    private PropertyModel<?> getPropertyModelByWriteName(ClassModel<T> classModel, String readName) {
        for (PropertyModel<?> propertyModel : classModel.getPropertyModels()) {
            if (propertyModel.isWritable() && propertyModel.getWriteName().equals(readName)) {
                return propertyModel;
            }
        }
        return null;
    }

    private static <T> boolean shouldSpecialize(ClassModel<T> classModel) {
        if (!classModel.hasTypeParameters()) {
            return true;
        }
        for (Map.Entry<String, TypeParameterMap> entry : classModel.getPropertyNameToTypeParameterMap().entrySet()) {
            TypeParameterMap typeParameterMap = entry.getValue();
            PropertyModel<?> propertyModel = classModel.getPropertyModel(entry.getKey());
            if (typeParameterMap.hasTypeParameters() && (propertyModel == null || propertyModel.getCodec() == null)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @Override // org.bson.codecs.pojo.PojoCodec
    public DiscriminatorLookup getDiscriminatorLookup() {
        return this.discriminatorLookup;
    }
}
