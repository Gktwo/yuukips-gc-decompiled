package org.eclipse.jetty.client.api;

import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/ContentProvider.class */
public interface ContentProvider extends Iterable<ByteBuffer> {

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/ContentProvider$Typed.class */
    public interface Typed extends ContentProvider {
        String getContentType();
    }

    long getLength();

    default boolean isReproducible() {
        return false;
    }
}
