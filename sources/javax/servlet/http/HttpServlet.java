package javax.servlet.http;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/* loaded from: grasscutter.jar:javax/servlet/http/HttpServlet.class */
public abstract class HttpServlet extends GenericServlet {
    private static final String METHOD_DELETE = "DELETE";
    private static final String METHOD_HEAD = "HEAD";
    private static final String METHOD_GET = "GET";
    private static final String METHOD_OPTIONS = "OPTIONS";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_PUT = "PUT";
    private static final String METHOD_TRACE = "TRACE";
    private static final String HEADER_IFMODSINCE = "If-Modified-Since";
    private static final String HEADER_LASTMOD = "Last-Modified";
    private static final String LSTRING_FILE = "javax.servlet.http.LocalStrings";
    private static ResourceBundle lStrings = ResourceBundle.getBundle(LSTRING_FILE);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String protocol = req.getProtocol();
        String msg = lStrings.getString("http.method_get_not_supported");
        if (protocol.endsWith("1.1")) {
            resp.sendError(405, msg);
        } else {
            resp.sendError(400, msg);
        }
    }

    protected long getLastModified(HttpServletRequest req) {
        return -1;
    }

    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NoBodyResponse response = new NoBodyResponse(resp);
        doGet(req, response);
        response.setContentLength();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String protocol = req.getProtocol();
        String msg = lStrings.getString("http.method_post_not_supported");
        if (protocol.endsWith("1.1")) {
            resp.sendError(405, msg);
        } else {
            resp.sendError(400, msg);
        }
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String protocol = req.getProtocol();
        String msg = lStrings.getString("http.method_put_not_supported");
        if (protocol.endsWith("1.1")) {
            resp.sendError(405, msg);
        } else {
            resp.sendError(400, msg);
        }
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String protocol = req.getProtocol();
        String msg = lStrings.getString("http.method_delete_not_supported");
        if (protocol.endsWith("1.1")) {
            resp.sendError(405, msg);
        } else {
            resp.sendError(400, msg);
        }
    }

    private Method[] getAllDeclaredMethods(Class<? extends HttpServlet> c) {
        Method[] allMethods = null;
        for (Class<?> clazz = c; !clazz.equals(HttpServlet.class); clazz = clazz.getSuperclass()) {
            Method[] thisMethods = clazz.getDeclaredMethods();
            if (allMethods == null || allMethods.length <= 0) {
                allMethods = thisMethods;
            } else {
                allMethods = new Method[thisMethods.length + allMethods.length];
                System.arraycopy(thisMethods, 0, allMethods, 0, thisMethods.length);
                System.arraycopy(allMethods, 0, allMethods, thisMethods.length, allMethods.length);
            }
        }
        return allMethods != null ? allMethods : new Method[0];
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: javax.servlet.http.HttpServlet */
    /* JADX WARN: Multi-variable type inference failed */
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean ALLOW_GET = false;
        boolean ALLOW_HEAD = false;
        boolean ALLOW_POST = false;
        boolean ALLOW_PUT = false;
        boolean ALLOW_DELETE = false;
        for (Method method : getAllDeclaredMethods(getClass())) {
            String methodName = method.getName();
            if (methodName.equals("doGet")) {
                ALLOW_GET = true;
                ALLOW_HEAD = true;
            } else if (methodName.equals("doPost")) {
                ALLOW_POST = true;
            } else if (methodName.equals("doPut")) {
                ALLOW_PUT = true;
            } else if (methodName.equals("doDelete")) {
                ALLOW_DELETE = true;
            }
        }
        StringBuilder allow = new StringBuilder();
        if (ALLOW_GET) {
            allow.append(METHOD_GET);
        }
        if (ALLOW_HEAD) {
            if (allow.length() > 0) {
                allow.append(", ");
            }
            allow.append(METHOD_HEAD);
        }
        if (ALLOW_POST) {
            if (allow.length() > 0) {
                allow.append(", ");
            }
            allow.append(METHOD_POST);
        }
        if (ALLOW_PUT) {
            if (allow.length() > 0) {
                allow.append(", ");
            }
            allow.append(METHOD_PUT);
        }
        if (ALLOW_DELETE) {
            if (allow.length() > 0) {
                allow.append(", ");
            }
            allow.append(METHOD_DELETE);
        }
        if (1 != 0) {
            if (allow.length() > 0) {
                allow.append(", ");
            }
            allow.append(METHOD_TRACE);
        }
        if (1 != 0) {
            if (allow.length() > 0) {
                allow.append(", ");
            }
            allow.append(METHOD_OPTIONS);
        }
        resp.setHeader("Allow", allow.toString());
    }

    protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder buffer = new StringBuilder("TRACE ").append(req.getRequestURI()).append(" ").append(req.getProtocol());
        Enumeration<String> reqHeaderEnum = req.getHeaderNames();
        while (reqHeaderEnum.hasMoreElements()) {
            String headerName = reqHeaderEnum.nextElement();
            buffer.append("\r\n").append(headerName).append(": ").append(req.getHeader(headerName));
        }
        buffer.append("\r\n");
        int responseLength = buffer.length();
        resp.setContentType("message/http");
        resp.setContentLength(responseLength);
        resp.getOutputStream().print(buffer.toString());
    }

    /* access modifiers changed from: protected */
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        if (method.equals(METHOD_GET)) {
            long lastModified = getLastModified(req);
            if (lastModified == -1) {
                doGet(req, resp);
            } else if (req.getDateHeader("If-Modified-Since") < lastModified) {
                maybeSetLastModified(resp, lastModified);
                doGet(req, resp);
            } else {
                resp.setStatus(304);
            }
        } else if (method.equals(METHOD_HEAD)) {
            maybeSetLastModified(resp, getLastModified(req));
            doHead(req, resp);
        } else if (method.equals(METHOD_POST)) {
            doPost(req, resp);
        } else if (method.equals(METHOD_PUT)) {
            doPut(req, resp);
        } else if (method.equals(METHOD_DELETE)) {
            doDelete(req, resp);
        } else if (method.equals(METHOD_OPTIONS)) {
            doOptions(req, resp);
        } else if (method.equals(METHOD_TRACE)) {
            doTrace(req, resp);
        } else {
            resp.sendError(501, MessageFormat.format(lStrings.getString("http.method_not_implemented"), method));
        }
    }

    private void maybeSetLastModified(HttpServletResponse resp, long lastModified) {
        if (!resp.containsHeader("Last-Modified") && lastModified >= 0) {
            resp.setDateHeader("Last-Modified", lastModified);
        }
    }

    @Override // javax.servlet.GenericServlet, javax.servlet.Servlet
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        if (!(req instanceof HttpServletRequest) || !(res instanceof HttpServletResponse)) {
            throw new ServletException("non-HTTP request or response");
        }
        service((HttpServletRequest) req, (HttpServletResponse) res);
    }
}
