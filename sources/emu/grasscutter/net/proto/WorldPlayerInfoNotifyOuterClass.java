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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass;
import emu.grasscutter.net.proto.PlayerWidgetInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerInfoNotifyOuterClass.class */
public final class WorldPlayerInfoNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bWorldPlayerInfoNotify.proto\u001a\u0016OnlinePlayerInfo.proto\u001a\u0016PlayerWidgetInfo.proto\"\u0001\n\u0015WorldPlayerInfoNotify\u00122\n\u0017player_widget_info_list\u0018\u0007 \u0003(\u000b2\u0011.PlayerWidgetInfo\u0012\u0017\n\u000fplayer_uid_list\u0018\f \u0003(\r\u0012+\n\u0010player_info_list\u0018\u000f \u0003(\u000b2\u0011.OnlinePlayerInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{OnlinePlayerInfoOuterClass.getDescriptor(), PlayerWidgetInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WorldPlayerInfoNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WorldPlayerInfoNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WorldPlayerInfoNotify_descriptor, new String[]{"PlayerWidgetInfoList", "PlayerUidList", "PlayerInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerInfoNotifyOuterClass$WorldPlayerInfoNotifyOrBuilder.class */
    public interface WorldPlayerInfoNotifyOrBuilder extends MessageOrBuilder {
        List<PlayerWidgetInfoOuterClass.PlayerWidgetInfo> getPlayerWidgetInfoListList();

        PlayerWidgetInfoOuterClass.PlayerWidgetInfo getPlayerWidgetInfoList(int i);

        int getPlayerWidgetInfoListCount();

        List<? extends PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder> getPlayerWidgetInfoListOrBuilderList();

        PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder getPlayerWidgetInfoListOrBuilder(int i);

        List<Integer> getPlayerUidListList();

        int getPlayerUidListCount();

        int getPlayerUidList(int i);

        List<OnlinePlayerInfoOuterClass.OnlinePlayerInfo> getPlayerInfoListList();

        OnlinePlayerInfoOuterClass.OnlinePlayerInfo getPlayerInfoList(int i);

        int getPlayerInfoListCount();

        List<? extends OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> getPlayerInfoListOrBuilderList();

        OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getPlayerInfoListOrBuilder(int i);
    }

    private WorldPlayerInfoNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerInfoNotifyOuterClass$WorldPlayerInfoNotify.class */
    public static final class WorldPlayerInfoNotify extends GeneratedMessageV3 implements WorldPlayerInfoNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PLAYER_WIDGET_INFO_LIST_FIELD_NUMBER = 7;
        private List<PlayerWidgetInfoOuterClass.PlayerWidgetInfo> playerWidgetInfoList_;
        public static final int PLAYER_UID_LIST_FIELD_NUMBER = 12;
        private Internal.IntList playerUidList_;
        private int playerUidListMemoizedSerializedSize;
        public static final int PLAYER_INFO_LIST_FIELD_NUMBER = 15;
        private List<OnlinePlayerInfoOuterClass.OnlinePlayerInfo> playerInfoList_;
        private byte memoizedIsInitialized;
        private static final WorldPlayerInfoNotify DEFAULT_INSTANCE = new WorldPlayerInfoNotify();
        private static final Parser<WorldPlayerInfoNotify> PARSER = new AbstractParser<WorldPlayerInfoNotify>() { // from class: emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotify.1
            @Override // com.google.protobuf.Parser
            public WorldPlayerInfoNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WorldPlayerInfoNotify(input, extensionRegistry);
            }
        };

        private WorldPlayerInfoNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.playerUidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private WorldPlayerInfoNotify() {
            this.playerUidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.playerWidgetInfoList_ = Collections.emptyList();
            this.playerUidList_ = emptyIntList();
            this.playerInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WorldPlayerInfoNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x012f */
        private WorldPlayerInfoNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 58:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.playerWidgetInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.playerWidgetInfoList_.add((PlayerWidgetInfoOuterClass.PlayerWidgetInfo) input.readMessage(PlayerWidgetInfoOuterClass.PlayerWidgetInfo.parser(), extensionRegistry));
                                break;
                            case 96:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.playerUidList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.playerUidList_.addInt(input.readUInt32());
                                break;
                            case 98:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.playerUidList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.playerUidList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 122:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.playerInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.playerInfoList_.add((OnlinePlayerInfoOuterClass.OnlinePlayerInfo) input.readMessage(OnlinePlayerInfoOuterClass.OnlinePlayerInfo.parser(), extensionRegistry));
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.playerWidgetInfoList_ = Collections.unmodifiableList(this.playerWidgetInfoList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.playerUidList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.playerInfoList_ = Collections.unmodifiableList(this.playerInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WorldPlayerInfoNotifyOuterClass.internal_static_WorldPlayerInfoNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WorldPlayerInfoNotifyOuterClass.internal_static_WorldPlayerInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WorldPlayerInfoNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
        public List<PlayerWidgetInfoOuterClass.PlayerWidgetInfo> getPlayerWidgetInfoListList() {
            return this.playerWidgetInfoList_;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
        public List<? extends PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder> getPlayerWidgetInfoListOrBuilderList() {
            return this.playerWidgetInfoList_;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
        public int getPlayerWidgetInfoListCount() {
            return this.playerWidgetInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
        public PlayerWidgetInfoOuterClass.PlayerWidgetInfo getPlayerWidgetInfoList(int index) {
            return this.playerWidgetInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
        public PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder getPlayerWidgetInfoListOrBuilder(int index) {
            return this.playerWidgetInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
        public List<Integer> getPlayerUidListList() {
            return this.playerUidList_;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
        public int getPlayerUidListCount() {
            return this.playerUidList_.size();
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
        public int getPlayerUidList(int index) {
            return this.playerUidList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
        public List<OnlinePlayerInfoOuterClass.OnlinePlayerInfo> getPlayerInfoListList() {
            return this.playerInfoList_;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
        public List<? extends OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> getPlayerInfoListOrBuilderList() {
            return this.playerInfoList_;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
        public int getPlayerInfoListCount() {
            return this.playerInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
        public OnlinePlayerInfoOuterClass.OnlinePlayerInfo getPlayerInfoList(int index) {
            return this.playerInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
        public OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getPlayerInfoListOrBuilder(int index) {
            return this.playerInfoList_.get(index);
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
            for (int i = 0; i < this.playerWidgetInfoList_.size(); i++) {
                output.writeMessage(7, this.playerWidgetInfoList_.get(i));
            }
            if (getPlayerUidListList().size() > 0) {
                output.writeUInt32NoTag(98);
                output.writeUInt32NoTag(this.playerUidListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.playerUidList_.size(); i2++) {
                output.writeUInt32NoTag(this.playerUidList_.getInt(i2));
            }
            for (int i3 = 0; i3 < this.playerInfoList_.size(); i3++) {
                output.writeMessage(15, this.playerInfoList_.get(i3));
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
            for (int i = 0; i < this.playerWidgetInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.playerWidgetInfoList_.get(i));
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.playerUidList_.size(); i2++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.playerUidList_.getInt(i2));
            }
            int size3 = size2 + dataSize;
            if (!getPlayerUidListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.playerUidListMemoizedSerializedSize = dataSize;
            for (int i3 = 0; i3 < this.playerInfoList_.size(); i3++) {
                size3 += CodedOutputStream.computeMessageSize(15, this.playerInfoList_.get(i3));
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WorldPlayerInfoNotify)) {
                return equals(obj);
            }
            WorldPlayerInfoNotify other = (WorldPlayerInfoNotify) obj;
            return getPlayerWidgetInfoListList().equals(other.getPlayerWidgetInfoListList()) && getPlayerUidListList().equals(other.getPlayerUidListList()) && getPlayerInfoListList().equals(other.getPlayerInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getPlayerWidgetInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getPlayerWidgetInfoListList().hashCode();
            }
            if (getPlayerUidListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getPlayerUidListList().hashCode();
            }
            if (getPlayerInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getPlayerInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WorldPlayerInfoNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorldPlayerInfoNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldPlayerInfoNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorldPlayerInfoNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldPlayerInfoNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorldPlayerInfoNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldPlayerInfoNotify parseFrom(InputStream input) throws IOException {
            return (WorldPlayerInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WorldPlayerInfoNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldPlayerInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WorldPlayerInfoNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (WorldPlayerInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WorldPlayerInfoNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldPlayerInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WorldPlayerInfoNotify parseFrom(CodedInputStream input) throws IOException {
            return (WorldPlayerInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WorldPlayerInfoNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldPlayerInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WorldPlayerInfoNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerInfoNotifyOuterClass$WorldPlayerInfoNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WorldPlayerInfoNotifyOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<PlayerWidgetInfoOuterClass.PlayerWidgetInfo, PlayerWidgetInfoOuterClass.PlayerWidgetInfo.Builder, PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder> playerWidgetInfoListBuilder_;
            private RepeatedFieldBuilderV3<OnlinePlayerInfoOuterClass.OnlinePlayerInfo, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder, OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> playerInfoListBuilder_;
            private List<PlayerWidgetInfoOuterClass.PlayerWidgetInfo> playerWidgetInfoList_ = Collections.emptyList();
            private Internal.IntList playerUidList_ = WorldPlayerInfoNotify.emptyIntList();
            private List<OnlinePlayerInfoOuterClass.OnlinePlayerInfo> playerInfoList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return WorldPlayerInfoNotifyOuterClass.internal_static_WorldPlayerInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WorldPlayerInfoNotifyOuterClass.internal_static_WorldPlayerInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WorldPlayerInfoNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WorldPlayerInfoNotify.alwaysUseFieldBuilders) {
                    getPlayerWidgetInfoListFieldBuilder();
                    getPlayerInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.playerWidgetInfoListBuilder_ == null) {
                    this.playerWidgetInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.playerWidgetInfoListBuilder_.clear();
                }
                this.playerUidList_ = WorldPlayerInfoNotify.emptyIntList();
                this.bitField0_ &= -3;
                if (this.playerInfoListBuilder_ == null) {
                    this.playerInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.playerInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WorldPlayerInfoNotifyOuterClass.internal_static_WorldPlayerInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WorldPlayerInfoNotify getDefaultInstanceForType() {
                return WorldPlayerInfoNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WorldPlayerInfoNotify build() {
                WorldPlayerInfoNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WorldPlayerInfoNotify buildPartial() {
                WorldPlayerInfoNotify result = new WorldPlayerInfoNotify(this);
                int i = this.bitField0_;
                if (this.playerWidgetInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.playerWidgetInfoList_ = Collections.unmodifiableList(this.playerWidgetInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.playerWidgetInfoList_ = this.playerWidgetInfoList_;
                } else {
                    result.playerWidgetInfoList_ = this.playerWidgetInfoListBuilder_.build();
                }
                if ((this.bitField0_ & 2) != 0) {
                    this.playerUidList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.playerUidList_ = this.playerUidList_;
                if (this.playerInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.playerInfoList_ = Collections.unmodifiableList(this.playerInfoList_);
                        this.bitField0_ &= -5;
                    }
                    result.playerInfoList_ = this.playerInfoList_;
                } else {
                    result.playerInfoList_ = this.playerInfoListBuilder_.build();
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
                if (other instanceof WorldPlayerInfoNotify) {
                    return mergeFrom((WorldPlayerInfoNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WorldPlayerInfoNotify other) {
                if (other == WorldPlayerInfoNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.playerWidgetInfoListBuilder_ == null) {
                    if (!other.playerWidgetInfoList_.isEmpty()) {
                        if (this.playerWidgetInfoList_.isEmpty()) {
                            this.playerWidgetInfoList_ = other.playerWidgetInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePlayerWidgetInfoListIsMutable();
                            this.playerWidgetInfoList_.addAll(other.playerWidgetInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.playerWidgetInfoList_.isEmpty()) {
                    if (this.playerWidgetInfoListBuilder_.isEmpty()) {
                        this.playerWidgetInfoListBuilder_.dispose();
                        this.playerWidgetInfoListBuilder_ = null;
                        this.playerWidgetInfoList_ = other.playerWidgetInfoList_;
                        this.bitField0_ &= -2;
                        this.playerWidgetInfoListBuilder_ = WorldPlayerInfoNotify.alwaysUseFieldBuilders ? getPlayerWidgetInfoListFieldBuilder() : null;
                    } else {
                        this.playerWidgetInfoListBuilder_.addAllMessages(other.playerWidgetInfoList_);
                    }
                }
                if (!other.playerUidList_.isEmpty()) {
                    if (this.playerUidList_.isEmpty()) {
                        this.playerUidList_ = other.playerUidList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensurePlayerUidListIsMutable();
                        this.playerUidList_.addAll(other.playerUidList_);
                    }
                    onChanged();
                }
                if (this.playerInfoListBuilder_ == null) {
                    if (!other.playerInfoList_.isEmpty()) {
                        if (this.playerInfoList_.isEmpty()) {
                            this.playerInfoList_ = other.playerInfoList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensurePlayerInfoListIsMutable();
                            this.playerInfoList_.addAll(other.playerInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.playerInfoList_.isEmpty()) {
                    if (this.playerInfoListBuilder_.isEmpty()) {
                        this.playerInfoListBuilder_.dispose();
                        this.playerInfoListBuilder_ = null;
                        this.playerInfoList_ = other.playerInfoList_;
                        this.bitField0_ &= -5;
                        this.playerInfoListBuilder_ = WorldPlayerInfoNotify.alwaysUseFieldBuilders ? getPlayerInfoListFieldBuilder() : null;
                    } else {
                        this.playerInfoListBuilder_.addAllMessages(other.playerInfoList_);
                    }
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
                WorldPlayerInfoNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = WorldPlayerInfoNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WorldPlayerInfoNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensurePlayerWidgetInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.playerWidgetInfoList_ = new ArrayList(this.playerWidgetInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
            public List<PlayerWidgetInfoOuterClass.PlayerWidgetInfo> getPlayerWidgetInfoListList() {
                if (this.playerWidgetInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.playerWidgetInfoList_);
                }
                return this.playerWidgetInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
            public int getPlayerWidgetInfoListCount() {
                if (this.playerWidgetInfoListBuilder_ == null) {
                    return this.playerWidgetInfoList_.size();
                }
                return this.playerWidgetInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
            public PlayerWidgetInfoOuterClass.PlayerWidgetInfo getPlayerWidgetInfoList(int index) {
                if (this.playerWidgetInfoListBuilder_ == null) {
                    return this.playerWidgetInfoList_.get(index);
                }
                return this.playerWidgetInfoListBuilder_.getMessage(index);
            }

            public Builder setPlayerWidgetInfoList(int index, PlayerWidgetInfoOuterClass.PlayerWidgetInfo value) {
                if (this.playerWidgetInfoListBuilder_ != null) {
                    this.playerWidgetInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerWidgetInfoListIsMutable();
                    this.playerWidgetInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPlayerWidgetInfoList(int index, PlayerWidgetInfoOuterClass.PlayerWidgetInfo.Builder builderForValue) {
                if (this.playerWidgetInfoListBuilder_ == null) {
                    ensurePlayerWidgetInfoListIsMutable();
                    this.playerWidgetInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerWidgetInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerWidgetInfoList(PlayerWidgetInfoOuterClass.PlayerWidgetInfo value) {
                if (this.playerWidgetInfoListBuilder_ != null) {
                    this.playerWidgetInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerWidgetInfoListIsMutable();
                    this.playerWidgetInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlayerWidgetInfoList(int index, PlayerWidgetInfoOuterClass.PlayerWidgetInfo value) {
                if (this.playerWidgetInfoListBuilder_ != null) {
                    this.playerWidgetInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerWidgetInfoListIsMutable();
                    this.playerWidgetInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlayerWidgetInfoList(PlayerWidgetInfoOuterClass.PlayerWidgetInfo.Builder builderForValue) {
                if (this.playerWidgetInfoListBuilder_ == null) {
                    ensurePlayerWidgetInfoListIsMutable();
                    this.playerWidgetInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.playerWidgetInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerWidgetInfoList(int index, PlayerWidgetInfoOuterClass.PlayerWidgetInfo.Builder builderForValue) {
                if (this.playerWidgetInfoListBuilder_ == null) {
                    ensurePlayerWidgetInfoListIsMutable();
                    this.playerWidgetInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerWidgetInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPlayerWidgetInfoList(Iterable<? extends PlayerWidgetInfoOuterClass.PlayerWidgetInfo> values) {
                if (this.playerWidgetInfoListBuilder_ == null) {
                    ensurePlayerWidgetInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.playerWidgetInfoList_);
                    onChanged();
                } else {
                    this.playerWidgetInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPlayerWidgetInfoList() {
                if (this.playerWidgetInfoListBuilder_ == null) {
                    this.playerWidgetInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.playerWidgetInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removePlayerWidgetInfoList(int index) {
                if (this.playerWidgetInfoListBuilder_ == null) {
                    ensurePlayerWidgetInfoListIsMutable();
                    this.playerWidgetInfoList_.remove(index);
                    onChanged();
                } else {
                    this.playerWidgetInfoListBuilder_.remove(index);
                }
                return this;
            }

            public PlayerWidgetInfoOuterClass.PlayerWidgetInfo.Builder getPlayerWidgetInfoListBuilder(int index) {
                return getPlayerWidgetInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
            public PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder getPlayerWidgetInfoListOrBuilder(int index) {
                if (this.playerWidgetInfoListBuilder_ == null) {
                    return this.playerWidgetInfoList_.get(index);
                }
                return this.playerWidgetInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
            public List<? extends PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder> getPlayerWidgetInfoListOrBuilderList() {
                if (this.playerWidgetInfoListBuilder_ != null) {
                    return this.playerWidgetInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.playerWidgetInfoList_);
            }

            public PlayerWidgetInfoOuterClass.PlayerWidgetInfo.Builder addPlayerWidgetInfoListBuilder() {
                return getPlayerWidgetInfoListFieldBuilder().addBuilder(PlayerWidgetInfoOuterClass.PlayerWidgetInfo.getDefaultInstance());
            }

            public PlayerWidgetInfoOuterClass.PlayerWidgetInfo.Builder addPlayerWidgetInfoListBuilder(int index) {
                return getPlayerWidgetInfoListFieldBuilder().addBuilder(index, PlayerWidgetInfoOuterClass.PlayerWidgetInfo.getDefaultInstance());
            }

            public List<PlayerWidgetInfoOuterClass.PlayerWidgetInfo.Builder> getPlayerWidgetInfoListBuilderList() {
                return getPlayerWidgetInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PlayerWidgetInfoOuterClass.PlayerWidgetInfo, PlayerWidgetInfoOuterClass.PlayerWidgetInfo.Builder, PlayerWidgetInfoOuterClass.PlayerWidgetInfoOrBuilder> getPlayerWidgetInfoListFieldBuilder() {
                if (this.playerWidgetInfoListBuilder_ == null) {
                    this.playerWidgetInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.playerWidgetInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.playerWidgetInfoList_ = null;
                }
                return this.playerWidgetInfoListBuilder_;
            }

            private void ensurePlayerUidListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.playerUidList_ = WorldPlayerInfoNotify.mutableCopy(this.playerUidList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
            public List<Integer> getPlayerUidListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.playerUidList_) : this.playerUidList_;
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
            public int getPlayerUidListCount() {
                return this.playerUidList_.size();
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
            public int getPlayerUidList(int index) {
                return this.playerUidList_.getInt(index);
            }

            public Builder setPlayerUidList(int index, int value) {
                ensurePlayerUidListIsMutable();
                this.playerUidList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addPlayerUidList(int value) {
                ensurePlayerUidListIsMutable();
                this.playerUidList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllPlayerUidList(Iterable<? extends Integer> values) {
                ensurePlayerUidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.playerUidList_);
                onChanged();
                return this;
            }

            public Builder clearPlayerUidList() {
                this.playerUidList_ = WorldPlayerInfoNotify.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensurePlayerInfoListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.playerInfoList_ = new ArrayList(this.playerInfoList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
            public List<OnlinePlayerInfoOuterClass.OnlinePlayerInfo> getPlayerInfoListList() {
                if (this.playerInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.playerInfoList_);
                }
                return this.playerInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
            public int getPlayerInfoListCount() {
                if (this.playerInfoListBuilder_ == null) {
                    return this.playerInfoList_.size();
                }
                return this.playerInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
            public OnlinePlayerInfoOuterClass.OnlinePlayerInfo getPlayerInfoList(int index) {
                if (this.playerInfoListBuilder_ == null) {
                    return this.playerInfoList_.get(index);
                }
                return this.playerInfoListBuilder_.getMessage(index);
            }

            public Builder setPlayerInfoList(int index, OnlinePlayerInfoOuterClass.OnlinePlayerInfo value) {
                if (this.playerInfoListBuilder_ != null) {
                    this.playerInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPlayerInfoList(int index, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder builderForValue) {
                if (this.playerInfoListBuilder_ == null) {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerInfoList(OnlinePlayerInfoOuterClass.OnlinePlayerInfo value) {
                if (this.playerInfoListBuilder_ != null) {
                    this.playerInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlayerInfoList(int index, OnlinePlayerInfoOuterClass.OnlinePlayerInfo value) {
                if (this.playerInfoListBuilder_ != null) {
                    this.playerInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlayerInfoList(OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder builderForValue) {
                if (this.playerInfoListBuilder_ == null) {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerInfoList(int index, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder builderForValue) {
                if (this.playerInfoListBuilder_ == null) {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPlayerInfoList(Iterable<? extends OnlinePlayerInfoOuterClass.OnlinePlayerInfo> values) {
                if (this.playerInfoListBuilder_ == null) {
                    ensurePlayerInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.playerInfoList_);
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPlayerInfoList() {
                if (this.playerInfoListBuilder_ == null) {
                    this.playerInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removePlayerInfoList(int index) {
                if (this.playerInfoListBuilder_ == null) {
                    ensurePlayerInfoListIsMutable();
                    this.playerInfoList_.remove(index);
                    onChanged();
                } else {
                    this.playerInfoListBuilder_.remove(index);
                }
                return this;
            }

            public OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder getPlayerInfoListBuilder(int index) {
                return getPlayerInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
            public OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getPlayerInfoListOrBuilder(int index) {
                if (this.playerInfoListBuilder_ == null) {
                    return this.playerInfoList_.get(index);
                }
                return this.playerInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerInfoNotifyOuterClass.WorldPlayerInfoNotifyOrBuilder
            public List<? extends OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> getPlayerInfoListOrBuilderList() {
                if (this.playerInfoListBuilder_ != null) {
                    return this.playerInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.playerInfoList_);
            }

            public OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder addPlayerInfoListBuilder() {
                return getPlayerInfoListFieldBuilder().addBuilder(OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance());
            }

            public OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder addPlayerInfoListBuilder(int index) {
                return getPlayerInfoListFieldBuilder().addBuilder(index, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance());
            }

            public List<OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder> getPlayerInfoListBuilderList() {
                return getPlayerInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<OnlinePlayerInfoOuterClass.OnlinePlayerInfo, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder, OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> getPlayerInfoListFieldBuilder() {
                if (this.playerInfoListBuilder_ == null) {
                    this.playerInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.playerInfoList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.playerInfoList_ = null;
                }
                return this.playerInfoListBuilder_;
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

        public static WorldPlayerInfoNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WorldPlayerInfoNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WorldPlayerInfoNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WorldPlayerInfoNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        OnlinePlayerInfoOuterClass.getDescriptor();
        PlayerWidgetInfoOuterClass.getDescriptor();
    }
}
