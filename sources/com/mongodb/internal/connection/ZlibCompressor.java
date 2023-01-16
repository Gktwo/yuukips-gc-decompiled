package com.mongodb.internal.connection;

import com.mongodb.MongoCompressor;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ZlibCompressor.class */
class ZlibCompressor extends Compressor {
    private final int level;

    /* access modifiers changed from: package-private */
    public ZlibCompressor(MongoCompressor mongoCompressor) {
        this.level = ((Integer) mongoCompressor.getPropertyNonNull(MongoCompressor.LEVEL, -1)).intValue();
    }

    @Override // com.mongodb.internal.connection.Compressor
    public String getName() {
        return "zlib";
    }

    @Override // com.mongodb.internal.connection.Compressor
    public byte getId() {
        return 2;
    }

    @Override // com.mongodb.internal.connection.Compressor
    InputStream getInputStream(InputStream source) {
        return new InflaterInputStream(source);
    }

    @Override // com.mongodb.internal.connection.Compressor
    OutputStream getOutputStream(OutputStream source) {
        return new DeflaterOutputStream(source, new Deflater(this.level));
    }
}
