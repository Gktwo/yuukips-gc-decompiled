package dev.morphia.mapping.codec.pojo;

import dev.morphia.annotations.PostLoad;
import dev.morphia.annotations.PreLoad;
import dev.morphia.mapping.codec.MorphiaInstanceCreator;
import dev.morphia.mapping.codec.reader.DocumentReader;
import org.bson.BsonReader;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.configuration.CodecConfigurationException;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/pojo/LifecycleDecoder.class */
public class LifecycleDecoder extends EntityDecoder {
    public <T> LifecycleDecoder(MorphiaCodec<T> codec) {
        super(codec);
    }

    @Override // dev.morphia.mapping.codec.pojo.EntityDecoder, org.bson.codecs.Decoder
    public Object decode(BsonReader reader, DecoderContext decoderContext) {
        String discriminator;
        Document document = (Document) getMorphiaCodec().getRegistry().get(Document.class).decode(reader, decoderContext);
        EntityModel model = getMorphiaCodec().getEntityModel();
        if (model.useDiscriminator() && (discriminator = document.getString(model.getDiscriminatorKey())) != null) {
            Codec<?> codec = getMorphiaCodec().getRegistry().get(getMorphiaCodec().getDiscriminatorLookup().lookup(discriminator));
            if (codec instanceof MorphiaCodec) {
                model = ((MorphiaCodec) codec).getEntityModel();
            } else {
                throw new CodecConfigurationException(String.format("Non-entity class used as discriminator: '%s'.", discriminator));
            }
        }
        MorphiaInstanceCreator instanceCreator = model.getInstanceCreator();
        Object entity = instanceCreator.getInstance();
        model.callLifecycleMethods(PreLoad.class, entity, document, getMorphiaCodec().getMapper());
        decodeProperties(new DocumentReader(document), decoderContext, instanceCreator, model);
        model.callLifecycleMethods(PostLoad.class, entity, document, getMorphiaCodec().getMapper());
        return entity;
    }
}
