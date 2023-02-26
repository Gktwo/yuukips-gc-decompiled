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
import emu.grasscutter.net.proto.HomeGroupPlayerInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSeekFurniturePlayerScoreOuterClass.class */
public final class HomeSeekFurniturePlayerScoreOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"HomeSeekFurniturePlayerScore.proto\u001a\u0019HomeGroupPlayerInfo.proto\"W\n\u001cHomeSeekFurniturePlayerScore\u0012(\n\nplayerInfo\u0018\u0004 \u0001(\u000b2\u0014.HomeGroupPlayerInfo\u0012\r\n\u0005score\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeGroupPlayerInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeSeekFurniturePlayerScore_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeSeekFurniturePlayerScore_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeSeekFurniturePlayerScore_descriptor, new String[]{"PlayerInfo", "Score"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSeekFurniturePlayerScoreOuterClass$HomeSeekFurniturePlayerScoreOrBuilder.class */
    public interface HomeSeekFurniturePlayerScoreOrBuilder extends MessageOrBuilder {
        boolean hasPlayerInfo();

        HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo getPlayerInfo();

        HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder getPlayerInfoOrBuilder();

        int getScore();
    }

    private HomeSeekFurniturePlayerScoreOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSeekFurniturePlayerScoreOuterClass$HomeSeekFurniturePlayerScore.class */
    public static final class HomeSeekFurniturePlayerScore extends GeneratedMessageV3 implements HomeSeekFurniturePlayerScoreOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PLAYERINFO_FIELD_NUMBER = 4;
        private HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo playerInfo_;
        public static final int SCORE_FIELD_NUMBER = 9;
        private int score_;
        private byte memoizedIsInitialized;
        private static final HomeSeekFurniturePlayerScore DEFAULT_INSTANCE = new HomeSeekFurniturePlayerScore();
        private static final Parser<HomeSeekFurniturePlayerScore> PARSER = new AbstractParser<HomeSeekFurniturePlayerScore>() { // from class: emu.grasscutter.net.proto.HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore.1
            @Override // com.google.protobuf.Parser
            public HomeSeekFurniturePlayerScore parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeSeekFurniturePlayerScore(input, extensionRegistry);
            }
        };

        private HomeSeekFurniturePlayerScore(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeSeekFurniturePlayerScore() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeSeekFurniturePlayerScore();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeSeekFurniturePlayerScore(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 34:
                                    HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo.Builder subBuilder = this.playerInfo_ != null ? this.playerInfo_.toBuilder() : null;
                                    this.playerInfo_ = (HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo) input.readMessage(HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.playerInfo_);
                                        this.playerInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 72:
                                    this.score_ = input.readUInt32();
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
            return HomeSeekFurniturePlayerScoreOuterClass.internal_static_HomeSeekFurniturePlayerScore_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeSeekFurniturePlayerScoreOuterClass.internal_static_HomeSeekFurniturePlayerScore_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeSeekFurniturePlayerScore.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScoreOrBuilder
        public boolean hasPlayerInfo() {
            return this.playerInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScoreOrBuilder
        public HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo getPlayerInfo() {
            return this.playerInfo_ == null ? HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo.getDefaultInstance() : this.playerInfo_;
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScoreOrBuilder
        public HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder getPlayerInfoOrBuilder() {
            return getPlayerInfo();
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScoreOrBuilder
        public int getScore() {
            return this.score_;
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
            if (this.playerInfo_ != null) {
                output.writeMessage(4, getPlayerInfo());
            }
            if (this.score_ != 0) {
                output.writeUInt32(9, this.score_);
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
            if (this.playerInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(4, getPlayerInfo());
            }
            if (this.score_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.score_);
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
            if (!(obj instanceof HomeSeekFurniturePlayerScore)) {
                return equals(obj);
            }
            HomeSeekFurniturePlayerScore other = (HomeSeekFurniturePlayerScore) obj;
            if (hasPlayerInfo() != other.hasPlayerInfo()) {
                return false;
            }
            return (!hasPlayerInfo() || getPlayerInfo().equals(other.getPlayerInfo())) && getScore() == other.getScore() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasPlayerInfo()) {
                hash = (53 * ((37 * hash) + 4)) + getPlayerInfo().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 9)) + getScore())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeSeekFurniturePlayerScore parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeSeekFurniturePlayerScore parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeSeekFurniturePlayerScore parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeSeekFurniturePlayerScore parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeSeekFurniturePlayerScore parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeSeekFurniturePlayerScore parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeSeekFurniturePlayerScore parseFrom(InputStream input) throws IOException {
            return (HomeSeekFurniturePlayerScore) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeSeekFurniturePlayerScore parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeSeekFurniturePlayerScore) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeSeekFurniturePlayerScore parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeSeekFurniturePlayerScore) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeSeekFurniturePlayerScore parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeSeekFurniturePlayerScore) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeSeekFurniturePlayerScore parseFrom(CodedInputStream input) throws IOException {
            return (HomeSeekFurniturePlayerScore) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeSeekFurniturePlayerScore parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeSeekFurniturePlayerScore) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeSeekFurniturePlayerScore prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSeekFurniturePlayerScoreOuterClass$HomeSeekFurniturePlayerScore$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeSeekFurniturePlayerScoreOrBuilder {
            private HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo playerInfo_;
            private SingleFieldBuilderV3<HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo, HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo.Builder, HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder> playerInfoBuilder_;
            private int score_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeSeekFurniturePlayerScoreOuterClass.internal_static_HomeSeekFurniturePlayerScore_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeSeekFurniturePlayerScoreOuterClass.internal_static_HomeSeekFurniturePlayerScore_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeSeekFurniturePlayerScore.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeSeekFurniturePlayerScore.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.playerInfoBuilder_ == null) {
                    this.playerInfo_ = null;
                } else {
                    this.playerInfo_ = null;
                    this.playerInfoBuilder_ = null;
                }
                this.score_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeSeekFurniturePlayerScoreOuterClass.internal_static_HomeSeekFurniturePlayerScore_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeSeekFurniturePlayerScore getDefaultInstanceForType() {
                return HomeSeekFurniturePlayerScore.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeSeekFurniturePlayerScore build() {
                HomeSeekFurniturePlayerScore result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeSeekFurniturePlayerScore buildPartial() {
                HomeSeekFurniturePlayerScore result = new HomeSeekFurniturePlayerScore(this);
                if (this.playerInfoBuilder_ == null) {
                    result.playerInfo_ = this.playerInfo_;
                } else {
                    result.playerInfo_ = this.playerInfoBuilder_.build();
                }
                result.score_ = this.score_;
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
                if (other instanceof HomeSeekFurniturePlayerScore) {
                    return mergeFrom((HomeSeekFurniturePlayerScore) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeSeekFurniturePlayerScore other) {
                if (other == HomeSeekFurniturePlayerScore.getDefaultInstance()) {
                    return this;
                }
                if (other.hasPlayerInfo()) {
                    mergePlayerInfo(other.getPlayerInfo());
                }
                if (other.getScore() != 0) {
                    setScore(other.getScore());
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
                HomeSeekFurniturePlayerScore parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeSeekFurniturePlayerScore.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeSeekFurniturePlayerScore) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScoreOrBuilder
            public boolean hasPlayerInfo() {
                return (this.playerInfoBuilder_ == null && this.playerInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScoreOrBuilder
            public HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo getPlayerInfo() {
                if (this.playerInfoBuilder_ == null) {
                    return this.playerInfo_ == null ? HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo.getDefaultInstance() : this.playerInfo_;
                }
                return this.playerInfoBuilder_.getMessage();
            }

            public Builder setPlayerInfo(HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo value) {
                if (this.playerInfoBuilder_ != null) {
                    this.playerInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.playerInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPlayerInfo(HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo.Builder builderForValue) {
                if (this.playerInfoBuilder_ == null) {
                    this.playerInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.playerInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePlayerInfo(HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo value) {
                if (this.playerInfoBuilder_ == null) {
                    if (this.playerInfo_ != null) {
                        this.playerInfo_ = HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo.newBuilder(this.playerInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.playerInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.playerInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPlayerInfo() {
                if (this.playerInfoBuilder_ == null) {
                    this.playerInfo_ = null;
                    onChanged();
                } else {
                    this.playerInfo_ = null;
                    this.playerInfoBuilder_ = null;
                }
                return this;
            }

            public HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo.Builder getPlayerInfoBuilder() {
                onChanged();
                return getPlayerInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScoreOrBuilder
            public HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder getPlayerInfoOrBuilder() {
                if (this.playerInfoBuilder_ != null) {
                    return this.playerInfoBuilder_.getMessageOrBuilder();
                }
                return this.playerInfo_ == null ? HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo.getDefaultInstance() : this.playerInfo_;
            }

            private SingleFieldBuilderV3<HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo, HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfo.Builder, HomeGroupPlayerInfoOuterClass.HomeGroupPlayerInfoOrBuilder> getPlayerInfoFieldBuilder() {
                if (this.playerInfoBuilder_ == null) {
                    this.playerInfoBuilder_ = new SingleFieldBuilderV3<>(getPlayerInfo(), getParentForChildren(), isClean());
                    this.playerInfo_ = null;
                }
                return this.playerInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScoreOrBuilder
            public int getScore() {
                return this.score_;
            }

            public Builder setScore(int value) {
                this.score_ = value;
                onChanged();
                return this;
            }

            public Builder clearScore() {
                this.score_ = 0;
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

        public static HomeSeekFurniturePlayerScore getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeSeekFurniturePlayerScore> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeSeekFurniturePlayerScore> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeSeekFurniturePlayerScore getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeGroupPlayerInfoOuterClass.getDescriptor();
    }
}
