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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAuthkeyReqOuterClass.class */
public final class GetAuthkeyReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013GetAuthkeyReq.proto\"H\n\rGetAuthkeyReq\u0012\u0012\n\nauthkeyVer\u0018\u0006 \u0001(\r\u0012\u0011\n\tauthAppid\u0018\u000e \u0001(\t\u0012\u0010\n\bsignType\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GetAuthkeyReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetAuthkeyReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetAuthkeyReq_descriptor, new String[]{"AuthkeyVer", "AuthAppid", "SignType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAuthkeyReqOuterClass$GetAuthkeyReqOrBuilder.class */
    public interface GetAuthkeyReqOrBuilder extends MessageOrBuilder {
        int getAuthkeyVer();

        String getAuthAppid();

        ByteString getAuthAppidBytes();

        int getSignType();
    }

    private GetAuthkeyReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAuthkeyReqOuterClass$GetAuthkeyReq.class */
    public static final class GetAuthkeyReq extends GeneratedMessageV3 implements GetAuthkeyReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AUTHKEYVER_FIELD_NUMBER = 6;
        private int authkeyVer_;
        public static final int AUTHAPPID_FIELD_NUMBER = 14;
        private volatile Object authAppid_;
        public static final int SIGNTYPE_FIELD_NUMBER = 8;
        private int signType_;
        private byte memoizedIsInitialized;
        private static final GetAuthkeyReq DEFAULT_INSTANCE = new GetAuthkeyReq();
        private static final Parser<GetAuthkeyReq> PARSER = new AbstractParser<GetAuthkeyReq>() { // from class: emu.grasscutter.net.proto.GetAuthkeyReqOuterClass.GetAuthkeyReq.1
            @Override // com.google.protobuf.Parser
            public GetAuthkeyReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetAuthkeyReq(input, extensionRegistry);
            }
        };

        private GetAuthkeyReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetAuthkeyReq() {
            this.memoizedIsInitialized = -1;
            this.authAppid_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetAuthkeyReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetAuthkeyReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 48:
                                this.authkeyVer_ = input.readUInt32();
                                break;
                            case 64:
                                this.signType_ = input.readUInt32();
                                break;
                            case 114:
                                this.authAppid_ = input.readStringRequireUtf8();
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
            return GetAuthkeyReqOuterClass.internal_static_GetAuthkeyReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetAuthkeyReqOuterClass.internal_static_GetAuthkeyReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAuthkeyReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetAuthkeyReqOuterClass.GetAuthkeyReqOrBuilder
        public int getAuthkeyVer() {
            return this.authkeyVer_;
        }

        @Override // emu.grasscutter.net.proto.GetAuthkeyReqOuterClass.GetAuthkeyReqOrBuilder
        public String getAuthAppid() {
            Object ref = this.authAppid_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.authAppid_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GetAuthkeyReqOuterClass.GetAuthkeyReqOrBuilder
        public ByteString getAuthAppidBytes() {
            Object ref = this.authAppid_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.authAppid_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GetAuthkeyReqOuterClass.GetAuthkeyReqOrBuilder
        public int getSignType() {
            return this.signType_;
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
            if (this.authkeyVer_ != 0) {
                output.writeUInt32(6, this.authkeyVer_);
            }
            if (this.signType_ != 0) {
                output.writeUInt32(8, this.signType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.authAppid_)) {
                GeneratedMessageV3.writeString(output, 14, this.authAppid_);
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
            if (this.authkeyVer_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.authkeyVer_);
            }
            if (this.signType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.signType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.authAppid_)) {
                size2 += GeneratedMessageV3.computeStringSize(14, this.authAppid_);
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
            if (!(obj instanceof GetAuthkeyReq)) {
                return equals(obj);
            }
            GetAuthkeyReq other = (GetAuthkeyReq) obj;
            return getAuthkeyVer() == other.getAuthkeyVer() && getAuthAppid().equals(other.getAuthAppid()) && getSignType() == other.getSignType() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getAuthkeyVer())) + 14)) + getAuthAppid().hashCode())) + 8)) + getSignType())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static GetAuthkeyReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetAuthkeyReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAuthkeyReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetAuthkeyReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAuthkeyReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetAuthkeyReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAuthkeyReq parseFrom(InputStream input) throws IOException {
            return (GetAuthkeyReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetAuthkeyReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAuthkeyReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetAuthkeyReq parseDelimitedFrom(InputStream input) throws IOException {
            return (GetAuthkeyReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetAuthkeyReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAuthkeyReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetAuthkeyReq parseFrom(CodedInputStream input) throws IOException {
            return (GetAuthkeyReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetAuthkeyReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAuthkeyReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetAuthkeyReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetAuthkeyReqOuterClass$GetAuthkeyReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetAuthkeyReqOrBuilder {
            private int authkeyVer_;
            private Object authAppid_ = "";
            private int signType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetAuthkeyReqOuterClass.internal_static_GetAuthkeyReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetAuthkeyReqOuterClass.internal_static_GetAuthkeyReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAuthkeyReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetAuthkeyReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.authkeyVer_ = 0;
                this.authAppid_ = "";
                this.signType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetAuthkeyReqOuterClass.internal_static_GetAuthkeyReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetAuthkeyReq getDefaultInstanceForType() {
                return GetAuthkeyReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetAuthkeyReq build() {
                GetAuthkeyReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetAuthkeyReq buildPartial() {
                GetAuthkeyReq result = new GetAuthkeyReq(this);
                result.authkeyVer_ = this.authkeyVer_;
                result.authAppid_ = this.authAppid_;
                result.signType_ = this.signType_;
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
                if (other instanceof GetAuthkeyReq) {
                    return mergeFrom((GetAuthkeyReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetAuthkeyReq other) {
                if (other == GetAuthkeyReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getAuthkeyVer() != 0) {
                    setAuthkeyVer(other.getAuthkeyVer());
                }
                if (!other.getAuthAppid().isEmpty()) {
                    this.authAppid_ = other.authAppid_;
                    onChanged();
                }
                if (other.getSignType() != 0) {
                    setSignType(other.getSignType());
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
                GetAuthkeyReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetAuthkeyReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetAuthkeyReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetAuthkeyReqOuterClass.GetAuthkeyReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetAuthkeyReqOuterClass.GetAuthkeyReqOrBuilder
            public String getAuthAppid() {
                Object ref = this.authAppid_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.authAppid_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GetAuthkeyReqOuterClass.GetAuthkeyReqOrBuilder
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
                this.authAppid_ = GetAuthkeyReq.getDefaultInstance().getAuthAppid();
                onChanged();
                return this;
            }

            public Builder setAuthAppidBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GetAuthkeyReq.checkByteStringIsUtf8(value);
                this.authAppid_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetAuthkeyReqOuterClass.GetAuthkeyReqOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static GetAuthkeyReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetAuthkeyReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetAuthkeyReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetAuthkeyReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
