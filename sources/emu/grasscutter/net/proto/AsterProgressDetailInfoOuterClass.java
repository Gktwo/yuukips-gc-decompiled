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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterProgressDetailInfoOuterClass.class */
public final class AsterProgressDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dAsterProgressDetailInfo.proto\"A\n\u0017AsterProgressDetailInfo\u0012\u0017\n\u000flastAutoAddTime\u0018\u000e \u0001(\r\u0012\r\n\u0005count\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AsterProgressDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AsterProgressDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AsterProgressDetailInfo_descriptor, new String[]{"LastAutoAddTime", "Count"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterProgressDetailInfoOuterClass$AsterProgressDetailInfoOrBuilder.class */
    public interface AsterProgressDetailInfoOrBuilder extends MessageOrBuilder {
        int getLastAutoAddTime();

        int getCount();
    }

    private AsterProgressDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterProgressDetailInfoOuterClass$AsterProgressDetailInfo.class */
    public static final class AsterProgressDetailInfo extends GeneratedMessageV3 implements AsterProgressDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LASTAUTOADDTIME_FIELD_NUMBER = 14;
        private int lastAutoAddTime_;
        public static final int COUNT_FIELD_NUMBER = 8;
        private int count_;
        private byte memoizedIsInitialized;
        private static final AsterProgressDetailInfo DEFAULT_INSTANCE = new AsterProgressDetailInfo();
        private static final Parser<AsterProgressDetailInfo> PARSER = new AbstractParser<AsterProgressDetailInfo>() { // from class: emu.grasscutter.net.proto.AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo.1
            @Override // com.google.protobuf.Parser
            public AsterProgressDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AsterProgressDetailInfo(input, extensionRegistry);
            }
        };

        private AsterProgressDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AsterProgressDetailInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AsterProgressDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AsterProgressDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 64:
                                this.count_ = input.readUInt32();
                                break;
                            case 112:
                                this.lastAutoAddTime_ = input.readUInt32();
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
            return AsterProgressDetailInfoOuterClass.internal_static_AsterProgressDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AsterProgressDetailInfoOuterClass.internal_static_AsterProgressDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AsterProgressDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AsterProgressDetailInfoOuterClass.AsterProgressDetailInfoOrBuilder
        public int getLastAutoAddTime() {
            return this.lastAutoAddTime_;
        }

        @Override // emu.grasscutter.net.proto.AsterProgressDetailInfoOuterClass.AsterProgressDetailInfoOrBuilder
        public int getCount() {
            return this.count_;
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
            if (this.count_ != 0) {
                output.writeUInt32(8, this.count_);
            }
            if (this.lastAutoAddTime_ != 0) {
                output.writeUInt32(14, this.lastAutoAddTime_);
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
            if (this.count_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(8, this.count_);
            }
            if (this.lastAutoAddTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.lastAutoAddTime_);
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
            if (!(obj instanceof AsterProgressDetailInfo)) {
                return equals(obj);
            }
            AsterProgressDetailInfo other = (AsterProgressDetailInfo) obj;
            return getLastAutoAddTime() == other.getLastAutoAddTime() && getCount() == other.getCount() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getLastAutoAddTime())) + 8)) + getCount())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AsterProgressDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AsterProgressDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AsterProgressDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AsterProgressDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AsterProgressDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AsterProgressDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AsterProgressDetailInfo parseFrom(InputStream input) throws IOException {
            return (AsterProgressDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AsterProgressDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AsterProgressDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AsterProgressDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AsterProgressDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AsterProgressDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AsterProgressDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AsterProgressDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (AsterProgressDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AsterProgressDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AsterProgressDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AsterProgressDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterProgressDetailInfoOuterClass$AsterProgressDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AsterProgressDetailInfoOrBuilder {
            private int lastAutoAddTime_;
            private int count_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AsterProgressDetailInfoOuterClass.internal_static_AsterProgressDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AsterProgressDetailInfoOuterClass.internal_static_AsterProgressDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AsterProgressDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AsterProgressDetailInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.lastAutoAddTime_ = 0;
                this.count_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AsterProgressDetailInfoOuterClass.internal_static_AsterProgressDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AsterProgressDetailInfo getDefaultInstanceForType() {
                return AsterProgressDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AsterProgressDetailInfo build() {
                AsterProgressDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AsterProgressDetailInfo buildPartial() {
                AsterProgressDetailInfo result = new AsterProgressDetailInfo(this);
                result.lastAutoAddTime_ = this.lastAutoAddTime_;
                result.count_ = this.count_;
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
                if (other instanceof AsterProgressDetailInfo) {
                    return mergeFrom((AsterProgressDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AsterProgressDetailInfo other) {
                if (other == AsterProgressDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getLastAutoAddTime() != 0) {
                    setLastAutoAddTime(other.getLastAutoAddTime());
                }
                if (other.getCount() != 0) {
                    setCount(other.getCount());
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
                AsterProgressDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AsterProgressDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AsterProgressDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AsterProgressDetailInfoOuterClass.AsterProgressDetailInfoOrBuilder
            public int getLastAutoAddTime() {
                return this.lastAutoAddTime_;
            }

            public Builder setLastAutoAddTime(int value) {
                this.lastAutoAddTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearLastAutoAddTime() {
                this.lastAutoAddTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AsterProgressDetailInfoOuterClass.AsterProgressDetailInfoOrBuilder
            public int getCount() {
                return this.count_;
            }

            public Builder setCount(int value) {
                this.count_ = value;
                onChanged();
                return this;
            }

            public Builder clearCount() {
                this.count_ = 0;
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

        public static AsterProgressDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AsterProgressDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AsterProgressDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AsterProgressDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
