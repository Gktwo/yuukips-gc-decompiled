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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityClientDataOuterClass.class */
public final class EntityClientDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016EntityClientData.proto\"q\n\u0010EntityClientData\u0012\u001e\n\u0016wind_change_scene_time\u0018\u0001 \u0001(\r\u0012\u001b\n\u0013windmill_sync_angle\u0018\u0002 \u0001(\u0002\u0012 \n\u0018wind_change_target_level\u0018\u0003 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_EntityClientData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EntityClientData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EntityClientData_descriptor, new String[]{"WindChangeSceneTime", "WindmillSyncAngle", "WindChangeTargetLevel"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityClientDataOuterClass$EntityClientDataOrBuilder.class */
    public interface EntityClientDataOrBuilder extends MessageOrBuilder {
        int getWindChangeSceneTime();

        float getWindmillSyncAngle();

        int getWindChangeTargetLevel();
    }

    private EntityClientDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityClientDataOuterClass$EntityClientData.class */
    public static final class EntityClientData extends GeneratedMessageV3 implements EntityClientDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int WIND_CHANGE_SCENE_TIME_FIELD_NUMBER = 1;
        private int windChangeSceneTime_;
        public static final int WINDMILL_SYNC_ANGLE_FIELD_NUMBER = 2;
        private float windmillSyncAngle_;
        public static final int WIND_CHANGE_TARGET_LEVEL_FIELD_NUMBER = 3;
        private int windChangeTargetLevel_;
        private byte memoizedIsInitialized;
        private static final EntityClientData DEFAULT_INSTANCE = new EntityClientData();
        private static final Parser<EntityClientData> PARSER = new AbstractParser<EntityClientData>() { // from class: emu.grasscutter.net.proto.EntityClientDataOuterClass.EntityClientData.1
            @Override // com.google.protobuf.Parser
            public EntityClientData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntityClientData(input, extensionRegistry);
            }
        };

        private EntityClientData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EntityClientData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EntityClientData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EntityClientData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.windChangeSceneTime_ = input.readUInt32();
                                    break;
                                case 21:
                                    this.windmillSyncAngle_ = input.readFloat();
                                    break;
                                case 24:
                                    this.windChangeTargetLevel_ = input.readInt32();
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
            return EntityClientDataOuterClass.internal_static_EntityClientData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntityClientDataOuterClass.internal_static_EntityClientData_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityClientData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EntityClientDataOuterClass.EntityClientDataOrBuilder
        public int getWindChangeSceneTime() {
            return this.windChangeSceneTime_;
        }

        @Override // emu.grasscutter.net.proto.EntityClientDataOuterClass.EntityClientDataOrBuilder
        public float getWindmillSyncAngle() {
            return this.windmillSyncAngle_;
        }

        @Override // emu.grasscutter.net.proto.EntityClientDataOuterClass.EntityClientDataOrBuilder
        public int getWindChangeTargetLevel() {
            return this.windChangeTargetLevel_;
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
            if (this.windChangeSceneTime_ != 0) {
                output.writeUInt32(1, this.windChangeSceneTime_);
            }
            if (this.windmillSyncAngle_ != 0.0f) {
                output.writeFloat(2, this.windmillSyncAngle_);
            }
            if (this.windChangeTargetLevel_ != 0) {
                output.writeInt32(3, this.windChangeTargetLevel_);
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
            if (this.windChangeSceneTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.windChangeSceneTime_);
            }
            if (this.windmillSyncAngle_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(2, this.windmillSyncAngle_);
            }
            if (this.windChangeTargetLevel_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(3, this.windChangeTargetLevel_);
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
            if (!(obj instanceof EntityClientData)) {
                return equals(obj);
            }
            EntityClientData other = (EntityClientData) obj;
            return getWindChangeSceneTime() == other.getWindChangeSceneTime() && Float.floatToIntBits(getWindmillSyncAngle()) == Float.floatToIntBits(other.getWindmillSyncAngle()) && getWindChangeTargetLevel() == other.getWindChangeTargetLevel() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getWindChangeSceneTime())) + 2)) + Float.floatToIntBits(getWindmillSyncAngle()))) + 3)) + getWindChangeTargetLevel())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static EntityClientData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityClientData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityClientData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityClientData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityClientData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityClientData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityClientData parseFrom(InputStream input) throws IOException {
            return (EntityClientData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityClientData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityClientData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityClientData parseDelimitedFrom(InputStream input) throws IOException {
            return (EntityClientData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EntityClientData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityClientData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityClientData parseFrom(CodedInputStream input) throws IOException {
            return (EntityClientData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityClientData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityClientData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EntityClientData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityClientDataOuterClass$EntityClientData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EntityClientDataOrBuilder {
            private int windChangeSceneTime_;
            private float windmillSyncAngle_;
            private int windChangeTargetLevel_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EntityClientDataOuterClass.internal_static_EntityClientData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntityClientDataOuterClass.internal_static_EntityClientData_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityClientData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EntityClientData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.windChangeSceneTime_ = 0;
                this.windmillSyncAngle_ = 0.0f;
                this.windChangeTargetLevel_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EntityClientDataOuterClass.internal_static_EntityClientData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EntityClientData getDefaultInstanceForType() {
                return EntityClientData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityClientData build() {
                EntityClientData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityClientData buildPartial() {
                EntityClientData result = new EntityClientData(this);
                result.windChangeSceneTime_ = this.windChangeSceneTime_;
                result.windmillSyncAngle_ = this.windmillSyncAngle_;
                result.windChangeTargetLevel_ = this.windChangeTargetLevel_;
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
                if (other instanceof EntityClientData) {
                    return mergeFrom((EntityClientData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EntityClientData other) {
                if (other == EntityClientData.getDefaultInstance()) {
                    return this;
                }
                if (other.getWindChangeSceneTime() != 0) {
                    setWindChangeSceneTime(other.getWindChangeSceneTime());
                }
                if (other.getWindmillSyncAngle() != 0.0f) {
                    setWindmillSyncAngle(other.getWindmillSyncAngle());
                }
                if (other.getWindChangeTargetLevel() != 0) {
                    setWindChangeTargetLevel(other.getWindChangeTargetLevel());
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
                EntityClientData parsedMessage = null;
                try {
                    try {
                        parsedMessage = EntityClientData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EntityClientData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EntityClientDataOuterClass.EntityClientDataOrBuilder
            public int getWindChangeSceneTime() {
                return this.windChangeSceneTime_;
            }

            public Builder setWindChangeSceneTime(int value) {
                this.windChangeSceneTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearWindChangeSceneTime() {
                this.windChangeSceneTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EntityClientDataOuterClass.EntityClientDataOrBuilder
            public float getWindmillSyncAngle() {
                return this.windmillSyncAngle_;
            }

            public Builder setWindmillSyncAngle(float value) {
                this.windmillSyncAngle_ = value;
                onChanged();
                return this;
            }

            public Builder clearWindmillSyncAngle() {
                this.windmillSyncAngle_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EntityClientDataOuterClass.EntityClientDataOrBuilder
            public int getWindChangeTargetLevel() {
                return this.windChangeTargetLevel_;
            }

            public Builder setWindChangeTargetLevel(int value) {
                this.windChangeTargetLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearWindChangeTargetLevel() {
                this.windChangeTargetLevel_ = 0;
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

        public static EntityClientData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EntityClientData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EntityClientData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EntityClientData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
