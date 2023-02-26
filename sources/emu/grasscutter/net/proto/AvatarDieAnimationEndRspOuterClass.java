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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarDieAnimationEndRspOuterClass.class */
public final class AvatarDieAnimationEndRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eAvatarDieAnimationEndRsp.proto\"M\n\u0018AvatarDieAnimationEndRsp\u0012\u000f\n\u0007dieGuid\u0018\u0003 \u0001(\u0004\u0012\u000f\n\u0007skillId\u0018\u0006 \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u0005 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarDieAnimationEndRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarDieAnimationEndRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarDieAnimationEndRsp_descriptor, new String[]{"DieGuid", "SkillId", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarDieAnimationEndRspOuterClass$AvatarDieAnimationEndRspOrBuilder.class */
    public interface AvatarDieAnimationEndRspOrBuilder extends MessageOrBuilder {
        long getDieGuid();

        int getSkillId();

        int getRetcode();
    }

    private AvatarDieAnimationEndRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarDieAnimationEndRspOuterClass$AvatarDieAnimationEndRsp.class */
    public static final class AvatarDieAnimationEndRsp extends GeneratedMessageV3 implements AvatarDieAnimationEndRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DIEGUID_FIELD_NUMBER = 3;
        private long dieGuid_;
        public static final int SKILLID_FIELD_NUMBER = 6;
        private int skillId_;
        public static final int RETCODE_FIELD_NUMBER = 5;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final AvatarDieAnimationEndRsp DEFAULT_INSTANCE = new AvatarDieAnimationEndRsp();
        private static final Parser<AvatarDieAnimationEndRsp> PARSER = new AbstractParser<AvatarDieAnimationEndRsp>() { // from class: emu.grasscutter.net.proto.AvatarDieAnimationEndRspOuterClass.AvatarDieAnimationEndRsp.1
            @Override // com.google.protobuf.Parser
            public AvatarDieAnimationEndRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarDieAnimationEndRsp(input, extensionRegistry);
            }
        };

        private AvatarDieAnimationEndRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarDieAnimationEndRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarDieAnimationEndRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarDieAnimationEndRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.dieGuid_ = input.readUInt64();
                                    break;
                                case 40:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 48:
                                    this.skillId_ = input.readUInt32();
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
            return AvatarDieAnimationEndRspOuterClass.internal_static_AvatarDieAnimationEndRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarDieAnimationEndRspOuterClass.internal_static_AvatarDieAnimationEndRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarDieAnimationEndRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarDieAnimationEndRspOuterClass.AvatarDieAnimationEndRspOrBuilder
        public long getDieGuid() {
            return this.dieGuid_;
        }

        @Override // emu.grasscutter.net.proto.AvatarDieAnimationEndRspOuterClass.AvatarDieAnimationEndRspOrBuilder
        public int getSkillId() {
            return this.skillId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarDieAnimationEndRspOuterClass.AvatarDieAnimationEndRspOrBuilder
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
            if (this.dieGuid_ != 0) {
                output.writeUInt64(3, this.dieGuid_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(5, this.retcode_);
            }
            if (this.skillId_ != 0) {
                output.writeUInt32(6, this.skillId_);
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
            if (this.dieGuid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(3, this.dieGuid_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(5, this.retcode_);
            }
            if (this.skillId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.skillId_);
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
            if (!(obj instanceof AvatarDieAnimationEndRsp)) {
                return equals(obj);
            }
            AvatarDieAnimationEndRsp other = (AvatarDieAnimationEndRsp) obj;
            return getDieGuid() == other.getDieGuid() && getSkillId() == other.getSkillId() && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + Internal.hashLong(getDieGuid()))) + 6)) + getSkillId())) + 5)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AvatarDieAnimationEndRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarDieAnimationEndRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarDieAnimationEndRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarDieAnimationEndRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarDieAnimationEndRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarDieAnimationEndRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarDieAnimationEndRsp parseFrom(InputStream input) throws IOException {
            return (AvatarDieAnimationEndRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarDieAnimationEndRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarDieAnimationEndRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarDieAnimationEndRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarDieAnimationEndRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarDieAnimationEndRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarDieAnimationEndRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarDieAnimationEndRsp parseFrom(CodedInputStream input) throws IOException {
            return (AvatarDieAnimationEndRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarDieAnimationEndRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarDieAnimationEndRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarDieAnimationEndRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarDieAnimationEndRspOuterClass$AvatarDieAnimationEndRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarDieAnimationEndRspOrBuilder {
            private long dieGuid_;
            private int skillId_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarDieAnimationEndRspOuterClass.internal_static_AvatarDieAnimationEndRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarDieAnimationEndRspOuterClass.internal_static_AvatarDieAnimationEndRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarDieAnimationEndRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarDieAnimationEndRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.dieGuid_ = 0;
                this.skillId_ = 0;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarDieAnimationEndRspOuterClass.internal_static_AvatarDieAnimationEndRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarDieAnimationEndRsp getDefaultInstanceForType() {
                return AvatarDieAnimationEndRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarDieAnimationEndRsp build() {
                AvatarDieAnimationEndRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarDieAnimationEndRsp buildPartial() {
                AvatarDieAnimationEndRsp result = new AvatarDieAnimationEndRsp(this);
                result.dieGuid_ = this.dieGuid_;
                result.skillId_ = this.skillId_;
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
                if (other instanceof AvatarDieAnimationEndRsp) {
                    return mergeFrom((AvatarDieAnimationEndRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarDieAnimationEndRsp other) {
                if (other == AvatarDieAnimationEndRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getDieGuid() != 0) {
                    setDieGuid(other.getDieGuid());
                }
                if (other.getSkillId() != 0) {
                    setSkillId(other.getSkillId());
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
                AvatarDieAnimationEndRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarDieAnimationEndRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarDieAnimationEndRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarDieAnimationEndRspOuterClass.AvatarDieAnimationEndRspOrBuilder
            public long getDieGuid() {
                return this.dieGuid_;
            }

            public Builder setDieGuid(long value) {
                this.dieGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearDieGuid() {
                this.dieGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarDieAnimationEndRspOuterClass.AvatarDieAnimationEndRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarDieAnimationEndRspOuterClass.AvatarDieAnimationEndRspOrBuilder
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

        public static AvatarDieAnimationEndRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarDieAnimationEndRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarDieAnimationEndRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarDieAnimationEndRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
