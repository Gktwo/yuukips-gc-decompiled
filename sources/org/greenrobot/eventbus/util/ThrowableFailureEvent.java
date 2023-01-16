package org.greenrobot.eventbus.util;

/* loaded from: grasscutter.jar:org/greenrobot/eventbus/util/ThrowableFailureEvent.class */
public class ThrowableFailureEvent implements HasExecutionScope {
    protected final Throwable throwable;
    protected final boolean suppressErrorUi;
    private Object executionContext;

    public ThrowableFailureEvent(Throwable throwable) {
        this.throwable = throwable;
        this.suppressErrorUi = false;
    }

    public ThrowableFailureEvent(Throwable throwable, boolean suppressErrorUi) {
        this.throwable = throwable;
        this.suppressErrorUi = suppressErrorUi;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public boolean isSuppressErrorUi() {
        return this.suppressErrorUi;
    }

    @Override // org.greenrobot.eventbus.util.HasExecutionScope
    public Object getExecutionScope() {
        return this.executionContext;
    }

    @Override // org.greenrobot.eventbus.util.HasExecutionScope
    public void setExecutionScope(Object executionContext) {
        this.executionContext = executionContext;
    }
}
