package p013io.javalin.plugin.rendering.vue;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Configs.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001a\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m373d2 = {"Lio/javalin/plugin/rendering/vue/VueVersionConfig;", "", "()V", "vue2", "", "vue3", "appName", "", "javalin"})
/* renamed from: io.javalin.plugin.rendering.vue.VueVersionConfig */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/vue/VueVersionConfig.class */
public final class VueVersionConfig {
    public final void vue2() {
        JavalinVue.INSTANCE.setVueVersion$javalin(VueVersion.VUE_2);
        JavalinVue.INSTANCE.setVueAppName$javalin("Vue");
    }

    public final void vue3(@NotNull String appName) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        JavalinVue.INSTANCE.setVueVersion$javalin(VueVersion.VUE_3);
        JavalinVue.INSTANCE.setVueAppName$javalin(appName);
    }
}
