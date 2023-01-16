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
import emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopBuyGoodsReqOuterClass.class */
public final class HomeLimitedShopBuyGoodsReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n HomeLimitedShopBuyGoodsReq.proto\u001a\u001aHomeLimitedShopGoods.proto\"U\n\u001aHomeLimitedShopBuyGoodsReq\u0012$\n\u0005goods\u0018\u0006 \u0001(\u000b2\u0015.HomeLimitedShopGoods\u0012\u0011\n\tbuy_count\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeLimitedShopGoodsOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeLimitedShopBuyGoodsReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeLimitedShopBuyGoodsReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeLimitedShopBuyGoodsReq_descriptor, new String[]{"Goods", "BuyCount"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopBuyGoodsReqOuterClass$HomeLimitedShopBuyGoodsReqOrBuilder.class */
    public interface HomeLimitedShopBuyGoodsReqOrBuilder extends MessageOrBuilder {
        boolean hasGoods();

        HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods getGoods();

        HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder getGoodsOrBuilder();

        int getBuyCount();
    }

    private HomeLimitedShopBuyGoodsReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopBuyGoodsReqOuterClass$HomeLimitedShopBuyGoodsReq.class */
    public static final class HomeLimitedShopBuyGoodsReq extends GeneratedMessageV3 implements HomeLimitedShopBuyGoodsReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GOODS_FIELD_NUMBER = 6;
        private HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods goods_;
        public static final int BUY_COUNT_FIELD_NUMBER = 13;
        private int buyCount_;
        private byte memoizedIsInitialized;
        private static final HomeLimitedShopBuyGoodsReq DEFAULT_INSTANCE = new HomeLimitedShopBuyGoodsReq();
        private static final Parser<HomeLimitedShopBuyGoodsReq> PARSER = new AbstractParser<HomeLimitedShopBuyGoodsReq>() { // from class: emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsReqOuterClass.HomeLimitedShopBuyGoodsReq.1
            @Override // com.google.protobuf.Parser
            public HomeLimitedShopBuyGoodsReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeLimitedShopBuyGoodsReq(input, extensionRegistry);
            }
        };

        private HomeLimitedShopBuyGoodsReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeLimitedShopBuyGoodsReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeLimitedShopBuyGoodsReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeLimitedShopBuyGoodsReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 50:
                                    HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder subBuilder = this.goods_ != null ? this.goods_.toBuilder() : null;
                                    this.goods_ = (HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods) input.readMessage(HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.goods_);
                                        this.goods_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 104:
                                    this.buyCount_ = input.readUInt32();
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
            return HomeLimitedShopBuyGoodsReqOuterClass.internal_static_HomeLimitedShopBuyGoodsReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeLimitedShopBuyGoodsReqOuterClass.internal_static_HomeLimitedShopBuyGoodsReq_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeLimitedShopBuyGoodsReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsReqOuterClass.HomeLimitedShopBuyGoodsReqOrBuilder
        public boolean hasGoods() {
            return this.goods_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsReqOuterClass.HomeLimitedShopBuyGoodsReqOrBuilder
        public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods getGoods() {
            return this.goods_ == null ? HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.getDefaultInstance() : this.goods_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsReqOuterClass.HomeLimitedShopBuyGoodsReqOrBuilder
        public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder getGoodsOrBuilder() {
            return getGoods();
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsReqOuterClass.HomeLimitedShopBuyGoodsReqOrBuilder
        public int getBuyCount() {
            return this.buyCount_;
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
            if (this.goods_ != null) {
                output.writeMessage(6, getGoods());
            }
            if (this.buyCount_ != 0) {
                output.writeUInt32(13, this.buyCount_);
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
            if (this.goods_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(6, getGoods());
            }
            if (this.buyCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.buyCount_);
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
            if (!(obj instanceof HomeLimitedShopBuyGoodsReq)) {
                return equals(obj);
            }
            HomeLimitedShopBuyGoodsReq other = (HomeLimitedShopBuyGoodsReq) obj;
            if (hasGoods() != other.hasGoods()) {
                return false;
            }
            return (!hasGoods() || getGoods().equals(other.getGoods())) && getBuyCount() == other.getBuyCount() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasGoods()) {
                hash = (53 * ((37 * hash) + 6)) + getGoods().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 13)) + getBuyCount())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeLimitedShopBuyGoodsReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopBuyGoodsReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopBuyGoodsReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopBuyGoodsReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopBuyGoodsReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopBuyGoodsReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopBuyGoodsReq parseFrom(InputStream input) throws IOException {
            return (HomeLimitedShopBuyGoodsReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeLimitedShopBuyGoodsReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopBuyGoodsReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeLimitedShopBuyGoodsReq parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeLimitedShopBuyGoodsReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeLimitedShopBuyGoodsReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopBuyGoodsReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeLimitedShopBuyGoodsReq parseFrom(CodedInputStream input) throws IOException {
            return (HomeLimitedShopBuyGoodsReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeLimitedShopBuyGoodsReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopBuyGoodsReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeLimitedShopBuyGoodsReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopBuyGoodsReqOuterClass$HomeLimitedShopBuyGoodsReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeLimitedShopBuyGoodsReqOrBuilder {
            private HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods goods_;
            private SingleFieldBuilderV3<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder> goodsBuilder_;
            private int buyCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeLimitedShopBuyGoodsReqOuterClass.internal_static_HomeLimitedShopBuyGoodsReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeLimitedShopBuyGoodsReqOuterClass.internal_static_HomeLimitedShopBuyGoodsReq_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeLimitedShopBuyGoodsReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeLimitedShopBuyGoodsReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.goodsBuilder_ == null) {
                    this.goods_ = null;
                } else {
                    this.goods_ = null;
                    this.goodsBuilder_ = null;
                }
                this.buyCount_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeLimitedShopBuyGoodsReqOuterClass.internal_static_HomeLimitedShopBuyGoodsReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeLimitedShopBuyGoodsReq getDefaultInstanceForType() {
                return HomeLimitedShopBuyGoodsReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeLimitedShopBuyGoodsReq build() {
                HomeLimitedShopBuyGoodsReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeLimitedShopBuyGoodsReq buildPartial() {
                HomeLimitedShopBuyGoodsReq result = new HomeLimitedShopBuyGoodsReq(this);
                if (this.goodsBuilder_ == null) {
                    result.goods_ = this.goods_;
                } else {
                    result.goods_ = this.goodsBuilder_.build();
                }
                result.buyCount_ = this.buyCount_;
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
                if (other instanceof HomeLimitedShopBuyGoodsReq) {
                    return mergeFrom((HomeLimitedShopBuyGoodsReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeLimitedShopBuyGoodsReq other) {
                if (other == HomeLimitedShopBuyGoodsReq.getDefaultInstance()) {
                    return this;
                }
                if (other.hasGoods()) {
                    mergeGoods(other.getGoods());
                }
                if (other.getBuyCount() != 0) {
                    setBuyCount(other.getBuyCount());
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
                HomeLimitedShopBuyGoodsReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeLimitedShopBuyGoodsReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeLimitedShopBuyGoodsReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsReqOuterClass.HomeLimitedShopBuyGoodsReqOrBuilder
            public boolean hasGoods() {
                return (this.goodsBuilder_ == null && this.goods_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsReqOuterClass.HomeLimitedShopBuyGoodsReqOrBuilder
            public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods getGoods() {
                if (this.goodsBuilder_ == null) {
                    return this.goods_ == null ? HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.getDefaultInstance() : this.goods_;
                }
                return this.goodsBuilder_.getMessage();
            }

            public Builder setGoods(HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods value) {
                if (this.goodsBuilder_ != null) {
                    this.goodsBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.goods_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setGoods(HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder builderForValue) {
                if (this.goodsBuilder_ == null) {
                    this.goods_ = builderForValue.build();
                    onChanged();
                } else {
                    this.goodsBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeGoods(HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods value) {
                if (this.goodsBuilder_ == null) {
                    if (this.goods_ != null) {
                        this.goods_ = HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.newBuilder(this.goods_).mergeFrom(value).buildPartial();
                    } else {
                        this.goods_ = value;
                    }
                    onChanged();
                } else {
                    this.goodsBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearGoods() {
                if (this.goodsBuilder_ == null) {
                    this.goods_ = null;
                    onChanged();
                } else {
                    this.goods_ = null;
                    this.goodsBuilder_ = null;
                }
                return this;
            }

            public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder getGoodsBuilder() {
                onChanged();
                return getGoodsFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsReqOuterClass.HomeLimitedShopBuyGoodsReqOrBuilder
            public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder getGoodsOrBuilder() {
                if (this.goodsBuilder_ != null) {
                    return this.goodsBuilder_.getMessageOrBuilder();
                }
                return this.goods_ == null ? HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.getDefaultInstance() : this.goods_;
            }

            private SingleFieldBuilderV3<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder> getGoodsFieldBuilder() {
                if (this.goodsBuilder_ == null) {
                    this.goodsBuilder_ = new SingleFieldBuilderV3<>(getGoods(), getParentForChildren(), isClean());
                    this.goods_ = null;
                }
                return this.goodsBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsReqOuterClass.HomeLimitedShopBuyGoodsReqOrBuilder
            public int getBuyCount() {
                return this.buyCount_;
            }

            public Builder setBuyCount(int value) {
                this.buyCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearBuyCount() {
                this.buyCount_ = 0;
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

        public static HomeLimitedShopBuyGoodsReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeLimitedShopBuyGoodsReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeLimitedShopBuyGoodsReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeLimitedShopBuyGoodsReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeLimitedShopGoodsOuterClass.getDescriptor();
    }
}
