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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CompoundQueueDataOuterClass.class */
public final class CompoundQueueDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017CompoundQueueData.proto\"c\n\u0011CompoundQueueData\u0012\u0013\n\u000boutputCount\u0018\f \u0001(\r\u0012\u0012\n\ncompoundId\u0018\t \u0001(\r\u0012\u0011\n\twaitCount\u0018\b \u0001(\r\u0012\u0012\n\noutputTime\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CompoundQueueData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CompoundQueueData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CompoundQueueData_descriptor, new String[]{"OutputCount", "CompoundId", "WaitCount", "OutputTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CompoundQueueDataOuterClass$CompoundQueueDataOrBuilder.class */
    public interface CompoundQueueDataOrBuilder extends MessageOrBuilder {
        int getOutputCount();

        int getCompoundId();

        int getWaitCount();

        int getOutputTime();
    }

    private CompoundQueueDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CompoundQueueDataOuterClass$CompoundQueueData.class */
    public static final class CompoundQueueData extends GeneratedMessageV3 implements CompoundQueueDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OUTPUTCOUNT_FIELD_NUMBER = 12;
        private int outputCount_;
        public static final int COMPOUNDID_FIELD_NUMBER = 9;
        private int compoundId_;
        public static final int WAITCOUNT_FIELD_NUMBER = 8;
        private int waitCount_;
        public static final int OUTPUTTIME_FIELD_NUMBER = 11;
        private int outputTime_;
        private byte memoizedIsInitialized;
        private static final CompoundQueueData DEFAULT_INSTANCE = new CompoundQueueData();
        private static final Parser<CompoundQueueData> PARSER = new AbstractParser<CompoundQueueData>() { // from class: emu.grasscutter.net.proto.CompoundQueueDataOuterClass.CompoundQueueData.1
            @Override // com.google.protobuf.Parser
            public CompoundQueueData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CompoundQueueData(input, extensionRegistry);
            }
        };

        private CompoundQueueData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CompoundQueueData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CompoundQueueData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CompoundQueueData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 64:
                                    this.waitCount_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.compoundId_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.outputTime_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.outputCount_ = input.readUInt32();
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
            return CompoundQueueDataOuterClass.internal_static_CompoundQueueData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CompoundQueueDataOuterClass.internal_static_CompoundQueueData_fieldAccessorTable.ensureFieldAccessorsInitialized(CompoundQueueData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder
        public int getOutputCount() {
            return this.outputCount_;
        }

        @Override // emu.grasscutter.net.proto.CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder
        public int getCompoundId() {
            return this.compoundId_;
        }

        @Override // emu.grasscutter.net.proto.CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder
        public int getWaitCount() {
            return this.waitCount_;
        }

        @Override // emu.grasscutter.net.proto.CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder
        public int getOutputTime() {
            return this.outputTime_;
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
            if (this.waitCount_ != 0) {
                output.writeUInt32(8, this.waitCount_);
            }
            if (this.compoundId_ != 0) {
                output.writeUInt32(9, this.compoundId_);
            }
            if (this.outputTime_ != 0) {
                output.writeUInt32(11, this.outputTime_);
            }
            if (this.outputCount_ != 0) {
                output.writeUInt32(12, this.outputCount_);
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
            if (this.waitCount_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(8, this.waitCount_);
            }
            if (this.compoundId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.compoundId_);
            }
            if (this.outputTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.outputTime_);
            }
            if (this.outputCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.outputCount_);
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
            if (!(obj instanceof CompoundQueueData)) {
                return equals(obj);
            }
            CompoundQueueData other = (CompoundQueueData) obj;
            return getOutputCount() == other.getOutputCount() && getCompoundId() == other.getCompoundId() && getWaitCount() == other.getWaitCount() && getOutputTime() == other.getOutputTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getOutputCount())) + 9)) + getCompoundId())) + 8)) + getWaitCount())) + 11)) + getOutputTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static CompoundQueueData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CompoundQueueData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CompoundQueueData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CompoundQueueData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CompoundQueueData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CompoundQueueData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CompoundQueueData parseFrom(InputStream input) throws IOException {
            return (CompoundQueueData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CompoundQueueData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CompoundQueueData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CompoundQueueData parseDelimitedFrom(InputStream input) throws IOException {
            return (CompoundQueueData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CompoundQueueData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CompoundQueueData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CompoundQueueData parseFrom(CodedInputStream input) throws IOException {
            return (CompoundQueueData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CompoundQueueData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CompoundQueueData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CompoundQueueData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CompoundQueueDataOuterClass$CompoundQueueData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CompoundQueueDataOrBuilder {
            private int outputCount_;
            private int compoundId_;
            private int waitCount_;
            private int outputTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CompoundQueueDataOuterClass.internal_static_CompoundQueueData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CompoundQueueDataOuterClass.internal_static_CompoundQueueData_fieldAccessorTable.ensureFieldAccessorsInitialized(CompoundQueueData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CompoundQueueData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.outputCount_ = 0;
                this.compoundId_ = 0;
                this.waitCount_ = 0;
                this.outputTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CompoundQueueDataOuterClass.internal_static_CompoundQueueData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CompoundQueueData getDefaultInstanceForType() {
                return CompoundQueueData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CompoundQueueData build() {
                CompoundQueueData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CompoundQueueData buildPartial() {
                CompoundQueueData result = new CompoundQueueData(this);
                result.outputCount_ = this.outputCount_;
                result.compoundId_ = this.compoundId_;
                result.waitCount_ = this.waitCount_;
                result.outputTime_ = this.outputTime_;
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
                if (other instanceof CompoundQueueData) {
                    return mergeFrom((CompoundQueueData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CompoundQueueData other) {
                if (other == CompoundQueueData.getDefaultInstance()) {
                    return this;
                }
                if (other.getOutputCount() != 0) {
                    setOutputCount(other.getOutputCount());
                }
                if (other.getCompoundId() != 0) {
                    setCompoundId(other.getCompoundId());
                }
                if (other.getWaitCount() != 0) {
                    setWaitCount(other.getWaitCount());
                }
                if (other.getOutputTime() != 0) {
                    setOutputTime(other.getOutputTime());
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
                CompoundQueueData parsedMessage = null;
                try {
                    try {
                        parsedMessage = CompoundQueueData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CompoundQueueData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder
            public int getOutputCount() {
                return this.outputCount_;
            }

            public Builder setOutputCount(int value) {
                this.outputCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearOutputCount() {
                this.outputCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder
            public int getCompoundId() {
                return this.compoundId_;
            }

            public Builder setCompoundId(int value) {
                this.compoundId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCompoundId() {
                this.compoundId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder
            public int getWaitCount() {
                return this.waitCount_;
            }

            public Builder setWaitCount(int value) {
                this.waitCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearWaitCount() {
                this.waitCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder
            public int getOutputTime() {
                return this.outputTime_;
            }

            public Builder setOutputTime(int value) {
                this.outputTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearOutputTime() {
                this.outputTime_ = 0;
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

        public static CompoundQueueData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CompoundQueueData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CompoundQueueData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CompoundQueueData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
