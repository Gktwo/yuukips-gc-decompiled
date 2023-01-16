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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryDungeonRecordOuterClass.class */
public final class RogueDiaryDungeonRecordOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dRogueDiaryDungeonRecord.proto\"h\n\u0017RogueDiaryDungeonRecord\u0012\u0013\n\u000bfinish_time\u0018\u000e \u0001(\r\u0012\u0011\n\tis_finish\u0018\n \u0001(\b\u0012\u0012\n\ndifficulty\u0018\u0005 \u0001(\r\u0012\u0011\n\tmax_round\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_RogueDiaryDungeonRecord_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RogueDiaryDungeonRecord_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RogueDiaryDungeonRecord_descriptor, new String[]{"FinishTime", "IsFinish", "Difficulty", "MaxRound"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryDungeonRecordOuterClass$RogueDiaryDungeonRecordOrBuilder.class */
    public interface RogueDiaryDungeonRecordOrBuilder extends MessageOrBuilder {
        int getFinishTime();

        boolean getIsFinish();

        int getDifficulty();

        int getMaxRound();
    }

    private RogueDiaryDungeonRecordOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryDungeonRecordOuterClass$RogueDiaryDungeonRecord.class */
    public static final class RogueDiaryDungeonRecord extends GeneratedMessageV3 implements RogueDiaryDungeonRecordOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FINISH_TIME_FIELD_NUMBER = 14;
        private int finishTime_;
        public static final int IS_FINISH_FIELD_NUMBER = 10;
        private boolean isFinish_;
        public static final int DIFFICULTY_FIELD_NUMBER = 5;
        private int difficulty_;
        public static final int MAX_ROUND_FIELD_NUMBER = 7;
        private int maxRound_;
        private byte memoizedIsInitialized;
        private static final RogueDiaryDungeonRecord DEFAULT_INSTANCE = new RogueDiaryDungeonRecord();
        private static final Parser<RogueDiaryDungeonRecord> PARSER = new AbstractParser<RogueDiaryDungeonRecord>() { // from class: emu.grasscutter.net.proto.RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord.1
            @Override // com.google.protobuf.Parser
            public RogueDiaryDungeonRecord parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RogueDiaryDungeonRecord(input, extensionRegistry);
            }
        };

        private RogueDiaryDungeonRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RogueDiaryDungeonRecord() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RogueDiaryDungeonRecord();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RogueDiaryDungeonRecord(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    this.difficulty_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.maxRound_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.isFinish_ = input.readBool();
                                    break;
                                case 112:
                                    this.finishTime_ = input.readUInt32();
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
            return RogueDiaryDungeonRecordOuterClass.internal_static_RogueDiaryDungeonRecord_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RogueDiaryDungeonRecordOuterClass.internal_static_RogueDiaryDungeonRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueDiaryDungeonRecord.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecordOrBuilder
        public int getFinishTime() {
            return this.finishTime_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecordOrBuilder
        public boolean getIsFinish() {
            return this.isFinish_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecordOrBuilder
        public int getDifficulty() {
            return this.difficulty_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecordOrBuilder
        public int getMaxRound() {
            return this.maxRound_;
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
            if (this.difficulty_ != 0) {
                output.writeUInt32(5, this.difficulty_);
            }
            if (this.maxRound_ != 0) {
                output.writeUInt32(7, this.maxRound_);
            }
            if (this.isFinish_) {
                output.writeBool(10, this.isFinish_);
            }
            if (this.finishTime_ != 0) {
                output.writeUInt32(14, this.finishTime_);
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
            if (this.difficulty_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.difficulty_);
            }
            if (this.maxRound_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.maxRound_);
            }
            if (this.isFinish_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.isFinish_);
            }
            if (this.finishTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.finishTime_);
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
            if (!(obj instanceof RogueDiaryDungeonRecord)) {
                return equals(obj);
            }
            RogueDiaryDungeonRecord other = (RogueDiaryDungeonRecord) obj;
            return getFinishTime() == other.getFinishTime() && getIsFinish() == other.getIsFinish() && getDifficulty() == other.getDifficulty() && getMaxRound() == other.getMaxRound() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getFinishTime())) + 10)) + Internal.hashBoolean(getIsFinish()))) + 5)) + getDifficulty())) + 7)) + getMaxRound())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static RogueDiaryDungeonRecord parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryDungeonRecord parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryDungeonRecord parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryDungeonRecord parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryDungeonRecord parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryDungeonRecord parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryDungeonRecord parseFrom(InputStream input) throws IOException {
            return (RogueDiaryDungeonRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueDiaryDungeonRecord parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryDungeonRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueDiaryDungeonRecord parseDelimitedFrom(InputStream input) throws IOException {
            return (RogueDiaryDungeonRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RogueDiaryDungeonRecord parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryDungeonRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueDiaryDungeonRecord parseFrom(CodedInputStream input) throws IOException {
            return (RogueDiaryDungeonRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueDiaryDungeonRecord parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryDungeonRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RogueDiaryDungeonRecord prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryDungeonRecordOuterClass$RogueDiaryDungeonRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RogueDiaryDungeonRecordOrBuilder {
            private int finishTime_;
            private boolean isFinish_;
            private int difficulty_;
            private int maxRound_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RogueDiaryDungeonRecordOuterClass.internal_static_RogueDiaryDungeonRecord_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RogueDiaryDungeonRecordOuterClass.internal_static_RogueDiaryDungeonRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueDiaryDungeonRecord.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RogueDiaryDungeonRecord.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.finishTime_ = 0;
                this.isFinish_ = false;
                this.difficulty_ = 0;
                this.maxRound_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RogueDiaryDungeonRecordOuterClass.internal_static_RogueDiaryDungeonRecord_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RogueDiaryDungeonRecord getDefaultInstanceForType() {
                return RogueDiaryDungeonRecord.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueDiaryDungeonRecord build() {
                RogueDiaryDungeonRecord result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueDiaryDungeonRecord buildPartial() {
                RogueDiaryDungeonRecord result = new RogueDiaryDungeonRecord(this);
                result.finishTime_ = this.finishTime_;
                result.isFinish_ = this.isFinish_;
                result.difficulty_ = this.difficulty_;
                result.maxRound_ = this.maxRound_;
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
                if (other instanceof RogueDiaryDungeonRecord) {
                    return mergeFrom((RogueDiaryDungeonRecord) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RogueDiaryDungeonRecord other) {
                if (other == RogueDiaryDungeonRecord.getDefaultInstance()) {
                    return this;
                }
                if (other.getFinishTime() != 0) {
                    setFinishTime(other.getFinishTime());
                }
                if (other.getIsFinish()) {
                    setIsFinish(other.getIsFinish());
                }
                if (other.getDifficulty() != 0) {
                    setDifficulty(other.getDifficulty());
                }
                if (other.getMaxRound() != 0) {
                    setMaxRound(other.getMaxRound());
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
                RogueDiaryDungeonRecord parsedMessage = null;
                try {
                    try {
                        parsedMessage = RogueDiaryDungeonRecord.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RogueDiaryDungeonRecord) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecordOrBuilder
            public int getFinishTime() {
                return this.finishTime_;
            }

            public Builder setFinishTime(int value) {
                this.finishTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearFinishTime() {
                this.finishTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecordOrBuilder
            public boolean getIsFinish() {
                return this.isFinish_;
            }

            public Builder setIsFinish(boolean value) {
                this.isFinish_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinish() {
                this.isFinish_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecordOrBuilder
            public int getDifficulty() {
                return this.difficulty_;
            }

            public Builder setDifficulty(int value) {
                this.difficulty_ = value;
                onChanged();
                return this;
            }

            public Builder clearDifficulty() {
                this.difficulty_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecordOrBuilder
            public int getMaxRound() {
                return this.maxRound_;
            }

            public Builder setMaxRound(int value) {
                this.maxRound_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxRound() {
                this.maxRound_ = 0;
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

        public static RogueDiaryDungeonRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RogueDiaryDungeonRecord> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RogueDiaryDungeonRecord> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RogueDiaryDungeonRecord getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
