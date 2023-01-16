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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2DungeonStageInfoOuterClass.class */
public final class SummerTimeV2DungeonStageInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"SummerTimeV2DungeonStageInfo.proto\"u\n\u001cSummerTimeV2DungeonStageInfo\u0012\u000f\n\u0007is_open\u0018\u0006 \u0001(\b\u0012\u0010\n\bstage_id\u0018\u0003 \u0001(\r\u0012\u001f\n\u0017is_prev_dungeon_succeed\u0018\f \u0001(\b\u0012\u0011\n\topen_time\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SummerTimeV2DungeonStageInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SummerTimeV2DungeonStageInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SummerTimeV2DungeonStageInfo_descriptor, new String[]{"IsOpen", "StageId", "IsPrevDungeonSucceed", "OpenTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2DungeonStageInfoOuterClass$SummerTimeV2DungeonStageInfoOrBuilder.class */
    public interface SummerTimeV2DungeonStageInfoOrBuilder extends MessageOrBuilder {
        boolean getIsOpen();

        int getStageId();

        boolean getIsPrevDungeonSucceed();

        int getOpenTime();
    }

    private SummerTimeV2DungeonStageInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2DungeonStageInfoOuterClass$SummerTimeV2DungeonStageInfo.class */
    public static final class SummerTimeV2DungeonStageInfo extends GeneratedMessageV3 implements SummerTimeV2DungeonStageInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_OPEN_FIELD_NUMBER = 6;
        private boolean isOpen_;
        public static final int STAGE_ID_FIELD_NUMBER = 3;
        private int stageId_;
        public static final int IS_PREV_DUNGEON_SUCCEED_FIELD_NUMBER = 12;
        private boolean isPrevDungeonSucceed_;
        public static final int OPEN_TIME_FIELD_NUMBER = 2;
        private int openTime_;
        private byte memoizedIsInitialized;
        private static final SummerTimeV2DungeonStageInfo DEFAULT_INSTANCE = new SummerTimeV2DungeonStageInfo();
        private static final Parser<SummerTimeV2DungeonStageInfo> PARSER = new AbstractParser<SummerTimeV2DungeonStageInfo>() { // from class: emu.grasscutter.net.proto.SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo.1
            @Override // com.google.protobuf.Parser
            public SummerTimeV2DungeonStageInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SummerTimeV2DungeonStageInfo(input, extensionRegistry);
            }
        };

        private SummerTimeV2DungeonStageInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SummerTimeV2DungeonStageInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SummerTimeV2DungeonStageInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SummerTimeV2DungeonStageInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.openTime_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.stageId_ = input.readUInt32();
                                    break;
                                case 48:
                                    this.isOpen_ = input.readBool();
                                    break;
                                case 96:
                                    this.isPrevDungeonSucceed_ = input.readBool();
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
            return SummerTimeV2DungeonStageInfoOuterClass.internal_static_SummerTimeV2DungeonStageInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SummerTimeV2DungeonStageInfoOuterClass.internal_static_SummerTimeV2DungeonStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeV2DungeonStageInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder
        public boolean getIsPrevDungeonSucceed() {
            return this.isPrevDungeonSucceed_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder
        public int getOpenTime() {
            return this.openTime_;
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
            if (this.openTime_ != 0) {
                output.writeUInt32(2, this.openTime_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(3, this.stageId_);
            }
            if (this.isOpen_) {
                output.writeBool(6, this.isOpen_);
            }
            if (this.isPrevDungeonSucceed_) {
                output.writeBool(12, this.isPrevDungeonSucceed_);
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
            if (this.openTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.openTime_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.stageId_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isOpen_);
            }
            if (this.isPrevDungeonSucceed_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isPrevDungeonSucceed_);
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
            if (!(obj instanceof SummerTimeV2DungeonStageInfo)) {
                return equals(obj);
            }
            SummerTimeV2DungeonStageInfo other = (SummerTimeV2DungeonStageInfo) obj;
            return getIsOpen() == other.getIsOpen() && getStageId() == other.getStageId() && getIsPrevDungeonSucceed() == other.getIsPrevDungeonSucceed() && getOpenTime() == other.getOpenTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + Internal.hashBoolean(getIsOpen()))) + 3)) + getStageId())) + 12)) + Internal.hashBoolean(getIsPrevDungeonSucceed()))) + 2)) + getOpenTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SummerTimeV2DungeonStageInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeV2DungeonStageInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeV2DungeonStageInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeV2DungeonStageInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeV2DungeonStageInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeV2DungeonStageInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeV2DungeonStageInfo parseFrom(InputStream input) throws IOException {
            return (SummerTimeV2DungeonStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeV2DungeonStageInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeV2DungeonStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeV2DungeonStageInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SummerTimeV2DungeonStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SummerTimeV2DungeonStageInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeV2DungeonStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeV2DungeonStageInfo parseFrom(CodedInputStream input) throws IOException {
            return (SummerTimeV2DungeonStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeV2DungeonStageInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeV2DungeonStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SummerTimeV2DungeonStageInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2DungeonStageInfoOuterClass$SummerTimeV2DungeonStageInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SummerTimeV2DungeonStageInfoOrBuilder {
            private boolean isOpen_;
            private int stageId_;
            private boolean isPrevDungeonSucceed_;
            private int openTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SummerTimeV2DungeonStageInfoOuterClass.internal_static_SummerTimeV2DungeonStageInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SummerTimeV2DungeonStageInfoOuterClass.internal_static_SummerTimeV2DungeonStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeV2DungeonStageInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SummerTimeV2DungeonStageInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isOpen_ = false;
                this.stageId_ = 0;
                this.isPrevDungeonSucceed_ = false;
                this.openTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SummerTimeV2DungeonStageInfoOuterClass.internal_static_SummerTimeV2DungeonStageInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SummerTimeV2DungeonStageInfo getDefaultInstanceForType() {
                return SummerTimeV2DungeonStageInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeV2DungeonStageInfo build() {
                SummerTimeV2DungeonStageInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeV2DungeonStageInfo buildPartial() {
                SummerTimeV2DungeonStageInfo result = new SummerTimeV2DungeonStageInfo(this);
                result.isOpen_ = this.isOpen_;
                result.stageId_ = this.stageId_;
                result.isPrevDungeonSucceed_ = this.isPrevDungeonSucceed_;
                result.openTime_ = this.openTime_;
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
                if (other instanceof SummerTimeV2DungeonStageInfo) {
                    return mergeFrom((SummerTimeV2DungeonStageInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SummerTimeV2DungeonStageInfo other) {
                if (other == SummerTimeV2DungeonStageInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getIsPrevDungeonSucceed()) {
                    setIsPrevDungeonSucceed(other.getIsPrevDungeonSucceed());
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
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
                SummerTimeV2DungeonStageInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SummerTimeV2DungeonStageInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SummerTimeV2DungeonStageInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder
            public boolean getIsPrevDungeonSucceed() {
                return this.isPrevDungeonSucceed_;
            }

            public Builder setIsPrevDungeonSucceed(boolean value) {
                this.isPrevDungeonSucceed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsPrevDungeonSucceed() {
                this.isPrevDungeonSucceed_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static SummerTimeV2DungeonStageInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SummerTimeV2DungeonStageInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SummerTimeV2DungeonStageInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SummerTimeV2DungeonStageInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
