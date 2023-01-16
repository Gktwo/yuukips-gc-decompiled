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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabLoopDungeonResultInfoOuterClass.class */
public final class ChannelerSlabLoopDungeonResultInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n(ChannelerSlabLoopDungeonResultInfo.proto\"\u0001\n\"ChannelerSlabLoopDungeonResultInfo\u0012\u0015\n\rdungeon_index\u0018\u0007 \u0001(\r\u0012\u0017\n\u000fchallenge_score\u0018\u0005 \u0001(\r\u0012\u0018\n\u0010is_in_time_limit\u0018\b \u0001(\b\u0012\u0012\n\nis_success\u0018\f \u0001(\b\u0012\u001b\n\u0013challenge_max_score\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChannelerSlabLoopDungeonResultInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_ChannelerSlabLoopDungeonResultInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f675x76a02be6 = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChannelerSlabLoopDungeonResultInfo_descriptor, new String[]{"DungeonIndex", "ChallengeScore", "IsInTimeLimit", "IsSuccess", "ChallengeMaxScore"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabLoopDungeonResultInfoOuterClass$ChannelerSlabLoopDungeonResultInfoOrBuilder.class */
    public interface ChannelerSlabLoopDungeonResultInfoOrBuilder extends MessageOrBuilder {
        int getDungeonIndex();

        int getChallengeScore();

        boolean getIsInTimeLimit();

        boolean getIsSuccess();

        int getChallengeMaxScore();
    }

    private ChannelerSlabLoopDungeonResultInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabLoopDungeonResultInfoOuterClass$ChannelerSlabLoopDungeonResultInfo.class */
    public static final class ChannelerSlabLoopDungeonResultInfo extends GeneratedMessageV3 implements ChannelerSlabLoopDungeonResultInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DUNGEON_INDEX_FIELD_NUMBER = 7;
        private int dungeonIndex_;
        public static final int CHALLENGE_SCORE_FIELD_NUMBER = 5;
        private int challengeScore_;
        public static final int IS_IN_TIME_LIMIT_FIELD_NUMBER = 8;
        private boolean isInTimeLimit_;
        public static final int IS_SUCCESS_FIELD_NUMBER = 12;
        private boolean isSuccess_;
        public static final int CHALLENGE_MAX_SCORE_FIELD_NUMBER = 13;
        private int challengeMaxScore_;
        private byte memoizedIsInitialized;
        private static final ChannelerSlabLoopDungeonResultInfo DEFAULT_INSTANCE = new ChannelerSlabLoopDungeonResultInfo();
        private static final Parser<ChannelerSlabLoopDungeonResultInfo> PARSER = new AbstractParser<ChannelerSlabLoopDungeonResultInfo>() { // from class: emu.grasscutter.net.proto.ChannelerSlabLoopDungeonResultInfoOuterClass.ChannelerSlabLoopDungeonResultInfo.1
            @Override // com.google.protobuf.Parser
            public ChannelerSlabLoopDungeonResultInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChannelerSlabLoopDungeonResultInfo(input, extensionRegistry);
            }
        };

        private ChannelerSlabLoopDungeonResultInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ChannelerSlabLoopDungeonResultInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChannelerSlabLoopDungeonResultInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChannelerSlabLoopDungeonResultInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.challengeScore_ = input.readUInt32();
                                break;
                            case 56:
                                this.dungeonIndex_ = input.readUInt32();
                                break;
                            case 64:
                                this.isInTimeLimit_ = input.readBool();
                                break;
                            case 96:
                                this.isSuccess_ = input.readBool();
                                break;
                            case 104:
                                this.challengeMaxScore_ = input.readUInt32();
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
            return ChannelerSlabLoopDungeonResultInfoOuterClass.internal_static_ChannelerSlabLoopDungeonResultInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChannelerSlabLoopDungeonResultInfoOuterClass.f675x76a02be6.ensureFieldAccessorsInitialized(ChannelerSlabLoopDungeonResultInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonResultInfoOuterClass.ChannelerSlabLoopDungeonResultInfoOrBuilder
        public int getDungeonIndex() {
            return this.dungeonIndex_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonResultInfoOuterClass.ChannelerSlabLoopDungeonResultInfoOrBuilder
        public int getChallengeScore() {
            return this.challengeScore_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonResultInfoOuterClass.ChannelerSlabLoopDungeonResultInfoOrBuilder
        public boolean getIsInTimeLimit() {
            return this.isInTimeLimit_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonResultInfoOuterClass.ChannelerSlabLoopDungeonResultInfoOrBuilder
        public boolean getIsSuccess() {
            return this.isSuccess_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonResultInfoOuterClass.ChannelerSlabLoopDungeonResultInfoOrBuilder
        public int getChallengeMaxScore() {
            return this.challengeMaxScore_;
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
            if (this.challengeScore_ != 0) {
                output.writeUInt32(5, this.challengeScore_);
            }
            if (this.dungeonIndex_ != 0) {
                output.writeUInt32(7, this.dungeonIndex_);
            }
            if (this.isInTimeLimit_) {
                output.writeBool(8, this.isInTimeLimit_);
            }
            if (this.isSuccess_) {
                output.writeBool(12, this.isSuccess_);
            }
            if (this.challengeMaxScore_ != 0) {
                output.writeUInt32(13, this.challengeMaxScore_);
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
            if (this.challengeScore_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.challengeScore_);
            }
            if (this.dungeonIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.dungeonIndex_);
            }
            if (this.isInTimeLimit_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isInTimeLimit_);
            }
            if (this.isSuccess_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isSuccess_);
            }
            if (this.challengeMaxScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.challengeMaxScore_);
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
            if (!(obj instanceof ChannelerSlabLoopDungeonResultInfo)) {
                return equals(obj);
            }
            ChannelerSlabLoopDungeonResultInfo other = (ChannelerSlabLoopDungeonResultInfo) obj;
            return getDungeonIndex() == other.getDungeonIndex() && getChallengeScore() == other.getChallengeScore() && getIsInTimeLimit() == other.getIsInTimeLimit() && getIsSuccess() == other.getIsSuccess() && getChallengeMaxScore() == other.getChallengeMaxScore() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getDungeonIndex())) + 5)) + getChallengeScore())) + 8)) + Internal.hashBoolean(getIsInTimeLimit()))) + 12)) + Internal.hashBoolean(getIsSuccess()))) + 13)) + getChallengeMaxScore())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ChannelerSlabLoopDungeonResultInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabLoopDungeonResultInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabLoopDungeonResultInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabLoopDungeonResultInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabLoopDungeonResultInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabLoopDungeonResultInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabLoopDungeonResultInfo parseFrom(InputStream input) throws IOException {
            return (ChannelerSlabLoopDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannelerSlabLoopDungeonResultInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabLoopDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannelerSlabLoopDungeonResultInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ChannelerSlabLoopDungeonResultInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChannelerSlabLoopDungeonResultInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabLoopDungeonResultInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannelerSlabLoopDungeonResultInfo parseFrom(CodedInputStream input) throws IOException {
            return (ChannelerSlabLoopDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannelerSlabLoopDungeonResultInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabLoopDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChannelerSlabLoopDungeonResultInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabLoopDungeonResultInfoOuterClass$ChannelerSlabLoopDungeonResultInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChannelerSlabLoopDungeonResultInfoOrBuilder {
            private int dungeonIndex_;
            private int challengeScore_;
            private boolean isInTimeLimit_;
            private boolean isSuccess_;
            private int challengeMaxScore_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChannelerSlabLoopDungeonResultInfoOuterClass.internal_static_ChannelerSlabLoopDungeonResultInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChannelerSlabLoopDungeonResultInfoOuterClass.f675x76a02be6.ensureFieldAccessorsInitialized(ChannelerSlabLoopDungeonResultInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChannelerSlabLoopDungeonResultInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.dungeonIndex_ = 0;
                this.challengeScore_ = 0;
                this.isInTimeLimit_ = false;
                this.isSuccess_ = false;
                this.challengeMaxScore_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChannelerSlabLoopDungeonResultInfoOuterClass.internal_static_ChannelerSlabLoopDungeonResultInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChannelerSlabLoopDungeonResultInfo getDefaultInstanceForType() {
                return ChannelerSlabLoopDungeonResultInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannelerSlabLoopDungeonResultInfo build() {
                ChannelerSlabLoopDungeonResultInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannelerSlabLoopDungeonResultInfo buildPartial() {
                ChannelerSlabLoopDungeonResultInfo result = new ChannelerSlabLoopDungeonResultInfo(this);
                result.dungeonIndex_ = this.dungeonIndex_;
                result.challengeScore_ = this.challengeScore_;
                result.isInTimeLimit_ = this.isInTimeLimit_;
                result.isSuccess_ = this.isSuccess_;
                result.challengeMaxScore_ = this.challengeMaxScore_;
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
                if (other instanceof ChannelerSlabLoopDungeonResultInfo) {
                    return mergeFrom((ChannelerSlabLoopDungeonResultInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChannelerSlabLoopDungeonResultInfo other) {
                if (other == ChannelerSlabLoopDungeonResultInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getDungeonIndex() != 0) {
                    setDungeonIndex(other.getDungeonIndex());
                }
                if (other.getChallengeScore() != 0) {
                    setChallengeScore(other.getChallengeScore());
                }
                if (other.getIsInTimeLimit()) {
                    setIsInTimeLimit(other.getIsInTimeLimit());
                }
                if (other.getIsSuccess()) {
                    setIsSuccess(other.getIsSuccess());
                }
                if (other.getChallengeMaxScore() != 0) {
                    setChallengeMaxScore(other.getChallengeMaxScore());
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
                ChannelerSlabLoopDungeonResultInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChannelerSlabLoopDungeonResultInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChannelerSlabLoopDungeonResultInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonResultInfoOuterClass.ChannelerSlabLoopDungeonResultInfoOrBuilder
            public int getDungeonIndex() {
                return this.dungeonIndex_;
            }

            public Builder setDungeonIndex(int value) {
                this.dungeonIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearDungeonIndex() {
                this.dungeonIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonResultInfoOuterClass.ChannelerSlabLoopDungeonResultInfoOrBuilder
            public int getChallengeScore() {
                return this.challengeScore_;
            }

            public Builder setChallengeScore(int value) {
                this.challengeScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearChallengeScore() {
                this.challengeScore_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonResultInfoOuterClass.ChannelerSlabLoopDungeonResultInfoOrBuilder
            public boolean getIsInTimeLimit() {
                return this.isInTimeLimit_;
            }

            public Builder setIsInTimeLimit(boolean value) {
                this.isInTimeLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsInTimeLimit() {
                this.isInTimeLimit_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonResultInfoOuterClass.ChannelerSlabLoopDungeonResultInfoOrBuilder
            public boolean getIsSuccess() {
                return this.isSuccess_;
            }

            public Builder setIsSuccess(boolean value) {
                this.isSuccess_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsSuccess() {
                this.isSuccess_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonResultInfoOuterClass.ChannelerSlabLoopDungeonResultInfoOrBuilder
            public int getChallengeMaxScore() {
                return this.challengeMaxScore_;
            }

            public Builder setChallengeMaxScore(int value) {
                this.challengeMaxScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearChallengeMaxScore() {
                this.challengeMaxScore_ = 0;
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

        public static ChannelerSlabLoopDungeonResultInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChannelerSlabLoopDungeonResultInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChannelerSlabLoopDungeonResultInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChannelerSlabLoopDungeonResultInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
