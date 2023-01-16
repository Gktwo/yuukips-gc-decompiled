package p013io.github.classgraph;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import nonapi.p019io.github.classgraph.utils.CollectionUtils;
import nonapi.p019io.github.classgraph.utils.ReflectionUtils;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* renamed from: io.github.classgraph.ModuleRef */
/* loaded from: grasscutter.jar:io/github/classgraph/ModuleRef.class */
public class ModuleRef implements Comparable<ModuleRef> {
    private final String name;
    private final Object reference;
    private final Object layer;
    private final Object descriptor;
    private final List<String> packages;
    private final URI location;
    private String locationStr;
    private File locationFile;
    private String rawVersion;
    private final ClassLoader classLoader;

    public ModuleRef(Object moduleReference, Object moduleLayer) {
        Boolean isPresent;
        if (moduleReference == null) {
            throw new IllegalArgumentException("moduleReference cannot be null");
        } else if (moduleLayer == null) {
            throw new IllegalArgumentException("moduleLayer cannot be null");
        } else {
            this.reference = moduleReference;
            this.layer = moduleLayer;
            this.descriptor = ReflectionUtils.invokeMethod(moduleReference, "descriptor", true);
            if (this.descriptor == null) {
                throw new IllegalArgumentException("moduleReference.descriptor() should not return null");
            }
            this.name = (String) ReflectionUtils.invokeMethod(this.descriptor, "name", true);
            Set<String> modulePackages = (Set) ReflectionUtils.invokeMethod(this.descriptor, "packages", true);
            if (modulePackages == null) {
                throw new IllegalArgumentException("moduleReference.descriptor().packages() should not return null");
            }
            this.packages = new ArrayList(modulePackages);
            CollectionUtils.sortIfNotEmpty(this.packages);
            Object optionalRawVersion = ReflectionUtils.invokeMethod(this.descriptor, "rawVersion", true);
            if (!(optionalRawVersion == null || (isPresent = (Boolean) ReflectionUtils.invokeMethod(optionalRawVersion, "isPresent", true)) == null || !isPresent.booleanValue())) {
                this.rawVersion = (String) ReflectionUtils.invokeMethod(optionalRawVersion, BeanUtil.PREFIX_GETTER_GET, true);
            }
            Object moduleLocationOptional = ReflectionUtils.invokeMethod(moduleReference, "location", true);
            if (moduleLocationOptional == null) {
                throw new IllegalArgumentException("moduleReference.location() should not return null");
            }
            Object moduleLocationIsPresent = ReflectionUtils.invokeMethod(moduleLocationOptional, "isPresent", true);
            if (moduleLocationIsPresent == null) {
                throw new IllegalArgumentException("moduleReference.location().isPresent() should not return null");
            }
            if (((Boolean) moduleLocationIsPresent).booleanValue()) {
                this.location = (URI) ReflectionUtils.invokeMethod(moduleLocationOptional, BeanUtil.PREFIX_GETTER_GET, true);
                if (this.location == null) {
                    throw new IllegalArgumentException("moduleReference.location().get() should not return null");
                }
            } else {
                this.location = null;
            }
            this.classLoader = (ClassLoader) ReflectionUtils.invokeMethod(moduleLayer, "findLoader", String.class, this.name, true);
        }
    }

    public String getName() {
        return this.name;
    }

    public Object getReference() {
        return this.reference;
    }

    public Object getLayer() {
        return this.layer;
    }

    public Object getDescriptor() {
        return this.descriptor;
    }

    public List<String> getPackages() {
        return this.packages;
    }

    public URI getLocation() {
        return this.location;
    }

    public String getLocationStr() {
        if (this.locationStr == null && this.location != null) {
            this.locationStr = this.location.toString();
        }
        return this.locationStr;
    }

    public File getLocationFile() {
        if (this.locationFile == null && this.location != null && Action.FILE_ATTRIBUTE.equals(this.location.getScheme())) {
            this.locationFile = new File(this.location);
        }
        return this.locationFile;
    }

    public String getRawVersion() {
        return this.rawVersion;
    }

    public boolean isSystemModule() {
        if (this.name == null || this.name.isEmpty()) {
            return false;
        }
        return this.name.startsWith("java.") || this.name.startsWith("jdk.") || this.name.startsWith("javafx.") || this.name.startsWith("oracle.");
    }

    public ClassLoader getClassLoader() {
        return this.classLoader;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModuleRef)) {
            return false;
        }
        ModuleRef modRef = (ModuleRef) obj;
        return modRef.reference.equals(this.reference) && modRef.layer.equals(this.layer);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.reference.hashCode() * this.layer.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return this.reference.toString();
    }

    public int compareTo(ModuleRef o) {
        int diff = this.name.compareTo(o.name);
        return diff != 0 ? diff : hashCode() - o.hashCode();
    }

    public ModuleReaderProxy open() throws IOException {
        return new ModuleReaderProxy(this);
    }
}
