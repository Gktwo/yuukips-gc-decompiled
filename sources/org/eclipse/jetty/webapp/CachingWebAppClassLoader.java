package org.eclipse.jetty.webapp;

import java.io.IOException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.webapp.WebAppClassLoader;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/CachingWebAppClassLoader.class */
public class CachingWebAppClassLoader extends WebAppClassLoader {
    private static final Logger LOG = Log.getLogger(CachingWebAppClassLoader.class);
    private final Set<String> _notFound = ConcurrentHashMap.newKeySet();
    private final ConcurrentHashMap<String, URL> _cache = new ConcurrentHashMap<>();

    public CachingWebAppClassLoader(ClassLoader parent, WebAppClassLoader.Context context) throws IOException {
        super(parent, context);
    }

    public CachingWebAppClassLoader(WebAppClassLoader.Context context) throws IOException {
        super(context);
    }

    @Override // org.eclipse.jetty.webapp.WebAppClassLoader, java.lang.ClassLoader
    public URL getResource(String name) {
        if (!this._notFound.contains(name)) {
            URL url = this._cache.get(name);
            if (url == null) {
                url = getResource(name);
                if (url == null) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Caching not found resource {}", name);
                    }
                    this._notFound.add(name);
                } else {
                    this._cache.putIfAbsent(name, url);
                }
            }
            return url;
        } else if (!LOG.isDebugEnabled()) {
            return null;
        } else {
            LOG.debug("Not found cache hit resource {}", name);
            return null;
        }
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (this._notFound.contains(name)) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Not found cache hit resource {}", name);
            }
            throw new ClassNotFoundException(name + ": in notfound cache");
        }
        try {
            return loadClass(name);
        } catch (ClassNotFoundException nfe) {
            if (this._notFound.add(name) && LOG.isDebugEnabled()) {
                LOG.debug("Caching not found {}", name);
                LOG.debug(nfe);
            }
            throw nfe;
        }
    }

    @ManagedOperation
    public void clearCache() {
        this._cache.clear();
        this._notFound.clear();
    }

    @Override // org.eclipse.jetty.webapp.WebAppClassLoader, java.lang.Object
    public String toString() {
        return "Caching[" + toString() + "]";
    }
}
