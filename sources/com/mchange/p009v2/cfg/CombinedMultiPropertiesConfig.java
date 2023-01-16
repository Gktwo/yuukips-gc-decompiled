package com.mchange.p009v2.cfg;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v2.cfg.CombinedMultiPropertiesConfig */
/* loaded from: grasscutter.jar:com/mchange/v2/cfg/CombinedMultiPropertiesConfig.class */
public class CombinedMultiPropertiesConfig extends MultiPropertiesConfig {
    MultiPropertiesConfig[] configs;
    String[] resourcePaths;
    List parseMessages;

    /* access modifiers changed from: package-private */
    public CombinedMultiPropertiesConfig(MultiPropertiesConfig[] multiPropertiesConfigArr) {
        this.configs = multiPropertiesConfigArr;
        LinkedList linkedList = new LinkedList();
        for (int length = multiPropertiesConfigArr.length - 1; length >= 0; length--) {
            String[] propertiesResourcePaths = multiPropertiesConfigArr[length].getPropertiesResourcePaths();
            for (int length2 = propertiesResourcePaths.length - 1; length2 >= 0; length2--) {
                String str = propertiesResourcePaths[length2];
                if (!linkedList.contains(str)) {
                    linkedList.add(0, str);
                }
            }
        }
        this.resourcePaths = (String[]) linkedList.toArray(new String[linkedList.size()]);
        LinkedList linkedList2 = new LinkedList();
        for (MultiPropertiesConfig multiPropertiesConfig : multiPropertiesConfigArr) {
            linkedList2.addAll(multiPropertiesConfig.getDelayedLogItems());
        }
        this.parseMessages = Collections.unmodifiableList(linkedList2);
    }

    private Map getPropsByResourcePaths() {
        HashMap hashMap = new HashMap();
        int length = this.resourcePaths.length;
        for (int i = 0; i < length; i++) {
            String str = this.resourcePaths[i];
            hashMap.put(str, getPropertiesByResourcePath(str));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public BasicMultiPropertiesConfig toBasic() {
        return new BasicMultiPropertiesConfig(getPropertiesResourcePaths(), getPropsByResourcePaths(), getDelayedLogItems());
    }

    @Override // com.mchange.p009v2.cfg.MultiPropertiesConfig
    public String[] getPropertiesResourcePaths() {
        return (String[]) this.resourcePaths.clone();
    }

    @Override // com.mchange.p009v2.cfg.MultiPropertiesConfig
    public Properties getPropertiesByResourcePath(String str) {
        Properties properties = new Properties();
        int length = this.configs.length;
        for (int i = 0; i < length; i++) {
            Properties propertiesByResourcePath = this.configs[i].getPropertiesByResourcePath(str);
            if (propertiesByResourcePath != null) {
                properties.putAll(propertiesByResourcePath);
            }
        }
        if (properties.size() > 0) {
            return properties;
        }
        return null;
    }

    @Override // com.mchange.p009v2.cfg.MultiPropertiesConfig, com.mchange.p009v2.cfg.PropertiesConfig
    public Properties getPropertiesByPrefix(String str) {
        LinkedList<Map.Entry> linkedList = new LinkedList();
        for (int length = this.configs.length - 1; length >= 0; length--) {
            Properties propertiesByPrefix = this.configs[length].getPropertiesByPrefix(str);
            if (propertiesByPrefix != null) {
                linkedList.addAll(0, propertiesByPrefix.entrySet());
            }
        }
        if (linkedList.size() == 0) {
            return null;
        }
        Properties properties = new Properties();
        for (Map.Entry entry : linkedList) {
            properties.put(entry.getKey(), entry.getValue());
        }
        return properties;
    }

    @Override // com.mchange.p009v2.cfg.MultiPropertiesConfig, com.mchange.p009v2.cfg.PropertiesConfig
    public String getProperty(String str) {
        for (int length = this.configs.length - 1; length >= 0; length--) {
            String property = this.configs[length].getProperty(str);
            if (property != null) {
                return property;
            }
        }
        return null;
    }

    @Override // com.mchange.p009v2.cfg.MultiPropertiesConfig
    public List getDelayedLogItems() {
        return this.parseMessages;
    }
}
