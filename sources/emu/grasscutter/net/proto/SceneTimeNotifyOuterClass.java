package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneTimeNotifyOuterClass.class */
public final class SceneTimeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015SceneTimeNotify.proto\"G\n\u000fSceneTimeNotify\u0012\u0010\n\bisPaused\u0018\u0004 \u0001(\b\u0012\u0011\n\tsceneTime\u0018\n \u0001(\u0004\u0012\u000f\n\u0007sceneId\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SceneTimeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneTimeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneTimeNotify_descriptor, new String[]{"IsPaused", "SceneTime", "SceneId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneTimeNotifyOuterClass$SceneTimeNotifyOrBuilder.class */
    public interface SceneTimeNotifyOrBuilder extends MessageOrBuilder {
        boolean getIsPaused();

        long getSceneTime();

        int getSceneId();
    }

    private SceneTimeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneTimeNotifyOuterClass$SceneTimeNotify.class */
    public static final class SceneTimeNotify extends GeneratedMessageV3 implements SceneTimeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISPAUSED_FIELD_NUMBER = 4;
        private boolean isPaused_;
        public static final int SCENETIME_FIELD_NUMBER = 10;
        private long sceneTime_;
        public static final int SCENEID_FIELD_NUMBER = 13;
        private int sceneId_;
        private byte memoizedIsInitialized;
        private static final SceneTimeNotify DEFAULT_INSTANCE = new SceneTimeNotify();
        private static final Parser<SceneTimeNotify> PARSER = new AbstractParser<SceneTimeNotify>() { // from class: emu.grasscutter.net.proto.SceneTimeNotifyOuterClass.SceneTimeNotify.1
            @Override // com.google.protobuf.Parser
            public SceneTimeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneTimeNotify(input, extensionRegistry);
            }
        };

        private SceneTimeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SceneTimeNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneTimeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneTimeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.isPaused_ = input.readBool();
                                    break;
                                case 80:
                                    this.sceneTime_ = input.readUInt64();
                                    break;
                                case 104:
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
            return SceneTimeNotifyOuterClass.internal_static_SceneTimeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneTimeNotifyOuterClass.internal_static_SceneTimeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneTimeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneTimeNotifyOuterClass.SceneTimeNotifyOrBuilder
        public boolean getIsPaused() {
            return this.isPaused_;
        }

        @Override // emu.grasscutter.net.proto.SceneTimeNotifyOuterClass.SceneTimeNotifyOrBuilder
        public long getSceneTime() {
            return this.sceneTime_;
        }

        @Override // emu.grasscutter.net.proto.SceneTimeNotifyOuterClass.SceneTimeNotifyOrBuilder
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
            if (this.isPaused_) {
                output.writeBool(4, this.isPaused_);
            }
            if (this.sceneTime_ != 0) {
                output.writeUInt64(10, this.sceneTime_);
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(13, this.sceneId_);
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
            if (this.isPaused_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(4, this.isPaused_);
            }
            if (this.sceneTime_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(10, this.sceneTime_);
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.sceneId_);
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
            if (!(obj instanceof SceneTimeNotify)) {
                return equals(obj);
            }
            SceneTimeNotify other = (SceneTimeNotify) obj;
            return getIsPaused() == other.getIsPaused() && getSceneTime() == other.getSceneTime() && getSceneId() == other.getSceneId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + Internal.hashBoolean(getIsPaused()))) + 10)) + Internal.hashLong(getSceneTime()))) + 13)) + getSceneId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SceneTimeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneTimeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneTimeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneTimeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneTimeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneTimeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneTimeNotify parseFrom(InputStream input) throws IOException {
            return (SceneTimeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneTimeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneTimeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneTimeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneTimeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneTimeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneTimeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneTimeNotify parseFrom(CodedInputStream input) throws IOException {
            return (SceneTimeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneTimeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneTimeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneTimeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneTimeNotifyOuterClass$SceneTimeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneTimeNotifyOrBuilder {
            private boolean isPaused_;
            private long sceneTime_;
            private int sceneId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneTimeNotifyOuterClass.internal_static_SceneTimeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneTimeNotifyOuterClass.internal_static_SceneTimeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneTimeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneTimeNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isPaused_ = false;
                this.sceneTime_ = 0;
                this.sceneId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneTimeNotifyOuterClass.internal_static_SceneTimeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneTimeNotify getDefaultInstanceForType() {
                return SceneTimeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneTimeNotify build() {
                SceneTimeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneTimeNotify buildPartial() {
                SceneTimeNotify result = new SceneTimeNotify(this);
                result.isPaused_ = this.isPaused_;
                result.sceneTime_ = this.sceneTime_;
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
                if (other instanceof SceneTimeNotify) {
                    return mergeFrom((SceneTimeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneTimeNotify other) {
                if (other == SceneTimeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsPaused()) {
                    setIsPaused(other.getIsPaused());
                }
                if (other.getSceneTime() != 0) {
                    setSceneTime(other.getSceneTime());
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
                SceneTimeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneTimeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneTimeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneTimeNotifyOuterClass.SceneTimeNotifyOrBuilder
            public boolean getIsPaused() {
                return this.isPaused_;
            }

            public Builder setIsPaused(boolean value) {
                this.isPaused_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsPaused() {
                this.isPaused_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneTimeNotifyOuterClass.SceneTimeNotifyOrBuilder
            public long getSceneTime() {
                return this.sceneTime_;
            }

            public Builder setSceneTime(long value) {
                this.sceneTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneTime() {
                this.sceneTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneTimeNotifyOuterClass.SceneTimeNotifyOrBuilder
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

        public static SceneTimeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneTimeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneTimeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneTimeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
