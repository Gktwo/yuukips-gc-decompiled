package p001ch.qos.logback.core.joran.action;

import org.xml.sax.Attributes;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;

/* renamed from: ch.qos.logback.core.joran.action.NOPAction */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/action/NOPAction.class */
public class NOPAction extends Action {
    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ec, String name, Attributes attributes) {
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ec, String name) {
    }
}
