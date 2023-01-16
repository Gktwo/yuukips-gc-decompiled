package net.bytebuddy.matcher;

import java.lang.ClassLoader;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/ClassLoaderParentMatcher.class */
public class ClassLoaderParentMatcher<T extends ClassLoader> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ClassLoader classLoader;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.classLoader.equals(((ClassLoaderParentMatcher) obj).classLoader);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.classLoader.hashCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: net.bytebuddy.matcher.ClassLoaderParentMatcher<T extends java.lang.ClassLoader> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // net.bytebuddy.matcher.ElementMatcher
    public /* bridge */ /* synthetic */ boolean matches(Object obj) {
        return matches((ClassLoaderParentMatcher<T>) ((ClassLoader) obj));
    }

    public ClassLoaderParentMatcher(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public boolean matches(T target) {
        for (ClassLoader current = this.classLoader; current != null; current = current.getParent()) {
            if (current == target) {
                return true;
            }
        }
        return target == null;
    }

    public String toString() {
        return "isParentOf(" + this.classLoader + ')';
    }
}
