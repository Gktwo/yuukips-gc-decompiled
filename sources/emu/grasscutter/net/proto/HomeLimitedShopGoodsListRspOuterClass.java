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
import emu.grasscutter.net.proto.HomeLimitedShopOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopGoodsListRspOuterClass.class */
public final class HomeLimitedShopGoodsListRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!HomeLimitedShopGoodsListRsp.proto\u001a\u0015HomeLimitedShop.proto\"N\n\u001bHomeLimitedShopGoodsListRsp\u0012\u000f\n\u0007retcode\u0018\u0001 \u0001(\u0005\u0012\u001e\n\u0004shop\u0018\f \u0001(\u000b2\u0010.HomeLimitedShopB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeLimitedShopOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeLimitedShopGoodsListRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeLimitedShopGoodsListRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeLimitedShopGoodsListRsp_descriptor, new String[]{"Retcode", "Shop"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopGoodsListRspOuterClass$HomeLimitedShopGoodsListRspOrBuilder.class */
    public interface HomeLimitedShopGoodsListRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        boolean hasShop();

        HomeLimitedShopOuterClass.HomeLimitedShop getShop();

        HomeLimitedShopOuterClass.HomeLimitedShopOrBuilder getShopOrBuilder();
    }

    private HomeLimitedShopGoodsListRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopGoodsListRspOuterClass$HomeLimitedShopGoodsListRsp.class */
    public static final class HomeLimitedShopGoodsListRsp extends GeneratedMessageV3 implements HomeLimitedShopGoodsListRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 1;
        private int retcode_;
        public static final int SHOP_FIELD_NUMBER = 12;
        private HomeLimitedShopOuterClass.HomeLimitedShop shop_;
        private byte memoizedIsInitialized;
        private static final HomeLimitedShopGoodsListRsp DEFAULT_INSTANCE = new HomeLimitedShopGoodsListRsp();
        private static final Parser<HomeLimitedShopGoodsListRsp> PARSER = new AbstractParser<HomeLimitedShopGoodsListRsp>() { // from class: emu.grasscutter.net.proto.HomeLimitedShopGoodsListRspOuterClass.HomeLimitedShopGoodsListRsp.1
            @Override // com.google.protobuf.Parser
            public HomeLimitedShopGoodsListRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeLimitedShopGoodsListRsp(input, extensionRegistry);
            }
        };

        private HomeLimitedShopGoodsListRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeLimitedShopGoodsListRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeLimitedShopGoodsListRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeLimitedShopGoodsListRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 98:
                                    HomeLimitedShopOuterClass.HomeLimitedShop.Builder subBuilder = this.shop_ != null ? this.shop_.toBuilder() : null;
                                    this.shop_ = (HomeLimitedShopOuterClass.HomeLimitedShop) input.readMessage(HomeLimitedShopOuterClass.HomeLimitedShop.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.shop_);
                                        this.shop_ = subBuilder.buildPartial();
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
            return HomeLimitedShopGoodsListRspOuterClass.internal_static_HomeLimitedShopGoodsListRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeLimitedShopGoodsListRspOuterClass.internal_static_HomeLimitedShopGoodsListRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeLimitedShopGoodsListRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsListRspOuterClass.HomeLimitedShopGoodsListRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsListRspOuterClass.HomeLimitedShopGoodsListRspOrBuilder
        public boolean hasShop() {
            return this.shop_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsListRspOuterClass.HomeLimitedShopGoodsListRspOrBuilder
        public HomeLimitedShopOuterClass.HomeLimitedShop getShop() {
            return this.shop_ == null ? HomeLimitedShopOuterClass.HomeLimitedShop.getDefaultInstance() : this.shop_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsListRspOuterClass.HomeLimitedShopGoodsListRspOrBuilder
        public HomeLimitedShopOuterClass.HomeLimitedShopOrBuilder getShopOrBuilder() {
            return getShop();
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
                output.writeInt32(1, this.retcode_);
            }
            if (this.shop_ != null) {
                output.writeMessage(12, getShop());
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
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.retcode_);
            }
            if (this.shop_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getShop());
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
            if (!(obj instanceof HomeLimitedShopGoodsListRsp)) {
                return equals(obj);
            }
            HomeLimitedShopGoodsListRsp other = (HomeLimitedShopGoodsListRsp) obj;
            if (getRetcode() == other.getRetcode() && hasShop() == other.hasShop()) {
                return (!hasShop() || getShop().equals(other.getShop())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getRetcode();
            if (hasShop()) {
                hash = (53 * ((37 * hash) + 12)) + getShop().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeLimitedShopGoodsListRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopGoodsListRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopGoodsListRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopGoodsListRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopGoodsListRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopGoodsListRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopGoodsListRsp parseFrom(InputStream input) throws IOException {
            return (HomeLimitedShopGoodsListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeLimitedShopGoodsListRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopGoodsListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeLimitedShopGoodsListRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeLimitedShopGoodsListRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeLimitedShopGoodsListRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopGoodsListRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeLimitedShopGoodsListRsp parseFrom(CodedInputStream input) throws IOException {
            return (HomeLimitedShopGoodsListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeLimitedShopGoodsListRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopGoodsListRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeLimitedShopGoodsListRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopGoodsListRspOuterClass$HomeLimitedShopGoodsListRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeLimitedShopGoodsListRspOrBuilder {
            private int retcode_;
            private HomeLimitedShopOuterClass.HomeLimitedShop shop_;
            private SingleFieldBuilderV3<HomeLimitedShopOuterClass.HomeLimitedShop, HomeLimitedShopOuterClass.HomeLimitedShop.Builder, HomeLimitedShopOuterClass.HomeLimitedShopOrBuilder> shopBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeLimitedShopGoodsListRspOuterClass.internal_static_HomeLimitedShopGoodsListRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeLimitedShopGoodsListRspOuterClass.internal_static_HomeLimitedShopGoodsListRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeLimitedShopGoodsListRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeLimitedShopGoodsListRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                if (this.shopBuilder_ == null) {
                    this.shop_ = null;
                } else {
                    this.shop_ = null;
                    this.shopBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeLimitedShopGoodsListRspOuterClass.internal_static_HomeLimitedShopGoodsListRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeLimitedShopGoodsListRsp getDefaultInstanceForType() {
                return HomeLimitedShopGoodsListRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeLimitedShopGoodsListRsp build() {
                HomeLimitedShopGoodsListRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeLimitedShopGoodsListRsp buildPartial() {
                HomeLimitedShopGoodsListRsp result = new HomeLimitedShopGoodsListRsp(this);
                result.retcode_ = this.retcode_;
                if (this.shopBuilder_ == null) {
                    result.shop_ = this.shop_;
                } else {
                    result.shop_ = this.shopBuilder_.build();
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
                if (other instanceof HomeLimitedShopGoodsListRsp) {
                    return mergeFrom((HomeLimitedShopGoodsListRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeLimitedShopGoodsListRsp other) {
                if (other == HomeLimitedShopGoodsListRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.hasShop()) {
                    mergeShop(other.getShop());
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
                HomeLimitedShopGoodsListRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeLimitedShopGoodsListRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeLimitedShopGoodsListRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsListRspOuterClass.HomeLimitedShopGoodsListRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsListRspOuterClass.HomeLimitedShopGoodsListRspOrBuilder
            public boolean hasShop() {
                return (this.shopBuilder_ == null && this.shop_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsListRspOuterClass.HomeLimitedShopGoodsListRspOrBuilder
            public HomeLimitedShopOuterClass.HomeLimitedShop getShop() {
                if (this.shopBuilder_ == null) {
                    return this.shop_ == null ? HomeLimitedShopOuterClass.HomeLimitedShop.getDefaultInstance() : this.shop_;
                }
                return this.shopBuilder_.getMessage();
            }

            public Builder setShop(HomeLimitedShopOuterClass.HomeLimitedShop value) {
                if (this.shopBuilder_ != null) {
                    this.shopBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.shop_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setShop(HomeLimitedShopOuterClass.HomeLimitedShop.Builder builderForValue) {
                if (this.shopBuilder_ == null) {
                    this.shop_ = builderForValue.build();
                    onChanged();
                } else {
                    this.shopBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeShop(HomeLimitedShopOuterClass.HomeLimitedShop value) {
                if (this.shopBuilder_ == null) {
                    if (this.shop_ != null) {
                        this.shop_ = HomeLimitedShopOuterClass.HomeLimitedShop.newBuilder(this.shop_).mergeFrom(value).buildPartial();
                    } else {
                        this.shop_ = value;
                    }
                    onChanged();
                } else {
                    this.shopBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearShop() {
                if (this.shopBuilder_ == null) {
                    this.shop_ = null;
                    onChanged();
                } else {
                    this.shop_ = null;
                    this.shopBuilder_ = null;
                }
                return this;
            }

            public HomeLimitedShopOuterClass.HomeLimitedShop.Builder getShopBuilder() {
                onChanged();
                return getShopFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsListRspOuterClass.HomeLimitedShopGoodsListRspOrBuilder
            public HomeLimitedShopOuterClass.HomeLimitedShopOrBuilder getShopOrBuilder() {
                if (this.shopBuilder_ != null) {
                    return this.shopBuilder_.getMessageOrBuilder();
                }
                return this.shop_ == null ? HomeLimitedShopOuterClass.HomeLimitedShop.getDefaultInstance() : this.shop_;
            }

            private SingleFieldBuilderV3<HomeLimitedShopOuterClass.HomeLimitedShop, HomeLimitedShopOuterClass.HomeLimitedShop.Builder, HomeLimitedShopOuterClass.HomeLimitedShopOrBuilder> getShopFieldBuilder() {
                if (this.shopBuilder_ == null) {
                    this.shopBuilder_ = new SingleFieldBuilderV3<>(getShop(), getParentForChildren(), isClean());
                    this.shop_ = null;
                }
                return this.shopBuilder_;
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

        public static HomeLimitedShopGoodsListRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeLimitedShopGoodsListRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeLimitedShopGoodsListRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeLimitedShopGoodsListRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeLimitedShopOuterClass.getDescriptor();
    }
}
