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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PrivateChatNotifyOuterClass.class */
public final class PrivateChatNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017PrivateChatNotify.proto\u001a\u000eChatInfo.proto\"1\n\u0011PrivateChatNotify\u0012\u001c\n\tchat_info\u0018\t \u0001(\u000b2\t.ChatInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ChatInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PrivateChatNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PrivateChatNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PrivateChatNotify_descriptor, new String[]{"ChatInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PrivateChatNotifyOuterClass$PrivateChatNotifyOrBuilder.class */
    public interface PrivateChatNotifyOrBuilder extends MessageOrBuilder {
        boolean hasChatInfo();

        ChatInfoOuterClass.ChatInfo getChatInfo();

        ChatInfoOuterClass.ChatInfoOrBuilder getChatInfoOrBuilder();
    }

    private PrivateChatNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PrivateChatNotifyOuterClass$PrivateChatNotify.class */
    public static final class PrivateChatNotify extends GeneratedMessageV3 implements PrivateChatNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHAT_INFO_FIELD_NUMBER = 9;
        private ChatInfoOuterClass.ChatInfo chatInfo_;
        private byte memoizedIsInitialized;
        private static final PrivateChatNotify DEFAULT_INSTANCE = new PrivateChatNotify();
        private static final Parser<PrivateChatNotify> PARSER = new AbstractParser<PrivateChatNotify>() { // from class: emu.grasscutter.net.proto.PrivateChatNotifyOuterClass.PrivateChatNotify.1
            @Override // com.google.protobuf.Parser
            public PrivateChatNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PrivateChatNotify(input, extensionRegistry);
            }
        };

        private PrivateChatNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PrivateChatNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PrivateChatNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PrivateChatNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 74:
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
            return PrivateChatNotifyOuterClass.internal_static_PrivateChatNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PrivateChatNotifyOuterClass.internal_static_PrivateChatNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PrivateChatNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PrivateChatNotifyOuterClass.PrivateChatNotifyOrBuilder
        public boolean hasChatInfo() {
            return this.chatInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.PrivateChatNotifyOuterClass.PrivateChatNotifyOrBuilder
        public ChatInfoOuterClass.ChatInfo getChatInfo() {
            return this.chatInfo_ == null ? ChatInfoOuterClass.ChatInfo.getDefaultInstance() : this.chatInfo_;
        }

        @Override // emu.grasscutter.net.proto.PrivateChatNotifyOuterClass.PrivateChatNotifyOrBuilder
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
            if (this.chatInfo_ != null) {
                output.writeMessage(9, getChatInfo());
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
                size2 = 0 + CodedOutputStream.computeMessageSize(9, getChatInfo());
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
            if (!(obj instanceof PrivateChatNotify)) {
                return equals(obj);
            }
            PrivateChatNotify other = (PrivateChatNotify) obj;
            if (hasChatInfo() != other.hasChatInfo()) {
                return false;
            }
            return (!hasChatInfo() || getChatInfo().equals(other.getChatInfo())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasChatInfo()) {
                hash = (53 * ((37 * hash) + 9)) + getChatInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PrivateChatNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PrivateChatNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PrivateChatNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PrivateChatNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PrivateChatNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PrivateChatNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PrivateChatNotify parseFrom(InputStream input) throws IOException {
            return (PrivateChatNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PrivateChatNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PrivateChatNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PrivateChatNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (PrivateChatNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PrivateChatNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PrivateChatNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PrivateChatNotify parseFrom(CodedInputStream input) throws IOException {
            return (PrivateChatNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PrivateChatNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PrivateChatNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PrivateChatNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PrivateChatNotifyOuterClass$PrivateChatNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PrivateChatNotifyOrBuilder {
            private ChatInfoOuterClass.ChatInfo chatInfo_;
            private SingleFieldBuilderV3<ChatInfoOuterClass.ChatInfo, ChatInfoOuterClass.ChatInfo.Builder, ChatInfoOuterClass.ChatInfoOrBuilder> chatInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PrivateChatNotifyOuterClass.internal_static_PrivateChatNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PrivateChatNotifyOuterClass.internal_static_PrivateChatNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PrivateChatNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PrivateChatNotify.alwaysUseFieldBuilders) {
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
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PrivateChatNotifyOuterClass.internal_static_PrivateChatNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PrivateChatNotify getDefaultInstanceForType() {
                return PrivateChatNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PrivateChatNotify build() {
                PrivateChatNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PrivateChatNotify buildPartial() {
                PrivateChatNotify result = new PrivateChatNotify(this);
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
                if (other instanceof PrivateChatNotify) {
                    return mergeFrom((PrivateChatNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PrivateChatNotify other) {
                if (other == PrivateChatNotify.getDefaultInstance()) {
                    return this;
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
                PrivateChatNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = PrivateChatNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PrivateChatNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PrivateChatNotifyOuterClass.PrivateChatNotifyOrBuilder
            public boolean hasChatInfo() {
                return (this.chatInfoBuilder_ == null && this.chatInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PrivateChatNotifyOuterClass.PrivateChatNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.PrivateChatNotifyOuterClass.PrivateChatNotifyOrBuilder
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

        public static PrivateChatNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PrivateChatNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PrivateChatNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PrivateChatNotify getDefaultInstanceForType() {
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
