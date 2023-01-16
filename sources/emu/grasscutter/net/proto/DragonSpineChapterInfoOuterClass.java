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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DragonSpineChapterInfoOuterClass.class */
public final class DragonSpineChapterInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cDragonSpineChapterInfo.proto\"\u0001\n\u0016DragonSpineChapterInfo\u0012\u0011\n\topen_time\u0018\u0001 \u0001(\r\u0012\u0010\n\bprogress\u0018\f \u0001(\r\u0012\u0012\n\nchapter_id\u0018\u0006 \u0001(\r\u0012\u001c\n\u0014finished_mission_num\u0018\u0005 \u0001(\r\u0012\u000f\n\u0007is_open\u0018\u0002 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_DragonSpineChapterInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DragonSpineChapterInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DragonSpineChapterInfo_descriptor, new String[]{"OpenTime", "Progress", "ChapterId", "FinishedMissionNum", "IsOpen"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DragonSpineChapterInfoOuterClass$DragonSpineChapterInfoOrBuilder.class */
    public interface DragonSpineChapterInfoOrBuilder extends MessageOrBuilder {
        int getOpenTime();

        int getProgress();

        int getChapterId();

        int getFinishedMissionNum();

        boolean getIsOpen();
    }

    private DragonSpineChapterInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DragonSpineChapterInfoOuterClass$DragonSpineChapterInfo.class */
    public static final class DragonSpineChapterInfo extends GeneratedMessageV3 implements DragonSpineChapterInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OPEN_TIME_FIELD_NUMBER = 1;
        private int openTime_;
        public static final int PROGRESS_FIELD_NUMBER = 12;
        private int progress_;
        public static final int CHAPTER_ID_FIELD_NUMBER = 6;
        private int chapterId_;
        public static final int FINISHED_MISSION_NUM_FIELD_NUMBER = 5;
        private int finishedMissionNum_;
        public static final int IS_OPEN_FIELD_NUMBER = 2;
        private boolean isOpen_;
        private byte memoizedIsInitialized;
        private static final DragonSpineChapterInfo DEFAULT_INSTANCE = new DragonSpineChapterInfo();
        private static final Parser<DragonSpineChapterInfo> PARSER = new AbstractParser<DragonSpineChapterInfo>() { // from class: emu.grasscutter.net.proto.DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo.1
            @Override // com.google.protobuf.Parser
            public DragonSpineChapterInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DragonSpineChapterInfo(input, extensionRegistry);
            }
        };

        private DragonSpineChapterInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DragonSpineChapterInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DragonSpineChapterInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DragonSpineChapterInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.openTime_ = input.readUInt32();
                                break;
                            case 16:
                                this.isOpen_ = input.readBool();
                                break;
                            case 40:
                                this.finishedMissionNum_ = input.readUInt32();
                                break;
                            case 48:
                                this.chapterId_ = input.readUInt32();
                                break;
                            case 96:
                                this.progress_ = input.readUInt32();
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
            return DragonSpineChapterInfoOuterClass.internal_static_DragonSpineChapterInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DragonSpineChapterInfoOuterClass.internal_static_DragonSpineChapterInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DragonSpineChapterInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder
        public int getProgress() {
            return this.progress_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder
        public int getChapterId() {
            return this.chapterId_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder
        public int getFinishedMissionNum() {
            return this.finishedMissionNum_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder
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
            if (this.openTime_ != 0) {
                output.writeUInt32(1, this.openTime_);
            }
            if (this.isOpen_) {
                output.writeBool(2, this.isOpen_);
            }
            if (this.finishedMissionNum_ != 0) {
                output.writeUInt32(5, this.finishedMissionNum_);
            }
            if (this.chapterId_ != 0) {
                output.writeUInt32(6, this.chapterId_);
            }
            if (this.progress_ != 0) {
                output.writeUInt32(12, this.progress_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.openTime_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.isOpen_);
            }
            if (this.finishedMissionNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.finishedMissionNum_);
            }
            if (this.chapterId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.chapterId_);
            }
            if (this.progress_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.progress_);
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
            if (!(obj instanceof DragonSpineChapterInfo)) {
                return equals(obj);
            }
            DragonSpineChapterInfo other = (DragonSpineChapterInfo) obj;
            return getOpenTime() == other.getOpenTime() && getProgress() == other.getProgress() && getChapterId() == other.getChapterId() && getFinishedMissionNum() == other.getFinishedMissionNum() && getIsOpen() == other.getIsOpen() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getOpenTime())) + 12)) + getProgress())) + 6)) + getChapterId())) + 5)) + getFinishedMissionNum())) + 2)) + Internal.hashBoolean(getIsOpen()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static DragonSpineChapterInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DragonSpineChapterInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DragonSpineChapterInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DragonSpineChapterInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DragonSpineChapterInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DragonSpineChapterInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DragonSpineChapterInfo parseFrom(InputStream input) throws IOException {
            return (DragonSpineChapterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DragonSpineChapterInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DragonSpineChapterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DragonSpineChapterInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DragonSpineChapterInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DragonSpineChapterInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DragonSpineChapterInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DragonSpineChapterInfo parseFrom(CodedInputStream input) throws IOException {
            return (DragonSpineChapterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DragonSpineChapterInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DragonSpineChapterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DragonSpineChapterInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DragonSpineChapterInfoOuterClass$DragonSpineChapterInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DragonSpineChapterInfoOrBuilder {
            private int openTime_;
            private int progress_;
            private int chapterId_;
            private int finishedMissionNum_;
            private boolean isOpen_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DragonSpineChapterInfoOuterClass.internal_static_DragonSpineChapterInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DragonSpineChapterInfoOuterClass.internal_static_DragonSpineChapterInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DragonSpineChapterInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DragonSpineChapterInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.openTime_ = 0;
                this.progress_ = 0;
                this.chapterId_ = 0;
                this.finishedMissionNum_ = 0;
                this.isOpen_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DragonSpineChapterInfoOuterClass.internal_static_DragonSpineChapterInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DragonSpineChapterInfo getDefaultInstanceForType() {
                return DragonSpineChapterInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DragonSpineChapterInfo build() {
                DragonSpineChapterInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DragonSpineChapterInfo buildPartial() {
                DragonSpineChapterInfo result = new DragonSpineChapterInfo(this);
                result.openTime_ = this.openTime_;
                result.progress_ = this.progress_;
                result.chapterId_ = this.chapterId_;
                result.finishedMissionNum_ = this.finishedMissionNum_;
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
                if (other instanceof DragonSpineChapterInfo) {
                    return mergeFrom((DragonSpineChapterInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DragonSpineChapterInfo other) {
                if (other == DragonSpineChapterInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.getProgress() != 0) {
                    setProgress(other.getProgress());
                }
                if (other.getChapterId() != 0) {
                    setChapterId(other.getChapterId());
                }
                if (other.getFinishedMissionNum() != 0) {
                    setFinishedMissionNum(other.getFinishedMissionNum());
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
                DragonSpineChapterInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = DragonSpineChapterInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DragonSpineChapterInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder
            public int getChapterId() {
                return this.chapterId_;
            }

            public Builder setChapterId(int value) {
                this.chapterId_ = value;
                onChanged();
                return this;
            }

            public Builder clearChapterId() {
                this.chapterId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder
            public int getFinishedMissionNum() {
                return this.finishedMissionNum_;
            }

            public Builder setFinishedMissionNum(int value) {
                this.finishedMissionNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearFinishedMissionNum() {
                this.finishedMissionNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder
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

        public static DragonSpineChapterInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DragonSpineChapterInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DragonSpineChapterInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DragonSpineChapterInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
