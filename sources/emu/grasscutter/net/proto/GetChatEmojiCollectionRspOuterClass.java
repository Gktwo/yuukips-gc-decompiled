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
import emu.grasscutter.net.proto.ChatEmojiCollectionDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetChatEmojiCollectionRspOuterClass.class */
public final class GetChatEmojiCollectionRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fGetChatEmojiCollectionRsp.proto\u001a\u001dChatEmojiCollectionData.proto\"g\n\u0019GetChatEmojiCollectionRsp\u0012\u000f\n\u0007retcode\u0018\u0004 \u0001(\u0005\u00129\n\u0017chatEmojiCollectionData\u0018\f \u0001(\u000b2\u0018.ChatEmojiCollectionDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ChatEmojiCollectionDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetChatEmojiCollectionRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetChatEmojiCollectionRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetChatEmojiCollectionRsp_descriptor, new String[]{"Retcode", "ChatEmojiCollectionData"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetChatEmojiCollectionRspOuterClass$GetChatEmojiCollectionRspOrBuilder.class */
    public interface GetChatEmojiCollectionRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        boolean hasChatEmojiCollectionData();

        ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData getChatEmojiCollectionData();

        ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionDataOrBuilder getChatEmojiCollectionDataOrBuilder();
    }

    private GetChatEmojiCollectionRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetChatEmojiCollectionRspOuterClass$GetChatEmojiCollectionRsp.class */
    public static final class GetChatEmojiCollectionRsp extends GeneratedMessageV3 implements GetChatEmojiCollectionRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 4;
        private int retcode_;
        public static final int CHATEMOJICOLLECTIONDATA_FIELD_NUMBER = 12;
        private ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData chatEmojiCollectionData_;
        private byte memoizedIsInitialized;
        private static final GetChatEmojiCollectionRsp DEFAULT_INSTANCE = new GetChatEmojiCollectionRsp();
        private static final Parser<GetChatEmojiCollectionRsp> PARSER = new AbstractParser<GetChatEmojiCollectionRsp>() { // from class: emu.grasscutter.net.proto.GetChatEmojiCollectionRspOuterClass.GetChatEmojiCollectionRsp.1
            @Override // com.google.protobuf.Parser
            public GetChatEmojiCollectionRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetChatEmojiCollectionRsp(input, extensionRegistry);
            }
        };

        private GetChatEmojiCollectionRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetChatEmojiCollectionRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetChatEmojiCollectionRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetChatEmojiCollectionRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 98:
                                    ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData.Builder subBuilder = this.chatEmojiCollectionData_ != null ? this.chatEmojiCollectionData_.toBuilder() : null;
                                    this.chatEmojiCollectionData_ = (ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData) input.readMessage(ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.chatEmojiCollectionData_);
                                        this.chatEmojiCollectionData_ = subBuilder.buildPartial();
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
            return GetChatEmojiCollectionRspOuterClass.internal_static_GetChatEmojiCollectionRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetChatEmojiCollectionRspOuterClass.internal_static_GetChatEmojiCollectionRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetChatEmojiCollectionRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetChatEmojiCollectionRspOuterClass.GetChatEmojiCollectionRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetChatEmojiCollectionRspOuterClass.GetChatEmojiCollectionRspOrBuilder
        public boolean hasChatEmojiCollectionData() {
            return this.chatEmojiCollectionData_ != null;
        }

        @Override // emu.grasscutter.net.proto.GetChatEmojiCollectionRspOuterClass.GetChatEmojiCollectionRspOrBuilder
        public ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData getChatEmojiCollectionData() {
            return this.chatEmojiCollectionData_ == null ? ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData.getDefaultInstance() : this.chatEmojiCollectionData_;
        }

        @Override // emu.grasscutter.net.proto.GetChatEmojiCollectionRspOuterClass.GetChatEmojiCollectionRspOrBuilder
        public ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionDataOrBuilder getChatEmojiCollectionDataOrBuilder() {
            return getChatEmojiCollectionData();
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
                output.writeInt32(4, this.retcode_);
            }
            if (this.chatEmojiCollectionData_ != null) {
                output.writeMessage(12, getChatEmojiCollectionData());
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
                size2 = 0 + CodedOutputStream.computeInt32Size(4, this.retcode_);
            }
            if (this.chatEmojiCollectionData_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getChatEmojiCollectionData());
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
            if (!(obj instanceof GetChatEmojiCollectionRsp)) {
                return equals(obj);
            }
            GetChatEmojiCollectionRsp other = (GetChatEmojiCollectionRsp) obj;
            if (getRetcode() == other.getRetcode() && hasChatEmojiCollectionData() == other.hasChatEmojiCollectionData()) {
                return (!hasChatEmojiCollectionData() || getChatEmojiCollectionData().equals(other.getChatEmojiCollectionData())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getRetcode();
            if (hasChatEmojiCollectionData()) {
                hash = (53 * ((37 * hash) + 12)) + getChatEmojiCollectionData().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetChatEmojiCollectionRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetChatEmojiCollectionRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetChatEmojiCollectionRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetChatEmojiCollectionRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetChatEmojiCollectionRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetChatEmojiCollectionRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetChatEmojiCollectionRsp parseFrom(InputStream input) throws IOException {
            return (GetChatEmojiCollectionRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetChatEmojiCollectionRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetChatEmojiCollectionRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetChatEmojiCollectionRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetChatEmojiCollectionRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetChatEmojiCollectionRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetChatEmojiCollectionRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetChatEmojiCollectionRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetChatEmojiCollectionRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetChatEmojiCollectionRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetChatEmojiCollectionRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetChatEmojiCollectionRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetChatEmojiCollectionRspOuterClass$GetChatEmojiCollectionRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetChatEmojiCollectionRspOrBuilder {
            private int retcode_;
            private ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData chatEmojiCollectionData_;
            private SingleFieldBuilderV3<ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData, ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData.Builder, ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionDataOrBuilder> chatEmojiCollectionDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetChatEmojiCollectionRspOuterClass.internal_static_GetChatEmojiCollectionRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetChatEmojiCollectionRspOuterClass.internal_static_GetChatEmojiCollectionRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetChatEmojiCollectionRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetChatEmojiCollectionRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                if (this.chatEmojiCollectionDataBuilder_ == null) {
                    this.chatEmojiCollectionData_ = null;
                } else {
                    this.chatEmojiCollectionData_ = null;
                    this.chatEmojiCollectionDataBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetChatEmojiCollectionRspOuterClass.internal_static_GetChatEmojiCollectionRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetChatEmojiCollectionRsp getDefaultInstanceForType() {
                return GetChatEmojiCollectionRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetChatEmojiCollectionRsp build() {
                GetChatEmojiCollectionRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetChatEmojiCollectionRsp buildPartial() {
                GetChatEmojiCollectionRsp result = new GetChatEmojiCollectionRsp(this);
                result.retcode_ = this.retcode_;
                if (this.chatEmojiCollectionDataBuilder_ == null) {
                    result.chatEmojiCollectionData_ = this.chatEmojiCollectionData_;
                } else {
                    result.chatEmojiCollectionData_ = this.chatEmojiCollectionDataBuilder_.build();
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
                if (other instanceof GetChatEmojiCollectionRsp) {
                    return mergeFrom((GetChatEmojiCollectionRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetChatEmojiCollectionRsp other) {
                if (other == GetChatEmojiCollectionRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.hasChatEmojiCollectionData()) {
                    mergeChatEmojiCollectionData(other.getChatEmojiCollectionData());
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
                GetChatEmojiCollectionRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetChatEmojiCollectionRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetChatEmojiCollectionRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetChatEmojiCollectionRspOuterClass.GetChatEmojiCollectionRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetChatEmojiCollectionRspOuterClass.GetChatEmojiCollectionRspOrBuilder
            public boolean hasChatEmojiCollectionData() {
                return (this.chatEmojiCollectionDataBuilder_ == null && this.chatEmojiCollectionData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GetChatEmojiCollectionRspOuterClass.GetChatEmojiCollectionRspOrBuilder
            public ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData getChatEmojiCollectionData() {
                if (this.chatEmojiCollectionDataBuilder_ == null) {
                    return this.chatEmojiCollectionData_ == null ? ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData.getDefaultInstance() : this.chatEmojiCollectionData_;
                }
                return this.chatEmojiCollectionDataBuilder_.getMessage();
            }

            public Builder setChatEmojiCollectionData(ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData value) {
                if (this.chatEmojiCollectionDataBuilder_ != null) {
                    this.chatEmojiCollectionDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.chatEmojiCollectionData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setChatEmojiCollectionData(ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData.Builder builderForValue) {
                if (this.chatEmojiCollectionDataBuilder_ == null) {
                    this.chatEmojiCollectionData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.chatEmojiCollectionDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeChatEmojiCollectionData(ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData value) {
                if (this.chatEmojiCollectionDataBuilder_ == null) {
                    if (this.chatEmojiCollectionData_ != null) {
                        this.chatEmojiCollectionData_ = ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData.newBuilder(this.chatEmojiCollectionData_).mergeFrom(value).buildPartial();
                    } else {
                        this.chatEmojiCollectionData_ = value;
                    }
                    onChanged();
                } else {
                    this.chatEmojiCollectionDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearChatEmojiCollectionData() {
                if (this.chatEmojiCollectionDataBuilder_ == null) {
                    this.chatEmojiCollectionData_ = null;
                    onChanged();
                } else {
                    this.chatEmojiCollectionData_ = null;
                    this.chatEmojiCollectionDataBuilder_ = null;
                }
                return this;
            }

            public ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData.Builder getChatEmojiCollectionDataBuilder() {
                onChanged();
                return getChatEmojiCollectionDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GetChatEmojiCollectionRspOuterClass.GetChatEmojiCollectionRspOrBuilder
            public ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionDataOrBuilder getChatEmojiCollectionDataOrBuilder() {
                if (this.chatEmojiCollectionDataBuilder_ != null) {
                    return this.chatEmojiCollectionDataBuilder_.getMessageOrBuilder();
                }
                return this.chatEmojiCollectionData_ == null ? ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData.getDefaultInstance() : this.chatEmojiCollectionData_;
            }

            private SingleFieldBuilderV3<ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData, ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData.Builder, ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionDataOrBuilder> getChatEmojiCollectionDataFieldBuilder() {
                if (this.chatEmojiCollectionDataBuilder_ == null) {
                    this.chatEmojiCollectionDataBuilder_ = new SingleFieldBuilderV3<>(getChatEmojiCollectionData(), getParentForChildren(), isClean());
                    this.chatEmojiCollectionData_ = null;
                }
                return this.chatEmojiCollectionDataBuilder_;
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

        public static GetChatEmojiCollectionRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetChatEmojiCollectionRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetChatEmojiCollectionRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetChatEmojiCollectionRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ChatEmojiCollectionDataOuterClass.getDescriptor();
    }
}
