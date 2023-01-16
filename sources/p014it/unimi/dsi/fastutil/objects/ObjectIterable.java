package p014it.unimi.dsi.fastutil.objects;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectIterable */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectIterable.class */
public interface ObjectIterable<K> extends Iterable<K> {
    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable
    ObjectIterator<K> iterator();

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
    default ObjectSpliterator<K> spliterator() {
        return ObjectSpliterators.asSpliteratorUnknownSize(iterator(), 0);
    }
}
