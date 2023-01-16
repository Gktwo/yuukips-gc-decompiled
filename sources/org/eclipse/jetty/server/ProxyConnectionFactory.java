package org.eclipse.jetty.server;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ReadPendingException;
import java.nio.channels.WritePendingException;
import java.nio.charset.StandardCharsets;
import org.eclipse.jetty.p023io.AbstractConnection;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.server.ConnectionFactory;
import org.eclipse.jetty.util.AttributesMap;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/ProxyConnectionFactory.class */
public class ProxyConnectionFactory extends DetectorConnectionFactory {
    public static final String TLS_VERSION = "TLS_VERSION";
    private static final Logger LOG = Log.getLogger(ProxyConnectionFactory.class);

    public ProxyConnectionFactory() {
        this(null);
    }

    public ProxyConnectionFactory(String nextProtocol) {
        super(new ProxyV1ConnectionFactory(nextProtocol), new ProxyV2ConnectionFactory(nextProtocol));
    }

    /* access modifiers changed from: private */
    public static ConnectionFactory findNextConnectionFactory(String nextProtocol, Connector connector, String currentProtocol, EndPoint endp) {
        String currentProtocol2 = "[" + currentProtocol + "]";
        if (LOG.isDebugEnabled()) {
            LOG.debug("finding connection factory following {} for protocol {}", currentProtocol2, nextProtocol);
        }
        String nextProtocolToFind = nextProtocol;
        if (nextProtocol == null) {
            nextProtocolToFind = AbstractConnectionFactory.findNextProtocol(connector, currentProtocol2);
        }
        if (nextProtocolToFind == null) {
            throw new IllegalStateException("Cannot find protocol following '" + currentProtocol2 + "' in connector's protocol list " + connector.getProtocols() + " for " + endp);
        }
        ConnectionFactory connectionFactory = connector.getConnectionFactory(nextProtocolToFind);
        if (connectionFactory == null) {
            throw new IllegalStateException("Cannot find protocol '" + nextProtocol + "' in connector's protocol list " + connector.getProtocols() + " for " + endp);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("found next connection factory {} for protocol {}", connectionFactory, nextProtocol);
        }
        return connectionFactory;
    }

    public int getMaxProxyHeader() {
        return ((ProxyV2ConnectionFactory) getBean((Class<Object>) ProxyV2ConnectionFactory.class)).getMaxProxyHeader();
    }

    public void setMaxProxyHeader(int maxProxyHeader) {
        ((ProxyV2ConnectionFactory) getBean((Class<Object>) ProxyV2ConnectionFactory.class)).setMaxProxyHeader(maxProxyHeader);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ProxyConnectionFactory$ProxyV1ConnectionFactory.class */
    private static class ProxyV1ConnectionFactory extends AbstractConnectionFactory implements ConnectionFactory.Detecting {
        private static final byte[] SIGNATURE = "PROXY".getBytes(StandardCharsets.US_ASCII);
        private final String _nextProtocol;

        private ProxyV1ConnectionFactory(String nextProtocol) {
            super("proxy");
            this._nextProtocol = nextProtocol;
        }

        @Override // org.eclipse.jetty.server.ConnectionFactory.Detecting
        public ConnectionFactory.Detecting.Detection detect(ByteBuffer buffer) {
            if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                ProxyConnectionFactory.LOG.debug("Proxy v1 attempting detection with {} bytes", (long) buffer.remaining());
            }
            if (buffer.remaining() < SIGNATURE.length) {
                if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                    ProxyConnectionFactory.LOG.debug("Proxy v1 detection requires more bytes", new Object[0]);
                }
                return ConnectionFactory.Detecting.Detection.NEED_MORE_BYTES;
            }
            for (int i = 0; i < SIGNATURE.length; i++) {
                if (buffer.get(i) != SIGNATURE[i]) {
                    if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                        ProxyConnectionFactory.LOG.debug("Proxy v1 detection unsuccessful", new Object[0]);
                    }
                    return ConnectionFactory.Detecting.Detection.NOT_RECOGNIZED;
                }
            }
            if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                ProxyConnectionFactory.LOG.debug("Proxy v1 detection succeeded", new Object[0]);
            }
            return ConnectionFactory.Detecting.Detection.RECOGNIZED;
        }

        @Override // org.eclipse.jetty.server.ConnectionFactory
        public Connection newConnection(Connector connector, EndPoint endp) {
            return configure(new ProxyProtocolV1Connection(endp, connector, ProxyConnectionFactory.findNextConnectionFactory(this._nextProtocol, connector, getProtocol(), endp)), connector, endp);
        }

        /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ProxyConnectionFactory$ProxyV1ConnectionFactory$ProxyProtocolV1Connection.class */
        private static class ProxyProtocolV1Connection extends AbstractConnection implements Connection.UpgradeFrom, Connection.UpgradeTo {
            private static final int CR_INDEX = 6;
            private static final int LF_INDEX = 7;
            private final Connector _connector;
            private final ConnectionFactory _next;
            private final ByteBuffer _buffer;
            private final StringBuilder _builder;
            private final String[] _fields;
            private int _index;
            private int _length;

            private ProxyProtocolV1Connection(EndPoint endp, Connector connector, ConnectionFactory next) {
                super(endp, connector.getExecutor());
                this._builder = new StringBuilder();
                this._fields = new String[6];
                this._connector = connector;
                this._next = next;
                this._buffer = this._connector.getByteBufferPool().acquire(getInputBufferSize(), true);
            }

            @Override // org.eclipse.jetty.p023io.AbstractConnection
            public void onFillable() {
                if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                    ProxyConnectionFactory.LOG.debug("Proxy v1 onFillable current index = ", (long) this._index);
                }
                while (this._index < 7) {
                    try {
                        int fill = getEndPoint().fill(this._buffer);
                        if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                            ProxyConnectionFactory.LOG.debug("Proxy v1 filled buffer with {} bytes", (long) fill);
                        }
                        if (fill < 0) {
                            this._connector.getByteBufferPool().release(this._buffer);
                            getEndPoint().shutdownOutput();
                            return;
                        } else if (fill == 0) {
                            fillInterested();
                            return;
                        } else if (parse()) {
                            break;
                        }
                    } catch (Throwable x) {
                        ProxyConnectionFactory.LOG.warn("Proxy v1 error for {}", getEndPoint(), x);
                        releaseAndClose();
                        return;
                    }
                }
                if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                    ProxyConnectionFactory.LOG.debug("Proxy v1 onFillable parsing done, now upgrading", new Object[0]);
                }
                upgrade();
            }

            @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
            public void onOpen() {
                onOpen();
                do {
                    try {
                        if (this._index >= 7) {
                            if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                                ProxyConnectionFactory.LOG.debug("Proxy v1 onOpen parsing done, now upgrading", new Object[0]);
                            }
                            upgrade();
                            return;
                        }
                    } catch (Throwable x) {
                        ProxyConnectionFactory.LOG.warn("Proxy v1 error for {}", getEndPoint(), x);
                        releaseAndClose();
                        return;
                    }
                } while (parse());
                if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                    ProxyConnectionFactory.LOG.debug("Proxy v1 onOpen parsing ran out of bytes, marking as fillInterested", new Object[0]);
                }
                fillInterested();
            }

            @Override // org.eclipse.jetty.p023io.Connection.UpgradeFrom
            public ByteBuffer onUpgradeFrom() {
                if (!this._buffer.hasRemaining()) {
                    return null;
                }
                ByteBuffer unconsumed = ByteBuffer.allocateDirect(this._buffer.remaining());
                unconsumed.put(this._buffer);
                unconsumed.flip();
                this._connector.getByteBufferPool().release(this._buffer);
                return unconsumed;
            }

            @Override // org.eclipse.jetty.p023io.Connection.UpgradeTo
            public void onUpgradeTo(ByteBuffer buffer) {
                if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                    ProxyConnectionFactory.LOG.debug("Proxy v1 copying unconsumed buffer {}", BufferUtil.toDetailString(buffer));
                }
                BufferUtil.append(this._buffer, buffer);
            }

            private boolean parse() throws IOException {
                if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                    ProxyConnectionFactory.LOG.debug("Proxy v1 parsing {}", BufferUtil.toDetailString(this._buffer));
                }
                this._length += this._buffer.remaining();
                while (this._buffer.hasRemaining()) {
                    byte b = this._buffer.get();
                    if (this._index < 6) {
                        if (b == 32 || b == 13) {
                            String[] strArr = this._fields;
                            int i = this._index;
                            this._index = i + 1;
                            strArr[i] = this._builder.toString();
                            this._builder.setLength(0);
                            if (b == 13) {
                                this._index = 6;
                            }
                        } else if (b < 32) {
                            throw new IOException("Proxy v1 bad character " + (b & 255));
                        } else {
                            this._builder.append((char) b);
                        }
                    } else if (b == 10) {
                        this._index = 7;
                        if (!ProxyConnectionFactory.LOG.isDebugEnabled()) {
                            return true;
                        }
                        ProxyConnectionFactory.LOG.debug("Proxy v1 parsing is done", new Object[0]);
                        return true;
                    } else {
                        throw new IOException("Proxy v1 bad CRLF " + (b & 255));
                    }
                }
                if (!ProxyConnectionFactory.LOG.isDebugEnabled()) {
                    return false;
                }
                ProxyConnectionFactory.LOG.debug("Proxy v1 parsing requires more bytes", new Object[0]);
                return false;
            }

            private void releaseAndClose() {
                if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                    ProxyConnectionFactory.LOG.debug("Proxy v1 releasing buffer and closing", new Object[0]);
                }
                this._connector.getByteBufferPool().release(this._buffer);
                close();
            }

            private void upgrade() {
                int proxyLineLength = this._length - this._buffer.remaining();
                if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                    ProxyConnectionFactory.LOG.debug("Proxy v1 pre-upgrade packet length (including CRLF) is {}", (long) proxyLineLength);
                }
                if (proxyLineLength >= 110) {
                    ProxyConnectionFactory.LOG.warn("Proxy v1 PROXY line too long {} for {}", Integer.valueOf(proxyLineLength), getEndPoint());
                    releaseAndClose();
                } else if (!"PROXY".equals(this._fields[0])) {
                    ProxyConnectionFactory.LOG.warn("Proxy v1 not PROXY protocol for {}", getEndPoint());
                    releaseAndClose();
                } else {
                    String srcIP = this._fields[2];
                    String srcPort = this._fields[4];
                    String dstIP = this._fields[3];
                    String dstPort = this._fields[5];
                    if ("UNKNOWN".equalsIgnoreCase(this._fields[1])) {
                        srcIP = getEndPoint().getRemoteAddress().getAddress().getHostAddress();
                        srcPort = String.valueOf(getEndPoint().getRemoteAddress().getPort());
                        dstIP = getEndPoint().getLocalAddress().getAddress().getHostAddress();
                        dstPort = String.valueOf(getEndPoint().getLocalAddress().getPort());
                    }
                    InetSocketAddress remote = new InetSocketAddress(srcIP, Integer.parseInt(srcPort));
                    InetSocketAddress local = new InetSocketAddress(dstIP, Integer.parseInt(dstPort));
                    if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                        ProxyConnectionFactory.LOG.debug("Proxy v1 next protocol '{}' for {} r={} l={}", this._next, getEndPoint(), remote, local);
                    }
                    DetectorConnectionFactory.upgradeToConnectionFactory(this._next, this._connector, new ProxyEndPoint(getEndPoint(), remote, local));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ProxyConnectionFactory$ProxyV2ConnectionFactory.class */
    public static class ProxyV2ConnectionFactory extends AbstractConnectionFactory implements ConnectionFactory.Detecting {
        private static final byte[] SIGNATURE = {13, 10, 13, 10, 0, 13, 10, 81, 85, 73, 84, 10};
        private final String _nextProtocol;
        private int _maxProxyHeader;

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ProxyConnectionFactory$ProxyV2ConnectionFactory$Family.class */
        public enum Family {
            UNSPEC,
            INET,
            INET6,
            UNIX
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ProxyConnectionFactory$ProxyV2ConnectionFactory$Transport.class */
        public enum Transport {
            UNSPEC,
            STREAM,
            DGRAM
        }

        private ProxyV2ConnectionFactory(String nextProtocol) {
            super("proxy");
            this._maxProxyHeader = 1024;
            this._nextProtocol = nextProtocol;
        }

        @Override // org.eclipse.jetty.server.ConnectionFactory.Detecting
        public ConnectionFactory.Detecting.Detection detect(ByteBuffer buffer) {
            if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                ProxyConnectionFactory.LOG.debug("Proxy v2 attempting detection with {} bytes", (long) buffer.remaining());
            }
            if (buffer.remaining() < SIGNATURE.length) {
                if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                    ProxyConnectionFactory.LOG.debug("Proxy v2 detection requires more bytes", new Object[0]);
                }
                return ConnectionFactory.Detecting.Detection.NEED_MORE_BYTES;
            }
            for (int i = 0; i < SIGNATURE.length; i++) {
                if (buffer.get(i) != SIGNATURE[i]) {
                    if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                        ProxyConnectionFactory.LOG.debug("Proxy v2 detection unsuccessful", new Object[0]);
                    }
                    return ConnectionFactory.Detecting.Detection.NOT_RECOGNIZED;
                }
            }
            if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                ProxyConnectionFactory.LOG.debug("Proxy v2 detection succeeded", new Object[0]);
            }
            return ConnectionFactory.Detecting.Detection.RECOGNIZED;
        }

        public int getMaxProxyHeader() {
            return this._maxProxyHeader;
        }

        public void setMaxProxyHeader(int maxProxyHeader) {
            this._maxProxyHeader = maxProxyHeader;
        }

        @Override // org.eclipse.jetty.server.ConnectionFactory
        public Connection newConnection(Connector connector, EndPoint endp) {
            return configure(new ProxyProtocolV2Connection(endp, connector, ProxyConnectionFactory.findNextConnectionFactory(this._nextProtocol, connector, getProtocol(), endp)), connector, endp);
        }

        /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ProxyConnectionFactory$ProxyV2ConnectionFactory$ProxyProtocolV2Connection.class */
        private class ProxyProtocolV2Connection extends AbstractConnection implements Connection.UpgradeFrom, Connection.UpgradeTo {
            private static final int HEADER_LENGTH = 16;
            private final Connector _connector;
            private final ConnectionFactory _next;
            private final ByteBuffer _buffer;
            private boolean _local;
            private Family _family;
            private int _length;
            private boolean _headerParsed;

            protected ProxyProtocolV2Connection(EndPoint endp, Connector connector, ConnectionFactory next) {
                super(endp, connector.getExecutor());
                this._connector = connector;
                this._next = next;
                this._buffer = this._connector.getByteBufferPool().acquire(getInputBufferSize(), true);
            }

            @Override // org.eclipse.jetty.p023io.Connection.UpgradeTo
            public void onUpgradeTo(ByteBuffer buffer) {
                if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                    ProxyConnectionFactory.LOG.debug("Proxy v2 copying unconsumed buffer {}", BufferUtil.toDetailString(buffer));
                }
                BufferUtil.append(this._buffer, buffer);
            }

            @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
            public void onOpen() {
                onOpen();
                try {
                    parseHeader();
                    if (!this._headerParsed || this._buffer.remaining() < this._length) {
                        if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                            ProxyConnectionFactory.LOG.debug("Proxy v2 onOpen parsing fixed length packet ran out of bytes, marking as fillInterested", new Object[0]);
                        }
                        fillInterested();
                    } else {
                        if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                            ProxyConnectionFactory.LOG.debug("Proxy v2 onOpen parsing fixed length packet part done, now upgrading", new Object[0]);
                        }
                        parseBodyAndUpgrade();
                    }
                } catch (Exception x) {
                    ProxyConnectionFactory.LOG.warn("Proxy v2 error for {}", getEndPoint(), x);
                    releaseAndClose();
                }
            }

            @Override // org.eclipse.jetty.p023io.AbstractConnection
            public void onFillable() {
                try {
                    if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                        ProxyConnectionFactory.LOG.debug("Proxy v2 onFillable header parsed? ", Boolean.valueOf(this._headerParsed));
                    }
                    while (!this._headerParsed) {
                        int fill = getEndPoint().fill(this._buffer);
                        if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                            ProxyConnectionFactory.LOG.debug("Proxy v2 filled buffer with {} bytes", (long) fill);
                        }
                        if (fill < 0) {
                            this._connector.getByteBufferPool().release(this._buffer);
                            getEndPoint().shutdownOutput();
                            return;
                        } else if (fill == 0) {
                            fillInterested();
                            return;
                        } else {
                            parseHeader();
                        }
                    }
                    if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                        ProxyConnectionFactory.LOG.debug("Proxy v2 onFillable header parsed, length = {}, buffer = {}", Integer.valueOf(this._length), BufferUtil.toDetailString(this._buffer));
                    }
                    while (this._buffer.remaining() < this._length) {
                        int fill2 = getEndPoint().fill(this._buffer);
                        if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                            ProxyConnectionFactory.LOG.debug("Proxy v2 filled buffer with {} bytes", (long) fill2);
                        }
                        if (fill2 < 0) {
                            this._connector.getByteBufferPool().release(this._buffer);
                            getEndPoint().shutdownOutput();
                            return;
                        } else if (fill2 == 0) {
                            fillInterested();
                            return;
                        }
                    }
                    parseBodyAndUpgrade();
                } catch (Throwable x) {
                    ProxyConnectionFactory.LOG.warn("Proxy v2 error for " + getEndPoint(), x);
                    releaseAndClose();
                }
            }

            @Override // org.eclipse.jetty.p023io.Connection.UpgradeFrom
            public ByteBuffer onUpgradeFrom() {
                if (!this._buffer.hasRemaining()) {
                    return null;
                }
                ByteBuffer unconsumed = ByteBuffer.allocateDirect(this._buffer.remaining());
                unconsumed.put(this._buffer);
                unconsumed.flip();
                this._connector.getByteBufferPool().release(this._buffer);
                return unconsumed;
            }

            private void parseBodyAndUpgrade() throws IOException {
                int dp;
                int sp;
                InetAddress dst;
                InetAddress src;
                int nonProxyRemaining = this._buffer.remaining() - this._length;
                if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                    ProxyConnectionFactory.LOG.debug("Proxy v2 parsing body, length = {}, buffer = {}", Integer.valueOf(this._length), BufferUtil.toHexSummary(this._buffer));
                }
                if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                    ProxyConnectionFactory.LOG.debug("Proxy v2 body {} from {} for {}", this._next, BufferUtil.toHexSummary(this._buffer), this);
                }
                EndPoint endPoint = getEndPoint();
                if (!this._local) {
                    switch (this._family) {
                        case INET:
                            byte[] addr = new byte[4];
                            this._buffer.get(addr);
                            src = Inet4Address.getByAddress(addr);
                            this._buffer.get(addr);
                            dst = Inet4Address.getByAddress(addr);
                            sp = this._buffer.getChar();
                            dp = this._buffer.getChar();
                            break;
                        case INET6:
                            byte[] addr2 = new byte[16];
                            this._buffer.get(addr2);
                            src = Inet6Address.getByAddress(addr2);
                            this._buffer.get(addr2);
                            dst = Inet6Address.getByAddress(addr2);
                            sp = this._buffer.getChar();
                            dp = this._buffer.getChar();
                            break;
                        default:
                            throw new IllegalStateException();
                    }
                    ProxyEndPoint proxyEndPoint = new ProxyEndPoint(endPoint, new InetSocketAddress(src, sp), new InetSocketAddress(dst, dp));
                    endPoint = proxyEndPoint;
                    while (this._buffer.remaining() > nonProxyRemaining) {
                        int type = 255 & this._buffer.get();
                        int length = this._buffer.getChar();
                        byte[] value = new byte[length];
                        this._buffer.get(value);
                        if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                            ProxyConnectionFactory.LOG.debug(String.format("Proxy v2 T=%x L=%d V=%s for %s", Integer.valueOf(type), Integer.valueOf(length), TypeUtil.toHexString(value), this), new Object[0]);
                        }
                        switch (type) {
                            case 32:
                                switch (value[0] & 255) {
                                    case 1:
                                        int i = 5;
                                        while (i < length) {
                                            int i2 = i + 1;
                                            int subType = value[i] & 255;
                                            int i3 = i2 + 1;
                                            int i4 = i3 + 1;
                                            int subLength = ((value[i2] & 255) * 256) + (value[i3] & 255);
                                            byte[] subValue = new byte[subLength];
                                            System.arraycopy(value, i4, subValue, 0, subLength);
                                            i = i4 + subLength;
                                            switch (subType) {
                                                case 33:
                                                    proxyEndPoint.setAttribute(ProxyConnectionFactory.TLS_VERSION, new String(subValue, StandardCharsets.US_ASCII));
                                                    break;
                                            }
                                        }
                                        continue;
                                }
                        }
                    }
                    if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                        ProxyConnectionFactory.LOG.debug("Proxy v2 {} {}", getEndPoint(), proxyEndPoint.toString());
                    }
                } else {
                    this._buffer.position(this._buffer.position() + this._length);
                }
                if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                    ProxyConnectionFactory.LOG.debug("Proxy v2 parsing dynamic packet part is now done, upgrading to {}", ProxyV2ConnectionFactory.this._nextProtocol);
                }
                DetectorConnectionFactory.upgradeToConnectionFactory(this._next, this._connector, endPoint);
            }

            private void parseHeader() throws IOException {
                Transport transport;
                if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                    ProxyConnectionFactory.LOG.debug("Proxy v2 parsing fixed length packet part, buffer = {}", BufferUtil.toDetailString(this._buffer));
                }
                if (this._buffer.remaining() >= 16) {
                    if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                        ProxyConnectionFactory.LOG.debug("Proxy v2 header {} for {}", BufferUtil.toHexSummary(this._buffer), this);
                    }
                    for (byte signatureByte : ProxyV2ConnectionFactory.SIGNATURE) {
                        if (this._buffer.get() != signatureByte) {
                            throw new IOException("Proxy v2 bad PROXY signature");
                        }
                    }
                    int versionAndCommand = 255 & this._buffer.get();
                    if ((versionAndCommand & PacketOpcodes.ExecuteGadgetLuaRsp) != 32) {
                        throw new IOException("Proxy v2 bad PROXY version");
                    }
                    this._local = (versionAndCommand & 15) == 0;
                    int transportAndFamily = 255 & this._buffer.get();
                    switch (transportAndFamily >> 4) {
                        case 0:
                            this._family = Family.UNSPEC;
                            break;
                        case 1:
                            this._family = Family.INET;
                            break;
                        case 2:
                            this._family = Family.INET6;
                            break;
                        case 3:
                            this._family = Family.UNIX;
                            break;
                        default:
                            throw new IOException("Proxy v2 bad PROXY family");
                    }
                    switch (15 & transportAndFamily) {
                        case 0:
                            transport = Transport.UNSPEC;
                            break;
                        case 1:
                            transport = Transport.STREAM;
                            break;
                        case 2:
                            transport = Transport.DGRAM;
                            break;
                        default:
                            throw new IOException("Proxy v2 bad PROXY family");
                    }
                    this._length = this._buffer.getChar();
                    if (!this._local && (this._family == Family.UNSPEC || this._family == Family.UNIX || transport != Transport.STREAM)) {
                        throw new IOException(String.format("Proxy v2 unsupported PROXY mode 0x%x,0x%x", Integer.valueOf(versionAndCommand), Integer.valueOf(transportAndFamily)));
                    } else if (this._length > ProxyV2ConnectionFactory.this.getMaxProxyHeader()) {
                        throw new IOException(String.format("Proxy v2 Unsupported PROXY mode 0x%x,0x%x,0x%x", Integer.valueOf(versionAndCommand), Integer.valueOf(transportAndFamily), Integer.valueOf(this._length)));
                    } else {
                        if (ProxyConnectionFactory.LOG.isDebugEnabled()) {
                            ProxyConnectionFactory.LOG.debug("Proxy v2 fixed length packet part is now parsed", new Object[0]);
                        }
                        this._headerParsed = true;
                    }
                }
            }

            private void releaseAndClose() {
                this._connector.getByteBufferPool().release(this._buffer);
                close();
            }
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ProxyConnectionFactory$ProxyEndPoint.class */
    public static class ProxyEndPoint extends AttributesMap implements EndPoint {
        private final EndPoint _endp;
        private final InetSocketAddress _remote;
        private final InetSocketAddress _local;

        public ProxyEndPoint(EndPoint endp, InetSocketAddress remote, InetSocketAddress local) {
            this._endp = endp;
            this._remote = remote;
            this._local = local;
        }

        public EndPoint unwrap() {
            return this._endp;
        }

        @Override // org.eclipse.jetty.p023io.EndPoint, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this._endp.close();
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public int fill(ByteBuffer buffer) throws IOException {
            return this._endp.fill(buffer);
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public void fillInterested(Callback callback) throws ReadPendingException {
            this._endp.fillInterested(callback);
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public boolean flush(ByteBuffer... buffer) throws IOException {
            return this._endp.flush(buffer);
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public Connection getConnection() {
            return this._endp.getConnection();
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public void setConnection(Connection connection) {
            this._endp.setConnection(connection);
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public long getCreatedTimeStamp() {
            return this._endp.getCreatedTimeStamp();
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public long getIdleTimeout() {
            return this._endp.getIdleTimeout();
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public void setIdleTimeout(long idleTimeout) {
            this._endp.setIdleTimeout(idleTimeout);
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public InetSocketAddress getLocalAddress() {
            return this._local;
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public InetSocketAddress getRemoteAddress() {
            return this._remote;
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public Object getTransport() {
            return this._endp.getTransport();
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public boolean isFillInterested() {
            return this._endp.isFillInterested();
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public boolean isInputShutdown() {
            return this._endp.isInputShutdown();
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public boolean isOpen() {
            return this._endp.isOpen();
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public boolean isOptimizedForDirectBuffers() {
            return this._endp.isOptimizedForDirectBuffers();
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public boolean isOutputShutdown() {
            return this._endp.isOutputShutdown();
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public void onClose() {
            this._endp.onClose();
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public void onOpen() {
            this._endp.onOpen();
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public void shutdownOutput() {
            this._endp.shutdownOutput();
        }

        @Override // org.eclipse.jetty.util.AttributesMap
        public String toString() {
            return String.format("%s@%x[remote=%s,local=%s,endpoint=%s]", getClass().getSimpleName(), Integer.valueOf(hashCode()), this._remote, this._local, this._endp);
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public boolean tryFillInterested(Callback callback) {
            return this._endp.tryFillInterested(callback);
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public void upgrade(Connection newConnection) {
            this._endp.upgrade(newConnection);
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public void write(Callback callback, ByteBuffer... buffers) throws WritePendingException {
            this._endp.write(callback, buffers);
        }
    }
}
