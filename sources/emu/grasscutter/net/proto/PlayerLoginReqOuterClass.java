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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerLoginReqOuterClass.class */
public final class PlayerLoginReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014PlayerLoginReq.proto\u001a\u0014TrackingIOInfo.proto\u001a\u0018AdjustTrackingInfo.proto\"ï\u0007\n\u000ePlayerLoginReq\u0012\r\n\u0005token\u0018\u0006 \u0001(\t\u0012\u001c\n\u0013Unk3300_NDLANBEIGEG\u0018Ã\u0002 \u0001(\r\u0012\u0011\n\ttargetUid\u0018\u0004 \u0001(\r\u0012\u001e\n\u0015checksumClientVersion\u0018Ê\r \u0001(\t\u0012\u0012\n\naccountUid\u0018\t \u0001(\t\u0012\u0010\n\bisEditor\u0018\r \u0001(\b\u0012\u0011\n\bbirthday\u0018\n \u0001(\t\u0012\u0014\n\fextraBinData\u0018N \u0001(\f\u0012\u0013\n\u000bregPlatform\u0018w \u0001(\r\u0012\u000e\n\u0005gmUid\u0018ö\u0001 \u0001(\r\u0012\u0011\n\bchecksum\u0018³\r \u0001(\t\u0012\u0014\n\fplatformType\u0018\f \u0001(\r\u0012(\n\u000etrackingIoInfo\u0018Æ\u0005 \u0001(\u000b2\u000f.TrackingIOInfo\u0012\u001c\n\u0013Unk3300_OFFHPAFIFGD\u0018â\r \u0001(\r\u0012\u0012\n\ndeviceInfo\u0018\u000e \u0001(\t\u0012\u001b\n\u0012targetHomeOwnerUid\u0018Ø\u0001 \u0001(\r\u0012\u0010\n\bplatform\u0018\u0002 \u0001(\t\u0012\u0012\n\tchannelId\u0018Ä\u0002 \u0001(\r\u0012\u0014\n\u000bcountryCode\u0018Ð\f \u0001(\t\u0012\u0011\n\tloginRand\u0018\b \u0001(\u0004\u0012\u0010\n\bonlineId\u00186 \u0001(\t\u0012\u0015\n\fsubChannelId\u0018­\r \u0001(\r\u0012\u0012\n\ndeviceUuid\u0018\u000f \u0001(\t\u0012\u001c\n\u0013Unk3300_OOBHAIIIPHH\u0018è\u000f \u0001(\r\u0012\u001a\n\u0011clientVerisonHash\u0018å\r \u0001(\t\u00120\n\u0012adjustTrackingInfo\u0018º\u0003 \u0001(\u000b2\u0013.AdjustTrackingInfo\u0012\u0013\n\u000baccountType\u0018\u0007 \u0001(\r\u0012\u000e\n\u0005psnId\u0018 \f \u0001(\t\u0012\f\n\u0003tag\u0018Ç\t \u0001(\r\u0012\u001c\n\u0013Unk3300_PMGFBMJNNCL\u0018ò\n \u0001(\r\u0012\u0015\n\rsystemVersion\u0018\u0003 \u0001(\t\u0012\u000f\n\u0007isGuest\u0018\n \u0001(\b\u0012\u0015\n\rclientVersion\u0018\u000b \u0001(\t\u0012\u0013\n\nisTransfer\u0018õ\u000f \u0001(\b\u0012\u001d\n\u0014environmentErrorCode\u0018÷\u0007 \u0001(\f\u0012\u0012\n\ndeviceName\u0018\u0001 \u0001(\t\u0012\u001b\n\u0012securityLibraryMd5\u0018ú\u0002 \u0001(\t\u0012\u0014\n\flanguageType\u0018\u0005 \u0001(\r\u0012\u0019\n\u0010securityCmdReply\u0018\u0007 \u0001(\f\u0012\u001f\n\u0016securityLibraryVersion\u0018¬\u0005 \u0001(\t\u0012\u001a\n\u0011clientDataVersion\u0018ª\u0003 \u0001(\r\u0012\f\n\u0003cps\u0018µ\u0006 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TrackingIOInfoOuterClass.getDescriptor(), AdjustTrackingInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerLoginReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerLoginReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerLoginReq_descriptor, new String[]{"Token", "Unk3300NDLANBEIGEG", "TargetUid", "ChecksumClientVersion", "AccountUid", "IsEditor", "Birthday", "ExtraBinData", "RegPlatform", "GmUid", "Checksum", "PlatformType", "TrackingIoInfo", "Unk3300OFFHPAFIFGD", "DeviceInfo", "TargetHomeOwnerUid", "Platform", "ChannelId", "CountryCode", "LoginRand", "OnlineId", "SubChannelId", "DeviceUuid", "Unk3300OOBHAIIIPHH", "ClientVerisonHash", "AdjustTrackingInfo", "AccountType", "PsnId", "Tag", "Unk3300PMGFBMJNNCL", "SystemVersion", "IsGuest", "ClientVersion", "IsTransfer", "EnvironmentErrorCode", "DeviceName", "SecurityLibraryMd5", "LanguageType", "SecurityCmdReply", "SecurityLibraryVersion", "ClientDataVersion", "Cps"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerLoginReqOuterClass$PlayerLoginReqOrBuilder.class */
    public interface PlayerLoginReqOrBuilder extends MessageOrBuilder {
        String getToken();

        ByteString getTokenBytes();

        int getUnk3300NDLANBEIGEG();

        int getTargetUid();

        String getChecksumClientVersion();

        ByteString getChecksumClientVersionBytes();

        String getAccountUid();

        ByteString getAccountUidBytes();

        boolean getIsEditor();

        String getBirthday();

        ByteString getBirthdayBytes();

        ByteString getExtraBinData();

        int getRegPlatform();

        int getGmUid();

        String getChecksum();

        ByteString getChecksumBytes();

        int getPlatformType();

        boolean hasTrackingIoInfo();

        TrackingIOInfoOuterClass.TrackingIOInfo getTrackingIoInfo();

        TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder getTrackingIoInfoOrBuilder();

        int getUnk3300OFFHPAFIFGD();

        String getDeviceInfo();

        ByteString getDeviceInfoBytes();

        int getTargetHomeOwnerUid();

        String getPlatform();

        ByteString getPlatformBytes();

        int getChannelId();

        String getCountryCode();

        ByteString getCountryCodeBytes();

        long getLoginRand();

        String getOnlineId();

        ByteString getOnlineIdBytes();

        int getSubChannelId();

        String getDeviceUuid();

        ByteString getDeviceUuidBytes();

        int getUnk3300OOBHAIIIPHH();

        String getClientVerisonHash();

        ByteString getClientVerisonHashBytes();

        boolean hasAdjustTrackingInfo();

        AdjustTrackingInfoOuterClass.AdjustTrackingInfo getAdjustTrackingInfo();

        AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder getAdjustTrackingInfoOrBuilder();

        int getAccountType();

        String getPsnId();

        ByteString getPsnIdBytes();

        int getTag();

        int getUnk3300PMGFBMJNNCL();

        String getSystemVersion();

        ByteString getSystemVersionBytes();

        boolean getIsGuest();

        String getClientVersion();

        ByteString getClientVersionBytes();

        boolean getIsTransfer();

        ByteString getEnvironmentErrorCode();

        String getDeviceName();

        ByteString getDeviceNameBytes();

        String getSecurityLibraryMd5();

        ByteString getSecurityLibraryMd5Bytes();

        int getLanguageType();

        ByteString getSecurityCmdReply();

        String getSecurityLibraryVersion();

        ByteString getSecurityLibraryVersionBytes();

        int getClientDataVersion();

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
        public static final int TOKEN_FIELD_NUMBER = 6;
        private volatile Object token_;
        public static final int UNK3300_NDLANBEIGEG_FIELD_NUMBER = 323;
        private int unk3300NDLANBEIGEG_;
        public static final int TARGETUID_FIELD_NUMBER = 4;
        private int targetUid_;
        public static final int CHECKSUMCLIENTVERSION_FIELD_NUMBER = 1738;
        private volatile Object checksumClientVersion_;
        public static final int ACCOUNTUID_FIELD_NUMBER = 9;
        private volatile Object accountUid_;
        public static final int ISEDITOR_FIELD_NUMBER = 13;
        private boolean isEditor_;
        public static final int BIRTHDAY_FIELD_NUMBER = 1280;
        private volatile Object birthday_;
        public static final int EXTRABINDATA_FIELD_NUMBER = 78;
        private ByteString extraBinData_;
        public static final int REGPLATFORM_FIELD_NUMBER = 119;
        private int regPlatform_;
        public static final int GMUID_FIELD_NUMBER = 246;
        private int gmUid_;
        public static final int CHECKSUM_FIELD_NUMBER = 1715;
        private volatile Object checksum_;
        public static final int PLATFORMTYPE_FIELD_NUMBER = 12;
        private int platformType_;
        public static final int TRACKINGIOINFO_FIELD_NUMBER = 710;
        private TrackingIOInfoOuterClass.TrackingIOInfo trackingIoInfo_;
        public static final int UNK3300_OFFHPAFIFGD_FIELD_NUMBER = 1762;
        private int unk3300OFFHPAFIFGD_;
        public static final int DEVICEINFO_FIELD_NUMBER = 14;
        private volatile Object deviceInfo_;
        public static final int TARGETHOMEOWNERUID_FIELD_NUMBER = 216;
        private int targetHomeOwnerUid_;
        public static final int PLATFORM_FIELD_NUMBER = 2;
        private volatile Object platform_;
        public static final int CHANNELID_FIELD_NUMBER = 324;
        private int channelId_;
        public static final int COUNTRYCODE_FIELD_NUMBER = 1616;
        private volatile Object countryCode_;
        public static final int LOGINRAND_FIELD_NUMBER = 8;
        private long loginRand_;
        public static final int ONLINEID_FIELD_NUMBER = 54;
        private volatile Object onlineId_;
        public static final int SUBCHANNELID_FIELD_NUMBER = 1709;
        private int subChannelId_;
        public static final int DEVICEUUID_FIELD_NUMBER = 15;
        private volatile Object deviceUuid_;
        public static final int UNK3300_OOBHAIIIPHH_FIELD_NUMBER = 2024;
        private int unk3300OOBHAIIIPHH_;
        public static final int CLIENTVERISONHASH_FIELD_NUMBER = 1765;
        private volatile Object clientVerisonHash_;
        public static final int ADJUSTTRACKINGINFO_FIELD_NUMBER = 442;
        private AdjustTrackingInfoOuterClass.AdjustTrackingInfo adjustTrackingInfo_;
        public static final int ACCOUNTTYPE_FIELD_NUMBER = 7;
        private int accountType_;
        public static final int PSNID_FIELD_NUMBER = 1568;
        private volatile Object psnId_;
        public static final int TAG_FIELD_NUMBER = 1223;
        private int tag_;
        public static final int UNK3300_PMGFBMJNNCL_FIELD_NUMBER = 1394;
        private int unk3300PMGFBMJNNCL_;
        public static final int SYSTEMVERSION_FIELD_NUMBER = 3;
        private volatile Object systemVersion_;
        public static final int ISGUEST_FIELD_NUMBER = 10;
        private boolean isGuest_;
        public static final int CLIENTVERSION_FIELD_NUMBER = 11;
        private volatile Object clientVersion_;
        public static final int ISTRANSFER_FIELD_NUMBER = 2037;
        private boolean isTransfer_;
        public static final int ENVIRONMENTERRORCODE_FIELD_NUMBER = 1015;
        private ByteString environmentErrorCode_;
        public static final int DEVICENAME_FIELD_NUMBER = 1;
        private volatile Object deviceName_;
        public static final int SECURITYLIBRARYMD5_FIELD_NUMBER = 378;
        private volatile Object securityLibraryMd5_;
        public static final int LANGUAGETYPE_FIELD_NUMBER = 5;
        private int languageType_;
        public static final int SECURITYCMDREPLY_FIELD_NUMBER = 907;
        private ByteString securityCmdReply_;
        public static final int SECURITYLIBRARYVERSION_FIELD_NUMBER = 684;
        private volatile Object securityLibraryVersion_;
        public static final int CLIENTDATAVERSION_FIELD_NUMBER = 426;
        private int clientDataVersion_;
        public static final int CPS_FIELD_NUMBER = 821;
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
            this.token_ = "";
            this.checksumClientVersion_ = "";
            this.accountUid_ = "";
            this.birthday_ = "";
            this.extraBinData_ = ByteString.EMPTY;
            this.checksum_ = "";
            this.deviceInfo_ = "";
            this.platform_ = "";
            this.countryCode_ = "";
            this.onlineId_ = "";
            this.deviceUuid_ = "";
            this.clientVerisonHash_ = "";
            this.psnId_ = "";
            this.systemVersion_ = "";
            this.clientVersion_ = "";
            this.environmentErrorCode_ = ByteString.EMPTY;
            this.deviceName_ = "";
            this.securityLibraryMd5_ = "";
            this.securityCmdReply_ = ByteString.EMPTY;
            this.securityLibraryVersion_ = "";
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
                                case 10:
                                    this.deviceName_ = input.readStringRequireUtf8();
                                    break;
                                case 18:
                                    this.platform_ = input.readStringRequireUtf8();
                                    break;
                                case 26:
                                    this.systemVersion_ = input.readStringRequireUtf8();
                                    break;
                                case 32:
                                    this.targetUid_ = input.readUInt32();
                                    break;
                                case 40:
                                    this.languageType_ = input.readUInt32();
                                    break;
                                case 50:
                                    this.token_ = input.readStringRequireUtf8();
                                    break;
                                case 56:
                                    this.accountType_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.loginRand_ = input.readUInt64();
                                    break;
                                case 74:
                                    this.accountUid_ = input.readStringRequireUtf8();
                                    break;
                                case 80:
                                    this.isGuest_ = input.readBool();
                                    break;
                                case 90:
                                    this.clientVersion_ = input.readStringRequireUtf8();
                                    break;
                                case 96:
                                    this.platformType_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.isEditor_ = input.readBool();
                                    break;
                                case 114:
                                    this.deviceInfo_ = input.readStringRequireUtf8();
                                    break;
                                case 122:
                                    this.deviceUuid_ = input.readStringRequireUtf8();
                                    break;
                                case 434:
                                    this.onlineId_ = input.readStringRequireUtf8();
                                    break;
                                case 626:
                                    this.extraBinData_ = input.readBytes();
                                    break;
                                case PacketOpcodes.DungeonCandidateTeamReplyInviteRsp:
                                    this.regPlatform_ = input.readUInt32();
                                    break;
                                case 1728:
                                    this.targetHomeOwnerUid_ = input.readUInt32();
                                    break;
                                case 1968:
                                    this.gmUid_ = input.readUInt32();
                                    break;
                                case 2584:
                                    this.unk3300NDLANBEIGEG_ = input.readUInt32();
                                    break;
                                case 2592:
                                    this.channelId_ = input.readUInt32();
                                    break;
                                case 3026:
                                    this.securityLibraryMd5_ = input.readStringRequireUtf8();
                                    break;
                                case 3408:
                                    this.clientDataVersion_ = input.readUInt32();
                                    break;
                                case PacketOpcodes.PlayerRoutineDataNotify:
                                    AdjustTrackingInfoOuterClass.AdjustTrackingInfo.Builder subBuilder = this.adjustTrackingInfo_ != null ? this.adjustTrackingInfo_.toBuilder() : null;
                                    this.adjustTrackingInfo_ = (AdjustTrackingInfoOuterClass.AdjustTrackingInfo) input.readMessage(AdjustTrackingInfoOuterClass.AdjustTrackingInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.adjustTrackingInfo_);
                                        this.adjustTrackingInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case PacketOpcodes.DraftGuestReplyInviteReq:
                                    this.securityLibraryVersion_ = input.readStringRequireUtf8();
                                    break;
                                case 5682:
                                    TrackingIOInfoOuterClass.TrackingIOInfo.Builder subBuilder2 = this.trackingIoInfo_ != null ? this.trackingIoInfo_.toBuilder() : null;
                                    this.trackingIoInfo_ = (TrackingIOInfoOuterClass.TrackingIOInfo) input.readMessage(TrackingIOInfoOuterClass.TrackingIOInfo.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.trackingIoInfo_);
                                        this.trackingIoInfo_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                case 6570:
                                    this.cps_ = input.readStringRequireUtf8();
                                    break;
                                case 7258:
                                    this.securityCmdReply_ = input.readBytes();
                                    break;
                                case 8122:
                                    this.environmentErrorCode_ = input.readBytes();
                                    break;
                                case RET_HOME_PICTURE_FRAME_COOP_CG_NOT_UNLOCK_VALUE:
                                    this.tag_ = input.readUInt32();
                                    break;
                                case 10242:
                                    this.birthday_ = input.readStringRequireUtf8();
                                    break;
                                case RET_UGC_DATA_NOT_FOUND_VALUE:
                                    this.unk3300PMGFBMJNNCL_ = input.readUInt32();
                                    break;
                                case 12546:
                                    this.psnId_ = input.readStringRequireUtf8();
                                    break;
                                case 12930:
                                    this.countryCode_ = input.readStringRequireUtf8();
                                    break;
                                case 13672:
                                    this.subChannelId_ = input.readUInt32();
                                    break;
                                case 13722:
                                    this.checksum_ = input.readStringRequireUtf8();
                                    break;
                                case 13906:
                                    this.checksumClientVersion_ = input.readStringRequireUtf8();
                                    break;
                                case 14096:
                                    this.unk3300OFFHPAFIFGD_ = input.readUInt32();
                                    break;
                                case 14122:
                                    this.clientVerisonHash_ = input.readStringRequireUtf8();
                                    break;
                                case 16192:
                                    this.unk3300OOBHAIIIPHH_ = input.readUInt32();
                                    break;
                                case 16296:
                                    this.isTransfer_ = input.readBool();
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
        public int getUnk3300NDLANBEIGEG() {
            return this.unk3300NDLANBEIGEG_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getTargetUid() {
            return this.targetUid_;
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
        public boolean getIsEditor() {
            return this.isEditor_;
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
        public ByteString getExtraBinData() {
            return this.extraBinData_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getRegPlatform() {
            return this.regPlatform_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getGmUid() {
            return this.gmUid_;
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
        public int getPlatformType() {
            return this.platformType_;
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
        public int getUnk3300OFFHPAFIFGD() {
            return this.unk3300OFFHPAFIFGD_;
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
        public int getTargetHomeOwnerUid() {
            return this.targetHomeOwnerUid_;
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
        public int getChannelId() {
            return this.channelId_;
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
        public long getLoginRand() {
            return this.loginRand_;
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
        public int getSubChannelId() {
            return this.subChannelId_;
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
        public int getUnk3300OOBHAIIIPHH() {
            return this.unk3300OOBHAIIIPHH_;
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
        public int getAccountType() {
            return this.accountType_;
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
        public int getTag() {
            return this.tag_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public int getUnk3300PMGFBMJNNCL() {
            return this.unk3300PMGFBMJNNCL_;
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
        public boolean getIsGuest() {
            return this.isGuest_;
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
        public boolean getIsTransfer() {
            return this.isTransfer_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getEnvironmentErrorCode() {
            return this.environmentErrorCode_;
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
        public int getLanguageType() {
            return this.languageType_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLoginReqOuterClass.PlayerLoginReqOrBuilder
        public ByteString getSecurityCmdReply() {
            return this.securityCmdReply_;
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
        public int getClientDataVersion() {
            return this.clientDataVersion_;
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
            if (!GeneratedMessageV3.isStringEmpty(this.deviceName_)) {
                GeneratedMessageV3.writeString(output, 1, this.deviceName_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.platform_)) {
                GeneratedMessageV3.writeString(output, 2, this.platform_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.systemVersion_)) {
                GeneratedMessageV3.writeString(output, 3, this.systemVersion_);
            }
            if (this.targetUid_ != 0) {
                output.writeUInt32(4, this.targetUid_);
            }
            if (this.languageType_ != 0) {
                output.writeUInt32(5, this.languageType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.token_)) {
                GeneratedMessageV3.writeString(output, 6, this.token_);
            }
            if (this.accountType_ != 0) {
                output.writeUInt32(7, this.accountType_);
            }
            if (this.loginRand_ != 0) {
                output.writeUInt64(8, this.loginRand_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.accountUid_)) {
                GeneratedMessageV3.writeString(output, 9, this.accountUid_);
            }
            if (this.isGuest_) {
                output.writeBool(10, this.isGuest_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientVersion_)) {
                GeneratedMessageV3.writeString(output, 11, this.clientVersion_);
            }
            if (this.platformType_ != 0) {
                output.writeUInt32(12, this.platformType_);
            }
            if (this.isEditor_) {
                output.writeBool(13, this.isEditor_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.deviceInfo_)) {
                GeneratedMessageV3.writeString(output, 14, this.deviceInfo_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.deviceUuid_)) {
                GeneratedMessageV3.writeString(output, 15, this.deviceUuid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.onlineId_)) {
                GeneratedMessageV3.writeString(output, 54, this.onlineId_);
            }
            if (!this.extraBinData_.isEmpty()) {
                output.writeBytes(78, this.extraBinData_);
            }
            if (this.regPlatform_ != 0) {
                output.writeUInt32(119, this.regPlatform_);
            }
            if (this.targetHomeOwnerUid_ != 0) {
                output.writeUInt32(216, this.targetHomeOwnerUid_);
            }
            if (this.gmUid_ != 0) {
                output.writeUInt32(246, this.gmUid_);
            }
            if (this.unk3300NDLANBEIGEG_ != 0) {
                output.writeUInt32(323, this.unk3300NDLANBEIGEG_);
            }
            if (this.channelId_ != 0) {
                output.writeUInt32(324, this.channelId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.securityLibraryMd5_)) {
                GeneratedMessageV3.writeString(output, 378, this.securityLibraryMd5_);
            }
            if (this.clientDataVersion_ != 0) {
                output.writeUInt32(426, this.clientDataVersion_);
            }
            if (this.adjustTrackingInfo_ != null) {
                output.writeMessage(442, getAdjustTrackingInfo());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.securityLibraryVersion_)) {
                GeneratedMessageV3.writeString(output, 684, this.securityLibraryVersion_);
            }
            if (this.trackingIoInfo_ != null) {
                output.writeMessage(TRACKINGIOINFO_FIELD_NUMBER, getTrackingIoInfo());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.cps_)) {
                GeneratedMessageV3.writeString(output, 821, this.cps_);
            }
            if (!this.securityCmdReply_.isEmpty()) {
                output.writeBytes(907, this.securityCmdReply_);
            }
            if (!this.environmentErrorCode_.isEmpty()) {
                output.writeBytes(1015, this.environmentErrorCode_);
            }
            if (this.tag_ != 0) {
                output.writeUInt32(1223, this.tag_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.birthday_)) {
                GeneratedMessageV3.writeString(output, 1280, this.birthday_);
            }
            if (this.unk3300PMGFBMJNNCL_ != 0) {
                output.writeUInt32(UNK3300_PMGFBMJNNCL_FIELD_NUMBER, this.unk3300PMGFBMJNNCL_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.psnId_)) {
                GeneratedMessageV3.writeString(output, PSNID_FIELD_NUMBER, this.psnId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.countryCode_)) {
                GeneratedMessageV3.writeString(output, COUNTRYCODE_FIELD_NUMBER, this.countryCode_);
            }
            if (this.subChannelId_ != 0) {
                output.writeUInt32(1709, this.subChannelId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.checksum_)) {
                GeneratedMessageV3.writeString(output, 1715, this.checksum_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.checksumClientVersion_)) {
                GeneratedMessageV3.writeString(output, CHECKSUMCLIENTVERSION_FIELD_NUMBER, this.checksumClientVersion_);
            }
            if (this.unk3300OFFHPAFIFGD_ != 0) {
                output.writeUInt32(UNK3300_OFFHPAFIFGD_FIELD_NUMBER, this.unk3300OFFHPAFIFGD_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientVerisonHash_)) {
                GeneratedMessageV3.writeString(output, 1765, this.clientVerisonHash_);
            }
            if (this.unk3300OOBHAIIIPHH_ != 0) {
                output.writeUInt32(UNK3300_OOBHAIIIPHH_FIELD_NUMBER, this.unk3300OOBHAIIIPHH_);
            }
            if (this.isTransfer_) {
                output.writeBool(2037, this.isTransfer_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.deviceName_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(1, this.deviceName_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.platform_)) {
                size2 += GeneratedMessageV3.computeStringSize(2, this.platform_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.systemVersion_)) {
                size2 += GeneratedMessageV3.computeStringSize(3, this.systemVersion_);
            }
            if (this.targetUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.targetUid_);
            }
            if (this.languageType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.languageType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.token_)) {
                size2 += GeneratedMessageV3.computeStringSize(6, this.token_);
            }
            if (this.accountType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.accountType_);
            }
            if (this.loginRand_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(8, this.loginRand_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.accountUid_)) {
                size2 += GeneratedMessageV3.computeStringSize(9, this.accountUid_);
            }
            if (this.isGuest_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.isGuest_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientVersion_)) {
                size2 += GeneratedMessageV3.computeStringSize(11, this.clientVersion_);
            }
            if (this.platformType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.platformType_);
            }
            if (this.isEditor_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isEditor_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.deviceInfo_)) {
                size2 += GeneratedMessageV3.computeStringSize(14, this.deviceInfo_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.deviceUuid_)) {
                size2 += GeneratedMessageV3.computeStringSize(15, this.deviceUuid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.onlineId_)) {
                size2 += GeneratedMessageV3.computeStringSize(54, this.onlineId_);
            }
            if (!this.extraBinData_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(78, this.extraBinData_);
            }
            if (this.regPlatform_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(119, this.regPlatform_);
            }
            if (this.targetHomeOwnerUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(216, this.targetHomeOwnerUid_);
            }
            if (this.gmUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(246, this.gmUid_);
            }
            if (this.unk3300NDLANBEIGEG_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(323, this.unk3300NDLANBEIGEG_);
            }
            if (this.channelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(324, this.channelId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.securityLibraryMd5_)) {
                size2 += GeneratedMessageV3.computeStringSize(378, this.securityLibraryMd5_);
            }
            if (this.clientDataVersion_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(426, this.clientDataVersion_);
            }
            if (this.adjustTrackingInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(442, getAdjustTrackingInfo());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.securityLibraryVersion_)) {
                size2 += GeneratedMessageV3.computeStringSize(684, this.securityLibraryVersion_);
            }
            if (this.trackingIoInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(TRACKINGIOINFO_FIELD_NUMBER, getTrackingIoInfo());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.cps_)) {
                size2 += GeneratedMessageV3.computeStringSize(821, this.cps_);
            }
            if (!this.securityCmdReply_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(907, this.securityCmdReply_);
            }
            if (!this.environmentErrorCode_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(1015, this.environmentErrorCode_);
            }
            if (this.tag_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(1223, this.tag_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.birthday_)) {
                size2 += GeneratedMessageV3.computeStringSize(1280, this.birthday_);
            }
            if (this.unk3300PMGFBMJNNCL_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(UNK3300_PMGFBMJNNCL_FIELD_NUMBER, this.unk3300PMGFBMJNNCL_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.psnId_)) {
                size2 += GeneratedMessageV3.computeStringSize(PSNID_FIELD_NUMBER, this.psnId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.countryCode_)) {
                size2 += GeneratedMessageV3.computeStringSize(COUNTRYCODE_FIELD_NUMBER, this.countryCode_);
            }
            if (this.subChannelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(1709, this.subChannelId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.checksum_)) {
                size2 += GeneratedMessageV3.computeStringSize(1715, this.checksum_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.checksumClientVersion_)) {
                size2 += GeneratedMessageV3.computeStringSize(CHECKSUMCLIENTVERSION_FIELD_NUMBER, this.checksumClientVersion_);
            }
            if (this.unk3300OFFHPAFIFGD_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(UNK3300_OFFHPAFIFGD_FIELD_NUMBER, this.unk3300OFFHPAFIFGD_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientVerisonHash_)) {
                size2 += GeneratedMessageV3.computeStringSize(1765, this.clientVerisonHash_);
            }
            if (this.unk3300OOBHAIIIPHH_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(UNK3300_OOBHAIIIPHH_FIELD_NUMBER, this.unk3300OOBHAIIIPHH_);
            }
            if (this.isTransfer_) {
                size2 += CodedOutputStream.computeBoolSize(2037, this.isTransfer_);
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
            if (!getToken().equals(other.getToken()) || getUnk3300NDLANBEIGEG() != other.getUnk3300NDLANBEIGEG() || getTargetUid() != other.getTargetUid() || !getChecksumClientVersion().equals(other.getChecksumClientVersion()) || !getAccountUid().equals(other.getAccountUid()) || getIsEditor() != other.getIsEditor() || !getBirthday().equals(other.getBirthday()) || !getExtraBinData().equals(other.getExtraBinData()) || getRegPlatform() != other.getRegPlatform() || getGmUid() != other.getGmUid() || !getChecksum().equals(other.getChecksum()) || getPlatformType() != other.getPlatformType() || hasTrackingIoInfo() != other.hasTrackingIoInfo()) {
                return false;
            }
            if ((!hasTrackingIoInfo() || getTrackingIoInfo().equals(other.getTrackingIoInfo())) && getUnk3300OFFHPAFIFGD() == other.getUnk3300OFFHPAFIFGD() && getDeviceInfo().equals(other.getDeviceInfo()) && getTargetHomeOwnerUid() == other.getTargetHomeOwnerUid() && getPlatform().equals(other.getPlatform()) && getChannelId() == other.getChannelId() && getCountryCode().equals(other.getCountryCode()) && getLoginRand() == other.getLoginRand() && getOnlineId().equals(other.getOnlineId()) && getSubChannelId() == other.getSubChannelId() && getDeviceUuid().equals(other.getDeviceUuid()) && getUnk3300OOBHAIIIPHH() == other.getUnk3300OOBHAIIIPHH() && getClientVerisonHash().equals(other.getClientVerisonHash()) && hasAdjustTrackingInfo() == other.hasAdjustTrackingInfo()) {
                return (!hasAdjustTrackingInfo() || getAdjustTrackingInfo().equals(other.getAdjustTrackingInfo())) && getAccountType() == other.getAccountType() && getPsnId().equals(other.getPsnId()) && getTag() == other.getTag() && getUnk3300PMGFBMJNNCL() == other.getUnk3300PMGFBMJNNCL() && getSystemVersion().equals(other.getSystemVersion()) && getIsGuest() == other.getIsGuest() && getClientVersion().equals(other.getClientVersion()) && getIsTransfer() == other.getIsTransfer() && getEnvironmentErrorCode().equals(other.getEnvironmentErrorCode()) && getDeviceName().equals(other.getDeviceName()) && getSecurityLibraryMd5().equals(other.getSecurityLibraryMd5()) && getLanguageType() == other.getLanguageType() && getSecurityCmdReply().equals(other.getSecurityCmdReply()) && getSecurityLibraryVersion().equals(other.getSecurityLibraryVersion()) && getClientDataVersion() == other.getClientDataVersion() && getCps().equals(other.getCps()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getToken().hashCode())) + 323)) + getUnk3300NDLANBEIGEG())) + 4)) + getTargetUid())) + CHECKSUMCLIENTVERSION_FIELD_NUMBER)) + getChecksumClientVersion().hashCode())) + 9)) + getAccountUid().hashCode())) + 13)) + Internal.hashBoolean(getIsEditor()))) + 1280)) + getBirthday().hashCode())) + 78)) + getExtraBinData().hashCode())) + 119)) + getRegPlatform())) + 246)) + getGmUid())) + 1715)) + getChecksum().hashCode())) + 12)) + getPlatformType();
            if (hasTrackingIoInfo()) {
                hash = (53 * ((37 * hash) + TRACKINGIOINFO_FIELD_NUMBER)) + getTrackingIoInfo().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + UNK3300_OFFHPAFIFGD_FIELD_NUMBER)) + getUnk3300OFFHPAFIFGD())) + 14)) + getDeviceInfo().hashCode())) + 216)) + getTargetHomeOwnerUid())) + 2)) + getPlatform().hashCode())) + 324)) + getChannelId())) + COUNTRYCODE_FIELD_NUMBER)) + getCountryCode().hashCode())) + 8)) + Internal.hashLong(getLoginRand()))) + 54)) + getOnlineId().hashCode())) + 1709)) + getSubChannelId())) + 15)) + getDeviceUuid().hashCode())) + UNK3300_OOBHAIIIPHH_FIELD_NUMBER)) + getUnk3300OOBHAIIIPHH())) + 1765)) + getClientVerisonHash().hashCode();
            if (hasAdjustTrackingInfo()) {
                hash2 = (53 * ((37 * hash2) + 442)) + getAdjustTrackingInfo().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 7)) + getAccountType())) + PSNID_FIELD_NUMBER)) + getPsnId().hashCode())) + 1223)) + getTag())) + UNK3300_PMGFBMJNNCL_FIELD_NUMBER)) + getUnk3300PMGFBMJNNCL())) + 3)) + getSystemVersion().hashCode())) + 10)) + Internal.hashBoolean(getIsGuest()))) + 11)) + getClientVersion().hashCode())) + 2037)) + Internal.hashBoolean(getIsTransfer()))) + 1015)) + getEnvironmentErrorCode().hashCode())) + 1)) + getDeviceName().hashCode())) + 378)) + getSecurityLibraryMd5().hashCode())) + 5)) + getLanguageType())) + 907)) + getSecurityCmdReply().hashCode())) + 684)) + getSecurityLibraryVersion().hashCode())) + 426)) + getClientDataVersion())) + 821)) + getCps().hashCode())) + this.unknownFields.hashCode();
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
            private int unk3300NDLANBEIGEG_;
            private int targetUid_;
            private boolean isEditor_;
            private int regPlatform_;
            private int gmUid_;
            private int platformType_;
            private TrackingIOInfoOuterClass.TrackingIOInfo trackingIoInfo_;
            private SingleFieldBuilderV3<TrackingIOInfoOuterClass.TrackingIOInfo, TrackingIOInfoOuterClass.TrackingIOInfo.Builder, TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder> trackingIoInfoBuilder_;
            private int unk3300OFFHPAFIFGD_;
            private int targetHomeOwnerUid_;
            private int channelId_;
            private long loginRand_;
            private int subChannelId_;
            private int unk3300OOBHAIIIPHH_;
            private AdjustTrackingInfoOuterClass.AdjustTrackingInfo adjustTrackingInfo_;
            private SingleFieldBuilderV3<AdjustTrackingInfoOuterClass.AdjustTrackingInfo, AdjustTrackingInfoOuterClass.AdjustTrackingInfo.Builder, AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder> adjustTrackingInfoBuilder_;
            private int accountType_;
            private int tag_;
            private int unk3300PMGFBMJNNCL_;
            private boolean isGuest_;
            private boolean isTransfer_;
            private int languageType_;
            private int clientDataVersion_;
            private Object token_ = "";
            private Object checksumClientVersion_ = "";
            private Object accountUid_ = "";
            private Object birthday_ = "";
            private ByteString extraBinData_ = ByteString.EMPTY;
            private Object checksum_ = "";
            private Object deviceInfo_ = "";
            private Object platform_ = "";
            private Object countryCode_ = "";
            private Object onlineId_ = "";
            private Object deviceUuid_ = "";
            private Object clientVerisonHash_ = "";
            private Object psnId_ = "";
            private Object systemVersion_ = "";
            private Object clientVersion_ = "";
            private ByteString environmentErrorCode_ = ByteString.EMPTY;
            private Object deviceName_ = "";
            private Object securityLibraryMd5_ = "";
            private ByteString securityCmdReply_ = ByteString.EMPTY;
            private Object securityLibraryVersion_ = "";
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
                this.token_ = "";
                this.unk3300NDLANBEIGEG_ = 0;
                this.targetUid_ = 0;
                this.checksumClientVersion_ = "";
                this.accountUid_ = "";
                this.isEditor_ = false;
                this.birthday_ = "";
                this.extraBinData_ = ByteString.EMPTY;
                this.regPlatform_ = 0;
                this.gmUid_ = 0;
                this.checksum_ = "";
                this.platformType_ = 0;
                if (this.trackingIoInfoBuilder_ == null) {
                    this.trackingIoInfo_ = null;
                } else {
                    this.trackingIoInfo_ = null;
                    this.trackingIoInfoBuilder_ = null;
                }
                this.unk3300OFFHPAFIFGD_ = 0;
                this.deviceInfo_ = "";
                this.targetHomeOwnerUid_ = 0;
                this.platform_ = "";
                this.channelId_ = 0;
                this.countryCode_ = "";
                this.loginRand_ = 0;
                this.onlineId_ = "";
                this.subChannelId_ = 0;
                this.deviceUuid_ = "";
                this.unk3300OOBHAIIIPHH_ = 0;
                this.clientVerisonHash_ = "";
                if (this.adjustTrackingInfoBuilder_ == null) {
                    this.adjustTrackingInfo_ = null;
                } else {
                    this.adjustTrackingInfo_ = null;
                    this.adjustTrackingInfoBuilder_ = null;
                }
                this.accountType_ = 0;
                this.psnId_ = "";
                this.tag_ = 0;
                this.unk3300PMGFBMJNNCL_ = 0;
                this.systemVersion_ = "";
                this.isGuest_ = false;
                this.clientVersion_ = "";
                this.isTransfer_ = false;
                this.environmentErrorCode_ = ByteString.EMPTY;
                this.deviceName_ = "";
                this.securityLibraryMd5_ = "";
                this.languageType_ = 0;
                this.securityCmdReply_ = ByteString.EMPTY;
                this.securityLibraryVersion_ = "";
                this.clientDataVersion_ = 0;
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
                result.token_ = this.token_;
                result.unk3300NDLANBEIGEG_ = this.unk3300NDLANBEIGEG_;
                result.targetUid_ = this.targetUid_;
                result.checksumClientVersion_ = this.checksumClientVersion_;
                result.accountUid_ = this.accountUid_;
                result.isEditor_ = this.isEditor_;
                result.birthday_ = this.birthday_;
                result.extraBinData_ = this.extraBinData_;
                result.regPlatform_ = this.regPlatform_;
                result.gmUid_ = this.gmUid_;
                result.checksum_ = this.checksum_;
                result.platformType_ = this.platformType_;
                if (this.trackingIoInfoBuilder_ == null) {
                    result.trackingIoInfo_ = this.trackingIoInfo_;
                } else {
                    result.trackingIoInfo_ = this.trackingIoInfoBuilder_.build();
                }
                result.unk3300OFFHPAFIFGD_ = this.unk3300OFFHPAFIFGD_;
                result.deviceInfo_ = this.deviceInfo_;
                result.targetHomeOwnerUid_ = this.targetHomeOwnerUid_;
                result.platform_ = this.platform_;
                result.channelId_ = this.channelId_;
                result.countryCode_ = this.countryCode_;
                result.loginRand_ = this.loginRand_;
                result.onlineId_ = this.onlineId_;
                result.subChannelId_ = this.subChannelId_;
                result.deviceUuid_ = this.deviceUuid_;
                result.unk3300OOBHAIIIPHH_ = this.unk3300OOBHAIIIPHH_;
                result.clientVerisonHash_ = this.clientVerisonHash_;
                if (this.adjustTrackingInfoBuilder_ == null) {
                    result.adjustTrackingInfo_ = this.adjustTrackingInfo_;
                } else {
                    result.adjustTrackingInfo_ = this.adjustTrackingInfoBuilder_.build();
                }
                result.accountType_ = this.accountType_;
                result.psnId_ = this.psnId_;
                result.tag_ = this.tag_;
                result.unk3300PMGFBMJNNCL_ = this.unk3300PMGFBMJNNCL_;
                result.systemVersion_ = this.systemVersion_;
                result.isGuest_ = this.isGuest_;
                result.clientVersion_ = this.clientVersion_;
                result.isTransfer_ = this.isTransfer_;
                result.environmentErrorCode_ = this.environmentErrorCode_;
                result.deviceName_ = this.deviceName_;
                result.securityLibraryMd5_ = this.securityLibraryMd5_;
                result.languageType_ = this.languageType_;
                result.securityCmdReply_ = this.securityCmdReply_;
                result.securityLibraryVersion_ = this.securityLibraryVersion_;
                result.clientDataVersion_ = this.clientDataVersion_;
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
                if (!other.getToken().isEmpty()) {
                    this.token_ = other.token_;
                    onChanged();
                }
                if (other.getUnk3300NDLANBEIGEG() != 0) {
                    setUnk3300NDLANBEIGEG(other.getUnk3300NDLANBEIGEG());
                }
                if (other.getTargetUid() != 0) {
                    setTargetUid(other.getTargetUid());
                }
                if (!other.getChecksumClientVersion().isEmpty()) {
                    this.checksumClientVersion_ = other.checksumClientVersion_;
                    onChanged();
                }
                if (!other.getAccountUid().isEmpty()) {
                    this.accountUid_ = other.accountUid_;
                    onChanged();
                }
                if (other.getIsEditor()) {
                    setIsEditor(other.getIsEditor());
                }
                if (!other.getBirthday().isEmpty()) {
                    this.birthday_ = other.birthday_;
                    onChanged();
                }
                if (other.getExtraBinData() != ByteString.EMPTY) {
                    setExtraBinData(other.getExtraBinData());
                }
                if (other.getRegPlatform() != 0) {
                    setRegPlatform(other.getRegPlatform());
                }
                if (other.getGmUid() != 0) {
                    setGmUid(other.getGmUid());
                }
                if (!other.getChecksum().isEmpty()) {
                    this.checksum_ = other.checksum_;
                    onChanged();
                }
                if (other.getPlatformType() != 0) {
                    setPlatformType(other.getPlatformType());
                }
                if (other.hasTrackingIoInfo()) {
                    mergeTrackingIoInfo(other.getTrackingIoInfo());
                }
                if (other.getUnk3300OFFHPAFIFGD() != 0) {
                    setUnk3300OFFHPAFIFGD(other.getUnk3300OFFHPAFIFGD());
                }
                if (!other.getDeviceInfo().isEmpty()) {
                    this.deviceInfo_ = other.deviceInfo_;
                    onChanged();
                }
                if (other.getTargetHomeOwnerUid() != 0) {
                    setTargetHomeOwnerUid(other.getTargetHomeOwnerUid());
                }
                if (!other.getPlatform().isEmpty()) {
                    this.platform_ = other.platform_;
                    onChanged();
                }
                if (other.getChannelId() != 0) {
                    setChannelId(other.getChannelId());
                }
                if (!other.getCountryCode().isEmpty()) {
                    this.countryCode_ = other.countryCode_;
                    onChanged();
                }
                if (other.getLoginRand() != 0) {
                    setLoginRand(other.getLoginRand());
                }
                if (!other.getOnlineId().isEmpty()) {
                    this.onlineId_ = other.onlineId_;
                    onChanged();
                }
                if (other.getSubChannelId() != 0) {
                    setSubChannelId(other.getSubChannelId());
                }
                if (!other.getDeviceUuid().isEmpty()) {
                    this.deviceUuid_ = other.deviceUuid_;
                    onChanged();
                }
                if (other.getUnk3300OOBHAIIIPHH() != 0) {
                    setUnk3300OOBHAIIIPHH(other.getUnk3300OOBHAIIIPHH());
                }
                if (!other.getClientVerisonHash().isEmpty()) {
                    this.clientVerisonHash_ = other.clientVerisonHash_;
                    onChanged();
                }
                if (other.hasAdjustTrackingInfo()) {
                    mergeAdjustTrackingInfo(other.getAdjustTrackingInfo());
                }
                if (other.getAccountType() != 0) {
                    setAccountType(other.getAccountType());
                }
                if (!other.getPsnId().isEmpty()) {
                    this.psnId_ = other.psnId_;
                    onChanged();
                }
                if (other.getTag() != 0) {
                    setTag(other.getTag());
                }
                if (other.getUnk3300PMGFBMJNNCL() != 0) {
                    setUnk3300PMGFBMJNNCL(other.getUnk3300PMGFBMJNNCL());
                }
                if (!other.getSystemVersion().isEmpty()) {
                    this.systemVersion_ = other.systemVersion_;
                    onChanged();
                }
                if (other.getIsGuest()) {
                    setIsGuest(other.getIsGuest());
                }
                if (!other.getClientVersion().isEmpty()) {
                    this.clientVersion_ = other.clientVersion_;
                    onChanged();
                }
                if (other.getIsTransfer()) {
                    setIsTransfer(other.getIsTransfer());
                }
                if (other.getEnvironmentErrorCode() != ByteString.EMPTY) {
                    setEnvironmentErrorCode(other.getEnvironmentErrorCode());
                }
                if (!other.getDeviceName().isEmpty()) {
                    this.deviceName_ = other.deviceName_;
                    onChanged();
                }
                if (!other.getSecurityLibraryMd5().isEmpty()) {
                    this.securityLibraryMd5_ = other.securityLibraryMd5_;
                    onChanged();
                }
                if (other.getLanguageType() != 0) {
                    setLanguageType(other.getLanguageType());
                }
                if (other.getSecurityCmdReply() != ByteString.EMPTY) {
                    setSecurityCmdReply(other.getSecurityCmdReply());
                }
                if (!other.getSecurityLibraryVersion().isEmpty()) {
                    this.securityLibraryVersion_ = other.securityLibraryVersion_;
                    onChanged();
                }
                if (other.getClientDataVersion() != 0) {
                    setClientDataVersion(other.getClientDataVersion());
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
        TrackingIOInfoOuterClass.getDescriptor();
        AdjustTrackingInfoOuterClass.getDescriptor();
    }
}
