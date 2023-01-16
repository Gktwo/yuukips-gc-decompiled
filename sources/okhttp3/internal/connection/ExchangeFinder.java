package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExchangeFinder.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��r\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\u0018��2\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0002J8\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0002J\u0006\u0010'\u001a\u00020$J\n\u0010(\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n��R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n��R\u000e\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u0002\n��R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n��R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n��¨\u00060"}, m373d2 = {"Lokhttp3/internal/connection/ExchangeFinder;", "", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "address", "Lokhttp3/Address;", "call", "Lokhttp3/internal/connection/RealCall;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "getAddress$okhttp", "()Lokhttp3/Address;", "connectionShutdownCount", "", "nextRouteToTry", "Lokhttp3/Route;", "otherFailureCount", "refusedStreamCount", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "find", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "findConnection", "Lokhttp3/internal/connection/RealConnection;", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "", "findHealthyConnection", "doExtensiveHealthChecks", "retryAfterFailure", "retryRoute", "sameHostAndPort", "url", "Lokhttp3/HttpUrl;", "trackFailure", "", "e", "Ljava/io/IOException;", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/connection/ExchangeFinder.class */
public final class ExchangeFinder {
    @NotNull
    private final RealConnectionPool connectionPool;
    @NotNull
    private final Address address;
    @NotNull
    private final RealCall call;
    @NotNull
    private final EventListener eventListener;
    @Nullable
    private RouteSelector.Selection routeSelection;
    @Nullable
    private RouteSelector routeSelector;
    private int refusedStreamCount;
    private int connectionShutdownCount;
    private int otherFailureCount;
    @Nullable
    private Route nextRouteToTry;

    public ExchangeFinder(@NotNull RealConnectionPool connectionPool, @NotNull Address address, @NotNull RealCall call, @NotNull EventListener eventListener) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
    }

    @NotNull
    public final Address getAddress$okhttp() {
        return this.address;
    }

    @NotNull
    public final ExchangeCodec find(@NotNull OkHttpClient client, @NotNull RealInterceptorChain chain) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        try {
            return findHealthyConnection(chain.getConnectTimeoutMillis$okhttp(), chain.getReadTimeoutMillis$okhttp(), chain.getWriteTimeoutMillis$okhttp(), client.pingIntervalMillis(), client.retryOnConnectionFailure(), !Intrinsics.areEqual(chain.getRequest$okhttp().method(), "GET")).newCodec$okhttp(client, chain);
        } catch (IOException e) {
            trackFailure(e);
            throw new RouteException(e);
        } catch (RouteException e2) {
            trackFailure(e2.getLastConnectException());
            throw e2;
        }
    }

    private final RealConnection findHealthyConnection(int connectTimeout, int readTimeout, int writeTimeout, int pingIntervalMillis, boolean connectionRetryEnabled, boolean doExtensiveHealthChecks) throws IOException {
        while (true) {
            RealConnection candidate = findConnection(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled);
            if (candidate.isHealthy(doExtensiveHealthChecks)) {
                return candidate;
            }
            candidate.noNewExchanges$okhttp();
            if (this.nextRouteToTry == null) {
                RouteSelector.Selection selection = this.routeSelection;
                if (selection == null ? true : selection.hasNext()) {
                    continue;
                } else {
                    RouteSelector routeSelector = this.routeSelector;
                    if (!(routeSelector == null ? true : routeSelector.hasNext())) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    private final RealConnection findConnection(int connectTimeout, int readTimeout, int writeTimeout, int pingIntervalMillis, boolean connectionRetryEnabled) throws IOException {
        Route route;
        List routes;
        if (this.call.isCanceled()) {
            throw new IOException("Canceled");
        }
        RealConnection callConnection = this.call.getConnection();
        if (callConnection != null) {
            Socket socket = null;
            synchronized (callConnection) {
                if (callConnection.getNoNewExchanges() || !sameHostAndPort(callConnection.route().address().url())) {
                    socket = this.call.releaseConnectionNoEvents$okhttp();
                }
                Unit unit = Unit.INSTANCE;
            }
            if (this.call.getConnection() != null) {
                if (socket == null) {
                    return callConnection;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            if (socket != null) {
                Util.closeQuietly(socket);
            }
            this.eventListener.connectionReleased(this.call, callConnection);
        }
        this.refusedStreamCount = 0;
        this.connectionShutdownCount = 0;
        this.otherFailureCount = 0;
        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false)) {
            RealConnection result = this.call.getConnection();
            Intrinsics.checkNotNull(result);
            this.eventListener.connectionAcquired(this.call, result);
            return result;
        }
        if (this.nextRouteToTry != null) {
            routes = null;
            Route route2 = this.nextRouteToTry;
            Intrinsics.checkNotNull(route2);
            route = route2;
            this.nextRouteToTry = null;
        } else {
            if (this.routeSelection != null) {
                RouteSelector.Selection selection = this.routeSelection;
                Intrinsics.checkNotNull(selection);
                if (selection.hasNext()) {
                    routes = null;
                    RouteSelector.Selection selection2 = this.routeSelection;
                    Intrinsics.checkNotNull(selection2);
                    route = selection2.next();
                }
            }
            RouteSelector localRouteSelector = this.routeSelector;
            if (localRouteSelector == null) {
                localRouteSelector = new RouteSelector(this.address, this.call.getClient().getRouteDatabase(), this.call, this.eventListener);
                this.routeSelector = localRouteSelector;
            }
            RouteSelector.Selection localRouteSelection = localRouteSelector.next();
            this.routeSelection = localRouteSelection;
            routes = localRouteSelection.getRoutes();
            if (this.call.isCanceled()) {
                throw new IOException("Canceled");
            } else if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, false)) {
                RealConnection result2 = this.call.getConnection();
                Intrinsics.checkNotNull(result2);
                this.eventListener.connectionAcquired(this.call, result2);
                return result2;
            } else {
                route = localRouteSelection.next();
            }
        }
        RealConnection newConnection = new RealConnection(this.connectionPool, route);
        this.call.setConnectionToCancel(newConnection);
        try {
            newConnection.connect(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled, this.call, this.eventListener);
            this.call.setConnectionToCancel(null);
            this.call.getClient().getRouteDatabase().connected(newConnection.route());
            if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, true)) {
                RealConnection result3 = this.call.getConnection();
                Intrinsics.checkNotNull(result3);
                this.nextRouteToTry = route;
                Util.closeQuietly(newConnection.socket());
                this.eventListener.connectionAcquired(this.call, result3);
                return result3;
            }
            synchronized (newConnection) {
                this.connectionPool.put(newConnection);
                this.call.acquireConnectionNoEvents(newConnection);
                Unit unit2 = Unit.INSTANCE;
            }
            this.eventListener.connectionAcquired(this.call, newConnection);
            return newConnection;
        } catch (Throwable th) {
            this.call.setConnectionToCancel(null);
            throw th;
        }
    }

    public final void trackFailure(@NotNull IOException e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.nextRouteToTry = null;
        if ((e instanceof StreamResetException) && ((StreamResetException) e).errorCode == ErrorCode.REFUSED_STREAM) {
            this.refusedStreamCount++;
        } else if (e instanceof ConnectionShutdownException) {
            this.connectionShutdownCount++;
        } else {
            this.otherFailureCount++;
        }
    }

    public final boolean retryAfterFailure() {
        RouteSelector localRouteSelector;
        if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if (this.nextRouteToTry != null) {
            return true;
        }
        Route retryRoute = retryRoute();
        if (retryRoute != null) {
            this.nextRouteToTry = retryRoute;
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        if (!(selection == null ? false : selection.hasNext()) && (localRouteSelector = this.routeSelector) != null) {
            return localRouteSelector.hasNext();
        }
        return true;
    }

    private final Route retryRoute() {
        RealConnection connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0 || (connection = this.call.getConnection()) == null) {
            return null;
        }
        synchronized (connection) {
            if (connection.getRouteFailureCount$okhttp() != 0) {
                return null;
            }
            if (!Util.canReuseConnectionFor(connection.route().address().url(), getAddress$okhttp().url())) {
                return null;
            }
            return connection.route();
        }
    }

    public final boolean sameHostAndPort(@NotNull HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HttpUrl routeUrl = this.address.url();
        return url.port() == routeUrl.port() && Intrinsics.areEqual(url.host(), routeUrl.host());
    }
}
