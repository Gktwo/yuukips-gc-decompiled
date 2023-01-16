package okio.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: -FileSystem.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\u000e\n��\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010��\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, m373d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;"})
@DebugMetadata(m364f = "-FileSystem.kt", m362l = {72}, m363i = {}, m359s = {}, m360n = {}, m361m = "invokeSuspend", m365c = "okio.internal._FileSystemKt$commonDeleteRecursively$sequence$1")
/* loaded from: grasscutter.jar:okio/internal/_FileSystemKt$commonDeleteRecursively$sequence$1.class */
public final class _FileSystemKt$commonDeleteRecursively$sequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    int label;
    private /* synthetic */ Object L$0;
    final /* synthetic */ FileSystem $this_commonDeleteRecursively;
    final /* synthetic */ Path $fileOrDirectory;

    /* access modifiers changed from: package-private */
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public _FileSystemKt$commonDeleteRecursively$sequence$1(FileSystem $receiver, Path $fileOrDirectory, Continuation<? super _FileSystemKt$commonDeleteRecursively$sequence$1> continuation) {
        super(2, continuation);
        this.$this_commonDeleteRecursively = $receiver;
        this.$fileOrDirectory = $fileOrDirectory;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> continuation) {
        _FileSystemKt$commonDeleteRecursively$sequence$1 _filesystemkt_commondeleterecursively_sequence_1 = new _FileSystemKt$commonDeleteRecursively$sequence$1(this.$this_commonDeleteRecursively, this.$fileOrDirectory, continuation);
        _filesystemkt_commondeleterecursively_sequence_1.L$0 = value;
        return _filesystemkt_commondeleterecursively_sequence_1;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super Path> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((_FileSystemKt$commonDeleteRecursively$sequence$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (_FileSystemKt.collectRecursively((SequenceScope) this.L$0, this.$this_commonDeleteRecursively, new ArrayDeque(), this.$fileOrDirectory, false, true, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
