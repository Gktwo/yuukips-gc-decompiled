package p013io.javalin.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.UpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;

/* compiled from: WsConnection.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��\f\n��\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n��\u001a\f\u0010��\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m373d2 = {"uriNoContextPath", "", "Lorg/eclipse/jetty/websocket/api/Session;", "javalin"})
/* renamed from: io.javalin.websocket.WsConnectionKt */
/* loaded from: grasscutter.jar:io/javalin/websocket/WsConnectionKt.class */
public final class WsConnectionKt {
    public static final String uriNoContextPath(Session $this$uriNoContextPath) {
        String path = $this$uriNoContextPath.getUpgradeRequest().getRequestURI().getPath();
        Intrinsics.checkNotNullExpressionValue(path, "this.upgradeRequest.requestURI.path");
        UpgradeRequest upgradeRequest = $this$uriNoContextPath.getUpgradeRequest();
        if (upgradeRequest == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest");
        }
        String contextPath = ((ServletUpgradeRequest) upgradeRequest).getHttpServletRequest().getContextPath();
        Intrinsics.checkNotNullExpressionValue(contextPath, "this.upgradeRequest as S…ervletRequest.contextPath");
        return StringsKt.removePrefix(path, (CharSequence) contextPath);
    }
}
