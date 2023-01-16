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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.PlayerLocationInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerWorldLocationInfoOuterClass.class */
public final class PlayerWorldLocationInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dPlayerWorldLocationInfo.proto\u001a\u0018PlayerLocationInfo.proto\"T\n\u0017PlayerWorldLocationInfo\u0012'\n\nplayer_loc\u0018\u0003 \u0001(\u000b2\u0013.PlayerLocationInfo\u0012\u0010\n\bscene_id\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PlayerLocationInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerWorldLocationInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerWorldLocationInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerWorldLocationInfo_descriptor, new String[]{"PlayerLoc", "SceneId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerWorldLocationInfoOuterClass$PlayerWorldLocationInfoOrBuilder.class */
    public interface PlayerWorldLocationInfoOrBuilder extends MessageOrBuilder {
        boolean hasPlayerLoc();

        PlayerLocationInfoOuterClass.PlayerLocationInfo getPlayerLoc();

        PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder getPlayerLocOrBuilder();

        int getSceneId();
    }

    private PlayerWorldLocationInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerWorldLocationInfoOuterClass$PlayerWorldLocationInfo.class */
    public static final class PlayerWorldLocationInfo extends GeneratedMessageV3 implements PlayerWorldLocationInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PLAYER_LOC_FIELD_NUMBER = 3;
        private PlayerLocationInfoOuterClass.PlayerLocationInfo playerLoc_;
        public static final int SCENE_ID_FIELD_NUMBER = 11;
        private int sceneId_;
        private byte memoizedIsInitialized;
        private static final PlayerWorldLocationInfo DEFAULT_INSTANCE = new PlayerWorldLocationInfo();
        private static final Parser<PlayerWorldLocationInfo> PARSER = new AbstractParser<PlayerWorldLocationInfo>() { // from class: emu.grasscutter.net.proto.PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo.1
            @Override // com.google.protobuf.Parser
            public PlayerWorldLocationInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerWorldLocationInfo(input, extensionRegistry);
            }
        };

        private PlayerWorldLocationInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerWorldLocationInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerWorldLocationInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerWorldLocationInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 26:
                                    PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder subBuilder = this.playerLoc_ != null ? this.playerLoc_.toBuilder() : null;
                                    this.playerLoc_ = (PlayerLocationInfoOuterClass.PlayerLocationInfo) input.readMessage(PlayerLocationInfoOuterClass.PlayerLocationInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.playerLoc_);
                                        this.playerLoc_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 88:
                                    this.sceneId_ = input.readUInt32();
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
            return PlayerWorldLocationInfoOuterClass.internal_static_PlayerWorldLocationInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerWorldLocationInfoOuterClass.internal_static_PlayerWorldLocationInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerWorldLocationInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfoOrBuilder
        public boolean hasPlayerLoc() {
            return this.playerLoc_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfoOrBuilder
        public PlayerLocationInfoOuterClass.PlayerLocationInfo getPlayerLoc() {
            return this.playerLoc_ == null ? PlayerLocationInfoOuterClass.PlayerLocationInfo.getDefaultInstance() : this.playerLoc_;
        }

        @Override // emu.grasscutter.net.proto.PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfoOrBuilder
        public PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder getPlayerLocOrBuilder() {
            return getPlayerLoc();
        }

        @Override // emu.grasscutter.net.proto.PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfoOrBuilder
        public int getSceneId() {
            return this.sceneId_;
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
            if (this.playerLoc_ != null) {
                output.writeMessage(3, getPlayerLoc());
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(11, this.sceneId_);
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
            if (this.playerLoc_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(3, getPlayerLoc());
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.sceneId_);
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
            if (!(obj instanceof PlayerWorldLocationInfo)) {
                return equals(obj);
            }
            PlayerWorldLocationInfo other = (PlayerWorldLocationInfo) obj;
            if (hasPlayerLoc() != other.hasPlayerLoc()) {
                return false;
            }
            return (!hasPlayerLoc() || getPlayerLoc().equals(other.getPlayerLoc())) && getSceneId() == other.getSceneId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasPlayerLoc()) {
                hash = (53 * ((37 * hash) + 3)) + getPlayerLoc().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 11)) + getSceneId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PlayerWorldLocationInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerWorldLocationInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerWorldLocationInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerWorldLocationInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerWorldLocationInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerWorldLocationInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerWorldLocationInfo parseFrom(InputStream input) throws IOException {
            return (PlayerWorldLocationInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerWorldLocationInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerWorldLocationInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerWorldLocationInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerWorldLocationInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerWorldLocationInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerWorldLocationInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerWorldLocationInfo parseFrom(CodedInputStream input) throws IOException {
            return (PlayerWorldLocationInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerWorldLocationInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerWorldLocationInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerWorldLocationInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerWorldLocationInfoOuterClass$PlayerWorldLocationInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerWorldLocationInfoOrBuilder {
            private PlayerLocationInfoOuterClass.PlayerLocationInfo playerLoc_;
            private SingleFieldBuilderV3<PlayerLocationInfoOuterClass.PlayerLocationInfo, PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder, PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder> playerLocBuilder_;
            private int sceneId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerWorldLocationInfoOuterClass.internal_static_PlayerWorldLocationInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerWorldLocationInfoOuterClass.internal_static_PlayerWorldLocationInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerWorldLocationInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerWorldLocationInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.playerLocBuilder_ == null) {
                    this.playerLoc_ = null;
                } else {
                    this.playerLoc_ = null;
                    this.playerLocBuilder_ = null;
                }
                this.sceneId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerWorldLocationInfoOuterClass.internal_static_PlayerWorldLocationInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerWorldLocationInfo getDefaultInstanceForType() {
                return PlayerWorldLocationInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerWorldLocationInfo build() {
                PlayerWorldLocationInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerWorldLocationInfo buildPartial() {
                PlayerWorldLocationInfo result = new PlayerWorldLocationInfo(this);
                if (this.playerLocBuilder_ == null) {
                    result.playerLoc_ = this.playerLoc_;
                } else {
                    result.playerLoc_ = this.playerLocBuilder_.build();
                }
                result.sceneId_ = this.sceneId_;
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
                if (other instanceof PlayerWorldLocationInfo) {
                    return mergeFrom((PlayerWorldLocationInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerWorldLocationInfo other) {
                if (other == PlayerWorldLocationInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasPlayerLoc()) {
                    mergePlayerLoc(other.getPlayerLoc());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
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
                PlayerWorldLocationInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerWorldLocationInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerWorldLocationInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfoOrBuilder
            public boolean hasPlayerLoc() {
                return (this.playerLocBuilder_ == null && this.playerLoc_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfoOrBuilder
            public PlayerLocationInfoOuterClass.PlayerLocationInfo getPlayerLoc() {
                if (this.playerLocBuilder_ == null) {
                    return this.playerLoc_ == null ? PlayerLocationInfoOuterClass.PlayerLocationInfo.getDefaultInstance() : this.playerLoc_;
                }
                return this.playerLocBuilder_.getMessage();
            }

            public Builder setPlayerLoc(PlayerLocationInfoOuterClass.PlayerLocationInfo value) {
                if (this.playerLocBuilder_ != null) {
                    this.playerLocBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.playerLoc_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPlayerLoc(PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder builderForValue) {
                if (this.playerLocBuilder_ == null) {
                    this.playerLoc_ = builderForValue.build();
                    onChanged();
                } else {
                    this.playerLocBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePlayerLoc(PlayerLocationInfoOuterClass.PlayerLocationInfo value) {
                if (this.playerLocBuilder_ == null) {
                    if (this.playerLoc_ != null) {
                        this.playerLoc_ = PlayerLocationInfoOuterClass.PlayerLocationInfo.newBuilder(this.playerLoc_).mergeFrom(value).buildPartial();
                    } else {
                        this.playerLoc_ = value;
                    }
                    onChanged();
                } else {
                    this.playerLocBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPlayerLoc() {
                if (this.playerLocBuilder_ == null) {
                    this.playerLoc_ = null;
                    onChanged();
                } else {
                    this.playerLoc_ = null;
                    this.playerLocBuilder_ = null;
                }
                return this;
            }

            public PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder getPlayerLocBuilder() {
                onChanged();
                return getPlayerLocFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfoOrBuilder
            public PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder getPlayerLocOrBuilder() {
                if (this.playerLocBuilder_ != null) {
                    return this.playerLocBuilder_.getMessageOrBuilder();
                }
                return this.playerLoc_ == null ? PlayerLocationInfoOuterClass.PlayerLocationInfo.getDefaultInstance() : this.playerLoc_;
            }

            private SingleFieldBuilderV3<PlayerLocationInfoOuterClass.PlayerLocationInfo, PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder, PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder> getPlayerLocFieldBuilder() {
                if (this.playerLocBuilder_ == null) {
                    this.playerLocBuilder_ = new SingleFieldBuilderV3<>(getPlayerLoc(), getParentForChildren(), isClean());
                    this.playerLoc_ = null;
                }
                return this.playerLocBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfoOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
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

        public static PlayerWorldLocationInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerWorldLocationInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerWorldLocationInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerWorldLocationInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PlayerLocationInfoOuterClass.getDescriptor();
    }
}
