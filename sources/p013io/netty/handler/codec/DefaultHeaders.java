package p013io.netty.handler.codec;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import p013io.netty.handler.codec.Headers;
import p013io.netty.util.HashingStrategy;
import p013io.netty.util.internal.MathUtil;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.DefaultHeaders */
/* loaded from: grasscutter.jar:io/netty/handler/codec/DefaultHeaders.class */
public class DefaultHeaders<K, V, T extends Headers<K, V, T>> implements Headers<K, V, T> {
    static final int HASH_CODE_SEED = -1028477387;
    private final HeaderEntry<K, V>[] entries;
    protected final HeaderEntry<K, V> head;
    private final byte hashMask;
    private final ValueConverter<V> valueConverter;
    private final NameValidator<K> nameValidator;
    private final HashingStrategy<K> hashingStrategy;
    int size;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* renamed from: io.netty.handler.codec.DefaultHeaders$NameValidator */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/DefaultHeaders$NameValidator.class */
    public interface NameValidator<K> {
        public static final NameValidator NOT_NULL = new NameValidator() { // from class: io.netty.handler.codec.DefaultHeaders.NameValidator.1
            @Override // p013io.netty.handler.codec.DefaultHeaders.NameValidator
            public void validateName(Object name) {
                ObjectUtil.checkNotNull(name, "name");
            }
        };

        void validateName(K k);
    }

    static {
        $assertionsDisabled = !DefaultHeaders.class.desiredAssertionStatus();
    }

    public DefaultHeaders(ValueConverter<V> valueConverter) {
        this(HashingStrategy.JAVA_HASHER, valueConverter);
    }

    public DefaultHeaders(ValueConverter<V> valueConverter, NameValidator<K> nameValidator) {
        this(HashingStrategy.JAVA_HASHER, valueConverter, nameValidator);
    }

    public DefaultHeaders(HashingStrategy<K> nameHashingStrategy, ValueConverter<V> valueConverter) {
        this(nameHashingStrategy, valueConverter, NameValidator.NOT_NULL);
    }

    public DefaultHeaders(HashingStrategy<K> nameHashingStrategy, ValueConverter<V> valueConverter, NameValidator<K> nameValidator) {
        this(nameHashingStrategy, valueConverter, nameValidator, 16);
    }

    public DefaultHeaders(HashingStrategy<K> nameHashingStrategy, ValueConverter<V> valueConverter, NameValidator<K> nameValidator, int arraySizeHint) {
        this.valueConverter = (ValueConverter) ObjectUtil.checkNotNull(valueConverter, "valueConverter");
        this.nameValidator = (NameValidator) ObjectUtil.checkNotNull(nameValidator, "nameValidator");
        this.hashingStrategy = (HashingStrategy) ObjectUtil.checkNotNull(nameHashingStrategy, "nameHashingStrategy");
        this.entries = new HeaderEntry[MathUtil.findNextPositivePowerOfTwo(Math.max(2, Math.min(arraySizeHint, 128)))];
        this.hashMask = (byte) (this.entries.length - 1);
        this.head = new HeaderEntry<>();
    }

    @Override // p013io.netty.handler.codec.Headers
    public V get(K name) {
        ObjectUtil.checkNotNull(name, "name");
        int h = this.hashingStrategy.hashCode(name);
        V value = null;
        for (HeaderEntry<K, V> e = this.entries[index(h)]; e != null; e = e.next) {
            if (e.hash == h && this.hashingStrategy.equals(name, e.key)) {
                value = e.value;
            }
        }
        return value;
    }

    @Override // p013io.netty.handler.codec.Headers
    public V get(K name, V defaultValue) {
        V value = get(name);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.netty.handler.codec.DefaultHeaders<K, V, T extends io.netty.handler.codec.Headers<K, V, T>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.handler.codec.Headers
    public V getAndRemove(K name) {
        int h = this.hashingStrategy.hashCode(name);
        return (V) remove0(h, index(h), ObjectUtil.checkNotNull(name, "name"));
    }

    @Override // p013io.netty.handler.codec.Headers
    public V getAndRemove(K name, V defaultValue) {
        V value = getAndRemove(name);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    @Override // p013io.netty.handler.codec.Headers
    public List<V> getAll(K name) {
        ObjectUtil.checkNotNull(name, "name");
        LinkedList<V> values = new LinkedList<>();
        int h = this.hashingStrategy.hashCode(name);
        for (HeaderEntry<K, V> e = this.entries[index(h)]; e != null; e = e.next) {
            if (e.hash == h && this.hashingStrategy.equals(name, e.key)) {
                values.addFirst(e.getValue());
            }
        }
        return values;
    }

    public Iterator<V> valueIterator(K name) {
        return new ValueIterator(name);
    }

    @Override // p013io.netty.handler.codec.Headers
    public List<V> getAllAndRemove(K name) {
        List<V> all = getAll(name);
        remove(name);
        return all;
    }

    @Override // p013io.netty.handler.codec.Headers
    public boolean contains(K name) {
        return get(name) != null;
    }

    @Override // p013io.netty.handler.codec.Headers
    public boolean containsObject(K name, Object value) {
        return contains(name, this.valueConverter.convertObject(ObjectUtil.checkNotNull(value, "value")));
    }

    @Override // p013io.netty.handler.codec.Headers
    public boolean containsBoolean(K name, boolean value) {
        return contains(name, this.valueConverter.convertBoolean(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public boolean containsByte(K name, byte value) {
        return contains(name, this.valueConverter.convertByte(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public boolean containsChar(K name, char value) {
        return contains(name, this.valueConverter.convertChar(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public boolean containsShort(K name, short value) {
        return contains(name, this.valueConverter.convertShort(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public boolean containsInt(K name, int value) {
        return contains(name, this.valueConverter.convertInt(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public boolean containsLong(K name, long value) {
        return contains(name, this.valueConverter.convertLong(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public boolean containsFloat(K name, float value) {
        return contains(name, this.valueConverter.convertFloat(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public boolean containsDouble(K name, double value) {
        return contains(name, this.valueConverter.convertDouble(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public boolean containsTimeMillis(K name, long value) {
        return contains(name, this.valueConverter.convertTimeMillis(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public boolean contains(K name, V value) {
        return contains(name, value, HashingStrategy.JAVA_HASHER);
    }

    /* JADX DEBUG: Type inference failed for r2v3. Raw type applied. Possible types: V, ? super V */
    public final boolean contains(K name, V value, HashingStrategy<? super V> valueHashingStrategy) {
        ObjectUtil.checkNotNull(name, "name");
        int h = this.hashingStrategy.hashCode(name);
        for (HeaderEntry<K, V> e = this.entries[index(h)]; e != null; e = e.next) {
            if (e.hash == h && this.hashingStrategy.equals(name, e.key) && valueHashingStrategy.equals(value, (V) e.value)) {
                return true;
            }
        }
        return false;
    }

    @Override // p013io.netty.handler.codec.Headers
    public int size() {
        return this.size;
    }

    @Override // p013io.netty.handler.codec.Headers
    public boolean isEmpty() {
        return this.head == this.head.after;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Set<K> names() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        Set<K> names = new LinkedHashSet<>(size());
        for (HeaderEntry<K, V> e = this.head.after; e != this.head; e = e.after) {
            names.add(e.getKey());
        }
        return names;
    }

    @Override // p013io.netty.handler.codec.Headers
    public T add(K name, V value) {
        this.nameValidator.validateName(name);
        ObjectUtil.checkNotNull(value, "value");
        int h = this.hashingStrategy.hashCode(name);
        add0(h, index(h), name, value);
        return thisT();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.netty.handler.codec.DefaultHeaders<K, V, T extends io.netty.handler.codec.Headers<K, V, T>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.handler.codec.Headers
    public T add(K name, Iterable<? extends V> values) {
        this.nameValidator.validateName(name);
        int h = this.hashingStrategy.hashCode(name);
        int i = index(h);
        Iterator<? extends V> it = values.iterator();
        while (it.hasNext()) {
            add0(h, i, name, it.next());
        }
        return (T) thisT();
    }

    @Override // p013io.netty.handler.codec.Headers
    public T add(K name, V... values) {
        this.nameValidator.validateName(name);
        int h = this.hashingStrategy.hashCode(name);
        int i = index(h);
        for (V v : values) {
            add0(h, i, name, v);
        }
        return thisT();
    }

    @Override // p013io.netty.handler.codec.Headers
    public T addObject(K name, Object value) {
        return add((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertObject(ObjectUtil.checkNotNull(value, "value")));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T addObject(K name, Iterable<?> values) {
        Iterator<?> it = values.iterator();
        while (it.hasNext()) {
            addObject((DefaultHeaders<K, V, T>) name, it.next());
        }
        return thisT();
    }

    @Override // p013io.netty.handler.codec.Headers
    public T addObject(K name, Object... values) {
        for (Object value : values) {
            addObject((DefaultHeaders<K, V, T>) name, value);
        }
        return thisT();
    }

    @Override // p013io.netty.handler.codec.Headers
    public T addInt(K name, int value) {
        return add((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertInt(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T addLong(K name, long value) {
        return add((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertLong(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T addDouble(K name, double value) {
        return add((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertDouble(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T addTimeMillis(K name, long value) {
        return add((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertTimeMillis(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T addChar(K name, char value) {
        return add((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertChar(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T addBoolean(K name, boolean value) {
        return add((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertBoolean(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T addFloat(K name, float value) {
        return add((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertFloat(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T addByte(K name, byte value) {
        return add((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertByte(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T addShort(K name, short value) {
        return add((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertShort(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T add(Headers<? extends K, ? extends V, ?> headers) {
        if (headers == this) {
            throw new IllegalArgumentException("can't add to itself.");
        }
        addImpl(headers);
        return thisT();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.netty.handler.codec.DefaultHeaders<K, V, T extends io.netty.handler.codec.Headers<K, V, T>> */
    /* JADX WARN: Multi-variable type inference failed */
    protected void addImpl(Headers<? extends K, ? extends V, ?> headers) {
        if (headers instanceof DefaultHeaders) {
            DefaultHeaders<? extends K, ? extends V, T> defaultHeaders = (DefaultHeaders) headers;
            HeaderEntry<K, V> headerEntry = defaultHeaders.head.after;
            if (defaultHeaders.hashingStrategy == this.hashingStrategy && defaultHeaders.nameValidator == this.nameValidator) {
                while (headerEntry != defaultHeaders.head) {
                    add0(headerEntry.hash, index(headerEntry.hash), headerEntry.key, headerEntry.value);
                    headerEntry = headerEntry.after;
                }
                return;
            }
            while (headerEntry != defaultHeaders.head) {
                add((DefaultHeaders<K, V, T>) headerEntry.key, (K) headerEntry.value);
                headerEntry = headerEntry.after;
            }
            return;
        }
        for (Map.Entry<? extends K, ? extends V> header : headers) {
            add((DefaultHeaders<K, V, T>) header.getKey(), header.getValue());
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public T set(K name, V value) {
        this.nameValidator.validateName(name);
        ObjectUtil.checkNotNull(value, "value");
        int h = this.hashingStrategy.hashCode(name);
        int i = index(h);
        remove0(h, i, name);
        add0(h, i, name, value);
        return thisT();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.netty.handler.codec.DefaultHeaders<K, V, T extends io.netty.handler.codec.Headers<K, V, T>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.handler.codec.Headers
    public T set(K name, Iterable<? extends V> values) {
        Object next;
        this.nameValidator.validateName(name);
        ObjectUtil.checkNotNull(values, "values");
        int h = this.hashingStrategy.hashCode(name);
        int i = index(h);
        remove0(h, i, name);
        Iterator<? extends V> it = values.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            add0(h, i, name, next);
        }
        return (T) thisT();
    }

    @Override // p013io.netty.handler.codec.Headers
    public T set(K name, V... values) {
        V v;
        this.nameValidator.validateName(name);
        ObjectUtil.checkNotNull(values, "values");
        int h = this.hashingStrategy.hashCode(name);
        int i = index(h);
        remove0(h, i, name);
        int length = values.length;
        int i2 = 0;
        while (i2 < length && (v = values[i2]) != null) {
            add0(h, i, name, v);
            i2++;
        }
        return thisT();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.netty.handler.codec.DefaultHeaders<K, V, T extends io.netty.handler.codec.Headers<K, V, T>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.handler.codec.Headers
    public T setObject(K name, Object value) {
        ObjectUtil.checkNotNull(value, "value");
        return (T) set((DefaultHeaders<K, V, T>) name, (K) ObjectUtil.checkNotNull(this.valueConverter.convertObject(value), "convertedValue"));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T setObject(K name, Iterable<?> values) {
        Object v;
        this.nameValidator.validateName(name);
        int h = this.hashingStrategy.hashCode(name);
        int i = index(h);
        remove0(h, i, name);
        Iterator<?> it = values.iterator();
        while (it.hasNext() && (v = it.next()) != null) {
            add0(h, i, name, this.valueConverter.convertObject(v));
        }
        return thisT();
    }

    @Override // p013io.netty.handler.codec.Headers
    public T setObject(K name, Object... values) {
        Object v;
        this.nameValidator.validateName(name);
        int h = this.hashingStrategy.hashCode(name);
        int i = index(h);
        remove0(h, i, name);
        int length = values.length;
        int i2 = 0;
        while (i2 < length && (v = values[i2]) != null) {
            add0(h, i, name, this.valueConverter.convertObject(v));
            i2++;
        }
        return thisT();
    }

    @Override // p013io.netty.handler.codec.Headers
    public T setInt(K name, int value) {
        return set((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertInt(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T setLong(K name, long value) {
        return set((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertLong(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T setDouble(K name, double value) {
        return set((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertDouble(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T setTimeMillis(K name, long value) {
        return set((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertTimeMillis(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T setFloat(K name, float value) {
        return set((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertFloat(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T setChar(K name, char value) {
        return set((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertChar(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T setBoolean(K name, boolean value) {
        return set((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertBoolean(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T setByte(K name, byte value) {
        return set((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertByte(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T setShort(K name, short value) {
        return set((DefaultHeaders<K, V, T>) name, (K) this.valueConverter.convertShort(value));
    }

    @Override // p013io.netty.handler.codec.Headers
    public T set(Headers<? extends K, ? extends V, ?> headers) {
        if (headers != this) {
            clear();
            addImpl(headers);
        }
        return thisT();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: io.netty.handler.codec.DefaultHeaders<K, V, T extends io.netty.handler.codec.Headers<K, V, T>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.handler.codec.Headers
    public T setAll(Headers<? extends K, ? extends V, ?> headers) {
        if (headers != this) {
            Iterator<? extends K> it = headers.names().iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            addImpl(headers);
        }
        return (T) thisT();
    }

    @Override // p013io.netty.handler.codec.Headers
    public boolean remove(K name) {
        return getAndRemove(name) != null;
    }

    @Override // p013io.netty.handler.codec.Headers
    public T clear() {
        Arrays.fill(this.entries, (Object) null);
        HeaderEntry<K, V> headerEntry = this.head;
        HeaderEntry<K, V> headerEntry2 = this.head;
        HeaderEntry<K, V> headerEntry3 = this.head;
        headerEntry2.after = headerEntry3;
        headerEntry.before = headerEntry3;
        this.size = 0;
        return thisT();
    }

    @Override // p013io.netty.handler.codec.Headers, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new HeaderIterator();
    }

    @Override // p013io.netty.handler.codec.Headers
    public Boolean getBoolean(K name) {
        V v = get(name);
        if (v == null) {
            return null;
        }
        try {
            return Boolean.valueOf(this.valueConverter.convertToBoolean(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public boolean getBoolean(K name, boolean defaultValue) {
        Boolean v = getBoolean(name);
        return v != null ? v.booleanValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Byte getByte(K name) {
        V v = get(name);
        if (v == null) {
            return null;
        }
        try {
            return Byte.valueOf(this.valueConverter.convertToByte(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public byte getByte(K name, byte defaultValue) {
        Byte v = getByte(name);
        return v != null ? v.byteValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Character getChar(K name) {
        V v = get(name);
        if (v == null) {
            return null;
        }
        try {
            return Character.valueOf(this.valueConverter.convertToChar(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public char getChar(K name, char defaultValue) {
        Character v = getChar(name);
        return v != null ? v.charValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Short getShort(K name) {
        V v = get(name);
        if (v == null) {
            return null;
        }
        try {
            return Short.valueOf(this.valueConverter.convertToShort(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public short getShort(K name, short defaultValue) {
        Short v = getShort(name);
        return v != null ? v.shortValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Integer getInt(K name) {
        V v = get(name);
        if (v == null) {
            return null;
        }
        try {
            return Integer.valueOf(this.valueConverter.convertToInt(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public int getInt(K name, int defaultValue) {
        Integer v = getInt(name);
        return v != null ? v.intValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Long getLong(K name) {
        V v = get(name);
        if (v == null) {
            return null;
        }
        try {
            return Long.valueOf(this.valueConverter.convertToLong(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public long getLong(K name, long defaultValue) {
        Long v = getLong(name);
        return v != null ? v.longValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Float getFloat(K name) {
        V v = get(name);
        if (v == null) {
            return null;
        }
        try {
            return Float.valueOf(this.valueConverter.convertToFloat(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public float getFloat(K name, float defaultValue) {
        Float v = getFloat(name);
        return v != null ? v.floatValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Double getDouble(K name) {
        V v = get(name);
        if (v == null) {
            return null;
        }
        try {
            return Double.valueOf(this.valueConverter.convertToDouble(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public double getDouble(K name, double defaultValue) {
        Double v = getDouble(name);
        return v != null ? v.doubleValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Long getTimeMillis(K name) {
        V v = get(name);
        if (v == null) {
            return null;
        }
        try {
            return Long.valueOf(this.valueConverter.convertToTimeMillis(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public long getTimeMillis(K name, long defaultValue) {
        Long v = getTimeMillis(name);
        return v != null ? v.longValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Boolean getBooleanAndRemove(K name) {
        V v = getAndRemove(name);
        if (v == null) {
            return null;
        }
        try {
            return Boolean.valueOf(this.valueConverter.convertToBoolean(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public boolean getBooleanAndRemove(K name, boolean defaultValue) {
        Boolean v = getBooleanAndRemove(name);
        return v != null ? v.booleanValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Byte getByteAndRemove(K name) {
        V v = getAndRemove(name);
        if (v == null) {
            return null;
        }
        try {
            return Byte.valueOf(this.valueConverter.convertToByte(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public byte getByteAndRemove(K name, byte defaultValue) {
        Byte v = getByteAndRemove(name);
        return v != null ? v.byteValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Character getCharAndRemove(K name) {
        V v = getAndRemove(name);
        if (v == null) {
            return null;
        }
        try {
            return Character.valueOf(this.valueConverter.convertToChar(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public char getCharAndRemove(K name, char defaultValue) {
        Character v = getCharAndRemove(name);
        return v != null ? v.charValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Short getShortAndRemove(K name) {
        V v = getAndRemove(name);
        if (v == null) {
            return null;
        }
        try {
            return Short.valueOf(this.valueConverter.convertToShort(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public short getShortAndRemove(K name, short defaultValue) {
        Short v = getShortAndRemove(name);
        return v != null ? v.shortValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Integer getIntAndRemove(K name) {
        V v = getAndRemove(name);
        if (v == null) {
            return null;
        }
        try {
            return Integer.valueOf(this.valueConverter.convertToInt(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public int getIntAndRemove(K name, int defaultValue) {
        Integer v = getIntAndRemove(name);
        return v != null ? v.intValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Long getLongAndRemove(K name) {
        V v = getAndRemove(name);
        if (v == null) {
            return null;
        }
        try {
            return Long.valueOf(this.valueConverter.convertToLong(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public long getLongAndRemove(K name, long defaultValue) {
        Long v = getLongAndRemove(name);
        return v != null ? v.longValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Float getFloatAndRemove(K name) {
        V v = getAndRemove(name);
        if (v == null) {
            return null;
        }
        try {
            return Float.valueOf(this.valueConverter.convertToFloat(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public float getFloatAndRemove(K name, float defaultValue) {
        Float v = getFloatAndRemove(name);
        return v != null ? v.floatValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Double getDoubleAndRemove(K name) {
        V v = getAndRemove(name);
        if (v == null) {
            return null;
        }
        try {
            return Double.valueOf(this.valueConverter.convertToDouble(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public double getDoubleAndRemove(K name, double defaultValue) {
        Double v = getDoubleAndRemove(name);
        return v != null ? v.doubleValue() : defaultValue;
    }

    @Override // p013io.netty.handler.codec.Headers
    public Long getTimeMillisAndRemove(K name) {
        V v = getAndRemove(name);
        if (v == null) {
            return null;
        }
        try {
            return Long.valueOf(this.valueConverter.convertToTimeMillis(v));
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override // p013io.netty.handler.codec.Headers
    public long getTimeMillisAndRemove(K name, long defaultValue) {
        Long v = getTimeMillisAndRemove(name);
        return v != null ? v.longValue() : defaultValue;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (!(o instanceof Headers)) {
            return false;
        }
        return equals((Headers) o, HashingStrategy.JAVA_HASHER);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return hashCode(HashingStrategy.JAVA_HASHER);
    }

    public final boolean equals(Headers<K, V, ?> h2, HashingStrategy<V> valueHashingStrategy) {
        if (h2.size() != size()) {
            return false;
        }
        if (this == h2) {
            return true;
        }
        for (K name : names()) {
            List<V> otherValues = h2.getAll(name);
            List<V> values = getAll(name);
            if (otherValues.size() != values.size()) {
                return false;
            }
            for (int i = 0; i < otherValues.size(); i++) {
                if (!valueHashingStrategy.equals(otherValues.get(i), values.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int hashCode(HashingStrategy<V> valueHashingStrategy) {
        int result = HASH_CODE_SEED;
        for (K name : names()) {
            result = (31 * result) + this.hashingStrategy.hashCode(name);
            List<V> values = getAll(name);
            for (int i = 0; i < values.size(); i++) {
                result = (31 * result) + valueHashingStrategy.hashCode(values.get(i));
            }
        }
        return result;
    }

    @Override // java.lang.Object
    public String toString() {
        return HeadersUtils.toString(getClass(), iterator(), size());
    }

    protected HeaderEntry<K, V> newHeaderEntry(int h, K name, V value, HeaderEntry<K, V> next) {
        return new HeaderEntry<>(h, name, value, next, this.head);
    }

    protected ValueConverter<V> valueConverter() {
        return this.valueConverter;
    }

    /* access modifiers changed from: private */
    public int index(int hash) {
        return hash & this.hashMask;
    }

    private void add0(int h, int i, K name, V value) {
        this.entries[i] = newHeaderEntry(h, name, value, this.entries[i]);
        this.size++;
    }

    private V remove0(int h, int i, K name) {
        HeaderEntry<K, V> e = this.entries[i];
        if (e == null) {
            return null;
        }
        V value = null;
        for (HeaderEntry<K, V> next = e.next; next != null; next = e.next) {
            if (next.hash != h || !this.hashingStrategy.equals(name, next.key)) {
                e = next;
            } else {
                value = next.value;
                e.next = next.next;
                next.remove();
                this.size--;
            }
        }
        HeaderEntry<K, V> e2 = this.entries[i];
        if (e2.hash == h && this.hashingStrategy.equals(name, e2.key)) {
            if (value == null) {
                value = e2.value;
            }
            this.entries[i] = e2.next;
            e2.remove();
            this.size--;
        }
        return value;
    }

    HeaderEntry<K, V> remove0(HeaderEntry<K, V> entry, HeaderEntry<K, V> previous) {
        int i = index(entry.hash);
        HeaderEntry<K, V> firstEntry = this.entries[i];
        if (firstEntry == entry) {
            this.entries[i] = entry.next;
            previous = this.entries[i];
        } else if (previous == null) {
            previous = firstEntry;
            HeaderEntry<K, V> next = firstEntry.next;
            while (next != null && next != entry) {
                previous = next;
                next = next.next;
            }
            if ($assertionsDisabled || next != null) {
                previous.next = entry.next;
            } else {
                throw new AssertionError("Entry not found in its hash bucket: " + entry);
            }
        } else {
            previous.next = entry.next;
        }
        entry.remove();
        this.size--;
        return previous;
    }

    private T thisT() {
        return this;
    }

    public DefaultHeaders<K, V, T> copy() {
        DefaultHeaders<K, V, T> copy = new DefaultHeaders<>(this.hashingStrategy, this.valueConverter, this.nameValidator, this.entries.length);
        copy.addImpl(this);
        return copy;
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.codec.DefaultHeaders$HeaderIterator */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/DefaultHeaders$HeaderIterator.class */
    public final class HeaderIterator implements Iterator<Map.Entry<K, V>> {
        private HeaderEntry<K, V> current;

        private HeaderIterator() {
            this.current = DefaultHeaders.this.head;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current.after != DefaultHeaders.this.head;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.current = this.current.after;
            if (this.current != DefaultHeaders.this.head) {
                return this.current;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("read only");
        }
    }

    /* renamed from: io.netty.handler.codec.DefaultHeaders$ValueIterator */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/DefaultHeaders$ValueIterator.class */
    private final class ValueIterator implements Iterator<V> {
        private final K name;
        private final int hash;
        private HeaderEntry<K, V> removalPrevious;
        private HeaderEntry<K, V> previous;
        private HeaderEntry<K, V> next;

        ValueIterator(K name) {
            this.name = (K) ObjectUtil.checkNotNull(name, "name");
            this.hash = DefaultHeaders.this.hashingStrategy.hashCode(name);
            calculateNext(DefaultHeaders.this.entries[DefaultHeaders.this.index(this.hash)]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public V next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.previous != null) {
                this.removalPrevious = this.previous;
            }
            this.previous = this.next;
            calculateNext(this.next.next);
            return this.previous.value;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.previous == null) {
                throw new IllegalStateException();
            }
            this.removalPrevious = DefaultHeaders.this.remove0(this.previous, this.removalPrevious);
            this.previous = null;
        }

        private void calculateNext(HeaderEntry<K, V> entry) {
            while (entry != null) {
                if (entry.hash != this.hash || !DefaultHeaders.this.hashingStrategy.equals(this.name, entry.key)) {
                    entry = entry.next;
                } else {
                    this.next = entry;
                    return;
                }
            }
            this.next = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: io.netty.handler.codec.DefaultHeaders$HeaderEntry */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/DefaultHeaders$HeaderEntry.class */
    public static class HeaderEntry<K, V> implements Map.Entry<K, V> {
        protected final int hash;
        protected final K key;
        protected V value;
        protected HeaderEntry<K, V> next;
        protected HeaderEntry<K, V> before;
        protected HeaderEntry<K, V> after;

        protected HeaderEntry(int hash, K key) {
            this.hash = hash;
            this.key = key;
        }

        HeaderEntry(int hash, K key, V value, HeaderEntry<K, V> next, HeaderEntry<K, V> head) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
            this.after = head;
            this.before = head.before;
            pointNeighborsToThis();
        }

        HeaderEntry() {
            this.hash = -1;
            this.key = null;
            this.after = this;
            this.before = this;
        }

        protected final void pointNeighborsToThis() {
            this.before.after = this;
            this.after.before = this;
        }

        public final HeaderEntry<K, V> before() {
            return this.before;
        }

        public final HeaderEntry<K, V> after() {
            return this.after;
        }

        protected void remove() {
            this.before.after = this.after;
            this.after.before = this.before;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V value) {
            ObjectUtil.checkNotNull(value, "value");
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override // java.lang.Object
        public final String toString() {
            return this.key.toString() + '=' + this.value.toString();
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> other = (Map.Entry) o;
            if (getKey() != null ? getKey().equals(other.getKey()) : other.getKey() == null) {
                if (getValue() != null ? getValue().equals(other.getValue()) : other.getValue() == null) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value == null ? 0 : this.value.hashCode());
        }
    }
}
