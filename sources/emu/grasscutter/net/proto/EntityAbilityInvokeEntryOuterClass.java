package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityAbilityInvokeEntryOuterClass.class */
public final class EntityAbilityInvokeEntryOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eEntityAbilityInvokeEntry.proto\u001a\u0018AbilityInvokeEntry.proto\"R\n\u0018EntityAbilityInvokeEntry\u0012$\n\u0007invokes\u0018\u0004 \u0003(\u000b2\u0013.AbilityInvokeEntry\u0012\u0010\n\bentityId\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilityInvokeEntryOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EntityAbilityInvokeEntry_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EntityAbilityInvokeEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EntityAbilityInvokeEntry_descriptor, new String[]{"Invokes", "EntityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityAbilityInvokeEntryOuterClass$EntityAbilityInvokeEntryOrBuilder.class */
    public interface EntityAbilityInvokeEntryOrBuilder extends MessageOrBuilder {
        List<AbilityInvokeEntryOuterClass.AbilityInvokeEntry> getInvokesList();

        AbilityInvokeEntryOuterClass.AbilityInvokeEntry getInvokes(int i);

        int getInvokesCount();

        List<? extends AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder> getInvokesOrBuilderList();

        AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder getInvokesOrBuilder(int i);

        int getEntityId();
    }

    private EntityAbilityInvokeEntryOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityAbilityInvokeEntryOuterClass$EntityAbilityInvokeEntry.class */
    public static final class EntityAbilityInvokeEntry extends GeneratedMessageV3 implements EntityAbilityInvokeEntryOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int INVOKES_FIELD_NUMBER = 4;
        private List<AbilityInvokeEntryOuterClass.AbilityInvokeEntry> invokes_;
        public static final int ENTITYID_FIELD_NUMBER = 9;
        private int entityId_;
        private byte memoizedIsInitialized;
        private static final EntityAbilityInvokeEntry DEFAULT_INSTANCE = new EntityAbilityInvokeEntry();
        private static final Parser<EntityAbilityInvokeEntry> PARSER = new AbstractParser<EntityAbilityInvokeEntry>() { // from class: emu.grasscutter.net.proto.EntityAbilityInvokeEntryOuterClass.EntityAbilityInvokeEntry.1
            @Override // com.google.protobuf.Parser
            public EntityAbilityInvokeEntry parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntityAbilityInvokeEntry(input, extensionRegistry);
            }
        };

        private EntityAbilityInvokeEntry(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EntityAbilityInvokeEntry() {
            this.memoizedIsInitialized = -1;
            this.invokes_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EntityAbilityInvokeEntry();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EntityAbilityInvokeEntry(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
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
                                case 34:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.invokes_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.invokes_.add((AbilityInvokeEntryOuterClass.AbilityInvokeEntry) input.readMessage(AbilityInvokeEntryOuterClass.AbilityInvokeEntry.parser(), extensionRegistry));
                                    break;
                                case 72:
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.invokes_ = Collections.unmodifiableList(this.invokes_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EntityAbilityInvokeEntryOuterClass.internal_static_EntityAbilityInvokeEntry_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntityAbilityInvokeEntryOuterClass.internal_static_EntityAbilityInvokeEntry_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityAbilityInvokeEntry.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EntityAbilityInvokeEntryOuterClass.EntityAbilityInvokeEntryOrBuilder
        public List<AbilityInvokeEntryOuterClass.AbilityInvokeEntry> getInvokesList() {
            return this.invokes_;
        }

        @Override // emu.grasscutter.net.proto.EntityAbilityInvokeEntryOuterClass.EntityAbilityInvokeEntryOrBuilder
        public List<? extends AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder> getInvokesOrBuilderList() {
            return this.invokes_;
        }

        @Override // emu.grasscutter.net.proto.EntityAbilityInvokeEntryOuterClass.EntityAbilityInvokeEntryOrBuilder
        public int getInvokesCount() {
            return this.invokes_.size();
        }

        @Override // emu.grasscutter.net.proto.EntityAbilityInvokeEntryOuterClass.EntityAbilityInvokeEntryOrBuilder
        public AbilityInvokeEntryOuterClass.AbilityInvokeEntry getInvokes(int index) {
            return this.invokes_.get(index);
        }

        @Override // emu.grasscutter.net.proto.EntityAbilityInvokeEntryOuterClass.EntityAbilityInvokeEntryOrBuilder
        public AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder getInvokesOrBuilder(int index) {
            return this.invokes_.get(index);
        }

        @Override // emu.grasscutter.net.proto.EntityAbilityInvokeEntryOuterClass.EntityAbilityInvokeEntryOrBuilder
        public int getEntityId() {
            return this.entityId_;
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
            for (int i = 0; i < this.invokes_.size(); i++) {
                output.writeMessage(4, this.invokes_.get(i));
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(9, this.entityId_);
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
            for (int i = 0; i < this.invokes_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.invokes_.get(i));
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.entityId_);
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
            if (!(obj instanceof EntityAbilityInvokeEntry)) {
                return equals(obj);
            }
            EntityAbilityInvokeEntry other = (EntityAbilityInvokeEntry) obj;
            return getInvokesList().equals(other.getInvokesList()) && getEntityId() == other.getEntityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getInvokesCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getInvokesList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 9)) + getEntityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EntityAbilityInvokeEntry parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityAbilityInvokeEntry parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityAbilityInvokeEntry parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityAbilityInvokeEntry parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityAbilityInvokeEntry parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityAbilityInvokeEntry parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityAbilityInvokeEntry parseFrom(InputStream input) throws IOException {
            return (EntityAbilityInvokeEntry) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityAbilityInvokeEntry parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityAbilityInvokeEntry) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityAbilityInvokeEntry parseDelimitedFrom(InputStream input) throws IOException {
            return (EntityAbilityInvokeEntry) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EntityAbilityInvokeEntry parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityAbilityInvokeEntry) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityAbilityInvokeEntry parseFrom(CodedInputStream input) throws IOException {
            return (EntityAbilityInvokeEntry) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityAbilityInvokeEntry parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityAbilityInvokeEntry) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EntityAbilityInvokeEntry prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityAbilityInvokeEntryOuterClass$EntityAbilityInvokeEntry$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EntityAbilityInvokeEntryOrBuilder {
            private int bitField0_;
            private List<AbilityInvokeEntryOuterClass.AbilityInvokeEntry> invokes_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<AbilityInvokeEntryOuterClass.AbilityInvokeEntry, AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder, AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder> invokesBuilder_;
            private int entityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EntityAbilityInvokeEntryOuterClass.internal_static_EntityAbilityInvokeEntry_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntityAbilityInvokeEntryOuterClass.internal_static_EntityAbilityInvokeEntry_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityAbilityInvokeEntry.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EntityAbilityInvokeEntry.alwaysUseFieldBuilders) {
                    getInvokesFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.invokesBuilder_ == null) {
                    this.invokes_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.invokesBuilder_.clear();
                }
                this.entityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EntityAbilityInvokeEntryOuterClass.internal_static_EntityAbilityInvokeEntry_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EntityAbilityInvokeEntry getDefaultInstanceForType() {
                return EntityAbilityInvokeEntry.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityAbilityInvokeEntry build() {
                EntityAbilityInvokeEntry result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityAbilityInvokeEntry buildPartial() {
                EntityAbilityInvokeEntry result = new EntityAbilityInvokeEntry(this);
                int i = this.bitField0_;
                if (this.invokesBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.invokes_ = Collections.unmodifiableList(this.invokes_);
                        this.bitField0_ &= -2;
                    }
                    result.invokes_ = this.invokes_;
                } else {
                    result.invokes_ = this.invokesBuilder_.build();
                }
                result.entityId_ = this.entityId_;
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
                if (other instanceof EntityAbilityInvokeEntry) {
                    return mergeFrom((EntityAbilityInvokeEntry) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EntityAbilityInvokeEntry other) {
                if (other == EntityAbilityInvokeEntry.getDefaultInstance()) {
                    return this;
                }
                if (this.invokesBuilder_ == null) {
                    if (!other.invokes_.isEmpty()) {
                        if (this.invokes_.isEmpty()) {
                            this.invokes_ = other.invokes_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureInvokesIsMutable();
                            this.invokes_.addAll(other.invokes_);
                        }
                        onChanged();
                    }
                } else if (!other.invokes_.isEmpty()) {
                    if (this.invokesBuilder_.isEmpty()) {
                        this.invokesBuilder_.dispose();
                        this.invokesBuilder_ = null;
                        this.invokes_ = other.invokes_;
                        this.bitField0_ &= -2;
                        this.invokesBuilder_ = EntityAbilityInvokeEntry.alwaysUseFieldBuilders ? getInvokesFieldBuilder() : null;
                    } else {
                        this.invokesBuilder_.addAllMessages(other.invokes_);
                    }
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
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
                EntityAbilityInvokeEntry parsedMessage = null;
                try {
                    try {
                        parsedMessage = EntityAbilityInvokeEntry.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EntityAbilityInvokeEntry) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureInvokesIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.invokes_ = new ArrayList(this.invokes_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.EntityAbilityInvokeEntryOuterClass.EntityAbilityInvokeEntryOrBuilder
            public List<AbilityInvokeEntryOuterClass.AbilityInvokeEntry> getInvokesList() {
                if (this.invokesBuilder_ == null) {
                    return Collections.unmodifiableList(this.invokes_);
                }
                return this.invokesBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.EntityAbilityInvokeEntryOuterClass.EntityAbilityInvokeEntryOrBuilder
            public int getInvokesCount() {
                if (this.invokesBuilder_ == null) {
                    return this.invokes_.size();
                }
                return this.invokesBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.EntityAbilityInvokeEntryOuterClass.EntityAbilityInvokeEntryOrBuilder
            public AbilityInvokeEntryOuterClass.AbilityInvokeEntry getInvokes(int index) {
                if (this.invokesBuilder_ == null) {
                    return this.invokes_.get(index);
                }
                return this.invokesBuilder_.getMessage(index);
            }

            public Builder setInvokes(int index, AbilityInvokeEntryOuterClass.AbilityInvokeEntry value) {
                if (this.invokesBuilder_ != null) {
                    this.invokesBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInvokesIsMutable();
                    this.invokes_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setInvokes(int index, AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder builderForValue) {
                if (this.invokesBuilder_ == null) {
                    ensureInvokesIsMutable();
                    this.invokes_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.invokesBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addInvokes(AbilityInvokeEntryOuterClass.AbilityInvokeEntry value) {
                if (this.invokesBuilder_ != null) {
                    this.invokesBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInvokesIsMutable();
                    this.invokes_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addInvokes(int index, AbilityInvokeEntryOuterClass.AbilityInvokeEntry value) {
                if (this.invokesBuilder_ != null) {
                    this.invokesBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInvokesIsMutable();
                    this.invokes_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addInvokes(AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder builderForValue) {
                if (this.invokesBuilder_ == null) {
                    ensureInvokesIsMutable();
                    this.invokes_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.invokesBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addInvokes(int index, AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder builderForValue) {
                if (this.invokesBuilder_ == null) {
                    ensureInvokesIsMutable();
                    this.invokes_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.invokesBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllInvokes(Iterable<? extends AbilityInvokeEntryOuterClass.AbilityInvokeEntry> values) {
                if (this.invokesBuilder_ == null) {
                    ensureInvokesIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.invokes_);
                    onChanged();
                } else {
                    this.invokesBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearInvokes() {
                if (this.invokesBuilder_ == null) {
                    this.invokes_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.invokesBuilder_.clear();
                }
                return this;
            }

            public Builder removeInvokes(int index) {
                if (this.invokesBuilder_ == null) {
                    ensureInvokesIsMutable();
                    this.invokes_.remove(index);
                    onChanged();
                } else {
                    this.invokesBuilder_.remove(index);
                }
                return this;
            }

            public AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder getInvokesBuilder(int index) {
                return getInvokesFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EntityAbilityInvokeEntryOuterClass.EntityAbilityInvokeEntryOrBuilder
            public AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder getInvokesOrBuilder(int index) {
                if (this.invokesBuilder_ == null) {
                    return this.invokes_.get(index);
                }
                return this.invokesBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EntityAbilityInvokeEntryOuterClass.EntityAbilityInvokeEntryOrBuilder
            public List<? extends AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder> getInvokesOrBuilderList() {
                if (this.invokesBuilder_ != null) {
                    return this.invokesBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.invokes_);
            }

            public AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder addInvokesBuilder() {
                return getInvokesFieldBuilder().addBuilder(AbilityInvokeEntryOuterClass.AbilityInvokeEntry.getDefaultInstance());
            }

            public AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder addInvokesBuilder(int index) {
                return getInvokesFieldBuilder().addBuilder(index, AbilityInvokeEntryOuterClass.AbilityInvokeEntry.getDefaultInstance());
            }

            public List<AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder> getInvokesBuilderList() {
                return getInvokesFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AbilityInvokeEntryOuterClass.AbilityInvokeEntry, AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder, AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder> getInvokesFieldBuilder() {
                if (this.invokesBuilder_ == null) {
                    this.invokesBuilder_ = new RepeatedFieldBuilderV3<>(this.invokes_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.invokes_ = null;
                }
                return this.invokesBuilder_;
            }

            @Override // emu.grasscutter.net.proto.EntityAbilityInvokeEntryOuterClass.EntityAbilityInvokeEntryOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static EntityAbilityInvokeEntry getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EntityAbilityInvokeEntry> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EntityAbilityInvokeEntry> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EntityAbilityInvokeEntry getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilityInvokeEntryOuterClass.getDescriptor();
    }
}
