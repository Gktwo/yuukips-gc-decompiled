package org.jline.utils;

import java.io.IOError;
import java.io.StringWriter;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/Curses.class */
public final class Curses {

    /* renamed from: sv */
    private static final Object[] f3267sv = new Object[26];

    /* renamed from: dv */
    private static final Object[] f3268dv = new Object[26];
    private static final int IFTE_NONE = 0;
    private static final int IFTE_IF = 1;
    private static final int IFTE_THEN = 2;
    private static final int IFTE_ELSE = 3;

    private Curses() {
    }

    public static String tputs(String cap, Object... params) {
        if (cap == null) {
            return null;
        }
        StringWriter sw = new StringWriter();
        tputs(sw, cap, params);
        return sw.toString();
    }

    public static void tputs(Appendable out, String str, Object... params) {
        try {
            doTputs(out, str, params);
        } catch (Exception e) {
            throw new IOError(e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:238:0x08a8  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x08bf A[LOOP:5: B:241:0x08bf->B:242:0x08dd, LOOP_START, PHI: r9 r14 r21 
      PHI: (r9v16 'index' int) = (r9v14 'index' int), (r9v17 'index' int) binds: [B:240:0x08bc, B:242:0x08dd] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r14v10 'ch' char) = (r14v8 'ch' char), (r14v11 'ch' char) binds: [B:240:0x08bc, B:242:0x08dd] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r21v3 'prec' int) = (r21v1 'prec' int), (r21v4 'prec' int) binds: [B:240:0x08bc, B:242:0x08dd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x08e0 A[PHI: r9 r14 r21 
      PHI: (r9v15 'index' int) = (r9v14 'index' int), (r9v17 'index' int) binds: [B:240:0x08bc, B:501:0x08e0] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r14v9 'ch' char) = (r14v8 'ch' char), (r14v11 'ch' char) binds: [B:240:0x08bc, B:501:0x08e0] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r21v2 'prec' int) = (r21v1 'prec' int), (r21v4 'prec' int) binds: [B:240:0x08bc, B:501:0x08e0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x08f2  */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x08ea A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void doTputs(java.lang.Appendable r6, java.lang.String r7, java.lang.Object... r8) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 2683
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.Curses.doTputs(java.lang.Appendable, java.lang.String, java.lang.Object[]):void");
    }

    private static int toInteger(Object pop) {
        if (pop instanceof Number) {
            return ((Number) pop).intValue();
        }
        if (pop instanceof Boolean) {
            return ((Boolean) pop).booleanValue() ? 1 : 0;
        }
        return Integer.parseInt(pop.toString());
    }
}
