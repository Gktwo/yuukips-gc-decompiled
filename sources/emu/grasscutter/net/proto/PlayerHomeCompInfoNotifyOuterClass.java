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
import emu.grasscutter.net.proto.PlayerHomeCompInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerHomeCompInfoNotifyOuterClass.class */
public final class PlayerHomeCompInfoNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001ePlayerHomeCompInfoNotify.proto\u001a\u0018PlayerHomeCompInfo.proto\"B\n\u0018PlayerHomeCompInfoNotify\u0012&\n\tcomp_info\u0018\u0002 \u0001(\u000b2\u0013.PlayerHomeCompInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PlayerHomeCompInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerHomeCompInfoNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerHomeCompInfoNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerHomeCompInfoNotify_descriptor, new String[]{"CompInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerHomeCompInfoNotifyOuterClass$PlayerHomeCompInfoNotifyOrBuilder.class */
    public interface PlayerHomeCompInfoNotifyOrBuilder extends MessageOrBuilder {
        boolean hasCompInfo();

        PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo getCompInfo();

        PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder getCompInfoOrBuilder();
    }

    private PlayerHomeCompInfoNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerHomeCompInfoNotifyOuterClass$PlayerHomeCompInfoNotify.class */
    public static final class PlayerHomeCompInfoNotify extends GeneratedMessageV3 implements PlayerHomeCompInfoNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COMP_INFO_FIELD_NUMBER = 2;
        private PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo compInfo_;
        private byte memoizedIsInitialized;
        private static final PlayerHomeCompInfoNotify DEFAULT_INSTANCE = new PlayerHomeCompInfoNotify();
        private static final Parser<PlayerHomeCompInfoNotify> PARSER = new AbstractParser<PlayerHomeCompInfoNotify>() { // from class: emu.grasscutter.net.proto.PlayerHomeCompInfoNotifyOuterClass.PlayerHomeCompInfoNotify.1
            @Override // com.google.protobuf.Parser
            public PlayerHomeCompInfoNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerHomeCompInfoNotify(input, extensionRegistry);
            }
        };

        private PlayerHomeCompInfoNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerHomeCompInfoNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerHomeCompInfoNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerHomeCompInfoNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 18:
                                PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo.Builder subBuilder = this.compInfo_ != null ? this.compInfo_.toBuilder() : null;
                                this.compInfo_ = (PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo) input.readMessage(PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.compInfo_);
                                    this.compInfo_ = subBuilder.buildPartial();
                                    break;
                                }
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
            return PlayerHomeCompInfoNotifyOuterClass.internal_static_PlayerHomeCompInfoNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerHomeCompInfoNotifyOuterClass.internal_static_PlayerHomeCompInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerHomeCompInfoNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoNotifyOuterClass.PlayerHomeCompInfoNotifyOrBuilder
        public boolean hasCompInfo() {
            return this.compInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoNotifyOuterClass.PlayerHomeCompInfoNotifyOrBuilder
        public PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo getCompInfo() {
            return this.compInfo_ == null ? PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo.getDefaultInstance() : this.compInfo_;
        }

        @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoNotifyOuterClass.PlayerHomeCompInfoNotifyOrBuilder
        public PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder getCompInfoOrBuilder() {
            return getCompInfo();
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
            if (this.compInfo_ != null) {
                output.writeMessage(2, getCompInfo());
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
            if (this.compInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getCompInfo());
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
            if (!(obj instanceof PlayerHomeCompInfoNotify)) {
                return equals(obj);
            }
            PlayerHomeCompInfoNotify other = (PlayerHomeCompInfoNotify) obj;
            if (hasCompInfo() != other.hasCompInfo()) {
                return false;
            }
            return (!hasCompInfo() || getCompInfo().equals(other.getCompInfo())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasCompInfo()) {
                hash = (53 * ((37 * hash) + 2)) + getCompInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PlayerHomeCompInfoNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerHomeCompInfoNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerHomeCompInfoNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerHomeCompInfoNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerHomeCompInfoNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerHomeCompInfoNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerHomeCompInfoNotify parseFrom(InputStream input) throws IOException {
            return (PlayerHomeCompInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerHomeCompInfoNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerHomeCompInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerHomeCompInfoNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerHomeCompInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerHomeCompInfoNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerHomeCompInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerHomeCompInfoNotify parseFrom(CodedInputStream input) throws IOException {
            return (PlayerHomeCompInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerHomeCompInfoNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerHomeCompInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerHomeCompInfoNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerHomeCompInfoNotifyOuterClass$PlayerHomeCompInfoNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerHomeCompInfoNotifyOrBuilder {
            private PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo compInfo_;
            private SingleFieldBuilderV3<PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo, PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo.Builder, PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder> compInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerHomeCompInfoNotifyOuterClass.internal_static_PlayerHomeCompInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerHomeCompInfoNotifyOuterClass.internal_static_PlayerHomeCompInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerHomeCompInfoNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerHomeCompInfoNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.compInfoBuilder_ == null) {
                    this.compInfo_ = null;
                } else {
                    this.compInfo_ = null;
                    this.compInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerHomeCompInfoNotifyOuterClass.internal_static_PlayerHomeCompInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerHomeCompInfoNotify getDefaultInstanceForType() {
                return PlayerHomeCompInfoNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerHomeCompInfoNotify build() {
                PlayerHomeCompInfoNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerHomeCompInfoNotify buildPartial() {
                PlayerHomeCompInfoNotify result = new PlayerHomeCompInfoNotify(this);
                if (this.compInfoBuilder_ == null) {
                    result.compInfo_ = this.compInfo_;
                } else {
                    result.compInfo_ = this.compInfoBuilder_.build();
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
                if (other instanceof PlayerHomeCompInfoNotify) {
                    return mergeFrom((PlayerHomeCompInfoNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerHomeCompInfoNotify other) {
                if (other == PlayerHomeCompInfoNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasCompInfo()) {
                    mergeCompInfo(other.getCompInfo());
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
                PlayerHomeCompInfoNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerHomeCompInfoNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerHomeCompInfoNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoNotifyOuterClass.PlayerHomeCompInfoNotifyOrBuilder
            public boolean hasCompInfo() {
                return (this.compInfoBuilder_ == null && this.compInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoNotifyOuterClass.PlayerHomeCompInfoNotifyOrBuilder
            public PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo getCompInfo() {
                if (this.compInfoBuilder_ == null) {
                    return this.compInfo_ == null ? PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo.getDefaultInstance() : this.compInfo_;
                }
                return this.compInfoBuilder_.getMessage();
            }

            public Builder setCompInfo(PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo value) {
                if (this.compInfoBuilder_ != null) {
                    this.compInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.compInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setCompInfo(PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo.Builder builderForValue) {
                if (this.compInfoBuilder_ == null) {
                    this.compInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.compInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeCompInfo(PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo value) {
                if (this.compInfoBuilder_ == null) {
                    if (this.compInfo_ != null) {
                        this.compInfo_ = PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo.newBuilder(this.compInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.compInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.compInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearCompInfo() {
                if (this.compInfoBuilder_ == null) {
                    this.compInfo_ = null;
                    onChanged();
                } else {
                    this.compInfo_ = null;
                    this.compInfoBuilder_ = null;
                }
                return this;
            }

            public PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo.Builder getCompInfoBuilder() {
                onChanged();
                return getCompInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlayerHomeCompInfoNotifyOuterClass.PlayerHomeCompInfoNotifyOrBuilder
            public PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder getCompInfoOrBuilder() {
                if (this.compInfoBuilder_ != null) {
                    return this.compInfoBuilder_.getMessageOrBuilder();
                }
                return this.compInfo_ == null ? PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo.getDefaultInstance() : this.compInfo_;
            }

            private SingleFieldBuilderV3<PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo, PlayerHomeCompInfoOuterClass.PlayerHomeCompInfo.Builder, PlayerHomeCompInfoOuterClass.PlayerHomeCompInfoOrBuilder> getCompInfoFieldBuilder() {
                if (this.compInfoBuilder_ == null) {
                    this.compInfoBuilder_ = new SingleFieldBuilderV3<>(getCompInfo(), getParentForChildren(), isClean());
                    this.compInfo_ = null;
                }
                return this.compInfoBuilder_;
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

        public static PlayerHomeCompInfoNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerHomeCompInfoNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerHomeCompInfoNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerHomeCompInfoNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PlayerHomeCompInfoOuterClass.getDescriptor();
    }
}
