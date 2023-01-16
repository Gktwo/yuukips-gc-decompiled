package kcp.highway;

import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;

/* loaded from: grasscutter.jar:kcp/highway/IKcp.class */
public interface IKcp {
    void release();

    ByteBuf mergeRecv();

    int recv(List<ByteBuf> list);

    int peekSize();

    boolean canRecv();

    int send(ByteBuf byteBuf);

    int input(ByteBuf byteBuf, boolean z, long j);

    long currentMs(long j);

    long flush(boolean z, long j);

    void update(long j);

    long check(long j);

    boolean checkFlush();

    int setMtu(int i);

    int getInterval();

    int nodelay(boolean z, int i, int i2, boolean z2);

    int waitSnd();

    long getConv();

    void setConv(long j);

    Object getUser();

    void setUser(Object obj);

    int getState();

    void setState(int i);

    boolean isNodelay();

    void setNodelay(boolean z);

    void setFastresend(int i);

    void setRxMinrto(int i);

    void setRcvWnd(int i);

    void setAckMaskSize(int i);

    void setReserved(int i);

    int getSndWnd();

    void setSndWnd(int i);

    boolean isStream();

    void setStream(boolean z);

    void setByteBufAllocator(ByteBufAllocator byteBufAllocator);

    KcpOutput getOutput();

    void setOutput(KcpOutput kcpOutput);

    void setAckNoDelay(boolean z);

    int getSrtt();
}
