package org.eclipse.jetty.websocket.api.extensions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/extensions/ExtensionFactory.class */
public abstract class ExtensionFactory implements Iterable<Class<? extends Extension>> {
    private final Map<String, Class<? extends Extension>> availableExtensions = new HashMap();

    public abstract Extension newInstance(ExtensionConfig extensionConfig);

    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: java.util.Map<java.lang.String, java.lang.Class<? extends org.eclipse.jetty.websocket.api.extensions.Extension>> */
    /* JADX WARN: Multi-variable type inference failed */
    public ExtensionFactory() {
        Iterator<Extension> iterator = ServiceLoader.load(Extension.class).iterator();
        while (iterator.hasNext()) {
            try {
                Extension ext = iterator.next();
                if (ext != null) {
                    this.availableExtensions.put(ext.getName(), ext.getClass());
                }
            } catch (Throwable th) {
            }
        }
    }

    public Map<String, Class<? extends Extension>> getAvailableExtensions() {
        return this.availableExtensions;
    }

    public Class<? extends Extension> getExtension(String name) {
        return this.availableExtensions.get(name);
    }

    public Set<String> getExtensionNames() {
        return this.availableExtensions.keySet();
    }

    public boolean isAvailable(String name) {
        return this.availableExtensions.containsKey(name);
    }

    @Override // java.lang.Iterable
    public Iterator<Class<? extends Extension>> iterator() {
        return this.availableExtensions.values().iterator();
    }

    public void register(String name, Class<? extends Extension> extension) {
        this.availableExtensions.put(name, extension);
    }

    public void unregister(String name) {
        this.availableExtensions.remove(name);
    }
}
