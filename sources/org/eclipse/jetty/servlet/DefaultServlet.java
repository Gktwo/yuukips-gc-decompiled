package org.eclipse.jetty.servlet;

import dev.morphia.mapping.Mapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.CompressedContentFormat;
import org.eclipse.jetty.http.HttpContent;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.http.PreEncodedHttpField;
import org.eclipse.jetty.http.pathmap.MappedResource;
import org.eclipse.jetty.server.CachedContentFactory;
import org.eclipse.jetty.server.ResourceContentFactory;
import org.eclipse.jetty.server.ResourceService;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.resource.ResourceFactory;

/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/DefaultServlet.class */
public class DefaultServlet extends HttpServlet implements ResourceFactory, ResourceService.WelcomeFactory {
    public static final String CONTEXT_INIT = "org.eclipse.jetty.servlet.Default.";
    private static final Logger LOG = Log.getLogger(DefaultServlet.class);
    private static final long serialVersionUID = 4930458713846881193L;
    private final ResourceService _resourceService;
    private ServletContext _servletContext;
    private ContextHandler _contextHandler;
    private boolean _welcomeServlets;
    private boolean _welcomeExactServlets;
    private Resource _resourceBase;
    private CachedContentFactory _cache;
    private MimeTypes _mimeTypes;
    private String[] _welcomes;
    private Resource _stylesheet;
    private boolean _useFileMappedBuffer;
    private String _relativeResourceBase;
    private ServletHandler _servletHandler;

    public DefaultServlet(ResourceService resourceService) {
        this._welcomeServlets = false;
        this._welcomeExactServlets = false;
        this._useFileMappedBuffer = false;
        this._resourceService = resourceService;
    }

    public DefaultServlet() {
        this(new ResourceService());
    }

    @Override // javax.servlet.GenericServlet
    public void init() throws UnavailableException {
        this._servletContext = getServletContext();
        this._contextHandler = initContextHandler(this._servletContext);
        this._mimeTypes = this._contextHandler.getMimeTypes();
        this._welcomes = this._contextHandler.getWelcomeFiles();
        if (this._welcomes == null) {
            this._welcomes = new String[]{"index.html", "index.jsp"};
        }
        this._resourceService.setAcceptRanges(getInitBoolean("acceptRanges", this._resourceService.isAcceptRanges()));
        this._resourceService.setDirAllowed(getInitBoolean("dirAllowed", this._resourceService.isDirAllowed()));
        this._resourceService.setRedirectWelcome(getInitBoolean("redirectWelcome", this._resourceService.isRedirectWelcome()));
        this._resourceService.setPrecompressedFormats(parsePrecompressedFormats(getInitParameter("precompressed"), getInitBoolean(GzipHandler.GZIP, false)));
        this._resourceService.setPathInfoOnly(getInitBoolean("pathInfoOnly", this._resourceService.isPathInfoOnly()));
        this._resourceService.setEtags(getInitBoolean("etags", this._resourceService.isEtags()));
        if ("exact".equals(getInitParameter("welcomeServlets"))) {
            this._welcomeExactServlets = true;
            this._welcomeServlets = false;
        } else {
            this._welcomeServlets = getInitBoolean("welcomeServlets", this._welcomeServlets);
        }
        this._useFileMappedBuffer = getInitBoolean("useFileMappedBuffer", this._useFileMappedBuffer);
        this._relativeResourceBase = getInitParameter("relativeResourceBase");
        String rb = getInitParameter("resourceBase");
        if (rb != null) {
            if (this._relativeResourceBase != null) {
                throw new UnavailableException("resourceBase & relativeResourceBase");
            }
            try {
                this._resourceBase = this._contextHandler.newResource(rb);
            } catch (Exception e) {
                LOG.warn(Log.EXCEPTION, e);
                throw new UnavailableException(e.toString());
            }
        }
        String css = getInitParameter("stylesheet");
        if (css != null) {
            try {
                this._stylesheet = Resource.newResource(css);
                if (!this._stylesheet.exists()) {
                    LOG.warn("!" + css, new Object[0]);
                    this._stylesheet = null;
                }
            } catch (Exception e2) {
                LOG.warn(e2.toString(), new Object[0]);
                LOG.debug(e2);
            }
        }
        if (this._stylesheet == null) {
            this._stylesheet = ResourceHandler.getDefaultStylesheet();
        }
        int encodingHeaderCacheSize = getInitInt("encodingHeaderCacheSize", -1);
        if (encodingHeaderCacheSize >= 0) {
            this._resourceService.setEncodingCacheSize(encodingHeaderCacheSize);
        }
        String cc = getInitParameter("cacheControl");
        if (cc != null) {
            this._resourceService.setCacheControl(new PreEncodedHttpField(HttpHeader.CACHE_CONTROL, cc));
        }
        String resourceCache = getInitParameter("resourceCache");
        int maxCacheSize = getInitInt("maxCacheSize", -2);
        int maxCachedFileSize = getInitInt("maxCachedFileSize", -2);
        int maxCachedFiles = getInitInt("maxCachedFiles", -2);
        if (resourceCache != null) {
            if (!(maxCacheSize == -1 && maxCachedFileSize == -2 && maxCachedFiles == -2)) {
                LOG.debug("ignoring resource cache configuration, using resourceCache attribute", new Object[0]);
            }
            if (this._relativeResourceBase == null && this._resourceBase == null) {
                this._cache = (CachedContentFactory) this._servletContext.getAttribute(resourceCache);
            } else {
                throw new UnavailableException("resourceCache specified with resource bases");
            }
        }
        try {
            if (this._cache == null && !(maxCachedFiles == -2 && maxCacheSize == -2 && maxCachedFileSize == -2)) {
                this._cache = new CachedContentFactory(null, this, this._mimeTypes, this._useFileMappedBuffer, this._resourceService.isEtags(), this._resourceService.getPrecompressedFormats());
                if (maxCacheSize >= 0) {
                    this._cache.setMaxCacheSize(maxCacheSize);
                }
                if (maxCachedFileSize >= -1) {
                    this._cache.setMaxCachedFileSize(maxCachedFileSize);
                }
                if (maxCachedFiles >= -1) {
                    this._cache.setMaxCachedFiles(maxCachedFiles);
                }
                this._servletContext.setAttribute(resourceCache == null ? "resourceCache" : resourceCache, this._cache);
            }
            HttpContent.ContentFactory contentFactory = this._cache;
            if (contentFactory == null) {
                contentFactory = new ResourceContentFactory(this, this._mimeTypes, this._resourceService.getPrecompressedFormats());
                if (resourceCache != null) {
                    this._servletContext.setAttribute(resourceCache, contentFactory);
                }
            }
            this._resourceService.setContentFactory(contentFactory);
            this._resourceService.setWelcomeFactory(this);
            List<String> gzipEquivalentFileExtensions = new ArrayList<>();
            String otherGzipExtensions = getInitParameter("otherGzipFileExtensions");
            if (otherGzipExtensions != null) {
                StringTokenizer tok = new StringTokenizer(otherGzipExtensions, ",", false);
                while (tok.hasMoreTokens()) {
                    String s = tok.nextToken().trim();
                    gzipEquivalentFileExtensions.add(s.charAt(0) == '.' ? s : Mapper.IGNORED_FIELDNAME + s);
                }
            } else {
                gzipEquivalentFileExtensions.add(".svgz");
            }
            this._resourceService.setGzipEquivalentFileExtensions(gzipEquivalentFileExtensions);
            this._servletHandler = (ServletHandler) this._contextHandler.getChildHandlerByClass(ServletHandler.class);
            if (LOG.isDebugEnabled()) {
                LOG.debug("resource base = " + this._resourceBase, new Object[0]);
            }
        } catch (Exception e3) {
            LOG.warn(Log.EXCEPTION, e3);
            throw new UnavailableException(e3.toString());
        }
    }

    private CompressedContentFormat[] parsePrecompressedFormats(String precompressed, boolean gzip) {
        List<CompressedContentFormat> ret = new ArrayList<>();
        if (precompressed != null && precompressed.indexOf(61) > 0) {
            for (String pair : precompressed.split(",")) {
                String[] setting = pair.split("=");
                ret.add(new CompressedContentFormat(setting[0].trim(), setting[1].trim()));
                if (gzip && !ret.contains(CompressedContentFormat.GZIP)) {
                    ret.add(CompressedContentFormat.GZIP);
                }
            }
        } else if (precompressed != null) {
            if (Boolean.parseBoolean(precompressed)) {
                ret.add(CompressedContentFormat.f3129BR);
                ret.add(CompressedContentFormat.GZIP);
            }
        } else if (gzip) {
            ret.add(CompressedContentFormat.GZIP);
        }
        return (CompressedContentFormat[]) ret.toArray(new CompressedContentFormat[ret.size()]);
    }

    protected ContextHandler initContextHandler(ServletContext servletContext) {
        if (ContextHandler.getCurrentContext() != null) {
            return ContextHandler.getCurrentContext().getContextHandler();
        }
        if (servletContext instanceof ContextHandler.Context) {
            return ((ContextHandler.Context) servletContext).getContextHandler();
        }
        throw new IllegalArgumentException("The servletContext " + servletContext + " " + servletContext.getClass().getName() + " is not " + ContextHandler.Context.class.getName());
    }

    @Override // javax.servlet.GenericServlet, javax.servlet.ServletConfig
    public String getInitParameter(String name) {
        String value = getServletContext().getInitParameter(CONTEXT_INIT + name);
        if (value == null) {
            value = getInitParameter(name);
        }
        return value;
    }

    private boolean getInitBoolean(String name, boolean dft) {
        String value = getInitParameter(name);
        if (value == null || value.length() == 0) {
            return dft;
        }
        return value.startsWith("t") || value.startsWith("T") || value.startsWith("y") || value.startsWith("Y") || value.startsWith("1");
    }

    private int getInitInt(String name, int dft) {
        String value = getInitParameter(name);
        if (value == null) {
            value = getInitParameter(name);
        }
        if (value == null || value.length() <= 0) {
            return dft;
        }
        return Integer.parseInt(value);
    }

    @Override // org.eclipse.jetty.util.resource.ResourceFactory
    public Resource getResource(String pathInContext) {
        Resource r = null;
        if (this._relativeResourceBase != null) {
            pathInContext = URIUtil.addPaths(this._relativeResourceBase, pathInContext);
        }
        try {
            if (this._resourceBase != null) {
                r = this._resourceBase.addPath(pathInContext);
                if (!this._contextHandler.checkAlias(pathInContext, r)) {
                    r = null;
                }
            } else if (!(this._servletContext instanceof ContextHandler.Context)) {
                return null;
            } else {
                r = this._contextHandler.getResource(pathInContext);
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("Resource " + pathInContext + "=" + r, new Object[0]);
            }
        } catch (IOException e) {
            LOG.ignore(e);
        }
        if ((r == null || !r.exists()) && pathInContext.endsWith("/jetty-dir.css")) {
            r = this._stylesheet;
        }
        return r;
    }

    @Override // javax.servlet.http.HttpServlet
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!this._resourceService.doGet(request, response)) {
            response.sendError(404);
        }
    }

    @Override // javax.servlet.http.HttpServlet
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override // javax.servlet.http.HttpServlet
    protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override // javax.servlet.http.HttpServlet
    protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(405);
    }

    @Override // javax.servlet.http.HttpServlet
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Allow", "GET,HEAD,POST,OPTIONS");
    }

    @Override // javax.servlet.GenericServlet, javax.servlet.Servlet
    public void destroy() {
        if (this._cache != null) {
            this._cache.flushCache();
        }
        destroy();
    }

    @Override // org.eclipse.jetty.server.ResourceService.WelcomeFactory
    public String getWelcomeFile(String pathInContext) {
        MappedResource<ServletHolder> entry;
        if (this._welcomes == null) {
            return null;
        }
        String welcomeServlet = null;
        for (String s : this._welcomes) {
            String welcomeInContext = URIUtil.addPaths(pathInContext, s);
            Resource welcome = getResource(welcomeInContext);
            if (welcome != null && welcome.exists()) {
                return welcomeInContext;
            }
            if ((this._welcomeServlets || this._welcomeExactServlets) && welcomeServlet == null && (entry = this._servletHandler.getMappedServlet(welcomeInContext)) != null && entry.getResource().getServletInstance() != this && (this._welcomeServlets || (this._welcomeExactServlets && entry.getPathSpec().getDeclaration().equals(welcomeInContext)))) {
                welcomeServlet = welcomeInContext;
            }
        }
        return welcomeServlet;
    }
}
