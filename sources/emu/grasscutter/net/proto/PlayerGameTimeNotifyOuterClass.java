package emu.grasscutter.net.proto;

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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerGameTimeNotifyOuterClass.class */
public final class PlayerGameTimeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aPlayerGameTimeNotify.proto\"E\n\u0014PlayerGameTimeNotify\u0012\u0010\n\bgameTime\u0018\u0001 \u0001(\r\u0012\u000e\n\u0006isHome\u0018\u0003 \u0001(\b\u0012\u000b\n\u0003uid\u0018\u000e \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PlayerGameTimeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerGameTimeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerGameTimeNotify_descriptor, new String[]{"GameTime", "IsHome", "Uid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerGameTimeNotifyOuterClass$PlayerGameTimeNotifyOrBuilder.class */
    public interface PlayerGameTimeNotifyOrBuilder extends MessageOrBuilder {
        int getGameTime();

        boolean getIsHome();

        int getUid();
    }

    private PlayerGameTimeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerGameTimeNotifyOuterClass$PlayerGameTimeNotify.class */
    public static final class PlayerGameTimeNotify extends GeneratedMessageV3 implements PlayerGameTimeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GAMETIME_FIELD_NUMBER = 1;
        private int gameTime_;
        public static final int ISHOME_FIELD_NUMBER = 3;
        private boolean isHome_;
        public static final int UID_FIELD_NUMBER = 14;
        private int uid_;
        private byte memoizedIsInitialized;
        private static final PlayerGameTimeNotify DEFAULT_INSTANCE = new PlayerGameTimeNotify();
        private static final Parser<PlayerGameTimeNotify> PARSER = new AbstractParser<PlayerGameTimeNotify>() { // from class: emu.grasscutter.net.proto.PlayerGameTimeNotifyOuterClass.PlayerGameTimeNotify.1
            @Override // com.google.protobuf.Parser
            public PlayerGameTimeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerGameTimeNotify(input, extensionRegistry);
            }
        };

        private PlayerGameTimeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerGameTimeNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerGameTimeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerGameTimeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.gameTime_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.isHome_ = input.readBool();
                                    break;
                                case 112:
                                    this.uid_ = input.readUInt32();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerGameTimeNotifyOuterClass.internal_static_PlayerGameTimeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerGameTimeNotifyOuterClass.internal_static_PlayerGameTimeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerGameTimeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerGameTimeNotifyOuterClass.PlayerGameTimeNotifyOrBuilder
        public int getGameTime() {
            return this.gameTime_;
        }

        @Override // emu.grasscutter.net.proto.PlayerGameTimeNotifyOuterClass.PlayerGameTimeNotifyOrBuilder
        public boolean getIsHome() {
            return this.isHome_;
        }

        @Override // emu.grasscutter.net.proto.PlayerGameTimeNotifyOuterClass.PlayerGameTimeNotifyOrBuilder
        public int getUid() {
            return this.uid_;
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
            if (this.gameTime_ != 0) {
                output.writeUInt32(1, this.gameTime_);
            }
            if (this.isHome_) {
                output.writeBool(3, this.isHome_);
            }
            if (this.uid_ != 0) {
                output.writeUInt32(14, this.uid_);
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
            if (this.gameTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.gameTime_);
            }
            if (this.isHome_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.isHome_);
            }
            if (this.uid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.uid_);
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
            if (!(obj instanceof PlayerGameTimeNotify)) {
                return equals(obj);
            }
            PlayerGameTimeNotify other = (PlayerGameTimeNotify) obj;
            return getGameTime() == other.getGameTime() && getIsHome() == other.getIsHome() && getUid() == other.getUid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getGameTime())) + 3)) + Internal.hashBoolean(getIsHome()))) + 14)) + getUid())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PlayerGameTimeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerGameTimeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerGameTimeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerGameTimeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerGameTimeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerGameTimeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerGameTimeNotify parseFrom(InputStream input) throws IOException {
            return (PlayerGameTimeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerGameTimeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerGameTimeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerGameTimeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerGameTimeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerGameTimeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerGameTimeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerGameTimeNotify parseFrom(CodedInputStream input) throws IOException {
            return (PlayerGameTimeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerGameTimeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerGameTimeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerGameTimeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerGameTimeNotifyOuterClass$PlayerGameTimeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerGameTimeNotifyOrBuilder {
            private int gameTime_;
            private boolean isHome_;
            private int uid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerGameTimeNotifyOuterClass.internal_static_PlayerGameTimeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerGameTimeNotifyOuterClass.internal_static_PlayerGameTimeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerGameTimeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerGameTimeNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.gameTime_ = 0;
                this.isHome_ = false;
                this.uid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerGameTimeNotifyOuterClass.internal_static_PlayerGameTimeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerGameTimeNotify getDefaultInstanceForType() {
                return PlayerGameTimeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerGameTimeNotify build() {
                PlayerGameTimeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerGameTimeNotify buildPartial() {
                PlayerGameTimeNotify result = new PlayerGameTimeNotify(this);
                result.gameTime_ = this.gameTime_;
                result.isHome_ = this.isHome_;
                result.uid_ = this.uid_;
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
                if (other instanceof PlayerGameTimeNotify) {
                    return mergeFrom((PlayerGameTimeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerGameTimeNotify other) {
                if (other == PlayerGameTimeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getGameTime() != 0) {
                    setGameTime(other.getGameTime());
                }
                if (other.getIsHome()) {
                    setIsHome(other.getIsHome());
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
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
                PlayerGameTimeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerGameTimeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerGameTimeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerGameTimeNotifyOuterClass.PlayerGameTimeNotifyOrBuilder
            public int getGameTime() {
                return this.gameTime_;
            }

            public Builder setGameTime(int value) {
                this.gameTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearGameTime() {
                this.gameTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerGameTimeNotifyOuterClass.PlayerGameTimeNotifyOrBuilder
            public boolean getIsHome() {
                return this.isHome_;
            }

            public Builder setIsHome(boolean value) {
                this.isHome_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsHome() {
                this.isHome_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerGameTimeNotifyOuterClass.PlayerGameTimeNotifyOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static PlayerGameTimeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerGameTimeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerGameTimeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerGameTimeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
