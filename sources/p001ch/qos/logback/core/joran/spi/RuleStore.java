package p001ch.qos.logback.core.joran.spi;

import java.util.List;
import p001ch.qos.logback.core.joran.action.Action;

/* renamed from: ch.qos.logback.core.joran.spi.RuleStore */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/spi/RuleStore.class */
public interface RuleStore {
    void addRule(ElementSelector elementSelector, String str) throws ClassNotFoundException;

    void addRule(ElementSelector elementSelector, Action action);

    List<Action> matchActions(ElementPath elementPath);
}
