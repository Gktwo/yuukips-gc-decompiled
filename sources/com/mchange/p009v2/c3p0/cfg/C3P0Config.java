package com.mchange.p009v2.c3p0.cfg;

import com.mchange.p006v1.lang.BooleanUtils;
import com.mchange.p009v2.beans.BeansUtils;
import com.mchange.p009v2.c3p0.C3P0Registry;
import com.mchange.p009v2.c3p0.impl.C3P0Defaults;
import com.mchange.p009v2.c3p0.impl.C3P0ImplUtils;
import com.mchange.p009v2.cfg.MConfig;
import com.mchange.p009v2.cfg.MultiPropertiesConfig;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import dev.morphia.mapping.Mapper;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import org.quartz.utils.PoolingConnectionProvider;

/* renamed from: com.mchange.v2.c3p0.cfg.C3P0Config */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/cfg/C3P0Config.class */
public final class C3P0Config {
    static final String PROP_STYLE_USER_OVERRIDES_PART = "user-overrides";
    static final String PROP_STYLE_EXTENSIONS_PART = "extensions";
    public static final String CFG_FINDER_CLASSNAME_KEY = "com.mchange.v2.c3p0.cfg.finder";
    public static final String DEFAULT_CONFIG_NAME = "default";
    public static final String PROPS_FILE_RSRC_PATH = "/c3p0.properties";
    private static MultiPropertiesConfig _MPCONFIG;
    private static C3P0Config _MAIN;
    NamedScope defaultConfig;
    HashMap configNamesToNamedScopes;
    static final String PROP_STYLE_NAMED_CFG_PFX = "c3p0.named-configs";
    static final int PROP_STYLE_NAMED_CFG_PFX_LEN = PROP_STYLE_NAMED_CFG_PFX.length();
    static final String PROP_STYLE_USER_OVERRIDES_PFX = "c3p0.user-overrides";
    static final int PROP_STYLE_USER_OVERRIDES_PFX_LEN = PROP_STYLE_USER_OVERRIDES_PFX.length();
    static final String PROP_STYLE_EXTENSIONS_PFX = "c3p0.extensions";
    static final int PROP_STYLE_EXTENSIONS_PFX_LEN = PROP_STYLE_EXTENSIONS_PFX.length();
    static final MLogger logger = MLog.getLogger(C3P0Config.class);
    static final Class[] SUOAS_ARGS = {String.class};
    static final Collection SKIP_BIND_PROPS = Arrays.asList("loginTimeout", "properties");

    static {
        setLibraryMultiPropertiesConfig(findLibraryMultiPropertiesConfig());
        setMainConfig(findLibraryC3P0Config(false));
        warnOnUnknownProperties(MAIN());
    }

    private static synchronized MultiPropertiesConfig MPCONFIG() {
        return _MPCONFIG;
    }

    private static synchronized C3P0Config MAIN() {
        return _MAIN;
    }

    private static synchronized void setLibraryMultiPropertiesConfig(MultiPropertiesConfig mpc) {
        _MPCONFIG = mpc;
    }

    public static Properties allCurrentProperties() {
        return MPCONFIG().getPropertiesByPrefix("");
    }

    public static synchronized void setMainConfig(C3P0Config protoMain) {
        _MAIN = protoMain;
    }

    public static synchronized void refreshMainConfig() {
        refreshMainConfig(null, null);
    }

    public static synchronized void refreshMainConfig(MultiPropertiesConfig[] overrides, String overridesDescription) {
        MultiPropertiesConfig libMpc = findLibraryMultiPropertiesConfig();
        if (overrides != null) {
            int olen = overrides.length;
            MultiPropertiesConfig[] combineMe = new MultiPropertiesConfig[olen + 1];
            combineMe[0] = libMpc;
            for (int i = 0; i < olen; i++) {
                combineMe[i + 1] = overrides[i];
            }
            setLibraryMultiPropertiesConfig(MConfig.combine(combineMe));
            setMainConfig(findLibraryC3P0Config(true));
            if (logger.isLoggable(MLevel.INFO)) {
                logger.log(MLevel.INFO, "c3p0 main configuration was refreshed, with overrides specified" + (overridesDescription == null ? Mapper.IGNORED_FIELDNAME : " - " + overridesDescription));
            }
        } else {
            setLibraryMultiPropertiesConfig(libMpc);
            setMainConfig(findLibraryC3P0Config(false));
            if (logger.isLoggable(MLevel.INFO)) {
                logger.log(MLevel.INFO, "c3p0 main configuration was refreshed, with no overrides specified (and any previous overrides removed).");
            }
        }
        C3P0Registry.markConfigRefreshed();
    }

    private static MultiPropertiesConfig findLibraryMultiPropertiesConfig() {
        return MConfig.readVmConfig(new String[]{"/mchange-commons.properties", "/mchange-log.properties"}, new String[]{"hocon:/reference,/application,/c3p0,/", "/c3p0.properties", "/"});
    }

    private static C3P0Config findLibraryC3P0Config(boolean warn_on_conflicting_overrides) {
        C3P0Config protoMain;
        String cname = MPCONFIG().getProperty(CFG_FINDER_CLASSNAME_KEY);
        C3P0ConfigFinder cfgFinder = null;
        if (cname != null) {
            try {
                cfgFinder = (C3P0ConfigFinder) Class.forName(cname).newInstance();
            } catch (Exception e) {
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.log(MLevel.WARNING, "Could not load specified C3P0ConfigFinder class'" + cname + "'.", (Throwable) e);
                }
            }
        }
        if (cfgFinder == null) {
            try {
                Class.forName("org.w3c.dom.Node");
                Class.forName("com.mchange.v2.c3p0.cfg.C3P0ConfigXmlUtils");
                cfgFinder = new DefaultC3P0ConfigFinder(warn_on_conflicting_overrides);
            } catch (Exception e2) {
                if (e2 instanceof ClassNotFoundException) {
                    if (logger.isLoggable(MLevel.WARNING)) {
                        logger.log(MLevel.WARNING, "XML configuration disabled! Verify that standard XML libs are available.", (Throwable) e2);
                    }
                } else if (logger.isLoggable(MLevel.SEVERE)) {
                    logger.log(MLevel.SEVERE, "An error occurred while trying to parse the XML configuration!");
                    logger.log(MLevel.SEVERE, "XML CONFIGURATION IGNORED!", (Throwable) e2);
                }
                HashMap flatDefaults = C3P0ConfigUtils.extractHardcodedC3P0Defaults();
                flatDefaults.putAll(C3P0ConfigUtils.extractC3P0PropertiesResources());
                protoMain = C3P0ConfigUtils.configFromFlatDefaults(flatDefaults);
            }
        }
        protoMain = cfgFinder.findConfig();
        HashMap propStyleConfigNamesToNamedScopes = findPropStyleNamedScopes();
        HashMap cfgFoundConfigNamesToNamedScopes = protoMain.configNamesToNamedScopes;
        HashMap mergedConfigNamesToNamedScopes = new HashMap();
        HashSet allConfigNames = new HashSet(cfgFoundConfigNamesToNamedScopes.keySet());
        allConfigNames.addAll(propStyleConfigNamesToNamedScopes.keySet());
        Iterator ii = allConfigNames.iterator();
        while (ii.hasNext()) {
            String cfgName = (String) ii.next();
            NamedScope cfgFound = (NamedScope) cfgFoundConfigNamesToNamedScopes.get(cfgName);
            NamedScope propStyle = (NamedScope) propStyleConfigNamesToNamedScopes.get(cfgName);
            if (cfgFound != null && propStyle != null) {
                mergedConfigNamesToNamedScopes.put(cfgName, cfgFound.mergedOver(propStyle));
            } else if (cfgFound != null && propStyle == null) {
                mergedConfigNamesToNamedScopes.put(cfgName, cfgFound);
            } else if (cfgFound != null || propStyle == null) {
                throw new AssertionError("Huh? allConfigNames is the union, every name should be in one of the two maps.");
            } else {
                mergedConfigNamesToNamedScopes.put(cfgName, propStyle);
            }
        }
        return new C3P0Config(new NamedScope(protoMain.defaultConfig.props, NamedScope.mergeUserNamesToOverrides(protoMain.defaultConfig.userNamesToOverrides, findPropStyleUserOverridesDefaultConfig()), NamedScope.mergeExtensions(protoMain.defaultConfig.extensions, findPropStyleExtensionsDefaultConfig())), mergedConfigNamesToNamedScopes);
    }

    private static void warnOnUnknownProperties(C3P0Config cfg) {
        warnOnUnknownProperties(cfg.defaultConfig);
        for (NamedScope namedScope : cfg.configNamesToNamedScopes.values()) {
            warnOnUnknownProperties(namedScope);
        }
    }

    private static void warnOnUnknownProperties(NamedScope scope) {
        warnOnUnknownProperties(scope.props);
        for (Map map : scope.userNamesToOverrides.values()) {
            warnOnUnknownProperties(map);
        }
    }

    private static void warnOnUnknownProperties(Map propMap) {
        for (String prop : propMap.keySet()) {
            if (!C3P0Defaults.isKnownProperty(prop) && logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "Unknown c3p0-config property: " + prop);
            }
        }
    }

    public static String getPropsFileConfigProperty(String prop) {
        return MPCONFIG().getProperty(prop);
    }

    /* access modifiers changed from: package-private */
    public static Properties findResourceProperties() {
        return MPCONFIG().getPropertiesByResourcePath("/c3p0.properties");
    }

    /* access modifiers changed from: package-private */
    public static Properties findAllOneLevelC3P0Properties() {
        Properties out = MPCONFIG().getPropertiesByPrefix(PoolingConnectionProvider.POOLING_PROVIDER_C3P0);
        Iterator ii = out.keySet().iterator();
        while (ii.hasNext()) {
            if (((String) ii.next()).lastIndexOf(46) > 4) {
                ii.remove();
            }
        }
        return out;
    }

    static HashMap findPropStyleUserOverridesDefaultConfig() {
        HashMap userNamesToOverrides = new HashMap();
        Properties props = MPCONFIG().getPropertiesByPrefix(PROP_STYLE_USER_OVERRIDES_PFX);
        for (String fullKey : props.keySet()) {
            String userProp = fullKey.substring(PROP_STYLE_USER_OVERRIDES_PFX_LEN + 1);
            int dot_index = userProp.indexOf(46);
            if (dot_index >= 0) {
                String user = userProp.substring(0, dot_index);
                String propName = userProp.substring(dot_index + 1);
                HashMap userOverridesMap = (HashMap) userNamesToOverrides.get(user);
                if (userOverridesMap == null) {
                    userOverridesMap = new HashMap();
                    userNamesToOverrides.put(user, userOverridesMap);
                }
                userOverridesMap.put(propName, props.get(fullKey));
            } else if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "Bad specification of user-override property '" + fullKey + "', propfile key should look like '" + PROP_STYLE_USER_OVERRIDES_PFX + ".<user>.<property>'. Ignoring.");
            }
        }
        return userNamesToOverrides;
    }

    static HashMap findPropStyleExtensionsDefaultConfig() {
        HashMap extensions = new HashMap();
        Properties props = MPCONFIG().getPropertiesByPrefix(PROP_STYLE_EXTENSIONS_PFX);
        for (String fullKey : props.keySet()) {
            extensions.put(fullKey.substring(PROP_STYLE_EXTENSIONS_PFX_LEN + 1), props.get(fullKey));
        }
        return extensions;
    }

    static HashMap findPropStyleNamedScopes() {
        HashMap namesToNamedScopes = new HashMap();
        Properties props = MPCONFIG().getPropertiesByPrefix(PROP_STYLE_NAMED_CFG_PFX);
        for (String fullKey : props.keySet()) {
            String nameProp = fullKey.substring(PROP_STYLE_NAMED_CFG_PFX_LEN + 1);
            int dot_index = nameProp.indexOf(46);
            if (dot_index >= 0) {
                String configName = nameProp.substring(0, dot_index);
                String propName = nameProp.substring(dot_index + 1);
                NamedScope scope = (NamedScope) namesToNamedScopes.get(configName);
                if (scope == null) {
                    scope = new NamedScope();
                    namesToNamedScopes.put(configName, scope);
                }
                int second_dot_index = propName.indexOf(46);
                if (second_dot_index < 0) {
                    scope.props.put(propName, props.get(fullKey));
                } else if (propName.startsWith(PROP_STYLE_USER_OVERRIDES_PART)) {
                    int third_dot_index = propName.substring(second_dot_index + 1).indexOf(46);
                    if (third_dot_index < 0 && logger.isLoggable(MLevel.WARNING)) {
                        logger.log(MLevel.WARNING, "Misformatted user-override property; missing user or property name: " + propName);
                    }
                    String user = propName.substring(second_dot_index + 1, third_dot_index);
                    String userPropName = propName.substring(third_dot_index + 1);
                    HashMap userOverridesMap = (HashMap) scope.userNamesToOverrides.get(user);
                    if (userOverridesMap == null) {
                        userOverridesMap = new HashMap();
                        scope.userNamesToOverrides.put(user, userOverridesMap);
                    }
                    userOverridesMap.put(userPropName, props.get(fullKey));
                } else if (propName.startsWith(PROP_STYLE_EXTENSIONS_PART)) {
                    scope.extensions.put(propName.substring(second_dot_index + 1), props.get(fullKey));
                } else if (logger.isLoggable(MLevel.WARNING)) {
                    logger.log(MLevel.WARNING, "Unexpected compound property, ignored: " + propName);
                }
            } else if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "Bad specification of named config property '" + fullKey + "', propfile key should look like '" + PROP_STYLE_NAMED_CFG_PFX + ".<cfgname>.<property>' or '" + PROP_STYLE_NAMED_CFG_PFX + ".<cfgname>.user-overrides.<user>.<property>'. Ignoring.");
            }
        }
        return namesToNamedScopes;
    }

    public static String getUnspecifiedUserProperty(String propKey, String configName) {
        String out = null;
        if (configName == null) {
            out = (String) MAIN().defaultConfig.props.get(propKey);
        } else {
            NamedScope named = (NamedScope) MAIN().configNamesToNamedScopes.get(configName);
            if (named != null) {
                out = (String) named.props.get(propKey);
            } else {
                logger.warning("named-config with name '" + configName + "' does not exist. Using default-config for property '" + propKey + "'.");
            }
            if (out == null) {
                out = (String) MAIN().defaultConfig.props.get(propKey);
            }
        }
        return out;
    }

    public static Map getExtensions(String configName) {
        HashMap raw = MAIN().defaultConfig.extensions;
        if (configName != null) {
            NamedScope named = (NamedScope) MAIN().configNamesToNamedScopes.get(configName);
            if (named != null) {
                raw = named.extensions;
            } else {
                logger.warning("named-config with name '" + configName + "' does not exist. Using default-config extensions.");
            }
        }
        return Collections.unmodifiableMap(raw);
    }

    public static Map getUnspecifiedUserProperties(String configName) {
        Map out = new HashMap();
        out.putAll(MAIN().defaultConfig.props);
        if (configName != null) {
            NamedScope named = (NamedScope) MAIN().configNamesToNamedScopes.get(configName);
            if (named != null) {
                out.putAll(named.props);
            } else {
                logger.warning("named-config with name '" + configName + "' does not exist. Using default-config.");
            }
        }
        return out;
    }

    public static Map getUserOverrides(String configName) {
        Map out = new HashMap();
        NamedScope namedConfigScope = null;
        if (configName != null) {
            namedConfigScope = (NamedScope) MAIN().configNamesToNamedScopes.get(configName);
        }
        out.putAll(MAIN().defaultConfig.userNamesToOverrides);
        if (namedConfigScope != null) {
            out.putAll(namedConfigScope.userNamesToOverrides);
        }
        if (out.isEmpty()) {
            return null;
        }
        return out;
    }

    public static String getUserOverridesAsString(String configName) throws IOException {
        Map userOverrides = getUserOverrides(configName);
        if (userOverrides == null) {
            return null;
        }
        return C3P0ImplUtils.createUserOverridesAsString(userOverrides).intern();
    }

    public static void bindUserOverridesAsString(Object bean, String uoas) throws Exception {
        bean.getClass().getMethod("setUserOverridesAsString", SUOAS_ARGS).invoke(bean, uoas);
    }

    public static void bindUserOverridesToBean(Object bean, String configName) throws Exception {
        bindUserOverridesAsString(bean, getUserOverridesAsString(configName));
    }

    public static void bindNamedConfigToBean(Object bean, String configName, boolean shouldBindUserOverridesAsString) throws IntrospectionException {
        Map defaultUserProps = getUnspecifiedUserProperties(configName);
        Map extensions = getExtensions(configName);
        Map union = new HashMap();
        union.putAll(defaultUserProps);
        union.put(PROP_STYLE_EXTENSIONS_PART, extensions);
        BeansUtils.overwriteAccessiblePropertiesFromMap(union, bean, false, SKIP_BIND_PROPS, true, MLevel.FINEST, MLevel.WARNING, false);
        if (shouldBindUserOverridesAsString) {
            try {
                bindUserOverridesToBean(bean, configName);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.log(MLevel.WARNING, "An exception occurred while trying to bind user overrides for named config '" + configName + "'. Only default user configs will be used.", (Throwable) e2);
                }
            }
        }
    }

    public static String initializeUserOverridesAsString() {
        try {
            return getUserOverridesAsString(null);
        } catch (Exception e) {
            if (!logger.isLoggable(MLevel.WARNING)) {
                return null;
            }
            logger.log(MLevel.WARNING, "Error initializing default user overrides. User overrides may be ignored.", (Throwable) e);
            return null;
        }
    }

    public static Map initializeExtensions() {
        return getExtensions(null);
    }

    public static String initializeStringPropertyVar(String propKey, String dflt) {
        String out = getUnspecifiedUserProperty(propKey, null);
        if (out == null) {
            out = dflt;
        }
        return out;
    }

    public static int initializeIntPropertyVar(String propKey, int dflt) {
        boolean set = false;
        int out = -1;
        String outStr = getUnspecifiedUserProperty(propKey, null);
        if (outStr != null) {
            try {
                out = Integer.parseInt(outStr.trim());
                set = true;
            } catch (NumberFormatException e) {
                logger.info("'" + outStr + "' is not a legal value for property '" + propKey + "'. Using default value: " + dflt);
            }
        }
        if (!set) {
            out = dflt;
        }
        return out;
    }

    public static boolean initializeBooleanPropertyVar(String propKey, boolean dflt) {
        boolean set = false;
        boolean out = false;
        String outStr = getUnspecifiedUserProperty(propKey, null);
        if (outStr != null) {
            try {
                out = BooleanUtils.parseBoolean(outStr.trim());
                set = true;
            } catch (IllegalArgumentException e) {
                logger.info("'" + outStr + "' is not a legal value for property '" + propKey + "'. Using default value: " + dflt);
            }
        }
        if (!set) {
            out = dflt;
        }
        return out;
    }

    public static MultiPropertiesConfig getMultiPropertiesConfig() {
        return MPCONFIG();
    }

    /* access modifiers changed from: package-private */
    public C3P0Config(NamedScope defaultConfig, HashMap configNamesToNamedScopes) {
        this.defaultConfig = defaultConfig;
        this.configNamesToNamedScopes = configNamesToNamedScopes;
    }
}
