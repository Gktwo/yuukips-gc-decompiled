package com.mchange.p009v2.lang;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.mchange.v2.lang.Coerce */
/* loaded from: grasscutter.jar:com/mchange/v2/lang/Coerce.class */
public final class Coerce {
    static final Set CAN_COERCE;

    static {
        Class[] clsArr = {Byte.TYPE, Boolean.TYPE, Character.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, String.class, Byte.class, Boolean.class, Character.class, Short.class, Integer.class, Long.class, Float.class, Double.class};
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(clsArr));
        CAN_COERCE = Collections.unmodifiableSet(hashSet);
    }

    public static boolean canCoerce(Class cls) {
        return CAN_COERCE.contains(cls);
    }

    public static boolean canCoerce(Object obj) {
        return canCoerce((Class) obj.getClass());
    }

    public static int toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return (int) Double.parseDouble(str);
        }
    }

    public static long toLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return (long) Double.parseDouble(str);
        }
    }

    public static float toFloat(String str) {
        return Float.parseFloat(str);
    }

    public static double toDouble(String str) {
        return Double.parseDouble(str);
    }

    public static byte toByte(String str) {
        return (byte) toInt(str);
    }

    public static short toShort(String str) {
        return (short) toInt(str);
    }

    public static boolean toBoolean(String str) {
        return Boolean.valueOf(str).booleanValue();
    }

    public static char toChar(String str) {
        String trim = str.trim();
        if (trim.length() == 1) {
            return trim.charAt(0);
        }
        return (char) toInt(trim);
    }

    public static Object toObject(String str, Class cls) {
        if (cls == Byte.TYPE) {
            cls = Byte.class;
        } else if (cls == Boolean.TYPE) {
            cls = Boolean.class;
        } else if (cls == Character.TYPE) {
            cls = Character.class;
        } else if (cls == Short.TYPE) {
            cls = Short.class;
        } else if (cls == Integer.TYPE) {
            cls = Integer.class;
        } else if (cls == Long.TYPE) {
            cls = Long.class;
        } else if (cls == Float.TYPE) {
            cls = Float.class;
        } else if (cls == Double.TYPE) {
            cls = Double.class;
        }
        if (cls == String.class) {
            return str;
        }
        if (cls == Byte.class) {
            return new Byte(toByte(str));
        }
        if (cls == Boolean.class) {
            return Boolean.valueOf(str);
        }
        if (cls == Character.class) {
            return new Character(toChar(str));
        }
        if (cls == Short.class) {
            return new Short(toShort(str));
        }
        if (cls == Integer.class) {
            return new Integer(str);
        }
        if (cls == Long.class) {
            return new Long(str);
        }
        if (cls == Float.class) {
            return new Float(str);
        }
        if (cls == Double.class) {
            return new Double(str);
        }
        throw new IllegalArgumentException("Cannot coerce to type: " + cls.getName());
    }

    private Coerce() {
    }
}
