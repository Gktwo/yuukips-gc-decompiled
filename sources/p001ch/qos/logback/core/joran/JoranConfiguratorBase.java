package p001ch.qos.logback.core.joran;

import java.util.HashMap;
import p001ch.qos.logback.core.joran.action.ActionConst;
import p001ch.qos.logback.core.joran.action.AppenderAction;
import p001ch.qos.logback.core.joran.action.AppenderRefAction;
import p001ch.qos.logback.core.joran.action.ContextPropertyAction;
import p001ch.qos.logback.core.joran.action.ConversionRuleAction;
import p001ch.qos.logback.core.joran.action.DefinePropertyAction;
import p001ch.qos.logback.core.joran.action.NestedBasicPropertyIA;
import p001ch.qos.logback.core.joran.action.NestedComplexPropertyIA;
import p001ch.qos.logback.core.joran.action.NewRuleAction;
import p001ch.qos.logback.core.joran.action.ParamAction;
import p001ch.qos.logback.core.joran.action.PropertyAction;
import p001ch.qos.logback.core.joran.action.ShutdownHookAction;
import p001ch.qos.logback.core.joran.action.StatusListenerAction;
import p001ch.qos.logback.core.joran.action.TimestampAction;
import p001ch.qos.logback.core.joran.spi.ElementSelector;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;
import p001ch.qos.logback.core.joran.spi.Interpreter;
import p001ch.qos.logback.core.joran.spi.RuleStore;

/* renamed from: ch.qos.logback.core.joran.JoranConfiguratorBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/JoranConfiguratorBase.class */
public abstract class JoranConfiguratorBase<E> extends GenericConfigurator {
    /* access modifiers changed from: protected */
    @Override // p001ch.qos.logback.core.joran.GenericConfigurator
    public void addInstanceRules(RuleStore rs) {
        rs.addRule(new ElementSelector("configuration/variable"), new PropertyAction());
        rs.addRule(new ElementSelector("configuration/property"), new PropertyAction());
        rs.addRule(new ElementSelector("configuration/substitutionProperty"), new PropertyAction());
        rs.addRule(new ElementSelector("configuration/timestamp"), new TimestampAction());
        rs.addRule(new ElementSelector("configuration/shutdownHook"), new ShutdownHookAction());
        rs.addRule(new ElementSelector("configuration/define"), new DefinePropertyAction());
        rs.addRule(new ElementSelector("configuration/contextProperty"), new ContextPropertyAction());
        rs.addRule(new ElementSelector("configuration/conversionRule"), new ConversionRuleAction());
        rs.addRule(new ElementSelector("configuration/statusListener"), new StatusListenerAction());
        rs.addRule(new ElementSelector("configuration/appender"), new AppenderAction());
        rs.addRule(new ElementSelector("configuration/appender/appender-ref"), new AppenderRefAction());
        rs.addRule(new ElementSelector("configuration/newRule"), new NewRuleAction());
        rs.addRule(new ElementSelector("*/param"), new ParamAction(getBeanDescriptionCache()));
    }

    @Override // p001ch.qos.logback.core.joran.GenericConfigurator
    protected void addImplicitRules(Interpreter interpreter) {
        NestedComplexPropertyIA nestedComplexPropertyIA = new NestedComplexPropertyIA(getBeanDescriptionCache());
        nestedComplexPropertyIA.setContext(this.context);
        interpreter.addImplicitAction(nestedComplexPropertyIA);
        NestedBasicPropertyIA nestedBasicIA = new NestedBasicPropertyIA(getBeanDescriptionCache());
        nestedBasicIA.setContext(this.context);
        interpreter.addImplicitAction(nestedBasicIA);
    }

    @Override // p001ch.qos.logback.core.joran.GenericConfigurator
    protected void buildInterpreter() {
        buildInterpreter();
        this.interpreter.getInterpretationContext().getObjectMap().put(ActionConst.APPENDER_BAG, new HashMap());
    }

    public InterpretationContext getInterpretationContext() {
        return this.interpreter.getInterpretationContext();
    }
}
