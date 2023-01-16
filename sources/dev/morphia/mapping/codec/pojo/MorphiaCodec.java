package dev.morphia.mapping.codec.pojo;

import dev.morphia.Datastore;
import dev.morphia.mapping.DiscriminatorLookup;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.MappingException;
import dev.morphia.mapping.codec.Conversions;
import dev.morphia.mapping.codec.PropertyCodecRegistryImpl;
import dev.morphia.sofia.Sofia;
import java.util.List;
import java.util.Locale;
import org.bson.BsonReader;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PropertyCodecProvider;
import org.bson.codecs.pojo.PropertyCodecRegistry;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/pojo/MorphiaCodec.class */
public class MorphiaCodec<T> implements CollectibleCodec<T> {
    private final PropertyModel idProperty;
    private final Mapper mapper;
    private final EntityModel entityModel;
    private final CodecRegistry registry;
    private final PropertyCodecRegistry propertyCodecRegistry;
    private final DiscriminatorLookup discriminatorLookup;
    private EntityEncoder encoder = new EntityEncoder(this);
    private EntityDecoder decoder = new EntityDecoder(this);

    public MorphiaCodec(Datastore datastore, EntityModel model, List<PropertyCodecProvider> propertyCodecProviders, DiscriminatorLookup discriminatorLookup, CodecRegistry registry) {
        this.mapper = datastore.getMapper();
        this.discriminatorLookup = discriminatorLookup;
        this.entityModel = model;
        this.registry = CodecRegistries.fromRegistries(CodecRegistries.fromCodecs(this), registry);
        this.propertyCodecRegistry = new PropertyCodecRegistryImpl(this, registry, propertyCodecProviders);
        this.idProperty = model.getIdProperty();
        specializePropertyCodecs();
    }

    @Override // org.bson.codecs.Decoder
    public T decode(BsonReader reader, DecoderContext decoderContext) {
        return (T) getDecoder().decode(reader, decoderContext);
    }

    @Override // org.bson.codecs.CollectibleCodec
    public boolean documentHasId(Object entity) {
        PropertyModel idField = this.entityModel.getIdProperty();
        if (idField != null) {
            return idField.getValue(entity) != null;
        }
        throw new MappingException(Sofia.idRequired(entity.getClass().getName(), new Locale[0]));
    }

    public EntityModel getEntityModel() {
        return this.entityModel;
    }

    public EntityEncoder getEncoder() {
        return this.encoder;
    }

    public MorphiaCodec<T> setEncoder(EntityEncoder encoder) {
        this.encoder = encoder;
        return this;
    }

    protected EntityDecoder getDecoder() {
        return this.decoder;
    }

    public void setDecoder(EntityDecoder decoder) {
        this.decoder = decoder;
    }

    @Override // org.bson.codecs.Encoder
    public void encode(BsonWriter writer, Object value, EncoderContext encoderContext) {
        this.encoder.encode(writer, value, encoderContext);
    }

    @Override // org.bson.codecs.Encoder
    public Class getEncoderClass() {
        return getEntityModel().getType();
    }

    @Override // org.bson.codecs.CollectibleCodec
    public Object generateIdIfAbsentFromDocument(Object entity) {
        if (!documentHasId(entity)) {
            this.idProperty.setValue(entity, Conversions.convert(new ObjectId(), this.idProperty.getType()));
        }
        return entity;
    }

    @Override // org.bson.codecs.CollectibleCodec
    public BsonValue getDocumentId(Object document) {
        throw new UnsupportedOperationException();
    }

    private void specializePropertyCodecs() {
        for (PropertyModel propertyModel : getEntityModel().getProperties()) {
            Codec codec = propertyModel.getCodec() != null ? propertyModel.getCodec() : this.propertyCodecRegistry.get(propertyModel.getTypeData());
            if (codec != null) {
                propertyModel.cachedCodec(codec);
            }
        }
    }

    public Mapper getMapper() {
        return this.mapper;
    }

    /* access modifiers changed from: package-private */
    public DiscriminatorLookup getDiscriminatorLookup() {
        return this.discriminatorLookup;
    }

    /* access modifiers changed from: package-private */
    public CodecRegistry getRegistry() {
        return this.registry;
    }
}
