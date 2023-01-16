package kcp.highway;

import kcp.highway.threadPool.ITask;

/* loaded from: grasscutter.jar:kcp/highway/WriteTask.class */
public class WriteTask implements ITask {
    private final Ukcp ukcp;

    public WriteTask(Ukcp ukcp) {
        this.ukcp = ukcp;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:16:0x0053
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // kcp.highway.threadPool.ITask
    public void execute() {
        /*
            r6 = this;
            r0 = r6
            kcp.highway.Ukcp r0 = r0.ukcp
            r7 = r0
            r0 = r7
            boolean r0 = r0.isActive()     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            if (r0 != 0) goto L_0x0011
            r0 = r6
            r0.release()
            return
        L_0x0011:
            r0 = r7
            java.util.Queue r0 = r0.getWriteBuffer()     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            r8 = r0
            r0 = 0
            r9 = r0
            r0 = 0
            r10 = r0
        L_0x001b:
            r0 = r7
            r1 = 0
            boolean r0 = r0.canSend(r1)     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            if (r0 == 0) goto L_0x0069
            r0 = r8
            java.lang.Object r0 = r0.poll()     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            io.netty.buffer.ByteBuf r0 = (p013io.netty.buffer.ByteBuf) r0     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            r12 = r0
            r0 = r12
            if (r0 != 0) goto L_0x0036
            goto L_0x0069
        L_0x0036:
            int r9 = r9 + 1
            r0 = r10
            r1 = r12
            int r1 = r1.readableBytes()     // Catch: Throwable -> 0x00b8, all -> 0x00c4, IOException -> 0x0053
            long r1 = (long) r1     // Catch: Throwable -> 0x00b8, all -> 0x00c4, IOException -> 0x0053
            long r0 = r0 + r1
            r10 = r0
            r0 = r7
            r1 = r12
            r0.send(r1)     // Catch: Throwable -> 0x00b8, all -> 0x00c4, IOException -> 0x0053
            r0 = r12
            boolean r0 = r0.release()     // Catch: Throwable -> 0x00b8, all -> 0x00c4, IOException -> 0x0053
            goto L_0x0066
        L_0x0053:
            r13 = move-exception
            r0 = r7
            kcp.highway.KcpListener r0 = r0.getKcpListener()     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            r1 = r13
            r2 = r7
            r0.handleException(r1, r2)     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            r0 = r6
            r0.release()
            return
        L_0x0066:
            goto L_0x001b
        L_0x0069:
            kcp.highway.erasure.fec.Snmp r0 = kcp.highway.erasure.fec.Snmp.snmp     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            java.util.concurrent.atomic.LongAdder r0 = r0.BytesSent     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            r1 = r10
            r0.add(r1)     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            r0 = r7
            boolean r0 = r0.isControlWriteBufferSize()     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            if (r0 == 0) goto L_0x0084
            r0 = r7
            java.util.concurrent.atomic.AtomicInteger r0 = r0.getWriteBufferIncr()     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            r1 = r9
            int r0 = r0.addAndGet(r1)     // Catch: Throwable -> 0x00b8, all -> 0x00c4
        L_0x0084:
            r0 = r7
            r1 = 0
            boolean r0 = r0.canSend(r1)     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            if (r0 == 0) goto L_0x009a
            r0 = r7
            boolean r0 = r0.checkFlush()     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            if (r0 == 0) goto L_0x00b1
            r0 = r7
            boolean r0 = r0.isFastFlush()     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            if (r0 == 0) goto L_0x00b1
        L_0x009a:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            r12 = r0
            r0 = r7
            r1 = r12
            long r0 = r0.flush(r1)     // Catch: Throwable -> 0x00b8, all -> 0x00c4
            r14 = r0
            r0 = r7
            r1 = r12
            r2 = r14
            long r1 = r1 + r2
            kcp.highway.Ukcp r0 = r0.setTsUpdate(r1)     // Catch: Throwable -> 0x00b8, all -> 0x00c4
        L_0x00b1:
            r0 = r6
            r0.release()
            goto L_0x00cd
        L_0x00b8:
            r8 = move-exception
            r0 = r8
            r0.printStackTrace()     // Catch: all -> 0x00c4
            r0 = r6
            r0.release()
            goto L_0x00cd
        L_0x00c4:
            r16 = move-exception
            r0 = r6
            r0.release()
            r0 = r16
            throw r0
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.WriteTask.execute():void");
    }

    public void release() {
        this.ukcp.getWriteProcessing().set(false);
    }
}
