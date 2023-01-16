package org.eclipse.jetty.util;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/IncludeExcludeSet.class */
public class IncludeExcludeSet<T, P> implements Predicate<P> {
    private final Set<T> _includes;
    private final Predicate<P> _includePredicate;
    private final Set<T> _excludes;
    private final Predicate<P> _excludePredicate;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/IncludeExcludeSet$SetContainsPredicate.class */
    private static class SetContainsPredicate<T> implements Predicate<T> {
        private final Set<T> set;

        public SetContainsPredicate(Set<T> set) {
            this.set = set;
        }

        @Override // java.util.function.Predicate
        public boolean test(T item) {
            return this.set.contains(item);
        }

        @Override // java.lang.Object
        public String toString() {
            return "CONTAINS";
        }
    }

    public IncludeExcludeSet() {
        this(HashSet.class);
    }

    public <SET extends Set<T>> IncludeExcludeSet(Class<SET> setClass) {
        try {
            this._includes = setClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            this._excludes = setClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (this._includes instanceof Predicate) {
                this._includePredicate = (Predicate) this._includes;
            } else {
                this._includePredicate = new SetContainsPredicate(this._includes);
            }
            if (this._excludes instanceof Predicate) {
                this._excludePredicate = (Predicate) this._excludes;
            } else {
                this._excludePredicate = new SetContainsPredicate(this._excludes);
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public <SET extends Set<T>> IncludeExcludeSet(Set<T> includeSet, Predicate<P> includePredicate, Set<T> excludeSet, Predicate<P> excludePredicate) {
        Objects.requireNonNull(includeSet, "Include Set");
        Objects.requireNonNull(includePredicate, "Include Predicate");
        Objects.requireNonNull(excludeSet, "Exclude Set");
        Objects.requireNonNull(excludePredicate, "Exclude Predicate");
        this._includes = includeSet;
        this._includePredicate = includePredicate;
        this._excludes = excludeSet;
        this._excludePredicate = excludePredicate;
    }

    public void include(T element) {
        this._includes.add(element);
    }

    public void include(T... element) {
        for (T e : element) {
            this._includes.add(e);
        }
    }

    public void exclude(T element) {
        this._excludes.add(element);
    }

    public void exclude(T... element) {
        for (T e : element) {
            this._excludes.add(e);
        }
    }

    @Deprecated
    public boolean matches(P t) {
        return test(t);
    }

    @Override // java.util.function.Predicate
    public boolean test(P t) {
        return (this._includes.isEmpty() || this._includePredicate.test(t)) && !this._excludePredicate.test(t);
    }

    public Boolean isIncludedAndNotExcluded(P item) {
        if (this._excludePredicate.test(item)) {
            return Boolean.FALSE;
        }
        if (this._includePredicate.test(item)) {
            return Boolean.TRUE;
        }
        return null;
    }

    public boolean hasIncludes() {
        return !this._includes.isEmpty();
    }

    public boolean hasExcludes() {
        return !this._excludes.isEmpty();
    }

    public int size() {
        return this._includes.size() + this._excludes.size();
    }

    public Set<T> getIncluded() {
        return this._includes;
    }

    public Set<T> getExcluded() {
        return this._excludes;
    }

    public void clear() {
        this._includes.clear();
        this._excludes.clear();
    }

    @Override // java.lang.Object
    public String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = getClass().getSimpleName();
        objArr[1] = Integer.valueOf(hashCode());
        objArr[2] = this._includes;
        objArr[3] = this._includePredicate == this._includes ? "SELF" : this._includePredicate;
        objArr[4] = this._excludes;
        objArr[5] = this._excludePredicate == this._excludes ? "SELF" : this._excludePredicate;
        return String.format("%s@%x{i=%s,ip=%s,e=%s,ep=%s}", objArr);
    }

    public boolean isEmpty() {
        return this._includes.isEmpty() && this._excludes.isEmpty();
    }

    public static <T1, T2> boolean matchCombined(T1 item1, IncludeExcludeSet<?, T1> set1, T2 item2, IncludeExcludeSet<?, T2> set2) {
        Boolean match1 = set1.isIncludedAndNotExcluded(item1);
        Boolean match2 = set2.isIncludedAndNotExcluded(item2);
        if (Boolean.FALSE.equals(match1) || Boolean.FALSE.equals(match2)) {
            return false;
        }
        return (!set1.hasIncludes() && !set2.hasIncludes()) || Boolean.TRUE.equals(match1) || Boolean.TRUE.equals(match2);
    }
}
