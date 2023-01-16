package p013io.javalin.core.routing;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.core.routing.PathSegment;

@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��2\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\"\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aB\u0010��\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000bH��\u001aP\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000bH��\u001a\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0006H��¨\u0006\u0012"}, m373d2 = {"constructRegex", "Lkotlin/text/Regex;", "segments", "", "Lio/javalin/core/routing/PathSegment;", "regexSuffix", "", "regexOptions", "", "Lkotlin/text/RegexOption;", "mapper", "Lkotlin/Function1;", "constructRegexList", "matchEverySubPath", "", "values", "regex", "url", "javalin"})
/* renamed from: io.javalin.core.routing.RoutingRegexesKt */
/* loaded from: grasscutter.jar:io/javalin/core/routing/RoutingRegexesKt.class */
public final class RoutingRegexes {
    public static /* synthetic */ List constructRegexList$default(boolean z, List list, String str, Set set, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            set = SetsKt.emptySet();
        }
        return constructRegexList(z, list, str, set, function1);
    }

    private static final List<Regex> constructRegexList$addRegexForExtraWildcard(boolean $matchEverySubPath, List<? extends PathSegment> list, String $regexSuffix, Set<? extends RegexOption> set, Function1<? super PathSegment, String> function1) {
        if ($matchEverySubPath) {
            return CollectionsKt.listOf(constructRegex(CollectionsKt.plus((Collection<? extends PathSegment.Wildcard>) list, PathSegment.Wildcard.INSTANCE), $regexSuffix, set, function1));
        }
        return CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Regex> constructRegexList(boolean matchEverySubPath, @NotNull List<? extends PathSegment> list, @NotNull String regexSuffix, @NotNull Set<? extends RegexOption> set, @NotNull Function1<? super PathSegment, String> function1) {
        Intrinsics.checkNotNullParameter(list, "segments");
        Intrinsics.checkNotNullParameter(regexSuffix, "regexSuffix");
        Intrinsics.checkNotNullParameter(set, "regexOptions");
        Intrinsics.checkNotNullParameter(function1, "mapper");
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(constructRegex(list, regexSuffix, set, function1)), (Iterable) constructRegexList$addRegexForExtraWildcard(matchEverySubPath, list, regexSuffix, set, function1));
    }

    public static /* synthetic */ Regex constructRegex$default(List list, String str, Set set, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            set = SetsKt.emptySet();
        }
        return constructRegex(list, str, set, function1);
    }

    @NotNull
    public static final Regex constructRegex(@NotNull List<? extends PathSegment> list, @NotNull String regexSuffix, @NotNull Set<? extends RegexOption> set, @NotNull Function1<? super PathSegment, String> function1) {
        Intrinsics.checkNotNullParameter(list, "segments");
        Intrinsics.checkNotNullParameter(regexSuffix, "regexSuffix");
        Intrinsics.checkNotNullParameter(set, "regexOptions");
        Intrinsics.checkNotNullParameter(function1, "mapper");
        String str = "^/" + CollectionsKt.joinToString$default(list, "/", null, null, 0, null, function1, 30, null) + regexSuffix + "$";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().apply(builderAction).toString()");
        return new Regex(str, set);
    }

    @NotNull
    public static final List<String> values(@NotNull Regex regex, @NotNull String url) {
        List<String> list;
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(url, "url");
        MatchResult matchEntire = regex.matchEntire(url);
        if (matchEntire == null) {
            list = null;
        } else {
            List<String> groupValues = matchEntire.getGroupValues();
            list = groupValues == null ? null : CollectionsKt.drop(groupValues, 1);
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }
}
