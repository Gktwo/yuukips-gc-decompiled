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
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.BuyGoodsParamOuterClass;
import emu.grasscutter.net.proto.ShopGoodsOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BatchBuyGoodsRspOuterClass.class */
public final class BatchBuyGoodsRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016BatchBuyGoodsRsp.proto\u001a\u0013BuyGoodsParam.proto\u001a\u000fShopGoods.proto\"~\n\u0010BatchBuyGoodsRsp\u0012\u0011\n\tshop_type\u0018\u0006 \u0001(\r\u0012\u001e\n\ngoods_list\u0018\u000f \u0003(\u000b2\n.ShopGoods\u0012\u000f\n\u0007retcode\u0018\r \u0001(\u0005\u0012&\n\u000ebuy_goods_list\u0018\b \u0003(\u000b2\u000e.BuyGoodsParamB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BuyGoodsParamOuterClass.getDescriptor(), ShopGoodsOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BatchBuyGoodsRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BatchBuyGoodsRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BatchBuyGoodsRsp_descriptor, new String[]{"ShopType", "GoodsList", "Retcode", "BuyGoodsList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BatchBuyGoodsRspOuterClass$BatchBuyGoodsRspOrBuilder.class */
    public interface BatchBuyGoodsRspOrBuilder extends MessageOrBuilder {
        int getShopType();

        List<ShopGoodsOuterClass.ShopGoods> getGoodsListList();

        ShopGoodsOuterClass.ShopGoods getGoodsList(int i);

        int getGoodsListCount();

        List<? extends ShopGoodsOuterClass.ShopGoodsOrBuilder> getGoodsListOrBuilderList();

        ShopGoodsOuterClass.ShopGoodsOrBuilder getGoodsListOrBuilder(int i);

        int getRetcode();

        List<BuyGoodsParamOuterClass.BuyGoodsParam> getBuyGoodsListList();

        BuyGoodsParamOuterClass.BuyGoodsParam getBuyGoodsList(int i);

        int getBuyGoodsListCount();

        List<? extends BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder> getBuyGoodsListOrBuilderList();

        BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder getBuyGoodsListOrBuilder(int i);
    }

    private BatchBuyGoodsRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BatchBuyGoodsRspOuterClass$BatchBuyGoodsRsp.class */
    public static final class BatchBuyGoodsRsp extends GeneratedMessageV3 implements BatchBuyGoodsRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SHOP_TYPE_FIELD_NUMBER = 6;
        private int shopType_;
        public static final int GOODS_LIST_FIELD_NUMBER = 15;
        private List<ShopGoodsOuterClass.ShopGoods> goodsList_;
        public static final int RETCODE_FIELD_NUMBER = 13;
        private int retcode_;
        public static final int BUY_GOODS_LIST_FIELD_NUMBER = 8;
        private List<BuyGoodsParamOuterClass.BuyGoodsParam> buyGoodsList_;
        private byte memoizedIsInitialized;
        private static final BatchBuyGoodsRsp DEFAULT_INSTANCE = new BatchBuyGoodsRsp();
        private static final Parser<BatchBuyGoodsRsp> PARSER = new AbstractParser<BatchBuyGoodsRsp>() { // from class: emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRsp.1
            @Override // com.google.protobuf.Parser
            public BatchBuyGoodsRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BatchBuyGoodsRsp(input, extensionRegistry);
            }
        };

        private BatchBuyGoodsRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BatchBuyGoodsRsp() {
            this.memoizedIsInitialized = -1;
            this.goodsList_ = Collections.emptyList();
            this.buyGoodsList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BatchBuyGoodsRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x00de */
        private BatchBuyGoodsRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 48:
                                this.shopType_ = input.readUInt32();
                                break;
                            case 66:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.buyGoodsList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.buyGoodsList_.add((BuyGoodsParamOuterClass.BuyGoodsParam) input.readMessage(BuyGoodsParamOuterClass.BuyGoodsParam.parser(), extensionRegistry));
                                break;
                            case 104:
                                this.retcode_ = input.readInt32();
                                break;
                            case 122:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.goodsList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.goodsList_.add((ShopGoodsOuterClass.ShopGoods) input.readMessage(ShopGoodsOuterClass.ShopGoods.parser(), extensionRegistry));
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.buyGoodsList_ = Collections.unmodifiableList(this.buyGoodsList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.goodsList_ = Collections.unmodifiableList(this.goodsList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BatchBuyGoodsRspOuterClass.internal_static_BatchBuyGoodsRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BatchBuyGoodsRspOuterClass.internal_static_BatchBuyGoodsRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(BatchBuyGoodsRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
        public int getShopType() {
            return this.shopType_;
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
        public List<ShopGoodsOuterClass.ShopGoods> getGoodsListList() {
            return this.goodsList_;
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
        public List<? extends ShopGoodsOuterClass.ShopGoodsOrBuilder> getGoodsListOrBuilderList() {
            return this.goodsList_;
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
        public int getGoodsListCount() {
            return this.goodsList_.size();
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
        public ShopGoodsOuterClass.ShopGoods getGoodsList(int index) {
            return this.goodsList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
        public ShopGoodsOuterClass.ShopGoodsOrBuilder getGoodsListOrBuilder(int index) {
            return this.goodsList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
        public List<BuyGoodsParamOuterClass.BuyGoodsParam> getBuyGoodsListList() {
            return this.buyGoodsList_;
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
        public List<? extends BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder> getBuyGoodsListOrBuilderList() {
            return this.buyGoodsList_;
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
        public int getBuyGoodsListCount() {
            return this.buyGoodsList_.size();
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
        public BuyGoodsParamOuterClass.BuyGoodsParam getBuyGoodsList(int index) {
            return this.buyGoodsList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
        public BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder getBuyGoodsListOrBuilder(int index) {
            return this.buyGoodsList_.get(index);
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
            if (this.shopType_ != 0) {
                output.writeUInt32(6, this.shopType_);
            }
            for (int i = 0; i < this.buyGoodsList_.size(); i++) {
                output.writeMessage(8, this.buyGoodsList_.get(i));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(13, this.retcode_);
            }
            for (int i2 = 0; i2 < this.goodsList_.size(); i2++) {
                output.writeMessage(15, this.goodsList_.get(i2));
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
            if (this.shopType_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.shopType_);
            }
            for (int i = 0; i < this.buyGoodsList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(8, this.buyGoodsList_.get(i));
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(13, this.retcode_);
            }
            for (int i2 = 0; i2 < this.goodsList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(15, this.goodsList_.get(i2));
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
            if (!(obj instanceof BatchBuyGoodsRsp)) {
                return equals(obj);
            }
            BatchBuyGoodsRsp other = (BatchBuyGoodsRsp) obj;
            return getShopType() == other.getShopType() && getGoodsListList().equals(other.getGoodsListList()) && getRetcode() == other.getRetcode() && getBuyGoodsListList().equals(other.getBuyGoodsListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getShopType();
            if (getGoodsListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getGoodsListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 13)) + getRetcode();
            if (getBuyGoodsListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 8)) + getBuyGoodsListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static BatchBuyGoodsRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BatchBuyGoodsRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BatchBuyGoodsRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BatchBuyGoodsRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BatchBuyGoodsRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BatchBuyGoodsRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BatchBuyGoodsRsp parseFrom(InputStream input) throws IOException {
            return (BatchBuyGoodsRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BatchBuyGoodsRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BatchBuyGoodsRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BatchBuyGoodsRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (BatchBuyGoodsRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BatchBuyGoodsRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BatchBuyGoodsRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BatchBuyGoodsRsp parseFrom(CodedInputStream input) throws IOException {
            return (BatchBuyGoodsRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BatchBuyGoodsRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BatchBuyGoodsRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BatchBuyGoodsRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BatchBuyGoodsRspOuterClass$BatchBuyGoodsRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BatchBuyGoodsRspOrBuilder {
            private int bitField0_;
            private int shopType_;
            private RepeatedFieldBuilderV3<ShopGoodsOuterClass.ShopGoods, ShopGoodsOuterClass.ShopGoods.Builder, ShopGoodsOuterClass.ShopGoodsOrBuilder> goodsListBuilder_;
            private int retcode_;
            private RepeatedFieldBuilderV3<BuyGoodsParamOuterClass.BuyGoodsParam, BuyGoodsParamOuterClass.BuyGoodsParam.Builder, BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder> buyGoodsListBuilder_;
            private List<ShopGoodsOuterClass.ShopGoods> goodsList_ = Collections.emptyList();
            private List<BuyGoodsParamOuterClass.BuyGoodsParam> buyGoodsList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return BatchBuyGoodsRspOuterClass.internal_static_BatchBuyGoodsRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BatchBuyGoodsRspOuterClass.internal_static_BatchBuyGoodsRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(BatchBuyGoodsRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BatchBuyGoodsRsp.alwaysUseFieldBuilders) {
                    getGoodsListFieldBuilder();
                    getBuyGoodsListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.shopType_ = 0;
                if (this.goodsListBuilder_ == null) {
                    this.goodsList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.goodsListBuilder_.clear();
                }
                this.retcode_ = 0;
                if (this.buyGoodsListBuilder_ == null) {
                    this.buyGoodsList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.buyGoodsListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BatchBuyGoodsRspOuterClass.internal_static_BatchBuyGoodsRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BatchBuyGoodsRsp getDefaultInstanceForType() {
                return BatchBuyGoodsRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BatchBuyGoodsRsp build() {
                BatchBuyGoodsRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BatchBuyGoodsRsp buildPartial() {
                BatchBuyGoodsRsp result = new BatchBuyGoodsRsp(this);
                int i = this.bitField0_;
                result.shopType_ = this.shopType_;
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
                if (this.buyGoodsListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.buyGoodsList_ = Collections.unmodifiableList(this.buyGoodsList_);
                        this.bitField0_ &= -3;
                    }
                    result.buyGoodsList_ = this.buyGoodsList_;
                } else {
                    result.buyGoodsList_ = this.buyGoodsListBuilder_.build();
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
                if (other instanceof BatchBuyGoodsRsp) {
                    return mergeFrom((BatchBuyGoodsRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BatchBuyGoodsRsp other) {
                if (other == BatchBuyGoodsRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getShopType() != 0) {
                    setShopType(other.getShopType());
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
                        this.goodsListBuilder_ = BatchBuyGoodsRsp.alwaysUseFieldBuilders ? getGoodsListFieldBuilder() : null;
                    } else {
                        this.goodsListBuilder_.addAllMessages(other.goodsList_);
                    }
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.buyGoodsListBuilder_ == null) {
                    if (!other.buyGoodsList_.isEmpty()) {
                        if (this.buyGoodsList_.isEmpty()) {
                            this.buyGoodsList_ = other.buyGoodsList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureBuyGoodsListIsMutable();
                            this.buyGoodsList_.addAll(other.buyGoodsList_);
                        }
                        onChanged();
                    }
                } else if (!other.buyGoodsList_.isEmpty()) {
                    if (this.buyGoodsListBuilder_.isEmpty()) {
                        this.buyGoodsListBuilder_.dispose();
                        this.buyGoodsListBuilder_ = null;
                        this.buyGoodsList_ = other.buyGoodsList_;
                        this.bitField0_ &= -3;
                        this.buyGoodsListBuilder_ = BatchBuyGoodsRsp.alwaysUseFieldBuilders ? getBuyGoodsListFieldBuilder() : null;
                    } else {
                        this.buyGoodsListBuilder_.addAllMessages(other.buyGoodsList_);
                    }
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
                BatchBuyGoodsRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = BatchBuyGoodsRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BatchBuyGoodsRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
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

            private void ensureGoodsListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.goodsList_ = new ArrayList(this.goodsList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
            public List<ShopGoodsOuterClass.ShopGoods> getGoodsListList() {
                if (this.goodsListBuilder_ == null) {
                    return Collections.unmodifiableList(this.goodsList_);
                }
                return this.goodsListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
            public int getGoodsListCount() {
                if (this.goodsListBuilder_ == null) {
                    return this.goodsList_.size();
                }
                return this.goodsListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
            public ShopGoodsOuterClass.ShopGoodsOrBuilder getGoodsListOrBuilder(int index) {
                if (this.goodsListBuilder_ == null) {
                    return this.goodsList_.get(index);
                }
                return this.goodsListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
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

            private void ensureBuyGoodsListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.buyGoodsList_ = new ArrayList(this.buyGoodsList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
            public List<BuyGoodsParamOuterClass.BuyGoodsParam> getBuyGoodsListList() {
                if (this.buyGoodsListBuilder_ == null) {
                    return Collections.unmodifiableList(this.buyGoodsList_);
                }
                return this.buyGoodsListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
            public int getBuyGoodsListCount() {
                if (this.buyGoodsListBuilder_ == null) {
                    return this.buyGoodsList_.size();
                }
                return this.buyGoodsListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
            public BuyGoodsParamOuterClass.BuyGoodsParam getBuyGoodsList(int index) {
                if (this.buyGoodsListBuilder_ == null) {
                    return this.buyGoodsList_.get(index);
                }
                return this.buyGoodsListBuilder_.getMessage(index);
            }

            public Builder setBuyGoodsList(int index, BuyGoodsParamOuterClass.BuyGoodsParam value) {
                if (this.buyGoodsListBuilder_ != null) {
                    this.buyGoodsListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBuyGoodsListIsMutable();
                    this.buyGoodsList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setBuyGoodsList(int index, BuyGoodsParamOuterClass.BuyGoodsParam.Builder builderForValue) {
                if (this.buyGoodsListBuilder_ == null) {
                    ensureBuyGoodsListIsMutable();
                    this.buyGoodsList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.buyGoodsListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBuyGoodsList(BuyGoodsParamOuterClass.BuyGoodsParam value) {
                if (this.buyGoodsListBuilder_ != null) {
                    this.buyGoodsListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBuyGoodsListIsMutable();
                    this.buyGoodsList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addBuyGoodsList(int index, BuyGoodsParamOuterClass.BuyGoodsParam value) {
                if (this.buyGoodsListBuilder_ != null) {
                    this.buyGoodsListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBuyGoodsListIsMutable();
                    this.buyGoodsList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addBuyGoodsList(BuyGoodsParamOuterClass.BuyGoodsParam.Builder builderForValue) {
                if (this.buyGoodsListBuilder_ == null) {
                    ensureBuyGoodsListIsMutable();
                    this.buyGoodsList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.buyGoodsListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBuyGoodsList(int index, BuyGoodsParamOuterClass.BuyGoodsParam.Builder builderForValue) {
                if (this.buyGoodsListBuilder_ == null) {
                    ensureBuyGoodsListIsMutable();
                    this.buyGoodsList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.buyGoodsListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBuyGoodsList(Iterable<? extends BuyGoodsParamOuterClass.BuyGoodsParam> values) {
                if (this.buyGoodsListBuilder_ == null) {
                    ensureBuyGoodsListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.buyGoodsList_);
                    onChanged();
                } else {
                    this.buyGoodsListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBuyGoodsList() {
                if (this.buyGoodsListBuilder_ == null) {
                    this.buyGoodsList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.buyGoodsListBuilder_.clear();
                }
                return this;
            }

            public Builder removeBuyGoodsList(int index) {
                if (this.buyGoodsListBuilder_ == null) {
                    ensureBuyGoodsListIsMutable();
                    this.buyGoodsList_.remove(index);
                    onChanged();
                } else {
                    this.buyGoodsListBuilder_.remove(index);
                }
                return this;
            }

            public BuyGoodsParamOuterClass.BuyGoodsParam.Builder getBuyGoodsListBuilder(int index) {
                return getBuyGoodsListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
            public BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder getBuyGoodsListOrBuilder(int index) {
                if (this.buyGoodsListBuilder_ == null) {
                    return this.buyGoodsList_.get(index);
                }
                return this.buyGoodsListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsRspOuterClass.BatchBuyGoodsRspOrBuilder
            public List<? extends BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder> getBuyGoodsListOrBuilderList() {
                if (this.buyGoodsListBuilder_ != null) {
                    return this.buyGoodsListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.buyGoodsList_);
            }

            public BuyGoodsParamOuterClass.BuyGoodsParam.Builder addBuyGoodsListBuilder() {
                return getBuyGoodsListFieldBuilder().addBuilder(BuyGoodsParamOuterClass.BuyGoodsParam.getDefaultInstance());
            }

            public BuyGoodsParamOuterClass.BuyGoodsParam.Builder addBuyGoodsListBuilder(int index) {
                return getBuyGoodsListFieldBuilder().addBuilder(index, BuyGoodsParamOuterClass.BuyGoodsParam.getDefaultInstance());
            }

            public List<BuyGoodsParamOuterClass.BuyGoodsParam.Builder> getBuyGoodsListBuilderList() {
                return getBuyGoodsListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BuyGoodsParamOuterClass.BuyGoodsParam, BuyGoodsParamOuterClass.BuyGoodsParam.Builder, BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder> getBuyGoodsListFieldBuilder() {
                if (this.buyGoodsListBuilder_ == null) {
                    this.buyGoodsListBuilder_ = new RepeatedFieldBuilderV3<>(this.buyGoodsList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.buyGoodsList_ = null;
                }
                return this.buyGoodsListBuilder_;
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

        public static BatchBuyGoodsRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BatchBuyGoodsRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BatchBuyGoodsRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BatchBuyGoodsRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BuyGoodsParamOuterClass.getDescriptor();
        ShopGoodsOuterClass.getDescriptor();
    }
}
