package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatComparators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatComparators.class */
public final class FloatComparators {
    public static final FloatComparator NATURAL_COMPARATOR = new NaturalImplicitComparator();
    public static final FloatComparator OPPOSITE_COMPARATOR = new OppositeImplicitComparator();

    private FloatComparators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatComparators$NaturalImplicitComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatComparators$NaturalImplicitComparator.class */
    protected static class NaturalImplicitComparator implements FloatComparator, Serializable {
        private static final long serialVersionUID = 1;

        protected NaturalImplicitComparator() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatComparator
        public final int compare(float a, float b) {
            return Float.compare(a, b);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatComparator, java.util.Comparator
        public Comparator<Float> reversed() {
            return FloatComparators.OPPOSITE_COMPARATOR;
        }

        private Object readResolve() {
            return FloatComparators.NATURAL_COMPARATOR;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatComparators$OppositeImplicitComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatComparators$OppositeImplicitComparator.class */
    protected static class OppositeImplicitComparator implements FloatComparator, Serializable {
        private static final long serialVersionUID = 1;

        protected OppositeImplicitComparator() {
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatComparator
        public final int compare(float a, float b) {
            return -Float.compare(a, b);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatComparator, java.util.Comparator
        public Comparator<Float> reversed() {
            return FloatComparators.NATURAL_COMPARATOR;
        }

        private Object readResolve() {
            return FloatComparators.OPPOSITE_COMPARATOR;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.floats.FloatComparators$OppositeComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatComparators$OppositeComparator.class */
    public static class OppositeComparator implements FloatComparator, Serializable {
        private static final long serialVersionUID = 1;
        final FloatComparator comparator;

        protected OppositeComparator(FloatComparator c) {
            this.comparator = c;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatComparator
        public final int compare(float a, float b) {
            return this.comparator.compare(b, a);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.floats.FloatComparator, java.util.Comparator
        public final Comparator<Float> reversed() {
            return this.comparator;
        }
    }

    public static FloatComparator oppositeComparator(FloatComparator c) {
        return c instanceof OppositeComparator ? ((OppositeComparator) c).comparator : new OppositeComparator(c);
    }

    public static FloatComparator asFloatComparator(final Comparator<? super Float> c) {
        return (c == null || (c instanceof FloatComparator)) ? (FloatComparator) c : new FloatComparator() { // from class: it.unimi.dsi.fastutil.floats.FloatComparators.1
            @Override // p014it.unimi.dsi.fastutil.floats.FloatComparator
            public int compare(float x, float y) {
                return c.compare(Float.valueOf(x), Float.valueOf(y));
            }

            @Override // p014it.unimi.dsi.fastutil.floats.FloatComparator
            public int compare(Float x, Float y) {
                return c.compare(x, y);
            }
        };
    }
}
