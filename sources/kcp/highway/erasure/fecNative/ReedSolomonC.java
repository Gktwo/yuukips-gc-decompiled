package kcp.highway.erasure.fecNative;

/* loaded from: grasscutter.jar:kcp/highway/erasure/fecNative/ReedSolomonC.class */
public class ReedSolomonC {
    private static boolean nativeSupport;

    protected static native void init();

    /* access modifiers changed from: protected */
    public native long rsNew(int i, int i2);

    /* access modifiers changed from: protected */
    public native void rsRelease(long j);

    /* access modifiers changed from: protected */
    public native void rsEncode(long j, long[] jArr, int i);

    /* access modifiers changed from: protected */
    public native void rsReconstruct(long j, long[] jArr, boolean[] zArr, int i);

    public static boolean isNativeSupport() {
        return nativeSupport;
    }
}
