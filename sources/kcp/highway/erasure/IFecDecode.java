package kcp.highway.erasure;

import java.util.List;
import kcp.highway.erasure.fec.FecPacket;
import p013io.netty.buffer.ByteBuf;

/* loaded from: grasscutter.jar:kcp/highway/erasure/IFecDecode.class */
public interface IFecDecode {
    List<ByteBuf> decode(FecPacket fecPacket);

    void release();
}
