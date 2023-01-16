package p014it.unimi.dsi.fastutil.objects;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractReferenceSortedSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReferenceSortedSet.class */
public abstract class AbstractReferenceSortedSet<K> extends AbstractReferenceSet<K> implements ReferenceSortedSet<K> {
    @Override // p014it.unimi.dsi.fastutil.objects.AbstractReferenceSet, p014it.unimi.dsi.fastutil.objects.AbstractReferenceCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ReferenceCollection, p014it.unimi.dsi.fastutil.objects.ObjectIterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
    public abstract ObjectBidirectionalIterator<K> iterator();
}
