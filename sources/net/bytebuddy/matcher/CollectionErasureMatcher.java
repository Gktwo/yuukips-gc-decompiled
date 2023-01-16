package net.bytebuddy.matcher;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/CollectionErasureMatcher.class */
public class CollectionErasureMatcher<T extends Iterable<? extends TypeDefinition>> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super Iterable<? extends TypeDescription>> matcher;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((CollectionErasureMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: net.bytebuddy.matcher.CollectionErasureMatcher<T extends java.lang.Iterable<? extends net.bytebuddy.description.type.TypeDefinition>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // net.bytebuddy.matcher.ElementMatcher
    public /* bridge */ /* synthetic */ boolean matches(Object obj) {
        return matches((CollectionErasureMatcher<T>) ((Iterable) obj));
    }

    public CollectionErasureMatcher(ElementMatcher<? super Iterable<? extends TypeDescription>> matcher) {
        this.matcher = matcher;
    }

    public boolean matches(T target) {
        List<TypeDescription> typeDescriptions = new ArrayList<>();
        Iterator it = target.iterator();
        while (it.hasNext()) {
            typeDescriptions.add(((TypeDefinition) it.next()).asErasure());
        }
        return this.matcher.matches(typeDescriptions);
    }

    public String toString() {
        return "erasures(" + this.matcher + ')';
    }
}
