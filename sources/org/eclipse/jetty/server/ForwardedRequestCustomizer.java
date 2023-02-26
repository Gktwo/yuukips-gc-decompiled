package org.eclipse.jetty.server;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import emu.grasscutter.net.packet.PacketOpcodes;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.net.InetSocketAddress;
import java.util.Iterator;
import net.bytebuddy.utility.JavaConstant;
import org.eclipse.jetty.http.BadMessageException;
import org.eclipse.jetty.http.HostPortHttpField;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpScheme;
import org.eclipse.jetty.http.HttpURI;
import org.eclipse.jetty.http.QuotedCSVParser;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.util.ArrayTrie;
import org.eclipse.jetty.util.HostPort;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.Trie;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/ForwardedRequestCustomizer.class */
public class ForwardedRequestCustomizer implements HttpConfiguration.Customizer {
    private HostPortHttpField _forcedHost;
    private boolean _proxyAsAuthority = false;
    private boolean _forwardedPortAsAuthority = true;
    private String _forwardedHeader = HttpHeader.FORWARDED.toString();
    private String _forwardedHostHeader = HttpHeader.X_FORWARDED_HOST.toString();
    private String _forwardedServerHeader = HttpHeader.X_FORWARDED_SERVER.toString();
    private String _forwardedProtoHeader = HttpHeader.X_FORWARDED_PROTO.toString();
    private String _forwardedForHeader = HttpHeader.X_FORWARDED_FOR.toString();
    private String _forwardedPortHeader = HttpHeader.X_FORWARDED_PORT.toString();
    private String _forwardedHttpsHeader = "X-Proxied-Https";
    private String _forwardedCipherSuiteHeader = "Proxy-auth-cert";
    private String _forwardedSslSessionIdHeader = "Proxy-ssl-id";
    private boolean _sslIsSecure = true;
    private Trie<MethodHandle> _handles;

    public ForwardedRequestCustomizer() {
        updateHandles();
    }

    public boolean getProxyAsAuthority() {
        return this._proxyAsAuthority;
    }

    public void setProxyAsAuthority(boolean proxyAsAuthority) {
        this._proxyAsAuthority = proxyAsAuthority;
    }

    public void setForwardedOnly(boolean rfc7239only) {
        if (rfc7239only) {
            if (this._forwardedHeader == null) {
                this._forwardedHeader = HttpHeader.FORWARDED.toString();
            }
            this._forwardedHostHeader = null;
            this._forwardedServerHeader = null;
            this._forwardedForHeader = null;
            this._forwardedPortHeader = null;
            this._forwardedProtoHeader = null;
            this._forwardedHttpsHeader = null;
        } else {
            if (this._forwardedHostHeader == null) {
                this._forwardedHostHeader = HttpHeader.X_FORWARDED_HOST.toString();
            }
            if (this._forwardedServerHeader == null) {
                this._forwardedServerHeader = HttpHeader.X_FORWARDED_SERVER.toString();
            }
            if (this._forwardedForHeader == null) {
                this._forwardedForHeader = HttpHeader.X_FORWARDED_FOR.toString();
            }
            if (this._forwardedPortHeader == null) {
                this._forwardedPortHeader = HttpHeader.X_FORWARDED_PORT.toString();
            }
            if (this._forwardedProtoHeader == null) {
                this._forwardedProtoHeader = HttpHeader.X_FORWARDED_PROTO.toString();
            }
            if (this._forwardedHttpsHeader == null) {
                this._forwardedHttpsHeader = "X-Proxied-Https";
            }
        }
        updateHandles();
    }

    public String getForcedHost() {
        return this._forcedHost.getValue();
    }

    public void setForcedHost(String hostAndPort) {
        this._forcedHost = new HostPortHttpField(hostAndPort);
    }

    public String getForwardedHeader() {
        return this._forwardedHeader;
    }

    public void setForwardedHeader(String forwardedHeader) {
        if (this._forwardedHeader == null || !this._forwardedHeader.equals(forwardedHeader)) {
            this._forwardedHeader = forwardedHeader;
            updateHandles();
        }
    }

    public String getForwardedHostHeader() {
        return this._forwardedHostHeader;
    }

    public void setForwardedHostHeader(String forwardedHostHeader) {
        if (this._forwardedHostHeader == null || !this._forwardedHostHeader.equalsIgnoreCase(forwardedHostHeader)) {
            this._forwardedHostHeader = forwardedHostHeader;
            updateHandles();
        }
    }

    public String getForwardedServerHeader() {
        return this._forwardedServerHeader;
    }

    public void setForwardedServerHeader(String forwardedServerHeader) {
        if (this._forwardedServerHeader == null || !this._forwardedServerHeader.equalsIgnoreCase(forwardedServerHeader)) {
            this._forwardedServerHeader = forwardedServerHeader;
            updateHandles();
        }
    }

    public String getForwardedForHeader() {
        return this._forwardedForHeader;
    }

    public void setForwardedForHeader(String forwardedRemoteAddressHeader) {
        if (this._forwardedForHeader == null || !this._forwardedForHeader.equalsIgnoreCase(forwardedRemoteAddressHeader)) {
            this._forwardedForHeader = forwardedRemoteAddressHeader;
            updateHandles();
        }
    }

    public String getForwardedPortHeader() {
        return this._forwardedPortHeader;
    }

    public void setForwardedPortHeader(String forwardedPortHeader) {
        if (this._forwardedPortHeader == null || !this._forwardedPortHeader.equalsIgnoreCase(forwardedPortHeader)) {
            this._forwardedPortHeader = forwardedPortHeader;
            updateHandles();
        }
    }

    public boolean getForwardedPortAsAuthority() {
        return this._forwardedPortAsAuthority;
    }

    public void setForwardedPortAsAuthority(boolean forwardedPortAsAuthority) {
        this._forwardedPortAsAuthority = forwardedPortAsAuthority;
    }

    public String getForwardedProtoHeader() {
        return this._forwardedProtoHeader;
    }

    public void setForwardedProtoHeader(String forwardedProtoHeader) {
        if (this._forwardedProtoHeader == null || !this._forwardedProtoHeader.equalsIgnoreCase(forwardedProtoHeader)) {
            this._forwardedProtoHeader = forwardedProtoHeader;
            updateHandles();
        }
    }

    public String getForwardedCipherSuiteHeader() {
        return this._forwardedCipherSuiteHeader;
    }

    public void setForwardedCipherSuiteHeader(String forwardedCipherSuiteHeader) {
        if (this._forwardedCipherSuiteHeader == null || !this._forwardedCipherSuiteHeader.equalsIgnoreCase(forwardedCipherSuiteHeader)) {
            this._forwardedCipherSuiteHeader = forwardedCipherSuiteHeader;
            updateHandles();
        }
    }

    public String getForwardedSslSessionIdHeader() {
        return this._forwardedSslSessionIdHeader;
    }

    public void setForwardedSslSessionIdHeader(String forwardedSslSessionIdHeader) {
        if (this._forwardedSslSessionIdHeader == null || !this._forwardedSslSessionIdHeader.equalsIgnoreCase(forwardedSslSessionIdHeader)) {
            this._forwardedSslSessionIdHeader = forwardedSslSessionIdHeader;
            updateHandles();
        }
    }

    public String getForwardedHttpsHeader() {
        return this._forwardedHttpsHeader;
    }

    public void setForwardedHttpsHeader(String forwardedHttpsHeader) {
        if (this._forwardedHttpsHeader == null || !this._forwardedHttpsHeader.equalsIgnoreCase(forwardedHttpsHeader)) {
            this._forwardedHttpsHeader = forwardedHttpsHeader;
            updateHandles();
        }
    }

    public boolean isSslIsSecure() {
        return this._sslIsSecure;
    }

    public void setSslIsSecure(boolean sslIsSecure) {
        this._sslIsSecure = sslIsSecure;
    }

    @Override // org.eclipse.jetty.server.HttpConfiguration.Customizer
    public void customize(Connector connector, HttpConfiguration config, Request request) {
        HttpFields httpFields = request.getHttpFields();
        Forwarded forwarded = new Forwarded(request, config);
        boolean match = false;
        Iterator<HttpField> it = httpFields.iterator();
        while (it.hasNext()) {
            HttpField field = it.next();
            try {
                MethodHandle handle = this._handles.get(field.getName());
                if (handle != null) {
                    match = true;
                    handle.invoke(forwarded, field);
                }
            } catch (Throwable t) {
                onError(field, t);
            }
        }
        if (match) {
            if (forwarded.isSecure()) {
                request.setSecure(true);
            }
            if (forwarded._proto != null) {
                request.setScheme(forwarded._proto);
            } else if (forwarded._secureScheme) {
                request.setScheme(config.getSecureScheme());
            }
            if (forwarded._authority != null) {
                String host = forwarded._authority._host;
                int port = forwarded._authority._port;
                HttpURI requestURI = request.getMetaData().getURI();
                if (requestURI != null) {
                    if (host == null) {
                        host = requestURI.getHost();
                    }
                    if (port == -1) {
                        port = requestURI.getPort();
                    }
                    if (!host.equalsIgnoreCase(requestURI.getHost()) || port != requestURI.getPort()) {
                        httpFields.put(new HostPortHttpField(host, port));
                        request.setAuthority(host, port);
                    }
                }
            }
            if (forwarded.hasFor()) {
                request.setRemoteAddr(InetSocketAddress.createUnresolved(forwarded._for._host, forwarded._for._port > 0 ? forwarded._for._port : request.getRemotePort()));
            }
        }
    }

    protected static int getSecurePort(HttpConfiguration config) {
        return config.getSecurePort() > 0 ? config.getSecurePort() : PacketOpcodes.PersonalLineAllDataRsp;
    }

    protected void onError(HttpField field, Throwable t) {
        throw new BadMessageException("Bad header value for " + field.getName(), t);
    }

    protected static String getLeftMost(String headerValue) {
        if (headerValue == null) {
            return null;
        }
        int commaIndex = headerValue.indexOf(44);
        if (commaIndex == -1) {
            return headerValue;
        }
        return headerValue.substring(0, commaIndex).trim();
    }

    public String toString() {
        return String.format("%s@%x", getClass().getSimpleName(), Integer.valueOf(hashCode()));
    }

    @Deprecated
    public String getHostHeader() {
        return this._forcedHost.getValue();
    }

    @Deprecated
    public void setHostHeader(String hostHeader) {
        this._forcedHost = new HostPortHttpField(hostHeader);
    }

    private void updateHandles() {
        int size = 0;
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        while (true) {
            try {
                size += 128;
                this._handles = new ArrayTrie(size);
                if (!updateForwardedHandle(lookup, getForwardedHeader(), "handleRFC7239") && !updateForwardedHandle(lookup, getForwardedHostHeader(), "handleForwardedHost") && !updateForwardedHandle(lookup, getForwardedForHeader(), "handleForwardedFor") && !updateForwardedHandle(lookup, getForwardedPortHeader(), "handleForwardedPort") && !updateForwardedHandle(lookup, getForwardedProtoHeader(), "handleProto") && !updateForwardedHandle(lookup, getForwardedHttpsHeader(), "handleHttps") && !updateForwardedHandle(lookup, getForwardedServerHeader(), "handleForwardedServer") && !updateForwardedHandle(lookup, getForwardedCipherSuiteHeader(), "handleCipherSuite") && !updateForwardedHandle(lookup, getForwardedSslSessionIdHeader(), "handleSslSessionId")) {
                    return;
                }
            } catch (IllegalAccessException | NoSuchMethodException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private boolean updateForwardedHandle(MethodHandles.Lookup lookup, String headerName, String forwardedMethodName) throws NoSuchMethodException, IllegalAccessException {
        return !StringUtil.isBlank(headerName) && !this._handles.put(headerName, lookup.findVirtual(Forwarded.class, forwardedMethodName, MethodType.methodType(Void.TYPE, HttpField.class)));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ForwardedRequestCustomizer$MutableHostPort.class */
    public static class MutableHostPort {
        public static final int UNSET = -1;
        public static final int IMPLIED = 0;
        String _host;
        Source _hostSource;
        int _port;
        Source _portSource;

        private MutableHostPort() {
            this._hostSource = Source.UNSET;
            this._port = -1;
            this._portSource = Source.UNSET;
        }

        public void setHostPort(String host, int port, Source source) {
            setHost(host, source);
            setPort(port, source);
        }

        public void setHost(String host, Source source) {
            if (source.priority() > this._hostSource.priority()) {
                this._host = host;
                this._hostSource = source;
            }
        }

        public void setPort(int port, Source source) {
            if (source.priority() > this._portSource.priority()) {
                this._port = port;
                this._portSource = source;
            }
        }

        public void setHostPort(HostPort hostPort, Source source) {
            if (source.priority() > this._hostSource.priority()) {
                this._host = hostPort.getHost();
                this._hostSource = source;
            }
            if (hostPort.getPort() > 0 && source.priority() > this._portSource.priority()) {
                this._port = hostPort.getPort();
                this._portSource = source;
            } else if (this._port == -1) {
                this._port = 0;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MutableHostPort{");
            sb.append("host='").append(this._host).append("'/").append(this._hostSource);
            sb.append(", port=").append(this._port);
            sb.append("/").append(this._portSource);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ForwardedRequestCustomizer$Source.class */
    public enum Source {
        UNSET,
        XPROXIED_HTTPS,
        XFORWARDED_PROTO,
        XFORWARDED_SERVER,
        XFORWARDED_PORT,
        XFORWARDED_FOR,
        XFORWARDED_HOST,
        FORWARDED,
        FORCED;

        int priority() {
            return ordinal();
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ForwardedRequestCustomizer$Forwarded.class */
    private class Forwarded extends QuotedCSVParser {
        HttpConfiguration _config;
        Request _request;
        MutableHostPort _authority;
        MutableHostPort _for;
        String _proto;
        Boolean _secure;
        Source _protoSource = Source.UNSET;
        boolean _secureScheme = false;

        public Forwarded(Request request, HttpConfiguration config) {
            super(false);
            this._request = request;
            this._config = config;
            if (ForwardedRequestCustomizer.this._forcedHost != null) {
                getAuthority().setHostPort(ForwardedRequestCustomizer.this._forcedHost.getHostPort().getHost(), ForwardedRequestCustomizer.this._forcedHost.getHostPort().getPort(), Source.FORCED);
            }
        }

        public boolean isSecure() {
            return this._secure != null && this._secure.booleanValue();
        }

        public boolean hasFor() {
            return (this._for == null || this._for._host == null) ? false : true;
        }

        private MutableHostPort getAuthority() {
            if (this._authority == null) {
                this._authority = new MutableHostPort();
            }
            return this._authority;
        }

        private MutableHostPort getFor() {
            if (this._for == null) {
                this._for = new MutableHostPort();
            }
            return this._for;
        }

        public void handleCipherSuite(HttpField field) {
            this._request.setAttribute(SecureRequestCustomizer.JAVAX_SERVLET_REQUEST_CIPHER_SUITE, field.getValue());
            if (ForwardedRequestCustomizer.this.isSslIsSecure()) {
                this._secure = true;
                this._secureScheme = true;
            }
        }

        public void handleSslSessionId(HttpField field) {
            this._request.setAttribute(SecureRequestCustomizer.JAVAX_SERVLET_REQUEST_SSL_SESSION_ID, field.getValue());
            if (ForwardedRequestCustomizer.this.isSslIsSecure()) {
                this._secure = true;
                this._secureScheme = true;
            }
        }

        public void handleForwardedHost(HttpField field) {
            updateAuthority(ForwardedRequestCustomizer.getLeftMost(field.getValue()), Source.XFORWARDED_HOST);
        }

        public void handleForwardedFor(HttpField field) {
            getFor().setHostPort(new HostPort(ForwardedRequestCustomizer.getLeftMost(field.getValue())), Source.XFORWARDED_FOR);
        }

        public void handleForwardedServer(HttpField field) {
            if (!ForwardedRequestCustomizer.this.getProxyAsAuthority()) {
                updateAuthority(ForwardedRequestCustomizer.getLeftMost(field.getValue()), Source.XFORWARDED_SERVER);
            }
        }

        public void handleForwardedPort(HttpField field) {
            updatePort(HostPort.parsePort(ForwardedRequestCustomizer.getLeftMost(field.getValue())), Source.XFORWARDED_PORT);
        }

        public void handleProto(HttpField field) {
            updateProto(ForwardedRequestCustomizer.getLeftMost(field.getValue()), Source.XFORWARDED_PROTO);
        }

        public void handleHttps(HttpField field) {
            if ("on".equalsIgnoreCase(field.getValue()) || C3P0Substitutions.DEBUG.equalsIgnoreCase(field.getValue())) {
                this._secure = true;
                updateProto(HttpScheme.HTTPS.asString(), Source.XPROXIED_HTTPS);
                updatePort(ForwardedRequestCustomizer.getSecurePort(this._config), Source.XPROXIED_HTTPS);
            } else if ("off".equalsIgnoreCase(field.getValue()) || "false".equalsIgnoreCase(field.getValue())) {
                this._secure = false;
                updateProto(HttpScheme.HTTP.asString(), Source.XPROXIED_HTTPS);
                updatePort(0, Source.XPROXIED_HTTPS);
            } else {
                throw new BadMessageException("Invalid value for " + field.getName());
            }
        }

        public void handleRFC7239(HttpField field) {
            addValue(field.getValue());
        }

        @Override // org.eclipse.jetty.http.QuotedCSVParser
        protected void parsedParam(StringBuffer buffer, int valueLength, int paramName, int paramValue) {
            if (valueLength == 0 && paramValue > paramName) {
                String name = StringUtil.asciiToLowerCase(buffer.substring(paramName, paramValue - 1));
                String value = buffer.substring(paramValue);
                char c = 65535;
                switch (name.hashCode()) {
                    case 3159:
                        if (name.equals("by")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 101577:
                        if (name.equals("for")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3208616:
                        if (name.equals("host")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 106940904:
                        if (name.equals("proto")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        if (ForwardedRequestCustomizer.this.getProxyAsAuthority() && !value.startsWith(JavaConstant.Dynamic.DEFAULT_NAME) && !"unknown".equals(value)) {
                            HostPort hostField = new HostPort(value);
                            getAuthority().setHostPort(hostField.getHost(), hostField.getPort(), Source.FORWARDED);
                            return;
                        }
                        return;
                    case 1:
                        if (!value.startsWith(JavaConstant.Dynamic.DEFAULT_NAME) && !"unknown".equals(value)) {
                            HostPort hostField2 = new HostPort(value);
                            getFor().setHostPort(hostField2.getHost(), hostField2.getPort(), Source.FORWARDED);
                            return;
                        }
                        return;
                    case 2:
                        if (!value.startsWith(JavaConstant.Dynamic.DEFAULT_NAME) && !"unknown".equals(value)) {
                            HostPort hostField3 = new HostPort(value);
                            getAuthority().setHostPort(hostField3.getHost(), hostField3.getPort(), Source.FORWARDED);
                            return;
                        }
                        return;
                    case 3:
                        updateProto(value, Source.FORWARDED);
                        return;
                    default:
                        return;
                }
            }
        }

        private void updateAuthority(String value, Source source) {
            getAuthority().setHostPort(new HostPort(value), source);
        }

        private void updatePort(int port, Source source) {
            if (ForwardedRequestCustomizer.this.getForwardedPortAsAuthority()) {
                getAuthority().setPort(port, source);
            } else {
                getFor().setPort(port, source);
            }
        }

        private void updateProto(String proto, Source source) {
            if (source.priority() > this._protoSource.priority()) {
                this._proto = proto;
                this._protoSource = source;
                if (this._proto.equalsIgnoreCase(this._config.getSecureScheme())) {
                    this._secure = true;
                }
            }
        }
    }
}
