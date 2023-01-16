package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;

/* access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/Cut.class */
public abstract class Cut<C extends Comparable> implements Comparable<Cut<C>>, Serializable {
    final C endpoint;
    private static final long serialVersionUID = 0;

    /* access modifiers changed from: package-private */
    public abstract boolean isLessThan(C c);

    /* access modifiers changed from: package-private */
    public abstract BoundType typeAsLowerBound();

    /* access modifiers changed from: package-private */
    public abstract BoundType typeAsUpperBound();

    /* access modifiers changed from: package-private */
    public abstract Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain);

    /* access modifiers changed from: package-private */
    public abstract Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain);

    /* access modifiers changed from: package-private */
    public abstract void describeAsLowerBound(StringBuilder sb);

    /* access modifiers changed from: package-private */
    public abstract void describeAsUpperBound(StringBuilder sb);

    /* access modifiers changed from: package-private */
    public abstract C leastValueAbove(DiscreteDomain<C> discreteDomain);

    /* access modifiers changed from: package-private */
    public abstract C greatestValueBelow(DiscreteDomain<C> discreteDomain);

    @Override // java.lang.Object
    public abstract int hashCode();

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Cut) ((Cut) obj));
    }

    Cut(C endpoint) {
        this.endpoint = endpoint;
    }

    /* access modifiers changed from: package-private */
    public Cut<C> canonical(DiscreteDomain<C> domain) {
        return this;
    }

    public int compareTo(Cut<C> that) {
        if (that == belowAll()) {
            return 1;
        }
        if (that == aboveAll()) {
            return -1;
        }
        int result = Range.compareOrThrow(this.endpoint, that.endpoint);
        if (result != 0) {
            return result;
        }
        return Booleans.compare(this instanceof AboveValue, that instanceof AboveValue);
    }

    /* access modifiers changed from: package-private */
    public C endpoint() {
        return this.endpoint;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof Cut)) {
            return false;
        }
        try {
            return compareTo((Cut) ((Cut) obj)) == 0;
        } catch (ClassCastException e) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> belowAll() {
        return BelowAll.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Cut$BelowAll.class */
    public static final class BelowAll extends Cut<Comparable<?>> {
        private static final BelowAll INSTANCE = new BelowAll();
        private static final long serialVersionUID = 0;

        private BelowAll() {
            super(null);
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        boolean isLessThan(Comparable<?> value) {
            return true;
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsLowerBound() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsUpperBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> withLowerBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> domain) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> withUpperBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> domain) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        void describeAsLowerBound(StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // com.google.common.collect.Cut
        void describeAsUpperBound(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> domain) {
            return domain.minValue();
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> domain) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> canonical(DiscreteDomain<Comparable<?>> domain) {
            try {
                return Cut.belowValue(domain.minValue());
            } catch (NoSuchElementException e) {
                return this;
            }
        }

        @Override // com.google.common.collect.Cut
        public int compareTo(Cut<Comparable<?>> o) {
            return o == this ? 0 : -1;
        }

        @Override // com.google.common.collect.Cut, java.lang.Object
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // java.lang.Object
        public String toString() {
            return "-∞";
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    /* access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> aboveAll() {
        return AboveAll.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Cut$AboveAll.class */
    public static final class AboveAll extends Cut<Comparable<?>> {
        private static final AboveAll INSTANCE = new AboveAll();
        private static final long serialVersionUID = 0;

        private AboveAll() {
            super(null);
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        boolean isLessThan(Comparable<?> value) {
            return false;
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsLowerBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsUpperBound() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> withLowerBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> domain) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> withUpperBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> domain) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        void describeAsLowerBound(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        void describeAsUpperBound(StringBuilder sb) {
            sb.append("+∞)");
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> domain) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> domain) {
            return domain.maxValue();
        }

        @Override // com.google.common.collect.Cut
        public int compareTo(Cut<Comparable<?>> o) {
            return o == this ? 0 : 1;
        }

        @Override // com.google.common.collect.Cut, java.lang.Object
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // java.lang.Object
        public String toString() {
            return "+∞";
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    /* access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> belowValue(C endpoint) {
        return new BelowValue(endpoint);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Cut$BelowValue.class */
    public static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((Cut) ((Cut) obj));
        }

        BelowValue(C endpoint) {
            super((Comparable) Preconditions.checkNotNull(endpoint));
        }

        @Override // com.google.common.collect.Cut
        boolean isLessThan(C value) {
            return Range.compareOrThrow(this.endpoint, value) <= 0;
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsLowerBound() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsUpperBound() {
            return BoundType.OPEN;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Cut
        Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> domain) {
            switch (boundType) {
                case CLOSED:
                    return this;
                case OPEN:
                    C previous = domain.previous(this.endpoint);
                    return previous == null ? Cut.belowAll() : new AboveValue(previous);
                default:
                    throw new AssertionError();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Cut
        Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> domain) {
            switch (boundType) {
                case CLOSED:
                    C previous = domain.previous(this.endpoint);
                    return previous == null ? Cut.aboveAll() : new AboveValue(previous);
                case OPEN:
                    return this;
                default:
                    throw new AssertionError();
            }
        }

        @Override // com.google.common.collect.Cut
        void describeAsLowerBound(StringBuilder sb) {
            sb.append('[').append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        void describeAsUpperBound(StringBuilder sb) {
            sb.append(this.endpoint).append(')');
        }

        @Override // com.google.common.collect.Cut
        C leastValueAbove(DiscreteDomain<C> domain) {
            return (C) this.endpoint;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Cut
        C greatestValueBelow(DiscreteDomain<C> domain) {
            return (C) domain.previous(this.endpoint);
        }

        @Override // com.google.common.collect.Cut, java.lang.Object
        public int hashCode() {
            return this.endpoint.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            return "\\" + this.endpoint + "/";
        }
    }

    /* access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> aboveValue(C endpoint) {
        return new AboveValue(endpoint);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Cut$AboveValue.class */
    public static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((Cut) ((Cut) obj));
        }

        AboveValue(C endpoint) {
            super((Comparable) Preconditions.checkNotNull(endpoint));
        }

        @Override // com.google.common.collect.Cut
        boolean isLessThan(C value) {
            return Range.compareOrThrow(this.endpoint, value) < 0;
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsLowerBound() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsUpperBound() {
            return BoundType.CLOSED;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Cut
        Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> domain) {
            switch (boundType) {
                case CLOSED:
                    C next = domain.next(this.endpoint);
                    return next == null ? Cut.belowAll() : belowValue(next);
                case OPEN:
                    return this;
                default:
                    throw new AssertionError();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Cut
        Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> domain) {
            switch (boundType) {
                case CLOSED:
                    return this;
                case OPEN:
                    C next = domain.next(this.endpoint);
                    return next == null ? Cut.aboveAll() : belowValue(next);
                default:
                    throw new AssertionError();
            }
        }

        @Override // com.google.common.collect.Cut
        void describeAsLowerBound(StringBuilder sb) {
            sb.append('(').append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        void describeAsUpperBound(StringBuilder sb) {
            sb.append(this.endpoint).append(']');
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Cut
        C leastValueAbove(DiscreteDomain<C> domain) {
            return (C) domain.next(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        C greatestValueBelow(DiscreteDomain<C> domain) {
            return (C) this.endpoint;
        }

        @Override // com.google.common.collect.Cut
        Cut<C> canonical(DiscreteDomain<C> domain) {
            C next = leastValueAbove(domain);
            return next != null ? belowValue(next) : Cut.aboveAll();
        }

        @Override // com.google.common.collect.Cut, java.lang.Object
        public int hashCode() {
            return this.endpoint.hashCode() ^ -1;
        }

        @Override // java.lang.Object
        public String toString() {
            return "/" + this.endpoint + "\\";
        }
    }
}
