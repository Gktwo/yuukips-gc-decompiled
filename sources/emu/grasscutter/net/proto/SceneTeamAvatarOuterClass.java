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
import emu.grasscutter.net.proto.AbilityControlBlockOuterClass;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import emu.grasscutter.net.proto.AvatarInfoOuterClass;
import emu.grasscutter.net.proto.SceneAvatarInfoOuterClass;
import emu.grasscutter.net.proto.SceneEntityInfoOuterClass;
import emu.grasscutter.net.proto.ServerBuffOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneTeamAvatarOuterClass.class */
public final class SceneTeamAvatarOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015SceneTeamAvatar.proto\u001a\u0019AbilityControlBlock.proto\u001a\u001aAbilitySyncStateInfo.proto\u001a\u0010AvatarInfo.proto\u001a\u0015SceneAvatarInfo.proto\u001a\u0015SceneEntityInfo.proto\u001a\u0010ServerBuff.proto\"\u0004\n\u000fSceneTeamAvatar\u0012+\n\u0011scene_avatar_info\u0018\u000e \u0001(\u000b2\u0010.SceneAvatarInfo\u0012 \n\u000bavatar_info\u0018\u000f \u0001(\u000b2\u000b.AvatarInfo\u0012\u0011\n\tentity_id\u0018\n \u0001(\r\u00122\n\u0013weapon_ability_info\u0018\u0006 \u0001(\u000b2\u0015.AbilitySyncStateInfo\u00123\n\u0015ability_control_block\u0018\u0002 \u0001(\u000b2\u0014.AbilityControlBlock\u0012\u0014\n\fis_reconnect\u0018\b \u0001(\b\u00122\n\u0013avatar_ability_info\u0018\u0004 \u0001(\u000b2\u0015.AbilitySyncStateInfo\u0012\u0013\n\u000bweapon_guid\u0018\f \u0001(\u0004\u0012\u0012\n\nplayer_uid\u0018\u0001 \u0001(\r\u0012+\n\u0011scene_entity_info\u0018\u000b \u0001(\u000b2\u0010.SceneEntityInfo\u0012\u0018\n\u0010weapon_entity_id\u0018\u0005 \u0001(\r\u0012\u0010\n\bscene_id\u0018\t \u0001(\r\u0012\u0014\n\u000bis_on_scene\u0018ñ\u0004 \u0001(\b\u0012\u0013\n\u000bavatar_guid\u0018\u0003 \u0001(\u0004\u0012\u001c\n\u0014is_player_cur_avatar\u0018\r \u0001(\b\u0012%\n\u0010server_buff_list\u0018\u0007 \u0003(\u000b2\u000b.ServerBuffB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilityControlBlockOuterClass.getDescriptor(), AbilitySyncStateInfoOuterClass.getDescriptor(), AvatarInfoOuterClass.getDescriptor(), SceneAvatarInfoOuterClass.getDescriptor(), SceneEntityInfoOuterClass.getDescriptor(), ServerBuffOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SceneTeamAvatar_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneTeamAvatar_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneTeamAvatar_descriptor, new String[]{"SceneAvatarInfo", "AvatarInfo", "EntityId", "WeaponAbilityInfo", "AbilityControlBlock", "IsReconnect", "AvatarAbilityInfo", "WeaponGuid", "PlayerUid", "SceneEntityInfo", "WeaponEntityId", "SceneId", "IsOnScene", "AvatarGuid", "IsPlayerCurAvatar", "ServerBuffList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneTeamAvatarOuterClass$SceneTeamAvatarOrBuilder.class */
    public interface SceneTeamAvatarOrBuilder extends MessageOrBuilder {
        boolean hasSceneAvatarInfo();

        SceneAvatarInfoOuterClass.SceneAvatarInfo getSceneAvatarInfo();

        SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder getSceneAvatarInfoOrBuilder();

        boolean hasAvatarInfo();

        AvatarInfoOuterClass.AvatarInfo getAvatarInfo();

        AvatarInfoOuterClass.AvatarInfoOrBuilder getAvatarInfoOrBuilder();

        int getEntityId();

        boolean hasWeaponAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getWeaponAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getWeaponAbilityInfoOrBuilder();

        boolean hasAbilityControlBlock();

        AbilityControlBlockOuterClass.AbilityControlBlock getAbilityControlBlock();

        AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder getAbilityControlBlockOrBuilder();

        boolean getIsReconnect();

        boolean hasAvatarAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getAvatarAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getAvatarAbilityInfoOrBuilder();

        long getWeaponGuid();

        int getPlayerUid();

        boolean hasSceneEntityInfo();

        SceneEntityInfoOuterClass.SceneEntityInfo getSceneEntityInfo();

        SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder getSceneEntityInfoOrBuilder();

        int getWeaponEntityId();

        int getSceneId();

        boolean getIsOnScene();

        long getAvatarGuid();

        boolean getIsPlayerCurAvatar();

        List<ServerBuffOuterClass.ServerBuff> getServerBuffListList();

        ServerBuffOuterClass.ServerBuff getServerBuffList(int i);

        int getServerBuffListCount();

        List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList();

        ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int i);
    }

    private SceneTeamAvatarOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneTeamAvatarOuterClass$SceneTeamAvatar.class */
    public static final class SceneTeamAvatar extends GeneratedMessageV3 implements SceneTeamAvatarOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SCENE_AVATAR_INFO_FIELD_NUMBER = 14;
        private SceneAvatarInfoOuterClass.SceneAvatarInfo sceneAvatarInfo_;
        public static final int AVATAR_INFO_FIELD_NUMBER = 15;
        private AvatarInfoOuterClass.AvatarInfo avatarInfo_;
        public static final int ENTITY_ID_FIELD_NUMBER = 10;
        private int entityId_;
        public static final int WEAPON_ABILITY_INFO_FIELD_NUMBER = 6;
        private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo weaponAbilityInfo_;
        public static final int ABILITY_CONTROL_BLOCK_FIELD_NUMBER = 2;
        private AbilityControlBlockOuterClass.AbilityControlBlock abilityControlBlock_;
        public static final int IS_RECONNECT_FIELD_NUMBER = 8;
        private boolean isReconnect_;
        public static final int AVATAR_ABILITY_INFO_FIELD_NUMBER = 4;
        private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo avatarAbilityInfo_;
        public static final int WEAPON_GUID_FIELD_NUMBER = 12;
        private long weaponGuid_;
        public static final int PLAYER_UID_FIELD_NUMBER = 1;
        private int playerUid_;
        public static final int SCENE_ENTITY_INFO_FIELD_NUMBER = 11;
        private SceneEntityInfoOuterClass.SceneEntityInfo sceneEntityInfo_;
        public static final int WEAPON_ENTITY_ID_FIELD_NUMBER = 5;
        private int weaponEntityId_;
        public static final int SCENE_ID_FIELD_NUMBER = 9;
        private int sceneId_;
        public static final int IS_ON_SCENE_FIELD_NUMBER = 625;
        private boolean isOnScene_;
        public static final int AVATAR_GUID_FIELD_NUMBER = 3;
        private long avatarGuid_;
        public static final int IS_PLAYER_CUR_AVATAR_FIELD_NUMBER = 13;
        private boolean isPlayerCurAvatar_;
        public static final int SERVER_BUFF_LIST_FIELD_NUMBER = 7;
        private List<ServerBuffOuterClass.ServerBuff> serverBuffList_;
        private byte memoizedIsInitialized;
        private static final SceneTeamAvatar DEFAULT_INSTANCE = new SceneTeamAvatar();
        private static final Parser<SceneTeamAvatar> PARSER = new AbstractParser<SceneTeamAvatar>() { // from class: emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatar.1
            @Override // com.google.protobuf.Parser
            public SceneTeamAvatar parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneTeamAvatar(input, extensionRegistry);
            }
        };

        private SceneTeamAvatar(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SceneTeamAvatar() {
            this.memoizedIsInitialized = -1;
            this.serverBuffList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneTeamAvatar();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneTeamAvatar(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.playerUid_ = input.readUInt32();
                                break;
                            case 18:
                                AbilityControlBlockOuterClass.AbilityControlBlock.Builder subBuilder = this.abilityControlBlock_ != null ? this.abilityControlBlock_.toBuilder() : null;
                                this.abilityControlBlock_ = (AbilityControlBlockOuterClass.AbilityControlBlock) input.readMessage(AbilityControlBlockOuterClass.AbilityControlBlock.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.abilityControlBlock_);
                                    this.abilityControlBlock_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 24:
                                this.avatarGuid_ = input.readUInt64();
                                break;
                            case 34:
                                AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder subBuilder2 = this.avatarAbilityInfo_ != null ? this.avatarAbilityInfo_.toBuilder() : null;
                                this.avatarAbilityInfo_ = (AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo) input.readMessage(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.avatarAbilityInfo_);
                                    this.avatarAbilityInfo_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 40:
                                this.weaponEntityId_ = input.readUInt32();
                                break;
                            case 50:
                                AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder subBuilder3 = this.weaponAbilityInfo_ != null ? this.weaponAbilityInfo_.toBuilder() : null;
                                this.weaponAbilityInfo_ = (AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo) input.readMessage(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.weaponAbilityInfo_);
                                    this.weaponAbilityInfo_ = subBuilder3.buildPartial();
                                    break;
                                }
                            case 58:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.serverBuffList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.serverBuffList_.add((ServerBuffOuterClass.ServerBuff) input.readMessage(ServerBuffOuterClass.ServerBuff.parser(), extensionRegistry));
                                break;
                            case 64:
                                this.isReconnect_ = input.readBool();
                                break;
                            case 72:
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 80:
                                this.entityId_ = input.readUInt32();
                                break;
                            case 90:
                                SceneEntityInfoOuterClass.SceneEntityInfo.Builder subBuilder4 = this.sceneEntityInfo_ != null ? this.sceneEntityInfo_.toBuilder() : null;
                                this.sceneEntityInfo_ = (SceneEntityInfoOuterClass.SceneEntityInfo) input.readMessage(SceneEntityInfoOuterClass.SceneEntityInfo.parser(), extensionRegistry);
                                if (subBuilder4 == null) {
                                    break;
                                } else {
                                    subBuilder4.mergeFrom(this.sceneEntityInfo_);
                                    this.sceneEntityInfo_ = subBuilder4.buildPartial();
                                    break;
                                }
                            case 96:
                                this.weaponGuid_ = input.readUInt64();
                                break;
                            case 104:
                                this.isPlayerCurAvatar_ = input.readBool();
                                break;
                            case 114:
                                SceneAvatarInfoOuterClass.SceneAvatarInfo.Builder subBuilder5 = this.sceneAvatarInfo_ != null ? this.sceneAvatarInfo_.toBuilder() : null;
                                this.sceneAvatarInfo_ = (SceneAvatarInfoOuterClass.SceneAvatarInfo) input.readMessage(SceneAvatarInfoOuterClass.SceneAvatarInfo.parser(), extensionRegistry);
                                if (subBuilder5 == null) {
                                    break;
                                } else {
                                    subBuilder5.mergeFrom(this.sceneAvatarInfo_);
                                    this.sceneAvatarInfo_ = subBuilder5.buildPartial();
                                    break;
                                }
                            case 122:
                                AvatarInfoOuterClass.AvatarInfo.Builder subBuilder6 = this.avatarInfo_ != null ? this.avatarInfo_.toBuilder() : null;
                                this.avatarInfo_ = (AvatarInfoOuterClass.AvatarInfo) input.readMessage(AvatarInfoOuterClass.AvatarInfo.parser(), extensionRegistry);
                                if (subBuilder6 == null) {
                                    break;
                                } else {
                                    subBuilder6.mergeFrom(this.avatarInfo_);
                                    this.avatarInfo_ = subBuilder6.buildPartial();
                                    break;
                                }
                            case 5000:
                                this.isOnScene_ = input.readBool();
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
                    this.serverBuffList_ = Collections.unmodifiableList(this.serverBuffList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SceneTeamAvatarOuterClass.internal_static_SceneTeamAvatar_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneTeamAvatarOuterClass.internal_static_SceneTeamAvatar_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneTeamAvatar.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public boolean hasSceneAvatarInfo() {
            return this.sceneAvatarInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public SceneAvatarInfoOuterClass.SceneAvatarInfo getSceneAvatarInfo() {
            return this.sceneAvatarInfo_ == null ? SceneAvatarInfoOuterClass.SceneAvatarInfo.getDefaultInstance() : this.sceneAvatarInfo_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder getSceneAvatarInfoOrBuilder() {
            return getSceneAvatarInfo();
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public boolean hasAvatarInfo() {
            return this.avatarInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public AvatarInfoOuterClass.AvatarInfo getAvatarInfo() {
            return this.avatarInfo_ == null ? AvatarInfoOuterClass.AvatarInfo.getDefaultInstance() : this.avatarInfo_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public AvatarInfoOuterClass.AvatarInfoOrBuilder getAvatarInfoOrBuilder() {
            return getAvatarInfo();
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public boolean hasWeaponAbilityInfo() {
            return this.weaponAbilityInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getWeaponAbilityInfo() {
            return this.weaponAbilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.weaponAbilityInfo_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getWeaponAbilityInfoOrBuilder() {
            return getWeaponAbilityInfo();
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public boolean hasAbilityControlBlock() {
            return this.abilityControlBlock_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public AbilityControlBlockOuterClass.AbilityControlBlock getAbilityControlBlock() {
            return this.abilityControlBlock_ == null ? AbilityControlBlockOuterClass.AbilityControlBlock.getDefaultInstance() : this.abilityControlBlock_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder getAbilityControlBlockOrBuilder() {
            return getAbilityControlBlock();
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public boolean getIsReconnect() {
            return this.isReconnect_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public boolean hasAvatarAbilityInfo() {
            return this.avatarAbilityInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getAvatarAbilityInfo() {
            return this.avatarAbilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.avatarAbilityInfo_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getAvatarAbilityInfoOrBuilder() {
            return getAvatarAbilityInfo();
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public long getWeaponGuid() {
            return this.weaponGuid_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public int getPlayerUid() {
            return this.playerUid_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public boolean hasSceneEntityInfo() {
            return this.sceneEntityInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public SceneEntityInfoOuterClass.SceneEntityInfo getSceneEntityInfo() {
            return this.sceneEntityInfo_ == null ? SceneEntityInfoOuterClass.SceneEntityInfo.getDefaultInstance() : this.sceneEntityInfo_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder getSceneEntityInfoOrBuilder() {
            return getSceneEntityInfo();
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public int getWeaponEntityId() {
            return this.weaponEntityId_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public boolean getIsOnScene() {
            return this.isOnScene_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public boolean getIsPlayerCurAvatar() {
            return this.isPlayerCurAvatar_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public List<ServerBuffOuterClass.ServerBuff> getServerBuffListList() {
            return this.serverBuffList_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList() {
            return this.serverBuffList_;
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public int getServerBuffListCount() {
            return this.serverBuffList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public ServerBuffOuterClass.ServerBuff getServerBuffList(int index) {
            return this.serverBuffList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
        public ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int index) {
            return this.serverBuffList_.get(index);
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
            if (this.playerUid_ != 0) {
                output.writeUInt32(1, this.playerUid_);
            }
            if (this.abilityControlBlock_ != null) {
                output.writeMessage(2, getAbilityControlBlock());
            }
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(3, this.avatarGuid_);
            }
            if (this.avatarAbilityInfo_ != null) {
                output.writeMessage(4, getAvatarAbilityInfo());
            }
            if (this.weaponEntityId_ != 0) {
                output.writeUInt32(5, this.weaponEntityId_);
            }
            if (this.weaponAbilityInfo_ != null) {
                output.writeMessage(6, getWeaponAbilityInfo());
            }
            for (int i = 0; i < this.serverBuffList_.size(); i++) {
                output.writeMessage(7, this.serverBuffList_.get(i));
            }
            if (this.isReconnect_) {
                output.writeBool(8, this.isReconnect_);
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(9, this.sceneId_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(10, this.entityId_);
            }
            if (this.sceneEntityInfo_ != null) {
                output.writeMessage(11, getSceneEntityInfo());
            }
            if (this.weaponGuid_ != 0) {
                output.writeUInt64(12, this.weaponGuid_);
            }
            if (this.isPlayerCurAvatar_) {
                output.writeBool(13, this.isPlayerCurAvatar_);
            }
            if (this.sceneAvatarInfo_ != null) {
                output.writeMessage(14, getSceneAvatarInfo());
            }
            if (this.avatarInfo_ != null) {
                output.writeMessage(15, getAvatarInfo());
            }
            if (this.isOnScene_) {
                output.writeBool(625, this.isOnScene_);
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
            if (this.playerUid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.playerUid_);
            }
            if (this.abilityControlBlock_ != null) {
                size2 += CodedOutputStream.computeMessageSize(2, getAbilityControlBlock());
            }
            if (this.avatarGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(3, this.avatarGuid_);
            }
            if (this.avatarAbilityInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(4, getAvatarAbilityInfo());
            }
            if (this.weaponEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.weaponEntityId_);
            }
            if (this.weaponAbilityInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(6, getWeaponAbilityInfo());
            }
            for (int i = 0; i < this.serverBuffList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.serverBuffList_.get(i));
            }
            if (this.isReconnect_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isReconnect_);
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.sceneId_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.entityId_);
            }
            if (this.sceneEntityInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getSceneEntityInfo());
            }
            if (this.weaponGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(12, this.weaponGuid_);
            }
            if (this.isPlayerCurAvatar_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isPlayerCurAvatar_);
            }
            if (this.sceneAvatarInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(14, getSceneAvatarInfo());
            }
            if (this.avatarInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(15, getAvatarInfo());
            }
            if (this.isOnScene_) {
                size2 += CodedOutputStream.computeBoolSize(625, this.isOnScene_);
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
            if (!(obj instanceof SceneTeamAvatar)) {
                return equals(obj);
            }
            SceneTeamAvatar other = (SceneTeamAvatar) obj;
            if (hasSceneAvatarInfo() != other.hasSceneAvatarInfo()) {
                return false;
            }
            if ((hasSceneAvatarInfo() && !getSceneAvatarInfo().equals(other.getSceneAvatarInfo())) || hasAvatarInfo() != other.hasAvatarInfo()) {
                return false;
            }
            if ((hasAvatarInfo() && !getAvatarInfo().equals(other.getAvatarInfo())) || getEntityId() != other.getEntityId() || hasWeaponAbilityInfo() != other.hasWeaponAbilityInfo()) {
                return false;
            }
            if ((hasWeaponAbilityInfo() && !getWeaponAbilityInfo().equals(other.getWeaponAbilityInfo())) || hasAbilityControlBlock() != other.hasAbilityControlBlock()) {
                return false;
            }
            if ((hasAbilityControlBlock() && !getAbilityControlBlock().equals(other.getAbilityControlBlock())) || getIsReconnect() != other.getIsReconnect() || hasAvatarAbilityInfo() != other.hasAvatarAbilityInfo()) {
                return false;
            }
            if ((!hasAvatarAbilityInfo() || getAvatarAbilityInfo().equals(other.getAvatarAbilityInfo())) && getWeaponGuid() == other.getWeaponGuid() && getPlayerUid() == other.getPlayerUid() && hasSceneEntityInfo() == other.hasSceneEntityInfo()) {
                return (!hasSceneEntityInfo() || getSceneEntityInfo().equals(other.getSceneEntityInfo())) && getWeaponEntityId() == other.getWeaponEntityId() && getSceneId() == other.getSceneId() && getIsOnScene() == other.getIsOnScene() && getAvatarGuid() == other.getAvatarGuid() && getIsPlayerCurAvatar() == other.getIsPlayerCurAvatar() && getServerBuffListList().equals(other.getServerBuffListList()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasSceneAvatarInfo()) {
                hash = (53 * ((37 * hash) + 14)) + getSceneAvatarInfo().hashCode();
            }
            if (hasAvatarInfo()) {
                hash = (53 * ((37 * hash) + 15)) + getAvatarInfo().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 10)) + getEntityId();
            if (hasWeaponAbilityInfo()) {
                hash2 = (53 * ((37 * hash2) + 6)) + getWeaponAbilityInfo().hashCode();
            }
            if (hasAbilityControlBlock()) {
                hash2 = (53 * ((37 * hash2) + 2)) + getAbilityControlBlock().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 8)) + Internal.hashBoolean(getIsReconnect());
            if (hasAvatarAbilityInfo()) {
                hash3 = (53 * ((37 * hash3) + 4)) + getAvatarAbilityInfo().hashCode();
            }
            int hash4 = (53 * ((37 * ((53 * ((37 * hash3) + 12)) + Internal.hashLong(getWeaponGuid()))) + 1)) + getPlayerUid();
            if (hasSceneEntityInfo()) {
                hash4 = (53 * ((37 * hash4) + 11)) + getSceneEntityInfo().hashCode();
            }
            int hash5 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash4) + 5)) + getWeaponEntityId())) + 9)) + getSceneId())) + 625)) + Internal.hashBoolean(getIsOnScene()))) + 3)) + Internal.hashLong(getAvatarGuid()))) + 13)) + Internal.hashBoolean(getIsPlayerCurAvatar());
            if (getServerBuffListCount() > 0) {
                hash5 = (53 * ((37 * hash5) + 7)) + getServerBuffListList().hashCode();
            }
            int hash6 = (29 * hash5) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash6;
            return hash6;
        }

        public static SceneTeamAvatar parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneTeamAvatar parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneTeamAvatar parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneTeamAvatar parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneTeamAvatar parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneTeamAvatar parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneTeamAvatar parseFrom(InputStream input) throws IOException {
            return (SceneTeamAvatar) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneTeamAvatar parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneTeamAvatar) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneTeamAvatar parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneTeamAvatar) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneTeamAvatar parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneTeamAvatar) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneTeamAvatar parseFrom(CodedInputStream input) throws IOException {
            return (SceneTeamAvatar) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneTeamAvatar parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneTeamAvatar) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneTeamAvatar prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneTeamAvatarOuterClass$SceneTeamAvatar$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneTeamAvatarOrBuilder {
            private int bitField0_;
            private SceneAvatarInfoOuterClass.SceneAvatarInfo sceneAvatarInfo_;
            private SingleFieldBuilderV3<SceneAvatarInfoOuterClass.SceneAvatarInfo, SceneAvatarInfoOuterClass.SceneAvatarInfo.Builder, SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder> sceneAvatarInfoBuilder_;
            private AvatarInfoOuterClass.AvatarInfo avatarInfo_;
            private SingleFieldBuilderV3<AvatarInfoOuterClass.AvatarInfo, AvatarInfoOuterClass.AvatarInfo.Builder, AvatarInfoOuterClass.AvatarInfoOrBuilder> avatarInfoBuilder_;
            private int entityId_;
            private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo weaponAbilityInfo_;
            private SingleFieldBuilderV3<AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder> weaponAbilityInfoBuilder_;
            private AbilityControlBlockOuterClass.AbilityControlBlock abilityControlBlock_;
            private SingleFieldBuilderV3<AbilityControlBlockOuterClass.AbilityControlBlock, AbilityControlBlockOuterClass.AbilityControlBlock.Builder, AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder> abilityControlBlockBuilder_;
            private boolean isReconnect_;
            private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo avatarAbilityInfo_;
            private SingleFieldBuilderV3<AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder> avatarAbilityInfoBuilder_;
            private long weaponGuid_;
            private int playerUid_;
            private SceneEntityInfoOuterClass.SceneEntityInfo sceneEntityInfo_;
            private SingleFieldBuilderV3<SceneEntityInfoOuterClass.SceneEntityInfo, SceneEntityInfoOuterClass.SceneEntityInfo.Builder, SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder> sceneEntityInfoBuilder_;
            private int weaponEntityId_;
            private int sceneId_;
            private boolean isOnScene_;
            private long avatarGuid_;
            private boolean isPlayerCurAvatar_;
            private List<ServerBuffOuterClass.ServerBuff> serverBuffList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ServerBuffOuterClass.ServerBuff, ServerBuffOuterClass.ServerBuff.Builder, ServerBuffOuterClass.ServerBuffOrBuilder> serverBuffListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneTeamAvatarOuterClass.internal_static_SceneTeamAvatar_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneTeamAvatarOuterClass.internal_static_SceneTeamAvatar_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneTeamAvatar.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneTeamAvatar.alwaysUseFieldBuilders) {
                    getServerBuffListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.sceneAvatarInfoBuilder_ == null) {
                    this.sceneAvatarInfo_ = null;
                } else {
                    this.sceneAvatarInfo_ = null;
                    this.sceneAvatarInfoBuilder_ = null;
                }
                if (this.avatarInfoBuilder_ == null) {
                    this.avatarInfo_ = null;
                } else {
                    this.avatarInfo_ = null;
                    this.avatarInfoBuilder_ = null;
                }
                this.entityId_ = 0;
                if (this.weaponAbilityInfoBuilder_ == null) {
                    this.weaponAbilityInfo_ = null;
                } else {
                    this.weaponAbilityInfo_ = null;
                    this.weaponAbilityInfoBuilder_ = null;
                }
                if (this.abilityControlBlockBuilder_ == null) {
                    this.abilityControlBlock_ = null;
                } else {
                    this.abilityControlBlock_ = null;
                    this.abilityControlBlockBuilder_ = null;
                }
                this.isReconnect_ = false;
                if (this.avatarAbilityInfoBuilder_ == null) {
                    this.avatarAbilityInfo_ = null;
                } else {
                    this.avatarAbilityInfo_ = null;
                    this.avatarAbilityInfoBuilder_ = null;
                }
                this.weaponGuid_ = 0;
                this.playerUid_ = 0;
                if (this.sceneEntityInfoBuilder_ == null) {
                    this.sceneEntityInfo_ = null;
                } else {
                    this.sceneEntityInfo_ = null;
                    this.sceneEntityInfoBuilder_ = null;
                }
                this.weaponEntityId_ = 0;
                this.sceneId_ = 0;
                this.isOnScene_ = false;
                this.avatarGuid_ = 0;
                this.isPlayerCurAvatar_ = false;
                if (this.serverBuffListBuilder_ == null) {
                    this.serverBuffList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.serverBuffListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneTeamAvatarOuterClass.internal_static_SceneTeamAvatar_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneTeamAvatar getDefaultInstanceForType() {
                return SceneTeamAvatar.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneTeamAvatar build() {
                SceneTeamAvatar result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneTeamAvatar buildPartial() {
                SceneTeamAvatar result = new SceneTeamAvatar(this);
                int i = this.bitField0_;
                if (this.sceneAvatarInfoBuilder_ == null) {
                    result.sceneAvatarInfo_ = this.sceneAvatarInfo_;
                } else {
                    result.sceneAvatarInfo_ = this.sceneAvatarInfoBuilder_.build();
                }
                if (this.avatarInfoBuilder_ == null) {
                    result.avatarInfo_ = this.avatarInfo_;
                } else {
                    result.avatarInfo_ = this.avatarInfoBuilder_.build();
                }
                result.entityId_ = this.entityId_;
                if (this.weaponAbilityInfoBuilder_ == null) {
                    result.weaponAbilityInfo_ = this.weaponAbilityInfo_;
                } else {
                    result.weaponAbilityInfo_ = this.weaponAbilityInfoBuilder_.build();
                }
                if (this.abilityControlBlockBuilder_ == null) {
                    result.abilityControlBlock_ = this.abilityControlBlock_;
                } else {
                    result.abilityControlBlock_ = this.abilityControlBlockBuilder_.build();
                }
                result.isReconnect_ = this.isReconnect_;
                if (this.avatarAbilityInfoBuilder_ == null) {
                    result.avatarAbilityInfo_ = this.avatarAbilityInfo_;
                } else {
                    result.avatarAbilityInfo_ = this.avatarAbilityInfoBuilder_.build();
                }
                result.weaponGuid_ = this.weaponGuid_;
                result.playerUid_ = this.playerUid_;
                if (this.sceneEntityInfoBuilder_ == null) {
                    result.sceneEntityInfo_ = this.sceneEntityInfo_;
                } else {
                    result.sceneEntityInfo_ = this.sceneEntityInfoBuilder_.build();
                }
                result.weaponEntityId_ = this.weaponEntityId_;
                result.sceneId_ = this.sceneId_;
                result.isOnScene_ = this.isOnScene_;
                result.avatarGuid_ = this.avatarGuid_;
                result.isPlayerCurAvatar_ = this.isPlayerCurAvatar_;
                if (this.serverBuffListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.serverBuffList_ = Collections.unmodifiableList(this.serverBuffList_);
                        this.bitField0_ &= -2;
                    }
                    result.serverBuffList_ = this.serverBuffList_;
                } else {
                    result.serverBuffList_ = this.serverBuffListBuilder_.build();
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
                if (other instanceof SceneTeamAvatar) {
                    return mergeFrom((SceneTeamAvatar) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneTeamAvatar other) {
                if (other == SceneTeamAvatar.getDefaultInstance()) {
                    return this;
                }
                if (other.hasSceneAvatarInfo()) {
                    mergeSceneAvatarInfo(other.getSceneAvatarInfo());
                }
                if (other.hasAvatarInfo()) {
                    mergeAvatarInfo(other.getAvatarInfo());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.hasWeaponAbilityInfo()) {
                    mergeWeaponAbilityInfo(other.getWeaponAbilityInfo());
                }
                if (other.hasAbilityControlBlock()) {
                    mergeAbilityControlBlock(other.getAbilityControlBlock());
                }
                if (other.getIsReconnect()) {
                    setIsReconnect(other.getIsReconnect());
                }
                if (other.hasAvatarAbilityInfo()) {
                    mergeAvatarAbilityInfo(other.getAvatarAbilityInfo());
                }
                if (other.getWeaponGuid() != 0) {
                    setWeaponGuid(other.getWeaponGuid());
                }
                if (other.getPlayerUid() != 0) {
                    setPlayerUid(other.getPlayerUid());
                }
                if (other.hasSceneEntityInfo()) {
                    mergeSceneEntityInfo(other.getSceneEntityInfo());
                }
                if (other.getWeaponEntityId() != 0) {
                    setWeaponEntityId(other.getWeaponEntityId());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (other.getIsOnScene()) {
                    setIsOnScene(other.getIsOnScene());
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                if (other.getIsPlayerCurAvatar()) {
                    setIsPlayerCurAvatar(other.getIsPlayerCurAvatar());
                }
                if (this.serverBuffListBuilder_ == null) {
                    if (!other.serverBuffList_.isEmpty()) {
                        if (this.serverBuffList_.isEmpty()) {
                            this.serverBuffList_ = other.serverBuffList_;
                            this.bitField0_ &= -2;
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
                        this.bitField0_ &= -2;
                        this.serverBuffListBuilder_ = SceneTeamAvatar.alwaysUseFieldBuilders ? getServerBuffListFieldBuilder() : null;
                    } else {
                        this.serverBuffListBuilder_.addAllMessages(other.serverBuffList_);
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
                SceneTeamAvatar parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneTeamAvatar.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneTeamAvatar) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public boolean hasSceneAvatarInfo() {
                return (this.sceneAvatarInfoBuilder_ == null && this.sceneAvatarInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public SceneAvatarInfoOuterClass.SceneAvatarInfo getSceneAvatarInfo() {
                if (this.sceneAvatarInfoBuilder_ == null) {
                    return this.sceneAvatarInfo_ == null ? SceneAvatarInfoOuterClass.SceneAvatarInfo.getDefaultInstance() : this.sceneAvatarInfo_;
                }
                return this.sceneAvatarInfoBuilder_.getMessage();
            }

            public Builder setSceneAvatarInfo(SceneAvatarInfoOuterClass.SceneAvatarInfo value) {
                if (this.sceneAvatarInfoBuilder_ != null) {
                    this.sceneAvatarInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.sceneAvatarInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSceneAvatarInfo(SceneAvatarInfoOuterClass.SceneAvatarInfo.Builder builderForValue) {
                if (this.sceneAvatarInfoBuilder_ == null) {
                    this.sceneAvatarInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.sceneAvatarInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSceneAvatarInfo(SceneAvatarInfoOuterClass.SceneAvatarInfo value) {
                if (this.sceneAvatarInfoBuilder_ == null) {
                    if (this.sceneAvatarInfo_ != null) {
                        this.sceneAvatarInfo_ = SceneAvatarInfoOuterClass.SceneAvatarInfo.newBuilder(this.sceneAvatarInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.sceneAvatarInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.sceneAvatarInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSceneAvatarInfo() {
                if (this.sceneAvatarInfoBuilder_ == null) {
                    this.sceneAvatarInfo_ = null;
                    onChanged();
                } else {
                    this.sceneAvatarInfo_ = null;
                    this.sceneAvatarInfoBuilder_ = null;
                }
                return this;
            }

            public SceneAvatarInfoOuterClass.SceneAvatarInfo.Builder getSceneAvatarInfoBuilder() {
                onChanged();
                return getSceneAvatarInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder getSceneAvatarInfoOrBuilder() {
                if (this.sceneAvatarInfoBuilder_ != null) {
                    return this.sceneAvatarInfoBuilder_.getMessageOrBuilder();
                }
                return this.sceneAvatarInfo_ == null ? SceneAvatarInfoOuterClass.SceneAvatarInfo.getDefaultInstance() : this.sceneAvatarInfo_;
            }

            private SingleFieldBuilderV3<SceneAvatarInfoOuterClass.SceneAvatarInfo, SceneAvatarInfoOuterClass.SceneAvatarInfo.Builder, SceneAvatarInfoOuterClass.SceneAvatarInfoOrBuilder> getSceneAvatarInfoFieldBuilder() {
                if (this.sceneAvatarInfoBuilder_ == null) {
                    this.sceneAvatarInfoBuilder_ = new SingleFieldBuilderV3<>(getSceneAvatarInfo(), getParentForChildren(), isClean());
                    this.sceneAvatarInfo_ = null;
                }
                return this.sceneAvatarInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public boolean hasAvatarInfo() {
                return (this.avatarInfoBuilder_ == null && this.avatarInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public AvatarInfoOuterClass.AvatarInfo getAvatarInfo() {
                if (this.avatarInfoBuilder_ == null) {
                    return this.avatarInfo_ == null ? AvatarInfoOuterClass.AvatarInfo.getDefaultInstance() : this.avatarInfo_;
                }
                return this.avatarInfoBuilder_.getMessage();
            }

            public Builder setAvatarInfo(AvatarInfoOuterClass.AvatarInfo value) {
                if (this.avatarInfoBuilder_ != null) {
                    this.avatarInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.avatarInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAvatarInfo(AvatarInfoOuterClass.AvatarInfo.Builder builderForValue) {
                if (this.avatarInfoBuilder_ == null) {
                    this.avatarInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.avatarInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAvatarInfo(AvatarInfoOuterClass.AvatarInfo value) {
                if (this.avatarInfoBuilder_ == null) {
                    if (this.avatarInfo_ != null) {
                        this.avatarInfo_ = AvatarInfoOuterClass.AvatarInfo.newBuilder(this.avatarInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.avatarInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.avatarInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAvatarInfo() {
                if (this.avatarInfoBuilder_ == null) {
                    this.avatarInfo_ = null;
                    onChanged();
                } else {
                    this.avatarInfo_ = null;
                    this.avatarInfoBuilder_ = null;
                }
                return this;
            }

            public AvatarInfoOuterClass.AvatarInfo.Builder getAvatarInfoBuilder() {
                onChanged();
                return getAvatarInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public AvatarInfoOuterClass.AvatarInfoOrBuilder getAvatarInfoOrBuilder() {
                if (this.avatarInfoBuilder_ != null) {
                    return this.avatarInfoBuilder_.getMessageOrBuilder();
                }
                return this.avatarInfo_ == null ? AvatarInfoOuterClass.AvatarInfo.getDefaultInstance() : this.avatarInfo_;
            }

            private SingleFieldBuilderV3<AvatarInfoOuterClass.AvatarInfo, AvatarInfoOuterClass.AvatarInfo.Builder, AvatarInfoOuterClass.AvatarInfoOrBuilder> getAvatarInfoFieldBuilder() {
                if (this.avatarInfoBuilder_ == null) {
                    this.avatarInfoBuilder_ = new SingleFieldBuilderV3<>(getAvatarInfo(), getParentForChildren(), isClean());
                    this.avatarInfo_ = null;
                }
                return this.avatarInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
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

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public boolean hasWeaponAbilityInfo() {
                return (this.weaponAbilityInfoBuilder_ == null && this.weaponAbilityInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getWeaponAbilityInfo() {
                if (this.weaponAbilityInfoBuilder_ == null) {
                    return this.weaponAbilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.weaponAbilityInfo_;
                }
                return this.weaponAbilityInfoBuilder_.getMessage();
            }

            public Builder setWeaponAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo value) {
                if (this.weaponAbilityInfoBuilder_ != null) {
                    this.weaponAbilityInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.weaponAbilityInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setWeaponAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder builderForValue) {
                if (this.weaponAbilityInfoBuilder_ == null) {
                    this.weaponAbilityInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.weaponAbilityInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeWeaponAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo value) {
                if (this.weaponAbilityInfoBuilder_ == null) {
                    if (this.weaponAbilityInfo_ != null) {
                        this.weaponAbilityInfo_ = AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder(this.weaponAbilityInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.weaponAbilityInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.weaponAbilityInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearWeaponAbilityInfo() {
                if (this.weaponAbilityInfoBuilder_ == null) {
                    this.weaponAbilityInfo_ = null;
                    onChanged();
                } else {
                    this.weaponAbilityInfo_ = null;
                    this.weaponAbilityInfoBuilder_ = null;
                }
                return this;
            }

            public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder getWeaponAbilityInfoBuilder() {
                onChanged();
                return getWeaponAbilityInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getWeaponAbilityInfoOrBuilder() {
                if (this.weaponAbilityInfoBuilder_ != null) {
                    return this.weaponAbilityInfoBuilder_.getMessageOrBuilder();
                }
                return this.weaponAbilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.weaponAbilityInfo_;
            }

            private SingleFieldBuilderV3<AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder> getWeaponAbilityInfoFieldBuilder() {
                if (this.weaponAbilityInfoBuilder_ == null) {
                    this.weaponAbilityInfoBuilder_ = new SingleFieldBuilderV3<>(getWeaponAbilityInfo(), getParentForChildren(), isClean());
                    this.weaponAbilityInfo_ = null;
                }
                return this.weaponAbilityInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public boolean hasAbilityControlBlock() {
                return (this.abilityControlBlockBuilder_ == null && this.abilityControlBlock_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public AbilityControlBlockOuterClass.AbilityControlBlock getAbilityControlBlock() {
                if (this.abilityControlBlockBuilder_ == null) {
                    return this.abilityControlBlock_ == null ? AbilityControlBlockOuterClass.AbilityControlBlock.getDefaultInstance() : this.abilityControlBlock_;
                }
                return this.abilityControlBlockBuilder_.getMessage();
            }

            public Builder setAbilityControlBlock(AbilityControlBlockOuterClass.AbilityControlBlock value) {
                if (this.abilityControlBlockBuilder_ != null) {
                    this.abilityControlBlockBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.abilityControlBlock_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAbilityControlBlock(AbilityControlBlockOuterClass.AbilityControlBlock.Builder builderForValue) {
                if (this.abilityControlBlockBuilder_ == null) {
                    this.abilityControlBlock_ = builderForValue.build();
                    onChanged();
                } else {
                    this.abilityControlBlockBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAbilityControlBlock(AbilityControlBlockOuterClass.AbilityControlBlock value) {
                if (this.abilityControlBlockBuilder_ == null) {
                    if (this.abilityControlBlock_ != null) {
                        this.abilityControlBlock_ = AbilityControlBlockOuterClass.AbilityControlBlock.newBuilder(this.abilityControlBlock_).mergeFrom(value).buildPartial();
                    } else {
                        this.abilityControlBlock_ = value;
                    }
                    onChanged();
                } else {
                    this.abilityControlBlockBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAbilityControlBlock() {
                if (this.abilityControlBlockBuilder_ == null) {
                    this.abilityControlBlock_ = null;
                    onChanged();
                } else {
                    this.abilityControlBlock_ = null;
                    this.abilityControlBlockBuilder_ = null;
                }
                return this;
            }

            public AbilityControlBlockOuterClass.AbilityControlBlock.Builder getAbilityControlBlockBuilder() {
                onChanged();
                return getAbilityControlBlockFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder getAbilityControlBlockOrBuilder() {
                if (this.abilityControlBlockBuilder_ != null) {
                    return this.abilityControlBlockBuilder_.getMessageOrBuilder();
                }
                return this.abilityControlBlock_ == null ? AbilityControlBlockOuterClass.AbilityControlBlock.getDefaultInstance() : this.abilityControlBlock_;
            }

            private SingleFieldBuilderV3<AbilityControlBlockOuterClass.AbilityControlBlock, AbilityControlBlockOuterClass.AbilityControlBlock.Builder, AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder> getAbilityControlBlockFieldBuilder() {
                if (this.abilityControlBlockBuilder_ == null) {
                    this.abilityControlBlockBuilder_ = new SingleFieldBuilderV3<>(getAbilityControlBlock(), getParentForChildren(), isClean());
                    this.abilityControlBlock_ = null;
                }
                return this.abilityControlBlockBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public boolean getIsReconnect() {
                return this.isReconnect_;
            }

            public Builder setIsReconnect(boolean value) {
                this.isReconnect_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsReconnect() {
                this.isReconnect_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public boolean hasAvatarAbilityInfo() {
                return (this.avatarAbilityInfoBuilder_ == null && this.avatarAbilityInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getAvatarAbilityInfo() {
                if (this.avatarAbilityInfoBuilder_ == null) {
                    return this.avatarAbilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.avatarAbilityInfo_;
                }
                return this.avatarAbilityInfoBuilder_.getMessage();
            }

            public Builder setAvatarAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo value) {
                if (this.avatarAbilityInfoBuilder_ != null) {
                    this.avatarAbilityInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.avatarAbilityInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAvatarAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder builderForValue) {
                if (this.avatarAbilityInfoBuilder_ == null) {
                    this.avatarAbilityInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.avatarAbilityInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAvatarAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo value) {
                if (this.avatarAbilityInfoBuilder_ == null) {
                    if (this.avatarAbilityInfo_ != null) {
                        this.avatarAbilityInfo_ = AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder(this.avatarAbilityInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.avatarAbilityInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.avatarAbilityInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAvatarAbilityInfo() {
                if (this.avatarAbilityInfoBuilder_ == null) {
                    this.avatarAbilityInfo_ = null;
                    onChanged();
                } else {
                    this.avatarAbilityInfo_ = null;
                    this.avatarAbilityInfoBuilder_ = null;
                }
                return this;
            }

            public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder getAvatarAbilityInfoBuilder() {
                onChanged();
                return getAvatarAbilityInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getAvatarAbilityInfoOrBuilder() {
                if (this.avatarAbilityInfoBuilder_ != null) {
                    return this.avatarAbilityInfoBuilder_.getMessageOrBuilder();
                }
                return this.avatarAbilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.avatarAbilityInfo_;
            }

            private SingleFieldBuilderV3<AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder> getAvatarAbilityInfoFieldBuilder() {
                if (this.avatarAbilityInfoBuilder_ == null) {
                    this.avatarAbilityInfoBuilder_ = new SingleFieldBuilderV3<>(getAvatarAbilityInfo(), getParentForChildren(), isClean());
                    this.avatarAbilityInfo_ = null;
                }
                return this.avatarAbilityInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public long getWeaponGuid() {
                return this.weaponGuid_;
            }

            public Builder setWeaponGuid(long value) {
                this.weaponGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearWeaponGuid() {
                this.weaponGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public int getPlayerUid() {
                return this.playerUid_;
            }

            public Builder setPlayerUid(int value) {
                this.playerUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerUid() {
                this.playerUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public boolean hasSceneEntityInfo() {
                return (this.sceneEntityInfoBuilder_ == null && this.sceneEntityInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public SceneEntityInfoOuterClass.SceneEntityInfo getSceneEntityInfo() {
                if (this.sceneEntityInfoBuilder_ == null) {
                    return this.sceneEntityInfo_ == null ? SceneEntityInfoOuterClass.SceneEntityInfo.getDefaultInstance() : this.sceneEntityInfo_;
                }
                return this.sceneEntityInfoBuilder_.getMessage();
            }

            public Builder setSceneEntityInfo(SceneEntityInfoOuterClass.SceneEntityInfo value) {
                if (this.sceneEntityInfoBuilder_ != null) {
                    this.sceneEntityInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.sceneEntityInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSceneEntityInfo(SceneEntityInfoOuterClass.SceneEntityInfo.Builder builderForValue) {
                if (this.sceneEntityInfoBuilder_ == null) {
                    this.sceneEntityInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.sceneEntityInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSceneEntityInfo(SceneEntityInfoOuterClass.SceneEntityInfo value) {
                if (this.sceneEntityInfoBuilder_ == null) {
                    if (this.sceneEntityInfo_ != null) {
                        this.sceneEntityInfo_ = SceneEntityInfoOuterClass.SceneEntityInfo.newBuilder(this.sceneEntityInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.sceneEntityInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.sceneEntityInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSceneEntityInfo() {
                if (this.sceneEntityInfoBuilder_ == null) {
                    this.sceneEntityInfo_ = null;
                    onChanged();
                } else {
                    this.sceneEntityInfo_ = null;
                    this.sceneEntityInfoBuilder_ = null;
                }
                return this;
            }

            public SceneEntityInfoOuterClass.SceneEntityInfo.Builder getSceneEntityInfoBuilder() {
                onChanged();
                return getSceneEntityInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder getSceneEntityInfoOrBuilder() {
                if (this.sceneEntityInfoBuilder_ != null) {
                    return this.sceneEntityInfoBuilder_.getMessageOrBuilder();
                }
                return this.sceneEntityInfo_ == null ? SceneEntityInfoOuterClass.SceneEntityInfo.getDefaultInstance() : this.sceneEntityInfo_;
            }

            private SingleFieldBuilderV3<SceneEntityInfoOuterClass.SceneEntityInfo, SceneEntityInfoOuterClass.SceneEntityInfo.Builder, SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder> getSceneEntityInfoFieldBuilder() {
                if (this.sceneEntityInfoBuilder_ == null) {
                    this.sceneEntityInfoBuilder_ = new SingleFieldBuilderV3<>(getSceneEntityInfo(), getParentForChildren(), isClean());
                    this.sceneEntityInfo_ = null;
                }
                return this.sceneEntityInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public int getWeaponEntityId() {
                return this.weaponEntityId_;
            }

            public Builder setWeaponEntityId(int value) {
                this.weaponEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearWeaponEntityId() {
                this.weaponEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
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

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public boolean getIsOnScene() {
                return this.isOnScene_;
            }

            public Builder setIsOnScene(boolean value) {
                this.isOnScene_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOnScene() {
                this.isOnScene_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public long getAvatarGuid() {
                return this.avatarGuid_;
            }

            public Builder setAvatarGuid(long value) {
                this.avatarGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarGuid() {
                this.avatarGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public boolean getIsPlayerCurAvatar() {
                return this.isPlayerCurAvatar_;
            }

            public Builder setIsPlayerCurAvatar(boolean value) {
                this.isPlayerCurAvatar_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsPlayerCurAvatar() {
                this.isPlayerCurAvatar_ = false;
                onChanged();
                return this;
            }

            private void ensureServerBuffListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.serverBuffList_ = new ArrayList(this.serverBuffList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public List<ServerBuffOuterClass.ServerBuff> getServerBuffListList() {
                if (this.serverBuffListBuilder_ == null) {
                    return Collections.unmodifiableList(this.serverBuffList_);
                }
                return this.serverBuffListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public int getServerBuffListCount() {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.size();
                }
                return this.serverBuffListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
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
                    this.bitField0_ &= -2;
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

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
            public ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int index) {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.get(index);
                }
                return this.serverBuffListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneTeamAvatarOuterClass.SceneTeamAvatarOrBuilder
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
                    this.serverBuffListBuilder_ = new RepeatedFieldBuilderV3<>(this.serverBuffList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.serverBuffList_ = null;
                }
                return this.serverBuffListBuilder_;
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

        public static SceneTeamAvatar getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneTeamAvatar> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneTeamAvatar> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneTeamAvatar getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilityControlBlockOuterClass.getDescriptor();
        AbilitySyncStateInfoOuterClass.getDescriptor();
        AvatarInfoOuterClass.getDescriptor();
        SceneAvatarInfoOuterClass.getDescriptor();
        SceneEntityInfoOuterClass.getDescriptor();
        ServerBuffOuterClass.getDescriptor();
    }
}
