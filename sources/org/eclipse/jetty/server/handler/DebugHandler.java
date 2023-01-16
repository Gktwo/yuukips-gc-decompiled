package org.eclipse.jetty.server.handler;

import dev.morphia.mapping.Mapper;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.server.AbstractConnector;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.util.DateCache;
import org.eclipse.jetty.util.RolloverFileOutputStream;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/DebugHandler.class */
public class DebugHandler extends HandlerWrapper implements Connection.Listener {
    private DateCache _date = new DateCache("HH:mm:ss", Locale.US);
    private OutputStream _out;
    private PrintStream _print;

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Response base_response = baseRequest.getResponse();
        Thread thread = Thread.currentThread();
        String old_name = thread.getName();
        boolean retry = false;
        String name = (String) request.getAttribute("org.eclipse.jetty.thread.name");
        if (name == null) {
            name = old_name + EmitterKt.COMMENT_PREFIX + baseRequest.getHttpURI();
        } else {
            retry = true;
        }
        try {
            try {
                try {
                    try {
                        try {
                            if (retry) {
                                print(name, "RESUME");
                            } else {
                                print(name, "REQUEST " + baseRequest.getRemoteAddr() + " " + request.getMethod() + " " + baseRequest.getHeader("Cookie") + "; " + baseRequest.getHeader("User-Agent"));
                            }
                            thread.setName(name);
                            getHandler().handle(target, baseRequest, request, response);
                            thread.setName(old_name);
                            if (baseRequest.getHttpChannelState().isAsyncStarted()) {
                                request.setAttribute("org.eclipse.jetty.thread.name", name);
                                print(name, "ASYNC");
                                return;
                            }
                            print(name, "RESPONSE " + base_response.getStatus() + (0 == 0 ? "" : "/" + ((String) null)) + " " + base_response.getContentType());
                        } catch (Error e) {
                            e.toString();
                            throw e;
                        }
                    } catch (RuntimeException rte) {
                        rte.toString();
                        throw rte;
                    }
                } catch (ServletException cause) {
                    String str = cause.toString() + EmitterKt.COMMENT_PREFIX + cause.getCause();
                    throw cause;
                }
            } catch (IOException ioe) {
                ioe.toString();
                throw ioe;
            }
        } catch (Throwable th) {
            thread.setName(old_name);
            if (baseRequest.getHttpChannelState().isAsyncStarted()) {
                request.setAttribute("org.eclipse.jetty.thread.name", name);
                print(name, "ASYNC");
            } else {
                print(name, "RESPONSE " + base_response.getStatus() + (0 == 0 ? "" : "/" + ((String) null)) + " " + base_response.getContentType());
            }
            throw th;
        }
    }

    private void print(String name, String message) {
        long now = System.currentTimeMillis();
        String d = this._date.formatNow(now);
        int ms = (int) (now % 1000);
        this._print.println(d + (ms > 99 ? Mapper.IGNORED_FIELDNAME : ms > 9 ? ".0" : ".00") + ms + EmitterKt.COMMENT_PREFIX + name + " " + message);
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (this._out == null) {
            this._out = new RolloverFileOutputStream("./logs/yyyy_mm_dd.debug.log", true);
        }
        this._print = new PrintStream(this._out);
        Connector[] connectors = getServer().getConnectors();
        for (Connector connector : connectors) {
            if (connector instanceof AbstractConnector) {
                connector.addBean(this, false);
            }
        }
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        doStop();
        this._print.close();
        Connector[] connectors = getServer().getConnectors();
        for (Connector connector : connectors) {
            if (connector instanceof AbstractConnector) {
                connector.removeBean(this);
            }
        }
    }

    public OutputStream getOutputStream() {
        return this._out;
    }

    public void setOutputStream(OutputStream out) {
        this._out = out;
    }

    @Override // org.eclipse.jetty.p023io.Connection.Listener
    public void onOpened(Connection connection) {
        print(Thread.currentThread().getName(), "OPENED " + connection.toString());
    }

    @Override // org.eclipse.jetty.p023io.Connection.Listener
    public void onClosed(Connection connection) {
        print(Thread.currentThread().getName(), "CLOSED " + connection.toString());
    }
}
