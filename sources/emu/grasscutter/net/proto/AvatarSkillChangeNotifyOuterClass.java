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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillChangeNotifyOuterClass.class */
public final class AvatarSkillChangeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dAvatarSkillChangeNotify.proto\"\u0001\n\u0017AvatarSkillChangeNotify\u0012\u0012\n\navatarGuid\u0018\u0004 \u0001(\u0004\u0012\u0010\n\bentityId\u0018\f \u0001(\r\u0012\u0015\n\ravatarSkillId\u0018\u0001 \u0001(\r\u0012\u0014\n\fskillDepotId\u0018\u0005 \u0001(\r\u0012\u0010\n\boldLevel\u0018\u0006 \u0001(\r\u0012\u0010\n\bcurLevel\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarSkillChangeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarSkillChangeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarSkillChangeNotify_descriptor, new String[]{"AvatarGuid", "EntityId", "AvatarSkillId", "SkillDepotId", "OldLevel", "CurLevel"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillChangeNotifyOuterClass$AvatarSkillChangeNotifyOrBuilder.class */
    public interface AvatarSkillChangeNotifyOrBuilder extends MessageOrBuilder {
        long getAvatarGuid();

        int getEntityId();

        int getAvatarSkillId();

        int getSkillDepotId();

        int getOldLevel();

        int getCurLevel();
    }

    private AvatarSkillChangeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillChangeNotifyOuterClass$AvatarSkillChangeNotify.class */
    public static final class AvatarSkillChangeNotify extends GeneratedMessageV3 implements AvatarSkillChangeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATARGUID_FIELD_NUMBER = 4;
        private long avatarGuid_;
        public static final int ENTITYID_FIELD_NUMBER = 12;
        private int entityId_;
        public static final int AVATARSKILLID_FIELD_NUMBER = 1;
        private int avatarSkillId_;
        public static final int SKILLDEPOTID_FIELD_NUMBER = 5;
        private int skillDepotId_;
        public static final int OLDLEVEL_FIELD_NUMBER = 6;
        private int oldLevel_;
        public static final int CURLEVEL_FIELD_NUMBER = 2;
        private int curLevel_;
        private byte memoizedIsInitialized;
        private static final AvatarSkillChangeNotify DEFAULT_INSTANCE = new AvatarSkillChangeNotify();
        private static final Parser<AvatarSkillChangeNotify> PARSER = new AbstractParser<AvatarSkillChangeNotify>() { // from class: emu.grasscutter.net.proto.AvatarSkillChangeNotifyOuterClass.AvatarSkillChangeNotify.1
            @Override // com.google.protobuf.Parser
            public AvatarSkillChangeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarSkillChangeNotify(input, extensionRegistry);
            }
        };

        private AvatarSkillChangeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarSkillChangeNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarSkillChangeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarSkillChangeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.avatarSkillId_ = input.readUInt32();
                                break;
                            case 16:
                                this.curLevel_ = input.readUInt32();
                                break;
                            case 32:
                                this.avatarGuid_ = input.readUInt64();
                                break;
                            case 40:
                                this.skillDepotId_ = input.readUInt32();
                                break;
                            case 48:
                                this.oldLevel_ = input.readUInt32();
                                break;
                            case 96:
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
            return AvatarSkillChangeNotifyOuterClass.internal_static_AvatarSkillChangeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarSkillChangeNotifyOuterClass.internal_static_AvatarSkillChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarSkillChangeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillChangeNotifyOuterClass.AvatarSkillChangeNotifyOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillChangeNotifyOuterClass.AvatarSkillChangeNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillChangeNotifyOuterClass.AvatarSkillChangeNotifyOrBuilder
        public int getAvatarSkillId() {
            return this.avatarSkillId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillChangeNotifyOuterClass.AvatarSkillChangeNotifyOrBuilder
        public int getSkillDepotId() {
            return this.skillDepotId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillChangeNotifyOuterClass.AvatarSkillChangeNotifyOrBuilder
        public int getOldLevel() {
            return this.oldLevel_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillChangeNotifyOuterClass.AvatarSkillChangeNotifyOrBuilder
        public int getCurLevel() {
            return this.curLevel_;
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
            if (this.avatarSkillId_ != 0) {
                output.writeUInt32(1, this.avatarSkillId_);
            }
            if (this.curLevel_ != 0) {
                output.writeUInt32(2, this.curLevel_);
            }
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(4, this.avatarGuid_);
            }
            if (this.skillDepotId_ != 0) {
                output.writeUInt32(5, this.skillDepotId_);
            }
            if (this.oldLevel_ != 0) {
                output.writeUInt32(6, this.oldLevel_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(12, this.entityId_);
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
            if (this.avatarSkillId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.avatarSkillId_);
            }
            if (this.curLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.curLevel_);
            }
            if (this.avatarGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(4, this.avatarGuid_);
            }
            if (this.skillDepotId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.skillDepotId_);
            }
            if (this.oldLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.oldLevel_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.entityId_);
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
            if (!(obj instanceof AvatarSkillChangeNotify)) {
                return equals(obj);
            }
            AvatarSkillChangeNotify other = (AvatarSkillChangeNotify) obj;
            return getAvatarGuid() == other.getAvatarGuid() && getEntityId() == other.getEntityId() && getAvatarSkillId() == other.getAvatarSkillId() && getSkillDepotId() == other.getSkillDepotId() && getOldLevel() == other.getOldLevel() && getCurLevel() == other.getCurLevel() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + Internal.hashLong(getAvatarGuid()))) + 12)) + getEntityId())) + 1)) + getAvatarSkillId())) + 5)) + getSkillDepotId())) + 6)) + getOldLevel())) + 2)) + getCurLevel())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AvatarSkillChangeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSkillChangeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSkillChangeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSkillChangeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSkillChangeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSkillChangeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSkillChangeNotify parseFrom(InputStream input) throws IOException {
            return (AvatarSkillChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarSkillChangeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSkillChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarSkillChangeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarSkillChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarSkillChangeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSkillChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarSkillChangeNotify parseFrom(CodedInputStream input) throws IOException {
            return (AvatarSkillChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarSkillChangeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSkillChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarSkillChangeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillChangeNotifyOuterClass$AvatarSkillChangeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarSkillChangeNotifyOrBuilder {
            private long avatarGuid_;
            private int entityId_;
            private int avatarSkillId_;
            private int skillDepotId_;
            private int oldLevel_;
            private int curLevel_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarSkillChangeNotifyOuterClass.internal_static_AvatarSkillChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarSkillChangeNotifyOuterClass.internal_static_AvatarSkillChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarSkillChangeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarSkillChangeNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.avatarGuid_ = 0;
                this.entityId_ = 0;
                this.avatarSkillId_ = 0;
                this.skillDepotId_ = 0;
                this.oldLevel_ = 0;
                this.curLevel_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarSkillChangeNotifyOuterClass.internal_static_AvatarSkillChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarSkillChangeNotify getDefaultInstanceForType() {
                return AvatarSkillChangeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarSkillChangeNotify build() {
                AvatarSkillChangeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarSkillChangeNotify buildPartial() {
                AvatarSkillChangeNotify result = new AvatarSkillChangeNotify(this);
                result.avatarGuid_ = this.avatarGuid_;
                result.entityId_ = this.entityId_;
                result.avatarSkillId_ = this.avatarSkillId_;
                result.skillDepotId_ = this.skillDepotId_;
                result.oldLevel_ = this.oldLevel_;
                result.curLevel_ = this.curLevel_;
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
                if (other instanceof AvatarSkillChangeNotify) {
                    return mergeFrom((AvatarSkillChangeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarSkillChangeNotify other) {
                if (other == AvatarSkillChangeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getAvatarSkillId() != 0) {
                    setAvatarSkillId(other.getAvatarSkillId());
                }
                if (other.getSkillDepotId() != 0) {
                    setSkillDepotId(other.getSkillDepotId());
                }
                if (other.getOldLevel() != 0) {
                    setOldLevel(other.getOldLevel());
                }
                if (other.getCurLevel() != 0) {
                    setCurLevel(other.getCurLevel());
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
                AvatarSkillChangeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarSkillChangeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarSkillChangeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillChangeNotifyOuterClass.AvatarSkillChangeNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarSkillChangeNotifyOuterClass.AvatarSkillChangeNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarSkillChangeNotifyOuterClass.AvatarSkillChangeNotifyOrBuilder
            public int getAvatarSkillId() {
                return this.avatarSkillId_;
            }

            public Builder setAvatarSkillId(int value) {
                this.avatarSkillId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarSkillId() {
                this.avatarSkillId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillChangeNotifyOuterClass.AvatarSkillChangeNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarSkillChangeNotifyOuterClass.AvatarSkillChangeNotifyOrBuilder
            public int getOldLevel() {
                return this.oldLevel_;
            }

            public Builder setOldLevel(int value) {
                this.oldLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearOldLevel() {
                this.oldLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillChangeNotifyOuterClass.AvatarSkillChangeNotifyOrBuilder
            public int getCurLevel() {
                return this.curLevel_;
            }

            public Builder setCurLevel(int value) {
                this.curLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurLevel() {
                this.curLevel_ = 0;
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

        public static AvatarSkillChangeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarSkillChangeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarSkillChangeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarSkillChangeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
