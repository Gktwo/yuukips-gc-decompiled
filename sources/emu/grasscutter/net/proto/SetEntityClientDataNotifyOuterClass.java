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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.EntityClientDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetEntityClientDataNotifyOuterClass.class */
public final class SetEntityClientDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fSetEntityClientDataNotify.proto\u001a\u0016EntityClientData.proto\"]\n\u0019SetEntityClientDataNotify\u0012\u0011\n\tentity_id\u0018\u000f \u0001(\r\u0012-\n\u0012entity_client_data\u0018\u0005 \u0001(\u000b2\u0011.EntityClientDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{EntityClientDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SetEntityClientDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SetEntityClientDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SetEntityClientDataNotify_descriptor, new String[]{"EntityId", "EntityClientData"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetEntityClientDataNotifyOuterClass$SetEntityClientDataNotifyOrBuilder.class */
    public interface SetEntityClientDataNotifyOrBuilder extends MessageOrBuilder {
        int getEntityId();

        boolean hasEntityClientData();

        EntityClientDataOuterClass.EntityClientData getEntityClientData();

        EntityClientDataOuterClass.EntityClientDataOrBuilder getEntityClientDataOrBuilder();
    }

    private SetEntityClientDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetEntityClientDataNotifyOuterClass$SetEntityClientDataNotify.class */
    public static final class SetEntityClientDataNotify extends GeneratedMessageV3 implements SetEntityClientDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITY_ID_FIELD_NUMBER = 15;
        private int entityId_;
        public static final int ENTITY_CLIENT_DATA_FIELD_NUMBER = 5;
        private EntityClientDataOuterClass.EntityClientData entityClientData_;
        private byte memoizedIsInitialized;
        private static final SetEntityClientDataNotify DEFAULT_INSTANCE = new SetEntityClientDataNotify();
        private static final Parser<SetEntityClientDataNotify> PARSER = new AbstractParser<SetEntityClientDataNotify>() { // from class: emu.grasscutter.net.proto.SetEntityClientDataNotifyOuterClass.SetEntityClientDataNotify.1
            @Override // com.google.protobuf.Parser
            public SetEntityClientDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SetEntityClientDataNotify(input, extensionRegistry);
            }
        };

        private SetEntityClientDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SetEntityClientDataNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SetEntityClientDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SetEntityClientDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 42:
                                    EntityClientDataOuterClass.EntityClientData.Builder subBuilder = this.entityClientData_ != null ? this.entityClientData_.toBuilder() : null;
                                    this.entityClientData_ = (EntityClientDataOuterClass.EntityClientData) input.readMessage(EntityClientDataOuterClass.EntityClientData.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.entityClientData_);
                                        this.entityClientData_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 120:
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
            return SetEntityClientDataNotifyOuterClass.internal_static_SetEntityClientDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SetEntityClientDataNotifyOuterClass.internal_static_SetEntityClientDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SetEntityClientDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SetEntityClientDataNotifyOuterClass.SetEntityClientDataNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.SetEntityClientDataNotifyOuterClass.SetEntityClientDataNotifyOrBuilder
        public boolean hasEntityClientData() {
            return this.entityClientData_ != null;
        }

        @Override // emu.grasscutter.net.proto.SetEntityClientDataNotifyOuterClass.SetEntityClientDataNotifyOrBuilder
        public EntityClientDataOuterClass.EntityClientData getEntityClientData() {
            return this.entityClientData_ == null ? EntityClientDataOuterClass.EntityClientData.getDefaultInstance() : this.entityClientData_;
        }

        @Override // emu.grasscutter.net.proto.SetEntityClientDataNotifyOuterClass.SetEntityClientDataNotifyOrBuilder
        public EntityClientDataOuterClass.EntityClientDataOrBuilder getEntityClientDataOrBuilder() {
            return getEntityClientData();
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
            if (this.entityClientData_ != null) {
                output.writeMessage(5, getEntityClientData());
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(15, this.entityId_);
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
            if (this.entityClientData_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(5, getEntityClientData());
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.entityId_);
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
            if (!(obj instanceof SetEntityClientDataNotify)) {
                return equals(obj);
            }
            SetEntityClientDataNotify other = (SetEntityClientDataNotify) obj;
            if (getEntityId() == other.getEntityId() && hasEntityClientData() == other.hasEntityClientData()) {
                return (!hasEntityClientData() || getEntityClientData().equals(other.getEntityClientData())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getEntityId();
            if (hasEntityClientData()) {
                hash = (53 * ((37 * hash) + 5)) + getEntityClientData().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SetEntityClientDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetEntityClientDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetEntityClientDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetEntityClientDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetEntityClientDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetEntityClientDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetEntityClientDataNotify parseFrom(InputStream input) throws IOException {
            return (SetEntityClientDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetEntityClientDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetEntityClientDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetEntityClientDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (SetEntityClientDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SetEntityClientDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetEntityClientDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetEntityClientDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (SetEntityClientDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetEntityClientDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetEntityClientDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SetEntityClientDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetEntityClientDataNotifyOuterClass$SetEntityClientDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SetEntityClientDataNotifyOrBuilder {
            private int entityId_;
            private EntityClientDataOuterClass.EntityClientData entityClientData_;
            private SingleFieldBuilderV3<EntityClientDataOuterClass.EntityClientData, EntityClientDataOuterClass.EntityClientData.Builder, EntityClientDataOuterClass.EntityClientDataOrBuilder> entityClientDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SetEntityClientDataNotifyOuterClass.internal_static_SetEntityClientDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SetEntityClientDataNotifyOuterClass.internal_static_SetEntityClientDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SetEntityClientDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SetEntityClientDataNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityId_ = 0;
                if (this.entityClientDataBuilder_ == null) {
                    this.entityClientData_ = null;
                } else {
                    this.entityClientData_ = null;
                    this.entityClientDataBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SetEntityClientDataNotifyOuterClass.internal_static_SetEntityClientDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SetEntityClientDataNotify getDefaultInstanceForType() {
                return SetEntityClientDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetEntityClientDataNotify build() {
                SetEntityClientDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetEntityClientDataNotify buildPartial() {
                SetEntityClientDataNotify result = new SetEntityClientDataNotify(this);
                result.entityId_ = this.entityId_;
                if (this.entityClientDataBuilder_ == null) {
                    result.entityClientData_ = this.entityClientData_;
                } else {
                    result.entityClientData_ = this.entityClientDataBuilder_.build();
                }
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
                if (other instanceof SetEntityClientDataNotify) {
                    return mergeFrom((SetEntityClientDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SetEntityClientDataNotify other) {
                if (other == SetEntityClientDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.hasEntityClientData()) {
                    mergeEntityClientData(other.getEntityClientData());
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
                SetEntityClientDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = SetEntityClientDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SetEntityClientDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SetEntityClientDataNotifyOuterClass.SetEntityClientDataNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.SetEntityClientDataNotifyOuterClass.SetEntityClientDataNotifyOrBuilder
            public boolean hasEntityClientData() {
                return (this.entityClientDataBuilder_ == null && this.entityClientData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SetEntityClientDataNotifyOuterClass.SetEntityClientDataNotifyOrBuilder
            public EntityClientDataOuterClass.EntityClientData getEntityClientData() {
                if (this.entityClientDataBuilder_ == null) {
                    return this.entityClientData_ == null ? EntityClientDataOuterClass.EntityClientData.getDefaultInstance() : this.entityClientData_;
                }
                return this.entityClientDataBuilder_.getMessage();
            }

            public Builder setEntityClientData(EntityClientDataOuterClass.EntityClientData value) {
                if (this.entityClientDataBuilder_ != null) {
                    this.entityClientDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.entityClientData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setEntityClientData(EntityClientDataOuterClass.EntityClientData.Builder builderForValue) {
                if (this.entityClientDataBuilder_ == null) {
                    this.entityClientData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.entityClientDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeEntityClientData(EntityClientDataOuterClass.EntityClientData value) {
                if (this.entityClientDataBuilder_ == null) {
                    if (this.entityClientData_ != null) {
                        this.entityClientData_ = EntityClientDataOuterClass.EntityClientData.newBuilder(this.entityClientData_).mergeFrom(value).buildPartial();
                    } else {
                        this.entityClientData_ = value;
                    }
                    onChanged();
                } else {
                    this.entityClientDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearEntityClientData() {
                if (this.entityClientDataBuilder_ == null) {
                    this.entityClientData_ = null;
                    onChanged();
                } else {
                    this.entityClientData_ = null;
                    this.entityClientDataBuilder_ = null;
                }
                return this;
            }

            public EntityClientDataOuterClass.EntityClientData.Builder getEntityClientDataBuilder() {
                onChanged();
                return getEntityClientDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SetEntityClientDataNotifyOuterClass.SetEntityClientDataNotifyOrBuilder
            public EntityClientDataOuterClass.EntityClientDataOrBuilder getEntityClientDataOrBuilder() {
                if (this.entityClientDataBuilder_ != null) {
                    return this.entityClientDataBuilder_.getMessageOrBuilder();
                }
                return this.entityClientData_ == null ? EntityClientDataOuterClass.EntityClientData.getDefaultInstance() : this.entityClientData_;
            }

            private SingleFieldBuilderV3<EntityClientDataOuterClass.EntityClientData, EntityClientDataOuterClass.EntityClientData.Builder, EntityClientDataOuterClass.EntityClientDataOrBuilder> getEntityClientDataFieldBuilder() {
                if (this.entityClientDataBuilder_ == null) {
                    this.entityClientDataBuilder_ = new SingleFieldBuilderV3<>(getEntityClientData(), getParentForChildren(), isClean());
                    this.entityClientData_ = null;
                }
                return this.entityClientDataBuilder_;
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

        public static SetEntityClientDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SetEntityClientDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SetEntityClientDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SetEntityClientDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        EntityClientDataOuterClass.getDescriptor();
    }
}
