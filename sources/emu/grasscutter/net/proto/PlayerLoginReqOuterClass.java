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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass;
import emu.grasscutter.net.proto.TrackingIOInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.text.Typography;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerLoginReqOuterClass.class */
public final class PlayerLoginReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014PlayerLoginReq.proto\u001a\u0018AdjustTrackingInfo.proto\u001a\u0014TrackingIOInfo.proto\"\b\n\u000ePlayerLoginReq\u0012\u0013\n\u000bdevice_uuid\u0018\u0005 \u0001(\t\u0012\u0012\n\ntarget_uid\u0018\n \u0001(\r\u0012\u0017\n\u000eextra_bin_data\u0018þ\u000f \u0001(\f\u0012\u0010\n\bplatform\u0018\u0004 \u0001(\t\u0012\u0011\n\bchecksum\u0018¶\n \u0001(\t\u0012\u0013\n\nchannel_id\u0018\f \u0001(\r\u0012\u001c\n\u0013client_verison_hash\u0018ø\u000f \u0001(\t\u0012\u0015\n\rlanguage_type\u0018\u000b \u0001(\r\u0012\u001c\n\u0013client_data_version\u0018Ï\u0006 \u0001(\r\u0012\u0014\n\faccount_type\u0018\u0007 \u0001(\r\u0012\u001d\n\u0014security_library_md5\u0018ä\u0006 \u0001(\t\u0012\u0012\n\tonline_id\u0018Á\u0004 \u0001(\t\u0012\u001b\n\u0013Unk3300_PMGFBMJNNCL\u0018R \u0001(\r\u0012\u0013\n\u000bdevice_name\u0018\f \u0001(\t\u0012\u0011\n\bbirthday\u0018ë\u0006 \u0001(\t\u0012\f\n\u0003tag\u0018\u0004 \u0001(\r\u0012\u0013\n\u000baccount_uid\u0018\u000e \u0001(\t\u0012\u0013\n\u000bdevice_info\u0018\u000f \u0001(\t\u0012\u0017\n\u000esub_channel_id\u0018²\u000b \u0001(\r\u0012\u0011\n\tis_editor\u0018\u0001 \u0001(\b\u0012\r\n\u0005token\u0018\b \u0001(\t\u0012\u0015\n\freg_platform\u0018¨\u0003 \u0001(\r\u0012 \n\u0017checksum_client_version\u0018Å\u0004 \u0001(\t\u0012\u001b\n\u0013Unk3300_OOBHAIIIPHH\u0018U \u0001(\r\u0012\u001c\n\u0013Unk3300_NDLANBEIGEG\u0018¨\n \u0001(\r\u0012\u0014\n\fcountry_code\u0018h \u0001(\t\u0012\u000f\n\u0006gm_uid\u0018þ\r \u0001(\r\u0012*\n\u0010tracking_io_info\u0018±\r \u0001(\u000b2\u000f.TrackingIOInfo\u0012\u0014\n\u000bis_transfer\u0018ð\u0004 \u0001(\b\u0012!\n\u0018security_library_version\u0018¼\u0006 \u0001(\t\u0012\u0016\n\u000eclient_version\u0018\u0002 \u0001(\t\u0012\u0010\n\bis_guest\u0018\r \u0001(\b\u0012\u0016\n\u000esystem_version\u0018\u0006 \u0001(\t\u0012\u001e\n\u0015target_home_owner_uid\u0018\u0007 \u0001(\r\u0012\u000f\n\u0006psn_id\u0018ú\b \u0001(\t\u0012\u001b\n\u0012security_cmd_reply\u0018ê\u0006 \u0001(\f\u0012\u001c\n\u0013Unk3300_OFFHPAFIFGD\u0018\b \u0001(\r\u0012\u0012\n\nlogin_rand\u0018\t \u0001(\u0004\u00121\n\u0014adjust_tracking_info\u0018@ \u0001(\u000b2\u0013.AdjustTrackingInfo\u0012\u001f\n\u0016environment_error_code\u0018\u0002 \u0001(\f\u0012\u0015\n\rplatform_type\u0018\u0003 \u0001(\r\u0012\f\n\u0003cps\u0018¿\u000f \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AdjustTrackingInfoOuterClass.getDescriptor(), TrackingIOInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerLoginReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerLoginReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerLoginReq_descriptor, new String[]{"DeviceUuid", "TargetUid", "ExtraBinData", "Platform", "Checksum", "ChannelId", "ClientVerisonHash", "LanguageType", "ClientDataVersion", "AccountType", "SecurityLibraryMd5", "OnlineId", "Unk3300PMGFBMJNNCL", "DeviceName", "Birthday", "Tag", "AccountUid", "DeviceInfo", "SubChannelId", "IsEditor", "Token", "RegPlatform", "ChecksumClientVersion", "Unk3300OOBHAIIIPHH", "Unk3300NDLANBEIGEG", "CountryCode", "GmUid", "TrackingIoInfo", "IsTransfer", "SecurityLibraryVersion", "ClientVersion", "IsGuest", "SystemVersion", "TargetHomeOwnerUid", "PsnId", "SecurityCmdReply", "Unk3300OFFHPAFIFGD", "LoginRand", "AdjustTrackingInfo", "EnvironmentErrorCode", "PlatformType", "Cps"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerLoginReqOuterClass$PlayerLoginReqOrBuilder.class */
    public interface PlayerLoginReqOrBuilder extends MessageOrBuilder {
        String getDeviceUuid();

        ByteString getDeviceUuidBytes();

        int getTargetUid();

        ByteString getExtraBinData();

        String getPlatform();

        ByteString getPlatformBytes();

        String getChecksum();

        ByteString getChecksumBytes();

        int getChannelId();

        String getClientVerisonHash();

        ByteString getClientVerisonHashBytes();

        int getLanguageType();

        int getClientDataVersion();

        int getAccountType();

        String getSecurityLibraryMd5();

        ByteString getSecurityLibraryMd5Bytes();

        String getOnlineId();

        ByteString getOnlineIdBytes();

        int getUnk3300PMGFBMJNNCL();

        String getDeviceName();

        ByteString getDeviceNameBytes();

        String getBirthday();

        ByteString getBirthdayBytes();

        int getTag();

        String getAccountUid();

        ByteString getAccountUidBytes();

        String getDeviceInfo();

        ByteString getDeviceInfoBytes();

        int getSubChannelId();

        boolean getIsEditor();

        String getToken();

        ByteString getTokenBytes();

        int getRegPlatform();

        String getChecksumClientVersion();

        ByteString getChecksumClientVersionBytes();

        int getUnk3300OOBHAIIIPHH();

        int getUnk3300NDLANBEIGEG();

        String getCountryCode();

        ByteString getCountryCodeBytes();

        int getGmUid();

        boolean hasTrackingIoInfo();

        TrackingIOInfoOuterClass.TrackingIOInfo getTrackingIoInfo();

        TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder getTrackingIoInfoOrBuilder();

        boolean getIsTransfer();

        String getSecurityLibraryVersion();

        ByteString getSecurityLibraryVersionBytes();

        String getClientVersion();

        ByteString getClientVersionBytes();

        boolean getIsGuest();

        String getSystemVersion();

        ByteString getSystemVersionBytes();

        int getTargetHomeOwnerUid();

        String getPsnId();

        ByteString getPsnIdBytes();

        ByteString getSecurityCmdReply();

        int getUnk3300OFFHPAFIFGD();

        long getLoginRand();

        boolean hasAdjustTrackingInfo();

        AdjustTrackingInfoOuterClass.AdjustTrackingInfo getAdjustTrackingInfo();

        AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder getAdjustTrackingInfoOrBuilder();

        ByteString getEnvironmentErrorCode();

        int getPlatformType();

        String getCps();

        ByteString getCpsBytes();
    }

    private PlayerLoginReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerLoginReqOuterClass$PlayerLoginReq.class */
    public static final class PlayerLoginReq extends GeneratedMessageV3 implements PlayerLoginReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DEVICE_UUID_FIELD_NUMBER = 5;
        private volatile Object deviceUuid_;
        public static final int TARGET_UID_FIELD_NUMBER = 10;
        private int targetUid_;
        public static final int EXTRA_BIN_DATA_FIELD_NUMBER = 2046;
        private ByteString extraBinData_;
        public static final int PLATFORM_FIELD_NUMBER = 4;
        private volatile Object platform_;
        public static final int CHECKSUM_FIELD_NUMBER = 1334;
        private volatile Object checksum_;
        public static final int CHANNEL_ID_FIELD_NUMBER = 1565;
        private int channelId_;
        public static final int CLIENT_VERISON_HASH_FIELD_NUMBER = 2040;
        private volatile Object clientVerisonHash_;
        public static final int LANGUAGE_TYPE_FIELD_NUMBER = 11;
        private int languageType_;
        public static final int CLIENT_DATA_VERSION_FIELD_NUMBER = 847;
        private int clientDataVersion_;
        public static final int ACCOUNT_TYPE_FIELD_NUMBER = 7;
        private int accountType_;
        public static final int SECURITY_LIBRARY_MD5_FIELD_NUMBER = 868;
        private volatile Object securityLibraryMd5_;
        public static final int ONLINE_ID_FIELD_NUMBER = 577;
        private volatile Object onlineId_;
        public static final int UNK3300_PMGFBMJNNCL_FIELD_NUMBER = 82;
        private int unk3300PMGFBMJNNCL_;
        public static final int DEVICE_NAME_FIELD_NUMBER = 12;
        private volatile Object deviceName_;
        public static final int BIRTHDAY_FIELD_NUMBER = 875;
        private volatile Object birthday_;
        public static final int TAG_FIELD_NUMBER = 525;
        private int tag_;
        public static final int ACCOUNT_UID_FIELD_NUMBER = 14;
        private volatile Object accountUid_;
        public static final int DEVICE_INFO_FIELD_NUMBER = 15;
        private volatile Object deviceInfo_;
        public static final int SUB_CHANNEL_ID_FIELD_NUMBER = 1458;
        private int subChannelId_;
        public static final int IS_EDITOR_FIELD_NUMBER = 1;
        private boolean isEditor_;
        public static final int TOKEN_FIELD_NUMBER = 8;
        private volatile Object token_;
        public static final int REG_PLATFORM_FIELD_NUMBER = 424;
        private int regPlatform_;
        public static final int CHECKSUM_CLIENT_VERSION_FIELD_NUMBER = 581;
        private volatile Object checksumClientVersion_;
        public static final int UNK3300_OOBHAIIIPHH_FIELD_NUMBER = 85;
        private int unk3300OOBHAIIIPHH_;
        public static final int UNK3300_NDLANBEIGEG_FIELD_NUMBER = 1320;
        private int unk3300NDLANBEIGEG_;
        public static final int COUNTRY_CODE_FIELD_NUMBER = 104;
        private volatile Object countryCode_;
        public static final int GM_UID_FIELD_NUMBER = 1790;
        private int gmUid_;
        public static final int TRACKING_IO_INFO_FIELD_NUMBER = 1713;
        private TrackingIOInfoOuterClass.TrackingIOInfo trackingIoInfo_;
        public static final int IS_TRANSFER_FIELD_NUMBER = 624;
        private boolean isTransfer_;
        public static final int SECURITY_LIBRARY_VERSION_FIELD_NUMBER = 828;
        private volatile Object securityLibraryVersion_;
        public static final int CLIENT_VERSION_FIELD_NUMBER = 2;
        private volatile Object clientVersion_;
        public static final int IS_GUEST_FIELD_NUMBER = 13;
        private boolean isGuest_;
        public static final int SYSTEM_VERSION_FIELD_NUMBER = 6;
        private volatile Object systemVersion_;
        public static final int TARGET_HOME_OWNER_UID_FIELD_NUMBER = 899;
        private int targetHomeOwnerUid_;
        public static final int PSN_ID_FIELD_NUMBER = 1146;
        private volatile Object psnId_;
        public static final int SECURITY_CMD_REPLY_FIELD_NUMBER = 874;
        private ByteString securityCmdReply_;
        public static final int UNK3300_OFFHPAFIFGD_FIELD_NUMBER = 1028;
        private int unk3300OFFHPAFIFGD_;
        public static final int LOGIN_RAND_FIELD_NUMBER = 9;
        private long loginRand_;
        public static final int ADJUST_TRACKING_INFO_FIELD_NUMBER = 64;
        private AdjustTrackingInfoOuterClass.AdjustTrackingInfo adjustTrackingInfo_;
        public static final int ENVIRONMENT_ERROR_CODE_FIELD_NUMBER = 256;
        private ByteString environmentErrorCode_;
        public static final int PLATFORM_TYPE_FIELD_NUMBER = 3;
        private int platformType_;
        public static final int CPS_FIELD_NUMBER = 1983;
        private volatile Object cps_;
        private byte memoizedIsInitialized;
        private static final PlayerLoginReq DEFAULT_INSTANCE = new PlayerLoginReq();
        private static final Parser<PlayerLoginReq> PARSER = new AbstractParser<PlayerLoginReq>() { // from class: emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReq.1
            @Override // com.google.protobuf.Parser
            public PlayerLoginReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerLoginReq(input, extensionRegistry);
            }
        };

        private PlayerLoginReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerLoginReq() {
            this.memoizedIsInitialized = -1;
            this.deviceUuid_ = "";
            this.extraBinData_ = ByteString.EMPTY;
            this.platform_ = "";
            this.checksum_ = "";
            this.clientVerisonHash_ = "";
            this.securityLibraryMd5_ = "";
            this.onlineId_ = "";
            this.deviceName_ = "";
            this.birthday_ = "";
            this.accountUid_ = "";
            this.deviceInfo_ = "";
            this.token_ = "";
            this.checksumClientVersion_ = "";
            this.countryCode_ = "";
            this.securityLibraryVersion_ = "";
            this.clientVersion_ = "";
            this.systemVersion_ = "";
            this.psnId_ = "";
            this.securityCmdReply_ = ByteString.EMPTY;
            this.environmentErrorCode_ = ByteString.EMPTY;
            this.cps_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerLoginReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerLoginReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.isEditor_ = input.readBool();
                                    break;
                                case 18:
                                    this.clientVersion_ = input.readStringRequireUtf8();
                                    break;
                                case 24:
                                    this.platformType_ = input.readUInt32();
                                    break;
                                case 34:
                                    this.platform_ = input.readStringRequireUtf8();
                                    break;
                                case 42:
                                    this.deviceUuid_ = input.readStringRequireUtf8();
                                    break;
                                case 50:
                                    this.systemVersion_ = input.readStringRequireUtf8();
                                    break;
                                case 56:
                                    this.accountType_ = input.readUInt32();
                                    break;
                                case 66:
                                    this.token_ = input.readStringRequireUtf8();
                                    break;
                                case 72:
                                    this.loginRand_ = input.readUInt64();
                                    break;
                                case 80:
                                    this.targetUid_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.languageType_ = input.readUInt32();
                                    break;
                                case 98:
                                    this.deviceName_ = input.readStringRequireUtf8();
                                    break;
                                case 104:
                                    this.isGuest_ = input.readBool();
                                    break;
                                case 114:
                                    this.accountUid_ = input.readStringRequireUtf8();
                                    break;
                                case 122:
                                    this.deviceInfo_ = input.readStringRequireUtf8();
                                    break;
                                case 514:
                                    AdjustTrackingInfoOuterClass.AdjustTrackingInfo.Builder subBuilder = this.adjustTrackingInfo_ != null ? this.adjustTrackingInfo_.toBuilder() : null;
                                    this.adjustTrackingInfo_ = (AdjustTrackingInfoOuterClass.AdjustTrackingInfo) input.readMessage(AdjustTrackingInfoOuterClass.AdjustTrackingInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.adjustTrackingInfo_);
                                        this.adjustTrackingInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 656:
                                    this.unk3300PMGFBMJNNCL_ = input.readUInt32();
                                    break;
                                case 680:
                                    this.unk3300OOBHAIIIPHH_ = input.readUInt32();
                                    break;
                                case PacketOpcodes.GadgetChangeLevelTagRsp:
                                    this.countryCode_ = input.readStringRequireUtf8();
                                    break;
                                case 2050:
                                    this.environmentErrorCode_ = input.readBytes();
                                    break;
                                case 3392:
                                    this.regPlatform_ = input.readUInt32();
                                    break;
                                case 4200:
                                    this.tag_ = input.readUInt32();
                                    break;
                                case 4618:
                                    this.onlineId_ = input.readStringRequireUtf8();
                                    break;
                                case 4650:
                                    this.checksumClientVersion_ = input.readStringRequireUtf8();
                                    break;
                                case 4992:
                                    this.isTransfer_ = input.readBool();
                                    break;
                                case 6626:
                                    this.securityLibraryVersion_ = input.readStringRequireUtf8();
                                    break;
                                case 6776:
                                    this.clientDataVersion_ = input.readUInt32();
                                    break;
                                case 6946:
                                    this.securityLibraryMd5_ = input.readStringRequireUtf8();
                                    break;
                                case 6994:
                                    this.securityCmdReply_ = input.readBytes();
                                    break;
                                case RET_PLAYER_NOT_EXIST_VALUE:
                                    this.birthday_ = input.readStringRequireUtf8();
                                    break;
                                case 7192:
                                    this.targetHomeOwnerUid_ = input.readUInt32();
                                    break;
                                case Typography.dagger /* 8224 */:
                                    this.unk3300OFFHPAFIFGD_ = input.readUInt32();
                                    break;
                                case RET_SUMMER_TIME_DRAFT_WOORD_EXCEED_LIMIT_VALUE:
                                    this.psnId_ = input.readStringRequireUtf8();
                                    break;
                                case 10560:
                                    this.unk3300NDLANBEIGEG_ = input.readUInt32();
                                    break;
                                case 10674:
                                    this.checksum_ = input.readStringRequireUtf8();
                                    break;
                                case 11664:
                                    this.subChannelId_ = input.readUInt32();
                                    break;
                                case 12520:
                                    this.channelId_ = input.readUInt32();
                                    break;
                                case 13706:
                                    TrackingIOInfoOuterClass.TrackingIOInfo.Builder subBuilder2 = this.trackingIoInfo_ != null ? this.trackingIoInfo_.toBuilder() : null;
                                    this.trackingIoInfo_ = (TrackingIOInfoOuterClass.TrackingIOInfo) input.readMessage(TrackingIOInfoOuterClass.TrackingIOInfo.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.trackingIoInfo_);
                                        this.trackingIoInfo_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                case 14320:
                                    this.gmUid_ = input.readUInt32();
                                    break;
                                case 15866:
                                    this.cps_ = input.readStringRequireUtf8();
                                    break;
                                case 16322:
                                    this.clientVerisonHash_ = input.readStringRequireUtf8();
                                    break;
                                case 16370:
                                    this.extraBinData_ = input.readBytes();
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
            return PlayerLoginReqOuterClass.internal_static_PlayerLoginReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerLoginReqOuterClass.internal_static_PlayerLoginReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerLoginReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getDeviceUuid() {
            Object ref = this.deviceUuid_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.deviceUuid_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getDeviceUuidBytes() {
            Object ref = this.deviceUuid_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.deviceUuid_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getTargetUid() {
            return this.targetUid_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getExtraBinData() {
            return this.extraBinData_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getPlatform() {
            Object ref = this.platform_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.platform_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getPlatformBytes() {
            Object ref = this.platform_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.platform_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getChecksum() {
            Object ref = this.checksum_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.checksum_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getChecksumBytes() {
            Object ref = this.checksum_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.checksum_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getChannelId() {
            return this.channelId_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getClientVerisonHash() {
            Object ref = this.clientVerisonHash_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.clientVerisonHash_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getClientVerisonHashBytes() {
            Object ref = this.clientVerisonHash_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.clientVerisonHash_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getLanguageType() {
            return this.languageType_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getClientDataVersion() {
            return this.clientDataVersion_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getAccountType() {
            return this.accountType_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getSecurityLibraryMd5() {
            Object ref = this.securityLibraryMd5_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.securityLibraryMd5_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getSecurityLibraryMd5Bytes() {
            Object ref = this.securityLibraryMd5_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.securityLibraryMd5_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getOnlineId() {
            Object ref = this.onlineId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.onlineId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getOnlineIdBytes() {
            Object ref = this.onlineId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.onlineId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getUnk3300PMGFBMJNNCL() {
            return this.unk3300PMGFBMJNNCL_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getDeviceName() {
            Object ref = this.deviceName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.deviceName_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getDeviceNameBytes() {
            Object ref = this.deviceName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.deviceName_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getBirthday() {
            Object ref = this.birthday_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.birthday_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getBirthdayBytes() {
            Object ref = this.birthday_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.birthday_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getTag() {
            return this.tag_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getAccountUid() {
            Object ref = this.accountUid_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.accountUid_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getAccountUidBytes() {
            Object ref = this.accountUid_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.accountUid_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getDeviceInfo() {
            Object ref = this.deviceInfo_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.deviceInfo_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getDeviceInfoBytes() {
            Object ref = this.deviceInfo_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.deviceInfo_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getSubChannelId() {
            return this.subChannelId_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public boolean getIsEditor() {
            return this.isEditor_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getToken() {
            Object ref = this.token_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.token_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getTokenBytes() {
            Object ref = this.token_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.token_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getRegPlatform() {
            return this.regPlatform_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getChecksumClientVersion() {
            Object ref = this.checksumClientVersion_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.checksumClientVersion_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getChecksumClientVersionBytes() {
            Object ref = this.checksumClientVersion_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.checksumClientVersion_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getUnk3300OOBHAIIIPHH() {
            return this.unk3300OOBHAIIIPHH_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getUnk3300NDLANBEIGEG() {
            return this.unk3300NDLANBEIGEG_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getCountryCode() {
            Object ref = this.countryCode_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.countryCode_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getCountryCodeBytes() {
            Object ref = this.countryCode_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.countryCode_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getGmUid() {
            return this.gmUid_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public boolean hasTrackingIoInfo() {
            return this.trackingIoInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public TrackingIOInfoOuterClass.TrackingIOInfo getTrackingIoInfo() {
            return this.trackingIoInfo_ == null ? TrackingIOInfoOuterClass.TrackingIOInfo.getDefaultInstance() : this.trackingIoInfo_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder getTrackingIoInfoOrBuilder() {
            return getTrackingIoInfo();
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public boolean getIsTransfer() {
            return this.isTransfer_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getSecurityLibraryVersion() {
            Object ref = this.securityLibraryVersion_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.securityLibraryVersion_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getSecurityLibraryVersionBytes() {
            Object ref = this.securityLibraryVersion_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.securityLibraryVersion_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getClientVersion() {
            Object ref = this.clientVersion_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.clientVersion_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getClientVersionBytes() {
            Object ref = this.clientVersion_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.clientVersion_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public boolean getIsGuest() {
            return this.isGuest_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getSystemVersion() {
            Object ref = this.systemVersion_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.systemVersion_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getSystemVersionBytes() {
            Object ref = this.systemVersion_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.systemVersion_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getTargetHomeOwnerUid() {
            return this.targetHomeOwnerUid_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getPsnId() {
            Object ref = this.psnId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.psnId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getPsnIdBytes() {
            Object ref = this.psnId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.psnId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getSecurityCmdReply() {
            return this.securityCmdReply_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getUnk3300OFFHPAFIFGD() {
            return this.unk3300OFFHPAFIFGD_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public long getLoginRand() {
            return this.loginRand_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public boolean hasAdjustTrackingInfo() {
            return this.adjustTrackingInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public AdjustTrackingInfoOuterClass.AdjustTrackingInfo getAdjustTrackingInfo() {
            return this.adjustTrackingInfo_ == null ? AdjustTrackingInfoOuterClass.AdjustTrackingInfo.getDefaultInstance() : this.adjustTrackingInfo_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder getAdjustTrackingInfoOrBuilder() {
            return getAdjustTrackingInfo();
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getEnvironmentErrorCode() {
            return this.environmentErrorCode_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getPlatformType() {
            return this.platformType_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public String getCps() {
            Object ref = this.cps_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.cps_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getCpsBytes() {
            Object ref = this.cps_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.cps_ = b;
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
            if (this.isEditor_) {
                output.writeBool(1, this.isEditor_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientVersion_)) {
                GeneratedMessageV3.writeString(output, 2, this.clientVersion_);
            }
            if (this.platformType_ != 0) {
                output.writeUInt32(3, this.platformType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.platform_)) {
                GeneratedMessageV3.writeString(output, 4, this.platform_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.deviceUuid_)) {
                GeneratedMessageV3.writeString(output, 5, this.deviceUuid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.systemVersion_)) {
                GeneratedMessageV3.writeString(output, 6, this.systemVersion_);
            }
            if (this.accountType_ != 0) {
                output.writeUInt32(7, this.accountType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.token_)) {
                GeneratedMessageV3.writeString(output, 8, this.token_);
            }
            if (this.loginRand_ != 0) {
                output.writeUInt64(9, this.loginRand_);
            }
            if (this.targetUid_ != 0) {
                output.writeUInt32(10, this.targetUid_);
            }
            if (this.languageType_ != 0) {
                output.writeUInt32(11, this.languageType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.deviceName_)) {
                GeneratedMessageV3.writeString(output, 12, this.deviceName_);
            }
            if (this.isGuest_) {
                output.writeBool(13, this.isGuest_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.accountUid_)) {
                GeneratedMessageV3.writeString(output, 14, this.accountUid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.deviceInfo_)) {
                GeneratedMessageV3.writeString(output, 15, this.deviceInfo_);
            }
            if (this.adjustTrackingInfo_ != null) {
                output.writeMessage(64, getAdjustTrackingInfo());
            }
            if (this.unk3300PMGFBMJNNCL_ != 0) {
                output.writeUInt32(82, this.unk3300PMGFBMJNNCL_);
            }
            if (this.unk3300OOBHAIIIPHH_ != 0) {
                output.writeUInt32(85, this.unk3300OOBHAIIIPHH_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.countryCode_)) {
                GeneratedMessageV3.writeString(output, 104, this.countryCode_);
            }
            if (!this.environmentErrorCode_.isEmpty()) {
                output.writeBytes(256, this.environmentErrorCode_);
            }
            if (this.regPlatform_ != 0) {
                output.writeUInt32(424, this.regPlatform_);
            }
            if (this.tag_ != 0) {
                output.writeUInt32(525, this.tag_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.onlineId_)) {
                GeneratedMessageV3.writeString(output, ONLINE_ID_FIELD_NUMBER, this.onlineId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.checksumClientVersion_)) {
                GeneratedMessageV3.writeString(output, CHECKSUM_CLIENT_VERSION_FIELD_NUMBER, this.checksumClientVersion_);
            }
            if (this.isTransfer_) {
                output.writeBool(624, this.isTransfer_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.securityLibraryVersion_)) {
                GeneratedMessageV3.writeString(output, 828, this.securityLibraryVersion_);
            }
            if (this.clientDataVersion_ != 0) {
                output.writeUInt32(847, this.clientDataVersion_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.securityLibraryMd5_)) {
                GeneratedMessageV3.writeString(output, 868, this.securityLibraryMd5_);
            }
            if (!this.securityCmdReply_.isEmpty()) {
                output.writeBytes(874, this.securityCmdReply_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.birthday_)) {
                GeneratedMessageV3.writeString(output, 875, this.birthday_);
            }
            if (this.targetHomeOwnerUid_ != 0) {
                output.writeUInt32(899, this.targetHomeOwnerUid_);
            }
            if (this.unk3300OFFHPAFIFGD_ != 0) {
                output.writeUInt32(UNK3300_OFFHPAFIFGD_FIELD_NUMBER, this.unk3300OFFHPAFIFGD_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.psnId_)) {
                GeneratedMessageV3.writeString(output, PSN_ID_FIELD_NUMBER, this.psnId_);
            }
            if (this.unk3300NDLANBEIGEG_ != 0) {
                output.writeUInt32(1320, this.unk3300NDLANBEIGEG_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.checksum_)) {
                GeneratedMessageV3.writeString(output, CHECKSUM_FIELD_NUMBER, this.checksum_);
            }
            if (this.subChannelId_ != 0) {
                output.writeUInt32(SUB_CHANNEL_ID_FIELD_NUMBER, this.subChannelId_);
            }
            if (this.channelId_ != 0) {
                output.writeUInt32(1565, this.channelId_);
            }
            if (this.trackingIoInfo_ != null) {
                output.writeMessage(1713, getTrackingIoInfo());
            }
            if (this.gmUid_ != 0) {
                output.writeUInt32(1790, this.gmUid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.cps_)) {
                GeneratedMessageV3.writeString(output, CPS_FIELD_NUMBER, this.cps_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientVerisonHash_)) {
                GeneratedMessageV3.writeString(output, CLIENT_VERISON_HASH_FIELD_NUMBER, this.clientVerisonHash_);
            }
            if (!this.extraBinData_.isEmpty()) {
                output.writeBytes(2046, this.extraBinData_);
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
            if (this.isEditor_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isEditor_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientVersion_)) {
                size2 += GeneratedMessageV3.computeStringSize(2, this.clientVersion_);
            }
            if (this.platformType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.platformType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.platform_)) {
                size2 += GeneratedMessageV3.computeStringSize(4, this.platform_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.deviceUuid_)) {
                size2 += GeneratedMessageV3.computeStringSize(5, this.deviceUuid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.systemVersion_)) {
                size2 += GeneratedMessageV3.computeStringSize(6, this.systemVersion_);
            }
            if (this.accountType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.accountType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.token_)) {
                size2 += GeneratedMessageV3.computeStringSize(8, this.token_);
            }
            if (this.loginRand_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(9, this.loginRand_);
            }
            if (this.targetUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.targetUid_);
            }
            if (this.languageType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.languageType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.deviceName_)) {
                size2 += GeneratedMessageV3.computeStringSize(12, this.deviceName_);
            }
            if (this.isGuest_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isGuest_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.accountUid_)) {
                size2 += GeneratedMessageV3.computeStringSize(14, this.accountUid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.deviceInfo_)) {
                size2 += GeneratedMessageV3.computeStringSize(15, this.deviceInfo_);
            }
            if (this.adjustTrackingInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(64, getAdjustTrackingInfo());
            }
            if (this.unk3300PMGFBMJNNCL_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(82, this.unk3300PMGFBMJNNCL_);
            }
            if (this.unk3300OOBHAIIIPHH_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(85, this.unk3300OOBHAIIIPHH_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.countryCode_)) {
                size2 += GeneratedMessageV3.computeStringSize(104, this.countryCode_);
            }
            if (!this.environmentErrorCode_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(256, this.environmentErrorCode_);
            }
            if (this.regPlatform_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(424, this.regPlatform_);
            }
            if (this.tag_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(525, this.tag_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.onlineId_)) {
                size2 += GeneratedMessageV3.computeStringSize(ONLINE_ID_FIELD_NUMBER, this.onlineId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.checksumClientVersion_)) {
                size2 += GeneratedMessageV3.computeStringSize(CHECKSUM_CLIENT_VERSION_FIELD_NUMBER, this.checksumClientVersion_);
            }
            if (this.isTransfer_) {
                size2 += CodedOutputStream.computeBoolSize(624, this.isTransfer_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.securityLibraryVersion_)) {
                size2 += GeneratedMessageV3.computeStringSize(828, this.securityLibraryVersion_);
            }
            if (this.clientDataVersion_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(847, this.clientDataVersion_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.securityLibraryMd5_)) {
                size2 += GeneratedMessageV3.computeStringSize(868, this.securityLibraryMd5_);
            }
            if (!this.securityCmdReply_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(874, this.securityCmdReply_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.birthday_)) {
                size2 += GeneratedMessageV3.computeStringSize(875, this.birthday_);
            }
            if (this.targetHomeOwnerUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(899, this.targetHomeOwnerUid_);
            }
            if (this.unk3300OFFHPAFIFGD_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(UNK3300_OFFHPAFIFGD_FIELD_NUMBER, this.unk3300OFFHPAFIFGD_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.psnId_)) {
                size2 += GeneratedMessageV3.computeStringSize(PSN_ID_FIELD_NUMBER, this.psnId_);
            }
            if (this.unk3300NDLANBEIGEG_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(1320, this.unk3300NDLANBEIGEG_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.checksum_)) {
                size2 += GeneratedMessageV3.computeStringSize(CHECKSUM_FIELD_NUMBER, this.checksum_);
            }
            if (this.subChannelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(SUB_CHANNEL_ID_FIELD_NUMBER, this.subChannelId_);
            }
            if (this.channelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(1565, this.channelId_);
            }
            if (this.trackingIoInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(1713, getTrackingIoInfo());
            }
            if (this.gmUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(1790, this.gmUid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.cps_)) {
                size2 += GeneratedMessageV3.computeStringSize(CPS_FIELD_NUMBER, this.cps_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientVerisonHash_)) {
                size2 += GeneratedMessageV3.computeStringSize(CLIENT_VERISON_HASH_FIELD_NUMBER, this.clientVerisonHash_);
            }
            if (!this.extraBinData_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(2046, this.extraBinData_);
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
            if (!(obj instanceof PlayerLoginReq)) {
                return equals(obj);
            }
            PlayerLoginReq other = (PlayerLoginReq) obj;
            if (!getDeviceUuid().equals(other.getDeviceUuid()) || getTargetUid() != other.getTargetUid() || !getExtraBinData().equals(other.getExtraBinData()) || !getPlatform().equals(other.getPlatform()) || !getChecksum().equals(other.getChecksum()) || getChannelId() != other.getChannelId() || !getClientVerisonHash().equals(other.getClientVerisonHash()) || getLanguageType() != other.getLanguageType() || getClientDataVersion() != other.getClientDataVersion() || getAccountType() != other.getAccountType() || !getSecurityLibraryMd5().equals(other.getSecurityLibraryMd5()) || !getOnlineId().equals(other.getOnlineId()) || getUnk3300PMGFBMJNNCL() != other.getUnk3300PMGFBMJNNCL() || !getDeviceName().equals(other.getDeviceName()) || !getBirthday().equals(other.getBirthday()) || getTag() != other.getTag() || !getAccountUid().equals(other.getAccountUid()) || !getDeviceInfo().equals(other.getDeviceInfo()) || getSubChannelId() != other.getSubChannelId() || getIsEditor() != other.getIsEditor() || !getToken().equals(other.getToken()) || getRegPlatform() != other.getRegPlatform() || !getChecksumClientVersion().equals(other.getChecksumClientVersion()) || getUnk3300OOBHAIIIPHH() != other.getUnk3300OOBHAIIIPHH() || getUnk3300NDLANBEIGEG() != other.getUnk3300NDLANBEIGEG() || !getCountryCode().equals(other.getCountryCode()) || getGmUid() != other.getGmUid() || hasTrackingIoInfo() != other.hasTrackingIoInfo()) {
                return false;
            }
            if ((!hasTrackingIoInfo() || getTrackingIoInfo().equals(other.getTrackingIoInfo())) && getIsTransfer() == other.getIsTransfer() && getSecurityLibraryVersion().equals(other.getSecurityLibraryVersion()) && getClientVersion().equals(other.getClientVersion()) && getIsGuest() == other.getIsGuest() && getSystemVersion().equals(other.getSystemVersion()) && getTargetHomeOwnerUid() == other.getTargetHomeOwnerUid() && getPsnId().equals(other.getPsnId()) && getSecurityCmdReply().equals(other.getSecurityCmdReply()) && getUnk3300OFFHPAFIFGD() == other.getUnk3300OFFHPAFIFGD() && getLoginRand() == other.getLoginRand() && hasAdjustTrackingInfo() == other.hasAdjustTrackingInfo()) {
                return (!hasAdjustTrackingInfo() || getAdjustTrackingInfo().equals(other.getAdjustTrackingInfo())) && getEnvironmentErrorCode().equals(other.getEnvironmentErrorCode()) && getPlatformType() == other.getPlatformType() && getCps().equals(other.getCps()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getDeviceUuid().hashCode())) + 10)) + getTargetUid())) + 2046)) + getExtraBinData().hashCode())) + 4)) + getPlatform().hashCode())) + CHECKSUM_FIELD_NUMBER)) + getChecksum().hashCode())) + 1565)) + getChannelId())) + CLIENT_VERISON_HASH_FIELD_NUMBER)) + getClientVerisonHash().hashCode())) + 11)) + getLanguageType())) + 847)) + getClientDataVersion())) + 7)) + getAccountType())) + 868)) + getSecurityLibraryMd5().hashCode())) + ONLINE_ID_FIELD_NUMBER)) + getOnlineId().hashCode())) + 82)) + getUnk3300PMGFBMJNNCL())) + 12)) + getDeviceName().hashCode())) + 875)) + getBirthday().hashCode())) + 525)) + getTag())) + 14)) + getAccountUid().hashCode())) + 15)) + getDeviceInfo().hashCode())) + SUB_CHANNEL_ID_FIELD_NUMBER)) + getSubChannelId())) + 1)) + Internal.hashBoolean(getIsEditor()))) + 8)) + getToken().hashCode())) + 424)) + getRegPlatform())) + CHECKSUM_CLIENT_VERSION_FIELD_NUMBER)) + getChecksumClientVersion().hashCode())) + 85)) + getUnk3300OOBHAIIIPHH())) + 1320)) + getUnk3300NDLANBEIGEG())) + 104)) + getCountryCode().hashCode())) + 1790)) + getGmUid();
            if (hasTrackingIoInfo()) {
                hash = (53 * ((37 * hash) + 1713)) + getTrackingIoInfo().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 624)) + Internal.hashBoolean(getIsTransfer()))) + 828)) + getSecurityLibraryVersion().hashCode())) + 2)) + getClientVersion().hashCode())) + 13)) + Internal.hashBoolean(getIsGuest()))) + 6)) + getSystemVersion().hashCode())) + 899)) + getTargetHomeOwnerUid())) + PSN_ID_FIELD_NUMBER)) + getPsnId().hashCode())) + 874)) + getSecurityCmdReply().hashCode())) + UNK3300_OFFHPAFIFGD_FIELD_NUMBER)) + getUnk3300OFFHPAFIFGD())) + 9)) + Internal.hashLong(getLoginRand());
            if (hasAdjustTrackingInfo()) {
                hash2 = (53 * ((37 * hash2) + 64)) + getAdjustTrackingInfo().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 256)) + getEnvironmentErrorCode().hashCode())) + 3)) + getPlatformType())) + CPS_FIELD_NUMBER)) + getCps().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static PlayerLoginReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerLoginReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerLoginReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerLoginReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerLoginReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerLoginReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerLoginReq parseFrom(InputStream input) throws IOException {
            return (PlayerLoginReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerLoginReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerLoginReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerLoginReq parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerLoginReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerLoginReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerLoginReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerLoginReq parseFrom(CodedInputStream input) throws IOException {
            return (PlayerLoginReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerLoginReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerLoginReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerLoginReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerLoginReqOuterClass$PlayerLoginReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerLoginReqOrBuilder {
            private int targetUid_;
            private int channelId_;
            private int languageType_;
            private int clientDataVersion_;
            private int accountType_;
            private int unk3300PMGFBMJNNCL_;
            private int tag_;
            private int subChannelId_;
            private boolean isEditor_;
            private int regPlatform_;
            private int unk3300OOBHAIIIPHH_;
            private int unk3300NDLANBEIGEG_;
            private int gmUid_;
            private TrackingIOInfoOuterClass.TrackingIOInfo trackingIoInfo_;
            private SingleFieldBuilderV3<TrackingIOInfoOuterClass.TrackingIOInfo, TrackingIOInfoOuterClass.TrackingIOInfo.Builder, TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder> trackingIoInfoBuilder_;
            private boolean isTransfer_;
            private boolean isGuest_;
            private int targetHomeOwnerUid_;
            private int unk3300OFFHPAFIFGD_;
            private long loginRand_;
            private AdjustTrackingInfoOuterClass.AdjustTrackingInfo adjustTrackingInfo_;
            private SingleFieldBuilderV3<AdjustTrackingInfoOuterClass.AdjustTrackingInfo, AdjustTrackingInfoOuterClass.AdjustTrackingInfo.Builder, AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder> adjustTrackingInfoBuilder_;
            private int platformType_;
            private Object deviceUuid_ = "";
            private ByteString extraBinData_ = ByteString.EMPTY;
            private Object platform_ = "";
            private Object checksum_ = "";
            private Object clientVerisonHash_ = "";
            private Object securityLibraryMd5_ = "";
            private Object onlineId_ = "";
            private Object deviceName_ = "";
            private Object birthday_ = "";
            private Object accountUid_ = "";
            private Object deviceInfo_ = "";
            private Object token_ = "";
            private Object checksumClientVersion_ = "";
            private Object countryCode_ = "";
            private Object securityLibraryVersion_ = "";
            private Object clientVersion_ = "";
            private Object systemVersion_ = "";
            private Object psnId_ = "";
            private ByteString securityCmdReply_ = ByteString.EMPTY;
            private ByteString environmentErrorCode_ = ByteString.EMPTY;
            private Object cps_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerLoginReqOuterClass.internal_static_PlayerLoginReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerLoginReqOuterClass.internal_static_PlayerLoginReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerLoginReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerLoginReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.deviceUuid_ = "";
                this.targetUid_ = 0;
                this.extraBinData_ = ByteString.EMPTY;
                this.platform_ = "";
                this.checksum_ = "";
                this.channelId_ = 0;
                this.clientVerisonHash_ = "";
                this.languageType_ = 0;
                this.clientDataVersion_ = 0;
                this.accountType_ = 0;
                this.securityLibraryMd5_ = "";
                this.onlineId_ = "";
                this.unk3300PMGFBMJNNCL_ = 0;
                this.deviceName_ = "";
                this.birthday_ = "";
                this.tag_ = 0;
                this.accountUid_ = "";
                this.deviceInfo_ = "";
                this.subChannelId_ = 0;
                this.isEditor_ = false;
                this.token_ = "";
                this.regPlatform_ = 0;
                this.checksumClientVersion_ = "";
                this.unk3300OOBHAIIIPHH_ = 0;
                this.unk3300NDLANBEIGEG_ = 0;
                this.countryCode_ = "";
                this.gmUid_ = 0;
                if (this.trackingIoInfoBuilder_ == null) {
                    this.trackingIoInfo_ = null;
                } else {
                    this.trackingIoInfo_ = null;
                    this.trackingIoInfoBuilder_ = null;
                }
                this.isTransfer_ = false;
                this.securityLibraryVersion_ = "";
                this.clientVersion_ = "";
                this.isGuest_ = false;
                this.systemVersion_ = "";
                this.targetHomeOwnerUid_ = 0;
                this.psnId_ = "";
                this.securityCmdReply_ = ByteString.EMPTY;
                this.unk3300OFFHPAFIFGD_ = 0;
                this.loginRand_ = 0;
                if (this.adjustTrackingInfoBuilder_ == null) {
                    this.adjustTrackingInfo_ = null;
                } else {
                    this.adjustTrackingInfo_ = null;
                    this.adjustTrackingInfoBuilder_ = null;
                }
                this.environmentErrorCode_ = ByteString.EMPTY;
                this.platformType_ = 0;
                this.cps_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerLoginReqOuterClass.internal_static_PlayerLoginReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerLoginReq getDefaultInstanceForType() {
                return PlayerLoginReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerLoginReq build() {
                PlayerLoginReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerLoginReq buildPartial() {
                PlayerLoginReq result = new PlayerLoginReq(this);
                result.deviceUuid_ = this.deviceUuid_;
                result.targetUid_ = this.targetUid_;
                result.extraBinData_ = this.extraBinData_;
                result.platform_ = this.platform_;
                result.checksum_ = this.checksum_;
                result.channelId_ = this.channelId_;
                result.clientVerisonHash_ = this.clientVerisonHash_;
                result.languageType_ = this.languageType_;
                result.clientDataVersion_ = this.clientDataVersion_;
                result.accountType_ = this.accountType_;
                result.securityLibraryMd5_ = this.securityLibraryMd5_;
                result.onlineId_ = this.onlineId_;
                result.unk3300PMGFBMJNNCL_ = this.unk3300PMGFBMJNNCL_;
                result.deviceName_ = this.deviceName_;
                result.birthday_ = this.birthday_;
                result.tag_ = this.tag_;
                result.accountUid_ = this.accountUid_;
                result.deviceInfo_ = this.deviceInfo_;
                result.subChannelId_ = this.subChannelId_;
                result.isEditor_ = this.isEditor_;
                result.token_ = this.token_;
                result.regPlatform_ = this.regPlatform_;
                result.checksumClientVersion_ = this.checksumClientVersion_;
                result.unk3300OOBHAIIIPHH_ = this.unk3300OOBHAIIIPHH_;
                result.unk3300NDLANBEIGEG_ = this.unk3300NDLANBEIGEG_;
                result.countryCode_ = this.countryCode_;
                result.gmUid_ = this.gmUid_;
                if (this.trackingIoInfoBuilder_ == null) {
                    result.trackingIoInfo_ = this.trackingIoInfo_;
                } else {
                    result.trackingIoInfo_ = this.trackingIoInfoBuilder_.build();
                }
                result.isTransfer_ = this.isTransfer_;
                result.securityLibraryVersion_ = this.securityLibraryVersion_;
                result.clientVersion_ = this.clientVersion_;
                result.isGuest_ = this.isGuest_;
                result.systemVersion_ = this.systemVersion_;
                result.targetHomeOwnerUid_ = this.targetHomeOwnerUid_;
                result.psnId_ = this.psnId_;
                result.securityCmdReply_ = this.securityCmdReply_;
                result.unk3300OFFHPAFIFGD_ = this.unk3300OFFHPAFIFGD_;
                result.loginRand_ = this.loginRand_;
                if (this.adjustTrackingInfoBuilder_ == null) {
                    result.adjustTrackingInfo_ = this.adjustTrackingInfo_;
                } else {
                    result.adjustTrackingInfo_ = this.adjustTrackingInfoBuilder_.build();
                }
                result.environmentErrorCode_ = this.environmentErrorCode_;
                result.platformType_ = this.platformType_;
                result.cps_ = this.cps_;
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
                if (other instanceof PlayerLoginReq) {
                    return mergeFrom((PlayerLoginReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerLoginReq other) {
                if (other == PlayerLoginReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.getDeviceUuid().isEmpty()) {
                    this.deviceUuid_ = other.deviceUuid_;
                    onChanged();
                }
                if (other.getTargetUid() != 0) {
                    setTargetUid(other.getTargetUid());
                }
                if (other.getExtraBinData() != ByteString.EMPTY) {
                    setExtraBinData(other.getExtraBinData());
                }
                if (!other.getPlatform().isEmpty()) {
                    this.platform_ = other.platform_;
                    onChanged();
                }
                if (!other.getChecksum().isEmpty()) {
                    this.checksum_ = other.checksum_;
                    onChanged();
                }
                if (other.getChannelId() != 0) {
                    setChannelId(other.getChannelId());
                }
                if (!other.getClientVerisonHash().isEmpty()) {
                    this.clientVerisonHash_ = other.clientVerisonHash_;
                    onChanged();
                }
                if (other.getLanguageType() != 0) {
                    setLanguageType(other.getLanguageType());
                }
                if (other.getClientDataVersion() != 0) {
                    setClientDataVersion(other.getClientDataVersion());
                }
                if (other.getAccountType() != 0) {
                    setAccountType(other.getAccountType());
                }
                if (!other.getSecurityLibraryMd5().isEmpty()) {
                    this.securityLibraryMd5_ = other.securityLibraryMd5_;
                    onChanged();
                }
                if (!other.getOnlineId().isEmpty()) {
                    this.onlineId_ = other.onlineId_;
                    onChanged();
                }
                if (other.getUnk3300PMGFBMJNNCL() != 0) {
                    setUnk3300PMGFBMJNNCL(other.getUnk3300PMGFBMJNNCL());
                }
                if (!other.getDeviceName().isEmpty()) {
                    this.deviceName_ = other.deviceName_;
                    onChanged();
                }
                if (!other.getBirthday().isEmpty()) {
                    this.birthday_ = other.birthday_;
                    onChanged();
                }
                if (other.getTag() != 0) {
                    setTag(other.getTag());
                }
                if (!other.getAccountUid().isEmpty()) {
                    this.accountUid_ = other.accountUid_;
                    onChanged();
                }
                if (!other.getDeviceInfo().isEmpty()) {
                    this.deviceInfo_ = other.deviceInfo_;
                    onChanged();
                }
                if (other.getSubChannelId() != 0) {
                    setSubChannelId(other.getSubChannelId());
                }
                if (other.getIsEditor()) {
                    setIsEditor(other.getIsEditor());
                }
                if (!other.getToken().isEmpty()) {
                    this.token_ = other.token_;
                    onChanged();
                }
                if (other.getRegPlatform() != 0) {
                    setRegPlatform(other.getRegPlatform());
                }
                if (!other.getChecksumClientVersion().isEmpty()) {
                    this.checksumClientVersion_ = other.checksumClientVersion_;
                    onChanged();
                }
                if (other.getUnk3300OOBHAIIIPHH() != 0) {
                    setUnk3300OOBHAIIIPHH(other.getUnk3300OOBHAIIIPHH());
                }
                if (other.getUnk3300NDLANBEIGEG() != 0) {
                    setUnk3300NDLANBEIGEG(other.getUnk3300NDLANBEIGEG());
                }
                if (!other.getCountryCode().isEmpty()) {
                    this.countryCode_ = other.countryCode_;
                    onChanged();
                }
                if (other.getGmUid() != 0) {
                    setGmUid(other.getGmUid());
                }
                if (other.hasTrackingIoInfo()) {
                    mergeTrackingIoInfo(other.getTrackingIoInfo());
                }
                if (other.getIsTransfer()) {
                    setIsTransfer(other.getIsTransfer());
                }
                if (!other.getSecurityLibraryVersion().isEmpty()) {
                    this.securityLibraryVersion_ = other.securityLibraryVersion_;
                    onChanged();
                }
                if (!other.getClientVersion().isEmpty()) {
                    this.clientVersion_ = other.clientVersion_;
                    onChanged();
                }
                if (other.getIsGuest()) {
                    setIsGuest(other.getIsGuest());
                }
                if (!other.getSystemVersion().isEmpty()) {
                    this.systemVersion_ = other.systemVersion_;
                    onChanged();
                }
                if (other.getTargetHomeOwnerUid() != 0) {
                    setTargetHomeOwnerUid(other.getTargetHomeOwnerUid());
                }
                if (!other.getPsnId().isEmpty()) {
                    this.psnId_ = other.psnId_;
                    onChanged();
                }
                if (other.getSecurityCmdReply() != ByteString.EMPTY) {
                    setSecurityCmdReply(other.getSecurityCmdReply());
                }
                if (other.getUnk3300OFFHPAFIFGD() != 0) {
                    setUnk3300OFFHPAFIFGD(other.getUnk3300OFFHPAFIFGD());
                }
                if (other.getLoginRand() != 0) {
                    setLoginRand(other.getLoginRand());
                }
                if (other.hasAdjustTrackingInfo()) {
                    mergeAdjustTrackingInfo(other.getAdjustTrackingInfo());
                }
                if (other.getEnvironmentErrorCode() != ByteString.EMPTY) {
                    setEnvironmentErrorCode(other.getEnvironmentErrorCode());
                }
                if (other.getPlatformType() != 0) {
                    setPlatformType(other.getPlatformType());
                }
                if (!other.getCps().isEmpty()) {
                    this.cps_ = other.cps_;
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
                PlayerLoginReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerLoginReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerLoginReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getDeviceUuid() {
                Object ref = this.deviceUuid_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.deviceUuid_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getDeviceUuidBytes() {
                Object ref = this.deviceUuid_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.deviceUuid_ = b;
                return b;
            }

            public Builder setDeviceUuid(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.deviceUuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearDeviceUuid() {
                this.deviceUuid_ = PlayerLoginReq.getDefaultInstance().getDeviceUuid();
                onChanged();
                return this;
            }

            public Builder setDeviceUuidBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.deviceUuid_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public int getTargetUid() {
                return this.targetUid_;
            }

            public Builder setTargetUid(int value) {
                this.targetUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getExtraBinData() {
                return this.extraBinData_;
            }

            public Builder setExtraBinData(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.extraBinData_ = value;
                onChanged();
                return this;
            }

            public Builder clearExtraBinData() {
                this.extraBinData_ = PlayerLoginReq.getDefaultInstance().getExtraBinData();
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getPlatform() {
                Object ref = this.platform_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.platform_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getPlatformBytes() {
                Object ref = this.platform_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.platform_ = b;
                return b;
            }

            public Builder setPlatform(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.platform_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlatform() {
                this.platform_ = PlayerLoginReq.getDefaultInstance().getPlatform();
                onChanged();
                return this;
            }

            public Builder setPlatformBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.platform_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getChecksum() {
                Object ref = this.checksum_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.checksum_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getChecksumBytes() {
                Object ref = this.checksum_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.checksum_ = b;
                return b;
            }

            public Builder setChecksum(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.checksum_ = value;
                onChanged();
                return this;
            }

            public Builder clearChecksum() {
                this.checksum_ = PlayerLoginReq.getDefaultInstance().getChecksum();
                onChanged();
                return this;
            }

            public Builder setChecksumBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.checksum_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public int getChannelId() {
                return this.channelId_;
            }

            public Builder setChannelId(int value) {
                this.channelId_ = value;
                onChanged();
                return this;
            }

            public Builder clearChannelId() {
                this.channelId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getClientVerisonHash() {
                Object ref = this.clientVerisonHash_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.clientVerisonHash_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getClientVerisonHashBytes() {
                Object ref = this.clientVerisonHash_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientVerisonHash_ = b;
                return b;
            }

            public Builder setClientVerisonHash(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientVerisonHash_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientVerisonHash() {
                this.clientVerisonHash_ = PlayerLoginReq.getDefaultInstance().getClientVerisonHash();
                onChanged();
                return this;
            }

            public Builder setClientVerisonHashBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.clientVerisonHash_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public int getLanguageType() {
                return this.languageType_;
            }

            public Builder setLanguageType(int value) {
                this.languageType_ = value;
                onChanged();
                return this;
            }

            public Builder clearLanguageType() {
                this.languageType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public int getClientDataVersion() {
                return this.clientDataVersion_;
            }

            public Builder setClientDataVersion(int value) {
                this.clientDataVersion_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientDataVersion() {
                this.clientDataVersion_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public int getAccountType() {
                return this.accountType_;
            }

            public Builder setAccountType(int value) {
                this.accountType_ = value;
                onChanged();
                return this;
            }

            public Builder clearAccountType() {
                this.accountType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getSecurityLibraryMd5() {
                Object ref = this.securityLibraryMd5_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.securityLibraryMd5_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getSecurityLibraryMd5Bytes() {
                Object ref = this.securityLibraryMd5_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.securityLibraryMd5_ = b;
                return b;
            }

            public Builder setSecurityLibraryMd5(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.securityLibraryMd5_ = value;
                onChanged();
                return this;
            }

            public Builder clearSecurityLibraryMd5() {
                this.securityLibraryMd5_ = PlayerLoginReq.getDefaultInstance().getSecurityLibraryMd5();
                onChanged();
                return this;
            }

            public Builder setSecurityLibraryMd5Bytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.securityLibraryMd5_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getOnlineId() {
                Object ref = this.onlineId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.onlineId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
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
                this.onlineId_ = PlayerLoginReq.getDefaultInstance().getOnlineId();
                onChanged();
                return this;
            }

            public Builder setOnlineIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.onlineId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public int getUnk3300PMGFBMJNNCL() {
                return this.unk3300PMGFBMJNNCL_;
            }

            public Builder setUnk3300PMGFBMJNNCL(int value) {
                this.unk3300PMGFBMJNNCL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300PMGFBMJNNCL() {
                this.unk3300PMGFBMJNNCL_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getDeviceName() {
                Object ref = this.deviceName_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.deviceName_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getDeviceNameBytes() {
                Object ref = this.deviceName_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.deviceName_ = b;
                return b;
            }

            public Builder setDeviceName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.deviceName_ = value;
                onChanged();
                return this;
            }

            public Builder clearDeviceName() {
                this.deviceName_ = PlayerLoginReq.getDefaultInstance().getDeviceName();
                onChanged();
                return this;
            }

            public Builder setDeviceNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.deviceName_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getBirthday() {
                Object ref = this.birthday_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.birthday_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getBirthdayBytes() {
                Object ref = this.birthday_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.birthday_ = b;
                return b;
            }

            public Builder setBirthday(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.birthday_ = value;
                onChanged();
                return this;
            }

            public Builder clearBirthday() {
                this.birthday_ = PlayerLoginReq.getDefaultInstance().getBirthday();
                onChanged();
                return this;
            }

            public Builder setBirthdayBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.birthday_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public int getTag() {
                return this.tag_;
            }

            public Builder setTag(int value) {
                this.tag_ = value;
                onChanged();
                return this;
            }

            public Builder clearTag() {
                this.tag_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getAccountUid() {
                Object ref = this.accountUid_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.accountUid_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getAccountUidBytes() {
                Object ref = this.accountUid_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.accountUid_ = b;
                return b;
            }

            public Builder setAccountUid(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.accountUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearAccountUid() {
                this.accountUid_ = PlayerLoginReq.getDefaultInstance().getAccountUid();
                onChanged();
                return this;
            }

            public Builder setAccountUidBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.accountUid_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getDeviceInfo() {
                Object ref = this.deviceInfo_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.deviceInfo_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getDeviceInfoBytes() {
                Object ref = this.deviceInfo_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.deviceInfo_ = b;
                return b;
            }

            public Builder setDeviceInfo(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.deviceInfo_ = value;
                onChanged();
                return this;
            }

            public Builder clearDeviceInfo() {
                this.deviceInfo_ = PlayerLoginReq.getDefaultInstance().getDeviceInfo();
                onChanged();
                return this;
            }

            public Builder setDeviceInfoBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.deviceInfo_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public int getSubChannelId() {
                return this.subChannelId_;
            }

            public Builder setSubChannelId(int value) {
                this.subChannelId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSubChannelId() {
                this.subChannelId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public boolean getIsEditor() {
                return this.isEditor_;
            }

            public Builder setIsEditor(boolean value) {
                this.isEditor_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsEditor() {
                this.isEditor_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getToken() {
                Object ref = this.token_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.token_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getTokenBytes() {
                Object ref = this.token_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.token_ = b;
                return b;
            }

            public Builder setToken(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.token_ = value;
                onChanged();
                return this;
            }

            public Builder clearToken() {
                this.token_ = PlayerLoginReq.getDefaultInstance().getToken();
                onChanged();
                return this;
            }

            public Builder setTokenBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.token_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public int getRegPlatform() {
                return this.regPlatform_;
            }

            public Builder setRegPlatform(int value) {
                this.regPlatform_ = value;
                onChanged();
                return this;
            }

            public Builder clearRegPlatform() {
                this.regPlatform_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getChecksumClientVersion() {
                Object ref = this.checksumClientVersion_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.checksumClientVersion_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getChecksumClientVersionBytes() {
                Object ref = this.checksumClientVersion_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.checksumClientVersion_ = b;
                return b;
            }

            public Builder setChecksumClientVersion(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.checksumClientVersion_ = value;
                onChanged();
                return this;
            }

            public Builder clearChecksumClientVersion() {
                this.checksumClientVersion_ = PlayerLoginReq.getDefaultInstance().getChecksumClientVersion();
                onChanged();
                return this;
            }

            public Builder setChecksumClientVersionBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.checksumClientVersion_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public int getUnk3300OOBHAIIIPHH() {
                return this.unk3300OOBHAIIIPHH_;
            }

            public Builder setUnk3300OOBHAIIIPHH(int value) {
                this.unk3300OOBHAIIIPHH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300OOBHAIIIPHH() {
                this.unk3300OOBHAIIIPHH_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public int getUnk3300NDLANBEIGEG() {
                return this.unk3300NDLANBEIGEG_;
            }

            public Builder setUnk3300NDLANBEIGEG(int value) {
                this.unk3300NDLANBEIGEG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NDLANBEIGEG() {
                this.unk3300NDLANBEIGEG_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getCountryCode() {
                Object ref = this.countryCode_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.countryCode_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getCountryCodeBytes() {
                Object ref = this.countryCode_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.countryCode_ = b;
                return b;
            }

            public Builder setCountryCode(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.countryCode_ = value;
                onChanged();
                return this;
            }

            public Builder clearCountryCode() {
                this.countryCode_ = PlayerLoginReq.getDefaultInstance().getCountryCode();
                onChanged();
                return this;
            }

            public Builder setCountryCodeBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.countryCode_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public int getGmUid() {
                return this.gmUid_;
            }

            public Builder setGmUid(int value) {
                this.gmUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearGmUid() {
                this.gmUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public boolean hasTrackingIoInfo() {
                return (this.trackingIoInfoBuilder_ == null && this.trackingIoInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public TrackingIOInfoOuterClass.TrackingIOInfo getTrackingIoInfo() {
                if (this.trackingIoInfoBuilder_ == null) {
                    return this.trackingIoInfo_ == null ? TrackingIOInfoOuterClass.TrackingIOInfo.getDefaultInstance() : this.trackingIoInfo_;
                }
                return this.trackingIoInfoBuilder_.getMessage();
            }

            public Builder setTrackingIoInfo(TrackingIOInfoOuterClass.TrackingIOInfo value) {
                if (this.trackingIoInfoBuilder_ != null) {
                    this.trackingIoInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.trackingIoInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setTrackingIoInfo(TrackingIOInfoOuterClass.TrackingIOInfo.Builder builderForValue) {
                if (this.trackingIoInfoBuilder_ == null) {
                    this.trackingIoInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.trackingIoInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeTrackingIoInfo(TrackingIOInfoOuterClass.TrackingIOInfo value) {
                if (this.trackingIoInfoBuilder_ == null) {
                    if (this.trackingIoInfo_ != null) {
                        this.trackingIoInfo_ = TrackingIOInfoOuterClass.TrackingIOInfo.newBuilder(this.trackingIoInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.trackingIoInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.trackingIoInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearTrackingIoInfo() {
                if (this.trackingIoInfoBuilder_ == null) {
                    this.trackingIoInfo_ = null;
                    onChanged();
                } else {
                    this.trackingIoInfo_ = null;
                    this.trackingIoInfoBuilder_ = null;
                }
                return this;
            }

            public TrackingIOInfoOuterClass.TrackingIOInfo.Builder getTrackingIoInfoBuilder() {
                onChanged();
                return getTrackingIoInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder getTrackingIoInfoOrBuilder() {
                if (this.trackingIoInfoBuilder_ != null) {
                    return this.trackingIoInfoBuilder_.getMessageOrBuilder();
                }
                return this.trackingIoInfo_ == null ? TrackingIOInfoOuterClass.TrackingIOInfo.getDefaultInstance() : this.trackingIoInfo_;
            }

            private SingleFieldBuilderV3<TrackingIOInfoOuterClass.TrackingIOInfo, TrackingIOInfoOuterClass.TrackingIOInfo.Builder, TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder> getTrackingIoInfoFieldBuilder() {
                if (this.trackingIoInfoBuilder_ == null) {
                    this.trackingIoInfoBuilder_ = new SingleFieldBuilderV3<>(getTrackingIoInfo(), getParentForChildren(), isClean());
                    this.trackingIoInfo_ = null;
                }
                return this.trackingIoInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public boolean getIsTransfer() {
                return this.isTransfer_;
            }

            public Builder setIsTransfer(boolean value) {
                this.isTransfer_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsTransfer() {
                this.isTransfer_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getSecurityLibraryVersion() {
                Object ref = this.securityLibraryVersion_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.securityLibraryVersion_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getSecurityLibraryVersionBytes() {
                Object ref = this.securityLibraryVersion_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.securityLibraryVersion_ = b;
                return b;
            }

            public Builder setSecurityLibraryVersion(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.securityLibraryVersion_ = value;
                onChanged();
                return this;
            }

            public Builder clearSecurityLibraryVersion() {
                this.securityLibraryVersion_ = PlayerLoginReq.getDefaultInstance().getSecurityLibraryVersion();
                onChanged();
                return this;
            }

            public Builder setSecurityLibraryVersionBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.securityLibraryVersion_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getClientVersion() {
                Object ref = this.clientVersion_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.clientVersion_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getClientVersionBytes() {
                Object ref = this.clientVersion_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientVersion_ = b;
                return b;
            }

            public Builder setClientVersion(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientVersion_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientVersion() {
                this.clientVersion_ = PlayerLoginReq.getDefaultInstance().getClientVersion();
                onChanged();
                return this;
            }

            public Builder setClientVersionBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.clientVersion_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public boolean getIsGuest() {
                return this.isGuest_;
            }

            public Builder setIsGuest(boolean value) {
                this.isGuest_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsGuest() {
                this.isGuest_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getSystemVersion() {
                Object ref = this.systemVersion_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.systemVersion_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getSystemVersionBytes() {
                Object ref = this.systemVersion_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.systemVersion_ = b;
                return b;
            }

            public Builder setSystemVersion(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.systemVersion_ = value;
                onChanged();
                return this;
            }

            public Builder clearSystemVersion() {
                this.systemVersion_ = PlayerLoginReq.getDefaultInstance().getSystemVersion();
                onChanged();
                return this;
            }

            public Builder setSystemVersionBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.systemVersion_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public int getTargetHomeOwnerUid() {
                return this.targetHomeOwnerUid_;
            }

            public Builder setTargetHomeOwnerUid(int value) {
                this.targetHomeOwnerUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetHomeOwnerUid() {
                this.targetHomeOwnerUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getPsnId() {
                Object ref = this.psnId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.psnId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
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
                this.psnId_ = PlayerLoginReq.getDefaultInstance().getPsnId();
                onChanged();
                return this;
            }

            public Builder setPsnIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.psnId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getSecurityCmdReply() {
                return this.securityCmdReply_;
            }

            public Builder setSecurityCmdReply(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.securityCmdReply_ = value;
                onChanged();
                return this;
            }

            public Builder clearSecurityCmdReply() {
                this.securityCmdReply_ = PlayerLoginReq.getDefaultInstance().getSecurityCmdReply();
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public int getUnk3300OFFHPAFIFGD() {
                return this.unk3300OFFHPAFIFGD_;
            }

            public Builder setUnk3300OFFHPAFIFGD(int value) {
                this.unk3300OFFHPAFIFGD_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300OFFHPAFIFGD() {
                this.unk3300OFFHPAFIFGD_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public long getLoginRand() {
                return this.loginRand_;
            }

            public Builder setLoginRand(long value) {
                this.loginRand_ = value;
                onChanged();
                return this;
            }

            public Builder clearLoginRand() {
                this.loginRand_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public boolean hasAdjustTrackingInfo() {
                return (this.adjustTrackingInfoBuilder_ == null && this.adjustTrackingInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public AdjustTrackingInfoOuterClass.AdjustTrackingInfo getAdjustTrackingInfo() {
                if (this.adjustTrackingInfoBuilder_ == null) {
                    return this.adjustTrackingInfo_ == null ? AdjustTrackingInfoOuterClass.AdjustTrackingInfo.getDefaultInstance() : this.adjustTrackingInfo_;
                }
                return this.adjustTrackingInfoBuilder_.getMessage();
            }

            public Builder setAdjustTrackingInfo(AdjustTrackingInfoOuterClass.AdjustTrackingInfo value) {
                if (this.adjustTrackingInfoBuilder_ != null) {
                    this.adjustTrackingInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.adjustTrackingInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAdjustTrackingInfo(AdjustTrackingInfoOuterClass.AdjustTrackingInfo.Builder builderForValue) {
                if (this.adjustTrackingInfoBuilder_ == null) {
                    this.adjustTrackingInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.adjustTrackingInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAdjustTrackingInfo(AdjustTrackingInfoOuterClass.AdjustTrackingInfo value) {
                if (this.adjustTrackingInfoBuilder_ == null) {
                    if (this.adjustTrackingInfo_ != null) {
                        this.adjustTrackingInfo_ = AdjustTrackingInfoOuterClass.AdjustTrackingInfo.newBuilder(this.adjustTrackingInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.adjustTrackingInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.adjustTrackingInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAdjustTrackingInfo() {
                if (this.adjustTrackingInfoBuilder_ == null) {
                    this.adjustTrackingInfo_ = null;
                    onChanged();
                } else {
                    this.adjustTrackingInfo_ = null;
                    this.adjustTrackingInfoBuilder_ = null;
                }
                return this;
            }

            public AdjustTrackingInfoOuterClass.AdjustTrackingInfo.Builder getAdjustTrackingInfoBuilder() {
                onChanged();
                return getAdjustTrackingInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder getAdjustTrackingInfoOrBuilder() {
                if (this.adjustTrackingInfoBuilder_ != null) {
                    return this.adjustTrackingInfoBuilder_.getMessageOrBuilder();
                }
                return this.adjustTrackingInfo_ == null ? AdjustTrackingInfoOuterClass.AdjustTrackingInfo.getDefaultInstance() : this.adjustTrackingInfo_;
            }

            private SingleFieldBuilderV3<AdjustTrackingInfoOuterClass.AdjustTrackingInfo, AdjustTrackingInfoOuterClass.AdjustTrackingInfo.Builder, AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder> getAdjustTrackingInfoFieldBuilder() {
                if (this.adjustTrackingInfoBuilder_ == null) {
                    this.adjustTrackingInfoBuilder_ = new SingleFieldBuilderV3<>(getAdjustTrackingInfo(), getParentForChildren(), isClean());
                    this.adjustTrackingInfo_ = null;
                }
                return this.adjustTrackingInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getEnvironmentErrorCode() {
                return this.environmentErrorCode_;
            }

            public Builder setEnvironmentErrorCode(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.environmentErrorCode_ = value;
                onChanged();
                return this;
            }

            public Builder clearEnvironmentErrorCode() {
                this.environmentErrorCode_ = PlayerLoginReq.getDefaultInstance().getEnvironmentErrorCode();
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public int getPlatformType() {
                return this.platformType_;
            }

            public Builder setPlatformType(int value) {
                this.platformType_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlatformType() {
                this.platformType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public String getCps() {
                Object ref = this.cps_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.cps_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
            public ByteString getCpsBytes() {
                Object ref = this.cps_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.cps_ = b;
                return b;
            }

            public Builder setCps(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.cps_ = value;
                onChanged();
                return this;
            }

            public Builder clearCps() {
                this.cps_ = PlayerLoginReq.getDefaultInstance().getCps();
                onChanged();
                return this;
            }

            public Builder setCpsBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerLoginReq.checkByteStringIsUtf8(value);
                this.cps_ = value;
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

        public static PlayerLoginReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerLoginReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerLoginReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerLoginReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AdjustTrackingInfoOuterClass.getDescriptor();
        TrackingIOInfoOuterClass.getDescriptor();
    }
}
