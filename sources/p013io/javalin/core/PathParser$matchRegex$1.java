package p013io.javalin.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.core.routing.PathSegment;

/* compiled from: PathParser.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\f\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m373d2 = {"<anonymous>", "", "it", "Lio/javalin/core/routing/PathSegment;"})
/* renamed from: io.javalin.core.PathParser$matchRegex$1 */
/* loaded from: grasscutter.jar:io/javalin/core/PathParser$matchRegex$1.class */
final class PathParser$matchRegex$1 extends Lambda implements Function1<PathSegment, String> {
    public static final PathParser$matchRegex$1 INSTANCE = new PathParser$matchRegex$1();

    PathParser$matchRegex$1() {
        super(1);
    }

    @NotNull
    public final String invoke(@NotNull PathSegment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.asRegexString$javalin();
    }
}
