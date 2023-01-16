package p001ch.qos.logback.core;

import java.util.HashSet;
import java.util.Set;
import p001ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.core.LifeCycleManager */
/* loaded from: grasscutter.jar:ch/qos/logback/core/LifeCycleManager.class */
public class LifeCycleManager {
    private final Set<LifeCycle> components = new HashSet();

    public void register(LifeCycle component) {
        this.components.add(component);
    }

    public void reset() {
        for (LifeCycle component : this.components) {
            if (component.isStarted()) {
                component.stop();
            }
        }
        this.components.clear();
    }
}
