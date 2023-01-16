package com.mongodb;

import com.mongodb.connection.BufferProvider;
import com.mongodb.internal.connection.ByteBufferBsonOutput;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bson.BsonBinaryWriter;
import org.bson.BsonReader;
import org.bson.codecs.Decoder;
import org.bson.codecs.DecoderContext;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/DBDecoderAdapter.class */
public class DBDecoderAdapter implements Decoder<DBObject> {
    private final DBDecoder decoder;
    private final DBCollection collection;
    private final BufferProvider bufferProvider;

    /* access modifiers changed from: package-private */
    public DBDecoderAdapter(DBDecoder decoder, DBCollection collection, BufferProvider bufferProvider) {
        this.decoder = decoder;
        this.collection = collection;
        this.bufferProvider = bufferProvider;
    }

    @Override // org.bson.codecs.Decoder
    public DBObject decode(BsonReader reader, DecoderContext decoderContext) {
        ByteBufferBsonOutput bsonOutput;
        BsonBinaryWriter binaryWriter;
        try {
            bsonOutput = new ByteBufferBsonOutput(this.bufferProvider);
            binaryWriter = new BsonBinaryWriter(bsonOutput);
            try {
                binaryWriter.pipe(reader);
                BufferExposingByteArrayOutputStream byteArrayOutputStream = new BufferExposingByteArrayOutputStream(binaryWriter.getBsonOutput().getSize());
                bsonOutput.pipe(byteArrayOutputStream);
                DBObject decode = this.decoder.decode(byteArrayOutputStream.getInternalBytes(), this.collection);
                binaryWriter.close();
                bsonOutput.close();
                return decode;
            } catch (IOException e) {
                throw new MongoInternalException("An unlikely IOException thrown.", e);
            }
        } catch (Throwable th) {
            binaryWriter.close();
            bsonOutput.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/DBDecoderAdapter$BufferExposingByteArrayOutputStream.class */
    public static class BufferExposingByteArrayOutputStream extends ByteArrayOutputStream {
        BufferExposingByteArrayOutputStream(int size) {
            super(size);
        }

        byte[] getInternalBytes() {
            return this.buf;
        }
    }
}
