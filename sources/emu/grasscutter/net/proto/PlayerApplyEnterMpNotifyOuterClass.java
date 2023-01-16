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
import emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpNotifyOuterClass.class */
public final class PlayerApplyEnterMpNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001ePlayerApplyEnterMpNotify.proto\u001a\u0016OnlinePlayerInfo.proto\"t\n\u0018PlayerApplyEnterMpNotify\u0012*\n\u000fsrc_player_info\u0018\f \u0001(\u000b2\u0011.OnlinePlayerInfo\u0012\u0018\n\u0010src_thread_index\u0018\t \u0001(\r\u0012\u0012\n\nsrc_app_id\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{OnlinePlayerInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerApplyEnterMpNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerApplyEnterMpNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerApplyEnterMpNotify_descriptor, new String[]{"SrcPlayerInfo", "SrcThreadIndex", "SrcAppId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpNotifyOuterClass$PlayerApplyEnterMpNotifyOrBuilder.class */
    public interface PlayerApplyEnterMpNotifyOrBuilder extends MessageOrBuilder {
        boolean hasSrcPlayerInfo();

        OnlinePlayerInfoOuterClass.OnlinePlayerInfo getSrcPlayerInfo();

        OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getSrcPlayerInfoOrBuilder();

        int getSrcThreadIndex();

        int getSrcAppId();
    }

    private PlayerApplyEnterMpNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpNotifyOuterClass$PlayerApplyEnterMpNotify.class */
    public static final class PlayerApplyEnterMpNotify extends GeneratedMessageV3 implements PlayerApplyEnterMpNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SRC_PLAYER_INFO_FIELD_NUMBER = 12;
        private OnlinePlayerInfoOuterClass.OnlinePlayerInfo srcPlayerInfo_;
        public static final int SRC_THREAD_INDEX_FIELD_NUMBER = 9;
        private int srcThreadIndex_;
        public static final int SRC_APP_ID_FIELD_NUMBER = 13;
        private int srcAppId_;
        private byte memoizedIsInitialized;
        private static final PlayerApplyEnterMpNotify DEFAULT_INSTANCE = new PlayerApplyEnterMpNotify();
        private static final Parser<PlayerApplyEnterMpNotify> PARSER = new AbstractParser<PlayerApplyEnterMpNotify>() { // from class: emu.grasscutter.net.proto.PlayerApplyEnterMpNotifyOuterClass.PlayerApplyEnterMpNotify.1
            @Override // com.google.protobuf.Parser
            public PlayerApplyEnterMpNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerApplyEnterMpNotify(input, extensionRegistry);
            }
        };

        private PlayerApplyEnterMpNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerApplyEnterMpNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerApplyEnterMpNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerApplyEnterMpNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 72:
                                    this.srcThreadIndex_ = input.readUInt32();
                                    break;
                                case 98:
                                    OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder subBuilder = this.srcPlayerInfo_ != null ? this.srcPlayerInfo_.toBuilder() : null;
                                    this.srcPlayerInfo_ = (OnlinePlayerInfoOuterClass.OnlinePlayerInfo) input.readMessage(OnlinePlayerInfoOuterClass.OnlinePlayerInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.srcPlayerInfo_);
                                        this.srcPlayerInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 104:
                                    this.srcAppId_ = input.readUInt32();
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
            return PlayerApplyEnterMpNotifyOuterClass.internal_static_PlayerApplyEnterMpNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerApplyEnterMpNotifyOuterClass.internal_static_PlayerApplyEnterMpNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerApplyEnterMpNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpNotifyOuterClass.PlayerApplyEnterMpNotifyOrBuilder
        public boolean hasSrcPlayerInfo() {
            return this.srcPlayerInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpNotifyOuterClass.PlayerApplyEnterMpNotifyOrBuilder
        public OnlinePlayerInfoOuterClass.OnlinePlayerInfo getSrcPlayerInfo() {
            return this.srcPlayerInfo_ == null ? OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance() : this.srcPlayerInfo_;
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpNotifyOuterClass.PlayerApplyEnterMpNotifyOrBuilder
        public OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getSrcPlayerInfoOrBuilder() {
            return getSrcPlayerInfo();
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpNotifyOuterClass.PlayerApplyEnterMpNotifyOrBuilder
        public int getSrcThreadIndex() {
            return this.srcThreadIndex_;
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpNotifyOuterClass.PlayerApplyEnterMpNotifyOrBuilder
        public int getSrcAppId() {
            return this.srcAppId_;
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
            if (this.srcThreadIndex_ != 0) {
                output.writeUInt32(9, this.srcThreadIndex_);
            }
            if (this.srcPlayerInfo_ != null) {
                output.writeMessage(12, getSrcPlayerInfo());
            }
            if (this.srcAppId_ != 0) {
                output.writeUInt32(13, this.srcAppId_);
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
            if (this.srcThreadIndex_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(9, this.srcThreadIndex_);
            }
            if (this.srcPlayerInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getSrcPlayerInfo());
            }
            if (this.srcAppId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.srcAppId_);
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
            if (!(obj instanceof PlayerApplyEnterMpNotify)) {
                return equals(obj);
            }
            PlayerApplyEnterMpNotify other = (PlayerApplyEnterMpNotify) obj;
            if (hasSrcPlayerInfo() != other.hasSrcPlayerInfo()) {
                return false;
            }
            return (!hasSrcPlayerInfo() || getSrcPlayerInfo().equals(other.getSrcPlayerInfo())) && getSrcThreadIndex() == other.getSrcThreadIndex() && getSrcAppId() == other.getSrcAppId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasSrcPlayerInfo()) {
                hash = (53 * ((37 * hash) + 12)) + getSrcPlayerInfo().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 9)) + getSrcThreadIndex())) + 13)) + getSrcAppId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PlayerApplyEnterMpNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerApplyEnterMpNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerApplyEnterMpNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerApplyEnterMpNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerApplyEnterMpNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerApplyEnterMpNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerApplyEnterMpNotify parseFrom(InputStream input) throws IOException {
            return (PlayerApplyEnterMpNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerApplyEnterMpNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerApplyEnterMpNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerApplyEnterMpNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerApplyEnterMpNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerApplyEnterMpNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerApplyEnterMpNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerApplyEnterMpNotify parseFrom(CodedInputStream input) throws IOException {
            return (PlayerApplyEnterMpNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerApplyEnterMpNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerApplyEnterMpNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerApplyEnterMpNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpNotifyOuterClass$PlayerApplyEnterMpNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerApplyEnterMpNotifyOrBuilder {
            private OnlinePlayerInfoOuterClass.OnlinePlayerInfo srcPlayerInfo_;
            private SingleFieldBuilderV3<OnlinePlayerInfoOuterClass.OnlinePlayerInfo, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder, OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> srcPlayerInfoBuilder_;
            private int srcThreadIndex_;
            private int srcAppId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerApplyEnterMpNotifyOuterClass.internal_static_PlayerApplyEnterMpNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerApplyEnterMpNotifyOuterClass.internal_static_PlayerApplyEnterMpNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerApplyEnterMpNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerApplyEnterMpNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.srcPlayerInfoBuilder_ == null) {
                    this.srcPlayerInfo_ = null;
                } else {
                    this.srcPlayerInfo_ = null;
                    this.srcPlayerInfoBuilder_ = null;
                }
                this.srcThreadIndex_ = 0;
                this.srcAppId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerApplyEnterMpNotifyOuterClass.internal_static_PlayerApplyEnterMpNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerApplyEnterMpNotify getDefaultInstanceForType() {
                return PlayerApplyEnterMpNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerApplyEnterMpNotify build() {
                PlayerApplyEnterMpNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerApplyEnterMpNotify buildPartial() {
                PlayerApplyEnterMpNotify result = new PlayerApplyEnterMpNotify(this);
                if (this.srcPlayerInfoBuilder_ == null) {
                    result.srcPlayerInfo_ = this.srcPlayerInfo_;
                } else {
                    result.srcPlayerInfo_ = this.srcPlayerInfoBuilder_.build();
                }
                result.srcThreadIndex_ = this.srcThreadIndex_;
                result.srcAppId_ = this.srcAppId_;
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
                if (other instanceof PlayerApplyEnterMpNotify) {
                    return mergeFrom((PlayerApplyEnterMpNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerApplyEnterMpNotify other) {
                if (other == PlayerApplyEnterMpNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasSrcPlayerInfo()) {
                    mergeSrcPlayerInfo(other.getSrcPlayerInfo());
                }
                if (other.getSrcThreadIndex() != 0) {
                    setSrcThreadIndex(other.getSrcThreadIndex());
                }
                if (other.getSrcAppId() != 0) {
                    setSrcAppId(other.getSrcAppId());
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
                PlayerApplyEnterMpNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerApplyEnterMpNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerApplyEnterMpNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpNotifyOuterClass.PlayerApplyEnterMpNotifyOrBuilder
            public boolean hasSrcPlayerInfo() {
                return (this.srcPlayerInfoBuilder_ == null && this.srcPlayerInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpNotifyOuterClass.PlayerApplyEnterMpNotifyOrBuilder
            public OnlinePlayerInfoOuterClass.OnlinePlayerInfo getSrcPlayerInfo() {
                if (this.srcPlayerInfoBuilder_ == null) {
                    return this.srcPlayerInfo_ == null ? OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance() : this.srcPlayerInfo_;
                }
                return this.srcPlayerInfoBuilder_.getMessage();
            }

            public Builder setSrcPlayerInfo(OnlinePlayerInfoOuterClass.OnlinePlayerInfo value) {
                if (this.srcPlayerInfoBuilder_ != null) {
                    this.srcPlayerInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.srcPlayerInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSrcPlayerInfo(OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder builderForValue) {
                if (this.srcPlayerInfoBuilder_ == null) {
                    this.srcPlayerInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.srcPlayerInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSrcPlayerInfo(OnlinePlayerInfoOuterClass.OnlinePlayerInfo value) {
                if (this.srcPlayerInfoBuilder_ == null) {
                    if (this.srcPlayerInfo_ != null) {
                        this.srcPlayerInfo_ = OnlinePlayerInfoOuterClass.OnlinePlayerInfo.newBuilder(this.srcPlayerInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.srcPlayerInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.srcPlayerInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSrcPlayerInfo() {
                if (this.srcPlayerInfoBuilder_ == null) {
                    this.srcPlayerInfo_ = null;
                    onChanged();
                } else {
                    this.srcPlayerInfo_ = null;
                    this.srcPlayerInfoBuilder_ = null;
                }
                return this;
            }

            public OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder getSrcPlayerInfoBuilder() {
                onChanged();
                return getSrcPlayerInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpNotifyOuterClass.PlayerApplyEnterMpNotifyOrBuilder
            public OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getSrcPlayerInfoOrBuilder() {
                if (this.srcPlayerInfoBuilder_ != null) {
                    return this.srcPlayerInfoBuilder_.getMessageOrBuilder();
                }
                return this.srcPlayerInfo_ == null ? OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance() : this.srcPlayerInfo_;
            }

            private SingleFieldBuilderV3<OnlinePlayerInfoOuterClass.OnlinePlayerInfo, OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder, OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> getSrcPlayerInfoFieldBuilder() {
                if (this.srcPlayerInfoBuilder_ == null) {
                    this.srcPlayerInfoBuilder_ = new SingleFieldBuilderV3<>(getSrcPlayerInfo(), getParentForChildren(), isClean());
                    this.srcPlayerInfo_ = null;
                }
                return this.srcPlayerInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpNotifyOuterClass.PlayerApplyEnterMpNotifyOrBuilder
            public int getSrcThreadIndex() {
                return this.srcThreadIndex_;
            }

            public Builder setSrcThreadIndex(int value) {
                this.srcThreadIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearSrcThreadIndex() {
                this.srcThreadIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpNotifyOuterClass.PlayerApplyEnterMpNotifyOrBuilder
            public int getSrcAppId() {
                return this.srcAppId_;
            }

            public Builder setSrcAppId(int value) {
                this.srcAppId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSrcAppId() {
                this.srcAppId_ = 0;
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

        public static PlayerApplyEnterMpNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerApplyEnterMpNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerApplyEnterMpNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerApplyEnterMpNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        OnlinePlayerInfoOuterClass.getDescriptor();
    }
}
