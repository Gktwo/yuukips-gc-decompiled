package org.jline.reader.impl;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import org.jline.reader.LineReader;
import org.jline.utils.Levenshtein;

/* loaded from: grasscutter.jar:org/jline/reader/impl/ReaderUtils.class */
public class ReaderUtils {
    private ReaderUtils() {
    }

    public static boolean isSet(LineReader reader, LineReader.Option option) {
        return reader != null && reader.isSet(option);
    }

    public static String getString(LineReader reader, String name, String def) {
        Object v = reader != null ? reader.getVariable(name) : null;
        return v != null ? v.toString() : def;
    }

    public static boolean getBoolean(LineReader reader, String name, boolean def) {
        Object v = reader != null ? reader.getVariable(name) : null;
        if (v instanceof Boolean) {
            return ((Boolean) v).booleanValue();
        }
        if (v == null) {
            return def;
        }
        String s = v.toString();
        return s.isEmpty() || s.equalsIgnoreCase("on") || s.equalsIgnoreCase("1") || s.equalsIgnoreCase(C3P0Substitutions.DEBUG);
    }

    public static int getInt(LineReader reader, String name, int def) {
        int nb = def;
        Object v = reader != null ? reader.getVariable(name) : null;
        if (v instanceof Number) {
            return ((Number) v).intValue();
        }
        if (v != null) {
            nb = 0;
            try {
                nb = Integer.parseInt(v.toString());
            } catch (NumberFormatException e) {
            }
        }
        return nb;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x002d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x003a */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long getLong(org.jline.reader.LineReader r3, java.lang.String r4, long r5) {
        /*
            r0 = r5
            r7 = r0
            r0 = r3
            if (r0 == 0) goto L_0x0011
            r0 = r3
            r1 = r4
            java.lang.Object r0 = r0.getVariable(r1)
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            r9 = r0
            r0 = r9
            boolean r0 = r0 instanceof java.lang.Number
            if (r0 == 0) goto L_0x0025
            r0 = r9
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
            return r0
        L_0x0025:
            r0 = r9
            if (r0 == 0) goto L_0x003c
            r0 = 0
            r7 = r0
            r0 = r9
            java.lang.String r0 = r0.toString()     // Catch: NumberFormatException -> 0x003a
            long r0 = java.lang.Long.parseLong(r0)     // Catch: NumberFormatException -> 0x003a
            r7 = r0
            goto L_0x003c
        L_0x003a:
            r10 = move-exception
        L_0x003c:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.reader.impl.ReaderUtils.getLong(org.jline.reader.LineReader, java.lang.String, long):long");
    }

    public static int distance(String word, String cand) {
        if (word.length() < cand.length()) {
            return Math.min(Levenshtein.distance(word, cand.substring(0, Math.min(cand.length(), word.length()))), Levenshtein.distance(word, cand));
        }
        return Levenshtein.distance(word, cand);
    }
}
