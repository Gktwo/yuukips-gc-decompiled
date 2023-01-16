package p001ch.qos.logback.core.joran.util.beans;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.joran.util.beans.BeanDescriptionFactory */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/util/beans/BeanDescriptionFactory.class */
public class BeanDescriptionFactory extends ContextAwareBase {
    /* access modifiers changed from: package-private */
    public BeanDescriptionFactory(Context context) {
        setContext(context);
    }

    public BeanDescription create(Class<?> clazz) {
        Map<String, Method> propertyNameToGetter = new HashMap<>();
        Map<String, Method> propertyNameToSetter = new HashMap<>();
        Map<String, Method> propertyNameToAdder = new HashMap<>();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (!method.isBridge()) {
                if (BeanUtil.isGetter(method)) {
                    String propertyName = BeanUtil.getPropertyName(method);
                    Method oldGetter = propertyNameToGetter.put(propertyName, method);
                    if (oldGetter != null) {
                        if (oldGetter.getName().startsWith(BeanUtil.PREFIX_GETTER_IS)) {
                            propertyNameToGetter.put(propertyName, oldGetter);
                        }
                        addWarn(String.format("Class '%s' contains multiple getters for the same property '%s'.", clazz.getCanonicalName(), propertyName));
                    }
                } else if (BeanUtil.isSetter(method)) {
                    String propertyName2 = BeanUtil.getPropertyName(method);
                    if (propertyNameToSetter.put(propertyName2, method) != null) {
                        addWarn(String.format("Class '%s' contains multiple setters for the same property '%s'.", clazz.getCanonicalName(), propertyName2));
                    }
                } else if (BeanUtil.isAdder(method)) {
                    String propertyName3 = BeanUtil.getPropertyName(method);
                    if (propertyNameToAdder.put(propertyName3, method) != null) {
                        addWarn(String.format("Class '%s' contains multiple adders for the same property '%s'.", clazz.getCanonicalName(), propertyName3));
                    }
                }
            }
        }
        return new BeanDescription(clazz, propertyNameToGetter, propertyNameToSetter, propertyNameToAdder);
    }
}
