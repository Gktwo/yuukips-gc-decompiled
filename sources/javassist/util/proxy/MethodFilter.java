package javassist.util.proxy;

import java.lang.reflect.Method;

/* loaded from: grasscutter.jar:javassist/util/proxy/MethodFilter.class */
public interface MethodFilter {
    boolean isHandled(Method method);
}
