package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleComparators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleComparators.class */
public final class DoubleComparators {
    public static final DoubleComparator NATURAL_COMPARATOR = new NaturalImplicitComparator();
    public static final DoubleComparator OPPOSITE_COMPARATOR = new OppositeImplicitComparator();

    private DoubleComparators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleComparators$NaturalImplicitComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleComparators$NaturalImplicitComparator.class */
    protected static class NaturalImplicitComparator implements DoubleComparator, Serializable {
        private static final long serialVersionUID = 1;

        protected NaturalImplicitComparator() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleComparator
        public final int compare(double a, double b) {
            return Double.compare(a, b);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleComparator, java.util.Comparator
        public Comparator<Double> reversed() {
            return DoubleComparators.OPPOSITE_COMPARATOR;
        }

        private Object readResolve() {
            return DoubleComparators.NATURAL_COMPARATOR;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleComparators$OppositeImplicitComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleComparators$OppositeImplicitComparator.class */
    protected static class OppositeImplicitComparator implements DoubleComparator, Serializable {
        private static final long serialVersionUID = 1;

        protected OppositeImplicitComparator() {
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleComparator
        public final int compare(double a, double b) {
            return -Double.compare(a, b);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleComparator, java.util.Comparator
        public Comparator<Double> reversed() {
            return DoubleComparators.NATURAL_COMPARATOR;
        }

        private Object readResolve() {
            return DoubleComparators.OPPOSITE_COMPARATOR;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleComparators$OppositeComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleComparators$OppositeComparator.class */
    public static class OppositeComparator implements DoubleComparator, Serializable {
        private static final long serialVersionUID = 1;
        final DoubleComparator comparator;

        protected OppositeComparator(DoubleComparator c) {
            this.comparator = c;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleComparator
        public final int compare(double a, double b) {
            return this.comparator.compare(b, a);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleComparator, java.util.Comparator
        public final Comparator<Double> reversed() {
            return this.comparator;
        }
    }

    public static DoubleComparator oppositeComparator(DoubleComparator c) {
        return c instanceof OppositeComparator ? ((OppositeComparator) c).comparator : new OppositeComparator(c);
    }

    public static DoubleComparator asDoubleComparator(final Comparator<? super Double> c) {
        return (c == null || (c instanceof DoubleComparator)) ? (DoubleComparator) c : new DoubleComparator() { // from class: it.unimi.dsi.fastutil.doubles.DoubleComparators.1
            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleComparator
            public int compare(double x, double y) {
                return c.compare(Double.valueOf(x), Double.valueOf(y));
            }

            @Override // p014it.unimi.dsi.fastutil.doubles.DoubleComparator
            public int compare(Double x, Double y) {
                return c.compare(x, y);
            }
        };
    }
}
