package org.eclipse.jetty.server;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import org.eclipse.jetty.p023io.AbstractConnection;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.server.ConnectionFactory;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/DetectorConnectionFactory.class */
public class DetectorConnectionFactory extends AbstractConnectionFactory implements ConnectionFactory.Detecting {
    private static final Logger LOG = Log.getLogger(DetectorConnectionFactory.class);
    private final List<ConnectionFactory.Detecting> _detectingConnectionFactories;

    public DetectorConnectionFactory(ConnectionFactory.Detecting... detectingConnectionFactories) {
        super(toProtocolString(detectingConnectionFactories));
        this._detectingConnectionFactories = Arrays.asList(detectingConnectionFactories);
        for (ConnectionFactory.Detecting detectingConnectionFactory : detectingConnectionFactories) {
            addBean(detectingConnectionFactory);
        }
    }

    private static String toProtocolString(ConnectionFactory.Detecting... detectingConnectionFactories) {
        if (detectingConnectionFactories.length == 0) {
            throw new IllegalArgumentException("At least one detecting instance is required");
        }
        String protocol = (String) ((LinkedHashSet) Arrays.stream(detectingConnectionFactories).map((v0) -> {
            return v0.getProtocol();
        }).collect(Collectors.toCollection(LinkedHashSet::new))).stream().collect(Collectors.joining("|", "[", "]"));
        if (LOG.isDebugEnabled()) {
            LOG.debug("Detector generated protocol name : {}", protocol);
        }
        return protocol;
    }

    @Override // org.eclipse.jetty.server.ConnectionFactory.Detecting
    public ConnectionFactory.Detecting.Detection detect(ByteBuffer buffer) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Detector {} detecting from buffer {} using {}", getProtocol(), BufferUtil.toHexString(buffer), this._detectingConnectionFactories);
        }
        boolean needMoreBytes = true;
        for (ConnectionFactory.Detecting detectingConnectionFactory : this._detectingConnectionFactories) {
            ConnectionFactory.Detecting.Detection detection = detectingConnectionFactory.detect(buffer);
            if (detection == ConnectionFactory.Detecting.Detection.RECOGNIZED) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Detector {} recognized bytes using {}", getProtocol(), detection);
                }
                return ConnectionFactory.Detecting.Detection.RECOGNIZED;
            }
            needMoreBytes &= detection == ConnectionFactory.Detecting.Detection.NEED_MORE_BYTES;
        }
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            Object[] objArr = new Object[2];
            objArr[0] = getProtocol();
            objArr[1] = needMoreBytes ? "requires more bytes" : "failed to recognize bytes";
            logger.debug("Detector {} {}", objArr);
        }
        return needMoreBytes ? ConnectionFactory.Detecting.Detection.NEED_MORE_BYTES : ConnectionFactory.Detecting.Detection.NOT_RECOGNIZED;
    }

    /* access modifiers changed from: protected */
    public static void upgradeToConnectionFactory(ConnectionFactory connectionFactory, Connector connector, EndPoint endPoint) throws IllegalStateException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Upgrading to connection factory {}", connectionFactory);
        }
        if (connectionFactory == null) {
            throw new IllegalStateException("Cannot upgrade: connection factory must not be null for " + endPoint);
        }
        Connection nextConnection = connectionFactory.newConnection(connector, endPoint);
        if (!(nextConnection instanceof Connection.UpgradeTo)) {
            throw new IllegalStateException("Cannot upgrade: " + nextConnection + " does not implement " + Connection.UpgradeTo.class.getName() + " for " + endPoint);
        }
        endPoint.upgrade(nextConnection);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Upgraded to connection factory {} and released buffer", connectionFactory);
        }
    }

    protected void nextProtocol(Connector connector, EndPoint endPoint, ByteBuffer buffer) throws IllegalStateException {
        String nextProtocol = findNextProtocol(connector);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Detector {} detection unsuccessful, found '{}' as the next protocol to upgrade to", getProtocol(), nextProtocol);
        }
        if (nextProtocol == null) {
            throw new IllegalStateException("Cannot find protocol following '" + getProtocol() + "' in connector's protocol list " + connector.getProtocols() + " for " + endPoint);
        }
        upgradeToConnectionFactory(connector.getConnectionFactory(nextProtocol), connector, endPoint);
    }

    @Override // org.eclipse.jetty.server.ConnectionFactory
    public Connection newConnection(Connector connector, EndPoint endPoint) {
        return configure(new DetectorConnection(endPoint, connector), connector, endPoint);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/DetectorConnectionFactory$DetectorConnection.class */
    private class DetectorConnection extends AbstractConnection implements Connection.UpgradeFrom, Connection.UpgradeTo {
        private final Connector _connector;
        private final ByteBuffer _buffer;

        private DetectorConnection(EndPoint endp, Connector connector) {
            super(endp, connector.getExecutor());
            this._connector = connector;
            this._buffer = connector.getByteBufferPool().acquire(getInputBufferSize(), true);
        }

        @Override // org.eclipse.jetty.p023io.Connection.UpgradeTo
        public void onUpgradeTo(ByteBuffer buffer) {
            if (DetectorConnectionFactory.LOG.isDebugEnabled()) {
                DetectorConnectionFactory.LOG.debug("Detector {} copying unconsumed buffer {}", DetectorConnectionFactory.this.getProtocol(), BufferUtil.toDetailString(buffer));
            }
            BufferUtil.append(this._buffer, buffer);
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

        @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
        public void onOpen() {
            onOpen();
            if (!detectAndUpgrade()) {
                fillInterested();
            }
        }

        @Override // org.eclipse.jetty.p023io.AbstractConnection
        public void onFillable() {
            while (BufferUtil.space(this._buffer) > 0) {
                try {
                    int fill = getEndPoint().fill(this._buffer);
                    if (DetectorConnectionFactory.LOG.isDebugEnabled()) {
                        DetectorConnectionFactory.LOG.debug("Detector {} filled buffer with {} bytes", DetectorConnectionFactory.this.getProtocol(), Integer.valueOf(fill));
                    }
                    if (fill < 0) {
                        this._connector.getByteBufferPool().release(this._buffer);
                        getEndPoint().shutdownOutput();
                        return;
                    } else if (fill == 0) {
                        fillInterested();
                        return;
                    } else if (detectAndUpgrade()) {
                        return;
                    }
                } catch (Throwable x) {
                    DetectorConnectionFactory.LOG.warn("Detector {} error for {}", DetectorConnectionFactory.this.getProtocol(), getEndPoint(), x);
                    releaseAndClose();
                    return;
                }
            }
            DetectorConnectionFactory.LOG.warn("Detector {} failed to detect upgrade target on {} for {}", DetectorConnectionFactory.this.getProtocol(), DetectorConnectionFactory.this._detectingConnectionFactories, getEndPoint());
            releaseAndClose();
        }

        private boolean detectAndUpgrade() {
            if (!BufferUtil.isEmpty(this._buffer)) {
                if (DetectorConnectionFactory.LOG.isDebugEnabled()) {
                    DetectorConnectionFactory.LOG.debug("Detector {} performing detection with {} bytes", DetectorConnectionFactory.this.getProtocol(), Integer.valueOf(this._buffer.remaining()));
                }
                boolean notRecognized = true;
                for (ConnectionFactory.Detecting detectingConnectionFactory : DetectorConnectionFactory.this._detectingConnectionFactories) {
                    ConnectionFactory.Detecting.Detection detection = detectingConnectionFactory.detect(this._buffer);
                    if (DetectorConnectionFactory.LOG.isDebugEnabled()) {
                        DetectorConnectionFactory.LOG.debug("Detector {} performed detection from {} with {} which returned {}", DetectorConnectionFactory.this.getProtocol(), BufferUtil.toDetailString(this._buffer), detectingConnectionFactory, detection);
                    }
                    if (detection == ConnectionFactory.Detecting.Detection.RECOGNIZED) {
                        try {
                            Connection nextConnection = detectingConnectionFactory.newConnection(this._connector, getEndPoint());
                            if (!(nextConnection instanceof Connection.UpgradeTo)) {
                                throw new IllegalStateException("Cannot upgrade: " + nextConnection + " does not implement " + Connection.UpgradeTo.class.getName());
                            }
                            getEndPoint().upgrade(nextConnection);
                            if (!DetectorConnectionFactory.LOG.isDebugEnabled()) {
                                return true;
                            }
                            DetectorConnectionFactory.LOG.debug("Detector {} upgraded to {}", DetectorConnectionFactory.this.getProtocol(), nextConnection);
                            return true;
                        } catch (DetectionFailureException e) {
                            if (DetectorConnectionFactory.LOG.isDebugEnabled()) {
                                DetectorConnectionFactory.LOG.debug("Detector {} failed to upgrade, rethrowing", DetectorConnectionFactory.this.getProtocol(), e);
                            }
                            throw e;
                        } catch (Exception e2) {
                            if (DetectorConnectionFactory.LOG.isDebugEnabled()) {
                                DetectorConnectionFactory.LOG.debug("Detector {} failed to upgrade", DetectorConnectionFactory.this.getProtocol());
                            }
                            releaseAndClose();
                            throw new DetectionFailureException(e2);
                        }
                    } else {
                        notRecognized &= detection == ConnectionFactory.Detecting.Detection.NOT_RECOGNIZED;
                    }
                }
                if (!notRecognized) {
                    return false;
                }
                if (DetectorConnectionFactory.LOG.isDebugEnabled()) {
                    DetectorConnectionFactory.LOG.debug("Detector {} failed to detect a known protocol, falling back to nextProtocol()", DetectorConnectionFactory.this.getProtocol());
                }
                DetectorConnectionFactory.this.nextProtocol(this._connector, getEndPoint(), this._buffer);
                if (!DetectorConnectionFactory.LOG.isDebugEnabled()) {
                    return true;
                }
                DetectorConnectionFactory.LOG.debug("Detector {} call to nextProtocol() succeeded, assuming upgrade performed", DetectorConnectionFactory.this.getProtocol());
                return true;
            } else if (!DetectorConnectionFactory.LOG.isDebugEnabled()) {
                return false;
            } else {
                DetectorConnectionFactory.LOG.debug("Detector {} skipping detection on an empty buffer", DetectorConnectionFactory.this.getProtocol());
                return false;
            }
        }

        private void releaseAndClose() {
            if (DetectorConnectionFactory.LOG.isDebugEnabled()) {
                DetectorConnectionFactory.LOG.debug("Detector {} releasing buffer and closing", DetectorConnectionFactory.this.getProtocol());
            }
            this._connector.getByteBufferPool().release(this._buffer);
            close();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/DetectorConnectionFactory$DetectionFailureException.class */
    public static class DetectionFailureException extends RuntimeException {
        public DetectionFailureException(Throwable cause) {
            super(cause);
        }
    }
}
