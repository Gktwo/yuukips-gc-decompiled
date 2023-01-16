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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocencePhotoObjectInfoOuterClass.class */
public final class GravenInnocencePhotoObjectInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$GravenInnocencePhotoObjectInfo.proto\"W\n\u001eGravenInnocencePhotoObjectInfo\u0012\u0011\n\tobject_id\u0018\u0004 \u0001(\r\u0012\r\n\u0005param\u0018\u000f \u0001(\r\u0012\u0013\n\u000bfinish_time\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GravenInnocencePhotoObjectInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_GravenInnocencePhotoObjectInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f751xe0e3e97d = new GeneratedMessageV3.FieldAccessorTable(internal_static_GravenInnocencePhotoObjectInfo_descriptor, new String[]{"ObjectId", "Param", "FinishTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocencePhotoObjectInfoOuterClass$GravenInnocencePhotoObjectInfoOrBuilder.class */
    public interface GravenInnocencePhotoObjectInfoOrBuilder extends MessageOrBuilder {
        int getObjectId();

        int getParam();

        int getFinishTime();
    }

    private GravenInnocencePhotoObjectInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocencePhotoObjectInfoOuterClass$GravenInnocencePhotoObjectInfo.class */
    public static final class GravenInnocencePhotoObjectInfo extends GeneratedMessageV3 implements GravenInnocencePhotoObjectInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OBJECT_ID_FIELD_NUMBER = 4;
        private int objectId_;
        public static final int PARAM_FIELD_NUMBER = 15;
        private int param_;
        public static final int FINISH_TIME_FIELD_NUMBER = 10;
        private int finishTime_;
        private byte memoizedIsInitialized;
        private static final GravenInnocencePhotoObjectInfo DEFAULT_INSTANCE = new GravenInnocencePhotoObjectInfo();
        private static final Parser<GravenInnocencePhotoObjectInfo> PARSER = new AbstractParser<GravenInnocencePhotoObjectInfo>() { // from class: emu.grasscutter.net.proto.GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo.1
            @Override // com.google.protobuf.Parser
            public GravenInnocencePhotoObjectInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GravenInnocencePhotoObjectInfo(input, extensionRegistry);
            }
        };

        private GravenInnocencePhotoObjectInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GravenInnocencePhotoObjectInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GravenInnocencePhotoObjectInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GravenInnocencePhotoObjectInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.objectId_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.finishTime_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.param_ = input.readUInt32();
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
            return GravenInnocencePhotoObjectInfoOuterClass.internal_static_GravenInnocencePhotoObjectInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GravenInnocencePhotoObjectInfoOuterClass.f751xe0e3e97d.ensureFieldAccessorsInitialized(GravenInnocencePhotoObjectInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfoOrBuilder
        public int getObjectId() {
            return this.objectId_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfoOrBuilder
        public int getParam() {
            return this.param_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfoOrBuilder
        public int getFinishTime() {
            return this.finishTime_;
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
            if (this.objectId_ != 0) {
                output.writeUInt32(4, this.objectId_);
            }
            if (this.finishTime_ != 0) {
                output.writeUInt32(10, this.finishTime_);
            }
            if (this.param_ != 0) {
                output.writeUInt32(15, this.param_);
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
            if (this.objectId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.objectId_);
            }
            if (this.finishTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.finishTime_);
            }
            if (this.param_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.param_);
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
            if (!(obj instanceof GravenInnocencePhotoObjectInfo)) {
                return equals(obj);
            }
            GravenInnocencePhotoObjectInfo other = (GravenInnocencePhotoObjectInfo) obj;
            return getObjectId() == other.getObjectId() && getParam() == other.getParam() && getFinishTime() == other.getFinishTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getObjectId())) + 15)) + getParam())) + 10)) + getFinishTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static GravenInnocencePhotoObjectInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocencePhotoObjectInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocencePhotoObjectInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocencePhotoObjectInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocencePhotoObjectInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocencePhotoObjectInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocencePhotoObjectInfo parseFrom(InputStream input) throws IOException {
            return (GravenInnocencePhotoObjectInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GravenInnocencePhotoObjectInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocencePhotoObjectInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GravenInnocencePhotoObjectInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GravenInnocencePhotoObjectInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GravenInnocencePhotoObjectInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocencePhotoObjectInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GravenInnocencePhotoObjectInfo parseFrom(CodedInputStream input) throws IOException {
            return (GravenInnocencePhotoObjectInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GravenInnocencePhotoObjectInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocencePhotoObjectInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GravenInnocencePhotoObjectInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocencePhotoObjectInfoOuterClass$GravenInnocencePhotoObjectInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GravenInnocencePhotoObjectInfoOrBuilder {
            private int objectId_;
            private int param_;
            private int finishTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GravenInnocencePhotoObjectInfoOuterClass.internal_static_GravenInnocencePhotoObjectInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GravenInnocencePhotoObjectInfoOuterClass.f751xe0e3e97d.ensureFieldAccessorsInitialized(GravenInnocencePhotoObjectInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GravenInnocencePhotoObjectInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.objectId_ = 0;
                this.param_ = 0;
                this.finishTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GravenInnocencePhotoObjectInfoOuterClass.internal_static_GravenInnocencePhotoObjectInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GravenInnocencePhotoObjectInfo getDefaultInstanceForType() {
                return GravenInnocencePhotoObjectInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GravenInnocencePhotoObjectInfo build() {
                GravenInnocencePhotoObjectInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GravenInnocencePhotoObjectInfo buildPartial() {
                GravenInnocencePhotoObjectInfo result = new GravenInnocencePhotoObjectInfo(this);
                result.objectId_ = this.objectId_;
                result.param_ = this.param_;
                result.finishTime_ = this.finishTime_;
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
                if (other instanceof GravenInnocencePhotoObjectInfo) {
                    return mergeFrom((GravenInnocencePhotoObjectInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GravenInnocencePhotoObjectInfo other) {
                if (other == GravenInnocencePhotoObjectInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getObjectId() != 0) {
                    setObjectId(other.getObjectId());
                }
                if (other.getParam() != 0) {
                    setParam(other.getParam());
                }
                if (other.getFinishTime() != 0) {
                    setFinishTime(other.getFinishTime());
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
                GravenInnocencePhotoObjectInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = GravenInnocencePhotoObjectInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GravenInnocencePhotoObjectInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfoOrBuilder
            public int getObjectId() {
                return this.objectId_;
            }

            public Builder setObjectId(int value) {
                this.objectId_ = value;
                onChanged();
                return this;
            }

            public Builder clearObjectId() {
                this.objectId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfoOrBuilder
            public int getParam() {
                return this.param_;
            }

            public Builder setParam(int value) {
                this.param_ = value;
                onChanged();
                return this;
            }

            public Builder clearParam() {
                this.param_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfoOrBuilder
            public int getFinishTime() {
                return this.finishTime_;
            }

            public Builder setFinishTime(int value) {
                this.finishTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearFinishTime() {
                this.finishTime_ = 0;
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

        public static GravenInnocencePhotoObjectInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GravenInnocencePhotoObjectInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GravenInnocencePhotoObjectInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GravenInnocencePhotoObjectInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
