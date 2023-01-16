package com.mongodb.internal.connection;

import com.github.luben.zstd.Zstd;
import com.github.luben.zstd.ZstdInputStream;
import com.mongodb.MongoInternalException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.bson.ByteBuf;
import org.bson.p022io.BsonOutput;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ZstdCompressor.class */
class ZstdCompressor extends Compressor {
    @Override // com.mongodb.internal.connection.Compressor
    public String getName() {
        return "zstd";
    }

    @Override // com.mongodb.internal.connection.Compressor
    public byte getId() {
        return 3;
    }

    @Override // com.mongodb.internal.connection.Compressor
    public void compress(List<ByteBuf> source, BsonOutput target) {
        int uncompressedSize = getUncompressedSize(source);
        byte[] singleByteArraySource = new byte[uncompressedSize];
        copy(source, singleByteArraySource);
        try {
            byte[] out = new byte[(int) Zstd.compressBound((long) uncompressedSize)];
            target.writeBytes(out, 0, (int) Zstd.compress(out, singleByteArraySource, Zstd.maxCompressionLevel()));
        } catch (RuntimeException e) {
            throw new MongoInternalException("Unexpected RuntimeException", e);
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
        return new ZstdInputStream(source);
    }
}
