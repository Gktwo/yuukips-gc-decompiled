package p001ch.qos.logback.classic.util;

import java.util.Iterator;
import java.util.ServiceLoader;
import p001ch.qos.logback.core.util.Loader;

/* renamed from: ch.qos.logback.classic.util.EnvUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/util/EnvUtil.class */
public class EnvUtil {
    static ClassLoader testServiceLoaderClassLoader = null;

    public static boolean isGroovyAvailable() {
        try {
            return Loader.getClassLoaderOfClass(EnvUtil.class).loadClass("groovy.lang.Binding") != null;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static ClassLoader getServiceLoaderClassLoader() {
        return testServiceLoaderClassLoader == null ? Loader.getClassLoaderOfClass(EnvUtil.class) : testServiceLoaderClassLoader;
    }

    public static <T> T loadFromServiceLoader(Class<T> c) {
        Iterator<T> it = ServiceLoader.load(c, getServiceLoaderClassLoader()).iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }
}
