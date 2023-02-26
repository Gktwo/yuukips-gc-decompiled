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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternRiteFireworksChallengeInfoOuterClass.class */
public final class LanternRiteFireworksChallengeInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n'LanternRiteFireworksChallengeInfo.proto\"`\n!LanternRiteFireworksChallengeInfo\u0012\u0013\n\u000bisFullScore\u0018\u000b \u0001(\b\u0012\u0011\n\tbestScore\u0018\u000e \u0001(\r\u0012\u0013\n\u000bchallengeId\u0018\u000f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_LanternRiteFireworksChallengeInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_LanternRiteFireworksChallengeInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f755x97ccfe48 = new GeneratedMessageV3.FieldAccessorTable(internal_static_LanternRiteFireworksChallengeInfo_descriptor, new String[]{"IsFullScore", "BestScore", "ChallengeId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternRiteFireworksChallengeInfoOuterClass$LanternRiteFireworksChallengeInfoOrBuilder.class */
    public interface LanternRiteFireworksChallengeInfoOrBuilder extends MessageOrBuilder {
        boolean getIsFullScore();

        int getBestScore();

        int getChallengeId();
    }

    private LanternRiteFireworksChallengeInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternRiteFireworksChallengeInfoOuterClass$LanternRiteFireworksChallengeInfo.class */
    public static final class LanternRiteFireworksChallengeInfo extends GeneratedMessageV3 implements LanternRiteFireworksChallengeInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISFULLSCORE_FIELD_NUMBER = 11;
        private boolean isFullScore_;
        public static final int BESTSCORE_FIELD_NUMBER = 14;
        private int bestScore_;
        public static final int CHALLENGEID_FIELD_NUMBER = 15;
        private int challengeId_;
        private byte memoizedIsInitialized;
        private static final LanternRiteFireworksChallengeInfo DEFAULT_INSTANCE = new LanternRiteFireworksChallengeInfo();
        private static final Parser<LanternRiteFireworksChallengeInfo> PARSER = new AbstractParser<LanternRiteFireworksChallengeInfo>() { // from class: emu.grasscutter.net.proto.LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfo.1
            @Override // com.google.protobuf.Parser
            public LanternRiteFireworksChallengeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LanternRiteFireworksChallengeInfo(input, extensionRegistry);
            }
        };

        private LanternRiteFireworksChallengeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private LanternRiteFireworksChallengeInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new LanternRiteFireworksChallengeInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LanternRiteFireworksChallengeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 88:
                                    this.isFullScore_ = input.readBool();
                                    break;
                                case 112:
                                    this.bestScore_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.challengeId_ = input.readUInt32();
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
            return LanternRiteFireworksChallengeInfoOuterClass.internal_static_LanternRiteFireworksChallengeInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LanternRiteFireworksChallengeInfoOuterClass.f755x97ccfe48.ensureFieldAccessorsInitialized(LanternRiteFireworksChallengeInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfoOrBuilder
        public boolean getIsFullScore() {
            return this.isFullScore_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfoOrBuilder
        public int getBestScore() {
            return this.bestScore_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfoOrBuilder
        public int getChallengeId() {
            return this.challengeId_;
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
            if (this.isFullScore_) {
                output.writeBool(11, this.isFullScore_);
            }
            if (this.bestScore_ != 0) {
                output.writeUInt32(14, this.bestScore_);
            }
            if (this.challengeId_ != 0) {
                output.writeUInt32(15, this.challengeId_);
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
            if (this.isFullScore_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(11, this.isFullScore_);
            }
            if (this.bestScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.bestScore_);
            }
            if (this.challengeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.challengeId_);
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
            if (!(obj instanceof LanternRiteFireworksChallengeInfo)) {
                return equals(obj);
            }
            LanternRiteFireworksChallengeInfo other = (LanternRiteFireworksChallengeInfo) obj;
            return getIsFullScore() == other.getIsFullScore() && getBestScore() == other.getBestScore() && getChallengeId() == other.getChallengeId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + Internal.hashBoolean(getIsFullScore()))) + 14)) + getBestScore())) + 15)) + getChallengeId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static LanternRiteFireworksChallengeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternRiteFireworksChallengeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternRiteFireworksChallengeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternRiteFireworksChallengeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternRiteFireworksChallengeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternRiteFireworksChallengeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternRiteFireworksChallengeInfo parseFrom(InputStream input) throws IOException {
            return (LanternRiteFireworksChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LanternRiteFireworksChallengeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternRiteFireworksChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static LanternRiteFireworksChallengeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (LanternRiteFireworksChallengeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static LanternRiteFireworksChallengeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternRiteFireworksChallengeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static LanternRiteFireworksChallengeInfo parseFrom(CodedInputStream input) throws IOException {
            return (LanternRiteFireworksChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LanternRiteFireworksChallengeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternRiteFireworksChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LanternRiteFireworksChallengeInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternRiteFireworksChallengeInfoOuterClass$LanternRiteFireworksChallengeInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LanternRiteFireworksChallengeInfoOrBuilder {
            private boolean isFullScore_;
            private int bestScore_;
            private int challengeId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LanternRiteFireworksChallengeInfoOuterClass.internal_static_LanternRiteFireworksChallengeInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LanternRiteFireworksChallengeInfoOuterClass.f755x97ccfe48.ensureFieldAccessorsInitialized(LanternRiteFireworksChallengeInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LanternRiteFireworksChallengeInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isFullScore_ = false;
                this.bestScore_ = 0;
                this.challengeId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LanternRiteFireworksChallengeInfoOuterClass.internal_static_LanternRiteFireworksChallengeInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LanternRiteFireworksChallengeInfo getDefaultInstanceForType() {
                return LanternRiteFireworksChallengeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LanternRiteFireworksChallengeInfo build() {
                LanternRiteFireworksChallengeInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LanternRiteFireworksChallengeInfo buildPartial() {
                LanternRiteFireworksChallengeInfo result = new LanternRiteFireworksChallengeInfo(this);
                result.isFullScore_ = this.isFullScore_;
                result.bestScore_ = this.bestScore_;
                result.challengeId_ = this.challengeId_;
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
                if (other instanceof LanternRiteFireworksChallengeInfo) {
                    return mergeFrom((LanternRiteFireworksChallengeInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LanternRiteFireworksChallengeInfo other) {
                if (other == LanternRiteFireworksChallengeInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsFullScore()) {
                    setIsFullScore(other.getIsFullScore());
                }
                if (other.getBestScore() != 0) {
                    setBestScore(other.getBestScore());
                }
                if (other.getChallengeId() != 0) {
                    setChallengeId(other.getChallengeId());
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
                LanternRiteFireworksChallengeInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = LanternRiteFireworksChallengeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (LanternRiteFireworksChallengeInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfoOrBuilder
            public boolean getIsFullScore() {
                return this.isFullScore_;
            }

            public Builder setIsFullScore(boolean value) {
                this.isFullScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFullScore() {
                this.isFullScore_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfoOrBuilder
            public int getBestScore() {
                return this.bestScore_;
            }

            public Builder setBestScore(int value) {
                this.bestScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearBestScore() {
                this.bestScore_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LanternRiteFireworksChallengeInfoOuterClass.LanternRiteFireworksChallengeInfoOrBuilder
            public int getChallengeId() {
                return this.challengeId_;
            }

            public Builder setChallengeId(int value) {
                this.challengeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearChallengeId() {
                this.challengeId_ = 0;
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

        public static LanternRiteFireworksChallengeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LanternRiteFireworksChallengeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LanternRiteFireworksChallengeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LanternRiteFireworksChallengeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
