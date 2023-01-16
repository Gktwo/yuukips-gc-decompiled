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
import emu.grasscutter.net.proto.BattlePassCycleOuterClass;
import emu.grasscutter.net.proto.BattlePassProductOuterClass;
import emu.grasscutter.net.proto.BattlePassRewardTagOuterClass;
import emu.grasscutter.net.proto.BattlePassUnlockStatusOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassScheduleOuterClass.class */
public final class BattlePassScheduleOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018BattlePassSchedule.proto\u001a\u0015BattlePassCycle.proto\u001a\u0017BattlePassProduct.proto\u001a\u0019BattlePassRewardTag.proto\u001a\u001cBattlePassUnlockStatus.proto\"\u0003\n\u0012BattlePassSchedule\u0012\u0013\n\u000bschedule_id\u0018\u0005 \u0001(\r\u0012\r\n\u0005point\u0018\u0002 \u0001(\r\u0012\r\n\u0005level\u0018\u0007 \u0001(\r\u0012\"\n\u001ais_extra_paid_reward_taken\u0018\b \u0001(\b\u0012\u0018\n\u0010cur_cycle_points\u0018\u000e \u0001(\r\u0012\u0011\n\tis_viewed\u0018\f \u0001(\b\u0012\u001b\n\u0013paid_platform_flags\u0018\u0004 \u0001(\r\u0012#\n\tcur_cycle\u0018\u000b \u0001(\u000b2\u0010.BattlePassCycle\u0012\u0012\n\nbegin_time\u0018\u0001 \u0001(\r\u0012.\n\runlock_status\u0018\u000f \u0001(\u000e2\u0017.BattlePassUnlockStatus\u0012(\n\fproduct_info\u0018\n \u0001(\u000b2\u0012.BattlePassProduct\u0012\u0010\n\bend_time\u0018\r \u0001(\r\u0012/\n\u0011reward_taken_list\u0018\u0003 \u0003(\u000b2\u0014.BattlePassRewardTagB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BattlePassCycleOuterClass.getDescriptor(), BattlePassProductOuterClass.getDescriptor(), BattlePassRewardTagOuterClass.getDescriptor(), BattlePassUnlockStatusOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BattlePassSchedule_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BattlePassSchedule_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BattlePassSchedule_descriptor, new String[]{"ScheduleId", "Point", "Level", "IsExtraPaidRewardTaken", "CurCyclePoints", "IsViewed", "PaidPlatformFlags", "CurCycle", "BeginTime", "UnlockStatus", "ProductInfo", "EndTime", "RewardTakenList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassScheduleOuterClass$BattlePassScheduleOrBuilder.class */
    public interface BattlePassScheduleOrBuilder extends MessageOrBuilder {
        int getScheduleId();

        int getPoint();

        int getLevel();

        boolean getIsExtraPaidRewardTaken();

        int getCurCyclePoints();

        boolean getIsViewed();

        int getPaidPlatformFlags();

        boolean hasCurCycle();

        BattlePassCycleOuterClass.BattlePassCycle getCurCycle();

        BattlePassCycleOuterClass.BattlePassCycleOrBuilder getCurCycleOrBuilder();

        int getBeginTime();

        int getUnlockStatusValue();

        BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus getUnlockStatus();

        boolean hasProductInfo();

        BattlePassProductOuterClass.BattlePassProduct getProductInfo();

        BattlePassProductOuterClass.BattlePassProductOrBuilder getProductInfoOrBuilder();

        int getEndTime();

        List<BattlePassRewardTagOuterClass.BattlePassRewardTag> getRewardTakenListList();

        BattlePassRewardTagOuterClass.BattlePassRewardTag getRewardTakenList(int i);

        int getRewardTakenListCount();

        List<? extends BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder> getRewardTakenListOrBuilderList();

        BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder getRewardTakenListOrBuilder(int i);
    }

    private BattlePassScheduleOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassScheduleOuterClass$BattlePassSchedule.class */
    public static final class BattlePassSchedule extends GeneratedMessageV3 implements BattlePassScheduleOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SCHEDULE_ID_FIELD_NUMBER = 5;
        private int scheduleId_;
        public static final int POINT_FIELD_NUMBER = 2;
        private int point_;
        public static final int LEVEL_FIELD_NUMBER = 7;
        private int level_;
        public static final int IS_EXTRA_PAID_REWARD_TAKEN_FIELD_NUMBER = 8;
        private boolean isExtraPaidRewardTaken_;
        public static final int CUR_CYCLE_POINTS_FIELD_NUMBER = 14;
        private int curCyclePoints_;
        public static final int IS_VIEWED_FIELD_NUMBER = 12;
        private boolean isViewed_;
        public static final int PAID_PLATFORM_FLAGS_FIELD_NUMBER = 4;
        private int paidPlatformFlags_;
        public static final int CUR_CYCLE_FIELD_NUMBER = 11;
        private BattlePassCycleOuterClass.BattlePassCycle curCycle_;
        public static final int BEGIN_TIME_FIELD_NUMBER = 1;
        private int beginTime_;
        public static final int UNLOCK_STATUS_FIELD_NUMBER = 15;
        private int unlockStatus_;
        public static final int PRODUCT_INFO_FIELD_NUMBER = 10;
        private BattlePassProductOuterClass.BattlePassProduct productInfo_;
        public static final int END_TIME_FIELD_NUMBER = 13;
        private int endTime_;
        public static final int REWARD_TAKEN_LIST_FIELD_NUMBER = 3;
        private List<BattlePassRewardTagOuterClass.BattlePassRewardTag> rewardTakenList_;
        private byte memoizedIsInitialized;
        private static final BattlePassSchedule DEFAULT_INSTANCE = new BattlePassSchedule();
        private static final Parser<BattlePassSchedule> PARSER = new AbstractParser<BattlePassSchedule>() { // from class: emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassSchedule.1
            @Override // com.google.protobuf.Parser
            public BattlePassSchedule parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattlePassSchedule(input, extensionRegistry);
            }
        };

        private BattlePassSchedule(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BattlePassSchedule() {
            this.memoizedIsInitialized = -1;
            this.unlockStatus_ = 0;
            this.rewardTakenList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BattlePassSchedule();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BattlePassSchedule(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.beginTime_ = input.readUInt32();
                                break;
                            case 16:
                                this.point_ = input.readUInt32();
                                break;
                            case 26:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.rewardTakenList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.rewardTakenList_.add((BattlePassRewardTagOuterClass.BattlePassRewardTag) input.readMessage(BattlePassRewardTagOuterClass.BattlePassRewardTag.parser(), extensionRegistry));
                                break;
                            case 32:
                                this.paidPlatformFlags_ = input.readUInt32();
                                break;
                            case 40:
                                this.scheduleId_ = input.readUInt32();
                                break;
                            case 56:
                                this.level_ = input.readUInt32();
                                break;
                            case 64:
                                this.isExtraPaidRewardTaken_ = input.readBool();
                                break;
                            case 82:
                                BattlePassProductOuterClass.BattlePassProduct.Builder subBuilder = this.productInfo_ != null ? this.productInfo_.toBuilder() : null;
                                this.productInfo_ = (BattlePassProductOuterClass.BattlePassProduct) input.readMessage(BattlePassProductOuterClass.BattlePassProduct.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.productInfo_);
                                    this.productInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 90:
                                BattlePassCycleOuterClass.BattlePassCycle.Builder subBuilder2 = this.curCycle_ != null ? this.curCycle_.toBuilder() : null;
                                this.curCycle_ = (BattlePassCycleOuterClass.BattlePassCycle) input.readMessage(BattlePassCycleOuterClass.BattlePassCycle.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.curCycle_);
                                    this.curCycle_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 96:
                                this.isViewed_ = input.readBool();
                                break;
                            case 104:
                                this.endTime_ = input.readUInt32();
                                break;
                            case 112:
                                this.curCyclePoints_ = input.readUInt32();
                                break;
                            case 120:
                                this.unlockStatus_ = input.readEnum();
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
                    this.rewardTakenList_ = Collections.unmodifiableList(this.rewardTakenList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BattlePassScheduleOuterClass.internal_static_BattlePassSchedule_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattlePassScheduleOuterClass.internal_static_BattlePassSchedule_fieldAccessorTable.ensureFieldAccessorsInitialized(BattlePassSchedule.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public int getScheduleId() {
            return this.scheduleId_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public int getPoint() {
            return this.point_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public boolean getIsExtraPaidRewardTaken() {
            return this.isExtraPaidRewardTaken_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public int getCurCyclePoints() {
            return this.curCyclePoints_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public boolean getIsViewed() {
            return this.isViewed_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public int getPaidPlatformFlags() {
            return this.paidPlatformFlags_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public boolean hasCurCycle() {
            return this.curCycle_ != null;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public BattlePassCycleOuterClass.BattlePassCycle getCurCycle() {
            return this.curCycle_ == null ? BattlePassCycleOuterClass.BattlePassCycle.getDefaultInstance() : this.curCycle_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public BattlePassCycleOuterClass.BattlePassCycleOrBuilder getCurCycleOrBuilder() {
            return getCurCycle();
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public int getUnlockStatusValue() {
            return this.unlockStatus_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus getUnlockStatus() {
            BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus result = BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.valueOf(this.unlockStatus_);
            return result == null ? BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public boolean hasProductInfo() {
            return this.productInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public BattlePassProductOuterClass.BattlePassProduct getProductInfo() {
            return this.productInfo_ == null ? BattlePassProductOuterClass.BattlePassProduct.getDefaultInstance() : this.productInfo_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public BattlePassProductOuterClass.BattlePassProductOrBuilder getProductInfoOrBuilder() {
            return getProductInfo();
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public List<BattlePassRewardTagOuterClass.BattlePassRewardTag> getRewardTakenListList() {
            return this.rewardTakenList_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public List<? extends BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder> getRewardTakenListOrBuilderList() {
            return this.rewardTakenList_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public int getRewardTakenListCount() {
            return this.rewardTakenList_.size();
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public BattlePassRewardTagOuterClass.BattlePassRewardTag getRewardTakenList(int index) {
            return this.rewardTakenList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
        public BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder getRewardTakenListOrBuilder(int index) {
            return this.rewardTakenList_.get(index);
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
            if (this.beginTime_ != 0) {
                output.writeUInt32(1, this.beginTime_);
            }
            if (this.point_ != 0) {
                output.writeUInt32(2, this.point_);
            }
            for (int i = 0; i < this.rewardTakenList_.size(); i++) {
                output.writeMessage(3, this.rewardTakenList_.get(i));
            }
            if (this.paidPlatformFlags_ != 0) {
                output.writeUInt32(4, this.paidPlatformFlags_);
            }
            if (this.scheduleId_ != 0) {
                output.writeUInt32(5, this.scheduleId_);
            }
            if (this.level_ != 0) {
                output.writeUInt32(7, this.level_);
            }
            if (this.isExtraPaidRewardTaken_) {
                output.writeBool(8, this.isExtraPaidRewardTaken_);
            }
            if (this.productInfo_ != null) {
                output.writeMessage(10, getProductInfo());
            }
            if (this.curCycle_ != null) {
                output.writeMessage(11, getCurCycle());
            }
            if (this.isViewed_) {
                output.writeBool(12, this.isViewed_);
            }
            if (this.endTime_ != 0) {
                output.writeUInt32(13, this.endTime_);
            }
            if (this.curCyclePoints_ != 0) {
                output.writeUInt32(14, this.curCyclePoints_);
            }
            if (this.unlockStatus_ != BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.BATTLE_PASS_UNLOCK_STATUS_INVALID.getNumber()) {
                output.writeEnum(15, this.unlockStatus_);
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
            if (this.beginTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.beginTime_);
            }
            if (this.point_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.point_);
            }
            for (int i = 0; i < this.rewardTakenList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.rewardTakenList_.get(i));
            }
            if (this.paidPlatformFlags_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.paidPlatformFlags_);
            }
            if (this.scheduleId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.scheduleId_);
            }
            if (this.level_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.level_);
            }
            if (this.isExtraPaidRewardTaken_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isExtraPaidRewardTaken_);
            }
            if (this.productInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(10, getProductInfo());
            }
            if (this.curCycle_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getCurCycle());
            }
            if (this.isViewed_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isViewed_);
            }
            if (this.endTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.endTime_);
            }
            if (this.curCyclePoints_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.curCyclePoints_);
            }
            if (this.unlockStatus_ != BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.BATTLE_PASS_UNLOCK_STATUS_INVALID.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(15, this.unlockStatus_);
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
            if (!(obj instanceof BattlePassSchedule)) {
                return equals(obj);
            }
            BattlePassSchedule other = (BattlePassSchedule) obj;
            if (getScheduleId() != other.getScheduleId() || getPoint() != other.getPoint() || getLevel() != other.getLevel() || getIsExtraPaidRewardTaken() != other.getIsExtraPaidRewardTaken() || getCurCyclePoints() != other.getCurCyclePoints() || getIsViewed() != other.getIsViewed() || getPaidPlatformFlags() != other.getPaidPlatformFlags() || hasCurCycle() != other.hasCurCycle()) {
                return false;
            }
            if ((!hasCurCycle() || getCurCycle().equals(other.getCurCycle())) && getBeginTime() == other.getBeginTime() && this.unlockStatus_ == other.unlockStatus_ && hasProductInfo() == other.hasProductInfo()) {
                return (!hasProductInfo() || getProductInfo().equals(other.getProductInfo())) && getEndTime() == other.getEndTime() && getRewardTakenListList().equals(other.getRewardTakenListList()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getScheduleId())) + 2)) + getPoint())) + 7)) + getLevel())) + 8)) + Internal.hashBoolean(getIsExtraPaidRewardTaken()))) + 14)) + getCurCyclePoints())) + 12)) + Internal.hashBoolean(getIsViewed()))) + 4)) + getPaidPlatformFlags();
            if (hasCurCycle()) {
                hash = (53 * ((37 * hash) + 11)) + getCurCycle().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 1)) + getBeginTime())) + 15)) + this.unlockStatus_;
            if (hasProductInfo()) {
                hash2 = (53 * ((37 * hash2) + 10)) + getProductInfo().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 13)) + getEndTime();
            if (getRewardTakenListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 3)) + getRewardTakenListList().hashCode();
            }
            int hash4 = (29 * hash3) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static BattlePassSchedule parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassSchedule parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassSchedule parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassSchedule parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassSchedule parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassSchedule parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassSchedule parseFrom(InputStream input) throws IOException {
            return (BattlePassSchedule) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BattlePassSchedule parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassSchedule) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BattlePassSchedule parseDelimitedFrom(InputStream input) throws IOException {
            return (BattlePassSchedule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BattlePassSchedule parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassSchedule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BattlePassSchedule parseFrom(CodedInputStream input) throws IOException {
            return (BattlePassSchedule) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BattlePassSchedule parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassSchedule) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BattlePassSchedule prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassScheduleOuterClass$BattlePassSchedule$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BattlePassScheduleOrBuilder {
            private int bitField0_;
            private int scheduleId_;
            private int point_;
            private int level_;
            private boolean isExtraPaidRewardTaken_;
            private int curCyclePoints_;
            private boolean isViewed_;
            private int paidPlatformFlags_;
            private BattlePassCycleOuterClass.BattlePassCycle curCycle_;
            private SingleFieldBuilderV3<BattlePassCycleOuterClass.BattlePassCycle, BattlePassCycleOuterClass.BattlePassCycle.Builder, BattlePassCycleOuterClass.BattlePassCycleOrBuilder> curCycleBuilder_;
            private int beginTime_;
            private BattlePassProductOuterClass.BattlePassProduct productInfo_;
            private SingleFieldBuilderV3<BattlePassProductOuterClass.BattlePassProduct, BattlePassProductOuterClass.BattlePassProduct.Builder, BattlePassProductOuterClass.BattlePassProductOrBuilder> productInfoBuilder_;
            private int endTime_;
            private RepeatedFieldBuilderV3<BattlePassRewardTagOuterClass.BattlePassRewardTag, BattlePassRewardTagOuterClass.BattlePassRewardTag.Builder, BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder> rewardTakenListBuilder_;
            private int unlockStatus_ = 0;
            private List<BattlePassRewardTagOuterClass.BattlePassRewardTag> rewardTakenList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return BattlePassScheduleOuterClass.internal_static_BattlePassSchedule_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattlePassScheduleOuterClass.internal_static_BattlePassSchedule_fieldAccessorTable.ensureFieldAccessorsInitialized(BattlePassSchedule.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BattlePassSchedule.alwaysUseFieldBuilders) {
                    getRewardTakenListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.scheduleId_ = 0;
                this.point_ = 0;
                this.level_ = 0;
                this.isExtraPaidRewardTaken_ = false;
                this.curCyclePoints_ = 0;
                this.isViewed_ = false;
                this.paidPlatformFlags_ = 0;
                if (this.curCycleBuilder_ == null) {
                    this.curCycle_ = null;
                } else {
                    this.curCycle_ = null;
                    this.curCycleBuilder_ = null;
                }
                this.beginTime_ = 0;
                this.unlockStatus_ = 0;
                if (this.productInfoBuilder_ == null) {
                    this.productInfo_ = null;
                } else {
                    this.productInfo_ = null;
                    this.productInfoBuilder_ = null;
                }
                this.endTime_ = 0;
                if (this.rewardTakenListBuilder_ == null) {
                    this.rewardTakenList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.rewardTakenListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BattlePassScheduleOuterClass.internal_static_BattlePassSchedule_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BattlePassSchedule getDefaultInstanceForType() {
                return BattlePassSchedule.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BattlePassSchedule build() {
                BattlePassSchedule result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BattlePassSchedule buildPartial() {
                BattlePassSchedule result = new BattlePassSchedule(this);
                int i = this.bitField0_;
                result.scheduleId_ = this.scheduleId_;
                result.point_ = this.point_;
                result.level_ = this.level_;
                result.isExtraPaidRewardTaken_ = this.isExtraPaidRewardTaken_;
                result.curCyclePoints_ = this.curCyclePoints_;
                result.isViewed_ = this.isViewed_;
                result.paidPlatformFlags_ = this.paidPlatformFlags_;
                if (this.curCycleBuilder_ == null) {
                    result.curCycle_ = this.curCycle_;
                } else {
                    result.curCycle_ = this.curCycleBuilder_.build();
                }
                result.beginTime_ = this.beginTime_;
                result.unlockStatus_ = this.unlockStatus_;
                if (this.productInfoBuilder_ == null) {
                    result.productInfo_ = this.productInfo_;
                } else {
                    result.productInfo_ = this.productInfoBuilder_.build();
                }
                result.endTime_ = this.endTime_;
                if (this.rewardTakenListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.rewardTakenList_ = Collections.unmodifiableList(this.rewardTakenList_);
                        this.bitField0_ &= -2;
                    }
                    result.rewardTakenList_ = this.rewardTakenList_;
                } else {
                    result.rewardTakenList_ = this.rewardTakenListBuilder_.build();
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
                if (other instanceof BattlePassSchedule) {
                    return mergeFrom((BattlePassSchedule) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BattlePassSchedule other) {
                if (other == BattlePassSchedule.getDefaultInstance()) {
                    return this;
                }
                if (other.getScheduleId() != 0) {
                    setScheduleId(other.getScheduleId());
                }
                if (other.getPoint() != 0) {
                    setPoint(other.getPoint());
                }
                if (other.getLevel() != 0) {
                    setLevel(other.getLevel());
                }
                if (other.getIsExtraPaidRewardTaken()) {
                    setIsExtraPaidRewardTaken(other.getIsExtraPaidRewardTaken());
                }
                if (other.getCurCyclePoints() != 0) {
                    setCurCyclePoints(other.getCurCyclePoints());
                }
                if (other.getIsViewed()) {
                    setIsViewed(other.getIsViewed());
                }
                if (other.getPaidPlatformFlags() != 0) {
                    setPaidPlatformFlags(other.getPaidPlatformFlags());
                }
                if (other.hasCurCycle()) {
                    mergeCurCycle(other.getCurCycle());
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                if (other.unlockStatus_ != 0) {
                    setUnlockStatusValue(other.getUnlockStatusValue());
                }
                if (other.hasProductInfo()) {
                    mergeProductInfo(other.getProductInfo());
                }
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
                }
                if (this.rewardTakenListBuilder_ == null) {
                    if (!other.rewardTakenList_.isEmpty()) {
                        if (this.rewardTakenList_.isEmpty()) {
                            this.rewardTakenList_ = other.rewardTakenList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureRewardTakenListIsMutable();
                            this.rewardTakenList_.addAll(other.rewardTakenList_);
                        }
                        onChanged();
                    }
                } else if (!other.rewardTakenList_.isEmpty()) {
                    if (this.rewardTakenListBuilder_.isEmpty()) {
                        this.rewardTakenListBuilder_.dispose();
                        this.rewardTakenListBuilder_ = null;
                        this.rewardTakenList_ = other.rewardTakenList_;
                        this.bitField0_ &= -2;
                        this.rewardTakenListBuilder_ = BattlePassSchedule.alwaysUseFieldBuilders ? getRewardTakenListFieldBuilder() : null;
                    } else {
                        this.rewardTakenListBuilder_.addAllMessages(other.rewardTakenList_);
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
                BattlePassSchedule parsedMessage = null;
                try {
                    try {
                        parsedMessage = BattlePassSchedule.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BattlePassSchedule) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public int getScheduleId() {
                return this.scheduleId_;
            }

            public Builder setScheduleId(int value) {
                this.scheduleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearScheduleId() {
                this.scheduleId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public int getPoint() {
                return this.point_;
            }

            public Builder setPoint(int value) {
                this.point_ = value;
                onChanged();
                return this;
            }

            public Builder clearPoint() {
                this.point_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public int getLevel() {
                return this.level_;
            }

            public Builder setLevel(int value) {
                this.level_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.level_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public boolean getIsExtraPaidRewardTaken() {
                return this.isExtraPaidRewardTaken_;
            }

            public Builder setIsExtraPaidRewardTaken(boolean value) {
                this.isExtraPaidRewardTaken_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsExtraPaidRewardTaken() {
                this.isExtraPaidRewardTaken_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public int getCurCyclePoints() {
                return this.curCyclePoints_;
            }

            public Builder setCurCyclePoints(int value) {
                this.curCyclePoints_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurCyclePoints() {
                this.curCyclePoints_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public boolean getIsViewed() {
                return this.isViewed_;
            }

            public Builder setIsViewed(boolean value) {
                this.isViewed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsViewed() {
                this.isViewed_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public int getPaidPlatformFlags() {
                return this.paidPlatformFlags_;
            }

            public Builder setPaidPlatformFlags(int value) {
                this.paidPlatformFlags_ = value;
                onChanged();
                return this;
            }

            public Builder clearPaidPlatformFlags() {
                this.paidPlatformFlags_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public boolean hasCurCycle() {
                return (this.curCycleBuilder_ == null && this.curCycle_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public BattlePassCycleOuterClass.BattlePassCycle getCurCycle() {
                if (this.curCycleBuilder_ == null) {
                    return this.curCycle_ == null ? BattlePassCycleOuterClass.BattlePassCycle.getDefaultInstance() : this.curCycle_;
                }
                return this.curCycleBuilder_.getMessage();
            }

            public Builder setCurCycle(BattlePassCycleOuterClass.BattlePassCycle value) {
                if (this.curCycleBuilder_ != null) {
                    this.curCycleBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.curCycle_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setCurCycle(BattlePassCycleOuterClass.BattlePassCycle.Builder builderForValue) {
                if (this.curCycleBuilder_ == null) {
                    this.curCycle_ = builderForValue.build();
                    onChanged();
                } else {
                    this.curCycleBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeCurCycle(BattlePassCycleOuterClass.BattlePassCycle value) {
                if (this.curCycleBuilder_ == null) {
                    if (this.curCycle_ != null) {
                        this.curCycle_ = BattlePassCycleOuterClass.BattlePassCycle.newBuilder(this.curCycle_).mergeFrom(value).buildPartial();
                    } else {
                        this.curCycle_ = value;
                    }
                    onChanged();
                } else {
                    this.curCycleBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearCurCycle() {
                if (this.curCycleBuilder_ == null) {
                    this.curCycle_ = null;
                    onChanged();
                } else {
                    this.curCycle_ = null;
                    this.curCycleBuilder_ = null;
                }
                return this;
            }

            public BattlePassCycleOuterClass.BattlePassCycle.Builder getCurCycleBuilder() {
                onChanged();
                return getCurCycleFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public BattlePassCycleOuterClass.BattlePassCycleOrBuilder getCurCycleOrBuilder() {
                if (this.curCycleBuilder_ != null) {
                    return this.curCycleBuilder_.getMessageOrBuilder();
                }
                return this.curCycle_ == null ? BattlePassCycleOuterClass.BattlePassCycle.getDefaultInstance() : this.curCycle_;
            }

            private SingleFieldBuilderV3<BattlePassCycleOuterClass.BattlePassCycle, BattlePassCycleOuterClass.BattlePassCycle.Builder, BattlePassCycleOuterClass.BattlePassCycleOrBuilder> getCurCycleFieldBuilder() {
                if (this.curCycleBuilder_ == null) {
                    this.curCycleBuilder_ = new SingleFieldBuilderV3<>(getCurCycle(), getParentForChildren(), isClean());
                    this.curCycle_ = null;
                }
                return this.curCycleBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
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

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public int getUnlockStatusValue() {
                return this.unlockStatus_;
            }

            public Builder setUnlockStatusValue(int value) {
                this.unlockStatus_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus getUnlockStatus() {
                BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus result = BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.valueOf(this.unlockStatus_);
                return result == null ? BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.UNRECOGNIZED : result;
            }

            public Builder setUnlockStatus(BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unlockStatus_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearUnlockStatus() {
                this.unlockStatus_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public boolean hasProductInfo() {
                return (this.productInfoBuilder_ == null && this.productInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public BattlePassProductOuterClass.BattlePassProduct getProductInfo() {
                if (this.productInfoBuilder_ == null) {
                    return this.productInfo_ == null ? BattlePassProductOuterClass.BattlePassProduct.getDefaultInstance() : this.productInfo_;
                }
                return this.productInfoBuilder_.getMessage();
            }

            public Builder setProductInfo(BattlePassProductOuterClass.BattlePassProduct value) {
                if (this.productInfoBuilder_ != null) {
                    this.productInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.productInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setProductInfo(BattlePassProductOuterClass.BattlePassProduct.Builder builderForValue) {
                if (this.productInfoBuilder_ == null) {
                    this.productInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.productInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeProductInfo(BattlePassProductOuterClass.BattlePassProduct value) {
                if (this.productInfoBuilder_ == null) {
                    if (this.productInfo_ != null) {
                        this.productInfo_ = BattlePassProductOuterClass.BattlePassProduct.newBuilder(this.productInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.productInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.productInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearProductInfo() {
                if (this.productInfoBuilder_ == null) {
                    this.productInfo_ = null;
                    onChanged();
                } else {
                    this.productInfo_ = null;
                    this.productInfoBuilder_ = null;
                }
                return this;
            }

            public BattlePassProductOuterClass.BattlePassProduct.Builder getProductInfoBuilder() {
                onChanged();
                return getProductInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public BattlePassProductOuterClass.BattlePassProductOrBuilder getProductInfoOrBuilder() {
                if (this.productInfoBuilder_ != null) {
                    return this.productInfoBuilder_.getMessageOrBuilder();
                }
                return this.productInfo_ == null ? BattlePassProductOuterClass.BattlePassProduct.getDefaultInstance() : this.productInfo_;
            }

            private SingleFieldBuilderV3<BattlePassProductOuterClass.BattlePassProduct, BattlePassProductOuterClass.BattlePassProduct.Builder, BattlePassProductOuterClass.BattlePassProductOrBuilder> getProductInfoFieldBuilder() {
                if (this.productInfoBuilder_ == null) {
                    this.productInfoBuilder_ = new SingleFieldBuilderV3<>(getProductInfo(), getParentForChildren(), isClean());
                    this.productInfo_ = null;
                }
                return this.productInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
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

            private void ensureRewardTakenListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.rewardTakenList_ = new ArrayList(this.rewardTakenList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public List<BattlePassRewardTagOuterClass.BattlePassRewardTag> getRewardTakenListList() {
                if (this.rewardTakenListBuilder_ == null) {
                    return Collections.unmodifiableList(this.rewardTakenList_);
                }
                return this.rewardTakenListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public int getRewardTakenListCount() {
                if (this.rewardTakenListBuilder_ == null) {
                    return this.rewardTakenList_.size();
                }
                return this.rewardTakenListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public BattlePassRewardTagOuterClass.BattlePassRewardTag getRewardTakenList(int index) {
                if (this.rewardTakenListBuilder_ == null) {
                    return this.rewardTakenList_.get(index);
                }
                return this.rewardTakenListBuilder_.getMessage(index);
            }

            public Builder setRewardTakenList(int index, BattlePassRewardTagOuterClass.BattlePassRewardTag value) {
                if (this.rewardTakenListBuilder_ != null) {
                    this.rewardTakenListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRewardTakenListIsMutable();
                    this.rewardTakenList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setRewardTakenList(int index, BattlePassRewardTagOuterClass.BattlePassRewardTag.Builder builderForValue) {
                if (this.rewardTakenListBuilder_ == null) {
                    ensureRewardTakenListIsMutable();
                    this.rewardTakenList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.rewardTakenListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addRewardTakenList(BattlePassRewardTagOuterClass.BattlePassRewardTag value) {
                if (this.rewardTakenListBuilder_ != null) {
                    this.rewardTakenListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRewardTakenListIsMutable();
                    this.rewardTakenList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addRewardTakenList(int index, BattlePassRewardTagOuterClass.BattlePassRewardTag value) {
                if (this.rewardTakenListBuilder_ != null) {
                    this.rewardTakenListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRewardTakenListIsMutable();
                    this.rewardTakenList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addRewardTakenList(BattlePassRewardTagOuterClass.BattlePassRewardTag.Builder builderForValue) {
                if (this.rewardTakenListBuilder_ == null) {
                    ensureRewardTakenListIsMutable();
                    this.rewardTakenList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.rewardTakenListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addRewardTakenList(int index, BattlePassRewardTagOuterClass.BattlePassRewardTag.Builder builderForValue) {
                if (this.rewardTakenListBuilder_ == null) {
                    ensureRewardTakenListIsMutable();
                    this.rewardTakenList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.rewardTakenListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllRewardTakenList(Iterable<? extends BattlePassRewardTagOuterClass.BattlePassRewardTag> values) {
                if (this.rewardTakenListBuilder_ == null) {
                    ensureRewardTakenListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.rewardTakenList_);
                    onChanged();
                } else {
                    this.rewardTakenListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearRewardTakenList() {
                if (this.rewardTakenListBuilder_ == null) {
                    this.rewardTakenList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.rewardTakenListBuilder_.clear();
                }
                return this;
            }

            public Builder removeRewardTakenList(int index) {
                if (this.rewardTakenListBuilder_ == null) {
                    ensureRewardTakenListIsMutable();
                    this.rewardTakenList_.remove(index);
                    onChanged();
                } else {
                    this.rewardTakenListBuilder_.remove(index);
                }
                return this;
            }

            public BattlePassRewardTagOuterClass.BattlePassRewardTag.Builder getRewardTakenListBuilder(int index) {
                return getRewardTakenListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder getRewardTakenListOrBuilder(int index) {
                if (this.rewardTakenListBuilder_ == null) {
                    return this.rewardTakenList_.get(index);
                }
                return this.rewardTakenListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder
            public List<? extends BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder> getRewardTakenListOrBuilderList() {
                if (this.rewardTakenListBuilder_ != null) {
                    return this.rewardTakenListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.rewardTakenList_);
            }

            public BattlePassRewardTagOuterClass.BattlePassRewardTag.Builder addRewardTakenListBuilder() {
                return getRewardTakenListFieldBuilder().addBuilder(BattlePassRewardTagOuterClass.BattlePassRewardTag.getDefaultInstance());
            }

            public BattlePassRewardTagOuterClass.BattlePassRewardTag.Builder addRewardTakenListBuilder(int index) {
                return getRewardTakenListFieldBuilder().addBuilder(index, BattlePassRewardTagOuterClass.BattlePassRewardTag.getDefaultInstance());
            }

            public List<BattlePassRewardTagOuterClass.BattlePassRewardTag.Builder> getRewardTakenListBuilderList() {
                return getRewardTakenListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BattlePassRewardTagOuterClass.BattlePassRewardTag, BattlePassRewardTagOuterClass.BattlePassRewardTag.Builder, BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder> getRewardTakenListFieldBuilder() {
                if (this.rewardTakenListBuilder_ == null) {
                    this.rewardTakenListBuilder_ = new RepeatedFieldBuilderV3<>(this.rewardTakenList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.rewardTakenList_ = null;
                }
                return this.rewardTakenListBuilder_;
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

        public static BattlePassSchedule getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BattlePassSchedule> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BattlePassSchedule> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BattlePassSchedule getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BattlePassCycleOuterClass.getDescriptor();
        BattlePassProductOuterClass.getDescriptor();
        BattlePassRewardTagOuterClass.getDescriptor();
        BattlePassUnlockStatusOuterClass.getDescriptor();
    }
}
