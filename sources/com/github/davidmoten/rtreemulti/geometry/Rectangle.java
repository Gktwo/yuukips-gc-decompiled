package com.github.davidmoten.rtreemulti.geometry;

import com.github.davidmoten.guavamini.Preconditions;
import com.github.davidmoten.rtreemulti.geometry.internal.RectangleDouble;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/geometry/Rectangle.class */
public interface Rectangle extends Geometry, HasGeometry {
    double[] mins();

    double[] maxes();

    double volume();

    double intersectionVolume(Rectangle rectangle);

    double surfaceArea();

    Rectangle add(Rectangle rectangle);

    boolean contains(double... dArr);

    default double min(int index) {
        return mins()[index];
    }

    default double max(int index) {
        return maxes()[index];
    }

    static Rectangle create(double[] mins, double[] maxes) {
        return RectangleDouble.create(mins, maxes);
    }

    static Rectangle createOrdered(double[] x, double[] y) {
        Preconditions.checkArgument(x.length == y.length, "x and y must have same length");
        double[] mins = new double[x.length];
        double[] maxes = new double[y.length];
        for (int i = 0; i < x.length; i++) {
            mins[i] = Math.min(x[i], y[i]);
            maxes[i] = Math.max(x[i], y[i]);
        }
        return create(mins, maxes);
    }

    static Rectangle create(double... values) {
        Preconditions.checkArgument(values.length >= 4 && values.length % 2 == 0, "must be at least 4 values passed and the number of values must be even");
        double[] x = new double[values.length / 2];
        double[] y = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            x[i] = values[i];
            y[i] = values[i + x.length];
        }
        return create(x, y);
    }
}
