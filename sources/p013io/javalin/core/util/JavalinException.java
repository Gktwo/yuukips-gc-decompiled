package p013io.javalin.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* compiled from: JavalinExceptions.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0016\u0018��2\u00060\u0001j\u0002`\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, m373d2 = {"Lio/javalin/core/util/JavalinException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", SendMailJob.PROP_MESSAGE, "", "(Ljava/lang/String;)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "javalin"})
/* renamed from: io.javalin.core.util.JavalinException */
/* loaded from: grasscutter.jar:io/javalin/core/util/JavalinException.class */
public class JavalinException extends RuntimeException {
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public JavalinException(@NotNull String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
    }

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public JavalinException(@NotNull String message, @NotNull Throwable cause) {
        super(message, cause);
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public JavalinException(@NotNull Throwable cause) {
        super(cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
