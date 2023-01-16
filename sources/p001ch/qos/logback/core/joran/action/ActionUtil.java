package p001ch.qos.logback.core.joran.action;

import java.util.Properties;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;
import p001ch.qos.logback.core.util.ContextUtil;
import p001ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.joran.action.ActionUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/action/ActionUtil.class */
public class ActionUtil {

    /* renamed from: ch.qos.logback.core.joran.action.ActionUtil$Scope */
    /* loaded from: grasscutter.jar:ch/qos/logback/core/joran/action/ActionUtil$Scope.class */
    public enum Scope {
        LOCAL,
        CONTEXT,
        SYSTEM
    }

    public static Scope stringToScope(String scopeStr) {
        if (Scope.SYSTEM.toString().equalsIgnoreCase(scopeStr)) {
            return Scope.SYSTEM;
        }
        if (Scope.CONTEXT.toString().equalsIgnoreCase(scopeStr)) {
            return Scope.CONTEXT;
        }
        return Scope.LOCAL;
    }

    public static void setProperty(InterpretationContext ic, String key, String value, Scope scope) {
        switch (scope) {
            case LOCAL:
                ic.addSubstitutionProperty(key, value);
                return;
            case CONTEXT:
                ic.getContext().putProperty(key, value);
                return;
            case SYSTEM:
                OptionHelper.setSystemProperty(ic, key, value);
                return;
            default:
                return;
        }
    }

    public static void setProperties(InterpretationContext ic, Properties props, Scope scope) {
        switch (scope) {
            case LOCAL:
                ic.addSubstitutionProperties(props);
                return;
            case CONTEXT:
                new ContextUtil(ic.getContext()).addProperties(props);
                return;
            case SYSTEM:
                OptionHelper.setSystemProperties(ic, props);
                return;
            default:
                return;
        }
    }
}
