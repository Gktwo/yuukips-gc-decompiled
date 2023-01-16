package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyField;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/protobuf/FieldSet.class */
public final class FieldSet<T extends FieldDescriptorLite<T>> {
    private static final int DEFAULT_FIELD_MAP_ARRAY_SIZE = 16;
    private final SmallSortedMap<T, Object> fields;
    private boolean isImmutable;
    private boolean hasLazyField;
    private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);

    /* loaded from: grasscutter.jar:com/google/protobuf/FieldSet$FieldDescriptorLite.class */
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        int getNumber();

        WireFormat.FieldType getLiteType();

        WireFormat.JavaType getLiteJavaType();

        boolean isRepeated();

        boolean isPacked();

        Internal.EnumLiteMap<?> getEnumType();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite);
    }

    private FieldSet() {
        this.fields = SmallSortedMap.newFieldMap(16);
    }

    private FieldSet(boolean dummy) {
        this(SmallSortedMap.newFieldMap(0));
        makeImmutable();
    }

    private FieldSet(SmallSortedMap<T, Object> fields) {
        this.fields = fields;
        makeImmutable();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet<>();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    public static <T extends FieldDescriptorLite<T>> Builder<T> newBuilder() {
        return new Builder<>();
    }

    /* access modifiers changed from: package-private */
    public boolean isEmpty() {
        return this.fields.isEmpty();
    }

    public void makeImmutable() {
        if (!this.isImmutable) {
            this.fields.makeImmutable();
            this.isImmutable = true;
        }
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FieldSet)) {
            return false;
        }
        return this.fields.equals(((FieldSet) o).fields);
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    public FieldSet<T> clone() {
        FieldSet<T> clone = newFieldSet();
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Map.Entry<T, Object> entry = this.fields.getArrayEntryAt(i);
            clone.setField(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<T, Object> entry2 : this.fields.getOverflowEntries()) {
            clone.setField(entry2.getKey(), entry2.getValue());
        }
        clone.hasLazyField = this.hasLazyField;
        return clone;
    }

    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    public Map<T, Object> getAllFields() {
        if (!this.hasLazyField) {
            return this.fields.isImmutable() ? this.fields : Collections.unmodifiableMap(this.fields);
        }
        SmallSortedMap<T, Object> result = cloneAllFieldsMap(this.fields, false);
        if (this.fields.isImmutable()) {
            result.makeImmutable();
        }
        return result;
    }

    /* access modifiers changed from: private */
    public static <T extends FieldDescriptorLite<T>> SmallSortedMap<T, Object> cloneAllFieldsMap(SmallSortedMap<T, Object> fields, boolean copyList) {
        SmallSortedMap<T, Object> result = SmallSortedMap.newFieldMap(16);
        for (int i = 0; i < fields.getNumArrayEntries(); i++) {
            cloneFieldEntry(result, fields.getArrayEntryAt(i), copyList);
        }
        for (Map.Entry<T, Object> entry : fields.getOverflowEntries()) {
            cloneFieldEntry(result, entry, copyList);
        }
        return result;
    }

    private static <T extends FieldDescriptorLite<T>> void cloneFieldEntry(Map<T, Object> map, Map.Entry<T, Object> entry, boolean copyList) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            map.put(key, ((LazyField) value).getValue());
        } else if (!copyList || !(value instanceof List)) {
            map.put(key, value);
        } else {
            map.put(key, new ArrayList((List) value));
        }
    }

    public Iterator<Map.Entry<T, Object>> iterator() {
        if (this.hasLazyField) {
            return new LazyField.LazyIterator(this.fields.entrySet().iterator());
        }
        return this.fields.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (this.hasLazyField) {
            return new LazyField.LazyIterator(this.fields.descendingEntrySet().iterator());
        }
        return this.fields.descendingEntrySet().iterator();
    }

    public boolean hasField(T descriptor) {
        if (!descriptor.isRepeated()) {
            return this.fields.get(descriptor) != null;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public Object getField(T descriptor) {
        Object o = this.fields.get(descriptor);
        if (o instanceof LazyField) {
            return ((LazyField) o).getValue();
        }
        return o;
    }

    public void setField(T descriptor, Object value) {
        if (!descriptor.isRepeated()) {
            verifyType(descriptor, value);
        } else if (!(value instanceof List)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        } else {
            List<Object> newList = new ArrayList();
            newList.addAll((List) value);
            for (Object element : newList) {
                verifyType(descriptor, element);
            }
            value = newList;
        }
        if (value instanceof LazyField) {
            this.hasLazyField = true;
        }
        this.fields.put((SmallSortedMap<T, Object>) descriptor, (T) value);
    }

    public void clearField(T descriptor) {
        this.fields.remove(descriptor);
        if (this.fields.isEmpty()) {
            this.hasLazyField = false;
        }
    }

    public int getRepeatedFieldCount(T descriptor) {
        if (!descriptor.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object value = getField(descriptor);
        if (value == null) {
            return 0;
        }
        return ((List) value).size();
    }

    public Object getRepeatedField(T descriptor, int index) {
        if (!descriptor.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object value = getField(descriptor);
        if (value != null) {
            return ((List) value).get(index);
        }
        throw new IndexOutOfBoundsException();
    }

    public void setRepeatedField(T descriptor, int index, Object value) {
        if (!descriptor.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object list = getField(descriptor);
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        verifyType(descriptor, value);
        ((List) list).set(index, value);
    }

    public void addRepeatedField(T descriptor, Object value) {
        List<Object> list;
        if (!descriptor.isRepeated()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        verifyType(descriptor, value);
        Object existingValue = getField(descriptor);
        if (existingValue == null) {
            list = new ArrayList<>();
            this.fields.put((SmallSortedMap<T, Object>) descriptor, (T) list);
        } else {
            list = (List) existingValue;
        }
        list.add(value);
    }

    private void verifyType(T descriptor, Object value) {
        if (!isValidType(descriptor.getLiteType(), value)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(descriptor.getNumber()), descriptor.getLiteType().getJavaType(), value.getClass().getName()));
        }
    }

    /* access modifiers changed from: private */
    public static boolean isValidType(WireFormat.FieldType type, Object value) {
        Internal.checkNotNull(value);
        switch (type.getJavaType()) {
            case INT:
                return value instanceof Integer;
            case LONG:
                return value instanceof Long;
            case FLOAT:
                return value instanceof Float;
            case DOUBLE:
                return value instanceof Double;
            case BOOLEAN:
                return value instanceof Boolean;
            case STRING:
                return value instanceof String;
            case BYTE_STRING:
                return (value instanceof ByteString) || (value instanceof byte[]);
            case ENUM:
                return (value instanceof Integer) || (value instanceof Internal.EnumLite);
            case MESSAGE:
                return (value instanceof MessageLite) || (value instanceof LazyField);
            default:
                return false;
        }
    }

    public boolean isInitialized() {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            if (!isInitialized(this.fields.getArrayEntryAt(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.fields.getOverflowEntries()) {
            if (!isInitialized(entry)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static <T extends FieldDescriptorLite<T>> boolean isInitialized(Map.Entry<T, Object> entry) {
        T descriptor = entry.getKey();
        if (descriptor.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        if (descriptor.isRepeated()) {
            for (MessageLite element : (List) entry.getValue()) {
                if (!element.isInitialized()) {
                    return false;
                }
            }
            return true;
        }
        Object value = entry.getValue();
        if (value instanceof MessageLite) {
            if (!((MessageLite) value).isInitialized()) {
                return false;
            }
            return true;
        } else if (value instanceof LazyField) {
            return true;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    /* access modifiers changed from: package-private */
    public static int getWireFormatForFieldType(WireFormat.FieldType type, boolean isPacked) {
        if (isPacked) {
            return 2;
        }
        return type.getWireType();
    }

    public void mergeFrom(FieldSet<T> other) {
        for (int i = 0; i < other.fields.getNumArrayEntries(); i++) {
            mergeFromField(other.fields.getArrayEntryAt(i));
        }
        for (Map.Entry<T, Object> entry : other.fields.getOverflowEntries()) {
            mergeFromField(entry);
        }
    }

    /* access modifiers changed from: private */
    public static Object cloneIfMutable(Object value) {
        if (!(value instanceof byte[])) {
            return value;
        }
        byte[] bytes = (byte[]) value;
        byte[] copy = new byte[bytes.length];
        System.arraycopy(bytes, 0, copy, 0, bytes.length);
        return copy;
    }

    private void mergeFromField(Map.Entry<T, Object> entry) {
        T descriptor = entry.getKey();
        Object otherValue = entry.getValue();
        if (otherValue instanceof LazyField) {
            otherValue = ((LazyField) otherValue).getValue();
        }
        if (descriptor.isRepeated()) {
            Object value = getField(descriptor);
            if (value == null) {
                value = new ArrayList();
            }
            for (Object element : (List) otherValue) {
                ((List) value).add(cloneIfMutable(element));
            }
            this.fields.put((SmallSortedMap<T, Object>) descriptor, (T) value);
        } else if (descriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            Object value2 = getField(descriptor);
            if (value2 == null) {
                this.fields.put((SmallSortedMap<T, Object>) descriptor, (T) cloneIfMutable(otherValue));
                return;
            }
            this.fields.put((SmallSortedMap<T, Object>) descriptor, (T) descriptor.internalMergeFrom(((MessageLite) value2).toBuilder(), (MessageLite) otherValue).build());
        } else {
            this.fields.put((SmallSortedMap<T, Object>) descriptor, (T) cloneIfMutable(otherValue));
        }
    }

    public static Object readPrimitiveField(CodedInputStream input, WireFormat.FieldType type, boolean checkUtf8) throws IOException {
        if (checkUtf8) {
            return WireFormat.readPrimitiveField(input, type, WireFormat.Utf8Validation.STRICT);
        }
        return WireFormat.readPrimitiveField(input, type, WireFormat.Utf8Validation.LOOSE);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Map.Entry<T, Object> entry = this.fields.getArrayEntryAt(i);
            writeField(entry.getKey(), entry.getValue(), output);
        }
        for (Map.Entry<T, Object> entry2 : this.fields.getOverflowEntries()) {
            writeField(entry2.getKey(), entry2.getValue(), output);
        }
    }

    public void writeMessageSetTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            writeMessageSetTo(this.fields.getArrayEntryAt(i), output);
        }
        for (Map.Entry<T, Object> entry : this.fields.getOverflowEntries()) {
            writeMessageSetTo(entry, output);
        }
    }

    private void writeMessageSetTo(Map.Entry<T, Object> entry, CodedOutputStream output) throws IOException {
        T descriptor = entry.getKey();
        if (descriptor.getLiteJavaType() != WireFormat.JavaType.MESSAGE || descriptor.isRepeated() || descriptor.isPacked()) {
            writeField(descriptor, entry.getValue(), output);
            return;
        }
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).getValue();
        }
        output.writeMessageSetExtension(entry.getKey().getNumber(), (MessageLite) value);
    }

    /* access modifiers changed from: package-private */
    public static void writeElement(CodedOutputStream output, WireFormat.FieldType type, int number, Object value) throws IOException {
        if (type == WireFormat.FieldType.GROUP) {
            output.writeGroup(number, (MessageLite) value);
            return;
        }
        output.writeTag(number, getWireFormatForFieldType(type, false));
        writeElementNoTag(output, type, value);
    }

    static void writeElementNoTag(CodedOutputStream output, WireFormat.FieldType type, Object value) throws IOException {
        switch (type) {
            case DOUBLE:
                output.writeDoubleNoTag(((Double) value).doubleValue());
                return;
            case FLOAT:
                output.writeFloatNoTag(((Float) value).floatValue());
                return;
            case INT64:
                output.writeInt64NoTag(((Long) value).longValue());
                return;
            case UINT64:
                output.writeUInt64NoTag(((Long) value).longValue());
                return;
            case INT32:
                output.writeInt32NoTag(((Integer) value).intValue());
                return;
            case FIXED64:
                output.writeFixed64NoTag(((Long) value).longValue());
                return;
            case FIXED32:
                output.writeFixed32NoTag(((Integer) value).intValue());
                return;
            case BOOL:
                output.writeBoolNoTag(((Boolean) value).booleanValue());
                return;
            case GROUP:
                output.writeGroupNoTag((MessageLite) value);
                return;
            case MESSAGE:
                output.writeMessageNoTag((MessageLite) value);
                return;
            case STRING:
                if (value instanceof ByteString) {
                    output.writeBytesNoTag((ByteString) value);
                    return;
                } else {
                    output.writeStringNoTag((String) value);
                    return;
                }
            case BYTES:
                if (value instanceof ByteString) {
                    output.writeBytesNoTag((ByteString) value);
                    return;
                } else {
                    output.writeByteArrayNoTag((byte[]) value);
                    return;
                }
            case UINT32:
                output.writeUInt32NoTag(((Integer) value).intValue());
                return;
            case SFIXED32:
                output.writeSFixed32NoTag(((Integer) value).intValue());
                return;
            case SFIXED64:
                output.writeSFixed64NoTag(((Long) value).longValue());
                return;
            case SINT32:
                output.writeSInt32NoTag(((Integer) value).intValue());
                return;
            case SINT64:
                output.writeSInt64NoTag(((Long) value).longValue());
                return;
            case ENUM:
                if (value instanceof Internal.EnumLite) {
                    output.writeEnumNoTag(((Internal.EnumLite) value).getNumber());
                    return;
                } else {
                    output.writeEnumNoTag(((Integer) value).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static void writeField(FieldDescriptorLite<?> descriptor, Object value, CodedOutputStream output) throws IOException {
        WireFormat.FieldType type = descriptor.getLiteType();
        int number = descriptor.getNumber();
        if (descriptor.isRepeated()) {
            List<?> valueList = (List) value;
            if (descriptor.isPacked()) {
                output.writeTag(number, 2);
                int dataSize = 0;
                Iterator<?> it = valueList.iterator();
                while (it.hasNext()) {
                    dataSize += computeElementSizeNoTag(type, it.next());
                }
                output.writeRawVarint32(dataSize);
                Iterator<?> it2 = valueList.iterator();
                while (it2.hasNext()) {
                    writeElementNoTag(output, type, it2.next());
                }
                return;
            }
            Iterator<?> it3 = valueList.iterator();
            while (it3.hasNext()) {
                writeElement(output, type, number, it3.next());
            }
        } else if (value instanceof LazyField) {
            writeElement(output, type, number, ((LazyField) value).getValue());
        } else {
            writeElement(output, type, number, value);
        }
    }

    public int getSerializedSize() {
        int size = 0;
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Map.Entry<T, Object> entry = this.fields.getArrayEntryAt(i);
            size += computeFieldSize(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<T, Object> entry2 : this.fields.getOverflowEntries()) {
            size += computeFieldSize(entry2.getKey(), entry2.getValue());
        }
        return size;
    }

    public int getMessageSetSerializedSize() {
        int size = 0;
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            size += getMessageSetSerializedSize(this.fields.getArrayEntryAt(i));
        }
        for (Map.Entry<T, Object> entry : this.fields.getOverflowEntries()) {
            size += getMessageSetSerializedSize(entry);
        }
        return size;
    }

    private int getMessageSetSerializedSize(Map.Entry<T, Object> entry) {
        T descriptor = entry.getKey();
        Object value = entry.getValue();
        if (descriptor.getLiteJavaType() != WireFormat.JavaType.MESSAGE || descriptor.isRepeated() || descriptor.isPacked()) {
            return computeFieldSize(descriptor, value);
        }
        if (value instanceof LazyField) {
            return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(entry.getKey().getNumber(), (LazyField) value);
        }
        return CodedOutputStream.computeMessageSetExtensionSize(entry.getKey().getNumber(), (MessageLite) value);
    }

    /* access modifiers changed from: package-private */
    public static int computeElementSize(WireFormat.FieldType type, int number, Object value) {
        int tagSize = CodedOutputStream.computeTagSize(number);
        if (type == WireFormat.FieldType.GROUP) {
            tagSize *= 2;
        }
        return tagSize + computeElementSizeNoTag(type, value);
    }

    static int computeElementSizeNoTag(WireFormat.FieldType type, Object value) {
        switch (type) {
            case DOUBLE:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) value).doubleValue());
            case FLOAT:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) value).floatValue());
            case INT64:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) value).longValue());
            case UINT64:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) value).longValue());
            case INT32:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) value).intValue());
            case FIXED64:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) value).longValue());
            case FIXED32:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) value).intValue());
            case BOOL:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) value).booleanValue());
            case GROUP:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) value);
            case MESSAGE:
                if (value instanceof LazyField) {
                    return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) value);
                }
                return CodedOutputStream.computeMessageSizeNoTag((MessageLite) value);
            case STRING:
                if (value instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString) value);
                }
                return CodedOutputStream.computeStringSizeNoTag((String) value);
            case BYTES:
                if (value instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString) value);
                }
                return CodedOutputStream.computeByteArraySizeNoTag((byte[]) value);
            case UINT32:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) value).intValue());
            case SFIXED32:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) value).intValue());
            case SFIXED64:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) value).longValue());
            case SINT32:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) value).intValue());
            case SINT64:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) value).longValue());
            case ENUM:
                if (value instanceof Internal.EnumLite) {
                    return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) value).getNumber());
                }
                return CodedOutputStream.computeEnumSizeNoTag(((Integer) value).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> descriptor, Object value) {
        WireFormat.FieldType type = descriptor.getLiteType();
        int number = descriptor.getNumber();
        if (!descriptor.isRepeated()) {
            return computeElementSize(type, number, value);
        }
        if (descriptor.isPacked()) {
            int dataSize = 0;
            for (Object element : (List) value) {
                dataSize += computeElementSizeNoTag(type, element);
            }
            return dataSize + CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeRawVarint32Size(dataSize);
        }
        int size = 0;
        for (Object element2 : (List) value) {
            size += computeElementSize(type, number, element2);
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/protobuf/FieldSet$Builder.class */
    public static final class Builder<T extends FieldDescriptorLite<T>> {
        private SmallSortedMap<T, Object> fields;
        private boolean hasLazyField;
        private boolean isMutable;
        private boolean hasNestedBuilders;

        private Builder() {
            this(SmallSortedMap.newFieldMap(16));
        }

        private Builder(SmallSortedMap<T, Object> fields) {
            this.fields = fields;
            this.isMutable = true;
        }

        public FieldSet<T> build() {
            if (this.fields.isEmpty()) {
                return FieldSet.emptySet();
            }
            this.isMutable = false;
            SmallSortedMap<T, Object> fieldsForBuild = this.fields;
            if (this.hasNestedBuilders) {
                fieldsForBuild = FieldSet.cloneAllFieldsMap(this.fields, false);
                replaceBuilders(fieldsForBuild);
            }
            FieldSet<T> fieldSet = new FieldSet<>(fieldsForBuild);
            ((FieldSet) fieldSet).hasLazyField = this.hasLazyField;
            return fieldSet;
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(SmallSortedMap<T, Object> fieldMap) {
            for (int i = 0; i < fieldMap.getNumArrayEntries(); i++) {
                replaceBuilders(fieldMap.getArrayEntryAt(i));
            }
            for (Map.Entry<T, Object> entry : fieldMap.getOverflowEntries()) {
                replaceBuilders(entry);
            }
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(Map.Entry<T, Object> entry) {
            entry.setValue(replaceBuilders(entry.getKey(), entry.getValue()));
        }

        private static <T extends FieldDescriptorLite<T>> Object replaceBuilders(T descriptor, Object value) {
            if (value == null) {
                return value;
            }
            if (descriptor.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
                return value;
            }
            if (!descriptor.isRepeated()) {
                return replaceBuilder(value);
            }
            if (!(value instanceof List)) {
                throw new IllegalStateException("Repeated field should contains a List but actually contains type: " + value.getClass());
            }
            List<Object> list = (List) value;
            for (int i = 0; i < list.size(); i++) {
                Object oldElement = list.get(i);
                Object newElement = replaceBuilder(oldElement);
                if (newElement != oldElement) {
                    if (list == value) {
                        list = new ArrayList<>(list);
                    }
                    list.set(i, newElement);
                }
            }
            return list;
        }

        private static Object replaceBuilder(Object value) {
            return value instanceof MessageLite.Builder ? ((MessageLite.Builder) value).build() : value;
        }

        public static <T extends FieldDescriptorLite<T>> Builder<T> fromFieldSet(FieldSet<T> fieldSet) {
            Builder<T> builder = new Builder<>(FieldSet.cloneAllFieldsMap(((FieldSet) fieldSet).fields, true));
            ((Builder) builder).hasLazyField = ((FieldSet) fieldSet).hasLazyField;
            return builder;
        }

        public Map<T, Object> getAllFields() {
            if (!this.hasLazyField) {
                return this.fields.isImmutable() ? this.fields : Collections.unmodifiableMap(this.fields);
            }
            SmallSortedMap<T, Object> result = FieldSet.cloneAllFieldsMap(this.fields, false);
            if (this.fields.isImmutable()) {
                result.makeImmutable();
            } else {
                replaceBuilders(result);
            }
            return result;
        }

        public boolean hasField(T descriptor) {
            if (!descriptor.isRepeated()) {
                return this.fields.get(descriptor) != null;
            }
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }

        public Object getField(T descriptor) {
            return replaceBuilders(descriptor, getFieldAllowBuilders(descriptor));
        }

        /* access modifiers changed from: package-private */
        public Object getFieldAllowBuilders(T descriptor) {
            Object o = this.fields.get(descriptor);
            if (o instanceof LazyField) {
                return ((LazyField) o).getValue();
            }
            return o;
        }

        private void ensureIsMutable() {
            if (!this.isMutable) {
                this.fields = FieldSet.cloneAllFieldsMap(this.fields, true);
                this.isMutable = true;
            }
        }

        public void setField(T descriptor, Object value) {
            ensureIsMutable();
            if (!descriptor.isRepeated()) {
                verifyType(descriptor, value);
            } else if (!(value instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            } else {
                List newList = new ArrayList();
                newList.addAll((List) value);
                for (Object element : newList) {
                    verifyType(descriptor, element);
                    this.hasNestedBuilders = this.hasNestedBuilders || (element instanceof MessageLite.Builder);
                }
                value = newList;
            }
            if (value instanceof LazyField) {
                this.hasLazyField = true;
            }
            this.hasNestedBuilders = this.hasNestedBuilders || (value instanceof MessageLite.Builder);
            this.fields.put((SmallSortedMap<T, Object>) descriptor, (T) value);
        }

        public void clearField(T descriptor) {
            ensureIsMutable();
            this.fields.remove(descriptor);
            if (this.fields.isEmpty()) {
                this.hasLazyField = false;
            }
        }

        public int getRepeatedFieldCount(T descriptor) {
            if (!descriptor.isRepeated()) {
                throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
            }
            Object value = getField(descriptor);
            if (value == null) {
                return 0;
            }
            return ((List) value).size();
        }

        public Object getRepeatedField(T descriptor, int index) {
            if (this.hasNestedBuilders) {
                ensureIsMutable();
            }
            return replaceBuilder(getRepeatedFieldAllowBuilders(descriptor, index));
        }

        /* access modifiers changed from: package-private */
        public Object getRepeatedFieldAllowBuilders(T descriptor, int index) {
            if (!descriptor.isRepeated()) {
                throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
            }
            Object value = getFieldAllowBuilders(descriptor);
            if (value != null) {
                return ((List) value).get(index);
            }
            throw new IndexOutOfBoundsException();
        }

        public void setRepeatedField(T descriptor, int index, Object value) {
            ensureIsMutable();
            if (!descriptor.isRepeated()) {
                throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
            }
            this.hasNestedBuilders = this.hasNestedBuilders || (value instanceof MessageLite.Builder);
            Object list = getField(descriptor);
            if (list == null) {
                throw new IndexOutOfBoundsException();
            }
            verifyType(descriptor, value);
            ((List) list).set(index, value);
        }

        public void addRepeatedField(T descriptor, Object value) {
            List<Object> list;
            ensureIsMutable();
            if (!descriptor.isRepeated()) {
                throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
            }
            this.hasNestedBuilders = this.hasNestedBuilders || (value instanceof MessageLite.Builder);
            verifyType(descriptor, value);
            Object existingValue = getField(descriptor);
            if (existingValue == null) {
                list = new ArrayList<>();
                this.fields.put((SmallSortedMap<T, Object>) descriptor, (T) list);
            } else {
                list = (List) existingValue;
            }
            list.add(value);
        }

        private void verifyType(T descriptor, Object value) {
            if (FieldSet.isValidType(descriptor.getLiteType(), value)) {
                return;
            }
            if (descriptor.getLiteType().getJavaType() != WireFormat.JavaType.MESSAGE || !(value instanceof MessageLite.Builder)) {
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(descriptor.getNumber()), descriptor.getLiteType().getJavaType(), value.getClass().getName()));
            }
        }

        public boolean isInitialized() {
            for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
                if (!FieldSet.isInitialized(this.fields.getArrayEntryAt(i))) {
                    return false;
                }
            }
            for (Map.Entry<T, Object> entry : this.fields.getOverflowEntries()) {
                if (!FieldSet.isInitialized(entry)) {
                    return false;
                }
            }
            return true;
        }

        public void mergeFrom(FieldSet<T> other) {
            ensureIsMutable();
            for (int i = 0; i < ((FieldSet) other).fields.getNumArrayEntries(); i++) {
                mergeFromField(((FieldSet) other).fields.getArrayEntryAt(i));
            }
            for (Map.Entry<T, Object> entry : ((FieldSet) other).fields.getOverflowEntries()) {
                mergeFromField(entry);
            }
        }

        private void mergeFromField(Map.Entry<T, Object> entry) {
            T descriptor = entry.getKey();
            Object otherValue = entry.getValue();
            if (otherValue instanceof LazyField) {
                otherValue = ((LazyField) otherValue).getValue();
            }
            if (descriptor.isRepeated()) {
                Object value = getField(descriptor);
                if (value == null) {
                    value = new ArrayList();
                }
                for (Object element : (List) otherValue) {
                    ((List) value).add(FieldSet.cloneIfMutable(element));
                }
                this.fields.put((SmallSortedMap<T, Object>) descriptor, (T) value);
            } else if (descriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
                Object value2 = getField(descriptor);
                if (value2 == null) {
                    this.fields.put((SmallSortedMap<T, Object>) descriptor, (T) FieldSet.cloneIfMutable(otherValue));
                } else if (value2 instanceof MessageLite.Builder) {
                    descriptor.internalMergeFrom((MessageLite.Builder) value2, (MessageLite) otherValue);
                } else {
                    this.fields.put((SmallSortedMap<T, Object>) descriptor, (T) descriptor.internalMergeFrom(((MessageLite) value2).toBuilder(), (MessageLite) otherValue).build());
                }
            } else {
                this.fields.put((SmallSortedMap<T, Object>) descriptor, (T) FieldSet.cloneIfMutable(otherValue));
            }
        }
    }
}
