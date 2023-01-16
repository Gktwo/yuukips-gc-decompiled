package p001ch.qos.logback.core.hook;

import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.ContextBase;
import p001ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.hook.ShutdownHookBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/hook/ShutdownHookBase.class */
public abstract class ShutdownHookBase extends ContextAwareBase implements ShutdownHook {
    /* access modifiers changed from: protected */
    public void stop() {
        addInfo("Logback context being closed via shutdown hook");
        Context hookContext = getContext();
        if (hookContext instanceof ContextBase) {
            ((ContextBase) hookContext).stop();
        }
    }
}
