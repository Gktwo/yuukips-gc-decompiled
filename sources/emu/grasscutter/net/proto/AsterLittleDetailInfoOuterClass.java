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
import emu.grasscutter.net.proto.AsterLittleStageStateOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterLittleDetailInfoOuterClass.class */
public final class AsterLittleDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bAsterLittleDetailInfo.proto\u001a\u001bAsterLittleStageState.proto\"\u0001\n\u0015AsterLittleDetailInfo\u0012\u0018\n\u0010stage_begin_time\u0018\t \u0001(\r\u0012\u000f\n\u0007is_open\u0018\b \u0001(\b\u0012+\n\u000bstage_state\u0018\u0005 \u0001(\u000e2\u0016.AsterLittleStageState\u0012\u0010\n\bstage_id\u0018\u000e \u0001(\r\u0012\u0012\n\nbegin_time\u0018\u0006 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AsterLittleStageStateOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AsterLittleDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AsterLittleDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AsterLittleDetailInfo_descriptor, new String[]{"StageBeginTime", "IsOpen", "StageState", "StageId", "BeginTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterLittleDetailInfoOuterClass$AsterLittleDetailInfoOrBuilder.class */
    public interface AsterLittleDetailInfoOrBuilder extends MessageOrBuilder {
        int getStageBeginTime();

        boolean getIsOpen();

        int getStageStateValue();

        AsterLittleStageStateOuterClass.AsterLittleStageState getStageState();

        int getStageId();

        int getBeginTime();
    }

    private AsterLittleDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterLittleDetailInfoOuterClass$AsterLittleDetailInfo.class */
    public static final class AsterLittleDetailInfo extends GeneratedMessageV3 implements AsterLittleDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGE_BEGIN_TIME_FIELD_NUMBER = 9;
        private int stageBeginTime_;
        public static final int IS_OPEN_FIELD_NUMBER = 8;
        private boolean isOpen_;
        public static final int STAGE_STATE_FIELD_NUMBER = 5;
        private int stageState_;
        public static final int STAGE_ID_FIELD_NUMBER = 14;
        private int stageId_;
        public static final int BEGIN_TIME_FIELD_NUMBER = 6;
        private int beginTime_;
        private byte memoizedIsInitialized;
        private static final AsterLittleDetailInfo DEFAULT_INSTANCE = new AsterLittleDetailInfo();
        private static final Parser<AsterLittleDetailInfo> PARSER = new AbstractParser<AsterLittleDetailInfo>() { // from class: emu.grasscutter.net.proto.AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo.1
            @Override // com.google.protobuf.Parser
            public AsterLittleDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AsterLittleDetailInfo(input, extensionRegistry);
            }
        };

        private AsterLittleDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AsterLittleDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.stageState_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AsterLittleDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AsterLittleDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 40:
                                this.stageState_ = input.readEnum();
                                break;
                            case 48:
                                this.beginTime_ = input.readUInt32();
                                break;
                            case 64:
                                this.isOpen_ = input.readBool();
                                break;
                            case 72:
                                this.stageBeginTime_ = input.readUInt32();
                                break;
                            case 112:
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
            return AsterLittleDetailInfoOuterClass.internal_static_AsterLittleDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AsterLittleDetailInfoOuterClass.internal_static_AsterLittleDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AsterLittleDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder
        public int getStageBeginTime() {
            return this.stageBeginTime_;
        }

        @Override // emu.grasscutter.net.proto.AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder
        public int getStageStateValue() {
            return this.stageState_;
        }

        @Override // emu.grasscutter.net.proto.AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder
        public AsterLittleStageStateOuterClass.AsterLittleStageState getStageState() {
            AsterLittleStageStateOuterClass.AsterLittleStageState result = AsterLittleStageStateOuterClass.AsterLittleStageState.valueOf(this.stageState_);
            return result == null ? AsterLittleStageStateOuterClass.AsterLittleStageState.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
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
            if (this.stageState_ != AsterLittleStageStateOuterClass.AsterLittleStageState.ASTER_LITTLE_STAGE_STATE_NONE.getNumber()) {
                output.writeEnum(5, this.stageState_);
            }
            if (this.beginTime_ != 0) {
                output.writeUInt32(6, this.beginTime_);
            }
            if (this.isOpen_) {
                output.writeBool(8, this.isOpen_);
            }
            if (this.stageBeginTime_ != 0) {
                output.writeUInt32(9, this.stageBeginTime_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(14, this.stageId_);
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
            if (this.stageState_ != AsterLittleStageStateOuterClass.AsterLittleStageState.ASTER_LITTLE_STAGE_STATE_NONE.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(5, this.stageState_);
            }
            if (this.beginTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.beginTime_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isOpen_);
            }
            if (this.stageBeginTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.stageBeginTime_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.stageId_);
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
            if (!(obj instanceof AsterLittleDetailInfo)) {
                return equals(obj);
            }
            AsterLittleDetailInfo other = (AsterLittleDetailInfo) obj;
            return getStageBeginTime() == other.getStageBeginTime() && getIsOpen() == other.getIsOpen() && this.stageState_ == other.stageState_ && getStageId() == other.getStageId() && getBeginTime() == other.getBeginTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getStageBeginTime())) + 8)) + Internal.hashBoolean(getIsOpen()))) + 5)) + this.stageState_)) + 14)) + getStageId())) + 6)) + getBeginTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AsterLittleDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AsterLittleDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AsterLittleDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AsterLittleDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AsterLittleDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AsterLittleDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AsterLittleDetailInfo parseFrom(InputStream input) throws IOException {
            return (AsterLittleDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AsterLittleDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AsterLittleDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AsterLittleDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AsterLittleDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AsterLittleDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AsterLittleDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AsterLittleDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (AsterLittleDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AsterLittleDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AsterLittleDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AsterLittleDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterLittleDetailInfoOuterClass$AsterLittleDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AsterLittleDetailInfoOrBuilder {
            private int stageBeginTime_;
            private boolean isOpen_;
            private int stageState_ = 0;
            private int stageId_;
            private int beginTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AsterLittleDetailInfoOuterClass.internal_static_AsterLittleDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AsterLittleDetailInfoOuterClass.internal_static_AsterLittleDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AsterLittleDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AsterLittleDetailInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.stageBeginTime_ = 0;
                this.isOpen_ = false;
                this.stageState_ = 0;
                this.stageId_ = 0;
                this.beginTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AsterLittleDetailInfoOuterClass.internal_static_AsterLittleDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AsterLittleDetailInfo getDefaultInstanceForType() {
                return AsterLittleDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AsterLittleDetailInfo build() {
                AsterLittleDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AsterLittleDetailInfo buildPartial() {
                AsterLittleDetailInfo result = new AsterLittleDetailInfo(this);
                result.stageBeginTime_ = this.stageBeginTime_;
                result.isOpen_ = this.isOpen_;
                result.stageState_ = this.stageState_;
                result.stageId_ = this.stageId_;
                result.beginTime_ = this.beginTime_;
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
                if (other instanceof AsterLittleDetailInfo) {
                    return mergeFrom((AsterLittleDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AsterLittleDetailInfo other) {
                if (other == AsterLittleDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getStageBeginTime() != 0) {
                    setStageBeginTime(other.getStageBeginTime());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.stageState_ != 0) {
                    setStageStateValue(other.getStageStateValue());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
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
                AsterLittleDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AsterLittleDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AsterLittleDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder
            public int getStageBeginTime() {
                return this.stageBeginTime_;
            }

            public Builder setStageBeginTime(int value) {
                this.stageBeginTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearStageBeginTime() {
                this.stageBeginTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder
            public int getStageStateValue() {
                return this.stageState_;
            }

            public Builder setStageStateValue(int value) {
                this.stageState_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder
            public AsterLittleStageStateOuterClass.AsterLittleStageState getStageState() {
                AsterLittleStageStateOuterClass.AsterLittleStageState result = AsterLittleStageStateOuterClass.AsterLittleStageState.valueOf(this.stageState_);
                return result == null ? AsterLittleStageStateOuterClass.AsterLittleStageState.UNRECOGNIZED : result;
            }

            public Builder setStageState(AsterLittleStageStateOuterClass.AsterLittleStageState value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.stageState_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearStageState() {
                this.stageState_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder
            public int getBeginTime() {
                return this.beginTime_;
            }

            public Builder setBeginTime(int value) {
                this.beginTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearBeginTime() {
                this.beginTime_ = 0;
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

        public static AsterLittleDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AsterLittleDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AsterLittleDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AsterLittleDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AsterLittleStageStateOuterClass.getDescriptor();
    }
}
