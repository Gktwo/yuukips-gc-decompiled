package org.eclipse.jetty.client;

import java.net.URI;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.http.HttpHeader;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/WWWAuthenticationProtocolHandler.class */
public class WWWAuthenticationProtocolHandler extends AuthenticationProtocolHandler {
    public static final String NAME = "www-authenticate";
    private static final String ATTRIBUTE = WWWAuthenticationProtocolHandler.class.getName() + ".attribute";

    public WWWAuthenticationProtocolHandler(HttpClient client) {
        this(client, 16384);
    }

    public WWWAuthenticationProtocolHandler(HttpClient client, int maxContentLength) {
        super(client, maxContentLength);
    }

    @Override // org.eclipse.jetty.client.ProtocolHandler
    public String getName() {
        return NAME;
    }

    @Override // org.eclipse.jetty.client.ProtocolHandler
    public boolean accept(Request request, Response response) {
        return response.getStatus() == 401;
    }

    @Override // org.eclipse.jetty.client.AuthenticationProtocolHandler
    protected HttpHeader getAuthenticateHeader() {
        return HttpHeader.WWW_AUTHENTICATE;
    }

    @Override // org.eclipse.jetty.client.AuthenticationProtocolHandler
    protected HttpHeader getAuthorizationHeader() {
        return HttpHeader.AUTHORIZATION;
    }

    @Override // org.eclipse.jetty.client.AuthenticationProtocolHandler
    protected URI getAuthenticationURI(Request request) {
        return request.getURI();
    }

    @Override // org.eclipse.jetty.client.AuthenticationProtocolHandler
    protected String getAuthenticationAttribute() {
        return ATTRIBUTE;
    }
}
