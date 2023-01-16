package p013io.github.classgraph;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* access modifiers changed from: package-private */
/* renamed from: io.github.classgraph.ScanResultObject */
/* loaded from: grasscutter.jar:io/github/classgraph/ScanResultObject.class */
public abstract class ScanResultObject {
    protected transient ScanResult scanResult;
    private transient ClassInfo classInfo;
    protected transient Class<?> classRef;

    protected abstract String getClassName();

    /* access modifiers changed from: package-private */
    public void setScanResult(ScanResult scanResult) {
        this.scanResult = scanResult;
    }

    final Set<ClassInfo> findReferencedClassInfo() {
        Set<ClassInfo> refdClassInfo = new LinkedHashSet<>();
        if (this.scanResult != null) {
            findReferencedClassInfo(this.scanResult.classNameToClassInfo, refdClassInfo);
        }
        return refdClassInfo;
    }

    /* access modifiers changed from: protected */
    public void findReferencedClassInfo(Map<String, ClassInfo> classNameToClassInfo, Set<ClassInfo> refdClassInfo) {
        ClassInfo ci = getClassInfo();
        if (ci != null) {
            refdClassInfo.add(ci);
        }
    }

    /* access modifiers changed from: package-private */
    public ClassInfo getClassInfo() {
        if (this.classInfo == null) {
            if (this.scanResult == null) {
                return null;
            }
            String className = getClassName();
            if (className == null) {
                throw new IllegalArgumentException("Class name is not set");
            }
            this.classInfo = this.scanResult.getClassInfo(className);
        }
        return this.classInfo;
    }

    private String getClassInfoNameOrClassName() {
        String className;
        ClassInfo ci = null;
        try {
            ci = getClassInfo();
        } catch (IllegalArgumentException e) {
        }
        if (ci == null) {
            ci = this.classInfo;
        }
        if (ci != null) {
            className = ci.getName();
        } else {
            className = getClassName();
        }
        if (className != null) {
            return className;
        }
        throw new IllegalArgumentException("Class name is not set");
    }

    /* access modifiers changed from: package-private */
    public <T> Class<T> loadClass(Class<T> superclassOrInterfaceType, boolean ignoreExceptions) {
        IllegalArgumentException illegalArgumentException;
        if (this.classRef == null) {
            String className = getClassInfoNameOrClassName();
            if (this.scanResult != null) {
                this.classRef = this.scanResult.loadClass(className, superclassOrInterfaceType, ignoreExceptions);
            } else {
                try {
                    this.classRef = Class.forName(className);
                } finally {
                    if (!ignoreExceptions) {
                    }
                }
            }
        }
        return (Class<T>) this.classRef;
    }

    <T> Class<T> loadClass(Class<T> superclassOrInterfaceType) {
        return loadClass(superclassOrInterfaceType, false);
    }

    /* access modifiers changed from: package-private */
    public Class<?> loadClass(boolean ignoreExceptions) {
        IllegalArgumentException illegalArgumentException;
        if (this.classRef == null) {
            String className = getClassInfoNameOrClassName();
            if (this.scanResult != null) {
                this.classRef = this.scanResult.loadClass(className, ignoreExceptions);
            } else {
                try {
                    this.classRef = Class.forName(className);
                } finally {
                    if (!ignoreExceptions) {
                    }
                }
            }
        }
        return this.classRef;
    }

    Class<?> loadClass() {
        return loadClass(false);
    }
}
