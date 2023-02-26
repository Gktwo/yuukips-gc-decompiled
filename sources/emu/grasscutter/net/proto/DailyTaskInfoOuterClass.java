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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyTaskInfoOuterClass.class */
public final class DailyTaskInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013DailyTaskInfo.proto\"t\n\rDailyTaskInfo\u0012\u0016\n\u000efinishProgress\u0018\t \u0001(\r\u0012\u0012\n\nisFinished\u0018\u0003 \u0001(\b\u0012\u0010\n\bprogress\u0018\u0007 \u0001(\r\u0012\u0013\n\u000bdailyTaskId\u0018\u0005 \u0001(\r\u0012\u0010\n\brewardId\u0018\u000e \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_DailyTaskInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DailyTaskInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DailyTaskInfo_descriptor, new String[]{"FinishProgress", "IsFinished", "Progress", "DailyTaskId", "RewardId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyTaskInfoOuterClass$DailyTaskInfoOrBuilder.class */
    public interface DailyTaskInfoOrBuilder extends MessageOrBuilder {
        int getFinishProgress();

        boolean getIsFinished();

        int getProgress();

        int getDailyTaskId();

        int getRewardId();
    }

    private DailyTaskInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyTaskInfoOuterClass$DailyTaskInfo.class */
    public static final class DailyTaskInfo extends GeneratedMessageV3 implements DailyTaskInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FINISHPROGRESS_FIELD_NUMBER = 9;
        private int finishProgress_;
        public static final int ISFINISHED_FIELD_NUMBER = 3;
        private boolean isFinished_;
        public static final int PROGRESS_FIELD_NUMBER = 7;
        private int progress_;
        public static final int DAILYTASKID_FIELD_NUMBER = 5;
        private int dailyTaskId_;
        public static final int REWARDID_FIELD_NUMBER = 14;
        private int rewardId_;
        private byte memoizedIsInitialized;
        private static final DailyTaskInfo DEFAULT_INSTANCE = new DailyTaskInfo();
        private static final Parser<DailyTaskInfo> PARSER = new AbstractParser<DailyTaskInfo>() { // from class: emu.grasscutter.net.proto.DailyTaskInfoOuterClass.DailyTaskInfo.1
            @Override // com.google.protobuf.Parser
            public DailyTaskInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DailyTaskInfo(input, extensionRegistry);
            }
        };

        private DailyTaskInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DailyTaskInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DailyTaskInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DailyTaskInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.isFinished_ = input.readBool();
                                break;
                            case 40:
                                this.dailyTaskId_ = input.readUInt32();
                                break;
                            case 56:
                                this.progress_ = input.readUInt32();
                                break;
                            case 72:
                                this.finishProgress_ = input.readUInt32();
                                break;
                            case 112:
                                this.rewardId_ = input.readUInt32();
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
            return DailyTaskInfoOuterClass.internal_static_DailyTaskInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DailyTaskInfoOuterClass.internal_static_DailyTaskInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyTaskInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder
        public int getFinishProgress() {
            return this.finishProgress_;
        }

        @Override // emu.grasscutter.net.proto.DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder
        public boolean getIsFinished() {
            return this.isFinished_;
        }

        @Override // emu.grasscutter.net.proto.DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder
        public int getProgress() {
            return this.progress_;
        }

        @Override // emu.grasscutter.net.proto.DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder
        public int getDailyTaskId() {
            return this.dailyTaskId_;
        }

        @Override // emu.grasscutter.net.proto.DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder
        public int getRewardId() {
            return this.rewardId_;
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
            if (this.isFinished_) {
                output.writeBool(3, this.isFinished_);
            }
            if (this.dailyTaskId_ != 0) {
                output.writeUInt32(5, this.dailyTaskId_);
            }
            if (this.progress_ != 0) {
                output.writeUInt32(7, this.progress_);
            }
            if (this.finishProgress_ != 0) {
                output.writeUInt32(9, this.finishProgress_);
            }
            if (this.rewardId_ != 0) {
                output.writeUInt32(14, this.rewardId_);
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
            if (this.isFinished_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(3, this.isFinished_);
            }
            if (this.dailyTaskId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.dailyTaskId_);
            }
            if (this.progress_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.progress_);
            }
            if (this.finishProgress_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.finishProgress_);
            }
            if (this.rewardId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.rewardId_);
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
            if (!(obj instanceof DailyTaskInfo)) {
                return equals(obj);
            }
            DailyTaskInfo other = (DailyTaskInfo) obj;
            return getFinishProgress() == other.getFinishProgress() && getIsFinished() == other.getIsFinished() && getProgress() == other.getProgress() && getDailyTaskId() == other.getDailyTaskId() && getRewardId() == other.getRewardId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getFinishProgress())) + 3)) + Internal.hashBoolean(getIsFinished()))) + 7)) + getProgress())) + 5)) + getDailyTaskId())) + 14)) + getRewardId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static DailyTaskInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DailyTaskInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyTaskInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DailyTaskInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyTaskInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DailyTaskInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyTaskInfo parseFrom(InputStream input) throws IOException {
            return (DailyTaskInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DailyTaskInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyTaskInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DailyTaskInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DailyTaskInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DailyTaskInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyTaskInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DailyTaskInfo parseFrom(CodedInputStream input) throws IOException {
            return (DailyTaskInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DailyTaskInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyTaskInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DailyTaskInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyTaskInfoOuterClass$DailyTaskInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DailyTaskInfoOrBuilder {
            private int finishProgress_;
            private boolean isFinished_;
            private int progress_;
            private int dailyTaskId_;
            private int rewardId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DailyTaskInfoOuterClass.internal_static_DailyTaskInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DailyTaskInfoOuterClass.internal_static_DailyTaskInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyTaskInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DailyTaskInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.finishProgress_ = 0;
                this.isFinished_ = false;
                this.progress_ = 0;
                this.dailyTaskId_ = 0;
                this.rewardId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DailyTaskInfoOuterClass.internal_static_DailyTaskInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DailyTaskInfo getDefaultInstanceForType() {
                return DailyTaskInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DailyTaskInfo build() {
                DailyTaskInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DailyTaskInfo buildPartial() {
                DailyTaskInfo result = new DailyTaskInfo(this);
                result.finishProgress_ = this.finishProgress_;
                result.isFinished_ = this.isFinished_;
                result.progress_ = this.progress_;
                result.dailyTaskId_ = this.dailyTaskId_;
                result.rewardId_ = this.rewardId_;
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
                if (other instanceof DailyTaskInfo) {
                    return mergeFrom((DailyTaskInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DailyTaskInfo other) {
                if (other == DailyTaskInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getFinishProgress() != 0) {
                    setFinishProgress(other.getFinishProgress());
                }
                if (other.getIsFinished()) {
                    setIsFinished(other.getIsFinished());
                }
                if (other.getProgress() != 0) {
                    setProgress(other.getProgress());
                }
                if (other.getDailyTaskId() != 0) {
                    setDailyTaskId(other.getDailyTaskId());
                }
                if (other.getRewardId() != 0) {
                    setRewardId(other.getRewardId());
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
                DailyTaskInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = DailyTaskInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DailyTaskInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder
            public int getFinishProgress() {
                return this.finishProgress_;
            }

            public Builder setFinishProgress(int value) {
                this.finishProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearFinishProgress() {
                this.finishProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder
            public boolean getIsFinished() {
                return this.isFinished_;
            }

            public Builder setIsFinished(boolean value) {
                this.isFinished_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinished() {
                this.isFinished_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder
            public int getProgress() {
                return this.progress_;
            }

            public Builder setProgress(int value) {
                this.progress_ = value;
                onChanged();
                return this;
            }

            public Builder clearProgress() {
                this.progress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder
            public int getDailyTaskId() {
                return this.dailyTaskId_;
            }

            public Builder setDailyTaskId(int value) {
                this.dailyTaskId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDailyTaskId() {
                this.dailyTaskId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder
            public int getRewardId() {
                return this.rewardId_;
            }

            public Builder setRewardId(int value) {
                this.rewardId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRewardId() {
                this.rewardId_ = 0;
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

        public static DailyTaskInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DailyTaskInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DailyTaskInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DailyTaskInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
