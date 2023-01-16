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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.MpSettingTypeOuterClass;
import emu.grasscutter.net.proto.ProfilePictureOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import javassist.bytecode.SignatureAttribute;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OnlinePlayerInfoOuterClass.class */
public final class OnlinePlayerInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016OnlinePlayerInfo.proto\u001a\u0013MpSettingType.proto\u001a\u0014ProfilePicture.proto\"Ë\u0002\n\u0010OnlinePlayerInfo\u0012\u000b\n\u0003uid\u0018\u0001 \u0001(\r\u0012\u0010\n\bnickname\u0018\u0002 \u0001(\t\u0012\u0014\n\fplayer_level\u0018\u0003 \u0001(\r\u0012\u0011\n\tavatar_id\u0018\u0004 \u0001(\r\u0012'\n\u000fmp_setting_type\u0018\u0005 \u0001(\u000e2\u000e.MpSettingType\u0012\u001f\n\u0017cur_player_num_in_world\u0018\u0006 \u0001(\r\u0012\u0013\n\u000bworld_level\u0018\u0007 \u0001(\r\u0012\u0011\n\tonline_id\u0018\b \u0001(\t\u0012\u0014\n\fname_card_id\u0018\t \u0001(\r\u0012\u001a\n\u0012blacklist_uid_list\u0018\n \u0003(\r\u0012\u0011\n\tsignature\u0018\u000b \u0001(\t\u0012(\n\u000fprofile_picture\u0018\f \u0001(\u000b2\u000f.ProfilePicture\u0012\u000e\n\u0006psn_id\u0018\r \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MpSettingTypeOuterClass.getDescriptor(), ProfilePictureOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_OnlinePlayerInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_OnlinePlayerInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_OnlinePlayerInfo_descriptor, new String[]{"Uid", "Nickname", "PlayerLevel", "AvatarId", "MpSettingType", "CurPlayerNumInWorld", "WorldLevel", "OnlineId", "NameCardId", "BlacklistUidList", SignatureAttribute.tag, "ProfilePicture", "PsnId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OnlinePlayerInfoOuterClass$OnlinePlayerInfoOrBuilder.class */
    public interface OnlinePlayerInfoOrBuilder extends MessageOrBuilder {
        int getUid();

        String getNickname();

        ByteString getNicknameBytes();

        int getPlayerLevel();

        int getAvatarId();

        int getMpSettingTypeValue();

        MpSettingTypeOuterClass.MpSettingType getMpSettingType();

        int getCurPlayerNumInWorld();

        int getWorldLevel();

        String getOnlineId();

        ByteString getOnlineIdBytes();

        int getNameCardId();

        List<Integer> getBlacklistUidListList();

        int getBlacklistUidListCount();

        int getBlacklistUidList(int i);

        String getSignature();

        ByteString getSignatureBytes();

        boolean hasProfilePicture();

        ProfilePictureOuterClass.ProfilePicture getProfilePicture();

        ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder();

        String getPsnId();

        ByteString getPsnIdBytes();
    }

    private OnlinePlayerInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OnlinePlayerInfoOuterClass$OnlinePlayerInfo.class */
    public static final class OnlinePlayerInfo extends GeneratedMessageV3 implements OnlinePlayerInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UID_FIELD_NUMBER = 1;
        private int uid_;
        public static final int NICKNAME_FIELD_NUMBER = 2;
        private volatile Object nickname_;
        public static final int PLAYER_LEVEL_FIELD_NUMBER = 3;
        private int playerLevel_;
        public static final int AVATAR_ID_FIELD_NUMBER = 4;
        private int avatarId_;
        public static final int MP_SETTING_TYPE_FIELD_NUMBER = 5;
        private int mpSettingType_;
        public static final int CUR_PLAYER_NUM_IN_WORLD_FIELD_NUMBER = 6;
        private int curPlayerNumInWorld_;
        public static final int WORLD_LEVEL_FIELD_NUMBER = 7;
        private int worldLevel_;
        public static final int ONLINE_ID_FIELD_NUMBER = 8;
        private volatile Object onlineId_;
        public static final int NAME_CARD_ID_FIELD_NUMBER = 9;
        private int nameCardId_;
        public static final int BLACKLIST_UID_LIST_FIELD_NUMBER = 10;
        private Internal.IntList blacklistUidList_;
        private int blacklistUidListMemoizedSerializedSize;
        public static final int SIGNATURE_FIELD_NUMBER = 11;
        private volatile Object signature_;
        public static final int PROFILE_PICTURE_FIELD_NUMBER = 12;
        private ProfilePictureOuterClass.ProfilePicture profilePicture_;
        public static final int PSN_ID_FIELD_NUMBER = 13;
        private volatile Object psnId_;
        private byte memoizedIsInitialized;
        private static final OnlinePlayerInfo DEFAULT_INSTANCE = new OnlinePlayerInfo();
        private static final Parser<OnlinePlayerInfo> PARSER = new AbstractParser<OnlinePlayerInfo>() { // from class: emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo.1
            @Override // com.google.protobuf.Parser
            public OnlinePlayerInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new OnlinePlayerInfo(input, extensionRegistry);
            }
        };

        private OnlinePlayerInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.blacklistUidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private OnlinePlayerInfo() {
            this.blacklistUidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.nickname_ = "";
            this.mpSettingType_ = 0;
            this.onlineId_ = "";
            this.blacklistUidList_ = emptyIntList();
            this.signature_ = "";
            this.psnId_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new OnlinePlayerInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnlinePlayerInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.uid_ = input.readUInt32();
                                break;
                            case 18:
                                this.nickname_ = input.readStringRequireUtf8();
                                break;
                            case 24:
                                this.playerLevel_ = input.readUInt32();
                                break;
                            case 32:
                                this.avatarId_ = input.readUInt32();
                                break;
                            case 40:
                                this.mpSettingType_ = input.readEnum();
                                break;
                            case 48:
                                this.curPlayerNumInWorld_ = input.readUInt32();
                                break;
                            case 56:
                                this.worldLevel_ = input.readUInt32();
                                break;
                            case 66:
                                this.onlineId_ = input.readStringRequireUtf8();
                                break;
                            case 72:
                                this.nameCardId_ = input.readUInt32();
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.blacklistUidList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.blacklistUidList_.addInt(input.readUInt32());
                                break;
                            case 82:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.blacklistUidList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.blacklistUidList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 90:
                                this.signature_ = input.readStringRequireUtf8();
                                break;
                            case 98:
                                ProfilePictureOuterClass.ProfilePicture.Builder subBuilder = this.profilePicture_ != null ? this.profilePicture_.toBuilder() : null;
                                this.profilePicture_ = (ProfilePictureOuterClass.ProfilePicture) input.readMessage(ProfilePictureOuterClass.ProfilePicture.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.profilePicture_);
                                    this.profilePicture_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 106:
                                this.psnId_ = input.readStringRequireUtf8();
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
                    this.blacklistUidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return OnlinePlayerInfoOuterClass.internal_static_OnlinePlayerInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return OnlinePlayerInfoOuterClass.internal_static_OnlinePlayerInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(OnlinePlayerInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public String getNickname() {
            Object ref = this.nickname_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.nickname_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public ByteString getNicknameBytes() {
            Object ref = this.nickname_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.nickname_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public int getPlayerLevel() {
            return this.playerLevel_;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public int getAvatarId() {
            return this.avatarId_;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public int getMpSettingTypeValue() {
            return this.mpSettingType_;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public MpSettingTypeOuterClass.MpSettingType getMpSettingType() {
            MpSettingTypeOuterClass.MpSettingType result = MpSettingTypeOuterClass.MpSettingType.valueOf(this.mpSettingType_);
            return result == null ? MpSettingTypeOuterClass.MpSettingType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public int getCurPlayerNumInWorld() {
            return this.curPlayerNumInWorld_;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public int getWorldLevel() {
            return this.worldLevel_;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public String getOnlineId() {
            Object ref = this.onlineId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.onlineId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public ByteString getOnlineIdBytes() {
            Object ref = this.onlineId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.onlineId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public int getNameCardId() {
            return this.nameCardId_;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public List<Integer> getBlacklistUidListList() {
            return this.blacklistUidList_;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public int getBlacklistUidListCount() {
            return this.blacklistUidList_.size();
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public int getBlacklistUidList(int index) {
            return this.blacklistUidList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public String getSignature() {
            Object ref = this.signature_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.signature_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public ByteString getSignatureBytes() {
            Object ref = this.signature_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.signature_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public boolean hasProfilePicture() {
            return this.profilePicture_ != null;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public ProfilePictureOuterClass.ProfilePicture getProfilePicture() {
            return this.profilePicture_ == null ? ProfilePictureOuterClass.ProfilePicture.getDefaultInstance() : this.profilePicture_;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder() {
            return getProfilePicture();
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public String getPsnId() {
            Object ref = this.psnId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.psnId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
        public ByteString getPsnIdBytes() {
            Object ref = this.psnId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.psnId_ = b;
            return b;
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
            if (this.uid_ != 0) {
                output.writeUInt32(1, this.uid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.nickname_)) {
                GeneratedMessageV3.writeString(output, 2, this.nickname_);
            }
            if (this.playerLevel_ != 0) {
                output.writeUInt32(3, this.playerLevel_);
            }
            if (this.avatarId_ != 0) {
                output.writeUInt32(4, this.avatarId_);
            }
            if (this.mpSettingType_ != MpSettingTypeOuterClass.MpSettingType.MP_SETTING_TYPE_NO_ENTER.getNumber()) {
                output.writeEnum(5, this.mpSettingType_);
            }
            if (this.curPlayerNumInWorld_ != 0) {
                output.writeUInt32(6, this.curPlayerNumInWorld_);
            }
            if (this.worldLevel_ != 0) {
                output.writeUInt32(7, this.worldLevel_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.onlineId_)) {
                GeneratedMessageV3.writeString(output, 8, this.onlineId_);
            }
            if (this.nameCardId_ != 0) {
                output.writeUInt32(9, this.nameCardId_);
            }
            if (getBlacklistUidListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.blacklistUidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.blacklistUidList_.size(); i++) {
                output.writeUInt32NoTag(this.blacklistUidList_.getInt(i));
            }
            if (!GeneratedMessageV3.isStringEmpty(this.signature_)) {
                GeneratedMessageV3.writeString(output, 11, this.signature_);
            }
            if (this.profilePicture_ != null) {
                output.writeMessage(12, getProfilePicture());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.psnId_)) {
                GeneratedMessageV3.writeString(output, 13, this.psnId_);
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
            if (this.uid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.uid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.nickname_)) {
                size2 += GeneratedMessageV3.computeStringSize(2, this.nickname_);
            }
            if (this.playerLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.playerLevel_);
            }
            if (this.avatarId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.avatarId_);
            }
            if (this.mpSettingType_ != MpSettingTypeOuterClass.MpSettingType.MP_SETTING_TYPE_NO_ENTER.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(5, this.mpSettingType_);
            }
            if (this.curPlayerNumInWorld_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.curPlayerNumInWorld_);
            }
            if (this.worldLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.worldLevel_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.onlineId_)) {
                size2 += GeneratedMessageV3.computeStringSize(8, this.onlineId_);
            }
            if (this.nameCardId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.nameCardId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.blacklistUidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.blacklistUidList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getBlacklistUidListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.blacklistUidListMemoizedSerializedSize = dataSize;
            if (!GeneratedMessageV3.isStringEmpty(this.signature_)) {
                size3 += GeneratedMessageV3.computeStringSize(11, this.signature_);
            }
            if (this.profilePicture_ != null) {
                size3 += CodedOutputStream.computeMessageSize(12, getProfilePicture());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.psnId_)) {
                size3 += GeneratedMessageV3.computeStringSize(13, this.psnId_);
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
            if (!(obj instanceof OnlinePlayerInfo)) {
                return equals(obj);
            }
            OnlinePlayerInfo other = (OnlinePlayerInfo) obj;
            if (getUid() == other.getUid() && getNickname().equals(other.getNickname()) && getPlayerLevel() == other.getPlayerLevel() && getAvatarId() == other.getAvatarId() && this.mpSettingType_ == other.mpSettingType_ && getCurPlayerNumInWorld() == other.getCurPlayerNumInWorld() && getWorldLevel() == other.getWorldLevel() && getOnlineId().equals(other.getOnlineId()) && getNameCardId() == other.getNameCardId() && getBlacklistUidListList().equals(other.getBlacklistUidListList()) && getSignature().equals(other.getSignature()) && hasProfilePicture() == other.hasProfilePicture()) {
                return (!hasProfilePicture() || getProfilePicture().equals(other.getProfilePicture())) && getPsnId().equals(other.getPsnId()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getUid())) + 2)) + getNickname().hashCode())) + 3)) + getPlayerLevel())) + 4)) + getAvatarId())) + 5)) + this.mpSettingType_)) + 6)) + getCurPlayerNumInWorld())) + 7)) + getWorldLevel())) + 8)) + getOnlineId().hashCode())) + 9)) + getNameCardId();
            if (getBlacklistUidListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getBlacklistUidListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 11)) + getSignature().hashCode();
            if (hasProfilePicture()) {
                hash2 = (53 * ((37 * hash2) + 12)) + getProfilePicture().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 13)) + getPsnId().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static OnlinePlayerInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OnlinePlayerInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnlinePlayerInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OnlinePlayerInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnlinePlayerInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OnlinePlayerInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnlinePlayerInfo parseFrom(InputStream input) throws IOException {
            return (OnlinePlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static OnlinePlayerInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnlinePlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static OnlinePlayerInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (OnlinePlayerInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static OnlinePlayerInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnlinePlayerInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static OnlinePlayerInfo parseFrom(CodedInputStream input) throws IOException {
            return (OnlinePlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static OnlinePlayerInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnlinePlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(OnlinePlayerInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OnlinePlayerInfoOuterClass$OnlinePlayerInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements OnlinePlayerInfoOrBuilder {
            private int bitField0_;
            private int uid_;
            private int playerLevel_;
            private int avatarId_;
            private int curPlayerNumInWorld_;
            private int worldLevel_;
            private int nameCardId_;
            private ProfilePictureOuterClass.ProfilePicture profilePicture_;
            private SingleFieldBuilderV3<ProfilePictureOuterClass.ProfilePicture, ProfilePictureOuterClass.ProfilePicture.Builder, ProfilePictureOuterClass.ProfilePictureOrBuilder> profilePictureBuilder_;
            private Object nickname_ = "";
            private int mpSettingType_ = 0;
            private Object onlineId_ = "";
            private Internal.IntList blacklistUidList_ = OnlinePlayerInfo.emptyIntList();
            private Object signature_ = "";
            private Object psnId_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return OnlinePlayerInfoOuterClass.internal_static_OnlinePlayerInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return OnlinePlayerInfoOuterClass.internal_static_OnlinePlayerInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(OnlinePlayerInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (OnlinePlayerInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.uid_ = 0;
                this.nickname_ = "";
                this.playerLevel_ = 0;
                this.avatarId_ = 0;
                this.mpSettingType_ = 0;
                this.curPlayerNumInWorld_ = 0;
                this.worldLevel_ = 0;
                this.onlineId_ = "";
                this.nameCardId_ = 0;
                this.blacklistUidList_ = OnlinePlayerInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.signature_ = "";
                if (this.profilePictureBuilder_ == null) {
                    this.profilePicture_ = null;
                } else {
                    this.profilePicture_ = null;
                    this.profilePictureBuilder_ = null;
                }
                this.psnId_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return OnlinePlayerInfoOuterClass.internal_static_OnlinePlayerInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public OnlinePlayerInfo getDefaultInstanceForType() {
                return OnlinePlayerInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public OnlinePlayerInfo build() {
                OnlinePlayerInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public OnlinePlayerInfo buildPartial() {
                OnlinePlayerInfo result = new OnlinePlayerInfo(this);
                int i = this.bitField0_;
                result.uid_ = this.uid_;
                result.nickname_ = this.nickname_;
                result.playerLevel_ = this.playerLevel_;
                result.avatarId_ = this.avatarId_;
                result.mpSettingType_ = this.mpSettingType_;
                result.curPlayerNumInWorld_ = this.curPlayerNumInWorld_;
                result.worldLevel_ = this.worldLevel_;
                result.onlineId_ = this.onlineId_;
                result.nameCardId_ = this.nameCardId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.blacklistUidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.blacklistUidList_ = this.blacklistUidList_;
                result.signature_ = this.signature_;
                if (this.profilePictureBuilder_ == null) {
                    result.profilePicture_ = this.profilePicture_;
                } else {
                    result.profilePicture_ = this.profilePictureBuilder_.build();
                }
                result.psnId_ = this.psnId_;
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
                if (other instanceof OnlinePlayerInfo) {
                    return mergeFrom((OnlinePlayerInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(OnlinePlayerInfo other) {
                if (other == OnlinePlayerInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (!other.getNickname().isEmpty()) {
                    this.nickname_ = other.nickname_;
                    onChanged();
                }
                if (other.getPlayerLevel() != 0) {
                    setPlayerLevel(other.getPlayerLevel());
                }
                if (other.getAvatarId() != 0) {
                    setAvatarId(other.getAvatarId());
                }
                if (other.mpSettingType_ != 0) {
                    setMpSettingTypeValue(other.getMpSettingTypeValue());
                }
                if (other.getCurPlayerNumInWorld() != 0) {
                    setCurPlayerNumInWorld(other.getCurPlayerNumInWorld());
                }
                if (other.getWorldLevel() != 0) {
                    setWorldLevel(other.getWorldLevel());
                }
                if (!other.getOnlineId().isEmpty()) {
                    this.onlineId_ = other.onlineId_;
                    onChanged();
                }
                if (other.getNameCardId() != 0) {
                    setNameCardId(other.getNameCardId());
                }
                if (!other.blacklistUidList_.isEmpty()) {
                    if (this.blacklistUidList_.isEmpty()) {
                        this.blacklistUidList_ = other.blacklistUidList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureBlacklistUidListIsMutable();
                        this.blacklistUidList_.addAll(other.blacklistUidList_);
                    }
                    onChanged();
                }
                if (!other.getSignature().isEmpty()) {
                    this.signature_ = other.signature_;
                    onChanged();
                }
                if (other.hasProfilePicture()) {
                    mergeProfilePicture(other.getProfilePicture());
                }
                if (!other.getPsnId().isEmpty()) {
                    this.psnId_ = other.psnId_;
                    onChanged();
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
                OnlinePlayerInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = OnlinePlayerInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (OnlinePlayerInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public int getUid() {
                return this.uid_;
            }

            public Builder setUid(int value) {
                this.uid_ = value;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public String getNickname() {
                Object ref = this.nickname_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.nickname_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public ByteString getNicknameBytes() {
                Object ref = this.nickname_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.nickname_ = b;
                return b;
            }

            public Builder setNickname(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.nickname_ = value;
                onChanged();
                return this;
            }

            public Builder clearNickname() {
                this.nickname_ = OnlinePlayerInfo.getDefaultInstance().getNickname();
                onChanged();
                return this;
            }

            public Builder setNicknameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                OnlinePlayerInfo.checkByteStringIsUtf8(value);
                this.nickname_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public int getPlayerLevel() {
                return this.playerLevel_;
            }

            public Builder setPlayerLevel(int value) {
                this.playerLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerLevel() {
                this.playerLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public int getAvatarId() {
                return this.avatarId_;
            }

            public Builder setAvatarId(int value) {
                this.avatarId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarId() {
                this.avatarId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public int getMpSettingTypeValue() {
                return this.mpSettingType_;
            }

            public Builder setMpSettingTypeValue(int value) {
                this.mpSettingType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public MpSettingTypeOuterClass.MpSettingType getMpSettingType() {
                MpSettingTypeOuterClass.MpSettingType result = MpSettingTypeOuterClass.MpSettingType.valueOf(this.mpSettingType_);
                return result == null ? MpSettingTypeOuterClass.MpSettingType.UNRECOGNIZED : result;
            }

            public Builder setMpSettingType(MpSettingTypeOuterClass.MpSettingType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.mpSettingType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearMpSettingType() {
                this.mpSettingType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public int getCurPlayerNumInWorld() {
                return this.curPlayerNumInWorld_;
            }

            public Builder setCurPlayerNumInWorld(int value) {
                this.curPlayerNumInWorld_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurPlayerNumInWorld() {
                this.curPlayerNumInWorld_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public int getWorldLevel() {
                return this.worldLevel_;
            }

            public Builder setWorldLevel(int value) {
                this.worldLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearWorldLevel() {
                this.worldLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public String getOnlineId() {
                Object ref = this.onlineId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.onlineId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public ByteString getOnlineIdBytes() {
                Object ref = this.onlineId_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.onlineId_ = b;
                return b;
            }

            public Builder setOnlineId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.onlineId_ = value;
                onChanged();
                return this;
            }

            public Builder clearOnlineId() {
                this.onlineId_ = OnlinePlayerInfo.getDefaultInstance().getOnlineId();
                onChanged();
                return this;
            }

            public Builder setOnlineIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                OnlinePlayerInfo.checkByteStringIsUtf8(value);
                this.onlineId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public int getNameCardId() {
                return this.nameCardId_;
            }

            public Builder setNameCardId(int value) {
                this.nameCardId_ = value;
                onChanged();
                return this;
            }

            public Builder clearNameCardId() {
                this.nameCardId_ = 0;
                onChanged();
                return this;
            }

            private void ensureBlacklistUidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.blacklistUidList_ = OnlinePlayerInfo.mutableCopy(this.blacklistUidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public List<Integer> getBlacklistUidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.blacklistUidList_) : this.blacklistUidList_;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public int getBlacklistUidListCount() {
                return this.blacklistUidList_.size();
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public int getBlacklistUidList(int index) {
                return this.blacklistUidList_.getInt(index);
            }

            public Builder setBlacklistUidList(int index, int value) {
                ensureBlacklistUidListIsMutable();
                this.blacklistUidList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addBlacklistUidList(int value) {
                ensureBlacklistUidListIsMutable();
                this.blacklistUidList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllBlacklistUidList(Iterable<? extends Integer> values) {
                ensureBlacklistUidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.blacklistUidList_);
                onChanged();
                return this;
            }

            public Builder clearBlacklistUidList() {
                this.blacklistUidList_ = OnlinePlayerInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public String getSignature() {
                Object ref = this.signature_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.signature_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public ByteString getSignatureBytes() {
                Object ref = this.signature_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.signature_ = b;
                return b;
            }

            public Builder setSignature(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.signature_ = value;
                onChanged();
                return this;
            }

            public Builder clearSignature() {
                this.signature_ = OnlinePlayerInfo.getDefaultInstance().getSignature();
                onChanged();
                return this;
            }

            public Builder setSignatureBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                OnlinePlayerInfo.checkByteStringIsUtf8(value);
                this.signature_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public boolean hasProfilePicture() {
                return (this.profilePictureBuilder_ == null && this.profilePicture_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public ProfilePictureOuterClass.ProfilePicture getProfilePicture() {
                if (this.profilePictureBuilder_ == null) {
                    return this.profilePicture_ == null ? ProfilePictureOuterClass.ProfilePicture.getDefaultInstance() : this.profilePicture_;
                }
                return this.profilePictureBuilder_.getMessage();
            }

            public Builder setProfilePicture(ProfilePictureOuterClass.ProfilePicture value) {
                if (this.profilePictureBuilder_ != null) {
                    this.profilePictureBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.profilePicture_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setProfilePicture(ProfilePictureOuterClass.ProfilePicture.Builder builderForValue) {
                if (this.profilePictureBuilder_ == null) {
                    this.profilePicture_ = builderForValue.build();
                    onChanged();
                } else {
                    this.profilePictureBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeProfilePicture(ProfilePictureOuterClass.ProfilePicture value) {
                if (this.profilePictureBuilder_ == null) {
                    if (this.profilePicture_ != null) {
                        this.profilePicture_ = ProfilePictureOuterClass.ProfilePicture.newBuilder(this.profilePicture_).mergeFrom(value).buildPartial();
                    } else {
                        this.profilePicture_ = value;
                    }
                    onChanged();
                } else {
                    this.profilePictureBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearProfilePicture() {
                if (this.profilePictureBuilder_ == null) {
                    this.profilePicture_ = null;
                    onChanged();
                } else {
                    this.profilePicture_ = null;
                    this.profilePictureBuilder_ = null;
                }
                return this;
            }

            public ProfilePictureOuterClass.ProfilePicture.Builder getProfilePictureBuilder() {
                onChanged();
                return getProfilePictureFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder() {
                if (this.profilePictureBuilder_ != null) {
                    return this.profilePictureBuilder_.getMessageOrBuilder();
                }
                return this.profilePicture_ == null ? ProfilePictureOuterClass.ProfilePicture.getDefaultInstance() : this.profilePicture_;
            }

            private SingleFieldBuilderV3<ProfilePictureOuterClass.ProfilePicture, ProfilePictureOuterClass.ProfilePicture.Builder, ProfilePictureOuterClass.ProfilePictureOrBuilder> getProfilePictureFieldBuilder() {
                if (this.profilePictureBuilder_ == null) {
                    this.profilePictureBuilder_ = new SingleFieldBuilderV3<>(getProfilePicture(), getParentForChildren(), isClean());
                    this.profilePicture_ = null;
                }
                return this.profilePictureBuilder_;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public String getPsnId() {
                Object ref = this.psnId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.psnId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder
            public ByteString getPsnIdBytes() {
                Object ref = this.psnId_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.psnId_ = b;
                return b;
            }

            public Builder setPsnId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.psnId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPsnId() {
                this.psnId_ = OnlinePlayerInfo.getDefaultInstance().getPsnId();
                onChanged();
                return this;
            }

            public Builder setPsnIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                OnlinePlayerInfo.checkByteStringIsUtf8(value);
                this.psnId_ = value;
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

        public static OnlinePlayerInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OnlinePlayerInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<OnlinePlayerInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public OnlinePlayerInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MpSettingTypeOuterClass.getDescriptor();
        ProfilePictureOuterClass.getDescriptor();
    }
}
