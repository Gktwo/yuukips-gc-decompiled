package p001ch.qos.logback.core.joran.util.beans;

import java.util.HashMap;
import java.util.Map;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.joran.util.beans.BeanDescriptionCache */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/util/beans/BeanDescriptionCache.class */
public class BeanDescriptionCache extends ContextAwareBase {
    private Map<Class<?>, BeanDescription> classToBeanDescription = new HashMap();
    private BeanDescriptionFactory beanDescriptionFactory;

    public BeanDescriptionCache(Context context) {
        setContext(context);
    }

    private BeanDescriptionFactory getBeanDescriptionFactory() {
        if (this.beanDescriptionFactory == null) {
            this.beanDescriptionFactory = new BeanDescriptionFactory(getContext());
        }
        return this.beanDescriptionFactory;
    }

    public BeanDescription getBeanDescription(Class<?> clazz) {
        if (!this.classToBeanDescription.containsKey(clazz)) {
            this.classToBeanDescription.put(clazz, getBeanDescriptionFactory().create(clazz));
        }
        return this.classToBeanDescription.get(clazz);
    }
}
