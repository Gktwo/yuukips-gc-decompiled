package org.eclipse.jetty.client.util;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.jetty.client.api.Authentication;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.util.Attributes;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.TypeUtil;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/DigestAuthentication.class */
public class DigestAuthentication extends AbstractAuthentication {
    private final Random random;
    private final String user;
    private final String password;

    public DigestAuthentication(URI uri, String realm, String user, String password) {
        this(uri, realm, user, password, new SecureRandom());
    }

    public DigestAuthentication(URI uri, String realm, String user, String password, Random random) {
        super(uri, realm);
        Objects.requireNonNull(random);
        this.random = random;
        this.user = user;
        this.password = password;
    }

    @Override // org.eclipse.jetty.client.util.AbstractAuthentication
    public String getType() {
        return "Digest";
    }

    @Override // org.eclipse.jetty.client.util.AbstractAuthentication, org.eclipse.jetty.client.api.Authentication
    public boolean matches(String type, URI uri, String realm) {
        if (realm == null) {
            return false;
        }
        return matches(type, uri, realm);
    }

    @Override // org.eclipse.jetty.client.api.Authentication
    public Authentication.Result authenticate(Request request, ContentResponse response, Authentication.HeaderInfo headerInfo, Attributes context) {
        Map<String, String> params = headerInfo.getParameters();
        String nonce = params.get("nonce");
        if (nonce == null || nonce.length() == 0) {
            return null;
        }
        String opaque = params.get("opaque");
        String algorithm = params.get("algorithm");
        if (algorithm == null) {
            algorithm = "MD5";
        }
        if (getMessageDigest(algorithm) == null) {
            return null;
        }
        String serverQOP = params.get("qop");
        String clientQOP = null;
        if (serverQOP != null) {
            List<String> serverQOPValues = StringUtil.csvSplit(null, serverQOP, 0, serverQOP.length());
            if (serverQOPValues.contains("auth")) {
                clientQOP = "auth";
            } else if (serverQOPValues.contains("auth-int")) {
                clientQOP = "auth-int";
            }
        }
        String realm = getRealm();
        if (Authentication.ANY_REALM.equals(realm)) {
            realm = headerInfo.getRealm();
        }
        return new DigestResult(headerInfo.getHeader(), response.getContent(), realm, this.user, this.password, algorithm, nonce, clientQOP, opaque);
    }

    /* access modifiers changed from: private */
    public MessageDigest getMessageDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/DigestAuthentication$DigestResult.class */
    private class DigestResult implements Authentication.Result {
        private final AtomicInteger nonceCount = new AtomicInteger();
        private final HttpHeader header;
        private final byte[] content;
        private final String realm;
        private final String user;
        private final String password;
        private final String algorithm;
        private final String nonce;
        private final String qop;
        private final String opaque;

        public DigestResult(HttpHeader header, byte[] content, String realm, String user, String password, String algorithm, String nonce, String qop, String opaque) {
            this.header = header;
            this.content = content;
            this.realm = realm;
            this.user = user;
            this.password = password;
            this.algorithm = algorithm;
            this.nonce = nonce;
            this.qop = qop;
            this.opaque = opaque;
        }

        @Override // org.eclipse.jetty.client.api.Authentication.Result
        public URI getURI() {
            return DigestAuthentication.this.getURI();
        }

        @Override // org.eclipse.jetty.client.api.Authentication.Result
        public void apply(Request request) {
            String a3;
            String clientNonce;
            String nonceCount;
            MessageDigest digester = DigestAuthentication.this.getMessageDigest(this.algorithm);
            if (digester != null) {
                String hashA1 = toHexString(digester.digest((this.user + EmitterKt.COMMENT_PREFIX + this.realm + EmitterKt.COMMENT_PREFIX + this.password).getBytes(StandardCharsets.ISO_8859_1)));
                String query = request.getQuery();
                String path = request.getPath();
                String uri = query == null ? path : path + "?" + query;
                String a2 = request.getMethod() + EmitterKt.COMMENT_PREFIX + uri;
                if ("auth-int".equals(this.qop)) {
                    a2 = a2 + EmitterKt.COMMENT_PREFIX + toHexString(digester.digest(this.content));
                }
                String hashA2 = toHexString(digester.digest(a2.getBytes(StandardCharsets.ISO_8859_1)));
                if (this.qop != null) {
                    nonceCount = nextNonceCount();
                    clientNonce = newClientNonce();
                    a3 = hashA1 + EmitterKt.COMMENT_PREFIX + this.nonce + EmitterKt.COMMENT_PREFIX + nonceCount + EmitterKt.COMMENT_PREFIX + clientNonce + EmitterKt.COMMENT_PREFIX + this.qop + EmitterKt.COMMENT_PREFIX + hashA2;
                } else {
                    nonceCount = null;
                    clientNonce = null;
                    a3 = hashA1 + EmitterKt.COMMENT_PREFIX + this.nonce + EmitterKt.COMMENT_PREFIX + hashA2;
                }
                String hashA3 = toHexString(digester.digest(a3.getBytes(StandardCharsets.ISO_8859_1)));
                StringBuilder value = new StringBuilder("Digest");
                value.append(" username=\"").append(this.user).append("\"");
                value.append(", realm=\"").append(this.realm).append("\"");
                value.append(", nonce=\"").append(this.nonce).append("\"");
                if (this.opaque != null) {
                    value.append(", opaque=\"").append(this.opaque).append("\"");
                }
                value.append(", algorithm=\"").append(this.algorithm).append("\"");
                value.append(", uri=\"").append(uri).append("\"");
                if (this.qop != null) {
                    value.append(", qop=\"").append(this.qop).append("\"");
                    value.append(", nc=\"").append(nonceCount).append("\"");
                    value.append(", cnonce=\"").append(clientNonce).append("\"");
                }
                value.append(", response=\"").append(hashA3).append("\"");
                request.header(this.header, value.toString());
            }
        }

        private String nextNonceCount() {
            String next = Integer.toHexString(this.nonceCount.incrementAndGet()).toLowerCase(Locale.ENGLISH);
            return "00000000".substring(0, "00000000".length() - next.length()) + next;
        }

        private String newClientNonce() {
            byte[] bytes = new byte[8];
            DigestAuthentication.this.random.nextBytes(bytes);
            return toHexString(bytes);
        }

        private String toHexString(byte[] bytes) {
            return TypeUtil.toHexString(bytes).toLowerCase(Locale.ENGLISH);
        }
    }
}
