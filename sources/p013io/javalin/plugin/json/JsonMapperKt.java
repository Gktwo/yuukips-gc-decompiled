package p013io.javalin.plugin.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.Javalin;
import p013io.javalin.http.Context;

/* compiled from: JsonMapper.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��\u0016\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0005\"\u000e\u0010��\u001a\u00020\u0001XT¢\u0006\u0002\n��¨\u0006\u0006"}, m373d2 = {"JSON_MAPPER_KEY", "", "jsonMapper", "Lio/javalin/plugin/json/JsonMapper;", "Lio/javalin/Javalin;", "Lio/javalin/http/Context;", "javalin"})
/* renamed from: io.javalin.plugin.json.JsonMapperKt */
/* loaded from: grasscutter.jar:io/javalin/plugin/json/JsonMapperKt.class */
public final class JsonMapperKt {
    @NotNull
    public static final String JSON_MAPPER_KEY = "global-json-mapper";

    @NotNull
    public static final JsonMapper jsonMapper(@NotNull Javalin $this$jsonMapper) {
        Intrinsics.checkNotNullParameter($this$jsonMapper, "<this>");
        Object attribute = $this$jsonMapper.attribute(JSON_MAPPER_KEY);
        Intrinsics.checkNotNullExpressionValue(attribute, "this.attribute(JSON_MAPPER_KEY)");
        return (JsonMapper) attribute;
    }

    @NotNull
    public static final JsonMapper jsonMapper(@NotNull Context $this$jsonMapper) {
        Intrinsics.checkNotNullParameter($this$jsonMapper, "<this>");
        return (JsonMapper) $this$jsonMapper.appAttribute(JSON_MAPPER_KEY);
    }
}
