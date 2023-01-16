package p013io.github.classgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import nonapi.p019io.github.classgraph.types.ParseException;
import nonapi.p019io.github.classgraph.types.Parser;
import nonapi.p019io.github.classgraph.types.TypeUtils;

/* renamed from: io.github.classgraph.TypeVariableSignature */
/* loaded from: grasscutter.jar:io/github/classgraph/TypeVariableSignature.class */
public final class TypeVariableSignature extends ClassRefOrTypeVariableSignature {
    private final String name;
    private final String definingClassName;
    MethodTypeSignature containingMethodSignature;

    private TypeVariableSignature(String typeVariableName, String definingClassName) {
        this.name = typeVariableName;
        this.definingClassName = definingClassName;
    }

    public String getName() {
        return this.name;
    }

    public TypeParameter resolve() {
        if (!(this.containingMethodSignature == null || this.containingMethodSignature.typeParameters == null || this.containingMethodSignature.typeParameters.isEmpty())) {
            for (TypeParameter typeParameter : this.containingMethodSignature.typeParameters) {
                if (typeParameter.name.equals(this.name)) {
                    return typeParameter;
                }
            }
        }
        ClassInfo containingClassInfo = getClassInfo();
        if (containingClassInfo == null) {
            throw new IllegalArgumentException("Could not find ClassInfo object for " + this.definingClassName);
        }
        ClassTypeSignature containingClassSignature = containingClassInfo.getTypeSignature();
        if (!(containingClassSignature == null || containingClassSignature.typeParameters == null || containingClassSignature.typeParameters.isEmpty())) {
            for (TypeParameter typeParameter2 : containingClassSignature.typeParameters) {
                if (typeParameter2.name.equals(this.name)) {
                    return typeParameter2;
                }
            }
        }
        throw new IllegalArgumentException("Could not resolve " + this.name + " against parameters of the defining method or enclosing class");
    }

    /* access modifiers changed from: package-private */
    public static TypeVariableSignature parse(Parser parser, String definingClassName) throws ParseException {
        if (parser.peek() != 'T') {
            return null;
        }
        parser.next();
        if (!TypeUtils.getIdentifierToken(parser)) {
            throw new ParseException(parser, "Could not parse type variable signature");
        }
        parser.expect(';');
        TypeVariableSignature typeVariableSignature = new TypeVariableSignature(parser.currToken(), definingClassName);
        List<TypeVariableSignature> typeVariableSignatures = (List) parser.getState();
        if (typeVariableSignatures == null) {
            List<TypeVariableSignature> arrayList = new ArrayList<>();
            typeVariableSignatures = arrayList;
            parser.setState(arrayList);
        }
        typeVariableSignatures.add(typeVariableSignature);
        return typeVariableSignature;
    }

    @Override // p013io.github.classgraph.ScanResultObject
    protected String getClassName() {
        return this.definingClassName;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.TypeSignature
    public void findReferencedClassNames(Set<String> refdClassNames) {
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TypeVariableSignature)) {
            return false;
        }
        return ((TypeVariableSignature) obj).name.equals(this.name);
    }

    @Override // p013io.github.classgraph.TypeSignature
    public boolean equalsIgnoringTypeParams(TypeSignature other) {
        if (!(other instanceof ClassRefTypeSignature)) {
            return equals(other);
        }
        if (((ClassRefTypeSignature) other).className.equals("java.lang.Object")) {
            return true;
        }
        try {
            TypeParameter typeParameter = resolve();
            if (typeParameter.classBound == null && (typeParameter.interfaceBounds == null || typeParameter.interfaceBounds.isEmpty())) {
                return true;
            }
            if (typeParameter.classBound != null) {
                if (typeParameter.classBound instanceof ClassRefTypeSignature) {
                    if (typeParameter.classBound.equals(other)) {
                        return true;
                    }
                } else if (typeParameter.classBound instanceof TypeVariableSignature) {
                    return equalsIgnoringTypeParams(typeParameter.classBound);
                } else {
                    return false;
                }
            }
            if (typeParameter.interfaceBounds == null) {
                return false;
            }
            for (ReferenceTypeSignature interfaceBound : typeParameter.interfaceBounds) {
                if (interfaceBound instanceof ClassRefTypeSignature) {
                    if (interfaceBound.equals(other)) {
                        return true;
                    }
                } else if (interfaceBound instanceof TypeVariableSignature) {
                    return equalsIgnoringTypeParams(interfaceBound);
                } else {
                    return false;
                }
            }
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    public String toStringWithTypeBound() {
        try {
            return resolve().toString();
        } catch (IllegalArgumentException e) {
            return this.name;
        }
    }

    @Override // p013io.github.classgraph.TypeSignature
    protected String toStringInternal(boolean useSimpleNames) {
        return this.name;
    }
}
