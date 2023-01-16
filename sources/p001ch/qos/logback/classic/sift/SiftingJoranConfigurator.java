package p001ch.qos.logback.classic.sift;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.classic.util.DefaultNestedComponentRules;
import p001ch.qos.logback.core.Appender;
import p001ch.qos.logback.core.joran.action.ActionConst;
import p001ch.qos.logback.core.joran.action.AppenderAction;
import p001ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import p001ch.qos.logback.core.joran.spi.ElementPath;
import p001ch.qos.logback.core.joran.spi.ElementSelector;
import p001ch.qos.logback.core.joran.spi.RuleStore;
import p001ch.qos.logback.core.sift.SiftingJoranConfiguratorBase;

/* renamed from: ch.qos.logback.classic.sift.SiftingJoranConfigurator */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/sift/SiftingJoranConfigurator.class */
public class SiftingJoranConfigurator extends SiftingJoranConfiguratorBase<ILoggingEvent> {
    /* access modifiers changed from: package-private */
    public SiftingJoranConfigurator(String key, String value, Map<String, String> parentPropertyMap) {
        super(key, value, parentPropertyMap);
    }

    @Override // p001ch.qos.logback.core.joran.GenericConfigurator
    protected ElementPath initialElementPath() {
        return new ElementPath("configuration");
    }

    @Override // p001ch.qos.logback.core.sift.SiftingJoranConfiguratorBase, p001ch.qos.logback.core.joran.GenericConfigurator
    protected void addInstanceRules(RuleStore rs) {
        addInstanceRules(rs);
        rs.addRule(new ElementSelector("configuration/appender"), new AppenderAction());
    }

    @Override // p001ch.qos.logback.core.joran.GenericConfigurator
    protected void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry registry) {
        DefaultNestedComponentRules.addDefaultNestedComponentRegistryRules(registry);
    }

    @Override // p001ch.qos.logback.core.joran.GenericConfigurator
    protected void buildInterpreter() {
        buildInterpreter();
        this.interpreter.getInterpretationContext().getObjectMap().put(ActionConst.APPENDER_BAG, new HashMap());
        Map<String, String> propertiesMap = new HashMap<>();
        propertiesMap.putAll(this.parentPropertyMap);
        propertiesMap.put(this.key, this.value);
        this.interpreter.setInterpretationContextPropertiesMap(propertiesMap);
    }

    @Override // p001ch.qos.logback.core.sift.SiftingJoranConfiguratorBase
    public Appender<ILoggingEvent> getAppender() {
        HashMap<String, Appender<?>> appenderMap = (HashMap) this.interpreter.getInterpretationContext().getObjectMap().get(ActionConst.APPENDER_BAG);
        oneAndOnlyOneCheck(appenderMap);
        Collection<Appender<?>> values = appenderMap.values();
        if (values.size() == 0) {
            return null;
        }
        return values.iterator().next();
    }
}
