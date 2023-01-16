package p013io.netty.handler.ssl;

import javax.net.ssl.SSLEngine;

/* renamed from: io.netty.handler.ssl.OpenSslCertificateCompressionAlgorithm */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslCertificateCompressionAlgorithm.class */
public interface OpenSslCertificateCompressionAlgorithm {
    byte[] compress(SSLEngine sSLEngine, byte[] bArr) throws Exception;

    byte[] decompress(SSLEngine sSLEngine, int i, byte[] bArr) throws Exception;

    int algorithmId();
}
