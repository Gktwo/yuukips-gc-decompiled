package p013io.github.classgraph;

import java.io.File;
import java.lang.annotation.Inherited;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nonapi.p019io.github.classgraph.json.AbstractC5513Id;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.types.ParseException;
import nonapi.p019io.github.classgraph.types.TypeUtils;
import okhttp3.HttpUrl;
import p013io.github.classgraph.Classfile;

/* renamed from: io.github.classgraph.ClassInfo */
/* loaded from: grasscutter.jar:io/github/classgraph/ClassInfo.class */
public class ClassInfo extends ScanResultObject implements Comparable<ClassInfo>, HasName {
    @AbstractC5513Id
    protected String name;
    private int modifiers;
    private boolean isRecord;
    boolean isInherited;
    private int classfileMinorVersion;
    private int classfileMajorVersion;
    protected String typeSignatureStr;
    private transient ClassTypeSignature typeSignature;
    private String fullyQualifiedDefiningMethodName;
    protected boolean isExternalClass = true;
    protected boolean isScannedClass;
    transient ClasspathElement classpathElement;
    protected transient Resource classfileResource;
    transient ClassLoader classLoader;
    ModuleInfo moduleInfo;
    PackageInfo packageInfo;
    AnnotationInfoList annotationInfo;
    FieldInfoList fieldInfo;
    MethodInfoList methodInfo;
    AnnotationParameterValueList annotationDefaultParamValues;
    private Set<String> referencedClassNames;
    private ClassInfoList referencedClasses;
    transient boolean annotationDefaultParamValuesHasBeenConvertedToPrimitive;
    private Map<RelType, Set<ClassInfo>> relatedClasses;
    private transient List<ClassInfo> overrideOrder;
    private static final int ANNOTATION_CLASS_MODIFIER = 8192;
    private static final ReachableAndDirectlyRelatedClasses NO_REACHABLE_CLASSES = new ReachableAndDirectlyRelatedClasses(Collections.emptySet(), Collections.emptySet());

    /* access modifiers changed from: private */
    /* renamed from: io.github.classgraph.ClassInfo$ClassType */
    /* loaded from: grasscutter.jar:io/github/classgraph/ClassInfo$ClassType.class */
    public enum ClassType {
        ALL,
        STANDARD_CLASS,
        IMPLEMENTED_INTERFACE,
        ANNOTATION,
        INTERFACE_OR_ANNOTATION,
        ENUM,
        RECORD
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.github.classgraph.ClassInfo$RelType */
    /* loaded from: grasscutter.jar:io/github/classgraph/ClassInfo$RelType.class */
    public enum RelType {
        SUPERCLASSES,
        SUBCLASSES,
        CONTAINS_INNER_CLASS,
        CONTAINED_WITHIN_OUTER_CLASS,
        IMPLEMENTED_INTERFACES,
        CLASSES_IMPLEMENTING,
        CLASS_ANNOTATIONS,
        CLASSES_WITH_ANNOTATION,
        METHOD_ANNOTATIONS,
        CLASSES_WITH_METHOD_ANNOTATION,
        CLASSES_WITH_NONPRIVATE_METHOD_ANNOTATION,
        METHOD_PARAMETER_ANNOTATIONS,
        CLASSES_WITH_METHOD_PARAMETER_ANNOTATION,
        CLASSES_WITH_NONPRIVATE_METHOD_PARAMETER_ANNOTATION,
        FIELD_ANNOTATIONS,
        CLASSES_WITH_FIELD_ANNOTATION,
        CLASSES_WITH_NONPRIVATE_FIELD_ANNOTATION
    }

    /* access modifiers changed from: package-private */
    public ClassInfo() {
    }

    /* access modifiers changed from: protected */
    public ClassInfo(String name, int classModifiers, Resource classfileResource) {
        this.name = name;
        if (name.endsWith(";")) {
            throw new IllegalArgumentException("Bad class name");
        }
        setModifiers(classModifiers);
        this.classfileResource = classfileResource;
        this.relatedClasses = new EnumMap(RelType.class);
    }

    /* access modifiers changed from: package-private */
    public boolean addRelatedClass(RelType relType, ClassInfo classInfo) {
        Set<ClassInfo> classInfoSet = this.relatedClasses.get(relType);
        if (classInfoSet == null) {
            Map<RelType, Set<ClassInfo>> map = this.relatedClasses;
            LinkedHashSet linkedHashSet = new LinkedHashSet(4);
            classInfoSet = linkedHashSet;
            map.put(relType, linkedHashSet);
        }
        return classInfoSet.add(classInfo);
    }

    /* access modifiers changed from: package-private */
    public static ClassInfo getOrCreateClassInfo(String className, Map<String, ClassInfo> classNameToClassInfo) {
        int numArrayDims = 0;
        String baseClassName = className;
        while (baseClassName.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            numArrayDims++;
            baseClassName = baseClassName.substring(0, baseClassName.length() - 2);
        }
        while (baseClassName.startsWith("[")) {
            numArrayDims++;
            baseClassName = baseClassName.substring(1);
        }
        if (baseClassName.endsWith(";")) {
            baseClassName = baseClassName.substring(baseClassName.length() - 1);
        }
        String baseClassName2 = baseClassName.replace('/', '.');
        ClassInfo classInfo = classNameToClassInfo.get(className);
        if (classInfo == null) {
            ClassInfo classInfo2 = numArrayDims == 0 ? new ClassInfo(baseClassName2, 0, null) : new ArrayClassInfo(new ArrayTypeSignature(baseClassName2, numArrayDims));
            classInfo = classInfo2;
            classNameToClassInfo.put(className, classInfo2);
        }
        return classInfo;
    }

    /* access modifiers changed from: package-private */
    public void setClassfileVersion(int minorVersion, int majorVersion) {
        this.classfileMinorVersion = minorVersion;
        this.classfileMajorVersion = majorVersion;
    }

    /* access modifiers changed from: package-private */
    public void setModifiers(int modifiers) {
        this.modifiers |= modifiers;
    }

    /* access modifiers changed from: package-private */
    public void setIsInterface(boolean isInterface) {
        if (isInterface) {
            this.modifiers |= 512;
        }
    }

    /* access modifiers changed from: package-private */
    public void setIsAnnotation(boolean isAnnotation) {
        if (isAnnotation) {
            this.modifiers |= 8192;
        }
    }

    /* access modifiers changed from: package-private */
    public void setIsRecord(boolean isRecord) {
        if (isRecord) {
            this.isRecord = isRecord;
        }
    }

    /* access modifiers changed from: package-private */
    public void addSuperclass(String superclassName, Map<String, ClassInfo> classNameToClassInfo) {
        if (superclassName != null && !superclassName.equals("java.lang.Object")) {
            ClassInfo superclassClassInfo = getOrCreateClassInfo(superclassName, classNameToClassInfo);
            addRelatedClass(RelType.SUPERCLASSES, superclassClassInfo);
            superclassClassInfo.addRelatedClass(RelType.SUBCLASSES, this);
        }
    }

    /* access modifiers changed from: package-private */
    public void addImplementedInterface(String interfaceName, Map<String, ClassInfo> classNameToClassInfo) {
        ClassInfo interfaceClassInfo = getOrCreateClassInfo(interfaceName, classNameToClassInfo);
        interfaceClassInfo.setIsInterface(true);
        addRelatedClass(RelType.IMPLEMENTED_INTERFACES, interfaceClassInfo);
        interfaceClassInfo.addRelatedClass(RelType.CLASSES_IMPLEMENTING, this);
    }

    /* access modifiers changed from: package-private */
    public static void addClassContainment(List<Classfile.ClassContainment> classContainmentEntries, Map<String, ClassInfo> classNameToClassInfo) {
        for (Classfile.ClassContainment classContainment : classContainmentEntries) {
            ClassInfo innerClassInfo = getOrCreateClassInfo(classContainment.innerClassName, classNameToClassInfo);
            innerClassInfo.setModifiers(classContainment.innerClassModifierBits);
            ClassInfo outerClassInfo = getOrCreateClassInfo(classContainment.outerClassName, classNameToClassInfo);
            innerClassInfo.addRelatedClass(RelType.CONTAINED_WITHIN_OUTER_CLASS, outerClassInfo);
            outerClassInfo.addRelatedClass(RelType.CONTAINS_INNER_CLASS, innerClassInfo);
        }
    }

    /* access modifiers changed from: package-private */
    public void addFullyQualifiedDefiningMethodName(String fullyQualifiedDefiningMethodName) {
        this.fullyQualifiedDefiningMethodName = fullyQualifiedDefiningMethodName;
    }

    /* access modifiers changed from: package-private */
    public void addClassAnnotation(AnnotationInfo classAnnotationInfo, Map<String, ClassInfo> classNameToClassInfo) {
        ClassInfo annotationClassInfo = getOrCreateClassInfo(classAnnotationInfo.getName(), classNameToClassInfo);
        annotationClassInfo.setModifiers(8192);
        if (this.annotationInfo == null) {
            this.annotationInfo = new AnnotationInfoList(2);
        }
        this.annotationInfo.add(classAnnotationInfo);
        addRelatedClass(RelType.CLASS_ANNOTATIONS, annotationClassInfo);
        annotationClassInfo.addRelatedClass(RelType.CLASSES_WITH_ANNOTATION, this);
        if (classAnnotationInfo.getName().equals(Inherited.class.getName())) {
            this.isInherited = true;
        }
    }

    private void addFieldOrMethodAnnotationInfo(AnnotationInfoList annotationInfoList, boolean isField, int modifiers, Map<String, ClassInfo> classNameToClassInfo) {
        if (annotationInfoList != null) {
            Iterator it = annotationInfoList.iterator();
            while (it.hasNext()) {
                ClassInfo annotationClassInfo = getOrCreateClassInfo(((AnnotationInfo) it.next()).getName(), classNameToClassInfo);
                annotationClassInfo.setModifiers(8192);
                addRelatedClass(isField ? RelType.FIELD_ANNOTATIONS : RelType.METHOD_ANNOTATIONS, annotationClassInfo);
                annotationClassInfo.addRelatedClass(isField ? RelType.CLASSES_WITH_FIELD_ANNOTATION : RelType.CLASSES_WITH_METHOD_ANNOTATION, this);
                if (!Modifier.isPrivate(modifiers)) {
                    annotationClassInfo.addRelatedClass(isField ? RelType.CLASSES_WITH_NONPRIVATE_FIELD_ANNOTATION : RelType.CLASSES_WITH_NONPRIVATE_METHOD_ANNOTATION, this);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void addFieldInfo(FieldInfoList fieldInfoList, Map<String, ClassInfo> classNameToClassInfo) {
        Iterator it = fieldInfoList.iterator();
        while (it.hasNext()) {
            FieldInfo fi = (FieldInfo) it.next();
            addFieldOrMethodAnnotationInfo(fi.annotationInfo, true, fi.getModifiers(), classNameToClassInfo);
        }
        if (this.fieldInfo == null) {
            this.fieldInfo = fieldInfoList;
        } else {
            this.fieldInfo.addAll(fieldInfoList);
        }
    }

    /* access modifiers changed from: package-private */
    public void addMethodInfo(MethodInfoList methodInfoList, Map<String, ClassInfo> classNameToClassInfo) {
        Iterator it = methodInfoList.iterator();
        while (it.hasNext()) {
            MethodInfo mi = (MethodInfo) it.next();
            addFieldOrMethodAnnotationInfo(mi.annotationInfo, false, mi.getModifiers(), classNameToClassInfo);
            if (mi.parameterAnnotationInfo != null) {
                for (int i = 0; i < mi.parameterAnnotationInfo.length; i++) {
                    AnnotationInfo[] paramAnnotationInfoArr = mi.parameterAnnotationInfo[i];
                    if (paramAnnotationInfoArr != null) {
                        for (AnnotationInfo methodParamAnnotationInfo : paramAnnotationInfoArr) {
                            ClassInfo annotationClassInfo = getOrCreateClassInfo(methodParamAnnotationInfo.getName(), classNameToClassInfo);
                            annotationClassInfo.setModifiers(8192);
                            addRelatedClass(RelType.METHOD_PARAMETER_ANNOTATIONS, annotationClassInfo);
                            annotationClassInfo.addRelatedClass(RelType.CLASSES_WITH_METHOD_PARAMETER_ANNOTATION, this);
                            if (!Modifier.isPrivate(mi.getModifiers())) {
                                annotationClassInfo.addRelatedClass(RelType.CLASSES_WITH_NONPRIVATE_METHOD_PARAMETER_ANNOTATION, this);
                            }
                        }
                    }
                }
            }
        }
        if (this.methodInfo == null) {
            this.methodInfo = methodInfoList;
        } else {
            this.methodInfo.addAll(methodInfoList);
        }
    }

    /* access modifiers changed from: package-private */
    public void setTypeSignature(String typeSignatureStr) {
        this.typeSignatureStr = typeSignatureStr;
    }

    /* access modifiers changed from: package-private */
    public void addAnnotationParamDefaultValues(AnnotationParameterValueList paramNamesAndValues) {
        setIsAnnotation(true);
        if (this.annotationDefaultParamValues == null) {
            this.annotationDefaultParamValues = paramNamesAndValues;
        } else {
            this.annotationDefaultParamValues.addAll(paramNamesAndValues);
        }
    }

    /* access modifiers changed from: package-private */
    public static ClassInfo addScannedClass(String className, int classModifiers, boolean isExternalClass, Map<String, ClassInfo> classNameToClassInfo, ClasspathElement classpathElement, Resource classfileResource) {
        ClassInfo classInfo = classNameToClassInfo.get(className);
        if (classInfo == null) {
            ClassInfo classInfo2 = new ClassInfo(className, classModifiers, classfileResource);
            classInfo = classInfo2;
            classNameToClassInfo.put(className, classInfo2);
        } else if (classInfo.isScannedClass) {
            throw new IllegalArgumentException("Class " + className + " should not have been encountered more than once due to classpath masking -- please report this bug at: https://github.com/classgraph/classgraph/issues");
        } else {
            classInfo.classfileResource = classfileResource;
            classInfo.modifiers |= classModifiers;
        }
        classInfo.isScannedClass = true;
        classInfo.isExternalClass = isExternalClass;
        classInfo.classpathElement = classpathElement;
        classInfo.classLoader = classpathElement.getClassLoader();
        return classInfo;
    }

    private static Set<ClassInfo> filterClassInfo(Collection<ClassInfo> classes, ScanSpec scanSpec, boolean strictWhitelist, ClassType... classTypes) {
        if (classes == null) {
            return Collections.emptySet();
        }
        boolean includeAllTypes = classTypes.length == 0;
        boolean includeStandardClasses = false;
        boolean includeImplementedInterfaces = false;
        boolean includeAnnotations = false;
        boolean includeEnums = false;
        boolean includeRecords = false;
        for (ClassType classType : classTypes) {
            switch (classType) {
                case ALL:
                    includeAllTypes = true;
                    break;
                case STANDARD_CLASS:
                    includeStandardClasses = true;
                    break;
                case IMPLEMENTED_INTERFACE:
                    includeImplementedInterfaces = true;
                    break;
                case ANNOTATION:
                    includeAnnotations = true;
                    break;
                case INTERFACE_OR_ANNOTATION:
                    includeAnnotations = true;
                    includeImplementedInterfaces = true;
                    break;
                case ENUM:
                    includeEnums = true;
                    break;
                case RECORD:
                    includeRecords = true;
                    break;
                default:
                    throw new IllegalArgumentException("Unknown ClassType: " + classType);
            }
        }
        if (includeStandardClasses && includeImplementedInterfaces && includeAnnotations) {
            includeAllTypes = true;
        }
        Set<ClassInfo> classInfoSetFiltered = new LinkedHashSet<>(classes.size());
        for (ClassInfo classInfo : classes) {
            if (includeAllTypes || ((includeStandardClasses && classInfo.isStandardClass()) || ((includeImplementedInterfaces && classInfo.isImplementedInterface()) || ((includeAnnotations && classInfo.isAnnotation()) || ((includeEnums && classInfo.isEnum()) || (includeRecords && classInfo.isRecord())))))) {
                if (!scanSpec.classOrPackageIsBlacklisted(classInfo.name) && (!classInfo.isExternalClass || scanSpec.enableExternalClasses || !strictWhitelist)) {
                    classInfoSetFiltered.add(classInfo);
                }
            }
        }
        return classInfoSetFiltered;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.github.classgraph.ClassInfo$ReachableAndDirectlyRelatedClasses */
    /* loaded from: grasscutter.jar:io/github/classgraph/ClassInfo$ReachableAndDirectlyRelatedClasses.class */
    public static class ReachableAndDirectlyRelatedClasses {
        final Set<ClassInfo> reachableClasses;
        final Set<ClassInfo> directlyRelatedClasses;

        private ReachableAndDirectlyRelatedClasses(Set<ClassInfo> reachableClasses, Set<ClassInfo> directlyRelatedClasses) {
            this.reachableClasses = reachableClasses;
            this.directlyRelatedClasses = directlyRelatedClasses;
        }
    }

    private ReachableAndDirectlyRelatedClasses filterClassInfo(RelType relType, boolean strictWhitelist, ClassType... classTypes) {
        Set<ClassInfo> directlyRelatedClasses = this.relatedClasses.get(relType);
        if (directlyRelatedClasses == null) {
            return NO_REACHABLE_CLASSES;
        }
        Set<ClassInfo> directlyRelatedClasses2 = new LinkedHashSet<>(directlyRelatedClasses);
        Set<ClassInfo> reachableClasses = new LinkedHashSet<>(directlyRelatedClasses2);
        if (relType == RelType.METHOD_ANNOTATIONS || relType == RelType.METHOD_PARAMETER_ANNOTATIONS || relType == RelType.FIELD_ANNOTATIONS) {
            for (ClassInfo annotation : directlyRelatedClasses2) {
                reachableClasses.addAll(annotation.filterClassInfo(RelType.CLASS_ANNOTATIONS, strictWhitelist, new ClassType[0]).reachableClasses);
            }
        } else if (relType == RelType.CLASSES_WITH_METHOD_ANNOTATION || relType == RelType.CLASSES_WITH_NONPRIVATE_METHOD_ANNOTATION || relType == RelType.CLASSES_WITH_METHOD_PARAMETER_ANNOTATION || relType == RelType.CLASSES_WITH_NONPRIVATE_METHOD_PARAMETER_ANNOTATION || relType == RelType.CLASSES_WITH_FIELD_ANNOTATION || relType == RelType.CLASSES_WITH_NONPRIVATE_FIELD_ANNOTATION) {
            for (ClassInfo subAnnotation : filterClassInfo(RelType.CLASSES_WITH_ANNOTATION, strictWhitelist, ClassType.ANNOTATION).reachableClasses) {
                Set<ClassInfo> annotatedClasses = subAnnotation.relatedClasses.get(relType);
                if (annotatedClasses != null) {
                    reachableClasses.addAll(annotatedClasses);
                }
            }
        } else {
            LinkedList<ClassInfo> queue = new LinkedList<>(directlyRelatedClasses2);
            while (!queue.isEmpty()) {
                Set<ClassInfo> headRelatedClasses = queue.removeFirst().relatedClasses.get(relType);
                if (headRelatedClasses != null) {
                    for (ClassInfo directlyReachableFromHead : headRelatedClasses) {
                        if (reachableClasses.add(directlyReachableFromHead)) {
                            queue.add(directlyReachableFromHead);
                        }
                    }
                }
            }
        }
        if (reachableClasses.isEmpty()) {
            return NO_REACHABLE_CLASSES;
        }
        if (relType == RelType.CLASS_ANNOTATIONS || relType == RelType.METHOD_ANNOTATIONS || relType == RelType.METHOD_PARAMETER_ANNOTATIONS || relType == RelType.FIELD_ANNOTATIONS) {
            Set<ClassInfo> reachableClassesToRemove = null;
            for (ClassInfo reachableClassInfo : reachableClasses) {
                if (reachableClassInfo.getName().startsWith("java.lang.annotation.") && !directlyRelatedClasses2.contains(reachableClassInfo)) {
                    if (reachableClassesToRemove == null) {
                        reachableClassesToRemove = new LinkedHashSet<>();
                    }
                    reachableClassesToRemove.add(reachableClassInfo);
                }
            }
            if (reachableClassesToRemove != null) {
                reachableClasses.removeAll(reachableClassesToRemove);
            }
        }
        return new ReachableAndDirectlyRelatedClasses(filterClassInfo(reachableClasses, this.scanResult.scanSpec, strictWhitelist, classTypes), filterClassInfo(directlyRelatedClasses2, this.scanResult.scanSpec, strictWhitelist, classTypes));
    }

    /* access modifiers changed from: package-private */
    public static ClassInfoList getAllClasses(Collection<ClassInfo> classes, ScanSpec scanSpec) {
        return new ClassInfoList(filterClassInfo(classes, scanSpec, true, ClassType.ALL), true);
    }

    /* access modifiers changed from: package-private */
    public static ClassInfoList getAllEnums(Collection<ClassInfo> classes, ScanSpec scanSpec) {
        return new ClassInfoList(filterClassInfo(classes, scanSpec, true, ClassType.ENUM), true);
    }

    /* access modifiers changed from: package-private */
    public static ClassInfoList getAllRecords(Collection<ClassInfo> classes, ScanSpec scanSpec) {
        return new ClassInfoList(filterClassInfo(classes, scanSpec, true, ClassType.RECORD), true);
    }

    /* access modifiers changed from: package-private */
    public static ClassInfoList getAllStandardClasses(Collection<ClassInfo> classes, ScanSpec scanSpec) {
        return new ClassInfoList(filterClassInfo(classes, scanSpec, true, ClassType.STANDARD_CLASS), true);
    }

    /* access modifiers changed from: package-private */
    public static ClassInfoList getAllImplementedInterfaceClasses(Collection<ClassInfo> classes, ScanSpec scanSpec) {
        return new ClassInfoList(filterClassInfo(classes, scanSpec, true, ClassType.IMPLEMENTED_INTERFACE), true);
    }

    /* access modifiers changed from: package-private */
    public static ClassInfoList getAllAnnotationClasses(Collection<ClassInfo> classes, ScanSpec scanSpec) {
        return new ClassInfoList(filterClassInfo(classes, scanSpec, true, ClassType.ANNOTATION), true);
    }

    /* access modifiers changed from: package-private */
    public static ClassInfoList getAllInterfacesOrAnnotationClasses(Collection<ClassInfo> classes, ScanSpec scanSpec) {
        return new ClassInfoList(filterClassInfo(classes, scanSpec, true, ClassType.INTERFACE_OR_ANNOTATION), true);
    }

    @Override // p013io.github.classgraph.HasName
    public String getName() {
        return this.name;
    }

    /* access modifiers changed from: package-private */
    public static String getSimpleName(String className) {
        return className.substring(className.lastIndexOf(46) + 1);
    }

    public String getSimpleName() {
        return getSimpleName(this.name);
    }

    public ModuleInfo getModuleInfo() {
        return this.moduleInfo;
    }

    public PackageInfo getPackageInfo() {
        return this.packageInfo;
    }

    public String getPackageName() {
        return PackageInfo.getParentPackageName(this.name);
    }

    public boolean isExternalClass() {
        return this.isExternalClass;
    }

    public int getClassfileMinorVersion() {
        return this.classfileMinorVersion;
    }

    public int getClassfileMajorVersion() {
        return this.classfileMajorVersion;
    }

    public int getModifiers() {
        return this.modifiers;
    }

    public String getModifiersStr() {
        StringBuilder buf = new StringBuilder();
        TypeUtils.modifiersToString(this.modifiers, TypeUtils.ModifierType.CLASS, false, buf);
        return buf.toString();
    }

    public boolean isPublic() {
        return (this.modifiers & 1) != 0;
    }

    public boolean isAbstract() {
        return (this.modifiers & 1024) != 0;
    }

    public boolean isSynthetic() {
        return (this.modifiers & 4096) != 0;
    }

    public boolean isFinal() {
        return (this.modifiers & 16) != 0;
    }

    public boolean isStatic() {
        return Modifier.isStatic(this.modifiers);
    }

    public boolean isAnnotation() {
        return (this.modifiers & 8192) != 0;
    }

    public boolean isInterface() {
        return isInterfaceOrAnnotation() && !isAnnotation();
    }

    public boolean isInterfaceOrAnnotation() {
        return (this.modifiers & 512) != 0;
    }

    public boolean isEnum() {
        return (this.modifiers & 16384) != 0;
    }

    public boolean isRecord() {
        return this.isRecord;
    }

    public boolean isStandardClass() {
        return !isAnnotation() && !isInterface();
    }

    public boolean isArrayClass() {
        return this instanceof ArrayClassInfo;
    }

    public boolean extendsSuperclass(String superclassName) {
        return getSuperclasses().containsName(superclassName);
    }

    public boolean isInnerClass() {
        return !getOuterClasses().isEmpty();
    }

    public boolean isOuterClass() {
        return !getInnerClasses().isEmpty();
    }

    public boolean isAnonymousInnerClass() {
        return this.fullyQualifiedDefiningMethodName != null;
    }

    public boolean isImplementedInterface() {
        return this.relatedClasses.get(RelType.CLASSES_IMPLEMENTING) != null || isInterface();
    }

    public boolean implementsInterface(String interfaceName) {
        return getInterfaces().containsName(interfaceName);
    }

    public boolean hasAnnotation(String annotationName) {
        return getAnnotations().containsName(annotationName);
    }

    public boolean hasDeclaredField(String fieldName) {
        return getDeclaredFieldInfo().containsName(fieldName);
    }

    public boolean hasField(String fieldName) {
        for (ClassInfo ci : getOverrideOrder()) {
            if (ci.hasDeclaredField(fieldName)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDeclaredFieldAnnotation(String fieldAnnotationName) {
        Iterator it = getDeclaredFieldInfo().iterator();
        while (it.hasNext()) {
            if (((FieldInfo) it.next()).hasAnnotation(fieldAnnotationName)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasFieldAnnotation(String fieldAnnotationName) {
        for (ClassInfo ci : getOverrideOrder()) {
            if (ci.hasDeclaredFieldAnnotation(fieldAnnotationName)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDeclaredMethod(String methodName) {
        return getDeclaredMethodInfo().containsName(methodName);
    }

    public boolean hasMethod(String methodName) {
        for (ClassInfo ci : getOverrideOrder()) {
            if (ci.hasDeclaredMethod(methodName)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDeclaredMethodAnnotation(String methodAnnotationName) {
        Iterator it = getDeclaredMethodInfo().iterator();
        while (it.hasNext()) {
            if (((MethodInfo) it.next()).hasAnnotation(methodAnnotationName)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasMethodAnnotation(String methodAnnotationName) {
        for (ClassInfo ci : getOverrideOrder()) {
            if (ci.hasDeclaredMethodAnnotation(methodAnnotationName)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDeclaredMethodParameterAnnotation(String methodParameterAnnotationName) {
        Iterator it = getDeclaredMethodInfo().iterator();
        while (it.hasNext()) {
            if (((MethodInfo) it.next()).hasParameterAnnotation(methodParameterAnnotationName)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasMethodParameterAnnotation(String methodParameterAnnotationName) {
        for (ClassInfo ci : getOverrideOrder()) {
            if (ci.hasDeclaredMethodParameterAnnotation(methodParameterAnnotationName)) {
                return true;
            }
        }
        return false;
    }

    private List<ClassInfo> getOverrideOrder(Set<ClassInfo> visited, List<ClassInfo> overrideOrderOut) {
        if (visited.add(this)) {
            overrideOrderOut.add(this);
            Iterator it = getInterfaces().iterator();
            while (it.hasNext()) {
                ((ClassInfo) it.next()).getOverrideOrder(visited, overrideOrderOut);
            }
            ClassInfo superclass = getSuperclass();
            if (superclass != null) {
                superclass.getOverrideOrder(visited, overrideOrderOut);
            }
        }
        return overrideOrderOut;
    }

    private List<ClassInfo> getOverrideOrder() {
        if (this.overrideOrder == null) {
            this.overrideOrder = getOverrideOrder(new HashSet(), new ArrayList());
        }
        return this.overrideOrder;
    }

    public ClassInfoList getSubclasses() {
        if (getName().equals("java.lang.Object")) {
            return this.scanResult.getAllClasses();
        }
        return new ClassInfoList(filterClassInfo(RelType.SUBCLASSES, !this.isExternalClass, new ClassType[0]), true);
    }

    public ClassInfoList getSuperclasses() {
        return new ClassInfoList(filterClassInfo(RelType.SUPERCLASSES, false, new ClassType[0]), false);
    }

    public ClassInfo getSuperclass() {
        Set<ClassInfo> superClasses = this.relatedClasses.get(RelType.SUPERCLASSES);
        if (superClasses == null || superClasses.isEmpty()) {
            return null;
        }
        if (superClasses.size() > 2) {
            throw new IllegalArgumentException("More than one superclass: " + superClasses);
        }
        ClassInfo superclass = superClasses.iterator().next();
        if (superclass.getName().equals("java.lang.Object")) {
            return null;
        }
        return superclass;
    }

    public ClassInfoList getOuterClasses() {
        return new ClassInfoList(filterClassInfo(RelType.CONTAINED_WITHIN_OUTER_CLASS, false, new ClassType[0]), false);
    }

    public ClassInfoList getInnerClasses() {
        return new ClassInfoList(filterClassInfo(RelType.CONTAINS_INNER_CLASS, false, new ClassType[0]), true);
    }

    public String getFullyQualifiedDefiningMethodName() {
        return this.fullyQualifiedDefiningMethodName;
    }

    public ClassInfoList getInterfaces() {
        ReachableAndDirectlyRelatedClasses implementedInterfaces = filterClassInfo(RelType.IMPLEMENTED_INTERFACES, false, new ClassType[0]);
        Set<ClassInfo> allInterfaces = new LinkedHashSet<>(implementedInterfaces.reachableClasses);
        for (ClassInfo superclass : filterClassInfo(RelType.SUPERCLASSES, false, new ClassType[0]).reachableClasses) {
            allInterfaces.addAll(superclass.filterClassInfo(RelType.IMPLEMENTED_INTERFACES, false, new ClassType[0]).reachableClasses);
        }
        return new ClassInfoList(allInterfaces, implementedInterfaces.directlyRelatedClasses, true);
    }

    public ClassInfoList getClassesImplementing() {
        if (!isInterface()) {
            throw new IllegalArgumentException("Class is not an interface: " + getName());
        }
        ReachableAndDirectlyRelatedClasses implementingClasses = filterClassInfo(RelType.CLASSES_IMPLEMENTING, !this.isExternalClass, new ClassType[0]);
        Set<ClassInfo> allImplementingClasses = new LinkedHashSet<>(implementingClasses.reachableClasses);
        for (ClassInfo implementingClass : implementingClasses.reachableClasses) {
            allImplementingClasses.addAll(implementingClass.filterClassInfo(RelType.SUBCLASSES, !implementingClass.isExternalClass, new ClassType[0]).reachableClasses);
        }
        return new ClassInfoList(allImplementingClasses, implementingClasses.directlyRelatedClasses, true);
    }

    public ClassInfoList getAnnotations() {
        if (!this.scanResult.scanSpec.enableAnnotationInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableAnnotationInfo() before #scan()");
        }
        ReachableAndDirectlyRelatedClasses annotationClasses = filterClassInfo(RelType.CLASS_ANNOTATIONS, false, new ClassType[0]);
        Set<ClassInfo> inheritedSuperclassAnnotations = null;
        Iterator it = getSuperclasses().iterator();
        while (it.hasNext()) {
            for (ClassInfo superclassAnnotation : ((ClassInfo) it.next()).filterClassInfo(RelType.CLASS_ANNOTATIONS, false, new ClassType[0]).reachableClasses) {
                if (superclassAnnotation != null && superclassAnnotation.isInherited) {
                    if (inheritedSuperclassAnnotations == null) {
                        inheritedSuperclassAnnotations = new LinkedHashSet<>();
                    }
                    inheritedSuperclassAnnotations.add(superclassAnnotation);
                }
            }
        }
        if (inheritedSuperclassAnnotations == null) {
            return new ClassInfoList(annotationClasses, true);
        }
        inheritedSuperclassAnnotations.addAll(annotationClasses.reachableClasses);
        return new ClassInfoList(inheritedSuperclassAnnotations, annotationClasses.directlyRelatedClasses, true);
    }

    private ClassInfoList getFieldOrMethodAnnotations(RelType relType) {
        boolean isField = relType == RelType.FIELD_ANNOTATIONS;
        if (!isField ? this.scanResult.scanSpec.enableMethodInfo : this.scanResult.scanSpec.enableFieldInfo) {
            if (this.scanResult.scanSpec.enableAnnotationInfo) {
                ReachableAndDirectlyRelatedClasses fieldOrMethodAnnotations = filterClassInfo(relType, false, ClassType.ANNOTATION);
                return new ClassInfoList(new LinkedHashSet<>(fieldOrMethodAnnotations.reachableClasses), fieldOrMethodAnnotations.directlyRelatedClasses, true);
            }
        }
        throw new IllegalArgumentException("Please call ClassGraph#enable" + (isField ? "Field" : "Method") + "Info() and #enableAnnotationInfo() before #scan()");
    }

    private ClassInfoList getClassesWithFieldOrMethodAnnotation(RelType relType) {
        boolean isField = relType == RelType.CLASSES_WITH_FIELD_ANNOTATION || relType == RelType.CLASSES_WITH_NONPRIVATE_FIELD_ANNOTATION;
        if (!isField ? this.scanResult.scanSpec.enableMethodInfo : this.scanResult.scanSpec.enableFieldInfo) {
            if (this.scanResult.scanSpec.enableAnnotationInfo) {
                ReachableAndDirectlyRelatedClasses classesWithDirectlyAnnotatedFieldsOrMethods = filterClassInfo(relType, !this.isExternalClass, new ClassType[0]);
                ReachableAndDirectlyRelatedClasses annotationsWithThisMetaAnnotation = filterClassInfo(RelType.CLASSES_WITH_ANNOTATION, !this.isExternalClass, ClassType.ANNOTATION);
                if (annotationsWithThisMetaAnnotation.reachableClasses.isEmpty()) {
                    return new ClassInfoList(classesWithDirectlyAnnotatedFieldsOrMethods, true);
                }
                Set<ClassInfo> allClassesWithAnnotatedOrMetaAnnotatedFieldsOrMethods = new LinkedHashSet<>(classesWithDirectlyAnnotatedFieldsOrMethods.reachableClasses);
                for (ClassInfo metaAnnotatedAnnotation : annotationsWithThisMetaAnnotation.reachableClasses) {
                    allClassesWithAnnotatedOrMetaAnnotatedFieldsOrMethods.addAll(metaAnnotatedAnnotation.filterClassInfo(relType, !metaAnnotatedAnnotation.isExternalClass, new ClassType[0]).reachableClasses);
                }
                return new ClassInfoList(allClassesWithAnnotatedOrMetaAnnotatedFieldsOrMethods, classesWithDirectlyAnnotatedFieldsOrMethods.directlyRelatedClasses, true);
            }
        }
        throw new IllegalArgumentException("Please call ClassGraph#enable" + (isField ? "Field" : "Method") + "Info() and #enableAnnotationInfo() before #scan()");
    }

    public AnnotationInfoList getAnnotationInfo() {
        if (this.scanResult.scanSpec.enableAnnotationInfo) {
            return AnnotationInfoList.getIndirectAnnotations(this.annotationInfo, this);
        }
        throw new IllegalArgumentException("Please call ClassGraph#enableAnnotationInfo() before #scan()");
    }

    public AnnotationInfo getAnnotationInfo(String annotationName) {
        return getAnnotationInfo().get(annotationName);
    }

    public AnnotationInfoList getAnnotationInfoRepeatable(String annotationName) {
        return getAnnotationInfo().getRepeatable(annotationName);
    }

    public AnnotationParameterValueList getAnnotationDefaultParameterValues() {
        if (!this.scanResult.scanSpec.enableAnnotationInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableAnnotationInfo() before #scan()");
        } else if (!isAnnotation()) {
            throw new IllegalArgumentException("Class is not an annotation: " + getName());
        } else if (this.annotationDefaultParamValues == null) {
            return AnnotationParameterValueList.EMPTY_LIST;
        } else {
            if (!this.annotationDefaultParamValuesHasBeenConvertedToPrimitive) {
                this.annotationDefaultParamValues.convertWrapperArraysToPrimitiveArrays(this);
                this.annotationDefaultParamValuesHasBeenConvertedToPrimitive = true;
            }
            return this.annotationDefaultParamValues;
        }
    }

    public ClassInfoList getClassesWithAnnotation() {
        if (!this.scanResult.scanSpec.enableAnnotationInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableAnnotationInfo() before #scan()");
        } else if (!isAnnotation()) {
            throw new IllegalArgumentException("Class is not an annotation: " + getName());
        } else {
            ReachableAndDirectlyRelatedClasses classesWithAnnotation = filterClassInfo(RelType.CLASSES_WITH_ANNOTATION, !this.isExternalClass, new ClassType[0]);
            if (!this.isInherited) {
                return new ClassInfoList(classesWithAnnotation, true);
            }
            Set<ClassInfo> classesWithAnnotationAndTheirSubclasses = new LinkedHashSet<>(classesWithAnnotation.reachableClasses);
            for (ClassInfo classWithAnnotation : classesWithAnnotation.reachableClasses) {
                classesWithAnnotationAndTheirSubclasses.addAll(classWithAnnotation.getSubclasses());
            }
            return new ClassInfoList(classesWithAnnotationAndTheirSubclasses, classesWithAnnotation.directlyRelatedClasses, true);
        }
    }

    /* access modifiers changed from: package-private */
    public ClassInfoList getClassesWithAnnotationDirectOnly() {
        return new ClassInfoList(filterClassInfo(RelType.CLASSES_WITH_ANNOTATION, !this.isExternalClass, new ClassType[0]), true);
    }

    private MethodInfoList getDeclaredMethodInfo(String methodName, boolean getNormalMethods, boolean getConstructorMethods, boolean getStaticInitializerMethods) {
        if (!this.scanResult.scanSpec.enableMethodInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableMethodInfo() before #scan()");
        } else if (this.methodInfo == null) {
            return MethodInfoList.EMPTY_LIST;
        } else {
            if (methodName == null) {
                MethodInfoList methodInfoList = new MethodInfoList();
                Iterator it = this.methodInfo.iterator();
                while (it.hasNext()) {
                    MethodInfo mi = (MethodInfo) it.next();
                    String miName = mi.getName();
                    boolean isConstructor = "<init>".equals(miName);
                    boolean isStaticInitializer = "<clinit>".equals(miName);
                    if ((isConstructor && getConstructorMethods) || ((isStaticInitializer && getStaticInitializerMethods) || (!isConstructor && !isStaticInitializer && getNormalMethods))) {
                        methodInfoList.add(mi);
                    }
                }
                return methodInfoList;
            }
            boolean hasMethodWithName = false;
            Iterator it2 = this.methodInfo.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((MethodInfo) it2.next()).getName().equals(methodName)) {
                        hasMethodWithName = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!hasMethodWithName) {
                return MethodInfoList.EMPTY_LIST;
            }
            MethodInfoList methodInfoList2 = new MethodInfoList();
            Iterator it3 = this.methodInfo.iterator();
            while (it3.hasNext()) {
                MethodInfo mi2 = (MethodInfo) it3.next();
                if (mi2.getName().equals(methodName)) {
                    methodInfoList2.add(mi2);
                }
            }
            return methodInfoList2;
        }
    }

    private MethodInfoList getMethodInfo(String methodName, boolean getNormalMethods, boolean getConstructorMethods, boolean getStaticInitializerMethods) {
        if (!this.scanResult.scanSpec.enableMethodInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableMethodInfo() before #scan()");
        }
        MethodInfoList methodInfoList = new MethodInfoList();
        Set<Map.Entry<String, String>> nameAndTypeDescriptorSet = new HashSet<>();
        for (ClassInfo ci : getOverrideOrder()) {
            Iterator it = ci.getDeclaredMethodInfo(methodName, getNormalMethods, getConstructorMethods, getStaticInitializerMethods).iterator();
            while (it.hasNext()) {
                MethodInfo mi = (MethodInfo) it.next();
                if (nameAndTypeDescriptorSet.add(new AbstractMap.SimpleEntry<>(mi.getName(), mi.getTypeDescriptor().toString()))) {
                    methodInfoList.add(mi);
                }
            }
        }
        return methodInfoList;
    }

    public MethodInfoList getDeclaredMethodInfo() {
        return getDeclaredMethodInfo(null, true, false, false);
    }

    public MethodInfoList getMethodInfo() {
        return getMethodInfo(null, true, false, false);
    }

    public MethodInfoList getDeclaredConstructorInfo() {
        return getDeclaredMethodInfo(null, false, true, false);
    }

    public MethodInfoList getConstructorInfo() {
        return getMethodInfo(null, false, true, false);
    }

    public MethodInfoList getDeclaredMethodAndConstructorInfo() {
        return getDeclaredMethodInfo(null, true, true, false);
    }

    public MethodInfoList getMethodAndConstructorInfo() {
        return getMethodInfo(null, true, true, false);
    }

    public MethodInfoList getDeclaredMethodInfo(String methodName) {
        return getDeclaredMethodInfo(methodName, false, false, false);
    }

    public MethodInfoList getMethodInfo(String methodName) {
        return getMethodInfo(methodName, false, false, false);
    }

    public ClassInfoList getMethodAnnotations() {
        return getFieldOrMethodAnnotations(RelType.METHOD_ANNOTATIONS);
    }

    public ClassInfoList getMethodParameterAnnotations() {
        return getFieldOrMethodAnnotations(RelType.METHOD_PARAMETER_ANNOTATIONS);
    }

    public ClassInfoList getClassesWithMethodAnnotation() {
        Set<ClassInfo> classesWithMethodAnnotation = new HashSet<>(getClassesWithFieldOrMethodAnnotation(RelType.CLASSES_WITH_METHOD_ANNOTATION));
        Iterator it = getClassesWithFieldOrMethodAnnotation(RelType.CLASSES_WITH_NONPRIVATE_METHOD_ANNOTATION).iterator();
        while (it.hasNext()) {
            classesWithMethodAnnotation.addAll(((ClassInfo) it.next()).getSubclasses());
        }
        return new ClassInfoList(classesWithMethodAnnotation, new HashSet(getClassesWithMethodAnnotationDirectOnly()), true);
    }

    public ClassInfoList getClassesWithMethodParameterAnnotation() {
        Set<ClassInfo> classesWithMethodParameterAnnotation = new HashSet<>(getClassesWithFieldOrMethodAnnotation(RelType.CLASSES_WITH_METHOD_PARAMETER_ANNOTATION));
        Iterator it = getClassesWithFieldOrMethodAnnotation(RelType.CLASSES_WITH_NONPRIVATE_METHOD_PARAMETER_ANNOTATION).iterator();
        while (it.hasNext()) {
            classesWithMethodParameterAnnotation.addAll(((ClassInfo) it.next()).getSubclasses());
        }
        return new ClassInfoList(classesWithMethodParameterAnnotation, new HashSet(getClassesWithMethodParameterAnnotationDirectOnly()), true);
    }

    /* access modifiers changed from: package-private */
    public ClassInfoList getClassesWithMethodAnnotationDirectOnly() {
        return new ClassInfoList(filterClassInfo(RelType.CLASSES_WITH_METHOD_ANNOTATION, !this.isExternalClass, new ClassType[0]), true);
    }

    ClassInfoList getClassesWithMethodParameterAnnotationDirectOnly() {
        return new ClassInfoList(filterClassInfo(RelType.CLASSES_WITH_METHOD_PARAMETER_ANNOTATION, !this.isExternalClass, new ClassType[0]), true);
    }

    public FieldInfoList getDeclaredFieldInfo() {
        if (this.scanResult.scanSpec.enableFieldInfo) {
            return this.fieldInfo == null ? FieldInfoList.EMPTY_LIST : this.fieldInfo;
        }
        throw new IllegalArgumentException("Please call ClassGraph#enableFieldInfo() before #scan()");
    }

    public FieldInfoList getFieldInfo() {
        if (!this.scanResult.scanSpec.enableFieldInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableFieldInfo() before #scan()");
        }
        FieldInfoList fieldInfoList = new FieldInfoList();
        Set<String> fieldNameSet = new HashSet<>();
        for (ClassInfo ci : getOverrideOrder()) {
            Iterator it = ci.getDeclaredFieldInfo().iterator();
            while (it.hasNext()) {
                FieldInfo fi = (FieldInfo) it.next();
                if (fieldNameSet.add(fi.getName())) {
                    fieldInfoList.add(fi);
                }
            }
        }
        return fieldInfoList;
    }

    public FieldInfo getDeclaredFieldInfo(String fieldName) {
        if (!this.scanResult.scanSpec.enableFieldInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableFieldInfo() before #scan()");
        } else if (this.fieldInfo == null) {
            return null;
        } else {
            Iterator it = this.fieldInfo.iterator();
            while (it.hasNext()) {
                FieldInfo fi = (FieldInfo) it.next();
                if (fi.getName().equals(fieldName)) {
                    return fi;
                }
            }
            return null;
        }
    }

    public FieldInfo getFieldInfo(String fieldName) {
        if (!this.scanResult.scanSpec.enableFieldInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableFieldInfo() before #scan()");
        }
        for (ClassInfo ci : getOverrideOrder()) {
            FieldInfo fi = ci.getDeclaredFieldInfo(fieldName);
            if (fi != null) {
                return fi;
            }
        }
        return null;
    }

    public ClassInfoList getFieldAnnotations() {
        return getFieldOrMethodAnnotations(RelType.FIELD_ANNOTATIONS);
    }

    public ClassInfoList getClassesWithFieldAnnotation() {
        Set<ClassInfo> classesWithMethodAnnotation = new HashSet<>(getClassesWithFieldOrMethodAnnotation(RelType.CLASSES_WITH_FIELD_ANNOTATION));
        Iterator it = getClassesWithFieldOrMethodAnnotation(RelType.CLASSES_WITH_NONPRIVATE_FIELD_ANNOTATION).iterator();
        while (it.hasNext()) {
            classesWithMethodAnnotation.addAll(((ClassInfo) it.next()).getSubclasses());
        }
        return new ClassInfoList(classesWithMethodAnnotation, new HashSet(getClassesWithMethodAnnotationDirectOnly()), true);
    }

    /* access modifiers changed from: package-private */
    public ClassInfoList getClassesWithFieldAnnotationDirectOnly() {
        return new ClassInfoList(filterClassInfo(RelType.CLASSES_WITH_FIELD_ANNOTATION, !this.isExternalClass, new ClassType[0]), true);
    }

    public ClassTypeSignature getTypeSignature() {
        if (this.typeSignatureStr == null) {
            return null;
        }
        if (this.typeSignature == null) {
            try {
                this.typeSignature = ClassTypeSignature.parse(this.typeSignatureStr, this);
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

    public URI getClasspathElementURI() {
        if (this.classpathElement != null) {
            return this.classpathElement.getURI();
        }
        throw new IllegalArgumentException("Classpath element is not known for this classpath element");
    }

    public URL getClasspathElementURL() {
        if (this.classpathElement == null) {
            throw new IllegalArgumentException("Classpath element is not known for this classpath element");
        }
        try {
            return this.classpathElement.getURI().toURL();
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Could not get classpath element URL", e);
        }
    }

    public File getClasspathElementFile() {
        if (this.classpathElement != null) {
            return this.classpathElement.getFile();
        }
        throw new IllegalArgumentException("Classpath element is not known for this classpath element");
    }

    public ModuleRef getModuleRef() {
        if (this.classpathElement == null) {
            throw new IllegalArgumentException("Classpath element is not known for this classpath element");
        } else if (this.classpathElement instanceof ClasspathElementModule) {
            return ((ClasspathElementModule) this.classpathElement).getModuleRef();
        } else {
            return null;
        }
    }

    public Resource getResource() {
        return this.classfileResource;
    }

    @Override // p013io.github.classgraph.ScanResultObject
    public <T> Class<T> loadClass(Class<T> superclassOrInterfaceType, boolean ignoreExceptions) {
        return loadClass(superclassOrInterfaceType, ignoreExceptions);
    }

    @Override // p013io.github.classgraph.ScanResultObject
    public <T> Class<T> loadClass(Class<T> superclassOrInterfaceType) {
        return loadClass(superclassOrInterfaceType, false);
    }

    @Override // p013io.github.classgraph.ScanResultObject
    public Class<?> loadClass(boolean ignoreExceptions) {
        return loadClass(ignoreExceptions);
    }

    @Override // p013io.github.classgraph.ScanResultObject
    public Class<?> loadClass() {
        return loadClass(false);
    }

    @Override // p013io.github.classgraph.ScanResultObject
    protected String getClassName() {
        return this.name;
    }

    @Override // p013io.github.classgraph.ScanResultObject
    protected ClassInfo getClassInfo() {
        return this;
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ScanResultObject
    public void setScanResult(ScanResult scanResult) {
        setScanResult(scanResult);
        if (this.typeSignature != null) {
            this.typeSignature.setScanResult(scanResult);
        }
        if (this.annotationInfo != null) {
            Iterator it = this.annotationInfo.iterator();
            while (it.hasNext()) {
                ((AnnotationInfo) it.next()).setScanResult(scanResult);
            }
        }
        if (this.fieldInfo != null) {
            Iterator it2 = this.fieldInfo.iterator();
            while (it2.hasNext()) {
                ((FieldInfo) it2.next()).setScanResult(scanResult);
            }
        }
        if (this.methodInfo != null) {
            Iterator it3 = this.methodInfo.iterator();
            while (it3.hasNext()) {
                ((MethodInfo) it3.next()).setScanResult(scanResult);
            }
        }
        if (this.annotationDefaultParamValues != null) {
            Iterator it4 = this.annotationDefaultParamValues.iterator();
            while (it4.hasNext()) {
                ((AnnotationParameterValue) it4.next()).setScanResult(scanResult);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void handleRepeatableAnnotations(Set<String> allRepeatableAnnotationNames) {
        if (this.annotationInfo != null) {
            this.annotationInfo.handleRepeatableAnnotations(allRepeatableAnnotationNames, this, RelType.CLASS_ANNOTATIONS, RelType.CLASSES_WITH_ANNOTATION, null);
        }
        if (this.fieldInfo != null) {
            Iterator it = this.fieldInfo.iterator();
            while (it.hasNext()) {
                ((FieldInfo) it.next()).handleRepeatableAnnotations(allRepeatableAnnotationNames);
            }
        }
        if (this.methodInfo != null) {
            Iterator it2 = this.methodInfo.iterator();
            while (it2.hasNext()) {
                ((MethodInfo) it2.next()).handleRepeatableAnnotations(allRepeatableAnnotationNames);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void addReferencedClassNames(Set<String> refdClassNames) {
        if (this.referencedClassNames == null) {
            this.referencedClassNames = refdClassNames;
        } else {
            this.referencedClassNames.addAll(refdClassNames);
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ScanResultObject
    public void findReferencedClassInfo(Map<String, ClassInfo> classNameToClassInfo, Set<ClassInfo> refdClassInfo) {
        findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        if (this.referencedClassNames != null) {
            for (String refdClassName : this.referencedClassNames) {
                ClassInfo classInfo = getOrCreateClassInfo(refdClassName, classNameToClassInfo);
                classInfo.setScanResult(this.scanResult);
                refdClassInfo.add(classInfo);
            }
        }
        getMethodInfo().findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        getFieldInfo().findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        getAnnotationInfo().findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        if (this.annotationDefaultParamValues != null) {
            this.annotationDefaultParamValues.findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        }
        ClassTypeSignature classSig = getTypeSignature();
        if (classSig != null) {
            classSig.findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        }
    }

    /* access modifiers changed from: package-private */
    public void setReferencedClasses(ClassInfoList refdClasses) {
        this.referencedClasses = refdClasses;
    }

    public ClassInfoList getClassDependencies() {
        if (this.scanResult.scanSpec.enableInterClassDependencies) {
            return this.referencedClasses == null ? ClassInfoList.EMPTY_LIST : this.referencedClasses;
        }
        throw new IllegalArgumentException("Please call ClassGraph#enableInterClassDependencies() before #scan()");
    }

    public int compareTo(ClassInfo o) {
        return this.name.compareTo(o.name);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClassInfo)) {
            return false;
        }
        return this.name.equals(((ClassInfo) obj).name);
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (this.name == null) {
            return 0;
        }
        return this.name.hashCode();
    }

    protected String toString(boolean typeNameOnly) {
        String str;
        ClassTypeSignature typeSig = getTypeSignature();
        if (typeSig != null) {
            return typeSig.toString(this.name, typeNameOnly, this.modifiers, isAnnotation(), isInterface());
        }
        StringBuilder buf = new StringBuilder();
        if (typeNameOnly) {
            buf.append(this.name);
        } else {
            TypeUtils.modifiersToString(this.modifiers, TypeUtils.ModifierType.CLASS, false, buf);
            if (buf.length() > 0) {
                buf.append(' ');
            }
            if (isRecord()) {
                str = "record ";
            } else if (isEnum()) {
                str = "enum ";
            } else if (isAnnotation()) {
                str = "@interface ";
            } else {
                str = isInterface() ? "interface " : "class ";
            }
            buf.append(str);
            buf.append(this.name);
            ClassInfo superclass = getSuperclass();
            if (superclass != null && !superclass.getName().equals("java.lang.Object")) {
                buf.append(" extends ").append(superclass.toString(true));
            }
            Set<ClassInfo> interfaces = filterClassInfo(RelType.IMPLEMENTED_INTERFACES, false, new ClassType[0]).directlyRelatedClasses;
            if (!interfaces.isEmpty()) {
                buf.append(isInterface() ? " extends " : " implements ");
                boolean first = true;
                for (ClassInfo iface : interfaces) {
                    if (first) {
                        first = false;
                    } else {
                        buf.append(", ");
                    }
                    buf.append(iface.toString(true));
                }
            }
        }
        return buf.toString();
    }

    @Override // java.lang.Object
    public String toString() {
        return toString(false);
    }
}
