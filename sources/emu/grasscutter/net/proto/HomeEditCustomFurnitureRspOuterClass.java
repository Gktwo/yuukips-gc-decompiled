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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeEditCustomFurnitureRspOuterClass.class */
public final class HomeEditCustomFurnitureRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n HomeEditCustomFurnitureRsp.proto\u001a\u001dHomeCustomFurnitureInfo.proto\"d\n\u001aHomeEditCustomFurnitureRsp\u0012\u000f\n\u0007retcode\u0018\u0007 \u0001(\u0005\u00125\n\u0013customFurnitureInfo\u0018\u000b \u0001(\u000b2\u0018.HomeCustomFurnitureInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeCustomFurnitureInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeEditCustomFurnitureRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeEditCustomFurnitureRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeEditCustomFurnitureRsp_descriptor, new String[]{"Retcode", "CustomFurnitureInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeEditCustomFurnitureRspOuterClass$HomeEditCustomFurnitureRspOrBuilder.class */
    public interface HomeEditCustomFurnitureRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        boolean hasCustomFurnitureInfo();

        HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo getCustomFurnitureInfo();

        HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder getCustomFurnitureInfoOrBuilder();
    }

    private HomeEditCustomFurnitureRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeEditCustomFurnitureRspOuterClass$HomeEditCustomFurnitureRsp.class */
    public static final class HomeEditCustomFurnitureRsp extends GeneratedMessageV3 implements HomeEditCustomFurnitureRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 7;
        private int retcode_;
        public static final int CUSTOMFURNITUREINFO_FIELD_NUMBER = 11;
        private HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo customFurnitureInfo_;
        private byte memoizedIsInitialized;
        private static final HomeEditCustomFurnitureRsp DEFAULT_INSTANCE = new HomeEditCustomFurnitureRsp();
        private static final Parser<HomeEditCustomFurnitureRsp> PARSER = new AbstractParser<HomeEditCustomFurnitureRsp>() { // from class: emu.grasscutter.net.proto.HomeEditCustomFurnitureRspOuterClass.HomeEditCustomFurnitureRsp.1
            @Override // com.google.protobuf.Parser
            public HomeEditCustomFurnitureRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeEditCustomFurnitureRsp(input, extensionRegistry);
            }
        };

        private HomeEditCustomFurnitureRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeEditCustomFurnitureRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeEditCustomFurnitureRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeEditCustomFurnitureRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 56:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 90:
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
            return HomeEditCustomFurnitureRspOuterClass.internal_static_HomeEditCustomFurnitureRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeEditCustomFurnitureRspOuterClass.internal_static_HomeEditCustomFurnitureRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeEditCustomFurnitureRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeEditCustomFurnitureRspOuterClass.HomeEditCustomFurnitureRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.HomeEditCustomFurnitureRspOuterClass.HomeEditCustomFurnitureRspOrBuilder
        public boolean hasCustomFurnitureInfo() {
            return this.customFurnitureInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeEditCustomFurnitureRspOuterClass.HomeEditCustomFurnitureRspOrBuilder
        public HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo getCustomFurnitureInfo() {
            return this.customFurnitureInfo_ == null ? HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.getDefaultInstance() : this.customFurnitureInfo_;
        }

        @Override // emu.grasscutter.net.proto.HomeEditCustomFurnitureRspOuterClass.HomeEditCustomFurnitureRspOrBuilder
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
            if (this.retcode_ != 0) {
                output.writeInt32(7, this.retcode_);
            }
            if (this.customFurnitureInfo_ != null) {
                output.writeMessage(11, getCustomFurnitureInfo());
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(7, this.retcode_);
            }
            if (this.customFurnitureInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getCustomFurnitureInfo());
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
            if (!(obj instanceof HomeEditCustomFurnitureRsp)) {
                return equals(obj);
            }
            HomeEditCustomFurnitureRsp other = (HomeEditCustomFurnitureRsp) obj;
            if (getRetcode() == other.getRetcode() && hasCustomFurnitureInfo() == other.hasCustomFurnitureInfo()) {
                return (!hasCustomFurnitureInfo() || getCustomFurnitureInfo().equals(other.getCustomFurnitureInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getRetcode();
            if (hasCustomFurnitureInfo()) {
                hash = (53 * ((37 * hash) + 11)) + getCustomFurnitureInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeEditCustomFurnitureRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeEditCustomFurnitureRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeEditCustomFurnitureRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeEditCustomFurnitureRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeEditCustomFurnitureRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeEditCustomFurnitureRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeEditCustomFurnitureRsp parseFrom(InputStream input) throws IOException {
            return (HomeEditCustomFurnitureRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeEditCustomFurnitureRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeEditCustomFurnitureRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeEditCustomFurnitureRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeEditCustomFurnitureRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeEditCustomFurnitureRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeEditCustomFurnitureRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeEditCustomFurnitureRsp parseFrom(CodedInputStream input) throws IOException {
            return (HomeEditCustomFurnitureRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeEditCustomFurnitureRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeEditCustomFurnitureRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeEditCustomFurnitureRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeEditCustomFurnitureRspOuterClass$HomeEditCustomFurnitureRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeEditCustomFurnitureRspOrBuilder {
            private int retcode_;
            private HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo customFurnitureInfo_;
            private SingleFieldBuilderV3<HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo, HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.Builder, HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder> customFurnitureInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeEditCustomFurnitureRspOuterClass.internal_static_HomeEditCustomFurnitureRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeEditCustomFurnitureRspOuterClass.internal_static_HomeEditCustomFurnitureRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeEditCustomFurnitureRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeEditCustomFurnitureRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
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
                return HomeEditCustomFurnitureRspOuterClass.internal_static_HomeEditCustomFurnitureRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeEditCustomFurnitureRsp getDefaultInstanceForType() {
                return HomeEditCustomFurnitureRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeEditCustomFurnitureRsp build() {
                HomeEditCustomFurnitureRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeEditCustomFurnitureRsp buildPartial() {
                HomeEditCustomFurnitureRsp result = new HomeEditCustomFurnitureRsp(this);
                result.retcode_ = this.retcode_;
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
                if (other instanceof HomeEditCustomFurnitureRsp) {
                    return mergeFrom((HomeEditCustomFurnitureRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeEditCustomFurnitureRsp other) {
                if (other == HomeEditCustomFurnitureRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                HomeEditCustomFurnitureRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeEditCustomFurnitureRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeEditCustomFurnitureRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeEditCustomFurnitureRspOuterClass.HomeEditCustomFurnitureRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeEditCustomFurnitureRspOuterClass.HomeEditCustomFurnitureRspOrBuilder
            public boolean hasCustomFurnitureInfo() {
                return (this.customFurnitureInfoBuilder_ == null && this.customFurnitureInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeEditCustomFurnitureRspOuterClass.HomeEditCustomFurnitureRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeEditCustomFurnitureRspOuterClass.HomeEditCustomFurnitureRspOrBuilder
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

        public static HomeEditCustomFurnitureRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeEditCustomFurnitureRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeEditCustomFurnitureRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeEditCustomFurnitureRsp getDefaultInstanceForType() {
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
