package org.eclipse.jetty.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.pathmap.MatchedResource;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerWrapper;
import org.eclipse.jetty.util.ArrayUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/Invoker.class */
public class Invoker extends HttpServlet {
    private static final Logger LOG = Log.getLogger(Invoker.class);
    private ContextHandler _contextHandler;
    private ServletHandler _servletHandler;
    private MatchedResource<ServletHolder> _invokerEntry;
    private Map<String, String> _parameters;
    private boolean _nonContextServlets;
    private boolean _verbose;

    @Override // javax.servlet.GenericServlet
    public void init() {
        this._contextHandler = ((ContextHandler.Context) getServletContext()).getContextHandler();
        Handler handler = this._contextHandler.getHandler();
        while (handler != null && !(handler instanceof ServletHandler) && (handler instanceof HandlerWrapper)) {
            handler = ((HandlerWrapper) handler).getHandler();
        }
        this._servletHandler = (ServletHandler) handler;
        Enumeration<String> e = getInitParameterNames();
        while (e.hasMoreElements()) {
            String param = e.nextElement();
            String value = getInitParameter(param);
            String lvalue = value.toLowerCase(Locale.ENGLISH);
            if ("nonContextServlets".equals(param)) {
                this._nonContextServlets = value.length() > 0 && lvalue.startsWith("t");
            }
            if ("verbose".equals(param)) {
                this._verbose = value.length() > 0 && lvalue.startsWith("t");
            } else {
                if (this._parameters == null) {
                    this._parameters = new HashMap();
                }
                this._parameters.put(param, value);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.servlet.http.HttpServlet
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean included = false;
        String servletPath = (String) request.getAttribute(RequestDispatcher.INCLUDE_SERVLET_PATH);
        if (servletPath == null) {
            servletPath = request.getServletPath();
        } else {
            included = true;
        }
        String pathInfo = (String) request.getAttribute(RequestDispatcher.INCLUDE_PATH_INFO);
        if (pathInfo == null) {
            pathInfo = request.getPathInfo();
        }
        if (pathInfo == null || pathInfo.length() <= 1) {
            response.sendError(404);
            return;
        }
        int i0 = pathInfo.charAt(0) == '/' ? 1 : 0;
        int i1 = pathInfo.indexOf(47, i0);
        String servlet = i1 < 0 ? pathInfo.substring(i0) : pathInfo.substring(i0, i1);
        ServletHolder holder = getHolder(this._servletHandler.getServlets(), servlet);
        if (holder != null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Adding servlet mapping for named servlet:" + servlet + EmitterKt.COMMENT_PREFIX + URIUtil.addPaths(servletPath, servlet) + "/*", new Object[0]);
            }
            ServletMapping mapping = new ServletMapping();
            mapping.setServletName(servlet);
            mapping.setPathSpec(URIUtil.addPaths(servletPath, servlet) + "/*");
            this._servletHandler.setServletMappings((ServletMapping[]) ArrayUtil.addToArray(this._servletHandler.getServletMappings(), mapping, ServletMapping.class));
        } else {
            if (servlet.endsWith(".class")) {
                servlet = servlet.substring(0, servlet.length() - 6);
            }
            if (servlet == null || servlet.length() == 0) {
                response.sendError(404);
                return;
            }
            synchronized (this._servletHandler) {
                this._invokerEntry = this._servletHandler.getMatchedServlet(servletPath);
                String path = URIUtil.addPaths(servletPath, servlet);
                MatchedResource<ServletHolder> entry = this._servletHandler.getMatchedServlet(path);
                if (entry == null || entry.getResource().equals(this._invokerEntry.getResource())) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Making new servlet=" + servlet + " with path=" + path + "/*", new Object[0]);
                    }
                    holder = this._servletHandler.addServletWithMapping(servlet, path + "/*");
                    if (this._parameters != null) {
                        holder.setInitParameters(this._parameters);
                    }
                    try {
                        holder.start();
                        if (!this._nonContextServlets) {
                            Object s = holder.getServlet();
                            if (this._contextHandler.getClassLoader() != s.getClass().getClassLoader()) {
                                try {
                                    holder.stop();
                                } catch (Exception e) {
                                    LOG.ignore(e);
                                }
                                LOG.warn("Dynamic servlet " + s + " not loaded from context " + request.getContextPath(), new Object[0]);
                                throw new UnavailableException("Not in context");
                            }
                        }
                        if (this._verbose && LOG.isDebugEnabled()) {
                            LOG.debug("Dynamic load '" + servlet + "' at " + path, new Object[0]);
                        }
                    } catch (Exception e2) {
                        LOG.debug(e2);
                        throw new UnavailableException(e2.toString());
                    }
                } else {
                    holder = entry.getResource();
                }
            }
        }
        if (holder != null) {
            Request baseRequest = Request.getBaseRequest(request);
            holder.prepare(baseRequest, request, response);
            holder.handle(baseRequest, new InvokedRequest(request, included, servlet, servletPath, pathInfo), response);
            return;
        }
        LOG.info("Can't find holder for servlet: " + servlet, new Object[0]);
        response.sendError(404);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/Invoker$InvokedRequest.class */
    class InvokedRequest extends HttpServletRequestWrapper {
        String _servletPath;
        String _pathInfo;
        boolean _included;

        InvokedRequest(HttpServletRequest request, boolean included, String name, String servletPath, String pathInfo) {
            super(request);
            this._included = included;
            this._servletPath = URIUtil.addPaths(servletPath, name);
            this._pathInfo = pathInfo.substring(name.length() + 1);
            if (this._pathInfo.length() == 0) {
                this._pathInfo = null;
            }
        }

        @Override // javax.servlet.http.HttpServletRequestWrapper, javax.servlet.http.HttpServletRequest
        public String getServletPath() {
            if (this._included) {
                return getServletPath();
            }
            return this._servletPath;
        }

        @Override // javax.servlet.http.HttpServletRequestWrapper, javax.servlet.http.HttpServletRequest
        public String getPathInfo() {
            if (this._included) {
                return getPathInfo();
            }
            return this._pathInfo;
        }

        @Override // javax.servlet.ServletRequestWrapper, javax.servlet.ServletRequest
        public Object getAttribute(String name) {
            if (this._included) {
                if (name.equals(RequestDispatcher.INCLUDE_REQUEST_URI)) {
                    return URIUtil.addPaths(URIUtil.addPaths(getContextPath(), this._servletPath), this._pathInfo);
                }
                if (name.equals(RequestDispatcher.INCLUDE_PATH_INFO)) {
                    return this._pathInfo;
                }
                if (name.equals(RequestDispatcher.INCLUDE_SERVLET_PATH)) {
                    return this._servletPath;
                }
            }
            return getAttribute(name);
        }
    }

    private ServletHolder getHolder(ServletHolder[] holders, String servlet) {
        if (holders == null) {
            return null;
        }
        ServletHolder holder = null;
        int i = 0;
        while (holder == null && i < holders.length) {
            if (holders[i].getName().equals(servlet)) {
                holder = holders[i];
            }
            i++;
        }
        return holder;
    }
}
