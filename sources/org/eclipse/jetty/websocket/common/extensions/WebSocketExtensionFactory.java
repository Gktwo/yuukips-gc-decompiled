package org.eclipse.jetty.websocket.common.extensions;

import java.io.IOException;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.compression.DeflaterPool;
import org.eclipse.jetty.util.compression.InflaterPool;
import org.eclipse.jetty.websocket.api.WebSocketException;
import org.eclipse.jetty.websocket.api.extensions.Extension;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;
import org.eclipse.jetty.websocket.api.extensions.ExtensionFactory;
import org.eclipse.jetty.websocket.common.extensions.compress.CompressExtension;
import org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/WebSocketExtensionFactory.class */
public class WebSocketExtensionFactory extends ExtensionFactory implements LifeCycle, Dumpable {
    private final ContainerLifeCycle containerLifeCycle;
    private final WebSocketContainerScope container;
    private final InflaterPool inflaterPool;
    private final DeflaterPool deflaterPool;

    public WebSocketExtensionFactory(WebSocketContainerScope container) {
        this(container, null, null);
    }

    public WebSocketExtensionFactory(WebSocketContainerScope container, InflaterPool inflaterPool, DeflaterPool deflaterPool) {
        this.container = container;
        this.containerLifeCycle = new ContainerLifeCycle() { // from class: org.eclipse.jetty.websocket.common.extensions.WebSocketExtensionFactory.1
            @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
            public String toString() {
                return String.format("%s@%x{%s}", WebSocketExtensionFactory.class.getSimpleName(), Integer.valueOf(hashCode()), WebSocketExtensionFactory.this.containerLifeCycle.getState());
            }
        };
        this.inflaterPool = inflaterPool != null ? inflaterPool : new InflaterPool(-1, true);
        this.containerLifeCycle.addBean(this.inflaterPool);
        this.deflaterPool = deflaterPool != null ? deflaterPool : new DeflaterPool(-1, -1, true);
        this.containerLifeCycle.addBean(this.deflaterPool);
    }

    public void unmanage(Object object) {
        this.containerLifeCycle.unmanage(object);
    }

    public InflaterPool getInflaterPool() {
        return this.inflaterPool;
    }

    public DeflaterPool getDeflaterPool() {
        return this.deflaterPool;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.ExtensionFactory
    public Extension newInstance(ExtensionConfig config) {
        Class<? extends Extension> extClass;
        if (config == null) {
            return null;
        }
        String name = config.getName();
        if (StringUtil.isBlank(name) || (extClass = getExtension(name)) == null) {
            return null;
        }
        try {
            Extension ext = (Extension) this.container.getObjectFactory().createInstance(extClass);
            if (ext instanceof AbstractExtension) {
                AbstractExtension aext = (AbstractExtension) ext;
                aext.init(this.container);
                aext.setConfig(config);
            }
            if (ext instanceof CompressExtension) {
                CompressExtension cext = (CompressExtension) ext;
                cext.setInflaterPool(this.inflaterPool);
                cext.setDeflaterPool(this.deflaterPool);
            }
            return ext;
        } catch (Exception e) {
            throw new WebSocketException("Cannot instantiate extension: " + extClass, e);
        }
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public void start() throws Exception {
        this.containerLifeCycle.start();
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public void stop() throws Exception {
        this.containerLifeCycle.stop();
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public boolean isRunning() {
        return this.containerLifeCycle.isRunning();
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public boolean isStarted() {
        return this.containerLifeCycle.isStarted();
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public boolean isStarting() {
        return this.containerLifeCycle.isStarting();
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public boolean isStopping() {
        return this.containerLifeCycle.isStopping();
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public boolean isStopped() {
        return this.containerLifeCycle.isStopped();
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public boolean isFailed() {
        return this.containerLifeCycle.isFailed();
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public void addLifeCycleListener(LifeCycle.Listener listener) {
        this.containerLifeCycle.addLifeCycleListener(listener);
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle
    public void removeLifeCycleListener(LifeCycle.Listener listener) {
        this.containerLifeCycle.removeLifeCycleListener(listener);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return this.containerLifeCycle.dump();
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dumpSelf() {
        return this.containerLifeCycle.dumpSelf();
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        this.containerLifeCycle.dump(out, indent);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.containerLifeCycle.toString();
    }
}
