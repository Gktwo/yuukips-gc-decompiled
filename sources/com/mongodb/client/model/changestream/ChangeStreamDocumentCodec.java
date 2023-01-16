package com.mongodb.client.model.changestream;

import com.mongodb.MongoNamespace;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.BsonValueCodecProvider;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.ClassModel;
import org.bson.codecs.pojo.ClassModelBuilder;
import org.bson.codecs.pojo.PojoCodecProvider;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/client/model/changestream/ChangeStreamDocumentCodec.class */
public final class ChangeStreamDocumentCodec<TResult> implements Codec<ChangeStreamDocument<TResult>> {
    private static final OperationTypeCodec OPERATION_TYPE_CODEC = new OperationTypeCodec();
    private final Codec<ChangeStreamDocument<TResult>> codec;

    @Override // org.bson.codecs.Encoder
    public /* bridge */ /* synthetic */ void encode(BsonWriter bsonWriter, Object obj, EncoderContext encoderContext) {
        encode(bsonWriter, (ChangeStreamDocument) ((ChangeStreamDocument) obj), encoderContext);
    }

    /* access modifiers changed from: package-private */
    public ChangeStreamDocumentCodec(Class<TResult> fullDocumentClass, CodecRegistry codecRegistry) {
        ClassModelBuilder<ChangeStreamDocument> classModelBuilder = ClassModel.builder(ChangeStreamDocument.class);
        classModelBuilder.getProperty("fullDocument").codec(codecRegistry.get(fullDocumentClass));
        classModelBuilder.getProperty("operationType").codec(OPERATION_TYPE_CODEC);
        this.codec = CodecRegistries.fromRegistries(CodecRegistries.fromProviders(PojoCodecProvider.builder().register(MongoNamespace.class).register(UpdateDescription.class).register(classModelBuilder.build()).build(), new BsonValueCodecProvider()), codecRegistry).get(ChangeStreamDocument.class);
    }

    @Override // org.bson.codecs.Decoder
    public ChangeStreamDocument<TResult> decode(BsonReader reader, DecoderContext decoderContext) {
        return this.codec.decode(reader, decoderContext);
    }

    public void encode(BsonWriter writer, ChangeStreamDocument<TResult> value, EncoderContext encoderContext) {
        this.codec.encode(writer, value, encoderContext);
    }

    @Override // org.bson.codecs.Encoder
    public Class<ChangeStreamDocument<TResult>> getEncoderClass() {
        return ChangeStreamDocument.class;
    }
}
