package com.mongodb.internal.connection;

import com.mongodb.MongoInternalException;
import org.bson.ByteBuf;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/CompressedHeader.class */
public class CompressedHeader {
    public static final int COMPRESSED_HEADER_LENGTH = 9;
    public static final int TOTAL_COMPRESSED_HEADER_LENGTH = 25;
    private final int originalOpcode;
    private final int uncompressedSize;
    private final byte compressorId;
    private final MessageHeader messageHeader;

    /* access modifiers changed from: package-private */
    public CompressedHeader(ByteBuf header, MessageHeader messageHeader) {
        this.messageHeader = messageHeader;
        if (messageHeader.getOpCode() != OpCode.OP_COMPRESSED.getValue()) {
            throw new MongoInternalException(String.format("The reply message opCode %d does not match the expected opCode %d", Integer.valueOf(messageHeader.getOpCode()), Integer.valueOf(OpCode.OP_COMPRESSED.getValue())));
        } else if (messageHeader.getMessageLength() < 25) {
            throw new MongoInternalException(String.format("The reply message length %d is less than the mimimum message length %d", Integer.valueOf(messageHeader.getMessageLength()), 9));
        } else {
            this.originalOpcode = header.getInt();
            this.uncompressedSize = header.getInt();
            this.compressorId = header.get();
        }
    }

    public int getOriginalOpcode() {
        return this.originalOpcode;
    }

    public int getUncompressedSize() {
        return this.uncompressedSize;
    }

    public byte getCompressorId() {
        return this.compressorId;
    }

    public int getCompressedSize() {
        return (this.messageHeader.getMessageLength() - 9) - 16;
    }

    public MessageHeader getMessageHeader() {
        return this.messageHeader;
    }
}
