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
import emu.grasscutter.net.proto.ShopGoodsOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuyGoodsParamOuterClass.class */
public final class BuyGoodsParamOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013BuyGoodsParam.proto\u001a\u000fShopGoods.proto\"<\n\rBuyGoodsParam\u0012\u0019\n\u0005goods\u0018\b \u0001(\u000b2\n.ShopGoods\u0012\u0010\n\bbuyCount\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ShopGoodsOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BuyGoodsParam_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BuyGoodsParam_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BuyGoodsParam_descriptor, new String[]{"Goods", "BuyCount"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuyGoodsParamOuterClass$BuyGoodsParamOrBuilder.class */
    public interface BuyGoodsParamOrBuilder extends MessageOrBuilder {
        boolean hasGoods();

        ShopGoodsOuterClass.ShopGoods getGoods();

        ShopGoodsOuterClass.ShopGoodsOrBuilder getGoodsOrBuilder();

        int getBuyCount();
    }

    private BuyGoodsParamOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuyGoodsParamOuterClass$BuyGoodsParam.class */
    public static final class BuyGoodsParam extends GeneratedMessageV3 implements BuyGoodsParamOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GOODS_FIELD_NUMBER = 8;
        private ShopGoodsOuterClass.ShopGoods goods_;
        public static final int BUYCOUNT_FIELD_NUMBER = 3;
        private int buyCount_;
        private byte memoizedIsInitialized;
        private static final BuyGoodsParam DEFAULT_INSTANCE = new BuyGoodsParam();
        private static final Parser<BuyGoodsParam> PARSER = new AbstractParser<BuyGoodsParam>() { // from class: emu.grasscutter.net.proto.BuyGoodsParamOuterClass.BuyGoodsParam.1
            @Override // com.google.protobuf.Parser
            public BuyGoodsParam parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BuyGoodsParam(input, extensionRegistry);
            }
        };

        private BuyGoodsParam(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BuyGoodsParam() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BuyGoodsParam();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyGoodsParam(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.buyCount_ = input.readUInt32();
                                    break;
                                case 66:
                                    ShopGoodsOuterClass.ShopGoods.Builder subBuilder = this.goods_ != null ? this.goods_.toBuilder() : null;
                                    this.goods_ = (ShopGoodsOuterClass.ShopGoods) input.readMessage(ShopGoodsOuterClass.ShopGoods.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.goods_);
                                        this.goods_ = subBuilder.buildPartial();
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
            return BuyGoodsParamOuterClass.internal_static_BuyGoodsParam_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BuyGoodsParamOuterClass.internal_static_BuyGoodsParam_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyGoodsParam.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder
        public boolean hasGoods() {
            return this.goods_ != null;
        }

        @Override // emu.grasscutter.net.proto.BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder
        public ShopGoodsOuterClass.ShopGoods getGoods() {
            return this.goods_ == null ? ShopGoodsOuterClass.ShopGoods.getDefaultInstance() : this.goods_;
        }

        @Override // emu.grasscutter.net.proto.BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder
        public ShopGoodsOuterClass.ShopGoodsOrBuilder getGoodsOrBuilder() {
            return getGoods();
        }

        @Override // emu.grasscutter.net.proto.BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder
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
            if (this.buyCount_ != 0) {
                output.writeUInt32(3, this.buyCount_);
            }
            if (this.goods_ != null) {
                output.writeMessage(8, getGoods());
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
            if (this.buyCount_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.buyCount_);
            }
            if (this.goods_ != null) {
                size2 += CodedOutputStream.computeMessageSize(8, getGoods());
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
            if (!(obj instanceof BuyGoodsParam)) {
                return equals(obj);
            }
            BuyGoodsParam other = (BuyGoodsParam) obj;
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
                hash = (53 * ((37 * hash) + 8)) + getGoods().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 3)) + getBuyCount())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BuyGoodsParam parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuyGoodsParam parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyGoodsParam parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuyGoodsParam parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyGoodsParam parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuyGoodsParam parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyGoodsParam parseFrom(InputStream input) throws IOException {
            return (BuyGoodsParam) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BuyGoodsParam parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyGoodsParam) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BuyGoodsParam parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyGoodsParam) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BuyGoodsParam parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyGoodsParam) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BuyGoodsParam parseFrom(CodedInputStream input) throws IOException {
            return (BuyGoodsParam) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BuyGoodsParam parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyGoodsParam) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BuyGoodsParam prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuyGoodsParamOuterClass$BuyGoodsParam$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BuyGoodsParamOrBuilder {
            private ShopGoodsOuterClass.ShopGoods goods_;
            private SingleFieldBuilderV3<ShopGoodsOuterClass.ShopGoods, ShopGoodsOuterClass.ShopGoods.Builder, ShopGoodsOuterClass.ShopGoodsOrBuilder> goodsBuilder_;
            private int buyCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BuyGoodsParamOuterClass.internal_static_BuyGoodsParam_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BuyGoodsParamOuterClass.internal_static_BuyGoodsParam_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyGoodsParam.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BuyGoodsParam.alwaysUseFieldBuilders) {
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
                return BuyGoodsParamOuterClass.internal_static_BuyGoodsParam_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BuyGoodsParam getDefaultInstanceForType() {
                return BuyGoodsParam.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BuyGoodsParam build() {
                BuyGoodsParam result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BuyGoodsParam buildPartial() {
                BuyGoodsParam result = new BuyGoodsParam(this);
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
                if (other instanceof BuyGoodsParam) {
                    return mergeFrom((BuyGoodsParam) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BuyGoodsParam other) {
                if (other == BuyGoodsParam.getDefaultInstance()) {
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
                BuyGoodsParam parsedMessage = null;
                try {
                    try {
                        parsedMessage = BuyGoodsParam.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BuyGoodsParam) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder
            public boolean hasGoods() {
                return (this.goodsBuilder_ == null && this.goods_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder
            public ShopGoodsOuterClass.ShopGoods getGoods() {
                if (this.goodsBuilder_ == null) {
                    return this.goods_ == null ? ShopGoodsOuterClass.ShopGoods.getDefaultInstance() : this.goods_;
                }
                return this.goodsBuilder_.getMessage();
            }

            public Builder setGoods(ShopGoodsOuterClass.ShopGoods value) {
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

            public Builder setGoods(ShopGoodsOuterClass.ShopGoods.Builder builderForValue) {
                if (this.goodsBuilder_ == null) {
                    this.goods_ = builderForValue.build();
                    onChanged();
                } else {
                    this.goodsBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeGoods(ShopGoodsOuterClass.ShopGoods value) {
                if (this.goodsBuilder_ == null) {
                    if (this.goods_ != null) {
                        this.goods_ = ShopGoodsOuterClass.ShopGoods.newBuilder(this.goods_).mergeFrom(value).buildPartial();
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

            public ShopGoodsOuterClass.ShopGoods.Builder getGoodsBuilder() {
                onChanged();
                return getGoodsFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder
            public ShopGoodsOuterClass.ShopGoodsOrBuilder getGoodsOrBuilder() {
                if (this.goodsBuilder_ != null) {
                    return this.goodsBuilder_.getMessageOrBuilder();
                }
                return this.goods_ == null ? ShopGoodsOuterClass.ShopGoods.getDefaultInstance() : this.goods_;
            }

            private SingleFieldBuilderV3<ShopGoodsOuterClass.ShopGoods, ShopGoodsOuterClass.ShopGoods.Builder, ShopGoodsOuterClass.ShopGoodsOrBuilder> getGoodsFieldBuilder() {
                if (this.goodsBuilder_ == null) {
                    this.goodsBuilder_ = new SingleFieldBuilderV3<>(getGoods(), getParentForChildren(), isClean());
                    this.goods_ = null;
                }
                return this.goodsBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder
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

        public static BuyGoodsParam getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BuyGoodsParam> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BuyGoodsParam> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BuyGoodsParam getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ShopGoodsOuterClass.getDescriptor();
    }
}
