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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeDungeonResultInfoOuterClass.class */
public final class EffigyChallengeDungeonResultInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n&EffigyChallengeDungeonResultInfo.proto\"\u0001\n EffigyChallengeDungeonResultInfo\u0012\u0019\n\u0011challengeMaxScore\u0018\u0006 \u0001(\r\u0012\u0015\n\risInTimeLimit\u0018\u0001 \u0001(\b\u0012\u0016\n\u000echallengeScore\u0018\u000e \u0001(\r\u0012\u0011\n\tisSuccess\u0018\u0002 \u0001(\b\u0012\u0013\n\u000bchallengeId\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_EffigyChallengeDungeonResultInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_EffigyChallengeDungeonResultInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f692x39bf6585 = new GeneratedMessageV3.FieldAccessorTable(internal_static_EffigyChallengeDungeonResultInfo_descriptor, new String[]{"ChallengeMaxScore", "IsInTimeLimit", "ChallengeScore", "IsSuccess", "ChallengeId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeDungeonResultInfoOuterClass$EffigyChallengeDungeonResultInfoOrBuilder.class */
    public interface EffigyChallengeDungeonResultInfoOrBuilder extends MessageOrBuilder {
        int getChallengeMaxScore();

        boolean getIsInTimeLimit();

        int getChallengeScore();

        boolean getIsSuccess();

        int getChallengeId();
    }

    private EffigyChallengeDungeonResultInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeDungeonResultInfoOuterClass$EffigyChallengeDungeonResultInfo.class */
    public static final class EffigyChallengeDungeonResultInfo extends GeneratedMessageV3 implements EffigyChallengeDungeonResultInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHALLENGEMAXSCORE_FIELD_NUMBER = 6;
        private int challengeMaxScore_;
        public static final int ISINTIMELIMIT_FIELD_NUMBER = 1;
        private boolean isInTimeLimit_;
        public static final int CHALLENGESCORE_FIELD_NUMBER = 14;
        private int challengeScore_;
        public static final int ISSUCCESS_FIELD_NUMBER = 2;
        private boolean isSuccess_;
        public static final int CHALLENGEID_FIELD_NUMBER = 10;
        private int challengeId_;
        private byte memoizedIsInitialized;
        private static final EffigyChallengeDungeonResultInfo DEFAULT_INSTANCE = new EffigyChallengeDungeonResultInfo();
        private static final Parser<EffigyChallengeDungeonResultInfo> PARSER = new AbstractParser<EffigyChallengeDungeonResultInfo>() { // from class: emu.grasscutter.net.proto.EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.1
            @Override // com.google.protobuf.Parser
            public EffigyChallengeDungeonResultInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EffigyChallengeDungeonResultInfo(input, extensionRegistry);
            }
        };

        private EffigyChallengeDungeonResultInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EffigyChallengeDungeonResultInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EffigyChallengeDungeonResultInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EffigyChallengeDungeonResultInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.isInTimeLimit_ = input.readBool();
                                break;
                            case 16:
                                this.isSuccess_ = input.readBool();
                                break;
                            case 48:
                                this.challengeMaxScore_ = input.readUInt32();
                                break;
                            case 80:
                                this.challengeId_ = input.readUInt32();
                                break;
                            case 112:
                                this.challengeScore_ = input.readUInt32();
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
            return EffigyChallengeDungeonResultInfoOuterClass.internal_static_EffigyChallengeDungeonResultInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EffigyChallengeDungeonResultInfoOuterClass.f692x39bf6585.ensureFieldAccessorsInitialized(EffigyChallengeDungeonResultInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder
        public int getChallengeMaxScore() {
            return this.challengeMaxScore_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder
        public boolean getIsInTimeLimit() {
            return this.isInTimeLimit_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder
        public int getChallengeScore() {
            return this.challengeScore_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder
        public boolean getIsSuccess() {
            return this.isSuccess_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder
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
            if (this.isInTimeLimit_) {
                output.writeBool(1, this.isInTimeLimit_);
            }
            if (this.isSuccess_) {
                output.writeBool(2, this.isSuccess_);
            }
            if (this.challengeMaxScore_ != 0) {
                output.writeUInt32(6, this.challengeMaxScore_);
            }
            if (this.challengeId_ != 0) {
                output.writeUInt32(10, this.challengeId_);
            }
            if (this.challengeScore_ != 0) {
                output.writeUInt32(14, this.challengeScore_);
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
            if (this.isInTimeLimit_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isInTimeLimit_);
            }
            if (this.isSuccess_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.isSuccess_);
            }
            if (this.challengeMaxScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.challengeMaxScore_);
            }
            if (this.challengeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.challengeId_);
            }
            if (this.challengeScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.challengeScore_);
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
            if (!(obj instanceof EffigyChallengeDungeonResultInfo)) {
                return equals(obj);
            }
            EffigyChallengeDungeonResultInfo other = (EffigyChallengeDungeonResultInfo) obj;
            return getChallengeMaxScore() == other.getChallengeMaxScore() && getIsInTimeLimit() == other.getIsInTimeLimit() && getChallengeScore() == other.getChallengeScore() && getIsSuccess() == other.getIsSuccess() && getChallengeId() == other.getChallengeId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getChallengeMaxScore())) + 1)) + Internal.hashBoolean(getIsInTimeLimit()))) + 14)) + getChallengeScore())) + 2)) + Internal.hashBoolean(getIsSuccess()))) + 10)) + getChallengeId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static EffigyChallengeDungeonResultInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyChallengeDungeonResultInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyChallengeDungeonResultInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyChallengeDungeonResultInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyChallengeDungeonResultInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyChallengeDungeonResultInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyChallengeDungeonResultInfo parseFrom(InputStream input) throws IOException {
            return (EffigyChallengeDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EffigyChallengeDungeonResultInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyChallengeDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EffigyChallengeDungeonResultInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (EffigyChallengeDungeonResultInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EffigyChallengeDungeonResultInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyChallengeDungeonResultInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EffigyChallengeDungeonResultInfo parseFrom(CodedInputStream input) throws IOException {
            return (EffigyChallengeDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EffigyChallengeDungeonResultInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyChallengeDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EffigyChallengeDungeonResultInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeDungeonResultInfoOuterClass$EffigyChallengeDungeonResultInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EffigyChallengeDungeonResultInfoOrBuilder {
            private int challengeMaxScore_;
            private boolean isInTimeLimit_;
            private int challengeScore_;
            private boolean isSuccess_;
            private int challengeId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EffigyChallengeDungeonResultInfoOuterClass.internal_static_EffigyChallengeDungeonResultInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EffigyChallengeDungeonResultInfoOuterClass.f692x39bf6585.ensureFieldAccessorsInitialized(EffigyChallengeDungeonResultInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EffigyChallengeDungeonResultInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.challengeMaxScore_ = 0;
                this.isInTimeLimit_ = false;
                this.challengeScore_ = 0;
                this.isSuccess_ = false;
                this.challengeId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EffigyChallengeDungeonResultInfoOuterClass.internal_static_EffigyChallengeDungeonResultInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EffigyChallengeDungeonResultInfo getDefaultInstanceForType() {
                return EffigyChallengeDungeonResultInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EffigyChallengeDungeonResultInfo build() {
                EffigyChallengeDungeonResultInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EffigyChallengeDungeonResultInfo buildPartial() {
                EffigyChallengeDungeonResultInfo result = new EffigyChallengeDungeonResultInfo(this);
                result.challengeMaxScore_ = this.challengeMaxScore_;
                result.isInTimeLimit_ = this.isInTimeLimit_;
                result.challengeScore_ = this.challengeScore_;
                result.isSuccess_ = this.isSuccess_;
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
                if (other instanceof EffigyChallengeDungeonResultInfo) {
                    return mergeFrom((EffigyChallengeDungeonResultInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EffigyChallengeDungeonResultInfo other) {
                if (other == EffigyChallengeDungeonResultInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getChallengeMaxScore() != 0) {
                    setChallengeMaxScore(other.getChallengeMaxScore());
                }
                if (other.getIsInTimeLimit()) {
                    setIsInTimeLimit(other.getIsInTimeLimit());
                }
                if (other.getChallengeScore() != 0) {
                    setChallengeScore(other.getChallengeScore());
                }
                if (other.getIsSuccess()) {
                    setIsSuccess(other.getIsSuccess());
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
                EffigyChallengeDungeonResultInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = EffigyChallengeDungeonResultInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EffigyChallengeDungeonResultInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder
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

        public static EffigyChallengeDungeonResultInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EffigyChallengeDungeonResultInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EffigyChallengeDungeonResultInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EffigyChallengeDungeonResultInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
