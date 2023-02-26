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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MathQuaternionOuterClass.class */
public final class MathQuaternionOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014MathQuaternion.proto\"<\n\u000eMathQuaternion\u0012\t\n\u0001x\u0018\u0001 \u0001(\u0002\u0012\t\n\u0001y\u0018\u0002 \u0001(\u0002\u0012\t\n\u0001z\u0018\u0003 \u0001(\u0002\u0012\t\n\u0001w\u0018\u0004 \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_MathQuaternion_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MathQuaternion_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MathQuaternion_descriptor, new String[]{"X", "Y", "Z", "W"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MathQuaternionOuterClass$MathQuaternionOrBuilder.class */
    public interface MathQuaternionOrBuilder extends MessageOrBuilder {
        float getX();

        float getY();

        float getZ();

        float getW();
    }

    private MathQuaternionOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MathQuaternionOuterClass$MathQuaternion.class */
    public static final class MathQuaternion extends GeneratedMessageV3 implements MathQuaternionOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int X_FIELD_NUMBER = 1;

        /* renamed from: x_ */
        private float f772x_;
        public static final int Y_FIELD_NUMBER = 2;

        /* renamed from: y_ */
        private float f773y_;
        public static final int Z_FIELD_NUMBER = 3;

        /* renamed from: z_ */
        private float f774z_;
        public static final int W_FIELD_NUMBER = 4;

        /* renamed from: w_ */
        private float f775w_;
        private byte memoizedIsInitialized;
        private static final MathQuaternion DEFAULT_INSTANCE = new MathQuaternion();
        private static final Parser<MathQuaternion> PARSER = new AbstractParser<MathQuaternion>() { // from class: emu.grasscutter.net.proto.MathQuaternionOuterClass.MathQuaternion.1
            @Override // com.google.protobuf.Parser
            public MathQuaternion parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MathQuaternion(input, extensionRegistry);
            }
        };

        private MathQuaternion(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MathQuaternion() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MathQuaternion();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MathQuaternion(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.f772x_ = input.readFloat();
                                    break;
                                case 21:
                                    this.f773y_ = input.readFloat();
                                    break;
                                case 29:
                                    this.f774z_ = input.readFloat();
                                    break;
                                case 37:
                                    this.f775w_ = input.readFloat();
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
            return MathQuaternionOuterClass.internal_static_MathQuaternion_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MathQuaternionOuterClass.internal_static_MathQuaternion_fieldAccessorTable.ensureFieldAccessorsInitialized(MathQuaternion.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MathQuaternionOuterClass.MathQuaternionOrBuilder
        public float getX() {
            return this.f772x_;
        }

        @Override // emu.grasscutter.net.proto.MathQuaternionOuterClass.MathQuaternionOrBuilder
        public float getY() {
            return this.f773y_;
        }

        @Override // emu.grasscutter.net.proto.MathQuaternionOuterClass.MathQuaternionOrBuilder
        public float getZ() {
            return this.f774z_;
        }

        @Override // emu.grasscutter.net.proto.MathQuaternionOuterClass.MathQuaternionOrBuilder
        public float getW() {
            return this.f775w_;
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
            if (this.f772x_ != 0.0f) {
                output.writeFloat(1, this.f772x_);
            }
            if (this.f773y_ != 0.0f) {
                output.writeFloat(2, this.f773y_);
            }
            if (this.f774z_ != 0.0f) {
                output.writeFloat(3, this.f774z_);
            }
            if (this.f775w_ != 0.0f) {
                output.writeFloat(4, this.f775w_);
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
            if (this.f772x_ != 0.0f) {
                size2 = 0 + CodedOutputStream.computeFloatSize(1, this.f772x_);
            }
            if (this.f773y_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(2, this.f773y_);
            }
            if (this.f774z_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(3, this.f774z_);
            }
            if (this.f775w_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(4, this.f775w_);
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
            if (!(obj instanceof MathQuaternion)) {
                return equals(obj);
            }
            MathQuaternion other = (MathQuaternion) obj;
            return Float.floatToIntBits(getX()) == Float.floatToIntBits(other.getX()) && Float.floatToIntBits(getY()) == Float.floatToIntBits(other.getY()) && Float.floatToIntBits(getZ()) == Float.floatToIntBits(other.getZ()) && Float.floatToIntBits(getW()) == Float.floatToIntBits(other.getW()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Float.floatToIntBits(getX()))) + 2)) + Float.floatToIntBits(getY()))) + 3)) + Float.floatToIntBits(getZ()))) + 4)) + Float.floatToIntBits(getW()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MathQuaternion parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MathQuaternion parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MathQuaternion parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MathQuaternion parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MathQuaternion parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MathQuaternion parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MathQuaternion parseFrom(InputStream input) throws IOException {
            return (MathQuaternion) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MathQuaternion parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MathQuaternion) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MathQuaternion parseDelimitedFrom(InputStream input) throws IOException {
            return (MathQuaternion) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MathQuaternion parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MathQuaternion) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MathQuaternion parseFrom(CodedInputStream input) throws IOException {
            return (MathQuaternion) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MathQuaternion parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MathQuaternion) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MathQuaternion prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MathQuaternionOuterClass$MathQuaternion$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MathQuaternionOrBuilder {

            /* renamed from: x_ */
            private float f776x_;

            /* renamed from: y_ */
            private float f777y_;

            /* renamed from: z_ */
            private float f778z_;

            /* renamed from: w_ */
            private float f779w_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MathQuaternionOuterClass.internal_static_MathQuaternion_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MathQuaternionOuterClass.internal_static_MathQuaternion_fieldAccessorTable.ensureFieldAccessorsInitialized(MathQuaternion.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MathQuaternion.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.f776x_ = 0.0f;
                this.f777y_ = 0.0f;
                this.f778z_ = 0.0f;
                this.f779w_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MathQuaternionOuterClass.internal_static_MathQuaternion_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MathQuaternion getDefaultInstanceForType() {
                return MathQuaternion.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MathQuaternion build() {
                MathQuaternion result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MathQuaternion buildPartial() {
                MathQuaternion result = new MathQuaternion(this);
                result.f772x_ = this.f776x_;
                result.f773y_ = this.f777y_;
                result.f774z_ = this.f778z_;
                result.f775w_ = this.f779w_;
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
                if (other instanceof MathQuaternion) {
                    return mergeFrom((MathQuaternion) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MathQuaternion other) {
                if (other == MathQuaternion.getDefaultInstance()) {
                    return this;
                }
                if (other.getX() != 0.0f) {
                    setX(other.getX());
                }
                if (other.getY() != 0.0f) {
                    setY(other.getY());
                }
                if (other.getZ() != 0.0f) {
                    setZ(other.getZ());
                }
                if (other.getW() != 0.0f) {
                    setW(other.getW());
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
                MathQuaternion parsedMessage = null;
                try {
                    try {
                        parsedMessage = MathQuaternion.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MathQuaternion) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MathQuaternionOuterClass.MathQuaternionOrBuilder
            public float getX() {
                return this.f776x_;
            }

            public Builder setX(float value) {
                this.f776x_ = value;
                onChanged();
                return this;
            }

            public Builder clearX() {
                this.f776x_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MathQuaternionOuterClass.MathQuaternionOrBuilder
            public float getY() {
                return this.f777y_;
            }

            public Builder setY(float value) {
                this.f777y_ = value;
                onChanged();
                return this;
            }

            public Builder clearY() {
                this.f777y_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MathQuaternionOuterClass.MathQuaternionOrBuilder
            public float getZ() {
                return this.f778z_;
            }

            public Builder setZ(float value) {
                this.f778z_ = value;
                onChanged();
                return this;
            }

            public Builder clearZ() {
                this.f778z_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MathQuaternionOuterClass.MathQuaternionOrBuilder
            public float getW() {
                return this.f779w_;
            }

            public Builder setW(float value) {
                this.f779w_ = value;
                onChanged();
                return this;
            }

            public Builder clearW() {
                this.f779w_ = 0.0f;
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

        public static MathQuaternion getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MathQuaternion> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MathQuaternion> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MathQuaternion getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
