package org.eclipse.jetty.servlet;

import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/Source.class */
public class Source {
    public static final Source EMBEDDED = new Source(Origin.EMBEDDED, null);
    public static final Source JAVAX_API = new Source(Origin.JAVAX_API, null);
    public Origin _origin;
    public String _resource;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/Source$Origin.class */
    public enum Origin {
        EMBEDDED,
        JAVAX_API,
        DESCRIPTOR,
        ANNOTATION
    }

    public Source(Origin o, String resource) {
        if (o == null) {
            throw new IllegalArgumentException("Origin is null");
        }
        this._origin = o;
        this._resource = resource;
    }

    public Origin getOrigin() {
        return this._origin;
    }

    public String getResource() {
        return this._resource;
    }

    public String toString() {
        return this._origin + EmitterKt.COMMENT_PREFIX + this._resource;
    }
}
