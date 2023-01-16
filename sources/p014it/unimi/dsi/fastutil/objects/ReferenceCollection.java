package p014it.unimi.dsi.fastutil.objects;

import java.util.Collection;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceCollection.class */
public interface ReferenceCollection<K> extends Collection<K>, ObjectIterable<K> {
    @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
    ObjectIterator<K> iterator();

    @Override // java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection, p014it.unimi.dsi.fastutil.objects.ObjectSet, java.util.Set
    default ObjectSpliterator<K> spliterator() {
        return ObjectSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 64);
    }
}
