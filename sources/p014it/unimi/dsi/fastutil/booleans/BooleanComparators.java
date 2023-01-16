package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;
import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanComparators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanComparators.class */
public final class BooleanComparators {
    public static final BooleanComparator NATURAL_COMPARATOR = new NaturalImplicitComparator();
    public static final BooleanComparator OPPOSITE_COMPARATOR = new OppositeImplicitComparator();

    private BooleanComparators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanComparators$NaturalImplicitComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanComparators$NaturalImplicitComparator.class */
    protected static class NaturalImplicitComparator implements BooleanComparator, Serializable {
        private static final long serialVersionUID = 1;

        protected NaturalImplicitComparator() {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanComparator
        public final int compare(boolean a, boolean b) {
            return Boolean.compare(a, b);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanComparator, java.util.Comparator
        public Comparator<Boolean> reversed() {
            return BooleanComparators.OPPOSITE_COMPARATOR;
        }

        private Object readResolve() {
            return BooleanComparators.NATURAL_COMPARATOR;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanComparators$OppositeImplicitComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanComparators$OppositeImplicitComparator.class */
    protected static class OppositeImplicitComparator implements BooleanComparator, Serializable {
        private static final long serialVersionUID = 1;

        protected OppositeImplicitComparator() {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanComparator
        public final int compare(boolean a, boolean b) {
            return -Boolean.compare(a, b);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanComparator, java.util.Comparator
        public Comparator<Boolean> reversed() {
            return BooleanComparators.NATURAL_COMPARATOR;
        }

        private Object readResolve() {
            return BooleanComparators.OPPOSITE_COMPARATOR;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanComparators$OppositeComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanComparators$OppositeComparator.class */
    public static class OppositeComparator implements BooleanComparator, Serializable {
        private static final long serialVersionUID = 1;
        final BooleanComparator comparator;

        protected OppositeComparator(BooleanComparator c) {
            this.comparator = c;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanComparator
        public final int compare(boolean a, boolean b) {
            return this.comparator.compare(b, a);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanComparator, java.util.Comparator
        public final Comparator<Boolean> reversed() {
            return this.comparator;
        }
    }

    public static BooleanComparator oppositeComparator(BooleanComparator c) {
        return c instanceof OppositeComparator ? ((OppositeComparator) c).comparator : new OppositeComparator(c);
    }

    public static BooleanComparator asBooleanComparator(final Comparator<? super Boolean> c) {
        return (c == null || (c instanceof BooleanComparator)) ? (BooleanComparator) c : new BooleanComparator() { // from class: it.unimi.dsi.fastutil.booleans.BooleanComparators.1
            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanComparator
            public int compare(boolean x, boolean y) {
                return c.compare(Boolean.valueOf(x), Boolean.valueOf(y));
            }

            @Override // p014it.unimi.dsi.fastutil.booleans.BooleanComparator
            public int compare(Boolean x, Boolean y) {
                return c.compare(x, y);
            }
        };
    }
}
