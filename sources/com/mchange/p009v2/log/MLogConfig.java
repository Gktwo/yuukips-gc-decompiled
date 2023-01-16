package com.mchange.p009v2.log;

import com.mchange.p009v2.cfg.DelayedLogItem;
import com.mchange.p009v2.cfg.MConfig;
import com.mchange.p009v2.cfg.MLogConfigSource;
import com.mchange.p009v2.cfg.MultiPropertiesConfig;
import dev.morphia.mapping.Mapper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.mchange.v2.log.MLogConfig */
/* loaded from: grasscutter.jar:com/mchange/v2/log/MLogConfig.class */
public final class MLogConfig {
    private static MultiPropertiesConfig CONFIG = null;
    private static List BOOTSTRAP_LOG_ITEMS = null;
    private static Method delayedDumpToLogger = null;

    public static synchronized void refresh(MultiPropertiesConfig[] multiPropertiesConfigArr, String str) {
        ArrayList arrayList = new ArrayList();
        MultiPropertiesConfig readVmConfig = MLogConfigSource.readVmConfig(new String[]{"/com/mchange/v2/log/default-mchange-log.properties"}, new String[]{"/mchange-log.properties", "/"}, arrayList);
        boolean z = CONFIG == null;
        if (multiPropertiesConfigArr != null) {
            int length = multiPropertiesConfigArr.length;
            MultiPropertiesConfig[] multiPropertiesConfigArr2 = new MultiPropertiesConfig[length + 1];
            multiPropertiesConfigArr2[0] = readVmConfig;
            for (int i = 0; i < length; i++) {
                multiPropertiesConfigArr2[i + 1] = multiPropertiesConfigArr[i];
            }
            arrayList.add(new DelayedLogItem(DelayedLogItem.Level.INFO, (z ? "Loaded" : "Refreshed") + " MLog library log configuration, with overrides" + (str == null ? Mapper.IGNORED_FIELDNAME : ": " + str)));
            CONFIG = MConfig.combine(multiPropertiesConfigArr2);
        } else {
            if (!z) {
                arrayList.add(new DelayedLogItem(DelayedLogItem.Level.INFO, "Refreshed MLog library log configuration, without overrides."));
            }
            CONFIG = readVmConfig;
        }
        BOOTSTRAP_LOG_ITEMS = arrayList;
    }

    private static void ensureLoad() {
        if (CONFIG == null) {
            refresh(null, null);
        }
    }

    private static void ensureDelayedDumpToLogger() {
        try {
            if (delayedDumpToLogger == null) {
                delayedDumpToLogger = Class.forName("com.mchange.v2.cfg.MConfig").getMethod("dumpToLogger", Class.forName("com.mchange.v2.cfg.DelayedLogItem"), MLogger.class);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new RuntimeException(e2);
        }
    }

    public static synchronized String getProperty(String str) {
        ensureLoad();
        return CONFIG.getProperty(str);
    }

    public static synchronized void logDelayedItems(MLogger mLogger) {
        ensureLoad();
        ensureDelayedDumpToLogger();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(BOOTSTRAP_LOG_ITEMS);
        arrayList.addAll(CONFIG.getDelayedLogItems());
        HashSet hashSet = new HashSet();
        hashSet.addAll(arrayList);
        for (Object obj : arrayList) {
            if (hashSet.contains(obj)) {
                hashSet.remove(obj);
                try {
                    delayedDumpToLogger.invoke(null, obj, mLogger);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new Error(e);
                }
            }
        }
    }

    public static synchronized String dump() {
        return CONFIG.toString();
    }

    private MLogConfig() {
    }
}
