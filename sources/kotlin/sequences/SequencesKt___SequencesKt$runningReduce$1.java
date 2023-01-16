package kotlin.sequences;

import emu.grasscutter.net.packet.PacketOpcodes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: _Sequences.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48, m374d1 = {"��\u000e\n��\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010��\u001a\u00020\u0001\"\u0004\b��\u0010\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, m373d2 = {"<anonymous>", "", "S", "T", "Lkotlin/sequences/SequenceScope;"})
@DebugMetadata(m364f = "_Sequences.kt", m362l = {2173, PacketOpcodes.EnterTrialAvatarActivityDungeonRsp}, m363i = {0, 0, 0, 1, 1, 1}, m359s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, m360n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, m361m = "invokeSuspend", m365c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1")
/* loaded from: grasscutter.jar:kotlin/sequences/SequencesKt___SequencesKt$runningReduce$1.class */
final class SequencesKt___SequencesKt$runningReduce$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object> {
    Object L$1;
    Object L$2;
    int label;
    private /* synthetic */ Object L$0;
    final /* synthetic */ Sequence<T> $this_runningReduce;
    final /* synthetic */ Function2<S, T, S> $operation;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function2<? super S, ? super T, ? extends S> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$runningReduce$1(Sequence<? extends T> sequence, Function2<? super S, ? super T, ? extends S> function2, Continuation<? super SequencesKt___SequencesKt$runningReduce$1> continuation) {
        super(2, continuation);
        this.$this_runningReduce = sequence;
        this.$operation = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningReduce$1 sequencesKt___SequencesKt$runningReduce$1 = new SequencesKt___SequencesKt$runningReduce$1(this.$this_runningReduce, this.$operation, continuation);
        sequencesKt___SequencesKt$runningReduce$1.L$0 = value;
        return sequencesKt___SequencesKt$runningReduce$1;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super S> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$runningReduce$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0098  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
        // Method dump skipped, instructions count: 256
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
