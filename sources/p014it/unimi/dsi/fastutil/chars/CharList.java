package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.Size64;
import p014it.unimi.dsi.fastutil.chars.AbstractCharList;

/* renamed from: it.unimi.dsi.fastutil.chars.CharList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharList.class */
public interface CharList extends List<Character>, Comparable<List<? extends Character>>, CharCollection {
    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
    CharListIterator iterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
    @Override // java.util.List
    ListIterator<Character> listIterator();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharListIterator' to match base method */
    @Override // java.util.List
    ListIterator<Character> listIterator(int i);

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharList' to match base method */
    @Override // java.util.List
    List<Character> subList(int i, int i2);

    void size(int i);

    void getElements(int i, char[] cArr, int i2, int i3);

    void removeElements(int i, int i2);

    void addElements(int i, char[] cArr);

    void addElements(int i, char[] cArr, int i2, int i3);

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
    boolean add(char c);

    void add(int i, char c);

    boolean addAll(int i, CharCollection charCollection);

    char set(int i, char c);

    char getChar(int i);

    int indexOf(char c);

    int lastIndexOf(char c);

    char removeChar(int i);

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharCollection, p014it.unimi.dsi.fastutil.chars.CharIterable
    default CharSpliterator spliterator() {
        if (this instanceof RandomAccess) {
            return new AbstractCharList.IndexBasedSpliterator(this, 0);
        }
        return CharSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 16720);
    }

    default void setElements(char[] a) {
        setElements(0, a);
    }

    default void setElements(int index, char[] a) {
        setElements(index, a, 0, a.length);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void setElements(int r7, char[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = r7
            if (r0 >= 0) goto L_0x0024
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is negative"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0024:
            r0 = r7
            r1 = r6
            int r1 = r1.size()
            if (r0 <= r1) goto L_0x005c
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Index ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
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
        L_0x005c:
            r0 = r8
            r1 = r9
            r2 = r10
            p014it.unimi.dsi.fastutil.chars.CharArrays.ensureOffsetLength(r0, r1, r2)
            r0 = r7
            r1 = r10
            int r0 = r0 + r1
            r1 = r6
            int r1 = r1.size()
            if (r0 <= r1) goto L_0x00a1
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
        L_0x00a1:
            r0 = r6
            r1 = r7
            it.unimi.dsi.fastutil.chars.CharListIterator r0 = r0.listIterator(r1)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x00ad:
            r0 = r12
            r1 = r10
            if (r0 >= r1) goto L_0x00cf
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
            goto L_0x00ad
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.CharList.setElements(int, char[], int, int):void");
    }

    @Deprecated
    default void add(int index, Character key) {
        add(index, key.charValue());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [it.unimi.dsi.fastutil.chars.CharListIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    default void replaceAll(p014it.unimi.dsi.fastutil.chars.CharUnaryOperator r5) {
        /*
            r4 = this;
            r0 = r4
            it.unimi.dsi.fastutil.chars.CharListIterator r0 = r0.listIterator()
            r6 = r0
        L_0x0007:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0025
            r0 = r6
            r1 = r5
            r2 = r6
            char r2 = r2.nextChar()
            char r1 = r1.apply(r2)
            r0.set(r1)
            goto L_0x0007
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.CharList.replaceAll(it.unimi.dsi.fastutil.chars.CharUnaryOperator):void");
    }

    default void replaceAll(IntUnaryOperator operator) {
        replaceAll(operator instanceof CharUnaryOperator ? (CharUnaryOperator) operator : x -> {
            return SafeMath.safeIntToChar(operator.applyAsInt(x));
        });
    }

    @Override // java.util.List
    @Deprecated
    default void replaceAll(UnaryOperator<Character> operator) {
        CharUnaryOperator charUnaryOperator;
        Objects.requireNonNull(operator);
        if (operator instanceof CharUnaryOperator) {
            charUnaryOperator = (CharUnaryOperator) operator;
        } else {
            Objects.requireNonNull(operator);
            charUnaryOperator = (v1) -> {
                return r1.apply(v1);
            };
        }
        replaceAll(charUnaryOperator);
    }

    @Override // java.util.List, java.util.Collection, p014it.unimi.dsi.fastutil.chars.CharCollection
    @Deprecated
    default boolean contains(Object key) {
        return contains(key);
    }

    @Override // java.util.List
    @Deprecated
    default Character get(int index) {
        return Character.valueOf(getChar(index));
    }

    @Override // java.util.List
    @Deprecated
    default int indexOf(Object o) {
        return indexOf(((Character) o).charValue());
    }

    @Override // java.util.List
    @Deprecated
    default int lastIndexOf(Object o) {
        return lastIndexOf(((Character) o).charValue());
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
    @Deprecated
    default boolean add(Character k) {
        return add(k.charValue());
    }

    @Override // java.util.List, java.util.Collection, p014it.unimi.dsi.fastutil.chars.CharCollection
    @Deprecated
    default boolean remove(Object key) {
        return remove(key);
    }

    @Override // java.util.List
    @Deprecated
    default Character remove(int index) {
        return Character.valueOf(removeChar(index));
    }

    @Deprecated
    default Character set(int index, Character k) {
        return Character.valueOf(set(index, k.charValue()));
    }

    default boolean addAll(int index, CharList l) {
        return addAll(index, (CharCollection) l);
    }

    default boolean addAll(CharList l) {
        return addAll(size(), l);
    }

    /* renamed from: of */
    static CharList m974of() {
        return CharImmutableList.m984of();
    }

    /* renamed from: of */
    static CharList m973of(char e) {
        return CharLists.singleton(e);
    }

    /* renamed from: of */
    static CharList m972of(char e0, char e1) {
        return CharImmutableList.m983of(e0, e1);
    }

    /* renamed from: of */
    static CharList m971of(char e0, char e1, char e2) {
        return CharImmutableList.m983of(e0, e1, e2);
    }

    /* renamed from: of */
    static CharList m970of(char... a) {
        switch (a.length) {
            case 0:
                return m974of();
            case 1:
                return m973of(a[0]);
            default:
                return CharImmutableList.m983of(a);
        }
    }

    @Override // java.util.List
    @Deprecated
    default void sort(Comparator<? super Character> comparator) {
        sort(CharComparators.asCharComparator(comparator));
    }

    default void sort(CharComparator comparator) {
        if (comparator == null) {
            unstableSort(comparator);
            return;
        }
        char[] elements = toCharArray();
        CharArrays.stableSort(elements, comparator);
        setElements(elements);
    }

    @Deprecated
    default void unstableSort(Comparator<? super Character> comparator) {
        unstableSort(CharComparators.asCharComparator(comparator));
    }

    default void unstableSort(CharComparator comparator) {
        char[] elements = toCharArray();
        if (comparator == null) {
            CharArrays.unstableSort(elements);
        } else {
            CharArrays.unstableSort(elements, comparator);
        }
        setElements(elements);
    }
}
