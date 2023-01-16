package org.jline.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Objects;
import org.jline.console.Printer;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/Signals.class */
public final class Signals {
    private Signals() {
    }

    public static Object register(String name, Runnable handler) {
        Objects.requireNonNull(handler);
        return register(name, handler, handler.getClass().getClassLoader());
    }

    public static Object register(String name, Runnable handler, ClassLoader loader) {
        try {
            Class<?> signalHandlerClass = Class.forName("sun.misc.SignalHandler");
            return doRegister(name, Proxy.newProxyInstance(loader, new Class[]{signalHandlerClass}, proxy, method, args -> {
                if (method.getDeclaringClass() == Object.class) {
                    if (Printer.TO_STRING.equals(method.getName())) {
                        return handler.toString();
                    }
                    return null;
                } else if (method.getDeclaringClass() != signalHandlerClass) {
                    return null;
                } else {
                    Log.trace(() -> {
                        return "Calling handler " + toString(handler) + " for signal " + name;
                    });
                    handler.run();
                    return null;
                }
            }));
        } catch (Exception e) {
            Log.debug("Error registering handler for signal ", name, e);
            return null;
        }
    }

    public static Object registerDefault(String name) {
        try {
            return doRegister(name, Class.forName("sun.misc.SignalHandler").getField("SIG_DFL").get(null));
        } catch (Exception e) {
            Log.debug("Error registering default handler for signal ", name, e);
            return null;
        }
    }

    public static void unregister(String name, Object previous) {
        if (previous != null) {
            try {
                doRegister(name, previous);
            } catch (Exception e) {
                Log.debug("Error unregistering handler for signal ", name, e);
            }
        }
    }

    private static Object doRegister(String name, Object handler) throws Exception {
        Log.trace(() -> {
            return "Registering signal " + name + " with handler " + toString(handler);
        });
        Class<?> signalClass = Class.forName("sun.misc.Signal");
        try {
            return signalClass.getMethod("handle", signalClass, Class.forName("sun.misc.SignalHandler")).invoke(null, signalClass.getConstructor(String.class).newInstance(name), handler);
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof IllegalArgumentException) {
                Log.trace(() -> {
                    return "Ignoring unsupported signal " + name;
                });
                return null;
            }
            Log.debug("Error registering handler for signal ", name, e);
            return null;
        }
    }

    private static String toString(Object handler) {
        Class<?> signalHandlerClass;
        try {
            signalHandlerClass = Class.forName("sun.misc.SignalHandler");
        } catch (Throwable th) {
        }
        if (handler == signalHandlerClass.getField("SIG_DFL").get(null)) {
            return "SIG_DFL";
        }
        if (handler == signalHandlerClass.getField("SIG_IGN").get(null)) {
            return "SIG_IGN";
        }
        return handler != null ? handler.toString() : "null";
    }
}
