package org.eclipse.jetty.client;

import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpHeader;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/RedirectProtocolHandler.class */
public class RedirectProtocolHandler extends Response.Listener.Adapter implements ProtocolHandler {
    public static final String NAME = "redirect";
    private final HttpRedirector redirector;

    public RedirectProtocolHandler(HttpClient client) {
        this.redirector = new HttpRedirector(client);
    }

    @Override // org.eclipse.jetty.client.ProtocolHandler
    public String getName() {
        return NAME;
    }

    @Override // org.eclipse.jetty.client.ProtocolHandler
    public boolean accept(Request request, Response response) {
        return this.redirector.isRedirect(response) && request.isFollowRedirects();
    }

    @Override // org.eclipse.jetty.client.ProtocolHandler
    public Response.Listener getResponseListener() {
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Response.Listener, org.eclipse.jetty.client.api.Response.HeaderListener
    public boolean onHeader(Response response, HttpField field) {
        return field.getHeader() != HttpHeader.CONTENT_ENCODING;
    }

    @Override // org.eclipse.jetty.client.api.Response.Listener, org.eclipse.jetty.client.api.Response.CompleteListener
    public void onComplete(Result result) {
        Request request = result.getRequest();
        Response response = result.getResponse();
        if (result.isSucceeded()) {
            this.redirector.redirect(request, response, null);
        } else {
            this.redirector.fail(request, response, result.getFailure());
        }
    }
}
