package p001ch.qos.logback.core.joran.action;

import java.util.Stack;
import org.xml.sax.Attributes;
import p001ch.qos.logback.core.joran.spi.ElementPath;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;
import p001ch.qos.logback.core.joran.util.PropertySetter;
import p001ch.qos.logback.core.joran.util.beans.BeanDescriptionCache;
import p001ch.qos.logback.core.util.AggregationType;

/* renamed from: ch.qos.logback.core.joran.action.NestedBasicPropertyIA */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/action/NestedBasicPropertyIA.class */
public class NestedBasicPropertyIA extends ImplicitAction {
    Stack<IADataForBasicProperty> actionDataStack = new Stack<>();
    private final BeanDescriptionCache beanDescriptionCache;

    public NestedBasicPropertyIA(BeanDescriptionCache beanDescriptionCache) {
        this.beanDescriptionCache = beanDescriptionCache;
    }

    @Override // p001ch.qos.logback.core.joran.action.ImplicitAction
    public boolean isApplicable(ElementPath elementPath, Attributes attributes, InterpretationContext ec) {
        String nestedElementTagName = elementPath.peekLast();
        if (ec.isEmpty()) {
            return false;
        }
        PropertySetter parentBean = new PropertySetter(this.beanDescriptionCache, ec.peekObject());
        parentBean.setContext(this.context);
        AggregationType aggregationType = parentBean.computeAggregationType(nestedElementTagName);
        switch (aggregationType) {
            case NOT_FOUND:
            case AS_COMPLEX_PROPERTY:
            case AS_COMPLEX_PROPERTY_COLLECTION:
                return false;
            case AS_BASIC_PROPERTY:
            case AS_BASIC_PROPERTY_COLLECTION:
                this.actionDataStack.push(new IADataForBasicProperty(parentBean, aggregationType, nestedElementTagName));
                return true;
            default:
                addError("PropertySetter.canContainComponent returned " + aggregationType);
                return false;
        }
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ec, String localName, Attributes attributes) {
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void body(InterpretationContext ec, String body) {
        String finalBody = ec.subst(body);
        IADataForBasicProperty actionData = this.actionDataStack.peek();
        switch (actionData.aggregationType) {
            case AS_BASIC_PROPERTY:
                actionData.parentBean.setProperty(actionData.propertyName, finalBody);
                return;
            case AS_BASIC_PROPERTY_COLLECTION:
                actionData.parentBean.addBasicProperty(actionData.propertyName, finalBody);
                return;
            default:
                addError("Unexpected aggregationType " + actionData.aggregationType);
                return;
        }
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ec, String tagName) {
        this.actionDataStack.pop();
    }
}
