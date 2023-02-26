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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBlockDotPatternOuterClass.class */
public final class HomeBlockDotPatternOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019HomeBlockDotPattern.proto\"B\n\u0013HomeBlockDotPattern\u0012\r\n\u0005width\u0018\u0003 \u0001(\r\u0012\f\n\u0004data\u0018\u000e \u0001(\f\u0012\u000e\n\u0006height\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_HomeBlockDotPattern_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeBlockDotPattern_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeBlockDotPattern_descriptor, new String[]{"Width", "Data", "Height"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBlockDotPatternOuterClass$HomeBlockDotPatternOrBuilder.class */
    public interface HomeBlockDotPatternOrBuilder extends MessageOrBuilder {
        int getWidth();

        ByteString getData();

        int getHeight();
    }

    private HomeBlockDotPatternOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBlockDotPatternOuterClass$HomeBlockDotPattern.class */
    public static final class HomeBlockDotPattern extends GeneratedMessageV3 implements HomeBlockDotPatternOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int WIDTH_FIELD_NUMBER = 3;
        private int width_;
        public static final int DATA_FIELD_NUMBER = 14;
        private ByteString data_;
        public static final int HEIGHT_FIELD_NUMBER = 8;
        private int height_;
        private byte memoizedIsInitialized;
        private static final HomeBlockDotPattern DEFAULT_INSTANCE = new HomeBlockDotPattern();
        private static final Parser<HomeBlockDotPattern> PARSER = new AbstractParser<HomeBlockDotPattern>() { // from class: emu.grasscutter.net.proto.HomeBlockDotPatternOuterClass.HomeBlockDotPattern.1
            @Override // com.google.protobuf.Parser
            public HomeBlockDotPattern parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeBlockDotPattern(input, extensionRegistry);
            }
        };

        private HomeBlockDotPattern(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeBlockDotPattern() {
            this.memoizedIsInitialized = -1;
            this.data_ = ByteString.EMPTY;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeBlockDotPattern();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeBlockDotPattern(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.width_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.height_ = input.readUInt32();
                                    break;
                                case 114:
                                    this.data_ = input.readBytes();
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
            return HomeBlockDotPatternOuterClass.internal_static_HomeBlockDotPattern_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeBlockDotPatternOuterClass.internal_static_HomeBlockDotPattern_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeBlockDotPattern.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockDotPatternOuterClass.HomeBlockDotPatternOrBuilder
        public int getWidth() {
            return this.width_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockDotPatternOuterClass.HomeBlockDotPatternOrBuilder
        public ByteString getData() {
            return this.data_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockDotPatternOuterClass.HomeBlockDotPatternOrBuilder
        public int getHeight() {
            return this.height_;
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
            if (this.width_ != 0) {
                output.writeUInt32(3, this.width_);
            }
            if (this.height_ != 0) {
                output.writeUInt32(8, this.height_);
            }
            if (!this.data_.isEmpty()) {
                output.writeBytes(14, this.data_);
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
            if (this.width_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.width_);
            }
            if (this.height_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.height_);
            }
            if (!this.data_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(14, this.data_);
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
            if (!(obj instanceof HomeBlockDotPattern)) {
                return equals(obj);
            }
            HomeBlockDotPattern other = (HomeBlockDotPattern) obj;
            return getWidth() == other.getWidth() && getData().equals(other.getData()) && getHeight() == other.getHeight() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getWidth())) + 14)) + getData().hashCode())) + 8)) + getHeight())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static HomeBlockDotPattern parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeBlockDotPattern parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeBlockDotPattern parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeBlockDotPattern parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeBlockDotPattern parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeBlockDotPattern parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeBlockDotPattern parseFrom(InputStream input) throws IOException {
            return (HomeBlockDotPattern) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeBlockDotPattern parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeBlockDotPattern) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeBlockDotPattern parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeBlockDotPattern) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeBlockDotPattern parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeBlockDotPattern) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeBlockDotPattern parseFrom(CodedInputStream input) throws IOException {
            return (HomeBlockDotPattern) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeBlockDotPattern parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeBlockDotPattern) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeBlockDotPattern prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBlockDotPatternOuterClass$HomeBlockDotPattern$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeBlockDotPatternOrBuilder {
            private int width_;
            private ByteString data_ = ByteString.EMPTY;
            private int height_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeBlockDotPatternOuterClass.internal_static_HomeBlockDotPattern_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeBlockDotPatternOuterClass.internal_static_HomeBlockDotPattern_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeBlockDotPattern.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeBlockDotPattern.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.width_ = 0;
                this.data_ = ByteString.EMPTY;
                this.height_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeBlockDotPatternOuterClass.internal_static_HomeBlockDotPattern_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeBlockDotPattern getDefaultInstanceForType() {
                return HomeBlockDotPattern.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeBlockDotPattern build() {
                HomeBlockDotPattern result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeBlockDotPattern buildPartial() {
                HomeBlockDotPattern result = new HomeBlockDotPattern(this);
                result.width_ = this.width_;
                result.data_ = this.data_;
                result.height_ = this.height_;
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
                if (other instanceof HomeBlockDotPattern) {
                    return mergeFrom((HomeBlockDotPattern) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeBlockDotPattern other) {
                if (other == HomeBlockDotPattern.getDefaultInstance()) {
                    return this;
                }
                if (other.getWidth() != 0) {
                    setWidth(other.getWidth());
                }
                if (other.getData() != ByteString.EMPTY) {
                    setData(other.getData());
                }
                if (other.getHeight() != 0) {
                    setHeight(other.getHeight());
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
                HomeBlockDotPattern parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeBlockDotPattern.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeBlockDotPattern) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeBlockDotPatternOuterClass.HomeBlockDotPatternOrBuilder
            public int getWidth() {
                return this.width_;
            }

            public Builder setWidth(int value) {
                this.width_ = value;
                onChanged();
                return this;
            }

            public Builder clearWidth() {
                this.width_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeBlockDotPatternOuterClass.HomeBlockDotPatternOrBuilder
            public ByteString getData() {
                return this.data_;
            }

            public Builder setData(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.data_ = value;
                onChanged();
                return this;
            }

            public Builder clearData() {
                this.data_ = HomeBlockDotPattern.getDefaultInstance().getData();
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeBlockDotPatternOuterClass.HomeBlockDotPatternOrBuilder
            public int getHeight() {
                return this.height_;
            }

            public Builder setHeight(int value) {
                this.height_ = value;
                onChanged();
                return this;
            }

            public Builder clearHeight() {
                this.height_ = 0;
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

        public static HomeBlockDotPattern getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeBlockDotPattern> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeBlockDotPattern> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeBlockDotPattern getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
