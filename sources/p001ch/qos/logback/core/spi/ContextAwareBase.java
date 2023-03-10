package p001ch.qos.logback.core.spi;

import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.status.ErrorStatus;
import p001ch.qos.logback.core.status.InfoStatus;
import p001ch.qos.logback.core.status.Status;
import p001ch.qos.logback.core.status.StatusManager;
import p001ch.qos.logback.core.status.WarnStatus;

/* renamed from: ch.qos.logback.core.spi.ContextAwareBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/spi/ContextAwareBase.class */
public class ContextAwareBase implements ContextAware {
    private int noContextWarning;
    protected Context context;
    final Object declaredOrigin;

    public ContextAwareBase() {
        this.noContextWarning = 0;
        this.declaredOrigin = this;
    }

    public ContextAwareBase(ContextAware declaredOrigin) {
        this.noContextWarning = 0;
        this.declaredOrigin = declaredOrigin;
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public void setContext(Context context) {
        if (this.context == null) {
            this.context = context;
        } else if (this.context != context) {
            throw new IllegalStateException("Context has been already set");
        }
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public Context getContext() {
        return this.context;
    }

    public StatusManager getStatusManager() {
        if (this.context == null) {
            return null;
        }
        return this.context.getStatusManager();
    }

    protected Object getDeclaredOrigin() {
        return this.declaredOrigin;
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public void addStatus(Status status) {
        if (this.context == null) {
            int i = this.noContextWarning;
            this.noContextWarning = i + 1;
            if (i == 0) {
                System.out.println("LOGBACK: No context given for " + this);
                return;
            }
            return;
        }
        StatusManager sm = this.context.getStatusManager();
        if (sm != null) {
            sm.add(status);
        }
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public void addInfo(String msg) {
        addStatus(new InfoStatus(msg, getDeclaredOrigin()));
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public void addInfo(String msg, Throwable ex) {
        addStatus(new InfoStatus(msg, getDeclaredOrigin(), ex));
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public void addWarn(String msg) {
        addStatus(new WarnStatus(msg, getDeclaredOrigin()));
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public void addWarn(String msg, Throwable ex) {
        addStatus(new WarnStatus(msg, getDeclaredOrigin(), ex));
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public void addError(String msg) {
        addStatus(new ErrorStatus(msg, getDeclaredOrigin()));
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public void addError(String msg, Throwable ex) {
        addStatus(new ErrorStatus(msg, getDeclaredOrigin(), ex));
    }
}
