package org.eclipse.jetty.server.handler;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HostPortHttpField;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.QuotedCSV;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.util.IncludeExcludeSet;
import org.eclipse.jetty.util.InetAddressSet;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.annotation.Name;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Locker;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ThreadLimitHandler.class */
public class ThreadLimitHandler extends HandlerWrapper {
    private static final Logger LOG = Log.getLogger(ThreadLimitHandler.class);
    private static final String REMOTE = "o.e.j.s.h.TLH.REMOTE";
    private static final String PERMIT = "o.e.j.s.h.TLH.PASS";
    private final boolean _rfc7239;
    private final String _forwardedHeader;
    private final IncludeExcludeSet<String, InetAddress> _includeExcludeSet;
    private final ConcurrentMap<String, Remote> _remotes;
    private volatile boolean _enabled;
    private int _threadLimit;

    public ThreadLimitHandler() {
        this(null, false);
    }

    public ThreadLimitHandler(@Name("forwardedHeader") String forwardedHeader) {
        this(forwardedHeader, HttpHeader.FORWARDED.m42is(forwardedHeader));
    }

    public ThreadLimitHandler(@Name("forwardedHeader") String forwardedHeader, @Name("rfc7239") boolean rfc7239) {
        this._includeExcludeSet = new IncludeExcludeSet<>(InetAddressSet.class);
        this._remotes = new ConcurrentHashMap();
        this._threadLimit = 10;
        this._rfc7239 = rfc7239;
        this._forwardedHeader = forwardedHeader;
        this._enabled = true;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        doStart();
        LOG.info(String.format("ThreadLimitHandler enable=%b limit=%d include=%s", Boolean.valueOf(this._enabled), Integer.valueOf(this._threadLimit), this._includeExcludeSet), new Object[0]);
    }

    @ManagedAttribute("true if this handler is enabled")
    public boolean isEnabled() {
        return this._enabled;
    }

    public void setEnabled(boolean enabled) {
        this._enabled = enabled;
        LOG.info(String.format("ThreadLimitHandler enable=%b limit=%d include=%s", Boolean.valueOf(this._enabled), Integer.valueOf(this._threadLimit), this._includeExcludeSet), new Object[0]);
    }

    @ManagedAttribute("The maximum threads that can be dispatched per remote IP")
    public int getThreadLimit() {
        return this._threadLimit;
    }

    public void setThreadLimit(int threadLimit) {
        if (threadLimit <= 0) {
            throw new IllegalArgumentException("limit must be >0");
        }
        this._threadLimit = threadLimit;
    }

    @ManagedOperation("Include IP in thread limits")
    public void include(String inetAddressPattern) {
        this._includeExcludeSet.include((IncludeExcludeSet<String, InetAddress>) inetAddressPattern);
    }

    @ManagedOperation("Exclude IP from thread limits")
    public void exclude(String inetAddressPattern) {
        this._includeExcludeSet.exclude((IncludeExcludeSet<String, InetAddress>) inetAddressPattern);
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Closeable permit;
        if (!this._enabled) {
            handle(target, baseRequest, request, response);
            return;
        }
        Remote remote = getRemote(baseRequest);
        if (remote == null) {
            handle(target, baseRequest, request, response);
            return;
        }
        try {
            permit = (Closeable) baseRequest.getAttribute(PERMIT);
            try {
                if (permit != null) {
                    baseRequest.removeAttribute(PERMIT);
                } else {
                    CompletableFuture<Closeable> futurePermit = remote.acquire();
                    if (futurePermit.isDone()) {
                        permit = futurePermit.get();
                    } else {
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Threadlimited {} {}", remote, target);
                        }
                        AsyncContext async = baseRequest.startAsync();
                        async.setTimeout(0);
                        futurePermit.thenAccept(c -> {
                            baseRequest.setAttribute(PERMIT, c);
                            async.dispatch();
                        });
                        if (permit != null) {
                            permit.close();
                            return;
                        }
                        return;
                    }
                }
                handle(target, baseRequest, request, response);
                if (permit != null) {
                    permit.close();
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new ServletException(e);
            }
        } catch (Throwable th) {
            if (permit != null) {
                permit.close();
            }
            throw th;
        }
    }

    protected int getThreadLimit(String ip) {
        if (!this._includeExcludeSet.isEmpty()) {
            try {
                if (!this._includeExcludeSet.test(InetAddress.getByName(ip))) {
                    LOG.debug("excluded {}", ip);
                    return 0;
                }
            } catch (Exception e) {
                LOG.ignore(e);
            }
        }
        return this._threadLimit;
    }

    protected Remote getRemote(Request baseRequest) {
        int limit;
        Remote remote = (Remote) baseRequest.getAttribute(REMOTE);
        if (remote != null) {
            return remote;
        }
        String ip = getRemoteIP(baseRequest);
        LOG.debug("ip={}", ip);
        if (ip == null || (limit = getThreadLimit(ip)) <= 0) {
            return null;
        }
        Remote remote2 = this._remotes.get(ip);
        if (remote2 == null) {
            Remote r = new Remote(ip, limit);
            remote2 = this._remotes.putIfAbsent(ip, r);
            if (remote2 == null) {
                remote2 = r;
            }
        }
        baseRequest.setAttribute(REMOTE, remote2);
        return remote2;
    }

    protected String getRemoteIP(Request baseRequest) {
        if (this._forwardedHeader != null && !this._forwardedHeader.isEmpty()) {
            String remote = this._rfc7239 ? getForwarded(baseRequest) : getXForwardedFor(baseRequest);
            if (remote != null && !remote.isEmpty()) {
                return remote;
            }
        }
        InetSocketAddress inetAddr = baseRequest.getHttpChannel().getRemoteAddress();
        if (inetAddr == null || inetAddr.getAddress() == null) {
            return null;
        }
        return inetAddr.getAddress().getHostAddress();
    }

    private String getForwarded(Request request) {
        RFC7239 rfc7239 = new RFC7239();
        Iterator<HttpField> it = request.getHttpFields().iterator();
        while (it.hasNext()) {
            HttpField field = it.next();
            if (this._forwardedHeader.equalsIgnoreCase(field.getName())) {
                rfc7239.addValue(field.getValue());
            }
        }
        if (rfc7239.getFor() != null) {
            return new HostPortHttpField(rfc7239.getFor()).getHost();
        }
        return null;
    }

    private String getXForwardedFor(Request request) {
        String forwardedFor = null;
        Iterator<HttpField> it = request.getHttpFields().iterator();
        while (it.hasNext()) {
            HttpField field = it.next();
            if (this._forwardedHeader.equalsIgnoreCase(field.getName())) {
                forwardedFor = field.getValue();
            }
        }
        if (forwardedFor == null || forwardedFor.isEmpty()) {
            return null;
        }
        int comma = forwardedFor.lastIndexOf(44);
        return comma >= 0 ? forwardedFor.substring(comma + 1).trim() : forwardedFor;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ThreadLimitHandler$Remote.class */
    public final class Remote implements Closeable {
        private final String _ip;
        private final int _limit;
        private int _permits;
        private final Locker _locker = new Locker();
        private Deque<CompletableFuture<Closeable>> _queue = new ArrayDeque();
        private final CompletableFuture<Closeable> _permitted = CompletableFuture.completedFuture(this);

        public Remote(String ip, int limit) {
            this._ip = ip;
            this._limit = limit;
        }

        public CompletableFuture<Closeable> acquire() {
            Locker.Lock lock = this._locker.lock();
            try {
                if (this._permits < this._limit) {
                    this._permits++;
                    CompletableFuture<Closeable> completableFuture = this._permitted;
                    if (lock != null) {
                        lock.close();
                    }
                    return completableFuture;
                }
                CompletableFuture<Closeable> pass = new CompletableFuture<>();
                this._queue.addLast(pass);
                if (lock != null) {
                    lock.close();
                }
                return pass;
            } catch (Throwable th) {
                if (lock != null) {
                    try {
                        lock.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
            r4._permits++;
         */
        @Override // java.io.Closeable, java.lang.AutoCloseable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r4 = this;
                r0 = r4
                org.eclipse.jetty.util.thread.Locker r0 = r0._locker
                org.eclipse.jetty.util.thread.Locker$Lock r0 = r0.lock()
                r5 = r0
                r0 = r4
                r1 = r0
                int r1 = r1._permits     // Catch: Throwable -> 0x0049
                r2 = 1
                int r1 = r1 - r2
                r0._permits = r1     // Catch: Throwable -> 0x0049
            L_0x0012:
                r0 = r4
                java.util.Deque<java.util.concurrent.CompletableFuture<java.io.Closeable>> r0 = r0._queue     // Catch: Throwable -> 0x0049
                java.lang.Object r0 = r0.pollFirst()     // Catch: Throwable -> 0x0049
                java.util.concurrent.CompletableFuture r0 = (java.util.concurrent.CompletableFuture) r0     // Catch: Throwable -> 0x0049
                r6 = r0
                r0 = r6
                if (r0 != 0) goto L_0x0026
                goto L_0x003e
            L_0x0026:
                r0 = r6
                r1 = r4
                boolean r0 = r0.complete(r1)     // Catch: Throwable -> 0x0049
                if (r0 == 0) goto L_0x003b
                r0 = r4
                r1 = r0
                int r1 = r1._permits     // Catch: Throwable -> 0x0049
                r2 = 1
                int r1 = r1 + r2
                r0._permits = r1     // Catch: Throwable -> 0x0049
                goto L_0x003e
            L_0x003b:
                goto L_0x0012
            L_0x003e:
                r0 = r5
                if (r0 == 0) goto L_0x005d
                r0 = r5
                r0.close()
                goto L_0x005d
            L_0x0049:
                r6 = move-exception
                r0 = r5
                if (r0 == 0) goto L_0x005b
                r0 = r5
                r0.close()     // Catch: Throwable -> 0x0055
                goto L_0x005b
            L_0x0055:
                r7 = move-exception
                r0 = r6
                r1 = r7
                r0.addSuppressed(r1)
            L_0x005b:
                r0 = r6
                throw r0
            L_0x005d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.handler.ThreadLimitHandler.Remote.close():void");
        }

        @Override // java.lang.Object
        public String toString() {
            Locker.Lock lock = this._locker.lock();
            try {
                String format = String.format("R[ip=%s,p=%d,l=%d,q=%d]", this._ip, Integer.valueOf(this._permits), Integer.valueOf(this._limit), Integer.valueOf(this._queue.size()));
                if (lock != null) {
                    lock.close();
                }
                return format;
            } catch (Throwable th) {
                if (lock != null) {
                    try {
                        lock.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ThreadLimitHandler$RFC7239.class */
    public final class RFC7239 extends QuotedCSV {
        String _for;

        private RFC7239() {
            super(false, new String[0]);
        }

        String getFor() {
            return this._for;
        }

        @Override // org.eclipse.jetty.http.QuotedCSVParser
        protected void parsedParam(StringBuffer buffer, int valueLength, int paramName, int paramValue) {
            if (valueLength == 0 && paramValue > paramName && "for".equalsIgnoreCase(StringUtil.asciiToLowerCase(buffer.substring(paramName, paramValue - 1)))) {
                String value = buffer.substring(paramValue);
                if ("unknown".equalsIgnoreCase(value)) {
                    this._for = null;
                } else {
                    this._for = value;
                }
            }
        }
    }
}
