package p013io.javalin.http;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* compiled from: HttpResponseException.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010$\n\u0002\b\u0002\u0018��2\u00020\u0001B1\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, m373d2 = {"Lio/javalin/http/RedirectResponse;", "Lio/javalin/http/HttpResponseException;", "status", "", SendMailJob.PROP_MESSAGE, "", "details", "", "(ILjava/lang/String;Ljava/util/Map;)V", "javalin"})
/* renamed from: io.javalin.http.RedirectResponse */
/* loaded from: grasscutter.jar:io/javalin/http/RedirectResponse.class */
public final class RedirectResponse extends HttpResponseException {
    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RedirectResponse(int status, @NotNull String message) {
        this(status, message, null, 4, null);
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
    }

    @JvmOverloads
    public RedirectResponse(int status) {
        this(status, null, null, 6, null);
    }

    @JvmOverloads
    public RedirectResponse() {
        this(0, null, null, 7, null);
    }

    public /* synthetic */ RedirectResponse(int i, String str, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? HttpCode.FOUND.getStatus() : i, (i2 & 2) != 0 ? "Redirected" : str, (i2 & 4) != 0 ? MapsKt.emptyMap() : map);
    }

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RedirectResponse(int status, @NotNull String message, @NotNull Map<String, String> map) {
        super(status, message, map);
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        Intrinsics.checkNotNullParameter(map, "details");
    }
}
