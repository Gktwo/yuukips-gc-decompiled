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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ChatInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PullPrivateChatRspOuterClass.class */
public final class PullPrivateChatRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018PullPrivateChatRsp.proto\u001a\u000eChatInfo.proto\"B\n\u0012PullPrivateChatRsp\u0012\u001b\n\bchatInfo\u0018\t \u0003(\u000b2\t.ChatInfo\u0012\u000f\n\u0007retcode\u0018\u000b \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ChatInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PullPrivateChatRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PullPrivateChatRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PullPrivateChatRsp_descriptor, new String[]{"ChatInfo", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PullPrivateChatRspOuterClass$PullPrivateChatRspOrBuilder.class */
    public interface PullPrivateChatRspOrBuilder extends MessageOrBuilder {
        List<ChatInfoOuterClass.ChatInfo> getChatInfoList();

        ChatInfoOuterClass.ChatInfo getChatInfo(int i);

        int getChatInfoCount();

        List<? extends ChatInfoOuterClass.ChatInfoOrBuilder> getChatInfoOrBuilderList();

        ChatInfoOuterClass.ChatInfoOrBuilder getChatInfoOrBuilder(int i);

        int getRetcode();
    }

    private PullPrivateChatRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PullPrivateChatRspOuterClass$PullPrivateChatRsp.class */
    public static final class PullPrivateChatRsp extends GeneratedMessageV3 implements PullPrivateChatRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHATINFO_FIELD_NUMBER = 9;
        private List<ChatInfoOuterClass.ChatInfo> chatInfo_;
        public static final int RETCODE_FIELD_NUMBER = 11;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final PullPrivateChatRsp DEFAULT_INSTANCE = new PullPrivateChatRsp();
        private static final Parser<PullPrivateChatRsp> PARSER = new AbstractParser<PullPrivateChatRsp>() { // from class: emu.grasscutter.net.proto.PullPrivateChatRspOuterClass.PullPrivateChatRsp.1
            @Override // com.google.protobuf.Parser
            public PullPrivateChatRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PullPrivateChatRsp(input, extensionRegistry);
            }
        };

        private PullPrivateChatRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PullPrivateChatRsp() {
            this.memoizedIsInitialized = -1;
            this.chatInfo_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PullPrivateChatRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PullPrivateChatRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 74:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.chatInfo_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.chatInfo_.add((ChatInfoOuterClass.ChatInfo) input.readMessage(ChatInfoOuterClass.ChatInfo.parser(), extensionRegistry));
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.chatInfo_ = Collections.unmodifiableList(this.chatInfo_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PullPrivateChatRspOuterClass.internal_static_PullPrivateChatRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PullPrivateChatRspOuterClass.internal_static_PullPrivateChatRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PullPrivateChatRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PullPrivateChatRspOuterClass.PullPrivateChatRspOrBuilder
        public List<ChatInfoOuterClass.ChatInfo> getChatInfoList() {
            return this.chatInfo_;
        }

        @Override // emu.grasscutter.net.proto.PullPrivateChatRspOuterClass.PullPrivateChatRspOrBuilder
        public List<? extends ChatInfoOuterClass.ChatInfoOrBuilder> getChatInfoOrBuilderList() {
            return this.chatInfo_;
        }

        @Override // emu.grasscutter.net.proto.PullPrivateChatRspOuterClass.PullPrivateChatRspOrBuilder
        public int getChatInfoCount() {
            return this.chatInfo_.size();
        }

        @Override // emu.grasscutter.net.proto.PullPrivateChatRspOuterClass.PullPrivateChatRspOrBuilder
        public ChatInfoOuterClass.ChatInfo getChatInfo(int index) {
            return this.chatInfo_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PullPrivateChatRspOuterClass.PullPrivateChatRspOrBuilder
        public ChatInfoOuterClass.ChatInfoOrBuilder getChatInfoOrBuilder(int index) {
            return this.chatInfo_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PullPrivateChatRspOuterClass.PullPrivateChatRspOrBuilder
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
            for (int i = 0; i < this.chatInfo_.size(); i++) {
                output.writeMessage(9, this.chatInfo_.get(i));
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
            for (int i = 0; i < this.chatInfo_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.chatInfo_.get(i));
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
            if (!(obj instanceof PullPrivateChatRsp)) {
                return equals(obj);
            }
            PullPrivateChatRsp other = (PullPrivateChatRsp) obj;
            return getChatInfoList().equals(other.getChatInfoList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getChatInfoCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getChatInfoList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 11)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PullPrivateChatRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PullPrivateChatRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PullPrivateChatRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PullPrivateChatRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PullPrivateChatRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PullPrivateChatRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PullPrivateChatRsp parseFrom(InputStream input) throws IOException {
            return (PullPrivateChatRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PullPrivateChatRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PullPrivateChatRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PullPrivateChatRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (PullPrivateChatRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PullPrivateChatRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PullPrivateChatRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PullPrivateChatRsp parseFrom(CodedInputStream input) throws IOException {
            return (PullPrivateChatRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PullPrivateChatRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PullPrivateChatRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PullPrivateChatRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PullPrivateChatRspOuterClass$PullPrivateChatRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PullPrivateChatRspOrBuilder {
            private int bitField0_;
            private List<ChatInfoOuterClass.ChatInfo> chatInfo_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ChatInfoOuterClass.ChatInfo, ChatInfoOuterClass.ChatInfo.Builder, ChatInfoOuterClass.ChatInfoOrBuilder> chatInfoBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PullPrivateChatRspOuterClass.internal_static_PullPrivateChatRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PullPrivateChatRspOuterClass.internal_static_PullPrivateChatRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PullPrivateChatRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PullPrivateChatRsp.alwaysUseFieldBuilders) {
                    getChatInfoFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.chatInfoBuilder_ == null) {
                    this.chatInfo_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.chatInfoBuilder_.clear();
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PullPrivateChatRspOuterClass.internal_static_PullPrivateChatRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PullPrivateChatRsp getDefaultInstanceForType() {
                return PullPrivateChatRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PullPrivateChatRsp build() {
                PullPrivateChatRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PullPrivateChatRsp buildPartial() {
                PullPrivateChatRsp result = new PullPrivateChatRsp(this);
                int i = this.bitField0_;
                if (this.chatInfoBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.chatInfo_ = Collections.unmodifiableList(this.chatInfo_);
                        this.bitField0_ &= -2;
                    }
                    result.chatInfo_ = this.chatInfo_;
                } else {
                    result.chatInfo_ = this.chatInfoBuilder_.build();
                }
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
                if (other instanceof PullPrivateChatRsp) {
                    return mergeFrom((PullPrivateChatRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PullPrivateChatRsp other) {
                if (other == PullPrivateChatRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.chatInfoBuilder_ == null) {
                    if (!other.chatInfo_.isEmpty()) {
                        if (this.chatInfo_.isEmpty()) {
                            this.chatInfo_ = other.chatInfo_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureChatInfoIsMutable();
                            this.chatInfo_.addAll(other.chatInfo_);
                        }
                        onChanged();
                    }
                } else if (!other.chatInfo_.isEmpty()) {
                    if (this.chatInfoBuilder_.isEmpty()) {
                        this.chatInfoBuilder_.dispose();
                        this.chatInfoBuilder_ = null;
                        this.chatInfo_ = other.chatInfo_;
                        this.bitField0_ &= -2;
                        this.chatInfoBuilder_ = PullPrivateChatRsp.alwaysUseFieldBuilders ? getChatInfoFieldBuilder() : null;
                    } else {
                        this.chatInfoBuilder_.addAllMessages(other.chatInfo_);
                    }
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
                PullPrivateChatRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = PullPrivateChatRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PullPrivateChatRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureChatInfoIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.chatInfo_ = new ArrayList(this.chatInfo_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.PullPrivateChatRspOuterClass.PullPrivateChatRspOrBuilder
            public List<ChatInfoOuterClass.ChatInfo> getChatInfoList() {
                if (this.chatInfoBuilder_ == null) {
                    return Collections.unmodifiableList(this.chatInfo_);
                }
                return this.chatInfoBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PullPrivateChatRspOuterClass.PullPrivateChatRspOrBuilder
            public int getChatInfoCount() {
                if (this.chatInfoBuilder_ == null) {
                    return this.chatInfo_.size();
                }
                return this.chatInfoBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PullPrivateChatRspOuterClass.PullPrivateChatRspOrBuilder
            public ChatInfoOuterClass.ChatInfo getChatInfo(int index) {
                if (this.chatInfoBuilder_ == null) {
                    return this.chatInfo_.get(index);
                }
                return this.chatInfoBuilder_.getMessage(index);
            }

            public Builder setChatInfo(int index, ChatInfoOuterClass.ChatInfo value) {
                if (this.chatInfoBuilder_ != null) {
                    this.chatInfoBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChatInfoIsMutable();
                    this.chatInfo_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setChatInfo(int index, ChatInfoOuterClass.ChatInfo.Builder builderForValue) {
                if (this.chatInfoBuilder_ == null) {
                    ensureChatInfoIsMutable();
                    this.chatInfo_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.chatInfoBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addChatInfo(ChatInfoOuterClass.ChatInfo value) {
                if (this.chatInfoBuilder_ != null) {
                    this.chatInfoBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChatInfoIsMutable();
                    this.chatInfo_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addChatInfo(int index, ChatInfoOuterClass.ChatInfo value) {
                if (this.chatInfoBuilder_ != null) {
                    this.chatInfoBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChatInfoIsMutable();
                    this.chatInfo_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addChatInfo(ChatInfoOuterClass.ChatInfo.Builder builderForValue) {
                if (this.chatInfoBuilder_ == null) {
                    ensureChatInfoIsMutable();
                    this.chatInfo_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.chatInfoBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addChatInfo(int index, ChatInfoOuterClass.ChatInfo.Builder builderForValue) {
                if (this.chatInfoBuilder_ == null) {
                    ensureChatInfoIsMutable();
                    this.chatInfo_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.chatInfoBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllChatInfo(Iterable<? extends ChatInfoOuterClass.ChatInfo> values) {
                if (this.chatInfoBuilder_ == null) {
                    ensureChatInfoIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.chatInfo_);
                    onChanged();
                } else {
                    this.chatInfoBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearChatInfo() {
                if (this.chatInfoBuilder_ == null) {
                    this.chatInfo_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.chatInfoBuilder_.clear();
                }
                return this;
            }

            public Builder removeChatInfo(int index) {
                if (this.chatInfoBuilder_ == null) {
                    ensureChatInfoIsMutable();
                    this.chatInfo_.remove(index);
                    onChanged();
                } else {
                    this.chatInfoBuilder_.remove(index);
                }
                return this;
            }

            public ChatInfoOuterClass.ChatInfo.Builder getChatInfoBuilder(int index) {
                return getChatInfoFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PullPrivateChatRspOuterClass.PullPrivateChatRspOrBuilder
            public ChatInfoOuterClass.ChatInfoOrBuilder getChatInfoOrBuilder(int index) {
                if (this.chatInfoBuilder_ == null) {
                    return this.chatInfo_.get(index);
                }
                return this.chatInfoBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PullPrivateChatRspOuterClass.PullPrivateChatRspOrBuilder
            public List<? extends ChatInfoOuterClass.ChatInfoOrBuilder> getChatInfoOrBuilderList() {
                if (this.chatInfoBuilder_ != null) {
                    return this.chatInfoBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.chatInfo_);
            }

            public ChatInfoOuterClass.ChatInfo.Builder addChatInfoBuilder() {
                return getChatInfoFieldBuilder().addBuilder(ChatInfoOuterClass.ChatInfo.getDefaultInstance());
            }

            public ChatInfoOuterClass.ChatInfo.Builder addChatInfoBuilder(int index) {
                return getChatInfoFieldBuilder().addBuilder(index, ChatInfoOuterClass.ChatInfo.getDefaultInstance());
            }

            public List<ChatInfoOuterClass.ChatInfo.Builder> getChatInfoBuilderList() {
                return getChatInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ChatInfoOuterClass.ChatInfo, ChatInfoOuterClass.ChatInfo.Builder, ChatInfoOuterClass.ChatInfoOrBuilder> getChatInfoFieldBuilder() {
                if (this.chatInfoBuilder_ == null) {
                    this.chatInfoBuilder_ = new RepeatedFieldBuilderV3<>(this.chatInfo_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.chatInfo_ = null;
                }
                return this.chatInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PullPrivateChatRspOuterClass.PullPrivateChatRspOrBuilder
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

        public static PullPrivateChatRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PullPrivateChatRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PullPrivateChatRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PullPrivateChatRsp getDefaultInstanceForType() {
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
