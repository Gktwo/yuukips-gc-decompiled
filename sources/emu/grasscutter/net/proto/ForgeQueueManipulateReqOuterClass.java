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
import emu.grasscutter.net.proto.ForgeQueueManipulateTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueManipulateReqOuterClass.class */
public final class ForgeQueueManipulateReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dForgeQueueManipulateReq.proto\u001a\u001eForgeQueueManipulateType.proto\"b\n\u0017ForgeQueueManipulateReq\u0012\u0014\n\fforgeQueueId\u0018\u0005 \u0001(\r\u00121\n\u000emanipulateType\u0018\u0002 \u0001(\u000e2\u0019.ForgeQueueManipulateTypeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ForgeQueueManipulateTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ForgeQueueManipulateReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ForgeQueueManipulateReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ForgeQueueManipulateReq_descriptor, new String[]{"ForgeQueueId", "ManipulateType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueManipulateReqOuterClass$ForgeQueueManipulateReqOrBuilder.class */
    public interface ForgeQueueManipulateReqOrBuilder extends MessageOrBuilder {
        int getForgeQueueId();

        int getManipulateTypeValue();

        ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType getManipulateType();
    }

    private ForgeQueueManipulateReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueManipulateReqOuterClass$ForgeQueueManipulateReq.class */
    public static final class ForgeQueueManipulateReq extends GeneratedMessageV3 implements ForgeQueueManipulateReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FORGEQUEUEID_FIELD_NUMBER = 5;
        private int forgeQueueId_;
        public static final int MANIPULATETYPE_FIELD_NUMBER = 2;
        private int manipulateType_;
        private byte memoizedIsInitialized;
        private static final ForgeQueueManipulateReq DEFAULT_INSTANCE = new ForgeQueueManipulateReq();
        private static final Parser<ForgeQueueManipulateReq> PARSER = new AbstractParser<ForgeQueueManipulateReq>() { // from class: emu.grasscutter.net.proto.ForgeQueueManipulateReqOuterClass.ForgeQueueManipulateReq.1
            @Override // com.google.protobuf.Parser
            public ForgeQueueManipulateReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ForgeQueueManipulateReq(input, extensionRegistry);
            }
        };

        private ForgeQueueManipulateReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ForgeQueueManipulateReq() {
            this.memoizedIsInitialized = -1;
            this.manipulateType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ForgeQueueManipulateReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ForgeQueueManipulateReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    this.manipulateType_ = input.readEnum();
                                    break;
                                case 40:
                                    this.forgeQueueId_ = input.readUInt32();
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
            return ForgeQueueManipulateReqOuterClass.internal_static_ForgeQueueManipulateReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ForgeQueueManipulateReqOuterClass.internal_static_ForgeQueueManipulateReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ForgeQueueManipulateReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateReqOuterClass.ForgeQueueManipulateReqOrBuilder
        public int getForgeQueueId() {
            return this.forgeQueueId_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateReqOuterClass.ForgeQueueManipulateReqOrBuilder
        public int getManipulateTypeValue() {
            return this.manipulateType_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateReqOuterClass.ForgeQueueManipulateReqOrBuilder
        public ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType getManipulateType() {
            ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType result = ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType.valueOf(this.manipulateType_);
            return result == null ? ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType.UNRECOGNIZED : result;
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
            if (this.manipulateType_ != ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType.FORGE_QUEUE_MANIPULATE_TYPE_RECEIVE_OUTPUT.getNumber()) {
                output.writeEnum(2, this.manipulateType_);
            }
            if (this.forgeQueueId_ != 0) {
                output.writeUInt32(5, this.forgeQueueId_);
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
            if (this.manipulateType_ != ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType.FORGE_QUEUE_MANIPULATE_TYPE_RECEIVE_OUTPUT.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(2, this.manipulateType_);
            }
            if (this.forgeQueueId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.forgeQueueId_);
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
            if (!(obj instanceof ForgeQueueManipulateReq)) {
                return equals(obj);
            }
            ForgeQueueManipulateReq other = (ForgeQueueManipulateReq) obj;
            return getForgeQueueId() == other.getForgeQueueId() && this.manipulateType_ == other.manipulateType_ && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getForgeQueueId())) + 2)) + this.manipulateType_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ForgeQueueManipulateReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeQueueManipulateReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeQueueManipulateReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeQueueManipulateReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeQueueManipulateReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeQueueManipulateReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeQueueManipulateReq parseFrom(InputStream input) throws IOException {
            return (ForgeQueueManipulateReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ForgeQueueManipulateReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeQueueManipulateReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ForgeQueueManipulateReq parseDelimitedFrom(InputStream input) throws IOException {
            return (ForgeQueueManipulateReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ForgeQueueManipulateReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeQueueManipulateReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ForgeQueueManipulateReq parseFrom(CodedInputStream input) throws IOException {
            return (ForgeQueueManipulateReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ForgeQueueManipulateReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeQueueManipulateReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ForgeQueueManipulateReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueManipulateReqOuterClass$ForgeQueueManipulateReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ForgeQueueManipulateReqOrBuilder {
            private int forgeQueueId_;
            private int manipulateType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return ForgeQueueManipulateReqOuterClass.internal_static_ForgeQueueManipulateReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ForgeQueueManipulateReqOuterClass.internal_static_ForgeQueueManipulateReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ForgeQueueManipulateReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ForgeQueueManipulateReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.forgeQueueId_ = 0;
                this.manipulateType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ForgeQueueManipulateReqOuterClass.internal_static_ForgeQueueManipulateReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ForgeQueueManipulateReq getDefaultInstanceForType() {
                return ForgeQueueManipulateReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ForgeQueueManipulateReq build() {
                ForgeQueueManipulateReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ForgeQueueManipulateReq buildPartial() {
                ForgeQueueManipulateReq result = new ForgeQueueManipulateReq(this);
                result.forgeQueueId_ = this.forgeQueueId_;
                result.manipulateType_ = this.manipulateType_;
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
                if (other instanceof ForgeQueueManipulateReq) {
                    return mergeFrom((ForgeQueueManipulateReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ForgeQueueManipulateReq other) {
                if (other == ForgeQueueManipulateReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getForgeQueueId() != 0) {
                    setForgeQueueId(other.getForgeQueueId());
                }
                if (other.manipulateType_ != 0) {
                    setManipulateTypeValue(other.getManipulateTypeValue());
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
                ForgeQueueManipulateReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = ForgeQueueManipulateReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ForgeQueueManipulateReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateReqOuterClass.ForgeQueueManipulateReqOrBuilder
            public int getForgeQueueId() {
                return this.forgeQueueId_;
            }

            public Builder setForgeQueueId(int value) {
                this.forgeQueueId_ = value;
                onChanged();
                return this;
            }

            public Builder clearForgeQueueId() {
                this.forgeQueueId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateReqOuterClass.ForgeQueueManipulateReqOrBuilder
            public int getManipulateTypeValue() {
                return this.manipulateType_;
            }

            public Builder setManipulateTypeValue(int value) {
                this.manipulateType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateReqOuterClass.ForgeQueueManipulateReqOrBuilder
            public ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType getManipulateType() {
                ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType result = ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType.valueOf(this.manipulateType_);
                return result == null ? ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType.UNRECOGNIZED : result;
            }

            public Builder setManipulateType(ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.manipulateType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearManipulateType() {
                this.manipulateType_ = 0;
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

        public static ForgeQueueManipulateReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ForgeQueueManipulateReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ForgeQueueManipulateReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ForgeQueueManipulateReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ForgeQueueManipulateTypeOuterClass.getDescriptor();
    }
}
