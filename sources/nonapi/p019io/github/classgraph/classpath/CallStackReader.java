package nonapi.p019io.github.classgraph.classpath;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.VersionFinder;
import p001ch.qos.logback.core.CoreConstants;

/* access modifiers changed from: package-private */
/* renamed from: nonapi.io.github.classgraph.classpath.CallStackReader */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classpath/CallStackReader.class */
public class CallStackReader {
    private static Class<?>[] callStack;

    private CallStackReader() {
    }

    /* access modifiers changed from: private */
    public static Class<?>[] getCallStackViaStackWalker() {
        try {
            Class<?> consumerClass = Class.forName("java.util.function.Consumer");
            final List<Class<?>> stackFrameClasses = new ArrayList<>();
            Class<?> stackWalkerOptionClass = Class.forName("java.lang.StackWalker$Option");
            Object retainClassReference = Class.forName("java.lang.Enum").getMethod(CoreConstants.VALUE_OF, Class.class, String.class).invoke(null, stackWalkerOptionClass, "RETAIN_CLASS_REFERENCE");
            Class<?> stackWalkerClass = Class.forName("java.lang.StackWalker");
            Object stackWalkerInstance = stackWalkerClass.getMethod("getInstance", stackWalkerOptionClass).invoke(null, retainClassReference);
            final Method stackFrameGetDeclaringClassMethod = Class.forName("java.lang.StackWalker$StackFrame").getMethod("getDeclaringClass", new Class[0]);
            stackWalkerClass.getMethod("forEach", consumerClass).invoke(stackWalkerInstance, Proxy.newProxyInstance(consumerClass.getClassLoader(), new Class[]{consumerClass}, new InvocationHandler() { // from class: nonapi.io.github.classgraph.classpath.CallStackReader.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    stackFrameClasses.add((Class) stackFrameGetDeclaringClassMethod.invoke(args[0], new Object[0]));
                    return null;
                }
            }));
            return (Class[]) stackFrameClasses.toArray(new Class[0]);
        } catch (Exception | LinkageError e) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: nonapi.io.github.classgraph.classpath.CallStackReader$CallerResolver */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classpath/CallStackReader$CallerResolver.class */
    public static final class CallerResolver extends SecurityManager {
        private CallerResolver() {
        }

        @Override // java.lang.SecurityManager
        protected Class<?>[] getClassContext() {
            return getClassContext();
        }
    }

    /* access modifiers changed from: private */
    public static Class<?>[] getCallStackViaSecurityManager(LogNode log) {
        try {
            return new CallerResolver().getClassContext();
        } catch (SecurityException e) {
            if (log == null) {
                return null;
            }
            log.log("Exception while trying to obtain call stack via SecurityManager", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static Class<?>[] getClassContext(final LogNode log) {
        if (callStack == null) {
            if ((VersionFinder.JAVA_MAJOR_VERSION == 11 && ((VersionFinder.JAVA_MINOR_VERSION >= 1 || VersionFinder.JAVA_SUB_VERSION >= 4) && !VersionFinder.JAVA_IS_EA_VERSION)) || ((VersionFinder.JAVA_MAJOR_VERSION == 12 && ((VersionFinder.JAVA_MINOR_VERSION >= 1 || VersionFinder.JAVA_SUB_VERSION >= 2) && !VersionFinder.JAVA_IS_EA_VERSION)) || ((VersionFinder.JAVA_MAJOR_VERSION == 13 && !VersionFinder.JAVA_IS_EA_VERSION) || VersionFinder.JAVA_MAJOR_VERSION > 13))) {
                callStack = (Class[]) AccessController.doPrivileged(new PrivilegedAction<Class<?>[]>() { // from class: nonapi.io.github.classgraph.classpath.CallStackReader.2
                    @Override // java.security.PrivilegedAction
                    public Class<?>[] run() {
                        return CallStackReader.getCallStackViaStackWalker();
                    }
                });
            }
            if (callStack == null || callStack.length == 0) {
                callStack = (Class[]) AccessController.doPrivileged(new PrivilegedAction<Class<?>[]>() { // from class: nonapi.io.github.classgraph.classpath.CallStackReader.3
                    @Override // java.security.PrivilegedAction
                    public Class<?>[] run() {
                        return CallStackReader.getCallStackViaSecurityManager(log);
                    }
                });
            }
            if (callStack == null || callStack.length == 0) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace == null || stackTrace.length == 0) {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        stackTrace = e.getStackTrace();
                    }
                }
                List<Class<?>> stackClassesList = new ArrayList<>();
                for (StackTraceElement elt : stackTrace) {
                    try {
                        stackClassesList.add(Class.forName(elt.getClassName()));
                    } catch (ClassNotFoundException | LinkageError e2) {
                    }
                }
                if (!stackClassesList.isEmpty()) {
                    callStack = (Class[]) stackClassesList.toArray(new Class[0]);
                } else {
                    callStack = new Class[]{CallStackReader.class};
                }
            }
        }
        return callStack;
    }
}
