package p001ch.qos.logback.classic.joran.action;

import org.xml.sax.Attributes;
import p001ch.qos.logback.classic.net.ReceiverBase;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.spi.ActionException;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;
import p001ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.classic.joran.action.ReceiverAction */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/joran/action/ReceiverAction.class */
public class ReceiverAction extends Action {
    private ReceiverBase receiver;
    private boolean inError;

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ic, String name, Attributes attributes) throws ActionException {
        String className = attributes.getValue("class");
        if (OptionHelper.isEmpty(className)) {
            addError("Missing class name for receiver. Near [" + name + "] line " + getLineNumber(ic));
            this.inError = true;
            return;
        }
        try {
            addInfo("About to instantiate receiver of type [" + className + "]");
            this.receiver = (ReceiverBase) OptionHelper.instantiateByClassName(className, ReceiverBase.class, this.context);
            this.receiver.setContext(this.context);
            ic.pushObject(this.receiver);
        } catch (Exception ex) {
            this.inError = true;
            addError("Could not create a receiver of type [" + className + "].", ex);
            throw new ActionException(ex);
        }
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ic, String name) throws ActionException {
        if (!this.inError) {
            ic.getContext().register(this.receiver);
            this.receiver.start();
            if (ic.peekObject() != this.receiver) {
                addWarn("The object at the of the stack is not the remote pushed earlier.");
            } else {
                ic.popObject();
            }
        }
    }
}
