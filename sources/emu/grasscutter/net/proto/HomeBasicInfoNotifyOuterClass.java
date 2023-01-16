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
import emu.grasscutter.net.proto.HomeBasicInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBasicInfoNotifyOuterClass.class */
public final class HomeBasicInfoNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019HomeBasicInfoNotify.proto\u001a\u0013HomeBasicInfo.proto\"9\n\u0013HomeBasicInfoNotify\u0012\"\n\nbasic_info\u0018\u0003 \u0001(\u000b2\u000e.HomeBasicInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeBasicInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeBasicInfoNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeBasicInfoNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeBasicInfoNotify_descriptor, new String[]{"BasicInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBasicInfoNotifyOuterClass$HomeBasicInfoNotifyOrBuilder.class */
    public interface HomeBasicInfoNotifyOrBuilder extends MessageOrBuilder {
        boolean hasBasicInfo();

        HomeBasicInfoOuterClass.HomeBasicInfo getBasicInfo();

        HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder getBasicInfoOrBuilder();
    }

    private HomeBasicInfoNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBasicInfoNotifyOuterClass$HomeBasicInfoNotify.class */
    public static final class HomeBasicInfoNotify extends GeneratedMessageV3 implements HomeBasicInfoNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BASIC_INFO_FIELD_NUMBER = 3;
        private HomeBasicInfoOuterClass.HomeBasicInfo basicInfo_;
        private byte memoizedIsInitialized;
        private static final HomeBasicInfoNotify DEFAULT_INSTANCE = new HomeBasicInfoNotify();
        private static final Parser<HomeBasicInfoNotify> PARSER = new AbstractParser<HomeBasicInfoNotify>() { // from class: emu.grasscutter.net.proto.HomeBasicInfoNotifyOuterClass.HomeBasicInfoNotify.1
            @Override // com.google.protobuf.Parser
            public HomeBasicInfoNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeBasicInfoNotify(input, extensionRegistry);
            }
        };

        private HomeBasicInfoNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeBasicInfoNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeBasicInfoNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeBasicInfoNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 26:
                                HomeBasicInfoOuterClass.HomeBasicInfo.Builder subBuilder = this.basicInfo_ != null ? this.basicInfo_.toBuilder() : null;
                                this.basicInfo_ = (HomeBasicInfoOuterClass.HomeBasicInfo) input.readMessage(HomeBasicInfoOuterClass.HomeBasicInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.basicInfo_);
                                    this.basicInfo_ = subBuilder.buildPartial();
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
            return HomeBasicInfoNotifyOuterClass.internal_static_HomeBasicInfoNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeBasicInfoNotifyOuterClass.internal_static_HomeBasicInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeBasicInfoNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeBasicInfoNotifyOuterClass.HomeBasicInfoNotifyOrBuilder
        public boolean hasBasicInfo() {
            return this.basicInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeBasicInfoNotifyOuterClass.HomeBasicInfoNotifyOrBuilder
        public HomeBasicInfoOuterClass.HomeBasicInfo getBasicInfo() {
            return this.basicInfo_ == null ? HomeBasicInfoOuterClass.HomeBasicInfo.getDefaultInstance() : this.basicInfo_;
        }

        @Override // emu.grasscutter.net.proto.HomeBasicInfoNotifyOuterClass.HomeBasicInfoNotifyOrBuilder
        public HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder getBasicInfoOrBuilder() {
            return getBasicInfo();
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
            if (this.basicInfo_ != null) {
                output.writeMessage(3, getBasicInfo());
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
            if (this.basicInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(3, getBasicInfo());
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
            if (!(obj instanceof HomeBasicInfoNotify)) {
                return equals(obj);
            }
            HomeBasicInfoNotify other = (HomeBasicInfoNotify) obj;
            if (hasBasicInfo() != other.hasBasicInfo()) {
                return false;
            }
            return (!hasBasicInfo() || getBasicInfo().equals(other.getBasicInfo())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasBasicInfo()) {
                hash = (53 * ((37 * hash) + 3)) + getBasicInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeBasicInfoNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeBasicInfoNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeBasicInfoNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeBasicInfoNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeBasicInfoNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeBasicInfoNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeBasicInfoNotify parseFrom(InputStream input) throws IOException {
            return (HomeBasicInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeBasicInfoNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeBasicInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeBasicInfoNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeBasicInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeBasicInfoNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeBasicInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeBasicInfoNotify parseFrom(CodedInputStream input) throws IOException {
            return (HomeBasicInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeBasicInfoNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeBasicInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeBasicInfoNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBasicInfoNotifyOuterClass$HomeBasicInfoNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeBasicInfoNotifyOrBuilder {
            private HomeBasicInfoOuterClass.HomeBasicInfo basicInfo_;
            private SingleFieldBuilderV3<HomeBasicInfoOuterClass.HomeBasicInfo, HomeBasicInfoOuterClass.HomeBasicInfo.Builder, HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder> basicInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeBasicInfoNotifyOuterClass.internal_static_HomeBasicInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeBasicInfoNotifyOuterClass.internal_static_HomeBasicInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeBasicInfoNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeBasicInfoNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.basicInfoBuilder_ == null) {
                    this.basicInfo_ = null;
                } else {
                    this.basicInfo_ = null;
                    this.basicInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeBasicInfoNotifyOuterClass.internal_static_HomeBasicInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeBasicInfoNotify getDefaultInstanceForType() {
                return HomeBasicInfoNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeBasicInfoNotify build() {
                HomeBasicInfoNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeBasicInfoNotify buildPartial() {
                HomeBasicInfoNotify result = new HomeBasicInfoNotify(this);
                if (this.basicInfoBuilder_ == null) {
                    result.basicInfo_ = this.basicInfo_;
                } else {
                    result.basicInfo_ = this.basicInfoBuilder_.build();
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
                if (other instanceof HomeBasicInfoNotify) {
                    return mergeFrom((HomeBasicInfoNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeBasicInfoNotify other) {
                if (other == HomeBasicInfoNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasBasicInfo()) {
                    mergeBasicInfo(other.getBasicInfo());
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
                HomeBasicInfoNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeBasicInfoNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeBasicInfoNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeBasicInfoNotifyOuterClass.HomeBasicInfoNotifyOrBuilder
            public boolean hasBasicInfo() {
                return (this.basicInfoBuilder_ == null && this.basicInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeBasicInfoNotifyOuterClass.HomeBasicInfoNotifyOrBuilder
            public HomeBasicInfoOuterClass.HomeBasicInfo getBasicInfo() {
                if (this.basicInfoBuilder_ == null) {
                    return this.basicInfo_ == null ? HomeBasicInfoOuterClass.HomeBasicInfo.getDefaultInstance() : this.basicInfo_;
                }
                return this.basicInfoBuilder_.getMessage();
            }

            public Builder setBasicInfo(HomeBasicInfoOuterClass.HomeBasicInfo value) {
                if (this.basicInfoBuilder_ != null) {
                    this.basicInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.basicInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setBasicInfo(HomeBasicInfoOuterClass.HomeBasicInfo.Builder builderForValue) {
                if (this.basicInfoBuilder_ == null) {
                    this.basicInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.basicInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeBasicInfo(HomeBasicInfoOuterClass.HomeBasicInfo value) {
                if (this.basicInfoBuilder_ == null) {
                    if (this.basicInfo_ != null) {
                        this.basicInfo_ = HomeBasicInfoOuterClass.HomeBasicInfo.newBuilder(this.basicInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.basicInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.basicInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearBasicInfo() {
                if (this.basicInfoBuilder_ == null) {
                    this.basicInfo_ = null;
                    onChanged();
                } else {
                    this.basicInfo_ = null;
                    this.basicInfoBuilder_ = null;
                }
                return this;
            }

            public HomeBasicInfoOuterClass.HomeBasicInfo.Builder getBasicInfoBuilder() {
                onChanged();
                return getBasicInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeBasicInfoNotifyOuterClass.HomeBasicInfoNotifyOrBuilder
            public HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder getBasicInfoOrBuilder() {
                if (this.basicInfoBuilder_ != null) {
                    return this.basicInfoBuilder_.getMessageOrBuilder();
                }
                return this.basicInfo_ == null ? HomeBasicInfoOuterClass.HomeBasicInfo.getDefaultInstance() : this.basicInfo_;
            }

            private SingleFieldBuilderV3<HomeBasicInfoOuterClass.HomeBasicInfo, HomeBasicInfoOuterClass.HomeBasicInfo.Builder, HomeBasicInfoOuterClass.HomeBasicInfoOrBuilder> getBasicInfoFieldBuilder() {
                if (this.basicInfoBuilder_ == null) {
                    this.basicInfoBuilder_ = new SingleFieldBuilderV3<>(getBasicInfo(), getParentForChildren(), isClean());
                    this.basicInfo_ = null;
                }
                return this.basicInfoBuilder_;
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

        public static HomeBasicInfoNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeBasicInfoNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeBasicInfoNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeBasicInfoNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeBasicInfoOuterClass.getDescriptor();
    }
}
