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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChatInfoOuterClass.class */
public final class ChatInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000eChatInfo.proto\"Í\u0001\n\bChatInfo\u0012\u000e\n\u0006isRead\u0018\u0006 \u0001(\b\u0012\u000b\n\u0003uid\u0018\u000f \u0001(\r\u0012\r\n\u0005toUid\u0018\u0003 \u0001(\r\u0012\u000f\n\u0004text\u0018\u000e \u0001(\tH��\u0012\u000f\n\u0004icon\u0018\t \u0001(\rH��\u0012,\n\u000bsystem_hint\u0018\u0004 \u0001(\u000b2\u0014.ChatInfo.SystemHintH��\u0012\u0010\n\bsequence\u0018\u0002 \u0001(\r\u0012\f\n\u0004time\u0018\u000b \u0001(\r\u001a\u001a\n\nSystemHint\u0012\f\n\u0004type\u0018\u000e \u0001(\rB\t\n\u0007contentB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChatInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChatInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChatInfo_descriptor, new String[]{"IsRead", "Uid", "ToUid", "Text", "Icon", "SystemHint", "Sequence", "Time", "Content"});
    private static final Descriptors.Descriptor internal_static_ChatInfo_SystemHint_descriptor = internal_static_ChatInfo_descriptor.getNestedTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChatInfo_SystemHint_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChatInfo_SystemHint_descriptor, new String[]{"Type"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChatInfoOuterClass$ChatInfoOrBuilder.class */
    public interface ChatInfoOrBuilder extends MessageOrBuilder {
        boolean getIsRead();

        int getUid();

        int getToUid();

        boolean hasText();

        String getText();

        ByteString getTextBytes();

        boolean hasIcon();

        int getIcon();

        boolean hasSystemHint();

        ChatInfo.SystemHint getSystemHint();

        ChatInfo.SystemHintOrBuilder getSystemHintOrBuilder();

        int getSequence();

        int getTime();

        ChatInfo.ContentCase getContentCase();
    }

    private ChatInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChatInfoOuterClass$ChatInfo.class */
    public static final class ChatInfo extends GeneratedMessageV3 implements ChatInfoOrBuilder {
        private static final long serialVersionUID = 0;
        private int contentCase_;
        private Object content_;
        public static final int ISREAD_FIELD_NUMBER = 6;
        private boolean isRead_;
        public static final int UID_FIELD_NUMBER = 15;
        private int uid_;
        public static final int TOUID_FIELD_NUMBER = 3;
        private int toUid_;
        public static final int TEXT_FIELD_NUMBER = 1809;
        public static final int ICON_FIELD_NUMBER = 1168;
        public static final int SYSTEM_HINT_FIELD_NUMBER = 523;
        public static final int SEQUENCE_FIELD_NUMBER = 2;
        private int sequence_;
        public static final int TIME_FIELD_NUMBER = 11;
        private int time_;
        private byte memoizedIsInitialized;
        private static final ChatInfo DEFAULT_INSTANCE = new ChatInfo();
        private static final Parser<ChatInfo> PARSER = new AbstractParser<ChatInfo>() { // from class: emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfo.1
            @Override // com.google.protobuf.Parser
            public ChatInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChatInfo(input, extensionRegistry);
            }
        };

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChatInfoOuterClass$ChatInfo$SystemHintOrBuilder.class */
        public interface SystemHintOrBuilder extends MessageOrBuilder {
            int getType();
        }

        private ChatInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.contentCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private ChatInfo() {
            this.contentCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChatInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChatInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.sequence_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.toUid_ = input.readUInt32();
                                    break;
                                case 48:
                                    this.isRead_ = input.readBool();
                                    break;
                                case 88:
                                    this.time_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.uid_ = input.readUInt32();
                                    break;
                                case 4186:
                                    SystemHint.Builder subBuilder = this.contentCase_ == 523 ? ((SystemHint) this.content_).toBuilder() : null;
                                    this.content_ = input.readMessage(SystemHint.parser(), extensionRegistry);
                                    if (subBuilder != null) {
                                        subBuilder.mergeFrom((SystemHint) this.content_);
                                        this.content_ = subBuilder.buildPartial();
                                    }
                                    this.contentCase_ = 523;
                                    break;
                                case 9344:
                                    this.contentCase_ = ICON_FIELD_NUMBER;
                                    this.content_ = Integer.valueOf(input.readUInt32());
                                    break;
                                case 14474:
                                    String s = input.readStringRequireUtf8();
                                    this.contentCase_ = TEXT_FIELD_NUMBER;
                                    this.content_ = s;
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
            return ChatInfoOuterClass.internal_static_ChatInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChatInfoOuterClass.internal_static_ChatInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatInfo.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChatInfoOuterClass$ChatInfo$SystemHint.class */
        public static final class SystemHint extends GeneratedMessageV3 implements SystemHintOrBuilder {
            private static final long serialVersionUID = 0;
            public static final int TYPE_FIELD_NUMBER = 14;
            private int type_;
            private byte memoizedIsInitialized;
            private static final SystemHint DEFAULT_INSTANCE = new SystemHint();
            private static final Parser<SystemHint> PARSER = new AbstractParser<SystemHint>() { // from class: emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfo.SystemHint.1
                @Override // com.google.protobuf.Parser
                public SystemHint parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new SystemHint(input, extensionRegistry);
                }
            };

            private SystemHint(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
            }

            private SystemHint() {
                this.memoizedIsInitialized = -1;
            }

            /* access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
                return new SystemHint();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private SystemHint(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 112:
                                    this.type_ = input.readUInt32();
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
                return ChatInfoOuterClass.internal_static_ChatInfo_SystemHint_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChatInfoOuterClass.internal_static_ChatInfo_SystemHint_fieldAccessorTable.ensureFieldAccessorsInitialized(SystemHint.class, Builder.class);
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfo.SystemHintOrBuilder
            public int getType() {
                return this.type_;
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
                if (this.type_ != 0) {
                    output.writeUInt32(14, this.type_);
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
                if (this.type_ != 0) {
                    size2 = 0 + CodedOutputStream.computeUInt32Size(14, this.type_);
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
                if (!(obj instanceof SystemHint)) {
                    return equals(obj);
                }
                SystemHint other = (SystemHint) obj;
                return getType() == other.getType() && this.unknownFields.equals(other.unknownFields);
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getType())) + this.unknownFields.hashCode();
                this.memoizedHashCode = hash;
                return hash;
            }

            public static SystemHint parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static SystemHint parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static SystemHint parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static SystemHint parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static SystemHint parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static SystemHint parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static SystemHint parseFrom(InputStream input) throws IOException {
                return (SystemHint) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static SystemHint parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (SystemHint) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            public static SystemHint parseDelimitedFrom(InputStream input) throws IOException {
                return (SystemHint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
            }

            public static SystemHint parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (SystemHint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }

            public static SystemHint parseFrom(CodedInputStream input) throws IOException {
                return (SystemHint) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static SystemHint parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (SystemHint) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(SystemHint prototype) {
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

            /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChatInfoOuterClass$ChatInfo$SystemHint$Builder.class */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SystemHintOrBuilder {
                private int type_;

                public static final Descriptors.Descriptor getDescriptor() {
                    return ChatInfoOuterClass.internal_static_ChatInfo_SystemHint_descriptor;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return ChatInfoOuterClass.internal_static_ChatInfo_SystemHint_fieldAccessorTable.ensureFieldAccessorsInitialized(SystemHint.class, Builder.class);
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (SystemHint.alwaysUseFieldBuilders) {
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    clear();
                    this.type_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return ChatInfoOuterClass.internal_static_ChatInfo_SystemHint_descriptor;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public SystemHint getDefaultInstanceForType() {
                    return SystemHint.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public SystemHint build() {
                    SystemHint result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw newUninitializedMessageException((Message) result);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public SystemHint buildPartial() {
                    SystemHint result = new SystemHint(this);
                    result.type_ = this.type_;
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
                    if (other instanceof SystemHint) {
                        return mergeFrom((SystemHint) other);
                    }
                    mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(SystemHint other) {
                    if (other == SystemHint.getDefaultInstance()) {
                        return this;
                    }
                    if (other.getType() != 0) {
                        setType(other.getType());
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
                    SystemHint parsedMessage = null;
                    try {
                        try {
                            parsedMessage = SystemHint.PARSER.parsePartialFrom(input, extensionRegistry);
                            if (parsedMessage != null) {
                                mergeFrom(parsedMessage);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            parsedMessage = (SystemHint) e.getUnfinishedMessage();
                            throw e.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        throw th;
                    }
                }

                @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfo.SystemHintOrBuilder
                public int getType() {
                    return this.type_;
                }

                public Builder setType(int value) {
                    this.type_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearType() {
                    this.type_ = 0;
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

            public static SystemHint getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<SystemHint> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<SystemHint> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SystemHint getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChatInfoOuterClass$ChatInfo$ContentCase.class */
        public enum ContentCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            TEXT(ChatInfo.TEXT_FIELD_NUMBER),
            ICON(ChatInfo.ICON_FIELD_NUMBER),
            SYSTEM_HINT(523),
            CONTENT_NOT_SET(0);
            
            private final int value;

            ContentCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static ContentCase valueOf(int value) {
                return forNumber(value);
            }

            public static ContentCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return CONTENT_NOT_SET;
                    case 523:
                        return SYSTEM_HINT;
                    case ChatInfo.ICON_FIELD_NUMBER /* 1168 */:
                        return ICON;
                    case ChatInfo.TEXT_FIELD_NUMBER /* 1809 */:
                        return TEXT;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public ContentCase getContentCase() {
            return ContentCase.forNumber(this.contentCase_);
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public boolean getIsRead() {
            return this.isRead_;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public int getToUid() {
            return this.toUid_;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public boolean hasText() {
            return this.contentCase_ == 1809;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public String getText() {
            Object ref = "";
            if (this.contentCase_ == 1809) {
                ref = this.content_;
            }
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            if (this.contentCase_ == 1809) {
                this.content_ = s;
            }
            return s;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public ByteString getTextBytes() {
            Object ref = "";
            if (this.contentCase_ == 1809) {
                ref = this.content_;
            }
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            if (this.contentCase_ == 1809) {
                this.content_ = b;
            }
            return b;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public boolean hasIcon() {
            return this.contentCase_ == 1168;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public int getIcon() {
            if (this.contentCase_ == 1168) {
                return ((Integer) this.content_).intValue();
            }
            return 0;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public boolean hasSystemHint() {
            return this.contentCase_ == 523;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public SystemHint getSystemHint() {
            if (this.contentCase_ == 523) {
                return (SystemHint) this.content_;
            }
            return SystemHint.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public SystemHintOrBuilder getSystemHintOrBuilder() {
            if (this.contentCase_ == 523) {
                return (SystemHint) this.content_;
            }
            return SystemHint.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public int getSequence() {
            return this.sequence_;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public int getTime() {
            return this.time_;
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
            if (this.sequence_ != 0) {
                output.writeUInt32(2, this.sequence_);
            }
            if (this.toUid_ != 0) {
                output.writeUInt32(3, this.toUid_);
            }
            if (this.isRead_) {
                output.writeBool(6, this.isRead_);
            }
            if (this.time_ != 0) {
                output.writeUInt32(11, this.time_);
            }
            if (this.uid_ != 0) {
                output.writeUInt32(15, this.uid_);
            }
            if (this.contentCase_ == 523) {
                output.writeMessage(523, (SystemHint) this.content_);
            }
            if (this.contentCase_ == 1168) {
                output.writeUInt32(ICON_FIELD_NUMBER, ((Integer) this.content_).intValue());
            }
            if (this.contentCase_ == 1809) {
                GeneratedMessageV3.writeString(output, TEXT_FIELD_NUMBER, this.content_);
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
            if (this.sequence_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.sequence_);
            }
            if (this.toUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.toUid_);
            }
            if (this.isRead_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isRead_);
            }
            if (this.time_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.time_);
            }
            if (this.uid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.uid_);
            }
            if (this.contentCase_ == 523) {
                size2 += CodedOutputStream.computeMessageSize(523, (SystemHint) this.content_);
            }
            if (this.contentCase_ == 1168) {
                size2 += CodedOutputStream.computeUInt32Size(ICON_FIELD_NUMBER, ((Integer) this.content_).intValue());
            }
            if (this.contentCase_ == 1809) {
                size2 += GeneratedMessageV3.computeStringSize(TEXT_FIELD_NUMBER, this.content_);
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
            if (!(obj instanceof ChatInfo)) {
                return equals(obj);
            }
            ChatInfo other = (ChatInfo) obj;
            if (getIsRead() != other.getIsRead() || getUid() != other.getUid() || getToUid() != other.getToUid() || getSequence() != other.getSequence() || getTime() != other.getTime() || !getContentCase().equals(other.getContentCase())) {
                return false;
            }
            switch (this.contentCase_) {
                case 523:
                    if (!getSystemHint().equals(other.getSystemHint())) {
                        return false;
                    }
                    break;
                case ICON_FIELD_NUMBER /* 1168 */:
                    if (getIcon() != other.getIcon()) {
                        return false;
                    }
                    break;
                case TEXT_FIELD_NUMBER /* 1809 */:
                    if (!getText().equals(other.getText())) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + Internal.hashBoolean(getIsRead()))) + 15)) + getUid())) + 3)) + getToUid())) + 2)) + getSequence())) + 11)) + getTime();
            switch (this.contentCase_) {
                case 523:
                    hash = (53 * ((37 * hash) + 523)) + getSystemHint().hashCode();
                    break;
                case ICON_FIELD_NUMBER /* 1168 */:
                    hash = (53 * ((37 * hash) + ICON_FIELD_NUMBER)) + getIcon();
                    break;
                case TEXT_FIELD_NUMBER /* 1809 */:
                    hash = (53 * ((37 * hash) + TEXT_FIELD_NUMBER)) + getText().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ChatInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChatInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChatInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChatInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChatInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChatInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChatInfo parseFrom(InputStream input) throws IOException {
            return (ChatInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChatInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChatInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChatInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ChatInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChatInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChatInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChatInfo parseFrom(CodedInputStream input) throws IOException {
            return (ChatInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChatInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChatInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChatInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChatInfoOuterClass$ChatInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChatInfoOrBuilder {
            private int contentCase_ = 0;
            private Object content_;
            private boolean isRead_;
            private int uid_;
            private int toUid_;
            private SingleFieldBuilderV3<SystemHint, SystemHint.Builder, SystemHintOrBuilder> systemHintBuilder_;
            private int sequence_;
            private int time_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChatInfoOuterClass.internal_static_ChatInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChatInfoOuterClass.internal_static_ChatInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChatInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isRead_ = false;
                this.uid_ = 0;
                this.toUid_ = 0;
                this.sequence_ = 0;
                this.time_ = 0;
                this.contentCase_ = 0;
                this.content_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChatInfoOuterClass.internal_static_ChatInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChatInfo getDefaultInstanceForType() {
                return ChatInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChatInfo build() {
                ChatInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChatInfo buildPartial() {
                ChatInfo result = new ChatInfo(this);
                result.isRead_ = this.isRead_;
                result.uid_ = this.uid_;
                result.toUid_ = this.toUid_;
                if (this.contentCase_ == 1809) {
                    result.content_ = this.content_;
                }
                if (this.contentCase_ == 1168) {
                    result.content_ = this.content_;
                }
                if (this.contentCase_ == 523) {
                    if (this.systemHintBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.systemHintBuilder_.build();
                    }
                }
                result.sequence_ = this.sequence_;
                result.time_ = this.time_;
                result.contentCase_ = this.contentCase_;
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
                if (other instanceof ChatInfo) {
                    return mergeFrom((ChatInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChatInfo other) {
                if (other == ChatInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsRead()) {
                    setIsRead(other.getIsRead());
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (other.getToUid() != 0) {
                    setToUid(other.getToUid());
                }
                if (other.getSequence() != 0) {
                    setSequence(other.getSequence());
                }
                if (other.getTime() != 0) {
                    setTime(other.getTime());
                }
                switch (other.getContentCase()) {
                    case TEXT:
                        this.contentCase_ = ChatInfo.TEXT_FIELD_NUMBER;
                        this.content_ = other.content_;
                        onChanged();
                        break;
                    case ICON:
                        setIcon(other.getIcon());
                        break;
                    case SYSTEM_HINT:
                        mergeSystemHint(other.getSystemHint());
                        break;
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
                ChatInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChatInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChatInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public ContentCase getContentCase() {
                return ContentCase.forNumber(this.contentCase_);
            }

            public Builder clearContent() {
                this.contentCase_ = 0;
                this.content_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public boolean getIsRead() {
                return this.isRead_;
            }

            public Builder setIsRead(boolean value) {
                this.isRead_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsRead() {
                this.isRead_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public int getUid() {
                return this.uid_;
            }

            public Builder setUid(int value) {
                this.uid_ = value;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public int getToUid() {
                return this.toUid_;
            }

            public Builder setToUid(int value) {
                this.toUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearToUid() {
                this.toUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public boolean hasText() {
                return this.contentCase_ == 1809;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public String getText() {
                Object ref = "";
                if (this.contentCase_ == 1809) {
                    ref = this.content_;
                }
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                if (this.contentCase_ == 1809) {
                    this.content_ = s;
                }
                return s;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public ByteString getTextBytes() {
                Object ref = "";
                if (this.contentCase_ == 1809) {
                    ref = this.content_;
                }
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                if (this.contentCase_ == 1809) {
                    this.content_ = b;
                }
                return b;
            }

            public Builder setText(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.contentCase_ = ChatInfo.TEXT_FIELD_NUMBER;
                this.content_ = value;
                onChanged();
                return this;
            }

            public Builder clearText() {
                if (this.contentCase_ == 1809) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder setTextBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ChatInfo.checkByteStringIsUtf8(value);
                this.contentCase_ = ChatInfo.TEXT_FIELD_NUMBER;
                this.content_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public boolean hasIcon() {
                return this.contentCase_ == 1168;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public int getIcon() {
                if (this.contentCase_ == 1168) {
                    return ((Integer) this.content_).intValue();
                }
                return 0;
            }

            public Builder setIcon(int value) {
                this.contentCase_ = ChatInfo.ICON_FIELD_NUMBER;
                this.content_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearIcon() {
                if (this.contentCase_ == 1168) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public boolean hasSystemHint() {
                return this.contentCase_ == 523;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public SystemHint getSystemHint() {
                if (this.systemHintBuilder_ == null) {
                    if (this.contentCase_ == 523) {
                        return (SystemHint) this.content_;
                    }
                    return SystemHint.getDefaultInstance();
                } else if (this.contentCase_ == 523) {
                    return this.systemHintBuilder_.getMessage();
                } else {
                    return SystemHint.getDefaultInstance();
                }
            }

            public Builder setSystemHint(SystemHint value) {
                if (this.systemHintBuilder_ != null) {
                    this.systemHintBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 523;
                return this;
            }

            public Builder setSystemHint(SystemHint.Builder builderForValue) {
                if (this.systemHintBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.systemHintBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 523;
                return this;
            }

            public Builder mergeSystemHint(SystemHint value) {
                if (this.systemHintBuilder_ == null) {
                    if (this.contentCase_ != 523 || this.content_ == SystemHint.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = SystemHint.newBuilder((SystemHint) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 523) {
                        this.systemHintBuilder_.mergeFrom(value);
                    }
                    this.systemHintBuilder_.setMessage(value);
                }
                this.contentCase_ = 523;
                return this;
            }

            public Builder clearSystemHint() {
                if (this.systemHintBuilder_ != null) {
                    if (this.contentCase_ == 523) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.systemHintBuilder_.clear();
                } else if (this.contentCase_ == 523) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public SystemHint.Builder getSystemHintBuilder() {
                return getSystemHintFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public SystemHintOrBuilder getSystemHintOrBuilder() {
                if (this.contentCase_ == 523 && this.systemHintBuilder_ != null) {
                    return this.systemHintBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 523) {
                    return (SystemHint) this.content_;
                }
                return SystemHint.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SystemHint, SystemHint.Builder, SystemHintOrBuilder> getSystemHintFieldBuilder() {
                if (this.systemHintBuilder_ == null) {
                    if (this.contentCase_ != 523) {
                        this.content_ = SystemHint.getDefaultInstance();
                    }
                    this.systemHintBuilder_ = new SingleFieldBuilderV3<>((SystemHint) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 523;
                onChanged();
                return this.systemHintBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public int getSequence() {
                return this.sequence_;
            }

            public Builder setSequence(int value) {
                this.sequence_ = value;
                onChanged();
                return this;
            }

            public Builder clearSequence() {
                this.sequence_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public int getTime() {
                return this.time_;
            }

            public Builder setTime(int value) {
                this.time_ = value;
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.time_ = 0;
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

        public static ChatInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChatInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChatInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChatInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
