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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationReliquaryRequestOuterClass.class */
public final class GameplayRecommendationReliquaryRequestOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n,GameplayRecommendationReliquaryRequest.proto\";\n&GameplayRecommendationReliquaryRequest\u0012\u0011\n\tequipType\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* renamed from: internal_static_GameplayRecommendationReliquaryRequest_descriptor */
    private static final Descriptors.Descriptor f725x21c33ba5 = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_GameplayRecommendationReliquaryRequest_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f726x27e2ed23 = new GeneratedMessageV3.FieldAccessorTable(f725x21c33ba5, new String[]{"EquipType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationReliquaryRequestOuterClass$GameplayRecommendationReliquaryRequestOrBuilder.class */
    public interface GameplayRecommendationReliquaryRequestOrBuilder extends MessageOrBuilder {
        int getEquipType();
    }

    private GameplayRecommendationReliquaryRequestOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationReliquaryRequestOuterClass$GameplayRecommendationReliquaryRequest.class */
    public static final class GameplayRecommendationReliquaryRequest extends GeneratedMessageV3 implements GameplayRecommendationReliquaryRequestOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int EQUIPTYPE_FIELD_NUMBER = 7;
        private int equipType_;
        private byte memoizedIsInitialized;
        private static final GameplayRecommendationReliquaryRequest DEFAULT_INSTANCE = new GameplayRecommendationReliquaryRequest();
        private static final Parser<GameplayRecommendationReliquaryRequest> PARSER = new AbstractParser<GameplayRecommendationReliquaryRequest>() { // from class: emu.grasscutter.net.proto.GameplayRecommendationReliquaryRequestOuterClass.GameplayRecommendationReliquaryRequest.1
            @Override // com.google.protobuf.Parser
            public GameplayRecommendationReliquaryRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GameplayRecommendationReliquaryRequest(input, extensionRegistry);
            }
        };

        private GameplayRecommendationReliquaryRequest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GameplayRecommendationReliquaryRequest() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GameplayRecommendationReliquaryRequest();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GameplayRecommendationReliquaryRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.equipType_ = input.readUInt32();
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
            return GameplayRecommendationReliquaryRequestOuterClass.f725x21c33ba5;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GameplayRecommendationReliquaryRequestOuterClass.f726x27e2ed23.ensureFieldAccessorsInitialized(GameplayRecommendationReliquaryRequest.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryRequestOuterClass.GameplayRecommendationReliquaryRequestOrBuilder
        public int getEquipType() {
            return this.equipType_;
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
            if (this.equipType_ != 0) {
                output.writeUInt32(7, this.equipType_);
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
            if (this.equipType_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(7, this.equipType_);
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
            if (!(obj instanceof GameplayRecommendationReliquaryRequest)) {
                return equals(obj);
            }
            GameplayRecommendationReliquaryRequest other = (GameplayRecommendationReliquaryRequest) obj;
            return getEquipType() == other.getEquipType() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getEquipType())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static GameplayRecommendationReliquaryRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GameplayRecommendationReliquaryRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GameplayRecommendationReliquaryRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GameplayRecommendationReliquaryRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GameplayRecommendationReliquaryRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GameplayRecommendationReliquaryRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GameplayRecommendationReliquaryRequest parseFrom(InputStream input) throws IOException {
            return (GameplayRecommendationReliquaryRequest) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GameplayRecommendationReliquaryRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GameplayRecommendationReliquaryRequest) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GameplayRecommendationReliquaryRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GameplayRecommendationReliquaryRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GameplayRecommendationReliquaryRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GameplayRecommendationReliquaryRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GameplayRecommendationReliquaryRequest parseFrom(CodedInputStream input) throws IOException {
            return (GameplayRecommendationReliquaryRequest) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GameplayRecommendationReliquaryRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GameplayRecommendationReliquaryRequest) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GameplayRecommendationReliquaryRequest prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationReliquaryRequestOuterClass$GameplayRecommendationReliquaryRequest$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GameplayRecommendationReliquaryRequestOrBuilder {
            private int equipType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GameplayRecommendationReliquaryRequestOuterClass.f725x21c33ba5;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GameplayRecommendationReliquaryRequestOuterClass.f726x27e2ed23.ensureFieldAccessorsInitialized(GameplayRecommendationReliquaryRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GameplayRecommendationReliquaryRequest.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.equipType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GameplayRecommendationReliquaryRequestOuterClass.f725x21c33ba5;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GameplayRecommendationReliquaryRequest getDefaultInstanceForType() {
                return GameplayRecommendationReliquaryRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GameplayRecommendationReliquaryRequest build() {
                GameplayRecommendationReliquaryRequest result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GameplayRecommendationReliquaryRequest buildPartial() {
                GameplayRecommendationReliquaryRequest result = new GameplayRecommendationReliquaryRequest(this);
                result.equipType_ = this.equipType_;
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
                if (other instanceof GameplayRecommendationReliquaryRequest) {
                    return mergeFrom((GameplayRecommendationReliquaryRequest) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GameplayRecommendationReliquaryRequest other) {
                if (other == GameplayRecommendationReliquaryRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.getEquipType() != 0) {
                    setEquipType(other.getEquipType());
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
                GameplayRecommendationReliquaryRequest parsedMessage = null;
                try {
                    try {
                        parsedMessage = GameplayRecommendationReliquaryRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GameplayRecommendationReliquaryRequest) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryRequestOuterClass.GameplayRecommendationReliquaryRequestOrBuilder
            public int getEquipType() {
                return this.equipType_;
            }

            public Builder setEquipType(int value) {
                this.equipType_ = value;
                onChanged();
                return this;
            }

            public Builder clearEquipType() {
                this.equipType_ = 0;
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

        public static GameplayRecommendationReliquaryRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GameplayRecommendationReliquaryRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GameplayRecommendationReliquaryRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameplayRecommendationReliquaryRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
