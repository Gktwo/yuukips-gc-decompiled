package com.mchange.p009v2.log;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.mchange.v2.log.MLevel */
/* loaded from: grasscutter.jar:com/mchange/v2/log/MLevel.class */
public final class MLevel {
    public static final MLevel ALL;
    public static final MLevel CONFIG;
    public static final MLevel FINE;
    public static final MLevel FINER;
    public static final MLevel FINEST;
    public static final MLevel INFO;
    public static final MLevel OFF;
    public static final MLevel SEVERE;
    public static final MLevel WARNING;
    public static final MLevel DEBUG;
    public static final MLevel TRACE;
    private static final Map integersToMLevels;
    private static final Map namesToMLevels;
    private static final int ALL_INTVAL = Integer.MIN_VALUE;
    private static final int CONFIG_INTVAL = 700;
    private static final int FINE_INTVAL = 500;
    private static final int FINER_INTVAL = 400;
    private static final int FINEST_INTVAL = 300;
    private static final int INFO_INTVAL = 800;
    private static final int OFF_INTVAL = Integer.MAX_VALUE;
    private static final int SEVERE_INTVAL = 1000;
    private static final int WARNING_INTVAL = 900;
    Object level;
    int intval;
    String lvlstring;

    public static MLevel fromIntValue(int i) {
        return (MLevel) integersToMLevels.get(new Integer(i));
    }

    public static MLevel fromSeverity(String str) {
        return (MLevel) namesToMLevels.get(str);
    }

    static {
        boolean z;
        Class<?> cls;
        try {
            cls = Class.forName("java.util.logging.Level");
            z = true;
        } catch (ClassNotFoundException e) {
            cls = null;
            z = false;
        }
        try {
            MLevel mLevel = new MLevel(z ? cls.getField("ALL").get(null) : null, Integer.MIN_VALUE, "ALL");
            MLevel mLevel2 = new MLevel(z ? cls.getField("CONFIG").get(null) : null, 700, "CONFIG");
            MLevel mLevel3 = new MLevel(z ? cls.getField("FINE").get(null) : null, 500, "FINE");
            MLevel mLevel4 = new MLevel(z ? cls.getField("FINER").get(null) : null, 400, "FINER");
            MLevel mLevel5 = new MLevel(z ? cls.getField("FINEST").get(null) : null, 300, "FINEST");
            MLevel mLevel6 = new MLevel(z ? cls.getField("INFO").get(null) : null, 800, "INFO");
            MLevel mLevel7 = new MLevel(z ? cls.getField("OFF").get(null) : null, Integer.MAX_VALUE, "OFF");
            MLevel mLevel8 = new MLevel(z ? cls.getField("SEVERE").get(null) : null, 1000, "SEVERE");
            MLevel mLevel9 = new MLevel(z ? cls.getField("WARNING").get(null) : null, 900, "WARNING");
            ALL = mLevel;
            CONFIG = mLevel2;
            FINE = mLevel3;
            FINER = mLevel4;
            FINEST = mLevel5;
            INFO = mLevel6;
            OFF = mLevel7;
            SEVERE = mLevel8;
            WARNING = mLevel9;
            DEBUG = mLevel3;
            TRACE = mLevel5;
            HashMap hashMap = new HashMap();
            hashMap.put(new Integer(mLevel.intValue()), mLevel);
            hashMap.put(new Integer(mLevel2.intValue()), mLevel2);
            hashMap.put(new Integer(mLevel3.intValue()), mLevel3);
            hashMap.put(new Integer(mLevel4.intValue()), mLevel4);
            hashMap.put(new Integer(mLevel5.intValue()), mLevel5);
            hashMap.put(new Integer(mLevel6.intValue()), mLevel6);
            hashMap.put(new Integer(mLevel7.intValue()), mLevel7);
            hashMap.put(new Integer(mLevel8.intValue()), mLevel8);
            hashMap.put(new Integer(mLevel9.intValue()), mLevel9);
            integersToMLevels = Collections.unmodifiableMap(hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(mLevel.getSeverity(), mLevel);
            hashMap2.put(mLevel2.getSeverity(), mLevel2);
            hashMap2.put(mLevel3.getSeverity(), mLevel3);
            hashMap2.put(mLevel4.getSeverity(), mLevel4);
            hashMap2.put(mLevel5.getSeverity(), mLevel5);
            hashMap2.put(mLevel6.getSeverity(), mLevel6);
            hashMap2.put(mLevel7.getSeverity(), mLevel7);
            hashMap2.put(mLevel8.getSeverity(), mLevel8);
            hashMap2.put(mLevel9.getSeverity(), mLevel9);
            namesToMLevels = Collections.unmodifiableMap(hashMap2);
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new InternalError("Huh? java.util.logging.Level is here, but not its expected public fields?");
        }
    }

    public int intValue() {
        return this.intval;
    }

    public Object asJdk14Level() {
        return this.level;
    }

    public String getSeverity() {
        return this.lvlstring;
    }

    public String toString() {
        return getClass().getName() + getLineHeader();
    }

    public String getLineHeader() {
        return "[" + this.lvlstring + ']';
    }

    public boolean isLoggable(MLevel mLevel) {
        return this.intval >= mLevel.intval;
    }

    private MLevel(Object obj, int i, String str) {
        this.level = obj;
        this.intval = i;
        this.lvlstring = str;
    }
}
