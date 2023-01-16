package com.github.davidmoten.rtreemulti.internal;

import com.github.davidmoten.rtreemulti.Entry;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import com.github.davidmoten.rtreemulti.geometry.HasGeometry;
import com.github.davidmoten.rtreemulti.geometry.Rectangle;
import java.util.Comparator;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/internal/Comparators.class */
public final class Comparators {
    private Comparators() {
    }

    public static <T extends HasGeometry> Comparator<HasGeometry> overlapVolumeThenVolumeIncreaseThenVolumeComparator(final Rectangle r, final List<T> list) {
        return new Comparator<HasGeometry>() { // from class: com.github.davidmoten.rtreemulti.internal.Comparators.1
            public int compare(HasGeometry g1, HasGeometry g2) {
                int value = Double.compare((double) Comparators.overlapVolume(r, list, g1), (double) Comparators.overlapVolume(r, list, g2));
                if (value == 0) {
                    value = Double.compare(Comparators.volumeIncrease(r, g1), Comparators.volumeIncrease(r, g2));
                    if (value == 0) {
                        value = Double.compare(Comparators.volume(r, g1), Comparators.volume(r, g2));
                    }
                }
                return value;
            }
        };
    }

    /* access modifiers changed from: private */
    public static double volume(Rectangle r, HasGeometry g1) {
        return g1.geometry().mbr().add(r).volume();
    }

    public static <T extends HasGeometry> Comparator<HasGeometry> volumeIncreaseThenVolumeComparator(final Rectangle r) {
        return new Comparator<HasGeometry>() { // from class: com.github.davidmoten.rtreemulti.internal.Comparators.2
            public int compare(HasGeometry g1, HasGeometry g2) {
                int value = Double.compare(Comparators.volumeIncrease(r, g1), Comparators.volumeIncrease(r, g2));
                if (value == 0) {
                    value = Double.compare(Comparators.volume(r, g1), Comparators.volume(r, g2));
                }
                return value;
            }
        };
    }

    /* access modifiers changed from: private */
    public static float overlapVolume(Rectangle r, List<? extends HasGeometry> list, HasGeometry g) {
        Rectangle gPlusR = g.geometry().mbr().add(r);
        float m = 0.0f;
        for (HasGeometry other : list) {
            if (other != g) {
                m = (float) (((double) m) + gPlusR.intersectionVolume(other.geometry().mbr()));
            }
        }
        return m;
    }

    /* access modifiers changed from: private */
    public static double volumeIncrease(Rectangle r, HasGeometry g) {
        return g.geometry().mbr().add(r).volume() - g.geometry().mbr().volume();
    }

    public static <T, S extends Geometry> Comparator<Entry<T, S>> ascendingDistance(final Rectangle r) {
        return new Comparator<Entry<T, S>>() { // from class: com.github.davidmoten.rtreemulti.internal.Comparators.3
            public int compare(Entry<T, S> e1, Entry<T, S> e2) {
                return Double.compare(e1.geometry().distance(r), e2.geometry().distance(r));
            }
        };
    }
}
