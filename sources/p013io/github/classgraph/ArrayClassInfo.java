package p013io.github.classgraph;

import java.util.Map;
import java.util.Set;

/* renamed from: io.github.classgraph.ArrayClassInfo */
/* loaded from: grasscutter.jar:io/github/classgraph/ArrayClassInfo.class */
public class ArrayClassInfo extends ClassInfo {
    private ArrayTypeSignature arrayTypeSignature;
    private ClassInfo elementClassInfo;

    ArrayClassInfo() {
    }

    /* access modifiers changed from: package-private */
    public ArrayClassInfo(ArrayTypeSignature arrayTypeSignature) {
        super(arrayTypeSignature.getClassName(), 0, null);
        this.arrayTypeSignature = arrayTypeSignature;
        getElementClassInfo();
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ClassInfo, p013io.github.classgraph.ScanResultObject
    public void setScanResult(ScanResult scanResult) {
        setScanResult(scanResult);
    }

    @Override // p013io.github.classgraph.ClassInfo
    public String getTypeSignatureStr() {
        return this.arrayTypeSignature.getTypeSignatureStr();
    }

    @Override // p013io.github.classgraph.ClassInfo
    public ClassTypeSignature getTypeSignature() {
        return null;
    }

    public ArrayTypeSignature getArrayTypeSignature() {
        return this.arrayTypeSignature;
    }

    public TypeSignature getElementTypeSignature() {
        return this.arrayTypeSignature.getElementTypeSignature();
    }

    public int getNumDimensions() {
        return this.arrayTypeSignature.getNumDimensions();
    }

    public ClassInfo getElementClassInfo() {
        if (this.elementClassInfo == null && !(this.arrayTypeSignature.getElementTypeSignature() instanceof BaseTypeSignature)) {
            this.elementClassInfo = this.arrayTypeSignature.getElementTypeSignature().getClassInfo();
            if (this.elementClassInfo != null) {
                this.classpathElement = this.elementClassInfo.classpathElement;
                this.classfileResource = this.elementClassInfo.classfileResource;
                this.classLoader = this.elementClassInfo.classLoader;
                this.isScannedClass = this.elementClassInfo.isScannedClass;
                this.isExternalClass = this.elementClassInfo.isExternalClass;
                this.moduleInfo = this.elementClassInfo.moduleInfo;
                this.packageInfo = this.elementClassInfo.packageInfo;
            }
        }
        return this.elementClassInfo;
    }

    public Class<?> loadElementClass(boolean ignoreExceptions) {
        return this.arrayTypeSignature.loadElementClass(ignoreExceptions);
    }

    public Class<?> loadElementClass() {
        return this.arrayTypeSignature.loadElementClass();
    }

    @Override // p013io.github.classgraph.ClassInfo, p013io.github.classgraph.ScanResultObject
    public Class<?> loadClass(boolean ignoreExceptions) {
        if (this.classRef == null) {
            this.classRef = this.arrayTypeSignature.loadClass(ignoreExceptions);
        }
        return this.classRef;
    }

    @Override // p013io.github.classgraph.ClassInfo, p013io.github.classgraph.ScanResultObject
    public Class<?> loadClass() {
        if (this.classRef == null) {
            this.classRef = this.arrayTypeSignature.loadClass();
        }
        return this.classRef;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ClassInfo, p013io.github.classgraph.ScanResultObject
    public void findReferencedClassInfo(Map<String, ClassInfo> classNameToClassInfo, Set<ClassInfo> refdClassInfo) {
        findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
    }

    @Override // p013io.github.classgraph.ClassInfo, java.lang.Object
    public boolean equals(Object obj) {
        return equals(obj);
    }

    @Override // p013io.github.classgraph.ClassInfo, java.lang.Object
    public int hashCode() {
        return hashCode();
    }
}
