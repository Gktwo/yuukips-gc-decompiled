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
import emu.grasscutter.net.proto.ResVersionConfigOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RegionInfoOuterClass.class */
public final class RegionInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010RegionInfo.proto\u001a\u0016ResVersionConfig.proto\"¯\u0006\n\nRegionInfo\u0012\u0015\n\rgateserver_ip\u0018\u0001 \u0001(\t\u0012\u0017\n\u000fgateserver_port\u0018\u0002 \u0001(\r\u0012\u0018\n\u0010pay_callback_url\u0018\u0003 \u0001(\t\u0012\u0011\n\tarea_type\u0018\u0007 \u0001(\t\u0012\u0014\n\fresource_url\u0018\b \u0001(\t\u0012\u0010\n\bdata_url\u0018\t \u0001(\t\u0012\u0014\n\ffeedback_url\u0018\n \u0001(\t\u0012\u0014\n\fbulletin_url\u0018\u000b \u0001(\t\u0012\u0018\n\u0010resource_url_bak\u0018\f \u0001(\t\u0012\u0014\n\fdata_url_bak\u0018\r \u0001(\t\u0012\u001b\n\u0013client_data_version\u0018\u000e \u0001(\r\u0012\u0014\n\fhandbook_url\u0018\u0010 \u0001(\t\u0012#\n\u001bclient_silence_data_version\u0018\u0012 \u0001(\r\u0012\u0017\n\u000fclient_data_md5\u0018\u0013 \u0001(\t\u0012\u001f\n\u0017client_silence_data_md5\u0018\u0014 \u0001(\t\u0012-\n\u0012res_version_config\u0018\u0016 \u0001(\u000b2\u0011.ResVersionConfig\u0012\u0012\n\nsecret_key\u0018\u0017 \u0001(\f\u0012\u001e\n\u0016official_community_url\u0018\u0018 \u0001(\t\u0012\u001d\n\u0015client_version_suffix\u0018\u001a \u0001(\t\u0012%\n\u001dclient_silence_version_suffix\u0018\u001b \u0001(\t\u0012\"\n\u001ause_gateserver_domain_name\u0018\u001c \u0001(\b\u0012\u001e\n\u0016gateserver_domain_name\u0018\u001d \u0001(\t\u0012\u0017\n\u000fuser_center_url\u0018\u001e \u0001(\t\u0012\u0018\n\u0010account_bind_url\u0018\u001f \u0001(\t\u0012\u0011\n\tcdkey_url\u0018  \u0001(\t\u0012\u001a\n\u0012privacy_policy_url\u0018! \u0001(\t\u0012\u0019\n\u0011next_resource_url\u0018\" \u0001(\t\u00122\n\u0017next_res_version_config\u0018# \u0001(\u000b2\u0011.ResVersionConfig\u0012\u0010\n\bgame_biz\u0018$ \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ResVersionConfigOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_RegionInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RegionInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RegionInfo_descriptor, new String[]{"GateserverIp", "GateserverPort", "PayCallbackUrl", "AreaType", "ResourceUrl", "DataUrl", "FeedbackUrl", "BulletinUrl", "ResourceUrlBak", "DataUrlBak", "ClientDataVersion", "HandbookUrl", "ClientSilenceDataVersion", "ClientDataMd5", "ClientSilenceDataMd5", "ResVersionConfig", "SecretKey", "OfficialCommunityUrl", "ClientVersionSuffix", "ClientSilenceVersionSuffix", "UseGateserverDomainName", "GateserverDomainName", "UserCenterUrl", "AccountBindUrl", "CdkeyUrl", "PrivacyPolicyUrl", "NextResourceUrl", "NextResVersionConfig", "GameBiz"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RegionInfoOuterClass$RegionInfoOrBuilder.class */
    public interface RegionInfoOrBuilder extends MessageOrBuilder {
        String getGateserverIp();

        ByteString getGateserverIpBytes();

        int getGateserverPort();

        String getPayCallbackUrl();

        ByteString getPayCallbackUrlBytes();

        String getAreaType();

        ByteString getAreaTypeBytes();

        String getResourceUrl();

        ByteString getResourceUrlBytes();

        String getDataUrl();

        ByteString getDataUrlBytes();

        String getFeedbackUrl();

        ByteString getFeedbackUrlBytes();

        String getBulletinUrl();

        ByteString getBulletinUrlBytes();

        String getResourceUrlBak();

        ByteString getResourceUrlBakBytes();

        String getDataUrlBak();

        ByteString getDataUrlBakBytes();

        int getClientDataVersion();

        String getHandbookUrl();

        ByteString getHandbookUrlBytes();

        int getClientSilenceDataVersion();

        String getClientDataMd5();

        ByteString getClientDataMd5Bytes();

        String getClientSilenceDataMd5();

        ByteString getClientSilenceDataMd5Bytes();

        boolean hasResVersionConfig();

        ResVersionConfigOuterClass.ResVersionConfig getResVersionConfig();

        ResVersionConfigOuterClass.ResVersionConfigOrBuilder getResVersionConfigOrBuilder();

        ByteString getSecretKey();

        String getOfficialCommunityUrl();

        ByteString getOfficialCommunityUrlBytes();

        String getClientVersionSuffix();

        ByteString getClientVersionSuffixBytes();

        String getClientSilenceVersionSuffix();

        ByteString getClientSilenceVersionSuffixBytes();

        boolean getUseGateserverDomainName();

        String getGateserverDomainName();

        ByteString getGateserverDomainNameBytes();

        String getUserCenterUrl();

        ByteString getUserCenterUrlBytes();

        String getAccountBindUrl();

        ByteString getAccountBindUrlBytes();

        String getCdkeyUrl();

        ByteString getCdkeyUrlBytes();

        String getPrivacyPolicyUrl();

        ByteString getPrivacyPolicyUrlBytes();

        String getNextResourceUrl();

        ByteString getNextResourceUrlBytes();

        boolean hasNextResVersionConfig();

        ResVersionConfigOuterClass.ResVersionConfig getNextResVersionConfig();

        ResVersionConfigOuterClass.ResVersionConfigOrBuilder getNextResVersionConfigOrBuilder();

        String getGameBiz();

        ByteString getGameBizBytes();
    }

    private RegionInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RegionInfoOuterClass$RegionInfo.class */
    public static final class RegionInfo extends GeneratedMessageV3 implements RegionInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GATESERVER_IP_FIELD_NUMBER = 1;
        private volatile Object gateserverIp_;
        public static final int GATESERVER_PORT_FIELD_NUMBER = 2;
        private int gateserverPort_;
        public static final int PAY_CALLBACK_URL_FIELD_NUMBER = 3;
        private volatile Object payCallbackUrl_;
        public static final int AREA_TYPE_FIELD_NUMBER = 7;
        private volatile Object areaType_;
        public static final int RESOURCE_URL_FIELD_NUMBER = 8;
        private volatile Object resourceUrl_;
        public static final int DATA_URL_FIELD_NUMBER = 9;
        private volatile Object dataUrl_;
        public static final int FEEDBACK_URL_FIELD_NUMBER = 10;
        private volatile Object feedbackUrl_;
        public static final int BULLETIN_URL_FIELD_NUMBER = 11;
        private volatile Object bulletinUrl_;
        public static final int RESOURCE_URL_BAK_FIELD_NUMBER = 12;
        private volatile Object resourceUrlBak_;
        public static final int DATA_URL_BAK_FIELD_NUMBER = 13;
        private volatile Object dataUrlBak_;
        public static final int CLIENT_DATA_VERSION_FIELD_NUMBER = 14;
        private int clientDataVersion_;
        public static final int HANDBOOK_URL_FIELD_NUMBER = 16;
        private volatile Object handbookUrl_;
        public static final int CLIENT_SILENCE_DATA_VERSION_FIELD_NUMBER = 18;
        private int clientSilenceDataVersion_;
        public static final int CLIENT_DATA_MD5_FIELD_NUMBER = 19;
        private volatile Object clientDataMd5_;
        public static final int CLIENT_SILENCE_DATA_MD5_FIELD_NUMBER = 20;
        private volatile Object clientSilenceDataMd5_;
        public static final int RES_VERSION_CONFIG_FIELD_NUMBER = 22;
        private ResVersionConfigOuterClass.ResVersionConfig resVersionConfig_;
        public static final int SECRET_KEY_FIELD_NUMBER = 23;
        private ByteString secretKey_;
        public static final int OFFICIAL_COMMUNITY_URL_FIELD_NUMBER = 24;
        private volatile Object officialCommunityUrl_;
        public static final int CLIENT_VERSION_SUFFIX_FIELD_NUMBER = 26;
        private volatile Object clientVersionSuffix_;
        public static final int CLIENT_SILENCE_VERSION_SUFFIX_FIELD_NUMBER = 27;
        private volatile Object clientSilenceVersionSuffix_;
        public static final int USE_GATESERVER_DOMAIN_NAME_FIELD_NUMBER = 28;
        private boolean useGateserverDomainName_;
        public static final int GATESERVER_DOMAIN_NAME_FIELD_NUMBER = 29;
        private volatile Object gateserverDomainName_;
        public static final int USER_CENTER_URL_FIELD_NUMBER = 30;
        private volatile Object userCenterUrl_;
        public static final int ACCOUNT_BIND_URL_FIELD_NUMBER = 31;
        private volatile Object accountBindUrl_;
        public static final int CDKEY_URL_FIELD_NUMBER = 32;
        private volatile Object cdkeyUrl_;
        public static final int PRIVACY_POLICY_URL_FIELD_NUMBER = 33;
        private volatile Object privacyPolicyUrl_;
        public static final int NEXT_RESOURCE_URL_FIELD_NUMBER = 34;
        private volatile Object nextResourceUrl_;
        public static final int NEXT_RES_VERSION_CONFIG_FIELD_NUMBER = 35;
        private ResVersionConfigOuterClass.ResVersionConfig nextResVersionConfig_;
        public static final int GAME_BIZ_FIELD_NUMBER = 36;
        private volatile Object gameBiz_;
        private byte memoizedIsInitialized;
        private static final RegionInfo DEFAULT_INSTANCE = new RegionInfo();
        private static final Parser<RegionInfo> PARSER = new AbstractParser<RegionInfo>() { // from class: emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfo.1
            @Override // com.google.protobuf.Parser
            public RegionInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RegionInfo(input, extensionRegistry);
            }
        };

        private RegionInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RegionInfo() {
            this.memoizedIsInitialized = -1;
            this.gateserverIp_ = "";
            this.payCallbackUrl_ = "";
            this.areaType_ = "";
            this.resourceUrl_ = "";
            this.dataUrl_ = "";
            this.feedbackUrl_ = "";
            this.bulletinUrl_ = "";
            this.resourceUrlBak_ = "";
            this.dataUrlBak_ = "";
            this.handbookUrl_ = "";
            this.clientDataMd5_ = "";
            this.clientSilenceDataMd5_ = "";
            this.secretKey_ = ByteString.EMPTY;
            this.officialCommunityUrl_ = "";
            this.clientVersionSuffix_ = "";
            this.clientSilenceVersionSuffix_ = "";
            this.gateserverDomainName_ = "";
            this.userCenterUrl_ = "";
            this.accountBindUrl_ = "";
            this.cdkeyUrl_ = "";
            this.privacyPolicyUrl_ = "";
            this.nextResourceUrl_ = "";
            this.gameBiz_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RegionInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RegionInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 10:
                                this.gateserverIp_ = input.readStringRequireUtf8();
                                break;
                            case 16:
                                this.gateserverPort_ = input.readUInt32();
                                break;
                            case 26:
                                this.payCallbackUrl_ = input.readStringRequireUtf8();
                                break;
                            case 58:
                                this.areaType_ = input.readStringRequireUtf8();
                                break;
                            case 66:
                                this.resourceUrl_ = input.readStringRequireUtf8();
                                break;
                            case 74:
                                this.dataUrl_ = input.readStringRequireUtf8();
                                break;
                            case 82:
                                this.feedbackUrl_ = input.readStringRequireUtf8();
                                break;
                            case 90:
                                this.bulletinUrl_ = input.readStringRequireUtf8();
                                break;
                            case 98:
                                this.resourceUrlBak_ = input.readStringRequireUtf8();
                                break;
                            case 106:
                                this.dataUrlBak_ = input.readStringRequireUtf8();
                                break;
                            case 112:
                                this.clientDataVersion_ = input.readUInt32();
                                break;
                            case 130:
                                this.handbookUrl_ = input.readStringRequireUtf8();
                                break;
                            case 144:
                                this.clientSilenceDataVersion_ = input.readUInt32();
                                break;
                            case 154:
                                this.clientDataMd5_ = input.readStringRequireUtf8();
                                break;
                            case 162:
                                this.clientSilenceDataMd5_ = input.readStringRequireUtf8();
                                break;
                            case 178:
                                ResVersionConfigOuterClass.ResVersionConfig.Builder subBuilder = this.resVersionConfig_ != null ? this.resVersionConfig_.toBuilder() : null;
                                this.resVersionConfig_ = (ResVersionConfigOuterClass.ResVersionConfig) input.readMessage(ResVersionConfigOuterClass.ResVersionConfig.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.resVersionConfig_);
                                    this.resVersionConfig_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 186:
                                this.secretKey_ = input.readBytes();
                                break;
                            case 194:
                                this.officialCommunityUrl_ = input.readStringRequireUtf8();
                                break;
                            case PacketOpcodes.ExecuteGadgetLuaReq:
                                this.clientVersionSuffix_ = input.readStringRequireUtf8();
                                break;
                            case PacketOpcodes.SceneEntityDrownReq:
                                this.clientSilenceVersionSuffix_ = input.readStringRequireUtf8();
                                break;
                            case PacketOpcodes.SceneAvatarStaminaStepRsp:
                                this.useGateserverDomainName_ = input.readBool();
                                break;
                            case PacketOpcodes.JoinPlayerSceneReq:
                                this.gateserverDomainName_ = input.readStringRequireUtf8();
                                break;
                            case PacketOpcodes.EnterWorldAreaReq:
                                this.userCenterUrl_ = input.readStringRequireUtf8();
                                break;
                            case 250:
                                this.accountBindUrl_ = input.readStringRequireUtf8();
                                break;
                            case PacketOpcodes.SceneAreaUnlockNotify:
                                this.cdkeyUrl_ = input.readStringRequireUtf8();
                                break;
                            case PacketOpcodes.SetSceneWeatherAreaRsp:
                                this.privacyPolicyUrl_ = input.readStringRequireUtf8();
                                break;
                            case PacketOpcodes.SceneEntityAppearNotify:
                                this.nextResourceUrl_ = input.readStringRequireUtf8();
                                break;
                            case PacketOpcodes.SceneKickPlayerNotify:
                                ResVersionConfigOuterClass.ResVersionConfig.Builder subBuilder2 = this.nextResVersionConfig_ != null ? this.nextResVersionConfig_.toBuilder() : null;
                                this.nextResVersionConfig_ = (ResVersionConfigOuterClass.ResVersionConfig) input.readMessage(ResVersionConfigOuterClass.ResVersionConfig.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.nextResVersionConfig_);
                                    this.nextResVersionConfig_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case PacketOpcodes.ExecuteGroupTriggerReq:
                                this.gameBiz_ = input.readStringRequireUtf8();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RegionInfoOuterClass.internal_static_RegionInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RegionInfoOuterClass.internal_static_RegionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RegionInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getGateserverIp() {
            Object ref = this.gateserverIp_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gateserverIp_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getGateserverIpBytes() {
            Object ref = this.gateserverIp_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gateserverIp_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public int getGateserverPort() {
            return this.gateserverPort_;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getPayCallbackUrl() {
            Object ref = this.payCallbackUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.payCallbackUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getPayCallbackUrlBytes() {
            Object ref = this.payCallbackUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.payCallbackUrl_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getAreaType() {
            Object ref = this.areaType_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.areaType_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getAreaTypeBytes() {
            Object ref = this.areaType_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.areaType_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getResourceUrl() {
            Object ref = this.resourceUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.resourceUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getResourceUrlBytes() {
            Object ref = this.resourceUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.resourceUrl_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getDataUrl() {
            Object ref = this.dataUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.dataUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getDataUrlBytes() {
            Object ref = this.dataUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.dataUrl_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getFeedbackUrl() {
            Object ref = this.feedbackUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.feedbackUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getFeedbackUrlBytes() {
            Object ref = this.feedbackUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.feedbackUrl_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getBulletinUrl() {
            Object ref = this.bulletinUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.bulletinUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getBulletinUrlBytes() {
            Object ref = this.bulletinUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.bulletinUrl_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getResourceUrlBak() {
            Object ref = this.resourceUrlBak_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.resourceUrlBak_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getResourceUrlBakBytes() {
            Object ref = this.resourceUrlBak_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.resourceUrlBak_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getDataUrlBak() {
            Object ref = this.dataUrlBak_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.dataUrlBak_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getDataUrlBakBytes() {
            Object ref = this.dataUrlBak_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.dataUrlBak_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public int getClientDataVersion() {
            return this.clientDataVersion_;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getHandbookUrl() {
            Object ref = this.handbookUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.handbookUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getHandbookUrlBytes() {
            Object ref = this.handbookUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.handbookUrl_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public int getClientSilenceDataVersion() {
            return this.clientSilenceDataVersion_;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getClientDataMd5() {
            Object ref = this.clientDataMd5_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.clientDataMd5_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getClientDataMd5Bytes() {
            Object ref = this.clientDataMd5_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.clientDataMd5_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getClientSilenceDataMd5() {
            Object ref = this.clientSilenceDataMd5_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.clientSilenceDataMd5_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getClientSilenceDataMd5Bytes() {
            Object ref = this.clientSilenceDataMd5_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.clientSilenceDataMd5_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public boolean hasResVersionConfig() {
            return this.resVersionConfig_ != null;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ResVersionConfigOuterClass.ResVersionConfig getResVersionConfig() {
            return this.resVersionConfig_ == null ? ResVersionConfigOuterClass.ResVersionConfig.getDefaultInstance() : this.resVersionConfig_;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ResVersionConfigOuterClass.ResVersionConfigOrBuilder getResVersionConfigOrBuilder() {
            return getResVersionConfig();
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getSecretKey() {
            return this.secretKey_;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getOfficialCommunityUrl() {
            Object ref = this.officialCommunityUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.officialCommunityUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getOfficialCommunityUrlBytes() {
            Object ref = this.officialCommunityUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.officialCommunityUrl_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getClientVersionSuffix() {
            Object ref = this.clientVersionSuffix_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.clientVersionSuffix_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getClientVersionSuffixBytes() {
            Object ref = this.clientVersionSuffix_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.clientVersionSuffix_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getClientSilenceVersionSuffix() {
            Object ref = this.clientSilenceVersionSuffix_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.clientSilenceVersionSuffix_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getClientSilenceVersionSuffixBytes() {
            Object ref = this.clientSilenceVersionSuffix_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.clientSilenceVersionSuffix_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public boolean getUseGateserverDomainName() {
            return this.useGateserverDomainName_;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getGateserverDomainName() {
            Object ref = this.gateserverDomainName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gateserverDomainName_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getGateserverDomainNameBytes() {
            Object ref = this.gateserverDomainName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gateserverDomainName_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getUserCenterUrl() {
            Object ref = this.userCenterUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.userCenterUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getUserCenterUrlBytes() {
            Object ref = this.userCenterUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.userCenterUrl_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getAccountBindUrl() {
            Object ref = this.accountBindUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.accountBindUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getAccountBindUrlBytes() {
            Object ref = this.accountBindUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.accountBindUrl_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getCdkeyUrl() {
            Object ref = this.cdkeyUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.cdkeyUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getCdkeyUrlBytes() {
            Object ref = this.cdkeyUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.cdkeyUrl_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getPrivacyPolicyUrl() {
            Object ref = this.privacyPolicyUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.privacyPolicyUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getPrivacyPolicyUrlBytes() {
            Object ref = this.privacyPolicyUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.privacyPolicyUrl_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getNextResourceUrl() {
            Object ref = this.nextResourceUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.nextResourceUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getNextResourceUrlBytes() {
            Object ref = this.nextResourceUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.nextResourceUrl_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public boolean hasNextResVersionConfig() {
            return this.nextResVersionConfig_ != null;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ResVersionConfigOuterClass.ResVersionConfig getNextResVersionConfig() {
            return this.nextResVersionConfig_ == null ? ResVersionConfigOuterClass.ResVersionConfig.getDefaultInstance() : this.nextResVersionConfig_;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ResVersionConfigOuterClass.ResVersionConfigOrBuilder getNextResVersionConfigOrBuilder() {
            return getNextResVersionConfig();
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public String getGameBiz() {
            Object ref = this.gameBiz_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gameBiz_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
        public ByteString getGameBizBytes() {
            Object ref = this.gameBiz_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gameBiz_ = b;
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
            if (!GeneratedMessageV3.isStringEmpty(this.gateserverIp_)) {
                GeneratedMessageV3.writeString(output, 1, this.gateserverIp_);
            }
            if (this.gateserverPort_ != 0) {
                output.writeUInt32(2, this.gateserverPort_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.payCallbackUrl_)) {
                GeneratedMessageV3.writeString(output, 3, this.payCallbackUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.areaType_)) {
                GeneratedMessageV3.writeString(output, 7, this.areaType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.resourceUrl_)) {
                GeneratedMessageV3.writeString(output, 8, this.resourceUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.dataUrl_)) {
                GeneratedMessageV3.writeString(output, 9, this.dataUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.feedbackUrl_)) {
                GeneratedMessageV3.writeString(output, 10, this.feedbackUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.bulletinUrl_)) {
                GeneratedMessageV3.writeString(output, 11, this.bulletinUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.resourceUrlBak_)) {
                GeneratedMessageV3.writeString(output, 12, this.resourceUrlBak_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.dataUrlBak_)) {
                GeneratedMessageV3.writeString(output, 13, this.dataUrlBak_);
            }
            if (this.clientDataVersion_ != 0) {
                output.writeUInt32(14, this.clientDataVersion_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.handbookUrl_)) {
                GeneratedMessageV3.writeString(output, 16, this.handbookUrl_);
            }
            if (this.clientSilenceDataVersion_ != 0) {
                output.writeUInt32(18, this.clientSilenceDataVersion_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientDataMd5_)) {
                GeneratedMessageV3.writeString(output, 19, this.clientDataMd5_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientSilenceDataMd5_)) {
                GeneratedMessageV3.writeString(output, 20, this.clientSilenceDataMd5_);
            }
            if (this.resVersionConfig_ != null) {
                output.writeMessage(22, getResVersionConfig());
            }
            if (!this.secretKey_.isEmpty()) {
                output.writeBytes(23, this.secretKey_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.officialCommunityUrl_)) {
                GeneratedMessageV3.writeString(output, 24, this.officialCommunityUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientVersionSuffix_)) {
                GeneratedMessageV3.writeString(output, 26, this.clientVersionSuffix_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientSilenceVersionSuffix_)) {
                GeneratedMessageV3.writeString(output, 27, this.clientSilenceVersionSuffix_);
            }
            if (this.useGateserverDomainName_) {
                output.writeBool(28, this.useGateserverDomainName_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gateserverDomainName_)) {
                GeneratedMessageV3.writeString(output, 29, this.gateserverDomainName_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.userCenterUrl_)) {
                GeneratedMessageV3.writeString(output, 30, this.userCenterUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.accountBindUrl_)) {
                GeneratedMessageV3.writeString(output, 31, this.accountBindUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.cdkeyUrl_)) {
                GeneratedMessageV3.writeString(output, 32, this.cdkeyUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.privacyPolicyUrl_)) {
                GeneratedMessageV3.writeString(output, 33, this.privacyPolicyUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.nextResourceUrl_)) {
                GeneratedMessageV3.writeString(output, 34, this.nextResourceUrl_);
            }
            if (this.nextResVersionConfig_ != null) {
                output.writeMessage(35, getNextResVersionConfig());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gameBiz_)) {
                GeneratedMessageV3.writeString(output, 36, this.gameBiz_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.gateserverIp_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(1, this.gateserverIp_);
            }
            if (this.gateserverPort_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.gateserverPort_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.payCallbackUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(3, this.payCallbackUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.areaType_)) {
                size2 += GeneratedMessageV3.computeStringSize(7, this.areaType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.resourceUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(8, this.resourceUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.dataUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(9, this.dataUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.feedbackUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(10, this.feedbackUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.bulletinUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(11, this.bulletinUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.resourceUrlBak_)) {
                size2 += GeneratedMessageV3.computeStringSize(12, this.resourceUrlBak_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.dataUrlBak_)) {
                size2 += GeneratedMessageV3.computeStringSize(13, this.dataUrlBak_);
            }
            if (this.clientDataVersion_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.clientDataVersion_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.handbookUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(16, this.handbookUrl_);
            }
            if (this.clientSilenceDataVersion_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(18, this.clientSilenceDataVersion_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientDataMd5_)) {
                size2 += GeneratedMessageV3.computeStringSize(19, this.clientDataMd5_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientSilenceDataMd5_)) {
                size2 += GeneratedMessageV3.computeStringSize(20, this.clientSilenceDataMd5_);
            }
            if (this.resVersionConfig_ != null) {
                size2 += CodedOutputStream.computeMessageSize(22, getResVersionConfig());
            }
            if (!this.secretKey_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(23, this.secretKey_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.officialCommunityUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(24, this.officialCommunityUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientVersionSuffix_)) {
                size2 += GeneratedMessageV3.computeStringSize(26, this.clientVersionSuffix_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientSilenceVersionSuffix_)) {
                size2 += GeneratedMessageV3.computeStringSize(27, this.clientSilenceVersionSuffix_);
            }
            if (this.useGateserverDomainName_) {
                size2 += CodedOutputStream.computeBoolSize(28, this.useGateserverDomainName_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gateserverDomainName_)) {
                size2 += GeneratedMessageV3.computeStringSize(29, this.gateserverDomainName_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.userCenterUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(30, this.userCenterUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.accountBindUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(31, this.accountBindUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.cdkeyUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(32, this.cdkeyUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.privacyPolicyUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(33, this.privacyPolicyUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.nextResourceUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(34, this.nextResourceUrl_);
            }
            if (this.nextResVersionConfig_ != null) {
                size2 += CodedOutputStream.computeMessageSize(35, getNextResVersionConfig());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gameBiz_)) {
                size2 += GeneratedMessageV3.computeStringSize(36, this.gameBiz_);
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
            if (!(obj instanceof RegionInfo)) {
                return equals(obj);
            }
            RegionInfo other = (RegionInfo) obj;
            if (!getGateserverIp().equals(other.getGateserverIp()) || getGateserverPort() != other.getGateserverPort() || !getPayCallbackUrl().equals(other.getPayCallbackUrl()) || !getAreaType().equals(other.getAreaType()) || !getResourceUrl().equals(other.getResourceUrl()) || !getDataUrl().equals(other.getDataUrl()) || !getFeedbackUrl().equals(other.getFeedbackUrl()) || !getBulletinUrl().equals(other.getBulletinUrl()) || !getResourceUrlBak().equals(other.getResourceUrlBak()) || !getDataUrlBak().equals(other.getDataUrlBak()) || getClientDataVersion() != other.getClientDataVersion() || !getHandbookUrl().equals(other.getHandbookUrl()) || getClientSilenceDataVersion() != other.getClientSilenceDataVersion() || !getClientDataMd5().equals(other.getClientDataMd5()) || !getClientSilenceDataMd5().equals(other.getClientSilenceDataMd5()) || hasResVersionConfig() != other.hasResVersionConfig()) {
                return false;
            }
            if ((!hasResVersionConfig() || getResVersionConfig().equals(other.getResVersionConfig())) && getSecretKey().equals(other.getSecretKey()) && getOfficialCommunityUrl().equals(other.getOfficialCommunityUrl()) && getClientVersionSuffix().equals(other.getClientVersionSuffix()) && getClientSilenceVersionSuffix().equals(other.getClientSilenceVersionSuffix()) && getUseGateserverDomainName() == other.getUseGateserverDomainName() && getGateserverDomainName().equals(other.getGateserverDomainName()) && getUserCenterUrl().equals(other.getUserCenterUrl()) && getAccountBindUrl().equals(other.getAccountBindUrl()) && getCdkeyUrl().equals(other.getCdkeyUrl()) && getPrivacyPolicyUrl().equals(other.getPrivacyPolicyUrl()) && getNextResourceUrl().equals(other.getNextResourceUrl()) && hasNextResVersionConfig() == other.hasNextResVersionConfig()) {
                return (!hasNextResVersionConfig() || getNextResVersionConfig().equals(other.getNextResVersionConfig())) && getGameBiz().equals(other.getGameBiz()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getGateserverIp().hashCode())) + 2)) + getGateserverPort())) + 3)) + getPayCallbackUrl().hashCode())) + 7)) + getAreaType().hashCode())) + 8)) + getResourceUrl().hashCode())) + 9)) + getDataUrl().hashCode())) + 10)) + getFeedbackUrl().hashCode())) + 11)) + getBulletinUrl().hashCode())) + 12)) + getResourceUrlBak().hashCode())) + 13)) + getDataUrlBak().hashCode())) + 14)) + getClientDataVersion())) + 16)) + getHandbookUrl().hashCode())) + 18)) + getClientSilenceDataVersion())) + 19)) + getClientDataMd5().hashCode())) + 20)) + getClientSilenceDataMd5().hashCode();
            if (hasResVersionConfig()) {
                hash = (53 * ((37 * hash) + 22)) + getResVersionConfig().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 23)) + getSecretKey().hashCode())) + 24)) + getOfficialCommunityUrl().hashCode())) + 26)) + getClientVersionSuffix().hashCode())) + 27)) + getClientSilenceVersionSuffix().hashCode())) + 28)) + Internal.hashBoolean(getUseGateserverDomainName()))) + 29)) + getGateserverDomainName().hashCode())) + 30)) + getUserCenterUrl().hashCode())) + 31)) + getAccountBindUrl().hashCode())) + 32)) + getCdkeyUrl().hashCode())) + 33)) + getPrivacyPolicyUrl().hashCode())) + 34)) + getNextResourceUrl().hashCode();
            if (hasNextResVersionConfig()) {
                hash2 = (53 * ((37 * hash2) + 35)) + getNextResVersionConfig().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 36)) + getGameBiz().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static RegionInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RegionInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegionInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RegionInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegionInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RegionInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegionInfo parseFrom(InputStream input) throws IOException {
            return (RegionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RegionInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RegionInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (RegionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RegionInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RegionInfo parseFrom(CodedInputStream input) throws IOException {
            return (RegionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RegionInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RegionInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RegionInfoOuterClass$RegionInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RegionInfoOrBuilder {
            private int gateserverPort_;
            private int clientDataVersion_;
            private int clientSilenceDataVersion_;
            private ResVersionConfigOuterClass.ResVersionConfig resVersionConfig_;
            private SingleFieldBuilderV3<ResVersionConfigOuterClass.ResVersionConfig, ResVersionConfigOuterClass.ResVersionConfig.Builder, ResVersionConfigOuterClass.ResVersionConfigOrBuilder> resVersionConfigBuilder_;
            private boolean useGateserverDomainName_;
            private ResVersionConfigOuterClass.ResVersionConfig nextResVersionConfig_;
            private SingleFieldBuilderV3<ResVersionConfigOuterClass.ResVersionConfig, ResVersionConfigOuterClass.ResVersionConfig.Builder, ResVersionConfigOuterClass.ResVersionConfigOrBuilder> nextResVersionConfigBuilder_;
            private Object gateserverIp_ = "";
            private Object payCallbackUrl_ = "";
            private Object areaType_ = "";
            private Object resourceUrl_ = "";
            private Object dataUrl_ = "";
            private Object feedbackUrl_ = "";
            private Object bulletinUrl_ = "";
            private Object resourceUrlBak_ = "";
            private Object dataUrlBak_ = "";
            private Object handbookUrl_ = "";
            private Object clientDataMd5_ = "";
            private Object clientSilenceDataMd5_ = "";
            private ByteString secretKey_ = ByteString.EMPTY;
            private Object officialCommunityUrl_ = "";
            private Object clientVersionSuffix_ = "";
            private Object clientSilenceVersionSuffix_ = "";
            private Object gateserverDomainName_ = "";
            private Object userCenterUrl_ = "";
            private Object accountBindUrl_ = "";
            private Object cdkeyUrl_ = "";
            private Object privacyPolicyUrl_ = "";
            private Object nextResourceUrl_ = "";
            private Object gameBiz_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return RegionInfoOuterClass.internal_static_RegionInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RegionInfoOuterClass.internal_static_RegionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RegionInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RegionInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.gateserverIp_ = "";
                this.gateserverPort_ = 0;
                this.payCallbackUrl_ = "";
                this.areaType_ = "";
                this.resourceUrl_ = "";
                this.dataUrl_ = "";
                this.feedbackUrl_ = "";
                this.bulletinUrl_ = "";
                this.resourceUrlBak_ = "";
                this.dataUrlBak_ = "";
                this.clientDataVersion_ = 0;
                this.handbookUrl_ = "";
                this.clientSilenceDataVersion_ = 0;
                this.clientDataMd5_ = "";
                this.clientSilenceDataMd5_ = "";
                if (this.resVersionConfigBuilder_ == null) {
                    this.resVersionConfig_ = null;
                } else {
                    this.resVersionConfig_ = null;
                    this.resVersionConfigBuilder_ = null;
                }
                this.secretKey_ = ByteString.EMPTY;
                this.officialCommunityUrl_ = "";
                this.clientVersionSuffix_ = "";
                this.clientSilenceVersionSuffix_ = "";
                this.useGateserverDomainName_ = false;
                this.gateserverDomainName_ = "";
                this.userCenterUrl_ = "";
                this.accountBindUrl_ = "";
                this.cdkeyUrl_ = "";
                this.privacyPolicyUrl_ = "";
                this.nextResourceUrl_ = "";
                if (this.nextResVersionConfigBuilder_ == null) {
                    this.nextResVersionConfig_ = null;
                } else {
                    this.nextResVersionConfig_ = null;
                    this.nextResVersionConfigBuilder_ = null;
                }
                this.gameBiz_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RegionInfoOuterClass.internal_static_RegionInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RegionInfo getDefaultInstanceForType() {
                return RegionInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RegionInfo build() {
                RegionInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RegionInfo buildPartial() {
                RegionInfo result = new RegionInfo(this);
                result.gateserverIp_ = this.gateserverIp_;
                result.gateserverPort_ = this.gateserverPort_;
                result.payCallbackUrl_ = this.payCallbackUrl_;
                result.areaType_ = this.areaType_;
                result.resourceUrl_ = this.resourceUrl_;
                result.dataUrl_ = this.dataUrl_;
                result.feedbackUrl_ = this.feedbackUrl_;
                result.bulletinUrl_ = this.bulletinUrl_;
                result.resourceUrlBak_ = this.resourceUrlBak_;
                result.dataUrlBak_ = this.dataUrlBak_;
                result.clientDataVersion_ = this.clientDataVersion_;
                result.handbookUrl_ = this.handbookUrl_;
                result.clientSilenceDataVersion_ = this.clientSilenceDataVersion_;
                result.clientDataMd5_ = this.clientDataMd5_;
                result.clientSilenceDataMd5_ = this.clientSilenceDataMd5_;
                if (this.resVersionConfigBuilder_ == null) {
                    result.resVersionConfig_ = this.resVersionConfig_;
                } else {
                    result.resVersionConfig_ = this.resVersionConfigBuilder_.build();
                }
                result.secretKey_ = this.secretKey_;
                result.officialCommunityUrl_ = this.officialCommunityUrl_;
                result.clientVersionSuffix_ = this.clientVersionSuffix_;
                result.clientSilenceVersionSuffix_ = this.clientSilenceVersionSuffix_;
                result.useGateserverDomainName_ = this.useGateserverDomainName_;
                result.gateserverDomainName_ = this.gateserverDomainName_;
                result.userCenterUrl_ = this.userCenterUrl_;
                result.accountBindUrl_ = this.accountBindUrl_;
                result.cdkeyUrl_ = this.cdkeyUrl_;
                result.privacyPolicyUrl_ = this.privacyPolicyUrl_;
                result.nextResourceUrl_ = this.nextResourceUrl_;
                if (this.nextResVersionConfigBuilder_ == null) {
                    result.nextResVersionConfig_ = this.nextResVersionConfig_;
                } else {
                    result.nextResVersionConfig_ = this.nextResVersionConfigBuilder_.build();
                }
                result.gameBiz_ = this.gameBiz_;
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
                if (other instanceof RegionInfo) {
                    return mergeFrom((RegionInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RegionInfo other) {
                if (other == RegionInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.getGateserverIp().isEmpty()) {
                    this.gateserverIp_ = other.gateserverIp_;
                    onChanged();
                }
                if (other.getGateserverPort() != 0) {
                    setGateserverPort(other.getGateserverPort());
                }
                if (!other.getPayCallbackUrl().isEmpty()) {
                    this.payCallbackUrl_ = other.payCallbackUrl_;
                    onChanged();
                }
                if (!other.getAreaType().isEmpty()) {
                    this.areaType_ = other.areaType_;
                    onChanged();
                }
                if (!other.getResourceUrl().isEmpty()) {
                    this.resourceUrl_ = other.resourceUrl_;
                    onChanged();
                }
                if (!other.getDataUrl().isEmpty()) {
                    this.dataUrl_ = other.dataUrl_;
                    onChanged();
                }
                if (!other.getFeedbackUrl().isEmpty()) {
                    this.feedbackUrl_ = other.feedbackUrl_;
                    onChanged();
                }
                if (!other.getBulletinUrl().isEmpty()) {
                    this.bulletinUrl_ = other.bulletinUrl_;
                    onChanged();
                }
                if (!other.getResourceUrlBak().isEmpty()) {
                    this.resourceUrlBak_ = other.resourceUrlBak_;
                    onChanged();
                }
                if (!other.getDataUrlBak().isEmpty()) {
                    this.dataUrlBak_ = other.dataUrlBak_;
                    onChanged();
                }
                if (other.getClientDataVersion() != 0) {
                    setClientDataVersion(other.getClientDataVersion());
                }
                if (!other.getHandbookUrl().isEmpty()) {
                    this.handbookUrl_ = other.handbookUrl_;
                    onChanged();
                }
                if (other.getClientSilenceDataVersion() != 0) {
                    setClientSilenceDataVersion(other.getClientSilenceDataVersion());
                }
                if (!other.getClientDataMd5().isEmpty()) {
                    this.clientDataMd5_ = other.clientDataMd5_;
                    onChanged();
                }
                if (!other.getClientSilenceDataMd5().isEmpty()) {
                    this.clientSilenceDataMd5_ = other.clientSilenceDataMd5_;
                    onChanged();
                }
                if (other.hasResVersionConfig()) {
                    mergeResVersionConfig(other.getResVersionConfig());
                }
                if (other.getSecretKey() != ByteString.EMPTY) {
                    setSecretKey(other.getSecretKey());
                }
                if (!other.getOfficialCommunityUrl().isEmpty()) {
                    this.officialCommunityUrl_ = other.officialCommunityUrl_;
                    onChanged();
                }
                if (!other.getClientVersionSuffix().isEmpty()) {
                    this.clientVersionSuffix_ = other.clientVersionSuffix_;
                    onChanged();
                }
                if (!other.getClientSilenceVersionSuffix().isEmpty()) {
                    this.clientSilenceVersionSuffix_ = other.clientSilenceVersionSuffix_;
                    onChanged();
                }
                if (other.getUseGateserverDomainName()) {
                    setUseGateserverDomainName(other.getUseGateserverDomainName());
                }
                if (!other.getGateserverDomainName().isEmpty()) {
                    this.gateserverDomainName_ = other.gateserverDomainName_;
                    onChanged();
                }
                if (!other.getUserCenterUrl().isEmpty()) {
                    this.userCenterUrl_ = other.userCenterUrl_;
                    onChanged();
                }
                if (!other.getAccountBindUrl().isEmpty()) {
                    this.accountBindUrl_ = other.accountBindUrl_;
                    onChanged();
                }
                if (!other.getCdkeyUrl().isEmpty()) {
                    this.cdkeyUrl_ = other.cdkeyUrl_;
                    onChanged();
                }
                if (!other.getPrivacyPolicyUrl().isEmpty()) {
                    this.privacyPolicyUrl_ = other.privacyPolicyUrl_;
                    onChanged();
                }
                if (!other.getNextResourceUrl().isEmpty()) {
                    this.nextResourceUrl_ = other.nextResourceUrl_;
                    onChanged();
                }
                if (other.hasNextResVersionConfig()) {
                    mergeNextResVersionConfig(other.getNextResVersionConfig());
                }
                if (!other.getGameBiz().isEmpty()) {
                    this.gameBiz_ = other.gameBiz_;
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
                RegionInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = RegionInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RegionInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getGateserverIp() {
                Object ref = this.gateserverIp_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gateserverIp_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getGateserverIpBytes() {
                Object ref = this.gateserverIp_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gateserverIp_ = b;
                return b;
            }

            public Builder setGateserverIp(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gateserverIp_ = value;
                onChanged();
                return this;
            }

            public Builder clearGateserverIp() {
                this.gateserverIp_ = RegionInfo.getDefaultInstance().getGateserverIp();
                onChanged();
                return this;
            }

            public Builder setGateserverIpBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.gateserverIp_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public int getGateserverPort() {
                return this.gateserverPort_;
            }

            public Builder setGateserverPort(int value) {
                this.gateserverPort_ = value;
                onChanged();
                return this;
            }

            public Builder clearGateserverPort() {
                this.gateserverPort_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getPayCallbackUrl() {
                Object ref = this.payCallbackUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.payCallbackUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getPayCallbackUrlBytes() {
                Object ref = this.payCallbackUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.payCallbackUrl_ = b;
                return b;
            }

            public Builder setPayCallbackUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.payCallbackUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearPayCallbackUrl() {
                this.payCallbackUrl_ = RegionInfo.getDefaultInstance().getPayCallbackUrl();
                onChanged();
                return this;
            }

            public Builder setPayCallbackUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.payCallbackUrl_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getAreaType() {
                Object ref = this.areaType_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.areaType_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getAreaTypeBytes() {
                Object ref = this.areaType_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.areaType_ = b;
                return b;
            }

            public Builder setAreaType(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.areaType_ = value;
                onChanged();
                return this;
            }

            public Builder clearAreaType() {
                this.areaType_ = RegionInfo.getDefaultInstance().getAreaType();
                onChanged();
                return this;
            }

            public Builder setAreaTypeBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.areaType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getResourceUrl() {
                Object ref = this.resourceUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.resourceUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getResourceUrlBytes() {
                Object ref = this.resourceUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.resourceUrl_ = b;
                return b;
            }

            public Builder setResourceUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.resourceUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearResourceUrl() {
                this.resourceUrl_ = RegionInfo.getDefaultInstance().getResourceUrl();
                onChanged();
                return this;
            }

            public Builder setResourceUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.resourceUrl_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getDataUrl() {
                Object ref = this.dataUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.dataUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getDataUrlBytes() {
                Object ref = this.dataUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.dataUrl_ = b;
                return b;
            }

            public Builder setDataUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.dataUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearDataUrl() {
                this.dataUrl_ = RegionInfo.getDefaultInstance().getDataUrl();
                onChanged();
                return this;
            }

            public Builder setDataUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.dataUrl_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getFeedbackUrl() {
                Object ref = this.feedbackUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.feedbackUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getFeedbackUrlBytes() {
                Object ref = this.feedbackUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.feedbackUrl_ = b;
                return b;
            }

            public Builder setFeedbackUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.feedbackUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearFeedbackUrl() {
                this.feedbackUrl_ = RegionInfo.getDefaultInstance().getFeedbackUrl();
                onChanged();
                return this;
            }

            public Builder setFeedbackUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.feedbackUrl_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getBulletinUrl() {
                Object ref = this.bulletinUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.bulletinUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getBulletinUrlBytes() {
                Object ref = this.bulletinUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.bulletinUrl_ = b;
                return b;
            }

            public Builder setBulletinUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bulletinUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearBulletinUrl() {
                this.bulletinUrl_ = RegionInfo.getDefaultInstance().getBulletinUrl();
                onChanged();
                return this;
            }

            public Builder setBulletinUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.bulletinUrl_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getResourceUrlBak() {
                Object ref = this.resourceUrlBak_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.resourceUrlBak_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getResourceUrlBakBytes() {
                Object ref = this.resourceUrlBak_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.resourceUrlBak_ = b;
                return b;
            }

            public Builder setResourceUrlBak(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.resourceUrlBak_ = value;
                onChanged();
                return this;
            }

            public Builder clearResourceUrlBak() {
                this.resourceUrlBak_ = RegionInfo.getDefaultInstance().getResourceUrlBak();
                onChanged();
                return this;
            }

            public Builder setResourceUrlBakBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.resourceUrlBak_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getDataUrlBak() {
                Object ref = this.dataUrlBak_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.dataUrlBak_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getDataUrlBakBytes() {
                Object ref = this.dataUrlBak_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.dataUrlBak_ = b;
                return b;
            }

            public Builder setDataUrlBak(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.dataUrlBak_ = value;
                onChanged();
                return this;
            }

            public Builder clearDataUrlBak() {
                this.dataUrlBak_ = RegionInfo.getDefaultInstance().getDataUrlBak();
                onChanged();
                return this;
            }

            public Builder setDataUrlBakBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.dataUrlBak_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getHandbookUrl() {
                Object ref = this.handbookUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.handbookUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getHandbookUrlBytes() {
                Object ref = this.handbookUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.handbookUrl_ = b;
                return b;
            }

            public Builder setHandbookUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.handbookUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearHandbookUrl() {
                this.handbookUrl_ = RegionInfo.getDefaultInstance().getHandbookUrl();
                onChanged();
                return this;
            }

            public Builder setHandbookUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.handbookUrl_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public int getClientSilenceDataVersion() {
                return this.clientSilenceDataVersion_;
            }

            public Builder setClientSilenceDataVersion(int value) {
                this.clientSilenceDataVersion_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientSilenceDataVersion() {
                this.clientSilenceDataVersion_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getClientDataMd5() {
                Object ref = this.clientDataMd5_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.clientDataMd5_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getClientDataMd5Bytes() {
                Object ref = this.clientDataMd5_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientDataMd5_ = b;
                return b;
            }

            public Builder setClientDataMd5(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientDataMd5_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientDataMd5() {
                this.clientDataMd5_ = RegionInfo.getDefaultInstance().getClientDataMd5();
                onChanged();
                return this;
            }

            public Builder setClientDataMd5Bytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.clientDataMd5_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getClientSilenceDataMd5() {
                Object ref = this.clientSilenceDataMd5_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.clientSilenceDataMd5_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getClientSilenceDataMd5Bytes() {
                Object ref = this.clientSilenceDataMd5_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientSilenceDataMd5_ = b;
                return b;
            }

            public Builder setClientSilenceDataMd5(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientSilenceDataMd5_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientSilenceDataMd5() {
                this.clientSilenceDataMd5_ = RegionInfo.getDefaultInstance().getClientSilenceDataMd5();
                onChanged();
                return this;
            }

            public Builder setClientSilenceDataMd5Bytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.clientSilenceDataMd5_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public boolean hasResVersionConfig() {
                return (this.resVersionConfigBuilder_ == null && this.resVersionConfig_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ResVersionConfigOuterClass.ResVersionConfig getResVersionConfig() {
                if (this.resVersionConfigBuilder_ == null) {
                    return this.resVersionConfig_ == null ? ResVersionConfigOuterClass.ResVersionConfig.getDefaultInstance() : this.resVersionConfig_;
                }
                return this.resVersionConfigBuilder_.getMessage();
            }

            public Builder setResVersionConfig(ResVersionConfigOuterClass.ResVersionConfig value) {
                if (this.resVersionConfigBuilder_ != null) {
                    this.resVersionConfigBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.resVersionConfig_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setResVersionConfig(ResVersionConfigOuterClass.ResVersionConfig.Builder builderForValue) {
                if (this.resVersionConfigBuilder_ == null) {
                    this.resVersionConfig_ = builderForValue.build();
                    onChanged();
                } else {
                    this.resVersionConfigBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeResVersionConfig(ResVersionConfigOuterClass.ResVersionConfig value) {
                if (this.resVersionConfigBuilder_ == null) {
                    if (this.resVersionConfig_ != null) {
                        this.resVersionConfig_ = ResVersionConfigOuterClass.ResVersionConfig.newBuilder(this.resVersionConfig_).mergeFrom(value).buildPartial();
                    } else {
                        this.resVersionConfig_ = value;
                    }
                    onChanged();
                } else {
                    this.resVersionConfigBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearResVersionConfig() {
                if (this.resVersionConfigBuilder_ == null) {
                    this.resVersionConfig_ = null;
                    onChanged();
                } else {
                    this.resVersionConfig_ = null;
                    this.resVersionConfigBuilder_ = null;
                }
                return this;
            }

            public ResVersionConfigOuterClass.ResVersionConfig.Builder getResVersionConfigBuilder() {
                onChanged();
                return getResVersionConfigFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ResVersionConfigOuterClass.ResVersionConfigOrBuilder getResVersionConfigOrBuilder() {
                if (this.resVersionConfigBuilder_ != null) {
                    return this.resVersionConfigBuilder_.getMessageOrBuilder();
                }
                return this.resVersionConfig_ == null ? ResVersionConfigOuterClass.ResVersionConfig.getDefaultInstance() : this.resVersionConfig_;
            }

            private SingleFieldBuilderV3<ResVersionConfigOuterClass.ResVersionConfig, ResVersionConfigOuterClass.ResVersionConfig.Builder, ResVersionConfigOuterClass.ResVersionConfigOrBuilder> getResVersionConfigFieldBuilder() {
                if (this.resVersionConfigBuilder_ == null) {
                    this.resVersionConfigBuilder_ = new SingleFieldBuilderV3<>(getResVersionConfig(), getParentForChildren(), isClean());
                    this.resVersionConfig_ = null;
                }
                return this.resVersionConfigBuilder_;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getSecretKey() {
                return this.secretKey_;
            }

            public Builder setSecretKey(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.secretKey_ = value;
                onChanged();
                return this;
            }

            public Builder clearSecretKey() {
                this.secretKey_ = RegionInfo.getDefaultInstance().getSecretKey();
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getOfficialCommunityUrl() {
                Object ref = this.officialCommunityUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.officialCommunityUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getOfficialCommunityUrlBytes() {
                Object ref = this.officialCommunityUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.officialCommunityUrl_ = b;
                return b;
            }

            public Builder setOfficialCommunityUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.officialCommunityUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearOfficialCommunityUrl() {
                this.officialCommunityUrl_ = RegionInfo.getDefaultInstance().getOfficialCommunityUrl();
                onChanged();
                return this;
            }

            public Builder setOfficialCommunityUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.officialCommunityUrl_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getClientVersionSuffix() {
                Object ref = this.clientVersionSuffix_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.clientVersionSuffix_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getClientVersionSuffixBytes() {
                Object ref = this.clientVersionSuffix_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientVersionSuffix_ = b;
                return b;
            }

            public Builder setClientVersionSuffix(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientVersionSuffix_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientVersionSuffix() {
                this.clientVersionSuffix_ = RegionInfo.getDefaultInstance().getClientVersionSuffix();
                onChanged();
                return this;
            }

            public Builder setClientVersionSuffixBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.clientVersionSuffix_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getClientSilenceVersionSuffix() {
                Object ref = this.clientSilenceVersionSuffix_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.clientSilenceVersionSuffix_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getClientSilenceVersionSuffixBytes() {
                Object ref = this.clientSilenceVersionSuffix_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientSilenceVersionSuffix_ = b;
                return b;
            }

            public Builder setClientSilenceVersionSuffix(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientSilenceVersionSuffix_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientSilenceVersionSuffix() {
                this.clientSilenceVersionSuffix_ = RegionInfo.getDefaultInstance().getClientSilenceVersionSuffix();
                onChanged();
                return this;
            }

            public Builder setClientSilenceVersionSuffixBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.clientSilenceVersionSuffix_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public boolean getUseGateserverDomainName() {
                return this.useGateserverDomainName_;
            }

            public Builder setUseGateserverDomainName(boolean value) {
                this.useGateserverDomainName_ = value;
                onChanged();
                return this;
            }

            public Builder clearUseGateserverDomainName() {
                this.useGateserverDomainName_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getGateserverDomainName() {
                Object ref = this.gateserverDomainName_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gateserverDomainName_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getGateserverDomainNameBytes() {
                Object ref = this.gateserverDomainName_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gateserverDomainName_ = b;
                return b;
            }

            public Builder setGateserverDomainName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gateserverDomainName_ = value;
                onChanged();
                return this;
            }

            public Builder clearGateserverDomainName() {
                this.gateserverDomainName_ = RegionInfo.getDefaultInstance().getGateserverDomainName();
                onChanged();
                return this;
            }

            public Builder setGateserverDomainNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.gateserverDomainName_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getUserCenterUrl() {
                Object ref = this.userCenterUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.userCenterUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getUserCenterUrlBytes() {
                Object ref = this.userCenterUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.userCenterUrl_ = b;
                return b;
            }

            public Builder setUserCenterUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.userCenterUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearUserCenterUrl() {
                this.userCenterUrl_ = RegionInfo.getDefaultInstance().getUserCenterUrl();
                onChanged();
                return this;
            }

            public Builder setUserCenterUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.userCenterUrl_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getAccountBindUrl() {
                Object ref = this.accountBindUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.accountBindUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getAccountBindUrlBytes() {
                Object ref = this.accountBindUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.accountBindUrl_ = b;
                return b;
            }

            public Builder setAccountBindUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.accountBindUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearAccountBindUrl() {
                this.accountBindUrl_ = RegionInfo.getDefaultInstance().getAccountBindUrl();
                onChanged();
                return this;
            }

            public Builder setAccountBindUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.accountBindUrl_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getCdkeyUrl() {
                Object ref = this.cdkeyUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.cdkeyUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getCdkeyUrlBytes() {
                Object ref = this.cdkeyUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.cdkeyUrl_ = b;
                return b;
            }

            public Builder setCdkeyUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.cdkeyUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearCdkeyUrl() {
                this.cdkeyUrl_ = RegionInfo.getDefaultInstance().getCdkeyUrl();
                onChanged();
                return this;
            }

            public Builder setCdkeyUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.cdkeyUrl_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getPrivacyPolicyUrl() {
                Object ref = this.privacyPolicyUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.privacyPolicyUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getPrivacyPolicyUrlBytes() {
                Object ref = this.privacyPolicyUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.privacyPolicyUrl_ = b;
                return b;
            }

            public Builder setPrivacyPolicyUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.privacyPolicyUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearPrivacyPolicyUrl() {
                this.privacyPolicyUrl_ = RegionInfo.getDefaultInstance().getPrivacyPolicyUrl();
                onChanged();
                return this;
            }

            public Builder setPrivacyPolicyUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.privacyPolicyUrl_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getNextResourceUrl() {
                Object ref = this.nextResourceUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.nextResourceUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getNextResourceUrlBytes() {
                Object ref = this.nextResourceUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.nextResourceUrl_ = b;
                return b;
            }

            public Builder setNextResourceUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.nextResourceUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextResourceUrl() {
                this.nextResourceUrl_ = RegionInfo.getDefaultInstance().getNextResourceUrl();
                onChanged();
                return this;
            }

            public Builder setNextResourceUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.nextResourceUrl_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public boolean hasNextResVersionConfig() {
                return (this.nextResVersionConfigBuilder_ == null && this.nextResVersionConfig_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ResVersionConfigOuterClass.ResVersionConfig getNextResVersionConfig() {
                if (this.nextResVersionConfigBuilder_ == null) {
                    return this.nextResVersionConfig_ == null ? ResVersionConfigOuterClass.ResVersionConfig.getDefaultInstance() : this.nextResVersionConfig_;
                }
                return this.nextResVersionConfigBuilder_.getMessage();
            }

            public Builder setNextResVersionConfig(ResVersionConfigOuterClass.ResVersionConfig value) {
                if (this.nextResVersionConfigBuilder_ != null) {
                    this.nextResVersionConfigBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.nextResVersionConfig_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setNextResVersionConfig(ResVersionConfigOuterClass.ResVersionConfig.Builder builderForValue) {
                if (this.nextResVersionConfigBuilder_ == null) {
                    this.nextResVersionConfig_ = builderForValue.build();
                    onChanged();
                } else {
                    this.nextResVersionConfigBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeNextResVersionConfig(ResVersionConfigOuterClass.ResVersionConfig value) {
                if (this.nextResVersionConfigBuilder_ == null) {
                    if (this.nextResVersionConfig_ != null) {
                        this.nextResVersionConfig_ = ResVersionConfigOuterClass.ResVersionConfig.newBuilder(this.nextResVersionConfig_).mergeFrom(value).buildPartial();
                    } else {
                        this.nextResVersionConfig_ = value;
                    }
                    onChanged();
                } else {
                    this.nextResVersionConfigBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearNextResVersionConfig() {
                if (this.nextResVersionConfigBuilder_ == null) {
                    this.nextResVersionConfig_ = null;
                    onChanged();
                } else {
                    this.nextResVersionConfig_ = null;
                    this.nextResVersionConfigBuilder_ = null;
                }
                return this;
            }

            public ResVersionConfigOuterClass.ResVersionConfig.Builder getNextResVersionConfigBuilder() {
                onChanged();
                return getNextResVersionConfigFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ResVersionConfigOuterClass.ResVersionConfigOrBuilder getNextResVersionConfigOrBuilder() {
                if (this.nextResVersionConfigBuilder_ != null) {
                    return this.nextResVersionConfigBuilder_.getMessageOrBuilder();
                }
                return this.nextResVersionConfig_ == null ? ResVersionConfigOuterClass.ResVersionConfig.getDefaultInstance() : this.nextResVersionConfig_;
            }

            private SingleFieldBuilderV3<ResVersionConfigOuterClass.ResVersionConfig, ResVersionConfigOuterClass.ResVersionConfig.Builder, ResVersionConfigOuterClass.ResVersionConfigOrBuilder> getNextResVersionConfigFieldBuilder() {
                if (this.nextResVersionConfigBuilder_ == null) {
                    this.nextResVersionConfigBuilder_ = new SingleFieldBuilderV3<>(getNextResVersionConfig(), getParentForChildren(), isClean());
                    this.nextResVersionConfig_ = null;
                }
                return this.nextResVersionConfigBuilder_;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public String getGameBiz() {
                Object ref = this.gameBiz_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gameBiz_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfoOrBuilder
            public ByteString getGameBizBytes() {
                Object ref = this.gameBiz_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gameBiz_ = b;
                return b;
            }

            public Builder setGameBiz(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gameBiz_ = value;
                onChanged();
                return this;
            }

            public Builder clearGameBiz() {
                this.gameBiz_ = RegionInfo.getDefaultInstance().getGameBiz();
                onChanged();
                return this;
            }

            public Builder setGameBizBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionInfo.checkByteStringIsUtf8(value);
                this.gameBiz_ = value;
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

        public static RegionInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RegionInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RegionInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RegionInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ResVersionConfigOuterClass.getDescriptor();
    }
}
