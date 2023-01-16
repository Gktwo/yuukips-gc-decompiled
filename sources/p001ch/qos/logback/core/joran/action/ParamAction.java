package p001ch.qos.logback.core.joran.action;

import org.xml.sax.Attributes;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;
import p001ch.qos.logback.core.joran.util.PropertySetter;
import p001ch.qos.logback.core.joran.util.beans.BeanDescriptionCache;

/* renamed from: ch.qos.logback.core.joran.action.ParamAction */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/action/ParamAction.class */
public class ParamAction extends Action {
    static String NO_NAME = "No name attribute in <param> element";
    static String NO_VALUE = "No value attribute in <param> element";
    boolean inError = false;
    private final BeanDescriptionCache beanDescriptionCache;

    public ParamAction(BeanDescriptionCache beanDescriptionCache) {
        this.beanDescriptionCache = beanDescriptionCache;
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ec, String localName, Attributes attributes) {
        String name = attributes.getValue("name");
        String value = attributes.getValue("value");
        if (name == null) {
            this.inError = true;
            addError(NO_NAME);
        } else if (value == null) {
            this.inError = true;
            addError(NO_VALUE);
        } else {
            String value2 = value.trim();
            PropertySetter propSetter = new PropertySetter(this.beanDescriptionCache, ec.peekObject());
            propSetter.setContext(this.context);
            propSetter.setProperty(ec.subst(name), ec.subst(value2));
        }
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ec, String localName) {
    }

    public void finish(InterpretationContext ec) {
    }
}
