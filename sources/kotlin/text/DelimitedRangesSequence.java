package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Strings.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\r\n��\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n��\b\u0002\u0018��2\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000eX\u0004¢\u0006\u0002\n��R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u0012"}, m373d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/text/DelimitedRangesSequence.class */
public final class DelimitedRangesSequence implements Sequence<IntRange> {
    @NotNull
    private final CharSequence input;
    private final int startIndex;
    private final int limit;
    @NotNull
    private final Function2<CharSequence, Integer, Pair<Integer, Integer>> getNextMatch;

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public DelimitedRangesSequence(@NotNull CharSequence input, int startIndex, int limit, @NotNull Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> function2) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(function2, "getNextMatch");
        this.input = input;
        this.startIndex = startIndex;
        this.limit = limit;
        this.getNextMatch = function2;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<IntRange> iterator() {
        return new Object(this) { // from class: kotlin.text.DelimitedRangesSequence$iterator$1
            private int nextState = -1;
            private int currentStartIndex;
            private int nextSearchIndex;
            @Nullable
            private IntRange nextItem;
            private int counter;
            final /* synthetic */ DelimitedRangesSequence this$0;

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
                this.currentStartIndex = RangesKt.coerceIn(DelimitedRangesSequence.access$getStartIndex$p($receiver), 0, DelimitedRangesSequence.access$getInput$p($receiver).length());
                this.nextSearchIndex = this.currentStartIndex;
            }

            public final int getNextState() {
                return this.nextState;
            }

            public final void setNextState(int i) {
                this.nextState = i;
            }

            public final int getCurrentStartIndex() {
                return this.currentStartIndex;
            }

            public final void setCurrentStartIndex(int i) {
                this.currentStartIndex = i;
            }

            public final int getNextSearchIndex() {
                return this.nextSearchIndex;
            }

            public final void setNextSearchIndex(int i) {
                this.nextSearchIndex = i;
            }

            @Nullable
            public final IntRange getNextItem() {
                return this.nextItem;
            }

            public final void setNextItem(@Nullable IntRange intRange) {
                this.nextItem = intRange;
            }

            public final int getCounter() {
                return this.counter;
            }

            public final void setCounter(int i) {
                this.counter = i;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
                if (r6.counter < kotlin.text.DelimitedRangesSequence.access$getLimit$p(r6.this$0)) goto L_0x0036;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private final void calcNext() {
                /*
                // Method dump skipped, instructions count: 238
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Strings.calcNext():void");
            }

            @Override // java.util.Iterator
            @NotNull
            public IntRange next() {
                if (this.nextState == -1) {
                    calcNext();
                }
                if (this.nextState == 0) {
                    throw new NoSuchElementException();
                }
                IntRange result = this.nextItem;
                if (result == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
                }
                this.nextItem = null;
                this.nextState = -1;
                return result;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.nextState == -1) {
                    calcNext();
                }
                return this.nextState == 1;
            }
        };
    }
}
