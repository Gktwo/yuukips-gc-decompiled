package p014it.unimi.dsi.fastutil.objects;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractObjectSortedSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObjectSortedSet.class */
public abstract class AbstractObjectSortedSet<K> extends AbstractObjectSet<K> implements ObjectSortedSet<K> {
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractObjectSet, p014it.unimi.dsi.fastutil.objects.AbstractObjectCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
    public abstract ObjectBidirectionalIterator<K> iterator();
}
