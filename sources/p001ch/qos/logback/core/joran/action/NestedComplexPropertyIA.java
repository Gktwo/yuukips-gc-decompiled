package p001ch.qos.logback.core.joran.action;

import java.util.Stack;
import org.xml.sax.Attributes;
import p001ch.qos.logback.core.joran.spi.ElementPath;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;
import p001ch.qos.logback.core.joran.spi.NoAutoStartUtil;
import p001ch.qos.logback.core.joran.util.PropertySetter;
import p001ch.qos.logback.core.joran.util.beans.BeanDescriptionCache;
import p001ch.qos.logback.core.spi.ContextAware;
import p001ch.qos.logback.core.spi.LifeCycle;
import p001ch.qos.logback.core.util.AggregationType;
import p001ch.qos.logback.core.util.Loader;
import p001ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.joran.action.NestedComplexPropertyIA */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/action/NestedComplexPropertyIA.class */
public class NestedComplexPropertyIA extends ImplicitAction {
    Stack<IADataForComplexProperty> actionDataStack = new Stack<>();
    private final BeanDescriptionCache beanDescriptionCache;

    public NestedComplexPropertyIA(BeanDescriptionCache beanDescriptionCache) {
        this.beanDescriptionCache = beanDescriptionCache;
    }

    @Override // p001ch.qos.logback.core.joran.action.ImplicitAction
    public boolean isApplicable(ElementPath elementPath, Attributes attributes, InterpretationContext ic) {
        String nestedElementTagName = elementPath.peekLast();
        if (ic.isEmpty()) {
            return false;
        }
        PropertySetter parentBean = new PropertySetter(this.beanDescriptionCache, ic.peekObject());
        parentBean.setContext(this.context);
        AggregationType aggregationType = parentBean.computeAggregationType(nestedElementTagName);
        switch (aggregationType) {
            case NOT_FOUND:
            case AS_BASIC_PROPERTY:
            case AS_BASIC_PROPERTY_COLLECTION:
                return false;
            case AS_COMPLEX_PROPERTY_COLLECTION:
            case AS_COMPLEX_PROPERTY:
                this.actionDataStack.push(new IADataForComplexProperty(parentBean, aggregationType, nestedElementTagName));
                return true;
            default:
                addError("PropertySetter.computeAggregationType returned " + aggregationType);
                return false;
        }
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ec, String localName, Attributes attributes) {
        Class<?> componentClass;
        IADataForComplexProperty actionData = this.actionDataStack.peek();
        String className = ec.subst(attributes.getValue("class"));
        try {
            if (!OptionHelper.isEmpty(className)) {
                componentClass = Loader.loadClass(className, this.context);
            } else {
                componentClass = actionData.parentBean.getClassNameViaImplicitRules(actionData.getComplexPropertyName(), actionData.getAggregationType(), ec.getDefaultNestedComponentRegistry());
            }
            if (componentClass == null) {
                actionData.inError = true;
                addError("Could not find an appropriate class for property [" + localName + "]");
                return;
            }
            if (OptionHelper.isEmpty(className)) {
                addInfo("Assuming default type [" + componentClass.getName() + "] for [" + localName + "] property");
            }
            actionData.setNestedComplexProperty(componentClass.newInstance());
            if (actionData.getNestedComplexProperty() instanceof ContextAware) {
                ((ContextAware) actionData.getNestedComplexProperty()).setContext(this.context);
            }
            ec.pushObject(actionData.getNestedComplexProperty());
        } catch (Exception oops) {
            actionData.inError = true;
            addError("Could not create component [" + localName + "] of type [" + className + "]", oops);
        }
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ec, String tagName) {
        IADataForComplexProperty actionData = this.actionDataStack.pop();
        if (!actionData.inError) {
            PropertySetter nestedBean = new PropertySetter(this.beanDescriptionCache, actionData.getNestedComplexProperty());
            nestedBean.setContext(this.context);
            if (nestedBean.computeAggregationType("parent") == AggregationType.AS_COMPLEX_PROPERTY) {
                nestedBean.setComplexProperty("parent", actionData.parentBean.getObj());
            }
            Object nestedComplexProperty = actionData.getNestedComplexProperty();
            if ((nestedComplexProperty instanceof LifeCycle) && NoAutoStartUtil.notMarkedWithNoAutoStart(nestedComplexProperty)) {
                ((LifeCycle) nestedComplexProperty).start();
            }
            if (ec.peekObject() != actionData.getNestedComplexProperty()) {
                addError("The object on the top the of the stack is not the component pushed earlier.");
                return;
            }
            ec.popObject();
            switch (actionData.aggregationType) {
                case AS_COMPLEX_PROPERTY_COLLECTION:
                    actionData.parentBean.addComplexProperty(tagName, actionData.getNestedComplexProperty());
                    return;
                case AS_COMPLEX_PROPERTY:
                    actionData.parentBean.setComplexProperty(tagName, actionData.getNestedComplexProperty());
                    return;
                default:
                    addError("Unexpected aggregationType " + actionData.aggregationType);
                    return;
            }
        }
    }
}
