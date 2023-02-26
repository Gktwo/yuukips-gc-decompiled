package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ShopGoodsOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuyGoodsRspOuterClass.class */
public final class BuyGoodsRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011BuyGoodsRsp.proto\u001a\u000fShopGoods.proto\"|\n\u000bBuyGoodsRsp\u0012\u0010\n\bbuyCount\u0018\u0002 \u0001(\r\u0012\u0019\n\u0005goods\u0018\u0001 \u0001(\u000b2\n.ShopGoods\u0012\u001d\n\tgoodsList\u0018\u0007 \u0003(\u000b2\n.ShopGoods\u0012\u000f\n\u0007retcode\u0018\u0005 \u0001(\u0005\u0012\u0010\n\bshopType\u0018\u000e \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ShopGoodsOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BuyGoodsRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BuyGoodsRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BuyGoodsRsp_descriptor, new String[]{"BuyCount", "Goods", "GoodsList", "Retcode", "ShopType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuyGoodsRspOuterClass$BuyGoodsRspOrBuilder.class */
    public interface BuyGoodsRspOrBuilder extends MessageOrBuilder {
        int getBuyCount();

        boolean hasGoods();

        ShopGoodsOuterClass.ShopGoods getGoods();

        ShopGoodsOuterClass.ShopGoodsOrBuilder getGoodsOrBuilder();

        List<ShopGoodsOuterClass.ShopGoods> getGoodsListList();

        ShopGoodsOuterClass.ShopGoods getGoodsList(int i);

        int getGoodsListCount();

        List<? extends ShopGoodsOuterClass.ShopGoodsOrBuilder> getGoodsListOrBuilderList();

        ShopGoodsOuterClass.ShopGoodsOrBuilder getGoodsListOrBuilder(int i);

        int getRetcode();

        int getShopType();
    }

    private BuyGoodsRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuyGoodsRspOuterClass$BuyGoodsRsp.class */
    public static final class BuyGoodsRsp extends GeneratedMessageV3 implements BuyGoodsRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BUYCOUNT_FIELD_NUMBER = 2;
        private int buyCount_;
        public static final int GOODS_FIELD_NUMBER = 1;
        private ShopGoodsOuterClass.ShopGoods goods_;
        public static final int GOODSLIST_FIELD_NUMBER = 7;
        private List<ShopGoodsOuterClass.ShopGoods> goodsList_;
        public static final int RETCODE_FIELD_NUMBER = 5;
        private int retcode_;
        public static final int SHOPTYPE_FIELD_NUMBER = 14;
        private int shopType_;
        private byte memoizedIsInitialized;
        private static final BuyGoodsRsp DEFAULT_INSTANCE = new BuyGoodsRsp();
        private static final Parser<BuyGoodsRsp> PARSER = new AbstractParser<BuyGoodsRsp>() { // from class: emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRsp.1
            @Override // com.google.protobuf.Parser
            public BuyGoodsRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BuyGoodsRsp(input, extensionRegistry);
            }
        };

        private BuyGoodsRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BuyGoodsRsp() {
            this.memoizedIsInitialized = -1;
            this.goodsList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BuyGoodsRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyGoodsRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                ShopGoodsOuterClass.ShopGoods.Builder subBuilder = this.goods_ != null ? this.goods_.toBuilder() : null;
                                this.goods_ = (ShopGoodsOuterClass.ShopGoods) input.readMessage(ShopGoodsOuterClass.ShopGoods.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.goods_);
                                    this.goods_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 16:
                                this.buyCount_ = input.readUInt32();
                                break;
                            case 40:
                                this.retcode_ = input.readInt32();
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.goodsList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.goodsList_.add((ShopGoodsOuterClass.ShopGoods) input.readMessage(ShopGoodsOuterClass.ShopGoods.parser(), extensionRegistry));
                                break;
                            case 112:
                                this.shopType_ = input.readUInt32();
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
                    this.goodsList_ = Collections.unmodifiableList(this.goodsList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BuyGoodsRspOuterClass.internal_static_BuyGoodsRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BuyGoodsRspOuterClass.internal_static_BuyGoodsRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyGoodsRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
        public int getBuyCount() {
            return this.buyCount_;
        }

        @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
        public boolean hasGoods() {
            return this.goods_ != null;
        }

        @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
        public ShopGoodsOuterClass.ShopGoods getGoods() {
            return this.goods_ == null ? ShopGoodsOuterClass.ShopGoods.getDefaultInstance() : this.goods_;
        }

        @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
        public ShopGoodsOuterClass.ShopGoodsOrBuilder getGoodsOrBuilder() {
            return getGoods();
        }

        @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
        public List<ShopGoodsOuterClass.ShopGoods> getGoodsListList() {
            return this.goodsList_;
        }

        @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
        public List<? extends ShopGoodsOuterClass.ShopGoodsOrBuilder> getGoodsListOrBuilderList() {
            return this.goodsList_;
        }

        @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
        public int getGoodsListCount() {
            return this.goodsList_.size();
        }

        @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
        public ShopGoodsOuterClass.ShopGoods getGoodsList(int index) {
            return this.goodsList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
        public ShopGoodsOuterClass.ShopGoodsOrBuilder getGoodsListOrBuilder(int index) {
            return this.goodsList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
        public int getShopType() {
            return this.shopType_;
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
                output.writeMessage(1, getGoods());
            }
            if (this.buyCount_ != 0) {
                output.writeUInt32(2, this.buyCount_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(5, this.retcode_);
            }
            for (int i = 0; i < this.goodsList_.size(); i++) {
                output.writeMessage(7, this.goodsList_.get(i));
            }
            if (this.shopType_ != 0) {
                output.writeUInt32(14, this.shopType_);
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
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getGoods());
            }
            if (this.buyCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.buyCount_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(5, this.retcode_);
            }
            for (int i = 0; i < this.goodsList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.goodsList_.get(i));
            }
            if (this.shopType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.shopType_);
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
            if (!(obj instanceof BuyGoodsRsp)) {
                return equals(obj);
            }
            BuyGoodsRsp other = (BuyGoodsRsp) obj;
            if (getBuyCount() == other.getBuyCount() && hasGoods() == other.hasGoods()) {
                return (!hasGoods() || getGoods().equals(other.getGoods())) && getGoodsListList().equals(other.getGoodsListList()) && getRetcode() == other.getRetcode() && getShopType() == other.getShopType() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getBuyCount();
            if (hasGoods()) {
                hash = (53 * ((37 * hash) + 1)) + getGoods().hashCode();
            }
            if (getGoodsListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getGoodsListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 5)) + getRetcode())) + 14)) + getShopType())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BuyGoodsRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuyGoodsRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyGoodsRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuyGoodsRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyGoodsRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuyGoodsRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyGoodsRsp parseFrom(InputStream input) throws IOException {
            return (BuyGoodsRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BuyGoodsRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyGoodsRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BuyGoodsRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyGoodsRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BuyGoodsRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyGoodsRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BuyGoodsRsp parseFrom(CodedInputStream input) throws IOException {
            return (BuyGoodsRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BuyGoodsRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyGoodsRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BuyGoodsRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuyGoodsRspOuterClass$BuyGoodsRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BuyGoodsRspOrBuilder {
            private int bitField0_;
            private int buyCount_;
            private ShopGoodsOuterClass.ShopGoods goods_;
            private SingleFieldBuilderV3<ShopGoodsOuterClass.ShopGoods, ShopGoodsOuterClass.ShopGoods.Builder, ShopGoodsOuterClass.ShopGoodsOrBuilder> goodsBuilder_;
            private List<ShopGoodsOuterClass.ShopGoods> goodsList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ShopGoodsOuterClass.ShopGoods, ShopGoodsOuterClass.ShopGoods.Builder, ShopGoodsOuterClass.ShopGoodsOrBuilder> goodsListBuilder_;
            private int retcode_;
            private int shopType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BuyGoodsRspOuterClass.internal_static_BuyGoodsRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BuyGoodsRspOuterClass.internal_static_BuyGoodsRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyGoodsRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BuyGoodsRsp.alwaysUseFieldBuilders) {
                    getGoodsListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.buyCount_ = 0;
                if (this.goodsBuilder_ == null) {
                    this.goods_ = null;
                } else {
                    this.goods_ = null;
                    this.goodsBuilder_ = null;
                }
                if (this.goodsListBuilder_ == null) {
                    this.goodsList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.goodsListBuilder_.clear();
                }
                this.retcode_ = 0;
                this.shopType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BuyGoodsRspOuterClass.internal_static_BuyGoodsRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BuyGoodsRsp getDefaultInstanceForType() {
                return BuyGoodsRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BuyGoodsRsp build() {
                BuyGoodsRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BuyGoodsRsp buildPartial() {
                BuyGoodsRsp result = new BuyGoodsRsp(this);
                int i = this.bitField0_;
                result.buyCount_ = this.buyCount_;
                if (this.goodsBuilder_ == null) {
                    result.goods_ = this.goods_;
                } else {
                    result.goods_ = this.goodsBuilder_.build();
                }
                if (this.goodsListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.goodsList_ = Collections.unmodifiableList(this.goodsList_);
                        this.bitField0_ &= -2;
                    }
                    result.goodsList_ = this.goodsList_;
                } else {
                    result.goodsList_ = this.goodsListBuilder_.build();
                }
                result.retcode_ = this.retcode_;
                result.shopType_ = this.shopType_;
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
                if (other instanceof BuyGoodsRsp) {
                    return mergeFrom((BuyGoodsRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BuyGoodsRsp other) {
                if (other == BuyGoodsRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getBuyCount() != 0) {
                    setBuyCount(other.getBuyCount());
                }
                if (other.hasGoods()) {
                    mergeGoods(other.getGoods());
                }
                if (this.goodsListBuilder_ == null) {
                    if (!other.goodsList_.isEmpty()) {
                        if (this.goodsList_.isEmpty()) {
                            this.goodsList_ = other.goodsList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureGoodsListIsMutable();
                            this.goodsList_.addAll(other.goodsList_);
                        }
                        onChanged();
                    }
                } else if (!other.goodsList_.isEmpty()) {
                    if (this.goodsListBuilder_.isEmpty()) {
                        this.goodsListBuilder_.dispose();
                        this.goodsListBuilder_ = null;
                        this.goodsList_ = other.goodsList_;
                        this.bitField0_ &= -2;
                        this.goodsListBuilder_ = BuyGoodsRsp.alwaysUseFieldBuilders ? getGoodsListFieldBuilder() : null;
                    } else {
                        this.goodsListBuilder_.addAllMessages(other.goodsList_);
                    }
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getShopType() != 0) {
                    setShopType(other.getShopType());
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
                BuyGoodsRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = BuyGoodsRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BuyGoodsRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
            public boolean hasGoods() {
                return (this.goodsBuilder_ == null && this.goods_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
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

            private void ensureGoodsListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.goodsList_ = new ArrayList(this.goodsList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
            public List<ShopGoodsOuterClass.ShopGoods> getGoodsListList() {
                if (this.goodsListBuilder_ == null) {
                    return Collections.unmodifiableList(this.goodsList_);
                }
                return this.goodsListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
            public int getGoodsListCount() {
                if (this.goodsListBuilder_ == null) {
                    return this.goodsList_.size();
                }
                return this.goodsListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
            public ShopGoodsOuterClass.ShopGoods getGoodsList(int index) {
                if (this.goodsListBuilder_ == null) {
                    return this.goodsList_.get(index);
                }
                return this.goodsListBuilder_.getMessage(index);
            }

            public Builder setGoodsList(int index, ShopGoodsOuterClass.ShopGoods value) {
                if (this.goodsListBuilder_ != null) {
                    this.goodsListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGoodsListIsMutable();
                    this.goodsList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setGoodsList(int index, ShopGoodsOuterClass.ShopGoods.Builder builderForValue) {
                if (this.goodsListBuilder_ == null) {
                    ensureGoodsListIsMutable();
                    this.goodsList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.goodsListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addGoodsList(ShopGoodsOuterClass.ShopGoods value) {
                if (this.goodsListBuilder_ != null) {
                    this.goodsListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGoodsListIsMutable();
                    this.goodsList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addGoodsList(int index, ShopGoodsOuterClass.ShopGoods value) {
                if (this.goodsListBuilder_ != null) {
                    this.goodsListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGoodsListIsMutable();
                    this.goodsList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addGoodsList(ShopGoodsOuterClass.ShopGoods.Builder builderForValue) {
                if (this.goodsListBuilder_ == null) {
                    ensureGoodsListIsMutable();
                    this.goodsList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.goodsListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addGoodsList(int index, ShopGoodsOuterClass.ShopGoods.Builder builderForValue) {
                if (this.goodsListBuilder_ == null) {
                    ensureGoodsListIsMutable();
                    this.goodsList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.goodsListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllGoodsList(Iterable<? extends ShopGoodsOuterClass.ShopGoods> values) {
                if (this.goodsListBuilder_ == null) {
                    ensureGoodsListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.goodsList_);
                    onChanged();
                } else {
                    this.goodsListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearGoodsList() {
                if (this.goodsListBuilder_ == null) {
                    this.goodsList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.goodsListBuilder_.clear();
                }
                return this;
            }

            public Builder removeGoodsList(int index) {
                if (this.goodsListBuilder_ == null) {
                    ensureGoodsListIsMutable();
                    this.goodsList_.remove(index);
                    onChanged();
                } else {
                    this.goodsListBuilder_.remove(index);
                }
                return this;
            }

            public ShopGoodsOuterClass.ShopGoods.Builder getGoodsListBuilder(int index) {
                return getGoodsListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
            public ShopGoodsOuterClass.ShopGoodsOrBuilder getGoodsListOrBuilder(int index) {
                if (this.goodsListBuilder_ == null) {
                    return this.goodsList_.get(index);
                }
                return this.goodsListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
            public List<? extends ShopGoodsOuterClass.ShopGoodsOrBuilder> getGoodsListOrBuilderList() {
                if (this.goodsListBuilder_ != null) {
                    return this.goodsListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.goodsList_);
            }

            public ShopGoodsOuterClass.ShopGoods.Builder addGoodsListBuilder() {
                return getGoodsListFieldBuilder().addBuilder(ShopGoodsOuterClass.ShopGoods.getDefaultInstance());
            }

            public ShopGoodsOuterClass.ShopGoods.Builder addGoodsListBuilder(int index) {
                return getGoodsListFieldBuilder().addBuilder(index, ShopGoodsOuterClass.ShopGoods.getDefaultInstance());
            }

            public List<ShopGoodsOuterClass.ShopGoods.Builder> getGoodsListBuilderList() {
                return getGoodsListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ShopGoodsOuterClass.ShopGoods, ShopGoodsOuterClass.ShopGoods.Builder, ShopGoodsOuterClass.ShopGoodsOrBuilder> getGoodsListFieldBuilder() {
                if (this.goodsListBuilder_ == null) {
                    this.goodsListBuilder_ = new RepeatedFieldBuilderV3<>(this.goodsList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.goodsList_ = null;
                }
                return this.goodsListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.BuyGoodsRspOuterClass.BuyGoodsRspOrBuilder
            public int getShopType() {
                return this.shopType_;
            }

            public Builder setShopType(int value) {
                this.shopType_ = value;
                onChanged();
                return this;
            }

            public Builder clearShopType() {
                this.shopType_ = 0;
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

        public static BuyGoodsRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BuyGoodsRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BuyGoodsRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BuyGoodsRsp getDefaultInstanceForType() {
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
