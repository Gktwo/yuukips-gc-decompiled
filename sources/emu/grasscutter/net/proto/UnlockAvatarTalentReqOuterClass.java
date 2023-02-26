package emu.grasscutter.net.proto;

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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockAvatarTalentReqOuterClass.class */
public final class UnlockAvatarTalentReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bUnlockAvatarTalentReq.proto\"=\n\u0015UnlockAvatarTalentReq\u0012\u0010\n\btalentId\u0018\t \u0001(\r\u0012\u0012\n\navatarGuid\u0018\u0001 \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_UnlockAvatarTalentReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_UnlockAvatarTalentReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_UnlockAvatarTalentReq_descriptor, new String[]{"TalentId", "AvatarGuid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockAvatarTalentReqOuterClass$UnlockAvatarTalentReqOrBuilder.class */
    public interface UnlockAvatarTalentReqOrBuilder extends MessageOrBuilder {
        int getTalentId();

        long getAvatarGuid();
    }

    private UnlockAvatarTalentReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockAvatarTalentReqOuterClass$UnlockAvatarTalentReq.class */
    public static final class UnlockAvatarTalentReq extends GeneratedMessageV3 implements UnlockAvatarTalentReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TALENTID_FIELD_NUMBER = 9;
        private int talentId_;
        public static final int AVATARGUID_FIELD_NUMBER = 1;
        private long avatarGuid_;
        private byte memoizedIsInitialized;
        private static final UnlockAvatarTalentReq DEFAULT_INSTANCE = new UnlockAvatarTalentReq();
        private static final Parser<UnlockAvatarTalentReq> PARSER = new AbstractParser<UnlockAvatarTalentReq>() { // from class: emu.grasscutter.net.proto.UnlockAvatarTalentReqOuterClass.UnlockAvatarTalentReq.1
            @Override // com.google.protobuf.Parser
            public UnlockAvatarTalentReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new UnlockAvatarTalentReq(input, extensionRegistry);
            }
        };

        private UnlockAvatarTalentReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private UnlockAvatarTalentReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UnlockAvatarTalentReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UnlockAvatarTalentReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.avatarGuid_ = input.readUInt64();
                                break;
                            case 72:
                                this.talentId_ = input.readUInt32();
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
            return UnlockAvatarTalentReqOuterClass.internal_static_UnlockAvatarTalentReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UnlockAvatarTalentReqOuterClass.internal_static_UnlockAvatarTalentReq_fieldAccessorTable.ensureFieldAccessorsInitialized(UnlockAvatarTalentReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.UnlockAvatarTalentReqOuterClass.UnlockAvatarTalentReqOrBuilder
        public int getTalentId() {
            return this.talentId_;
        }

        @Override // emu.grasscutter.net.proto.UnlockAvatarTalentReqOuterClass.UnlockAvatarTalentReqOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
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
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(1, this.avatarGuid_);
            }
            if (this.talentId_ != 0) {
                output.writeUInt32(9, this.talentId_);
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
            if (this.avatarGuid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(1, this.avatarGuid_);
            }
            if (this.talentId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.talentId_);
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
            if (!(obj instanceof UnlockAvatarTalentReq)) {
                return equals(obj);
            }
            UnlockAvatarTalentReq other = (UnlockAvatarTalentReq) obj;
            return getTalentId() == other.getTalentId() && getAvatarGuid() == other.getAvatarGuid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getTalentId())) + 1)) + Internal.hashLong(getAvatarGuid()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static UnlockAvatarTalentReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnlockAvatarTalentReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnlockAvatarTalentReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnlockAvatarTalentReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnlockAvatarTalentReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnlockAvatarTalentReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnlockAvatarTalentReq parseFrom(InputStream input) throws IOException {
            return (UnlockAvatarTalentReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UnlockAvatarTalentReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnlockAvatarTalentReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UnlockAvatarTalentReq parseDelimitedFrom(InputStream input) throws IOException {
            return (UnlockAvatarTalentReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UnlockAvatarTalentReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnlockAvatarTalentReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UnlockAvatarTalentReq parseFrom(CodedInputStream input) throws IOException {
            return (UnlockAvatarTalentReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UnlockAvatarTalentReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnlockAvatarTalentReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UnlockAvatarTalentReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockAvatarTalentReqOuterClass$UnlockAvatarTalentReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UnlockAvatarTalentReqOrBuilder {
            private int talentId_;
            private long avatarGuid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return UnlockAvatarTalentReqOuterClass.internal_static_UnlockAvatarTalentReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UnlockAvatarTalentReqOuterClass.internal_static_UnlockAvatarTalentReq_fieldAccessorTable.ensureFieldAccessorsInitialized(UnlockAvatarTalentReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UnlockAvatarTalentReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.talentId_ = 0;
                this.avatarGuid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UnlockAvatarTalentReqOuterClass.internal_static_UnlockAvatarTalentReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UnlockAvatarTalentReq getDefaultInstanceForType() {
                return UnlockAvatarTalentReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UnlockAvatarTalentReq build() {
                UnlockAvatarTalentReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UnlockAvatarTalentReq buildPartial() {
                UnlockAvatarTalentReq result = new UnlockAvatarTalentReq(this);
                result.talentId_ = this.talentId_;
                result.avatarGuid_ = this.avatarGuid_;
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
                if (other instanceof UnlockAvatarTalentReq) {
                    return mergeFrom((UnlockAvatarTalentReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UnlockAvatarTalentReq other) {
                if (other == UnlockAvatarTalentReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getTalentId() != 0) {
                    setTalentId(other.getTalentId());
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
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
                UnlockAvatarTalentReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = UnlockAvatarTalentReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (UnlockAvatarTalentReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.UnlockAvatarTalentReqOuterClass.UnlockAvatarTalentReqOrBuilder
            public int getTalentId() {
                return this.talentId_;
            }

            public Builder setTalentId(int value) {
                this.talentId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTalentId() {
                this.talentId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UnlockAvatarTalentReqOuterClass.UnlockAvatarTalentReqOrBuilder
            public long getAvatarGuid() {
                return this.avatarGuid_;
            }

            public Builder setAvatarGuid(long value) {
                this.avatarGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarGuid() {
                this.avatarGuid_ = 0;
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

        public static UnlockAvatarTalentReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UnlockAvatarTalentReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UnlockAvatarTalentReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UnlockAvatarTalentReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
