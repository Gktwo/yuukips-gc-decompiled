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
import emu.grasscutter.net.proto.BreakoutActionOuterClass;
import emu.grasscutter.net.proto.BreakoutElementReactionCounterOuterClass;
import emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass;
import emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass;
import emu.grasscutter.net.proto.BreakoutSyncConnectUidInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutSnapShotOuterClass.class */
public final class BreakoutSnapShotOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016BreakoutSnapShot.proto\u001a\u0014BreakoutAction.proto\u001a$BreakoutElementReactionCounter.proto\u001a\u001cBreakoutPhysicalObject.proto\u001a\u0018BreakoutSpawnPoint.proto\u001a BreakoutSyncConnectUidInfo.proto\"É\u0005\n\u0010BreakoutSnapShot\u0012\u0018\n\u0010client_game_time\u0018\u0001 \u0001(\u0004\u0012\u0018\n\u0010server_game_time\u0018\u0002 \u0001(\u0004\u0012*\n\tball_list\u0018\u0003 \u0003(\u000b2\u0017.BreakoutPhysicalObject\u00125\n\u0014physical_object_list\u0018\u0004 \u0003(\u000b2\u0017.BreakoutPhysicalObject\u0012$\n\u000baction_list\u0018\u0005 \u0003(\u000b2\u000f.BreakoutAction\u0012\u0012\n\nwave_index\u0018\u0006 \u0001(\r\u0012\u0011\n\tis_finish\u0018\u0007 \u0001(\b\u0012\r\n\u0005score\u0018\b \u0001(\r\u0012\r\n\u0005combo\u0018\t \u0001(\r\u0012\u0011\n\tmax_combo\u0018\n \u0001(\r\u0012\u0012\n\nlife_count\u0018\u000b \u0001(\r\u0012\u0018\n\u0010wave_suite_index\u0018\f \u0001(\r\u0012-\n\u0010spawn_point_list\u0018\r \u0003(\u000b2\u0013.BreakoutSpawnPoint\u0012\u0019\n\u0011remaining_boss_hp\u0018\u000e \u0001(\r\u0012D\n\u001bbrick_element_reaction_list\u0018\u000f \u0003(\u000b2\u001f.BreakoutElementReactionCounter\u0012C\n\u001aball_element_reaction_list\u0018\u0010 \u0003(\u000b2\u001f.BreakoutElementReactionCounter\u00122\n\ruid_info_list\u0018\u0011 \u0003(\u000b2\u001b.BreakoutSyncConnectUidInfo\u00124\n\u0013dynamic_object_list\u0018\u0012 \u0003(\u000b2\u0017.BreakoutPhysicalObject\u0012\u0015\n\rid_index_list\u0018\u0013 \u0003(\r\u0012\u001c\n\u0014raw_client_game_time\u0018\u0014 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BreakoutActionOuterClass.getDescriptor(), BreakoutElementReactionCounterOuterClass.getDescriptor(), BreakoutPhysicalObjectOuterClass.getDescriptor(), BreakoutSpawnPointOuterClass.getDescriptor(), BreakoutSyncConnectUidInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BreakoutSnapShot_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BreakoutSnapShot_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BreakoutSnapShot_descriptor, new String[]{"ClientGameTime", "ServerGameTime", "BallList", "PhysicalObjectList", "ActionList", "WaveIndex", "IsFinish", "Score", "Combo", "MaxCombo", "LifeCount", "WaveSuiteIndex", "SpawnPointList", "RemainingBossHp", "BrickElementReactionList", "BallElementReactionList", "UidInfoList", "DynamicObjectList", "IdIndexList", "RawClientGameTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutSnapShotOuterClass$BreakoutSnapShotOrBuilder.class */
    public interface BreakoutSnapShotOrBuilder extends MessageOrBuilder {
        long getClientGameTime();

        long getServerGameTime();

        List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> getBallListList();

        BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject getBallList(int i);

        int getBallListCount();

        List<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getBallListOrBuilderList();

        BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder getBallListOrBuilder(int i);

        List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> getPhysicalObjectListList();

        BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject getPhysicalObjectList(int i);

        int getPhysicalObjectListCount();

        List<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getPhysicalObjectListOrBuilderList();

        BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder getPhysicalObjectListOrBuilder(int i);

        List<BreakoutActionOuterClass.BreakoutAction> getActionListList();

        BreakoutActionOuterClass.BreakoutAction getActionList(int i);

        int getActionListCount();

        List<? extends BreakoutActionOuterClass.BreakoutActionOrBuilder> getActionListOrBuilderList();

        BreakoutActionOuterClass.BreakoutActionOrBuilder getActionListOrBuilder(int i);

        int getWaveIndex();

        boolean getIsFinish();

        int getScore();

        int getCombo();

        int getMaxCombo();

        int getLifeCount();

        int getWaveSuiteIndex();

        List<BreakoutSpawnPointOuterClass.BreakoutSpawnPoint> getSpawnPointListList();

        BreakoutSpawnPointOuterClass.BreakoutSpawnPoint getSpawnPointList(int i);

        int getSpawnPointListCount();

        List<? extends BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder> getSpawnPointListOrBuilderList();

        BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder getSpawnPointListOrBuilder(int i);

        int getRemainingBossHp();

        List<BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter> getBrickElementReactionListList();

        BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter getBrickElementReactionList(int i);

        int getBrickElementReactionListCount();

        List<? extends BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder> getBrickElementReactionListOrBuilderList();

        BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder getBrickElementReactionListOrBuilder(int i);

        List<BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter> getBallElementReactionListList();

        BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter getBallElementReactionList(int i);

        int getBallElementReactionListCount();

        List<? extends BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder> getBallElementReactionListOrBuilderList();

        BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder getBallElementReactionListOrBuilder(int i);

        List<BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo> getUidInfoListList();

        BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo getUidInfoList(int i);

        int getUidInfoListCount();

        List<? extends BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder> getUidInfoListOrBuilderList();

        BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder getUidInfoListOrBuilder(int i);

        List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> getDynamicObjectListList();

        BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject getDynamicObjectList(int i);

        int getDynamicObjectListCount();

        List<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getDynamicObjectListOrBuilderList();

        BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder getDynamicObjectListOrBuilder(int i);

        List<Integer> getIdIndexListList();

        int getIdIndexListCount();

        int getIdIndexList(int i);

        int getRawClientGameTime();
    }

    private BreakoutSnapShotOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutSnapShotOuterClass$BreakoutSnapShot.class */
    public static final class BreakoutSnapShot extends GeneratedMessageV3 implements BreakoutSnapShotOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CLIENT_GAME_TIME_FIELD_NUMBER = 1;
        private long clientGameTime_;
        public static final int SERVER_GAME_TIME_FIELD_NUMBER = 2;
        private long serverGameTime_;
        public static final int BALL_LIST_FIELD_NUMBER = 3;
        private List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> ballList_;
        public static final int PHYSICAL_OBJECT_LIST_FIELD_NUMBER = 4;
        private List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> physicalObjectList_;
        public static final int ACTION_LIST_FIELD_NUMBER = 5;
        private List<BreakoutActionOuterClass.BreakoutAction> actionList_;
        public static final int WAVE_INDEX_FIELD_NUMBER = 6;
        private int waveIndex_;
        public static final int IS_FINISH_FIELD_NUMBER = 7;
        private boolean isFinish_;
        public static final int SCORE_FIELD_NUMBER = 8;
        private int score_;
        public static final int COMBO_FIELD_NUMBER = 9;
        private int combo_;
        public static final int MAX_COMBO_FIELD_NUMBER = 10;
        private int maxCombo_;
        public static final int LIFE_COUNT_FIELD_NUMBER = 11;
        private int lifeCount_;
        public static final int WAVE_SUITE_INDEX_FIELD_NUMBER = 12;
        private int waveSuiteIndex_;
        public static final int SPAWN_POINT_LIST_FIELD_NUMBER = 13;
        private List<BreakoutSpawnPointOuterClass.BreakoutSpawnPoint> spawnPointList_;
        public static final int REMAINING_BOSS_HP_FIELD_NUMBER = 14;
        private int remainingBossHp_;
        public static final int BRICK_ELEMENT_REACTION_LIST_FIELD_NUMBER = 15;
        private List<BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter> brickElementReactionList_;
        public static final int BALL_ELEMENT_REACTION_LIST_FIELD_NUMBER = 16;
        private List<BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter> ballElementReactionList_;
        public static final int UID_INFO_LIST_FIELD_NUMBER = 17;
        private List<BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo> uidInfoList_;
        public static final int DYNAMIC_OBJECT_LIST_FIELD_NUMBER = 18;
        private List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> dynamicObjectList_;
        public static final int ID_INDEX_LIST_FIELD_NUMBER = 19;
        private Internal.IntList idIndexList_;
        private int idIndexListMemoizedSerializedSize;
        public static final int RAW_CLIENT_GAME_TIME_FIELD_NUMBER = 20;
        private int rawClientGameTime_;
        private byte memoizedIsInitialized;
        private static final BreakoutSnapShot DEFAULT_INSTANCE = new BreakoutSnapShot();
        private static final Parser<BreakoutSnapShot> PARSER = new AbstractParser<BreakoutSnapShot>() { // from class: emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShot.1
            @Override // com.google.protobuf.Parser
            public BreakoutSnapShot parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BreakoutSnapShot(input, extensionRegistry);
            }
        };

        private BreakoutSnapShot(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.idIndexListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private BreakoutSnapShot() {
            this.idIndexListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.ballList_ = Collections.emptyList();
            this.physicalObjectList_ = Collections.emptyList();
            this.actionList_ = Collections.emptyList();
            this.spawnPointList_ = Collections.emptyList();
            this.brickElementReactionList_ = Collections.emptyList();
            this.ballElementReactionList_ = Collections.emptyList();
            this.uidInfoList_ = Collections.emptyList();
            this.dynamicObjectList_ = Collections.emptyList();
            this.idIndexList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BreakoutSnapShot();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:167:0x0352 */
        private BreakoutSnapShot(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.clientGameTime_ = input.readUInt64();
                                break;
                            case 16:
                                this.serverGameTime_ = input.readUInt64();
                                break;
                            case 26:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.ballList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.ballList_.add((BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject) input.readMessage(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.parser(), extensionRegistry));
                                break;
                            case 34:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.physicalObjectList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.physicalObjectList_.add((BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject) input.readMessage(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.parser(), extensionRegistry));
                                break;
                            case 42:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.actionList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.actionList_.add((BreakoutActionOuterClass.BreakoutAction) input.readMessage(BreakoutActionOuterClass.BreakoutAction.parser(), extensionRegistry));
                                break;
                            case 48:
                                this.waveIndex_ = input.readUInt32();
                                break;
                            case 56:
                                this.isFinish_ = input.readBool();
                                break;
                            case 64:
                                this.score_ = input.readUInt32();
                                break;
                            case 72:
                                this.combo_ = input.readUInt32();
                                break;
                            case 80:
                                this.maxCombo_ = input.readUInt32();
                                break;
                            case 88:
                                this.lifeCount_ = input.readUInt32();
                                break;
                            case 96:
                                this.waveSuiteIndex_ = input.readUInt32();
                                break;
                            case 106:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.spawnPointList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.spawnPointList_.add((BreakoutSpawnPointOuterClass.BreakoutSpawnPoint) input.readMessage(BreakoutSpawnPointOuterClass.BreakoutSpawnPoint.parser(), extensionRegistry));
                                break;
                            case 112:
                                this.remainingBossHp_ = input.readUInt32();
                                break;
                            case 122:
                                if ((mutable_bitField0_ & 16) == 0) {
                                    this.brickElementReactionList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                this.brickElementReactionList_.add((BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter) input.readMessage(BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.parser(), extensionRegistry));
                                break;
                            case 130:
                                if ((mutable_bitField0_ & 32) == 0) {
                                    this.ballElementReactionList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                }
                                this.ballElementReactionList_.add((BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter) input.readMessage(BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.parser(), extensionRegistry));
                                break;
                            case 138:
                                if ((mutable_bitField0_ & 64) == 0) {
                                    this.uidInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                }
                                this.uidInfoList_.add((BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo) input.readMessage(BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo.parser(), extensionRegistry));
                                break;
                            case 146:
                                if ((mutable_bitField0_ & 128) == 0) {
                                    this.dynamicObjectList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 128) == 1 ? 1 : 0;
                                }
                                this.dynamicObjectList_.add((BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject) input.readMessage(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.parser(), extensionRegistry));
                                break;
                            case 152:
                                if ((mutable_bitField0_ & 256) == 0) {
                                    this.idIndexList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 256) == 1 ? 1 : 0;
                                }
                                this.idIndexList_.addInt(input.readUInt32());
                                break;
                            case 154:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 256) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.idIndexList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 256) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.idIndexList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 160:
                                this.rawClientGameTime_ = input.readInt32();
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
                    this.ballList_ = Collections.unmodifiableList(this.ballList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.physicalObjectList_ = Collections.unmodifiableList(this.physicalObjectList_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.actionList_ = Collections.unmodifiableList(this.actionList_);
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.spawnPointList_ = Collections.unmodifiableList(this.spawnPointList_);
                }
                if ((mutable_bitField0_ & 16) != 0) {
                    this.brickElementReactionList_ = Collections.unmodifiableList(this.brickElementReactionList_);
                }
                if ((mutable_bitField0_ & 32) != 0) {
                    this.ballElementReactionList_ = Collections.unmodifiableList(this.ballElementReactionList_);
                }
                if ((mutable_bitField0_ & 64) != 0) {
                    this.uidInfoList_ = Collections.unmodifiableList(this.uidInfoList_);
                }
                if ((mutable_bitField0_ & 128) != 0) {
                    this.dynamicObjectList_ = Collections.unmodifiableList(this.dynamicObjectList_);
                }
                if ((mutable_bitField0_ & 256) != 0) {
                    this.idIndexList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BreakoutSnapShotOuterClass.internal_static_BreakoutSnapShot_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BreakoutSnapShotOuterClass.internal_static_BreakoutSnapShot_fieldAccessorTable.ensureFieldAccessorsInitialized(BreakoutSnapShot.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public long getClientGameTime() {
            return this.clientGameTime_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public long getServerGameTime() {
            return this.serverGameTime_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> getBallListList() {
            return this.ballList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getBallListOrBuilderList() {
            return this.ballList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getBallListCount() {
            return this.ballList_.size();
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject getBallList(int index) {
            return this.ballList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder getBallListOrBuilder(int index) {
            return this.ballList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> getPhysicalObjectListList() {
            return this.physicalObjectList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getPhysicalObjectListOrBuilderList() {
            return this.physicalObjectList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getPhysicalObjectListCount() {
            return this.physicalObjectList_.size();
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject getPhysicalObjectList(int index) {
            return this.physicalObjectList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder getPhysicalObjectListOrBuilder(int index) {
            return this.physicalObjectList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<BreakoutActionOuterClass.BreakoutAction> getActionListList() {
            return this.actionList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<? extends BreakoutActionOuterClass.BreakoutActionOrBuilder> getActionListOrBuilderList() {
            return this.actionList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getActionListCount() {
            return this.actionList_.size();
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public BreakoutActionOuterClass.BreakoutAction getActionList(int index) {
            return this.actionList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public BreakoutActionOuterClass.BreakoutActionOrBuilder getActionListOrBuilder(int index) {
            return this.actionList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getWaveIndex() {
            return this.waveIndex_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public boolean getIsFinish() {
            return this.isFinish_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getScore() {
            return this.score_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getCombo() {
            return this.combo_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getMaxCombo() {
            return this.maxCombo_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getLifeCount() {
            return this.lifeCount_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getWaveSuiteIndex() {
            return this.waveSuiteIndex_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<BreakoutSpawnPointOuterClass.BreakoutSpawnPoint> getSpawnPointListList() {
            return this.spawnPointList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<? extends BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder> getSpawnPointListOrBuilderList() {
            return this.spawnPointList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getSpawnPointListCount() {
            return this.spawnPointList_.size();
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public BreakoutSpawnPointOuterClass.BreakoutSpawnPoint getSpawnPointList(int index) {
            return this.spawnPointList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder getSpawnPointListOrBuilder(int index) {
            return this.spawnPointList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getRemainingBossHp() {
            return this.remainingBossHp_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter> getBrickElementReactionListList() {
            return this.brickElementReactionList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<? extends BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder> getBrickElementReactionListOrBuilderList() {
            return this.brickElementReactionList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getBrickElementReactionListCount() {
            return this.brickElementReactionList_.size();
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter getBrickElementReactionList(int index) {
            return this.brickElementReactionList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder getBrickElementReactionListOrBuilder(int index) {
            return this.brickElementReactionList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter> getBallElementReactionListList() {
            return this.ballElementReactionList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<? extends BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder> getBallElementReactionListOrBuilderList() {
            return this.ballElementReactionList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getBallElementReactionListCount() {
            return this.ballElementReactionList_.size();
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter getBallElementReactionList(int index) {
            return this.ballElementReactionList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder getBallElementReactionListOrBuilder(int index) {
            return this.ballElementReactionList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo> getUidInfoListList() {
            return this.uidInfoList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<? extends BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder> getUidInfoListOrBuilderList() {
            return this.uidInfoList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getUidInfoListCount() {
            return this.uidInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo getUidInfoList(int index) {
            return this.uidInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder getUidInfoListOrBuilder(int index) {
            return this.uidInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> getDynamicObjectListList() {
            return this.dynamicObjectList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getDynamicObjectListOrBuilderList() {
            return this.dynamicObjectList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getDynamicObjectListCount() {
            return this.dynamicObjectList_.size();
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject getDynamicObjectList(int index) {
            return this.dynamicObjectList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder getDynamicObjectListOrBuilder(int index) {
            return this.dynamicObjectList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public List<Integer> getIdIndexListList() {
            return this.idIndexList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getIdIndexListCount() {
            return this.idIndexList_.size();
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getIdIndexList(int index) {
            return this.idIndexList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
        public int getRawClientGameTime() {
            return this.rawClientGameTime_;
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
            if (this.clientGameTime_ != 0) {
                output.writeUInt64(1, this.clientGameTime_);
            }
            if (this.serverGameTime_ != 0) {
                output.writeUInt64(2, this.serverGameTime_);
            }
            for (int i = 0; i < this.ballList_.size(); i++) {
                output.writeMessage(3, this.ballList_.get(i));
            }
            for (int i2 = 0; i2 < this.physicalObjectList_.size(); i2++) {
                output.writeMessage(4, this.physicalObjectList_.get(i2));
            }
            for (int i3 = 0; i3 < this.actionList_.size(); i3++) {
                output.writeMessage(5, this.actionList_.get(i3));
            }
            if (this.waveIndex_ != 0) {
                output.writeUInt32(6, this.waveIndex_);
            }
            if (this.isFinish_) {
                output.writeBool(7, this.isFinish_);
            }
            if (this.score_ != 0) {
                output.writeUInt32(8, this.score_);
            }
            if (this.combo_ != 0) {
                output.writeUInt32(9, this.combo_);
            }
            if (this.maxCombo_ != 0) {
                output.writeUInt32(10, this.maxCombo_);
            }
            if (this.lifeCount_ != 0) {
                output.writeUInt32(11, this.lifeCount_);
            }
            if (this.waveSuiteIndex_ != 0) {
                output.writeUInt32(12, this.waveSuiteIndex_);
            }
            for (int i4 = 0; i4 < this.spawnPointList_.size(); i4++) {
                output.writeMessage(13, this.spawnPointList_.get(i4));
            }
            if (this.remainingBossHp_ != 0) {
                output.writeUInt32(14, this.remainingBossHp_);
            }
            for (int i5 = 0; i5 < this.brickElementReactionList_.size(); i5++) {
                output.writeMessage(15, this.brickElementReactionList_.get(i5));
            }
            for (int i6 = 0; i6 < this.ballElementReactionList_.size(); i6++) {
                output.writeMessage(16, this.ballElementReactionList_.get(i6));
            }
            for (int i7 = 0; i7 < this.uidInfoList_.size(); i7++) {
                output.writeMessage(17, this.uidInfoList_.get(i7));
            }
            for (int i8 = 0; i8 < this.dynamicObjectList_.size(); i8++) {
                output.writeMessage(18, this.dynamicObjectList_.get(i8));
            }
            if (getIdIndexListList().size() > 0) {
                output.writeUInt32NoTag(154);
                output.writeUInt32NoTag(this.idIndexListMemoizedSerializedSize);
            }
            for (int i9 = 0; i9 < this.idIndexList_.size(); i9++) {
                output.writeUInt32NoTag(this.idIndexList_.getInt(i9));
            }
            if (this.rawClientGameTime_ != 0) {
                output.writeInt32(20, this.rawClientGameTime_);
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
            if (this.clientGameTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(1, this.clientGameTime_);
            }
            if (this.serverGameTime_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(2, this.serverGameTime_);
            }
            for (int i = 0; i < this.ballList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.ballList_.get(i));
            }
            for (int i2 = 0; i2 < this.physicalObjectList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.physicalObjectList_.get(i2));
            }
            for (int i3 = 0; i3 < this.actionList_.size(); i3++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.actionList_.get(i3));
            }
            if (this.waveIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.waveIndex_);
            }
            if (this.isFinish_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.isFinish_);
            }
            if (this.score_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.score_);
            }
            if (this.combo_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.combo_);
            }
            if (this.maxCombo_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.maxCombo_);
            }
            if (this.lifeCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.lifeCount_);
            }
            if (this.waveSuiteIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.waveSuiteIndex_);
            }
            for (int i4 = 0; i4 < this.spawnPointList_.size(); i4++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.spawnPointList_.get(i4));
            }
            if (this.remainingBossHp_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.remainingBossHp_);
            }
            for (int i5 = 0; i5 < this.brickElementReactionList_.size(); i5++) {
                size2 += CodedOutputStream.computeMessageSize(15, this.brickElementReactionList_.get(i5));
            }
            for (int i6 = 0; i6 < this.ballElementReactionList_.size(); i6++) {
                size2 += CodedOutputStream.computeMessageSize(16, this.ballElementReactionList_.get(i6));
            }
            for (int i7 = 0; i7 < this.uidInfoList_.size(); i7++) {
                size2 += CodedOutputStream.computeMessageSize(17, this.uidInfoList_.get(i7));
            }
            for (int i8 = 0; i8 < this.dynamicObjectList_.size(); i8++) {
                size2 += CodedOutputStream.computeMessageSize(18, this.dynamicObjectList_.get(i8));
            }
            int dataSize = 0;
            for (int i9 = 0; i9 < this.idIndexList_.size(); i9++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.idIndexList_.getInt(i9));
            }
            int size3 = size2 + dataSize;
            if (!getIdIndexListList().isEmpty()) {
                size3 = size3 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.idIndexListMemoizedSerializedSize = dataSize;
            if (this.rawClientGameTime_ != 0) {
                size3 += CodedOutputStream.computeInt32Size(20, this.rawClientGameTime_);
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
            if (!(obj instanceof BreakoutSnapShot)) {
                return equals(obj);
            }
            BreakoutSnapShot other = (BreakoutSnapShot) obj;
            return getClientGameTime() == other.getClientGameTime() && getServerGameTime() == other.getServerGameTime() && getBallListList().equals(other.getBallListList()) && getPhysicalObjectListList().equals(other.getPhysicalObjectListList()) && getActionListList().equals(other.getActionListList()) && getWaveIndex() == other.getWaveIndex() && getIsFinish() == other.getIsFinish() && getScore() == other.getScore() && getCombo() == other.getCombo() && getMaxCombo() == other.getMaxCombo() && getLifeCount() == other.getLifeCount() && getWaveSuiteIndex() == other.getWaveSuiteIndex() && getSpawnPointListList().equals(other.getSpawnPointListList()) && getRemainingBossHp() == other.getRemainingBossHp() && getBrickElementReactionListList().equals(other.getBrickElementReactionListList()) && getBallElementReactionListList().equals(other.getBallElementReactionListList()) && getUidInfoListList().equals(other.getUidInfoListList()) && getDynamicObjectListList().equals(other.getDynamicObjectListList()) && getIdIndexListList().equals(other.getIdIndexListList()) && getRawClientGameTime() == other.getRawClientGameTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Internal.hashLong(getClientGameTime()))) + 2)) + Internal.hashLong(getServerGameTime());
            if (getBallListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getBallListList().hashCode();
            }
            if (getPhysicalObjectListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getPhysicalObjectListList().hashCode();
            }
            if (getActionListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getActionListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 6)) + getWaveIndex())) + 7)) + Internal.hashBoolean(getIsFinish()))) + 8)) + getScore())) + 9)) + getCombo())) + 10)) + getMaxCombo())) + 11)) + getLifeCount())) + 12)) + getWaveSuiteIndex();
            if (getSpawnPointListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 13)) + getSpawnPointListList().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 14)) + getRemainingBossHp();
            if (getBrickElementReactionListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 15)) + getBrickElementReactionListList().hashCode();
            }
            if (getBallElementReactionListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 16)) + getBallElementReactionListList().hashCode();
            }
            if (getUidInfoListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 17)) + getUidInfoListList().hashCode();
            }
            if (getDynamicObjectListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 18)) + getDynamicObjectListList().hashCode();
            }
            if (getIdIndexListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 19)) + getIdIndexListList().hashCode();
            }
            int hash4 = (29 * ((53 * ((37 * hash3) + 20)) + getRawClientGameTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static BreakoutSnapShot parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutSnapShot parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutSnapShot parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutSnapShot parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutSnapShot parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutSnapShot parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutSnapShot parseFrom(InputStream input) throws IOException {
            return (BreakoutSnapShot) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutSnapShot parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutSnapShot) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutSnapShot parseDelimitedFrom(InputStream input) throws IOException {
            return (BreakoutSnapShot) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BreakoutSnapShot parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutSnapShot) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutSnapShot parseFrom(CodedInputStream input) throws IOException {
            return (BreakoutSnapShot) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutSnapShot parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutSnapShot) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BreakoutSnapShot prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutSnapShotOuterClass$BreakoutSnapShot$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BreakoutSnapShotOrBuilder {
            private int bitField0_;
            private long clientGameTime_;
            private long serverGameTime_;
            private RepeatedFieldBuilderV3<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> ballListBuilder_;
            private RepeatedFieldBuilderV3<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> physicalObjectListBuilder_;
            private RepeatedFieldBuilderV3<BreakoutActionOuterClass.BreakoutAction, BreakoutActionOuterClass.BreakoutAction.Builder, BreakoutActionOuterClass.BreakoutActionOrBuilder> actionListBuilder_;
            private int waveIndex_;
            private boolean isFinish_;
            private int score_;
            private int combo_;
            private int maxCombo_;
            private int lifeCount_;
            private int waveSuiteIndex_;
            private RepeatedFieldBuilderV3<BreakoutSpawnPointOuterClass.BreakoutSpawnPoint, BreakoutSpawnPointOuterClass.BreakoutSpawnPoint.Builder, BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder> spawnPointListBuilder_;
            private int remainingBossHp_;
            private RepeatedFieldBuilderV3<BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder> brickElementReactionListBuilder_;
            private RepeatedFieldBuilderV3<BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder> ballElementReactionListBuilder_;
            private RepeatedFieldBuilderV3<BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo, BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo.Builder, BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder> uidInfoListBuilder_;
            private RepeatedFieldBuilderV3<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> dynamicObjectListBuilder_;
            private int rawClientGameTime_;
            private List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> ballList_ = Collections.emptyList();
            private List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> physicalObjectList_ = Collections.emptyList();
            private List<BreakoutActionOuterClass.BreakoutAction> actionList_ = Collections.emptyList();
            private List<BreakoutSpawnPointOuterClass.BreakoutSpawnPoint> spawnPointList_ = Collections.emptyList();
            private List<BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter> brickElementReactionList_ = Collections.emptyList();
            private List<BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter> ballElementReactionList_ = Collections.emptyList();
            private List<BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo> uidInfoList_ = Collections.emptyList();
            private List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> dynamicObjectList_ = Collections.emptyList();
            private Internal.IntList idIndexList_ = BreakoutSnapShot.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return BreakoutSnapShotOuterClass.internal_static_BreakoutSnapShot_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BreakoutSnapShotOuterClass.internal_static_BreakoutSnapShot_fieldAccessorTable.ensureFieldAccessorsInitialized(BreakoutSnapShot.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BreakoutSnapShot.alwaysUseFieldBuilders) {
                    getBallListFieldBuilder();
                    getPhysicalObjectListFieldBuilder();
                    getActionListFieldBuilder();
                    getSpawnPointListFieldBuilder();
                    getBrickElementReactionListFieldBuilder();
                    getBallElementReactionListFieldBuilder();
                    getUidInfoListFieldBuilder();
                    getDynamicObjectListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.clientGameTime_ = 0;
                this.serverGameTime_ = 0;
                if (this.ballListBuilder_ == null) {
                    this.ballList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.ballListBuilder_.clear();
                }
                if (this.physicalObjectListBuilder_ == null) {
                    this.physicalObjectList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.physicalObjectListBuilder_.clear();
                }
                if (this.actionListBuilder_ == null) {
                    this.actionList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.actionListBuilder_.clear();
                }
                this.waveIndex_ = 0;
                this.isFinish_ = false;
                this.score_ = 0;
                this.combo_ = 0;
                this.maxCombo_ = 0;
                this.lifeCount_ = 0;
                this.waveSuiteIndex_ = 0;
                if (this.spawnPointListBuilder_ == null) {
                    this.spawnPointList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.spawnPointListBuilder_.clear();
                }
                this.remainingBossHp_ = 0;
                if (this.brickElementReactionListBuilder_ == null) {
                    this.brickElementReactionList_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    this.brickElementReactionListBuilder_.clear();
                }
                if (this.ballElementReactionListBuilder_ == null) {
                    this.ballElementReactionList_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                } else {
                    this.ballElementReactionListBuilder_.clear();
                }
                if (this.uidInfoListBuilder_ == null) {
                    this.uidInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                } else {
                    this.uidInfoListBuilder_.clear();
                }
                if (this.dynamicObjectListBuilder_ == null) {
                    this.dynamicObjectList_ = Collections.emptyList();
                    this.bitField0_ &= -129;
                } else {
                    this.dynamicObjectListBuilder_.clear();
                }
                this.idIndexList_ = BreakoutSnapShot.emptyIntList();
                this.bitField0_ &= -257;
                this.rawClientGameTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BreakoutSnapShotOuterClass.internal_static_BreakoutSnapShot_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BreakoutSnapShot getDefaultInstanceForType() {
                return BreakoutSnapShot.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutSnapShot build() {
                BreakoutSnapShot result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutSnapShot buildPartial() {
                BreakoutSnapShot result = new BreakoutSnapShot(this);
                int i = this.bitField0_;
                result.clientGameTime_ = this.clientGameTime_;
                result.serverGameTime_ = this.serverGameTime_;
                if (this.ballListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.ballList_ = Collections.unmodifiableList(this.ballList_);
                        this.bitField0_ &= -2;
                    }
                    result.ballList_ = this.ballList_;
                } else {
                    result.ballList_ = this.ballListBuilder_.build();
                }
                if (this.physicalObjectListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.physicalObjectList_ = Collections.unmodifiableList(this.physicalObjectList_);
                        this.bitField0_ &= -3;
                    }
                    result.physicalObjectList_ = this.physicalObjectList_;
                } else {
                    result.physicalObjectList_ = this.physicalObjectListBuilder_.build();
                }
                if (this.actionListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.actionList_ = Collections.unmodifiableList(this.actionList_);
                        this.bitField0_ &= -5;
                    }
                    result.actionList_ = this.actionList_;
                } else {
                    result.actionList_ = this.actionListBuilder_.build();
                }
                result.waveIndex_ = this.waveIndex_;
                result.isFinish_ = this.isFinish_;
                result.score_ = this.score_;
                result.combo_ = this.combo_;
                result.maxCombo_ = this.maxCombo_;
                result.lifeCount_ = this.lifeCount_;
                result.waveSuiteIndex_ = this.waveSuiteIndex_;
                if (this.spawnPointListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.spawnPointList_ = Collections.unmodifiableList(this.spawnPointList_);
                        this.bitField0_ &= -9;
                    }
                    result.spawnPointList_ = this.spawnPointList_;
                } else {
                    result.spawnPointList_ = this.spawnPointListBuilder_.build();
                }
                result.remainingBossHp_ = this.remainingBossHp_;
                if (this.brickElementReactionListBuilder_ == null) {
                    if ((this.bitField0_ & 16) != 0) {
                        this.brickElementReactionList_ = Collections.unmodifiableList(this.brickElementReactionList_);
                        this.bitField0_ &= -17;
                    }
                    result.brickElementReactionList_ = this.brickElementReactionList_;
                } else {
                    result.brickElementReactionList_ = this.brickElementReactionListBuilder_.build();
                }
                if (this.ballElementReactionListBuilder_ == null) {
                    if ((this.bitField0_ & 32) != 0) {
                        this.ballElementReactionList_ = Collections.unmodifiableList(this.ballElementReactionList_);
                        this.bitField0_ &= -33;
                    }
                    result.ballElementReactionList_ = this.ballElementReactionList_;
                } else {
                    result.ballElementReactionList_ = this.ballElementReactionListBuilder_.build();
                }
                if (this.uidInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 64) != 0) {
                        this.uidInfoList_ = Collections.unmodifiableList(this.uidInfoList_);
                        this.bitField0_ &= -65;
                    }
                    result.uidInfoList_ = this.uidInfoList_;
                } else {
                    result.uidInfoList_ = this.uidInfoListBuilder_.build();
                }
                if (this.dynamicObjectListBuilder_ == null) {
                    if ((this.bitField0_ & 128) != 0) {
                        this.dynamicObjectList_ = Collections.unmodifiableList(this.dynamicObjectList_);
                        this.bitField0_ &= -129;
                    }
                    result.dynamicObjectList_ = this.dynamicObjectList_;
                } else {
                    result.dynamicObjectList_ = this.dynamicObjectListBuilder_.build();
                }
                if ((this.bitField0_ & 256) != 0) {
                    this.idIndexList_.makeImmutable();
                    this.bitField0_ &= -257;
                }
                result.idIndexList_ = this.idIndexList_;
                result.rawClientGameTime_ = this.rawClientGameTime_;
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
                if (other instanceof BreakoutSnapShot) {
                    return mergeFrom((BreakoutSnapShot) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BreakoutSnapShot other) {
                if (other == BreakoutSnapShot.getDefaultInstance()) {
                    return this;
                }
                if (other.getClientGameTime() != 0) {
                    setClientGameTime(other.getClientGameTime());
                }
                if (other.getServerGameTime() != 0) {
                    setServerGameTime(other.getServerGameTime());
                }
                if (this.ballListBuilder_ == null) {
                    if (!other.ballList_.isEmpty()) {
                        if (this.ballList_.isEmpty()) {
                            this.ballList_ = other.ballList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureBallListIsMutable();
                            this.ballList_.addAll(other.ballList_);
                        }
                        onChanged();
                    }
                } else if (!other.ballList_.isEmpty()) {
                    if (this.ballListBuilder_.isEmpty()) {
                        this.ballListBuilder_.dispose();
                        this.ballListBuilder_ = null;
                        this.ballList_ = other.ballList_;
                        this.bitField0_ &= -2;
                        this.ballListBuilder_ = BreakoutSnapShot.alwaysUseFieldBuilders ? getBallListFieldBuilder() : null;
                    } else {
                        this.ballListBuilder_.addAllMessages(other.ballList_);
                    }
                }
                if (this.physicalObjectListBuilder_ == null) {
                    if (!other.physicalObjectList_.isEmpty()) {
                        if (this.physicalObjectList_.isEmpty()) {
                            this.physicalObjectList_ = other.physicalObjectList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensurePhysicalObjectListIsMutable();
                            this.physicalObjectList_.addAll(other.physicalObjectList_);
                        }
                        onChanged();
                    }
                } else if (!other.physicalObjectList_.isEmpty()) {
                    if (this.physicalObjectListBuilder_.isEmpty()) {
                        this.physicalObjectListBuilder_.dispose();
                        this.physicalObjectListBuilder_ = null;
                        this.physicalObjectList_ = other.physicalObjectList_;
                        this.bitField0_ &= -3;
                        this.physicalObjectListBuilder_ = BreakoutSnapShot.alwaysUseFieldBuilders ? getPhysicalObjectListFieldBuilder() : null;
                    } else {
                        this.physicalObjectListBuilder_.addAllMessages(other.physicalObjectList_);
                    }
                }
                if (this.actionListBuilder_ == null) {
                    if (!other.actionList_.isEmpty()) {
                        if (this.actionList_.isEmpty()) {
                            this.actionList_ = other.actionList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureActionListIsMutable();
                            this.actionList_.addAll(other.actionList_);
                        }
                        onChanged();
                    }
                } else if (!other.actionList_.isEmpty()) {
                    if (this.actionListBuilder_.isEmpty()) {
                        this.actionListBuilder_.dispose();
                        this.actionListBuilder_ = null;
                        this.actionList_ = other.actionList_;
                        this.bitField0_ &= -5;
                        this.actionListBuilder_ = BreakoutSnapShot.alwaysUseFieldBuilders ? getActionListFieldBuilder() : null;
                    } else {
                        this.actionListBuilder_.addAllMessages(other.actionList_);
                    }
                }
                if (other.getWaveIndex() != 0) {
                    setWaveIndex(other.getWaveIndex());
                }
                if (other.getIsFinish()) {
                    setIsFinish(other.getIsFinish());
                }
                if (other.getScore() != 0) {
                    setScore(other.getScore());
                }
                if (other.getCombo() != 0) {
                    setCombo(other.getCombo());
                }
                if (other.getMaxCombo() != 0) {
                    setMaxCombo(other.getMaxCombo());
                }
                if (other.getLifeCount() != 0) {
                    setLifeCount(other.getLifeCount());
                }
                if (other.getWaveSuiteIndex() != 0) {
                    setWaveSuiteIndex(other.getWaveSuiteIndex());
                }
                if (this.spawnPointListBuilder_ == null) {
                    if (!other.spawnPointList_.isEmpty()) {
                        if (this.spawnPointList_.isEmpty()) {
                            this.spawnPointList_ = other.spawnPointList_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureSpawnPointListIsMutable();
                            this.spawnPointList_.addAll(other.spawnPointList_);
                        }
                        onChanged();
                    }
                } else if (!other.spawnPointList_.isEmpty()) {
                    if (this.spawnPointListBuilder_.isEmpty()) {
                        this.spawnPointListBuilder_.dispose();
                        this.spawnPointListBuilder_ = null;
                        this.spawnPointList_ = other.spawnPointList_;
                        this.bitField0_ &= -9;
                        this.spawnPointListBuilder_ = BreakoutSnapShot.alwaysUseFieldBuilders ? getSpawnPointListFieldBuilder() : null;
                    } else {
                        this.spawnPointListBuilder_.addAllMessages(other.spawnPointList_);
                    }
                }
                if (other.getRemainingBossHp() != 0) {
                    setRemainingBossHp(other.getRemainingBossHp());
                }
                if (this.brickElementReactionListBuilder_ == null) {
                    if (!other.brickElementReactionList_.isEmpty()) {
                        if (this.brickElementReactionList_.isEmpty()) {
                            this.brickElementReactionList_ = other.brickElementReactionList_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureBrickElementReactionListIsMutable();
                            this.brickElementReactionList_.addAll(other.brickElementReactionList_);
                        }
                        onChanged();
                    }
                } else if (!other.brickElementReactionList_.isEmpty()) {
                    if (this.brickElementReactionListBuilder_.isEmpty()) {
                        this.brickElementReactionListBuilder_.dispose();
                        this.brickElementReactionListBuilder_ = null;
                        this.brickElementReactionList_ = other.brickElementReactionList_;
                        this.bitField0_ &= -17;
                        this.brickElementReactionListBuilder_ = BreakoutSnapShot.alwaysUseFieldBuilders ? getBrickElementReactionListFieldBuilder() : null;
                    } else {
                        this.brickElementReactionListBuilder_.addAllMessages(other.brickElementReactionList_);
                    }
                }
                if (this.ballElementReactionListBuilder_ == null) {
                    if (!other.ballElementReactionList_.isEmpty()) {
                        if (this.ballElementReactionList_.isEmpty()) {
                            this.ballElementReactionList_ = other.ballElementReactionList_;
                            this.bitField0_ &= -33;
                        } else {
                            ensureBallElementReactionListIsMutable();
                            this.ballElementReactionList_.addAll(other.ballElementReactionList_);
                        }
                        onChanged();
                    }
                } else if (!other.ballElementReactionList_.isEmpty()) {
                    if (this.ballElementReactionListBuilder_.isEmpty()) {
                        this.ballElementReactionListBuilder_.dispose();
                        this.ballElementReactionListBuilder_ = null;
                        this.ballElementReactionList_ = other.ballElementReactionList_;
                        this.bitField0_ &= -33;
                        this.ballElementReactionListBuilder_ = BreakoutSnapShot.alwaysUseFieldBuilders ? getBallElementReactionListFieldBuilder() : null;
                    } else {
                        this.ballElementReactionListBuilder_.addAllMessages(other.ballElementReactionList_);
                    }
                }
                if (this.uidInfoListBuilder_ == null) {
                    if (!other.uidInfoList_.isEmpty()) {
                        if (this.uidInfoList_.isEmpty()) {
                            this.uidInfoList_ = other.uidInfoList_;
                            this.bitField0_ &= -65;
                        } else {
                            ensureUidInfoListIsMutable();
                            this.uidInfoList_.addAll(other.uidInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.uidInfoList_.isEmpty()) {
                    if (this.uidInfoListBuilder_.isEmpty()) {
                        this.uidInfoListBuilder_.dispose();
                        this.uidInfoListBuilder_ = null;
                        this.uidInfoList_ = other.uidInfoList_;
                        this.bitField0_ &= -65;
                        this.uidInfoListBuilder_ = BreakoutSnapShot.alwaysUseFieldBuilders ? getUidInfoListFieldBuilder() : null;
                    } else {
                        this.uidInfoListBuilder_.addAllMessages(other.uidInfoList_);
                    }
                }
                if (this.dynamicObjectListBuilder_ == null) {
                    if (!other.dynamicObjectList_.isEmpty()) {
                        if (this.dynamicObjectList_.isEmpty()) {
                            this.dynamicObjectList_ = other.dynamicObjectList_;
                            this.bitField0_ &= -129;
                        } else {
                            ensureDynamicObjectListIsMutable();
                            this.dynamicObjectList_.addAll(other.dynamicObjectList_);
                        }
                        onChanged();
                    }
                } else if (!other.dynamicObjectList_.isEmpty()) {
                    if (this.dynamicObjectListBuilder_.isEmpty()) {
                        this.dynamicObjectListBuilder_.dispose();
                        this.dynamicObjectListBuilder_ = null;
                        this.dynamicObjectList_ = other.dynamicObjectList_;
                        this.bitField0_ &= -129;
                        this.dynamicObjectListBuilder_ = BreakoutSnapShot.alwaysUseFieldBuilders ? getDynamicObjectListFieldBuilder() : null;
                    } else {
                        this.dynamicObjectListBuilder_.addAllMessages(other.dynamicObjectList_);
                    }
                }
                if (!other.idIndexList_.isEmpty()) {
                    if (this.idIndexList_.isEmpty()) {
                        this.idIndexList_ = other.idIndexList_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureIdIndexListIsMutable();
                        this.idIndexList_.addAll(other.idIndexList_);
                    }
                    onChanged();
                }
                if (other.getRawClientGameTime() != 0) {
                    setRawClientGameTime(other.getRawClientGameTime());
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
                BreakoutSnapShot parsedMessage = null;
                try {
                    try {
                        parsedMessage = BreakoutSnapShot.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BreakoutSnapShot) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public long getClientGameTime() {
                return this.clientGameTime_;
            }

            public Builder setClientGameTime(long value) {
                this.clientGameTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientGameTime() {
                this.clientGameTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public long getServerGameTime() {
                return this.serverGameTime_;
            }

            public Builder setServerGameTime(long value) {
                this.serverGameTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearServerGameTime() {
                this.serverGameTime_ = 0;
                onChanged();
                return this;
            }

            private void ensureBallListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.ballList_ = new ArrayList(this.ballList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> getBallListList() {
                if (this.ballListBuilder_ == null) {
                    return Collections.unmodifiableList(this.ballList_);
                }
                return this.ballListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getBallListCount() {
                if (this.ballListBuilder_ == null) {
                    return this.ballList_.size();
                }
                return this.ballListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject getBallList(int index) {
                if (this.ballListBuilder_ == null) {
                    return this.ballList_.get(index);
                }
                return this.ballListBuilder_.getMessage(index);
            }

            public Builder setBallList(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject value) {
                if (this.ballListBuilder_ != null) {
                    this.ballListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBallListIsMutable();
                    this.ballList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setBallList(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder builderForValue) {
                if (this.ballListBuilder_ == null) {
                    ensureBallListIsMutable();
                    this.ballList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.ballListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBallList(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject value) {
                if (this.ballListBuilder_ != null) {
                    this.ballListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBallListIsMutable();
                    this.ballList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addBallList(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject value) {
                if (this.ballListBuilder_ != null) {
                    this.ballListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBallListIsMutable();
                    this.ballList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addBallList(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder builderForValue) {
                if (this.ballListBuilder_ == null) {
                    ensureBallListIsMutable();
                    this.ballList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.ballListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBallList(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder builderForValue) {
                if (this.ballListBuilder_ == null) {
                    ensureBallListIsMutable();
                    this.ballList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.ballListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBallList(Iterable<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> values) {
                if (this.ballListBuilder_ == null) {
                    ensureBallListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.ballList_);
                    onChanged();
                } else {
                    this.ballListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBallList() {
                if (this.ballListBuilder_ == null) {
                    this.ballList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.ballListBuilder_.clear();
                }
                return this;
            }

            public Builder removeBallList(int index) {
                if (this.ballListBuilder_ == null) {
                    ensureBallListIsMutable();
                    this.ballList_.remove(index);
                    onChanged();
                } else {
                    this.ballListBuilder_.remove(index);
                }
                return this;
            }

            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder getBallListBuilder(int index) {
                return getBallListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder getBallListOrBuilder(int index) {
                if (this.ballListBuilder_ == null) {
                    return this.ballList_.get(index);
                }
                return this.ballListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getBallListOrBuilderList() {
                if (this.ballListBuilder_ != null) {
                    return this.ballListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.ballList_);
            }

            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder addBallListBuilder() {
                return getBallListFieldBuilder().addBuilder(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.getDefaultInstance());
            }

            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder addBallListBuilder(int index) {
                return getBallListFieldBuilder().addBuilder(index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.getDefaultInstance());
            }

            public List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder> getBallListBuilderList() {
                return getBallListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getBallListFieldBuilder() {
                if (this.ballListBuilder_ == null) {
                    this.ballListBuilder_ = new RepeatedFieldBuilderV3<>(this.ballList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.ballList_ = null;
                }
                return this.ballListBuilder_;
            }

            private void ensurePhysicalObjectListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.physicalObjectList_ = new ArrayList(this.physicalObjectList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> getPhysicalObjectListList() {
                if (this.physicalObjectListBuilder_ == null) {
                    return Collections.unmodifiableList(this.physicalObjectList_);
                }
                return this.physicalObjectListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getPhysicalObjectListCount() {
                if (this.physicalObjectListBuilder_ == null) {
                    return this.physicalObjectList_.size();
                }
                return this.physicalObjectListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject getPhysicalObjectList(int index) {
                if (this.physicalObjectListBuilder_ == null) {
                    return this.physicalObjectList_.get(index);
                }
                return this.physicalObjectListBuilder_.getMessage(index);
            }

            public Builder setPhysicalObjectList(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject value) {
                if (this.physicalObjectListBuilder_ != null) {
                    this.physicalObjectListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePhysicalObjectListIsMutable();
                    this.physicalObjectList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPhysicalObjectList(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder builderForValue) {
                if (this.physicalObjectListBuilder_ == null) {
                    ensurePhysicalObjectListIsMutable();
                    this.physicalObjectList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.physicalObjectListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPhysicalObjectList(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject value) {
                if (this.physicalObjectListBuilder_ != null) {
                    this.physicalObjectListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePhysicalObjectListIsMutable();
                    this.physicalObjectList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPhysicalObjectList(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject value) {
                if (this.physicalObjectListBuilder_ != null) {
                    this.physicalObjectListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePhysicalObjectListIsMutable();
                    this.physicalObjectList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPhysicalObjectList(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder builderForValue) {
                if (this.physicalObjectListBuilder_ == null) {
                    ensurePhysicalObjectListIsMutable();
                    this.physicalObjectList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.physicalObjectListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPhysicalObjectList(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder builderForValue) {
                if (this.physicalObjectListBuilder_ == null) {
                    ensurePhysicalObjectListIsMutable();
                    this.physicalObjectList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.physicalObjectListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPhysicalObjectList(Iterable<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> values) {
                if (this.physicalObjectListBuilder_ == null) {
                    ensurePhysicalObjectListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.physicalObjectList_);
                    onChanged();
                } else {
                    this.physicalObjectListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPhysicalObjectList() {
                if (this.physicalObjectListBuilder_ == null) {
                    this.physicalObjectList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.physicalObjectListBuilder_.clear();
                }
                return this;
            }

            public Builder removePhysicalObjectList(int index) {
                if (this.physicalObjectListBuilder_ == null) {
                    ensurePhysicalObjectListIsMutable();
                    this.physicalObjectList_.remove(index);
                    onChanged();
                } else {
                    this.physicalObjectListBuilder_.remove(index);
                }
                return this;
            }

            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder getPhysicalObjectListBuilder(int index) {
                return getPhysicalObjectListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder getPhysicalObjectListOrBuilder(int index) {
                if (this.physicalObjectListBuilder_ == null) {
                    return this.physicalObjectList_.get(index);
                }
                return this.physicalObjectListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getPhysicalObjectListOrBuilderList() {
                if (this.physicalObjectListBuilder_ != null) {
                    return this.physicalObjectListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.physicalObjectList_);
            }

            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder addPhysicalObjectListBuilder() {
                return getPhysicalObjectListFieldBuilder().addBuilder(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.getDefaultInstance());
            }

            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder addPhysicalObjectListBuilder(int index) {
                return getPhysicalObjectListFieldBuilder().addBuilder(index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.getDefaultInstance());
            }

            public List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder> getPhysicalObjectListBuilderList() {
                return getPhysicalObjectListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getPhysicalObjectListFieldBuilder() {
                if (this.physicalObjectListBuilder_ == null) {
                    this.physicalObjectListBuilder_ = new RepeatedFieldBuilderV3<>(this.physicalObjectList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.physicalObjectList_ = null;
                }
                return this.physicalObjectListBuilder_;
            }

            private void ensureActionListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.actionList_ = new ArrayList(this.actionList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<BreakoutActionOuterClass.BreakoutAction> getActionListList() {
                if (this.actionListBuilder_ == null) {
                    return Collections.unmodifiableList(this.actionList_);
                }
                return this.actionListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getActionListCount() {
                if (this.actionListBuilder_ == null) {
                    return this.actionList_.size();
                }
                return this.actionListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public BreakoutActionOuterClass.BreakoutAction getActionList(int index) {
                if (this.actionListBuilder_ == null) {
                    return this.actionList_.get(index);
                }
                return this.actionListBuilder_.getMessage(index);
            }

            public Builder setActionList(int index, BreakoutActionOuterClass.BreakoutAction value) {
                if (this.actionListBuilder_ != null) {
                    this.actionListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureActionListIsMutable();
                    this.actionList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setActionList(int index, BreakoutActionOuterClass.BreakoutAction.Builder builderForValue) {
                if (this.actionListBuilder_ == null) {
                    ensureActionListIsMutable();
                    this.actionList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.actionListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addActionList(BreakoutActionOuterClass.BreakoutAction value) {
                if (this.actionListBuilder_ != null) {
                    this.actionListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureActionListIsMutable();
                    this.actionList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addActionList(int index, BreakoutActionOuterClass.BreakoutAction value) {
                if (this.actionListBuilder_ != null) {
                    this.actionListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureActionListIsMutable();
                    this.actionList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addActionList(BreakoutActionOuterClass.BreakoutAction.Builder builderForValue) {
                if (this.actionListBuilder_ == null) {
                    ensureActionListIsMutable();
                    this.actionList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.actionListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addActionList(int index, BreakoutActionOuterClass.BreakoutAction.Builder builderForValue) {
                if (this.actionListBuilder_ == null) {
                    ensureActionListIsMutable();
                    this.actionList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.actionListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllActionList(Iterable<? extends BreakoutActionOuterClass.BreakoutAction> values) {
                if (this.actionListBuilder_ == null) {
                    ensureActionListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.actionList_);
                    onChanged();
                } else {
                    this.actionListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearActionList() {
                if (this.actionListBuilder_ == null) {
                    this.actionList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.actionListBuilder_.clear();
                }
                return this;
            }

            public Builder removeActionList(int index) {
                if (this.actionListBuilder_ == null) {
                    ensureActionListIsMutable();
                    this.actionList_.remove(index);
                    onChanged();
                } else {
                    this.actionListBuilder_.remove(index);
                }
                return this;
            }

            public BreakoutActionOuterClass.BreakoutAction.Builder getActionListBuilder(int index) {
                return getActionListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public BreakoutActionOuterClass.BreakoutActionOrBuilder getActionListOrBuilder(int index) {
                if (this.actionListBuilder_ == null) {
                    return this.actionList_.get(index);
                }
                return this.actionListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<? extends BreakoutActionOuterClass.BreakoutActionOrBuilder> getActionListOrBuilderList() {
                if (this.actionListBuilder_ != null) {
                    return this.actionListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.actionList_);
            }

            public BreakoutActionOuterClass.BreakoutAction.Builder addActionListBuilder() {
                return getActionListFieldBuilder().addBuilder(BreakoutActionOuterClass.BreakoutAction.getDefaultInstance());
            }

            public BreakoutActionOuterClass.BreakoutAction.Builder addActionListBuilder(int index) {
                return getActionListFieldBuilder().addBuilder(index, BreakoutActionOuterClass.BreakoutAction.getDefaultInstance());
            }

            public List<BreakoutActionOuterClass.BreakoutAction.Builder> getActionListBuilderList() {
                return getActionListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BreakoutActionOuterClass.BreakoutAction, BreakoutActionOuterClass.BreakoutAction.Builder, BreakoutActionOuterClass.BreakoutActionOrBuilder> getActionListFieldBuilder() {
                if (this.actionListBuilder_ == null) {
                    this.actionListBuilder_ = new RepeatedFieldBuilderV3<>(this.actionList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.actionList_ = null;
                }
                return this.actionListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getWaveIndex() {
                return this.waveIndex_;
            }

            public Builder setWaveIndex(int value) {
                this.waveIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearWaveIndex() {
                this.waveIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public boolean getIsFinish() {
                return this.isFinish_;
            }

            public Builder setIsFinish(boolean value) {
                this.isFinish_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinish() {
                this.isFinish_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getScore() {
                return this.score_;
            }

            public Builder setScore(int value) {
                this.score_ = value;
                onChanged();
                return this;
            }

            public Builder clearScore() {
                this.score_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getCombo() {
                return this.combo_;
            }

            public Builder setCombo(int value) {
                this.combo_ = value;
                onChanged();
                return this;
            }

            public Builder clearCombo() {
                this.combo_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getMaxCombo() {
                return this.maxCombo_;
            }

            public Builder setMaxCombo(int value) {
                this.maxCombo_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxCombo() {
                this.maxCombo_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getLifeCount() {
                return this.lifeCount_;
            }

            public Builder setLifeCount(int value) {
                this.lifeCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearLifeCount() {
                this.lifeCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getWaveSuiteIndex() {
                return this.waveSuiteIndex_;
            }

            public Builder setWaveSuiteIndex(int value) {
                this.waveSuiteIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearWaveSuiteIndex() {
                this.waveSuiteIndex_ = 0;
                onChanged();
                return this;
            }

            private void ensureSpawnPointListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.spawnPointList_ = new ArrayList(this.spawnPointList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<BreakoutSpawnPointOuterClass.BreakoutSpawnPoint> getSpawnPointListList() {
                if (this.spawnPointListBuilder_ == null) {
                    return Collections.unmodifiableList(this.spawnPointList_);
                }
                return this.spawnPointListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getSpawnPointListCount() {
                if (this.spawnPointListBuilder_ == null) {
                    return this.spawnPointList_.size();
                }
                return this.spawnPointListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public BreakoutSpawnPointOuterClass.BreakoutSpawnPoint getSpawnPointList(int index) {
                if (this.spawnPointListBuilder_ == null) {
                    return this.spawnPointList_.get(index);
                }
                return this.spawnPointListBuilder_.getMessage(index);
            }

            public Builder setSpawnPointList(int index, BreakoutSpawnPointOuterClass.BreakoutSpawnPoint value) {
                if (this.spawnPointListBuilder_ != null) {
                    this.spawnPointListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSpawnPointListIsMutable();
                    this.spawnPointList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setSpawnPointList(int index, BreakoutSpawnPointOuterClass.BreakoutSpawnPoint.Builder builderForValue) {
                if (this.spawnPointListBuilder_ == null) {
                    ensureSpawnPointListIsMutable();
                    this.spawnPointList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.spawnPointListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSpawnPointList(BreakoutSpawnPointOuterClass.BreakoutSpawnPoint value) {
                if (this.spawnPointListBuilder_ != null) {
                    this.spawnPointListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSpawnPointListIsMutable();
                    this.spawnPointList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addSpawnPointList(int index, BreakoutSpawnPointOuterClass.BreakoutSpawnPoint value) {
                if (this.spawnPointListBuilder_ != null) {
                    this.spawnPointListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSpawnPointListIsMutable();
                    this.spawnPointList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addSpawnPointList(BreakoutSpawnPointOuterClass.BreakoutSpawnPoint.Builder builderForValue) {
                if (this.spawnPointListBuilder_ == null) {
                    ensureSpawnPointListIsMutable();
                    this.spawnPointList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.spawnPointListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSpawnPointList(int index, BreakoutSpawnPointOuterClass.BreakoutSpawnPoint.Builder builderForValue) {
                if (this.spawnPointListBuilder_ == null) {
                    ensureSpawnPointListIsMutable();
                    this.spawnPointList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.spawnPointListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSpawnPointList(Iterable<? extends BreakoutSpawnPointOuterClass.BreakoutSpawnPoint> values) {
                if (this.spawnPointListBuilder_ == null) {
                    ensureSpawnPointListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.spawnPointList_);
                    onChanged();
                } else {
                    this.spawnPointListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSpawnPointList() {
                if (this.spawnPointListBuilder_ == null) {
                    this.spawnPointList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.spawnPointListBuilder_.clear();
                }
                return this;
            }

            public Builder removeSpawnPointList(int index) {
                if (this.spawnPointListBuilder_ == null) {
                    ensureSpawnPointListIsMutable();
                    this.spawnPointList_.remove(index);
                    onChanged();
                } else {
                    this.spawnPointListBuilder_.remove(index);
                }
                return this;
            }

            public BreakoutSpawnPointOuterClass.BreakoutSpawnPoint.Builder getSpawnPointListBuilder(int index) {
                return getSpawnPointListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder getSpawnPointListOrBuilder(int index) {
                if (this.spawnPointListBuilder_ == null) {
                    return this.spawnPointList_.get(index);
                }
                return this.spawnPointListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<? extends BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder> getSpawnPointListOrBuilderList() {
                if (this.spawnPointListBuilder_ != null) {
                    return this.spawnPointListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.spawnPointList_);
            }

            public BreakoutSpawnPointOuterClass.BreakoutSpawnPoint.Builder addSpawnPointListBuilder() {
                return getSpawnPointListFieldBuilder().addBuilder(BreakoutSpawnPointOuterClass.BreakoutSpawnPoint.getDefaultInstance());
            }

            public BreakoutSpawnPointOuterClass.BreakoutSpawnPoint.Builder addSpawnPointListBuilder(int index) {
                return getSpawnPointListFieldBuilder().addBuilder(index, BreakoutSpawnPointOuterClass.BreakoutSpawnPoint.getDefaultInstance());
            }

            public List<BreakoutSpawnPointOuterClass.BreakoutSpawnPoint.Builder> getSpawnPointListBuilderList() {
                return getSpawnPointListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BreakoutSpawnPointOuterClass.BreakoutSpawnPoint, BreakoutSpawnPointOuterClass.BreakoutSpawnPoint.Builder, BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder> getSpawnPointListFieldBuilder() {
                if (this.spawnPointListBuilder_ == null) {
                    this.spawnPointListBuilder_ = new RepeatedFieldBuilderV3<>(this.spawnPointList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.spawnPointList_ = null;
                }
                return this.spawnPointListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getRemainingBossHp() {
                return this.remainingBossHp_;
            }

            public Builder setRemainingBossHp(int value) {
                this.remainingBossHp_ = value;
                onChanged();
                return this;
            }

            public Builder clearRemainingBossHp() {
                this.remainingBossHp_ = 0;
                onChanged();
                return this;
            }

            private void ensureBrickElementReactionListIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.brickElementReactionList_ = new ArrayList(this.brickElementReactionList_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter> getBrickElementReactionListList() {
                if (this.brickElementReactionListBuilder_ == null) {
                    return Collections.unmodifiableList(this.brickElementReactionList_);
                }
                return this.brickElementReactionListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getBrickElementReactionListCount() {
                if (this.brickElementReactionListBuilder_ == null) {
                    return this.brickElementReactionList_.size();
                }
                return this.brickElementReactionListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter getBrickElementReactionList(int index) {
                if (this.brickElementReactionListBuilder_ == null) {
                    return this.brickElementReactionList_.get(index);
                }
                return this.brickElementReactionListBuilder_.getMessage(index);
            }

            public Builder setBrickElementReactionList(int index, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter value) {
                if (this.brickElementReactionListBuilder_ != null) {
                    this.brickElementReactionListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBrickElementReactionListIsMutable();
                    this.brickElementReactionList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setBrickElementReactionList(int index, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder builderForValue) {
                if (this.brickElementReactionListBuilder_ == null) {
                    ensureBrickElementReactionListIsMutable();
                    this.brickElementReactionList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.brickElementReactionListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBrickElementReactionList(BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter value) {
                if (this.brickElementReactionListBuilder_ != null) {
                    this.brickElementReactionListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBrickElementReactionListIsMutable();
                    this.brickElementReactionList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addBrickElementReactionList(int index, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter value) {
                if (this.brickElementReactionListBuilder_ != null) {
                    this.brickElementReactionListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBrickElementReactionListIsMutable();
                    this.brickElementReactionList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addBrickElementReactionList(BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder builderForValue) {
                if (this.brickElementReactionListBuilder_ == null) {
                    ensureBrickElementReactionListIsMutable();
                    this.brickElementReactionList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.brickElementReactionListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBrickElementReactionList(int index, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder builderForValue) {
                if (this.brickElementReactionListBuilder_ == null) {
                    ensureBrickElementReactionListIsMutable();
                    this.brickElementReactionList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.brickElementReactionListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBrickElementReactionList(Iterable<? extends BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter> values) {
                if (this.brickElementReactionListBuilder_ == null) {
                    ensureBrickElementReactionListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.brickElementReactionList_);
                    onChanged();
                } else {
                    this.brickElementReactionListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBrickElementReactionList() {
                if (this.brickElementReactionListBuilder_ == null) {
                    this.brickElementReactionList_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    this.brickElementReactionListBuilder_.clear();
                }
                return this;
            }

            public Builder removeBrickElementReactionList(int index) {
                if (this.brickElementReactionListBuilder_ == null) {
                    ensureBrickElementReactionListIsMutable();
                    this.brickElementReactionList_.remove(index);
                    onChanged();
                } else {
                    this.brickElementReactionListBuilder_.remove(index);
                }
                return this;
            }

            public BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder getBrickElementReactionListBuilder(int index) {
                return getBrickElementReactionListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder getBrickElementReactionListOrBuilder(int index) {
                if (this.brickElementReactionListBuilder_ == null) {
                    return this.brickElementReactionList_.get(index);
                }
                return this.brickElementReactionListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<? extends BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder> getBrickElementReactionListOrBuilderList() {
                if (this.brickElementReactionListBuilder_ != null) {
                    return this.brickElementReactionListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.brickElementReactionList_);
            }

            public BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder addBrickElementReactionListBuilder() {
                return getBrickElementReactionListFieldBuilder().addBuilder(BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.getDefaultInstance());
            }

            public BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder addBrickElementReactionListBuilder(int index) {
                return getBrickElementReactionListFieldBuilder().addBuilder(index, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.getDefaultInstance());
            }

            public List<BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder> getBrickElementReactionListBuilderList() {
                return getBrickElementReactionListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder> getBrickElementReactionListFieldBuilder() {
                if (this.brickElementReactionListBuilder_ == null) {
                    this.brickElementReactionListBuilder_ = new RepeatedFieldBuilderV3<>(this.brickElementReactionList_, (this.bitField0_ & 16) != 0, getParentForChildren(), isClean());
                    this.brickElementReactionList_ = null;
                }
                return this.brickElementReactionListBuilder_;
            }

            private void ensureBallElementReactionListIsMutable() {
                if ((this.bitField0_ & 32) == 0) {
                    this.ballElementReactionList_ = new ArrayList(this.ballElementReactionList_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter> getBallElementReactionListList() {
                if (this.ballElementReactionListBuilder_ == null) {
                    return Collections.unmodifiableList(this.ballElementReactionList_);
                }
                return this.ballElementReactionListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getBallElementReactionListCount() {
                if (this.ballElementReactionListBuilder_ == null) {
                    return this.ballElementReactionList_.size();
                }
                return this.ballElementReactionListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter getBallElementReactionList(int index) {
                if (this.ballElementReactionListBuilder_ == null) {
                    return this.ballElementReactionList_.get(index);
                }
                return this.ballElementReactionListBuilder_.getMessage(index);
            }

            public Builder setBallElementReactionList(int index, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter value) {
                if (this.ballElementReactionListBuilder_ != null) {
                    this.ballElementReactionListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBallElementReactionListIsMutable();
                    this.ballElementReactionList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setBallElementReactionList(int index, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder builderForValue) {
                if (this.ballElementReactionListBuilder_ == null) {
                    ensureBallElementReactionListIsMutable();
                    this.ballElementReactionList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.ballElementReactionListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBallElementReactionList(BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter value) {
                if (this.ballElementReactionListBuilder_ != null) {
                    this.ballElementReactionListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBallElementReactionListIsMutable();
                    this.ballElementReactionList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addBallElementReactionList(int index, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter value) {
                if (this.ballElementReactionListBuilder_ != null) {
                    this.ballElementReactionListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBallElementReactionListIsMutable();
                    this.ballElementReactionList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addBallElementReactionList(BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder builderForValue) {
                if (this.ballElementReactionListBuilder_ == null) {
                    ensureBallElementReactionListIsMutable();
                    this.ballElementReactionList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.ballElementReactionListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBallElementReactionList(int index, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder builderForValue) {
                if (this.ballElementReactionListBuilder_ == null) {
                    ensureBallElementReactionListIsMutable();
                    this.ballElementReactionList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.ballElementReactionListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBallElementReactionList(Iterable<? extends BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter> values) {
                if (this.ballElementReactionListBuilder_ == null) {
                    ensureBallElementReactionListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.ballElementReactionList_);
                    onChanged();
                } else {
                    this.ballElementReactionListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBallElementReactionList() {
                if (this.ballElementReactionListBuilder_ == null) {
                    this.ballElementReactionList_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                    onChanged();
                } else {
                    this.ballElementReactionListBuilder_.clear();
                }
                return this;
            }

            public Builder removeBallElementReactionList(int index) {
                if (this.ballElementReactionListBuilder_ == null) {
                    ensureBallElementReactionListIsMutable();
                    this.ballElementReactionList_.remove(index);
                    onChanged();
                } else {
                    this.ballElementReactionListBuilder_.remove(index);
                }
                return this;
            }

            public BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder getBallElementReactionListBuilder(int index) {
                return getBallElementReactionListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder getBallElementReactionListOrBuilder(int index) {
                if (this.ballElementReactionListBuilder_ == null) {
                    return this.ballElementReactionList_.get(index);
                }
                return this.ballElementReactionListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<? extends BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder> getBallElementReactionListOrBuilderList() {
                if (this.ballElementReactionListBuilder_ != null) {
                    return this.ballElementReactionListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.ballElementReactionList_);
            }

            public BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder addBallElementReactionListBuilder() {
                return getBallElementReactionListFieldBuilder().addBuilder(BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.getDefaultInstance());
            }

            public BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder addBallElementReactionListBuilder(int index) {
                return getBallElementReactionListFieldBuilder().addBuilder(index, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.getDefaultInstance());
            }

            public List<BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder> getBallElementReactionListBuilderList() {
                return getBallElementReactionListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounter.Builder, BreakoutElementReactionCounterOuterClass.BreakoutElementReactionCounterOrBuilder> getBallElementReactionListFieldBuilder() {
                if (this.ballElementReactionListBuilder_ == null) {
                    this.ballElementReactionListBuilder_ = new RepeatedFieldBuilderV3<>(this.ballElementReactionList_, (this.bitField0_ & 32) != 0, getParentForChildren(), isClean());
                    this.ballElementReactionList_ = null;
                }
                return this.ballElementReactionListBuilder_;
            }

            private void ensureUidInfoListIsMutable() {
                if ((this.bitField0_ & 64) == 0) {
                    this.uidInfoList_ = new ArrayList(this.uidInfoList_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo> getUidInfoListList() {
                if (this.uidInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.uidInfoList_);
                }
                return this.uidInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getUidInfoListCount() {
                if (this.uidInfoListBuilder_ == null) {
                    return this.uidInfoList_.size();
                }
                return this.uidInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo getUidInfoList(int index) {
                if (this.uidInfoListBuilder_ == null) {
                    return this.uidInfoList_.get(index);
                }
                return this.uidInfoListBuilder_.getMessage(index);
            }

            public Builder setUidInfoList(int index, BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo value) {
                if (this.uidInfoListBuilder_ != null) {
                    this.uidInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUidInfoListIsMutable();
                    this.uidInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUidInfoList(int index, BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo.Builder builderForValue) {
                if (this.uidInfoListBuilder_ == null) {
                    ensureUidInfoListIsMutable();
                    this.uidInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uidInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUidInfoList(BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo value) {
                if (this.uidInfoListBuilder_ != null) {
                    this.uidInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUidInfoListIsMutable();
                    this.uidInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUidInfoList(int index, BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo value) {
                if (this.uidInfoListBuilder_ != null) {
                    this.uidInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUidInfoListIsMutable();
                    this.uidInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUidInfoList(BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo.Builder builderForValue) {
                if (this.uidInfoListBuilder_ == null) {
                    ensureUidInfoListIsMutable();
                    this.uidInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.uidInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUidInfoList(int index, BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo.Builder builderForValue) {
                if (this.uidInfoListBuilder_ == null) {
                    ensureUidInfoListIsMutable();
                    this.uidInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uidInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUidInfoList(Iterable<? extends BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo> values) {
                if (this.uidInfoListBuilder_ == null) {
                    ensureUidInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.uidInfoList_);
                    onChanged();
                } else {
                    this.uidInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUidInfoList() {
                if (this.uidInfoListBuilder_ == null) {
                    this.uidInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                    onChanged();
                } else {
                    this.uidInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeUidInfoList(int index) {
                if (this.uidInfoListBuilder_ == null) {
                    ensureUidInfoListIsMutable();
                    this.uidInfoList_.remove(index);
                    onChanged();
                } else {
                    this.uidInfoListBuilder_.remove(index);
                }
                return this;
            }

            public BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo.Builder getUidInfoListBuilder(int index) {
                return getUidInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder getUidInfoListOrBuilder(int index) {
                if (this.uidInfoListBuilder_ == null) {
                    return this.uidInfoList_.get(index);
                }
                return this.uidInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<? extends BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder> getUidInfoListOrBuilderList() {
                if (this.uidInfoListBuilder_ != null) {
                    return this.uidInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.uidInfoList_);
            }

            public BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo.Builder addUidInfoListBuilder() {
                return getUidInfoListFieldBuilder().addBuilder(BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo.getDefaultInstance());
            }

            public BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo.Builder addUidInfoListBuilder(int index) {
                return getUidInfoListFieldBuilder().addBuilder(index, BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo.getDefaultInstance());
            }

            public List<BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo.Builder> getUidInfoListBuilderList() {
                return getUidInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo, BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfo.Builder, BreakoutSyncConnectUidInfoOuterClass.BreakoutSyncConnectUidInfoOrBuilder> getUidInfoListFieldBuilder() {
                if (this.uidInfoListBuilder_ == null) {
                    this.uidInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.uidInfoList_, (this.bitField0_ & 64) != 0, getParentForChildren(), isClean());
                    this.uidInfoList_ = null;
                }
                return this.uidInfoListBuilder_;
            }

            private void ensureDynamicObjectListIsMutable() {
                if ((this.bitField0_ & 128) == 0) {
                    this.dynamicObjectList_ = new ArrayList(this.dynamicObjectList_);
                    this.bitField0_ |= 128;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> getDynamicObjectListList() {
                if (this.dynamicObjectListBuilder_ == null) {
                    return Collections.unmodifiableList(this.dynamicObjectList_);
                }
                return this.dynamicObjectListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getDynamicObjectListCount() {
                if (this.dynamicObjectListBuilder_ == null) {
                    return this.dynamicObjectList_.size();
                }
                return this.dynamicObjectListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject getDynamicObjectList(int index) {
                if (this.dynamicObjectListBuilder_ == null) {
                    return this.dynamicObjectList_.get(index);
                }
                return this.dynamicObjectListBuilder_.getMessage(index);
            }

            public Builder setDynamicObjectList(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject value) {
                if (this.dynamicObjectListBuilder_ != null) {
                    this.dynamicObjectListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDynamicObjectListIsMutable();
                    this.dynamicObjectList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDynamicObjectList(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder builderForValue) {
                if (this.dynamicObjectListBuilder_ == null) {
                    ensureDynamicObjectListIsMutable();
                    this.dynamicObjectList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dynamicObjectListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDynamicObjectList(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject value) {
                if (this.dynamicObjectListBuilder_ != null) {
                    this.dynamicObjectListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDynamicObjectListIsMutable();
                    this.dynamicObjectList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDynamicObjectList(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject value) {
                if (this.dynamicObjectListBuilder_ != null) {
                    this.dynamicObjectListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDynamicObjectListIsMutable();
                    this.dynamicObjectList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDynamicObjectList(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder builderForValue) {
                if (this.dynamicObjectListBuilder_ == null) {
                    ensureDynamicObjectListIsMutable();
                    this.dynamicObjectList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dynamicObjectListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDynamicObjectList(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder builderForValue) {
                if (this.dynamicObjectListBuilder_ == null) {
                    ensureDynamicObjectListIsMutable();
                    this.dynamicObjectList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dynamicObjectListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDynamicObjectList(Iterable<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> values) {
                if (this.dynamicObjectListBuilder_ == null) {
                    ensureDynamicObjectListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.dynamicObjectList_);
                    onChanged();
                } else {
                    this.dynamicObjectListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDynamicObjectList() {
                if (this.dynamicObjectListBuilder_ == null) {
                    this.dynamicObjectList_ = Collections.emptyList();
                    this.bitField0_ &= -129;
                    onChanged();
                } else {
                    this.dynamicObjectListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDynamicObjectList(int index) {
                if (this.dynamicObjectListBuilder_ == null) {
                    ensureDynamicObjectListIsMutable();
                    this.dynamicObjectList_.remove(index);
                    onChanged();
                } else {
                    this.dynamicObjectListBuilder_.remove(index);
                }
                return this;
            }

            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder getDynamicObjectListBuilder(int index) {
                return getDynamicObjectListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder getDynamicObjectListOrBuilder(int index) {
                if (this.dynamicObjectListBuilder_ == null) {
                    return this.dynamicObjectList_.get(index);
                }
                return this.dynamicObjectListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getDynamicObjectListOrBuilderList() {
                if (this.dynamicObjectListBuilder_ != null) {
                    return this.dynamicObjectListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dynamicObjectList_);
            }

            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder addDynamicObjectListBuilder() {
                return getDynamicObjectListFieldBuilder().addBuilder(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.getDefaultInstance());
            }

            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder addDynamicObjectListBuilder(int index) {
                return getDynamicObjectListFieldBuilder().addBuilder(index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.getDefaultInstance());
            }

            public List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder> getDynamicObjectListBuilderList() {
                return getDynamicObjectListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getDynamicObjectListFieldBuilder() {
                if (this.dynamicObjectListBuilder_ == null) {
                    this.dynamicObjectListBuilder_ = new RepeatedFieldBuilderV3<>(this.dynamicObjectList_, (this.bitField0_ & 128) != 0, getParentForChildren(), isClean());
                    this.dynamicObjectList_ = null;
                }
                return this.dynamicObjectListBuilder_;
            }

            private void ensureIdIndexListIsMutable() {
                if ((this.bitField0_ & 256) == 0) {
                    this.idIndexList_ = BreakoutSnapShot.mutableCopy(this.idIndexList_);
                    this.bitField0_ |= 256;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public List<Integer> getIdIndexListList() {
                return (this.bitField0_ & 256) != 0 ? Collections.unmodifiableList(this.idIndexList_) : this.idIndexList_;
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getIdIndexListCount() {
                return this.idIndexList_.size();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getIdIndexList(int index) {
                return this.idIndexList_.getInt(index);
            }

            public Builder setIdIndexList(int index, int value) {
                ensureIdIndexListIsMutable();
                this.idIndexList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addIdIndexList(int value) {
                ensureIdIndexListIsMutable();
                this.idIndexList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllIdIndexList(Iterable<? extends Integer> values) {
                ensureIdIndexListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.idIndexList_);
                onChanged();
                return this;
            }

            public Builder clearIdIndexList() {
                this.idIndexList_ = BreakoutSnapShot.emptyIntList();
                this.bitField0_ &= -257;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder
            public int getRawClientGameTime() {
                return this.rawClientGameTime_;
            }

            public Builder setRawClientGameTime(int value) {
                this.rawClientGameTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearRawClientGameTime() {
                this.rawClientGameTime_ = 0;
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

        public static BreakoutSnapShot getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BreakoutSnapShot> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BreakoutSnapShot> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BreakoutSnapShot getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BreakoutActionOuterClass.getDescriptor();
        BreakoutElementReactionCounterOuterClass.getDescriptor();
        BreakoutPhysicalObjectOuterClass.getDescriptor();
        BreakoutSpawnPointOuterClass.getDescriptor();
        BreakoutSyncConnectUidInfoOuterClass.getDescriptor();
    }
}
