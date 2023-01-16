package p013io.javalin.http;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CompletionException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import p013io.javalin.http.util.JsonEscapeUtil;

/* compiled from: HttpResponseExceptionMapper.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��@\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u0014\u001a\u00020\u000b2\n\u0010\n\u001a\u00060\u0010j\u0002`\u0011H\u0002J\f\u0010\u0015\u001a\u00020\u0004*\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006\u0016"}, m373d2 = {"Lio/javalin/http/HttpResponseExceptionMapper;", "", "()V", "docsUrl", "", "canHandle", "", "t", "", "classUrl", "e", "Lio/javalin/http/HttpResponseException;", "getTypeUrl", "handle", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "ctx", "Lio/javalin/http/Context;", "unwrap", "jsonEscape", "javalin"})
/* renamed from: io.javalin.http.HttpResponseExceptionMapper */
/* loaded from: grasscutter.jar:io/javalin/http/HttpResponseExceptionMapper.class */
public final class HttpResponseExceptionMapper {
    @NotNull
    public static final HttpResponseExceptionMapper INSTANCE = new HttpResponseExceptionMapper();
    @NotNull
    private static final String docsUrl = "https://javalin.io/documentation#";

    private HttpResponseExceptionMapper() {
    }

    public final boolean canHandle(@NotNull Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        return HttpResponseException.class.isAssignableFrom(t.getClass());
    }

    public final void handle(@NotNull Exception exception, @NotNull Context ctx) {
        String result;
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        HttpResponseException e = unwrap(exception);
        String header = ctx.header("Accept");
        if ((header == null ? false : StringsKt.contains$default((CharSequence) header, (CharSequence) ContentType.JSON, false, 2, (Object) null)) || Intrinsics.areEqual(ctx.res.getContentType(), ContentType.JSON)) {
            Context status = ctx.status(e.getStatus());
            StringBuilder append = new StringBuilder().append("{\n                |    \"title\": \"");
            String message = e.getMessage();
            StringBuilder append2 = append.append((Object) (message == null ? null : jsonEscape(message))).append("\",\n                |    \"status\": ").append(e.getStatus()).append(",\n                |    \"type\": \"");
            String typeUrl = getTypeUrl(e);
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, Logger.ROOT_LOGGER_NAME);
            if (typeUrl == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = typeUrl.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            StringBuilder append3 = append2.append(lowerCase).append("\",\n                |    \"details\": {");
            Map $this$map$iv = e.getDetails();
            Collection destination$iv$iv = new ArrayList($this$map$iv.size());
            for (Map.Entry item$iv$iv : $this$map$iv.entrySet()) {
                destination$iv$iv.add('\"' + item$iv$iv.getKey() + "\":\"" + INSTANCE.jsonEscape(item$iv$iv.getValue()) + '\"');
            }
            status.result(StringsKt.trimMargin$default(append3.append(CollectionsKt.joinToString$default((List) destination$iv$iv, ",", null, null, 0, null, null, 62, null)).append("}\n                |}").toString(), null, 1, null)).contentType(ContentType.APPLICATION_JSON);
            return;
        }
        if (e.getDetails().isEmpty()) {
            result = String.valueOf(e.getMessage());
        } else {
            StringBuilder append4 = new StringBuilder().append("\n                |").append((Object) e.getMessage()).append("\n                |");
            Map $this$map$iv2 = e.getDetails();
            Collection destination$iv$iv2 = new ArrayList($this$map$iv2.size());
            for (Map.Entry item$iv$iv2 : $this$map$iv2.entrySet()) {
                destination$iv$iv2.add("\n                |" + item$iv$iv2.getKey() + ":\n                |" + item$iv$iv2.getValue() + "\n                |");
            }
            result = StringsKt.trimMargin$default(append4.append(CollectionsKt.joinToString$default((List) destination$iv$iv2, "", null, null, 0, null, null, 62, null)).toString(), null, 1, null);
        }
        ctx.status(e.getStatus()).result(result);
    }

    private final String classUrl(HttpResponseException e) {
        return Intrinsics.stringPlus(docsUrl, e.getClass().getSimpleName());
    }

    private final HttpResponseException unwrap(Exception e) {
        Exception cause = e instanceof CompletionException ? e.getCause() : e;
        if (cause != null) {
            return (HttpResponseException) cause;
        }
        throw new NullPointerException("null cannot be cast to non-null type io.javalin.http.HttpResponseException");
    }

    private final String getTypeUrl(HttpResponseException e) {
        return (!(e instanceof RedirectResponse) && !(e instanceof BadRequestResponse) && !(e instanceof UnauthorizedResponse) && !(e instanceof ForbiddenResponse) && !(e instanceof NotFoundResponse) && !(e instanceof MethodNotAllowedResponse) && !(e instanceof ConflictResponse) && !(e instanceof GoneResponse) && !(e instanceof InternalServerErrorResponse) && !(e instanceof ServiceUnavailableResponse) && !(e instanceof BadGatewayResponse) && !(e instanceof GatewayTimeoutResponse)) ? "https://javalin.io/documentation#error-responses" : classUrl(e);
    }

    private final String jsonEscape(String $this$jsonEscape) {
        return JsonEscapeUtil.INSTANCE.escape($this$jsonEscape);
    }
}
