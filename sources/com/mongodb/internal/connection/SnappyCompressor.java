package com.mongodb.internal.connection;

import com.mongodb.MongoInternalException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.bson.ByteBuf;
import org.bson.p022io.BsonOutput;
import org.xerial.snappy.Snappy;
import org.xerial.snappy.SnappyInputStream;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/SnappyCompressor.class */
class SnappyCompressor extends Compressor {
    @Override // com.mongodb.internal.connection.Compressor
    public String getName() {
        return "snappy";
    }

    @Override // com.mongodb.internal.connection.Compressor
    public byte getId() {
        return 1;
    }

    @Override // com.mongodb.internal.connection.Compressor
    public void compress(List<ByteBuf> source, BsonOutput target) {
        int uncompressedSize = getUncompressedSize(source);
        byte[] singleByteArraySource = new byte[uncompressedSize];
        copy(source, singleByteArraySource);
        try {
            byte[] out = new byte[Snappy.maxCompressedLength(uncompressedSize)];
            target.writeBytes(out, 0, Snappy.compress(singleByteArraySource, 0, singleByteArraySource.length, out, 0));
        } catch (IOException e) {
            throw new MongoInternalException("Unexpected IOException", e);
        }
    }

    private int getUncompressedSize(List<ByteBuf> source) {
        int uncompressedSize = 0;
        for (ByteBuf cur : source) {
            uncompressedSize += cur.remaining();
        }
        return uncompressedSize;
    }

    private void copy(List<ByteBuf> source, byte[] in) {
        int offset = 0;
        for (ByteBuf cur : source) {
            int remaining = cur.remaining();
            cur.get(in, offset, remaining);
            offset += remaining;
        }
    }

    @Override // com.mongodb.internal.connection.Compressor
    InputStream getInputStream(InputStream source) throws IOException {
        return new SnappyInputStream(source);
    }
}
