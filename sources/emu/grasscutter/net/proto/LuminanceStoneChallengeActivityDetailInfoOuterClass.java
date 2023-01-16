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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LuminanceStoneChallengeActivityDetailInfoOuterClass.class */
public final class LuminanceStoneChallengeActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n/LuminanceStoneChallengeActivityDetailInfo.proto\"\u0001\n)LuminanceStoneChallengeActivityDetailInfo\u0012\u0019\n\u0011is_content_closed\u0018\u0001 \u0001(\b\u0012\u0018\n\u0010current_stage_id\u0018\u0002 \u0001(\r\u0012!\n\u0019is_final_gallery_complete\u0018\u0007 \u0001(\b\u0012\u0012\n\nbest_score\u0018\u0006 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* renamed from: internal_static_LuminanceStoneChallengeActivityDetailInfo_descriptor */
    private static final Descriptors.Descriptor f773x70839119 = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_LuminanceStoneChallengeActivityDetailInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f774x9e808e97 = new GeneratedMessageV3.FieldAccessorTable(f773x70839119, new String[]{"IsContentClosed", "CurrentStageId", "IsFinalGalleryComplete", "BestScore"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LuminanceStoneChallengeActivityDetailInfoOuterClass$LuminanceStoneChallengeActivityDetailInfoOrBuilder.class */
    public interface LuminanceStoneChallengeActivityDetailInfoOrBuilder extends MessageOrBuilder {
        boolean getIsContentClosed();

        int getCurrentStageId();

        boolean getIsFinalGalleryComplete();

        int getBestScore();
    }

    private LuminanceStoneChallengeActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LuminanceStoneChallengeActivityDetailInfoOuterClass$LuminanceStoneChallengeActivityDetailInfo.class */
    public static final class LuminanceStoneChallengeActivityDetailInfo extends GeneratedMessageV3 implements LuminanceStoneChallengeActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 1;
        private boolean isContentClosed_;
        public static final int CURRENT_STAGE_ID_FIELD_NUMBER = 2;
        private int currentStageId_;
        public static final int IS_FINAL_GALLERY_COMPLETE_FIELD_NUMBER = 7;
        private boolean isFinalGalleryComplete_;
        public static final int BEST_SCORE_FIELD_NUMBER = 6;
        private int bestScore_;
        private byte memoizedIsInitialized;
        private static final LuminanceStoneChallengeActivityDetailInfo DEFAULT_INSTANCE = new LuminanceStoneChallengeActivityDetailInfo();
        private static final Parser<LuminanceStoneChallengeActivityDetailInfo> PARSER = new AbstractParser<LuminanceStoneChallengeActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public LuminanceStoneChallengeActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LuminanceStoneChallengeActivityDetailInfo(input, extensionRegistry);
            }
        };

        private LuminanceStoneChallengeActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private LuminanceStoneChallengeActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new LuminanceStoneChallengeActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LuminanceStoneChallengeActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.isContentClosed_ = input.readBool();
                                    break;
                                case 16:
                                    this.currentStageId_ = input.readUInt32();
                                    break;
                                case 48:
                                    this.bestScore_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.isFinalGalleryComplete_ = input.readBool();
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
            return LuminanceStoneChallengeActivityDetailInfoOuterClass.f773x70839119;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LuminanceStoneChallengeActivityDetailInfoOuterClass.f774x9e808e97.ensureFieldAccessorsInitialized(LuminanceStoneChallengeActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        @Override // emu.grasscutter.net.proto.LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfoOrBuilder
        public int getCurrentStageId() {
            return this.currentStageId_;
        }

        @Override // emu.grasscutter.net.proto.LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfoOrBuilder
        public boolean getIsFinalGalleryComplete() {
            return this.isFinalGalleryComplete_;
        }

        @Override // emu.grasscutter.net.proto.LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfoOrBuilder
        public int getBestScore() {
            return this.bestScore_;
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
            if (this.isContentClosed_) {
                output.writeBool(1, this.isContentClosed_);
            }
            if (this.currentStageId_ != 0) {
                output.writeUInt32(2, this.currentStageId_);
            }
            if (this.bestScore_ != 0) {
                output.writeUInt32(6, this.bestScore_);
            }
            if (this.isFinalGalleryComplete_) {
                output.writeBool(7, this.isFinalGalleryComplete_);
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
            if (this.isContentClosed_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isContentClosed_);
            }
            if (this.currentStageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.currentStageId_);
            }
            if (this.bestScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.bestScore_);
            }
            if (this.isFinalGalleryComplete_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.isFinalGalleryComplete_);
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
            if (!(obj instanceof LuminanceStoneChallengeActivityDetailInfo)) {
                return equals(obj);
            }
            LuminanceStoneChallengeActivityDetailInfo other = (LuminanceStoneChallengeActivityDetailInfo) obj;
            return getIsContentClosed() == other.getIsContentClosed() && getCurrentStageId() == other.getCurrentStageId() && getIsFinalGalleryComplete() == other.getIsFinalGalleryComplete() && getBestScore() == other.getBestScore() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Internal.hashBoolean(getIsContentClosed()))) + 2)) + getCurrentStageId())) + 7)) + Internal.hashBoolean(getIsFinalGalleryComplete()))) + 6)) + getBestScore())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static LuminanceStoneChallengeActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LuminanceStoneChallengeActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LuminanceStoneChallengeActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LuminanceStoneChallengeActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LuminanceStoneChallengeActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LuminanceStoneChallengeActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LuminanceStoneChallengeActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (LuminanceStoneChallengeActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LuminanceStoneChallengeActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LuminanceStoneChallengeActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static LuminanceStoneChallengeActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (LuminanceStoneChallengeActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static LuminanceStoneChallengeActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LuminanceStoneChallengeActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static LuminanceStoneChallengeActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (LuminanceStoneChallengeActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LuminanceStoneChallengeActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LuminanceStoneChallengeActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LuminanceStoneChallengeActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LuminanceStoneChallengeActivityDetailInfoOuterClass$LuminanceStoneChallengeActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LuminanceStoneChallengeActivityDetailInfoOrBuilder {
            private boolean isContentClosed_;
            private int currentStageId_;
            private boolean isFinalGalleryComplete_;
            private int bestScore_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LuminanceStoneChallengeActivityDetailInfoOuterClass.f773x70839119;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LuminanceStoneChallengeActivityDetailInfoOuterClass.f774x9e808e97.ensureFieldAccessorsInitialized(LuminanceStoneChallengeActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LuminanceStoneChallengeActivityDetailInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isContentClosed_ = false;
                this.currentStageId_ = 0;
                this.isFinalGalleryComplete_ = false;
                this.bestScore_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LuminanceStoneChallengeActivityDetailInfoOuterClass.f773x70839119;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LuminanceStoneChallengeActivityDetailInfo getDefaultInstanceForType() {
                return LuminanceStoneChallengeActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LuminanceStoneChallengeActivityDetailInfo build() {
                LuminanceStoneChallengeActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LuminanceStoneChallengeActivityDetailInfo buildPartial() {
                LuminanceStoneChallengeActivityDetailInfo result = new LuminanceStoneChallengeActivityDetailInfo(this);
                result.isContentClosed_ = this.isContentClosed_;
                result.currentStageId_ = this.currentStageId_;
                result.isFinalGalleryComplete_ = this.isFinalGalleryComplete_;
                result.bestScore_ = this.bestScore_;
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
                if (other instanceof LuminanceStoneChallengeActivityDetailInfo) {
                    return mergeFrom((LuminanceStoneChallengeActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LuminanceStoneChallengeActivityDetailInfo other) {
                if (other == LuminanceStoneChallengeActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                if (other.getCurrentStageId() != 0) {
                    setCurrentStageId(other.getCurrentStageId());
                }
                if (other.getIsFinalGalleryComplete()) {
                    setIsFinalGalleryComplete(other.getIsFinalGalleryComplete());
                }
                if (other.getBestScore() != 0) {
                    setBestScore(other.getBestScore());
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
                LuminanceStoneChallengeActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = LuminanceStoneChallengeActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (LuminanceStoneChallengeActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfoOrBuilder
            public boolean getIsContentClosed() {
                return this.isContentClosed_;
            }

            public Builder setIsContentClosed(boolean value) {
                this.isContentClosed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsContentClosed() {
                this.isContentClosed_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfoOrBuilder
            public int getCurrentStageId() {
                return this.currentStageId_;
            }

            public Builder setCurrentStageId(int value) {
                this.currentStageId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurrentStageId() {
                this.currentStageId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfoOrBuilder
            public boolean getIsFinalGalleryComplete() {
                return this.isFinalGalleryComplete_;
            }

            public Builder setIsFinalGalleryComplete(boolean value) {
                this.isFinalGalleryComplete_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinalGalleryComplete() {
                this.isFinalGalleryComplete_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static LuminanceStoneChallengeActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LuminanceStoneChallengeActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LuminanceStoneChallengeActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LuminanceStoneChallengeActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
