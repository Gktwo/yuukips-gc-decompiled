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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpRspOuterClass.class */
public final class PlayerApplyEnterMpRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bPlayerApplyEnterMpRsp.proto\"J\n\u0015PlayerApplyEnterMpRsp\u0012\r\n\u0005param\u0018\u0005 \u0001(\r\u0012\u0011\n\ttargetUid\u0018\n \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u000b \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PlayerApplyEnterMpRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerApplyEnterMpRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerApplyEnterMpRsp_descriptor, new String[]{"Param", "TargetUid", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpRspOuterClass$PlayerApplyEnterMpRspOrBuilder.class */
    public interface PlayerApplyEnterMpRspOrBuilder extends MessageOrBuilder {
        int getParam();

        int getTargetUid();

        int getRetcode();
    }

    private PlayerApplyEnterMpRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpRspOuterClass$PlayerApplyEnterMpRsp.class */
    public static final class PlayerApplyEnterMpRsp extends GeneratedMessageV3 implements PlayerApplyEnterMpRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PARAM_FIELD_NUMBER = 5;
        private int param_;
        public static final int TARGETUID_FIELD_NUMBER = 10;
        private int targetUid_;
        public static final int RETCODE_FIELD_NUMBER = 11;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final PlayerApplyEnterMpRsp DEFAULT_INSTANCE = new PlayerApplyEnterMpRsp();
        private static final Parser<PlayerApplyEnterMpRsp> PARSER = new AbstractParser<PlayerApplyEnterMpRsp>() { // from class: emu.grasscutter.net.proto.PlayerApplyEnterMpRspOuterClass.PlayerApplyEnterMpRsp.1
            @Override // com.google.protobuf.Parser
            public PlayerApplyEnterMpRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerApplyEnterMpRsp(input, extensionRegistry);
            }
        };

        private PlayerApplyEnterMpRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerApplyEnterMpRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerApplyEnterMpRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerApplyEnterMpRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.param_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.targetUid_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.retcode_ = input.readInt32();
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
            return PlayerApplyEnterMpRspOuterClass.internal_static_PlayerApplyEnterMpRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerApplyEnterMpRspOuterClass.internal_static_PlayerApplyEnterMpRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerApplyEnterMpRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpRspOuterClass.PlayerApplyEnterMpRspOrBuilder
        public int getParam() {
            return this.param_;
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpRspOuterClass.PlayerApplyEnterMpRspOrBuilder
        public int getTargetUid() {
            return this.targetUid_;
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpRspOuterClass.PlayerApplyEnterMpRspOrBuilder
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
            if (this.param_ != 0) {
                output.writeUInt32(5, this.param_);
            }
            if (this.targetUid_ != 0) {
                output.writeUInt32(10, this.targetUid_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(11, this.retcode_);
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
            if (this.param_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.param_);
            }
            if (this.targetUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.targetUid_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(11, this.retcode_);
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
            if (!(obj instanceof PlayerApplyEnterMpRsp)) {
                return equals(obj);
            }
            PlayerApplyEnterMpRsp other = (PlayerApplyEnterMpRsp) obj;
            return getParam() == other.getParam() && getTargetUid() == other.getTargetUid() && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getParam())) + 10)) + getTargetUid())) + 11)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PlayerApplyEnterMpRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerApplyEnterMpRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerApplyEnterMpRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerApplyEnterMpRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerApplyEnterMpRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerApplyEnterMpRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerApplyEnterMpRsp parseFrom(InputStream input) throws IOException {
            return (PlayerApplyEnterMpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerApplyEnterMpRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerApplyEnterMpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerApplyEnterMpRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerApplyEnterMpRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerApplyEnterMpRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerApplyEnterMpRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerApplyEnterMpRsp parseFrom(CodedInputStream input) throws IOException {
            return (PlayerApplyEnterMpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerApplyEnterMpRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerApplyEnterMpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerApplyEnterMpRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpRspOuterClass$PlayerApplyEnterMpRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerApplyEnterMpRspOrBuilder {
            private int param_;
            private int targetUid_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerApplyEnterMpRspOuterClass.internal_static_PlayerApplyEnterMpRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerApplyEnterMpRspOuterClass.internal_static_PlayerApplyEnterMpRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerApplyEnterMpRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerApplyEnterMpRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.param_ = 0;
                this.targetUid_ = 0;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerApplyEnterMpRspOuterClass.internal_static_PlayerApplyEnterMpRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerApplyEnterMpRsp getDefaultInstanceForType() {
                return PlayerApplyEnterMpRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerApplyEnterMpRsp build() {
                PlayerApplyEnterMpRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerApplyEnterMpRsp buildPartial() {
                PlayerApplyEnterMpRsp result = new PlayerApplyEnterMpRsp(this);
                result.param_ = this.param_;
                result.targetUid_ = this.targetUid_;
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
                if (other instanceof PlayerApplyEnterMpRsp) {
                    return mergeFrom((PlayerApplyEnterMpRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerApplyEnterMpRsp other) {
                if (other == PlayerApplyEnterMpRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getParam() != 0) {
                    setParam(other.getParam());
                }
                if (other.getTargetUid() != 0) {
                    setTargetUid(other.getTargetUid());
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
                PlayerApplyEnterMpRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerApplyEnterMpRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerApplyEnterMpRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpRspOuterClass.PlayerApplyEnterMpRspOrBuilder
            public int getParam() {
                return this.param_;
            }

            public Builder setParam(int value) {
                this.param_ = value;
                onChanged();
                return this;
            }

            public Builder clearParam() {
                this.param_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpRspOuterClass.PlayerApplyEnterMpRspOrBuilder
            public int getTargetUid() {
                return this.targetUid_;
            }

            public Builder setTargetUid(int value) {
                this.targetUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpRspOuterClass.PlayerApplyEnterMpRspOrBuilder
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

        public static PlayerApplyEnterMpRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerApplyEnterMpRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerApplyEnterMpRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerApplyEnterMpRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
