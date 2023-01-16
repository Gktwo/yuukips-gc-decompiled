package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SlidingWindow.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48, m374d1 = {"��\u0010\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0010 \u0010��\u001a\u00020\u0001\"\u0004\b��\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H@"}, m373d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", ""})
@DebugMetadata(m364f = "SlidingWindow.kt", m362l = {34, 40, 49, 55, 58}, m363i = {0, 0, 0, 2, 2, 3, 3}, m359s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"}, m360n = {"$this$iterator", "buffer", "gap", "$this$iterator", "buffer", "$this$iterator", "buffer"}, m361m = "invokeSuspend", m365c = "kotlin.collections.SlidingWindowKt$windowedIterator$1")
/* loaded from: grasscutter.jar:kotlin/collections/SlidingWindowKt$windowedIterator$1.class */
public final class SlidingWindowKt$windowedIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    Object L$1;
    Object L$2;
    int I$0;
    int label;
    private /* synthetic */ Object L$0;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    final /* synthetic */ Iterator<T> $iterator;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ boolean $partialWindows;

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.Iterator<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public SlidingWindowKt$windowedIterator$1(int $size, int $step, Iterator<? extends T> it, boolean $reuseBuffer, boolean $partialWindows, Continuation<? super SlidingWindowKt$windowedIterator$1> continuation) {
        super(2, continuation);
        this.$size = $size;
        this.$step = $step;
        this.$iterator = it;
        this.$reuseBuffer = $reuseBuffer;
        this.$partialWindows = $partialWindows;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> continuation) {
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
        slidingWindowKt$windowedIterator$1.L$0 = value;
        return slidingWindowKt$windowedIterator$1;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super List<? extends T>> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SlidingWindowKt$windowedIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x022d, code lost:
        if (r6.$partialWindows == false) goto L_0x02e5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0074  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
        // Method dump skipped, instructions count: 755
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.SlidingWindowKt$windowedIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
