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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RobotPushPlayerDataNotifyOuterClass.class */
public final class RobotPushPlayerDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fRobotPushPlayerDataNotify.proto\"(\n\u0019RobotPushPlayerDataNotify\u0012\u000b\n\u0003bin\u0018\u0006 \u0001(\fB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_RobotPushPlayerDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RobotPushPlayerDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RobotPushPlayerDataNotify_descriptor, new String[]{"Bin"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RobotPushPlayerDataNotifyOuterClass$RobotPushPlayerDataNotifyOrBuilder.class */
    public interface RobotPushPlayerDataNotifyOrBuilder extends MessageOrBuilder {
        ByteString getBin();
    }

    private RobotPushPlayerDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RobotPushPlayerDataNotifyOuterClass$RobotPushPlayerDataNotify.class */
    public static final class RobotPushPlayerDataNotify extends GeneratedMessageV3 implements RobotPushPlayerDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BIN_FIELD_NUMBER = 6;
        private ByteString bin_;
        private byte memoizedIsInitialized;
        private static final RobotPushPlayerDataNotify DEFAULT_INSTANCE = new RobotPushPlayerDataNotify();
        private static final Parser<RobotPushPlayerDataNotify> PARSER = new AbstractParser<RobotPushPlayerDataNotify>() { // from class: emu.grasscutter.net.proto.RobotPushPlayerDataNotifyOuterClass.RobotPushPlayerDataNotify.1
            @Override // com.google.protobuf.Parser
            public RobotPushPlayerDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RobotPushPlayerDataNotify(input, extensionRegistry);
            }
        };

        private RobotPushPlayerDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RobotPushPlayerDataNotify() {
            this.memoizedIsInitialized = -1;
            this.bin_ = ByteString.EMPTY;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RobotPushPlayerDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RobotPushPlayerDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 50:
                                this.bin_ = input.readBytes();
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
            return RobotPushPlayerDataNotifyOuterClass.internal_static_RobotPushPlayerDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RobotPushPlayerDataNotifyOuterClass.internal_static_RobotPushPlayerDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(RobotPushPlayerDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RobotPushPlayerDataNotifyOuterClass.RobotPushPlayerDataNotifyOrBuilder
        public ByteString getBin() {
            return this.bin_;
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
            if (!this.bin_.isEmpty()) {
                output.writeBytes(6, this.bin_);
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
            if (!this.bin_.isEmpty()) {
                size2 = 0 + CodedOutputStream.computeBytesSize(6, this.bin_);
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
            if (!(obj instanceof RobotPushPlayerDataNotify)) {
                return equals(obj);
            }
            RobotPushPlayerDataNotify other = (RobotPushPlayerDataNotify) obj;
            return getBin().equals(other.getBin()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getBin().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static RobotPushPlayerDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RobotPushPlayerDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RobotPushPlayerDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RobotPushPlayerDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RobotPushPlayerDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RobotPushPlayerDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RobotPushPlayerDataNotify parseFrom(InputStream input) throws IOException {
            return (RobotPushPlayerDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RobotPushPlayerDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RobotPushPlayerDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RobotPushPlayerDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (RobotPushPlayerDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RobotPushPlayerDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RobotPushPlayerDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RobotPushPlayerDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (RobotPushPlayerDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RobotPushPlayerDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RobotPushPlayerDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RobotPushPlayerDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RobotPushPlayerDataNotifyOuterClass$RobotPushPlayerDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RobotPushPlayerDataNotifyOrBuilder {
            private ByteString bin_ = ByteString.EMPTY;

            public static final Descriptors.Descriptor getDescriptor() {
                return RobotPushPlayerDataNotifyOuterClass.internal_static_RobotPushPlayerDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RobotPushPlayerDataNotifyOuterClass.internal_static_RobotPushPlayerDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(RobotPushPlayerDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RobotPushPlayerDataNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.bin_ = ByteString.EMPTY;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RobotPushPlayerDataNotifyOuterClass.internal_static_RobotPushPlayerDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RobotPushPlayerDataNotify getDefaultInstanceForType() {
                return RobotPushPlayerDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RobotPushPlayerDataNotify build() {
                RobotPushPlayerDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RobotPushPlayerDataNotify buildPartial() {
                RobotPushPlayerDataNotify result = new RobotPushPlayerDataNotify(this);
                result.bin_ = this.bin_;
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
                if (other instanceof RobotPushPlayerDataNotify) {
                    return mergeFrom((RobotPushPlayerDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RobotPushPlayerDataNotify other) {
                if (other == RobotPushPlayerDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getBin() != ByteString.EMPTY) {
                    setBin(other.getBin());
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
                RobotPushPlayerDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = RobotPushPlayerDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RobotPushPlayerDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RobotPushPlayerDataNotifyOuterClass.RobotPushPlayerDataNotifyOrBuilder
            public ByteString getBin() {
                return this.bin_;
            }

            public Builder setBin(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bin_ = value;
                onChanged();
                return this;
            }

            public Builder clearBin() {
                this.bin_ = RobotPushPlayerDataNotify.getDefaultInstance().getBin();
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

        public static RobotPushPlayerDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RobotPushPlayerDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RobotPushPlayerDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RobotPushPlayerDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
