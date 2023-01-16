package net.bytebuddy.matcher;

import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.Iterable;
import java.util.Collection;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/CollectionSizeMatcher.class */
public class CollectionSizeMatcher<T extends Iterable<?>> extends ElementMatcher.Junction.AbstractBase<T> {
    private final int size;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.size == ((CollectionSizeMatcher) obj).size;
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.size;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: net.bytebuddy.matcher.CollectionSizeMatcher<T extends java.lang.Iterable<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // net.bytebuddy.matcher.ElementMatcher
    @SuppressFBWarnings(value = {"DLS_DEAD_LOCAL_STORE"}, justification = "Iteration required to count size of an iterable")
    public /* bridge */ /* synthetic */ boolean matches(Object obj) {
        return matches((CollectionSizeMatcher<T>) ((Iterable) obj));
    }

    public CollectionSizeMatcher(int size) {
        this.size = size;
    }

    @SuppressFBWarnings(value = {"DLS_DEAD_LOCAL_STORE"}, justification = "Iteration required to count size of an iterable")
    public boolean matches(T target) {
        if (target instanceof Collection) {
            return ((Collection) target).size() == this.size;
        }
        int size = 0;
        for (Object obj : target) {
            size++;
        }
        return size == this.size;
    }

    public String toString() {
        return "ofSize(" + this.size + ')';
    }
}
