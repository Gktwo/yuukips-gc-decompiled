package p013io.javalin.core.security;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.quartz.jobs.p027ee.mail.SendMailJob;
import p013io.javalin.Javalin;
import p013io.javalin.core.plugin.Plugin;
import p013io.javalin.http.Context;
import p013io.javalin.http.UnauthorizedResponse;

/* compiled from: BasicAuthFilter.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��¨\u0006\n"}, m373d2 = {"Lio/javalin/core/security/BasicAuthFilter;", "Lio/javalin/core/plugin/Plugin;", SendMailJob.PROP_USERNAME, "", "password", "(Ljava/lang/String;Ljava/lang/String;)V", "apply", "", "app", "Lio/javalin/Javalin;", "javalin"})
/* renamed from: io.javalin.core.security.BasicAuthFilter */
/* loaded from: grasscutter.jar:io/javalin/core/security/BasicAuthFilter.class */
public final class BasicAuthFilter implements Plugin {
    @NotNull
    private final String username;
    @NotNull
    private final String password;

    public BasicAuthFilter(@NotNull String username, @NotNull String password) {
        Intrinsics.checkNotNullParameter(username, SendMailJob.PROP_USERNAME);
        Intrinsics.checkNotNullParameter(password, "password");
        this.username = username;
        this.password = password;
    }

    @Override // p013io.javalin.core.plugin.Plugin
    public void apply(@NotNull Javalin app) {
        Intrinsics.checkNotNullParameter(app, "app");
        app.before((v1) -> {
            m5755apply$lambda3(r1, v1);
        });
    }

    /* renamed from: apply$lambda-3  reason: not valid java name */
    private static final void m5755apply$lambda3(BasicAuthFilter this$0, Context ctx) {
        Object obj;
        boolean matched;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m7062constructorimpl(ctx.basicAuthCredentials());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m7062constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7058exceptionOrNullimpl(obj) == null) {
            BasicAuthCredentials $dstr$user$pass = (BasicAuthCredentials) obj;
            matched = Intrinsics.areEqual($dstr$user$pass.component1(), this$0.username) && Intrinsics.areEqual($dstr$user$pass.component2(), this$0.password);
        } else {
            matched = false;
        }
        if (!matched) {
            ctx.header("WWW-Authenticate", "Basic");
            throw new UnauthorizedResponse(null, null, 3, null);
        }
    }
}
