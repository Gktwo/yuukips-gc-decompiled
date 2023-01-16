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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialBoostReqOuterClass.class */
public final class PlayerCompoundMaterialBoostReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$PlayerCompoundMaterialBoostReq.proto\"\u0001\n\u001ePlayerCompoundMaterialBoostReq\u0012\u0014\n\fis_boost_all\u0018\r \u0001(\b\u0012\u001b\n\u0013Unk3300_PPDDLODBIKG\u0018\b \u0001(\r\u0012\u001b\n\u0013Unk3300_BGHFBCLHCIG\u0018\u0005 \u0001(\r\u0012\u001b\n\u0013Unk3300_FEGPHHFLFLM\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PlayerCompoundMaterialBoostReq_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_PlayerCompoundMaterialBoostReq_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f828x1944ae4f = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerCompoundMaterialBoostReq_descriptor, new String[]{"IsBoostAll", "Unk3300PPDDLODBIKG", "Unk3300BGHFBCLHCIG", "Unk3300FEGPHHFLFLM"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialBoostReqOuterClass$PlayerCompoundMaterialBoostReqOrBuilder.class */
    public interface PlayerCompoundMaterialBoostReqOrBuilder extends MessageOrBuilder {
        boolean getIsBoostAll();

        int getUnk3300PPDDLODBIKG();

        int getUnk3300BGHFBCLHCIG();

        int getUnk3300FEGPHHFLFLM();
    }

    private PlayerCompoundMaterialBoostReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialBoostReqOuterClass$PlayerCompoundMaterialBoostReq.class */
    public static final class PlayerCompoundMaterialBoostReq extends GeneratedMessageV3 implements PlayerCompoundMaterialBoostReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_BOOST_ALL_FIELD_NUMBER = 13;
        private boolean isBoostAll_;
        public static final int UNK3300_PPDDLODBIKG_FIELD_NUMBER = 8;
        private int unk3300PPDDLODBIKG_;
        public static final int UNK3300_BGHFBCLHCIG_FIELD_NUMBER = 5;
        private int unk3300BGHFBCLHCIG_;
        public static final int UNK3300_FEGPHHFLFLM_FIELD_NUMBER = 11;
        private int unk3300FEGPHHFLFLM_;
        private byte memoizedIsInitialized;
        private static final PlayerCompoundMaterialBoostReq DEFAULT_INSTANCE = new PlayerCompoundMaterialBoostReq();
        private static final Parser<PlayerCompoundMaterialBoostReq> PARSER = new AbstractParser<PlayerCompoundMaterialBoostReq>() { // from class: emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReq.1
            @Override // com.google.protobuf.Parser
            public PlayerCompoundMaterialBoostReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerCompoundMaterialBoostReq(input, extensionRegistry);
            }
        };

        private PlayerCompoundMaterialBoostReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerCompoundMaterialBoostReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerCompoundMaterialBoostReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerCompoundMaterialBoostReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    this.unk3300BGHFBCLHCIG_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.unk3300PPDDLODBIKG_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.unk3300FEGPHHFLFLM_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.isBoostAll_ = input.readBool();
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
            return PlayerCompoundMaterialBoostReqOuterClass.internal_static_PlayerCompoundMaterialBoostReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerCompoundMaterialBoostReqOuterClass.f828x1944ae4f.ensureFieldAccessorsInitialized(PlayerCompoundMaterialBoostReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public boolean getIsBoostAll() {
            return this.isBoostAll_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public int getUnk3300PPDDLODBIKG() {
            return this.unk3300PPDDLODBIKG_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public int getUnk3300BGHFBCLHCIG() {
            return this.unk3300BGHFBCLHCIG_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public int getUnk3300FEGPHHFLFLM() {
            return this.unk3300FEGPHHFLFLM_;
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
            if (this.unk3300BGHFBCLHCIG_ != 0) {
                output.writeUInt32(5, this.unk3300BGHFBCLHCIG_);
            }
            if (this.unk3300PPDDLODBIKG_ != 0) {
                output.writeUInt32(8, this.unk3300PPDDLODBIKG_);
            }
            if (this.unk3300FEGPHHFLFLM_ != 0) {
                output.writeUInt32(11, this.unk3300FEGPHHFLFLM_);
            }
            if (this.isBoostAll_) {
                output.writeBool(13, this.isBoostAll_);
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
            if (this.unk3300BGHFBCLHCIG_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.unk3300BGHFBCLHCIG_);
            }
            if (this.unk3300PPDDLODBIKG_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.unk3300PPDDLODBIKG_);
            }
            if (this.unk3300FEGPHHFLFLM_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.unk3300FEGPHHFLFLM_);
            }
            if (this.isBoostAll_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isBoostAll_);
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
            if (!(obj instanceof PlayerCompoundMaterialBoostReq)) {
                return equals(obj);
            }
            PlayerCompoundMaterialBoostReq other = (PlayerCompoundMaterialBoostReq) obj;
            return getIsBoostAll() == other.getIsBoostAll() && getUnk3300PPDDLODBIKG() == other.getUnk3300PPDDLODBIKG() && getUnk3300BGHFBCLHCIG() == other.getUnk3300BGHFBCLHCIG() && getUnk3300FEGPHHFLFLM() == other.getUnk3300FEGPHHFLFLM() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + Internal.hashBoolean(getIsBoostAll()))) + 8)) + getUnk3300PPDDLODBIKG())) + 5)) + getUnk3300BGHFBCLHCIG())) + 11)) + getUnk3300FEGPHHFLFLM())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(InputStream input) throws IOException {
            return (PlayerCompoundMaterialBoostReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCompoundMaterialBoostReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostReq parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerCompoundMaterialBoostReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerCompoundMaterialBoostReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCompoundMaterialBoostReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(CodedInputStream input) throws IOException {
            return (PlayerCompoundMaterialBoostReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCompoundMaterialBoostReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerCompoundMaterialBoostReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialBoostReqOuterClass$PlayerCompoundMaterialBoostReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerCompoundMaterialBoostReqOrBuilder {
            private boolean isBoostAll_;
            private int unk3300PPDDLODBIKG_;
            private int unk3300BGHFBCLHCIG_;
            private int unk3300FEGPHHFLFLM_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerCompoundMaterialBoostReqOuterClass.internal_static_PlayerCompoundMaterialBoostReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerCompoundMaterialBoostReqOuterClass.f828x1944ae4f.ensureFieldAccessorsInitialized(PlayerCompoundMaterialBoostReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerCompoundMaterialBoostReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isBoostAll_ = false;
                this.unk3300PPDDLODBIKG_ = 0;
                this.unk3300BGHFBCLHCIG_ = 0;
                this.unk3300FEGPHHFLFLM_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerCompoundMaterialBoostReqOuterClass.internal_static_PlayerCompoundMaterialBoostReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerCompoundMaterialBoostReq getDefaultInstanceForType() {
                return PlayerCompoundMaterialBoostReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerCompoundMaterialBoostReq build() {
                PlayerCompoundMaterialBoostReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerCompoundMaterialBoostReq buildPartial() {
                PlayerCompoundMaterialBoostReq result = new PlayerCompoundMaterialBoostReq(this);
                result.isBoostAll_ = this.isBoostAll_;
                result.unk3300PPDDLODBIKG_ = this.unk3300PPDDLODBIKG_;
                result.unk3300BGHFBCLHCIG_ = this.unk3300BGHFBCLHCIG_;
                result.unk3300FEGPHHFLFLM_ = this.unk3300FEGPHHFLFLM_;
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
                if (other instanceof PlayerCompoundMaterialBoostReq) {
                    return mergeFrom((PlayerCompoundMaterialBoostReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerCompoundMaterialBoostReq other) {
                if (other == PlayerCompoundMaterialBoostReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsBoostAll()) {
                    setIsBoostAll(other.getIsBoostAll());
                }
                if (other.getUnk3300PPDDLODBIKG() != 0) {
                    setUnk3300PPDDLODBIKG(other.getUnk3300PPDDLODBIKG());
                }
                if (other.getUnk3300BGHFBCLHCIG() != 0) {
                    setUnk3300BGHFBCLHCIG(other.getUnk3300BGHFBCLHCIG());
                }
                if (other.getUnk3300FEGPHHFLFLM() != 0) {
                    setUnk3300FEGPHHFLFLM(other.getUnk3300FEGPHHFLFLM());
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
                PlayerCompoundMaterialBoostReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerCompoundMaterialBoostReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerCompoundMaterialBoostReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
            public boolean getIsBoostAll() {
                return this.isBoostAll_;
            }

            public Builder setIsBoostAll(boolean value) {
                this.isBoostAll_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsBoostAll() {
                this.isBoostAll_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
            public int getUnk3300PPDDLODBIKG() {
                return this.unk3300PPDDLODBIKG_;
            }

            public Builder setUnk3300PPDDLODBIKG(int value) {
                this.unk3300PPDDLODBIKG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300PPDDLODBIKG() {
                this.unk3300PPDDLODBIKG_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
            public int getUnk3300BGHFBCLHCIG() {
                return this.unk3300BGHFBCLHCIG_;
            }

            public Builder setUnk3300BGHFBCLHCIG(int value) {
                this.unk3300BGHFBCLHCIG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300BGHFBCLHCIG() {
                this.unk3300BGHFBCLHCIG_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
            public int getUnk3300FEGPHHFLFLM() {
                return this.unk3300FEGPHHFLFLM_;
            }

            public Builder setUnk3300FEGPHHFLFLM(int value) {
                this.unk3300FEGPHHFLFLM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300FEGPHHFLFLM() {
                this.unk3300FEGPHHFLFLM_ = 0;
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

        public static PlayerCompoundMaterialBoostReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerCompoundMaterialBoostReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerCompoundMaterialBoostReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerCompoundMaterialBoostReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
