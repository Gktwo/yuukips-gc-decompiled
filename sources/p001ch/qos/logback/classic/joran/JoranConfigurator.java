package p001ch.qos.logback.classic.joran;

import p001ch.qos.logback.classic.joran.action.ConfigurationAction;
import p001ch.qos.logback.classic.joran.action.ConsolePluginAction;
import p001ch.qos.logback.classic.joran.action.ContextNameAction;
import p001ch.qos.logback.classic.joran.action.EvaluatorAction;
import p001ch.qos.logback.classic.joran.action.InsertFromJNDIAction;
import p001ch.qos.logback.classic.joran.action.JMXConfiguratorAction;
import p001ch.qos.logback.classic.joran.action.LevelAction;
import p001ch.qos.logback.classic.joran.action.LoggerAction;
import p001ch.qos.logback.classic.joran.action.LoggerContextListenerAction;
import p001ch.qos.logback.classic.joran.action.ReceiverAction;
import p001ch.qos.logback.classic.joran.action.RootLoggerAction;
import p001ch.qos.logback.classic.sift.SiftAction;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.classic.spi.PlatformInfo;
import p001ch.qos.logback.classic.util.DefaultNestedComponentRules;
import p001ch.qos.logback.core.joran.JoranConfiguratorBase;
import p001ch.qos.logback.core.joran.action.AppenderRefAction;
import p001ch.qos.logback.core.joran.action.IncludeAction;
import p001ch.qos.logback.core.joran.action.NOPAction;
import p001ch.qos.logback.core.joran.conditional.ElseAction;
import p001ch.qos.logback.core.joran.conditional.IfAction;
import p001ch.qos.logback.core.joran.conditional.ThenAction;
import p001ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import p001ch.qos.logback.core.joran.spi.ElementSelector;
import p001ch.qos.logback.core.joran.spi.RuleStore;

/* renamed from: ch.qos.logback.classic.joran.JoranConfigurator */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/joran/JoranConfigurator.class */
public class JoranConfigurator extends JoranConfiguratorBase<ILoggingEvent> {
    @Override // p001ch.qos.logback.core.joran.JoranConfiguratorBase, p001ch.qos.logback.core.joran.GenericConfigurator
    public void addInstanceRules(RuleStore rs) {
        addInstanceRules(rs);
        rs.addRule(new ElementSelector("configuration"), new ConfigurationAction());
        rs.addRule(new ElementSelector("configuration/contextName"), new ContextNameAction());
        rs.addRule(new ElementSelector("configuration/contextListener"), new LoggerContextListenerAction());
        rs.addRule(new ElementSelector("configuration/insertFromJNDI"), new InsertFromJNDIAction());
        rs.addRule(new ElementSelector("configuration/evaluator"), new EvaluatorAction());
        rs.addRule(new ElementSelector("configuration/appender/sift"), new SiftAction());
        rs.addRule(new ElementSelector("configuration/appender/sift/*"), new NOPAction());
        rs.addRule(new ElementSelector("configuration/logger"), new LoggerAction());
        rs.addRule(new ElementSelector("configuration/logger/level"), new LevelAction());
        rs.addRule(new ElementSelector("configuration/root"), new RootLoggerAction());
        rs.addRule(new ElementSelector("configuration/root/level"), new LevelAction());
        rs.addRule(new ElementSelector("configuration/logger/appender-ref"), new AppenderRefAction());
        rs.addRule(new ElementSelector("configuration/root/appender-ref"), new AppenderRefAction());
        rs.addRule(new ElementSelector("*/if"), new IfAction());
        rs.addRule(new ElementSelector("*/if/then"), new ThenAction());
        rs.addRule(new ElementSelector("*/if/then/*"), new NOPAction());
        rs.addRule(new ElementSelector("*/if/else"), new ElseAction());
        rs.addRule(new ElementSelector("*/if/else/*"), new NOPAction());
        if (PlatformInfo.hasJMXObjectName()) {
            rs.addRule(new ElementSelector("configuration/jmxConfigurator"), new JMXConfiguratorAction());
        }
        rs.addRule(new ElementSelector("configuration/include"), new IncludeAction());
        rs.addRule(new ElementSelector("configuration/consolePlugin"), new ConsolePluginAction());
        rs.addRule(new ElementSelector("configuration/receiver"), new ReceiverAction());
    }

    @Override // p001ch.qos.logback.core.joran.GenericConfigurator
    protected void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry registry) {
        DefaultNestedComponentRules.addDefaultNestedComponentRegistryRules(registry);
    }
}
