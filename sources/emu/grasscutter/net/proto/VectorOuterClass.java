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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VectorOuterClass.class */
public final class VectorOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\fVector.proto\")\n\u0006Vector\u0012\t\n\u0001x\u0018\u0001 \u0001(\u0002\u0012\t\n\u0001y\u0018\u0002 \u0001(\u0002\u0012\t\n\u0001z\u0018\u0003 \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_Vector_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_Vector_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_Vector_descriptor, new String[]{"X", "Y", "Z"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VectorOuterClass$VectorOrBuilder.class */
    public interface VectorOrBuilder extends MessageOrBuilder {
        float getX();

        float getY();

        float getZ();
    }

    private VectorOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VectorOuterClass$Vector.class */
    public static final class Vector extends GeneratedMessageV3 implements VectorOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int X_FIELD_NUMBER = 1;

        /* renamed from: x_ */
        private float f913x_;
        public static final int Y_FIELD_NUMBER = 2;

        /* renamed from: y_ */
        private float f914y_;
        public static final int Z_FIELD_NUMBER = 3;

        /* renamed from: z_ */
        private float f915z_;
        private byte memoizedIsInitialized;
        private static final Vector DEFAULT_INSTANCE = new Vector();
        private static final Parser<Vector> PARSER = new AbstractParser<Vector>() { // from class: emu.grasscutter.net.proto.VectorOuterClass.Vector.1
            @Override // com.google.protobuf.Parser
            public Vector parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Vector(input, extensionRegistry);
            }
        };

        private Vector(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private Vector() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new Vector();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Vector(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.f913x_ = input.readFloat();
                                    break;
                                case 21:
                                    this.f914y_ = input.readFloat();
                                    break;
                                case 29:
                                    this.f915z_ = input.readFloat();
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
            return VectorOuterClass.internal_static_Vector_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VectorOuterClass.internal_static_Vector_fieldAccessorTable.ensureFieldAccessorsInitialized(Vector.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.VectorOuterClass.VectorOrBuilder
        public float getX() {
            return this.f913x_;
        }

        @Override // emu.grasscutter.net.proto.VectorOuterClass.VectorOrBuilder
        public float getY() {
            return this.f914y_;
        }

        @Override // emu.grasscutter.net.proto.VectorOuterClass.VectorOrBuilder
        public float getZ() {
            return this.f915z_;
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
            if (this.f913x_ != 0.0f) {
                output.writeFloat(1, this.f913x_);
            }
            if (this.f914y_ != 0.0f) {
                output.writeFloat(2, this.f914y_);
            }
            if (this.f915z_ != 0.0f) {
                output.writeFloat(3, this.f915z_);
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
            if (this.f913x_ != 0.0f) {
                size2 = 0 + CodedOutputStream.computeFloatSize(1, this.f913x_);
            }
            if (this.f914y_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(2, this.f914y_);
            }
            if (this.f915z_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(3, this.f915z_);
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
            if (!(obj instanceof Vector)) {
                return equals(obj);
            }
            Vector other = (Vector) obj;
            return Float.floatToIntBits(getX()) == Float.floatToIntBits(other.getX()) && Float.floatToIntBits(getY()) == Float.floatToIntBits(other.getY()) && Float.floatToIntBits(getZ()) == Float.floatToIntBits(other.getZ()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Float.floatToIntBits(getX()))) + 2)) + Float.floatToIntBits(getY()))) + 3)) + Float.floatToIntBits(getZ()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static Vector parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Vector parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Vector parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Vector parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Vector parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Vector parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Vector parseFrom(InputStream input) throws IOException {
            return (Vector) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Vector parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Vector) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static Vector parseDelimitedFrom(InputStream input) throws IOException {
            return (Vector) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static Vector parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Vector) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static Vector parseFrom(CodedInputStream input) throws IOException {
            return (Vector) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Vector parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Vector) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Vector prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VectorOuterClass$Vector$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VectorOrBuilder {

            /* renamed from: x_ */
            private float f916x_;

            /* renamed from: y_ */
            private float f917y_;

            /* renamed from: z_ */
            private float f918z_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VectorOuterClass.internal_static_Vector_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VectorOuterClass.internal_static_Vector_fieldAccessorTable.ensureFieldAccessorsInitialized(Vector.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Vector.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.f916x_ = 0.0f;
                this.f917y_ = 0.0f;
                this.f918z_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VectorOuterClass.internal_static_Vector_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Vector getDefaultInstanceForType() {
                return Vector.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Vector build() {
                Vector result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Vector buildPartial() {
                Vector result = new Vector(this);
                result.f913x_ = this.f916x_;
                result.f914y_ = this.f917y_;
                result.f915z_ = this.f918z_;
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
                if (other instanceof Vector) {
                    return mergeFrom((Vector) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Vector other) {
                if (other == Vector.getDefaultInstance()) {
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
                Vector parsedMessage = null;
                try {
                    try {
                        parsedMessage = Vector.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (Vector) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.VectorOuterClass.VectorOrBuilder
            public float getX() {
                return this.f916x_;
            }

            public Builder setX(float value) {
                this.f916x_ = value;
                onChanged();
                return this;
            }

            public Builder clearX() {
                this.f916x_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VectorOuterClass.VectorOrBuilder
            public float getY() {
                return this.f917y_;
            }

            public Builder setY(float value) {
                this.f917y_ = value;
                onChanged();
                return this;
            }

            public Builder clearY() {
                this.f917y_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VectorOuterClass.VectorOrBuilder
            public float getZ() {
                return this.f918z_;
            }

            public Builder setZ(float value) {
                this.f918z_ = value;
                onChanged();
                return this;
            }

            public Builder clearZ() {
                this.f918z_ = 0.0f;
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

        public static Vector getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Vector> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Vector> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Vector getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
