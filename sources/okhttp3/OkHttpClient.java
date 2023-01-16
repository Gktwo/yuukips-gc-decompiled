package okhttp3;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.net.Proxy;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.WebSocket;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.p021ws.RealWebSocket;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OkHttpClient.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018�� y2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002xyB\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u000f\b��\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\bSJ\u000f\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\bTJ\r\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\bUJ\r\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\bVJ\r\u0010\u0017\u001a\u00020\u000fH\u0007¢\u0006\u0002\bWJ\r\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\bXJ\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007¢\u0006\u0002\bYJ\r\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0002\bZJ\r\u0010\"\u001a\u00020#H\u0007¢\u0006\u0002\b[J\r\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\b\\J\r\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\b]J\r\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\b^J\r\u0010.\u001a\u00020,H\u0007¢\u0006\u0002\b_J\r\u0010/\u001a\u000200H\u0007¢\u0006\u0002\b`J\u0013\u00102\u001a\b\u0012\u0004\u0012\u0002030\u001cH\u0007¢\u0006\u0002\baJ\u0013\u00107\u001a\b\u0012\u0004\u0012\u0002030\u001cH\u0007¢\u0006\u0002\bbJ\b\u0010c\u001a\u00020\u0006H\u0016J\u0010\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0016J\u0018\u0010h\u001a\u00020i2\u0006\u0010f\u001a\u00020g2\u0006\u0010j\u001a\u00020kH\u0016J\r\u00108\u001a\u00020\u000fH\u0007¢\u0006\u0002\blJ\u0013\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u001cH\u0007¢\u0006\u0002\bmJ\u000f\u0010;\u001a\u0004\u0018\u00010<H\u0007¢\u0006\u0002\bnJ\r\u0010>\u001a\u00020\tH\u0007¢\u0006\u0002\boJ\r\u0010?\u001a\u00020@H\u0007¢\u0006\u0002\bpJ\r\u0010B\u001a\u00020\u000fH\u0007¢\u0006\u0002\bqJ\r\u0010C\u001a\u00020,H\u0007¢\u0006\u0002\brJ\r\u0010H\u001a\u00020IH\u0007¢\u0006\u0002\bsJ\r\u0010K\u001a\u00020LH\u0007¢\u0006\u0002\btJ\b\u0010u\u001a\u00020vH\u0002J\r\u0010O\u001a\u00020\u000fH\u0007¢\u0006\u0002\bwR\u0013\u0010\b\u001a\u00020\t8G¢\u0006\b\n��\u001a\u0004\b\b\u0010\nR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f8G¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\rR\u0013\u0010\u000e\u001a\u00020\u000f8G¢\u0006\b\n��\u001a\u0004\b\u000e\u0010\u0010R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u00128G¢\u0006\b\n��\u001a\u0004\b\u0011\u0010\u0013R\u0013\u0010\u0014\u001a\u00020\u00158G¢\u0006\b\n��\u001a\u0004\b\u0014\u0010\u0016R\u0013\u0010\u0017\u001a\u00020\u000f8G¢\u0006\b\n��\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u0018\u001a\u00020\u00198G¢\u0006\b\n��\u001a\u0004\b\u0018\u0010\u001aR\u0019\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8G¢\u0006\b\n��\u001a\u0004\b\u001b\u0010\u001eR\u0013\u0010\u001f\u001a\u00020 8G¢\u0006\b\n��\u001a\u0004\b\u001f\u0010!R\u0013\u0010\"\u001a\u00020#8G¢\u0006\b\n��\u001a\u0004\b\"\u0010$R\u0013\u0010%\u001a\u00020&8G¢\u0006\b\n��\u001a\u0004\b%\u0010'R\u0013\u0010(\u001a\u00020)8G¢\u0006\b\n��\u001a\u0004\b(\u0010*R\u0013\u0010+\u001a\u00020,8G¢\u0006\b\n��\u001a\u0004\b+\u0010-R\u0013\u0010.\u001a\u00020,8G¢\u0006\b\n��\u001a\u0004\b.\u0010-R\u0013\u0010/\u001a\u0002008G¢\u0006\b\n��\u001a\u0004\b/\u00101R\u0019\u00102\u001a\b\u0012\u0004\u0012\u0002030\u001c8G¢\u0006\b\n��\u001a\u0004\b2\u0010\u001eR\u0013\u00104\u001a\u0002058G¢\u0006\b\n��\u001a\u0004\b4\u00106R\u0019\u00107\u001a\b\u0012\u0004\u0012\u0002030\u001c8G¢\u0006\b\n��\u001a\u0004\b7\u0010\u001eR\u0013\u00108\u001a\u00020\u000f8G¢\u0006\b\n��\u001a\u0004\b8\u0010\u0010R\u0019\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u001c8G¢\u0006\b\n��\u001a\u0004\b9\u0010\u001eR\u0015\u0010;\u001a\u0004\u0018\u00010<8G¢\u0006\b\n��\u001a\u0004\b;\u0010=R\u0013\u0010>\u001a\u00020\t8G¢\u0006\b\n��\u001a\u0004\b>\u0010\nR\u0013\u0010?\u001a\u00020@8G¢\u0006\b\n��\u001a\u0004\b?\u0010AR\u0013\u0010B\u001a\u00020\u000f8G¢\u0006\b\n��\u001a\u0004\bB\u0010\u0010R\u0013\u0010C\u001a\u00020,8G¢\u0006\b\n��\u001a\u0004\bC\u0010-R\u0011\u0010D\u001a\u00020E¢\u0006\b\n��\u001a\u0004\bF\u0010GR\u0013\u0010H\u001a\u00020I8G¢\u0006\b\n��\u001a\u0004\bH\u0010JR\u0011\u0010K\u001a\u00020L8G¢\u0006\u0006\u001a\u0004\bK\u0010MR\u0010\u0010N\u001a\u0004\u0018\u00010LX\u0004¢\u0006\u0002\n��R\u0013\u0010O\u001a\u00020\u000f8G¢\u0006\b\n��\u001a\u0004\bO\u0010\u0010R\u0015\u0010P\u001a\u0004\u0018\u00010Q8G¢\u0006\b\n��\u001a\u0004\bP\u0010R¨\u0006z"}, m373d2 = {"Lokhttp3/OkHttpClient;", "", "Lokhttp3/Call$Factory;", "Lokhttp3/WebSocket$Factory;", "()V", "builder", "Lokhttp3/OkHttpClient$Builder;", "(Lokhttp3/OkHttpClient$Builder;)V", "authenticator", "Lokhttp3/Authenticator;", "()Lokhttp3/Authenticator;", "cache", "Lokhttp3/Cache;", "()Lokhttp3/Cache;", "callTimeoutMillis", "", "()I", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "certificatePinner", "Lokhttp3/CertificatePinner;", "()Lokhttp3/CertificatePinner;", "connectTimeoutMillis", "connectionPool", "Lokhttp3/ConnectionPool;", "()Lokhttp3/ConnectionPool;", "connectionSpecs", "", "Lokhttp3/ConnectionSpec;", "()Ljava/util/List;", "cookieJar", "Lokhttp3/CookieJar;", "()Lokhttp3/CookieJar;", "dispatcher", "Lokhttp3/Dispatcher;", "()Lokhttp3/Dispatcher;", "dns", "Lokhttp3/Dns;", "()Lokhttp3/Dns;", "eventListenerFactory", "Lokhttp3/EventListener$Factory;", "()Lokhttp3/EventListener$Factory;", "followRedirects", "", "()Z", "followSslRedirects", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "()Ljavax/net/ssl/HostnameVerifier;", "interceptors", "Lokhttp3/Interceptor;", "minWebSocketMessageToCompress", "", "()J", "networkInterceptors", "pingIntervalMillis", "protocols", "Lokhttp3/Protocol;", "proxy", "Ljava/net/Proxy;", "()Ljava/net/Proxy;", "proxyAuthenticator", "proxySelector", "Ljava/net/ProxySelector;", "()Ljava/net/ProxySelector;", "readTimeoutMillis", "retryOnConnectionFailure", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase", "()Lokhttp3/internal/connection/RouteDatabase;", "socketFactory", "Ljavax/net/SocketFactory;", "()Ljavax/net/SocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactoryOrNull", "writeTimeoutMillis", "x509TrustManager", "Ljavax/net/ssl/X509TrustManager;", "()Ljavax/net/ssl/X509TrustManager;", "-deprecated_authenticator", "-deprecated_cache", "-deprecated_callTimeoutMillis", "-deprecated_certificatePinner", "-deprecated_connectTimeoutMillis", "-deprecated_connectionPool", "-deprecated_connectionSpecs", "-deprecated_cookieJar", "-deprecated_dispatcher", "-deprecated_dns", "-deprecated_eventListenerFactory", "-deprecated_followRedirects", "-deprecated_followSslRedirects", "-deprecated_hostnameVerifier", "-deprecated_interceptors", "-deprecated_networkInterceptors", "newBuilder", "newCall", "Lokhttp3/Call;", "request", "Lokhttp3/Request;", "newWebSocket", "Lokhttp3/WebSocket;", "listener", "Lokhttp3/WebSocketListener;", "-deprecated_pingIntervalMillis", "-deprecated_protocols", "-deprecated_proxy", "-deprecated_proxyAuthenticator", "-deprecated_proxySelector", "-deprecated_readTimeoutMillis", "-deprecated_retryOnConnectionFailure", "-deprecated_socketFactory", "-deprecated_sslSocketFactory", "verifyClientState", "", "-deprecated_writeTimeoutMillis", "Builder", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/OkHttpClient.class */
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    @NotNull
    private final Dispatcher dispatcher;
    @NotNull
    private final ConnectionPool connectionPool;
    @NotNull
    private final List<Interceptor> interceptors;
    @NotNull
    private final List<Interceptor> networkInterceptors;
    @NotNull
    private final EventListener.Factory eventListenerFactory;
    private final boolean retryOnConnectionFailure;
    @NotNull
    private final Authenticator authenticator;
    private final boolean followRedirects;
    private final boolean followSslRedirects;
    @NotNull
    private final CookieJar cookieJar;
    @Nullable
    private final Cache cache;
    @NotNull
    private final Dns dns;
    @Nullable
    private final Proxy proxy;
    @NotNull
    private final ProxySelector proxySelector;
    @NotNull
    private final Authenticator proxyAuthenticator;
    @NotNull
    private final SocketFactory socketFactory;
    @Nullable
    private final SSLSocketFactory sslSocketFactoryOrNull;
    @Nullable
    private final X509TrustManager x509TrustManager;
    @NotNull
    private final List<ConnectionSpec> connectionSpecs;
    @NotNull
    private final List<Protocol> protocols;
    @NotNull
    private final HostnameVerifier hostnameVerifier;
    @NotNull
    private final CertificatePinner certificatePinner;
    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;
    private final int callTimeoutMillis;
    private final int connectTimeoutMillis;
    private final int readTimeoutMillis;
    private final int writeTimeoutMillis;
    private final int pingIntervalMillis;
    private final long minWebSocketMessageToCompress;
    @NotNull
    private final RouteDatabase routeDatabase;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableListOf(Protocol.HTTP_2, Protocol.HTTP_1_1);
    @NotNull
    private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = Util.immutableListOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    public OkHttpClient(@NotNull Builder builder) {
        NullProxySelector nullProxySelector;
        boolean z;
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.dispatcher = builder.getDispatcher$okhttp();
        this.connectionPool = builder.getConnectionPool$okhttp();
        this.interceptors = Util.toImmutableList(builder.getInterceptors$okhttp());
        this.networkInterceptors = Util.toImmutableList(builder.getNetworkInterceptors$okhttp());
        this.eventListenerFactory = builder.getEventListenerFactory$okhttp();
        this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure$okhttp();
        this.authenticator = builder.getAuthenticator$okhttp();
        this.followRedirects = builder.getFollowRedirects$okhttp();
        this.followSslRedirects = builder.getFollowSslRedirects$okhttp();
        this.cookieJar = builder.getCookieJar$okhttp();
        this.cache = builder.getCache$okhttp();
        this.dns = builder.getDns$okhttp();
        this.proxy = builder.getProxy$okhttp();
        if (builder.getProxy$okhttp() != null) {
            nullProxySelector = NullProxySelector.INSTANCE;
        } else {
            nullProxySelector = builder.getProxySelector$okhttp();
            nullProxySelector = nullProxySelector == null ? ProxySelector.getDefault() : nullProxySelector;
            if (nullProxySelector == null) {
                nullProxySelector = NullProxySelector.INSTANCE;
            }
        }
        this.proxySelector = nullProxySelector;
        this.proxyAuthenticator = builder.getProxyAuthenticator$okhttp();
        this.socketFactory = builder.getSocketFactory$okhttp();
        this.connectionSpecs = builder.getConnectionSpecs$okhttp();
        this.protocols = builder.getProtocols$okhttp();
        this.hostnameVerifier = builder.getHostnameVerifier$okhttp();
        this.callTimeoutMillis = builder.getCallTimeout$okhttp();
        this.connectTimeoutMillis = builder.getConnectTimeout$okhttp();
        this.readTimeoutMillis = builder.getReadTimeout$okhttp();
        this.writeTimeoutMillis = builder.getWriteTimeout$okhttp();
        this.pingIntervalMillis = builder.getPingInterval$okhttp();
        this.minWebSocketMessageToCompress = builder.getMinWebSocketMessageToCompress$okhttp();
        RouteDatabase routeDatabase$okhttp = builder.getRouteDatabase$okhttp();
        this.routeDatabase = routeDatabase$okhttp == null ? new RouteDatabase() : routeDatabase$okhttp;
        Iterable $this$none$iv = this.connectionSpecs;
        if (!($this$none$iv instanceof Collection) || !((Collection) $this$none$iv).isEmpty()) {
            Iterator<T> it = $this$none$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((ConnectionSpec) it.next()).isTls()) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
        } else {
            z = true;
        }
        if (z) {
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            this.certificatePinner = CertificatePinner.DEFAULT;
        } else if (builder.getSslSocketFactoryOrNull$okhttp() != null) {
            this.sslSocketFactoryOrNull = builder.getSslSocketFactoryOrNull$okhttp();
            CertificateChainCleaner certificateChainCleaner$okhttp = builder.getCertificateChainCleaner$okhttp();
            Intrinsics.checkNotNull(certificateChainCleaner$okhttp);
            this.certificateChainCleaner = certificateChainCleaner$okhttp;
            X509TrustManager x509TrustManagerOrNull$okhttp = builder.getX509TrustManagerOrNull$okhttp();
            Intrinsics.checkNotNull(x509TrustManagerOrNull$okhttp);
            this.x509TrustManager = x509TrustManagerOrNull$okhttp;
            CertificatePinner certificatePinner$okhttp = builder.getCertificatePinner$okhttp();
            CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
            Intrinsics.checkNotNull(certificateChainCleaner);
            this.certificatePinner = certificatePinner$okhttp.withCertificateChainCleaner$okhttp(certificateChainCleaner);
        } else {
            this.x509TrustManager = Platform.Companion.get().platformTrustManager();
            Platform platform = Platform.Companion.get();
            X509TrustManager x509TrustManager = this.x509TrustManager;
            Intrinsics.checkNotNull(x509TrustManager);
            this.sslSocketFactoryOrNull = platform.newSslSocketFactory(x509TrustManager);
            CertificateChainCleaner.Companion companion = CertificateChainCleaner.Companion;
            X509TrustManager x509TrustManager2 = this.x509TrustManager;
            Intrinsics.checkNotNull(x509TrustManager2);
            this.certificateChainCleaner = companion.get(x509TrustManager2);
            CertificatePinner certificatePinner$okhttp2 = builder.getCertificatePinner$okhttp();
            CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
            Intrinsics.checkNotNull(certificateChainCleaner2);
            this.certificatePinner = certificatePinner$okhttp2.withCertificateChainCleaner$okhttp(certificateChainCleaner2);
        }
        verifyClientState();
    }

    @Override // java.lang.Object
    @NotNull
    public Object clone() {
        return clone();
    }

    @JvmName(name = "dispatcher")
    @NotNull
    public final Dispatcher dispatcher() {
        return this.dispatcher;
    }

    @JvmName(name = "connectionPool")
    @NotNull
    public final ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    @JvmName(name = "interceptors")
    @NotNull
    public final List<Interceptor> interceptors() {
        return this.interceptors;
    }

    @JvmName(name = "networkInterceptors")
    @NotNull
    public final List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    @JvmName(name = "eventListenerFactory")
    @NotNull
    public final EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @JvmName(name = "retryOnConnectionFailure")
    public final boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @JvmName(name = "authenticator")
    @NotNull
    public final Authenticator authenticator() {
        return this.authenticator;
    }

    @JvmName(name = "followRedirects")
    public final boolean followRedirects() {
        return this.followRedirects;
    }

    @JvmName(name = "followSslRedirects")
    public final boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    @JvmName(name = "cookieJar")
    @NotNull
    public final CookieJar cookieJar() {
        return this.cookieJar;
    }

    @JvmName(name = "cache")
    @Nullable
    public final Cache cache() {
        return this.cache;
    }

    @JvmName(name = "dns")
    @NotNull
    public final Dns dns() {
        return this.dns;
    }

    @JvmName(name = "proxy")
    @Nullable
    public final Proxy proxy() {
        return this.proxy;
    }

    @JvmName(name = "proxySelector")
    @NotNull
    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    @JvmName(name = "proxyAuthenticator")
    @NotNull
    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @JvmName(name = "socketFactory")
    @NotNull
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @JvmName(name = "sslSocketFactory")
    @NotNull
    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    @JvmName(name = "x509TrustManager")
    @Nullable
    public final X509TrustManager x509TrustManager() {
        return this.x509TrustManager;
    }

    @JvmName(name = "connectionSpecs")
    @NotNull
    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    @JvmName(name = "protocols")
    @NotNull
    public final List<Protocol> protocols() {
        return this.protocols;
    }

    @JvmName(name = "hostnameVerifier")
    @NotNull
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @JvmName(name = "certificatePinner")
    @NotNull
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @JvmName(name = "certificateChainCleaner")
    @Nullable
    public final CertificateChainCleaner certificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    @JvmName(name = "callTimeoutMillis")
    public final int callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @JvmName(name = "connectTimeoutMillis")
    public final int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @JvmName(name = "readTimeoutMillis")
    public final int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @JvmName(name = "writeTimeoutMillis")
    public final int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @JvmName(name = "pingIntervalMillis")
    public final int pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @JvmName(name = "minWebSocketMessageToCompress")
    public final long minWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    @NotNull
    public final RouteDatabase getRouteDatabase() {
        return this.routeDatabase;
    }

    public OkHttpClient() {
        this(new Builder());
    }

    private final void verifyClientState() {
        boolean z;
        if (!(!this.interceptors.contains(null))) {
            throw new IllegalStateException(Intrinsics.stringPlus("Null interceptor: ", interceptors()).toString());
        }
        if (!(!this.networkInterceptors.contains(null))) {
            throw new IllegalStateException(Intrinsics.stringPlus("Null network interceptor: ", networkInterceptors()).toString());
        }
        Iterable $this$none$iv = this.connectionSpecs;
        if (!($this$none$iv instanceof Collection) || !((Collection) $this$none$iv).isEmpty()) {
            Iterator<T> it = $this$none$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((ConnectionSpec) it.next()).isTls()) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
        } else {
            z = true;
        }
        if (z) {
            if (!(this.sslSocketFactoryOrNull == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(this.certificateChainCleaner == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(this.x509TrustManager == null)) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (!Intrinsics.areEqual(this.certificatePinner, CertificatePinner.DEFAULT)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        } else if (this.sslSocketFactoryOrNull == null) {
            throw new IllegalStateException("sslSocketFactory == null".toString());
        } else if (this.certificateChainCleaner == null) {
            throw new IllegalStateException("certificateChainCleaner == null".toString());
        } else if (this.x509TrustManager == null) {
            throw new IllegalStateException("x509TrustManager == null".toString());
        }
    }

    @Override // okhttp3.Call.Factory
    @NotNull
    public Call newCall(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new RealCall(this, request, false);
    }

    @Override // okhttp3.WebSocket.Factory
    @NotNull
    public WebSocket newWebSocket(@NotNull Request request, @NotNull WebSocketListener listener) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(listener, "listener");
        RealWebSocket webSocket = new RealWebSocket(TaskRunner.INSTANCE, request, listener, new Random(), (long) this.pingIntervalMillis, null, this.minWebSocketMessageToCompress);
        webSocket.connect(this);
        return webSocket;
    }

    @NotNull
    public Builder newBuilder() {
        return new Builder(this);
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "dispatcher", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_dispatcher")
    @NotNull
    /* renamed from: -deprecated_dispatcher  reason: not valid java name */
    public final Dispatcher m9249deprecated_dispatcher() {
        return this.dispatcher;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "connectionPool", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_connectionPool")
    @NotNull
    /* renamed from: -deprecated_connectionPool  reason: not valid java name */
    public final ConnectionPool m9250deprecated_connectionPool() {
        return this.connectionPool;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "interceptors", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_interceptors")
    @NotNull
    /* renamed from: -deprecated_interceptors  reason: not valid java name */
    public final List<Interceptor> m9251deprecated_interceptors() {
        return this.interceptors;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "networkInterceptors", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_networkInterceptors")
    @NotNull
    /* renamed from: -deprecated_networkInterceptors  reason: not valid java name */
    public final List<Interceptor> m9252deprecated_networkInterceptors() {
        return this.networkInterceptors;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "eventListenerFactory", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_eventListenerFactory")
    @NotNull
    /* renamed from: -deprecated_eventListenerFactory  reason: not valid java name */
    public final EventListener.Factory m9253deprecated_eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "retryOnConnectionFailure", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_retryOnConnectionFailure")
    /* renamed from: -deprecated_retryOnConnectionFailure  reason: not valid java name */
    public final boolean m9254deprecated_retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "authenticator", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_authenticator")
    @NotNull
    /* renamed from: -deprecated_authenticator  reason: not valid java name */
    public final Authenticator m9255deprecated_authenticator() {
        return this.authenticator;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "followRedirects", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_followRedirects")
    /* renamed from: -deprecated_followRedirects  reason: not valid java name */
    public final boolean m9256deprecated_followRedirects() {
        return this.followRedirects;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "followSslRedirects", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_followSslRedirects")
    /* renamed from: -deprecated_followSslRedirects  reason: not valid java name */
    public final boolean m9257deprecated_followSslRedirects() {
        return this.followSslRedirects;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "cookieJar", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_cookieJar")
    @NotNull
    /* renamed from: -deprecated_cookieJar  reason: not valid java name */
    public final CookieJar m9258deprecated_cookieJar() {
        return this.cookieJar;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "cache", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_cache")
    @Nullable
    /* renamed from: -deprecated_cache  reason: not valid java name */
    public final Cache m9259deprecated_cache() {
        return this.cache;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "dns", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_dns")
    @NotNull
    /* renamed from: -deprecated_dns  reason: not valid java name */
    public final Dns m9260deprecated_dns() {
        return this.dns;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "proxy", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_proxy")
    @Nullable
    /* renamed from: -deprecated_proxy  reason: not valid java name */
    public final Proxy m9261deprecated_proxy() {
        return this.proxy;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "proxySelector", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_proxySelector")
    @NotNull
    /* renamed from: -deprecated_proxySelector  reason: not valid java name */
    public final ProxySelector m9262deprecated_proxySelector() {
        return this.proxySelector;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "proxyAuthenticator", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_proxyAuthenticator")
    @NotNull
    /* renamed from: -deprecated_proxyAuthenticator  reason: not valid java name */
    public final Authenticator m9263deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "socketFactory", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_socketFactory")
    @NotNull
    /* renamed from: -deprecated_socketFactory  reason: not valid java name */
    public final SocketFactory m9264deprecated_socketFactory() {
        return this.socketFactory;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "sslSocketFactory", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_sslSocketFactory")
    @NotNull
    /* renamed from: -deprecated_sslSocketFactory  reason: not valid java name */
    public final SSLSocketFactory m9265deprecated_sslSocketFactory() {
        return sslSocketFactory();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "connectionSpecs", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_connectionSpecs")
    @NotNull
    /* renamed from: -deprecated_connectionSpecs  reason: not valid java name */
    public final List<ConnectionSpec> m9266deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "protocols", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_protocols")
    @NotNull
    /* renamed from: -deprecated_protocols  reason: not valid java name */
    public final List<Protocol> m9267deprecated_protocols() {
        return this.protocols;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "hostnameVerifier", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_hostnameVerifier")
    @NotNull
    /* renamed from: -deprecated_hostnameVerifier  reason: not valid java name */
    public final HostnameVerifier m9268deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "certificatePinner", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_certificatePinner")
    @NotNull
    /* renamed from: -deprecated_certificatePinner  reason: not valid java name */
    public final CertificatePinner m9269deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "callTimeoutMillis", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_callTimeoutMillis")
    /* renamed from: -deprecated_callTimeoutMillis  reason: not valid java name */
    public final int m9270deprecated_callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "connectTimeoutMillis", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_connectTimeoutMillis")
    /* renamed from: -deprecated_connectTimeoutMillis  reason: not valid java name */
    public final int m9271deprecated_connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "readTimeoutMillis", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_readTimeoutMillis")
    /* renamed from: -deprecated_readTimeoutMillis  reason: not valid java name */
    public final int m9272deprecated_readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "writeTimeoutMillis", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_writeTimeoutMillis")
    /* renamed from: -deprecated_writeTimeoutMillis  reason: not valid java name */
    public final int m9273deprecated_writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "pingIntervalMillis", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_pingIntervalMillis")
    /* renamed from: -deprecated_pingIntervalMillis  reason: not valid java name */
    public final int m9274deprecated_pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    /* compiled from: OkHttpClient.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018��2\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J?\u0010\u0001\u001a\u00020��2*\b\u0004\u0010\u0001\u001a#\u0012\u0017\u0012\u00150¡\u0001¢\u0006\u000f\b¢\u0001\u0012\n\b£\u0001\u0012\u0005\b\b(¤\u0001\u0012\u0005\u0012\u00030¥\u00010 \u0001H\bø\u0001��¢\u0006\u0003\b¦\u0001J\u0010\u0010\u0001\u001a\u00020��2\u0007\u0010§\u0001\u001a\u00020]J?\u0010¨\u0001\u001a\u00020��2*\b\u0004\u0010\u0001\u001a#\u0012\u0017\u0012\u00150¡\u0001¢\u0006\u000f\b¢\u0001\u0012\n\b£\u0001\u0012\u0005\b\b(¤\u0001\u0012\u0005\u0012\u00030¥\u00010 \u0001H\bø\u0001��¢\u0006\u0003\b©\u0001J\u0010\u0010¨\u0001\u001a\u00020��2\u0007\u0010§\u0001\u001a\u00020]J\u000e\u0010\u0006\u001a\u00020��2\u0006\u0010\u0006\u001a\u00020\u0007J\u0007\u0010ª\u0001\u001a\u00020\u0003J\u0010\u0010\f\u001a\u00020��2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u0012\u001a\u00020��2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0007J\u0019\u0010\u0012\u001a\u00020��2\u0007\u0010­\u0001\u001a\u00020`2\b\u0010®\u0001\u001a\u00030¯\u0001J\u000e\u0010\u001e\u001a\u00020��2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0012\u0010$\u001a\u00020��2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0007J\u0019\u0010$\u001a\u00020��2\u0007\u0010­\u0001\u001a\u00020`2\b\u0010®\u0001\u001a\u00030¯\u0001J\u000e\u0010'\u001a\u00020��2\u0006\u0010'\u001a\u00020(J\u0014\u0010-\u001a\u00020��2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.J\u000e\u00104\u001a\u00020��2\u0006\u00104\u001a\u000205J\u000e\u0010:\u001a\u00020��2\u0006\u0010:\u001a\u00020;J\u000e\u0010@\u001a\u00020��2\u0006\u0010@\u001a\u00020AJ\u0011\u0010°\u0001\u001a\u00020��2\b\u0010°\u0001\u001a\u00030±\u0001J\u000e\u0010F\u001a\u00020��2\u0006\u0010F\u001a\u00020GJ\u000e\u0010L\u001a\u00020��2\u0006\u0010L\u001a\u00020MJ\u000f\u0010R\u001a\u00020��2\u0007\u0010²\u0001\u001a\u00020MJ\u000e\u0010U\u001a\u00020��2\u0006\u0010U\u001a\u00020VJ\f\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\J\u000f\u0010_\u001a\u00020��2\u0007\u0010³\u0001\u001a\u00020`J\f\u0010e\u001a\b\u0012\u0004\u0012\u00020]0\\J\u0012\u0010g\u001a\u00020��2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0007J\u0019\u0010g\u001a\u00020��2\u0007\u0010´\u0001\u001a\u00020`2\b\u0010®\u0001\u001a\u00030¯\u0001J\u0014\u0010j\u001a\u00020��2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020k0.J\u0010\u0010n\u001a\u00020��2\b\u0010n\u001a\u0004\u0018\u00010oJ\u000e\u0010t\u001a\u00020��2\u0006\u0010t\u001a\u00020\u0007J\u000e\u0010w\u001a\u00020��2\u0006\u0010w\u001a\u00020xJ\u0012\u0010}\u001a\u00020��2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0007J\u0019\u0010}\u001a\u00020��2\u0007\u0010­\u0001\u001a\u00020`2\b\u0010®\u0001\u001a\u00030¯\u0001J\u0010\u0010\u0001\u001a\u00020��2\u0007\u0010\u0001\u001a\u00020MJ\u0011\u0010\u0001\u001a\u00020��2\b\u0010\u0001\u001a\u00030\u0001J\u0013\u0010µ\u0001\u001a\u00020��2\b\u0010µ\u0001\u001a\u00030\u0001H\u0007J\u001b\u0010µ\u0001\u001a\u00020��2\b\u0010µ\u0001\u001a\u00030\u00012\b\u0010¶\u0001\u001a\u00030\u0001J\u0013\u0010\u0001\u001a\u00020��2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0007J\u001a\u0010\u0001\u001a\u00020��2\u0007\u0010­\u0001\u001a\u00020`2\b\u0010®\u0001\u001a\u00030¯\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n��\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n��\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0013X\u000e¢\u0006\u000e\n��\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n��\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u000e¢\u0006\u000e\n��\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u000e¢\u0006\u000e\n��\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u000e¢\u0006\u000e\n��\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020AX\u000e¢\u0006\u000e\n��\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020GX\u000e¢\u0006\u000e\n��\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020MX\u000e¢\u0006\u000e\n��\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020MX\u000e¢\u0006\u000e\n��\u001a\u0004\bS\u0010O\"\u0004\bT\u0010QR\u001a\u0010U\u001a\u00020VX\u000e¢\u0006\u000e\n��\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\X\u0004¢\u0006\b\n��\u001a\u0004\b^\u00101R\u001a\u0010_\u001a\u00020`X\u000e¢\u0006\u000e\n��\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020]0\\X\u0004¢\u0006\b\n��\u001a\u0004\bf\u00101R\u001a\u0010g\u001a\u00020\u0013X\u000e¢\u0006\u000e\n��\u001a\u0004\bh\u0010\u0015\"\u0004\bi\u0010\u0017R \u0010j\u001a\b\u0012\u0004\u0012\u00020k0.X\u000e¢\u0006\u000e\n��\u001a\u0004\bl\u00101\"\u0004\bm\u00103R\u001c\u0010n\u001a\u0004\u0018\u00010oX\u000e¢\u0006\u000e\n��\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n��\u001a\u0004\bu\u0010\t\"\u0004\bv\u0010\u000bR\u001c\u0010w\u001a\u0004\u0018\u00010xX\u000e¢\u0006\u000e\n��\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u001a\u0010}\u001a\u00020\u0013X\u000e¢\u0006\u000e\n��\u001a\u0004\b~\u0010\u0015\"\u0004\b\u0010\u0017R\u001d\u0010\u0001\u001a\u00020MX\u000e¢\u0006\u0010\n��\u001a\u0005\b\u0001\u0010O\"\u0005\b\u0001\u0010QR\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n��\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n��\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n��\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\u0013X\u000e¢\u0006\u0010\n��\u001a\u0005\b\u0001\u0010\u0015\"\u0005\b\u0001\u0010\u0017R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n��\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006·\u0001"}, m373d2 = {"Lokhttp3/OkHttpClient$Builder;", "", "okHttpClient", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "()V", "authenticator", "Lokhttp3/Authenticator;", "getAuthenticator$okhttp", "()Lokhttp3/Authenticator;", "setAuthenticator$okhttp", "(Lokhttp3/Authenticator;)V", "cache", "Lokhttp3/Cache;", "getCache$okhttp", "()Lokhttp3/Cache;", "setCache$okhttp", "(Lokhttp3/Cache;)V", "callTimeout", "", "getCallTimeout$okhttp", "()I", "setCallTimeout$okhttp", "(I)V", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "setCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)V", "certificatePinner", "Lokhttp3/CertificatePinner;", "getCertificatePinner$okhttp", "()Lokhttp3/CertificatePinner;", "setCertificatePinner$okhttp", "(Lokhttp3/CertificatePinner;)V", "connectTimeout", "getConnectTimeout$okhttp", "setConnectTimeout$okhttp", "connectionPool", "Lokhttp3/ConnectionPool;", "getConnectionPool$okhttp", "()Lokhttp3/ConnectionPool;", "setConnectionPool$okhttp", "(Lokhttp3/ConnectionPool;)V", "connectionSpecs", "", "Lokhttp3/ConnectionSpec;", "getConnectionSpecs$okhttp", "()Ljava/util/List;", "setConnectionSpecs$okhttp", "(Ljava/util/List;)V", "cookieJar", "Lokhttp3/CookieJar;", "getCookieJar$okhttp", "()Lokhttp3/CookieJar;", "setCookieJar$okhttp", "(Lokhttp3/CookieJar;)V", "dispatcher", "Lokhttp3/Dispatcher;", "getDispatcher$okhttp", "()Lokhttp3/Dispatcher;", "setDispatcher$okhttp", "(Lokhttp3/Dispatcher;)V", "dns", "Lokhttp3/Dns;", "getDns$okhttp", "()Lokhttp3/Dns;", "setDns$okhttp", "(Lokhttp3/Dns;)V", "eventListenerFactory", "Lokhttp3/EventListener$Factory;", "getEventListenerFactory$okhttp", "()Lokhttp3/EventListener$Factory;", "setEventListenerFactory$okhttp", "(Lokhttp3/EventListener$Factory;)V", "followRedirects", "", "getFollowRedirects$okhttp", "()Z", "setFollowRedirects$okhttp", "(Z)V", "followSslRedirects", "getFollowSslRedirects$okhttp", "setFollowSslRedirects$okhttp", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "getHostnameVerifier$okhttp", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier$okhttp", "(Ljavax/net/ssl/HostnameVerifier;)V", "interceptors", "", "Lokhttp3/Interceptor;", "getInterceptors$okhttp", "minWebSocketMessageToCompress", "", "getMinWebSocketMessageToCompress$okhttp", "()J", "setMinWebSocketMessageToCompress$okhttp", "(J)V", "networkInterceptors", "getNetworkInterceptors$okhttp", "pingInterval", "getPingInterval$okhttp", "setPingInterval$okhttp", "protocols", "Lokhttp3/Protocol;", "getProtocols$okhttp", "setProtocols$okhttp", "proxy", "Ljava/net/Proxy;", "getProxy$okhttp", "()Ljava/net/Proxy;", "setProxy$okhttp", "(Ljava/net/Proxy;)V", "proxyAuthenticator", "getProxyAuthenticator$okhttp", "setProxyAuthenticator$okhttp", "proxySelector", "Ljava/net/ProxySelector;", "getProxySelector$okhttp", "()Ljava/net/ProxySelector;", "setProxySelector$okhttp", "(Ljava/net/ProxySelector;)V", "readTimeout", "getReadTimeout$okhttp", "setReadTimeout$okhttp", "retryOnConnectionFailure", "getRetryOnConnectionFailure$okhttp", "setRetryOnConnectionFailure$okhttp", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase$okhttp", "()Lokhttp3/internal/connection/RouteDatabase;", "setRouteDatabase$okhttp", "(Lokhttp3/internal/connection/RouteDatabase;)V", "socketFactory", "Ljavax/net/SocketFactory;", "getSocketFactory$okhttp", "()Ljavax/net/SocketFactory;", "setSocketFactory$okhttp", "(Ljavax/net/SocketFactory;)V", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "getSslSocketFactoryOrNull$okhttp", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactoryOrNull$okhttp", "(Ljavax/net/ssl/SSLSocketFactory;)V", "writeTimeout", "getWriteTimeout$okhttp", "setWriteTimeout$okhttp", "x509TrustManagerOrNull", "Ljavax/net/ssl/X509TrustManager;", "getX509TrustManagerOrNull$okhttp", "()Ljavax/net/ssl/X509TrustManager;", "setX509TrustManagerOrNull$okhttp", "(Ljavax/net/ssl/X509TrustManager;)V", "addInterceptor", "block", "Lkotlin/Function1;", "Lokhttp3/Interceptor$Chain;", "Lkotlin/ParameterName;", "name", "chain", "Lokhttp3/Response;", "-addInterceptor", "interceptor", "addNetworkInterceptor", "-addNetworkInterceptor", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "duration", "Ljava/time/Duration;", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "eventListener", "Lokhttp3/EventListener;", "followProtocolRedirects", "bytes", "interval", "sslSocketFactory", "trustManager", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/OkHttpClient$Builder.class */
    public static final class Builder {
        @NotNull
        private Dispatcher dispatcher;
        @NotNull
        private ConnectionPool connectionPool;
        @NotNull
        private final List<Interceptor> interceptors;
        @NotNull
        private final List<Interceptor> networkInterceptors;
        @NotNull
        private EventListener.Factory eventListenerFactory;
        private boolean retryOnConnectionFailure;
        @NotNull
        private Authenticator authenticator;
        private boolean followRedirects;
        private boolean followSslRedirects;
        @NotNull
        private CookieJar cookieJar;
        @Nullable
        private Cache cache;
        @NotNull
        private Dns dns;
        @Nullable
        private Proxy proxy;
        @Nullable
        private ProxySelector proxySelector;
        @NotNull
        private Authenticator proxyAuthenticator;
        @NotNull
        private SocketFactory socketFactory;
        @Nullable
        private SSLSocketFactory sslSocketFactoryOrNull;
        @Nullable
        private X509TrustManager x509TrustManagerOrNull;
        @NotNull
        private List<ConnectionSpec> connectionSpecs;
        @NotNull
        private List<? extends Protocol> protocols;
        @NotNull
        private HostnameVerifier hostnameVerifier;
        @NotNull
        private CertificatePinner certificatePinner;
        @Nullable
        private CertificateChainCleaner certificateChainCleaner;
        private int callTimeout;
        private int connectTimeout;
        private int readTimeout;
        private int writeTimeout;
        private int pingInterval;
        private long minWebSocketMessageToCompress;
        @Nullable
        private RouteDatabase routeDatabase;

        public Builder() {
            this.dispatcher = new Dispatcher();
            this.connectionPool = new ConnectionPool();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = Util.asFactory(EventListener.NONE);
            this.retryOnConnectionFailure = true;
            this.authenticator = Authenticator.NONE;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = Authenticator.NONE;
            SocketFactory socketFactory = SocketFactory.getDefault();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getDefault()");
            this.socketFactory = socketFactory;
            this.connectionSpecs = OkHttpClient.Companion.getDEFAULT_CONNECTION_SPECS$okhttp();
            this.protocols = OkHttpClient.Companion.getDEFAULT_PROTOCOLS$okhttp();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.minWebSocketMessageToCompress = 1024;
        }

        @NotNull
        public final Dispatcher getDispatcher$okhttp() {
            return this.dispatcher;
        }

        public final void setDispatcher$okhttp(@NotNull Dispatcher dispatcher) {
            Intrinsics.checkNotNullParameter(dispatcher, "<set-?>");
            this.dispatcher = dispatcher;
        }

        @NotNull
        public final ConnectionPool getConnectionPool$okhttp() {
            return this.connectionPool;
        }

        public final void setConnectionPool$okhttp(@NotNull ConnectionPool connectionPool) {
            Intrinsics.checkNotNullParameter(connectionPool, "<set-?>");
            this.connectionPool = connectionPool;
        }

        @NotNull
        public final List<Interceptor> getInterceptors$okhttp() {
            return this.interceptors;
        }

        @NotNull
        public final List<Interceptor> getNetworkInterceptors$okhttp() {
            return this.networkInterceptors;
        }

        @NotNull
        public final EventListener.Factory getEventListenerFactory$okhttp() {
            return this.eventListenerFactory;
        }

        public final void setEventListenerFactory$okhttp(@NotNull EventListener.Factory factory) {
            Intrinsics.checkNotNullParameter(factory, "<set-?>");
            this.eventListenerFactory = factory;
        }

        public final boolean getRetryOnConnectionFailure$okhttp() {
            return this.retryOnConnectionFailure;
        }

        public final void setRetryOnConnectionFailure$okhttp(boolean z) {
            this.retryOnConnectionFailure = z;
        }

        @NotNull
        public final Authenticator getAuthenticator$okhttp() {
            return this.authenticator;
        }

        public final void setAuthenticator$okhttp(@NotNull Authenticator authenticator) {
            Intrinsics.checkNotNullParameter(authenticator, "<set-?>");
            this.authenticator = authenticator;
        }

        public final boolean getFollowRedirects$okhttp() {
            return this.followRedirects;
        }

        public final void setFollowRedirects$okhttp(boolean z) {
            this.followRedirects = z;
        }

        public final boolean getFollowSslRedirects$okhttp() {
            return this.followSslRedirects;
        }

        public final void setFollowSslRedirects$okhttp(boolean z) {
            this.followSslRedirects = z;
        }

        @NotNull
        public final CookieJar getCookieJar$okhttp() {
            return this.cookieJar;
        }

        public final void setCookieJar$okhttp(@NotNull CookieJar cookieJar) {
            Intrinsics.checkNotNullParameter(cookieJar, "<set-?>");
            this.cookieJar = cookieJar;
        }

        @Nullable
        public final Cache getCache$okhttp() {
            return this.cache;
        }

        public final void setCache$okhttp(@Nullable Cache cache) {
            this.cache = cache;
        }

        @NotNull
        public final Dns getDns$okhttp() {
            return this.dns;
        }

        public final void setDns$okhttp(@NotNull Dns dns) {
            Intrinsics.checkNotNullParameter(dns, "<set-?>");
            this.dns = dns;
        }

        @Nullable
        public final Proxy getProxy$okhttp() {
            return this.proxy;
        }

        public final void setProxy$okhttp(@Nullable Proxy proxy) {
            this.proxy = proxy;
        }

        @Nullable
        public final ProxySelector getProxySelector$okhttp() {
            return this.proxySelector;
        }

        public final void setProxySelector$okhttp(@Nullable ProxySelector proxySelector) {
            this.proxySelector = proxySelector;
        }

        @NotNull
        public final Authenticator getProxyAuthenticator$okhttp() {
            return this.proxyAuthenticator;
        }

        public final void setProxyAuthenticator$okhttp(@NotNull Authenticator authenticator) {
            Intrinsics.checkNotNullParameter(authenticator, "<set-?>");
            this.proxyAuthenticator = authenticator;
        }

        @NotNull
        public final SocketFactory getSocketFactory$okhttp() {
            return this.socketFactory;
        }

        public final void setSocketFactory$okhttp(@NotNull SocketFactory socketFactory) {
            Intrinsics.checkNotNullParameter(socketFactory, "<set-?>");
            this.socketFactory = socketFactory;
        }

        @Nullable
        public final SSLSocketFactory getSslSocketFactoryOrNull$okhttp() {
            return this.sslSocketFactoryOrNull;
        }

        public final void setSslSocketFactoryOrNull$okhttp(@Nullable SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactoryOrNull = sSLSocketFactory;
        }

        @Nullable
        public final X509TrustManager getX509TrustManagerOrNull$okhttp() {
            return this.x509TrustManagerOrNull;
        }

        public final void setX509TrustManagerOrNull$okhttp(@Nullable X509TrustManager x509TrustManager) {
            this.x509TrustManagerOrNull = x509TrustManager;
        }

        @NotNull
        public final List<ConnectionSpec> getConnectionSpecs$okhttp() {
            return this.connectionSpecs;
        }

        public final void setConnectionSpecs$okhttp(@NotNull List<ConnectionSpec> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.connectionSpecs = list;
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.List<? extends okhttp3.Protocol>, java.util.List<okhttp3.Protocol> */
        @NotNull
        public final List<Protocol> getProtocols$okhttp() {
            return this.protocols;
        }

        public final void setProtocols$okhttp(@NotNull List<? extends Protocol> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.protocols = list;
        }

        @NotNull
        public final HostnameVerifier getHostnameVerifier$okhttp() {
            return this.hostnameVerifier;
        }

        public final void setHostnameVerifier$okhttp(@NotNull HostnameVerifier hostnameVerifier) {
            Intrinsics.checkNotNullParameter(hostnameVerifier, "<set-?>");
            this.hostnameVerifier = hostnameVerifier;
        }

        @NotNull
        public final CertificatePinner getCertificatePinner$okhttp() {
            return this.certificatePinner;
        }

        public final void setCertificatePinner$okhttp(@NotNull CertificatePinner certificatePinner) {
            Intrinsics.checkNotNullParameter(certificatePinner, "<set-?>");
            this.certificatePinner = certificatePinner;
        }

        @Nullable
        public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
            return this.certificateChainCleaner;
        }

        public final void setCertificateChainCleaner$okhttp(@Nullable CertificateChainCleaner certificateChainCleaner) {
            this.certificateChainCleaner = certificateChainCleaner;
        }

        public final int getCallTimeout$okhttp() {
            return this.callTimeout;
        }

        public final void setCallTimeout$okhttp(int i) {
            this.callTimeout = i;
        }

        public final int getConnectTimeout$okhttp() {
            return this.connectTimeout;
        }

        public final void setConnectTimeout$okhttp(int i) {
            this.connectTimeout = i;
        }

        public final int getReadTimeout$okhttp() {
            return this.readTimeout;
        }

        public final void setReadTimeout$okhttp(int i) {
            this.readTimeout = i;
        }

        public final int getWriteTimeout$okhttp() {
            return this.writeTimeout;
        }

        public final void setWriteTimeout$okhttp(int i) {
            this.writeTimeout = i;
        }

        public final int getPingInterval$okhttp() {
            return this.pingInterval;
        }

        public final void setPingInterval$okhttp(int i) {
            this.pingInterval = i;
        }

        public final long getMinWebSocketMessageToCompress$okhttp() {
            return this.minWebSocketMessageToCompress;
        }

        public final void setMinWebSocketMessageToCompress$okhttp(long j) {
            this.minWebSocketMessageToCompress = j;
        }

        @Nullable
        public final RouteDatabase getRouteDatabase$okhttp() {
            return this.routeDatabase;
        }

        public final void setRouteDatabase$okhttp(@Nullable RouteDatabase routeDatabase) {
            this.routeDatabase = routeDatabase;
        }

        /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull OkHttpClient okHttpClient) {
            this();
            Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
            this.dispatcher = okHttpClient.dispatcher();
            this.connectionPool = okHttpClient.connectionPool();
            CollectionsKt.addAll(this.interceptors, okHttpClient.interceptors());
            CollectionsKt.addAll(this.networkInterceptors, okHttpClient.networkInterceptors());
            this.eventListenerFactory = okHttpClient.eventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure();
            this.authenticator = okHttpClient.authenticator();
            this.followRedirects = okHttpClient.followRedirects();
            this.followSslRedirects = okHttpClient.followSslRedirects();
            this.cookieJar = okHttpClient.cookieJar();
            this.cache = okHttpClient.cache();
            this.dns = okHttpClient.dns();
            this.proxy = okHttpClient.proxy();
            this.proxySelector = okHttpClient.proxySelector();
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator();
            this.socketFactory = okHttpClient.socketFactory();
            this.sslSocketFactoryOrNull = okHttpClient.sslSocketFactoryOrNull;
            this.x509TrustManagerOrNull = okHttpClient.x509TrustManager();
            this.connectionSpecs = okHttpClient.connectionSpecs();
            this.protocols = okHttpClient.protocols();
            this.hostnameVerifier = okHttpClient.hostnameVerifier();
            this.certificatePinner = okHttpClient.certificatePinner();
            this.certificateChainCleaner = okHttpClient.certificateChainCleaner();
            this.callTimeout = okHttpClient.callTimeoutMillis();
            this.connectTimeout = okHttpClient.connectTimeoutMillis();
            this.readTimeout = okHttpClient.readTimeoutMillis();
            this.writeTimeout = okHttpClient.writeTimeoutMillis();
            this.pingInterval = okHttpClient.pingIntervalMillis();
            this.minWebSocketMessageToCompress = okHttpClient.minWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient.getRouteDatabase();
        }

        @NotNull
        public final Builder dispatcher(@NotNull Dispatcher dispatcher) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            setDispatcher$okhttp(dispatcher);
            return this;
        }

        @NotNull
        public final Builder connectionPool(@NotNull ConnectionPool connectionPool) {
            Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
            setConnectionPool$okhttp(connectionPool);
            return this;
        }

        @NotNull
        public final List<Interceptor> interceptors() {
            return this.interceptors;
        }

        @NotNull
        public final Builder addInterceptor(@NotNull Interceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            getInterceptors$okhttp().add(interceptor);
            return this;
        }

        @JvmName(name = "-addInterceptor")
        @NotNull
        /* renamed from: -addInterceptor  reason: not valid java name */
        public final Builder m9276addInterceptor(@NotNull Function1<? super Interceptor.Chain, Response> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            return addInterceptor(new OkHttpClient$Builder$addInterceptor$2(function1));
        }

        @NotNull
        public final List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        @NotNull
        public final Builder addNetworkInterceptor(@NotNull Interceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            getNetworkInterceptors$okhttp().add(interceptor);
            return this;
        }

        @JvmName(name = "-addNetworkInterceptor")
        @NotNull
        /* renamed from: -addNetworkInterceptor  reason: not valid java name */
        public final Builder m9277addNetworkInterceptor(@NotNull Function1<? super Interceptor.Chain, Response> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            return addNetworkInterceptor(new OkHttpClient$Builder$addNetworkInterceptor$2(function1));
        }

        @NotNull
        public final Builder eventListener(@NotNull EventListener eventListener) {
            Intrinsics.checkNotNullParameter(eventListener, "eventListener");
            setEventListenerFactory$okhttp(Util.asFactory(eventListener));
            return this;
        }

        @NotNull
        public final Builder eventListenerFactory(@NotNull EventListener.Factory eventListenerFactory) {
            Intrinsics.checkNotNullParameter(eventListenerFactory, "eventListenerFactory");
            setEventListenerFactory$okhttp(eventListenerFactory);
            return this;
        }

        @NotNull
        public final Builder retryOnConnectionFailure(boolean retryOnConnectionFailure) {
            setRetryOnConnectionFailure$okhttp(retryOnConnectionFailure);
            return this;
        }

        @NotNull
        public final Builder authenticator(@NotNull Authenticator authenticator) {
            Intrinsics.checkNotNullParameter(authenticator, "authenticator");
            setAuthenticator$okhttp(authenticator);
            return this;
        }

        @NotNull
        public final Builder followRedirects(boolean followRedirects) {
            setFollowRedirects$okhttp(followRedirects);
            return this;
        }

        @NotNull
        public final Builder followSslRedirects(boolean followProtocolRedirects) {
            setFollowSslRedirects$okhttp(followProtocolRedirects);
            return this;
        }

        @NotNull
        public final Builder cookieJar(@NotNull CookieJar cookieJar) {
            Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
            setCookieJar$okhttp(cookieJar);
            return this;
        }

        @NotNull
        public final Builder cache(@Nullable Cache cache) {
            setCache$okhttp(cache);
            return this;
        }

        @NotNull
        public final Builder dns(@NotNull Dns dns) {
            Intrinsics.checkNotNullParameter(dns, "dns");
            Builder $this$dns_u24lambda_u2d12 = this;
            if (!Intrinsics.areEqual(dns, $this$dns_u24lambda_u2d12.getDns$okhttp())) {
                $this$dns_u24lambda_u2d12.setRouteDatabase$okhttp(null);
            }
            $this$dns_u24lambda_u2d12.setDns$okhttp(dns);
            return this;
        }

        @NotNull
        public final Builder proxy(@Nullable Proxy proxy) {
            Builder $this$proxy_u24lambda_u2d13 = this;
            if (!Intrinsics.areEqual(proxy, $this$proxy_u24lambda_u2d13.getProxy$okhttp())) {
                $this$proxy_u24lambda_u2d13.setRouteDatabase$okhttp(null);
            }
            $this$proxy_u24lambda_u2d13.setProxy$okhttp(proxy);
            return this;
        }

        @NotNull
        public final Builder proxySelector(@NotNull ProxySelector proxySelector) {
            Intrinsics.checkNotNullParameter(proxySelector, "proxySelector");
            Builder $this$proxySelector_u24lambda_u2d14 = this;
            if (!Intrinsics.areEqual(proxySelector, $this$proxySelector_u24lambda_u2d14.getProxySelector$okhttp())) {
                $this$proxySelector_u24lambda_u2d14.setRouteDatabase$okhttp(null);
            }
            $this$proxySelector_u24lambda_u2d14.setProxySelector$okhttp(proxySelector);
            return this;
        }

        @NotNull
        public final Builder proxyAuthenticator(@NotNull Authenticator proxyAuthenticator) {
            Intrinsics.checkNotNullParameter(proxyAuthenticator, "proxyAuthenticator");
            Builder $this$proxyAuthenticator_u24lambda_u2d15 = this;
            if (!Intrinsics.areEqual(proxyAuthenticator, $this$proxyAuthenticator_u24lambda_u2d15.getProxyAuthenticator$okhttp())) {
                $this$proxyAuthenticator_u24lambda_u2d15.setRouteDatabase$okhttp(null);
            }
            $this$proxyAuthenticator_u24lambda_u2d15.setProxyAuthenticator$okhttp(proxyAuthenticator);
            return this;
        }

        @NotNull
        public final Builder socketFactory(@NotNull SocketFactory socketFactory) {
            Intrinsics.checkNotNullParameter(socketFactory, "socketFactory");
            Builder $this$socketFactory_u24lambda_u2d17 = this;
            if (!(!(socketFactory instanceof SSLSocketFactory))) {
                throw new IllegalArgumentException("socketFactory instanceof SSLSocketFactory".toString());
            }
            if (!Intrinsics.areEqual(socketFactory, $this$socketFactory_u24lambda_u2d17.getSocketFactory$okhttp())) {
                $this$socketFactory_u24lambda_u2d17.setRouteDatabase$okhttp(null);
            }
            $this$socketFactory_u24lambda_u2d17.setSocketFactory$okhttp(socketFactory);
            return this;
        }

        @Deprecated(message = "Use the sslSocketFactory overload that accepts a X509TrustManager.", level = DeprecationLevel.ERROR)
        @NotNull
        public final Builder sslSocketFactory(@NotNull SSLSocketFactory sslSocketFactory) {
            Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
            Builder $this$sslSocketFactory_u24lambda_u2d18 = this;
            if (!Intrinsics.areEqual(sslSocketFactory, $this$sslSocketFactory_u24lambda_u2d18.getSslSocketFactoryOrNull$okhttp())) {
                $this$sslSocketFactory_u24lambda_u2d18.setRouteDatabase$okhttp(null);
            }
            $this$sslSocketFactory_u24lambda_u2d18.setSslSocketFactoryOrNull$okhttp(sslSocketFactory);
            X509TrustManager trustManager = Platform.Companion.get().trustManager(sslSocketFactory);
            if (trustManager == null) {
                throw new IllegalStateException("Unable to extract the trust manager on " + Platform.Companion.get() + ", sslSocketFactory is " + sslSocketFactory.getClass());
            }
            $this$sslSocketFactory_u24lambda_u2d18.setX509TrustManagerOrNull$okhttp(trustManager);
            Platform platform = Platform.Companion.get();
            X509TrustManager x509TrustManagerOrNull$okhttp = $this$sslSocketFactory_u24lambda_u2d18.getX509TrustManagerOrNull$okhttp();
            Intrinsics.checkNotNull(x509TrustManagerOrNull$okhttp);
            $this$sslSocketFactory_u24lambda_u2d18.setCertificateChainCleaner$okhttp(platform.buildCertificateChainCleaner(x509TrustManagerOrNull$okhttp));
            return this;
        }

        @NotNull
        public final Builder sslSocketFactory(@NotNull SSLSocketFactory sslSocketFactory, @NotNull X509TrustManager trustManager) {
            Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            Builder $this$sslSocketFactory_u24lambda_u2d19 = this;
            if (!Intrinsics.areEqual(sslSocketFactory, $this$sslSocketFactory_u24lambda_u2d19.getSslSocketFactoryOrNull$okhttp()) || !Intrinsics.areEqual(trustManager, $this$sslSocketFactory_u24lambda_u2d19.getX509TrustManagerOrNull$okhttp())) {
                $this$sslSocketFactory_u24lambda_u2d19.setRouteDatabase$okhttp(null);
            }
            $this$sslSocketFactory_u24lambda_u2d19.setSslSocketFactoryOrNull$okhttp(sslSocketFactory);
            $this$sslSocketFactory_u24lambda_u2d19.setCertificateChainCleaner$okhttp(CertificateChainCleaner.Companion.get(trustManager));
            $this$sslSocketFactory_u24lambda_u2d19.setX509TrustManagerOrNull$okhttp(trustManager);
            return this;
        }

        @NotNull
        public final Builder connectionSpecs(@NotNull List<ConnectionSpec> list) {
            Intrinsics.checkNotNullParameter(list, "connectionSpecs");
            Builder $this$connectionSpecs_u24lambda_u2d20 = this;
            if (!Intrinsics.areEqual(list, $this$connectionSpecs_u24lambda_u2d20.getConnectionSpecs$okhttp())) {
                $this$connectionSpecs_u24lambda_u2d20.setRouteDatabase$okhttp(null);
            }
            $this$connectionSpecs_u24lambda_u2d20.setConnectionSpecs$okhttp(Util.toImmutableList(list));
            return this;
        }

        @NotNull
        public final Builder protocols(@NotNull List<? extends Protocol> list) {
            Intrinsics.checkNotNullParameter(list, "protocols");
            Builder $this$protocols_u24lambda_u2d25 = this;
            List protocolsCopy = CollectionsKt.toMutableList((Collection) list);
            if (!(protocolsCopy.contains(Protocol.H2_PRIOR_KNOWLEDGE) || protocolsCopy.contains(Protocol.HTTP_1_1))) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("protocols must contain h2_prior_knowledge or http/1.1: ", protocolsCopy).toString());
            }
            if (!(!protocolsCopy.contains(Protocol.H2_PRIOR_KNOWLEDGE) || protocolsCopy.size() <= 1)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("protocols containing h2_prior_knowledge cannot use other protocols: ", protocolsCopy).toString());
            }
            if (!(!protocolsCopy.contains(Protocol.HTTP_1_0))) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("protocols must not contain http/1.0: ", protocolsCopy).toString());
            }
            if (!(!protocolsCopy.contains(null))) {
                throw new IllegalArgumentException("protocols must not contain null".toString());
            }
            protocolsCopy.remove(Protocol.SPDY_3);
            if (!Intrinsics.areEqual(protocolsCopy, $this$protocols_u24lambda_u2d25.getProtocols$okhttp())) {
                $this$protocols_u24lambda_u2d25.setRouteDatabase$okhttp(null);
            }
            List<? extends Protocol> unmodifiableList = Collections.unmodifiableList(protocolsCopy);
            Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(protocolsCopy)");
            $this$protocols_u24lambda_u2d25.setProtocols$okhttp(unmodifiableList);
            return this;
        }

        @NotNull
        public final Builder hostnameVerifier(@NotNull HostnameVerifier hostnameVerifier) {
            Intrinsics.checkNotNullParameter(hostnameVerifier, "hostnameVerifier");
            Builder $this$hostnameVerifier_u24lambda_u2d26 = this;
            if (!Intrinsics.areEqual(hostnameVerifier, $this$hostnameVerifier_u24lambda_u2d26.getHostnameVerifier$okhttp())) {
                $this$hostnameVerifier_u24lambda_u2d26.setRouteDatabase$okhttp(null);
            }
            $this$hostnameVerifier_u24lambda_u2d26.setHostnameVerifier$okhttp(hostnameVerifier);
            return this;
        }

        @NotNull
        public final Builder certificatePinner(@NotNull CertificatePinner certificatePinner) {
            Intrinsics.checkNotNullParameter(certificatePinner, "certificatePinner");
            Builder $this$certificatePinner_u24lambda_u2d27 = this;
            if (!Intrinsics.areEqual(certificatePinner, $this$certificatePinner_u24lambda_u2d27.getCertificatePinner$okhttp())) {
                $this$certificatePinner_u24lambda_u2d27.setRouteDatabase$okhttp(null);
            }
            $this$certificatePinner_u24lambda_u2d27.setCertificatePinner$okhttp(certificatePinner);
            return this;
        }

        @NotNull
        public final Builder callTimeout(long timeout, @NotNull TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            setCallTimeout$okhttp(Util.checkDuration("timeout", timeout, unit));
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder callTimeout(@NotNull Duration duration) {
            Intrinsics.checkNotNullParameter(duration, "duration");
            callTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        public final Builder connectTimeout(long timeout, @NotNull TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            setConnectTimeout$okhttp(Util.checkDuration("timeout", timeout, unit));
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder connectTimeout(@NotNull Duration duration) {
            Intrinsics.checkNotNullParameter(duration, "duration");
            connectTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        public final Builder readTimeout(long timeout, @NotNull TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            setReadTimeout$okhttp(Util.checkDuration("timeout", timeout, unit));
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder readTimeout(@NotNull Duration duration) {
            Intrinsics.checkNotNullParameter(duration, "duration");
            readTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        public final Builder writeTimeout(long timeout, @NotNull TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            setWriteTimeout$okhttp(Util.checkDuration("timeout", timeout, unit));
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder writeTimeout(@NotNull Duration duration) {
            Intrinsics.checkNotNullParameter(duration, "duration");
            writeTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        public final Builder pingInterval(long interval, @NotNull TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            setPingInterval$okhttp(Util.checkDuration("interval", interval, unit));
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder pingInterval(@NotNull Duration duration) {
            Intrinsics.checkNotNullParameter(duration, "duration");
            pingInterval(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        public final Builder minWebSocketMessageToCompress(long bytes) {
            Builder $this$minWebSocketMessageToCompress_u24lambda_u2d39 = this;
            if (!(bytes >= 0)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("minWebSocketMessageToCompress must be positive: ", Long.valueOf(bytes)).toString());
            }
            $this$minWebSocketMessageToCompress_u24lambda_u2d39.setMinWebSocketMessageToCompress$okhttp(bytes);
            return this;
        }

        @NotNull
        public final OkHttpClient build() {
            return new OkHttpClient(this);
        }
    }

    /* compiled from: OkHttpClient.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0004¢\u0006\b\n��\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, m373d2 = {"Lokhttp3/OkHttpClient$Companion;", "", "()V", "DEFAULT_CONNECTION_SPECS", "", "Lokhttp3/ConnectionSpec;", "getDEFAULT_CONNECTION_SPECS$okhttp", "()Ljava/util/List;", "DEFAULT_PROTOCOLS", "Lokhttp3/Protocol;", "getDEFAULT_PROTOCOLS$okhttp", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/OkHttpClient$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final List<Protocol> getDEFAULT_PROTOCOLS$okhttp() {
            return OkHttpClient.DEFAULT_PROTOCOLS;
        }

        @NotNull
        public final List<ConnectionSpec> getDEFAULT_CONNECTION_SPECS$okhttp() {
            return OkHttpClient.DEFAULT_CONNECTION_SPECS;
        }
    }
}
