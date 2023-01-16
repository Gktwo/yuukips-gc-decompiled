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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChallengeBriefOuterClass.class */
public final class ChallengeBriefOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014ChallengeBrief.proto\"i\n\u000eChallengeBrief\u0012\u0017\n\u000fchallenge_index\u0018\u0005 \u0001(\r\u0012\u0014\n\fcur_progress\u0018\u000f \u0001(\r\u0012\u0012\n\nis_success\u0018\f \u0001(\b\u0012\u0014\n\fchallenge_id\u0018\u0001 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChallengeBrief_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChallengeBrief_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChallengeBrief_descriptor, new String[]{"ChallengeIndex", "CurProgress", "IsSuccess", "ChallengeId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChallengeBriefOuterClass$ChallengeBriefOrBuilder.class */
    public interface ChallengeBriefOrBuilder extends MessageOrBuilder {
        int getChallengeIndex();

        int getCurProgress();

        boolean getIsSuccess();

        int getChallengeId();
    }

    private ChallengeBriefOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChallengeBriefOuterClass$ChallengeBrief.class */
    public static final class ChallengeBrief extends GeneratedMessageV3 implements ChallengeBriefOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHALLENGE_INDEX_FIELD_NUMBER = 5;
        private int challengeIndex_;
        public static final int CUR_PROGRESS_FIELD_NUMBER = 15;
        private int curProgress_;
        public static final int IS_SUCCESS_FIELD_NUMBER = 12;
        private boolean isSuccess_;
        public static final int CHALLENGE_ID_FIELD_NUMBER = 1;
        private int challengeId_;
        private byte memoizedIsInitialized;
        private static final ChallengeBrief DEFAULT_INSTANCE = new ChallengeBrief();
        private static final Parser<ChallengeBrief> PARSER = new AbstractParser<ChallengeBrief>() { // from class: emu.grasscutter.net.proto.ChallengeBriefOuterClass.ChallengeBrief.1
            @Override // com.google.protobuf.Parser
            public ChallengeBrief parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChallengeBrief(input, extensionRegistry);
            }
        };

        private ChallengeBrief(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ChallengeBrief() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChallengeBrief();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChallengeBrief(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.challengeId_ = input.readUInt32();
                                    break;
                                case 40:
                                    this.challengeIndex_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.isSuccess_ = input.readBool();
                                    break;
                                case 120:
                                    this.curProgress_ = input.readUInt32();
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
            return ChallengeBriefOuterClass.internal_static_ChallengeBrief_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChallengeBriefOuterClass.internal_static_ChallengeBrief_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeBrief.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChallengeBriefOuterClass.ChallengeBriefOrBuilder
        public int getChallengeIndex() {
            return this.challengeIndex_;
        }

        @Override // emu.grasscutter.net.proto.ChallengeBriefOuterClass.ChallengeBriefOrBuilder
        public int getCurProgress() {
            return this.curProgress_;
        }

        @Override // emu.grasscutter.net.proto.ChallengeBriefOuterClass.ChallengeBriefOrBuilder
        public boolean getIsSuccess() {
            return this.isSuccess_;
        }

        @Override // emu.grasscutter.net.proto.ChallengeBriefOuterClass.ChallengeBriefOrBuilder
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
            if (this.challengeId_ != 0) {
                output.writeUInt32(1, this.challengeId_);
            }
            if (this.challengeIndex_ != 0) {
                output.writeUInt32(5, this.challengeIndex_);
            }
            if (this.isSuccess_) {
                output.writeBool(12, this.isSuccess_);
            }
            if (this.curProgress_ != 0) {
                output.writeUInt32(15, this.curProgress_);
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
            if (this.challengeId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.challengeId_);
            }
            if (this.challengeIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.challengeIndex_);
            }
            if (this.isSuccess_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isSuccess_);
            }
            if (this.curProgress_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.curProgress_);
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
            if (!(obj instanceof ChallengeBrief)) {
                return equals(obj);
            }
            ChallengeBrief other = (ChallengeBrief) obj;
            return getChallengeIndex() == other.getChallengeIndex() && getCurProgress() == other.getCurProgress() && getIsSuccess() == other.getIsSuccess() && getChallengeId() == other.getChallengeId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getChallengeIndex())) + 15)) + getCurProgress())) + 12)) + Internal.hashBoolean(getIsSuccess()))) + 1)) + getChallengeId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ChallengeBrief parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChallengeBrief parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChallengeBrief parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChallengeBrief parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChallengeBrief parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChallengeBrief parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChallengeBrief parseFrom(InputStream input) throws IOException {
            return (ChallengeBrief) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChallengeBrief parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChallengeBrief) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChallengeBrief parseDelimitedFrom(InputStream input) throws IOException {
            return (ChallengeBrief) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChallengeBrief parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChallengeBrief) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChallengeBrief parseFrom(CodedInputStream input) throws IOException {
            return (ChallengeBrief) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChallengeBrief parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChallengeBrief) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChallengeBrief prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChallengeBriefOuterClass$ChallengeBrief$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChallengeBriefOrBuilder {
            private int challengeIndex_;
            private int curProgress_;
            private boolean isSuccess_;
            private int challengeId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChallengeBriefOuterClass.internal_static_ChallengeBrief_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChallengeBriefOuterClass.internal_static_ChallengeBrief_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeBrief.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChallengeBrief.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.challengeIndex_ = 0;
                this.curProgress_ = 0;
                this.isSuccess_ = false;
                this.challengeId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChallengeBriefOuterClass.internal_static_ChallengeBrief_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChallengeBrief getDefaultInstanceForType() {
                return ChallengeBrief.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChallengeBrief build() {
                ChallengeBrief result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChallengeBrief buildPartial() {
                ChallengeBrief result = new ChallengeBrief(this);
                result.challengeIndex_ = this.challengeIndex_;
                result.curProgress_ = this.curProgress_;
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
                if (other instanceof ChallengeBrief) {
                    return mergeFrom((ChallengeBrief) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChallengeBrief other) {
                if (other == ChallengeBrief.getDefaultInstance()) {
                    return this;
                }
                if (other.getChallengeIndex() != 0) {
                    setChallengeIndex(other.getChallengeIndex());
                }
                if (other.getCurProgress() != 0) {
                    setCurProgress(other.getCurProgress());
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
                ChallengeBrief parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChallengeBrief.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChallengeBrief) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChallengeBriefOuterClass.ChallengeBriefOrBuilder
            public int getChallengeIndex() {
                return this.challengeIndex_;
            }

            public Builder setChallengeIndex(int value) {
                this.challengeIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearChallengeIndex() {
                this.challengeIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChallengeBriefOuterClass.ChallengeBriefOrBuilder
            public int getCurProgress() {
                return this.curProgress_;
            }

            public Builder setCurProgress(int value) {
                this.curProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurProgress() {
                this.curProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChallengeBriefOuterClass.ChallengeBriefOrBuilder
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

            @Override // emu.grasscutter.net.proto.ChallengeBriefOuterClass.ChallengeBriefOrBuilder
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

        public static ChallengeBrief getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChallengeBrief> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChallengeBrief> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChallengeBrief getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
