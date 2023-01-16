package p013io.netty.channel;

import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.WriteBufferWaterMark */
/* loaded from: grasscutter.jar:io/netty/channel/WriteBufferWaterMark.class */
public final class WriteBufferWaterMark {
    private static final int DEFAULT_LOW_WATER_MARK = 32768;
    private static final int DEFAULT_HIGH_WATER_MARK = 65536;
    public static final WriteBufferWaterMark DEFAULT = new WriteBufferWaterMark(32768, 65536, false);
    private final int low;
    private final int high;

    public WriteBufferWaterMark(int low, int high) {
        this(low, high, true);
    }

    /* access modifiers changed from: package-private */
    public WriteBufferWaterMark(int low, int high, boolean validate) {
        if (validate) {
            ObjectUtil.checkPositiveOrZero(low, "low");
            if (high < low) {
                throw new IllegalArgumentException("write buffer's high water mark cannot be less than  low water mark (" + low + "): " + high);
            }
        }
        this.low = low;
        this.high = high;
    }

    public int low() {
        return this.low;
    }

    public int high() {
        return this.high;
    }

    public String toString() {
        return new StringBuilder(55).append("WriteBufferWaterMark(low: ").append(this.low).append(", high: ").append(this.high).append(")").toString();
    }
}
