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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyTaskDataNotifyOuterClass.class */
public final class DailyTaskDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019DailyTaskDataNotify.proto\"]\n\u0013DailyTaskDataNotify\u0012\u001a\n\u0012isTakenScoreReward\u0018\r \u0001(\b\u0012\u0013\n\u000bfinishedNum\u0018\u000b \u0001(\r\u0012\u0015\n\rscoreRewardId\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_DailyTaskDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DailyTaskDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DailyTaskDataNotify_descriptor, new String[]{"IsTakenScoreReward", "FinishedNum", "ScoreRewardId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyTaskDataNotifyOuterClass$DailyTaskDataNotifyOrBuilder.class */
    public interface DailyTaskDataNotifyOrBuilder extends MessageOrBuilder {
        boolean getIsTakenScoreReward();

        int getFinishedNum();

        int getScoreRewardId();
    }

    private DailyTaskDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyTaskDataNotifyOuterClass$DailyTaskDataNotify.class */
    public static final class DailyTaskDataNotify extends GeneratedMessageV3 implements DailyTaskDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISTAKENSCOREREWARD_FIELD_NUMBER = 13;
        private boolean isTakenScoreReward_;
        public static final int FINISHEDNUM_FIELD_NUMBER = 11;
        private int finishedNum_;
        public static final int SCOREREWARDID_FIELD_NUMBER = 2;
        private int scoreRewardId_;
        private byte memoizedIsInitialized;
        private static final DailyTaskDataNotify DEFAULT_INSTANCE = new DailyTaskDataNotify();
        private static final Parser<DailyTaskDataNotify> PARSER = new AbstractParser<DailyTaskDataNotify>() { // from class: emu.grasscutter.net.proto.DailyTaskDataNotifyOuterClass.DailyTaskDataNotify.1
            @Override // com.google.protobuf.Parser
            public DailyTaskDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DailyTaskDataNotify(input, extensionRegistry);
            }
        };

        private DailyTaskDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DailyTaskDataNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DailyTaskDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DailyTaskDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.scoreRewardId_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.finishedNum_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.isTakenScoreReward_ = input.readBool();
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
            return DailyTaskDataNotifyOuterClass.internal_static_DailyTaskDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DailyTaskDataNotifyOuterClass.internal_static_DailyTaskDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyTaskDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DailyTaskDataNotifyOuterClass.DailyTaskDataNotifyOrBuilder
        public boolean getIsTakenScoreReward() {
            return this.isTakenScoreReward_;
        }

        @Override // emu.grasscutter.net.proto.DailyTaskDataNotifyOuterClass.DailyTaskDataNotifyOrBuilder
        public int getFinishedNum() {
            return this.finishedNum_;
        }

        @Override // emu.grasscutter.net.proto.DailyTaskDataNotifyOuterClass.DailyTaskDataNotifyOrBuilder
        public int getScoreRewardId() {
            return this.scoreRewardId_;
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
            if (this.scoreRewardId_ != 0) {
                output.writeUInt32(2, this.scoreRewardId_);
            }
            if (this.finishedNum_ != 0) {
                output.writeUInt32(11, this.finishedNum_);
            }
            if (this.isTakenScoreReward_) {
                output.writeBool(13, this.isTakenScoreReward_);
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
            if (this.scoreRewardId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.scoreRewardId_);
            }
            if (this.finishedNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.finishedNum_);
            }
            if (this.isTakenScoreReward_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isTakenScoreReward_);
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
            if (!(obj instanceof DailyTaskDataNotify)) {
                return equals(obj);
            }
            DailyTaskDataNotify other = (DailyTaskDataNotify) obj;
            return getIsTakenScoreReward() == other.getIsTakenScoreReward() && getFinishedNum() == other.getFinishedNum() && getScoreRewardId() == other.getScoreRewardId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + Internal.hashBoolean(getIsTakenScoreReward()))) + 11)) + getFinishedNum())) + 2)) + getScoreRewardId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static DailyTaskDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DailyTaskDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyTaskDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DailyTaskDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyTaskDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DailyTaskDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyTaskDataNotify parseFrom(InputStream input) throws IOException {
            return (DailyTaskDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DailyTaskDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyTaskDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DailyTaskDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (DailyTaskDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DailyTaskDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyTaskDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DailyTaskDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (DailyTaskDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DailyTaskDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyTaskDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DailyTaskDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyTaskDataNotifyOuterClass$DailyTaskDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DailyTaskDataNotifyOrBuilder {
            private boolean isTakenScoreReward_;
            private int finishedNum_;
            private int scoreRewardId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DailyTaskDataNotifyOuterClass.internal_static_DailyTaskDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DailyTaskDataNotifyOuterClass.internal_static_DailyTaskDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyTaskDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DailyTaskDataNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isTakenScoreReward_ = false;
                this.finishedNum_ = 0;
                this.scoreRewardId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DailyTaskDataNotifyOuterClass.internal_static_DailyTaskDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DailyTaskDataNotify getDefaultInstanceForType() {
                return DailyTaskDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DailyTaskDataNotify build() {
                DailyTaskDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DailyTaskDataNotify buildPartial() {
                DailyTaskDataNotify result = new DailyTaskDataNotify(this);
                result.isTakenScoreReward_ = this.isTakenScoreReward_;
                result.finishedNum_ = this.finishedNum_;
                result.scoreRewardId_ = this.scoreRewardId_;
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
                if (other instanceof DailyTaskDataNotify) {
                    return mergeFrom((DailyTaskDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DailyTaskDataNotify other) {
                if (other == DailyTaskDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsTakenScoreReward()) {
                    setIsTakenScoreReward(other.getIsTakenScoreReward());
                }
                if (other.getFinishedNum() != 0) {
                    setFinishedNum(other.getFinishedNum());
                }
                if (other.getScoreRewardId() != 0) {
                    setScoreRewardId(other.getScoreRewardId());
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
                DailyTaskDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = DailyTaskDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DailyTaskDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DailyTaskDataNotifyOuterClass.DailyTaskDataNotifyOrBuilder
            public boolean getIsTakenScoreReward() {
                return this.isTakenScoreReward_;
            }

            public Builder setIsTakenScoreReward(boolean value) {
                this.isTakenScoreReward_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsTakenScoreReward() {
                this.isTakenScoreReward_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DailyTaskDataNotifyOuterClass.DailyTaskDataNotifyOrBuilder
            public int getFinishedNum() {
                return this.finishedNum_;
            }

            public Builder setFinishedNum(int value) {
                this.finishedNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearFinishedNum() {
                this.finishedNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DailyTaskDataNotifyOuterClass.DailyTaskDataNotifyOrBuilder
            public int getScoreRewardId() {
                return this.scoreRewardId_;
            }

            public Builder setScoreRewardId(int value) {
                this.scoreRewardId_ = value;
                onChanged();
                return this;
            }

            public Builder clearScoreRewardId() {
                this.scoreRewardId_ = 0;
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

        public static DailyTaskDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DailyTaskDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DailyTaskDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DailyTaskDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
