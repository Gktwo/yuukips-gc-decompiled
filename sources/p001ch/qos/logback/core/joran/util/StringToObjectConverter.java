package p001ch.qos.logback.core.joran.util;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.spi.ContextAware;

/* renamed from: ch.qos.logback.core.joran.util.StringToObjectConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/util/StringToObjectConverter.class */
public class StringToObjectConverter {
    private static final Class<?>[] STING_CLASS_PARAMETER = {String.class};

    public static boolean canBeBuiltFromSimpleString(Class<?> parameterClass) {
        Package p = parameterClass.getPackage();
        if (parameterClass.isPrimitive()) {
            return true;
        }
        if ((p == null || !"java.lang".equals(p.getName())) && !followsTheValueOfConvention(parameterClass) && !parameterClass.isEnum() && !isOfTypeCharset(parameterClass)) {
            return false;
        }
        return true;
    }

    public static Object convertArg(ContextAware ca, String val, Class<?> type) {
        if (val == null) {
            return null;
        }
        String v = val.trim();
        if (String.class.isAssignableFrom(type)) {
            return v;
        }
        if (Integer.TYPE.isAssignableFrom(type)) {
            return new Integer(v);
        }
        if (Long.TYPE.isAssignableFrom(type)) {
            return new Long(v);
        }
        if (Float.TYPE.isAssignableFrom(type)) {
            return new Float(v);
        }
        if (Double.TYPE.isAssignableFrom(type)) {
            return new Double(v);
        }
        if (Boolean.TYPE.isAssignableFrom(type)) {
            if (C3P0Substitutions.DEBUG.equalsIgnoreCase(v)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(v)) {
                return Boolean.FALSE;
            }
            return null;
        } else if (type.isEnum()) {
            return convertToEnum(ca, v, type);
        } else {
            if (followsTheValueOfConvention(type)) {
                return convertByValueOfMethod(ca, type, v);
            }
            if (isOfTypeCharset(type)) {
                return convertToCharset(ca, val);
            }
            return null;
        }
    }

    private static boolean isOfTypeCharset(Class<?> type) {
        return Charset.class.isAssignableFrom(type);
    }

    private static Charset convertToCharset(ContextAware ca, String val) {
        try {
            return Charset.forName(val);
        } catch (UnsupportedCharsetException e) {
            ca.addError("Failed to get charset [" + val + "]", e);
            return null;
        }
    }

    public static Method getValueOfMethod(Class<?> type) {
        try {
            return type.getMethod(CoreConstants.VALUE_OF, STING_CLASS_PARAMETER);
        } catch (NoSuchMethodException e) {
            return null;
        } catch (SecurityException e2) {
            return null;
        }
    }

    private static boolean followsTheValueOfConvention(Class<?> parameterClass) {
        Method valueOfMethod = getValueOfMethod(parameterClass);
        if (valueOfMethod == null) {
            return false;
        }
        return Modifier.isStatic(valueOfMethod.getModifiers());
    }

    private static Object convertByValueOfMethod(ContextAware ca, Class<?> type, String val) {
        try {
            return type.getMethod(CoreConstants.VALUE_OF, STING_CLASS_PARAMETER).invoke(null, val);
        } catch (Exception e) {
            ca.addError("Failed to invoke valueOf{} method in class [" + type.getName() + "] with value [" + val + "]");
            return null;
        }
    }

    private static Object convertToEnum(ContextAware ca, String val, Class<? extends Enum> enumType) {
        return Enum.valueOf(enumType, val);
    }

    boolean isBuildableFromSimpleString() {
        return false;
    }
}
