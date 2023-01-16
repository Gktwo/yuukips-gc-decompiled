package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.LazyField;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: grasscutter.jar:com/google/protobuf/MessageSetSchema.class */
final class MessageSetSchema<T> implements Schema<T> {
    private final MessageLite defaultInstance;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean hasExtensions;
    private final ExtensionSchema<?> extensionSchema;

    private MessageSetSchema(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite defaultInstance) {
        this.unknownFieldSchema = unknownFieldSchema;
        this.hasExtensions = extensionSchema.hasExtensions(defaultInstance);
        this.extensionSchema = extensionSchema;
        this.defaultInstance = defaultInstance;
    }

    /* access modifiers changed from: package-private */
    public static <T> MessageSetSchema<T> newSchema(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite defaultInstance) {
        return new MessageSetSchema<>(unknownFieldSchema, extensionSchema, defaultInstance);
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.defaultInstance.newBuilderForType().buildPartial();
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T message, T other) {
        if (!this.unknownFieldSchema.getFromMessage(message).equals(this.unknownFieldSchema.getFromMessage(other))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(message).equals(this.extensionSchema.getExtensions(other));
        }
        return true;
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T message) {
        int hashCode = this.unknownFieldSchema.getFromMessage(message).hashCode();
        if (this.hasExtensions) {
            hashCode = (hashCode * 53) + this.extensionSchema.getExtensions(message).hashCode();
        }
        return hashCode;
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T message, T other) {
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, message, other);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, message, other);
        }
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: com.google.protobuf.UnknownFieldSchema<?, ?>, com.google.protobuf.UnknownFieldSchema<UT, UB> */
    @Override // com.google.protobuf.Schema
    public void writeTo(T message, Writer writer) throws IOException {
        Iterator<?> iterator = this.extensionSchema.getExtensions(message).iterator();
        while (iterator.hasNext()) {
            Map.Entry<?, Object> extension = iterator.next();
            FieldSet.FieldDescriptorLite<?> fd = (FieldSet.FieldDescriptorLite) extension.getKey();
            if (fd.getLiteJavaType() != WireFormat.JavaType.MESSAGE || fd.isRepeated() || fd.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (extension instanceof LazyField.LazyEntry) {
                writer.writeMessageSetItem(fd.getNumber(), ((LazyField.LazyEntry) extension).getField().toByteString());
            } else {
                writer.writeMessageSetItem(fd.getNumber(), extension.getValue());
            }
        }
        writeUnknownFieldsHelper(this.unknownFieldSchema, message, writer);
    }

    private <UT, UB> void writeUnknownFieldsHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, T message, Writer writer) throws IOException {
        unknownFieldSchema.writeAsMessageSetTo(unknownFieldSchema.getFromMessage(message), writer);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0197 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x002b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0192 A[SYNTHETIC] */
    @Override // com.google.protobuf.Schema
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mergeFrom(T r8, byte[] r9, int r10, int r11, com.google.protobuf.ArrayDecoders.Registers r12) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 434
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSetSchema.mergeFrom(java.lang.Object, byte[], int, int, com.google.protobuf.ArrayDecoders$Registers):void");
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: com.google.protobuf.UnknownFieldSchema<?, ?>, com.google.protobuf.UnknownFieldSchema<UT, UB> */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: com.google.protobuf.ExtensionSchema<?>, com.google.protobuf.ExtensionSchema<ET extends com.google.protobuf.FieldSet$FieldDescriptorLite<ET>> */
    @Override // com.google.protobuf.Schema
    public void mergeFrom(T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, message, reader, extensionRegistry);
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
        UB unknownFields = unknownFieldSchema.getBuilderFromMessage(message);
        FieldSet<ET> extensions = extensionSchema.getMutableExtensions(message);
        while (reader.getFieldNumber() != Integer.MAX_VALUE) {
            try {
                if (!parseMessageSetItemOrUnknownField(reader, extensionRegistry, extensionSchema, extensions, unknownFieldSchema, unknownFields)) {
                    unknownFieldSchema.setBuilderToMessage(message, unknownFields);
                    return;
                }
            } finally {
                unknownFieldSchema.setBuilderToMessage(message, unknownFields);
            }
        }
    }

    @Override // com.google.protobuf.Schema
    public void makeImmutable(T message) {
        this.unknownFieldSchema.makeImmutable(message);
        this.extensionSchema.makeImmutable(message);
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(Reader reader, ExtensionRegistryLite extensionRegistry, ExtensionSchema<ET> extensionSchema, FieldSet<ET> extensions, UnknownFieldSchema<UT, UB> unknownFieldSchema, UB unknownFields) throws IOException {
        int startTag = reader.getTag();
        if (startTag == WireFormat.MESSAGE_SET_ITEM_TAG) {
            int typeId = 0;
            ByteString rawBytes = null;
            Object extension = null;
            while (reader.getFieldNumber() != Integer.MAX_VALUE) {
                int tag = reader.getTag();
                if (tag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                    typeId = reader.readUInt32();
                    extension = extensionSchema.findExtensionByNumber(extensionRegistry, this.defaultInstance, typeId);
                } else if (tag == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                    if (extension != null) {
                        extensionSchema.parseLengthPrefixedMessageSetItem(reader, extension, extensionRegistry, extensions);
                    } else {
                        rawBytes = reader.readBytes();
                    }
                } else if (!reader.skipField()) {
                    break;
                }
            }
            if (reader.getTag() != WireFormat.MESSAGE_SET_ITEM_END_TAG) {
                throw InvalidProtocolBufferException.invalidEndTag();
            } else if (rawBytes == null) {
                return true;
            } else {
                if (extension != null) {
                    extensionSchema.parseMessageSetItem(rawBytes, extension, extensionRegistry, extensions);
                    return true;
                }
                unknownFieldSchema.addLengthDelimited(unknownFields, typeId, rawBytes);
                return true;
            }
        } else if (WireFormat.getTagWireType(startTag) != 2) {
            return reader.skipField();
        } else {
            Object extension2 = extensionSchema.findExtensionByNumber(extensionRegistry, this.defaultInstance, WireFormat.getTagFieldNumber(startTag));
            if (extension2 == null) {
                return unknownFieldSchema.mergeOneFieldFrom(unknownFields, reader);
            }
            extensionSchema.parseLengthPrefixedMessageSetItem(reader, extension2, extensionRegistry, extensions);
            return true;
        }
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T message) {
        return this.extensionSchema.getExtensions(message).isInitialized();
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: com.google.protobuf.UnknownFieldSchema<?, ?>, com.google.protobuf.UnknownFieldSchema<UT, UB> */
    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T message) {
        int size = 0 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, message);
        if (this.hasExtensions) {
            size += this.extensionSchema.getExtensions(message).getMessageSetSerializedSize();
        }
        return size;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> schema, T message) {
        return schema.getSerializedSizeAsMessageSet(schema.getFromMessage(message));
    }
}
