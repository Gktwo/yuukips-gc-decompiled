package p001ch.qos.logback.classic.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.slf4j.spi.MDCAdapter;

/* renamed from: ch.qos.logback.classic.util.LogbackMDCAdapter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/util/LogbackMDCAdapter.class */
public class LogbackMDCAdapter implements MDCAdapter {
    private static final int WRITE_OPERATION = 1;
    private static final int MAP_COPY_OPERATION = 2;
    final ThreadLocal<Map<String, String>> copyOnThreadLocal = new ThreadLocal<>();
    final ThreadLocal<Integer> lastOperation = new ThreadLocal<>();

    private Integer getAndSetLastOperation(int op) {
        Integer lastOp = this.lastOperation.get();
        this.lastOperation.set(Integer.valueOf(op));
        return lastOp;
    }

    private boolean wasLastOpReadOrNull(Integer lastOp) {
        return lastOp == null || lastOp.intValue() == 2;
    }

    private Map<String, String> duplicateAndInsertNewMap(Map<String, String> oldMap) {
        Map<String, String> newMap = Collections.synchronizedMap(new HashMap());
        if (oldMap != null) {
            synchronized (oldMap) {
                newMap.putAll(oldMap);
            }
        }
        this.copyOnThreadLocal.set(newMap);
        return newMap;
    }

    @Override // org.slf4j.spi.MDCAdapter
    public void put(String key, String val) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        Map<String, String> oldMap = this.copyOnThreadLocal.get();
        if (wasLastOpReadOrNull(getAndSetLastOperation(1)) || oldMap == null) {
            duplicateAndInsertNewMap(oldMap).put(key, val);
        } else {
            oldMap.put(key, val);
        }
    }

    @Override // org.slf4j.spi.MDCAdapter
    public void remove(String key) {
        Map<String, String> oldMap;
        if (key != null && (oldMap = this.copyOnThreadLocal.get()) != null) {
            if (wasLastOpReadOrNull(getAndSetLastOperation(1))) {
                duplicateAndInsertNewMap(oldMap).remove(key);
            } else {
                oldMap.remove(key);
            }
        }
    }

    @Override // org.slf4j.spi.MDCAdapter
    public void clear() {
        this.lastOperation.set(1);
        this.copyOnThreadLocal.remove();
    }

    @Override // org.slf4j.spi.MDCAdapter
    public String get(String key) {
        Map<String, String> map = this.copyOnThreadLocal.get();
        if (map == null || key == null) {
            return null;
        }
        return map.get(key);
    }

    public Map<String, String> getPropertyMap() {
        this.lastOperation.set(2);
        return this.copyOnThreadLocal.get();
    }

    public Set<String> getKeys() {
        Map<String, String> map = getPropertyMap();
        if (map != null) {
            return map.keySet();
        }
        return null;
    }

    @Override // org.slf4j.spi.MDCAdapter
    public Map<String, String> getCopyOfContextMap() {
        Map<String, String> hashMap = this.copyOnThreadLocal.get();
        if (hashMap == null) {
            return null;
        }
        return new HashMap(hashMap);
    }

    @Override // org.slf4j.spi.MDCAdapter
    public void setContextMap(Map<String, String> contextMap) {
        this.lastOperation.set(1);
        Map<String, String> newMap = Collections.synchronizedMap(new HashMap());
        newMap.putAll(contextMap);
        this.copyOnThreadLocal.set(newMap);
    }
}
