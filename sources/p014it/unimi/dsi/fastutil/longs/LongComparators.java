package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.longs.LongComparators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongComparators.class */
public final class LongComparators {
    public static final LongComparator NATURAL_COMPARATOR = new NaturalImplicitComparator();
    public static final LongComparator OPPOSITE_COMPARATOR = new OppositeImplicitComparator();

    private LongComparators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongComparators$NaturalImplicitComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongComparators$NaturalImplicitComparator.class */
    protected static class NaturalImplicitComparator implements LongComparator, Serializable {
        private static final long serialVersionUID = 1;

        protected NaturalImplicitComparator() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongComparator
        public final int compare(long a, long b) {
            return Long.compare(a, b);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongComparator, java.util.Comparator
        public Comparator<Long> reversed() {
            return LongComparators.OPPOSITE_COMPARATOR;
        }

        private Object readResolve() {
            return LongComparators.NATURAL_COMPARATOR;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.LongComparators$OppositeImplicitComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongComparators$OppositeImplicitComparator.class */
    protected static class OppositeImplicitComparator implements LongComparator, Serializable {
        private static final long serialVersionUID = 1;

        protected OppositeImplicitComparator() {
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongComparator
        public final int compare(long a, long b) {
            return -Long.compare(a, b);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongComparator, java.util.Comparator
        public Comparator<Long> reversed() {
            return LongComparators.NATURAL_COMPARATOR;
        }

        private Object readResolve() {
            return LongComparators.OPPOSITE_COMPARATOR;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.longs.LongComparators$OppositeComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongComparators$OppositeComparator.class */
    public static class OppositeComparator implements LongComparator, Serializable {
        private static final long serialVersionUID = 1;
        final LongComparator comparator;

        protected OppositeComparator(LongComparator c) {
            this.comparator = c;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongComparator
        public final int compare(long a, long b) {
            return this.comparator.compare(b, a);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.longs.LongComparator, java.util.Comparator
        public final Comparator<Long> reversed() {
            return this.comparator;
        }
    }

    public static LongComparator oppositeComparator(LongComparator c) {
        return c instanceof OppositeComparator ? ((OppositeComparator) c).comparator : new OppositeComparator(c);
    }

    public static LongComparator asLongComparator(final Comparator<? super Long> c) {
        return (c == null || (c instanceof LongComparator)) ? (LongComparator) c : new LongComparator() { // from class: it.unimi.dsi.fastutil.longs.LongComparators.1
            @Override // p014it.unimi.dsi.fastutil.longs.LongComparator
            public int compare(long x, long y) {
                return c.compare(Long.valueOf(x), Long.valueOf(y));
            }

            @Override // p014it.unimi.dsi.fastutil.longs.LongComparator
            public int compare(Long x, Long y) {
                return c.compare(x, y);
            }
        };
    }
}
