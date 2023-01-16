package p001ch.qos.logback.classic.joran.action;

import org.xml.sax.Attributes;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;

/* renamed from: ch.qos.logback.classic.joran.action.ContextNameAction */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/joran/action/ContextNameAction.class */
public class ContextNameAction extends Action {
    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ec, String name, Attributes attributes) {
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void body(InterpretationContext ec, String body) {
        String finalBody = ec.subst(body);
        addInfo("Setting logger context name as [" + finalBody + "]");
        try {
            this.context.setName(finalBody);
        } catch (IllegalStateException e) {
            addError("Failed to rename context [" + this.context.getName() + "] as [" + finalBody + "]", e);
        }
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ec, String name) {
    }
}
