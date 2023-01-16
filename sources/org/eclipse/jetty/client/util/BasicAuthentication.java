package org.eclipse.jetty.client.util;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.eclipse.jetty.client.api.Authentication;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.util.Attributes;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/BasicAuthentication.class */
public class BasicAuthentication extends AbstractAuthentication {
    private final String user;
    private final String password;

    public BasicAuthentication(URI uri, String realm, String user, String password) {
        super(uri, realm);
        this.user = user;
        this.password = password;
    }

    @Override // org.eclipse.jetty.client.util.AbstractAuthentication
    public String getType() {
        return "Basic";
    }

    @Override // org.eclipse.jetty.client.api.Authentication
    public Authentication.Result authenticate(Request request, ContentResponse response, Authentication.HeaderInfo headerInfo, Attributes context) {
        String charsetParam = headerInfo.getParameter("charset");
        return new BasicResult(getURI(), headerInfo.getHeader(), this.user, this.password, charsetParam == null ? null : Charset.forName(charsetParam));
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/BasicAuthentication$BasicResult.class */
    public static class BasicResult implements Authentication.Result {
        private final URI uri;
        private final HttpHeader header;
        private final String value;

        public BasicResult(URI uri, String user, String password) {
            this(uri, HttpHeader.AUTHORIZATION, user, password);
        }

        public BasicResult(URI uri, HttpHeader header, String user, String password) {
            this(uri, header, user, password, StandardCharsets.ISO_8859_1);
        }

        public BasicResult(URI uri, HttpHeader header, String user, String password, Charset charset) {
            this.uri = uri;
            this.header = header;
            this.value = "Basic " + Base64.getEncoder().encodeToString((user + EmitterKt.COMMENT_PREFIX + password).getBytes(charset == null ? StandardCharsets.ISO_8859_1 : charset));
        }

        @Override // org.eclipse.jetty.client.api.Authentication.Result
        public URI getURI() {
            return this.uri;
        }

        @Override // org.eclipse.jetty.client.api.Authentication.Result
        public void apply(Request request) {
            if (!request.getHeaders().contains(this.header, this.value)) {
                request.header(this.header, this.value);
            }
        }

        public String toString() {
            return String.format("Basic authentication result for %s", getURI());
        }
    }
}
