package org.eclipse.jetty.client;

import org.eclipse.jetty.client.api.Request;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpRequestException.class */
public class HttpRequestException extends RuntimeException {
    private final Request request;

    public HttpRequestException(String message, Request request) {
        super(message);
        this.request = request;
    }

    public Request getRequest() {
        return this.request;
    }
}
