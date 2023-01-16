package p001ch.qos.logback.core.joran.spi;

import java.util.HashMap;
import java.util.Map;

/* renamed from: ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/spi/DefaultNestedComponentRegistry.class */
public class DefaultNestedComponentRegistry {
    Map<HostClassAndPropertyDouble, Class<?>> defaultComponentMap = new HashMap();

    public void add(Class<?> hostClass, String propertyName, Class<?> componentClass) {
        this.defaultComponentMap.put(new HostClassAndPropertyDouble(hostClass, propertyName.toLowerCase()), componentClass);
    }

    public Class<?> findDefaultComponentType(Class<?> hostClass, String propertyName) {
        String propertyName2 = propertyName.toLowerCase();
        while (hostClass != null) {
            Class<?> componentClass = oneShotFind(hostClass, propertyName2);
            if (componentClass != null) {
                return componentClass;
            }
            hostClass = hostClass.getSuperclass();
        }
        return null;
    }

    private Class<?> oneShotFind(Class<?> hostClass, String propertyName) {
        return this.defaultComponentMap.get(new HostClassAndPropertyDouble(hostClass, propertyName));
    }
}
