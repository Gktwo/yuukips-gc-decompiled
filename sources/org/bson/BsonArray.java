package org.bson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.bson.codecs.BsonArrayCodec;
import org.bson.codecs.DecoderContext;
import org.bson.json.JsonReader;

/* loaded from: grasscutter.jar:org/bson/BsonArray.class */
public class BsonArray extends BsonValue implements List<BsonValue>, Cloneable {
    private final List<BsonValue> values;

    public BsonArray(List<? extends BsonValue> values) {
        this(values, true);
    }

    public BsonArray() {
        this(new ArrayList(), false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<? extends org.bson.BsonValue> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public BsonArray(List<? extends BsonValue> values, boolean copy) {
        if (copy) {
            this.values = new ArrayList(values);
        } else {
            this.values = values;
        }
    }

    public static BsonArray parse(String json) {
        return new BsonArrayCodec().decode((BsonReader) new JsonReader(json), DecoderContext.builder().build());
    }

    public List<BsonValue> getValues() {
        return Collections.unmodifiableList(this.values);
    }

    @Override // org.bson.BsonValue
    public BsonType getBsonType() {
        return BsonType.ARRAY;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.values.size();
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object o) {
        return this.values.contains(o);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<BsonValue> iterator() {
        return this.values.iterator();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.values.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] a) {
        return (T[]) this.values.toArray(a);
    }

    public boolean add(BsonValue bsonValue) {
        return this.values.add(bsonValue);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object o) {
        return this.values.remove(o);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> c) {
        return this.values.containsAll(c);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends BsonValue> c) {
        return this.values.addAll(c);
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends BsonValue> c) {
        return this.values.addAll(index, c);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        return this.values.removeAll(c);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> c) {
        return this.values.retainAll(c);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.values.clear();
    }

    @Override // java.util.List
    public BsonValue get(int index) {
        return this.values.get(index);
    }

    public BsonValue set(int index, BsonValue element) {
        return this.values.set(index, element);
    }

    public void add(int index, BsonValue element) {
        this.values.add(index, element);
    }

    @Override // java.util.List
    public BsonValue remove(int index) {
        return this.values.remove(index);
    }

    @Override // java.util.List
    public int indexOf(Object o) {
        return this.values.indexOf(o);
    }

    @Override // java.util.List
    public int lastIndexOf(Object o) {
        return this.values.lastIndexOf(o);
    }

    @Override // java.util.List
    public ListIterator<BsonValue> listIterator() {
        return this.values.listIterator();
    }

    @Override // java.util.List
    public ListIterator<BsonValue> listIterator(int index) {
        return this.values.listIterator(index);
    }

    @Override // java.util.List
    public List<BsonValue> subList(int fromIndex, int toIndex) {
        return this.values.subList(fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BsonArray)) {
            return false;
        }
        return getValues().equals(((BsonArray) o).getValues());
    }

    @Override // java.util.List, java.util.Collection, java.lang.Object
    public int hashCode() {
        return this.values.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return "BsonArray{values=" + this.values + '}';
    }

    @Override // java.lang.Object
    public BsonArray clone() {
        BsonArray to = new BsonArray();
        Iterator<BsonValue> it = iterator();
        while (it.hasNext()) {
            BsonValue cur = it.next();
            switch (cur.getBsonType()) {
                case DOCUMENT:
                    to.add((BsonValue) cur.asDocument().clone());
                    break;
                case ARRAY:
                    to.add((BsonValue) cur.asArray().clone());
                    break;
                case BINARY:
                    to.add((BsonValue) BsonBinary.clone(cur.asBinary()));
                    break;
                case JAVASCRIPT_WITH_SCOPE:
                    to.add((BsonValue) BsonJavaScriptWithScope.clone(cur.asJavaScriptWithScope()));
                    break;
                default:
                    to.add(cur);
                    break;
            }
        }
        return to;
    }
}
