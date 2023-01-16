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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageHuntingStageDataOuterClass.class */
public final class VintageHuntingStageDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dVintageHuntingStageData.proto\"x\n\u0017VintageHuntingStageData\u0012\u0014\n\frecord_value\u0018\u000b \u0001(\r\u0012\u0011\n\topen_time\u0018\u0005 \u0001(\r\u0012\u0010\n\bstage_id\u0018\n \u0001(\r\u0012\u0011\n\tis_finish\u0018\f \u0001(\b\u0012\u000f\n\u0007is_open\u0018\u0004 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_VintageHuntingStageData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_VintageHuntingStageData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_VintageHuntingStageData_descriptor, new String[]{"RecordValue", "OpenTime", "StageId", "IsFinish", "IsOpen"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageHuntingStageDataOuterClass$VintageHuntingStageDataOrBuilder.class */
    public interface VintageHuntingStageDataOrBuilder extends MessageOrBuilder {
        int getRecordValue();

        int getOpenTime();

        int getStageId();

        boolean getIsFinish();

        boolean getIsOpen();
    }

    private VintageHuntingStageDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageHuntingStageDataOuterClass$VintageHuntingStageData.class */
    public static final class VintageHuntingStageData extends GeneratedMessageV3 implements VintageHuntingStageDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RECORD_VALUE_FIELD_NUMBER = 11;
        private int recordValue_;
        public static final int OPEN_TIME_FIELD_NUMBER = 5;
        private int openTime_;
        public static final int STAGE_ID_FIELD_NUMBER = 10;
        private int stageId_;
        public static final int IS_FINISH_FIELD_NUMBER = 12;
        private boolean isFinish_;
        public static final int IS_OPEN_FIELD_NUMBER = 4;
        private boolean isOpen_;
        private byte memoizedIsInitialized;
        private static final VintageHuntingStageData DEFAULT_INSTANCE = new VintageHuntingStageData();
        private static final Parser<VintageHuntingStageData> PARSER = new AbstractParser<VintageHuntingStageData>() { // from class: emu.grasscutter.net.proto.VintageHuntingStageDataOuterClass.VintageHuntingStageData.1
            @Override // com.google.protobuf.Parser
            public VintageHuntingStageData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VintageHuntingStageData(input, extensionRegistry);
            }
        };

        private VintageHuntingStageData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private VintageHuntingStageData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new VintageHuntingStageData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VintageHuntingStageData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.isOpen_ = input.readBool();
                                break;
                            case 40:
                                this.openTime_ = input.readUInt32();
                                break;
                            case 80:
                                this.stageId_ = input.readUInt32();
                                break;
                            case 88:
                                this.recordValue_ = input.readUInt32();
                                break;
                            case 96:
                                this.isFinish_ = input.readBool();
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
            return VintageHuntingStageDataOuterClass.internal_static_VintageHuntingStageData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VintageHuntingStageDataOuterClass.internal_static_VintageHuntingStageData_fieldAccessorTable.ensureFieldAccessorsInitialized(VintageHuntingStageData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.VintageHuntingStageDataOuterClass.VintageHuntingStageDataOrBuilder
        public int getRecordValue() {
            return this.recordValue_;
        }

        @Override // emu.grasscutter.net.proto.VintageHuntingStageDataOuterClass.VintageHuntingStageDataOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.VintageHuntingStageDataOuterClass.VintageHuntingStageDataOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.VintageHuntingStageDataOuterClass.VintageHuntingStageDataOrBuilder
        public boolean getIsFinish() {
            return this.isFinish_;
        }

        @Override // emu.grasscutter.net.proto.VintageHuntingStageDataOuterClass.VintageHuntingStageDataOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
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
            if (this.isOpen_) {
                output.writeBool(4, this.isOpen_);
            }
            if (this.openTime_ != 0) {
                output.writeUInt32(5, this.openTime_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(10, this.stageId_);
            }
            if (this.recordValue_ != 0) {
                output.writeUInt32(11, this.recordValue_);
            }
            if (this.isFinish_) {
                output.writeBool(12, this.isFinish_);
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
            if (this.isOpen_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(4, this.isOpen_);
            }
            if (this.openTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.openTime_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.stageId_);
            }
            if (this.recordValue_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.recordValue_);
            }
            if (this.isFinish_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isFinish_);
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
            if (!(obj instanceof VintageHuntingStageData)) {
                return equals(obj);
            }
            VintageHuntingStageData other = (VintageHuntingStageData) obj;
            return getRecordValue() == other.getRecordValue() && getOpenTime() == other.getOpenTime() && getStageId() == other.getStageId() && getIsFinish() == other.getIsFinish() && getIsOpen() == other.getIsOpen() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getRecordValue())) + 5)) + getOpenTime())) + 10)) + getStageId())) + 12)) + Internal.hashBoolean(getIsFinish()))) + 4)) + Internal.hashBoolean(getIsOpen()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static VintageHuntingStageData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageHuntingStageData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageHuntingStageData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageHuntingStageData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageHuntingStageData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageHuntingStageData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageHuntingStageData parseFrom(InputStream input) throws IOException {
            return (VintageHuntingStageData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintageHuntingStageData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageHuntingStageData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintageHuntingStageData parseDelimitedFrom(InputStream input) throws IOException {
            return (VintageHuntingStageData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static VintageHuntingStageData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageHuntingStageData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintageHuntingStageData parseFrom(CodedInputStream input) throws IOException {
            return (VintageHuntingStageData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintageHuntingStageData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageHuntingStageData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VintageHuntingStageData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageHuntingStageDataOuterClass$VintageHuntingStageData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VintageHuntingStageDataOrBuilder {
            private int recordValue_;
            private int openTime_;
            private int stageId_;
            private boolean isFinish_;
            private boolean isOpen_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VintageHuntingStageDataOuterClass.internal_static_VintageHuntingStageData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VintageHuntingStageDataOuterClass.internal_static_VintageHuntingStageData_fieldAccessorTable.ensureFieldAccessorsInitialized(VintageHuntingStageData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VintageHuntingStageData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.recordValue_ = 0;
                this.openTime_ = 0;
                this.stageId_ = 0;
                this.isFinish_ = false;
                this.isOpen_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VintageHuntingStageDataOuterClass.internal_static_VintageHuntingStageData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VintageHuntingStageData getDefaultInstanceForType() {
                return VintageHuntingStageData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintageHuntingStageData build() {
                VintageHuntingStageData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintageHuntingStageData buildPartial() {
                VintageHuntingStageData result = new VintageHuntingStageData(this);
                result.recordValue_ = this.recordValue_;
                result.openTime_ = this.openTime_;
                result.stageId_ = this.stageId_;
                result.isFinish_ = this.isFinish_;
                result.isOpen_ = this.isOpen_;
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
                if (other instanceof VintageHuntingStageData) {
                    return mergeFrom((VintageHuntingStageData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VintageHuntingStageData other) {
                if (other == VintageHuntingStageData.getDefaultInstance()) {
                    return this;
                }
                if (other.getRecordValue() != 0) {
                    setRecordValue(other.getRecordValue());
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getIsFinish()) {
                    setIsFinish(other.getIsFinish());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
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
                VintageHuntingStageData parsedMessage = null;
                try {
                    try {
                        parsedMessage = VintageHuntingStageData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (VintageHuntingStageData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageHuntingStageDataOuterClass.VintageHuntingStageDataOrBuilder
            public int getRecordValue() {
                return this.recordValue_;
            }

            public Builder setRecordValue(int value) {
                this.recordValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearRecordValue() {
                this.recordValue_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageHuntingStageDataOuterClass.VintageHuntingStageDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.VintageHuntingStageDataOuterClass.VintageHuntingStageDataOrBuilder
            public int getStageId() {
                return this.stageId_;
            }

            public Builder setStageId(int value) {
                this.stageId_ = value;
                onChanged();
                return this;
            }

            public Builder clearStageId() {
                this.stageId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageHuntingStageDataOuterClass.VintageHuntingStageDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.VintageHuntingStageDataOuterClass.VintageHuntingStageDataOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
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

        public static VintageHuntingStageData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VintageHuntingStageData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VintageHuntingStageData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VintageHuntingStageData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
