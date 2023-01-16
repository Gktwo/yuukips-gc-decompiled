package p013io.github.classgraph;

import dev.morphia.mapping.Mapper;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nonapi.p019io.github.classgraph.types.ParseException;
import nonapi.p019io.github.classgraph.types.TypeUtils;
import p013io.github.classgraph.ClassInfo;

/* renamed from: io.github.classgraph.MethodInfo */
/* loaded from: grasscutter.jar:io/github/classgraph/MethodInfo.class */
public class MethodInfo extends ScanResultObject implements Comparable<MethodInfo>, HasName {
    private String declaringClassName;
    private String name;
    private int modifiers;
    AnnotationInfoList annotationInfo;
    private String typeDescriptorStr;
    private transient MethodTypeSignature typeDescriptor;
    private String typeSignatureStr;
    private transient MethodTypeSignature typeSignature;
    private String[] parameterNames;
    private int[] parameterModifiers;
    AnnotationInfo[][] parameterAnnotationInfo;
    private transient MethodParameterInfo[] parameterInfo;
    private boolean hasBody;

    MethodInfo() {
    }

    /* access modifiers changed from: package-private */
    public MethodInfo(String definingClassName, String methodName, AnnotationInfoList methodAnnotationInfo, int modifiers, String typeDescriptorStr, String typeSignatureStr, String[] parameterNames, int[] parameterModifiers, AnnotationInfo[][] parameterAnnotationInfo, boolean hasBody) {
        this.declaringClassName = definingClassName;
        this.name = methodName;
        this.modifiers = modifiers;
        this.typeDescriptorStr = typeDescriptorStr;
        this.typeSignatureStr = typeSignatureStr;
        this.parameterNames = parameterNames;
        this.parameterModifiers = parameterModifiers;
        this.parameterAnnotationInfo = parameterAnnotationInfo;
        this.annotationInfo = (methodAnnotationInfo == null || methodAnnotationInfo.isEmpty()) ? null : methodAnnotationInfo;
        this.hasBody = hasBody;
    }

    @Override // p013io.github.classgraph.HasName
    public String getName() {
        return this.name;
    }

    public int getModifiers() {
        return this.modifiers;
    }

    public String getModifiersStr() {
        StringBuilder buf = new StringBuilder();
        TypeUtils.modifiersToString(this.modifiers, TypeUtils.ModifierType.METHOD, isDefault(), buf);
        return buf.toString();
    }

    @Override // p013io.github.classgraph.ScanResultObject
    public ClassInfo getClassInfo() {
        return getClassInfo();
    }

    public MethodTypeSignature getTypeDescriptor() {
        if (this.typeDescriptor == null) {
            try {
                this.typeDescriptor = MethodTypeSignature.parse(this.typeDescriptorStr, this.declaringClassName);
                this.typeDescriptor.setScanResult(this.scanResult);
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return this.typeDescriptor;
    }

    public String getTypeDescriptorStr() {
        return this.typeDescriptorStr;
    }

    public MethodTypeSignature getTypeSignature() {
        if (this.typeSignature == null && this.typeSignatureStr != null) {
            try {
                this.typeSignature = MethodTypeSignature.parse(this.typeSignatureStr, this.declaringClassName);
                this.typeSignature.setScanResult(this.scanResult);
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return this.typeSignature;
    }

    public String getTypeSignatureStr() {
        return this.typeSignatureStr;
    }

    public MethodTypeSignature getTypeSignatureOrTypeDescriptor() {
        MethodTypeSignature typeSig = getTypeSignature();
        if (typeSig != null) {
            return typeSig;
        }
        return getTypeDescriptor();
    }

    public String getTypeSignatureOrTypeDescriptorStr() {
        if (this.typeSignatureStr != null) {
            return this.typeSignatureStr;
        }
        return this.typeDescriptorStr;
    }

    public boolean isConstructor() {
        return "<init>".equals(this.name);
    }

    public boolean isPublic() {
        return Modifier.isPublic(this.modifiers);
    }

    public boolean isStatic() {
        return Modifier.isStatic(this.modifiers);
    }

    public boolean isFinal() {
        return Modifier.isFinal(this.modifiers);
    }

    public boolean isSynchronized() {
        return Modifier.isSynchronized(this.modifiers);
    }

    public boolean isBridge() {
        return (this.modifiers & 64) != 0;
    }

    public boolean isSynthetic() {
        return (this.modifiers & 4096) != 0;
    }

    public boolean isVarArgs() {
        return (this.modifiers & 128) != 0;
    }

    public boolean isNative() {
        return Modifier.isNative(this.modifiers);
    }

    public boolean hasBody() {
        return this.hasBody;
    }

    public boolean isDefault() {
        ClassInfo classInfo = getClassInfo();
        return classInfo != null && classInfo.isInterface() && this.hasBody;
    }

    public MethodParameterInfo[] getParameterInfo() {
        if (this.parameterInfo == null) {
            List<TypeSignature> paramTypeDescriptors = getTypeDescriptor().getParameterTypeSignatures();
            List<TypeSignature> paramTypeSignatures = getTypeSignature() != null ? getTypeSignature().getParameterTypeSignatures() : null;
            int numParams = paramTypeDescriptors.size();
            if (paramTypeSignatures == null || paramTypeSignatures.size() <= numParams) {
                if (Math.max(this.parameterNames == null ? 0 : this.parameterNames.length, Math.max(this.parameterModifiers == null ? 0 : this.parameterModifiers.length, this.parameterAnnotationInfo == null ? 0 : this.parameterAnnotationInfo.length)) > numParams) {
                    throw ClassGraphException.newClassGraphException("Type descriptor for method " + this.declaringClassName + Mapper.IGNORED_FIELDNAME + this.name + " has insufficient parameters");
                }
                String[] paramNamesAligned = null;
                if (this.parameterNames != null && numParams > 0) {
                    if (this.parameterNames.length == numParams) {
                        paramNamesAligned = this.parameterNames;
                    } else {
                        paramNamesAligned = new String[numParams];
                        int lenDiff = numParams - this.parameterNames.length;
                        for (int i = 0; i < this.parameterNames.length; i++) {
                            paramNamesAligned[lenDiff + i] = this.parameterNames[i];
                        }
                    }
                }
                int[] paramModifiersAligned = null;
                if (this.parameterModifiers != null && numParams > 0) {
                    if (this.parameterModifiers.length == numParams) {
                        paramModifiersAligned = this.parameterModifiers;
                    } else {
                        paramModifiersAligned = new int[numParams];
                        int lenDiff2 = numParams - this.parameterModifiers.length;
                        for (int i2 = 0; i2 < this.parameterModifiers.length; i2++) {
                            paramModifiersAligned[lenDiff2 + i2] = this.parameterModifiers[i2];
                        }
                    }
                }
                AnnotationInfo[][] paramAnnotationInfoAligned = null;
                if (this.parameterAnnotationInfo != null && numParams > 0) {
                    if (this.parameterAnnotationInfo.length == numParams) {
                        paramAnnotationInfoAligned = this.parameterAnnotationInfo;
                    } else {
                        paramAnnotationInfoAligned = new AnnotationInfo[numParams];
                        int lenDiff3 = numParams - this.parameterAnnotationInfo.length;
                        for (int i3 = 0; i3 < this.parameterAnnotationInfo.length; i3++) {
                            paramAnnotationInfoAligned[lenDiff3 + i3] = this.parameterAnnotationInfo[i3];
                        }
                    }
                }
                List<TypeSignature> paramTypeSignaturesAligned = null;
                if (paramTypeSignatures != null && numParams > 0) {
                    if (paramTypeSignatures.size() == paramTypeDescriptors.size()) {
                        paramTypeSignaturesAligned = paramTypeSignatures;
                    } else {
                        paramTypeSignaturesAligned = new ArrayList<>(numParams);
                        int n = numParams - paramTypeSignatures.size();
                        for (int i4 = 0; i4 < n; i4++) {
                            paramTypeSignaturesAligned.add(null);
                        }
                        paramTypeSignaturesAligned.addAll(paramTypeSignatures);
                    }
                }
                this.parameterInfo = new MethodParameterInfo[numParams];
                for (int i5 = 0; i5 < numParams; i5++) {
                    this.parameterInfo[i5] = new MethodParameterInfo(this, paramAnnotationInfoAligned == null ? null : paramAnnotationInfoAligned[i5], paramModifiersAligned == null ? 0 : paramModifiersAligned[i5], paramTypeDescriptors.get(i5), paramTypeSignaturesAligned == null ? null : paramTypeSignaturesAligned.get(i5), paramNamesAligned == null ? null : paramNamesAligned[i5]);
                    this.parameterInfo[i5].setScanResult(this.scanResult);
                }
            } else {
                throw ClassGraphException.newClassGraphException("typeSignatureParamTypes.size() > typeDescriptorParamTypes.size() for method " + this.declaringClassName + Mapper.IGNORED_FIELDNAME + this.name);
            }
        }
        return this.parameterInfo;
    }

    public AnnotationInfoList getAnnotationInfo() {
        if (this.scanResult.scanSpec.enableAnnotationInfo) {
            return this.annotationInfo == null ? AnnotationInfoList.EMPTY_LIST : AnnotationInfoList.getIndirectAnnotations(this.annotationInfo, null);
        }
        throw new IllegalArgumentException("Please call ClassGraph#enableAnnotationInfo() before #scan()");
    }

    public AnnotationInfo getAnnotationInfo(String annotationName) {
        return getAnnotationInfo().get(annotationName);
    }

    public AnnotationInfoList getAnnotationInfoRepeatable(String annotationName) {
        return getAnnotationInfo().getRepeatable(annotationName);
    }

    public boolean hasAnnotation(String annotationName) {
        return getAnnotationInfo().containsName(annotationName);
    }

    public boolean hasParameterAnnotation(String annotationName) {
        for (MethodParameterInfo methodParameterInfo : getParameterInfo()) {
            if (methodParameterInfo.hasAnnotation(annotationName)) {
                return true;
            }
        }
        return false;
    }

    public Method loadClassAndGetMethod() throws IllegalArgumentException {
        MethodParameterInfo[] allParameterInfo = getParameterInfo();
        List<Class<?>> parameterClasses = new ArrayList<>(allParameterInfo.length);
        for (MethodParameterInfo mpi : allParameterInfo) {
            parameterClasses.add(mpi.getTypeSignatureOrTypeDescriptor().loadClass());
        }
        Class<?>[] parameterClassesArr = (Class[]) parameterClasses.toArray(new Class[0]);
        try {
            return loadClass().getMethod(getName(), parameterClassesArr);
        } catch (NoSuchMethodException e) {
            try {
                return loadClass().getDeclaredMethod(getName(), parameterClassesArr);
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException("No such method: " + getClassName() + Mapper.IGNORED_FIELDNAME + getName());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void handleRepeatableAnnotations(Set<String> allRepeatableAnnotationNames) {
        if (this.annotationInfo != null) {
            this.annotationInfo.handleRepeatableAnnotations(allRepeatableAnnotationNames, getClassInfo(), ClassInfo.RelType.METHOD_ANNOTATIONS, ClassInfo.RelType.CLASSES_WITH_METHOD_ANNOTATION, ClassInfo.RelType.CLASSES_WITH_NONPRIVATE_METHOD_ANNOTATION);
        }
        if (this.parameterAnnotationInfo != null) {
            for (int i = 0; i < this.parameterAnnotationInfo.length; i++) {
                AnnotationInfo[] pai = this.parameterAnnotationInfo[i];
                if (pai != null && pai.length > 0) {
                    boolean hasRepeatableAnnotation = false;
                    int length = pai.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (allRepeatableAnnotationNames.contains(pai[i2].getName())) {
                            hasRepeatableAnnotation = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (hasRepeatableAnnotation) {
                        AnnotationInfoList aiList = new AnnotationInfoList(pai.length);
                        for (AnnotationInfo ai : pai) {
                            aiList.add(ai);
                        }
                        aiList.handleRepeatableAnnotations(allRepeatableAnnotationNames, getClassInfo(), ClassInfo.RelType.METHOD_PARAMETER_ANNOTATIONS, ClassInfo.RelType.CLASSES_WITH_METHOD_PARAMETER_ANNOTATION, ClassInfo.RelType.CLASSES_WITH_NONPRIVATE_METHOD_PARAMETER_ANNOTATION);
                        this.parameterAnnotationInfo[i] = (AnnotationInfo[]) aiList.toArray(new AnnotationInfo[0]);
                    }
                }
            }
        }
    }

    @Override // p013io.github.classgraph.ScanResultObject
    protected String getClassName() {
        return this.declaringClassName;
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ScanResultObject
    public void setScanResult(ScanResult scanResult) {
        setScanResult(scanResult);
        if (this.typeDescriptor != null) {
            this.typeDescriptor.setScanResult(scanResult);
        }
        if (this.typeSignature != null) {
            this.typeSignature.setScanResult(scanResult);
        }
        if (this.annotationInfo != null) {
            Iterator it = this.annotationInfo.iterator();
            while (it.hasNext()) {
                ((AnnotationInfo) it.next()).setScanResult(scanResult);
            }
        }
        if (this.parameterAnnotationInfo != null) {
            AnnotationInfo[][] annotationInfoArr = this.parameterAnnotationInfo;
            for (AnnotationInfo[] pai : annotationInfoArr) {
                if (pai != null) {
                    for (AnnotationInfo ai : pai) {
                        ai.setScanResult(scanResult);
                    }
                }
            }
        }
        if (this.parameterInfo != null) {
            for (MethodParameterInfo mpi : this.parameterInfo) {
                mpi.setScanResult(scanResult);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ScanResultObject
    public void findReferencedClassInfo(Map<String, ClassInfo> classNameToClassInfo, Set<ClassInfo> refdClassInfo) {
        MethodTypeSignature methodSig = getTypeSignature();
        if (methodSig != null) {
            methodSig.findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        }
        MethodTypeSignature methodDesc = getTypeDescriptor();
        if (methodDesc != null) {
            methodDesc.findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        }
        if (this.annotationInfo != null) {
            Iterator it = this.annotationInfo.iterator();
            while (it.hasNext()) {
                ((AnnotationInfo) it.next()).findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
            }
        }
        for (MethodParameterInfo mpi : getParameterInfo()) {
            AnnotationInfo[] aiArr = mpi.annotationInfo;
            if (aiArr != null) {
                for (AnnotationInfo ai : aiArr) {
                    ai.findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
                }
            }
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MethodInfo)) {
            return false;
        }
        MethodInfo other = (MethodInfo) obj;
        return this.declaringClassName.equals(other.declaringClassName) && this.typeDescriptorStr.equals(other.typeDescriptorStr) && this.name.equals(other.name);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.name.hashCode() + (this.typeDescriptorStr.hashCode() * 11) + (this.declaringClassName.hashCode() * 57);
    }

    public int compareTo(MethodInfo other) {
        int diff0 = this.declaringClassName.compareTo(other.declaringClassName);
        if (diff0 != 0) {
            return diff0;
        }
        int diff1 = this.name.compareTo(other.name);
        if (diff1 != 0) {
            return diff1;
        }
        return this.typeDescriptorStr.compareTo(other.typeDescriptorStr);
    }

    @Override // java.lang.Object
    public String toString() {
        String paramName;
        MethodTypeSignature methodType = getTypeSignatureOrTypeDescriptor();
        StringBuilder buf = new StringBuilder();
        if (this.annotationInfo != null) {
            Iterator it = this.annotationInfo.iterator();
            while (it.hasNext()) {
                AnnotationInfo annotation = (AnnotationInfo) it.next();
                if (buf.length() > 0) {
                    buf.append(' ');
                }
                annotation.toString(buf);
            }
        }
        if (this.modifiers != 0) {
            if (buf.length() > 0) {
                buf.append(' ');
            }
            TypeUtils.modifiersToString(this.modifiers, TypeUtils.ModifierType.METHOD, isDefault(), buf);
        }
        List<TypeParameter> typeParameters = methodType.getTypeParameters();
        if (!typeParameters.isEmpty()) {
            if (buf.length() > 0) {
                buf.append(' ');
            }
            buf.append('<');
            for (int i = 0; i < typeParameters.size(); i++) {
                if (i > 0) {
                    buf.append(", ");
                }
                buf.append(typeParameters.get(i).toString());
            }
            buf.append('>');
        }
        if (!isConstructor()) {
            if (buf.length() > 0) {
                buf.append(' ');
            }
            buf.append(methodType.getResultType().toString());
        }
        buf.append(' ');
        if (this.name != null) {
            buf.append(this.name);
        }
        MethodParameterInfo[] allParamInfo = getParameterInfo();
        boolean hasParamNames = false;
        int length = allParamInfo.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (allParamInfo[i2].getName() != null) {
                hasParamNames = true;
                break;
            } else {
                i2++;
            }
        }
        int varArgsParamIndex = -1;
        if (isVarArgs()) {
            int i3 = allParamInfo.length - 1;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                int mods = allParamInfo[i3].getModifiers();
                if ((mods & 4096) == 0 && (mods & 32768) == 0 && (allParamInfo[i3].getTypeSignatureOrTypeDescriptor() instanceof ArrayTypeSignature)) {
                    varArgsParamIndex = i3;
                    break;
                }
                i3--;
            }
        }
        buf.append('(');
        int numParams = allParamInfo.length;
        for (int i4 = 0; i4 < numParams; i4++) {
            MethodParameterInfo paramInfo = allParamInfo[i4];
            if (i4 > 0) {
                buf.append(", ");
            }
            if (paramInfo.annotationInfo != null) {
                for (AnnotationInfo ai : paramInfo.annotationInfo) {
                    ai.toString(buf);
                    buf.append(' ');
                }
            }
            MethodParameterInfo.modifiersToString(paramInfo.getModifiers(), buf);
            TypeSignature paramType = paramInfo.getTypeSignatureOrTypeDescriptor();
            if (i4 != varArgsParamIndex) {
                buf.append(paramType.toString());
            } else if (!(paramType instanceof ArrayTypeSignature)) {
                throw new IllegalArgumentException("Got non-array type for last parameter of varargs method " + this.name);
            } else {
                ArrayTypeSignature arrayType = (ArrayTypeSignature) paramType;
                if (arrayType.getNumDimensions() == 0) {
                    throw new IllegalArgumentException("Got a zero-dimension array type for last parameter of varargs method " + this.name);
                }
                buf.append(new ArrayTypeSignature(arrayType.getElementTypeSignature(), arrayType.getNumDimensions() - 1, null).toString());
                buf.append("...");
            }
            if (hasParamNames && (paramName = paramInfo.getName()) != null) {
                buf.append(' ');
                buf.append(paramName);
            }
        }
        buf.append(')');
        if (!methodType.getThrowsSignatures().isEmpty()) {
            buf.append(" throws ");
            for (int i5 = 0; i5 < methodType.getThrowsSignatures().size(); i5++) {
                if (i5 > 0) {
                    buf.append(", ");
                }
                buf.append(methodType.getThrowsSignatures().get(i5).toString());
            }
        }
        return buf.toString();
    }
}
