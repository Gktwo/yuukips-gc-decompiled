package org.eclipse.jetty.webapp;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.regex.Pattern;
import org.eclipse.jetty.util.PatternMatcher;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/JarScanner.class */
public abstract class JarScanner extends PatternMatcher {
    private static final Logger LOG = Log.getLogger(JarScanner.class);

    public abstract void processEntry(URI uri, JarEntry jarEntry);

    public void scan(Pattern pattern, URI[] uris, boolean isNullInclusive) throws Exception {
        match(pattern, uris, isNullInclusive);
    }

    public void scan(Pattern pattern, ClassLoader loader, boolean isNullInclusive, boolean visitParent) throws Exception {
        URL[] urls;
        while (loader != null) {
            if ((loader instanceof URLClassLoader) && (urls = ((URLClassLoader) loader).getURLs()) != null) {
                URI[] uris = new URI[urls.length];
                int i = 0;
                for (URL u : urls) {
                    i++;
                    uris[i] = u.toURI();
                }
                scan(pattern, uris, isNullInclusive);
            }
            if (visitParent) {
                loader = loader.getParent();
            } else {
                loader = null;
            }
        }
    }

    @Override // org.eclipse.jetty.util.PatternMatcher
    public void matched(URI uri) throws Exception {
        InputStream in;
        LOG.debug("Search of {}", uri);
        if (uri.toString().toLowerCase(Locale.ENGLISH).endsWith(".jar") && (in = Resource.newResource(uri).getInputStream()) != null) {
            JarInputStream jarIn = new JarInputStream(in);
            try {
                for (JarEntry entry = jarIn.getNextJarEntry(); entry != null; entry = jarIn.getNextJarEntry()) {
                    processEntry(uri, entry);
                }
            } finally {
                jarIn.close();
            }
        }
    }
}
