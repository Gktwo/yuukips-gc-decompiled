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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MonsterAIConfigHashNotifyOuterClass.class */
public final class MonsterAIConfigHashNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fMonsterAIConfigHashNotify.proto\"R\n\u0019MonsterAIConfigHashNotify\u0012\u0012\n\nhash_value\u0018\u0007 \u0001(\u0005\u0012\u0011\n\tentity_id\u0018\u000e \u0001(\r\u0012\u000e\n\u0006job_id\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_MonsterAIConfigHashNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MonsterAIConfigHashNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MonsterAIConfigHashNotify_descriptor, new String[]{"HashValue", "EntityId", "JobId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MonsterAIConfigHashNotifyOuterClass$MonsterAIConfigHashNotifyOrBuilder.class */
    public interface MonsterAIConfigHashNotifyOrBuilder extends MessageOrBuilder {
        int getHashValue();

        int getEntityId();

        int getJobId();
    }

    private MonsterAIConfigHashNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MonsterAIConfigHashNotifyOuterClass$MonsterAIConfigHashNotify.class */
    public static final class MonsterAIConfigHashNotify extends GeneratedMessageV3 implements MonsterAIConfigHashNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int HASH_VALUE_FIELD_NUMBER = 7;
        private int hashValue_;
        public static final int ENTITY_ID_FIELD_NUMBER = 14;
        private int entityId_;
        public static final int JOB_ID_FIELD_NUMBER = 11;
        private int jobId_;
        private byte memoizedIsInitialized;
        private static final MonsterAIConfigHashNotify DEFAULT_INSTANCE = new MonsterAIConfigHashNotify();
        private static final Parser<MonsterAIConfigHashNotify> PARSER = new AbstractParser<MonsterAIConfigHashNotify>() { // from class: emu.grasscutter.net.proto.MonsterAIConfigHashNotifyOuterClass.MonsterAIConfigHashNotify.1
            @Override // com.google.protobuf.Parser
            public MonsterAIConfigHashNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MonsterAIConfigHashNotify(input, extensionRegistry);
            }
        };

        private MonsterAIConfigHashNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MonsterAIConfigHashNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MonsterAIConfigHashNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MonsterAIConfigHashNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 56:
                                    this.hashValue_ = input.readInt32();
                                    break;
                                case 88:
                                    this.jobId_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.entityId_ = input.readUInt32();
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
            return MonsterAIConfigHashNotifyOuterClass.internal_static_MonsterAIConfigHashNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MonsterAIConfigHashNotifyOuterClass.internal_static_MonsterAIConfigHashNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(MonsterAIConfigHashNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MonsterAIConfigHashNotifyOuterClass.MonsterAIConfigHashNotifyOrBuilder
        public int getHashValue() {
            return this.hashValue_;
        }

        @Override // emu.grasscutter.net.proto.MonsterAIConfigHashNotifyOuterClass.MonsterAIConfigHashNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.MonsterAIConfigHashNotifyOuterClass.MonsterAIConfigHashNotifyOrBuilder
        public int getJobId() {
            return this.jobId_;
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
            if (this.hashValue_ != 0) {
                output.writeInt32(7, this.hashValue_);
            }
            if (this.jobId_ != 0) {
                output.writeUInt32(11, this.jobId_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(14, this.entityId_);
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
            if (this.hashValue_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(7, this.hashValue_);
            }
            if (this.jobId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.jobId_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.entityId_);
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
            if (!(obj instanceof MonsterAIConfigHashNotify)) {
                return equals(obj);
            }
            MonsterAIConfigHashNotify other = (MonsterAIConfigHashNotify) obj;
            return getHashValue() == other.getHashValue() && getEntityId() == other.getEntityId() && getJobId() == other.getJobId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getHashValue())) + 14)) + getEntityId())) + 11)) + getJobId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MonsterAIConfigHashNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MonsterAIConfigHashNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MonsterAIConfigHashNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MonsterAIConfigHashNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MonsterAIConfigHashNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MonsterAIConfigHashNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MonsterAIConfigHashNotify parseFrom(InputStream input) throws IOException {
            return (MonsterAIConfigHashNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MonsterAIConfigHashNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MonsterAIConfigHashNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MonsterAIConfigHashNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (MonsterAIConfigHashNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MonsterAIConfigHashNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MonsterAIConfigHashNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MonsterAIConfigHashNotify parseFrom(CodedInputStream input) throws IOException {
            return (MonsterAIConfigHashNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MonsterAIConfigHashNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MonsterAIConfigHashNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MonsterAIConfigHashNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MonsterAIConfigHashNotifyOuterClass$MonsterAIConfigHashNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MonsterAIConfigHashNotifyOrBuilder {
            private int hashValue_;
            private int entityId_;
            private int jobId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MonsterAIConfigHashNotifyOuterClass.internal_static_MonsterAIConfigHashNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MonsterAIConfigHashNotifyOuterClass.internal_static_MonsterAIConfigHashNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(MonsterAIConfigHashNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MonsterAIConfigHashNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.hashValue_ = 0;
                this.entityId_ = 0;
                this.jobId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MonsterAIConfigHashNotifyOuterClass.internal_static_MonsterAIConfigHashNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MonsterAIConfigHashNotify getDefaultInstanceForType() {
                return MonsterAIConfigHashNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MonsterAIConfigHashNotify build() {
                MonsterAIConfigHashNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MonsterAIConfigHashNotify buildPartial() {
                MonsterAIConfigHashNotify result = new MonsterAIConfigHashNotify(this);
                result.hashValue_ = this.hashValue_;
                result.entityId_ = this.entityId_;
                result.jobId_ = this.jobId_;
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
                if (other instanceof MonsterAIConfigHashNotify) {
                    return mergeFrom((MonsterAIConfigHashNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MonsterAIConfigHashNotify other) {
                if (other == MonsterAIConfigHashNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getHashValue() != 0) {
                    setHashValue(other.getHashValue());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getJobId() != 0) {
                    setJobId(other.getJobId());
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
                MonsterAIConfigHashNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = MonsterAIConfigHashNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MonsterAIConfigHashNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MonsterAIConfigHashNotifyOuterClass.MonsterAIConfigHashNotifyOrBuilder
            public int getHashValue() {
                return this.hashValue_;
            }

            public Builder setHashValue(int value) {
                this.hashValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearHashValue() {
                this.hashValue_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MonsterAIConfigHashNotifyOuterClass.MonsterAIConfigHashNotifyOrBuilder
            public int getEntityId() {
                return this.entityId_;
            }

            public Builder setEntityId(int value) {
                this.entityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntityId() {
                this.entityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MonsterAIConfigHashNotifyOuterClass.MonsterAIConfigHashNotifyOrBuilder
            public int getJobId() {
                return this.jobId_;
            }

            public Builder setJobId(int value) {
                this.jobId_ = value;
                onChanged();
                return this;
            }

            public Builder clearJobId() {
                this.jobId_ = 0;
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

        public static MonsterAIConfigHashNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MonsterAIConfigHashNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MonsterAIConfigHashNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MonsterAIConfigHashNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
