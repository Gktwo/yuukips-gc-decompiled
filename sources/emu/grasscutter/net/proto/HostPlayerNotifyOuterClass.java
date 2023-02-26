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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HostPlayerNotifyOuterClass.class */
public final class HostPlayerNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016HostPlayerNotify.proto\"7\n\u0010HostPlayerNotify\u0012\u000f\n\u0007hostUid\u0018\u0004 \u0001(\r\u0012\u0012\n\nhostPeerId\u0018\u0005 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_HostPlayerNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HostPlayerNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HostPlayerNotify_descriptor, new String[]{"HostUid", "HostPeerId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HostPlayerNotifyOuterClass$HostPlayerNotifyOrBuilder.class */
    public interface HostPlayerNotifyOrBuilder extends MessageOrBuilder {
        int getHostUid();

        int getHostPeerId();
    }

    private HostPlayerNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HostPlayerNotifyOuterClass$HostPlayerNotify.class */
    public static final class HostPlayerNotify extends GeneratedMessageV3 implements HostPlayerNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int HOSTUID_FIELD_NUMBER = 4;
        private int hostUid_;
        public static final int HOSTPEERID_FIELD_NUMBER = 5;
        private int hostPeerId_;
        private byte memoizedIsInitialized;
        private static final HostPlayerNotify DEFAULT_INSTANCE = new HostPlayerNotify();
        private static final Parser<HostPlayerNotify> PARSER = new AbstractParser<HostPlayerNotify>() { // from class: emu.grasscutter.net.proto.HostPlayerNotifyOuterClass.HostPlayerNotify.1
            @Override // com.google.protobuf.Parser
            public HostPlayerNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HostPlayerNotify(input, extensionRegistry);
            }
        };

        private HostPlayerNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HostPlayerNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HostPlayerNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HostPlayerNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.hostUid_ = input.readUInt32();
                                break;
                            case 40:
                                this.hostPeerId_ = input.readUInt32();
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
            return HostPlayerNotifyOuterClass.internal_static_HostPlayerNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HostPlayerNotifyOuterClass.internal_static_HostPlayerNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(HostPlayerNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HostPlayerNotifyOuterClass.HostPlayerNotifyOrBuilder
        public int getHostUid() {
            return this.hostUid_;
        }

        @Override // emu.grasscutter.net.proto.HostPlayerNotifyOuterClass.HostPlayerNotifyOrBuilder
        public int getHostPeerId() {
            return this.hostPeerId_;
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
            if (this.hostUid_ != 0) {
                output.writeUInt32(4, this.hostUid_);
            }
            if (this.hostPeerId_ != 0) {
                output.writeUInt32(5, this.hostPeerId_);
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
            if (this.hostUid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.hostUid_);
            }
            if (this.hostPeerId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.hostPeerId_);
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
            if (!(obj instanceof HostPlayerNotify)) {
                return equals(obj);
            }
            HostPlayerNotify other = (HostPlayerNotify) obj;
            return getHostUid() == other.getHostUid() && getHostPeerId() == other.getHostPeerId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getHostUid())) + 5)) + getHostPeerId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static HostPlayerNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HostPlayerNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HostPlayerNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HostPlayerNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HostPlayerNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HostPlayerNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HostPlayerNotify parseFrom(InputStream input) throws IOException {
            return (HostPlayerNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HostPlayerNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HostPlayerNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HostPlayerNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (HostPlayerNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HostPlayerNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HostPlayerNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HostPlayerNotify parseFrom(CodedInputStream input) throws IOException {
            return (HostPlayerNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HostPlayerNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HostPlayerNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HostPlayerNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HostPlayerNotifyOuterClass$HostPlayerNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HostPlayerNotifyOrBuilder {
            private int hostUid_;
            private int hostPeerId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HostPlayerNotifyOuterClass.internal_static_HostPlayerNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HostPlayerNotifyOuterClass.internal_static_HostPlayerNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(HostPlayerNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HostPlayerNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.hostUid_ = 0;
                this.hostPeerId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HostPlayerNotifyOuterClass.internal_static_HostPlayerNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HostPlayerNotify getDefaultInstanceForType() {
                return HostPlayerNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HostPlayerNotify build() {
                HostPlayerNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HostPlayerNotify buildPartial() {
                HostPlayerNotify result = new HostPlayerNotify(this);
                result.hostUid_ = this.hostUid_;
                result.hostPeerId_ = this.hostPeerId_;
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
                if (other instanceof HostPlayerNotify) {
                    return mergeFrom((HostPlayerNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HostPlayerNotify other) {
                if (other == HostPlayerNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getHostUid() != 0) {
                    setHostUid(other.getHostUid());
                }
                if (other.getHostPeerId() != 0) {
                    setHostPeerId(other.getHostPeerId());
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
                HostPlayerNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = HostPlayerNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HostPlayerNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HostPlayerNotifyOuterClass.HostPlayerNotifyOrBuilder
            public int getHostUid() {
                return this.hostUid_;
            }

            public Builder setHostUid(int value) {
                this.hostUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearHostUid() {
                this.hostUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HostPlayerNotifyOuterClass.HostPlayerNotifyOrBuilder
            public int getHostPeerId() {
                return this.hostPeerId_;
            }

            public Builder setHostPeerId(int value) {
                this.hostPeerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearHostPeerId() {
                this.hostPeerId_ = 0;
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

        public static HostPlayerNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HostPlayerNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HostPlayerNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HostPlayerNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
