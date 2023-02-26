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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetPlayerNameRspOuterClass.class */
public final class SetPlayerNameRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016SetPlayerNameRsp.proto\"5\n\u0010SetPlayerNameRsp\u0012\u000f\n\u0007retcode\u0018\u000b \u0001(\u0005\u0012\u0010\n\bnickName\u0018\r \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SetPlayerNameRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SetPlayerNameRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SetPlayerNameRsp_descriptor, new String[]{"Retcode", "NickName"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetPlayerNameRspOuterClass$SetPlayerNameRspOrBuilder.class */
    public interface SetPlayerNameRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        String getNickName();

        ByteString getNickNameBytes();
    }

    private SetPlayerNameRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetPlayerNameRspOuterClass$SetPlayerNameRsp.class */
    public static final class SetPlayerNameRsp extends GeneratedMessageV3 implements SetPlayerNameRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 11;
        private int retcode_;
        public static final int NICKNAME_FIELD_NUMBER = 13;
        private volatile Object nickName_;
        private byte memoizedIsInitialized;
        private static final SetPlayerNameRsp DEFAULT_INSTANCE = new SetPlayerNameRsp();
        private static final Parser<SetPlayerNameRsp> PARSER = new AbstractParser<SetPlayerNameRsp>() { // from class: emu.grasscutter.net.proto.SetPlayerNameRspOuterClass.SetPlayerNameRsp.1
            @Override // com.google.protobuf.Parser
            public SetPlayerNameRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SetPlayerNameRsp(input, extensionRegistry);
            }
        };

        private SetPlayerNameRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SetPlayerNameRsp() {
            this.memoizedIsInitialized = -1;
            this.nickName_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SetPlayerNameRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SetPlayerNameRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 88:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 106:
                                    this.nickName_ = input.readStringRequireUtf8();
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
            return SetPlayerNameRspOuterClass.internal_static_SetPlayerNameRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SetPlayerNameRspOuterClass.internal_static_SetPlayerNameRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SetPlayerNameRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SetPlayerNameRspOuterClass.SetPlayerNameRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.SetPlayerNameRspOuterClass.SetPlayerNameRspOrBuilder
        public String getNickName() {
            Object ref = this.nickName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.nickName_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.SetPlayerNameRspOuterClass.SetPlayerNameRspOrBuilder
        public ByteString getNickNameBytes() {
            Object ref = this.nickName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.nickName_ = b;
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
            if (this.retcode_ != 0) {
                output.writeInt32(11, this.retcode_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.nickName_)) {
                GeneratedMessageV3.writeString(output, 13, this.nickName_);
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
                size2 = 0 + CodedOutputStream.computeInt32Size(11, this.retcode_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.nickName_)) {
                size2 += GeneratedMessageV3.computeStringSize(13, this.nickName_);
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
            if (!(obj instanceof SetPlayerNameRsp)) {
                return equals(obj);
            }
            SetPlayerNameRsp other = (SetPlayerNameRsp) obj;
            return getRetcode() == other.getRetcode() && getNickName().equals(other.getNickName()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getRetcode())) + 13)) + getNickName().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SetPlayerNameRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetPlayerNameRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetPlayerNameRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetPlayerNameRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetPlayerNameRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetPlayerNameRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetPlayerNameRsp parseFrom(InputStream input) throws IOException {
            return (SetPlayerNameRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetPlayerNameRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetPlayerNameRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetPlayerNameRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (SetPlayerNameRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SetPlayerNameRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetPlayerNameRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetPlayerNameRsp parseFrom(CodedInputStream input) throws IOException {
            return (SetPlayerNameRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetPlayerNameRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetPlayerNameRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SetPlayerNameRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetPlayerNameRspOuterClass$SetPlayerNameRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SetPlayerNameRspOrBuilder {
            private int retcode_;
            private Object nickName_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return SetPlayerNameRspOuterClass.internal_static_SetPlayerNameRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SetPlayerNameRspOuterClass.internal_static_SetPlayerNameRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SetPlayerNameRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SetPlayerNameRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.nickName_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SetPlayerNameRspOuterClass.internal_static_SetPlayerNameRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SetPlayerNameRsp getDefaultInstanceForType() {
                return SetPlayerNameRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetPlayerNameRsp build() {
                SetPlayerNameRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetPlayerNameRsp buildPartial() {
                SetPlayerNameRsp result = new SetPlayerNameRsp(this);
                result.retcode_ = this.retcode_;
                result.nickName_ = this.nickName_;
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
                if (other instanceof SetPlayerNameRsp) {
                    return mergeFrom((SetPlayerNameRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SetPlayerNameRsp other) {
                if (other == SetPlayerNameRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (!other.getNickName().isEmpty()) {
                    this.nickName_ = other.nickName_;
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
                SetPlayerNameRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = SetPlayerNameRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SetPlayerNameRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SetPlayerNameRspOuterClass.SetPlayerNameRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.SetPlayerNameRspOuterClass.SetPlayerNameRspOrBuilder
            public String getNickName() {
                Object ref = this.nickName_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.nickName_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.SetPlayerNameRspOuterClass.SetPlayerNameRspOrBuilder
            public ByteString getNickNameBytes() {
                Object ref = this.nickName_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.nickName_ = b;
                return b;
            }

            public Builder setNickName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.nickName_ = value;
                onChanged();
                return this;
            }

            public Builder clearNickName() {
                this.nickName_ = SetPlayerNameRsp.getDefaultInstance().getNickName();
                onChanged();
                return this;
            }

            public Builder setNickNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                SetPlayerNameRsp.checkByteStringIsUtf8(value);
                this.nickName_ = value;
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

        public static SetPlayerNameRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SetPlayerNameRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SetPlayerNameRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SetPlayerNameRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
