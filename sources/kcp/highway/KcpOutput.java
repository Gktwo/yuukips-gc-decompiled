package kcp.highway;

import p013io.netty.buffer.ByteBuf;

/* loaded from: grasscutter.jar:kcp/highway/KcpOutput.class */
public interface KcpOutput {
    void out(ByteBuf byteBuf, IKcp iKcp);
}
