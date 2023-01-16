package okio.internal;

import java.util.Iterator;
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
@DebugMetadata(m364f = "-FileSystem.kt", m362l = {93}, m363i = {0, 0}, m359s = {"L$0", "L$1"}, m360n = {"$this$sequence", "stack"}, m361m = "invokeSuspend", m365c = "okio.internal._FileSystemKt$commonListRecursively$1")
/* loaded from: grasscutter.jar:okio/internal/_FileSystemKt$commonListRecursively$1.class */
public final class _FileSystemKt$commonListRecursively$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    Object L$1;
    Object L$2;
    int label;
    private /* synthetic */ Object L$0;
    final /* synthetic */ Path $dir;
    final /* synthetic */ FileSystem $this_commonListRecursively;
    final /* synthetic */ boolean $followSymlinks;

    /* access modifiers changed from: package-private */
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public _FileSystemKt$commonListRecursively$1(Path $dir, FileSystem $receiver, boolean $followSymlinks, Continuation<? super _FileSystemKt$commonListRecursively$1> continuation) {
        super(2, continuation);
        this.$dir = $dir;
        this.$this_commonListRecursively = $receiver;
        this.$followSymlinks = $followSymlinks;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> continuation) {
        _FileSystemKt$commonListRecursively$1 _filesystemkt_commonlistrecursively_1 = new _FileSystemKt$commonListRecursively$1(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, continuation);
        _filesystemkt_commonlistrecursively_1.L$0 = value;
        return _filesystemkt_commonlistrecursively_1;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super Path> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((_FileSystemKt$commonListRecursively$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object $result) {
        Iterator<Path> it;
        ArrayDeque stack;
        SequenceScope $this$sequence;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$sequence = (SequenceScope) this.L$0;
                stack = new ArrayDeque();
                stack.addLast(this.$dir);
                it = this.$this_commonListRecursively.list(this.$dir).iterator();
                break;
            case 1:
                it = (Iterator) this.L$2;
                stack = (ArrayDeque) this.L$1;
                $this$sequence = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            FileSystem fileSystem = this.$this_commonListRecursively;
            this.L$0 = $this$sequence;
            this.L$1 = stack;
            this.L$2 = it;
            this.label = 1;
            if (_FileSystemKt.collectRecursively($this$sequence, fileSystem, stack, it.next(), this.$followSymlinks, false, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
