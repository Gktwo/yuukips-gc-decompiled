package p013io.javalin.jetty;

import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.jetbrains.annotations.NotNull;
import org.quartz.jobs.NativeJob;
import p013io.javalin.core.LoomUtil;

/* compiled from: JettyUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��¨\u0006\u000f"}, m373d2 = {"Lio/javalin/jetty/LoomThreadPool;", "Lorg/eclipse/jetty/util/thread/ThreadPool;", "()V", "executorService", "Ljava/util/concurrent/ExecutorService;", "execute", "", NativeJob.PROP_COMMAND, "Ljava/lang/Runnable;", "getIdleThreads", "", "getThreads", "isLowOnThreads", "", "join", "javalin"})
/* renamed from: io.javalin.jetty.LoomThreadPool */
/* loaded from: grasscutter.jar:io/javalin/jetty/LoomThreadPool.class */
public final class LoomThreadPool implements ThreadPool {
    @NotNull
    private final ExecutorService executorService = LoomUtil.INSTANCE.getExecutorService();

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable command) {
        Intrinsics.checkNotNullParameter(command, NativeJob.PROP_COMMAND);
        this.executorService.submit(command);
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    public void join() {
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    public int getThreads() {
        return 1;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    public int getIdleThreads() {
        return 1;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    public boolean isLowOnThreads() {
        return false;
    }
}
