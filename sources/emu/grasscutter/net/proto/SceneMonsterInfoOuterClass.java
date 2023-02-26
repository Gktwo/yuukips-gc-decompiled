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
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.FishtankFishInfoOuterClass;
import emu.grasscutter.net.proto.MonsterBornTypeOuterClass;
import emu.grasscutter.net.proto.MonsterRouteOuterClass;
import emu.grasscutter.net.proto.SceneFishInfoOuterClass;
import emu.grasscutter.net.proto.SceneWeaponInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneMonsterInfoOuterClass.class */
public final class SceneMonsterInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016SceneMonsterInfo.proto\u001a\u0016FishtankFishInfo.proto\u001a\u0015MonsterBornType.proto\u001a\u0012MonsterRoute.proto\u001a\u0013SceneFishInfo.proto\u001a\u0015SceneWeaponInfo.proto\"ã\u0005\n\u0010SceneMonsterInfo\u0012\u0012\n\nmonster_id\u0018\u0001 \u0001(\r\u0012\u0010\n\bgroup_id\u0018\u0002 \u0001(\r\u0012\u0011\n\tconfig_id\u0018\u0003 \u0001(\r\u0012%\n\u000bweapon_list\u0018\u0004 \u0003(\u000b2\u0010.SceneWeaponInfo\u0012\u0019\n\u0011authority_peer_id\u0018\u0005 \u0001(\r\u0012\u0012\n\naffix_list\u0018\u0006 \u0003(\r\u0012\u0010\n\bis_elite\u0018\u0007 \u0001(\b\u0012\u0017\n\u000fowner_entity_id\u0018\b \u0001(\r\u0012\u0014\n\fsummoned_tag\u0018\t \u0001(\r\u0012;\n\u000esummon_tag_map\u0018\n \u0003(\u000b2#.SceneMonsterInfo.SummonTagMapEntry\u0012\u000f\n\u0007pose_id\u0018\u000b \u0001(\r\u0012#\n\tborn_type\u0018\f \u0001(\u000e2\u0010.MonsterBornType\u0012\u0010\n\bblock_id\u0018\r \u0001(\r\u0012\u0011\n\tmark_flag\u0018\u000e \u0001(\r\u0012\u0010\n\btitle_id\u0018\u000f \u0001(\r\u0012\u0017\n\u000fspecial_name_id\u0018\u0010 \u0001(\r\u0012\u0018\n\u0010attack_target_id\u0018\u0011 \u0001(\r\u0012$\n\rmonster_route\u0018\u0012 \u0001(\u000b2\r.MonsterRoute\u0012\u0014\n\fai_config_id\u0018\u0013 \u0001(\r\u0012\u0016\n\u000elevel_route_id\u0018\u0014 \u0001(\r\u0012\u0014\n\finit_pose_id\u0018\u0015 \u0001(\r\u0012\u0010\n\bis_light\u0018\u0016 \u0001(\b\u0012\u0010\n\bkill_num\u0018\u0017 \u0001(\r\u0012#\n\tfish_info\u00182 \u0001(\u000b2\u000e.SceneFishInfoH��\u0012/\n\u0012fishtank_fish_info\u00183 \u0001(\u000b2\u0011.FishtankFishInfoH��\u001a3\n\u0011SummonTagMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\t\n\u0007contentB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FishtankFishInfoOuterClass.getDescriptor(), MonsterBornTypeOuterClass.getDescriptor(), MonsterRouteOuterClass.getDescriptor(), SceneFishInfoOuterClass.getDescriptor(), SceneWeaponInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SceneMonsterInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneMonsterInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneMonsterInfo_descriptor, new String[]{"MonsterId", "GroupId", "ConfigId", "WeaponList", "AuthorityPeerId", "AffixList", "IsElite", "OwnerEntityId", "SummonedTag", "SummonTagMap", "PoseId", "BornType", "BlockId", "MarkFlag", "TitleId", "SpecialNameId", "AttackTargetId", "MonsterRoute", "AiConfigId", "LevelRouteId", "InitPoseId", "IsLight", "KillNum", "FishInfo", "FishtankFishInfo", "Content"});
    private static final Descriptors.Descriptor internal_static_SceneMonsterInfo_SummonTagMapEntry_descriptor = internal_static_SceneMonsterInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_SceneMonsterInfo_SummonTagMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f843x4de84b1 = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneMonsterInfo_SummonTagMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneMonsterInfoOuterClass$SceneMonsterInfoOrBuilder.class */
    public interface SceneMonsterInfoOrBuilder extends MessageOrBuilder {
        int getMonsterId();

        int getGroupId();

        int getConfigId();

        List<SceneWeaponInfoOuterClass.SceneWeaponInfo> getWeaponListList();

        SceneWeaponInfoOuterClass.SceneWeaponInfo getWeaponList(int i);

        int getWeaponListCount();

        List<? extends SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder> getWeaponListOrBuilderList();

        SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder getWeaponListOrBuilder(int i);

        int getAuthorityPeerId();

        List<Integer> getAffixListList();

        int getAffixListCount();

        int getAffixList(int i);

        boolean getIsElite();

        int getOwnerEntityId();

        int getSummonedTag();

        int getSummonTagMapCount();

        boolean containsSummonTagMap(int i);

        @Deprecated
        Map<Integer, Integer> getSummonTagMap();

        Map<Integer, Integer> getSummonTagMapMap();

        int getSummonTagMapOrDefault(int i, int i2);

        int getSummonTagMapOrThrow(int i);

        int getPoseId();

        int getBornTypeValue();

        MonsterBornTypeOuterClass.MonsterBornType getBornType();

        int getBlockId();

        int getMarkFlag();

        int getTitleId();

        int getSpecialNameId();

        int getAttackTargetId();

        boolean hasMonsterRoute();

        MonsterRouteOuterClass.MonsterRoute getMonsterRoute();

        MonsterRouteOuterClass.MonsterRouteOrBuilder getMonsterRouteOrBuilder();

        int getAiConfigId();

        int getLevelRouteId();

        int getInitPoseId();

        boolean getIsLight();

        int getKillNum();

        boolean hasFishInfo();

        SceneFishInfoOuterClass.SceneFishInfo getFishInfo();

        SceneFishInfoOuterClass.SceneFishInfoOrBuilder getFishInfoOrBuilder();

        boolean hasFishtankFishInfo();

        FishtankFishInfoOuterClass.FishtankFishInfo getFishtankFishInfo();

        FishtankFishInfoOuterClass.FishtankFishInfoOrBuilder getFishtankFishInfoOrBuilder();

        SceneMonsterInfo.ContentCase getContentCase();
    }

    private SceneMonsterInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneMonsterInfoOuterClass$SceneMonsterInfo.class */
    public static final class SceneMonsterInfo extends GeneratedMessageV3 implements SceneMonsterInfoOrBuilder {
        private static final long serialVersionUID = 0;
        private int contentCase_;
        private Object content_;
        public static final int MONSTER_ID_FIELD_NUMBER = 1;
        private int monsterId_;
        public static final int GROUP_ID_FIELD_NUMBER = 2;
        private int groupId_;
        public static final int CONFIG_ID_FIELD_NUMBER = 3;
        private int configId_;
        public static final int WEAPON_LIST_FIELD_NUMBER = 4;
        private List<SceneWeaponInfoOuterClass.SceneWeaponInfo> weaponList_;
        public static final int AUTHORITY_PEER_ID_FIELD_NUMBER = 5;
        private int authorityPeerId_;
        public static final int AFFIX_LIST_FIELD_NUMBER = 6;
        private Internal.IntList affixList_;
        private int affixListMemoizedSerializedSize;
        public static final int IS_ELITE_FIELD_NUMBER = 7;
        private boolean isElite_;
        public static final int OWNER_ENTITY_ID_FIELD_NUMBER = 8;
        private int ownerEntityId_;
        public static final int SUMMONED_TAG_FIELD_NUMBER = 9;
        private int summonedTag_;
        public static final int SUMMON_TAG_MAP_FIELD_NUMBER = 10;
        private MapField<Integer, Integer> summonTagMap_;
        public static final int POSE_ID_FIELD_NUMBER = 11;
        private int poseId_;
        public static final int BORN_TYPE_FIELD_NUMBER = 12;
        private int bornType_;
        public static final int BLOCK_ID_FIELD_NUMBER = 13;
        private int blockId_;
        public static final int MARK_FLAG_FIELD_NUMBER = 14;
        private int markFlag_;
        public static final int TITLE_ID_FIELD_NUMBER = 15;
        private int titleId_;
        public static final int SPECIAL_NAME_ID_FIELD_NUMBER = 16;
        private int specialNameId_;
        public static final int ATTACK_TARGET_ID_FIELD_NUMBER = 17;
        private int attackTargetId_;
        public static final int MONSTER_ROUTE_FIELD_NUMBER = 18;
        private MonsterRouteOuterClass.MonsterRoute monsterRoute_;
        public static final int AI_CONFIG_ID_FIELD_NUMBER = 19;
        private int aiConfigId_;
        public static final int LEVEL_ROUTE_ID_FIELD_NUMBER = 20;
        private int levelRouteId_;
        public static final int INIT_POSE_ID_FIELD_NUMBER = 21;
        private int initPoseId_;
        public static final int IS_LIGHT_FIELD_NUMBER = 22;
        private boolean isLight_;
        public static final int KILL_NUM_FIELD_NUMBER = 23;
        private int killNum_;
        public static final int FISH_INFO_FIELD_NUMBER = 50;
        public static final int FISHTANK_FISH_INFO_FIELD_NUMBER = 51;
        private byte memoizedIsInitialized;
        private static final SceneMonsterInfo DEFAULT_INSTANCE = new SceneMonsterInfo();
        private static final Parser<SceneMonsterInfo> PARSER = new AbstractParser<SceneMonsterInfo>() { // from class: emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfo.1
            @Override // com.google.protobuf.Parser
            public SceneMonsterInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneMonsterInfo(input, extensionRegistry);
            }
        };

        /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
            java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
            	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
            */
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfo.internalGetMapField(int):com.google.protobuf.MapField
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.MapField internalGetMapField(int r5) {
            /*
                r4 = this;
                r0 = r5
                switch(r0) {
                    case 10: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetSummonTagMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private SceneMonsterInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.contentCase_ = 0;
            this.affixListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private SceneMonsterInfo() {
            this.contentCase_ = 0;
            this.affixListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.weaponList_ = Collections.emptyList();
            this.affixList_ = emptyIntList();
            this.bornType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneMonsterInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:135:0x0398 */
        private SceneMonsterInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.monsterId_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.groupId_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.configId_ = input.readUInt32();
                                    break;
                                case 34:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.weaponList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.weaponList_.add((SceneWeaponInfoOuterClass.SceneWeaponInfo) input.readMessage(SceneWeaponInfoOuterClass.SceneWeaponInfo.parser(), extensionRegistry));
                                    break;
                                case 40:
                                    this.authorityPeerId_ = input.readUInt32();
                                    break;
                                case 48:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.affixList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.affixList_.addInt(input.readUInt32());
                                    break;
                                case 50:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.affixList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.affixList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 56:
                                    this.isElite_ = input.readBool();
                                    break;
                                case 64:
                                    this.ownerEntityId_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.summonedTag_ = input.readUInt32();
                                    break;
                                case 82:
                                    if ((mutable_bitField0_ & 4) == 0) {
                                        this.summonTagMap_ = MapField.newMapField(SummonTagMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    MapEntry<Integer, Integer> summonTagMap__ = (MapEntry) input.readMessage(SummonTagMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.summonTagMap_.getMutableMap().put(summonTagMap__.getKey(), summonTagMap__.getValue());
                                    break;
                                case 88:
                                    this.poseId_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.bornType_ = input.readEnum();
                                    break;
                                case 104:
                                    this.blockId_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.markFlag_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.titleId_ = input.readUInt32();
                                    break;
                                case 128:
                                    this.specialNameId_ = input.readUInt32();
                                    break;
                                case 136:
                                    this.attackTargetId_ = input.readUInt32();
                                    break;
                                case 146:
                                    MonsterRouteOuterClass.MonsterRoute.Builder subBuilder = this.monsterRoute_ != null ? this.monsterRoute_.toBuilder() : null;
                                    this.monsterRoute_ = (MonsterRouteOuterClass.MonsterRoute) input.readMessage(MonsterRouteOuterClass.MonsterRoute.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.monsterRoute_);
                                        this.monsterRoute_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 152:
                                    this.aiConfigId_ = input.readUInt32();
                                    break;
                                case 160:
                                    this.levelRouteId_ = input.readUInt32();
                                    break;
                                case 168:
                                    this.initPoseId_ = input.readUInt32();
                                    break;
                                case 176:
                                    this.isLight_ = input.readBool();
                                    break;
                                case 184:
                                    this.killNum_ = input.readUInt32();
                                    break;
                                case 402:
                                    SceneFishInfoOuterClass.SceneFishInfo.Builder subBuilder2 = this.contentCase_ == 50 ? ((SceneFishInfoOuterClass.SceneFishInfo) this.content_).toBuilder() : null;
                                    this.content_ = input.readMessage(SceneFishInfoOuterClass.SceneFishInfo.parser(), extensionRegistry);
                                    if (subBuilder2 != null) {
                                        subBuilder2.mergeFrom((SceneFishInfoOuterClass.SceneFishInfo) this.content_);
                                        this.content_ = subBuilder2.buildPartial();
                                    }
                                    this.contentCase_ = 50;
                                    break;
                                case 410:
                                    FishtankFishInfoOuterClass.FishtankFishInfo.Builder subBuilder3 = this.contentCase_ == 51 ? ((FishtankFishInfoOuterClass.FishtankFishInfo) this.content_).toBuilder() : null;
                                    this.content_ = input.readMessage(FishtankFishInfoOuterClass.FishtankFishInfo.parser(), extensionRegistry);
                                    if (subBuilder3 != null) {
                                        subBuilder3.mergeFrom((FishtankFishInfoOuterClass.FishtankFishInfo) this.content_);
                                        this.content_ = subBuilder3.buildPartial();
                                    }
                                    this.contentCase_ = 51;
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.weaponList_ = Collections.unmodifiableList(this.weaponList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.affixList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SceneMonsterInfoOuterClass.internal_static_SceneMonsterInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneMonsterInfoOuterClass.internal_static_SceneMonsterInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneMonsterInfo.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneMonsterInfoOuterClass$SceneMonsterInfo$ContentCase.class */
        public enum ContentCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            FISH_INFO(50),
            FISHTANK_FISH_INFO(51),
            CONTENT_NOT_SET(0);
            
            private final int value;

            ContentCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static ContentCase valueOf(int value) {
                return forNumber(value);
            }

            public static ContentCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return CONTENT_NOT_SET;
                    case 50:
                        return FISH_INFO;
                    case 51:
                        return FISHTANK_FISH_INFO;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public ContentCase getContentCase() {
            return ContentCase.forNumber(this.contentCase_);
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getMonsterId() {
            return this.monsterId_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getGroupId() {
            return this.groupId_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getConfigId() {
            return this.configId_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public List<SceneWeaponInfoOuterClass.SceneWeaponInfo> getWeaponListList() {
            return this.weaponList_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public List<? extends SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder> getWeaponListOrBuilderList() {
            return this.weaponList_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getWeaponListCount() {
            return this.weaponList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public SceneWeaponInfoOuterClass.SceneWeaponInfo getWeaponList(int index) {
            return this.weaponList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder getWeaponListOrBuilder(int index) {
            return this.weaponList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getAuthorityPeerId() {
            return this.authorityPeerId_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public List<Integer> getAffixListList() {
            return this.affixList_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getAffixListCount() {
            return this.affixList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getAffixList(int index) {
            return this.affixList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public boolean getIsElite() {
            return this.isElite_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getOwnerEntityId() {
            return this.ownerEntityId_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getSummonedTag() {
            return this.summonedTag_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneMonsterInfoOuterClass$SceneMonsterInfo$SummonTagMapDefaultEntryHolder.class */
        public static final class SummonTagMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(SceneMonsterInfoOuterClass.internal_static_SceneMonsterInfo_SummonTagMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private SummonTagMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetSummonTagMap() {
            if (this.summonTagMap_ == null) {
                return MapField.emptyMapField(SummonTagMapDefaultEntryHolder.defaultEntry);
            }
            return this.summonTagMap_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getSummonTagMapCount() {
            return internalGetSummonTagMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public boolean containsSummonTagMap(int key) {
            return internalGetSummonTagMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getSummonTagMap() {
            return getSummonTagMapMap();
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public Map<Integer, Integer> getSummonTagMapMap() {
            return internalGetSummonTagMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getSummonTagMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetSummonTagMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getSummonTagMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetSummonTagMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getPoseId() {
            return this.poseId_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getBornTypeValue() {
            return this.bornType_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public MonsterBornTypeOuterClass.MonsterBornType getBornType() {
            MonsterBornTypeOuterClass.MonsterBornType result = MonsterBornTypeOuterClass.MonsterBornType.valueOf(this.bornType_);
            return result == null ? MonsterBornTypeOuterClass.MonsterBornType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getBlockId() {
            return this.blockId_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getMarkFlag() {
            return this.markFlag_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getTitleId() {
            return this.titleId_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getSpecialNameId() {
            return this.specialNameId_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getAttackTargetId() {
            return this.attackTargetId_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public boolean hasMonsterRoute() {
            return this.monsterRoute_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public MonsterRouteOuterClass.MonsterRoute getMonsterRoute() {
            return this.monsterRoute_ == null ? MonsterRouteOuterClass.MonsterRoute.getDefaultInstance() : this.monsterRoute_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public MonsterRouteOuterClass.MonsterRouteOrBuilder getMonsterRouteOrBuilder() {
            return getMonsterRoute();
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getAiConfigId() {
            return this.aiConfigId_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getLevelRouteId() {
            return this.levelRouteId_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getInitPoseId() {
            return this.initPoseId_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public boolean getIsLight() {
            return this.isLight_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public int getKillNum() {
            return this.killNum_;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public boolean hasFishInfo() {
            return this.contentCase_ == 50;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public SceneFishInfoOuterClass.SceneFishInfo getFishInfo() {
            if (this.contentCase_ == 50) {
                return (SceneFishInfoOuterClass.SceneFishInfo) this.content_;
            }
            return SceneFishInfoOuterClass.SceneFishInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public SceneFishInfoOuterClass.SceneFishInfoOrBuilder getFishInfoOrBuilder() {
            if (this.contentCase_ == 50) {
                return (SceneFishInfoOuterClass.SceneFishInfo) this.content_;
            }
            return SceneFishInfoOuterClass.SceneFishInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public boolean hasFishtankFishInfo() {
            return this.contentCase_ == 51;
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public FishtankFishInfoOuterClass.FishtankFishInfo getFishtankFishInfo() {
            if (this.contentCase_ == 51) {
                return (FishtankFishInfoOuterClass.FishtankFishInfo) this.content_;
            }
            return FishtankFishInfoOuterClass.FishtankFishInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
        public FishtankFishInfoOuterClass.FishtankFishInfoOrBuilder getFishtankFishInfoOrBuilder() {
            if (this.contentCase_ == 51) {
                return (FishtankFishInfoOuterClass.FishtankFishInfo) this.content_;
            }
            return FishtankFishInfoOuterClass.FishtankFishInfo.getDefaultInstance();
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
            if (this.monsterId_ != 0) {
                output.writeUInt32(1, this.monsterId_);
            }
            if (this.groupId_ != 0) {
                output.writeUInt32(2, this.groupId_);
            }
            if (this.configId_ != 0) {
                output.writeUInt32(3, this.configId_);
            }
            for (int i = 0; i < this.weaponList_.size(); i++) {
                output.writeMessage(4, this.weaponList_.get(i));
            }
            if (this.authorityPeerId_ != 0) {
                output.writeUInt32(5, this.authorityPeerId_);
            }
            if (getAffixListList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.affixListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.affixList_.size(); i2++) {
                output.writeUInt32NoTag(this.affixList_.getInt(i2));
            }
            if (this.isElite_) {
                output.writeBool(7, this.isElite_);
            }
            if (this.ownerEntityId_ != 0) {
                output.writeUInt32(8, this.ownerEntityId_);
            }
            if (this.summonedTag_ != 0) {
                output.writeUInt32(9, this.summonedTag_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSummonTagMap(), SummonTagMapDefaultEntryHolder.defaultEntry, 10);
            if (this.poseId_ != 0) {
                output.writeUInt32(11, this.poseId_);
            }
            if (this.bornType_ != MonsterBornTypeOuterClass.MonsterBornType.MONSTER_BORN_TYPE_NONE.getNumber()) {
                output.writeEnum(12, this.bornType_);
            }
            if (this.blockId_ != 0) {
                output.writeUInt32(13, this.blockId_);
            }
            if (this.markFlag_ != 0) {
                output.writeUInt32(14, this.markFlag_);
            }
            if (this.titleId_ != 0) {
                output.writeUInt32(15, this.titleId_);
            }
            if (this.specialNameId_ != 0) {
                output.writeUInt32(16, this.specialNameId_);
            }
            if (this.attackTargetId_ != 0) {
                output.writeUInt32(17, this.attackTargetId_);
            }
            if (this.monsterRoute_ != null) {
                output.writeMessage(18, getMonsterRoute());
            }
            if (this.aiConfigId_ != 0) {
                output.writeUInt32(19, this.aiConfigId_);
            }
            if (this.levelRouteId_ != 0) {
                output.writeUInt32(20, this.levelRouteId_);
            }
            if (this.initPoseId_ != 0) {
                output.writeUInt32(21, this.initPoseId_);
            }
            if (this.isLight_) {
                output.writeBool(22, this.isLight_);
            }
            if (this.killNum_ != 0) {
                output.writeUInt32(23, this.killNum_);
            }
            if (this.contentCase_ == 50) {
                output.writeMessage(50, (SceneFishInfoOuterClass.SceneFishInfo) this.content_);
            }
            if (this.contentCase_ == 51) {
                output.writeMessage(51, (FishtankFishInfoOuterClass.FishtankFishInfo) this.content_);
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
            if (this.monsterId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.monsterId_);
            }
            if (this.groupId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.groupId_);
            }
            if (this.configId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.configId_);
            }
            for (int i = 0; i < this.weaponList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.weaponList_.get(i));
            }
            if (this.authorityPeerId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.authorityPeerId_);
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.affixList_.size(); i2++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.affixList_.getInt(i2));
            }
            int size3 = size2 + dataSize;
            if (!getAffixListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.affixListMemoizedSerializedSize = dataSize;
            if (this.isElite_) {
                size3 += CodedOutputStream.computeBoolSize(7, this.isElite_);
            }
            if (this.ownerEntityId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(8, this.ownerEntityId_);
            }
            if (this.summonedTag_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(9, this.summonedTag_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetSummonTagMap().getMap().entrySet()) {
                size3 += CodedOutputStream.computeMessageSize(10, SummonTagMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.poseId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(11, this.poseId_);
            }
            if (this.bornType_ != MonsterBornTypeOuterClass.MonsterBornType.MONSTER_BORN_TYPE_NONE.getNumber()) {
                size3 += CodedOutputStream.computeEnumSize(12, this.bornType_);
            }
            if (this.blockId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(13, this.blockId_);
            }
            if (this.markFlag_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(14, this.markFlag_);
            }
            if (this.titleId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(15, this.titleId_);
            }
            if (this.specialNameId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(16, this.specialNameId_);
            }
            if (this.attackTargetId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(17, this.attackTargetId_);
            }
            if (this.monsterRoute_ != null) {
                size3 += CodedOutputStream.computeMessageSize(18, getMonsterRoute());
            }
            if (this.aiConfigId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(19, this.aiConfigId_);
            }
            if (this.levelRouteId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(20, this.levelRouteId_);
            }
            if (this.initPoseId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(21, this.initPoseId_);
            }
            if (this.isLight_) {
                size3 += CodedOutputStream.computeBoolSize(22, this.isLight_);
            }
            if (this.killNum_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(23, this.killNum_);
            }
            if (this.contentCase_ == 50) {
                size3 += CodedOutputStream.computeMessageSize(50, (SceneFishInfoOuterClass.SceneFishInfo) this.content_);
            }
            if (this.contentCase_ == 51) {
                size3 += CodedOutputStream.computeMessageSize(51, (FishtankFishInfoOuterClass.FishtankFishInfo) this.content_);
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
            if (!(obj instanceof SceneMonsterInfo)) {
                return equals(obj);
            }
            SceneMonsterInfo other = (SceneMonsterInfo) obj;
            if (getMonsterId() != other.getMonsterId() || getGroupId() != other.getGroupId() || getConfigId() != other.getConfigId() || !getWeaponListList().equals(other.getWeaponListList()) || getAuthorityPeerId() != other.getAuthorityPeerId() || !getAffixListList().equals(other.getAffixListList()) || getIsElite() != other.getIsElite() || getOwnerEntityId() != other.getOwnerEntityId() || getSummonedTag() != other.getSummonedTag() || !internalGetSummonTagMap().equals(other.internalGetSummonTagMap()) || getPoseId() != other.getPoseId() || this.bornType_ != other.bornType_ || getBlockId() != other.getBlockId() || getMarkFlag() != other.getMarkFlag() || getTitleId() != other.getTitleId() || getSpecialNameId() != other.getSpecialNameId() || getAttackTargetId() != other.getAttackTargetId() || hasMonsterRoute() != other.hasMonsterRoute()) {
                return false;
            }
            if ((hasMonsterRoute() && !getMonsterRoute().equals(other.getMonsterRoute())) || getAiConfigId() != other.getAiConfigId() || getLevelRouteId() != other.getLevelRouteId() || getInitPoseId() != other.getInitPoseId() || getIsLight() != other.getIsLight() || getKillNum() != other.getKillNum() || !getContentCase().equals(other.getContentCase())) {
                return false;
            }
            switch (this.contentCase_) {
                case 50:
                    if (!getFishInfo().equals(other.getFishInfo())) {
                        return false;
                    }
                    break;
                case 51:
                    if (!getFishtankFishInfo().equals(other.getFishtankFishInfo())) {
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
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getMonsterId())) + 2)) + getGroupId())) + 3)) + getConfigId();
            if (getWeaponListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getWeaponListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 5)) + getAuthorityPeerId();
            if (getAffixListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 6)) + getAffixListList().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 7)) + Internal.hashBoolean(getIsElite()))) + 8)) + getOwnerEntityId())) + 9)) + getSummonedTag();
            if (!internalGetSummonTagMap().getMap().isEmpty()) {
                hash3 = (53 * ((37 * hash3) + 10)) + internalGetSummonTagMap().hashCode();
            }
            int hash4 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash3) + 11)) + getPoseId())) + 12)) + this.bornType_)) + 13)) + getBlockId())) + 14)) + getMarkFlag())) + 15)) + getTitleId())) + 16)) + getSpecialNameId())) + 17)) + getAttackTargetId();
            if (hasMonsterRoute()) {
                hash4 = (53 * ((37 * hash4) + 18)) + getMonsterRoute().hashCode();
            }
            int hash5 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash4) + 19)) + getAiConfigId())) + 20)) + getLevelRouteId())) + 21)) + getInitPoseId())) + 22)) + Internal.hashBoolean(getIsLight()))) + 23)) + getKillNum();
            switch (this.contentCase_) {
                case 50:
                    hash5 = (53 * ((37 * hash5) + 50)) + getFishInfo().hashCode();
                    break;
                case 51:
                    hash5 = (53 * ((37 * hash5) + 51)) + getFishtankFishInfo().hashCode();
                    break;
            }
            int hash6 = (29 * hash5) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash6;
            return hash6;
        }

        public static SceneMonsterInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneMonsterInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneMonsterInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneMonsterInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneMonsterInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneMonsterInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneMonsterInfo parseFrom(InputStream input) throws IOException {
            return (SceneMonsterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneMonsterInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneMonsterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneMonsterInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneMonsterInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneMonsterInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneMonsterInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneMonsterInfo parseFrom(CodedInputStream input) throws IOException {
            return (SceneMonsterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneMonsterInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneMonsterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneMonsterInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneMonsterInfoOuterClass$SceneMonsterInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneMonsterInfoOrBuilder {
            private Object content_;
            private int bitField0_;
            private int monsterId_;
            private int groupId_;
            private int configId_;
            private RepeatedFieldBuilderV3<SceneWeaponInfoOuterClass.SceneWeaponInfo, SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder, SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder> weaponListBuilder_;
            private int authorityPeerId_;
            private boolean isElite_;
            private int ownerEntityId_;
            private int summonedTag_;
            private MapField<Integer, Integer> summonTagMap_;
            private int poseId_;
            private int blockId_;
            private int markFlag_;
            private int titleId_;
            private int specialNameId_;
            private int attackTargetId_;
            private MonsterRouteOuterClass.MonsterRoute monsterRoute_;
            private SingleFieldBuilderV3<MonsterRouteOuterClass.MonsterRoute, MonsterRouteOuterClass.MonsterRoute.Builder, MonsterRouteOuterClass.MonsterRouteOrBuilder> monsterRouteBuilder_;
            private int aiConfigId_;
            private int levelRouteId_;
            private int initPoseId_;
            private boolean isLight_;
            private int killNum_;
            private SingleFieldBuilderV3<SceneFishInfoOuterClass.SceneFishInfo, SceneFishInfoOuterClass.SceneFishInfo.Builder, SceneFishInfoOuterClass.SceneFishInfoOrBuilder> fishInfoBuilder_;
            private SingleFieldBuilderV3<FishtankFishInfoOuterClass.FishtankFishInfo, FishtankFishInfoOuterClass.FishtankFishInfo.Builder, FishtankFishInfoOuterClass.FishtankFishInfoOrBuilder> fishtankFishInfoBuilder_;
            private int contentCase_ = 0;
            private List<SceneWeaponInfoOuterClass.SceneWeaponInfo> weaponList_ = Collections.emptyList();
            private Internal.IntList affixList_ = SceneMonsterInfo.emptyIntList();
            private int bornType_ = 0;

            /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
                java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                */
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.MapField internalGetMapField(int r5) {
                /*
                    r4 = this;
                    r0 = r5
                    switch(r0) {
                        case 10: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetSummonTagMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
            }

            /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
                java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                */
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.MapField internalGetMutableMapField(int r5) {
                /*
                    r4 = this;
                    r0 = r5
                    switch(r0) {
                        case 10: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableSummonTagMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneMonsterInfoOuterClass.internal_static_SceneMonsterInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneMonsterInfoOuterClass.internal_static_SceneMonsterInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneMonsterInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneMonsterInfo.alwaysUseFieldBuilders) {
                    getWeaponListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.monsterId_ = 0;
                this.groupId_ = 0;
                this.configId_ = 0;
                if (this.weaponListBuilder_ == null) {
                    this.weaponList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.weaponListBuilder_.clear();
                }
                this.authorityPeerId_ = 0;
                this.affixList_ = SceneMonsterInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.isElite_ = false;
                this.ownerEntityId_ = 0;
                this.summonedTag_ = 0;
                internalGetMutableSummonTagMap().clear();
                this.poseId_ = 0;
                this.bornType_ = 0;
                this.blockId_ = 0;
                this.markFlag_ = 0;
                this.titleId_ = 0;
                this.specialNameId_ = 0;
                this.attackTargetId_ = 0;
                if (this.monsterRouteBuilder_ == null) {
                    this.monsterRoute_ = null;
                } else {
                    this.monsterRoute_ = null;
                    this.monsterRouteBuilder_ = null;
                }
                this.aiConfigId_ = 0;
                this.levelRouteId_ = 0;
                this.initPoseId_ = 0;
                this.isLight_ = false;
                this.killNum_ = 0;
                this.contentCase_ = 0;
                this.content_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneMonsterInfoOuterClass.internal_static_SceneMonsterInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneMonsterInfo getDefaultInstanceForType() {
                return SceneMonsterInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneMonsterInfo build() {
                SceneMonsterInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneMonsterInfo buildPartial() {
                SceneMonsterInfo result = new SceneMonsterInfo(this);
                int i = this.bitField0_;
                result.monsterId_ = this.monsterId_;
                result.groupId_ = this.groupId_;
                result.configId_ = this.configId_;
                if (this.weaponListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.weaponList_ = Collections.unmodifiableList(this.weaponList_);
                        this.bitField0_ &= -2;
                    }
                    result.weaponList_ = this.weaponList_;
                } else {
                    result.weaponList_ = this.weaponListBuilder_.build();
                }
                result.authorityPeerId_ = this.authorityPeerId_;
                if ((this.bitField0_ & 2) != 0) {
                    this.affixList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.affixList_ = this.affixList_;
                result.isElite_ = this.isElite_;
                result.ownerEntityId_ = this.ownerEntityId_;
                result.summonedTag_ = this.summonedTag_;
                result.summonTagMap_ = internalGetSummonTagMap();
                result.summonTagMap_.makeImmutable();
                result.poseId_ = this.poseId_;
                result.bornType_ = this.bornType_;
                result.blockId_ = this.blockId_;
                result.markFlag_ = this.markFlag_;
                result.titleId_ = this.titleId_;
                result.specialNameId_ = this.specialNameId_;
                result.attackTargetId_ = this.attackTargetId_;
                if (this.monsterRouteBuilder_ == null) {
                    result.monsterRoute_ = this.monsterRoute_;
                } else {
                    result.monsterRoute_ = this.monsterRouteBuilder_.build();
                }
                result.aiConfigId_ = this.aiConfigId_;
                result.levelRouteId_ = this.levelRouteId_;
                result.initPoseId_ = this.initPoseId_;
                result.isLight_ = this.isLight_;
                result.killNum_ = this.killNum_;
                if (this.contentCase_ == 50) {
                    if (this.fishInfoBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.fishInfoBuilder_.build();
                    }
                }
                if (this.contentCase_ == 51) {
                    if (this.fishtankFishInfoBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.fishtankFishInfoBuilder_.build();
                    }
                }
                result.contentCase_ = this.contentCase_;
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
                if (other instanceof SceneMonsterInfo) {
                    return mergeFrom((SceneMonsterInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneMonsterInfo other) {
                if (other == SceneMonsterInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getMonsterId() != 0) {
                    setMonsterId(other.getMonsterId());
                }
                if (other.getGroupId() != 0) {
                    setGroupId(other.getGroupId());
                }
                if (other.getConfigId() != 0) {
                    setConfigId(other.getConfigId());
                }
                if (this.weaponListBuilder_ == null) {
                    if (!other.weaponList_.isEmpty()) {
                        if (this.weaponList_.isEmpty()) {
                            this.weaponList_ = other.weaponList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureWeaponListIsMutable();
                            this.weaponList_.addAll(other.weaponList_);
                        }
                        onChanged();
                    }
                } else if (!other.weaponList_.isEmpty()) {
                    if (this.weaponListBuilder_.isEmpty()) {
                        this.weaponListBuilder_.dispose();
                        this.weaponListBuilder_ = null;
                        this.weaponList_ = other.weaponList_;
                        this.bitField0_ &= -2;
                        this.weaponListBuilder_ = SceneMonsterInfo.alwaysUseFieldBuilders ? getWeaponListFieldBuilder() : null;
                    } else {
                        this.weaponListBuilder_.addAllMessages(other.weaponList_);
                    }
                }
                if (other.getAuthorityPeerId() != 0) {
                    setAuthorityPeerId(other.getAuthorityPeerId());
                }
                if (!other.affixList_.isEmpty()) {
                    if (this.affixList_.isEmpty()) {
                        this.affixList_ = other.affixList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureAffixListIsMutable();
                        this.affixList_.addAll(other.affixList_);
                    }
                    onChanged();
                }
                if (other.getIsElite()) {
                    setIsElite(other.getIsElite());
                }
                if (other.getOwnerEntityId() != 0) {
                    setOwnerEntityId(other.getOwnerEntityId());
                }
                if (other.getSummonedTag() != 0) {
                    setSummonedTag(other.getSummonedTag());
                }
                internalGetMutableSummonTagMap().mergeFrom(other.internalGetSummonTagMap());
                if (other.getPoseId() != 0) {
                    setPoseId(other.getPoseId());
                }
                if (other.bornType_ != 0) {
                    setBornTypeValue(other.getBornTypeValue());
                }
                if (other.getBlockId() != 0) {
                    setBlockId(other.getBlockId());
                }
                if (other.getMarkFlag() != 0) {
                    setMarkFlag(other.getMarkFlag());
                }
                if (other.getTitleId() != 0) {
                    setTitleId(other.getTitleId());
                }
                if (other.getSpecialNameId() != 0) {
                    setSpecialNameId(other.getSpecialNameId());
                }
                if (other.getAttackTargetId() != 0) {
                    setAttackTargetId(other.getAttackTargetId());
                }
                if (other.hasMonsterRoute()) {
                    mergeMonsterRoute(other.getMonsterRoute());
                }
                if (other.getAiConfigId() != 0) {
                    setAiConfigId(other.getAiConfigId());
                }
                if (other.getLevelRouteId() != 0) {
                    setLevelRouteId(other.getLevelRouteId());
                }
                if (other.getInitPoseId() != 0) {
                    setInitPoseId(other.getInitPoseId());
                }
                if (other.getIsLight()) {
                    setIsLight(other.getIsLight());
                }
                if (other.getKillNum() != 0) {
                    setKillNum(other.getKillNum());
                }
                switch (other.getContentCase()) {
                    case FISH_INFO:
                        mergeFishInfo(other.getFishInfo());
                        break;
                    case FISHTANK_FISH_INFO:
                        mergeFishtankFishInfo(other.getFishtankFishInfo());
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
                SceneMonsterInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneMonsterInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneMonsterInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public ContentCase getContentCase() {
                return ContentCase.forNumber(this.contentCase_);
            }

            public Builder clearContent() {
                this.contentCase_ = 0;
                this.content_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getConfigId() {
                return this.configId_;
            }

            public Builder setConfigId(int value) {
                this.configId_ = value;
                onChanged();
                return this;
            }

            public Builder clearConfigId() {
                this.configId_ = 0;
                onChanged();
                return this;
            }

            private void ensureWeaponListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.weaponList_ = new ArrayList(this.weaponList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public List<SceneWeaponInfoOuterClass.SceneWeaponInfo> getWeaponListList() {
                if (this.weaponListBuilder_ == null) {
                    return Collections.unmodifiableList(this.weaponList_);
                }
                return this.weaponListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getWeaponListCount() {
                if (this.weaponListBuilder_ == null) {
                    return this.weaponList_.size();
                }
                return this.weaponListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public SceneWeaponInfoOuterClass.SceneWeaponInfo getWeaponList(int index) {
                if (this.weaponListBuilder_ == null) {
                    return this.weaponList_.get(index);
                }
                return this.weaponListBuilder_.getMessage(index);
            }

            public Builder setWeaponList(int index, SceneWeaponInfoOuterClass.SceneWeaponInfo value) {
                if (this.weaponListBuilder_ != null) {
                    this.weaponListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureWeaponListIsMutable();
                    this.weaponList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setWeaponList(int index, SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder builderForValue) {
                if (this.weaponListBuilder_ == null) {
                    ensureWeaponListIsMutable();
                    this.weaponList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.weaponListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addWeaponList(SceneWeaponInfoOuterClass.SceneWeaponInfo value) {
                if (this.weaponListBuilder_ != null) {
                    this.weaponListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureWeaponListIsMutable();
                    this.weaponList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addWeaponList(int index, SceneWeaponInfoOuterClass.SceneWeaponInfo value) {
                if (this.weaponListBuilder_ != null) {
                    this.weaponListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureWeaponListIsMutable();
                    this.weaponList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addWeaponList(SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder builderForValue) {
                if (this.weaponListBuilder_ == null) {
                    ensureWeaponListIsMutable();
                    this.weaponList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.weaponListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addWeaponList(int index, SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder builderForValue) {
                if (this.weaponListBuilder_ == null) {
                    ensureWeaponListIsMutable();
                    this.weaponList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.weaponListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllWeaponList(Iterable<? extends SceneWeaponInfoOuterClass.SceneWeaponInfo> values) {
                if (this.weaponListBuilder_ == null) {
                    ensureWeaponListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.weaponList_);
                    onChanged();
                } else {
                    this.weaponListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearWeaponList() {
                if (this.weaponListBuilder_ == null) {
                    this.weaponList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.weaponListBuilder_.clear();
                }
                return this;
            }

            public Builder removeWeaponList(int index) {
                if (this.weaponListBuilder_ == null) {
                    ensureWeaponListIsMutable();
                    this.weaponList_.remove(index);
                    onChanged();
                } else {
                    this.weaponListBuilder_.remove(index);
                }
                return this;
            }

            public SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder getWeaponListBuilder(int index) {
                return getWeaponListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder getWeaponListOrBuilder(int index) {
                if (this.weaponListBuilder_ == null) {
                    return this.weaponList_.get(index);
                }
                return this.weaponListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public List<? extends SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder> getWeaponListOrBuilderList() {
                if (this.weaponListBuilder_ != null) {
                    return this.weaponListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.weaponList_);
            }

            public SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder addWeaponListBuilder() {
                return getWeaponListFieldBuilder().addBuilder(SceneWeaponInfoOuterClass.SceneWeaponInfo.getDefaultInstance());
            }

            public SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder addWeaponListBuilder(int index) {
                return getWeaponListFieldBuilder().addBuilder(index, SceneWeaponInfoOuterClass.SceneWeaponInfo.getDefaultInstance());
            }

            public List<SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder> getWeaponListBuilderList() {
                return getWeaponListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SceneWeaponInfoOuterClass.SceneWeaponInfo, SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder, SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder> getWeaponListFieldBuilder() {
                if (this.weaponListBuilder_ == null) {
                    this.weaponListBuilder_ = new RepeatedFieldBuilderV3<>(this.weaponList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.weaponList_ = null;
                }
                return this.weaponListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getAuthorityPeerId() {
                return this.authorityPeerId_;
            }

            public Builder setAuthorityPeerId(int value) {
                this.authorityPeerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAuthorityPeerId() {
                this.authorityPeerId_ = 0;
                onChanged();
                return this;
            }

            private void ensureAffixListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.affixList_ = SceneMonsterInfo.mutableCopy(this.affixList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public List<Integer> getAffixListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.affixList_) : this.affixList_;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getAffixListCount() {
                return this.affixList_.size();
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getAffixList(int index) {
                return this.affixList_.getInt(index);
            }

            public Builder setAffixList(int index, int value) {
                ensureAffixListIsMutable();
                this.affixList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addAffixList(int value) {
                ensureAffixListIsMutable();
                this.affixList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllAffixList(Iterable<? extends Integer> values) {
                ensureAffixListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.affixList_);
                onChanged();
                return this;
            }

            public Builder clearAffixList() {
                this.affixList_ = SceneMonsterInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public boolean getIsElite() {
                return this.isElite_;
            }

            public Builder setIsElite(boolean value) {
                this.isElite_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsElite() {
                this.isElite_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getOwnerEntityId() {
                return this.ownerEntityId_;
            }

            public Builder setOwnerEntityId(int value) {
                this.ownerEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearOwnerEntityId() {
                this.ownerEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getSummonedTag() {
                return this.summonedTag_;
            }

            public Builder setSummonedTag(int value) {
                this.summonedTag_ = value;
                onChanged();
                return this;
            }

            public Builder clearSummonedTag() {
                this.summonedTag_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetSummonTagMap() {
                if (this.summonTagMap_ == null) {
                    return MapField.emptyMapField(SummonTagMapDefaultEntryHolder.defaultEntry);
                }
                return this.summonTagMap_;
            }

            private MapField<Integer, Integer> internalGetMutableSummonTagMap() {
                onChanged();
                if (this.summonTagMap_ == null) {
                    this.summonTagMap_ = MapField.newMapField(SummonTagMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.summonTagMap_.isMutable()) {
                    this.summonTagMap_ = this.summonTagMap_.copy();
                }
                return this.summonTagMap_;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getSummonTagMapCount() {
                return internalGetSummonTagMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public boolean containsSummonTagMap(int key) {
                return internalGetSummonTagMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getSummonTagMap() {
                return getSummonTagMapMap();
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public Map<Integer, Integer> getSummonTagMapMap() {
                return internalGetSummonTagMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getSummonTagMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetSummonTagMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getSummonTagMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetSummonTagMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearSummonTagMap() {
                internalGetMutableSummonTagMap().getMutableMap().clear();
                return this;
            }

            public Builder removeSummonTagMap(int key) {
                internalGetMutableSummonTagMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableSummonTagMap() {
                return internalGetMutableSummonTagMap().getMutableMap();
            }

            public Builder putSummonTagMap(int key, int value) {
                internalGetMutableSummonTagMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllSummonTagMap(Map<Integer, Integer> values) {
                internalGetMutableSummonTagMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getPoseId() {
                return this.poseId_;
            }

            public Builder setPoseId(int value) {
                this.poseId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPoseId() {
                this.poseId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getBornTypeValue() {
                return this.bornType_;
            }

            public Builder setBornTypeValue(int value) {
                this.bornType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public MonsterBornTypeOuterClass.MonsterBornType getBornType() {
                MonsterBornTypeOuterClass.MonsterBornType result = MonsterBornTypeOuterClass.MonsterBornType.valueOf(this.bornType_);
                return result == null ? MonsterBornTypeOuterClass.MonsterBornType.UNRECOGNIZED : result;
            }

            public Builder setBornType(MonsterBornTypeOuterClass.MonsterBornType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bornType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearBornType() {
                this.bornType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getBlockId() {
                return this.blockId_;
            }

            public Builder setBlockId(int value) {
                this.blockId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBlockId() {
                this.blockId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getMarkFlag() {
                return this.markFlag_;
            }

            public Builder setMarkFlag(int value) {
                this.markFlag_ = value;
                onChanged();
                return this;
            }

            public Builder clearMarkFlag() {
                this.markFlag_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getTitleId() {
                return this.titleId_;
            }

            public Builder setTitleId(int value) {
                this.titleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTitleId() {
                this.titleId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getSpecialNameId() {
                return this.specialNameId_;
            }

            public Builder setSpecialNameId(int value) {
                this.specialNameId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSpecialNameId() {
                this.specialNameId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getAttackTargetId() {
                return this.attackTargetId_;
            }

            public Builder setAttackTargetId(int value) {
                this.attackTargetId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAttackTargetId() {
                this.attackTargetId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public boolean hasMonsterRoute() {
                return (this.monsterRouteBuilder_ == null && this.monsterRoute_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public MonsterRouteOuterClass.MonsterRoute getMonsterRoute() {
                if (this.monsterRouteBuilder_ == null) {
                    return this.monsterRoute_ == null ? MonsterRouteOuterClass.MonsterRoute.getDefaultInstance() : this.monsterRoute_;
                }
                return this.monsterRouteBuilder_.getMessage();
            }

            public Builder setMonsterRoute(MonsterRouteOuterClass.MonsterRoute value) {
                if (this.monsterRouteBuilder_ != null) {
                    this.monsterRouteBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.monsterRoute_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setMonsterRoute(MonsterRouteOuterClass.MonsterRoute.Builder builderForValue) {
                if (this.monsterRouteBuilder_ == null) {
                    this.monsterRoute_ = builderForValue.build();
                    onChanged();
                } else {
                    this.monsterRouteBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeMonsterRoute(MonsterRouteOuterClass.MonsterRoute value) {
                if (this.monsterRouteBuilder_ == null) {
                    if (this.monsterRoute_ != null) {
                        this.monsterRoute_ = MonsterRouteOuterClass.MonsterRoute.newBuilder(this.monsterRoute_).mergeFrom(value).buildPartial();
                    } else {
                        this.monsterRoute_ = value;
                    }
                    onChanged();
                } else {
                    this.monsterRouteBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearMonsterRoute() {
                if (this.monsterRouteBuilder_ == null) {
                    this.monsterRoute_ = null;
                    onChanged();
                } else {
                    this.monsterRoute_ = null;
                    this.monsterRouteBuilder_ = null;
                }
                return this;
            }

            public MonsterRouteOuterClass.MonsterRoute.Builder getMonsterRouteBuilder() {
                onChanged();
                return getMonsterRouteFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public MonsterRouteOuterClass.MonsterRouteOrBuilder getMonsterRouteOrBuilder() {
                if (this.monsterRouteBuilder_ != null) {
                    return this.monsterRouteBuilder_.getMessageOrBuilder();
                }
                return this.monsterRoute_ == null ? MonsterRouteOuterClass.MonsterRoute.getDefaultInstance() : this.monsterRoute_;
            }

            private SingleFieldBuilderV3<MonsterRouteOuterClass.MonsterRoute, MonsterRouteOuterClass.MonsterRoute.Builder, MonsterRouteOuterClass.MonsterRouteOrBuilder> getMonsterRouteFieldBuilder() {
                if (this.monsterRouteBuilder_ == null) {
                    this.monsterRouteBuilder_ = new SingleFieldBuilderV3<>(getMonsterRoute(), getParentForChildren(), isClean());
                    this.monsterRoute_ = null;
                }
                return this.monsterRouteBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getAiConfigId() {
                return this.aiConfigId_;
            }

            public Builder setAiConfigId(int value) {
                this.aiConfigId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAiConfigId() {
                this.aiConfigId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getLevelRouteId() {
                return this.levelRouteId_;
            }

            public Builder setLevelRouteId(int value) {
                this.levelRouteId_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevelRouteId() {
                this.levelRouteId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getInitPoseId() {
                return this.initPoseId_;
            }

            public Builder setInitPoseId(int value) {
                this.initPoseId_ = value;
                onChanged();
                return this;
            }

            public Builder clearInitPoseId() {
                this.initPoseId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public boolean getIsLight() {
                return this.isLight_;
            }

            public Builder setIsLight(boolean value) {
                this.isLight_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsLight() {
                this.isLight_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public int getKillNum() {
                return this.killNum_;
            }

            public Builder setKillNum(int value) {
                this.killNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearKillNum() {
                this.killNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public boolean hasFishInfo() {
                return this.contentCase_ == 50;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public SceneFishInfoOuterClass.SceneFishInfo getFishInfo() {
                if (this.fishInfoBuilder_ == null) {
                    if (this.contentCase_ == 50) {
                        return (SceneFishInfoOuterClass.SceneFishInfo) this.content_;
                    }
                    return SceneFishInfoOuterClass.SceneFishInfo.getDefaultInstance();
                } else if (this.contentCase_ == 50) {
                    return this.fishInfoBuilder_.getMessage();
                } else {
                    return SceneFishInfoOuterClass.SceneFishInfo.getDefaultInstance();
                }
            }

            public Builder setFishInfo(SceneFishInfoOuterClass.SceneFishInfo value) {
                if (this.fishInfoBuilder_ != null) {
                    this.fishInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 50;
                return this;
            }

            public Builder setFishInfo(SceneFishInfoOuterClass.SceneFishInfo.Builder builderForValue) {
                if (this.fishInfoBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.fishInfoBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 50;
                return this;
            }

            public Builder mergeFishInfo(SceneFishInfoOuterClass.SceneFishInfo value) {
                if (this.fishInfoBuilder_ == null) {
                    if (this.contentCase_ != 50 || this.content_ == SceneFishInfoOuterClass.SceneFishInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = SceneFishInfoOuterClass.SceneFishInfo.newBuilder((SceneFishInfoOuterClass.SceneFishInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 50) {
                        this.fishInfoBuilder_.mergeFrom(value);
                    }
                    this.fishInfoBuilder_.setMessage(value);
                }
                this.contentCase_ = 50;
                return this;
            }

            public Builder clearFishInfo() {
                if (this.fishInfoBuilder_ != null) {
                    if (this.contentCase_ == 50) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.fishInfoBuilder_.clear();
                } else if (this.contentCase_ == 50) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public SceneFishInfoOuterClass.SceneFishInfo.Builder getFishInfoBuilder() {
                return getFishInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public SceneFishInfoOuterClass.SceneFishInfoOrBuilder getFishInfoOrBuilder() {
                if (this.contentCase_ == 50 && this.fishInfoBuilder_ != null) {
                    return this.fishInfoBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 50) {
                    return (SceneFishInfoOuterClass.SceneFishInfo) this.content_;
                }
                return SceneFishInfoOuterClass.SceneFishInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SceneFishInfoOuterClass.SceneFishInfo, SceneFishInfoOuterClass.SceneFishInfo.Builder, SceneFishInfoOuterClass.SceneFishInfoOrBuilder> getFishInfoFieldBuilder() {
                if (this.fishInfoBuilder_ == null) {
                    if (this.contentCase_ != 50) {
                        this.content_ = SceneFishInfoOuterClass.SceneFishInfo.getDefaultInstance();
                    }
                    this.fishInfoBuilder_ = new SingleFieldBuilderV3<>((SceneFishInfoOuterClass.SceneFishInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 50;
                onChanged();
                return this.fishInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public boolean hasFishtankFishInfo() {
                return this.contentCase_ == 51;
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public FishtankFishInfoOuterClass.FishtankFishInfo getFishtankFishInfo() {
                if (this.fishtankFishInfoBuilder_ == null) {
                    if (this.contentCase_ == 51) {
                        return (FishtankFishInfoOuterClass.FishtankFishInfo) this.content_;
                    }
                    return FishtankFishInfoOuterClass.FishtankFishInfo.getDefaultInstance();
                } else if (this.contentCase_ == 51) {
                    return this.fishtankFishInfoBuilder_.getMessage();
                } else {
                    return FishtankFishInfoOuterClass.FishtankFishInfo.getDefaultInstance();
                }
            }

            public Builder setFishtankFishInfo(FishtankFishInfoOuterClass.FishtankFishInfo value) {
                if (this.fishtankFishInfoBuilder_ != null) {
                    this.fishtankFishInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 51;
                return this;
            }

            public Builder setFishtankFishInfo(FishtankFishInfoOuterClass.FishtankFishInfo.Builder builderForValue) {
                if (this.fishtankFishInfoBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.fishtankFishInfoBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 51;
                return this;
            }

            public Builder mergeFishtankFishInfo(FishtankFishInfoOuterClass.FishtankFishInfo value) {
                if (this.fishtankFishInfoBuilder_ == null) {
                    if (this.contentCase_ != 51 || this.content_ == FishtankFishInfoOuterClass.FishtankFishInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = FishtankFishInfoOuterClass.FishtankFishInfo.newBuilder((FishtankFishInfoOuterClass.FishtankFishInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 51) {
                        this.fishtankFishInfoBuilder_.mergeFrom(value);
                    }
                    this.fishtankFishInfoBuilder_.setMessage(value);
                }
                this.contentCase_ = 51;
                return this;
            }

            public Builder clearFishtankFishInfo() {
                if (this.fishtankFishInfoBuilder_ != null) {
                    if (this.contentCase_ == 51) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.fishtankFishInfoBuilder_.clear();
                } else if (this.contentCase_ == 51) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public FishtankFishInfoOuterClass.FishtankFishInfo.Builder getFishtankFishInfoBuilder() {
                return getFishtankFishInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder
            public FishtankFishInfoOuterClass.FishtankFishInfoOrBuilder getFishtankFishInfoOrBuilder() {
                if (this.contentCase_ == 51 && this.fishtankFishInfoBuilder_ != null) {
                    return this.fishtankFishInfoBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 51) {
                    return (FishtankFishInfoOuterClass.FishtankFishInfo) this.content_;
                }
                return FishtankFishInfoOuterClass.FishtankFishInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<FishtankFishInfoOuterClass.FishtankFishInfo, FishtankFishInfoOuterClass.FishtankFishInfo.Builder, FishtankFishInfoOuterClass.FishtankFishInfoOrBuilder> getFishtankFishInfoFieldBuilder() {
                if (this.fishtankFishInfoBuilder_ == null) {
                    if (this.contentCase_ != 51) {
                        this.content_ = FishtankFishInfoOuterClass.FishtankFishInfo.getDefaultInstance();
                    }
                    this.fishtankFishInfoBuilder_ = new SingleFieldBuilderV3<>((FishtankFishInfoOuterClass.FishtankFishInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 51;
                onChanged();
                return this.fishtankFishInfoBuilder_;
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

        public static SceneMonsterInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneMonsterInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneMonsterInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneMonsterInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FishtankFishInfoOuterClass.getDescriptor();
        MonsterBornTypeOuterClass.getDescriptor();
        MonsterRouteOuterClass.getDescriptor();
        SceneFishInfoOuterClass.getDescriptor();
        SceneWeaponInfoOuterClass.getDescriptor();
    }
}
