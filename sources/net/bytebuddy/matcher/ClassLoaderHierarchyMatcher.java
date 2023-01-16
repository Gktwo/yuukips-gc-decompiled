package net.bytebuddy.matcher;

import java.lang.ClassLoader;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/ClassLoaderHierarchyMatcher.class */
public class ClassLoaderHierarchyMatcher<T extends ClassLoader> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super ClassLoader> matcher;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((ClassLoaderHierarchyMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: net.bytebuddy.matcher.ClassLoaderHierarchyMatcher<T extends java.lang.ClassLoader> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // net.bytebuddy.matcher.ElementMatcher
    public /* bridge */ /* synthetic */ boolean matches(Object obj) {
        return matches((ClassLoaderHierarchyMatcher<T>) ((ClassLoader) obj));
    }

    public ClassLoaderHierarchyMatcher(ElementMatcher<? super ClassLoader> matcher) {
        this.matcher = matcher;
    }

    public boolean matches(T target) {
        for (ClassLoader current = target; current != null; current = current.getParent()) {
            if (this.matcher.matches(current)) {
                return true;
            }
        }
        return this.matcher.matches(null);
    }

    public String toString() {
        return "hasChild(" + this.matcher + ')';
    }
}
