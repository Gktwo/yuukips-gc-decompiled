package p001ch.qos.logback.core.hook;

import p001ch.qos.logback.core.util.Duration;

/* renamed from: ch.qos.logback.core.hook.DelayingShutdownHook */
/* loaded from: grasscutter.jar:ch/qos/logback/core/hook/DelayingShutdownHook.class */
public class DelayingShutdownHook extends ShutdownHookBase {
    public static final Duration DEFAULT_DELAY = Duration.buildByMilliseconds(0.0d);
    private Duration delay = DEFAULT_DELAY;

    public Duration getDelay() {
        return this.delay;
    }

    public void setDelay(Duration delay) {
        this.delay = delay;
    }

    @Override // java.lang.Runnable
    public void run() {
        addInfo("Sleeping for " + this.delay);
        try {
            Thread.sleep(this.delay.getMilliseconds());
        } catch (InterruptedException e) {
        }
        stop();
    }
}
