package dev.morphia.mapping.codec.pojo;

import com.mongodb.lang.Nullable;
import dev.morphia.mapping.DiscriminatorLookup;
import dev.morphia.mapping.codec.Conversions;
import dev.morphia.mapping.codec.MorphiaInstanceCreator;
import org.bson.BsonInvalidOperationException;
import org.bson.BsonReader;
import org.bson.BsonReaderMark;
import org.bson.BsonType;
import org.bson.codecs.Codec;
import org.bson.codecs.Decoder;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.configuration.CodecConfigurationException;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/pojo/EntityDecoder.class */
public class EntityDecoder implements Decoder<Object> {
    private final MorphiaCodec<?> morphiaCodec;
    private final EntityModel classModel;

    /* access modifiers changed from: protected */
    public EntityDecoder(MorphiaCodec<?> morphiaCodec) {
        this.morphiaCodec = morphiaCodec;
        this.classModel = morphiaCodec.getEntityModel();
    }

    @Override // org.bson.codecs.Decoder
    public Object decode(BsonReader reader, DecoderContext decoderContext) {
        if (!decoderContext.hasCheckedDiscriminator()) {
            return getCodecFromDocument(reader, this.classModel.useDiscriminator(), this.classModel.getDiscriminatorKey(), this.morphiaCodec.getRegistry(), this.morphiaCodec.getDiscriminatorLookup(), this.morphiaCodec).decode(reader, DecoderContext.builder().checkedDiscriminator(true).build());
        }
        MorphiaInstanceCreator instanceCreator = getInstanceCreator();
        decodeProperties(reader, decoderContext, instanceCreator, this.classModel);
        return instanceCreator.getInstance();
    }

    protected MorphiaInstanceCreator getInstanceCreator() {
        return this.classModel.getInstanceCreator();
    }

    protected void decodeModel(BsonReader reader, DecoderContext decoderContext, MorphiaInstanceCreator instanceCreator, @Nullable PropertyModel model) {
        if (model != null) {
            try {
                if (reader.getCurrentBsonType() == BsonType.NULL) {
                    reader.readNull();
                } else {
                    instanceCreator.set(decoderContext.decodeWithChildContext(model.getCachedCodec(), reader), model);
                }
            } catch (BsonInvalidOperationException e) {
                reader.getMark().reset();
                instanceCreator.set(Conversions.convert(this.morphiaCodec.getMapper().getCodecRegistry().get(Object.class).decode(reader, decoderContext), model.getTypeData().getType()), model);
            }
        } else {
            reader.skipValue();
        }
    }

    protected void decodeProperties(BsonReader reader, DecoderContext decoderContext, MorphiaInstanceCreator instanceCreator, EntityModel classModel) {
        reader.readStartDocument();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            String name = reader.readName();
            if (!classModel.useDiscriminator() || !classModel.getDiscriminatorKey().equals(name)) {
                decodeModel(reader, decoderContext, instanceCreator, classModel.getProperty(name));
            } else {
                reader.readString();
            }
        }
        reader.readEndDocument();
    }

    protected Codec<?> getCodecFromDocument(BsonReader reader, boolean useDiscriminator, String discriminatorKey, CodecRegistry registry, DiscriminatorLookup discriminatorLookup, Codec<?> defaultCodec) {
        Codec<?> codec = null;
        if (useDiscriminator) {
            BsonReaderMark mark = reader.getMark();
            try {
                try {
                    reader.readStartDocument();
                    while (codec == null) {
                        if (reader.readBsonType() == BsonType.END_OF_DOCUMENT) {
                            break;
                        } else if (discriminatorKey.equals(reader.readName())) {
                            codec = registry.get(discriminatorLookup.lookup(reader.readString()));
                        } else {
                            reader.skipValue();
                        }
                    }
                } catch (Exception e) {
                    throw new CodecConfigurationException(String.format("Failed to decode '%s'. Decoding errored with: %s", this.morphiaCodec.getEntityModel().getName(), e.getMessage()), e);
                }
            } finally {
                mark.reset();
            }
        }
        return codec != null ? codec : defaultCodec;
    }

    protected MorphiaCodec<?> getMorphiaCodec() {
        return this.morphiaCodec;
    }
}
