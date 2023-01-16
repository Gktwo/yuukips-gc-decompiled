package org.eclipse.jetty.util;

import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/MathUtils.class */
public class MathUtils {
    private MathUtils() {
    }

    public static boolean sumOverflows(int a, int b) {
        try {
            Math.addExact(a, b);
            return false;
        } catch (ArithmeticException e) {
            return true;
        }
    }

    public static long cappedAdd(long a, long b) {
        try {
            return Math.addExact(a, b);
        } catch (ArithmeticException e) {
            return LongCompanionObject.MAX_VALUE;
        }
    }

    public static int cappedAdd(int a, int b, int maxValue) {
        try {
            return Math.min(Math.addExact(a, b), maxValue);
        } catch (ArithmeticException e) {
            return maxValue;
        }
    }
}
