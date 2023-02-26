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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2BoatStageInfoOuterClass.class */
public final class SummerTimeV2BoatStageInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fSummerTimeV2BoatStageInfo.proto\"a\n\u0019SummerTimeV2BoatStageInfo\u0012\u0010\n\bopenTime\u0018\u0003 \u0001(\r\u0012\u000e\n\u0006isOpen\u0018\u000e \u0001(\b\u0012\u000f\n\u0007stageId\u0018\u0002 \u0001(\r\u0012\u0011\n\tbestScore\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SummerTimeV2BoatStageInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SummerTimeV2BoatStageInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SummerTimeV2BoatStageInfo_descriptor, new String[]{"OpenTime", "IsOpen", "StageId", "BestScore"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2BoatStageInfoOuterClass$SummerTimeV2BoatStageInfoOrBuilder.class */
    public interface SummerTimeV2BoatStageInfoOrBuilder extends MessageOrBuilder {
        int getOpenTime();

        boolean getIsOpen();

        int getStageId();

        int getBestScore();
    }

    private SummerTimeV2BoatStageInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2BoatStageInfoOuterClass$SummerTimeV2BoatStageInfo.class */
    public static final class SummerTimeV2BoatStageInfo extends GeneratedMessageV3 implements SummerTimeV2BoatStageInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OPENTIME_FIELD_NUMBER = 3;
        private int openTime_;
        public static final int ISOPEN_FIELD_NUMBER = 14;
        private boolean isOpen_;
        public static final int STAGEID_FIELD_NUMBER = 2;
        private int stageId_;
        public static final int BESTSCORE_FIELD_NUMBER = 4;
        private int bestScore_;
        private byte memoizedIsInitialized;
        private static final SummerTimeV2BoatStageInfo DEFAULT_INSTANCE = new SummerTimeV2BoatStageInfo();
        private static final Parser<SummerTimeV2BoatStageInfo> PARSER = new AbstractParser<SummerTimeV2BoatStageInfo>() { // from class: emu.grasscutter.net.proto.SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo.1
            @Override // com.google.protobuf.Parser
            public SummerTimeV2BoatStageInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SummerTimeV2BoatStageInfo(input, extensionRegistry);
            }
        };

        private SummerTimeV2BoatStageInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SummerTimeV2BoatStageInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SummerTimeV2BoatStageInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SummerTimeV2BoatStageInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.stageId_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.openTime_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.bestScore_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.isOpen_ = input.readBool();
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
            return SummerTimeV2BoatStageInfoOuterClass.internal_static_SummerTimeV2BoatStageInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SummerTimeV2BoatStageInfoOuterClass.internal_static_SummerTimeV2BoatStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeV2BoatStageInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder
        public int getBestScore() {
            return this.bestScore_;
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
            if (this.stageId_ != 0) {
                output.writeUInt32(2, this.stageId_);
            }
            if (this.openTime_ != 0) {
                output.writeUInt32(3, this.openTime_);
            }
            if (this.bestScore_ != 0) {
                output.writeUInt32(4, this.bestScore_);
            }
            if (this.isOpen_) {
                output.writeBool(14, this.isOpen_);
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
            if (this.stageId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.stageId_);
            }
            if (this.openTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.openTime_);
            }
            if (this.bestScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.bestScore_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.isOpen_);
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
            if (!(obj instanceof SummerTimeV2BoatStageInfo)) {
                return equals(obj);
            }
            SummerTimeV2BoatStageInfo other = (SummerTimeV2BoatStageInfo) obj;
            return getOpenTime() == other.getOpenTime() && getIsOpen() == other.getIsOpen() && getStageId() == other.getStageId() && getBestScore() == other.getBestScore() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getOpenTime())) + 14)) + Internal.hashBoolean(getIsOpen()))) + 2)) + getStageId())) + 4)) + getBestScore())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SummerTimeV2BoatStageInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeV2BoatStageInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeV2BoatStageInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeV2BoatStageInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeV2BoatStageInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeV2BoatStageInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeV2BoatStageInfo parseFrom(InputStream input) throws IOException {
            return (SummerTimeV2BoatStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeV2BoatStageInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeV2BoatStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeV2BoatStageInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SummerTimeV2BoatStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SummerTimeV2BoatStageInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeV2BoatStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeV2BoatStageInfo parseFrom(CodedInputStream input) throws IOException {
            return (SummerTimeV2BoatStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeV2BoatStageInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeV2BoatStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SummerTimeV2BoatStageInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2BoatStageInfoOuterClass$SummerTimeV2BoatStageInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SummerTimeV2BoatStageInfoOrBuilder {
            private int openTime_;
            private boolean isOpen_;
            private int stageId_;
            private int bestScore_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SummerTimeV2BoatStageInfoOuterClass.internal_static_SummerTimeV2BoatStageInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SummerTimeV2BoatStageInfoOuterClass.internal_static_SummerTimeV2BoatStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeV2BoatStageInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SummerTimeV2BoatStageInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.openTime_ = 0;
                this.isOpen_ = false;
                this.stageId_ = 0;
                this.bestScore_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SummerTimeV2BoatStageInfoOuterClass.internal_static_SummerTimeV2BoatStageInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SummerTimeV2BoatStageInfo getDefaultInstanceForType() {
                return SummerTimeV2BoatStageInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeV2BoatStageInfo build() {
                SummerTimeV2BoatStageInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeV2BoatStageInfo buildPartial() {
                SummerTimeV2BoatStageInfo result = new SummerTimeV2BoatStageInfo(this);
                result.openTime_ = this.openTime_;
                result.isOpen_ = this.isOpen_;
                result.stageId_ = this.stageId_;
                result.bestScore_ = this.bestScore_;
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
                if (other instanceof SummerTimeV2BoatStageInfo) {
                    return mergeFrom((SummerTimeV2BoatStageInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SummerTimeV2BoatStageInfo other) {
                if (other == SummerTimeV2BoatStageInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getBestScore() != 0) {
                    setBestScore(other.getBestScore());
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
                SummerTimeV2BoatStageInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SummerTimeV2BoatStageInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SummerTimeV2BoatStageInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder
            public int getBestScore() {
                return this.bestScore_;
            }

            public Builder setBestScore(int value) {
                this.bestScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearBestScore() {
                this.bestScore_ = 0;
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

        public static SummerTimeV2BoatStageInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SummerTimeV2BoatStageInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SummerTimeV2BoatStageInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SummerTimeV2BoatStageInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
