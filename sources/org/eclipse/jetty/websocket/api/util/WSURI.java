package org.eclipse.jetty.websocket.api.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import org.eclipse.jetty.util.URIUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/util/WSURI.class */
public final class WSURI {
    public static URI toHttp(URI inputUri) throws URISyntaxException {
        Objects.requireNonNull(inputUri, "Input URI must not be null");
        String wsScheme = inputUri.getScheme();
        if (URIUtil.HTTP.equalsIgnoreCase(wsScheme) || URIUtil.HTTPS.equalsIgnoreCase(wsScheme)) {
            return inputUri;
        }
        if ("ws".equalsIgnoreCase(wsScheme)) {
            return new URI(URIUtil.HTTP + inputUri.toString().substring(wsScheme.length()));
        }
        if ("wss".equalsIgnoreCase(wsScheme)) {
            return new URI(URIUtil.HTTPS + inputUri.toString().substring(wsScheme.length()));
        }
        throw new URISyntaxException(inputUri.toString(), "Unrecognized WebSocket scheme");
    }

    public static URI toWebsocket(CharSequence inputUrl) throws URISyntaxException {
        return toWebsocket(new URI(inputUrl.toString()));
    }

    public static URI toWebsocket(CharSequence inputUrl, String query) throws URISyntaxException {
        if (query == null) {
            return toWebsocket(new URI(inputUrl.toString()));
        }
        return toWebsocket(new URI(inputUrl.toString() + '?' + query));
    }

    public static URI toWebsocket(URI inputUri) throws URISyntaxException {
        Objects.requireNonNull(inputUri, "Input URI must not be null");
        String httpScheme = inputUri.getScheme();
        if ("ws".equalsIgnoreCase(httpScheme) || "wss".equalsIgnoreCase(httpScheme)) {
            return inputUri;
        }
        if (URIUtil.HTTP.equalsIgnoreCase(httpScheme)) {
            return new URI("ws" + inputUri.toString().substring(httpScheme.length()));
        }
        if (URIUtil.HTTPS.equalsIgnoreCase(httpScheme)) {
            return new URI("wss" + inputUri.toString().substring(httpScheme.length()));
        }
        throw new URISyntaxException(inputUri.toString(), "Unrecognized HTTP scheme");
    }
}
