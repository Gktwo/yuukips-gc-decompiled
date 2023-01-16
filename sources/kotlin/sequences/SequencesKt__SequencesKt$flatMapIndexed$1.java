package kotlin.sequences;

import java.util.Iterator;
import javassist.compiler.TokenId;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Sequences.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48, m374d1 = {"��\u000e\n��\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010��\u001a\u00020\u0001\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H@"}, m373d2 = {"<anonymous>", "", "T", "C", "R", "Lkotlin/sequences/SequenceScope;"})
@DebugMetadata(m364f = "Sequences.kt", m362l = {TokenId.PUBLIC}, m363i = {0, 0}, m359s = {"L$0", "I$0"}, m360n = {"$this$sequence", "index"}, m361m = "invokeSuspend", m365c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1")
/* loaded from: grasscutter.jar:kotlin/sequences/SequencesKt__SequencesKt$flatMapIndexed$1.class */
final class SequencesKt__SequencesKt$flatMapIndexed$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    Object L$1;
    int I$0;
    int label;
    private /* synthetic */ Object L$0;
    final /* synthetic */ Sequence<T> $source;
    final /* synthetic */ Function2<Integer, T, C> $transform;
    final /* synthetic */ Function1<C, Iterator<R>> $iterator;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super T, ? extends C> */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.jvm.functions.Function1<? super C, ? extends java.util.Iterator<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt__SequencesKt$flatMapIndexed$1(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends C> function2, Function1<? super C, ? extends Iterator<? extends R>> function1, Continuation<? super SequencesKt__SequencesKt$flatMapIndexed$1> continuation) {
        super(2, continuation);
        this.$source = sequence;
        this.$transform = function2;
        this.$iterator = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> continuation) {
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.$source, this.$transform, this.$iterator, continuation);
        sequencesKt__SequencesKt$flatMapIndexed$1.L$0 = value;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super R> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object $result) {
        Iterator it;
        int index;
        SequenceScope $this$sequence;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$sequence = (SequenceScope) this.L$0;
                index = 0;
                it = this.$source.iterator();
                break;
            case 1:
                index = this.I$0;
                it = (Iterator) this.L$1;
                $this$sequence = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            Object element = it.next();
            Function2<Integer, T, C> function2 = this.$transform;
            index++;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Object result = function2.invoke(boxing.boxInt(index), element);
            this.L$0 = $this$sequence;
            this.L$1 = it;
            this.I$0 = index;
            this.label = 1;
            if ($this$sequence.yieldAll((Iterator) this.$iterator.invoke(result), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
