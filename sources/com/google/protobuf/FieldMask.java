package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: grasscutter.jar:com/google/protobuf/FieldMask.class */
public final class FieldMask extends GeneratedMessageV3 implements FieldMaskOrBuilder {
    private static final long serialVersionUID = 0;
    public static final int PATHS_FIELD_NUMBER = 1;
    private LazyStringList paths_;
    private byte memoizedIsInitialized;
    private static final FieldMask DEFAULT_INSTANCE = new FieldMask();
    private static final Parser<FieldMask> PARSER = new AbstractParser<FieldMask>() { // from class: com.google.protobuf.FieldMask.1
        @Override // com.google.protobuf.Parser
        public FieldMask parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return new FieldMask(input, extensionRegistry);
        }
    };

    private FieldMask(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    private FieldMask() {
        this.memoizedIsInitialized = -1;
        this.paths_ = LazyStringArrayList.EMPTY;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new FieldMask();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private FieldMask(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        this();
        int mutable_bitField0_;
        UnknownFieldSet.Builder unknownFields;
        if (extensionRegistry == null) {
            throw new NullPointerException();
        }
        try {
            mutable_bitField0_ = 0;
            unknownFields = UnknownFieldSet.newBuilder();
            boolean done = false;
            while (!done) {
                try {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            String s = input.readStringRequireUtf8();
                            if ((mutable_bitField0_ & 1) == 0) {
                                this.paths_ = new LazyStringArrayList();
                                mutable_bitField0_ |= 1;
                            }
                            this.paths_.add(s);
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
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            }
        } finally {
            if ((mutable_bitField0_ & 1) != 0) {
                this.paths_ = this.paths_.getUnmodifiableView();
            }
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable.ensureFieldAccessorsInitialized(FieldMask.class, Builder.class);
    }

    @Override // com.google.protobuf.FieldMaskOrBuilder
    public ProtocolStringList getPathsList() {
        return this.paths_;
    }

    @Override // com.google.protobuf.FieldMaskOrBuilder
    public int getPathsCount() {
        return this.paths_.size();
    }

    @Override // com.google.protobuf.FieldMaskOrBuilder
    public String getPaths(int index) {
        return (String) this.paths_.get(index);
    }

    @Override // com.google.protobuf.FieldMaskOrBuilder
    public ByteString getPathsBytes(int index) {
        return this.paths_.getByteString(index);
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
        for (int i = 0; i < this.paths_.size(); i++) {
            GeneratedMessageV3.writeString(output, 1, this.paths_.getRaw(i));
        }
        this.unknownFields.writeTo(output);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.memoizedSize;
        if (size != -1) {
            return size;
        }
        int dataSize = 0;
        for (int i = 0; i < this.paths_.size(); i++) {
            dataSize += computeStringSizeNoTag(this.paths_.getRaw(i));
        }
        int size2 = 0 + dataSize + (1 * getPathsList().size()) + this.unknownFields.getSerializedSize();
        this.memoizedSize = size2;
        return size2;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldMask)) {
            return equals(obj);
        }
        FieldMask other = (FieldMask) obj;
        return getPathsList().equals(other.getPathsList()) && this.unknownFields.equals(other.unknownFields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hash = (19 * 41) + getDescriptor().hashCode();
        if (getPathsCount() > 0) {
            hash = (53 * ((37 * hash) + 1)) + getPathsList().hashCode();
        }
        int hash2 = (29 * hash) + this.unknownFields.hashCode();
        this.memoizedHashCode = hash2;
        return hash2;
    }

    public static FieldMask parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static FieldMask parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static FieldMask parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static FieldMask parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static FieldMask parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static FieldMask parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static FieldMask parseFrom(InputStream input) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static FieldMask parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static FieldMask parseDelimitedFrom(InputStream input) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static FieldMask parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static FieldMask parseFrom(CodedInputStream input) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static FieldMask parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(FieldMask prototype) {
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

    /* loaded from: grasscutter.jar:com/google/protobuf/FieldMask$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FieldMaskOrBuilder {
        private int bitField0_;
        private LazyStringList paths_;

        public static final Descriptors.Descriptor getDescriptor() {
            return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable.ensureFieldAccessorsInitialized(FieldMask.class, Builder.class);
        }

        private Builder() {
            this.paths_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent parent) {
            super(parent);
            this.paths_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            clear();
            this.paths_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FieldMask getDefaultInstanceForType() {
            return FieldMask.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public FieldMask build() {
            FieldMask result = buildPartial();
            if (result.isInitialized()) {
                return result;
            }
            throw newUninitializedMessageException((Message) result);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public FieldMask buildPartial() {
            FieldMask result = new FieldMask(this);
            int i = this.bitField0_;
            if ((this.bitField0_ & 1) != 0) {
                this.paths_ = this.paths_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            result.paths_ = this.paths_;
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
            if (other instanceof FieldMask) {
                return mergeFrom((FieldMask) other);
            }
            mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(FieldMask other) {
            if (other == FieldMask.getDefaultInstance()) {
                return this;
            }
            if (!other.paths_.isEmpty()) {
                if (this.paths_.isEmpty()) {
                    this.paths_ = other.paths_;
                    this.bitField0_ &= -2;
                } else {
                    ensurePathsIsMutable();
                    this.paths_.addAll(other.paths_);
                }
                onChanged();
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
            FieldMask parsedMessage = null;
            try {
                try {
                    parsedMessage = (FieldMask) FieldMask.PARSER.parsePartialFrom(input, extensionRegistry);
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FieldMask) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                }
            } catch (Throwable th) {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
                throw th;
            }
        }

        private void ensurePathsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.paths_ = new LazyStringArrayList(this.paths_);
                this.bitField0_ |= 1;
            }
        }

        @Override // com.google.protobuf.FieldMaskOrBuilder
        public ProtocolStringList getPathsList() {
            return this.paths_.getUnmodifiableView();
        }

        @Override // com.google.protobuf.FieldMaskOrBuilder
        public int getPathsCount() {
            return this.paths_.size();
        }

        @Override // com.google.protobuf.FieldMaskOrBuilder
        public String getPaths(int index) {
            return (String) this.paths_.get(index);
        }

        @Override // com.google.protobuf.FieldMaskOrBuilder
        public ByteString getPathsBytes(int index) {
            return this.paths_.getByteString(index);
        }

        public Builder setPaths(int index, String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            ensurePathsIsMutable();
            this.paths_.set(index, value);
            onChanged();
            return this;
        }

        public Builder addPaths(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            ensurePathsIsMutable();
            this.paths_.add(value);
            onChanged();
            return this;
        }

        public Builder addAllPaths(Iterable<String> values) {
            ensurePathsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.paths_);
            onChanged();
            return this;
        }

        public Builder clearPaths() {
            this.paths_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder addPathsBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.checkByteStringIsUtf8(value);
            ensurePathsIsMutable();
            this.paths_.add(value);
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

    public static FieldMask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<FieldMask> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<FieldMask> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public FieldMask getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
