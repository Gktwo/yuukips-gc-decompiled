package com.github.davidmoten.rtreemulti.geometry.internal;

import com.github.davidmoten.guavamini.Preconditions;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import com.github.davidmoten.rtreemulti.geometry.Rectangle;
import com.github.davidmoten.rtreemulti.internal.util.ObjectsHelper;
import java.util.Arrays;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/geometry/internal/RectangleDouble.class */
public final class RectangleDouble implements Rectangle {
    private final double[] mins;
    private final double[] maxes;

    private RectangleDouble(double[] mins, double[] maxes) {
        Preconditions.checkArgument(mins.length == maxes.length);
        for (int i = 0; i < mins.length; i++) {
            Preconditions.checkArgument(maxes[i] >= mins[i]);
        }
        this.mins = mins;
        this.maxes = maxes;
    }

    public static RectangleDouble create(double[] mins, double[] maxes) {
        return new RectangleDouble(mins, maxes);
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Rectangle
    public Rectangle add(Rectangle r) {
        double[] a = new double[this.mins.length];
        double[] b = new double[this.mins.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = min(this.mins[i], r.min(i));
            b[i] = max(this.maxes[i], r.max(i));
        }
        return new RectangleDouble(a, b);
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Rectangle
    public boolean contains(double... p) {
        Preconditions.checkArgument(this.mins.length == p.length);
        for (int i = 0; i < p.length; i++) {
            if (p[i] < this.mins[i] || p[i] > this.maxes[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Geometry
    public boolean intersects(Rectangle r) {
        return GeometryUtil.intersects(this.mins, this.maxes, r.mins(), r.maxes());
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Geometry
    public double distance(Rectangle r) {
        return GeometryUtil.distance(this.mins, this.maxes, r.mins(), r.maxes());
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Geometry
    public Rectangle mbr() {
        return this;
    }

    public String toString() {
        return "Rectangle [mins=" + Arrays.toString(this.mins) + ", maxes=" + Arrays.toString(this.maxes) + "]";
    }

    public int hashCode() {
        return (31 * ((31 * 1) + Arrays.hashCode(this.mins))) + Arrays.hashCode(this.maxes);
    }

    public boolean equals(Object obj) {
        RectangleDouble other = (RectangleDouble) ObjectsHelper.asClass(obj, RectangleDouble.class);
        return other != null && Arrays.equals(this.mins, other.mins) && Arrays.equals(this.maxes, other.maxes);
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Rectangle
    public double intersectionVolume(Rectangle r) {
        if (!intersects(r)) {
            return 0.0d;
        }
        return create(GeometryUtil.max(this.mins, r.mins()), GeometryUtil.min(this.maxes, r.maxes())).volume();
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.HasGeometry
    public Geometry geometry() {
        return this;
    }

    private static double max(double a, double b) {
        if (a < b) {
            return b;
        }
        return a;
    }

    private static double min(double a, double b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [double] */
    /* JADX WARN: Type inference failed for: r0v12, types: [double] */
    @Override // com.github.davidmoten.rtreemulti.geometry.Rectangle
    public double surfaceArea() {
        char c = 0;
        for (int i = 0; i < this.mins.length; i++) {
            char c2 = 0;
            for (int j = 0; j < this.mins.length; j++) {
                if (i != j) {
                    c2 *= this.maxes[j] - this.mins[j];
                }
            }
            c += c2;
        }
        return 0 * c;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [double] */
    @Override // com.github.davidmoten.rtreemulti.geometry.Rectangle
    public double volume() {
        char c = 0;
        for (int i = 0; i < this.mins.length; i++) {
            c *= this.maxes[i] - this.mins[i];
        }
        return c;
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Rectangle
    public double[] mins() {
        return this.mins;
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Rectangle
    public double[] maxes() {
        return this.maxes;
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Geometry
    public int dimensions() {
        return this.mins.length;
    }
}
