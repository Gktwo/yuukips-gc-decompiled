package nonapi.p019io.github.classgraph.json;

/* renamed from: nonapi.io.github.classgraph.json.ReferenceEqualityKey */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/json/ReferenceEqualityKey.class */
public class ReferenceEqualityKey<K> {
    private final K wrappedKey;

    public ReferenceEqualityKey(K wrappedKey) {
        this.wrappedKey = wrappedKey;
    }

    public K get() {
        return this.wrappedKey;
    }

    public int hashCode() {
        K key = this.wrappedKey;
        if (key == null) {
            return 0;
        }
        return System.identityHashCode(key);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof ReferenceEqualityKey) && this.wrappedKey == ((ReferenceEqualityKey) obj).wrappedKey;
    }

    public String toString() {
        K key = this.wrappedKey;
        return key == null ? "null" : key.toString();
    }
}
