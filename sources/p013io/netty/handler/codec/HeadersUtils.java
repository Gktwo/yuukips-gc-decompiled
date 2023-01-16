package p013io.netty.handler.codec;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.HttpUrl;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.HeadersUtils */
/* loaded from: grasscutter.jar:io/netty/handler/codec/HeadersUtils.class */
public final class HeadersUtils {
    private HeadersUtils() {
    }

    public static <K, V> List<String> getAllAsString(Headers<K, V, ?> headers, K name) {
        final List<V> allNames = headers.getAll(name);
        return new AbstractList<String>() { // from class: io.netty.handler.codec.HeadersUtils.1
            @Override // java.util.AbstractList, java.util.List
            public String get(int index) {
                Object obj = allNames.get(index);
                if (obj != null) {
                    return obj.toString();
                }
                return null;
            }

            @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
            public int size() {
                return allNames.size();
            }
        };
    }

    public static <K, V> String getAsString(Headers<K, V, ?> headers, K name) {
        V orig = headers.get(name);
        if (orig != null) {
            return orig.toString();
        }
        return null;
    }

    public static Iterator<Map.Entry<String, String>> iteratorAsString(Iterable<Map.Entry<CharSequence, CharSequence>> headers) {
        return new StringEntryIterator(headers.iterator());
    }

    public static <K, V> String toString(Class<?> headersClass, Iterator<Map.Entry<K, V>> headersIt, int size) {
        String simpleName = headersClass.getSimpleName();
        if (size == 0) {
            return simpleName + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(simpleName.length() + 2 + (size * 20)).append(simpleName).append('[');
        while (headersIt.hasNext()) {
            Map.Entry<K, V> next = headersIt.next();
            sb.append(next.getKey()).append(": ").append(next.getValue()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.append(']').toString();
    }

    public static Set<String> namesAsString(Headers<CharSequence, CharSequence, ?> headers) {
        return new CharSequenceDelegatingStringSet(headers.names());
    }

    /* renamed from: io.netty.handler.codec.HeadersUtils$StringEntryIterator */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/HeadersUtils$StringEntryIterator.class */
    private static final class StringEntryIterator implements Iterator<Map.Entry<String, String>> {
        private final Iterator<Map.Entry<CharSequence, CharSequence>> iter;

        StringEntryIterator(Iterator<Map.Entry<CharSequence, CharSequence>> iter) {
            this.iter = iter;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<String, String> next() {
            return new StringEntry(this.iter.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iter.remove();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.codec.HeadersUtils$StringEntry */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/HeadersUtils$StringEntry.class */
    public static final class StringEntry implements Map.Entry<String, String> {
        private final Map.Entry<CharSequence, CharSequence> entry;
        private String name;
        private String value;

        StringEntry(Map.Entry<CharSequence, CharSequence> entry) {
            this.entry = entry;
        }

        @Override // java.util.Map.Entry
        public String getKey() {
            if (this.name == null) {
                this.name = this.entry.getKey().toString();
            }
            return this.name;
        }

        @Override // java.util.Map.Entry
        public String getValue() {
            if (this.value == null && this.entry.getValue() != null) {
                this.value = this.entry.getValue().toString();
            }
            return this.value;
        }

        public String setValue(String value) {
            String old = getValue();
            this.entry.setValue(value);
            return old;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.entry.toString();
        }
    }

    /* renamed from: io.netty.handler.codec.HeadersUtils$StringIterator */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/HeadersUtils$StringIterator.class */
    private static final class StringIterator<T> implements Iterator<String> {
        private final Iterator<T> iter;

        StringIterator(Iterator<T> iter) {
            this.iter = iter;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public String next() {
            T next = this.iter.next();
            if (next != null) {
                return next.toString();
            }
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iter.remove();
        }
    }

    /* renamed from: io.netty.handler.codec.HeadersUtils$CharSequenceDelegatingStringSet */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/HeadersUtils$CharSequenceDelegatingStringSet.class */
    private static final class CharSequenceDelegatingStringSet extends DelegatingStringSet<CharSequence> {
        CharSequenceDelegatingStringSet(Set<CharSequence> allNames) {
            super(allNames);
        }

        public boolean add(String e) {
            return this.allNames.add(e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends String> c) {
            return this.allNames.addAll(c);
        }
    }

    /* renamed from: io.netty.handler.codec.HeadersUtils$DelegatingStringSet */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/HeadersUtils$DelegatingStringSet.class */
    private static abstract class DelegatingStringSet<T> extends AbstractCollection<String> implements Set<String> {
        protected final Set<T> allNames;

        DelegatingStringSet(Set<T> allNames) {
            this.allNames = (Set) ObjectUtil.checkNotNull(allNames, "allNames");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.allNames.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.allNames.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            return this.allNames.contains(o.toString());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<String> iterator() {
            return new StringIterator(this.allNames.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            return this.allNames.remove(o);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.allNames.clear();
        }
    }
}
