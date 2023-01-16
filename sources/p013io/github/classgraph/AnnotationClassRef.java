package p013io.github.classgraph;

import nonapi.p019io.github.classgraph.types.ParseException;

/* renamed from: io.github.classgraph.AnnotationClassRef */
/* loaded from: grasscutter.jar:io/github/classgraph/AnnotationClassRef.class */
public class AnnotationClassRef extends ScanResultObject {
    private String typeDescriptorStr;
    private transient TypeSignature typeSignature;
    private transient String className;

    AnnotationClassRef() {
    }

    /* access modifiers changed from: package-private */
    public AnnotationClassRef(String typeDescriptorStr) {
        this.typeDescriptorStr = typeDescriptorStr;
    }

    public String getName() {
        return getClassName();
    }

    private TypeSignature getTypeSignature() {
        if (this.typeSignature == null) {
            try {
                this.typeSignature = TypeSignature.parse(this.typeDescriptorStr, (String) null);
                this.typeSignature.setScanResult(this.scanResult);
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return this.typeSignature;
    }

    @Override // p013io.github.classgraph.ScanResultObject
    public Class<?> loadClass(boolean ignoreExceptions) {
        getTypeSignature();
        if (this.typeSignature instanceof BaseTypeSignature) {
            return ((BaseTypeSignature) this.typeSignature).getType();
        }
        if (this.typeSignature instanceof ClassRefTypeSignature) {
            return ((ClassRefTypeSignature) this.typeSignature).loadClass(ignoreExceptions);
        }
        if (this.typeSignature instanceof ArrayTypeSignature) {
            return ((ArrayTypeSignature) this.typeSignature).loadClass(ignoreExceptions);
        }
        throw new IllegalArgumentException("Got unexpected type " + this.typeSignature.getClass().getName() + " for ref type signature: " + this.typeDescriptorStr);
    }

    @Override // p013io.github.classgraph.ScanResultObject
    public Class<?> loadClass() {
        return loadClass(false);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ScanResultObject
    public String getClassName() {
        if (this.className == null) {
            getTypeSignature();
            if (this.typeSignature instanceof BaseTypeSignature) {
                this.className = ((BaseTypeSignature) this.typeSignature).getTypeStr();
            } else if (this.typeSignature instanceof ClassRefTypeSignature) {
                this.className = ((ClassRefTypeSignature) this.typeSignature).getFullyQualifiedClassName();
            } else if (this.typeSignature instanceof ArrayTypeSignature) {
                this.className = ((ArrayTypeSignature) this.typeSignature).getClassName();
            } else {
                throw new IllegalArgumentException("Got unexpected type " + this.typeSignature.getClass().getName() + " for ref type signature: " + this.typeDescriptorStr);
            }
        }
        return this.className;
    }

    @Override // p013io.github.classgraph.ScanResultObject
    public ClassInfo getClassInfo() {
        getTypeSignature();
        return this.typeSignature.getClassInfo();
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ScanResultObject
    public void setScanResult(ScanResult scanResult) {
        setScanResult(scanResult);
        if (this.typeSignature != null) {
            this.typeSignature.setScanResult(scanResult);
        }
    }

    public int hashCode() {
        return getTypeSignature().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AnnotationClassRef)) {
            return false;
        }
        return getTypeSignature().equals(((AnnotationClassRef) obj).getTypeSignature());
    }

    public String toString() {
        ClassInfo ci;
        if (this.scanResult == null || (ci = getClassInfo()) == null || ci.isInterfaceOrAnnotation()) {
        }
        return getTypeSignature().toString() + ".class";
    }
}
