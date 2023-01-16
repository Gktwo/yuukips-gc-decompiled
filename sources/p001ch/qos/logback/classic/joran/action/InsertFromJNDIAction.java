package p001ch.qos.logback.classic.joran.action;

import javax.naming.NamingException;
import org.xml.sax.Attributes;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.action.ActionUtil;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;
import p001ch.qos.logback.core.util.JNDIUtil;
import p001ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.classic.joran.action.InsertFromJNDIAction */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/joran/action/InsertFromJNDIAction.class */
public class InsertFromJNDIAction extends Action {
    public static final String ENV_ENTRY_NAME_ATTR = "env-entry-name";
    public static final String AS_ATTR = "as";

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ec, String name, Attributes attributes) {
        int errorCount = 0;
        String envEntryName = ec.subst(attributes.getValue(ENV_ENTRY_NAME_ATTR));
        String asKey = ec.subst(attributes.getValue(AS_ATTR));
        ActionUtil.Scope scope = ActionUtil.stringToScope(attributes.getValue(Action.SCOPE_ATTRIBUTE));
        if (OptionHelper.isEmpty(envEntryName)) {
            addError("[env-entry-name] missing, around " + getLineColStr(ec));
            errorCount = 0 + 1;
        }
        if (OptionHelper.isEmpty(asKey)) {
            addError("[as] missing, around " + getLineColStr(ec));
            errorCount++;
        }
        if (errorCount == 0) {
            try {
                String envEntryValue = JNDIUtil.lookupString(JNDIUtil.getInitialContext(), envEntryName);
                if (OptionHelper.isEmpty(envEntryValue)) {
                    addError("[" + envEntryName + "] has null or empty value");
                } else {
                    addInfo("Setting variable [" + asKey + "] to [" + envEntryValue + "] in [" + scope + "] scope");
                    ActionUtil.setProperty(ec, asKey, envEntryValue, scope);
                }
            } catch (NamingException e) {
                addError("Failed to lookup JNDI env-entry [" + envEntryName + "]", e);
            }
        }
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ec, String name) {
    }
}
