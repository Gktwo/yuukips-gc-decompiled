package p001ch.qos.logback.core.util;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.util.Properties;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.spi.ContextAware;
import p001ch.qos.logback.core.spi.PropertyContainer;
import p001ch.qos.logback.core.spi.ScanException;
import p001ch.qos.logback.core.subst.NodeToStringTransformer;

/* renamed from: ch.qos.logback.core.util.OptionHelper */
/* loaded from: grasscutter.jar:ch/qos/logback/core/util/OptionHelper.class */
public class OptionHelper {
    static final String DELIM_START = "${";
    static final char DELIM_STOP = '}';
    static final String DELIM_DEFAULT = ":-";
    static final int DELIM_START_LEN = 2;
    static final int DELIM_STOP_LEN = 1;
    static final int DELIM_DEFAULT_LEN = 2;
    static final String _IS_UNDEFINED = "_IS_UNDEFINED";

    public static Object instantiateByClassName(String className, Class<?> superClass, Context context) throws IncompatibleClassException, DynamicClassLoadingException {
        return instantiateByClassName(className, superClass, Loader.getClassLoaderOfObject(context));
    }

    public static Object instantiateByClassNameAndParameter(String className, Class<?> superClass, Context context, Class<?> type, Object param) throws IncompatibleClassException, DynamicClassLoadingException {
        return instantiateByClassNameAndParameter(className, superClass, Loader.getClassLoaderOfObject(context), type, param);
    }

    public static Object instantiateByClassName(String className, Class<?> superClass, ClassLoader classLoader) throws IncompatibleClassException, DynamicClassLoadingException {
        return instantiateByClassNameAndParameter(className, superClass, classLoader, (Class<?>) null, (Object) null);
    }

    public static Object instantiateByClassNameAndParameter(String className, Class<?> superClass, ClassLoader classLoader, Class<?> type, Object parameter) throws IncompatibleClassException, DynamicClassLoadingException {
        if (className == null) {
            throw new NullPointerException();
        }
        try {
            Class<?> classObj = classLoader.loadClass(className);
            if (!superClass.isAssignableFrom(classObj)) {
                throw new IncompatibleClassException(superClass, classObj);
            } else if (type == null) {
                return classObj.newInstance();
            } else {
                return classObj.getConstructor(type).newInstance(parameter);
            }
        } catch (IncompatibleClassException ice) {
            throw ice;
        } catch (Throwable t) {
            throw new DynamicClassLoadingException("Failed to instantiate type " + className, t);
        }
    }

    public static String substVars(String val, PropertyContainer pc1) {
        return substVars(val, pc1, null);
    }

    public static String substVars(String input, PropertyContainer pc0, PropertyContainer pc1) {
        try {
            return NodeToStringTransformer.substituteVariable(input, pc0, pc1);
        } catch (ScanException e) {
            throw new IllegalArgumentException("Failed to parse input [" + input + "]", e);
        }
    }

    public static String propertyLookup(String key, PropertyContainer pc1, PropertyContainer pc2) {
        String value = pc1.getProperty(key);
        if (value == null && pc2 != null) {
            value = pc2.getProperty(key);
        }
        if (value == null) {
            value = getSystemProperty(key, null);
        }
        if (value == null) {
            value = getEnv(key);
        }
        return value;
    }

    public static String getSystemProperty(String key, String def) {
        try {
            return System.getProperty(key, def);
        } catch (SecurityException e) {
            return def;
        }
    }

    public static String getEnv(String key) {
        try {
            return System.getenv(key);
        } catch (SecurityException e) {
            return null;
        }
    }

    public static String getSystemProperty(String key) {
        try {
            return System.getProperty(key);
        } catch (SecurityException e) {
            return null;
        }
    }

    public static void setSystemProperties(ContextAware contextAware, Properties props) {
        for (String key : props.keySet()) {
            setSystemProperty(contextAware, key, props.getProperty(key));
        }
    }

    public static void setSystemProperty(ContextAware contextAware, String key, String value) {
        try {
            System.setProperty(key, value);
        } catch (SecurityException e) {
            contextAware.addError("Failed to set system property [" + key + "]", e);
        }
    }

    public static Properties getSystemProperties() {
        try {
            return System.getProperties();
        } catch (SecurityException e) {
            return new Properties();
        }
    }

    public static String[] extractDefaultReplacement(String key) {
        String[] result = new String[2];
        if (key == null) {
            return result;
        }
        result[0] = key;
        int d = key.indexOf(":-");
        if (d != -1) {
            result[0] = key.substring(0, d);
            result[1] = key.substring(d + 2);
        }
        return result;
    }

    public static boolean toBoolean(String value, boolean dEfault) {
        if (value == null) {
            return dEfault;
        }
        String trimmedVal = value.trim();
        if (C3P0Substitutions.DEBUG.equalsIgnoreCase(trimmedVal)) {
            return true;
        }
        if ("false".equalsIgnoreCase(trimmedVal)) {
            return false;
        }
        return dEfault;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
