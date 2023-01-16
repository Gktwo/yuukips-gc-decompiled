package org.quartz.spi;

import java.io.InputStream;
import java.net.URL;

/* loaded from: grasscutter.jar:org/quartz/spi/ClassLoadHelper.class */
public interface ClassLoadHelper {
    void initialize();

    Class<?> loadClass(String str) throws ClassNotFoundException;

    <T> Class<? extends T> loadClass(String str, Class<T> cls) throws ClassNotFoundException;

    URL getResource(String str);

    InputStream getResourceAsStream(String str);

    ClassLoader getClassLoader();
}
