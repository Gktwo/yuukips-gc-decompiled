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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFetterLevelRewardRspOuterClass.class */
public final class AvatarFetterLevelRewardRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n AvatarFetterLevelRewardRsp.proto\"h\n\u001aAvatarFetterLevelRewardRsp\u0012\u0010\n\brewardId\u0018\u000f \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u000e \u0001(\u0005\u0012\u0013\n\u000bfetterLevel\u0018\u0002 \u0001(\r\u0012\u0012\n\navatarGuid\u0018\u0006 \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarFetterLevelRewardRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarFetterLevelRewardRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarFetterLevelRewardRsp_descriptor, new String[]{"RewardId", "Retcode", "FetterLevel", "AvatarGuid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFetterLevelRewardRspOuterClass$AvatarFetterLevelRewardRspOrBuilder.class */
    public interface AvatarFetterLevelRewardRspOrBuilder extends MessageOrBuilder {
        int getRewardId();

        int getRetcode();

        int getFetterLevel();

        long getAvatarGuid();
    }

    private AvatarFetterLevelRewardRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFetterLevelRewardRspOuterClass$AvatarFetterLevelRewardRsp.class */
    public static final class AvatarFetterLevelRewardRsp extends GeneratedMessageV3 implements AvatarFetterLevelRewardRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int REWARDID_FIELD_NUMBER = 15;
        private int rewardId_;
        public static final int RETCODE_FIELD_NUMBER = 14;
        private int retcode_;
        public static final int FETTERLEVEL_FIELD_NUMBER = 2;
        private int fetterLevel_;
        public static final int AVATARGUID_FIELD_NUMBER = 6;
        private long avatarGuid_;
        private byte memoizedIsInitialized;
        private static final AvatarFetterLevelRewardRsp DEFAULT_INSTANCE = new AvatarFetterLevelRewardRsp();
        private static final Parser<AvatarFetterLevelRewardRsp> PARSER = new AbstractParser<AvatarFetterLevelRewardRsp>() { // from class: emu.grasscutter.net.proto.AvatarFetterLevelRewardRspOuterClass.AvatarFetterLevelRewardRsp.1
            @Override // com.google.protobuf.Parser
            public AvatarFetterLevelRewardRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarFetterLevelRewardRsp(input, extensionRegistry);
            }
        };

        private AvatarFetterLevelRewardRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarFetterLevelRewardRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarFetterLevelRewardRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarFetterLevelRewardRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.fetterLevel_ = input.readUInt32();
                                    break;
                                case 48:
                                    this.avatarGuid_ = input.readUInt64();
                                    break;
                                case 112:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 120:
                                    this.rewardId_ = input.readUInt32();
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
            return AvatarFetterLevelRewardRspOuterClass.internal_static_AvatarFetterLevelRewardRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarFetterLevelRewardRspOuterClass.internal_static_AvatarFetterLevelRewardRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarFetterLevelRewardRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterLevelRewardRspOuterClass.AvatarFetterLevelRewardRspOrBuilder
        public int getRewardId() {
            return this.rewardId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterLevelRewardRspOuterClass.AvatarFetterLevelRewardRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterLevelRewardRspOuterClass.AvatarFetterLevelRewardRspOrBuilder
        public int getFetterLevel() {
            return this.fetterLevel_;
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterLevelRewardRspOuterClass.AvatarFetterLevelRewardRspOrBuilder
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
            if (this.fetterLevel_ != 0) {
                output.writeUInt32(2, this.fetterLevel_);
            }
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(6, this.avatarGuid_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(14, this.retcode_);
            }
            if (this.rewardId_ != 0) {
                output.writeUInt32(15, this.rewardId_);
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
            if (this.fetterLevel_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.fetterLevel_);
            }
            if (this.avatarGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(6, this.avatarGuid_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(14, this.retcode_);
            }
            if (this.rewardId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.rewardId_);
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
            if (!(obj instanceof AvatarFetterLevelRewardRsp)) {
                return equals(obj);
            }
            AvatarFetterLevelRewardRsp other = (AvatarFetterLevelRewardRsp) obj;
            return getRewardId() == other.getRewardId() && getRetcode() == other.getRetcode() && getFetterLevel() == other.getFetterLevel() && getAvatarGuid() == other.getAvatarGuid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getRewardId())) + 14)) + getRetcode())) + 2)) + getFetterLevel())) + 6)) + Internal.hashLong(getAvatarGuid()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AvatarFetterLevelRewardRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarFetterLevelRewardRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarFetterLevelRewardRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarFetterLevelRewardRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarFetterLevelRewardRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarFetterLevelRewardRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarFetterLevelRewardRsp parseFrom(InputStream input) throws IOException {
            return (AvatarFetterLevelRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarFetterLevelRewardRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarFetterLevelRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarFetterLevelRewardRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarFetterLevelRewardRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarFetterLevelRewardRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarFetterLevelRewardRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarFetterLevelRewardRsp parseFrom(CodedInputStream input) throws IOException {
            return (AvatarFetterLevelRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarFetterLevelRewardRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarFetterLevelRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarFetterLevelRewardRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFetterLevelRewardRspOuterClass$AvatarFetterLevelRewardRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarFetterLevelRewardRspOrBuilder {
            private int rewardId_;
            private int retcode_;
            private int fetterLevel_;
            private long avatarGuid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarFetterLevelRewardRspOuterClass.internal_static_AvatarFetterLevelRewardRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarFetterLevelRewardRspOuterClass.internal_static_AvatarFetterLevelRewardRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarFetterLevelRewardRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarFetterLevelRewardRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.rewardId_ = 0;
                this.retcode_ = 0;
                this.fetterLevel_ = 0;
                this.avatarGuid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarFetterLevelRewardRspOuterClass.internal_static_AvatarFetterLevelRewardRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarFetterLevelRewardRsp getDefaultInstanceForType() {
                return AvatarFetterLevelRewardRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarFetterLevelRewardRsp build() {
                AvatarFetterLevelRewardRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarFetterLevelRewardRsp buildPartial() {
                AvatarFetterLevelRewardRsp result = new AvatarFetterLevelRewardRsp(this);
                result.rewardId_ = this.rewardId_;
                result.retcode_ = this.retcode_;
                result.fetterLevel_ = this.fetterLevel_;
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
                if (other instanceof AvatarFetterLevelRewardRsp) {
                    return mergeFrom((AvatarFetterLevelRewardRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarFetterLevelRewardRsp other) {
                if (other == AvatarFetterLevelRewardRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRewardId() != 0) {
                    setRewardId(other.getRewardId());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getFetterLevel() != 0) {
                    setFetterLevel(other.getFetterLevel());
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
                AvatarFetterLevelRewardRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarFetterLevelRewardRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarFetterLevelRewardRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterLevelRewardRspOuterClass.AvatarFetterLevelRewardRspOrBuilder
            public int getRewardId() {
                return this.rewardId_;
            }

            public Builder setRewardId(int value) {
                this.rewardId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRewardId() {
                this.rewardId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterLevelRewardRspOuterClass.AvatarFetterLevelRewardRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarFetterLevelRewardRspOuterClass.AvatarFetterLevelRewardRspOrBuilder
            public int getFetterLevel() {
                return this.fetterLevel_;
            }

            public Builder setFetterLevel(int value) {
                this.fetterLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearFetterLevel() {
                this.fetterLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterLevelRewardRspOuterClass.AvatarFetterLevelRewardRspOrBuilder
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

        public static AvatarFetterLevelRewardRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarFetterLevelRewardRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarFetterLevelRewardRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarFetterLevelRewardRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
