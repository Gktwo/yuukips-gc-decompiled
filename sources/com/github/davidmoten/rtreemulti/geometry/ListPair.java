package com.github.davidmoten.rtreemulti.geometry;

import com.github.davidmoten.rtreemulti.geometry.HasGeometry;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/geometry/ListPair.class */
public final class ListPair<T extends HasGeometry> {
    private final Group<T> group1;
    private final Group<T> group2;
    private double volumeSum = -1.0d;
    private final double marginSum;

    public ListPair(List<T> list1, List<T> list2) {
        this.group1 = new Group<>(list1);
        this.group2 = new Group<>(list2);
        this.marginSum = this.group1.geometry().mbr().surfaceArea() + this.group2.geometry().mbr().surfaceArea();
    }

    public Group<T> group1() {
        return this.group1;
    }

    public Group<T> group2() {
        return this.group2;
    }

    public double volumeSum() {
        if (this.volumeSum == -1.0d) {
            this.volumeSum = this.group1.geometry().mbr().volume() + this.group2.geometry().mbr().volume();
        }
        return this.volumeSum;
    }

    public double marginSum() {
        return this.marginSum;
    }
}
