package p013io.netty.handler.ssl;

import java.security.cert.Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.ssl.OpenSslSession */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslSession.class */
public interface OpenSslSession extends SSLSession {
    OpenSslSessionId sessionId();

    void setLocalCertificate(Certificate[] certificateArr);

    void setSessionId(OpenSslSessionId openSslSessionId);

    @Override // p013io.netty.handler.ssl.OpenSslSession
    OpenSslSessionContext getSessionContext();

    void tryExpandApplicationBufferSize(int i);

    void handshakeFinished(byte[] bArr, String str, String str2, byte[] bArr2, byte[][] bArr3, long j, long j2) throws SSLException;
}
