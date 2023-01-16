package org.eclipse.jetty.util;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.net.URI;
import java.util.Optional;
import java.util.function.Function;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ModuleLocation.class */
class ModuleLocation implements Function<Class<?>, URI> {
    private static final Logger LOG = Log.getLogger(ModuleLocation.class);
    private final Class<?> classModule;
    private final MethodHandle handleGetModule;
    private final MethodHandle handleGetLayer;
    private final MethodHandle handleConfiguration;
    private final MethodHandle handleGetName;
    private final MethodHandle handleOptionalResolvedModule;
    private final MethodHandle handleReference;
    private final MethodHandle handleLocation;

    public ModuleLocation() {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            this.classModule = loader.loadClass("java.lang.Module");
            this.handleGetModule = lookup.findVirtual(Class.class, "getModule", MethodType.methodType(this.classModule));
            Class<?> classLayer = loader.loadClass("java.lang.ModuleLayer");
            this.handleGetLayer = lookup.findVirtual(this.classModule, "getLayer", MethodType.methodType(classLayer));
            Class<?> classConfiguration = loader.loadClass("java.lang.module.Configuration");
            this.handleConfiguration = lookup.findVirtual(classLayer, "configuration", MethodType.methodType(classConfiguration));
            this.handleGetName = lookup.findVirtual(this.classModule, "getName", MethodType.methodType(String.class));
            this.handleOptionalResolvedModule = lookup.findVirtual(classConfiguration, "findModule", MethodType.methodType(classConfiguration.getMethod("findModule", String.class).getReturnType(), String.class));
            Class<?> classResolvedModule = loader.loadClass("java.lang.module.ResolvedModule");
            Class<?> classReference = loader.loadClass("java.lang.module.ModuleReference");
            this.handleReference = lookup.findVirtual(classResolvedModule, "reference", MethodType.methodType(classReference));
            this.handleLocation = lookup.findVirtual(classReference, "location", MethodType.methodType(classReference.getMethod("location", new Class[0]).getReturnType()));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException e) {
            throw new UnsupportedOperationException("Not supported on this runtime", e);
        }
    }

    public URI apply(Class<?> clazz) {
        Object layer;
        Object configuration;
        String moduleName;
        try {
            Object module = this.handleGetModule.invoke(clazz);
            if (module == null || (layer = this.handleGetLayer.invoke(module)) == null || (configuration = this.handleConfiguration.invoke(layer)) == null || (moduleName = this.handleGetName.invoke(module)) == null) {
                return null;
            }
            Optional<?> optionalResolvedModule = this.handleOptionalResolvedModule.invoke(configuration, moduleName);
            if (!optionalResolvedModule.isPresent()) {
                return null;
            }
            Optional<URI> location = this.handleLocation.invoke(this.handleReference.invoke(optionalResolvedModule.get()));
            if (location != null || location.isPresent()) {
                return location.get();
            }
            return null;
        } catch (Throwable ignored) {
            if (!LOG.isDebugEnabled()) {
                return null;
            }
            LOG.ignore(ignored);
            return null;
        }
    }
}
