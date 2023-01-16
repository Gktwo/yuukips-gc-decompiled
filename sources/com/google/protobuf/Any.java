package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:com/google/protobuf/Any.class */
public final class Any extends GeneratedMessageV3 implements AnyOrBuilder {
    private static final long serialVersionUID = 0;
    private volatile Message cachedUnpackValue;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    private volatile Object typeUrl_;
    public static final int VALUE_FIELD_NUMBER = 2;
    private ByteString value_;
    private byte memoizedIsInitialized;
    private static final Any DEFAULT_INSTANCE = new Any();
    private static final Parser<Any> PARSER = new AbstractParser<Any>() { // from class: com.google.protobuf.Any.1
        @Override // com.google.protobuf.Parser
        public Any parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return new Any(input, extensionRegistry);
        }
    };

    private Any(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    private Any() {
        this.memoizedIsInitialized = -1;
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new Any();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private Any(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        this();
        UnknownFieldSet.Builder unknownFields;
        if (extensionRegistry == null) {
            throw new NullPointerException();
        }
        try {
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
                                this.typeUrl_ = input.readStringRequireUtf8();
                                break;
                            case 18:
                                this.value_ = input.readBytes();
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                    } catch (IOException e) {
                        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                }
            }
        } finally {
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return AnyProto.internal_static_google_protobuf_Any_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Builder.class);
    }

    private static String getTypeUrl(String typeUrlPrefix, Descriptors.Descriptor descriptor) {
        if (typeUrlPrefix.endsWith("/")) {
            return typeUrlPrefix + descriptor.getFullName();
        }
        return typeUrlPrefix + "/" + descriptor.getFullName();
    }

    private static String getTypeNameFromTypeUrl(String typeUrl) {
        int pos = typeUrl.lastIndexOf(47);
        return pos == -1 ? "" : typeUrl.substring(pos + 1);
    }

    public static <T extends Message> Any pack(T message) {
        return newBuilder().setTypeUrl(getTypeUrl("type.googleapis.com", message.getDescriptorForType())).setValue(message.toByteString()).build();
    }

    public static <T extends Message> Any pack(T message, String typeUrlPrefix) {
        return newBuilder().setTypeUrl(getTypeUrl(typeUrlPrefix, message.getDescriptorForType())).setValue(message.toByteString()).build();
    }

    /* renamed from: is */
    public <T extends Message> boolean m1297is(Class<T> clazz) {
        return getTypeNameFromTypeUrl(getTypeUrl()).equals(((Message) Internal.getDefaultInstance(clazz)).getDescriptorForType().getFullName());
    }

    public <T extends Message> T unpack(Class<T> clazz) throws InvalidProtocolBufferException {
        boolean invalidClazz = false;
        if (this.cachedUnpackValue != null) {
            if (this.cachedUnpackValue.getClass() == clazz) {
                return (T) this.cachedUnpackValue;
            }
            invalidClazz = true;
        }
        if (invalidClazz || !m1297is(clazz)) {
            throw new InvalidProtocolBufferException("Type of the Any message does not match the given class.");
        }
        T result = (T) ((Message) ((Message) Internal.getDefaultInstance(clazz)).getParserForType().parseFrom(getValue()));
        this.cachedUnpackValue = result;
        return result;
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public String getTypeUrl() {
        Object ref = this.typeUrl_;
        if (ref instanceof String) {
            return (String) ref;
        }
        String s = ((ByteString) ref).toStringUtf8();
        this.typeUrl_ = s;
        return s;
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public ByteString getTypeUrlBytes() {
        Object ref = this.typeUrl_;
        if (!(ref instanceof String)) {
            return (ByteString) ref;
        }
        ByteString b = ByteString.copyFromUtf8((String) ref);
        this.typeUrl_ = b;
        return b;
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public ByteString getValue() {
        return this.value_;
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
        if (!GeneratedMessageV3.isStringEmpty(this.typeUrl_)) {
            GeneratedMessageV3.writeString(output, 1, this.typeUrl_);
        }
        if (!this.value_.isEmpty()) {
            output.writeBytes(2, this.value_);
        }
        this.unknownFields.writeTo(output);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.memoizedSize;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!GeneratedMessageV3.isStringEmpty(this.typeUrl_)) {
            size2 = 0 + GeneratedMessageV3.computeStringSize(1, this.typeUrl_);
        }
        if (!this.value_.isEmpty()) {
            size2 += CodedOutputStream.computeBytesSize(2, this.value_);
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
        if (!(obj instanceof Any)) {
            return equals(obj);
        }
        Any other = (Any) obj;
        return getTypeUrl().equals(other.getTypeUrl()) && getValue().equals(other.getValue()) && this.unknownFields.equals(other.unknownFields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getTypeUrl().hashCode())) + 2)) + getValue().hashCode())) + this.unknownFields.hashCode();
        this.memoizedHashCode = hash;
        return hash;
    }

    public static Any parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Any parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Any parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Any parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Any parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Any parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Any parseFrom(InputStream input) throws IOException {
        return (Any) GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static Any parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Any) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Any parseDelimitedFrom(InputStream input) throws IOException {
        return (Any) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static Any parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Any) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static Any parseFrom(CodedInputStream input) throws IOException {
        return (Any) GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static Any parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Any) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Any prototype) {
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

    /* loaded from: grasscutter.jar:com/google/protobuf/Any$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AnyOrBuilder {
        private Object typeUrl_;
        private ByteString value_;

        public static final Descriptors.Descriptor getDescriptor() {
            return AnyProto.internal_static_google_protobuf_Any_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Builder.class);
        }

        private Builder() {
            this.typeUrl_ = "";
            this.value_ = ByteString.EMPTY;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent parent) {
            super(parent);
            this.typeUrl_ = "";
            this.value_ = ByteString.EMPTY;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            clear();
            this.typeUrl_ = "";
            this.value_ = ByteString.EMPTY;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return AnyProto.internal_static_google_protobuf_Any_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Any getDefaultInstanceForType() {
            return Any.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Any build() {
            Any result = buildPartial();
            if (result.isInitialized()) {
                return result;
            }
            throw newUninitializedMessageException((Message) result);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Any buildPartial() {
            Any result = new Any(this);
            result.typeUrl_ = this.typeUrl_;
            result.value_ = this.value_;
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
            if (other instanceof Any) {
                return mergeFrom((Any) other);
            }
            mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(Any other) {
            if (other == Any.getDefaultInstance()) {
                return this;
            }
            if (!other.getTypeUrl().isEmpty()) {
                this.typeUrl_ = other.typeUrl_;
                onChanged();
            }
            if (other.getValue() != ByteString.EMPTY) {
                setValue(other.getValue());
            }
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
            Any parsedMessage = null;
            try {
                try {
                    parsedMessage = (Any) Any.PARSER.parsePartialFrom(input, extensionRegistry);
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Any) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                }
            } catch (Throwable th) {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
                throw th;
            }
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public String getTypeUrl() {
            Object ref = this.typeUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.typeUrl_ = s;
            return s;
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public ByteString getTypeUrlBytes() {
            Object ref = this.typeUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.typeUrl_ = b;
            return b;
        }

        public Builder setTypeUrl(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.typeUrl_ = value;
            onChanged();
            return this;
        }

        public Builder clearTypeUrl() {
            this.typeUrl_ = Any.getDefaultInstance().getTypeUrl();
            onChanged();
            return this;
        }

        public Builder setTypeUrlBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.checkByteStringIsUtf8(value);
            this.typeUrl_ = value;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public ByteString getValue() {
            return this.value_;
        }

        public Builder setValue(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.value_ = value;
            onChanged();
            return this;
        }

        public Builder clearValue() {
            this.value_ = Any.getDefaultInstance().getValue();
            onChanged();
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

    public static Any getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Any> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Any> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Any getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
