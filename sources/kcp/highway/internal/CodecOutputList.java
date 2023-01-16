package kcp.highway.internal;

import java.util.AbstractList;
import java.util.RandomAccess;
import p013io.netty.util.Recycler;
import p013io.netty.util.internal.ObjectUtil;

/* loaded from: grasscutter.jar:kcp/highway/internal/CodecOutputList.class */
public class CodecOutputList<T> extends AbstractList<T> implements RandomAccess {
    private static final Recycler<CodecOutputList> RECYCLER = new Recycler<CodecOutputList>() { // from class: kcp.highway.internal.CodecOutputList.1
        /* access modifiers changed from: protected */
        @Override // p013io.netty.util.Recycler
        public CodecOutputList newObject(Recycler.Handle<CodecOutputList> handle) {
            return new CodecOutputList(handle);
        }
    };
    private final Recycler.Handle<CodecOutputList<T>> handle;
    private int size;
    private Object[] array = new Object[16];
    private boolean insertSinceRecycled;

    public static <T> CodecOutputList<T> newInstance() {
        return RECYCLER.get();
    }

    private CodecOutputList(Recycler.Handle<CodecOutputList<T>> handle) {
        this.handle = handle;
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int index) {
        checkIndex(index);
        return (T) this.array[index];
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean add(Object element) {
        ObjectUtil.checkNotNull(element, "element");
        int newSize = this.size + 1;
        if (newSize > this.array.length) {
            expandArray();
        }
        insert(this.size, element);
        this.size = newSize;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int index, Object element) {
        ObjectUtil.checkNotNull(element, "element");
        checkIndex(index);
        T t = (T) this.array[index];
        insert(index, element);
        return t;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, Object element) {
        ObjectUtil.checkNotNull(element, "element");
        checkIndex(index);
        if (this.size == this.array.length) {
            expandArray();
        }
        if (index != this.size - 1) {
            System.arraycopy(this.array, index, this.array, index + 1, this.size - index);
        }
        insert(index, element);
        this.size++;
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int index) {
        checkIndex(index);
        T t = (T) this.array[index];
        int len = (this.size - index) - 1;
        if (len > 0) {
            System.arraycopy(this.array, index + 1, this.array, index, len);
        }
        Object[] objArr = this.array;
        int i = this.size - 1;
        this.size = i;
        objArr[i] = null;
        return t;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public void clear() {
        this.size = 0;
    }

    boolean insertSinceRecycled() {
        return this.insertSinceRecycled;
    }

    public void recycle() {
        for (int i = 0; i < this.size; i++) {
            this.array[i] = null;
        }
        clear();
        this.insertSinceRecycled = false;
        this.handle.recycle(this);
    }

    public T getUnsafe(int index) {
        return (T) this.array[index];
    }

    private void checkIndex(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void insert(int index, Object element) {
        this.array[index] = element;
        this.insertSinceRecycled = true;
    }

    private void expandArray() {
        int newCapacity = this.array.length << 1;
        if (newCapacity < 0) {
            throw new OutOfMemoryError();
        }
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(this.array, 0, newArray, 0, this.array.length);
        this.array = newArray;
    }
}
