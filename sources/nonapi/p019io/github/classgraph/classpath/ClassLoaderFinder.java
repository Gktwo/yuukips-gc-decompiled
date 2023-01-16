package nonapi.p019io.github.classgraph.classpath;

import java.util.Iterator;
import java.util.LinkedHashSet;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.LogNode;

/* renamed from: nonapi.io.github.classgraph.classpath.ClassLoaderFinder */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classpath/ClassLoaderFinder.class */
public class ClassLoaderFinder {
    private final ClassLoader[] contextClassLoaders;

    public ClassLoader[] getContextClassLoaders() {
        return this.contextClassLoaders;
    }

    /* access modifiers changed from: package-private */
    public ClassLoaderFinder(ScanSpec scanSpec, LogNode log) {
        LogNode classLoadersFoundLog;
        LinkedHashSet<ClassLoader> classLoadersUnique;
        if (scanSpec.overrideClassLoaders == null) {
            classLoadersUnique = new LinkedHashSet<>();
            ClassLoader threadClassLoader = Thread.currentThread().getContextClassLoader();
            if (threadClassLoader != null) {
                classLoadersUnique.add(threadClassLoader);
            }
            ClassLoader currClassClassLoader = getClass().getClassLoader();
            if (currClassClassLoader != null) {
                classLoadersUnique.add(currClassClassLoader);
            }
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            if (systemClassLoader != null) {
                classLoadersUnique.add(systemClassLoader);
            }
            try {
                Class<?>[] callStack = CallStackReader.getClassContext(log);
                for (int i = callStack.length - 1; i >= 0; i--) {
                    ClassLoader callerClassLoader = callStack[i].getClassLoader();
                    if (callerClassLoader != null) {
                        classLoadersUnique.add(callerClassLoader);
                    }
                }
            } catch (IllegalArgumentException e) {
                if (log != null) {
                    log.log("Could not get call stack", e);
                }
            }
            if (scanSpec.addedClassLoaders != null) {
                classLoadersUnique.addAll(scanSpec.addedClassLoaders);
            }
            classLoadersFoundLog = log == null ? null : log.log("Found ClassLoaders:");
        } else {
            classLoadersUnique = new LinkedHashSet<>(scanSpec.overrideClassLoaders);
            classLoadersFoundLog = log == null ? null : log.log("Override ClassLoaders:");
        }
        if (classLoadersFoundLog != null) {
            Iterator<ClassLoader> it = classLoadersUnique.iterator();
            while (it.hasNext()) {
                classLoadersFoundLog.log(it.next().getClass().getName());
            }
        }
        this.contextClassLoaders = (ClassLoader[]) classLoadersUnique.toArray(new ClassLoader[0]);
    }
}
