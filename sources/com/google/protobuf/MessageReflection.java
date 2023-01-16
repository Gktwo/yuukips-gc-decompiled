package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/protobuf/MessageReflection.class */
public class MessageReflection {

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/protobuf/MessageReflection$MergeTarget.class */
    public interface MergeTarget {

        /* loaded from: grasscutter.jar:com/google/protobuf/MessageReflection$MergeTarget$ContainerType.class */
        public enum ContainerType {
            MESSAGE,
            EXTENSION_SET
        }

        Descriptors.Descriptor getDescriptorForType();

        ContainerType getContainerType();

        ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry extensionRegistry, String str);

        ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry extensionRegistry, Descriptors.Descriptor descriptor, int i);

        Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        MergeTarget setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        MergeTarget clearField(Descriptors.FieldDescriptor fieldDescriptor);

        MergeTarget setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj);

        MergeTarget addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor);

        MergeTarget clearOneof(Descriptors.OneofDescriptor oneofDescriptor);

        Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor);

        Object parseGroup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException;

        Object parseMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException;

        Object parseMessageFromBytes(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException;

        WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor fieldDescriptor);

        MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor fieldDescriptor, Message message);

        MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor fieldDescriptor, Message message);

        Object finish();
    }

    MessageReflection() {
    }

    /* access modifiers changed from: package-private */
    public static void writeMessageTo(Message message, Map<Descriptors.FieldDescriptor, Object> fields, CodedOutputStream output, boolean alwaysWriteRequiredFields) throws IOException {
        boolean isMessageSet = message.getDescriptorForType().getOptions().getMessageSetWireFormat();
        if (alwaysWriteRequiredFields) {
            fields = new TreeMap(fields);
            for (Descriptors.FieldDescriptor field : message.getDescriptorForType().getFields()) {
                if (field.isRequired() && !fields.containsKey(field)) {
                    fields.put(field, message.getField(field));
                }
            }
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : fields.entrySet()) {
            Descriptors.FieldDescriptor field2 = entry.getKey();
            Object value = entry.getValue();
            if (!isMessageSet || !field2.isExtension() || field2.getType() != Descriptors.FieldDescriptor.Type.MESSAGE || field2.isRepeated()) {
                FieldSet.writeField(field2, value, output);
            } else {
                output.writeMessageSetExtension(field2.getNumber(), (Message) value);
            }
        }
        UnknownFieldSet unknownFields = message.getUnknownFields();
        if (isMessageSet) {
            unknownFields.writeAsMessageSetTo(output);
        } else {
            unknownFields.writeTo(output);
        }
    }

    /* access modifiers changed from: package-private */
    public static int getSerializedSize(Message message, Map<Descriptors.FieldDescriptor, Object> fields) {
        int size;
        int size2 = 0;
        boolean isMessageSet = message.getDescriptorForType().getOptions().getMessageSetWireFormat();
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : fields.entrySet()) {
            Descriptors.FieldDescriptor field = entry.getKey();
            Object value = entry.getValue();
            if (!isMessageSet || !field.isExtension() || field.getType() != Descriptors.FieldDescriptor.Type.MESSAGE || field.isRepeated()) {
                size2 += FieldSet.computeFieldSize(field, value);
            } else {
                size2 += CodedOutputStream.computeMessageSetExtensionSize(field.getNumber(), (Message) value);
            }
        }
        UnknownFieldSet unknownFields = message.getUnknownFields();
        if (isMessageSet) {
            size = size2 + unknownFields.getSerializedSizeAsMessageSet();
        } else {
            size = size2 + unknownFields.getSerializedSize();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    public static String delimitWithCommas(List<String> parts) {
        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(part);
        }
        return result.toString();
    }

    /* access modifiers changed from: package-private */
    public static boolean isInitialized(MessageOrBuilder message) {
        for (Descriptors.FieldDescriptor field : message.getDescriptorForType().getFields()) {
            if (field.isRequired() && !message.hasField(field)) {
                return false;
            }
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : message.getAllFields().entrySet()) {
            Descriptors.FieldDescriptor field2 = entry.getKey();
            if (field2.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (field2.isRepeated()) {
                    for (Message element : (List) entry.getValue()) {
                        if (!element.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (!((Message) entry.getValue()).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String subMessagePrefix(String prefix, Descriptors.FieldDescriptor field, int index) {
        StringBuilder result = new StringBuilder(prefix);
        if (field.isExtension()) {
            result.append('(').append(field.getFullName()).append(')');
        } else {
            result.append(field.getName());
        }
        if (index != -1) {
            result.append('[').append(index).append(']');
        }
        result.append('.');
        return result.toString();
    }

    private static void findMissingFields(MessageOrBuilder message, String prefix, List<String> results) {
        for (Descriptors.FieldDescriptor field : message.getDescriptorForType().getFields()) {
            if (field.isRequired() && !message.hasField(field)) {
                results.add(prefix + field.getName());
            }
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : message.getAllFields().entrySet()) {
            Descriptors.FieldDescriptor field2 = entry.getKey();
            Object value = entry.getValue();
            if (field2.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (field2.isRepeated()) {
                    int i = 0;
                    for (MessageOrBuilder messageOrBuilder : (List) value) {
                        i++;
                        findMissingFields(messageOrBuilder, subMessagePrefix(prefix, field2, i), results);
                    }
                } else if (message.hasField(field2)) {
                    findMissingFields((MessageOrBuilder) value, subMessagePrefix(prefix, field2, -1), results);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static List<String> findMissingFields(MessageOrBuilder message) {
        List<String> results = new ArrayList<>();
        findMissingFields(message, "", results);
        return results;
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/protobuf/MessageReflection$BuilderAdapter.class */
    public static class BuilderAdapter implements MergeTarget {
        private final Message.Builder builder;

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.Descriptor getDescriptorForType() {
            return this.builder.getDescriptorForType();
        }

        public BuilderAdapter(Message.Builder builder) {
            this.builder = builder;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object getField(Descriptors.FieldDescriptor field) {
            return this.builder.getField(field);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor field) {
            return this.builder.hasField(field);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor field, Object value) {
            this.builder.setField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor field) {
            this.builder.clearField(field);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            this.builder.setRepeatedField(field, index, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            this.builder.addRepeatedField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor oneof) {
            return this.builder.hasOneof(oneof);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor oneof) {
            this.builder.clearOneof(oneof);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof) {
            return this.builder.getOneofFieldDescriptor(oneof);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.MESSAGE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry registry, String name) {
            return registry.findImmutableExtensionByName(name);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry registry, Descriptors.Descriptor containingType, int fieldNumber) {
            return registry.findImmutableExtensionByNumber(containingType, fieldNumber);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message.Builder subBuilder;
            Message originalMessage;
            if (defaultInstance != null) {
                subBuilder = defaultInstance.newBuilderForType();
            } else {
                subBuilder = this.builder.newBuilderForField(field);
            }
            if (!field.isRepeated() && (originalMessage = (Message) getField(field)) != null) {
                subBuilder.mergeFrom(originalMessage);
            }
            input.readGroup(field.getNumber(), subBuilder, extensionRegistry);
            return subBuilder.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message.Builder subBuilder;
            Message originalMessage;
            if (defaultInstance != null) {
                subBuilder = defaultInstance.newBuilderForType();
            } else {
                subBuilder = this.builder.newBuilderForField(field);
            }
            if (!field.isRepeated() && (originalMessage = (Message) getField(field)) != null) {
                subBuilder.mergeFrom(originalMessage);
            }
            input.readMessage(subBuilder, extensionRegistry);
            return subBuilder.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString bytes, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message.Builder subBuilder;
            Message originalMessage;
            if (defaultInstance != null) {
                subBuilder = defaultInstance.newBuilderForType();
            } else {
                subBuilder = this.builder.newBuilderForField(field);
            }
            if (!field.isRepeated() && (originalMessage = (Message) getField(field)) != null) {
                subBuilder.mergeFrom(originalMessage);
            }
            subBuilder.mergeFrom(bytes, extensionRegistry);
            return subBuilder.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor field, Message defaultInstance) {
            Message.Builder subBuilder;
            Message originalMessage;
            if (defaultInstance != null) {
                subBuilder = defaultInstance.newBuilderForType();
            } else {
                subBuilder = this.builder.newBuilderForField(field);
            }
            if (!field.isRepeated() && (originalMessage = (Message) getField(field)) != null) {
                subBuilder.mergeFrom(originalMessage);
            }
            return new BuilderAdapter(subBuilder);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor field, Message defaultInstance) {
            Message.Builder subBuilder;
            if (defaultInstance != null) {
                subBuilder = defaultInstance.newBuilderForType();
            } else {
                subBuilder = this.builder.newBuilderForField(field);
            }
            return new BuilderAdapter(subBuilder);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor descriptor) {
            if (descriptor.needsUtf8Check()) {
                return WireFormat.Utf8Validation.STRICT;
            }
            if (descriptor.isRepeated() || !(this.builder instanceof GeneratedMessage.Builder)) {
                return WireFormat.Utf8Validation.LOOSE;
            }
            return WireFormat.Utf8Validation.LAZY;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object finish() {
            return this.builder.buildPartial();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/protobuf/MessageReflection$ExtensionAdapter.class */
    public static class ExtensionAdapter implements MergeTarget {
        private final FieldSet<Descriptors.FieldDescriptor> extensions;

        /* access modifiers changed from: package-private */
        public ExtensionAdapter(FieldSet<Descriptors.FieldDescriptor> extensions) {
            this.extensions = extensions;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.Descriptor getDescriptorForType() {
            throw new UnsupportedOperationException("getDescriptorForType() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object getField(Descriptors.FieldDescriptor field) {
            return this.extensions.getField(field);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor field) {
            return this.extensions.hasField(field);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor field, Object value) {
            this.extensions.setField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor field) {
            this.extensions.clearField(field);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            this.extensions.setRepeatedField(field, index, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            this.extensions.addRepeatedField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor oneof) {
            return false;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor oneof) {
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof) {
            return null;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.EXTENSION_SET;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry registry, String name) {
            return registry.findImmutableExtensionByName(name);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry registry, Descriptors.Descriptor containingType, int fieldNumber) {
            return registry.findImmutableExtensionByNumber(containingType, fieldNumber);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream input, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message originalMessage;
            Message.Builder subBuilder = defaultInstance.newBuilderForType();
            if (!field.isRepeated() && (originalMessage = (Message) getField(field)) != null) {
                subBuilder.mergeFrom(originalMessage);
            }
            input.readGroup(field.getNumber(), subBuilder, registry);
            return subBuilder.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream input, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message originalMessage;
            Message.Builder subBuilder = defaultInstance.newBuilderForType();
            if (!field.isRepeated() && (originalMessage = (Message) getField(field)) != null) {
                subBuilder.mergeFrom(originalMessage);
            }
            input.readMessage(subBuilder, registry);
            return subBuilder.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString bytes, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message originalMessage;
            Message.Builder subBuilder = defaultInstance.newBuilderForType();
            if (!field.isRepeated() && (originalMessage = (Message) getField(field)) != null) {
                subBuilder.mergeFrom(originalMessage);
            }
            subBuilder.mergeFrom(bytes, registry);
            return subBuilder.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor descriptor, Message defaultInstance) {
            throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor descriptor, Message defaultInstance) {
            throw new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor descriptor) {
            if (descriptor.needsUtf8Check()) {
                return WireFormat.Utf8Validation.STRICT;
            }
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object finish() {
            throw new UnsupportedOperationException("finish() called on FieldSet object");
        }
    }

    /* access modifiers changed from: package-private */
    public static boolean mergeFieldFrom(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, Descriptors.Descriptor type, MergeTarget target, int tag) throws IOException {
        Descriptors.FieldDescriptor field;
        Object value;
        if (!type.getOptions().getMessageSetWireFormat() || tag != WireFormat.MESSAGE_SET_ITEM_TAG) {
            int wireType = WireFormat.getTagWireType(tag);
            int fieldNumber = WireFormat.getTagFieldNumber(tag);
            Message defaultInstance = null;
            if (!type.isExtensionNumber(fieldNumber)) {
                field = target.getContainerType() == MergeTarget.ContainerType.MESSAGE ? type.findFieldByNumber(fieldNumber) : null;
            } else if (extensionRegistry instanceof ExtensionRegistry) {
                ExtensionRegistry.ExtensionInfo extension = target.findExtensionByNumber((ExtensionRegistry) extensionRegistry, type, fieldNumber);
                if (extension == null) {
                    field = null;
                } else {
                    field = extension.descriptor;
                    defaultInstance = extension.defaultInstance;
                    if (defaultInstance == null && field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        throw new IllegalStateException("Message-typed extension lacked default instance: " + field.getFullName());
                    }
                }
            } else {
                field = null;
            }
            boolean unknown = false;
            boolean packed = false;
            if (field == null) {
                unknown = true;
            } else if (wireType == FieldSet.getWireFormatForFieldType(field.getLiteType(), false)) {
                packed = false;
            } else if (!field.isPackable() || wireType != FieldSet.getWireFormatForFieldType(field.getLiteType(), true)) {
                unknown = true;
            } else {
                packed = true;
            }
            if (unknown) {
                if (unknownFields != null) {
                    return unknownFields.mergeFieldFrom(tag, input);
                }
                return input.skipField(tag);
            } else if (packed) {
                int limit = input.pushLimit(input.readRawVarint32());
                if (field.getLiteType() == WireFormat.FieldType.ENUM) {
                    while (input.getBytesUntilLimit() > 0) {
                        int rawValue = input.readEnum();
                        if (field.getFile().supportsUnknownEnumValue()) {
                            target.addRepeatedField(field, field.getEnumType().findValueByNumberCreatingIfUnknown(rawValue));
                        } else {
                            Object value2 = field.getEnumType().findValueByNumber(rawValue);
                            if (value2 != null) {
                                target.addRepeatedField(field, value2);
                            } else if (unknownFields != null) {
                                unknownFields.mergeVarintField(fieldNumber, rawValue);
                            }
                        }
                    }
                } else {
                    while (input.getBytesUntilLimit() > 0) {
                        target.addRepeatedField(field, WireFormat.readPrimitiveField(input, field.getLiteType(), target.getUtf8Validation(field)));
                    }
                }
                input.popLimit(limit);
                return true;
            } else {
                switch (field.getType()) {
                    case GROUP:
                        value = target.parseGroup(input, extensionRegistry, field, defaultInstance);
                        break;
                    case MESSAGE:
                        value = target.parseMessage(input, extensionRegistry, field, defaultInstance);
                        break;
                    case ENUM:
                        int rawValue2 = input.readEnum();
                        if (field.getFile().supportsUnknownEnumValue()) {
                            value = field.getEnumType().findValueByNumberCreatingIfUnknown(rawValue2);
                            break;
                        } else {
                            value = field.getEnumType().findValueByNumber(rawValue2);
                            if (value == null) {
                                if (unknownFields == null) {
                                    return true;
                                }
                                unknownFields.mergeVarintField(fieldNumber, rawValue2);
                                return true;
                            }
                        }
                        break;
                    default:
                        value = WireFormat.readPrimitiveField(input, field.getLiteType(), target.getUtf8Validation(field));
                        break;
                }
                if (field.isRepeated()) {
                    target.addRepeatedField(field, value);
                    return true;
                }
                target.setField(field, value);
                return true;
            }
        } else {
            mergeMessageSetExtensionFromCodedStream(input, unknownFields, extensionRegistry, type, target);
            return true;
        }
    }

    private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, Descriptors.Descriptor type, MergeTarget target) throws IOException {
        int typeId = 0;
        ByteString rawBytes = null;
        ExtensionRegistry.ExtensionInfo extension = null;
        while (true) {
            int tag = input.readTag();
            if (tag == 0) {
                break;
            } else if (tag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                typeId = input.readUInt32();
                if (typeId != 0 && (extensionRegistry instanceof ExtensionRegistry)) {
                    extension = target.findExtensionByNumber((ExtensionRegistry) extensionRegistry, type, typeId);
                }
            } else if (tag == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                if (typeId == 0 || extension == null || !ExtensionRegistryLite.isEagerlyParseMessageSets()) {
                    rawBytes = input.readBytes();
                } else {
                    eagerlyMergeMessageSetExtension(input, extension, extensionRegistry, target);
                    rawBytes = null;
                }
            } else if (!input.skipField(tag)) {
                break;
            }
        }
        input.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
        if (rawBytes != null && typeId != 0) {
            if (extension != null) {
                mergeMessageSetExtensionFromBytes(rawBytes, extension, extensionRegistry, target);
            } else if (rawBytes != null && unknownFields != null) {
                unknownFields.mergeField(typeId, UnknownFieldSet.Field.newBuilder().addLengthDelimited(rawBytes).build());
            }
        }
    }

    private static void mergeMessageSetExtensionFromBytes(ByteString rawBytes, ExtensionRegistry.ExtensionInfo extension, ExtensionRegistryLite extensionRegistry, MergeTarget target) throws IOException {
        Descriptors.FieldDescriptor field = extension.descriptor;
        if (target.hasField(field) || ExtensionRegistryLite.isEagerlyParseMessageSets()) {
            target.setField(field, target.parseMessageFromBytes(rawBytes, extensionRegistry, field, extension.defaultInstance));
        } else {
            target.setField(field, new LazyField(extension.defaultInstance, extensionRegistry, rawBytes));
        }
    }

    private static void eagerlyMergeMessageSetExtension(CodedInputStream input, ExtensionRegistry.ExtensionInfo extension, ExtensionRegistryLite extensionRegistry, MergeTarget target) throws IOException {
        Descriptors.FieldDescriptor field = extension.descriptor;
        target.setField(field, target.parseMessage(input, extensionRegistry, field, extension.defaultInstance));
    }
}
