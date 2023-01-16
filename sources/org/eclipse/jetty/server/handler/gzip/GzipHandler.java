package org.eclipse.jetty.server.handler.gzip;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.ListIterator;
import java.util.regex.Pattern;
import java.util.zip.Deflater;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.CompressedContentFormat;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.http.PreEncodedHttpField;
import org.eclipse.jetty.http.pathmap.PathSpecSet;
import org.eclipse.jetty.server.HttpOutput;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.HandlerWrapper;
import org.eclipse.jetty.util.IncludeExclude;
import org.eclipse.jetty.util.RegexSet;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.compression.DeflaterPool;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/gzip/GzipHandler.class */
public class GzipHandler extends HandlerWrapper implements GzipFactory {
    public static final String GZIP_HANDLER_ETAGS = "o.e.j.s.h.gzip.GzipHandler.etag";
    public static final String DEFLATE = "deflate";
    public static final int DEFAULT_MIN_GZIP_SIZE = 32;
    public static final int BREAK_EVEN_GZIP_SIZE = 23;
    private int _poolCapacity = -1;
    private DeflaterPool _deflaterPool = null;
    private int _minGzipSize = 32;
    private int _compressionLevel = -1;
    @Deprecated
    private boolean _checkGzExists = false;
    private boolean _syncFlush = false;
    private int _inflateBufferSize = -1;
    private EnumSet<DispatcherType> _dispatchers = EnumSet.of(DispatcherType.REQUEST);
    private final IncludeExclude<String> _agentPatterns = new IncludeExclude<>(RegexSet.class);
    private final IncludeExclude<String> _methods = new IncludeExclude<>();
    private final IncludeExclude<String> _paths = new IncludeExclude<>(PathSpecSet.class);
    private final IncludeExclude<String> _mimeTypes = new IncludeExclude<>();
    private HttpField _vary;
    private static final Logger LOG = Log.getLogger(GzipHandler.class);
    public static final String GZIP = "gzip";
    private static final HttpField X_CE_GZIP = new PreEncodedHttpField("X-Content-Encoding", GZIP);
    private static final Pattern COMMA_GZIP = Pattern.compile(".*, *gzip");

    public GzipHandler() {
        this._methods.include((IncludeExclude<String>) HttpMethod.GET.asString());
        for (String type : MimeTypes.getKnownMimeTypes()) {
            if ("image/svg+xml".equals(type)) {
                this._paths.exclude((IncludeExclude<String>) "*.svgz");
            } else if (type.startsWith("image/") || type.startsWith("audio/") || type.startsWith("video/")) {
                this._mimeTypes.exclude((IncludeExclude<String>) type);
            }
        }
        this._mimeTypes.exclude((IncludeExclude<String>) "application/compress");
        this._mimeTypes.exclude((IncludeExclude<String>) "application/zip");
        this._mimeTypes.exclude((IncludeExclude<String>) "application/gzip");
        this._mimeTypes.exclude((IncludeExclude<String>) "application/bzip2");
        this._mimeTypes.exclude((IncludeExclude<String>) "application/brotli");
        this._mimeTypes.exclude((IncludeExclude<String>) "application/x-xz");
        this._mimeTypes.exclude((IncludeExclude<String>) "application/x-rar-compressed");
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} mime types {}", this, this._mimeTypes);
        }
        this._agentPatterns.exclude((IncludeExclude<String>) ".*MSIE 6.0.*");
    }

    public void addExcludedAgentPatterns(String... patterns) {
        this._agentPatterns.exclude((Object[]) patterns);
    }

    public void addExcludedMethods(String... methods) {
        for (String m : methods) {
            this._methods.exclude((IncludeExclude<String>) m);
        }
    }

    public EnumSet<DispatcherType> getDispatcherTypes() {
        return this._dispatchers;
    }

    public void setDispatcherTypes(EnumSet<DispatcherType> dispatchers) {
        this._dispatchers = dispatchers;
    }

    public void setDispatcherTypes(DispatcherType... dispatchers) {
        this._dispatchers = EnumSet.copyOf(Arrays.asList(dispatchers));
    }

    public void addExcludedMimeTypes(String... types) {
        for (String t : types) {
            this._mimeTypes.exclude((Object[]) StringUtil.csvSplit(t));
        }
    }

    public void addExcludedPaths(String... pathspecs) {
        for (String p : pathspecs) {
            this._paths.exclude((Object[]) StringUtil.csvSplit(p));
        }
    }

    public void addIncludedAgentPatterns(String... patterns) {
        this._agentPatterns.include((Object[]) patterns);
    }

    public void addIncludedMethods(String... methods) {
        for (String m : methods) {
            this._methods.include((IncludeExclude<String>) m);
        }
    }

    public boolean isSyncFlush() {
        return this._syncFlush;
    }

    public void setSyncFlush(boolean syncFlush) {
        this._syncFlush = syncFlush;
    }

    public void addIncludedMimeTypes(String... types) {
        for (String t : types) {
            this._mimeTypes.include((Object[]) StringUtil.csvSplit(t));
        }
    }

    public void addIncludedPaths(String... pathspecs) {
        for (String p : pathspecs) {
            this._paths.include((Object[]) StringUtil.csvSplit(p));
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        this._deflaterPool = newDeflaterPool(this._poolCapacity);
        addBean(this._deflaterPool);
        this._vary = this._agentPatterns.size() > 0 ? GzipHttpOutputInterceptor.VARY_ACCEPT_ENCODING_USER_AGENT : GzipHttpOutputInterceptor.VARY_ACCEPT_ENCODING;
        doStart();
    }

    @Deprecated
    public boolean getCheckGzExists() {
        return this._checkGzExists;
    }

    public int getCompressionLevel() {
        return this._compressionLevel;
    }

    @Override // org.eclipse.jetty.server.handler.gzip.GzipFactory
    public Deflater getDeflater(Request request, long contentLength) {
        HttpFields httpFields = request.getHttpFields();
        String ua = httpFields.get(HttpHeader.USER_AGENT);
        if (ua != null && !isAgentGzipable(ua)) {
            LOG.debug("{} excluded user agent {}", this, request);
            return null;
        } else if (contentLength >= 0 && contentLength < ((long) this._minGzipSize)) {
            LOG.debug("{} excluded minGzipSize {}", this, request);
            return null;
        } else if (httpFields.contains(HttpHeader.ACCEPT_ENCODING, GZIP)) {
            return this._deflaterPool.acquire();
        } else {
            LOG.debug("{} excluded not gzip accept {}", this, request);
            return null;
        }
    }

    public String[] getExcludedAgentPatterns() {
        return (String[]) this._agentPatterns.getExcluded().toArray(new String[0]);
    }

    public String[] getExcludedMethods() {
        return (String[]) this._methods.getExcluded().toArray(new String[0]);
    }

    public String[] getExcludedMimeTypes() {
        return (String[]) this._mimeTypes.getExcluded().toArray(new String[0]);
    }

    public String[] getExcludedPaths() {
        return (String[]) this._paths.getExcluded().toArray(new String[0]);
    }

    public String[] getIncludedAgentPatterns() {
        return (String[]) this._agentPatterns.getIncluded().toArray(new String[0]);
    }

    public String[] getIncludedMethods() {
        return (String[]) this._methods.getIncluded().toArray(new String[0]);
    }

    public String[] getIncludedMimeTypes() {
        return (String[]) this._mimeTypes.getIncluded().toArray(new String[0]);
    }

    public String[] getIncludedPaths() {
        return (String[]) this._paths.getIncluded().toArray(new String[0]);
    }

    @Deprecated
    public String[] getMethods() {
        return getIncludedMethods();
    }

    public int getMinGzipSize() {
        return this._minGzipSize;
    }

    protected HttpField getVaryField() {
        return this._vary;
    }

    public int getInflateBufferSize() {
        return this._inflateBufferSize;
    }

    public void setInflateBufferSize(int size) {
        this._inflateBufferSize = size;
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String realpath;
        ServletContext context = baseRequest.getServletContext();
        String path = context == null ? baseRequest.getRequestURI() : URIUtil.addPaths(baseRequest.getServletPath(), baseRequest.getPathInfo());
        LOG.debug("{} handle {} in {}", this, baseRequest, context);
        if (!this._dispatchers.contains(baseRequest.getDispatcherType())) {
            LOG.debug("{} excluded by dispatcherType {}", this, baseRequest.getDispatcherType());
            this._handler.handle(target, baseRequest, request, response);
            return;
        }
        if (this._inflateBufferSize > 0 && !baseRequest.isHandled()) {
            boolean inflate = false;
            ListIterator<HttpField> i = baseRequest.getHttpFields().listIterator();
            while (true) {
                if (!i.hasNext()) {
                    break;
                }
                HttpField field = i.next();
                if (field.getHeader() == HttpHeader.CONTENT_ENCODING) {
                    if (field.getValue().equalsIgnoreCase(GZIP)) {
                        i.set(X_CE_GZIP);
                        inflate = true;
                        break;
                    } else if (COMMA_GZIP.matcher(field.getValue()).matches()) {
                        String v = field.getValue();
                        i.set(new HttpField(HttpHeader.CONTENT_ENCODING, v.substring(0, v.lastIndexOf(44))));
                        i.add(X_CE_GZIP);
                        inflate = true;
                        break;
                    }
                }
            }
            if (inflate) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("{} inflate {}", this, request);
                }
                baseRequest.getHttpInput().addInterceptor(new GzipHttpInputInterceptor(baseRequest.getHttpChannel().getByteBufferPool(), this._inflateBufferSize));
                baseRequest.getHttpFields().computeField(HttpHeader.CONTENT_LENGTH, header, fields -> {
                    if (fields == null) {
                        return null;
                    }
                    return new HttpField("X-Content-Length", (String) fields.stream().map((v0) -> {
                        return v0.getValue();
                    }).findAny().orElse("0"));
                });
            }
        }
        if (response.isCommitted()) {
            this._handler.handle(target, baseRequest, request, response);
            return;
        }
        HttpOutput out = baseRequest.getResponse().getHttpOutput();
        for (HttpOutput.Interceptor interceptor = out.getInterceptor(); interceptor != null; interceptor = interceptor.getNextInterceptor()) {
            if (interceptor instanceof GzipHttpOutputInterceptor) {
                LOG.debug("{} already intercepting {}", this, request);
                this._handler.handle(target, baseRequest, request, response);
                return;
            }
        }
        if (!StringUtil.isEmpty(CompressedContentFormat.ETAG_SEPARATOR)) {
            ListIterator<HttpField> fields = baseRequest.getHttpFields().listIterator();
            while (fields.hasNext()) {
                HttpField field2 = fields.next();
                if (field2.getHeader() == HttpHeader.IF_NONE_MATCH || field2.getHeader() == HttpHeader.IF_MATCH) {
                    String etags = field2.getValue();
                    String etagsNoSuffix = CompressedContentFormat.GZIP.stripSuffixes(etags);
                    if (!etagsNoSuffix.equals(etags)) {
                        fields.set(new HttpField(field2.getHeader(), etagsNoSuffix));
                        baseRequest.setAttribute(GZIP_HANDLER_ETAGS, etags);
                    }
                }
            }
        }
        if (!this._methods.test(baseRequest.getMethod())) {
            LOG.debug("{} excluded by method {}", this, request);
            this._handler.handle(target, baseRequest, request, response);
        } else if (!isPathGzipable(path)) {
            LOG.debug("{} excluded by path {}", this, request);
            this._handler.handle(target, baseRequest, request, response);
        } else {
            String mimeType = context == null ? MimeTypes.getDefaultMimeByExtension(path) : context.getMimeType(path);
            if (mimeType != null && !isMimeTypeGzipable(HttpFields.valueParameters(mimeType, null))) {
                LOG.debug("{} excluded by path suffix mime type {}", this, request);
                this._handler.handle(target, baseRequest, request, response);
            } else if (!this._checkGzExists || context == null || (realpath = request.getServletContext().getRealPath(path)) == null || !new File(realpath + ".gz").exists()) {
                HttpOutput.Interceptor origInterceptor = out.getInterceptor();
                try {
                    out.setInterceptor(new GzipHttpOutputInterceptor(this, getVaryField(), baseRequest.getHttpChannel(), origInterceptor, isSyncFlush()));
                    if (this._handler != null) {
                        this._handler.handle(target, baseRequest, request, response);
                    }
                    if (!(baseRequest.isHandled() || baseRequest.isAsyncStarted())) {
                        out.setInterceptor(origInterceptor);
                    }
                } catch (Throwable th) {
                    if (!baseRequest.isHandled() && !baseRequest.isAsyncStarted()) {
                        out.setInterceptor(origInterceptor);
                    }
                    throw th;
                }
            } else {
                LOG.debug("{} gzip exists {}", this, request);
                this._handler.handle(target, baseRequest, request, response);
            }
        }
    }

    protected boolean isAgentGzipable(String ua) {
        if (ua == null) {
            return false;
        }
        return this._agentPatterns.test(ua);
    }

    @Override // org.eclipse.jetty.server.handler.gzip.GzipFactory
    public boolean isMimeTypeGzipable(String mimetype) {
        return this._mimeTypes.test(mimetype);
    }

    protected boolean isPathGzipable(String requestURI) {
        if (requestURI == null) {
            return true;
        }
        return this._paths.test(requestURI);
    }

    @Override // org.eclipse.jetty.server.handler.gzip.GzipFactory
    public void recycle(Deflater deflater) {
        this._deflaterPool.release(deflater);
    }

    @Deprecated
    public void setCheckGzExists(boolean checkGzExists) {
        this._checkGzExists = checkGzExists;
    }

    public void setCompressionLevel(int compressionLevel) {
        if (isStarted()) {
            throw new IllegalStateException(getState());
        }
        this._compressionLevel = compressionLevel;
    }

    public void setExcludedAgentPatterns(String... patterns) {
        this._agentPatterns.getExcluded().clear();
        addExcludedAgentPatterns(patterns);
    }

    public void setExcludedMethods(String... methods) {
        this._methods.getExcluded().clear();
        this._methods.exclude((Object[]) methods);
    }

    public void setExcludedMimeTypes(String... types) {
        this._mimeTypes.getExcluded().clear();
        this._mimeTypes.exclude((Object[]) types);
    }

    public void setExcludedPaths(String... pathspecs) {
        this._paths.getExcluded().clear();
        this._paths.exclude((Object[]) pathspecs);
    }

    public void setIncludedAgentPatterns(String... patterns) {
        this._agentPatterns.getIncluded().clear();
        addIncludedAgentPatterns(patterns);
    }

    public void setIncludedMethods(String... methods) {
        this._methods.getIncluded().clear();
        this._methods.include((Object[]) methods);
    }

    public void setIncludedMimeTypes(String... types) {
        this._mimeTypes.getIncluded().clear();
        this._mimeTypes.include((Object[]) types);
    }

    public void setIncludedPaths(String... pathspecs) {
        this._paths.getIncluded().clear();
        this._paths.include((Object[]) pathspecs);
    }

    public void setMinGzipSize(int minGzipSize) {
        if (minGzipSize < 23) {
            LOG.warn("minGzipSize of {} is inefficient for short content, break even is size {}", Integer.valueOf(minGzipSize), 23);
        }
        this._minGzipSize = Math.max(0, minGzipSize);
    }

    public void setIncludedMethodList(String csvMethods) {
        setIncludedMethods(StringUtil.csvSplit(csvMethods));
    }

    public String getIncludedMethodList() {
        return String.join(",", getIncludedMethods());
    }

    public void setExcludedMethodList(String csvMethods) {
        setExcludedMethods(StringUtil.csvSplit(csvMethods));
    }

    public String getExcludedMethodList() {
        return String.join(",", getExcludedMethods());
    }

    public int getDeflaterPoolCapacity() {
        return this._poolCapacity;
    }

    public void setDeflaterPoolCapacity(int capacity) {
        if (isStarted()) {
            throw new IllegalStateException(getState());
        }
        this._poolCapacity = capacity;
    }

    protected DeflaterPool newDeflaterPool(int capacity) {
        return new DeflaterPool(capacity, getCompressionLevel(), true);
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s@%x{%s,min=%s,inflate=%s}", getClass().getSimpleName(), Integer.valueOf(hashCode()), getState(), Integer.valueOf(this._minGzipSize), Integer.valueOf(this._inflateBufferSize));
    }
}
