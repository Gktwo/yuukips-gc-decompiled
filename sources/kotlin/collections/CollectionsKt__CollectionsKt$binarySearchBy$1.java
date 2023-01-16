package kotlin.collections;

import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Collections.kt */
/* JADX WARN: Incorrect field signature: TK; */
@Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 176, m374d1 = {"��\u0012\n��\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\u0010��\u001a\u00020\u0001\"\u0004\b��\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m373d2 = {"<anonymous>", "", "T", "K", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Integer;"})
/* loaded from: grasscutter.jar:kotlin/collections/CollectionsKt__CollectionsKt$binarySearchBy$1.class */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1 extends Lambda implements Function1<T, Integer> {
    final /* synthetic */ Function1<T, K> $selector;
    final /* synthetic */ Comparable $key;

    /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/functions/Function1<-TT;+TK;>;TK;)V */
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(Function1 $selector, Comparable $key) {
        super(1);
        this.$selector = $selector;
        this.$key = $key;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Integer invoke(T t) {
        return Integer.valueOf(ComparisonsKt.compareValues((Comparable) this.$selector.invoke(t), this.$key));
    }
}
