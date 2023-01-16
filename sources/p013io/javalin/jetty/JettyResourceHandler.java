package p013io.javalin.jetty;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.eclipse.jetty.util.resource.Resource;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.staticfiles.ResourceHandler;
import p013io.javalin.http.staticfiles.StaticFileConfig;

/* compiled from: JettyResourceHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001e\u0010\u0012\u001a\u00020\r*\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\r*\u0004\u0018\u00010\u0013H\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, m373d2 = {"Lio/javalin/jetty/JettyResourceHandler;", "Lio/javalin/http/staticfiles/ResourceHandler;", "()V", "handlers", "", "Lio/javalin/jetty/ConfigurableHandler;", "getHandlers", "()Ljava/util/List;", "addStaticFileConfig", "", "config", "Lio/javalin/http/staticfiles/StaticFileConfig;", "handle", "", "httpRequest", "Ljavax/servlet/http/HttpServletRequest;", "httpResponse", "Ljavax/servlet/http/HttpServletResponse;", "isDirectoryWithWelcomeFile", "Lorg/eclipse/jetty/util/resource/Resource;", "handler", "Lorg/eclipse/jetty/server/handler/ResourceHandler;", TypeProxy.INSTANCE_FIELD, "", "isFile", "javalin"})
/* renamed from: io.javalin.jetty.JettyResourceHandler */
/* loaded from: grasscutter.jar:io/javalin/jetty/JettyResourceHandler.class */
public final class JettyResourceHandler implements ResourceHandler {
    @NotNull
    private final List<ConfigurableHandler> handlers = new ArrayList();

    public JettyResourceHandler() {
        JettyUtil.disableJettyLogger();
    }

    @NotNull
    public final List<ConfigurableHandler> getHandlers() {
        return this.handlers;
    }

    @Override // p013io.javalin.http.staticfiles.ResourceHandler
    public void addStaticFileConfig(@NotNull StaticFileConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        List<ConfigurableHandler> list = this.handlers;
        ConfigurableHandler $this$addStaticFileConfig_u24lambda_u2d0 = new ConfigurableHandler(config);
        $this$addStaticFileConfig_u24lambda_u2d0.start();
        Unit unit = Unit.INSTANCE;
        list.add($this$addStaticFileConfig_u24lambda_u2d0);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:40:0x01cb
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // p013io.javalin.http.staticfiles.ResourceHandler
    public boolean handle(@org.jetbrains.annotations.NotNull javax.servlet.http.HttpServletRequest r7, @org.jetbrains.annotations.NotNull javax.servlet.http.HttpServletResponse r8) {
        /*
        // Method dump skipped, instructions count: 527
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.javalin.jetty.JettyResourceHandler.handle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse):boolean");
    }

    private final boolean isFile(Resource $this$isFile) {
        return $this$isFile != null && $this$isFile.exists() && !$this$isFile.isDirectory();
    }

    private final boolean isDirectoryWithWelcomeFile(Resource $this$isDirectoryWithWelcomeFile, org.eclipse.jetty.server.handler.ResourceHandler handler, String target) {
        if ($this$isDirectoryWithWelcomeFile != null && $this$isDirectoryWithWelcomeFile.isDirectory()) {
            Resource resource = handler.getResource(Intrinsics.stringPlus(StringsKt.removeSuffix(target, (CharSequence) "/"), "/index.html"));
            if (resource == null ? false : resource.exists()) {
                return true;
            }
        }
        return false;
    }
}
