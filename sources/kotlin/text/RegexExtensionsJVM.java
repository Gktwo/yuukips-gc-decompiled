package kotlin.text;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��\f\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\u001a\r\u0010��\u001a\u00020\u0001*\u00020\u0002H\b¨\u0006\u0003"}, m373d2 = {"toRegex", "Lkotlin/text/Regex;", "Ljava/util/regex/Pattern;", "kotlin-stdlib"}, m368xs = "kotlin/text/StringsKt")
/* renamed from: kotlin.text.StringsKt__RegexExtensionsJVMKt */
/* loaded from: grasscutter.jar:kotlin/text/StringsKt__RegexExtensionsJVMKt.class */
class RegexExtensionsJVM extends Indent {
    @InlineOnly
    private static final Regex toRegex(Pattern $this$toRegex) {
        Intrinsics.checkNotNullParameter($this$toRegex, "<this>");
        return new Regex($this$toRegex);
    }
}
