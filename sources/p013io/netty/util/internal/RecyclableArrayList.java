package p013io.netty.util.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import p013io.netty.util.internal.ObjectPool;

/* renamed from: io.netty.util.internal.RecyclableArrayList */
/* loaded from: grasscutter.jar:io/netty/util/internal/RecyclableArrayList.class */
public final class RecyclableArrayList extends ArrayList<Object> {
    private static final long serialVersionUID = -8605125654176467947L;
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private static final ObjectPool<RecyclableArrayList> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<RecyclableArrayList>() { // from class: io.netty.util.internal.RecyclableArrayList.1
        @Override // p013io.netty.util.internal.ObjectPool.ObjectCreator
        public RecyclableArrayList newObject(ObjectPool.Handle<RecyclableArrayList> handle) {
            return new RecyclableArrayList(handle);
        }
    });
    private boolean insertSinceRecycled;
    private final ObjectPool.Handle<RecyclableArrayList> handle;

    public static RecyclableArrayList newInstance() {
        return newInstance(8);
    }

    public static RecyclableArrayList newInstance(int minCapacity) {
        RecyclableArrayList ret = RECYCLER.get();
        ret.ensureCapacity(minCapacity);
        return ret;
    }

    private RecyclableArrayList(ObjectPool.Handle<RecyclableArrayList> handle) {
        this(handle, 8);
    }

    private RecyclableArrayList(ObjectPool.Handle<RecyclableArrayList> handle, int initialCapacity) {
        super(initialCapacity);
        this.handle = handle;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<?> c) {
        checkNullElements(c);
        if (!addAll(c)) {
            return false;
        }
        this.insertSinceRecycled = true;
        return true;
    }

    @Override // java.util.ArrayList, java.util.List, java.util.AbstractList
    public boolean addAll(int index, Collection<?> c) {
        checkNullElements(c);
        if (!addAll(index, c)) {
            return false;
        }
        this.insertSinceRecycled = true;
        return true;
    }

    private static void checkNullElements(Collection<?> c) {
        if (!(c instanceof RandomAccess) || !(c instanceof List)) {
            Iterator<?> it = c.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("c contains null values");
                }
            }
            return;
        }
        List<?> list = (List) c;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == null) {
                throw new IllegalArgumentException("c contains null values");
            }
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(Object element) {
        if (!add(ObjectUtil.checkNotNull(element, "element"))) {
            return false;
        }
        this.insertSinceRecycled = true;
        return true;
    }

    @Override // java.util.ArrayList, java.util.List, java.util.AbstractList
    public void add(int index, Object element) {
        add(index, ObjectUtil.checkNotNull(element, "element"));
        this.insertSinceRecycled = true;
    }

    @Override // java.util.ArrayList, java.util.List, java.util.AbstractList
    public Object set(int index, Object element) {
        Object old = set(index, ObjectUtil.checkNotNull(element, "element"));
        this.insertSinceRecycled = true;
        return old;
    }

    public boolean insertSinceRecycled() {
        return this.insertSinceRecycled;
    }

    public boolean recycle() {
        clear();
        this.insertSinceRecycled = false;
        this.handle.recycle(this);
        return true;
    }
}
