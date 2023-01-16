package p013io.netty.util.concurrent;

import java.util.concurrent.Executor;
import org.quartz.jobs.NativeJob;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.util.concurrent.ImmediateExecutor */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/ImmediateExecutor.class */
public final class ImmediateExecutor implements Executor {
    public static final ImmediateExecutor INSTANCE = new ImmediateExecutor();

    private ImmediateExecutor() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        ((Runnable) ObjectUtil.checkNotNull(command, NativeJob.PROP_COMMAND)).run();
    }
}
