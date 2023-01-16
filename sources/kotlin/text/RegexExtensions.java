package kotlin.text;

import java.util.Set;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��\u0018\n��\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010��\u001a\u00020\u0001*\u00020\u0002H\b\u001a\u001b\u0010��\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\b\u001a\u0015\u0010��\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\b¨\u0006\u0007"}, m373d2 = {"toRegex", "Lkotlin/text/Regex;", "", "options", "", "Lkotlin/text/RegexOption;", "option", "kotlin-stdlib"}, m368xs = "kotlin/text/StringsKt")
/* renamed from: kotlin.text.StringsKt__RegexExtensionsKt */
/* loaded from: grasscutter.jar:kotlin/text/StringsKt__RegexExtensionsKt.class */
class RegexExtensions extends RegexExtensionsJVM {
    @InlineOnly
    private static final Regex toRegex(String $this$toRegex) {
        Intrinsics.checkNotNullParameter($this$toRegex, "<this>");
        return new Regex($this$toRegex);
    }

    @InlineOnly
    private static final Regex toRegex(String $this$toRegex, RegexOption option) {
        Intrinsics.checkNotNullParameter($this$toRegex, "<this>");
        Intrinsics.checkNotNullParameter(option, "option");
        return new Regex($this$toRegex, option);
    }

    @InlineOnly
    private static final Regex toRegex(String $this$toRegex, Set<? extends RegexOption> set) {
        Intrinsics.checkNotNullParameter($this$toRegex, "<this>");
        Intrinsics.checkNotNullParameter(set, "options");
        return new Regex($this$toRegex, set);
    }
}
