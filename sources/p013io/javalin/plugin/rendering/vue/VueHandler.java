package p013io.javalin.plugin.rendering.vue;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.builtins.TTop;
import p013io.javalin.http.Context;
import p013io.javalin.http.Handler;
import p013io.javalin.http.InternalServerErrorResponse;

/* compiled from: VueHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010��\n\u0002\b\u0004\n\u0002\u0018\u0002\b&\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0014\u0010\u000e\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u0002"}, m373d2 = {"Lio/javalin/plugin/rendering/vue/VueHandler;", "Lio/javalin/http/Handler;", "componentId", "", "(Ljava/lang/String;)V", "handle", "", "ctx", "Lio/javalin/http/Context;", "postRender", "layout", "preRender", TTop.STAT_STATE, "", "postRenderHook", "preRenderHook", "javalin", "resolver", "Lio/javalin/plugin/rendering/vue/VueDependencyResolver;"})
/* renamed from: io.javalin.plugin.rendering.vue.VueHandler */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/vue/VueHandler.class */
public abstract class VueHandler implements Handler {
    @NotNull
    private final String componentId;

    public VueHandler(@NotNull String componentId) {
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        this.componentId = componentId;
    }

    @Nullable
    public Object state(@NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return null;
    }

    @NotNull
    public String preRender(@NotNull String layout, @NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return layout;
    }

    @NotNull
    public String postRender(@NotNull String layout, @NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return layout;
    }

    @Override // p013io.javalin.http.Handler
    public void handle(@NotNull Context ctx) {
        String componentId;
        String dependencies;
        Path path;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        JavalinVue javalinVue = JavalinVue.INSTANCE;
        Boolean isDev$javalin = JavalinVue.INSTANCE.isDev$javalin();
        javalinVue.setDev$javalin(isDev$javalin == null ? JavalinVue.isDevFunction.invoke(ctx) : isDev$javalin);
        JavalinVue javalinVue2 = JavalinVue.INSTANCE;
        Path rootDirectory$javalin = JavalinVue.INSTANCE.getRootDirectory$javalin();
        javalinVue2.setRootDirectory$javalin(rootDirectory$javalin == null ? PathMaster.INSTANCE.defaultLocation(JavalinVue.INSTANCE.isDev$javalin()) : rootDirectory$javalin);
        String routeComponent = StringsKt.startsWith$default(this.componentId, "<", false, 2, (Object) null) ? this.componentId : '<' + this.componentId + "></" + this.componentId + '>';
        Set allFiles = Intrinsics.areEqual((Object) JavalinVue.INSTANCE.isDev$javalin(), (Object) true) ? JavalinVue.INSTANCE.walkPaths() : JavalinVue.INSTANCE.getCachedPaths$javalin();
        Lazy resolver$delegate = LazyKt.lazy(new Function0<VueDependencyResolver>(allFiles) { // from class: io.javalin.plugin.rendering.vue.VueHandler$handle$resolver$2
            final /* synthetic */ Set<Path> $allFiles;

            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Set<? extends java.nio.file.Path> */
            /* JADX WARN: Multi-variable type inference failed */
            /* access modifiers changed from: package-private */
            {
                this.$allFiles = r4;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VueDependencyResolver invoke() {
                return Intrinsics.areEqual((Object) JavalinVue.INSTANCE.isDev$javalin(), (Object) true) ? new VueDependencyResolver(this.$allFiles, JavalinVue.INSTANCE.getVueAppName$javalin()) : JavalinVue.INSTANCE.getCachedDependencyResolver$javalin();
            }
        });
        String $this$takeWhile$iv = StringsKt.removePrefix(routeComponent, (CharSequence) "<");
        int index$iv = 0;
        int length = $this$takeWhile$iv.length();
        while (true) {
            if (index$iv >= length) {
                componentId = $this$takeWhile$iv;
                break;
            }
            if (!(!SetsKt.setOf((Object[]) new Character[]{'>', ' '}).contains(Character.valueOf($this$takeWhile$iv.charAt(index$iv))))) {
                componentId = $this$takeWhile$iv.substring(0, index$iv);
                Intrinsics.checkNotNullExpressionValue(componentId, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                break;
            }
            index$iv++;
        }
        if (JavalinVue.optimizeDependencies) {
            dependencies = m5902handle$lambda0(resolver$delegate).resolve(componentId);
        } else {
            dependencies = VueHandlerKt.joinVueFiles(allFiles);
        }
        Intrinsics.checkNotNullExpressionValue(dependencies, "dependencies");
        if (!StringsKt.contains$default((CharSequence) dependencies, (CharSequence) componentId, false, 2, (Object) null)) {
            throw new InternalServerErrorResponse(Intrinsics.stringPlus("Route component not found: ", routeComponent), null, 2, null);
        }
        FileInliner fileInliner = FileInliner.INSTANCE;
        Iterator it = allFiles.iterator();
        while (true) {
            if (!it.hasNext()) {
                path = null;
                break;
            }
            Object next = it.next();
            if (((Path) next).endsWith("vue/layout.html")) {
                path = next;
                break;
            }
        }
        Intrinsics.checkNotNull(path);
        String preRenderHook = preRenderHook(VueHandlerKt.readText(path), ctx);
        Set $this$filterNot$iv = allFiles;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterNot$iv) {
            if (!VueHandlerKt.isVueFile((Path) element$iv$iv)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        ctx.html(postRenderHook(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(fileInliner.inlineFiles(preRenderHook, (List) destination$iv$iv), "@componentRegistration", "@loadableData@componentRegistration@serverState", false, 4, (Object) null), "@loadableData", LoadableData.loadableDataScript, false, 4, (Object) null), "@componentRegistration", dependencies, false, 4, (Object) null), "@serverState", VueHandlerKt.getState(ctx, state(ctx)), false, 4, (Object) null), "@routeComponent", routeComponent, false, 4, (Object) null), "@cdnWebjar/", Intrinsics.areEqual((Object) JavalinVue.INSTANCE.isDev$javalin(), (Object) true) ? "/webjars/" : "https://cdn.jsdelivr.net/webjars/org.webjars.npm/", false, 4, (Object) null), ctx)).header("Cache-Control", JavalinVue.cacheControl);
    }

    /* renamed from: handle$lambda-0  reason: not valid java name */
    private static final VueDependencyResolver m5902handle$lambda0(Lazy<? extends VueDependencyResolver> lazy) {
        return (VueDependencyResolver) lazy.getValue();
    }

    private final String preRenderHook(String $this$preRenderHook, Context ctx) {
        return preRender($this$preRenderHook, ctx);
    }

    private final String postRenderHook(String $this$postRenderHook, Context ctx) {
        return postRender($this$postRenderHook, ctx);
    }
}
