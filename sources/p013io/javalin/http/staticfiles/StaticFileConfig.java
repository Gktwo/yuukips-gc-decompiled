package p013io.javalin.http.staticfiles;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: StaticFileConfig.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��>\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010$\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018��2\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u000eHÆ\u0003Ji\u0010\u0018\u001a\u00020��2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u000eHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\r\u0010\u001d\u001a\u00020\u0003H��¢\u0006\u0002\b\u001eJ\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u001e\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f8\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u001e\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u000e8\u0006@\u0006X\u000e¢\u0006\u0002\n��¨\u0006 "}, m373d2 = {"Lio/javalin/http/staticfiles/StaticFileConfig;", "", "hostedPath", "", "directory", "location", "Lio/javalin/http/staticfiles/Location;", "precompress", "", "aliasCheck", "Lorg/eclipse/jetty/server/handler/ContextHandler$AliasCheck;", "headers", "", "skipFileFunction", "Lkotlin/Function1;", "Ljavax/servlet/http/HttpServletRequest;", "(Ljava/lang/String;Ljava/lang/String;Lio/javalin/http/staticfiles/Location;ZLorg/eclipse/jetty/server/handler/ContextHandler$AliasCheck;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "refinedToString", "refinedToString$javalin", Printer.TO_STRING, "javalin"})
/* renamed from: io.javalin.http.staticfiles.StaticFileConfig */
/* loaded from: grasscutter.jar:io/javalin/http/staticfiles/StaticFileConfig.class */
public final class StaticFileConfig {
    @JvmField
    @NotNull
    public String hostedPath;
    @JvmField
    @NotNull
    public String directory;
    @JvmField
    @NotNull
    public Location location;
    @JvmField
    public boolean precompress;
    @JvmField
    @Nullable
    public ContextHandler.AliasCheck aliasCheck;
    @JvmField
    @NotNull
    public Map<String, String> headers;
    @JvmField
    @NotNull
    public Function1<? super HttpServletRequest, Boolean> skipFileFunction;

    @NotNull
    public final String component1() {
        return this.hostedPath;
    }

    @NotNull
    public final String component2() {
        return this.directory;
    }

    @NotNull
    public final Location component3() {
        return this.location;
    }

    public final boolean component4() {
        return this.precompress;
    }

    @Nullable
    public final ContextHandler.AliasCheck component5() {
        return this.aliasCheck;
    }

    @NotNull
    public final Map<String, String> component6() {
        return this.headers;
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super javax.servlet.http.HttpServletRequest, java.lang.Boolean>, kotlin.jvm.functions.Function1<javax.servlet.http.HttpServletRequest, java.lang.Boolean> */
    @NotNull
    public final Function1<HttpServletRequest, Boolean> component7() {
        return this.skipFileFunction;
    }

    @NotNull
    public final StaticFileConfig copy(@NotNull String hostedPath, @NotNull String directory, @NotNull Location location, boolean precompress, @Nullable ContextHandler.AliasCheck aliasCheck, @NotNull Map<String, String> map, @NotNull Function1<? super HttpServletRequest, Boolean> function1) {
        Intrinsics.checkNotNullParameter(hostedPath, "hostedPath");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(function1, "skipFileFunction");
        return new StaticFileConfig(hostedPath, directory, location, precompress, aliasCheck, map, function1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: io.javalin.http.staticfiles.StaticFileConfig */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StaticFileConfig copy$default(StaticFileConfig staticFileConfig, String str, String str2, Location location, boolean z, ContextHandler.AliasCheck aliasCheck, Map map, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = staticFileConfig.hostedPath;
        }
        if ((i & 2) != 0) {
            str2 = staticFileConfig.directory;
        }
        if ((i & 4) != 0) {
            location = staticFileConfig.location;
        }
        if ((i & 8) != 0) {
            z = staticFileConfig.precompress;
        }
        if ((i & 16) != 0) {
            aliasCheck = staticFileConfig.aliasCheck;
        }
        if ((i & 32) != 0) {
            map = staticFileConfig.headers;
        }
        if ((i & 64) != 0) {
            function1 = staticFileConfig.skipFileFunction;
        }
        return staticFileConfig.copy(str, str2, location, z, aliasCheck, map, function1);
    }

    @NotNull
    public String toString() {
        return "StaticFileConfig(hostedPath=" + this.hostedPath + ", directory=" + this.directory + ", location=" + this.location + ", precompress=" + this.precompress + ", aliasCheck=" + this.aliasCheck + ", headers=" + this.headers + ", skipFileFunction=" + this.skipFileFunction + ')';
    }

    public int hashCode() {
        int hashCode = ((((this.hostedPath.hashCode() * 31) + this.directory.hashCode()) * 31) + this.location.hashCode()) * 31;
        boolean z = this.precompress;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return ((((((hashCode + i) * 31) + (this.aliasCheck == null ? 0 : this.aliasCheck.hashCode())) * 31) + this.headers.hashCode()) * 31) + this.skipFileFunction.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StaticFileConfig)) {
            return false;
        }
        StaticFileConfig staticFileConfig = (StaticFileConfig) other;
        return Intrinsics.areEqual(this.hostedPath, staticFileConfig.hostedPath) && Intrinsics.areEqual(this.directory, staticFileConfig.directory) && this.location == staticFileConfig.location && this.precompress == staticFileConfig.precompress && Intrinsics.areEqual(this.aliasCheck, staticFileConfig.aliasCheck) && Intrinsics.areEqual(this.headers, staticFileConfig.headers) && Intrinsics.areEqual(this.skipFileFunction, staticFileConfig.skipFileFunction);
    }

    public StaticFileConfig() {
        this(null, null, null, false, null, null, null, 127, null);
    }

    public StaticFileConfig(@NotNull String hostedPath, @NotNull String directory, @NotNull Location location, boolean precompress, @Nullable ContextHandler.AliasCheck aliasCheck, @NotNull Map<String, String> map, @NotNull Function1<? super HttpServletRequest, Boolean> function1) {
        Intrinsics.checkNotNullParameter(hostedPath, "hostedPath");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(function1, "skipFileFunction");
        this.hostedPath = hostedPath;
        this.directory = directory;
        this.location = location;
        this.precompress = precompress;
        this.aliasCheck = aliasCheck;
        this.headers = map;
        this.skipFileFunction = function1;
    }

    public /* synthetic */ StaticFileConfig(String str, String str2, Location location, boolean z, ContextHandler.AliasCheck aliasCheck, Map map, C27481 r16, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "/" : str, (i & 2) != 0 ? "/public" : str2, (i & 4) != 0 ? Location.CLASSPATH : location, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : aliasCheck, (i & 32) != 0 ? MapsKt.mutableMapOf(Tuples.m366to("Cache-Control", "max-age=0")) : map, (i & 64) != 0 ? C27481.INSTANCE : r16);
    }

    @NotNull
    public final String refinedToString$javalin() {
        return StringsKt.replace$default(toString(), ", skipFileFunction=(javax.servlet.http.HttpServletRequest) -> kotlin.Boolean", "", false, 4, (Object) null);
    }
}
