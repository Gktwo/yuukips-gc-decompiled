package kcp.highway;

import kcp.highway.erasure.IFecEncode;
import p013io.netty.buffer.ByteBuf;

/* loaded from: grasscutter.jar:kcp/highway/FecOutPut.class */
public class FecOutPut implements KcpOutput {
    private KcpOutput output;
    private IFecEncode fecEncode;

    /* access modifiers changed from: protected */
    public FecOutPut(KcpOutput output, IFecEncode fecEncode) {
        this.output = output;
        this.fecEncode = fecEncode;
    }

    @Override // kcp.highway.KcpOutput
    public void out(ByteBuf msg, IKcp kcp2) {
        ByteBuf[] byteBufs = this.fecEncode.encode(msg);
        this.output.out(msg, kcp2);
        if (byteBufs != null) {
            for (ByteBuf parityByteBuf : byteBufs) {
                this.output.out(parityByteBuf, kcp2);
            }
        }
    }
}
