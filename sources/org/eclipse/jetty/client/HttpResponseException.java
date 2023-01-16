package org.eclipse.jetty.client;

import org.eclipse.jetty.client.api.Response;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpResponseException.class */
public class HttpResponseException extends RuntimeException {
    private final Response response;

    public HttpResponseException(String message, Response response) {
        this(message, response, null);
    }

    public HttpResponseException(String message, Response response, Throwable cause) {
        super(message, cause);
        this.response = response;
    }

    public Response getResponse() {
        return this.response;
    }
}
