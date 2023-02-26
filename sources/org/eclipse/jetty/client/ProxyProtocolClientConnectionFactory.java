package org.eclipse.jetty.client;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.eclipse.jetty.p023io.AbstractConnection;
import org.eclipse.jetty.p023io.ClientConnectionFactory;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.Promise;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Invocable;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProxyProtocolClientConnectionFactory.class */
public abstract class ProxyProtocolClientConnectionFactory implements ClientConnectionFactory {
    private final ClientConnectionFactory factory;

    protected abstract ProxyProtocolConnection newProxyProtocolConnection(EndPoint endPoint, Map<String, Object> map);

    /* renamed from: org.eclipse.jetty.client.ProxyProtocolClientConnectionFactory$V1 */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProxyProtocolClientConnectionFactory$V1.class */
    public static class C5597V1 extends ProxyProtocolClientConnectionFactory {
        public C5597V1(ClientConnectionFactory factory) {
            super(factory);
        }

        @Override // org.eclipse.jetty.client.ProxyProtocolClientConnectionFactory
        protected ProxyProtocolConnection newProxyProtocolConnection(EndPoint endPoint, Map<String, Object> context) {
            HttpDestination destination = (HttpDestination) context.get(HttpClientTransport.HTTP_DESTINATION_CONTEXT_KEY);
            Executor executor = destination.getHttpClient().getExecutor();
            Tag tag = (Tag) destination.getOrigin().getTag();
            if (tag == null) {
                InetSocketAddress local = endPoint.getLocalAddress();
                InetSocketAddress remote = endPoint.getRemoteAddress();
                tag = new Tag(local.getAddress() instanceof Inet4Address ? "TCP4" : "TCP6", local.getAddress().getHostAddress(), local.getPort(), remote.getAddress().getHostAddress(), remote.getPort());
            }
            return new ProxyProtocolConnectionV1(endPoint, executor, getClientConnectionFactory(), context, tag);
        }

        /* renamed from: org.eclipse.jetty.client.ProxyProtocolClientConnectionFactory$V1$Tag */
        /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProxyProtocolClientConnectionFactory$V1$Tag.class */
        public static class Tag implements ClientConnectionFactory.Decorator {
            public static final Tag UNKNOWN = new Tag("UNKNOWN", null, 0, null, 0);
            private final String family;
            private final String srcIP;
            private final int srcPort;
            private final String dstIP;
            private final int dstPort;

            public Tag() {
                this(null, 0);
            }

            public Tag(String srcIP, int srcPort) {
                this(null, srcIP, srcPort, null, 0);
            }

            public Tag(String family, String srcIP, int srcPort, String dstIP, int dstPort) {
                this.family = family;
                this.srcIP = srcIP;
                this.srcPort = srcPort;
                this.dstIP = dstIP;
                this.dstPort = dstPort;
            }

            public String getFamily() {
                return this.family;
            }

            public String getSourceAddress() {
                return this.srcIP;
            }

            public int getSourcePort() {
                return this.srcPort;
            }

            public String getDestinationAddress() {
                return this.dstIP;
            }

            public int getDestinationPort() {
                return this.dstPort;
            }

            @Override // org.eclipse.jetty.p023io.ClientConnectionFactory.Decorator
            public ClientConnectionFactory apply(ClientConnectionFactory factory) {
                return new C5597V1(factory);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Tag that = (Tag) obj;
                return Objects.equals(this.family, that.family) && Objects.equals(this.srcIP, that.srcIP) && this.srcPort == that.srcPort && Objects.equals(this.dstIP, that.dstIP) && this.dstPort == that.dstPort;
            }

            public int hashCode() {
                return Objects.hash(this.family, this.srcIP, Integer.valueOf(this.srcPort), this.dstIP, Integer.valueOf(this.dstPort));
            }
        }
    }

    /* renamed from: org.eclipse.jetty.client.ProxyProtocolClientConnectionFactory$V2 */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProxyProtocolClientConnectionFactory$V2.class */
    public static class C5598V2 extends ProxyProtocolClientConnectionFactory {
        public C5598V2(ClientConnectionFactory factory) {
            super(factory);
        }

        @Override // org.eclipse.jetty.client.ProxyProtocolClientConnectionFactory
        protected ProxyProtocolConnection newProxyProtocolConnection(EndPoint endPoint, Map<String, Object> context) {
            HttpDestination destination = (HttpDestination) context.get(HttpClientTransport.HTTP_DESTINATION_CONTEXT_KEY);
            Executor executor = destination.getHttpClient().getExecutor();
            Tag tag = (Tag) destination.getOrigin().getTag();
            if (tag == null) {
                InetSocketAddress local = endPoint.getLocalAddress();
                InetSocketAddress remote = endPoint.getRemoteAddress();
                tag = new Tag(Tag.Command.PROXY, local.getAddress() instanceof Inet4Address ? Tag.Family.INET4 : Tag.Family.INET6, Tag.Protocol.STREAM, local.getAddress().getHostAddress(), local.getPort(), remote.getAddress().getHostAddress(), remote.getPort(), null);
            }
            return new ProxyProtocolConnectionV2(endPoint, executor, getClientConnectionFactory(), context, tag);
        }

        /* renamed from: org.eclipse.jetty.client.ProxyProtocolClientConnectionFactory$V2$Tag */
        /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProxyProtocolClientConnectionFactory$V2$Tag.class */
        public static class Tag implements ClientConnectionFactory.Decorator {
            public static final Tag LOCAL = new Tag(Command.LOCAL, Family.UNSPEC, Protocol.UNSPEC, null, 0, null, 0, null);
            private Command command;
            private Family family;
            private Protocol protocol;
            private String srcIP;
            private int srcPort;
            private String dstIP;
            private int dstPort;
            private List<TLV> tlvs;

            /* renamed from: org.eclipse.jetty.client.ProxyProtocolClientConnectionFactory$V2$Tag$Command */
            /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProxyProtocolClientConnectionFactory$V2$Tag$Command.class */
            public enum Command {
                LOCAL,
                PROXY
            }

            /* renamed from: org.eclipse.jetty.client.ProxyProtocolClientConnectionFactory$V2$Tag$Family */
            /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProxyProtocolClientConnectionFactory$V2$Tag$Family.class */
            public enum Family {
                UNSPEC,
                INET4,
                INET6,
                UNIX
            }

            /* renamed from: org.eclipse.jetty.client.ProxyProtocolClientConnectionFactory$V2$Tag$Protocol */
            /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProxyProtocolClientConnectionFactory$V2$Tag$Protocol.class */
            public enum Protocol {
                UNSPEC,
                STREAM,
                DGRAM
            }

            public Tag() {
                this(null, 0);
            }

            public Tag(String srcIP, int srcPort) {
                this(Command.PROXY, null, Protocol.STREAM, srcIP, srcPort, null, 0, null);
            }

            public Tag(String srcIP, int srcPort, List<TLV> tlvs) {
                this(Command.PROXY, null, Protocol.STREAM, srcIP, srcPort, null, 0, tlvs);
            }

            public Tag(Command command, Family family, Protocol protocol, String srcIP, int srcPort, String dstIP, int dstPort, List<TLV> tlvs) {
                this.command = command;
                this.family = family;
                this.protocol = protocol;
                this.srcIP = srcIP;
                this.srcPort = srcPort;
                this.dstIP = dstIP;
                this.dstPort = dstPort;
                this.tlvs = tlvs;
            }

            public Command getCommand() {
                return this.command;
            }

            public Family getFamily() {
                return this.family;
            }

            public Protocol getProtocol() {
                return this.protocol;
            }

            public String getSourceAddress() {
                return this.srcIP;
            }

            public int getSourcePort() {
                return this.srcPort;
            }

            public String getDestinationAddress() {
                return this.dstIP;
            }

            public int getDestinationPort() {
                return this.dstPort;
            }

            public List<TLV> getTLVs() {
                return this.tlvs;
            }

            @Override // org.eclipse.jetty.p023io.ClientConnectionFactory.Decorator
            public ClientConnectionFactory apply(ClientConnectionFactory factory) {
                return new C5598V2(factory);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Tag that = (Tag) obj;
                return this.command == that.command && this.family == that.family && this.protocol == that.protocol && Objects.equals(this.srcIP, that.srcIP) && this.srcPort == that.srcPort && Objects.equals(this.dstIP, that.dstIP) && this.dstPort == that.dstPort && Objects.equals(this.tlvs, that.tlvs);
            }

            public int hashCode() {
                return Objects.hash(this.command, this.family, this.protocol, this.srcIP, Integer.valueOf(this.srcPort), this.dstIP, Integer.valueOf(this.dstPort), this.tlvs);
            }

            /* renamed from: org.eclipse.jetty.client.ProxyProtocolClientConnectionFactory$V2$Tag$TLV */
            /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProxyProtocolClientConnectionFactory$V2$Tag$TLV.class */
            public static class TLV {
                private final int type;
                private final byte[] value;

                public TLV(int type, byte[] value) {
                    if (type < 0 || type > 255) {
                        throw new IllegalArgumentException("Invalid type: " + type);
                    } else if (value == null || value.length <= 65535) {
                        this.type = type;
                        this.value = (byte[]) Objects.requireNonNull(value);
                    } else {
                        throw new IllegalArgumentException("Invalid value length: " + value.length);
                    }
                }

                public int getType() {
                    return this.type;
                }

                public byte[] getValue() {
                    return this.value;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    TLV that = (TLV) obj;
                    return this.type == that.type && Arrays.equals(this.value, that.value);
                }

                public int hashCode() {
                    return (31 * Objects.hash(Integer.valueOf(this.type))) + Arrays.hashCode(this.value);
                }
            }
        }
    }

    private ProxyProtocolClientConnectionFactory(ClientConnectionFactory factory) {
        this.factory = factory;
    }

    public ClientConnectionFactory getClientConnectionFactory() {
        return this.factory;
    }

    @Override // org.eclipse.jetty.p023io.ClientConnectionFactory
    public Connection newConnection(EndPoint endPoint, Map<String, Object> context) {
        return customize(newProxyProtocolConnection(endPoint, context), context);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProxyProtocolClientConnectionFactory$ProxyProtocolConnection.class */
    protected static abstract class ProxyProtocolConnection extends AbstractConnection implements Callback {
        protected static final Logger LOG = Log.getLogger(ProxyProtocolConnection.class);
        private final ClientConnectionFactory factory;
        private final Map<String, Object> context;

        protected abstract void writePROXYBytes(EndPoint endPoint, Callback callback);

        private ProxyProtocolConnection(EndPoint endPoint, Executor executor, ClientConnectionFactory factory, Map<String, Object> context) {
            super(endPoint, executor);
            this.factory = factory;
            this.context = context;
        }

        @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
        public void onOpen() {
            onOpen();
            writePROXYBytes(getEndPoint(), this);
        }

        @Override // org.eclipse.jetty.util.Callback
        public void succeeded() {
            try {
                EndPoint endPoint = getEndPoint();
                Connection connection = this.factory.newConnection(endPoint, this.context);
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Written PROXY line, upgrading to {}", connection);
                }
                endPoint.upgrade(connection);
            } catch (Throwable x) {
                failed(x);
            }
        }

        @Override // org.eclipse.jetty.util.Callback
        public void failed(Throwable x) {
            close();
            ((Promise) this.context.get(HttpClientTransport.HTTP_CONNECTION_PROMISE_CONTEXT_KEY)).failed(x);
        }

        @Override // org.eclipse.jetty.util.thread.Invocable
        public Invocable.InvocationType getInvocationType() {
            return Invocable.InvocationType.NON_BLOCKING;
        }

        @Override // org.eclipse.jetty.p023io.AbstractConnection
        public void onFillable() {
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProxyProtocolClientConnectionFactory$ProxyProtocolConnectionV1.class */
    private static class ProxyProtocolConnectionV1 extends ProxyProtocolConnection {
        private final C5597V1.Tag tag;

        public ProxyProtocolConnectionV1(EndPoint endPoint, Executor executor, ClientConnectionFactory factory, Map<String, Object> context, C5597V1.Tag tag) {
            super(endPoint, executor, factory, context);
            this.tag = tag;
        }

        @Override // org.eclipse.jetty.client.ProxyProtocolClientConnectionFactory.ProxyProtocolConnection
        protected void writePROXYBytes(EndPoint endPoint, Callback callback) {
            try {
                InetSocketAddress localAddress = endPoint.getLocalAddress();
                InetSocketAddress remoteAddress = endPoint.getRemoteAddress();
                String family = this.tag.getFamily();
                String srcIP = this.tag.getSourceAddress();
                int srcPort = this.tag.getSourcePort();
                String dstIP = this.tag.getDestinationAddress();
                int dstPort = this.tag.getDestinationPort();
                if (family == null) {
                    family = localAddress.getAddress() instanceof Inet4Address ? "TCP4" : "TCP6";
                }
                String family2 = family.toUpperCase(Locale.ENGLISH);
                boolean unknown = family2.equals("UNKNOWN");
                StringBuilder builder = new StringBuilder(64);
                builder.append("PROXY ").append(family2);
                if (!unknown) {
                    if (srcIP == null) {
                        srcIP = localAddress.getAddress().getHostAddress();
                    }
                    builder.append(" ").append(srcIP);
                    if (dstIP == null) {
                        dstIP = remoteAddress.getAddress().getHostAddress();
                    }
                    builder.append(" ").append(dstIP);
                    if (srcPort <= 0) {
                        srcPort = localAddress.getPort();
                    }
                    builder.append(" ").append(srcPort);
                    if (dstPort <= 0) {
                        dstPort = remoteAddress.getPort();
                    }
                    builder.append(" ").append(dstPort);
                }
                builder.append("\r\n");
                String line = builder.toString();
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Writing PROXY bytes: {}", line.trim());
                }
                endPoint.write(callback, ByteBuffer.wrap(line.getBytes(StandardCharsets.US_ASCII)));
            } catch (Throwable x) {
                callback.failed(x);
            }
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProxyProtocolClientConnectionFactory$ProxyProtocolConnectionV2.class */
    private static class ProxyProtocolConnectionV2 extends ProxyProtocolConnection {
        private static final byte[] MAGIC = {13, 10, 13, 10, 0, 13, 10, 81, 85, 73, 84, 10};
        private final C5598V2.Tag tag;

        public ProxyProtocolConnectionV2(EndPoint endPoint, Executor executor, ClientConnectionFactory factory, Map<String, Object> context, C5598V2.Tag tag) {
            super(endPoint, executor, factory, context);
            this.tag = tag;
        }

        @Override // org.eclipse.jetty.client.ProxyProtocolClientConnectionFactory.ProxyProtocolConnection
        protected void writePROXYBytes(EndPoint endPoint, Callback callback) {
            try {
                int capacity = MAGIC.length + 1 + 1 + 2 + 216;
                List<C5598V2.Tag.TLV> tlvs = this.tag.getTLVs();
                int vectorsLength = tlvs == null ? 0 : tlvs.stream().mapToInt(tlv -> {
                    return 3 + tlv.getValue().length;
                }).sum();
                ByteBuffer buffer = ByteBuffer.allocateDirect(capacity + vectorsLength);
                buffer.put(MAGIC);
                buffer.put((byte) (32 | (this.tag.getCommand().ordinal() & 15)));
                C5598V2.Tag.Family family = this.tag.getFamily();
                String srcAddr = this.tag.getSourceAddress();
                if (srcAddr == null) {
                    srcAddr = endPoint.getLocalAddress().getAddress().getHostAddress();
                }
                int srcPort = this.tag.getSourcePort();
                if (srcPort <= 0) {
                    srcPort = endPoint.getLocalAddress().getPort();
                }
                if (family == null) {
                    family = InetAddress.getByName(srcAddr) instanceof Inet4Address ? C5598V2.Tag.Family.INET4 : C5598V2.Tag.Family.INET6;
                }
                C5598V2.Tag.Protocol protocol = this.tag.getProtocol();
                if (protocol == null) {
                    protocol = C5598V2.Tag.Protocol.STREAM;
                }
                buffer.put((byte) ((family.ordinal() << 4) | protocol.ordinal()));
                int length = 0;
                switch (family) {
                    case UNSPEC:
                        break;
                    case INET4:
                        length = 12;
                        break;
                    case INET6:
                        length = 36;
                        break;
                    case UNIX:
                        length = 216;
                        break;
                    default:
                        throw new IllegalStateException();
                }
                buffer.putShort((short) (length + vectorsLength));
                String dstAddr = this.tag.getDestinationAddress();
                if (dstAddr == null) {
                    dstAddr = endPoint.getRemoteAddress().getAddress().getHostAddress();
                }
                int dstPort = this.tag.getDestinationPort();
                if (dstPort <= 0) {
                    dstPort = endPoint.getRemoteAddress().getPort();
                }
                switch (family) {
                    case UNSPEC:
                        break;
                    case INET4:
                    case INET6:
                        buffer.put(InetAddress.getByName(srcAddr).getAddress());
                        buffer.put(InetAddress.getByName(dstAddr).getAddress());
                        buffer.putShort((short) srcPort);
                        buffer.putShort((short) dstPort);
                        break;
                    case UNIX:
                        int position = buffer.position();
                        buffer.put(srcAddr.getBytes(StandardCharsets.US_ASCII));
                        buffer.position(position + 108);
                        buffer.put(dstAddr.getBytes(StandardCharsets.US_ASCII));
                        break;
                    default:
                        throw new IllegalStateException();
                }
                if (tlvs != null) {
                    for (C5598V2.Tag.TLV tlv : tlvs) {
                        buffer.put((byte) tlv.getType());
                        byte[] data = tlv.getValue();
                        buffer.putShort((short) data.length);
                        buffer.put(data);
                    }
                }
                buffer.flip();
                endPoint.write(callback, buffer);
            } catch (Throwable x) {
                callback.failed(x);
            }
        }
    }
}
