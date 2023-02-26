package p013io.javalin.jetty;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import kcp.highway.Kcp;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.server.LowResourceMonitor;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.StatisticsHandler;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.quartz.jobs.p027ee.ejb.EJBInvokerJob;
import p013io.javalin.core.LoomUtil;
import p013io.javalin.core.util.JavalinLogger;

/* compiled from: JettyUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��8\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018��2\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0006\u0010\u0018\u001a\u00020\rR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001a"}, m373d2 = {"Lio/javalin/jetty/JettyUtil;", "", "()V", "logDuringStartup", "", "logIfNotStarted", "getLogIfNotStarted", "()Z", "setLogIfNotStarted", "(Z)V", "defaultThreadPool", "Lorg/eclipse/jetty/util/thread/ThreadPool;", "disableJettyLogger", "", "getOrDefault", "Lorg/eclipse/jetty/server/Server;", "server", "isClientAbortException", "t", "", "isJettyTimeoutException", "maybeLogIfServerNotStarted", "jettyServer", "Lio/javalin/jetty/JettyServer;", "reEnableJettyLogger", "NoopLogger", "javalin"})
/* renamed from: io.javalin.jetty.JettyUtil */
/* loaded from: grasscutter.jar:io/javalin/jetty/JettyUtil.class */
public final class JettyUtil {
    @JvmField
    public static boolean logDuringStartup;
    @NotNull
    public static final JettyUtil INSTANCE = new JettyUtil();
    private static boolean logIfNotStarted = true;

    private JettyUtil() {
    }

    @JvmStatic
    @NotNull
    public static final Server getOrDefault(@Nullable Server server) {
        if (server != null) {
            return server;
        }
        Server $this$getOrDefault_u24lambda_u2d0 = new Server(INSTANCE.defaultThreadPool());
        $this$getOrDefault_u24lambda_u2d0.addBean(new LowResourceMonitor($this$getOrDefault_u24lambda_u2d0));
        $this$getOrDefault_u24lambda_u2d0.insertHandler(new StatisticsHandler());
        $this$getOrDefault_u24lambda_u2d0.setAttribute("is-default-server", true);
        return $this$getOrDefault_u24lambda_u2d0;
    }

    private final ThreadPool defaultThreadPool() {
        if (!LoomUtil.useLoomThreadPool || !LoomUtil.INSTANCE.getLoomAvailable()) {
            QueuedThreadPool $this$defaultThreadPool_u24lambda_u2d1 = new QueuedThreadPool(250, 8, (int) Kcp.IKCP_RTO_MAX);
            $this$defaultThreadPool_u24lambda_u2d1.setName("JettyServerThreadPool");
            return $this$defaultThreadPool_u24lambda_u2d1;
        }
        JavalinLogger.info$default("Loom is available, using Virtual ThreadPool... Neat!", null, 2, null);
        return new LoomThreadPool();
    }

    @JvmStatic
    public static final void disableJettyLogger() {
        if (!logDuringStartup) {
            Logger access$getDefaultLogger$p = JettyUtilKt.access$getDefaultLogger$p();
            JettyUtilKt.access$setDefaultLogger$p(access$getDefaultLogger$p == null ? Log.getLog() : access$getDefaultLogger$p);
            Log.setLog(new NoopLogger());
        }
    }

    public final void reEnableJettyLogger() {
        if (!logDuringStartup) {
            Log.setLog(JettyUtilKt.access$getDefaultLogger$p());
        }
    }

    public final boolean getLogIfNotStarted() {
        return logIfNotStarted;
    }

    public final void setLogIfNotStarted(boolean z) {
        logIfNotStarted = z;
    }

    @JvmStatic
    public static final void maybeLogIfServerNotStarted(@NotNull JettyServer jettyServer) {
        Intrinsics.checkNotNullParameter(jettyServer, "jettyServer");
        new Thread(() -> {
            m5859maybeLogIfServerNotStarted$lambda2(r2);
        }).start();
    }

    /* renamed from: maybeLogIfServerNotStarted$lambda-2  reason: not valid java name */
    private static final void m5859maybeLogIfServerNotStarted$lambda2(JettyServer $jettyServer) {
        Intrinsics.checkNotNullParameter($jettyServer, "$jettyServer");
        Thread.sleep(5000);
        if (INSTANCE.getLogIfNotStarted() && !$jettyServer.started) {
            JavalinLogger.info$default("It looks like you created a Javalin instance, but you never started it.", null, 2, null);
            JavalinLogger.info$default("Try: Javalin app = Javalin.create().start();", null, 2, null);
            JavalinLogger.info$default("For more help, visit https://javalin.io/documentation#server-setup", null, 2, null);
            JavalinLogger.info$default("To disable this message, do `JettyUtil.logIfNotStarted = false`", null, 2, null);
        }
    }

    public final boolean isClientAbortException(@NotNull Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        return Intrinsics.areEqual(t.getClass().getName(), "org.eclipse.jetty.io.EofException");
    }

    public final boolean isJettyTimeoutException(@NotNull Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        return (t instanceof IOException) && (t.getCause() instanceof TimeoutException);
    }

    /* compiled from: JettyUtil.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\u0011\n\u0002\u0010��\n\u0002\b\u0003\n\u0002\u0010\t\n��\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0016¢\u0006\u0002\u0010\nJ\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020��2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J)\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0016¢\u0006\u0002\u0010\nJ\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J)\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0016¢\u0006\u0002\u0010\nJ\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u001b"}, m373d2 = {"Lio/javalin/jetty/JettyUtil$NoopLogger;", "Lorg/eclipse/jetty/util/log/Logger;", "()V", "debug", "", "msg", "", EJBInvokerJob.EJB_ARGS_KEY, "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "s", "l", "", "thrown", "", "getLogger", "name", "getName", "ignore", "ignored", "info", "isDebugEnabled", "", "setDebugEnabled", "enabled", "warn", "javalin"})
    /* renamed from: io.javalin.jetty.JettyUtil$NoopLogger */
    /* loaded from: grasscutter.jar:io/javalin/jetty/JettyUtil$NoopLogger.class */
    public static final class NoopLogger implements Logger {
        @Override // org.eclipse.jetty.util.log.Logger
        @NotNull
        public String getName() {
            return "noop";
        }

        @Override // org.eclipse.jetty.util.log.Logger
        @NotNull
        public NoopLogger getLogger(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this;
        }

        @Override // org.eclipse.jetty.util.log.Logger
        public void setDebugEnabled(boolean enabled) {
        }

        @Override // org.eclipse.jetty.util.log.Logger
        public boolean isDebugEnabled() {
            return false;
        }

        @Override // org.eclipse.jetty.util.log.Logger
        public void ignore(@NotNull Throwable ignored) {
            Intrinsics.checkNotNullParameter(ignored, "ignored");
        }

        @Override // org.eclipse.jetty.util.log.Logger
        public void warn(@NotNull String msg, @NotNull Object... args) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(args, EJBInvokerJob.EJB_ARGS_KEY);
        }

        @Override // org.eclipse.jetty.util.log.Logger
        public void warn(@NotNull Throwable thrown) {
            Intrinsics.checkNotNullParameter(thrown, "thrown");
        }

        @Override // org.eclipse.jetty.util.log.Logger
        public void warn(@NotNull String msg, @NotNull Throwable thrown) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(thrown, "thrown");
        }

        @Override // org.eclipse.jetty.util.log.Logger
        public void info(@NotNull String msg, @NotNull Object... args) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(args, EJBInvokerJob.EJB_ARGS_KEY);
        }

        @Override // org.eclipse.jetty.util.log.Logger
        public void info(@NotNull Throwable thrown) {
            Intrinsics.checkNotNullParameter(thrown, "thrown");
        }

        @Override // org.eclipse.jetty.util.log.Logger
        public void info(@NotNull String msg, @NotNull Throwable thrown) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(thrown, "thrown");
        }

        @Override // org.eclipse.jetty.util.log.Logger
        public void debug(@NotNull String msg, @NotNull Object... args) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(args, EJBInvokerJob.EJB_ARGS_KEY);
        }

        @Override // org.eclipse.jetty.util.log.Logger
        public void debug(@NotNull String s, long l) {
            Intrinsics.checkNotNullParameter(s, "s");
        }

        @Override // org.eclipse.jetty.util.log.Logger
        public void debug(@NotNull Throwable thrown) {
            Intrinsics.checkNotNullParameter(thrown, "thrown");
        }

        @Override // org.eclipse.jetty.util.log.Logger
        public void debug(@NotNull String msg, @NotNull Throwable thrown) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(thrown, "thrown");
        }
    }
}
