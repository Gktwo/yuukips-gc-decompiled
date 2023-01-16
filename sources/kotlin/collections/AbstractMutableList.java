package kotlin.collections;

import java.util.AbstractList;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.markers.KMutableList;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: AbstractMutableList.kt */
@SinceKotlin(version = "1.1")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n��\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0007\b'\u0018��*\u0004\b��\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028��H&¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00028��2\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u00028��2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028��H¦\u0002¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, m373d2 = {"Lkotlin/collections/AbstractMutableList;", "E", "", "Ljava/util/AbstractList;", "()V", BeanUtil.PREFIX_ADDER, "", "index", "", "element", "(ILjava/lang/Object;)V", "removeAt", "(I)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/collections/AbstractMutableList.class */
public abstract class AbstractMutableList<E> extends AbstractList<E> implements List<E>, KMutableList {
    @Override // java.util.AbstractList, java.util.List
    public abstract E set(int i, E e);

    public abstract E removeAt(int i);

    @Override // java.util.AbstractList, java.util.List
    public abstract void add(int i, E e);

    public abstract int getSize();

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int index) {
        return removeAt(index);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }
}
