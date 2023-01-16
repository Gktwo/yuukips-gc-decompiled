package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;
import org.jline.reader.LineReader;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: ReversedViews.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��$\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\b\u0002\u0018��*\u0004\b��\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028��0\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028��H\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0016\u0010\u0010\u001a\u00028��2\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00028��2\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0013\u001a\u00028��2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028��H\u0002¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028��0\u0004X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, m373d2 = {"Lkotlin/collections/ReversedList;", "T", "Lkotlin/collections/AbstractMutableList;", MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", BeanUtil.PREFIX_ADDER, "", "index", "element", "(ILjava/lang/Object;)V", LineReader.CLEAR, BeanUtil.PREFIX_GETTER_GET, "(I)Ljava/lang/Object;", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/collections/ReversedList.class */
final class ReversedList<T> extends AbstractMutableList<T> {
    @NotNull
    private final List<T> delegate;

    public ReversedList(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.delegate = list;
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.delegate.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int index) {
        return this.delegate.get(ReversedViews.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, index));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public void clear() {
        this.delegate.clear();
    }

    @Override // kotlin.collections.AbstractMutableList
    public T removeAt(int index) {
        return this.delegate.remove(ReversedViews.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, index));
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public T set(int index, T t) {
        return this.delegate.set(ReversedViews.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, index), t);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int index, T t) {
        this.delegate.add(ReversedViews.reversePositionIndex$CollectionsKt__ReversedViewsKt(this, index), t);
    }
}
