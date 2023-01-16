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
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopGoodsOuterClass.class */
public final class ShopGoodsOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fShopGoods.proto\u001a\u000fItemParam.proto\"Û\u0003\n\tShopGoods\u0012\u001b\n\u0012secondary_sheet_id\u0018ë\u0007 \u0001(\r\u0012\u001e\n\ngoods_item\u0018\u000f \u0001(\u000b2\n.ItemParam\u0012\"\n\u000ecost_item_list\u0018\u0007 \u0003(\u000b2\n.ItemParam\u0012\u0012\n\nbought_num\u0018\u000e \u0001(\r\u0012\u0019\n\u0011pre_goods_id_list\u0018\t \u0003(\r\u0012\u0011\n\tmin_level\u0018\u0005 \u0001(\r\u0012\r\n\u0005mcoin\u0018\u000b \u0001(\r\u0012\r\n\u0005hcoin\u0018\u0006 \u0001(\r\u0012\u0010\n\bend_time\u0018\u0003 \u0001(\r\u0012\u0019\n\u0011next_refresh_time\u0018\n \u0001(\r\u0012\u0010\n\bgoods_id\u0018\r \u0001(\r\u0012\u001c\n\u0013Unk3300_OMKIFIMDGDN\u0018\b \u0001(\r\u0012\u0011\n\tbuy_limit\u0018\b \u0001(\r\u0012\u001c\n\u0013Unk3300_MBGOMHNBHMG\u0018\u0006 \u0001(\r\u0012\r\n\u0005scoin\u0018\u0002 \u0001(\r\u0012\u0011\n\tmax_level\u0018\u0001 \u0001(\r\u0012\u0015\n\fsingle_limit\u0018ê\r \u0001(\r\u0012\u001c\n\u0013Unk3300_NJCPAJBCEPH\u0018ù\u0003 \u0001(\r\u0012\u0012\n\nbegin_time\u0018\f \u0001(\r\u0012\u0014\n\fdisable_type\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ShopGoods_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ShopGoods_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ShopGoods_descriptor, new String[]{"SecondarySheetId", "GoodsItem", "CostItemList", "BoughtNum", "PreGoodsIdList", "MinLevel", "Mcoin", "Hcoin", "EndTime", "NextRefreshTime", "GoodsId", "Unk3300OMKIFIMDGDN", "BuyLimit", "Unk3300MBGOMHNBHMG", "Scoin", "MaxLevel", "SingleLimit", "Unk3300NJCPAJBCEPH", "BeginTime", "DisableType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopGoodsOuterClass$ShopGoodsOrBuilder.class */
    public interface ShopGoodsOrBuilder extends MessageOrBuilder {
        int getSecondarySheetId();

        boolean hasGoodsItem();

        ItemParamOuterClass.ItemParam getGoodsItem();

        ItemParamOuterClass.ItemParamOrBuilder getGoodsItemOrBuilder();

        List<ItemParamOuterClass.ItemParam> getCostItemListList();

        ItemParamOuterClass.ItemParam getCostItemList(int i);

        int getCostItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getCostItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getCostItemListOrBuilder(int i);

        int getBoughtNum();

        List<Integer> getPreGoodsIdListList();

        int getPreGoodsIdListCount();

        int getPreGoodsIdList(int i);

        int getMinLevel();

        int getMcoin();

        int getHcoin();

        int getEndTime();

        int getNextRefreshTime();

        int getGoodsId();

        int getUnk3300OMKIFIMDGDN();

        int getBuyLimit();

        int getUnk3300MBGOMHNBHMG();

        int getScoin();

        int getMaxLevel();

        int getSingleLimit();

        int getUnk3300NJCPAJBCEPH();

        int getBeginTime();

        int getDisableType();
    }

    private ShopGoodsOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopGoodsOuterClass$ShopGoods.class */
    public static final class ShopGoods extends GeneratedMessageV3 implements ShopGoodsOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SECONDARY_SHEET_ID_FIELD_NUMBER = 1003;
        private int secondarySheetId_;
        public static final int GOODS_ITEM_FIELD_NUMBER = 15;
        private ItemParamOuterClass.ItemParam goodsItem_;
        public static final int COST_ITEM_LIST_FIELD_NUMBER = 7;
        private List<ItemParamOuterClass.ItemParam> costItemList_;
        public static final int BOUGHT_NUM_FIELD_NUMBER = 14;
        private int boughtNum_;
        public static final int PRE_GOODS_ID_LIST_FIELD_NUMBER = 9;
        private Internal.IntList preGoodsIdList_;
        private int preGoodsIdListMemoizedSerializedSize;
        public static final int MIN_LEVEL_FIELD_NUMBER = 5;
        private int minLevel_;
        public static final int MCOIN_FIELD_NUMBER = 11;
        private int mcoin_;
        public static final int HCOIN_FIELD_NUMBER = 6;
        private int hcoin_;
        public static final int END_TIME_FIELD_NUMBER = 3;
        private int endTime_;
        public static final int NEXT_REFRESH_TIME_FIELD_NUMBER = 10;
        private int nextRefreshTime_;
        public static final int GOODS_ID_FIELD_NUMBER = 13;
        private int goodsId_;
        public static final int UNK3300_OMKIFIMDGDN_FIELD_NUMBER = 1037;
        private int unk3300OMKIFIMDGDN_;
        public static final int BUY_LIMIT_FIELD_NUMBER = 8;
        private int buyLimit_;
        public static final int UNK3300_MBGOMHNBHMG_FIELD_NUMBER = 777;
        private int unk3300MBGOMHNBHMG_;
        public static final int SCOIN_FIELD_NUMBER = 2;
        private int scoin_;
        public static final int MAX_LEVEL_FIELD_NUMBER = 1;
        private int maxLevel_;
        public static final int SINGLE_LIMIT_FIELD_NUMBER = 1770;
        private int singleLimit_;
        public static final int UNK3300_NJCPAJBCEPH_FIELD_NUMBER = 505;
        private int unk3300NJCPAJBCEPH_;
        public static final int BEGIN_TIME_FIELD_NUMBER = 12;
        private int beginTime_;
        public static final int DISABLE_TYPE_FIELD_NUMBER = 4;
        private int disableType_;
        private byte memoizedIsInitialized;
        private static final ShopGoods DEFAULT_INSTANCE = new ShopGoods();
        private static final Parser<ShopGoods> PARSER = new AbstractParser<ShopGoods>() { // from class: emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoods.1
            @Override // com.google.protobuf.Parser
            public ShopGoods parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopGoods(input, extensionRegistry);
            }
        };

        private ShopGoods(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.preGoodsIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ShopGoods() {
            this.preGoodsIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.costItemList_ = Collections.emptyList();
            this.preGoodsIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ShopGoods();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:110:0x0282 */
        private ShopGoods(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.maxLevel_ = input.readUInt32();
                                break;
                            case 16:
                                this.scoin_ = input.readUInt32();
                                break;
                            case 24:
                                this.endTime_ = input.readUInt32();
                                break;
                            case 32:
                                this.disableType_ = input.readUInt32();
                                break;
                            case 40:
                                this.minLevel_ = input.readUInt32();
                                break;
                            case 48:
                                this.hcoin_ = input.readUInt32();
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.costItemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.costItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 64:
                                this.buyLimit_ = input.readUInt32();
                                break;
                            case 72:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.preGoodsIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.preGoodsIdList_.addInt(input.readUInt32());
                                break;
                            case 74:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.preGoodsIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.preGoodsIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 80:
                                this.nextRefreshTime_ = input.readUInt32();
                                break;
                            case 88:
                                this.mcoin_ = input.readUInt32();
                                break;
                            case 96:
                                this.beginTime_ = input.readUInt32();
                                break;
                            case 104:
                                this.goodsId_ = input.readUInt32();
                                break;
                            case 112:
                                this.boughtNum_ = input.readUInt32();
                                break;
                            case 122:
                                ItemParamOuterClass.ItemParam.Builder subBuilder = this.goodsItem_ != null ? this.goodsItem_.toBuilder() : null;
                                this.goodsItem_ = (ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.goodsItem_);
                                    this.goodsItem_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 4040:
                                this.unk3300NJCPAJBCEPH_ = input.readUInt32();
                                break;
                            case 6216:
                                this.unk3300MBGOMHNBHMG_ = input.readUInt32();
                                break;
                            case 8024:
                                this.secondarySheetId_ = input.readUInt32();
                                break;
                            case PacketOpcodes.TreasureMapHostInfoNotify:
                                this.unk3300OMKIFIMDGDN_ = input.readUInt32();
                                break;
                            case 14160:
                                this.singleLimit_ = input.readUInt32();
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
                    this.costItemList_ = Collections.unmodifiableList(this.costItemList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.preGoodsIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ShopGoodsOuterClass.internal_static_ShopGoods_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopGoodsOuterClass.internal_static_ShopGoods_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopGoods.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getSecondarySheetId() {
            return this.secondarySheetId_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public boolean hasGoodsItem() {
            return this.goodsItem_ != null;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public ItemParamOuterClass.ItemParam getGoodsItem() {
            return this.goodsItem_ == null ? ItemParamOuterClass.ItemParam.getDefaultInstance() : this.goodsItem_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getGoodsItemOrBuilder() {
            return getGoodsItem();
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public List<ItemParamOuterClass.ItemParam> getCostItemListList() {
            return this.costItemList_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getCostItemListOrBuilderList() {
            return this.costItemList_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getCostItemListCount() {
            return this.costItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public ItemParamOuterClass.ItemParam getCostItemList(int index) {
            return this.costItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getCostItemListOrBuilder(int index) {
            return this.costItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getBoughtNum() {
            return this.boughtNum_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public List<Integer> getPreGoodsIdListList() {
            return this.preGoodsIdList_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getPreGoodsIdListCount() {
            return this.preGoodsIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getPreGoodsIdList(int index) {
            return this.preGoodsIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getMinLevel() {
            return this.minLevel_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getMcoin() {
            return this.mcoin_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getHcoin() {
            return this.hcoin_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getNextRefreshTime() {
            return this.nextRefreshTime_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getGoodsId() {
            return this.goodsId_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getUnk3300OMKIFIMDGDN() {
            return this.unk3300OMKIFIMDGDN_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getBuyLimit() {
            return this.buyLimit_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getUnk3300MBGOMHNBHMG() {
            return this.unk3300MBGOMHNBHMG_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getScoin() {
            return this.scoin_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getMaxLevel() {
            return this.maxLevel_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getSingleLimit() {
            return this.singleLimit_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getUnk3300NJCPAJBCEPH() {
            return this.unk3300NJCPAJBCEPH_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
        }

        @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
        public int getDisableType() {
            return this.disableType_;
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
            getSerializedSize();
            if (this.maxLevel_ != 0) {
                output.writeUInt32(1, this.maxLevel_);
            }
            if (this.scoin_ != 0) {
                output.writeUInt32(2, this.scoin_);
            }
            if (this.endTime_ != 0) {
                output.writeUInt32(3, this.endTime_);
            }
            if (this.disableType_ != 0) {
                output.writeUInt32(4, this.disableType_);
            }
            if (this.minLevel_ != 0) {
                output.writeUInt32(5, this.minLevel_);
            }
            if (this.hcoin_ != 0) {
                output.writeUInt32(6, this.hcoin_);
            }
            for (int i = 0; i < this.costItemList_.size(); i++) {
                output.writeMessage(7, this.costItemList_.get(i));
            }
            if (this.buyLimit_ != 0) {
                output.writeUInt32(8, this.buyLimit_);
            }
            if (getPreGoodsIdListList().size() > 0) {
                output.writeUInt32NoTag(74);
                output.writeUInt32NoTag(this.preGoodsIdListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.preGoodsIdList_.size(); i2++) {
                output.writeUInt32NoTag(this.preGoodsIdList_.getInt(i2));
            }
            if (this.nextRefreshTime_ != 0) {
                output.writeUInt32(10, this.nextRefreshTime_);
            }
            if (this.mcoin_ != 0) {
                output.writeUInt32(11, this.mcoin_);
            }
            if (this.beginTime_ != 0) {
                output.writeUInt32(12, this.beginTime_);
            }
            if (this.goodsId_ != 0) {
                output.writeUInt32(13, this.goodsId_);
            }
            if (this.boughtNum_ != 0) {
                output.writeUInt32(14, this.boughtNum_);
            }
            if (this.goodsItem_ != null) {
                output.writeMessage(15, getGoodsItem());
            }
            if (this.unk3300NJCPAJBCEPH_ != 0) {
                output.writeUInt32(505, this.unk3300NJCPAJBCEPH_);
            }
            if (this.unk3300MBGOMHNBHMG_ != 0) {
                output.writeUInt32(UNK3300_MBGOMHNBHMG_FIELD_NUMBER, this.unk3300MBGOMHNBHMG_);
            }
            if (this.secondarySheetId_ != 0) {
                output.writeUInt32(1003, this.secondarySheetId_);
            }
            if (this.unk3300OMKIFIMDGDN_ != 0) {
                output.writeUInt32(UNK3300_OMKIFIMDGDN_FIELD_NUMBER, this.unk3300OMKIFIMDGDN_);
            }
            if (this.singleLimit_ != 0) {
                output.writeUInt32(SINGLE_LIMIT_FIELD_NUMBER, this.singleLimit_);
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
            if (this.maxLevel_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.maxLevel_);
            }
            if (this.scoin_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.scoin_);
            }
            if (this.endTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.endTime_);
            }
            if (this.disableType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.disableType_);
            }
            if (this.minLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.minLevel_);
            }
            if (this.hcoin_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.hcoin_);
            }
            for (int i = 0; i < this.costItemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.costItemList_.get(i));
            }
            if (this.buyLimit_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.buyLimit_);
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.preGoodsIdList_.size(); i2++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.preGoodsIdList_.getInt(i2));
            }
            int size3 = size2 + dataSize;
            if (!getPreGoodsIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.preGoodsIdListMemoizedSerializedSize = dataSize;
            if (this.nextRefreshTime_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(10, this.nextRefreshTime_);
            }
            if (this.mcoin_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(11, this.mcoin_);
            }
            if (this.beginTime_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(12, this.beginTime_);
            }
            if (this.goodsId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(13, this.goodsId_);
            }
            if (this.boughtNum_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(14, this.boughtNum_);
            }
            if (this.goodsItem_ != null) {
                size3 += CodedOutputStream.computeMessageSize(15, getGoodsItem());
            }
            if (this.unk3300NJCPAJBCEPH_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(505, this.unk3300NJCPAJBCEPH_);
            }
            if (this.unk3300MBGOMHNBHMG_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(UNK3300_MBGOMHNBHMG_FIELD_NUMBER, this.unk3300MBGOMHNBHMG_);
            }
            if (this.secondarySheetId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(1003, this.secondarySheetId_);
            }
            if (this.unk3300OMKIFIMDGDN_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(UNK3300_OMKIFIMDGDN_FIELD_NUMBER, this.unk3300OMKIFIMDGDN_);
            }
            if (this.singleLimit_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(SINGLE_LIMIT_FIELD_NUMBER, this.singleLimit_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShopGoods)) {
                return equals(obj);
            }
            ShopGoods other = (ShopGoods) obj;
            if (getSecondarySheetId() == other.getSecondarySheetId() && hasGoodsItem() == other.hasGoodsItem()) {
                return (!hasGoodsItem() || getGoodsItem().equals(other.getGoodsItem())) && getCostItemListList().equals(other.getCostItemListList()) && getBoughtNum() == other.getBoughtNum() && getPreGoodsIdListList().equals(other.getPreGoodsIdListList()) && getMinLevel() == other.getMinLevel() && getMcoin() == other.getMcoin() && getHcoin() == other.getHcoin() && getEndTime() == other.getEndTime() && getNextRefreshTime() == other.getNextRefreshTime() && getGoodsId() == other.getGoodsId() && getUnk3300OMKIFIMDGDN() == other.getUnk3300OMKIFIMDGDN() && getBuyLimit() == other.getBuyLimit() && getUnk3300MBGOMHNBHMG() == other.getUnk3300MBGOMHNBHMG() && getScoin() == other.getScoin() && getMaxLevel() == other.getMaxLevel() && getSingleLimit() == other.getSingleLimit() && getUnk3300NJCPAJBCEPH() == other.getUnk3300NJCPAJBCEPH() && getBeginTime() == other.getBeginTime() && getDisableType() == other.getDisableType() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1003)) + getSecondarySheetId();
            if (hasGoodsItem()) {
                hash = (53 * ((37 * hash) + 15)) + getGoodsItem().hashCode();
            }
            if (getCostItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getCostItemListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 14)) + getBoughtNum();
            if (getPreGoodsIdListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 9)) + getPreGoodsIdListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 5)) + getMinLevel())) + 11)) + getMcoin())) + 6)) + getHcoin())) + 3)) + getEndTime())) + 10)) + getNextRefreshTime())) + 13)) + getGoodsId())) + UNK3300_OMKIFIMDGDN_FIELD_NUMBER)) + getUnk3300OMKIFIMDGDN())) + 8)) + getBuyLimit())) + UNK3300_MBGOMHNBHMG_FIELD_NUMBER)) + getUnk3300MBGOMHNBHMG())) + 2)) + getScoin())) + 1)) + getMaxLevel())) + SINGLE_LIMIT_FIELD_NUMBER)) + getSingleLimit())) + 505)) + getUnk3300NJCPAJBCEPH())) + 12)) + getBeginTime())) + 4)) + getDisableType())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ShopGoods parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShopGoods parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShopGoods parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShopGoods parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShopGoods parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShopGoods parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShopGoods parseFrom(InputStream input) throws IOException {
            return (ShopGoods) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ShopGoods parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopGoods) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ShopGoods parseDelimitedFrom(InputStream input) throws IOException {
            return (ShopGoods) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ShopGoods parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopGoods) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ShopGoods parseFrom(CodedInputStream input) throws IOException {
            return (ShopGoods) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ShopGoods parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopGoods) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ShopGoods prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopGoodsOuterClass$ShopGoods$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ShopGoodsOrBuilder {
            private int bitField0_;
            private int secondarySheetId_;
            private ItemParamOuterClass.ItemParam goodsItem_;
            private SingleFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> goodsItemBuilder_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> costItemListBuilder_;
            private int boughtNum_;
            private int minLevel_;
            private int mcoin_;
            private int hcoin_;
            private int endTime_;
            private int nextRefreshTime_;
            private int goodsId_;
            private int unk3300OMKIFIMDGDN_;
            private int buyLimit_;
            private int unk3300MBGOMHNBHMG_;
            private int scoin_;
            private int maxLevel_;
            private int singleLimit_;
            private int unk3300NJCPAJBCEPH_;
            private int beginTime_;
            private int disableType_;
            private List<ItemParamOuterClass.ItemParam> costItemList_ = Collections.emptyList();
            private Internal.IntList preGoodsIdList_ = ShopGoods.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ShopGoodsOuterClass.internal_static_ShopGoods_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopGoodsOuterClass.internal_static_ShopGoods_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopGoods.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ShopGoods.alwaysUseFieldBuilders) {
                    getCostItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.secondarySheetId_ = 0;
                if (this.goodsItemBuilder_ == null) {
                    this.goodsItem_ = null;
                } else {
                    this.goodsItem_ = null;
                    this.goodsItemBuilder_ = null;
                }
                if (this.costItemListBuilder_ == null) {
                    this.costItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.costItemListBuilder_.clear();
                }
                this.boughtNum_ = 0;
                this.preGoodsIdList_ = ShopGoods.emptyIntList();
                this.bitField0_ &= -3;
                this.minLevel_ = 0;
                this.mcoin_ = 0;
                this.hcoin_ = 0;
                this.endTime_ = 0;
                this.nextRefreshTime_ = 0;
                this.goodsId_ = 0;
                this.unk3300OMKIFIMDGDN_ = 0;
                this.buyLimit_ = 0;
                this.unk3300MBGOMHNBHMG_ = 0;
                this.scoin_ = 0;
                this.maxLevel_ = 0;
                this.singleLimit_ = 0;
                this.unk3300NJCPAJBCEPH_ = 0;
                this.beginTime_ = 0;
                this.disableType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ShopGoodsOuterClass.internal_static_ShopGoods_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ShopGoods getDefaultInstanceForType() {
                return ShopGoods.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ShopGoods build() {
                ShopGoods result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ShopGoods buildPartial() {
                ShopGoods result = new ShopGoods(this);
                int i = this.bitField0_;
                result.secondarySheetId_ = this.secondarySheetId_;
                if (this.goodsItemBuilder_ == null) {
                    result.goodsItem_ = this.goodsItem_;
                } else {
                    result.goodsItem_ = this.goodsItemBuilder_.build();
                }
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
                if ((this.bitField0_ & 2) != 0) {
                    this.preGoodsIdList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.preGoodsIdList_ = this.preGoodsIdList_;
                result.minLevel_ = this.minLevel_;
                result.mcoin_ = this.mcoin_;
                result.hcoin_ = this.hcoin_;
                result.endTime_ = this.endTime_;
                result.nextRefreshTime_ = this.nextRefreshTime_;
                result.goodsId_ = this.goodsId_;
                result.unk3300OMKIFIMDGDN_ = this.unk3300OMKIFIMDGDN_;
                result.buyLimit_ = this.buyLimit_;
                result.unk3300MBGOMHNBHMG_ = this.unk3300MBGOMHNBHMG_;
                result.scoin_ = this.scoin_;
                result.maxLevel_ = this.maxLevel_;
                result.singleLimit_ = this.singleLimit_;
                result.unk3300NJCPAJBCEPH_ = this.unk3300NJCPAJBCEPH_;
                result.beginTime_ = this.beginTime_;
                result.disableType_ = this.disableType_;
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
                if (other instanceof ShopGoods) {
                    return mergeFrom((ShopGoods) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ShopGoods other) {
                if (other == ShopGoods.getDefaultInstance()) {
                    return this;
                }
                if (other.getSecondarySheetId() != 0) {
                    setSecondarySheetId(other.getSecondarySheetId());
                }
                if (other.hasGoodsItem()) {
                    mergeGoodsItem(other.getGoodsItem());
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
                        this.costItemListBuilder_ = ShopGoods.alwaysUseFieldBuilders ? getCostItemListFieldBuilder() : null;
                    } else {
                        this.costItemListBuilder_.addAllMessages(other.costItemList_);
                    }
                }
                if (other.getBoughtNum() != 0) {
                    setBoughtNum(other.getBoughtNum());
                }
                if (!other.preGoodsIdList_.isEmpty()) {
                    if (this.preGoodsIdList_.isEmpty()) {
                        this.preGoodsIdList_ = other.preGoodsIdList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensurePreGoodsIdListIsMutable();
                        this.preGoodsIdList_.addAll(other.preGoodsIdList_);
                    }
                    onChanged();
                }
                if (other.getMinLevel() != 0) {
                    setMinLevel(other.getMinLevel());
                }
                if (other.getMcoin() != 0) {
                    setMcoin(other.getMcoin());
                }
                if (other.getHcoin() != 0) {
                    setHcoin(other.getHcoin());
                }
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
                }
                if (other.getNextRefreshTime() != 0) {
                    setNextRefreshTime(other.getNextRefreshTime());
                }
                if (other.getGoodsId() != 0) {
                    setGoodsId(other.getGoodsId());
                }
                if (other.getUnk3300OMKIFIMDGDN() != 0) {
                    setUnk3300OMKIFIMDGDN(other.getUnk3300OMKIFIMDGDN());
                }
                if (other.getBuyLimit() != 0) {
                    setBuyLimit(other.getBuyLimit());
                }
                if (other.getUnk3300MBGOMHNBHMG() != 0) {
                    setUnk3300MBGOMHNBHMG(other.getUnk3300MBGOMHNBHMG());
                }
                if (other.getScoin() != 0) {
                    setScoin(other.getScoin());
                }
                if (other.getMaxLevel() != 0) {
                    setMaxLevel(other.getMaxLevel());
                }
                if (other.getSingleLimit() != 0) {
                    setSingleLimit(other.getSingleLimit());
                }
                if (other.getUnk3300NJCPAJBCEPH() != 0) {
                    setUnk3300NJCPAJBCEPH(other.getUnk3300NJCPAJBCEPH());
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                if (other.getDisableType() != 0) {
                    setDisableType(other.getDisableType());
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
                ShopGoods parsedMessage = null;
                try {
                    try {
                        parsedMessage = ShopGoods.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ShopGoods) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public int getSecondarySheetId() {
                return this.secondarySheetId_;
            }

            public Builder setSecondarySheetId(int value) {
                this.secondarySheetId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSecondarySheetId() {
                this.secondarySheetId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public boolean hasGoodsItem() {
                return (this.goodsItemBuilder_ == null && this.goodsItem_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
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

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
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

            private void ensureCostItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.costItemList_ = new ArrayList(this.costItemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public List<ItemParamOuterClass.ItemParam> getCostItemListList() {
                if (this.costItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.costItemList_);
                }
                return this.costItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public int getCostItemListCount() {
                if (this.costItemListBuilder_ == null) {
                    return this.costItemList_.size();
                }
                return this.costItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
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

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getCostItemListOrBuilder(int index) {
                if (this.costItemListBuilder_ == null) {
                    return this.costItemList_.get(index);
                }
                return this.costItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
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

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
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

            private void ensurePreGoodsIdListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.preGoodsIdList_ = ShopGoods.mutableCopy(this.preGoodsIdList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public List<Integer> getPreGoodsIdListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.preGoodsIdList_) : this.preGoodsIdList_;
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public int getPreGoodsIdListCount() {
                return this.preGoodsIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public int getPreGoodsIdList(int index) {
                return this.preGoodsIdList_.getInt(index);
            }

            public Builder setPreGoodsIdList(int index, int value) {
                ensurePreGoodsIdListIsMutable();
                this.preGoodsIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addPreGoodsIdList(int value) {
                ensurePreGoodsIdListIsMutable();
                this.preGoodsIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllPreGoodsIdList(Iterable<? extends Integer> values) {
                ensurePreGoodsIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.preGoodsIdList_);
                onChanged();
                return this;
            }

            public Builder clearPreGoodsIdList() {
                this.preGoodsIdList_ = ShopGoods.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public int getMinLevel() {
                return this.minLevel_;
            }

            public Builder setMinLevel(int value) {
                this.minLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearMinLevel() {
                this.minLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public int getMcoin() {
                return this.mcoin_;
            }

            public Builder setMcoin(int value) {
                this.mcoin_ = value;
                onChanged();
                return this;
            }

            public Builder clearMcoin() {
                this.mcoin_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public int getHcoin() {
                return this.hcoin_;
            }

            public Builder setHcoin(int value) {
                this.hcoin_ = value;
                onChanged();
                return this;
            }

            public Builder clearHcoin() {
                this.hcoin_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public int getEndTime() {
                return this.endTime_;
            }

            public Builder setEndTime(int value) {
                this.endTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearEndTime() {
                this.endTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
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

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
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

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public int getUnk3300OMKIFIMDGDN() {
                return this.unk3300OMKIFIMDGDN_;
            }

            public Builder setUnk3300OMKIFIMDGDN(int value) {
                this.unk3300OMKIFIMDGDN_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300OMKIFIMDGDN() {
                this.unk3300OMKIFIMDGDN_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
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

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public int getUnk3300MBGOMHNBHMG() {
                return this.unk3300MBGOMHNBHMG_;
            }

            public Builder setUnk3300MBGOMHNBHMG(int value) {
                this.unk3300MBGOMHNBHMG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300MBGOMHNBHMG() {
                this.unk3300MBGOMHNBHMG_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public int getScoin() {
                return this.scoin_;
            }

            public Builder setScoin(int value) {
                this.scoin_ = value;
                onChanged();
                return this;
            }

            public Builder clearScoin() {
                this.scoin_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public int getMaxLevel() {
                return this.maxLevel_;
            }

            public Builder setMaxLevel(int value) {
                this.maxLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxLevel() {
                this.maxLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public int getSingleLimit() {
                return this.singleLimit_;
            }

            public Builder setSingleLimit(int value) {
                this.singleLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearSingleLimit() {
                this.singleLimit_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public int getUnk3300NJCPAJBCEPH() {
                return this.unk3300NJCPAJBCEPH_;
            }

            public Builder setUnk3300NJCPAJBCEPH(int value) {
                this.unk3300NJCPAJBCEPH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NJCPAJBCEPH() {
                this.unk3300NJCPAJBCEPH_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
            public int getBeginTime() {
                return this.beginTime_;
            }

            public Builder setBeginTime(int value) {
                this.beginTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearBeginTime() {
                this.beginTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopGoodsOuterClass.ShopGoodsOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static ShopGoods getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ShopGoods> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ShopGoods> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ShopGoods getDefaultInstanceForType() {
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
