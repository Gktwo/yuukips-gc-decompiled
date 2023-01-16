package p001ch.qos.logback.core.joran.action;

import org.xml.sax.Attributes;
import p001ch.qos.logback.core.joran.spi.ActionException;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;

/* renamed from: ch.qos.logback.core.joran.action.ContextPropertyAction */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/action/ContextPropertyAction.class */
public class ContextPropertyAction extends Action {
    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ec, String name, Attributes attributes) throws ActionException {
        addError("The [contextProperty] element has been removed. Please use [substitutionProperty] element instead");
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ec, String name) throws ActionException {
    }
}
