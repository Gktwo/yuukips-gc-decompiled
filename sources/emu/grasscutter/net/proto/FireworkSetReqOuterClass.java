package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.FireworkSetDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireworkSetReqOuterClass.class */
public final class FireworkSetReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014FireworkSetReq.proto\u001a\u0015FireworkSetData.proto\"0\n\u000eFireworkSetReq\u0012\u001e\n\u0004data\u0018\u0002 \u0001(\u000b2\u0010.FireworkSetDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FireworkSetDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FireworkSetReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FireworkSetReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FireworkSetReq_descriptor, new String[]{"Data"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireworkSetReqOuterClass$FireworkSetReqOrBuilder.class */
    public interface FireworkSetReqOrBuilder extends MessageOrBuilder {
        boolean hasData();

        FireworkSetDataOuterClass.FireworkSetData getData();

        FireworkSetDataOuterClass.FireworkSetDataOrBuilder getDataOrBuilder();
    }

    private FireworkSetReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireworkSetReqOuterClass$FireworkSetReq.class */
    public static final class FireworkSetReq extends GeneratedMessageV3 implements FireworkSetReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DATA_FIELD_NUMBER = 2;
        private FireworkSetDataOuterClass.FireworkSetData data_;
        private byte memoizedIsInitialized;
        private static final FireworkSetReq DEFAULT_INSTANCE = new FireworkSetReq();
        private static final Parser<FireworkSetReq> PARSER = new AbstractParser<FireworkSetReq>() { // from class: emu.grasscutter.net.proto.FireworkSetReqOuterClass.FireworkSetReq.1
            @Override // com.google.protobuf.Parser
            public FireworkSetReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FireworkSetReq(input, extensionRegistry);
            }
        };

        private FireworkSetReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FireworkSetReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FireworkSetReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FireworkSetReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 18:
                                FireworkSetDataOuterClass.FireworkSetData.Builder subBuilder = this.data_ != null ? this.data_.toBuilder() : null;
                                this.data_ = (FireworkSetDataOuterClass.FireworkSetData) input.readMessage(FireworkSetDataOuterClass.FireworkSetData.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.data_);
                                    this.data_ = subBuilder.buildPartial();
                                    break;
                                }
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FireworkSetReqOuterClass.internal_static_FireworkSetReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FireworkSetReqOuterClass.internal_static_FireworkSetReq_fieldAccessorTable.ensureFieldAccessorsInitialized(FireworkSetReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FireworkSetReqOuterClass.FireworkSetReqOrBuilder
        public boolean hasData() {
            return this.data_ != null;
        }

        @Override // emu.grasscutter.net.proto.FireworkSetReqOuterClass.FireworkSetReqOrBuilder
        public FireworkSetDataOuterClass.FireworkSetData getData() {
            return this.data_ == null ? FireworkSetDataOuterClass.FireworkSetData.getDefaultInstance() : this.data_;
        }

        @Override // emu.grasscutter.net.proto.FireworkSetReqOuterClass.FireworkSetReqOrBuilder
        public FireworkSetDataOuterClass.FireworkSetDataOrBuilder getDataOrBuilder() {
            return getData();
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
            if (this.data_ != null) {
                output.writeMessage(2, getData());
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
            if (this.data_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getData());
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
            if (!(obj instanceof FireworkSetReq)) {
                return equals(obj);
            }
            FireworkSetReq other = (FireworkSetReq) obj;
            if (hasData() != other.hasData()) {
                return false;
            }
            return (!hasData() || getData().equals(other.getData())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasData()) {
                hash = (53 * ((37 * hash) + 2)) + getData().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FireworkSetReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireworkSetReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireworkSetReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireworkSetReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireworkSetReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireworkSetReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireworkSetReq parseFrom(InputStream input) throws IOException {
            return (FireworkSetReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FireworkSetReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireworkSetReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FireworkSetReq parseDelimitedFrom(InputStream input) throws IOException {
            return (FireworkSetReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FireworkSetReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireworkSetReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FireworkSetReq parseFrom(CodedInputStream input) throws IOException {
            return (FireworkSetReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FireworkSetReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireworkSetReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FireworkSetReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireworkSetReqOuterClass$FireworkSetReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FireworkSetReqOrBuilder {
            private FireworkSetDataOuterClass.FireworkSetData data_;
            private SingleFieldBuilderV3<FireworkSetDataOuterClass.FireworkSetData, FireworkSetDataOuterClass.FireworkSetData.Builder, FireworkSetDataOuterClass.FireworkSetDataOrBuilder> dataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FireworkSetReqOuterClass.internal_static_FireworkSetReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FireworkSetReqOuterClass.internal_static_FireworkSetReq_fieldAccessorTable.ensureFieldAccessorsInitialized(FireworkSetReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FireworkSetReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.dataBuilder_ == null) {
                    this.data_ = null;
                } else {
                    this.data_ = null;
                    this.dataBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FireworkSetReqOuterClass.internal_static_FireworkSetReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FireworkSetReq getDefaultInstanceForType() {
                return FireworkSetReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FireworkSetReq build() {
                FireworkSetReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FireworkSetReq buildPartial() {
                FireworkSetReq result = new FireworkSetReq(this);
                if (this.dataBuilder_ == null) {
                    result.data_ = this.data_;
                } else {
                    result.data_ = this.dataBuilder_.build();
                }
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
                if (other instanceof FireworkSetReq) {
                    return mergeFrom((FireworkSetReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FireworkSetReq other) {
                if (other == FireworkSetReq.getDefaultInstance()) {
                    return this;
                }
                if (other.hasData()) {
                    mergeData(other.getData());
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
                FireworkSetReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = FireworkSetReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FireworkSetReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FireworkSetReqOuterClass.FireworkSetReqOrBuilder
            public boolean hasData() {
                return (this.dataBuilder_ == null && this.data_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.FireworkSetReqOuterClass.FireworkSetReqOrBuilder
            public FireworkSetDataOuterClass.FireworkSetData getData() {
                if (this.dataBuilder_ == null) {
                    return this.data_ == null ? FireworkSetDataOuterClass.FireworkSetData.getDefaultInstance() : this.data_;
                }
                return this.dataBuilder_.getMessage();
            }

            public Builder setData(FireworkSetDataOuterClass.FireworkSetData value) {
                if (this.dataBuilder_ != null) {
                    this.dataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.data_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setData(FireworkSetDataOuterClass.FireworkSetData.Builder builderForValue) {
                if (this.dataBuilder_ == null) {
                    this.data_ = builderForValue.build();
                    onChanged();
                } else {
                    this.dataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeData(FireworkSetDataOuterClass.FireworkSetData value) {
                if (this.dataBuilder_ == null) {
                    if (this.data_ != null) {
                        this.data_ = FireworkSetDataOuterClass.FireworkSetData.newBuilder(this.data_).mergeFrom(value).buildPartial();
                    } else {
                        this.data_ = value;
                    }
                    onChanged();
                } else {
                    this.dataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearData() {
                if (this.dataBuilder_ == null) {
                    this.data_ = null;
                    onChanged();
                } else {
                    this.data_ = null;
                    this.dataBuilder_ = null;
                }
                return this;
            }

            public FireworkSetDataOuterClass.FireworkSetData.Builder getDataBuilder() {
                onChanged();
                return getDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.FireworkSetReqOuterClass.FireworkSetReqOrBuilder
            public FireworkSetDataOuterClass.FireworkSetDataOrBuilder getDataOrBuilder() {
                if (this.dataBuilder_ != null) {
                    return this.dataBuilder_.getMessageOrBuilder();
                }
                return this.data_ == null ? FireworkSetDataOuterClass.FireworkSetData.getDefaultInstance() : this.data_;
            }

            private SingleFieldBuilderV3<FireworkSetDataOuterClass.FireworkSetData, FireworkSetDataOuterClass.FireworkSetData.Builder, FireworkSetDataOuterClass.FireworkSetDataOrBuilder> getDataFieldBuilder() {
                if (this.dataBuilder_ == null) {
                    this.dataBuilder_ = new SingleFieldBuilderV3<>(getData(), getParentForChildren(), isClean());
                    this.data_ = null;
                }
                return this.dataBuilder_;
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

        public static FireworkSetReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FireworkSetReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FireworkSetReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FireworkSetReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FireworkSetDataOuterClass.getDescriptor();
    }
}
