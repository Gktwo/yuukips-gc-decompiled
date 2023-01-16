package org.quartz.simpl;

import java.io.InputStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.net.URL;
import org.quartz.spi.ClassLoadHelper;

/* loaded from: grasscutter.jar:org/quartz/simpl/SimpleClassLoadHelper.class */
public class SimpleClassLoadHelper implements ClassLoadHelper {
    @Override // org.quartz.spi.ClassLoadHelper
    public void initialize() {
    }

    @Override // org.quartz.spi.ClassLoadHelper
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return Class.forName(name);
    }

    @Override // org.quartz.spi.ClassLoadHelper
    public <T> Class<? extends T> loadClass(String name, Class<T> clazz) throws ClassNotFoundException {
        return (Class<? extends T>) loadClass(name);
    }

    @Override // org.quartz.spi.ClassLoadHelper
    public URL getResource(String name) {
        return getClassLoader().getResource(name);
    }

    @Override // org.quartz.spi.ClassLoadHelper
    public InputStream getResourceAsStream(String name) {
        return getClassLoader().getResourceAsStream(name);
    }

    @Override // org.quartz.spi.ClassLoadHelper
    public ClassLoader getClassLoader() {
        try {
            ClassLoader cl = getClass().getClassLoader();
            Method mthd = ClassLoader.class.getDeclaredMethod("getCallerClassLoader", new Class[0]);
            AccessibleObject.setAccessible(new AccessibleObject[]{mthd}, true);
            return (ClassLoader) mthd.invoke(cl, new Object[0]);
        } catch (Throwable th) {
            return getClass().getClassLoader();
        }
    }
}
