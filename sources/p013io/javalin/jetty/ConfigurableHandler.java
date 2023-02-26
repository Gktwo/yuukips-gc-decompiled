package p013io.javalin.jetty;

import java.io.File;
import java.nio.file.AccessDeniedException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.resource.EmptyResource;
import org.eclipse.jetty.util.resource.Resource;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.core.util.JavalinException;
import p013io.javalin.core.util.JavalinLogger;
import p013io.javalin.http.staticfiles.Location;
import p013io.javalin.http.staticfiles.StaticFileConfig;

/* compiled from: JettyResourceHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f²\u0006\u0012\u0010\r\u001a\n \u000e*\u0004\u0018\u00010\b0\bX\u0002"}, m373d2 = {"Lio/javalin/jetty/ConfigurableHandler;", "Lorg/eclipse/jetty/server/handler/ResourceHandler;", "config", "Lio/javalin/http/staticfiles/StaticFileConfig;", "(Lio/javalin/http/staticfiles/StaticFileConfig;)V", "getConfig", "()Lio/javalin/http/staticfiles/StaticFileConfig;", "getResource", "Lorg/eclipse/jetty/util/resource/Resource;", "path", "", "getResourceBase", "javalin", "aliasResource", "kotlin.jvm.PlatformType"})
/* renamed from: io.javalin.jetty.ConfigurableHandler */
/* loaded from: grasscutter.jar:io/javalin/jetty/ConfigurableHandler.class */
public class ConfigurableHandler extends ResourceHandler {
    @NotNull
    private final StaticFileConfig config;

    public ConfigurableHandler(@NotNull StaticFileConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        setResourceBase(getResourceBase(this.config));
        setDirAllowed(false);
        setEtags(true);
        JavalinLogger.INSTANCE.addDelayed$javalin(new Function1<Unit, Unit>(this) { // from class: io.javalin.jetty.ConfigurableHandler.1
            final /* synthetic */ ConfigurableHandler this$0;

            {
                this.this$0 = $receiver;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke(unit);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Unit it) {
                Intrinsics.checkNotNullParameter(it, "it");
                JavalinLogger.info$default("Static file handler added: " + this.this$0.getConfig().refinedToString$javalin() + ". File system location: '" + this.this$0.getResourceBase(this.this$0.getConfig()) + '\'', null, 2, null);
            }
        });
    }

    @NotNull
    public final StaticFileConfig getConfig() {
        return this.config;
    }

    @Override // org.eclipse.jetty.server.handler.ResourceHandler, org.eclipse.jetty.util.resource.ResourceFactory
    @NotNull
    public Resource getResource(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Lazy aliasResource$delegate = LazyKt.lazy(new Function0<Resource>(this, path) { // from class: io.javalin.jetty.ConfigurableHandler$getResource$aliasResource$2
            final /* synthetic */ ConfigurableHandler this$0;
            final /* synthetic */ String $path;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
                this.$path = $path;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Resource invoke() {
                Resource baseResource = this.this$0.getBaseResource();
                Intrinsics.checkNotNull(baseResource);
                return baseResource.addPath(URIUtil.canonicalPath(this.$path));
            }
        });
        if (Intrinsics.areEqual(this.config.directory, "META-INF/resources/webjars")) {
            Resource newClassPathResource = Resource.newClassPathResource(Intrinsics.stringPlus("META-INF/resources", path));
            Resource resource = newClassPathResource == null ? EmptyResource.INSTANCE : newClassPathResource;
            Intrinsics.checkNotNullExpressionValue(resource, "Resource.newClassPathRes…?: EmptyResource.INSTANCE");
            return resource;
        } else if (this.config.aliasCheck != null && m5854getResource$lambda0(aliasResource$delegate).isAlias()) {
            ContextHandler.AliasCheck aliasCheck = this.config.aliasCheck;
            if (aliasCheck == null ? false : aliasCheck.check(path, m5854getResource$lambda0(aliasResource$delegate))) {
                Resource r0 = m5854getResource$lambda0(aliasResource$delegate);
                Intrinsics.checkNotNullExpressionValue(r0, "if (config.aliasCheck?.c…ion(\"Failed alias check\")");
                return r0;
            }
            throw new AccessDeniedException("Failed alias check");
        } else if (Intrinsics.areEqual(this.config.hostedPath, "/")) {
            Resource resource2 = getResource(path);
            Intrinsics.checkNotNullExpressionValue(resource2, "super.getResource(path)");
            return resource2;
        } else if (StringsKt.startsWith$default(path, this.config.hostedPath, false, 2, (Object) null)) {
            Resource resource3 = getResource(StringsKt.removePrefix(path, (CharSequence) this.config.hostedPath));
            Intrinsics.checkNotNullExpressionValue(resource3, "super.getResource(path.r…refix(config.hostedPath))");
            return resource3;
        } else {
            Resource resource4 = EmptyResource.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(resource4, "INSTANCE");
            return resource4;
        }
    }

    /* renamed from: getResource$lambda-0  reason: not valid java name */
    private static final Resource m5854getResource$lambda0(Lazy<? extends Resource> lazy) {
        return (Resource) lazy.getValue();
    }

    /* access modifiers changed from: private */
    public final String getResourceBase(StaticFileConfig config) {
        String noSuchDirMessage = "Static resource directory with path: '" + config.directory + "' does not exist.";
        if (config.location == Location.CLASSPATH) {
            Resource newClassPathResource = Resource.newClassPathResource(config.directory);
            String resource = newClassPathResource == null ? null : newClassPathResource.toString();
            if (resource != null) {
                return resource;
            }
            throw new JavalinException(noSuchDirMessage + " Depending on your setup, empty folders might not get copied to classpath.");
        } else if (new File(config.directory).exists()) {
            return config.directory;
        } else {
            throw new JavalinException(noSuchDirMessage);
        }
    }
}
