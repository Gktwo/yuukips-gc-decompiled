package net.bytebuddy.matcher;

import java.util.Iterator;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/CollectionElementMatcher.class */
public class CollectionElementMatcher<T> extends ElementMatcher.Junction.AbstractBase<Iterable<? extends T>> {
    private final int index;
    private final ElementMatcher<? super T> matcher;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.index == ((CollectionElementMatcher) obj).index && this.matcher.equals(((CollectionElementMatcher) obj).matcher);
    }

    public int hashCode() {
        return (((getClass().hashCode() * 31) + this.index) * 31) + this.matcher.hashCode();
    }

    @Override // net.bytebuddy.matcher.ElementMatcher
    public /* bridge */ /* synthetic */ boolean matches(Object obj) {
        return matches((Iterable) ((Iterable) obj));
    }

    public CollectionElementMatcher(int index, ElementMatcher<? super T> matcher) {
        this.index = index;
        this.matcher = matcher;
    }

    public boolean matches(Iterable<? extends T> target) {
        Iterator<? extends T> iterator = target.iterator();
        for (int index = 0; index < this.index; index++) {
            if (!iterator.hasNext()) {
                return false;
            }
            iterator.next();
        }
        return iterator.hasNext() && this.matcher.matches((Object) iterator.next());
    }

    public String toString() {
        return "with(" + this.index + " matches " + this.matcher + ")";
    }
}
