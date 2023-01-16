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
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.RegionSimpleInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryRegionListHttpRspOuterClass.class */
public final class QueryRegionListHttpRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cQueryRegionListHttpRsp.proto\u001a\u0016RegionSimpleInfo.proto\"­\u0001\n\u0016QueryRegionListHttpRsp\u0012\u000f\n\u0007retcode\u0018\u0001 \u0001(\u0005\u0012&\n\u000bregion_list\u0018\u0002 \u0003(\u000b2\u0011.RegionSimpleInfo\u0012\u0019\n\u0011client_secret_key\u0018\u0005 \u0001(\f\u0012&\n\u001eclient_custom_config_encrypted\u0018\u0006 \u0001(\f\u0012\u0017\n\u000fenable_login_pc\u0018\u0007 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{RegionSimpleInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_QueryRegionListHttpRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QueryRegionListHttpRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QueryRegionListHttpRsp_descriptor, new String[]{"Retcode", "RegionList", "ClientSecretKey", "ClientCustomConfigEncrypted", "EnableLoginPc"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryRegionListHttpRspOuterClass$QueryRegionListHttpRspOrBuilder.class */
    public interface QueryRegionListHttpRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        List<RegionSimpleInfoOuterClass.RegionSimpleInfo> getRegionListList();

        RegionSimpleInfoOuterClass.RegionSimpleInfo getRegionList(int i);

        int getRegionListCount();

        List<? extends RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder> getRegionListOrBuilderList();

        RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder getRegionListOrBuilder(int i);

        ByteString getClientSecretKey();

        ByteString getClientCustomConfigEncrypted();

        boolean getEnableLoginPc();
    }

    private QueryRegionListHttpRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryRegionListHttpRspOuterClass$QueryRegionListHttpRsp.class */
    public static final class QueryRegionListHttpRsp extends GeneratedMessageV3 implements QueryRegionListHttpRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 1;
        private int retcode_;
        public static final int REGION_LIST_FIELD_NUMBER = 2;
        private List<RegionSimpleInfoOuterClass.RegionSimpleInfo> regionList_;
        public static final int CLIENT_SECRET_KEY_FIELD_NUMBER = 5;
        private ByteString clientSecretKey_;
        public static final int CLIENT_CUSTOM_CONFIG_ENCRYPTED_FIELD_NUMBER = 6;
        private ByteString clientCustomConfigEncrypted_;
        public static final int ENABLE_LOGIN_PC_FIELD_NUMBER = 7;
        private boolean enableLoginPc_;
        private byte memoizedIsInitialized;
        private static final QueryRegionListHttpRsp DEFAULT_INSTANCE = new QueryRegionListHttpRsp();
        private static final Parser<QueryRegionListHttpRsp> PARSER = new AbstractParser<QueryRegionListHttpRsp>() { // from class: emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRsp.1
            @Override // com.google.protobuf.Parser
            public QueryRegionListHttpRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QueryRegionListHttpRsp(input, extensionRegistry);
            }
        };

        private QueryRegionListHttpRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private QueryRegionListHttpRsp() {
            this.memoizedIsInitialized = -1;
            this.regionList_ = Collections.emptyList();
            this.clientSecretKey_ = ByteString.EMPTY;
            this.clientCustomConfigEncrypted_ = ByteString.EMPTY;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QueryRegionListHttpRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QueryRegionListHttpRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.retcode_ = input.readInt32();
                                break;
                            case 18:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.regionList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.regionList_.add((RegionSimpleInfoOuterClass.RegionSimpleInfo) input.readMessage(RegionSimpleInfoOuterClass.RegionSimpleInfo.parser(), extensionRegistry));
                                break;
                            case 42:
                                this.clientSecretKey_ = input.readBytes();
                                break;
                            case 50:
                                this.clientCustomConfigEncrypted_ = input.readBytes();
                                break;
                            case 56:
                                this.enableLoginPc_ = input.readBool();
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
                    this.regionList_ = Collections.unmodifiableList(this.regionList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QueryRegionListHttpRspOuterClass.internal_static_QueryRegionListHttpRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QueryRegionListHttpRspOuterClass.internal_static_QueryRegionListHttpRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryRegionListHttpRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
        public List<RegionSimpleInfoOuterClass.RegionSimpleInfo> getRegionListList() {
            return this.regionList_;
        }

        @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
        public List<? extends RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder> getRegionListOrBuilderList() {
            return this.regionList_;
        }

        @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
        public int getRegionListCount() {
            return this.regionList_.size();
        }

        @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
        public RegionSimpleInfoOuterClass.RegionSimpleInfo getRegionList(int index) {
            return this.regionList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
        public RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder getRegionListOrBuilder(int index) {
            return this.regionList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
        public ByteString getClientSecretKey() {
            return this.clientSecretKey_;
        }

        @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
        public ByteString getClientCustomConfigEncrypted() {
            return this.clientCustomConfigEncrypted_;
        }

        @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
        public boolean getEnableLoginPc() {
            return this.enableLoginPc_;
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
            for (int i = 0; i < this.regionList_.size(); i++) {
                output.writeMessage(2, this.regionList_.get(i));
            }
            if (!this.clientSecretKey_.isEmpty()) {
                output.writeBytes(5, this.clientSecretKey_);
            }
            if (!this.clientCustomConfigEncrypted_.isEmpty()) {
                output.writeBytes(6, this.clientCustomConfigEncrypted_);
            }
            if (this.enableLoginPc_) {
                output.writeBool(7, this.enableLoginPc_);
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
            for (int i = 0; i < this.regionList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.regionList_.get(i));
            }
            if (!this.clientSecretKey_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(5, this.clientSecretKey_);
            }
            if (!this.clientCustomConfigEncrypted_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(6, this.clientCustomConfigEncrypted_);
            }
            if (this.enableLoginPc_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.enableLoginPc_);
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
            if (!(obj instanceof QueryRegionListHttpRsp)) {
                return equals(obj);
            }
            QueryRegionListHttpRsp other = (QueryRegionListHttpRsp) obj;
            return getRetcode() == other.getRetcode() && getRegionListList().equals(other.getRegionListList()) && getClientSecretKey().equals(other.getClientSecretKey()) && getClientCustomConfigEncrypted().equals(other.getClientCustomConfigEncrypted()) && getEnableLoginPc() == other.getEnableLoginPc() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getRetcode();
            if (getRegionListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getRegionListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 5)) + getClientSecretKey().hashCode())) + 6)) + getClientCustomConfigEncrypted().hashCode())) + 7)) + Internal.hashBoolean(getEnableLoginPc()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static QueryRegionListHttpRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryRegionListHttpRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryRegionListHttpRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryRegionListHttpRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryRegionListHttpRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryRegionListHttpRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryRegionListHttpRsp parseFrom(InputStream input) throws IOException {
            return (QueryRegionListHttpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QueryRegionListHttpRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryRegionListHttpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QueryRegionListHttpRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (QueryRegionListHttpRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QueryRegionListHttpRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryRegionListHttpRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QueryRegionListHttpRsp parseFrom(CodedInputStream input) throws IOException {
            return (QueryRegionListHttpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QueryRegionListHttpRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryRegionListHttpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QueryRegionListHttpRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryRegionListHttpRspOuterClass$QueryRegionListHttpRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QueryRegionListHttpRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private RepeatedFieldBuilderV3<RegionSimpleInfoOuterClass.RegionSimpleInfo, RegionSimpleInfoOuterClass.RegionSimpleInfo.Builder, RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder> regionListBuilder_;
            private boolean enableLoginPc_;
            private List<RegionSimpleInfoOuterClass.RegionSimpleInfo> regionList_ = Collections.emptyList();
            private ByteString clientSecretKey_ = ByteString.EMPTY;
            private ByteString clientCustomConfigEncrypted_ = ByteString.EMPTY;

            public static final Descriptors.Descriptor getDescriptor() {
                return QueryRegionListHttpRspOuterClass.internal_static_QueryRegionListHttpRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QueryRegionListHttpRspOuterClass.internal_static_QueryRegionListHttpRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryRegionListHttpRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QueryRegionListHttpRsp.alwaysUseFieldBuilders) {
                    getRegionListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                if (this.regionListBuilder_ == null) {
                    this.regionList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.regionListBuilder_.clear();
                }
                this.clientSecretKey_ = ByteString.EMPTY;
                this.clientCustomConfigEncrypted_ = ByteString.EMPTY;
                this.enableLoginPc_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QueryRegionListHttpRspOuterClass.internal_static_QueryRegionListHttpRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QueryRegionListHttpRsp getDefaultInstanceForType() {
                return QueryRegionListHttpRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QueryRegionListHttpRsp build() {
                QueryRegionListHttpRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QueryRegionListHttpRsp buildPartial() {
                QueryRegionListHttpRsp result = new QueryRegionListHttpRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                if (this.regionListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.regionList_ = Collections.unmodifiableList(this.regionList_);
                        this.bitField0_ &= -2;
                    }
                    result.regionList_ = this.regionList_;
                } else {
                    result.regionList_ = this.regionListBuilder_.build();
                }
                result.clientSecretKey_ = this.clientSecretKey_;
                result.clientCustomConfigEncrypted_ = this.clientCustomConfigEncrypted_;
                result.enableLoginPc_ = this.enableLoginPc_;
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
                if (other instanceof QueryRegionListHttpRsp) {
                    return mergeFrom((QueryRegionListHttpRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QueryRegionListHttpRsp other) {
                if (other == QueryRegionListHttpRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.regionListBuilder_ == null) {
                    if (!other.regionList_.isEmpty()) {
                        if (this.regionList_.isEmpty()) {
                            this.regionList_ = other.regionList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureRegionListIsMutable();
                            this.regionList_.addAll(other.regionList_);
                        }
                        onChanged();
                    }
                } else if (!other.regionList_.isEmpty()) {
                    if (this.regionListBuilder_.isEmpty()) {
                        this.regionListBuilder_.dispose();
                        this.regionListBuilder_ = null;
                        this.regionList_ = other.regionList_;
                        this.bitField0_ &= -2;
                        this.regionListBuilder_ = QueryRegionListHttpRsp.alwaysUseFieldBuilders ? getRegionListFieldBuilder() : null;
                    } else {
                        this.regionListBuilder_.addAllMessages(other.regionList_);
                    }
                }
                if (other.getClientSecretKey() != ByteString.EMPTY) {
                    setClientSecretKey(other.getClientSecretKey());
                }
                if (other.getClientCustomConfigEncrypted() != ByteString.EMPTY) {
                    setClientCustomConfigEncrypted(other.getClientCustomConfigEncrypted());
                }
                if (other.getEnableLoginPc()) {
                    setEnableLoginPc(other.getEnableLoginPc());
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
                QueryRegionListHttpRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = QueryRegionListHttpRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QueryRegionListHttpRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
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

            private void ensureRegionListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.regionList_ = new ArrayList(this.regionList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
            public List<RegionSimpleInfoOuterClass.RegionSimpleInfo> getRegionListList() {
                if (this.regionListBuilder_ == null) {
                    return Collections.unmodifiableList(this.regionList_);
                }
                return this.regionListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
            public int getRegionListCount() {
                if (this.regionListBuilder_ == null) {
                    return this.regionList_.size();
                }
                return this.regionListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
            public RegionSimpleInfoOuterClass.RegionSimpleInfo getRegionList(int index) {
                if (this.regionListBuilder_ == null) {
                    return this.regionList_.get(index);
                }
                return this.regionListBuilder_.getMessage(index);
            }

            public Builder setRegionList(int index, RegionSimpleInfoOuterClass.RegionSimpleInfo value) {
                if (this.regionListBuilder_ != null) {
                    this.regionListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRegionListIsMutable();
                    this.regionList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setRegionList(int index, RegionSimpleInfoOuterClass.RegionSimpleInfo.Builder builderForValue) {
                if (this.regionListBuilder_ == null) {
                    ensureRegionListIsMutable();
                    this.regionList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.regionListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addRegionList(RegionSimpleInfoOuterClass.RegionSimpleInfo value) {
                if (this.regionListBuilder_ != null) {
                    this.regionListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRegionListIsMutable();
                    this.regionList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addRegionList(int index, RegionSimpleInfoOuterClass.RegionSimpleInfo value) {
                if (this.regionListBuilder_ != null) {
                    this.regionListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRegionListIsMutable();
                    this.regionList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addRegionList(RegionSimpleInfoOuterClass.RegionSimpleInfo.Builder builderForValue) {
                if (this.regionListBuilder_ == null) {
                    ensureRegionListIsMutable();
                    this.regionList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.regionListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addRegionList(int index, RegionSimpleInfoOuterClass.RegionSimpleInfo.Builder builderForValue) {
                if (this.regionListBuilder_ == null) {
                    ensureRegionListIsMutable();
                    this.regionList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.regionListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllRegionList(Iterable<? extends RegionSimpleInfoOuterClass.RegionSimpleInfo> values) {
                if (this.regionListBuilder_ == null) {
                    ensureRegionListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.regionList_);
                    onChanged();
                } else {
                    this.regionListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearRegionList() {
                if (this.regionListBuilder_ == null) {
                    this.regionList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.regionListBuilder_.clear();
                }
                return this;
            }

            public Builder removeRegionList(int index) {
                if (this.regionListBuilder_ == null) {
                    ensureRegionListIsMutable();
                    this.regionList_.remove(index);
                    onChanged();
                } else {
                    this.regionListBuilder_.remove(index);
                }
                return this;
            }

            public RegionSimpleInfoOuterClass.RegionSimpleInfo.Builder getRegionListBuilder(int index) {
                return getRegionListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
            public RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder getRegionListOrBuilder(int index) {
                if (this.regionListBuilder_ == null) {
                    return this.regionList_.get(index);
                }
                return this.regionListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
            public List<? extends RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder> getRegionListOrBuilderList() {
                if (this.regionListBuilder_ != null) {
                    return this.regionListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.regionList_);
            }

            public RegionSimpleInfoOuterClass.RegionSimpleInfo.Builder addRegionListBuilder() {
                return getRegionListFieldBuilder().addBuilder(RegionSimpleInfoOuterClass.RegionSimpleInfo.getDefaultInstance());
            }

            public RegionSimpleInfoOuterClass.RegionSimpleInfo.Builder addRegionListBuilder(int index) {
                return getRegionListFieldBuilder().addBuilder(index, RegionSimpleInfoOuterClass.RegionSimpleInfo.getDefaultInstance());
            }

            public List<RegionSimpleInfoOuterClass.RegionSimpleInfo.Builder> getRegionListBuilderList() {
                return getRegionListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<RegionSimpleInfoOuterClass.RegionSimpleInfo, RegionSimpleInfoOuterClass.RegionSimpleInfo.Builder, RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder> getRegionListFieldBuilder() {
                if (this.regionListBuilder_ == null) {
                    this.regionListBuilder_ = new RepeatedFieldBuilderV3<>(this.regionList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.regionList_ = null;
                }
                return this.regionListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
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
                this.clientSecretKey_ = QueryRegionListHttpRsp.getDefaultInstance().getClientSecretKey();
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
            public ByteString getClientCustomConfigEncrypted() {
                return this.clientCustomConfigEncrypted_;
            }

            public Builder setClientCustomConfigEncrypted(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientCustomConfigEncrypted_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientCustomConfigEncrypted() {
                this.clientCustomConfigEncrypted_ = QueryRegionListHttpRsp.getDefaultInstance().getClientCustomConfigEncrypted();
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRspOrBuilder
            public boolean getEnableLoginPc() {
                return this.enableLoginPc_;
            }

            public Builder setEnableLoginPc(boolean value) {
                this.enableLoginPc_ = value;
                onChanged();
                return this;
            }

            public Builder clearEnableLoginPc() {
                this.enableLoginPc_ = false;
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

        public static QueryRegionListHttpRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QueryRegionListHttpRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QueryRegionListHttpRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QueryRegionListHttpRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        RegionSimpleInfoOuterClass.getDescriptor();
    }
}
