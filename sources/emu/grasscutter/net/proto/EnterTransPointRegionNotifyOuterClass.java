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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EnterTransPointRegionNotifyOuterClass.class */
public final class EnterTransPointRegionNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!EnterTransPointRegionNotify.proto\"?\n\u001bEnterTransPointRegionNotify\u0012\u000f\n\u0007pointId\u0018\u0001 \u0001(\r\u0012\u000f\n\u0007sceneId\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_EnterTransPointRegionNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EnterTransPointRegionNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EnterTransPointRegionNotify_descriptor, new String[]{"PointId", "SceneId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EnterTransPointRegionNotifyOuterClass$EnterTransPointRegionNotifyOrBuilder.class */
    public interface EnterTransPointRegionNotifyOrBuilder extends MessageOrBuilder {
        int getPointId();

        int getSceneId();
    }

    private EnterTransPointRegionNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EnterTransPointRegionNotifyOuterClass$EnterTransPointRegionNotify.class */
    public static final class EnterTransPointRegionNotify extends GeneratedMessageV3 implements EnterTransPointRegionNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int POINTID_FIELD_NUMBER = 1;
        private int pointId_;
        public static final int SCENEID_FIELD_NUMBER = 3;
        private int sceneId_;
        private byte memoizedIsInitialized;
        private static final EnterTransPointRegionNotify DEFAULT_INSTANCE = new EnterTransPointRegionNotify();
        private static final Parser<EnterTransPointRegionNotify> PARSER = new AbstractParser<EnterTransPointRegionNotify>() { // from class: emu.grasscutter.net.proto.EnterTransPointRegionNotifyOuterClass.EnterTransPointRegionNotify.1
            @Override // com.google.protobuf.Parser
            public EnterTransPointRegionNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EnterTransPointRegionNotify(input, extensionRegistry);
            }
        };

        private EnterTransPointRegionNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EnterTransPointRegionNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EnterTransPointRegionNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EnterTransPointRegionNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.pointId_ = input.readUInt32();
                                break;
                            case 24:
                                this.sceneId_ = input.readUInt32();
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
            return EnterTransPointRegionNotifyOuterClass.internal_static_EnterTransPointRegionNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EnterTransPointRegionNotifyOuterClass.internal_static_EnterTransPointRegionNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EnterTransPointRegionNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EnterTransPointRegionNotifyOuterClass.EnterTransPointRegionNotifyOrBuilder
        public int getPointId() {
            return this.pointId_;
        }

        @Override // emu.grasscutter.net.proto.EnterTransPointRegionNotifyOuterClass.EnterTransPointRegionNotifyOrBuilder
        public int getSceneId() {
            return this.sceneId_;
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
            if (this.pointId_ != 0) {
                output.writeUInt32(1, this.pointId_);
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(3, this.sceneId_);
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
            if (this.pointId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.pointId_);
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.sceneId_);
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
            if (!(obj instanceof EnterTransPointRegionNotify)) {
                return equals(obj);
            }
            EnterTransPointRegionNotify other = (EnterTransPointRegionNotify) obj;
            return getPointId() == other.getPointId() && getSceneId() == other.getSceneId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getPointId())) + 3)) + getSceneId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static EnterTransPointRegionNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EnterTransPointRegionNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EnterTransPointRegionNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EnterTransPointRegionNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EnterTransPointRegionNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EnterTransPointRegionNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EnterTransPointRegionNotify parseFrom(InputStream input) throws IOException {
            return (EnterTransPointRegionNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EnterTransPointRegionNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterTransPointRegionNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EnterTransPointRegionNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (EnterTransPointRegionNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EnterTransPointRegionNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterTransPointRegionNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EnterTransPointRegionNotify parseFrom(CodedInputStream input) throws IOException {
            return (EnterTransPointRegionNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EnterTransPointRegionNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterTransPointRegionNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EnterTransPointRegionNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EnterTransPointRegionNotifyOuterClass$EnterTransPointRegionNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EnterTransPointRegionNotifyOrBuilder {
            private int pointId_;
            private int sceneId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EnterTransPointRegionNotifyOuterClass.internal_static_EnterTransPointRegionNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EnterTransPointRegionNotifyOuterClass.internal_static_EnterTransPointRegionNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EnterTransPointRegionNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EnterTransPointRegionNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.pointId_ = 0;
                this.sceneId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EnterTransPointRegionNotifyOuterClass.internal_static_EnterTransPointRegionNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EnterTransPointRegionNotify getDefaultInstanceForType() {
                return EnterTransPointRegionNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EnterTransPointRegionNotify build() {
                EnterTransPointRegionNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EnterTransPointRegionNotify buildPartial() {
                EnterTransPointRegionNotify result = new EnterTransPointRegionNotify(this);
                result.pointId_ = this.pointId_;
                result.sceneId_ = this.sceneId_;
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
                if (other instanceof EnterTransPointRegionNotify) {
                    return mergeFrom((EnterTransPointRegionNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EnterTransPointRegionNotify other) {
                if (other == EnterTransPointRegionNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getPointId() != 0) {
                    setPointId(other.getPointId());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
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
                EnterTransPointRegionNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = EnterTransPointRegionNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EnterTransPointRegionNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EnterTransPointRegionNotifyOuterClass.EnterTransPointRegionNotifyOrBuilder
            public int getPointId() {
                return this.pointId_;
            }

            public Builder setPointId(int value) {
                this.pointId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPointId() {
                this.pointId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EnterTransPointRegionNotifyOuterClass.EnterTransPointRegionNotifyOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
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

        public static EnterTransPointRegionNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EnterTransPointRegionNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EnterTransPointRegionNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EnterTransPointRegionNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
