package p001ch.qos.logback.classic;

import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.AsyncAppenderBase;

/* renamed from: ch.qos.logback.classic.AsyncAppender */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/AsyncAppender.class */
public class AsyncAppender extends AsyncAppenderBase<ILoggingEvent> {
    boolean includeCallerData = false;

    /* access modifiers changed from: protected */
    public boolean isDiscardable(ILoggingEvent event) {
        return event.getLevel().toInt() <= 20000;
    }

    /* access modifiers changed from: protected */
    public void preprocess(ILoggingEvent eventObject) {
        eventObject.prepareForDeferredProcessing();
        if (this.includeCallerData) {
            eventObject.getCallerData();
        }
    }

    public boolean isIncludeCallerData() {
        return this.includeCallerData;
    }

    public void setIncludeCallerData(boolean includeCallerData) {
        this.includeCallerData = includeCallerData;
    }
}
