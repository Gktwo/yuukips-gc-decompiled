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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSatiationDataOuterClass.class */
public final class AvatarSatiationDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019AvatarSatiationData.proto\"X\n\u0013AvatarSatiationData\u0012\u0012\n\navatarGuid\u0018\u0005 \u0001(\u0004\u0012\u0012\n\nfinishTime\u0018\u000f \u0001(\u0002\u0012\u0019\n\u0011penaltyFinishTime\u0018\f \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarSatiationData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarSatiationData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarSatiationData_descriptor, new String[]{"AvatarGuid", "FinishTime", "PenaltyFinishTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSatiationDataOuterClass$AvatarSatiationDataOrBuilder.class */
    public interface AvatarSatiationDataOrBuilder extends MessageOrBuilder {
        long getAvatarGuid();

        float getFinishTime();

        float getPenaltyFinishTime();
    }

    private AvatarSatiationDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSatiationDataOuterClass$AvatarSatiationData.class */
    public static final class AvatarSatiationData extends GeneratedMessageV3 implements AvatarSatiationDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATARGUID_FIELD_NUMBER = 5;
        private long avatarGuid_;
        public static final int FINISHTIME_FIELD_NUMBER = 15;
        private float finishTime_;
        public static final int PENALTYFINISHTIME_FIELD_NUMBER = 12;
        private float penaltyFinishTime_;
        private byte memoizedIsInitialized;
        private static final AvatarSatiationData DEFAULT_INSTANCE = new AvatarSatiationData();
        private static final Parser<AvatarSatiationData> PARSER = new AbstractParser<AvatarSatiationData>() { // from class: emu.grasscutter.net.proto.AvatarSatiationDataOuterClass.AvatarSatiationData.1
            @Override // com.google.protobuf.Parser
            public AvatarSatiationData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarSatiationData(input, extensionRegistry);
            }
        };

        private AvatarSatiationData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarSatiationData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarSatiationData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarSatiationData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    this.avatarGuid_ = input.readUInt64();
                                    break;
                                case 101:
                                    this.penaltyFinishTime_ = input.readFloat();
                                    break;
                                case 125:
                                    this.finishTime_ = input.readFloat();
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
                        }
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
            return AvatarSatiationDataOuterClass.internal_static_AvatarSatiationData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarSatiationDataOuterClass.internal_static_AvatarSatiationData_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarSatiationData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarSatiationDataOuterClass.AvatarSatiationDataOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSatiationDataOuterClass.AvatarSatiationDataOrBuilder
        public float getFinishTime() {
            return this.finishTime_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSatiationDataOuterClass.AvatarSatiationDataOrBuilder
        public float getPenaltyFinishTime() {
            return this.penaltyFinishTime_;
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
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(5, this.avatarGuid_);
            }
            if (this.penaltyFinishTime_ != 0.0f) {
                output.writeFloat(12, this.penaltyFinishTime_);
            }
            if (this.finishTime_ != 0.0f) {
                output.writeFloat(15, this.finishTime_);
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
            if (this.avatarGuid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(5, this.avatarGuid_);
            }
            if (this.penaltyFinishTime_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(12, this.penaltyFinishTime_);
            }
            if (this.finishTime_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(15, this.finishTime_);
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
            if (!(obj instanceof AvatarSatiationData)) {
                return equals(obj);
            }
            AvatarSatiationData other = (AvatarSatiationData) obj;
            return getAvatarGuid() == other.getAvatarGuid() && Float.floatToIntBits(getFinishTime()) == Float.floatToIntBits(other.getFinishTime()) && Float.floatToIntBits(getPenaltyFinishTime()) == Float.floatToIntBits(other.getPenaltyFinishTime()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + Internal.hashLong(getAvatarGuid()))) + 15)) + Float.floatToIntBits(getFinishTime()))) + 12)) + Float.floatToIntBits(getPenaltyFinishTime()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AvatarSatiationData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSatiationData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSatiationData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSatiationData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSatiationData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSatiationData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSatiationData parseFrom(InputStream input) throws IOException {
            return (AvatarSatiationData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarSatiationData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSatiationData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarSatiationData parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarSatiationData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarSatiationData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSatiationData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarSatiationData parseFrom(CodedInputStream input) throws IOException {
            return (AvatarSatiationData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarSatiationData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSatiationData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarSatiationData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSatiationDataOuterClass$AvatarSatiationData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarSatiationDataOrBuilder {
            private long avatarGuid_;
            private float finishTime_;
            private float penaltyFinishTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarSatiationDataOuterClass.internal_static_AvatarSatiationData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarSatiationDataOuterClass.internal_static_AvatarSatiationData_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarSatiationData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarSatiationData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.avatarGuid_ = 0;
                this.finishTime_ = 0.0f;
                this.penaltyFinishTime_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarSatiationDataOuterClass.internal_static_AvatarSatiationData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarSatiationData getDefaultInstanceForType() {
                return AvatarSatiationData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarSatiationData build() {
                AvatarSatiationData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarSatiationData buildPartial() {
                AvatarSatiationData result = new AvatarSatiationData(this);
                result.avatarGuid_ = this.avatarGuid_;
                result.finishTime_ = this.finishTime_;
                result.penaltyFinishTime_ = this.penaltyFinishTime_;
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
                if (other instanceof AvatarSatiationData) {
                    return mergeFrom((AvatarSatiationData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarSatiationData other) {
                if (other == AvatarSatiationData.getDefaultInstance()) {
                    return this;
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                if (other.getFinishTime() != 0.0f) {
                    setFinishTime(other.getFinishTime());
                }
                if (other.getPenaltyFinishTime() != 0.0f) {
                    setPenaltyFinishTime(other.getPenaltyFinishTime());
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
                AvatarSatiationData parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarSatiationData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarSatiationData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarSatiationDataOuterClass.AvatarSatiationDataOrBuilder
            public long getAvatarGuid() {
                return this.avatarGuid_;
            }

            public Builder setAvatarGuid(long value) {
                this.avatarGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarGuid() {
                this.avatarGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarSatiationDataOuterClass.AvatarSatiationDataOrBuilder
            public float getFinishTime() {
                return this.finishTime_;
            }

            public Builder setFinishTime(float value) {
                this.finishTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearFinishTime() {
                this.finishTime_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarSatiationDataOuterClass.AvatarSatiationDataOrBuilder
            public float getPenaltyFinishTime() {
                return this.penaltyFinishTime_;
            }

            public Builder setPenaltyFinishTime(float value) {
                this.penaltyFinishTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearPenaltyFinishTime() {
                this.penaltyFinishTime_ = 0.0f;
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

        public static AvatarSatiationData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarSatiationData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarSatiationData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarSatiationData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
