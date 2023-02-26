package p013io.javalin.http.sse;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.InputStream;
import javax.servlet.AsyncContext;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.quartz.jobs.p027ee.mail.SendMailJob;
import p013io.javalin.http.Context;
import p013io.javalin.plugin.json.JsonMapperKt;

/* compiled from: SseClient.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��6\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010��\n\u0002\b\u0003\u0018��2\u00020\u0001B\u000f\b��\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011J$\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n��¨\u0006\u0014"}, m373d2 = {"Lio/javalin/http/sse/SseClient;", "Ljava/io/Closeable;", "ctx", "Lio/javalin/http/Context;", "(Lio/javalin/http/Context;)V", "closeCallback", "Ljava/lang/Runnable;", "emitter", "Lio/javalin/http/sse/Emitter;", "close", "", "onClose", "sendComment", "comment", "", "sendEvent", "data", "", "event", "id", "javalin"})
/* renamed from: io.javalin.http.sse.SseClient */
/* loaded from: grasscutter.jar:io/javalin/http/sse/SseClient.class */
public final class SseClient implements Closeable {
    @JvmField
    @NotNull
    public final Context ctx;
    @NotNull
    private final Emitter emitter;
    @NotNull
    private Runnable closeCallback = SseClient::m5835closeCallback$lambda0;

    @JvmOverloads
    public final void sendEvent(@NotNull String event, @NotNull Object data) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(data, "data");
        sendEvent$default(this, event, data, null, 4, null);
    }

    public SseClient(@NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.ctx = ctx;
        AsyncContext asyncContext = this.ctx.req.getAsyncContext();
        Intrinsics.checkNotNullExpressionValue(asyncContext, "ctx.req.asyncContext");
        this.emitter = new Emitter(asyncContext);
    }

    /* renamed from: closeCallback$lambda-0  reason: not valid java name */
    private static final void m5835closeCallback$lambda0() {
    }

    public final void onClose(@NotNull Runnable closeCallback) {
        Intrinsics.checkNotNullParameter(closeCallback, "closeCallback");
        this.closeCallback = closeCallback;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.ctx.req.getAsyncContext().complete();
        this.closeCallback.run();
    }

    public final void sendEvent(@NotNull Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        sendEvent$default(this, SendMailJob.PROP_MESSAGE, data, null, 4, null);
    }

    public static /* synthetic */ void sendEvent$default(SseClient sseClient, String str, Object obj, String str2, int i, Object obj2) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        sseClient.sendEvent(str, obj, str2);
    }

    @JvmOverloads
    public final void sendEvent(@NotNull String event, @NotNull Object data, @Nullable String id) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof InputStream) {
            this.emitter.emit(event, (InputStream) data, id);
        } else if (data instanceof String) {
            Emitter emitter = this.emitter;
            byte[] bytes = ((String) data).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            emitter.emit(event, new ByteArrayInputStream(bytes), id);
        } else {
            Emitter emitter2 = this.emitter;
            String jsonString = JsonMapperKt.jsonMapper(this.ctx).toJsonString(data);
            Intrinsics.checkNotNullExpressionValue(jsonString, "ctx.jsonMapper().toJsonString(data)");
            byte[] bytes2 = jsonString.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
            emitter2.emit(event, new ByteArrayInputStream(bytes2), id);
        }
        if (this.emitter.isClosed()) {
            close();
        }
    }

    public final void sendComment(@NotNull String comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        this.emitter.emit(comment);
        if (this.emitter.isClosed()) {
            close();
        }
    }
}
