package org.eclipse.jetty.security.authentication;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.BitSet;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.security.Authenticator;
import org.eclipse.jetty.security.ServerAuthException;
import org.eclipse.jetty.security.UserAuthentication;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.QuotedStringTokenizer;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.security.Credential;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/authentication/DigestAuthenticator.class */
public class DigestAuthenticator extends LoginAuthenticator {
    private static final Logger LOG = Log.getLogger(DigestAuthenticator.class);
    private final SecureRandom _random = new SecureRandom();
    private long _maxNonceAgeMs = 60000;
    private int _maxNC = 1024;
    private ConcurrentMap<String, Nonce> _nonceMap = new ConcurrentHashMap();
    private Queue<Nonce> _nonceQueue = new ConcurrentLinkedQueue();

    @Override // org.eclipse.jetty.security.authentication.LoginAuthenticator, org.eclipse.jetty.security.Authenticator
    public void setConfiguration(Authenticator.AuthConfiguration configuration) {
        setConfiguration(configuration);
        String mna = configuration.getInitParameter("maxNonceAge");
        if (mna != null) {
            setMaxNonceAge(Long.parseLong(mna));
        }
        String mnc = configuration.getInitParameter("maxNonceCount");
        if (mnc != null) {
            setMaxNonceCount(Integer.parseInt(mnc));
        }
    }

    public int getMaxNonceCount() {
        return this._maxNC;
    }

    public void setMaxNonceCount(int maxNC) {
        this._maxNC = maxNC;
    }

    public long getMaxNonceAge() {
        return this._maxNonceAgeMs;
    }

    public void setMaxNonceAge(long maxNonceAgeInMillis) {
        this._maxNonceAgeMs = maxNonceAgeInMillis;
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public String getAuthMethod() {
        return "DIGEST";
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public boolean secureResponse(ServletRequest req, ServletResponse res, boolean mandatory, Authentication.User validatedUser) throws ServerAuthException {
        return true;
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public Authentication validateRequest(ServletRequest req, ServletResponse res, boolean mandatory) throws ServerAuthException {
        if (!mandatory) {
            return new DeferredAuthentication(this);
        }
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String credentials = request.getHeader(HttpHeader.AUTHORIZATION.asString());
        try {
            Request baseRequest = Request.getBaseRequest(request);
            boolean stale = false;
            if (credentials != null) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Credentials: " + credentials, new Object[0]);
                }
                QuotedStringTokenizer tokenizer = new QuotedStringTokenizer(credentials, "=, ", true, false);
                Digest digest = new Digest(request.getMethod());
                String last = null;
                String name = null;
                while (tokenizer.hasMoreTokens()) {
                    String tok = tokenizer.nextToken();
                    switch (tok.length() == 1 ? tok.charAt(0) : 0) {
                        case ' ':
                            break;
                        case ',':
                            name = null;
                            break;
                        case '=':
                            name = last;
                            last = tok;
                            break;
                        default:
                            last = tok;
                            if (name != null) {
                                if (SendMailJob.PROP_USERNAME.equalsIgnoreCase(name)) {
                                    digest.username = tok;
                                } else if ("realm".equalsIgnoreCase(name)) {
                                    digest.realm = tok;
                                } else if ("nonce".equalsIgnoreCase(name)) {
                                    digest.nonce = tok;
                                } else if ("nc".equalsIgnoreCase(name)) {
                                    digest.f3109nc = tok;
                                } else if ("cnonce".equalsIgnoreCase(name)) {
                                    digest.cnonce = tok;
                                } else if ("qop".equalsIgnoreCase(name)) {
                                    digest.qop = tok;
                                } else if ("uri".equalsIgnoreCase(name)) {
                                    digest.uri = tok;
                                } else if ("response".equalsIgnoreCase(name)) {
                                    digest.response = tok;
                                }
                                name = null;
                                break;
                            } else {
                                break;
                            }
                    }
                }
                int n = checkNonce(digest, baseRequest);
                if (n > 0) {
                    UserIdentity user = login(digest.username, digest, req);
                    if (user != null) {
                        return new UserAuthentication(getAuthMethod(), user);
                    }
                } else if (n == 0) {
                    stale = true;
                }
            }
            if (DeferredAuthentication.isDeferred(response)) {
                return Authentication.UNAUTHENTICATED;
            }
            String domain = request.getContextPath();
            if (domain == null) {
                domain = "/";
            }
            response.setHeader(HttpHeader.WWW_AUTHENTICATE.asString(), "Digest realm=\"" + this._loginService.getName() + "\", domain=\"" + domain + "\", nonce=\"" + newNonce(baseRequest) + "\", algorithm=MD5, qop=\"auth\", stale=" + stale);
            response.sendError(401);
            return Authentication.SEND_CONTINUE;
        } catch (IOException e) {
            throw new ServerAuthException(e);
        }
    }

    @Override // org.eclipse.jetty.security.authentication.LoginAuthenticator
    public UserIdentity login(String username, Object credentials, ServletRequest request) {
        if (!Objects.equals(((Digest) credentials).realm, this._loginService.getName())) {
            return null;
        }
        return login(username, credentials, request);
    }

    public String newNonce(Request request) {
        Nonce nonce;
        do {
            byte[] nounce = new byte[24];
            this._random.nextBytes(nounce);
            nonce = new Nonce(Base64.getEncoder().encodeToString(nounce), request.getTimeStamp(), getMaxNonceCount());
        } while (this._nonceMap.putIfAbsent(nonce._nonce, nonce) != null);
        this._nonceQueue.add(nonce);
        return nonce._nonce;
    }

    private int checkNonce(Digest digest, Request request) {
        long expired = request.getTimeStamp() - getMaxNonceAge();
        Nonce peek = this._nonceQueue.peek();
        while (true) {
            Nonce nonce = peek;
            if (nonce == null || nonce._ts >= expired) {
                try {
                    Nonce nonce2 = this._nonceMap.get(digest.nonce);
                    if (nonce2 == null) {
                        return 0;
                    }
                    long count = Long.parseLong(digest.f3109nc, 16);
                    if (count >= ((long) this._maxNC)) {
                        return 0;
                    }
                    if (nonce2.seen((int) count)) {
                        return -1;
                    }
                    return 1;
                } catch (Exception e) {
                    LOG.ignore(e);
                    return -1;
                }
            } else {
                this._nonceQueue.remove(nonce);
                this._nonceMap.remove(nonce._nonce);
                peek = this._nonceQueue.peek();
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/security/authentication/DigestAuthenticator$Nonce.class */
    public static class Nonce {
        final String _nonce;
        final long _ts;
        final BitSet _seen;

        public Nonce(String nonce, long ts, int size) {
            this._nonce = nonce;
            this._ts = ts;
            this._seen = new BitSet(size);
        }

        public boolean seen(int count) {
            synchronized (this) {
                if (count >= this._seen.size()) {
                    return true;
                }
                boolean s = this._seen.get(count);
                this._seen.set(count);
                return s;
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/security/authentication/DigestAuthenticator$Digest.class */
    public static class Digest extends Credential {
        private static final long serialVersionUID = -2484639019549527724L;
        final String method;
        String username = "";
        String realm = "";
        String nonce = "";

        /* renamed from: nc */
        String f3109nc = "";
        String cnonce = "";
        String qop = "";
        String uri = "";
        String response = "";

        Digest(String m) {
            this.method = m;
        }

        @Override // org.eclipse.jetty.util.security.Credential
        public boolean check(Object credentials) {
            byte[] ha1;
            if (credentials instanceof char[]) {
                credentials = new String((char[]) credentials);
            }
            String password = credentials instanceof String ? (String) credentials : credentials.toString();
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                if (credentials instanceof Credential.MD5) {
                    ha1 = ((Credential.MD5) credentials).getDigest();
                } else {
                    md.update(this.username.getBytes(StandardCharsets.ISO_8859_1));
                    md.update((byte) 58);
                    md.update(this.realm.getBytes(StandardCharsets.ISO_8859_1));
                    md.update((byte) 58);
                    md.update(password.getBytes(StandardCharsets.ISO_8859_1));
                    ha1 = md.digest();
                }
                md.reset();
                md.update(this.method.getBytes(StandardCharsets.ISO_8859_1));
                md.update((byte) 58);
                md.update(this.uri.getBytes(StandardCharsets.ISO_8859_1));
                byte[] ha2 = md.digest();
                md.update(TypeUtil.toString(ha1, 16).getBytes(StandardCharsets.ISO_8859_1));
                md.update((byte) 58);
                md.update(this.nonce.getBytes(StandardCharsets.ISO_8859_1));
                md.update((byte) 58);
                md.update(this.f3109nc.getBytes(StandardCharsets.ISO_8859_1));
                md.update((byte) 58);
                md.update(this.cnonce.getBytes(StandardCharsets.ISO_8859_1));
                md.update((byte) 58);
                md.update(this.qop.getBytes(StandardCharsets.ISO_8859_1));
                md.update((byte) 58);
                md.update(TypeUtil.toString(ha2, 16).getBytes(StandardCharsets.ISO_8859_1));
                return stringEquals(TypeUtil.toString(md.digest(), 16).toLowerCase(), this.response == null ? null : this.response.toLowerCase());
            } catch (Exception e) {
                DigestAuthenticator.LOG.warn(e);
                return false;
            }
        }

        @Override // java.lang.Object
        public String toString() {
            return this.username + "," + this.response;
        }
    }
}
