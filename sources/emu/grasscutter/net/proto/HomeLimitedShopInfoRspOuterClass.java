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
import emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopInfoRspOuterClass.class */
public final class HomeLimitedShopInfoRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cHomeLimitedShopInfoRsp.proto\u001a\u0019HomeLimitedShopInfo.proto\"Q\n\u0016HomeLimitedShopInfoRsp\u0012\u000f\n\u0007retcode\u0018\n \u0001(\u0005\u0012&\n\bshopInfo\u0018\u0007 \u0001(\u000b2\u0014.HomeLimitedShopInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeLimitedShopInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeLimitedShopInfoRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeLimitedShopInfoRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeLimitedShopInfoRsp_descriptor, new String[]{"Retcode", "ShopInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopInfoRspOuterClass$HomeLimitedShopInfoRspOrBuilder.class */
    public interface HomeLimitedShopInfoRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        boolean hasShopInfo();

        HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo getShopInfo();

        HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder getShopInfoOrBuilder();
    }

    private HomeLimitedShopInfoRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopInfoRspOuterClass$HomeLimitedShopInfoRsp.class */
    public static final class HomeLimitedShopInfoRsp extends GeneratedMessageV3 implements HomeLimitedShopInfoRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 10;
        private int retcode_;
        public static final int SHOPINFO_FIELD_NUMBER = 7;
        private HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo shopInfo_;
        private byte memoizedIsInitialized;
        private static final HomeLimitedShopInfoRsp DEFAULT_INSTANCE = new HomeLimitedShopInfoRsp();
        private static final Parser<HomeLimitedShopInfoRsp> PARSER = new AbstractParser<HomeLimitedShopInfoRsp>() { // from class: emu.grasscutter.net.proto.HomeLimitedShopInfoRspOuterClass.HomeLimitedShopInfoRsp.1
            @Override // com.google.protobuf.Parser
            public HomeLimitedShopInfoRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeLimitedShopInfoRsp(input, extensionRegistry);
            }
        };

        private HomeLimitedShopInfoRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeLimitedShopInfoRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeLimitedShopInfoRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeLimitedShopInfoRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 58:
                                    HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.Builder subBuilder = this.shopInfo_ != null ? this.shopInfo_.toBuilder() : null;
                                    this.shopInfo_ = (HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo) input.readMessage(HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.shopInfo_);
                                        this.shopInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 80:
                                    this.retcode_ = input.readInt32();
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
            return HomeLimitedShopInfoRspOuterClass.internal_static_HomeLimitedShopInfoRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeLimitedShopInfoRspOuterClass.internal_static_HomeLimitedShopInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeLimitedShopInfoRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoRspOuterClass.HomeLimitedShopInfoRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoRspOuterClass.HomeLimitedShopInfoRspOrBuilder
        public boolean hasShopInfo() {
            return this.shopInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoRspOuterClass.HomeLimitedShopInfoRspOrBuilder
        public HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo getShopInfo() {
            return this.shopInfo_ == null ? HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.getDefaultInstance() : this.shopInfo_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoRspOuterClass.HomeLimitedShopInfoRspOrBuilder
        public HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder getShopInfoOrBuilder() {
            return getShopInfo();
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
            if (this.shopInfo_ != null) {
                output.writeMessage(7, getShopInfo());
            }
            if (this.retcode_ != 0) {
                output.writeInt32(10, this.retcode_);
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
            if (this.shopInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(7, getShopInfo());
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(10, this.retcode_);
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
            if (!(obj instanceof HomeLimitedShopInfoRsp)) {
                return equals(obj);
            }
            HomeLimitedShopInfoRsp other = (HomeLimitedShopInfoRsp) obj;
            if (getRetcode() == other.getRetcode() && hasShopInfo() == other.hasShopInfo()) {
                return (!hasShopInfo() || getShopInfo().equals(other.getShopInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getRetcode();
            if (hasShopInfo()) {
                hash = (53 * ((37 * hash) + 7)) + getShopInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeLimitedShopInfoRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopInfoRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopInfoRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopInfoRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopInfoRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopInfoRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopInfoRsp parseFrom(InputStream input) throws IOException {
            return (HomeLimitedShopInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeLimitedShopInfoRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeLimitedShopInfoRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeLimitedShopInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeLimitedShopInfoRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeLimitedShopInfoRsp parseFrom(CodedInputStream input) throws IOException {
            return (HomeLimitedShopInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeLimitedShopInfoRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeLimitedShopInfoRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopInfoRspOuterClass$HomeLimitedShopInfoRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeLimitedShopInfoRspOrBuilder {
            private int retcode_;
            private HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo shopInfo_;
            private SingleFieldBuilderV3<HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo, HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.Builder, HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder> shopInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeLimitedShopInfoRspOuterClass.internal_static_HomeLimitedShopInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeLimitedShopInfoRspOuterClass.internal_static_HomeLimitedShopInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeLimitedShopInfoRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeLimitedShopInfoRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                if (this.shopInfoBuilder_ == null) {
                    this.shopInfo_ = null;
                } else {
                    this.shopInfo_ = null;
                    this.shopInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeLimitedShopInfoRspOuterClass.internal_static_HomeLimitedShopInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeLimitedShopInfoRsp getDefaultInstanceForType() {
                return HomeLimitedShopInfoRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeLimitedShopInfoRsp build() {
                HomeLimitedShopInfoRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeLimitedShopInfoRsp buildPartial() {
                HomeLimitedShopInfoRsp result = new HomeLimitedShopInfoRsp(this);
                result.retcode_ = this.retcode_;
                if (this.shopInfoBuilder_ == null) {
                    result.shopInfo_ = this.shopInfo_;
                } else {
                    result.shopInfo_ = this.shopInfoBuilder_.build();
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
                if (other instanceof HomeLimitedShopInfoRsp) {
                    return mergeFrom((HomeLimitedShopInfoRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeLimitedShopInfoRsp other) {
                if (other == HomeLimitedShopInfoRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.hasShopInfo()) {
                    mergeShopInfo(other.getShopInfo());
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
                HomeLimitedShopInfoRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeLimitedShopInfoRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeLimitedShopInfoRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoRspOuterClass.HomeLimitedShopInfoRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoRspOuterClass.HomeLimitedShopInfoRspOrBuilder
            public boolean hasShopInfo() {
                return (this.shopInfoBuilder_ == null && this.shopInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoRspOuterClass.HomeLimitedShopInfoRspOrBuilder
            public HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo getShopInfo() {
                if (this.shopInfoBuilder_ == null) {
                    return this.shopInfo_ == null ? HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.getDefaultInstance() : this.shopInfo_;
                }
                return this.shopInfoBuilder_.getMessage();
            }

            public Builder setShopInfo(HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo value) {
                if (this.shopInfoBuilder_ != null) {
                    this.shopInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.shopInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setShopInfo(HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.Builder builderForValue) {
                if (this.shopInfoBuilder_ == null) {
                    this.shopInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.shopInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeShopInfo(HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo value) {
                if (this.shopInfoBuilder_ == null) {
                    if (this.shopInfo_ != null) {
                        this.shopInfo_ = HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.newBuilder(this.shopInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.shopInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.shopInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearShopInfo() {
                if (this.shopInfoBuilder_ == null) {
                    this.shopInfo_ = null;
                    onChanged();
                } else {
                    this.shopInfo_ = null;
                    this.shopInfoBuilder_ = null;
                }
                return this;
            }

            public HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.Builder getShopInfoBuilder() {
                onChanged();
                return getShopInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoRspOuterClass.HomeLimitedShopInfoRspOrBuilder
            public HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder getShopInfoOrBuilder() {
                if (this.shopInfoBuilder_ != null) {
                    return this.shopInfoBuilder_.getMessageOrBuilder();
                }
                return this.shopInfo_ == null ? HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.getDefaultInstance() : this.shopInfo_;
            }

            private SingleFieldBuilderV3<HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo, HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.Builder, HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder> getShopInfoFieldBuilder() {
                if (this.shopInfoBuilder_ == null) {
                    this.shopInfoBuilder_ = new SingleFieldBuilderV3<>(getShopInfo(), getParentForChildren(), isClean());
                    this.shopInfo_ = null;
                }
                return this.shopInfoBuilder_;
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

        public static HomeLimitedShopInfoRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeLimitedShopInfoRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeLimitedShopInfoRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeLimitedShopInfoRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeLimitedShopInfoOuterClass.getDescriptor();
    }
}
