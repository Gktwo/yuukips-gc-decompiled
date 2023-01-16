package p001ch.qos.logback.core.joran.action;

import org.xml.sax.Attributes;
import p001ch.qos.logback.core.joran.spi.ElementPath;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;

/* renamed from: ch.qos.logback.core.joran.action.ImplicitAction */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/action/ImplicitAction.class */
public abstract class ImplicitAction extends Action {
    public abstract boolean isApplicable(ElementPath elementPath, Attributes attributes, InterpretationContext interpretationContext);
}
