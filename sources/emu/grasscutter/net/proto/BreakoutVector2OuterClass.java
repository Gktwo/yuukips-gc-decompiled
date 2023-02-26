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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutVector2OuterClass.class */
public final class BreakoutVector2OuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015BreakoutVector2.proto\"'\n\u000fBreakoutVector2\u0012\t\n\u0001x\u0018\u0001 \u0001(\u0005\u0012\t\n\u0001y\u0018\u0002 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BreakoutVector2_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BreakoutVector2_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BreakoutVector2_descriptor, new String[]{"X", "Y"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutVector2OuterClass$BreakoutVector2OrBuilder.class */
    public interface BreakoutVector2OrBuilder extends MessageOrBuilder {
        int getX();

        int getY();
    }

    private BreakoutVector2OuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutVector2OuterClass$BreakoutVector2.class */
    public static final class BreakoutVector2 extends GeneratedMessageV3 implements BreakoutVector2OrBuilder {
        private static final long serialVersionUID = 0;
        public static final int X_FIELD_NUMBER = 1;

        /* renamed from: x_ */
        private int f662x_;
        public static final int Y_FIELD_NUMBER = 2;

        /* renamed from: y_ */
        private int f663y_;
        private byte memoizedIsInitialized;
        private static final BreakoutVector2 DEFAULT_INSTANCE = new BreakoutVector2();
        private static final Parser<BreakoutVector2> PARSER = new AbstractParser<BreakoutVector2>() { // from class: emu.grasscutter.net.proto.BreakoutVector2OuterClass.BreakoutVector2.1
            @Override // com.google.protobuf.Parser
            public BreakoutVector2 parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BreakoutVector2(input, extensionRegistry);
            }
        };

        private BreakoutVector2(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BreakoutVector2() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BreakoutVector2();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BreakoutVector2(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.f662x_ = input.readInt32();
                                break;
                            case 16:
                                this.f663y_ = input.readInt32();
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
            return BreakoutVector2OuterClass.internal_static_BreakoutVector2_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BreakoutVector2OuterClass.internal_static_BreakoutVector2_fieldAccessorTable.ensureFieldAccessorsInitialized(BreakoutVector2.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BreakoutVector2OuterClass.BreakoutVector2OrBuilder
        public int getX() {
            return this.f662x_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutVector2OuterClass.BreakoutVector2OrBuilder
        public int getY() {
            return this.f663y_;
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
            if (this.f662x_ != 0) {
                output.writeInt32(1, this.f662x_);
            }
            if (this.f663y_ != 0) {
                output.writeInt32(2, this.f663y_);
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
            if (this.f662x_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.f662x_);
            }
            if (this.f663y_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(2, this.f663y_);
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
            if (!(obj instanceof BreakoutVector2)) {
                return equals(obj);
            }
            BreakoutVector2 other = (BreakoutVector2) obj;
            return getX() == other.getX() && getY() == other.getY() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getX())) + 2)) + getY())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static BreakoutVector2 parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutVector2 parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutVector2 parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutVector2 parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutVector2 parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutVector2 parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutVector2 parseFrom(InputStream input) throws IOException {
            return (BreakoutVector2) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutVector2 parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutVector2) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutVector2 parseDelimitedFrom(InputStream input) throws IOException {
            return (BreakoutVector2) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BreakoutVector2 parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutVector2) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutVector2 parseFrom(CodedInputStream input) throws IOException {
            return (BreakoutVector2) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutVector2 parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutVector2) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BreakoutVector2 prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutVector2OuterClass$BreakoutVector2$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BreakoutVector2OrBuilder {

            /* renamed from: x_ */
            private int f664x_;

            /* renamed from: y_ */
            private int f665y_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BreakoutVector2OuterClass.internal_static_BreakoutVector2_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BreakoutVector2OuterClass.internal_static_BreakoutVector2_fieldAccessorTable.ensureFieldAccessorsInitialized(BreakoutVector2.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BreakoutVector2.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.f664x_ = 0;
                this.f665y_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BreakoutVector2OuterClass.internal_static_BreakoutVector2_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BreakoutVector2 getDefaultInstanceForType() {
                return BreakoutVector2.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutVector2 build() {
                BreakoutVector2 result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutVector2 buildPartial() {
                BreakoutVector2 result = new BreakoutVector2(this);
                result.f662x_ = this.f664x_;
                result.f663y_ = this.f665y_;
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
                if (other instanceof BreakoutVector2) {
                    return mergeFrom((BreakoutVector2) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BreakoutVector2 other) {
                if (other == BreakoutVector2.getDefaultInstance()) {
                    return this;
                }
                if (other.getX() != 0) {
                    setX(other.getX());
                }
                if (other.getY() != 0) {
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
                BreakoutVector2 parsedMessage = null;
                try {
                    try {
                        parsedMessage = BreakoutVector2.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BreakoutVector2) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutVector2OuterClass.BreakoutVector2OrBuilder
            public int getX() {
                return this.f664x_;
            }

            public Builder setX(int value) {
                this.f664x_ = value;
                onChanged();
                return this;
            }

            public Builder clearX() {
                this.f664x_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutVector2OuterClass.BreakoutVector2OrBuilder
            public int getY() {
                return this.f665y_;
            }

            public Builder setY(int value) {
                this.f665y_ = value;
                onChanged();
                return this;
            }

            public Builder clearY() {
                this.f665y_ = 0;
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

        public static BreakoutVector2 getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BreakoutVector2> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BreakoutVector2> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BreakoutVector2 getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
