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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerTokenReqOuterClass.class */
public final class GetPlayerTokenReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017GetPlayerTokenReq.proto\"Å\u0003\n\u0011GetPlayerTokenReq\u0012\u000b\n\u0003uid\u0018\n \u0001(\r\u0012\u0018\n\u000fcloud_client_ip\u0018Ç\r \u0001(\r\u0012\u0015\n\rplatform_type\u0018\u0002 \u0001(\r\u0012\u0010\n\bis_guest\u0018\u000e \u0001(\b\u0012\u0011\n\tonline_id\u0018\f \u0001(\t\u0012\u0014\n\faccount_type\u0018\u0006 \u0001(\r\u0012\u0012\n\nchannel_id\u0018\b \u0001(\r\u0012\u0018\n\u000fclient_rand_key\u0018\u0003 \u0001(\t\u0012\u001b\n\u0013Unk3300_PHNOHCKIHIA\u0018\u0003 \u0001(\t\u0012\r\n\u0004lang\u0018\f \u0001(\r\u0012\u001b\n\u0013Unk3300_PKONAOIDNFK\u0018\r \u0001(\t\u0012\u001b\n\u0013Unk3300_PMGFBMJNNCL\u0018\u0001 \u0001(\r\u0012\u000e\n\u0006psn_id\u0018\u0005 \u0001(\t\u0012\u000f\n\u0006key_id\u0018\t \u0001(\r\u0012\u0013\n\u000baccount_uid\u0018\u0004 \u0001(\t\u0012\u0015\n\rclient_ip_str\u0018\u000f \u0001(\t\u0012\u0015\n\raccount_token\u0018\t \u0001(\t\u0012\u0014\n\fcountry_code\u0018\u000b \u0001(\t\u0012\u0011\n\bbirthday\u0018¤\u0002 \u0001(\t\u0012\u0016\n\u000esub_channel_id\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GetPlayerTokenReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetPlayerTokenReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetPlayerTokenReq_descriptor, new String[]{"Uid", "CloudClientIp", "PlatformType", "IsGuest", "OnlineId", "AccountType", "ChannelId", "ClientRandKey", "Unk3300PHNOHCKIHIA", "Lang", "Unk3300PKONAOIDNFK", "Unk3300PMGFBMJNNCL", "PsnId", "KeyId", "AccountUid", "ClientIpStr", "AccountToken", "CountryCode", "Birthday", "SubChannelId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerTokenReqOuterClass$GetPlayerTokenReqOrBuilder.class */
    public interface GetPlayerTokenReqOrBuilder extends MessageOrBuilder {
        int getUid();

        int getCloudClientIp();

        int getPlatformType();

        boolean getIsGuest();

        String getOnlineId();

        ByteString getOnlineIdBytes();

        int getAccountType();

        int getChannelId();

        String getClientRandKey();

        ByteString getClientRandKeyBytes();

        String getUnk3300PHNOHCKIHIA();

        ByteString getUnk3300PHNOHCKIHIABytes();

        int getLang();

        String getUnk3300PKONAOIDNFK();

        ByteString getUnk3300PKONAOIDNFKBytes();

        int getUnk3300PMGFBMJNNCL();

        String getPsnId();

        ByteString getPsnIdBytes();

        int getKeyId();

        String getAccountUid();

        ByteString getAccountUidBytes();

        String getClientIpStr();

        ByteString getClientIpStrBytes();

        String getAccountToken();

        ByteString getAccountTokenBytes();

        String getCountryCode();

        ByteString getCountryCodeBytes();

        String getBirthday();

        ByteString getBirthdayBytes();

        int getSubChannelId();
    }

    private GetPlayerTokenReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerTokenReqOuterClass$GetPlayerTokenReq.class */
    public static final class GetPlayerTokenReq extends GeneratedMessageV3 implements GetPlayerTokenReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UID_FIELD_NUMBER = 10;
        private int uid_;
        public static final int CLOUD_CLIENT_IP_FIELD_NUMBER = 1735;
        private int cloudClientIp_;
        public static final int PLATFORM_TYPE_FIELD_NUMBER = 2;
        private int platformType_;
        public static final int IS_GUEST_FIELD_NUMBER = 14;
        private boolean isGuest_;
        public static final int ONLINE_ID_FIELD_NUMBER = 12;
        private volatile Object onlineId_;
        public static final int ACCOUNT_TYPE_FIELD_NUMBER = 6;
        private int accountType_;
        public static final int CHANNEL_ID_FIELD_NUMBER = 8;
        private int channelId_;
        public static final int CLIENT_RAND_KEY_FIELD_NUMBER = 400;
        private volatile Object clientRandKey_;
        public static final int UNK3300_PHNOHCKIHIA_FIELD_NUMBER = 3;
        private volatile Object unk3300PHNOHCKIHIA_;
        public static final int LANG_FIELD_NUMBER = 1548;
        private int lang_;
        public static final int UNK3300_PKONAOIDNFK_FIELD_NUMBER = 13;
        private volatile Object unk3300PKONAOIDNFK_;
        public static final int UNK3300_PMGFBMJNNCL_FIELD_NUMBER = 1;
        private int unk3300PMGFBMJNNCL_;
        public static final int PSN_ID_FIELD_NUMBER = 5;
        private volatile Object psnId_;
        public static final int KEY_ID_FIELD_NUMBER = 1175;
        private int keyId_;
        public static final int ACCOUNT_UID_FIELD_NUMBER = 4;
        private volatile Object accountUid_;
        public static final int CLIENT_IP_STR_FIELD_NUMBER = 15;
        private volatile Object clientIpStr_;
        public static final int ACCOUNT_TOKEN_FIELD_NUMBER = 9;
        private volatile Object accountToken_;
        public static final int COUNTRY_CODE_FIELD_NUMBER = 11;
        private volatile Object countryCode_;
        public static final int BIRTHDAY_FIELD_NUMBER = 292;
        private volatile Object birthday_;
        public static final int SUB_CHANNEL_ID_FIELD_NUMBER = 7;
        private int subChannelId_;
        private byte memoizedIsInitialized;
        private static final GetPlayerTokenReq DEFAULT_INSTANCE = new GetPlayerTokenReq();
        private static final Parser<GetPlayerTokenReq> PARSER = new AbstractParser<GetPlayerTokenReq>() { // from class: emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReq.1
            @Override // com.google.protobuf.Parser
            public GetPlayerTokenReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetPlayerTokenReq(input, extensionRegistry);
            }
        };

        private GetPlayerTokenReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetPlayerTokenReq() {
            this.memoizedIsInitialized = -1;
            this.onlineId_ = "";
            this.clientRandKey_ = "";
            this.unk3300PHNOHCKIHIA_ = "";
            this.unk3300PKONAOIDNFK_ = "";
            this.psnId_ = "";
            this.accountUid_ = "";
            this.clientIpStr_ = "";
            this.accountToken_ = "";
            this.countryCode_ = "";
            this.birthday_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetPlayerTokenReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetPlayerTokenReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.unk3300PMGFBMJNNCL_ = input.readUInt32();
                                break;
                            case 16:
                                this.platformType_ = input.readUInt32();
                                break;
                            case 26:
                                this.unk3300PHNOHCKIHIA_ = input.readStringRequireUtf8();
                                break;
                            case 34:
                                this.accountUid_ = input.readStringRequireUtf8();
                                break;
                            case 42:
                                this.psnId_ = input.readStringRequireUtf8();
                                break;
                            case 48:
                                this.accountType_ = input.readUInt32();
                                break;
                            case 56:
                                this.subChannelId_ = input.readUInt32();
                                break;
                            case 64:
                                this.channelId_ = input.readUInt32();
                                break;
                            case 74:
                                this.accountToken_ = input.readStringRequireUtf8();
                                break;
                            case 80:
                                this.uid_ = input.readUInt32();
                                break;
                            case 90:
                                this.countryCode_ = input.readStringRequireUtf8();
                                break;
                            case 98:
                                this.onlineId_ = input.readStringRequireUtf8();
                                break;
                            case 106:
                                this.unk3300PKONAOIDNFK_ = input.readStringRequireUtf8();
                                break;
                            case 112:
                                this.isGuest_ = input.readBool();
                                break;
                            case 122:
                                this.clientIpStr_ = input.readStringRequireUtf8();
                                break;
                            case 2338:
                                this.birthday_ = input.readStringRequireUtf8();
                                break;
                            case 3202:
                                this.clientRandKey_ = input.readStringRequireUtf8();
                                break;
                            case 9400:
                                this.keyId_ = input.readUInt32();
                                break;
                            case 12384:
                                this.lang_ = input.readUInt32();
                                break;
                            case 13880:
                                this.cloudClientIp_ = input.readUInt32();
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
            return GetPlayerTokenReqOuterClass.internal_static_GetPlayerTokenReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetPlayerTokenReqOuterClass.internal_static_GetPlayerTokenReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GetPlayerTokenReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public int getCloudClientIp() {
            return this.cloudClientIp_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public int getPlatformType() {
            return this.platformType_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public boolean getIsGuest() {
            return this.isGuest_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public String getOnlineId() {
            Object ref = this.onlineId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.onlineId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public ByteString getOnlineIdBytes() {
            Object ref = this.onlineId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.onlineId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public int getAccountType() {
            return this.accountType_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public int getChannelId() {
            return this.channelId_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public String getClientRandKey() {
            Object ref = this.clientRandKey_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.clientRandKey_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public ByteString getClientRandKeyBytes() {
            Object ref = this.clientRandKey_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.clientRandKey_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public String getUnk3300PHNOHCKIHIA() {
            Object ref = this.unk3300PHNOHCKIHIA_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.unk3300PHNOHCKIHIA_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public ByteString getUnk3300PHNOHCKIHIABytes() {
            Object ref = this.unk3300PHNOHCKIHIA_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.unk3300PHNOHCKIHIA_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public int getLang() {
            return this.lang_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public String getUnk3300PKONAOIDNFK() {
            Object ref = this.unk3300PKONAOIDNFK_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.unk3300PKONAOIDNFK_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public ByteString getUnk3300PKONAOIDNFKBytes() {
            Object ref = this.unk3300PKONAOIDNFK_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.unk3300PKONAOIDNFK_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public int getUnk3300PMGFBMJNNCL() {
            return this.unk3300PMGFBMJNNCL_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public String getPsnId() {
            Object ref = this.psnId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.psnId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public ByteString getPsnIdBytes() {
            Object ref = this.psnId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.psnId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public int getKeyId() {
            return this.keyId_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public String getAccountUid() {
            Object ref = this.accountUid_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.accountUid_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public ByteString getAccountUidBytes() {
            Object ref = this.accountUid_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.accountUid_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public String getClientIpStr() {
            Object ref = this.clientIpStr_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.clientIpStr_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public ByteString getClientIpStrBytes() {
            Object ref = this.clientIpStr_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.clientIpStr_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public String getAccountToken() {
            Object ref = this.accountToken_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.accountToken_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public ByteString getAccountTokenBytes() {
            Object ref = this.accountToken_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.accountToken_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public String getCountryCode() {
            Object ref = this.countryCode_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.countryCode_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public ByteString getCountryCodeBytes() {
            Object ref = this.countryCode_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.countryCode_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public String getBirthday() {
            Object ref = this.birthday_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.birthday_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public ByteString getBirthdayBytes() {
            Object ref = this.birthday_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.birthday_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
        public int getSubChannelId() {
            return this.subChannelId_;
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
            if (this.unk3300PMGFBMJNNCL_ != 0) {
                output.writeUInt32(1, this.unk3300PMGFBMJNNCL_);
            }
            if (this.platformType_ != 0) {
                output.writeUInt32(2, this.platformType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300PHNOHCKIHIA_)) {
                GeneratedMessageV3.writeString(output, 3, this.unk3300PHNOHCKIHIA_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.accountUid_)) {
                GeneratedMessageV3.writeString(output, 4, this.accountUid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.psnId_)) {
                GeneratedMessageV3.writeString(output, 5, this.psnId_);
            }
            if (this.accountType_ != 0) {
                output.writeUInt32(6, this.accountType_);
            }
            if (this.subChannelId_ != 0) {
                output.writeUInt32(7, this.subChannelId_);
            }
            if (this.channelId_ != 0) {
                output.writeUInt32(8, this.channelId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.accountToken_)) {
                GeneratedMessageV3.writeString(output, 9, this.accountToken_);
            }
            if (this.uid_ != 0) {
                output.writeUInt32(10, this.uid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.countryCode_)) {
                GeneratedMessageV3.writeString(output, 11, this.countryCode_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.onlineId_)) {
                GeneratedMessageV3.writeString(output, 12, this.onlineId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300PKONAOIDNFK_)) {
                GeneratedMessageV3.writeString(output, 13, this.unk3300PKONAOIDNFK_);
            }
            if (this.isGuest_) {
                output.writeBool(14, this.isGuest_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientIpStr_)) {
                GeneratedMessageV3.writeString(output, 15, this.clientIpStr_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.birthday_)) {
                GeneratedMessageV3.writeString(output, 292, this.birthday_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientRandKey_)) {
                GeneratedMessageV3.writeString(output, 400, this.clientRandKey_);
            }
            if (this.keyId_ != 0) {
                output.writeUInt32(KEY_ID_FIELD_NUMBER, this.keyId_);
            }
            if (this.lang_ != 0) {
                output.writeUInt32(LANG_FIELD_NUMBER, this.lang_);
            }
            if (this.cloudClientIp_ != 0) {
                output.writeUInt32(1735, this.cloudClientIp_);
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
            if (this.unk3300PMGFBMJNNCL_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.unk3300PMGFBMJNNCL_);
            }
            if (this.platformType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.platformType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300PHNOHCKIHIA_)) {
                size2 += GeneratedMessageV3.computeStringSize(3, this.unk3300PHNOHCKIHIA_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.accountUid_)) {
                size2 += GeneratedMessageV3.computeStringSize(4, this.accountUid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.psnId_)) {
                size2 += GeneratedMessageV3.computeStringSize(5, this.psnId_);
            }
            if (this.accountType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.accountType_);
            }
            if (this.subChannelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.subChannelId_);
            }
            if (this.channelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.channelId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.accountToken_)) {
                size2 += GeneratedMessageV3.computeStringSize(9, this.accountToken_);
            }
            if (this.uid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.uid_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.countryCode_)) {
                size2 += GeneratedMessageV3.computeStringSize(11, this.countryCode_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.onlineId_)) {
                size2 += GeneratedMessageV3.computeStringSize(12, this.onlineId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300PKONAOIDNFK_)) {
                size2 += GeneratedMessageV3.computeStringSize(13, this.unk3300PKONAOIDNFK_);
            }
            if (this.isGuest_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.isGuest_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientIpStr_)) {
                size2 += GeneratedMessageV3.computeStringSize(15, this.clientIpStr_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.birthday_)) {
                size2 += GeneratedMessageV3.computeStringSize(292, this.birthday_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientRandKey_)) {
                size2 += GeneratedMessageV3.computeStringSize(400, this.clientRandKey_);
            }
            if (this.keyId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(KEY_ID_FIELD_NUMBER, this.keyId_);
            }
            if (this.lang_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(LANG_FIELD_NUMBER, this.lang_);
            }
            if (this.cloudClientIp_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(1735, this.cloudClientIp_);
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
            if (!(obj instanceof GetPlayerTokenReq)) {
                return equals(obj);
            }
            GetPlayerTokenReq other = (GetPlayerTokenReq) obj;
            return getUid() == other.getUid() && getCloudClientIp() == other.getCloudClientIp() && getPlatformType() == other.getPlatformType() && getIsGuest() == other.getIsGuest() && getOnlineId().equals(other.getOnlineId()) && getAccountType() == other.getAccountType() && getChannelId() == other.getChannelId() && getClientRandKey().equals(other.getClientRandKey()) && getUnk3300PHNOHCKIHIA().equals(other.getUnk3300PHNOHCKIHIA()) && getLang() == other.getLang() && getUnk3300PKONAOIDNFK().equals(other.getUnk3300PKONAOIDNFK()) && getUnk3300PMGFBMJNNCL() == other.getUnk3300PMGFBMJNNCL() && getPsnId().equals(other.getPsnId()) && getKeyId() == other.getKeyId() && getAccountUid().equals(other.getAccountUid()) && getClientIpStr().equals(other.getClientIpStr()) && getAccountToken().equals(other.getAccountToken()) && getCountryCode().equals(other.getCountryCode()) && getBirthday().equals(other.getBirthday()) && getSubChannelId() == other.getSubChannelId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getUid())) + 1735)) + getCloudClientIp())) + 2)) + getPlatformType())) + 14)) + Internal.hashBoolean(getIsGuest()))) + 12)) + getOnlineId().hashCode())) + 6)) + getAccountType())) + 8)) + getChannelId())) + 400)) + getClientRandKey().hashCode())) + 3)) + getUnk3300PHNOHCKIHIA().hashCode())) + LANG_FIELD_NUMBER)) + getLang())) + 13)) + getUnk3300PKONAOIDNFK().hashCode())) + 1)) + getUnk3300PMGFBMJNNCL())) + 5)) + getPsnId().hashCode())) + KEY_ID_FIELD_NUMBER)) + getKeyId())) + 4)) + getAccountUid().hashCode())) + 15)) + getClientIpStr().hashCode())) + 9)) + getAccountToken().hashCode())) + 11)) + getCountryCode().hashCode())) + 292)) + getBirthday().hashCode())) + 7)) + getSubChannelId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static GetPlayerTokenReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerTokenReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerTokenReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerTokenReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerTokenReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerTokenReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerTokenReq parseFrom(InputStream input) throws IOException {
            return (GetPlayerTokenReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetPlayerTokenReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerTokenReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetPlayerTokenReq parseDelimitedFrom(InputStream input) throws IOException {
            return (GetPlayerTokenReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetPlayerTokenReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerTokenReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetPlayerTokenReq parseFrom(CodedInputStream input) throws IOException {
            return (GetPlayerTokenReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetPlayerTokenReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerTokenReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetPlayerTokenReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerTokenReqOuterClass$GetPlayerTokenReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetPlayerTokenReqOrBuilder {
            private int uid_;
            private int cloudClientIp_;
            private int platformType_;
            private boolean isGuest_;
            private int accountType_;
            private int channelId_;
            private int lang_;
            private int unk3300PMGFBMJNNCL_;
            private int keyId_;
            private int subChannelId_;
            private Object onlineId_ = "";
            private Object clientRandKey_ = "";
            private Object unk3300PHNOHCKIHIA_ = "";
            private Object unk3300PKONAOIDNFK_ = "";
            private Object psnId_ = "";
            private Object accountUid_ = "";
            private Object clientIpStr_ = "";
            private Object accountToken_ = "";
            private Object countryCode_ = "";
            private Object birthday_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return GetPlayerTokenReqOuterClass.internal_static_GetPlayerTokenReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetPlayerTokenReqOuterClass.internal_static_GetPlayerTokenReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GetPlayerTokenReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetPlayerTokenReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.uid_ = 0;
                this.cloudClientIp_ = 0;
                this.platformType_ = 0;
                this.isGuest_ = false;
                this.onlineId_ = "";
                this.accountType_ = 0;
                this.channelId_ = 0;
                this.clientRandKey_ = "";
                this.unk3300PHNOHCKIHIA_ = "";
                this.lang_ = 0;
                this.unk3300PKONAOIDNFK_ = "";
                this.unk3300PMGFBMJNNCL_ = 0;
                this.psnId_ = "";
                this.keyId_ = 0;
                this.accountUid_ = "";
                this.clientIpStr_ = "";
                this.accountToken_ = "";
                this.countryCode_ = "";
                this.birthday_ = "";
                this.subChannelId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetPlayerTokenReqOuterClass.internal_static_GetPlayerTokenReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetPlayerTokenReq getDefaultInstanceForType() {
                return GetPlayerTokenReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetPlayerTokenReq build() {
                GetPlayerTokenReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetPlayerTokenReq buildPartial() {
                GetPlayerTokenReq result = new GetPlayerTokenReq(this);
                result.uid_ = this.uid_;
                result.cloudClientIp_ = this.cloudClientIp_;
                result.platformType_ = this.platformType_;
                result.isGuest_ = this.isGuest_;
                result.onlineId_ = this.onlineId_;
                result.accountType_ = this.accountType_;
                result.channelId_ = this.channelId_;
                result.clientRandKey_ = this.clientRandKey_;
                result.unk3300PHNOHCKIHIA_ = this.unk3300PHNOHCKIHIA_;
                result.lang_ = this.lang_;
                result.unk3300PKONAOIDNFK_ = this.unk3300PKONAOIDNFK_;
                result.unk3300PMGFBMJNNCL_ = this.unk3300PMGFBMJNNCL_;
                result.psnId_ = this.psnId_;
                result.keyId_ = this.keyId_;
                result.accountUid_ = this.accountUid_;
                result.clientIpStr_ = this.clientIpStr_;
                result.accountToken_ = this.accountToken_;
                result.countryCode_ = this.countryCode_;
                result.birthday_ = this.birthday_;
                result.subChannelId_ = this.subChannelId_;
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
                if (other instanceof GetPlayerTokenReq) {
                    return mergeFrom((GetPlayerTokenReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetPlayerTokenReq other) {
                if (other == GetPlayerTokenReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (other.getCloudClientIp() != 0) {
                    setCloudClientIp(other.getCloudClientIp());
                }
                if (other.getPlatformType() != 0) {
                    setPlatformType(other.getPlatformType());
                }
                if (other.getIsGuest()) {
                    setIsGuest(other.getIsGuest());
                }
                if (!other.getOnlineId().isEmpty()) {
                    this.onlineId_ = other.onlineId_;
                    onChanged();
                }
                if (other.getAccountType() != 0) {
                    setAccountType(other.getAccountType());
                }
                if (other.getChannelId() != 0) {
                    setChannelId(other.getChannelId());
                }
                if (!other.getClientRandKey().isEmpty()) {
                    this.clientRandKey_ = other.clientRandKey_;
                    onChanged();
                }
                if (!other.getUnk3300PHNOHCKIHIA().isEmpty()) {
                    this.unk3300PHNOHCKIHIA_ = other.unk3300PHNOHCKIHIA_;
                    onChanged();
                }
                if (other.getLang() != 0) {
                    setLang(other.getLang());
                }
                if (!other.getUnk3300PKONAOIDNFK().isEmpty()) {
                    this.unk3300PKONAOIDNFK_ = other.unk3300PKONAOIDNFK_;
                    onChanged();
                }
                if (other.getUnk3300PMGFBMJNNCL() != 0) {
                    setUnk3300PMGFBMJNNCL(other.getUnk3300PMGFBMJNNCL());
                }
                if (!other.getPsnId().isEmpty()) {
                    this.psnId_ = other.psnId_;
                    onChanged();
                }
                if (other.getKeyId() != 0) {
                    setKeyId(other.getKeyId());
                }
                if (!other.getAccountUid().isEmpty()) {
                    this.accountUid_ = other.accountUid_;
                    onChanged();
                }
                if (!other.getClientIpStr().isEmpty()) {
                    this.clientIpStr_ = other.clientIpStr_;
                    onChanged();
                }
                if (!other.getAccountToken().isEmpty()) {
                    this.accountToken_ = other.accountToken_;
                    onChanged();
                }
                if (!other.getCountryCode().isEmpty()) {
                    this.countryCode_ = other.countryCode_;
                    onChanged();
                }
                if (!other.getBirthday().isEmpty()) {
                    this.birthday_ = other.birthday_;
                    onChanged();
                }
                if (other.getSubChannelId() != 0) {
                    setSubChannelId(other.getSubChannelId());
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
                GetPlayerTokenReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetPlayerTokenReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetPlayerTokenReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
            public String getOnlineId() {
                Object ref = this.onlineId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.onlineId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
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
                this.onlineId_ = GetPlayerTokenReq.getDefaultInstance().getOnlineId();
                onChanged();
                return this;
            }

            public Builder setOnlineIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenReq.checkByteStringIsUtf8(value);
                this.onlineId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
            public String getClientRandKey() {
                Object ref = this.clientRandKey_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.clientRandKey_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
            public ByteString getClientRandKeyBytes() {
                Object ref = this.clientRandKey_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientRandKey_ = b;
                return b;
            }

            public Builder setClientRandKey(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientRandKey_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientRandKey() {
                this.clientRandKey_ = GetPlayerTokenReq.getDefaultInstance().getClientRandKey();
                onChanged();
                return this;
            }

            public Builder setClientRandKeyBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenReq.checkByteStringIsUtf8(value);
                this.clientRandKey_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
            public String getUnk3300PHNOHCKIHIA() {
                Object ref = this.unk3300PHNOHCKIHIA_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.unk3300PHNOHCKIHIA_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
            public ByteString getUnk3300PHNOHCKIHIABytes() {
                Object ref = this.unk3300PHNOHCKIHIA_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.unk3300PHNOHCKIHIA_ = b;
                return b;
            }

            public Builder setUnk3300PHNOHCKIHIA(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unk3300PHNOHCKIHIA_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300PHNOHCKIHIA() {
                this.unk3300PHNOHCKIHIA_ = GetPlayerTokenReq.getDefaultInstance().getUnk3300PHNOHCKIHIA();
                onChanged();
                return this;
            }

            public Builder setUnk3300PHNOHCKIHIABytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenReq.checkByteStringIsUtf8(value);
                this.unk3300PHNOHCKIHIA_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
            public int getLang() {
                return this.lang_;
            }

            public Builder setLang(int value) {
                this.lang_ = value;
                onChanged();
                return this;
            }

            public Builder clearLang() {
                this.lang_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
            public String getUnk3300PKONAOIDNFK() {
                Object ref = this.unk3300PKONAOIDNFK_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.unk3300PKONAOIDNFK_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
            public ByteString getUnk3300PKONAOIDNFKBytes() {
                Object ref = this.unk3300PKONAOIDNFK_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.unk3300PKONAOIDNFK_ = b;
                return b;
            }

            public Builder setUnk3300PKONAOIDNFK(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unk3300PKONAOIDNFK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300PKONAOIDNFK() {
                this.unk3300PKONAOIDNFK_ = GetPlayerTokenReq.getDefaultInstance().getUnk3300PKONAOIDNFK();
                onChanged();
                return this;
            }

            public Builder setUnk3300PKONAOIDNFKBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenReq.checkByteStringIsUtf8(value);
                this.unk3300PKONAOIDNFK_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
            public String getPsnId() {
                Object ref = this.psnId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.psnId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
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
                this.psnId_ = GetPlayerTokenReq.getDefaultInstance().getPsnId();
                onChanged();
                return this;
            }

            public Builder setPsnIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenReq.checkByteStringIsUtf8(value);
                this.psnId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
            public String getAccountUid() {
                Object ref = this.accountUid_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.accountUid_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
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
                this.accountUid_ = GetPlayerTokenReq.getDefaultInstance().getAccountUid();
                onChanged();
                return this;
            }

            public Builder setAccountUidBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenReq.checkByteStringIsUtf8(value);
                this.accountUid_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
            public String getClientIpStr() {
                Object ref = this.clientIpStr_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.clientIpStr_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
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
                this.clientIpStr_ = GetPlayerTokenReq.getDefaultInstance().getClientIpStr();
                onChanged();
                return this;
            }

            public Builder setClientIpStrBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenReq.checkByteStringIsUtf8(value);
                this.clientIpStr_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
            public String getAccountToken() {
                Object ref = this.accountToken_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.accountToken_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
            public ByteString getAccountTokenBytes() {
                Object ref = this.accountToken_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.accountToken_ = b;
                return b;
            }

            public Builder setAccountToken(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.accountToken_ = value;
                onChanged();
                return this;
            }

            public Builder clearAccountToken() {
                this.accountToken_ = GetPlayerTokenReq.getDefaultInstance().getAccountToken();
                onChanged();
                return this;
            }

            public Builder setAccountTokenBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenReq.checkByteStringIsUtf8(value);
                this.accountToken_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
            public String getCountryCode() {
                Object ref = this.countryCode_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.countryCode_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
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
                this.countryCode_ = GetPlayerTokenReq.getDefaultInstance().getCountryCode();
                onChanged();
                return this;
            }

            public Builder setCountryCodeBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenReq.checkByteStringIsUtf8(value);
                this.countryCode_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
            public String getBirthday() {
                Object ref = this.birthday_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.birthday_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
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
                this.birthday_ = GetPlayerTokenReq.getDefaultInstance().getBirthday();
                onChanged();
                return this;
            }

            public Builder setBirthdayBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetPlayerTokenReq.checkByteStringIsUtf8(value);
                this.birthday_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerTokenReqOuterClass.GetPlayerTokenReqOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static GetPlayerTokenReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetPlayerTokenReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetPlayerTokenReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetPlayerTokenReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
