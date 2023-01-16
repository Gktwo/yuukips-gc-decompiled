package p013io.javalin.core.util;

import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.quartz.jobs.p027ee.mail.SendMailJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p013io.javalin.Javalin;

/* compiled from: JavalinLogger.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��6\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n��\n\u0002\u0010\u0003\n\u0002\b\u0007\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\f\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H��¢\u0006\u0002\b\u000eJ\u001c\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u001c\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u001c\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\r\u0010\u0016\u001a\u00020\u0006H��¢\u0006\u0002\b\u0017J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u001c\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007R \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0004¢\u0006\u0002\n��R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n��R\u0012\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n��¨\u0006\u001a"}, m373d2 = {"Lio/javalin/core/util/JavalinLogger;", "", "()V", "delayed", "Ljava/util/ArrayDeque;", "Lkotlin/Function1;", "", "enabled", "", "log", "Lorg/slf4j/Logger;", "startupInfo", "addDelayed", "action", "addDelayed$javalin", "debug", SendMailJob.PROP_MESSAGE, "", "throwable", "", "error", "info", "logAllDelayed", "logAllDelayed$javalin", "startup", "warn", "javalin"})
/* renamed from: io.javalin.core.util.JavalinLogger */
/* loaded from: grasscutter.jar:io/javalin/core/util/JavalinLogger.class */
public final class JavalinLogger {
    @NotNull
    private static final Logger log;
    @NotNull
    public static final JavalinLogger INSTANCE = new JavalinLogger();
    @JvmField
    public static boolean enabled = true;
    @JvmField
    public static boolean startupInfo = true;
    @NotNull
    private static final ArrayDeque<Function1<Unit, Unit>> delayed = new ArrayDeque<>();

    @JvmStatic
    @JvmOverloads
    public static final void info(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        info$default(message, null, 2, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void warn(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        warn$default(message, null, 2, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void error(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        error$default(message, null, 2, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void debug(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        debug$default(message, null, 2, null);
    }

    private JavalinLogger() {
    }

    static {
        Logger logger = LoggerFactory.getLogger(Javalin.class);
        Intrinsics.checkNotNull(logger);
        log = logger;
    }

    @JvmStatic
    public static final void startup(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        if (enabled && startupInfo) {
            log.info(message);
        }
    }

    public static /* synthetic */ void info$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        info(str, th);
    }

    @JvmStatic
    @JvmOverloads
    public static final void info(@NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        if (enabled) {
            if (throwable != null) {
                log.info(message, throwable);
            } else {
                log.info(message);
            }
        }
    }

    public static /* synthetic */ void warn$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        warn(str, th);
    }

    @JvmStatic
    @JvmOverloads
    public static final void warn(@NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        if (enabled) {
            if (throwable != null) {
                log.warn(message, throwable);
            } else {
                log.warn(message);
            }
        }
    }

    public static /* synthetic */ void error$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        error(str, th);
    }

    @JvmStatic
    @JvmOverloads
    public static final void error(@NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        if (enabled) {
            if (throwable != null) {
                log.error(message, throwable);
            } else {
                log.error(message);
            }
        }
    }

    public static /* synthetic */ void debug$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        debug(str, th);
    }

    @JvmStatic
    @JvmOverloads
    public static final void debug(@NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        if (enabled) {
            if (throwable != null) {
                log.debug(message, throwable);
            } else {
                log.debug(message);
            }
        }
    }

    public final boolean addDelayed$javalin(@NotNull Function1<? super Unit, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        return delayed.add(function1);
    }

    public final void logAllDelayed$javalin() {
        while (delayed.size() > 0) {
            delayed.poll().invoke(Unit.INSTANCE);
        }
    }
}
