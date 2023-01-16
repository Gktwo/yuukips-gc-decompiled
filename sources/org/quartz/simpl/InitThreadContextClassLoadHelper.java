package org.quartz.simpl;

import java.io.InputStream;
import java.net.URL;
import org.quartz.spi.ClassLoadHelper;

/* loaded from: grasscutter.jar:org/quartz/simpl/InitThreadContextClassLoadHelper.class */
public class InitThreadContextClassLoadHelper implements ClassLoadHelper {
    private ClassLoader initClassLoader;

    @Override // org.quartz.spi.ClassLoadHelper
    public void initialize() {
        this.initClassLoader = Thread.currentThread().getContextClassLoader();
    }

    @Override // org.quartz.spi.ClassLoadHelper
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return this.initClassLoader.loadClass(name);
    }

    @Override // org.quartz.spi.ClassLoadHelper
    public <T> Class<? extends T> loadClass(String name, Class<T> clazz) throws ClassNotFoundException {
        return (Class<? extends T>) loadClass(name);
    }

    @Override // org.quartz.spi.ClassLoadHelper
    public URL getResource(String name) {
        return this.initClassLoader.getResource(name);
    }

    @Override // org.quartz.spi.ClassLoadHelper
    public InputStream getResourceAsStream(String name) {
        return this.initClassLoader.getResourceAsStream(name);
    }

    @Override // org.quartz.spi.ClassLoadHelper
    public ClassLoader getClassLoader() {
        return this.initClassLoader;
    }
}
