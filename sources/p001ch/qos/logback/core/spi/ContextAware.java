package p001ch.qos.logback.core.spi;

import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.status.Status;

/* renamed from: ch.qos.logback.core.spi.ContextAware */
/* loaded from: grasscutter.jar:ch/qos/logback/core/spi/ContextAware.class */
public interface ContextAware {
    void setContext(Context context);

    Context getContext();

    void addStatus(Status status);

    void addInfo(String str);

    void addInfo(String str, Throwable th);

    void addWarn(String str);

    void addWarn(String str, Throwable th);

    void addError(String str);

    void addError(String str, Throwable th);
}
