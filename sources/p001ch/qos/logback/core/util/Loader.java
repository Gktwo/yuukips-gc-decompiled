package p001ch.qos.logback.core.util;

import java.io.IOException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import p001ch.qos.logback.core.Context;

/* renamed from: ch.qos.logback.core.util.Loader */
/* loaded from: grasscutter.jar:ch/qos/logback/core/util/Loader.class */
public class Loader {
    static final String TSTR = "Caught Exception while in Loader.getResource. This may be innocuous.";
    private static boolean ignoreTCL;
    public static final String IGNORE_TCL_PROPERTY_NAME = "logback.ignoreTCL";
    private static boolean HAS_GET_CLASS_LOADER_PERMISSION;

    static {
        ignoreTCL = false;
        HAS_GET_CLASS_LOADER_PERMISSION = false;
        String ignoreTCLProp = OptionHelper.getSystemProperty(IGNORE_TCL_PROPERTY_NAME, null);
        if (ignoreTCLProp != null) {
            ignoreTCL = OptionHelper.toBoolean(ignoreTCLProp, true);
        }
        HAS_GET_CLASS_LOADER_PERMISSION = ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: ch.qos.logback.core.util.Loader.1
            @Override // java.security.PrivilegedAction
            public Boolean run() {
                try {
                    AccessController.checkPermission(new RuntimePermission("getClassLoader"));
                    return true;
                } catch (SecurityException e) {
                    return false;
                }
            }
        })).booleanValue();
    }

    public static Set<URL> getResources(String resource, ClassLoader classLoader) throws IOException {
        Set<URL> urlSet = new HashSet<>();
        Enumeration<URL> urlEnum = classLoader.getResources(resource);
        while (urlEnum.hasMoreElements()) {
            urlSet.add(urlEnum.nextElement());
        }
        return urlSet;
    }

    public static URL getResource(String resource, ClassLoader classLoader) {
        try {
            return classLoader.getResource(resource);
        } catch (Throwable th) {
            return null;
        }
    }

    public static URL getResourceBySelfClassLoader(String resource) {
        return getResource(resource, getClassLoaderOfClass(Loader.class));
    }

    public static ClassLoader getTCL() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String clazz, Context context) throws ClassNotFoundException {
        return getClassLoaderOfObject(context).loadClass(clazz);
    }

    public static ClassLoader getClassLoaderOfObject(Object o) {
        if (o != null) {
            return getClassLoaderOfClass(o.getClass());
        }
        throw new NullPointerException("Argument cannot be null");
    }

    public static ClassLoader getClassLoaderAsPrivileged(final Class<?> clazz) {
        if (!HAS_GET_CLASS_LOADER_PERMISSION) {
            return null;
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: ch.qos.logback.core.util.Loader.2
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return clazz.getClassLoader();
            }
        });
    }

    public static ClassLoader getClassLoaderOfClass(Class<?> clazz) {
        ClassLoader cl = clazz.getClassLoader();
        if (cl == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return cl;
    }

    public static Class<?> loadClass(String clazz) throws ClassNotFoundException {
        if (ignoreTCL) {
            return Class.forName(clazz);
        }
        try {
            return getTCL().loadClass(clazz);
        } catch (Throwable th) {
            return Class.forName(clazz);
        }
    }
}
