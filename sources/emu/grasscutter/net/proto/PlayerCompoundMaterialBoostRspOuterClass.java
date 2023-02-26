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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialBoostRspOuterClass.class */
public final class PlayerCompoundMaterialBoostRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$PlayerCompoundMaterialBoostRsp.proto\"T\n\u001ePlayerCompoundMaterialBoostRsp\u0012\u000b\n\u0003uid\u0018\t \u0001(\r\u0012\u0013\n\u000bakkcmakdlck\u0018\u0001 \u0001(\r\u0012\u0010\n\bgameTime\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PlayerCompoundMaterialBoostRsp_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_PlayerCompoundMaterialBoostRsp_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f807xe20044fe = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerCompoundMaterialBoostRsp_descriptor, new String[]{"Uid", "Akkcmakdlck", "GameTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialBoostRspOuterClass$PlayerCompoundMaterialBoostRspOrBuilder.class */
    public interface PlayerCompoundMaterialBoostRspOrBuilder extends MessageOrBuilder {
        int getUid();

        int getAkkcmakdlck();

        int getGameTime();
    }

    private PlayerCompoundMaterialBoostRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialBoostRspOuterClass$PlayerCompoundMaterialBoostRsp.class */
    public static final class PlayerCompoundMaterialBoostRsp extends GeneratedMessageV3 implements PlayerCompoundMaterialBoostRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UID_FIELD_NUMBER = 9;
        private int uid_;
        public static final int AKKCMAKDLCK_FIELD_NUMBER = 1;
        private int akkcmakdlck_;
        public static final int GAMETIME_FIELD_NUMBER = 8;
        private int gameTime_;
        private byte memoizedIsInitialized;
        private static final PlayerCompoundMaterialBoostRsp DEFAULT_INSTANCE = new PlayerCompoundMaterialBoostRsp();
        private static final Parser<PlayerCompoundMaterialBoostRsp> PARSER = new AbstractParser<PlayerCompoundMaterialBoostRsp>() { // from class: emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRsp.1
            @Override // com.google.protobuf.Parser
            public PlayerCompoundMaterialBoostRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerCompoundMaterialBoostRsp(input, extensionRegistry);
            }
        };

        private PlayerCompoundMaterialBoostRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerCompoundMaterialBoostRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerCompoundMaterialBoostRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerCompoundMaterialBoostRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.akkcmakdlck_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.gameTime_ = input.readUInt32();
                                    break;
                                case 72:
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
            return PlayerCompoundMaterialBoostRspOuterClass.internal_static_PlayerCompoundMaterialBoostRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerCompoundMaterialBoostRspOuterClass.f807xe20044fe.ensureFieldAccessorsInitialized(PlayerCompoundMaterialBoostRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
        public int getAkkcmakdlck() {
            return this.akkcmakdlck_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
        public int getGameTime() {
            return this.gameTime_;
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
            if (this.akkcmakdlck_ != 0) {
                output.writeUInt32(1, this.akkcmakdlck_);
            }
            if (this.gameTime_ != 0) {
                output.writeUInt32(8, this.gameTime_);
            }
            if (this.uid_ != 0) {
                output.writeUInt32(9, this.uid_);
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
            if (this.akkcmakdlck_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.akkcmakdlck_);
            }
            if (this.gameTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.gameTime_);
            }
            if (this.uid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.uid_);
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
            if (!(obj instanceof PlayerCompoundMaterialBoostRsp)) {
                return equals(obj);
            }
            PlayerCompoundMaterialBoostRsp other = (PlayerCompoundMaterialBoostRsp) obj;
            return getUid() == other.getUid() && getAkkcmakdlck() == other.getAkkcmakdlck() && getGameTime() == other.getGameTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getUid())) + 1)) + getAkkcmakdlck())) + 8)) + getGameTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(InputStream input) throws IOException {
            return (PlayerCompoundMaterialBoostRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCompoundMaterialBoostRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerCompoundMaterialBoostRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerCompoundMaterialBoostRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCompoundMaterialBoostRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(CodedInputStream input) throws IOException {
            return (PlayerCompoundMaterialBoostRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCompoundMaterialBoostRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerCompoundMaterialBoostRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialBoostRspOuterClass$PlayerCompoundMaterialBoostRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerCompoundMaterialBoostRspOrBuilder {
            private int uid_;
            private int akkcmakdlck_;
            private int gameTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerCompoundMaterialBoostRspOuterClass.internal_static_PlayerCompoundMaterialBoostRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerCompoundMaterialBoostRspOuterClass.f807xe20044fe.ensureFieldAccessorsInitialized(PlayerCompoundMaterialBoostRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerCompoundMaterialBoostRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.uid_ = 0;
                this.akkcmakdlck_ = 0;
                this.gameTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerCompoundMaterialBoostRspOuterClass.internal_static_PlayerCompoundMaterialBoostRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerCompoundMaterialBoostRsp getDefaultInstanceForType() {
                return PlayerCompoundMaterialBoostRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerCompoundMaterialBoostRsp build() {
                PlayerCompoundMaterialBoostRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerCompoundMaterialBoostRsp buildPartial() {
                PlayerCompoundMaterialBoostRsp result = new PlayerCompoundMaterialBoostRsp(this);
                result.uid_ = this.uid_;
                result.akkcmakdlck_ = this.akkcmakdlck_;
                result.gameTime_ = this.gameTime_;
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
                if (other instanceof PlayerCompoundMaterialBoostRsp) {
                    return mergeFrom((PlayerCompoundMaterialBoostRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerCompoundMaterialBoostRsp other) {
                if (other == PlayerCompoundMaterialBoostRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (other.getAkkcmakdlck() != 0) {
                    setAkkcmakdlck(other.getAkkcmakdlck());
                }
                if (other.getGameTime() != 0) {
                    setGameTime(other.getGameTime());
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
                PlayerCompoundMaterialBoostRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerCompoundMaterialBoostRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerCompoundMaterialBoostRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
            public int getAkkcmakdlck() {
                return this.akkcmakdlck_;
            }

            public Builder setAkkcmakdlck(int value) {
                this.akkcmakdlck_ = value;
                onChanged();
                return this;
            }

            public Builder clearAkkcmakdlck() {
                this.akkcmakdlck_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static PlayerCompoundMaterialBoostRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerCompoundMaterialBoostRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerCompoundMaterialBoostRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerCompoundMaterialBoostRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
