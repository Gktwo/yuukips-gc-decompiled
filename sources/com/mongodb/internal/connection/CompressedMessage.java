package com.mongodb.internal.connection;

import com.mongodb.internal.connection.RequestMessage;
import com.mongodb.internal.session.SessionContext;
import java.util.List;
import org.bson.ByteBuf;
import org.bson.p022io.BsonOutput;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/CompressedMessage.class */
class CompressedMessage extends RequestMessage {
    private final OpCode wrappedOpcode;
    private final List<ByteBuf> wrappedMessageBuffers;
    private final Compressor compressor;

    /* access modifiers changed from: package-private */
    public CompressedMessage(OpCode wrappedOpcode, List<ByteBuf> wrappedMessageBuffers, Compressor compressor, MessageSettings settings) {
        super(OpCode.OP_COMPRESSED, getWrappedMessageRequestId(wrappedMessageBuffers), settings);
        this.wrappedOpcode = wrappedOpcode;
        this.wrappedMessageBuffers = wrappedMessageBuffers;
        this.compressor = compressor;
    }

    @Override // com.mongodb.internal.connection.RequestMessage
    protected RequestMessage.EncodingMetadata encodeMessageBodyWithMetadata(BsonOutput bsonOutput, SessionContext sessionContext) {
        bsonOutput.writeInt32(this.wrappedOpcode.getValue());
        bsonOutput.writeInt32(getWrappedMessageSize(this.wrappedMessageBuffers) - 16);
        bsonOutput.writeByte(this.compressor.getId());
        getFirstWrappedMessageBuffer(this.wrappedMessageBuffers).position(getFirstWrappedMessageBuffer(this.wrappedMessageBuffers).position() + 16);
        this.compressor.compress(this.wrappedMessageBuffers, bsonOutput);
        return new RequestMessage.EncodingMetadata(0);
    }

    private static int getWrappedMessageSize(List<ByteBuf> wrappedMessageBuffers) {
        return getFirstWrappedMessageBuffer(wrappedMessageBuffers).getInt(0);
    }

    private static int getWrappedMessageRequestId(List<ByteBuf> wrappedMessageBuffers) {
        return getFirstWrappedMessageBuffer(wrappedMessageBuffers).getInt(4);
    }

    private static ByteBuf getFirstWrappedMessageBuffer(List<ByteBuf> wrappedMessageBuffers) {
        return wrappedMessageBuffers.get(0);
    }
}
