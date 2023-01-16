package org.bson.p022io;

import java.nio.ByteOrder;
import java.nio.charset.Charset;
import org.bson.BsonSerializationException;
import org.bson.ByteBuf;
import org.bson.types.ObjectId;

/* renamed from: org.bson.io.ByteBufferBsonInput */
/* loaded from: grasscutter.jar:org/bson/io/ByteBufferBsonInput.class */
public class ByteBufferBsonInput implements BsonInput {
    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");
    private static final String[] ONE_BYTE_ASCII_STRINGS = new String[128];
    private ByteBuf buffer;

    static {
        for (int b = 0; b < ONE_BYTE_ASCII_STRINGS.length; b++) {
            ONE_BYTE_ASCII_STRINGS[b] = String.valueOf((char) b);
        }
    }

    public ByteBufferBsonInput(ByteBuf buffer) {
        if (buffer == null) {
            throw new IllegalArgumentException("buffer can not be null");
        }
        this.buffer = buffer;
        buffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // org.bson.p022io.BsonInput
    public int getPosition() {
        ensureOpen();
        return this.buffer.position();
    }

    @Override // org.bson.p022io.BsonInput
    public byte readByte() {
        ensureOpen();
        ensureAvailable(1);
        return this.buffer.get();
    }

    @Override // org.bson.p022io.BsonInput
    public void readBytes(byte[] bytes) {
        ensureOpen();
        ensureAvailable(bytes.length);
        this.buffer.get(bytes);
    }

    @Override // org.bson.p022io.BsonInput
    public void readBytes(byte[] bytes, int offset, int length) {
        ensureOpen();
        ensureAvailable(length);
        this.buffer.get(bytes, offset, length);
    }

    @Override // org.bson.p022io.BsonInput
    public long readInt64() {
        ensureOpen();
        ensureAvailable(8);
        return this.buffer.getLong();
    }

    @Override // org.bson.p022io.BsonInput
    public double readDouble() {
        ensureOpen();
        ensureAvailable(8);
        return this.buffer.getDouble();
    }

    @Override // org.bson.p022io.BsonInput
    public int readInt32() {
        ensureOpen();
        ensureAvailable(4);
        return this.buffer.getInt();
    }

    @Override // org.bson.p022io.BsonInput
    public ObjectId readObjectId() {
        ensureOpen();
        byte[] bytes = new byte[12];
        readBytes(bytes);
        return new ObjectId(bytes);
    }

    @Override // org.bson.p022io.BsonInput
    public String readString() {
        ensureOpen();
        int size = readInt32();
        if (size <= 0) {
            throw new BsonSerializationException(String.format("While decoding a BSON string found a size that is not a positive number: %d", Integer.valueOf(size)));
        }
        ensureAvailable(size);
        return readString(size);
    }

    @Override // org.bson.p022io.BsonInput
    public String readCString() {
        int mark = this.buffer.position();
        skipCString();
        int size = this.buffer.position() - mark;
        this.buffer.position(mark);
        return readString(size);
    }

    private String readString(int size) {
        if (size == 2) {
            byte asciiByte = this.buffer.get();
            if (this.buffer.get() != 0) {
                throw new BsonSerializationException("Found a BSON string that is not null-terminated");
            } else if (asciiByte < 0) {
                return UTF8_CHARSET.newDecoder().replacement();
            } else {
                return ONE_BYTE_ASCII_STRINGS[asciiByte];
            }
        } else {
            byte[] bytes = new byte[size - 1];
            this.buffer.get(bytes);
            if (this.buffer.get() == 0) {
                return new String(bytes, UTF8_CHARSET);
            }
            throw new BsonSerializationException("Found a BSON string that is not null-terminated");
        }
    }

    @Override // org.bson.p022io.BsonInput
    public void skipCString() {
        ensureOpen();
        boolean checkNext = true;
        while (checkNext) {
            if (!this.buffer.hasRemaining()) {
                throw new BsonSerializationException("Found a BSON string that is not null-terminated");
            }
            checkNext = this.buffer.get() != 0;
        }
    }

    @Override // org.bson.p022io.BsonInput
    public void skip(int numBytes) {
        ensureOpen();
        this.buffer.position(this.buffer.position() + numBytes);
    }

    @Override // org.bson.p022io.BsonInput
    public BsonInputMark getMark(int readLimit) {
        return new BsonInputMark() { // from class: org.bson.io.ByteBufferBsonInput.1
            private int mark;

            {
                this.mark = ByteBufferBsonInput.this.buffer.position();
            }

            @Override // org.bson.p022io.BsonInputMark
            public void reset() {
                ByteBufferBsonInput.this.ensureOpen();
                ByteBufferBsonInput.this.buffer.position(this.mark);
            }
        };
    }

    @Override // org.bson.p022io.BsonInput
    public boolean hasRemaining() {
        ensureOpen();
        return this.buffer.hasRemaining();
    }

    @Override // org.bson.p022io.BsonInput, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.buffer.release();
        this.buffer = null;
    }

    /* access modifiers changed from: private */
    public void ensureOpen() {
        if (this.buffer == null) {
            throw new IllegalStateException("Stream is closed");
        }
    }

    private void ensureAvailable(int bytesNeeded) {
        if (this.buffer.remaining() < bytesNeeded) {
            throw new BsonSerializationException(String.format("While decoding a BSON document %d bytes were required, but only %d remain", Integer.valueOf(bytesNeeded), Integer.valueOf(this.buffer.remaining())));
        }
    }
}
