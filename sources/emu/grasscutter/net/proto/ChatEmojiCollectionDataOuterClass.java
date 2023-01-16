package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChatEmojiCollectionDataOuterClass.class */
public final class ChatEmojiCollectionDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dChatEmojiCollectionData.proto\"0\n\u0017ChatEmojiCollectionData\u0012\u0015\n\remoji_id_list\u0018\u0001 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChatEmojiCollectionData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChatEmojiCollectionData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChatEmojiCollectionData_descriptor, new String[]{"EmojiIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChatEmojiCollectionDataOuterClass$ChatEmojiCollectionDataOrBuilder.class */
    public interface ChatEmojiCollectionDataOrBuilder extends MessageOrBuilder {
        List<Integer> getEmojiIdListList();

        int getEmojiIdListCount();

        int getEmojiIdList(int i);
    }

    private ChatEmojiCollectionDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChatEmojiCollectionDataOuterClass$ChatEmojiCollectionData.class */
    public static final class ChatEmojiCollectionData extends GeneratedMessageV3 implements ChatEmojiCollectionDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int EMOJI_ID_LIST_FIELD_NUMBER = 1;
        private Internal.IntList emojiIdList_;
        private int emojiIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final ChatEmojiCollectionData DEFAULT_INSTANCE = new ChatEmojiCollectionData();
        private static final Parser<ChatEmojiCollectionData> PARSER = new AbstractParser<ChatEmojiCollectionData>() { // from class: emu.grasscutter.net.proto.ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData.1
            @Override // com.google.protobuf.Parser
            public ChatEmojiCollectionData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChatEmojiCollectionData(input, extensionRegistry);
            }
        };

        private ChatEmojiCollectionData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.emojiIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ChatEmojiCollectionData() {
            this.emojiIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.emojiIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChatEmojiCollectionData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChatEmojiCollectionData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
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
                                case 8:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.emojiIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.emojiIdList_.addInt(input.readUInt32());
                                    break;
                                case 10:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.emojiIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.emojiIdList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.emojiIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ChatEmojiCollectionDataOuterClass.internal_static_ChatEmojiCollectionData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChatEmojiCollectionDataOuterClass.internal_static_ChatEmojiCollectionData_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatEmojiCollectionData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionDataOrBuilder
        public List<Integer> getEmojiIdListList() {
            return this.emojiIdList_;
        }

        @Override // emu.grasscutter.net.proto.ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionDataOrBuilder
        public int getEmojiIdListCount() {
            return this.emojiIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionDataOrBuilder
        public int getEmojiIdList(int index) {
            return this.emojiIdList_.getInt(index);
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
            getSerializedSize();
            if (getEmojiIdListList().size() > 0) {
                output.writeUInt32NoTag(10);
                output.writeUInt32NoTag(this.emojiIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.emojiIdList_.size(); i++) {
                output.writeUInt32NoTag(this.emojiIdList_.getInt(i));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.emojiIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.emojiIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getEmojiIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.emojiIdListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ChatEmojiCollectionData)) {
                return equals(obj);
            }
            ChatEmojiCollectionData other = (ChatEmojiCollectionData) obj;
            return getEmojiIdListList().equals(other.getEmojiIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getEmojiIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getEmojiIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ChatEmojiCollectionData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChatEmojiCollectionData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChatEmojiCollectionData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChatEmojiCollectionData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChatEmojiCollectionData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChatEmojiCollectionData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChatEmojiCollectionData parseFrom(InputStream input) throws IOException {
            return (ChatEmojiCollectionData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChatEmojiCollectionData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChatEmojiCollectionData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChatEmojiCollectionData parseDelimitedFrom(InputStream input) throws IOException {
            return (ChatEmojiCollectionData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChatEmojiCollectionData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChatEmojiCollectionData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChatEmojiCollectionData parseFrom(CodedInputStream input) throws IOException {
            return (ChatEmojiCollectionData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChatEmojiCollectionData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChatEmojiCollectionData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChatEmojiCollectionData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChatEmojiCollectionDataOuterClass$ChatEmojiCollectionData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChatEmojiCollectionDataOrBuilder {
            private int bitField0_;
            private Internal.IntList emojiIdList_ = ChatEmojiCollectionData.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ChatEmojiCollectionDataOuterClass.internal_static_ChatEmojiCollectionData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChatEmojiCollectionDataOuterClass.internal_static_ChatEmojiCollectionData_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatEmojiCollectionData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChatEmojiCollectionData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.emojiIdList_ = ChatEmojiCollectionData.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChatEmojiCollectionDataOuterClass.internal_static_ChatEmojiCollectionData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChatEmojiCollectionData getDefaultInstanceForType() {
                return ChatEmojiCollectionData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChatEmojiCollectionData build() {
                ChatEmojiCollectionData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChatEmojiCollectionData buildPartial() {
                ChatEmojiCollectionData result = new ChatEmojiCollectionData(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.emojiIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.emojiIdList_ = this.emojiIdList_;
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
                if (other instanceof ChatEmojiCollectionData) {
                    return mergeFrom((ChatEmojiCollectionData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChatEmojiCollectionData other) {
                if (other == ChatEmojiCollectionData.getDefaultInstance()) {
                    return this;
                }
                if (!other.emojiIdList_.isEmpty()) {
                    if (this.emojiIdList_.isEmpty()) {
                        this.emojiIdList_ = other.emojiIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureEmojiIdListIsMutable();
                        this.emojiIdList_.addAll(other.emojiIdList_);
                    }
                    onChanged();
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
                ChatEmojiCollectionData parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChatEmojiCollectionData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChatEmojiCollectionData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureEmojiIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.emojiIdList_ = ChatEmojiCollectionData.mutableCopy(this.emojiIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionDataOrBuilder
            public List<Integer> getEmojiIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.emojiIdList_) : this.emojiIdList_;
            }

            @Override // emu.grasscutter.net.proto.ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionDataOrBuilder
            public int getEmojiIdListCount() {
                return this.emojiIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionDataOrBuilder
            public int getEmojiIdList(int index) {
                return this.emojiIdList_.getInt(index);
            }

            public Builder setEmojiIdList(int index, int value) {
                ensureEmojiIdListIsMutable();
                this.emojiIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addEmojiIdList(int value) {
                ensureEmojiIdListIsMutable();
                this.emojiIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllEmojiIdList(Iterable<? extends Integer> values) {
                ensureEmojiIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.emojiIdList_);
                onChanged();
                return this;
            }

            public Builder clearEmojiIdList() {
                this.emojiIdList_ = ChatEmojiCollectionData.emptyIntList();
                this.bitField0_ &= -2;
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

        public static ChatEmojiCollectionData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChatEmojiCollectionData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChatEmojiCollectionData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChatEmojiCollectionData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
