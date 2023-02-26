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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoinCollectTeamAvatarInfoOuterClass.class */
public final class CoinCollectTeamAvatarInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fCoinCollectTeamAvatarInfo.proto\"@\n\u0019CoinCollectTeamAvatarInfo\u0012\u0011\n\tcostumeId\u0018\u000f \u0001(\r\u0012\u0010\n\bavatarId\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CoinCollectTeamAvatarInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CoinCollectTeamAvatarInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CoinCollectTeamAvatarInfo_descriptor, new String[]{"CostumeId", "AvatarId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoinCollectTeamAvatarInfoOuterClass$CoinCollectTeamAvatarInfoOrBuilder.class */
    public interface CoinCollectTeamAvatarInfoOrBuilder extends MessageOrBuilder {
        int getCostumeId();

        int getAvatarId();
    }

    private CoinCollectTeamAvatarInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoinCollectTeamAvatarInfoOuterClass$CoinCollectTeamAvatarInfo.class */
    public static final class CoinCollectTeamAvatarInfo extends GeneratedMessageV3 implements CoinCollectTeamAvatarInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COSTUMEID_FIELD_NUMBER = 15;
        private int costumeId_;
        public static final int AVATARID_FIELD_NUMBER = 8;
        private int avatarId_;
        private byte memoizedIsInitialized;
        private static final CoinCollectTeamAvatarInfo DEFAULT_INSTANCE = new CoinCollectTeamAvatarInfo();
        private static final Parser<CoinCollectTeamAvatarInfo> PARSER = new AbstractParser<CoinCollectTeamAvatarInfo>() { // from class: emu.grasscutter.net.proto.CoinCollectTeamAvatarInfoOuterClass.CoinCollectTeamAvatarInfo.1
            @Override // com.google.protobuf.Parser
            public CoinCollectTeamAvatarInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CoinCollectTeamAvatarInfo(input, extensionRegistry);
            }
        };

        private CoinCollectTeamAvatarInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CoinCollectTeamAvatarInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CoinCollectTeamAvatarInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CoinCollectTeamAvatarInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 64:
                                this.avatarId_ = input.readUInt32();
                                break;
                            case 120:
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
            return CoinCollectTeamAvatarInfoOuterClass.internal_static_CoinCollectTeamAvatarInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CoinCollectTeamAvatarInfoOuterClass.internal_static_CoinCollectTeamAvatarInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CoinCollectTeamAvatarInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CoinCollectTeamAvatarInfoOuterClass.CoinCollectTeamAvatarInfoOrBuilder
        public int getCostumeId() {
            return this.costumeId_;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectTeamAvatarInfoOuterClass.CoinCollectTeamAvatarInfoOrBuilder
        public int getAvatarId() {
            return this.avatarId_;
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
                output.writeUInt32(8, this.avatarId_);
            }
            if (this.costumeId_ != 0) {
                output.writeUInt32(15, this.costumeId_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(8, this.avatarId_);
            }
            if (this.costumeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.costumeId_);
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
            if (!(obj instanceof CoinCollectTeamAvatarInfo)) {
                return equals(obj);
            }
            CoinCollectTeamAvatarInfo other = (CoinCollectTeamAvatarInfo) obj;
            return getCostumeId() == other.getCostumeId() && getAvatarId() == other.getAvatarId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getCostumeId())) + 8)) + getAvatarId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static CoinCollectTeamAvatarInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CoinCollectTeamAvatarInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CoinCollectTeamAvatarInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CoinCollectTeamAvatarInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CoinCollectTeamAvatarInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CoinCollectTeamAvatarInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CoinCollectTeamAvatarInfo parseFrom(InputStream input) throws IOException {
            return (CoinCollectTeamAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CoinCollectTeamAvatarInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CoinCollectTeamAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CoinCollectTeamAvatarInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CoinCollectTeamAvatarInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CoinCollectTeamAvatarInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CoinCollectTeamAvatarInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CoinCollectTeamAvatarInfo parseFrom(CodedInputStream input) throws IOException {
            return (CoinCollectTeamAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CoinCollectTeamAvatarInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CoinCollectTeamAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CoinCollectTeamAvatarInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoinCollectTeamAvatarInfoOuterClass$CoinCollectTeamAvatarInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CoinCollectTeamAvatarInfoOrBuilder {
            private int costumeId_;
            private int avatarId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CoinCollectTeamAvatarInfoOuterClass.internal_static_CoinCollectTeamAvatarInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CoinCollectTeamAvatarInfoOuterClass.internal_static_CoinCollectTeamAvatarInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CoinCollectTeamAvatarInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CoinCollectTeamAvatarInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.costumeId_ = 0;
                this.avatarId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CoinCollectTeamAvatarInfoOuterClass.internal_static_CoinCollectTeamAvatarInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CoinCollectTeamAvatarInfo getDefaultInstanceForType() {
                return CoinCollectTeamAvatarInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CoinCollectTeamAvatarInfo build() {
                CoinCollectTeamAvatarInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CoinCollectTeamAvatarInfo buildPartial() {
                CoinCollectTeamAvatarInfo result = new CoinCollectTeamAvatarInfo(this);
                result.costumeId_ = this.costumeId_;
                result.avatarId_ = this.avatarId_;
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
                if (other instanceof CoinCollectTeamAvatarInfo) {
                    return mergeFrom((CoinCollectTeamAvatarInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CoinCollectTeamAvatarInfo other) {
                if (other == CoinCollectTeamAvatarInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getCostumeId() != 0) {
                    setCostumeId(other.getCostumeId());
                }
                if (other.getAvatarId() != 0) {
                    setAvatarId(other.getAvatarId());
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
                CoinCollectTeamAvatarInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CoinCollectTeamAvatarInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CoinCollectTeamAvatarInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CoinCollectTeamAvatarInfoOuterClass.CoinCollectTeamAvatarInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.CoinCollectTeamAvatarInfoOuterClass.CoinCollectTeamAvatarInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static CoinCollectTeamAvatarInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CoinCollectTeamAvatarInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CoinCollectTeamAvatarInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CoinCollectTeamAvatarInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
