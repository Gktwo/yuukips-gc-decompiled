package p001ch.qos.logback.classic.turbo;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: ch.qos.logback.classic.turbo.LRUMessageCache */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/turbo/LRUMessageCache.class */
class LRUMessageCache extends LinkedHashMap<String, Integer> {
    private static final long serialVersionUID = 1;
    final int cacheSize;

    /* access modifiers changed from: package-private */
    public LRUMessageCache(int cacheSize) {
        super((int) (((float) cacheSize) * 1.3333334f), 0.75f, true);
        if (cacheSize < 1) {
            throw new IllegalArgumentException("Cache size cannot be smaller than 1");
        }
        this.cacheSize = cacheSize;
    }

    /* access modifiers changed from: package-private */
    public int getMessageCountAndThenIncrement(String msg) {
        Integer i;
        if (msg == null) {
            return 0;
        }
        synchronized (this) {
            Integer i2 = get(msg);
            if (i2 == null) {
                i = 0;
            } else {
                i = Integer.valueOf(i2.intValue() + 1);
            }
            put(msg, i);
        }
        return i.intValue();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Map$Entry] */
    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<String, Integer> entry) {
        return size() > this.cacheSize;
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
    public synchronized void clear() {
        clear();
    }
}
