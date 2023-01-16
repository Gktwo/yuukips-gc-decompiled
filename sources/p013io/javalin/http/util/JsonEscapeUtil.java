package p013io.javalin.http.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: JsonEscapeUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, m373d2 = {"Lio/javalin/http/util/JsonEscapeUtil;", "", "()V", "escape", "", "str", "javalin"})
/* renamed from: io.javalin.http.util.JsonEscapeUtil */
/* loaded from: grasscutter.jar:io/javalin/http/util/JsonEscapeUtil.class */
public final class JsonEscapeUtil {
    @NotNull
    public static final JsonEscapeUtil INSTANCE = new JsonEscapeUtil();

    private JsonEscapeUtil() {
    }

    @NotNull
    public final String escape(@NotNull String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "str");
        StringBuilder builder = new StringBuilder(str.length());
        int i = 0;
        int length = str.length();
        while (i < length) {
            char ch = str.charAt(i);
            i++;
            if (ch == '\"') {
                str2 = "\\\"";
            } else if (ch == '\n') {
                str2 = "\\n";
            } else if (ch == '\r') {
                str2 = "\\r";
            } else if (ch == '\\') {
                str2 = "\\\\";
            } else if (ch == '\t') {
                str2 = "\\t";
            } else {
                str2 = ch == '\b' ? "\\b" : Character.valueOf(ch);
            }
            builder.append(str2);
        }
        String sb = builder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "builder.toString()");
        return sb;
    }
}
