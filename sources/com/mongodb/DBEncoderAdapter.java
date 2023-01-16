package com.mongodb;

import com.mongodb.assertions.Assertions;
import java.nio.ByteBuffer;
import org.bson.BsonBinaryReader;
import org.bson.BsonWriter;
import org.bson.ByteBufNIO;
import org.bson.codecs.Encoder;
import org.bson.codecs.EncoderContext;
import org.bson.p022io.BasicOutputBuffer;
import org.bson.p022io.ByteBufferBsonInput;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/DBEncoderAdapter.class */
public class DBEncoderAdapter implements Encoder<DBObject> {
    private final DBEncoder encoder;

    /* access modifiers changed from: package-private */
    public DBEncoderAdapter(DBEncoder encoder) {
        this.encoder = (DBEncoder) Assertions.notNull("encoder", encoder);
    }

    public void encode(BsonWriter writer, DBObject document, EncoderContext encoderContext) {
        BasicOutputBuffer buffer = new BasicOutputBuffer();
        try {
            this.encoder.writeObject(buffer, document);
            BsonBinaryReader reader = new BsonBinaryReader(new ByteBufferBsonInput(new ByteBufNIO(ByteBuffer.wrap(buffer.toByteArray()))));
            writer.pipe(reader);
            reader.close();
        } finally {
            buffer.close();
        }
    }

    @Override // org.bson.codecs.Encoder
    public Class<DBObject> getEncoderClass() {
        return DBObject.class;
    }
}
