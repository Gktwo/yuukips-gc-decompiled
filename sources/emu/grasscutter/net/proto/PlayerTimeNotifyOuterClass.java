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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerTimeNotifyOuterClass.class */
public final class PlayerTimeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016PlayerTimeNotify.proto\"O\n\u0010PlayerTimeNotify\u0012\u0011\n\tis_paused\u0018\f \u0001(\b\u0012\u0013\n\u000bplayer_time\u0018\u000b \u0001(\u0004\u0012\u0013\n\u000bserver_time\u0018\u0005 \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PlayerTimeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerTimeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerTimeNotify_descriptor, new String[]{"IsPaused", "PlayerTime", "ServerTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerTimeNotifyOuterClass$PlayerTimeNotifyOrBuilder.class */
    public interface PlayerTimeNotifyOrBuilder extends MessageOrBuilder {
        boolean getIsPaused();

        long getPlayerTime();

        long getServerTime();
    }

    private PlayerTimeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerTimeNotifyOuterClass$PlayerTimeNotify.class */
    public static final class PlayerTimeNotify extends GeneratedMessageV3 implements PlayerTimeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_PAUSED_FIELD_NUMBER = 12;
        private boolean isPaused_;
        public static final int PLAYER_TIME_FIELD_NUMBER = 11;
        private long playerTime_;
        public static final int SERVER_TIME_FIELD_NUMBER = 5;
        private long serverTime_;
        private byte memoizedIsInitialized;
        private static final PlayerTimeNotify DEFAULT_INSTANCE = new PlayerTimeNotify();
        private static final Parser<PlayerTimeNotify> PARSER = new AbstractParser<PlayerTimeNotify>() { // from class: emu.grasscutter.net.proto.PlayerTimeNotifyOuterClass.PlayerTimeNotify.1
            @Override // com.google.protobuf.Parser
            public PlayerTimeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerTimeNotify(input, extensionRegistry);
            }
        };

        private PlayerTimeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerTimeNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerTimeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerTimeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.serverTime_ = input.readUInt64();
                                    break;
                                case 88:
                                    this.playerTime_ = input.readUInt64();
                                    break;
                                case 96:
                                    this.isPaused_ = input.readBool();
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
            return PlayerTimeNotifyOuterClass.internal_static_PlayerTimeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerTimeNotifyOuterClass.internal_static_PlayerTimeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerTimeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerTimeNotifyOuterClass.PlayerTimeNotifyOrBuilder
        public boolean getIsPaused() {
            return this.isPaused_;
        }

        @Override // emu.grasscutter.net.proto.PlayerTimeNotifyOuterClass.PlayerTimeNotifyOrBuilder
        public long getPlayerTime() {
            return this.playerTime_;
        }

        @Override // emu.grasscutter.net.proto.PlayerTimeNotifyOuterClass.PlayerTimeNotifyOrBuilder
        public long getServerTime() {
            return this.serverTime_;
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
            if (this.serverTime_ != 0) {
                output.writeUInt64(5, this.serverTime_);
            }
            if (this.playerTime_ != 0) {
                output.writeUInt64(11, this.playerTime_);
            }
            if (this.isPaused_) {
                output.writeBool(12, this.isPaused_);
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
            if (this.serverTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(5, this.serverTime_);
            }
            if (this.playerTime_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(11, this.playerTime_);
            }
            if (this.isPaused_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isPaused_);
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
            if (!(obj instanceof PlayerTimeNotify)) {
                return equals(obj);
            }
            PlayerTimeNotify other = (PlayerTimeNotify) obj;
            return getIsPaused() == other.getIsPaused() && getPlayerTime() == other.getPlayerTime() && getServerTime() == other.getServerTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + Internal.hashBoolean(getIsPaused()))) + 11)) + Internal.hashLong(getPlayerTime()))) + 5)) + Internal.hashLong(getServerTime()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PlayerTimeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerTimeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerTimeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerTimeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerTimeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerTimeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerTimeNotify parseFrom(InputStream input) throws IOException {
            return (PlayerTimeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerTimeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerTimeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerTimeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerTimeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerTimeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerTimeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerTimeNotify parseFrom(CodedInputStream input) throws IOException {
            return (PlayerTimeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerTimeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerTimeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerTimeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerTimeNotifyOuterClass$PlayerTimeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerTimeNotifyOrBuilder {
            private boolean isPaused_;
            private long playerTime_;
            private long serverTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerTimeNotifyOuterClass.internal_static_PlayerTimeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerTimeNotifyOuterClass.internal_static_PlayerTimeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerTimeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerTimeNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isPaused_ = false;
                this.playerTime_ = 0;
                this.serverTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerTimeNotifyOuterClass.internal_static_PlayerTimeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerTimeNotify getDefaultInstanceForType() {
                return PlayerTimeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerTimeNotify build() {
                PlayerTimeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerTimeNotify buildPartial() {
                PlayerTimeNotify result = new PlayerTimeNotify(this);
                result.isPaused_ = this.isPaused_;
                result.playerTime_ = this.playerTime_;
                result.serverTime_ = this.serverTime_;
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
                if (other instanceof PlayerTimeNotify) {
                    return mergeFrom((PlayerTimeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerTimeNotify other) {
                if (other == PlayerTimeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsPaused()) {
                    setIsPaused(other.getIsPaused());
                }
                if (other.getPlayerTime() != 0) {
                    setPlayerTime(other.getPlayerTime());
                }
                if (other.getServerTime() != 0) {
                    setServerTime(other.getServerTime());
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
                PlayerTimeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerTimeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerTimeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerTimeNotifyOuterClass.PlayerTimeNotifyOrBuilder
            public boolean getIsPaused() {
                return this.isPaused_;
            }

            public Builder setIsPaused(boolean value) {
                this.isPaused_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsPaused() {
                this.isPaused_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerTimeNotifyOuterClass.PlayerTimeNotifyOrBuilder
            public long getPlayerTime() {
                return this.playerTime_;
            }

            public Builder setPlayerTime(long value) {
                this.playerTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerTime() {
                this.playerTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerTimeNotifyOuterClass.PlayerTimeNotifyOrBuilder
            public long getServerTime() {
                return this.serverTime_;
            }

            public Builder setServerTime(long value) {
                this.serverTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearServerTime() {
                this.serverTime_ = 0;
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

        public static PlayerTimeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerTimeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerTimeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerTimeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
