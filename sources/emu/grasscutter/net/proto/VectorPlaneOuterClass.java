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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VectorPlaneOuterClass.class */
public final class VectorPlaneOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011VectorPlane.proto\"#\n\u000bVectorPlane\u0012\t\n\u0001x\u0018\u0001 \u0001(\u0002\u0012\t\n\u0001y\u0018\u0002 \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_VectorPlane_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_VectorPlane_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_VectorPlane_descriptor, new String[]{"X", "Y"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VectorPlaneOuterClass$VectorPlaneOrBuilder.class */
    public interface VectorPlaneOrBuilder extends MessageOrBuilder {
        float getX();

        float getY();
    }

    private VectorPlaneOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VectorPlaneOuterClass$VectorPlane.class */
    public static final class VectorPlane extends GeneratedMessageV3 implements VectorPlaneOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int X_FIELD_NUMBER = 1;

        /* renamed from: x_ */
        private float f888x_;
        public static final int Y_FIELD_NUMBER = 2;

        /* renamed from: y_ */
        private float f889y_;
        private byte memoizedIsInitialized;
        private static final VectorPlane DEFAULT_INSTANCE = new VectorPlane();
        private static final Parser<VectorPlane> PARSER = new AbstractParser<VectorPlane>() { // from class: emu.grasscutter.net.proto.VectorPlaneOuterClass.VectorPlane.1
            @Override // com.google.protobuf.Parser
            public VectorPlane parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VectorPlane(input, extensionRegistry);
            }
        };

        private VectorPlane(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private VectorPlane() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new VectorPlane();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VectorPlane(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 13:
                                this.f888x_ = input.readFloat();
                                break;
                            case 21:
                                this.f889y_ = input.readFloat();
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
            return VectorPlaneOuterClass.internal_static_VectorPlane_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VectorPlaneOuterClass.internal_static_VectorPlane_fieldAccessorTable.ensureFieldAccessorsInitialized(VectorPlane.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.VectorPlaneOuterClass.VectorPlaneOrBuilder
        public float getX() {
            return this.f888x_;
        }

        @Override // emu.grasscutter.net.proto.VectorPlaneOuterClass.VectorPlaneOrBuilder
        public float getY() {
            return this.f889y_;
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
            if (this.f888x_ != 0.0f) {
                output.writeFloat(1, this.f888x_);
            }
            if (this.f889y_ != 0.0f) {
                output.writeFloat(2, this.f889y_);
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
            if (this.f888x_ != 0.0f) {
                size2 = 0 + CodedOutputStream.computeFloatSize(1, this.f888x_);
            }
            if (this.f889y_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(2, this.f889y_);
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
            if (!(obj instanceof VectorPlane)) {
                return equals(obj);
            }
            VectorPlane other = (VectorPlane) obj;
            return Float.floatToIntBits(getX()) == Float.floatToIntBits(other.getX()) && Float.floatToIntBits(getY()) == Float.floatToIntBits(other.getY()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Float.floatToIntBits(getX()))) + 2)) + Float.floatToIntBits(getY()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static VectorPlane parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VectorPlane parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VectorPlane parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VectorPlane parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VectorPlane parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VectorPlane parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VectorPlane parseFrom(InputStream input) throws IOException {
            return (VectorPlane) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VectorPlane parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VectorPlane) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static VectorPlane parseDelimitedFrom(InputStream input) throws IOException {
            return (VectorPlane) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static VectorPlane parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VectorPlane) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static VectorPlane parseFrom(CodedInputStream input) throws IOException {
            return (VectorPlane) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VectorPlane parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VectorPlane) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VectorPlane prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VectorPlaneOuterClass$VectorPlane$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VectorPlaneOrBuilder {

            /* renamed from: x_ */
            private float f890x_;

            /* renamed from: y_ */
            private float f891y_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VectorPlaneOuterClass.internal_static_VectorPlane_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VectorPlaneOuterClass.internal_static_VectorPlane_fieldAccessorTable.ensureFieldAccessorsInitialized(VectorPlane.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VectorPlane.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.f890x_ = 0.0f;
                this.f891y_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VectorPlaneOuterClass.internal_static_VectorPlane_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VectorPlane getDefaultInstanceForType() {
                return VectorPlane.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VectorPlane build() {
                VectorPlane result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VectorPlane buildPartial() {
                VectorPlane result = new VectorPlane(this);
                result.f888x_ = this.f890x_;
                result.f889y_ = this.f891y_;
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
                if (other instanceof VectorPlane) {
                    return mergeFrom((VectorPlane) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VectorPlane other) {
                if (other == VectorPlane.getDefaultInstance()) {
                    return this;
                }
                if (other.getX() != 0.0f) {
                    setX(other.getX());
                }
                if (other.getY() != 0.0f) {
                    setY(other.getY());
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
                VectorPlane parsedMessage = null;
                try {
                    try {
                        parsedMessage = VectorPlane.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (VectorPlane) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.VectorPlaneOuterClass.VectorPlaneOrBuilder
            public float getX() {
                return this.f890x_;
            }

            public Builder setX(float value) {
                this.f890x_ = value;
                onChanged();
                return this;
            }

            public Builder clearX() {
                this.f890x_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VectorPlaneOuterClass.VectorPlaneOrBuilder
            public float getY() {
                return this.f891y_;
            }

            public Builder setY(float value) {
                this.f891y_ = value;
                onChanged();
                return this;
            }

            public Builder clearY() {
                this.f891y_ = 0.0f;
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

        public static VectorPlane getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VectorPlane> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VectorPlane> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VectorPlane getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
