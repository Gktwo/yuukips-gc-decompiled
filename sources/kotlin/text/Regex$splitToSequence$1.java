package kotlin.text;

import emu.grasscutter.net.packet.PacketOpcodes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Regex.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48, m374d1 = {"��\u000e\n��\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010��\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, m373d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""})
@DebugMetadata(m364f = "Regex.kt", m362l = {PacketOpcodes.BackMyWorldRsp, PacketOpcodes.PlatformStopRouteNotify, PacketOpcodes.GetSceneAreaReq}, m363i = {1, 1, 1}, m359s = {"L$0", "L$1", "I$0"}, m360n = {"$this$sequence", "matcher", "splitCount"}, m361m = "invokeSuspend", m365c = "kotlin.text.Regex$splitToSequence$1")
/* loaded from: grasscutter.jar:kotlin/text/Regex$splitToSequence$1.class */
public final class Regex$splitToSequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
    Object L$1;
    int I$0;
    int label;
    private /* synthetic */ Object L$0;
    final /* synthetic */ Regex this$0;
    final /* synthetic */ CharSequence $input;
    final /* synthetic */ int $limit;

    /* access modifiers changed from: package-private */
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public Regex$splitToSequence$1(Regex $receiver, CharSequence $input, int $limit, Continuation<? super Regex$splitToSequence$1> continuation) {
        super(2, continuation);
        this.this$0 = $receiver;
        this.$input = $input;
        this.$limit = $limit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> continuation) {
        Regex$splitToSequence$1 regex$splitToSequence$1 = new Regex$splitToSequence$1(this.this$0, this.$input, this.$limit, continuation);
        regex$splitToSequence$1.L$0 = value;
        return regex$splitToSequence$1;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super String> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((Regex$splitToSequence$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0122  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
        // Method dump skipped, instructions count: 313
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex$splitToSequence$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
