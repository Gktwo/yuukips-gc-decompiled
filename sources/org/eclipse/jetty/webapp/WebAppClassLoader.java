package org.eclipse.jetty.webapp;

import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.PrivilegedExceptionAction;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;
import org.eclipse.jetty.util.C5739IO;
import org.eclipse.jetty.util.ClassVisibilityChecker;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.resource.ResourceCollection;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/WebAppClassLoader.class */
public class WebAppClassLoader extends URLClassLoader implements ClassVisibilityChecker {
    private static final Logger LOG = Log.getLogger(WebAppClassLoader.class);
    private static final ThreadLocal<Boolean> __loadServerClasses = new ThreadLocal<>();
    private final Context _context;
    private final ClassLoader _parent;
    private final Set<String> _extensions;
    private String _name;
    private final List<ClassFileTransformer> _transformers;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/WebAppClassLoader$Context.class */
    public interface Context extends ClassVisibilityChecker {
        Resource newResource(String str) throws IOException;

        PermissionCollection getPermissions();

        boolean isParentLoaderPriority();

        String getExtraClasspath();

        boolean isServerResource(String str, URL url);

        boolean isSystemResource(String str, URL url);
    }

    static {
        registerAsParallelCapable();
    }

    public static <T> T runWithServerClassAccess(PrivilegedExceptionAction<T> action) throws Exception {
        Boolean lsc = __loadServerClasses.get();
        try {
            __loadServerClasses.set(true);
            T run = action.run();
            if (lsc == null) {
                __loadServerClasses.remove();
            } else {
                __loadServerClasses.set(lsc);
            }
            return run;
        } catch (Throwable th) {
            if (lsc == null) {
                __loadServerClasses.remove();
            } else {
                __loadServerClasses.set(lsc);
            }
            throw th;
        }
    }

    public WebAppClassLoader(Context context) throws IOException {
        this(null, context);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WebAppClassLoader(java.lang.ClassLoader r6, org.eclipse.jetty.webapp.WebAppClassLoader.Context r7) throws java.io.IOException {
        /*
            r5 = this;
            r0 = r5
            r1 = 0
            java.net.URL[] r1 = new java.net.URL[r1]
            r2 = r6
            if (r2 == 0) goto L_0x000d
            r2 = r6
            goto L_0x0032
        L_0x000d:
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r2 = r2.getContextClassLoader()
            if (r2 == 0) goto L_0x001f
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r2 = r2.getContextClassLoader()
            goto L_0x0032
        L_0x001f:
            java.lang.Class<org.eclipse.jetty.webapp.WebAppClassLoader> r2 = org.eclipse.jetty.webapp.WebAppClassLoader.class
            java.lang.ClassLoader r2 = r2.getClassLoader()
            if (r2 == 0) goto L_0x002f
            java.lang.Class<org.eclipse.jetty.webapp.WebAppClassLoader> r2 = org.eclipse.jetty.webapp.WebAppClassLoader.class
            java.lang.ClassLoader r2 = r2.getClassLoader()
            goto L_0x0032
        L_0x002f:
            java.lang.ClassLoader r2 = java.lang.ClassLoader.getSystemClassLoader()
        L_0x0032:
            r0.<init>(r1, r2)
            r0 = r5
            java.util.HashSet r1 = new java.util.HashSet
            r2 = r1
            r2.<init>()
            r0._extensions = r1
            r0 = r5
            r1 = r5
            int r1 = r1.hashCode()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0._name = r1
            r0 = r5
            java.util.concurrent.CopyOnWriteArrayList r1 = new java.util.concurrent.CopyOnWriteArrayList
            r2 = r1
            r2.<init>()
            r0._transformers = r1
            r0 = r5
            r1 = r5
            java.lang.ClassLoader r1 = r1.getParent()
            r0._parent = r1
            r0 = r5
            r1 = r7
            r0._context = r1
            r0 = r5
            java.lang.ClassLoader r0 = r0._parent
            if (r0 != 0) goto L_0x0074
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "no parent classloader!"
            r1.<init>(r2)
            throw r0
        L_0x0074:
            r0 = r5
            java.util.Set<java.lang.String> r0 = r0._extensions
            java.lang.String r1 = ".jar"
            boolean r0 = r0.add(r1)
            r0 = r5
            java.util.Set<java.lang.String> r0 = r0._extensions
            java.lang.String r1 = ".zip"
            boolean r0 = r0.add(r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            java.lang.Class<org.eclipse.jetty.webapp.WebAppClassLoader> r1 = org.eclipse.jetty.webapp.WebAppClassLoader.class
            java.lang.String r1 = r1.getName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ".extensions"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = java.lang.System.getProperty(r0)
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L_0x00d4
            java.util.StringTokenizer r0 = new java.util.StringTokenizer
            r1 = r0
            r2 = r8
            java.lang.String r3 = ",;"
            r1.<init>(r2, r3)
            r9 = r0
        L_0x00b7:
            r0 = r9
            boolean r0 = r0.hasMoreTokens()
            if (r0 == 0) goto L_0x00d4
            r0 = r5
            java.util.Set<java.lang.String> r0 = r0._extensions
            r1 = r9
            java.lang.String r1 = r1.nextToken()
            java.lang.String r1 = r1.trim()
            boolean r0 = r0.add(r1)
            goto L_0x00b7
        L_0x00d4:
            r0 = r7
            java.lang.String r0 = r0.getExtraClasspath()
            if (r0 == 0) goto L_0x00e7
            r0 = r5
            r1 = r7
            java.lang.String r1 = r1.getExtraClasspath()
            r0.addClassPath(r1)
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.webapp.WebAppClassLoader.<init>(java.lang.ClassLoader, org.eclipse.jetty.webapp.WebAppClassLoader$Context):void");
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public Context getContext() {
        return this._context;
    }

    public void addClassPath(Resource resource) throws IOException {
        if (resource instanceof ResourceCollection) {
            for (Resource r : ((ResourceCollection) resource).getResources()) {
                addClassPath(r);
            }
            return;
        }
        addClassPath(resource.toString());
    }

    public void addClassPath(String classPath) throws IOException {
        if (classPath != null) {
            StringTokenizer tokenizer = new StringTokenizer(classPath, ",;");
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken().trim();
                if (!token.endsWith("*")) {
                    Resource resource = this._context.newResource(token);
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Path resource=" + resource, new Object[0]);
                    }
                    if (resource.isDirectory() && (resource instanceof ResourceCollection)) {
                        addClassPath(resource);
                    } else if (resource.getFile() != null) {
                        addURL(resource.getURI().toURL());
                    } else if (resource.isDirectory()) {
                        addURL(resource.getURI().toURL());
                    } else {
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Check file exists and is not nested jar: " + resource, new Object[0]);
                        }
                        throw new IllegalArgumentException("File not resolvable or incompatible with URLClassloader: " + resource);
                    }
                } else if (token.length() > 1) {
                    String token2 = token.substring(0, token.length() - 1);
                    Resource resource2 = this._context.newResource(token2);
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Glob Path resource=" + resource2, new Object[0]);
                    }
                    addJars(this._context.newResource(token2));
                    return;
                } else {
                    return;
                }
            }
        }
    }

    private boolean isFileSupported(String file) {
        int dot = file.lastIndexOf(46);
        return dot != -1 && this._extensions.contains(file.substring(dot));
    }

    public void addJars(Resource lib) {
        String[] entries;
        if (lib.exists() && lib.isDirectory() && (entries = lib.list()) != null) {
            Arrays.sort(entries);
            for (String entry : entries) {
                try {
                    Resource resource = lib.addPath(entry);
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("addJar - {}", resource);
                    }
                    if (isFileSupported(resource.getName().toLowerCase(Locale.ENGLISH))) {
                        addClassPath(URIUtil.encodeSpecific(resource.toString(), ",;"));
                    }
                } catch (Exception ex) {
                    LOG.warn(Log.EXCEPTION, ex);
                }
            }
        }
    }

    @Override // java.net.URLClassLoader, java.security.SecureClassLoader
    public PermissionCollection getPermissions(CodeSource cs) {
        PermissionCollection permissions = this._context.getPermissions();
        return permissions == null ? getPermissions(cs) : permissions;
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> getResources(String name) throws IOException {
        List<URL> resources;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Enumeration<URL> urls = this._parent.getResources(name);
        while (urls != null && urls.hasMoreElements()) {
            URL url = urls.nextElement();
            if (Boolean.TRUE.equals(__loadServerClasses.get()) || !this._context.isServerResource(name, url)) {
                arrayList.add(url);
            }
        }
        Enumeration<URL> urls2 = findResources(name);
        while (urls2 != null && urls2.hasMoreElements()) {
            URL url2 = urls2.nextElement();
            if (!this._context.isSystemResource(name, url2) || arrayList.isEmpty()) {
                arrayList2.add(url2);
            }
        }
        if (this._context.isParentLoaderPriority()) {
            arrayList.addAll(arrayList2);
            resources = arrayList;
        } else {
            arrayList2.addAll(arrayList);
            resources = arrayList2;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("getResources {} {}", name, resources);
        }
        return Collections.enumeration(resources);
    }

    @Override // java.lang.ClassLoader
    public URL getResource(String name) {
        URL resource = null;
        if (this._context.isParentLoaderPriority()) {
            URL parentUrl = this._parent.getResource(name);
            if (parentUrl == null || (!Boolean.TRUE.equals(__loadServerClasses.get()) && this._context.isServerResource(name, parentUrl))) {
                URL webappUrl = findResource(name);
                if (webappUrl != null) {
                    resource = webappUrl;
                }
            } else {
                resource = parentUrl;
            }
        } else {
            URL webappUrl2 = findResource(name);
            if (webappUrl2 == null || this._context.isSystemResource(name, webappUrl2)) {
                URL parentUrl2 = this._parent.getResource(name);
                if (parentUrl2 != null && (Boolean.TRUE.equals(__loadServerClasses.get()) || !this._context.isServerResource(name, parentUrl2))) {
                    resource = parentUrl2;
                } else if (webappUrl2 != null) {
                    resource = webappUrl2;
                }
            } else {
                resource = webappUrl2;
            }
        }
        if (resource == null && name.startsWith("/")) {
            resource = getResource(name.substring(1));
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("getResource {} {}", name, resource);
        }
        return resource;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:53:0x00fe
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.lang.ClassLoader
    protected java.lang.Class<?> loadClass(java.lang.String r6, boolean r7) throws java.lang.ClassNotFoundException {
        /*
        // Method dump skipped, instructions count: 304
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.webapp.WebAppClassLoader.loadClass(java.lang.String, boolean):java.lang.Class");
    }

    @Deprecated
    public void addClassFileTransformer(ClassFileTransformer transformer) {
        this._transformers.add(transformer);
    }

    @Deprecated
    public boolean removeClassFileTransformer(ClassFileTransformer transformer) {
        return this._transformers.remove(transformer);
    }

    public void addTransformer(ClassFileTransformer transformer) {
        this._transformers.add(transformer);
    }

    public boolean removeTransformer(ClassFileTransformer transformer) {
        return this._transformers.remove(transformer);
    }

    protected Class<?> loadAsResource(String name, boolean checkSystemResource) throws ClassNotFoundException {
        Class<?> webappClass = null;
        URL webappUrl = findResource(TypeUtil.toClassReference(name));
        if (webappUrl != null && (!checkSystemResource || !this._context.isSystemResource(name, webappUrl))) {
            webappClass = foundClass(name, webappUrl);
            resolveClass(webappClass);
            if (LOG.isDebugEnabled()) {
                LOG.debug("WAP webapp loaded {}", webappClass);
            }
        }
        return webappClass;
    }

    @Override // java.net.URLClassLoader, java.lang.ClassLoader
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (this._transformers.isEmpty()) {
            return findClass(name);
        }
        URL url = findResource(TypeUtil.toClassReference(name));
        if (url != null) {
            return foundClass(name, url);
        }
        throw new ClassNotFoundException(name);
    }

    protected Class<?> foundClass(String name, URL url) throws ClassNotFoundException {
        InputStream content;
        if (this._transformers.isEmpty()) {
            return findClass(name);
        }
        try {
            content = null;
            try {
                content = url.openStream();
                byte[] bytes = C5739IO.readBytes(content);
                for (ClassFileTransformer transformer : this._transformers) {
                    byte[] tmp = transformer.transform(this, name, (Class) null, (ProtectionDomain) null, bytes);
                    if (tmp != null) {
                        bytes = tmp;
                    }
                }
                Class<?> defineClass = defineClass(name, bytes, 0, bytes.length);
                if (content != null) {
                    try {
                        content.close();
                    } catch (IOException e) {
                        throw new ClassNotFoundException(name, e);
                    }
                }
                return defineClass;
            } catch (IOException e2) {
                throw new ClassNotFoundException(name, e2);
            } catch (IllegalClassFormatException e3) {
                throw new ClassNotFoundException(name, e3);
            }
        } catch (Throwable th) {
            if (content != null) {
                try {
                    content.close();
                } catch (IOException e4) {
                    throw new ClassNotFoundException(name, e4);
                }
            }
            throw th;
        }
    }

    @Override // java.net.URLClassLoader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close();
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format("%s{%s}@%x", getClass().getSimpleName(), this._name, Integer.valueOf(hashCode()));
    }

    @Override // org.eclipse.jetty.util.ClassVisibilityChecker
    public boolean isSystemClass(Class<?> clazz) {
        return this._context.isSystemClass(clazz);
    }

    @Override // org.eclipse.jetty.util.ClassVisibilityChecker
    public boolean isServerClass(Class<?> clazz) {
        return this._context.isServerClass(clazz);
    }
}
