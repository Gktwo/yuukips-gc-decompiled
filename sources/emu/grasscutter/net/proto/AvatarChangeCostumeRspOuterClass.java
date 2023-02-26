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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarChangeCostumeRspOuterClass.class */
public final class AvatarChangeCostumeRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cAvatarChangeCostumeRsp.proto\"P\n\u0016AvatarChangeCostumeRsp\u0012\u0011\n\tcostumeId\u0018\u000f \u0001(\r\u0012\u0012\n\navatarGuid\u0018\u0005 \u0001(\u0004\u0012\u000f\n\u0007retcode\u0018\u0007 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarChangeCostumeRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarChangeCostumeRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarChangeCostumeRsp_descriptor, new String[]{"CostumeId", "AvatarGuid", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarChangeCostumeRspOuterClass$AvatarChangeCostumeRspOrBuilder.class */
    public interface AvatarChangeCostumeRspOrBuilder extends MessageOrBuilder {
        int getCostumeId();

        long getAvatarGuid();

        int getRetcode();
    }

    private AvatarChangeCostumeRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarChangeCostumeRspOuterClass$AvatarChangeCostumeRsp.class */
    public static final class AvatarChangeCostumeRsp extends GeneratedMessageV3 implements AvatarChangeCostumeRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COSTUMEID_FIELD_NUMBER = 15;
        private int costumeId_;
        public static final int AVATARGUID_FIELD_NUMBER = 5;
        private long avatarGuid_;
        public static final int RETCODE_FIELD_NUMBER = 7;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final AvatarChangeCostumeRsp DEFAULT_INSTANCE = new AvatarChangeCostumeRsp();
        private static final Parser<AvatarChangeCostumeRsp> PARSER = new AbstractParser<AvatarChangeCostumeRsp>() { // from class: emu.grasscutter.net.proto.AvatarChangeCostumeRspOuterClass.AvatarChangeCostumeRsp.1
            @Override // com.google.protobuf.Parser
            public AvatarChangeCostumeRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarChangeCostumeRsp(input, extensionRegistry);
            }
        };

        private AvatarChangeCostumeRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarChangeCostumeRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarChangeCostumeRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarChangeCostumeRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    this.avatarGuid_ = input.readUInt64();
                                    break;
                                case 56:
                                    this.retcode_ = input.readInt32();
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
            return AvatarChangeCostumeRspOuterClass.internal_static_AvatarChangeCostumeRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarChangeCostumeRspOuterClass.internal_static_AvatarChangeCostumeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarChangeCostumeRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarChangeCostumeRspOuterClass.AvatarChangeCostumeRspOrBuilder
        public int getCostumeId() {
            return this.costumeId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarChangeCostumeRspOuterClass.AvatarChangeCostumeRspOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.AvatarChangeCostumeRspOuterClass.AvatarChangeCostumeRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
                output.writeUInt64(5, this.avatarGuid_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(7, this.retcode_);
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
            if (this.avatarGuid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(5, this.avatarGuid_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(7, this.retcode_);
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
            if (!(obj instanceof AvatarChangeCostumeRsp)) {
                return equals(obj);
            }
            AvatarChangeCostumeRsp other = (AvatarChangeCostumeRsp) obj;
            return getCostumeId() == other.getCostumeId() && getAvatarGuid() == other.getAvatarGuid() && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getCostumeId())) + 5)) + Internal.hashLong(getAvatarGuid()))) + 7)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AvatarChangeCostumeRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarChangeCostumeRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarChangeCostumeRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarChangeCostumeRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarChangeCostumeRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarChangeCostumeRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarChangeCostumeRsp parseFrom(InputStream input) throws IOException {
            return (AvatarChangeCostumeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarChangeCostumeRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarChangeCostumeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarChangeCostumeRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarChangeCostumeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarChangeCostumeRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarChangeCostumeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarChangeCostumeRsp parseFrom(CodedInputStream input) throws IOException {
            return (AvatarChangeCostumeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarChangeCostumeRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarChangeCostumeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarChangeCostumeRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarChangeCostumeRspOuterClass$AvatarChangeCostumeRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarChangeCostumeRspOrBuilder {
            private int costumeId_;
            private long avatarGuid_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarChangeCostumeRspOuterClass.internal_static_AvatarChangeCostumeRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarChangeCostumeRspOuterClass.internal_static_AvatarChangeCostumeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarChangeCostumeRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarChangeCostumeRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.costumeId_ = 0;
                this.avatarGuid_ = 0;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarChangeCostumeRspOuterClass.internal_static_AvatarChangeCostumeRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarChangeCostumeRsp getDefaultInstanceForType() {
                return AvatarChangeCostumeRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarChangeCostumeRsp build() {
                AvatarChangeCostumeRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarChangeCostumeRsp buildPartial() {
                AvatarChangeCostumeRsp result = new AvatarChangeCostumeRsp(this);
                result.costumeId_ = this.costumeId_;
                result.avatarGuid_ = this.avatarGuid_;
                result.retcode_ = this.retcode_;
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
                if (other instanceof AvatarChangeCostumeRsp) {
                    return mergeFrom((AvatarChangeCostumeRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarChangeCostumeRsp other) {
                if (other == AvatarChangeCostumeRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getCostumeId() != 0) {
                    setCostumeId(other.getCostumeId());
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                AvatarChangeCostumeRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarChangeCostumeRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarChangeCostumeRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarChangeCostumeRspOuterClass.AvatarChangeCostumeRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarChangeCostumeRspOuterClass.AvatarChangeCostumeRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarChangeCostumeRspOuterClass.AvatarChangeCostumeRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static AvatarChangeCostumeRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarChangeCostumeRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarChangeCostumeRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarChangeCostumeRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
