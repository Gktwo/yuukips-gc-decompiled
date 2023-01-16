package p001ch.qos.logback.core.pattern;

import java.util.List;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.spi.ContextAware;
import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.spi.LifeCycle;
import p001ch.qos.logback.core.status.Status;

/* renamed from: ch.qos.logback.core.pattern.DynamicConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/DynamicConverter.class */
public abstract class DynamicConverter<E> extends FormattingConverter<E> implements LifeCycle, ContextAware {
    private List<String> optionList;
    ContextAwareBase cab = new ContextAwareBase(this);
    protected boolean started = false;

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.started = true;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.started = false;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.started;
    }

    public void setOptionList(List<String> optionList) {
        this.optionList = optionList;
    }

    public String getFirstOption() {
        if (this.optionList == null || this.optionList.size() == 0) {
            return null;
        }
        return this.optionList.get(0);
    }

    protected List<String> getOptionList() {
        return this.optionList;
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public void setContext(Context context) {
        this.cab.setContext(context);
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public Context getContext() {
        return this.cab.getContext();
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public void addStatus(Status status) {
        this.cab.addStatus(status);
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public void addInfo(String msg) {
        this.cab.addInfo(msg);
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public void addInfo(String msg, Throwable ex) {
        this.cab.addInfo(msg, ex);
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public void addWarn(String msg) {
        this.cab.addWarn(msg);
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public void addWarn(String msg, Throwable ex) {
        this.cab.addWarn(msg, ex);
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public void addError(String msg) {
        this.cab.addError(msg);
    }

    @Override // p001ch.qos.logback.core.spi.ContextAware
    public void addError(String msg, Throwable ex) {
        this.cab.addError(msg, ex);
    }
}
