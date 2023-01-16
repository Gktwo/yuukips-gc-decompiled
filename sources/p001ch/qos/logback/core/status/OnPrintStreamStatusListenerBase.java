package p001ch.qos.logback.core.status;

import java.io.PrintStream;
import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.spi.LifeCycle;
import p001ch.qos.logback.core.util.StatusPrinter;

/* renamed from: ch.qos.logback.core.status.OnPrintStreamStatusListenerBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/status/OnPrintStreamStatusListenerBase.class */
public abstract class OnPrintStreamStatusListenerBase extends ContextAwareBase implements StatusListener, LifeCycle {
    static final long DEFAULT_RETROSPECTIVE = 300;
    String prefix;
    boolean isStarted = false;
    long retrospectiveThresold = DEFAULT_RETROSPECTIVE;

    protected abstract PrintStream getPrintStream();

    private void print(Status status) {
        StringBuilder sb = new StringBuilder();
        if (this.prefix != null) {
            sb.append(this.prefix);
        }
        StatusPrinter.buildStr(sb, "", status);
        getPrintStream().print(sb);
    }

    @Override // p001ch.qos.logback.core.status.StatusListener
    public void addStatusEvent(Status status) {
        if (this.isStarted) {
            print(status);
        }
    }

    private void retrospectivePrint() {
        if (this.context != null) {
            long now = System.currentTimeMillis();
            for (Status status : this.context.getStatusManager().getCopyOfStatusList()) {
                if (isElapsedTimeLongerThanThreshold(now, status.getDate().longValue())) {
                    print(status);
                }
            }
        }
    }

    private boolean isElapsedTimeLongerThanThreshold(long now, long timestamp) {
        return now - timestamp < this.retrospectiveThresold;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.isStarted = true;
        if (this.retrospectiveThresold > 0) {
            retrospectivePrint();
        }
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setRetrospective(long retrospective) {
        this.retrospectiveThresold = retrospective;
    }

    public long getRetrospective() {
        return this.retrospectiveThresold;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.isStarted = false;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.isStarted;
    }
}
