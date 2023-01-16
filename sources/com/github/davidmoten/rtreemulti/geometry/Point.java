package com.github.davidmoten.rtreemulti.geometry;

import com.github.davidmoten.rtreemulti.geometry.internal.PointDouble;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/geometry/Point.class */
public interface Point extends Rectangle {
    @Override // com.github.davidmoten.rtreemulti.geometry.Rectangle
    double[] mins();

    @Override // com.github.davidmoten.rtreemulti.geometry.Rectangle
    default double[] maxes() {
        return mins();
    }

    default double[] values() {
        return mins();
    }

    static Point create(double... x) {
        return PointDouble.create(x);
    }

    static Point create(List<? extends Number> x) {
        double[] a = new double[x.size()];
        for (int i = 0; i < x.size(); i++) {
            a[i] = ((Number) x.get(i)).doubleValue();
        }
        return create(a);
    }
}
