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
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import emu.grasscutter.net.proto.ServerBuffOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarEnterSceneInfoOuterClass.class */
public final class AvatarEnterSceneInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aAvatarEnterSceneInfo.proto\u001a\u001aAbilitySyncStateInfo.proto\u001a\u0010ServerBuff.proto\"\u0002\n\u0014AvatarEnterSceneInfo\u0012\u0018\n\u0010weapon_entity_id\u0018\u0005 \u0001(\r\u0012\u0013\n\u000bavatar_guid\u0018\t \u0001(\u0004\u0012\u0018\n\u0010avatar_entity_id\u0018\r \u0001(\r\u0012%\n\u0010server_buff_list\u0018\u0007 \u0003(\u000b2\u000b.ServerBuff\u00122\n\u0013weapon_ability_info\u0018\u0006 \u0001(\u000b2\u0015.AbilitySyncStateInfo\u0012\u0014\n\fbuff_id_list\u0018\b \u0003(\r\u00122\n\u0013avatar_ability_info\u0018\u0001 \u0001(\u000b2\u0015.AbilitySyncStateInfo\u0012\u0013\n\u000bweapon_guid\u0018\u000f \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilitySyncStateInfoOuterClass.getDescriptor(), ServerBuffOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarEnterSceneInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarEnterSceneInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarEnterSceneInfo_descriptor, new String[]{"WeaponEntityId", "AvatarGuid", "AvatarEntityId", "ServerBuffList", "WeaponAbilityInfo", "BuffIdList", "AvatarAbilityInfo", "WeaponGuid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarEnterSceneInfoOuterClass$AvatarEnterSceneInfoOrBuilder.class */
    public interface AvatarEnterSceneInfoOrBuilder extends MessageOrBuilder {
        int getWeaponEntityId();

        long getAvatarGuid();

        int getAvatarEntityId();

        List<ServerBuffOuterClass.ServerBuff> getServerBuffListList();

        ServerBuffOuterClass.ServerBuff getServerBuffList(int i);

        int getServerBuffListCount();

        List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList();

        ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int i);

        boolean hasWeaponAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getWeaponAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getWeaponAbilityInfoOrBuilder();

        List<Integer> getBuffIdListList();

        int getBuffIdListCount();

        int getBuffIdList(int i);

        boolean hasAvatarAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getAvatarAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getAvatarAbilityInfoOrBuilder();

        long getWeaponGuid();
    }

    private AvatarEnterSceneInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarEnterSceneInfoOuterClass$AvatarEnterSceneInfo.class */
    public static final class AvatarEnterSceneInfo extends GeneratedMessageV3 implements AvatarEnterSceneInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int WEAPON_ENTITY_ID_FIELD_NUMBER = 5;
        private int weaponEntityId_;
        public static final int AVATAR_GUID_FIELD_NUMBER = 9;
        private long avatarGuid_;
        public static final int AVATAR_ENTITY_ID_FIELD_NUMBER = 13;
        private int avatarEntityId_;
        public static final int SERVER_BUFF_LIST_FIELD_NUMBER = 7;
        private List<ServerBuffOuterClass.ServerBuff> serverBuffList_;
        public static final int WEAPON_ABILITY_INFO_FIELD_NUMBER = 6;
        private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo weaponAbilityInfo_;
        public static final int BUFF_ID_LIST_FIELD_NUMBER = 8;
        private Internal.IntList buffIdList_;
        private int buffIdListMemoizedSerializedSize;
        public static final int AVATAR_ABILITY_INFO_FIELD_NUMBER = 1;
        private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo avatarAbilityInfo_;
        public static final int WEAPON_GUID_FIELD_NUMBER = 15;
        private long weaponGuid_;
        private byte memoizedIsInitialized;
        private static final AvatarEnterSceneInfo DEFAULT_INSTANCE = new AvatarEnterSceneInfo();
        private static final Parser<AvatarEnterSceneInfo> PARSER = new AbstractParser<AvatarEnterSceneInfo>() { // from class: emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo.1
            @Override // com.google.protobuf.Parser
            public AvatarEnterSceneInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarEnterSceneInfo(input, extensionRegistry);
            }
        };

        private AvatarEnterSceneInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.buffIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private AvatarEnterSceneInfo() {
            this.buffIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.serverBuffList_ = Collections.emptyList();
            this.buffIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarEnterSceneInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:92:0x01d0 */
        private AvatarEnterSceneInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder subBuilder = this.avatarAbilityInfo_ != null ? this.avatarAbilityInfo_.toBuilder() : null;
                                this.avatarAbilityInfo_ = (AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo) input.readMessage(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.avatarAbilityInfo_);
                                    this.avatarAbilityInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 40:
                                this.weaponEntityId_ = input.readUInt32();
                                break;
                            case 50:
                                AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder subBuilder2 = this.weaponAbilityInfo_ != null ? this.weaponAbilityInfo_.toBuilder() : null;
                                this.weaponAbilityInfo_ = (AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo) input.readMessage(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.weaponAbilityInfo_);
                                    this.weaponAbilityInfo_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 58:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.serverBuffList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.serverBuffList_.add((ServerBuffOuterClass.ServerBuff) input.readMessage(ServerBuffOuterClass.ServerBuff.parser(), extensionRegistry));
                                break;
                            case 64:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.buffIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.buffIdList_.addInt(input.readUInt32());
                                break;
                            case 66:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.buffIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.buffIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 72:
                                this.avatarGuid_ = input.readUInt64();
                                break;
                            case 104:
                                this.avatarEntityId_ = input.readUInt32();
                                break;
                            case 120:
                                this.weaponGuid_ = input.readUInt64();
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
                    this.serverBuffList_ = Collections.unmodifiableList(this.serverBuffList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.buffIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvatarEnterSceneInfoOuterClass.internal_static_AvatarEnterSceneInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarEnterSceneInfoOuterClass.internal_static_AvatarEnterSceneInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarEnterSceneInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public int getWeaponEntityId() {
            return this.weaponEntityId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public int getAvatarEntityId() {
            return this.avatarEntityId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public List<ServerBuffOuterClass.ServerBuff> getServerBuffListList() {
            return this.serverBuffList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList() {
            return this.serverBuffList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public int getServerBuffListCount() {
            return this.serverBuffList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public ServerBuffOuterClass.ServerBuff getServerBuffList(int index) {
            return this.serverBuffList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int index) {
            return this.serverBuffList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public boolean hasWeaponAbilityInfo() {
            return this.weaponAbilityInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getWeaponAbilityInfo() {
            return this.weaponAbilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.weaponAbilityInfo_;
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getWeaponAbilityInfoOrBuilder() {
            return getWeaponAbilityInfo();
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public List<Integer> getBuffIdListList() {
            return this.buffIdList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public int getBuffIdListCount() {
            return this.buffIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public int getBuffIdList(int index) {
            return this.buffIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public boolean hasAvatarAbilityInfo() {
            return this.avatarAbilityInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getAvatarAbilityInfo() {
            return this.avatarAbilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.avatarAbilityInfo_;
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getAvatarAbilityInfoOrBuilder() {
            return getAvatarAbilityInfo();
        }

        @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
        public long getWeaponGuid() {
            return this.weaponGuid_;
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
            if (this.avatarAbilityInfo_ != null) {
                output.writeMessage(1, getAvatarAbilityInfo());
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
            if (getBuffIdListList().size() > 0) {
                output.writeUInt32NoTag(66);
                output.writeUInt32NoTag(this.buffIdListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.buffIdList_.size(); i2++) {
                output.writeUInt32NoTag(this.buffIdList_.getInt(i2));
            }
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(9, this.avatarGuid_);
            }
            if (this.avatarEntityId_ != 0) {
                output.writeUInt32(13, this.avatarEntityId_);
            }
            if (this.weaponGuid_ != 0) {
                output.writeUInt64(15, this.weaponGuid_);
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
            if (this.avatarAbilityInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getAvatarAbilityInfo());
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
            int dataSize = 0;
            for (int i2 = 0; i2 < this.buffIdList_.size(); i2++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.buffIdList_.getInt(i2));
            }
            int size3 = size2 + dataSize;
            if (!getBuffIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.buffIdListMemoizedSerializedSize = dataSize;
            if (this.avatarGuid_ != 0) {
                size3 += CodedOutputStream.computeUInt64Size(9, this.avatarGuid_);
            }
            if (this.avatarEntityId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(13, this.avatarEntityId_);
            }
            if (this.weaponGuid_ != 0) {
                size3 += CodedOutputStream.computeUInt64Size(15, this.weaponGuid_);
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
            if (!(obj instanceof AvatarEnterSceneInfo)) {
                return equals(obj);
            }
            AvatarEnterSceneInfo other = (AvatarEnterSceneInfo) obj;
            if (getWeaponEntityId() != other.getWeaponEntityId() || getAvatarGuid() != other.getAvatarGuid() || getAvatarEntityId() != other.getAvatarEntityId() || !getServerBuffListList().equals(other.getServerBuffListList()) || hasWeaponAbilityInfo() != other.hasWeaponAbilityInfo()) {
                return false;
            }
            if ((!hasWeaponAbilityInfo() || getWeaponAbilityInfo().equals(other.getWeaponAbilityInfo())) && getBuffIdListList().equals(other.getBuffIdListList()) && hasAvatarAbilityInfo() == other.hasAvatarAbilityInfo()) {
                return (!hasAvatarAbilityInfo() || getAvatarAbilityInfo().equals(other.getAvatarAbilityInfo())) && getWeaponGuid() == other.getWeaponGuid() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getWeaponEntityId())) + 9)) + Internal.hashLong(getAvatarGuid()))) + 13)) + getAvatarEntityId();
            if (getServerBuffListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getServerBuffListList().hashCode();
            }
            if (hasWeaponAbilityInfo()) {
                hash = (53 * ((37 * hash) + 6)) + getWeaponAbilityInfo().hashCode();
            }
            if (getBuffIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getBuffIdListList().hashCode();
            }
            if (hasAvatarAbilityInfo()) {
                hash = (53 * ((37 * hash) + 1)) + getAvatarAbilityInfo().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 15)) + Internal.hashLong(getWeaponGuid()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarEnterSceneInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarEnterSceneInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarEnterSceneInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarEnterSceneInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarEnterSceneInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarEnterSceneInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarEnterSceneInfo parseFrom(InputStream input) throws IOException {
            return (AvatarEnterSceneInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarEnterSceneInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarEnterSceneInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarEnterSceneInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarEnterSceneInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarEnterSceneInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarEnterSceneInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarEnterSceneInfo parseFrom(CodedInputStream input) throws IOException {
            return (AvatarEnterSceneInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarEnterSceneInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarEnterSceneInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarEnterSceneInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarEnterSceneInfoOuterClass$AvatarEnterSceneInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarEnterSceneInfoOrBuilder {
            private int bitField0_;
            private int weaponEntityId_;
            private long avatarGuid_;
            private int avatarEntityId_;
            private RepeatedFieldBuilderV3<ServerBuffOuterClass.ServerBuff, ServerBuffOuterClass.ServerBuff.Builder, ServerBuffOuterClass.ServerBuffOrBuilder> serverBuffListBuilder_;
            private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo weaponAbilityInfo_;
            private SingleFieldBuilderV3<AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder> weaponAbilityInfoBuilder_;
            private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo avatarAbilityInfo_;
            private SingleFieldBuilderV3<AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder> avatarAbilityInfoBuilder_;
            private long weaponGuid_;
            private List<ServerBuffOuterClass.ServerBuff> serverBuffList_ = Collections.emptyList();
            private Internal.IntList buffIdList_ = AvatarEnterSceneInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarEnterSceneInfoOuterClass.internal_static_AvatarEnterSceneInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarEnterSceneInfoOuterClass.internal_static_AvatarEnterSceneInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarEnterSceneInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarEnterSceneInfo.alwaysUseFieldBuilders) {
                    getServerBuffListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.weaponEntityId_ = 0;
                this.avatarGuid_ = 0;
                this.avatarEntityId_ = 0;
                if (this.serverBuffListBuilder_ == null) {
                    this.serverBuffList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.serverBuffListBuilder_.clear();
                }
                if (this.weaponAbilityInfoBuilder_ == null) {
                    this.weaponAbilityInfo_ = null;
                } else {
                    this.weaponAbilityInfo_ = null;
                    this.weaponAbilityInfoBuilder_ = null;
                }
                this.buffIdList_ = AvatarEnterSceneInfo.emptyIntList();
                this.bitField0_ &= -3;
                if (this.avatarAbilityInfoBuilder_ == null) {
                    this.avatarAbilityInfo_ = null;
                } else {
                    this.avatarAbilityInfo_ = null;
                    this.avatarAbilityInfoBuilder_ = null;
                }
                this.weaponGuid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarEnterSceneInfoOuterClass.internal_static_AvatarEnterSceneInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarEnterSceneInfo getDefaultInstanceForType() {
                return AvatarEnterSceneInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarEnterSceneInfo build() {
                AvatarEnterSceneInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarEnterSceneInfo buildPartial() {
                AvatarEnterSceneInfo result = new AvatarEnterSceneInfo(this);
                int i = this.bitField0_;
                result.weaponEntityId_ = this.weaponEntityId_;
                result.avatarGuid_ = this.avatarGuid_;
                result.avatarEntityId_ = this.avatarEntityId_;
                if (this.serverBuffListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.serverBuffList_ = Collections.unmodifiableList(this.serverBuffList_);
                        this.bitField0_ &= -2;
                    }
                    result.serverBuffList_ = this.serverBuffList_;
                } else {
                    result.serverBuffList_ = this.serverBuffListBuilder_.build();
                }
                if (this.weaponAbilityInfoBuilder_ == null) {
                    result.weaponAbilityInfo_ = this.weaponAbilityInfo_;
                } else {
                    result.weaponAbilityInfo_ = this.weaponAbilityInfoBuilder_.build();
                }
                if ((this.bitField0_ & 2) != 0) {
                    this.buffIdList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.buffIdList_ = this.buffIdList_;
                if (this.avatarAbilityInfoBuilder_ == null) {
                    result.avatarAbilityInfo_ = this.avatarAbilityInfo_;
                } else {
                    result.avatarAbilityInfo_ = this.avatarAbilityInfoBuilder_.build();
                }
                result.weaponGuid_ = this.weaponGuid_;
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
                if (other instanceof AvatarEnterSceneInfo) {
                    return mergeFrom((AvatarEnterSceneInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarEnterSceneInfo other) {
                if (other == AvatarEnterSceneInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getWeaponEntityId() != 0) {
                    setWeaponEntityId(other.getWeaponEntityId());
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                if (other.getAvatarEntityId() != 0) {
                    setAvatarEntityId(other.getAvatarEntityId());
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
                        this.serverBuffListBuilder_ = AvatarEnterSceneInfo.alwaysUseFieldBuilders ? getServerBuffListFieldBuilder() : null;
                    } else {
                        this.serverBuffListBuilder_.addAllMessages(other.serverBuffList_);
                    }
                }
                if (other.hasWeaponAbilityInfo()) {
                    mergeWeaponAbilityInfo(other.getWeaponAbilityInfo());
                }
                if (!other.buffIdList_.isEmpty()) {
                    if (this.buffIdList_.isEmpty()) {
                        this.buffIdList_ = other.buffIdList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureBuffIdListIsMutable();
                        this.buffIdList_.addAll(other.buffIdList_);
                    }
                    onChanged();
                }
                if (other.hasAvatarAbilityInfo()) {
                    mergeAvatarAbilityInfo(other.getAvatarAbilityInfo());
                }
                if (other.getWeaponGuid() != 0) {
                    setWeaponGuid(other.getWeaponGuid());
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
                AvatarEnterSceneInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarEnterSceneInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarEnterSceneInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
            public int getAvatarEntityId() {
                return this.avatarEntityId_;
            }

            public Builder setAvatarEntityId(int value) {
                this.avatarEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarEntityId() {
                this.avatarEntityId_ = 0;
                onChanged();
                return this;
            }

            private void ensureServerBuffListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.serverBuffList_ = new ArrayList(this.serverBuffList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
            public List<ServerBuffOuterClass.ServerBuff> getServerBuffListList() {
                if (this.serverBuffListBuilder_ == null) {
                    return Collections.unmodifiableList(this.serverBuffList_);
                }
                return this.serverBuffListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
            public int getServerBuffListCount() {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.size();
                }
                return this.serverBuffListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
            public ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int index) {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.get(index);
                }
                return this.serverBuffListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
            public boolean hasWeaponAbilityInfo() {
                return (this.weaponAbilityInfoBuilder_ == null && this.weaponAbilityInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
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

            private void ensureBuffIdListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.buffIdList_ = AvatarEnterSceneInfo.mutableCopy(this.buffIdList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
            public List<Integer> getBuffIdListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.buffIdList_) : this.buffIdList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
            public int getBuffIdListCount() {
                return this.buffIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
            public int getBuffIdList(int index) {
                return this.buffIdList_.getInt(index);
            }

            public Builder setBuffIdList(int index, int value) {
                ensureBuffIdListIsMutable();
                this.buffIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addBuffIdList(int value) {
                ensureBuffIdListIsMutable();
                this.buffIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllBuffIdList(Iterable<? extends Integer> values) {
                ensureBuffIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.buffIdList_);
                onChanged();
                return this;
            }

            public Builder clearBuffIdList() {
                this.buffIdList_ = AvatarEnterSceneInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
            public boolean hasAvatarAbilityInfo() {
                return (this.avatarAbilityInfoBuilder_ == null && this.avatarAbilityInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static AvatarEnterSceneInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarEnterSceneInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarEnterSceneInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarEnterSceneInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilitySyncStateInfoOuterClass.getDescriptor();
        ServerBuffOuterClass.getDescriptor();
    }
}
