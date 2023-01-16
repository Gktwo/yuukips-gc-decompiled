package org.eclipse.jetty.server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Locale;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.DateCache;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.Name;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject("Debug Listener")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/DebugListener.class */
public class DebugListener extends AbstractLifeCycle implements ServletContextListener {
    private static final Logger LOG = Log.getLogger(DebugListener.class);
    private static final DateCache __date = new DateCache("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    private final String _attr;
    private final PrintStream _out;
    private boolean _renameThread;
    private boolean _showHeaders;
    private boolean _dumpContext;
    final AsyncListener _asyncListener;
    final ServletRequestListener _servletRequestListener;
    final ContextHandler.ContextScopeListener _contextScopeListener;

    public DebugListener() {
        this(null, false, false, false);
    }

    public DebugListener(@Name("renameThread") boolean renameThread, @Name("showHeaders") boolean showHeaders, @Name("dumpContext") boolean dumpContext) {
        this(null, renameThread, showHeaders, dumpContext);
    }

    public DebugListener(@Name("outputStream") OutputStream out, @Name("renameThread") boolean renameThread, @Name("showHeaders") boolean showHeaders, @Name("dumpContext") boolean dumpContext) {
        this._attr = String.format("__R%s@%x", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        this._asyncListener = new AsyncListener() { // from class: org.eclipse.jetty.server.DebugListener.1
            @Override // javax.servlet.AsyncListener
            public void onTimeout(AsyncEvent event) throws IOException {
                DebugListener.this.log("!  ctx=%s r=%s onTimeout %s", DebugListener.this.findContextName(((AsyncContextEvent) event).getServletContext()), DebugListener.this.findRequestName(event.getAsyncContext().getRequest()), ((AsyncContextEvent) event).getHttpChannelState());
            }

            @Override // javax.servlet.AsyncListener
            public void onStartAsync(AsyncEvent event) throws IOException {
                DebugListener.this.log("!  ctx=%s r=%s onStartAsync %s", DebugListener.this.findContextName(((AsyncContextEvent) event).getServletContext()), DebugListener.this.findRequestName(event.getAsyncContext().getRequest()), ((AsyncContextEvent) event).getHttpChannelState());
            }

            @Override // javax.servlet.AsyncListener
            public void onError(AsyncEvent event) throws IOException {
                DebugListener.this.log("!! ctx=%s r=%s onError %s %s", DebugListener.this.findContextName(((AsyncContextEvent) event).getServletContext()), DebugListener.this.findRequestName(event.getAsyncContext().getRequest()), event.getThrowable(), ((AsyncContextEvent) event).getHttpChannelState());
            }

            @Override // javax.servlet.AsyncListener
            public void onComplete(AsyncEvent event) throws IOException {
                AsyncContextEvent ace = (AsyncContextEvent) event;
                String cname = DebugListener.this.findContextName(ace.getServletContext());
                String rname = DebugListener.this.findRequestName(ace.getAsyncContext().getRequest());
                Response response = Request.getBaseRequest(ace.getAsyncContext().getRequest()).getResponse();
                DebugListener.this.log("!  ctx=%s r=%s onComplete %s %d%s", cname, rname, ace.getHttpChannelState(), Integer.valueOf(response.getStatus()), DebugListener.this._showHeaders ? "\n" + response.getHttpFields().toString() : "");
            }
        };
        this._servletRequestListener = new ServletRequestListener() { // from class: org.eclipse.jetty.server.DebugListener.2
            @Override // javax.servlet.ServletRequestListener
            public void requestInitialized(ServletRequestEvent sre) {
                String cname = DebugListener.this.findContextName(sre.getServletContext());
                HttpServletRequest r = (HttpServletRequest) sre.getServletRequest();
                String rname = DebugListener.this.findRequestName(r);
                DispatcherType d = r.getDispatcherType();
                if (d == DispatcherType.REQUEST) {
                    Request br = Request.getBaseRequest(r);
                    String headers = DebugListener.this._showHeaders ? "\n" + br.getMetaData().getFields().toString() : "";
                    StringBuffer url = r.getRequestURL();
                    if (r.getQueryString() != null) {
                        url.append('?').append(r.getQueryString());
                    }
                    DebugListener.this.log(">> %s ctx=%s r=%s %s %s %s %s %s%s", d, cname, rname, d, r.getMethod(), url.toString(), r.getProtocol(), br.getHttpChannel(), headers);
                    return;
                }
                DebugListener.this.log(">> %s ctx=%s r=%s", d, cname, rname);
            }

            @Override // javax.servlet.ServletRequestListener
            public void requestDestroyed(ServletRequestEvent sre) {
                String cname = DebugListener.this.findContextName(sre.getServletContext());
                HttpServletRequest r = (HttpServletRequest) sre.getServletRequest();
                String rname = DebugListener.this.findRequestName(r);
                DispatcherType d = r.getDispatcherType();
                if (sre.getServletRequest().isAsyncStarted()) {
                    sre.getServletRequest().getAsyncContext().addListener(DebugListener.this._asyncListener);
                    DebugListener.this.log("<< %s ctx=%s r=%s async=true", d, cname, rname);
                    return;
                }
                DebugListener.this.log("<< %s ctx=%s r=%s async=false %d%s", d, cname, rname, Integer.valueOf(Request.getBaseRequest(r).getResponse().getStatus()), DebugListener.this._showHeaders ? "\n" + Request.getBaseRequest(r).getResponse().getHttpFields().toString() : "");
            }
        };
        this._contextScopeListener = new ContextHandler.ContextScopeListener() { // from class: org.eclipse.jetty.server.DebugListener.3
            @Override // org.eclipse.jetty.server.handler.ContextHandler.ContextScopeListener
            public void enterScope(ContextHandler.Context context, Request request, Object reason) {
                String cname = DebugListener.this.findContextName(context);
                if (request == null) {
                    DebugListener.this.log(">  ctx=%s %s", cname, reason);
                    return;
                }
                String rname = DebugListener.this.findRequestName(request);
                if (DebugListener.this._renameThread) {
                    Thread thread = Thread.currentThread();
                    thread.setName(String.format("%s#%s", thread.getName(), rname));
                }
                DebugListener.this.log(">  ctx=%s r=%s %s", cname, rname, reason);
            }

            @Override // org.eclipse.jetty.server.handler.ContextHandler.ContextScopeListener
            public void exitScope(ContextHandler.Context context, Request request) {
                String cname = DebugListener.this.findContextName(context);
                if (request == null) {
                    DebugListener.this.log("<  ctx=%s", cname);
                    return;
                }
                String rname = DebugListener.this.findRequestName(request);
                DebugListener.this.log("<  ctx=%s r=%s", cname, rname);
                if (DebugListener.this._renameThread) {
                    Thread thread = Thread.currentThread();
                    if (thread.getName().endsWith(rname)) {
                        thread.setName(thread.getName().substring(0, (thread.getName().length() - rname.length()) - 1));
                    }
                }
            }
        };
        this._out = out == null ? null : new PrintStream(out);
        this._renameThread = renameThread;
        this._showHeaders = showHeaders;
        this._dumpContext = dumpContext;
    }

    @ManagedAttribute("Rename thread within context scope")
    public boolean isRenameThread() {
        return this._renameThread;
    }

    public void setRenameThread(boolean renameThread) {
        this._renameThread = renameThread;
    }

    @ManagedAttribute("Show request headers")
    public boolean isShowHeaders() {
        return this._showHeaders;
    }

    public void setShowHeaders(boolean showHeaders) {
        this._showHeaders = showHeaders;
    }

    @ManagedAttribute("Dump contexts at start")
    public boolean isDumpContext() {
        return this._dumpContext;
    }

    public void setDumpContext(boolean dumpContext) {
        this._dumpContext = dumpContext;
    }

    @Override // javax.servlet.ServletContextListener
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().addListener((ServletContext) this._servletRequestListener);
        ContextHandler handler = ContextHandler.getContextHandler(sce.getServletContext());
        handler.addEventListener(this._contextScopeListener);
        log("^  ctx=%s %s", findContextName(sce.getServletContext()), sce.getServletContext());
        if (!this._dumpContext) {
            return;
        }
        if (this._out == null) {
            handler.dumpStdErr();
            System.err.println(Dumpable.KEY);
            return;
        }
        try {
            handler.dump(this._out);
            this._out.println(Dumpable.KEY);
        } catch (Exception e) {
            LOG.warn(e);
        }
    }

    @Override // javax.servlet.ServletContextListener
    public void contextDestroyed(ServletContextEvent sce) {
        log("v  ctx=%s %s", findContextName(sce.getServletContext()), sce.getServletContext());
    }

    protected String findContextName(ServletContext context) {
        if (context == null) {
            return null;
        }
        String n = (String) context.getAttribute(this._attr);
        if (n == null) {
            n = String.format("%s@%x", context.getContextPath(), Integer.valueOf(context.hashCode()));
            context.setAttribute(this._attr, n);
        }
        return n;
    }

    protected String findRequestName(ServletRequest request) {
        if (request == null) {
            return null;
        }
        HttpServletRequest r = (HttpServletRequest) request;
        String n = (String) request.getAttribute(this._attr);
        if (n == null) {
            n = String.format("%s@%x", r.getRequestURI(), Integer.valueOf(request.hashCode()));
            request.setAttribute(this._attr, n);
        }
        return n;
    }

    protected void log(String format, Object... arg) {
        if (isRunning()) {
            String s = String.format(format, arg);
            long now = System.currentTimeMillis();
            long ms = now % 1000;
            if (this._out != null) {
                this._out.printf("%s.%03d:%s%n", __date.formatNow(now), Long.valueOf(ms), s);
            }
            if (LOG.isDebugEnabled()) {
                LOG.info(s, new Object[0]);
            }
        }
    }
}
