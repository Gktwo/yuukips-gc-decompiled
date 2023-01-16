package net.bytebuddy.matcher;

import java.lang.annotation.ElementType;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/AnnotationTargetMatcher.class */
public class AnnotationTargetMatcher<T extends AnnotationDescription> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementType elementType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.elementType.equals(((AnnotationTargetMatcher) obj).elementType);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.elementType.hashCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: net.bytebuddy.matcher.AnnotationTargetMatcher<T extends net.bytebuddy.description.annotation.AnnotationDescription> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // net.bytebuddy.matcher.ElementMatcher
    public /* bridge */ /* synthetic */ boolean matches(Object obj) {
        return matches((AnnotationTargetMatcher<T>) ((AnnotationDescription) obj));
    }

    public AnnotationTargetMatcher(ElementType elementType) {
        this.elementType = elementType;
    }

    public boolean matches(T target) {
        return target.getElementTypes().contains(this.elementType);
    }

    public String toString() {
        return "targetsElement(" + this.elementType + ")";
    }
}
