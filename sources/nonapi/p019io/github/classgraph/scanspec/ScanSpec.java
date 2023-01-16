package nonapi.p019io.github.classgraph.scanspec;

import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import nonapi.p019io.github.classgraph.scanspec.WhiteBlackList;
import nonapi.p019io.github.classgraph.utils.LogNode;
import p013io.github.classgraph.ClassGraph;
import p013io.github.classgraph.ClassGraphException;
import p013io.github.classgraph.ModulePathInfo;

/* renamed from: nonapi.io.github.classgraph.scanspec.ScanSpec */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/scanspec/ScanSpec.class */
public class ScanSpec {
    public boolean enableClassInfo;
    public boolean enableFieldInfo;
    public boolean enableMethodInfo;
    public boolean enableAnnotationInfo;
    public boolean enableStaticFinalFieldConstantInitializerValues;
    public boolean enableInterClassDependencies;
    public boolean enableExternalClasses;
    public boolean enableSystemJarsAndModules;
    public boolean ignoreClassVisibility;
    public boolean ignoreFieldVisibility;
    public boolean ignoreMethodVisibility;
    public boolean disableRuntimeInvisibleAnnotations;
    public Set<String> allowedURLSchemes;
    public transient List<ClassLoader> addedClassLoaders;
    public transient List<ClassLoader> overrideClassLoaders;
    public transient List<Object> addedModuleLayers;
    public transient List<Object> overrideModuleLayers;
    public List<Object> overrideClasspath;
    public transient List<ClassGraph.ClasspathElementFilter> classpathElementFilters;
    public boolean initializeLoadedClasses;
    public boolean removeTemporaryFilesAfterScan;
    public boolean ignoreParentClassLoaders;
    public boolean ignoreParentModuleLayers;
    public boolean enableMemoryMapping;
    public WhiteBlackList.WhiteBlackListWholeString packageWhiteBlackList = new WhiteBlackList.WhiteBlackListWholeString('.');
    public WhiteBlackList.WhiteBlackListPrefix packagePrefixWhiteBlackList = new WhiteBlackList.WhiteBlackListPrefix('.');
    public WhiteBlackList.WhiteBlackListWholeString pathWhiteBlackList = new WhiteBlackList.WhiteBlackListWholeString('/');
    public WhiteBlackList.WhiteBlackListPrefix pathPrefixWhiteBlackList = new WhiteBlackList.WhiteBlackListPrefix('/');
    public WhiteBlackList.WhiteBlackListWholeString classWhiteBlackList = new WhiteBlackList.WhiteBlackListWholeString('.');
    public WhiteBlackList.WhiteBlackListWholeString classfilePathWhiteBlackList = new WhiteBlackList.WhiteBlackListWholeString('/');
    public WhiteBlackList.WhiteBlackListWholeString classPackageWhiteBlackList = new WhiteBlackList.WhiteBlackListWholeString('.');
    public WhiteBlackList.WhiteBlackListWholeString classPackagePathWhiteBlackList = new WhiteBlackList.WhiteBlackListWholeString('/');
    public WhiteBlackList.WhiteBlackListWholeString moduleWhiteBlackList = new WhiteBlackList.WhiteBlackListWholeString('.');
    public WhiteBlackList.WhiteBlackListLeafname jarWhiteBlackList = new WhiteBlackList.WhiteBlackListLeafname('/');
    public WhiteBlackList.WhiteBlackListWholeString classpathElementResourcePathWhiteBlackList = new WhiteBlackList.WhiteBlackListWholeString('/');
    public WhiteBlackList.WhiteBlackListLeafname libOrExtJarWhiteBlackList = new WhiteBlackList.WhiteBlackListLeafname('/');
    public boolean scanJars = true;
    public boolean scanNestedJars = true;
    public boolean scanDirs = true;
    public boolean scanModules = true;
    public boolean extendScanningUpwardsToExternalClasses = true;
    public ModulePathInfo modulePathInfo = new ModulePathInfo();
    public int maxBufferedJarRAMSize = 67108864;

    /* renamed from: nonapi.io.github.classgraph.scanspec.ScanSpec$ScanSpecPathMatch */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/scanspec/ScanSpec$ScanSpecPathMatch.class */
    public enum ScanSpecPathMatch {
        HAS_BLACKLISTED_PATH_PREFIX,
        HAS_WHITELISTED_PATH_PREFIX,
        AT_WHITELISTED_PATH,
        ANCESTOR_OF_WHITELISTED_PATH,
        AT_WHITELISTED_CLASS_PACKAGE,
        NOT_WITHIN_WHITELISTED_PATH
    }

    public void sortPrefixes() {
        Field[] declaredFields = ScanSpec.class.getDeclaredFields();
        for (Field field : declaredFields) {
            if (WhiteBlackList.class.isAssignableFrom(field.getType())) {
                try {
                    ((WhiteBlackList) field.get(this)).sortPrefixes();
                } catch (ReflectiveOperationException e) {
                    throw ClassGraphException.newClassGraphException("Field is not accessible: " + field, e);
                }
            }
        }
    }

    public void addClasspathOverride(Object overrideClasspathElement) {
        if (this.overrideClasspath == null) {
            this.overrideClasspath = new ArrayList();
        }
        this.overrideClasspath.add(((overrideClasspathElement instanceof String) || (overrideClasspathElement instanceof URL) || (overrideClasspathElement instanceof URI)) ? overrideClasspathElement : overrideClasspathElement.toString());
    }

    public void filterClasspathElements(ClassGraph.ClasspathElementFilter classpathElementFilter) {
        if (this.classpathElementFilters == null) {
            this.classpathElementFilters = new ArrayList(2);
        }
        this.classpathElementFilters.add(classpathElementFilter);
    }

    public void addClassLoader(ClassLoader classLoader) {
        if (this.addedClassLoaders == null) {
            this.addedClassLoaders = new ArrayList();
        }
        if (classLoader != null) {
            this.addedClassLoaders.add(classLoader);
        }
    }

    public void enableURLScheme(String scheme) {
        if (scheme == null || scheme.length() < 2) {
            throw new IllegalArgumentException("URL schemes must contain at least two characters");
        }
        if (this.allowedURLSchemes == null) {
            this.allowedURLSchemes = new HashSet();
        }
        this.allowedURLSchemes.add(scheme.toLowerCase());
    }

    public void overrideClassLoaders(ClassLoader... overrideClassLoaders) {
        if (overrideClassLoaders.length == 0) {
            throw new IllegalArgumentException("At least one override ClassLoader must be provided");
        }
        this.addedClassLoaders = null;
        this.overrideClassLoaders = new ArrayList();
        for (ClassLoader classLoader : overrideClassLoaders) {
            if (classLoader != null) {
                this.overrideClassLoaders.add(classLoader);
            }
        }
    }

    private static boolean isModuleLayer(Object moduleLayer) {
        if (moduleLayer == null) {
            throw new IllegalArgumentException("ModuleLayer references must not be null");
        }
        for (Class<?> currClass = moduleLayer.getClass(); currClass != null; currClass = currClass.getSuperclass()) {
            if (currClass.getName().equals("java.lang.ModuleLayer")) {
                return true;
            }
        }
        return false;
    }

    public void addModuleLayer(Object moduleLayer) {
        if (!isModuleLayer(moduleLayer)) {
            throw new IllegalArgumentException("moduleLayer must be of type java.lang.ModuleLayer");
        }
        if (this.addedModuleLayers == null) {
            this.addedModuleLayers = new ArrayList();
        }
        this.addedModuleLayers.add(moduleLayer);
    }

    public void overrideModuleLayers(Object... overrideModuleLayers) {
        if (overrideModuleLayers == null) {
            throw new IllegalArgumentException("overrideModuleLayers cannot be null");
        } else if (overrideModuleLayers.length == 0) {
            throw new IllegalArgumentException("At least one override ModuleLayer must be provided");
        } else {
            for (Object moduleLayer : overrideModuleLayers) {
                if (!isModuleLayer(moduleLayer)) {
                    throw new IllegalArgumentException("moduleLayer must be of type java.lang.ModuleLayer");
                }
            }
            this.addedModuleLayers = null;
            this.overrideModuleLayers = new ArrayList();
            Collections.addAll(this.overrideModuleLayers, overrideModuleLayers);
        }
    }

    public ScanSpecPathMatch dirWhitelistMatchStatus(String relativePath) {
        if (this.pathWhiteBlackList.isBlacklisted(relativePath)) {
            return ScanSpecPathMatch.HAS_BLACKLISTED_PATH_PREFIX;
        }
        if (this.pathPrefixWhiteBlackList.isBlacklisted(relativePath)) {
            return ScanSpecPathMatch.HAS_BLACKLISTED_PATH_PREFIX;
        }
        if (this.pathWhiteBlackList.whitelistIsEmpty() && this.classPackagePathWhiteBlackList.whitelistIsEmpty()) {
            return (relativePath.isEmpty() || relativePath.equals("/")) ? ScanSpecPathMatch.AT_WHITELISTED_PATH : ScanSpecPathMatch.HAS_WHITELISTED_PATH_PREFIX;
        }
        if (this.pathWhiteBlackList.isSpecificallyWhitelistedAndNotBlacklisted(relativePath)) {
            return ScanSpecPathMatch.AT_WHITELISTED_PATH;
        }
        if (this.classPackagePathWhiteBlackList.isSpecificallyWhitelistedAndNotBlacklisted(relativePath)) {
            return ScanSpecPathMatch.AT_WHITELISTED_CLASS_PACKAGE;
        }
        if (this.pathPrefixWhiteBlackList.isSpecificallyWhitelisted(relativePath)) {
            return ScanSpecPathMatch.HAS_WHITELISTED_PATH_PREFIX;
        }
        if (relativePath.equals("/")) {
            return ScanSpecPathMatch.ANCESTOR_OF_WHITELISTED_PATH;
        }
        if (this.pathWhiteBlackList.whitelistHasPrefix(relativePath)) {
            return ScanSpecPathMatch.ANCESTOR_OF_WHITELISTED_PATH;
        }
        if (this.classfilePathWhiteBlackList.whitelistHasPrefix(relativePath)) {
            return ScanSpecPathMatch.ANCESTOR_OF_WHITELISTED_PATH;
        }
        return ScanSpecPathMatch.NOT_WITHIN_WHITELISTED_PATH;
    }

    public boolean classfileIsSpecificallyWhitelisted(String relativePath) {
        return this.classfilePathWhiteBlackList.isSpecificallyWhitelistedAndNotBlacklisted(relativePath);
    }

    public boolean classOrPackageIsBlacklisted(String className) {
        return this.classWhiteBlackList.isBlacklisted(className) || this.packagePrefixWhiteBlackList.isBlacklisted(className);
    }

    public void log(LogNode log) {
        if (log != null) {
            LogNode scanSpecLog = log.log("ScanSpec:");
            Field[] declaredFields = ScanSpec.class.getDeclaredFields();
            for (Field field : declaredFields) {
                try {
                    scanSpecLog.log(field.getName() + ": " + field.get(this));
                } catch (ReflectiveOperationException e) {
                }
            }
        }
    }
}
