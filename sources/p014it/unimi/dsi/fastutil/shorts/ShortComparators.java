package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortComparators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortComparators.class */
public final class ShortComparators {
    public static final ShortComparator NATURAL_COMPARATOR = new NaturalImplicitComparator();
    public static final ShortComparator OPPOSITE_COMPARATOR = new OppositeImplicitComparator();

    private ShortComparators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortComparators$NaturalImplicitComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortComparators$NaturalImplicitComparator.class */
    protected static class NaturalImplicitComparator implements ShortComparator, Serializable {
        private static final long serialVersionUID = 1;

        protected NaturalImplicitComparator() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortComparator
        public final int compare(short a, short b) {
            return Short.compare(a, b);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortComparator, java.util.Comparator
        public Comparator<Short> reversed() {
            return ShortComparators.OPPOSITE_COMPARATOR;
        }

        private Object readResolve() {
            return ShortComparators.NATURAL_COMPARATOR;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortComparators$OppositeImplicitComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortComparators$OppositeImplicitComparator.class */
    protected static class OppositeImplicitComparator implements ShortComparator, Serializable {
        private static final long serialVersionUID = 1;

        protected OppositeImplicitComparator() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortComparator
        public final int compare(short a, short b) {
            return -Short.compare(a, b);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortComparator, java.util.Comparator
        public Comparator<Short> reversed() {
            return ShortComparators.NATURAL_COMPARATOR;
        }

        private Object readResolve() {
            return ShortComparators.OPPOSITE_COMPARATOR;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortComparators$OppositeComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortComparators$OppositeComparator.class */
    public static class OppositeComparator implements ShortComparator, Serializable {
        private static final long serialVersionUID = 1;
        final ShortComparator comparator;

        protected OppositeComparator(ShortComparator c) {
            this.comparator = c;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortComparator
        public final int compare(short a, short b) {
            return this.comparator.compare(b, a);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortComparator, java.util.Comparator
        public final Comparator<Short> reversed() {
            return this.comparator;
        }
    }

    public static ShortComparator oppositeComparator(ShortComparator c) {
        return c instanceof OppositeComparator ? ((OppositeComparator) c).comparator : new OppositeComparator(c);
    }

    public static ShortComparator asShortComparator(final Comparator<? super Short> c) {
        return (c == null || (c instanceof ShortComparator)) ? (ShortComparator) c : new ShortComparator() { // from class: it.unimi.dsi.fastutil.shorts.ShortComparators.1
            @Override // p014it.unimi.dsi.fastutil.shorts.ShortComparator
            public int compare(short x, short y) {
                return c.compare(Short.valueOf(x), Short.valueOf(y));
            }

            @Override // p014it.unimi.dsi.fastutil.shorts.ShortComparator
            public int compare(Short x, Short y) {
                return c.compare(x, y);
            }
        };
    }
}
