package nonapi.p019io.github.classgraph.classloaderhandler;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;
import net.bytebuddy.implementation.MethodDelegation;
import nonapi.p019io.github.classgraph.classpath.ClassLoaderOrder;
import nonapi.p019io.github.classgraph.classpath.ClasspathOrder;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.ReflectionUtils;
import org.jline.builtins.Tmux;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* renamed from: nonapi.io.github.classgraph.classloaderhandler.EquinoxClassLoaderHandler */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classloaderhandler/EquinoxClassLoaderHandler.class */
class EquinoxClassLoaderHandler implements ClassLoaderHandler {
    private static boolean alreadyReadSystemBundles;
    private static final String[] FIELD_NAMES = {"cp", "nestedDirName"};

    private EquinoxClassLoaderHandler() {
    }

    public static boolean canHandle(Class<?> classLoaderClass, LogNode log) {
        return "org.eclipse.osgi.internal.loader.EquinoxClassLoader".equals(classLoaderClass.getName());
    }

    public static void findClassLoaderOrder(ClassLoader classLoader, ClassLoaderOrder classLoaderOrder, LogNode log) {
        classLoaderOrder.delegateTo(classLoader.getParent(), true, log);
        classLoaderOrder.add(classLoader, log);
    }

    private static void addBundleFile(Object bundlefile, Set<Object> path, ClassLoader classLoader, ClasspathOrder classpathOrderOut, ScanSpec scanSpec, LogNode log) {
        Object baseBundleFile;
        if (bundlefile != null && path.add(bundlefile)) {
            Object baseFile = ReflectionUtils.getFieldVal(bundlefile, "basefile", false);
            if (baseFile != null) {
                boolean foundClassPathElement = false;
                String[] strArr = FIELD_NAMES;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Object fieldVal = ReflectionUtils.getFieldVal(bundlefile, strArr[i], false);
                    if (fieldVal != null) {
                        foundClassPathElement = true;
                        Object base = baseFile;
                        String sep = "/";
                        if (bundlefile.getClass().getName().equals("org.eclipse.osgi.storage.bundlefile.NestedDirBundleFile") && (baseBundleFile = ReflectionUtils.getFieldVal(bundlefile, "baseBundleFile", false)) != null && baseBundleFile.getClass().getName().equals("org.eclipse.osgi.storage.bundlefile.ZipBundleFile")) {
                            base = baseBundleFile;
                            sep = "!/";
                        }
                        classpathOrderOut.addClasspathEntry(base.toString() + sep + fieldVal.toString(), classLoader, scanSpec, log);
                    } else {
                        i++;
                    }
                }
                if (!foundClassPathElement) {
                    classpathOrderOut.addClasspathEntry(baseFile.toString(), classLoader, scanSpec, log);
                }
            }
            addBundleFile(ReflectionUtils.getFieldVal(bundlefile, "wrapped", false), path, classLoader, classpathOrderOut, scanSpec, log);
            addBundleFile(ReflectionUtils.getFieldVal(bundlefile, Tmux.CMD_NEXT, false), path, classLoader, classpathOrderOut, scanSpec, log);
        }
    }

    private static void addClasspathEntries(Object owner, ClassLoader classLoader, ClasspathOrder classpathOrderOut, ScanSpec scanSpec, LogNode log) {
        Object entries = ReflectionUtils.getFieldVal(owner, "entries", false);
        if (entries != null) {
            int n = Array.getLength(entries);
            for (int i = 0; i < n; i++) {
                addBundleFile(ReflectionUtils.getFieldVal(Array.get(entries, i), "bundlefile", false), new HashSet(), classLoader, classpathOrderOut, scanSpec, log);
            }
        }
    }

    public static void findClasspathOrder(ClassLoader classLoader, ClasspathOrder classpathOrder, ScanSpec scanSpec, LogNode log) {
        int fileIdx;
        Object manager = ReflectionUtils.getFieldVal(classLoader, "manager", false);
        addClasspathEntries(manager, classLoader, classpathOrder, scanSpec, log);
        Object fragments = ReflectionUtils.getFieldVal(manager, "fragments", false);
        if (fragments != null) {
            int fragLength = Array.getLength(fragments);
            for (int f = 0; f < fragLength; f++) {
                addClasspathEntries(Array.get(fragments, f), classLoader, classpathOrder, scanSpec, log);
            }
        }
        if (!alreadyReadSystemBundles) {
            Object bundles = ReflectionUtils.invokeMethod(ReflectionUtils.invokeMethod(ReflectionUtils.invokeMethod(ReflectionUtils.invokeMethod(ReflectionUtils.getFieldVal(ReflectionUtils.getFieldVal(ReflectionUtils.getFieldVal(ReflectionUtils.getFieldVal(ReflectionUtils.getFieldVal(ReflectionUtils.getFieldVal(classLoader, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, false), "container", false), "storage", false), "moduleContainer", false), "moduleDatabase", false), "modulesById", false), BeanUtil.PREFIX_GETTER_GET, Object.class, 0L, false), "getBundle", false), "getBundleContext", false), "getBundles", false);
            if (bundles != null) {
                int n = Array.getLength(bundles);
                for (int i = 0; i < n; i++) {
                    String location = (String) ReflectionUtils.getFieldVal(ReflectionUtils.getFieldVal(Array.get(bundles, i), "module", false), "location", false);
                    if (location != null && (fileIdx = location.indexOf("file:")) >= 0) {
                        classpathOrder.addClasspathEntry(location.substring(fileIdx), classLoader, scanSpec, log);
                    }
                }
            }
            alreadyReadSystemBundles = true;
        }
    }
}
