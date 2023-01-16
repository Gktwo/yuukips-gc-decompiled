package p014it.unimi.dsi.fastutil.objects;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterable */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBidirectionalIterable.class */
public interface ObjectBidirectionalIterable<K> extends ObjectIterable<K> {
    @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterable, java.lang.Iterable, p014it.unimi.dsi.fastutil.objects.ObjectCollection
    ObjectBidirectionalIterator<K> iterator();
}
