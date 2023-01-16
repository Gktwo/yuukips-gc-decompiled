package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:com/google/protobuf/Struct.class */
public final class Struct extends GeneratedMessageV3 implements StructOrBuilder {
    private static final long serialVersionUID = 0;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private MapField<String, Value> fields_;
    private byte memoizedIsInitialized;
    private static final Struct DEFAULT_INSTANCE = new Struct();
    private static final Parser<Struct> PARSER = new AbstractParser<Struct>() { // from class: com.google.protobuf.Struct.1
        @Override // com.google.protobuf.Parser
        public Struct parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return new Struct(input, extensionRegistry);
        }
    };

    private Struct(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    private Struct() {
        this.memoizedIsInitialized = -1;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new Struct();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private Struct(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        this();
        UnknownFieldSet.Builder unknownFields;
        if (extensionRegistry == null) {
            throw new NullPointerException();
        }
        try {
            int mutable_bitField0_ = 0;
            unknownFields = UnknownFieldSet.newBuilder();
            boolean done = false;
            while (!done) {
                try {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 10:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.fields_ = MapField.newMapField(FieldsDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<String, Value> fields__ = (MapEntry) input.readMessage(FieldsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.fields_.getMutableMap().put(fields__.getKey(), fields__.getValue());
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            }
        } finally {
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Struct_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected MapField internalGetMapField(int number) {
        switch (number) {
            case 1:
                return internalGetFields();
            default:
                throw new RuntimeException("Invalid map field number: " + number);
        }
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Builder.class);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/protobuf/Struct$FieldsDefaultEntryHolder.class */
    public static final class FieldsDefaultEntryHolder {
        static final MapEntry<String, Value> defaultEntry = MapEntry.newDefaultInstance(StructProto.internal_static_google_protobuf_Struct_FieldsEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

        private FieldsDefaultEntryHolder() {
        }
    }

    /* access modifiers changed from: private */
    public MapField<String, Value> internalGetFields() {
        if (this.fields_ == null) {
            return MapField.emptyMapField(FieldsDefaultEntryHolder.defaultEntry);
        }
        return this.fields_;
    }

    @Override // com.google.protobuf.StructOrBuilder
    public int getFieldsCount() {
        return internalGetFields().getMap().size();
    }

    @Override // com.google.protobuf.StructOrBuilder
    public boolean containsFields(String key) {
        if (key != null) {
            return internalGetFields().getMap().containsKey(key);
        }
        throw new NullPointerException();
    }

    @Override // com.google.protobuf.StructOrBuilder
    @Deprecated
    public Map<String, Value> getFields() {
        return getFieldsMap();
    }

    @Override // com.google.protobuf.StructOrBuilder
    public Map<String, Value> getFieldsMap() {
        return internalGetFields().getMap();
    }

    @Override // com.google.protobuf.StructOrBuilder
    public Value getFieldsOrDefault(String key, Value defaultValue) {
        if (key == null) {
            throw new NullPointerException();
        }
        Map<String, Value> map = internalGetFields().getMap();
        return map.containsKey(key) ? map.get(key) : defaultValue;
    }

    @Override // com.google.protobuf.StructOrBuilder
    public Value getFieldsOrThrow(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        Map<String, Value> map = internalGetFields().getMap();
        if (map.containsKey(key)) {
            return map.get(key);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte isInitialized = this.memoizedIsInitialized;
        if (isInitialized == 1) {
            return true;
        }
        if (isInitialized == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream output) throws IOException {
        GeneratedMessageV3.serializeStringMapTo(output, internalGetFields(), FieldsDefaultEntryHolder.defaultEntry, 1);
        this.unknownFields.writeTo(output);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.memoizedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (Map.Entry<String, Value> entry : internalGetFields().getMap().entrySet()) {
            size2 += CodedOutputStream.computeMessageSize(1, FieldsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
        int size3 = size2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = size3;
        return size3;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Struct)) {
            return equals(obj);
        }
        Struct other = (Struct) obj;
        return internalGetFields().equals(other.internalGetFields()) && this.unknownFields.equals(other.unknownFields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hash = (19 * 41) + getDescriptor().hashCode();
        if (!internalGetFields().getMap().isEmpty()) {
            hash = (53 * ((37 * hash) + 1)) + internalGetFields().hashCode();
        }
        int hash2 = (29 * hash) + this.unknownFields.hashCode();
        this.memoizedHashCode = hash2;
        return hash2;
    }

    public static Struct parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Struct parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Struct parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Struct parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Struct parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Struct parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Struct parseFrom(InputStream input) throws IOException {
        return (Struct) GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static Struct parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Struct) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Struct parseDelimitedFrom(InputStream input) throws IOException {
        return (Struct) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static Struct parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Struct) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static Struct parseFrom(CodedInputStream input) throws IOException {
        return (Struct) GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static Struct parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Struct) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Struct prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
        return new Builder(parent);
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/Struct$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StructOrBuilder {
        private int bitField0_;
        private MapField<String, Value> fields_;

        public static final Descriptors.Descriptor getDescriptor() {
            return StructProto.internal_static_google_protobuf_Struct_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected MapField internalGetMapField(int number) {
            switch (number) {
                case 1:
                    return internalGetFields();
                default:
                    throw new RuntimeException("Invalid map field number: " + number);
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected MapField internalGetMutableMapField(int number) {
            switch (number) {
                case 1:
                    return internalGetMutableFields();
                default:
                    throw new RuntimeException("Invalid map field number: " + number);
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Builder.class);
        }

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent parent) {
            super(parent);
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            clear();
            internalGetMutableFields().clear();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return StructProto.internal_static_google_protobuf_Struct_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Struct getDefaultInstanceForType() {
            return Struct.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Struct build() {
            Struct result = buildPartial();
            if (result.isInitialized()) {
                return result;
            }
            throw newUninitializedMessageException((Message) result);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Struct buildPartial() {
            Struct result = new Struct(this);
            int i = this.bitField0_;
            result.fields_ = internalGetFields();
            result.fields_.makeImmutable();
            onBuilt();
            return result;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, java.lang.Object, com.google.protobuf.Message.Builder
        public Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor field, Object value) {
            return setField(field, value);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor field) {
            return clearField(field);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
            return clearOneof(oneof);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            return setRepeatedField(field, index, value);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            return addRepeatedField(field, value);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message other) {
            if (other instanceof Struct) {
                return mergeFrom((Struct) other);
            }
            mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(Struct other) {
            if (other == Struct.getDefaultInstance()) {
                return this;
            }
            internalGetMutableFields().mergeFrom(other.internalGetFields());
            mergeUnknownFields(other.unknownFields);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Struct parsedMessage = null;
            try {
                try {
                    parsedMessage = (Struct) Struct.PARSER.parsePartialFrom(input, extensionRegistry);
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Struct) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                }
            } catch (Throwable th) {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
                throw th;
            }
        }

        private MapField<String, Value> internalGetFields() {
            if (this.fields_ == null) {
                return MapField.emptyMapField(FieldsDefaultEntryHolder.defaultEntry);
            }
            return this.fields_;
        }

        private MapField<String, Value> internalGetMutableFields() {
            onChanged();
            if (this.fields_ == null) {
                this.fields_ = MapField.newMapField(FieldsDefaultEntryHolder.defaultEntry);
            }
            if (!this.fields_.isMutable()) {
                this.fields_ = this.fields_.copy();
            }
            return this.fields_;
        }

        @Override // com.google.protobuf.StructOrBuilder
        public int getFieldsCount() {
            return internalGetFields().getMap().size();
        }

        @Override // com.google.protobuf.StructOrBuilder
        public boolean containsFields(String key) {
            if (key != null) {
                return internalGetFields().getMap().containsKey(key);
            }
            throw new NullPointerException();
        }

        @Override // com.google.protobuf.StructOrBuilder
        @Deprecated
        public Map<String, Value> getFields() {
            return getFieldsMap();
        }

        @Override // com.google.protobuf.StructOrBuilder
        public Map<String, Value> getFieldsMap() {
            return internalGetFields().getMap();
        }

        @Override // com.google.protobuf.StructOrBuilder
        public Value getFieldsOrDefault(String key, Value defaultValue) {
            if (key == null) {
                throw new NullPointerException();
            }
            Map<String, Value> map = internalGetFields().getMap();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }

        @Override // com.google.protobuf.StructOrBuilder
        public Value getFieldsOrThrow(String key) {
            if (key == null) {
                throw new NullPointerException();
            }
            Map<String, Value> map = internalGetFields().getMap();
            if (map.containsKey(key)) {
                return map.get(key);
            }
            throw new IllegalArgumentException();
        }

        public Builder clearFields() {
            internalGetMutableFields().getMutableMap().clear();
            return this;
        }

        public Builder removeFields(String key) {
            if (key == null) {
                throw new NullPointerException();
            }
            internalGetMutableFields().getMutableMap().remove(key);
            return this;
        }

        @Deprecated
        public Map<String, Value> getMutableFields() {
            return internalGetMutableFields().getMutableMap();
        }

        public Builder putFields(String key, Value value) {
            if (key == null) {
                throw new NullPointerException();
            } else if (value == null) {
                throw new NullPointerException();
            } else {
                internalGetMutableFields().getMutableMap().put(key, value);
                return this;
            }
        }

        public Builder putAllFields(Map<String, Value> values) {
            internalGetMutableFields().getMutableMap().putAll(values);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
            return setUnknownFields(unknownFields);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
            return mergeUnknownFields(unknownFields);
        }
    }

    public static Struct getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Struct> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Struct> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Struct getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
