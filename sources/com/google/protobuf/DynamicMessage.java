package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:com/google/protobuf/DynamicMessage.class */
public final class DynamicMessage extends AbstractMessage {
    private final Descriptors.Descriptor type;
    private final FieldSet<Descriptors.FieldDescriptor> fields;
    private final Descriptors.FieldDescriptor[] oneofCases;
    private final UnknownFieldSet unknownFields;
    private int memoizedSize = -1;

    DynamicMessage(Descriptors.Descriptor type, FieldSet<Descriptors.FieldDescriptor> fields, Descriptors.FieldDescriptor[] oneofCases, UnknownFieldSet unknownFields) {
        this.type = type;
        this.fields = fields;
        this.oneofCases = oneofCases;
        this.unknownFields = unknownFields;
    }

    public static DynamicMessage getDefaultInstance(Descriptors.Descriptor type) {
        return new DynamicMessage(type, FieldSet.emptySet(), new Descriptors.FieldDescriptor[type.toProto().getOneofDeclCount()], UnknownFieldSet.getDefaultInstance());
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor type, CodedInputStream input) throws IOException {
        return newBuilder(type).mergeFrom(input).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor type, CodedInputStream input, ExtensionRegistry extensionRegistry) throws IOException {
        return newBuilder(type).mergeFrom(input, (ExtensionRegistryLite) extensionRegistry).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor type, ByteString data) throws InvalidProtocolBufferException {
        return newBuilder(type).mergeFrom(data).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor type, ByteString data, ExtensionRegistry extensionRegistry) throws InvalidProtocolBufferException {
        return newBuilder(type).mergeFrom(data, (ExtensionRegistryLite) extensionRegistry).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor type, byte[] data) throws InvalidProtocolBufferException {
        return newBuilder(type).mergeFrom(data).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor type, byte[] data, ExtensionRegistry extensionRegistry) throws InvalidProtocolBufferException {
        return newBuilder(type).mergeFrom(data, (ExtensionRegistryLite) extensionRegistry).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor type, InputStream input) throws IOException {
        return newBuilder(type).mergeFrom(input).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor type, InputStream input, ExtensionRegistry extensionRegistry) throws IOException {
        return newBuilder(type).mergeFrom(input, (ExtensionRegistryLite) extensionRegistry).buildParsed();
    }

    public static Builder newBuilder(Descriptors.Descriptor type) {
        return new Builder(type);
    }

    public static Builder newBuilder(Message prototype) {
        return new Builder(prototype.getDescriptorForType()).mergeFrom(prototype);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return this.type;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public DynamicMessage getDefaultInstanceForType() {
        return getDefaultInstance(this.type);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return this.fields.getAllFields();
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(Descriptors.OneofDescriptor oneof) {
        verifyOneofContainingType(oneof);
        if (this.oneofCases[oneof.getIndex()] == null) {
            return false;
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof) {
        verifyOneofContainingType(oneof);
        return this.oneofCases[oneof.getIndex()];
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor field) {
        verifyContainingType(field);
        return this.fields.hasField(field);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor field) {
        verifyContainingType(field);
        Object result = this.fields.getField(field);
        if (result == null) {
            if (field.isRepeated()) {
                result = Collections.emptyList();
            } else if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                result = getDefaultInstance(field.getMessageType());
            } else {
                result = field.getDefaultValue();
            }
        }
        return result;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor field) {
        verifyContainingType(field);
        return this.fields.getRepeatedFieldCount(field);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor field, int index) {
        verifyContainingType(field);
        return this.fields.getRepeatedField(field, index);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    static boolean isInitialized(Descriptors.Descriptor type, FieldSet<Descriptors.FieldDescriptor> fields) {
        for (Descriptors.FieldDescriptor field : type.getFields()) {
            if (field.isRequired() && !fields.hasField(field)) {
                return false;
            }
        }
        return fields.isInitialized();
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return isInitialized(this.type, this.fields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.type.getOptions().getMessageSetWireFormat()) {
            this.fields.writeMessageSetTo(output);
            this.unknownFields.writeAsMessageSetTo(output);
            return;
        }
        this.fields.writeTo(output);
        this.unknownFields.writeTo(output);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size;
        int size2 = this.memoizedSize;
        if (size2 != -1) {
            return size2;
        }
        if (this.type.getOptions().getMessageSetWireFormat()) {
            size = this.fields.getMessageSetSerializedSize() + this.unknownFields.getSerializedSizeAsMessageSet();
        } else {
            size = this.fields.getSerializedSize() + this.unknownFields.getSerializedSize();
        }
        this.memoizedSize = size;
        return size;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return new Builder(this.type);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return newBuilderForType().mergeFrom((Message) this);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<DynamicMessage> getParserForType() {
        return new AbstractParser<DynamicMessage>() { // from class: com.google.protobuf.DynamicMessage.1
            @Override // com.google.protobuf.Parser
            public DynamicMessage parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builder = DynamicMessage.newBuilder(DynamicMessage.this.type);
                try {
                    builder.mergeFrom(input, extensionRegistry);
                    return builder.buildPartial();
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(builder.buildPartial());
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(builder.buildPartial());
                }
            }
        };
    }

    private void verifyContainingType(Descriptors.FieldDescriptor field) {
        if (field.getContainingType() != this.type) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }

    private void verifyOneofContainingType(Descriptors.OneofDescriptor oneof) {
        if (oneof.getContainingType() != this.type) {
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/DynamicMessage$Builder.class */
    public static final class Builder extends AbstractMessage.Builder<Builder> {
        private final Descriptors.Descriptor type;
        private FieldSet<Descriptors.FieldDescriptor> fields;
        private final Descriptors.FieldDescriptor[] oneofCases;
        private UnknownFieldSet unknownFields;

        private Builder(Descriptors.Descriptor type) {
            this.type = type;
            this.fields = FieldSet.newFieldSet();
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            this.oneofCases = new Descriptors.FieldDescriptor[type.toProto().getOneofDeclCount()];
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            if (this.fields.isImmutable()) {
                this.fields = FieldSet.newFieldSet();
            } else {
                this.fields.clear();
            }
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message other) {
            if (!(other instanceof DynamicMessage)) {
                return mergeFrom(other);
            }
            DynamicMessage otherDynamicMessage = (DynamicMessage) other;
            if (otherDynamicMessage.type != this.type) {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
            ensureIsMutable();
            this.fields.mergeFrom(otherDynamicMessage.fields);
            mergeUnknownFields(otherDynamicMessage.unknownFields);
            for (int i = 0; i < this.oneofCases.length; i++) {
                if (this.oneofCases[i] == null) {
                    this.oneofCases[i] = otherDynamicMessage.oneofCases[i];
                } else if (!(otherDynamicMessage.oneofCases[i] == null || this.oneofCases[i] == otherDynamicMessage.oneofCases[i])) {
                    this.fields.clearField(this.oneofCases[i]);
                    this.oneofCases[i] = otherDynamicMessage.oneofCases[i];
                }
            }
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public DynamicMessage build() {
            if (isInitialized()) {
                return buildPartial();
            }
            throw newUninitializedMessageException((Message) new DynamicMessage(this.type, this.fields, (Descriptors.FieldDescriptor[]) Arrays.copyOf(this.oneofCases, this.oneofCases.length), this.unknownFields));
        }

        /* access modifiers changed from: private */
        public DynamicMessage buildParsed() throws InvalidProtocolBufferException {
            if (isInitialized()) {
                return buildPartial();
            }
            throw newUninitializedMessageException((Message) new DynamicMessage(this.type, this.fields, (Descriptors.FieldDescriptor[]) Arrays.copyOf(this.oneofCases, this.oneofCases.length), this.unknownFields)).asInvalidProtocolBufferException();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public DynamicMessage buildPartial() {
            if (this.type.getOptions().getMapEntry()) {
                for (Descriptors.FieldDescriptor field : this.type.getFields()) {
                    if (field.isOptional() && !this.fields.hasField(field)) {
                        if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                            this.fields.setField(field, DynamicMessage.getDefaultInstance(field.getMessageType()));
                        } else {
                            this.fields.setField(field, field.getDefaultValue());
                        }
                    }
                }
            }
            this.fields.makeImmutable();
            return new DynamicMessage(this.type, this.fields, (Descriptors.FieldDescriptor[]) Arrays.copyOf(this.oneofCases, this.oneofCases.length), this.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, java.lang.Object, com.google.protobuf.Message.Builder
        public Builder clone() {
            Builder result = new Builder(this.type);
            result.fields.mergeFrom(this.fields);
            result.mergeUnknownFields(this.unknownFields);
            System.arraycopy(this.oneofCases, 0, result.oneofCases, 0, this.oneofCases.length);
            return result;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return DynamicMessage.isInitialized(this.type, this.fields);
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return this.type;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DynamicMessage getDefaultInstanceForType() {
            return DynamicMessage.getDefaultInstance(this.type);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return this.fields.getAllFields();
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder newBuilderForField(Descriptors.FieldDescriptor field) {
            verifyContainingType(field);
            if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return new Builder(field.getMessageType());
            }
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(Descriptors.OneofDescriptor oneof) {
            verifyOneofContainingType(oneof);
            if (this.oneofCases[oneof.getIndex()] == null) {
                return false;
            }
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof) {
            verifyOneofContainingType(oneof);
            return this.oneofCases[oneof.getIndex()];
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
            verifyOneofContainingType(oneof);
            Descriptors.FieldDescriptor field = this.oneofCases[oneof.getIndex()];
            if (field != null) {
                clearField(field);
            }
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor field) {
            verifyContainingType(field);
            return this.fields.hasField(field);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor field) {
            verifyContainingType(field);
            Object result = this.fields.getField(field);
            if (result == null) {
                if (field.isRepeated()) {
                    result = Collections.emptyList();
                } else if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    result = DynamicMessage.getDefaultInstance(field.getMessageType());
                } else {
                    result = field.getDefaultValue();
                }
            }
            return result;
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor field, Object value) {
            verifyContainingType(field);
            ensureIsMutable();
            if (field.getType() == Descriptors.FieldDescriptor.Type.ENUM) {
                ensureEnumValueDescriptor(field, value);
            }
            Descriptors.OneofDescriptor oneofDescriptor = field.getContainingOneof();
            if (oneofDescriptor != null) {
                int index = oneofDescriptor.getIndex();
                Descriptors.FieldDescriptor oldField = this.oneofCases[index];
                if (!(oldField == null || oldField == field)) {
                    this.fields.clearField(oldField);
                }
                this.oneofCases[index] = field;
            } else if (field.getFile().getSyntax() == Descriptors.FileDescriptor.Syntax.PROTO3 && !field.isRepeated() && field.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE && value.equals(field.getDefaultValue())) {
                this.fields.clearField(field);
                return this;
            }
            this.fields.setField(field, value);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor field) {
            verifyContainingType(field);
            ensureIsMutable();
            Descriptors.OneofDescriptor oneofDescriptor = field.getContainingOneof();
            if (oneofDescriptor != null) {
                int index = oneofDescriptor.getIndex();
                if (this.oneofCases[index] == field) {
                    this.oneofCases[index] = null;
                }
            }
            this.fields.clearField(field);
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor field) {
            verifyContainingType(field);
            return this.fields.getRepeatedFieldCount(field);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor field, int index) {
            verifyContainingType(field);
            return this.fields.getRepeatedField(field, index);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            verifyContainingType(field);
            ensureIsMutable();
            this.fields.setRepeatedField(field, index, value);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            verifyContainingType(field);
            ensureIsMutable();
            this.fields.addRepeatedField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setUnknownFields(UnknownFieldSet unknownFields) {
            this.unknownFields = unknownFields;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
            this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(unknownFields).build();
            return this;
        }

        private void verifyContainingType(Descriptors.FieldDescriptor field) {
            if (field.getContainingType() != this.type) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        private void verifyOneofContainingType(Descriptors.OneofDescriptor oneof) {
            if (oneof.getContainingType() != this.type) {
                throw new IllegalArgumentException("OneofDescriptor does not match message type.");
            }
        }

        private void ensureSingularEnumValueDescriptor(Descriptors.FieldDescriptor field, Object value) {
            Internal.checkNotNull(value);
            if (!(value instanceof Descriptors.EnumValueDescriptor)) {
                throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
            }
        }

        private void ensureEnumValueDescriptor(Descriptors.FieldDescriptor field, Object value) {
            if (field.isRepeated()) {
                for (Object item : (List) value) {
                    ensureSingularEnumValueDescriptor(field, item);
                }
                return;
            }
            ensureSingularEnumValueDescriptor(field, value);
        }

        private void ensureIsMutable() {
            if (this.fields.isImmutable()) {
                this.fields = this.fields.clone();
            }
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor field) {
            throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor field, int index) {
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a dynamic message type.");
        }
    }
}
