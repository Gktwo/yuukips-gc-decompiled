package p013io.netty.handler.ssl;

import java.security.AlgorithmConstraints;
import javax.net.ssl.SSLParameters;
import p013io.netty.util.internal.SuppressJava6Requirement;

/* renamed from: io.netty.handler.ssl.Java7SslParametersUtils */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/Java7SslParametersUtils.class */
final class Java7SslParametersUtils {
    private Java7SslParametersUtils() {
    }

    /* access modifiers changed from: package-private */
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static void setAlgorithmConstraints(SSLParameters sslParameters, Object algorithmConstraints) {
        sslParameters.setAlgorithmConstraints((AlgorithmConstraints) algorithmConstraints);
    }
}
