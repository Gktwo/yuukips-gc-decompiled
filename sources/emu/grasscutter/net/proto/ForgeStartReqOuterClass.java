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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeStartReqOuterClass.class */
public final class ForgeStartReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013ForgeStartReq.proto\"I\n\rForgeStartReq\u0012\u0010\n\bforge_id\u0018\b \u0001(\r\u0012\u0011\n\tavatar_id\u0018\u0001 \u0001(\r\u0012\u0013\n\u000bforge_count\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ForgeStartReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ForgeStartReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ForgeStartReq_descriptor, new String[]{"ForgeId", "AvatarId", "ForgeCount"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeStartReqOuterClass$ForgeStartReqOrBuilder.class */
    public interface ForgeStartReqOrBuilder extends MessageOrBuilder {
        int getForgeId();

        int getAvatarId();

        int getForgeCount();
    }

    private ForgeStartReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeStartReqOuterClass$ForgeStartReq.class */
    public static final class ForgeStartReq extends GeneratedMessageV3 implements ForgeStartReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FORGE_ID_FIELD_NUMBER = 8;
        private int forgeId_;
        public static final int AVATAR_ID_FIELD_NUMBER = 1;
        private int avatarId_;
        public static final int FORGE_COUNT_FIELD_NUMBER = 10;
        private int forgeCount_;
        private byte memoizedIsInitialized;
        private static final ForgeStartReq DEFAULT_INSTANCE = new ForgeStartReq();
        private static final Parser<ForgeStartReq> PARSER = new AbstractParser<ForgeStartReq>() { // from class: emu.grasscutter.net.proto.ForgeStartReqOuterClass.ForgeStartReq.1
            @Override // com.google.protobuf.Parser
            public ForgeStartReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ForgeStartReq(input, extensionRegistry);
            }
        };

        private ForgeStartReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ForgeStartReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ForgeStartReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ForgeStartReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.avatarId_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.forgeId_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.forgeCount_ = input.readUInt32();
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
                        }
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
            return ForgeStartReqOuterClass.internal_static_ForgeStartReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ForgeStartReqOuterClass.internal_static_ForgeStartReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ForgeStartReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ForgeStartReqOuterClass.ForgeStartReqOrBuilder
        public int getForgeId() {
            return this.forgeId_;
        }

        @Override // emu.grasscutter.net.proto.ForgeStartReqOuterClass.ForgeStartReqOrBuilder
        public int getAvatarId() {
            return this.avatarId_;
        }

        @Override // emu.grasscutter.net.proto.ForgeStartReqOuterClass.ForgeStartReqOrBuilder
        public int getForgeCount() {
            return this.forgeCount_;
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
            if (this.avatarId_ != 0) {
                output.writeUInt32(1, this.avatarId_);
            }
            if (this.forgeId_ != 0) {
                output.writeUInt32(8, this.forgeId_);
            }
            if (this.forgeCount_ != 0) {
                output.writeUInt32(10, this.forgeCount_);
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
            if (this.avatarId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.avatarId_);
            }
            if (this.forgeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.forgeId_);
            }
            if (this.forgeCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.forgeCount_);
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
            if (!(obj instanceof ForgeStartReq)) {
                return equals(obj);
            }
            ForgeStartReq other = (ForgeStartReq) obj;
            return getForgeId() == other.getForgeId() && getAvatarId() == other.getAvatarId() && getForgeCount() == other.getForgeCount() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getForgeId())) + 1)) + getAvatarId())) + 10)) + getForgeCount())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ForgeStartReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeStartReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeStartReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeStartReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeStartReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeStartReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeStartReq parseFrom(InputStream input) throws IOException {
            return (ForgeStartReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ForgeStartReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeStartReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ForgeStartReq parseDelimitedFrom(InputStream input) throws IOException {
            return (ForgeStartReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ForgeStartReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeStartReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ForgeStartReq parseFrom(CodedInputStream input) throws IOException {
            return (ForgeStartReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ForgeStartReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeStartReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ForgeStartReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeStartReqOuterClass$ForgeStartReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ForgeStartReqOrBuilder {
            private int forgeId_;
            private int avatarId_;
            private int forgeCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ForgeStartReqOuterClass.internal_static_ForgeStartReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ForgeStartReqOuterClass.internal_static_ForgeStartReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ForgeStartReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ForgeStartReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.forgeId_ = 0;
                this.avatarId_ = 0;
                this.forgeCount_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ForgeStartReqOuterClass.internal_static_ForgeStartReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ForgeStartReq getDefaultInstanceForType() {
                return ForgeStartReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ForgeStartReq build() {
                ForgeStartReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ForgeStartReq buildPartial() {
                ForgeStartReq result = new ForgeStartReq(this);
                result.forgeId_ = this.forgeId_;
                result.avatarId_ = this.avatarId_;
                result.forgeCount_ = this.forgeCount_;
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
                if (other instanceof ForgeStartReq) {
                    return mergeFrom((ForgeStartReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ForgeStartReq other) {
                if (other == ForgeStartReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getForgeId() != 0) {
                    setForgeId(other.getForgeId());
                }
                if (other.getAvatarId() != 0) {
                    setAvatarId(other.getAvatarId());
                }
                if (other.getForgeCount() != 0) {
                    setForgeCount(other.getForgeCount());
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
                ForgeStartReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = ForgeStartReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ForgeStartReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ForgeStartReqOuterClass.ForgeStartReqOrBuilder
            public int getForgeId() {
                return this.forgeId_;
            }

            public Builder setForgeId(int value) {
                this.forgeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearForgeId() {
                this.forgeId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ForgeStartReqOuterClass.ForgeStartReqOrBuilder
            public int getAvatarId() {
                return this.avatarId_;
            }

            public Builder setAvatarId(int value) {
                this.avatarId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarId() {
                this.avatarId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ForgeStartReqOuterClass.ForgeStartReqOrBuilder
            public int getForgeCount() {
                return this.forgeCount_;
            }

            public Builder setForgeCount(int value) {
                this.forgeCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearForgeCount() {
                this.forgeCount_ = 0;
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

        public static ForgeStartReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ForgeStartReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ForgeStartReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ForgeStartReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
