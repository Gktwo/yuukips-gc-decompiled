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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannellerSlabLoopDungeonResultInfoOuterClass.class */
public final class ChannellerSlabLoopDungeonResultInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n)ChannellerSlabLoopDungeonResultInfo.proto\"\u0001\n#ChannellerSlabLoopDungeonResultInfo\u0012\u0019\n\u0011challengeMaxScore\u0018\u0005 \u0001(\r\u0012\u0011\n\tisSuccess\u0018\r \u0001(\b\u0012\u0015\n\risInTimeLimit\u0018\u0006 \u0001(\b\u0012\u0016\n\u000echallengeScore\u0018\u0001 \u0001(\r\u0012\u0014\n\fdungeonIndex\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChannellerSlabLoopDungeonResultInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_ChannellerSlabLoopDungeonResultInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f672xd7a86c2a = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChannellerSlabLoopDungeonResultInfo_descriptor, new String[]{"ChallengeMaxScore", "IsSuccess", "IsInTimeLimit", "ChallengeScore", "DungeonIndex"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannellerSlabLoopDungeonResultInfoOuterClass$ChannellerSlabLoopDungeonResultInfoOrBuilder.class */
    public interface ChannellerSlabLoopDungeonResultInfoOrBuilder extends MessageOrBuilder {
        int getChallengeMaxScore();

        boolean getIsSuccess();

        boolean getIsInTimeLimit();

        int getChallengeScore();

        int getDungeonIndex();
    }

    private ChannellerSlabLoopDungeonResultInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannellerSlabLoopDungeonResultInfoOuterClass$ChannellerSlabLoopDungeonResultInfo.class */
    public static final class ChannellerSlabLoopDungeonResultInfo extends GeneratedMessageV3 implements ChannellerSlabLoopDungeonResultInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHALLENGEMAXSCORE_FIELD_NUMBER = 5;
        private int challengeMaxScore_;
        public static final int ISSUCCESS_FIELD_NUMBER = 13;
        private boolean isSuccess_;
        public static final int ISINTIMELIMIT_FIELD_NUMBER = 6;
        private boolean isInTimeLimit_;
        public static final int CHALLENGESCORE_FIELD_NUMBER = 1;
        private int challengeScore_;
        public static final int DUNGEONINDEX_FIELD_NUMBER = 3;
        private int dungeonIndex_;
        private byte memoizedIsInitialized;
        private static final ChannellerSlabLoopDungeonResultInfo DEFAULT_INSTANCE = new ChannellerSlabLoopDungeonResultInfo();
        private static final Parser<ChannellerSlabLoopDungeonResultInfo> PARSER = new AbstractParser<ChannellerSlabLoopDungeonResultInfo>() { // from class: emu.grasscutter.net.proto.ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.1
            @Override // com.google.protobuf.Parser
            public ChannellerSlabLoopDungeonResultInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChannellerSlabLoopDungeonResultInfo(input, extensionRegistry);
            }
        };

        private ChannellerSlabLoopDungeonResultInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ChannellerSlabLoopDungeonResultInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChannellerSlabLoopDungeonResultInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChannellerSlabLoopDungeonResultInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.challengeScore_ = input.readUInt32();
                                break;
                            case 24:
                                this.dungeonIndex_ = input.readUInt32();
                                break;
                            case 40:
                                this.challengeMaxScore_ = input.readUInt32();
                                break;
                            case 48:
                                this.isInTimeLimit_ = input.readBool();
                                break;
                            case 104:
                                this.isSuccess_ = input.readBool();
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
            return ChannellerSlabLoopDungeonResultInfoOuterClass.internal_static_ChannellerSlabLoopDungeonResultInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChannellerSlabLoopDungeonResultInfoOuterClass.f672xd7a86c2a.ensureFieldAccessorsInitialized(ChannellerSlabLoopDungeonResultInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder
        public int getChallengeMaxScore() {
            return this.challengeMaxScore_;
        }

        @Override // emu.grasscutter.net.proto.ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder
        public boolean getIsSuccess() {
            return this.isSuccess_;
        }

        @Override // emu.grasscutter.net.proto.ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder
        public boolean getIsInTimeLimit() {
            return this.isInTimeLimit_;
        }

        @Override // emu.grasscutter.net.proto.ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder
        public int getChallengeScore() {
            return this.challengeScore_;
        }

        @Override // emu.grasscutter.net.proto.ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder
        public int getDungeonIndex() {
            return this.dungeonIndex_;
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
                output.writeUInt32(1, this.challengeScore_);
            }
            if (this.dungeonIndex_ != 0) {
                output.writeUInt32(3, this.dungeonIndex_);
            }
            if (this.challengeMaxScore_ != 0) {
                output.writeUInt32(5, this.challengeMaxScore_);
            }
            if (this.isInTimeLimit_) {
                output.writeBool(6, this.isInTimeLimit_);
            }
            if (this.isSuccess_) {
                output.writeBool(13, this.isSuccess_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.challengeScore_);
            }
            if (this.dungeonIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.dungeonIndex_);
            }
            if (this.challengeMaxScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.challengeMaxScore_);
            }
            if (this.isInTimeLimit_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isInTimeLimit_);
            }
            if (this.isSuccess_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isSuccess_);
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
            if (!(obj instanceof ChannellerSlabLoopDungeonResultInfo)) {
                return equals(obj);
            }
            ChannellerSlabLoopDungeonResultInfo other = (ChannellerSlabLoopDungeonResultInfo) obj;
            return getChallengeMaxScore() == other.getChallengeMaxScore() && getIsSuccess() == other.getIsSuccess() && getIsInTimeLimit() == other.getIsInTimeLimit() && getChallengeScore() == other.getChallengeScore() && getDungeonIndex() == other.getDungeonIndex() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getChallengeMaxScore())) + 13)) + Internal.hashBoolean(getIsSuccess()))) + 6)) + Internal.hashBoolean(getIsInTimeLimit()))) + 1)) + getChallengeScore())) + 3)) + getDungeonIndex())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ChannellerSlabLoopDungeonResultInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannellerSlabLoopDungeonResultInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannellerSlabLoopDungeonResultInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannellerSlabLoopDungeonResultInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannellerSlabLoopDungeonResultInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannellerSlabLoopDungeonResultInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannellerSlabLoopDungeonResultInfo parseFrom(InputStream input) throws IOException {
            return (ChannellerSlabLoopDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannellerSlabLoopDungeonResultInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannellerSlabLoopDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannellerSlabLoopDungeonResultInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ChannellerSlabLoopDungeonResultInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChannellerSlabLoopDungeonResultInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannellerSlabLoopDungeonResultInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannellerSlabLoopDungeonResultInfo parseFrom(CodedInputStream input) throws IOException {
            return (ChannellerSlabLoopDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannellerSlabLoopDungeonResultInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannellerSlabLoopDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChannellerSlabLoopDungeonResultInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannellerSlabLoopDungeonResultInfoOuterClass$ChannellerSlabLoopDungeonResultInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChannellerSlabLoopDungeonResultInfoOrBuilder {
            private int challengeMaxScore_;
            private boolean isSuccess_;
            private boolean isInTimeLimit_;
            private int challengeScore_;
            private int dungeonIndex_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChannellerSlabLoopDungeonResultInfoOuterClass.internal_static_ChannellerSlabLoopDungeonResultInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChannellerSlabLoopDungeonResultInfoOuterClass.f672xd7a86c2a.ensureFieldAccessorsInitialized(ChannellerSlabLoopDungeonResultInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChannellerSlabLoopDungeonResultInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.challengeMaxScore_ = 0;
                this.isSuccess_ = false;
                this.isInTimeLimit_ = false;
                this.challengeScore_ = 0;
                this.dungeonIndex_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChannellerSlabLoopDungeonResultInfoOuterClass.internal_static_ChannellerSlabLoopDungeonResultInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChannellerSlabLoopDungeonResultInfo getDefaultInstanceForType() {
                return ChannellerSlabLoopDungeonResultInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannellerSlabLoopDungeonResultInfo build() {
                ChannellerSlabLoopDungeonResultInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannellerSlabLoopDungeonResultInfo buildPartial() {
                ChannellerSlabLoopDungeonResultInfo result = new ChannellerSlabLoopDungeonResultInfo(this);
                result.challengeMaxScore_ = this.challengeMaxScore_;
                result.isSuccess_ = this.isSuccess_;
                result.isInTimeLimit_ = this.isInTimeLimit_;
                result.challengeScore_ = this.challengeScore_;
                result.dungeonIndex_ = this.dungeonIndex_;
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
                if (other instanceof ChannellerSlabLoopDungeonResultInfo) {
                    return mergeFrom((ChannellerSlabLoopDungeonResultInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChannellerSlabLoopDungeonResultInfo other) {
                if (other == ChannellerSlabLoopDungeonResultInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getChallengeMaxScore() != 0) {
                    setChallengeMaxScore(other.getChallengeMaxScore());
                }
                if (other.getIsSuccess()) {
                    setIsSuccess(other.getIsSuccess());
                }
                if (other.getIsInTimeLimit()) {
                    setIsInTimeLimit(other.getIsInTimeLimit());
                }
                if (other.getChallengeScore() != 0) {
                    setChallengeScore(other.getChallengeScore());
                }
                if (other.getDungeonIndex() != 0) {
                    setDungeonIndex(other.getDungeonIndex());
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
                ChannellerSlabLoopDungeonResultInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChannellerSlabLoopDungeonResultInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChannellerSlabLoopDungeonResultInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static ChannellerSlabLoopDungeonResultInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChannellerSlabLoopDungeonResultInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChannellerSlabLoopDungeonResultInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChannellerSlabLoopDungeonResultInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
