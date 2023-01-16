package p013io.github.classgraph;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.CollectionUtils;
import p013io.github.classgraph.ClassInfo;

/* renamed from: io.github.classgraph.ClassInfoList */
/* loaded from: grasscutter.jar:io/github/classgraph/ClassInfoList.class */
public class ClassInfoList extends MappableInfoList<ClassInfo> {
    private final transient Set<ClassInfo> directlyRelatedClasses;
    private final boolean sortByName;
    private static final long serialVersionUID = 1;
    static final ClassInfoList EMPTY_LIST = new ClassInfoList();

    @FunctionalInterface
    /* renamed from: io.github.classgraph.ClassInfoList$ClassInfoFilter */
    /* loaded from: grasscutter.jar:io/github/classgraph/ClassInfoList$ClassInfoFilter.class */
    public interface ClassInfoFilter {
        boolean accept(ClassInfo classInfo);
    }

    static {
        EMPTY_LIST.makeUnmodifiable();
    }

    public static ClassInfoList emptyList() {
        return EMPTY_LIST;
    }

    /* access modifiers changed from: package-private */
    public ClassInfoList(Set<ClassInfo> reachableClasses, Set<ClassInfo> directlyRelatedClasses, boolean sortByName) {
        super(reachableClasses);
        this.sortByName = sortByName;
        if (sortByName) {
            CollectionUtils.sortIfNotEmpty(this);
        }
        this.directlyRelatedClasses = directlyRelatedClasses == null ? reachableClasses : directlyRelatedClasses;
    }

    /* access modifiers changed from: package-private */
    public ClassInfoList(ClassInfo.ReachableAndDirectlyRelatedClasses reachableAndDirectlyRelatedClasses, boolean sortByName) {
        this(reachableAndDirectlyRelatedClasses.reachableClasses, reachableAndDirectlyRelatedClasses.directlyRelatedClasses, sortByName);
    }

    /* access modifiers changed from: package-private */
    public ClassInfoList(Set<ClassInfo> reachableClasses, boolean sortByName) {
        this(reachableClasses, null, sortByName);
    }

    public ClassInfoList() {
        super(1);
        this.sortByName = false;
        this.directlyRelatedClasses = new HashSet(2);
    }

    public ClassInfoList(int sizeHint) {
        super(sizeHint);
        this.sortByName = false;
        this.directlyRelatedClasses = new HashSet(2);
    }

    public ClassInfoList(Collection<ClassInfo> classInfoCollection) {
        this(classInfoCollection instanceof Set ? (Set) classInfoCollection : new HashSet(classInfoCollection), null, true);
    }

    public <T> List<Class<T>> loadClasses(Class<T> superclassOrInterfaceType, boolean ignoreExceptions) {
        if (isEmpty()) {
            return Collections.emptyList();
        }
        List<Class<T>> classRefs = new ArrayList<>();
        Iterator it = iterator();
        while (it.hasNext()) {
            Class<T> classRef = ((ClassInfo) it.next()).loadClass(superclassOrInterfaceType, ignoreExceptions);
            if (classRef != null) {
                classRefs.add(classRef);
            }
        }
        return classRefs.isEmpty() ? Collections.emptyList() : classRefs;
    }

    public <T> List<Class<T>> loadClasses(Class<T> superclassOrInterfaceType) {
        return loadClasses(superclassOrInterfaceType, false);
    }

    public List<Class<?>> loadClasses(boolean ignoreExceptions) {
        if (isEmpty()) {
            return Collections.emptyList();
        }
        List<Class<?>> classRefs = new ArrayList<>();
        Iterator it = iterator();
        while (it.hasNext()) {
            Class<?> classRef = ((ClassInfo) it.next()).loadClass(ignoreExceptions);
            if (classRef != null) {
                classRefs.add(classRef);
            }
        }
        return classRefs.isEmpty() ? Collections.emptyList() : classRefs;
    }

    public List<Class<?>> loadClasses() {
        return loadClasses(false);
    }

    public ClassInfoList directOnly() {
        return new ClassInfoList(this.directlyRelatedClasses, this.directlyRelatedClasses, this.sortByName);
    }

    public ClassInfoList union(ClassInfoList... others) {
        Set<ClassInfo> reachableClassesUnion = new LinkedHashSet<>(this);
        Set<ClassInfo> directlyRelatedClassesUnion = new LinkedHashSet<>(this.directlyRelatedClasses);
        for (ClassInfoList other : others) {
            reachableClassesUnion.addAll(other);
            directlyRelatedClassesUnion.addAll(other.directlyRelatedClasses);
        }
        return new ClassInfoList(reachableClassesUnion, directlyRelatedClassesUnion, this.sortByName);
    }

    public ClassInfoList intersect(ClassInfoList... others) {
        ArrayDeque<ClassInfoList> intersectionOrder = new ArrayDeque<>();
        intersectionOrder.add(this);
        boolean foundFirst = false;
        for (ClassInfoList other : others) {
            if (other.sortByName) {
                intersectionOrder.add(other);
            } else if (!foundFirst) {
                foundFirst = true;
                intersectionOrder.push(other);
            } else {
                intersectionOrder.add(other);
            }
        }
        ClassInfoList first = intersectionOrder.remove();
        Set<ClassInfo> reachableClassesIntersection = new LinkedHashSet<>(first);
        while (!intersectionOrder.isEmpty()) {
            reachableClassesIntersection.retainAll(intersectionOrder.remove());
        }
        Set<ClassInfo> directlyRelatedClassesIntersection = new LinkedHashSet<>(this.directlyRelatedClasses);
        for (ClassInfoList other2 : others) {
            directlyRelatedClassesIntersection.retainAll(other2.directlyRelatedClasses);
        }
        return new ClassInfoList(reachableClassesIntersection, directlyRelatedClassesIntersection, first.sortByName);
    }

    public ClassInfoList exclude(ClassInfoList other) {
        Set<ClassInfo> reachableClassesDifference = new LinkedHashSet<>(this);
        Set<ClassInfo> directlyRelatedClassesDifference = new LinkedHashSet<>(this.directlyRelatedClasses);
        reachableClassesDifference.removeAll(other);
        directlyRelatedClassesDifference.removeAll(other.directlyRelatedClasses);
        return new ClassInfoList(reachableClassesDifference, directlyRelatedClassesDifference, this.sortByName);
    }

    public ClassInfoList filter(ClassInfoFilter filter) {
        Set<ClassInfo> reachableClassesFiltered = new LinkedHashSet<>(size());
        Set<ClassInfo> directlyRelatedClassesFiltered = new LinkedHashSet<>(this.directlyRelatedClasses.size());
        Iterator it = iterator();
        while (it.hasNext()) {
            ClassInfo ci = (ClassInfo) it.next();
            if (filter.accept(ci)) {
                reachableClassesFiltered.add(ci);
                if (this.directlyRelatedClasses.contains(ci)) {
                    directlyRelatedClassesFiltered.add(ci);
                }
            }
        }
        return new ClassInfoList(reachableClassesFiltered, directlyRelatedClassesFiltered, this.sortByName);
    }

    public ClassInfoList getStandardClasses() {
        return filter(new ClassInfoFilter() { // from class: io.github.classgraph.ClassInfoList.1
            @Override // p013io.github.classgraph.ClassInfoList.ClassInfoFilter
            public boolean accept(ClassInfo ci) {
                return ci.isStandardClass();
            }
        });
    }

    public ClassInfoList getInterfaces() {
        return filter(new ClassInfoFilter() { // from class: io.github.classgraph.ClassInfoList.2
            @Override // p013io.github.classgraph.ClassInfoList.ClassInfoFilter
            public boolean accept(ClassInfo ci) {
                return ci.isInterface();
            }
        });
    }

    public ClassInfoList getInterfacesAndAnnotations() {
        return filter(new ClassInfoFilter() { // from class: io.github.classgraph.ClassInfoList.3
            @Override // p013io.github.classgraph.ClassInfoList.ClassInfoFilter
            public boolean accept(ClassInfo ci) {
                return ci.isInterfaceOrAnnotation();
            }
        });
    }

    public ClassInfoList getImplementedInterfaces() {
        return filter(new ClassInfoFilter() { // from class: io.github.classgraph.ClassInfoList.4
            @Override // p013io.github.classgraph.ClassInfoList.ClassInfoFilter
            public boolean accept(ClassInfo ci) {
                return ci.isImplementedInterface();
            }
        });
    }

    public ClassInfoList getAnnotations() {
        return filter(new ClassInfoFilter() { // from class: io.github.classgraph.ClassInfoList.5
            @Override // p013io.github.classgraph.ClassInfoList.ClassInfoFilter
            public boolean accept(ClassInfo ci) {
                return ci.isAnnotation();
            }
        });
    }

    public ClassInfoList getEnums() {
        return filter(new ClassInfoFilter() { // from class: io.github.classgraph.ClassInfoList.6
            @Override // p013io.github.classgraph.ClassInfoList.ClassInfoFilter
            public boolean accept(ClassInfo ci) {
                return ci.isEnum();
            }
        });
    }

    public ClassInfoList getRecords() {
        return filter(new ClassInfoFilter() { // from class: io.github.classgraph.ClassInfoList.7
            @Override // p013io.github.classgraph.ClassInfoList.ClassInfoFilter
            public boolean accept(ClassInfo ci) {
                return ci.isRecord();
            }
        });
    }

    public ClassInfoList getAssignableTo(ClassInfo superclassOrInterface) {
        if (superclassOrInterface == null) {
            throw new IllegalArgumentException("assignableToClass parameter cannot be null");
        }
        final Set<ClassInfo> allAssignableFromClasses = new HashSet<>();
        if (superclassOrInterface.isStandardClass()) {
            allAssignableFromClasses.addAll(superclassOrInterface.getSubclasses());
        } else if (superclassOrInterface.isInterfaceOrAnnotation()) {
            allAssignableFromClasses.addAll(superclassOrInterface.getClassesImplementing());
        }
        allAssignableFromClasses.add(superclassOrInterface);
        return filter(new ClassInfoFilter() { // from class: io.github.classgraph.ClassInfoList.8
            @Override // p013io.github.classgraph.ClassInfoList.ClassInfoFilter
            public boolean accept(ClassInfo ci) {
                return allAssignableFromClasses.contains(ci);
            }
        });
    }

    public String generateGraphVizDotFileFromInterClassDependencies(float sizeX, float sizeY, boolean includeExternalClasses) {
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        } else if (((ClassInfo) get(0)).scanResult.scanSpec.enableInterClassDependencies) {
            return GraphvizDotfileGenerator.generateGraphVizDotFileFromInterClassDependencies(this, sizeX, sizeY, includeExternalClasses);
        } else {
            throw new IllegalArgumentException("Please call ClassGraph#enableInterClassDependencies() before #scan()");
        }
    }

    public String generateGraphVizDotFileFromClassDependencies() {
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        ScanSpec scanSpec = ((ClassInfo) get(0)).scanResult.scanSpec;
        if (scanSpec.enableInterClassDependencies) {
            return GraphvizDotfileGenerator.generateGraphVizDotFileFromInterClassDependencies(this, 10.5f, 8.0f, scanSpec.enableExternalClasses);
        }
        throw new IllegalArgumentException("Please call ClassGraph#enableInterClassDependencies() before #scan()");
    }

    public String generateGraphVizDotFile(float sizeX, float sizeY, boolean showFields, boolean showFieldTypeDependencyEdges, boolean showMethods, boolean showMethodTypeDependencyEdges, boolean showAnnotations, boolean useSimpleNames) {
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        ScanSpec scanSpec = ((ClassInfo) get(0)).scanResult.scanSpec;
        if (scanSpec.enableClassInfo) {
            return GraphvizDotfileGenerator.generateGraphVizDotFile(this, sizeX, sizeY, showFields, showFieldTypeDependencyEdges, showMethods, showMethodTypeDependencyEdges, showAnnotations, useSimpleNames, scanSpec);
        }
        throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
    }

    public String generateGraphVizDotFile(float sizeX, float sizeY, boolean showFields, boolean showFieldTypeDependencyEdges, boolean showMethods, boolean showMethodTypeDependencyEdges, boolean showAnnotations) {
        return generateGraphVizDotFile(sizeX, sizeY, showFields, showFieldTypeDependencyEdges, showMethods, showMethodTypeDependencyEdges, showAnnotations, true);
    }

    public String generateGraphVizDotFile(float sizeX, float sizeY) {
        return generateGraphVizDotFile(sizeX, sizeY, true, true, true, true, true);
    }

    public String generateGraphVizDotFile() {
        return generateGraphVizDotFile(10.5f, 8.0f, true, true, true, true, true);
    }

    public void generateGraphVizDotFile(File file) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        Throwable th = null;
        try {
            writer.print(generateGraphVizDotFile());
            if (writer == null) {
                return;
            }
            if (0 != 0) {
                try {
                    writer.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            } else {
                writer.close();
            }
        } catch (Throwable th3) {
            if (writer != null) {
                if (0 != 0) {
                    try {
                        writer.close();
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    }
                } else {
                    writer.close();
                }
            }
            throw th3;
        }
    }

    @Override // p013io.github.classgraph.InfoList, p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassInfoList)) {
            return false;
        }
        ClassInfoList other = (ClassInfoList) obj;
        if ((this.directlyRelatedClasses == null) != (other.directlyRelatedClasses == null)) {
            return false;
        }
        if (this.directlyRelatedClasses == null) {
            return equals(other);
        }
        return equals(other) && this.directlyRelatedClasses.equals(other.directlyRelatedClasses);
    }

    @Override // p013io.github.classgraph.InfoList, p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Object
    public int hashCode() {
        return hashCode() ^ (this.directlyRelatedClasses == null ? 0 : this.directlyRelatedClasses.hashCode());
    }
}
