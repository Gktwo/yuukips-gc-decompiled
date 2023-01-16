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
import emu.grasscutter.net.proto.BirthdayOuterClass;
import emu.grasscutter.net.proto.FriendEnterHomeOptionOuterClass;
import emu.grasscutter.net.proto.FriendOnlineStateOuterClass;
import emu.grasscutter.net.proto.ProfilePictureOuterClass;
import emu.grasscutter.net.proto.SocialShowAvatarInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javassist.bytecode.SignatureAttribute;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SocialDetailOuterClass.class */
public final class SocialDetailOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012SocialDetail.proto\u001a\u000eBirthday.proto\u001a\u001bFriendEnterHomeOption.proto\u001a\u0017FriendOnlineState.proto\u001a\u0014ProfilePicture.proto\u001a\u001aSocialShowAvatarInfo.proto\"°\u0005\n\fSocialDetail\u0012\u000b\n\u0003uid\u0018\u0001 \u0001(\r\u0012\u0010\n\bnickname\u0018\u0002 \u0001(\t\u0012\r\n\u0005level\u0018\u0003 \u0001(\r\u0012\u0011\n\tavatar_id\u0018\u0004 \u0001(\r\u0012\u0011\n\tsignature\u0018\u0005 \u0001(\t\u0012\u001b\n\bbirthday\u0018\u0006 \u0001(\u000b2\t.Birthday\u0012\u0013\n\u000bworld_level\u0018\u0007 \u0001(\r\u0012\u0015\n\rreserved_list\u0018\b \u0003(\r\u0012(\n\fonline_state\u0018\t \u0001(\u000e2\u0012.FriendOnlineState\u0012\r\n\u0005param\u0018\n \u0001(\r\u0012\u0011\n\tis_friend\u0018\u000b \u0001(\b\u0012\u001c\n\u0014is_mp_mode_available\u0018\f \u0001(\b\u0012\u0011\n\tonline_id\u0018\r \u0001(\t\u0012\u0014\n\fname_card_id\u0018\u000e \u0001(\r\u0012\u0017\n\u000fis_in_blacklist\u0018\u000f \u0001(\b\u0012\u001a\n\u0012is_chat_no_disturb\u0018\u0010 \u0001(\b\u0012\u0013\n\u000bremark_name\u0018\u0011 \u0001(\t\u0012\u001e\n\u0016finish_achievement_num\u0018\u0012 \u0001(\r\u0012\u0019\n\u0011tower_floor_index\u0018\u0013 \u0001(\r\u0012\u0019\n\u0011tower_level_index\u0018\u0014 \u0001(\r\u0012\u0016\n\u000eis_show_avatar\u0018\u0015 \u0001(\b\u00124\n\u0015show_avatar_info_list\u0018\u0016 \u0003(\u000b2\u0015.SocialShowAvatarInfo\u0012\u001e\n\u0016show_name_card_id_list\u0018\u0017 \u0003(\r\u00128\n\u0018friend_enter_home_option\u0018\u0018 \u0001(\u000e2\u0016.FriendEnterHomeOption\u0012(\n\u000fprofile_picture\u0018\u0019 \u0001(\u000b2\u000f.ProfilePictureB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BirthdayOuterClass.getDescriptor(), FriendEnterHomeOptionOuterClass.getDescriptor(), FriendOnlineStateOuterClass.getDescriptor(), ProfilePictureOuterClass.getDescriptor(), SocialShowAvatarInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SocialDetail_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SocialDetail_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SocialDetail_descriptor, new String[]{"Uid", "Nickname", "Level", "AvatarId", SignatureAttribute.tag, "Birthday", "WorldLevel", "ReservedList", "OnlineState", "Param", "IsFriend", "IsMpModeAvailable", "OnlineId", "NameCardId", "IsInBlacklist", "IsChatNoDisturb", "RemarkName", "FinishAchievementNum", "TowerFloorIndex", "TowerLevelIndex", "IsShowAvatar", "ShowAvatarInfoList", "ShowNameCardIdList", "FriendEnterHomeOption", "ProfilePicture"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SocialDetailOuterClass$SocialDetailOrBuilder.class */
    public interface SocialDetailOrBuilder extends MessageOrBuilder {
        int getUid();

        String getNickname();

        ByteString getNicknameBytes();

        int getLevel();

        int getAvatarId();

        String getSignature();

        ByteString getSignatureBytes();

        boolean hasBirthday();

        BirthdayOuterClass.Birthday getBirthday();

        BirthdayOuterClass.BirthdayOrBuilder getBirthdayOrBuilder();

        int getWorldLevel();

        List<Integer> getReservedListList();

        int getReservedListCount();

        int getReservedList(int i);

        int getOnlineStateValue();

        FriendOnlineStateOuterClass.FriendOnlineState getOnlineState();

        int getParam();

        boolean getIsFriend();

        boolean getIsMpModeAvailable();

        String getOnlineId();

        ByteString getOnlineIdBytes();

        int getNameCardId();

        boolean getIsInBlacklist();

        boolean getIsChatNoDisturb();

        String getRemarkName();

        ByteString getRemarkNameBytes();

        int getFinishAchievementNum();

        int getTowerFloorIndex();

        int getTowerLevelIndex();

        boolean getIsShowAvatar();

        List<SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo> getShowAvatarInfoListList();

        SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo getShowAvatarInfoList(int i);

        int getShowAvatarInfoListCount();

        List<? extends SocialShowAvatarInfoOuterClass.SocialShowAvatarInfoOrBuilder> getShowAvatarInfoListOrBuilderList();

        SocialShowAvatarInfoOuterClass.SocialShowAvatarInfoOrBuilder getShowAvatarInfoListOrBuilder(int i);

        List<Integer> getShowNameCardIdListList();

        int getShowNameCardIdListCount();

        int getShowNameCardIdList(int i);

        int getFriendEnterHomeOptionValue();

        FriendEnterHomeOptionOuterClass.FriendEnterHomeOption getFriendEnterHomeOption();

        boolean hasProfilePicture();

        ProfilePictureOuterClass.ProfilePicture getProfilePicture();

        ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder();
    }

    private SocialDetailOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SocialDetailOuterClass$SocialDetail.class */
    public static final class SocialDetail extends GeneratedMessageV3 implements SocialDetailOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UID_FIELD_NUMBER = 1;
        private int uid_;
        public static final int NICKNAME_FIELD_NUMBER = 2;
        private volatile Object nickname_;
        public static final int LEVEL_FIELD_NUMBER = 3;
        private int level_;
        public static final int AVATAR_ID_FIELD_NUMBER = 4;
        private int avatarId_;
        public static final int SIGNATURE_FIELD_NUMBER = 5;
        private volatile Object signature_;
        public static final int BIRTHDAY_FIELD_NUMBER = 6;
        private BirthdayOuterClass.Birthday birthday_;
        public static final int WORLD_LEVEL_FIELD_NUMBER = 7;
        private int worldLevel_;
        public static final int RESERVED_LIST_FIELD_NUMBER = 8;
        private Internal.IntList reservedList_;
        private int reservedListMemoizedSerializedSize;
        public static final int ONLINE_STATE_FIELD_NUMBER = 9;
        private int onlineState_;
        public static final int PARAM_FIELD_NUMBER = 10;
        private int param_;
        public static final int IS_FRIEND_FIELD_NUMBER = 11;
        private boolean isFriend_;
        public static final int IS_MP_MODE_AVAILABLE_FIELD_NUMBER = 12;
        private boolean isMpModeAvailable_;
        public static final int ONLINE_ID_FIELD_NUMBER = 13;
        private volatile Object onlineId_;
        public static final int NAME_CARD_ID_FIELD_NUMBER = 14;
        private int nameCardId_;
        public static final int IS_IN_BLACKLIST_FIELD_NUMBER = 15;
        private boolean isInBlacklist_;
        public static final int IS_CHAT_NO_DISTURB_FIELD_NUMBER = 16;
        private boolean isChatNoDisturb_;
        public static final int REMARK_NAME_FIELD_NUMBER = 17;
        private volatile Object remarkName_;
        public static final int FINISH_ACHIEVEMENT_NUM_FIELD_NUMBER = 18;
        private int finishAchievementNum_;
        public static final int TOWER_FLOOR_INDEX_FIELD_NUMBER = 19;
        private int towerFloorIndex_;
        public static final int TOWER_LEVEL_INDEX_FIELD_NUMBER = 20;
        private int towerLevelIndex_;
        public static final int IS_SHOW_AVATAR_FIELD_NUMBER = 21;
        private boolean isShowAvatar_;
        public static final int SHOW_AVATAR_INFO_LIST_FIELD_NUMBER = 22;
        private List<SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo> showAvatarInfoList_;
        public static final int SHOW_NAME_CARD_ID_LIST_FIELD_NUMBER = 23;
        private Internal.IntList showNameCardIdList_;
        private int showNameCardIdListMemoizedSerializedSize;
        public static final int FRIEND_ENTER_HOME_OPTION_FIELD_NUMBER = 24;
        private int friendEnterHomeOption_;
        public static final int PROFILE_PICTURE_FIELD_NUMBER = 25;
        private ProfilePictureOuterClass.ProfilePicture profilePicture_;
        private byte memoizedIsInitialized;
        private static final SocialDetail DEFAULT_INSTANCE = new SocialDetail();
        private static final Parser<SocialDetail> PARSER = new AbstractParser<SocialDetail>() { // from class: emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetail.1
            @Override // com.google.protobuf.Parser
            public SocialDetail parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SocialDetail(input, extensionRegistry);
            }
        };

        private SocialDetail(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.reservedListMemoizedSerializedSize = -1;
            this.showNameCardIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private SocialDetail() {
            this.reservedListMemoizedSerializedSize = -1;
            this.showNameCardIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.nickname_ = "";
            this.signature_ = "";
            this.reservedList_ = emptyIntList();
            this.onlineState_ = 0;
            this.onlineId_ = "";
            this.remarkName_ = "";
            this.showAvatarInfoList_ = Collections.emptyList();
            this.showNameCardIdList_ = emptyIntList();
            this.friendEnterHomeOption_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SocialDetail();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:145:0x038f */
        private SocialDetail(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 42:
                                this.signature_ = input.readStringRequireUtf8();
                                break;
                            case 50:
                                BirthdayOuterClass.Birthday.Builder subBuilder = this.birthday_ != null ? this.birthday_.toBuilder() : null;
                                this.birthday_ = (BirthdayOuterClass.Birthday) input.readMessage(BirthdayOuterClass.Birthday.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.birthday_);
                                    this.birthday_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 56:
                                this.worldLevel_ = input.readUInt32();
                                break;
                            case 64:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.reservedList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.reservedList_.addInt(input.readUInt32());
                                break;
                            case 66:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.reservedList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.reservedList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 72:
                                this.onlineState_ = input.readEnum();
                                break;
                            case 80:
                                this.param_ = input.readUInt32();
                                break;
                            case 88:
                                this.isFriend_ = input.readBool();
                                break;
                            case 96:
                                this.isMpModeAvailable_ = input.readBool();
                                break;
                            case 106:
                                this.onlineId_ = input.readStringRequireUtf8();
                                break;
                            case 112:
                                this.nameCardId_ = input.readUInt32();
                                break;
                            case 120:
                                this.isInBlacklist_ = input.readBool();
                                break;
                            case 128:
                                this.isChatNoDisturb_ = input.readBool();
                                break;
                            case 138:
                                this.remarkName_ = input.readStringRequireUtf8();
                                break;
                            case 144:
                                this.finishAchievementNum_ = input.readUInt32();
                                break;
                            case 152:
                                this.towerFloorIndex_ = input.readUInt32();
                                break;
                            case 160:
                                this.towerLevelIndex_ = input.readUInt32();
                                break;
                            case 168:
                                this.isShowAvatar_ = input.readBool();
                                break;
                            case 178:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.showAvatarInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.showAvatarInfoList_.add((SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo) input.readMessage(SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo.parser(), extensionRegistry));
                                break;
                            case 184:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.showNameCardIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.showNameCardIdList_.addInt(input.readUInt32());
                                break;
                            case 186:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.showNameCardIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.showNameCardIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 192:
                                this.friendEnterHomeOption_ = input.readEnum();
                                break;
                            case 202:
                                ProfilePictureOuterClass.ProfilePicture.Builder subBuilder2 = this.profilePicture_ != null ? this.profilePicture_.toBuilder() : null;
                                this.profilePicture_ = (ProfilePictureOuterClass.ProfilePicture) input.readMessage(ProfilePictureOuterClass.ProfilePicture.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.profilePicture_);
                                    this.profilePicture_ = subBuilder2.buildPartial();
                                    break;
                                }
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
                    this.reservedList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.showAvatarInfoList_ = Collections.unmodifiableList(this.showAvatarInfoList_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.showNameCardIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SocialDetailOuterClass.internal_static_SocialDetail_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SocialDetailOuterClass.internal_static_SocialDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(SocialDetail.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public String getNickname() {
            Object ref = this.nickname_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.nickname_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public ByteString getNicknameBytes() {
            Object ref = this.nickname_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.nickname_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public int getAvatarId() {
            return this.avatarId_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public String getSignature() {
            Object ref = this.signature_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.signature_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public ByteString getSignatureBytes() {
            Object ref = this.signature_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.signature_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public boolean hasBirthday() {
            return this.birthday_ != null;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public BirthdayOuterClass.Birthday getBirthday() {
            return this.birthday_ == null ? BirthdayOuterClass.Birthday.getDefaultInstance() : this.birthday_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public BirthdayOuterClass.BirthdayOrBuilder getBirthdayOrBuilder() {
            return getBirthday();
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public int getWorldLevel() {
            return this.worldLevel_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public List<Integer> getReservedListList() {
            return this.reservedList_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public int getReservedListCount() {
            return this.reservedList_.size();
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public int getReservedList(int index) {
            return this.reservedList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public int getOnlineStateValue() {
            return this.onlineState_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public FriendOnlineStateOuterClass.FriendOnlineState getOnlineState() {
            FriendOnlineStateOuterClass.FriendOnlineState result = FriendOnlineStateOuterClass.FriendOnlineState.valueOf(this.onlineState_);
            return result == null ? FriendOnlineStateOuterClass.FriendOnlineState.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public int getParam() {
            return this.param_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public boolean getIsFriend() {
            return this.isFriend_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public boolean getIsMpModeAvailable() {
            return this.isMpModeAvailable_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public String getOnlineId() {
            Object ref = this.onlineId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.onlineId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public ByteString getOnlineIdBytes() {
            Object ref = this.onlineId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.onlineId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public int getNameCardId() {
            return this.nameCardId_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public boolean getIsInBlacklist() {
            return this.isInBlacklist_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public boolean getIsChatNoDisturb() {
            return this.isChatNoDisturb_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public String getRemarkName() {
            Object ref = this.remarkName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.remarkName_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public ByteString getRemarkNameBytes() {
            Object ref = this.remarkName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.remarkName_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public int getFinishAchievementNum() {
            return this.finishAchievementNum_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public int getTowerFloorIndex() {
            return this.towerFloorIndex_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public int getTowerLevelIndex() {
            return this.towerLevelIndex_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public boolean getIsShowAvatar() {
            return this.isShowAvatar_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public List<SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo> getShowAvatarInfoListList() {
            return this.showAvatarInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public List<? extends SocialShowAvatarInfoOuterClass.SocialShowAvatarInfoOrBuilder> getShowAvatarInfoListOrBuilderList() {
            return this.showAvatarInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public int getShowAvatarInfoListCount() {
            return this.showAvatarInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo getShowAvatarInfoList(int index) {
            return this.showAvatarInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public SocialShowAvatarInfoOuterClass.SocialShowAvatarInfoOrBuilder getShowAvatarInfoListOrBuilder(int index) {
            return this.showAvatarInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public List<Integer> getShowNameCardIdListList() {
            return this.showNameCardIdList_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public int getShowNameCardIdListCount() {
            return this.showNameCardIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public int getShowNameCardIdList(int index) {
            return this.showNameCardIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public int getFriendEnterHomeOptionValue() {
            return this.friendEnterHomeOption_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public FriendEnterHomeOptionOuterClass.FriendEnterHomeOption getFriendEnterHomeOption() {
            FriendEnterHomeOptionOuterClass.FriendEnterHomeOption result = FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.valueOf(this.friendEnterHomeOption_);
            return result == null ? FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public boolean hasProfilePicture() {
            return this.profilePicture_ != null;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public ProfilePictureOuterClass.ProfilePicture getProfilePicture() {
            return this.profilePicture_ == null ? ProfilePictureOuterClass.ProfilePicture.getDefaultInstance() : this.profilePicture_;
        }

        @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
        public ProfilePictureOuterClass.ProfilePictureOrBuilder getProfilePictureOrBuilder() {
            return getProfilePicture();
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
            if (this.level_ != 0) {
                output.writeUInt32(3, this.level_);
            }
            if (this.avatarId_ != 0) {
                output.writeUInt32(4, this.avatarId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.signature_)) {
                GeneratedMessageV3.writeString(output, 5, this.signature_);
            }
            if (this.birthday_ != null) {
                output.writeMessage(6, getBirthday());
            }
            if (this.worldLevel_ != 0) {
                output.writeUInt32(7, this.worldLevel_);
            }
            if (getReservedListList().size() > 0) {
                output.writeUInt32NoTag(66);
                output.writeUInt32NoTag(this.reservedListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.reservedList_.size(); i++) {
                output.writeUInt32NoTag(this.reservedList_.getInt(i));
            }
            if (this.onlineState_ != FriendOnlineStateOuterClass.FriendOnlineState.FRIEND_ONLINE_STATE_DISCONNECT.getNumber()) {
                output.writeEnum(9, this.onlineState_);
            }
            if (this.param_ != 0) {
                output.writeUInt32(10, this.param_);
            }
            if (this.isFriend_) {
                output.writeBool(11, this.isFriend_);
            }
            if (this.isMpModeAvailable_) {
                output.writeBool(12, this.isMpModeAvailable_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.onlineId_)) {
                GeneratedMessageV3.writeString(output, 13, this.onlineId_);
            }
            if (this.nameCardId_ != 0) {
                output.writeUInt32(14, this.nameCardId_);
            }
            if (this.isInBlacklist_) {
                output.writeBool(15, this.isInBlacklist_);
            }
            if (this.isChatNoDisturb_) {
                output.writeBool(16, this.isChatNoDisturb_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.remarkName_)) {
                GeneratedMessageV3.writeString(output, 17, this.remarkName_);
            }
            if (this.finishAchievementNum_ != 0) {
                output.writeUInt32(18, this.finishAchievementNum_);
            }
            if (this.towerFloorIndex_ != 0) {
                output.writeUInt32(19, this.towerFloorIndex_);
            }
            if (this.towerLevelIndex_ != 0) {
                output.writeUInt32(20, this.towerLevelIndex_);
            }
            if (this.isShowAvatar_) {
                output.writeBool(21, this.isShowAvatar_);
            }
            for (int i2 = 0; i2 < this.showAvatarInfoList_.size(); i2++) {
                output.writeMessage(22, this.showAvatarInfoList_.get(i2));
            }
            if (getShowNameCardIdListList().size() > 0) {
                output.writeUInt32NoTag(186);
                output.writeUInt32NoTag(this.showNameCardIdListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.showNameCardIdList_.size(); i3++) {
                output.writeUInt32NoTag(this.showNameCardIdList_.getInt(i3));
            }
            if (this.friendEnterHomeOption_ != FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.FRIEND_ENTER_HOME_OPTION_NEED_CONFIRM.getNumber()) {
                output.writeEnum(24, this.friendEnterHomeOption_);
            }
            if (this.profilePicture_ != null) {
                output.writeMessage(25, getProfilePicture());
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
            if (!GeneratedMessageV3.isStringEmpty(this.signature_)) {
                size2 += GeneratedMessageV3.computeStringSize(5, this.signature_);
            }
            if (this.birthday_ != null) {
                size2 += CodedOutputStream.computeMessageSize(6, getBirthday());
            }
            if (this.worldLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.worldLevel_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.reservedList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.reservedList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getReservedListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.reservedListMemoizedSerializedSize = dataSize;
            if (this.onlineState_ != FriendOnlineStateOuterClass.FriendOnlineState.FRIEND_ONLINE_STATE_DISCONNECT.getNumber()) {
                size3 += CodedOutputStream.computeEnumSize(9, this.onlineState_);
            }
            if (this.param_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(10, this.param_);
            }
            if (this.isFriend_) {
                size3 += CodedOutputStream.computeBoolSize(11, this.isFriend_);
            }
            if (this.isMpModeAvailable_) {
                size3 += CodedOutputStream.computeBoolSize(12, this.isMpModeAvailable_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.onlineId_)) {
                size3 += GeneratedMessageV3.computeStringSize(13, this.onlineId_);
            }
            if (this.nameCardId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(14, this.nameCardId_);
            }
            if (this.isInBlacklist_) {
                size3 += CodedOutputStream.computeBoolSize(15, this.isInBlacklist_);
            }
            if (this.isChatNoDisturb_) {
                size3 += CodedOutputStream.computeBoolSize(16, this.isChatNoDisturb_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.remarkName_)) {
                size3 += GeneratedMessageV3.computeStringSize(17, this.remarkName_);
            }
            if (this.finishAchievementNum_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(18, this.finishAchievementNum_);
            }
            if (this.towerFloorIndex_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(19, this.towerFloorIndex_);
            }
            if (this.towerLevelIndex_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(20, this.towerLevelIndex_);
            }
            if (this.isShowAvatar_) {
                size3 += CodedOutputStream.computeBoolSize(21, this.isShowAvatar_);
            }
            for (int i2 = 0; i2 < this.showAvatarInfoList_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(22, this.showAvatarInfoList_.get(i2));
            }
            int dataSize2 = 0;
            for (int i3 = 0; i3 < this.showNameCardIdList_.size(); i3++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.showNameCardIdList_.getInt(i3));
            }
            int size4 = size3 + dataSize2;
            if (!getShowNameCardIdListList().isEmpty()) {
                size4 = size4 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.showNameCardIdListMemoizedSerializedSize = dataSize2;
            if (this.friendEnterHomeOption_ != FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.FRIEND_ENTER_HOME_OPTION_NEED_CONFIRM.getNumber()) {
                size4 += CodedOutputStream.computeEnumSize(24, this.friendEnterHomeOption_);
            }
            if (this.profilePicture_ != null) {
                size4 += CodedOutputStream.computeMessageSize(25, getProfilePicture());
            }
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SocialDetail)) {
                return equals(obj);
            }
            SocialDetail other = (SocialDetail) obj;
            if (getUid() != other.getUid() || !getNickname().equals(other.getNickname()) || getLevel() != other.getLevel() || getAvatarId() != other.getAvatarId() || !getSignature().equals(other.getSignature()) || hasBirthday() != other.hasBirthday()) {
                return false;
            }
            if ((!hasBirthday() || getBirthday().equals(other.getBirthday())) && getWorldLevel() == other.getWorldLevel() && getReservedListList().equals(other.getReservedListList()) && this.onlineState_ == other.onlineState_ && getParam() == other.getParam() && getIsFriend() == other.getIsFriend() && getIsMpModeAvailable() == other.getIsMpModeAvailable() && getOnlineId().equals(other.getOnlineId()) && getNameCardId() == other.getNameCardId() && getIsInBlacklist() == other.getIsInBlacklist() && getIsChatNoDisturb() == other.getIsChatNoDisturb() && getRemarkName().equals(other.getRemarkName()) && getFinishAchievementNum() == other.getFinishAchievementNum() && getTowerFloorIndex() == other.getTowerFloorIndex() && getTowerLevelIndex() == other.getTowerLevelIndex() && getIsShowAvatar() == other.getIsShowAvatar() && getShowAvatarInfoListList().equals(other.getShowAvatarInfoListList()) && getShowNameCardIdListList().equals(other.getShowNameCardIdListList()) && this.friendEnterHomeOption_ == other.friendEnterHomeOption_ && hasProfilePicture() == other.hasProfilePicture()) {
                return (!hasProfilePicture() || getProfilePicture().equals(other.getProfilePicture())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getUid())) + 2)) + getNickname().hashCode())) + 3)) + getLevel())) + 4)) + getAvatarId())) + 5)) + getSignature().hashCode();
            if (hasBirthday()) {
                hash = (53 * ((37 * hash) + 6)) + getBirthday().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 7)) + getWorldLevel();
            if (getReservedListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 8)) + getReservedListList().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 9)) + this.onlineState_)) + 10)) + getParam())) + 11)) + Internal.hashBoolean(getIsFriend()))) + 12)) + Internal.hashBoolean(getIsMpModeAvailable()))) + 13)) + getOnlineId().hashCode())) + 14)) + getNameCardId())) + 15)) + Internal.hashBoolean(getIsInBlacklist()))) + 16)) + Internal.hashBoolean(getIsChatNoDisturb()))) + 17)) + getRemarkName().hashCode())) + 18)) + getFinishAchievementNum())) + 19)) + getTowerFloorIndex())) + 20)) + getTowerLevelIndex())) + 21)) + Internal.hashBoolean(getIsShowAvatar());
            if (getShowAvatarInfoListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 22)) + getShowAvatarInfoListList().hashCode();
            }
            if (getShowNameCardIdListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 23)) + getShowNameCardIdListList().hashCode();
            }
            int hash4 = (53 * ((37 * hash3) + 24)) + this.friendEnterHomeOption_;
            if (hasProfilePicture()) {
                hash4 = (53 * ((37 * hash4) + 25)) + getProfilePicture().hashCode();
            }
            int hash5 = (29 * hash4) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash5;
            return hash5;
        }

        public static SocialDetail parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SocialDetail parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SocialDetail parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SocialDetail parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SocialDetail parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SocialDetail parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SocialDetail parseFrom(InputStream input) throws IOException {
            return (SocialDetail) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SocialDetail parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SocialDetail) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SocialDetail parseDelimitedFrom(InputStream input) throws IOException {
            return (SocialDetail) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SocialDetail parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SocialDetail) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SocialDetail parseFrom(CodedInputStream input) throws IOException {
            return (SocialDetail) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SocialDetail parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SocialDetail) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SocialDetail prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SocialDetailOuterClass$SocialDetail$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SocialDetailOrBuilder {
            private int bitField0_;
            private int uid_;
            private int level_;
            private int avatarId_;
            private BirthdayOuterClass.Birthday birthday_;
            private SingleFieldBuilderV3<BirthdayOuterClass.Birthday, BirthdayOuterClass.Birthday.Builder, BirthdayOuterClass.BirthdayOrBuilder> birthdayBuilder_;
            private int worldLevel_;
            private int param_;
            private boolean isFriend_;
            private boolean isMpModeAvailable_;
            private int nameCardId_;
            private boolean isInBlacklist_;
            private boolean isChatNoDisturb_;
            private int finishAchievementNum_;
            private int towerFloorIndex_;
            private int towerLevelIndex_;
            private boolean isShowAvatar_;
            private RepeatedFieldBuilderV3<SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo, SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo.Builder, SocialShowAvatarInfoOuterClass.SocialShowAvatarInfoOrBuilder> showAvatarInfoListBuilder_;
            private ProfilePictureOuterClass.ProfilePicture profilePicture_;
            private SingleFieldBuilderV3<ProfilePictureOuterClass.ProfilePicture, ProfilePictureOuterClass.ProfilePicture.Builder, ProfilePictureOuterClass.ProfilePictureOrBuilder> profilePictureBuilder_;
            private Object nickname_ = "";
            private Object signature_ = "";
            private Internal.IntList reservedList_ = SocialDetail.emptyIntList();
            private int onlineState_ = 0;
            private Object onlineId_ = "";
            private Object remarkName_ = "";
            private List<SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo> showAvatarInfoList_ = Collections.emptyList();
            private Internal.IntList showNameCardIdList_ = SocialDetail.emptyIntList();
            private int friendEnterHomeOption_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return SocialDetailOuterClass.internal_static_SocialDetail_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SocialDetailOuterClass.internal_static_SocialDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(SocialDetail.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SocialDetail.alwaysUseFieldBuilders) {
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
                this.signature_ = "";
                if (this.birthdayBuilder_ == null) {
                    this.birthday_ = null;
                } else {
                    this.birthday_ = null;
                    this.birthdayBuilder_ = null;
                }
                this.worldLevel_ = 0;
                this.reservedList_ = SocialDetail.emptyIntList();
                this.bitField0_ &= -2;
                this.onlineState_ = 0;
                this.param_ = 0;
                this.isFriend_ = false;
                this.isMpModeAvailable_ = false;
                this.onlineId_ = "";
                this.nameCardId_ = 0;
                this.isInBlacklist_ = false;
                this.isChatNoDisturb_ = false;
                this.remarkName_ = "";
                this.finishAchievementNum_ = 0;
                this.towerFloorIndex_ = 0;
                this.towerLevelIndex_ = 0;
                this.isShowAvatar_ = false;
                if (this.showAvatarInfoListBuilder_ == null) {
                    this.showAvatarInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.showAvatarInfoListBuilder_.clear();
                }
                this.showNameCardIdList_ = SocialDetail.emptyIntList();
                this.bitField0_ &= -5;
                this.friendEnterHomeOption_ = 0;
                if (this.profilePictureBuilder_ == null) {
                    this.profilePicture_ = null;
                } else {
                    this.profilePicture_ = null;
                    this.profilePictureBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SocialDetailOuterClass.internal_static_SocialDetail_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SocialDetail getDefaultInstanceForType() {
                return SocialDetail.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SocialDetail build() {
                SocialDetail result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SocialDetail buildPartial() {
                SocialDetail result = new SocialDetail(this);
                int i = this.bitField0_;
                result.uid_ = this.uid_;
                result.nickname_ = this.nickname_;
                result.level_ = this.level_;
                result.avatarId_ = this.avatarId_;
                result.signature_ = this.signature_;
                if (this.birthdayBuilder_ == null) {
                    result.birthday_ = this.birthday_;
                } else {
                    result.birthday_ = this.birthdayBuilder_.build();
                }
                result.worldLevel_ = this.worldLevel_;
                if ((this.bitField0_ & 1) != 0) {
                    this.reservedList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.reservedList_ = this.reservedList_;
                result.onlineState_ = this.onlineState_;
                result.param_ = this.param_;
                result.isFriend_ = this.isFriend_;
                result.isMpModeAvailable_ = this.isMpModeAvailable_;
                result.onlineId_ = this.onlineId_;
                result.nameCardId_ = this.nameCardId_;
                result.isInBlacklist_ = this.isInBlacklist_;
                result.isChatNoDisturb_ = this.isChatNoDisturb_;
                result.remarkName_ = this.remarkName_;
                result.finishAchievementNum_ = this.finishAchievementNum_;
                result.towerFloorIndex_ = this.towerFloorIndex_;
                result.towerLevelIndex_ = this.towerLevelIndex_;
                result.isShowAvatar_ = this.isShowAvatar_;
                if (this.showAvatarInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.showAvatarInfoList_ = Collections.unmodifiableList(this.showAvatarInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.showAvatarInfoList_ = this.showAvatarInfoList_;
                } else {
                    result.showAvatarInfoList_ = this.showAvatarInfoListBuilder_.build();
                }
                if ((this.bitField0_ & 4) != 0) {
                    this.showNameCardIdList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.showNameCardIdList_ = this.showNameCardIdList_;
                result.friendEnterHomeOption_ = this.friendEnterHomeOption_;
                if (this.profilePictureBuilder_ == null) {
                    result.profilePicture_ = this.profilePicture_;
                } else {
                    result.profilePicture_ = this.profilePictureBuilder_.build();
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
                if (other instanceof SocialDetail) {
                    return mergeFrom((SocialDetail) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SocialDetail other) {
                if (other == SocialDetail.getDefaultInstance()) {
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
                if (!other.getSignature().isEmpty()) {
                    this.signature_ = other.signature_;
                    onChanged();
                }
                if (other.hasBirthday()) {
                    mergeBirthday(other.getBirthday());
                }
                if (other.getWorldLevel() != 0) {
                    setWorldLevel(other.getWorldLevel());
                }
                if (!other.reservedList_.isEmpty()) {
                    if (this.reservedList_.isEmpty()) {
                        this.reservedList_ = other.reservedList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureReservedListIsMutable();
                        this.reservedList_.addAll(other.reservedList_);
                    }
                    onChanged();
                }
                if (other.onlineState_ != 0) {
                    setOnlineStateValue(other.getOnlineStateValue());
                }
                if (other.getParam() != 0) {
                    setParam(other.getParam());
                }
                if (other.getIsFriend()) {
                    setIsFriend(other.getIsFriend());
                }
                if (other.getIsMpModeAvailable()) {
                    setIsMpModeAvailable(other.getIsMpModeAvailable());
                }
                if (!other.getOnlineId().isEmpty()) {
                    this.onlineId_ = other.onlineId_;
                    onChanged();
                }
                if (other.getNameCardId() != 0) {
                    setNameCardId(other.getNameCardId());
                }
                if (other.getIsInBlacklist()) {
                    setIsInBlacklist(other.getIsInBlacklist());
                }
                if (other.getIsChatNoDisturb()) {
                    setIsChatNoDisturb(other.getIsChatNoDisturb());
                }
                if (!other.getRemarkName().isEmpty()) {
                    this.remarkName_ = other.remarkName_;
                    onChanged();
                }
                if (other.getFinishAchievementNum() != 0) {
                    setFinishAchievementNum(other.getFinishAchievementNum());
                }
                if (other.getTowerFloorIndex() != 0) {
                    setTowerFloorIndex(other.getTowerFloorIndex());
                }
                if (other.getTowerLevelIndex() != 0) {
                    setTowerLevelIndex(other.getTowerLevelIndex());
                }
                if (other.getIsShowAvatar()) {
                    setIsShowAvatar(other.getIsShowAvatar());
                }
                if (this.showAvatarInfoListBuilder_ == null) {
                    if (!other.showAvatarInfoList_.isEmpty()) {
                        if (this.showAvatarInfoList_.isEmpty()) {
                            this.showAvatarInfoList_ = other.showAvatarInfoList_;
                            this.bitField0_ &= -3;
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
                        this.bitField0_ &= -3;
                        this.showAvatarInfoListBuilder_ = SocialDetail.alwaysUseFieldBuilders ? getShowAvatarInfoListFieldBuilder() : null;
                    } else {
                        this.showAvatarInfoListBuilder_.addAllMessages(other.showAvatarInfoList_);
                    }
                }
                if (!other.showNameCardIdList_.isEmpty()) {
                    if (this.showNameCardIdList_.isEmpty()) {
                        this.showNameCardIdList_ = other.showNameCardIdList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureShowNameCardIdListIsMutable();
                        this.showNameCardIdList_.addAll(other.showNameCardIdList_);
                    }
                    onChanged();
                }
                if (other.friendEnterHomeOption_ != 0) {
                    setFriendEnterHomeOptionValue(other.getFriendEnterHomeOptionValue());
                }
                if (other.hasProfilePicture()) {
                    mergeProfilePicture(other.getProfilePicture());
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
                SocialDetail parsedMessage = null;
                try {
                    try {
                        parsedMessage = SocialDetail.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SocialDetail) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public String getNickname() {
                Object ref = this.nickname_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.nickname_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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
                this.nickname_ = SocialDetail.getDefaultInstance().getNickname();
                onChanged();
                return this;
            }

            public Builder setNicknameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                SocialDetail.checkByteStringIsUtf8(value);
                this.nickname_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public String getSignature() {
                Object ref = this.signature_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.signature_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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
                this.signature_ = SocialDetail.getDefaultInstance().getSignature();
                onChanged();
                return this;
            }

            public Builder setSignatureBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                SocialDetail.checkByteStringIsUtf8(value);
                this.signature_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public boolean hasBirthday() {
                return (this.birthdayBuilder_ == null && this.birthday_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public BirthdayOuterClass.Birthday getBirthday() {
                if (this.birthdayBuilder_ == null) {
                    return this.birthday_ == null ? BirthdayOuterClass.Birthday.getDefaultInstance() : this.birthday_;
                }
                return this.birthdayBuilder_.getMessage();
            }

            public Builder setBirthday(BirthdayOuterClass.Birthday value) {
                if (this.birthdayBuilder_ != null) {
                    this.birthdayBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.birthday_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setBirthday(BirthdayOuterClass.Birthday.Builder builderForValue) {
                if (this.birthdayBuilder_ == null) {
                    this.birthday_ = builderForValue.build();
                    onChanged();
                } else {
                    this.birthdayBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeBirthday(BirthdayOuterClass.Birthday value) {
                if (this.birthdayBuilder_ == null) {
                    if (this.birthday_ != null) {
                        this.birthday_ = BirthdayOuterClass.Birthday.newBuilder(this.birthday_).mergeFrom(value).buildPartial();
                    } else {
                        this.birthday_ = value;
                    }
                    onChanged();
                } else {
                    this.birthdayBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearBirthday() {
                if (this.birthdayBuilder_ == null) {
                    this.birthday_ = null;
                    onChanged();
                } else {
                    this.birthday_ = null;
                    this.birthdayBuilder_ = null;
                }
                return this;
            }

            public BirthdayOuterClass.Birthday.Builder getBirthdayBuilder() {
                onChanged();
                return getBirthdayFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public BirthdayOuterClass.BirthdayOrBuilder getBirthdayOrBuilder() {
                if (this.birthdayBuilder_ != null) {
                    return this.birthdayBuilder_.getMessageOrBuilder();
                }
                return this.birthday_ == null ? BirthdayOuterClass.Birthday.getDefaultInstance() : this.birthday_;
            }

            private SingleFieldBuilderV3<BirthdayOuterClass.Birthday, BirthdayOuterClass.Birthday.Builder, BirthdayOuterClass.BirthdayOrBuilder> getBirthdayFieldBuilder() {
                if (this.birthdayBuilder_ == null) {
                    this.birthdayBuilder_ = new SingleFieldBuilderV3<>(getBirthday(), getParentForChildren(), isClean());
                    this.birthday_ = null;
                }
                return this.birthdayBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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

            private void ensureReservedListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.reservedList_ = SocialDetail.mutableCopy(this.reservedList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public List<Integer> getReservedListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.reservedList_) : this.reservedList_;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public int getReservedListCount() {
                return this.reservedList_.size();
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public int getReservedList(int index) {
                return this.reservedList_.getInt(index);
            }

            public Builder setReservedList(int index, int value) {
                ensureReservedListIsMutable();
                this.reservedList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addReservedList(int value) {
                ensureReservedListIsMutable();
                this.reservedList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllReservedList(Iterable<? extends Integer> values) {
                ensureReservedListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.reservedList_);
                onChanged();
                return this;
            }

            public Builder clearReservedList() {
                this.reservedList_ = SocialDetail.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public int getOnlineStateValue() {
                return this.onlineState_;
            }

            public Builder setOnlineStateValue(int value) {
                this.onlineState_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public boolean getIsFriend() {
                return this.isFriend_;
            }

            public Builder setIsFriend(boolean value) {
                this.isFriend_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFriend() {
                this.isFriend_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public String getOnlineId() {
                Object ref = this.onlineId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.onlineId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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
                this.onlineId_ = SocialDetail.getDefaultInstance().getOnlineId();
                onChanged();
                return this;
            }

            public Builder setOnlineIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                SocialDetail.checkByteStringIsUtf8(value);
                this.onlineId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public boolean getIsInBlacklist() {
                return this.isInBlacklist_;
            }

            public Builder setIsInBlacklist(boolean value) {
                this.isInBlacklist_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsInBlacklist() {
                this.isInBlacklist_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public String getRemarkName() {
                Object ref = this.remarkName_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.remarkName_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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
                this.remarkName_ = SocialDetail.getDefaultInstance().getRemarkName();
                onChanged();
                return this;
            }

            public Builder setRemarkNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                SocialDetail.checkByteStringIsUtf8(value);
                this.remarkName_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public int getFinishAchievementNum() {
                return this.finishAchievementNum_;
            }

            public Builder setFinishAchievementNum(int value) {
                this.finishAchievementNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearFinishAchievementNum() {
                this.finishAchievementNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public int getTowerFloorIndex() {
                return this.towerFloorIndex_;
            }

            public Builder setTowerFloorIndex(int value) {
                this.towerFloorIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearTowerFloorIndex() {
                this.towerFloorIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public int getTowerLevelIndex() {
                return this.towerLevelIndex_;
            }

            public Builder setTowerLevelIndex(int value) {
                this.towerLevelIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearTowerLevelIndex() {
                this.towerLevelIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public boolean getIsShowAvatar() {
                return this.isShowAvatar_;
            }

            public Builder setIsShowAvatar(boolean value) {
                this.isShowAvatar_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsShowAvatar() {
                this.isShowAvatar_ = false;
                onChanged();
                return this;
            }

            private void ensureShowAvatarInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.showAvatarInfoList_ = new ArrayList(this.showAvatarInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public List<SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo> getShowAvatarInfoListList() {
                if (this.showAvatarInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.showAvatarInfoList_);
                }
                return this.showAvatarInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public int getShowAvatarInfoListCount() {
                if (this.showAvatarInfoListBuilder_ == null) {
                    return this.showAvatarInfoList_.size();
                }
                return this.showAvatarInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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
                    this.bitField0_ &= -3;
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

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public SocialShowAvatarInfoOuterClass.SocialShowAvatarInfoOrBuilder getShowAvatarInfoListOrBuilder(int index) {
                if (this.showAvatarInfoListBuilder_ == null) {
                    return this.showAvatarInfoList_.get(index);
                }
                return this.showAvatarInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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
                    this.showAvatarInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.showAvatarInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.showAvatarInfoList_ = null;
                }
                return this.showAvatarInfoListBuilder_;
            }

            private void ensureShowNameCardIdListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.showNameCardIdList_ = SocialDetail.mutableCopy(this.showNameCardIdList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public List<Integer> getShowNameCardIdListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.showNameCardIdList_) : this.showNameCardIdList_;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public int getShowNameCardIdListCount() {
                return this.showNameCardIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public int getShowNameCardIdList(int index) {
                return this.showNameCardIdList_.getInt(index);
            }

            public Builder setShowNameCardIdList(int index, int value) {
                ensureShowNameCardIdListIsMutable();
                this.showNameCardIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addShowNameCardIdList(int value) {
                ensureShowNameCardIdListIsMutable();
                this.showNameCardIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllShowNameCardIdList(Iterable<? extends Integer> values) {
                ensureShowNameCardIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.showNameCardIdList_);
                onChanged();
                return this;
            }

            public Builder clearShowNameCardIdList() {
                this.showNameCardIdList_ = SocialDetail.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public int getFriendEnterHomeOptionValue() {
                return this.friendEnterHomeOption_;
            }

            public Builder setFriendEnterHomeOptionValue(int value) {
                this.friendEnterHomeOption_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
            public boolean hasProfilePicture() {
                return (this.profilePictureBuilder_ == null && this.profilePicture_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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

            @Override // emu.grasscutter.net.proto.SocialDetailOuterClass.SocialDetailOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static SocialDetail getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SocialDetail> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SocialDetail> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SocialDetail getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BirthdayOuterClass.getDescriptor();
        FriendEnterHomeOptionOuterClass.getDescriptor();
        FriendOnlineStateOuterClass.getDescriptor();
        ProfilePictureOuterClass.getDescriptor();
        SocialShowAvatarInfoOuterClass.getDescriptor();
    }
}
