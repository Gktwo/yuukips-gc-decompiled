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
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityClientExtraInfoOuterClass.class */
public final class EntityClientExtraInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bEntityClientExtraInfo.proto\u001a\fVector.proto\"=\n\u0015EntityClientExtraInfo\u0012$\n\u0013skillAnchorPosition\u0018\u0001 \u0001(\u000b2\u0007.VectorB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EntityClientExtraInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EntityClientExtraInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EntityClientExtraInfo_descriptor, new String[]{"SkillAnchorPosition"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityClientExtraInfoOuterClass$EntityClientExtraInfoOrBuilder.class */
    public interface EntityClientExtraInfoOrBuilder extends MessageOrBuilder {
        boolean hasSkillAnchorPosition();

        VectorOuterClass.Vector getSkillAnchorPosition();

        VectorOuterClass.VectorOrBuilder getSkillAnchorPositionOrBuilder();
    }

    private EntityClientExtraInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityClientExtraInfoOuterClass$EntityClientExtraInfo.class */
    public static final class EntityClientExtraInfo extends GeneratedMessageV3 implements EntityClientExtraInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SKILLANCHORPOSITION_FIELD_NUMBER = 1;
        private VectorOuterClass.Vector skillAnchorPosition_;
        private byte memoizedIsInitialized;
        private static final EntityClientExtraInfo DEFAULT_INSTANCE = new EntityClientExtraInfo();
        private static final Parser<EntityClientExtraInfo> PARSER = new AbstractParser<EntityClientExtraInfo>() { // from class: emu.grasscutter.net.proto.EntityClientExtraInfoOuterClass.EntityClientExtraInfo.1
            @Override // com.google.protobuf.Parser
            public EntityClientExtraInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntityClientExtraInfo(input, extensionRegistry);
            }
        };

        private EntityClientExtraInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EntityClientExtraInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EntityClientExtraInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EntityClientExtraInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                VectorOuterClass.Vector.Builder subBuilder = this.skillAnchorPosition_ != null ? this.skillAnchorPosition_.toBuilder() : null;
                                this.skillAnchorPosition_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.skillAnchorPosition_);
                                    this.skillAnchorPosition_ = subBuilder.buildPartial();
                                    break;
                                }
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
            return EntityClientExtraInfoOuterClass.internal_static_EntityClientExtraInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntityClientExtraInfoOuterClass.internal_static_EntityClientExtraInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityClientExtraInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EntityClientExtraInfoOuterClass.EntityClientExtraInfoOrBuilder
        public boolean hasSkillAnchorPosition() {
            return this.skillAnchorPosition_ != null;
        }

        @Override // emu.grasscutter.net.proto.EntityClientExtraInfoOuterClass.EntityClientExtraInfoOrBuilder
        public VectorOuterClass.Vector getSkillAnchorPosition() {
            return this.skillAnchorPosition_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.skillAnchorPosition_;
        }

        @Override // emu.grasscutter.net.proto.EntityClientExtraInfoOuterClass.EntityClientExtraInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getSkillAnchorPositionOrBuilder() {
            return getSkillAnchorPosition();
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
            if (this.skillAnchorPosition_ != null) {
                output.writeMessage(1, getSkillAnchorPosition());
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
            if (this.skillAnchorPosition_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getSkillAnchorPosition());
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
            if (!(obj instanceof EntityClientExtraInfo)) {
                return equals(obj);
            }
            EntityClientExtraInfo other = (EntityClientExtraInfo) obj;
            if (hasSkillAnchorPosition() != other.hasSkillAnchorPosition()) {
                return false;
            }
            return (!hasSkillAnchorPosition() || getSkillAnchorPosition().equals(other.getSkillAnchorPosition())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasSkillAnchorPosition()) {
                hash = (53 * ((37 * hash) + 1)) + getSkillAnchorPosition().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EntityClientExtraInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityClientExtraInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityClientExtraInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityClientExtraInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityClientExtraInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityClientExtraInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityClientExtraInfo parseFrom(InputStream input) throws IOException {
            return (EntityClientExtraInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityClientExtraInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityClientExtraInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityClientExtraInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (EntityClientExtraInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EntityClientExtraInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityClientExtraInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityClientExtraInfo parseFrom(CodedInputStream input) throws IOException {
            return (EntityClientExtraInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityClientExtraInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityClientExtraInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EntityClientExtraInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityClientExtraInfoOuterClass$EntityClientExtraInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EntityClientExtraInfoOrBuilder {
            private VectorOuterClass.Vector skillAnchorPosition_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> skillAnchorPositionBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EntityClientExtraInfoOuterClass.internal_static_EntityClientExtraInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntityClientExtraInfoOuterClass.internal_static_EntityClientExtraInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityClientExtraInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EntityClientExtraInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.skillAnchorPositionBuilder_ == null) {
                    this.skillAnchorPosition_ = null;
                } else {
                    this.skillAnchorPosition_ = null;
                    this.skillAnchorPositionBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EntityClientExtraInfoOuterClass.internal_static_EntityClientExtraInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EntityClientExtraInfo getDefaultInstanceForType() {
                return EntityClientExtraInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityClientExtraInfo build() {
                EntityClientExtraInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityClientExtraInfo buildPartial() {
                EntityClientExtraInfo result = new EntityClientExtraInfo(this);
                if (this.skillAnchorPositionBuilder_ == null) {
                    result.skillAnchorPosition_ = this.skillAnchorPosition_;
                } else {
                    result.skillAnchorPosition_ = this.skillAnchorPositionBuilder_.build();
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
                if (other instanceof EntityClientExtraInfo) {
                    return mergeFrom((EntityClientExtraInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EntityClientExtraInfo other) {
                if (other == EntityClientExtraInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasSkillAnchorPosition()) {
                    mergeSkillAnchorPosition(other.getSkillAnchorPosition());
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
                EntityClientExtraInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = EntityClientExtraInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EntityClientExtraInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EntityClientExtraInfoOuterClass.EntityClientExtraInfoOrBuilder
            public boolean hasSkillAnchorPosition() {
                return (this.skillAnchorPositionBuilder_ == null && this.skillAnchorPosition_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EntityClientExtraInfoOuterClass.EntityClientExtraInfoOrBuilder
            public VectorOuterClass.Vector getSkillAnchorPosition() {
                if (this.skillAnchorPositionBuilder_ == null) {
                    return this.skillAnchorPosition_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.skillAnchorPosition_;
                }
                return this.skillAnchorPositionBuilder_.getMessage();
            }

            public Builder setSkillAnchorPosition(VectorOuterClass.Vector value) {
                if (this.skillAnchorPositionBuilder_ != null) {
                    this.skillAnchorPositionBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.skillAnchorPosition_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSkillAnchorPosition(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.skillAnchorPositionBuilder_ == null) {
                    this.skillAnchorPosition_ = builderForValue.build();
                    onChanged();
                } else {
                    this.skillAnchorPositionBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSkillAnchorPosition(VectorOuterClass.Vector value) {
                if (this.skillAnchorPositionBuilder_ == null) {
                    if (this.skillAnchorPosition_ != null) {
                        this.skillAnchorPosition_ = VectorOuterClass.Vector.newBuilder(this.skillAnchorPosition_).mergeFrom(value).buildPartial();
                    } else {
                        this.skillAnchorPosition_ = value;
                    }
                    onChanged();
                } else {
                    this.skillAnchorPositionBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSkillAnchorPosition() {
                if (this.skillAnchorPositionBuilder_ == null) {
                    this.skillAnchorPosition_ = null;
                    onChanged();
                } else {
                    this.skillAnchorPosition_ = null;
                    this.skillAnchorPositionBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getSkillAnchorPositionBuilder() {
                onChanged();
                return getSkillAnchorPositionFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.EntityClientExtraInfoOuterClass.EntityClientExtraInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getSkillAnchorPositionOrBuilder() {
                if (this.skillAnchorPositionBuilder_ != null) {
                    return this.skillAnchorPositionBuilder_.getMessageOrBuilder();
                }
                return this.skillAnchorPosition_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.skillAnchorPosition_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getSkillAnchorPositionFieldBuilder() {
                if (this.skillAnchorPositionBuilder_ == null) {
                    this.skillAnchorPositionBuilder_ = new SingleFieldBuilderV3<>(getSkillAnchorPosition(), getParentForChildren(), isClean());
                    this.skillAnchorPosition_ = null;
                }
                return this.skillAnchorPositionBuilder_;
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

        public static EntityClientExtraInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EntityClientExtraInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EntityClientExtraInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EntityClientExtraInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
    }
}
