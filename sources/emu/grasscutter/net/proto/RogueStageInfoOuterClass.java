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
import emu.grasscutter.net.proto.RogueShowAvatarTeamInfoOuterClass;
import emu.grasscutter.net.proto.RoguelikeRuneRecordOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueStageInfoOuterClass.class */
public final class RogueStageInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014RogueStageInfo.proto\u001a\u001dRogueShowAvatarTeamInfo.proto\u001a\u0019RoguelikeRuneRecord.proto\"¡\u0003\n\u000eRogueStageInfo\u0012\u001d\n\u0014revise_monster_level\u0018®\u000f \u0001(\r\u0012\u0011\n\tis_passed\u0018\u000b \u0001(\b\u0012\u001b\n\u0013Unk3300_GGHMFKNHPAJ\u0018\u0002 \u0001(\r\u0012-\n\u000bavatar_team\u0018\b \u0001(\u000b2\u0018.RogueShowAvatarTeamInfo\u0012\u0017\n\u000fis_taken_reward\u0018\t \u0001(\b\u0012\u0013\n\u000bis_explored\u0018\u000e \u0001(\b\u0012.\n\u0010rune_record_list\u0018\u0005 \u0003(\u000b2\u0014.RoguelikeRuneRecord\u0012\u0014\n\fis_in_combat\u0018\u0006 \u0001(\b\u0012\u0012\n\ncoin_c_num\u0018\u0003 \u0001(\r\u0012\u000f\n\u0007is_open\u0018\r \u0001(\b\u0012\u0010\n\bstage_id\u0018\u0007 \u0001(\r\u0012\u0018\n\u0010max_passed_level\u0018\u0004 \u0001(\r\u0012\u0011\n\tcur_level\u0018\f \u0001(\r\u0012\u001b\n\u0013Unk3300_OHHBEPOICLI\u0018\u0001 \u0001(\r\u0012\u001c\n\u0013Unk3300_HPKFHLLCJBM\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{RogueShowAvatarTeamInfoOuterClass.getDescriptor(), RoguelikeRuneRecordOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_RogueStageInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RogueStageInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RogueStageInfo_descriptor, new String[]{"ReviseMonsterLevel", "IsPassed", "Unk3300GGHMFKNHPAJ", "AvatarTeam", "IsTakenReward", "IsExplored", "RuneRecordList", "IsInCombat", "CoinCNum", "IsOpen", "StageId", "MaxPassedLevel", "CurLevel", "Unk3300OHHBEPOICLI", "Unk3300HPKFHLLCJBM"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueStageInfoOuterClass$RogueStageInfoOrBuilder.class */
    public interface RogueStageInfoOrBuilder extends MessageOrBuilder {
        int getReviseMonsterLevel();

        boolean getIsPassed();

        int getUnk3300GGHMFKNHPAJ();

        boolean hasAvatarTeam();

        RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo getAvatarTeam();

        RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfoOrBuilder getAvatarTeamOrBuilder();

        boolean getIsTakenReward();

        boolean getIsExplored();

        List<RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord> getRuneRecordListList();

        RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord getRuneRecordList(int i);

        int getRuneRecordListCount();

        List<? extends RoguelikeRuneRecordOuterClass.RoguelikeRuneRecordOrBuilder> getRuneRecordListOrBuilderList();

        RoguelikeRuneRecordOuterClass.RoguelikeRuneRecordOrBuilder getRuneRecordListOrBuilder(int i);

        boolean getIsInCombat();

        int getCoinCNum();

        boolean getIsOpen();

        int getStageId();

        int getMaxPassedLevel();

        int getCurLevel();

        int getUnk3300OHHBEPOICLI();

        int getUnk3300HPKFHLLCJBM();
    }

    private RogueStageInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueStageInfoOuterClass$RogueStageInfo.class */
    public static final class RogueStageInfo extends GeneratedMessageV3 implements RogueStageInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int REVISE_MONSTER_LEVEL_FIELD_NUMBER = 1966;
        private int reviseMonsterLevel_;
        public static final int IS_PASSED_FIELD_NUMBER = 11;
        private boolean isPassed_;
        public static final int UNK3300_GGHMFKNHPAJ_FIELD_NUMBER = 2;
        private int unk3300GGHMFKNHPAJ_;
        public static final int AVATAR_TEAM_FIELD_NUMBER = 8;
        private RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo avatarTeam_;
        public static final int IS_TAKEN_REWARD_FIELD_NUMBER = 9;
        private boolean isTakenReward_;
        public static final int IS_EXPLORED_FIELD_NUMBER = 14;
        private boolean isExplored_;
        public static final int RUNE_RECORD_LIST_FIELD_NUMBER = 5;
        private List<RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord> runeRecordList_;
        public static final int IS_IN_COMBAT_FIELD_NUMBER = 6;
        private boolean isInCombat_;
        public static final int COIN_C_NUM_FIELD_NUMBER = 3;
        private int coinCNum_;
        public static final int IS_OPEN_FIELD_NUMBER = 13;
        private boolean isOpen_;
        public static final int STAGE_ID_FIELD_NUMBER = 7;
        private int stageId_;
        public static final int MAX_PASSED_LEVEL_FIELD_NUMBER = 4;
        private int maxPassedLevel_;
        public static final int CUR_LEVEL_FIELD_NUMBER = 12;
        private int curLevel_;
        public static final int UNK3300_OHHBEPOICLI_FIELD_NUMBER = 1;
        private int unk3300OHHBEPOICLI_;
        public static final int UNK3300_HPKFHLLCJBM_FIELD_NUMBER = 275;
        private int unk3300HPKFHLLCJBM_;
        private byte memoizedIsInitialized;
        private static final RogueStageInfo DEFAULT_INSTANCE = new RogueStageInfo();
        private static final Parser<RogueStageInfo> PARSER = new AbstractParser<RogueStageInfo>() { // from class: emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfo.1
            @Override // com.google.protobuf.Parser
            public RogueStageInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RogueStageInfo(input, extensionRegistry);
            }
        };

        private RogueStageInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RogueStageInfo() {
            this.memoizedIsInitialized = -1;
            this.runeRecordList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RogueStageInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RogueStageInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.unk3300OHHBEPOICLI_ = input.readUInt32();
                                break;
                            case 16:
                                this.unk3300GGHMFKNHPAJ_ = input.readUInt32();
                                break;
                            case 24:
                                this.coinCNum_ = input.readUInt32();
                                break;
                            case 32:
                                this.maxPassedLevel_ = input.readUInt32();
                                break;
                            case 42:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.runeRecordList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.runeRecordList_.add((RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord) input.readMessage(RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord.parser(), extensionRegistry));
                                break;
                            case 48:
                                this.isInCombat_ = input.readBool();
                                break;
                            case 56:
                                this.stageId_ = input.readUInt32();
                                break;
                            case 66:
                                RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo.Builder subBuilder = this.avatarTeam_ != null ? this.avatarTeam_.toBuilder() : null;
                                this.avatarTeam_ = (RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo) input.readMessage(RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.avatarTeam_);
                                    this.avatarTeam_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 72:
                                this.isTakenReward_ = input.readBool();
                                break;
                            case 88:
                                this.isPassed_ = input.readBool();
                                break;
                            case 96:
                                this.curLevel_ = input.readUInt32();
                                break;
                            case 104:
                                this.isOpen_ = input.readBool();
                                break;
                            case 112:
                                this.isExplored_ = input.readBool();
                                break;
                            case 2200:
                                this.unk3300HPKFHLLCJBM_ = input.readUInt32();
                                break;
                            case 15728:
                                this.reviseMonsterLevel_ = input.readUInt32();
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
                    this.runeRecordList_ = Collections.unmodifiableList(this.runeRecordList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RogueStageInfoOuterClass.internal_static_RogueStageInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RogueStageInfoOuterClass.internal_static_RogueStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueStageInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public int getReviseMonsterLevel() {
            return this.reviseMonsterLevel_;
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public boolean getIsPassed() {
            return this.isPassed_;
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public int getUnk3300GGHMFKNHPAJ() {
            return this.unk3300GGHMFKNHPAJ_;
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public boolean hasAvatarTeam() {
            return this.avatarTeam_ != null;
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo getAvatarTeam() {
            return this.avatarTeam_ == null ? RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo.getDefaultInstance() : this.avatarTeam_;
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfoOrBuilder getAvatarTeamOrBuilder() {
            return getAvatarTeam();
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public boolean getIsTakenReward() {
            return this.isTakenReward_;
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public boolean getIsExplored() {
            return this.isExplored_;
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public List<RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord> getRuneRecordListList() {
            return this.runeRecordList_;
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public List<? extends RoguelikeRuneRecordOuterClass.RoguelikeRuneRecordOrBuilder> getRuneRecordListOrBuilderList() {
            return this.runeRecordList_;
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public int getRuneRecordListCount() {
            return this.runeRecordList_.size();
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord getRuneRecordList(int index) {
            return this.runeRecordList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public RoguelikeRuneRecordOuterClass.RoguelikeRuneRecordOrBuilder getRuneRecordListOrBuilder(int index) {
            return this.runeRecordList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public boolean getIsInCombat() {
            return this.isInCombat_;
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public int getCoinCNum() {
            return this.coinCNum_;
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public int getMaxPassedLevel() {
            return this.maxPassedLevel_;
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public int getCurLevel() {
            return this.curLevel_;
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public int getUnk3300OHHBEPOICLI() {
            return this.unk3300OHHBEPOICLI_;
        }

        @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
        public int getUnk3300HPKFHLLCJBM() {
            return this.unk3300HPKFHLLCJBM_;
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
            if (this.unk3300OHHBEPOICLI_ != 0) {
                output.writeUInt32(1, this.unk3300OHHBEPOICLI_);
            }
            if (this.unk3300GGHMFKNHPAJ_ != 0) {
                output.writeUInt32(2, this.unk3300GGHMFKNHPAJ_);
            }
            if (this.coinCNum_ != 0) {
                output.writeUInt32(3, this.coinCNum_);
            }
            if (this.maxPassedLevel_ != 0) {
                output.writeUInt32(4, this.maxPassedLevel_);
            }
            for (int i = 0; i < this.runeRecordList_.size(); i++) {
                output.writeMessage(5, this.runeRecordList_.get(i));
            }
            if (this.isInCombat_) {
                output.writeBool(6, this.isInCombat_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(7, this.stageId_);
            }
            if (this.avatarTeam_ != null) {
                output.writeMessage(8, getAvatarTeam());
            }
            if (this.isTakenReward_) {
                output.writeBool(9, this.isTakenReward_);
            }
            if (this.isPassed_) {
                output.writeBool(11, this.isPassed_);
            }
            if (this.curLevel_ != 0) {
                output.writeUInt32(12, this.curLevel_);
            }
            if (this.isOpen_) {
                output.writeBool(13, this.isOpen_);
            }
            if (this.isExplored_) {
                output.writeBool(14, this.isExplored_);
            }
            if (this.unk3300HPKFHLLCJBM_ != 0) {
                output.writeUInt32(275, this.unk3300HPKFHLLCJBM_);
            }
            if (this.reviseMonsterLevel_ != 0) {
                output.writeUInt32(REVISE_MONSTER_LEVEL_FIELD_NUMBER, this.reviseMonsterLevel_);
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
            if (this.unk3300OHHBEPOICLI_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.unk3300OHHBEPOICLI_);
            }
            if (this.unk3300GGHMFKNHPAJ_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.unk3300GGHMFKNHPAJ_);
            }
            if (this.coinCNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.coinCNum_);
            }
            if (this.maxPassedLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.maxPassedLevel_);
            }
            for (int i = 0; i < this.runeRecordList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.runeRecordList_.get(i));
            }
            if (this.isInCombat_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isInCombat_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.stageId_);
            }
            if (this.avatarTeam_ != null) {
                size2 += CodedOutputStream.computeMessageSize(8, getAvatarTeam());
            }
            if (this.isTakenReward_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.isTakenReward_);
            }
            if (this.isPassed_) {
                size2 += CodedOutputStream.computeBoolSize(11, this.isPassed_);
            }
            if (this.curLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.curLevel_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isOpen_);
            }
            if (this.isExplored_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.isExplored_);
            }
            if (this.unk3300HPKFHLLCJBM_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(275, this.unk3300HPKFHLLCJBM_);
            }
            if (this.reviseMonsterLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(REVISE_MONSTER_LEVEL_FIELD_NUMBER, this.reviseMonsterLevel_);
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
            if (!(obj instanceof RogueStageInfo)) {
                return equals(obj);
            }
            RogueStageInfo other = (RogueStageInfo) obj;
            if (getReviseMonsterLevel() == other.getReviseMonsterLevel() && getIsPassed() == other.getIsPassed() && getUnk3300GGHMFKNHPAJ() == other.getUnk3300GGHMFKNHPAJ() && hasAvatarTeam() == other.hasAvatarTeam()) {
                return (!hasAvatarTeam() || getAvatarTeam().equals(other.getAvatarTeam())) && getIsTakenReward() == other.getIsTakenReward() && getIsExplored() == other.getIsExplored() && getRuneRecordListList().equals(other.getRuneRecordListList()) && getIsInCombat() == other.getIsInCombat() && getCoinCNum() == other.getCoinCNum() && getIsOpen() == other.getIsOpen() && getStageId() == other.getStageId() && getMaxPassedLevel() == other.getMaxPassedLevel() && getCurLevel() == other.getCurLevel() && getUnk3300OHHBEPOICLI() == other.getUnk3300OHHBEPOICLI() && getUnk3300HPKFHLLCJBM() == other.getUnk3300HPKFHLLCJBM() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + REVISE_MONSTER_LEVEL_FIELD_NUMBER)) + getReviseMonsterLevel())) + 11)) + Internal.hashBoolean(getIsPassed()))) + 2)) + getUnk3300GGHMFKNHPAJ();
            if (hasAvatarTeam()) {
                hash = (53 * ((37 * hash) + 8)) + getAvatarTeam().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 9)) + Internal.hashBoolean(getIsTakenReward()))) + 14)) + Internal.hashBoolean(getIsExplored());
            if (getRuneRecordListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 5)) + getRuneRecordListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 6)) + Internal.hashBoolean(getIsInCombat()))) + 3)) + getCoinCNum())) + 13)) + Internal.hashBoolean(getIsOpen()))) + 7)) + getStageId())) + 4)) + getMaxPassedLevel())) + 12)) + getCurLevel())) + 1)) + getUnk3300OHHBEPOICLI())) + 275)) + getUnk3300HPKFHLLCJBM())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static RogueStageInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueStageInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueStageInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueStageInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueStageInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueStageInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueStageInfo parseFrom(InputStream input) throws IOException {
            return (RogueStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueStageInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueStageInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (RogueStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RogueStageInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueStageInfo parseFrom(CodedInputStream input) throws IOException {
            return (RogueStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueStageInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RogueStageInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueStageInfoOuterClass$RogueStageInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RogueStageInfoOrBuilder {
            private int bitField0_;
            private int reviseMonsterLevel_;
            private boolean isPassed_;
            private int unk3300GGHMFKNHPAJ_;
            private RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo avatarTeam_;
            private SingleFieldBuilderV3<RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo, RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo.Builder, RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfoOrBuilder> avatarTeamBuilder_;
            private boolean isTakenReward_;
            private boolean isExplored_;
            private List<RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord> runeRecordList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord, RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord.Builder, RoguelikeRuneRecordOuterClass.RoguelikeRuneRecordOrBuilder> runeRecordListBuilder_;
            private boolean isInCombat_;
            private int coinCNum_;
            private boolean isOpen_;
            private int stageId_;
            private int maxPassedLevel_;
            private int curLevel_;
            private int unk3300OHHBEPOICLI_;
            private int unk3300HPKFHLLCJBM_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RogueStageInfoOuterClass.internal_static_RogueStageInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RogueStageInfoOuterClass.internal_static_RogueStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueStageInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RogueStageInfo.alwaysUseFieldBuilders) {
                    getRuneRecordListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.reviseMonsterLevel_ = 0;
                this.isPassed_ = false;
                this.unk3300GGHMFKNHPAJ_ = 0;
                if (this.avatarTeamBuilder_ == null) {
                    this.avatarTeam_ = null;
                } else {
                    this.avatarTeam_ = null;
                    this.avatarTeamBuilder_ = null;
                }
                this.isTakenReward_ = false;
                this.isExplored_ = false;
                if (this.runeRecordListBuilder_ == null) {
                    this.runeRecordList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.runeRecordListBuilder_.clear();
                }
                this.isInCombat_ = false;
                this.coinCNum_ = 0;
                this.isOpen_ = false;
                this.stageId_ = 0;
                this.maxPassedLevel_ = 0;
                this.curLevel_ = 0;
                this.unk3300OHHBEPOICLI_ = 0;
                this.unk3300HPKFHLLCJBM_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RogueStageInfoOuterClass.internal_static_RogueStageInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RogueStageInfo getDefaultInstanceForType() {
                return RogueStageInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueStageInfo build() {
                RogueStageInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueStageInfo buildPartial() {
                RogueStageInfo result = new RogueStageInfo(this);
                int i = this.bitField0_;
                result.reviseMonsterLevel_ = this.reviseMonsterLevel_;
                result.isPassed_ = this.isPassed_;
                result.unk3300GGHMFKNHPAJ_ = this.unk3300GGHMFKNHPAJ_;
                if (this.avatarTeamBuilder_ == null) {
                    result.avatarTeam_ = this.avatarTeam_;
                } else {
                    result.avatarTeam_ = this.avatarTeamBuilder_.build();
                }
                result.isTakenReward_ = this.isTakenReward_;
                result.isExplored_ = this.isExplored_;
                if (this.runeRecordListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.runeRecordList_ = Collections.unmodifiableList(this.runeRecordList_);
                        this.bitField0_ &= -2;
                    }
                    result.runeRecordList_ = this.runeRecordList_;
                } else {
                    result.runeRecordList_ = this.runeRecordListBuilder_.build();
                }
                result.isInCombat_ = this.isInCombat_;
                result.coinCNum_ = this.coinCNum_;
                result.isOpen_ = this.isOpen_;
                result.stageId_ = this.stageId_;
                result.maxPassedLevel_ = this.maxPassedLevel_;
                result.curLevel_ = this.curLevel_;
                result.unk3300OHHBEPOICLI_ = this.unk3300OHHBEPOICLI_;
                result.unk3300HPKFHLLCJBM_ = this.unk3300HPKFHLLCJBM_;
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
                if (other instanceof RogueStageInfo) {
                    return mergeFrom((RogueStageInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RogueStageInfo other) {
                if (other == RogueStageInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getReviseMonsterLevel() != 0) {
                    setReviseMonsterLevel(other.getReviseMonsterLevel());
                }
                if (other.getIsPassed()) {
                    setIsPassed(other.getIsPassed());
                }
                if (other.getUnk3300GGHMFKNHPAJ() != 0) {
                    setUnk3300GGHMFKNHPAJ(other.getUnk3300GGHMFKNHPAJ());
                }
                if (other.hasAvatarTeam()) {
                    mergeAvatarTeam(other.getAvatarTeam());
                }
                if (other.getIsTakenReward()) {
                    setIsTakenReward(other.getIsTakenReward());
                }
                if (other.getIsExplored()) {
                    setIsExplored(other.getIsExplored());
                }
                if (this.runeRecordListBuilder_ == null) {
                    if (!other.runeRecordList_.isEmpty()) {
                        if (this.runeRecordList_.isEmpty()) {
                            this.runeRecordList_ = other.runeRecordList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureRuneRecordListIsMutable();
                            this.runeRecordList_.addAll(other.runeRecordList_);
                        }
                        onChanged();
                    }
                } else if (!other.runeRecordList_.isEmpty()) {
                    if (this.runeRecordListBuilder_.isEmpty()) {
                        this.runeRecordListBuilder_.dispose();
                        this.runeRecordListBuilder_ = null;
                        this.runeRecordList_ = other.runeRecordList_;
                        this.bitField0_ &= -2;
                        this.runeRecordListBuilder_ = RogueStageInfo.alwaysUseFieldBuilders ? getRuneRecordListFieldBuilder() : null;
                    } else {
                        this.runeRecordListBuilder_.addAllMessages(other.runeRecordList_);
                    }
                }
                if (other.getIsInCombat()) {
                    setIsInCombat(other.getIsInCombat());
                }
                if (other.getCoinCNum() != 0) {
                    setCoinCNum(other.getCoinCNum());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getMaxPassedLevel() != 0) {
                    setMaxPassedLevel(other.getMaxPassedLevel());
                }
                if (other.getCurLevel() != 0) {
                    setCurLevel(other.getCurLevel());
                }
                if (other.getUnk3300OHHBEPOICLI() != 0) {
                    setUnk3300OHHBEPOICLI(other.getUnk3300OHHBEPOICLI());
                }
                if (other.getUnk3300HPKFHLLCJBM() != 0) {
                    setUnk3300HPKFHLLCJBM(other.getUnk3300HPKFHLLCJBM());
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
                RogueStageInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = RogueStageInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RogueStageInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public int getReviseMonsterLevel() {
                return this.reviseMonsterLevel_;
            }

            public Builder setReviseMonsterLevel(int value) {
                this.reviseMonsterLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearReviseMonsterLevel() {
                this.reviseMonsterLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public boolean getIsPassed() {
                return this.isPassed_;
            }

            public Builder setIsPassed(boolean value) {
                this.isPassed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsPassed() {
                this.isPassed_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public int getUnk3300GGHMFKNHPAJ() {
                return this.unk3300GGHMFKNHPAJ_;
            }

            public Builder setUnk3300GGHMFKNHPAJ(int value) {
                this.unk3300GGHMFKNHPAJ_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300GGHMFKNHPAJ() {
                this.unk3300GGHMFKNHPAJ_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public boolean hasAvatarTeam() {
                return (this.avatarTeamBuilder_ == null && this.avatarTeam_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo getAvatarTeam() {
                if (this.avatarTeamBuilder_ == null) {
                    return this.avatarTeam_ == null ? RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo.getDefaultInstance() : this.avatarTeam_;
                }
                return this.avatarTeamBuilder_.getMessage();
            }

            public Builder setAvatarTeam(RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo value) {
                if (this.avatarTeamBuilder_ != null) {
                    this.avatarTeamBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.avatarTeam_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAvatarTeam(RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo.Builder builderForValue) {
                if (this.avatarTeamBuilder_ == null) {
                    this.avatarTeam_ = builderForValue.build();
                    onChanged();
                } else {
                    this.avatarTeamBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAvatarTeam(RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo value) {
                if (this.avatarTeamBuilder_ == null) {
                    if (this.avatarTeam_ != null) {
                        this.avatarTeam_ = RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo.newBuilder(this.avatarTeam_).mergeFrom(value).buildPartial();
                    } else {
                        this.avatarTeam_ = value;
                    }
                    onChanged();
                } else {
                    this.avatarTeamBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAvatarTeam() {
                if (this.avatarTeamBuilder_ == null) {
                    this.avatarTeam_ = null;
                    onChanged();
                } else {
                    this.avatarTeam_ = null;
                    this.avatarTeamBuilder_ = null;
                }
                return this;
            }

            public RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo.Builder getAvatarTeamBuilder() {
                onChanged();
                return getAvatarTeamFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfoOrBuilder getAvatarTeamOrBuilder() {
                if (this.avatarTeamBuilder_ != null) {
                    return this.avatarTeamBuilder_.getMessageOrBuilder();
                }
                return this.avatarTeam_ == null ? RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo.getDefaultInstance() : this.avatarTeam_;
            }

            private SingleFieldBuilderV3<RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo, RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo.Builder, RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfoOrBuilder> getAvatarTeamFieldBuilder() {
                if (this.avatarTeamBuilder_ == null) {
                    this.avatarTeamBuilder_ = new SingleFieldBuilderV3<>(getAvatarTeam(), getParentForChildren(), isClean());
                    this.avatarTeam_ = null;
                }
                return this.avatarTeamBuilder_;
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public boolean getIsTakenReward() {
                return this.isTakenReward_;
            }

            public Builder setIsTakenReward(boolean value) {
                this.isTakenReward_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsTakenReward() {
                this.isTakenReward_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public boolean getIsExplored() {
                return this.isExplored_;
            }

            public Builder setIsExplored(boolean value) {
                this.isExplored_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsExplored() {
                this.isExplored_ = false;
                onChanged();
                return this;
            }

            private void ensureRuneRecordListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.runeRecordList_ = new ArrayList(this.runeRecordList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public List<RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord> getRuneRecordListList() {
                if (this.runeRecordListBuilder_ == null) {
                    return Collections.unmodifiableList(this.runeRecordList_);
                }
                return this.runeRecordListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public int getRuneRecordListCount() {
                if (this.runeRecordListBuilder_ == null) {
                    return this.runeRecordList_.size();
                }
                return this.runeRecordListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord getRuneRecordList(int index) {
                if (this.runeRecordListBuilder_ == null) {
                    return this.runeRecordList_.get(index);
                }
                return this.runeRecordListBuilder_.getMessage(index);
            }

            public Builder setRuneRecordList(int index, RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord value) {
                if (this.runeRecordListBuilder_ != null) {
                    this.runeRecordListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRuneRecordListIsMutable();
                    this.runeRecordList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setRuneRecordList(int index, RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord.Builder builderForValue) {
                if (this.runeRecordListBuilder_ == null) {
                    ensureRuneRecordListIsMutable();
                    this.runeRecordList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.runeRecordListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addRuneRecordList(RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord value) {
                if (this.runeRecordListBuilder_ != null) {
                    this.runeRecordListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRuneRecordListIsMutable();
                    this.runeRecordList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addRuneRecordList(int index, RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord value) {
                if (this.runeRecordListBuilder_ != null) {
                    this.runeRecordListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRuneRecordListIsMutable();
                    this.runeRecordList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addRuneRecordList(RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord.Builder builderForValue) {
                if (this.runeRecordListBuilder_ == null) {
                    ensureRuneRecordListIsMutable();
                    this.runeRecordList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.runeRecordListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addRuneRecordList(int index, RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord.Builder builderForValue) {
                if (this.runeRecordListBuilder_ == null) {
                    ensureRuneRecordListIsMutable();
                    this.runeRecordList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.runeRecordListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllRuneRecordList(Iterable<? extends RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord> values) {
                if (this.runeRecordListBuilder_ == null) {
                    ensureRuneRecordListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.runeRecordList_);
                    onChanged();
                } else {
                    this.runeRecordListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearRuneRecordList() {
                if (this.runeRecordListBuilder_ == null) {
                    this.runeRecordList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.runeRecordListBuilder_.clear();
                }
                return this;
            }

            public Builder removeRuneRecordList(int index) {
                if (this.runeRecordListBuilder_ == null) {
                    ensureRuneRecordListIsMutable();
                    this.runeRecordList_.remove(index);
                    onChanged();
                } else {
                    this.runeRecordListBuilder_.remove(index);
                }
                return this;
            }

            public RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord.Builder getRuneRecordListBuilder(int index) {
                return getRuneRecordListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public RoguelikeRuneRecordOuterClass.RoguelikeRuneRecordOrBuilder getRuneRecordListOrBuilder(int index) {
                if (this.runeRecordListBuilder_ == null) {
                    return this.runeRecordList_.get(index);
                }
                return this.runeRecordListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public List<? extends RoguelikeRuneRecordOuterClass.RoguelikeRuneRecordOrBuilder> getRuneRecordListOrBuilderList() {
                if (this.runeRecordListBuilder_ != null) {
                    return this.runeRecordListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.runeRecordList_);
            }

            public RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord.Builder addRuneRecordListBuilder() {
                return getRuneRecordListFieldBuilder().addBuilder(RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord.getDefaultInstance());
            }

            public RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord.Builder addRuneRecordListBuilder(int index) {
                return getRuneRecordListFieldBuilder().addBuilder(index, RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord.getDefaultInstance());
            }

            public List<RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord.Builder> getRuneRecordListBuilderList() {
                return getRuneRecordListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord, RoguelikeRuneRecordOuterClass.RoguelikeRuneRecord.Builder, RoguelikeRuneRecordOuterClass.RoguelikeRuneRecordOrBuilder> getRuneRecordListFieldBuilder() {
                if (this.runeRecordListBuilder_ == null) {
                    this.runeRecordListBuilder_ = new RepeatedFieldBuilderV3<>(this.runeRecordList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.runeRecordList_ = null;
                }
                return this.runeRecordListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public boolean getIsInCombat() {
                return this.isInCombat_;
            }

            public Builder setIsInCombat(boolean value) {
                this.isInCombat_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsInCombat() {
                this.isInCombat_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public int getCoinCNum() {
                return this.coinCNum_;
            }

            public Builder setCoinCNum(int value) {
                this.coinCNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearCoinCNum() {
                this.coinCNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public int getStageId() {
                return this.stageId_;
            }

            public Builder setStageId(int value) {
                this.stageId_ = value;
                onChanged();
                return this;
            }

            public Builder clearStageId() {
                this.stageId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public int getMaxPassedLevel() {
                return this.maxPassedLevel_;
            }

            public Builder setMaxPassedLevel(int value) {
                this.maxPassedLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxPassedLevel() {
                this.maxPassedLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public int getCurLevel() {
                return this.curLevel_;
            }

            public Builder setCurLevel(int value) {
                this.curLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurLevel() {
                this.curLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public int getUnk3300OHHBEPOICLI() {
                return this.unk3300OHHBEPOICLI_;
            }

            public Builder setUnk3300OHHBEPOICLI(int value) {
                this.unk3300OHHBEPOICLI_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300OHHBEPOICLI() {
                this.unk3300OHHBEPOICLI_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueStageInfoOuterClass.RogueStageInfoOrBuilder
            public int getUnk3300HPKFHLLCJBM() {
                return this.unk3300HPKFHLLCJBM_;
            }

            public Builder setUnk3300HPKFHLLCJBM(int value) {
                this.unk3300HPKFHLLCJBM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300HPKFHLLCJBM() {
                this.unk3300HPKFHLLCJBM_ = 0;
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

        public static RogueStageInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RogueStageInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RogueStageInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RogueStageInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        RogueShowAvatarTeamInfoOuterClass.getDescriptor();
        RoguelikeRuneRecordOuterClass.getDescriptor();
    }
}
