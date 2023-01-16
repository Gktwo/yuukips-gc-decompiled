package p013io.javalin.core.security;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* compiled from: SecurityUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\"\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020��2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m373d2 = {"Lio/javalin/core/security/BasicAuthCredentials;", "", SendMailJob.PROP_USERNAME, "", "password", "(Ljava/lang/String;Ljava/lang/String;)V", "getPassword", "()Ljava/lang/String;", "getUsername", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", Printer.TO_STRING, "javalin"})
/* renamed from: io.javalin.core.security.BasicAuthCredentials */
/* loaded from: grasscutter.jar:io/javalin/core/security/BasicAuthCredentials.class */
public final class BasicAuthCredentials {
    @NotNull
    private final String username;
    @NotNull
    private final String password;

    @NotNull
    public final String component1() {
        return this.username;
    }

    @NotNull
    public final String component2() {
        return this.password;
    }

    @NotNull
    public final BasicAuthCredentials copy(@NotNull String username, @NotNull String password) {
        Intrinsics.checkNotNullParameter(username, SendMailJob.PROP_USERNAME);
        Intrinsics.checkNotNullParameter(password, "password");
        return new BasicAuthCredentials(username, password);
    }

    public static /* synthetic */ BasicAuthCredentials copy$default(BasicAuthCredentials basicAuthCredentials, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = basicAuthCredentials.username;
        }
        if ((i & 2) != 0) {
            str2 = basicAuthCredentials.password;
        }
        return basicAuthCredentials.copy(str, str2);
    }

    @NotNull
    public String toString() {
        return "BasicAuthCredentials(username=" + this.username + ", password=" + this.password + ')';
    }

    public int hashCode() {
        return (this.username.hashCode() * 31) + this.password.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BasicAuthCredentials)) {
            return false;
        }
        BasicAuthCredentials basicAuthCredentials = (BasicAuthCredentials) other;
        return Intrinsics.areEqual(this.username, basicAuthCredentials.username) && Intrinsics.areEqual(this.password, basicAuthCredentials.password);
    }

    public BasicAuthCredentials(@NotNull String username, @NotNull String password) {
        Intrinsics.checkNotNullParameter(username, SendMailJob.PROP_USERNAME);
        Intrinsics.checkNotNullParameter(password, "password");
        this.username = username;
        this.password = password;
    }

    @NotNull
    public final String getUsername() {
        return this.username;
    }

    @NotNull
    public final String getPassword() {
        return this.password;
    }
}
