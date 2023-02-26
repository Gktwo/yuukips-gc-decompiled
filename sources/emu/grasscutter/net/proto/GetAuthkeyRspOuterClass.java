package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAuthkeyRspOuterClass.class */
public final class GetAuthkeyRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013GetAuthkeyRsp.proto\"{\n\rGetAuthkeyRsp\u0012\u000f\n\u0007gameBiz\u0018\u0001 \u0001(\t\u0012\u0010\n\bsignType\u0018\u0003 \u0001(\r\u0012\u0011\n\tauthAppid\u0018\u000b \u0001(\t\u0012\u0012\n\nauthkeyVer\u0018\u0007 \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u000e \u0001(\u0005\u0012\u000f\n\u0007authkey\u0018\t \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GetAuthkeyRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetAuthkeyRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetAuthkeyRsp_descriptor, new String[]{"GameBiz", "SignType", "AuthAppid", "AuthkeyVer", "Retcode", "Authkey"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAuthkeyRspOuterClass$GetAuthkeyRspOrBuilder.class */
    public interface GetAuthkeyRspOrBuilder extends MessageOrBuilder {
        String getGameBiz();

        ByteString getGameBizBytes();

        int getSignType();

        String getAuthAppid();

        ByteString getAuthAppidBytes();

        int getAuthkeyVer();

        int getRetcode();

        String getAuthkey();

        ByteString getAuthkeyBytes();
    }

    private GetAuthkeyRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAuthkeyRspOuterClass$GetAuthkeyRsp.class */
    public static final class GetAuthkeyRsp extends GeneratedMessageV3 implements GetAuthkeyRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GAMEBIZ_FIELD_NUMBER = 1;
        private volatile Object gameBiz_;
        public static final int SIGNTYPE_FIELD_NUMBER = 3;
        private int signType_;
        public static final int AUTHAPPID_FIELD_NUMBER = 11;
        private volatile Object authAppid_;
        public static final int AUTHKEYVER_FIELD_NUMBER = 7;
        private int authkeyVer_;
        public static final int RETCODE_FIELD_NUMBER = 14;
        private int retcode_;
        public static final int AUTHKEY_FIELD_NUMBER = 9;
        private volatile Object authkey_;
        private byte memoizedIsInitialized;
        private static final GetAuthkeyRsp DEFAULT_INSTANCE = new GetAuthkeyRsp();
        private static final Parser<GetAuthkeyRsp> PARSER = new AbstractParser<GetAuthkeyRsp>() { // from class: emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRsp.1
            @Override // com.google.protobuf.Parser
            public GetAuthkeyRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetAuthkeyRsp(input, extensionRegistry);
            }
        };

        private GetAuthkeyRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetAuthkeyRsp() {
            this.memoizedIsInitialized = -1;
            this.gameBiz_ = "";
            this.authAppid_ = "";
            this.authkey_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetAuthkeyRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetAuthkeyRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.gameBiz_ = input.readStringRequireUtf8();
                                break;
                            case 24:
                                this.signType_ = input.readUInt32();
                                break;
                            case 56:
                                this.authkeyVer_ = input.readUInt32();
                                break;
                            case 74:
                                this.authkey_ = input.readStringRequireUtf8();
                                break;
                            case 90:
                                this.authAppid_ = input.readStringRequireUtf8();
                                break;
                            case 112:
                                this.retcode_ = input.readInt32();
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
            return GetAuthkeyRspOuterClass.internal_static_GetAuthkeyRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetAuthkeyRspOuterClass.internal_static_GetAuthkeyRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAuthkeyRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
        public String getGameBiz() {
            Object ref = this.gameBiz_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gameBiz_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
        public ByteString getGameBizBytes() {
            Object ref = this.gameBiz_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gameBiz_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
        public int getSignType() {
            return this.signType_;
        }

        @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
        public String getAuthAppid() {
            Object ref = this.authAppid_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.authAppid_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
        public ByteString getAuthAppidBytes() {
            Object ref = this.authAppid_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.authAppid_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
        public int getAuthkeyVer() {
            return this.authkeyVer_;
        }

        @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
        public String getAuthkey() {
            Object ref = this.authkey_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.authkey_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
        public ByteString getAuthkeyBytes() {
            Object ref = this.authkey_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.authkey_ = b;
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
            if (!GeneratedMessageV3.isStringEmpty(this.gameBiz_)) {
                GeneratedMessageV3.writeString(output, 1, this.gameBiz_);
            }
            if (this.signType_ != 0) {
                output.writeUInt32(3, this.signType_);
            }
            if (this.authkeyVer_ != 0) {
                output.writeUInt32(7, this.authkeyVer_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.authkey_)) {
                GeneratedMessageV3.writeString(output, 9, this.authkey_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.authAppid_)) {
                GeneratedMessageV3.writeString(output, 11, this.authAppid_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(14, this.retcode_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.gameBiz_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(1, this.gameBiz_);
            }
            if (this.signType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.signType_);
            }
            if (this.authkeyVer_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.authkeyVer_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.authkey_)) {
                size2 += GeneratedMessageV3.computeStringSize(9, this.authkey_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.authAppid_)) {
                size2 += GeneratedMessageV3.computeStringSize(11, this.authAppid_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(14, this.retcode_);
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
            if (!(obj instanceof GetAuthkeyRsp)) {
                return equals(obj);
            }
            GetAuthkeyRsp other = (GetAuthkeyRsp) obj;
            return getGameBiz().equals(other.getGameBiz()) && getSignType() == other.getSignType() && getAuthAppid().equals(other.getAuthAppid()) && getAuthkeyVer() == other.getAuthkeyVer() && getRetcode() == other.getRetcode() && getAuthkey().equals(other.getAuthkey()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getGameBiz().hashCode())) + 3)) + getSignType())) + 11)) + getAuthAppid().hashCode())) + 7)) + getAuthkeyVer())) + 14)) + getRetcode())) + 9)) + getAuthkey().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static GetAuthkeyRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetAuthkeyRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAuthkeyRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetAuthkeyRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAuthkeyRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetAuthkeyRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAuthkeyRsp parseFrom(InputStream input) throws IOException {
            return (GetAuthkeyRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetAuthkeyRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAuthkeyRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetAuthkeyRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetAuthkeyRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetAuthkeyRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAuthkeyRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetAuthkeyRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetAuthkeyRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetAuthkeyRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAuthkeyRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetAuthkeyRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAuthkeyRspOuterClass$GetAuthkeyRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetAuthkeyRspOrBuilder {
            private int signType_;
            private int authkeyVer_;
            private int retcode_;
            private Object gameBiz_ = "";
            private Object authAppid_ = "";
            private Object authkey_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return GetAuthkeyRspOuterClass.internal_static_GetAuthkeyRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetAuthkeyRspOuterClass.internal_static_GetAuthkeyRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAuthkeyRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetAuthkeyRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.gameBiz_ = "";
                this.signType_ = 0;
                this.authAppid_ = "";
                this.authkeyVer_ = 0;
                this.retcode_ = 0;
                this.authkey_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetAuthkeyRspOuterClass.internal_static_GetAuthkeyRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetAuthkeyRsp getDefaultInstanceForType() {
                return GetAuthkeyRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetAuthkeyRsp build() {
                GetAuthkeyRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetAuthkeyRsp buildPartial() {
                GetAuthkeyRsp result = new GetAuthkeyRsp(this);
                result.gameBiz_ = this.gameBiz_;
                result.signType_ = this.signType_;
                result.authAppid_ = this.authAppid_;
                result.authkeyVer_ = this.authkeyVer_;
                result.retcode_ = this.retcode_;
                result.authkey_ = this.authkey_;
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
                if (other instanceof GetAuthkeyRsp) {
                    return mergeFrom((GetAuthkeyRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetAuthkeyRsp other) {
                if (other == GetAuthkeyRsp.getDefaultInstance()) {
                    return this;
                }
                if (!other.getGameBiz().isEmpty()) {
                    this.gameBiz_ = other.gameBiz_;
                    onChanged();
                }
                if (other.getSignType() != 0) {
                    setSignType(other.getSignType());
                }
                if (!other.getAuthAppid().isEmpty()) {
                    this.authAppid_ = other.authAppid_;
                    onChanged();
                }
                if (other.getAuthkeyVer() != 0) {
                    setAuthkeyVer(other.getAuthkeyVer());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (!other.getAuthkey().isEmpty()) {
                    this.authkey_ = other.authkey_;
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
                GetAuthkeyRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetAuthkeyRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetAuthkeyRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
            public String getGameBiz() {
                Object ref = this.gameBiz_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gameBiz_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
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
                this.gameBiz_ = GetAuthkeyRsp.getDefaultInstance().getGameBiz();
                onChanged();
                return this;
            }

            public Builder setGameBizBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetAuthkeyRsp.checkByteStringIsUtf8(value);
                this.gameBiz_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
            public int getSignType() {
                return this.signType_;
            }

            public Builder setSignType(int value) {
                this.signType_ = value;
                onChanged();
                return this;
            }

            public Builder clearSignType() {
                this.signType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
            public String getAuthAppid() {
                Object ref = this.authAppid_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.authAppid_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
            public ByteString getAuthAppidBytes() {
                Object ref = this.authAppid_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.authAppid_ = b;
                return b;
            }

            public Builder setAuthAppid(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.authAppid_ = value;
                onChanged();
                return this;
            }

            public Builder clearAuthAppid() {
                this.authAppid_ = GetAuthkeyRsp.getDefaultInstance().getAuthAppid();
                onChanged();
                return this;
            }

            public Builder setAuthAppidBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetAuthkeyRsp.checkByteStringIsUtf8(value);
                this.authAppid_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
            public int getAuthkeyVer() {
                return this.authkeyVer_;
            }

            public Builder setAuthkeyVer(int value) {
                this.authkeyVer_ = value;
                onChanged();
                return this;
            }

            public Builder clearAuthkeyVer() {
                this.authkeyVer_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
            public String getAuthkey() {
                Object ref = this.authkey_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.authkey_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetAuthkeyRspOuterClass.GetAuthkeyRspOrBuilder
            public ByteString getAuthkeyBytes() {
                Object ref = this.authkey_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.authkey_ = b;
                return b;
            }

            public Builder setAuthkey(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.authkey_ = value;
                onChanged();
                return this;
            }

            public Builder clearAuthkey() {
                this.authkey_ = GetAuthkeyRsp.getDefaultInstance().getAuthkey();
                onChanged();
                return this;
            }

            public Builder setAuthkeyBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetAuthkeyRsp.checkByteStringIsUtf8(value);
                this.authkey_ = value;
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

        public static GetAuthkeyRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetAuthkeyRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetAuthkeyRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetAuthkeyRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
