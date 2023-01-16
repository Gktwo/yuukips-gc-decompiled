package com.mchange.p011v3.hocon;

import com.mchange.p009v2.cfg.DelayedLogItem;
import com.mchange.p009v2.cfg.MultiPropertiesConfig;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigList;
import com.typesafe.config.ConfigValue;
import com.typesafe.config.ConfigValueType;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* renamed from: com.mchange.v3.hocon.HoconMultiPropertiesConfig */
/* loaded from: grasscutter.jar:com/mchange/v3/hocon/HoconMultiPropertiesConfig.class */
public class HoconMultiPropertiesConfig extends MultiPropertiesConfig {
    String quasiResourcePath;
    Properties props;
    List<DelayedLogItem> delayedLogItems = new LinkedList();
    Map<String, Properties> propsByPrefix = new HashMap();

    public HoconMultiPropertiesConfig(String str, Config config) {
        this.quasiResourcePath = str;
        this.props = propsForConfig(config);
    }

    private Properties propsForConfig(Config config) {
        Properties properties = new Properties();
        for (Map.Entry entry : config.entrySet()) {
            try {
                properties.put(entry.getKey(), asSimpleString((ConfigValue) entry.getValue()));
            } catch (IllegalArgumentException e) {
                this.delayedLogItems.add(new DelayedLogItem(DelayedLogItem.Level.FINE, "For property '" + ((String) entry.getKey()) + "', " + e.getMessage()));
            }
        }
        return properties;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v3.hocon.HoconMultiPropertiesConfig$1 */
    /* loaded from: grasscutter.jar:com/mchange/v3/hocon/HoconMultiPropertiesConfig$1.class */
    public static /* synthetic */ class C09501 {
        static final /* synthetic */ int[] $SwitchMap$com$typesafe$config$ConfigValueType = new int[ConfigValueType.values().length];

        static {
            try {
                $SwitchMap$com$typesafe$config$ConfigValueType[ConfigValueType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$typesafe$config$ConfigValueType[ConfigValueType.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$typesafe$config$ConfigValueType[ConfigValueType.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$typesafe$config$ConfigValueType[ConfigValueType.LIST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$typesafe$config$ConfigValueType[ConfigValueType.OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$typesafe$config$ConfigValueType[ConfigValueType.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private static String asSimpleString(ConfigValue configValue) throws IllegalArgumentException {
        ConfigValueType valueType = configValue.valueType();
        switch (C09501.$SwitchMap$com$typesafe$config$ConfigValueType[valueType.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return String.valueOf(configValue.unwrapped());
            case 4:
                ConfigList<ConfigValue> configList = (ConfigList) configValue;
                for (ConfigValue configValue2 : configList) {
                    if (!isSimple(configValue2)) {
                        throw new IllegalArgumentException("value is a complex list, could not be rendered as a simple property: " + configValue);
                    }
                }
                StringBuilder sb = new StringBuilder();
                int size = configList.size();
                for (int i = 0; i < size; i++) {
                    if (i != 0) {
                        sb.append(',');
                    }
                    sb.append(asSimpleString((ConfigValue) configList.get(i)));
                }
                return sb.toString();
            case 5:
                throw new IllegalArgumentException("value is a ConfigValue object rather than an atom or list of atoms: " + configValue);
            case 6:
                throw new IllegalArgumentException("value is a null; will be excluded from the MultiPropertiesConfig: " + configValue);
            default:
                throw new IllegalArgumentException("value of an unexpected type: (value->" + configValue + ", type->" + valueType + ")");
        }
    }

    private static boolean isSimple(ConfigValue configValue) {
        switch (C09501.$SwitchMap$com$typesafe$config$ConfigValueType[configValue.valueType().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    @Override // com.mchange.p009v2.cfg.MultiPropertiesConfig
    public String[] getPropertiesResourcePaths() {
        return new String[]{this.quasiResourcePath};
    }

    @Override // com.mchange.p009v2.cfg.MultiPropertiesConfig
    public Properties getPropertiesByResourcePath(String str) {
        if (!str.equals(this.quasiResourcePath)) {
            return null;
        }
        Properties properties = new Properties();
        properties.putAll(this.props);
        return properties;
    }

    @Override // com.mchange.p009v2.cfg.MultiPropertiesConfig, com.mchange.p009v2.cfg.PropertiesConfig
    public synchronized Properties getPropertiesByPrefix(String str) {
        Properties properties = this.propsByPrefix.get(str);
        if (properties == null) {
            properties = new Properties();
            if ("".equals(str)) {
                properties.putAll(this.props);
            } else {
                String str2 = str + '.';
                for (Map.Entry entry : this.props.entrySet()) {
                    String str3 = (String) entry.getKey();
                    if (str3.startsWith(str2)) {
                        properties.put(str3, entry.getValue());
                    }
                }
            }
            this.propsByPrefix.put(str, properties);
        }
        return properties;
    }

    @Override // com.mchange.p009v2.cfg.MultiPropertiesConfig, com.mchange.p009v2.cfg.PropertiesConfig
    public String getProperty(String str) {
        return (String) this.props.get(str);
    }

    @Override // com.mchange.p009v2.cfg.MultiPropertiesConfig
    public List getDelayedLogItems() {
        return this.delayedLogItems;
    }
}
