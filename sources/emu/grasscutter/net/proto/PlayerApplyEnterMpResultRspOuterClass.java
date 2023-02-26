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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpResultRspOuterClass.class */
public final class PlayerApplyEnterMpResultRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!PlayerApplyEnterMpResultRsp.proto\"a\n\u001bPlayerApplyEnterMpResultRsp\u0012\u0010\n\bapplyUid\u0018\n \u0001(\r\u0012\u0010\n\bisAgreed\u0018\t \u0001(\b\u0012\u000f\n\u0007retcode\u0018\u0002 \u0001(\u0005\u0012\r\n\u0005param\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PlayerApplyEnterMpResultRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerApplyEnterMpResultRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerApplyEnterMpResultRsp_descriptor, new String[]{"ApplyUid", "IsAgreed", "Retcode", "Param"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpResultRspOuterClass$PlayerApplyEnterMpResultRspOrBuilder.class */
    public interface PlayerApplyEnterMpResultRspOrBuilder extends MessageOrBuilder {
        int getApplyUid();

        boolean getIsAgreed();

        int getRetcode();

        int getParam();
    }

    private PlayerApplyEnterMpResultRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpResultRspOuterClass$PlayerApplyEnterMpResultRsp.class */
    public static final class PlayerApplyEnterMpResultRsp extends GeneratedMessageV3 implements PlayerApplyEnterMpResultRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int APPLYUID_FIELD_NUMBER = 10;
        private int applyUid_;
        public static final int ISAGREED_FIELD_NUMBER = 9;
        private boolean isAgreed_;
        public static final int RETCODE_FIELD_NUMBER = 2;
        private int retcode_;
        public static final int PARAM_FIELD_NUMBER = 4;
        private int param_;
        private byte memoizedIsInitialized;
        private static final PlayerApplyEnterMpResultRsp DEFAULT_INSTANCE = new PlayerApplyEnterMpResultRsp();
        private static final Parser<PlayerApplyEnterMpResultRsp> PARSER = new AbstractParser<PlayerApplyEnterMpResultRsp>() { // from class: emu.grasscutter.net.proto.PlayerApplyEnterMpResultRspOuterClass.PlayerApplyEnterMpResultRsp.1
            @Override // com.google.protobuf.Parser
            public PlayerApplyEnterMpResultRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerApplyEnterMpResultRsp(input, extensionRegistry);
            }
        };

        private PlayerApplyEnterMpResultRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerApplyEnterMpResultRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerApplyEnterMpResultRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerApplyEnterMpResultRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 32:
                                    this.param_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.isAgreed_ = input.readBool();
                                    break;
                                case 80:
                                    this.applyUid_ = input.readUInt32();
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
            return PlayerApplyEnterMpResultRspOuterClass.internal_static_PlayerApplyEnterMpResultRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerApplyEnterMpResultRspOuterClass.internal_static_PlayerApplyEnterMpResultRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerApplyEnterMpResultRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultRspOuterClass.PlayerApplyEnterMpResultRspOrBuilder
        public int getApplyUid() {
            return this.applyUid_;
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultRspOuterClass.PlayerApplyEnterMpResultRspOrBuilder
        public boolean getIsAgreed() {
            return this.isAgreed_;
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultRspOuterClass.PlayerApplyEnterMpResultRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultRspOuterClass.PlayerApplyEnterMpResultRspOrBuilder
        public int getParam() {
            return this.param_;
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
            if (this.retcode_ != 0) {
                output.writeInt32(2, this.retcode_);
            }
            if (this.param_ != 0) {
                output.writeUInt32(4, this.param_);
            }
            if (this.isAgreed_) {
                output.writeBool(9, this.isAgreed_);
            }
            if (this.applyUid_ != 0) {
                output.writeUInt32(10, this.applyUid_);
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(2, this.retcode_);
            }
            if (this.param_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.param_);
            }
            if (this.isAgreed_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.isAgreed_);
            }
            if (this.applyUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.applyUid_);
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
            if (!(obj instanceof PlayerApplyEnterMpResultRsp)) {
                return equals(obj);
            }
            PlayerApplyEnterMpResultRsp other = (PlayerApplyEnterMpResultRsp) obj;
            return getApplyUid() == other.getApplyUid() && getIsAgreed() == other.getIsAgreed() && getRetcode() == other.getRetcode() && getParam() == other.getParam() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getApplyUid())) + 9)) + Internal.hashBoolean(getIsAgreed()))) + 2)) + getRetcode())) + 4)) + getParam())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PlayerApplyEnterMpResultRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerApplyEnterMpResultRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerApplyEnterMpResultRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerApplyEnterMpResultRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerApplyEnterMpResultRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerApplyEnterMpResultRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerApplyEnterMpResultRsp parseFrom(InputStream input) throws IOException {
            return (PlayerApplyEnterMpResultRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerApplyEnterMpResultRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerApplyEnterMpResultRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerApplyEnterMpResultRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerApplyEnterMpResultRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerApplyEnterMpResultRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerApplyEnterMpResultRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerApplyEnterMpResultRsp parseFrom(CodedInputStream input) throws IOException {
            return (PlayerApplyEnterMpResultRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerApplyEnterMpResultRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerApplyEnterMpResultRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerApplyEnterMpResultRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpResultRspOuterClass$PlayerApplyEnterMpResultRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerApplyEnterMpResultRspOrBuilder {
            private int applyUid_;
            private boolean isAgreed_;
            private int retcode_;
            private int param_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerApplyEnterMpResultRspOuterClass.internal_static_PlayerApplyEnterMpResultRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerApplyEnterMpResultRspOuterClass.internal_static_PlayerApplyEnterMpResultRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerApplyEnterMpResultRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerApplyEnterMpResultRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.applyUid_ = 0;
                this.isAgreed_ = false;
                this.retcode_ = 0;
                this.param_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerApplyEnterMpResultRspOuterClass.internal_static_PlayerApplyEnterMpResultRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerApplyEnterMpResultRsp getDefaultInstanceForType() {
                return PlayerApplyEnterMpResultRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerApplyEnterMpResultRsp build() {
                PlayerApplyEnterMpResultRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerApplyEnterMpResultRsp buildPartial() {
                PlayerApplyEnterMpResultRsp result = new PlayerApplyEnterMpResultRsp(this);
                result.applyUid_ = this.applyUid_;
                result.isAgreed_ = this.isAgreed_;
                result.retcode_ = this.retcode_;
                result.param_ = this.param_;
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
                if (other instanceof PlayerApplyEnterMpResultRsp) {
                    return mergeFrom((PlayerApplyEnterMpResultRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerApplyEnterMpResultRsp other) {
                if (other == PlayerApplyEnterMpResultRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getApplyUid() != 0) {
                    setApplyUid(other.getApplyUid());
                }
                if (other.getIsAgreed()) {
                    setIsAgreed(other.getIsAgreed());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getParam() != 0) {
                    setParam(other.getParam());
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
                PlayerApplyEnterMpResultRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerApplyEnterMpResultRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerApplyEnterMpResultRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultRspOuterClass.PlayerApplyEnterMpResultRspOrBuilder
            public int getApplyUid() {
                return this.applyUid_;
            }

            public Builder setApplyUid(int value) {
                this.applyUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearApplyUid() {
                this.applyUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultRspOuterClass.PlayerApplyEnterMpResultRspOrBuilder
            public boolean getIsAgreed() {
                return this.isAgreed_;
            }

            public Builder setIsAgreed(boolean value) {
                this.isAgreed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAgreed() {
                this.isAgreed_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultRspOuterClass.PlayerApplyEnterMpResultRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultRspOuterClass.PlayerApplyEnterMpResultRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static PlayerApplyEnterMpResultRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerApplyEnterMpResultRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerApplyEnterMpResultRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerApplyEnterMpResultRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
