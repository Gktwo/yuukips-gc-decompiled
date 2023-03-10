package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.CoreConstants;

/* compiled from: RunSuspend.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018��2\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u0002J\u001e\u0010\u000f\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016ø\u0001��¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R(\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000eø\u0001��ø\u0001\u0001¢\u0006\u000e\n��\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011"}, m373d2 = {"Lkotlin/coroutines/jvm/internal/RunSuspend;", "Lkotlin/coroutines/Continuation;", "", "()V", CoreConstants.CONTEXT_SCOPE_VALUE, "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "Lkotlin/Result;", "getResult-xLWZpok", "()Lkotlin/Result;", "setResult", "(Lkotlin/Result;)V", "await", "resumeWith", "(Ljava/lang/Object;)V", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/coroutines/jvm/internal/RunSuspend.class */
final class RunSuspend implements Continuation<Unit> {
    @Nullable
    private Result<Unit> result;

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Nullable
    /* renamed from: getResult-xLWZpok  reason: not valid java name */
    public final Result<Unit> m8274getResultxLWZpok() {
        return this.result;
    }

    public final void setResult(@Nullable Result<Unit> result) {
        this.result = result;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object result) {
        synchronized (this) {
            this.result = Result.m7060boximpl(result);
            notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void await() {
        synchronized (this) {
            while (true) {
                Result result = m8274getResultxLWZpok();
                if (result == null) {
                    wait();
                } else {
                    ResultKt.throwOnFailure(result.m7061unboximpl());
                }
            }
        }
    }
}
