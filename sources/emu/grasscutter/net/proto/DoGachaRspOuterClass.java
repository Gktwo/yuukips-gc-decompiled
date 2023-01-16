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
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.GachaItemOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DoGachaRspOuterClass.class */
public final class DoGachaRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010DoGachaRsp.proto\u001a\u000fGachaItem.proto\"\u0004\n\nDoGachaRsp\u0012\u001c\n\u0013Unk3300_OHFMHIHJHPJ\u0018\u000e \u0001(\b\u0012\u0018\n\u0010left_gacha_times\u0018\u0003 \u0001(\r\u0012#\n\u000fgacha_item_list\u0018\t \u0003(\u000b2\n.GachaItem\u0012\u001c\n\u0013Unk3300_HBILIAEIHNK\u0018ß\u000e \u0001(\b\u0012\u0012\n\ngacha_type\u0018\n \u0001(\r\u0012\u0018\n\u0010new_gacha_random\u0018\u0006 \u0001(\r\u0012\u0015\n\rwish_progress\u0018\u0001 \u0001(\r\u0012\u0019\n\u0011wish_max_progress\u0018\u0005 \u0001(\r\u0012\u0013\n\u000bgacha_times\u0018\u0004 \u0001(\r\u0012\u0019\n\u0011gacha_times_limit\u0018\u000f \u0001(\r\u0012\u0014\n\fwish_item_id\u0018\f \u0001(\r\u0012\u0018\n\u0010ten_cost_item_id\u0018\r \u0001(\r\u0012\u0015\n\rcost_item_num\u0018\b \u0001(\r\u0012\u0019\n\u0011ten_cost_item_num\u0018\u0002 \u0001(\r\u0012'\n\u001ecur_schedule_daily_gacha_times\u0018\f \u0001(\r\u0012\u0014\n\fcost_item_id\u0018\u0007 \u0001(\r\u0012\u0019\n\u0011gacha_schedule_id\u0018\u000e \u0001(\r\u0012\u001a\n\u0011daily_gacha_times\u0018Ó\u0003 \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u000b \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GachaItemOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DoGachaRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DoGachaRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DoGachaRsp_descriptor, new String[]{"Unk3300OHFMHIHJHPJ", "LeftGachaTimes", "GachaItemList", "Unk3300HBILIAEIHNK", "GachaType", "NewGachaRandom", "WishProgress", "WishMaxProgress", "GachaTimes", "GachaTimesLimit", "WishItemId", "TenCostItemId", "CostItemNum", "TenCostItemNum", "CurScheduleDailyGachaTimes", "CostItemId", "GachaScheduleId", "DailyGachaTimes", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DoGachaRspOuterClass$DoGachaRspOrBuilder.class */
    public interface DoGachaRspOrBuilder extends MessageOrBuilder {
        boolean getUnk3300OHFMHIHJHPJ();

        int getLeftGachaTimes();

        List<GachaItemOuterClass.GachaItem> getGachaItemListList();

        GachaItemOuterClass.GachaItem getGachaItemList(int i);

        int getGachaItemListCount();

        List<? extends GachaItemOuterClass.GachaItemOrBuilder> getGachaItemListOrBuilderList();

        GachaItemOuterClass.GachaItemOrBuilder getGachaItemListOrBuilder(int i);

        boolean getUnk3300HBILIAEIHNK();

        int getGachaType();

        int getNewGachaRandom();

        int getWishProgress();

        int getWishMaxProgress();

        int getGachaTimes();

        int getGachaTimesLimit();

        int getWishItemId();

        int getTenCostItemId();

        int getCostItemNum();

        int getTenCostItemNum();

        int getCurScheduleDailyGachaTimes();

        int getCostItemId();

        int getGachaScheduleId();

        int getDailyGachaTimes();

        int getRetcode();
    }

    private DoGachaRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DoGachaRspOuterClass$DoGachaRsp.class */
    public static final class DoGachaRsp extends GeneratedMessageV3 implements DoGachaRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_OHFMHIHJHPJ_FIELD_NUMBER = 1812;
        private boolean unk3300OHFMHIHJHPJ_;
        public static final int LEFT_GACHA_TIMES_FIELD_NUMBER = 3;
        private int leftGachaTimes_;
        public static final int GACHA_ITEM_LIST_FIELD_NUMBER = 9;
        private List<GachaItemOuterClass.GachaItem> gachaItemList_;
        public static final int UNK3300_HBILIAEIHNK_FIELD_NUMBER = 1887;
        private boolean unk3300HBILIAEIHNK_;
        public static final int GACHA_TYPE_FIELD_NUMBER = 10;
        private int gachaType_;
        public static final int NEW_GACHA_RANDOM_FIELD_NUMBER = 6;
        private int newGachaRandom_;
        public static final int WISH_PROGRESS_FIELD_NUMBER = 1;
        private int wishProgress_;
        public static final int WISH_MAX_PROGRESS_FIELD_NUMBER = 5;
        private int wishMaxProgress_;
        public static final int GACHA_TIMES_FIELD_NUMBER = 4;
        private int gachaTimes_;
        public static final int GACHA_TIMES_LIMIT_FIELD_NUMBER = 15;
        private int gachaTimesLimit_;
        public static final int WISH_ITEM_ID_FIELD_NUMBER = 12;
        private int wishItemId_;
        public static final int TEN_COST_ITEM_ID_FIELD_NUMBER = 13;
        private int tenCostItemId_;
        public static final int COST_ITEM_NUM_FIELD_NUMBER = 8;
        private int costItemNum_;
        public static final int TEN_COST_ITEM_NUM_FIELD_NUMBER = 2;
        private int tenCostItemNum_;
        public static final int CUR_SCHEDULE_DAILY_GACHA_TIMES_FIELD_NUMBER = 1550;
        private int curScheduleDailyGachaTimes_;
        public static final int COST_ITEM_ID_FIELD_NUMBER = 7;
        private int costItemId_;
        public static final int GACHA_SCHEDULE_ID_FIELD_NUMBER = 14;
        private int gachaScheduleId_;
        public static final int DAILY_GACHA_TIMES_FIELD_NUMBER = 467;
        private int dailyGachaTimes_;
        public static final int RETCODE_FIELD_NUMBER = 11;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final DoGachaRsp DEFAULT_INSTANCE = new DoGachaRsp();
        private static final Parser<DoGachaRsp> PARSER = new AbstractParser<DoGachaRsp>() { // from class: emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRsp.1
            @Override // com.google.protobuf.Parser
            public DoGachaRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DoGachaRsp(input, extensionRegistry);
            }
        };

        private DoGachaRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DoGachaRsp() {
            this.memoizedIsInitialized = -1;
            this.gachaItemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DoGachaRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DoGachaRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.wishProgress_ = input.readUInt32();
                                break;
                            case 16:
                                this.tenCostItemNum_ = input.readUInt32();
                                break;
                            case 24:
                                this.leftGachaTimes_ = input.readUInt32();
                                break;
                            case 32:
                                this.gachaTimes_ = input.readUInt32();
                                break;
                            case 40:
                                this.wishMaxProgress_ = input.readUInt32();
                                break;
                            case 48:
                                this.newGachaRandom_ = input.readUInt32();
                                break;
                            case 56:
                                this.costItemId_ = input.readUInt32();
                                break;
                            case 64:
                                this.costItemNum_ = input.readUInt32();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.gachaItemList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.gachaItemList_.add((GachaItemOuterClass.GachaItem) input.readMessage(GachaItemOuterClass.GachaItem.parser(), extensionRegistry));
                                break;
                            case 80:
                                this.gachaType_ = input.readUInt32();
                                break;
                            case 88:
                                this.retcode_ = input.readInt32();
                                break;
                            case 96:
                                this.wishItemId_ = input.readUInt32();
                                break;
                            case 104:
                                this.tenCostItemId_ = input.readUInt32();
                                break;
                            case 112:
                                this.gachaScheduleId_ = input.readUInt32();
                                break;
                            case 120:
                                this.gachaTimesLimit_ = input.readUInt32();
                                break;
                            case 3736:
                                this.dailyGachaTimes_ = input.readUInt32();
                                break;
                            case 12400:
                                this.curScheduleDailyGachaTimes_ = input.readUInt32();
                                break;
                            case 14496:
                                this.unk3300OHFMHIHJHPJ_ = input.readBool();
                                break;
                            case 15096:
                                this.unk3300HBILIAEIHNK_ = input.readBool();
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
                    this.gachaItemList_ = Collections.unmodifiableList(this.gachaItemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DoGachaRspOuterClass.internal_static_DoGachaRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DoGachaRspOuterClass.internal_static_DoGachaRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(DoGachaRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public boolean getUnk3300OHFMHIHJHPJ() {
            return this.unk3300OHFMHIHJHPJ_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getLeftGachaTimes() {
            return this.leftGachaTimes_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public List<GachaItemOuterClass.GachaItem> getGachaItemListList() {
            return this.gachaItemList_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public List<? extends GachaItemOuterClass.GachaItemOrBuilder> getGachaItemListOrBuilderList() {
            return this.gachaItemList_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getGachaItemListCount() {
            return this.gachaItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public GachaItemOuterClass.GachaItem getGachaItemList(int index) {
            return this.gachaItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public GachaItemOuterClass.GachaItemOrBuilder getGachaItemListOrBuilder(int index) {
            return this.gachaItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public boolean getUnk3300HBILIAEIHNK() {
            return this.unk3300HBILIAEIHNK_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getGachaType() {
            return this.gachaType_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getNewGachaRandom() {
            return this.newGachaRandom_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getWishProgress() {
            return this.wishProgress_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getWishMaxProgress() {
            return this.wishMaxProgress_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getGachaTimes() {
            return this.gachaTimes_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getGachaTimesLimit() {
            return this.gachaTimesLimit_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getWishItemId() {
            return this.wishItemId_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getTenCostItemId() {
            return this.tenCostItemId_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getCostItemNum() {
            return this.costItemNum_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getTenCostItemNum() {
            return this.tenCostItemNum_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getCurScheduleDailyGachaTimes() {
            return this.curScheduleDailyGachaTimes_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getCostItemId() {
            return this.costItemId_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getGachaScheduleId() {
            return this.gachaScheduleId_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getDailyGachaTimes() {
            return this.dailyGachaTimes_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
            if (this.wishProgress_ != 0) {
                output.writeUInt32(1, this.wishProgress_);
            }
            if (this.tenCostItemNum_ != 0) {
                output.writeUInt32(2, this.tenCostItemNum_);
            }
            if (this.leftGachaTimes_ != 0) {
                output.writeUInt32(3, this.leftGachaTimes_);
            }
            if (this.gachaTimes_ != 0) {
                output.writeUInt32(4, this.gachaTimes_);
            }
            if (this.wishMaxProgress_ != 0) {
                output.writeUInt32(5, this.wishMaxProgress_);
            }
            if (this.newGachaRandom_ != 0) {
                output.writeUInt32(6, this.newGachaRandom_);
            }
            if (this.costItemId_ != 0) {
                output.writeUInt32(7, this.costItemId_);
            }
            if (this.costItemNum_ != 0) {
                output.writeUInt32(8, this.costItemNum_);
            }
            for (int i = 0; i < this.gachaItemList_.size(); i++) {
                output.writeMessage(9, this.gachaItemList_.get(i));
            }
            if (this.gachaType_ != 0) {
                output.writeUInt32(10, this.gachaType_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(11, this.retcode_);
            }
            if (this.wishItemId_ != 0) {
                output.writeUInt32(12, this.wishItemId_);
            }
            if (this.tenCostItemId_ != 0) {
                output.writeUInt32(13, this.tenCostItemId_);
            }
            if (this.gachaScheduleId_ != 0) {
                output.writeUInt32(14, this.gachaScheduleId_);
            }
            if (this.gachaTimesLimit_ != 0) {
                output.writeUInt32(15, this.gachaTimesLimit_);
            }
            if (this.dailyGachaTimes_ != 0) {
                output.writeUInt32(467, this.dailyGachaTimes_);
            }
            if (this.curScheduleDailyGachaTimes_ != 0) {
                output.writeUInt32(CUR_SCHEDULE_DAILY_GACHA_TIMES_FIELD_NUMBER, this.curScheduleDailyGachaTimes_);
            }
            if (this.unk3300OHFMHIHJHPJ_) {
                output.writeBool(1812, this.unk3300OHFMHIHJHPJ_);
            }
            if (this.unk3300HBILIAEIHNK_) {
                output.writeBool(UNK3300_HBILIAEIHNK_FIELD_NUMBER, this.unk3300HBILIAEIHNK_);
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
            if (this.wishProgress_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.wishProgress_);
            }
            if (this.tenCostItemNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.tenCostItemNum_);
            }
            if (this.leftGachaTimes_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.leftGachaTimes_);
            }
            if (this.gachaTimes_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.gachaTimes_);
            }
            if (this.wishMaxProgress_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.wishMaxProgress_);
            }
            if (this.newGachaRandom_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.newGachaRandom_);
            }
            if (this.costItemId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.costItemId_);
            }
            if (this.costItemNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.costItemNum_);
            }
            for (int i = 0; i < this.gachaItemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.gachaItemList_.get(i));
            }
            if (this.gachaType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.gachaType_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(11, this.retcode_);
            }
            if (this.wishItemId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.wishItemId_);
            }
            if (this.tenCostItemId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.tenCostItemId_);
            }
            if (this.gachaScheduleId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.gachaScheduleId_);
            }
            if (this.gachaTimesLimit_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.gachaTimesLimit_);
            }
            if (this.dailyGachaTimes_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(467, this.dailyGachaTimes_);
            }
            if (this.curScheduleDailyGachaTimes_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(CUR_SCHEDULE_DAILY_GACHA_TIMES_FIELD_NUMBER, this.curScheduleDailyGachaTimes_);
            }
            if (this.unk3300OHFMHIHJHPJ_) {
                size2 += CodedOutputStream.computeBoolSize(1812, this.unk3300OHFMHIHJHPJ_);
            }
            if (this.unk3300HBILIAEIHNK_) {
                size2 += CodedOutputStream.computeBoolSize(UNK3300_HBILIAEIHNK_FIELD_NUMBER, this.unk3300HBILIAEIHNK_);
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
            if (!(obj instanceof DoGachaRsp)) {
                return equals(obj);
            }
            DoGachaRsp other = (DoGachaRsp) obj;
            return getUnk3300OHFMHIHJHPJ() == other.getUnk3300OHFMHIHJHPJ() && getLeftGachaTimes() == other.getLeftGachaTimes() && getGachaItemListList().equals(other.getGachaItemListList()) && getUnk3300HBILIAEIHNK() == other.getUnk3300HBILIAEIHNK() && getGachaType() == other.getGachaType() && getNewGachaRandom() == other.getNewGachaRandom() && getWishProgress() == other.getWishProgress() && getWishMaxProgress() == other.getWishMaxProgress() && getGachaTimes() == other.getGachaTimes() && getGachaTimesLimit() == other.getGachaTimesLimit() && getWishItemId() == other.getWishItemId() && getTenCostItemId() == other.getTenCostItemId() && getCostItemNum() == other.getCostItemNum() && getTenCostItemNum() == other.getTenCostItemNum() && getCurScheduleDailyGachaTimes() == other.getCurScheduleDailyGachaTimes() && getCostItemId() == other.getCostItemId() && getGachaScheduleId() == other.getGachaScheduleId() && getDailyGachaTimes() == other.getDailyGachaTimes() && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1812)) + Internal.hashBoolean(getUnk3300OHFMHIHJHPJ()))) + 3)) + getLeftGachaTimes();
            if (getGachaItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getGachaItemListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + UNK3300_HBILIAEIHNK_FIELD_NUMBER)) + Internal.hashBoolean(getUnk3300HBILIAEIHNK()))) + 10)) + getGachaType())) + 6)) + getNewGachaRandom())) + 1)) + getWishProgress())) + 5)) + getWishMaxProgress())) + 4)) + getGachaTimes())) + 15)) + getGachaTimesLimit())) + 12)) + getWishItemId())) + 13)) + getTenCostItemId())) + 8)) + getCostItemNum())) + 2)) + getTenCostItemNum())) + CUR_SCHEDULE_DAILY_GACHA_TIMES_FIELD_NUMBER)) + getCurScheduleDailyGachaTimes())) + 7)) + getCostItemId())) + 14)) + getGachaScheduleId())) + 467)) + getDailyGachaTimes())) + 11)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DoGachaRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DoGachaRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DoGachaRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DoGachaRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DoGachaRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DoGachaRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DoGachaRsp parseFrom(InputStream input) throws IOException {
            return (DoGachaRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DoGachaRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DoGachaRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DoGachaRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (DoGachaRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DoGachaRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DoGachaRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DoGachaRsp parseFrom(CodedInputStream input) throws IOException {
            return (DoGachaRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DoGachaRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DoGachaRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DoGachaRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DoGachaRspOuterClass$DoGachaRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DoGachaRspOrBuilder {
            private int bitField0_;
            private boolean unk3300OHFMHIHJHPJ_;
            private int leftGachaTimes_;
            private List<GachaItemOuterClass.GachaItem> gachaItemList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<GachaItemOuterClass.GachaItem, GachaItemOuterClass.GachaItem.Builder, GachaItemOuterClass.GachaItemOrBuilder> gachaItemListBuilder_;
            private boolean unk3300HBILIAEIHNK_;
            private int gachaType_;
            private int newGachaRandom_;
            private int wishProgress_;
            private int wishMaxProgress_;
            private int gachaTimes_;
            private int gachaTimesLimit_;
            private int wishItemId_;
            private int tenCostItemId_;
            private int costItemNum_;
            private int tenCostItemNum_;
            private int curScheduleDailyGachaTimes_;
            private int costItemId_;
            private int gachaScheduleId_;
            private int dailyGachaTimes_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DoGachaRspOuterClass.internal_static_DoGachaRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DoGachaRspOuterClass.internal_static_DoGachaRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(DoGachaRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DoGachaRsp.alwaysUseFieldBuilders) {
                    getGachaItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300OHFMHIHJHPJ_ = false;
                this.leftGachaTimes_ = 0;
                if (this.gachaItemListBuilder_ == null) {
                    this.gachaItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.gachaItemListBuilder_.clear();
                }
                this.unk3300HBILIAEIHNK_ = false;
                this.gachaType_ = 0;
                this.newGachaRandom_ = 0;
                this.wishProgress_ = 0;
                this.wishMaxProgress_ = 0;
                this.gachaTimes_ = 0;
                this.gachaTimesLimit_ = 0;
                this.wishItemId_ = 0;
                this.tenCostItemId_ = 0;
                this.costItemNum_ = 0;
                this.tenCostItemNum_ = 0;
                this.curScheduleDailyGachaTimes_ = 0;
                this.costItemId_ = 0;
                this.gachaScheduleId_ = 0;
                this.dailyGachaTimes_ = 0;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DoGachaRspOuterClass.internal_static_DoGachaRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DoGachaRsp getDefaultInstanceForType() {
                return DoGachaRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DoGachaRsp build() {
                DoGachaRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DoGachaRsp buildPartial() {
                DoGachaRsp result = new DoGachaRsp(this);
                int i = this.bitField0_;
                result.unk3300OHFMHIHJHPJ_ = this.unk3300OHFMHIHJHPJ_;
                result.leftGachaTimes_ = this.leftGachaTimes_;
                if (this.gachaItemListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.gachaItemList_ = Collections.unmodifiableList(this.gachaItemList_);
                        this.bitField0_ &= -2;
                    }
                    result.gachaItemList_ = this.gachaItemList_;
                } else {
                    result.gachaItemList_ = this.gachaItemListBuilder_.build();
                }
                result.unk3300HBILIAEIHNK_ = this.unk3300HBILIAEIHNK_;
                result.gachaType_ = this.gachaType_;
                result.newGachaRandom_ = this.newGachaRandom_;
                result.wishProgress_ = this.wishProgress_;
                result.wishMaxProgress_ = this.wishMaxProgress_;
                result.gachaTimes_ = this.gachaTimes_;
                result.gachaTimesLimit_ = this.gachaTimesLimit_;
                result.wishItemId_ = this.wishItemId_;
                result.tenCostItemId_ = this.tenCostItemId_;
                result.costItemNum_ = this.costItemNum_;
                result.tenCostItemNum_ = this.tenCostItemNum_;
                result.curScheduleDailyGachaTimes_ = this.curScheduleDailyGachaTimes_;
                result.costItemId_ = this.costItemId_;
                result.gachaScheduleId_ = this.gachaScheduleId_;
                result.dailyGachaTimes_ = this.dailyGachaTimes_;
                result.retcode_ = this.retcode_;
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
                if (other instanceof DoGachaRsp) {
                    return mergeFrom((DoGachaRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DoGachaRsp other) {
                if (other == DoGachaRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300OHFMHIHJHPJ()) {
                    setUnk3300OHFMHIHJHPJ(other.getUnk3300OHFMHIHJHPJ());
                }
                if (other.getLeftGachaTimes() != 0) {
                    setLeftGachaTimes(other.getLeftGachaTimes());
                }
                if (this.gachaItemListBuilder_ == null) {
                    if (!other.gachaItemList_.isEmpty()) {
                        if (this.gachaItemList_.isEmpty()) {
                            this.gachaItemList_ = other.gachaItemList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureGachaItemListIsMutable();
                            this.gachaItemList_.addAll(other.gachaItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.gachaItemList_.isEmpty()) {
                    if (this.gachaItemListBuilder_.isEmpty()) {
                        this.gachaItemListBuilder_.dispose();
                        this.gachaItemListBuilder_ = null;
                        this.gachaItemList_ = other.gachaItemList_;
                        this.bitField0_ &= -2;
                        this.gachaItemListBuilder_ = DoGachaRsp.alwaysUseFieldBuilders ? getGachaItemListFieldBuilder() : null;
                    } else {
                        this.gachaItemListBuilder_.addAllMessages(other.gachaItemList_);
                    }
                }
                if (other.getUnk3300HBILIAEIHNK()) {
                    setUnk3300HBILIAEIHNK(other.getUnk3300HBILIAEIHNK());
                }
                if (other.getGachaType() != 0) {
                    setGachaType(other.getGachaType());
                }
                if (other.getNewGachaRandom() != 0) {
                    setNewGachaRandom(other.getNewGachaRandom());
                }
                if (other.getWishProgress() != 0) {
                    setWishProgress(other.getWishProgress());
                }
                if (other.getWishMaxProgress() != 0) {
                    setWishMaxProgress(other.getWishMaxProgress());
                }
                if (other.getGachaTimes() != 0) {
                    setGachaTimes(other.getGachaTimes());
                }
                if (other.getGachaTimesLimit() != 0) {
                    setGachaTimesLimit(other.getGachaTimesLimit());
                }
                if (other.getWishItemId() != 0) {
                    setWishItemId(other.getWishItemId());
                }
                if (other.getTenCostItemId() != 0) {
                    setTenCostItemId(other.getTenCostItemId());
                }
                if (other.getCostItemNum() != 0) {
                    setCostItemNum(other.getCostItemNum());
                }
                if (other.getTenCostItemNum() != 0) {
                    setTenCostItemNum(other.getTenCostItemNum());
                }
                if (other.getCurScheduleDailyGachaTimes() != 0) {
                    setCurScheduleDailyGachaTimes(other.getCurScheduleDailyGachaTimes());
                }
                if (other.getCostItemId() != 0) {
                    setCostItemId(other.getCostItemId());
                }
                if (other.getGachaScheduleId() != 0) {
                    setGachaScheduleId(other.getGachaScheduleId());
                }
                if (other.getDailyGachaTimes() != 0) {
                    setDailyGachaTimes(other.getDailyGachaTimes());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                DoGachaRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = DoGachaRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DoGachaRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public boolean getUnk3300OHFMHIHJHPJ() {
                return this.unk3300OHFMHIHJHPJ_;
            }

            public Builder setUnk3300OHFMHIHJHPJ(boolean value) {
                this.unk3300OHFMHIHJHPJ_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300OHFMHIHJHPJ() {
                this.unk3300OHFMHIHJHPJ_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public int getLeftGachaTimes() {
                return this.leftGachaTimes_;
            }

            public Builder setLeftGachaTimes(int value) {
                this.leftGachaTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearLeftGachaTimes() {
                this.leftGachaTimes_ = 0;
                onChanged();
                return this;
            }

            private void ensureGachaItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.gachaItemList_ = new ArrayList(this.gachaItemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public List<GachaItemOuterClass.GachaItem> getGachaItemListList() {
                if (this.gachaItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.gachaItemList_);
                }
                return this.gachaItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public int getGachaItemListCount() {
                if (this.gachaItemListBuilder_ == null) {
                    return this.gachaItemList_.size();
                }
                return this.gachaItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public GachaItemOuterClass.GachaItem getGachaItemList(int index) {
                if (this.gachaItemListBuilder_ == null) {
                    return this.gachaItemList_.get(index);
                }
                return this.gachaItemListBuilder_.getMessage(index);
            }

            public Builder setGachaItemList(int index, GachaItemOuterClass.GachaItem value) {
                if (this.gachaItemListBuilder_ != null) {
                    this.gachaItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGachaItemListIsMutable();
                    this.gachaItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setGachaItemList(int index, GachaItemOuterClass.GachaItem.Builder builderForValue) {
                if (this.gachaItemListBuilder_ == null) {
                    ensureGachaItemListIsMutable();
                    this.gachaItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.gachaItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addGachaItemList(GachaItemOuterClass.GachaItem value) {
                if (this.gachaItemListBuilder_ != null) {
                    this.gachaItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGachaItemListIsMutable();
                    this.gachaItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addGachaItemList(int index, GachaItemOuterClass.GachaItem value) {
                if (this.gachaItemListBuilder_ != null) {
                    this.gachaItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGachaItemListIsMutable();
                    this.gachaItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addGachaItemList(GachaItemOuterClass.GachaItem.Builder builderForValue) {
                if (this.gachaItemListBuilder_ == null) {
                    ensureGachaItemListIsMutable();
                    this.gachaItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.gachaItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addGachaItemList(int index, GachaItemOuterClass.GachaItem.Builder builderForValue) {
                if (this.gachaItemListBuilder_ == null) {
                    ensureGachaItemListIsMutable();
                    this.gachaItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.gachaItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllGachaItemList(Iterable<? extends GachaItemOuterClass.GachaItem> values) {
                if (this.gachaItemListBuilder_ == null) {
                    ensureGachaItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.gachaItemList_);
                    onChanged();
                } else {
                    this.gachaItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearGachaItemList() {
                if (this.gachaItemListBuilder_ == null) {
                    this.gachaItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.gachaItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeGachaItemList(int index) {
                if (this.gachaItemListBuilder_ == null) {
                    ensureGachaItemListIsMutable();
                    this.gachaItemList_.remove(index);
                    onChanged();
                } else {
                    this.gachaItemListBuilder_.remove(index);
                }
                return this;
            }

            public GachaItemOuterClass.GachaItem.Builder getGachaItemListBuilder(int index) {
                return getGachaItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public GachaItemOuterClass.GachaItemOrBuilder getGachaItemListOrBuilder(int index) {
                if (this.gachaItemListBuilder_ == null) {
                    return this.gachaItemList_.get(index);
                }
                return this.gachaItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public List<? extends GachaItemOuterClass.GachaItemOrBuilder> getGachaItemListOrBuilderList() {
                if (this.gachaItemListBuilder_ != null) {
                    return this.gachaItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.gachaItemList_);
            }

            public GachaItemOuterClass.GachaItem.Builder addGachaItemListBuilder() {
                return getGachaItemListFieldBuilder().addBuilder(GachaItemOuterClass.GachaItem.getDefaultInstance());
            }

            public GachaItemOuterClass.GachaItem.Builder addGachaItemListBuilder(int index) {
                return getGachaItemListFieldBuilder().addBuilder(index, GachaItemOuterClass.GachaItem.getDefaultInstance());
            }

            public List<GachaItemOuterClass.GachaItem.Builder> getGachaItemListBuilderList() {
                return getGachaItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<GachaItemOuterClass.GachaItem, GachaItemOuterClass.GachaItem.Builder, GachaItemOuterClass.GachaItemOrBuilder> getGachaItemListFieldBuilder() {
                if (this.gachaItemListBuilder_ == null) {
                    this.gachaItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.gachaItemList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.gachaItemList_ = null;
                }
                return this.gachaItemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public boolean getUnk3300HBILIAEIHNK() {
                return this.unk3300HBILIAEIHNK_;
            }

            public Builder setUnk3300HBILIAEIHNK(boolean value) {
                this.unk3300HBILIAEIHNK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300HBILIAEIHNK() {
                this.unk3300HBILIAEIHNK_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public int getGachaType() {
                return this.gachaType_;
            }

            public Builder setGachaType(int value) {
                this.gachaType_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaType() {
                this.gachaType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public int getNewGachaRandom() {
                return this.newGachaRandom_;
            }

            public Builder setNewGachaRandom(int value) {
                this.newGachaRandom_ = value;
                onChanged();
                return this;
            }

            public Builder clearNewGachaRandom() {
                this.newGachaRandom_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public int getWishProgress() {
                return this.wishProgress_;
            }

            public Builder setWishProgress(int value) {
                this.wishProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearWishProgress() {
                this.wishProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public int getWishMaxProgress() {
                return this.wishMaxProgress_;
            }

            public Builder setWishMaxProgress(int value) {
                this.wishMaxProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearWishMaxProgress() {
                this.wishMaxProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public int getGachaTimes() {
                return this.gachaTimes_;
            }

            public Builder setGachaTimes(int value) {
                this.gachaTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaTimes() {
                this.gachaTimes_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public int getGachaTimesLimit() {
                return this.gachaTimesLimit_;
            }

            public Builder setGachaTimesLimit(int value) {
                this.gachaTimesLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaTimesLimit() {
                this.gachaTimesLimit_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public int getWishItemId() {
                return this.wishItemId_;
            }

            public Builder setWishItemId(int value) {
                this.wishItemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearWishItemId() {
                this.wishItemId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public int getTenCostItemId() {
                return this.tenCostItemId_;
            }

            public Builder setTenCostItemId(int value) {
                this.tenCostItemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTenCostItemId() {
                this.tenCostItemId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public int getCostItemNum() {
                return this.costItemNum_;
            }

            public Builder setCostItemNum(int value) {
                this.costItemNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearCostItemNum() {
                this.costItemNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public int getTenCostItemNum() {
                return this.tenCostItemNum_;
            }

            public Builder setTenCostItemNum(int value) {
                this.tenCostItemNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearTenCostItemNum() {
                this.tenCostItemNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public int getCurScheduleDailyGachaTimes() {
                return this.curScheduleDailyGachaTimes_;
            }

            public Builder setCurScheduleDailyGachaTimes(int value) {
                this.curScheduleDailyGachaTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurScheduleDailyGachaTimes() {
                this.curScheduleDailyGachaTimes_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public int getCostItemId() {
                return this.costItemId_;
            }

            public Builder setCostItemId(int value) {
                this.costItemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCostItemId() {
                this.costItemId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public int getGachaScheduleId() {
                return this.gachaScheduleId_;
            }

            public Builder setGachaScheduleId(int value) {
                this.gachaScheduleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaScheduleId() {
                this.gachaScheduleId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
            public int getDailyGachaTimes() {
                return this.dailyGachaTimes_;
            }

            public Builder setDailyGachaTimes(int value) {
                this.dailyGachaTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearDailyGachaTimes() {
                this.dailyGachaTimes_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaRspOuterClass.DoGachaRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static DoGachaRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DoGachaRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DoGachaRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DoGachaRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GachaItemOuterClass.getDescriptor();
    }
}
