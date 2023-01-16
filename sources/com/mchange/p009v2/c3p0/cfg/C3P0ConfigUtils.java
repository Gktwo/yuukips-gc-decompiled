package com.mchange.p009v2.c3p0.cfg;

import com.mchange.p009v2.c3p0.impl.C3P0Defaults;
import com.mchange.p009v2.lang.Coerce;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* renamed from: com.mchange.v2.c3p0.cfg.C3P0ConfigUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/cfg/C3P0ConfigUtils.class */
public final class C3P0ConfigUtils {
    public static final String PROPS_FILE_RSRC_PATH = "/c3p0.properties";
    public static final String PROPS_FILE_PROP_PFX = "c3p0.";
    public static final int PROPS_FILE_PROP_PFX_LEN = 5;
    private static final String[] MISSPELL_PFXS = {"/c3pO", "/c3po", "/C3P0", "/C3PO"};
    static final MLogger logger = MLog.getLogger(C3P0ConfigUtils.class);

    static {
        if (logger.isLoggable(MLevel.WARNING) && C3P0ConfigUtils.class.getResource("/c3p0.properties") == null) {
            for (int i = 0; i < MISSPELL_PFXS.length; i++) {
                String str = MISSPELL_PFXS[i] + ".properties";
                if (C3P0ConfigUtils.class.getResource(MISSPELL_PFXS[i] + ".properties") != null) {
                    logger.warning("POSSIBLY MISSPELLED c3p0.properties CONFIG RESOURCE FOUND. Please ensure the file name is c3p0.properties, all lower case, with the digit 0 (NOT the letter O) in c3p0. It should be placed  in the top level of c3p0's effective classpath.");
                    return;
                }
            }
        }
    }

    public static HashMap extractHardcodedC3P0Defaults(boolean stringify_coercibles) {
        HashMap out = new HashMap();
        try {
            Method[] methods = C3P0Defaults.class.getMethods();
            for (Method m : methods) {
                int mods = m.getModifiers();
                if (!((mods & 1) == 0 || (mods & 8) == 0 || m.getParameterTypes().length != 0)) {
                    Object val = m.invoke(null, null);
                    if (val != null) {
                        out.put(m.getName(), (!stringify_coercibles || !Coerce.canCoerce(val)) ? val : String.valueOf(val));
                    }
                }
            }
        } catch (Exception e) {
            logger.log(MLevel.WARNING, "Failed to extract hardcoded default config!?", (Throwable) e);
        }
        return out;
    }

    public static HashMap extractHardcodedC3P0Defaults() {
        return extractHardcodedC3P0Defaults(true);
    }

    public static HashMap extractC3P0PropertiesResources() {
        HashMap out = new HashMap();
        Properties props = findAllOneLevelC3P0Properties();
        for (String key : props.keySet()) {
            String val = (String) props.get(key);
            if (key.startsWith(PROPS_FILE_PROP_PFX)) {
                out.put(key.substring(5).trim(), val.trim());
            }
        }
        return out;
    }

    public static C3P0Config configFromFlatDefaults(HashMap flatDefaults) {
        NamedScope defaults = new NamedScope();
        defaults.props.putAll(flatDefaults);
        return new C3P0Config(defaults, new HashMap());
    }

    public static String getPropsFileConfigProperty(String prop) {
        return C3P0Config.getPropsFileConfigProperty(prop);
    }

    public static Properties findResourceProperties() {
        return C3P0Config.findResourceProperties();
    }

    private static Properties findAllOneLevelC3P0Properties() {
        return C3P0Config.findAllOneLevelC3P0Properties();
    }

    /* access modifiers changed from: package-private */
    public static Properties findAllC3P0SystemProperties() {
        Properties out = new Properties();
        try {
            for (String key : C3P0Defaults.getKnownProperties(null)) {
                String value = System.getProperty(PROPS_FILE_PROP_PFX + key);
                if (value != null && value.trim().length() > 0) {
                    out.put(key, value);
                }
            }
        } catch (SecurityException e) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "A SecurityException occurred while trying to read c3p0 System properties. c3p0 configuration set via System properties may be ignored!", (Throwable) e);
            }
        }
        return out;
    }

    public static Object extractUserOverride(String propName, String userName, Map userOverrides) {
        Map specificUserOverrides = (Map) userOverrides.get(userName);
        if (specificUserOverrides != null) {
            return specificUserOverrides.get(propName);
        }
        return null;
    }

    public static Boolean extractBooleanOverride(String propName, String userName, Map userOverrides) {
        Object check = extractUserOverride(propName, userName, userOverrides);
        if (check == null || (check instanceof Boolean)) {
            return (Boolean) check;
        }
        if (check instanceof String) {
            return Boolean.valueOf((String) check);
        }
        throw new ClassCastException("Parameter '" + propName + "' as overridden for user '" + userName + "' is " + check + ", which cannot be converted to Boolean.");
    }

    private C3P0ConfigUtils() {
    }
}
