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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PSPlayerApplyEnterMpReqOuterClass.class */
public final class PSPlayerApplyEnterMpReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dPSPlayerApplyEnterMpReq.proto\".\n\u0017PSPlayerApplyEnterMpReq\u0012\u0013\n\u000btargetPsnId\u0018\u0006 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PSPlayerApplyEnterMpReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PSPlayerApplyEnterMpReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PSPlayerApplyEnterMpReq_descriptor, new String[]{"TargetPsnId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PSPlayerApplyEnterMpReqOuterClass$PSPlayerApplyEnterMpReqOrBuilder.class */
    public interface PSPlayerApplyEnterMpReqOrBuilder extends MessageOrBuilder {
        String getTargetPsnId();

        ByteString getTargetPsnIdBytes();
    }

    private PSPlayerApplyEnterMpReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PSPlayerApplyEnterMpReqOuterClass$PSPlayerApplyEnterMpReq.class */
    public static final class PSPlayerApplyEnterMpReq extends GeneratedMessageV3 implements PSPlayerApplyEnterMpReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TARGETPSNID_FIELD_NUMBER = 6;
        private volatile Object targetPsnId_;
        private byte memoizedIsInitialized;
        private static final PSPlayerApplyEnterMpReq DEFAULT_INSTANCE = new PSPlayerApplyEnterMpReq();
        private static final Parser<PSPlayerApplyEnterMpReq> PARSER = new AbstractParser<PSPlayerApplyEnterMpReq>() { // from class: emu.grasscutter.net.proto.PSPlayerApplyEnterMpReqOuterClass.PSPlayerApplyEnterMpReq.1
            @Override // com.google.protobuf.Parser
            public PSPlayerApplyEnterMpReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PSPlayerApplyEnterMpReq(input, extensionRegistry);
            }
        };

        private PSPlayerApplyEnterMpReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PSPlayerApplyEnterMpReq() {
            this.memoizedIsInitialized = -1;
            this.targetPsnId_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PSPlayerApplyEnterMpReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PSPlayerApplyEnterMpReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 50:
                                this.targetPsnId_ = input.readStringRequireUtf8();
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
            return PSPlayerApplyEnterMpReqOuterClass.internal_static_PSPlayerApplyEnterMpReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PSPlayerApplyEnterMpReqOuterClass.internal_static_PSPlayerApplyEnterMpReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PSPlayerApplyEnterMpReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PSPlayerApplyEnterMpReqOuterClass.PSPlayerApplyEnterMpReqOrBuilder
        public String getTargetPsnId() {
            Object ref = this.targetPsnId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.targetPsnId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PSPlayerApplyEnterMpReqOuterClass.PSPlayerApplyEnterMpReqOrBuilder
        public ByteString getTargetPsnIdBytes() {
            Object ref = this.targetPsnId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.targetPsnId_ = b;
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
            if (!GeneratedMessageV3.isStringEmpty(this.targetPsnId_)) {
                GeneratedMessageV3.writeString(output, 6, this.targetPsnId_);
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
                size2 = 0 + GeneratedMessageV3.computeStringSize(6, this.targetPsnId_);
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
            if (!(obj instanceof PSPlayerApplyEnterMpReq)) {
                return equals(obj);
            }
            PSPlayerApplyEnterMpReq other = (PSPlayerApplyEnterMpReq) obj;
            return getTargetPsnId().equals(other.getTargetPsnId()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getTargetPsnId().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PSPlayerApplyEnterMpReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PSPlayerApplyEnterMpReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PSPlayerApplyEnterMpReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PSPlayerApplyEnterMpReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PSPlayerApplyEnterMpReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PSPlayerApplyEnterMpReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PSPlayerApplyEnterMpReq parseFrom(InputStream input) throws IOException {
            return (PSPlayerApplyEnterMpReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PSPlayerApplyEnterMpReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PSPlayerApplyEnterMpReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PSPlayerApplyEnterMpReq parseDelimitedFrom(InputStream input) throws IOException {
            return (PSPlayerApplyEnterMpReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PSPlayerApplyEnterMpReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PSPlayerApplyEnterMpReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PSPlayerApplyEnterMpReq parseFrom(CodedInputStream input) throws IOException {
            return (PSPlayerApplyEnterMpReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PSPlayerApplyEnterMpReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PSPlayerApplyEnterMpReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PSPlayerApplyEnterMpReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PSPlayerApplyEnterMpReqOuterClass$PSPlayerApplyEnterMpReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PSPlayerApplyEnterMpReqOrBuilder {
            private Object targetPsnId_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return PSPlayerApplyEnterMpReqOuterClass.internal_static_PSPlayerApplyEnterMpReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PSPlayerApplyEnterMpReqOuterClass.internal_static_PSPlayerApplyEnterMpReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PSPlayerApplyEnterMpReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PSPlayerApplyEnterMpReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.targetPsnId_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PSPlayerApplyEnterMpReqOuterClass.internal_static_PSPlayerApplyEnterMpReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PSPlayerApplyEnterMpReq getDefaultInstanceForType() {
                return PSPlayerApplyEnterMpReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PSPlayerApplyEnterMpReq build() {
                PSPlayerApplyEnterMpReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PSPlayerApplyEnterMpReq buildPartial() {
                PSPlayerApplyEnterMpReq result = new PSPlayerApplyEnterMpReq(this);
                result.targetPsnId_ = this.targetPsnId_;
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
                if (other instanceof PSPlayerApplyEnterMpReq) {
                    return mergeFrom((PSPlayerApplyEnterMpReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PSPlayerApplyEnterMpReq other) {
                if (other == PSPlayerApplyEnterMpReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.getTargetPsnId().isEmpty()) {
                    this.targetPsnId_ = other.targetPsnId_;
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
                PSPlayerApplyEnterMpReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = PSPlayerApplyEnterMpReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PSPlayerApplyEnterMpReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PSPlayerApplyEnterMpReqOuterClass.PSPlayerApplyEnterMpReqOrBuilder
            public String getTargetPsnId() {
                Object ref = this.targetPsnId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.targetPsnId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PSPlayerApplyEnterMpReqOuterClass.PSPlayerApplyEnterMpReqOrBuilder
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
                this.targetPsnId_ = PSPlayerApplyEnterMpReq.getDefaultInstance().getTargetPsnId();
                onChanged();
                return this;
            }

            public Builder setTargetPsnIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PSPlayerApplyEnterMpReq.checkByteStringIsUtf8(value);
                this.targetPsnId_ = value;
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

        public static PSPlayerApplyEnterMpReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PSPlayerApplyEnterMpReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PSPlayerApplyEnterMpReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PSPlayerApplyEnterMpReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
