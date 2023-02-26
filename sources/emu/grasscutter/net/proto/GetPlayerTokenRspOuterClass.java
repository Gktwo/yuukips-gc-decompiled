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
import emu.grasscutter.net.proto.StopServerOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerTokenRspOuterClass.class */
public final class GetPlayerTokenRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017GetPlayerTokenRsp.proto\u001a\u0010StopServer.proto\"È\u0005\n\u0011GetPlayerTokenRsp\u0012\u0015\n\fsubChannelId\u0018û\u0006 \u0001(\r\u0012\r\n\u0005token\u0018\u0006 \u0001(\t\u0012\u000b\n\u0003uid\u0018\u0001 \u0001(\r\u0012\u0011\n\tsecretKey\u0018\f \u0001(\t\u0012\u0013\n\u000baccountType\u0018\u0003 \u0001(\r\u0012\u000b\n\u0003msg\u0018\n \u0001(\t\u0012\u001c\n\u0013Unk3300_AJBBIPFMBEL\u0018\u0005 \u0001(\b\u0012\u0019\n\u0011securityCmdBuffer\u0018\r \u0001(\f\u0012\u000f\n\u0007retcode\u0018\u000f \u0001(\u0005\u0012\u0014\n\fextraBinData\u0018\u000e \u0001(\f\u0012\u001f\n\u0016clientVersionRandomKey\u0018\f \u0001(\t\u0012\u0014\n\u000bcountryCode\u0018¨\u000f \u0001(\t\u0012\u000e\n\u0005keyId\u0018Ó\u000f \u0001(\r\u0012\u0011\n\bbirthday\u0018³\u000b \u0001(\t\u0012\r\n\u0005gmUid\u0018\u0005 \u0001(\r\u0012\u0015\n\rsecretKeySeed\u0018\b \u0001(\u0004\u0012\u0017\n\u000fblackUidEndTime\u0018\u0002 \u0001(\r\u0012\u0012\n\tchannelId\u0018Ì\n \u0001(\r\u0012\u0014\n\u000bregPlatform\u0018Î\f \u0001(\r\u0012\u0014\n\fplatformType\u0018\u000b \u0001(\r\u0012\u000f\n\u0007isGuest\u0018\u0004 \u0001(\b\u0012\u001f\n\u0016finishCollectionIdList\u0018¶\u000e \u0003(\r\u0012\f\n\u0003tag\u0018À\n \u0001(\r\u0012\u0012\n\naccountUid\u0018\t \u0001(\t\u0012\u001a\n\u0012isProficientPlayer\u0018\u0007 \u0001(\b\u0012\r\n\u0004sign\u0018É\u000f \u0001(\t\u0012 \n\nstopServer\u0018Û\u0002 \u0001(\u000b2\u000b.StopServer\u0012\u000e\n\u0005psnId\u0018\n \u0001(\t\u0012\u0016\n\rcloudClientIp\u0018É\u000b \u0001(\r\u0012\u0013\n\u000bclientIpStr\u0018@ \u0001(\t\u0012\u0016\n\rserverRandKey\u0018\u000b \u0001(\t\u0012\u001c\n\u0013Unk3300_CFBHAHOHDKC\u0018ÿ\f \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{StopServerOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetPlayerTokenRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetPlayerTokenRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetPlayerTokenRsp_descriptor, new String[]{"SubChannelId", "Token", "Uid", "SecretKey", "AccountType", "Msg", "Unk3300AJBBIPFMBEL", "SecurityCmdBuffer", "Retcode", "ExtraBinData", "ClientVersionRandomKey", "CountryCode", "KeyId", "Birthday", "GmUid", "SecretKeySeed", "BlackUidEndTime", "ChannelId", "RegPlatform", "PlatformType", "IsGuest", "FinishCollectionIdList", "Tag", "AccountUid", "IsProficientPlayer", "Sign", "StopServer", "PsnId", "CloudClientIp", "ClientIpStr", "ServerRandKey", "Unk3300CFBHAHOHDKC"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerTokenRspOuterClass$GetPlayerTokenRspOrBuilder.class */
    public interface GetPlayerTokenRspOrBuilder extends MessageOrBuilder {
        int getSubChannelId();

        String getToken();

        ByteString getTokenBytes();

        int getUid();

        String getSecretKey();

        ByteString getSecretKeyBytes();

        int getAccountType();

        String getMsg();

        ByteString getMsgBytes();

        boolean getUnk3300AJBBIPFMBEL();

        ByteString getSecurityCmdBuffer();

        int getRetcode();

        ByteString getExtraBinData();

        String getClientVersionRandomKey();

        ByteString getClientVersionRandomKeyBytes();

        String getCountryCode();

        ByteString getCountryCodeBytes();

        int getKeyId();

        String getBirthday();

        ByteString getBirthdayBytes();

        int getGmUid();

        long getSecretKeySeed();

        int getBlackUidEndTime();

        int getChannelId();

        int getRegPlatform();

        int getPlatformType();

        boolean getIsGuest();

        List<Integer> getFinishCollectionIdListList();

        int getFinishCollectionIdListCount();

        int getFinishCollectionIdList(int i);

        int getTag();

        String getAccountUid();

        ByteString getAccountUidBytes();

        boolean getIsProficientPlayer();

        String getSign();

        ByteString getSignBytes();

        boolean hasStopServer();

        StopServerOuterClass.StopServer getStopServer();

        StopServerOuterClass.StopServerOrBuilder getStopServerOrBuilder();

        String getPsnId();

        ByteString getPsnIdBytes();

        int getCloudClientIp();

        String getClientIpStr();

        ByteString getClientIpStrBytes();

        String getServerRandKey();

        ByteString getServerRandKeyBytes();

        boolean getUnk3300CFBHAHOHDKC();
    }

    private GetPlayerTokenRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerTokenRspOuterClass$GetPlayerTokenRsp.class */
    public static final class GetPlayerTokenRsp extends GeneratedMessageV3 implements GetPlayerTokenRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SUBCHANNELID_FIELD_NUMBER = 891;
        private int subChannelId_;
        public static final int TOKEN_FIELD_NUMBER = 6;
        private volatile Object token_;
        public static final int UID_FIELD_NUMBER = 1;
        private int uid_;
        public static final int SECRETKEY_FIELD_NUMBER = 12;
        private volatile Object secretKey_;
        public static final int ACCOUNTTYPE_FIELD_NUMBER = 3;
        private int accountType_;
        public static final int MSG_FIELD_NUMBER = 10;
        private volatile Object msg_;
        public static final int UNK3300_AJBBIPFMBEL_FIELD_NUMBER = 661;
        private boolean unk3300AJBBIPFMBEL_;
        public static final int SECURITYCMDBUFFER_FIELD_NUMBER = 13;
        private ByteString securityCmdBuffer_;
        public static final int RETCODE_FIELD_NUMBER = 15;
        private int retcode_;
        public static final int EXTRABINDATA_FIELD_NUMBER = 14;
        private ByteString extraBinData_;
        public static final int CLIENTVERSIONRANDOMKEY_FIELD_NUMBER = 1558;
        private volatile Object clientVersionRandomKey_;
        public static final int COUNTRYCODE_FIELD_NUMBER = 1960;
        private volatile Object countryCode_;
        public static final int KEYID_FIELD_NUMBER = 2003;
        private int keyId_;
        public static final int BIRTHDAY_FIELD_NUMBER = 1459;
        private volatile Object birthday_;
        public static final int GMUID_FIELD_NUMBER = 5;
        private int gmUid_;
        public static final int SECRETKEYSEED_FIELD_NUMBER = 8;
        private long secretKeySeed_;
        public static final int BLACKUIDENDTIME_FIELD_NUMBER = 2;
        private int blackUidEndTime_;
        public static final int CHANNELID_FIELD_NUMBER = 1356;
        private int channelId_;
        public static final int REGPLATFORM_FIELD_NUMBER = 1614;
        private int regPlatform_;
        public static final int PLATFORMTYPE_FIELD_NUMBER = 11;
        private int platformType_;
        public static final int ISGUEST_FIELD_NUMBER = 4;
        private boolean isGuest_;
        public static final int FINISHCOLLECTIONIDLIST_FIELD_NUMBER = 1846;
        private Internal.IntList finishCollectionIdList_;
        private int finishCollectionIdListMemoizedSerializedSize;
        public static final int TAG_FIELD_NUMBER = 1344;
        private int tag_;
        public static final int ACCOUNTUID_FIELD_NUMBER = 9;
        private volatile Object accountUid_;
        public static final int ISPROFICIENTPLAYER_FIELD_NUMBER = 7;
        private boolean isProficientPlayer_;
        public static final int SIGN_FIELD_NUMBER = 1993;
        private volatile Object sign_;
        public static final int STOPSERVER_FIELD_NUMBER = 347;
        private StopServerOuterClass.StopServer stopServer_;
        public static final int PSNID_FIELD_NUMBER = 1285;
        private volatile Object psnId_;
        public static final int CLOUDCLIENTIP_FIELD_NUMBER = 1481;
        private int cloudClientIp_;
        public static final int CLIENTIPSTR_FIELD_NUMBER = 64;
        private volatile Object clientIpStr_;
        public static final int SERVERRANDKEY_FIELD_NUMBER = 1420;
        private volatile Object serverRandKey_;
        public static final int UNK3300_CFBHAHOHDKC_FIELD_NUMBER = 1663;
        private boolean unk3300CFBHAHOHDKC_;
        private byte memoizedIsInitialized;
        private static final GetPlayerTokenRsp DEFAULT_INSTANCE = new GetPlayerTokenRsp();
        private static final Parser<GetPlayerTokenRsp> PARSER = new AbstractParser<GetPlayerTokenRsp>() { // from class: emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRsp.1
            @Override // com.google.protobuf.Parser
            public GetPlayerTokenRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetPlayerTokenRsp(input, extensionRegistry);
            }
        };

        private GetPlayerTokenRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.finishCollectionIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GetPlayerTokenRsp() {
            this.finishCollectionIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.token_ = "";
            this.secretKey_ = "";
            this.msg_ = "";
            this.securityCmdBuffer_ = ByteString.EMPTY;
            this.extraBinData_ = ByteString.EMPTY;
            this.clientVersionRandomKey_ = "";
            this.countryCode_ = "";
            this.birthday_ = "";
            this.finishCollectionIdList_ = emptyIntList();
            this.accountUid_ = "";
            this.sign_ = "";
            this.psnId_ = "";
            this.clientIpStr_ = "";
            this.serverRandKey_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetPlayerTokenRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetPlayerTokenRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.blackUidEndTime_ = input.readUInt32();
                                break;
                            case 24:
                                this.accountType_ = input.readUInt32();
                                break;
                            case 32:
                                this.isGuest_ = input.readBool();
                                break;
                            case 40:
                                this.gmUid_ = input.readUInt32();
                                break;
                            case 50:
                                this.token_ = input.readStringRequireUtf8();
                                break;
                            case 56:
                                this.isProficientPlayer_ = input.readBool();
                                break;
                            case 64:
                                this.secretKeySeed_ = input.readUInt64();
                                break;
                            case 74:
                                this.accountUid_ = input.readStringRequireUtf8();
                                break;
                            case 82:
                                this.msg_ = input.readStringRequireUtf8();
                                break;
                            case 88:
                                this.platformType_ = input.readUInt32();
                                break;
                            case 98:
                                this.secretKey_ = input.readStringRequireUtf8();
                                break;
                            case 106:
                                this.securityCmdBuffer_ = input.readBytes();
                                break;
                            case 114:
                                this.extraBinData_ = input.readBytes();
                                break;
                            case 120:
                                this.retcode_ = input.readInt32();
                                break;
                            case 514:
                                this.clientIpStr_ = input.readStringRequireUtf8();
                                break;
                            case 2778:
                                StopServerOuterClass.StopServer.Builder subBuilder = this.stopServer_ != null ? this.stopServer_.toBuilder() : null;
                                this.stopServer_ = (StopServerOuterClass.StopServer) input.readMessage(StopServerOuterClass.StopServer.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.stopServer_);
                                    this.stopServer_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 5288:
                                this.unk3300AJBBIPFMBEL_ = input.readBool();
                                break;
                            case RET_MECHANICUS_DIFFICULT_NOT_SUPPORT_VALUE:
                                this.subChannelId_ = input.readUInt32();
                                break;
                            case 10282:
                                this.psnId_ = input.readStringRequireUtf8();
                                break;
                            case 10752:
                                this.tag_ = input.readUInt32();
                                break;
                            case 10848:
                                this.channelId_ = input.readUInt32();
                                break;
                            case 11362:
                                this.serverRandKey_ = input.readStringRequireUtf8();
                                break;
                            case 11674:
                                this.birthday_ = input.readStringRequireUtf8();
                                break;
                            case 11848:
                                this.cloudClientIp_ = input.readUInt32();
                                break;
                            case 12466:
                                this.clientVersionRandomKey_ = input.readStringRequireUtf8();
                                break;
                            case 12912:
                                this.regPlatform_ = input.readUInt32();
                                break;
                            case 13304:
                                this.unk3300CFBHAHOHDKC_ = input.readBool();
                                break;
                            case 14768:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.finishCollectionIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.finishCollectionIdList_.addInt(input.readUInt32());
                                break;
                            case 14770:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.finishCollectionIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.finishCollectionIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 15682:
                                this.countryCode_ = input.readStringRequireUtf8();
                                break;
                            case 15946:
                                this.sign_ = input.readStringRequireUtf8();
                                break;
                            case 16024:
                                this.keyId_ = input.readUInt32();
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
                    this.finishCollectionIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetPlayerTokenRspOuterClass.internal_static_GetPlayerTokenRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetPlayerTokenRspOuterClass.internal_static_GetPlayerTokenRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetPlayerTokenRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getSubChannelId() {
            return this.subChannelId_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public String getToken() {
            Object ref = this.token_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.token_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public ByteString getTokenBytes() {
            Object ref = this.token_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.token_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public String getSecretKey() {
            Object ref = this.secretKey_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.secretKey_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public ByteString getSecretKeyBytes() {
            Object ref = this.secretKey_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.secretKey_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getAccountType() {
            return this.accountType_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public String getMsg() {
            Object ref = this.msg_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.msg_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public ByteString getMsgBytes() {
            Object ref = this.msg_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.msg_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public boolean getUnk3300AJBBIPFMBEL() {
            return this.unk3300AJBBIPFMBEL_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public ByteString getSecurityCmdBuffer() {
            return this.securityCmdBuffer_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public ByteString getExtraBinData() {
            return this.extraBinData_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public String getClientVersionRandomKey() {
            Object ref = this.clientVersionRandomKey_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.clientVersionRandomKey_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public ByteString getClientVersionRandomKeyBytes() {
            Object ref = this.clientVersionRandomKey_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.clientVersionRandomKey_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public String getCountryCode() {
            Object ref = this.countryCode_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.countryCode_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public ByteString getCountryCodeBytes() {
            Object ref = this.countryCode_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.countryCode_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getKeyId() {
            return this.keyId_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public String getBirthday() {
            Object ref = this.birthday_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.birthday_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public ByteString getBirthdayBytes() {
            Object ref = this.birthday_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.birthday_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getGmUid() {
            return this.gmUid_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public long getSecretKeySeed() {
            return this.secretKeySeed_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getBlackUidEndTime() {
            return this.blackUidEndTime_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getChannelId() {
            return this.channelId_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getRegPlatform() {
            return this.regPlatform_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getPlatformType() {
            return this.platformType_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public boolean getIsGuest() {
            return this.isGuest_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public List<Integer> getFinishCollectionIdListList() {
            return this.finishCollectionIdList_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getFinishCollectionIdListCount() {
            return this.finishCollectionIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getFinishCollectionIdList(int index) {
            return this.finishCollectionIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getTag() {
            return this.tag_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public String getAccountUid() {
            Object ref = this.accountUid_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.accountUid_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public ByteString getAccountUidBytes() {
            Object ref = this.accountUid_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.accountUid_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public boolean getIsProficientPlayer() {
            return this.isProficientPlayer_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public String getSign() {
            Object ref = this.sign_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.sign_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public ByteString getSignBytes() {
            Object ref = this.sign_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.sign_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public boolean hasStopServer() {
            return this.stopServer_ != null;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public StopServerOuterClass.StopServer getStopServer() {
            return this.stopServer_ == null ? StopServerOuterClass.StopServer.getDefaultInstance() : this.stopServer_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public StopServerOuterClass.StopServerOrBuilder getStopServerOrBuilder() {
            return getStopServer();
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public String getPsnId() {
            Object ref = this.psnId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.psnId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public ByteString getPsnIdBytes() {
            Object ref = this.psnId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.psnId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getCloudClientIp() {
            return this.cloudClientIp_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public String getClientIpStr() {
            Object ref = this.clientIpStr_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.clientIpStr_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public ByteString getClientIpStrBytes() {
            Object ref = this.clientIpStr_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.clientIpStr_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public String getServerRandKey() {
            Object ref = this.serverRandKey_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.serverRandKey_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public ByteString getServerRandKeyBytes() {
            Object ref = this.serverRandKey_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.serverRandKey_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public boolean getUnk3300CFBHAHOHDKC() {
            return this.unk3300CFBHAHOHDKC_;
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
            if (this.blackUidEndTime_ != 0) {
                output.writeUInt32(2, this.blackUidEndTime_);
            }
            if (this.accountType_ != 0) {
                output.writeUInt32(3, this.accountType_);
            }
            if (this.isGuest_) {
                output.writeBool(4, this.isGuest_);
            }
            if (this.gmUid_ != 0) {
                output.writeUInt32(5, this.gmUid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.token_)) {
                GeneratedMessageV3.writeString(output, 6, this.token_);
            }
            if (this.isProficientPlayer_) {
                output.writeBool(7, this.isProficientPlayer_);
            }
            if (this.secretKeySeed_ != 0) {
                output.writeUInt64(8, this.secretKeySeed_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.accountUid_)) {
                GeneratedMessageV3.writeString(output, 9, this.accountUid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.msg_)) {
                GeneratedMessageV3.writeString(output, 10, this.msg_);
            }
            if (this.platformType_ != 0) {
                output.writeUInt32(11, this.platformType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.secretKey_)) {
                GeneratedMessageV3.writeString(output, 12, this.secretKey_);
            }
            if (!this.securityCmdBuffer_.isEmpty()) {
                output.writeBytes(13, this.securityCmdBuffer_);
            }
            if (!this.extraBinData_.isEmpty()) {
                output.writeBytes(14, this.extraBinData_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(15, this.retcode_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientIpStr_)) {
                GeneratedMessageV3.writeString(output, 64, this.clientIpStr_);
            }
            if (this.stopServer_ != null) {
                output.writeMessage(347, getStopServer());
            }
            if (this.unk3300AJBBIPFMBEL_) {
                output.writeBool(661, this.unk3300AJBBIPFMBEL_);
            }
            if (this.subChannelId_ != 0) {
                output.writeUInt32(891, this.subChannelId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.psnId_)) {
                GeneratedMessageV3.writeString(output, PSNID_FIELD_NUMBER, this.psnId_);
            }
            if (this.tag_ != 0) {
                output.writeUInt32(TAG_FIELD_NUMBER, this.tag_);
            }
            if (this.channelId_ != 0) {
                output.writeUInt32(CHANNELID_FIELD_NUMBER, this.channelId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.serverRandKey_)) {
                GeneratedMessageV3.writeString(output, 1420, this.serverRandKey_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.birthday_)) {
                GeneratedMessageV3.writeString(output, BIRTHDAY_FIELD_NUMBER, this.birthday_);
            }
            if (this.cloudClientIp_ != 0) {
                output.writeUInt32(CLOUDCLIENTIP_FIELD_NUMBER, this.cloudClientIp_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientVersionRandomKey_)) {
                GeneratedMessageV3.writeString(output, CLIENTVERSIONRANDOMKEY_FIELD_NUMBER, this.clientVersionRandomKey_);
            }
            if (this.regPlatform_ != 0) {
                output.writeUInt32(REGPLATFORM_FIELD_NUMBER, this.regPlatform_);
            }
            if (this.unk3300CFBHAHOHDKC_) {
                output.writeBool(1663, this.unk3300CFBHAHOHDKC_);
            }
            if (getFinishCollectionIdListList().size() > 0) {
                output.writeUInt32NoTag(14770);
                output.writeUInt32NoTag(this.finishCollectionIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.finishCollectionIdList_.size(); i++) {
                output.writeUInt32NoTag(this.finishCollectionIdList_.getInt(i));
            }
            if (!GeneratedMessageV3.isStringEmpty(this.countryCode_)) {
                GeneratedMessageV3.writeString(output, 1960, this.countryCode_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.sign_)) {
                GeneratedMessageV3.writeString(output, 1993, this.sign_);
            }
            if (this.keyId_ != 0) {
                output.writeUInt32(2003, this.keyId_);
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
            if (this.blackUidEndTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.blackUidEndTime_);
            }
            if (this.accountType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.accountType_);
            }
            if (this.isGuest_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isGuest_);
            }
            if (this.gmUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.gmUid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.token_)) {
                size2 += GeneratedMessageV3.computeStringSize(6, this.token_);
            }
            if (this.isProficientPlayer_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.isProficientPlayer_);
            }
            if (this.secretKeySeed_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(8, this.secretKeySeed_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.accountUid_)) {
                size2 += GeneratedMessageV3.computeStringSize(9, this.accountUid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.msg_)) {
                size2 += GeneratedMessageV3.computeStringSize(10, this.msg_);
            }
            if (this.platformType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.platformType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.secretKey_)) {
                size2 += GeneratedMessageV3.computeStringSize(12, this.secretKey_);
            }
            if (!this.securityCmdBuffer_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(13, this.securityCmdBuffer_);
            }
            if (!this.extraBinData_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(14, this.extraBinData_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(15, this.retcode_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientIpStr_)) {
                size2 += GeneratedMessageV3.computeStringSize(64, this.clientIpStr_);
            }
            if (this.stopServer_ != null) {
                size2 += CodedOutputStream.computeMessageSize(347, getStopServer());
            }
            if (this.unk3300AJBBIPFMBEL_) {
                size2 += CodedOutputStream.computeBoolSize(661, this.unk3300AJBBIPFMBEL_);
            }
            if (this.subChannelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(891, this.subChannelId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.psnId_)) {
                size2 += GeneratedMessageV3.computeStringSize(PSNID_FIELD_NUMBER, this.psnId_);
            }
            if (this.tag_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(TAG_FIELD_NUMBER, this.tag_);
            }
            if (this.channelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(CHANNELID_FIELD_NUMBER, this.channelId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.serverRandKey_)) {
                size2 += GeneratedMessageV3.computeStringSize(1420, this.serverRandKey_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.birthday_)) {
                size2 += GeneratedMessageV3.computeStringSize(BIRTHDAY_FIELD_NUMBER, this.birthday_);
            }
            if (this.cloudClientIp_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(CLOUDCLIENTIP_FIELD_NUMBER, this.cloudClientIp_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientVersionRandomKey_)) {
                size2 += GeneratedMessageV3.computeStringSize(CLIENTVERSIONRANDOMKEY_FIELD_NUMBER, this.clientVersionRandomKey_);
            }
            if (this.regPlatform_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(REGPLATFORM_FIELD_NUMBER, this.regPlatform_);
            }
            if (this.unk3300CFBHAHOHDKC_) {
                size2 += CodedOutputStream.computeBoolSize(1663, this.unk3300CFBHAHOHDKC_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.finishCollectionIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.finishCollectionIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getFinishCollectionIdListList().isEmpty()) {
                size3 = size3 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.finishCollectionIdListMemoizedSerializedSize = dataSize;
            if (!GeneratedMessageV3.isStringEmpty(this.countryCode_)) {
                size3 += GeneratedMessageV3.computeStringSize(1960, this.countryCode_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.sign_)) {
                size3 += GeneratedMessageV3.computeStringSize(1993, this.sign_);
            }
            if (this.keyId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(2003, this.keyId_);
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
            if (!(obj instanceof GetPlayerTokenRsp)) {
                return equals(obj);
            }
            GetPlayerTokenRsp other = (GetPlayerTokenRsp) obj;
            if (getSubChannelId() == other.getSubChannelId() && getToken().equals(other.getToken()) && getUid() == other.getUid() && getSecretKey().equals(other.getSecretKey()) && getAccountType() == other.getAccountType() && getMsg().equals(other.getMsg()) && getUnk3300AJBBIPFMBEL() == other.getUnk3300AJBBIPFMBEL() && getSecurityCmdBuffer().equals(other.getSecurityCmdBuffer()) && getRetcode() == other.getRetcode() && getExtraBinData().equals(other.getExtraBinData()) && getClientVersionRandomKey().equals(other.getClientVersionRandomKey()) && getCountryCode().equals(other.getCountryCode()) && getKeyId() == other.getKeyId() && getBirthday().equals(other.getBirthday()) && getGmUid() == other.getGmUid() && getSecretKeySeed() == other.getSecretKeySeed() && getBlackUidEndTime() == other.getBlackUidEndTime() && getChannelId() == other.getChannelId() && getRegPlatform() == other.getRegPlatform() && getPlatformType() == other.getPlatformType() && getIsGuest() == other.getIsGuest() && getFinishCollectionIdListList().equals(other.getFinishCollectionIdListList()) && getTag() == other.getTag() && getAccountUid().equals(other.getAccountUid()) && getIsProficientPlayer() == other.getIsProficientPlayer() && getSign().equals(other.getSign()) && hasStopServer() == other.hasStopServer()) {
                return (!hasStopServer() || getStopServer().equals(other.getStopServer())) && getPsnId().equals(other.getPsnId()) && getCloudClientIp() == other.getCloudClientIp() && getClientIpStr().equals(other.getClientIpStr()) && getServerRandKey().equals(other.getServerRandKey()) && getUnk3300CFBHAHOHDKC() == other.getUnk3300CFBHAHOHDKC() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 891)) + getSubChannelId())) + 6)) + getToken().hashCode())) + 1)) + getUid())) + 12)) + getSecretKey().hashCode())) + 3)) + getAccountType())) + 10)) + getMsg().hashCode())) + 661)) + Internal.hashBoolean(getUnk3300AJBBIPFMBEL()))) + 13)) + getSecurityCmdBuffer().hashCode())) + 15)) + getRetcode())) + 14)) + getExtraBinData().hashCode())) + CLIENTVERSIONRANDOMKEY_FIELD_NUMBER)) + getClientVersionRandomKey().hashCode())) + 1960)) + getCountryCode().hashCode())) + 2003)) + getKeyId())) + BIRTHDAY_FIELD_NUMBER)) + getBirthday().hashCode())) + 5)) + getGmUid())) + 8)) + Internal.hashLong(getSecretKeySeed()))) + 2)) + getBlackUidEndTime())) + CHANNELID_FIELD_NUMBER)) + getChannelId())) + REGPLATFORM_FIELD_NUMBER)) + getRegPlatform())) + 11)) + getPlatformType())) + 4)) + Internal.hashBoolean(getIsGuest());
            if (getFinishCollectionIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 1846)) + getFinishCollectionIdListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + TAG_FIELD_NUMBER)) + getTag())) + 9)) + getAccountUid().hashCode())) + 7)) + Internal.hashBoolean(getIsProficientPlayer()))) + 1993)) + getSign().hashCode();
            if (hasStopServer()) {
                hash2 = (53 * ((37 * hash2) + 347)) + getStopServer().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + PSNID_FIELD_NUMBER)) + getPsnId().hashCode())) + CLOUDCLIENTIP_FIELD_NUMBER)) + getCloudClientIp())) + 64)) + getClientIpStr().hashCode())) + 1420)) + getServerRandKey().hashCode())) + 1663)) + Internal.hashBoolean(getUnk3300CFBHAHOHDKC()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static GetPlayerTokenRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerTokenRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerTokenRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerTokenRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerTokenRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerTokenRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerTokenRsp parseFrom(InputStream input) throws IOException {
            return (GetPlayerTokenRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetPlayerTokenRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerTokenRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetPlayerTokenRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetPlayerTokenRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetPlayerTokenRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerTokenRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetPlayerTokenRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetPlayerTokenRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetPlayerTokenRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerTokenRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetPlayerTokenRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerTokenRspOuterClass$GetPlayerTokenRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetPlayerTokenRspOrBuilder {
            private int bitField0_;
            private int subChannelId_;
            private int uid_;
            private int accountType_;
            private boolean unk3300AJBBIPFMBEL_;
            private int retcode_;
            private int keyId_;
            private int gmUid_;
            private long secretKeySeed_;
            private int blackUidEndTime_;
            private int channelId_;
            private int regPlatform_;
            private int platformType_;
            private boolean isGuest_;
            private int tag_;
            private boolean isProficientPlayer_;
            private StopServerOuterClass.StopServer stopServer_;
            private SingleFieldBuilderV3<StopServerOuterClass.StopServer, StopServerOuterClass.StopServer.Builder, StopServerOuterClass.StopServerOrBuilder> stopServerBuilder_;
            private int cloudClientIp_;
            private boolean unk3300CFBHAHOHDKC_;
            private Object token_ = "";
            private Object secretKey_ = "";
            private Object msg_ = "";
            private ByteString securityCmdBuffer_ = ByteString.EMPTY;
            private ByteString extraBinData_ = ByteString.EMPTY;
            private Object clientVersionRandomKey_ = "";
            private Object countryCode_ = "";
            private Object birthday_ = "";
            private Internal.IntList finishCollectionIdList_ = GetPlayerTokenRsp.emptyIntList();
            private Object accountUid_ = "";
            private Object sign_ = "";
            private Object psnId_ = "";
            private Object clientIpStr_ = "";
            private Object serverRandKey_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return GetPlayerTokenRspOuterClass.internal_static_GetPlayerTokenRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetPlayerTokenRspOuterClass.internal_static_GetPlayerTokenRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetPlayerTokenRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetPlayerTokenRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.subChannelId_ = 0;
                this.token_ = "";
                this.uid_ = 0;
                this.secretKey_ = "";
                this.accountType_ = 0;
                this.msg_ = "";
                this.unk3300AJBBIPFMBEL_ = false;
                this.securityCmdBuffer_ = ByteString.EMPTY;
                this.retcode_ = 0;
                this.extraBinData_ = ByteString.EMPTY;
                this.clientVersionRandomKey_ = "";
                this.countryCode_ = "";
                this.keyId_ = 0;
                this.birthday_ = "";
                this.gmUid_ = 0;
                this.secretKeySeed_ = 0;
                this.blackUidEndTime_ = 0;
                this.channelId_ = 0;
                this.regPlatform_ = 0;
                this.platformType_ = 0;
                this.isGuest_ = false;
                this.finishCollectionIdList_ = GetPlayerTokenRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.tag_ = 0;
                this.accountUid_ = "";
                this.isProficientPlayer_ = false;
                this.sign_ = "";
                if (this.stopServerBuilder_ == null) {
                    this.stopServer_ = null;
                } else {
                    this.stopServer_ = null;
                    this.stopServerBuilder_ = null;
                }
                this.psnId_ = "";
                this.cloudClientIp_ = 0;
                this.clientIpStr_ = "";
                this.serverRandKey_ = "";
                this.unk3300CFBHAHOHDKC_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetPlayerTokenRspOuterClass.internal_static_GetPlayerTokenRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetPlayerTokenRsp getDefaultInstanceForType() {
                return GetPlayerTokenRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetPlayerTokenRsp build() {
                GetPlayerTokenRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetPlayerTokenRsp buildPartial() {
                GetPlayerTokenRsp result = new GetPlayerTokenRsp(this);
                int i = this.bitField0_;
                result.subChannelId_ = this.subChannelId_;
                result.token_ = this.token_;
                result.uid_ = this.uid_;
                result.secretKey_ = this.secretKey_;
                result.accountType_ = this.accountType_;
                result.msg_ = this.msg_;
                result.unk3300AJBBIPFMBEL_ = this.unk3300AJBBIPFMBEL_;
                result.securityCmdBuffer_ = this.securityCmdBuffer_;
                result.retcode_ = this.retcode_;
                result.extraBinData_ = this.extraBinData_;
                result.clientVersionRandomKey_ = this.clientVersionRandomKey_;
                result.countryCode_ = this.countryCode_;
                result.keyId_ = this.keyId_;
                result.birthday_ = this.birthday_;
                result.gmUid_ = this.gmUid_;
                result.secretKeySeed_ = this.secretKeySeed_;
                result.blackUidEndTime_ = this.blackUidEndTime_;
                result.channelId_ = this.channelId_;
                result.regPlatform_ = this.regPlatform_;
                result.platformType_ = this.platformType_;
                result.isGuest_ = this.isGuest_;
                if ((this.bitField0_ & 1) != 0) {
                    this.finishCollectionIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.finishCollectionIdList_ = this.finishCollectionIdList_;
                result.tag_ = this.tag_;
                result.accountUid_ = this.accountUid_;
                result.isProficientPlayer_ = this.isProficientPlayer_;
                result.sign_ = this.sign_;
                if (this.stopServerBuilder_ == null) {
                    result.stopServer_ = this.stopServer_;
                } else {
                    result.stopServer_ = this.stopServerBuilder_.build();
                }
                result.psnId_ = this.psnId_;
                result.cloudClientIp_ = this.cloudClientIp_;
                result.clientIpStr_ = this.clientIpStr_;
                result.serverRandKey_ = this.serverRandKey_;
                result.unk3300CFBHAHOHDKC_ = this.unk3300CFBHAHOHDKC_;
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
                if (other instanceof GetPlayerTokenRsp) {
                    return mergeFrom((GetPlayerTokenRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetPlayerTokenRsp other) {
                if (other == GetPlayerTokenRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getSubChannelId() != 0) {
                    setSubChannelId(other.getSubChannelId());
                }
                if (!other.getToken().isEmpty()) {
                    this.token_ = other.token_;
                    onChanged();
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (!other.getSecretKey().isEmpty()) {
                    this.secretKey_ = other.secretKey_;
                    onChanged();
                }
                if (other.getAccountType() != 0) {
                    setAccountType(other.getAccountType());
                }
                if (!other.getMsg().isEmpty()) {
                    this.msg_ = other.msg_;
                    onChanged();
                }
                if (other.getUnk3300AJBBIPFMBEL()) {
                    setUnk3300AJBBIPFMBEL(other.getUnk3300AJBBIPFMBEL());
                }
                if (other.getSecurityCmdBuffer() != ByteString.EMPTY) {
                    setSecurityCmdBuffer(other.getSecurityCmdBuffer());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getExtraBinData() != ByteString.EMPTY) {
                    setExtraBinData(other.getExtraBinData());
                }
                if (!other.getClientVersionRandomKey().isEmpty()) {
                    this.clientVersionRandomKey_ = other.clientVersionRandomKey_;
                    onChanged();
                }
                if (!other.getCountryCode().isEmpty()) {
                    this.countryCode_ = other.countryCode_;
                    onChanged();
                }
                if (other.getKeyId() != 0) {
                    setKeyId(other.getKeyId());
                }
                if (!other.getBirthday().isEmpty()) {
                    this.birthday_ = other.birthday_;
                    onChanged();
                }
                if (other.getGmUid() != 0) {
                    setGmUid(other.getGmUid());
                }
                if (other.getSecretKeySeed() != 0) {
                    setSecretKeySeed(other.getSecretKeySeed());
                }
                if (other.getBlackUidEndTime() != 0) {
                    setBlackUidEndTime(other.getBlackUidEndTime());
                }
                if (other.getChannelId() != 0) {
                    setChannelId(other.getChannelId());
                }
                if (other.getRegPlatform() != 0) {
                    setRegPlatform(other.getRegPlatform());
                }
                if (other.getPlatformType() != 0) {
                    setPlatformType(other.getPlatformType());
                }
                if (other.getIsGuest()) {
                    setIsGuest(other.getIsGuest());
                }
                if (!other.finishCollectionIdList_.isEmpty()) {
                    if (this.finishCollectionIdList_.isEmpty()) {
                        this.finishCollectionIdList_ = other.finishCollectionIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFinishCollectionIdListIsMutable();
                        this.finishCollectionIdList_.addAll(other.finishCollectionIdList_);
                    }
                    onChanged();
                }
                if (other.getTag() != 0) {
                    setTag(other.getTag());
                }
                if (!other.getAccountUid().isEmpty()) {
                    this.accountUid_ = other.accountUid_;
                    onChanged();
                }
                if (other.getIsProficientPlayer()) {
                    setIsProficientPlayer(other.getIsProficientPlayer());
                }
                if (!other.getSign().isEmpty()) {
                    this.sign_ = other.sign_;
                    onChanged();
                }
                if (other.hasStopServer()) {
                    mergeStopServer(other.getStopServer());
                }
                if (!other.getPsnId().isEmpty()) {
                    this.psnId_ = other.psnId_;
                    onChanged();
                }
                if (other.getCloudClientIp() != 0) {
                    setCloudClientIp(other.getCloudClientIp());
                }
                if (!other.getClientIpStr().isEmpty()) {
                    this.clientIpStr_ = other.clientIpStr_;
                    onChanged();
                }
                if (!other.getServerRandKey().isEmpty()) {
                    this.serverRandKey_ = other.serverRandKey_;
                    onChanged();
                }
                if (other.getUnk3300CFBHAHOHDKC()) {
                    setUnk3300CFBHAHOHDKC(other.getUnk3300CFBHAHOHDKC());
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
                GetPlayerTokenRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetPlayerTokenRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetPlayerTokenRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public String getToken() {
                Object ref = this.token_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.token_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
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
                this.token_ = GetPlayerTokenRsp.getDefaultInstance().getToken();
                onChanged();
                return this;
            }

            public Builder setTokenBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenRsp.checkByteStringIsUtf8(value);
                this.token_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public String getSecretKey() {
                Object ref = this.secretKey_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.secretKey_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public ByteString getSecretKeyBytes() {
                Object ref = this.secretKey_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.secretKey_ = b;
                return b;
            }

            public Builder setSecretKey(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.secretKey_ = value;
                onChanged();
                return this;
            }

            public Builder clearSecretKey() {
                this.secretKey_ = GetPlayerTokenRsp.getDefaultInstance().getSecretKey();
                onChanged();
                return this;
            }

            public Builder setSecretKeyBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenRsp.checkByteStringIsUtf8(value);
                this.secretKey_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public String getMsg() {
                Object ref = this.msg_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.msg_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public ByteString getMsgBytes() {
                Object ref = this.msg_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.msg_ = b;
                return b;
            }

            public Builder setMsg(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.msg_ = value;
                onChanged();
                return this;
            }

            public Builder clearMsg() {
                this.msg_ = GetPlayerTokenRsp.getDefaultInstance().getMsg();
                onChanged();
                return this;
            }

            public Builder setMsgBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenRsp.checkByteStringIsUtf8(value);
                this.msg_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public boolean getUnk3300AJBBIPFMBEL() {
                return this.unk3300AJBBIPFMBEL_;
            }

            public Builder setUnk3300AJBBIPFMBEL(boolean value) {
                this.unk3300AJBBIPFMBEL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300AJBBIPFMBEL() {
                this.unk3300AJBBIPFMBEL_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public ByteString getSecurityCmdBuffer() {
                return this.securityCmdBuffer_;
            }

            public Builder setSecurityCmdBuffer(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.securityCmdBuffer_ = value;
                onChanged();
                return this;
            }

            public Builder clearSecurityCmdBuffer() {
                this.securityCmdBuffer_ = GetPlayerTokenRsp.getDefaultInstance().getSecurityCmdBuffer();
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
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
                this.extraBinData_ = GetPlayerTokenRsp.getDefaultInstance().getExtraBinData();
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public String getClientVersionRandomKey() {
                Object ref = this.clientVersionRandomKey_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.clientVersionRandomKey_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public ByteString getClientVersionRandomKeyBytes() {
                Object ref = this.clientVersionRandomKey_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientVersionRandomKey_ = b;
                return b;
            }

            public Builder setClientVersionRandomKey(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientVersionRandomKey_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientVersionRandomKey() {
                this.clientVersionRandomKey_ = GetPlayerTokenRsp.getDefaultInstance().getClientVersionRandomKey();
                onChanged();
                return this;
            }

            public Builder setClientVersionRandomKeyBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenRsp.checkByteStringIsUtf8(value);
                this.clientVersionRandomKey_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public String getCountryCode() {
                Object ref = this.countryCode_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.countryCode_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
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
                this.countryCode_ = GetPlayerTokenRsp.getDefaultInstance().getCountryCode();
                onChanged();
                return this;
            }

            public Builder setCountryCodeBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenRsp.checkByteStringIsUtf8(value);
                this.countryCode_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public int getKeyId() {
                return this.keyId_;
            }

            public Builder setKeyId(int value) {
                this.keyId_ = value;
                onChanged();
                return this;
            }

            public Builder clearKeyId() {
                this.keyId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public String getBirthday() {
                Object ref = this.birthday_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.birthday_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
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
                this.birthday_ = GetPlayerTokenRsp.getDefaultInstance().getBirthday();
                onChanged();
                return this;
            }

            public Builder setBirthdayBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenRsp.checkByteStringIsUtf8(value);
                this.birthday_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public long getSecretKeySeed() {
                return this.secretKeySeed_;
            }

            public Builder setSecretKeySeed(long value) {
                this.secretKeySeed_ = value;
                onChanged();
                return this;
            }

            public Builder clearSecretKeySeed() {
                this.secretKeySeed_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public int getBlackUidEndTime() {
                return this.blackUidEndTime_;
            }

            public Builder setBlackUidEndTime(int value) {
                this.blackUidEndTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearBlackUidEndTime() {
                this.blackUidEndTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
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

            private void ensureFinishCollectionIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.finishCollectionIdList_ = GetPlayerTokenRsp.mutableCopy(this.finishCollectionIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public List<Integer> getFinishCollectionIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.finishCollectionIdList_) : this.finishCollectionIdList_;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public int getFinishCollectionIdListCount() {
                return this.finishCollectionIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public int getFinishCollectionIdList(int index) {
                return this.finishCollectionIdList_.getInt(index);
            }

            public Builder setFinishCollectionIdList(int index, int value) {
                ensureFinishCollectionIdListIsMutable();
                this.finishCollectionIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFinishCollectionIdList(int value) {
                ensureFinishCollectionIdListIsMutable();
                this.finishCollectionIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFinishCollectionIdList(Iterable<? extends Integer> values) {
                ensureFinishCollectionIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.finishCollectionIdList_);
                onChanged();
                return this;
            }

            public Builder clearFinishCollectionIdList() {
                this.finishCollectionIdList_ = GetPlayerTokenRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public String getAccountUid() {
                Object ref = this.accountUid_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.accountUid_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
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
                this.accountUid_ = GetPlayerTokenRsp.getDefaultInstance().getAccountUid();
                onChanged();
                return this;
            }

            public Builder setAccountUidBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenRsp.checkByteStringIsUtf8(value);
                this.accountUid_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public boolean getIsProficientPlayer() {
                return this.isProficientPlayer_;
            }

            public Builder setIsProficientPlayer(boolean value) {
                this.isProficientPlayer_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsProficientPlayer() {
                this.isProficientPlayer_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public String getSign() {
                Object ref = this.sign_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.sign_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public ByteString getSignBytes() {
                Object ref = this.sign_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.sign_ = b;
                return b;
            }

            public Builder setSign(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.sign_ = value;
                onChanged();
                return this;
            }

            public Builder clearSign() {
                this.sign_ = GetPlayerTokenRsp.getDefaultInstance().getSign();
                onChanged();
                return this;
            }

            public Builder setSignBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenRsp.checkByteStringIsUtf8(value);
                this.sign_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public boolean hasStopServer() {
                return (this.stopServerBuilder_ == null && this.stopServer_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public StopServerOuterClass.StopServer getStopServer() {
                if (this.stopServerBuilder_ == null) {
                    return this.stopServer_ == null ? StopServerOuterClass.StopServer.getDefaultInstance() : this.stopServer_;
                }
                return this.stopServerBuilder_.getMessage();
            }

            public Builder setStopServer(StopServerOuterClass.StopServer value) {
                if (this.stopServerBuilder_ != null) {
                    this.stopServerBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.stopServer_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setStopServer(StopServerOuterClass.StopServer.Builder builderForValue) {
                if (this.stopServerBuilder_ == null) {
                    this.stopServer_ = builderForValue.build();
                    onChanged();
                } else {
                    this.stopServerBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeStopServer(StopServerOuterClass.StopServer value) {
                if (this.stopServerBuilder_ == null) {
                    if (this.stopServer_ != null) {
                        this.stopServer_ = StopServerOuterClass.StopServer.newBuilder(this.stopServer_).mergeFrom(value).buildPartial();
                    } else {
                        this.stopServer_ = value;
                    }
                    onChanged();
                } else {
                    this.stopServerBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearStopServer() {
                if (this.stopServerBuilder_ == null) {
                    this.stopServer_ = null;
                    onChanged();
                } else {
                    this.stopServer_ = null;
                    this.stopServerBuilder_ = null;
                }
                return this;
            }

            public StopServerOuterClass.StopServer.Builder getStopServerBuilder() {
                onChanged();
                return getStopServerFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public StopServerOuterClass.StopServerOrBuilder getStopServerOrBuilder() {
                if (this.stopServerBuilder_ != null) {
                    return this.stopServerBuilder_.getMessageOrBuilder();
                }
                return this.stopServer_ == null ? StopServerOuterClass.StopServer.getDefaultInstance() : this.stopServer_;
            }

            private SingleFieldBuilderV3<StopServerOuterClass.StopServer, StopServerOuterClass.StopServer.Builder, StopServerOuterClass.StopServerOrBuilder> getStopServerFieldBuilder() {
                if (this.stopServerBuilder_ == null) {
                    this.stopServerBuilder_ = new SingleFieldBuilderV3<>(getStopServer(), getParentForChildren(), isClean());
                    this.stopServer_ = null;
                }
                return this.stopServerBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public String getPsnId() {
                Object ref = this.psnId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.psnId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
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
                this.psnId_ = GetPlayerTokenRsp.getDefaultInstance().getPsnId();
                onChanged();
                return this;
            }

            public Builder setPsnIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenRsp.checkByteStringIsUtf8(value);
                this.psnId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public int getCloudClientIp() {
                return this.cloudClientIp_;
            }

            public Builder setCloudClientIp(int value) {
                this.cloudClientIp_ = value;
                onChanged();
                return this;
            }

            public Builder clearCloudClientIp() {
                this.cloudClientIp_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public String getClientIpStr() {
                Object ref = this.clientIpStr_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.clientIpStr_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public ByteString getClientIpStrBytes() {
                Object ref = this.clientIpStr_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientIpStr_ = b;
                return b;
            }

            public Builder setClientIpStr(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientIpStr_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientIpStr() {
                this.clientIpStr_ = GetPlayerTokenRsp.getDefaultInstance().getClientIpStr();
                onChanged();
                return this;
            }

            public Builder setClientIpStrBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenRsp.checkByteStringIsUtf8(value);
                this.clientIpStr_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public String getServerRandKey() {
                Object ref = this.serverRandKey_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.serverRandKey_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public ByteString getServerRandKeyBytes() {
                Object ref = this.serverRandKey_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.serverRandKey_ = b;
                return b;
            }

            public Builder setServerRandKey(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.serverRandKey_ = value;
                onChanged();
                return this;
            }

            public Builder clearServerRandKey() {
                this.serverRandKey_ = GetPlayerTokenRsp.getDefaultInstance().getServerRandKey();
                onChanged();
                return this;
            }

            public Builder setServerRandKeyBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenRsp.checkByteStringIsUtf8(value);
                this.serverRandKey_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public boolean getUnk3300CFBHAHOHDKC() {
                return this.unk3300CFBHAHOHDKC_;
            }

            public Builder setUnk3300CFBHAHOHDKC(boolean value) {
                this.unk3300CFBHAHOHDKC_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300CFBHAHOHDKC() {
                this.unk3300CFBHAHOHDKC_ = false;
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

        public static GetPlayerTokenRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetPlayerTokenRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetPlayerTokenRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetPlayerTokenRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        StopServerOuterClass.getDescriptor();
    }
}
