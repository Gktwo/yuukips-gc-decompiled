package p013io.github.classgraph;

import dev.morphia.mapping.Mapper;
import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nonapi.p019io.github.classgraph.concurrency.AutoCloseableExecutorService;
import nonapi.p019io.github.classgraph.fastzipfilereader.NestedJarHandler;
import nonapi.p019io.github.classgraph.json.JSONDeserializer;
import nonapi.p019io.github.classgraph.json.JSONSerializer;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.CollectionUtils;
import nonapi.p019io.github.classgraph.utils.FileUtils;
import nonapi.p019io.github.classgraph.utils.JarUtils;
import nonapi.p019io.github.classgraph.utils.LogNode;

/* renamed from: io.github.classgraph.ScanResult */
/* loaded from: grasscutter.jar:io/github/classgraph/ScanResult.class */
public final class ScanResult implements Closeable, AutoCloseable {
    private List<String> rawClasspathEltOrderStrs;
    private List<ClasspathElement> classpathOrder;
    private ResourceList allWhitelistedResourcesCached;
    private Map<String, ResourceList> pathToWhitelistedResourcesCached;
    Map<String, ClassInfo> classNameToClassInfo;
    private Map<String, PackageInfo> packageNameToPackageInfo;
    private Map<String, ModuleInfo> moduleNameToModuleInfo;
    private Map<File, Long> fileToLastModified;
    private boolean isObtainedFromDeserialization;
    private ClassGraphClassLoader classGraphClassLoader;
    private ClassLoader[] classLoaderOrderRespectingParentDelegation;
    private NestedJarHandler nestedJarHandler;
    ScanSpec scanSpec;
    private final LogNode topLevelLog;
    private final WeakReference<ScanResult> weakReference;
    private static Set<WeakReference<ScanResult>> nonClosedWeakReferences = Collections.newSetFromMap(new ConcurrentHashMap());
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final String CURRENT_SERIALIZATION_FORMAT = "10";
    private final AtomicInteger getResourcesWithPathCallCount = new AtomicInteger();
    private final AtomicBoolean closed = new AtomicBoolean(false);

    /* access modifiers changed from: private */
    /* renamed from: io.github.classgraph.ScanResult$SerializationFormat */
    /* loaded from: grasscutter.jar:io/github/classgraph/ScanResult$SerializationFormat.class */
    public static class SerializationFormat {
        public String format;
        public ScanSpec scanSpec;
        public List<String> classpath;
        public List<ClassInfo> classInfo;
        public List<PackageInfo> packageInfo;
        public List<ModuleInfo> moduleInfo;

        public SerializationFormat() {
        }

        public SerializationFormat(String serializationFormatStr, ScanSpec scanSpec, List<ClassInfo> classInfo, List<PackageInfo> packageInfo, List<ModuleInfo> moduleInfo, List<String> classpath) {
            this.format = serializationFormatStr;
            this.scanSpec = scanSpec;
            this.classpath = classpath;
            this.classInfo = classInfo;
            this.packageInfo = packageInfo;
            this.moduleInfo = moduleInfo;
        }
    }

    /* access modifiers changed from: package-private */
    public static void init() {
        if (!initialized.getAndSet(true)) {
            FileUtils.closeDirectByteBuffer(ByteBuffer.allocateDirect(32), null);
        }
    }

    /* access modifiers changed from: package-private */
    public ScanResult(ScanSpec scanSpec, List<ClasspathElement> classpathOrder, List<String> rawClasspathEltOrderStrs, ClassLoader[] classLoaderOrderRespectingParentDelegation, Map<String, ClassInfo> classNameToClassInfo, Map<String, PackageInfo> packageNameToPackageInfo, Map<String, ModuleInfo> moduleNameToModuleInfo, Map<File, Long> fileToLastModified, NestedJarHandler nestedJarHandler, LogNode topLevelLog) {
        AnnotationInfo repeatableMetaAnnotation;
        String repeatableAnnotationName;
        this.scanSpec = scanSpec;
        this.rawClasspathEltOrderStrs = rawClasspathEltOrderStrs;
        this.classpathOrder = classpathOrder;
        this.classLoaderOrderRespectingParentDelegation = classLoaderOrderRespectingParentDelegation;
        this.fileToLastModified = fileToLastModified;
        this.classNameToClassInfo = classNameToClassInfo;
        this.packageNameToPackageInfo = packageNameToPackageInfo;
        this.moduleNameToModuleInfo = moduleNameToModuleInfo;
        this.nestedJarHandler = nestedJarHandler;
        this.topLevelLog = topLevelLog;
        if (classNameToClassInfo != null) {
            indexResourcesAndClassInfo();
        }
        if (classNameToClassInfo != null) {
            Set<String> allRepeatableAnnotationNames = new HashSet<>();
            for (ClassInfo classInfo : classNameToClassInfo.values()) {
                if (!(!classInfo.isAnnotation() || classInfo.annotationInfo == null || (repeatableMetaAnnotation = classInfo.annotationInfo.get("java.lang.annotation.Repeatable")) == null)) {
                    AnnotationParameterValueList vals = repeatableMetaAnnotation.getParameterValues();
                    if (!vals.isEmpty()) {
                        Object val = vals.getValue("value");
                        if ((val instanceof AnnotationClassRef) && (repeatableAnnotationName = ((AnnotationClassRef) val).getName()) != null) {
                            allRepeatableAnnotationNames.add(repeatableAnnotationName);
                        }
                    }
                }
            }
            if (!allRepeatableAnnotationNames.isEmpty()) {
                for (ClassInfo classInfo2 : classNameToClassInfo.values()) {
                    classInfo2.handleRepeatableAnnotations(allRepeatableAnnotationNames);
                }
            }
        }
        this.classGraphClassLoader = new ClassGraphClassLoader(this);
        this.weakReference = new WeakReference<>(this);
        nonClosedWeakReferences.add(this.weakReference);
    }

    private void indexResourcesAndClassInfo() {
        for (ClassInfo classInfo : this.classNameToClassInfo.values()) {
            classInfo.setScanResult(this);
        }
        if (this.scanSpec.enableInterClassDependencies) {
            Iterator it = new ArrayList(this.classNameToClassInfo.values()).iterator();
            while (it.hasNext()) {
                ClassInfo ci = (ClassInfo) it.next();
                Set<ClassInfo> refdClassesFiltered = new HashSet<>();
                for (ClassInfo refdClassInfo : ci.findReferencedClassInfo()) {
                    if (refdClassInfo != null && !ci.equals(refdClassInfo) && !refdClassInfo.getName().equals("java.lang.Object") && (!refdClassInfo.isExternalClass() || this.scanSpec.enableExternalClasses)) {
                        refdClassInfo.setScanResult(this);
                        refdClassesFiltered.add(refdClassInfo);
                    }
                }
                ci.setReferencedClasses(new ClassInfoList(refdClassesFiltered, true));
            }
        }
    }

    public List<File> getClasspathFiles() {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        }
        List<File> classpathElementOrderFiles = new ArrayList<>();
        for (ClasspathElement classpathElement : this.classpathOrder) {
            File file = classpathElement.getFile();
            if (file != null) {
                classpathElementOrderFiles.add(file);
            }
        }
        return classpathElementOrderFiles;
    }

    public String getClasspath() {
        if (!this.closed.get()) {
            return JarUtils.pathElementsToPathStr(getClasspathFiles());
        }
        throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
    }

    public List<URI> getClasspathURIs() {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        }
        List<URI> classpathElementOrderURIs = new ArrayList<>();
        for (ClasspathElement classpathElement : this.classpathOrder) {
            try {
                URI uri = classpathElement.getURI();
                if (uri != null) {
                    classpathElementOrderURIs.add(uri);
                }
            } catch (IllegalArgumentException e) {
            }
        }
        return classpathElementOrderURIs;
    }

    public List<URL> getClasspathURLs() {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        }
        List<URL> classpathElementOrderURLs = new ArrayList<>();
        for (ClasspathElement classpathElement : this.classpathOrder) {
            try {
                URI uri = classpathElement.getURI();
                if (uri != null) {
                    classpathElementOrderURLs.add(uri.toURL());
                }
            } catch (IllegalArgumentException | MalformedURLException e) {
            }
        }
        return classpathElementOrderURLs;
    }

    public List<ModuleRef> getModules() {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        }
        List<ModuleRef> moduleRefs = new ArrayList<>();
        for (ClasspathElement classpathElement : this.classpathOrder) {
            if (classpathElement instanceof ClasspathElementModule) {
                moduleRefs.add(((ClasspathElementModule) classpathElement).getModuleRef());
            }
        }
        return moduleRefs;
    }

    public ModulePathInfo getModulePathInfo() {
        return this.scanSpec.modulePathInfo;
    }

    public ResourceList getAllResources() {
        if (this.allWhitelistedResourcesCached == null) {
            ResourceList whitelistedResourcesList = new ResourceList();
            for (ClasspathElement classpathElt : this.classpathOrder) {
                whitelistedResourcesList.addAll(classpathElt.whitelistedResources);
            }
            this.allWhitelistedResourcesCached = whitelistedResourcesList;
        }
        return this.allWhitelistedResourcesCached;
    }

    public Map<String, ResourceList> getAllResourcesAsMap() {
        if (this.pathToWhitelistedResourcesCached == null) {
            Map<String, ResourceList> pathToWhitelistedResourceListMap = new HashMap<>();
            Iterator it = getAllResources().iterator();
            while (it.hasNext()) {
                Resource res = (Resource) it.next();
                ResourceList resList = pathToWhitelistedResourceListMap.get(res.getPath());
                if (resList == null) {
                    String path = res.getPath();
                    ResourceList resourceList = new ResourceList();
                    resList = resourceList;
                    pathToWhitelistedResourceListMap.put(path, resourceList);
                }
                resList.add(res);
            }
            this.pathToWhitelistedResourcesCached = pathToWhitelistedResourceListMap;
        }
        return this.pathToWhitelistedResourcesCached;
    }

    public ResourceList getResourcesWithPath(String resourcePath) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        }
        String path = FileUtils.sanitizeEntryPath(resourcePath, true, true);
        if (this.getResourcesWithPathCallCount.incrementAndGet() > 3) {
            return getAllResourcesAsMap().get(path);
        }
        ResourceList matchingResources = null;
        for (ClasspathElement classpathElt : this.classpathOrder) {
            for (Resource res : classpathElt.whitelistedResources) {
                if (res.getPath().equals(path)) {
                    if (matchingResources == null) {
                        matchingResources = new ResourceList();
                    }
                    matchingResources.add(res);
                }
            }
        }
        return matchingResources == null ? ResourceList.EMPTY_LIST : matchingResources;
    }

    public ResourceList getResourcesWithPathIgnoringWhitelist(String resourcePath) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        }
        String path = FileUtils.sanitizeEntryPath(resourcePath, true, true);
        ResourceList matchingResources = new ResourceList();
        for (ClasspathElement classpathElt : this.classpathOrder) {
            Resource matchingResource = classpathElt.getResource(path);
            if (matchingResource != null) {
                matchingResources.add(matchingResource);
            }
        }
        return matchingResources;
    }

    public ResourceList getResourcesWithLeafName(String leafName) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        }
        ResourceList allWhitelistedResources = getAllResources();
        if (allWhitelistedResources.isEmpty()) {
            return ResourceList.EMPTY_LIST;
        }
        ResourceList filteredResources = new ResourceList();
        Iterator it = allWhitelistedResources.iterator();
        while (it.hasNext()) {
            Resource classpathResource = (Resource) it.next();
            String relativePath = classpathResource.getPath();
            if (relativePath.substring(relativePath.lastIndexOf(47) + 1).equals(leafName)) {
                filteredResources.add(classpathResource);
            }
        }
        return filteredResources;
    }

    public ResourceList getResourcesWithExtension(String extension) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        }
        ResourceList allWhitelistedResources = getAllResources();
        if (allWhitelistedResources.isEmpty()) {
            return ResourceList.EMPTY_LIST;
        }
        String bareExtension = extension;
        while (bareExtension.startsWith(Mapper.IGNORED_FIELDNAME)) {
            bareExtension = bareExtension.substring(1);
        }
        ResourceList filteredResources = new ResourceList();
        Iterator it = allWhitelistedResources.iterator();
        while (it.hasNext()) {
            Resource classpathResource = (Resource) it.next();
            String relativePath = classpathResource.getPath();
            int lastSlashIdx = relativePath.lastIndexOf(47);
            int lastDotIdx = relativePath.lastIndexOf(46);
            if (lastDotIdx > lastSlashIdx && relativePath.substring(lastDotIdx + 1).equalsIgnoreCase(bareExtension)) {
                filteredResources.add(classpathResource);
            }
        }
        return filteredResources;
    }

    public ResourceList getResourcesMatchingPattern(Pattern pattern) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        }
        ResourceList allWhitelistedResources = getAllResources();
        if (allWhitelistedResources.isEmpty()) {
            return ResourceList.EMPTY_LIST;
        }
        ResourceList filteredResources = new ResourceList();
        Iterator it = allWhitelistedResources.iterator();
        while (it.hasNext()) {
            Resource classpathResource = (Resource) it.next();
            if (pattern.matcher(classpathResource.getPath()).matches()) {
                filteredResources.add(classpathResource);
            }
        }
        return filteredResources;
    }

    public ModuleInfo getModuleInfo(String moduleName) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (this.scanSpec.enableClassInfo) {
            return this.moduleNameToModuleInfo.get(moduleName);
        } else {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
        }
    }

    public ModuleInfoList getModuleInfo() {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (this.scanSpec.enableClassInfo) {
            return new ModuleInfoList(this.moduleNameToModuleInfo.values());
        } else {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
        }
    }

    public PackageInfo getPackageInfo(String packageName) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (this.scanSpec.enableClassInfo) {
            return this.packageNameToPackageInfo.get(packageName);
        } else {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
        }
    }

    public PackageInfoList getPackageInfo() {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (this.scanSpec.enableClassInfo) {
            return new PackageInfoList(this.packageNameToPackageInfo.values());
        } else {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
        }
    }

    public Map<ClassInfo, ClassInfoList> getClassDependencyMap() {
        Map<ClassInfo, ClassInfoList> map = new HashMap<>();
        Iterator it = getAllClasses().iterator();
        while (it.hasNext()) {
            ClassInfo ci = (ClassInfo) it.next();
            map.put(ci, ci.getClassDependencies());
        }
        return map;
    }

    public Map<ClassInfo, ClassInfoList> getReverseClassDependencyMap() {
        Map<ClassInfo, Set<ClassInfo>> revMapSet = new HashMap<>();
        Iterator it = getAllClasses().iterator();
        while (it.hasNext()) {
            ClassInfo ci = (ClassInfo) it.next();
            Iterator it2 = ci.getClassDependencies().iterator();
            while (it2.hasNext()) {
                ClassInfo dep = (ClassInfo) it2.next();
                Set<ClassInfo> set = revMapSet.get(dep);
                if (set == null) {
                    Set<ClassInfo> hashSet = new HashSet<>();
                    set = hashSet;
                    revMapSet.put(dep, hashSet);
                }
                set.add(ci);
            }
        }
        Map<ClassInfo, ClassInfoList> revMapList = new HashMap<>();
        for (Map.Entry<ClassInfo, Set<ClassInfo>> ent : revMapSet.entrySet()) {
            revMapList.put(ent.getKey(), new ClassInfoList(ent.getValue(), true));
        }
        return revMapList;
    }

    public ClassInfo getClassInfo(String className) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (this.scanSpec.enableClassInfo) {
            return this.classNameToClassInfo.get(className);
        } else {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
        }
    }

    public ClassInfoList getAllClasses() {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (this.scanSpec.enableClassInfo) {
            return ClassInfo.getAllClasses(this.classNameToClassInfo.values(), this.scanSpec);
        } else {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
        }
    }

    public ClassInfoList getAllEnums() {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (this.scanSpec.enableClassInfo) {
            return ClassInfo.getAllEnums(this.classNameToClassInfo.values(), this.scanSpec);
        } else {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
        }
    }

    public ClassInfoList getAllRecords() {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (this.scanSpec.enableClassInfo) {
            return ClassInfo.getAllRecords(this.classNameToClassInfo.values(), this.scanSpec);
        } else {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
        }
    }

    public Map<String, ClassInfo> getAllClassesAsMap() {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (this.scanSpec.enableClassInfo) {
            return this.classNameToClassInfo;
        } else {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
        }
    }

    public ClassInfoList getAllStandardClasses() {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (this.scanSpec.enableClassInfo) {
            return ClassInfo.getAllStandardClasses(this.classNameToClassInfo.values(), this.scanSpec);
        } else {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
        }
    }

    public ClassInfoList getSubclasses(String superclassName) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (!this.scanSpec.enableClassInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
        } else if (superclassName.equals("java.lang.Object")) {
            return getAllStandardClasses();
        } else {
            ClassInfo superclass = this.classNameToClassInfo.get(superclassName);
            return superclass == null ? ClassInfoList.EMPTY_LIST : superclass.getSubclasses();
        }
    }

    public ClassInfoList getSuperclasses(String subclassName) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (!this.scanSpec.enableClassInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
        } else {
            ClassInfo subclass = this.classNameToClassInfo.get(subclassName);
            return subclass == null ? ClassInfoList.EMPTY_LIST : subclass.getSuperclasses();
        }
    }

    public ClassInfoList getClassesWithMethodAnnotation(String methodAnnotationName) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (!this.scanSpec.enableClassInfo || !this.scanSpec.enableMethodInfo || !this.scanSpec.enableAnnotationInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo(), #enableMethodInfo(), and #enableAnnotationInfo() before #scan()");
        } else {
            ClassInfo classInfo = this.classNameToClassInfo.get(methodAnnotationName);
            return classInfo == null ? ClassInfoList.EMPTY_LIST : classInfo.getClassesWithMethodAnnotation();
        }
    }

    public ClassInfoList getClassesWithMethodParameterAnnotation(String methodParameterAnnotationName) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (!this.scanSpec.enableClassInfo || !this.scanSpec.enableMethodInfo || !this.scanSpec.enableAnnotationInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo(), #enableMethodInfo(), and #enableAnnotationInfo() before #scan()");
        } else {
            ClassInfo classInfo = this.classNameToClassInfo.get(methodParameterAnnotationName);
            return classInfo == null ? ClassInfoList.EMPTY_LIST : classInfo.getClassesWithMethodParameterAnnotation();
        }
    }

    public ClassInfoList getClassesWithFieldAnnotation(String fieldAnnotationName) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (!this.scanSpec.enableClassInfo || !this.scanSpec.enableFieldInfo || !this.scanSpec.enableAnnotationInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo(), #enableFieldInfo(), and #enableAnnotationInfo() before #scan()");
        } else {
            ClassInfo classInfo = this.classNameToClassInfo.get(fieldAnnotationName);
            return classInfo == null ? ClassInfoList.EMPTY_LIST : classInfo.getClassesWithFieldAnnotation();
        }
    }

    public ClassInfoList getAllInterfaces() {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (this.scanSpec.enableClassInfo) {
            return ClassInfo.getAllImplementedInterfaceClasses(this.classNameToClassInfo.values(), this.scanSpec);
        } else {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
        }
    }

    public ClassInfoList getInterfaces(String className) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (!this.scanSpec.enableClassInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
        } else {
            ClassInfo classInfo = this.classNameToClassInfo.get(className);
            return classInfo == null ? ClassInfoList.EMPTY_LIST : classInfo.getInterfaces();
        }
    }

    public ClassInfoList getClassesImplementing(String interfaceName) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (!this.scanSpec.enableClassInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
        } else {
            ClassInfo classInfo = this.classNameToClassInfo.get(interfaceName);
            return classInfo == null ? ClassInfoList.EMPTY_LIST : classInfo.getClassesImplementing();
        }
    }

    public ClassInfoList getAllAnnotations() {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (this.scanSpec.enableClassInfo && this.scanSpec.enableAnnotationInfo) {
            return ClassInfo.getAllAnnotationClasses(this.classNameToClassInfo.values(), this.scanSpec);
        } else {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() and #enableAnnotationInfo() before #scan()");
        }
    }

    public ClassInfoList getAllInterfacesAndAnnotations() {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (this.scanSpec.enableClassInfo && this.scanSpec.enableAnnotationInfo) {
            return ClassInfo.getAllInterfacesOrAnnotationClasses(this.classNameToClassInfo.values(), this.scanSpec);
        } else {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() and #enableAnnotationInfo() before #scan()");
        }
    }

    public ClassInfoList getClassesWithAnnotation(String annotationName) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (!this.scanSpec.enableClassInfo || !this.scanSpec.enableAnnotationInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() and #enableAnnotationInfo() before #scan()");
        } else {
            ClassInfo classInfo = this.classNameToClassInfo.get(annotationName);
            return classInfo == null ? ClassInfoList.EMPTY_LIST : classInfo.getClassesWithAnnotation();
        }
    }

    public ClassInfoList getAnnotationsOnClass(String className) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (!this.scanSpec.enableClassInfo || !this.scanSpec.enableAnnotationInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() and #enableAnnotationInfo() before #scan()");
        } else {
            ClassInfo classInfo = this.classNameToClassInfo.get(className);
            return classInfo == null ? ClassInfoList.EMPTY_LIST : classInfo.getAnnotations();
        }
    }

    public boolean classpathContentsModifiedSinceScan() {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (this.fileToLastModified == null) {
            return true;
        } else {
            for (Map.Entry<File, Long> ent : this.fileToLastModified.entrySet()) {
                if (ent.getKey().lastModified() != ent.getValue().longValue()) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long classpathContentsLastModifiedTime() {
        /*
            r5 = this;
            r0 = r5
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.closed
            boolean r0 = r0.get()
            if (r0 == 0) goto L_0x0014
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "Cannot use a ScanResult after it has been closed"
            r1.<init>(r2)
            throw r0
        L_0x0014:
            r0 = 0
            r6 = r0
            r0 = r5
            java.util.Map<java.io.File, java.lang.Long> r0 = r0.fileToLastModified
            if (r0 == 0) goto L_0x005e
            long r0 = java.lang.System.currentTimeMillis()
            r8 = r0
            r0 = r5
            java.util.Map<java.io.File, java.lang.Long> r0 = r0.fileToLastModified
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
            r10 = r0
        L_0x0031:
            r0 = r10
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x005e
            r0 = r10
            java.lang.Object r0 = r0.next()
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            r11 = r0
            r0 = r11
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x005b
            r0 = r11
            r1 = r8
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x005b
            r0 = r11
            r6 = r0
        L_0x005b:
            goto L_0x0031
        L_0x005e:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.github.classgraph.ScanResult.classpathContentsLastModifiedTime():long");
    }

    /* access modifiers changed from: package-private */
    public ClassLoader[] getClassLoaderOrderRespectingParentDelegation() {
        return this.classLoaderOrderRespectingParentDelegation;
    }

    public Class<?> loadClass(String className, boolean returnNullIfClassNotFound) throws IllegalArgumentException {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (className == null || className.isEmpty()) {
            throw new NullPointerException("className cannot be null or empty");
        } else {
            try {
                return Class.forName(className, this.scanSpec.initializeLoadedClasses, this.classGraphClassLoader);
            } catch (ClassNotFoundException | LinkageError e) {
                if (returnNullIfClassNotFound) {
                    return null;
                }
                throw new IllegalArgumentException("Could not load class " + className + " : " + e);
            }
        }
    }

    public <T> Class<T> loadClass(String className, Class<T> superclassOrInterfaceType, boolean returnNullIfClassNotFound) throws IllegalArgumentException {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (className == null || className.isEmpty()) {
            throw new NullPointerException("className cannot be null or empty");
        } else if (superclassOrInterfaceType == null) {
            throw new NullPointerException("superclassOrInterfaceType parameter cannot be null");
        } else {
            try {
                Class<T> cls = (Class<T>) Class.forName(className, this.scanSpec.initializeLoadedClasses, this.classGraphClassLoader);
                if (cls == null || superclassOrInterfaceType.isAssignableFrom(cls)) {
                    return cls;
                }
                if (returnNullIfClassNotFound) {
                    return null;
                }
                throw new IllegalArgumentException("Loaded class " + cls.getName() + " cannot be cast to " + superclassOrInterfaceType.getName());
            } catch (ClassNotFoundException | LinkageError e) {
                if (returnNullIfClassNotFound) {
                    return null;
                }
                throw new IllegalArgumentException("Could not load class " + className + " : " + e);
            }
        }
    }

    public static ScanResult fromJSON(String json) {
        Matcher matcher = Pattern.compile("\\{[\\n\\r ]*\"format\"[ ]?:[ ]?\"([^\"]+)\"").matcher(json);
        if (!matcher.find()) {
            throw new IllegalArgumentException("JSON is not in correct format");
        } else if (!"10".equals(matcher.group(1))) {
            throw new IllegalArgumentException("JSON was serialized in a different format from the format used by the current version of ClassGraph -- please serialize and deserialize your ScanResult using the same version of ClassGraph");
        } else {
            SerializationFormat deserialized = (SerializationFormat) JSONDeserializer.deserializeObject(SerializationFormat.class, json);
            if (!deserialized.format.equals("10")) {
                throw new IllegalArgumentException("JSON was serialized by newer version of ClassGraph");
            }
            ClassGraph classGraph = new ClassGraph();
            classGraph.scanSpec = deserialized.scanSpec;
            if (classGraph.scanSpec.overrideClasspath == null) {
                classGraph.overrideClasspath(deserialized.classpath);
            }
            AutoCloseableExecutorService executorService = new AutoCloseableExecutorService(ClassGraph.DEFAULT_NUM_WORKER_THREADS);
            Throwable th = null;
            try {
                ScanResult scanResult = classGraph.getClasspathScanResult(executorService);
                if (executorService != null) {
                    if (0 != 0) {
                        try {
                            executorService.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        executorService.close();
                    }
                }
                scanResult.rawClasspathEltOrderStrs = deserialized.classpath;
                scanResult.scanSpec = deserialized.scanSpec;
                scanResult.classNameToClassInfo = new HashMap();
                if (deserialized.classInfo != null) {
                    for (ClassInfo ci : deserialized.classInfo) {
                        scanResult.classNameToClassInfo.put(ci.getName(), ci);
                        ci.setScanResult(scanResult);
                    }
                }
                scanResult.moduleNameToModuleInfo = new HashMap();
                if (deserialized.moduleInfo != null) {
                    for (ModuleInfo mi : deserialized.moduleInfo) {
                        scanResult.moduleNameToModuleInfo.put(mi.getName(), mi);
                    }
                }
                scanResult.packageNameToPackageInfo = new HashMap();
                if (deserialized.packageInfo != null) {
                    for (PackageInfo pi : deserialized.packageInfo) {
                        scanResult.packageNameToPackageInfo.put(pi.getName(), pi);
                    }
                }
                scanResult.indexResourcesAndClassInfo();
                scanResult.isObtainedFromDeserialization = true;
                return scanResult;
            } catch (Throwable th3) {
                if (executorService != null) {
                    if (0 != 0) {
                        try {
                            executorService.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        executorService.close();
                    }
                }
                throw th3;
            }
        }
    }

    public String toJSON(int indentWidth) {
        if (this.closed.get()) {
            throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
        } else if (!this.scanSpec.enableClassInfo) {
            throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
        } else {
            List<ClassInfo> allClassInfo = new ArrayList<>(this.classNameToClassInfo.values());
            CollectionUtils.sortIfNotEmpty(allClassInfo);
            List<PackageInfo> allPackageInfo = new ArrayList<>(this.packageNameToPackageInfo.values());
            CollectionUtils.sortIfNotEmpty(allPackageInfo);
            List<ModuleInfo> allModuleInfo = new ArrayList<>(this.moduleNameToModuleInfo.values());
            CollectionUtils.sortIfNotEmpty(allModuleInfo);
            return JSONSerializer.serializeObject(new SerializationFormat("10", this.scanSpec, allClassInfo, allPackageInfo, allModuleInfo, this.rawClasspathEltOrderStrs), indentWidth, false);
        }
    }

    public String toJSON() {
        return toJSON(0);
    }

    public boolean isObtainedFromDeserialization() {
        return this.isObtainedFromDeserialization;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.closed.getAndSet(true)) {
            nonClosedWeakReferences.remove(this.weakReference);
            if (this.classpathOrder != null) {
                this.classpathOrder.clear();
                this.classpathOrder = null;
            }
            if (this.allWhitelistedResourcesCached != null) {
                Iterator it = this.allWhitelistedResourcesCached.iterator();
                while (it.hasNext()) {
                    ((Resource) it.next()).close();
                }
                this.allWhitelistedResourcesCached.clear();
                this.allWhitelistedResourcesCached = null;
            }
            if (this.pathToWhitelistedResourcesCached != null) {
                this.pathToWhitelistedResourcesCached.clear();
                this.pathToWhitelistedResourcesCached = null;
            }
            this.classGraphClassLoader = null;
            if (this.classNameToClassInfo != null) {
            }
            if (this.packageNameToPackageInfo != null) {
                this.packageNameToPackageInfo.clear();
                this.packageNameToPackageInfo = null;
            }
            if (this.moduleNameToModuleInfo != null) {
                this.moduleNameToModuleInfo.clear();
                this.moduleNameToModuleInfo = null;
            }
            if (this.fileToLastModified != null) {
                this.fileToLastModified.clear();
                this.fileToLastModified = null;
            }
            if (this.nestedJarHandler != null) {
                this.nestedJarHandler.close(this.topLevelLog);
                this.nestedJarHandler = null;
            }
            this.classGraphClassLoader = null;
            this.classLoaderOrderRespectingParentDelegation = null;
            if (this.topLevelLog != null) {
                this.topLevelLog.flush();
            }
        }
    }

    public static void closeAll() {
        Iterator it = new ArrayList(nonClosedWeakReferences).iterator();
        while (it.hasNext()) {
            ScanResult scanResult = ((WeakReference) it.next()).get();
            if (scanResult != null) {
                scanResult.close();
            }
        }
    }
}
