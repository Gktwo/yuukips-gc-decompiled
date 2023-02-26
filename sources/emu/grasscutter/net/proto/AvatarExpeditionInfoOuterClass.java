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
import emu.grasscutter.net.proto.AvatarExpeditionStateOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionInfoOuterClass.class */
public final class AvatarExpeditionInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aAvatarExpeditionInfo.proto\u001a\u001bAvatarExpeditionState.proto\"\u0001\n\u0014AvatarExpeditionInfo\u0012%\n\u0005state\u0018\u0001 \u0001(\u000e2\u0016.AvatarExpeditionState\u0012\r\n\u0005expId\u0018\u0002 \u0001(\r\u0012\u0010\n\bhourTime\u0018\u0003 \u0001(\r\u0012\u0011\n\tstartTime\u0018\u0004 \u0001(\r\u0012\u0014\n\fshortenRatio\u0018\u0005 \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AvatarExpeditionStateOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarExpeditionInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarExpeditionInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarExpeditionInfo_descriptor, new String[]{"State", "ExpId", "HourTime", "StartTime", "ShortenRatio"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionInfoOuterClass$AvatarExpeditionInfoOrBuilder.class */
    public interface AvatarExpeditionInfoOrBuilder extends MessageOrBuilder {
        int getStateValue();

        AvatarExpeditionStateOuterClass.AvatarExpeditionState getState();

        int getExpId();

        int getHourTime();

        int getStartTime();

        float getShortenRatio();
    }

    private AvatarExpeditionInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionInfoOuterClass$AvatarExpeditionInfo.class */
    public static final class AvatarExpeditionInfo extends GeneratedMessageV3 implements AvatarExpeditionInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STATE_FIELD_NUMBER = 1;
        private int state_;
        public static final int EXPID_FIELD_NUMBER = 2;
        private int expId_;
        public static final int HOURTIME_FIELD_NUMBER = 3;
        private int hourTime_;
        public static final int STARTTIME_FIELD_NUMBER = 4;
        private int startTime_;
        public static final int SHORTENRATIO_FIELD_NUMBER = 5;
        private float shortenRatio_;
        private byte memoizedIsInitialized;
        private static final AvatarExpeditionInfo DEFAULT_INSTANCE = new AvatarExpeditionInfo();
        private static final Parser<AvatarExpeditionInfo> PARSER = new AbstractParser<AvatarExpeditionInfo>() { // from class: emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo.1
            @Override // com.google.protobuf.Parser
            public AvatarExpeditionInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarExpeditionInfo(input, extensionRegistry);
            }
        };

        private AvatarExpeditionInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarExpeditionInfo() {
            this.memoizedIsInitialized = -1;
            this.state_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarExpeditionInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarExpeditionInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.state_ = input.readEnum();
                                break;
                            case 16:
                                this.expId_ = input.readUInt32();
                                break;
                            case 24:
                                this.hourTime_ = input.readUInt32();
                                break;
                            case 32:
                                this.startTime_ = input.readUInt32();
                                break;
                            case 45:
                                this.shortenRatio_ = input.readFloat();
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
            return AvatarExpeditionInfoOuterClass.internal_static_AvatarExpeditionInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarExpeditionInfoOuterClass.internal_static_AvatarExpeditionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarExpeditionInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass.AvatarExpeditionInfoOrBuilder
        public int getStateValue() {
            return this.state_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass.AvatarExpeditionInfoOrBuilder
        public AvatarExpeditionStateOuterClass.AvatarExpeditionState getState() {
            AvatarExpeditionStateOuterClass.AvatarExpeditionState result = AvatarExpeditionStateOuterClass.AvatarExpeditionState.valueOf(this.state_);
            return result == null ? AvatarExpeditionStateOuterClass.AvatarExpeditionState.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass.AvatarExpeditionInfoOrBuilder
        public int getExpId() {
            return this.expId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass.AvatarExpeditionInfoOrBuilder
        public int getHourTime() {
            return this.hourTime_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass.AvatarExpeditionInfoOrBuilder
        public int getStartTime() {
            return this.startTime_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass.AvatarExpeditionInfoOrBuilder
        public float getShortenRatio() {
            return this.shortenRatio_;
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
            if (this.state_ != AvatarExpeditionStateOuterClass.AvatarExpeditionState.AVATAR_EXPEDITION_STATE_NONE.getNumber()) {
                output.writeEnum(1, this.state_);
            }
            if (this.expId_ != 0) {
                output.writeUInt32(2, this.expId_);
            }
            if (this.hourTime_ != 0) {
                output.writeUInt32(3, this.hourTime_);
            }
            if (this.startTime_ != 0) {
                output.writeUInt32(4, this.startTime_);
            }
            if (this.shortenRatio_ != 0.0f) {
                output.writeFloat(5, this.shortenRatio_);
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
            if (this.state_ != AvatarExpeditionStateOuterClass.AvatarExpeditionState.AVATAR_EXPEDITION_STATE_NONE.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(1, this.state_);
            }
            if (this.expId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.expId_);
            }
            if (this.hourTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.hourTime_);
            }
            if (this.startTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.startTime_);
            }
            if (this.shortenRatio_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(5, this.shortenRatio_);
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
            if (!(obj instanceof AvatarExpeditionInfo)) {
                return equals(obj);
            }
            AvatarExpeditionInfo other = (AvatarExpeditionInfo) obj;
            return this.state_ == other.state_ && getExpId() == other.getExpId() && getHourTime() == other.getHourTime() && getStartTime() == other.getStartTime() && Float.floatToIntBits(getShortenRatio()) == Float.floatToIntBits(other.getShortenRatio()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + this.state_)) + 2)) + getExpId())) + 3)) + getHourTime())) + 4)) + getStartTime())) + 5)) + Float.floatToIntBits(getShortenRatio()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AvatarExpeditionInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionInfo parseFrom(InputStream input) throws IOException {
            return (AvatarExpeditionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarExpeditionInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarExpeditionInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarExpeditionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarExpeditionInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarExpeditionInfo parseFrom(CodedInputStream input) throws IOException {
            return (AvatarExpeditionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarExpeditionInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarExpeditionInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionInfoOuterClass$AvatarExpeditionInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarExpeditionInfoOrBuilder {
            private int state_ = 0;
            private int expId_;
            private int hourTime_;
            private int startTime_;
            private float shortenRatio_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarExpeditionInfoOuterClass.internal_static_AvatarExpeditionInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarExpeditionInfoOuterClass.internal_static_AvatarExpeditionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarExpeditionInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarExpeditionInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.state_ = 0;
                this.expId_ = 0;
                this.hourTime_ = 0;
                this.startTime_ = 0;
                this.shortenRatio_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarExpeditionInfoOuterClass.internal_static_AvatarExpeditionInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarExpeditionInfo getDefaultInstanceForType() {
                return AvatarExpeditionInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarExpeditionInfo build() {
                AvatarExpeditionInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarExpeditionInfo buildPartial() {
                AvatarExpeditionInfo result = new AvatarExpeditionInfo(this);
                result.state_ = this.state_;
                result.expId_ = this.expId_;
                result.hourTime_ = this.hourTime_;
                result.startTime_ = this.startTime_;
                result.shortenRatio_ = this.shortenRatio_;
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
                if (other instanceof AvatarExpeditionInfo) {
                    return mergeFrom((AvatarExpeditionInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarExpeditionInfo other) {
                if (other == AvatarExpeditionInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.state_ != 0) {
                    setStateValue(other.getStateValue());
                }
                if (other.getExpId() != 0) {
                    setExpId(other.getExpId());
                }
                if (other.getHourTime() != 0) {
                    setHourTime(other.getHourTime());
                }
                if (other.getStartTime() != 0) {
                    setStartTime(other.getStartTime());
                }
                if (other.getShortenRatio() != 0.0f) {
                    setShortenRatio(other.getShortenRatio());
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
                AvatarExpeditionInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarExpeditionInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarExpeditionInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass.AvatarExpeditionInfoOrBuilder
            public int getStateValue() {
                return this.state_;
            }

            public Builder setStateValue(int value) {
                this.state_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass.AvatarExpeditionInfoOrBuilder
            public AvatarExpeditionStateOuterClass.AvatarExpeditionState getState() {
                AvatarExpeditionStateOuterClass.AvatarExpeditionState result = AvatarExpeditionStateOuterClass.AvatarExpeditionState.valueOf(this.state_);
                return result == null ? AvatarExpeditionStateOuterClass.AvatarExpeditionState.UNRECOGNIZED : result;
            }

            public Builder setState(AvatarExpeditionStateOuterClass.AvatarExpeditionState value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.state_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearState() {
                this.state_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass.AvatarExpeditionInfoOrBuilder
            public int getExpId() {
                return this.expId_;
            }

            public Builder setExpId(int value) {
                this.expId_ = value;
                onChanged();
                return this;
            }

            public Builder clearExpId() {
                this.expId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass.AvatarExpeditionInfoOrBuilder
            public int getHourTime() {
                return this.hourTime_;
            }

            public Builder setHourTime(int value) {
                this.hourTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearHourTime() {
                this.hourTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass.AvatarExpeditionInfoOrBuilder
            public int getStartTime() {
                return this.startTime_;
            }

            public Builder setStartTime(int value) {
                this.startTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartTime() {
                this.startTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass.AvatarExpeditionInfoOrBuilder
            public float getShortenRatio() {
                return this.shortenRatio_;
            }

            public Builder setShortenRatio(float value) {
                this.shortenRatio_ = value;
                onChanged();
                return this;
            }

            public Builder clearShortenRatio() {
                this.shortenRatio_ = 0.0f;
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

        public static AvatarExpeditionInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarExpeditionInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarExpeditionInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarExpeditionInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AvatarExpeditionStateOuterClass.getDescriptor();
    }
}
