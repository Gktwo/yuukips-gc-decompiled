package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanMap;
import p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2BooleanSortedMap.class */
public abstract class AbstractShort2BooleanSortedMap extends AbstractShort2BooleanMap implements Short2BooleanSortedMap {
    private static final long serialVersionUID = -1773560792952436569L;

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanMap, p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, java.util.Map
    public ShortSortedSet keySet() {
        return new KeySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanSortedMap$KeySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2BooleanSortedMap$KeySet.class */
    public class KeySet extends AbstractShortSortedSet {
        /* access modifiers changed from: protected */
        public KeySet() {
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortCollection
        public boolean contains(short k) {
            return AbstractShort2BooleanSortedMap.this.containsKey(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractShort2BooleanSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractShort2BooleanSortedMap.this.clear();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet, java.util.SortedSet
        public Comparator<? super Short> comparator() {
            return AbstractShort2BooleanSortedMap.this.comparator();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short firstShort() {
            return AbstractShort2BooleanSortedMap.this.firstShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public short lastShort() {
            return AbstractShort2BooleanSortedMap.this.lastShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet headSet(short to) {
            return AbstractShort2BooleanSortedMap.this.headMap(to).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet tailSet(short from) {
            return AbstractShort2BooleanSortedMap.this.tailMap(from).keySet();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortSortedSet subSet(short from, short to) {
            return AbstractShort2BooleanSortedMap.this.subMap(from, to).keySet();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [it.unimi.dsi.fastutil.objects.ObjectSortedSet] */
        @Override // p014it.unimi.dsi.fastutil.shorts.ShortSortedSet
        public ShortBidirectionalIterator iterator(short from) {
            return new KeySetIterator(AbstractShort2BooleanSortedMap.this.short2BooleanEntrySet().iterator(new AbstractShort2BooleanMap.BasicEntry(from, false)));
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortSortedSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortSet, p014it.unimi.dsi.fastutil.shorts.AbstractShortCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.shorts.ShortCollection, p014it.unimi.dsi.fastutil.shorts.ShortIterable
        public ShortBidirectionalIterator iterator() {
            return new KeySetIterator(Short2BooleanSortedMaps.fastIterator(AbstractShort2BooleanSortedMap.this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanSortedMap$KeySetIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2BooleanSortedMap$KeySetIterator.class */
    public static class KeySetIterator implements ShortBidirectionalIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Short2BooleanMap.Entry> f2849i;

        public KeySetIterator(ObjectBidirectionalIterator<Short2BooleanMap.Entry> i) {
            this.f2849i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            return ((Short2BooleanMap.Entry) this.f2849i.next()).getShortKey();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator
        public short previousShort() {
            return this.f2849i.previous().getShortKey();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2849i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f2849i.hasPrevious();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanMap, p014it.unimi.dsi.fastutil.shorts.Short2BooleanMap, java.util.Map
    public BooleanCollection values() {
        return new ValuesCollection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanSortedMap$ValuesCollection */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2BooleanSortedMap$ValuesCollection.class */
    public class ValuesCollection extends AbstractBooleanCollection {
        protected ValuesCollection() {
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.booleans.BooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanIterable, p014it.unimi.dsi.fastutil.booleans.BooleanBigList
        public BooleanIterator iterator() {
            return new ValuesIterator(Short2BooleanSortedMaps.fastIterator(AbstractShort2BooleanSortedMap.this));
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.AbstractBooleanCollection, p014it.unimi.dsi.fastutil.booleans.BooleanCollection
        public boolean contains(boolean k) {
            return AbstractShort2BooleanSortedMap.this.containsValue(k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractShort2BooleanSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractShort2BooleanSortedMap.this.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanSortedMap$ValuesIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2BooleanSortedMap$ValuesIterator.class */
    public static class ValuesIterator implements BooleanIterator {

        /* renamed from: i */
        protected final ObjectBidirectionalIterator<Short2BooleanMap.Entry> f2850i;

        public ValuesIterator(ObjectBidirectionalIterator<Short2BooleanMap.Entry> i) {
            this.f2850i = i;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            return ((Short2BooleanMap.Entry) this.f2850i.next()).getBooleanValue();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2850i.hasNext();
        }
    }
}
