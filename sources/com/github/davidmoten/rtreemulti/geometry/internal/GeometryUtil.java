package com.github.davidmoten.rtreemulti.geometry.internal;

import com.github.davidmoten.rtreemulti.geometry.Rectangle;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/geometry/internal/GeometryUtil.class */
public final class GeometryUtil {
    private GeometryUtil() {
    }

    public static double max(double a, double b) {
        if (a < b) {
            return b;
        }
        return a;
    }

    public static double distance(double[] x, Rectangle r) {
        return distance(x, r.mins(), r.maxes());
    }

    public static double distance(double[] x, double[] a, double[] b) {
        return distance(x, x, a, b);
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [double] */
    public static double distance(double[] x, double[] y, double[] a, double[] b) {
        if (intersects(x, y, a, b)) {
            return 0.0d;
        }
        char c = 0;
        for (int i = 0; i < x.length; i++) {
            boolean xyMostLeft = x[i] < a[i];
            double mostLeftX1 = xyMostLeft ? x[i] : a[i];
            double mostRightX1 = xyMostLeft ? a[i] : x[i];
            double xDifference = max(0.0d, mostLeftX1 == mostRightX1 ? 0.0d : mostRightX1 - (xyMostLeft ? y[i] : b[i]));
            c += xDifference * xDifference;
        }
        return Math.sqrt(c);
    }

    public static boolean intersects(double[] mins, double[] maxes, double[] minsOther, double[] maxesOther) {
        for (int i = 0; i < mins.length; i++) {
            if (mins[i] > maxesOther[i] || maxes[i] < minsOther[i]) {
                return false;
            }
        }
        return true;
    }

    public static double[] min(double[] a, double[] b) {
        double[] p = new double[a.length];
        for (int i = 0; i < p.length; i++) {
            p[i] = Math.min(a[i], b[i]);
        }
        return p;
    }

    public static double[] max(double[] a, double[] b) {
        double[] p = new double[a.length];
        for (int i = 0; i < p.length; i++) {
            p[i] = Math.max(a[i], b[i]);
        }
        return p;
    }
}
