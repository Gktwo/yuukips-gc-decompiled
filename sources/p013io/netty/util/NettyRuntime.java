package p013io.netty.util;

import java.util.Locale;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.SystemPropertyUtil;

/* renamed from: io.netty.util.NettyRuntime */
/* loaded from: grasscutter.jar:io/netty/util/NettyRuntime.class */
public final class NettyRuntime {
    private static final AvailableProcessorsHolder holder = new AvailableProcessorsHolder();

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.util.NettyRuntime$AvailableProcessorsHolder */
    /* loaded from: grasscutter.jar:io/netty/util/NettyRuntime$AvailableProcessorsHolder.class */
    public static class AvailableProcessorsHolder {
        private int availableProcessors;

        AvailableProcessorsHolder() {
        }

        synchronized void setAvailableProcessors(int availableProcessors) {
            ObjectUtil.checkPositive(availableProcessors, "availableProcessors");
            if (this.availableProcessors != 0) {
                throw new IllegalStateException(String.format(Locale.ROOT, "availableProcessors is already set to [%d], rejecting [%d]", Integer.valueOf(this.availableProcessors), Integer.valueOf(availableProcessors)));
            }
            this.availableProcessors = availableProcessors;
        }

        @SuppressForbidden(reason = "to obtain default number of available processors")
        synchronized int availableProcessors() {
            if (this.availableProcessors == 0) {
                setAvailableProcessors(SystemPropertyUtil.getInt("io.netty.availableProcessors", Runtime.getRuntime().availableProcessors()));
            }
            return this.availableProcessors;
        }
    }

    public static void setAvailableProcessors(int availableProcessors) {
        holder.setAvailableProcessors(availableProcessors);
    }

    public static int availableProcessors() {
        return holder.availableProcessors();
    }

    private NettyRuntime() {
    }
}
