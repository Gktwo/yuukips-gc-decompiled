package kcp.highway.erasure;

import kcp.highway.erasure.fecNative.FecDecode;
import kcp.highway.erasure.fecNative.FecEncode;
import kcp.highway.erasure.fecNative.ReedSolomonNative;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* loaded from: grasscutter.jar:kcp/highway/erasure/FecAdapt.class */
public class FecAdapt {
    private static final InternalLogger log = InternalLoggerFactory.getInstance(FecAdapt.class);
    private ReedSolomonNative reedSolomonNative;
    private ReedSolomon reedSolomon;

    public FecAdapt(int dataShards, int parityShards) {
        if (ReedSolomonNative.isNativeSupport()) {
            this.reedSolomonNative = new ReedSolomonNative(dataShards, parityShards);
            log.info("fec use C native reedSolomon dataShards {} parityShards {}", Integer.valueOf(dataShards), Integer.valueOf(parityShards));
            return;
        }
        this.reedSolomon = ReedSolomon.create(dataShards, parityShards);
        log.info("fec use jvm reedSolomon dataShards {} parityShards {}", Integer.valueOf(dataShards), Integer.valueOf(parityShards));
    }

    public IFecEncode fecEncode(int headerOffset, int mtu) {
        IFecEncode iFecEncode;
        if (this.reedSolomonNative != null) {
            iFecEncode = new FecEncode(headerOffset, this.reedSolomonNative, mtu);
        } else {
            iFecEncode = new kcp.highway.erasure.fec.FecEncode(headerOffset, this.reedSolomon, mtu);
        }
        return iFecEncode;
    }

    public IFecDecode fecDecode(int mtu) {
        IFecDecode iFecDecode;
        if (this.reedSolomonNative != null) {
            iFecDecode = new FecDecode(3 * this.reedSolomonNative.getTotalShardCount(), this.reedSolomonNative, mtu);
        } else {
            iFecDecode = new kcp.highway.erasure.fec.FecDecode(3 * this.reedSolomon.getTotalShardCount(), this.reedSolomon, mtu);
        }
        return iFecDecode;
    }
}
