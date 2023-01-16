package org.eclipse.jetty.client.http;

import org.eclipse.jetty.client.HttpResponse;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/http/HttpConnectionUpgrader.class */
public interface HttpConnectionUpgrader {
    void upgrade(HttpResponse httpResponse, HttpConnectionOverHTTP httpConnectionOverHTTP);
}
