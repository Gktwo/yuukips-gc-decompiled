package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import p013io.javalin.http.sse.EmitterKt;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true)
/* loaded from: grasscutter.jar:com/google/common/collect/GeneralRange.class */
public final class GeneralRange<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final T lowerEndpoint;
    private final BoundType lowerBoundType;
    private final boolean hasUpperBound;
    private final T upperEndpoint;
    private final BoundType upperBoundType;
    private transient GeneralRange<T> reverse;

    static <T extends Comparable> GeneralRange<T> from(Range<T> range) {
        return new GeneralRange<>(Ordering.natural(), range.hasLowerBound(), range.hasLowerBound() ? range.lowerEndpoint() : null, range.hasLowerBound() ? range.lowerBoundType() : BoundType.OPEN, range.hasUpperBound(), range.hasUpperBound() ? range.upperEndpoint() : null, range.hasUpperBound() ? range.upperBoundType() : BoundType.OPEN);
    }

    /* access modifiers changed from: package-private */
    public static <T> GeneralRange<T> all(Comparator<? super T> comparator) {
        return new GeneralRange<>(comparator, false, null, BoundType.OPEN, false, null, BoundType.OPEN);
    }

    /* access modifiers changed from: package-private */
    public static <T> GeneralRange<T> downTo(Comparator<? super T> comparator, T endpoint, BoundType boundType) {
        return new GeneralRange<>(comparator, true, endpoint, boundType, false, null, BoundType.OPEN);
    }

    /* access modifiers changed from: package-private */
    public static <T> GeneralRange<T> upTo(Comparator<? super T> comparator, T endpoint, BoundType boundType) {
        return new GeneralRange<>(comparator, false, null, BoundType.OPEN, true, endpoint, boundType);
    }

    static <T> GeneralRange<T> range(Comparator<? super T> comparator, T lower, BoundType lowerType, T upper, BoundType upperType) {
        return new GeneralRange<>(comparator, true, lower, lowerType, true, upper, upperType);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private GeneralRange(Comparator<? super T> comparator, boolean hasLowerBound, T lowerEndpoint, BoundType lowerBoundType, boolean hasUpperBound, T upperEndpoint, BoundType upperBoundType) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        this.hasLowerBound = hasLowerBound;
        this.hasUpperBound = hasUpperBound;
        this.lowerEndpoint = lowerEndpoint;
        this.lowerBoundType = (BoundType) Preconditions.checkNotNull(lowerBoundType);
        this.upperEndpoint = upperEndpoint;
        this.upperBoundType = (BoundType) Preconditions.checkNotNull(upperBoundType);
        if (hasLowerBound) {
            comparator.compare(lowerEndpoint, lowerEndpoint);
        }
        if (hasUpperBound) {
            comparator.compare(upperEndpoint, upperEndpoint);
        }
        if (hasLowerBound && hasUpperBound) {
            int cmp = comparator.compare(lowerEndpoint, upperEndpoint);
            Preconditions.checkArgument(cmp <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", lowerEndpoint, upperEndpoint);
            if (cmp == 0) {
                Preconditions.checkArgument((lowerBoundType != BoundType.OPEN) | (upperBoundType != BoundType.OPEN));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Comparator<? super T> comparator() {
        return this.comparator;
    }

    /* access modifiers changed from: package-private */
    public boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    /* access modifiers changed from: package-private */
    public boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    boolean isEmpty() {
        return (hasUpperBound() && tooLow(getUpperEndpoint())) || (hasLowerBound() && tooHigh(getLowerEndpoint()));
    }

    /* access modifiers changed from: package-private */
    public boolean tooLow(T t) {
        if (!hasLowerBound()) {
            return false;
        }
        int cmp = this.comparator.compare(t, getLowerEndpoint());
        return (cmp < 0) | ((cmp == 0) & (getLowerBoundType() == BoundType.OPEN));
    }

    /* access modifiers changed from: package-private */
    public boolean tooHigh(T t) {
        if (!hasUpperBound()) {
            return false;
        }
        int cmp = this.comparator.compare(t, getUpperEndpoint());
        return (cmp > 0) | ((cmp == 0) & (getUpperBoundType() == BoundType.OPEN));
    }

    /* access modifiers changed from: package-private */
    public boolean contains(T t) {
        return !tooLow(t) && !tooHigh(t);
    }

    /* access modifiers changed from: package-private */
    public GeneralRange<T> intersect(GeneralRange<T> other) {
        int cmp;
        int cmp2;
        int cmp3;
        Preconditions.checkNotNull(other);
        Preconditions.checkArgument(this.comparator.equals(other.comparator));
        boolean hasLowBound = this.hasLowerBound;
        T lowEnd = getLowerEndpoint();
        BoundType lowType = getLowerBoundType();
        if (!hasLowerBound()) {
            hasLowBound = other.hasLowerBound;
            lowEnd = other.getLowerEndpoint();
            lowType = other.getLowerBoundType();
        } else if (other.hasLowerBound() && ((cmp3 = this.comparator.compare(getLowerEndpoint(), other.getLowerEndpoint())) < 0 || (cmp3 == 0 && other.getLowerBoundType() == BoundType.OPEN))) {
            lowEnd = other.getLowerEndpoint();
            lowType = other.getLowerBoundType();
        }
        boolean hasUpBound = this.hasUpperBound;
        T upEnd = getUpperEndpoint();
        BoundType upType = getUpperBoundType();
        if (!hasUpperBound()) {
            hasUpBound = other.hasUpperBound;
            upEnd = other.getUpperEndpoint();
            upType = other.getUpperBoundType();
        } else if (other.hasUpperBound() && ((cmp2 = this.comparator.compare(getUpperEndpoint(), other.getUpperEndpoint())) > 0 || (cmp2 == 0 && other.getUpperBoundType() == BoundType.OPEN))) {
            upEnd = other.getUpperEndpoint();
            upType = other.getUpperBoundType();
        }
        if (hasLowBound && hasUpBound && ((cmp = this.comparator.compare(lowEnd, upEnd)) > 0 || (cmp == 0 && lowType == BoundType.OPEN && upType == BoundType.OPEN))) {
            lowEnd = upEnd;
            lowType = BoundType.OPEN;
            upType = BoundType.CLOSED;
        }
        return new GeneralRange<>(this.comparator, hasLowBound, lowEnd, lowType, hasUpBound, upEnd, upType);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof GeneralRange)) {
            return false;
        }
        GeneralRange<?> r = (GeneralRange) obj;
        return this.comparator.equals(r.comparator) && this.hasLowerBound == r.hasLowerBound && this.hasUpperBound == r.hasUpperBound && getLowerBoundType().equals(r.getLowerBoundType()) && getUpperBoundType().equals(r.getUpperBoundType()) && Objects.equal(getLowerEndpoint(), r.getLowerEndpoint()) && Objects.equal(getUpperEndpoint(), r.getUpperEndpoint());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Objects.hashCode(this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType());
    }

    GeneralRange<T> reverse() {
        GeneralRange<T> result = this.reverse;
        if (result != null) {
            return result;
        }
        GeneralRange<T> result2 = new GeneralRange<>(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
        result2.reverse = this;
        this.reverse = result2;
        return result2;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.comparator + EmitterKt.COMMENT_PREFIX + (this.lowerBoundType == BoundType.CLOSED ? '[' : '(') + (this.hasLowerBound ? this.lowerEndpoint : "-∞") + ',' + (this.hasUpperBound ? this.upperEndpoint : "∞") + (this.upperBoundType == BoundType.CLOSED ? ']' : ')');
    }

    /* access modifiers changed from: package-private */
    public T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    /* access modifiers changed from: package-private */
    public BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    /* access modifiers changed from: package-private */
    public T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    /* access modifiers changed from: package-private */
    public BoundType getUpperBoundType() {
        return this.upperBoundType;
    }
}
