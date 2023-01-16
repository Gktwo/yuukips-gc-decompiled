package kcp.highway;

import p013io.netty.buffer.ByteBuf;

/* loaded from: grasscutter.jar:kcp/highway/KcpListener.class */
public interface KcpListener {
    void onConnected(Ukcp ukcp);

    void handleReceive(ByteBuf byteBuf, Ukcp ukcp);

    void handleException(Throwable th, Ukcp ukcp);

    void handleClose(Ukcp ukcp);
}
