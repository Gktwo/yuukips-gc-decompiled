package p013io.javalin.core.plugin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* compiled from: PluginExceptions.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018��2\u00060\u0001j\u0002`\u0002B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n��\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m373d2 = {"Lio/javalin/core/plugin/PluginLifecycleViolationException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "pluginClass", "Ljava/lang/Class;", "Lio/javalin/core/plugin/Plugin;", SendMailJob.PROP_MESSAGE, "", "(Ljava/lang/Class;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "javalin"})
/* renamed from: io.javalin.core.plugin.PluginLifecycleViolationException */
/* loaded from: grasscutter.jar:io/javalin/core/plugin/PluginLifecycleViolationException.class */
public abstract class PluginLifecycleViolationException extends RuntimeException {
    @NotNull
    private final String message;

    @Override // java.lang.Throwable
    @NotNull
    public String getMessage() {
        return this.message;
    }

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public PluginLifecycleViolationException(@NotNull Class<? extends Plugin> cls, @NotNull String message) {
        super("Error in " + ((Object) cls.getCanonicalName()) + ": " + message);
        Intrinsics.checkNotNullParameter(cls, "pluginClass");
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        this.message = message;
    }
}
