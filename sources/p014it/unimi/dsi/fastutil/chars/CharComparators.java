package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Comparator;

/* renamed from: it.unimi.dsi.fastutil.chars.CharComparators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharComparators.class */
public final class CharComparators {
    public static final CharComparator NATURAL_COMPARATOR = new NaturalImplicitComparator();
    public static final CharComparator OPPOSITE_COMPARATOR = new OppositeImplicitComparator();

    private CharComparators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharComparators$NaturalImplicitComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharComparators$NaturalImplicitComparator.class */
    protected static class NaturalImplicitComparator implements CharComparator, Serializable {
        private static final long serialVersionUID = 1;

        protected NaturalImplicitComparator() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharComparator
        public final int compare(char a, char b) {
            return Character.compare(a, b);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharComparator, java.util.Comparator
        public Comparator<Character> reversed() {
            return CharComparators.OPPOSITE_COMPARATOR;
        }

        private Object readResolve() {
            return CharComparators.NATURAL_COMPARATOR;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharComparators$OppositeImplicitComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharComparators$OppositeImplicitComparator.class */
    protected static class OppositeImplicitComparator implements CharComparator, Serializable {
        private static final long serialVersionUID = 1;

        protected OppositeImplicitComparator() {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharComparator
        public final int compare(char a, char b) {
            return -Character.compare(a, b);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharComparator, java.util.Comparator
        public Comparator<Character> reversed() {
            return CharComparators.NATURAL_COMPARATOR;
        }

        private Object readResolve() {
            return CharComparators.OPPOSITE_COMPARATOR;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.chars.CharComparators$OppositeComparator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharComparators$OppositeComparator.class */
    public static class OppositeComparator implements CharComparator, Serializable {
        private static final long serialVersionUID = 1;
        final CharComparator comparator;

        protected OppositeComparator(CharComparator c) {
            this.comparator = c;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharComparator
        public final int compare(char a, char b) {
            return this.comparator.compare(b, a);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.CharComparator, java.util.Comparator
        public final Comparator<Character> reversed() {
            return this.comparator;
        }
    }

    public static CharComparator oppositeComparator(CharComparator c) {
        return c instanceof OppositeComparator ? ((OppositeComparator) c).comparator : new OppositeComparator(c);
    }

    public static CharComparator asCharComparator(final Comparator<? super Character> c) {
        return (c == null || (c instanceof CharComparator)) ? (CharComparator) c : new CharComparator() { // from class: it.unimi.dsi.fastutil.chars.CharComparators.1
            @Override // p014it.unimi.dsi.fastutil.chars.CharComparator
            public int compare(char x, char y) {
                return c.compare(Character.valueOf(x), Character.valueOf(y));
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharComparator
            public int compare(Character x, Character y) {
                return c.compare(x, y);
            }
        };
    }
}
