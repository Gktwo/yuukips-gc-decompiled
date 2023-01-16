package kotlin.sequences;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: _Sequences.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48, m374d1 = {"��\u000e\n��\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010��\u001a\u00020\u0001\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@"}, m373d2 = {"<anonymous>", "", "T", "R", "Lkotlin/sequences/SequenceScope;"})
@DebugMetadata(m364f = "_Sequences.kt", m362l = {PacketOpcodes.FlightActivitySettleNotify, 2148}, m363i = {0, 1, 1, 1}, m359s = {"L$0", "L$0", "L$1", "I$0"}, m360n = {"$this$sequence", "$this$sequence", "accumulator", "index"}, m361m = "invokeSuspend", m365c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1")
/* loaded from: grasscutter.jar:kotlin/sequences/SequencesKt___SequencesKt$runningFoldIndexed$1.class */
final class SequencesKt___SequencesKt$runningFoldIndexed$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    Object L$1;
    Object L$2;
    int I$0;
    int label;
    private /* synthetic */ Object L$0;
    final /* synthetic */ R $initial;
    final /* synthetic */ Sequence<T> $this_runningFoldIndexed;
    final /* synthetic */ Function3<Integer, R, T, R> $operation;

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super R, ? super T, ? extends R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$runningFoldIndexed$1(R r, Sequence<? extends T> sequence, Function3<? super Integer, ? super R, ? super T, ? extends R> function3, Continuation<? super SequencesKt___SequencesKt$runningFoldIndexed$1> continuation) {
        super(2, continuation);
        this.$initial = r;
        this.$this_runningFoldIndexed = sequence;
        this.$operation = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.$initial, this.$this_runningFoldIndexed, this.$operation, continuation);
        sequencesKt___SequencesKt$runningFoldIndexed$1.L$0 = value;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super R> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object $result) {
        Iterator it;
        Object accumulator;
        int index;
        SequenceScope $this$sequence;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$sequence = (SequenceScope) this.L$0;
                this.L$0 = $this$sequence;
                this.label = 1;
                if ($this$sequence.yield(this.$initial, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                index = 0;
                accumulator = this.$initial;
                it = this.$this_runningFoldIndexed.iterator();
                break;
            case 1:
                $this$sequence = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure($result);
                index = 0;
                accumulator = this.$initial;
                it = this.$this_runningFoldIndexed.iterator();
                break;
            case 2:
                index = this.I$0;
                it = (Iterator) this.L$2;
                accumulator = this.L$1;
                $this$sequence = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            Object element = it.next();
            Function3<Integer, R, T, R> function3 = this.$operation;
            index++;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            accumulator = function3.invoke(boxing.boxInt(index), accumulator, element);
            this.L$0 = $this$sequence;
            this.L$1 = accumulator;
            this.L$2 = it;
            this.I$0 = index;
            this.label = 2;
            if ($this$sequence.yield(accumulator, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
