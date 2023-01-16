package org.eclipse.jetty.websocket.common.extensions.compress;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/compress/DeflateFrameExtension.class */
public class DeflateFrameExtension extends CompressExtension {
    @Override // org.eclipse.jetty.websocket.common.extensions.AbstractExtension, org.eclipse.jetty.websocket.api.extensions.Extension
    public String getName() {
        return "deflate-frame";
    }

    @Override // org.eclipse.jetty.websocket.common.extensions.compress.CompressExtension
    int getRsvUseMode() {
        return 0;
    }

    @Override // org.eclipse.jetty.websocket.common.extensions.compress.CompressExtension
    int getTailDropMode() {
        return 1;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:14:0x0050
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.eclipse.jetty.websocket.api.extensions.IncomingFrames
    public void incomingFrame(org.eclipse.jetty.websocket.api.extensions.Frame r5) {
        /*
            r4 = this;
            r0 = r5
            org.eclipse.jetty.websocket.api.extensions.Frame$Type r0 = r0.getType()
            boolean r0 = r0.isControl()
            if (r0 != 0) goto L_0x001e
            r0 = r5
            boolean r0 = r0.isRsv1()
            if (r0 == 0) goto L_0x001e
            r0 = r5
            boolean r0 = r0.hasPayload()
            if (r0 != 0) goto L_0x0024
        L_0x001e:
            r0 = r4
            r1 = r5
            r0.nextIncomingFrame(r1)
            return
        L_0x0024:
            r0 = r4
            org.eclipse.jetty.websocket.common.extensions.compress.ByteAccumulator r0 = r0.newByteAccumulator()     // Catch: DataFormatException -> 0x0069
            r6 = r0
            r0 = r4
            r1 = r6
            r2 = r5
            java.nio.ByteBuffer r2 = r2.getPayload()     // Catch: Throwable -> 0x0050, DataFormatException -> 0x0069
            r0.decompress(r1, r2)     // Catch: Throwable -> 0x0050, DataFormatException -> 0x0069
            r0 = r4
            r1 = r6
            java.nio.ByteBuffer r2 = org.eclipse.jetty.websocket.common.extensions.compress.DeflateFrameExtension.TAIL_BYTES_BUF     // Catch: Throwable -> 0x0050, DataFormatException -> 0x0069
            java.nio.ByteBuffer r2 = r2.slice()     // Catch: Throwable -> 0x0050, DataFormatException -> 0x0069
            r0.decompress(r1, r2)     // Catch: Throwable -> 0x0050, DataFormatException -> 0x0069
            r0 = r4
            r1 = r5
            r2 = r6
            r0.forwardIncoming(r1, r2)     // Catch: Throwable -> 0x0050, DataFormatException -> 0x0069
            r0 = r6
            if (r0 == 0) goto L_0x0066
            r0 = r6
            r0.close()     // Catch: DataFormatException -> 0x0069
            goto L_0x0066
        L_0x0050:
            r7 = move-exception
            r0 = r6
            if (r0 == 0) goto L_0x0064
            r0 = r6
            r0.close()     // Catch: Throwable -> 0x005c, DataFormatException -> 0x0069
            goto L_0x0064
        L_0x005c:
            r8 = move-exception
            r0 = r7
            r1 = r8
            r0.addSuppressed(r1)     // Catch: DataFormatException -> 0x0069
        L_0x0064:
            r0 = r7
            throw r0     // Catch: DataFormatException -> 0x0069
        L_0x0066:
            goto L_0x0073
        L_0x0069:
            r6 = move-exception
            org.eclipse.jetty.websocket.api.BadPayloadException r0 = new org.eclipse.jetty.websocket.api.BadPayloadException
            r1 = r0
            r2 = r6
            r1.<init>(r2)
            throw r0
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.websocket.common.extensions.compress.DeflateFrameExtension.incomingFrame(org.eclipse.jetty.websocket.api.extensions.Frame):void");
    }
}
