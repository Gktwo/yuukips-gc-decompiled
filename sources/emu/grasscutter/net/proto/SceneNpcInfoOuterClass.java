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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneNpcInfoOuterClass.class */
public final class SceneNpcInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012SceneNpcInfo.proto\"U\n\fSceneNpcInfo\u0012\r\n\u0005npcId\u0018\u0001 \u0001(\r\u0012\u000e\n\u0006roomId\u0018\u0002 \u0001(\r\u0012\u0015\n\rparentQuestId\u0018\u0003 \u0001(\r\u0012\u000f\n\u0007blockId\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SceneNpcInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneNpcInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneNpcInfo_descriptor, new String[]{"NpcId", "RoomId", "ParentQuestId", "BlockId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneNpcInfoOuterClass$SceneNpcInfoOrBuilder.class */
    public interface SceneNpcInfoOrBuilder extends MessageOrBuilder {
        int getNpcId();

        int getRoomId();

        int getParentQuestId();

        int getBlockId();
    }

    private SceneNpcInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneNpcInfoOuterClass$SceneNpcInfo.class */
    public static final class SceneNpcInfo extends GeneratedMessageV3 implements SceneNpcInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int NPCID_FIELD_NUMBER = 1;
        private int npcId_;
        public static final int ROOMID_FIELD_NUMBER = 2;
        private int roomId_;
        public static final int PARENTQUESTID_FIELD_NUMBER = 3;
        private int parentQuestId_;
        public static final int BLOCKID_FIELD_NUMBER = 4;
        private int blockId_;
        private byte memoizedIsInitialized;
        private static final SceneNpcInfo DEFAULT_INSTANCE = new SceneNpcInfo();
        private static final Parser<SceneNpcInfo> PARSER = new AbstractParser<SceneNpcInfo>() { // from class: emu.grasscutter.net.proto.SceneNpcInfoOuterClass.SceneNpcInfo.1
            @Override // com.google.protobuf.Parser
            public SceneNpcInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneNpcInfo(input, extensionRegistry);
            }
        };

        private SceneNpcInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SceneNpcInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneNpcInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneNpcInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.npcId_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.roomId_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.parentQuestId_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.blockId_ = input.readUInt32();
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
            return SceneNpcInfoOuterClass.internal_static_SceneNpcInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneNpcInfoOuterClass.internal_static_SceneNpcInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneNpcInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneNpcInfoOuterClass.SceneNpcInfoOrBuilder
        public int getNpcId() {
            return this.npcId_;
        }

        @Override // emu.grasscutter.net.proto.SceneNpcInfoOuterClass.SceneNpcInfoOrBuilder
        public int getRoomId() {
            return this.roomId_;
        }

        @Override // emu.grasscutter.net.proto.SceneNpcInfoOuterClass.SceneNpcInfoOrBuilder
        public int getParentQuestId() {
            return this.parentQuestId_;
        }

        @Override // emu.grasscutter.net.proto.SceneNpcInfoOuterClass.SceneNpcInfoOrBuilder
        public int getBlockId() {
            return this.blockId_;
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
            if (this.npcId_ != 0) {
                output.writeUInt32(1, this.npcId_);
            }
            if (this.roomId_ != 0) {
                output.writeUInt32(2, this.roomId_);
            }
            if (this.parentQuestId_ != 0) {
                output.writeUInt32(3, this.parentQuestId_);
            }
            if (this.blockId_ != 0) {
                output.writeUInt32(4, this.blockId_);
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
            if (this.npcId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.npcId_);
            }
            if (this.roomId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.roomId_);
            }
            if (this.parentQuestId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.parentQuestId_);
            }
            if (this.blockId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.blockId_);
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
            if (!(obj instanceof SceneNpcInfo)) {
                return equals(obj);
            }
            SceneNpcInfo other = (SceneNpcInfo) obj;
            return getNpcId() == other.getNpcId() && getRoomId() == other.getRoomId() && getParentQuestId() == other.getParentQuestId() && getBlockId() == other.getBlockId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getNpcId())) + 2)) + getRoomId())) + 3)) + getParentQuestId())) + 4)) + getBlockId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SceneNpcInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneNpcInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneNpcInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneNpcInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneNpcInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneNpcInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneNpcInfo parseFrom(InputStream input) throws IOException {
            return (SceneNpcInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneNpcInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneNpcInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneNpcInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneNpcInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneNpcInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneNpcInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneNpcInfo parseFrom(CodedInputStream input) throws IOException {
            return (SceneNpcInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneNpcInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneNpcInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneNpcInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneNpcInfoOuterClass$SceneNpcInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneNpcInfoOrBuilder {
            private int npcId_;
            private int roomId_;
            private int parentQuestId_;
            private int blockId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneNpcInfoOuterClass.internal_static_SceneNpcInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneNpcInfoOuterClass.internal_static_SceneNpcInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneNpcInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneNpcInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.npcId_ = 0;
                this.roomId_ = 0;
                this.parentQuestId_ = 0;
                this.blockId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneNpcInfoOuterClass.internal_static_SceneNpcInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneNpcInfo getDefaultInstanceForType() {
                return SceneNpcInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneNpcInfo build() {
                SceneNpcInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneNpcInfo buildPartial() {
                SceneNpcInfo result = new SceneNpcInfo(this);
                result.npcId_ = this.npcId_;
                result.roomId_ = this.roomId_;
                result.parentQuestId_ = this.parentQuestId_;
                result.blockId_ = this.blockId_;
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
                if (other instanceof SceneNpcInfo) {
                    return mergeFrom((SceneNpcInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneNpcInfo other) {
                if (other == SceneNpcInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getNpcId() != 0) {
                    setNpcId(other.getNpcId());
                }
                if (other.getRoomId() != 0) {
                    setRoomId(other.getRoomId());
                }
                if (other.getParentQuestId() != 0) {
                    setParentQuestId(other.getParentQuestId());
                }
                if (other.getBlockId() != 0) {
                    setBlockId(other.getBlockId());
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
                SceneNpcInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneNpcInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneNpcInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneNpcInfoOuterClass.SceneNpcInfoOrBuilder
            public int getNpcId() {
                return this.npcId_;
            }

            public Builder setNpcId(int value) {
                this.npcId_ = value;
                onChanged();
                return this;
            }

            public Builder clearNpcId() {
                this.npcId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneNpcInfoOuterClass.SceneNpcInfoOrBuilder
            public int getRoomId() {
                return this.roomId_;
            }

            public Builder setRoomId(int value) {
                this.roomId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRoomId() {
                this.roomId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneNpcInfoOuterClass.SceneNpcInfoOrBuilder
            public int getParentQuestId() {
                return this.parentQuestId_;
            }

            public Builder setParentQuestId(int value) {
                this.parentQuestId_ = value;
                onChanged();
                return this;
            }

            public Builder clearParentQuestId() {
                this.parentQuestId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneNpcInfoOuterClass.SceneNpcInfoOrBuilder
            public int getBlockId() {
                return this.blockId_;
            }

            public Builder setBlockId(int value) {
                this.blockId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBlockId() {
                this.blockId_ = 0;
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

        public static SceneNpcInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneNpcInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneNpcInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneNpcInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
