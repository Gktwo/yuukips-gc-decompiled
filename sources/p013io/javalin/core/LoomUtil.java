package p013io.javalin.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.bytebuddy.ClassFileVersion;
import org.jetbrains.annotations.NotNull;

/* compiled from: LoomUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001a\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n��¨\u0006\n"}, m373d2 = {"Lio/javalin/core/LoomUtil;", "", "()V", "loomAvailable", "", "getLoomAvailable", "()Z", "useLoomThreadPool", "getExecutorService", "Ljava/util/concurrent/ExecutorService;", "javalin"})
/* renamed from: io.javalin.core.LoomUtil */
/* loaded from: grasscutter.jar:io/javalin/core/LoomUtil.class */
public final class LoomUtil {
    @NotNull
    public static final LoomUtil INSTANCE;
    @JvmField
    public static boolean useLoomThreadPool;
    private static final boolean loomAvailable;

    private LoomUtil() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:4:0x002a
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:232)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:54)
        */
    static {
        /*
            io.javalin.core.LoomUtil r0 = new io.javalin.core.LoomUtil
            r1 = r0
            r1.<init>()
            p013io.javalin.core.LoomUtil.INSTANCE = r0
            r0 = 1
            p013io.javalin.core.LoomUtil.useLoomThreadPool = r0
            java.lang.String r0 = "java.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            r6 = r0
            r0 = r6
            java.lang.String r1 = "getProperty(\"java.version\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r1 = "loom"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 1
            boolean r0 = kotlin.text.StringsKt.contains(r0, r1, r2)
            if (r0 != 0) goto L_0x004a
            java.lang.Class<java.lang.Thread> r0 = java.lang.Thread.class
            java.lang.String r1 = "startVirtualThread"
            r2 = 1
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: Exception -> 0x0043
            r6 = r2
            r2 = r6
            r3 = 0
            java.lang.Class<java.lang.Runnable> r4 = java.lang.Runnable.class
            r2[r3] = r4     // Catch: Exception -> 0x0043
            r2 = r6
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch: Exception -> 0x0043
            r0 = 1
            r6 = r0
            goto L_0x0046
        L_0x0043:
            r7 = move-exception
            r0 = 0
            r6 = r0
        L_0x0046:
            r0 = r6
            if (r0 == 0) goto L_0x004e
        L_0x004a:
            r0 = 1
            goto L_0x004f
        L_0x004e:
            r0 = 0
        L_0x004f:
            p013io.javalin.core.LoomUtil.loomAvailable = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.javalin.core.LoomUtil.m5740clinit():void");
    }

    public final boolean getLoomAvailable() {
        return loomAvailable;
    }

    @NotNull
    public final ExecutorService getExecutorService() {
        if (!loomAvailable) {
            throw new IllegalStateException("Your Java version (" + ((Object) System.getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION)) + ") doesn't support Loom");
        }
        Object invoke = Executors.class.getMethod("newVirtualThreadPerTaskExecutor", new Class[0]).invoke(Executors.class, new Object[0]);
        if (invoke != null) {
            return (ExecutorService) invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.ExecutorService");
    }
}
