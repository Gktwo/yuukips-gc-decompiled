package org.eclipse.jetty.util;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/DeprecationWarning.class */
public class DeprecationWarning implements Decorator {
    private static final Logger LOG = Log.getLogger(DeprecationWarning.class);

    @Override // org.eclipse.jetty.util.Decorator
    public <T> T decorate(T o) {
        if (o == null) {
            return null;
        }
        Class<?> clazz = o.getClass();
        try {
            if (((Deprecated) clazz.getAnnotation(Deprecated.class)) != null) {
                LOG.warn("Using @Deprecated Class {}", clazz.getName());
            }
        } catch (Throwable t) {
            LOG.ignore(t);
        }
        verifyIndirectTypes(clazz.getSuperclass(), clazz, "Class");
        for (Class<?> ifaceClazz : clazz.getInterfaces()) {
            verifyIndirectTypes(ifaceClazz, clazz, "Interface");
        }
        return o;
    }

    private void verifyIndirectTypes(Class<?> superClazz, Class<?> clazz, String typeName) {
        while (superClazz != null && superClazz != Object.class) {
            try {
                if (((Deprecated) superClazz.getAnnotation(Deprecated.class)) != null) {
                    LOG.warn("Using indirect @Deprecated {} {} - (seen from {})", typeName, superClazz.getName(), clazz);
                }
                superClazz = superClazz.getSuperclass();
            } catch (Throwable t) {
                LOG.ignore(t);
                return;
            }
        }
    }

    @Override // org.eclipse.jetty.util.Decorator
    public void destroy(Object o) {
    }
}
