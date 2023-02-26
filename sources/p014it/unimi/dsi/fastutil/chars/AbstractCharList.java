package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p014it.unimi.dsi.fastutil.chars.CharIterators;
import p014it.unimi.dsi.fastutil.chars.CharSpliterators;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractCharList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractCharList.class */
public abstract class AbstractCharList extends AbstractCharCollection implements CharList, CharStack {
    protected void ensureIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is negative");
        } else if (index > size()) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than list size (" + size() + ")");
        }
    }

    protected void ensureRestrictedIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is negative");
        } else if (index >= size()) {
            throw new IndexOutOfBoundsException("Index (" + index + ") is greater than or equal to list size (" + size() + ")");
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    public void add(int index, char k) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean add(char k) {
        add(size(), k);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    public char removeChar(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    public char set(int index, char k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends Character> c) {
        if (c instanceof CharCollection) {
            return addAll(index, (CharCollection) c);
        }
        ensureIndex(index);
        Iterator<? extends Character> i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, ((Character) i.next()).charValue());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends Character> c) {
        return addAll(size(), c);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
    public CharListIterator iterator() {
        return listIterator();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
    public ListIterator<Character> listIterator() {
        return listIterator(0);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
    public ListIterator<Character> listIterator(int index) {
        ensureIndex(index);
        return new CharIterators.AbstractIndexBasedListIterator(0, index) { // from class: it.unimi.dsi.fastutil.chars.AbstractCharList.1
            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedIterator
            protected final char get(int i) {
                return AbstractCharList.this.getChar(i);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedListIterator
            protected final void add(int i, char k) {
                AbstractCharList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedListIterator
            protected final void set(int i, char k) {
                AbstractCharList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                AbstractCharList.this.removeChar(i);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return AbstractCharList.this.size();
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractCharList$IndexBasedSpliterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractCharList$IndexBasedSpliterator.class */
    public static final class IndexBasedSpliterator extends CharSpliterators.LateBindingSizeIndexBasedSpliterator {

        /* renamed from: l */
        final CharList f1315l;

        /* access modifiers changed from: package-private */
        public IndexBasedSpliterator(CharList l, int pos) {
            super(pos);
            this.f1315l = l;
        }

        IndexBasedSpliterator(CharList l, int pos, int maxPos) {
            super(pos, maxPos);
            this.f1315l = l;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.LateBindingSizeIndexBasedSpliterator
        protected final int getMaxPosFromBackingStore() {
            return this.f1315l.size();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
        protected final char get(int i) {
            return this.f1315l.getChar(i);
        }

        /* access modifiers changed from: protected */
        @Override // p014it.unimi.dsi.fastutil.chars.CharSpliterators.AbstractIndexBasedSpliterator
        public final IndexBasedSpliterator makeForSplit(int pos, int maxPos) {
            return new IndexBasedSpliterator(this.f1315l, pos, maxPos);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean contains(char k) {
        return indexOf(k) >= 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int indexOf(char r4) {
        /*
            r3 = this;
            r0 = r3
            it.unimi.dsi.fastutil.chars.CharListIterator r0 = r0.listIterator()
            r5 = r0
        L_0x0005:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0021
            r0 = r5
            char r0 = r0.nextChar()
            r6 = r0
            r0 = r4
            r1 = r6
            if (r0 != r1) goto L_0x0005
            r0 = r5
            int r0 = r0.previousIndex()
            return r0
        L_0x0021:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.AbstractCharList.indexOf(char):int");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int lastIndexOf(char r4) {
        /*
            r3 = this;
            r0 = r3
            r1 = r3
            int r1 = r1.size()
            it.unimi.dsi.fastutil.chars.CharListIterator r0 = r0.listIterator(r1)
            r5 = r0
        L_0x0009:
            r0 = r5
            boolean r0 = r0.hasPrevious()
            if (r0 == 0) goto L_0x0025
            r0 = r5
            char r0 = r0.previousChar()
            r6 = r0
            r0 = r4
            r1 = r6
            if (r0 != r1) goto L_0x0009
            r0 = r5
            int r0 = r0.nextIndex()
            return r0
        L_0x0025:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.AbstractCharList.lastIndexOf(char):int");
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    public void size(int size) {
        int i = size();
        if (size > i) {
            while (true) {
                i++;
                if (i < size) {
                    add((char) 0);
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                i--;
                if (i != size) {
                    removeChar(i);
                } else {
                    return;
                }
            }
        }
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharList' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
    public List<Character> subList(int from, int to) {
        ensureIndex(from);
        ensureIndex(to);
        if (from <= to) {
            return this instanceof RandomAccess ? new CharRandomAccessSubList(this, from, to) : new CharSubList(this, from, to);
        }
        throw new IndexOutOfBoundsException("Start index (" + from + ") is greater than end index (" + to + ")");
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharIterable
    public void forEach(CharConsumer action) {
        if (this instanceof RandomAccess) {
            int max = size();
            for (int i = 0; i < max; i++) {
                action.accept(getChar(i));
            }
            return;
        }
        forEach(action);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeElements(int r6, int r7) {
        /*
            r5 = this;
            r0 = r5
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r5
            r1 = r6
            it.unimi.dsi.fastutil.chars.CharListIterator r0 = r0.listIterator(r1)
            r8 = r0
            r0 = r7
            r1 = r6
            int r0 = r0 - r1
            r9 = r0
            r0 = r9
            if (r0 >= 0) goto L_0x003e
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Start index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r6
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is greater than end index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x003e:
            r0 = r9
            int r9 = r9 + -1
            if (r0 == 0) goto L_0x0056
            r0 = r8
            char r0 = r0.nextChar()
            r0 = r8
            r0.remove()
            goto L_0x003e
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.AbstractCharList.removeElements(int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addElements(int r6, char[] r7, int r8, int r9) {
        /*
            r5 = this;
            r0 = r5
            r1 = r6
            r0.ensureIndex(r1)
            r0 = r7
            r1 = r8
            r2 = r9
            p014it.unimi.dsi.fastutil.chars.CharArrays.ensureOffsetLength(r0, r1, r2)
            r0 = r5
            boolean r0 = r0 instanceof java.util.RandomAccess
            if (r0 == 0) goto L_0x002c
        L_0x0013:
            r0 = r9
            int r9 = r9 + -1
            if (r0 == 0) goto L_0x004b
            r0 = r5
            r1 = r6
            int r6 = r6 + 1
            r2 = r7
            r3 = r8
            int r8 = r8 + 1
            char r2 = r2[r3]
            r0.add(r1, r2)
            goto L_0x0013
        L_0x002c:
            r0 = r5
            r1 = r6
            it.unimi.dsi.fastutil.chars.CharListIterator r0 = r0.listIterator(r1)
            r10 = r0
        L_0x0033:
            r0 = r9
            int r9 = r9 + -1
            if (r0 == 0) goto L_0x004b
            r0 = r10
            r1 = r7
            r2 = r8
            int r8 = r8 + 1
            char r1 = r1[r2]
            r0.add(r1)
            goto L_0x0033
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.AbstractCharList.addElements(int, char[], int, int):void");
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    public void addElements(int index, char[] a) {
        addElements(index, a, 0, a.length);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getElements(int r7, char[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r8
            r1 = r9
            r2 = r10
            p014it.unimi.dsi.fastutil.chars.CharArrays.ensureOffsetLength(r0, r1, r2)
            r0 = r7
            r1 = r10
            int r0 = r0 + r1
            r1 = r6
            int r1 = r1.size()
            if (r0 <= r1) goto L_0x0046
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "End index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            r4 = r10
            int r3 = r3 + r4
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is greater than list size ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r6
            int r3 = r3.size()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0046:
            r0 = r6
            boolean r0 = r0 instanceof java.util.RandomAccess
            if (r0 == 0) goto L_0x006d
            r0 = r7
            r11 = r0
        L_0x0050:
            r0 = r10
            int r10 = r10 + -1
            if (r0 == 0) goto L_0x006a
            r0 = r8
            r1 = r9
            int r9 = r9 + 1
            r2 = r6
            r3 = r11
            int r11 = r11 + 1
            char r2 = r2.getChar(r3)
            r0[r1] = r2
            goto L_0x0050
        L_0x006a:
            goto L_0x008c
        L_0x006d:
            r0 = r6
            r1 = r7
            it.unimi.dsi.fastutil.chars.CharListIterator r0 = r0.listIterator(r1)
            r11 = r0
        L_0x0074:
            r0 = r10
            int r10 = r10 + -1
            if (r0 == 0) goto L_0x008c
            r0 = r8
            r1 = r9
            int r9 = r9 + 1
            r2 = r11
            char r2 = r2.nextChar()
            r0[r1] = r2
            goto L_0x0074
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.AbstractCharList.getElements(int, char[], int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setElements(int r7, char[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r0.ensureIndex(r1)
            r0 = r8
            r1 = r9
            r2 = r10
            p014it.unimi.dsi.fastutil.chars.CharArrays.ensureOffsetLength(r0, r1, r2)
            r0 = r7
            r1 = r10
            int r0 = r0 + r1
            r1 = r6
            int r1 = r1.size()
            if (r0 <= r1) goto L_0x0046
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "End index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            r4 = r10
            int r3 = r3 + r4
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is greater than list size ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r6
            int r3 = r3.size()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0046:
            r0 = r6
            boolean r0 = r0 instanceof java.util.RandomAccess
            if (r0 == 0) goto L_0x006f
            r0 = 0
            r11 = r0
        L_0x0050:
            r0 = r11
            r1 = r10
            if (r0 >= r1) goto L_0x006c
            r0 = r6
            r1 = r11
            r2 = r7
            int r1 = r1 + r2
            r2 = r8
            r3 = r11
            r4 = r9
            int r3 = r3 + r4
            char r2 = r2[r3]
            char r0 = r0.set(r1, r2)
            int r11 = r11 + 1
            goto L_0x0050
        L_0x006c:
            goto L_0x009b
        L_0x006f:
            r0 = r6
            r1 = r7
            it.unimi.dsi.fastutil.chars.CharListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x0079:
            r0 = r12
            r1 = r10
            if (r0 >= r1) goto L_0x009b
            r0 = r11
            char r0 = r0.nextChar()
            r0 = r11
            r1 = r8
            r2 = r9
            r3 = r12
            int r12 = r12 + 1
            int r2 = r2 + r3
            char r1 = r1[r2]
            r0.set(r1)
            goto L_0x0079
        L_0x009b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.AbstractCharList.setElements(int, char[], int, int):void");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        removeElements(0, size());
    }

    @Override // java.util.Collection, java.lang.Object, java.util.List
    public int hashCode() {
        CharIterator i = iterator();
        int h = 1;
        int s = size();
        while (true) {
            s--;
            if (s == 0) {
                return h;
            }
            h = (31 * h) + i.nextChar();
        }
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // java.util.Collection, java.lang.Object, java.util.List
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = r4
            r1 = r3
            if (r0 != r1) goto L_0x0007
            r0 = 1
            return r0
        L_0x0007:
            r0 = r4
            boolean r0 = r0 instanceof java.util.List
            if (r0 != 0) goto L_0x0010
            r0 = 0
            return r0
        L_0x0010:
            r0 = r4
            java.util.List r0 = (java.util.List) r0
            r5 = r0
            r0 = r3
            int r0 = r0.size()
            r6 = r0
            r0 = r6
            r1 = r5
            int r1 = r1.size()
            if (r0 == r1) goto L_0x0026
            r0 = 0
            return r0
        L_0x0026:
            r0 = r5
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.chars.CharList
            if (r0 == 0) goto L_0x005a
            r0 = r3
            it.unimi.dsi.fastutil.chars.CharListIterator r0 = r0.listIterator()
            r7 = r0
            r0 = r5
            it.unimi.dsi.fastutil.chars.CharList r0 = (p014it.unimi.dsi.fastutil.chars.CharList) r0
            it.unimi.dsi.fastutil.chars.CharListIterator r0 = r0.listIterator()
            r8 = r0
        L_0x003e:
            r0 = r6
            int r6 = r6 + -1
            if (r0 == 0) goto L_0x0058
            r0 = r7
            char r0 = r0.nextChar()
            r1 = r8
            char r1 = r1.nextChar()
            if (r0 == r1) goto L_0x003e
            r0 = 0
            return r0
        L_0x0058:
            r0 = 1
            return r0
        L_0x005a:
            r0 = r3
            it.unimi.dsi.fastutil.chars.CharListIterator r0 = r0.listIterator()
            r7 = r0
            r0 = r5
            java.util.ListIterator r0 = r0.listIterator()
            r8 = r0
        L_0x0068:
            r0 = r6
            int r6 = r6 + -1
            if (r0 == 0) goto L_0x0085
            r0 = r7
            java.lang.Object r0 = r0.next()
            r1 = r8
            java.lang.Object r1 = r1.next()
            boolean r0 = java.util.Objects.equals(r0, r1)
            if (r0 != 0) goto L_0x0068
            r0 = 0
            return r0
        L_0x0085:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.AbstractCharList.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
    /* JADX WARN: Type inference failed for: r0v27, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(java.util.List<? extends java.lang.Character> r4) {
        /*
            r3 = this;
            r0 = r4
            r1 = r3
            if (r0 != r1) goto L_0x0007
            r0 = 0
            return r0
        L_0x0007:
            r0 = r4
            boolean r0 = r0 instanceof p014it.unimi.dsi.fastutil.chars.CharList
            if (r0 == 0) goto L_0x006b
            r0 = r3
            it.unimi.dsi.fastutil.chars.CharListIterator r0 = r0.listIterator()
            r5 = r0
            r0 = r4
            it.unimi.dsi.fastutil.chars.CharList r0 = (p014it.unimi.dsi.fastutil.chars.CharList) r0
            it.unimi.dsi.fastutil.chars.CharListIterator r0 = r0.listIterator()
            r6 = r0
        L_0x001d:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x004f
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x004f
            r0 = r5
            char r0 = r0.nextChar()
            r8 = r0
            r0 = r6
            char r0 = r0.nextChar()
            r9 = r0
            r0 = r8
            r1 = r9
            int r0 = java.lang.Character.compare(r0, r1)
            r1 = r0
            r7 = r1
            if (r0 == 0) goto L_0x001d
            r0 = r7
            return r0
        L_0x004f:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x005c
            r0 = -1
            goto L_0x006a
        L_0x005c:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0069
            r0 = 1
            goto L_0x006a
        L_0x0069:
            r0 = 0
        L_0x006a:
            return r0
        L_0x006b:
            r0 = r3
            it.unimi.dsi.fastutil.chars.CharListIterator r0 = r0.listIterator()
            r5 = r0
            r0 = r4
            java.util.ListIterator r0 = r0.listIterator()
            r6 = r0
        L_0x0077:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00a6
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00a6
            r0 = r5
            java.lang.Object r0 = r0.next()
            java.lang.Comparable r0 = (java.lang.Comparable) r0
            r1 = r6
            java.lang.Object r1 = r1.next()
            int r0 = r0.compareTo(r1)
            r1 = r0
            r7 = r1
            if (r0 == 0) goto L_0x0077
            r0 = r7
            return r0
        L_0x00a6:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00b3
            r0 = -1
            goto L_0x00c1
        L_0x00b3:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00c0
            r0 = 1
            goto L_0x00c1
        L_0x00c0:
            r0 = 0
        L_0x00c1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.AbstractCharList.compareTo(java.util.List):int");
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharStack
    public void push(char o) {
        add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharStack
    public char popChar() {
        if (!isEmpty()) {
            return removeChar(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharStack
    public char topChar() {
        if (!isEmpty()) {
            return getChar(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharStack
    public char peekChar(int i) {
        return getChar((size() - 1) - i);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean rem(char k) {
        int index = indexOf(k);
        if (index == -1) {
            return false;
        }
        removeChar(index);
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public char[] toCharArray() {
        int size = size();
        char[] ret = new char[size];
        getElements(0, ret, 0, size);
        return ret;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public char[] toArray(char[] a) {
        int size = size();
        if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        getElements(0, a, 0, size);
        return a;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharList
    public boolean addAll(int index, CharCollection c) {
        ensureIndex(index);
        CharIterator i = c.iterator();
        boolean retVal = i.hasNext();
        while (i.hasNext()) {
            index++;
            add(index, i.nextChar());
        }
        return retVal;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
    public boolean addAll(CharCollection c) {
        return addAll(size(), c);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder();
        CharIterator i = iterator();
        int n = size();
        boolean first = true;
        s.append("[");
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
                s.append("]");
                return s.toString();
            }
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractCharList$CharSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractCharList$CharSubList.class */
    public static class CharSubList extends AbstractCharList implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;

        /* renamed from: l */
        protected final CharList f1313l;
        protected final int from;

        /* renamed from: to */
        protected int f1314to;
        static final /* synthetic */ boolean $assertionsDisabled;

        /* Return type fixed from 'java.util.ListIterator' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator<Character> listIterator() {
            return listIterator();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(List<? extends Character> list) {
            return compareTo(list);
        }

        static {
            $assertionsDisabled = !AbstractCharList.class.desiredAssertionStatus();
        }

        public CharSubList(CharList l, int from, int to) {
            this.f1313l = l;
            this.from = from;
            this.f1314to = to;
        }

        /* access modifiers changed from: private */
        public boolean assertRange() {
            if (!$assertionsDisabled && this.from > this.f1313l.size()) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && this.f1314to > this.f1313l.size()) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.f1314to >= this.from) {
                return true;
            } else {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean add(char k) {
            this.f1313l.add(this.f1314to, k);
            this.f1314to++;
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public void add(int index, char k) {
            ensureIndex(index);
            this.f1313l.add(this.from + index, k);
            this.f1314to++;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, java.util.List
        public boolean addAll(int index, Collection<? extends Character> c) {
            ensureIndex(index);
            this.f1314to += c.size();
            return this.f1313l.addAll(this.from + index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public char getChar(int index) {
            ensureRestrictedIndex(index);
            return this.f1313l.getChar(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public char removeChar(int index) {
            ensureRestrictedIndex(index);
            this.f1314to--;
            return this.f1313l.removeChar(this.from + index);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public char set(int index, char k) {
            ensureRestrictedIndex(index);
            return this.f1313l.set(this.from + index, k);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f1314to - this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public void getElements(int from, char[] a, int offset, int length) {
            ensureIndex(from);
            if (from + length > size()) {
                throw new IndexOutOfBoundsException("End index (" + from + length + ") is greater than list size (" + size() + ")");
            }
            this.f1313l.getElements(this.from + from, a, offset, length);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public void removeElements(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            this.f1313l.removeElements(this.from + from, this.from + to);
            this.f1314to -= to - from;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public void addElements(int index, char[] a, int offset, int length) {
            ensureIndex(index);
            this.f1313l.addElements(this.from + index, a, offset, length);
            this.f1314to += length;
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public void setElements(int index, char[] a, int offset, int length) {
            ensureIndex(index);
            this.f1313l.setElements(this.from + index, a, offset, length);
            if (!$assertionsDisabled && !assertRange()) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.chars.AbstractCharList$CharSubList$RandomAccessIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractCharList$CharSubList$RandomAccessIter.class */
        public final class RandomAccessIter extends CharIterators.AbstractIndexBasedListIterator {
            static final /* synthetic */ boolean $assertionsDisabled;

            static {
                $assertionsDisabled = !AbstractCharList.class.desiredAssertionStatus();
            }

            RandomAccessIter(int pos) {
                super(0, pos);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedIterator
            protected final char get(int i) {
                return CharSubList.this.f1313l.getChar(CharSubList.this.from + i);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedListIterator
            protected final void add(int i, char k) {
                CharSubList.this.add(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedListIterator
            protected final void set(int i, char k) {
                CharSubList.this.set(i, k);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedIterator
            protected final void remove(int i) {
                CharSubList.this.removeChar(i);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedIterator
            protected final int getMaxPos() {
                return CharSubList.this.f1314to - CharSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedListIterator, p014it.unimi.dsi.fastutil.chars.CharListIterator
            public void add(char k) {
                add(k);
                if (!$assertionsDisabled && !CharSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.AbstractIndexBasedIterator, java.util.Iterator, p014it.unimi.dsi.fastutil.chars.CharListIterator, java.util.ListIterator
            public void remove() {
                remove();
                if (!$assertionsDisabled && !CharSubList.this.assertRange()) {
                    throw new AssertionError();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: it.unimi.dsi.fastutil.chars.AbstractCharList$CharSubList$ParentWrappingIter */
        /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractCharList$CharSubList$ParentWrappingIter.class */
        public class ParentWrappingIter implements CharListIterator {
            private CharListIterator parent;

            ParentWrappingIter(CharListIterator parent) {
                this.parent = parent;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.parent.nextIndex() - CharSubList.this.from;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.parent.previousIndex() - CharSubList.this.from;
            }

            @Override // java.util.Iterator, java.util.ListIterator
            public boolean hasNext() {
                return this.parent.nextIndex() < CharSubList.this.f1314to;
            }

            @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
            public boolean hasPrevious() {
                return this.parent.previousIndex() >= CharSubList.this.from;
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
            public char nextChar() {
                if (hasNext()) {
                    return this.parent.nextChar();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
            public char previousChar() {
                if (hasPrevious()) {
                    return this.parent.previousChar();
                }
                throw new NoSuchElementException();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator
            public void add(char k) {
                this.parent.add(k);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator
            public void set(char k) {
                this.parent.set(k);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator, java.util.Iterator, java.util.ListIterator
            public void remove() {
                this.parent.remove();
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
            public int back(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int currentPos = this.parent.previousIndex();
                int parentNewPos = currentPos - n;
                if (parentNewPos < CharSubList.this.from - 1) {
                    parentNewPos = CharSubList.this.from - 1;
                }
                return this.parent.back(parentNewPos - currentPos);
            }

            @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.chars.CharIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
            public int skip(int n) {
                if (n < 0) {
                    throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                }
                int currentPos = this.parent.nextIndex();
                int parentNewPos = currentPos + n;
                if (parentNewPos > CharSubList.this.f1314to) {
                    parentNewPos = CharSubList.this.f1314to;
                }
                return this.parent.skip(parentNewPos - currentPos);
            }
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
        /* JADX WARN: Type inference failed for: r3v2, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public ListIterator<Character> listIterator(int index) {
            ensureIndex(index);
            return this.f1313l instanceof RandomAccess ? new RandomAccessIter(index) : new ParentWrappingIter(this.f1313l.listIterator(index + this.from));
        }

        @Override // java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
        public CharSpliterator spliterator() {
            return this.f1313l instanceof RandomAccess ? new IndexBasedSpliterator(this.f1313l, this.from, this.f1314to) : spliterator();
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public List<Character> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new CharSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.AbstractCharCollection, p014it.unimi.dsi.fastutil.chars.CharCollection
        public boolean rem(char k) {
            int index = indexOf(k);
            if (index == -1) {
                return false;
            }
            this.f1314to--;
            this.f1313l.removeChar(this.from + index);
            if ($assertionsDisabled || assertRange()) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList
        public boolean addAll(int index, CharCollection c) {
            ensureIndex(index);
            return addAll(index, c);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharList
        public boolean addAll(int index, CharList l) {
            ensureIndex(index);
            return addAll(index, l);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.AbstractCharList$CharRandomAccessSubList */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractCharList$CharRandomAccessSubList.class */
    public static class CharRandomAccessSubList extends CharSubList implements RandomAccess {
        private static final long serialVersionUID = -107070782945191929L;

        public CharRandomAccessSubList(CharList l, int from, int to) {
            super(l, from, to);
        }

        /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharList' to match base method */
        @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharList.CharSubList, p014it.unimi.dsi.fastutil.chars.AbstractCharList, p014it.unimi.dsi.fastutil.chars.CharList, java.util.List
        public List<Character> subList(int from, int to) {
            ensureIndex(from);
            ensureIndex(to);
            if (from <= to) {
                return new CharRandomAccessSubList(this, from, to);
            }
            throw new IllegalArgumentException("Start index (" + from + ") is greater than end index (" + to + ")");
        }
    }
}
