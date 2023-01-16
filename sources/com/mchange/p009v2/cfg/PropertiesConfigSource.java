package com.mchange.p009v2.cfg;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

/* renamed from: com.mchange.v2.cfg.PropertiesConfigSource */
/* loaded from: grasscutter.jar:com/mchange/v2/cfg/PropertiesConfigSource.class */
public interface PropertiesConfigSource {
    Parse propertiesFromSource(String str) throws FileNotFoundException, Exception;

    /* renamed from: com.mchange.v2.cfg.PropertiesConfigSource$Parse */
    /* loaded from: grasscutter.jar:com/mchange/v2/cfg/PropertiesConfigSource$Parse.class */
    public static class Parse {
        private Properties properties;
        private List<DelayedLogItem> parseMessages;

        public Properties getProperties() {
            return this.properties;
        }

        public List<DelayedLogItem> getDelayedLogItems() {
            return this.parseMessages;
        }

        public Parse(Properties properties, List<DelayedLogItem> list) {
            this.properties = properties;
            this.parseMessages = list;
        }
    }
}
