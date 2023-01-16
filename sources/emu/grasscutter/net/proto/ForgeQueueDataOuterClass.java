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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueDataOuterClass.class */
public final class ForgeQueueDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014ForgeQueueData.proto\"´\u0001\n\u000eForgeQueueData\u0012\u001d\n\u0015next_finish_timestamp\u0018\u0001 \u0001(\r\u0012\u0010\n\bforge_id\u0018\u0005 \u0001(\r\u0012\u0014\n\ffinish_count\u0018\u0007 \u0001(\r\u0012\u0010\n\bqueue_id\u0018\u0004 \u0001(\r\u0012\u001e\n\u0016total_finish_timestamp\u0018\u000f \u0001(\r\u0012\u0011\n\tavatar_id\u0018\f \u0001(\r\u0012\u0016\n\u000eunfinish_count\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ForgeQueueData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ForgeQueueData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ForgeQueueData_descriptor, new String[]{"NextFinishTimestamp", "ForgeId", "FinishCount", "QueueId", "TotalFinishTimestamp", "AvatarId", "UnfinishCount"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueDataOuterClass$ForgeQueueDataOrBuilder.class */
    public interface ForgeQueueDataOrBuilder extends MessageOrBuilder {
        int getNextFinishTimestamp();

        int getForgeId();

        int getFinishCount();

        int getQueueId();

        int getTotalFinishTimestamp();

        int getAvatarId();

        int getUnfinishCount();
    }

    private ForgeQueueDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueDataOuterClass$ForgeQueueData.class */
    public static final class ForgeQueueData extends GeneratedMessageV3 implements ForgeQueueDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int NEXT_FINISH_TIMESTAMP_FIELD_NUMBER = 1;
        private int nextFinishTimestamp_;
        public static final int FORGE_ID_FIELD_NUMBER = 5;
        private int forgeId_;
        public static final int FINISH_COUNT_FIELD_NUMBER = 7;
        private int finishCount_;
        public static final int QUEUE_ID_FIELD_NUMBER = 4;
        private int queueId_;
        public static final int TOTAL_FINISH_TIMESTAMP_FIELD_NUMBER = 15;
        private int totalFinishTimestamp_;
        public static final int AVATAR_ID_FIELD_NUMBER = 12;
        private int avatarId_;
        public static final int UNFINISH_COUNT_FIELD_NUMBER = 3;
        private int unfinishCount_;
        private byte memoizedIsInitialized;
        private static final ForgeQueueData DEFAULT_INSTANCE = new ForgeQueueData();
        private static final Parser<ForgeQueueData> PARSER = new AbstractParser<ForgeQueueData>() { // from class: emu.grasscutter.net.proto.ForgeQueueDataOuterClass.ForgeQueueData.1
            @Override // com.google.protobuf.Parser
            public ForgeQueueData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ForgeQueueData(input, extensionRegistry);
            }
        };

        private ForgeQueueData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ForgeQueueData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ForgeQueueData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ForgeQueueData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.nextFinishTimestamp_ = input.readUInt32();
                                break;
                            case 24:
                                this.unfinishCount_ = input.readUInt32();
                                break;
                            case 32:
                                this.queueId_ = input.readUInt32();
                                break;
                            case 40:
                                this.forgeId_ = input.readUInt32();
                                break;
                            case 56:
                                this.finishCount_ = input.readUInt32();
                                break;
                            case 96:
                                this.avatarId_ = input.readUInt32();
                                break;
                            case 120:
                                this.totalFinishTimestamp_ = input.readUInt32();
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
            return ForgeQueueDataOuterClass.internal_static_ForgeQueueData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ForgeQueueDataOuterClass.internal_static_ForgeQueueData_fieldAccessorTable.ensureFieldAccessorsInitialized(ForgeQueueData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueDataOuterClass.ForgeQueueDataOrBuilder
        public int getNextFinishTimestamp() {
            return this.nextFinishTimestamp_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueDataOuterClass.ForgeQueueDataOrBuilder
        public int getForgeId() {
            return this.forgeId_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueDataOuterClass.ForgeQueueDataOrBuilder
        public int getFinishCount() {
            return this.finishCount_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueDataOuterClass.ForgeQueueDataOrBuilder
        public int getQueueId() {
            return this.queueId_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueDataOuterClass.ForgeQueueDataOrBuilder
        public int getTotalFinishTimestamp() {
            return this.totalFinishTimestamp_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueDataOuterClass.ForgeQueueDataOrBuilder
        public int getAvatarId() {
            return this.avatarId_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueDataOuterClass.ForgeQueueDataOrBuilder
        public int getUnfinishCount() {
            return this.unfinishCount_;
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
            if (this.nextFinishTimestamp_ != 0) {
                output.writeUInt32(1, this.nextFinishTimestamp_);
            }
            if (this.unfinishCount_ != 0) {
                output.writeUInt32(3, this.unfinishCount_);
            }
            if (this.queueId_ != 0) {
                output.writeUInt32(4, this.queueId_);
            }
            if (this.forgeId_ != 0) {
                output.writeUInt32(5, this.forgeId_);
            }
            if (this.finishCount_ != 0) {
                output.writeUInt32(7, this.finishCount_);
            }
            if (this.avatarId_ != 0) {
                output.writeUInt32(12, this.avatarId_);
            }
            if (this.totalFinishTimestamp_ != 0) {
                output.writeUInt32(15, this.totalFinishTimestamp_);
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
            if (this.nextFinishTimestamp_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.nextFinishTimestamp_);
            }
            if (this.unfinishCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.unfinishCount_);
            }
            if (this.queueId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.queueId_);
            }
            if (this.forgeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.forgeId_);
            }
            if (this.finishCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.finishCount_);
            }
            if (this.avatarId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.avatarId_);
            }
            if (this.totalFinishTimestamp_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.totalFinishTimestamp_);
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
            if (!(obj instanceof ForgeQueueData)) {
                return equals(obj);
            }
            ForgeQueueData other = (ForgeQueueData) obj;
            return getNextFinishTimestamp() == other.getNextFinishTimestamp() && getForgeId() == other.getForgeId() && getFinishCount() == other.getFinishCount() && getQueueId() == other.getQueueId() && getTotalFinishTimestamp() == other.getTotalFinishTimestamp() && getAvatarId() == other.getAvatarId() && getUnfinishCount() == other.getUnfinishCount() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getNextFinishTimestamp())) + 5)) + getForgeId())) + 7)) + getFinishCount())) + 4)) + getQueueId())) + 15)) + getTotalFinishTimestamp())) + 12)) + getAvatarId())) + 3)) + getUnfinishCount())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ForgeQueueData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeQueueData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeQueueData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeQueueData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeQueueData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeQueueData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeQueueData parseFrom(InputStream input) throws IOException {
            return (ForgeQueueData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ForgeQueueData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeQueueData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ForgeQueueData parseDelimitedFrom(InputStream input) throws IOException {
            return (ForgeQueueData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ForgeQueueData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeQueueData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ForgeQueueData parseFrom(CodedInputStream input) throws IOException {
            return (ForgeQueueData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ForgeQueueData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeQueueData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ForgeQueueData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueDataOuterClass$ForgeQueueData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ForgeQueueDataOrBuilder {
            private int nextFinishTimestamp_;
            private int forgeId_;
            private int finishCount_;
            private int queueId_;
            private int totalFinishTimestamp_;
            private int avatarId_;
            private int unfinishCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ForgeQueueDataOuterClass.internal_static_ForgeQueueData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ForgeQueueDataOuterClass.internal_static_ForgeQueueData_fieldAccessorTable.ensureFieldAccessorsInitialized(ForgeQueueData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ForgeQueueData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.nextFinishTimestamp_ = 0;
                this.forgeId_ = 0;
                this.finishCount_ = 0;
                this.queueId_ = 0;
                this.totalFinishTimestamp_ = 0;
                this.avatarId_ = 0;
                this.unfinishCount_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ForgeQueueDataOuterClass.internal_static_ForgeQueueData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ForgeQueueData getDefaultInstanceForType() {
                return ForgeQueueData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ForgeQueueData build() {
                ForgeQueueData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ForgeQueueData buildPartial() {
                ForgeQueueData result = new ForgeQueueData(this);
                result.nextFinishTimestamp_ = this.nextFinishTimestamp_;
                result.forgeId_ = this.forgeId_;
                result.finishCount_ = this.finishCount_;
                result.queueId_ = this.queueId_;
                result.totalFinishTimestamp_ = this.totalFinishTimestamp_;
                result.avatarId_ = this.avatarId_;
                result.unfinishCount_ = this.unfinishCount_;
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
                if (other instanceof ForgeQueueData) {
                    return mergeFrom((ForgeQueueData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ForgeQueueData other) {
                if (other == ForgeQueueData.getDefaultInstance()) {
                    return this;
                }
                if (other.getNextFinishTimestamp() != 0) {
                    setNextFinishTimestamp(other.getNextFinishTimestamp());
                }
                if (other.getForgeId() != 0) {
                    setForgeId(other.getForgeId());
                }
                if (other.getFinishCount() != 0) {
                    setFinishCount(other.getFinishCount());
                }
                if (other.getQueueId() != 0) {
                    setQueueId(other.getQueueId());
                }
                if (other.getTotalFinishTimestamp() != 0) {
                    setTotalFinishTimestamp(other.getTotalFinishTimestamp());
                }
                if (other.getAvatarId() != 0) {
                    setAvatarId(other.getAvatarId());
                }
                if (other.getUnfinishCount() != 0) {
                    setUnfinishCount(other.getUnfinishCount());
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
                ForgeQueueData parsedMessage = null;
                try {
                    try {
                        parsedMessage = ForgeQueueData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ForgeQueueData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueDataOuterClass.ForgeQueueDataOrBuilder
            public int getNextFinishTimestamp() {
                return this.nextFinishTimestamp_;
            }

            public Builder setNextFinishTimestamp(int value) {
                this.nextFinishTimestamp_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextFinishTimestamp() {
                this.nextFinishTimestamp_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueDataOuterClass.ForgeQueueDataOrBuilder
            public int getForgeId() {
                return this.forgeId_;
            }

            public Builder setForgeId(int value) {
                this.forgeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearForgeId() {
                this.forgeId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueDataOuterClass.ForgeQueueDataOrBuilder
            public int getFinishCount() {
                return this.finishCount_;
            }

            public Builder setFinishCount(int value) {
                this.finishCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearFinishCount() {
                this.finishCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueDataOuterClass.ForgeQueueDataOrBuilder
            public int getQueueId() {
                return this.queueId_;
            }

            public Builder setQueueId(int value) {
                this.queueId_ = value;
                onChanged();
                return this;
            }

            public Builder clearQueueId() {
                this.queueId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueDataOuterClass.ForgeQueueDataOrBuilder
            public int getTotalFinishTimestamp() {
                return this.totalFinishTimestamp_;
            }

            public Builder setTotalFinishTimestamp(int value) {
                this.totalFinishTimestamp_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalFinishTimestamp() {
                this.totalFinishTimestamp_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueDataOuterClass.ForgeQueueDataOrBuilder
            public int getAvatarId() {
                return this.avatarId_;
            }

            public Builder setAvatarId(int value) {
                this.avatarId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarId() {
                this.avatarId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueDataOuterClass.ForgeQueueDataOrBuilder
            public int getUnfinishCount() {
                return this.unfinishCount_;
            }

            public Builder setUnfinishCount(int value) {
                this.unfinishCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnfinishCount() {
                this.unfinishCount_ = 0;
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

        public static ForgeQueueData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ForgeQueueData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ForgeQueueData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ForgeQueueData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
