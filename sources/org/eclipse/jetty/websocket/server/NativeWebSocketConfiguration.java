package org.eclipse.jetty.websocket.server;

import java.util.Iterator;
import javax.servlet.ServletContext;
import org.eclipse.jetty.http.pathmap.MappedResource;
import org.eclipse.jetty.http.pathmap.MatchedResource;
import org.eclipse.jetty.http.pathmap.PathMappings;
import org.eclipse.jetty.http.pathmap.PathSpec;
import org.eclipse.jetty.http.pathmap.UriTemplatePathSpec;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.websocket.api.WebSocketException;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.server.pathmap.RegexPathSpec;
import org.eclipse.jetty.websocket.server.pathmap.ServletPathSpec;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/server/NativeWebSocketConfiguration.class */
public class NativeWebSocketConfiguration extends ContainerLifeCycle implements MappedWebSocketCreator {
    private final WebSocketServerFactory factory;
    private final PathMappings<WebSocketCreator> mappings;

    public NativeWebSocketConfiguration(ServletContext context) {
        this(new WebSocketServerFactory(context));
    }

    public NativeWebSocketConfiguration(WebSocketServerFactory webSocketServerFactory) {
        this.mappings = new PathMappings<>();
        this.factory = webSocketServerFactory;
        addBean(this.factory);
        addBean(this.mappings);
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this.mappings.removeIf(mapped -> {
            return !(mapped.getResource() instanceof PersistedWebSocketCreator);
        });
        doStop();
    }

    public WebSocketServerFactory getFactory() {
        return this.factory;
    }

    public MatchedResource<WebSocketCreator> getMatched(String target) {
        return this.mappings.getMatched(target);
    }

    @Deprecated
    public MappedResource<WebSocketCreator> getMatch(String target) {
        MatchedResource<WebSocketCreator> matched = this.mappings.getMatched(target);
        if (matched == null) {
            return null;
        }
        return new MappedResource<>(matched.getPathSpec(), matched.getResource());
    }

    public WebSocketPolicy getPolicy() {
        return this.factory.getPolicy();
    }

    @Override // org.eclipse.jetty.websocket.server.MappedWebSocketCreator
    public void addMapping(PathSpec pathSpec, WebSocketCreator creator) {
        WebSocketCreator wsCreator = creator;
        if (!isRunning()) {
            wsCreator = new PersistedWebSocketCreator(creator);
        }
        this.mappings.put(pathSpec, (PathSpec) wsCreator);
    }

    @Override // org.eclipse.jetty.websocket.server.MappedWebSocketCreator
    @Deprecated
    public void addMapping(org.eclipse.jetty.websocket.server.pathmap.PathSpec spec, WebSocketCreator creator) {
        if (spec instanceof ServletPathSpec) {
            addMapping(new org.eclipse.jetty.http.pathmap.ServletPathSpec(spec.getSpec()), creator);
        } else if (spec instanceof RegexPathSpec) {
            addMapping(new org.eclipse.jetty.http.pathmap.RegexPathSpec(spec.getSpec()), creator);
        } else {
            throw new RuntimeException("Unsupported (Deprecated) PathSpec implementation type: " + spec.getClass().getName());
        }
    }

    public void addMapping(PathSpec pathSpec, Class<?> endpointClass) {
        this.mappings.put(pathSpec, (PathSpec) req, resp -> {
            try {
                return endpointClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                throw new WebSocketException("Unable to create instance of " + endpointClass.getName(), e);
            }
        });
    }

    @Override // org.eclipse.jetty.websocket.server.MappedWebSocketCreator
    public void addMapping(String rawspec, WebSocketCreator creator) {
        addMapping(toPathSpec(rawspec), creator);
    }

    private PathSpec toPathSpec(String rawspec) {
        if (rawspec.charAt(0) == '/' || rawspec.startsWith("*.") || rawspec.startsWith("servlet|")) {
            return new org.eclipse.jetty.http.pathmap.ServletPathSpec(rawspec);
        }
        if (rawspec.charAt(0) == '^' || rawspec.startsWith("regex|")) {
            return new org.eclipse.jetty.http.pathmap.RegexPathSpec(rawspec);
        }
        if (rawspec.startsWith("uri-template|")) {
            return new UriTemplatePathSpec(rawspec.substring("uri-template|".length()));
        }
        throw new IllegalArgumentException("Unrecognized path spec syntax [" + rawspec + "]");
    }

    @Override // org.eclipse.jetty.websocket.server.MappedWebSocketCreator
    public WebSocketCreator getMapping(String rawspec) {
        PathSpec pathSpec = toPathSpec(rawspec);
        Iterator<MappedResource<WebSocketCreator>> it = this.mappings.iterator();
        while (it.hasNext()) {
            MappedResource<WebSocketCreator> mapping = it.next();
            if (mapping.getPathSpec().equals(pathSpec)) {
                return mapping.getResource();
            }
        }
        return null;
    }

    @Override // org.eclipse.jetty.websocket.server.MappedWebSocketCreator
    public boolean removeMapping(String rawspec) {
        PathSpec pathSpec = toPathSpec(rawspec);
        boolean removed = false;
        Iterator<MappedResource<WebSocketCreator>> iterator = this.mappings.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPathSpec().equals(pathSpec)) {
                iterator.remove();
                removed = true;
            }
        }
        return removed;
    }

    public void addMapping(String rawspec, Class<?> endpointClass) {
        addMapping(toPathSpec(rawspec), endpointClass);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/server/NativeWebSocketConfiguration$PersistedWebSocketCreator.class */
    public class PersistedWebSocketCreator implements WebSocketCreator {
        private final WebSocketCreator delegate;

        public PersistedWebSocketCreator(WebSocketCreator delegate) {
            this.delegate = delegate;
        }

        @Override // org.eclipse.jetty.websocket.servlet.WebSocketCreator
        public Object createWebSocket(ServletUpgradeRequest req, ServletUpgradeResponse resp) {
            return this.delegate.createWebSocket(req, resp);
        }

        public String toString() {
            return "Persisted[" + toString() + "]";
        }
    }
}
