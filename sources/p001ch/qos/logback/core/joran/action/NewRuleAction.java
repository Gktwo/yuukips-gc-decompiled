package p001ch.qos.logback.core.joran.action;

import org.xml.sax.Attributes;
import p001ch.qos.logback.core.joran.spi.ElementSelector;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;
import p001ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.joran.action.NewRuleAction */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/action/NewRuleAction.class */
public class NewRuleAction extends Action {
    boolean inError = false;

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ec, String localName, Attributes attributes) {
        this.inError = false;
        String pattern = attributes.getValue("pattern");
        String actionClass = attributes.getValue("actionClass");
        if (OptionHelper.isEmpty(pattern)) {
            this.inError = true;
            addError("No 'pattern' attribute in <newRule>");
        } else if (OptionHelper.isEmpty(actionClass)) {
            this.inError = true;
            addError("No 'actionClass' attribute in <newRule>");
        } else {
            try {
                addInfo("About to add new Joran parsing rule [" + pattern + "," + actionClass + "].");
                ec.getJoranInterpreter().getRuleStore().addRule(new ElementSelector(pattern), actionClass);
            } catch (Exception e) {
                this.inError = true;
                addError("Could not add new Joran parsing rule [" + pattern + "," + actionClass + "]");
            }
        }
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ec, String n) {
    }

    public void finish(InterpretationContext ec) {
    }
}
