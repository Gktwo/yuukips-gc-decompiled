package p001ch.qos.logback.core.joran.conditional;

import java.util.List;
import java.util.Stack;
import org.xml.sax.Attributes;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.event.SaxEvent;
import p001ch.qos.logback.core.joran.spi.ActionException;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;

/* renamed from: ch.qos.logback.core.joran.conditional.ThenOrElseActionBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/conditional/ThenOrElseActionBase.class */
public abstract class ThenOrElseActionBase extends Action {
    Stack<ThenActionState> stateStack = new Stack<>();

    abstract void registerEventList(IfAction ifAction, List<SaxEvent> list);

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ic, String name, Attributes attributes) throws ActionException {
        if (weAreActive(ic)) {
            ThenActionState state = new ThenActionState();
            if (ic.isListenerListEmpty()) {
                ic.addInPlayListener(state);
                state.isRegistered = true;
            }
            this.stateStack.push(state);
        }
    }

    boolean weAreActive(InterpretationContext ic) {
        Object o = ic.peekObject();
        if (!(o instanceof IfAction)) {
            return false;
        }
        return ((IfAction) o).isActive();
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ic, String name) throws ActionException {
        if (weAreActive(ic)) {
            ThenActionState state = this.stateStack.pop();
            if (state.isRegistered) {
                ic.removeInPlayListener(state);
                Object o = ic.peekObject();
                if (o instanceof IfAction) {
                    removeFirstAndLastFromList(state.eventList);
                    registerEventList((IfAction) o, state.eventList);
                    return;
                }
                throw new IllegalStateException("Missing IfAction on top of stack");
            }
        }
    }

    void removeFirstAndLastFromList(List<SaxEvent> eventList) {
        eventList.remove(0);
        eventList.remove(eventList.size() - 1);
    }
}
