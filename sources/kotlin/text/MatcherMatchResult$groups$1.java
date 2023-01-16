package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: Regex.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��-\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010(\n��*\u0001��\b\n\u0018��2\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m373d2 = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", BeanUtil.PREFIX_GETTER_GET, "index", "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/text/MatcherMatchResult$groups$1.class */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchNamedGroupCollection {
    final /* synthetic */ MatcherMatchResult this$0;

    /* access modifiers changed from: package-private */
    public MatcherMatchResult$groups$1(MatcherMatchResult $receiver) {
        this.this$0 = $receiver;
    }

    public /* bridge */ boolean contains(MatchGroup element) {
        return contains((MatcherMatchResult$groups$1) element);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object element) {
        if (!(element == null ? true : element instanceof MatchGroup)) {
            return false;
        }
        return contains((MatchGroup) element);
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return MatcherMatchResult.access$getMatchResult(this.this$0).groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<MatchGroup> iterator() {
        return SequencesKt.map(CollectionsKt.asSequence(CollectionsKt.getIndices(this)), new Function1<Integer, MatchGroup>(this) { // from class: kotlin.text.MatcherMatchResult$groups$1$iterator$1
            final /* synthetic */ MatcherMatchResult$groups$1 this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            @Nullable
            public final MatchGroup invoke(int it) {
                return this.this$0.get(it);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MatchGroup invoke(Integer num) {
                return invoke(num.intValue());
            }
        }).iterator();
    }

    @Override // kotlin.text.MatchGroupCollection
    @Nullable
    public MatchGroup get(int index) {
        IntRange range = RegexKt.access$range(MatcherMatchResult.access$getMatchResult(this.this$0), index);
        if (range.getStart().intValue() < 0) {
            return null;
        }
        String group = MatcherMatchResult.access$getMatchResult(this.this$0).group(index);
        Intrinsics.checkNotNullExpressionValue(group, "matchResult.group(index)");
        return new MatchGroup(group, range);
    }

    @Override // kotlin.text.MatchNamedGroupCollection
    @Nullable
    public MatchGroup get(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getMatchResultNamedGroup(MatcherMatchResult.access$getMatchResult(this.this$0), name);
    }
}
