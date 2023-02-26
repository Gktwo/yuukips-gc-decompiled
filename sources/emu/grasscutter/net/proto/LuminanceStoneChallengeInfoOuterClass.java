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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LuminanceStoneChallengeInfoOuterClass.class */
public final class LuminanceStoneChallengeInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!LuminanceStoneChallengeInfo.proto\"~\n\u001bLuminanceStoneChallengeInfo\u0012\u001f\n\u0017killSpecialMonsterCount\u0018\u0007 \u0001(\r\u0012\r\n\u0005score\u0018\u000f \u0001(\r\u0012\u0018\n\u0010killMonsterCount\u0018\u0004 \u0001(\r\u0012\u0015\n\rcleanMudCount\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_LuminanceStoneChallengeInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_LuminanceStoneChallengeInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_LuminanceStoneChallengeInfo_descriptor, new String[]{"KillSpecialMonsterCount", "Score", "KillMonsterCount", "CleanMudCount"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LuminanceStoneChallengeInfoOuterClass$LuminanceStoneChallengeInfoOrBuilder.class */
    public interface LuminanceStoneChallengeInfoOrBuilder extends MessageOrBuilder {
        int getKillSpecialMonsterCount();

        int getScore();

        int getKillMonsterCount();

        int getCleanMudCount();
    }

    private LuminanceStoneChallengeInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LuminanceStoneChallengeInfoOuterClass$LuminanceStoneChallengeInfo.class */
    public static final class LuminanceStoneChallengeInfo extends GeneratedMessageV3 implements LuminanceStoneChallengeInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int KILLSPECIALMONSTERCOUNT_FIELD_NUMBER = 7;
        private int killSpecialMonsterCount_;
        public static final int SCORE_FIELD_NUMBER = 15;
        private int score_;
        public static final int KILLMONSTERCOUNT_FIELD_NUMBER = 4;
        private int killMonsterCount_;
        public static final int CLEANMUDCOUNT_FIELD_NUMBER = 13;
        private int cleanMudCount_;
        private byte memoizedIsInitialized;
        private static final LuminanceStoneChallengeInfo DEFAULT_INSTANCE = new LuminanceStoneChallengeInfo();
        private static final Parser<LuminanceStoneChallengeInfo> PARSER = new AbstractParser<LuminanceStoneChallengeInfo>() { // from class: emu.grasscutter.net.proto.LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo.1
            @Override // com.google.protobuf.Parser
            public LuminanceStoneChallengeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LuminanceStoneChallengeInfo(input, extensionRegistry);
            }
        };

        private LuminanceStoneChallengeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private LuminanceStoneChallengeInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new LuminanceStoneChallengeInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LuminanceStoneChallengeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.killMonsterCount_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.killSpecialMonsterCount_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.cleanMudCount_ = input.readUInt32();
                                    break;
                                case 120:
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
            return LuminanceStoneChallengeInfoOuterClass.internal_static_LuminanceStoneChallengeInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LuminanceStoneChallengeInfoOuterClass.internal_static_LuminanceStoneChallengeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LuminanceStoneChallengeInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfoOrBuilder
        public int getKillSpecialMonsterCount() {
            return this.killSpecialMonsterCount_;
        }

        @Override // emu.grasscutter.net.proto.LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfoOrBuilder
        public int getScore() {
            return this.score_;
        }

        @Override // emu.grasscutter.net.proto.LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfoOrBuilder
        public int getKillMonsterCount() {
            return this.killMonsterCount_;
        }

        @Override // emu.grasscutter.net.proto.LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfoOrBuilder
        public int getCleanMudCount() {
            return this.cleanMudCount_;
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
            if (this.killMonsterCount_ != 0) {
                output.writeUInt32(4, this.killMonsterCount_);
            }
            if (this.killSpecialMonsterCount_ != 0) {
                output.writeUInt32(7, this.killSpecialMonsterCount_);
            }
            if (this.cleanMudCount_ != 0) {
                output.writeUInt32(13, this.cleanMudCount_);
            }
            if (this.score_ != 0) {
                output.writeUInt32(15, this.score_);
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
            if (this.killMonsterCount_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.killMonsterCount_);
            }
            if (this.killSpecialMonsterCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.killSpecialMonsterCount_);
            }
            if (this.cleanMudCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.cleanMudCount_);
            }
            if (this.score_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.score_);
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
            if (!(obj instanceof LuminanceStoneChallengeInfo)) {
                return equals(obj);
            }
            LuminanceStoneChallengeInfo other = (LuminanceStoneChallengeInfo) obj;
            return getKillSpecialMonsterCount() == other.getKillSpecialMonsterCount() && getScore() == other.getScore() && getKillMonsterCount() == other.getKillMonsterCount() && getCleanMudCount() == other.getCleanMudCount() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getKillSpecialMonsterCount())) + 15)) + getScore())) + 4)) + getKillMonsterCount())) + 13)) + getCleanMudCount())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static LuminanceStoneChallengeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LuminanceStoneChallengeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LuminanceStoneChallengeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LuminanceStoneChallengeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LuminanceStoneChallengeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LuminanceStoneChallengeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LuminanceStoneChallengeInfo parseFrom(InputStream input) throws IOException {
            return (LuminanceStoneChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LuminanceStoneChallengeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LuminanceStoneChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static LuminanceStoneChallengeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (LuminanceStoneChallengeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static LuminanceStoneChallengeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LuminanceStoneChallengeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static LuminanceStoneChallengeInfo parseFrom(CodedInputStream input) throws IOException {
            return (LuminanceStoneChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LuminanceStoneChallengeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LuminanceStoneChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LuminanceStoneChallengeInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LuminanceStoneChallengeInfoOuterClass$LuminanceStoneChallengeInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LuminanceStoneChallengeInfoOrBuilder {
            private int killSpecialMonsterCount_;
            private int score_;
            private int killMonsterCount_;
            private int cleanMudCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LuminanceStoneChallengeInfoOuterClass.internal_static_LuminanceStoneChallengeInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LuminanceStoneChallengeInfoOuterClass.internal_static_LuminanceStoneChallengeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LuminanceStoneChallengeInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LuminanceStoneChallengeInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.killSpecialMonsterCount_ = 0;
                this.score_ = 0;
                this.killMonsterCount_ = 0;
                this.cleanMudCount_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LuminanceStoneChallengeInfoOuterClass.internal_static_LuminanceStoneChallengeInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LuminanceStoneChallengeInfo getDefaultInstanceForType() {
                return LuminanceStoneChallengeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LuminanceStoneChallengeInfo build() {
                LuminanceStoneChallengeInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LuminanceStoneChallengeInfo buildPartial() {
                LuminanceStoneChallengeInfo result = new LuminanceStoneChallengeInfo(this);
                result.killSpecialMonsterCount_ = this.killSpecialMonsterCount_;
                result.score_ = this.score_;
                result.killMonsterCount_ = this.killMonsterCount_;
                result.cleanMudCount_ = this.cleanMudCount_;
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
                if (other instanceof LuminanceStoneChallengeInfo) {
                    return mergeFrom((LuminanceStoneChallengeInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LuminanceStoneChallengeInfo other) {
                if (other == LuminanceStoneChallengeInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getKillSpecialMonsterCount() != 0) {
                    setKillSpecialMonsterCount(other.getKillSpecialMonsterCount());
                }
                if (other.getScore() != 0) {
                    setScore(other.getScore());
                }
                if (other.getKillMonsterCount() != 0) {
                    setKillMonsterCount(other.getKillMonsterCount());
                }
                if (other.getCleanMudCount() != 0) {
                    setCleanMudCount(other.getCleanMudCount());
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
                LuminanceStoneChallengeInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = LuminanceStoneChallengeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (LuminanceStoneChallengeInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfoOrBuilder
            public int getKillSpecialMonsterCount() {
                return this.killSpecialMonsterCount_;
            }

            public Builder setKillSpecialMonsterCount(int value) {
                this.killSpecialMonsterCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearKillSpecialMonsterCount() {
                this.killSpecialMonsterCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfoOrBuilder
            public int getKillMonsterCount() {
                return this.killMonsterCount_;
            }

            public Builder setKillMonsterCount(int value) {
                this.killMonsterCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearKillMonsterCount() {
                this.killMonsterCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfoOrBuilder
            public int getCleanMudCount() {
                return this.cleanMudCount_;
            }

            public Builder setCleanMudCount(int value) {
                this.cleanMudCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearCleanMudCount() {
                this.cleanMudCount_ = 0;
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

        public static LuminanceStoneChallengeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LuminanceStoneChallengeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LuminanceStoneChallengeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LuminanceStoneChallengeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
