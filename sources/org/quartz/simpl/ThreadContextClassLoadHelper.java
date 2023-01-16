package org.quartz.simpl;

import java.io.InputStream;
import java.net.URL;
import org.quartz.spi.ClassLoadHelper;

/* loaded from: grasscutter.jar:org/quartz/simpl/ThreadContextClassLoadHelper.class */
public class ThreadContextClassLoadHelper implements ClassLoadHelper {
    @Override // org.quartz.spi.ClassLoadHelper
    public void initialize() {
    }

    @Override // org.quartz.spi.ClassLoadHelper
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return getClassLoader().loadClass(name);
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
        return Thread.currentThread().getContextClassLoader();
    }
}
