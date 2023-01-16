package p001ch.qos.logback.core.spi;

/* renamed from: ch.qos.logback.core.spi.LifeCycle */
/* loaded from: grasscutter.jar:ch/qos/logback/core/spi/LifeCycle.class */
public interface LifeCycle {
    void start();

    void stop();

    boolean isStarted();
}
