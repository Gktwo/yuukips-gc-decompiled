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
import javassist.bytecode.SignatureAttribute;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetPlayerSignatureRspOuterClass.class */
public final class SetPlayerSignatureRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bSetPlayerSignatureRsp.proto\";\n\u0015SetPlayerSignatureRsp\u0012\u000f\n\u0007retcode\u0018\u0006 \u0001(\u0005\u0012\u0011\n\tsignature\u0018\f \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SetPlayerSignatureRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SetPlayerSignatureRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SetPlayerSignatureRsp_descriptor, new String[]{"Retcode", SignatureAttribute.tag});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetPlayerSignatureRspOuterClass$SetPlayerSignatureRspOrBuilder.class */
    public interface SetPlayerSignatureRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        String getSignature();

        ByteString getSignatureBytes();
    }

    private SetPlayerSignatureRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetPlayerSignatureRspOuterClass$SetPlayerSignatureRsp.class */
    public static final class SetPlayerSignatureRsp extends GeneratedMessageV3 implements SetPlayerSignatureRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 6;
        private int retcode_;
        public static final int SIGNATURE_FIELD_NUMBER = 12;
        private volatile Object signature_;
        private byte memoizedIsInitialized;
        private static final SetPlayerSignatureRsp DEFAULT_INSTANCE = new SetPlayerSignatureRsp();
        private static final Parser<SetPlayerSignatureRsp> PARSER = new AbstractParser<SetPlayerSignatureRsp>() { // from class: emu.grasscutter.net.proto.SetPlayerSignatureRspOuterClass.SetPlayerSignatureRsp.1
            @Override // com.google.protobuf.Parser
            public SetPlayerSignatureRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SetPlayerSignatureRsp(input, extensionRegistry);
            }
        };

        private SetPlayerSignatureRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SetPlayerSignatureRsp() {
            this.memoizedIsInitialized = -1;
            this.signature_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SetPlayerSignatureRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SetPlayerSignatureRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 48:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 98:
                                    this.signature_ = input.readStringRequireUtf8();
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
            return SetPlayerSignatureRspOuterClass.internal_static_SetPlayerSignatureRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SetPlayerSignatureRspOuterClass.internal_static_SetPlayerSignatureRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SetPlayerSignatureRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SetPlayerSignatureRspOuterClass.SetPlayerSignatureRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.SetPlayerSignatureRspOuterClass.SetPlayerSignatureRspOrBuilder
        public String getSignature() {
            Object ref = this.signature_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.signature_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.SetPlayerSignatureRspOuterClass.SetPlayerSignatureRspOrBuilder
        public ByteString getSignatureBytes() {
            Object ref = this.signature_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.signature_ = b;
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
                output.writeInt32(6, this.retcode_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.signature_)) {
                GeneratedMessageV3.writeString(output, 12, this.signature_);
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
                size2 = 0 + CodedOutputStream.computeInt32Size(6, this.retcode_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.signature_)) {
                size2 += GeneratedMessageV3.computeStringSize(12, this.signature_);
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
            if (!(obj instanceof SetPlayerSignatureRsp)) {
                return equals(obj);
            }
            SetPlayerSignatureRsp other = (SetPlayerSignatureRsp) obj;
            return getRetcode() == other.getRetcode() && getSignature().equals(other.getSignature()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getRetcode())) + 12)) + getSignature().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SetPlayerSignatureRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetPlayerSignatureRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetPlayerSignatureRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetPlayerSignatureRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetPlayerSignatureRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetPlayerSignatureRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetPlayerSignatureRsp parseFrom(InputStream input) throws IOException {
            return (SetPlayerSignatureRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetPlayerSignatureRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetPlayerSignatureRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetPlayerSignatureRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (SetPlayerSignatureRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SetPlayerSignatureRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetPlayerSignatureRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetPlayerSignatureRsp parseFrom(CodedInputStream input) throws IOException {
            return (SetPlayerSignatureRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetPlayerSignatureRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetPlayerSignatureRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SetPlayerSignatureRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetPlayerSignatureRspOuterClass$SetPlayerSignatureRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SetPlayerSignatureRspOrBuilder {
            private int retcode_;
            private Object signature_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return SetPlayerSignatureRspOuterClass.internal_static_SetPlayerSignatureRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SetPlayerSignatureRspOuterClass.internal_static_SetPlayerSignatureRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SetPlayerSignatureRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SetPlayerSignatureRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.signature_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SetPlayerSignatureRspOuterClass.internal_static_SetPlayerSignatureRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SetPlayerSignatureRsp getDefaultInstanceForType() {
                return SetPlayerSignatureRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetPlayerSignatureRsp build() {
                SetPlayerSignatureRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetPlayerSignatureRsp buildPartial() {
                SetPlayerSignatureRsp result = new SetPlayerSignatureRsp(this);
                result.retcode_ = this.retcode_;
                result.signature_ = this.signature_;
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
                if (other instanceof SetPlayerSignatureRsp) {
                    return mergeFrom((SetPlayerSignatureRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SetPlayerSignatureRsp other) {
                if (other == SetPlayerSignatureRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (!other.getSignature().isEmpty()) {
                    this.signature_ = other.signature_;
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
                SetPlayerSignatureRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = SetPlayerSignatureRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SetPlayerSignatureRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SetPlayerSignatureRspOuterClass.SetPlayerSignatureRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.SetPlayerSignatureRspOuterClass.SetPlayerSignatureRspOrBuilder
            public String getSignature() {
                Object ref = this.signature_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.signature_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.SetPlayerSignatureRspOuterClass.SetPlayerSignatureRspOrBuilder
            public ByteString getSignatureBytes() {
                Object ref = this.signature_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.signature_ = b;
                return b;
            }

            public Builder setSignature(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.signature_ = value;
                onChanged();
                return this;
            }

            public Builder clearSignature() {
                this.signature_ = SetPlayerSignatureRsp.getDefaultInstance().getSignature();
                onChanged();
                return this;
            }

            public Builder setSignatureBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                SetPlayerSignatureRsp.checkByteStringIsUtf8(value);
                this.signature_ = value;
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

        public static SetPlayerSignatureRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SetPlayerSignatureRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SetPlayerSignatureRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SetPlayerSignatureRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
