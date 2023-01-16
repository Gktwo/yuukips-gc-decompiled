package net.bytebuddy.description;

import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.matcher.ElementMatchers;

/* loaded from: grasscutter.jar:net/bytebuddy/description/TypeVariableSource.class */
public interface TypeVariableSource extends ModifierReviewable.OfAbstraction {
    public static final TypeVariableSource UNDEFINED = null;

    TypeList.Generic getTypeVariables();

    TypeVariableSource getEnclosingSource();

    boolean isInferrable();

    TypeDescription.Generic findVariable(String str);

    <T> T accept(Visitor<T> visitor);

    boolean isGenerified();

    /* loaded from: grasscutter.jar:net/bytebuddy/description/TypeVariableSource$Visitor.class */
    public interface Visitor<T> {
        T onType(TypeDescription typeDescription);

        T onMethod(MethodDescription.InDefinedShape inDefinedShape);

        /* loaded from: grasscutter.jar:net/bytebuddy/description/TypeVariableSource$Visitor$NoOp.class */
        public enum NoOp implements Visitor<TypeVariableSource> {
            INSTANCE;

            @Override // net.bytebuddy.description.TypeVariableSource.Visitor
            public TypeVariableSource onType(TypeDescription typeDescription) {
                return typeDescription;
            }

            @Override // net.bytebuddy.description.TypeVariableSource.Visitor
            public TypeVariableSource onMethod(MethodDescription.InDefinedShape methodDescription) {
                return methodDescription;
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/TypeVariableSource$AbstractBase.class */
    public static abstract class AbstractBase extends ModifierReviewable.AbstractBase implements TypeVariableSource {
        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeDescription.Generic findVariable(String symbol) {
            TypeList.Generic typeVariables = getTypeVariables().filter(ElementMatchers.named(symbol));
            if (!typeVariables.isEmpty()) {
                return typeVariables.getOnly();
            }
            TypeVariableSource enclosingSource = getEnclosingSource();
            return enclosingSource == null ? TypeDescription.Generic.UNDEFINED : enclosingSource.findVariable(symbol);
        }
    }
}
