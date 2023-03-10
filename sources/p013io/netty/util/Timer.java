package p013io.netty.util;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: io.netty.util.Timer */
/* loaded from: grasscutter.jar:io/netty/util/Timer.class */
public interface Timer {
    Timeout newTimeout(TimerTask timerTask, long j, TimeUnit timeUnit);

    Set<Timeout> stop();
}
