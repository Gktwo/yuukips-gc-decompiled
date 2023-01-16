package org.bson;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.Channels;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.bson.p022io.ByteBufferBsonInput;
import org.bson.types.BSONTimestamp;
import org.bson.types.Binary;
import org.bson.types.Code;
import org.bson.types.CodeWScope;
import org.bson.types.MaxKey;
import org.bson.types.MinKey;
import org.bson.types.Symbol;

/* loaded from: grasscutter.jar:org/bson/LazyBSONObject.class */
public class LazyBSONObject implements BSONObject {
    private final byte[] bytes;
    private final int offset;
    private final LazyBSONCallback callback;

    public LazyBSONObject(byte[] bytes, LazyBSONCallback callback) {
        this(bytes, 0, callback);
    }

    public LazyBSONObject(byte[] bytes, int offset, LazyBSONCallback callback) {
        this.bytes = bytes;
        this.callback = callback;
        this.offset = offset;
    }

    protected int getOffset() {
        return this.offset;
    }

    protected byte[] getBytes() {
        return this.bytes;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r6 = readValue(r0);
     */
    @Override // org.bson.BSONObject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object get(java.lang.String r4) {
        /*
            r3 = this;
            r0 = r3
            org.bson.BsonBinaryReader r0 = r0.getBsonReader()
            r5 = r0
            r0 = r5
            r0.readStartDocument()     // Catch: all -> 0x0037
            r0 = 0
            r6 = r0
        L_0x000b:
            r0 = r5
            org.bson.BsonType r0 = r0.readBsonType()     // Catch: all -> 0x0037
            org.bson.BsonType r1 = org.bson.BsonType.END_OF_DOCUMENT     // Catch: all -> 0x0037
            if (r0 == r1) goto L_0x0030
            r0 = r4
            r1 = r5
            java.lang.String r1 = r1.readName()     // Catch: all -> 0x0037
            boolean r0 = r0.equals(r1)     // Catch: all -> 0x0037
            if (r0 == 0) goto L_0x0029
            r0 = r3
            r1 = r5
            java.lang.Object r0 = r0.readValue(r1)     // Catch: all -> 0x0037
            r6 = r0
            goto L_0x0030
        L_0x0029:
            r0 = r5
            r0.skipValue()     // Catch: all -> 0x0037
            goto L_0x000b
        L_0x0030:
            r0 = r5
            r0.close()
            goto L_0x0040
        L_0x0037:
            r7 = move-exception
            r0 = r5
            r0.close()
            r0 = r7
            throw r0
        L_0x0040:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bson.LazyBSONObject.get(java.lang.String):java.lang.Object");
    }

    @Override // org.bson.BSONObject
    public boolean containsField(String s) {
        BsonBinaryReader reader = getBsonReader();
        try {
            reader.readStartDocument();
            while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
                if (reader.readName().equals(s)) {
                    return true;
                }
                reader.skipValue();
            }
            reader.close();
            return false;
        } finally {
            reader.close();
        }
    }

    @Override // org.bson.BSONObject
    public Set<String> keySet() {
        Set<String> keys = new LinkedHashSet<>();
        BsonBinaryReader reader = getBsonReader();
        try {
            reader.readStartDocument();
            while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
                keys.add(reader.readName());
                reader.skipValue();
            }
            reader.readEndDocument();
            return Collections.unmodifiableSet(keys);
        } finally {
            reader.close();
        }
    }

    Object readValue(BsonBinaryReader reader) {
        switch (reader.getCurrentBsonType()) {
            case DOCUMENT:
                return readDocument(reader);
            case ARRAY:
                return readArray(reader);
            case DOUBLE:
                return Double.valueOf(reader.readDouble());
            case STRING:
                return reader.readString();
            case BINARY:
                byte binarySubType = reader.peekBinarySubType();
                BsonBinary binary = reader.readBinaryData();
                if (binarySubType == BsonBinarySubType.BINARY.getValue() || binarySubType == BsonBinarySubType.OLD_BINARY.getValue()) {
                    return binary.getData();
                }
                return new Binary(binary.getType(), binary.getData());
            case NULL:
                reader.readNull();
                return null;
            case UNDEFINED:
                reader.readUndefined();
                return null;
            case OBJECT_ID:
                return reader.readObjectId();
            case BOOLEAN:
                return Boolean.valueOf(reader.readBoolean());
            case DATE_TIME:
                return new Date(reader.readDateTime());
            case REGULAR_EXPRESSION:
                BsonRegularExpression regularExpression = reader.readRegularExpression();
                return Pattern.compile(regularExpression.getPattern(), BSON.regexFlags(regularExpression.getOptions()));
            case DB_POINTER:
                BsonDbPointer dbPointer = reader.readDBPointer();
                return this.callback.createDBRef(dbPointer.getNamespace(), dbPointer.getId());
            case JAVASCRIPT:
                return new Code(reader.readJavaScript());
            case SYMBOL:
                return new Symbol(reader.readSymbol());
            case JAVASCRIPT_WITH_SCOPE:
                return new CodeWScope(reader.readJavaScriptWithScope(), (BSONObject) readJavaScriptWithScopeDocument(reader));
            case INT32:
                return Integer.valueOf(reader.readInt32());
            case TIMESTAMP:
                BsonTimestamp timestamp = reader.readTimestamp();
                return new BSONTimestamp(timestamp.getTime(), timestamp.getInc());
            case INT64:
                return Long.valueOf(reader.readInt64());
            case DECIMAL128:
                return reader.readDecimal128();
            case MIN_KEY:
                reader.readMinKey();
                return new MinKey();
            case MAX_KEY:
                reader.readMaxKey();
                return new MaxKey();
            default:
                throw new IllegalArgumentException("unhandled BSON type: " + reader.getCurrentBsonType());
        }
    }

    private Object readArray(BsonBinaryReader reader) {
        int position = reader.getBsonInput().getPosition();
        reader.skipValue();
        return this.callback.createArray(this.bytes, this.offset + position);
    }

    private Object readDocument(BsonBinaryReader reader) {
        int position = reader.getBsonInput().getPosition();
        reader.skipValue();
        return this.callback.createObject(this.bytes, this.offset + position);
    }

    private Object readJavaScriptWithScopeDocument(BsonBinaryReader reader) {
        int position = reader.getBsonInput().getPosition();
        reader.readStartDocument();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            reader.skipName();
            reader.skipValue();
        }
        reader.readEndDocument();
        return this.callback.createObject(this.bytes, this.offset + position);
    }

    BsonBinaryReader getBsonReader() {
        return new BsonBinaryReader(new ByteBufferBsonInput(new ByteBufNIO(getBufferForInternalBytes())));
    }

    private ByteBuffer getBufferForInternalBytes() {
        ByteBuffer buffer = ByteBuffer.wrap(this.bytes, this.offset, this.bytes.length - this.offset).slice();
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.limit(buffer.getInt());
        buffer.rewind();
        return buffer;
    }

    public boolean isEmpty() {
        return keySet().size() == 0;
    }

    public int getBSONSize() {
        return getBufferForInternalBytes().getInt();
    }

    public int pipe(OutputStream os) throws IOException {
        return Channels.newChannel(os).write(getBufferForInternalBytes());
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        final List<Map.Entry<String, Object>> entries = new ArrayList<>();
        BsonBinaryReader reader = getBsonReader();
        try {
            reader.readStartDocument();
            while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
                entries.add(new AbstractMap.SimpleImmutableEntry<>(reader.readName(), readValue(reader)));
            }
            reader.readEndDocument();
            return new Set<Map.Entry<String, Object>>() { // from class: org.bson.LazyBSONObject.1
                @Override // java.util.Set, java.util.Collection
                public int size() {
                    return entries.size();
                }

                @Override // java.util.Set, java.util.Collection
                public boolean isEmpty() {
                    return entries.isEmpty();
                }

                @Override // java.util.Set, java.util.Collection, java.lang.Iterable
                public Iterator<Map.Entry<String, Object>> iterator() {
                    return entries.iterator();
                }

                @Override // java.util.Set, java.util.Collection
                public Object[] toArray() {
                    return entries.toArray();
                }

                @Override // java.util.Set, java.util.Collection
                public <T> T[] toArray(T[] a) {
                    return (T[]) entries.toArray(a);
                }

                @Override // java.util.Set, java.util.Collection
                public boolean contains(Object o) {
                    return entries.contains(o);
                }

                @Override // java.util.Set, java.util.Collection
                public boolean containsAll(Collection<?> c) {
                    return entries.containsAll(c);
                }

                public boolean add(Map.Entry<String, Object> stringObjectEntry) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Set, java.util.Collection
                public boolean remove(Object o) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Set, java.util.Collection
                public boolean addAll(Collection<? extends Map.Entry<String, Object>> c) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Set, java.util.Collection
                public boolean retainAll(Collection<?> c) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Set, java.util.Collection
                public boolean removeAll(Collection<?> c) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Set, java.util.Collection
                public void clear() {
                    throw new UnsupportedOperationException();
                }
            };
        } finally {
            reader.close();
        }
    }

    public int hashCode() {
        int result = 1;
        int size = getBSONSize();
        for (int i = this.offset; i < this.offset + size; i++) {
            result = (31 * result) + this.bytes[i];
        }
        return result;
    }

    public boolean equals(Object o) {
        byte b;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LazyBSONObject other = (LazyBSONObject) o;
        if (this.bytes == other.bytes && this.offset == other.offset) {
            return true;
        }
        if (this.bytes == null || other.bytes == null || this.bytes.length == 0 || other.bytes.length == 0 || other.bytes[other.offset] != (b = this.bytes[this.offset])) {
            return false;
        }
        for (int i = 0; i < b; i++) {
            if (this.bytes[this.offset + i] != other.bytes[other.offset + i]) {
                return false;
            }
        }
        return true;
    }

    @Override // org.bson.BSONObject
    public Object put(String key, Object v) {
        throw new UnsupportedOperationException("Object is read only");
    }

    @Override // org.bson.BSONObject
    public void putAll(BSONObject o) {
        throw new UnsupportedOperationException("Object is read only");
    }

    @Override // org.bson.BSONObject
    public void putAll(Map m) {
        throw new UnsupportedOperationException("Object is read only");
    }

    @Override // org.bson.BSONObject
    public Object removeField(String key) {
        throw new UnsupportedOperationException("Object is read only");
    }

    @Override // org.bson.BSONObject
    public Map toMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return Collections.unmodifiableMap(map);
    }
}
