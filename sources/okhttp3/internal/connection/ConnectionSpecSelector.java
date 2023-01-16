package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionSpec;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConnectionSpecSelector.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��6\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b��\u0018��2\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\rH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n��¨\u0006\u0012"}, m373d2 = {"Lokhttp3/internal/connection/ConnectionSpecSelector;", "", "connectionSpecs", "", "Lokhttp3/ConnectionSpec;", "(Ljava/util/List;)V", "isFallback", "", "isFallbackPossible", "nextModeIndex", "", "configureSecureSocket", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "connectionFailed", "e", "Ljava/io/IOException;", "socket", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/connection/ConnectionSpecSelector.class */
public final class ConnectionSpecSelector {
    @NotNull
    private final List<ConnectionSpec> connectionSpecs;
    private int nextModeIndex;
    private boolean isFallbackPossible;
    private boolean isFallback;

    public ConnectionSpecSelector(@NotNull List<ConnectionSpec> list) {
        Intrinsics.checkNotNullParameter(list, "connectionSpecs");
        this.connectionSpecs = list;
    }

    @NotNull
    public final ConnectionSpec configureSecureSocket(@NotNull SSLSocket sslSocket) throws IOException {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        ConnectionSpec tlsConfiguration = null;
        int i = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i >= size) {
                break;
            }
            i++;
            ConnectionSpec connectionSpec = this.connectionSpecs.get(i);
            if (connectionSpec.isCompatible(sslSocket)) {
                tlsConfiguration = connectionSpec;
                this.nextModeIndex = i + 1;
                break;
            }
        }
        if (tlsConfiguration == null) {
            StringBuilder append = new StringBuilder().append("Unable to find acceptable protocols. isFallback=").append(this.isFallback).append(", modes=").append(this.connectionSpecs).append(", supported protocols=");
            String[] enabledProtocols = sslSocket.getEnabledProtocols();
            Intrinsics.checkNotNull(enabledProtocols);
            String arrays = Arrays.toString(enabledProtocols);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            throw new UnknownServiceException(append.append(arrays).toString());
        }
        this.isFallbackPossible = isFallbackPossible(sslSocket);
        tlsConfiguration.apply$okhttp(sslSocket, this.isFallback);
        return tlsConfiguration;
    }

    public final boolean connectionFailed(@NotNull IOException e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.isFallback = true;
        if (this.isFallbackPossible && !(e instanceof ProtocolException) && !(e instanceof InterruptedIOException)) {
            return (!(e instanceof SSLHandshakeException) || !(e.getCause() instanceof CertificateException)) && !(e instanceof SSLPeerUnverifiedException) && (e instanceof SSLException);
        }
        return false;
    }

    private final boolean isFallbackPossible(SSLSocket socket) {
        int i = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (i < size) {
            i++;
            if (this.connectionSpecs.get(i).isCompatible(socket)) {
                return true;
            }
        }
        return false;
    }
}
