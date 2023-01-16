package okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import org.jetbrains.annotations.NotNull;
import org.quartz.jobs.p027ee.ejb.EJBInvokerJob;

/* compiled from: RetryAndFollowUpInterceptor.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018�� \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��¨\u0006\u001f"}, m373d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lokhttp3/Interceptor;", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "buildRedirectRequest", "Lokhttp3/Request;", "userResponse", "Lokhttp3/Response;", EJBInvokerJob.EJB_METHOD_KEY, "", "followUpRequest", "exchange", "Lokhttp3/internal/connection/Exchange;", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "isRecoverable", "", "e", "Ljava/io/IOException;", "requestSendStarted", "recover", "call", "Lokhttp3/internal/connection/RealCall;", "userRequest", "requestIsOneShot", "retryAfter", "", "defaultDelay", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/http/RetryAndFollowUpInterceptor.class */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final OkHttpClient client;
    private static final int MAX_FOLLOW_UPS = 20;

    public RetryAndFollowUpInterceptor(@NotNull OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Response response;
        Exchange exchange;
        Request followUp;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realChain = (RealInterceptorChain) chain;
        Request request = ((RealInterceptorChain) chain).getRequest$okhttp();
        RealCall call = realChain.getCall$okhttp();
        int followUpCount = 0;
        Response priorResponse = null;
        boolean newExchangeFinder = true;
        List recoveredFailures = CollectionsKt.emptyList();
        while (true) {
            call.enterNetworkInterceptorExchange(request, newExchangeFinder);
            try {
                if (call.isCanceled()) {
                    throw new IOException("Canceled");
                }
                try {
                    try {
                        response = realChain.proceed(request);
                        newExchangeFinder = true;
                        if (priorResponse != null) {
                            response = response.newBuilder().priorResponse(priorResponse.newBuilder().body(null).build()).build();
                        }
                        exchange = call.getInterceptorScopedExchange$okhttp();
                        followUp = followUpRequest(response, exchange);
                    } catch (IOException e) {
                        if (!recover(e, call, request, !(e instanceof ConnectionShutdownException))) {
                            throw Util.withSuppressed(e, recoveredFailures);
                        }
                        recoveredFailures = CollectionsKt.plus((Collection<? extends IOException>) recoveredFailures, e);
                        newExchangeFinder = false;
                        call.exitNetworkInterceptorExchange$okhttp(true);
                    }
                } catch (RouteException e2) {
                    if (!recover(e2.getLastConnectException(), call, request, false)) {
                        throw Util.withSuppressed(e2.getFirstConnectException(), recoveredFailures);
                    }
                    recoveredFailures = CollectionsKt.plus((Collection<? extends IOException>) recoveredFailures, e2.getFirstConnectException());
                    newExchangeFinder = false;
                    call.exitNetworkInterceptorExchange$okhttp(true);
                }
                if (followUp == null) {
                    if (exchange != null && exchange.isDuplex$okhttp()) {
                        call.timeoutEarlyExit();
                    }
                    call.exitNetworkInterceptorExchange$okhttp(false);
                    return response;
                }
                RequestBody followUpBody = followUp.body();
                if (followUpBody == null || !followUpBody.isOneShot()) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        Util.closeQuietly(body);
                    }
                    followUpCount++;
                    if (followUpCount > 20) {
                        throw new ProtocolException(Intrinsics.stringPlus("Too many follow-up requests: ", Integer.valueOf(followUpCount)));
                    }
                    request = followUp;
                    priorResponse = response;
                    call.exitNetworkInterceptorExchange$okhttp(true);
                } else {
                    call.exitNetworkInterceptorExchange$okhttp(false);
                    return response;
                }
            } catch (Throwable th) {
                call.exitNetworkInterceptorExchange$okhttp(true);
                throw th;
            }
        }
    }

    private final boolean recover(IOException e, RealCall call, Request userRequest, boolean requestSendStarted) {
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        return (!requestSendStarted || !requestIsOneShot(e, userRequest)) && isRecoverable(e, requestSendStarted) && call.retryAfterFailure();
    }

    private final boolean requestIsOneShot(IOException e, Request userRequest) {
        RequestBody requestBody = userRequest.body();
        return (requestBody != null && requestBody.isOneShot()) || (e instanceof FileNotFoundException);
    }

    private final boolean isRecoverable(IOException e, boolean requestSendStarted) {
        if (e instanceof ProtocolException) {
            return false;
        }
        if (e instanceof InterruptedIOException) {
            return (e instanceof SocketTimeoutException) && !requestSendStarted;
        }
        if ((!(e instanceof SSLHandshakeException) || !(e.getCause() instanceof CertificateException)) && !(e instanceof SSLPeerUnverifiedException)) {
            return true;
        }
        return false;
    }

    private final Request followUpRequest(Response userResponse, Exchange exchange) throws IOException {
        Route route;
        if (exchange == null) {
            route = null;
        } else {
            RealConnection connection$okhttp = exchange.getConnection$okhttp();
            route = connection$okhttp == null ? null : connection$okhttp.route();
        }
        int responseCode = userResponse.code();
        String method = userResponse.request().method();
        switch (responseCode) {
            case 300:
            case 301:
            case 302:
            case 303:
            case 307:
            case 308:
                return buildRedirectRequest(userResponse, method);
            case 401:
                return this.client.authenticator().authenticate(route, userResponse);
            case 407:
                Intrinsics.checkNotNull(route);
                if (route.proxy().type() == Proxy.Type.HTTP) {
                    return this.client.proxyAuthenticator().authenticate(route, userResponse);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            case 408:
                if (!this.client.retryOnConnectionFailure()) {
                    return null;
                }
                RequestBody requestBody = userResponse.request().body();
                if (requestBody != null && requestBody.isOneShot()) {
                    return null;
                }
                Response priorResponse = userResponse.priorResponse();
                if ((priorResponse == null || priorResponse.code() != 408) && retryAfter(userResponse, 0) <= 0) {
                    return userResponse.request();
                }
                return null;
            case 421:
                RequestBody requestBody2 = userResponse.request().body();
                if ((requestBody2 != null && requestBody2.isOneShot()) || exchange == null || !exchange.isCoalescedConnection$okhttp()) {
                    return null;
                }
                exchange.getConnection$okhttp().noCoalescedConnections$okhttp();
                return userResponse.request();
            case 503:
                Response priorResponse2 = userResponse.priorResponse();
                if ((priorResponse2 == null || priorResponse2.code() != 503) && retryAfter(userResponse, Integer.MAX_VALUE) == 0) {
                    return userResponse.request();
                }
                return null;
            default:
                return null;
        }
    }

    private final Request buildRedirectRequest(Response userResponse, String method) {
        String location;
        HttpUrl url;
        if (!this.client.followRedirects() || (location = Response.header$default(userResponse, "Location", null, 2, null)) == null || (url = userResponse.request().url().resolve(location)) == null) {
            return null;
        }
        if (!Intrinsics.areEqual(url.scheme(), userResponse.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder requestBuilder = userResponse.request().newBuilder();
        if (HttpMethod.permitsRequestBody(method)) {
            int responseCode = userResponse.code();
            boolean maintainBody = HttpMethod.INSTANCE.redirectsWithBody(method) || responseCode == 308 || responseCode == 307;
            if (!HttpMethod.INSTANCE.redirectsToGet(method) || responseCode == 308 || responseCode == 307) {
                requestBuilder.method(method, maintainBody ? userResponse.request().body() : null);
            } else {
                requestBuilder.method("GET", null);
            }
            if (!maintainBody) {
                requestBuilder.removeHeader("Transfer-Encoding");
                requestBuilder.removeHeader("Content-Length");
                requestBuilder.removeHeader("Content-Type");
            }
        }
        if (!Util.canReuseConnectionFor(userResponse.request().url(), url)) {
            requestBuilder.removeHeader("Authorization");
        }
        return requestBuilder.url(url).build();
    }

    private final int retryAfter(Response userResponse, int defaultDelay) {
        String header = Response.header$default(userResponse, "Retry-After", null, 2, null);
        if (header == null) {
            return defaultDelay;
        }
        if (!new Regex("\\d+").matches(header)) {
            return Integer.MAX_VALUE;
        }
        Integer valueOf = Integer.valueOf(header);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(header)");
        return valueOf.intValue();
    }

    /* compiled from: RetryAndFollowUpInterceptor.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\b\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006\u0005"}, m373d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor$Companion;", "", "()V", "MAX_FOLLOW_UPS", "", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http/RetryAndFollowUpInterceptor$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }
    }
}
