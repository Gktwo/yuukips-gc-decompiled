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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairChapterInfoOuterClass.class */
public final class FleurFairChapterInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aFleurFairChapterInfo.proto\";\n\u0014FleurFairChapterInfo\u0012\u0010\n\bopenTime\u0018\n \u0001(\r\u0012\u0011\n\tchapterId\u0018\u000e \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FleurFairChapterInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FleurFairChapterInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FleurFairChapterInfo_descriptor, new String[]{"OpenTime", "ChapterId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairChapterInfoOuterClass$FleurFairChapterInfoOrBuilder.class */
    public interface FleurFairChapterInfoOrBuilder extends MessageOrBuilder {
        int getOpenTime();

        int getChapterId();
    }

    private FleurFairChapterInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairChapterInfoOuterClass$FleurFairChapterInfo.class */
    public static final class FleurFairChapterInfo extends GeneratedMessageV3 implements FleurFairChapterInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OPENTIME_FIELD_NUMBER = 10;
        private int openTime_;
        public static final int CHAPTERID_FIELD_NUMBER = 14;
        private int chapterId_;
        private byte memoizedIsInitialized;
        private static final FleurFairChapterInfo DEFAULT_INSTANCE = new FleurFairChapterInfo();
        private static final Parser<FleurFairChapterInfo> PARSER = new AbstractParser<FleurFairChapterInfo>() { // from class: emu.grasscutter.net.proto.FleurFairChapterInfoOuterClass.FleurFairChapterInfo.1
            @Override // com.google.protobuf.Parser
            public FleurFairChapterInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FleurFairChapterInfo(input, extensionRegistry);
            }
        };

        private FleurFairChapterInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FleurFairChapterInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FleurFairChapterInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FleurFairChapterInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 80:
                                this.openTime_ = input.readUInt32();
                                break;
                            case 112:
                                this.chapterId_ = input.readUInt32();
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
            return FleurFairChapterInfoOuterClass.internal_static_FleurFairChapterInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FleurFairChapterInfoOuterClass.internal_static_FleurFairChapterInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FleurFairChapterInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder
        public int getChapterId() {
            return this.chapterId_;
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
                output.writeUInt32(10, this.openTime_);
            }
            if (this.chapterId_ != 0) {
                output.writeUInt32(14, this.chapterId_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(10, this.openTime_);
            }
            if (this.chapterId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.chapterId_);
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
            if (!(obj instanceof FleurFairChapterInfo)) {
                return equals(obj);
            }
            FleurFairChapterInfo other = (FleurFairChapterInfo) obj;
            return getOpenTime() == other.getOpenTime() && getChapterId() == other.getChapterId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getOpenTime())) + 14)) + getChapterId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static FleurFairChapterInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairChapterInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairChapterInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairChapterInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairChapterInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairChapterInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairChapterInfo parseFrom(InputStream input) throws IOException {
            return (FleurFairChapterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FleurFairChapterInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairChapterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FleurFairChapterInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (FleurFairChapterInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FleurFairChapterInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairChapterInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FleurFairChapterInfo parseFrom(CodedInputStream input) throws IOException {
            return (FleurFairChapterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FleurFairChapterInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairChapterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FleurFairChapterInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairChapterInfoOuterClass$FleurFairChapterInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FleurFairChapterInfoOrBuilder {
            private int openTime_;
            private int chapterId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FleurFairChapterInfoOuterClass.internal_static_FleurFairChapterInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FleurFairChapterInfoOuterClass.internal_static_FleurFairChapterInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FleurFairChapterInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FleurFairChapterInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.openTime_ = 0;
                this.chapterId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FleurFairChapterInfoOuterClass.internal_static_FleurFairChapterInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FleurFairChapterInfo getDefaultInstanceForType() {
                return FleurFairChapterInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FleurFairChapterInfo build() {
                FleurFairChapterInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FleurFairChapterInfo buildPartial() {
                FleurFairChapterInfo result = new FleurFairChapterInfo(this);
                result.openTime_ = this.openTime_;
                result.chapterId_ = this.chapterId_;
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
                if (other instanceof FleurFairChapterInfo) {
                    return mergeFrom((FleurFairChapterInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FleurFairChapterInfo other) {
                if (other == FleurFairChapterInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.getChapterId() != 0) {
                    setChapterId(other.getChapterId());
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
                FleurFairChapterInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = FleurFairChapterInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FleurFairChapterInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static FleurFairChapterInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FleurFairChapterInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FleurFairChapterInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FleurFairChapterInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
