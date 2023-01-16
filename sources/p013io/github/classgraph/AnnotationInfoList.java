package p013io.github.classgraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nonapi.p019io.github.classgraph.utils.CollectionUtils;
import p013io.github.classgraph.ClassInfo;

/* renamed from: io.github.classgraph.AnnotationInfoList */
/* loaded from: grasscutter.jar:io/github/classgraph/AnnotationInfoList.class */
public class AnnotationInfoList extends MappableInfoList<AnnotationInfo> {
    private AnnotationInfoList directlyRelatedAnnotations;
    private static final long serialVersionUID = 1;
    static final AnnotationInfoList EMPTY_LIST = new AnnotationInfoList();

    @FunctionalInterface
    /* renamed from: io.github.classgraph.AnnotationInfoList$AnnotationInfoFilter */
    /* loaded from: grasscutter.jar:io/github/classgraph/AnnotationInfoList$AnnotationInfoFilter.class */
    public interface AnnotationInfoFilter {
        boolean accept(AnnotationInfo annotationInfo);
    }

    static {
        EMPTY_LIST.makeUnmodifiable();
    }

    public static AnnotationInfoList emptyList() {
        return EMPTY_LIST;
    }

    public AnnotationInfoList() {
    }

    public AnnotationInfoList(int sizeHint) {
        super(sizeHint);
    }

    public AnnotationInfoList(AnnotationInfoList reachableAnnotations) {
        this(reachableAnnotations, reachableAnnotations);
    }

    AnnotationInfoList(AnnotationInfoList reachableAnnotations, AnnotationInfoList directlyRelatedAnnotations) {
        super(reachableAnnotations);
        this.directlyRelatedAnnotations = directlyRelatedAnnotations;
    }

    public AnnotationInfoList filter(AnnotationInfoFilter filter) {
        AnnotationInfoList annotationInfoFiltered = new AnnotationInfoList();
        Iterator it = iterator();
        while (it.hasNext()) {
            AnnotationInfo resource = (AnnotationInfo) it.next();
            if (filter.accept(resource)) {
                annotationInfoFiltered.add(resource);
            }
        }
        return annotationInfoFiltered;
    }

    /* access modifiers changed from: protected */
    public void findReferencedClassInfo(Map<String, ClassInfo> classNameToClassInfo, Set<ClassInfo> refdClassInfo) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((AnnotationInfo) it.next()).findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        }
    }

    /* access modifiers changed from: package-private */
    public void handleRepeatableAnnotations(Set<String> allRepeatableAnnotationNames, ClassInfo containingClassInfo, ClassInfo.RelType forwardRelType, ClassInfo.RelType reverseRelType0, ClassInfo.RelType reverseRelType1) {
        AnnotationParameterValue apv;
        ClassInfo annotationClass;
        List<AnnotationInfo> repeatableAnnotations = null;
        for (int i = size() - 1; i >= 0; i--) {
            AnnotationInfo ai = (AnnotationInfo) get(i);
            if (allRepeatableAnnotationNames.contains(ai.getName())) {
                if (repeatableAnnotations == null) {
                    repeatableAnnotations = new ArrayList<>();
                }
                repeatableAnnotations.add(ai);
                remove(i);
            }
        }
        if (repeatableAnnotations != null) {
            for (AnnotationInfo repeatableAnnotation : repeatableAnnotations) {
                AnnotationParameterValueList values = repeatableAnnotation.getParameterValues();
                if (!values.isEmpty() && (apv = values.get("value")) != null) {
                    Object arr = apv.getValue();
                    if (arr instanceof Object[]) {
                        Object[] objArr = (Object[]) arr;
                        for (Object value : objArr) {
                            if (value instanceof AnnotationInfo) {
                                AnnotationInfo ai2 = (AnnotationInfo) value;
                                add(ai2);
                                if (!(forwardRelType == null || ((reverseRelType0 == null && reverseRelType1 == null) || (annotationClass = ai2.getClassInfo()) == null))) {
                                    containingClassInfo.addRelatedClass(forwardRelType, annotationClass);
                                    if (reverseRelType0 != null) {
                                        annotationClass.addRelatedClass(reverseRelType0, containingClassInfo);
                                    }
                                    if (reverseRelType1 != null) {
                                        annotationClass.addRelatedClass(reverseRelType1, containingClassInfo);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void findMetaAnnotations(AnnotationInfo ai, AnnotationInfoList allAnnotationsOut, Set<ClassInfo> visited) {
        ClassInfo annotationClassInfo = ai.getClassInfo();
        if (annotationClassInfo != null && annotationClassInfo.annotationInfo != null && visited.add(annotationClassInfo)) {
            Iterator it = annotationClassInfo.annotationInfo.iterator();
            while (it.hasNext()) {
                AnnotationInfo metaAnnotationInfo = (AnnotationInfo) it.next();
                if (!metaAnnotationInfo.getClassInfo().getName().startsWith("java.lang.annotation.")) {
                    allAnnotationsOut.add(metaAnnotationInfo);
                    findMetaAnnotations(metaAnnotationInfo, allAnnotationsOut, visited);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static AnnotationInfoList getIndirectAnnotations(AnnotationInfoList directAnnotationInfo, ClassInfo annotatedClass) {
        Set<ClassInfo> directOrInheritedAnnotationClasses = new HashSet<>();
        Set<ClassInfo> reachedAnnotationClasses = new HashSet<>();
        AnnotationInfoList reachableAnnotationInfo = new AnnotationInfoList(directAnnotationInfo == null ? 2 : directAnnotationInfo.size());
        if (directAnnotationInfo != null) {
            Iterator it = directAnnotationInfo.iterator();
            while (it.hasNext()) {
                AnnotationInfo dai = (AnnotationInfo) it.next();
                directOrInheritedAnnotationClasses.add(dai.getClassInfo());
                reachableAnnotationInfo.add(dai);
                findMetaAnnotations(dai, reachableAnnotationInfo, reachedAnnotationClasses);
            }
        }
        if (annotatedClass != null) {
            Iterator it2 = annotatedClass.getSuperclasses().iterator();
            while (it2.hasNext()) {
                ClassInfo superclass = (ClassInfo) it2.next();
                if (superclass.annotationInfo != null) {
                    Iterator it3 = superclass.annotationInfo.iterator();
                    while (it3.hasNext()) {
                        AnnotationInfo sai = (AnnotationInfo) it3.next();
                        if (sai.isInherited() && directOrInheritedAnnotationClasses.add(sai.getClassInfo())) {
                            reachableAnnotationInfo.add(sai);
                            AnnotationInfoList reachableMetaAnnotationInfo = new AnnotationInfoList(2);
                            findMetaAnnotations(sai, reachableMetaAnnotationInfo, reachedAnnotationClasses);
                            Iterator it4 = reachableMetaAnnotationInfo.iterator();
                            while (it4.hasNext()) {
                                AnnotationInfo rmai = (AnnotationInfo) it4.next();
                                if (rmai.isInherited()) {
                                    reachableAnnotationInfo.add(rmai);
                                }
                            }
                        }
                    }
                }
            }
        }
        AnnotationInfoList directAnnotationInfoSorted = directAnnotationInfo == null ? EMPTY_LIST : new AnnotationInfoList(directAnnotationInfo);
        CollectionUtils.sortIfNotEmpty(directAnnotationInfoSorted);
        AnnotationInfoList annotationInfoList = new AnnotationInfoList(reachableAnnotationInfo, directAnnotationInfoSorted);
        CollectionUtils.sortIfNotEmpty(annotationInfoList);
        return annotationInfoList;
    }

    public AnnotationInfoList directOnly() {
        return this.directlyRelatedAnnotations == null ? this : new AnnotationInfoList(this.directlyRelatedAnnotations, null);
    }

    public AnnotationInfoList getRepeatable(String name) {
        boolean hasNamedAnnotation = false;
        Iterator it = iterator();
        while (true) {
            if (it.hasNext()) {
                if (((AnnotationInfo) it.next()).getName().equals(name)) {
                    hasNamedAnnotation = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!hasNamedAnnotation) {
            return EMPTY_LIST;
        }
        AnnotationInfoList matchingAnnotations = new AnnotationInfoList(size());
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            AnnotationInfo ai = (AnnotationInfo) it2.next();
            if (ai.getName().equals(name)) {
                matchingAnnotations.add(ai);
            }
        }
        return matchingAnnotations;
    }

    @Override // p013io.github.classgraph.InfoList, p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnnotationInfoList)) {
            return false;
        }
        AnnotationInfoList other = (AnnotationInfoList) obj;
        if ((this.directlyRelatedAnnotations == null) != (other.directlyRelatedAnnotations == null)) {
            return false;
        }
        if (this.directlyRelatedAnnotations == null) {
            return equals(other);
        }
        return equals(other) && this.directlyRelatedAnnotations.equals(other.directlyRelatedAnnotations);
    }

    @Override // p013io.github.classgraph.InfoList, p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Object
    public int hashCode() {
        return hashCode() ^ (this.directlyRelatedAnnotations == null ? 0 : this.directlyRelatedAnnotations.hashCode());
    }
}
