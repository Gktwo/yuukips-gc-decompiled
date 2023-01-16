package org.eclipse.jetty.client.api;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/ContentResponse.class */
public interface ContentResponse extends Response {
    String getMediaType();

    String getEncoding();

    byte[] getContent();

    String getContentAsString();
}
