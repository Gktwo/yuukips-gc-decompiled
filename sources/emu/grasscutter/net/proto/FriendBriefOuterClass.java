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
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.FriendEnterHomeOptionOuterClass;
import emu.grasscutter.net.proto.FriendOnlineStateOuterClass;
import emu.grasscutter.net.proto.PlatformTypeOuterClass;
import emu.grasscutter.net.proto.ProfilePictureOuterClass;
import emu.grasscutter.net.proto.SocialShowAvatarInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javassist.bytecode.SignatureAttribute;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FriendBriefOuterClass.class */
public final class FriendBriefOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011FriendBrief.proto\u001a\u001bFriendEnterHomeOption.proto\u001a\u0017FriendOnlineState.proto\u001a\u0012PlatformType.proto\u001a\u0014ProfilePicture.proto\u001a\u001aSocialShowAvatarInfo.proto\"Þ\u0004\n\u000bFriendBrief\u0012\u000b\n\u0003uid\u0018\u0001 \u0001(\r\u0012\u0010\n\bnickname\u0018\u0002 \u0001(\t\u0012\r\n\u0005level\u0018\u0003 \u0001(\r\u0012\u0011\n\tavatar_id\u0018\u0004 \u0001(\r\u0012\u0013\n\u000bworld_level\u0018\u0005 \u0001(\r\u0012\u0011\n\tsignature\u0018\u0006 \u0001(\t\u0012(\n\fonline_state\u0018\u0007 \u0001(\u000e2\u0012.FriendOnlineState\u0012\r\n\u0005param\u0018\b \u0001(\r\u0012\u001c\n\u0014is_mp_mode_available\u0018\n \u0001(\b\u0012\u0011\n\tonline_id\u0018\u000b \u0001(\t\u0012\u0018\n\u0010last_active_time\u0018\f \u0001(\r\u0012\u0014\n\fname_card_id\u0018\r \u0001(\r\u0012\u0015\n\rmp_player_num\u0018\u000e \u0001(\r\u0012\u001a\n\u0012is_chat_no_disturb\u0018\u000f \u0001(\b\u0012\u0015\n\rchat_sequence\u0018\u0010 \u0001(\r\u0012\u0013\n\u000bremark_name\u0018\u0011 \u0001(\t\u00124\n\u0015show_avatar_info_list\u0018\u0016 \u0003(\u000b2\u0015.SocialShowAvatarInfo\u00128\n\u0018friend_enter_home_option\u0018\u0017 \u0001(\u000e2\u0016.FriendEnterHomeOption\u0012(\n\u000fprofile_picture\u0018\u0018 \u0001(\u000b2\u000f.ProfilePicture\u0012\u0016\n\u000eis_game_source\u0018\u0019 \u0001(\b\u0012\u0015\n\ris_psn_source\u0018\u001a \u0001(\b\u0012$\n\rplatform_type\u0018\u001b \u0001(\u000e2\r.PlatformTypeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FriendEnterHomeOptionOuterClass.getDescriptor(), FriendOnlineStateOuterClass.getDescriptor(), PlatformTypeOuterClass.getDescriptor(), ProfilePictureOuterClass.getDescriptor(), SocialShowAvatarInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FriendBrief_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FriendBrief_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FriendBrief_descriptor, new String[]{"Uid", "Nickname", "Level", "AvatarId", "WorldLevel", SignatureAttribute.tag, "OnlineState", "Param", "IsMpModeAvailable", "OnlineId", "LastActiveTime", "NameCardId", "MpPlayerNum", "IsChatNoDisturb", "ChatSequence", "RemarkName", "ShowAvatarInfoList", "FriendEnterHomeOption", "ProfilePicture", "IsGameSource", "IsPsnSource", "PlatformType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FriendBriefOuterClass$FriendBriefOrBuilder.class */
    public interface FriendBriefOrBuilder extends MessageOrBuilder {
        int getUid();

        String getNickname();

        ByteString getNicknameBytes();

        int getLevel();

        int getAvatarId();

        int getWorldLevel();

        String getSignature();

        ByteString getSignatureBytes();

        int getOnlineStateValue();

        FriendOnlineStateOuterClass.FriendOnlineState getOnlineState();

        int getParam();

        boolean getIsMpModeAvailable();

        String getOnlineId();

        ByteString getOnlineIdBytes();

        int getLastActiveTime();

        int getNameCardId();

        int getMpPlayerNum();

        boolean getIsChatNoDisturb();

        int getChatSequence();

        String getRemarkName();

        ByteString getRemarkNameBytes();

        List<SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo> getShowAvatarInfoListList();

        SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo getShowAvatarInfoList(int i);

        int getShowAvatarInfoListCount();

        List<? extends SocialShowAvatarInfoOuterClass.SocialShowAvatarInfoOrBuilder> getShowAvatarInfoListOrBuilderList();

        SocialShowAvatarInfoOuterClass.SocialShowAvatarInfoOrBuilder getShowAvatarInfoListOrBuilder(int i);

        int getFriendEnterHomeOptionValue();

        FriendEnterHomeOptionOuterClass.FriendEnterHomeOption getFriendEnterHomeOption();

        boolean hasProfilePicture();

        ProfilePictureOuterClass.ProfilePicture getProfilePicture();

        ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder();

        boolean getIsGameSource();

        boolean getIsPsnSource();

        int getPlatformTypeValue();

        PlatformTypeOuterClass.PlatformType getPlatformType();
    }

    private FriendBriefOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FriendBriefOuterClass$FriendBrief.class */
    public static final class FriendBrief extends GeneratedMessageV3 implements FriendBriefOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UID_FIELD_NUMBER = 1;
        private int uid_;
        public static final int NICKNAME_FIELD_NUMBER = 2;
        private volatile Object nickname_;
        public static final int LEVEL_FIELD_NUMBER = 3;
        private int level_;
        public static final int AVATAR_ID_FIELD_NUMBER = 4;
        private int avatarId_;
        public static final int WORLD_LEVEL_FIELD_NUMBER = 5;
        private int worldLevel_;
        public static final int SIGNATURE_FIELD_NUMBER = 6;
        private volatile Object signature_;
        public static final int ONLINE_STATE_FIELD_NUMBER = 7;
        private int onlineState_;
        public static final int PARAM_FIELD_NUMBER = 8;
        private int param_;
        public static final int IS_MP_MODE_AVAILABLE_FIELD_NUMBER = 10;
        private boolean isMpModeAvailable_;
        public static final int ONLINE_ID_FIELD_NUMBER = 11;
        private volatile Object onlineId_;
        public static final int LAST_ACTIVE_TIME_FIELD_NUMBER = 12;
        private int lastActiveTime_;
        public static final int NAME_CARD_ID_FIELD_NUMBER = 13;
        private int nameCardId_;
        public static final int MP_PLAYER_NUM_FIELD_NUMBER = 14;
        private int mpPlayerNum_;
        public static final int IS_CHAT_NO_DISTURB_FIELD_NUMBER = 15;
        private boolean isChatNoDisturb_;
        public static final int CHAT_SEQUENCE_FIELD_NUMBER = 16;
        private int chatSequence_;
        public static final int REMARK_NAME_FIELD_NUMBER = 17;
        private volatile Object remarkName_;
        public static final int SHOW_AVATAR_INFO_LIST_FIELD_NUMBER = 22;
        private List<SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo> showAvatarInfoList_;
        public static final int FRIEND_ENTER_HOME_OPTION_FIELD_NUMBER = 23;
        private int friendEnterHomeOption_;
        public static final int PROFILE_PICTURE_FIELD_NUMBER = 24;
        private ProfilePictureOuterClass.ProfilePicture profilePicture_;
        public static final int IS_GAME_SOURCE_FIELD_NUMBER = 25;
        private boolean isGameSource_;
        public static final int IS_PSN_SOURCE_FIELD_NUMBER = 26;
        private boolean isPsnSource_;
        public static final int PLATFORM_TYPE_FIELD_NUMBER = 27;
        private int platformType_;
        private byte memoizedIsInitialized;
        private static final FriendBrief DEFAULT_INSTANCE = new FriendBrief();
        private static final Parser<FriendBrief> PARSER = new AbstractParser<FriendBrief>() { // from class: emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBrief.1
            @Override // com.google.protobuf.Parser
            public FriendBrief parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FriendBrief(input, extensionRegistry);
            }
        };

        private FriendBrief(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FriendBrief() {
            this.memoizedIsInitialized = -1;
            this.nickname_ = "";
            this.signature_ = "";
            this.onlineState_ = 0;
            this.onlineId_ = "";
            this.remarkName_ = "";
            this.showAvatarInfoList_ = Collections.emptyList();
            this.friendEnterHomeOption_ = 0;
            this.platformType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FriendBrief();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FriendBrief(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.level_ = input.readUInt32();
                                break;
                            case 32:
                                this.avatarId_ = input.readUInt32();
                                break;
                            case 40:
                                this.worldLevel_ = input.readUInt32();
                                break;
                            case 50:
                                this.signature_ = input.readStringRequireUtf8();
                                break;
                            case 56:
                                this.onlineState_ = input.readEnum();
                                break;
                            case 64:
                                this.param_ = input.readUInt32();
                                break;
                            case 80:
                                this.isMpModeAvailable_ = input.readBool();
                                break;
                            case 90:
                                this.onlineId_ = input.readStringRequireUtf8();
                                break;
                            case 96:
                                this.lastActiveTime_ = input.readUInt32();
                                break;
                            case 104:
                                this.nameCardId_ = input.readUInt32();
                                break;
                            case 112:
                                this.mpPlayerNum_ = input.readUInt32();
                                break;
                            case 120:
                                this.isChatNoDisturb_ = input.readBool();
                                break;
                            case 128:
                                this.chatSequence_ = input.readUInt32();
                                break;
                            case 138:
                                this.remarkName_ = input.readStringRequireUtf8();
                                break;
                            case 178:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.showAvatarInfoList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.showAvatarInfoList_.add((SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo) input.readMessage(SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo.parser(), extensionRegistry));
                                break;
                            case 184:
                                this.friendEnterHomeOption_ = input.readEnum();
                                break;
                            case 194:
                                ProfilePictureOuterClass.ProfilePicture.Builder subBuilder = this.profilePicture_ != null ? this.profilePicture_.toBuilder() : null;
                                this.profilePicture_ = (ProfilePictureOuterClass.ProfilePicture) input.readMessage(ProfilePictureOuterClass.ProfilePicture.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.profilePicture_);
                                    this.profilePicture_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 200:
                                this.isGameSource_ = input.readBool();
                                break;
                            case PacketOpcodes.PlatformStartRouteNotify:
                                this.isPsnSource_ = input.readBool();
                                break;
                            case 216:
                                this.platformType_ = input.readEnum();
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
                    this.showAvatarInfoList_ = Collections.unmodifiableList(this.showAvatarInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FriendBriefOuterClass.internal_static_FriendBrief_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FriendBriefOuterClass.internal_static_FriendBrief_fieldAccessorTable.ensureFieldAccessorsInitialized(FriendBrief.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public String getNickname() {
            Object ref = this.nickname_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.nickname_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public ByteString getNicknameBytes() {
            Object ref = this.nickname_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.nickname_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public int getAvatarId() {
            return this.avatarId_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public int getWorldLevel() {
            return this.worldLevel_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public String getSignature() {
            Object ref = this.signature_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.signature_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public ByteString getSignatureBytes() {
            Object ref = this.signature_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.signature_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public int getOnlineStateValue() {
            return this.onlineState_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public FriendOnlineStateOuterClass.FriendOnlineState getOnlineState() {
            FriendOnlineStateOuterClass.FriendOnlineState result = FriendOnlineStateOuterClass.FriendOnlineState.valueOf(this.onlineState_);
            return result == null ? FriendOnlineStateOuterClass.FriendOnlineState.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public int getParam() {
            return this.param_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public boolean getIsMpModeAvailable() {
            return this.isMpModeAvailable_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public String getOnlineId() {
            Object ref = this.onlineId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.onlineId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public ByteString getOnlineIdBytes() {
            Object ref = this.onlineId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.onlineId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public int getLastActiveTime() {
            return this.lastActiveTime_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public int getNameCardId() {
            return this.nameCardId_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public int getMpPlayerNum() {
            return this.mpPlayerNum_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public boolean getIsChatNoDisturb() {
            return this.isChatNoDisturb_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public int getChatSequence() {
            return this.chatSequence_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public String getRemarkName() {
            Object ref = this.remarkName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.remarkName_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public ByteString getRemarkNameBytes() {
            Object ref = this.remarkName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.remarkName_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public List<SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo> getShowAvatarInfoListList() {
            return this.showAvatarInfoList_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public List<? extends SocialShowAvatarInfoOuterClass.SocialShowAvatarInfoOrBuilder> getShowAvatarInfoListOrBuilderList() {
            return this.showAvatarInfoList_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public int getShowAvatarInfoListCount() {
            return this.showAvatarInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo getShowAvatarInfoList(int index) {
            return this.showAvatarInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public SocialShowAvatarInfoOuterClass.SocialShowAvatarInfoOrBuilder getShowAvatarInfoListOrBuilder(int index) {
            return this.showAvatarInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public int getFriendEnterHomeOptionValue() {
            return this.friendEnterHomeOption_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public FriendEnterHomeOptionOuterClass.FriendEnterHomeOption getFriendEnterHomeOption() {
            FriendEnterHomeOptionOuterClass.FriendEnterHomeOption result = FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.valueOf(this.friendEnterHomeOption_);
            return result == null ? FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public boolean hasProfilePicture() {
            return this.profilePicture_ != null;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public ProfilePictureOuterClass.ProfilePicture getProfilePicture() {
            return this.profilePicture_ == null ? ProfilePictureOuterClass.ProfilePicture.getDefaultInstance() : this.profilePicture_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder() {
            return getProfilePicture();
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public boolean getIsGameSource() {
            return this.isGameSource_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public boolean getIsPsnSource() {
            return this.isPsnSource_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public int getPlatformTypeValue() {
            return this.platformType_;
        }

        @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
        public PlatformTypeOuterClass.PlatformType getPlatformType() {
            PlatformTypeOuterClass.PlatformType result = PlatformTypeOuterClass.PlatformType.valueOf(this.platformType_);
            return result == null ? PlatformTypeOuterClass.PlatformType.UNRECOGNIZED : result;
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
            if (this.uid_ != 0) {
                output.writeUInt32(1, this.uid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.nickname_)) {
                GeneratedMessageV3.writeString(output, 2, this.nickname_);
            }
            if (this.level_ != 0) {
                output.writeUInt32(3, this.level_);
            }
            if (this.avatarId_ != 0) {
                output.writeUInt32(4, this.avatarId_);
            }
            if (this.worldLevel_ != 0) {
                output.writeUInt32(5, this.worldLevel_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.signature_)) {
                GeneratedMessageV3.writeString(output, 6, this.signature_);
            }
            if (this.onlineState_ != FriendOnlineStateOuterClass.FriendOnlineState.FRIEND_ONLINE_STATE_DISCONNECT.getNumber()) {
                output.writeEnum(7, this.onlineState_);
            }
            if (this.param_ != 0) {
                output.writeUInt32(8, this.param_);
            }
            if (this.isMpModeAvailable_) {
                output.writeBool(10, this.isMpModeAvailable_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.onlineId_)) {
                GeneratedMessageV3.writeString(output, 11, this.onlineId_);
            }
            if (this.lastActiveTime_ != 0) {
                output.writeUInt32(12, this.lastActiveTime_);
            }
            if (this.nameCardId_ != 0) {
                output.writeUInt32(13, this.nameCardId_);
            }
            if (this.mpPlayerNum_ != 0) {
                output.writeUInt32(14, this.mpPlayerNum_);
            }
            if (this.isChatNoDisturb_) {
                output.writeBool(15, this.isChatNoDisturb_);
            }
            if (this.chatSequence_ != 0) {
                output.writeUInt32(16, this.chatSequence_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.remarkName_)) {
                GeneratedMessageV3.writeString(output, 17, this.remarkName_);
            }
            for (int i = 0; i < this.showAvatarInfoList_.size(); i++) {
                output.writeMessage(22, this.showAvatarInfoList_.get(i));
            }
            if (this.friendEnterHomeOption_ != FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.FRIEND_ENTER_HOME_OPTION_NEED_CONFIRM.getNumber()) {
                output.writeEnum(23, this.friendEnterHomeOption_);
            }
            if (this.profilePicture_ != null) {
                output.writeMessage(24, getProfilePicture());
            }
            if (this.isGameSource_) {
                output.writeBool(25, this.isGameSource_);
            }
            if (this.isPsnSource_) {
                output.writeBool(26, this.isPsnSource_);
            }
            if (this.platformType_ != PlatformTypeOuterClass.PlatformType.PLATFORM_TYPE_EDITOR.getNumber()) {
                output.writeEnum(27, this.platformType_);
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
            if (this.level_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.level_);
            }
            if (this.avatarId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.avatarId_);
            }
            if (this.worldLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.worldLevel_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.signature_)) {
                size2 += GeneratedMessageV3.computeStringSize(6, this.signature_);
            }
            if (this.onlineState_ != FriendOnlineStateOuterClass.FriendOnlineState.FRIEND_ONLINE_STATE_DISCONNECT.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(7, this.onlineState_);
            }
            if (this.param_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.param_);
            }
            if (this.isMpModeAvailable_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.isMpModeAvailable_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.onlineId_)) {
                size2 += GeneratedMessageV3.computeStringSize(11, this.onlineId_);
            }
            if (this.lastActiveTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.lastActiveTime_);
            }
            if (this.nameCardId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.nameCardId_);
            }
            if (this.mpPlayerNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.mpPlayerNum_);
            }
            if (this.isChatNoDisturb_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.isChatNoDisturb_);
            }
            if (this.chatSequence_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(16, this.chatSequence_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.remarkName_)) {
                size2 += GeneratedMessageV3.computeStringSize(17, this.remarkName_);
            }
            for (int i = 0; i < this.showAvatarInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(22, this.showAvatarInfoList_.get(i));
            }
            if (this.friendEnterHomeOption_ != FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.FRIEND_ENTER_HOME_OPTION_NEED_CONFIRM.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(23, this.friendEnterHomeOption_);
            }
            if (this.profilePicture_ != null) {
                size2 += CodedOutputStream.computeMessageSize(24, getProfilePicture());
            }
            if (this.isGameSource_) {
                size2 += CodedOutputStream.computeBoolSize(25, this.isGameSource_);
            }
            if (this.isPsnSource_) {
                size2 += CodedOutputStream.computeBoolSize(26, this.isPsnSource_);
            }
            if (this.platformType_ != PlatformTypeOuterClass.PlatformType.PLATFORM_TYPE_EDITOR.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(27, this.platformType_);
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
            if (!(obj instanceof FriendBrief)) {
                return equals(obj);
            }
            FriendBrief other = (FriendBrief) obj;
            if (getUid() == other.getUid() && getNickname().equals(other.getNickname()) && getLevel() == other.getLevel() && getAvatarId() == other.getAvatarId() && getWorldLevel() == other.getWorldLevel() && getSignature().equals(other.getSignature()) && this.onlineState_ == other.onlineState_ && getParam() == other.getParam() && getIsMpModeAvailable() == other.getIsMpModeAvailable() && getOnlineId().equals(other.getOnlineId()) && getLastActiveTime() == other.getLastActiveTime() && getNameCardId() == other.getNameCardId() && getMpPlayerNum() == other.getMpPlayerNum() && getIsChatNoDisturb() == other.getIsChatNoDisturb() && getChatSequence() == other.getChatSequence() && getRemarkName().equals(other.getRemarkName()) && getShowAvatarInfoListList().equals(other.getShowAvatarInfoListList()) && this.friendEnterHomeOption_ == other.friendEnterHomeOption_ && hasProfilePicture() == other.hasProfilePicture()) {
                return (!hasProfilePicture() || getProfilePicture().equals(other.getProfilePicture())) && getIsGameSource() == other.getIsGameSource() && getIsPsnSource() == other.getIsPsnSource() && this.platformType_ == other.platformType_ && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getUid())) + 2)) + getNickname().hashCode())) + 3)) + getLevel())) + 4)) + getAvatarId())) + 5)) + getWorldLevel())) + 6)) + getSignature().hashCode())) + 7)) + this.onlineState_)) + 8)) + getParam())) + 10)) + Internal.hashBoolean(getIsMpModeAvailable()))) + 11)) + getOnlineId().hashCode())) + 12)) + getLastActiveTime())) + 13)) + getNameCardId())) + 14)) + getMpPlayerNum())) + 15)) + Internal.hashBoolean(getIsChatNoDisturb()))) + 16)) + getChatSequence())) + 17)) + getRemarkName().hashCode();
            if (getShowAvatarInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 22)) + getShowAvatarInfoListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 23)) + this.friendEnterHomeOption_;
            if (hasProfilePicture()) {
                hash2 = (53 * ((37 * hash2) + 24)) + getProfilePicture().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 25)) + Internal.hashBoolean(getIsGameSource()))) + 26)) + Internal.hashBoolean(getIsPsnSource()))) + 27)) + this.platformType_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static FriendBrief parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FriendBrief parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FriendBrief parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FriendBrief parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FriendBrief parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FriendBrief parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FriendBrief parseFrom(InputStream input) throws IOException {
            return (FriendBrief) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FriendBrief parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FriendBrief) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FriendBrief parseDelimitedFrom(InputStream input) throws IOException {
            return (FriendBrief) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FriendBrief parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FriendBrief) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FriendBrief parseFrom(CodedInputStream input) throws IOException {
            return (FriendBrief) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FriendBrief parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FriendBrief) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FriendBrief prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FriendBriefOuterClass$FriendBrief$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FriendBriefOrBuilder {
            private int bitField0_;
            private int uid_;
            private int level_;
            private int avatarId_;
            private int worldLevel_;
            private int param_;
            private boolean isMpModeAvailable_;
            private int lastActiveTime_;
            private int nameCardId_;
            private int mpPlayerNum_;
            private boolean isChatNoDisturb_;
            private int chatSequence_;
            private RepeatedFieldBuilderV3<SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo, SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo.Builder, SocialShowAvatarInfoOuterClass.SocialShowAvatarInfoOrBuilder> showAvatarInfoListBuilder_;
            private ProfilePictureOuterClass.ProfilePicture profilePicture_;
            private SingleFieldBuilderV3<ProfilePictureOuterClass.ProfilePicture, ProfilePictureOuterClass.ProfilePicture.Builder, ProfilePictureOuterClass.ProfilePictureOrBuilder> profilePictureBuilder_;
            private boolean isGameSource_;
            private boolean isPsnSource_;
            private Object nickname_ = "";
            private Object signature_ = "";
            private int onlineState_ = 0;
            private Object onlineId_ = "";
            private Object remarkName_ = "";
            private List<SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo> showAvatarInfoList_ = Collections.emptyList();
            private int friendEnterHomeOption_ = 0;
            private int platformType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return FriendBriefOuterClass.internal_static_FriendBrief_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FriendBriefOuterClass.internal_static_FriendBrief_fieldAccessorTable.ensureFieldAccessorsInitialized(FriendBrief.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FriendBrief.alwaysUseFieldBuilders) {
                    getShowAvatarInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.uid_ = 0;
                this.nickname_ = "";
                this.level_ = 0;
                this.avatarId_ = 0;
                this.worldLevel_ = 0;
                this.signature_ = "";
                this.onlineState_ = 0;
                this.param_ = 0;
                this.isMpModeAvailable_ = false;
                this.onlineId_ = "";
                this.lastActiveTime_ = 0;
                this.nameCardId_ = 0;
                this.mpPlayerNum_ = 0;
                this.isChatNoDisturb_ = false;
                this.chatSequence_ = 0;
                this.remarkName_ = "";
                if (this.showAvatarInfoListBuilder_ == null) {
                    this.showAvatarInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.showAvatarInfoListBuilder_.clear();
                }
                this.friendEnterHomeOption_ = 0;
                if (this.profilePictureBuilder_ == null) {
                    this.profilePicture_ = null;
                } else {
                    this.profilePicture_ = null;
                    this.profilePictureBuilder_ = null;
                }
                this.isGameSource_ = false;
                this.isPsnSource_ = false;
                this.platformType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FriendBriefOuterClass.internal_static_FriendBrief_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FriendBrief getDefaultInstanceForType() {
                return FriendBrief.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FriendBrief build() {
                FriendBrief result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FriendBrief buildPartial() {
                FriendBrief result = new FriendBrief(this);
                int i = this.bitField0_;
                result.uid_ = this.uid_;
                result.nickname_ = this.nickname_;
                result.level_ = this.level_;
                result.avatarId_ = this.avatarId_;
                result.worldLevel_ = this.worldLevel_;
                result.signature_ = this.signature_;
                result.onlineState_ = this.onlineState_;
                result.param_ = this.param_;
                result.isMpModeAvailable_ = this.isMpModeAvailable_;
                result.onlineId_ = this.onlineId_;
                result.lastActiveTime_ = this.lastActiveTime_;
                result.nameCardId_ = this.nameCardId_;
                result.mpPlayerNum_ = this.mpPlayerNum_;
                result.isChatNoDisturb_ = this.isChatNoDisturb_;
                result.chatSequence_ = this.chatSequence_;
                result.remarkName_ = this.remarkName_;
                if (this.showAvatarInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.showAvatarInfoList_ = Collections.unmodifiableList(this.showAvatarInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.showAvatarInfoList_ = this.showAvatarInfoList_;
                } else {
                    result.showAvatarInfoList_ = this.showAvatarInfoListBuilder_.build();
                }
                result.friendEnterHomeOption_ = this.friendEnterHomeOption_;
                if (this.profilePictureBuilder_ == null) {
                    result.profilePicture_ = this.profilePicture_;
                } else {
                    result.profilePicture_ = this.profilePictureBuilder_.build();
                }
                result.isGameSource_ = this.isGameSource_;
                result.isPsnSource_ = this.isPsnSource_;
                result.platformType_ = this.platformType_;
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
                if (other instanceof FriendBrief) {
                    return mergeFrom((FriendBrief) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FriendBrief other) {
                if (other == FriendBrief.getDefaultInstance()) {
                    return this;
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (!other.getNickname().isEmpty()) {
                    this.nickname_ = other.nickname_;
                    onChanged();
                }
                if (other.getLevel() != 0) {
                    setLevel(other.getLevel());
                }
                if (other.getAvatarId() != 0) {
                    setAvatarId(other.getAvatarId());
                }
                if (other.getWorldLevel() != 0) {
                    setWorldLevel(other.getWorldLevel());
                }
                if (!other.getSignature().isEmpty()) {
                    this.signature_ = other.signature_;
                    onChanged();
                }
                if (other.onlineState_ != 0) {
                    setOnlineStateValue(other.getOnlineStateValue());
                }
                if (other.getParam() != 0) {
                    setParam(other.getParam());
                }
                if (other.getIsMpModeAvailable()) {
                    setIsMpModeAvailable(other.getIsMpModeAvailable());
                }
                if (!other.getOnlineId().isEmpty()) {
                    this.onlineId_ = other.onlineId_;
                    onChanged();
                }
                if (other.getLastActiveTime() != 0) {
                    setLastActiveTime(other.getLastActiveTime());
                }
                if (other.getNameCardId() != 0) {
                    setNameCardId(other.getNameCardId());
                }
                if (other.getMpPlayerNum() != 0) {
                    setMpPlayerNum(other.getMpPlayerNum());
                }
                if (other.getIsChatNoDisturb()) {
                    setIsChatNoDisturb(other.getIsChatNoDisturb());
                }
                if (other.getChatSequence() != 0) {
                    setChatSequence(other.getChatSequence());
                }
                if (!other.getRemarkName().isEmpty()) {
                    this.remarkName_ = other.remarkName_;
                    onChanged();
                }
                if (this.showAvatarInfoListBuilder_ == null) {
                    if (!other.showAvatarInfoList_.isEmpty()) {
                        if (this.showAvatarInfoList_.isEmpty()) {
                            this.showAvatarInfoList_ = other.showAvatarInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureShowAvatarInfoListIsMutable();
                            this.showAvatarInfoList_.addAll(other.showAvatarInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.showAvatarInfoList_.isEmpty()) {
                    if (this.showAvatarInfoListBuilder_.isEmpty()) {
                        this.showAvatarInfoListBuilder_.dispose();
                        this.showAvatarInfoListBuilder_ = null;
                        this.showAvatarInfoList_ = other.showAvatarInfoList_;
                        this.bitField0_ &= -2;
                        this.showAvatarInfoListBuilder_ = FriendBrief.alwaysUseFieldBuilders ? getShowAvatarInfoListFieldBuilder() : null;
                    } else {
                        this.showAvatarInfoListBuilder_.addAllMessages(other.showAvatarInfoList_);
                    }
                }
                if (other.friendEnterHomeOption_ != 0) {
                    setFriendEnterHomeOptionValue(other.getFriendEnterHomeOptionValue());
                }
                if (other.hasProfilePicture()) {
                    mergeProfilePicture(other.getProfilePicture());
                }
                if (other.getIsGameSource()) {
                    setIsGameSource(other.getIsGameSource());
                }
                if (other.getIsPsnSource()) {
                    setIsPsnSource(other.getIsPsnSource());
                }
                if (other.platformType_ != 0) {
                    setPlatformTypeValue(other.getPlatformTypeValue());
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
                FriendBrief parsedMessage = null;
                try {
                    try {
                        parsedMessage = FriendBrief.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FriendBrief) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
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

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public String getNickname() {
                Object ref = this.nickname_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.nickname_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
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
                this.nickname_ = FriendBrief.getDefaultInstance().getNickname();
                onChanged();
                return this;
            }

            public Builder setNicknameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                FriendBrief.checkByteStringIsUtf8(value);
                this.nickname_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
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

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
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

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
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

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public String getSignature() {
                Object ref = this.signature_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.signature_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
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
                this.signature_ = FriendBrief.getDefaultInstance().getSignature();
                onChanged();
                return this;
            }

            public Builder setSignatureBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                FriendBrief.checkByteStringIsUtf8(value);
                this.signature_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public int getOnlineStateValue() {
                return this.onlineState_;
            }

            public Builder setOnlineStateValue(int value) {
                this.onlineState_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public FriendOnlineStateOuterClass.FriendOnlineState getOnlineState() {
                FriendOnlineStateOuterClass.FriendOnlineState result = FriendOnlineStateOuterClass.FriendOnlineState.valueOf(this.onlineState_);
                return result == null ? FriendOnlineStateOuterClass.FriendOnlineState.UNRECOGNIZED : result;
            }

            public Builder setOnlineState(FriendOnlineStateOuterClass.FriendOnlineState value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.onlineState_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearOnlineState() {
                this.onlineState_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public int getParam() {
                return this.param_;
            }

            public Builder setParam(int value) {
                this.param_ = value;
                onChanged();
                return this;
            }

            public Builder clearParam() {
                this.param_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public boolean getIsMpModeAvailable() {
                return this.isMpModeAvailable_;
            }

            public Builder setIsMpModeAvailable(boolean value) {
                this.isMpModeAvailable_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsMpModeAvailable() {
                this.isMpModeAvailable_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public String getOnlineId() {
                Object ref = this.onlineId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.onlineId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
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
                this.onlineId_ = FriendBrief.getDefaultInstance().getOnlineId();
                onChanged();
                return this;
            }

            public Builder setOnlineIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                FriendBrief.checkByteStringIsUtf8(value);
                this.onlineId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public int getLastActiveTime() {
                return this.lastActiveTime_;
            }

            public Builder setLastActiveTime(int value) {
                this.lastActiveTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearLastActiveTime() {
                this.lastActiveTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
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

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public int getMpPlayerNum() {
                return this.mpPlayerNum_;
            }

            public Builder setMpPlayerNum(int value) {
                this.mpPlayerNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearMpPlayerNum() {
                this.mpPlayerNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public boolean getIsChatNoDisturb() {
                return this.isChatNoDisturb_;
            }

            public Builder setIsChatNoDisturb(boolean value) {
                this.isChatNoDisturb_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsChatNoDisturb() {
                this.isChatNoDisturb_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public int getChatSequence() {
                return this.chatSequence_;
            }

            public Builder setChatSequence(int value) {
                this.chatSequence_ = value;
                onChanged();
                return this;
            }

            public Builder clearChatSequence() {
                this.chatSequence_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public String getRemarkName() {
                Object ref = this.remarkName_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.remarkName_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public ByteString getRemarkNameBytes() {
                Object ref = this.remarkName_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.remarkName_ = b;
                return b;
            }

            public Builder setRemarkName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.remarkName_ = value;
                onChanged();
                return this;
            }

            public Builder clearRemarkName() {
                this.remarkName_ = FriendBrief.getDefaultInstance().getRemarkName();
                onChanged();
                return this;
            }

            public Builder setRemarkNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                FriendBrief.checkByteStringIsUtf8(value);
                this.remarkName_ = value;
                onChanged();
                return this;
            }

            private void ensureShowAvatarInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.showAvatarInfoList_ = new ArrayList(this.showAvatarInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public List<SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo> getShowAvatarInfoListList() {
                if (this.showAvatarInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.showAvatarInfoList_);
                }
                return this.showAvatarInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public int getShowAvatarInfoListCount() {
                if (this.showAvatarInfoListBuilder_ == null) {
                    return this.showAvatarInfoList_.size();
                }
                return this.showAvatarInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo getShowAvatarInfoList(int index) {
                if (this.showAvatarInfoListBuilder_ == null) {
                    return this.showAvatarInfoList_.get(index);
                }
                return this.showAvatarInfoListBuilder_.getMessage(index);
            }

            public Builder setShowAvatarInfoList(int index, SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo value) {
                if (this.showAvatarInfoListBuilder_ != null) {
                    this.showAvatarInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureShowAvatarInfoListIsMutable();
                    this.showAvatarInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setShowAvatarInfoList(int index, SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo.Builder builderForValue) {
                if (this.showAvatarInfoListBuilder_ == null) {
                    ensureShowAvatarInfoListIsMutable();
                    this.showAvatarInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.showAvatarInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addShowAvatarInfoList(SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo value) {
                if (this.showAvatarInfoListBuilder_ != null) {
                    this.showAvatarInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureShowAvatarInfoListIsMutable();
                    this.showAvatarInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addShowAvatarInfoList(int index, SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo value) {
                if (this.showAvatarInfoListBuilder_ != null) {
                    this.showAvatarInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureShowAvatarInfoListIsMutable();
                    this.showAvatarInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addShowAvatarInfoList(SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo.Builder builderForValue) {
                if (this.showAvatarInfoListBuilder_ == null) {
                    ensureShowAvatarInfoListIsMutable();
                    this.showAvatarInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.showAvatarInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addShowAvatarInfoList(int index, SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo.Builder builderForValue) {
                if (this.showAvatarInfoListBuilder_ == null) {
                    ensureShowAvatarInfoListIsMutable();
                    this.showAvatarInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.showAvatarInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllShowAvatarInfoList(Iterable<? extends SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo> values) {
                if (this.showAvatarInfoListBuilder_ == null) {
                    ensureShowAvatarInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.showAvatarInfoList_);
                    onChanged();
                } else {
                    this.showAvatarInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearShowAvatarInfoList() {
                if (this.showAvatarInfoListBuilder_ == null) {
                    this.showAvatarInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.showAvatarInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeShowAvatarInfoList(int index) {
                if (this.showAvatarInfoListBuilder_ == null) {
                    ensureShowAvatarInfoListIsMutable();
                    this.showAvatarInfoList_.remove(index);
                    onChanged();
                } else {
                    this.showAvatarInfoListBuilder_.remove(index);
                }
                return this;
            }

            public SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo.Builder getShowAvatarInfoListBuilder(int index) {
                return getShowAvatarInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public SocialShowAvatarInfoOuterClass.SocialShowAvatarInfoOrBuilder getShowAvatarInfoListOrBuilder(int index) {
                if (this.showAvatarInfoListBuilder_ == null) {
                    return this.showAvatarInfoList_.get(index);
                }
                return this.showAvatarInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public List<? extends SocialShowAvatarInfoOuterClass.SocialShowAvatarInfoOrBuilder> getShowAvatarInfoListOrBuilderList() {
                if (this.showAvatarInfoListBuilder_ != null) {
                    return this.showAvatarInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.showAvatarInfoList_);
            }

            public SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo.Builder addShowAvatarInfoListBuilder() {
                return getShowAvatarInfoListFieldBuilder().addBuilder(SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo.getDefaultInstance());
            }

            public SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo.Builder addShowAvatarInfoListBuilder(int index) {
                return getShowAvatarInfoListFieldBuilder().addBuilder(index, SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo.getDefaultInstance());
            }

            public List<SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo.Builder> getShowAvatarInfoListBuilderList() {
                return getShowAvatarInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo, SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo.Builder, SocialShowAvatarInfoOuterClass.SocialShowAvatarInfoOrBuilder> getShowAvatarInfoListFieldBuilder() {
                if (this.showAvatarInfoListBuilder_ == null) {
                    this.showAvatarInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.showAvatarInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.showAvatarInfoList_ = null;
                }
                return this.showAvatarInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public int getFriendEnterHomeOptionValue() {
                return this.friendEnterHomeOption_;
            }

            public Builder setFriendEnterHomeOptionValue(int value) {
                this.friendEnterHomeOption_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public FriendEnterHomeOptionOuterClass.FriendEnterHomeOption getFriendEnterHomeOption() {
                FriendEnterHomeOptionOuterClass.FriendEnterHomeOption result = FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.valueOf(this.friendEnterHomeOption_);
                return result == null ? FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.UNRECOGNIZED : result;
            }

            public Builder setFriendEnterHomeOption(FriendEnterHomeOptionOuterClass.FriendEnterHomeOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.friendEnterHomeOption_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearFriendEnterHomeOption() {
                this.friendEnterHomeOption_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public boolean hasProfilePicture() {
                return (this.profilePictureBuilder_ == null && this.profilePicture_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
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

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
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

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public boolean getIsGameSource() {
                return this.isGameSource_;
            }

            public Builder setIsGameSource(boolean value) {
                this.isGameSource_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsGameSource() {
                this.isGameSource_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public boolean getIsPsnSource() {
                return this.isPsnSource_;
            }

            public Builder setIsPsnSource(boolean value) {
                this.isPsnSource_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsPsnSource() {
                this.isPsnSource_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public int getPlatformTypeValue() {
                return this.platformType_;
            }

            public Builder setPlatformTypeValue(int value) {
                this.platformType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FriendBriefOuterClass.FriendBriefOrBuilder
            public PlatformTypeOuterClass.PlatformType getPlatformType() {
                PlatformTypeOuterClass.PlatformType result = PlatformTypeOuterClass.PlatformType.valueOf(this.platformType_);
                return result == null ? PlatformTypeOuterClass.PlatformType.UNRECOGNIZED : result;
            }

            public Builder setPlatformType(PlatformTypeOuterClass.PlatformType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.platformType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearPlatformType() {
                this.platformType_ = 0;
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

        public static FriendBrief getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FriendBrief> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FriendBrief> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FriendBrief getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FriendEnterHomeOptionOuterClass.getDescriptor();
        FriendOnlineStateOuterClass.getDescriptor();
        PlatformTypeOuterClass.getDescriptor();
        ProfilePictureOuterClass.getDescriptor();
        SocialShowAvatarInfoOuterClass.getDescriptor();
    }
}
