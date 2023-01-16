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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass;
import emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass;
import emu.grasscutter.net.proto.EntityClientDataOuterClass;
import emu.grasscutter.net.proto.EntityEnvironmentInfoOuterClass;
import emu.grasscutter.net.proto.FightPropPairOuterClass;
import emu.grasscutter.net.proto.MotionInfoOuterClass;
import emu.grasscutter.net.proto.PropPairOuterClass;
import emu.grasscutter.net.proto.ProtEntityTypeOuterClass;
import emu.grasscutter.net.proto.SceneAvatarInfoOuterClass;
import emu.grasscutter.net.proto.SceneGadgetInfoOuterClass;
import emu.grasscutter.net.proto.SceneMonsterInfoOuterClass;
import emu.grasscutter.net.proto.SceneNpcInfoOuterClass;
import emu.grasscutter.net.proto.ServerBuffOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityInfoOuterClass.class */
public final class SceneEntityInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015SceneEntityInfo.proto\u001a$AnimatorParameterValueInfoPair.proto\u001a\u0019EntityAuthorityInfo.proto\u001a\u0016EntityClientData.proto\u001a\u001bEntityEnvironmentInfo.proto\u001a\u0013FightPropPair.proto\u001a\u0010MotionInfo.proto\u001a\u000ePropPair.proto\u001a\u0014ProtEntityType.proto\u001a\u0015SceneAvatarInfo.proto\u001a\u0015SceneGadgetInfo.proto\u001a\u0016SceneMonsterInfo.proto\u001a\u0012SceneNpcInfo.proto\u001a\u0010ServerBuff.proto\"Ä\u0005\n\u000fSceneEntityInfo\u0012$\n\u000bentity_type\u0018\u0001 \u0001(\u000e2\u000f.ProtEntityType\u0012\u0011\n\tentity_id\u0018\u0002 \u0001(\r\u0012\f\n\u0004name\u0018\u0003 \u0001(\t\u0012 \n\u000bmotion_info\u0018\u0004 \u0001(\u000b2\u000b.MotionInfo\u0012\u001c\n\tprop_list\u0018\u0005 \u0003(\u000b2\t.PropPair\u0012'\n\u000ffight_prop_list\u0018\u0006 \u0003(\u000b2\u000e.FightPropPair\u0012\u0012\n\nlife_state\u0018\u0007 \u0001(\r\u0012;\n\u0012animator_para_list\u0018\t \u0003(\u000b2\u001f.AnimatorParameterValueInfoPair\u0012\u001f\n\u0017last_move_scene_time_ms\u0018\u0011 \u0001(\r\u0012\u001e\n\u0016last_move_reliable_seq\u0018\u0012 \u0001(\r\u0012-\n\u0012entity_client_data\u0018\u0013 \u0001(\u000b2\u0011.EntityClientData\u0012<\n\u001centity_environment_info_list\u0018\u0014 \u0003(\u000b2\u0016.EntityEnvironmentInfo\u00123\n\u0015entity_authority_info\u0018\u0015 \u0001(\u000b2\u0014.EntityAuthorityInfo\u0012\u0010\n\btag_list\u0018\u0016 \u0003(\t\u0012%\n\u0010server_buff_list\u0018\u0017 \u0003(\u000b2\u000b.ServerBuff\u0012\"\n\u0006avatar\u0018\n \u0001(\u000b2\u0010.SceneAvatarInfoH��\u0012$\n\u0007monster\u0018\u000b \u0001(\u000b2\u0011.SceneMonsterInfoH��\u0012\u001c\n\u0003npc\u0018\f \u0001(\u000b2\r.SceneNpcInfoH��\u0012\"\n\u0006gadget\u0018\r \u0001(\u000b2\u0010.SceneGadgetInfoH��B\b\n\u0006entityB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AnimatorParameterValueInfoPairOuterClass.getDescriptor(), EntityAuthorityInfoOuterClass.getDescriptor(), EntityClientDataOuterClass.getDescriptor(), EntityEnvironmentInfoOuterClass.getDescriptor(), FightPropPairOuterClass.getDescriptor(), MotionInfoOuterClass.getDescriptor(), PropPairOuterClass.getDescriptor(), ProtEntityTypeOuterClass.getDescriptor(), SceneAvatarInfoOuterClass.getDescriptor(), SceneGadgetInfoOuterClass.getDescriptor(), SceneMonsterInfoOuterClass.getDescriptor(), SceneNpcInfoOuterClass.getDescriptor(), ServerBuffOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SceneEntityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneEntityInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneEntityInfo_descriptor, new String[]{"EntityType", "EntityId", "Name", "MotionInfo", "PropList", "FightPropList", "LifeState", "AnimatorParaList", "LastMoveSceneTimeMs", "LastMoveReliableSeq", "EntityClientData", "EntityEnvironmentInfoList", "EntityAuthorityInfo", "TagList", "ServerBuffList", "Avatar", "Monster", "Npc", "Gadget", "Entity"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityInfoOuterClass$SceneEntityInfoOrBuilder.class */
    public interface SceneEntityInfoOrBuilder extends MessageOrBuilder {
        int getEntityTypeValue();

        ProtEntityTypeOuterClass.ProtEntityType getEntityType();

        int getEntityId();

        String getName();

        ByteString getNameBytes();

        boolean hasMotionInfo();

        MotionInfoOuterClass.MotionInfo getMotionInfo();

        MotionInfoOuterClass.MotionInfoOrBuilder getMotionInfoOrBuilder();

        List<PropPairOuterClass.PropPair> getPropListList();

        PropPairOuterClass.PropPair getPropList(int i);

        int getPropListCount();

        List<? extends PropPairOuterClass.PropPairOrBuilder> getPropListOrBuilderList();

        PropPairOuterClass.PropPairOrBuilder getPropListOrBuilder(int i);

        List<FightPropPairOuterClass.FightPropPair> getFightPropListList();

        FightPropPairOuterClass.FightPropPair getFightPropList(int i);

        int getFightPropListCount();

        List<? extends FightPropPairOuterClass.FightPropPairOrBuilder> getFightPropListOrBuilderList();

        FightPropPairOuterClass.FightPropPairOrBuilder getFightPropListOrBuilder(int i);

        int getLifeState();

        List<AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair> getAnimatorParaListList();

        AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair getAnimatorParaList(int i);

        int getAnimatorParaListCount();

        List<? extends AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder> getAnimatorParaListOrBuilderList();

        AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder getAnimatorParaListOrBuilder(int i);

        int getLastMoveSceneTimeMs();

        int getLastMoveReliableSeq();

        boolean hasEntityClientData();

        EntityClientDataOuterClass.EntityClientData getEntityClientData();

        EntityClientDataOuterClass.EntityClientDataOrBuilder getEntityClientDataOrBuilder();

        List<EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo> getEntityEnvironmentInfoListList();

        EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo getEntityEnvironmentInfoList(int i);

        int getEntityEnvironmentInfoListCount();

        List<? extends EntityEnvironmentInfoOuterClass.EntityEnvironmentInfoOrBuilder> getEntityEnvironmentInfoListOrBuilderList();

        EntityEnvironmentInfoOuterClass.EntityEnvironmentInfoOrBuilder getEntityEnvironmentInfoListOrBuilder(int i);

        boolean hasEntityAuthorityInfo();

        EntityAuthorityInfoOuterClass.EntityAuthorityInfo getEntityAuthorityInfo();

        EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder getEntityAuthorityInfoOrBuilder();

        List<String> getTagListList();

        int getTagListCount();

        String getTagList(int i);

        ByteString getTagListBytes(int i);

        List<ServerBuffOuterClass.ServerBuff> getServerBuffListList();

        ServerBuffOuterClass.ServerBuff getServerBuffList(int i);

        int getServerBuffListCount();

        List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList();

        ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int i);

        boolean hasAvatar();

        SceneAvatarInfoOuterClass.SceneAvatarInfo getAvatar();

        SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder getAvatarOrBuilder();

        boolean hasMonster();

        SceneMonsterInfoOuterClass.SceneMonsterInfo getMonster();

        SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder getMonsterOrBuilder();

        boolean hasNpc();

        SceneNpcInfoOuterClass.SceneNpcInfo getNpc();

        SceneNpcInfoOuterClass.SceneNpcInfoOrBuilder getNpcOrBuilder();

        boolean hasGadget();

        SceneGadgetInfoOuterClass.SceneGadgetInfo getGadget();

        SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder getGadgetOrBuilder();

        SceneEntityInfo.EntityCase getEntityCase();
    }

    private SceneEntityInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityInfoOuterClass$SceneEntityInfo.class */
    public static final class SceneEntityInfo extends GeneratedMessageV3 implements SceneEntityInfoOrBuilder {
        private static final long serialVersionUID = 0;
        private int entityCase_;
        private Object entity_;
        public static final int ENTITY_TYPE_FIELD_NUMBER = 1;
        private int entityType_;
        public static final int ENTITY_ID_FIELD_NUMBER = 2;
        private int entityId_;
        public static final int NAME_FIELD_NUMBER = 3;
        private volatile Object name_;
        public static final int MOTION_INFO_FIELD_NUMBER = 4;
        private MotionInfoOuterClass.MotionInfo motionInfo_;
        public static final int PROP_LIST_FIELD_NUMBER = 5;
        private List<PropPairOuterClass.PropPair> propList_;
        public static final int FIGHT_PROP_LIST_FIELD_NUMBER = 6;
        private List<FightPropPairOuterClass.FightPropPair> fightPropList_;
        public static final int LIFE_STATE_FIELD_NUMBER = 7;
        private int lifeState_;
        public static final int ANIMATOR_PARA_LIST_FIELD_NUMBER = 9;
        private List<AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair> animatorParaList_;
        public static final int LAST_MOVE_SCENE_TIME_MS_FIELD_NUMBER = 17;
        private int lastMoveSceneTimeMs_;
        public static final int LAST_MOVE_RELIABLE_SEQ_FIELD_NUMBER = 18;
        private int lastMoveReliableSeq_;
        public static final int ENTITY_CLIENT_DATA_FIELD_NUMBER = 19;
        private EntityClientDataOuterClass.EntityClientData entityClientData_;
        public static final int ENTITY_ENVIRONMENT_INFO_LIST_FIELD_NUMBER = 20;
        private List<EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo> entityEnvironmentInfoList_;
        public static final int ENTITY_AUTHORITY_INFO_FIELD_NUMBER = 21;
        private EntityAuthorityInfoOuterClass.EntityAuthorityInfo entityAuthorityInfo_;
        public static final int TAG_LIST_FIELD_NUMBER = 22;
        private LazyStringList tagList_;
        public static final int SERVER_BUFF_LIST_FIELD_NUMBER = 23;
        private List<ServerBuffOuterClass.ServerBuff> serverBuffList_;
        public static final int AVATAR_FIELD_NUMBER = 10;
        public static final int MONSTER_FIELD_NUMBER = 11;
        public static final int NPC_FIELD_NUMBER = 12;
        public static final int GADGET_FIELD_NUMBER = 13;
        private byte memoizedIsInitialized;
        private static final SceneEntityInfo DEFAULT_INSTANCE = new SceneEntityInfo();
        private static final Parser<SceneEntityInfo> PARSER = new AbstractParser<SceneEntityInfo>() { // from class: emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfo.1
            @Override // com.google.protobuf.Parser
            public SceneEntityInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneEntityInfo(input, extensionRegistry);
            }
        };

        private SceneEntityInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.entityCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private SceneEntityInfo() {
            this.entityCase_ = 0;
            this.memoizedIsInitialized = -1;
            this.entityType_ = 0;
            this.name_ = "";
            this.propList_ = Collections.emptyList();
            this.fightPropList_ = Collections.emptyList();
            this.animatorParaList_ = Collections.emptyList();
            this.entityEnvironmentInfoList_ = Collections.emptyList();
            this.tagList_ = LazyStringArrayList.EMPTY;
            this.serverBuffList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneEntityInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:170:0x0418 */
        private SceneEntityInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.entityType_ = input.readEnum();
                                break;
                            case 16:
                                this.entityId_ = input.readUInt32();
                                break;
                            case 26:
                                this.name_ = input.readStringRequireUtf8();
                                break;
                            case 34:
                                MotionInfoOuterClass.MotionInfo.Builder subBuilder = this.motionInfo_ != null ? this.motionInfo_.toBuilder() : null;
                                this.motionInfo_ = (MotionInfoOuterClass.MotionInfo) input.readMessage(MotionInfoOuterClass.MotionInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.motionInfo_);
                                    this.motionInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 42:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.propList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.propList_.add((PropPairOuterClass.PropPair) input.readMessage(PropPairOuterClass.PropPair.parser(), extensionRegistry));
                                break;
                            case 50:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.fightPropList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.fightPropList_.add((FightPropPairOuterClass.FightPropPair) input.readMessage(FightPropPairOuterClass.FightPropPair.parser(), extensionRegistry));
                                break;
                            case 56:
                                this.lifeState_ = input.readUInt32();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.animatorParaList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.animatorParaList_.add((AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair) input.readMessage(AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.parser(), extensionRegistry));
                                break;
                            case 82:
                                SceneAvatarInfoOuterClass.SceneAvatarInfo.Builder subBuilder2 = this.entityCase_ == 10 ? ((SceneAvatarInfoOuterClass.SceneAvatarInfo) this.entity_).toBuilder() : null;
                                this.entity_ = input.readMessage(SceneAvatarInfoOuterClass.SceneAvatarInfo.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((SceneAvatarInfoOuterClass.SceneAvatarInfo) this.entity_);
                                    this.entity_ = subBuilder2.buildPartial();
                                }
                                this.entityCase_ = 10;
                                break;
                            case 90:
                                SceneMonsterInfoOuterClass.SceneMonsterInfo.Builder subBuilder3 = this.entityCase_ == 11 ? ((SceneMonsterInfoOuterClass.SceneMonsterInfo) this.entity_).toBuilder() : null;
                                this.entity_ = input.readMessage(SceneMonsterInfoOuterClass.SceneMonsterInfo.parser(), extensionRegistry);
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((SceneMonsterInfoOuterClass.SceneMonsterInfo) this.entity_);
                                    this.entity_ = subBuilder3.buildPartial();
                                }
                                this.entityCase_ = 11;
                                break;
                            case 98:
                                SceneNpcInfoOuterClass.SceneNpcInfo.Builder subBuilder4 = this.entityCase_ == 12 ? ((SceneNpcInfoOuterClass.SceneNpcInfo) this.entity_).toBuilder() : null;
                                this.entity_ = input.readMessage(SceneNpcInfoOuterClass.SceneNpcInfo.parser(), extensionRegistry);
                                if (subBuilder4 != null) {
                                    subBuilder4.mergeFrom((SceneNpcInfoOuterClass.SceneNpcInfo) this.entity_);
                                    this.entity_ = subBuilder4.buildPartial();
                                }
                                this.entityCase_ = 12;
                                break;
                            case 106:
                                SceneGadgetInfoOuterClass.SceneGadgetInfo.Builder subBuilder5 = this.entityCase_ == 13 ? ((SceneGadgetInfoOuterClass.SceneGadgetInfo) this.entity_).toBuilder() : null;
                                this.entity_ = input.readMessage(SceneGadgetInfoOuterClass.SceneGadgetInfo.parser(), extensionRegistry);
                                if (subBuilder5 != null) {
                                    subBuilder5.mergeFrom((SceneGadgetInfoOuterClass.SceneGadgetInfo) this.entity_);
                                    this.entity_ = subBuilder5.buildPartial();
                                }
                                this.entityCase_ = 13;
                                break;
                            case 136:
                                this.lastMoveSceneTimeMs_ = input.readUInt32();
                                break;
                            case 144:
                                this.lastMoveReliableSeq_ = input.readUInt32();
                                break;
                            case 154:
                                EntityClientDataOuterClass.EntityClientData.Builder subBuilder6 = this.entityClientData_ != null ? this.entityClientData_.toBuilder() : null;
                                this.entityClientData_ = (EntityClientDataOuterClass.EntityClientData) input.readMessage(EntityClientDataOuterClass.EntityClientData.parser(), extensionRegistry);
                                if (subBuilder6 == null) {
                                    break;
                                } else {
                                    subBuilder6.mergeFrom(this.entityClientData_);
                                    this.entityClientData_ = subBuilder6.buildPartial();
                                    break;
                                }
                            case 162:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.entityEnvironmentInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.entityEnvironmentInfoList_.add((EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo) input.readMessage(EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo.parser(), extensionRegistry));
                                break;
                            case 170:
                                EntityAuthorityInfoOuterClass.EntityAuthorityInfo.Builder subBuilder7 = this.entityAuthorityInfo_ != null ? this.entityAuthorityInfo_.toBuilder() : null;
                                this.entityAuthorityInfo_ = (EntityAuthorityInfoOuterClass.EntityAuthorityInfo) input.readMessage(EntityAuthorityInfoOuterClass.EntityAuthorityInfo.parser(), extensionRegistry);
                                if (subBuilder7 == null) {
                                    break;
                                } else {
                                    subBuilder7.mergeFrom(this.entityAuthorityInfo_);
                                    this.entityAuthorityInfo_ = subBuilder7.buildPartial();
                                    break;
                                }
                            case 178:
                                String s = input.readStringRequireUtf8();
                                if ((mutable_bitField0_ & 16) == 0) {
                                    this.tagList_ = new LazyStringArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                this.tagList_.add(s);
                                break;
                            case 186:
                                if ((mutable_bitField0_ & 32) == 0) {
                                    this.serverBuffList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                }
                                this.serverBuffList_.add((ServerBuffOuterClass.ServerBuff) input.readMessage(ServerBuffOuterClass.ServerBuff.parser(), extensionRegistry));
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
                    this.propList_ = Collections.unmodifiableList(this.propList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.fightPropList_ = Collections.unmodifiableList(this.fightPropList_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.animatorParaList_ = Collections.unmodifiableList(this.animatorParaList_);
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.entityEnvironmentInfoList_ = Collections.unmodifiableList(this.entityEnvironmentInfoList_);
                }
                if ((mutable_bitField0_ & 16) != 0) {
                    this.tagList_ = this.tagList_.getUnmodifiableView();
                }
                if ((mutable_bitField0_ & 32) != 0) {
                    this.serverBuffList_ = Collections.unmodifiableList(this.serverBuffList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SceneEntityInfoOuterClass.internal_static_SceneEntityInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneEntityInfoOuterClass.internal_static_SceneEntityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneEntityInfo.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityInfoOuterClass$SceneEntityInfo$EntityCase.class */
        public enum EntityCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            AVATAR(10),
            MONSTER(11),
            NPC(12),
            GADGET(13),
            ENTITY_NOT_SET(0);
            
            private final int value;

            EntityCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static EntityCase valueOf(int value) {
                return forNumber(value);
            }

            public static EntityCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return ENTITY_NOT_SET;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    default:
                        return null;
                    case 10:
                        return AVATAR;
                    case 11:
                        return MONSTER;
                    case 12:
                        return NPC;
                    case 13:
                        return GADGET;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public EntityCase getEntityCase() {
            return EntityCase.forNumber(this.entityCase_);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public int getEntityTypeValue() {
            return this.entityType_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public ProtEntityTypeOuterClass.ProtEntityType getEntityType() {
            ProtEntityTypeOuterClass.ProtEntityType result = ProtEntityTypeOuterClass.ProtEntityType.valueOf(this.entityType_);
            return result == null ? ProtEntityTypeOuterClass.ProtEntityType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.name_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public boolean hasMotionInfo() {
            return this.motionInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public MotionInfoOuterClass.MotionInfo getMotionInfo() {
            return this.motionInfo_ == null ? MotionInfoOuterClass.MotionInfo.getDefaultInstance() : this.motionInfo_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public MotionInfoOuterClass.MotionInfoOrBuilder getMotionInfoOrBuilder() {
            return getMotionInfo();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public List<PropPairOuterClass.PropPair> getPropListList() {
            return this.propList_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public List<? extends PropPairOuterClass.PropPairOrBuilder> getPropListOrBuilderList() {
            return this.propList_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public int getPropListCount() {
            return this.propList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public PropPairOuterClass.PropPair getPropList(int index) {
            return this.propList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public PropPairOuterClass.PropPairOrBuilder getPropListOrBuilder(int index) {
            return this.propList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public List<FightPropPairOuterClass.FightPropPair> getFightPropListList() {
            return this.fightPropList_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public List<? extends FightPropPairOuterClass.FightPropPairOrBuilder> getFightPropListOrBuilderList() {
            return this.fightPropList_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public int getFightPropListCount() {
            return this.fightPropList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public FightPropPairOuterClass.FightPropPair getFightPropList(int index) {
            return this.fightPropList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public FightPropPairOuterClass.FightPropPairOrBuilder getFightPropListOrBuilder(int index) {
            return this.fightPropList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public int getLifeState() {
            return this.lifeState_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public List<AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair> getAnimatorParaListList() {
            return this.animatorParaList_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public List<? extends AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder> getAnimatorParaListOrBuilderList() {
            return this.animatorParaList_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public int getAnimatorParaListCount() {
            return this.animatorParaList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair getAnimatorParaList(int index) {
            return this.animatorParaList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder getAnimatorParaListOrBuilder(int index) {
            return this.animatorParaList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public int getLastMoveSceneTimeMs() {
            return this.lastMoveSceneTimeMs_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public int getLastMoveReliableSeq() {
            return this.lastMoveReliableSeq_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public boolean hasEntityClientData() {
            return this.entityClientData_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public EntityClientDataOuterClass.EntityClientData getEntityClientData() {
            return this.entityClientData_ == null ? EntityClientDataOuterClass.EntityClientData.getDefaultInstance() : this.entityClientData_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public EntityClientDataOuterClass.EntityClientDataOrBuilder getEntityClientDataOrBuilder() {
            return getEntityClientData();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public List<EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo> getEntityEnvironmentInfoListList() {
            return this.entityEnvironmentInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public List<? extends EntityEnvironmentInfoOuterClass.EntityEnvironmentInfoOrBuilder> getEntityEnvironmentInfoListOrBuilderList() {
            return this.entityEnvironmentInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public int getEntityEnvironmentInfoListCount() {
            return this.entityEnvironmentInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo getEntityEnvironmentInfoList(int index) {
            return this.entityEnvironmentInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public EntityEnvironmentInfoOuterClass.EntityEnvironmentInfoOrBuilder getEntityEnvironmentInfoListOrBuilder(int index) {
            return this.entityEnvironmentInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public boolean hasEntityAuthorityInfo() {
            return this.entityAuthorityInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public EntityAuthorityInfoOuterClass.EntityAuthorityInfo getEntityAuthorityInfo() {
            return this.entityAuthorityInfo_ == null ? EntityAuthorityInfoOuterClass.EntityAuthorityInfo.getDefaultInstance() : this.entityAuthorityInfo_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder getEntityAuthorityInfoOrBuilder() {
            return getEntityAuthorityInfo();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public ProtocolStringList getTagListList() {
            return this.tagList_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public int getTagListCount() {
            return this.tagList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public String getTagList(int index) {
            return (String) this.tagList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public ByteString getTagListBytes(int index) {
            return this.tagList_.getByteString(index);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public List<ServerBuffOuterClass.ServerBuff> getServerBuffListList() {
            return this.serverBuffList_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList() {
            return this.serverBuffList_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public int getServerBuffListCount() {
            return this.serverBuffList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public ServerBuffOuterClass.ServerBuff getServerBuffList(int index) {
            return this.serverBuffList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int index) {
            return this.serverBuffList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public boolean hasAvatar() {
            return this.entityCase_ == 10;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public SceneAvatarInfoOuterClass.SceneAvatarInfo getAvatar() {
            if (this.entityCase_ == 10) {
                return (SceneAvatarInfoOuterClass.SceneAvatarInfo) this.entity_;
            }
            return SceneAvatarInfoOuterClass.SceneAvatarInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder getAvatarOrBuilder() {
            if (this.entityCase_ == 10) {
                return (SceneAvatarInfoOuterClass.SceneAvatarInfo) this.entity_;
            }
            return SceneAvatarInfoOuterClass.SceneAvatarInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public boolean hasMonster() {
            return this.entityCase_ == 11;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public SceneMonsterInfoOuterClass.SceneMonsterInfo getMonster() {
            if (this.entityCase_ == 11) {
                return (SceneMonsterInfoOuterClass.SceneMonsterInfo) this.entity_;
            }
            return SceneMonsterInfoOuterClass.SceneMonsterInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder getMonsterOrBuilder() {
            if (this.entityCase_ == 11) {
                return (SceneMonsterInfoOuterClass.SceneMonsterInfo) this.entity_;
            }
            return SceneMonsterInfoOuterClass.SceneMonsterInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public boolean hasNpc() {
            return this.entityCase_ == 12;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public SceneNpcInfoOuterClass.SceneNpcInfo getNpc() {
            if (this.entityCase_ == 12) {
                return (SceneNpcInfoOuterClass.SceneNpcInfo) this.entity_;
            }
            return SceneNpcInfoOuterClass.SceneNpcInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public SceneNpcInfoOuterClass.SceneNpcInfoOrBuilder getNpcOrBuilder() {
            if (this.entityCase_ == 12) {
                return (SceneNpcInfoOuterClass.SceneNpcInfo) this.entity_;
            }
            return SceneNpcInfoOuterClass.SceneNpcInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public boolean hasGadget() {
            return this.entityCase_ == 13;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public SceneGadgetInfoOuterClass.SceneGadgetInfo getGadget() {
            if (this.entityCase_ == 13) {
                return (SceneGadgetInfoOuterClass.SceneGadgetInfo) this.entity_;
            }
            return SceneGadgetInfoOuterClass.SceneGadgetInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
        public SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder getGadgetOrBuilder() {
            if (this.entityCase_ == 13) {
                return (SceneGadgetInfoOuterClass.SceneGadgetInfo) this.entity_;
            }
            return SceneGadgetInfoOuterClass.SceneGadgetInfo.getDefaultInstance();
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
            if (this.entityType_ != ProtEntityTypeOuterClass.ProtEntityType.PROT_ENTITY_TYPE_NONE.getNumber()) {
                output.writeEnum(1, this.entityType_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(2, this.entityId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
                GeneratedMessageV3.writeString(output, 3, this.name_);
            }
            if (this.motionInfo_ != null) {
                output.writeMessage(4, getMotionInfo());
            }
            for (int i = 0; i < this.propList_.size(); i++) {
                output.writeMessage(5, this.propList_.get(i));
            }
            for (int i2 = 0; i2 < this.fightPropList_.size(); i2++) {
                output.writeMessage(6, this.fightPropList_.get(i2));
            }
            if (this.lifeState_ != 0) {
                output.writeUInt32(7, this.lifeState_);
            }
            for (int i3 = 0; i3 < this.animatorParaList_.size(); i3++) {
                output.writeMessage(9, this.animatorParaList_.get(i3));
            }
            if (this.entityCase_ == 10) {
                output.writeMessage(10, (SceneAvatarInfoOuterClass.SceneAvatarInfo) this.entity_);
            }
            if (this.entityCase_ == 11) {
                output.writeMessage(11, (SceneMonsterInfoOuterClass.SceneMonsterInfo) this.entity_);
            }
            if (this.entityCase_ == 12) {
                output.writeMessage(12, (SceneNpcInfoOuterClass.SceneNpcInfo) this.entity_);
            }
            if (this.entityCase_ == 13) {
                output.writeMessage(13, (SceneGadgetInfoOuterClass.SceneGadgetInfo) this.entity_);
            }
            if (this.lastMoveSceneTimeMs_ != 0) {
                output.writeUInt32(17, this.lastMoveSceneTimeMs_);
            }
            if (this.lastMoveReliableSeq_ != 0) {
                output.writeUInt32(18, this.lastMoveReliableSeq_);
            }
            if (this.entityClientData_ != null) {
                output.writeMessage(19, getEntityClientData());
            }
            for (int i4 = 0; i4 < this.entityEnvironmentInfoList_.size(); i4++) {
                output.writeMessage(20, this.entityEnvironmentInfoList_.get(i4));
            }
            if (this.entityAuthorityInfo_ != null) {
                output.writeMessage(21, getEntityAuthorityInfo());
            }
            for (int i5 = 0; i5 < this.tagList_.size(); i5++) {
                GeneratedMessageV3.writeString(output, 22, this.tagList_.getRaw(i5));
            }
            for (int i6 = 0; i6 < this.serverBuffList_.size(); i6++) {
                output.writeMessage(23, this.serverBuffList_.get(i6));
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
            if (this.entityType_ != ProtEntityTypeOuterClass.ProtEntityType.PROT_ENTITY_TYPE_NONE.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(1, this.entityType_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.entityId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
                size2 += GeneratedMessageV3.computeStringSize(3, this.name_);
            }
            if (this.motionInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(4, getMotionInfo());
            }
            for (int i = 0; i < this.propList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.propList_.get(i));
            }
            for (int i2 = 0; i2 < this.fightPropList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.fightPropList_.get(i2));
            }
            if (this.lifeState_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.lifeState_);
            }
            for (int i3 = 0; i3 < this.animatorParaList_.size(); i3++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.animatorParaList_.get(i3));
            }
            if (this.entityCase_ == 10) {
                size2 += CodedOutputStream.computeMessageSize(10, (SceneAvatarInfoOuterClass.SceneAvatarInfo) this.entity_);
            }
            if (this.entityCase_ == 11) {
                size2 += CodedOutputStream.computeMessageSize(11, (SceneMonsterInfoOuterClass.SceneMonsterInfo) this.entity_);
            }
            if (this.entityCase_ == 12) {
                size2 += CodedOutputStream.computeMessageSize(12, (SceneNpcInfoOuterClass.SceneNpcInfo) this.entity_);
            }
            if (this.entityCase_ == 13) {
                size2 += CodedOutputStream.computeMessageSize(13, (SceneGadgetInfoOuterClass.SceneGadgetInfo) this.entity_);
            }
            if (this.lastMoveSceneTimeMs_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(17, this.lastMoveSceneTimeMs_);
            }
            if (this.lastMoveReliableSeq_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(18, this.lastMoveReliableSeq_);
            }
            if (this.entityClientData_ != null) {
                size2 += CodedOutputStream.computeMessageSize(19, getEntityClientData());
            }
            for (int i4 = 0; i4 < this.entityEnvironmentInfoList_.size(); i4++) {
                size2 += CodedOutputStream.computeMessageSize(20, this.entityEnvironmentInfoList_.get(i4));
            }
            if (this.entityAuthorityInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(21, getEntityAuthorityInfo());
            }
            int dataSize = 0;
            for (int i5 = 0; i5 < this.tagList_.size(); i5++) {
                dataSize += computeStringSizeNoTag(this.tagList_.getRaw(i5));
            }
            int size3 = size2 + dataSize + (2 * getTagListList().size());
            for (int i6 = 0; i6 < this.serverBuffList_.size(); i6++) {
                size3 += CodedOutputStream.computeMessageSize(23, this.serverBuffList_.get(i6));
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
            if (!(obj instanceof SceneEntityInfo)) {
                return equals(obj);
            }
            SceneEntityInfo other = (SceneEntityInfo) obj;
            if (this.entityType_ != other.entityType_ || getEntityId() != other.getEntityId() || !getName().equals(other.getName()) || hasMotionInfo() != other.hasMotionInfo()) {
                return false;
            }
            if ((hasMotionInfo() && !getMotionInfo().equals(other.getMotionInfo())) || !getPropListList().equals(other.getPropListList()) || !getFightPropListList().equals(other.getFightPropListList()) || getLifeState() != other.getLifeState() || !getAnimatorParaListList().equals(other.getAnimatorParaListList()) || getLastMoveSceneTimeMs() != other.getLastMoveSceneTimeMs() || getLastMoveReliableSeq() != other.getLastMoveReliableSeq() || hasEntityClientData() != other.hasEntityClientData()) {
                return false;
            }
            if ((hasEntityClientData() && !getEntityClientData().equals(other.getEntityClientData())) || !getEntityEnvironmentInfoListList().equals(other.getEntityEnvironmentInfoListList()) || hasEntityAuthorityInfo() != other.hasEntityAuthorityInfo()) {
                return false;
            }
            if ((hasEntityAuthorityInfo() && !getEntityAuthorityInfo().equals(other.getEntityAuthorityInfo())) || !getTagListList().equals(other.getTagListList()) || !getServerBuffListList().equals(other.getServerBuffListList()) || !getEntityCase().equals(other.getEntityCase())) {
                return false;
            }
            switch (this.entityCase_) {
                case 10:
                    if (!getAvatar().equals(other.getAvatar())) {
                        return false;
                    }
                    break;
                case 11:
                    if (!getMonster().equals(other.getMonster())) {
                        return false;
                    }
                    break;
                case 12:
                    if (!getNpc().equals(other.getNpc())) {
                        return false;
                    }
                    break;
                case 13:
                    if (!getGadget().equals(other.getGadget())) {
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
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + this.entityType_)) + 2)) + getEntityId())) + 3)) + getName().hashCode();
            if (hasMotionInfo()) {
                hash = (53 * ((37 * hash) + 4)) + getMotionInfo().hashCode();
            }
            if (getPropListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getPropListList().hashCode();
            }
            if (getFightPropListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getFightPropListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 7)) + getLifeState();
            if (getAnimatorParaListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 9)) + getAnimatorParaListList().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * hash2) + 17)) + getLastMoveSceneTimeMs())) + 18)) + getLastMoveReliableSeq();
            if (hasEntityClientData()) {
                hash3 = (53 * ((37 * hash3) + 19)) + getEntityClientData().hashCode();
            }
            if (getEntityEnvironmentInfoListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 20)) + getEntityEnvironmentInfoListList().hashCode();
            }
            if (hasEntityAuthorityInfo()) {
                hash3 = (53 * ((37 * hash3) + 21)) + getEntityAuthorityInfo().hashCode();
            }
            if (getTagListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 22)) + getTagListList().hashCode();
            }
            if (getServerBuffListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 23)) + getServerBuffListList().hashCode();
            }
            switch (this.entityCase_) {
                case 10:
                    hash3 = (53 * ((37 * hash3) + 10)) + getAvatar().hashCode();
                    break;
                case 11:
                    hash3 = (53 * ((37 * hash3) + 11)) + getMonster().hashCode();
                    break;
                case 12:
                    hash3 = (53 * ((37 * hash3) + 12)) + getNpc().hashCode();
                    break;
                case 13:
                    hash3 = (53 * ((37 * hash3) + 13)) + getGadget().hashCode();
                    break;
            }
            int hash4 = (29 * hash3) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static SceneEntityInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneEntityInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneEntityInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneEntityInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneEntityInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneEntityInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneEntityInfo parseFrom(InputStream input) throws IOException {
            return (SceneEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneEntityInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneEntityInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneEntityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneEntityInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneEntityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneEntityInfo parseFrom(CodedInputStream input) throws IOException {
            return (SceneEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneEntityInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneEntityInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityInfoOuterClass$SceneEntityInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneEntityInfoOrBuilder {
            private Object entity_;
            private int bitField0_;
            private int entityId_;
            private MotionInfoOuterClass.MotionInfo motionInfo_;
            private SingleFieldBuilderV3<MotionInfoOuterClass.MotionInfo, MotionInfoOuterClass.MotionInfo.Builder, MotionInfoOuterClass.MotionInfoOrBuilder> motionInfoBuilder_;
            private RepeatedFieldBuilderV3<PropPairOuterClass.PropPair, PropPairOuterClass.PropPair.Builder, PropPairOuterClass.PropPairOrBuilder> propListBuilder_;
            private RepeatedFieldBuilderV3<FightPropPairOuterClass.FightPropPair, FightPropPairOuterClass.FightPropPair.Builder, FightPropPairOuterClass.FightPropPairOrBuilder> fightPropListBuilder_;
            private int lifeState_;
            private RepeatedFieldBuilderV3<AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder> animatorParaListBuilder_;
            private int lastMoveSceneTimeMs_;
            private int lastMoveReliableSeq_;
            private EntityClientDataOuterClass.EntityClientData entityClientData_;
            private SingleFieldBuilderV3<EntityClientDataOuterClass.EntityClientData, EntityClientDataOuterClass.EntityClientData.Builder, EntityClientDataOuterClass.EntityClientDataOrBuilder> entityClientDataBuilder_;
            private RepeatedFieldBuilderV3<EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo, EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo.Builder, EntityEnvironmentInfoOuterClass.EntityEnvironmentInfoOrBuilder> entityEnvironmentInfoListBuilder_;
            private EntityAuthorityInfoOuterClass.EntityAuthorityInfo entityAuthorityInfo_;
            private SingleFieldBuilderV3<EntityAuthorityInfoOuterClass.EntityAuthorityInfo, EntityAuthorityInfoOuterClass.EntityAuthorityInfo.Builder, EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder> entityAuthorityInfoBuilder_;
            private RepeatedFieldBuilderV3<ServerBuffOuterClass.ServerBuff, ServerBuffOuterClass.ServerBuff.Builder, ServerBuffOuterClass.ServerBuffOrBuilder> serverBuffListBuilder_;
            private SingleFieldBuilderV3<SceneAvatarInfoOuterClass.SceneAvatarInfo, SceneAvatarInfoOuterClass.SceneAvatarInfo.Builder, SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder> avatarBuilder_;
            private SingleFieldBuilderV3<SceneMonsterInfoOuterClass.SceneMonsterInfo, SceneMonsterInfoOuterClass.SceneMonsterInfo.Builder, SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder> monsterBuilder_;
            private SingleFieldBuilderV3<SceneNpcInfoOuterClass.SceneNpcInfo, SceneNpcInfoOuterClass.SceneNpcInfo.Builder, SceneNpcInfoOuterClass.SceneNpcInfoOrBuilder> npcBuilder_;
            private SingleFieldBuilderV3<SceneGadgetInfoOuterClass.SceneGadgetInfo, SceneGadgetInfoOuterClass.SceneGadgetInfo.Builder, SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder> gadgetBuilder_;
            private int entityCase_ = 0;
            private int entityType_ = 0;
            private Object name_ = "";
            private List<PropPairOuterClass.PropPair> propList_ = Collections.emptyList();
            private List<FightPropPairOuterClass.FightPropPair> fightPropList_ = Collections.emptyList();
            private List<AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair> animatorParaList_ = Collections.emptyList();
            private List<EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo> entityEnvironmentInfoList_ = Collections.emptyList();
            private LazyStringList tagList_ = LazyStringArrayList.EMPTY;
            private List<ServerBuffOuterClass.ServerBuff> serverBuffList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneEntityInfoOuterClass.internal_static_SceneEntityInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneEntityInfoOuterClass.internal_static_SceneEntityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneEntityInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneEntityInfo.alwaysUseFieldBuilders) {
                    getPropListFieldBuilder();
                    getFightPropListFieldBuilder();
                    getAnimatorParaListFieldBuilder();
                    getEntityEnvironmentInfoListFieldBuilder();
                    getServerBuffListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityType_ = 0;
                this.entityId_ = 0;
                this.name_ = "";
                if (this.motionInfoBuilder_ == null) {
                    this.motionInfo_ = null;
                } else {
                    this.motionInfo_ = null;
                    this.motionInfoBuilder_ = null;
                }
                if (this.propListBuilder_ == null) {
                    this.propList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.propListBuilder_.clear();
                }
                if (this.fightPropListBuilder_ == null) {
                    this.fightPropList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.fightPropListBuilder_.clear();
                }
                this.lifeState_ = 0;
                if (this.animatorParaListBuilder_ == null) {
                    this.animatorParaList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.animatorParaListBuilder_.clear();
                }
                this.lastMoveSceneTimeMs_ = 0;
                this.lastMoveReliableSeq_ = 0;
                if (this.entityClientDataBuilder_ == null) {
                    this.entityClientData_ = null;
                } else {
                    this.entityClientData_ = null;
                    this.entityClientDataBuilder_ = null;
                }
                if (this.entityEnvironmentInfoListBuilder_ == null) {
                    this.entityEnvironmentInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.entityEnvironmentInfoListBuilder_.clear();
                }
                if (this.entityAuthorityInfoBuilder_ == null) {
                    this.entityAuthorityInfo_ = null;
                } else {
                    this.entityAuthorityInfo_ = null;
                    this.entityAuthorityInfoBuilder_ = null;
                }
                this.tagList_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -17;
                if (this.serverBuffListBuilder_ == null) {
                    this.serverBuffList_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                } else {
                    this.serverBuffListBuilder_.clear();
                }
                this.entityCase_ = 0;
                this.entity_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneEntityInfoOuterClass.internal_static_SceneEntityInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneEntityInfo getDefaultInstanceForType() {
                return SceneEntityInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneEntityInfo build() {
                SceneEntityInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneEntityInfo buildPartial() {
                SceneEntityInfo result = new SceneEntityInfo(this);
                int i = this.bitField0_;
                result.entityType_ = this.entityType_;
                result.entityId_ = this.entityId_;
                result.name_ = this.name_;
                if (this.motionInfoBuilder_ == null) {
                    result.motionInfo_ = this.motionInfo_;
                } else {
                    result.motionInfo_ = this.motionInfoBuilder_.build();
                }
                if (this.propListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.propList_ = Collections.unmodifiableList(this.propList_);
                        this.bitField0_ &= -2;
                    }
                    result.propList_ = this.propList_;
                } else {
                    result.propList_ = this.propListBuilder_.build();
                }
                if (this.fightPropListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.fightPropList_ = Collections.unmodifiableList(this.fightPropList_);
                        this.bitField0_ &= -3;
                    }
                    result.fightPropList_ = this.fightPropList_;
                } else {
                    result.fightPropList_ = this.fightPropListBuilder_.build();
                }
                result.lifeState_ = this.lifeState_;
                if (this.animatorParaListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.animatorParaList_ = Collections.unmodifiableList(this.animatorParaList_);
                        this.bitField0_ &= -5;
                    }
                    result.animatorParaList_ = this.animatorParaList_;
                } else {
                    result.animatorParaList_ = this.animatorParaListBuilder_.build();
                }
                result.lastMoveSceneTimeMs_ = this.lastMoveSceneTimeMs_;
                result.lastMoveReliableSeq_ = this.lastMoveReliableSeq_;
                if (this.entityClientDataBuilder_ == null) {
                    result.entityClientData_ = this.entityClientData_;
                } else {
                    result.entityClientData_ = this.entityClientDataBuilder_.build();
                }
                if (this.entityEnvironmentInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.entityEnvironmentInfoList_ = Collections.unmodifiableList(this.entityEnvironmentInfoList_);
                        this.bitField0_ &= -9;
                    }
                    result.entityEnvironmentInfoList_ = this.entityEnvironmentInfoList_;
                } else {
                    result.entityEnvironmentInfoList_ = this.entityEnvironmentInfoListBuilder_.build();
                }
                if (this.entityAuthorityInfoBuilder_ == null) {
                    result.entityAuthorityInfo_ = this.entityAuthorityInfo_;
                } else {
                    result.entityAuthorityInfo_ = this.entityAuthorityInfoBuilder_.build();
                }
                if ((this.bitField0_ & 16) != 0) {
                    this.tagList_ = this.tagList_.getUnmodifiableView();
                    this.bitField0_ &= -17;
                }
                result.tagList_ = this.tagList_;
                if (this.serverBuffListBuilder_ == null) {
                    if ((this.bitField0_ & 32) != 0) {
                        this.serverBuffList_ = Collections.unmodifiableList(this.serverBuffList_);
                        this.bitField0_ &= -33;
                    }
                    result.serverBuffList_ = this.serverBuffList_;
                } else {
                    result.serverBuffList_ = this.serverBuffListBuilder_.build();
                }
                if (this.entityCase_ == 10) {
                    if (this.avatarBuilder_ == null) {
                        result.entity_ = this.entity_;
                    } else {
                        result.entity_ = this.avatarBuilder_.build();
                    }
                }
                if (this.entityCase_ == 11) {
                    if (this.monsterBuilder_ == null) {
                        result.entity_ = this.entity_;
                    } else {
                        result.entity_ = this.monsterBuilder_.build();
                    }
                }
                if (this.entityCase_ == 12) {
                    if (this.npcBuilder_ == null) {
                        result.entity_ = this.entity_;
                    } else {
                        result.entity_ = this.npcBuilder_.build();
                    }
                }
                if (this.entityCase_ == 13) {
                    if (this.gadgetBuilder_ == null) {
                        result.entity_ = this.entity_;
                    } else {
                        result.entity_ = this.gadgetBuilder_.build();
                    }
                }
                result.entityCase_ = this.entityCase_;
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
                if (other instanceof SceneEntityInfo) {
                    return mergeFrom((SceneEntityInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneEntityInfo other) {
                if (other == SceneEntityInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.entityType_ != 0) {
                    setEntityTypeValue(other.getEntityTypeValue());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (!other.getName().isEmpty()) {
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasMotionInfo()) {
                    mergeMotionInfo(other.getMotionInfo());
                }
                if (this.propListBuilder_ == null) {
                    if (!other.propList_.isEmpty()) {
                        if (this.propList_.isEmpty()) {
                            this.propList_ = other.propList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePropListIsMutable();
                            this.propList_.addAll(other.propList_);
                        }
                        onChanged();
                    }
                } else if (!other.propList_.isEmpty()) {
                    if (this.propListBuilder_.isEmpty()) {
                        this.propListBuilder_.dispose();
                        this.propListBuilder_ = null;
                        this.propList_ = other.propList_;
                        this.bitField0_ &= -2;
                        this.propListBuilder_ = SceneEntityInfo.alwaysUseFieldBuilders ? getPropListFieldBuilder() : null;
                    } else {
                        this.propListBuilder_.addAllMessages(other.propList_);
                    }
                }
                if (this.fightPropListBuilder_ == null) {
                    if (!other.fightPropList_.isEmpty()) {
                        if (this.fightPropList_.isEmpty()) {
                            this.fightPropList_ = other.fightPropList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureFightPropListIsMutable();
                            this.fightPropList_.addAll(other.fightPropList_);
                        }
                        onChanged();
                    }
                } else if (!other.fightPropList_.isEmpty()) {
                    if (this.fightPropListBuilder_.isEmpty()) {
                        this.fightPropListBuilder_.dispose();
                        this.fightPropListBuilder_ = null;
                        this.fightPropList_ = other.fightPropList_;
                        this.bitField0_ &= -3;
                        this.fightPropListBuilder_ = SceneEntityInfo.alwaysUseFieldBuilders ? getFightPropListFieldBuilder() : null;
                    } else {
                        this.fightPropListBuilder_.addAllMessages(other.fightPropList_);
                    }
                }
                if (other.getLifeState() != 0) {
                    setLifeState(other.getLifeState());
                }
                if (this.animatorParaListBuilder_ == null) {
                    if (!other.animatorParaList_.isEmpty()) {
                        if (this.animatorParaList_.isEmpty()) {
                            this.animatorParaList_ = other.animatorParaList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureAnimatorParaListIsMutable();
                            this.animatorParaList_.addAll(other.animatorParaList_);
                        }
                        onChanged();
                    }
                } else if (!other.animatorParaList_.isEmpty()) {
                    if (this.animatorParaListBuilder_.isEmpty()) {
                        this.animatorParaListBuilder_.dispose();
                        this.animatorParaListBuilder_ = null;
                        this.animatorParaList_ = other.animatorParaList_;
                        this.bitField0_ &= -5;
                        this.animatorParaListBuilder_ = SceneEntityInfo.alwaysUseFieldBuilders ? getAnimatorParaListFieldBuilder() : null;
                    } else {
                        this.animatorParaListBuilder_.addAllMessages(other.animatorParaList_);
                    }
                }
                if (other.getLastMoveSceneTimeMs() != 0) {
                    setLastMoveSceneTimeMs(other.getLastMoveSceneTimeMs());
                }
                if (other.getLastMoveReliableSeq() != 0) {
                    setLastMoveReliableSeq(other.getLastMoveReliableSeq());
                }
                if (other.hasEntityClientData()) {
                    mergeEntityClientData(other.getEntityClientData());
                }
                if (this.entityEnvironmentInfoListBuilder_ == null) {
                    if (!other.entityEnvironmentInfoList_.isEmpty()) {
                        if (this.entityEnvironmentInfoList_.isEmpty()) {
                            this.entityEnvironmentInfoList_ = other.entityEnvironmentInfoList_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureEntityEnvironmentInfoListIsMutable();
                            this.entityEnvironmentInfoList_.addAll(other.entityEnvironmentInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.entityEnvironmentInfoList_.isEmpty()) {
                    if (this.entityEnvironmentInfoListBuilder_.isEmpty()) {
                        this.entityEnvironmentInfoListBuilder_.dispose();
                        this.entityEnvironmentInfoListBuilder_ = null;
                        this.entityEnvironmentInfoList_ = other.entityEnvironmentInfoList_;
                        this.bitField0_ &= -9;
                        this.entityEnvironmentInfoListBuilder_ = SceneEntityInfo.alwaysUseFieldBuilders ? getEntityEnvironmentInfoListFieldBuilder() : null;
                    } else {
                        this.entityEnvironmentInfoListBuilder_.addAllMessages(other.entityEnvironmentInfoList_);
                    }
                }
                if (other.hasEntityAuthorityInfo()) {
                    mergeEntityAuthorityInfo(other.getEntityAuthorityInfo());
                }
                if (!other.tagList_.isEmpty()) {
                    if (this.tagList_.isEmpty()) {
                        this.tagList_ = other.tagList_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureTagListIsMutable();
                        this.tagList_.addAll(other.tagList_);
                    }
                    onChanged();
                }
                if (this.serverBuffListBuilder_ == null) {
                    if (!other.serverBuffList_.isEmpty()) {
                        if (this.serverBuffList_.isEmpty()) {
                            this.serverBuffList_ = other.serverBuffList_;
                            this.bitField0_ &= -33;
                        } else {
                            ensureServerBuffListIsMutable();
                            this.serverBuffList_.addAll(other.serverBuffList_);
                        }
                        onChanged();
                    }
                } else if (!other.serverBuffList_.isEmpty()) {
                    if (this.serverBuffListBuilder_.isEmpty()) {
                        this.serverBuffListBuilder_.dispose();
                        this.serverBuffListBuilder_ = null;
                        this.serverBuffList_ = other.serverBuffList_;
                        this.bitField0_ &= -33;
                        this.serverBuffListBuilder_ = SceneEntityInfo.alwaysUseFieldBuilders ? getServerBuffListFieldBuilder() : null;
                    } else {
                        this.serverBuffListBuilder_.addAllMessages(other.serverBuffList_);
                    }
                }
                switch (other.getEntityCase()) {
                    case AVATAR:
                        mergeAvatar(other.getAvatar());
                        break;
                    case MONSTER:
                        mergeMonster(other.getMonster());
                        break;
                    case NPC:
                        mergeNpc(other.getNpc());
                        break;
                    case GADGET:
                        mergeGadget(other.getGadget());
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
                SceneEntityInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneEntityInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneEntityInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public EntityCase getEntityCase() {
                return EntityCase.forNumber(this.entityCase_);
            }

            public Builder clearEntity() {
                this.entityCase_ = 0;
                this.entity_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public int getEntityTypeValue() {
                return this.entityType_;
            }

            public Builder setEntityTypeValue(int value) {
                this.entityType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public ProtEntityTypeOuterClass.ProtEntityType getEntityType() {
                ProtEntityTypeOuterClass.ProtEntityType result = ProtEntityTypeOuterClass.ProtEntityType.valueOf(this.entityType_);
                return result == null ? ProtEntityTypeOuterClass.ProtEntityType.UNRECOGNIZED : result;
            }

            public Builder setEntityType(ProtEntityTypeOuterClass.ProtEntityType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.entityType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearEntityType() {
                this.entityType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public int getEntityId() {
                return this.entityId_;
            }

            public Builder setEntityId(int value) {
                this.entityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntityId() {
                this.entityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public ByteString getNameBytes() {
                Object ref = this.name_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.name_ = b;
                return b;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = SceneEntityInfo.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                SceneEntityInfo.checkByteStringIsUtf8(value);
                this.name_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public boolean hasMotionInfo() {
                return (this.motionInfoBuilder_ == null && this.motionInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public MotionInfoOuterClass.MotionInfo getMotionInfo() {
                if (this.motionInfoBuilder_ == null) {
                    return this.motionInfo_ == null ? MotionInfoOuterClass.MotionInfo.getDefaultInstance() : this.motionInfo_;
                }
                return this.motionInfoBuilder_.getMessage();
            }

            public Builder setMotionInfo(MotionInfoOuterClass.MotionInfo value) {
                if (this.motionInfoBuilder_ != null) {
                    this.motionInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.motionInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setMotionInfo(MotionInfoOuterClass.MotionInfo.Builder builderForValue) {
                if (this.motionInfoBuilder_ == null) {
                    this.motionInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.motionInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeMotionInfo(MotionInfoOuterClass.MotionInfo value) {
                if (this.motionInfoBuilder_ == null) {
                    if (this.motionInfo_ != null) {
                        this.motionInfo_ = MotionInfoOuterClass.MotionInfo.newBuilder(this.motionInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.motionInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.motionInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearMotionInfo() {
                if (this.motionInfoBuilder_ == null) {
                    this.motionInfo_ = null;
                    onChanged();
                } else {
                    this.motionInfo_ = null;
                    this.motionInfoBuilder_ = null;
                }
                return this;
            }

            public MotionInfoOuterClass.MotionInfo.Builder getMotionInfoBuilder() {
                onChanged();
                return getMotionInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public MotionInfoOuterClass.MotionInfoOrBuilder getMotionInfoOrBuilder() {
                if (this.motionInfoBuilder_ != null) {
                    return this.motionInfoBuilder_.getMessageOrBuilder();
                }
                return this.motionInfo_ == null ? MotionInfoOuterClass.MotionInfo.getDefaultInstance() : this.motionInfo_;
            }

            private SingleFieldBuilderV3<MotionInfoOuterClass.MotionInfo, MotionInfoOuterClass.MotionInfo.Builder, MotionInfoOuterClass.MotionInfoOrBuilder> getMotionInfoFieldBuilder() {
                if (this.motionInfoBuilder_ == null) {
                    this.motionInfoBuilder_ = new SingleFieldBuilderV3<>(getMotionInfo(), getParentForChildren(), isClean());
                    this.motionInfo_ = null;
                }
                return this.motionInfoBuilder_;
            }

            private void ensurePropListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.propList_ = new ArrayList(this.propList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public List<PropPairOuterClass.PropPair> getPropListList() {
                if (this.propListBuilder_ == null) {
                    return Collections.unmodifiableList(this.propList_);
                }
                return this.propListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public int getPropListCount() {
                if (this.propListBuilder_ == null) {
                    return this.propList_.size();
                }
                return this.propListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public PropPairOuterClass.PropPair getPropList(int index) {
                if (this.propListBuilder_ == null) {
                    return this.propList_.get(index);
                }
                return this.propListBuilder_.getMessage(index);
            }

            public Builder setPropList(int index, PropPairOuterClass.PropPair value) {
                if (this.propListBuilder_ != null) {
                    this.propListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePropListIsMutable();
                    this.propList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPropList(int index, PropPairOuterClass.PropPair.Builder builderForValue) {
                if (this.propListBuilder_ == null) {
                    ensurePropListIsMutable();
                    this.propList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.propListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPropList(PropPairOuterClass.PropPair value) {
                if (this.propListBuilder_ != null) {
                    this.propListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePropListIsMutable();
                    this.propList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPropList(int index, PropPairOuterClass.PropPair value) {
                if (this.propListBuilder_ != null) {
                    this.propListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePropListIsMutable();
                    this.propList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPropList(PropPairOuterClass.PropPair.Builder builderForValue) {
                if (this.propListBuilder_ == null) {
                    ensurePropListIsMutable();
                    this.propList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.propListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPropList(int index, PropPairOuterClass.PropPair.Builder builderForValue) {
                if (this.propListBuilder_ == null) {
                    ensurePropListIsMutable();
                    this.propList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.propListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPropList(Iterable<? extends PropPairOuterClass.PropPair> values) {
                if (this.propListBuilder_ == null) {
                    ensurePropListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.propList_);
                    onChanged();
                } else {
                    this.propListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPropList() {
                if (this.propListBuilder_ == null) {
                    this.propList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.propListBuilder_.clear();
                }
                return this;
            }

            public Builder removePropList(int index) {
                if (this.propListBuilder_ == null) {
                    ensurePropListIsMutable();
                    this.propList_.remove(index);
                    onChanged();
                } else {
                    this.propListBuilder_.remove(index);
                }
                return this;
            }

            public PropPairOuterClass.PropPair.Builder getPropListBuilder(int index) {
                return getPropListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public PropPairOuterClass.PropPairOrBuilder getPropListOrBuilder(int index) {
                if (this.propListBuilder_ == null) {
                    return this.propList_.get(index);
                }
                return this.propListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public List<? extends PropPairOuterClass.PropPairOrBuilder> getPropListOrBuilderList() {
                if (this.propListBuilder_ != null) {
                    return this.propListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.propList_);
            }

            public PropPairOuterClass.PropPair.Builder addPropListBuilder() {
                return getPropListFieldBuilder().addBuilder(PropPairOuterClass.PropPair.getDefaultInstance());
            }

            public PropPairOuterClass.PropPair.Builder addPropListBuilder(int index) {
                return getPropListFieldBuilder().addBuilder(index, PropPairOuterClass.PropPair.getDefaultInstance());
            }

            public List<PropPairOuterClass.PropPair.Builder> getPropListBuilderList() {
                return getPropListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PropPairOuterClass.PropPair, PropPairOuterClass.PropPair.Builder, PropPairOuterClass.PropPairOrBuilder> getPropListFieldBuilder() {
                if (this.propListBuilder_ == null) {
                    this.propListBuilder_ = new RepeatedFieldBuilderV3<>(this.propList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.propList_ = null;
                }
                return this.propListBuilder_;
            }

            private void ensureFightPropListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.fightPropList_ = new ArrayList(this.fightPropList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public List<FightPropPairOuterClass.FightPropPair> getFightPropListList() {
                if (this.fightPropListBuilder_ == null) {
                    return Collections.unmodifiableList(this.fightPropList_);
                }
                return this.fightPropListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public int getFightPropListCount() {
                if (this.fightPropListBuilder_ == null) {
                    return this.fightPropList_.size();
                }
                return this.fightPropListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public FightPropPairOuterClass.FightPropPair getFightPropList(int index) {
                if (this.fightPropListBuilder_ == null) {
                    return this.fightPropList_.get(index);
                }
                return this.fightPropListBuilder_.getMessage(index);
            }

            public Builder setFightPropList(int index, FightPropPairOuterClass.FightPropPair value) {
                if (this.fightPropListBuilder_ != null) {
                    this.fightPropListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFightPropListIsMutable();
                    this.fightPropList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setFightPropList(int index, FightPropPairOuterClass.FightPropPair.Builder builderForValue) {
                if (this.fightPropListBuilder_ == null) {
                    ensureFightPropListIsMutable();
                    this.fightPropList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fightPropListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFightPropList(FightPropPairOuterClass.FightPropPair value) {
                if (this.fightPropListBuilder_ != null) {
                    this.fightPropListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFightPropListIsMutable();
                    this.fightPropList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addFightPropList(int index, FightPropPairOuterClass.FightPropPair value) {
                if (this.fightPropListBuilder_ != null) {
                    this.fightPropListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFightPropListIsMutable();
                    this.fightPropList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addFightPropList(FightPropPairOuterClass.FightPropPair.Builder builderForValue) {
                if (this.fightPropListBuilder_ == null) {
                    ensureFightPropListIsMutable();
                    this.fightPropList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.fightPropListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFightPropList(int index, FightPropPairOuterClass.FightPropPair.Builder builderForValue) {
                if (this.fightPropListBuilder_ == null) {
                    ensureFightPropListIsMutable();
                    this.fightPropList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fightPropListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFightPropList(Iterable<? extends FightPropPairOuterClass.FightPropPair> values) {
                if (this.fightPropListBuilder_ == null) {
                    ensureFightPropListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.fightPropList_);
                    onChanged();
                } else {
                    this.fightPropListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFightPropList() {
                if (this.fightPropListBuilder_ == null) {
                    this.fightPropList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.fightPropListBuilder_.clear();
                }
                return this;
            }

            public Builder removeFightPropList(int index) {
                if (this.fightPropListBuilder_ == null) {
                    ensureFightPropListIsMutable();
                    this.fightPropList_.remove(index);
                    onChanged();
                } else {
                    this.fightPropListBuilder_.remove(index);
                }
                return this;
            }

            public FightPropPairOuterClass.FightPropPair.Builder getFightPropListBuilder(int index) {
                return getFightPropListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public FightPropPairOuterClass.FightPropPairOrBuilder getFightPropListOrBuilder(int index) {
                if (this.fightPropListBuilder_ == null) {
                    return this.fightPropList_.get(index);
                }
                return this.fightPropListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public List<? extends FightPropPairOuterClass.FightPropPairOrBuilder> getFightPropListOrBuilderList() {
                if (this.fightPropListBuilder_ != null) {
                    return this.fightPropListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.fightPropList_);
            }

            public FightPropPairOuterClass.FightPropPair.Builder addFightPropListBuilder() {
                return getFightPropListFieldBuilder().addBuilder(FightPropPairOuterClass.FightPropPair.getDefaultInstance());
            }

            public FightPropPairOuterClass.FightPropPair.Builder addFightPropListBuilder(int index) {
                return getFightPropListFieldBuilder().addBuilder(index, FightPropPairOuterClass.FightPropPair.getDefaultInstance());
            }

            public List<FightPropPairOuterClass.FightPropPair.Builder> getFightPropListBuilderList() {
                return getFightPropListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FightPropPairOuterClass.FightPropPair, FightPropPairOuterClass.FightPropPair.Builder, FightPropPairOuterClass.FightPropPairOrBuilder> getFightPropListFieldBuilder() {
                if (this.fightPropListBuilder_ == null) {
                    this.fightPropListBuilder_ = new RepeatedFieldBuilderV3<>(this.fightPropList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.fightPropList_ = null;
                }
                return this.fightPropListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public int getLifeState() {
                return this.lifeState_;
            }

            public Builder setLifeState(int value) {
                this.lifeState_ = value;
                onChanged();
                return this;
            }

            public Builder clearLifeState() {
                this.lifeState_ = 0;
                onChanged();
                return this;
            }

            private void ensureAnimatorParaListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.animatorParaList_ = new ArrayList(this.animatorParaList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public List<AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair> getAnimatorParaListList() {
                if (this.animatorParaListBuilder_ == null) {
                    return Collections.unmodifiableList(this.animatorParaList_);
                }
                return this.animatorParaListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public int getAnimatorParaListCount() {
                if (this.animatorParaListBuilder_ == null) {
                    return this.animatorParaList_.size();
                }
                return this.animatorParaListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair getAnimatorParaList(int index) {
                if (this.animatorParaListBuilder_ == null) {
                    return this.animatorParaList_.get(index);
                }
                return this.animatorParaListBuilder_.getMessage(index);
            }

            public Builder setAnimatorParaList(int index, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair value) {
                if (this.animatorParaListBuilder_ != null) {
                    this.animatorParaListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAnimatorParaListIsMutable();
                    this.animatorParaList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAnimatorParaList(int index, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder builderForValue) {
                if (this.animatorParaListBuilder_ == null) {
                    ensureAnimatorParaListIsMutable();
                    this.animatorParaList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.animatorParaListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAnimatorParaList(AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair value) {
                if (this.animatorParaListBuilder_ != null) {
                    this.animatorParaListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAnimatorParaListIsMutable();
                    this.animatorParaList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAnimatorParaList(int index, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair value) {
                if (this.animatorParaListBuilder_ != null) {
                    this.animatorParaListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAnimatorParaListIsMutable();
                    this.animatorParaList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAnimatorParaList(AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder builderForValue) {
                if (this.animatorParaListBuilder_ == null) {
                    ensureAnimatorParaListIsMutable();
                    this.animatorParaList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.animatorParaListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAnimatorParaList(int index, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder builderForValue) {
                if (this.animatorParaListBuilder_ == null) {
                    ensureAnimatorParaListIsMutable();
                    this.animatorParaList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.animatorParaListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAnimatorParaList(Iterable<? extends AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair> values) {
                if (this.animatorParaListBuilder_ == null) {
                    ensureAnimatorParaListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.animatorParaList_);
                    onChanged();
                } else {
                    this.animatorParaListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAnimatorParaList() {
                if (this.animatorParaListBuilder_ == null) {
                    this.animatorParaList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.animatorParaListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAnimatorParaList(int index) {
                if (this.animatorParaListBuilder_ == null) {
                    ensureAnimatorParaListIsMutable();
                    this.animatorParaList_.remove(index);
                    onChanged();
                } else {
                    this.animatorParaListBuilder_.remove(index);
                }
                return this;
            }

            public AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder getAnimatorParaListBuilder(int index) {
                return getAnimatorParaListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder getAnimatorParaListOrBuilder(int index) {
                if (this.animatorParaListBuilder_ == null) {
                    return this.animatorParaList_.get(index);
                }
                return this.animatorParaListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public List<? extends AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder> getAnimatorParaListOrBuilderList() {
                if (this.animatorParaListBuilder_ != null) {
                    return this.animatorParaListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.animatorParaList_);
            }

            public AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder addAnimatorParaListBuilder() {
                return getAnimatorParaListFieldBuilder().addBuilder(AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.getDefaultInstance());
            }

            public AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder addAnimatorParaListBuilder(int index) {
                return getAnimatorParaListFieldBuilder().addBuilder(index, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.getDefaultInstance());
            }

            public List<AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder> getAnimatorParaListBuilderList() {
                return getAnimatorParaListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder> getAnimatorParaListFieldBuilder() {
                if (this.animatorParaListBuilder_ == null) {
                    this.animatorParaListBuilder_ = new RepeatedFieldBuilderV3<>(this.animatorParaList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.animatorParaList_ = null;
                }
                return this.animatorParaListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public int getLastMoveSceneTimeMs() {
                return this.lastMoveSceneTimeMs_;
            }

            public Builder setLastMoveSceneTimeMs(int value) {
                this.lastMoveSceneTimeMs_ = value;
                onChanged();
                return this;
            }

            public Builder clearLastMoveSceneTimeMs() {
                this.lastMoveSceneTimeMs_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public int getLastMoveReliableSeq() {
                return this.lastMoveReliableSeq_;
            }

            public Builder setLastMoveReliableSeq(int value) {
                this.lastMoveReliableSeq_ = value;
                onChanged();
                return this;
            }

            public Builder clearLastMoveReliableSeq() {
                this.lastMoveReliableSeq_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public boolean hasEntityClientData() {
                return (this.entityClientDataBuilder_ == null && this.entityClientData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public EntityClientDataOuterClass.EntityClientData getEntityClientData() {
                if (this.entityClientDataBuilder_ == null) {
                    return this.entityClientData_ == null ? EntityClientDataOuterClass.EntityClientData.getDefaultInstance() : this.entityClientData_;
                }
                return this.entityClientDataBuilder_.getMessage();
            }

            public Builder setEntityClientData(EntityClientDataOuterClass.EntityClientData value) {
                if (this.entityClientDataBuilder_ != null) {
                    this.entityClientDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.entityClientData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setEntityClientData(EntityClientDataOuterClass.EntityClientData.Builder builderForValue) {
                if (this.entityClientDataBuilder_ == null) {
                    this.entityClientData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.entityClientDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeEntityClientData(EntityClientDataOuterClass.EntityClientData value) {
                if (this.entityClientDataBuilder_ == null) {
                    if (this.entityClientData_ != null) {
                        this.entityClientData_ = EntityClientDataOuterClass.EntityClientData.newBuilder(this.entityClientData_).mergeFrom(value).buildPartial();
                    } else {
                        this.entityClientData_ = value;
                    }
                    onChanged();
                } else {
                    this.entityClientDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearEntityClientData() {
                if (this.entityClientDataBuilder_ == null) {
                    this.entityClientData_ = null;
                    onChanged();
                } else {
                    this.entityClientData_ = null;
                    this.entityClientDataBuilder_ = null;
                }
                return this;
            }

            public EntityClientDataOuterClass.EntityClientData.Builder getEntityClientDataBuilder() {
                onChanged();
                return getEntityClientDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public EntityClientDataOuterClass.EntityClientDataOrBuilder getEntityClientDataOrBuilder() {
                if (this.entityClientDataBuilder_ != null) {
                    return this.entityClientDataBuilder_.getMessageOrBuilder();
                }
                return this.entityClientData_ == null ? EntityClientDataOuterClass.EntityClientData.getDefaultInstance() : this.entityClientData_;
            }

            private SingleFieldBuilderV3<EntityClientDataOuterClass.EntityClientData, EntityClientDataOuterClass.EntityClientData.Builder, EntityClientDataOuterClass.EntityClientDataOrBuilder> getEntityClientDataFieldBuilder() {
                if (this.entityClientDataBuilder_ == null) {
                    this.entityClientDataBuilder_ = new SingleFieldBuilderV3<>(getEntityClientData(), getParentForChildren(), isClean());
                    this.entityClientData_ = null;
                }
                return this.entityClientDataBuilder_;
            }

            private void ensureEntityEnvironmentInfoListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.entityEnvironmentInfoList_ = new ArrayList(this.entityEnvironmentInfoList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public List<EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo> getEntityEnvironmentInfoListList() {
                if (this.entityEnvironmentInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.entityEnvironmentInfoList_);
                }
                return this.entityEnvironmentInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public int getEntityEnvironmentInfoListCount() {
                if (this.entityEnvironmentInfoListBuilder_ == null) {
                    return this.entityEnvironmentInfoList_.size();
                }
                return this.entityEnvironmentInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo getEntityEnvironmentInfoList(int index) {
                if (this.entityEnvironmentInfoListBuilder_ == null) {
                    return this.entityEnvironmentInfoList_.get(index);
                }
                return this.entityEnvironmentInfoListBuilder_.getMessage(index);
            }

            public Builder setEntityEnvironmentInfoList(int index, EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo value) {
                if (this.entityEnvironmentInfoListBuilder_ != null) {
                    this.entityEnvironmentInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEntityEnvironmentInfoListIsMutable();
                    this.entityEnvironmentInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setEntityEnvironmentInfoList(int index, EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo.Builder builderForValue) {
                if (this.entityEnvironmentInfoListBuilder_ == null) {
                    ensureEntityEnvironmentInfoListIsMutable();
                    this.entityEnvironmentInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.entityEnvironmentInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addEntityEnvironmentInfoList(EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo value) {
                if (this.entityEnvironmentInfoListBuilder_ != null) {
                    this.entityEnvironmentInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEntityEnvironmentInfoListIsMutable();
                    this.entityEnvironmentInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addEntityEnvironmentInfoList(int index, EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo value) {
                if (this.entityEnvironmentInfoListBuilder_ != null) {
                    this.entityEnvironmentInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEntityEnvironmentInfoListIsMutable();
                    this.entityEnvironmentInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addEntityEnvironmentInfoList(EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo.Builder builderForValue) {
                if (this.entityEnvironmentInfoListBuilder_ == null) {
                    ensureEntityEnvironmentInfoListIsMutable();
                    this.entityEnvironmentInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.entityEnvironmentInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addEntityEnvironmentInfoList(int index, EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo.Builder builderForValue) {
                if (this.entityEnvironmentInfoListBuilder_ == null) {
                    ensureEntityEnvironmentInfoListIsMutable();
                    this.entityEnvironmentInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.entityEnvironmentInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllEntityEnvironmentInfoList(Iterable<? extends EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo> values) {
                if (this.entityEnvironmentInfoListBuilder_ == null) {
                    ensureEntityEnvironmentInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.entityEnvironmentInfoList_);
                    onChanged();
                } else {
                    this.entityEnvironmentInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearEntityEnvironmentInfoList() {
                if (this.entityEnvironmentInfoListBuilder_ == null) {
                    this.entityEnvironmentInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.entityEnvironmentInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeEntityEnvironmentInfoList(int index) {
                if (this.entityEnvironmentInfoListBuilder_ == null) {
                    ensureEntityEnvironmentInfoListIsMutable();
                    this.entityEnvironmentInfoList_.remove(index);
                    onChanged();
                } else {
                    this.entityEnvironmentInfoListBuilder_.remove(index);
                }
                return this;
            }

            public EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo.Builder getEntityEnvironmentInfoListBuilder(int index) {
                return getEntityEnvironmentInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public EntityEnvironmentInfoOuterClass.EntityEnvironmentInfoOrBuilder getEntityEnvironmentInfoListOrBuilder(int index) {
                if (this.entityEnvironmentInfoListBuilder_ == null) {
                    return this.entityEnvironmentInfoList_.get(index);
                }
                return this.entityEnvironmentInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public List<? extends EntityEnvironmentInfoOuterClass.EntityEnvironmentInfoOrBuilder> getEntityEnvironmentInfoListOrBuilderList() {
                if (this.entityEnvironmentInfoListBuilder_ != null) {
                    return this.entityEnvironmentInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.entityEnvironmentInfoList_);
            }

            public EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo.Builder addEntityEnvironmentInfoListBuilder() {
                return getEntityEnvironmentInfoListFieldBuilder().addBuilder(EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo.getDefaultInstance());
            }

            public EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo.Builder addEntityEnvironmentInfoListBuilder(int index) {
                return getEntityEnvironmentInfoListFieldBuilder().addBuilder(index, EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo.getDefaultInstance());
            }

            public List<EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo.Builder> getEntityEnvironmentInfoListBuilderList() {
                return getEntityEnvironmentInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo, EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo.Builder, EntityEnvironmentInfoOuterClass.EntityEnvironmentInfoOrBuilder> getEntityEnvironmentInfoListFieldBuilder() {
                if (this.entityEnvironmentInfoListBuilder_ == null) {
                    this.entityEnvironmentInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.entityEnvironmentInfoList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.entityEnvironmentInfoList_ = null;
                }
                return this.entityEnvironmentInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public boolean hasEntityAuthorityInfo() {
                return (this.entityAuthorityInfoBuilder_ == null && this.entityAuthorityInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public EntityAuthorityInfoOuterClass.EntityAuthorityInfo getEntityAuthorityInfo() {
                if (this.entityAuthorityInfoBuilder_ == null) {
                    return this.entityAuthorityInfo_ == null ? EntityAuthorityInfoOuterClass.EntityAuthorityInfo.getDefaultInstance() : this.entityAuthorityInfo_;
                }
                return this.entityAuthorityInfoBuilder_.getMessage();
            }

            public Builder setEntityAuthorityInfo(EntityAuthorityInfoOuterClass.EntityAuthorityInfo value) {
                if (this.entityAuthorityInfoBuilder_ != null) {
                    this.entityAuthorityInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.entityAuthorityInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setEntityAuthorityInfo(EntityAuthorityInfoOuterClass.EntityAuthorityInfo.Builder builderForValue) {
                if (this.entityAuthorityInfoBuilder_ == null) {
                    this.entityAuthorityInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.entityAuthorityInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeEntityAuthorityInfo(EntityAuthorityInfoOuterClass.EntityAuthorityInfo value) {
                if (this.entityAuthorityInfoBuilder_ == null) {
                    if (this.entityAuthorityInfo_ != null) {
                        this.entityAuthorityInfo_ = EntityAuthorityInfoOuterClass.EntityAuthorityInfo.newBuilder(this.entityAuthorityInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.entityAuthorityInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.entityAuthorityInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearEntityAuthorityInfo() {
                if (this.entityAuthorityInfoBuilder_ == null) {
                    this.entityAuthorityInfo_ = null;
                    onChanged();
                } else {
                    this.entityAuthorityInfo_ = null;
                    this.entityAuthorityInfoBuilder_ = null;
                }
                return this;
            }

            public EntityAuthorityInfoOuterClass.EntityAuthorityInfo.Builder getEntityAuthorityInfoBuilder() {
                onChanged();
                return getEntityAuthorityInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder getEntityAuthorityInfoOrBuilder() {
                if (this.entityAuthorityInfoBuilder_ != null) {
                    return this.entityAuthorityInfoBuilder_.getMessageOrBuilder();
                }
                return this.entityAuthorityInfo_ == null ? EntityAuthorityInfoOuterClass.EntityAuthorityInfo.getDefaultInstance() : this.entityAuthorityInfo_;
            }

            private SingleFieldBuilderV3<EntityAuthorityInfoOuterClass.EntityAuthorityInfo, EntityAuthorityInfoOuterClass.EntityAuthorityInfo.Builder, EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder> getEntityAuthorityInfoFieldBuilder() {
                if (this.entityAuthorityInfoBuilder_ == null) {
                    this.entityAuthorityInfoBuilder_ = new SingleFieldBuilderV3<>(getEntityAuthorityInfo(), getParentForChildren(), isClean());
                    this.entityAuthorityInfo_ = null;
                }
                return this.entityAuthorityInfoBuilder_;
            }

            private void ensureTagListIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.tagList_ = new LazyStringArrayList(this.tagList_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public ProtocolStringList getTagListList() {
                return this.tagList_.getUnmodifiableView();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public int getTagListCount() {
                return this.tagList_.size();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public String getTagList(int index) {
                return (String) this.tagList_.get(index);
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public ByteString getTagListBytes(int index) {
                return this.tagList_.getByteString(index);
            }

            public Builder setTagList(int index, String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureTagListIsMutable();
                this.tagList_.set(index, value);
                onChanged();
                return this;
            }

            public Builder addTagList(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureTagListIsMutable();
                this.tagList_.add(value);
                onChanged();
                return this;
            }

            public Builder addAllTagList(Iterable<String> values) {
                ensureTagListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.tagList_);
                onChanged();
                return this;
            }

            public Builder clearTagList() {
                this.tagList_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -17;
                onChanged();
                return this;
            }

            public Builder addTagListBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                SceneEntityInfo.checkByteStringIsUtf8(value);
                ensureTagListIsMutable();
                this.tagList_.add(value);
                onChanged();
                return this;
            }

            private void ensureServerBuffListIsMutable() {
                if ((this.bitField0_ & 32) == 0) {
                    this.serverBuffList_ = new ArrayList(this.serverBuffList_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public List<ServerBuffOuterClass.ServerBuff> getServerBuffListList() {
                if (this.serverBuffListBuilder_ == null) {
                    return Collections.unmodifiableList(this.serverBuffList_);
                }
                return this.serverBuffListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public int getServerBuffListCount() {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.size();
                }
                return this.serverBuffListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public ServerBuffOuterClass.ServerBuff getServerBuffList(int index) {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.get(index);
                }
                return this.serverBuffListBuilder_.getMessage(index);
            }

            public Builder setServerBuffList(int index, ServerBuffOuterClass.ServerBuff value) {
                if (this.serverBuffListBuilder_ != null) {
                    this.serverBuffListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setServerBuffList(int index, ServerBuffOuterClass.ServerBuff.Builder builderForValue) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addServerBuffList(ServerBuffOuterClass.ServerBuff value) {
                if (this.serverBuffListBuilder_ != null) {
                    this.serverBuffListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addServerBuffList(int index, ServerBuffOuterClass.ServerBuff value) {
                if (this.serverBuffListBuilder_ != null) {
                    this.serverBuffListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addServerBuffList(ServerBuffOuterClass.ServerBuff.Builder builderForValue) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addServerBuffList(int index, ServerBuffOuterClass.ServerBuff.Builder builderForValue) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllServerBuffList(Iterable<? extends ServerBuffOuterClass.ServerBuff> values) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.serverBuffList_);
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearServerBuffList() {
                if (this.serverBuffListBuilder_ == null) {
                    this.serverBuffList_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.clear();
                }
                return this;
            }

            public Builder removeServerBuffList(int index) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.remove(index);
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.remove(index);
                }
                return this;
            }

            public ServerBuffOuterClass.ServerBuff.Builder getServerBuffListBuilder(int index) {
                return getServerBuffListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int index) {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.get(index);
                }
                return this.serverBuffListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList() {
                if (this.serverBuffListBuilder_ != null) {
                    return this.serverBuffListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.serverBuffList_);
            }

            public ServerBuffOuterClass.ServerBuff.Builder addServerBuffListBuilder() {
                return getServerBuffListFieldBuilder().addBuilder(ServerBuffOuterClass.ServerBuff.getDefaultInstance());
            }

            public ServerBuffOuterClass.ServerBuff.Builder addServerBuffListBuilder(int index) {
                return getServerBuffListFieldBuilder().addBuilder(index, ServerBuffOuterClass.ServerBuff.getDefaultInstance());
            }

            public List<ServerBuffOuterClass.ServerBuff.Builder> getServerBuffListBuilderList() {
                return getServerBuffListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ServerBuffOuterClass.ServerBuff, ServerBuffOuterClass.ServerBuff.Builder, ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListFieldBuilder() {
                if (this.serverBuffListBuilder_ == null) {
                    this.serverBuffListBuilder_ = new RepeatedFieldBuilderV3<>(this.serverBuffList_, (this.bitField0_ & 32) != 0, getParentForChildren(), isClean());
                    this.serverBuffList_ = null;
                }
                return this.serverBuffListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public boolean hasAvatar() {
                return this.entityCase_ == 10;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public SceneAvatarInfoOuterClass.SceneAvatarInfo getAvatar() {
                if (this.avatarBuilder_ == null) {
                    if (this.entityCase_ == 10) {
                        return (SceneAvatarInfoOuterClass.SceneAvatarInfo) this.entity_;
                    }
                    return SceneAvatarInfoOuterClass.SceneAvatarInfo.getDefaultInstance();
                } else if (this.entityCase_ == 10) {
                    return this.avatarBuilder_.getMessage();
                } else {
                    return SceneAvatarInfoOuterClass.SceneAvatarInfo.getDefaultInstance();
                }
            }

            public Builder setAvatar(SceneAvatarInfoOuterClass.SceneAvatarInfo value) {
                if (this.avatarBuilder_ != null) {
                    this.avatarBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.entity_ = value;
                    onChanged();
                }
                this.entityCase_ = 10;
                return this;
            }

            public Builder setAvatar(SceneAvatarInfoOuterClass.SceneAvatarInfo.Builder builderForValue) {
                if (this.avatarBuilder_ == null) {
                    this.entity_ = builderForValue.build();
                    onChanged();
                } else {
                    this.avatarBuilder_.setMessage(builderForValue.build());
                }
                this.entityCase_ = 10;
                return this;
            }

            public Builder mergeAvatar(SceneAvatarInfoOuterClass.SceneAvatarInfo value) {
                if (this.avatarBuilder_ == null) {
                    if (this.entityCase_ != 10 || this.entity_ == SceneAvatarInfoOuterClass.SceneAvatarInfo.getDefaultInstance()) {
                        this.entity_ = value;
                    } else {
                        this.entity_ = SceneAvatarInfoOuterClass.SceneAvatarInfo.newBuilder((SceneAvatarInfoOuterClass.SceneAvatarInfo) this.entity_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.entityCase_ == 10) {
                        this.avatarBuilder_.mergeFrom(value);
                    }
                    this.avatarBuilder_.setMessage(value);
                }
                this.entityCase_ = 10;
                return this;
            }

            public Builder clearAvatar() {
                if (this.avatarBuilder_ != null) {
                    if (this.entityCase_ == 10) {
                        this.entityCase_ = 0;
                        this.entity_ = null;
                    }
                    this.avatarBuilder_.clear();
                } else if (this.entityCase_ == 10) {
                    this.entityCase_ = 0;
                    this.entity_ = null;
                    onChanged();
                }
                return this;
            }

            public SceneAvatarInfoOuterClass.SceneAvatarInfo.Builder getAvatarBuilder() {
                return getAvatarFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder getAvatarOrBuilder() {
                if (this.entityCase_ == 10 && this.avatarBuilder_ != null) {
                    return this.avatarBuilder_.getMessageOrBuilder();
                }
                if (this.entityCase_ == 10) {
                    return (SceneAvatarInfoOuterClass.SceneAvatarInfo) this.entity_;
                }
                return SceneAvatarInfoOuterClass.SceneAvatarInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SceneAvatarInfoOuterClass.SceneAvatarInfo, SceneAvatarInfoOuterClass.SceneAvatarInfo.Builder, SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder> getAvatarFieldBuilder() {
                if (this.avatarBuilder_ == null) {
                    if (this.entityCase_ != 10) {
                        this.entity_ = SceneAvatarInfoOuterClass.SceneAvatarInfo.getDefaultInstance();
                    }
                    this.avatarBuilder_ = new SingleFieldBuilderV3<>((SceneAvatarInfoOuterClass.SceneAvatarInfo) this.entity_, getParentForChildren(), isClean());
                    this.entity_ = null;
                }
                this.entityCase_ = 10;
                onChanged();
                return this.avatarBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public boolean hasMonster() {
                return this.entityCase_ == 11;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public SceneMonsterInfoOuterClass.SceneMonsterInfo getMonster() {
                if (this.monsterBuilder_ == null) {
                    if (this.entityCase_ == 11) {
                        return (SceneMonsterInfoOuterClass.SceneMonsterInfo) this.entity_;
                    }
                    return SceneMonsterInfoOuterClass.SceneMonsterInfo.getDefaultInstance();
                } else if (this.entityCase_ == 11) {
                    return this.monsterBuilder_.getMessage();
                } else {
                    return SceneMonsterInfoOuterClass.SceneMonsterInfo.getDefaultInstance();
                }
            }

            public Builder setMonster(SceneMonsterInfoOuterClass.SceneMonsterInfo value) {
                if (this.monsterBuilder_ != null) {
                    this.monsterBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.entity_ = value;
                    onChanged();
                }
                this.entityCase_ = 11;
                return this;
            }

            public Builder setMonster(SceneMonsterInfoOuterClass.SceneMonsterInfo.Builder builderForValue) {
                if (this.monsterBuilder_ == null) {
                    this.entity_ = builderForValue.build();
                    onChanged();
                } else {
                    this.monsterBuilder_.setMessage(builderForValue.build());
                }
                this.entityCase_ = 11;
                return this;
            }

            public Builder mergeMonster(SceneMonsterInfoOuterClass.SceneMonsterInfo value) {
                if (this.monsterBuilder_ == null) {
                    if (this.entityCase_ != 11 || this.entity_ == SceneMonsterInfoOuterClass.SceneMonsterInfo.getDefaultInstance()) {
                        this.entity_ = value;
                    } else {
                        this.entity_ = SceneMonsterInfoOuterClass.SceneMonsterInfo.newBuilder((SceneMonsterInfoOuterClass.SceneMonsterInfo) this.entity_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.entityCase_ == 11) {
                        this.monsterBuilder_.mergeFrom(value);
                    }
                    this.monsterBuilder_.setMessage(value);
                }
                this.entityCase_ = 11;
                return this;
            }

            public Builder clearMonster() {
                if (this.monsterBuilder_ != null) {
                    if (this.entityCase_ == 11) {
                        this.entityCase_ = 0;
                        this.entity_ = null;
                    }
                    this.monsterBuilder_.clear();
                } else if (this.entityCase_ == 11) {
                    this.entityCase_ = 0;
                    this.entity_ = null;
                    onChanged();
                }
                return this;
            }

            public SceneMonsterInfoOuterClass.SceneMonsterInfo.Builder getMonsterBuilder() {
                return getMonsterFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder getMonsterOrBuilder() {
                if (this.entityCase_ == 11 && this.monsterBuilder_ != null) {
                    return this.monsterBuilder_.getMessageOrBuilder();
                }
                if (this.entityCase_ == 11) {
                    return (SceneMonsterInfoOuterClass.SceneMonsterInfo) this.entity_;
                }
                return SceneMonsterInfoOuterClass.SceneMonsterInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SceneMonsterInfoOuterClass.SceneMonsterInfo, SceneMonsterInfoOuterClass.SceneMonsterInfo.Builder, SceneMonsterInfoOuterClass.SceneMonsterInfoOrBuilder> getMonsterFieldBuilder() {
                if (this.monsterBuilder_ == null) {
                    if (this.entityCase_ != 11) {
                        this.entity_ = SceneMonsterInfoOuterClass.SceneMonsterInfo.getDefaultInstance();
                    }
                    this.monsterBuilder_ = new SingleFieldBuilderV3<>((SceneMonsterInfoOuterClass.SceneMonsterInfo) this.entity_, getParentForChildren(), isClean());
                    this.entity_ = null;
                }
                this.entityCase_ = 11;
                onChanged();
                return this.monsterBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public boolean hasNpc() {
                return this.entityCase_ == 12;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public SceneNpcInfoOuterClass.SceneNpcInfo getNpc() {
                if (this.npcBuilder_ == null) {
                    if (this.entityCase_ == 12) {
                        return (SceneNpcInfoOuterClass.SceneNpcInfo) this.entity_;
                    }
                    return SceneNpcInfoOuterClass.SceneNpcInfo.getDefaultInstance();
                } else if (this.entityCase_ == 12) {
                    return this.npcBuilder_.getMessage();
                } else {
                    return SceneNpcInfoOuterClass.SceneNpcInfo.getDefaultInstance();
                }
            }

            public Builder setNpc(SceneNpcInfoOuterClass.SceneNpcInfo value) {
                if (this.npcBuilder_ != null) {
                    this.npcBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.entity_ = value;
                    onChanged();
                }
                this.entityCase_ = 12;
                return this;
            }

            public Builder setNpc(SceneNpcInfoOuterClass.SceneNpcInfo.Builder builderForValue) {
                if (this.npcBuilder_ == null) {
                    this.entity_ = builderForValue.build();
                    onChanged();
                } else {
                    this.npcBuilder_.setMessage(builderForValue.build());
                }
                this.entityCase_ = 12;
                return this;
            }

            public Builder mergeNpc(SceneNpcInfoOuterClass.SceneNpcInfo value) {
                if (this.npcBuilder_ == null) {
                    if (this.entityCase_ != 12 || this.entity_ == SceneNpcInfoOuterClass.SceneNpcInfo.getDefaultInstance()) {
                        this.entity_ = value;
                    } else {
                        this.entity_ = SceneNpcInfoOuterClass.SceneNpcInfo.newBuilder((SceneNpcInfoOuterClass.SceneNpcInfo) this.entity_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.entityCase_ == 12) {
                        this.npcBuilder_.mergeFrom(value);
                    }
                    this.npcBuilder_.setMessage(value);
                }
                this.entityCase_ = 12;
                return this;
            }

            public Builder clearNpc() {
                if (this.npcBuilder_ != null) {
                    if (this.entityCase_ == 12) {
                        this.entityCase_ = 0;
                        this.entity_ = null;
                    }
                    this.npcBuilder_.clear();
                } else if (this.entityCase_ == 12) {
                    this.entityCase_ = 0;
                    this.entity_ = null;
                    onChanged();
                }
                return this;
            }

            public SceneNpcInfoOuterClass.SceneNpcInfo.Builder getNpcBuilder() {
                return getNpcFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public SceneNpcInfoOuterClass.SceneNpcInfoOrBuilder getNpcOrBuilder() {
                if (this.entityCase_ == 12 && this.npcBuilder_ != null) {
                    return this.npcBuilder_.getMessageOrBuilder();
                }
                if (this.entityCase_ == 12) {
                    return (SceneNpcInfoOuterClass.SceneNpcInfo) this.entity_;
                }
                return SceneNpcInfoOuterClass.SceneNpcInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SceneNpcInfoOuterClass.SceneNpcInfo, SceneNpcInfoOuterClass.SceneNpcInfo.Builder, SceneNpcInfoOuterClass.SceneNpcInfoOrBuilder> getNpcFieldBuilder() {
                if (this.npcBuilder_ == null) {
                    if (this.entityCase_ != 12) {
                        this.entity_ = SceneNpcInfoOuterClass.SceneNpcInfo.getDefaultInstance();
                    }
                    this.npcBuilder_ = new SingleFieldBuilderV3<>((SceneNpcInfoOuterClass.SceneNpcInfo) this.entity_, getParentForChildren(), isClean());
                    this.entity_ = null;
                }
                this.entityCase_ = 12;
                onChanged();
                return this.npcBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public boolean hasGadget() {
                return this.entityCase_ == 13;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public SceneGadgetInfoOuterClass.SceneGadgetInfo getGadget() {
                if (this.gadgetBuilder_ == null) {
                    if (this.entityCase_ == 13) {
                        return (SceneGadgetInfoOuterClass.SceneGadgetInfo) this.entity_;
                    }
                    return SceneGadgetInfoOuterClass.SceneGadgetInfo.getDefaultInstance();
                } else if (this.entityCase_ == 13) {
                    return this.gadgetBuilder_.getMessage();
                } else {
                    return SceneGadgetInfoOuterClass.SceneGadgetInfo.getDefaultInstance();
                }
            }

            public Builder setGadget(SceneGadgetInfoOuterClass.SceneGadgetInfo value) {
                if (this.gadgetBuilder_ != null) {
                    this.gadgetBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.entity_ = value;
                    onChanged();
                }
                this.entityCase_ = 13;
                return this;
            }

            public Builder setGadget(SceneGadgetInfoOuterClass.SceneGadgetInfo.Builder builderForValue) {
                if (this.gadgetBuilder_ == null) {
                    this.entity_ = builderForValue.build();
                    onChanged();
                } else {
                    this.gadgetBuilder_.setMessage(builderForValue.build());
                }
                this.entityCase_ = 13;
                return this;
            }

            public Builder mergeGadget(SceneGadgetInfoOuterClass.SceneGadgetInfo value) {
                if (this.gadgetBuilder_ == null) {
                    if (this.entityCase_ != 13 || this.entity_ == SceneGadgetInfoOuterClass.SceneGadgetInfo.getDefaultInstance()) {
                        this.entity_ = value;
                    } else {
                        this.entity_ = SceneGadgetInfoOuterClass.SceneGadgetInfo.newBuilder((SceneGadgetInfoOuterClass.SceneGadgetInfo) this.entity_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.entityCase_ == 13) {
                        this.gadgetBuilder_.mergeFrom(value);
                    }
                    this.gadgetBuilder_.setMessage(value);
                }
                this.entityCase_ = 13;
                return this;
            }

            public Builder clearGadget() {
                if (this.gadgetBuilder_ != null) {
                    if (this.entityCase_ == 13) {
                        this.entityCase_ = 0;
                        this.entity_ = null;
                    }
                    this.gadgetBuilder_.clear();
                } else if (this.entityCase_ == 13) {
                    this.entityCase_ = 0;
                    this.entity_ = null;
                    onChanged();
                }
                return this;
            }

            public SceneGadgetInfoOuterClass.SceneGadgetInfo.Builder getGadgetBuilder() {
                return getGadgetFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder
            public SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder getGadgetOrBuilder() {
                if (this.entityCase_ == 13 && this.gadgetBuilder_ != null) {
                    return this.gadgetBuilder_.getMessageOrBuilder();
                }
                if (this.entityCase_ == 13) {
                    return (SceneGadgetInfoOuterClass.SceneGadgetInfo) this.entity_;
                }
                return SceneGadgetInfoOuterClass.SceneGadgetInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SceneGadgetInfoOuterClass.SceneGadgetInfo, SceneGadgetInfoOuterClass.SceneGadgetInfo.Builder, SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder> getGadgetFieldBuilder() {
                if (this.gadgetBuilder_ == null) {
                    if (this.entityCase_ != 13) {
                        this.entity_ = SceneGadgetInfoOuterClass.SceneGadgetInfo.getDefaultInstance();
                    }
                    this.gadgetBuilder_ = new SingleFieldBuilderV3<>((SceneGadgetInfoOuterClass.SceneGadgetInfo) this.entity_, getParentForChildren(), isClean());
                    this.entity_ = null;
                }
                this.entityCase_ = 13;
                onChanged();
                return this.gadgetBuilder_;
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

        public static SceneEntityInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneEntityInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneEntityInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneEntityInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AnimatorParameterValueInfoPairOuterClass.getDescriptor();
        EntityAuthorityInfoOuterClass.getDescriptor();
        EntityClientDataOuterClass.getDescriptor();
        EntityEnvironmentInfoOuterClass.getDescriptor();
        FightPropPairOuterClass.getDescriptor();
        MotionInfoOuterClass.getDescriptor();
        PropPairOuterClass.getDescriptor();
        ProtEntityTypeOuterClass.getDescriptor();
        SceneAvatarInfoOuterClass.getDescriptor();
        SceneGadgetInfoOuterClass.getDescriptor();
        SceneMonsterInfoOuterClass.getDescriptor();
        SceneNpcInfoOuterClass.getDescriptor();
        ServerBuffOuterClass.getDescriptor();
    }
}
