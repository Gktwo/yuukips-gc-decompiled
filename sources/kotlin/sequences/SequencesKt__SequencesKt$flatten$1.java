package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Sequences.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48, m374d1 = {"��\u0010\n��\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\u0010��\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b��\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m373d2 = {"<anonymous>", "", "T", "it", "Lkotlin/sequences/Sequence;", "invoke"})
/* loaded from: grasscutter.jar:kotlin/sequences/SequencesKt__SequencesKt$flatten$1.class */
final class SequencesKt__SequencesKt$flatten$1 extends Lambda implements Function1<Sequence<? extends T>, Iterator<? extends T>> {
    public static final SequencesKt__SequencesKt$flatten$1 INSTANCE = new SequencesKt__SequencesKt$flatten$1();

    SequencesKt__SequencesKt$flatten$1() {
        super(1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.Iterator<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final Iterator<T> invoke(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "it");
        return sequence.iterator();
    }
}
