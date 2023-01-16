package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.builtins.Tmux;

/* compiled from: Regex.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n��R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n��\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, m373d2 = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", Tmux.CMD_NEXT, "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/text/MatcherMatchResult.class */
public final class MatcherMatchResult implements MatchResult {
    @NotNull
    private final Matcher matcher;
    @NotNull
    private final CharSequence input;
    @NotNull
    private final MatchGroupCollection groups = new MatcherMatchResult$groups$1(this);
    @Nullable
    private List<String> groupValues_;

    public MatcherMatchResult(@NotNull Matcher matcher, @NotNull CharSequence input) {
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(input, "input");
        this.matcher = matcher;
        this.input = input;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public MatchResult.Destructured getDestructured() {
        return MatchResult.DefaultImpls.getDestructured(this);
    }

    /* access modifiers changed from: private */
    public final java.util.regex.MatchResult getMatchResult() {
        return this.matcher;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public IntRange getRange() {
        return RegexKt.range(getMatchResult());
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public String getValue() {
        String group = getMatchResult().group();
        Intrinsics.checkNotNullExpressionValue(group, "matchResult.group()");
        return group;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public MatchGroupCollection getGroups() {
        return this.groups;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public List<String> getGroupValues() {
        if (this.groupValues_ == null) {
            this.groupValues_ = new AbstractList<String>(this) { // from class: kotlin.text.MatcherMatchResult$groupValues$1
                final /* synthetic */ MatcherMatchResult this$0;

                /* access modifiers changed from: package-private */
                {
                    this.this$0 = $receiver;
                }

                public /* bridge */ int indexOf(String element) {
                    return indexOf((MatcherMatchResult$groupValues$1) element);
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int indexOf(Object element) {
                    if (!(element instanceof String)) {
                        return -1;
                    }
                    return indexOf((String) element);
                }

                public /* bridge */ int lastIndexOf(String element) {
                    return lastIndexOf((MatcherMatchResult$groupValues$1) element);
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int lastIndexOf(Object element) {
                    if (!(element instanceof String)) {
                        return -1;
                    }
                    return lastIndexOf((String) element);
                }

                public /* bridge */ boolean contains(String element) {
                    return contains((MatcherMatchResult$groupValues$1) element);
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection
                public final /* bridge */ boolean contains(Object element) {
                    if (!(element instanceof String)) {
                        return false;
                    }
                    return contains((String) element);
                }

                @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
                public int getSize() {
                    return MatcherMatchResult.access$getMatchResult(this.this$0).groupCount() + 1;
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                @NotNull
                public String get(int index) {
                    String group = MatcherMatchResult.access$getMatchResult(this.this$0).group(index);
                    return group == null ? "" : group;
                }
            };
        }
        List<String> list = this.groupValues_;
        Intrinsics.checkNotNull(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    @Nullable
    public MatchResult next() {
        int nextIndex = getMatchResult().end() + (getMatchResult().end() == getMatchResult().start() ? 1 : 0);
        if (nextIndex > this.input.length()) {
            return null;
        }
        Matcher matcher = this.matcher.pattern().matcher(this.input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher.pattern().matcher(input)");
        return RegexKt.findNext(matcher, nextIndex, this.input);
    }
}
