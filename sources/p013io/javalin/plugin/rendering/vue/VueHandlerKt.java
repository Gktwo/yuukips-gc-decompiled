package p013io.javalin.plugin.rendering.vue;

import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Tuples;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.builtins.TTop;
import org.slf4j.Marker;
import p013io.javalin.http.Context;
import p013io.javalin.plugin.json.JsonMapper;
import p013io.javalin.plugin.json.JsonMapperKt;

/* compiled from: VueHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��(\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010��\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n��\n\u0002\u0010\"\n\u0002\b\u0002\u001a\u001a\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H��\u001a\b\u0010\u0006\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0002\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH��\u001a\u0012\u0010\f\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u000b0\rH\u0002\u001a\f\u0010\u000e\u001a\u00020\u0001*\u00020\u000bH��¨\u0006\u000f"}, m373d2 = {"getState", "", "ctx", "Lio/javalin/http/Context;", TTop.STAT_STATE, "", "prototypeOrGlobalConfig", "urlEncodeForJavascript", "string", "isVueFile", "", "Ljava/nio/file/Path;", "joinVueFiles", "", "readText", "javalin"})
/* renamed from: io.javalin.plugin.rendering.vue.VueHandlerKt */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/vue/VueHandlerKt.class */
public final class VueHandlerKt {
    /* access modifiers changed from: private */
    public static final String joinVueFiles(Set<? extends Path> $this$filter$iv) {
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (isVueFile((Path) element$iv$iv)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv, "", null, null, 0, null, VueHandlerKt$joinVueFiles$2.INSTANCE, 30, null);
    }

    @NotNull
    public static final String getState(@NotNull Context ctx, @Nullable Object state) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        StringBuilder append = new StringBuilder().append("\n<script>\n").append(prototypeOrGlobalConfig()).append(".$javalin = JSON.parse(decodeURIComponent(\"");
        JsonMapper jsonMapper = JsonMapperKt.jsonMapper(ctx);
        Pair[] pairArr = new Pair[2];
        pairArr[0] = Tuples.m366to("pathParams", ctx.pathParamMap());
        pairArr[1] = Tuples.m366to(TTop.STAT_STATE, state == null ? JavalinVue.stateFunction.invoke(ctx) : state);
        String jsonString = jsonMapper.toJsonString(MapsKt.mapOf(pairArr));
        Intrinsics.checkNotNullExpressionValue(jsonString, "ctx.jsonMapper().toJsonS…      )\n                )");
        return append.append(urlEncodeForJavascript(jsonString)).append("\"))\n</script>\n").toString();
    }

    private static final String urlEncodeForJavascript(String string) {
        String encode = URLEncoder.encode(string, Charsets.UTF_8.name());
        Intrinsics.checkNotNullExpressionValue(encode, "encode(string, Charsets.UTF_8.name())");
        return StringsKt.replace$default(encode, Marker.ANY_NON_NULL_MARKER, "%20", false, 4, (Object) null);
    }

    private static final String prototypeOrGlobalConfig() {
        return JavalinVue.INSTANCE.getVueVersion$javalin() == VueVersion.VUE_3 ? Intrinsics.stringPlus(JavalinVue.INSTANCE.getVueAppName$javalin(), ".config.globalProperties") : Intrinsics.stringPlus(JavalinVue.INSTANCE.getVueAppName$javalin(), ".prototype");
    }

    @NotNull
    public static final String readText(@NotNull Path $this$readText) {
        Intrinsics.checkNotNullParameter($this$readText, "<this>");
        byte[] readAllBytes = Files.readAllBytes($this$readText);
        Intrinsics.checkNotNullExpressionValue(readAllBytes, "readAllBytes(this)");
        return new String(readAllBytes, Charsets.UTF_8);
    }

    public static final boolean isVueFile(@NotNull Path $this$isVueFile) {
        Intrinsics.checkNotNullParameter($this$isVueFile, "<this>");
        return StringsKt.endsWith$default($this$isVueFile.toString(), ".vue", false, 2, (Object) null);
    }
}
