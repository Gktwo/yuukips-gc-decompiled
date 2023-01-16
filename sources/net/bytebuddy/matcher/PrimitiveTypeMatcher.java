package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/PrimitiveTypeMatcher.class */
public class PrimitiveTypeMatcher<T extends TypeDefinition> extends ElementMatcher.Junction.AbstractBase<T> {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass();
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: net.bytebuddy.matcher.PrimitiveTypeMatcher<T extends net.bytebuddy.description.type.TypeDefinition> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // net.bytebuddy.matcher.ElementMatcher
    public /* bridge */ /* synthetic */ boolean matches(Object obj) {
        return matches((PrimitiveTypeMatcher<T>) ((TypeDefinition) obj));
    }

    public boolean matches(T target) {
        return target.isPrimitive();
    }

    public String toString() {
        return "isPrimitive()";
    }
}
