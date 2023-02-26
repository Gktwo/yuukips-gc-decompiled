package p013io.netty.handler.ssl;

import io.netty.internal.tcnative.SSLSession;
import io.netty.internal.tcnative.SSLSessionCache;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.security.cert.X509Certificate;
import p013io.netty.util.ResourceLeakDetector;
import p013io.netty.util.ResourceLeakDetectorFactory;
import p013io.netty.util.ResourceLeakTracker;
import p013io.netty.util.internal.EmptyArrays;
import p013io.netty.util.internal.SystemPropertyUtil;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.ssl.OpenSslSessionCache */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslSessionCache.class */
public class OpenSslSessionCache implements SSLSessionCache {
    private static final OpenSslSession[] EMPTY_SESSIONS = new OpenSslSession[0];
    private static final int DEFAULT_CACHE_SIZE;
    private final OpenSslEngineMap engineMap;
    private final Map<OpenSslSessionId, NativeSslSession> sessions = new LinkedHashMap<OpenSslSessionId, NativeSslSession>() { // from class: io.netty.handler.ssl.OpenSslSessionCache.1
        private static final long serialVersionUID = -7773696788135734448L;

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<OpenSslSessionId, NativeSslSession> eldest) {
            int maxSize = OpenSslSessionCache.this.maximumCacheSize.get();
            if (maxSize < 0 || size() <= maxSize) {
                return false;
            }
            OpenSslSessionCache.this.removeSessionWithId(eldest.getKey());
            return false;
        }
    };
    private final AtomicInteger maximumCacheSize = new AtomicInteger(DEFAULT_CACHE_SIZE);
    private final AtomicInteger sessionTimeout = new AtomicInteger(300);
    private int sessionCounter;

    static {
        int cacheSize = SystemPropertyUtil.getInt("javax.net.ssl.sessionCacheSize", 20480);
        if (cacheSize >= 0) {
            DEFAULT_CACHE_SIZE = cacheSize;
        } else {
            DEFAULT_CACHE_SIZE = 20480;
        }
    }

    /* access modifiers changed from: package-private */
    public OpenSslSessionCache(OpenSslEngineMap engineMap) {
        this.engineMap = engineMap;
    }

    /* access modifiers changed from: package-private */
    public final void setSessionTimeout(int seconds) {
        if (this.sessionTimeout.getAndSet(seconds) > seconds) {
            clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final int getSessionTimeout() {
        return this.sessionTimeout.get();
    }

    protected boolean sessionCreated(NativeSslSession session) {
        return true;
    }

    protected void sessionRemoved(NativeSslSession session) {
    }

    /* access modifiers changed from: package-private */
    public final void setSessionCacheSize(int size) {
        if (((long) this.maximumCacheSize.getAndSet(size)) > ((long) size) || size == 0) {
            clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final int getSessionCacheSize() {
        return this.maximumCacheSize.get();
    }

    private void expungeInvalidSessions() {
        if (!this.sessions.isEmpty()) {
            long now = System.currentTimeMillis();
            Iterator<Map.Entry<OpenSslSessionId, NativeSslSession>> iterator = this.sessions.entrySet().iterator();
            while (iterator.hasNext()) {
                NativeSslSession session = iterator.next().getValue();
                if (!session.isValid(now)) {
                    iterator.remove();
                    notifyRemovalAndFree(session);
                } else {
                    return;
                }
            }
        }
    }

    public final boolean sessionCreated(long ssl, long sslSession) {
        ReferenceCountedOpenSslEngine engine = this.engineMap.get(ssl);
        if (engine == null) {
            return false;
        }
        NativeSslSession session = new NativeSslSession(sslSession, engine.getPeerHost(), engine.getPeerPort(), ((long) getSessionTimeout()) * 1000);
        engine.setSessionId(session.sessionId());
        synchronized (this) {
            int i = this.sessionCounter + 1;
            this.sessionCounter = i;
            if (i == 255) {
                this.sessionCounter = 0;
                expungeInvalidSessions();
            }
            if (!sessionCreated(session)) {
                session.close();
                return false;
            }
            NativeSslSession old = this.sessions.put(session.sessionId(), session);
            if (old != null) {
                notifyRemovalAndFree(old);
            }
            return true;
        }
    }

    public final long getSession(long ssl, byte[] sessionId) {
        OpenSslSessionId id = new OpenSslSessionId(sessionId);
        synchronized (this) {
            NativeSslSession session = this.sessions.get(id);
            if (session == null) {
                return -1;
            }
            if (!session.isValid() || !session.upRef()) {
                removeSessionWithId(session.sessionId());
                return -1;
            }
            if (session.shouldBeSingleUse()) {
                removeSessionWithId(session.sessionId());
            }
            session.updateLastAccessedTime();
            return session.session();
        }
    }

    /* access modifiers changed from: package-private */
    public void setSession(long ssl, String host, int port) {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void removeSessionWithId(OpenSslSessionId id) {
        NativeSslSession sslSession = this.sessions.remove(id);
        if (sslSession != null) {
            notifyRemovalAndFree(sslSession);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean containsSessionWithId(OpenSslSessionId id) {
        return this.sessions.containsKey(id);
    }

    private void notifyRemovalAndFree(NativeSslSession session) {
        sessionRemoved(session);
        session.free();
    }

    /* access modifiers changed from: package-private */
    public final synchronized OpenSslSession getSession(OpenSslSessionId id) {
        NativeSslSession session = this.sessions.get(id);
        if (session == null || session.isValid()) {
            return session;
        }
        removeSessionWithId(session.sessionId());
        return null;
    }

    /* access modifiers changed from: package-private */
    public final List<OpenSslSessionId> getIds() {
        OpenSslSession[] sessionsArray;
        synchronized (this) {
            sessionsArray = (OpenSslSession[]) this.sessions.values().toArray(EMPTY_SESSIONS);
        }
        List<OpenSslSessionId> ids = new ArrayList<>(sessionsArray.length);
        for (OpenSslSession session : sessionsArray) {
            if (session.isValid()) {
                ids.add(session.sessionId());
            }
        }
        return ids;
    }

    /* access modifiers changed from: package-private */
    public synchronized void clear() {
        Iterator<Map.Entry<OpenSslSessionId, NativeSslSession>> iterator = this.sessions.entrySet().iterator();
        while (iterator.hasNext()) {
            iterator.remove();
            notifyRemovalAndFree(iterator.next().getValue());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.ssl.OpenSslSessionCache$NativeSslSession */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslSessionCache$NativeSslSession.class */
    public static final class NativeSslSession implements OpenSslSession {
        static final ResourceLeakDetector<NativeSslSession> LEAK_DETECTOR;
        private final long session;
        private final String peerHost;
        private final int peerPort;

        /* renamed from: id */
        private final OpenSslSessionId f981id;
        private final long timeout;
        private boolean freed;
        static final /* synthetic */ boolean $assertionsDisabled;
        private final long creationTime = System.currentTimeMillis();
        private volatile long lastAccessedTime = this.creationTime;
        private volatile boolean valid = true;
        private final ResourceLeakTracker<NativeSslSession> leakTracker = LEAK_DETECTOR.track(this);

        static {
            $assertionsDisabled = !OpenSslSessionCache.class.desiredAssertionStatus();
            LEAK_DETECTOR = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(NativeSslSession.class);
        }

        NativeSslSession(long session, String peerHost, int peerPort, long timeout) {
            this.session = session;
            this.peerHost = peerHost;
            this.peerPort = peerPort;
            this.timeout = timeout;
            this.f981id = new OpenSslSessionId(SSLSession.getSessionId(session));
        }

        @Override // p013io.netty.handler.ssl.OpenSslSession
        public void setSessionId(OpenSslSessionId id) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        public boolean shouldBeSingleUse() {
            if ($assertionsDisabled || !this.freed) {
                return SSLSession.shouldBeSingleUse(this.session);
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public long session() {
            if ($assertionsDisabled || !this.freed) {
                return this.session;
            }
            throw new AssertionError();
        }

        boolean upRef() {
            if ($assertionsDisabled || !this.freed) {
                return SSLSession.upRef(this.session);
            }
            throw new AssertionError();
        }

        synchronized void free() {
            close();
            SSLSession.free(this.session);
        }

        void close() {
            if ($assertionsDisabled || !this.freed) {
                this.freed = true;
                invalidate();
                if (this.leakTracker != null) {
                    this.leakTracker.close(this);
                    return;
                }
                return;
            }
            throw new AssertionError();
        }

        @Override // p013io.netty.handler.ssl.OpenSslSession
        public OpenSslSessionId sessionId() {
            return this.f981id;
        }

        boolean isValid(long now) {
            return this.creationTime + this.timeout >= now && this.valid;
        }

        @Override // p013io.netty.handler.ssl.OpenSslSession
        public void setLocalCertificate(Certificate[] localCertificate) {
            throw new UnsupportedOperationException();
        }

        @Override // p013io.netty.handler.ssl.OpenSslSession
        public OpenSslSessionContext getSessionContext() {
            return null;
        }

        @Override // p013io.netty.handler.ssl.OpenSslSession
        public void tryExpandApplicationBufferSize(int packetLengthDataOnly) {
            throw new UnsupportedOperationException();
        }

        @Override // p013io.netty.handler.ssl.OpenSslSession
        public void handshakeFinished(byte[] id, String cipher, String protocol, byte[] peerCertificate, byte[][] peerCertificateChain, long creationTime, long timeout) {
            throw new UnsupportedOperationException();
        }

        @Override // javax.net.ssl.SSLSession
        public byte[] getId() {
            return this.f981id.cloneBytes();
        }

        @Override // javax.net.ssl.SSLSession
        public long getCreationTime() {
            return this.creationTime;
        }

        /* access modifiers changed from: package-private */
        public void updateLastAccessedTime() {
            this.lastAccessedTime = System.currentTimeMillis();
        }

        @Override // javax.net.ssl.SSLSession
        public long getLastAccessedTime() {
            return this.lastAccessedTime;
        }

        @Override // javax.net.ssl.SSLSession
        public void invalidate() {
            this.valid = false;
        }

        @Override // javax.net.ssl.SSLSession
        public boolean isValid() {
            return isValid(System.currentTimeMillis());
        }

        @Override // javax.net.ssl.SSLSession
        public void putValue(String name, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // javax.net.ssl.SSLSession
        public Object getValue(String name) {
            return null;
        }

        @Override // javax.net.ssl.SSLSession
        public void removeValue(String name) {
        }

        @Override // javax.net.ssl.SSLSession
        public String[] getValueNames() {
            return EmptyArrays.EMPTY_STRINGS;
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getPeerCertificates() {
            throw new UnsupportedOperationException();
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getLocalCertificates() {
            throw new UnsupportedOperationException();
        }

        @Override // javax.net.ssl.SSLSession
        public X509Certificate[] getPeerCertificateChain() {
            throw new UnsupportedOperationException();
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getPeerPrincipal() {
            throw new UnsupportedOperationException();
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getLocalPrincipal() {
            throw new UnsupportedOperationException();
        }

        @Override // javax.net.ssl.SSLSession
        public String getCipherSuite() {
            return null;
        }

        @Override // javax.net.ssl.SSLSession
        public String getProtocol() {
            return null;
        }

        @Override // javax.net.ssl.SSLSession
        public String getPeerHost() {
            return this.peerHost;
        }

        @Override // javax.net.ssl.SSLSession
        public int getPeerPort() {
            return this.peerPort;
        }

        @Override // javax.net.ssl.SSLSession
        public int getPacketBufferSize() {
            return ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE;
        }

        @Override // javax.net.ssl.SSLSession
        public int getApplicationBufferSize() {
            return ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.f981id.hashCode();
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof OpenSslSession)) {
                return false;
            }
            return this.f981id.equals(((OpenSslSession) o).sessionId());
        }
    }
}
