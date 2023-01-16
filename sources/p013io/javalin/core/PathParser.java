package p013io.javalin.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.core.routing.ParameterNamesNotUniqueException;
import p013io.javalin.core.routing.ParserStateKt;
import p013io.javalin.core.routing.PathSegment;
import p013io.javalin.core.routing.PathSegmentKt;
import p013io.javalin.core.routing.RoutingRegexes;
import p013io.javalin.http.util.ContextUtil;

/* compiled from: PathParser.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u0003J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0003R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n��R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n��\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n��R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0010\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t¢\u0006\b\n��\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u0018"}, m373d2 = {"Lio/javalin/core/PathParser;", "", "rawPath", "", "ignoreTrailingSlashes", "", "(Ljava/lang/String;Z)V", "matchPathAndEverySubPath", "matchRegex", "", "Lkotlin/text/Regex;", "path", "pathParamNames", "getPathParamNames", "()Ljava/util/List;", "pathParamRegex", "regexSuffix", "segments", "Lio/javalin/core/routing/PathSegment;", "getSegments", "extractPathParams", "", "url", "matches", "javalin"})
/* renamed from: io.javalin.core.PathParser */
/* loaded from: grasscutter.jar:io/javalin/core/PathParser.class */
public final class PathParser {
    @NotNull
    private final String rawPath;
    private final boolean matchPathAndEverySubPath;
    @NotNull
    private final String path;
    @NotNull
    private final List<PathSegment> segments;
    @NotNull
    private final List<String> pathParamNames;
    @NotNull
    private final String regexSuffix;
    @NotNull
    private final List<Regex> matchRegex;
    @NotNull
    private final List<Regex> pathParamRegex;

    public PathParser(@NotNull String rawPath, boolean ignoreTrailingSlashes) {
        String str;
        Intrinsics.checkNotNullParameter(rawPath, "rawPath");
        this.rawPath = rawPath;
        if (StringsKt.contains$default((CharSequence) this.rawPath, (CharSequence) "/:", false, 2, (Object) null)) {
            throw new IllegalArgumentException("Path '" + this.rawPath + "' invalid - Javalin 4 switched from ':param' to '{param}'.");
        }
        this.matchPathAndEverySubPath = StringsKt.endsWith$default(this.rawPath, ">*", false, 2, (Object) null) || StringsKt.endsWith$default(this.rawPath, "}*", false, 2, (Object) null);
        this.path = this.matchPathAndEverySubPath ? StringsKt.removeSuffix(this.rawPath, (CharSequence) "*") : this.rawPath;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : StringsKt.split$default((CharSequence) this.path, new String[]{"/"}, false, 0, 6, (Object) null)) {
            if (((String) element$iv$iv).length() > 0) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable<String> $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (String segment : $this$map$iv) {
            destination$iv$iv2.add(ParserStateKt.convertSegment(segment, this.rawPath));
        }
        this.segments = (List) destination$iv$iv2;
        Iterable<PathSegment> $this$map$iv2 = this.segments;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (PathSegment it : $this$map$iv2) {
            destination$iv$iv3.add(PathSegmentKt.pathParamNames(it));
        }
        List list = CollectionsKt.flatten((List) destination$iv$iv3);
        if (CollectionsKt.toSet(list).size() != list.size()) {
            throw new ParameterNamesNotUniqueException(this.rawPath);
        }
        Unit unit = Unit.INSTANCE;
        this.pathParamNames = list;
        if (ignoreTrailingSlashes) {
            str = "/?";
        } else {
            str = StringsKt.endsWith$default(this.rawPath, "/", false, 2, (Object) null) ? "/" : "";
        }
        this.regexSuffix = str;
        this.matchRegex = RoutingRegexes.constructRegexList$default(this.matchPathAndEverySubPath, this.segments, this.regexSuffix, null, PathParser$matchRegex$1.INSTANCE, 8, null);
        this.pathParamRegex = RoutingRegexes.constructRegexList$default(this.matchPathAndEverySubPath, this.segments, this.regexSuffix, null, PathParser$pathParamRegex$1.INSTANCE, 8, null);
    }

    @NotNull
    public final List<PathSegment> getSegments() {
        return this.segments;
    }

    @NotNull
    public final List<String> getPathParamNames() {
        return this.pathParamNames;
    }

    public final boolean matches(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Iterable<Regex> $this$any$iv = this.matchRegex;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Regex it : $this$any$iv) {
            if (it.matches(url)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final Map<String, String> extractPathParams(@NotNull String url) {
        int index;
        Intrinsics.checkNotNullParameter(url, "url");
        int index$iv = 0;
        Iterator<Regex> it = this.matchRegex.iterator();
        while (true) {
            if (!it.hasNext()) {
                index = -1;
                break;
            } else if (((Regex) it.next()).matches(url)) {
                index = index$iv;
                break;
            } else {
                index$iv++;
            }
        }
        Iterable $this$zip$iv = this.pathParamNames;
        Iterable other$iv = RoutingRegexes.values(this.pathParamRegex.get(index), url);
        Iterator first$iv = $this$zip$iv.iterator();
        Iterator second$iv = other$iv.iterator();
        ArrayList list$iv = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault($this$zip$iv, 10), CollectionsKt.collectionSizeOrDefault(other$iv, 10)));
        while (first$iv.hasNext() && second$iv.hasNext()) {
            list$iv.add(Tuples.m366to((String) first$iv.next(), ContextUtil.INSTANCE.urlDecode((String) second$iv.next())));
        }
        return MapsKt.toMap(list$iv);
    }
}
