package p001ch.qos.logback.core;

import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.spi.PropertyDefiner;

/* renamed from: ch.qos.logback.core.PropertyDefinerBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/PropertyDefinerBase.class */
public abstract class PropertyDefinerBase extends ContextAwareBase implements PropertyDefiner {
    protected static String booleanAsStr(boolean bool) {
        return bool ? Boolean.TRUE.toString() : Boolean.FALSE.toString();
    }
}
