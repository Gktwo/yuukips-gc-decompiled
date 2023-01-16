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
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010$\n\u0002\b\u0002\u0018��2\u00020\u0001B'\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m373d2 = {"Lio/javalin/http/BadGatewayResponse;", "Lio/javalin/http/HttpResponseException;", SendMailJob.PROP_MESSAGE, "", "details", "", "(Ljava/lang/String;Ljava/util/Map;)V", "javalin"})
/* renamed from: io.javalin.http.BadGatewayResponse */
/* loaded from: grasscutter.jar:io/javalin/http/BadGatewayResponse.class */
public final class BadGatewayResponse extends HttpResponseException {
    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BadGatewayResponse(@NotNull String message) {
        this(message, null, 2, null);
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
    }

    @JvmOverloads
    public BadGatewayResponse() {
        this(null, null, 3, null);
    }

    public /* synthetic */ BadGatewayResponse(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Bad gateway" : str, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BadGatewayResponse(@NotNull String message, @NotNull Map<String, String> map) {
        super(HttpCode.BAD_GATEWAY.getStatus(), message, map);
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        Intrinsics.checkNotNullParameter(map, "details");
    }
}
