package org.eclipse.jetty.util;

import java.net.URL;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/Loader.class */
public class Loader {
    public static URL getResource(String name) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return loader == null ? ClassLoader.getSystemResource(name) : loader.getResource(name);
    }

    public static Class loadClass(String name) throws ClassNotFoundException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return loader == null ? Class.forName(name) : loader.loadClass(name);
    }

    public static Class loadClass(Class loaderClass, String name) throws ClassNotFoundException {
        if (loaderClass == null || loaderClass.getClassLoader() == null) {
            return loadClass(name);
        }
        return loaderClass.getClassLoader().loadClass(name);
    }

    public static ResourceBundle getResourceBundle(String name, boolean checkParents, Locale locale) throws MissingResourceException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return loader == null ? ResourceBundle.getBundle(name, locale) : ResourceBundle.getBundle(name, locale, loader);
    }
}
