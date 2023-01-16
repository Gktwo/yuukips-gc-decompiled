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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChatInfoOuterClass.class */
public final class ChatInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000eChatInfo.proto\"Ï\u0002\n\bChatInfo\u0012\u000f\n\u0007is_read\u0018\u0003 \u0001(\b\u0012\f\n\u0004time\u0018\u0001 \u0001(\r\u0012\u000e\n\u0006to_uid\u0018\n \u0001(\r\u0012\u000b\n\u0003uid\u0018\u000b \u0001(\r\u0012\u0010\n\bsequence\u0018\u0005 \u0001(\r\u0012\u000f\n\u0004text\u0018\u0007 \u0001(\tH��\u0012\u000f\n\u0004icon\u0018Þ\u0007 \u0001(\rH��\u0012,\n\u000bsystem_hint\u0018\u0006 \u0001(\u000b2\u0014.ChatInfo.SystemHintH��\u001a\u001a\n\nSystemHint\u0012\f\n\u0004type\u0018\u000f \u0001(\r\"~\n\u000eSystemHintType\u0012\u001e\n\u001aSYSTEM_HINT_TYPE_CHAT_NONE\u0010��\u0012%\n!SYSTEM_HINT_TYPE_CHAT_ENTER_WORLD\u0010\u0001\u0012%\n!SYSTEM_HINT_TYPE_CHAT_LEAVE_WORLD\u0010\u0002B\t\n\u0007contentB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChatInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChatInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChatInfo_descriptor, new String[]{"IsRead", "Time", "ToUid", "Uid", "Sequence", "Text", "Icon", "SystemHint", "Content"});
    private static final Descriptors.Descriptor internal_static_ChatInfo_SystemHint_descriptor = internal_static_ChatInfo_descriptor.getNestedTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChatInfo_SystemHint_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChatInfo_SystemHint_descriptor, new String[]{"Type"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChatInfoOuterClass$ChatInfoOrBuilder.class */
    public interface ChatInfoOrBuilder extends MessageOrBuilder {
        boolean getIsRead();

        int getTime();

        int getToUid();

        int getUid();

        int getSequence();

        boolean hasText();

        String getText();

        ByteString getTextBytes();

        boolean hasIcon();

        int getIcon();

        boolean hasSystemHint();

        ChatInfo.SystemHint getSystemHint();

        ChatInfo.SystemHintOrBuilder getSystemHintOrBuilder();

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
        public static final int IS_READ_FIELD_NUMBER = 3;
        private boolean isRead_;
        public static final int TIME_FIELD_NUMBER = 1;
        private int time_;
        public static final int TO_UID_FIELD_NUMBER = 10;
        private int toUid_;
        public static final int UID_FIELD_NUMBER = 11;
        private int uid_;
        public static final int SEQUENCE_FIELD_NUMBER = 5;
        private int sequence_;
        public static final int TEXT_FIELD_NUMBER = 909;
        public static final int ICON_FIELD_NUMBER = 990;
        public static final int SYSTEM_HINT_FIELD_NUMBER = 799;
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
                                case 8:
                                    this.time_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.isRead_ = input.readBool();
                                    break;
                                case 40:
                                    this.sequence_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.toUid_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.uid_ = input.readUInt32();
                                    break;
                                case 6394:
                                    SystemHint.Builder subBuilder = this.contentCase_ == 799 ? ((SystemHint) this.content_).toBuilder() : null;
                                    this.content_ = input.readMessage(SystemHint.parser(), extensionRegistry);
                                    if (subBuilder != null) {
                                        subBuilder.mergeFrom((SystemHint) this.content_);
                                        this.content_ = subBuilder.buildPartial();
                                    }
                                    this.contentCase_ = 799;
                                    break;
                                case 7274:
                                    String s = input.readStringRequireUtf8();
                                    this.contentCase_ = 909;
                                    this.content_ = s;
                                    break;
                                case 7920:
                                    this.contentCase_ = 990;
                                    this.content_ = Integer.valueOf(input.readUInt32());
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChatInfoOuterClass$ChatInfo$SystemHintType.class */
        public enum SystemHintType implements ProtocolMessageEnum {
            SYSTEM_HINT_TYPE_CHAT_NONE(0),
            SYSTEM_HINT_TYPE_CHAT_ENTER_WORLD(1),
            SYSTEM_HINT_TYPE_CHAT_LEAVE_WORLD(2),
            UNRECOGNIZED(-1);
            
            public static final int SYSTEM_HINT_TYPE_CHAT_NONE_VALUE = 0;
            public static final int SYSTEM_HINT_TYPE_CHAT_ENTER_WORLD_VALUE = 1;
            public static final int SYSTEM_HINT_TYPE_CHAT_LEAVE_WORLD_VALUE = 2;
            private static final Internal.EnumLiteMap<SystemHintType> internalValueMap = new Internal.EnumLiteMap<SystemHintType>() { // from class: emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfo.SystemHintType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public SystemHintType findValueByNumber(int number) {
                    return SystemHintType.forNumber(number);
                }
            };
            private static final SystemHintType[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static SystemHintType valueOf(int value) {
                return forNumber(value);
            }

            public static SystemHintType forNumber(int value) {
                switch (value) {
                    case 0:
                        return SYSTEM_HINT_TYPE_CHAT_NONE;
                    case 1:
                        return SYSTEM_HINT_TYPE_CHAT_ENTER_WORLD;
                    case 2:
                        return SYSTEM_HINT_TYPE_CHAT_LEAVE_WORLD;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<SystemHintType> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                if (this != UNRECOGNIZED) {
                    return getDescriptor().getValues().get(ordinal());
                }
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return ChatInfo.getDescriptor().getEnumTypes().get(0);
            }

            public static SystemHintType valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            SystemHintType(int value) {
                this.value = value;
            }
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChatInfoOuterClass$ChatInfo$SystemHint.class */
        public static final class SystemHint extends GeneratedMessageV3 implements SystemHintOrBuilder {
            private static final long serialVersionUID = 0;
            public static final int TYPE_FIELD_NUMBER = 15;
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
                                case 120:
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
                    output.writeUInt32(15, this.type_);
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
                    size2 = 0 + CodedOutputStream.computeUInt32Size(15, this.type_);
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
                int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getType())) + this.unknownFields.hashCode();
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
            TEXT(909),
            ICON(990),
            SYSTEM_HINT(799),
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
                    case 799:
                        return SYSTEM_HINT;
                    case 909:
                        return TEXT;
                    case 990:
                        return ICON;
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
        public int getTime() {
            return this.time_;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public int getToUid() {
            return this.toUid_;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public int getSequence() {
            return this.sequence_;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public boolean hasText() {
            return this.contentCase_ == 909;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public String getText() {
            Object ref = "";
            if (this.contentCase_ == 909) {
                ref = this.content_;
            }
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            if (this.contentCase_ == 909) {
                this.content_ = s;
            }
            return s;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public ByteString getTextBytes() {
            Object ref = "";
            if (this.contentCase_ == 909) {
                ref = this.content_;
            }
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            if (this.contentCase_ == 909) {
                this.content_ = b;
            }
            return b;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public boolean hasIcon() {
            return this.contentCase_ == 990;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public int getIcon() {
            if (this.contentCase_ == 990) {
                return ((Integer) this.content_).intValue();
            }
            return 0;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public boolean hasSystemHint() {
            return this.contentCase_ == 799;
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public SystemHint getSystemHint() {
            if (this.contentCase_ == 799) {
                return (SystemHint) this.content_;
            }
            return SystemHint.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
        public SystemHintOrBuilder getSystemHintOrBuilder() {
            if (this.contentCase_ == 799) {
                return (SystemHint) this.content_;
            }
            return SystemHint.getDefaultInstance();
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
            if (this.time_ != 0) {
                output.writeUInt32(1, this.time_);
            }
            if (this.isRead_) {
                output.writeBool(3, this.isRead_);
            }
            if (this.sequence_ != 0) {
                output.writeUInt32(5, this.sequence_);
            }
            if (this.toUid_ != 0) {
                output.writeUInt32(10, this.toUid_);
            }
            if (this.uid_ != 0) {
                output.writeUInt32(11, this.uid_);
            }
            if (this.contentCase_ == 799) {
                output.writeMessage(799, (SystemHint) this.content_);
            }
            if (this.contentCase_ == 909) {
                GeneratedMessageV3.writeString(output, 909, this.content_);
            }
            if (this.contentCase_ == 990) {
                output.writeUInt32(990, ((Integer) this.content_).intValue());
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
            if (this.time_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.time_);
            }
            if (this.isRead_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.isRead_);
            }
            if (this.sequence_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.sequence_);
            }
            if (this.toUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.toUid_);
            }
            if (this.uid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.uid_);
            }
            if (this.contentCase_ == 799) {
                size2 += CodedOutputStream.computeMessageSize(799, (SystemHint) this.content_);
            }
            if (this.contentCase_ == 909) {
                size2 += GeneratedMessageV3.computeStringSize(909, this.content_);
            }
            if (this.contentCase_ == 990) {
                size2 += CodedOutputStream.computeUInt32Size(990, ((Integer) this.content_).intValue());
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
            if (getIsRead() != other.getIsRead() || getTime() != other.getTime() || getToUid() != other.getToUid() || getUid() != other.getUid() || getSequence() != other.getSequence() || !getContentCase().equals(other.getContentCase())) {
                return false;
            }
            switch (this.contentCase_) {
                case 799:
                    if (!getSystemHint().equals(other.getSystemHint())) {
                        return false;
                    }
                    break;
                case 909:
                    if (!getText().equals(other.getText())) {
                        return false;
                    }
                    break;
                case 990:
                    if (getIcon() != other.getIcon()) {
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
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + Internal.hashBoolean(getIsRead()))) + 1)) + getTime())) + 10)) + getToUid())) + 11)) + getUid())) + 5)) + getSequence();
            switch (this.contentCase_) {
                case 799:
                    hash = (53 * ((37 * hash) + 799)) + getSystemHint().hashCode();
                    break;
                case 909:
                    hash = (53 * ((37 * hash) + 909)) + getText().hashCode();
                    break;
                case 990:
                    hash = (53 * ((37 * hash) + 990)) + getIcon();
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
            private int time_;
            private int toUid_;
            private int uid_;
            private int sequence_;
            private SingleFieldBuilderV3<SystemHint, SystemHint.Builder, SystemHintOrBuilder> systemHintBuilder_;

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
                this.time_ = 0;
                this.toUid_ = 0;
                this.uid_ = 0;
                this.sequence_ = 0;
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
                result.time_ = this.time_;
                result.toUid_ = this.toUid_;
                result.uid_ = this.uid_;
                result.sequence_ = this.sequence_;
                if (this.contentCase_ == 909) {
                    result.content_ = this.content_;
                }
                if (this.contentCase_ == 990) {
                    result.content_ = this.content_;
                }
                if (this.contentCase_ == 799) {
                    if (this.systemHintBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.systemHintBuilder_.build();
                    }
                }
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
                if (other.getTime() != 0) {
                    setTime(other.getTime());
                }
                if (other.getToUid() != 0) {
                    setToUid(other.getToUid());
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (other.getSequence() != 0) {
                    setSequence(other.getSequence());
                }
                switch (other.getContentCase()) {
                    case TEXT:
                        this.contentCase_ = 909;
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
            public boolean hasText() {
                return this.contentCase_ == 909;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public String getText() {
                Object ref = "";
                if (this.contentCase_ == 909) {
                    ref = this.content_;
                }
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                if (this.contentCase_ == 909) {
                    this.content_ = s;
                }
                return s;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public ByteString getTextBytes() {
                Object ref = "";
                if (this.contentCase_ == 909) {
                    ref = this.content_;
                }
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                if (this.contentCase_ == 909) {
                    this.content_ = b;
                }
                return b;
            }

            public Builder setText(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.contentCase_ = 909;
                this.content_ = value;
                onChanged();
                return this;
            }

            public Builder clearText() {
                if (this.contentCase_ == 909) {
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
                this.contentCase_ = 909;
                this.content_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public boolean hasIcon() {
                return this.contentCase_ == 990;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public int getIcon() {
                if (this.contentCase_ == 990) {
                    return ((Integer) this.content_).intValue();
                }
                return 0;
            }

            public Builder setIcon(int value) {
                this.contentCase_ = 990;
                this.content_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearIcon() {
                if (this.contentCase_ == 990) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public boolean hasSystemHint() {
                return this.contentCase_ == 799;
            }

            @Override // emu.grasscutter.net.proto.ChatInfoOuterClass.ChatInfoOrBuilder
            public SystemHint getSystemHint() {
                if (this.systemHintBuilder_ == null) {
                    if (this.contentCase_ == 799) {
                        return (SystemHint) this.content_;
                    }
                    return SystemHint.getDefaultInstance();
                } else if (this.contentCase_ == 799) {
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
                this.contentCase_ = 799;
                return this;
            }

            public Builder setSystemHint(SystemHint.Builder builderForValue) {
                if (this.systemHintBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.systemHintBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 799;
                return this;
            }

            public Builder mergeSystemHint(SystemHint value) {
                if (this.systemHintBuilder_ == null) {
                    if (this.contentCase_ != 799 || this.content_ == SystemHint.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = SystemHint.newBuilder((SystemHint) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 799) {
                        this.systemHintBuilder_.mergeFrom(value);
                    }
                    this.systemHintBuilder_.setMessage(value);
                }
                this.contentCase_ = 799;
                return this;
            }

            public Builder clearSystemHint() {
                if (this.systemHintBuilder_ != null) {
                    if (this.contentCase_ == 799) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.systemHintBuilder_.clear();
                } else if (this.contentCase_ == 799) {
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
                if (this.contentCase_ == 799 && this.systemHintBuilder_ != null) {
                    return this.systemHintBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 799) {
                    return (SystemHint) this.content_;
                }
                return SystemHint.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SystemHint, SystemHint.Builder, SystemHintOrBuilder> getSystemHintFieldBuilder() {
                if (this.systemHintBuilder_ == null) {
                    if (this.contentCase_ != 799) {
                        this.content_ = SystemHint.getDefaultInstance();
                    }
                    this.systemHintBuilder_ = new SingleFieldBuilderV3<>((SystemHint) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 799;
                onChanged();
                return this.systemHintBuilder_;
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
