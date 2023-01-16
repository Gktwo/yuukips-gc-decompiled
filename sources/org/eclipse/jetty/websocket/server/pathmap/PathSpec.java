package org.eclipse.jetty.websocket.server.pathmap;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/server/pathmap/PathSpec.class */
public abstract class PathSpec {
    private final String spec;

    /* access modifiers changed from: protected */
    public PathSpec(String spec) {
        this.spec = spec;
    }

    public String getSpec() {
        return this.spec;
    }
}
