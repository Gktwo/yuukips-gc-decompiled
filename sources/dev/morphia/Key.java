package dev.morphia;

import com.mongodb.lang.Nullable;
import dev.morphia.mapping.codec.references.MorphiaProxy;
import java.io.Serializable;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/Key.class */
public class Key<T> implements Serializable, Comparable<Key<T>> {
    @Nullable
    private String collection;
    @Nullable
    private Class<? extends T> type;

    /* renamed from: id */
    private Object f462id;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Key) ((Key) obj));
    }

    protected Key() {
    }

    public Key(Class<? extends T> type, @Nullable String collection, Object id) {
        this.type = (Class<? extends T>) (MorphiaProxy.class.isAssignableFrom(type) ? type.getSuperclass() : type);
        this.collection = collection;
        this.f462id = id;
    }

    public Key(Class<? extends T> type, String collection) {
        this.type = type;
        this.collection = collection;
    }

    private static int compareNullable(@Nullable Comparable o1, @Nullable Comparable o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.compareTo(o2);
    }

    public int compareTo(Key<T> other) {
        int cmp;
        checkState(this);
        checkState(other);
        if (other.type != null && this.type != null && (cmp = this.type.getName().compareTo(other.type.getName())) != 0) {
            return cmp;
        }
        int cmp2 = compareNullable(this.collection, other.collection);
        if (cmp2 != 0) {
            return cmp2;
        }
        try {
            int cmp3 = compareNullable((Comparable) this.f462id, (Comparable) other.f462id);
            if (cmp3 != 0) {
                return cmp3;
            }
            return 0;
        } catch (Exception e) {
            if ((this.f462id.equals(other.f462id) ? 0 : 1) != 0) {
                return this.f462id.toString().compareTo(other.f462id.toString());
            }
            return 0;
        }
    }

    @Nullable
    public String getCollection() {
        return this.collection;
    }

    public void setCollection(@Nullable String collection) {
        this.collection = collection;
    }

    public Object getId() {
        return this.f462id;
    }

    @Nullable
    public Class<? extends T> getType() {
        return this.type;
    }

    public void setType(Class<? extends T> clazz) {
        this.type = clazz;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.f462id.hashCode();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof Key) && compareTo((Key) ((Key) obj)) == 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder bld = new StringBuilder("Key{");
        if (this.collection != null) {
            bld.append("collection=");
            bld.append(this.collection);
        } else if (this.type != null) {
            bld.append("type=");
            bld.append(this.type.getName());
        }
        bld.append(", id=");
        bld.append(this.f462id);
        bld.append("}");
        return bld.toString();
    }

    private void checkState(Key k) {
        if (k.type == null && k.collection == null) {
            throw new IllegalStateException("Collection must be specified (or a class).");
        } else if (k.f462id == null) {
            throw new IllegalStateException("id must be specified");
        }
    }
}
