package org.eclipse.jetty.server.handler;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.p023io.ByteBufferOutputStream;
import org.eclipse.jetty.server.Dispatcher;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.QuotedStringTokenizer;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.quartz.jobs.p027ee.mail.SendMailJob;
import p013io.javalin.http.ContentType;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ErrorHandler.class */
public class ErrorHandler extends AbstractHandler {
    private static final Logger LOG = Log.getLogger(ErrorHandler.class);
    public static final String ERROR_PAGE = "org.eclipse.jetty.server.error_page";
    public static final String ERROR_CONTEXT = "org.eclipse.jetty.server.error_context";
    public static final String ERROR_CHARSET = "org.eclipse.jetty.server.error_charset";
    boolean _showServlet = true;
    boolean _showStacks = true;
    boolean _disableStacks = false;
    boolean _showMessageInTitle = true;
    String _cacheControl = "must-revalidate,no-cache,no-store";

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ErrorHandler$ErrorPageMapper.class */
    public interface ErrorPageMapper {
        String getErrorPage(HttpServletRequest httpServletRequest);
    }

    public boolean errorPageForMethod(String method) {
        char c = 65535;
        switch (method.hashCode()) {
            case 70454:
                if (method.equals("GET")) {
                    c = 0;
                    break;
                }
                break;
            case 2213344:
                if (method.equals("HEAD")) {
                    c = 2;
                    break;
                }
                break;
            case 2461856:
                if (method.equals("POST")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doError(target, baseRequest, request, response);
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler
    public void doError(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cacheControl = getCacheControl();
        if (cacheControl != null) {
            response.setHeader(HttpHeader.CACHE_CONTROL.asString(), cacheControl);
        }
        String errorPage = this instanceof ErrorPageMapper ? ((ErrorPageMapper) this).getErrorPage(request) : null;
        ContextHandler.Context context = baseRequest.getErrorContext();
        Dispatcher errorDispatcher = (errorPage == null || context == null) ? null : (Dispatcher) context.getRequestDispatcher(errorPage);
        try {
            if (errorDispatcher != null) {
                try {
                    errorDispatcher.error(request, response);
                    baseRequest.setHandled(true);
                    return;
                } catch (ServletException e) {
                    LOG.debug(e);
                    if (response.isCommitted()) {
                        baseRequest.setHandled(true);
                        return;
                    }
                }
            }
            String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
            if (message == null) {
                message = baseRequest.getResponse().getReason();
            }
            generateAcceptableResponse(baseRequest, request, response, response.getStatus(), message);
            baseRequest.setHandled(true);
        } catch (Throwable th) {
            baseRequest.setHandled(true);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void generateAcceptableResponse(org.eclipse.jetty.server.Request r9, javax.servlet.http.HttpServletRequest r10, javax.servlet.http.HttpServletResponse r11, int r12, java.lang.String r13) throws java.io.IOException {
        /*
            r8 = this;
            r0 = r9
            org.eclipse.jetty.http.HttpFields r0 = r0.getHttpFields()
            org.eclipse.jetty.http.HttpHeader r1 = org.eclipse.jetty.http.HttpHeader.ACCEPT
            java.util.function.ToIntFunction<java.lang.String> r2 = org.eclipse.jetty.http.QuotedQualityCSV.MOST_SPECIFIC_MIME_ORDERING
            java.util.List r0 = r0.getQualityCSV(r1, r2)
            r14 = r0
            r0 = r14
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x003a
            r0 = r9
            org.eclipse.jetty.http.HttpFields r0 = r0.getHttpFields()
            org.eclipse.jetty.http.HttpHeader r1 = org.eclipse.jetty.http.HttpHeader.ACCEPT
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x003a
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            org.eclipse.jetty.http.MimeTypes$Type r6 = org.eclipse.jetty.http.MimeTypes.Type.TEXT_HTML
            java.lang.String r6 = r6.asString()
            r0.generateAcceptableResponse(r1, r2, r3, r4, r5, r6)
            goto L_0x007f
        L_0x003a:
            r0 = r14
            java.util.Iterator r0 = r0.iterator()
            r15 = r0
        L_0x0043:
            r0 = r15
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x007f
            r0 = r15
            java.lang.Object r0 = r0.next()
            java.lang.String r0 = (java.lang.String) r0
            r16 = r0
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r16
            r0.generateAcceptableResponse(r1, r2, r3, r4, r5, r6)
            r0 = r11
            boolean r0 = r0.isCommitted()
            if (r0 != 0) goto L_0x007f
            r0 = r9
            org.eclipse.jetty.server.Response r0 = r0.getResponse()
            boolean r0 = r0.isWritingOrStreaming()
            if (r0 == 0) goto L_0x007c
            goto L_0x007f
        L_0x007c:
            goto L_0x0043
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.handler.ErrorHandler.generateAcceptableResponse(org.eclipse.jetty.server.Request, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, int, java.lang.String):void");
    }

    @Deprecated
    protected Writer getAcceptableWriter(Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> acceptable = baseRequest.getHttpFields().getQualityCSV(HttpHeader.ACCEPT_CHARSET);
        if (acceptable.isEmpty()) {
            response.setCharacterEncoding(StandardCharsets.ISO_8859_1.name());
            return response.getWriter();
        }
        for (String charset : acceptable) {
            try {
                if ("*".equals(charset)) {
                    response.setCharacterEncoding(StandardCharsets.UTF_8.name());
                } else {
                    response.setCharacterEncoding(Charset.forName(charset).name());
                }
                return response.getWriter();
            } catch (Exception e) {
                LOG.ignore(e);
            }
        }
        return null;
    }

    protected void generateAcceptableResponse(Request baseRequest, HttpServletRequest request, HttpServletResponse response, int code, String message, String contentType) throws IOException {
        MimeTypes.Type type;
        Charset charset = null;
        List<String> acceptable = baseRequest.getHttpFields().getQualityCSV(HttpHeader.ACCEPT_CHARSET);
        if (!acceptable.isEmpty()) {
            Iterator<String> it = acceptable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String name = it.next();
                if ("*".equals(name)) {
                    charset = StandardCharsets.UTF_8;
                    break;
                }
                try {
                    charset = Charset.forName(name);
                } catch (Exception e) {
                    LOG.ignore(e);
                }
            }
            if (charset == null) {
                return;
            }
        }
        char c = 65535;
        switch (contentType.hashCode()) {
            case -1082243251:
                if (contentType.equals(ContentType.HTML)) {
                    c = 0;
                    break;
                }
                break;
            case -1082184566:
                if (contentType.equals("text/json")) {
                    c = 3;
                    break;
                }
                break;
            case -877022264:
                if (contentType.equals("text/*")) {
                    c = 1;
                    break;
                }
                break;
            case -43840953:
                if (contentType.equals(ContentType.JSON)) {
                    c = 4;
                    break;
                }
                break;
            case 41861:
                if (contentType.equals("*/*")) {
                    c = 2;
                    break;
                }
                break;
            case 817335912:
                if (contentType.equals(ContentType.PLAIN)) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                type = MimeTypes.Type.TEXT_HTML;
                if (charset == null) {
                    charset = StandardCharsets.ISO_8859_1;
                    break;
                }
                break;
            case 3:
            case 4:
                type = MimeTypes.Type.TEXT_JSON;
                if (charset == null) {
                    charset = StandardCharsets.UTF_8;
                    break;
                }
                break;
            case 5:
                type = MimeTypes.Type.TEXT_PLAIN;
                if (charset == null) {
                    charset = StandardCharsets.ISO_8859_1;
                    break;
                }
                break;
            default:
                return;
        }
        while (true) {
            try {
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(new ByteBufferOutputStream(baseRequest.getResponse().getHttpOutput().getBuffer()), charset));
                switch (type) {
                    case TEXT_HTML:
                        response.setContentType(MimeTypes.Type.TEXT_HTML.asString());
                        response.setCharacterEncoding(charset.name());
                        request.setAttribute(ERROR_CHARSET, charset);
                        handleErrorPage(request, writer, code, message);
                        break;
                    case TEXT_JSON:
                        response.setContentType(contentType);
                        writeErrorJson(request, writer, code, message);
                        break;
                    case TEXT_PLAIN:
                        response.setContentType(MimeTypes.Type.TEXT_PLAIN.asString());
                        response.setCharacterEncoding(charset.name());
                        writeErrorPlain(request, writer, code, message);
                        break;
                    default:
                        throw new IllegalStateException();
                }
                writer.flush();
            } catch (BufferOverflowException e2) {
                LOG.warn("Error page too large: {} {} {}", Integer.valueOf(code), message, request);
                if (LOG.isDebugEnabled()) {
                    LOG.warn(e2);
                }
                baseRequest.getResponse().resetContent();
                if (!this._disableStacks) {
                    LOG.info("Disabling showsStacks for " + this, new Object[0]);
                    this._disableStacks = true;
                }
            }
        }
        baseRequest.getHttpChannel().sendResponseAndComplete();
    }

    protected void handleErrorPage(HttpServletRequest request, Writer writer, int code, String message) throws IOException {
        writeErrorPage(request, writer, code, message, this._showStacks);
    }

    protected void writeErrorPage(HttpServletRequest request, Writer writer, int code, String message, boolean showStacks) throws IOException {
        if (message == null) {
            message = HttpStatus.getMessage(code);
        }
        writer.write("<html>\n<head>\n");
        writeErrorPageHead(request, writer, code, message);
        writer.write("</head>\n<body>");
        writeErrorPageBody(request, writer, code, message, showStacks);
        writer.write("\n</body>\n</html>\n");
    }

    protected void writeErrorPageHead(HttpServletRequest request, Writer writer, int code, String message) throws IOException {
        Charset charset = (Charset) request.getAttribute(ERROR_CHARSET);
        if (charset != null) {
            writer.write("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=");
            writer.write(charset.name());
            writer.write("\"/>\n");
        }
        writer.write("<title>Error ");
        String status = Integer.toString(code);
        writer.write(status);
        if (message != null && !message.equals(status)) {
            writer.write(32);
            writer.write(StringUtil.sanitizeXmlString(message));
        }
        writer.write("</title>\n");
    }

    protected void writeErrorPageBody(HttpServletRequest request, Writer writer, int code, String message, boolean showStacks) throws IOException {
        writeErrorPageMessage(request, writer, code, message, request.getRequestURI());
        if (showStacks && !this._disableStacks) {
            writeErrorPageStacks(request, writer);
        }
        Request.getBaseRequest(request).getHttpChannel().getHttpConfiguration().writePoweredBy(writer, "<hr/>", "<hr/>\n");
    }

    protected void writeErrorPageMessage(HttpServletRequest request, Writer writer, int code, String message, String uri) throws IOException {
        writer.write("<h2>HTTP ERROR ");
        String status = Integer.toString(code);
        writer.write(status);
        if (message != null && !message.equals(status)) {
            writer.write(32);
            writer.write(StringUtil.sanitizeXmlString(message));
        }
        writer.write("</h2>\n");
        writer.write("<table>\n");
        htmlRow(writer, "URI", uri);
        htmlRow(writer, "STATUS", status);
        htmlRow(writer, "MESSAGE", message);
        if (isShowServlet()) {
            htmlRow(writer, "SERVLET", request.getAttribute(RequestDispatcher.ERROR_SERVLET_NAME));
        }
        for (Throwable cause = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION); cause != null; cause = cause.getCause()) {
            htmlRow(writer, "CAUSED BY", cause);
        }
        writer.write("</table>\n");
    }

    private void htmlRow(Writer writer, String tag, Object value) throws IOException {
        writer.write("<tr><th>");
        writer.write(tag);
        writer.write(":</th><td>");
        if (value == null) {
            writer.write("-");
        } else {
            writer.write(StringUtil.sanitizeXmlString(value.toString()));
        }
        writer.write("</td></tr>\n");
    }

    private void writeErrorPlain(HttpServletRequest request, PrintWriter writer, int code, String message) {
        writer.write("HTTP ERROR ");
        writer.write(Integer.toString(code));
        writer.write(32);
        writer.write(StringUtil.sanitizeXmlString(message));
        writer.write("\n");
        writer.printf("URI: %s%n", request.getRequestURI());
        writer.printf("STATUS: %s%n", Integer.valueOf(code));
        writer.printf("MESSAGE: %s%n", message);
        if (isShowServlet()) {
            writer.printf("SERVLET: %s%n", request.getAttribute(RequestDispatcher.ERROR_SERVLET_NAME));
        }
        for (Throwable cause = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION); cause != null; cause = cause.getCause()) {
            writer.printf("CAUSED BY %s%n", cause);
            if (isShowStacks() && !this._disableStacks) {
                cause.printStackTrace(writer);
            }
        }
    }

    private void writeErrorJson(HttpServletRequest request, PrintWriter writer, int code, String message) {
        Object servlet = request.getAttribute(RequestDispatcher.ERROR_SERVLET_NAME);
        Map<String, String> json = new HashMap<>();
        json.put("url", request.getRequestURI());
        json.put("status", Integer.toString(code));
        json.put(SendMailJob.PROP_MESSAGE, message);
        if (isShowServlet() && servlet != null) {
            json.put("servlet", servlet.toString());
        }
        int c = 0;
        for (Throwable cause = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION); cause != null; cause = cause.getCause()) {
            c++;
            json.put("cause" + c, cause.toString());
        }
        writer.append((CharSequence) json.entrySet().stream().map(e -> {
            return QuotedStringTokenizer.quote((String) e.getKey()) + EmitterKt.COMMENT_PREFIX + QuotedStringTokenizer.quote(StringUtil.sanitizeXmlString((String) e.getValue()));
        }).collect(Collectors.joining(",\n", "{\n", "\n}")));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x004a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    protected void writeErrorPageStacks(javax.servlet.http.HttpServletRequest r5, java.io.Writer r6) throws java.io.IOException {
        /*
            r4 = this;
            r0 = r5
            java.lang.String r1 = "javax.servlet.error.exception"
            java.lang.Object r0 = r0.getAttribute(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L_0x0084
            r0 = r6
            java.lang.String r1 = "<h3>Caused by:</h3><pre>"
            r0.write(r1)
            java.io.StringWriter r0 = new java.io.StringWriter
            r1 = r0
            r1.<init>()
            r8 = r0
            java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch: Throwable -> 0x0068
            r1 = r0
            r2 = r8
            r1.<init>(r2)     // Catch: Throwable -> 0x0068
            r9 = r0
            r0 = r7
            r1 = r9
            r0.printStackTrace(r1)     // Catch: Throwable -> 0x004a, Throwable -> 0x0068
            r0 = r9
            r0.flush()     // Catch: Throwable -> 0x004a, Throwable -> 0x0068
            r0 = r4
            r1 = r6
            r2 = r8
            java.lang.StringBuffer r2 = r2.getBuffer()     // Catch: Throwable -> 0x004a, Throwable -> 0x0068
            java.lang.String r2 = r2.toString()     // Catch: Throwable -> 0x004a, Throwable -> 0x0068
            r0.write(r1, r2)     // Catch: Throwable -> 0x004a, Throwable -> 0x0068
            r0 = r9
            r0.close()     // Catch: Throwable -> 0x0068
            goto L_0x0060
        L_0x004a:
            r10 = move-exception
            r0 = r9
            r0.close()     // Catch: Throwable -> 0x0068, Throwable -> 0x0054
            goto L_0x005d
        L_0x0054:
            r11 = move-exception
            r0 = r10
            r1 = r11
            r0.addSuppressed(r1)     // Catch: Throwable -> 0x0068
        L_0x005d:
            r0 = r10
            throw r0     // Catch: Throwable -> 0x0068
        L_0x0060:
            r0 = r8
            r0.close()
            goto L_0x007e
        L_0x0068:
            r9 = move-exception
            r0 = r8
            r0.close()     // Catch: Throwable -> 0x0072
            goto L_0x007b
        L_0x0072:
            r10 = move-exception
            r0 = r9
            r1 = r10
            r0.addSuppressed(r1)
        L_0x007b:
            r0 = r9
            throw r0
        L_0x007e:
            r0 = r6
            java.lang.String r1 = "</pre>\n"
            r0.write(r1)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.handler.ErrorHandler.writeErrorPageStacks(javax.servlet.http.HttpServletRequest, java.io.Writer):void");
    }

    public ByteBuffer badMessageError(int status, String reason, HttpFields fields) {
        if (reason == null) {
            reason = HttpStatus.getMessage(status);
        }
        fields.put(HttpHeader.CONTENT_TYPE, MimeTypes.Type.TEXT_HTML_8859_1.asString());
        return BufferUtil.toBuffer("<h1>Bad Message " + status + "</h1><pre>reason: " + reason + "</pre>");
    }

    public String getCacheControl() {
        return this._cacheControl;
    }

    public void setCacheControl(String cacheControl) {
        this._cacheControl = cacheControl;
    }

    public boolean isShowServlet() {
        return this._showServlet;
    }

    public void setShowServlet(boolean showServlet) {
        this._showServlet = showServlet;
    }

    public boolean isShowStacks() {
        return this._showStacks;
    }

    public void setShowStacks(boolean showStacks) {
        this._showStacks = showStacks;
    }

    public void setShowMessageInTitle(boolean showMessageInTitle) {
        this._showMessageInTitle = showMessageInTitle;
    }

    public boolean getShowMessageInTitle() {
        return this._showMessageInTitle;
    }

    protected void write(Writer writer, String string) throws IOException {
        if (string != null) {
            writer.write(StringUtil.sanitizeXmlString(string));
        }
    }

    public static ErrorHandler getErrorHandler(Server server, ContextHandler context) {
        ErrorHandler errorHandler = null;
        if (context != null) {
            errorHandler = context.getErrorHandler();
        }
        if (errorHandler == null && server != null) {
            errorHandler = (ErrorHandler) server.getBean((Class<Object>) ErrorHandler.class);
        }
        return errorHandler;
    }
}
