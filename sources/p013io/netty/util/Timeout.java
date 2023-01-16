package p013io.netty.util;

/* renamed from: io.netty.util.Timeout */
/* loaded from: grasscutter.jar:io/netty/util/Timeout.class */
public interface Timeout {
    Timer timer();

    TimerTask task();

    boolean isExpired();

    boolean isCancelled();

    boolean cancel();
}
