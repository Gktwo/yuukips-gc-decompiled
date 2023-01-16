package p013io.github.classgraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nonapi.p019io.github.classgraph.types.ParseException;
import nonapi.p019io.github.classgraph.types.Parser;

/* renamed from: io.github.classgraph.MethodTypeSignature */
/* loaded from: grasscutter.jar:io/github/classgraph/MethodTypeSignature.class */
public final class MethodTypeSignature extends HierarchicalTypeSignature {
    final List<TypeParameter> typeParameters;
    private final List<TypeSignature> parameterTypeSignatures;
    private final TypeSignature resultType;
    private final List<ClassRefOrTypeVariableSignature> throwsSignatures;

    private MethodTypeSignature(List<TypeParameter> typeParameters, List<TypeSignature> paramTypes, TypeSignature resultType, List<ClassRefOrTypeVariableSignature> throwsSignatures) {
        this.typeParameters = typeParameters;
        this.parameterTypeSignatures = paramTypes;
        this.resultType = resultType;
        this.throwsSignatures = throwsSignatures;
    }

    /* access modifiers changed from: package-private */
    public List<TypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    /* access modifiers changed from: package-private */
    public List<TypeSignature> getParameterTypeSignatures() {
        return this.parameterTypeSignatures;
    }

    public TypeSignature getResultType() {
        return this.resultType;
    }

    public List<ClassRefOrTypeVariableSignature> getThrowsSignatures() {
        return this.throwsSignatures;
    }

    /* access modifiers changed from: package-private */
    public static MethodTypeSignature parse(String typeDescriptor, String definingClassName) throws ParseException {
        List<ClassRefOrTypeVariableSignature> throwsSignatures;
        if (typeDescriptor.equals("<init>")) {
            return new MethodTypeSignature(Collections.emptyList(), Collections.emptyList(), BaseTypeSignature.VOID, Collections.emptyList());
        }
        Parser parser = new Parser(typeDescriptor);
        List<TypeParameter> typeParameters = TypeParameter.parseList(parser, definingClassName);
        parser.expect('(');
        List<TypeSignature> paramTypes = new ArrayList<>();
        while (parser.peek() != ')') {
            if (!parser.hasMore()) {
                throw new ParseException(parser, "Ran out of input while parsing method signature");
            }
            TypeSignature paramType = TypeSignature.parse(parser, definingClassName);
            if (paramType == null) {
                throw new ParseException(parser, "Missing method parameter type signature");
            }
            paramTypes.add(paramType);
        }
        parser.expect(')');
        TypeSignature resultType = TypeSignature.parse(parser, definingClassName);
        if (resultType == null) {
            throw new ParseException(parser, "Missing method result type signature");
        }
        if (parser.peek() == '^') {
            throwsSignatures = new ArrayList<>();
            while (parser.peek() == '^') {
                parser.expect('^');
                ClassRefTypeSignature classTypeSignature = ClassRefTypeSignature.parse(parser, definingClassName);
                if (classTypeSignature != null) {
                    throwsSignatures.add(classTypeSignature);
                } else {
                    TypeVariableSignature typeVariableSignature = TypeVariableSignature.parse(parser, definingClassName);
                    if (typeVariableSignature != null) {
                        throwsSignatures.add(typeVariableSignature);
                    } else {
                        throw new ParseException(parser, "Missing type variable signature");
                    }
                }
            }
        } else {
            throwsSignatures = Collections.emptyList();
        }
        if (parser.hasMore()) {
            throw new ParseException(parser, "Extra characters at end of type descriptor");
        }
        MethodTypeSignature methodSignature = new MethodTypeSignature(typeParameters, paramTypes, resultType, throwsSignatures);
        List<TypeVariableSignature> typeVariableSignatures = (List) parser.getState();
        if (typeVariableSignatures != null) {
            for (TypeVariableSignature typeVariableSignature2 : typeVariableSignatures) {
                typeVariableSignature2.containingMethodSignature = methodSignature;
            }
        }
        return methodSignature;
    }

    @Override // p013io.github.classgraph.ScanResultObject
    protected String getClassName() {
        throw new IllegalArgumentException("getClassName() cannot be called here");
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ScanResultObject
    public ClassInfo getClassInfo() {
        throw new IllegalArgumentException("getClassInfo() cannot be called here");
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ScanResultObject
    public void setScanResult(ScanResult scanResult) {
        setScanResult(scanResult);
        if (this.typeParameters != null) {
            for (TypeParameter typeParameter : this.typeParameters) {
                typeParameter.setScanResult(scanResult);
            }
        }
        if (this.parameterTypeSignatures != null) {
            for (TypeSignature typeParameter2 : this.parameterTypeSignatures) {
                typeParameter2.setScanResult(scanResult);
            }
        }
        if (this.resultType != null) {
            this.resultType.setScanResult(scanResult);
        }
        if (this.throwsSignatures != null) {
            for (ClassRefOrTypeVariableSignature throwsSignature : this.throwsSignatures) {
                throwsSignature.setScanResult(scanResult);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void findReferencedClassNames(Set<String> refdClassNames) {
        for (TypeParameter typeParameter : this.typeParameters) {
            if (typeParameter != null) {
                typeParameter.findReferencedClassNames(refdClassNames);
            }
        }
        for (TypeSignature typeSignature : this.parameterTypeSignatures) {
            if (typeSignature != null) {
                typeSignature.findReferencedClassNames(refdClassNames);
            }
        }
        this.resultType.findReferencedClassNames(refdClassNames);
        for (ClassRefOrTypeVariableSignature typeSignature2 : this.throwsSignatures) {
            if (typeSignature2 != null) {
                typeSignature2.findReferencedClassNames(refdClassNames);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ScanResultObject
    public void findReferencedClassInfo(Map<String, ClassInfo> classNameToClassInfo, Set<ClassInfo> refdClassInfo) {
        Set<String> refdClassNames = new HashSet<>();
        findReferencedClassNames(refdClassNames);
        for (String refdClassName : refdClassNames) {
            ClassInfo classInfo = ClassInfo.getOrCreateClassInfo(refdClassName, classNameToClassInfo);
            classInfo.scanResult = this.scanResult;
            refdClassInfo.add(classInfo);
        }
    }

    public int hashCode() {
        return this.typeParameters.hashCode() + (this.parameterTypeSignatures.hashCode() * 7) + (this.resultType.hashCode() * 15) + (this.throwsSignatures.hashCode() * 31);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MethodTypeSignature)) {
            return false;
        }
        MethodTypeSignature o = (MethodTypeSignature) obj;
        return o.typeParameters.equals(this.typeParameters) && o.parameterTypeSignatures.equals(this.parameterTypeSignatures) && o.resultType.equals(this.resultType) && o.throwsSignatures.equals(this.throwsSignatures);
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        if (!this.typeParameters.isEmpty()) {
            buf.append('<');
            for (int i = 0; i < this.typeParameters.size(); i++) {
                if (i > 0) {
                    buf.append(", ");
                }
                buf.append(this.typeParameters.get(i).toString());
            }
            buf.append('>');
        }
        if (buf.length() > 0) {
            buf.append(' ');
        }
        buf.append(this.resultType.toString());
        buf.append(" (");
        for (int i2 = 0; i2 < this.parameterTypeSignatures.size(); i2++) {
            if (i2 > 0) {
                buf.append(", ");
            }
            buf.append(this.parameterTypeSignatures.get(i2).toString());
        }
        buf.append(')');
        if (!this.throwsSignatures.isEmpty()) {
            buf.append(" throws ");
            for (int i3 = 0; i3 < this.throwsSignatures.size(); i3++) {
                if (i3 > 0) {
                    buf.append(", ");
                }
                buf.append(this.throwsSignatures.get(i3).toString());
            }
        }
        return buf.toString();
    }
}
