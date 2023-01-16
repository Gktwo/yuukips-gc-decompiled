package p013io.javalin.plugin.rendering.markdown;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.commonmark.parser.Parser;

@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\b\n��\n\u0002\u0018\u0002\n��\u0010��\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, m373d2 = {"<anonymous>", "Lorg/commonmark/parser/Parser;", "kotlin.jvm.PlatformType"})
/* renamed from: io.javalin.plugin.rendering.markdown.JavalinCommonmark$defaultParser$2 */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/markdown/JavalinCommonmark$defaultParser$2.class */
final class Commonmark extends Lambda implements Function0<Parser> {
    public static final Commonmark INSTANCE = new Commonmark();

    Commonmark() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Parser invoke() {
        return Parser.builder().build();
    }
}
