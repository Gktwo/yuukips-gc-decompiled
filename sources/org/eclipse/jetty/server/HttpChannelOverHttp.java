package org.eclipse.jetty.server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jetty.http.BadMessageException;
import org.eclipse.jetty.http.HostPortHttpField;
import org.eclipse.jetty.http.HttpCompliance;
import org.eclipse.jetty.http.HttpComplianceSection;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpGenerator;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpHeaderValue;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpParser;
import org.eclipse.jetty.http.HttpURI;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.http.MetaData;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.server.ConnectionFactory;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannelOverHttp.class */
public class HttpChannelOverHttp extends HttpChannel implements HttpParser.RequestHandler, HttpParser.ComplianceHandler {
    private static final Logger LOG = Log.getLogger(HttpChannelOverHttp.class);
    private static final HttpField PREAMBLE_UPGRADE_H2C = new HttpField(HttpHeader.UPGRADE, "h2c");
    private final HttpConnection _httpConnection;
    private HttpField _connection;
    private boolean _delayedForContent;
    private List<String> _complianceViolations;
    private HttpFields _trailers;
    private final HttpFields _fields = new HttpFields();
    private final MetaData.Request _metadata = new MetaData.Request(this._fields);
    private HttpField _upgrade = null;
    private boolean _unknownExpectation = false;
    private boolean _expect100Continue = false;
    private boolean _expect102Processing = false;

    public HttpChannelOverHttp(HttpConnection httpConnection, Connector connector, HttpConfiguration config, EndPoint endPoint, HttpTransport transport) {
        super(connector, config, endPoint, transport);
        this._httpConnection = httpConnection;
        this._metadata.setURI(new HttpURI());
    }

    @Override // org.eclipse.jetty.server.HttpChannel
    protected HttpInput newHttpInput(HttpChannelState state) {
        return new HttpInputOverHTTP(state);
    }

    @Override // org.eclipse.jetty.server.HttpChannel
    public void recycle() {
        recycle();
        this._unknownExpectation = false;
        this._expect100Continue = false;
        this._expect102Processing = false;
        this._metadata.recycle();
        this._connection = null;
        this._fields.clear();
        this._upgrade = null;
        this._trailers = null;
    }

    @Override // org.eclipse.jetty.server.HttpChannel
    public boolean isExpecting100Continue() {
        return this._expect100Continue;
    }

    @Override // org.eclipse.jetty.server.HttpChannel
    public boolean isExpecting102Processing() {
        return this._expect102Processing;
    }

    @Override // org.eclipse.jetty.http.HttpParser.RequestHandler
    public boolean startRequest(String method, String uri, HttpVersion version) {
        this._metadata.setMethod(method);
        this._metadata.getURI().parseRequestTarget(method, uri);
        this._metadata.setHttpVersion(version);
        this._unknownExpectation = false;
        this._expect100Continue = false;
        this._expect102Processing = false;
        return false;
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public void parsedHeader(HttpField field) {
        HttpHeader header = field.getHeader();
        String value = field.getValue();
        if (header != null) {
            switch (header) {
                case CONNECTION:
                    this._connection = field;
                    break;
                case HOST:
                    if (!this._metadata.getURI().isAbsolute() && (field instanceof HostPortHttpField)) {
                        HostPortHttpField hp = (HostPortHttpField) field;
                        this._metadata.getURI().setAuthority(hp.getHost(), hp.getPort());
                        break;
                    }
                    break;
                case EXPECT:
                    if (this._metadata.getHttpVersion() == HttpVersion.HTTP_1_1) {
                        HttpHeaderValue expect = HttpHeaderValue.CACHE.get(value);
                        switch (C56741.$SwitchMap$org$eclipse$jetty$http$HttpHeaderValue[(expect == null ? HttpHeaderValue.UNKNOWN : expect).ordinal()]) {
                            case 1:
                                this._expect100Continue = true;
                                break;
                            case 2:
                                this._expect102Processing = true;
                                break;
                            default:
                                String[] values = field.getValues();
                                int i = 0;
                                while (values != null && i < values.length) {
                                    HttpHeaderValue expect2 = HttpHeaderValue.CACHE.get(values[i].trim());
                                    if (expect2 == null) {
                                        this._unknownExpectation = true;
                                    } else {
                                        switch (expect2) {
                                            case CONTINUE:
                                                this._expect100Continue = true;
                                                continue;
                                            case PROCESSING:
                                                this._expect102Processing = true;
                                                continue;
                                            default:
                                                this._unknownExpectation = true;
                                                continue;
                                        }
                                    }
                                    i++;
                                }
                                break;
                        }
                    }
                    break;
                case UPGRADE:
                    this._upgrade = field;
                    break;
            }
        }
        this._fields.add(field);
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public void parsedTrailer(HttpField field) {
        if (this._trailers == null) {
            this._trailers = new HttpFields();
        }
        this._trailers.add(field);
    }

    @Override // org.eclipse.jetty.server.HttpChannel
    public void continue100(int available) throws IOException {
        if (isExpecting100Continue()) {
            this._expect100Continue = false;
            if (available != 0) {
                return;
            }
            if (getResponse().isCommitted()) {
                throw new IOException("Committed before 100 Continues");
            } else if (!sendResponse(HttpGenerator.CONTINUE_100_INFO, null, false)) {
                throw new IOException("Concurrent commit while trying to send 100-Continue");
            }
        }
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public void earlyEOF() {
        this._httpConnection.getGenerator().setPersistent(false);
        if (this._metadata.getMethod() == null) {
            this._httpConnection.close();
        } else if (onEarlyEOF() || this._delayedForContent) {
            this._delayedForContent = false;
            handle();
        }
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public boolean content(ByteBuffer content) {
        boolean handle = onContent(this._httpConnection.newContent(content)) || this._delayedForContent;
        this._delayedForContent = false;
        return handle;
    }

    @Override // org.eclipse.jetty.server.HttpChannel
    public void onAsyncWaitForContent() {
        this._httpConnection.asyncReadFillInterested();
    }

    @Override // org.eclipse.jetty.server.HttpChannel
    public void onBlockWaitForContent() {
        this._httpConnection.blockingReadFillInterested();
    }

    @Override // org.eclipse.jetty.server.HttpChannel
    public void onBlockWaitForContentFailure(Throwable failure) {
        this._httpConnection.blockingReadFailure(failure);
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public void badMessage(BadMessageException failure) {
        this._httpConnection.getGenerator().setPersistent(false);
        try {
            onRequest(this._metadata);
            getRequest().getHttpInput().earlyEOF();
        } catch (Exception e) {
            LOG.ignore(e);
        }
        onBadMessage(failure);
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public boolean headerComplete() {
        boolean persistent;
        if (this._complianceViolations != null && !this._complianceViolations.isEmpty()) {
            getRequest().setAttribute(HttpCompliance.VIOLATIONS_ATTR, this._complianceViolations);
            this._complianceViolations = null;
        }
        switch (this._metadata.getHttpVersion()) {
            case HTTP_0_9:
                persistent = false;
                break;
            case HTTP_1_0:
                if (!getHttpConfiguration().isPersistentConnectionsEnabled()) {
                    persistent = false;
                } else if (this._connection == null) {
                    persistent = false;
                } else if (this._connection.contains(HttpHeaderValue.KEEP_ALIVE.asString())) {
                    persistent = true;
                } else {
                    persistent = this._fields.contains(HttpHeader.CONNECTION, HttpHeaderValue.KEEP_ALIVE.asString());
                }
                if (!persistent) {
                    persistent = HttpMethod.CONNECT.m40is(this._metadata.getMethod());
                }
                if (persistent) {
                    getResponse().getHttpFields().add(HttpHeader.CONNECTION, HttpHeaderValue.KEEP_ALIVE);
                    break;
                }
                break;
            case HTTP_1_1:
                if (this._unknownExpectation) {
                    badMessage(new BadMessageException(417));
                    return false;
                }
                if (!getHttpConfiguration().isPersistentConnectionsEnabled()) {
                    persistent = false;
                } else if (this._connection == null) {
                    persistent = true;
                } else if (this._connection.contains(HttpHeaderValue.CLOSE.asString())) {
                    persistent = false;
                } else {
                    persistent = !this._fields.contains(HttpHeader.CONNECTION, HttpHeaderValue.CLOSE.asString());
                }
                if (!persistent) {
                    persistent = HttpMethod.CONNECT.m40is(this._metadata.getMethod());
                }
                if (!persistent) {
                    getResponse().getHttpFields().add(HttpHeader.CONNECTION, HttpHeaderValue.CLOSE);
                }
                if (this._upgrade != null && upgrade()) {
                    return true;
                }
                break;
            case HTTP_2:
                this._upgrade = PREAMBLE_UPGRADE_H2C;
                if (HttpMethod.PRI.m40is(this._metadata.getMethod()) && "*".equals(this._metadata.getURI().toString()) && this._fields.size() == 0 && upgrade()) {
                    return true;
                }
                badMessage(new BadMessageException(426));
                this._httpConnection.getParser().close();
                return false;
            default:
                throw new IllegalStateException("unsupported version " + this._metadata.getHttpVersion());
        }
        if (!persistent) {
            this._httpConnection.getGenerator().setPersistent(false);
        }
        onRequest(this._metadata);
        this._delayedForContent = getHttpConfiguration().isDelayDispatchUntilContent() && (this._httpConnection.getParser().getContentLength() > 0 || this._httpConnection.getParser().isChunking()) && !isExpecting100Continue() && !isCommitted() && this._httpConnection.isRequestBufferEmpty();
        return !this._delayedForContent;
    }

    /* access modifiers changed from: package-private */
    public boolean onIdleTimeout(Throwable timeout) {
        if (!this._delayedForContent) {
            return true;
        }
        this._delayedForContent = false;
        getRequest().getHttpInput().onIdleTimeout(timeout);
        execute(this);
        return false;
    }

    private boolean upgrade() throws BadMessageException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("upgrade {} {}", this, this._upgrade);
        }
        boolean isUpgradedH2C = this._upgrade == PREAMBLE_UPGRADE_H2C;
        if (isUpgradedH2C || (this._connection != null && this._connection.contains("upgrade"))) {
            ConnectionFactory.Upgrading factory = null;
            Iterator<ConnectionFactory> it = getConnector().getConnectionFactories().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ConnectionFactory f = it.next();
                if ((f instanceof ConnectionFactory.Upgrading) && f.getProtocols().contains(this._upgrade.getValue())) {
                    factory = (ConnectionFactory.Upgrading) f;
                    break;
                }
            }
            if (factory != null) {
                HttpFields response101 = new HttpFields();
                Connection upgradeConnection = factory.upgradeConnection(getConnector(), getEndPoint(), this._metadata, response101);
                if (upgradeConnection != null) {
                    if (!isUpgradedH2C) {
                        try {
                            sendResponse(new MetaData.Response(HttpVersion.HTTP_1_1, 101, response101, 0), null, true);
                        } catch (IOException e) {
                            throw new BadMessageException(500, null, e);
                        }
                    }
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Upgrade from {} to {}", getEndPoint().getConnection(), upgradeConnection);
                    }
                    getRequest().setAttribute(HttpConnection.UPGRADE_CONNECTION_ATTRIBUTE, upgradeConnection);
                    getResponse().setStatus(101);
                    getHttpTransport().onCompleted();
                    return true;
                } else if (!LOG.isDebugEnabled()) {
                    return false;
                } else {
                    LOG.debug("Upgrade ignored for {} by {}", this._upgrade, factory);
                    return false;
                }
            } else if (!LOG.isDebugEnabled()) {
                return false;
            } else {
                LOG.debug("No factory for {} in {}", this._upgrade, getConnector());
                return false;
            }
        } else {
            throw new BadMessageException(400);
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.HttpChannel
    public void handleException(Throwable x) {
        this._httpConnection.getGenerator().setPersistent(false);
        handleException(x);
    }

    @Override // org.eclipse.jetty.server.HttpChannel
    public void abort(Throwable failure) {
        abort(failure);
        this._httpConnection.getGenerator().setPersistent(false);
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public boolean contentComplete() {
        boolean handle = onContentComplete() || this._delayedForContent;
        this._delayedForContent = false;
        return handle;
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public boolean messageComplete() {
        if (this._trailers != null) {
            onTrailers(this._trailers);
        }
        return onRequestComplete();
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public int getHeaderCacheSize() {
        return getHttpConfiguration().getHeaderCacheSize();
    }

    @Override // org.eclipse.jetty.http.HttpParser.ComplianceHandler
    public void onComplianceViolation(HttpCompliance compliance, HttpComplianceSection violation, String reason) {
        if (this._httpConnection.isRecordHttpComplianceViolations()) {
            if (this._complianceViolations == null) {
                this._complianceViolations = new ArrayList();
            }
            String record = String.format("%s (see %s) in mode %s for %s in %s", violation.getDescription(), violation.getURL(), compliance, reason, getHttpTransport());
            this._complianceViolations.add(record);
            if (LOG.isDebugEnabled()) {
                LOG.debug(record, new Object[0]);
            }
        }
    }
}
