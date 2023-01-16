package p001ch.qos.logback.core.joran.action;

import java.util.HashMap;
import org.xml.sax.Attributes;
import p001ch.qos.logback.core.Appender;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;
import p001ch.qos.logback.core.spi.AppenderAttachable;
import p001ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.joran.action.AppenderRefAction */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/action/AppenderRefAction.class */
public class AppenderRefAction<E> extends Action {
    boolean inError = false;

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ec, String tagName, Attributes attributes) {
        this.inError = false;
        Object o = ec.peekObject();
        if (!(o instanceof AppenderAttachable)) {
            this.inError = true;
            addError("Could not find an AppenderAttachable at the top of execution stack. Near [" + tagName + "] line " + getLineNumber(ec));
            return;
        }
        AppenderAttachable<E> appenderAttachable = (AppenderAttachable) o;
        String appenderName = ec.subst(attributes.getValue(ActionConst.REF_ATTRIBUTE));
        if (OptionHelper.isEmpty(appenderName)) {
            this.inError = true;
            addError("Missing appender ref attribute in <appender-ref> tag.");
            return;
        }
        Appender<E> appender = ((HashMap) ec.getObjectMap().get(ActionConst.APPENDER_BAG)).get(appenderName);
        if (appender == null) {
            this.inError = true;
            addError("Could not find an appender named [" + appenderName + "]. Did you define it below instead of above in the configuration file?");
            addError("See http://logback.qos.ch/codes.html#appender_order for more details.");
            return;
        }
        addInfo("Attaching appender named [" + appenderName + "] to " + appenderAttachable);
        appenderAttachable.addAppender(appender);
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ec, String n) {
    }
}
