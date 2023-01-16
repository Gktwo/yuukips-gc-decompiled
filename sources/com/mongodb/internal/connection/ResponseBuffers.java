package com.mongodb.internal.connection;

import java.io.Closeable;
import org.bson.BsonDocument;
import org.bson.ByteBuf;
import org.bson.codecs.Decoder;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ResponseBuffers.class */
public class ResponseBuffers implements Closeable {
    private final ReplyHeader replyHeader;
    private final ByteBuf bodyByteBuffer;
    private final int bodyByteBufferStartPosition;
    private volatile boolean isClosed;

    /* access modifiers changed from: package-private */
    public ResponseBuffers(ReplyHeader replyHeader, ByteBuf bodyByteBuffer) {
        this.replyHeader = replyHeader;
        this.bodyByteBuffer = bodyByteBuffer;
        this.bodyByteBufferStartPosition = bodyByteBuffer == null ? 0 : bodyByteBuffer.position();
    }

    public ReplyHeader getReplyHeader() {
        return this.replyHeader;
    }

    /* access modifiers changed from: package-private */
    public <T extends BsonDocument> T getResponseDocument(int messageId, Decoder<T> decoder) {
        ReplyMessage<T> replyMessage = new ReplyMessage<>(this, decoder, (long) messageId);
        reset();
        return replyMessage.getDocuments().get(0);
    }

    public ByteBuf getBodyByteBuffer() {
        return this.bodyByteBuffer.asReadOnly();
    }

    public void reset() {
        this.bodyByteBuffer.position(this.bodyByteBufferStartPosition);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.isClosed) {
            if (this.bodyByteBuffer != null) {
                this.bodyByteBuffer.release();
            }
            this.isClosed = true;
        }
    }
}
