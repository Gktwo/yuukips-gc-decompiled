package p013io.javalin.plugin.json;

import java.io.InputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.core.LoomUtil;

/* compiled from: PipedStreamUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��(\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n��\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, m373d2 = {"Lio/javalin/plugin/json/PipedStreamUtil;", "", "()V", "executorService", "Ljava/util/concurrent/ExecutorService;", "getExecutorService", "()Ljava/util/concurrent/ExecutorService;", "getInputStream", "Ljava/io/InputStream;", "userCallback", "Lkotlin/Function1;", "Ljava/io/PipedOutputStream;", "", "javalin"})
/* renamed from: io.javalin.plugin.json.PipedStreamUtil */
/* loaded from: grasscutter.jar:io/javalin/plugin/json/PipedStreamUtil.class */
public final class PipedStreamUtil {
    @NotNull
    public static final PipedStreamUtil INSTANCE = new PipedStreamUtil();
    @NotNull
    private static final ExecutorService executorService;

    private PipedStreamUtil() {
    }

    @NotNull
    public final ExecutorService getExecutorService() {
        return executorService;
    }

    static {
        ThreadPoolExecutor threadPoolExecutor;
        if (LoomUtil.INSTANCE.getLoomAvailable()) {
            threadPoolExecutor = LoomUtil.INSTANCE.getExecutorService();
        } else {
            threadPoolExecutor = new ThreadPoolExecutor(4, 32, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        }
        executorService = threadPoolExecutor;
    }

    @NotNull
    public final InputStream getInputStream(@NotNull Function1<? super PipedOutputStream, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "userCallback");
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedStreamUtil$getInputStream$pipedInputStream$1 pipedInputStream = new PipedStreamUtil$getInputStream$pipedInputStream$1(pipedOutputStream);
        executorService.execute(() -> {
            m5866getInputStream$lambda0(r1, r2, r3);
        });
        return pipedInputStream;
    }

    /* renamed from: getInputStream$lambda-0  reason: not valid java name */
    private static final void m5866getInputStream$lambda0(Function1 $userCallback, PipedOutputStream $pipedOutputStream, PipedStreamUtil$getInputStream$pipedInputStream$1 $pipedInputStream) {
        Intrinsics.checkNotNullParameter($userCallback, "$userCallback");
        Intrinsics.checkNotNullParameter($pipedOutputStream, "$pipedOutputStream");
        Intrinsics.checkNotNullParameter($pipedInputStream, "$pipedInputStream");
        try {
            try {
                $userCallback.invoke($pipedOutputStream);
                $pipedOutputStream.close();
            } catch (Exception userException) {
                $pipedInputStream.setException(userException);
                $pipedOutputStream.close();
            }
        } catch (Throwable th) {
            $pipedOutputStream.close();
            throw th;
        }
    }
}
