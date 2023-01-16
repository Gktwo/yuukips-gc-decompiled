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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityEnvironmentInfoOuterClass.class */
public final class EntityEnvironmentInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bEntityEnvironmentInfo.proto\"K\n\u0015EntityEnvironmentInfo\u0012\u0019\n\u0011json_climate_type\u0018\u0001 \u0001(\r\u0012\u0017\n\u000fclimate_area_id\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_EntityEnvironmentInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EntityEnvironmentInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EntityEnvironmentInfo_descriptor, new String[]{"JsonClimateType", "ClimateAreaId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityEnvironmentInfoOuterClass$EntityEnvironmentInfoOrBuilder.class */
    public interface EntityEnvironmentInfoOrBuilder extends MessageOrBuilder {
        int getJsonClimateType();

        int getClimateAreaId();
    }

    private EntityEnvironmentInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityEnvironmentInfoOuterClass$EntityEnvironmentInfo.class */
    public static final class EntityEnvironmentInfo extends GeneratedMessageV3 implements EntityEnvironmentInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int JSON_CLIMATE_TYPE_FIELD_NUMBER = 1;
        private int jsonClimateType_;
        public static final int CLIMATE_AREA_ID_FIELD_NUMBER = 2;
        private int climateAreaId_;
        private byte memoizedIsInitialized;
        private static final EntityEnvironmentInfo DEFAULT_INSTANCE = new EntityEnvironmentInfo();
        private static final Parser<EntityEnvironmentInfo> PARSER = new AbstractParser<EntityEnvironmentInfo>() { // from class: emu.grasscutter.net.proto.EntityEnvironmentInfoOuterClass.EntityEnvironmentInfo.1
            @Override // com.google.protobuf.Parser
            public EntityEnvironmentInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntityEnvironmentInfo(input, extensionRegistry);
            }
        };

        private EntityEnvironmentInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EntityEnvironmentInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EntityEnvironmentInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EntityEnvironmentInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.jsonClimateType_ = input.readUInt32();
                                break;
                            case 16:
                                this.climateAreaId_ = input.readUInt32();
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
            return EntityEnvironmentInfoOuterClass.internal_static_EntityEnvironmentInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntityEnvironmentInfoOuterClass.internal_static_EntityEnvironmentInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityEnvironmentInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EntityEnvironmentInfoOuterClass.EntityEnvironmentInfoOrBuilder
        public int getJsonClimateType() {
            return this.jsonClimateType_;
        }

        @Override // emu.grasscutter.net.proto.EntityEnvironmentInfoOuterClass.EntityEnvironmentInfoOrBuilder
        public int getClimateAreaId() {
            return this.climateAreaId_;
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
            if (this.jsonClimateType_ != 0) {
                output.writeUInt32(1, this.jsonClimateType_);
            }
            if (this.climateAreaId_ != 0) {
                output.writeUInt32(2, this.climateAreaId_);
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
            if (this.jsonClimateType_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.jsonClimateType_);
            }
            if (this.climateAreaId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.climateAreaId_);
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
            if (!(obj instanceof EntityEnvironmentInfo)) {
                return equals(obj);
            }
            EntityEnvironmentInfo other = (EntityEnvironmentInfo) obj;
            return getJsonClimateType() == other.getJsonClimateType() && getClimateAreaId() == other.getClimateAreaId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getJsonClimateType())) + 2)) + getClimateAreaId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static EntityEnvironmentInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityEnvironmentInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityEnvironmentInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityEnvironmentInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityEnvironmentInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityEnvironmentInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityEnvironmentInfo parseFrom(InputStream input) throws IOException {
            return (EntityEnvironmentInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityEnvironmentInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityEnvironmentInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityEnvironmentInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (EntityEnvironmentInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EntityEnvironmentInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityEnvironmentInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityEnvironmentInfo parseFrom(CodedInputStream input) throws IOException {
            return (EntityEnvironmentInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityEnvironmentInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityEnvironmentInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EntityEnvironmentInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityEnvironmentInfoOuterClass$EntityEnvironmentInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EntityEnvironmentInfoOrBuilder {
            private int jsonClimateType_;
            private int climateAreaId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EntityEnvironmentInfoOuterClass.internal_static_EntityEnvironmentInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntityEnvironmentInfoOuterClass.internal_static_EntityEnvironmentInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityEnvironmentInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EntityEnvironmentInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.jsonClimateType_ = 0;
                this.climateAreaId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EntityEnvironmentInfoOuterClass.internal_static_EntityEnvironmentInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EntityEnvironmentInfo getDefaultInstanceForType() {
                return EntityEnvironmentInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityEnvironmentInfo build() {
                EntityEnvironmentInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityEnvironmentInfo buildPartial() {
                EntityEnvironmentInfo result = new EntityEnvironmentInfo(this);
                result.jsonClimateType_ = this.jsonClimateType_;
                result.climateAreaId_ = this.climateAreaId_;
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
                if (other instanceof EntityEnvironmentInfo) {
                    return mergeFrom((EntityEnvironmentInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EntityEnvironmentInfo other) {
                if (other == EntityEnvironmentInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getJsonClimateType() != 0) {
                    setJsonClimateType(other.getJsonClimateType());
                }
                if (other.getClimateAreaId() != 0) {
                    setClimateAreaId(other.getClimateAreaId());
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
                EntityEnvironmentInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = EntityEnvironmentInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EntityEnvironmentInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EntityEnvironmentInfoOuterClass.EntityEnvironmentInfoOrBuilder
            public int getJsonClimateType() {
                return this.jsonClimateType_;
            }

            public Builder setJsonClimateType(int value) {
                this.jsonClimateType_ = value;
                onChanged();
                return this;
            }

            public Builder clearJsonClimateType() {
                this.jsonClimateType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EntityEnvironmentInfoOuterClass.EntityEnvironmentInfoOrBuilder
            public int getClimateAreaId() {
                return this.climateAreaId_;
            }

            public Builder setClimateAreaId(int value) {
                this.climateAreaId_ = value;
                onChanged();
                return this;
            }

            public Builder clearClimateAreaId() {
                this.climateAreaId_ = 0;
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

        public static EntityEnvironmentInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EntityEnvironmentInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EntityEnvironmentInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EntityEnvironmentInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
