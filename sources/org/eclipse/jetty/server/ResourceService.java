package org.eclipse.jetty.server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.CompressedContentFormat;
import org.eclipse.jetty.http.HttpContent;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpHeaderValue;
import org.eclipse.jetty.http.PreEncodedHttpField;
import org.eclipse.jetty.http.QuotedQualityCSV;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/ResourceService.class */
public class ResourceService {
    private static final Logger LOG = Log.getLogger(ResourceService.class);
    private static final PreEncodedHttpField ACCEPT_RANGES = new PreEncodedHttpField(HttpHeader.ACCEPT_RANGES, "bytes");
    private HttpContent.ContentFactory _contentFactory;
    private WelcomeFactory _welcomeFactory;
    private boolean _acceptRanges = true;
    private boolean _dirAllowed = true;
    private boolean _redirectWelcome = false;
    private CompressedContentFormat[] _precompressedFormats = new CompressedContentFormat[0];
    private String[] _preferredEncodingOrder = new String[0];
    private final Map<String, List<String>> _preferredEncodingOrderCache = new ConcurrentHashMap();
    private int _encodingCacheSize = 100;
    private boolean _pathInfoOnly = false;
    private boolean _etags = false;
    private HttpField _cacheControl;
    private List<String> _gzipEquivalentFileExtensions;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ResourceService$WelcomeFactory.class */
    public interface WelcomeFactory {
        String getWelcomeFile(String str);
    }

    public HttpContent.ContentFactory getContentFactory() {
        return this._contentFactory;
    }

    public void setContentFactory(HttpContent.ContentFactory contentFactory) {
        this._contentFactory = contentFactory;
    }

    public WelcomeFactory getWelcomeFactory() {
        return this._welcomeFactory;
    }

    public void setWelcomeFactory(WelcomeFactory welcomeFactory) {
        this._welcomeFactory = welcomeFactory;
    }

    public boolean isAcceptRanges() {
        return this._acceptRanges;
    }

    public void setAcceptRanges(boolean acceptRanges) {
        this._acceptRanges = acceptRanges;
    }

    public boolean isDirAllowed() {
        return this._dirAllowed;
    }

    public void setDirAllowed(boolean dirAllowed) {
        this._dirAllowed = dirAllowed;
    }

    public boolean isRedirectWelcome() {
        return this._redirectWelcome;
    }

    public void setRedirectWelcome(boolean redirectWelcome) {
        this._redirectWelcome = redirectWelcome;
    }

    public CompressedContentFormat[] getPrecompressedFormats() {
        return this._precompressedFormats;
    }

    public void setPrecompressedFormats(CompressedContentFormat[] precompressedFormats) {
        this._precompressedFormats = precompressedFormats;
        this._preferredEncodingOrder = (String[]) Arrays.stream(this._precompressedFormats).map(f -> {
            return f.getEncoding();
        }).toArray(x$0 -> {
            return new String[x$0];
        });
    }

    public void setEncodingCacheSize(int encodingCacheSize) {
        this._encodingCacheSize = encodingCacheSize;
    }

    public int getEncodingCacheSize() {
        return this._encodingCacheSize;
    }

    public boolean isPathInfoOnly() {
        return this._pathInfoOnly;
    }

    public void setPathInfoOnly(boolean pathInfoOnly) {
        this._pathInfoOnly = pathInfoOnly;
    }

    public boolean isEtags() {
        return this._etags;
    }

    public void setEtags(boolean etags) {
        this._etags = etags;
    }

    public HttpField getCacheControl() {
        return this._cacheControl;
    }

    public void setCacheControl(HttpField cacheControl) {
        HttpField httpField;
        if (cacheControl == null) {
            this._cacheControl = null;
        }
        if (cacheControl.getHeader() != HttpHeader.CACHE_CONTROL) {
            throw new IllegalArgumentException("!Cache-Control");
        }
        if (cacheControl instanceof PreEncodedHttpField) {
            httpField = cacheControl;
        } else {
            httpField = new PreEncodedHttpField(cacheControl.getHeader(), cacheControl.getValue());
        }
        this._cacheControl = httpField;
    }

    public List<String> getGzipEquivalentFileExtensions() {
        return this._gzipEquivalentFileExtensions;
    }

    public void setGzipEquivalentFileExtensions(List<String> gzipEquivalentFileExtensions) {
        this._gzipEquivalentFileExtensions = gzipEquivalentFileExtensions;
    }

    public boolean doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo;
        String servletPath;
        HttpContent content;
        HttpContent content2;
        Enumeration<String> reqRanges = null;
        boolean included = request.getAttribute(RequestDispatcher.INCLUDE_REQUEST_URI) != null;
        if (included) {
            servletPath = this._pathInfoOnly ? "/" : (String) request.getAttribute(RequestDispatcher.INCLUDE_SERVLET_PATH);
            pathInfo = (String) request.getAttribute(RequestDispatcher.INCLUDE_PATH_INFO);
            if (servletPath == null) {
                servletPath = request.getServletPath();
                pathInfo = request.getPathInfo();
            }
        } else {
            servletPath = this._pathInfoOnly ? "/" : request.getServletPath();
            pathInfo = request.getPathInfo();
            reqRanges = request.getHeaders(HttpHeader.RANGE.asString());
            if (!hasDefinedRange(reqRanges)) {
                reqRanges = null;
            }
        }
        String pathInContext = URIUtil.addPaths(servletPath, pathInfo);
        boolean endsWithSlash = (pathInfo == null ? this._pathInfoOnly ? "" : servletPath : pathInfo).endsWith("/");
        boolean checkPrecompressedVariants = this._precompressedFormats.length > 0 && !endsWithSlash && !included && reqRanges == null;
        try {
            content = null;
            try {
                content = this._contentFactory.getContent(pathInContext, response.getBufferSize());
                if (LOG.isDebugEnabled()) {
                    LOG.debug("content={}", content);
                }
                if (content == null || !content.getResource().exists()) {
                    if (included) {
                        throw new FileNotFoundException("!" + pathInContext);
                    }
                    notFound(request, response);
                    boolean isCommitted = response.isCommitted();
                    if (!(1 == 0 || content == null)) {
                        content.release();
                    }
                    return isCommitted;
                } else if (content.getResource().isDirectory()) {
                    sendWelcome(content, pathInContext, endsWithSlash, included, request, response);
                    if (!(1 == 0 || content == null)) {
                        content.release();
                    }
                    return true;
                } else if (!included && endsWithSlash && pathInContext.length() > 1) {
                    String q = request.getQueryString();
                    String pathInContext2 = pathInContext.substring(0, pathInContext.length() - 1);
                    if (!(q == null || q.length() == 0)) {
                        pathInContext2 = pathInContext2 + "?" + q;
                    }
                    response.sendRedirect(response.encodeRedirectURL(URIUtil.addPaths(request.getContextPath(), pathInContext2)));
                    if (!(1 == 0 || content == null)) {
                        content.release();
                    }
                    return true;
                } else if (!included && !passConditionalHeaders(request, response, content)) {
                    return true;
                } else {
                    Map<CompressedContentFormat, ? extends HttpContent> precompressedContents = checkPrecompressedVariants ? content.getPrecompressedContents() : null;
                    if (precompressedContents != null && precompressedContents.size() > 0) {
                        response.addHeader(HttpHeader.VARY.asString(), HttpHeader.ACCEPT_ENCODING.asString());
                        CompressedContentFormat precompressedContentEncoding = getBestPrecompressedContent(getPreferredEncodingOrder(request), precompressedContents.keySet());
                        if (precompressedContentEncoding != null) {
                            HttpContent precompressedContent = (HttpContent) precompressedContents.get(precompressedContentEncoding);
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("precompressed={}", precompressedContent);
                            }
                            content2 = precompressedContent;
                            response.setHeader(HttpHeader.CONTENT_ENCODING.asString(), precompressedContentEncoding.getEncoding());
                        }
                    }
                    if (isGzippedContent(pathInContext)) {
                        response.setHeader(HttpHeader.CONTENT_ENCODING.asString(), GzipHandler.GZIP);
                    }
                    if (!sendData(request, response, included, content2, reqRanges) || content2 == null) {
                        return true;
                    }
                    content2.release();
                    return true;
                }
            } catch (IllegalArgumentException e) {
                LOG.warn(Log.EXCEPTION, e);
                if (!response.isCommitted()) {
                    response.sendError(500, e.getMessage());
                }
                if (1 == 0 || content == null) {
                    return true;
                }
                content.release();
                return true;
            }
        } finally {
            if (!(1 == 0 || content == null)) {
                content.release();
            }
        }
    }

    private List<String> getPreferredEncodingOrder(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaders(HttpHeader.ACCEPT_ENCODING.asString());
        if (!headers.hasMoreElements()) {
            return Collections.emptyList();
        }
        String key = headers.nextElement();
        if (headers.hasMoreElements()) {
            StringBuilder sb = new StringBuilder(key.length() * 2);
            sb.append(key);
            do {
                sb.append(',').append(headers.nextElement());
            } while (headers.hasMoreElements());
            key = sb.toString();
        }
        List<String> values = this._preferredEncodingOrderCache.get(key);
        if (values == null) {
            QuotedQualityCSV encodingQualityCSV = new QuotedQualityCSV(this._preferredEncodingOrder);
            encodingQualityCSV.addValue(key);
            values = encodingQualityCSV.getValues();
            if (this._preferredEncodingOrderCache.size() > this._encodingCacheSize) {
                this._preferredEncodingOrderCache.clear();
            }
            this._preferredEncodingOrderCache.put(key, values);
        }
        return values;
    }

    private CompressedContentFormat getBestPrecompressedContent(List<String> preferredEncodings, Collection<CompressedContentFormat> availableFormats) {
        if (availableFormats.isEmpty()) {
            return null;
        }
        for (String encoding : preferredEncodings) {
            for (CompressedContentFormat format : availableFormats) {
                if (format.getEncoding().equals(encoding)) {
                    return format;
                }
            }
            if ("*".equals(encoding)) {
                return availableFormats.iterator().next();
            }
            if (HttpHeaderValue.IDENTITY.asString().equals(encoding)) {
                return null;
            }
        }
        return null;
    }

    protected void sendWelcome(HttpContent content, String pathInContext, boolean endsWithSlash, boolean included, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!endsWithSlash) {
            StringBuilder buf = new StringBuilder(request.getRequestURI());
            int param = buf.lastIndexOf(";");
            if (param < 0 || buf.lastIndexOf("/", param) > 0) {
                buf.append('/');
            } else {
                buf.insert(param, '/');
            }
            String q = request.getQueryString();
            if (!(q == null || q.length() == 0)) {
                buf.append('?');
                buf.append(q);
            }
            response.setContentLength(0);
            response.sendRedirect(response.encodeRedirectURL(buf.toString()));
            return;
        }
        String welcome = this._welcomeFactory == null ? null : this._welcomeFactory.getWelcomeFile(pathInContext);
        if (welcome != null) {
            String servletPath = included ? (String) request.getAttribute(RequestDispatcher.INCLUDE_SERVLET_PATH) : request.getServletPath();
            if (this._pathInfoOnly) {
                welcome = URIUtil.addPaths(servletPath, welcome);
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("welcome={}", welcome);
            }
            ServletContext context = request.getServletContext();
            if (this._redirectWelcome || context == null) {
                response.setContentLength(0);
                String uri = URIUtil.encodePath(URIUtil.addPaths(request.getContextPath(), welcome));
                String q2 = request.getQueryString();
                if (q2 != null && !q2.isEmpty()) {
                    uri = uri + "?" + q2;
                }
                response.sendRedirect(response.encodeRedirectURL(uri));
                return;
            }
            RequestDispatcher dispatcher = context.getRequestDispatcher(URIUtil.encodePath(welcome));
            if (dispatcher == null) {
                return;
            }
            if (included) {
                dispatcher.include(request, response);
                return;
            }
            request.setAttribute("org.eclipse.jetty.server.welcome", welcome);
            dispatcher.forward(request, response);
        } else if (included || passConditionalHeaders(request, response, content)) {
            sendDirectory(request, response, content.getResource(), pathInContext);
        }
    }

    protected boolean isGzippedContent(String path) {
        if (path == null || this._gzipEquivalentFileExtensions == null) {
            return false;
        }
        for (String suffix : this._gzipEquivalentFileExtensions) {
            if (path.endsWith(suffix)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDefinedRange(Enumeration<String> reqRanges) {
        return reqRanges != null && reqRanges.hasMoreElements();
    }

    protected void notFound(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(404);
    }

    protected void sendStatus(HttpServletResponse response, int status, Supplier<String> etag) throws IOException {
        response.setStatus(status);
        if (this._etags && etag != null) {
            response.setHeader(HttpHeader.ETAG.asString(), etag.get());
        }
        response.flushBuffer();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:0x0093 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x0130 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r0v88, types: [long] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5, types: [long] */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected boolean passConditionalHeaders(javax.servlet.http.HttpServletRequest r9, javax.servlet.http.HttpServletResponse r10, org.eclipse.jetty.http.HttpContent r11) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 644
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.ResourceService.passConditionalHeaders(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.eclipse.jetty.http.HttpContent):boolean");
    }

    protected void sendDirectory(HttpServletRequest request, HttpServletResponse response, Resource resource, String pathInContext) throws IOException {
        if (!this._dirAllowed) {
            response.sendError(403);
            return;
        }
        String dir = resource.getListHTML(URIUtil.addEncodedPaths(request.getRequestURI(), "/"), pathInContext.length() > 1, request.getQueryString());
        if (dir == null) {
            response.sendError(403, "No directory");
            return;
        }
        byte[] data = dir.getBytes(StandardCharsets.UTF_8);
        response.setContentType("text/html;charset=utf-8");
        response.setContentLength(data.length);
        response.getOutputStream().write(data);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected boolean sendData(javax.servlet.http.HttpServletRequest r10, javax.servlet.http.HttpServletResponse r11, boolean r12, final org.eclipse.jetty.http.HttpContent r13, java.util.Enumeration<java.lang.String> r14) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1032
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.ResourceService.sendData(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, boolean, org.eclipse.jetty.http.HttpContent, java.util.Enumeration):boolean");
    }

    protected void putHeaders(HttpServletResponse response, HttpContent content, long contentLength) {
        if (response instanceof Response) {
            Response r = (Response) response;
            r.putHeaders(content, contentLength, this._etags);
            HttpFields fields = r.getHttpFields();
            if (this._acceptRanges && !fields.contains(HttpHeader.ACCEPT_RANGES)) {
                fields.add(ACCEPT_RANGES);
            }
            if (this._cacheControl != null && !fields.contains(HttpHeader.CACHE_CONTROL)) {
                fields.add(this._cacheControl);
                return;
            }
            return;
        }
        Response.putHeaders(response, content, contentLength, this._etags);
        if (this._acceptRanges && !response.containsHeader(HttpHeader.ACCEPT_RANGES.asString())) {
            response.setHeader(ACCEPT_RANGES.getName(), ACCEPT_RANGES.getValue());
        }
        if (this._cacheControl != null && !response.containsHeader(HttpHeader.CACHE_CONTROL.asString())) {
            response.setHeader(this._cacheControl.getName(), this._cacheControl.getValue());
        }
    }
}
