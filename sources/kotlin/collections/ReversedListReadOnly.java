package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: ReversedViews.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001c\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0012\u0018��*\u0006\b��\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028��0\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\u00028��2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028��0\u0004X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\r"}, m373d2 = {"Lkotlin/collections/ReversedListReadOnly;", "T", "Lkotlin/collections/AbstractList;", MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", BeanUtil.PREFIX_GETTER_GET, "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/collections/ReversedListReadOnly.class */
class ReversedListReadOnly<T> extends AbstractList<T> {
    @NotNull
    private final List<T> delegate;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public ReversedListReadOnly(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.delegate = list;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.delegate.size();
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int index) {
        return this.delegate.get(ReversedViews.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, index));
    }
}
