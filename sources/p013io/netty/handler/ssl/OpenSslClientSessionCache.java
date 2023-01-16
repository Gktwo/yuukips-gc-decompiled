package p013io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import java.util.HashMap;
import java.util.Map;
import p013io.netty.handler.ssl.OpenSslSessionCache;
import p013io.netty.util.AsciiString;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.ssl.OpenSslClientSessionCache */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslClientSessionCache.class */
public final class OpenSslClientSessionCache extends OpenSslSessionCache {
    private final Map<HostPort, OpenSslSessionCache.NativeSslSession> sessions = new HashMap();
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !OpenSslClientSessionCache.class.desiredAssertionStatus();
    }

    /* access modifiers changed from: package-private */
    public OpenSslClientSessionCache(OpenSslEngineMap engineMap) {
        super(engineMap);
    }

    @Override // p013io.netty.handler.ssl.OpenSslSessionCache
    protected boolean sessionCreated(OpenSslSessionCache.NativeSslSession session) {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            HostPort hostPort = keyFor(session.getPeerHost(), session.getPeerPort());
            if (hostPort == null || this.sessions.containsKey(hostPort)) {
                return false;
            }
            this.sessions.put(hostPort, session);
            return true;
        }
        throw new AssertionError();
    }

    @Override // p013io.netty.handler.ssl.OpenSslSessionCache
    protected void sessionRemoved(OpenSslSessionCache.NativeSslSession session) {
        if ($assertionsDisabled || Thread.holdsLock(this)) {
            HostPort hostPort = keyFor(session.getPeerHost(), session.getPeerPort());
            if (hostPort != null) {
                this.sessions.remove(hostPort);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.netty.handler.ssl.OpenSslSessionCache
    public void setSession(long ssl, String host, int port) {
        HostPort hostPort = keyFor(host, port);
        if (hostPort != null) {
            synchronized (this) {
                OpenSslSessionCache.NativeSslSession session = this.sessions.get(hostPort);
                if (session != null) {
                    if (!session.isValid()) {
                        removeSessionWithId(session.sessionId());
                        return;
                    }
                    boolean reused = SSL.setSession(ssl, session.session());
                    if (reused) {
                        if (session.shouldBeSingleUse()) {
                            session.invalidate();
                        }
                        session.updateLastAccessedTime();
                    }
                }
            }
        }
    }

    private static HostPort keyFor(String host, int port) {
        if (host != null || port >= 1) {
            return new HostPort(host, port);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.netty.handler.ssl.OpenSslSessionCache
    public synchronized void clear() {
        clear();
        this.sessions.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.ssl.OpenSslClientSessionCache$HostPort */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslClientSessionCache$HostPort.class */
    public static final class HostPort {
        private final int hash;
        private final String host;
        private final int port;

        HostPort(String host, int port) {
            this.host = host;
            this.port = port;
            this.hash = (31 * AsciiString.hashCode(host)) + port;
        }

        public int hashCode() {
            return this.hash;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof HostPort)) {
                return false;
            }
            HostPort other = (HostPort) obj;
            return this.port == other.port && this.host.equalsIgnoreCase(other.host);
        }

        public String toString() {
            return "HostPort{host='" + this.host + "', port=" + this.port + '}';
        }
    }
}
