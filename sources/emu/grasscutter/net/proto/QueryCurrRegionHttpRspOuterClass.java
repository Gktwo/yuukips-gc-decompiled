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
import emu.grasscutter.net.proto.ForceUpdateInfoOuterClass;
import emu.grasscutter.net.proto.RegionInfoOuterClass;
import emu.grasscutter.net.proto.StopServerInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryCurrRegionHttpRspOuterClass.class */
public final class QueryCurrRegionHttpRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cQueryCurrRegionHttpRsp.proto\u001a\u0015ForceUpdateInfo.proto\u001a\u0010RegionInfo.proto\u001a\u0014StopServerInfo.proto\"¦\u0002\n\u0016QueryCurrRegionHttpRsp\u0012\u000f\n\u0007retcode\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003msg\u0018\u0002 \u0001(\t\u0012 \n\u000bregion_info\u0018\u0003 \u0001(\u000b2\u000b.RegionInfo\u0012\u0019\n\u0011client_secret_key\u0018\u000b \u0001(\f\u0012&\n\u001eregion_custom_config_encrypted\u0018\f \u0001(\f\u0012-\n%client_region_custom_config_encrypted\u0018\r \u0001(\f\u0012(\n\fforce_update\u0018\u0004 \u0001(\u000b2\u0010.ForceUpdateInfoH��\u0012&\n\u000bstop_server\u0018\u0005 \u0001(\u000b2\u000f.StopServerInfoH��B\b\n\u0006detailB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ForceUpdateInfoOuterClass.getDescriptor(), RegionInfoOuterClass.getDescriptor(), StopServerInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_QueryCurrRegionHttpRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QueryCurrRegionHttpRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QueryCurrRegionHttpRsp_descriptor, new String[]{"Retcode", "Msg", "RegionInfo", "ClientSecretKey", "RegionCustomConfigEncrypted", "ClientRegionCustomConfigEncrypted", "ForceUpdate", "StopServer", "Detail"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryCurrRegionHttpRspOuterClass$QueryCurrRegionHttpRspOrBuilder.class */
    public interface QueryCurrRegionHttpRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        String getMsg();

        ByteString getMsgBytes();

        boolean hasRegionInfo();

        RegionInfoOuterClass.RegionInfo getRegionInfo();

        RegionInfoOuterClass.RegionInfoOrBuilder getRegionInfoOrBuilder();

        ByteString getClientSecretKey();

        ByteString getRegionCustomConfigEncrypted();

        ByteString getClientRegionCustomConfigEncrypted();

        boolean hasForceUpdate();

        ForceUpdateInfoOuterClass.ForceUpdateInfo getForceUpdate();

        ForceUpdateInfoOuterClass.ForceUpdateInfoOrBuilder getForceUpdateOrBuilder();

        boolean hasStopServer();

        StopServerInfoOuterClass.StopServerInfo getStopServer();

        StopServerInfoOuterClass.StopServerInfoOrBuilder getStopServerOrBuilder();

        QueryCurrRegionHttpRsp.DetailCase getDetailCase();
    }

    private QueryCurrRegionHttpRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryCurrRegionHttpRspOuterClass$QueryCurrRegionHttpRsp.class */
    public static final class QueryCurrRegionHttpRsp extends GeneratedMessageV3 implements QueryCurrRegionHttpRspOrBuilder {
        private static final long serialVersionUID = 0;
        private int detailCase_;
        private Object detail_;
        public static final int RETCODE_FIELD_NUMBER = 1;
        private int retcode_;
        public static final int MSG_FIELD_NUMBER = 2;
        private volatile Object msg_;
        public static final int REGION_INFO_FIELD_NUMBER = 3;
        private RegionInfoOuterClass.RegionInfo regionInfo_;
        public static final int CLIENT_SECRET_KEY_FIELD_NUMBER = 11;
        private ByteString clientSecretKey_;
        public static final int REGION_CUSTOM_CONFIG_ENCRYPTED_FIELD_NUMBER = 12;
        private ByteString regionCustomConfigEncrypted_;
        public static final int CLIENT_REGION_CUSTOM_CONFIG_ENCRYPTED_FIELD_NUMBER = 13;
        private ByteString clientRegionCustomConfigEncrypted_;
        public static final int FORCE_UPDATE_FIELD_NUMBER = 4;
        public static final int STOP_SERVER_FIELD_NUMBER = 5;
        private byte memoizedIsInitialized;
        private static final QueryCurrRegionHttpRsp DEFAULT_INSTANCE = new QueryCurrRegionHttpRsp();
        private static final Parser<QueryCurrRegionHttpRsp> PARSER = new AbstractParser<QueryCurrRegionHttpRsp>() { // from class: emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp.1
            @Override // com.google.protobuf.Parser
            public QueryCurrRegionHttpRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QueryCurrRegionHttpRsp(input, extensionRegistry);
            }
        };

        private QueryCurrRegionHttpRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.detailCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private QueryCurrRegionHttpRsp() {
            this.detailCase_ = 0;
            this.memoizedIsInitialized = -1;
            this.msg_ = "";
            this.clientSecretKey_ = ByteString.EMPTY;
            this.regionCustomConfigEncrypted_ = ByteString.EMPTY;
            this.clientRegionCustomConfigEncrypted_ = ByteString.EMPTY;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QueryCurrRegionHttpRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QueryCurrRegionHttpRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.retcode_ = input.readInt32();
                                break;
                            case 18:
                                this.msg_ = input.readStringRequireUtf8();
                                break;
                            case 26:
                                RegionInfoOuterClass.RegionInfo.Builder subBuilder = this.regionInfo_ != null ? this.regionInfo_.toBuilder() : null;
                                this.regionInfo_ = (RegionInfoOuterClass.RegionInfo) input.readMessage(RegionInfoOuterClass.RegionInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.regionInfo_);
                                    this.regionInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 34:
                                ForceUpdateInfoOuterClass.ForceUpdateInfo.Builder subBuilder2 = this.detailCase_ == 4 ? ((ForceUpdateInfoOuterClass.ForceUpdateInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(ForceUpdateInfoOuterClass.ForceUpdateInfo.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((ForceUpdateInfoOuterClass.ForceUpdateInfo) this.detail_);
                                    this.detail_ = subBuilder2.buildPartial();
                                }
                                this.detailCase_ = 4;
                                break;
                            case 42:
                                StopServerInfoOuterClass.StopServerInfo.Builder subBuilder3 = this.detailCase_ == 5 ? ((StopServerInfoOuterClass.StopServerInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(StopServerInfoOuterClass.StopServerInfo.parser(), extensionRegistry);
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((StopServerInfoOuterClass.StopServerInfo) this.detail_);
                                    this.detail_ = subBuilder3.buildPartial();
                                }
                                this.detailCase_ = 5;
                                break;
                            case 90:
                                this.clientSecretKey_ = input.readBytes();
                                break;
                            case 98:
                                this.regionCustomConfigEncrypted_ = input.readBytes();
                                break;
                            case 106:
                                this.clientRegionCustomConfigEncrypted_ = input.readBytes();
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
            return QueryCurrRegionHttpRspOuterClass.internal_static_QueryCurrRegionHttpRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QueryCurrRegionHttpRspOuterClass.internal_static_QueryCurrRegionHttpRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryCurrRegionHttpRsp.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryCurrRegionHttpRspOuterClass$QueryCurrRegionHttpRsp$DetailCase.class */
        public enum DetailCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            FORCE_UPDATE(4),
            STOP_SERVER(5),
            DETAIL_NOT_SET(0);
            
            private final int value;

            DetailCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static DetailCase valueOf(int value) {
                return forNumber(value);
            }

            public static DetailCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return DETAIL_NOT_SET;
                    case 4:
                        return FORCE_UPDATE;
                    case 5:
                        return STOP_SERVER;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
        public DetailCase getDetailCase() {
            return DetailCase.forNumber(this.detailCase_);
        }

        @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
        public String getMsg() {
            Object ref = this.msg_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.msg_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
        public ByteString getMsgBytes() {
            Object ref = this.msg_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.msg_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
        public boolean hasRegionInfo() {
            return this.regionInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
        public RegionInfoOuterClass.RegionInfo getRegionInfo() {
            return this.regionInfo_ == null ? RegionInfoOuterClass.RegionInfo.getDefaultInstance() : this.regionInfo_;
        }

        @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
        public RegionInfoOuterClass.RegionInfoOrBuilder getRegionInfoOrBuilder() {
            return getRegionInfo();
        }

        @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
        public ByteString getClientSecretKey() {
            return this.clientSecretKey_;
        }

        @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
        public ByteString getRegionCustomConfigEncrypted() {
            return this.regionCustomConfigEncrypted_;
        }

        @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
        public ByteString getClientRegionCustomConfigEncrypted() {
            return this.clientRegionCustomConfigEncrypted_;
        }

        @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
        public boolean hasForceUpdate() {
            return this.detailCase_ == 4;
        }

        @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
        public ForceUpdateInfoOuterClass.ForceUpdateInfo getForceUpdate() {
            if (this.detailCase_ == 4) {
                return (ForceUpdateInfoOuterClass.ForceUpdateInfo) this.detail_;
            }
            return ForceUpdateInfoOuterClass.ForceUpdateInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
        public ForceUpdateInfoOuterClass.ForceUpdateInfoOrBuilder getForceUpdateOrBuilder() {
            if (this.detailCase_ == 4) {
                return (ForceUpdateInfoOuterClass.ForceUpdateInfo) this.detail_;
            }
            return ForceUpdateInfoOuterClass.ForceUpdateInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
        public boolean hasStopServer() {
            return this.detailCase_ == 5;
        }

        @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
        public StopServerInfoOuterClass.StopServerInfo getStopServer() {
            if (this.detailCase_ == 5) {
                return (StopServerInfoOuterClass.StopServerInfo) this.detail_;
            }
            return StopServerInfoOuterClass.StopServerInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
        public StopServerInfoOuterClass.StopServerInfoOrBuilder getStopServerOrBuilder() {
            if (this.detailCase_ == 5) {
                return (StopServerInfoOuterClass.StopServerInfo) this.detail_;
            }
            return StopServerInfoOuterClass.StopServerInfo.getDefaultInstance();
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
            if (this.retcode_ != 0) {
                output.writeInt32(1, this.retcode_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.msg_)) {
                GeneratedMessageV3.writeString(output, 2, this.msg_);
            }
            if (this.regionInfo_ != null) {
                output.writeMessage(3, getRegionInfo());
            }
            if (this.detailCase_ == 4) {
                output.writeMessage(4, (ForceUpdateInfoOuterClass.ForceUpdateInfo) this.detail_);
            }
            if (this.detailCase_ == 5) {
                output.writeMessage(5, (StopServerInfoOuterClass.StopServerInfo) this.detail_);
            }
            if (!this.clientSecretKey_.isEmpty()) {
                output.writeBytes(11, this.clientSecretKey_);
            }
            if (!this.regionCustomConfigEncrypted_.isEmpty()) {
                output.writeBytes(12, this.regionCustomConfigEncrypted_);
            }
            if (!this.clientRegionCustomConfigEncrypted_.isEmpty()) {
                output.writeBytes(13, this.clientRegionCustomConfigEncrypted_);
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.retcode_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.msg_)) {
                size2 += GeneratedMessageV3.computeStringSize(2, this.msg_);
            }
            if (this.regionInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(3, getRegionInfo());
            }
            if (this.detailCase_ == 4) {
                size2 += CodedOutputStream.computeMessageSize(4, (ForceUpdateInfoOuterClass.ForceUpdateInfo) this.detail_);
            }
            if (this.detailCase_ == 5) {
                size2 += CodedOutputStream.computeMessageSize(5, (StopServerInfoOuterClass.StopServerInfo) this.detail_);
            }
            if (!this.clientSecretKey_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(11, this.clientSecretKey_);
            }
            if (!this.regionCustomConfigEncrypted_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(12, this.regionCustomConfigEncrypted_);
            }
            if (!this.clientRegionCustomConfigEncrypted_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(13, this.clientRegionCustomConfigEncrypted_);
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
            if (!(obj instanceof QueryCurrRegionHttpRsp)) {
                return equals(obj);
            }
            QueryCurrRegionHttpRsp other = (QueryCurrRegionHttpRsp) obj;
            if (getRetcode() != other.getRetcode() || !getMsg().equals(other.getMsg()) || hasRegionInfo() != other.hasRegionInfo()) {
                return false;
            }
            if ((hasRegionInfo() && !getRegionInfo().equals(other.getRegionInfo())) || !getClientSecretKey().equals(other.getClientSecretKey()) || !getRegionCustomConfigEncrypted().equals(other.getRegionCustomConfigEncrypted()) || !getClientRegionCustomConfigEncrypted().equals(other.getClientRegionCustomConfigEncrypted()) || !getDetailCase().equals(other.getDetailCase())) {
                return false;
            }
            switch (this.detailCase_) {
                case 4:
                    if (!getForceUpdate().equals(other.getForceUpdate())) {
                        return false;
                    }
                    break;
                case 5:
                    if (!getStopServer().equals(other.getStopServer())) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getRetcode())) + 2)) + getMsg().hashCode();
            if (hasRegionInfo()) {
                hash = (53 * ((37 * hash) + 3)) + getRegionInfo().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 11)) + getClientSecretKey().hashCode())) + 12)) + getRegionCustomConfigEncrypted().hashCode())) + 13)) + getClientRegionCustomConfigEncrypted().hashCode();
            switch (this.detailCase_) {
                case 4:
                    hash2 = (53 * ((37 * hash2) + 4)) + getForceUpdate().hashCode();
                    break;
                case 5:
                    hash2 = (53 * ((37 * hash2) + 5)) + getStopServer().hashCode();
                    break;
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static QueryCurrRegionHttpRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryCurrRegionHttpRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryCurrRegionHttpRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryCurrRegionHttpRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryCurrRegionHttpRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryCurrRegionHttpRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryCurrRegionHttpRsp parseFrom(InputStream input) throws IOException {
            return (QueryCurrRegionHttpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QueryCurrRegionHttpRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryCurrRegionHttpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QueryCurrRegionHttpRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (QueryCurrRegionHttpRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QueryCurrRegionHttpRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryCurrRegionHttpRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QueryCurrRegionHttpRsp parseFrom(CodedInputStream input) throws IOException {
            return (QueryCurrRegionHttpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QueryCurrRegionHttpRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryCurrRegionHttpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QueryCurrRegionHttpRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryCurrRegionHttpRspOuterClass$QueryCurrRegionHttpRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QueryCurrRegionHttpRspOrBuilder {
            private Object detail_;
            private int retcode_;
            private RegionInfoOuterClass.RegionInfo regionInfo_;
            private SingleFieldBuilderV3<RegionInfoOuterClass.RegionInfo, RegionInfoOuterClass.RegionInfo.Builder, RegionInfoOuterClass.RegionInfoOrBuilder> regionInfoBuilder_;
            private SingleFieldBuilderV3<ForceUpdateInfoOuterClass.ForceUpdateInfo, ForceUpdateInfoOuterClass.ForceUpdateInfo.Builder, ForceUpdateInfoOuterClass.ForceUpdateInfoOrBuilder> forceUpdateBuilder_;
            private SingleFieldBuilderV3<StopServerInfoOuterClass.StopServerInfo, StopServerInfoOuterClass.StopServerInfo.Builder, StopServerInfoOuterClass.StopServerInfoOrBuilder> stopServerBuilder_;
            private int detailCase_ = 0;
            private Object msg_ = "";
            private ByteString clientSecretKey_ = ByteString.EMPTY;
            private ByteString regionCustomConfigEncrypted_ = ByteString.EMPTY;
            private ByteString clientRegionCustomConfigEncrypted_ = ByteString.EMPTY;

            public static final Descriptors.Descriptor getDescriptor() {
                return QueryCurrRegionHttpRspOuterClass.internal_static_QueryCurrRegionHttpRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QueryCurrRegionHttpRspOuterClass.internal_static_QueryCurrRegionHttpRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryCurrRegionHttpRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QueryCurrRegionHttpRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.msg_ = "";
                if (this.regionInfoBuilder_ == null) {
                    this.regionInfo_ = null;
                } else {
                    this.regionInfo_ = null;
                    this.regionInfoBuilder_ = null;
                }
                this.clientSecretKey_ = ByteString.EMPTY;
                this.regionCustomConfigEncrypted_ = ByteString.EMPTY;
                this.clientRegionCustomConfigEncrypted_ = ByteString.EMPTY;
                this.detailCase_ = 0;
                this.detail_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QueryCurrRegionHttpRspOuterClass.internal_static_QueryCurrRegionHttpRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QueryCurrRegionHttpRsp getDefaultInstanceForType() {
                return QueryCurrRegionHttpRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QueryCurrRegionHttpRsp build() {
                QueryCurrRegionHttpRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QueryCurrRegionHttpRsp buildPartial() {
                QueryCurrRegionHttpRsp result = new QueryCurrRegionHttpRsp(this);
                result.retcode_ = this.retcode_;
                result.msg_ = this.msg_;
                if (this.regionInfoBuilder_ == null) {
                    result.regionInfo_ = this.regionInfo_;
                } else {
                    result.regionInfo_ = this.regionInfoBuilder_.build();
                }
                result.clientSecretKey_ = this.clientSecretKey_;
                result.regionCustomConfigEncrypted_ = this.regionCustomConfigEncrypted_;
                result.clientRegionCustomConfigEncrypted_ = this.clientRegionCustomConfigEncrypted_;
                if (this.detailCase_ == 4) {
                    if (this.forceUpdateBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.forceUpdateBuilder_.build();
                    }
                }
                if (this.detailCase_ == 5) {
                    if (this.stopServerBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.stopServerBuilder_.build();
                    }
                }
                result.detailCase_ = this.detailCase_;
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
                if (other instanceof QueryCurrRegionHttpRsp) {
                    return mergeFrom((QueryCurrRegionHttpRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QueryCurrRegionHttpRsp other) {
                if (other == QueryCurrRegionHttpRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (!other.getMsg().isEmpty()) {
                    this.msg_ = other.msg_;
                    onChanged();
                }
                if (other.hasRegionInfo()) {
                    mergeRegionInfo(other.getRegionInfo());
                }
                if (other.getClientSecretKey() != ByteString.EMPTY) {
                    setClientSecretKey(other.getClientSecretKey());
                }
                if (other.getRegionCustomConfigEncrypted() != ByteString.EMPTY) {
                    setRegionCustomConfigEncrypted(other.getRegionCustomConfigEncrypted());
                }
                if (other.getClientRegionCustomConfigEncrypted() != ByteString.EMPTY) {
                    setClientRegionCustomConfigEncrypted(other.getClientRegionCustomConfigEncrypted());
                }
                switch (other.getDetailCase()) {
                    case FORCE_UPDATE:
                        mergeForceUpdate(other.getForceUpdate());
                        break;
                    case STOP_SERVER:
                        mergeStopServer(other.getStopServer());
                        break;
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
                QueryCurrRegionHttpRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = QueryCurrRegionHttpRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QueryCurrRegionHttpRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
            public DetailCase getDetailCase() {
                return DetailCase.forNumber(this.detailCase_);
            }

            public Builder clearDetail() {
                this.detailCase_ = 0;
                this.detail_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
            public String getMsg() {
                Object ref = this.msg_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.msg_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
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
                this.msg_ = QueryCurrRegionHttpRsp.getDefaultInstance().getMsg();
                onChanged();
                return this;
            }

            public Builder setMsgBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                QueryCurrRegionHttpRsp.checkByteStringIsUtf8(value);
                this.msg_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
            public boolean hasRegionInfo() {
                return (this.regionInfoBuilder_ == null && this.regionInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
            public RegionInfoOuterClass.RegionInfo getRegionInfo() {
                if (this.regionInfoBuilder_ == null) {
                    return this.regionInfo_ == null ? RegionInfoOuterClass.RegionInfo.getDefaultInstance() : this.regionInfo_;
                }
                return this.regionInfoBuilder_.getMessage();
            }

            public Builder setRegionInfo(RegionInfoOuterClass.RegionInfo value) {
                if (this.regionInfoBuilder_ != null) {
                    this.regionInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.regionInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRegionInfo(RegionInfoOuterClass.RegionInfo.Builder builderForValue) {
                if (this.regionInfoBuilder_ == null) {
                    this.regionInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.regionInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRegionInfo(RegionInfoOuterClass.RegionInfo value) {
                if (this.regionInfoBuilder_ == null) {
                    if (this.regionInfo_ != null) {
                        this.regionInfo_ = RegionInfoOuterClass.RegionInfo.newBuilder(this.regionInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.regionInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.regionInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRegionInfo() {
                if (this.regionInfoBuilder_ == null) {
                    this.regionInfo_ = null;
                    onChanged();
                } else {
                    this.regionInfo_ = null;
                    this.regionInfoBuilder_ = null;
                }
                return this;
            }

            public RegionInfoOuterClass.RegionInfo.Builder getRegionInfoBuilder() {
                onChanged();
                return getRegionInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
            public RegionInfoOuterClass.RegionInfoOrBuilder getRegionInfoOrBuilder() {
                if (this.regionInfoBuilder_ != null) {
                    return this.regionInfoBuilder_.getMessageOrBuilder();
                }
                return this.regionInfo_ == null ? RegionInfoOuterClass.RegionInfo.getDefaultInstance() : this.regionInfo_;
            }

            private SingleFieldBuilderV3<RegionInfoOuterClass.RegionInfo, RegionInfoOuterClass.RegionInfo.Builder, RegionInfoOuterClass.RegionInfoOrBuilder> getRegionInfoFieldBuilder() {
                if (this.regionInfoBuilder_ == null) {
                    this.regionInfoBuilder_ = new SingleFieldBuilderV3<>(getRegionInfo(), getParentForChildren(), isClean());
                    this.regionInfo_ = null;
                }
                return this.regionInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
            public ByteString getClientSecretKey() {
                return this.clientSecretKey_;
            }

            public Builder setClientSecretKey(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientSecretKey_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientSecretKey() {
                this.clientSecretKey_ = QueryCurrRegionHttpRsp.getDefaultInstance().getClientSecretKey();
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
            public ByteString getRegionCustomConfigEncrypted() {
                return this.regionCustomConfigEncrypted_;
            }

            public Builder setRegionCustomConfigEncrypted(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.regionCustomConfigEncrypted_ = value;
                onChanged();
                return this;
            }

            public Builder clearRegionCustomConfigEncrypted() {
                this.regionCustomConfigEncrypted_ = QueryCurrRegionHttpRsp.getDefaultInstance().getRegionCustomConfigEncrypted();
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
            public ByteString getClientRegionCustomConfigEncrypted() {
                return this.clientRegionCustomConfigEncrypted_;
            }

            public Builder setClientRegionCustomConfigEncrypted(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientRegionCustomConfigEncrypted_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientRegionCustomConfigEncrypted() {
                this.clientRegionCustomConfigEncrypted_ = QueryCurrRegionHttpRsp.getDefaultInstance().getClientRegionCustomConfigEncrypted();
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
            public boolean hasForceUpdate() {
                return this.detailCase_ == 4;
            }

            @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
            public ForceUpdateInfoOuterClass.ForceUpdateInfo getForceUpdate() {
                if (this.forceUpdateBuilder_ == null) {
                    if (this.detailCase_ == 4) {
                        return (ForceUpdateInfoOuterClass.ForceUpdateInfo) this.detail_;
                    }
                    return ForceUpdateInfoOuterClass.ForceUpdateInfo.getDefaultInstance();
                } else if (this.detailCase_ == 4) {
                    return this.forceUpdateBuilder_.getMessage();
                } else {
                    return ForceUpdateInfoOuterClass.ForceUpdateInfo.getDefaultInstance();
                }
            }

            public Builder setForceUpdate(ForceUpdateInfoOuterClass.ForceUpdateInfo value) {
                if (this.forceUpdateBuilder_ != null) {
                    this.forceUpdateBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 4;
                return this;
            }

            public Builder setForceUpdate(ForceUpdateInfoOuterClass.ForceUpdateInfo.Builder builderForValue) {
                if (this.forceUpdateBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.forceUpdateBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 4;
                return this;
            }

            public Builder mergeForceUpdate(ForceUpdateInfoOuterClass.ForceUpdateInfo value) {
                if (this.forceUpdateBuilder_ == null) {
                    if (this.detailCase_ != 4 || this.detail_ == ForceUpdateInfoOuterClass.ForceUpdateInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = ForceUpdateInfoOuterClass.ForceUpdateInfo.newBuilder((ForceUpdateInfoOuterClass.ForceUpdateInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 4) {
                        this.forceUpdateBuilder_.mergeFrom(value);
                    }
                    this.forceUpdateBuilder_.setMessage(value);
                }
                this.detailCase_ = 4;
                return this;
            }

            public Builder clearForceUpdate() {
                if (this.forceUpdateBuilder_ != null) {
                    if (this.detailCase_ == 4) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.forceUpdateBuilder_.clear();
                } else if (this.detailCase_ == 4) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public ForceUpdateInfoOuterClass.ForceUpdateInfo.Builder getForceUpdateBuilder() {
                return getForceUpdateFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
            public ForceUpdateInfoOuterClass.ForceUpdateInfoOrBuilder getForceUpdateOrBuilder() {
                if (this.detailCase_ == 4 && this.forceUpdateBuilder_ != null) {
                    return this.forceUpdateBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 4) {
                    return (ForceUpdateInfoOuterClass.ForceUpdateInfo) this.detail_;
                }
                return ForceUpdateInfoOuterClass.ForceUpdateInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ForceUpdateInfoOuterClass.ForceUpdateInfo, ForceUpdateInfoOuterClass.ForceUpdateInfo.Builder, ForceUpdateInfoOuterClass.ForceUpdateInfoOrBuilder> getForceUpdateFieldBuilder() {
                if (this.forceUpdateBuilder_ == null) {
                    if (this.detailCase_ != 4) {
                        this.detail_ = ForceUpdateInfoOuterClass.ForceUpdateInfo.getDefaultInstance();
                    }
                    this.forceUpdateBuilder_ = new SingleFieldBuilderV3<>((ForceUpdateInfoOuterClass.ForceUpdateInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 4;
                onChanged();
                return this.forceUpdateBuilder_;
            }

            @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
            public boolean hasStopServer() {
                return this.detailCase_ == 5;
            }

            @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
            public StopServerInfoOuterClass.StopServerInfo getStopServer() {
                if (this.stopServerBuilder_ == null) {
                    if (this.detailCase_ == 5) {
                        return (StopServerInfoOuterClass.StopServerInfo) this.detail_;
                    }
                    return StopServerInfoOuterClass.StopServerInfo.getDefaultInstance();
                } else if (this.detailCase_ == 5) {
                    return this.stopServerBuilder_.getMessage();
                } else {
                    return StopServerInfoOuterClass.StopServerInfo.getDefaultInstance();
                }
            }

            public Builder setStopServer(StopServerInfoOuterClass.StopServerInfo value) {
                if (this.stopServerBuilder_ != null) {
                    this.stopServerBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 5;
                return this;
            }

            public Builder setStopServer(StopServerInfoOuterClass.StopServerInfo.Builder builderForValue) {
                if (this.stopServerBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.stopServerBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 5;
                return this;
            }

            public Builder mergeStopServer(StopServerInfoOuterClass.StopServerInfo value) {
                if (this.stopServerBuilder_ == null) {
                    if (this.detailCase_ != 5 || this.detail_ == StopServerInfoOuterClass.StopServerInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = StopServerInfoOuterClass.StopServerInfo.newBuilder((StopServerInfoOuterClass.StopServerInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 5) {
                        this.stopServerBuilder_.mergeFrom(value);
                    }
                    this.stopServerBuilder_.setMessage(value);
                }
                this.detailCase_ = 5;
                return this;
            }

            public Builder clearStopServer() {
                if (this.stopServerBuilder_ != null) {
                    if (this.detailCase_ == 5) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.stopServerBuilder_.clear();
                } else if (this.detailCase_ == 5) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public StopServerInfoOuterClass.StopServerInfo.Builder getStopServerBuilder() {
                return getStopServerFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRspOrBuilder
            public StopServerInfoOuterClass.StopServerInfoOrBuilder getStopServerOrBuilder() {
                if (this.detailCase_ == 5 && this.stopServerBuilder_ != null) {
                    return this.stopServerBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 5) {
                    return (StopServerInfoOuterClass.StopServerInfo) this.detail_;
                }
                return StopServerInfoOuterClass.StopServerInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<StopServerInfoOuterClass.StopServerInfo, StopServerInfoOuterClass.StopServerInfo.Builder, StopServerInfoOuterClass.StopServerInfoOrBuilder> getStopServerFieldBuilder() {
                if (this.stopServerBuilder_ == null) {
                    if (this.detailCase_ != 5) {
                        this.detail_ = StopServerInfoOuterClass.StopServerInfo.getDefaultInstance();
                    }
                    this.stopServerBuilder_ = new SingleFieldBuilderV3<>((StopServerInfoOuterClass.StopServerInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 5;
                onChanged();
                return this.stopServerBuilder_;
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

        public static QueryCurrRegionHttpRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QueryCurrRegionHttpRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QueryCurrRegionHttpRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QueryCurrRegionHttpRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ForceUpdateInfoOuterClass.getDescriptor();
        RegionInfoOuterClass.getDescriptor();
        StopServerInfoOuterClass.getDescriptor();
    }
}
