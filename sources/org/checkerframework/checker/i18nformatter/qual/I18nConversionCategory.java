package org.checkerframework.checker.i18nformatter.qual;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* loaded from: grasscutter.jar:org/checkerframework/checker/i18nformatter/qual/I18nConversionCategory.class */
public enum I18nConversionCategory {
    UNUSED(null, null),
    GENERAL(null, null),
    DATE(new Class[]{Date.class, Number.class}, new String[]{"date", "time"}),
    NUMBER(new Class[]{Number.class}, new String[]{"number", "choice"});
    
    public final Class<? extends Object>[] types;
    public final String[] strings;

    I18nConversionCategory(Class[] clsArr, String[] strings) {
        this.types = clsArr;
        this.strings = strings;
    }

    public static I18nConversionCategory stringToI18nConversionCategory(String string) {
        String string2 = string.toLowerCase();
        I18nConversionCategory[] i18nConversionCategoryArr = {DATE, NUMBER};
        for (I18nConversionCategory v : i18nConversionCategoryArr) {
            for (String s : v.strings) {
                if (s.equals(string2)) {
                    return v;
                }
            }
        }
        throw new IllegalArgumentException("Invalid format type.");
    }

    private static <E> Set<E> arrayToSet(E[] a) {
        return new HashSet(Arrays.asList(a));
    }

    public static boolean isSubsetOf(I18nConversionCategory a, I18nConversionCategory b) {
        return intersect(a, b) == a;
    }

    public static I18nConversionCategory intersect(I18nConversionCategory a, I18nConversionCategory b) {
        if (a == UNUSED) {
            return b;
        }
        if (b == UNUSED) {
            return a;
        }
        if (a == GENERAL) {
            return b;
        }
        if (b == GENERAL) {
            return a;
        }
        Set<Class<? extends Object>> as = arrayToSet(a.types);
        as.retainAll(arrayToSet(b.types));
        I18nConversionCategory[] i18nConversionCategoryArr = {DATE, NUMBER};
        for (I18nConversionCategory v : i18nConversionCategoryArr) {
            if (arrayToSet(v.types).equals(as)) {
                return v;
            }
        }
        throw new RuntimeException();
    }

    public static I18nConversionCategory union(I18nConversionCategory a, I18nConversionCategory b) {
        if (a == UNUSED || b == UNUSED) {
            return UNUSED;
        }
        if (a == GENERAL || b == GENERAL) {
            return GENERAL;
        }
        if (a == DATE || b == DATE) {
            return DATE;
        }
        return NUMBER;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder(name());
        if (this.types == null) {
            sb.append(" conversion category (all types)");
        } else {
            sb.append(" conversion category (one of: ");
            boolean first = true;
            Class<? extends Object>[] clsArr = this.types;
            for (Class<? extends Object> cls : clsArr) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(cls.getCanonicalName());
                first = false;
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
