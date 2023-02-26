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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerGetForceQuitBanInfoRspOuterClass.class */
public final class PlayerGetForceQuitBanInfoRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"PlayerGetForceQuitBanInfoRsp.proto\"T\n\u001cPlayerGetForceQuitBanInfoRsp\u0012\u000f\n\u0007retcode\u0018\u0007 \u0001(\u0005\u0012\u0012\n\nexpireTime\u0018\t \u0001(\r\u0012\u000f\n\u0007matchId\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PlayerGetForceQuitBanInfoRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerGetForceQuitBanInfoRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerGetForceQuitBanInfoRsp_descriptor, new String[]{"Retcode", "ExpireTime", "MatchId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerGetForceQuitBanInfoRspOuterClass$PlayerGetForceQuitBanInfoRspOrBuilder.class */
    public interface PlayerGetForceQuitBanInfoRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getExpireTime();

        int getMatchId();
    }

    private PlayerGetForceQuitBanInfoRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerGetForceQuitBanInfoRspOuterClass$PlayerGetForceQuitBanInfoRsp.class */
    public static final class PlayerGetForceQuitBanInfoRsp extends GeneratedMessageV3 implements PlayerGetForceQuitBanInfoRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 7;
        private int retcode_;
        public static final int EXPIRETIME_FIELD_NUMBER = 9;
        private int expireTime_;
        public static final int MATCHID_FIELD_NUMBER = 10;
        private int matchId_;
        private byte memoizedIsInitialized;
        private static final PlayerGetForceQuitBanInfoRsp DEFAULT_INSTANCE = new PlayerGetForceQuitBanInfoRsp();
        private static final Parser<PlayerGetForceQuitBanInfoRsp> PARSER = new AbstractParser<PlayerGetForceQuitBanInfoRsp>() { // from class: emu.grasscutter.net.proto.PlayerGetForceQuitBanInfoRspOuterClass.PlayerGetForceQuitBanInfoRsp.1
            @Override // com.google.protobuf.Parser
            public PlayerGetForceQuitBanInfoRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerGetForceQuitBanInfoRsp(input, extensionRegistry);
            }
        };

        private PlayerGetForceQuitBanInfoRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerGetForceQuitBanInfoRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerGetForceQuitBanInfoRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerGetForceQuitBanInfoRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 56:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 72:
                                    this.expireTime_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.matchId_ = input.readUInt32();
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
            return PlayerGetForceQuitBanInfoRspOuterClass.internal_static_PlayerGetForceQuitBanInfoRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerGetForceQuitBanInfoRspOuterClass.internal_static_PlayerGetForceQuitBanInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerGetForceQuitBanInfoRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerGetForceQuitBanInfoRspOuterClass.PlayerGetForceQuitBanInfoRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.PlayerGetForceQuitBanInfoRspOuterClass.PlayerGetForceQuitBanInfoRspOrBuilder
        public int getExpireTime() {
            return this.expireTime_;
        }

        @Override // emu.grasscutter.net.proto.PlayerGetForceQuitBanInfoRspOuterClass.PlayerGetForceQuitBanInfoRspOrBuilder
        public int getMatchId() {
            return this.matchId_;
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
                output.writeInt32(7, this.retcode_);
            }
            if (this.expireTime_ != 0) {
                output.writeUInt32(9, this.expireTime_);
            }
            if (this.matchId_ != 0) {
                output.writeUInt32(10, this.matchId_);
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
                size2 = 0 + CodedOutputStream.computeInt32Size(7, this.retcode_);
            }
            if (this.expireTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.expireTime_);
            }
            if (this.matchId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.matchId_);
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
            if (!(obj instanceof PlayerGetForceQuitBanInfoRsp)) {
                return equals(obj);
            }
            PlayerGetForceQuitBanInfoRsp other = (PlayerGetForceQuitBanInfoRsp) obj;
            return getRetcode() == other.getRetcode() && getExpireTime() == other.getExpireTime() && getMatchId() == other.getMatchId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getRetcode())) + 9)) + getExpireTime())) + 10)) + getMatchId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PlayerGetForceQuitBanInfoRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerGetForceQuitBanInfoRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerGetForceQuitBanInfoRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerGetForceQuitBanInfoRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerGetForceQuitBanInfoRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerGetForceQuitBanInfoRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerGetForceQuitBanInfoRsp parseFrom(InputStream input) throws IOException {
            return (PlayerGetForceQuitBanInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerGetForceQuitBanInfoRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerGetForceQuitBanInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerGetForceQuitBanInfoRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerGetForceQuitBanInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerGetForceQuitBanInfoRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerGetForceQuitBanInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerGetForceQuitBanInfoRsp parseFrom(CodedInputStream input) throws IOException {
            return (PlayerGetForceQuitBanInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerGetForceQuitBanInfoRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerGetForceQuitBanInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerGetForceQuitBanInfoRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerGetForceQuitBanInfoRspOuterClass$PlayerGetForceQuitBanInfoRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerGetForceQuitBanInfoRspOrBuilder {
            private int retcode_;
            private int expireTime_;
            private int matchId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerGetForceQuitBanInfoRspOuterClass.internal_static_PlayerGetForceQuitBanInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerGetForceQuitBanInfoRspOuterClass.internal_static_PlayerGetForceQuitBanInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerGetForceQuitBanInfoRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerGetForceQuitBanInfoRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.expireTime_ = 0;
                this.matchId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerGetForceQuitBanInfoRspOuterClass.internal_static_PlayerGetForceQuitBanInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerGetForceQuitBanInfoRsp getDefaultInstanceForType() {
                return PlayerGetForceQuitBanInfoRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerGetForceQuitBanInfoRsp build() {
                PlayerGetForceQuitBanInfoRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerGetForceQuitBanInfoRsp buildPartial() {
                PlayerGetForceQuitBanInfoRsp result = new PlayerGetForceQuitBanInfoRsp(this);
                result.retcode_ = this.retcode_;
                result.expireTime_ = this.expireTime_;
                result.matchId_ = this.matchId_;
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
                if (other instanceof PlayerGetForceQuitBanInfoRsp) {
                    return mergeFrom((PlayerGetForceQuitBanInfoRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerGetForceQuitBanInfoRsp other) {
                if (other == PlayerGetForceQuitBanInfoRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getExpireTime() != 0) {
                    setExpireTime(other.getExpireTime());
                }
                if (other.getMatchId() != 0) {
                    setMatchId(other.getMatchId());
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
                PlayerGetForceQuitBanInfoRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerGetForceQuitBanInfoRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerGetForceQuitBanInfoRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerGetForceQuitBanInfoRspOuterClass.PlayerGetForceQuitBanInfoRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlayerGetForceQuitBanInfoRspOuterClass.PlayerGetForceQuitBanInfoRspOrBuilder
            public int getExpireTime() {
                return this.expireTime_;
            }

            public Builder setExpireTime(int value) {
                this.expireTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearExpireTime() {
                this.expireTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerGetForceQuitBanInfoRspOuterClass.PlayerGetForceQuitBanInfoRspOrBuilder
            public int getMatchId() {
                return this.matchId_;
            }

            public Builder setMatchId(int value) {
                this.matchId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMatchId() {
                this.matchId_ = 0;
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

        public static PlayerGetForceQuitBanInfoRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerGetForceQuitBanInfoRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerGetForceQuitBanInfoRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerGetForceQuitBanInfoRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
