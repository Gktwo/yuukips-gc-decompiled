package p013io.javalin.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* compiled from: JavalinExceptions.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m373d2 = {"Lio/javalin/core/util/JavalinBindException;", "Lio/javalin/core/util/JavalinException;", SendMailJob.PROP_MESSAGE, "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "javalin"})
/* renamed from: io.javalin.core.util.JavalinBindException */
/* loaded from: grasscutter.jar:io/javalin/core/util/JavalinBindException.class */
public final class JavalinBindException extends JavalinException {
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public JavalinBindException(@NotNull String message, @NotNull Throwable cause) {
        super(message, cause);
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
