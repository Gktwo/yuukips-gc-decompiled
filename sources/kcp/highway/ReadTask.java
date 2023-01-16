package kcp.highway;

import java.util.Queue;
import kcp.highway.erasure.fec.Snmp;
import kcp.highway.internal.CodecOutputList;
import kcp.highway.threadPool.ITask;
import p013io.netty.buffer.ByteBuf;

/* loaded from: grasscutter.jar:kcp/highway/ReadTask.class */
public class ReadTask implements ITask {
    private final Ukcp ukcp;

    public ReadTask(Ukcp ukcp) {
        this.ukcp = ukcp;
    }

    /* JADX WARN: Type inference failed for: r0v39, types: [long] */
    /* JADX WARN: Type inference failed for: r0v50, types: [long] */
    @Override // kcp.highway.threadPool.ITask
    public void execute() {
        CodecOutputList<ByteBuf> bufList = null;
        Ukcp ukcp = this.ukcp;
        try {
            if (!ukcp.isActive()) {
                release();
                if (0 != 0) {
                    bufList.recycle();
                    return;
                }
                return;
            }
            long current = System.currentTimeMillis();
            Queue<ByteBuf> recieveList = ukcp.getReadBuffer();
            int readCount = 0;
            while (true) {
                ByteBuf byteBuf = recieveList.poll();
                if (byteBuf == null) {
                    break;
                }
                readCount++;
                ukcp.input(byteBuf, current);
                byteBuf.release();
            }
            if (readCount == 0) {
                release();
                if (0 != 0) {
                    bufList.recycle();
                    return;
                }
                return;
            }
            if (ukcp.isControlReadBufferSize()) {
                ukcp.getReadBufferIncr().addAndGet(readCount);
            }
            char c = 0;
            if (ukcp.isStream()) {
                int size = 0;
                while (ukcp.canRecv()) {
                    if (bufList == null) {
                        bufList = CodecOutputList.newInstance();
                    }
                    ukcp.receive(bufList);
                    size = bufList.size();
                }
                for (int i = 0; i < size; i++) {
                    ByteBuf byteBuf2 = bufList.getUnsafe(i);
                    c += (long) byteBuf2.readableBytes();
                    readBytebuf(byteBuf2, current, ukcp);
                }
            } else {
                while (ukcp.canRecv()) {
                    ByteBuf recvBuf = ukcp.mergeReceive();
                    c += (long) recvBuf.readableBytes();
                    readBytebuf(recvBuf, current, ukcp);
                }
            }
            Snmp.snmp.BytesReceived.add(c);
            if (!ukcp.getWriteBuffer().isEmpty() && ukcp.canSend(false)) {
                ukcp.notifyWriteEvent();
            }
            release();
            if (bufList != null) {
                bufList.recycle();
            }
        } catch (Throwable th) {
            release();
            if (bufList != null) {
                bufList.recycle();
            }
            throw th;
        }
    }

    private void readBytebuf(ByteBuf buf, long current, Ukcp ukcp) {
        ukcp.setLastRecieveTime(current);
        try {
            ukcp.getKcpListener().handleReceive(buf, ukcp);
            buf.release();
        } catch (Throwable th) {
            buf.release();
            throw th;
        }
    }

    public void release() {
        this.ukcp.getReadProcessing().set(false);
    }
}
