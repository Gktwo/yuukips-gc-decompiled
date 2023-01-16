package dev.morphia.mapping.codec.pojo;

import dev.morphia.annotations.PostPersist;
import dev.morphia.annotations.PrePersist;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.writer.DocumentWriter;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/pojo/LifecycleEncoder.class */
public class LifecycleEncoder extends EntityEncoder {
    /* Return type fixed from 'java.lang.Class' to match base method */
    @Override // dev.morphia.mapping.codec.pojo.EntityEncoder, org.bson.codecs.Encoder
    public /* bridge */ /* synthetic */ Class<Object> getEncoderClass() {
        return getEncoderClass();
    }

    public <T> LifecycleEncoder(MorphiaCodec<T> morphiaCodec) {
        super(morphiaCodec);
    }

    @Override // dev.morphia.mapping.codec.pojo.EntityEncoder, org.bson.codecs.Encoder
    public void encode(BsonWriter writer, Object value, EncoderContext encoderContext) {
        EntityModel model = getMorphiaCodec().getEntityModel();
        Mapper mapper = getMorphiaCodec().getMapper();
        Document document = new Document();
        model.callLifecycleMethods(PrePersist.class, value, document, mapper);
        DocumentWriter documentWriter = new DocumentWriter(mapper, document);
        encode(documentWriter, value, encoderContext);
        Document document2 = documentWriter.getDocument();
        model.callLifecycleMethods(PostPersist.class, value, document2, mapper);
        getMorphiaCodec().getRegistry().get(Document.class).encode(writer, document2, encoderContext);
    }
}
