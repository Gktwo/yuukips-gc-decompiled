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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillUpgradeRspOuterClass.class */
public final class AvatarSkillUpgradeRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bAvatarSkillUpgradeRsp.proto\"w\n\u0015AvatarSkillUpgradeRsp\u0012\u000f\n\u0007retcode\u0018\u0005 \u0001(\u0005\u0012\u0010\n\bcurLevel\u0018\u0002 \u0001(\r\u0012\u0015\n\ravatarSkillId\u0018\u000f \u0001(\r\u0012\u0012\n\navatarGuid\u0018\u0007 \u0001(\u0004\u0012\u0010\n\boldLevel\u0018\u0001 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarSkillUpgradeRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarSkillUpgradeRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarSkillUpgradeRsp_descriptor, new String[]{"Retcode", "CurLevel", "AvatarSkillId", "AvatarGuid", "OldLevel"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillUpgradeRspOuterClass$AvatarSkillUpgradeRspOrBuilder.class */
    public interface AvatarSkillUpgradeRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getCurLevel();

        int getAvatarSkillId();

        long getAvatarGuid();

        int getOldLevel();
    }

    private AvatarSkillUpgradeRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillUpgradeRspOuterClass$AvatarSkillUpgradeRsp.class */
    public static final class AvatarSkillUpgradeRsp extends GeneratedMessageV3 implements AvatarSkillUpgradeRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 5;
        private int retcode_;
        public static final int CURLEVEL_FIELD_NUMBER = 2;
        private int curLevel_;
        public static final int AVATARSKILLID_FIELD_NUMBER = 15;
        private int avatarSkillId_;
        public static final int AVATARGUID_FIELD_NUMBER = 7;
        private long avatarGuid_;
        public static final int OLDLEVEL_FIELD_NUMBER = 1;
        private int oldLevel_;
        private byte memoizedIsInitialized;
        private static final AvatarSkillUpgradeRsp DEFAULT_INSTANCE = new AvatarSkillUpgradeRsp();
        private static final Parser<AvatarSkillUpgradeRsp> PARSER = new AbstractParser<AvatarSkillUpgradeRsp>() { // from class: emu.grasscutter.net.proto.AvatarSkillUpgradeRspOuterClass.AvatarSkillUpgradeRsp.1
            @Override // com.google.protobuf.Parser
            public AvatarSkillUpgradeRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarSkillUpgradeRsp(input, extensionRegistry);
            }
        };

        private AvatarSkillUpgradeRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarSkillUpgradeRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarSkillUpgradeRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarSkillUpgradeRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.oldLevel_ = input.readUInt32();
                                break;
                            case 16:
                                this.curLevel_ = input.readUInt32();
                                break;
                            case 40:
                                this.retcode_ = input.readInt32();
                                break;
                            case 56:
                                this.avatarGuid_ = input.readUInt64();
                                break;
                            case 120:
                                this.avatarSkillId_ = input.readUInt32();
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
            return AvatarSkillUpgradeRspOuterClass.internal_static_AvatarSkillUpgradeRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarSkillUpgradeRspOuterClass.internal_static_AvatarSkillUpgradeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarSkillUpgradeRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillUpgradeRspOuterClass.AvatarSkillUpgradeRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillUpgradeRspOuterClass.AvatarSkillUpgradeRspOrBuilder
        public int getCurLevel() {
            return this.curLevel_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillUpgradeRspOuterClass.AvatarSkillUpgradeRspOrBuilder
        public int getAvatarSkillId() {
            return this.avatarSkillId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillUpgradeRspOuterClass.AvatarSkillUpgradeRspOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillUpgradeRspOuterClass.AvatarSkillUpgradeRspOrBuilder
        public int getOldLevel() {
            return this.oldLevel_;
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
            if (this.oldLevel_ != 0) {
                output.writeUInt32(1, this.oldLevel_);
            }
            if (this.curLevel_ != 0) {
                output.writeUInt32(2, this.curLevel_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(5, this.retcode_);
            }
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(7, this.avatarGuid_);
            }
            if (this.avatarSkillId_ != 0) {
                output.writeUInt32(15, this.avatarSkillId_);
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
            if (this.oldLevel_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.oldLevel_);
            }
            if (this.curLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.curLevel_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(5, this.retcode_);
            }
            if (this.avatarGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(7, this.avatarGuid_);
            }
            if (this.avatarSkillId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.avatarSkillId_);
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
            if (!(obj instanceof AvatarSkillUpgradeRsp)) {
                return equals(obj);
            }
            AvatarSkillUpgradeRsp other = (AvatarSkillUpgradeRsp) obj;
            return getRetcode() == other.getRetcode() && getCurLevel() == other.getCurLevel() && getAvatarSkillId() == other.getAvatarSkillId() && getAvatarGuid() == other.getAvatarGuid() && getOldLevel() == other.getOldLevel() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getRetcode())) + 2)) + getCurLevel())) + 15)) + getAvatarSkillId())) + 7)) + Internal.hashLong(getAvatarGuid()))) + 1)) + getOldLevel())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AvatarSkillUpgradeRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSkillUpgradeRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSkillUpgradeRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSkillUpgradeRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSkillUpgradeRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSkillUpgradeRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSkillUpgradeRsp parseFrom(InputStream input) throws IOException {
            return (AvatarSkillUpgradeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarSkillUpgradeRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSkillUpgradeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarSkillUpgradeRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarSkillUpgradeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarSkillUpgradeRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSkillUpgradeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarSkillUpgradeRsp parseFrom(CodedInputStream input) throws IOException {
            return (AvatarSkillUpgradeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarSkillUpgradeRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSkillUpgradeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarSkillUpgradeRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillUpgradeRspOuterClass$AvatarSkillUpgradeRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarSkillUpgradeRspOrBuilder {
            private int retcode_;
            private int curLevel_;
            private int avatarSkillId_;
            private long avatarGuid_;
            private int oldLevel_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarSkillUpgradeRspOuterClass.internal_static_AvatarSkillUpgradeRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarSkillUpgradeRspOuterClass.internal_static_AvatarSkillUpgradeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarSkillUpgradeRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarSkillUpgradeRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.curLevel_ = 0;
                this.avatarSkillId_ = 0;
                this.avatarGuid_ = 0;
                this.oldLevel_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarSkillUpgradeRspOuterClass.internal_static_AvatarSkillUpgradeRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarSkillUpgradeRsp getDefaultInstanceForType() {
                return AvatarSkillUpgradeRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarSkillUpgradeRsp build() {
                AvatarSkillUpgradeRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarSkillUpgradeRsp buildPartial() {
                AvatarSkillUpgradeRsp result = new AvatarSkillUpgradeRsp(this);
                result.retcode_ = this.retcode_;
                result.curLevel_ = this.curLevel_;
                result.avatarSkillId_ = this.avatarSkillId_;
                result.avatarGuid_ = this.avatarGuid_;
                result.oldLevel_ = this.oldLevel_;
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
                if (other instanceof AvatarSkillUpgradeRsp) {
                    return mergeFrom((AvatarSkillUpgradeRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarSkillUpgradeRsp other) {
                if (other == AvatarSkillUpgradeRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getCurLevel() != 0) {
                    setCurLevel(other.getCurLevel());
                }
                if (other.getAvatarSkillId() != 0) {
                    setAvatarSkillId(other.getAvatarSkillId());
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                if (other.getOldLevel() != 0) {
                    setOldLevel(other.getOldLevel());
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
                AvatarSkillUpgradeRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarSkillUpgradeRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarSkillUpgradeRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillUpgradeRspOuterClass.AvatarSkillUpgradeRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarSkillUpgradeRspOuterClass.AvatarSkillUpgradeRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarSkillUpgradeRspOuterClass.AvatarSkillUpgradeRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarSkillUpgradeRspOuterClass.AvatarSkillUpgradeRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarSkillUpgradeRspOuterClass.AvatarSkillUpgradeRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static AvatarSkillUpgradeRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarSkillUpgradeRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarSkillUpgradeRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarSkillUpgradeRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
