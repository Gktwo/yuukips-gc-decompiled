package com.mchange.p009v2.cfg;

import java.util.Properties;

/* renamed from: com.mchange.v2.cfg.PropertiesConfig */
/* loaded from: grasscutter.jar:com/mchange/v2/cfg/PropertiesConfig.class */
public interface PropertiesConfig {
    Properties getPropertiesByPrefix(String str);

    String getProperty(String str);
}
