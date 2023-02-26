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
import emu.grasscutter.net.proto.PlayerRTTInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerRTTNotifyOuterClass.class */
public final class WorldPlayerRTTNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aWorldPlayerRTTNotify.proto\u001a\u0013PlayerRTTInfo.proto\"=\n\u0014WorldPlayerRTTNotify\u0012%\n\rplayerRttList\u0018\u0002 \u0003(\u000b2\u000e.PlayerRTTInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PlayerRTTInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WorldPlayerRTTNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WorldPlayerRTTNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WorldPlayerRTTNotify_descriptor, new String[]{"PlayerRttList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerRTTNotifyOuterClass$WorldPlayerRTTNotifyOrBuilder.class */
    public interface WorldPlayerRTTNotifyOrBuilder extends MessageOrBuilder {
        List<PlayerRTTInfoOuterClass.PlayerRTTInfo> getPlayerRttListList();

        PlayerRTTInfoOuterClass.PlayerRTTInfo getPlayerRttList(int i);

        int getPlayerRttListCount();

        List<? extends PlayerRTTInfoOuterClass.PlayerRTTInfoOrBuilder> getPlayerRttListOrBuilderList();

        PlayerRTTInfoOuterClass.PlayerRTTInfoOrBuilder getPlayerRttListOrBuilder(int i);
    }

    private WorldPlayerRTTNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerRTTNotifyOuterClass$WorldPlayerRTTNotify.class */
    public static final class WorldPlayerRTTNotify extends GeneratedMessageV3 implements WorldPlayerRTTNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PLAYERRTTLIST_FIELD_NUMBER = 2;
        private List<PlayerRTTInfoOuterClass.PlayerRTTInfo> playerRttList_;
        private byte memoizedIsInitialized;
        private static final WorldPlayerRTTNotify DEFAULT_INSTANCE = new WorldPlayerRTTNotify();
        private static final Parser<WorldPlayerRTTNotify> PARSER = new AbstractParser<WorldPlayerRTTNotify>() { // from class: emu.grasscutter.net.proto.WorldPlayerRTTNotifyOuterClass.WorldPlayerRTTNotify.1
            @Override // com.google.protobuf.Parser
            public WorldPlayerRTTNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WorldPlayerRTTNotify(input, extensionRegistry);
            }
        };

        private WorldPlayerRTTNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WorldPlayerRTTNotify() {
            this.memoizedIsInitialized = -1;
            this.playerRttList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WorldPlayerRTTNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WorldPlayerRTTNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 18:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.playerRttList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.playerRttList_.add((PlayerRTTInfoOuterClass.PlayerRTTInfo) input.readMessage(PlayerRTTInfoOuterClass.PlayerRTTInfo.parser(), extensionRegistry));
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
                    this.playerRttList_ = Collections.unmodifiableList(this.playerRttList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WorldPlayerRTTNotifyOuterClass.internal_static_WorldPlayerRTTNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WorldPlayerRTTNotifyOuterClass.internal_static_WorldPlayerRTTNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WorldPlayerRTTNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerRTTNotifyOuterClass.WorldPlayerRTTNotifyOrBuilder
        public List<PlayerRTTInfoOuterClass.PlayerRTTInfo> getPlayerRttListList() {
            return this.playerRttList_;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerRTTNotifyOuterClass.WorldPlayerRTTNotifyOrBuilder
        public List<? extends PlayerRTTInfoOuterClass.PlayerRTTInfoOrBuilder> getPlayerRttListOrBuilderList() {
            return this.playerRttList_;
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerRTTNotifyOuterClass.WorldPlayerRTTNotifyOrBuilder
        public int getPlayerRttListCount() {
            return this.playerRttList_.size();
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerRTTNotifyOuterClass.WorldPlayerRTTNotifyOrBuilder
        public PlayerRTTInfoOuterClass.PlayerRTTInfo getPlayerRttList(int index) {
            return this.playerRttList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WorldPlayerRTTNotifyOuterClass.WorldPlayerRTTNotifyOrBuilder
        public PlayerRTTInfoOuterClass.PlayerRTTInfoOrBuilder getPlayerRttListOrBuilder(int index) {
            return this.playerRttList_.get(index);
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
            for (int i = 0; i < this.playerRttList_.size(); i++) {
                output.writeMessage(2, this.playerRttList_.get(i));
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
            for (int i = 0; i < this.playerRttList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.playerRttList_.get(i));
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
            if (!(obj instanceof WorldPlayerRTTNotify)) {
                return equals(obj);
            }
            WorldPlayerRTTNotify other = (WorldPlayerRTTNotify) obj;
            return getPlayerRttListList().equals(other.getPlayerRttListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getPlayerRttListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getPlayerRttListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WorldPlayerRTTNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorldPlayerRTTNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldPlayerRTTNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorldPlayerRTTNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldPlayerRTTNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorldPlayerRTTNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldPlayerRTTNotify parseFrom(InputStream input) throws IOException {
            return (WorldPlayerRTTNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WorldPlayerRTTNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldPlayerRTTNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WorldPlayerRTTNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (WorldPlayerRTTNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WorldPlayerRTTNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldPlayerRTTNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WorldPlayerRTTNotify parseFrom(CodedInputStream input) throws IOException {
            return (WorldPlayerRTTNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WorldPlayerRTTNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldPlayerRTTNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WorldPlayerRTTNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldPlayerRTTNotifyOuterClass$WorldPlayerRTTNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WorldPlayerRTTNotifyOrBuilder {
            private int bitField0_;
            private List<PlayerRTTInfoOuterClass.PlayerRTTInfo> playerRttList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<PlayerRTTInfoOuterClass.PlayerRTTInfo, PlayerRTTInfoOuterClass.PlayerRTTInfo.Builder, PlayerRTTInfoOuterClass.PlayerRTTInfoOrBuilder> playerRttListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WorldPlayerRTTNotifyOuterClass.internal_static_WorldPlayerRTTNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WorldPlayerRTTNotifyOuterClass.internal_static_WorldPlayerRTTNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WorldPlayerRTTNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WorldPlayerRTTNotify.alwaysUseFieldBuilders) {
                    getPlayerRttListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.playerRttListBuilder_ == null) {
                    this.playerRttList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.playerRttListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WorldPlayerRTTNotifyOuterClass.internal_static_WorldPlayerRTTNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WorldPlayerRTTNotify getDefaultInstanceForType() {
                return WorldPlayerRTTNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WorldPlayerRTTNotify build() {
                WorldPlayerRTTNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WorldPlayerRTTNotify buildPartial() {
                WorldPlayerRTTNotify result = new WorldPlayerRTTNotify(this);
                int i = this.bitField0_;
                if (this.playerRttListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.playerRttList_ = Collections.unmodifiableList(this.playerRttList_);
                        this.bitField0_ &= -2;
                    }
                    result.playerRttList_ = this.playerRttList_;
                } else {
                    result.playerRttList_ = this.playerRttListBuilder_.build();
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
                if (other instanceof WorldPlayerRTTNotify) {
                    return mergeFrom((WorldPlayerRTTNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WorldPlayerRTTNotify other) {
                if (other == WorldPlayerRTTNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.playerRttListBuilder_ == null) {
                    if (!other.playerRttList_.isEmpty()) {
                        if (this.playerRttList_.isEmpty()) {
                            this.playerRttList_ = other.playerRttList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePlayerRttListIsMutable();
                            this.playerRttList_.addAll(other.playerRttList_);
                        }
                        onChanged();
                    }
                } else if (!other.playerRttList_.isEmpty()) {
                    if (this.playerRttListBuilder_.isEmpty()) {
                        this.playerRttListBuilder_.dispose();
                        this.playerRttListBuilder_ = null;
                        this.playerRttList_ = other.playerRttList_;
                        this.bitField0_ &= -2;
                        this.playerRttListBuilder_ = WorldPlayerRTTNotify.alwaysUseFieldBuilders ? getPlayerRttListFieldBuilder() : null;
                    } else {
                        this.playerRttListBuilder_.addAllMessages(other.playerRttList_);
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
                WorldPlayerRTTNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = WorldPlayerRTTNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WorldPlayerRTTNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensurePlayerRttListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.playerRttList_ = new ArrayList(this.playerRttList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerRTTNotifyOuterClass.WorldPlayerRTTNotifyOrBuilder
            public List<PlayerRTTInfoOuterClass.PlayerRTTInfo> getPlayerRttListList() {
                if (this.playerRttListBuilder_ == null) {
                    return Collections.unmodifiableList(this.playerRttList_);
                }
                return this.playerRttListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerRTTNotifyOuterClass.WorldPlayerRTTNotifyOrBuilder
            public int getPlayerRttListCount() {
                if (this.playerRttListBuilder_ == null) {
                    return this.playerRttList_.size();
                }
                return this.playerRttListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerRTTNotifyOuterClass.WorldPlayerRTTNotifyOrBuilder
            public PlayerRTTInfoOuterClass.PlayerRTTInfo getPlayerRttList(int index) {
                if (this.playerRttListBuilder_ == null) {
                    return this.playerRttList_.get(index);
                }
                return this.playerRttListBuilder_.getMessage(index);
            }

            public Builder setPlayerRttList(int index, PlayerRTTInfoOuterClass.PlayerRTTInfo value) {
                if (this.playerRttListBuilder_ != null) {
                    this.playerRttListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerRttListIsMutable();
                    this.playerRttList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPlayerRttList(int index, PlayerRTTInfoOuterClass.PlayerRTTInfo.Builder builderForValue) {
                if (this.playerRttListBuilder_ == null) {
                    ensurePlayerRttListIsMutable();
                    this.playerRttList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerRttListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerRttList(PlayerRTTInfoOuterClass.PlayerRTTInfo value) {
                if (this.playerRttListBuilder_ != null) {
                    this.playerRttListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerRttListIsMutable();
                    this.playerRttList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlayerRttList(int index, PlayerRTTInfoOuterClass.PlayerRTTInfo value) {
                if (this.playerRttListBuilder_ != null) {
                    this.playerRttListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerRttListIsMutable();
                    this.playerRttList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlayerRttList(PlayerRTTInfoOuterClass.PlayerRTTInfo.Builder builderForValue) {
                if (this.playerRttListBuilder_ == null) {
                    ensurePlayerRttListIsMutable();
                    this.playerRttList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.playerRttListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerRttList(int index, PlayerRTTInfoOuterClass.PlayerRTTInfo.Builder builderForValue) {
                if (this.playerRttListBuilder_ == null) {
                    ensurePlayerRttListIsMutable();
                    this.playerRttList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerRttListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPlayerRttList(Iterable<? extends PlayerRTTInfoOuterClass.PlayerRTTInfo> values) {
                if (this.playerRttListBuilder_ == null) {
                    ensurePlayerRttListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.playerRttList_);
                    onChanged();
                } else {
                    this.playerRttListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPlayerRttList() {
                if (this.playerRttListBuilder_ == null) {
                    this.playerRttList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.playerRttListBuilder_.clear();
                }
                return this;
            }

            public Builder removePlayerRttList(int index) {
                if (this.playerRttListBuilder_ == null) {
                    ensurePlayerRttListIsMutable();
                    this.playerRttList_.remove(index);
                    onChanged();
                } else {
                    this.playerRttListBuilder_.remove(index);
                }
                return this;
            }

            public PlayerRTTInfoOuterClass.PlayerRTTInfo.Builder getPlayerRttListBuilder(int index) {
                return getPlayerRttListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerRTTNotifyOuterClass.WorldPlayerRTTNotifyOrBuilder
            public PlayerRTTInfoOuterClass.PlayerRTTInfoOrBuilder getPlayerRttListOrBuilder(int index) {
                if (this.playerRttListBuilder_ == null) {
                    return this.playerRttList_.get(index);
                }
                return this.playerRttListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WorldPlayerRTTNotifyOuterClass.WorldPlayerRTTNotifyOrBuilder
            public List<? extends PlayerRTTInfoOuterClass.PlayerRTTInfoOrBuilder> getPlayerRttListOrBuilderList() {
                if (this.playerRttListBuilder_ != null) {
                    return this.playerRttListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.playerRttList_);
            }

            public PlayerRTTInfoOuterClass.PlayerRTTInfo.Builder addPlayerRttListBuilder() {
                return getPlayerRttListFieldBuilder().addBuilder(PlayerRTTInfoOuterClass.PlayerRTTInfo.getDefaultInstance());
            }

            public PlayerRTTInfoOuterClass.PlayerRTTInfo.Builder addPlayerRttListBuilder(int index) {
                return getPlayerRttListFieldBuilder().addBuilder(index, PlayerRTTInfoOuterClass.PlayerRTTInfo.getDefaultInstance());
            }

            public List<PlayerRTTInfoOuterClass.PlayerRTTInfo.Builder> getPlayerRttListBuilderList() {
                return getPlayerRttListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PlayerRTTInfoOuterClass.PlayerRTTInfo, PlayerRTTInfoOuterClass.PlayerRTTInfo.Builder, PlayerRTTInfoOuterClass.PlayerRTTInfoOrBuilder> getPlayerRttListFieldBuilder() {
                if (this.playerRttListBuilder_ == null) {
                    this.playerRttListBuilder_ = new RepeatedFieldBuilderV3<>(this.playerRttList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.playerRttList_ = null;
                }
                return this.playerRttListBuilder_;
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

        public static WorldPlayerRTTNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WorldPlayerRTTNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WorldPlayerRTTNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WorldPlayerRTTNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PlayerRTTInfoOuterClass.getDescriptor();
    }
}
