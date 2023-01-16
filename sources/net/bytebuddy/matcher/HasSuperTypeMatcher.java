package net.bytebuddy.matcher;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/HasSuperTypeMatcher.class */
public class HasSuperTypeMatcher<T extends TypeDescription> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super TypeDescription.Generic> matcher;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((HasSuperTypeMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: net.bytebuddy.matcher.HasSuperTypeMatcher<T extends net.bytebuddy.description.type.TypeDescription> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // net.bytebuddy.matcher.ElementMatcher
    public /* bridge */ /* synthetic */ boolean matches(Object obj) {
        return matches((HasSuperTypeMatcher<T>) ((TypeDescription) obj));
    }

    public HasSuperTypeMatcher(ElementMatcher<? super TypeDescription.Generic> matcher) {
        this.matcher = matcher;
    }

    public boolean matches(T target) {
        Set<TypeDescription> previous = new HashSet<>();
        Iterator it = target.iterator();
        while (it.hasNext()) {
            TypeDefinition typeDefinition = (TypeDefinition) it.next();
            if (!previous.add(typeDefinition.asErasure())) {
                return false;
            }
            if (this.matcher.matches(typeDefinition.asGenericType())) {
                return true;
            }
            LinkedList<TypeDefinition> interfaceTypes = new LinkedList<>(typeDefinition.getInterfaces());
            while (!interfaceTypes.isEmpty()) {
                TypeDefinition interfaceType = interfaceTypes.removeFirst();
                if (previous.add(interfaceType.asErasure())) {
                    if (this.matcher.matches(interfaceType.asGenericType())) {
                        return true;
                    }
                    interfaceTypes.addAll(interfaceType.getInterfaces());
                }
            }
        }
        return false;
    }

    public String toString() {
        return "hasSuperType(" + this.matcher + ")";
    }
}
