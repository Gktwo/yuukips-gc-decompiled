package kotlin.collections.builders;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.builtins.Tmux;
import org.jline.console.Printer;
import org.jline.reader.LineReader;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;
import p001ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

/* compiled from: ListBuilder.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��r\n\u0002\u0018\u0002\n��\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010��\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0003\b��\u0018��*\u0004\b��\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001VB\u0007\b\u0016¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bBM\b\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028��0\r\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028��\u0018\u00010��\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028��\u0018\u00010��¢\u0006\u0002\u0010\u0014J\u0015\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028��H\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001b\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028��H\u0016¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028��0#H\u0016J\u0016\u0010!\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028��0#H\u0016J&\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028��0#2\u0006\u0010&\u001a\u00020\nH\u0002J\u001d\u0010'\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028��H\u0002¢\u0006\u0002\u0010 J\f\u0010(\u001a\b\u0012\u0004\u0012\u00028��0)J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0016J\u0014\u0010,\u001a\u00020\u00112\n\u0010-\u001a\u0006\u0012\u0002\b\u00030)H\u0002J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\nH\u0002J\u0010\u00100\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\nH\u0002J\u0013\u00101\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u000102H\u0002J\u0016\u00103\u001a\u00028��2\u0006\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0002\u00104J\b\u00105\u001a\u00020\nH\u0016J\u0015\u00106\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028��H\u0016¢\u0006\u0002\u00107J\u0018\u00108\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\b\u00109\u001a\u00020\u0011H\u0016J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00028��0;H\u0002J\u0015\u0010<\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028��H\u0016¢\u0006\u0002\u00107J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00028��0>H\u0016J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00028��0>2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0015\u0010?\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028��H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010@\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028��0#H\u0016J\u0015\u0010A\u001a\u00028��2\u0006\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0002\u00104J\u0015\u0010B\u001a\u00028��2\u0006\u0010%\u001a\u00020\nH\u0002¢\u0006\u0002\u00104J\u0018\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\nH\u0002J\u0016\u0010F\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028��0#H\u0016J.\u0010G\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028��0#2\u0006\u0010H\u001a\u00020\u0011H\u0002J\u001e\u0010I\u001a\u00028��2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028��H\u0002¢\u0006\u0002\u0010JJ\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00028��0\u00022\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\nH\u0016J\u0015\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\rH\u0016¢\u0006\u0002\u0010OJ'\u0010N\u001a\b\u0012\u0004\u0012\u0002HP0\r\"\u0004\b\u0001\u0010P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HP0\rH\u0016¢\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u000202H\u0002R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028��0\rX\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028��\u0018\u00010��X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0016\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n��R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n��R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n��R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028��\u0018\u00010��X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0018\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006W"}, m373d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "initialCapacity", "", "(I)V", "array", "", "offset", "length", "isReadOnly", "", "backing", "root", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "isEffectivelyReadOnly", "()Z", "size", "getSize", "()I", BeanUtil.PREFIX_ADDER, "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", IntegerTokenConverter.CONVERTER_KEY, "n", "addAtInternal", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "", "checkIsMutable", LineReader.CLEAR, "contentEquals", "other", "ensureCapacity", "minCapacity", "ensureExtraCapacity", "equals", "", BeanUtil.PREFIX_GETTER_GET, "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", "T", "destination", "([Ljava/lang/Object;)[Ljava/lang/Object;", Printer.TO_STRING, "", "writeReplace", "Itr", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/collections/builders/ListBuilder.class */
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
    @NotNull
    private E[] array;
    private int offset;
    private int length;
    private boolean isReadOnly;
    @Nullable
    private final ListBuilder<E> backing;
    @Nullable
    private final ListBuilder<E> root;

    private ListBuilder(E[] eArr, int offset, int length, boolean isReadOnly, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = offset;
        this.length = length;
        this.isReadOnly = isReadOnly;
        this.backing = listBuilder;
        this.root = listBuilder2;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int initialCapacity) {
        this(ListBuilderKt.arrayOfUninitializedElements(initialCapacity), 0, 0, false, null, null);
    }

    @NotNull
    public final List<E> build() {
        if (this.backing != null) {
            throw new IllegalStateException();
        }
        checkIsMutable();
        this.isReadOnly = true;
        return this;
    }

    private final Object writeReplace() {
        if (isEffectivelyReadOnly()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.length;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
        return this.array[this.offset + index];
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int index, E e) {
        checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
        E e2 = this.array[this.offset + index];
        this.array[this.offset + index] = e;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        for (int i = 0; i < this.length; i++) {
            if (Intrinsics.areEqual(this.array[this.offset + i], element)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        for (int i = this.length - 1; i >= 0; i--) {
            if (Intrinsics.areEqual(this.array[this.offset + i], element)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<E> iterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator(int index) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
        return new Itr(this, index);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean add(E e) {
        checkIsMutable();
        addAtInternal(this.offset + this.length, e);
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int index, E e) {
        checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
        addAtInternal(this.offset + index, e);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        checkIsMutable();
        int n = collection.size();
        addAllInternal(this.offset + this.length, collection, n);
        return n > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, @NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
        int n = collection.size();
        addAllInternal(this.offset + index, collection, n);
        return n > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public void clear() {
        checkIsMutable();
        removeRangeInternal(this.offset, this.length);
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int index) {
        checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
        return removeAtInternal(this.offset + index);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean remove(Object element) {
        checkIsMutable();
        int i = indexOf(element);
        if (i >= 0) {
            remove(i);
        }
        return i >= 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.Collection<? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, collection, false) > 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.Collection<? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public List<E> subList(int fromIndex, int toIndex) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.length);
        E[] eArr = this.array;
        int i = this.offset + fromIndex;
        int i2 = toIndex - fromIndex;
        boolean z = this.isReadOnly;
        ListBuilder<E> listBuilder = this.root;
        if (listBuilder == null) {
            listBuilder = this;
        }
        return new ListBuilder(eArr, i, i2, z, this, listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "destination");
        if (tArr.length < this.length) {
            T[] tArr2 = (T[]) Arrays.copyOfRange(this.array, this.offset, this.offset + this.length, tArr.getClass());
            Intrinsics.checkNotNullExpressionValue(tArr2, "copyOfRange(array, offse…h, destination.javaClass)");
            return tArr2;
        }
        ArraysKt.copyInto(this.array, tArr, 0, this.offset, this.offset + this.length);
        if (tArr.length > this.length) {
            tArr[this.length] = null;
        }
        return tArr;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    @NotNull
    public Object[] toArray() {
        return ArraysKt.copyOfRange(this.array, this.offset, this.offset + this.length);
    }

    @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public boolean equals(@Nullable Object other) {
        return other == this || ((other instanceof List) && contentEquals((List) other));
    }

    @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public int hashCode() {
        return ListBuilderKt.access$subarrayContentHashCode(this.array, this.offset, this.length);
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    @NotNull
    public String toString() {
        return ListBuilderKt.access$subarrayContentToString(this.array, this.offset, this.length);
    }

    private final void ensureCapacity(int minCapacity) {
        if (this.backing != null) {
            throw new IllegalStateException();
        } else if (minCapacity < 0) {
            throw new OutOfMemoryError();
        } else if (minCapacity > this.array.length) {
            this.array = (E[]) ListBuilderKt.copyOfUninitializedElements(this.array, ArrayDeque.Companion.newCapacity$kotlin_stdlib(this.array.length, minCapacity));
        }
    }

    private final void checkIsMutable() {
        if (isEffectivelyReadOnly()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean isEffectivelyReadOnly() {
        return this.isReadOnly || (this.root != null && this.root.isReadOnly);
    }

    private final void ensureExtraCapacity(int n) {
        ensureCapacity(this.length + n);
    }

    private final boolean contentEquals(List<?> list) {
        return ListBuilderKt.access$subarrayContentEquals(this.array, this.offset, this.length, list);
    }

    private final void insertAtInternal(int i, int n) {
        ensureExtraCapacity(n);
        ArraysKt.copyInto(this.array, this.array, i + n, i, this.offset + this.length);
        this.length += n;
    }

    private final void addAtInternal(int i, E e) {
        if (this.backing != null) {
            this.backing.addAtInternal(i, e);
            this.array = this.backing.array;
            this.length++;
            return;
        }
        insertAtInternal(i, 1);
        this.array[i] = e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: E[] */
    /* JADX WARN: Multi-variable type inference failed */
    private final void addAllInternal(int i, Collection<? extends E> collection, int n) {
        if (this.backing != null) {
            this.backing.addAllInternal(i, collection, n);
            this.array = this.backing.array;
            this.length += n;
            return;
        }
        insertAtInternal(i, n);
        Iterator it = collection.iterator();
        for (int j = 0; j < n; j++) {
            this.array[i + j] = it.next();
        }
    }

    private final E removeAtInternal(int i) {
        if (this.backing != null) {
            this.length--;
            return this.backing.removeAtInternal(i);
        }
        E e = this.array[i];
        ArraysKt.copyInto(this.array, this.array, i, i + 1, this.offset + this.length);
        ListBuilderKt.resetAt(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e;
    }

    private final void removeRangeInternal(int rangeOffset, int rangeLength) {
        if (this.backing != null) {
            this.backing.removeRangeInternal(rangeOffset, rangeLength);
        } else {
            ArraysKt.copyInto(this.array, this.array, rangeOffset, rangeOffset + rangeLength, this.length);
            ListBuilderKt.resetRange(this.array, this.length - rangeLength, this.length);
        }
        this.length -= rangeLength;
    }

    private final int retainOrRemoveAllInternal(int rangeOffset, int rangeLength, Collection<? extends E> collection, boolean retain) {
        if (this.backing != null) {
            int removed = this.backing.retainOrRemoveAllInternal(rangeOffset, rangeLength, collection, retain);
            this.length -= removed;
            return removed;
        }
        int i = 0;
        int j = 0;
        while (i < rangeLength) {
            if (collection.contains(this.array[rangeOffset + i]) == retain) {
                j++;
                i++;
                this.array[rangeOffset + j] = this.array[rangeOffset + i];
            } else {
                i++;
            }
        }
        int removed2 = rangeLength - j;
        ArraysKt.copyInto(this.array, this.array, rangeOffset + j, rangeOffset + rangeLength, this.length);
        ListBuilderKt.resetRange(this.array, this.length - removed2, this.length);
        this.length -= removed2;
        return removed2;
    }

    /* compiled from: ListBuilder.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��*\n\u0002\u0018\u0002\n��\n\u0002\u0010+\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018��*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\r\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n��¨\u0006\u0017"}, m373d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "lastIndex", BeanUtil.PREFIX_ADDER, "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", Tmux.CMD_NEXT, "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/collections/builders/ListBuilder$Itr.class */
    private static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        @NotNull
        private final ListBuilder<E> list;
        private int index;
        private int lastIndex = -1;

        public Itr(@NotNull ListBuilder<E> listBuilder, int index) {
            Intrinsics.checkNotNullParameter(listBuilder, "list");
            this.list = listBuilder;
            this.index = index;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < ((ListBuilder) this.list).length;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (this.index <= 0) {
                throw new NoSuchElementException();
            }
            this.index--;
            this.lastIndex = this.index;
            return (E) ((ListBuilder) this.list).array[((ListBuilder) this.list).offset + this.lastIndex];
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.index >= ((ListBuilder) this.list).length) {
                throw new NoSuchElementException();
            }
            int i = this.index;
            this.index = i + 1;
            this.lastIndex = i;
            return (E) ((ListBuilder) this.list).array[((ListBuilder) this.list).offset + this.lastIndex];
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            if (!(this.lastIndex != -1)) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.list.set(this.lastIndex, e);
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            ListBuilder<E> listBuilder = this.list;
            int i = this.index;
            this.index = i + 1;
            listBuilder.add(i, e);
            this.lastIndex = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            if (!(this.lastIndex != -1)) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.list.remove(this.lastIndex);
            this.index = this.lastIndex;
            this.lastIndex = -1;
        }
    }
}
