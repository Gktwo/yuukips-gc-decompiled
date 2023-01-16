package p014it.unimi.dsi.fastutil.chars;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractCharCollection */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractCharCollection.class */
public abstract class AbstractCharCollection extends AbstractCollection<Character> implements CharCollection {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
    public abstract CharIterator iterator();

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean add(char k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean contains(char k) {
        CharIterator iterator = iterator();
        while (iterator.hasNext()) {
            if (k == iterator.nextChar()) {
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean rem(char k) {
        CharIterator iterator = iterator();
        while (iterator.hasNext()) {
            if (k == iterator.nextChar()) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
    @Deprecated
    public boolean add(Character key) {
        return add(key);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.chars.CharCollection
    @Deprecated
    public boolean contains(Object key) {
        return contains(key);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p014it.unimi.dsi.fastutil.chars.CharCollection
    @Deprecated
    public boolean remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
    public char[] toArray(char[] a) {
        int size = size();
        if (a == null) {
            a = new char[size];
        } else if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        CharIterators.unwrap(iterator(), a);
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
    public char[] toCharArray() {
        return toArray((char[]) null);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
    @Deprecated
    public char[] toCharArray(char[] a) {
        return toArray(a);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean addAll(CharCollection c) {
        boolean retVal = false;
        CharIterator i = c.iterator();
        while (i.hasNext()) {
            if (add(i.nextChar())) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Character> c) {
        if (c instanceof CharCollection) {
            return addAll((CharCollection) c);
        }
        return addAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean containsAll(CharCollection c) {
        CharIterator i = c.iterator();
        while (i.hasNext()) {
            if (!contains(i.nextChar())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection<?> c) {
        if (c instanceof CharCollection) {
            return containsAll((CharCollection) c);
        }
        return containsAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean removeAll(CharCollection c) {
        boolean retVal = false;
        CharIterator i = c.iterator();
        while (i.hasNext()) {
            if (rem(i.nextChar())) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> c) {
        if (c instanceof CharCollection) {
            return removeAll((CharCollection) c);
        }
        return removeAll(c);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean retainAll(CharCollection c) {
        boolean retVal = false;
        CharIterator i = iterator();
        while (i.hasNext()) {
            if (!c.contains(i.nextChar())) {
                i.remove();
                retVal = true;
            }
        }
        return retVal;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> c) {
        if (c instanceof CharCollection) {
            return retainAll((CharCollection) c);
        }
        return retainAll(c);
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        CharIterator i = iterator();
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
                s.append(String.valueOf(i.nextChar()));
            } else {
                s.append("}");
                return s.toString();
            }
        }
    }
}
