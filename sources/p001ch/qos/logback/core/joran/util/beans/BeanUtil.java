package p001ch.qos.logback.core.joran.util.beans;

import java.lang.reflect.Method;

/* renamed from: ch.qos.logback.core.joran.util.beans.BeanUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/util/beans/BeanUtil.class */
public class BeanUtil {
    public static final String PREFIX_GETTER_IS = "is";
    public static final String PREFIX_GETTER_GET = "get";
    public static final String PREFIX_SETTER = "set";
    public static final String PREFIX_ADDER = "add";

    public static boolean isAdder(Method method) {
        if (getParameterCount(method) == 1 && method.getReturnType() == Void.TYPE) {
            return method.getName().startsWith(PREFIX_ADDER);
        }
        return false;
    }

    public static boolean isGetter(Method method) {
        Class<?> returnType;
        if (getParameterCount(method) > 0 || (returnType = method.getReturnType()) == Void.TYPE) {
            return false;
        }
        String methodName = method.getName();
        if (!methodName.startsWith(PREFIX_GETTER_GET) && !methodName.startsWith(PREFIX_GETTER_IS)) {
            return false;
        }
        if (!methodName.startsWith(PREFIX_GETTER_IS) || returnType.equals(Boolean.TYPE) || returnType.equals(Boolean.class)) {
            return true;
        }
        return false;
    }

    private static int getParameterCount(Method method) {
        return method.getParameterTypes().length;
    }

    public static boolean isSetter(Method method) {
        if (getParameterCount(method) == 1 && method.getReturnType() == Void.TYPE && method.getName().startsWith("set")) {
            return true;
        }
        return false;
    }

    public static String getPropertyName(Method method) {
        String methodName = method.getName();
        String rawPropertyName = getSubstringIfPrefixMatches(methodName, PREFIX_GETTER_GET);
        if (rawPropertyName == null) {
            rawPropertyName = getSubstringIfPrefixMatches(methodName, "set");
        }
        if (rawPropertyName == null) {
            rawPropertyName = getSubstringIfPrefixMatches(methodName, PREFIX_GETTER_IS);
        }
        if (rawPropertyName == null) {
            rawPropertyName = getSubstringIfPrefixMatches(methodName, PREFIX_ADDER);
        }
        return toLowerCamelCase(rawPropertyName);
    }

    public static String toLowerCamelCase(String string) {
        if (string == null) {
            return null;
        }
        if (string.isEmpty()) {
            return string;
        }
        if (string.length() > 1 && Character.isUpperCase(string.charAt(1)) && Character.isUpperCase(string.charAt(0))) {
            return string;
        }
        char[] chars = string.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
    }

    private static String getSubstringIfPrefixMatches(String wholeString, String prefix) {
        if (wholeString.startsWith(prefix)) {
            return wholeString.substring(prefix.length());
        }
        return null;
    }
}
