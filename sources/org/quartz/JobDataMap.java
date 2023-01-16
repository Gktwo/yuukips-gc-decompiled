package org.quartz;

import java.io.Serializable;
import java.util.Map;
import org.quartz.utils.StringKeyDirtyFlagMap;

/* loaded from: grasscutter.jar:org/quartz/JobDataMap.class */
public class JobDataMap extends StringKeyDirtyFlagMap implements Serializable {
    private static final long serialVersionUID = -6939901990106713909L;

    public JobDataMap() {
        super(15);
    }

    public JobDataMap(Map<?, ?> map) {
        this();
        putAll(map);
        clearDirtyFlag();
    }

    public void putAsString(String key, boolean value) {
        put(key, Boolean.valueOf(value).toString());
    }

    public void putAsString(String key, Boolean value) {
        put(key, value.toString());
    }

    public void putAsString(String key, char value) {
        put(key, Character.valueOf(value).toString());
    }

    public void putAsString(String key, Character value) {
        put(key, value.toString());
    }

    public void putAsString(String key, double value) {
        put(key, Double.toString(value));
    }

    public void putAsString(String key, Double value) {
        put(key, value.toString());
    }

    public void putAsString(String key, float value) {
        put(key, Float.toString(value));
    }

    public void putAsString(String key, Float value) {
        put(key, value.toString());
    }

    public void putAsString(String key, int value) {
        put(key, Integer.valueOf(value).toString());
    }

    public void putAsString(String key, Integer value) {
        put(key, value.toString());
    }

    public void putAsString(String key, long value) {
        put(key, Long.valueOf(value).toString());
    }

    public void putAsString(String key, Long value) {
        put(key, value.toString());
    }

    public int getIntFromString(String key) {
        return new Integer((String) get(key)).intValue();
    }

    public int getIntValue(String key) {
        if (get(key) instanceof String) {
            return getIntFromString(key);
        }
        return getInt(key);
    }

    public Integer getIntegerFromString(String key) {
        return new Integer((String) get(key));
    }

    public boolean getBooleanValueFromString(String key) {
        return Boolean.valueOf((String) get(key)).booleanValue();
    }

    public boolean getBooleanValue(String key) {
        if (get(key) instanceof String) {
            return getBooleanValueFromString(key);
        }
        return getBoolean(key);
    }

    public Boolean getBooleanFromString(String key) {
        return Boolean.valueOf((String) get(key));
    }

    public char getCharFromString(String key) {
        return ((String) get(key)).charAt(0);
    }

    public Character getCharacterFromString(String key) {
        return Character.valueOf(((String) get(key)).charAt(0));
    }

    public double getDoubleValueFromString(String key) {
        return Double.valueOf((String) get(key)).doubleValue();
    }

    public double getDoubleValue(String key) {
        if (get(key) instanceof String) {
            return getDoubleValueFromString(key);
        }
        return getDouble(key);
    }

    public Double getDoubleFromString(String key) {
        return new Double((String) get(key));
    }

    public float getFloatValueFromString(String key) {
        return new Float((String) get(key)).floatValue();
    }

    public float getFloatValue(String key) {
        if (get(key) instanceof String) {
            return getFloatValueFromString(key);
        }
        return getFloat(key);
    }

    public Float getFloatFromString(String key) {
        return new Float((String) get(key));
    }

    public long getLongValueFromString(String key) {
        return new Long((String) get(key)).longValue();
    }

    public long getLongValue(String key) {
        if (get(key) instanceof String) {
            return getLongValueFromString(key);
        }
        return getLong(key);
    }

    public Long getLongFromString(String key) {
        return new Long((String) get(key));
    }
}
