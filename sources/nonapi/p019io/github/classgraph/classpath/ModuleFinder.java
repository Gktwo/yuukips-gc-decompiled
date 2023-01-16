package nonapi.p019io.github.classgraph.classpath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.CollectionUtils;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.ReflectionUtils;
import p013io.github.classgraph.ModuleRef;

/* renamed from: nonapi.io.github.classgraph.classpath.ModuleFinder */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classpath/ModuleFinder.class */
public class ModuleFinder {
    private List<ModuleRef> systemModuleRefs;
    private List<ModuleRef> nonSystemModuleRefs;
    private boolean forceScanJavaClassPath;

    public List<ModuleRef> getSystemModuleRefs() {
        return this.systemModuleRefs;
    }

    public List<ModuleRef> getNonSystemModuleRefs() {
        return this.nonSystemModuleRefs;
    }

    public boolean forceScanJavaClassPath() {
        return this.forceScanJavaClassPath;
    }

    private static void findLayerOrder(Object layer, Set<Object> layerVisited, Set<Object> parentLayers, Deque<Object> layerOrderOut) {
        if (layerVisited.add(layer)) {
            List<Object> parents = (List) ReflectionUtils.invokeMethod(layer, "parents", true);
            if (parents != null) {
                parentLayers.addAll(parents);
                for (Object parent : parents) {
                    findLayerOrder(parent, layerVisited, parentLayers, layerOrderOut);
                }
            }
            layerOrderOut.push(layer);
        }
    }

    private static List<ModuleRef> findModuleRefs(LinkedHashSet<Object> layers, ScanSpec scanSpec, LogNode log) {
        List<Object> layerOrderFinal;
        Set<Object> modules;
        if (layers.isEmpty()) {
            return Collections.emptyList();
        }
        Deque<Object> layerOrder = new ArrayDeque<>();
        Set<Object> parentLayers = new HashSet<>();
        Iterator<Object> it = layers.iterator();
        while (it.hasNext()) {
            Object layer = it.next();
            if (layer != null) {
                findLayerOrder(layer, new HashSet(), parentLayers, layerOrder);
            }
        }
        if (scanSpec.addedModuleLayers != null) {
            for (Object layer2 : scanSpec.addedModuleLayers) {
                if (layer2 != null) {
                    findLayerOrder(layer2, new HashSet(), parentLayers, layerOrder);
                }
            }
        }
        if (scanSpec.ignoreParentModuleLayers) {
            layerOrderFinal = new ArrayList<>();
            for (Object layer3 : layerOrder) {
                if (!parentLayers.contains(layer3)) {
                    layerOrderFinal.add(layer3);
                }
            }
        } else {
            layerOrderFinal = new ArrayList<>(layerOrder);
        }
        Set<Object> addedModules = new HashSet<>();
        LinkedHashSet<ModuleRef> moduleRefOrder = new LinkedHashSet<>();
        for (Object layer4 : layerOrderFinal) {
            Object configuration = ReflectionUtils.invokeMethod(layer4, "configuration", true);
            if (!(configuration == null || (modules = (Set) ReflectionUtils.invokeMethod(configuration, "modules", true)) == null)) {
                List<ModuleRef> modulesInLayer = new ArrayList<>();
                for (Object module : modules) {
                    Object moduleReference = ReflectionUtils.invokeMethod(module, "reference", true);
                    if (moduleReference != null && addedModules.add(moduleReference)) {
                        try {
                            modulesInLayer.add(new ModuleRef(moduleReference, layer4));
                        } catch (IllegalArgumentException e) {
                            if (log != null) {
                                log.log("Exception while creating ModuleRef for module " + moduleReference, e);
                            }
                        }
                    }
                }
                CollectionUtils.sortIfNotEmpty(modulesInLayer);
                moduleRefOrder.addAll(modulesInLayer);
            }
        }
        return new ArrayList(moduleRefOrder);
    }

    private List<ModuleRef> findModuleRefsFromCallstack(Class<?>[] callStack, ScanSpec scanSpec, LogNode log) {
        LinkedHashSet<Object> layers = new LinkedHashSet<>();
        if (callStack != null) {
            for (Class<?> stackFrameClass : callStack) {
                Object module = ReflectionUtils.invokeMethod(stackFrameClass, "getModule", false);
                if (module != null) {
                    Object layer = ReflectionUtils.invokeMethod(module, "getLayer", true);
                    if (layer != null) {
                        layers.add(layer);
                    } else {
                        this.forceScanJavaClassPath = true;
                    }
                }
            }
        }
        Class<?> moduleLayerClass = null;
        try {
            moduleLayerClass = Class.forName("java.lang.ModuleLayer");
        } catch (ClassNotFoundException | LinkageError e) {
        }
        if (moduleLayerClass != null) {
            Object bootLayer = ReflectionUtils.invokeStaticMethod(moduleLayerClass, "boot", false);
            if (bootLayer != null) {
                layers.add(bootLayer);
            } else {
                this.forceScanJavaClassPath = true;
            }
        }
        return findModuleRefs(layers, scanSpec, log);
    }

    public ModuleFinder(Class<?>[] callStack, ScanSpec scanSpec, LogNode log) {
        if (scanSpec.scanModules) {
            List<ModuleRef> allModuleRefsList = null;
            if (scanSpec.overrideModuleLayers != null) {
                if (log != null) {
                    LogNode subLog = log.log("Overriding module layers");
                    for (Object moduleLayer : scanSpec.overrideModuleLayers) {
                        subLog.log(moduleLayer.toString());
                    }
                }
                allModuleRefsList = findModuleRefs(new LinkedHashSet(scanSpec.overrideModuleLayers), scanSpec, log);
            } else if (callStack != null && callStack.length > 0) {
                allModuleRefsList = findModuleRefsFromCallstack(callStack, scanSpec, log);
            }
            if (allModuleRefsList != null) {
                this.systemModuleRefs = new ArrayList();
                this.nonSystemModuleRefs = new ArrayList();
                for (ModuleRef moduleRef : allModuleRefsList) {
                    if (moduleRef != null) {
                        if (moduleRef.isSystemModule()) {
                            this.systemModuleRefs.add(moduleRef);
                        } else {
                            this.nonSystemModuleRefs.add(moduleRef);
                        }
                    }
                }
            }
            if (log != null) {
                LogNode sysSubLog = log.log("Found system modules:");
                if (this.systemModuleRefs == null || this.systemModuleRefs.isEmpty()) {
                    sysSubLog.log("[None]");
                } else {
                    for (ModuleRef moduleRef2 : this.systemModuleRefs) {
                        sysSubLog.log(moduleRef2.toString());
                    }
                }
                LogNode nonSysSubLog = log.log("Found non-system modules:");
                if (this.nonSystemModuleRefs == null || this.nonSystemModuleRefs.isEmpty()) {
                    nonSysSubLog.log("[None]");
                    return;
                }
                for (ModuleRef moduleRef3 : this.nonSystemModuleRefs) {
                    nonSysSubLog.log(moduleRef3.toString());
                }
            }
        } else if (log != null) {
            log.log("Module scanning is disabled, because classloaders or classpath was overridden");
        }
    }
}
