package org.eclipse.jetty.client.util;

import org.eclipse.jetty.client.api.ContentProvider;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/AbstractTypedContentProvider.class */
public abstract class AbstractTypedContentProvider implements ContentProvider.Typed {
    private final String contentType;

    /* access modifiers changed from: protected */
    public AbstractTypedContentProvider(String contentType) {
        this.contentType = contentType;
    }

    @Override // org.eclipse.jetty.client.api.ContentProvider.Typed
    public String getContentType() {
        return this.contentType;
    }
}
