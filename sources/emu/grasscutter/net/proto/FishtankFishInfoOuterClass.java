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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FishtankFishInfoOuterClass.class */
public final class FishtankFishInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016FishtankFishInfo.proto\"d\n\u0010FishtankFishInfo\u0012 \n\u0018fish_distance_from_water\u0018\u0001 \u0001(\u0002\u0012\u0012\n\nfish_scale\u0018\u0002 \u0001(\u0002\u0012\u001a\n\u0012initial_rotation_y\u0018\u0003 \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FishtankFishInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FishtankFishInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FishtankFishInfo_descriptor, new String[]{"FishDistanceFromWater", "FishScale", "InitialRotationY"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FishtankFishInfoOuterClass$FishtankFishInfoOrBuilder.class */
    public interface FishtankFishInfoOrBuilder extends MessageOrBuilder {
        float getFishDistanceFromWater();

        float getFishScale();

        float getInitialRotationY();
    }

    private FishtankFishInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FishtankFishInfoOuterClass$FishtankFishInfo.class */
    public static final class FishtankFishInfo extends GeneratedMessageV3 implements FishtankFishInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FISH_DISTANCE_FROM_WATER_FIELD_NUMBER = 1;
        private float fishDistanceFromWater_;
        public static final int FISH_SCALE_FIELD_NUMBER = 2;
        private float fishScale_;
        public static final int INITIAL_ROTATION_Y_FIELD_NUMBER = 3;
        private float initialRotationY_;
        private byte memoizedIsInitialized;
        private static final FishtankFishInfo DEFAULT_INSTANCE = new FishtankFishInfo();
        private static final Parser<FishtankFishInfo> PARSER = new AbstractParser<FishtankFishInfo>() { // from class: emu.grasscutter.net.proto.FishtankFishInfoOuterClass.FishtankFishInfo.1
            @Override // com.google.protobuf.Parser
            public FishtankFishInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FishtankFishInfo(input, extensionRegistry);
            }
        };

        private FishtankFishInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FishtankFishInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FishtankFishInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FishtankFishInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 13:
                                    this.fishDistanceFromWater_ = input.readFloat();
                                    break;
                                case 21:
                                    this.fishScale_ = input.readFloat();
                                    break;
                                case 29:
                                    this.initialRotationY_ = input.readFloat();
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
            return FishtankFishInfoOuterClass.internal_static_FishtankFishInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FishtankFishInfoOuterClass.internal_static_FishtankFishInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FishtankFishInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FishtankFishInfoOuterClass.FishtankFishInfoOrBuilder
        public float getFishDistanceFromWater() {
            return this.fishDistanceFromWater_;
        }

        @Override // emu.grasscutter.net.proto.FishtankFishInfoOuterClass.FishtankFishInfoOrBuilder
        public float getFishScale() {
            return this.fishScale_;
        }

        @Override // emu.grasscutter.net.proto.FishtankFishInfoOuterClass.FishtankFishInfoOrBuilder
        public float getInitialRotationY() {
            return this.initialRotationY_;
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
            if (this.fishDistanceFromWater_ != 0.0f) {
                output.writeFloat(1, this.fishDistanceFromWater_);
            }
            if (this.fishScale_ != 0.0f) {
                output.writeFloat(2, this.fishScale_);
            }
            if (this.initialRotationY_ != 0.0f) {
                output.writeFloat(3, this.initialRotationY_);
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
            if (this.fishDistanceFromWater_ != 0.0f) {
                size2 = 0 + CodedOutputStream.computeFloatSize(1, this.fishDistanceFromWater_);
            }
            if (this.fishScale_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(2, this.fishScale_);
            }
            if (this.initialRotationY_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(3, this.initialRotationY_);
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
            if (!(obj instanceof FishtankFishInfo)) {
                return equals(obj);
            }
            FishtankFishInfo other = (FishtankFishInfo) obj;
            return Float.floatToIntBits(getFishDistanceFromWater()) == Float.floatToIntBits(other.getFishDistanceFromWater()) && Float.floatToIntBits(getFishScale()) == Float.floatToIntBits(other.getFishScale()) && Float.floatToIntBits(getInitialRotationY()) == Float.floatToIntBits(other.getInitialRotationY()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Float.floatToIntBits(getFishDistanceFromWater()))) + 2)) + Float.floatToIntBits(getFishScale()))) + 3)) + Float.floatToIntBits(getInitialRotationY()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static FishtankFishInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FishtankFishInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FishtankFishInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FishtankFishInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FishtankFishInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FishtankFishInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FishtankFishInfo parseFrom(InputStream input) throws IOException {
            return (FishtankFishInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FishtankFishInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FishtankFishInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FishtankFishInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (FishtankFishInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FishtankFishInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FishtankFishInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FishtankFishInfo parseFrom(CodedInputStream input) throws IOException {
            return (FishtankFishInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FishtankFishInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FishtankFishInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FishtankFishInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FishtankFishInfoOuterClass$FishtankFishInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FishtankFishInfoOrBuilder {
            private float fishDistanceFromWater_;
            private float fishScale_;
            private float initialRotationY_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FishtankFishInfoOuterClass.internal_static_FishtankFishInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FishtankFishInfoOuterClass.internal_static_FishtankFishInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FishtankFishInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FishtankFishInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.fishDistanceFromWater_ = 0.0f;
                this.fishScale_ = 0.0f;
                this.initialRotationY_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FishtankFishInfoOuterClass.internal_static_FishtankFishInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FishtankFishInfo getDefaultInstanceForType() {
                return FishtankFishInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FishtankFishInfo build() {
                FishtankFishInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FishtankFishInfo buildPartial() {
                FishtankFishInfo result = new FishtankFishInfo(this);
                result.fishDistanceFromWater_ = this.fishDistanceFromWater_;
                result.fishScale_ = this.fishScale_;
                result.initialRotationY_ = this.initialRotationY_;
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
                if (other instanceof FishtankFishInfo) {
                    return mergeFrom((FishtankFishInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FishtankFishInfo other) {
                if (other == FishtankFishInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getFishDistanceFromWater() != 0.0f) {
                    setFishDistanceFromWater(other.getFishDistanceFromWater());
                }
                if (other.getFishScale() != 0.0f) {
                    setFishScale(other.getFishScale());
                }
                if (other.getInitialRotationY() != 0.0f) {
                    setInitialRotationY(other.getInitialRotationY());
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
                FishtankFishInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = FishtankFishInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FishtankFishInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FishtankFishInfoOuterClass.FishtankFishInfoOrBuilder
            public float getFishDistanceFromWater() {
                return this.fishDistanceFromWater_;
            }

            public Builder setFishDistanceFromWater(float value) {
                this.fishDistanceFromWater_ = value;
                onChanged();
                return this;
            }

            public Builder clearFishDistanceFromWater() {
                this.fishDistanceFromWater_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FishtankFishInfoOuterClass.FishtankFishInfoOrBuilder
            public float getFishScale() {
                return this.fishScale_;
            }

            public Builder setFishScale(float value) {
                this.fishScale_ = value;
                onChanged();
                return this;
            }

            public Builder clearFishScale() {
                this.fishScale_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FishtankFishInfoOuterClass.FishtankFishInfoOrBuilder
            public float getInitialRotationY() {
                return this.initialRotationY_;
            }

            public Builder setInitialRotationY(float value) {
                this.initialRotationY_ = value;
                onChanged();
                return this;
            }

            public Builder clearInitialRotationY() {
                this.initialRotationY_ = 0.0f;
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

        public static FishtankFishInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FishtankFishInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FishtankFishInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FishtankFishInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
