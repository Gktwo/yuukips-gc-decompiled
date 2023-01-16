package p014it.unimi.dsi.fastutil.bytes;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByteCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByteCollection.class */
public abstract class AbstractByteCollection extends AbstractCollection<Byte> implements ByteCollection {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    public abstract ByteIterator iterator();

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean add(byte k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean contains(byte k) {
        ByteIterator iterator = iterator();
        while (iterator.hasNext()) {
            if (k == iterator.nextByte()) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean rem(byte k) {
        ByteIterator iterator = iterator();
        while (iterator.hasNext()) {
            if (k == iterator.nextByte()) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
    @Deprecated
    public boolean add(Byte key) {
        return add(key);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    @Deprecated
    public boolean contains(Object key) {
        return contains(key);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    @Deprecated
    public boolean remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public byte[] toArray(byte[] a) {
        int size = size();
        if (a == null) {
            a = new byte[size];
        } else if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        ByteIterators.unwrap(iterator(), a);
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public byte[] toByteArray() {
        return toArray((byte[]) null);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
    @Deprecated
    public byte[] toByteArray(byte[] a) {
        return toArray(a);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean addAll(ByteCollection c) {
        boolean retVal = false;
        ByteIterator i = c.iterator();
        while (i.hasNext()) {
            if (add(i.nextByte())) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Byte> c) {
        if (c instanceof ByteCollection) {
            return addAll((ByteCollection) c);
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean containsAll(ByteCollection c) {
        ByteIterator i = c.iterator();
        while (i.hasNext()) {
            if (!contains(i.nextByte())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection<?> c) {
        if (c instanceof ByteCollection) {
            return containsAll((ByteCollection) c);
        }
        return containsAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean removeAll(ByteCollection c) {
        boolean retVal = false;
        ByteIterator i = c.iterator();
        while (i.hasNext()) {
            if (rem(i.nextByte())) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        if (c instanceof ByteCollection) {
            return removeAll((ByteCollection) c);
        }
        return removeAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteCollection
    public boolean retainAll(ByteCollection c) {
        boolean retVal = false;
        ByteIterator i = iterator();
        while (i.hasNext()) {
            if (!c.contains(i.nextByte())) {
                i.remove();
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> c) {
        if (c instanceof ByteCollection) {
            return retainAll((ByteCollection) c);
        }
        return retainAll(c);
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        ByteIterator i = iterator();
        int n = size();
        boolean first = true;
        s.append("{");
        while (true) {
            n--;
            if (n != 0) {
                if (first) {
                    first = false;
                } else {
                    s.append(", ");
                }
                s.append(String.valueOf((int) i.nextByte()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
