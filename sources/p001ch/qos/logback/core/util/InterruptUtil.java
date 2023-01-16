package p001ch.qos.logback.core.util;

import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.util.InterruptUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/util/InterruptUtil.class */
public class InterruptUtil extends ContextAwareBase {
    final boolean previouslyInterrupted = Thread.currentThread().isInterrupted();

    public InterruptUtil(Context context) {
        setContext(context);
    }

    public void maskInterruptFlag() {
        if (this.previouslyInterrupted) {
            Thread.interrupted();
        }
    }

    public void unmaskInterruptFlag() {
        if (this.previouslyInterrupted) {
            try {
                Thread.currentThread().interrupt();
            } catch (SecurityException se) {
                addError("Failed to intrreupt current thread", se);
            }
        }
    }
}
