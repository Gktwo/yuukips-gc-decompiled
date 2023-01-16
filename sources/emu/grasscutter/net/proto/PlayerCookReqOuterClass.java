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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCookReqOuterClass.class */
public final class PlayerCookReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013PlayerCookReq.proto\"b\n\rPlayerCookReq\u0012\u0011\n\trecipe_id\u0018\u0001 \u0001(\r\u0012\u0013\n\u000bqte_quality\u0018\u0005 \u0001(\r\u0012\u0012\n\ncook_count\u0018\u0007 \u0001(\r\u0012\u0015\n\rassist_avatar\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PlayerCookReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerCookReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerCookReq_descriptor, new String[]{"RecipeId", "QteQuality", "CookCount", "AssistAvatar"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCookReqOuterClass$PlayerCookReqOrBuilder.class */
    public interface PlayerCookReqOrBuilder extends MessageOrBuilder {
        int getRecipeId();

        int getQteQuality();

        int getCookCount();

        int getAssistAvatar();
    }

    private PlayerCookReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCookReqOuterClass$PlayerCookReq.class */
    public static final class PlayerCookReq extends GeneratedMessageV3 implements PlayerCookReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RECIPE_ID_FIELD_NUMBER = 1;
        private int recipeId_;
        public static final int QTE_QUALITY_FIELD_NUMBER = 5;
        private int qteQuality_;
        public static final int COOK_COUNT_FIELD_NUMBER = 7;
        private int cookCount_;
        public static final int ASSIST_AVATAR_FIELD_NUMBER = 12;
        private int assistAvatar_;
        private byte memoizedIsInitialized;
        private static final PlayerCookReq DEFAULT_INSTANCE = new PlayerCookReq();
        private static final Parser<PlayerCookReq> PARSER = new AbstractParser<PlayerCookReq>() { // from class: emu.grasscutter.net.proto.PlayerCookReqOuterClass.PlayerCookReq.1
            @Override // com.google.protobuf.Parser
            public PlayerCookReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerCookReq(input, extensionRegistry);
            }
        };

        private PlayerCookReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerCookReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerCookReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerCookReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.recipeId_ = input.readUInt32();
                                    break;
                                case 40:
                                    this.qteQuality_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.cookCount_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.assistAvatar_ = input.readUInt32();
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
            return PlayerCookReqOuterClass.internal_static_PlayerCookReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerCookReqOuterClass.internal_static_PlayerCookReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerCookReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerCookReqOuterClass.PlayerCookReqOrBuilder
        public int getRecipeId() {
            return this.recipeId_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCookReqOuterClass.PlayerCookReqOrBuilder
        public int getQteQuality() {
            return this.qteQuality_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCookReqOuterClass.PlayerCookReqOrBuilder
        public int getCookCount() {
            return this.cookCount_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCookReqOuterClass.PlayerCookReqOrBuilder
        public int getAssistAvatar() {
            return this.assistAvatar_;
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
            if (this.recipeId_ != 0) {
                output.writeUInt32(1, this.recipeId_);
            }
            if (this.qteQuality_ != 0) {
                output.writeUInt32(5, this.qteQuality_);
            }
            if (this.cookCount_ != 0) {
                output.writeUInt32(7, this.cookCount_);
            }
            if (this.assistAvatar_ != 0) {
                output.writeUInt32(12, this.assistAvatar_);
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
            if (this.recipeId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.recipeId_);
            }
            if (this.qteQuality_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.qteQuality_);
            }
            if (this.cookCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.cookCount_);
            }
            if (this.assistAvatar_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.assistAvatar_);
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
            if (!(obj instanceof PlayerCookReq)) {
                return equals(obj);
            }
            PlayerCookReq other = (PlayerCookReq) obj;
            return getRecipeId() == other.getRecipeId() && getQteQuality() == other.getQteQuality() && getCookCount() == other.getCookCount() && getAssistAvatar() == other.getAssistAvatar() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getRecipeId())) + 5)) + getQteQuality())) + 7)) + getCookCount())) + 12)) + getAssistAvatar())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PlayerCookReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCookReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCookReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCookReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCookReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCookReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCookReq parseFrom(InputStream input) throws IOException {
            return (PlayerCookReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerCookReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCookReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerCookReq parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerCookReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerCookReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCookReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerCookReq parseFrom(CodedInputStream input) throws IOException {
            return (PlayerCookReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerCookReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCookReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerCookReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCookReqOuterClass$PlayerCookReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerCookReqOrBuilder {
            private int recipeId_;
            private int qteQuality_;
            private int cookCount_;
            private int assistAvatar_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerCookReqOuterClass.internal_static_PlayerCookReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerCookReqOuterClass.internal_static_PlayerCookReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerCookReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerCookReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.recipeId_ = 0;
                this.qteQuality_ = 0;
                this.cookCount_ = 0;
                this.assistAvatar_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerCookReqOuterClass.internal_static_PlayerCookReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerCookReq getDefaultInstanceForType() {
                return PlayerCookReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerCookReq build() {
                PlayerCookReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerCookReq buildPartial() {
                PlayerCookReq result = new PlayerCookReq(this);
                result.recipeId_ = this.recipeId_;
                result.qteQuality_ = this.qteQuality_;
                result.cookCount_ = this.cookCount_;
                result.assistAvatar_ = this.assistAvatar_;
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
                if (other instanceof PlayerCookReq) {
                    return mergeFrom((PlayerCookReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerCookReq other) {
                if (other == PlayerCookReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getRecipeId() != 0) {
                    setRecipeId(other.getRecipeId());
                }
                if (other.getQteQuality() != 0) {
                    setQteQuality(other.getQteQuality());
                }
                if (other.getCookCount() != 0) {
                    setCookCount(other.getCookCount());
                }
                if (other.getAssistAvatar() != 0) {
                    setAssistAvatar(other.getAssistAvatar());
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
                PlayerCookReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerCookReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerCookReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerCookReqOuterClass.PlayerCookReqOrBuilder
            public int getRecipeId() {
                return this.recipeId_;
            }

            public Builder setRecipeId(int value) {
                this.recipeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRecipeId() {
                this.recipeId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerCookReqOuterClass.PlayerCookReqOrBuilder
            public int getQteQuality() {
                return this.qteQuality_;
            }

            public Builder setQteQuality(int value) {
                this.qteQuality_ = value;
                onChanged();
                return this;
            }

            public Builder clearQteQuality() {
                this.qteQuality_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerCookReqOuterClass.PlayerCookReqOrBuilder
            public int getCookCount() {
                return this.cookCount_;
            }

            public Builder setCookCount(int value) {
                this.cookCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearCookCount() {
                this.cookCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerCookReqOuterClass.PlayerCookReqOrBuilder
            public int getAssistAvatar() {
                return this.assistAvatar_;
            }

            public Builder setAssistAvatar(int value) {
                this.assistAvatar_ = value;
                onChanged();
                return this;
            }

            public Builder clearAssistAvatar() {
                this.assistAvatar_ = 0;
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

        public static PlayerCookReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerCookReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerCookReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerCookReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
