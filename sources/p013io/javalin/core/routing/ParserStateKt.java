package p013io.javalin.core.routing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jline.builtins.Tmux;
import p013io.javalin.core.routing.PathSegment;

/* compiled from: ParserState.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��,\n��\n\u0002\u0010 \n\u0002\u0010\u000e\n��\n\u0002\u0010\"\n\u0002\u0010\f\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n��\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H��\u001a\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002\u001a\u001c\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002\"\u0014\u0010��\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n��\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n��¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0012X\u0002"}, m373d2 = {"adjacentViolations", "", "", "allDelimiters", "", "", "convertSegment", "Lio/javalin/core/routing/PathSegment;", "segment", "rawPath", "parseAsPathSegment", "isEnclosedBy", "", Tmux.OPT_PREFIX, "suffix", "stripEnclosing", "javalin", "bracketsCount", "", "wildcardCount"})
/* renamed from: io.javalin.core.routing.ParserStateKt */
/* loaded from: grasscutter.jar:io/javalin/core/routing/ParserStateKt.class */
public final class ParserStateKt {
    @NotNull
    private static final Set<Character> allDelimiters = SetsKt.setOf((Object[]) new Character[]{'{', '}', '<', '>'});
    @NotNull
    private static final List<String> adjacentViolations = CollectionsKt.listOf((Object[]) new String[]{"*{", "*<", "}*", ">*"});

    /* compiled from: ParserState.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48)
    /* renamed from: io.javalin.core.routing.ParserStateKt$WhenMappings */
    /* loaded from: grasscutter.jar:io/javalin/core/routing/ParserStateKt$WhenMappings.class */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ParserState.values().length];
            iArr[ParserState.NORMAL.ordinal()] = 1;
            iArr[ParserState.INSIDE_SLASH_IGNORING_BRACKETS.ordinal()] = 2;
            iArr[ParserState.INSIDE_SLASH_ACCEPTING_BRACKETS.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static final PathSegment convertSegment(@NotNull String segment, @NotNull String rawPath) {
        boolean z;
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(rawPath, "rawPath");
        Lazy bracketsCount$delegate = LazyKt.lazy(new Function0<Integer>(segment) { // from class: io.javalin.core.routing.ParserStateKt$convertSegment$bracketsCount$2
            final /* synthetic */ String $segment;

            /* access modifiers changed from: package-private */
            {
                this.$segment = $segment;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                CharSequence $this$count$iv = this.$segment;
                int count$iv = 0;
                for (int i = 0; i < $this$count$iv.length(); i++) {
                    if (ParserStateKt.allDelimiters.contains(Character.valueOf($this$count$iv.charAt(i)))) {
                        count$iv++;
                    }
                }
                return Integer.valueOf(count$iv);
            }
        });
        Lazy wildcardCount$delegate = LazyKt.lazy(new Function0<Integer>(segment) { // from class: io.javalin.core.routing.ParserStateKt$convertSegment$wildcardCount$2
            final /* synthetic */ String $segment;

            /* access modifiers changed from: package-private */
            {
                this.$segment = $segment;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                CharSequence $this$count$iv = this.$segment;
                int count$iv = 0;
                for (int i = 0; i < $this$count$iv.length(); i++) {
                    if ($this$count$iv.charAt(i) == '*') {
                        count$iv++;
                    }
                }
                return Integer.valueOf(count$iv);
            }
        });
        if (m5748convertSegment$lambda0(bracketsCount$delegate) % 2 != 0) {
            throw new MissingBracketsException(segment, rawPath);
        }
        Iterable $this$any$iv = adjacentViolations;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator<T> it = $this$any$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (StringsKt.contains$default((CharSequence) segment, (CharSequence) ((String) it.next()), false, 2, (Object) null)) {
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
        }
        if (!z) {
            return Intrinsics.areEqual(segment, "*") ? PathSegment.Wildcard.INSTANCE : (m5748convertSegment$lambda0(bracketsCount$delegate) == 0 && m5749convertSegment$lambda1(wildcardCount$delegate) == 0) ? PathSegmentKt.createNormal$default(segment, false, 2, null) : (m5748convertSegment$lambda0(bracketsCount$delegate) != 2 || !isEnclosedBy(segment, '{', '}')) ? (m5748convertSegment$lambda0(bracketsCount$delegate) != 2 || !isEnclosedBy(segment, '<', '>')) ? parseAsPathSegment(segment, rawPath) : PathSegmentKt.createSlashAcceptingParam(stripEnclosing(segment, '<', '>')) : PathSegmentKt.createSlashIgnoringParam(stripEnclosing(segment, '{', '}'));
        }
        throw new WildcardBracketAdjacentException(segment, rawPath);
    }

    /* renamed from: convertSegment$lambda-0  reason: not valid java name */
    private static final int m5748convertSegment$lambda0(Lazy<Integer> lazy) {
        return lazy.getValue().intValue();
    }

    /* renamed from: convertSegment$lambda-1  reason: not valid java name */
    private static final int m5749convertSegment$lambda1(Lazy<Integer> lazy) {
        return lazy.getValue().intValue();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, io.javalin.core.routing.ParserState] */
    private static final PathSegment parseAsPathSegment(String segment, String rawPath) {
        Ref.ObjectRef state = new Ref.ObjectRef();
        state.element = ParserState.NORMAL;
        List pathNameAccumulator = new ArrayList();
        String $this$map$iv = segment;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length());
        for (int i = 0; i < $this$map$iv.length(); i++) {
            destination$iv$iv.add(parseAsPathSegment$mapSingleChar(state, segment, rawPath, pathNameAccumulator, $this$map$iv.charAt(i)));
        }
        Iterable<PathSegment> $this$fold$iv = CollectionsKt.filterNotNull((List) destination$iv$iv);
        PathSegment.MultipleSegments multipleSegments = new PathSegment.MultipleSegments(CollectionsKt.emptyList());
        for (PathSegment pathSegment : $this$fold$iv) {
            PathSegment lastAddition = (PathSegment) CollectionsKt.lastOrNull((List<? extends Object>) multipleSegments.getInnerSegments());
            if (lastAddition == null) {
                multipleSegments = new PathSegment.MultipleSegments(CollectionsKt.listOf(pathSegment));
            } else if ((lastAddition instanceof PathSegment.Wildcard) && (pathSegment instanceof PathSegment.Wildcard)) {
                multipleSegments = multipleSegments;
            } else if (!(lastAddition instanceof PathSegment.Normal) || !(pathSegment instanceof PathSegment.Normal)) {
                multipleSegments = new PathSegment.MultipleSegments(CollectionsKt.plus((Collection<? extends PathSegment>) multipleSegments.getInnerSegments(), pathSegment));
            } else {
                multipleSegments = new PathSegment.MultipleSegments(CollectionsKt.plus((Collection<? extends PathSegment.Normal>) CollectionsKt.dropLast(multipleSegments.getInnerSegments(), 1), PathSegmentKt.createNormal$default(Intrinsics.stringPlus(((PathSegment.Normal) lastAddition).getContent(), ((PathSegment.Normal) pathSegment).getContent()), false, 2, null)));
            }
        }
        return multipleSegments;
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [T, io.javalin.core.routing.ParserState] */
    /* JADX WARN: Type inference failed for: r1v18, types: [T, io.javalin.core.routing.ParserState] */
    /* JADX WARN: Type inference failed for: r1v28, types: [T, io.javalin.core.routing.ParserState] */
    /* JADX WARN: Type inference failed for: r1v29, types: [T, io.javalin.core.routing.ParserState] */
    private static final PathSegment parseAsPathSegment$mapSingleChar(Ref.ObjectRef<ParserState> objectRef, String $segment, String $rawPath, List<Character> list, char c) {
        PathSegment.Parameter.SlashAcceptingParameter slashAcceptingParameter;
        boolean z;
        boolean z2;
        PathSegment.Parameter.SlashIgnoringParameter slashIgnoringParameter;
        boolean z3;
        boolean z4;
        boolean z5;
        switch (WhenMappings.$EnumSwitchMapping$0[objectRef.element.ordinal()]) {
            case 1:
                if (c == '*') {
                    return PathSegment.Wildcard.INSTANCE;
                }
                if (c == '{') {
                    objectRef.element = ParserState.INSIDE_SLASH_IGNORING_BRACKETS;
                    return null;
                } else if (c == '<') {
                    objectRef.element = ParserState.INSIDE_SLASH_ACCEPTING_BRACKETS;
                    return null;
                } else {
                    if (c == '}') {
                        z5 = true;
                    } else {
                        z5 = c == '>';
                    }
                    if (!z5) {
                        return PathSegmentKt.createNormal$default(String.valueOf(c), false, 2, null);
                    }
                    throw new MissingBracketsException($segment, $rawPath);
                }
            case 2:
                if (c == '}') {
                    objectRef.element = ParserState.NORMAL;
                    String name = CollectionsKt.joinToString$default(list, "", null, null, 0, null, null, 62, null);
                    list.clear();
                    slashIgnoringParameter = PathSegmentKt.createSlashIgnoringParam(name);
                } else {
                    if (c == '{') {
                        z3 = true;
                    } else {
                        z3 = c == '<';
                    }
                    if (z3) {
                        z4 = true;
                    } else {
                        z4 = c == '>';
                    }
                    if (z4) {
                        throw new MissingBracketsException($segment, $rawPath);
                    }
                    list.add(Character.valueOf(c));
                    slashIgnoringParameter = null;
                }
                return slashIgnoringParameter;
            case 3:
                if (c == '>') {
                    objectRef.element = ParserState.NORMAL;
                    String name2 = CollectionsKt.joinToString$default(list, "", null, null, 0, null, null, 62, null);
                    list.clear();
                    slashAcceptingParameter = PathSegmentKt.createSlashAcceptingParam(name2);
                } else {
                    if (c == '{') {
                        z = true;
                    } else {
                        z = c == '}';
                    }
                    if (z) {
                        z2 = true;
                    } else {
                        z2 = c == '<';
                    }
                    if (z2) {
                        throw new MissingBracketsException($segment, $rawPath);
                    }
                    list.add(Character.valueOf(c));
                    slashAcceptingParameter = null;
                }
                return slashAcceptingParameter;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final boolean isEnclosedBy(String $this$isEnclosedBy, char prefix, char suffix) {
        return StringsKt.startsWith$default((CharSequence) $this$isEnclosedBy, prefix, false, 2, (Object) null) && StringsKt.endsWith$default((CharSequence) $this$isEnclosedBy, suffix, false, 2, (Object) null);
    }

    private static final String stripEnclosing(String $this$stripEnclosing, char prefix, char suffix) {
        return StringsKt.removeSuffix(StringsKt.removePrefix($this$stripEnclosing, (CharSequence) String.valueOf(prefix)), (CharSequence) String.valueOf(suffix));
    }
}
