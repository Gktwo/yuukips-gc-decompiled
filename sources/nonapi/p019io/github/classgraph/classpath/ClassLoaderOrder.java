package nonapi.p019io.github.classgraph.classpath;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nonapi.p019io.github.classgraph.classloaderhandler.ClassLoaderHandlerRegistry;
import nonapi.p019io.github.classgraph.utils.LogNode;

/* renamed from: nonapi.io.github.classgraph.classpath.ClassLoaderOrder */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classpath/ClassLoaderOrder.class */
public class ClassLoaderOrder {
    private final List<Map.Entry<ClassLoader, ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry>> classLoaderOrder = new ArrayList();
    private final Set<ClassLoader> added = new HashSet();
    private final Set<ClassLoader> delegatedTo = new HashSet();
    private final Set<ClassLoader> allParentClassLoaders = new HashSet();
    private final Map<ClassLoader, ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry> classLoaderToClassLoaderHandlerRegistryEntry = new HashMap();

    public List<Map.Entry<ClassLoader, ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry>> getClassLoaderOrder() {
        return this.classLoaderOrder;
    }

    public Set<ClassLoader> getAllParentClassLoaders() {
        return this.allParentClassLoaders;
    }

    private ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry getRegistryEntry(ClassLoader classLoader, LogNode log) {
        ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry entry = this.classLoaderToClassLoaderHandlerRegistryEntry.get(classLoader);
        if (entry == null) {
            Class<?> currClassLoaderClass = classLoader.getClass();
            while (currClassLoaderClass != Object.class && currClassLoaderClass != null) {
                Iterator<ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry> it = ClassLoaderHandlerRegistry.CLASS_LOADER_HANDLERS.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry ent = it.next();
                    if (ent.canHandle(currClassLoaderClass, log)) {
                        entry = ent;
                        break;
                    }
                }
                if (entry != null) {
                    break;
                }
                currClassLoaderClass = currClassLoaderClass.getSuperclass();
            }
            if (entry == null) {
                entry = ClassLoaderHandlerRegistry.FALLBACK_HANDLER;
            }
            this.classLoaderToClassLoaderHandlerRegistryEntry.put(classLoader, entry);
        }
        return entry;
    }

    public void add(ClassLoader classLoader, LogNode log) {
        ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry entry;
        if (classLoader != null && this.added.add(classLoader) && (entry = getRegistryEntry(classLoader, log)) != null) {
            this.classLoaderOrder.add(new AbstractMap.SimpleEntry(classLoader, entry));
        }
    }

    public void delegateTo(ClassLoader classLoader, boolean isParent, LogNode log) {
        if (classLoader != null) {
            if (isParent) {
                this.allParentClassLoaders.add(classLoader);
            }
            if (this.delegatedTo.add(classLoader)) {
                getRegistryEntry(classLoader, log).findClassLoaderOrder(classLoader, this, log);
            }
        }
    }
}
