package com.mongodb.client.internal;

import com.mongodb.ServerAddress;
import com.mongodb.internal.connection.SslHelper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import p013io.javalin.http.sse.EmitterKt;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/client/internal/KeyManagementService.class */
public class KeyManagementService {
    private final SSLContext sslContext;
    private final int defaultPort;
    private final int timeoutMillis;

    /* access modifiers changed from: package-private */
    public KeyManagementService(SSLContext sslContext, int defaultPort, int timeoutMillis) {
        this.sslContext = sslContext;
        this.defaultPort = defaultPort;
        this.timeoutMillis = timeoutMillis;
    }

    public InputStream stream(String host, ByteBuffer message) throws IOException {
        ServerAddress serverAddress = host.contains(EmitterKt.COMMENT_PREFIX) ? new ServerAddress(host) : new ServerAddress(host, this.defaultPort);
        SSLSocket socket = (SSLSocket) this.sslContext.getSocketFactory().createSocket();
        try {
            enableHostNameVerification(socket);
            socket.setSoTimeout(this.timeoutMillis);
            socket.connect(serverAddress.getSocketAddress(), this.timeoutMillis);
            try {
                OutputStream outputStream = socket.getOutputStream();
                byte[] bytes = new byte[message.remaining()];
                message.get(bytes);
                outputStream.write(bytes);
                try {
                    return socket.getInputStream();
                } catch (IOException e) {
                    closeSocket(socket);
                    throw e;
                }
            } catch (IOException e2) {
                closeSocket(socket);
                throw e2;
            }
        } catch (IOException e3) {
            closeSocket(socket);
            throw e3;
        }
    }

    private void enableHostNameVerification(SSLSocket socket) {
        SSLParameters sslParameters = socket.getSSLParameters();
        if (sslParameters == null) {
            sslParameters = new SSLParameters();
        }
        SslHelper.enableHostNameVerification(sslParameters);
        socket.setSSLParameters(sslParameters);
    }

    public int getDefaultPort() {
        return this.defaultPort;
    }

    private void closeSocket(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
        }
    }
}
