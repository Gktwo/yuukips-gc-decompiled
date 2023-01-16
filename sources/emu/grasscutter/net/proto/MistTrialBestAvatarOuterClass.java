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
import emu.grasscutter.net.proto.AvatarTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MistTrialBestAvatarOuterClass.class */
public final class MistTrialBestAvatarOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019MistTrialBestAvatar.proto\u001a\u0010AvatarType.proto\"^\n\u0013MistTrialBestAvatar\u0012\u0011\n\tavatar_id\u0018\u0004 \u0001(\r\u0012\u0012\n\ncostume_id\u0018\f \u0001(\r\u0012 \n\u000bavatar_type\u0018\u0006 \u0001(\u000e2\u000b.AvatarTypeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AvatarTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MistTrialBestAvatar_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MistTrialBestAvatar_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MistTrialBestAvatar_descriptor, new String[]{"AvatarId", "CostumeId", "AvatarType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MistTrialBestAvatarOuterClass$MistTrialBestAvatarOrBuilder.class */
    public interface MistTrialBestAvatarOrBuilder extends MessageOrBuilder {
        int getAvatarId();

        int getCostumeId();

        int getAvatarTypeValue();

        AvatarTypeOuterClass.AvatarType getAvatarType();
    }

    private MistTrialBestAvatarOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MistTrialBestAvatarOuterClass$MistTrialBestAvatar.class */
    public static final class MistTrialBestAvatar extends GeneratedMessageV3 implements MistTrialBestAvatarOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATAR_ID_FIELD_NUMBER = 4;
        private int avatarId_;
        public static final int COSTUME_ID_FIELD_NUMBER = 12;
        private int costumeId_;
        public static final int AVATAR_TYPE_FIELD_NUMBER = 6;
        private int avatarType_;
        private byte memoizedIsInitialized;
        private static final MistTrialBestAvatar DEFAULT_INSTANCE = new MistTrialBestAvatar();
        private static final Parser<MistTrialBestAvatar> PARSER = new AbstractParser<MistTrialBestAvatar>() { // from class: emu.grasscutter.net.proto.MistTrialBestAvatarOuterClass.MistTrialBestAvatar.1
            @Override // com.google.protobuf.Parser
            public MistTrialBestAvatar parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MistTrialBestAvatar(input, extensionRegistry);
            }
        };

        private MistTrialBestAvatar(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MistTrialBestAvatar() {
            this.memoizedIsInitialized = -1;
            this.avatarType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MistTrialBestAvatar();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MistTrialBestAvatar(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.avatarId_ = input.readUInt32();
                                break;
                            case 48:
                                this.avatarType_ = input.readEnum();
                                break;
                            case 96:
                                this.costumeId_ = input.readUInt32();
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
            return MistTrialBestAvatarOuterClass.internal_static_MistTrialBestAvatar_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MistTrialBestAvatarOuterClass.internal_static_MistTrialBestAvatar_fieldAccessorTable.ensureFieldAccessorsInitialized(MistTrialBestAvatar.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder
        public int getAvatarId() {
            return this.avatarId_;
        }

        @Override // emu.grasscutter.net.proto.MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder
        public int getCostumeId() {
            return this.costumeId_;
        }

        @Override // emu.grasscutter.net.proto.MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder
        public int getAvatarTypeValue() {
            return this.avatarType_;
        }

        @Override // emu.grasscutter.net.proto.MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder
        public AvatarTypeOuterClass.AvatarType getAvatarType() {
            AvatarTypeOuterClass.AvatarType result = AvatarTypeOuterClass.AvatarType.valueOf(this.avatarType_);
            return result == null ? AvatarTypeOuterClass.AvatarType.UNRECOGNIZED : result;
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
                output.writeUInt32(4, this.avatarId_);
            }
            if (this.avatarType_ != AvatarTypeOuterClass.AvatarType.AVATAR_TYPE_NONE.getNumber()) {
                output.writeEnum(6, this.avatarType_);
            }
            if (this.costumeId_ != 0) {
                output.writeUInt32(12, this.costumeId_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.avatarId_);
            }
            if (this.avatarType_ != AvatarTypeOuterClass.AvatarType.AVATAR_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(6, this.avatarType_);
            }
            if (this.costumeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.costumeId_);
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
            if (!(obj instanceof MistTrialBestAvatar)) {
                return equals(obj);
            }
            MistTrialBestAvatar other = (MistTrialBestAvatar) obj;
            return getAvatarId() == other.getAvatarId() && getCostumeId() == other.getCostumeId() && this.avatarType_ == other.avatarType_ && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getAvatarId())) + 12)) + getCostumeId())) + 6)) + this.avatarType_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MistTrialBestAvatar parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MistTrialBestAvatar parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MistTrialBestAvatar parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MistTrialBestAvatar parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MistTrialBestAvatar parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MistTrialBestAvatar parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MistTrialBestAvatar parseFrom(InputStream input) throws IOException {
            return (MistTrialBestAvatar) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MistTrialBestAvatar parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MistTrialBestAvatar) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MistTrialBestAvatar parseDelimitedFrom(InputStream input) throws IOException {
            return (MistTrialBestAvatar) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MistTrialBestAvatar parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MistTrialBestAvatar) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MistTrialBestAvatar parseFrom(CodedInputStream input) throws IOException {
            return (MistTrialBestAvatar) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MistTrialBestAvatar parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MistTrialBestAvatar) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MistTrialBestAvatar prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MistTrialBestAvatarOuterClass$MistTrialBestAvatar$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MistTrialBestAvatarOrBuilder {
            private int avatarId_;
            private int costumeId_;
            private int avatarType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return MistTrialBestAvatarOuterClass.internal_static_MistTrialBestAvatar_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MistTrialBestAvatarOuterClass.internal_static_MistTrialBestAvatar_fieldAccessorTable.ensureFieldAccessorsInitialized(MistTrialBestAvatar.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MistTrialBestAvatar.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.avatarId_ = 0;
                this.costumeId_ = 0;
                this.avatarType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MistTrialBestAvatarOuterClass.internal_static_MistTrialBestAvatar_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MistTrialBestAvatar getDefaultInstanceForType() {
                return MistTrialBestAvatar.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MistTrialBestAvatar build() {
                MistTrialBestAvatar result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MistTrialBestAvatar buildPartial() {
                MistTrialBestAvatar result = new MistTrialBestAvatar(this);
                result.avatarId_ = this.avatarId_;
                result.costumeId_ = this.costumeId_;
                result.avatarType_ = this.avatarType_;
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
                if (other instanceof MistTrialBestAvatar) {
                    return mergeFrom((MistTrialBestAvatar) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MistTrialBestAvatar other) {
                if (other == MistTrialBestAvatar.getDefaultInstance()) {
                    return this;
                }
                if (other.getAvatarId() != 0) {
                    setAvatarId(other.getAvatarId());
                }
                if (other.getCostumeId() != 0) {
                    setCostumeId(other.getCostumeId());
                }
                if (other.avatarType_ != 0) {
                    setAvatarTypeValue(other.getAvatarTypeValue());
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
                MistTrialBestAvatar parsedMessage = null;
                try {
                    try {
                        parsedMessage = MistTrialBestAvatar.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MistTrialBestAvatar) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder
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

            @Override // emu.grasscutter.net.proto.MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder
            public int getCostumeId() {
                return this.costumeId_;
            }

            public Builder setCostumeId(int value) {
                this.costumeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCostumeId() {
                this.costumeId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder
            public int getAvatarTypeValue() {
                return this.avatarType_;
            }

            public Builder setAvatarTypeValue(int value) {
                this.avatarType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MistTrialBestAvatarOuterClass.MistTrialBestAvatarOrBuilder
            public AvatarTypeOuterClass.AvatarType getAvatarType() {
                AvatarTypeOuterClass.AvatarType result = AvatarTypeOuterClass.AvatarType.valueOf(this.avatarType_);
                return result == null ? AvatarTypeOuterClass.AvatarType.UNRECOGNIZED : result;
            }

            public Builder setAvatarType(AvatarTypeOuterClass.AvatarType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.avatarType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearAvatarType() {
                this.avatarType_ = 0;
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

        public static MistTrialBestAvatar getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MistTrialBestAvatar> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MistTrialBestAvatar> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MistTrialBestAvatar getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AvatarTypeOuterClass.getDescriptor();
    }
}
