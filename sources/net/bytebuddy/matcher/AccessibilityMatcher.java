package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/AccessibilityMatcher.class */
public class AccessibilityMatcher<T extends ByteCodeElement> extends ElementMatcher.Junction.AbstractBase<T> {
    private final TypeDescription typeDescription;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((AccessibilityMatcher) obj).typeDescription);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: net.bytebuddy.matcher.AccessibilityMatcher<T extends net.bytebuddy.description.ByteCodeElement> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // net.bytebuddy.matcher.ElementMatcher
    public /* bridge */ /* synthetic */ boolean matches(Object obj) {
        return matches((AccessibilityMatcher<T>) ((ByteCodeElement) obj));
    }

    public AccessibilityMatcher(TypeDescription typeDescription) {
        this.typeDescription = typeDescription;
    }

    public boolean matches(T target) {
        return target.isAccessibleTo(this.typeDescription);
    }

    public String toString() {
        return "isAccessibleTo(" + this.typeDescription + ")";
    }
}
