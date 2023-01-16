package p013io.javalin.core.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.Javalin;
import p013io.javalin.core.plugin.Plugin;
import p013io.javalin.http.util.CorsBeforeHandler;

/* compiled from: CorsPlugin.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018�� \n2\u00020\u0001:\u0001\nB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n��¨\u0006\u000b"}, m373d2 = {"Lio/javalin/core/util/CorsPlugin;", "Lio/javalin/core/plugin/Plugin;", "origins", "", "", "(Ljava/util/List;)V", "apply", "", "app", "Lio/javalin/Javalin;", "Companion", "javalin"})
/* renamed from: io.javalin.core.util.CorsPlugin */
/* loaded from: grasscutter.jar:io/javalin/core/util/CorsPlugin.class */
public final class CorsPlugin implements Plugin {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<String> origins;

    @JvmStatic
    @NotNull
    public static final CorsPlugin forOrigins(@NotNull String... origins) {
        return Companion.forOrigins(origins);
    }

    @JvmStatic
    @NotNull
    public static final CorsPlugin forAllOrigins() {
        return Companion.forAllOrigins();
    }

    public CorsPlugin(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "origins");
        this.origins = list;
    }

    @Override // p013io.javalin.core.plugin.Plugin
    public void apply(@NotNull Javalin app) {
        Intrinsics.checkNotNullParameter(app, "app");
        if (this.origins.isEmpty()) {
            throw new IllegalArgumentException("Origins cannot be empty.");
        }
        app.before(new CorsBeforeHandler(this.origins));
    }

    /* compiled from: CorsPlugin.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J!\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, m373d2 = {"Lio/javalin/core/util/CorsPlugin$Companion;", "", "()V", "forAllOrigins", "Lio/javalin/core/util/CorsPlugin;", "forOrigins", "origins", "", "", "([Ljava/lang/String;)Lio/javalin/core/util/CorsPlugin;", "javalin"})
    /* renamed from: io.javalin.core.util.CorsPlugin$Companion */
    /* loaded from: grasscutter.jar:io/javalin/core/util/CorsPlugin$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final CorsPlugin forOrigins(@NotNull String... origins) {
            Intrinsics.checkNotNullParameter(origins, "origins");
            return new CorsPlugin(ArraysKt.toList(origins));
        }

        @JvmStatic
        @NotNull
        public final CorsPlugin forAllOrigins() {
            return new CorsPlugin(CollectionsKt.listOf("*"));
        }
    }
}
