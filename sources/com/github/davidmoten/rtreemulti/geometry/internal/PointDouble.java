package com.github.davidmoten.rtreemulti.geometry.internal;

import com.github.davidmoten.rtreemulti.geometry.Geometry;
import com.github.davidmoten.rtreemulti.geometry.Point;
import com.github.davidmoten.rtreemulti.geometry.Rectangle;
import java.util.Arrays;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/geometry/internal/PointDouble.class */
public final class PointDouble implements Point {

    /* renamed from: x */
    private final double[] f242x;

    private PointDouble(double[] x) {
        this.f242x = x;
    }

    public static PointDouble create(double[] x) {
        return new PointDouble(x);
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Geometry
    public Rectangle mbr() {
        return this;
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Geometry
    public double distance(Rectangle r) {
        return GeometryUtil.distance(this.f242x, r);
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Geometry
    public boolean intersects(Rectangle r) {
        return GeometryUtil.intersects(this.f242x, this.f242x, r.mins(), r.maxes());
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Point, com.github.davidmoten.rtreemulti.geometry.Rectangle
    public double[] mins() {
        return this.f242x;
    }

    public String toString() {
        return "Point " + Arrays.toString(mins());
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.HasGeometry
    public Geometry geometry() {
        return this;
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Rectangle
    public double volume() {
        return 0.0d;
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Rectangle
    public Rectangle add(Rectangle r) {
        return Rectangle.create(GeometryUtil.min(this.f242x, r.mins()), GeometryUtil.max(this.f242x, r.maxes()));
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Rectangle
    public boolean contains(double... p) {
        return Arrays.equals(this.f242x, p);
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Rectangle
    public double intersectionVolume(Rectangle r) {
        return 0.0d;
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Rectangle
    public double surfaceArea() {
        return 0.0d;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f242x);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            return Arrays.equals(this.f242x, ((PointDouble) obj).f242x);
        }
        return false;
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.Geometry
    public int dimensions() {
        return this.f242x.length;
    }
}
