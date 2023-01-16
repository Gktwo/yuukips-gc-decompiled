package kotlin.sequences;

import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.quartz.impl.jdbcjobstore.Constants;
import org.quartz.jobs.p027ee.mail.SendMailJob;

@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��R\n��\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aN\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b��\u0010\n2/\b\t\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\bø\u0001��¢\u0006\u0002\u0010\u0012\u001aN\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\n0\u0014\"\u0004\b��\u0010\n2/\b\t\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\bø\u0001��¢\u0006\u0002\u0010\u0015\u001aM\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b��\u0010\n2/\b\u0001\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0007ø\u0001��¢\u0006\u0002\u0010\u0012\u001aM\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\n0\u0014\"\u0004\b��\u0010\n2/\b\u0001\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0007ø\u0001��¢\u0006\u0002\u0010\u0015\"\u0012\u0010��\u001a\u00060\u0001j\u0002`\u0002XT¢\u0006\u0002\n��\"\u0012\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002XT¢\u0006\u0002\n��\"\u0012\u0010\u0004\u001a\u00060\u0001j\u0002`\u0002XT¢\u0006\u0002\n��\"\u0012\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002XT¢\u0006\u0002\n��\"\u0012\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002XT¢\u0006\u0002\n��\"\u0012\u0010\u0007\u001a\u00060\u0001j\u0002`\u0002XT¢\u0006\u0002\n��*V\b\u0007\u0010\u0019\u001a\u0004\b��\u0010\n\"\b\u0012\u0004\u0012\u0002H\n0\r2\b\u0012\u0004\u0012\u0002H\n0\rB6\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u001c\b\u001d\u0012\u0018\b\u000bB\u0014\b\u001e\u0012\u0006\b\u001f\u0012\u0002\b\f\u0012\b\b \u0012\u0004\b\b(!\u0012\n\b\"\u0012\u0006\b\n0#8$*\f\b\u0002\u0010%\"\u00020\u00012\u00020\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, m373d2 = {"State_Done", "", "Lkotlin/sequences/State;", "State_Failed", "State_ManyNotReady", "State_ManyReady", "State_NotReady", "State_Ready", "buildIterator", "", "T", "builderAction", "Lkotlin/Function2;", "Lkotlin/sequences/SequenceScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "buildSequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "iterator", "block", "sequence", "SequenceBuilder", "Lkotlin/Deprecated;", SendMailJob.PROP_MESSAGE, "Use SequenceScope class instead.", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "SequenceScope<T>", "level", "Lkotlin/DeprecationLevel;", Constants.STATE_ERROR, "State", "kotlin-stdlib"}, m368xs = "kotlin/sequences/SequencesKt")
/* renamed from: kotlin.sequences.SequencesKt__SequenceBuilderKt */
/* loaded from: grasscutter.jar:kotlin/sequences/SequencesKt__SequenceBuilderKt.class */
class SequenceBuilder {
    private static final int State_NotReady = 0;
    private static final int State_ManyNotReady = 1;
    private static final int State_ManyReady = 2;
    private static final int State_Ready = 3;
    private static final int State_Done = 4;
    private static final int State_Failed = 5;

    @Deprecated(message = "Use SequenceScope class instead.", replaceWith = @ReplaceWith(expression = "SequenceScope<T>", imports = {}), level = DeprecationLevel.ERROR)
    public static /* synthetic */ void SequenceBuilder$annotations() {
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Sequence<T> sequence(@BuilderInference @NotNull Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        return new Sequence<T>(function2) { // from class: kotlin.sequences.SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1
            final /* synthetic */ Function2 $block$inlined;

            {
                this.$block$inlined = r4;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                return SequencesKt.iterator(this.$block$inlined);
            }
        };
    }

    @Deprecated(message = "Use 'sequence { }' function instead.", replaceWith = @ReplaceWith(expression = "sequence(builderAction)", imports = {}), level = DeprecationLevel.ERROR)
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Sequence<T> buildSequence(@BuilderInference Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "builderAction");
        return new Sequence<T>(function2) { // from class: kotlin.sequences.SequencesKt__SequenceBuilderKt$buildSequence$$inlined$Sequence$1
            final /* synthetic */ Function2 $builderAction$inlined;

            {
                this.$builderAction$inlined = r4;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                return SequencesKt.iterator(this.$builderAction$inlined);
            }
        };
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Iterator<T> iterator(@BuilderInference @NotNull Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        SequenceBuilderIterator iterator = new SequenceBuilderIterator();
        iterator.setNextStep(IntrinsicsKt.createCoroutineUnintercepted(function2, iterator, iterator));
        return iterator;
    }

    @Deprecated(message = "Use 'iterator { }' function instead.", replaceWith = @ReplaceWith(expression = "iterator(builderAction)", imports = {}), level = DeprecationLevel.ERROR)
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Iterator<T> buildIterator(@BuilderInference Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "builderAction");
        return SequencesKt.iterator(function2);
    }
}
