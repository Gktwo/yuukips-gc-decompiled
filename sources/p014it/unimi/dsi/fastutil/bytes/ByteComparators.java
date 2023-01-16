package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteComparators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteComparators.class */
public final class ByteComparators {
    public static final ByteComparator NATURAL_COMPARATOR = new NaturalImplicitComparator();
    public static final ByteComparator OPPOSITE_COMPARATOR = new OppositeImplicitComparator();

    private ByteComparators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteComparators$NaturalImplicitComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteComparators$NaturalImplicitComparator.class */
    protected static class NaturalImplicitComparator implements ByteComparator, Serializable {
        private static final long serialVersionUID = 1;

        protected NaturalImplicitComparator() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteComparator
        public final int compare(byte a, byte b) {
            return Byte.compare(a, b);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteComparator, java.util.Comparator
        public Comparator<Byte> reversed() {
            return ByteComparators.OPPOSITE_COMPARATOR;
        }

        private Object readResolve() {
            return ByteComparators.NATURAL_COMPARATOR;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteComparators$OppositeImplicitComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteComparators$OppositeImplicitComparator.class */
    protected static class OppositeImplicitComparator implements ByteComparator, Serializable {
        private static final long serialVersionUID = 1;

        protected OppositeImplicitComparator() {
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteComparator
        public final int compare(byte a, byte b) {
            return -Byte.compare(a, b);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteComparator, java.util.Comparator
        public Comparator<Byte> reversed() {
            return ByteComparators.NATURAL_COMPARATOR;
        }

        private Object readResolve() {
            return ByteComparators.OPPOSITE_COMPARATOR;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteComparators$OppositeComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteComparators$OppositeComparator.class */
    public static class OppositeComparator implements ByteComparator, Serializable {
        private static final long serialVersionUID = 1;
        final ByteComparator comparator;

        protected OppositeComparator(ByteComparator c) {
            this.comparator = c;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteComparator
        public final int compare(byte a, byte b) {
            return this.comparator.compare(b, a);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.bytes.ByteComparator, java.util.Comparator
        public final Comparator<Byte> reversed() {
            return this.comparator;
        }
    }

    public static ByteComparator oppositeComparator(ByteComparator c) {
        return c instanceof OppositeComparator ? ((OppositeComparator) c).comparator : new OppositeComparator(c);
    }

    public static ByteComparator asByteComparator(final Comparator<? super Byte> c) {
        return (c == null || (c instanceof ByteComparator)) ? (ByteComparator) c : new ByteComparator() { // from class: it.unimi.dsi.fastutil.bytes.ByteComparators.1
            @Override // p014it.unimi.dsi.fastutil.bytes.ByteComparator
            public int compare(byte x, byte y) {
                return c.compare(Byte.valueOf(x), Byte.valueOf(y));
            }

            @Override // p014it.unimi.dsi.fastutil.bytes.ByteComparator
            public int compare(Byte x, Byte y) {
                return c.compare(x, y);
            }
        };
    }
}
