package nonapi.p019io.github.classgraph.json;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import p013io.github.classgraph.ClassGraphException;

/* access modifiers changed from: package-private */
/* renamed from: nonapi.io.github.classgraph.json.TypeResolutions */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/json/TypeResolutions.class */
public class TypeResolutions {
    private final TypeVariable<?>[] typeVariables;
    Type[] resolvedTypeArguments;

    /* access modifiers changed from: package-private */
    public TypeResolutions(ParameterizedType resolvedType) {
        this.typeVariables = ((Class) resolvedType.getRawType()).getTypeParameters();
        this.resolvedTypeArguments = resolvedType.getActualTypeArguments();
        if (this.resolvedTypeArguments.length != this.typeVariables.length) {
            throw new IllegalArgumentException("Type parameter count mismatch");
        }
    }

    /* access modifiers changed from: package-private */
    public Type resolveTypeVariables(Type type) {
        if (type instanceof Class) {
            return type;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] typeArgs = parameterizedType.getActualTypeArguments();
            Type[] typeArgsResolved = null;
            for (int i = 0; i < typeArgs.length; i++) {
                Type typeArgResolved = resolveTypeVariables(typeArgs[i]);
                if (typeArgsResolved != null) {
                    typeArgsResolved[i] = typeArgResolved;
                } else if (!typeArgResolved.equals(typeArgs[i])) {
                    typeArgsResolved = new Type[typeArgs.length];
                    System.arraycopy(typeArgs, 0, typeArgsResolved, 0, i);
                    typeArgsResolved[i] = typeArgResolved;
                }
            }
            if (typeArgsResolved == null) {
                return type;
            }
            return new ParameterizedTypeImpl((Class) parameterizedType.getRawType(), typeArgsResolved, parameterizedType.getOwnerType());
        } else if (type instanceof TypeVariable) {
            TypeVariable<?> typeVariable = (TypeVariable) type;
            for (int i2 = 0; i2 < this.typeVariables.length; i2++) {
                if (this.typeVariables[i2].getName().equals(typeVariable.getName())) {
                    return this.resolvedTypeArguments[i2];
                }
            }
            return type;
        } else if (type instanceof GenericArrayType) {
            int numArrayDims = 0;
            Type t = type;
            while (t instanceof GenericArrayType) {
                numArrayDims++;
                t = ((GenericArrayType) t).getGenericComponentType();
            }
            Type innermostTypeResolved = resolveTypeVariables(t);
            if (innermostTypeResolved instanceof Class) {
                return Array.newInstance((Class) innermostTypeResolved, (int[]) Array.newInstance(Integer.TYPE, numArrayDims)).getClass();
            }
            throw new IllegalArgumentException("Could not resolve generic array type " + type);
        } else if (type instanceof WildcardType) {
            throw ClassGraphException.newClassGraphException("WildcardType not yet supported: " + type);
        } else {
            throw ClassGraphException.newClassGraphException("Got unexpected type: " + type);
        }
    }

    public String toString() {
        if (this.typeVariables.length == 0) {
            return "{ }";
        }
        StringBuilder buf = new StringBuilder();
        buf.append("{ ");
        for (int i = 0; i < this.typeVariables.length; i++) {
            if (i > 0) {
                buf.append(", ");
            }
            buf.append(this.typeVariables[i]).append(" => ").append(this.resolvedTypeArguments[i]);
        }
        buf.append(" }");
        return buf.toString();
    }
}
