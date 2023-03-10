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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HachiStageInfoOuterClass.class */
public final class HachiStageInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014HachiStageInfo.proto\"W\n\u000eHachiStageInfo\u0012\u0010\n\bopenTime\u0018\n \u0001(\r\u0012\u0012\n\nisFinished\u0018\f \u0001(\b\u0012\u000f\n\u0007stageId\u0018\r \u0001(\r\u0012\u000e\n\u0006isOpen\u0018\u0003 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_HachiStageInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HachiStageInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HachiStageInfo_descriptor, new String[]{"OpenTime", "IsFinished", "StageId", "IsOpen"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HachiStageInfoOuterClass$HachiStageInfoOrBuilder.class */
    public interface HachiStageInfoOrBuilder extends MessageOrBuilder {
        int getOpenTime();

        boolean getIsFinished();

        int getStageId();

        boolean getIsOpen();
    }

    private HachiStageInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HachiStageInfoOuterClass$HachiStageInfo.class */
    public static final class HachiStageInfo extends GeneratedMessageV3 implements HachiStageInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OPENTIME_FIELD_NUMBER = 10;
        private int openTime_;
        public static final int ISFINISHED_FIELD_NUMBER = 12;
        private boolean isFinished_;
        public static final int STAGEID_FIELD_NUMBER = 13;
        private int stageId_;
        public static final int ISOPEN_FIELD_NUMBER = 3;
        private boolean isOpen_;
        private byte memoizedIsInitialized;
        private static final HachiStageInfo DEFAULT_INSTANCE = new HachiStageInfo();
        private static final Parser<HachiStageInfo> PARSER = new AbstractParser<HachiStageInfo>() { // from class: emu.grasscutter.net.proto.HachiStageInfoOuterClass.HachiStageInfo.1
            @Override // com.google.protobuf.Parser
            public HachiStageInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HachiStageInfo(input, extensionRegistry);
            }
        };

        private HachiStageInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HachiStageInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HachiStageInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HachiStageInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.isOpen_ = input.readBool();
                                    break;
                                case 80:
                                    this.openTime_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.isFinished_ = input.readBool();
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
            return HachiStageInfoOuterClass.internal_static_HachiStageInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HachiStageInfoOuterClass.internal_static_HachiStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HachiStageInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HachiStageInfoOuterClass.HachiStageInfoOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.HachiStageInfoOuterClass.HachiStageInfoOrBuilder
        public boolean getIsFinished() {
            return this.isFinished_;
        }

        @Override // emu.grasscutter.net.proto.HachiStageInfoOuterClass.HachiStageInfoOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.HachiStageInfoOuterClass.HachiStageInfoOrBuilder
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
                output.writeBool(3, this.isOpen_);
            }
            if (this.openTime_ != 0) {
                output.writeUInt32(10, this.openTime_);
            }
            if (this.isFinished_) {
                output.writeBool(12, this.isFinished_);
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
            if (this.isOpen_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(3, this.isOpen_);
            }
            if (this.openTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.openTime_);
            }
            if (this.isFinished_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isFinished_);
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
            if (!(obj instanceof HachiStageInfo)) {
                return equals(obj);
            }
            HachiStageInfo other = (HachiStageInfo) obj;
            return getOpenTime() == other.getOpenTime() && getIsFinished() == other.getIsFinished() && getStageId() == other.getStageId() && getIsOpen() == other.getIsOpen() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getOpenTime())) + 12)) + Internal.hashBoolean(getIsFinished()))) + 13)) + getStageId())) + 3)) + Internal.hashBoolean(getIsOpen()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static HachiStageInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HachiStageInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HachiStageInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HachiStageInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HachiStageInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HachiStageInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HachiStageInfo parseFrom(InputStream input) throws IOException {
            return (HachiStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HachiStageInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HachiStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HachiStageInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (HachiStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HachiStageInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HachiStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HachiStageInfo parseFrom(CodedInputStream input) throws IOException {
            return (HachiStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HachiStageInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HachiStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HachiStageInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HachiStageInfoOuterClass$HachiStageInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HachiStageInfoOrBuilder {
            private int openTime_;
            private boolean isFinished_;
            private int stageId_;
            private boolean isOpen_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HachiStageInfoOuterClass.internal_static_HachiStageInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HachiStageInfoOuterClass.internal_static_HachiStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HachiStageInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HachiStageInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.openTime_ = 0;
                this.isFinished_ = false;
                this.stageId_ = 0;
                this.isOpen_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HachiStageInfoOuterClass.internal_static_HachiStageInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HachiStageInfo getDefaultInstanceForType() {
                return HachiStageInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HachiStageInfo build() {
                HachiStageInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HachiStageInfo buildPartial() {
                HachiStageInfo result = new HachiStageInfo(this);
                result.openTime_ = this.openTime_;
                result.isFinished_ = this.isFinished_;
                result.stageId_ = this.stageId_;
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
                if (other instanceof HachiStageInfo) {
                    return mergeFrom((HachiStageInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HachiStageInfo other) {
                if (other == HachiStageInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.getIsFinished()) {
                    setIsFinished(other.getIsFinished());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
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
                HachiStageInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = HachiStageInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HachiStageInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HachiStageInfoOuterClass.HachiStageInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.HachiStageInfoOuterClass.HachiStageInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.HachiStageInfoOuterClass.HachiStageInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.HachiStageInfoOuterClass.HachiStageInfoOrBuilder
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

        public static HachiStageInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HachiStageInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HachiStageInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HachiStageInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
