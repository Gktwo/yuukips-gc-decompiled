package p013io.netty.handler.ssl;

import io.netty.internal.tcnative.CertificateVerifier;
import java.security.cert.CertificateException;

/* renamed from: io.netty.handler.ssl.OpenSslCertificateException */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslCertificateException.class */
public final class OpenSslCertificateException extends CertificateException {
    private static final long serialVersionUID = 5542675253797129798L;
    private final int errorCode;

    public OpenSslCertificateException(int errorCode) {
        this((String) null, errorCode);
    }

    public OpenSslCertificateException(String msg, int errorCode) {
        super(msg);
        this.errorCode = checkErrorCode(errorCode);
    }

    public OpenSslCertificateException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = checkErrorCode(errorCode);
    }

    public OpenSslCertificateException(Throwable cause, int errorCode) {
        this(null, cause, errorCode);
    }

    public int errorCode() {
        return this.errorCode;
    }

    private static int checkErrorCode(int errorCode) {
        if (!OpenSsl.isAvailable() || CertificateVerifier.isValid(errorCode)) {
            return errorCode;
        }
        throw new IllegalArgumentException("errorCode '" + errorCode + "' invalid, see https://www.openssl.org/docs/man1.0.2/apps/verify.html.");
    }
}
