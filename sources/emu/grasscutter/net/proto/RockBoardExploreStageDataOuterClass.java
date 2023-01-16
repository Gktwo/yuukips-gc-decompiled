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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RockBoardExploreStageDataOuterClass.class */
public final class RockBoardExploreStageDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fRockBoardExploreStageData.proto\"d\n\u0019RockBoardExploreStageData\u0012\u0011\n\tis_finish\u0018\b \u0001(\b\u0012\u000f\n\u0007is_open\u0018\t \u0001(\b\u0012\u0011\n\topen_time\u0018\f \u0001(\r\u0012\u0010\n\bstage_id\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_RockBoardExploreStageData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RockBoardExploreStageData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RockBoardExploreStageData_descriptor, new String[]{"IsFinish", "IsOpen", "OpenTime", "StageId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RockBoardExploreStageDataOuterClass$RockBoardExploreStageDataOrBuilder.class */
    public interface RockBoardExploreStageDataOrBuilder extends MessageOrBuilder {
        boolean getIsFinish();

        boolean getIsOpen();

        int getOpenTime();

        int getStageId();
    }

    private RockBoardExploreStageDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RockBoardExploreStageDataOuterClass$RockBoardExploreStageData.class */
    public static final class RockBoardExploreStageData extends GeneratedMessageV3 implements RockBoardExploreStageDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_FINISH_FIELD_NUMBER = 8;
        private boolean isFinish_;
        public static final int IS_OPEN_FIELD_NUMBER = 9;
        private boolean isOpen_;
        public static final int OPEN_TIME_FIELD_NUMBER = 12;
        private int openTime_;
        public static final int STAGE_ID_FIELD_NUMBER = 13;
        private int stageId_;
        private byte memoizedIsInitialized;
        private static final RockBoardExploreStageData DEFAULT_INSTANCE = new RockBoardExploreStageData();
        private static final Parser<RockBoardExploreStageData> PARSER = new AbstractParser<RockBoardExploreStageData>() { // from class: emu.grasscutter.net.proto.RockBoardExploreStageDataOuterClass.RockBoardExploreStageData.1
            @Override // com.google.protobuf.Parser
            public RockBoardExploreStageData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RockBoardExploreStageData(input, extensionRegistry);
            }
        };

        private RockBoardExploreStageData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RockBoardExploreStageData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RockBoardExploreStageData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RockBoardExploreStageData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.isFinish_ = input.readBool();
                                    break;
                                case 72:
                                    this.isOpen_ = input.readBool();
                                    break;
                                case 96:
                                    this.openTime_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.stageId_ = input.readUInt32();
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
            return RockBoardExploreStageDataOuterClass.internal_static_RockBoardExploreStageData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RockBoardExploreStageDataOuterClass.internal_static_RockBoardExploreStageData_fieldAccessorTable.ensureFieldAccessorsInitialized(RockBoardExploreStageData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RockBoardExploreStageDataOuterClass.RockBoardExploreStageDataOrBuilder
        public boolean getIsFinish() {
            return this.isFinish_;
        }

        @Override // emu.grasscutter.net.proto.RockBoardExploreStageDataOuterClass.RockBoardExploreStageDataOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.RockBoardExploreStageDataOuterClass.RockBoardExploreStageDataOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.RockBoardExploreStageDataOuterClass.RockBoardExploreStageDataOrBuilder
        public int getStageId() {
            return this.stageId_;
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
            if (this.isFinish_) {
                output.writeBool(8, this.isFinish_);
            }
            if (this.isOpen_) {
                output.writeBool(9, this.isOpen_);
            }
            if (this.openTime_ != 0) {
                output.writeUInt32(12, this.openTime_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(13, this.stageId_);
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
            if (this.isFinish_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(8, this.isFinish_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.isOpen_);
            }
            if (this.openTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.openTime_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.stageId_);
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
            if (!(obj instanceof RockBoardExploreStageData)) {
                return equals(obj);
            }
            RockBoardExploreStageData other = (RockBoardExploreStageData) obj;
            return getIsFinish() == other.getIsFinish() && getIsOpen() == other.getIsOpen() && getOpenTime() == other.getOpenTime() && getStageId() == other.getStageId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + Internal.hashBoolean(getIsFinish()))) + 9)) + Internal.hashBoolean(getIsOpen()))) + 12)) + getOpenTime())) + 13)) + getStageId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static RockBoardExploreStageData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RockBoardExploreStageData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RockBoardExploreStageData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RockBoardExploreStageData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RockBoardExploreStageData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RockBoardExploreStageData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RockBoardExploreStageData parseFrom(InputStream input) throws IOException {
            return (RockBoardExploreStageData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RockBoardExploreStageData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RockBoardExploreStageData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RockBoardExploreStageData parseDelimitedFrom(InputStream input) throws IOException {
            return (RockBoardExploreStageData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RockBoardExploreStageData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RockBoardExploreStageData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RockBoardExploreStageData parseFrom(CodedInputStream input) throws IOException {
            return (RockBoardExploreStageData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RockBoardExploreStageData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RockBoardExploreStageData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RockBoardExploreStageData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RockBoardExploreStageDataOuterClass$RockBoardExploreStageData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RockBoardExploreStageDataOrBuilder {
            private boolean isFinish_;
            private boolean isOpen_;
            private int openTime_;
            private int stageId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RockBoardExploreStageDataOuterClass.internal_static_RockBoardExploreStageData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RockBoardExploreStageDataOuterClass.internal_static_RockBoardExploreStageData_fieldAccessorTable.ensureFieldAccessorsInitialized(RockBoardExploreStageData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RockBoardExploreStageData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isFinish_ = false;
                this.isOpen_ = false;
                this.openTime_ = 0;
                this.stageId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RockBoardExploreStageDataOuterClass.internal_static_RockBoardExploreStageData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RockBoardExploreStageData getDefaultInstanceForType() {
                return RockBoardExploreStageData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RockBoardExploreStageData build() {
                RockBoardExploreStageData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RockBoardExploreStageData buildPartial() {
                RockBoardExploreStageData result = new RockBoardExploreStageData(this);
                result.isFinish_ = this.isFinish_;
                result.isOpen_ = this.isOpen_;
                result.openTime_ = this.openTime_;
                result.stageId_ = this.stageId_;
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
                if (other instanceof RockBoardExploreStageData) {
                    return mergeFrom((RockBoardExploreStageData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RockBoardExploreStageData other) {
                if (other == RockBoardExploreStageData.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsFinish()) {
                    setIsFinish(other.getIsFinish());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
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
                RockBoardExploreStageData parsedMessage = null;
                try {
                    try {
                        parsedMessage = RockBoardExploreStageData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RockBoardExploreStageData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RockBoardExploreStageDataOuterClass.RockBoardExploreStageDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.RockBoardExploreStageDataOuterClass.RockBoardExploreStageDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.RockBoardExploreStageDataOuterClass.RockBoardExploreStageDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.RockBoardExploreStageDataOuterClass.RockBoardExploreStageDataOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static RockBoardExploreStageData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RockBoardExploreStageData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RockBoardExploreStageData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RockBoardExploreStageData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
