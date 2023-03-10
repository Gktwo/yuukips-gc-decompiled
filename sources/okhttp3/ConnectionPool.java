package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.MethodDelegation;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConnectionPool.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��.\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\b\n��\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018��2\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0007\b\u0016¢\u0006\u0002\u0010\tB\u000f\b��\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0003R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n��\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, m373d2 = {"Lokhttp3/ConnectionPool;", "", "maxIdleConnections", "", "keepAliveDuration", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(IJLjava/util/concurrent/TimeUnit;)V", "()V", MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, "Lokhttp3/internal/connection/RealConnectionPool;", "(Lokhttp3/internal/connection/RealConnectionPool;)V", "getDelegate$okhttp", "()Lokhttp3/internal/connection/RealConnectionPool;", "connectionCount", "evictAll", "", "idleConnectionCount", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/ConnectionPool.class */
public final class ConnectionPool {
    @NotNull
    private final RealConnectionPool delegate;

    public ConnectionPool(@NotNull RealConnectionPool delegate) {
        Intrinsics.checkNotNullParameter(delegate, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.delegate = delegate;
    }

    @NotNull
    public final RealConnectionPool getDelegate$okhttp() {
        return this.delegate;
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int maxIdleConnections, long keepAliveDuration, @NotNull TimeUnit timeUnit) {
        this(new RealConnectionPool(TaskRunner.INSTANCE, maxIdleConnections, keepAliveDuration, timeUnit));
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
    }

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public final int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }

    public final int connectionCount() {
        return this.delegate.connectionCount();
    }

    public final void evictAll() {
        this.delegate.evictAll();
    }
}
