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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.RogueDiaryDungeonRecordOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryStageInfoOuterClass.class */
public final class RogueDiaryStageInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019RogueDiaryStageInfo.proto\u001a\u001dRogueDiaryDungeonRecord.proto\"k\n\u0013RogueDiaryStageInfo\u0012\u0010\n\bstage_id\u0018\u000f \u0001(\r\u0012-\n\u000bbest_record\u0018\t \u0001(\u000b2\u0018.RogueDiaryDungeonRecord\u0012\u0013\n\u000bis_have_try\u0018\u000b \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{RogueDiaryDungeonRecordOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_RogueDiaryStageInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RogueDiaryStageInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RogueDiaryStageInfo_descriptor, new String[]{"StageId", "BestRecord", "IsHaveTry"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryStageInfoOuterClass$RogueDiaryStageInfoOrBuilder.class */
    public interface RogueDiaryStageInfoOrBuilder extends MessageOrBuilder {
        int getStageId();

        boolean hasBestRecord();

        RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord getBestRecord();

        RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecordOrBuilder getBestRecordOrBuilder();

        boolean getIsHaveTry();
    }

    private RogueDiaryStageInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryStageInfoOuterClass$RogueDiaryStageInfo.class */
    public static final class RogueDiaryStageInfo extends GeneratedMessageV3 implements RogueDiaryStageInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGE_ID_FIELD_NUMBER = 15;
        private int stageId_;
        public static final int BEST_RECORD_FIELD_NUMBER = 9;
        private RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord bestRecord_;
        public static final int IS_HAVE_TRY_FIELD_NUMBER = 11;
        private boolean isHaveTry_;
        private byte memoizedIsInitialized;
        private static final RogueDiaryStageInfo DEFAULT_INSTANCE = new RogueDiaryStageInfo();
        private static final Parser<RogueDiaryStageInfo> PARSER = new AbstractParser<RogueDiaryStageInfo>() { // from class: emu.grasscutter.net.proto.RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo.1
            @Override // com.google.protobuf.Parser
            public RogueDiaryStageInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RogueDiaryStageInfo(input, extensionRegistry);
            }
        };

        private RogueDiaryStageInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RogueDiaryStageInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RogueDiaryStageInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RogueDiaryStageInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 74:
                                    RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord.Builder subBuilder = this.bestRecord_ != null ? this.bestRecord_.toBuilder() : null;
                                    this.bestRecord_ = (RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord) input.readMessage(RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.bestRecord_);
                                        this.bestRecord_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 88:
                                    this.isHaveTry_ = input.readBool();
                                    break;
                                case 120:
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
            return RogueDiaryStageInfoOuterClass.internal_static_RogueDiaryStageInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RogueDiaryStageInfoOuterClass.internal_static_RogueDiaryStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueDiaryStageInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder
        public boolean hasBestRecord() {
            return this.bestRecord_ != null;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder
        public RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord getBestRecord() {
            return this.bestRecord_ == null ? RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord.getDefaultInstance() : this.bestRecord_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder
        public RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecordOrBuilder getBestRecordOrBuilder() {
            return getBestRecord();
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder
        public boolean getIsHaveTry() {
            return this.isHaveTry_;
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
            if (this.bestRecord_ != null) {
                output.writeMessage(9, getBestRecord());
            }
            if (this.isHaveTry_) {
                output.writeBool(11, this.isHaveTry_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(15, this.stageId_);
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
            if (this.bestRecord_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(9, getBestRecord());
            }
            if (this.isHaveTry_) {
                size2 += CodedOutputStream.computeBoolSize(11, this.isHaveTry_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.stageId_);
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
            if (!(obj instanceof RogueDiaryStageInfo)) {
                return equals(obj);
            }
            RogueDiaryStageInfo other = (RogueDiaryStageInfo) obj;
            if (getStageId() == other.getStageId() && hasBestRecord() == other.hasBestRecord()) {
                return (!hasBestRecord() || getBestRecord().equals(other.getBestRecord())) && getIsHaveTry() == other.getIsHaveTry() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getStageId();
            if (hasBestRecord()) {
                hash = (53 * ((37 * hash) + 9)) + getBestRecord().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 11)) + Internal.hashBoolean(getIsHaveTry()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static RogueDiaryStageInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryStageInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryStageInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryStageInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryStageInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryStageInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryStageInfo parseFrom(InputStream input) throws IOException {
            return (RogueDiaryStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueDiaryStageInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueDiaryStageInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (RogueDiaryStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RogueDiaryStageInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueDiaryStageInfo parseFrom(CodedInputStream input) throws IOException {
            return (RogueDiaryStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueDiaryStageInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RogueDiaryStageInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryStageInfoOuterClass$RogueDiaryStageInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RogueDiaryStageInfoOrBuilder {
            private int stageId_;
            private RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord bestRecord_;
            private SingleFieldBuilderV3<RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord, RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord.Builder, RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecordOrBuilder> bestRecordBuilder_;
            private boolean isHaveTry_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RogueDiaryStageInfoOuterClass.internal_static_RogueDiaryStageInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RogueDiaryStageInfoOuterClass.internal_static_RogueDiaryStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueDiaryStageInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RogueDiaryStageInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.stageId_ = 0;
                if (this.bestRecordBuilder_ == null) {
                    this.bestRecord_ = null;
                } else {
                    this.bestRecord_ = null;
                    this.bestRecordBuilder_ = null;
                }
                this.isHaveTry_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RogueDiaryStageInfoOuterClass.internal_static_RogueDiaryStageInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RogueDiaryStageInfo getDefaultInstanceForType() {
                return RogueDiaryStageInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueDiaryStageInfo build() {
                RogueDiaryStageInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueDiaryStageInfo buildPartial() {
                RogueDiaryStageInfo result = new RogueDiaryStageInfo(this);
                result.stageId_ = this.stageId_;
                if (this.bestRecordBuilder_ == null) {
                    result.bestRecord_ = this.bestRecord_;
                } else {
                    result.bestRecord_ = this.bestRecordBuilder_.build();
                }
                result.isHaveTry_ = this.isHaveTry_;
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
                if (other instanceof RogueDiaryStageInfo) {
                    return mergeFrom((RogueDiaryStageInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RogueDiaryStageInfo other) {
                if (other == RogueDiaryStageInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.hasBestRecord()) {
                    mergeBestRecord(other.getBestRecord());
                }
                if (other.getIsHaveTry()) {
                    setIsHaveTry(other.getIsHaveTry());
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
                RogueDiaryStageInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = RogueDiaryStageInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RogueDiaryStageInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder
            public boolean hasBestRecord() {
                return (this.bestRecordBuilder_ == null && this.bestRecord_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder
            public RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord getBestRecord() {
                if (this.bestRecordBuilder_ == null) {
                    return this.bestRecord_ == null ? RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord.getDefaultInstance() : this.bestRecord_;
                }
                return this.bestRecordBuilder_.getMessage();
            }

            public Builder setBestRecord(RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord value) {
                if (this.bestRecordBuilder_ != null) {
                    this.bestRecordBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.bestRecord_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setBestRecord(RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord.Builder builderForValue) {
                if (this.bestRecordBuilder_ == null) {
                    this.bestRecord_ = builderForValue.build();
                    onChanged();
                } else {
                    this.bestRecordBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeBestRecord(RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord value) {
                if (this.bestRecordBuilder_ == null) {
                    if (this.bestRecord_ != null) {
                        this.bestRecord_ = RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord.newBuilder(this.bestRecord_).mergeFrom(value).buildPartial();
                    } else {
                        this.bestRecord_ = value;
                    }
                    onChanged();
                } else {
                    this.bestRecordBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearBestRecord() {
                if (this.bestRecordBuilder_ == null) {
                    this.bestRecord_ = null;
                    onChanged();
                } else {
                    this.bestRecord_ = null;
                    this.bestRecordBuilder_ = null;
                }
                return this;
            }

            public RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord.Builder getBestRecordBuilder() {
                onChanged();
                return getBestRecordFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder
            public RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecordOrBuilder getBestRecordOrBuilder() {
                if (this.bestRecordBuilder_ != null) {
                    return this.bestRecordBuilder_.getMessageOrBuilder();
                }
                return this.bestRecord_ == null ? RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord.getDefaultInstance() : this.bestRecord_;
            }

            private SingleFieldBuilderV3<RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord, RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecord.Builder, RogueDiaryDungeonRecordOuterClass.RogueDiaryDungeonRecordOrBuilder> getBestRecordFieldBuilder() {
                if (this.bestRecordBuilder_ == null) {
                    this.bestRecordBuilder_ = new SingleFieldBuilderV3<>(getBestRecord(), getParentForChildren(), isClean());
                    this.bestRecord_ = null;
                }
                return this.bestRecordBuilder_;
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder
            public boolean getIsHaveTry() {
                return this.isHaveTry_;
            }

            public Builder setIsHaveTry(boolean value) {
                this.isHaveTry_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsHaveTry() {
                this.isHaveTry_ = false;
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

        public static RogueDiaryStageInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RogueDiaryStageInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RogueDiaryStageInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RogueDiaryStageInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        RogueDiaryDungeonRecordOuterClass.getDescriptor();
    }
}
