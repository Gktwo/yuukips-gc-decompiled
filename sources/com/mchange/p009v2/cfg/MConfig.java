package com.mchange.p009v2.cfg;

import com.mchange.p006v1.cachedstore.CachedStore;
import com.mchange.p006v1.cachedstore.CachedStoreException;
import com.mchange.p006v1.cachedstore.CachedStoreFactory;
import com.mchange.p006v1.cachedstore.CachedStoreUtils;
import com.mchange.p006v1.util.ArrayUtils;
import com.mchange.p009v2.cfg.DelayedLogItem;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.mchange.v2.cfg.MConfig */
/* loaded from: grasscutter.jar:com/mchange/v2/cfg/MConfig.class */
public final class MConfig {
    private static final MLogger logger = MLog.getLogger(MConfig.class);
    private static final Map<DelayedLogItem.Level, MLevel> levelMap;
    static final CachedStore cache;

    static {
        try {
            HashMap hashMap = new HashMap();
            DelayedLogItem.Level[] values = DelayedLogItem.Level.values();
            for (DelayedLogItem.Level level : values) {
                hashMap.put(level, (MLevel) MLevel.class.getField(level.toString()).get(null));
            }
            levelMap = Collections.unmodifiableMap(hashMap);
            cache = CachedStoreUtils.synchronizedCachedStore(CachedStoreFactory.createNoCleanupCachedStore(new CSManager()));
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new RuntimeException(e2);
        }
    }

    public static MultiPropertiesConfig readVmConfig(String[] strArr, String[] strArr2) {
        try {
            return (MultiPropertiesConfig) cache.find(new PathsKey(strArr, strArr2));
        } catch (CachedStoreException e) {
            throw new RuntimeException(e);
        }
    }

    public static MultiPropertiesConfig readVmConfig() {
        return readVmConfig(ConfigUtils.NO_PATHS, ConfigUtils.NO_PATHS);
    }

    public static MultiPropertiesConfig readConfig(String[] strArr) {
        try {
            return (MultiPropertiesConfig) cache.find(new PathsKey(strArr));
        } catch (CachedStoreException e) {
            throw new RuntimeException(e);
        }
    }

    public static MultiPropertiesConfig combine(MultiPropertiesConfig[] multiPropertiesConfigArr) {
        return ConfigUtils.combine(multiPropertiesConfigArr);
    }

    public static void dumpToLogger(List<DelayedLogItem> list, MLogger mLogger) {
        for (DelayedLogItem delayedLogItem : list) {
            dumpToLogger(delayedLogItem, mLogger);
        }
    }

    public static void dumpToLogger(DelayedLogItem delayedLogItem, MLogger mLogger) {
        mLogger.log(levelMap.get(delayedLogItem.getLevel()), delayedLogItem.getText(), delayedLogItem.getException());
    }

    /* access modifiers changed from: private */
    /* renamed from: com.mchange.v2.cfg.MConfig$PathsKey */
    /* loaded from: grasscutter.jar:com/mchange/v2/cfg/MConfig$PathsKey.class */
    public static final class PathsKey {
        String[] paths;
        List delayedLogItems;

        public boolean equals(Object obj) {
            if (obj instanceof PathsKey) {
                return Arrays.equals(this.paths, ((PathsKey) obj).paths);
            }
            return false;
        }

        public int hashCode() {
            return ArrayUtils.hashArray(this.paths);
        }

        PathsKey(String[] strArr, String[] strArr2) {
            this.delayedLogItems = new ArrayList();
            List vmCondensedPaths = ConfigUtils.vmCondensedPaths(strArr, strArr2, this.delayedLogItems);
            this.paths = (String[]) vmCondensedPaths.toArray(new String[vmCondensedPaths.size()]);
        }

        PathsKey(String[] strArr) {
            this.delayedLogItems = Collections.emptyList();
            this.paths = strArr;
        }
    }

    /* renamed from: com.mchange.v2.cfg.MConfig$CSManager */
    /* loaded from: grasscutter.jar:com/mchange/v2/cfg/MConfig$CSManager.class */
    private static class CSManager implements CachedStore.Manager {
        private CSManager() {
        }

        @Override // com.mchange.p006v1.cachedstore.CachedStore.Manager
        public boolean isDirty(Object obj, Object obj2) throws Exception {
            return false;
        }

        @Override // com.mchange.p006v1.cachedstore.CachedStore.Manager
        public Object recreateFromKey(Object obj) throws Exception {
            PathsKey pathsKey = (PathsKey) obj;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(pathsKey.delayedLogItems);
            MultiPropertiesConfig read = ConfigUtils.read(pathsKey.paths, arrayList);
            MConfig.dumpToLogger(arrayList, MConfig.logger);
            return read;
        }
    }

    private MConfig() {
    }
}
