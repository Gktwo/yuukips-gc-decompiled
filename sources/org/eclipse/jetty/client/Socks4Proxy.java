package org.eclipse.jetty.client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.jetty.client.Origin;
import org.eclipse.jetty.client.ProxyConfiguration;
import org.eclipse.jetty.p023io.AbstractConnection;
import org.eclipse.jetty.p023io.ClientConnectionFactory;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.p023io.ssl.SslClientConnectionFactory;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.Promise;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/Socks4Proxy.class */
public class Socks4Proxy extends ProxyConfiguration.Proxy {
    public Socks4Proxy(String host, int port) {
        this(new Origin.Address(host, port), false);
    }

    public Socks4Proxy(Origin.Address address, boolean secure) {
        super(address, secure);
    }

    @Override // org.eclipse.jetty.client.ProxyConfiguration.Proxy
    public ClientConnectionFactory newClientConnectionFactory(ClientConnectionFactory connectionFactory) {
        return new Socks4ProxyClientConnectionFactory(connectionFactory);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/Socks4Proxy$Socks4ProxyClientConnectionFactory.class */
    public static class Socks4ProxyClientConnectionFactory implements ClientConnectionFactory {
        private final ClientConnectionFactory connectionFactory;

        public Socks4ProxyClientConnectionFactory(ClientConnectionFactory connectionFactory) {
            this.connectionFactory = connectionFactory;
        }

        @Override // org.eclipse.jetty.p023io.ClientConnectionFactory
        public Connection newConnection(EndPoint endPoint, Map<String, Object> context) {
            return customize(new Socks4ProxyConnection(endPoint, ((HttpDestination) context.get(HttpClientTransport.HTTP_DESTINATION_CONTEXT_KEY)).getHttpClient().getExecutor(), this.connectionFactory, context), context);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/Socks4Proxy$Socks4ProxyConnection.class */
    public static class Socks4ProxyConnection extends AbstractConnection implements Callback {
        private static final Pattern IPv4_PATTERN = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})");
        private static final Logger LOG = Log.getLogger(Socks4ProxyConnection.class);
        private final Socks4Parser parser = new Socks4Parser();
        private final ClientConnectionFactory connectionFactory;
        private final Map<String, Object> context;

        public Socks4ProxyConnection(EndPoint endPoint, Executor executor, ClientConnectionFactory connectionFactory, Map<String, Object> context) {
            super(endPoint, executor);
            this.connectionFactory = connectionFactory;
            this.context = context;
        }

        @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
        public void onOpen() {
            onOpen();
            writeSocks4Connect();
        }

        private void writeSocks4Connect() {
            HttpDestination destination = (HttpDestination) this.context.get(HttpClientTransport.HTTP_DESTINATION_CONTEXT_KEY);
            String host = destination.getHost();
            short port = (short) destination.getPort();
            Matcher matcher = IPv4_PATTERN.matcher(host);
            if (matcher.matches()) {
                ByteBuffer buffer = ByteBuffer.allocate(9);
                buffer.put((byte) 4).put((byte) 1).putShort(port);
                for (int i = 1; i <= 4; i++) {
                    buffer.put((byte) Integer.parseInt(matcher.group(i)));
                }
                buffer.put((byte) 0);
                buffer.flip();
                getEndPoint().write(this, buffer);
                return;
            }
            byte[] hostBytes = host.getBytes(StandardCharsets.UTF_8);
            ByteBuffer buffer2 = ByteBuffer.allocate(9 + hostBytes.length + 1);
            buffer2.put((byte) 4).put((byte) 1).putShort(port);
            buffer2.put((byte) 0).put((byte) 0).put((byte) 0).put((byte) 1).put((byte) 0);
            buffer2.put(hostBytes).put((byte) 0);
            buffer2.flip();
            getEndPoint().write(this, buffer2);
        }

        @Override // org.eclipse.jetty.util.Callback
        public void succeeded() {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Written SOCKS4 connect request", new Object[0]);
            }
            fillInterested();
        }

        @Override // org.eclipse.jetty.util.Callback
        public void failed(Throwable x) {
            close();
            ((Promise) this.context.get(HttpClientTransport.HTTP_CONNECTION_PROMISE_CONTEXT_KEY)).failed(x);
        }

        @Override // org.eclipse.jetty.p023io.AbstractConnection
        public void onFillable() {
            while (true) {
                try {
                    ByteBuffer buffer = BufferUtil.allocate(this.parser.expected());
                    int filled = getEndPoint().fill(buffer);
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Read SOCKS4 connect response, {} bytes", (long) filled);
                    }
                    if (filled < 0) {
                        throw new IOException("SOCKS4 tunnel failed, connection closed");
                    } else if (filled == 0) {
                        fillInterested();
                        return;
                    } else if (this.parser.parse(buffer)) {
                        return;
                    }
                } catch (Throwable x) {
                    failed(x);
                    return;
                }
            }
        }

        /* access modifiers changed from: private */
        public void onSocks4Response(int responseCode) throws IOException {
            if (responseCode == 90) {
                tunnel();
                return;
            }
            throw new IOException("SOCKS4 tunnel failed with code " + responseCode);
        }

        private void tunnel() {
            try {
                HttpDestination destination = (HttpDestination) this.context.get(HttpClientTransport.HTTP_DESTINATION_CONTEXT_KEY);
                this.context.put(SslClientConnectionFactory.SSL_PEER_HOST_CONTEXT_KEY, destination.getHost());
                this.context.put(SslClientConnectionFactory.SSL_PEER_PORT_CONTEXT_KEY, Integer.valueOf(destination.getPort()));
                ClientConnectionFactory connectionFactory = this.connectionFactory;
                if (destination.isSecure()) {
                    connectionFactory = destination.newSslClientConnectionFactory(null, connectionFactory);
                }
                Connection newConnection = connectionFactory.newConnection(getEndPoint(), this.context);
                getEndPoint().upgrade(newConnection);
                if (LOG.isDebugEnabled()) {
                    LOG.debug("SOCKS4 tunnel established: {} over {}", this, newConnection);
                }
            } catch (Throwable x) {
                failed(x);
            }
        }

        /* loaded from: grasscutter.jar:org/eclipse/jetty/client/Socks4Proxy$Socks4ProxyConnection$Socks4Parser.class */
        private class Socks4Parser {
            private static final int EXPECTED_LENGTH = 8;
            private int cursor;
            private int response;

            private Socks4Parser() {
            }

            /* access modifiers changed from: private */
            public boolean parse(ByteBuffer buffer) throws IOException {
                while (buffer.hasRemaining()) {
                    byte current = buffer.get();
                    if (this.cursor == 1) {
                        this.response = current & 255;
                    }
                    this.cursor++;
                    if (this.cursor == 8) {
                        Socks4ProxyConnection.this.onSocks4Response(this.response);
                        return true;
                    }
                }
                return false;
            }

            /* access modifiers changed from: private */
            public int expected() {
                return 8 - this.cursor;
            }
        }
    }
}
