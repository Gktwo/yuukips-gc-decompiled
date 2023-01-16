package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: _Sequences.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48)
/* loaded from: grasscutter.jar:kotlin/sequences/SequencesKt___SequencesKt$flatMap$2.class */
/* synthetic */ class SequencesKt___SequencesKt$flatMap$2 extends FunctionReferenceImpl implements Function1<Sequence<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt$flatMap$2 INSTANCE = new SequencesKt___SequencesKt$flatMap$2();

    SequencesKt___SequencesKt$flatMap$2() {
        super(1, Sequence.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.Iterator<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final Iterator<R> invoke(@NotNull Sequence<? extends R> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "p0");
        return sequence.iterator();
    }
}
