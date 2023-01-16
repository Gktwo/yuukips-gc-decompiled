package com.mchange.p009v2.cfg;

import java.util.List;
import java.util.Properties;

/* renamed from: com.mchange.v2.cfg.MultiPropertiesConfig */
/* loaded from: grasscutter.jar:com/mchange/v2/cfg/MultiPropertiesConfig.class */
public abstract class MultiPropertiesConfig implements PropertiesConfig {
    private static String PROGRAMMATICALLY_SUPPLIED_PROPERTIES = "PROGRAMMATICALLY_SUPPLIED_PROPERTIES";

    public abstract String[] getPropertiesResourcePaths();

    public abstract Properties getPropertiesByResourcePath(String str);

    @Override // com.mchange.p009v2.cfg.PropertiesConfig
    public abstract Properties getPropertiesByPrefix(String str);

    @Override // com.mchange.p009v2.cfg.PropertiesConfig
    public abstract String getProperty(String str);

    public abstract List getDelayedLogItems();

    public static MultiPropertiesConfig readVmConfig(String[] strArr, String[] strArr2) {
        return ConfigUtils.readVmConfig(strArr, strArr2);
    }

    public static MultiPropertiesConfig readVmConfig() {
        return ConfigUtils.readVmConfig();
    }

    public static MultiPropertiesConfig fromProperties(String str, Properties properties) {
        return new BasicMultiPropertiesConfig(str, properties);
    }

    public static MultiPropertiesConfig fromProperties(Properties properties) {
        return fromProperties(PROGRAMMATICALLY_SUPPLIED_PROPERTIES, properties);
    }
}
