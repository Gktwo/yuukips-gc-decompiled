package org.eclipse.jetty.server;

import java.io.IOException;
import java.util.Locale;
import javax.servlet.http.Cookie;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.pathmap.PathMappings;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.RequestLog;
import org.eclipse.jetty.util.DateCache;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.spi.AbstractComponentTracker;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/AbstractNCSARequestLog.class */
public class AbstractNCSARequestLog extends ContainerLifeCycle implements RequestLog {
    protected static final Logger LOG = Log.getLogger(AbstractNCSARequestLog.class);
    private static ThreadLocal<StringBuilder> _buffers = ThreadLocal.withInitial(() -> {
        return new StringBuilder(256);
    });
    protected final RequestLog.Writer _requestLogWriter;
    private String[] _ignorePaths;
    private boolean _extended;
    private transient PathMappings<String> _ignorePathMap;
    private boolean _preferProxiedForAddress;
    private transient DateCache _logDateCache;
    private boolean _logLatency = false;
    private boolean _logCookies = false;
    private boolean _logServer = false;
    private String _logDateFormat = CoreConstants.CLF_DATE_PATTERN;
    private Locale _logLocale = Locale.getDefault();
    private String _logTimeZone = "GMT";

    public AbstractNCSARequestLog(RequestLog.Writer requestLogWriter) {
        this._requestLogWriter = requestLogWriter;
        addBean(this._requestLogWriter);
    }

    protected boolean isEnabled() {
        return true;
    }

    public void write(String requestEntry) throws IOException {
        this._requestLogWriter.write(requestEntry);
    }

    private void append(StringBuilder buf, String s) {
        if (s == null || s.length() == 0) {
            buf.append('-');
        } else {
            buf.append(s);
        }
    }

    @Override // org.eclipse.jetty.server.RequestLog
    public void log(Request request, Response response) {
        try {
            if ((this._ignorePathMap == null || this._ignorePathMap.getMatched(request.getRequestURI()) == null) && isEnabled()) {
                StringBuilder buf = _buffers.get();
                buf.setLength(0);
                if (this._logServer) {
                    append(buf, request.getServerName());
                    buf.append(' ');
                }
                String addr = null;
                if (this._preferProxiedForAddress) {
                    addr = request.getHeader(HttpHeader.X_FORWARDED_FOR.toString());
                }
                if (addr == null) {
                    addr = request.getRemoteAddr();
                }
                buf.append(addr);
                buf.append(" - ");
                String auth = getAuthentication(request);
                append(buf, auth == null ? "-" : auth);
                buf.append(" [");
                if (this._logDateCache != null) {
                    buf.append(this._logDateCache.format(request.getTimeStamp()));
                } else {
                    buf.append(request.getTimeStamp());
                }
                buf.append("] \"");
                append(buf, request.getMethod());
                buf.append(' ');
                append(buf, request.getOriginalURI());
                buf.append(' ');
                append(buf, request.getProtocol());
                buf.append("\" ");
                int status = response.getCommittedMetaData().getStatus();
                if (status >= 0) {
                    buf.append((char) (48 + ((status / 100) % 10)));
                    buf.append((char) (48 + ((status / 10) % 10)));
                    buf.append((char) (48 + (status % 10)));
                } else {
                    buf.append(status);
                }
                long written = response.getHttpChannel().getBytesWritten();
                if (written >= 0) {
                    buf.append(' ');
                    if (written > 99999) {
                        buf.append(written);
                    } else {
                        if (written > 9999) {
                            buf.append((char) ((int) (48 + ((written / AbstractComponentTracker.LINGERING_TIMEOUT) % 10))));
                        }
                        if (written > 999) {
                            buf.append((char) ((int) (48 + ((written / 1000) % 10))));
                        }
                        if (written > 99) {
                            buf.append((char) ((int) (48 + ((written / 100) % 10))));
                        }
                        if (written > 9) {
                            buf.append((char) ((int) (48 + ((written / 10) % 10))));
                        }
                        buf.append((char) ((int) (48 + (written % 10))));
                    }
                    buf.append(' ');
                } else {
                    buf.append(" - ");
                }
                if (this._extended) {
                    logExtended(buf, request, response);
                }
                if (this._logCookies) {
                    Cookie[] cookies = request.getCookies();
                    if (cookies == null || cookies.length == 0) {
                        buf.append(" -");
                    } else {
                        buf.append(" \"");
                        for (int i = 0; i < cookies.length; i++) {
                            if (i != 0) {
                                buf.append(';');
                            }
                            buf.append(cookies[i].getName());
                            buf.append('=');
                            buf.append(cookies[i].getValue());
                        }
                        buf.append('\"');
                    }
                }
                if (this._logLatency) {
                    long now = System.currentTimeMillis();
                    if (this._logLatency) {
                        buf.append(' ');
                        buf.append(now - request.getTimeStamp());
                    }
                }
                write(buf.toString());
            }
        } catch (IOException e) {
            LOG.warn(e);
        }
    }

    protected String getAuthentication(Request request) {
        Authentication authentication = request.getAuthentication();
        if (authentication instanceof Authentication.User) {
            return ((Authentication.User) authentication).getUserIdentity().getUserPrincipal().getName();
        }
        return null;
    }

    protected void logExtended(StringBuilder b, Request request, Response response) throws IOException {
        String referer = request.getHeader(HttpHeader.REFERER.toString());
        if (referer == null) {
            b.append("\"-\" ");
        } else {
            b.append('\"');
            b.append(referer);
            b.append("\" ");
        }
        String agent = request.getHeader(HttpHeader.USER_AGENT.toString());
        if (agent == null) {
            b.append("\"-\"");
            return;
        }
        b.append('\"');
        b.append(agent);
        b.append('\"');
    }

    public void setIgnorePaths(String[] ignorePaths) {
        this._ignorePaths = ignorePaths;
    }

    public String[] getIgnorePaths() {
        return this._ignorePaths;
    }

    public void setLogCookies(boolean logCookies) {
        this._logCookies = logCookies;
    }

    public boolean getLogCookies() {
        return this._logCookies;
    }

    public void setLogServer(boolean logServer) {
        this._logServer = logServer;
    }

    public boolean getLogServer() {
        return this._logServer;
    }

    public void setLogLatency(boolean logLatency) {
        this._logLatency = logLatency;
    }

    public boolean getLogLatency() {
        return this._logLatency;
    }

    @Deprecated
    public void setLogDispatch(boolean value) {
    }

    @Deprecated
    public boolean isLogDispatch() {
        return false;
    }

    public void setPreferProxiedForAddress(boolean preferProxiedForAddress) {
        this._preferProxiedForAddress = preferProxiedForAddress;
    }

    public boolean getPreferProxiedForAddress() {
        return this._preferProxiedForAddress;
    }

    public void setExtended(boolean extended) {
        this._extended = extended;
    }

    @ManagedAttribute("use extended NCSA format")
    public boolean isExtended() {
        return this._extended;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public synchronized void doStart() throws Exception {
        if (this._logDateFormat != null) {
            this._logDateCache = new DateCache(this._logDateFormat, this._logLocale, this._logTimeZone);
        }
        if (this._ignorePaths == null || this._ignorePaths.length <= 0) {
            this._ignorePathMap = null;
        } else {
            this._ignorePathMap = new PathMappings<>();
            for (int i = 0; i < this._ignorePaths.length; i++) {
                this._ignorePathMap.put(this._ignorePaths[i], this._ignorePaths[i]);
            }
        }
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this._logDateCache = null;
        doStop();
    }

    public void setLogDateFormat(String format) {
        this._logDateFormat = format;
    }

    public String getLogDateFormat() {
        return this._logDateFormat;
    }

    public void setLogLocale(Locale logLocale) {
        this._logLocale = logLocale;
    }

    public Locale getLogLocale() {
        return this._logLocale;
    }

    public void setLogTimeZone(String tz) {
        this._logTimeZone = tz;
    }

    @ManagedAttribute("the timezone")
    public String getLogTimeZone() {
        return this._logTimeZone;
    }
}
