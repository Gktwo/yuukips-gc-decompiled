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
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010$\n\u0002\b\u0006\b\u0016\u0018��2\u00060\u0001j\u0002`\u0002B-\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\tR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n��\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m373d2 = {"Lio/javalin/http/HttpResponseException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "status", "", SendMailJob.PROP_MESSAGE, "", "details", "", "(ILjava/lang/String;Ljava/util/Map;)V", "getDetails", "()Ljava/util/Map;", "getStatus", "()I", "javalin"})
/* renamed from: io.javalin.http.HttpResponseException */
/* loaded from: grasscutter.jar:io/javalin/http/HttpResponseException.class */
public class HttpResponseException extends RuntimeException {
    private final int status;
    @NotNull
    private final Map<String, String> details;

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HttpResponseException(int status, @NotNull String message) {
        this(status, message, null, 4, null);
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
    }

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HttpResponseException(int status, @NotNull String message, @NotNull Map<String, String> map) {
        super(message);
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        Intrinsics.checkNotNullParameter(map, "details");
        this.status = status;
        this.details = map;
    }

    public /* synthetic */ HttpResponseException(int i, String str, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? MapsKt.emptyMap() : map);
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final Map<String, String> getDetails() {
        return this.details;
    }
}
