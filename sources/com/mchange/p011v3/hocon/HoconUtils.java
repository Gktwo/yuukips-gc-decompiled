package com.mchange.p011v3.hocon;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* renamed from: com.mchange.v3.hocon.HoconUtils */
/* loaded from: grasscutter.jar:com/mchange/v3/hocon/HoconUtils.class */
public final class HoconUtils {
    private static final String APPLICATION = "application";

    /* renamed from: com.mchange.v3.hocon.HoconUtils$PropertiesConversion */
    /* loaded from: grasscutter.jar:com/mchange/v3/hocon/HoconUtils$PropertiesConversion.class */
    public static class PropertiesConversion {
        Properties properties;
        Set<String> unrenderable;
    }

    public static PropertiesConversion configToProperties(Config config) {
        Set<Map.Entry> entrySet = config.entrySet();
        Properties properties = new Properties();
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : entrySet) {
            String str = (String) entry.getKey();
            String str2 = null;
            try {
                str2 = config.getString(str);
            } catch (ConfigException.WrongType e) {
                hashSet.add(str);
            }
            if (str2 != null) {
                properties.setProperty(str, str2);
            }
        }
        PropertiesConversion propertiesConversion = new PropertiesConversion();
        propertiesConversion.properties = properties;
        propertiesConversion.unrenderable = hashSet;
        return propertiesConversion;
    }

    public static Config applicationOrStandardSubstitute(ClassLoader classLoader) throws SubstituteNotAvailableException {
        String str = APPLICATION;
        Config config = null;
        String property = System.getProperty("config.resource");
        if (property != null) {
            str = property;
        } else {
            String property2 = System.getProperty("config.file");
            if (property2 != null) {
                File file = new File(property2);
                if (!file.exists()) {
                    throw new SubstituteNotAvailableException(String.format("Specified config.file '%s' (specified as a System property) does not exist.", file.getAbsolutePath()));
                } else if (file.canRead()) {
                    config = ConfigFactory.parseFile(file);
                } else {
                    throw new SubstituteNotAvailableException(String.format("config.file '%s' (specified as a System property) is not readable.", file.getAbsolutePath()));
                }
            } else {
                String property3 = System.getProperty("config.url");
                if (property3 != null) {
                    try {
                        config = ConfigFactory.parseURL(new URL(property3));
                    } catch (MalformedURLException e) {
                        throw new SubstituteNotAvailableException(String.format("Specified config.url '%s' (specified as a System property) could not be parsed.", property3));
                    }
                }
            }
        }
        if (config == null) {
            config = ConfigFactory.parseResourcesAnySyntax(classLoader, str);
        }
        return config;
    }

    public static ConfigWithFallbackMessage applicationOrStandardSubstituteFallbackWithMessage(ClassLoader classLoader) throws SubstituteNotAvailableException {
        try {
            return new ConfigWithFallbackMessage(applicationOrStandardSubstitute(classLoader), null);
        } catch (SubstituteNotAvailableException e) {
            return new ConfigWithFallbackMessage(ConfigFactory.parseResourcesAnySyntax(classLoader, APPLICATION), e.getMessage() + " Falling back to standard application.(conf|json|properties).");
        }
    }

    /* renamed from: com.mchange.v3.hocon.HoconUtils$SubstituteNotAvailableException */
    /* loaded from: grasscutter.jar:com/mchange/v3/hocon/HoconUtils$SubstituteNotAvailableException.class */
    public static class SubstituteNotAvailableException extends Exception {
        SubstituteNotAvailableException(String str) {
            super(str);
        }
    }

    /* renamed from: com.mchange.v3.hocon.HoconUtils$ConfigWithFallbackMessage */
    /* loaded from: grasscutter.jar:com/mchange/v3/hocon/HoconUtils$ConfigWithFallbackMessage.class */
    public static class ConfigWithFallbackMessage {
        private Config _config;
        private String _message;

        public Config config() {
            return this._config;
        }

        public String message() {
            return this._message;
        }

        private ConfigWithFallbackMessage(Config config, String str) {
            this._config = config;
            this._message = str;
        }
    }

    /* renamed from: com.mchange.v3.hocon.HoconUtils$WarnedConfig */
    /* loaded from: grasscutter.jar:com/mchange/v3/hocon/HoconUtils$WarnedConfig.class */
    public static class WarnedConfig {
        public Config config;
        public List<String> warnings;

        WarnedConfig(Config config, List<String> list) {
            this.config = config;
            this.warnings = list;
        }
    }

    public static WarnedConfig customFileOrSpecifiedSourceWins(File file) {
        ArrayList arrayList = new ArrayList();
        boolean exists = file.exists();
        Properties properties = System.getProperties();
        if ((properties.containsKey("config.resource") || properties.containsKey("config.file") || properties.containsKey("config.url")) && exists) {
            arrayList.add(createSpecifiedSourceWarning(file, properties));
            return new WarnedConfig(ConfigFactory.load(), arrayList);
        } else if (!exists) {
            return new WarnedConfig(ConfigFactory.load(), arrayList);
        } else {
            return new WarnedConfig(ConfigFactory.defaultOverrides().withFallback(ConfigFactory.parseFile(file).withFallback(ConfigFactory.defaultApplication().withFallback(ConfigFactory.defaultReference()))), arrayList);
        }
    }

    private static String createSpecifiedSourceWarning(File file, Properties properties) {
        boolean z = true;
        StringBuilder sb = new StringBuilder();
        sb.append("Config file ");
        sb.append(file.getAbsolutePath());
        sb.append(" will be ignored because a location has been explicitly set via System.properties. [");
        if (properties.containsKey("config.resource")) {
            sb.append("config.resource=" + properties.getProperty("config.resource"));
            z = false;
        }
        if (properties.containsKey("config.file")) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("config.file=" + properties.getProperty("config.file"));
            z = false;
        }
        if (properties.containsKey("config.url")) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("config.url=" + properties.getProperty("config.url"));
        }
        sb.append("]");
        return sb.toString();
    }

    private HoconUtils() {
    }
}
