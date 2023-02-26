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
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopGoodsOuterClass.class */
public final class HomeLimitedShopGoodsOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aHomeLimitedShopGoods.proto\u001a\u000fItemParam.proto\"¢\u0001\n\u0014HomeLimitedShopGoods\u0012\u0013\n\u000bdisableType\u0018\u0005 \u0001(\r\u0012\u001d\n\tgoodsItem\u0018\f \u0001(\u000b2\n.ItemParam\u0012\u000f\n\u0007goodsId\u0018\u0006 \u0001(\r\u0012 \n\fcostItemList\u0018\u000f \u0003(\u000b2\n.ItemParam\u0012\u0011\n\tboughtNum\u0018\u0007 \u0001(\r\u0012\u0010\n\bbuyLimit\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeLimitedShopGoods_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeLimitedShopGoods_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeLimitedShopGoods_descriptor, new String[]{"DisableType", "GoodsItem", "GoodsId", "CostItemList", "BoughtNum", "BuyLimit"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopGoodsOuterClass$HomeLimitedShopGoodsOrBuilder.class */
    public interface HomeLimitedShopGoodsOrBuilder extends MessageOrBuilder {
        int getDisableType();

        boolean hasGoodsItem();

        ItemParamOuterClass.ItemParam getGoodsItem();

        ItemParamOuterClass.ItemParamOrBuilder getGoodsItemOrBuilder();

        int getGoodsId();

        List<ItemParamOuterClass.ItemParam> getCostItemListList();

        ItemParamOuterClass.ItemParam getCostItemList(int i);

        int getCostItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getCostItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getCostItemListOrBuilder(int i);

        int getBoughtNum();

        int getBuyLimit();
    }

    private HomeLimitedShopGoodsOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopGoodsOuterClass$HomeLimitedShopGoods.class */
    public static final class HomeLimitedShopGoods extends GeneratedMessageV3 implements HomeLimitedShopGoodsOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DISABLETYPE_FIELD_NUMBER = 5;
        private int disableType_;
        public static final int GOODSITEM_FIELD_NUMBER = 12;
        private ItemParamOuterClass.ItemParam goodsItem_;
        public static final int GOODSID_FIELD_NUMBER = 6;
        private int goodsId_;
        public static final int COSTITEMLIST_FIELD_NUMBER = 15;
        private List<ItemParamOuterClass.ItemParam> costItemList_;
        public static final int BOUGHTNUM_FIELD_NUMBER = 7;
        private int boughtNum_;
        public static final int BUYLIMIT_FIELD_NUMBER = 13;
        private int buyLimit_;
        private byte memoizedIsInitialized;
        private static final HomeLimitedShopGoods DEFAULT_INSTANCE = new HomeLimitedShopGoods();
        private static final Parser<HomeLimitedShopGoods> PARSER = new AbstractParser<HomeLimitedShopGoods>() { // from class: emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.1
            @Override // com.google.protobuf.Parser
            public HomeLimitedShopGoods parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeLimitedShopGoods(input, extensionRegistry);
            }
        };

        private HomeLimitedShopGoods(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeLimitedShopGoods() {
            this.memoizedIsInitialized = -1;
            this.costItemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeLimitedShopGoods();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeLimitedShopGoods(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 40:
                                    this.disableType_ = input.readUInt32();
                                    break;
                                case 48:
                                    this.goodsId_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.boughtNum_ = input.readUInt32();
                                    break;
                                case 98:
                                    ItemParamOuterClass.ItemParam.Builder subBuilder = this.goodsItem_ != null ? this.goodsItem_.toBuilder() : null;
                                    this.goodsItem_ = (ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.goodsItem_);
                                        this.goodsItem_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 104:
                                    this.buyLimit_ = input.readUInt32();
                                    break;
                                case 122:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.costItemList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.costItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.costItemList_ = Collections.unmodifiableList(this.costItemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeLimitedShopGoodsOuterClass.internal_static_HomeLimitedShopGoods_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeLimitedShopGoodsOuterClass.internal_static_HomeLimitedShopGoods_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeLimitedShopGoods.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
        public int getDisableType() {
            return this.disableType_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
        public boolean hasGoodsItem() {
            return this.goodsItem_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
        public ItemParamOuterClass.ItemParam getGoodsItem() {
            return this.goodsItem_ == null ? ItemParamOuterClass.ItemParam.getDefaultInstance() : this.goodsItem_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getGoodsItemOrBuilder() {
            return getGoodsItem();
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
        public int getGoodsId() {
            return this.goodsId_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
        public List<ItemParamOuterClass.ItemParam> getCostItemListList() {
            return this.costItemList_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getCostItemListOrBuilderList() {
            return this.costItemList_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
        public int getCostItemListCount() {
            return this.costItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
        public ItemParamOuterClass.ItemParam getCostItemList(int index) {
            return this.costItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getCostItemListOrBuilder(int index) {
            return this.costItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
        public int getBoughtNum() {
            return this.boughtNum_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
        public int getBuyLimit() {
            return this.buyLimit_;
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
            if (this.disableType_ != 0) {
                output.writeUInt32(5, this.disableType_);
            }
            if (this.goodsId_ != 0) {
                output.writeUInt32(6, this.goodsId_);
            }
            if (this.boughtNum_ != 0) {
                output.writeUInt32(7, this.boughtNum_);
            }
            if (this.goodsItem_ != null) {
                output.writeMessage(12, getGoodsItem());
            }
            if (this.buyLimit_ != 0) {
                output.writeUInt32(13, this.buyLimit_);
            }
            for (int i = 0; i < this.costItemList_.size(); i++) {
                output.writeMessage(15, this.costItemList_.get(i));
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
            if (this.disableType_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.disableType_);
            }
            if (this.goodsId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.goodsId_);
            }
            if (this.boughtNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.boughtNum_);
            }
            if (this.goodsItem_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getGoodsItem());
            }
            if (this.buyLimit_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.buyLimit_);
            }
            for (int i = 0; i < this.costItemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(15, this.costItemList_.get(i));
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
            if (!(obj instanceof HomeLimitedShopGoods)) {
                return equals(obj);
            }
            HomeLimitedShopGoods other = (HomeLimitedShopGoods) obj;
            if (getDisableType() == other.getDisableType() && hasGoodsItem() == other.hasGoodsItem()) {
                return (!hasGoodsItem() || getGoodsItem().equals(other.getGoodsItem())) && getGoodsId() == other.getGoodsId() && getCostItemListList().equals(other.getCostItemListList()) && getBoughtNum() == other.getBoughtNum() && getBuyLimit() == other.getBuyLimit() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getDisableType();
            if (hasGoodsItem()) {
                hash = (53 * ((37 * hash) + 12)) + getGoodsItem().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 6)) + getGoodsId();
            if (getCostItemListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 15)) + getCostItemListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * hash2) + 7)) + getBoughtNum())) + 13)) + getBuyLimit())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static HomeLimitedShopGoods parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopGoods parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopGoods parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopGoods parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopGoods parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopGoods parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopGoods parseFrom(InputStream input) throws IOException {
            return (HomeLimitedShopGoods) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeLimitedShopGoods parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopGoods) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeLimitedShopGoods parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeLimitedShopGoods) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeLimitedShopGoods parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopGoods) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeLimitedShopGoods parseFrom(CodedInputStream input) throws IOException {
            return (HomeLimitedShopGoods) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeLimitedShopGoods parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopGoods) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeLimitedShopGoods prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopGoodsOuterClass$HomeLimitedShopGoods$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeLimitedShopGoodsOrBuilder {
            private int bitField0_;
            private int disableType_;
            private ItemParamOuterClass.ItemParam goodsItem_;
            private SingleFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> goodsItemBuilder_;
            private int goodsId_;
            private List<ItemParamOuterClass.ItemParam> costItemList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> costItemListBuilder_;
            private int boughtNum_;
            private int buyLimit_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeLimitedShopGoodsOuterClass.internal_static_HomeLimitedShopGoods_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeLimitedShopGoodsOuterClass.internal_static_HomeLimitedShopGoods_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeLimitedShopGoods.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeLimitedShopGoods.alwaysUseFieldBuilders) {
                    getCostItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.disableType_ = 0;
                if (this.goodsItemBuilder_ == null) {
                    this.goodsItem_ = null;
                } else {
                    this.goodsItem_ = null;
                    this.goodsItemBuilder_ = null;
                }
                this.goodsId_ = 0;
                if (this.costItemListBuilder_ == null) {
                    this.costItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.costItemListBuilder_.clear();
                }
                this.boughtNum_ = 0;
                this.buyLimit_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeLimitedShopGoodsOuterClass.internal_static_HomeLimitedShopGoods_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeLimitedShopGoods getDefaultInstanceForType() {
                return HomeLimitedShopGoods.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeLimitedShopGoods build() {
                HomeLimitedShopGoods result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeLimitedShopGoods buildPartial() {
                HomeLimitedShopGoods result = new HomeLimitedShopGoods(this);
                int i = this.bitField0_;
                result.disableType_ = this.disableType_;
                if (this.goodsItemBuilder_ == null) {
                    result.goodsItem_ = this.goodsItem_;
                } else {
                    result.goodsItem_ = this.goodsItemBuilder_.build();
                }
                result.goodsId_ = this.goodsId_;
                if (this.costItemListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.costItemList_ = Collections.unmodifiableList(this.costItemList_);
                        this.bitField0_ &= -2;
                    }
                    result.costItemList_ = this.costItemList_;
                } else {
                    result.costItemList_ = this.costItemListBuilder_.build();
                }
                result.boughtNum_ = this.boughtNum_;
                result.buyLimit_ = this.buyLimit_;
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
                if (other instanceof HomeLimitedShopGoods) {
                    return mergeFrom((HomeLimitedShopGoods) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeLimitedShopGoods other) {
                if (other == HomeLimitedShopGoods.getDefaultInstance()) {
                    return this;
                }
                if (other.getDisableType() != 0) {
                    setDisableType(other.getDisableType());
                }
                if (other.hasGoodsItem()) {
                    mergeGoodsItem(other.getGoodsItem());
                }
                if (other.getGoodsId() != 0) {
                    setGoodsId(other.getGoodsId());
                }
                if (this.costItemListBuilder_ == null) {
                    if (!other.costItemList_.isEmpty()) {
                        if (this.costItemList_.isEmpty()) {
                            this.costItemList_ = other.costItemList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureCostItemListIsMutable();
                            this.costItemList_.addAll(other.costItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.costItemList_.isEmpty()) {
                    if (this.costItemListBuilder_.isEmpty()) {
                        this.costItemListBuilder_.dispose();
                        this.costItemListBuilder_ = null;
                        this.costItemList_ = other.costItemList_;
                        this.bitField0_ &= -2;
                        this.costItemListBuilder_ = HomeLimitedShopGoods.alwaysUseFieldBuilders ? getCostItemListFieldBuilder() : null;
                    } else {
                        this.costItemListBuilder_.addAllMessages(other.costItemList_);
                    }
                }
                if (other.getBoughtNum() != 0) {
                    setBoughtNum(other.getBoughtNum());
                }
                if (other.getBuyLimit() != 0) {
                    setBuyLimit(other.getBuyLimit());
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
                HomeLimitedShopGoods parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeLimitedShopGoods.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeLimitedShopGoods) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
            public int getDisableType() {
                return this.disableType_;
            }

            public Builder setDisableType(int value) {
                this.disableType_ = value;
                onChanged();
                return this;
            }

            public Builder clearDisableType() {
                this.disableType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
            public boolean hasGoodsItem() {
                return (this.goodsItemBuilder_ == null && this.goodsItem_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
            public ItemParamOuterClass.ItemParam getGoodsItem() {
                if (this.goodsItemBuilder_ == null) {
                    return this.goodsItem_ == null ? ItemParamOuterClass.ItemParam.getDefaultInstance() : this.goodsItem_;
                }
                return this.goodsItemBuilder_.getMessage();
            }

            public Builder setGoodsItem(ItemParamOuterClass.ItemParam value) {
                if (this.goodsItemBuilder_ != null) {
                    this.goodsItemBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.goodsItem_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setGoodsItem(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.goodsItemBuilder_ == null) {
                    this.goodsItem_ = builderForValue.build();
                    onChanged();
                } else {
                    this.goodsItemBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeGoodsItem(ItemParamOuterClass.ItemParam value) {
                if (this.goodsItemBuilder_ == null) {
                    if (this.goodsItem_ != null) {
                        this.goodsItem_ = ItemParamOuterClass.ItemParam.newBuilder(this.goodsItem_).mergeFrom(value).buildPartial();
                    } else {
                        this.goodsItem_ = value;
                    }
                    onChanged();
                } else {
                    this.goodsItemBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearGoodsItem() {
                if (this.goodsItemBuilder_ == null) {
                    this.goodsItem_ = null;
                    onChanged();
                } else {
                    this.goodsItem_ = null;
                    this.goodsItemBuilder_ = null;
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getGoodsItemBuilder() {
                onChanged();
                return getGoodsItemFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getGoodsItemOrBuilder() {
                if (this.goodsItemBuilder_ != null) {
                    return this.goodsItemBuilder_.getMessageOrBuilder();
                }
                return this.goodsItem_ == null ? ItemParamOuterClass.ItemParam.getDefaultInstance() : this.goodsItem_;
            }

            private SingleFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getGoodsItemFieldBuilder() {
                if (this.goodsItemBuilder_ == null) {
                    this.goodsItemBuilder_ = new SingleFieldBuilderV3<>(getGoodsItem(), getParentForChildren(), isClean());
                    this.goodsItem_ = null;
                }
                return this.goodsItemBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
            public int getGoodsId() {
                return this.goodsId_;
            }

            public Builder setGoodsId(int value) {
                this.goodsId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGoodsId() {
                this.goodsId_ = 0;
                onChanged();
                return this;
            }

            private void ensureCostItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.costItemList_ = new ArrayList(this.costItemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
            public List<ItemParamOuterClass.ItemParam> getCostItemListList() {
                if (this.costItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.costItemList_);
                }
                return this.costItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
            public int getCostItemListCount() {
                if (this.costItemListBuilder_ == null) {
                    return this.costItemList_.size();
                }
                return this.costItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
            public ItemParamOuterClass.ItemParam getCostItemList(int index) {
                if (this.costItemListBuilder_ == null) {
                    return this.costItemList_.get(index);
                }
                return this.costItemListBuilder_.getMessage(index);
            }

            public Builder setCostItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.costItemListBuilder_ != null) {
                    this.costItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCostItemListIsMutable();
                    this.costItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setCostItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.costItemListBuilder_ == null) {
                    ensureCostItemListIsMutable();
                    this.costItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.costItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCostItemList(ItemParamOuterClass.ItemParam value) {
                if (this.costItemListBuilder_ != null) {
                    this.costItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCostItemListIsMutable();
                    this.costItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addCostItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.costItemListBuilder_ != null) {
                    this.costItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCostItemListIsMutable();
                    this.costItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addCostItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.costItemListBuilder_ == null) {
                    ensureCostItemListIsMutable();
                    this.costItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.costItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCostItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.costItemListBuilder_ == null) {
                    ensureCostItemListIsMutable();
                    this.costItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.costItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCostItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.costItemListBuilder_ == null) {
                    ensureCostItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.costItemList_);
                    onChanged();
                } else {
                    this.costItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCostItemList() {
                if (this.costItemListBuilder_ == null) {
                    this.costItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.costItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeCostItemList(int index) {
                if (this.costItemListBuilder_ == null) {
                    ensureCostItemListIsMutable();
                    this.costItemList_.remove(index);
                    onChanged();
                } else {
                    this.costItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getCostItemListBuilder(int index) {
                return getCostItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getCostItemListOrBuilder(int index) {
                if (this.costItemListBuilder_ == null) {
                    return this.costItemList_.get(index);
                }
                return this.costItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getCostItemListOrBuilderList() {
                if (this.costItemListBuilder_ != null) {
                    return this.costItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.costItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addCostItemListBuilder() {
                return getCostItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addCostItemListBuilder(int index) {
                return getCostItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getCostItemListBuilderList() {
                return getCostItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getCostItemListFieldBuilder() {
                if (this.costItemListBuilder_ == null) {
                    this.costItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.costItemList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.costItemList_ = null;
                }
                return this.costItemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
            public int getBoughtNum() {
                return this.boughtNum_;
            }

            public Builder setBoughtNum(int value) {
                this.boughtNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearBoughtNum() {
                this.boughtNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder
            public int getBuyLimit() {
                return this.buyLimit_;
            }

            public Builder setBuyLimit(int value) {
                this.buyLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearBuyLimit() {
                this.buyLimit_ = 0;
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

        public static HomeLimitedShopGoods getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeLimitedShopGoods> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeLimitedShopGoods> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeLimitedShopGoods getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ItemParamOuterClass.getDescriptor();
    }
}
