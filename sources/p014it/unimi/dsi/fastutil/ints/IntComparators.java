package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.ints.IntComparators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntComparators.class */
public final class IntComparators {
    public static final IntComparator NATURAL_COMPARATOR = new NaturalImplicitComparator();
    public static final IntComparator OPPOSITE_COMPARATOR = new OppositeImplicitComparator();

    private IntComparators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntComparators$NaturalImplicitComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntComparators$NaturalImplicitComparator.class */
    protected static class NaturalImplicitComparator implements IntComparator, Serializable {
        private static final long serialVersionUID = 1;

        protected NaturalImplicitComparator() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntComparator
        public final int compare(int a, int b) {
            return Integer.compare(a, b);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntComparator, java.util.Comparator
        public Comparator<Integer> reversed() {
            return IntComparators.OPPOSITE_COMPARATOR;
        }

        private Object readResolve() {
            return IntComparators.NATURAL_COMPARATOR;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.IntComparators$OppositeImplicitComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntComparators$OppositeImplicitComparator.class */
    protected static class OppositeImplicitComparator implements IntComparator, Serializable {
        private static final long serialVersionUID = 1;

        protected OppositeImplicitComparator() {
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntComparator
        public final int compare(int a, int b) {
            return -Integer.compare(a, b);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntComparator, java.util.Comparator
        public Comparator<Integer> reversed() {
            return IntComparators.NATURAL_COMPARATOR;
        }

        private Object readResolve() {
            return IntComparators.OPPOSITE_COMPARATOR;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.ints.IntComparators$OppositeComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntComparators$OppositeComparator.class */
    public static class OppositeComparator implements IntComparator, Serializable {
        private static final long serialVersionUID = 1;
        final IntComparator comparator;

        protected OppositeComparator(IntComparator c) {
            this.comparator = c;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntComparator
        public final int compare(int a, int b) {
            return this.comparator.compare(b, a);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.ints.IntComparator, java.util.Comparator
        public final Comparator<Integer> reversed() {
            return this.comparator;
        }
    }

    public static IntComparator oppositeComparator(IntComparator c) {
        return c instanceof OppositeComparator ? ((OppositeComparator) c).comparator : new OppositeComparator(c);
    }

    public static IntComparator asIntComparator(final Comparator<? super Integer> c) {
        return (c == null || (c instanceof IntComparator)) ? (IntComparator) c : new IntComparator() { // from class: it.unimi.dsi.fastutil.ints.IntComparators.1
            @Override // p014it.unimi.dsi.fastutil.ints.IntComparator
            public int compare(int x, int y) {
                return c.compare(Integer.valueOf(x), Integer.valueOf(y));
            }

            @Override // p014it.unimi.dsi.fastutil.ints.IntComparator
            public int compare(Integer x, Integer y) {
                return c.compare(x, y);
            }
        };
    }
}
