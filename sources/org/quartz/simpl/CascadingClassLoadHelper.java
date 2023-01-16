package org.quartz.simpl;

import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import org.quartz.spi.ClassLoadHelper;

/* loaded from: grasscutter.jar:org/quartz/simpl/CascadingClassLoadHelper.class */
public class CascadingClassLoadHelper implements ClassLoadHelper {
    private LinkedList<ClassLoadHelper> loadHelpers;
    private ClassLoadHelper bestCandidate;

    @Override // org.quartz.spi.ClassLoadHelper
    public void initialize() {
        this.loadHelpers = new LinkedList<>();
        this.loadHelpers.add(new LoadingLoaderClassLoadHelper());
        this.loadHelpers.add(new SimpleClassLoadHelper());
        this.loadHelpers.add(new ThreadContextClassLoadHelper());
        this.loadHelpers.add(new InitThreadContextClassLoadHelper());
        Iterator i$ = this.loadHelpers.iterator();
        while (i$.hasNext()) {
            i$.next().initialize();
        }
    }

    @Override // org.quartz.spi.ClassLoadHelper
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (this.bestCandidate != null) {
            try {
                return this.bestCandidate.loadClass(name);
            } catch (Throwable th) {
                this.bestCandidate = null;
            }
        }
        Throwable throwable = null;
        Class<?> clazz = null;
        ClassLoadHelper loadHelper = null;
        Iterator<ClassLoadHelper> iter = this.loadHelpers.iterator();
        while (iter.hasNext()) {
            loadHelper = iter.next();
            try {
                clazz = loadHelper.loadClass(name);
                break;
            } catch (Throwable t) {
                throwable = t;
            }
        }
        if (clazz != null) {
            this.bestCandidate = loadHelper;
            return clazz;
        } else if (throwable instanceof ClassNotFoundException) {
            throw ((ClassNotFoundException) throwable);
        } else {
            throw new ClassNotFoundException(String.format("Unable to load class %s by any known loaders.", name), throwable);
        }
    }

    @Override // org.quartz.spi.ClassLoadHelper
    public <T> Class<? extends T> loadClass(String name, Class<T> clazz) throws ClassNotFoundException {
        return (Class<? extends T>) loadClass(name);
    }

    @Override // org.quartz.spi.ClassLoadHelper
    public URL getResource(String name) {
        URL result = null;
        if (this.bestCandidate != null) {
            result = this.bestCandidate.getResource(name);
            if (result != null) {
                return result;
            }
            this.bestCandidate = null;
        }
        ClassLoadHelper loadHelper = null;
        Iterator<ClassLoadHelper> iter = this.loadHelpers.iterator();
        while (iter.hasNext()) {
            loadHelper = iter.next();
            result = loadHelper.getResource(name);
            if (result != null) {
                break;
            }
        }
        this.bestCandidate = loadHelper;
        return result;
    }

    @Override // org.quartz.spi.ClassLoadHelper
    public InputStream getResourceAsStream(String name) {
        InputStream result = null;
        if (this.bestCandidate != null) {
            result = this.bestCandidate.getResourceAsStream(name);
            if (result != null) {
                return result;
            }
            this.bestCandidate = null;
        }
        ClassLoadHelper loadHelper = null;
        Iterator<ClassLoadHelper> iter = this.loadHelpers.iterator();
        while (iter.hasNext()) {
            loadHelper = iter.next();
            result = loadHelper.getResourceAsStream(name);
            if (result != null) {
                break;
            }
        }
        this.bestCandidate = loadHelper;
        return result;
    }

    @Override // org.quartz.spi.ClassLoadHelper
    public ClassLoader getClassLoader() {
        return this.bestCandidate == null ? Thread.currentThread().getContextClassLoader() : this.bestCandidate.getClassLoader();
    }
}
