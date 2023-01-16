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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ProudSkillExtraLevelNotifyOuterClass.class */
public final class ProudSkillExtraLevelNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n ProudSkillExtraLevelNotify.proto\"q\n\u001aProudSkillExtraLevelNotify\u0012\u0013\n\u000bavatar_guid\u0018\r \u0001(\u0004\u0012\u0013\n\u000bextra_level\u0018\u0004 \u0001(\r\u0012\u0013\n\u000btalent_type\u0018\b \u0001(\r\u0012\u0014\n\ftalent_index\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ProudSkillExtraLevelNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ProudSkillExtraLevelNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ProudSkillExtraLevelNotify_descriptor, new String[]{"AvatarGuid", "ExtraLevel", "TalentType", "TalentIndex"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ProudSkillExtraLevelNotifyOuterClass$ProudSkillExtraLevelNotifyOrBuilder.class */
    public interface ProudSkillExtraLevelNotifyOrBuilder extends MessageOrBuilder {
        long getAvatarGuid();

        int getExtraLevel();

        int getTalentType();

        int getTalentIndex();
    }

    private ProudSkillExtraLevelNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ProudSkillExtraLevelNotifyOuterClass$ProudSkillExtraLevelNotify.class */
    public static final class ProudSkillExtraLevelNotify extends GeneratedMessageV3 implements ProudSkillExtraLevelNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATAR_GUID_FIELD_NUMBER = 13;
        private long avatarGuid_;
        public static final int EXTRA_LEVEL_FIELD_NUMBER = 4;
        private int extraLevel_;
        public static final int TALENT_TYPE_FIELD_NUMBER = 8;
        private int talentType_;
        public static final int TALENT_INDEX_FIELD_NUMBER = 2;
        private int talentIndex_;
        private byte memoizedIsInitialized;
        private static final ProudSkillExtraLevelNotify DEFAULT_INSTANCE = new ProudSkillExtraLevelNotify();
        private static final Parser<ProudSkillExtraLevelNotify> PARSER = new AbstractParser<ProudSkillExtraLevelNotify>() { // from class: emu.grasscutter.net.proto.ProudSkillExtraLevelNotifyOuterClass.ProudSkillExtraLevelNotify.1
            @Override // com.google.protobuf.Parser
            public ProudSkillExtraLevelNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ProudSkillExtraLevelNotify(input, extensionRegistry);
            }
        };

        private ProudSkillExtraLevelNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ProudSkillExtraLevelNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ProudSkillExtraLevelNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ProudSkillExtraLevelNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.talentIndex_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.extraLevel_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.talentType_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.avatarGuid_ = input.readUInt64();
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
            return ProudSkillExtraLevelNotifyOuterClass.internal_static_ProudSkillExtraLevelNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ProudSkillExtraLevelNotifyOuterClass.internal_static_ProudSkillExtraLevelNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ProudSkillExtraLevelNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ProudSkillExtraLevelNotifyOuterClass.ProudSkillExtraLevelNotifyOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.ProudSkillExtraLevelNotifyOuterClass.ProudSkillExtraLevelNotifyOrBuilder
        public int getExtraLevel() {
            return this.extraLevel_;
        }

        @Override // emu.grasscutter.net.proto.ProudSkillExtraLevelNotifyOuterClass.ProudSkillExtraLevelNotifyOrBuilder
        public int getTalentType() {
            return this.talentType_;
        }

        @Override // emu.grasscutter.net.proto.ProudSkillExtraLevelNotifyOuterClass.ProudSkillExtraLevelNotifyOrBuilder
        public int getTalentIndex() {
            return this.talentIndex_;
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
            if (this.talentIndex_ != 0) {
                output.writeUInt32(2, this.talentIndex_);
            }
            if (this.extraLevel_ != 0) {
                output.writeUInt32(4, this.extraLevel_);
            }
            if (this.talentType_ != 0) {
                output.writeUInt32(8, this.talentType_);
            }
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(13, this.avatarGuid_);
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
            if (this.talentIndex_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.talentIndex_);
            }
            if (this.extraLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.extraLevel_);
            }
            if (this.talentType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.talentType_);
            }
            if (this.avatarGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(13, this.avatarGuid_);
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
            if (!(obj instanceof ProudSkillExtraLevelNotify)) {
                return equals(obj);
            }
            ProudSkillExtraLevelNotify other = (ProudSkillExtraLevelNotify) obj;
            return getAvatarGuid() == other.getAvatarGuid() && getExtraLevel() == other.getExtraLevel() && getTalentType() == other.getTalentType() && getTalentIndex() == other.getTalentIndex() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + Internal.hashLong(getAvatarGuid()))) + 4)) + getExtraLevel())) + 8)) + getTalentType())) + 2)) + getTalentIndex())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ProudSkillExtraLevelNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ProudSkillExtraLevelNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ProudSkillExtraLevelNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ProudSkillExtraLevelNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ProudSkillExtraLevelNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ProudSkillExtraLevelNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ProudSkillExtraLevelNotify parseFrom(InputStream input) throws IOException {
            return (ProudSkillExtraLevelNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ProudSkillExtraLevelNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ProudSkillExtraLevelNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ProudSkillExtraLevelNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ProudSkillExtraLevelNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ProudSkillExtraLevelNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ProudSkillExtraLevelNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ProudSkillExtraLevelNotify parseFrom(CodedInputStream input) throws IOException {
            return (ProudSkillExtraLevelNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ProudSkillExtraLevelNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ProudSkillExtraLevelNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ProudSkillExtraLevelNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ProudSkillExtraLevelNotifyOuterClass$ProudSkillExtraLevelNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ProudSkillExtraLevelNotifyOrBuilder {
            private long avatarGuid_;
            private int extraLevel_;
            private int talentType_;
            private int talentIndex_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ProudSkillExtraLevelNotifyOuterClass.internal_static_ProudSkillExtraLevelNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ProudSkillExtraLevelNotifyOuterClass.internal_static_ProudSkillExtraLevelNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ProudSkillExtraLevelNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ProudSkillExtraLevelNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.avatarGuid_ = 0;
                this.extraLevel_ = 0;
                this.talentType_ = 0;
                this.talentIndex_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ProudSkillExtraLevelNotifyOuterClass.internal_static_ProudSkillExtraLevelNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ProudSkillExtraLevelNotify getDefaultInstanceForType() {
                return ProudSkillExtraLevelNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ProudSkillExtraLevelNotify build() {
                ProudSkillExtraLevelNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ProudSkillExtraLevelNotify buildPartial() {
                ProudSkillExtraLevelNotify result = new ProudSkillExtraLevelNotify(this);
                result.avatarGuid_ = this.avatarGuid_;
                result.extraLevel_ = this.extraLevel_;
                result.talentType_ = this.talentType_;
                result.talentIndex_ = this.talentIndex_;
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
                if (other instanceof ProudSkillExtraLevelNotify) {
                    return mergeFrom((ProudSkillExtraLevelNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ProudSkillExtraLevelNotify other) {
                if (other == ProudSkillExtraLevelNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                if (other.getExtraLevel() != 0) {
                    setExtraLevel(other.getExtraLevel());
                }
                if (other.getTalentType() != 0) {
                    setTalentType(other.getTalentType());
                }
                if (other.getTalentIndex() != 0) {
                    setTalentIndex(other.getTalentIndex());
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
                ProudSkillExtraLevelNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ProudSkillExtraLevelNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ProudSkillExtraLevelNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ProudSkillExtraLevelNotifyOuterClass.ProudSkillExtraLevelNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.ProudSkillExtraLevelNotifyOuterClass.ProudSkillExtraLevelNotifyOrBuilder
            public int getExtraLevel() {
                return this.extraLevel_;
            }

            public Builder setExtraLevel(int value) {
                this.extraLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearExtraLevel() {
                this.extraLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ProudSkillExtraLevelNotifyOuterClass.ProudSkillExtraLevelNotifyOrBuilder
            public int getTalentType() {
                return this.talentType_;
            }

            public Builder setTalentType(int value) {
                this.talentType_ = value;
                onChanged();
                return this;
            }

            public Builder clearTalentType() {
                this.talentType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ProudSkillExtraLevelNotifyOuterClass.ProudSkillExtraLevelNotifyOrBuilder
            public int getTalentIndex() {
                return this.talentIndex_;
            }

            public Builder setTalentIndex(int value) {
                this.talentIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearTalentIndex() {
                this.talentIndex_ = 0;
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

        public static ProudSkillExtraLevelNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ProudSkillExtraLevelNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ProudSkillExtraLevelNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ProudSkillExtraLevelNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
