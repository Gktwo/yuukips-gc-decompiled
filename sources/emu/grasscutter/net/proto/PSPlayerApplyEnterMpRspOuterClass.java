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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PSPlayerApplyEnterMpRspOuterClass.class */
public final class PSPlayerApplyEnterMpRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dPSPlayerApplyEnterMpRsp.proto\"P\n\u0017PSPlayerApplyEnterMpRsp\u0012\u0015\n\rtarget_psn_id\u0018\u0003 \u0001(\t\u0012\u000f\n\u0007retcode\u0018\u0005 \u0001(\u0005\u0012\r\n\u0005param\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PSPlayerApplyEnterMpRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PSPlayerApplyEnterMpRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PSPlayerApplyEnterMpRsp_descriptor, new String[]{"TargetPsnId", "Retcode", "Param"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PSPlayerApplyEnterMpRspOuterClass$PSPlayerApplyEnterMpRspOrBuilder.class */
    public interface PSPlayerApplyEnterMpRspOrBuilder extends MessageOrBuilder {
        String getTargetPsnId();

        ByteString getTargetPsnIdBytes();

        int getRetcode();

        int getParam();
    }

    private PSPlayerApplyEnterMpRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PSPlayerApplyEnterMpRspOuterClass$PSPlayerApplyEnterMpRsp.class */
    public static final class PSPlayerApplyEnterMpRsp extends GeneratedMessageV3 implements PSPlayerApplyEnterMpRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TARGET_PSN_ID_FIELD_NUMBER = 3;
        private volatile Object targetPsnId_;
        public static final int RETCODE_FIELD_NUMBER = 5;
        private int retcode_;
        public static final int PARAM_FIELD_NUMBER = 10;
        private int param_;
        private byte memoizedIsInitialized;
        private static final PSPlayerApplyEnterMpRsp DEFAULT_INSTANCE = new PSPlayerApplyEnterMpRsp();
        private static final Parser<PSPlayerApplyEnterMpRsp> PARSER = new AbstractParser<PSPlayerApplyEnterMpRsp>() { // from class: emu.grasscutter.net.proto.PSPlayerApplyEnterMpRspOuterClass.PSPlayerApplyEnterMpRsp.1
            @Override // com.google.protobuf.Parser
            public PSPlayerApplyEnterMpRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PSPlayerApplyEnterMpRsp(input, extensionRegistry);
            }
        };

        private PSPlayerApplyEnterMpRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PSPlayerApplyEnterMpRsp() {
            this.memoizedIsInitialized = -1;
            this.targetPsnId_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PSPlayerApplyEnterMpRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PSPlayerApplyEnterMpRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 26:
                                this.targetPsnId_ = input.readStringRequireUtf8();
                                break;
                            case 40:
                                this.retcode_ = input.readInt32();
                                break;
                            case 80:
                                this.param_ = input.readUInt32();
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
            return PSPlayerApplyEnterMpRspOuterClass.internal_static_PSPlayerApplyEnterMpRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PSPlayerApplyEnterMpRspOuterClass.internal_static_PSPlayerApplyEnterMpRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PSPlayerApplyEnterMpRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PSPlayerApplyEnterMpRspOuterClass.PSPlayerApplyEnterMpRspOrBuilder
        public String getTargetPsnId() {
            Object ref = this.targetPsnId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.targetPsnId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PSPlayerApplyEnterMpRspOuterClass.PSPlayerApplyEnterMpRspOrBuilder
        public ByteString getTargetPsnIdBytes() {
            Object ref = this.targetPsnId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.targetPsnId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PSPlayerApplyEnterMpRspOuterClass.PSPlayerApplyEnterMpRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.PSPlayerApplyEnterMpRspOuterClass.PSPlayerApplyEnterMpRspOrBuilder
        public int getParam() {
            return this.param_;
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
            if (!GeneratedMessageV3.isStringEmpty(this.targetPsnId_)) {
                GeneratedMessageV3.writeString(output, 3, this.targetPsnId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(5, this.retcode_);
            }
            if (this.param_ != 0) {
                output.writeUInt32(10, this.param_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.targetPsnId_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(3, this.targetPsnId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(5, this.retcode_);
            }
            if (this.param_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.param_);
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
            if (!(obj instanceof PSPlayerApplyEnterMpRsp)) {
                return equals(obj);
            }
            PSPlayerApplyEnterMpRsp other = (PSPlayerApplyEnterMpRsp) obj;
            return getTargetPsnId().equals(other.getTargetPsnId()) && getRetcode() == other.getRetcode() && getParam() == other.getParam() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getTargetPsnId().hashCode())) + 5)) + getRetcode())) + 10)) + getParam())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PSPlayerApplyEnterMpRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PSPlayerApplyEnterMpRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PSPlayerApplyEnterMpRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PSPlayerApplyEnterMpRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PSPlayerApplyEnterMpRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PSPlayerApplyEnterMpRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PSPlayerApplyEnterMpRsp parseFrom(InputStream input) throws IOException {
            return (PSPlayerApplyEnterMpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PSPlayerApplyEnterMpRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PSPlayerApplyEnterMpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PSPlayerApplyEnterMpRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (PSPlayerApplyEnterMpRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PSPlayerApplyEnterMpRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PSPlayerApplyEnterMpRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PSPlayerApplyEnterMpRsp parseFrom(CodedInputStream input) throws IOException {
            return (PSPlayerApplyEnterMpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PSPlayerApplyEnterMpRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PSPlayerApplyEnterMpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PSPlayerApplyEnterMpRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PSPlayerApplyEnterMpRspOuterClass$PSPlayerApplyEnterMpRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PSPlayerApplyEnterMpRspOrBuilder {
            private Object targetPsnId_ = "";
            private int retcode_;
            private int param_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PSPlayerApplyEnterMpRspOuterClass.internal_static_PSPlayerApplyEnterMpRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PSPlayerApplyEnterMpRspOuterClass.internal_static_PSPlayerApplyEnterMpRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PSPlayerApplyEnterMpRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PSPlayerApplyEnterMpRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.targetPsnId_ = "";
                this.retcode_ = 0;
                this.param_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PSPlayerApplyEnterMpRspOuterClass.internal_static_PSPlayerApplyEnterMpRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PSPlayerApplyEnterMpRsp getDefaultInstanceForType() {
                return PSPlayerApplyEnterMpRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PSPlayerApplyEnterMpRsp build() {
                PSPlayerApplyEnterMpRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PSPlayerApplyEnterMpRsp buildPartial() {
                PSPlayerApplyEnterMpRsp result = new PSPlayerApplyEnterMpRsp(this);
                result.targetPsnId_ = this.targetPsnId_;
                result.retcode_ = this.retcode_;
                result.param_ = this.param_;
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
                if (other instanceof PSPlayerApplyEnterMpRsp) {
                    return mergeFrom((PSPlayerApplyEnterMpRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PSPlayerApplyEnterMpRsp other) {
                if (other == PSPlayerApplyEnterMpRsp.getDefaultInstance()) {
                    return this;
                }
                if (!other.getTargetPsnId().isEmpty()) {
                    this.targetPsnId_ = other.targetPsnId_;
                    onChanged();
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getParam() != 0) {
                    setParam(other.getParam());
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
                PSPlayerApplyEnterMpRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = PSPlayerApplyEnterMpRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PSPlayerApplyEnterMpRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PSPlayerApplyEnterMpRspOuterClass.PSPlayerApplyEnterMpRspOrBuilder
            public String getTargetPsnId() {
                Object ref = this.targetPsnId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.targetPsnId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PSPlayerApplyEnterMpRspOuterClass.PSPlayerApplyEnterMpRspOrBuilder
            public ByteString getTargetPsnIdBytes() {
                Object ref = this.targetPsnId_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.targetPsnId_ = b;
                return b;
            }

            public Builder setTargetPsnId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.targetPsnId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetPsnId() {
                this.targetPsnId_ = PSPlayerApplyEnterMpRsp.getDefaultInstance().getTargetPsnId();
                onChanged();
                return this;
            }

            public Builder setTargetPsnIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PSPlayerApplyEnterMpRsp.checkByteStringIsUtf8(value);
                this.targetPsnId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PSPlayerApplyEnterMpRspOuterClass.PSPlayerApplyEnterMpRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.PSPlayerApplyEnterMpRspOuterClass.PSPlayerApplyEnterMpRspOrBuilder
            public int getParam() {
                return this.param_;
            }

            public Builder setParam(int value) {
                this.param_ = value;
                onChanged();
                return this;
            }

            public Builder clearParam() {
                this.param_ = 0;
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

        public static PSPlayerApplyEnterMpRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PSPlayerApplyEnterMpRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PSPlayerApplyEnterMpRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PSPlayerApplyEnterMpRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
