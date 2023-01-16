package p013io.github.classgraph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import nonapi.p019io.github.classgraph.utils.CollectionUtils;

/* renamed from: io.github.classgraph.PackageInfo */
/* loaded from: grasscutter.jar:io/github/classgraph/PackageInfo.class */
public class PackageInfo implements Comparable<PackageInfo>, HasName {
    private String name;
    private Set<AnnotationInfo> annotationInfoSet;
    private AnnotationInfoList annotationInfo;
    private PackageInfo parent;
    private Set<PackageInfo> children;
    private Map<String, ClassInfo> memberClassNameToClassInfo;

    PackageInfo() {
    }

    PackageInfo(String packageName) {
        this.name = packageName;
    }

    @Override // p013io.github.classgraph.HasName
    public String getName() {
        return this.name;
    }

    /* access modifiers changed from: package-private */
    public void addAnnotations(AnnotationInfoList packageAnnotations) {
        if (packageAnnotations != null && !packageAnnotations.isEmpty()) {
            if (this.annotationInfoSet == null) {
                this.annotationInfoSet = new LinkedHashSet();
            }
            this.annotationInfoSet.addAll(packageAnnotations);
        }
    }

    /* access modifiers changed from: package-private */
    public void addClassInfo(ClassInfo classInfo) {
        if (this.memberClassNameToClassInfo == null) {
            this.memberClassNameToClassInfo = new HashMap();
        }
        this.memberClassNameToClassInfo.put(classInfo.getName(), classInfo);
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

    public PackageInfo getParent() {
        return this.parent;
    }

    public PackageInfoList getChildren() {
        if (this.children == null) {
            return PackageInfoList.EMPTY_LIST;
        }
        PackageInfoList childrenSorted = new PackageInfoList(this.children);
        CollectionUtils.sortIfNotEmpty(childrenSorted, new Comparator<PackageInfo>() { // from class: io.github.classgraph.PackageInfo.1
            public int compare(PackageInfo o1, PackageInfo o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        return childrenSorted;
    }

    public ClassInfo getClassInfo(String className) {
        if (this.memberClassNameToClassInfo == null) {
            return null;
        }
        return this.memberClassNameToClassInfo.get(className);
    }

    public ClassInfoList getClassInfo() {
        return this.memberClassNameToClassInfo == null ? ClassInfoList.EMPTY_LIST : new ClassInfoList((Set<ClassInfo>) new HashSet(this.memberClassNameToClassInfo.values()), true);
    }

    private void obtainClassInfoRecursive(Set<ClassInfo> reachableClassInfo) {
        if (this.memberClassNameToClassInfo != null) {
            reachableClassInfo.addAll(this.memberClassNameToClassInfo.values());
        }
        Iterator it = getChildren().iterator();
        while (it.hasNext()) {
            ((PackageInfo) it.next()).obtainClassInfoRecursive(reachableClassInfo);
        }
    }

    public ClassInfoList getClassInfoRecursive() {
        Set<ClassInfo> reachableClassInfo = new HashSet<>();
        obtainClassInfoRecursive(reachableClassInfo);
        return new ClassInfoList(reachableClassInfo, true);
    }

    /* access modifiers changed from: package-private */
    public static String getParentPackageName(String packageOrClassName) {
        if (packageOrClassName.isEmpty()) {
            return null;
        }
        int lastDotIdx = packageOrClassName.lastIndexOf(46);
        return lastDotIdx < 0 ? "" : packageOrClassName.substring(0, lastDotIdx);
    }

    /* access modifiers changed from: package-private */
    public static PackageInfo getOrCreatePackage(String packageName, Map<String, PackageInfo> packageNameToPackageInfo) {
        PackageInfo parentPackageInfo;
        PackageInfo packageInfo = packageNameToPackageInfo.get(packageName);
        if (packageInfo != null) {
            return packageInfo;
        }
        PackageInfo packageInfo2 = new PackageInfo(packageName);
        packageNameToPackageInfo.put(packageName, packageInfo2);
        if (!packageName.isEmpty() && (parentPackageInfo = getOrCreatePackage(getParentPackageName(packageInfo2.name), packageNameToPackageInfo)) != null) {
            if (parentPackageInfo.children == null) {
                parentPackageInfo.children = new HashSet();
            }
            parentPackageInfo.children.add(packageInfo2);
            packageInfo2.parent = parentPackageInfo;
        }
        return packageInfo2;
    }

    public int compareTo(PackageInfo o) {
        return this.name.compareTo(o.name);
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
        if (!(obj instanceof PackageInfo)) {
            return false;
        }
        return this.name.equals(((PackageInfo) obj).name);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.name;
    }
}
