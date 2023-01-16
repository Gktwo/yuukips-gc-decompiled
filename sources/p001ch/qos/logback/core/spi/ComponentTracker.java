package p001ch.qos.logback.core.spi;

import java.util.Collection;
import java.util.Set;

/* renamed from: ch.qos.logback.core.spi.ComponentTracker */
/* loaded from: grasscutter.jar:ch/qos/logback/core/spi/ComponentTracker.class */
public interface ComponentTracker<C> {
    public static final int DEFAULT_TIMEOUT = 1800000;
    public static final int DEFAULT_MAX_COMPONENTS = Integer.MAX_VALUE;

    int getComponentCount();

    C find(String str);

    C getOrCreate(String str, long j);

    void removeStaleComponents(long j);

    void endOfLife(String str);

    Collection<C> allComponents();

    Set<String> allKeys();
}
