package p013io.github.classgraph;

import java.net.URI;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import nonapi.p019io.github.classgraph.utils.CollectionUtils;

/* renamed from: io.github.classgraph.ModuleInfo */
/* loaded from: grasscutter.jar:io/github/classgraph/ModuleInfo.class */
public class ModuleInfo implements Comparable<ModuleInfo>, HasName {
    private String name;
    private transient ClasspathElement classpathElement;
    private transient ModuleRef moduleRef;
    private transient URI locationURI;
    private Set<AnnotationInfo> annotationInfoSet;
    private AnnotationInfoList annotationInfo;
    private Set<PackageInfo> packageInfoSet;
    private Set<ClassInfo> classInfoSet;

    ModuleInfo() {
    }

    /* access modifiers changed from: package-private */
    public ModuleInfo(ModuleRef moduleRef, ClasspathElement classpathElement) {
        this.moduleRef = moduleRef;
        this.classpathElement = classpathElement;
        this.name = classpathElement.getModuleName();
    }

    @Override // p013io.github.classgraph.HasName
    public String getName() {
        return this.name;
    }

    public URI getLocation() {
        if (this.locationURI == null) {
            this.locationURI = this.moduleRef != null ? this.moduleRef.getLocation() : null;
            if (this.locationURI == null) {
                this.locationURI = this.classpathElement.getURI();
            }
        }
        return this.locationURI;
    }

    public ModuleRef getModuleRef() {
        return this.moduleRef;
    }

    /* access modifiers changed from: package-private */
    public void addClassInfo(ClassInfo classInfo) {
        if (this.classInfoSet == null) {
            this.classInfoSet = new HashSet();
        }
        this.classInfoSet.add(classInfo);
    }

    public ClassInfo getClassInfo(String className) {
        for (ClassInfo ci : this.classInfoSet) {
            if (ci.getName().equals(className)) {
                return ci;
            }
        }
        return null;
    }

    public ClassInfoList getClassInfo() {
        return new ClassInfoList(this.classInfoSet, true);
    }

    /* access modifiers changed from: package-private */
    public void addPackageInfo(PackageInfo packageInfo) {
        if (this.packageInfoSet == null) {
            this.packageInfoSet = new HashSet();
        }
        this.packageInfoSet.add(packageInfo);
    }

    public PackageInfo getPackageInfo(String packageName) {
        if (this.packageInfoSet == null) {
            return null;
        }
        for (PackageInfo pi : this.packageInfoSet) {
            if (pi.getName().equals(packageName)) {
                return pi;
            }
        }
        return null;
    }

    public PackageInfoList getPackageInfo() {
        if (this.packageInfoSet == null) {
            return new PackageInfoList(1);
        }
        PackageInfoList packageInfoList = new PackageInfoList(this.packageInfoSet);
        CollectionUtils.sortIfNotEmpty(packageInfoList);
        return packageInfoList;
    }

    /* access modifiers changed from: package-private */
    public void addAnnotations(AnnotationInfoList moduleAnnotations) {
        if (moduleAnnotations != null && !moduleAnnotations.isEmpty()) {
            if (this.annotationInfoSet == null) {
                this.annotationInfoSet = new LinkedHashSet();
            }
            this.annotationInfoSet.addAll(moduleAnnotations);
        }
    }

    public AnnotationInfo getAnnotationInfo(String annotationName) {
        return getAnnotationInfo().get(annotationName);
    }

    public AnnotationInfoList getAnnotationInfo() {
        if (this.annotationInfo == null) {
            if (this.annotationInfoSet == null) {
                this.annotationInfo = AnnotationInfoList.EMPTY_LIST;
            } else {
                this.annotationInfo = new AnnotationInfoList();
                this.annotationInfo.addAll(this.annotationInfoSet);
            }
        }
        return this.annotationInfo;
    }

    public boolean hasAnnotation(String annotationName) {
        return getAnnotationInfo().containsName(annotationName);
    }

    public int compareTo(ModuleInfo other) {
        int diff = this.name.compareTo(other.name);
        if (diff != 0) {
            return diff;
        }
        URI thisLoc = getLocation();
        URI otherLoc = other.getLocation();
        if (thisLoc == null || otherLoc == null) {
            return 0;
        }
        return thisLoc.compareTo(otherLoc);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof ModuleInfo) && compareTo((ModuleInfo) obj) == 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.name;
    }
}
