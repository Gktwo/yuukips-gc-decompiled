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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerChatReqOuterClass.class */
public final class PlayerChatReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013PlayerChatReq.proto\u001a\u000eChatInfo.proto\"?\n\rPlayerChatReq\u0012\u0011\n\tchannelId\u0018\u0005 \u0001(\r\u0012\u001b\n\bchatInfo\u0018\f \u0001(\u000b2\t.ChatInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ChatInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerChatReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerChatReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerChatReq_descriptor, new String[]{"ChannelId", "ChatInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerChatReqOuterClass$PlayerChatReqOrBuilder.class */
    public interface PlayerChatReqOrBuilder extends MessageOrBuilder {
        int getChannelId();

        boolean hasChatInfo();

        ChatInfoOuterClass.ChatInfo getChatInfo();

        ChatInfoOuterClass.ChatInfoOrBuilder getChatInfoOrBuilder();
    }

    private PlayerChatReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerChatReqOuterClass$PlayerChatReq.class */
    public static final class PlayerChatReq extends GeneratedMessageV3 implements PlayerChatReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHANNELID_FIELD_NUMBER = 5;
        private int channelId_;
        public static final int CHATINFO_FIELD_NUMBER = 12;
        private ChatInfoOuterClass.ChatInfo chatInfo_;
        private byte memoizedIsInitialized;
        private static final PlayerChatReq DEFAULT_INSTANCE = new PlayerChatReq();
        private static final Parser<PlayerChatReq> PARSER = new AbstractParser<PlayerChatReq>() { // from class: emu.grasscutter.net.proto.PlayerChatReqOuterClass.PlayerChatReq.1
            @Override // com.google.protobuf.Parser
            public PlayerChatReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerChatReq(input, extensionRegistry);
            }
        };

        private PlayerChatReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerChatReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerChatReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerChatReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.channelId_ = input.readUInt32();
                                    break;
                                case 98:
                                    ChatInfoOuterClass.ChatInfo.Builder subBuilder = this.chatInfo_ != null ? this.chatInfo_.toBuilder() : null;
                                    this.chatInfo_ = (ChatInfoOuterClass.ChatInfo) input.readMessage(ChatInfoOuterClass.ChatInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.chatInfo_);
                                        this.chatInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
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
            return PlayerChatReqOuterClass.internal_static_PlayerChatReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerChatReqOuterClass.internal_static_PlayerChatReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerChatReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerChatReqOuterClass.PlayerChatReqOrBuilder
        public int getChannelId() {
            return this.channelId_;
        }

        @Override // emu.grasscutter.net.proto.PlayerChatReqOuterClass.PlayerChatReqOrBuilder
        public boolean hasChatInfo() {
            return this.chatInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayerChatReqOuterClass.PlayerChatReqOrBuilder
        public ChatInfoOuterClass.ChatInfo getChatInfo() {
            return this.chatInfo_ == null ? ChatInfoOuterClass.ChatInfo.getDefaultInstance() : this.chatInfo_;
        }

        @Override // emu.grasscutter.net.proto.PlayerChatReqOuterClass.PlayerChatReqOrBuilder
        public ChatInfoOuterClass.ChatInfoOrBuilder getChatInfoOrBuilder() {
            return getChatInfo();
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
            if (this.channelId_ != 0) {
                output.writeUInt32(5, this.channelId_);
            }
            if (this.chatInfo_ != null) {
                output.writeMessage(12, getChatInfo());
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
            if (this.channelId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.channelId_);
            }
            if (this.chatInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getChatInfo());
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
            if (!(obj instanceof PlayerChatReq)) {
                return equals(obj);
            }
            PlayerChatReq other = (PlayerChatReq) obj;
            if (getChannelId() == other.getChannelId() && hasChatInfo() == other.hasChatInfo()) {
                return (!hasChatInfo() || getChatInfo().equals(other.getChatInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getChannelId();
            if (hasChatInfo()) {
                hash = (53 * ((37 * hash) + 12)) + getChatInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PlayerChatReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerChatReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerChatReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerChatReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerChatReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerChatReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerChatReq parseFrom(InputStream input) throws IOException {
            return (PlayerChatReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerChatReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerChatReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerChatReq parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerChatReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerChatReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerChatReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerChatReq parseFrom(CodedInputStream input) throws IOException {
            return (PlayerChatReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerChatReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerChatReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerChatReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerChatReqOuterClass$PlayerChatReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerChatReqOrBuilder {
            private int channelId_;
            private ChatInfoOuterClass.ChatInfo chatInfo_;
            private SingleFieldBuilderV3<ChatInfoOuterClass.ChatInfo, ChatInfoOuterClass.ChatInfo.Builder, ChatInfoOuterClass.ChatInfoOrBuilder> chatInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerChatReqOuterClass.internal_static_PlayerChatReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerChatReqOuterClass.internal_static_PlayerChatReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerChatReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerChatReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.channelId_ = 0;
                if (this.chatInfoBuilder_ == null) {
                    this.chatInfo_ = null;
                } else {
                    this.chatInfo_ = null;
                    this.chatInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerChatReqOuterClass.internal_static_PlayerChatReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerChatReq getDefaultInstanceForType() {
                return PlayerChatReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerChatReq build() {
                PlayerChatReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerChatReq buildPartial() {
                PlayerChatReq result = new PlayerChatReq(this);
                result.channelId_ = this.channelId_;
                if (this.chatInfoBuilder_ == null) {
                    result.chatInfo_ = this.chatInfo_;
                } else {
                    result.chatInfo_ = this.chatInfoBuilder_.build();
                }
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
                if (other instanceof PlayerChatReq) {
                    return mergeFrom((PlayerChatReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerChatReq other) {
                if (other == PlayerChatReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getChannelId() != 0) {
                    setChannelId(other.getChannelId());
                }
                if (other.hasChatInfo()) {
                    mergeChatInfo(other.getChatInfo());
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
                PlayerChatReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerChatReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerChatReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerChatReqOuterClass.PlayerChatReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlayerChatReqOuterClass.PlayerChatReqOrBuilder
            public boolean hasChatInfo() {
                return (this.chatInfoBuilder_ == null && this.chatInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayerChatReqOuterClass.PlayerChatReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlayerChatReqOuterClass.PlayerChatReqOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static PlayerChatReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerChatReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerChatReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerChatReq getDefaultInstanceForType() {
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
