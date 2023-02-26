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
import emu.grasscutter.net.proto.ShopCardProductOuterClass;
import emu.grasscutter.net.proto.ShopConcertProductOuterClass;
import emu.grasscutter.net.proto.ShopGoodsOuterClass;
import emu.grasscutter.net.proto.ShopMcoinProductOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopOuterClass.class */
public final class ShopOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\nShop.proto\u001a\u0016ShopMcoinProduct.proto\u001a\u0018ShopConcertProduct.proto\u001a\u0015ShopCardProduct.proto\u001a\u000fShopGoods.proto\"\u0002\n\u0004Shop\u0012+\n\u0010mcoinProductList\u0018\u0006 \u0003(\u000b2\u0011.ShopMcoinProduct\u0012\u000e\n\u0006cityId\u0018\n \u0001(\r\u0012/\n\u0012concertProductList\u0018\r \u0003(\u000b2\u0013.ShopConcertProduct\u0012\u0017\n\u000fnextRefreshTime\u0018\u000e \u0001(\r\u0012)\n\u000fcardProductList\u0018\t \u0003(\u000b2\u0010.ShopCardProduct\u0012\u001b\n\u0013cityReputationLevel\u0018\u0004 \u0001(\r\u0012\u0010\n\bshopType\u0018\u0005 \u0001(\r\u0012\u001d\n\tgoodsList\u0018\u000f \u0003(\u000b2\n.ShopGoodsB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ShopMcoinProductOuterClass.getDescriptor(), ShopConcertProductOuterClass.getDescriptor(), ShopCardProductOuterClass.getDescriptor(), ShopGoodsOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_Shop_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_Shop_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_Shop_descriptor, new String[]{"McoinProductList", "CityId", "ConcertProductList", "NextRefreshTime", "CardProductList", "CityReputationLevel", "ShopType", "GoodsList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopOuterClass$ShopOrBuilder.class */
    public interface ShopOrBuilder extends MessageOrBuilder {
        List<ShopMcoinProductOuterClass.ShopMcoinProduct> getMcoinProductListList();

        ShopMcoinProductOuterClass.ShopMcoinProduct getMcoinProductList(int i);

        int getMcoinProductListCount();

        List<? extends ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder> getMcoinProductListOrBuilderList();

        ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder getMcoinProductListOrBuilder(int i);

        int getCityId();

        List<ShopConcertProductOuterClass.ShopConcertProduct> getConcertProductListList();

        ShopConcertProductOuterClass.ShopConcertProduct getConcertProductList(int i);

        int getConcertProductListCount();

        List<? extends ShopConcertProductOuterClass.ShopConcertProductOrBuilder> getConcertProductListOrBuilderList();

        ShopConcertProductOuterClass.ShopConcertProductOrBuilder getConcertProductListOrBuilder(int i);

        int getNextRefreshTime();

        List<ShopCardProductOuterClass.ShopCardProduct> getCardProductListList();

        ShopCardProductOuterClass.ShopCardProduct getCardProductList(int i);

        int getCardProductListCount();

        List<? extends ShopCardProductOuterClass.ShopCardProductOrBuilder> getCardProductListOrBuilderList();

        ShopCardProductOuterClass.ShopCardProductOrBuilder getCardProductListOrBuilder(int i);

        int getCityReputationLevel();

        int getShopType();

        List<ShopGoodsOuterClass.ShopGoods> getGoodsListList();

        ShopGoodsOuterClass.ShopGoods getGoodsList(int i);

        int getGoodsListCount();

        List<? extends ShopGoodsOuterClass.ShopGoodsOrBuilder> getGoodsListOrBuilderList();

        ShopGoodsOuterClass.ShopGoodsOrBuilder getGoodsListOrBuilder(int i);
    }

    private ShopOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopOuterClass$Shop.class */
    public static final class Shop extends GeneratedMessageV3 implements ShopOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MCOINPRODUCTLIST_FIELD_NUMBER = 6;
        private List<ShopMcoinProductOuterClass.ShopMcoinProduct> mcoinProductList_;
        public static final int CITYID_FIELD_NUMBER = 10;
        private int cityId_;
        public static final int CONCERTPRODUCTLIST_FIELD_NUMBER = 13;
        private List<ShopConcertProductOuterClass.ShopConcertProduct> concertProductList_;
        public static final int NEXTREFRESHTIME_FIELD_NUMBER = 14;
        private int nextRefreshTime_;
        public static final int CARDPRODUCTLIST_FIELD_NUMBER = 9;
        private List<ShopCardProductOuterClass.ShopCardProduct> cardProductList_;
        public static final int CITYREPUTATIONLEVEL_FIELD_NUMBER = 4;
        private int cityReputationLevel_;
        public static final int SHOPTYPE_FIELD_NUMBER = 5;
        private int shopType_;
        public static final int GOODSLIST_FIELD_NUMBER = 15;
        private List<ShopGoodsOuterClass.ShopGoods> goodsList_;
        private byte memoizedIsInitialized;
        private static final Shop DEFAULT_INSTANCE = new Shop();
        private static final Parser<Shop> PARSER = new AbstractParser<Shop>() { // from class: emu.grasscutter.net.proto.ShopOuterClass.Shop.1
            @Override // com.google.protobuf.Parser
            public Shop parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Shop(input, extensionRegistry);
            }
        };

        private Shop(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private Shop() {
            this.memoizedIsInitialized = -1;
            this.mcoinProductList_ = Collections.emptyList();
            this.concertProductList_ = Collections.emptyList();
            this.cardProductList_ = Collections.emptyList();
            this.goodsList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new Shop();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x0170 */
        private Shop(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.cityReputationLevel_ = input.readUInt32();
                                    break;
                                case 40:
                                    this.shopType_ = input.readUInt32();
                                    break;
                                case 50:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.mcoinProductList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.mcoinProductList_.add((ShopMcoinProductOuterClass.ShopMcoinProduct) input.readMessage(ShopMcoinProductOuterClass.ShopMcoinProduct.parser(), extensionRegistry));
                                    break;
                                case 74:
                                    if ((mutable_bitField0_ & 4) == 0) {
                                        this.cardProductList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    this.cardProductList_.add((ShopCardProductOuterClass.ShopCardProduct) input.readMessage(ShopCardProductOuterClass.ShopCardProduct.parser(), extensionRegistry));
                                    break;
                                case 80:
                                    this.cityId_ = input.readUInt32();
                                    break;
                                case 106:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.concertProductList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.concertProductList_.add((ShopConcertProductOuterClass.ShopConcertProduct) input.readMessage(ShopConcertProductOuterClass.ShopConcertProduct.parser(), extensionRegistry));
                                    break;
                                case 112:
                                    this.nextRefreshTime_ = input.readUInt32();
                                    break;
                                case 122:
                                    if ((mutable_bitField0_ & 8) == 0) {
                                        this.goodsList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.mcoinProductList_ = Collections.unmodifiableList(this.mcoinProductList_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.cardProductList_ = Collections.unmodifiableList(this.cardProductList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.concertProductList_ = Collections.unmodifiableList(this.concertProductList_);
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.goodsList_ = Collections.unmodifiableList(this.goodsList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ShopOuterClass.internal_static_Shop_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopOuterClass.internal_static_Shop_fieldAccessorTable.ensureFieldAccessorsInitialized(Shop.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public List<ShopMcoinProductOuterClass.ShopMcoinProduct> getMcoinProductListList() {
            return this.mcoinProductList_;
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public List<? extends ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder> getMcoinProductListOrBuilderList() {
            return this.mcoinProductList_;
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public int getMcoinProductListCount() {
            return this.mcoinProductList_.size();
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public ShopMcoinProductOuterClass.ShopMcoinProduct getMcoinProductList(int index) {
            return this.mcoinProductList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder getMcoinProductListOrBuilder(int index) {
            return this.mcoinProductList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public int getCityId() {
            return this.cityId_;
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public List<ShopConcertProductOuterClass.ShopConcertProduct> getConcertProductListList() {
            return this.concertProductList_;
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public List<? extends ShopConcertProductOuterClass.ShopConcertProductOrBuilder> getConcertProductListOrBuilderList() {
            return this.concertProductList_;
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public int getConcertProductListCount() {
            return this.concertProductList_.size();
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public ShopConcertProductOuterClass.ShopConcertProduct getConcertProductList(int index) {
            return this.concertProductList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public ShopConcertProductOuterClass.ShopConcertProductOrBuilder getConcertProductListOrBuilder(int index) {
            return this.concertProductList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public int getNextRefreshTime() {
            return this.nextRefreshTime_;
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public List<ShopCardProductOuterClass.ShopCardProduct> getCardProductListList() {
            return this.cardProductList_;
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public List<? extends ShopCardProductOuterClass.ShopCardProductOrBuilder> getCardProductListOrBuilderList() {
            return this.cardProductList_;
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public int getCardProductListCount() {
            return this.cardProductList_.size();
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public ShopCardProductOuterClass.ShopCardProduct getCardProductList(int index) {
            return this.cardProductList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public ShopCardProductOuterClass.ShopCardProductOrBuilder getCardProductListOrBuilder(int index) {
            return this.cardProductList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public int getCityReputationLevel() {
            return this.cityReputationLevel_;
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public int getShopType() {
            return this.shopType_;
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public List<ShopGoodsOuterClass.ShopGoods> getGoodsListList() {
            return this.goodsList_;
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public List<? extends ShopGoodsOuterClass.ShopGoodsOrBuilder> getGoodsListOrBuilderList() {
            return this.goodsList_;
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public int getGoodsListCount() {
            return this.goodsList_.size();
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public ShopGoodsOuterClass.ShopGoods getGoodsList(int index) {
            return this.goodsList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
        public ShopGoodsOuterClass.ShopGoodsOrBuilder getGoodsListOrBuilder(int index) {
            return this.goodsList_.get(index);
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
            if (this.cityReputationLevel_ != 0) {
                output.writeUInt32(4, this.cityReputationLevel_);
            }
            if (this.shopType_ != 0) {
                output.writeUInt32(5, this.shopType_);
            }
            for (int i = 0; i < this.mcoinProductList_.size(); i++) {
                output.writeMessage(6, this.mcoinProductList_.get(i));
            }
            for (int i2 = 0; i2 < this.cardProductList_.size(); i2++) {
                output.writeMessage(9, this.cardProductList_.get(i2));
            }
            if (this.cityId_ != 0) {
                output.writeUInt32(10, this.cityId_);
            }
            for (int i3 = 0; i3 < this.concertProductList_.size(); i3++) {
                output.writeMessage(13, this.concertProductList_.get(i3));
            }
            if (this.nextRefreshTime_ != 0) {
                output.writeUInt32(14, this.nextRefreshTime_);
            }
            for (int i4 = 0; i4 < this.goodsList_.size(); i4++) {
                output.writeMessage(15, this.goodsList_.get(i4));
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
            if (this.cityReputationLevel_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.cityReputationLevel_);
            }
            if (this.shopType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.shopType_);
            }
            for (int i = 0; i < this.mcoinProductList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.mcoinProductList_.get(i));
            }
            for (int i2 = 0; i2 < this.cardProductList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.cardProductList_.get(i2));
            }
            if (this.cityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.cityId_);
            }
            for (int i3 = 0; i3 < this.concertProductList_.size(); i3++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.concertProductList_.get(i3));
            }
            if (this.nextRefreshTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.nextRefreshTime_);
            }
            for (int i4 = 0; i4 < this.goodsList_.size(); i4++) {
                size2 += CodedOutputStream.computeMessageSize(15, this.goodsList_.get(i4));
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
            if (!(obj instanceof Shop)) {
                return equals(obj);
            }
            Shop other = (Shop) obj;
            return getMcoinProductListList().equals(other.getMcoinProductListList()) && getCityId() == other.getCityId() && getConcertProductListList().equals(other.getConcertProductListList()) && getNextRefreshTime() == other.getNextRefreshTime() && getCardProductListList().equals(other.getCardProductListList()) && getCityReputationLevel() == other.getCityReputationLevel() && getShopType() == other.getShopType() && getGoodsListList().equals(other.getGoodsListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getMcoinProductListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getMcoinProductListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 10)) + getCityId();
            if (getConcertProductListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 13)) + getConcertProductListList().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 14)) + getNextRefreshTime();
            if (getCardProductListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 9)) + getCardProductListList().hashCode();
            }
            int hash4 = (53 * ((37 * ((53 * ((37 * hash3) + 4)) + getCityReputationLevel())) + 5)) + getShopType();
            if (getGoodsListCount() > 0) {
                hash4 = (53 * ((37 * hash4) + 15)) + getGoodsListList().hashCode();
            }
            int hash5 = (29 * hash4) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash5;
            return hash5;
        }

        public static Shop parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Shop parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Shop parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Shop parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Shop parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Shop parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Shop parseFrom(InputStream input) throws IOException {
            return (Shop) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Shop parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Shop) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static Shop parseDelimitedFrom(InputStream input) throws IOException {
            return (Shop) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static Shop parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Shop) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static Shop parseFrom(CodedInputStream input) throws IOException {
            return (Shop) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Shop parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Shop) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Shop prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopOuterClass$Shop$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ShopOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<ShopMcoinProductOuterClass.ShopMcoinProduct, ShopMcoinProductOuterClass.ShopMcoinProduct.Builder, ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder> mcoinProductListBuilder_;
            private int cityId_;
            private RepeatedFieldBuilderV3<ShopConcertProductOuterClass.ShopConcertProduct, ShopConcertProductOuterClass.ShopConcertProduct.Builder, ShopConcertProductOuterClass.ShopConcertProductOrBuilder> concertProductListBuilder_;
            private int nextRefreshTime_;
            private RepeatedFieldBuilderV3<ShopCardProductOuterClass.ShopCardProduct, ShopCardProductOuterClass.ShopCardProduct.Builder, ShopCardProductOuterClass.ShopCardProductOrBuilder> cardProductListBuilder_;
            private int cityReputationLevel_;
            private int shopType_;
            private RepeatedFieldBuilderV3<ShopGoodsOuterClass.ShopGoods, ShopGoodsOuterClass.ShopGoods.Builder, ShopGoodsOuterClass.ShopGoodsOrBuilder> goodsListBuilder_;
            private List<ShopMcoinProductOuterClass.ShopMcoinProduct> mcoinProductList_ = Collections.emptyList();
            private List<ShopConcertProductOuterClass.ShopConcertProduct> concertProductList_ = Collections.emptyList();
            private List<ShopCardProductOuterClass.ShopCardProduct> cardProductList_ = Collections.emptyList();
            private List<ShopGoodsOuterClass.ShopGoods> goodsList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ShopOuterClass.internal_static_Shop_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopOuterClass.internal_static_Shop_fieldAccessorTable.ensureFieldAccessorsInitialized(Shop.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Shop.alwaysUseFieldBuilders) {
                    getMcoinProductListFieldBuilder();
                    getConcertProductListFieldBuilder();
                    getCardProductListFieldBuilder();
                    getGoodsListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.mcoinProductListBuilder_ == null) {
                    this.mcoinProductList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.mcoinProductListBuilder_.clear();
                }
                this.cityId_ = 0;
                if (this.concertProductListBuilder_ == null) {
                    this.concertProductList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.concertProductListBuilder_.clear();
                }
                this.nextRefreshTime_ = 0;
                if (this.cardProductListBuilder_ == null) {
                    this.cardProductList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.cardProductListBuilder_.clear();
                }
                this.cityReputationLevel_ = 0;
                this.shopType_ = 0;
                if (this.goodsListBuilder_ == null) {
                    this.goodsList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.goodsListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ShopOuterClass.internal_static_Shop_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Shop getDefaultInstanceForType() {
                return Shop.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Shop build() {
                Shop result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Shop buildPartial() {
                Shop result = new Shop(this);
                int i = this.bitField0_;
                if (this.mcoinProductListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.mcoinProductList_ = Collections.unmodifiableList(this.mcoinProductList_);
                        this.bitField0_ &= -2;
                    }
                    result.mcoinProductList_ = this.mcoinProductList_;
                } else {
                    result.mcoinProductList_ = this.mcoinProductListBuilder_.build();
                }
                result.cityId_ = this.cityId_;
                if (this.concertProductListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.concertProductList_ = Collections.unmodifiableList(this.concertProductList_);
                        this.bitField0_ &= -3;
                    }
                    result.concertProductList_ = this.concertProductList_;
                } else {
                    result.concertProductList_ = this.concertProductListBuilder_.build();
                }
                result.nextRefreshTime_ = this.nextRefreshTime_;
                if (this.cardProductListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.cardProductList_ = Collections.unmodifiableList(this.cardProductList_);
                        this.bitField0_ &= -5;
                    }
                    result.cardProductList_ = this.cardProductList_;
                } else {
                    result.cardProductList_ = this.cardProductListBuilder_.build();
                }
                result.cityReputationLevel_ = this.cityReputationLevel_;
                result.shopType_ = this.shopType_;
                if (this.goodsListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.goodsList_ = Collections.unmodifiableList(this.goodsList_);
                        this.bitField0_ &= -9;
                    }
                    result.goodsList_ = this.goodsList_;
                } else {
                    result.goodsList_ = this.goodsListBuilder_.build();
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
                if (other instanceof Shop) {
                    return mergeFrom((Shop) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Shop other) {
                if (other == Shop.getDefaultInstance()) {
                    return this;
                }
                if (this.mcoinProductListBuilder_ == null) {
                    if (!other.mcoinProductList_.isEmpty()) {
                        if (this.mcoinProductList_.isEmpty()) {
                            this.mcoinProductList_ = other.mcoinProductList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMcoinProductListIsMutable();
                            this.mcoinProductList_.addAll(other.mcoinProductList_);
                        }
                        onChanged();
                    }
                } else if (!other.mcoinProductList_.isEmpty()) {
                    if (this.mcoinProductListBuilder_.isEmpty()) {
                        this.mcoinProductListBuilder_.dispose();
                        this.mcoinProductListBuilder_ = null;
                        this.mcoinProductList_ = other.mcoinProductList_;
                        this.bitField0_ &= -2;
                        this.mcoinProductListBuilder_ = Shop.alwaysUseFieldBuilders ? getMcoinProductListFieldBuilder() : null;
                    } else {
                        this.mcoinProductListBuilder_.addAllMessages(other.mcoinProductList_);
                    }
                }
                if (other.getCityId() != 0) {
                    setCityId(other.getCityId());
                }
                if (this.concertProductListBuilder_ == null) {
                    if (!other.concertProductList_.isEmpty()) {
                        if (this.concertProductList_.isEmpty()) {
                            this.concertProductList_ = other.concertProductList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureConcertProductListIsMutable();
                            this.concertProductList_.addAll(other.concertProductList_);
                        }
                        onChanged();
                    }
                } else if (!other.concertProductList_.isEmpty()) {
                    if (this.concertProductListBuilder_.isEmpty()) {
                        this.concertProductListBuilder_.dispose();
                        this.concertProductListBuilder_ = null;
                        this.concertProductList_ = other.concertProductList_;
                        this.bitField0_ &= -3;
                        this.concertProductListBuilder_ = Shop.alwaysUseFieldBuilders ? getConcertProductListFieldBuilder() : null;
                    } else {
                        this.concertProductListBuilder_.addAllMessages(other.concertProductList_);
                    }
                }
                if (other.getNextRefreshTime() != 0) {
                    setNextRefreshTime(other.getNextRefreshTime());
                }
                if (this.cardProductListBuilder_ == null) {
                    if (!other.cardProductList_.isEmpty()) {
                        if (this.cardProductList_.isEmpty()) {
                            this.cardProductList_ = other.cardProductList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureCardProductListIsMutable();
                            this.cardProductList_.addAll(other.cardProductList_);
                        }
                        onChanged();
                    }
                } else if (!other.cardProductList_.isEmpty()) {
                    if (this.cardProductListBuilder_.isEmpty()) {
                        this.cardProductListBuilder_.dispose();
                        this.cardProductListBuilder_ = null;
                        this.cardProductList_ = other.cardProductList_;
                        this.bitField0_ &= -5;
                        this.cardProductListBuilder_ = Shop.alwaysUseFieldBuilders ? getCardProductListFieldBuilder() : null;
                    } else {
                        this.cardProductListBuilder_.addAllMessages(other.cardProductList_);
                    }
                }
                if (other.getCityReputationLevel() != 0) {
                    setCityReputationLevel(other.getCityReputationLevel());
                }
                if (other.getShopType() != 0) {
                    setShopType(other.getShopType());
                }
                if (this.goodsListBuilder_ == null) {
                    if (!other.goodsList_.isEmpty()) {
                        if (this.goodsList_.isEmpty()) {
                            this.goodsList_ = other.goodsList_;
                            this.bitField0_ &= -9;
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
                        this.bitField0_ &= -9;
                        this.goodsListBuilder_ = Shop.alwaysUseFieldBuilders ? getGoodsListFieldBuilder() : null;
                    } else {
                        this.goodsListBuilder_.addAllMessages(other.goodsList_);
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
                Shop parsedMessage = null;
                try {
                    try {
                        parsedMessage = Shop.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (Shop) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureMcoinProductListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.mcoinProductList_ = new ArrayList(this.mcoinProductList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public List<ShopMcoinProductOuterClass.ShopMcoinProduct> getMcoinProductListList() {
                if (this.mcoinProductListBuilder_ == null) {
                    return Collections.unmodifiableList(this.mcoinProductList_);
                }
                return this.mcoinProductListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public int getMcoinProductListCount() {
                if (this.mcoinProductListBuilder_ == null) {
                    return this.mcoinProductList_.size();
                }
                return this.mcoinProductListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public ShopMcoinProductOuterClass.ShopMcoinProduct getMcoinProductList(int index) {
                if (this.mcoinProductListBuilder_ == null) {
                    return this.mcoinProductList_.get(index);
                }
                return this.mcoinProductListBuilder_.getMessage(index);
            }

            public Builder setMcoinProductList(int index, ShopMcoinProductOuterClass.ShopMcoinProduct value) {
                if (this.mcoinProductListBuilder_ != null) {
                    this.mcoinProductListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMcoinProductListIsMutable();
                    this.mcoinProductList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMcoinProductList(int index, ShopMcoinProductOuterClass.ShopMcoinProduct.Builder builderForValue) {
                if (this.mcoinProductListBuilder_ == null) {
                    ensureMcoinProductListIsMutable();
                    this.mcoinProductList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.mcoinProductListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMcoinProductList(ShopMcoinProductOuterClass.ShopMcoinProduct value) {
                if (this.mcoinProductListBuilder_ != null) {
                    this.mcoinProductListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMcoinProductListIsMutable();
                    this.mcoinProductList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMcoinProductList(int index, ShopMcoinProductOuterClass.ShopMcoinProduct value) {
                if (this.mcoinProductListBuilder_ != null) {
                    this.mcoinProductListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMcoinProductListIsMutable();
                    this.mcoinProductList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMcoinProductList(ShopMcoinProductOuterClass.ShopMcoinProduct.Builder builderForValue) {
                if (this.mcoinProductListBuilder_ == null) {
                    ensureMcoinProductListIsMutable();
                    this.mcoinProductList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.mcoinProductListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMcoinProductList(int index, ShopMcoinProductOuterClass.ShopMcoinProduct.Builder builderForValue) {
                if (this.mcoinProductListBuilder_ == null) {
                    ensureMcoinProductListIsMutable();
                    this.mcoinProductList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.mcoinProductListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMcoinProductList(Iterable<? extends ShopMcoinProductOuterClass.ShopMcoinProduct> values) {
                if (this.mcoinProductListBuilder_ == null) {
                    ensureMcoinProductListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.mcoinProductList_);
                    onChanged();
                } else {
                    this.mcoinProductListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMcoinProductList() {
                if (this.mcoinProductListBuilder_ == null) {
                    this.mcoinProductList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.mcoinProductListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMcoinProductList(int index) {
                if (this.mcoinProductListBuilder_ == null) {
                    ensureMcoinProductListIsMutable();
                    this.mcoinProductList_.remove(index);
                    onChanged();
                } else {
                    this.mcoinProductListBuilder_.remove(index);
                }
                return this;
            }

            public ShopMcoinProductOuterClass.ShopMcoinProduct.Builder getMcoinProductListBuilder(int index) {
                return getMcoinProductListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder getMcoinProductListOrBuilder(int index) {
                if (this.mcoinProductListBuilder_ == null) {
                    return this.mcoinProductList_.get(index);
                }
                return this.mcoinProductListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public List<? extends ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder> getMcoinProductListOrBuilderList() {
                if (this.mcoinProductListBuilder_ != null) {
                    return this.mcoinProductListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.mcoinProductList_);
            }

            public ShopMcoinProductOuterClass.ShopMcoinProduct.Builder addMcoinProductListBuilder() {
                return getMcoinProductListFieldBuilder().addBuilder(ShopMcoinProductOuterClass.ShopMcoinProduct.getDefaultInstance());
            }

            public ShopMcoinProductOuterClass.ShopMcoinProduct.Builder addMcoinProductListBuilder(int index) {
                return getMcoinProductListFieldBuilder().addBuilder(index, ShopMcoinProductOuterClass.ShopMcoinProduct.getDefaultInstance());
            }

            public List<ShopMcoinProductOuterClass.ShopMcoinProduct.Builder> getMcoinProductListBuilderList() {
                return getMcoinProductListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ShopMcoinProductOuterClass.ShopMcoinProduct, ShopMcoinProductOuterClass.ShopMcoinProduct.Builder, ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder> getMcoinProductListFieldBuilder() {
                if (this.mcoinProductListBuilder_ == null) {
                    this.mcoinProductListBuilder_ = new RepeatedFieldBuilderV3<>(this.mcoinProductList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.mcoinProductList_ = null;
                }
                return this.mcoinProductListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public int getCityId() {
                return this.cityId_;
            }

            public Builder setCityId(int value) {
                this.cityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCityId() {
                this.cityId_ = 0;
                onChanged();
                return this;
            }

            private void ensureConcertProductListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.concertProductList_ = new ArrayList(this.concertProductList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public List<ShopConcertProductOuterClass.ShopConcertProduct> getConcertProductListList() {
                if (this.concertProductListBuilder_ == null) {
                    return Collections.unmodifiableList(this.concertProductList_);
                }
                return this.concertProductListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public int getConcertProductListCount() {
                if (this.concertProductListBuilder_ == null) {
                    return this.concertProductList_.size();
                }
                return this.concertProductListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public ShopConcertProductOuterClass.ShopConcertProduct getConcertProductList(int index) {
                if (this.concertProductListBuilder_ == null) {
                    return this.concertProductList_.get(index);
                }
                return this.concertProductListBuilder_.getMessage(index);
            }

            public Builder setConcertProductList(int index, ShopConcertProductOuterClass.ShopConcertProduct value) {
                if (this.concertProductListBuilder_ != null) {
                    this.concertProductListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureConcertProductListIsMutable();
                    this.concertProductList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setConcertProductList(int index, ShopConcertProductOuterClass.ShopConcertProduct.Builder builderForValue) {
                if (this.concertProductListBuilder_ == null) {
                    ensureConcertProductListIsMutable();
                    this.concertProductList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.concertProductListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addConcertProductList(ShopConcertProductOuterClass.ShopConcertProduct value) {
                if (this.concertProductListBuilder_ != null) {
                    this.concertProductListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureConcertProductListIsMutable();
                    this.concertProductList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addConcertProductList(int index, ShopConcertProductOuterClass.ShopConcertProduct value) {
                if (this.concertProductListBuilder_ != null) {
                    this.concertProductListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureConcertProductListIsMutable();
                    this.concertProductList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addConcertProductList(ShopConcertProductOuterClass.ShopConcertProduct.Builder builderForValue) {
                if (this.concertProductListBuilder_ == null) {
                    ensureConcertProductListIsMutable();
                    this.concertProductList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.concertProductListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addConcertProductList(int index, ShopConcertProductOuterClass.ShopConcertProduct.Builder builderForValue) {
                if (this.concertProductListBuilder_ == null) {
                    ensureConcertProductListIsMutable();
                    this.concertProductList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.concertProductListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllConcertProductList(Iterable<? extends ShopConcertProductOuterClass.ShopConcertProduct> values) {
                if (this.concertProductListBuilder_ == null) {
                    ensureConcertProductListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.concertProductList_);
                    onChanged();
                } else {
                    this.concertProductListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearConcertProductList() {
                if (this.concertProductListBuilder_ == null) {
                    this.concertProductList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.concertProductListBuilder_.clear();
                }
                return this;
            }

            public Builder removeConcertProductList(int index) {
                if (this.concertProductListBuilder_ == null) {
                    ensureConcertProductListIsMutable();
                    this.concertProductList_.remove(index);
                    onChanged();
                } else {
                    this.concertProductListBuilder_.remove(index);
                }
                return this;
            }

            public ShopConcertProductOuterClass.ShopConcertProduct.Builder getConcertProductListBuilder(int index) {
                return getConcertProductListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public ShopConcertProductOuterClass.ShopConcertProductOrBuilder getConcertProductListOrBuilder(int index) {
                if (this.concertProductListBuilder_ == null) {
                    return this.concertProductList_.get(index);
                }
                return this.concertProductListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public List<? extends ShopConcertProductOuterClass.ShopConcertProductOrBuilder> getConcertProductListOrBuilderList() {
                if (this.concertProductListBuilder_ != null) {
                    return this.concertProductListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.concertProductList_);
            }

            public ShopConcertProductOuterClass.ShopConcertProduct.Builder addConcertProductListBuilder() {
                return getConcertProductListFieldBuilder().addBuilder(ShopConcertProductOuterClass.ShopConcertProduct.getDefaultInstance());
            }

            public ShopConcertProductOuterClass.ShopConcertProduct.Builder addConcertProductListBuilder(int index) {
                return getConcertProductListFieldBuilder().addBuilder(index, ShopConcertProductOuterClass.ShopConcertProduct.getDefaultInstance());
            }

            public List<ShopConcertProductOuterClass.ShopConcertProduct.Builder> getConcertProductListBuilderList() {
                return getConcertProductListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ShopConcertProductOuterClass.ShopConcertProduct, ShopConcertProductOuterClass.ShopConcertProduct.Builder, ShopConcertProductOuterClass.ShopConcertProductOrBuilder> getConcertProductListFieldBuilder() {
                if (this.concertProductListBuilder_ == null) {
                    this.concertProductListBuilder_ = new RepeatedFieldBuilderV3<>(this.concertProductList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.concertProductList_ = null;
                }
                return this.concertProductListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public int getNextRefreshTime() {
                return this.nextRefreshTime_;
            }

            public Builder setNextRefreshTime(int value) {
                this.nextRefreshTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextRefreshTime() {
                this.nextRefreshTime_ = 0;
                onChanged();
                return this;
            }

            private void ensureCardProductListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.cardProductList_ = new ArrayList(this.cardProductList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public List<ShopCardProductOuterClass.ShopCardProduct> getCardProductListList() {
                if (this.cardProductListBuilder_ == null) {
                    return Collections.unmodifiableList(this.cardProductList_);
                }
                return this.cardProductListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public int getCardProductListCount() {
                if (this.cardProductListBuilder_ == null) {
                    return this.cardProductList_.size();
                }
                return this.cardProductListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public ShopCardProductOuterClass.ShopCardProduct getCardProductList(int index) {
                if (this.cardProductListBuilder_ == null) {
                    return this.cardProductList_.get(index);
                }
                return this.cardProductListBuilder_.getMessage(index);
            }

            public Builder setCardProductList(int index, ShopCardProductOuterClass.ShopCardProduct value) {
                if (this.cardProductListBuilder_ != null) {
                    this.cardProductListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCardProductListIsMutable();
                    this.cardProductList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setCardProductList(int index, ShopCardProductOuterClass.ShopCardProduct.Builder builderForValue) {
                if (this.cardProductListBuilder_ == null) {
                    ensureCardProductListIsMutable();
                    this.cardProductList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.cardProductListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCardProductList(ShopCardProductOuterClass.ShopCardProduct value) {
                if (this.cardProductListBuilder_ != null) {
                    this.cardProductListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCardProductListIsMutable();
                    this.cardProductList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addCardProductList(int index, ShopCardProductOuterClass.ShopCardProduct value) {
                if (this.cardProductListBuilder_ != null) {
                    this.cardProductListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCardProductListIsMutable();
                    this.cardProductList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addCardProductList(ShopCardProductOuterClass.ShopCardProduct.Builder builderForValue) {
                if (this.cardProductListBuilder_ == null) {
                    ensureCardProductListIsMutable();
                    this.cardProductList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.cardProductListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCardProductList(int index, ShopCardProductOuterClass.ShopCardProduct.Builder builderForValue) {
                if (this.cardProductListBuilder_ == null) {
                    ensureCardProductListIsMutable();
                    this.cardProductList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.cardProductListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCardProductList(Iterable<? extends ShopCardProductOuterClass.ShopCardProduct> values) {
                if (this.cardProductListBuilder_ == null) {
                    ensureCardProductListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.cardProductList_);
                    onChanged();
                } else {
                    this.cardProductListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCardProductList() {
                if (this.cardProductListBuilder_ == null) {
                    this.cardProductList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.cardProductListBuilder_.clear();
                }
                return this;
            }

            public Builder removeCardProductList(int index) {
                if (this.cardProductListBuilder_ == null) {
                    ensureCardProductListIsMutable();
                    this.cardProductList_.remove(index);
                    onChanged();
                } else {
                    this.cardProductListBuilder_.remove(index);
                }
                return this;
            }

            public ShopCardProductOuterClass.ShopCardProduct.Builder getCardProductListBuilder(int index) {
                return getCardProductListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public ShopCardProductOuterClass.ShopCardProductOrBuilder getCardProductListOrBuilder(int index) {
                if (this.cardProductListBuilder_ == null) {
                    return this.cardProductList_.get(index);
                }
                return this.cardProductListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public List<? extends ShopCardProductOuterClass.ShopCardProductOrBuilder> getCardProductListOrBuilderList() {
                if (this.cardProductListBuilder_ != null) {
                    return this.cardProductListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.cardProductList_);
            }

            public ShopCardProductOuterClass.ShopCardProduct.Builder addCardProductListBuilder() {
                return getCardProductListFieldBuilder().addBuilder(ShopCardProductOuterClass.ShopCardProduct.getDefaultInstance());
            }

            public ShopCardProductOuterClass.ShopCardProduct.Builder addCardProductListBuilder(int index) {
                return getCardProductListFieldBuilder().addBuilder(index, ShopCardProductOuterClass.ShopCardProduct.getDefaultInstance());
            }

            public List<ShopCardProductOuterClass.ShopCardProduct.Builder> getCardProductListBuilderList() {
                return getCardProductListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ShopCardProductOuterClass.ShopCardProduct, ShopCardProductOuterClass.ShopCardProduct.Builder, ShopCardProductOuterClass.ShopCardProductOrBuilder> getCardProductListFieldBuilder() {
                if (this.cardProductListBuilder_ == null) {
                    this.cardProductListBuilder_ = new RepeatedFieldBuilderV3<>(this.cardProductList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.cardProductList_ = null;
                }
                return this.cardProductListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public int getCityReputationLevel() {
                return this.cityReputationLevel_;
            }

            public Builder setCityReputationLevel(int value) {
                this.cityReputationLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearCityReputationLevel() {
                this.cityReputationLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
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
                if ((this.bitField0_ & 8) == 0) {
                    this.goodsList_ = new ArrayList(this.goodsList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public List<ShopGoodsOuterClass.ShopGoods> getGoodsListList() {
                if (this.goodsListBuilder_ == null) {
                    return Collections.unmodifiableList(this.goodsList_);
                }
                return this.goodsListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public int getGoodsListCount() {
                if (this.goodsListBuilder_ == null) {
                    return this.goodsList_.size();
                }
                return this.goodsListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
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
                    this.bitField0_ &= -9;
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

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
            public ShopGoodsOuterClass.ShopGoodsOrBuilder getGoodsListOrBuilder(int index) {
                if (this.goodsListBuilder_ == null) {
                    return this.goodsList_.get(index);
                }
                return this.goodsListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ShopOuterClass.ShopOrBuilder
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
                    this.goodsListBuilder_ = new RepeatedFieldBuilderV3<>(this.goodsList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.goodsList_ = null;
                }
                return this.goodsListBuilder_;
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

        public static Shop getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Shop> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Shop> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Shop getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ShopMcoinProductOuterClass.getDescriptor();
        ShopConcertProductOuterClass.getDescriptor();
        ShopCardProductOuterClass.getDescriptor();
        ShopGoodsOuterClass.getDescriptor();
    }
}
