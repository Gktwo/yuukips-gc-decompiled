package p001ch.qos.logback.classic.turbo;

import org.slf4j.Marker;
import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.Logger;
import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.spi.FilterReply;
import p001ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.classic.turbo.TurboFilter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/turbo/TurboFilter.class */
public abstract class TurboFilter extends ContextAwareBase implements LifeCycle {
    private String name;
    boolean start = false;

    public abstract FilterReply decide(Marker marker, Logger logger, Level level, String str, Object[] objArr, Throwable th);

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.start = true;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.start;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.start = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
