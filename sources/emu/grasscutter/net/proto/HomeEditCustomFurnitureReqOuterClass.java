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
import emu.grasscutter.net.proto.HomeCustomFurnitureInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeEditCustomFurnitureReqOuterClass.class */
public final class HomeEditCustomFurnitureReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n HomeEditCustomFurnitureReq.proto\u001a\u001dHomeCustomFurnitureInfo.proto\"S\n\u001aHomeEditCustomFurnitureReq\u00125\n\u0013customFurnitureInfo\u0018\u0005 \u0001(\u000b2\u0018.HomeCustomFurnitureInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeCustomFurnitureInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeEditCustomFurnitureReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeEditCustomFurnitureReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeEditCustomFurnitureReq_descriptor, new String[]{"CustomFurnitureInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeEditCustomFurnitureReqOuterClass$HomeEditCustomFurnitureReqOrBuilder.class */
    public interface HomeEditCustomFurnitureReqOrBuilder extends MessageOrBuilder {
        boolean hasCustomFurnitureInfo();

        HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo getCustomFurnitureInfo();

        HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder getCustomFurnitureInfoOrBuilder();
    }

    private HomeEditCustomFurnitureReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeEditCustomFurnitureReqOuterClass$HomeEditCustomFurnitureReq.class */
    public static final class HomeEditCustomFurnitureReq extends GeneratedMessageV3 implements HomeEditCustomFurnitureReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CUSTOMFURNITUREINFO_FIELD_NUMBER = 5;
        private HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo customFurnitureInfo_;
        private byte memoizedIsInitialized;
        private static final HomeEditCustomFurnitureReq DEFAULT_INSTANCE = new HomeEditCustomFurnitureReq();
        private static final Parser<HomeEditCustomFurnitureReq> PARSER = new AbstractParser<HomeEditCustomFurnitureReq>() { // from class: emu.grasscutter.net.proto.HomeEditCustomFurnitureReqOuterClass.HomeEditCustomFurnitureReq.1
            @Override // com.google.protobuf.Parser
            public HomeEditCustomFurnitureReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeEditCustomFurnitureReq(input, extensionRegistry);
            }
        };

        private HomeEditCustomFurnitureReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeEditCustomFurnitureReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeEditCustomFurnitureReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeEditCustomFurnitureReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 42:
                                HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.Builder subBuilder = this.customFurnitureInfo_ != null ? this.customFurnitureInfo_.toBuilder() : null;
                                this.customFurnitureInfo_ = (HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo) input.readMessage(HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.customFurnitureInfo_);
                                    this.customFurnitureInfo_ = subBuilder.buildPartial();
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
            return HomeEditCustomFurnitureReqOuterClass.internal_static_HomeEditCustomFurnitureReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeEditCustomFurnitureReqOuterClass.internal_static_HomeEditCustomFurnitureReq_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeEditCustomFurnitureReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeEditCustomFurnitureReqOuterClass.HomeEditCustomFurnitureReqOrBuilder
        public boolean hasCustomFurnitureInfo() {
            return this.customFurnitureInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeEditCustomFurnitureReqOuterClass.HomeEditCustomFurnitureReqOrBuilder
        public HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo getCustomFurnitureInfo() {
            return this.customFurnitureInfo_ == null ? HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.getDefaultInstance() : this.customFurnitureInfo_;
        }

        @Override // emu.grasscutter.net.proto.HomeEditCustomFurnitureReqOuterClass.HomeEditCustomFurnitureReqOrBuilder
        public HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder getCustomFurnitureInfoOrBuilder() {
            return getCustomFurnitureInfo();
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
            if (this.customFurnitureInfo_ != null) {
                output.writeMessage(5, getCustomFurnitureInfo());
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
            if (this.customFurnitureInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(5, getCustomFurnitureInfo());
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
            if (!(obj instanceof HomeEditCustomFurnitureReq)) {
                return equals(obj);
            }
            HomeEditCustomFurnitureReq other = (HomeEditCustomFurnitureReq) obj;
            if (hasCustomFurnitureInfo() != other.hasCustomFurnitureInfo()) {
                return false;
            }
            return (!hasCustomFurnitureInfo() || getCustomFurnitureInfo().equals(other.getCustomFurnitureInfo())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasCustomFurnitureInfo()) {
                hash = (53 * ((37 * hash) + 5)) + getCustomFurnitureInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeEditCustomFurnitureReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeEditCustomFurnitureReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeEditCustomFurnitureReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeEditCustomFurnitureReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeEditCustomFurnitureReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeEditCustomFurnitureReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeEditCustomFurnitureReq parseFrom(InputStream input) throws IOException {
            return (HomeEditCustomFurnitureReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeEditCustomFurnitureReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeEditCustomFurnitureReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeEditCustomFurnitureReq parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeEditCustomFurnitureReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeEditCustomFurnitureReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeEditCustomFurnitureReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeEditCustomFurnitureReq parseFrom(CodedInputStream input) throws IOException {
            return (HomeEditCustomFurnitureReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeEditCustomFurnitureReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeEditCustomFurnitureReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeEditCustomFurnitureReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeEditCustomFurnitureReqOuterClass$HomeEditCustomFurnitureReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeEditCustomFurnitureReqOrBuilder {
            private HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo customFurnitureInfo_;
            private SingleFieldBuilderV3<HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo, HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.Builder, HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder> customFurnitureInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeEditCustomFurnitureReqOuterClass.internal_static_HomeEditCustomFurnitureReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeEditCustomFurnitureReqOuterClass.internal_static_HomeEditCustomFurnitureReq_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeEditCustomFurnitureReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeEditCustomFurnitureReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.customFurnitureInfoBuilder_ == null) {
                    this.customFurnitureInfo_ = null;
                } else {
                    this.customFurnitureInfo_ = null;
                    this.customFurnitureInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeEditCustomFurnitureReqOuterClass.internal_static_HomeEditCustomFurnitureReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeEditCustomFurnitureReq getDefaultInstanceForType() {
                return HomeEditCustomFurnitureReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeEditCustomFurnitureReq build() {
                HomeEditCustomFurnitureReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeEditCustomFurnitureReq buildPartial() {
                HomeEditCustomFurnitureReq result = new HomeEditCustomFurnitureReq(this);
                if (this.customFurnitureInfoBuilder_ == null) {
                    result.customFurnitureInfo_ = this.customFurnitureInfo_;
                } else {
                    result.customFurnitureInfo_ = this.customFurnitureInfoBuilder_.build();
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
                if (other instanceof HomeEditCustomFurnitureReq) {
                    return mergeFrom((HomeEditCustomFurnitureReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeEditCustomFurnitureReq other) {
                if (other == HomeEditCustomFurnitureReq.getDefaultInstance()) {
                    return this;
                }
                if (other.hasCustomFurnitureInfo()) {
                    mergeCustomFurnitureInfo(other.getCustomFurnitureInfo());
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
                HomeEditCustomFurnitureReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeEditCustomFurnitureReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeEditCustomFurnitureReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeEditCustomFurnitureReqOuterClass.HomeEditCustomFurnitureReqOrBuilder
            public boolean hasCustomFurnitureInfo() {
                return (this.customFurnitureInfoBuilder_ == null && this.customFurnitureInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeEditCustomFurnitureReqOuterClass.HomeEditCustomFurnitureReqOrBuilder
            public HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo getCustomFurnitureInfo() {
                if (this.customFurnitureInfoBuilder_ == null) {
                    return this.customFurnitureInfo_ == null ? HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.getDefaultInstance() : this.customFurnitureInfo_;
                }
                return this.customFurnitureInfoBuilder_.getMessage();
            }

            public Builder setCustomFurnitureInfo(HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo value) {
                if (this.customFurnitureInfoBuilder_ != null) {
                    this.customFurnitureInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.customFurnitureInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setCustomFurnitureInfo(HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.Builder builderForValue) {
                if (this.customFurnitureInfoBuilder_ == null) {
                    this.customFurnitureInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.customFurnitureInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeCustomFurnitureInfo(HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo value) {
                if (this.customFurnitureInfoBuilder_ == null) {
                    if (this.customFurnitureInfo_ != null) {
                        this.customFurnitureInfo_ = HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.newBuilder(this.customFurnitureInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.customFurnitureInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.customFurnitureInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearCustomFurnitureInfo() {
                if (this.customFurnitureInfoBuilder_ == null) {
                    this.customFurnitureInfo_ = null;
                    onChanged();
                } else {
                    this.customFurnitureInfo_ = null;
                    this.customFurnitureInfoBuilder_ = null;
                }
                return this;
            }

            public HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.Builder getCustomFurnitureInfoBuilder() {
                onChanged();
                return getCustomFurnitureInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeEditCustomFurnitureReqOuterClass.HomeEditCustomFurnitureReqOrBuilder
            public HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder getCustomFurnitureInfoOrBuilder() {
                if (this.customFurnitureInfoBuilder_ != null) {
                    return this.customFurnitureInfoBuilder_.getMessageOrBuilder();
                }
                return this.customFurnitureInfo_ == null ? HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.getDefaultInstance() : this.customFurnitureInfo_;
            }

            private SingleFieldBuilderV3<HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo, HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.Builder, HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder> getCustomFurnitureInfoFieldBuilder() {
                if (this.customFurnitureInfoBuilder_ == null) {
                    this.customFurnitureInfoBuilder_ = new SingleFieldBuilderV3<>(getCustomFurnitureInfo(), getParentForChildren(), isClean());
                    this.customFurnitureInfo_ = null;
                }
                return this.customFurnitureInfoBuilder_;
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

        public static HomeEditCustomFurnitureReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeEditCustomFurnitureReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeEditCustomFurnitureReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeEditCustomFurnitureReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeCustomFurnitureInfoOuterClass.getDescriptor();
    }
}
