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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpResultReqOuterClass.class */
public final class PlayerApplyEnterMpResultReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!PlayerApplyEnterMpResultReq.proto\"C\n\u001bPlayerApplyEnterMpResultReq\u0012\u0011\n\tapply_uid\u0018\u0007 \u0001(\r\u0012\u0011\n\tis_agreed\u0018\f \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PlayerApplyEnterMpResultReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerApplyEnterMpResultReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerApplyEnterMpResultReq_descriptor, new String[]{"ApplyUid", "IsAgreed"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpResultReqOuterClass$PlayerApplyEnterMpResultReqOrBuilder.class */
    public interface PlayerApplyEnterMpResultReqOrBuilder extends MessageOrBuilder {
        int getApplyUid();

        boolean getIsAgreed();
    }

    private PlayerApplyEnterMpResultReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpResultReqOuterClass$PlayerApplyEnterMpResultReq.class */
    public static final class PlayerApplyEnterMpResultReq extends GeneratedMessageV3 implements PlayerApplyEnterMpResultReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int APPLY_UID_FIELD_NUMBER = 7;
        private int applyUid_;
        public static final int IS_AGREED_FIELD_NUMBER = 12;
        private boolean isAgreed_;
        private byte memoizedIsInitialized;
        private static final PlayerApplyEnterMpResultReq DEFAULT_INSTANCE = new PlayerApplyEnterMpResultReq();
        private static final Parser<PlayerApplyEnterMpResultReq> PARSER = new AbstractParser<PlayerApplyEnterMpResultReq>() { // from class: emu.grasscutter.net.proto.PlayerApplyEnterMpResultReqOuterClass.PlayerApplyEnterMpResultReq.1
            @Override // com.google.protobuf.Parser
            public PlayerApplyEnterMpResultReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerApplyEnterMpResultReq(input, extensionRegistry);
            }
        };

        private PlayerApplyEnterMpResultReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerApplyEnterMpResultReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerApplyEnterMpResultReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerApplyEnterMpResultReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 56:
                                this.applyUid_ = input.readUInt32();
                                break;
                            case 96:
                                this.isAgreed_ = input.readBool();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerApplyEnterMpResultReqOuterClass.internal_static_PlayerApplyEnterMpResultReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerApplyEnterMpResultReqOuterClass.internal_static_PlayerApplyEnterMpResultReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerApplyEnterMpResultReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultReqOuterClass.PlayerApplyEnterMpResultReqOrBuilder
        public int getApplyUid() {
            return this.applyUid_;
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultReqOuterClass.PlayerApplyEnterMpResultReqOrBuilder
        public boolean getIsAgreed() {
            return this.isAgreed_;
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
            if (this.applyUid_ != 0) {
                output.writeUInt32(7, this.applyUid_);
            }
            if (this.isAgreed_) {
                output.writeBool(12, this.isAgreed_);
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
            if (this.applyUid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(7, this.applyUid_);
            }
            if (this.isAgreed_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isAgreed_);
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
            if (!(obj instanceof PlayerApplyEnterMpResultReq)) {
                return equals(obj);
            }
            PlayerApplyEnterMpResultReq other = (PlayerApplyEnterMpResultReq) obj;
            return getApplyUid() == other.getApplyUid() && getIsAgreed() == other.getIsAgreed() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getApplyUid())) + 12)) + Internal.hashBoolean(getIsAgreed()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PlayerApplyEnterMpResultReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerApplyEnterMpResultReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerApplyEnterMpResultReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerApplyEnterMpResultReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerApplyEnterMpResultReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerApplyEnterMpResultReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerApplyEnterMpResultReq parseFrom(InputStream input) throws IOException {
            return (PlayerApplyEnterMpResultReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerApplyEnterMpResultReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerApplyEnterMpResultReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerApplyEnterMpResultReq parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerApplyEnterMpResultReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerApplyEnterMpResultReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerApplyEnterMpResultReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerApplyEnterMpResultReq parseFrom(CodedInputStream input) throws IOException {
            return (PlayerApplyEnterMpResultReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerApplyEnterMpResultReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerApplyEnterMpResultReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerApplyEnterMpResultReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpResultReqOuterClass$PlayerApplyEnterMpResultReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerApplyEnterMpResultReqOrBuilder {
            private int applyUid_;
            private boolean isAgreed_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerApplyEnterMpResultReqOuterClass.internal_static_PlayerApplyEnterMpResultReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerApplyEnterMpResultReqOuterClass.internal_static_PlayerApplyEnterMpResultReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerApplyEnterMpResultReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerApplyEnterMpResultReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.applyUid_ = 0;
                this.isAgreed_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerApplyEnterMpResultReqOuterClass.internal_static_PlayerApplyEnterMpResultReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerApplyEnterMpResultReq getDefaultInstanceForType() {
                return PlayerApplyEnterMpResultReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerApplyEnterMpResultReq build() {
                PlayerApplyEnterMpResultReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerApplyEnterMpResultReq buildPartial() {
                PlayerApplyEnterMpResultReq result = new PlayerApplyEnterMpResultReq(this);
                result.applyUid_ = this.applyUid_;
                result.isAgreed_ = this.isAgreed_;
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
                if (other instanceof PlayerApplyEnterMpResultReq) {
                    return mergeFrom((PlayerApplyEnterMpResultReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerApplyEnterMpResultReq other) {
                if (other == PlayerApplyEnterMpResultReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getApplyUid() != 0) {
                    setApplyUid(other.getApplyUid());
                }
                if (other.getIsAgreed()) {
                    setIsAgreed(other.getIsAgreed());
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
                PlayerApplyEnterMpResultReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerApplyEnterMpResultReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerApplyEnterMpResultReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultReqOuterClass.PlayerApplyEnterMpResultReqOrBuilder
            public int getApplyUid() {
                return this.applyUid_;
            }

            public Builder setApplyUid(int value) {
                this.applyUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearApplyUid() {
                this.applyUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultReqOuterClass.PlayerApplyEnterMpResultReqOrBuilder
            public boolean getIsAgreed() {
                return this.isAgreed_;
            }

            public Builder setIsAgreed(boolean value) {
                this.isAgreed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAgreed() {
                this.isAgreed_ = false;
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

        public static PlayerApplyEnterMpResultReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerApplyEnterMpResultReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerApplyEnterMpResultReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerApplyEnterMpResultReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
