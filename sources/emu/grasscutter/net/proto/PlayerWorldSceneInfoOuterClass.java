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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerWorldSceneInfoOuterClass.class */
public final class PlayerWorldSceneInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aPlayerWorldSceneInfo.proto\"Q\n\u0014PlayerWorldSceneInfo\u0012\u0016\n\u000esceneTagIdList\u0018\r \u0003(\r\u0012\u0010\n\bisLocked\u0018\u0005 \u0001(\b\u0012\u000f\n\u0007sceneId\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PlayerWorldSceneInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerWorldSceneInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerWorldSceneInfo_descriptor, new String[]{"SceneTagIdList", "IsLocked", "SceneId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerWorldSceneInfoOuterClass$PlayerWorldSceneInfoOrBuilder.class */
    public interface PlayerWorldSceneInfoOrBuilder extends MessageOrBuilder {
        List<Integer> getSceneTagIdListList();

        int getSceneTagIdListCount();

        int getSceneTagIdList(int i);

        boolean getIsLocked();

        int getSceneId();
    }

    private PlayerWorldSceneInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerWorldSceneInfoOuterClass$PlayerWorldSceneInfo.class */
    public static final class PlayerWorldSceneInfo extends GeneratedMessageV3 implements PlayerWorldSceneInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SCENETAGIDLIST_FIELD_NUMBER = 13;
        private Internal.IntList sceneTagIdList_;
        private int sceneTagIdListMemoizedSerializedSize;
        public static final int ISLOCKED_FIELD_NUMBER = 5;
        private boolean isLocked_;
        public static final int SCENEID_FIELD_NUMBER = 11;
        private int sceneId_;
        private byte memoizedIsInitialized;
        private static final PlayerWorldSceneInfo DEFAULT_INSTANCE = new PlayerWorldSceneInfo();
        private static final Parser<PlayerWorldSceneInfo> PARSER = new AbstractParser<PlayerWorldSceneInfo>() { // from class: emu.grasscutter.net.proto.PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.1
            @Override // com.google.protobuf.Parser
            public PlayerWorldSceneInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerWorldSceneInfo(input, extensionRegistry);
            }
        };

        private PlayerWorldSceneInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.sceneTagIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private PlayerWorldSceneInfo() {
            this.sceneTagIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.sceneTagIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerWorldSceneInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerWorldSceneInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 40:
                                this.isLocked_ = input.readBool();
                                break;
                            case 88:
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 104:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.sceneTagIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.sceneTagIdList_.addInt(input.readUInt32());
                                break;
                            case 106:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.sceneTagIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.sceneTagIdList_.addInt(input.readUInt32());
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
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.sceneTagIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerWorldSceneInfoOuterClass.internal_static_PlayerWorldSceneInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerWorldSceneInfoOuterClass.internal_static_PlayerWorldSceneInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerWorldSceneInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder
        public List<Integer> getSceneTagIdListList() {
            return this.sceneTagIdList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder
        public int getSceneTagIdListCount() {
            return this.sceneTagIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder
        public int getSceneTagIdList(int index) {
            return this.sceneTagIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder
        public boolean getIsLocked() {
            return this.isLocked_;
        }

        @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder
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
            getSerializedSize();
            if (this.isLocked_) {
                output.writeBool(5, this.isLocked_);
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(11, this.sceneId_);
            }
            if (getSceneTagIdListList().size() > 0) {
                output.writeUInt32NoTag(106);
                output.writeUInt32NoTag(this.sceneTagIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.sceneTagIdList_.size(); i++) {
                output.writeUInt32NoTag(this.sceneTagIdList_.getInt(i));
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
            if (this.isLocked_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(5, this.isLocked_);
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.sceneId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.sceneTagIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.sceneTagIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getSceneTagIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.sceneTagIdListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PlayerWorldSceneInfo)) {
                return equals(obj);
            }
            PlayerWorldSceneInfo other = (PlayerWorldSceneInfo) obj;
            return getSceneTagIdListList().equals(other.getSceneTagIdListList()) && getIsLocked() == other.getIsLocked() && getSceneId() == other.getSceneId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getSceneTagIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getSceneTagIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 5)) + Internal.hashBoolean(getIsLocked()))) + 11)) + getSceneId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PlayerWorldSceneInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerWorldSceneInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerWorldSceneInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerWorldSceneInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerWorldSceneInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerWorldSceneInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerWorldSceneInfo parseFrom(InputStream input) throws IOException {
            return (PlayerWorldSceneInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerWorldSceneInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerWorldSceneInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerWorldSceneInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerWorldSceneInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerWorldSceneInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerWorldSceneInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerWorldSceneInfo parseFrom(CodedInputStream input) throws IOException {
            return (PlayerWorldSceneInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerWorldSceneInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerWorldSceneInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerWorldSceneInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerWorldSceneInfoOuterClass$PlayerWorldSceneInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerWorldSceneInfoOrBuilder {
            private int bitField0_;
            private Internal.IntList sceneTagIdList_ = PlayerWorldSceneInfo.emptyIntList();
            private boolean isLocked_;
            private int sceneId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerWorldSceneInfoOuterClass.internal_static_PlayerWorldSceneInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerWorldSceneInfoOuterClass.internal_static_PlayerWorldSceneInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerWorldSceneInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerWorldSceneInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.sceneTagIdList_ = PlayerWorldSceneInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.isLocked_ = false;
                this.sceneId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerWorldSceneInfoOuterClass.internal_static_PlayerWorldSceneInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerWorldSceneInfo getDefaultInstanceForType() {
                return PlayerWorldSceneInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerWorldSceneInfo build() {
                PlayerWorldSceneInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerWorldSceneInfo buildPartial() {
                PlayerWorldSceneInfo result = new PlayerWorldSceneInfo(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.sceneTagIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.sceneTagIdList_ = this.sceneTagIdList_;
                result.isLocked_ = this.isLocked_;
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
                if (other instanceof PlayerWorldSceneInfo) {
                    return mergeFrom((PlayerWorldSceneInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerWorldSceneInfo other) {
                if (other == PlayerWorldSceneInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.sceneTagIdList_.isEmpty()) {
                    if (this.sceneTagIdList_.isEmpty()) {
                        this.sceneTagIdList_ = other.sceneTagIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureSceneTagIdListIsMutable();
                        this.sceneTagIdList_.addAll(other.sceneTagIdList_);
                    }
                    onChanged();
                }
                if (other.getIsLocked()) {
                    setIsLocked(other.getIsLocked());
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
                PlayerWorldSceneInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerWorldSceneInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerWorldSceneInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureSceneTagIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.sceneTagIdList_ = PlayerWorldSceneInfo.mutableCopy(this.sceneTagIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder
            public List<Integer> getSceneTagIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.sceneTagIdList_) : this.sceneTagIdList_;
            }

            @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder
            public int getSceneTagIdListCount() {
                return this.sceneTagIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder
            public int getSceneTagIdList(int index) {
                return this.sceneTagIdList_.getInt(index);
            }

            public Builder setSceneTagIdList(int index, int value) {
                ensureSceneTagIdListIsMutable();
                this.sceneTagIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addSceneTagIdList(int value) {
                ensureSceneTagIdListIsMutable();
                this.sceneTagIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllSceneTagIdList(Iterable<? extends Integer> values) {
                ensureSceneTagIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.sceneTagIdList_);
                onChanged();
                return this;
            }

            public Builder clearSceneTagIdList() {
                this.sceneTagIdList_ = PlayerWorldSceneInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder
            public boolean getIsLocked() {
                return this.isLocked_;
            }

            public Builder setIsLocked(boolean value) {
                this.isLocked_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsLocked() {
                this.isLocked_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfoOrBuilder
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

        public static PlayerWorldSceneInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerWorldSceneInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerWorldSceneInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerWorldSceneInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
