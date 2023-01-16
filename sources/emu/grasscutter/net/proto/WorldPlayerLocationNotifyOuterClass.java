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
import emu.grasscutter.net.proto.PlayerLocationInfoOuterClass;
import emu.grasscutter.net.proto.PlayerWorldLocationInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerLocationNotifyOuterClass.class */
public final class WorldPlayerLocationNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fWorldPlayerLocationNotify.proto\u001a\u0018PlayerLocationInfo.proto\u001a\u001dPlayerWorldLocationInfo.proto\"\u0001\n\u0019WorldPlayerLocationNotify\u00127\n\u0015player_world_loc_list\u0018\u0005 \u0003(\u000b2\u0018.PlayerWorldLocationInfo\u0012,\n\u000fplayer_loc_list\u0018\u000e \u0003(\u000b2\u0013.PlayerLocationInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PlayerLocationInfoOuterClass.getDescriptor(), PlayerWorldLocationInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WorldPlayerLocationNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WorldPlayerLocationNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WorldPlayerLocationNotify_descriptor, new String[]{"PlayerWorldLocList", "PlayerLocList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerLocationNotifyOuterClass$WorldPlayerLocationNotifyOrBuilder.class */
    public interface WorldPlayerLocationNotifyOrBuilder extends MessageOrBuilder {
        List<PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo> getPlayerWorldLocListList();

        PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo getPlayerWorldLocList(int i);

        int getPlayerWorldLocListCount();

        List<? extends PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfoOrBuilder> getPlayerWorldLocListOrBuilderList();

        PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfoOrBuilder getPlayerWorldLocListOrBuilder(int i);

        List<PlayerLocationInfoOuterClass.PlayerLocationInfo> getPlayerLocListList();

        PlayerLocationInfoOuterClass.PlayerLocationInfo getPlayerLocList(int i);

        int getPlayerLocListCount();

        List<? extends PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder> getPlayerLocListOrBuilderList();

        PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder getPlayerLocListOrBuilder(int i);
    }

    private WorldPlayerLocationNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerLocationNotifyOuterClass$WorldPlayerLocationNotify.class */
    public static final class WorldPlayerLocationNotify extends GeneratedMessageV3 implements WorldPlayerLocationNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PLAYER_WORLD_LOC_LIST_FIELD_NUMBER = 5;
        private List<PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo> playerWorldLocList_;
        public static final int PLAYER_LOC_LIST_FIELD_NUMBER = 14;
        private List<PlayerLocationInfoOuterClass.PlayerLocationInfo> playerLocList_;
        private byte memoizedIsInitialized;
        private static final WorldPlayerLocationNotify DEFAULT_INSTANCE = new WorldPlayerLocationNotify();
        private static final Parser<WorldPlayerLocationNotify> PARSER = new AbstractParser<WorldPlayerLocationNotify>() { // from class: emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotify.1
            @Override // com.google.protobuf.Parser
            public WorldPlayerLocationNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WorldPlayerLocationNotify(input, extensionRegistry);
            }
        };

        private WorldPlayerLocationNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WorldPlayerLocationNotify() {
            this.memoizedIsInitialized = -1;
            this.playerWorldLocList_ = Collections.emptyList();
            this.playerLocList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WorldPlayerLocationNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x00b8 */
        private WorldPlayerLocationNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 42:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.playerWorldLocList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.playerWorldLocList_.add((PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo) input.readMessage(PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo.parser(), extensionRegistry));
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.playerLocList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.playerLocList_.add((PlayerLocationInfoOuterClass.PlayerLocationInfo) input.readMessage(PlayerLocationInfoOuterClass.PlayerLocationInfo.parser(), extensionRegistry));
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
                    this.playerWorldLocList_ = Collections.unmodifiableList(this.playerWorldLocList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.playerLocList_ = Collections.unmodifiableList(this.playerLocList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WorldPlayerLocationNotifyOuterClass.internal_static_WorldPlayerLocationNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WorldPlayerLocationNotifyOuterClass.internal_static_WorldPlayerLocationNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WorldPlayerLocationNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
        public List<PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo> getPlayerWorldLocListList() {
            return this.playerWorldLocList_;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
        public List<? extends PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfoOrBuilder> getPlayerWorldLocListOrBuilderList() {
            return this.playerWorldLocList_;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
        public int getPlayerWorldLocListCount() {
            return this.playerWorldLocList_.size();
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
        public PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo getPlayerWorldLocList(int index) {
            return this.playerWorldLocList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
        public PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfoOrBuilder getPlayerWorldLocListOrBuilder(int index) {
            return this.playerWorldLocList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
        public List<PlayerLocationInfoOuterClass.PlayerLocationInfo> getPlayerLocListList() {
            return this.playerLocList_;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
        public List<? extends PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder> getPlayerLocListOrBuilderList() {
            return this.playerLocList_;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
        public int getPlayerLocListCount() {
            return this.playerLocList_.size();
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
        public PlayerLocationInfoOuterClass.PlayerLocationInfo getPlayerLocList(int index) {
            return this.playerLocList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
        public PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder getPlayerLocListOrBuilder(int index) {
            return this.playerLocList_.get(index);
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
            for (int i = 0; i < this.playerWorldLocList_.size(); i++) {
                output.writeMessage(5, this.playerWorldLocList_.get(i));
            }
            for (int i2 = 0; i2 < this.playerLocList_.size(); i2++) {
                output.writeMessage(14, this.playerLocList_.get(i2));
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
            for (int i = 0; i < this.playerWorldLocList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.playerWorldLocList_.get(i));
            }
            for (int i2 = 0; i2 < this.playerLocList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.playerLocList_.get(i2));
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
            if (!(obj instanceof WorldPlayerLocationNotify)) {
                return equals(obj);
            }
            WorldPlayerLocationNotify other = (WorldPlayerLocationNotify) obj;
            return getPlayerWorldLocListList().equals(other.getPlayerWorldLocListList()) && getPlayerLocListList().equals(other.getPlayerLocListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getPlayerWorldLocListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getPlayerWorldLocListList().hashCode();
            }
            if (getPlayerLocListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getPlayerLocListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WorldPlayerLocationNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorldPlayerLocationNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldPlayerLocationNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorldPlayerLocationNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldPlayerLocationNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorldPlayerLocationNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldPlayerLocationNotify parseFrom(InputStream input) throws IOException {
            return (WorldPlayerLocationNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WorldPlayerLocationNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldPlayerLocationNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WorldPlayerLocationNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (WorldPlayerLocationNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WorldPlayerLocationNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldPlayerLocationNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WorldPlayerLocationNotify parseFrom(CodedInputStream input) throws IOException {
            return (WorldPlayerLocationNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WorldPlayerLocationNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldPlayerLocationNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WorldPlayerLocationNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerLocationNotifyOuterClass$WorldPlayerLocationNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WorldPlayerLocationNotifyOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo, PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo.Builder, PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfoOrBuilder> playerWorldLocListBuilder_;
            private RepeatedFieldBuilderV3<PlayerLocationInfoOuterClass.PlayerLocationInfo, PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder, PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder> playerLocListBuilder_;
            private List<PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo> playerWorldLocList_ = Collections.emptyList();
            private List<PlayerLocationInfoOuterClass.PlayerLocationInfo> playerLocList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return WorldPlayerLocationNotifyOuterClass.internal_static_WorldPlayerLocationNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WorldPlayerLocationNotifyOuterClass.internal_static_WorldPlayerLocationNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WorldPlayerLocationNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WorldPlayerLocationNotify.alwaysUseFieldBuilders) {
                    getPlayerWorldLocListFieldBuilder();
                    getPlayerLocListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.playerWorldLocListBuilder_ == null) {
                    this.playerWorldLocList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.playerWorldLocListBuilder_.clear();
                }
                if (this.playerLocListBuilder_ == null) {
                    this.playerLocList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.playerLocListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WorldPlayerLocationNotifyOuterClass.internal_static_WorldPlayerLocationNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WorldPlayerLocationNotify getDefaultInstanceForType() {
                return WorldPlayerLocationNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WorldPlayerLocationNotify build() {
                WorldPlayerLocationNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WorldPlayerLocationNotify buildPartial() {
                WorldPlayerLocationNotify result = new WorldPlayerLocationNotify(this);
                int i = this.bitField0_;
                if (this.playerWorldLocListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.playerWorldLocList_ = Collections.unmodifiableList(this.playerWorldLocList_);
                        this.bitField0_ &= -2;
                    }
                    result.playerWorldLocList_ = this.playerWorldLocList_;
                } else {
                    result.playerWorldLocList_ = this.playerWorldLocListBuilder_.build();
                }
                if (this.playerLocListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.playerLocList_ = Collections.unmodifiableList(this.playerLocList_);
                        this.bitField0_ &= -3;
                    }
                    result.playerLocList_ = this.playerLocList_;
                } else {
                    result.playerLocList_ = this.playerLocListBuilder_.build();
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
                if (other instanceof WorldPlayerLocationNotify) {
                    return mergeFrom((WorldPlayerLocationNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WorldPlayerLocationNotify other) {
                if (other == WorldPlayerLocationNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.playerWorldLocListBuilder_ == null) {
                    if (!other.playerWorldLocList_.isEmpty()) {
                        if (this.playerWorldLocList_.isEmpty()) {
                            this.playerWorldLocList_ = other.playerWorldLocList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePlayerWorldLocListIsMutable();
                            this.playerWorldLocList_.addAll(other.playerWorldLocList_);
                        }
                        onChanged();
                    }
                } else if (!other.playerWorldLocList_.isEmpty()) {
                    if (this.playerWorldLocListBuilder_.isEmpty()) {
                        this.playerWorldLocListBuilder_.dispose();
                        this.playerWorldLocListBuilder_ = null;
                        this.playerWorldLocList_ = other.playerWorldLocList_;
                        this.bitField0_ &= -2;
                        this.playerWorldLocListBuilder_ = WorldPlayerLocationNotify.alwaysUseFieldBuilders ? getPlayerWorldLocListFieldBuilder() : null;
                    } else {
                        this.playerWorldLocListBuilder_.addAllMessages(other.playerWorldLocList_);
                    }
                }
                if (this.playerLocListBuilder_ == null) {
                    if (!other.playerLocList_.isEmpty()) {
                        if (this.playerLocList_.isEmpty()) {
                            this.playerLocList_ = other.playerLocList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensurePlayerLocListIsMutable();
                            this.playerLocList_.addAll(other.playerLocList_);
                        }
                        onChanged();
                    }
                } else if (!other.playerLocList_.isEmpty()) {
                    if (this.playerLocListBuilder_.isEmpty()) {
                        this.playerLocListBuilder_.dispose();
                        this.playerLocListBuilder_ = null;
                        this.playerLocList_ = other.playerLocList_;
                        this.bitField0_ &= -3;
                        this.playerLocListBuilder_ = WorldPlayerLocationNotify.alwaysUseFieldBuilders ? getPlayerLocListFieldBuilder() : null;
                    } else {
                        this.playerLocListBuilder_.addAllMessages(other.playerLocList_);
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
                WorldPlayerLocationNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = WorldPlayerLocationNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WorldPlayerLocationNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensurePlayerWorldLocListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.playerWorldLocList_ = new ArrayList(this.playerWorldLocList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
            public List<PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo> getPlayerWorldLocListList() {
                if (this.playerWorldLocListBuilder_ == null) {
                    return Collections.unmodifiableList(this.playerWorldLocList_);
                }
                return this.playerWorldLocListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
            public int getPlayerWorldLocListCount() {
                if (this.playerWorldLocListBuilder_ == null) {
                    return this.playerWorldLocList_.size();
                }
                return this.playerWorldLocListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
            public PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo getPlayerWorldLocList(int index) {
                if (this.playerWorldLocListBuilder_ == null) {
                    return this.playerWorldLocList_.get(index);
                }
                return this.playerWorldLocListBuilder_.getMessage(index);
            }

            public Builder setPlayerWorldLocList(int index, PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo value) {
                if (this.playerWorldLocListBuilder_ != null) {
                    this.playerWorldLocListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerWorldLocListIsMutable();
                    this.playerWorldLocList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPlayerWorldLocList(int index, PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo.Builder builderForValue) {
                if (this.playerWorldLocListBuilder_ == null) {
                    ensurePlayerWorldLocListIsMutable();
                    this.playerWorldLocList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerWorldLocListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerWorldLocList(PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo value) {
                if (this.playerWorldLocListBuilder_ != null) {
                    this.playerWorldLocListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerWorldLocListIsMutable();
                    this.playerWorldLocList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlayerWorldLocList(int index, PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo value) {
                if (this.playerWorldLocListBuilder_ != null) {
                    this.playerWorldLocListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerWorldLocListIsMutable();
                    this.playerWorldLocList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlayerWorldLocList(PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo.Builder builderForValue) {
                if (this.playerWorldLocListBuilder_ == null) {
                    ensurePlayerWorldLocListIsMutable();
                    this.playerWorldLocList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.playerWorldLocListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerWorldLocList(int index, PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo.Builder builderForValue) {
                if (this.playerWorldLocListBuilder_ == null) {
                    ensurePlayerWorldLocListIsMutable();
                    this.playerWorldLocList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerWorldLocListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPlayerWorldLocList(Iterable<? extends PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo> values) {
                if (this.playerWorldLocListBuilder_ == null) {
                    ensurePlayerWorldLocListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.playerWorldLocList_);
                    onChanged();
                } else {
                    this.playerWorldLocListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPlayerWorldLocList() {
                if (this.playerWorldLocListBuilder_ == null) {
                    this.playerWorldLocList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.playerWorldLocListBuilder_.clear();
                }
                return this;
            }

            public Builder removePlayerWorldLocList(int index) {
                if (this.playerWorldLocListBuilder_ == null) {
                    ensurePlayerWorldLocListIsMutable();
                    this.playerWorldLocList_.remove(index);
                    onChanged();
                } else {
                    this.playerWorldLocListBuilder_.remove(index);
                }
                return this;
            }

            public PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo.Builder getPlayerWorldLocListBuilder(int index) {
                return getPlayerWorldLocListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
            public PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfoOrBuilder getPlayerWorldLocListOrBuilder(int index) {
                if (this.playerWorldLocListBuilder_ == null) {
                    return this.playerWorldLocList_.get(index);
                }
                return this.playerWorldLocListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
            public List<? extends PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfoOrBuilder> getPlayerWorldLocListOrBuilderList() {
                if (this.playerWorldLocListBuilder_ != null) {
                    return this.playerWorldLocListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.playerWorldLocList_);
            }

            public PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo.Builder addPlayerWorldLocListBuilder() {
                return getPlayerWorldLocListFieldBuilder().addBuilder(PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo.getDefaultInstance());
            }

            public PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo.Builder addPlayerWorldLocListBuilder(int index) {
                return getPlayerWorldLocListFieldBuilder().addBuilder(index, PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo.getDefaultInstance());
            }

            public List<PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo.Builder> getPlayerWorldLocListBuilderList() {
                return getPlayerWorldLocListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo, PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo.Builder, PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfoOrBuilder> getPlayerWorldLocListFieldBuilder() {
                if (this.playerWorldLocListBuilder_ == null) {
                    this.playerWorldLocListBuilder_ = new RepeatedFieldBuilderV3<>(this.playerWorldLocList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.playerWorldLocList_ = null;
                }
                return this.playerWorldLocListBuilder_;
            }

            private void ensurePlayerLocListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.playerLocList_ = new ArrayList(this.playerLocList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
            public List<PlayerLocationInfoOuterClass.PlayerLocationInfo> getPlayerLocListList() {
                if (this.playerLocListBuilder_ == null) {
                    return Collections.unmodifiableList(this.playerLocList_);
                }
                return this.playerLocListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
            public int getPlayerLocListCount() {
                if (this.playerLocListBuilder_ == null) {
                    return this.playerLocList_.size();
                }
                return this.playerLocListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
            public PlayerLocationInfoOuterClass.PlayerLocationInfo getPlayerLocList(int index) {
                if (this.playerLocListBuilder_ == null) {
                    return this.playerLocList_.get(index);
                }
                return this.playerLocListBuilder_.getMessage(index);
            }

            public Builder setPlayerLocList(int index, PlayerLocationInfoOuterClass.PlayerLocationInfo value) {
                if (this.playerLocListBuilder_ != null) {
                    this.playerLocListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerLocListIsMutable();
                    this.playerLocList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPlayerLocList(int index, PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder builderForValue) {
                if (this.playerLocListBuilder_ == null) {
                    ensurePlayerLocListIsMutable();
                    this.playerLocList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerLocListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerLocList(PlayerLocationInfoOuterClass.PlayerLocationInfo value) {
                if (this.playerLocListBuilder_ != null) {
                    this.playerLocListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerLocListIsMutable();
                    this.playerLocList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlayerLocList(int index, PlayerLocationInfoOuterClass.PlayerLocationInfo value) {
                if (this.playerLocListBuilder_ != null) {
                    this.playerLocListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerLocListIsMutable();
                    this.playerLocList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlayerLocList(PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder builderForValue) {
                if (this.playerLocListBuilder_ == null) {
                    ensurePlayerLocListIsMutable();
                    this.playerLocList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.playerLocListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerLocList(int index, PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder builderForValue) {
                if (this.playerLocListBuilder_ == null) {
                    ensurePlayerLocListIsMutable();
                    this.playerLocList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerLocListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPlayerLocList(Iterable<? extends PlayerLocationInfoOuterClass.PlayerLocationInfo> values) {
                if (this.playerLocListBuilder_ == null) {
                    ensurePlayerLocListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.playerLocList_);
                    onChanged();
                } else {
                    this.playerLocListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPlayerLocList() {
                if (this.playerLocListBuilder_ == null) {
                    this.playerLocList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.playerLocListBuilder_.clear();
                }
                return this;
            }

            public Builder removePlayerLocList(int index) {
                if (this.playerLocListBuilder_ == null) {
                    ensurePlayerLocListIsMutable();
                    this.playerLocList_.remove(index);
                    onChanged();
                } else {
                    this.playerLocListBuilder_.remove(index);
                }
                return this;
            }

            public PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder getPlayerLocListBuilder(int index) {
                return getPlayerLocListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
            public PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder getPlayerLocListOrBuilder(int index) {
                if (this.playerLocListBuilder_ == null) {
                    return this.playerLocList_.get(index);
                }
                return this.playerLocListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerLocationNotifyOuterClass.WorldPlayerLocationNotifyOrBuilder
            public List<? extends PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder> getPlayerLocListOrBuilderList() {
                if (this.playerLocListBuilder_ != null) {
                    return this.playerLocListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.playerLocList_);
            }

            public PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder addPlayerLocListBuilder() {
                return getPlayerLocListFieldBuilder().addBuilder(PlayerLocationInfoOuterClass.PlayerLocationInfo.getDefaultInstance());
            }

            public PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder addPlayerLocListBuilder(int index) {
                return getPlayerLocListFieldBuilder().addBuilder(index, PlayerLocationInfoOuterClass.PlayerLocationInfo.getDefaultInstance());
            }

            public List<PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder> getPlayerLocListBuilderList() {
                return getPlayerLocListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PlayerLocationInfoOuterClass.PlayerLocationInfo, PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder, PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder> getPlayerLocListFieldBuilder() {
                if (this.playerLocListBuilder_ == null) {
                    this.playerLocListBuilder_ = new RepeatedFieldBuilderV3<>(this.playerLocList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.playerLocList_ = null;
                }
                return this.playerLocListBuilder_;
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

        public static WorldPlayerLocationNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WorldPlayerLocationNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WorldPlayerLocationNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WorldPlayerLocationNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PlayerLocationInfoOuterClass.getDescriptor();
        PlayerWorldLocationInfoOuterClass.getDescriptor();
    }
}
