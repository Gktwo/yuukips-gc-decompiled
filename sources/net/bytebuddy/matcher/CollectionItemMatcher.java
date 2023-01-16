package net.bytebuddy.matcher;

import java.util.Iterator;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/CollectionItemMatcher.class */
public class CollectionItemMatcher<T> extends ElementMatcher.Junction.AbstractBase<Iterable<? extends T>> {
    private final ElementMatcher<? super T> matcher;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((CollectionItemMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    @Override // net.bytebuddy.matcher.ElementMatcher
    public /* bridge */ /* synthetic */ boolean matches(Object obj) {
        return matches((Iterable) ((Iterable) obj));
    }

    public CollectionItemMatcher(ElementMatcher<? super T> matcher) {
        this.matcher = matcher;
    }

    public boolean matches(Iterable<? extends T> target) {
        Iterator<? extends T> it = target.iterator();
        while (it.hasNext()) {
            if (this.matcher.matches(it.next())) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "whereOne(" + this.matcher + ")";
    }
}
