package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.CoreConstants;

/* compiled from: DeepRecursive.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018��*\u0004\b��\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004BK\u00129\u0010\u0005\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028��\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u00028��\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\b\b\u0012\u0006\u0010\t\u001a\u00028��ø\u0001��¢\u0006\u0002\u0010\nJ\u0019\u0010\u0015\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028��H@ø\u0001��¢\u0006\u0002\u0010\u0016Jc\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000429\u0010\u0018\u001a5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\b\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0002ø\u0001��¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016ø\u0001��¢\u0006\u0002\u0010\u001cJ\u000b\u0010\u001d\u001a\u00028\u0001¢\u0006\u0002\u0010\u001eJ5\u0010\u0015\u001a\u0002H\u001f\"\u0004\b\u0002\u0010 \"\u0004\b\u0003\u0010\u001f*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\u001f0!2\u0006\u0010\t\u001a\u0002H H@ø\u0001��¢\u0006\u0002\u0010\"R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004X\u000e¢\u0006\u0002\n��R\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fRF\u0010\u0010\u001a5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\b\bX\u000eø\u0001��¢\u0006\u0004\n\u0002\u0010\u0011R\u001e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013X\u000eø\u0001��ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n��\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006#"}, m373d2 = {"Lkotlin/DeepRecursiveScopeImpl;", "T", "R", "Lkotlin/DeepRecursiveScope;", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function3;", "", "Lkotlin/ExtensionFunctionType;", "value", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;)V", "cont", CoreConstants.CONTEXT_SCOPE_VALUE, "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "function", "Lkotlin/jvm/functions/Function3;", "result", "Lkotlin/Result;", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, "callRecursive", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "crossFunctionCompletion", "currentFunction", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "resumeWith", "", "(Ljava/lang/Object;)V", "runCallLoop", "()Ljava/lang/Object;", "S", "U", "Lkotlin/DeepRecursiveFunction;", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"})
@ExperimentalStdlibApi
/* loaded from: grasscutter.jar:kotlin/DeepRecursiveScopeImpl.class */
public final class DeepRecursiveScopeImpl<T, R> extends DeepRecursiveScope<T, R> implements Continuation<R> {
    @NotNull
    private Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function;
    @Nullable
    private Object value;
    @Nullable
    private Continuation<Object> cont = this;
    @NotNull
    private Object result = DeepRecursive.UNDEFINED_RESULT;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function3<? super kotlin.DeepRecursiveScope<T, R>, ? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public DeepRecursiveScopeImpl(@NotNull Function3<? super DeepRecursiveScope<T, R>, ? super T, ? super Continuation<? super R>, ? extends Object> function3, T t) {
        super(null);
        Intrinsics.checkNotNullParameter(function3, "block");
        this.function = function3;
        this.value = t;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object result) {
        this.cont = null;
        this.result = result;
    }

    @Override // kotlin.DeepRecursiveScope
    @Nullable
    public Object callRecursive(T t, @NotNull Continuation<? super R> continuation) {
        this.cont = continuation;
        this.value = t;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended;
    }

    @Override // kotlin.DeepRecursiveScope
    @Nullable
    public <U, S> Object callRecursive(@NotNull DeepRecursiveFunction<U, S> deepRecursiveFunction, U u, @NotNull Continuation<? super S> continuation) {
        Function3 function = deepRecursiveFunction.getBlock$kotlin_stdlib();
        DeepRecursiveScopeImpl<T, R> $this$callRecursive_u24lambda_u2d2_u24lambda_u2d1 = this;
        Function3 currentFunction = $this$callRecursive_u24lambda_u2d2_u24lambda_u2d1.function;
        if (function != currentFunction) {
            $this$callRecursive_u24lambda_u2d2_u24lambda_u2d1.function = function;
            $this$callRecursive_u24lambda_u2d2_u24lambda_u2d1.cont = $this$callRecursive_u24lambda_u2d2_u24lambda_u2d1.crossFunctionCompletion(currentFunction, continuation);
        } else {
            $this$callRecursive_u24lambda_u2d2_u24lambda_u2d1.cont = continuation;
        }
        $this$callRecursive_u24lambda_u2d2_u24lambda_u2d1.value = u;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended;
    }

    private final Continuation<Object> crossFunctionCompletion(Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function3, Continuation<Object> continuation) {
        return new Continuation<Object>(EmptyCoroutineContext.INSTANCE, this, function3, continuation) { // from class: kotlin.DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1
            final /* synthetic */ CoroutineContext $context;
            final /* synthetic */ DeepRecursiveScopeImpl this$0;
            final /* synthetic */ Function3 $currentFunction$inlined;
            final /* synthetic */ kotlin.coroutines.Continuation $cont$inlined;

            {
                this.$context = $context;
                this.this$0 = r5;
                this.$currentFunction$inlined = r6;
                this.$cont$inlined = r7;
            }

            @Override // kotlin.coroutines.Continuation
            @NotNull
            public CoroutineContext getContext() {
                return this.$context;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(@NotNull Object result) {
                DeepRecursiveScopeImpl.access$setFunction$p(this.this$0, this.$currentFunction$inlined);
                DeepRecursiveScopeImpl.access$setCont$p(this.this$0, this.$cont$inlined);
                DeepRecursiveScopeImpl.access$setResult$p(this.this$0, result);
            }
        };
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:8:0x0025
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:232)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:54)
        */
    public final R runCallLoop() {
        /*
            r5 = this;
        L_0x0000:
            r0 = r5
            java.lang.Object r0 = r0.result
            r6 = r0
            r0 = r5
            kotlin.coroutines.Continuation<java.lang.Object> r0 = r0.cont
            r1 = r0
            if (r1 != 0) goto L_0x001a
            r0 = r6
            r9 = r0
            r0 = r9
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r9
            return r0
        L_0x001a:
            r7 = r0
            java.lang.Object r0 = kotlin.DeepRecursive.access$getUNDEFINED_RESULT$p()
            r1 = r6
            boolean r0 = kotlin.Result.m7062equalsimpl0(r0, r1)
            if (r0 == 0) goto L_0x007b
            r0 = r5
            kotlin.jvm.functions.Function3<? super kotlin.DeepRecursiveScope<?, ?>, java.lang.Object, ? super kotlin.coroutines.Continuation<java.lang.Object>, ? extends java.lang.Object> r0 = r0.function     // Catch: Throwable -> 0x0049
            r9 = r0
            r0 = r5
            java.lang.Object r0 = r0.value     // Catch: Throwable -> 0x0049
            r10 = r0
            r0 = r9
            r1 = 3
            java.lang.Object r0 = kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(r0, r1)     // Catch: Throwable -> 0x0049
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0     // Catch: Throwable -> 0x0049
            r1 = r5
            r2 = r10
            r3 = r7
            java.lang.Object r0 = r0.invoke(r1, r2, r3)     // Catch: Throwable -> 0x0049
            r9 = r0
            goto L_0x0060
        L_0x0049:
            r10 = move-exception
            r0 = r7
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            r1 = r10
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m7059constructorimpl(r1)
            r0.resumeWith(r1)
            goto L_0x0000
        L_0x0060:
            r0 = r9
            r8 = r0
            r0 = r8
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 == r1) goto L_0x0000
            r0 = r7
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            r1 = r8
            java.lang.Object r1 = kotlin.Result.m7059constructorimpl(r1)
            r0.resumeWith(r1)
            goto L_0x0000
        L_0x007b:
            r0 = r5
            java.lang.Object r1 = kotlin.DeepRecursive.access$getUNDEFINED_RESULT$p()
            r0.result = r1
            r0 = r7
            r1 = r6
            r0.resumeWith(r1)
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.DeepRecursiveScopeImpl.runCallLoop():java.lang.Object");
    }
}
