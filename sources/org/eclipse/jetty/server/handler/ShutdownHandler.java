package org.eclipse.jetty.server.handler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.NetworkConnector;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ShutdownHandler.class */
public class ShutdownHandler extends HandlerWrapper {
    private static final Logger LOG = Log.getLogger(ShutdownHandler.class);
    private final String _shutdownToken;
    private boolean _sendShutdownAtStart;
    private boolean _exitJvm;

    @Deprecated
    public ShutdownHandler(Server server, String shutdownToken) {
        this(shutdownToken);
    }

    public ShutdownHandler(String shutdownToken) {
        this(shutdownToken, false, false);
    }

    public ShutdownHandler(String shutdownToken, boolean exitJVM, boolean sendShutdownAtStart) {
        this._exitJvm = false;
        this._shutdownToken = shutdownToken;
        setExitJvm(exitJVM);
        setSendShutdownAtStart(sendShutdownAtStart);
    }

    public void sendShutdown() throws IOException {
        URL url = new URL(getServerUrl() + "/shutdown?token=" + this._shutdownToken);
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.getResponseCode();
            LOG.info("Shutting down " + url + ": " + connection.getResponseCode() + " " + connection.getResponseMessage(), new Object[0]);
        } catch (SocketException e) {
            LOG.debug("Not running", new Object[0]);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private String getServerUrl() {
        NetworkConnector connector = null;
        Connector[] connectors = getServer().getConnectors();
        int length = connectors.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Connector c = connectors[i];
            if (c instanceof NetworkConnector) {
                connector = (NetworkConnector) c;
                break;
            }
            i++;
        }
        if (connector == null) {
            return "http://localhost";
        }
        return "http://localhost:" + connector.getPort();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        doStart();
        if (this._sendShutdownAtStart) {
            sendShutdown();
        }
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!target.equals("/shutdown")) {
            handle(target, baseRequest, request, response);
        } else if (!request.getMethod().equals("POST")) {
            response.sendError(400);
        } else if (!hasCorrectSecurityToken(request)) {
            LOG.warn("Unauthorized tokenless shutdown attempt from " + request.getRemoteAddr(), new Object[0]);
            response.sendError(401);
        } else if (!requestFromLocalhost(baseRequest)) {
            LOG.warn("Unauthorized non-loopback shutdown attempt from " + request.getRemoteAddr(), new Object[0]);
            response.sendError(401);
        } else {
            LOG.info("Shutting down by request from " + request.getRemoteAddr(), new Object[0]);
            doShutdown(baseRequest, response);
        }
    }

    protected void doShutdown(Request baseRequest, HttpServletResponse response) throws IOException {
        for (Connector connector : getServer().getConnectors()) {
            connector.shutdown();
        }
        baseRequest.setHandled(true);
        response.setStatus(200);
        response.flushBuffer();
        final Server server = getServer();
        new Thread() { // from class: org.eclipse.jetty.server.handler.ShutdownHandler.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    ShutdownHandler.this.shutdownServer(server);
                } catch (InterruptedException e) {
                    ShutdownHandler.LOG.ignore(e);
                } catch (Exception e2) {
                    throw new RuntimeException("Shutting down server", e2);
                }
            }
        }.start();
    }

    private boolean requestFromLocalhost(Request request) {
        InetSocketAddress addr = request.getRemoteInetSocketAddress();
        if (addr == null) {
            return false;
        }
        return addr.getAddress().isLoopbackAddress();
    }

    private boolean hasCorrectSecurityToken(HttpServletRequest request) {
        String tok = request.getParameter("token");
        if (LOG.isDebugEnabled()) {
            LOG.debug("Token: {}", tok);
        }
        return this._shutdownToken.equals(tok);
    }

    /* access modifiers changed from: private */
    public void shutdownServer(Server server) throws Exception {
        server.stop();
        if (this._exitJvm) {
            System.exit(0);
        }
    }

    public void setExitJvm(boolean exitJvm) {
        this._exitJvm = exitJvm;
    }

    public boolean isSendShutdownAtStart() {
        return this._sendShutdownAtStart;
    }

    public void setSendShutdownAtStart(boolean sendShutdownAtStart) {
        this._sendShutdownAtStart = sendShutdownAtStart;
    }

    public String getShutdownToken() {
        return this._shutdownToken;
    }

    public boolean isExitJvm() {
        return this._exitJvm;
    }
}
