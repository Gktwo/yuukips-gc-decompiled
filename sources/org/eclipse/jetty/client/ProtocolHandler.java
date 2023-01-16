package org.eclipse.jetty.client;

import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProtocolHandler.class */
public interface ProtocolHandler {
    String getName();

    boolean accept(Request request, Response response);

    Response.Listener getResponseListener();
}
