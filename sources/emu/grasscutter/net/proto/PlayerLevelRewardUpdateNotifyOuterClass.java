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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerLevelRewardUpdateNotifyOuterClass.class */
public final class PlayerLevelRewardUpdateNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#PlayerLevelRewardUpdateNotify.proto\"3\n\u001dPlayerLevelRewardUpdateNotify\u0012\u0012\n\nlevel_list\u0018\t \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PlayerLevelRewardUpdateNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerLevelRewardUpdateNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerLevelRewardUpdateNotify_descriptor, new String[]{"LevelList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerLevelRewardUpdateNotifyOuterClass$PlayerLevelRewardUpdateNotifyOrBuilder.class */
    public interface PlayerLevelRewardUpdateNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getLevelListList();

        int getLevelListCount();

        int getLevelList(int i);
    }

    private PlayerLevelRewardUpdateNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerLevelRewardUpdateNotifyOuterClass$PlayerLevelRewardUpdateNotify.class */
    public static final class PlayerLevelRewardUpdateNotify extends GeneratedMessageV3 implements PlayerLevelRewardUpdateNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEVEL_LIST_FIELD_NUMBER = 9;
        private Internal.IntList levelList_;
        private int levelListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final PlayerLevelRewardUpdateNotify DEFAULT_INSTANCE = new PlayerLevelRewardUpdateNotify();
        private static final Parser<PlayerLevelRewardUpdateNotify> PARSER = new AbstractParser<PlayerLevelRewardUpdateNotify>() { // from class: emu.grasscutter.net.proto.PlayerLevelRewardUpdateNotifyOuterClass.PlayerLevelRewardUpdateNotify.1
            @Override // com.google.protobuf.Parser
            public PlayerLevelRewardUpdateNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerLevelRewardUpdateNotify(input, extensionRegistry);
            }
        };

        private PlayerLevelRewardUpdateNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.levelListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private PlayerLevelRewardUpdateNotify() {
            this.levelListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.levelList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerLevelRewardUpdateNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerLevelRewardUpdateNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 72:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.levelList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.levelList_.addInt(input.readUInt32());
                                    break;
                                case 74:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.levelList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.levelList_.addInt(input.readUInt32());
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
                    this.levelList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerLevelRewardUpdateNotifyOuterClass.internal_static_PlayerLevelRewardUpdateNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerLevelRewardUpdateNotifyOuterClass.internal_static_PlayerLevelRewardUpdateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerLevelRewardUpdateNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerLevelRewardUpdateNotifyOuterClass.PlayerLevelRewardUpdateNotifyOrBuilder
        public List<Integer> getLevelListList() {
            return this.levelList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerLevelRewardUpdateNotifyOuterClass.PlayerLevelRewardUpdateNotifyOrBuilder
        public int getLevelListCount() {
            return this.levelList_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerLevelRewardUpdateNotifyOuterClass.PlayerLevelRewardUpdateNotifyOrBuilder
        public int getLevelList(int index) {
            return this.levelList_.getInt(index);
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
            if (getLevelListList().size() > 0) {
                output.writeUInt32NoTag(74);
                output.writeUInt32NoTag(this.levelListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.levelList_.size(); i++) {
                output.writeUInt32NoTag(this.levelList_.getInt(i));
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
            for (int i = 0; i < this.levelList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.levelList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getLevelListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.levelListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PlayerLevelRewardUpdateNotify)) {
                return equals(obj);
            }
            PlayerLevelRewardUpdateNotify other = (PlayerLevelRewardUpdateNotify) obj;
            return getLevelListList().equals(other.getLevelListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getLevelListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getLevelListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PlayerLevelRewardUpdateNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerLevelRewardUpdateNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerLevelRewardUpdateNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerLevelRewardUpdateNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerLevelRewardUpdateNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerLevelRewardUpdateNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerLevelRewardUpdateNotify parseFrom(InputStream input) throws IOException {
            return (PlayerLevelRewardUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerLevelRewardUpdateNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerLevelRewardUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerLevelRewardUpdateNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerLevelRewardUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerLevelRewardUpdateNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerLevelRewardUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerLevelRewardUpdateNotify parseFrom(CodedInputStream input) throws IOException {
            return (PlayerLevelRewardUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerLevelRewardUpdateNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerLevelRewardUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerLevelRewardUpdateNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerLevelRewardUpdateNotifyOuterClass$PlayerLevelRewardUpdateNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerLevelRewardUpdateNotifyOrBuilder {
            private int bitField0_;
            private Internal.IntList levelList_ = PlayerLevelRewardUpdateNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerLevelRewardUpdateNotifyOuterClass.internal_static_PlayerLevelRewardUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerLevelRewardUpdateNotifyOuterClass.internal_static_PlayerLevelRewardUpdateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerLevelRewardUpdateNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerLevelRewardUpdateNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.levelList_ = PlayerLevelRewardUpdateNotify.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerLevelRewardUpdateNotifyOuterClass.internal_static_PlayerLevelRewardUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerLevelRewardUpdateNotify getDefaultInstanceForType() {
                return PlayerLevelRewardUpdateNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerLevelRewardUpdateNotify build() {
                PlayerLevelRewardUpdateNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerLevelRewardUpdateNotify buildPartial() {
                PlayerLevelRewardUpdateNotify result = new PlayerLevelRewardUpdateNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.levelList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.levelList_ = this.levelList_;
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
                if (other instanceof PlayerLevelRewardUpdateNotify) {
                    return mergeFrom((PlayerLevelRewardUpdateNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerLevelRewardUpdateNotify other) {
                if (other == PlayerLevelRewardUpdateNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.levelList_.isEmpty()) {
                    if (this.levelList_.isEmpty()) {
                        this.levelList_ = other.levelList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureLevelListIsMutable();
                        this.levelList_.addAll(other.levelList_);
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
                PlayerLevelRewardUpdateNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerLevelRewardUpdateNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerLevelRewardUpdateNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureLevelListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.levelList_ = PlayerLevelRewardUpdateNotify.mutableCopy(this.levelList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerLevelRewardUpdateNotifyOuterClass.PlayerLevelRewardUpdateNotifyOrBuilder
            public List<Integer> getLevelListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.levelList_) : this.levelList_;
            }

            @Override // emu.grasscutter.net.proto.PlayerLevelRewardUpdateNotifyOuterClass.PlayerLevelRewardUpdateNotifyOrBuilder
            public int getLevelListCount() {
                return this.levelList_.size();
            }

            @Override // emu.grasscutter.net.proto.PlayerLevelRewardUpdateNotifyOuterClass.PlayerLevelRewardUpdateNotifyOrBuilder
            public int getLevelList(int index) {
                return this.levelList_.getInt(index);
            }

            public Builder setLevelList(int index, int value) {
                ensureLevelListIsMutable();
                this.levelList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addLevelList(int value) {
                ensureLevelListIsMutable();
                this.levelList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllLevelList(Iterable<? extends Integer> values) {
                ensureLevelListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.levelList_);
                onChanged();
                return this;
            }

            public Builder clearLevelList() {
                this.levelList_ = PlayerLevelRewardUpdateNotify.emptyIntList();
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

        public static PlayerLevelRewardUpdateNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerLevelRewardUpdateNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerLevelRewardUpdateNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerLevelRewardUpdateNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
