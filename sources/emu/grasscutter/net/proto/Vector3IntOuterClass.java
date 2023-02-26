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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/Vector3IntOuterClass.class */
public final class Vector3IntOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010Vector3Int.proto\"-\n\nVector3Int\u0012\t\n\u0001x\u0018\u0001 \u0001(\u0005\u0012\t\n\u0001y\u0018\u0002 \u0001(\u0005\u0012\t\n\u0001z\u0018\u0003 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_Vector3Int_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_Vector3Int_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_Vector3Int_descriptor, new String[]{"X", "Y", "Z"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/Vector3IntOuterClass$Vector3IntOrBuilder.class */
    public interface Vector3IntOrBuilder extends MessageOrBuilder {
        int getX();

        int getY();

        int getZ();
    }

    private Vector3IntOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/Vector3IntOuterClass$Vector3Int.class */
    public static final class Vector3Int extends GeneratedMessageV3 implements Vector3IntOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int X_FIELD_NUMBER = 1;

        /* renamed from: x_ */
        private int f876x_;
        public static final int Y_FIELD_NUMBER = 2;

        /* renamed from: y_ */
        private int f877y_;
        public static final int Z_FIELD_NUMBER = 3;

        /* renamed from: z_ */
        private int f878z_;
        private byte memoizedIsInitialized;
        private static final Vector3Int DEFAULT_INSTANCE = new Vector3Int();
        private static final Parser<Vector3Int> PARSER = new AbstractParser<Vector3Int>() { // from class: emu.grasscutter.net.proto.Vector3IntOuterClass.Vector3Int.1
            @Override // com.google.protobuf.Parser
            public Vector3Int parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Vector3Int(input, extensionRegistry);
            }
        };

        private Vector3Int(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private Vector3Int() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new Vector3Int();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Vector3Int(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.f876x_ = input.readInt32();
                                    break;
                                case 16:
                                    this.f877y_ = input.readInt32();
                                    break;
                                case 24:
                                    this.f878z_ = input.readInt32();
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
            return Vector3IntOuterClass.internal_static_Vector3Int_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Vector3IntOuterClass.internal_static_Vector3Int_fieldAccessorTable.ensureFieldAccessorsInitialized(Vector3Int.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.Vector3IntOuterClass.Vector3IntOrBuilder
        public int getX() {
            return this.f876x_;
        }

        @Override // emu.grasscutter.net.proto.Vector3IntOuterClass.Vector3IntOrBuilder
        public int getY() {
            return this.f877y_;
        }

        @Override // emu.grasscutter.net.proto.Vector3IntOuterClass.Vector3IntOrBuilder
        public int getZ() {
            return this.f878z_;
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
            if (this.f876x_ != 0) {
                output.writeInt32(1, this.f876x_);
            }
            if (this.f877y_ != 0) {
                output.writeInt32(2, this.f877y_);
            }
            if (this.f878z_ != 0) {
                output.writeInt32(3, this.f878z_);
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
            if (this.f876x_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.f876x_);
            }
            if (this.f877y_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(2, this.f877y_);
            }
            if (this.f878z_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(3, this.f878z_);
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
            if (!(obj instanceof Vector3Int)) {
                return equals(obj);
            }
            Vector3Int other = (Vector3Int) obj;
            return getX() == other.getX() && getY() == other.getY() && getZ() == other.getZ() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getX())) + 2)) + getY())) + 3)) + getZ())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static Vector3Int parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Vector3Int parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Vector3Int parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Vector3Int parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Vector3Int parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Vector3Int parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Vector3Int parseFrom(InputStream input) throws IOException {
            return (Vector3Int) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Vector3Int parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Vector3Int) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static Vector3Int parseDelimitedFrom(InputStream input) throws IOException {
            return (Vector3Int) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static Vector3Int parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Vector3Int) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static Vector3Int parseFrom(CodedInputStream input) throws IOException {
            return (Vector3Int) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Vector3Int parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Vector3Int) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Vector3Int prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/Vector3IntOuterClass$Vector3Int$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Vector3IntOrBuilder {

            /* renamed from: x_ */
            private int f879x_;

            /* renamed from: y_ */
            private int f880y_;

            /* renamed from: z_ */
            private int f881z_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Vector3IntOuterClass.internal_static_Vector3Int_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Vector3IntOuterClass.internal_static_Vector3Int_fieldAccessorTable.ensureFieldAccessorsInitialized(Vector3Int.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Vector3Int.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.f879x_ = 0;
                this.f880y_ = 0;
                this.f881z_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Vector3IntOuterClass.internal_static_Vector3Int_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Vector3Int getDefaultInstanceForType() {
                return Vector3Int.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Vector3Int build() {
                Vector3Int result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Vector3Int buildPartial() {
                Vector3Int result = new Vector3Int(this);
                result.f876x_ = this.f879x_;
                result.f877y_ = this.f880y_;
                result.f878z_ = this.f881z_;
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
                if (other instanceof Vector3Int) {
                    return mergeFrom((Vector3Int) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Vector3Int other) {
                if (other == Vector3Int.getDefaultInstance()) {
                    return this;
                }
                if (other.getX() != 0) {
                    setX(other.getX());
                }
                if (other.getY() != 0) {
                    setY(other.getY());
                }
                if (other.getZ() != 0) {
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
                Vector3Int parsedMessage = null;
                try {
                    try {
                        parsedMessage = Vector3Int.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (Vector3Int) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.Vector3IntOuterClass.Vector3IntOrBuilder
            public int getX() {
                return this.f879x_;
            }

            public Builder setX(int value) {
                this.f879x_ = value;
                onChanged();
                return this;
            }

            public Builder clearX() {
                this.f879x_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.Vector3IntOuterClass.Vector3IntOrBuilder
            public int getY() {
                return this.f880y_;
            }

            public Builder setY(int value) {
                this.f880y_ = value;
                onChanged();
                return this;
            }

            public Builder clearY() {
                this.f880y_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.Vector3IntOuterClass.Vector3IntOrBuilder
            public int getZ() {
                return this.f881z_;
            }

            public Builder setZ(int value) {
                this.f881z_ = value;
                onChanged();
                return this;
            }

            public Builder clearZ() {
                this.f881z_ = 0;
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

        public static Vector3Int getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Vector3Int> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Vector3Int> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Vector3Int getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
