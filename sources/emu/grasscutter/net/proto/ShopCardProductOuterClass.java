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
import com.google.protobuf.Internal;
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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopCardProductOuterClass.class */
public final class ShopCardProductOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015ShopCardProduct.proto\u001a\u000fItemParam.proto\"Æ\u0002\n\u000fShopCardProduct\u0012\u0012\n\nproduct_id\u0018\u0001 \u0001(\t\u0012\u0012\n\nprice_tier\u0018\u0002 \u0001(\t\u0012\u0012\n\nmcoin_base\u0018\u0003 \u0001(\r\u0012\u0015\n\rhcoin_per_day\u0018\u0004 \u0001(\r\u0012\f\n\u0004days\u0018\u0005 \u0001(\r\u0012\u001a\n\u0012remain_reward_days\u0018\u0006 \u0001(\r\u0012\u0019\n\u0011card_product_type\u0018\u0007 \u0001(\r\u00120\n\nresin_card\u0018e \u0001(\u000b2\u001a.ShopCardProduct.ResinCardH��\u001aV\n\tResinCard\u0012\"\n\u000ebase_item_list\u0018\u0001 \u0003(\u000b2\n.ItemParam\u0012%\n\u0011per_day_item_list\u0018\u0002 \u0003(\u000b2\n.ItemParamB\u0011\n\u000fextra_card_dataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ShopCardProduct_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ShopCardProduct_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ShopCardProduct_descriptor, new String[]{"ProductId", "PriceTier", "McoinBase", "HcoinPerDay", "Days", "RemainRewardDays", "CardProductType", "ResinCard", "ExtraCardData"});
    private static final Descriptors.Descriptor internal_static_ShopCardProduct_ResinCard_descriptor = internal_static_ShopCardProduct_descriptor.getNestedTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ShopCardProduct_ResinCard_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ShopCardProduct_ResinCard_descriptor, new String[]{"BaseItemList", "PerDayItemList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopCardProductOuterClass$ShopCardProductOrBuilder.class */
    public interface ShopCardProductOrBuilder extends MessageOrBuilder {
        String getProductId();

        ByteString getProductIdBytes();

        String getPriceTier();

        ByteString getPriceTierBytes();

        int getMcoinBase();

        int getHcoinPerDay();

        int getDays();

        int getRemainRewardDays();

        int getCardProductType();

        boolean hasResinCard();

        ShopCardProduct.ResinCard getResinCard();

        ShopCardProduct.ResinCardOrBuilder getResinCardOrBuilder();

        ShopCardProduct.ExtraCardDataCase getExtraCardDataCase();
    }

    private ShopCardProductOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopCardProductOuterClass$ShopCardProduct.class */
    public static final class ShopCardProduct extends GeneratedMessageV3 implements ShopCardProductOrBuilder {
        private static final long serialVersionUID = 0;
        private int extraCardDataCase_;
        private Object extraCardData_;
        public static final int PRODUCT_ID_FIELD_NUMBER = 1;
        private volatile Object productId_;
        public static final int PRICE_TIER_FIELD_NUMBER = 2;
        private volatile Object priceTier_;
        public static final int MCOIN_BASE_FIELD_NUMBER = 3;
        private int mcoinBase_;
        public static final int HCOIN_PER_DAY_FIELD_NUMBER = 4;
        private int hcoinPerDay_;
        public static final int DAYS_FIELD_NUMBER = 5;
        private int days_;
        public static final int REMAIN_REWARD_DAYS_FIELD_NUMBER = 6;
        private int remainRewardDays_;
        public static final int CARD_PRODUCT_TYPE_FIELD_NUMBER = 7;
        private int cardProductType_;
        public static final int RESIN_CARD_FIELD_NUMBER = 101;
        private byte memoizedIsInitialized;
        private static final ShopCardProduct DEFAULT_INSTANCE = new ShopCardProduct();
        private static final Parser<ShopCardProduct> PARSER = new AbstractParser<ShopCardProduct>() { // from class: emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.1
            @Override // com.google.protobuf.Parser
            public ShopCardProduct parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopCardProduct(input, extensionRegistry);
            }
        };

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopCardProductOuterClass$ShopCardProduct$ResinCardOrBuilder.class */
        public interface ResinCardOrBuilder extends MessageOrBuilder {
            List<ItemParamOuterClass.ItemParam> getBaseItemListList();

            ItemParamOuterClass.ItemParam getBaseItemList(int i);

            int getBaseItemListCount();

            List<? extends ItemParamOuterClass.ItemParamOrBuilder> getBaseItemListOrBuilderList();

            ItemParamOuterClass.ItemParamOrBuilder getBaseItemListOrBuilder(int i);

            List<ItemParamOuterClass.ItemParam> getPerDayItemListList();

            ItemParamOuterClass.ItemParam getPerDayItemList(int i);

            int getPerDayItemListCount();

            List<? extends ItemParamOuterClass.ItemParamOrBuilder> getPerDayItemListOrBuilderList();

            ItemParamOuterClass.ItemParamOrBuilder getPerDayItemListOrBuilder(int i);
        }

        private ShopCardProduct(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.extraCardDataCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private ShopCardProduct() {
            this.extraCardDataCase_ = 0;
            this.memoizedIsInitialized = -1;
            this.productId_ = "";
            this.priceTier_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ShopCardProduct();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ShopCardProduct(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                this.productId_ = input.readStringRequireUtf8();
                                break;
                            case 18:
                                this.priceTier_ = input.readStringRequireUtf8();
                                break;
                            case 24:
                                this.mcoinBase_ = input.readUInt32();
                                break;
                            case 32:
                                this.hcoinPerDay_ = input.readUInt32();
                                break;
                            case 40:
                                this.days_ = input.readUInt32();
                                break;
                            case 48:
                                this.remainRewardDays_ = input.readUInt32();
                                break;
                            case 56:
                                this.cardProductType_ = input.readUInt32();
                                break;
                            case 810:
                                ResinCard.Builder subBuilder = this.extraCardDataCase_ == 101 ? ((ResinCard) this.extraCardData_).toBuilder() : null;
                                this.extraCardData_ = input.readMessage(ResinCard.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((ResinCard) this.extraCardData_);
                                    this.extraCardData_ = subBuilder.buildPartial();
                                }
                                this.extraCardDataCase_ = 101;
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ShopCardProductOuterClass.internal_static_ShopCardProduct_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopCardProductOuterClass.internal_static_ShopCardProduct_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopCardProduct.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopCardProductOuterClass$ShopCardProduct$ResinCard.class */
        public static final class ResinCard extends GeneratedMessageV3 implements ResinCardOrBuilder {
            private static final long serialVersionUID = 0;
            public static final int BASE_ITEM_LIST_FIELD_NUMBER = 1;
            private List<ItemParamOuterClass.ItemParam> baseItemList_;
            public static final int PER_DAY_ITEM_LIST_FIELD_NUMBER = 2;
            private List<ItemParamOuterClass.ItemParam> perDayItemList_;
            private byte memoizedIsInitialized;
            private static final ResinCard DEFAULT_INSTANCE = new ResinCard();
            private static final Parser<ResinCard> PARSER = new AbstractParser<ResinCard>() { // from class: emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCard.1
                @Override // com.google.protobuf.Parser
                public ResinCard parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new ResinCard(input, extensionRegistry);
                }
            };

            private ResinCard(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
            }

            private ResinCard() {
                this.memoizedIsInitialized = -1;
                this.baseItemList_ = Collections.emptyList();
                this.perDayItemList_ = Collections.emptyList();
            }

            /* access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
                return new ResinCard();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x00b8 */
            private ResinCard(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.baseItemList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.baseItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                    break;
                                case 18:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.perDayItemList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.perDayItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
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
                    if ((mutable_bitField0_ & 1) != 0) {
                        this.baseItemList_ = Collections.unmodifiableList(this.baseItemList_);
                    }
                    if ((mutable_bitField0_ & 2) != 0) {
                        this.perDayItemList_ = Collections.unmodifiableList(this.perDayItemList_);
                    }
                    this.unknownFields = unknownFields.build();
                    makeExtensionsImmutable();
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ShopCardProductOuterClass.internal_static_ShopCardProduct_ResinCard_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopCardProductOuterClass.internal_static_ShopCardProduct_ResinCard_fieldAccessorTable.ensureFieldAccessorsInitialized(ResinCard.class, Builder.class);
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
            public List<ItemParamOuterClass.ItemParam> getBaseItemListList() {
                return this.baseItemList_;
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getBaseItemListOrBuilderList() {
                return this.baseItemList_;
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
            public int getBaseItemListCount() {
                return this.baseItemList_.size();
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
            public ItemParamOuterClass.ItemParam getBaseItemList(int index) {
                return this.baseItemList_.get(index);
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getBaseItemListOrBuilder(int index) {
                return this.baseItemList_.get(index);
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
            public List<ItemParamOuterClass.ItemParam> getPerDayItemListList() {
                return this.perDayItemList_;
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getPerDayItemListOrBuilderList() {
                return this.perDayItemList_;
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
            public int getPerDayItemListCount() {
                return this.perDayItemList_.size();
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
            public ItemParamOuterClass.ItemParam getPerDayItemList(int index) {
                return this.perDayItemList_.get(index);
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getPerDayItemListOrBuilder(int index) {
                return this.perDayItemList_.get(index);
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
                for (int i = 0; i < this.baseItemList_.size(); i++) {
                    output.writeMessage(1, this.baseItemList_.get(i));
                }
                for (int i2 = 0; i2 < this.perDayItemList_.size(); i2++) {
                    output.writeMessage(2, this.perDayItemList_.get(i2));
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
                for (int i = 0; i < this.baseItemList_.size(); i++) {
                    size2 += CodedOutputStream.computeMessageSize(1, this.baseItemList_.get(i));
                }
                for (int i2 = 0; i2 < this.perDayItemList_.size(); i2++) {
                    size2 += CodedOutputStream.computeMessageSize(2, this.perDayItemList_.get(i2));
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
                if (!(obj instanceof ResinCard)) {
                    return equals(obj);
                }
                ResinCard other = (ResinCard) obj;
                return getBaseItemListList().equals(other.getBaseItemListList()) && getPerDayItemListList().equals(other.getPerDayItemListList()) && this.unknownFields.equals(other.unknownFields);
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hash = (19 * 41) + getDescriptor().hashCode();
                if (getBaseItemListCount() > 0) {
                    hash = (53 * ((37 * hash) + 1)) + getBaseItemListList().hashCode();
                }
                if (getPerDayItemListCount() > 0) {
                    hash = (53 * ((37 * hash) + 2)) + getPerDayItemListList().hashCode();
                }
                int hash2 = (29 * hash) + this.unknownFields.hashCode();
                this.memoizedHashCode = hash2;
                return hash2;
            }

            public static ResinCard parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static ResinCard parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static ResinCard parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static ResinCard parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static ResinCard parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static ResinCard parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static ResinCard parseFrom(InputStream input) throws IOException {
                return (ResinCard) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static ResinCard parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (ResinCard) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            public static ResinCard parseDelimitedFrom(InputStream input) throws IOException {
                return (ResinCard) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
            }

            public static ResinCard parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (ResinCard) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }

            public static ResinCard parseFrom(CodedInputStream input) throws IOException {
                return (ResinCard) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static ResinCard parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (ResinCard) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(ResinCard prototype) {
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

            /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopCardProductOuterClass$ShopCardProduct$ResinCard$Builder.class */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResinCardOrBuilder {
                private int bitField0_;
                private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> baseItemListBuilder_;
                private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> perDayItemListBuilder_;
                private List<ItemParamOuterClass.ItemParam> baseItemList_ = Collections.emptyList();
                private List<ItemParamOuterClass.ItemParam> perDayItemList_ = Collections.emptyList();

                public static final Descriptors.Descriptor getDescriptor() {
                    return ShopCardProductOuterClass.internal_static_ShopCardProduct_ResinCard_descriptor;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return ShopCardProductOuterClass.internal_static_ShopCardProduct_ResinCard_fieldAccessorTable.ensureFieldAccessorsInitialized(ResinCard.class, Builder.class);
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (ResinCard.alwaysUseFieldBuilders) {
                        getBaseItemListFieldBuilder();
                        getPerDayItemListFieldBuilder();
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    clear();
                    if (this.baseItemListBuilder_ == null) {
                        this.baseItemList_ = Collections.emptyList();
                        this.bitField0_ &= -2;
                    } else {
                        this.baseItemListBuilder_.clear();
                    }
                    if (this.perDayItemListBuilder_ == null) {
                        this.perDayItemList_ = Collections.emptyList();
                        this.bitField0_ &= -3;
                    } else {
                        this.perDayItemListBuilder_.clear();
                    }
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return ShopCardProductOuterClass.internal_static_ShopCardProduct_ResinCard_descriptor;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public ResinCard getDefaultInstanceForType() {
                    return ResinCard.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public ResinCard build() {
                    ResinCard result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw newUninitializedMessageException((Message) result);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public ResinCard buildPartial() {
                    ResinCard result = new ResinCard(this);
                    int i = this.bitField0_;
                    if (this.baseItemListBuilder_ == null) {
                        if ((this.bitField0_ & 1) != 0) {
                            this.baseItemList_ = Collections.unmodifiableList(this.baseItemList_);
                            this.bitField0_ &= -2;
                        }
                        result.baseItemList_ = this.baseItemList_;
                    } else {
                        result.baseItemList_ = this.baseItemListBuilder_.build();
                    }
                    if (this.perDayItemListBuilder_ == null) {
                        if ((this.bitField0_ & 2) != 0) {
                            this.perDayItemList_ = Collections.unmodifiableList(this.perDayItemList_);
                            this.bitField0_ &= -3;
                        }
                        result.perDayItemList_ = this.perDayItemList_;
                    } else {
                        result.perDayItemList_ = this.perDayItemListBuilder_.build();
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
                    if (other instanceof ResinCard) {
                        return mergeFrom((ResinCard) other);
                    }
                    mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(ResinCard other) {
                    if (other == ResinCard.getDefaultInstance()) {
                        return this;
                    }
                    if (this.baseItemListBuilder_ == null) {
                        if (!other.baseItemList_.isEmpty()) {
                            if (this.baseItemList_.isEmpty()) {
                                this.baseItemList_ = other.baseItemList_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureBaseItemListIsMutable();
                                this.baseItemList_.addAll(other.baseItemList_);
                            }
                            onChanged();
                        }
                    } else if (!other.baseItemList_.isEmpty()) {
                        if (this.baseItemListBuilder_.isEmpty()) {
                            this.baseItemListBuilder_.dispose();
                            this.baseItemListBuilder_ = null;
                            this.baseItemList_ = other.baseItemList_;
                            this.bitField0_ &= -2;
                            this.baseItemListBuilder_ = ResinCard.alwaysUseFieldBuilders ? getBaseItemListFieldBuilder() : null;
                        } else {
                            this.baseItemListBuilder_.addAllMessages(other.baseItemList_);
                        }
                    }
                    if (this.perDayItemListBuilder_ == null) {
                        if (!other.perDayItemList_.isEmpty()) {
                            if (this.perDayItemList_.isEmpty()) {
                                this.perDayItemList_ = other.perDayItemList_;
                                this.bitField0_ &= -3;
                            } else {
                                ensurePerDayItemListIsMutable();
                                this.perDayItemList_.addAll(other.perDayItemList_);
                            }
                            onChanged();
                        }
                    } else if (!other.perDayItemList_.isEmpty()) {
                        if (this.perDayItemListBuilder_.isEmpty()) {
                            this.perDayItemListBuilder_.dispose();
                            this.perDayItemListBuilder_ = null;
                            this.perDayItemList_ = other.perDayItemList_;
                            this.bitField0_ &= -3;
                            this.perDayItemListBuilder_ = ResinCard.alwaysUseFieldBuilders ? getPerDayItemListFieldBuilder() : null;
                        } else {
                            this.perDayItemListBuilder_.addAllMessages(other.perDayItemList_);
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
                    ResinCard parsedMessage = null;
                    try {
                        try {
                            parsedMessage = ResinCard.PARSER.parsePartialFrom(input, extensionRegistry);
                            if (parsedMessage != null) {
                                mergeFrom(parsedMessage);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            parsedMessage = (ResinCard) e.getUnfinishedMessage();
                            throw e.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        throw th;
                    }
                }

                private void ensureBaseItemListIsMutable() {
                    if ((this.bitField0_ & 1) == 0) {
                        this.baseItemList_ = new ArrayList(this.baseItemList_);
                        this.bitField0_ |= 1;
                    }
                }

                @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
                public List<ItemParamOuterClass.ItemParam> getBaseItemListList() {
                    if (this.baseItemListBuilder_ == null) {
                        return Collections.unmodifiableList(this.baseItemList_);
                    }
                    return this.baseItemListBuilder_.getMessageList();
                }

                @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
                public int getBaseItemListCount() {
                    if (this.baseItemListBuilder_ == null) {
                        return this.baseItemList_.size();
                    }
                    return this.baseItemListBuilder_.getCount();
                }

                @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
                public ItemParamOuterClass.ItemParam getBaseItemList(int index) {
                    if (this.baseItemListBuilder_ == null) {
                        return this.baseItemList_.get(index);
                    }
                    return this.baseItemListBuilder_.getMessage(index);
                }

                public Builder setBaseItemList(int index, ItemParamOuterClass.ItemParam value) {
                    if (this.baseItemListBuilder_ != null) {
                        this.baseItemListBuilder_.setMessage(index, value);
                    } else if (value == null) {
                        throw new NullPointerException();
                    } else {
                        ensureBaseItemListIsMutable();
                        this.baseItemList_.set(index, value);
                        onChanged();
                    }
                    return this;
                }

                public Builder setBaseItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                    if (this.baseItemListBuilder_ == null) {
                        ensureBaseItemListIsMutable();
                        this.baseItemList_.set(index, builderForValue.build());
                        onChanged();
                    } else {
                        this.baseItemListBuilder_.setMessage(index, builderForValue.build());
                    }
                    return this;
                }

                public Builder addBaseItemList(ItemParamOuterClass.ItemParam value) {
                    if (this.baseItemListBuilder_ != null) {
                        this.baseItemListBuilder_.addMessage(value);
                    } else if (value == null) {
                        throw new NullPointerException();
                    } else {
                        ensureBaseItemListIsMutable();
                        this.baseItemList_.add(value);
                        onChanged();
                    }
                    return this;
                }

                public Builder addBaseItemList(int index, ItemParamOuterClass.ItemParam value) {
                    if (this.baseItemListBuilder_ != null) {
                        this.baseItemListBuilder_.addMessage(index, value);
                    } else if (value == null) {
                        throw new NullPointerException();
                    } else {
                        ensureBaseItemListIsMutable();
                        this.baseItemList_.add(index, value);
                        onChanged();
                    }
                    return this;
                }

                public Builder addBaseItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                    if (this.baseItemListBuilder_ == null) {
                        ensureBaseItemListIsMutable();
                        this.baseItemList_.add(builderForValue.build());
                        onChanged();
                    } else {
                        this.baseItemListBuilder_.addMessage(builderForValue.build());
                    }
                    return this;
                }

                public Builder addBaseItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                    if (this.baseItemListBuilder_ == null) {
                        ensureBaseItemListIsMutable();
                        this.baseItemList_.add(index, builderForValue.build());
                        onChanged();
                    } else {
                        this.baseItemListBuilder_.addMessage(index, builderForValue.build());
                    }
                    return this;
                }

                public Builder addAllBaseItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                    if (this.baseItemListBuilder_ == null) {
                        ensureBaseItemListIsMutable();
                        AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.baseItemList_);
                        onChanged();
                    } else {
                        this.baseItemListBuilder_.addAllMessages(values);
                    }
                    return this;
                }

                public Builder clearBaseItemList() {
                    if (this.baseItemListBuilder_ == null) {
                        this.baseItemList_ = Collections.emptyList();
                        this.bitField0_ &= -2;
                        onChanged();
                    } else {
                        this.baseItemListBuilder_.clear();
                    }
                    return this;
                }

                public Builder removeBaseItemList(int index) {
                    if (this.baseItemListBuilder_ == null) {
                        ensureBaseItemListIsMutable();
                        this.baseItemList_.remove(index);
                        onChanged();
                    } else {
                        this.baseItemListBuilder_.remove(index);
                    }
                    return this;
                }

                public ItemParamOuterClass.ItemParam.Builder getBaseItemListBuilder(int index) {
                    return getBaseItemListFieldBuilder().getBuilder(index);
                }

                @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
                public ItemParamOuterClass.ItemParamOrBuilder getBaseItemListOrBuilder(int index) {
                    if (this.baseItemListBuilder_ == null) {
                        return this.baseItemList_.get(index);
                    }
                    return this.baseItemListBuilder_.getMessageOrBuilder(index);
                }

                @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
                public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getBaseItemListOrBuilderList() {
                    if (this.baseItemListBuilder_ != null) {
                        return this.baseItemListBuilder_.getMessageOrBuilderList();
                    }
                    return Collections.unmodifiableList(this.baseItemList_);
                }

                public ItemParamOuterClass.ItemParam.Builder addBaseItemListBuilder() {
                    return getBaseItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
                }

                public ItemParamOuterClass.ItemParam.Builder addBaseItemListBuilder(int index) {
                    return getBaseItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
                }

                public List<ItemParamOuterClass.ItemParam.Builder> getBaseItemListBuilderList() {
                    return getBaseItemListFieldBuilder().getBuilderList();
                }

                private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getBaseItemListFieldBuilder() {
                    if (this.baseItemListBuilder_ == null) {
                        this.baseItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.baseItemList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                        this.baseItemList_ = null;
                    }
                    return this.baseItemListBuilder_;
                }

                private void ensurePerDayItemListIsMutable() {
                    if ((this.bitField0_ & 2) == 0) {
                        this.perDayItemList_ = new ArrayList(this.perDayItemList_);
                        this.bitField0_ |= 2;
                    }
                }

                @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
                public List<ItemParamOuterClass.ItemParam> getPerDayItemListList() {
                    if (this.perDayItemListBuilder_ == null) {
                        return Collections.unmodifiableList(this.perDayItemList_);
                    }
                    return this.perDayItemListBuilder_.getMessageList();
                }

                @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
                public int getPerDayItemListCount() {
                    if (this.perDayItemListBuilder_ == null) {
                        return this.perDayItemList_.size();
                    }
                    return this.perDayItemListBuilder_.getCount();
                }

                @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
                public ItemParamOuterClass.ItemParam getPerDayItemList(int index) {
                    if (this.perDayItemListBuilder_ == null) {
                        return this.perDayItemList_.get(index);
                    }
                    return this.perDayItemListBuilder_.getMessage(index);
                }

                public Builder setPerDayItemList(int index, ItemParamOuterClass.ItemParam value) {
                    if (this.perDayItemListBuilder_ != null) {
                        this.perDayItemListBuilder_.setMessage(index, value);
                    } else if (value == null) {
                        throw new NullPointerException();
                    } else {
                        ensurePerDayItemListIsMutable();
                        this.perDayItemList_.set(index, value);
                        onChanged();
                    }
                    return this;
                }

                public Builder setPerDayItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                    if (this.perDayItemListBuilder_ == null) {
                        ensurePerDayItemListIsMutable();
                        this.perDayItemList_.set(index, builderForValue.build());
                        onChanged();
                    } else {
                        this.perDayItemListBuilder_.setMessage(index, builderForValue.build());
                    }
                    return this;
                }

                public Builder addPerDayItemList(ItemParamOuterClass.ItemParam value) {
                    if (this.perDayItemListBuilder_ != null) {
                        this.perDayItemListBuilder_.addMessage(value);
                    } else if (value == null) {
                        throw new NullPointerException();
                    } else {
                        ensurePerDayItemListIsMutable();
                        this.perDayItemList_.add(value);
                        onChanged();
                    }
                    return this;
                }

                public Builder addPerDayItemList(int index, ItemParamOuterClass.ItemParam value) {
                    if (this.perDayItemListBuilder_ != null) {
                        this.perDayItemListBuilder_.addMessage(index, value);
                    } else if (value == null) {
                        throw new NullPointerException();
                    } else {
                        ensurePerDayItemListIsMutable();
                        this.perDayItemList_.add(index, value);
                        onChanged();
                    }
                    return this;
                }

                public Builder addPerDayItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                    if (this.perDayItemListBuilder_ == null) {
                        ensurePerDayItemListIsMutable();
                        this.perDayItemList_.add(builderForValue.build());
                        onChanged();
                    } else {
                        this.perDayItemListBuilder_.addMessage(builderForValue.build());
                    }
                    return this;
                }

                public Builder addPerDayItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                    if (this.perDayItemListBuilder_ == null) {
                        ensurePerDayItemListIsMutable();
                        this.perDayItemList_.add(index, builderForValue.build());
                        onChanged();
                    } else {
                        this.perDayItemListBuilder_.addMessage(index, builderForValue.build());
                    }
                    return this;
                }

                public Builder addAllPerDayItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                    if (this.perDayItemListBuilder_ == null) {
                        ensurePerDayItemListIsMutable();
                        AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.perDayItemList_);
                        onChanged();
                    } else {
                        this.perDayItemListBuilder_.addAllMessages(values);
                    }
                    return this;
                }

                public Builder clearPerDayItemList() {
                    if (this.perDayItemListBuilder_ == null) {
                        this.perDayItemList_ = Collections.emptyList();
                        this.bitField0_ &= -3;
                        onChanged();
                    } else {
                        this.perDayItemListBuilder_.clear();
                    }
                    return this;
                }

                public Builder removePerDayItemList(int index) {
                    if (this.perDayItemListBuilder_ == null) {
                        ensurePerDayItemListIsMutable();
                        this.perDayItemList_.remove(index);
                        onChanged();
                    } else {
                        this.perDayItemListBuilder_.remove(index);
                    }
                    return this;
                }

                public ItemParamOuterClass.ItemParam.Builder getPerDayItemListBuilder(int index) {
                    return getPerDayItemListFieldBuilder().getBuilder(index);
                }

                @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
                public ItemParamOuterClass.ItemParamOrBuilder getPerDayItemListOrBuilder(int index) {
                    if (this.perDayItemListBuilder_ == null) {
                        return this.perDayItemList_.get(index);
                    }
                    return this.perDayItemListBuilder_.getMessageOrBuilder(index);
                }

                @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProduct.ResinCardOrBuilder
                public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getPerDayItemListOrBuilderList() {
                    if (this.perDayItemListBuilder_ != null) {
                        return this.perDayItemListBuilder_.getMessageOrBuilderList();
                    }
                    return Collections.unmodifiableList(this.perDayItemList_);
                }

                public ItemParamOuterClass.ItemParam.Builder addPerDayItemListBuilder() {
                    return getPerDayItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
                }

                public ItemParamOuterClass.ItemParam.Builder addPerDayItemListBuilder(int index) {
                    return getPerDayItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
                }

                public List<ItemParamOuterClass.ItemParam.Builder> getPerDayItemListBuilderList() {
                    return getPerDayItemListFieldBuilder().getBuilderList();
                }

                private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getPerDayItemListFieldBuilder() {
                    if (this.perDayItemListBuilder_ == null) {
                        this.perDayItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.perDayItemList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                        this.perDayItemList_ = null;
                    }
                    return this.perDayItemListBuilder_;
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

            public static ResinCard getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<ResinCard> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<ResinCard> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ResinCard getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopCardProductOuterClass$ShopCardProduct$ExtraCardDataCase.class */
        public enum ExtraCardDataCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            RESIN_CARD(101),
            EXTRACARDDATA_NOT_SET(0);
            
            private final int value;

            ExtraCardDataCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static ExtraCardDataCase valueOf(int value) {
                return forNumber(value);
            }

            public static ExtraCardDataCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return EXTRACARDDATA_NOT_SET;
                    case 101:
                        return RESIN_CARD;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
        public ExtraCardDataCase getExtraCardDataCase() {
            return ExtraCardDataCase.forNumber(this.extraCardDataCase_);
        }

        @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
        public String getProductId() {
            Object ref = this.productId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.productId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
        public ByteString getProductIdBytes() {
            Object ref = this.productId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.productId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
        public String getPriceTier() {
            Object ref = this.priceTier_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.priceTier_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
        public ByteString getPriceTierBytes() {
            Object ref = this.priceTier_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.priceTier_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
        public int getMcoinBase() {
            return this.mcoinBase_;
        }

        @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
        public int getHcoinPerDay() {
            return this.hcoinPerDay_;
        }

        @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
        public int getDays() {
            return this.days_;
        }

        @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
        public int getRemainRewardDays() {
            return this.remainRewardDays_;
        }

        @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
        public int getCardProductType() {
            return this.cardProductType_;
        }

        @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
        public boolean hasResinCard() {
            return this.extraCardDataCase_ == 101;
        }

        @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
        public ResinCard getResinCard() {
            if (this.extraCardDataCase_ == 101) {
                return (ResinCard) this.extraCardData_;
            }
            return ResinCard.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
        public ResinCardOrBuilder getResinCardOrBuilder() {
            if (this.extraCardDataCase_ == 101) {
                return (ResinCard) this.extraCardData_;
            }
            return ResinCard.getDefaultInstance();
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
            if (!GeneratedMessageV3.isStringEmpty(this.productId_)) {
                GeneratedMessageV3.writeString(output, 1, this.productId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.priceTier_)) {
                GeneratedMessageV3.writeString(output, 2, this.priceTier_);
            }
            if (this.mcoinBase_ != 0) {
                output.writeUInt32(3, this.mcoinBase_);
            }
            if (this.hcoinPerDay_ != 0) {
                output.writeUInt32(4, this.hcoinPerDay_);
            }
            if (this.days_ != 0) {
                output.writeUInt32(5, this.days_);
            }
            if (this.remainRewardDays_ != 0) {
                output.writeUInt32(6, this.remainRewardDays_);
            }
            if (this.cardProductType_ != 0) {
                output.writeUInt32(7, this.cardProductType_);
            }
            if (this.extraCardDataCase_ == 101) {
                output.writeMessage(101, (ResinCard) this.extraCardData_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.productId_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(1, this.productId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.priceTier_)) {
                size2 += GeneratedMessageV3.computeStringSize(2, this.priceTier_);
            }
            if (this.mcoinBase_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.mcoinBase_);
            }
            if (this.hcoinPerDay_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.hcoinPerDay_);
            }
            if (this.days_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.days_);
            }
            if (this.remainRewardDays_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.remainRewardDays_);
            }
            if (this.cardProductType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.cardProductType_);
            }
            if (this.extraCardDataCase_ == 101) {
                size2 += CodedOutputStream.computeMessageSize(101, (ResinCard) this.extraCardData_);
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
            if (!(obj instanceof ShopCardProduct)) {
                return equals(obj);
            }
            ShopCardProduct other = (ShopCardProduct) obj;
            if (!getProductId().equals(other.getProductId()) || !getPriceTier().equals(other.getPriceTier()) || getMcoinBase() != other.getMcoinBase() || getHcoinPerDay() != other.getHcoinPerDay() || getDays() != other.getDays() || getRemainRewardDays() != other.getRemainRewardDays() || getCardProductType() != other.getCardProductType() || !getExtraCardDataCase().equals(other.getExtraCardDataCase())) {
                return false;
            }
            switch (this.extraCardDataCase_) {
                case 101:
                    if (!getResinCard().equals(other.getResinCard())) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getProductId().hashCode())) + 2)) + getPriceTier().hashCode())) + 3)) + getMcoinBase())) + 4)) + getHcoinPerDay())) + 5)) + getDays())) + 6)) + getRemainRewardDays())) + 7)) + getCardProductType();
            switch (this.extraCardDataCase_) {
                case 101:
                    hash = (53 * ((37 * hash) + 101)) + getResinCard().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ShopCardProduct parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShopCardProduct parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShopCardProduct parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShopCardProduct parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShopCardProduct parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShopCardProduct parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShopCardProduct parseFrom(InputStream input) throws IOException {
            return (ShopCardProduct) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ShopCardProduct parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopCardProduct) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ShopCardProduct parseDelimitedFrom(InputStream input) throws IOException {
            return (ShopCardProduct) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ShopCardProduct parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopCardProduct) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ShopCardProduct parseFrom(CodedInputStream input) throws IOException {
            return (ShopCardProduct) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ShopCardProduct parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopCardProduct) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ShopCardProduct prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopCardProductOuterClass$ShopCardProduct$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ShopCardProductOrBuilder {
            private Object extraCardData_;
            private int mcoinBase_;
            private int hcoinPerDay_;
            private int days_;
            private int remainRewardDays_;
            private int cardProductType_;
            private SingleFieldBuilderV3<ResinCard, ResinCard.Builder, ResinCardOrBuilder> resinCardBuilder_;
            private int extraCardDataCase_ = 0;
            private Object productId_ = "";
            private Object priceTier_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return ShopCardProductOuterClass.internal_static_ShopCardProduct_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopCardProductOuterClass.internal_static_ShopCardProduct_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopCardProduct.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ShopCardProduct.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.productId_ = "";
                this.priceTier_ = "";
                this.mcoinBase_ = 0;
                this.hcoinPerDay_ = 0;
                this.days_ = 0;
                this.remainRewardDays_ = 0;
                this.cardProductType_ = 0;
                this.extraCardDataCase_ = 0;
                this.extraCardData_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ShopCardProductOuterClass.internal_static_ShopCardProduct_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ShopCardProduct getDefaultInstanceForType() {
                return ShopCardProduct.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ShopCardProduct build() {
                ShopCardProduct result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ShopCardProduct buildPartial() {
                ShopCardProduct result = new ShopCardProduct(this);
                result.productId_ = this.productId_;
                result.priceTier_ = this.priceTier_;
                result.mcoinBase_ = this.mcoinBase_;
                result.hcoinPerDay_ = this.hcoinPerDay_;
                result.days_ = this.days_;
                result.remainRewardDays_ = this.remainRewardDays_;
                result.cardProductType_ = this.cardProductType_;
                if (this.extraCardDataCase_ == 101) {
                    if (this.resinCardBuilder_ == null) {
                        result.extraCardData_ = this.extraCardData_;
                    } else {
                        result.extraCardData_ = this.resinCardBuilder_.build();
                    }
                }
                result.extraCardDataCase_ = this.extraCardDataCase_;
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
                if (other instanceof ShopCardProduct) {
                    return mergeFrom((ShopCardProduct) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ShopCardProduct other) {
                if (other == ShopCardProduct.getDefaultInstance()) {
                    return this;
                }
                if (!other.getProductId().isEmpty()) {
                    this.productId_ = other.productId_;
                    onChanged();
                }
                if (!other.getPriceTier().isEmpty()) {
                    this.priceTier_ = other.priceTier_;
                    onChanged();
                }
                if (other.getMcoinBase() != 0) {
                    setMcoinBase(other.getMcoinBase());
                }
                if (other.getHcoinPerDay() != 0) {
                    setHcoinPerDay(other.getHcoinPerDay());
                }
                if (other.getDays() != 0) {
                    setDays(other.getDays());
                }
                if (other.getRemainRewardDays() != 0) {
                    setRemainRewardDays(other.getRemainRewardDays());
                }
                if (other.getCardProductType() != 0) {
                    setCardProductType(other.getCardProductType());
                }
                switch (other.getExtraCardDataCase()) {
                    case RESIN_CARD:
                        mergeResinCard(other.getResinCard());
                        break;
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
                ShopCardProduct parsedMessage = null;
                try {
                    try {
                        parsedMessage = ShopCardProduct.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ShopCardProduct) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
            public ExtraCardDataCase getExtraCardDataCase() {
                return ExtraCardDataCase.forNumber(this.extraCardDataCase_);
            }

            public Builder clearExtraCardData() {
                this.extraCardDataCase_ = 0;
                this.extraCardData_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
            public String getProductId() {
                Object ref = this.productId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.productId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
            public ByteString getProductIdBytes() {
                Object ref = this.productId_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.productId_ = b;
                return b;
            }

            public Builder setProductId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.productId_ = value;
                onChanged();
                return this;
            }

            public Builder clearProductId() {
                this.productId_ = ShopCardProduct.getDefaultInstance().getProductId();
                onChanged();
                return this;
            }

            public Builder setProductIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ShopCardProduct.checkByteStringIsUtf8(value);
                this.productId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
            public String getPriceTier() {
                Object ref = this.priceTier_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.priceTier_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
            public ByteString getPriceTierBytes() {
                Object ref = this.priceTier_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.priceTier_ = b;
                return b;
            }

            public Builder setPriceTier(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.priceTier_ = value;
                onChanged();
                return this;
            }

            public Builder clearPriceTier() {
                this.priceTier_ = ShopCardProduct.getDefaultInstance().getPriceTier();
                onChanged();
                return this;
            }

            public Builder setPriceTierBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ShopCardProduct.checkByteStringIsUtf8(value);
                this.priceTier_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
            public int getMcoinBase() {
                return this.mcoinBase_;
            }

            public Builder setMcoinBase(int value) {
                this.mcoinBase_ = value;
                onChanged();
                return this;
            }

            public Builder clearMcoinBase() {
                this.mcoinBase_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
            public int getHcoinPerDay() {
                return this.hcoinPerDay_;
            }

            public Builder setHcoinPerDay(int value) {
                this.hcoinPerDay_ = value;
                onChanged();
                return this;
            }

            public Builder clearHcoinPerDay() {
                this.hcoinPerDay_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
            public int getDays() {
                return this.days_;
            }

            public Builder setDays(int value) {
                this.days_ = value;
                onChanged();
                return this;
            }

            public Builder clearDays() {
                this.days_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
            public int getRemainRewardDays() {
                return this.remainRewardDays_;
            }

            public Builder setRemainRewardDays(int value) {
                this.remainRewardDays_ = value;
                onChanged();
                return this;
            }

            public Builder clearRemainRewardDays() {
                this.remainRewardDays_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
            public int getCardProductType() {
                return this.cardProductType_;
            }

            public Builder setCardProductType(int value) {
                this.cardProductType_ = value;
                onChanged();
                return this;
            }

            public Builder clearCardProductType() {
                this.cardProductType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
            public boolean hasResinCard() {
                return this.extraCardDataCase_ == 101;
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
            public ResinCard getResinCard() {
                if (this.resinCardBuilder_ == null) {
                    if (this.extraCardDataCase_ == 101) {
                        return (ResinCard) this.extraCardData_;
                    }
                    return ResinCard.getDefaultInstance();
                } else if (this.extraCardDataCase_ == 101) {
                    return this.resinCardBuilder_.getMessage();
                } else {
                    return ResinCard.getDefaultInstance();
                }
            }

            public Builder setResinCard(ResinCard value) {
                if (this.resinCardBuilder_ != null) {
                    this.resinCardBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.extraCardData_ = value;
                    onChanged();
                }
                this.extraCardDataCase_ = 101;
                return this;
            }

            public Builder setResinCard(ResinCard.Builder builderForValue) {
                if (this.resinCardBuilder_ == null) {
                    this.extraCardData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.resinCardBuilder_.setMessage(builderForValue.build());
                }
                this.extraCardDataCase_ = 101;
                return this;
            }

            public Builder mergeResinCard(ResinCard value) {
                if (this.resinCardBuilder_ == null) {
                    if (this.extraCardDataCase_ != 101 || this.extraCardData_ == ResinCard.getDefaultInstance()) {
                        this.extraCardData_ = value;
                    } else {
                        this.extraCardData_ = ResinCard.newBuilder((ResinCard) this.extraCardData_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.extraCardDataCase_ == 101) {
                        this.resinCardBuilder_.mergeFrom(value);
                    }
                    this.resinCardBuilder_.setMessage(value);
                }
                this.extraCardDataCase_ = 101;
                return this;
            }

            public Builder clearResinCard() {
                if (this.resinCardBuilder_ != null) {
                    if (this.extraCardDataCase_ == 101) {
                        this.extraCardDataCase_ = 0;
                        this.extraCardData_ = null;
                    }
                    this.resinCardBuilder_.clear();
                } else if (this.extraCardDataCase_ == 101) {
                    this.extraCardDataCase_ = 0;
                    this.extraCardData_ = null;
                    onChanged();
                }
                return this;
            }

            public ResinCard.Builder getResinCardBuilder() {
                return getResinCardFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ShopCardProductOuterClass.ShopCardProductOrBuilder
            public ResinCardOrBuilder getResinCardOrBuilder() {
                if (this.extraCardDataCase_ == 101 && this.resinCardBuilder_ != null) {
                    return this.resinCardBuilder_.getMessageOrBuilder();
                }
                if (this.extraCardDataCase_ == 101) {
                    return (ResinCard) this.extraCardData_;
                }
                return ResinCard.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ResinCard, ResinCard.Builder, ResinCardOrBuilder> getResinCardFieldBuilder() {
                if (this.resinCardBuilder_ == null) {
                    if (this.extraCardDataCase_ != 101) {
                        this.extraCardData_ = ResinCard.getDefaultInstance();
                    }
                    this.resinCardBuilder_ = new SingleFieldBuilderV3<>((ResinCard) this.extraCardData_, getParentForChildren(), isClean());
                    this.extraCardData_ = null;
                }
                this.extraCardDataCase_ = 101;
                onChanged();
                return this.resinCardBuilder_;
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

        public static ShopCardProduct getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ShopCardProduct> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ShopCardProduct> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ShopCardProduct getDefaultInstanceForType() {
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
