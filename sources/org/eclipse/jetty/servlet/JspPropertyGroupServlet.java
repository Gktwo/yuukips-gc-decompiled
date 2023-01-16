package org.eclipse.jetty.servlet;

import java.io.IOException;
import java.util.Locale;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/JspPropertyGroupServlet.class */
public class JspPropertyGroupServlet extends GenericServlet {
    private static final long serialVersionUID = 3681783214726776945L;
    public static final String NAME = "__org.eclipse.jetty.servlet.JspPropertyGroupServlet__";
    private final ServletHandler _servletHandler;
    private final ContextHandler _contextHandler;
    private ServletHolder _dftServlet;
    private ServletHolder _jspServlet;
    private boolean _starJspMapped;

    public JspPropertyGroupServlet(ContextHandler context, ServletHandler servletHandler) {
        this._contextHandler = context;
        this._servletHandler = servletHandler;
    }

    @Override // javax.servlet.GenericServlet
    public void init() throws ServletException {
        String jspName = "jsp";
        ServletMapping servletMapping = this._servletHandler.getServletMapping("*.jsp");
        if (servletMapping != null) {
            this._starJspMapped = true;
            ServletMapping[] mappings = this._servletHandler.getServletMappings();
            for (ServletMapping m : mappings) {
                String[] paths = m.getPathSpecs();
                if (paths != null) {
                    for (String path : paths) {
                        if ("*.jsp".equals(path) && !NAME.equals(m.getServletName())) {
                            servletMapping = m;
                        }
                    }
                }
            }
            jspName = servletMapping.getServletName();
        }
        this._jspServlet = this._servletHandler.getServlet(jspName);
        String dftName = "default";
        ServletMapping defaultMapping = this._servletHandler.getServletMapping("/");
        if (defaultMapping != null) {
            dftName = defaultMapping.getServletName();
        }
        this._dftServlet = this._servletHandler.getServlet(dftName);
    }

    @Override // javax.servlet.GenericServlet, javax.servlet.Servlet
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String pathInfo;
        String servletPath;
        if (req instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) req;
            if (request.getAttribute(RequestDispatcher.INCLUDE_REQUEST_URI) != null) {
                servletPath = (String) request.getAttribute(RequestDispatcher.INCLUDE_SERVLET_PATH);
                pathInfo = (String) request.getAttribute(RequestDispatcher.INCLUDE_PATH_INFO);
                if (servletPath == null) {
                    servletPath = request.getServletPath();
                    pathInfo = request.getPathInfo();
                }
            } else {
                servletPath = request.getServletPath();
                pathInfo = request.getPathInfo();
            }
            String pathInContext = URIUtil.addPaths(servletPath, pathInfo);
            if (pathInContext.endsWith("/")) {
                this._dftServlet.getServlet().service(req, res);
            } else if (!this._starJspMapped || !pathInContext.toLowerCase(Locale.ENGLISH).endsWith(".jsp")) {
                Resource resource = this._contextHandler.getResource(pathInContext);
                if (resource == null || !resource.isDirectory()) {
                    this._jspServlet.getServlet().service(req, res);
                } else {
                    this._dftServlet.getServlet().service(req, res);
                }
            } else {
                this._jspServlet.getServlet().service(req, res);
            }
        } else {
            throw new ServletException("Request not HttpServletRequest");
        }
    }
}
