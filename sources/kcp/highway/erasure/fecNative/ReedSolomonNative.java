package kcp.highway.erasure.fecNative;

/* loaded from: grasscutter.jar:kcp/highway/erasure/fecNative/ReedSolomonNative.class */
public class ReedSolomonNative {
    public static final ReedSolomonC REED_SOLOMON_C = new ReedSolomonC();
    private long reedSolomonPtr;
    private int dataShards;
    private int parityShards;

    public int getTotalShardCount() {
        return this.dataShards + this.parityShards;
    }

    public ReedSolomonNative(int dataShards, int parityShards) {
        this.reedSolomonPtr = REED_SOLOMON_C.rsNew(dataShards, parityShards);
        this.dataShards = dataShards;
        this.parityShards = parityShards;
    }

    public static boolean isNativeSupport() {
        return ReedSolomonC.isNativeSupport();
    }

    protected void rsRelease() {
        REED_SOLOMON_C.rsRelease(this.reedSolomonPtr);
    }

    /* access modifiers changed from: protected */
    public void rsEncode(long[] shards, int byteCount) {
        REED_SOLOMON_C.rsEncode(this.reedSolomonPtr, shards, byteCount);
    }

    /* access modifiers changed from: protected */
    public void rsReconstruct(long[] shards, boolean[] shardPresent, int byteCount) {
        REED_SOLOMON_C.rsReconstruct(this.reedSolomonPtr, shards, shardPresent, byteCount);
    }

    public int getDataShards() {
        return this.dataShards;
    }

    public void setDataShards(int dataShards) {
        this.dataShards = dataShards;
    }

    public int getParityShards() {
        return this.parityShards;
    }

    public void setParityShards(int parityShards) {
        this.parityShards = parityShards;
    }
}
