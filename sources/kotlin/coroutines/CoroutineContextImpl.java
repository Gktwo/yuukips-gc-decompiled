package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48, m374d1 = {"��\u0010\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m373d2 = {"<anonymous>", "", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
/* renamed from: kotlin.coroutines.CombinedContext$toString$1 */
/* loaded from: grasscutter.jar:kotlin/coroutines/CombinedContext$toString$1.class */
final class CoroutineContextImpl extends Lambda implements Function2<String, CoroutineContext.Element, String> {
    public static final CoroutineContextImpl INSTANCE = new CoroutineContextImpl();

    CoroutineContextImpl() {
        super(2);
    }

    @NotNull
    public final String invoke(@NotNull String acc, @NotNull CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(acc, "acc");
        Intrinsics.checkNotNullParameter(element, "element");
        return acc.length() == 0 ? element.toString() : acc + ", " + element;
    }
}
