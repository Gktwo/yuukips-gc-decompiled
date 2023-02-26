package org.eclipse.jetty.server.handler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.C5739IO;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/DefaultHandler.class */
public class DefaultHandler extends AbstractHandler {
    private static final Logger LOG = Log.getLogger(DefaultHandler.class);
    final long _faviconModified;
    final byte[] _favicon;
    boolean _serveIcon;
    boolean _showContexts;

    public DefaultHandler() {
        byte[] favbytes;
        try {
            this._faviconModified = (System.currentTimeMillis() / 1000) * 1000;
            this._serveIcon = true;
            this._showContexts = true;
            favbytes = null;
            try {
                URL fav = getClass().getClassLoader().getResource("org/eclipse/jetty/favicon.ico");
                if (fav != null) {
                    favbytes = C5739IO.readBytes(Resource.newResource(fav).getInputStream());
                }
                this._favicon = favbytes;
            } catch (Exception e) {
                LOG.warn(e);
                this._favicon = favbytes;
            }
        } catch (Throwable th) {
            this._favicon = favbytes;
            throw th;
        }
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!response.isCommitted() && !baseRequest.isHandled()) {
            baseRequest.setHandled(true);
            String method = request.getMethod();
            if (!this._serveIcon || this._favicon == null || !HttpMethod.GET.m40is(method) || !target.equals("/favicon.ico")) {
                if (!this._showContexts || !HttpMethod.GET.m40is(method) || !request.getRequestURI().equals("/")) {
                    response.sendError(404);
                    return;
                }
                response.setStatus(404);
                response.setContentType(MimeTypes.Type.TEXT_HTML_UTF_8.toString());
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                try {
                    OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                    writer.append((CharSequence) "<!DOCTYPE html>\n");
                    writer.append((CharSequence) "<html lang=\"en\">\n<head>\n");
                    writer.append((CharSequence) "<title>Error 404 - Not Found</title>\n");
                    writer.append((CharSequence) "<meta charset=\"utf-8\">\n");
                    writer.append((CharSequence) "<style>body { font-family: sans-serif; } table, td { border: 1px solid #333; } td, th { padding: 5px; } thead, tfoot { background-color: #333; color: #fff; } </style>\n");
                    writer.append((CharSequence) "</head>\n<body>\n");
                    writer.append((CharSequence) "<h2>Error 404 - Not Found.</h2>\n");
                    writer.append((CharSequence) "<p>No context on this server matched or handled this request.</p>\n");
                    writer.append((CharSequence) "<p>Contexts known to this server are:</p>\n");
                    Server server = getServer();
                    Handler[] handlers = server == null ? null : server.getChildHandlersByClass(ContextHandler.class);
                    writer.append((CharSequence) "<table class=\"contexts\"><thead><tr>");
                    writer.append((CharSequence) "<th>Context Path</th>");
                    writer.append((CharSequence) "<th>Display Name</th>");
                    writer.append((CharSequence) "<th>Status</th>");
                    writer.append((CharSequence) "<th>LifeCycle</th>");
                    writer.append((CharSequence) "</tr></thead><tbody>\n");
                    int i = 0;
                    while (handlers != null && i < handlers.length) {
                        writer.append((CharSequence) "<tr><td>");
                        ContextHandler context = (ContextHandler) handlers[i];
                        String contextPath = context.getContextPath();
                        String href = URIUtil.encodePath(contextPath);
                        if (contextPath.length() > 1 && !contextPath.endsWith("/")) {
                            href = href + '/';
                        }
                        if (context.isRunning()) {
                            writer.append((CharSequence) "<a href=\"").append((CharSequence) href).append((CharSequence) "\">");
                        }
                        writer.append((CharSequence) StringUtil.replace(contextPath, "%", "&#37;"));
                        if (context.isRunning()) {
                            writer.append((CharSequence) "</a>");
                        }
                        writer.append((CharSequence) "</td><td>");
                        if (StringUtil.isNotBlank(context.getDisplayName())) {
                            writer.append((CharSequence) StringUtil.sanitizeXmlString(context.getDisplayName()));
                        }
                        writer.append((CharSequence) "&nbsp;</td><td>");
                        if (context.isAvailable()) {
                            writer.append((CharSequence) "Available");
                        } else {
                            writer.append((CharSequence) "<em>Not</em> Available");
                        }
                        writer.append((CharSequence) "</td><td>");
                        writer.append((CharSequence) context.getState());
                        writer.append((CharSequence) "</td></tr>\n");
                        i++;
                    }
                    writer.append((CharSequence) "</tbody></table><hr/>\n");
                    writer.append((CharSequence) "<a href=\"https://eclipse.org/jetty\"><img alt=\"icon\" src=\"/favicon.ico\"/></a>&nbsp;");
                    writer.append((CharSequence) "<a href=\"https://eclipse.org/jetty\">Powered by Eclipse Jetty:// Server</a><hr/>\n");
                    writer.append((CharSequence) "</body>\n</html>\n");
                    writer.flush();
                    byte[] content = outputStream.toByteArray();
                    response.setContentLength(content.length);
                    OutputStream out = response.getOutputStream();
                    try {
                        out.write(content);
                        if (out != null) {
                            out.close();
                        }
                        writer.close();
                        outputStream.close();
                    } catch (Throwable th) {
                        if (out != null) {
                            try {
                                out.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } else if (request.getDateHeader(HttpHeader.IF_MODIFIED_SINCE.toString()) == this._faviconModified) {
                response.setStatus(304);
            } else {
                response.setStatus(200);
                response.setContentType("image/x-icon");
                response.setContentLength(this._favicon.length);
                response.setDateHeader(HttpHeader.LAST_MODIFIED.toString(), this._faviconModified);
                response.setHeader(HttpHeader.CACHE_CONTROL.toString(), "max-age=360000,public");
                response.getOutputStream().write(this._favicon);
            }
        }
    }

    public boolean getServeIcon() {
        return this._serveIcon;
    }

    public void setServeIcon(boolean serveIcon) {
        this._serveIcon = serveIcon;
    }

    public boolean getShowContexts() {
        return this._showContexts;
    }

    public void setShowContexts(boolean show) {
        this._showContexts = show;
    }
}
