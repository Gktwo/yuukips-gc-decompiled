package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��\u000e\n��\n\u0002\u0010(\n��\n\u0002\u0018\u0002\n��\u001a\u001f\u0010��\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b��\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0002¨\u0006\u0004"}, m373d2 = {"iterator", "", "T", "Ljava/util/Enumeration;", "kotlin-stdlib"}, m368xs = "kotlin/collections/CollectionsKt")
/* renamed from: kotlin.collections.CollectionsKt__IteratorsJVMKt */
/* loaded from: grasscutter.jar:kotlin/collections/CollectionsKt__IteratorsJVMKt.class */
class IteratorsJVM extends CollectionsKt__IterablesKt {
    @NotNull
    public static final <T> Iterator<T> iterator(@NotNull Enumeration<T> enumeration) {
        Intrinsics.checkNotNullParameter(enumeration, "<this>");
        return new Object(enumeration) { // from class: kotlin.collections.CollectionsKt__IteratorsJVMKt$iterator$1
            final /* synthetic */ Enumeration<T> $this_iterator;

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            /* access modifiers changed from: package-private */
            {
                this.$this_iterator = r4;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.$this_iterator.hasMoreElements();
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
            @Override // java.util.Iterator
            public T next() {
                return this.$this_iterator.nextElement();
            }
        };
    }
}
