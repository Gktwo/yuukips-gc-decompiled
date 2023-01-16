package com.mongodb.internal.connection;

import com.mongodb.MongoInternalException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ReplyMessage.class */
public class ReplyMessage<T> {
    private final ReplyHeader replyHeader;
    private final List<T> documents;

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0063
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public ReplyMessage(com.mongodb.internal.connection.ResponseBuffers r6, org.bson.codecs.Decoder<T> r7, long r8) {
        /*
            r5 = this;
            r0 = r5
            r1 = r6
            com.mongodb.internal.connection.ReplyHeader r1 = r1.getReplyHeader()
            r2 = r8
            r0.<init>(r1, r2)
            r0 = r5
            com.mongodb.internal.connection.ReplyHeader r0 = r0.replyHeader
            int r0 = r0.getNumberReturned()
            if (r0 <= 0) goto L_0x008e
            org.bson.io.ByteBufferBsonInput r0 = new org.bson.io.ByteBufferBsonInput
            r1 = r0
            r2 = r6
            org.bson.ByteBuf r2 = r2.getBodyByteBuffer()
            org.bson.ByteBuf r2 = r2.duplicate()
            r1.<init>(r2)
            r10 = r0
        L_0x0025:
            r0 = r5
            java.util.List<T> r0 = r0.documents     // Catch: all -> 0x007e
            int r0 = r0.size()     // Catch: all -> 0x007e
            r1 = r5
            com.mongodb.internal.connection.ReplyHeader r1 = r1.replyHeader     // Catch: all -> 0x007e
            int r1 = r1.getNumberReturned()     // Catch: all -> 0x007e
            if (r0 >= r1) goto L_0x0070
            org.bson.BsonBinaryReader r0 = new org.bson.BsonBinaryReader     // Catch: all -> 0x007e
            r1 = r0
            r2 = r10
            r1.<init>(r2)     // Catch: all -> 0x007e
            r11 = r0
            r0 = r5
            java.util.List<T> r0 = r0.documents     // Catch: all -> 0x0063, all -> 0x007e
            r1 = r7
            r2 = r11
            org.bson.codecs.DecoderContext$Builder r3 = org.bson.codecs.DecoderContext.builder()     // Catch: all -> 0x0063, all -> 0x007e
            org.bson.codecs.DecoderContext r3 = r3.build()     // Catch: all -> 0x0063, all -> 0x007e
            java.lang.Object r1 = r1.decode(r2, r3)     // Catch: all -> 0x0063, all -> 0x007e
            boolean r0 = r0.add(r1)     // Catch: all -> 0x0063, all -> 0x007e
            r0 = r11
            r0.close()     // Catch: all -> 0x007e
            goto L_0x006d
        L_0x0063:
            r12 = move-exception
            r0 = r11
            r0.close()     // Catch: all -> 0x007e
            r0 = r12
            throw r0     // Catch: all -> 0x007e
        L_0x006d:
            goto L_0x0025
        L_0x0070:
            r0 = r10
            r0.close()
            r0 = r6
            r0.reset()
            goto L_0x008e
        L_0x007e:
            r13 = move-exception
            r0 = r10
            r0.close()
            r0 = r6
            r0.reset()
            r0 = r13
            throw r0
        L_0x008e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.ReplyMessage.<init>(com.mongodb.internal.connection.ResponseBuffers, org.bson.codecs.Decoder, long):void");
    }

    ReplyMessage(ReplyHeader replyHeader, long requestId) {
        if (requestId != ((long) replyHeader.getResponseTo())) {
            throw new MongoInternalException(String.format("The responseTo (%d) in the response does not match the requestId (%d) in the request", Integer.valueOf(replyHeader.getResponseTo()), Long.valueOf(requestId)));
        }
        this.replyHeader = replyHeader;
        this.documents = new ArrayList(replyHeader.getNumberReturned());
    }

    public ReplyHeader getReplyHeader() {
        return this.replyHeader;
    }

    public List<T> getDocuments() {
        return this.documents;
    }
}
