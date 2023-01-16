package com.github.davidmoten.rtreemulti.geometry;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/geometry/Geometry.class */
public interface Geometry {
    double distance(Rectangle rectangle);

    Rectangle mbr();

    boolean intersects(Rectangle rectangle);

    int dimensions();
}
