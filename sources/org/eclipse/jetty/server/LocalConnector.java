package org.eclipse.jetty.server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.p023io.ByteArrayEndPoint;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.thread.Scheduler;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/LocalConnector.class */
public class LocalConnector extends AbstractConnector {
    private final BlockingQueue<LocalEndPoint> _connects;

    public LocalConnector(Server server, Executor executor, Scheduler scheduler, ByteBufferPool pool, int acceptors, ConnectionFactory... factories) {
        super(server, executor, scheduler, pool, acceptors, factories);
        this._connects = new LinkedBlockingQueue();
        setIdleTimeout(30000);
    }

    public LocalConnector(Server server) {
        this(server, null, null, null, -1, new HttpConnectionFactory());
    }

    public LocalConnector(Server server, SslContextFactory sslContextFactory) {
        this(server, null, null, null, -1, AbstractConnectionFactory.getFactories(sslContextFactory, new HttpConnectionFactory()));
    }

    public LocalConnector(Server server, ConnectionFactory connectionFactory) {
        this(server, null, null, null, -1, connectionFactory);
    }

    public LocalConnector(Server server, ConnectionFactory connectionFactory, SslContextFactory sslContextFactory) {
        this(server, null, null, null, -1, AbstractConnectionFactory.getFactories(sslContextFactory, connectionFactory));
    }

    @Override // org.eclipse.jetty.server.Connector
    public Object getTransport() {
        return this;
    }

    @Deprecated
    public String getResponses(String requests) throws Exception {
        return getResponses(requests, 5, TimeUnit.SECONDS);
    }

    @Deprecated
    public String getResponses(String requests, long idleFor, TimeUnit units) throws Exception {
        ByteBuffer result = getResponses(BufferUtil.toBuffer(requests, StandardCharsets.UTF_8), idleFor, units);
        if (result == null) {
            return null;
        }
        return BufferUtil.toString(result, StandardCharsets.UTF_8);
    }

    @Deprecated
    public ByteBuffer getResponses(ByteBuffer requestsBuffer) throws Exception {
        return getResponses(requestsBuffer, 5, TimeUnit.SECONDS);
    }

    @Deprecated
    public ByteBuffer getResponses(ByteBuffer requestsBuffer, long idleFor, TimeUnit units) throws Exception {
        if (LOG.isDebugEnabled()) {
            LOG.debug("requests {}", BufferUtil.toUTF8String(requestsBuffer));
        }
        LocalEndPoint endp = executeRequest(requestsBuffer);
        endp.waitUntilClosedOrIdleFor(idleFor, units);
        ByteBuffer responses = endp.takeOutput();
        if (endp.isOutputShutdown()) {
            endp.close();
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("responses {}", BufferUtil.toUTF8String(responses));
        }
        return responses;
    }

    public LocalEndPoint executeRequest(String rawRequest) {
        return executeRequest(BufferUtil.toBuffer(rawRequest, StandardCharsets.UTF_8));
    }

    private LocalEndPoint executeRequest(ByteBuffer rawRequest) {
        if (!isStarted()) {
            throw new IllegalStateException("!STARTED");
        }
        LocalEndPoint endp = new LocalEndPoint();
        endp.addInput(rawRequest);
        this._connects.add(endp);
        return endp;
    }

    public LocalEndPoint connect() {
        LocalEndPoint endp = new LocalEndPoint();
        this._connects.add(endp);
        return endp;
    }

    @Override // org.eclipse.jetty.server.AbstractConnector
    protected void accept(int acceptorID) throws IOException, InterruptedException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("accepting {}", (long) acceptorID);
        }
        LocalEndPoint endPoint = this._connects.take();
        Connection connection = getDefaultConnectionFactory().newConnection(this, endPoint);
        endPoint.setConnection(connection);
        endPoint.onOpen();
        onEndPointOpened(endPoint);
        connection.onOpen();
    }

    public ByteBuffer getResponse(ByteBuffer requestsBuffer) throws Exception {
        return getResponse(requestsBuffer, false, 10L, TimeUnit.SECONDS);
    }

    public ByteBuffer getResponse(ByteBuffer requestBuffer, long time, TimeUnit unit) throws Exception {
        boolean head = BufferUtil.toString(requestBuffer).toLowerCase().startsWith("head ");
        if (LOG.isDebugEnabled()) {
            LOG.debug("requests {}", BufferUtil.toUTF8String(requestBuffer));
        }
        return executeRequest(requestBuffer).waitForResponse(head, time, unit);
    }

    public ByteBuffer getResponse(ByteBuffer requestBuffer, boolean head, long time, TimeUnit unit) throws Exception {
        if (LOG.isDebugEnabled()) {
            LOG.debug("requests {}", BufferUtil.toUTF8String(requestBuffer));
        }
        return executeRequest(requestBuffer).waitForResponse(head, time, unit);
    }

    public String getResponse(String rawRequest) throws Exception {
        return getResponse(rawRequest, false, 30L, TimeUnit.SECONDS);
    }

    public String getResponse(String rawRequest, long time, TimeUnit unit) throws Exception {
        boolean head = rawRequest.toLowerCase().startsWith("head ");
        ByteBuffer requestsBuffer = BufferUtil.toBuffer(rawRequest, StandardCharsets.ISO_8859_1);
        if (LOG.isDebugEnabled()) {
            LOG.debug("request {}", BufferUtil.toUTF8String(requestsBuffer));
        }
        return BufferUtil.toString(executeRequest(requestsBuffer).waitForResponse(head, time, unit), StandardCharsets.ISO_8859_1);
    }

    public String getResponse(String rawRequest, boolean head, long time, TimeUnit unit) throws Exception {
        ByteBuffer requestsBuffer = BufferUtil.toBuffer(rawRequest, StandardCharsets.ISO_8859_1);
        if (LOG.isDebugEnabled()) {
            LOG.debug("request {}", BufferUtil.toUTF8String(requestsBuffer));
        }
        return BufferUtil.toString(executeRequest(requestsBuffer).waitForResponse(head, time, unit), StandardCharsets.ISO_8859_1);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/LocalConnector$LocalEndPoint.class */
    public class LocalEndPoint extends ByteArrayEndPoint {
        private final CountDownLatch _closed = new CountDownLatch(1);
        private ByteBuffer _responseData;

        public LocalEndPoint() {
            super(LocalConnector.this.getScheduler(), LocalConnector.this.getIdleTimeout());
            setGrowOutput(true);
        }

        @Override // org.eclipse.jetty.p023io.ByteArrayEndPoint
        protected void execute(Runnable task) {
            LocalConnector.this.getExecutor().execute(task);
        }

        @Override // org.eclipse.jetty.p023io.AbstractEndPoint, org.eclipse.jetty.p023io.IdleTimeout, org.eclipse.jetty.p023io.EndPoint
        public void onClose() {
            Connection connection = getConnection();
            if (connection != null) {
                connection.onClose();
            }
            LocalConnector.this.onEndPointClosed(this);
            onClose();
            this._closed.countDown();
        }

        @Override // org.eclipse.jetty.p023io.ByteArrayEndPoint, org.eclipse.jetty.p023io.AbstractEndPoint
        public void doShutdownOutput() {
            shutdownOutput();
            close();
        }

        public void waitUntilClosed() {
            while (isOpen()) {
                try {
                } catch (Exception e) {
                    AbstractConnector.LOG.warn(e);
                }
                if (!this._closed.await(10, TimeUnit.SECONDS)) {
                    return;
                }
            }
        }

        public void waitUntilClosedOrIdleFor(long idleFor, TimeUnit units) {
            Thread.yield();
            int size = getOutput().remaining();
            while (isOpen()) {
                try {
                    if (!this._closed.await(idleFor, units)) {
                        if (size != getOutput().remaining()) {
                            size = getOutput().remaining();
                        } else if (AbstractConnector.LOG.isDebugEnabled()) {
                            AbstractConnector.LOG.debug("idle for {} {}", Long.valueOf(idleFor), units);
                            return;
                        } else {
                            return;
                        }
                    }
                } catch (Exception e) {
                    AbstractConnector.LOG.warn(e);
                }
            }
        }

        public ByteBuffer getResponseData() {
            return this._responseData;
        }

        public String getResponse() throws Exception {
            return getResponse(false, 30, TimeUnit.SECONDS);
        }

        public String getResponse(boolean head, long time, TimeUnit unit) throws Exception {
            ByteBuffer response = waitForResponse(head, time, unit);
            if (response != null) {
                return BufferUtil.toString(response);
            }
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0056, code lost:
            r0.atEOF();
            r0.parseNext(org.eclipse.jetty.util.BufferUtil.EMPTY_BUFFER);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.nio.ByteBuffer waitForResponse(boolean r7, long r8, java.util.concurrent.TimeUnit r10) throws java.lang.Exception {
            /*
            // Method dump skipped, instructions count: 285
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.LocalConnector.LocalEndPoint.waitForResponse(boolean, long, java.util.concurrent.TimeUnit):java.nio.ByteBuffer");
        }
    }
}
