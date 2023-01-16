package emu.grasscutter.net.proto;

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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.VectorOuterClass;
import emu.grasscutter.net.proto.WeeklyBossResinDiscountInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InvestigationMonsterOuterClass.class */
public final class InvestigationMonsterOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aInvestigationMonster.proto\u001a\fVector.proto\u001a!WeeklyBossResinDiscountInfo.proto\"\u0004\n\u0014InvestigationMonster\u0012\u0010\n\bis_alive\u0018\r \u0001(\b\u0012\u0014\n\u0003pos\u0018\u0007 \u0001(\u000b2\u0007.Vector\u0012\u0010\n\bscene_id\u0018\f \u0001(\r\u0012\u0019\n\u0011next_refresh_time\u0018\b \u0001(\r\u0012\u000f\n\u0007city_id\u0018\u000e \u0001(\r\u0012\u0011\n\bgroup_id\u0018Ç\r \u0001(\r\u0012$\n\u001cnext_boss_chest_refresh_time\u0018\u0001 \u0001(\r\u0012E\n\u001fweekly_boss_resin_discount_info\u0018\u0003 \u0001(\u000b2\u001c.WeeklyBossResinDiscountInfo\u0012\u0016\n\u000eboss_chest_num\u0018\u0006 \u0001(\r\u0012\n\n\u0002id\u0018\t \u0001(\r\u0012\u0013\n\nmonster_id\u0018²\u0004 \u0001(\r\u00123\n\nlock_state\u0018\u0004 \u0001(\u000e2\u001f.InvestigationMonster.LockState\u0012\u0018\n\u0010refresh_interval\u0018\n \u0001(\r\u0012\u0016\n\u000eis_area_locked\u0018\u0005 \u0001(\b\u0012\r\n\u0005level\u0018\u0002 \u0001(\r\u0012\u001a\n\u0012max_boss_chest_num\u0018\u000b \u0001(\r\u0012\r\n\u0005resin\u0018\u000f \u0001(\r\"6\n\tLockState\u0012\u0013\n\u000fLOCK_STATE_NONE\u0010��\u0012\u0014\n\u0010LOCK_STATE_QUEST\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor(), WeeklyBossResinDiscountInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_InvestigationMonster_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_InvestigationMonster_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_InvestigationMonster_descriptor, new String[]{"IsAlive", "Pos", "SceneId", "NextRefreshTime", "CityId", "GroupId", "NextBossChestRefreshTime", "WeeklyBossResinDiscountInfo", "BossChestNum", "Id", "MonsterId", "LockState", "RefreshInterval", "IsAreaLocked", "Level", "MaxBossChestNum", "Resin"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InvestigationMonsterOuterClass$InvestigationMonsterOrBuilder.class */
    public interface InvestigationMonsterOrBuilder extends MessageOrBuilder {
        boolean getIsAlive();

        boolean hasPos();

        VectorOuterClass.Vector getPos();

        VectorOuterClass.VectorOrBuilder getPosOrBuilder();

        int getSceneId();

        int getNextRefreshTime();

        int getCityId();

        int getGroupId();

        int getNextBossChestRefreshTime();

        boolean hasWeeklyBossResinDiscountInfo();

        WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo getWeeklyBossResinDiscountInfo();

        WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder getWeeklyBossResinDiscountInfoOrBuilder();

        int getBossChestNum();

        int getId();

        int getMonsterId();

        int getLockStateValue();

        InvestigationMonster.LockState getLockState();

        int getRefreshInterval();

        boolean getIsAreaLocked();

        int getLevel();

        int getMaxBossChestNum();

        int getResin();
    }

    private InvestigationMonsterOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InvestigationMonsterOuterClass$InvestigationMonster.class */
    public static final class InvestigationMonster extends GeneratedMessageV3 implements InvestigationMonsterOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_ALIVE_FIELD_NUMBER = 13;
        private boolean isAlive_;
        public static final int POS_FIELD_NUMBER = 7;
        private VectorOuterClass.Vector pos_;
        public static final int SCENE_ID_FIELD_NUMBER = 12;
        private int sceneId_;
        public static final int NEXT_REFRESH_TIME_FIELD_NUMBER = 8;
        private int nextRefreshTime_;
        public static final int CITY_ID_FIELD_NUMBER = 14;
        private int cityId_;
        public static final int GROUP_ID_FIELD_NUMBER = 1735;
        private int groupId_;
        public static final int NEXT_BOSS_CHEST_REFRESH_TIME_FIELD_NUMBER = 1;
        private int nextBossChestRefreshTime_;
        public static final int WEEKLY_BOSS_RESIN_DISCOUNT_INFO_FIELD_NUMBER = 3;
        private WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo weeklyBossResinDiscountInfo_;
        public static final int BOSS_CHEST_NUM_FIELD_NUMBER = 6;
        private int bossChestNum_;
        public static final int ID_FIELD_NUMBER = 9;
        private int id_;
        public static final int MONSTER_ID_FIELD_NUMBER = 562;
        private int monsterId_;
        public static final int LOCK_STATE_FIELD_NUMBER = 4;
        private int lockState_;
        public static final int REFRESH_INTERVAL_FIELD_NUMBER = 10;
        private int refreshInterval_;
        public static final int IS_AREA_LOCKED_FIELD_NUMBER = 5;
        private boolean isAreaLocked_;
        public static final int LEVEL_FIELD_NUMBER = 2;
        private int level_;
        public static final int MAX_BOSS_CHEST_NUM_FIELD_NUMBER = 11;
        private int maxBossChestNum_;
        public static final int RESIN_FIELD_NUMBER = 15;
        private int resin_;
        private byte memoizedIsInitialized;
        private static final InvestigationMonster DEFAULT_INSTANCE = new InvestigationMonster();
        private static final Parser<InvestigationMonster> PARSER = new AbstractParser<InvestigationMonster>() { // from class: emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonster.1
            @Override // com.google.protobuf.Parser
            public InvestigationMonster parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InvestigationMonster(input, extensionRegistry);
            }
        };

        private InvestigationMonster(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private InvestigationMonster() {
            this.memoizedIsInitialized = -1;
            this.lockState_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new InvestigationMonster();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InvestigationMonster(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.nextBossChestRefreshTime_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.level_ = input.readUInt32();
                                    break;
                                case 26:
                                    WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.Builder subBuilder = this.weeklyBossResinDiscountInfo_ != null ? this.weeklyBossResinDiscountInfo_.toBuilder() : null;
                                    this.weeklyBossResinDiscountInfo_ = (WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo) input.readMessage(WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.weeklyBossResinDiscountInfo_);
                                        this.weeklyBossResinDiscountInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 32:
                                    this.lockState_ = input.readEnum();
                                    break;
                                case 40:
                                    this.isAreaLocked_ = input.readBool();
                                    break;
                                case 48:
                                    this.bossChestNum_ = input.readUInt32();
                                    break;
                                case 58:
                                    VectorOuterClass.Vector.Builder subBuilder2 = this.pos_ != null ? this.pos_.toBuilder() : null;
                                    this.pos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.pos_);
                                        this.pos_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                case 64:
                                    this.nextRefreshTime_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.id_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.refreshInterval_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.maxBossChestNum_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.sceneId_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.isAlive_ = input.readBool();
                                    break;
                                case 112:
                                    this.cityId_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.resin_ = input.readUInt32();
                                    break;
                                case 4496:
                                    this.monsterId_ = input.readUInt32();
                                    break;
                                case 13880:
                                    this.groupId_ = input.readUInt32();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return InvestigationMonsterOuterClass.internal_static_InvestigationMonster_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return InvestigationMonsterOuterClass.internal_static_InvestigationMonster_fieldAccessorTable.ensureFieldAccessorsInitialized(InvestigationMonster.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InvestigationMonsterOuterClass$InvestigationMonster$LockState.class */
        public enum LockState implements ProtocolMessageEnum {
            LOCK_STATE_NONE(0),
            LOCK_STATE_QUEST(1),
            UNRECOGNIZED(-1);
            
            public static final int LOCK_STATE_NONE_VALUE = 0;
            public static final int LOCK_STATE_QUEST_VALUE = 1;
            private static final Internal.EnumLiteMap<LockState> internalValueMap = new Internal.EnumLiteMap<LockState>() { // from class: emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonster.LockState.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public LockState findValueByNumber(int number) {
                    return LockState.forNumber(number);
                }
            };
            private static final LockState[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static LockState valueOf(int value) {
                return forNumber(value);
            }

            public static LockState forNumber(int value) {
                switch (value) {
                    case 0:
                        return LOCK_STATE_NONE;
                    case 1:
                        return LOCK_STATE_QUEST;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<LockState> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                if (this != UNRECOGNIZED) {
                    return getDescriptor().getValues().get(ordinal());
                }
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return InvestigationMonster.getDescriptor().getEnumTypes().get(0);
            }

            public static LockState valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            LockState(int value) {
                this.value = value;
            }
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public boolean getIsAlive() {
            return this.isAlive_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public VectorOuterClass.Vector getPos() {
            return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public int getNextRefreshTime() {
            return this.nextRefreshTime_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public int getCityId() {
            return this.cityId_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public int getGroupId() {
            return this.groupId_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public int getNextBossChestRefreshTime() {
            return this.nextBossChestRefreshTime_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public boolean hasWeeklyBossResinDiscountInfo() {
            return this.weeklyBossResinDiscountInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo getWeeklyBossResinDiscountInfo() {
            return this.weeklyBossResinDiscountInfo_ == null ? WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.getDefaultInstance() : this.weeklyBossResinDiscountInfo_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder getWeeklyBossResinDiscountInfoOrBuilder() {
            return getWeeklyBossResinDiscountInfo();
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public int getBossChestNum() {
            return this.bossChestNum_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public int getMonsterId() {
            return this.monsterId_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public int getLockStateValue() {
            return this.lockState_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public LockState getLockState() {
            LockState result = LockState.valueOf(this.lockState_);
            return result == null ? LockState.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public int getRefreshInterval() {
            return this.refreshInterval_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public boolean getIsAreaLocked() {
            return this.isAreaLocked_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public int getMaxBossChestNum() {
            return this.maxBossChestNum_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
        public int getResin() {
            return this.resin_;
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
            if (this.nextBossChestRefreshTime_ != 0) {
                output.writeUInt32(1, this.nextBossChestRefreshTime_);
            }
            if (this.level_ != 0) {
                output.writeUInt32(2, this.level_);
            }
            if (this.weeklyBossResinDiscountInfo_ != null) {
                output.writeMessage(3, getWeeklyBossResinDiscountInfo());
            }
            if (this.lockState_ != LockState.LOCK_STATE_NONE.getNumber()) {
                output.writeEnum(4, this.lockState_);
            }
            if (this.isAreaLocked_) {
                output.writeBool(5, this.isAreaLocked_);
            }
            if (this.bossChestNum_ != 0) {
                output.writeUInt32(6, this.bossChestNum_);
            }
            if (this.pos_ != null) {
                output.writeMessage(7, getPos());
            }
            if (this.nextRefreshTime_ != 0) {
                output.writeUInt32(8, this.nextRefreshTime_);
            }
            if (this.id_ != 0) {
                output.writeUInt32(9, this.id_);
            }
            if (this.refreshInterval_ != 0) {
                output.writeUInt32(10, this.refreshInterval_);
            }
            if (this.maxBossChestNum_ != 0) {
                output.writeUInt32(11, this.maxBossChestNum_);
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(12, this.sceneId_);
            }
            if (this.isAlive_) {
                output.writeBool(13, this.isAlive_);
            }
            if (this.cityId_ != 0) {
                output.writeUInt32(14, this.cityId_);
            }
            if (this.resin_ != 0) {
                output.writeUInt32(15, this.resin_);
            }
            if (this.monsterId_ != 0) {
                output.writeUInt32(562, this.monsterId_);
            }
            if (this.groupId_ != 0) {
                output.writeUInt32(1735, this.groupId_);
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
            if (this.nextBossChestRefreshTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.nextBossChestRefreshTime_);
            }
            if (this.level_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.level_);
            }
            if (this.weeklyBossResinDiscountInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(3, getWeeklyBossResinDiscountInfo());
            }
            if (this.lockState_ != LockState.LOCK_STATE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(4, this.lockState_);
            }
            if (this.isAreaLocked_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.isAreaLocked_);
            }
            if (this.bossChestNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.bossChestNum_);
            }
            if (this.pos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(7, getPos());
            }
            if (this.nextRefreshTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.nextRefreshTime_);
            }
            if (this.id_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.id_);
            }
            if (this.refreshInterval_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.refreshInterval_);
            }
            if (this.maxBossChestNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.maxBossChestNum_);
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.sceneId_);
            }
            if (this.isAlive_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isAlive_);
            }
            if (this.cityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.cityId_);
            }
            if (this.resin_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.resin_);
            }
            if (this.monsterId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(562, this.monsterId_);
            }
            if (this.groupId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(1735, this.groupId_);
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
            if (!(obj instanceof InvestigationMonster)) {
                return equals(obj);
            }
            InvestigationMonster other = (InvestigationMonster) obj;
            if (getIsAlive() != other.getIsAlive() || hasPos() != other.hasPos()) {
                return false;
            }
            if ((!hasPos() || getPos().equals(other.getPos())) && getSceneId() == other.getSceneId() && getNextRefreshTime() == other.getNextRefreshTime() && getCityId() == other.getCityId() && getGroupId() == other.getGroupId() && getNextBossChestRefreshTime() == other.getNextBossChestRefreshTime() && hasWeeklyBossResinDiscountInfo() == other.hasWeeklyBossResinDiscountInfo()) {
                return (!hasWeeklyBossResinDiscountInfo() || getWeeklyBossResinDiscountInfo().equals(other.getWeeklyBossResinDiscountInfo())) && getBossChestNum() == other.getBossChestNum() && getId() == other.getId() && getMonsterId() == other.getMonsterId() && this.lockState_ == other.lockState_ && getRefreshInterval() == other.getRefreshInterval() && getIsAreaLocked() == other.getIsAreaLocked() && getLevel() == other.getLevel() && getMaxBossChestNum() == other.getMaxBossChestNum() && getResin() == other.getResin() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + Internal.hashBoolean(getIsAlive());
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 7)) + getPos().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 12)) + getSceneId())) + 8)) + getNextRefreshTime())) + 14)) + getCityId())) + 1735)) + getGroupId())) + 1)) + getNextBossChestRefreshTime();
            if (hasWeeklyBossResinDiscountInfo()) {
                hash2 = (53 * ((37 * hash2) + 3)) + getWeeklyBossResinDiscountInfo().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 6)) + getBossChestNum())) + 9)) + getId())) + 562)) + getMonsterId())) + 4)) + this.lockState_)) + 10)) + getRefreshInterval())) + 5)) + Internal.hashBoolean(getIsAreaLocked()))) + 2)) + getLevel())) + 11)) + getMaxBossChestNum())) + 15)) + getResin())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static InvestigationMonster parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InvestigationMonster parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InvestigationMonster parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InvestigationMonster parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InvestigationMonster parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InvestigationMonster parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InvestigationMonster parseFrom(InputStream input) throws IOException {
            return (InvestigationMonster) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static InvestigationMonster parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InvestigationMonster) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static InvestigationMonster parseDelimitedFrom(InputStream input) throws IOException {
            return (InvestigationMonster) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static InvestigationMonster parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InvestigationMonster) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static InvestigationMonster parseFrom(CodedInputStream input) throws IOException {
            return (InvestigationMonster) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static InvestigationMonster parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InvestigationMonster) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(InvestigationMonster prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InvestigationMonsterOuterClass$InvestigationMonster$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InvestigationMonsterOrBuilder {
            private boolean isAlive_;
            private VectorOuterClass.Vector pos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posBuilder_;
            private int sceneId_;
            private int nextRefreshTime_;
            private int cityId_;
            private int groupId_;
            private int nextBossChestRefreshTime_;
            private WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo weeklyBossResinDiscountInfo_;
            private SingleFieldBuilderV3<WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.Builder, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder> weeklyBossResinDiscountInfoBuilder_;
            private int bossChestNum_;
            private int id_;
            private int monsterId_;
            private int lockState_ = 0;
            private int refreshInterval_;
            private boolean isAreaLocked_;
            private int level_;
            private int maxBossChestNum_;
            private int resin_;

            public static final Descriptors.Descriptor getDescriptor() {
                return InvestigationMonsterOuterClass.internal_static_InvestigationMonster_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return InvestigationMonsterOuterClass.internal_static_InvestigationMonster_fieldAccessorTable.ensureFieldAccessorsInitialized(InvestigationMonster.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (InvestigationMonster.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isAlive_ = false;
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                this.sceneId_ = 0;
                this.nextRefreshTime_ = 0;
                this.cityId_ = 0;
                this.groupId_ = 0;
                this.nextBossChestRefreshTime_ = 0;
                if (this.weeklyBossResinDiscountInfoBuilder_ == null) {
                    this.weeklyBossResinDiscountInfo_ = null;
                } else {
                    this.weeklyBossResinDiscountInfo_ = null;
                    this.weeklyBossResinDiscountInfoBuilder_ = null;
                }
                this.bossChestNum_ = 0;
                this.id_ = 0;
                this.monsterId_ = 0;
                this.lockState_ = 0;
                this.refreshInterval_ = 0;
                this.isAreaLocked_ = false;
                this.level_ = 0;
                this.maxBossChestNum_ = 0;
                this.resin_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return InvestigationMonsterOuterClass.internal_static_InvestigationMonster_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public InvestigationMonster getDefaultInstanceForType() {
                return InvestigationMonster.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public InvestigationMonster build() {
                InvestigationMonster result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public InvestigationMonster buildPartial() {
                InvestigationMonster result = new InvestigationMonster(this);
                result.isAlive_ = this.isAlive_;
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                result.sceneId_ = this.sceneId_;
                result.nextRefreshTime_ = this.nextRefreshTime_;
                result.cityId_ = this.cityId_;
                result.groupId_ = this.groupId_;
                result.nextBossChestRefreshTime_ = this.nextBossChestRefreshTime_;
                if (this.weeklyBossResinDiscountInfoBuilder_ == null) {
                    result.weeklyBossResinDiscountInfo_ = this.weeklyBossResinDiscountInfo_;
                } else {
                    result.weeklyBossResinDiscountInfo_ = this.weeklyBossResinDiscountInfoBuilder_.build();
                }
                result.bossChestNum_ = this.bossChestNum_;
                result.id_ = this.id_;
                result.monsterId_ = this.monsterId_;
                result.lockState_ = this.lockState_;
                result.refreshInterval_ = this.refreshInterval_;
                result.isAreaLocked_ = this.isAreaLocked_;
                result.level_ = this.level_;
                result.maxBossChestNum_ = this.maxBossChestNum_;
                result.resin_ = this.resin_;
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
                if (other instanceof InvestigationMonster) {
                    return mergeFrom((InvestigationMonster) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(InvestigationMonster other) {
                if (other == InvestigationMonster.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsAlive()) {
                    setIsAlive(other.getIsAlive());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (other.getNextRefreshTime() != 0) {
                    setNextRefreshTime(other.getNextRefreshTime());
                }
                if (other.getCityId() != 0) {
                    setCityId(other.getCityId());
                }
                if (other.getGroupId() != 0) {
                    setGroupId(other.getGroupId());
                }
                if (other.getNextBossChestRefreshTime() != 0) {
                    setNextBossChestRefreshTime(other.getNextBossChestRefreshTime());
                }
                if (other.hasWeeklyBossResinDiscountInfo()) {
                    mergeWeeklyBossResinDiscountInfo(other.getWeeklyBossResinDiscountInfo());
                }
                if (other.getBossChestNum() != 0) {
                    setBossChestNum(other.getBossChestNum());
                }
                if (other.getId() != 0) {
                    setId(other.getId());
                }
                if (other.getMonsterId() != 0) {
                    setMonsterId(other.getMonsterId());
                }
                if (other.lockState_ != 0) {
                    setLockStateValue(other.getLockStateValue());
                }
                if (other.getRefreshInterval() != 0) {
                    setRefreshInterval(other.getRefreshInterval());
                }
                if (other.getIsAreaLocked()) {
                    setIsAreaLocked(other.getIsAreaLocked());
                }
                if (other.getLevel() != 0) {
                    setLevel(other.getLevel());
                }
                if (other.getMaxBossChestNum() != 0) {
                    setMaxBossChestNum(other.getMaxBossChestNum());
                }
                if (other.getResin() != 0) {
                    setResin(other.getResin());
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
                InvestigationMonster parsedMessage = null;
                try {
                    try {
                        parsedMessage = InvestigationMonster.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (InvestigationMonster) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public boolean getIsAlive() {
                return this.isAlive_;
            }

            public Builder setIsAlive(boolean value) {
                this.isAlive_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAlive() {
                this.isAlive_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public VectorOuterClass.Vector getPos() {
                if (this.posBuilder_ == null) {
                    return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
                }
                return this.posBuilder_.getMessage();
            }

            public Builder setPos(VectorOuterClass.Vector value) {
                if (this.posBuilder_ != null) {
                    this.posBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.pos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.posBuilder_ == null) {
                    this.pos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.posBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePos(VectorOuterClass.Vector value) {
                if (this.posBuilder_ == null) {
                    if (this.pos_ != null) {
                        this.pos_ = VectorOuterClass.Vector.newBuilder(this.pos_).mergeFrom(value).buildPartial();
                    } else {
                        this.pos_ = value;
                    }
                    onChanged();
                } else {
                    this.posBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPos() {
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                    onChanged();
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getPosBuilder() {
                onChanged();
                return getPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
                if (this.posBuilder_ != null) {
                    return this.posBuilder_.getMessageOrBuilder();
                }
                return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getPosFieldBuilder() {
                if (this.posBuilder_ == null) {
                    this.posBuilder_ = new SingleFieldBuilderV3<>(getPos(), getParentForChildren(), isClean());
                    this.pos_ = null;
                }
                return this.posBuilder_;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
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

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
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

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public int getGroupId() {
                return this.groupId_;
            }

            public Builder setGroupId(int value) {
                this.groupId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGroupId() {
                this.groupId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public int getNextBossChestRefreshTime() {
                return this.nextBossChestRefreshTime_;
            }

            public Builder setNextBossChestRefreshTime(int value) {
                this.nextBossChestRefreshTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextBossChestRefreshTime() {
                this.nextBossChestRefreshTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public boolean hasWeeklyBossResinDiscountInfo() {
                return (this.weeklyBossResinDiscountInfoBuilder_ == null && this.weeklyBossResinDiscountInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo getWeeklyBossResinDiscountInfo() {
                if (this.weeklyBossResinDiscountInfoBuilder_ == null) {
                    return this.weeklyBossResinDiscountInfo_ == null ? WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.getDefaultInstance() : this.weeklyBossResinDiscountInfo_;
                }
                return this.weeklyBossResinDiscountInfoBuilder_.getMessage();
            }

            public Builder setWeeklyBossResinDiscountInfo(WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo value) {
                if (this.weeklyBossResinDiscountInfoBuilder_ != null) {
                    this.weeklyBossResinDiscountInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.weeklyBossResinDiscountInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setWeeklyBossResinDiscountInfo(WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.Builder builderForValue) {
                if (this.weeklyBossResinDiscountInfoBuilder_ == null) {
                    this.weeklyBossResinDiscountInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.weeklyBossResinDiscountInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeWeeklyBossResinDiscountInfo(WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo value) {
                if (this.weeklyBossResinDiscountInfoBuilder_ == null) {
                    if (this.weeklyBossResinDiscountInfo_ != null) {
                        this.weeklyBossResinDiscountInfo_ = WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.newBuilder(this.weeklyBossResinDiscountInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.weeklyBossResinDiscountInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.weeklyBossResinDiscountInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearWeeklyBossResinDiscountInfo() {
                if (this.weeklyBossResinDiscountInfoBuilder_ == null) {
                    this.weeklyBossResinDiscountInfo_ = null;
                    onChanged();
                } else {
                    this.weeklyBossResinDiscountInfo_ = null;
                    this.weeklyBossResinDiscountInfoBuilder_ = null;
                }
                return this;
            }

            public WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.Builder getWeeklyBossResinDiscountInfoBuilder() {
                onChanged();
                return getWeeklyBossResinDiscountInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder getWeeklyBossResinDiscountInfoOrBuilder() {
                if (this.weeklyBossResinDiscountInfoBuilder_ != null) {
                    return this.weeklyBossResinDiscountInfoBuilder_.getMessageOrBuilder();
                }
                return this.weeklyBossResinDiscountInfo_ == null ? WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.getDefaultInstance() : this.weeklyBossResinDiscountInfo_;
            }

            private SingleFieldBuilderV3<WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.Builder, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder> getWeeklyBossResinDiscountInfoFieldBuilder() {
                if (this.weeklyBossResinDiscountInfoBuilder_ == null) {
                    this.weeklyBossResinDiscountInfoBuilder_ = new SingleFieldBuilderV3<>(getWeeklyBossResinDiscountInfo(), getParentForChildren(), isClean());
                    this.weeklyBossResinDiscountInfo_ = null;
                }
                return this.weeklyBossResinDiscountInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public int getBossChestNum() {
                return this.bossChestNum_;
            }

            public Builder setBossChestNum(int value) {
                this.bossChestNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearBossChestNum() {
                this.bossChestNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public int getMonsterId() {
                return this.monsterId_;
            }

            public Builder setMonsterId(int value) {
                this.monsterId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMonsterId() {
                this.monsterId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public int getLockStateValue() {
                return this.lockState_;
            }

            public Builder setLockStateValue(int value) {
                this.lockState_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public LockState getLockState() {
                LockState result = LockState.valueOf(this.lockState_);
                return result == null ? LockState.UNRECOGNIZED : result;
            }

            public Builder setLockState(LockState value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.lockState_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearLockState() {
                this.lockState_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public int getRefreshInterval() {
                return this.refreshInterval_;
            }

            public Builder setRefreshInterval(int value) {
                this.refreshInterval_ = value;
                onChanged();
                return this;
            }

            public Builder clearRefreshInterval() {
                this.refreshInterval_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public boolean getIsAreaLocked() {
                return this.isAreaLocked_;
            }

            public Builder setIsAreaLocked(boolean value) {
                this.isAreaLocked_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAreaLocked() {
                this.isAreaLocked_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
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

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public int getMaxBossChestNum() {
                return this.maxBossChestNum_;
            }

            public Builder setMaxBossChestNum(int value) {
                this.maxBossChestNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxBossChestNum() {
                this.maxBossChestNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder
            public int getResin() {
                return this.resin_;
            }

            public Builder setResin(int value) {
                this.resin_ = value;
                onChanged();
                return this;
            }

            public Builder clearResin() {
                this.resin_ = 0;
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

        public static InvestigationMonster getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<InvestigationMonster> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<InvestigationMonster> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public InvestigationMonster getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
        WeeklyBossResinDiscountInfoOuterClass.getDescriptor();
    }
}
