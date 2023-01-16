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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarUnlockTalentNotifyOuterClass.class */
public final class AvatarUnlockTalentNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eAvatarUnlockTalentNotify.proto\"m\n\u0018AvatarUnlockTalentNotify\u0012\u0016\n\u000eskill_depot_id\u0018\t \u0001(\r\u0012\u0013\n\u000bavatar_guid\u0018\u0003 \u0001(\u0004\u0012\u0011\n\tentity_id\u0018\n \u0001(\r\u0012\u0011\n\ttalent_id\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarUnlockTalentNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarUnlockTalentNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarUnlockTalentNotify_descriptor, new String[]{"SkillDepotId", "AvatarGuid", "EntityId", "TalentId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarUnlockTalentNotifyOuterClass$AvatarUnlockTalentNotifyOrBuilder.class */
    public interface AvatarUnlockTalentNotifyOrBuilder extends MessageOrBuilder {
        int getSkillDepotId();

        long getAvatarGuid();

        int getEntityId();

        int getTalentId();
    }

    private AvatarUnlockTalentNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarUnlockTalentNotifyOuterClass$AvatarUnlockTalentNotify.class */
    public static final class AvatarUnlockTalentNotify extends GeneratedMessageV3 implements AvatarUnlockTalentNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SKILL_DEPOT_ID_FIELD_NUMBER = 9;
        private int skillDepotId_;
        public static final int AVATAR_GUID_FIELD_NUMBER = 3;
        private long avatarGuid_;
        public static final int ENTITY_ID_FIELD_NUMBER = 10;
        private int entityId_;
        public static final int TALENT_ID_FIELD_NUMBER = 8;
        private int talentId_;
        private byte memoizedIsInitialized;
        private static final AvatarUnlockTalentNotify DEFAULT_INSTANCE = new AvatarUnlockTalentNotify();
        private static final Parser<AvatarUnlockTalentNotify> PARSER = new AbstractParser<AvatarUnlockTalentNotify>() { // from class: emu.grasscutter.net.proto.AvatarUnlockTalentNotifyOuterClass.AvatarUnlockTalentNotify.1
            @Override // com.google.protobuf.Parser
            public AvatarUnlockTalentNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarUnlockTalentNotify(input, extensionRegistry);
            }
        };

        private AvatarUnlockTalentNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarUnlockTalentNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarUnlockTalentNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarUnlockTalentNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.avatarGuid_ = input.readUInt64();
                                    break;
                                case 64:
                                    this.talentId_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.skillDepotId_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.entityId_ = input.readUInt32();
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
            return AvatarUnlockTalentNotifyOuterClass.internal_static_AvatarUnlockTalentNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarUnlockTalentNotifyOuterClass.internal_static_AvatarUnlockTalentNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarUnlockTalentNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarUnlockTalentNotifyOuterClass.AvatarUnlockTalentNotifyOrBuilder
        public int getSkillDepotId() {
            return this.skillDepotId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarUnlockTalentNotifyOuterClass.AvatarUnlockTalentNotifyOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.AvatarUnlockTalentNotifyOuterClass.AvatarUnlockTalentNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarUnlockTalentNotifyOuterClass.AvatarUnlockTalentNotifyOrBuilder
        public int getTalentId() {
            return this.talentId_;
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
                output.writeUInt64(3, this.avatarGuid_);
            }
            if (this.talentId_ != 0) {
                output.writeUInt32(8, this.talentId_);
            }
            if (this.skillDepotId_ != 0) {
                output.writeUInt32(9, this.skillDepotId_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(10, this.entityId_);
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
                size2 = 0 + CodedOutputStream.computeUInt64Size(3, this.avatarGuid_);
            }
            if (this.talentId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.talentId_);
            }
            if (this.skillDepotId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.skillDepotId_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.entityId_);
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
            if (!(obj instanceof AvatarUnlockTalentNotify)) {
                return equals(obj);
            }
            AvatarUnlockTalentNotify other = (AvatarUnlockTalentNotify) obj;
            return getSkillDepotId() == other.getSkillDepotId() && getAvatarGuid() == other.getAvatarGuid() && getEntityId() == other.getEntityId() && getTalentId() == other.getTalentId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getSkillDepotId())) + 3)) + Internal.hashLong(getAvatarGuid()))) + 10)) + getEntityId())) + 8)) + getTalentId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AvatarUnlockTalentNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarUnlockTalentNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarUnlockTalentNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarUnlockTalentNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarUnlockTalentNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarUnlockTalentNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarUnlockTalentNotify parseFrom(InputStream input) throws IOException {
            return (AvatarUnlockTalentNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarUnlockTalentNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarUnlockTalentNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarUnlockTalentNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarUnlockTalentNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarUnlockTalentNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarUnlockTalentNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarUnlockTalentNotify parseFrom(CodedInputStream input) throws IOException {
            return (AvatarUnlockTalentNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarUnlockTalentNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarUnlockTalentNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarUnlockTalentNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarUnlockTalentNotifyOuterClass$AvatarUnlockTalentNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarUnlockTalentNotifyOrBuilder {
            private int skillDepotId_;
            private long avatarGuid_;
            private int entityId_;
            private int talentId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarUnlockTalentNotifyOuterClass.internal_static_AvatarUnlockTalentNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarUnlockTalentNotifyOuterClass.internal_static_AvatarUnlockTalentNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarUnlockTalentNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarUnlockTalentNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.skillDepotId_ = 0;
                this.avatarGuid_ = 0;
                this.entityId_ = 0;
                this.talentId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarUnlockTalentNotifyOuterClass.internal_static_AvatarUnlockTalentNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarUnlockTalentNotify getDefaultInstanceForType() {
                return AvatarUnlockTalentNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarUnlockTalentNotify build() {
                AvatarUnlockTalentNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarUnlockTalentNotify buildPartial() {
                AvatarUnlockTalentNotify result = new AvatarUnlockTalentNotify(this);
                result.skillDepotId_ = this.skillDepotId_;
                result.avatarGuid_ = this.avatarGuid_;
                result.entityId_ = this.entityId_;
                result.talentId_ = this.talentId_;
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
                if (other instanceof AvatarUnlockTalentNotify) {
                    return mergeFrom((AvatarUnlockTalentNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarUnlockTalentNotify other) {
                if (other == AvatarUnlockTalentNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getSkillDepotId() != 0) {
                    setSkillDepotId(other.getSkillDepotId());
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getTalentId() != 0) {
                    setTalentId(other.getTalentId());
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
                AvatarUnlockTalentNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarUnlockTalentNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarUnlockTalentNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarUnlockTalentNotifyOuterClass.AvatarUnlockTalentNotifyOrBuilder
            public int getSkillDepotId() {
                return this.skillDepotId_;
            }

            public Builder setSkillDepotId(int value) {
                this.skillDepotId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSkillDepotId() {
                this.skillDepotId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarUnlockTalentNotifyOuterClass.AvatarUnlockTalentNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarUnlockTalentNotifyOuterClass.AvatarUnlockTalentNotifyOrBuilder
            public int getEntityId() {
                return this.entityId_;
            }

            public Builder setEntityId(int value) {
                this.entityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntityId() {
                this.entityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarUnlockTalentNotifyOuterClass.AvatarUnlockTalentNotifyOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static AvatarUnlockTalentNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarUnlockTalentNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarUnlockTalentNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarUnlockTalentNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
