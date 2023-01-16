package p013io.javalin.plugin.rendering.vue;

import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jdk7.AutoCloseable;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.http.Context;

/* compiled from: JavalinVue.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��`\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\"\u001a\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0007J\u0016\u0010-\u001a\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u00020705H\u0007J\f\u00108\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u001b\u0010\u0005\u001a\u00020\u00068@X\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8@X\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00120\u00198\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u0012\u0010\u001b\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u001e\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001dX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n��\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u001a\u0010(\u001a\u00020\u0004X\u000e¢\u0006\u000e\n��\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n��\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00069"}, m373d2 = {"Lio/javalin/plugin/rendering/vue/JavalinVue;", "", "()V", "cacheControl", "", "cachedDependencyResolver", "Lio/javalin/plugin/rendering/vue/VueDependencyResolver;", "getCachedDependencyResolver$javalin", "()Lio/javalin/plugin/rendering/vue/VueDependencyResolver;", "cachedDependencyResolver$delegate", "Lkotlin/Lazy;", "cachedPaths", "", "Ljava/nio/file/Path;", "getCachedPaths$javalin", "()Ljava/util/Set;", "cachedPaths$delegate", "isDev", "", "isDev$javalin", "()Ljava/lang/Boolean;", "setDev$javalin", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isDevFunction", "Lkotlin/Function1;", "Lio/javalin/http/Context;", "optimizeDependencies", "resourcesJarClass", "Ljava/lang/Class;", "getResourcesJarClass$javalin", "()Ljava/lang/Class;", "setResourcesJarClass$javalin", "(Ljava/lang/Class;)V", "rootDirectory", "getRootDirectory$javalin", "()Ljava/nio/file/Path;", "setRootDirectory$javalin", "(Ljava/nio/file/Path;)V", "stateFunction", "vueAppName", "getVueAppName$javalin", "()Ljava/lang/String;", "setVueAppName$javalin", "(Ljava/lang/String;)V", "vueVersion", "Lio/javalin/plugin/rendering/vue/VueVersion;", "getVueVersion$javalin", "()Lio/javalin/plugin/rendering/vue/VueVersion;", "setVueVersion$javalin", "(Lio/javalin/plugin/rendering/vue/VueVersion;)V", "", "config", "Ljava/util/function/Consumer;", "Lio/javalin/plugin/rendering/vue/VueDirConfig;", "Lio/javalin/plugin/rendering/vue/VueVersionConfig;", "walkPaths", "javalin"})
/* renamed from: io.javalin.plugin.rendering.vue.JavalinVue */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/vue/JavalinVue.class */
public final class JavalinVue {
    @Nullable
    private static Path rootDirectory;
    @Nullable
    private static Boolean isDev;
    @NotNull
    public static final JavalinVue INSTANCE = new JavalinVue();
    @NotNull
    private static Class<?> resourcesJarClass = PathMaster.class;
    @NotNull
    private static VueVersion vueVersion = VueVersion.VUE_2;
    @NotNull
    private static String vueAppName = "Vue";
    @JvmField
    @NotNull
    public static Function1<? super Context, Boolean> isDevFunction = JavalinVue$isDevFunction$1.INSTANCE;
    @JvmField
    public static boolean optimizeDependencies = true;
    @JvmField
    @NotNull
    public static Function1<? super Context, ? extends Object> stateFunction = JavalinVue$stateFunction$1.INSTANCE;
    @JvmField
    @NotNull
    public static String cacheControl = "no-cache, no-store, must-revalidate";
    @NotNull
    private static final Lazy cachedPaths$delegate = LazyKt.lazy(JavalinVue$cachedPaths$2.INSTANCE);
    @NotNull
    private static final Lazy cachedDependencyResolver$delegate = LazyKt.lazy(JavalinVue$cachedDependencyResolver$2.INSTANCE);

    private JavalinVue() {
    }

    @NotNull
    public final Class<?> getResourcesJarClass$javalin() {
        return resourcesJarClass;
    }

    public final void setResourcesJarClass$javalin(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<set-?>");
        resourcesJarClass = cls;
    }

    @Nullable
    public final Path getRootDirectory$javalin() {
        return rootDirectory;
    }

    public final void setRootDirectory$javalin(@Nullable Path path) {
        rootDirectory = path;
    }

    @JvmStatic
    public static final void rootDirectory(@NotNull Consumer<VueDirConfig> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "config");
        consumer.accept(new VueDirConfig());
    }

    @NotNull
    public final VueVersion getVueVersion$javalin() {
        return vueVersion;
    }

    public final void setVueVersion$javalin(@NotNull VueVersion vueVersion2) {
        Intrinsics.checkNotNullParameter(vueVersion2, "<set-?>");
        vueVersion = vueVersion2;
    }

    @NotNull
    public final String getVueAppName$javalin() {
        return vueAppName;
    }

    public final void setVueAppName$javalin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        vueAppName = str;
    }

    @JvmStatic
    public static final void vueVersion(@NotNull Consumer<VueVersionConfig> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "config");
        consumer.accept(new VueVersionConfig());
    }

    @Nullable
    public final Boolean isDev$javalin() {
        return isDev;
    }

    public final void setDev$javalin(@Nullable Boolean bool) {
        isDev = bool;
    }

    @NotNull
    public final Set<Path> walkPaths() {
        Stream it = Files.walk(rootDirectory, 20, new FileVisitOption[0]);
        Throwable th = null;
        try {
            Set<Path> set = (Set) it.collect(Collectors.toSet());
            AutoCloseable.closeFinally(it, th);
            Intrinsics.checkNotNullExpressionValue(set, "walk(rootDirectory, 20).…ect(Collectors.toSet()) }");
            return set;
        } catch (Throwable th2) {
            AutoCloseable.closeFinally(it, th);
            throw th2;
        }
    }

    @NotNull
    public final Set<Path> getCachedPaths$javalin() {
        return (Set) cachedPaths$delegate.getValue();
    }

    @NotNull
    public final VueDependencyResolver getCachedDependencyResolver$javalin() {
        return (VueDependencyResolver) cachedDependencyResolver$delegate.getValue();
    }
}
