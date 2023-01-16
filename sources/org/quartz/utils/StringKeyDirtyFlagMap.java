package org.quartz.utils;

import java.io.Serializable;

/* loaded from: grasscutter.jar:org/quartz/utils/StringKeyDirtyFlagMap.class */
public class StringKeyDirtyFlagMap extends DirtyFlagMap<String, Object> {
    static final long serialVersionUID = -9076749120524952280L;
    private boolean allowsTransientData = false;

    public StringKeyDirtyFlagMap() {
    }

    public StringKeyDirtyFlagMap(int initialCapacity) {
        super(initialCapacity);
    }

    public StringKeyDirtyFlagMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override // org.quartz.utils.DirtyFlagMap, java.util.Map, java.lang.Object
    public boolean equals(Object obj) {
        return equals(obj);
    }

    @Override // org.quartz.utils.DirtyFlagMap, java.util.Map, java.lang.Object
    public int hashCode() {
        return getWrappedMap().hashCode();
    }

    public String[] getKeys() {
        return (String[]) keySet().toArray(new String[size()]);
    }

    public void setAllowsTransientData(boolean allowsTransientData) {
        if (!containsTransientData() || allowsTransientData) {
            this.allowsTransientData = allowsTransientData;
            return;
        }
        throw new IllegalStateException("Cannot set property 'allowsTransientData' to 'false' when data map contains non-serializable objects.");
    }

    public boolean getAllowsTransientData() {
        return this.allowsTransientData;
    }

    public boolean containsTransientData() {
        if (!getAllowsTransientData()) {
            return false;
        }
        for (String str : getKeys()) {
            if (!(get(str) instanceof Serializable)) {
                return true;
            }
        }
        return false;
    }

    public void removeTransientData() {
        if (getAllowsTransientData()) {
            String[] keys = getKeys();
            for (int i = 0; i < keys.length; i++) {
                if (!(get(keys[i]) instanceof Serializable)) {
                    remove(keys[i]);
                }
            }
        }
    }

    public void put(String key, int value) {
        put((StringKeyDirtyFlagMap) key, (String) Integer.valueOf(value));
    }

    public void put(String key, long value) {
        put((StringKeyDirtyFlagMap) key, (String) Long.valueOf(value));
    }

    public void put(String key, float value) {
        put((StringKeyDirtyFlagMap) key, (String) Float.valueOf(value));
    }

    public void put(String key, double value) {
        put((StringKeyDirtyFlagMap) key, (String) Double.valueOf(value));
    }

    public void put(String key, boolean value) {
        put((StringKeyDirtyFlagMap) key, (String) Boolean.valueOf(value));
    }

    public void put(String key, char value) {
        put((StringKeyDirtyFlagMap) key, (String) Character.valueOf(value));
    }

    public void put(String key, String value) {
        put((StringKeyDirtyFlagMap) key, value);
    }

    public Object put(String key, Object value) {
        return put((StringKeyDirtyFlagMap) key, (String) value);
    }

    public int getInt(String key) {
        Object obj = get(key);
        try {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return Integer.parseInt((String) obj);
        } catch (Exception e) {
            throw new ClassCastException("Identified object is not an Integer.");
        }
    }

    public long getLong(String key) {
        Object obj = get(key);
        try {
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            return Long.parseLong((String) obj);
        } catch (Exception e) {
            throw new ClassCastException("Identified object is not a Long.");
        }
    }

    public float getFloat(String key) {
        Object obj = get(key);
        try {
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            return Float.parseFloat((String) obj);
        } catch (Exception e) {
            throw new ClassCastException("Identified object is not a Float.");
        }
    }

    public double getDouble(String key) {
        Object obj = get(key);
        try {
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return Double.parseDouble((String) obj);
        } catch (Exception e) {
            throw new ClassCastException("Identified object is not a Double.");
        }
    }

    public boolean getBoolean(String key) {
        Object obj = get(key);
        try {
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return Boolean.parseBoolean((String) obj);
        } catch (Exception e) {
            throw new ClassCastException("Identified object is not a Boolean.");
        }
    }

    public char getChar(String key) {
        Object obj = get(key);
        try {
            if (obj instanceof Character) {
                return ((Character) obj).charValue();
            }
            return ((String) obj).charAt(0);
        } catch (Exception e) {
            throw new ClassCastException("Identified object is not a Character.");
        }
    }

    public String getString(String key) {
        try {
            return (String) get(key);
        } catch (Exception e) {
            throw new ClassCastException("Identified object is not a String.");
        }
    }
}
