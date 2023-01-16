package net.bytebuddy.description.type;

import java.util.Collections;
import java.util.List;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.matcher.ElementMatcher;

/* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeVariableToken.class */
public class TypeVariableToken implements ByteCodeElement.Token<TypeVariableToken> {
    private final String symbol;
    private final List<? extends TypeDescription.Generic> bounds;
    private final List<? extends AnnotationDescription> annotations;
    private transient /* synthetic */ int hashCode;

    public TypeVariableToken(String symbol, List<? extends TypeDescription.Generic> bounds) {
        this(symbol, bounds, Collections.emptyList());
    }

    public TypeVariableToken(String symbol, List<? extends TypeDescription.Generic> bounds, List<? extends AnnotationDescription> annotations) {
        this.symbol = symbol;
        this.bounds = bounds;
        this.annotations = annotations;
    }

    /* renamed from: of */
    public static TypeVariableToken m233of(TypeDescription.Generic typeVariable, ElementMatcher<? super TypeDescription> matcher) {
        return new TypeVariableToken(typeVariable.getSymbol(), typeVariable.getUpperBounds().accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(matcher)), typeVariable.getDeclaredAnnotations());
    }

    public String getSymbol() {
        return this.symbol;
    }

    public TypeList.Generic getBounds() {
        return new TypeList.Generic.Explicit(this.bounds);
    }

    public AnnotationList getAnnotations() {
        return new AnnotationList.Explicit(this.annotations);
    }

    @Override // net.bytebuddy.description.ByteCodeElement.Token
    public TypeVariableToken accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
        return new TypeVariableToken(this.symbol, getBounds().accept(visitor), this.annotations);
    }

    @CachedReturnPlugin.Enhance("hashCode")
    public int hashCode() {
        int hashCode = this.hashCode != 0 ? 0 : (31 * ((31 * this.symbol.hashCode()) + this.bounds.hashCode())) + this.annotations.hashCode();
        if (hashCode == 0) {
            hashCode = this.hashCode;
        } else {
            this.hashCode = hashCode;
        }
        return hashCode;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TypeVariableToken)) {
            return false;
        }
        TypeVariableToken typeVariableToken = (TypeVariableToken) other;
        return this.symbol.equals(typeVariableToken.symbol) && this.bounds.equals(typeVariableToken.bounds) && this.annotations.equals(typeVariableToken.annotations);
    }

    public String toString() {
        return this.symbol;
    }
}
