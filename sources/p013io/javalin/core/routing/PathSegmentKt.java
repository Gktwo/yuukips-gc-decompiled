package p013io.javalin.core.routing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.core.routing.PathSegment;

/* compiled from: PathSegment.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��,\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H��\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H��\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H��\u001a\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\b\u0012\u0004\u0012\u00020\f0\u000b\u001a\f\u0010\r\u001a\u00020\u0003*\u00020\u0003H\u0002\u001a\u0012\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b*\u00020\fH��¨\u0006\u000f"}, m373d2 = {"createNormal", "Lio/javalin/core/routing/PathSegment$Normal;", "string", "", "enableRegex", "", "createSlashAcceptingParam", "Lio/javalin/core/routing/PathSegment$Parameter$SlashAcceptingParameter;", "createSlashIgnoringParam", "Lio/javalin/core/routing/PathSegment$Parameter$SlashIgnoringParameter;", "flattenMultipleSegments", "", "Lio/javalin/core/routing/PathSegment;", "grouped", "pathParamNames", "javalin"})
/* renamed from: io.javalin.core.routing.PathSegmentKt */
/* loaded from: grasscutter.jar:io/javalin/core/routing/PathSegmentKt.class */
public final class PathSegmentKt {
    /* access modifiers changed from: private */
    public static final String grouped(String $this$grouped) {
        return '(' + $this$grouped + ')';
    }

    @NotNull
    public static final PathSegment.Normal createNormal(@NotNull String string, boolean enableRegex) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (enableRegex) {
            return new PathSegment.Normal.RegexAllowed(string);
        }
        return new PathSegment.Normal.RegexEscaped(string);
    }

    public static /* synthetic */ PathSegment.Normal createNormal$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return createNormal(str, z);
    }

    @NotNull
    public static final PathSegment.Parameter.SlashIgnoringParameter createSlashIgnoringParam(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return new PathSegment.Parameter.SlashIgnoringParameter(string);
    }

    @NotNull
    public static final PathSegment.Parameter.SlashAcceptingParameter createSlashAcceptingParam(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return new PathSegment.Parameter.SlashAcceptingParameter(string);
    }

    @NotNull
    public static final List<PathSegment> flattenMultipleSegments(@NotNull List<? extends PathSegment> list) {
        List<PathSegment> list2;
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<? extends PathSegment> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (PathSegment it : $this$map$iv) {
            if (it instanceof PathSegment.MultipleSegments) {
                list2 = ((PathSegment.MultipleSegments) it).getInnerSegments();
            } else {
                list2 = CollectionsKt.listOf(it);
            }
            destination$iv$iv.add(list2);
        }
        return CollectionsKt.flatten((List) destination$iv$iv);
    }

    @NotNull
    public static final List<String> pathParamNames(@NotNull PathSegment $this$pathParamNames) {
        Intrinsics.checkNotNullParameter($this$pathParamNames, "<this>");
        if ($this$pathParamNames instanceof PathSegment.Normal ? true : $this$pathParamNames instanceof PathSegment.Wildcard) {
            return CollectionsKt.emptyList();
        }
        if ($this$pathParamNames instanceof PathSegment.Parameter) {
            return CollectionsKt.listOf(((PathSegment.Parameter) $this$pathParamNames).getName());
        }
        if ($this$pathParamNames instanceof PathSegment.MultipleSegments) {
            Iterable $this$filterIsInstance$iv = ((PathSegment.MultipleSegments) $this$pathParamNames).getInnerSegments();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filterIsInstance$iv) {
                if (element$iv$iv instanceof PathSegment.Parameter) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable<PathSegment.Parameter> $this$map$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (PathSegment.Parameter it : $this$map$iv) {
                destination$iv$iv2.add(it.getName());
            }
            return (List) destination$iv$iv2;
        }
        throw new NoWhenBranchMatchedException();
    }
}
