package org.eclipse.jetty.client;

import java.net.URI;
import org.eclipse.jetty.client.ProxyConfiguration;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.http.HttpHeader;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProxyAuthenticationProtocolHandler.class */
public class ProxyAuthenticationProtocolHandler extends AuthenticationProtocolHandler {
    public static final String NAME = "proxy-authenticate";
    private static final String ATTRIBUTE = ProxyAuthenticationProtocolHandler.class.getName() + ".attribute";

    public ProxyAuthenticationProtocolHandler(HttpClient client) {
        this(client, 16384);
    }

    public ProxyAuthenticationProtocolHandler(HttpClient client, int maxContentLength) {
        super(client, maxContentLength);
    }

    @Override // org.eclipse.jetty.client.ProtocolHandler
    public String getName() {
        return NAME;
    }

    @Override // org.eclipse.jetty.client.ProtocolHandler
    public boolean accept(Request request, Response response) {
        return response.getStatus() == 407;
    }

    @Override // org.eclipse.jetty.client.AuthenticationProtocolHandler
    protected HttpHeader getAuthenticateHeader() {
        return HttpHeader.PROXY_AUTHENTICATE;
    }

    @Override // org.eclipse.jetty.client.AuthenticationProtocolHandler
    protected HttpHeader getAuthorizationHeader() {
        return HttpHeader.PROXY_AUTHORIZATION;
    }

    @Override // org.eclipse.jetty.client.AuthenticationProtocolHandler
    protected URI getAuthenticationURI(Request request) {
        ProxyConfiguration.Proxy proxy = getHttpClient().destinationFor(request.getScheme(), request.getHost(), request.getPort()).getProxy();
        return proxy != null ? proxy.getURI() : request.getURI();
    }

    @Override // org.eclipse.jetty.client.AuthenticationProtocolHandler
    protected String getAuthenticationAttribute() {
        return ATTRIBUTE;
    }
}
