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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BounceConjuringChapterInfoOuterClass.class */
public final class BounceConjuringChapterInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n BounceConjuringChapterInfo.proto\"W\n\u001aBounceConjuringChapterInfo\u0012\u0012\n\nbest_score\u0018\u0003 \u0001(\r\u0012\u0011\n\topen_time\u0018\u0002 \u0001(\r\u0012\u0012\n\nchapter_id\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BounceConjuringChapterInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BounceConjuringChapterInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BounceConjuringChapterInfo_descriptor, new String[]{"BestScore", "OpenTime", "ChapterId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BounceConjuringChapterInfoOuterClass$BounceConjuringChapterInfoOrBuilder.class */
    public interface BounceConjuringChapterInfoOrBuilder extends MessageOrBuilder {
        int getBestScore();

        int getOpenTime();

        int getChapterId();
    }

    private BounceConjuringChapterInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BounceConjuringChapterInfoOuterClass$BounceConjuringChapterInfo.class */
    public static final class BounceConjuringChapterInfo extends GeneratedMessageV3 implements BounceConjuringChapterInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BEST_SCORE_FIELD_NUMBER = 3;
        private int bestScore_;
        public static final int OPEN_TIME_FIELD_NUMBER = 2;
        private int openTime_;
        public static final int CHAPTER_ID_FIELD_NUMBER = 11;
        private int chapterId_;
        private byte memoizedIsInitialized;
        private static final BounceConjuringChapterInfo DEFAULT_INSTANCE = new BounceConjuringChapterInfo();
        private static final Parser<BounceConjuringChapterInfo> PARSER = new AbstractParser<BounceConjuringChapterInfo>() { // from class: emu.grasscutter.net.proto.BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo.1
            @Override // com.google.protobuf.Parser
            public BounceConjuringChapterInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BounceConjuringChapterInfo(input, extensionRegistry);
            }
        };

        private BounceConjuringChapterInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BounceConjuringChapterInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BounceConjuringChapterInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BounceConjuringChapterInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    this.openTime_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.bestScore_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.chapterId_ = input.readUInt32();
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
            return BounceConjuringChapterInfoOuterClass.internal_static_BounceConjuringChapterInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BounceConjuringChapterInfoOuterClass.internal_static_BounceConjuringChapterInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BounceConjuringChapterInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfoOrBuilder
        public int getBestScore() {
            return this.bestScore_;
        }

        @Override // emu.grasscutter.net.proto.BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfoOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfoOrBuilder
        public int getChapterId() {
            return this.chapterId_;
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
            if (this.openTime_ != 0) {
                output.writeUInt32(2, this.openTime_);
            }
            if (this.bestScore_ != 0) {
                output.writeUInt32(3, this.bestScore_);
            }
            if (this.chapterId_ != 0) {
                output.writeUInt32(11, this.chapterId_);
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
            if (this.openTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.openTime_);
            }
            if (this.bestScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.bestScore_);
            }
            if (this.chapterId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.chapterId_);
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
            if (!(obj instanceof BounceConjuringChapterInfo)) {
                return equals(obj);
            }
            BounceConjuringChapterInfo other = (BounceConjuringChapterInfo) obj;
            return getBestScore() == other.getBestScore() && getOpenTime() == other.getOpenTime() && getChapterId() == other.getChapterId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getBestScore())) + 2)) + getOpenTime())) + 11)) + getChapterId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static BounceConjuringChapterInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BounceConjuringChapterInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BounceConjuringChapterInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BounceConjuringChapterInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BounceConjuringChapterInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BounceConjuringChapterInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BounceConjuringChapterInfo parseFrom(InputStream input) throws IOException {
            return (BounceConjuringChapterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BounceConjuringChapterInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BounceConjuringChapterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BounceConjuringChapterInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BounceConjuringChapterInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BounceConjuringChapterInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BounceConjuringChapterInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BounceConjuringChapterInfo parseFrom(CodedInputStream input) throws IOException {
            return (BounceConjuringChapterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BounceConjuringChapterInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BounceConjuringChapterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BounceConjuringChapterInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BounceConjuringChapterInfoOuterClass$BounceConjuringChapterInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BounceConjuringChapterInfoOrBuilder {
            private int bestScore_;
            private int openTime_;
            private int chapterId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BounceConjuringChapterInfoOuterClass.internal_static_BounceConjuringChapterInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BounceConjuringChapterInfoOuterClass.internal_static_BounceConjuringChapterInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BounceConjuringChapterInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BounceConjuringChapterInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.bestScore_ = 0;
                this.openTime_ = 0;
                this.chapterId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BounceConjuringChapterInfoOuterClass.internal_static_BounceConjuringChapterInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BounceConjuringChapterInfo getDefaultInstanceForType() {
                return BounceConjuringChapterInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BounceConjuringChapterInfo build() {
                BounceConjuringChapterInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BounceConjuringChapterInfo buildPartial() {
                BounceConjuringChapterInfo result = new BounceConjuringChapterInfo(this);
                result.bestScore_ = this.bestScore_;
                result.openTime_ = this.openTime_;
                result.chapterId_ = this.chapterId_;
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
                if (other instanceof BounceConjuringChapterInfo) {
                    return mergeFrom((BounceConjuringChapterInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BounceConjuringChapterInfo other) {
                if (other == BounceConjuringChapterInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getBestScore() != 0) {
                    setBestScore(other.getBestScore());
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.getChapterId() != 0) {
                    setChapterId(other.getChapterId());
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
                BounceConjuringChapterInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BounceConjuringChapterInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BounceConjuringChapterInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfoOrBuilder
            public int getOpenTime() {
                return this.openTime_;
            }

            public Builder setOpenTime(int value) {
                this.openTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearOpenTime() {
                this.openTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfoOrBuilder
            public int getChapterId() {
                return this.chapterId_;
            }

            public Builder setChapterId(int value) {
                this.chapterId_ = value;
                onChanged();
                return this;
            }

            public Builder clearChapterId() {
                this.chapterId_ = 0;
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

        public static BounceConjuringChapterInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BounceConjuringChapterInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BounceConjuringChapterInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BounceConjuringChapterInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
