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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillMaxChargeCountNotifyOuterClass.class */
public final class AvatarSkillMaxChargeCountNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%AvatarSkillMaxChargeCountNotify.proto\"b\n\u001fAvatarSkillMaxChargeCountNotify\u0012\u0013\n\u000bavatar_guid\u0018\u0004 \u0001(\u0004\u0012\u0018\n\u0010max_charge_count\u0018\t \u0001(\r\u0012\u0010\n\bskill_id\u0018\u0006 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarSkillMaxChargeCountNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_AvatarSkillMaxChargeCountNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f650xc4b57a3 = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarSkillMaxChargeCountNotify_descriptor, new String[]{"AvatarGuid", "MaxChargeCount", "SkillId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillMaxChargeCountNotifyOuterClass$AvatarSkillMaxChargeCountNotifyOrBuilder.class */
    public interface AvatarSkillMaxChargeCountNotifyOrBuilder extends MessageOrBuilder {
        long getAvatarGuid();

        int getMaxChargeCount();

        int getSkillId();
    }

    private AvatarSkillMaxChargeCountNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillMaxChargeCountNotifyOuterClass$AvatarSkillMaxChargeCountNotify.class */
    public static final class AvatarSkillMaxChargeCountNotify extends GeneratedMessageV3 implements AvatarSkillMaxChargeCountNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATAR_GUID_FIELD_NUMBER = 4;
        private long avatarGuid_;
        public static final int MAX_CHARGE_COUNT_FIELD_NUMBER = 9;
        private int maxChargeCount_;
        public static final int SKILL_ID_FIELD_NUMBER = 6;
        private int skillId_;
        private byte memoizedIsInitialized;
        private static final AvatarSkillMaxChargeCountNotify DEFAULT_INSTANCE = new AvatarSkillMaxChargeCountNotify();
        private static final Parser<AvatarSkillMaxChargeCountNotify> PARSER = new AbstractParser<AvatarSkillMaxChargeCountNotify>() { // from class: emu.grasscutter.net.proto.AvatarSkillMaxChargeCountNotifyOuterClass.AvatarSkillMaxChargeCountNotify.1
            @Override // com.google.protobuf.Parser
            public AvatarSkillMaxChargeCountNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarSkillMaxChargeCountNotify(input, extensionRegistry);
            }
        };

        private AvatarSkillMaxChargeCountNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarSkillMaxChargeCountNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarSkillMaxChargeCountNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarSkillMaxChargeCountNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.avatarGuid_ = input.readUInt64();
                                    break;
                                case 48:
                                    this.skillId_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.maxChargeCount_ = input.readUInt32();
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
            return AvatarSkillMaxChargeCountNotifyOuterClass.internal_static_AvatarSkillMaxChargeCountNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarSkillMaxChargeCountNotifyOuterClass.f650xc4b57a3.ensureFieldAccessorsInitialized(AvatarSkillMaxChargeCountNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillMaxChargeCountNotifyOuterClass.AvatarSkillMaxChargeCountNotifyOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillMaxChargeCountNotifyOuterClass.AvatarSkillMaxChargeCountNotifyOrBuilder
        public int getMaxChargeCount() {
            return this.maxChargeCount_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillMaxChargeCountNotifyOuterClass.AvatarSkillMaxChargeCountNotifyOrBuilder
        public int getSkillId() {
            return this.skillId_;
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
                output.writeUInt64(4, this.avatarGuid_);
            }
            if (this.skillId_ != 0) {
                output.writeUInt32(6, this.skillId_);
            }
            if (this.maxChargeCount_ != 0) {
                output.writeUInt32(9, this.maxChargeCount_);
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
                size2 = 0 + CodedOutputStream.computeUInt64Size(4, this.avatarGuid_);
            }
            if (this.skillId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.skillId_);
            }
            if (this.maxChargeCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.maxChargeCount_);
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
            if (!(obj instanceof AvatarSkillMaxChargeCountNotify)) {
                return equals(obj);
            }
            AvatarSkillMaxChargeCountNotify other = (AvatarSkillMaxChargeCountNotify) obj;
            return getAvatarGuid() == other.getAvatarGuid() && getMaxChargeCount() == other.getMaxChargeCount() && getSkillId() == other.getSkillId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + Internal.hashLong(getAvatarGuid()))) + 9)) + getMaxChargeCount())) + 6)) + getSkillId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AvatarSkillMaxChargeCountNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSkillMaxChargeCountNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSkillMaxChargeCountNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSkillMaxChargeCountNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSkillMaxChargeCountNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSkillMaxChargeCountNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSkillMaxChargeCountNotify parseFrom(InputStream input) throws IOException {
            return (AvatarSkillMaxChargeCountNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarSkillMaxChargeCountNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSkillMaxChargeCountNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarSkillMaxChargeCountNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarSkillMaxChargeCountNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarSkillMaxChargeCountNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSkillMaxChargeCountNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarSkillMaxChargeCountNotify parseFrom(CodedInputStream input) throws IOException {
            return (AvatarSkillMaxChargeCountNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarSkillMaxChargeCountNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSkillMaxChargeCountNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarSkillMaxChargeCountNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillMaxChargeCountNotifyOuterClass$AvatarSkillMaxChargeCountNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarSkillMaxChargeCountNotifyOrBuilder {
            private long avatarGuid_;
            private int maxChargeCount_;
            private int skillId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarSkillMaxChargeCountNotifyOuterClass.internal_static_AvatarSkillMaxChargeCountNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarSkillMaxChargeCountNotifyOuterClass.f650xc4b57a3.ensureFieldAccessorsInitialized(AvatarSkillMaxChargeCountNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarSkillMaxChargeCountNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.avatarGuid_ = 0;
                this.maxChargeCount_ = 0;
                this.skillId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarSkillMaxChargeCountNotifyOuterClass.internal_static_AvatarSkillMaxChargeCountNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarSkillMaxChargeCountNotify getDefaultInstanceForType() {
                return AvatarSkillMaxChargeCountNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarSkillMaxChargeCountNotify build() {
                AvatarSkillMaxChargeCountNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarSkillMaxChargeCountNotify buildPartial() {
                AvatarSkillMaxChargeCountNotify result = new AvatarSkillMaxChargeCountNotify(this);
                result.avatarGuid_ = this.avatarGuid_;
                result.maxChargeCount_ = this.maxChargeCount_;
                result.skillId_ = this.skillId_;
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
                if (other instanceof AvatarSkillMaxChargeCountNotify) {
                    return mergeFrom((AvatarSkillMaxChargeCountNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarSkillMaxChargeCountNotify other) {
                if (other == AvatarSkillMaxChargeCountNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                if (other.getMaxChargeCount() != 0) {
                    setMaxChargeCount(other.getMaxChargeCount());
                }
                if (other.getSkillId() != 0) {
                    setSkillId(other.getSkillId());
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
                AvatarSkillMaxChargeCountNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarSkillMaxChargeCountNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarSkillMaxChargeCountNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillMaxChargeCountNotifyOuterClass.AvatarSkillMaxChargeCountNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarSkillMaxChargeCountNotifyOuterClass.AvatarSkillMaxChargeCountNotifyOrBuilder
            public int getMaxChargeCount() {
                return this.maxChargeCount_;
            }

            public Builder setMaxChargeCount(int value) {
                this.maxChargeCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxChargeCount() {
                this.maxChargeCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillMaxChargeCountNotifyOuterClass.AvatarSkillMaxChargeCountNotifyOrBuilder
            public int getSkillId() {
                return this.skillId_;
            }

            public Builder setSkillId(int value) {
                this.skillId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSkillId() {
                this.skillId_ = 0;
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

        public static AvatarSkillMaxChargeCountNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarSkillMaxChargeCountNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarSkillMaxChargeCountNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarSkillMaxChargeCountNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
