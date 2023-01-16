package org.eclipse.jetty.server;

import org.eclipse.jetty.http.HttpCompliance;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.util.annotation.Name;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpConnectionFactory.class */
public class HttpConnectionFactory extends AbstractConnectionFactory implements HttpConfiguration.ConnectionFactory {
    private final HttpConfiguration _config;
    private HttpCompliance _httpCompliance;
    private boolean _recordHttpComplianceViolations;

    public HttpConnectionFactory() {
        this(new HttpConfiguration());
    }

    public HttpConnectionFactory(@Name("config") HttpConfiguration config) {
        this(config, null);
    }

    public HttpConnectionFactory(@Name("config") HttpConfiguration config, @Name("compliance") HttpCompliance compliance) {
        super(HttpVersion.HTTP_1_1.asString());
        this._recordHttpComplianceViolations = false;
        this._config = config;
        this._httpCompliance = compliance == null ? HttpCompliance.RFC7230 : compliance;
        if (config == null) {
            throw new IllegalArgumentException("Null HttpConfiguration");
        }
        addBean(this._config);
    }

    @Override // org.eclipse.jetty.server.HttpConfiguration.ConnectionFactory
    public HttpConfiguration getHttpConfiguration() {
        return this._config;
    }

    public HttpCompliance getHttpCompliance() {
        return this._httpCompliance;
    }

    public boolean isRecordHttpComplianceViolations() {
        return this._recordHttpComplianceViolations;
    }

    public void setHttpCompliance(HttpCompliance httpCompliance) {
        this._httpCompliance = httpCompliance;
    }

    @Override // org.eclipse.jetty.server.ConnectionFactory
    public Connection newConnection(Connector connector, EndPoint endPoint) {
        return configure(new HttpConnection(this._config, connector, endPoint, this._httpCompliance, isRecordHttpComplianceViolations()), connector, endPoint);
    }

    public void setRecordHttpComplianceViolations(boolean recordHttpComplianceViolations) {
        this._recordHttpComplianceViolations = recordHttpComplianceViolations;
    }
}
