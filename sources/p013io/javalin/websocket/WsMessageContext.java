package p013io.javalin.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.websocket.api.Session;
import org.jetbrains.annotations.NotNull;
import org.quartz.jobs.p027ee.mail.SendMailJob;
import p013io.javalin.plugin.json.JsonMapperKt;

/* compiled from: WsContext.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018��2\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0006\u001a\u00020\u0003J\u001a\u0010\b\u001a\u0002H\t\"\n\b��\u0010\t\u0018\u0001*\u00020\nH\b¢\u0006\u0002\u0010\u000bJ\u001f\u0010\b\u001a\u0002H\t\"\u0004\b��\u0010\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\t0\r¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��¨\u0006\u000f"}, m373d2 = {"Lio/javalin/websocket/WsMessageContext;", "Lio/javalin/websocket/WsContext;", "sessionId", "", "session", "Lorg/eclipse/jetty/websocket/api/Session;", SendMailJob.PROP_MESSAGE, "(Ljava/lang/String;Lorg/eclipse/jetty/websocket/api/Session;Ljava/lang/String;)V", "messageAsClass", "T", "", "()Ljava/lang/Object;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "javalin"})
/* renamed from: io.javalin.websocket.WsMessageContext */
/* loaded from: grasscutter.jar:io/javalin/websocket/WsMessageContext.class */
public final class WsMessageContext extends WsContext {
    @NotNull
    private final String message;

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public WsMessageContext(@NotNull String sessionId, @NotNull Session session, @NotNull String message) {
        super(sessionId, session);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        this.message = message;
    }

    @NotNull
    public final String message() {
        return this.message;
    }

    public final <T> T messageAsClass(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return (T) JsonMapperKt.jsonMapper(getUpgradeCtx$javalin()).fromJsonString(this.message, cls);
    }

    public final /* synthetic */ <T> T messageAsClass() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) messageAsClass(Object.class);
    }
}
