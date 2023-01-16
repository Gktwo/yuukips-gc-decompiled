package com.mongodb;

import org.bson.BsonWriter;
import org.bson.codecs.Encoder;
import org.bson.codecs.EncoderContext;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/DBEncoderFactoryAdapter.class */
public class DBEncoderFactoryAdapter implements Encoder<DBObject> {
    private final DBEncoderFactory encoderFactory;

    /* access modifiers changed from: package-private */
    public DBEncoderFactoryAdapter(DBEncoderFactory encoderFactory) {
        this.encoderFactory = encoderFactory;
    }

    public void encode(BsonWriter writer, DBObject value, EncoderContext encoderContext) {
        new DBEncoderAdapter(this.encoderFactory.create()).encode(writer, value, encoderContext);
    }

    @Override // org.bson.codecs.Encoder
    public Class<DBObject> getEncoderClass() {
        return DBObject.class;
    }
}
