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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityConfigHashEntryOuterClass.class */
public final class EntityConfigHashEntryOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bEntityConfigHashEntry.proto\"K\n\u0015EntityConfigHashEntry\u0012\u0010\n\bentityId\u0018\u0003 \u0001(\r\u0012\r\n\u0005jobId\u0018\f \u0001(\r\u0012\u0011\n\thashValue\u0018\u0006 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_EntityConfigHashEntry_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EntityConfigHashEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EntityConfigHashEntry_descriptor, new String[]{"EntityId", "JobId", "HashValue"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityConfigHashEntryOuterClass$EntityConfigHashEntryOrBuilder.class */
    public interface EntityConfigHashEntryOrBuilder extends MessageOrBuilder {
        int getEntityId();

        int getJobId();

        int getHashValue();
    }

    private EntityConfigHashEntryOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityConfigHashEntryOuterClass$EntityConfigHashEntry.class */
    public static final class EntityConfigHashEntry extends GeneratedMessageV3 implements EntityConfigHashEntryOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITYID_FIELD_NUMBER = 3;
        private int entityId_;
        public static final int JOBID_FIELD_NUMBER = 12;
        private int jobId_;
        public static final int HASHVALUE_FIELD_NUMBER = 6;
        private int hashValue_;
        private byte memoizedIsInitialized;
        private static final EntityConfigHashEntry DEFAULT_INSTANCE = new EntityConfigHashEntry();
        private static final Parser<EntityConfigHashEntry> PARSER = new AbstractParser<EntityConfigHashEntry>() { // from class: emu.grasscutter.net.proto.EntityConfigHashEntryOuterClass.EntityConfigHashEntry.1
            @Override // com.google.protobuf.Parser
            public EntityConfigHashEntry parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntityConfigHashEntry(input, extensionRegistry);
            }
        };

        private EntityConfigHashEntry(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EntityConfigHashEntry() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EntityConfigHashEntry();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EntityConfigHashEntry(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.entityId_ = input.readUInt32();
                                    break;
                                case 48:
                                    this.hashValue_ = input.readInt32();
                                    break;
                                case 96:
                                    this.jobId_ = input.readUInt32();
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
            return EntityConfigHashEntryOuterClass.internal_static_EntityConfigHashEntry_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntityConfigHashEntryOuterClass.internal_static_EntityConfigHashEntry_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityConfigHashEntry.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder
        public int getJobId() {
            return this.jobId_;
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder
        public int getHashValue() {
            return this.hashValue_;
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
            if (this.entityId_ != 0) {
                output.writeUInt32(3, this.entityId_);
            }
            if (this.hashValue_ != 0) {
                output.writeInt32(6, this.hashValue_);
            }
            if (this.jobId_ != 0) {
                output.writeUInt32(12, this.jobId_);
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
            if (this.entityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.entityId_);
            }
            if (this.hashValue_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(6, this.hashValue_);
            }
            if (this.jobId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.jobId_);
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
            if (!(obj instanceof EntityConfigHashEntry)) {
                return equals(obj);
            }
            EntityConfigHashEntry other = (EntityConfigHashEntry) obj;
            return getEntityId() == other.getEntityId() && getJobId() == other.getJobId() && getHashValue() == other.getHashValue() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getEntityId())) + 12)) + getJobId())) + 6)) + getHashValue())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static EntityConfigHashEntry parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityConfigHashEntry parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityConfigHashEntry parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityConfigHashEntry parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityConfigHashEntry parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityConfigHashEntry parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityConfigHashEntry parseFrom(InputStream input) throws IOException {
            return (EntityConfigHashEntry) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityConfigHashEntry parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityConfigHashEntry) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityConfigHashEntry parseDelimitedFrom(InputStream input) throws IOException {
            return (EntityConfigHashEntry) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EntityConfigHashEntry parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityConfigHashEntry) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityConfigHashEntry parseFrom(CodedInputStream input) throws IOException {
            return (EntityConfigHashEntry) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityConfigHashEntry parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityConfigHashEntry) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EntityConfigHashEntry prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityConfigHashEntryOuterClass$EntityConfigHashEntry$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EntityConfigHashEntryOrBuilder {
            private int entityId_;
            private int jobId_;
            private int hashValue_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EntityConfigHashEntryOuterClass.internal_static_EntityConfigHashEntry_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntityConfigHashEntryOuterClass.internal_static_EntityConfigHashEntry_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityConfigHashEntry.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EntityConfigHashEntry.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityId_ = 0;
                this.jobId_ = 0;
                this.hashValue_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EntityConfigHashEntryOuterClass.internal_static_EntityConfigHashEntry_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EntityConfigHashEntry getDefaultInstanceForType() {
                return EntityConfigHashEntry.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityConfigHashEntry build() {
                EntityConfigHashEntry result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityConfigHashEntry buildPartial() {
                EntityConfigHashEntry result = new EntityConfigHashEntry(this);
                result.entityId_ = this.entityId_;
                result.jobId_ = this.jobId_;
                result.hashValue_ = this.hashValue_;
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
                if (other instanceof EntityConfigHashEntry) {
                    return mergeFrom((EntityConfigHashEntry) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EntityConfigHashEntry other) {
                if (other == EntityConfigHashEntry.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getJobId() != 0) {
                    setJobId(other.getJobId());
                }
                if (other.getHashValue() != 0) {
                    setHashValue(other.getHashValue());
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
                EntityConfigHashEntry parsedMessage = null;
                try {
                    try {
                        parsedMessage = EntityConfigHashEntry.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EntityConfigHashEntry) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder
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

            @Override // emu.grasscutter.net.proto.EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder
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

            @Override // emu.grasscutter.net.proto.EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static EntityConfigHashEntry getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EntityConfigHashEntry> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EntityConfigHashEntry> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EntityConfigHashEntry getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
