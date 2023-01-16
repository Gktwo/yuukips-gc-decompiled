package p013io.github.classgraph;

import dev.morphia.mapping.Mapper;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import nonapi.p019io.github.classgraph.types.ParseException;
import nonapi.p019io.github.classgraph.types.TypeUtils;
import p013io.github.classgraph.ClassInfo;

/* renamed from: io.github.classgraph.FieldInfo */
/* loaded from: grasscutter.jar:io/github/classgraph/FieldInfo.class */
public class FieldInfo extends ScanResultObject implements Comparable<FieldInfo>, HasName {
    private String declaringClassName;
    private String name;
    private int modifiers;
    private String typeSignatureStr;
    private String typeDescriptorStr;
    private transient TypeSignature typeSignature;
    private transient TypeSignature typeDescriptor;
    private ObjectTypedValueWrapper constantInitializerValue;
    AnnotationInfoList annotationInfo;

    FieldInfo() {
    }

    /* access modifiers changed from: package-private */
    public FieldInfo(String definingClassName, String fieldName, int modifiers, String typeDescriptorStr, String typeSignatureStr, Object constantInitializerValue, AnnotationInfoList annotationInfo) {
        if (fieldName == null) {
            throw new IllegalArgumentException();
        }
        this.declaringClassName = definingClassName;
        this.name = fieldName;
        this.modifiers = modifiers;
        this.typeDescriptorStr = typeDescriptorStr;
        this.typeSignatureStr = typeSignatureStr;
        this.constantInitializerValue = constantInitializerValue == null ? null : new ObjectTypedValueWrapper(constantInitializerValue);
        this.annotationInfo = (annotationInfo == null || annotationInfo.isEmpty()) ? null : annotationInfo;
    }

    @Override // p013io.github.classgraph.HasName
    public String getName() {
        return this.name;
    }

    @Override // p013io.github.classgraph.ScanResultObject
    public ClassInfo getClassInfo() {
        return getClassInfo();
    }

    public String getModifierStr() {
        StringBuilder buf = new StringBuilder();
        TypeUtils.modifiersToString(this.modifiers, TypeUtils.ModifierType.FIELD, false, buf);
        return buf.toString();
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

    public boolean isTransient() {
        return Modifier.isTransient(this.modifiers);
    }

    public int getModifiers() {
        return this.modifiers;
    }

    public TypeSignature getTypeDescriptor() {
        if (this.typeDescriptorStr == null) {
            return null;
        }
        if (this.typeDescriptor == null) {
            try {
                this.typeDescriptor = TypeSignature.parse(this.typeDescriptorStr, this.declaringClassName);
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

    public TypeSignature getTypeSignature() {
        if (this.typeSignatureStr == null) {
            return null;
        }
        if (this.typeSignature == null) {
            try {
                this.typeSignature = TypeSignature.parse(this.typeSignatureStr, this.declaringClassName);
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

    public TypeSignature getTypeSignatureOrTypeDescriptor() {
        TypeSignature typeSig = getTypeSignature();
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

    public Object getConstantInitializerValue() {
        if (!this.scanResult.scanSpec.enableStaticFinalFieldConstantInitializerValues) {
            throw new IllegalArgumentException("Please call ClassGraph#enableStaticFinalFieldConstantInitializerValues() before #scan()");
        } else if (this.constantInitializerValue == null) {
            return null;
        } else {
            return this.constantInitializerValue.get();
        }
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

    public Field loadClassAndGetField() throws IllegalArgumentException {
        try {
            return loadClass().getField(getName());
        } catch (NoSuchFieldException e) {
            try {
                return loadClass().getDeclaredField(getName());
            } catch (NoSuchFieldException e2) {
                throw new IllegalArgumentException("No such field: " + getClassName() + Mapper.IGNORED_FIELDNAME + getName());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void handleRepeatableAnnotations(Set<String> allRepeatableAnnotationNames) {
        if (this.annotationInfo != null) {
            this.annotationInfo.handleRepeatableAnnotations(allRepeatableAnnotationNames, getClassInfo(), ClassInfo.RelType.FIELD_ANNOTATIONS, ClassInfo.RelType.CLASSES_WITH_FIELD_ANNOTATION, ClassInfo.RelType.CLASSES_WITH_NONPRIVATE_FIELD_ANNOTATION);
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
        if (this.typeSignature != null) {
            this.typeSignature.setScanResult(scanResult);
        }
        if (this.typeDescriptor != null) {
            this.typeDescriptor.setScanResult(scanResult);
        }
        if (this.annotationInfo != null) {
            Iterator it = this.annotationInfo.iterator();
            while (it.hasNext()) {
                ((AnnotationInfo) it.next()).setScanResult(scanResult);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ScanResultObject
    public void findReferencedClassInfo(Map<String, ClassInfo> classNameToClassInfo, Set<ClassInfo> refdClassInfo) {
        TypeSignature methodSig = getTypeSignature();
        if (methodSig != null) {
            methodSig.findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        }
        TypeSignature methodDesc = getTypeDescriptor();
        if (methodDesc != null) {
            methodDesc.findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        }
        if (this.annotationInfo != null) {
            Iterator it = this.annotationInfo.iterator();
            while (it.hasNext()) {
                ((AnnotationInfo) it.next()).findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
            }
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldInfo)) {
            return false;
        }
        FieldInfo other = (FieldInfo) obj;
        return this.declaringClassName.equals(other.declaringClassName) && this.name.equals(other.name);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.name.hashCode() + (this.declaringClassName.hashCode() * 11);
    }

    public int compareTo(FieldInfo other) {
        int diff = this.declaringClassName.compareTo(other.declaringClassName);
        if (diff != 0) {
            return diff;
        }
        return this.name.compareTo(other.name);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder buf = new StringBuilder();
        if (this.annotationInfo != null) {
            Iterator it = this.annotationInfo.iterator();
            while (it.hasNext()) {
                AnnotationInfo annotation = (AnnotationInfo) it.next();
                if (buf.length() > 0) {
                    buf.append(' ');
                }
                buf.append(annotation.toString());
            }
        }
        if (this.modifiers != 0) {
            if (buf.length() > 0) {
                buf.append(' ');
            }
            TypeUtils.modifiersToString(this.modifiers, TypeUtils.ModifierType.FIELD, false, buf);
        }
        if (buf.length() > 0) {
            buf.append(' ');
        }
        buf.append(getTypeSignatureOrTypeDescriptor().toString());
        buf.append(' ');
        buf.append(this.name);
        if (this.constantInitializerValue != null) {
            Object val = this.constantInitializerValue.get();
            buf.append(" = ");
            if (val instanceof String) {
                buf.append('\"').append(((String) val).replace("\\", "\\\\").replace("\"", "\\\"")).append('\"');
            } else if (val instanceof Character) {
                buf.append('\'').append(((Character) val).toString().replace("\\", "\\\\").replaceAll("'", "\\'")).append('\'');
            } else {
                buf.append(val.toString());
            }
        }
        return buf.toString();
    }
}
