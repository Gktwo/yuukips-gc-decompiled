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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoutePointChangeInfoOuterClass.class */
public final class RoutePointChangeInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aRoutePointChangeInfo.proto\"T\n\u0014RoutePointChangeInfo\u0012\u0016\n\u000etargetVelocity\u0018\u0007 \u0001(\u0002\u0012\u0012\n\npointIndex\u0018\u000b \u0001(\r\u0012\u0010\n\bwaitTime\u0018\u000f \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_RoutePointChangeInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RoutePointChangeInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RoutePointChangeInfo_descriptor, new String[]{"TargetVelocity", "PointIndex", "WaitTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoutePointChangeInfoOuterClass$RoutePointChangeInfoOrBuilder.class */
    public interface RoutePointChangeInfoOrBuilder extends MessageOrBuilder {
        float getTargetVelocity();

        int getPointIndex();

        float getWaitTime();
    }

    private RoutePointChangeInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoutePointChangeInfoOuterClass$RoutePointChangeInfo.class */
    public static final class RoutePointChangeInfo extends GeneratedMessageV3 implements RoutePointChangeInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TARGETVELOCITY_FIELD_NUMBER = 7;
        private float targetVelocity_;
        public static final int POINTINDEX_FIELD_NUMBER = 11;
        private int pointIndex_;
        public static final int WAITTIME_FIELD_NUMBER = 15;
        private float waitTime_;
        private byte memoizedIsInitialized;
        private static final RoutePointChangeInfo DEFAULT_INSTANCE = new RoutePointChangeInfo();
        private static final Parser<RoutePointChangeInfo> PARSER = new AbstractParser<RoutePointChangeInfo>() { // from class: emu.grasscutter.net.proto.RoutePointChangeInfoOuterClass.RoutePointChangeInfo.1
            @Override // com.google.protobuf.Parser
            public RoutePointChangeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RoutePointChangeInfo(input, extensionRegistry);
            }
        };

        private RoutePointChangeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RoutePointChangeInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RoutePointChangeInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RoutePointChangeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 61:
                                    this.targetVelocity_ = input.readFloat();
                                    break;
                                case 88:
                                    this.pointIndex_ = input.readUInt32();
                                    break;
                                case 125:
                                    this.waitTime_ = input.readFloat();
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
            return RoutePointChangeInfoOuterClass.internal_static_RoutePointChangeInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RoutePointChangeInfoOuterClass.internal_static_RoutePointChangeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RoutePointChangeInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RoutePointChangeInfoOuterClass.RoutePointChangeInfoOrBuilder
        public float getTargetVelocity() {
            return this.targetVelocity_;
        }

        @Override // emu.grasscutter.net.proto.RoutePointChangeInfoOuterClass.RoutePointChangeInfoOrBuilder
        public int getPointIndex() {
            return this.pointIndex_;
        }

        @Override // emu.grasscutter.net.proto.RoutePointChangeInfoOuterClass.RoutePointChangeInfoOrBuilder
        public float getWaitTime() {
            return this.waitTime_;
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
            if (this.targetVelocity_ != 0.0f) {
                output.writeFloat(7, this.targetVelocity_);
            }
            if (this.pointIndex_ != 0) {
                output.writeUInt32(11, this.pointIndex_);
            }
            if (this.waitTime_ != 0.0f) {
                output.writeFloat(15, this.waitTime_);
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
            if (this.targetVelocity_ != 0.0f) {
                size2 = 0 + CodedOutputStream.computeFloatSize(7, this.targetVelocity_);
            }
            if (this.pointIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.pointIndex_);
            }
            if (this.waitTime_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(15, this.waitTime_);
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
            if (!(obj instanceof RoutePointChangeInfo)) {
                return equals(obj);
            }
            RoutePointChangeInfo other = (RoutePointChangeInfo) obj;
            return Float.floatToIntBits(getTargetVelocity()) == Float.floatToIntBits(other.getTargetVelocity()) && getPointIndex() == other.getPointIndex() && Float.floatToIntBits(getWaitTime()) == Float.floatToIntBits(other.getWaitTime()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + Float.floatToIntBits(getTargetVelocity()))) + 11)) + getPointIndex())) + 15)) + Float.floatToIntBits(getWaitTime()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static RoutePointChangeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoutePointChangeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoutePointChangeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoutePointChangeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoutePointChangeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoutePointChangeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoutePointChangeInfo parseFrom(InputStream input) throws IOException {
            return (RoutePointChangeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoutePointChangeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoutePointChangeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoutePointChangeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (RoutePointChangeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RoutePointChangeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoutePointChangeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoutePointChangeInfo parseFrom(CodedInputStream input) throws IOException {
            return (RoutePointChangeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoutePointChangeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoutePointChangeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RoutePointChangeInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoutePointChangeInfoOuterClass$RoutePointChangeInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RoutePointChangeInfoOrBuilder {
            private float targetVelocity_;
            private int pointIndex_;
            private float waitTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RoutePointChangeInfoOuterClass.internal_static_RoutePointChangeInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RoutePointChangeInfoOuterClass.internal_static_RoutePointChangeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RoutePointChangeInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RoutePointChangeInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.targetVelocity_ = 0.0f;
                this.pointIndex_ = 0;
                this.waitTime_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RoutePointChangeInfoOuterClass.internal_static_RoutePointChangeInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RoutePointChangeInfo getDefaultInstanceForType() {
                return RoutePointChangeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RoutePointChangeInfo build() {
                RoutePointChangeInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RoutePointChangeInfo buildPartial() {
                RoutePointChangeInfo result = new RoutePointChangeInfo(this);
                result.targetVelocity_ = this.targetVelocity_;
                result.pointIndex_ = this.pointIndex_;
                result.waitTime_ = this.waitTime_;
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
                if (other instanceof RoutePointChangeInfo) {
                    return mergeFrom((RoutePointChangeInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RoutePointChangeInfo other) {
                if (other == RoutePointChangeInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getTargetVelocity() != 0.0f) {
                    setTargetVelocity(other.getTargetVelocity());
                }
                if (other.getPointIndex() != 0) {
                    setPointIndex(other.getPointIndex());
                }
                if (other.getWaitTime() != 0.0f) {
                    setWaitTime(other.getWaitTime());
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
                RoutePointChangeInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = RoutePointChangeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RoutePointChangeInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RoutePointChangeInfoOuterClass.RoutePointChangeInfoOrBuilder
            public float getTargetVelocity() {
                return this.targetVelocity_;
            }

            public Builder setTargetVelocity(float value) {
                this.targetVelocity_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetVelocity() {
                this.targetVelocity_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoutePointChangeInfoOuterClass.RoutePointChangeInfoOrBuilder
            public int getPointIndex() {
                return this.pointIndex_;
            }

            public Builder setPointIndex(int value) {
                this.pointIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearPointIndex() {
                this.pointIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoutePointChangeInfoOuterClass.RoutePointChangeInfoOrBuilder
            public float getWaitTime() {
                return this.waitTime_;
            }

            public Builder setWaitTime(float value) {
                this.waitTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearWaitTime() {
                this.waitTime_ = 0.0f;
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

        public static RoutePointChangeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RoutePointChangeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RoutePointChangeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RoutePointChangeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
