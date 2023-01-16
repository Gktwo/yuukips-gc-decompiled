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
import emu.grasscutter.net.proto.ChatInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerChatNotifyOuterClass.class */
public final class PlayerChatNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016PlayerChatNotify.proto\u001a\u000eChatInfo.proto\"D\n\u0010PlayerChatNotify\u0012\u001c\n\tchat_info\u0018\u000b \u0001(\u000b2\t.ChatInfo\u0012\u0012\n\nchannel_id\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ChatInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerChatNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerChatNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerChatNotify_descriptor, new String[]{"ChatInfo", "ChannelId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerChatNotifyOuterClass$PlayerChatNotifyOrBuilder.class */
    public interface PlayerChatNotifyOrBuilder extends MessageOrBuilder {
        boolean hasChatInfo();

        ChatInfoOuterClass.ChatInfo getChatInfo();

        ChatInfoOuterClass.ChatInfoOrBuilder getChatInfoOrBuilder();

        int getChannelId();
    }

    private PlayerChatNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerChatNotifyOuterClass$PlayerChatNotify.class */
    public static final class PlayerChatNotify extends GeneratedMessageV3 implements PlayerChatNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHAT_INFO_FIELD_NUMBER = 11;
        private ChatInfoOuterClass.ChatInfo chatInfo_;
        public static final int CHANNEL_ID_FIELD_NUMBER = 13;
        private int channelId_;
        private byte memoizedIsInitialized;
        private static final PlayerChatNotify DEFAULT_INSTANCE = new PlayerChatNotify();
        private static final Parser<PlayerChatNotify> PARSER = new AbstractParser<PlayerChatNotify>() { // from class: emu.grasscutter.net.proto.PlayerChatNotifyOuterClass.PlayerChatNotify.1
            @Override // com.google.protobuf.Parser
            public PlayerChatNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerChatNotify(input, extensionRegistry);
            }
        };

        private PlayerChatNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerChatNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerChatNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerChatNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 90:
                                    ChatInfoOuterClass.ChatInfo.Builder subBuilder = this.chatInfo_ != null ? this.chatInfo_.toBuilder() : null;
                                    this.chatInfo_ = (ChatInfoOuterClass.ChatInfo) input.readMessage(ChatInfoOuterClass.ChatInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.chatInfo_);
                                        this.chatInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 104:
                                    this.channelId_ = input.readUInt32();
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
            return PlayerChatNotifyOuterClass.internal_static_PlayerChatNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerChatNotifyOuterClass.internal_static_PlayerChatNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerChatNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerChatNotifyOuterClass.PlayerChatNotifyOrBuilder
        public boolean hasChatInfo() {
            return this.chatInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayerChatNotifyOuterClass.PlayerChatNotifyOrBuilder
        public ChatInfoOuterClass.ChatInfo getChatInfo() {
            return this.chatInfo_ == null ? ChatInfoOuterClass.ChatInfo.getDefaultInstance() : this.chatInfo_;
        }

        @Override // emu.grasscutter.net.proto.PlayerChatNotifyOuterClass.PlayerChatNotifyOrBuilder
        public ChatInfoOuterClass.ChatInfoOrBuilder getChatInfoOrBuilder() {
            return getChatInfo();
        }

        @Override // emu.grasscutter.net.proto.PlayerChatNotifyOuterClass.PlayerChatNotifyOrBuilder
        public int getChannelId() {
            return this.channelId_;
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
            if (this.chatInfo_ != null) {
                output.writeMessage(11, getChatInfo());
            }
            if (this.channelId_ != 0) {
                output.writeUInt32(13, this.channelId_);
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
            if (this.chatInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(11, getChatInfo());
            }
            if (this.channelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.channelId_);
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
            if (!(obj instanceof PlayerChatNotify)) {
                return equals(obj);
            }
            PlayerChatNotify other = (PlayerChatNotify) obj;
            if (hasChatInfo() != other.hasChatInfo()) {
                return false;
            }
            return (!hasChatInfo() || getChatInfo().equals(other.getChatInfo())) && getChannelId() == other.getChannelId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasChatInfo()) {
                hash = (53 * ((37 * hash) + 11)) + getChatInfo().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 13)) + getChannelId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PlayerChatNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerChatNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerChatNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerChatNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerChatNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerChatNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerChatNotify parseFrom(InputStream input) throws IOException {
            return (PlayerChatNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerChatNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerChatNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerChatNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerChatNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerChatNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerChatNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerChatNotify parseFrom(CodedInputStream input) throws IOException {
            return (PlayerChatNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerChatNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerChatNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerChatNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerChatNotifyOuterClass$PlayerChatNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerChatNotifyOrBuilder {
            private ChatInfoOuterClass.ChatInfo chatInfo_;
            private SingleFieldBuilderV3<ChatInfoOuterClass.ChatInfo, ChatInfoOuterClass.ChatInfo.Builder, ChatInfoOuterClass.ChatInfoOrBuilder> chatInfoBuilder_;
            private int channelId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerChatNotifyOuterClass.internal_static_PlayerChatNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerChatNotifyOuterClass.internal_static_PlayerChatNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerChatNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerChatNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.chatInfoBuilder_ == null) {
                    this.chatInfo_ = null;
                } else {
                    this.chatInfo_ = null;
                    this.chatInfoBuilder_ = null;
                }
                this.channelId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerChatNotifyOuterClass.internal_static_PlayerChatNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerChatNotify getDefaultInstanceForType() {
                return PlayerChatNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerChatNotify build() {
                PlayerChatNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerChatNotify buildPartial() {
                PlayerChatNotify result = new PlayerChatNotify(this);
                if (this.chatInfoBuilder_ == null) {
                    result.chatInfo_ = this.chatInfo_;
                } else {
                    result.chatInfo_ = this.chatInfoBuilder_.build();
                }
                result.channelId_ = this.channelId_;
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
                if (other instanceof PlayerChatNotify) {
                    return mergeFrom((PlayerChatNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerChatNotify other) {
                if (other == PlayerChatNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasChatInfo()) {
                    mergeChatInfo(other.getChatInfo());
                }
                if (other.getChannelId() != 0) {
                    setChannelId(other.getChannelId());
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
                PlayerChatNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerChatNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerChatNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerChatNotifyOuterClass.PlayerChatNotifyOrBuilder
            public boolean hasChatInfo() {
                return (this.chatInfoBuilder_ == null && this.chatInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayerChatNotifyOuterClass.PlayerChatNotifyOrBuilder
            public ChatInfoOuterClass.ChatInfo getChatInfo() {
                if (this.chatInfoBuilder_ == null) {
                    return this.chatInfo_ == null ? ChatInfoOuterClass.ChatInfo.getDefaultInstance() : this.chatInfo_;
                }
                return this.chatInfoBuilder_.getMessage();
            }

            public Builder setChatInfo(ChatInfoOuterClass.ChatInfo value) {
                if (this.chatInfoBuilder_ != null) {
                    this.chatInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.chatInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setChatInfo(ChatInfoOuterClass.ChatInfo.Builder builderForValue) {
                if (this.chatInfoBuilder_ == null) {
                    this.chatInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.chatInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeChatInfo(ChatInfoOuterClass.ChatInfo value) {
                if (this.chatInfoBuilder_ == null) {
                    if (this.chatInfo_ != null) {
                        this.chatInfo_ = ChatInfoOuterClass.ChatInfo.newBuilder(this.chatInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.chatInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.chatInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearChatInfo() {
                if (this.chatInfoBuilder_ == null) {
                    this.chatInfo_ = null;
                    onChanged();
                } else {
                    this.chatInfo_ = null;
                    this.chatInfoBuilder_ = null;
                }
                return this;
            }

            public ChatInfoOuterClass.ChatInfo.Builder getChatInfoBuilder() {
                onChanged();
                return getChatInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlayerChatNotifyOuterClass.PlayerChatNotifyOrBuilder
            public ChatInfoOuterClass.ChatInfoOrBuilder getChatInfoOrBuilder() {
                if (this.chatInfoBuilder_ != null) {
                    return this.chatInfoBuilder_.getMessageOrBuilder();
                }
                return this.chatInfo_ == null ? ChatInfoOuterClass.ChatInfo.getDefaultInstance() : this.chatInfo_;
            }

            private SingleFieldBuilderV3<ChatInfoOuterClass.ChatInfo, ChatInfoOuterClass.ChatInfo.Builder, ChatInfoOuterClass.ChatInfoOrBuilder> getChatInfoFieldBuilder() {
                if (this.chatInfoBuilder_ == null) {
                    this.chatInfoBuilder_ = new SingleFieldBuilderV3<>(getChatInfo(), getParentForChildren(), isClean());
                    this.chatInfo_ = null;
                }
                return this.chatInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerChatNotifyOuterClass.PlayerChatNotifyOrBuilder
            public int getChannelId() {
                return this.channelId_;
            }

            public Builder setChannelId(int value) {
                this.channelId_ = value;
                onChanged();
                return this;
            }

            public Builder clearChannelId() {
                this.channelId_ = 0;
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

        public static PlayerChatNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerChatNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerChatNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerChatNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ChatInfoOuterClass.getDescriptor();
    }
}
