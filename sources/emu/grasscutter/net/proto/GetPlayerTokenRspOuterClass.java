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
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.StopServerInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import org.eclipse.jetty.websocket.api.StatusCode;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerTokenRspOuterClass.class */
public final class GetPlayerTokenRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017GetPlayerTokenRsp.proto\u001a\u0014StopServerInfo.proto\"ñ\u0005\n\u0011GetPlayerTokenRsp\u0012\u001b\n\u0013security_cmd_buffer\u0018\u0006 \u0001(\f\u0012\u000e\n\u0006gm_uid\u0018\u0007 \u0001(\r\u0012\u0010\n\bis_guest\u0018\u000b \u0001(\b\u0012\u001b\n\u0013Unk3300_AJBBIPFMBEL\u0018~ \u0001(\b\u0012\u000f\n\u0006key_id\u0018\u0001 \u0001(\r\u0012\r\n\u0004sign\u0018\r \u0001(\t\u0012\u0012\n\nsecret_key\u0018\u000f \u0001(\t\u0012\u0014\n\faccount_type\u0018\b \u0001(\r\u0012\u0013\n\nchannel_id\u0018¤\u0005 \u0001(\r\u0012\u0016\n\u000eextra_bin_data\u0018\u0005 \u0001(\f\u0012\u0017\n\u000fsecret_key_seed\u0018\u0003 \u0001(\u0004\u0012\r\n\u0005token\u0018\r \u0001(\t\u0012\u0018\n\u000fserver_rand_key\u0018¤\t \u0001(\t\u0012\u0018\n\u000fcloud_client_ip\u0018\r \u0001(\r\u0012\u0011\n\bbirthday\u0018·\u000e \u0001(\t\u0012\f\n\u0003tag\u0018Ë\b \u0001(\r\u0012\u0016\n\rclient_ip_str\u0018æ\n \u0001(\t\u0012\u0017\n\u000esub_channel_id\u0018\b \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u0002 \u0001(\u0005\u0012\"\n\u0019client_version_random_key\u0018\t \u0001(\t\u0012\u000f\n\u0006psn_id\u0018ò\u0001 \u0001(\t\u0012\u001c\n\u0014is_proficient_player\u0018\t \u0001(\b\u0012\u0015\n\rplatform_type\u0018\n \u0001(\r\u0012\u0015\n\freg_platform\u0018\u0005 \u0001(\r\u0012%\n\u000bstop_server\u0018é\u000e \u0001(\u000b2\u000f.StopServerInfo\u0012\u001a\n\u0012black_uid_end_time\u0018\f \u0001(\r\u0012\u001c\n\u0013Unk3300_CFBHAHOHDKC\u0018ê\u0005 \u0001(\b\u0012\u0013\n\u000baccount_uid\u0018\u0001 \u0001(\t\u0012\"\n\u0019finish_collection_id_list\u0018æ\r \u0003(\r\u0012\u000b\n\u0003msg\u0018\u0004 \u0001(\t\u0012\u0015\n\fcountry_code\u0018õ\u0001 \u0001(\t\u0012\u000b\n\u0003uid\u0018\u000e \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{StopServerInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetPlayerTokenRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetPlayerTokenRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetPlayerTokenRsp_descriptor, new String[]{"SecurityCmdBuffer", "GmUid", "IsGuest", "Unk3300AJBBIPFMBEL", "KeyId", "Sign", "SecretKey", "AccountType", "ChannelId", "ExtraBinData", "SecretKeySeed", "Token", "ServerRandKey", "CloudClientIp", "Birthday", "Tag", "ClientIpStr", "SubChannelId", "Retcode", "ClientVersionRandomKey", "PsnId", "IsProficientPlayer", "PlatformType", "RegPlatform", "StopServer", "BlackUidEndTime", "Unk3300CFBHAHOHDKC", "AccountUid", "FinishCollectionIdList", "Msg", "CountryCode", "Uid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerTokenRspOuterClass$GetPlayerTokenRspOrBuilder.class */
    public interface GetPlayerTokenRspOrBuilder extends MessageOrBuilder {
        ByteString getSecurityCmdBuffer();

        int getGmUid();

        boolean getIsGuest();

        boolean getUnk3300AJBBIPFMBEL();

        int getKeyId();

        String getSign();

        ByteString getSignBytes();

        String getSecretKey();

        ByteString getSecretKeyBytes();

        int getAccountType();

        int getChannelId();

        ByteString getExtraBinData();

        long getSecretKeySeed();

        String getToken();

        ByteString getTokenBytes();

        String getServerRandKey();

        ByteString getServerRandKeyBytes();

        int getCloudClientIp();

        String getBirthday();

        ByteString getBirthdayBytes();

        int getTag();

        String getClientIpStr();

        ByteString getClientIpStrBytes();

        int getSubChannelId();

        int getRetcode();

        String getClientVersionRandomKey();

        ByteString getClientVersionRandomKeyBytes();

        String getPsnId();

        ByteString getPsnIdBytes();

        boolean getIsProficientPlayer();

        int getPlatformType();

        int getRegPlatform();

        boolean hasStopServer();

        StopServerInfoOuterClass.StopServerInfo getStopServer();

        StopServerInfoOuterClass.StopServerInfoOrBuilder getStopServerOrBuilder();

        int getBlackUidEndTime();

        boolean getUnk3300CFBHAHOHDKC();

        String getAccountUid();

        ByteString getAccountUidBytes();

        List<Integer> getFinishCollectionIdListList();

        int getFinishCollectionIdListCount();

        int getFinishCollectionIdList(int i);

        String getMsg();

        ByteString getMsgBytes();

        String getCountryCode();

        ByteString getCountryCodeBytes();

        int getUid();
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
        public static final int SECURITY_CMD_BUFFER_FIELD_NUMBER = 6;
        private ByteString securityCmdBuffer_;
        public static final int GM_UID_FIELD_NUMBER = 7;
        private int gmUid_;
        public static final int IS_GUEST_FIELD_NUMBER = 11;
        private boolean isGuest_;
        public static final int UNK3300_AJBBIPFMBEL_FIELD_NUMBER = 126;
        private boolean unk3300AJBBIPFMBEL_;
        public static final int KEY_ID_FIELD_NUMBER = 134;
        private int keyId_;
        public static final int SIGN_FIELD_NUMBER = 1666;
        private volatile Object sign_;
        public static final int SECRET_KEY_FIELD_NUMBER = 15;
        private volatile Object secretKey_;
        public static final int ACCOUNT_TYPE_FIELD_NUMBER = 8;
        private int accountType_;
        public static final int CHANNEL_ID_FIELD_NUMBER = 676;
        private int channelId_;
        public static final int EXTRA_BIN_DATA_FIELD_NUMBER = 5;
        private ByteString extraBinData_;
        public static final int SECRET_KEY_SEED_FIELD_NUMBER = 3;
        private long secretKeySeed_;
        public static final int TOKEN_FIELD_NUMBER = 13;
        private volatile Object token_;
        public static final int SERVER_RAND_KEY_FIELD_NUMBER = 1188;
        private volatile Object serverRandKey_;
        public static final int CLOUD_CLIENT_IP_FIELD_NUMBER = 1670;
        private int cloudClientIp_;
        public static final int BIRTHDAY_FIELD_NUMBER = 1847;
        private volatile Object birthday_;
        public static final int TAG_FIELD_NUMBER = 1099;
        private int tag_;
        public static final int CLIENT_IP_STR_FIELD_NUMBER = 1382;
        private volatile Object clientIpStr_;
        public static final int SUB_CHANNEL_ID_FIELD_NUMBER = 1038;
        private int subChannelId_;
        public static final int RETCODE_FIELD_NUMBER = 2;
        private int retcode_;
        public static final int CLIENT_VERSION_RANDOM_KEY_FIELD_NUMBER = 1152;
        private volatile Object clientVersionRandomKey_;
        public static final int PSN_ID_FIELD_NUMBER = 242;
        private volatile Object psnId_;
        public static final int IS_PROFICIENT_PLAYER_FIELD_NUMBER = 9;
        private boolean isProficientPlayer_;
        public static final int PLATFORM_TYPE_FIELD_NUMBER = 10;
        private int platformType_;
        public static final int REG_PLATFORM_FIELD_NUMBER = 646;
        private int regPlatform_;
        public static final int STOP_SERVER_FIELD_NUMBER = 1897;
        private StopServerInfoOuterClass.StopServerInfo stopServer_;
        public static final int BLACK_UID_END_TIME_FIELD_NUMBER = 12;
        private int blackUidEndTime_;
        public static final int UNK3300_CFBHAHOHDKC_FIELD_NUMBER = 746;
        private boolean unk3300CFBHAHOHDKC_;
        public static final int ACCOUNT_UID_FIELD_NUMBER = 1;
        private volatile Object accountUid_;
        public static final int FINISH_COLLECTION_ID_LIST_FIELD_NUMBER = 1766;
        private Internal.IntList finishCollectionIdList_;
        private int finishCollectionIdListMemoizedSerializedSize;
        public static final int MSG_FIELD_NUMBER = 4;
        private volatile Object msg_;
        public static final int COUNTRY_CODE_FIELD_NUMBER = 245;
        private volatile Object countryCode_;
        public static final int UID_FIELD_NUMBER = 14;
        private int uid_;
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
            this.securityCmdBuffer_ = ByteString.EMPTY;
            this.sign_ = "";
            this.secretKey_ = "";
            this.extraBinData_ = ByteString.EMPTY;
            this.token_ = "";
            this.serverRandKey_ = "";
            this.birthday_ = "";
            this.clientIpStr_ = "";
            this.clientVersionRandomKey_ = "";
            this.psnId_ = "";
            this.accountUid_ = "";
            this.finishCollectionIdList_ = emptyIntList();
            this.msg_ = "";
            this.countryCode_ = "";
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
                            case 10:
                                this.accountUid_ = input.readStringRequireUtf8();
                                break;
                            case 16:
                                this.retcode_ = input.readInt32();
                                break;
                            case 24:
                                this.secretKeySeed_ = input.readUInt64();
                                break;
                            case 34:
                                this.msg_ = input.readStringRequireUtf8();
                                break;
                            case 42:
                                this.extraBinData_ = input.readBytes();
                                break;
                            case 50:
                                this.securityCmdBuffer_ = input.readBytes();
                                break;
                            case 56:
                                this.gmUid_ = input.readUInt32();
                                break;
                            case 64:
                                this.accountType_ = input.readUInt32();
                                break;
                            case 72:
                                this.isProficientPlayer_ = input.readBool();
                                break;
                            case 80:
                                this.platformType_ = input.readUInt32();
                                break;
                            case 88:
                                this.isGuest_ = input.readBool();
                                break;
                            case 96:
                                this.blackUidEndTime_ = input.readUInt32();
                                break;
                            case 106:
                                this.token_ = input.readStringRequireUtf8();
                                break;
                            case 112:
                                this.uid_ = input.readUInt32();
                                break;
                            case 122:
                                this.secretKey_ = input.readStringRequireUtf8();
                                break;
                            case StatusCode.POLICY_VIOLATION /* 1008 */:
                                this.unk3300AJBBIPFMBEL_ = input.readBool();
                                break;
                            case 1072:
                                this.keyId_ = input.readUInt32();
                                break;
                            case 1938:
                                this.psnId_ = input.readStringRequireUtf8();
                                break;
                            case 1962:
                                this.countryCode_ = input.readStringRequireUtf8();
                                break;
                            case 5168:
                                this.regPlatform_ = input.readUInt32();
                                break;
                            case 5408:
                                this.channelId_ = input.readUInt32();
                                break;
                            case 5968:
                                this.unk3300CFBHAHOHDKC_ = input.readBool();
                                break;
                            case 8304:
                                this.subChannelId_ = input.readUInt32();
                                break;
                            case PacketOpcodes.IrodoriMasterGallerySettleNotify:
                                this.tag_ = input.readUInt32();
                                break;
                            case 9218:
                                this.clientVersionRandomKey_ = input.readStringRequireUtf8();
                                break;
                            case 9506:
                                this.serverRandKey_ = input.readStringRequireUtf8();
                                break;
                            case RET_CUSTOM_DUNGEON_INTERNAL_FAIL_VALUE:
                                this.clientIpStr_ = input.readStringRequireUtf8();
                                break;
                            case 13330:
                                this.sign_ = input.readStringRequireUtf8();
                                break;
                            case 13360:
                                this.cloudClientIp_ = input.readUInt32();
                                break;
                            case 14128:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.finishCollectionIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.finishCollectionIdList_.addInt(input.readUInt32());
                                break;
                            case 14130:
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
                            case 14778:
                                this.birthday_ = input.readStringRequireUtf8();
                                break;
                            case 15178:
                                StopServerInfoOuterClass.StopServerInfo.Builder subBuilder = this.stopServer_ != null ? this.stopServer_.toBuilder() : null;
                                this.stopServer_ = (StopServerInfoOuterClass.StopServerInfo) input.readMessage(StopServerInfoOuterClass.StopServerInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.stopServer_);
                                    this.stopServer_ = subBuilder.buildPartial();
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
        public ByteString getSecurityCmdBuffer() {
            return this.securityCmdBuffer_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getGmUid() {
            return this.gmUid_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public boolean getIsGuest() {
            return this.isGuest_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public boolean getUnk3300AJBBIPFMBEL() {
            return this.unk3300AJBBIPFMBEL_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getKeyId() {
            return this.keyId_;
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
        public int getChannelId() {
            return this.channelId_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public ByteString getExtraBinData() {
            return this.extraBinData_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public long getSecretKeySeed() {
            return this.secretKeySeed_;
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
        public int getCloudClientIp() {
            return this.cloudClientIp_;
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
        public int getTag() {
            return this.tag_;
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
        public int getSubChannelId() {
            return this.subChannelId_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
        public boolean getIsProficientPlayer() {
            return this.isProficientPlayer_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getPlatformType() {
            return this.platformType_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getRegPlatform() {
            return this.regPlatform_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public boolean hasStopServer() {
            return this.stopServer_ != null;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public StopServerInfoOuterClass.StopServerInfo getStopServer() {
            return this.stopServer_ == null ? StopServerInfoOuterClass.StopServerInfo.getDefaultInstance() : this.stopServer_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public StopServerInfoOuterClass.StopServerInfoOrBuilder getStopServerOrBuilder() {
            return getStopServer();
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public int getBlackUidEndTime() {
            return this.blackUidEndTime_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
        public boolean getUnk3300CFBHAHOHDKC() {
            return this.unk3300CFBHAHOHDKC_;
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
        public int getUid() {
            return this.uid_;
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
            if (!GeneratedMessageV3.isStringEmpty(this.accountUid_)) {
                GeneratedMessageV3.writeString(output, 1, this.accountUid_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(2, this.retcode_);
            }
            if (this.secretKeySeed_ != 0) {
                output.writeUInt64(3, this.secretKeySeed_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.msg_)) {
                GeneratedMessageV3.writeString(output, 4, this.msg_);
            }
            if (!this.extraBinData_.isEmpty()) {
                output.writeBytes(5, this.extraBinData_);
            }
            if (!this.securityCmdBuffer_.isEmpty()) {
                output.writeBytes(6, this.securityCmdBuffer_);
            }
            if (this.gmUid_ != 0) {
                output.writeUInt32(7, this.gmUid_);
            }
            if (this.accountType_ != 0) {
                output.writeUInt32(8, this.accountType_);
            }
            if (this.isProficientPlayer_) {
                output.writeBool(9, this.isProficientPlayer_);
            }
            if (this.platformType_ != 0) {
                output.writeUInt32(10, this.platformType_);
            }
            if (this.isGuest_) {
                output.writeBool(11, this.isGuest_);
            }
            if (this.blackUidEndTime_ != 0) {
                output.writeUInt32(12, this.blackUidEndTime_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.token_)) {
                GeneratedMessageV3.writeString(output, 13, this.token_);
            }
            if (this.uid_ != 0) {
                output.writeUInt32(14, this.uid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.secretKey_)) {
                GeneratedMessageV3.writeString(output, 15, this.secretKey_);
            }
            if (this.unk3300AJBBIPFMBEL_) {
                output.writeBool(126, this.unk3300AJBBIPFMBEL_);
            }
            if (this.keyId_ != 0) {
                output.writeUInt32(134, this.keyId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.psnId_)) {
                GeneratedMessageV3.writeString(output, 242, this.psnId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.countryCode_)) {
                GeneratedMessageV3.writeString(output, 245, this.countryCode_);
            }
            if (this.regPlatform_ != 0) {
                output.writeUInt32(646, this.regPlatform_);
            }
            if (this.channelId_ != 0) {
                output.writeUInt32(676, this.channelId_);
            }
            if (this.unk3300CFBHAHOHDKC_) {
                output.writeBool(UNK3300_CFBHAHOHDKC_FIELD_NUMBER, this.unk3300CFBHAHOHDKC_);
            }
            if (this.subChannelId_ != 0) {
                output.writeUInt32(SUB_CHANNEL_ID_FIELD_NUMBER, this.subChannelId_);
            }
            if (this.tag_ != 0) {
                output.writeUInt32(1099, this.tag_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientVersionRandomKey_)) {
                GeneratedMessageV3.writeString(output, CLIENT_VERSION_RANDOM_KEY_FIELD_NUMBER, this.clientVersionRandomKey_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.serverRandKey_)) {
                GeneratedMessageV3.writeString(output, SERVER_RAND_KEY_FIELD_NUMBER, this.serverRandKey_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientIpStr_)) {
                GeneratedMessageV3.writeString(output, CLIENT_IP_STR_FIELD_NUMBER, this.clientIpStr_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.sign_)) {
                GeneratedMessageV3.writeString(output, 1666, this.sign_);
            }
            if (this.cloudClientIp_ != 0) {
                output.writeUInt32(CLOUD_CLIENT_IP_FIELD_NUMBER, this.cloudClientIp_);
            }
            if (getFinishCollectionIdListList().size() > 0) {
                output.writeUInt32NoTag(14130);
                output.writeUInt32NoTag(this.finishCollectionIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.finishCollectionIdList_.size(); i++) {
                output.writeUInt32NoTag(this.finishCollectionIdList_.getInt(i));
            }
            if (!GeneratedMessageV3.isStringEmpty(this.birthday_)) {
                GeneratedMessageV3.writeString(output, BIRTHDAY_FIELD_NUMBER, this.birthday_);
            }
            if (this.stopServer_ != null) {
                output.writeMessage(STOP_SERVER_FIELD_NUMBER, getStopServer());
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
            if (!GeneratedMessageV3.isStringEmpty(this.accountUid_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(1, this.accountUid_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(2, this.retcode_);
            }
            if (this.secretKeySeed_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(3, this.secretKeySeed_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.msg_)) {
                size2 += GeneratedMessageV3.computeStringSize(4, this.msg_);
            }
            if (!this.extraBinData_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(5, this.extraBinData_);
            }
            if (!this.securityCmdBuffer_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(6, this.securityCmdBuffer_);
            }
            if (this.gmUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.gmUid_);
            }
            if (this.accountType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.accountType_);
            }
            if (this.isProficientPlayer_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.isProficientPlayer_);
            }
            if (this.platformType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.platformType_);
            }
            if (this.isGuest_) {
                size2 += CodedOutputStream.computeBoolSize(11, this.isGuest_);
            }
            if (this.blackUidEndTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.blackUidEndTime_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.token_)) {
                size2 += GeneratedMessageV3.computeStringSize(13, this.token_);
            }
            if (this.uid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.uid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.secretKey_)) {
                size2 += GeneratedMessageV3.computeStringSize(15, this.secretKey_);
            }
            if (this.unk3300AJBBIPFMBEL_) {
                size2 += CodedOutputStream.computeBoolSize(126, this.unk3300AJBBIPFMBEL_);
            }
            if (this.keyId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(134, this.keyId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.psnId_)) {
                size2 += GeneratedMessageV3.computeStringSize(242, this.psnId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.countryCode_)) {
                size2 += GeneratedMessageV3.computeStringSize(245, this.countryCode_);
            }
            if (this.regPlatform_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(646, this.regPlatform_);
            }
            if (this.channelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(676, this.channelId_);
            }
            if (this.unk3300CFBHAHOHDKC_) {
                size2 += CodedOutputStream.computeBoolSize(UNK3300_CFBHAHOHDKC_FIELD_NUMBER, this.unk3300CFBHAHOHDKC_);
            }
            if (this.subChannelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(SUB_CHANNEL_ID_FIELD_NUMBER, this.subChannelId_);
            }
            if (this.tag_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(1099, this.tag_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientVersionRandomKey_)) {
                size2 += GeneratedMessageV3.computeStringSize(CLIENT_VERSION_RANDOM_KEY_FIELD_NUMBER, this.clientVersionRandomKey_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.serverRandKey_)) {
                size2 += GeneratedMessageV3.computeStringSize(SERVER_RAND_KEY_FIELD_NUMBER, this.serverRandKey_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientIpStr_)) {
                size2 += GeneratedMessageV3.computeStringSize(CLIENT_IP_STR_FIELD_NUMBER, this.clientIpStr_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.sign_)) {
                size2 += GeneratedMessageV3.computeStringSize(1666, this.sign_);
            }
            if (this.cloudClientIp_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(CLOUD_CLIENT_IP_FIELD_NUMBER, this.cloudClientIp_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.birthday_)) {
                size3 += GeneratedMessageV3.computeStringSize(BIRTHDAY_FIELD_NUMBER, this.birthday_);
            }
            if (this.stopServer_ != null) {
                size3 += CodedOutputStream.computeMessageSize(STOP_SERVER_FIELD_NUMBER, getStopServer());
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
            if (getSecurityCmdBuffer().equals(other.getSecurityCmdBuffer()) && getGmUid() == other.getGmUid() && getIsGuest() == other.getIsGuest() && getUnk3300AJBBIPFMBEL() == other.getUnk3300AJBBIPFMBEL() && getKeyId() == other.getKeyId() && getSign().equals(other.getSign()) && getSecretKey().equals(other.getSecretKey()) && getAccountType() == other.getAccountType() && getChannelId() == other.getChannelId() && getExtraBinData().equals(other.getExtraBinData()) && getSecretKeySeed() == other.getSecretKeySeed() && getToken().equals(other.getToken()) && getServerRandKey().equals(other.getServerRandKey()) && getCloudClientIp() == other.getCloudClientIp() && getBirthday().equals(other.getBirthday()) && getTag() == other.getTag() && getClientIpStr().equals(other.getClientIpStr()) && getSubChannelId() == other.getSubChannelId() && getRetcode() == other.getRetcode() && getClientVersionRandomKey().equals(other.getClientVersionRandomKey()) && getPsnId().equals(other.getPsnId()) && getIsProficientPlayer() == other.getIsProficientPlayer() && getPlatformType() == other.getPlatformType() && getRegPlatform() == other.getRegPlatform() && hasStopServer() == other.hasStopServer()) {
                return (!hasStopServer() || getStopServer().equals(other.getStopServer())) && getBlackUidEndTime() == other.getBlackUidEndTime() && getUnk3300CFBHAHOHDKC() == other.getUnk3300CFBHAHOHDKC() && getAccountUid().equals(other.getAccountUid()) && getFinishCollectionIdListList().equals(other.getFinishCollectionIdListList()) && getMsg().equals(other.getMsg()) && getCountryCode().equals(other.getCountryCode()) && getUid() == other.getUid() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getSecurityCmdBuffer().hashCode())) + 7)) + getGmUid())) + 11)) + Internal.hashBoolean(getIsGuest()))) + 126)) + Internal.hashBoolean(getUnk3300AJBBIPFMBEL()))) + 134)) + getKeyId())) + 1666)) + getSign().hashCode())) + 15)) + getSecretKey().hashCode())) + 8)) + getAccountType())) + 676)) + getChannelId())) + 5)) + getExtraBinData().hashCode())) + 3)) + Internal.hashLong(getSecretKeySeed()))) + 13)) + getToken().hashCode())) + SERVER_RAND_KEY_FIELD_NUMBER)) + getServerRandKey().hashCode())) + CLOUD_CLIENT_IP_FIELD_NUMBER)) + getCloudClientIp())) + BIRTHDAY_FIELD_NUMBER)) + getBirthday().hashCode())) + 1099)) + getTag())) + CLIENT_IP_STR_FIELD_NUMBER)) + getClientIpStr().hashCode())) + SUB_CHANNEL_ID_FIELD_NUMBER)) + getSubChannelId())) + 2)) + getRetcode())) + CLIENT_VERSION_RANDOM_KEY_FIELD_NUMBER)) + getClientVersionRandomKey().hashCode())) + 242)) + getPsnId().hashCode())) + 9)) + Internal.hashBoolean(getIsProficientPlayer()))) + 10)) + getPlatformType())) + 646)) + getRegPlatform();
            if (hasStopServer()) {
                hash = (53 * ((37 * hash) + STOP_SERVER_FIELD_NUMBER)) + getStopServer().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 12)) + getBlackUidEndTime())) + UNK3300_CFBHAHOHDKC_FIELD_NUMBER)) + Internal.hashBoolean(getUnk3300CFBHAHOHDKC()))) + 1)) + getAccountUid().hashCode();
            if (getFinishCollectionIdListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 1766)) + getFinishCollectionIdListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 4)) + getMsg().hashCode())) + 245)) + getCountryCode().hashCode())) + 14)) + getUid())) + this.unknownFields.hashCode();
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
            private int gmUid_;
            private boolean isGuest_;
            private boolean unk3300AJBBIPFMBEL_;
            private int keyId_;
            private int accountType_;
            private int channelId_;
            private long secretKeySeed_;
            private int cloudClientIp_;
            private int tag_;
            private int subChannelId_;
            private int retcode_;
            private boolean isProficientPlayer_;
            private int platformType_;
            private int regPlatform_;
            private StopServerInfoOuterClass.StopServerInfo stopServer_;
            private SingleFieldBuilderV3<StopServerInfoOuterClass.StopServerInfo, StopServerInfoOuterClass.StopServerInfo.Builder, StopServerInfoOuterClass.StopServerInfoOrBuilder> stopServerBuilder_;
            private int blackUidEndTime_;
            private boolean unk3300CFBHAHOHDKC_;
            private int uid_;
            private ByteString securityCmdBuffer_ = ByteString.EMPTY;
            private Object sign_ = "";
            private Object secretKey_ = "";
            private ByteString extraBinData_ = ByteString.EMPTY;
            private Object token_ = "";
            private Object serverRandKey_ = "";
            private Object birthday_ = "";
            private Object clientIpStr_ = "";
            private Object clientVersionRandomKey_ = "";
            private Object psnId_ = "";
            private Object accountUid_ = "";
            private Internal.IntList finishCollectionIdList_ = GetPlayerTokenRsp.emptyIntList();
            private Object msg_ = "";
            private Object countryCode_ = "";

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
                this.securityCmdBuffer_ = ByteString.EMPTY;
                this.gmUid_ = 0;
                this.isGuest_ = false;
                this.unk3300AJBBIPFMBEL_ = false;
                this.keyId_ = 0;
                this.sign_ = "";
                this.secretKey_ = "";
                this.accountType_ = 0;
                this.channelId_ = 0;
                this.extraBinData_ = ByteString.EMPTY;
                this.secretKeySeed_ = 0;
                this.token_ = "";
                this.serverRandKey_ = "";
                this.cloudClientIp_ = 0;
                this.birthday_ = "";
                this.tag_ = 0;
                this.clientIpStr_ = "";
                this.subChannelId_ = 0;
                this.retcode_ = 0;
                this.clientVersionRandomKey_ = "";
                this.psnId_ = "";
                this.isProficientPlayer_ = false;
                this.platformType_ = 0;
                this.regPlatform_ = 0;
                if (this.stopServerBuilder_ == null) {
                    this.stopServer_ = null;
                } else {
                    this.stopServer_ = null;
                    this.stopServerBuilder_ = null;
                }
                this.blackUidEndTime_ = 0;
                this.unk3300CFBHAHOHDKC_ = false;
                this.accountUid_ = "";
                this.finishCollectionIdList_ = GetPlayerTokenRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.msg_ = "";
                this.countryCode_ = "";
                this.uid_ = 0;
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
                result.securityCmdBuffer_ = this.securityCmdBuffer_;
                result.gmUid_ = this.gmUid_;
                result.isGuest_ = this.isGuest_;
                result.unk3300AJBBIPFMBEL_ = this.unk3300AJBBIPFMBEL_;
                result.keyId_ = this.keyId_;
                result.sign_ = this.sign_;
                result.secretKey_ = this.secretKey_;
                result.accountType_ = this.accountType_;
                result.channelId_ = this.channelId_;
                result.extraBinData_ = this.extraBinData_;
                result.secretKeySeed_ = this.secretKeySeed_;
                result.token_ = this.token_;
                result.serverRandKey_ = this.serverRandKey_;
                result.cloudClientIp_ = this.cloudClientIp_;
                result.birthday_ = this.birthday_;
                result.tag_ = this.tag_;
                result.clientIpStr_ = this.clientIpStr_;
                result.subChannelId_ = this.subChannelId_;
                result.retcode_ = this.retcode_;
                result.clientVersionRandomKey_ = this.clientVersionRandomKey_;
                result.psnId_ = this.psnId_;
                result.isProficientPlayer_ = this.isProficientPlayer_;
                result.platformType_ = this.platformType_;
                result.regPlatform_ = this.regPlatform_;
                if (this.stopServerBuilder_ == null) {
                    result.stopServer_ = this.stopServer_;
                } else {
                    result.stopServer_ = this.stopServerBuilder_.build();
                }
                result.blackUidEndTime_ = this.blackUidEndTime_;
                result.unk3300CFBHAHOHDKC_ = this.unk3300CFBHAHOHDKC_;
                result.accountUid_ = this.accountUid_;
                if ((this.bitField0_ & 1) != 0) {
                    this.finishCollectionIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.finishCollectionIdList_ = this.finishCollectionIdList_;
                result.msg_ = this.msg_;
                result.countryCode_ = this.countryCode_;
                result.uid_ = this.uid_;
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
                if (other.getSecurityCmdBuffer() != ByteString.EMPTY) {
                    setSecurityCmdBuffer(other.getSecurityCmdBuffer());
                }
                if (other.getGmUid() != 0) {
                    setGmUid(other.getGmUid());
                }
                if (other.getIsGuest()) {
                    setIsGuest(other.getIsGuest());
                }
                if (other.getUnk3300AJBBIPFMBEL()) {
                    setUnk3300AJBBIPFMBEL(other.getUnk3300AJBBIPFMBEL());
                }
                if (other.getKeyId() != 0) {
                    setKeyId(other.getKeyId());
                }
                if (!other.getSign().isEmpty()) {
                    this.sign_ = other.sign_;
                    onChanged();
                }
                if (!other.getSecretKey().isEmpty()) {
                    this.secretKey_ = other.secretKey_;
                    onChanged();
                }
                if (other.getAccountType() != 0) {
                    setAccountType(other.getAccountType());
                }
                if (other.getChannelId() != 0) {
                    setChannelId(other.getChannelId());
                }
                if (other.getExtraBinData() != ByteString.EMPTY) {
                    setExtraBinData(other.getExtraBinData());
                }
                if (other.getSecretKeySeed() != 0) {
                    setSecretKeySeed(other.getSecretKeySeed());
                }
                if (!other.getToken().isEmpty()) {
                    this.token_ = other.token_;
                    onChanged();
                }
                if (!other.getServerRandKey().isEmpty()) {
                    this.serverRandKey_ = other.serverRandKey_;
                    onChanged();
                }
                if (other.getCloudClientIp() != 0) {
                    setCloudClientIp(other.getCloudClientIp());
                }
                if (!other.getBirthday().isEmpty()) {
                    this.birthday_ = other.birthday_;
                    onChanged();
                }
                if (other.getTag() != 0) {
                    setTag(other.getTag());
                }
                if (!other.getClientIpStr().isEmpty()) {
                    this.clientIpStr_ = other.clientIpStr_;
                    onChanged();
                }
                if (other.getSubChannelId() != 0) {
                    setSubChannelId(other.getSubChannelId());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (!other.getClientVersionRandomKey().isEmpty()) {
                    this.clientVersionRandomKey_ = other.clientVersionRandomKey_;
                    onChanged();
                }
                if (!other.getPsnId().isEmpty()) {
                    this.psnId_ = other.psnId_;
                    onChanged();
                }
                if (other.getIsProficientPlayer()) {
                    setIsProficientPlayer(other.getIsProficientPlayer());
                }
                if (other.getPlatformType() != 0) {
                    setPlatformType(other.getPlatformType());
                }
                if (other.getRegPlatform() != 0) {
                    setRegPlatform(other.getRegPlatform());
                }
                if (other.hasStopServer()) {
                    mergeStopServer(other.getStopServer());
                }
                if (other.getBlackUidEndTime() != 0) {
                    setBlackUidEndTime(other.getBlackUidEndTime());
                }
                if (other.getUnk3300CFBHAHOHDKC()) {
                    setUnk3300CFBHAHOHDKC(other.getUnk3300CFBHAHOHDKC());
                }
                if (!other.getAccountUid().isEmpty()) {
                    this.accountUid_ = other.accountUid_;
                    onChanged();
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
                if (!other.getMsg().isEmpty()) {
                    this.msg_ = other.msg_;
                    onChanged();
                }
                if (!other.getCountryCode().isEmpty()) {
                    this.countryCode_ = other.countryCode_;
                    onChanged();
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
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
            public boolean hasStopServer() {
                return (this.stopServerBuilder_ == null && this.stopServer_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public StopServerInfoOuterClass.StopServerInfo getStopServer() {
                if (this.stopServerBuilder_ == null) {
                    return this.stopServer_ == null ? StopServerInfoOuterClass.StopServerInfo.getDefaultInstance() : this.stopServer_;
                }
                return this.stopServerBuilder_.getMessage();
            }

            public Builder setStopServer(StopServerInfoOuterClass.StopServerInfo value) {
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

            public Builder setStopServer(StopServerInfoOuterClass.StopServerInfo.Builder builderForValue) {
                if (this.stopServerBuilder_ == null) {
                    this.stopServer_ = builderForValue.build();
                    onChanged();
                } else {
                    this.stopServerBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeStopServer(StopServerInfoOuterClass.StopServerInfo value) {
                if (this.stopServerBuilder_ == null) {
                    if (this.stopServer_ != null) {
                        this.stopServer_ = StopServerInfoOuterClass.StopServerInfo.newBuilder(this.stopServer_).mergeFrom(value).buildPartial();
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

            public StopServerInfoOuterClass.StopServerInfo.Builder getStopServerBuilder() {
                onChanged();
                return getStopServerFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass.GetPlayerTokenRspOrBuilder
            public StopServerInfoOuterClass.StopServerInfoOrBuilder getStopServerOrBuilder() {
                if (this.stopServerBuilder_ != null) {
                    return this.stopServerBuilder_.getMessageOrBuilder();
                }
                return this.stopServer_ == null ? StopServerInfoOuterClass.StopServerInfo.getDefaultInstance() : this.stopServer_;
            }

            private SingleFieldBuilderV3<StopServerInfoOuterClass.StopServerInfo, StopServerInfoOuterClass.StopServerInfo.Builder, StopServerInfoOuterClass.StopServerInfoOrBuilder> getStopServerFieldBuilder() {
                if (this.stopServerBuilder_ == null) {
                    this.stopServerBuilder_ = new SingleFieldBuilderV3<>(getStopServer(), getParentForChildren(), isClean());
                    this.stopServer_ = null;
                }
                return this.stopServerBuilder_;
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
        StopServerInfoOuterClass.getDescriptor();
    }
}
