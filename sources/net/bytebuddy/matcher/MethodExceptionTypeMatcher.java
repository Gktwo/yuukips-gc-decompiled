package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/MethodExceptionTypeMatcher.class */
public class MethodExceptionTypeMatcher<T extends MethodDescription> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super TypeList.Generic> matcher;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((MethodExceptionTypeMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: net.bytebuddy.matcher.MethodExceptionTypeMatcher<T extends net.bytebuddy.description.method.MethodDescription> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // net.bytebuddy.matcher.ElementMatcher
    public /* bridge */ /* synthetic */ boolean matches(Object obj) {
        return matches((MethodExceptionTypeMatcher<T>) ((MethodDescription) obj));
    }

    public MethodExceptionTypeMatcher(ElementMatcher<? super TypeList.Generic> matcher) {
        this.matcher = matcher;
    }

    public boolean matches(T target) {
        return this.matcher.matches(target.getExceptionTypes());
    }

    public String toString() {
        return "exceptions(" + this.matcher + ")";
    }
}
