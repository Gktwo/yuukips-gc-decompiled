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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationReliquaryMainPropDataOuterClass.class */
public final class GameplayRecommendationReliquaryMainPropDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n1GameplayRecommendationReliquaryMainPropData.proto\"W\n+GameplayRecommendationReliquaryMainPropData\u0012\u0012\n\npermillage\u0018\u0005 \u0001(\r\u0012\u0014\n\fmain_prop_id\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* renamed from: internal_static_GameplayRecommendationReliquaryMainPropData_descriptor */
    private static final Descriptors.Descriptor f737xd25aba02 = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_GameplayRecommendationReliquaryMainPropData_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f738xdcf8be80 = new GeneratedMessageV3.FieldAccessorTable(f737xd25aba02, new String[]{"Permillage", "MainPropId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationReliquaryMainPropDataOuterClass$GameplayRecommendationReliquaryMainPropDataOrBuilder.class */
    public interface GameplayRecommendationReliquaryMainPropDataOrBuilder extends MessageOrBuilder {
        int getPermillage();

        int getMainPropId();
    }

    private GameplayRecommendationReliquaryMainPropDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationReliquaryMainPropDataOuterClass$GameplayRecommendationReliquaryMainPropData.class */
    public static final class GameplayRecommendationReliquaryMainPropData extends GeneratedMessageV3 implements GameplayRecommendationReliquaryMainPropDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PERMILLAGE_FIELD_NUMBER = 5;
        private int permillage_;
        public static final int MAIN_PROP_ID_FIELD_NUMBER = 10;
        private int mainPropId_;
        private byte memoizedIsInitialized;
        private static final GameplayRecommendationReliquaryMainPropData DEFAULT_INSTANCE = new GameplayRecommendationReliquaryMainPropData();
        private static final Parser<GameplayRecommendationReliquaryMainPropData> PARSER = new AbstractParser<GameplayRecommendationReliquaryMainPropData>() { // from class: emu.grasscutter.net.proto.GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropData.1
            @Override // com.google.protobuf.Parser
            public GameplayRecommendationReliquaryMainPropData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GameplayRecommendationReliquaryMainPropData(input, extensionRegistry);
            }
        };

        private GameplayRecommendationReliquaryMainPropData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GameplayRecommendationReliquaryMainPropData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GameplayRecommendationReliquaryMainPropData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GameplayRecommendationReliquaryMainPropData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 40:
                                this.permillage_ = input.readUInt32();
                                break;
                            case 80:
                                this.mainPropId_ = input.readUInt32();
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
            return GameplayRecommendationReliquaryMainPropDataOuterClass.f737xd25aba02;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GameplayRecommendationReliquaryMainPropDataOuterClass.f738xdcf8be80.ensureFieldAccessorsInitialized(GameplayRecommendationReliquaryMainPropData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder
        public int getPermillage() {
            return this.permillage_;
        }

        @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder
        public int getMainPropId() {
            return this.mainPropId_;
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
            if (this.permillage_ != 0) {
                output.writeUInt32(5, this.permillage_);
            }
            if (this.mainPropId_ != 0) {
                output.writeUInt32(10, this.mainPropId_);
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
            if (this.permillage_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.permillage_);
            }
            if (this.mainPropId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.mainPropId_);
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
            if (!(obj instanceof GameplayRecommendationReliquaryMainPropData)) {
                return equals(obj);
            }
            GameplayRecommendationReliquaryMainPropData other = (GameplayRecommendationReliquaryMainPropData) obj;
            return getPermillage() == other.getPermillage() && getMainPropId() == other.getMainPropId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getPermillage())) + 10)) + getMainPropId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static GameplayRecommendationReliquaryMainPropData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GameplayRecommendationReliquaryMainPropData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GameplayRecommendationReliquaryMainPropData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GameplayRecommendationReliquaryMainPropData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GameplayRecommendationReliquaryMainPropData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GameplayRecommendationReliquaryMainPropData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GameplayRecommendationReliquaryMainPropData parseFrom(InputStream input) throws IOException {
            return (GameplayRecommendationReliquaryMainPropData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GameplayRecommendationReliquaryMainPropData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GameplayRecommendationReliquaryMainPropData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GameplayRecommendationReliquaryMainPropData parseDelimitedFrom(InputStream input) throws IOException {
            return (GameplayRecommendationReliquaryMainPropData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GameplayRecommendationReliquaryMainPropData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GameplayRecommendationReliquaryMainPropData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GameplayRecommendationReliquaryMainPropData parseFrom(CodedInputStream input) throws IOException {
            return (GameplayRecommendationReliquaryMainPropData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GameplayRecommendationReliquaryMainPropData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GameplayRecommendationReliquaryMainPropData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GameplayRecommendationReliquaryMainPropData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GameplayRecommendationReliquaryMainPropDataOuterClass$GameplayRecommendationReliquaryMainPropData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GameplayRecommendationReliquaryMainPropDataOrBuilder {
            private int permillage_;
            private int mainPropId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GameplayRecommendationReliquaryMainPropDataOuterClass.f737xd25aba02;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GameplayRecommendationReliquaryMainPropDataOuterClass.f738xdcf8be80.ensureFieldAccessorsInitialized(GameplayRecommendationReliquaryMainPropData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GameplayRecommendationReliquaryMainPropData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.permillage_ = 0;
                this.mainPropId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GameplayRecommendationReliquaryMainPropDataOuterClass.f737xd25aba02;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GameplayRecommendationReliquaryMainPropData getDefaultInstanceForType() {
                return GameplayRecommendationReliquaryMainPropData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GameplayRecommendationReliquaryMainPropData build() {
                GameplayRecommendationReliquaryMainPropData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GameplayRecommendationReliquaryMainPropData buildPartial() {
                GameplayRecommendationReliquaryMainPropData result = new GameplayRecommendationReliquaryMainPropData(this);
                result.permillage_ = this.permillage_;
                result.mainPropId_ = this.mainPropId_;
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
                if (other instanceof GameplayRecommendationReliquaryMainPropData) {
                    return mergeFrom((GameplayRecommendationReliquaryMainPropData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GameplayRecommendationReliquaryMainPropData other) {
                if (other == GameplayRecommendationReliquaryMainPropData.getDefaultInstance()) {
                    return this;
                }
                if (other.getPermillage() != 0) {
                    setPermillage(other.getPermillage());
                }
                if (other.getMainPropId() != 0) {
                    setMainPropId(other.getMainPropId());
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
                GameplayRecommendationReliquaryMainPropData parsedMessage = null;
                try {
                    try {
                        parsedMessage = GameplayRecommendationReliquaryMainPropData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GameplayRecommendationReliquaryMainPropData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder
            public int getPermillage() {
                return this.permillage_;
            }

            public Builder setPermillage(int value) {
                this.permillage_ = value;
                onChanged();
                return this;
            }

            public Builder clearPermillage() {
                this.permillage_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GameplayRecommendationReliquaryMainPropDataOuterClass.GameplayRecommendationReliquaryMainPropDataOrBuilder
            public int getMainPropId() {
                return this.mainPropId_;
            }

            public Builder setMainPropId(int value) {
                this.mainPropId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMainPropId() {
                this.mainPropId_ = 0;
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

        public static GameplayRecommendationReliquaryMainPropData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GameplayRecommendationReliquaryMainPropData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GameplayRecommendationReliquaryMainPropData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameplayRecommendationReliquaryMainPropData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
