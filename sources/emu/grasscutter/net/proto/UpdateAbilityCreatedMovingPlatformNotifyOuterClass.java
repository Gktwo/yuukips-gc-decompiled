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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdateAbilityCreatedMovingPlatformNotifyOuterClass.class */
public final class UpdateAbilityCreatedMovingPlatformNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n.UpdateAbilityCreatedMovingPlatformNotify.proto\"Ê\u0001\n(UpdateAbilityCreatedMovingPlatformNotify\u0012\u0011\n\tentity_id\u0018\u0001 \u0001(\r\u0012A\n\u0007op_type\u0018\u000f \u0001(\u000e20.UpdateAbilityCreatedMovingPlatformNotify.OpType\"H\n\u0006OpType\u0012\u0010\n\fOP_TYPE_NONE\u0010��\u0012\u0014\n\u0010OP_TYPE_ACTIVATE\u0010\u0001\u0012\u0016\n\u0012OP_TYPE_DEACTIVATE\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* renamed from: internal_static_UpdateAbilityCreatedMovingPlatformNotify_descriptor */
    private static final Descriptors.Descriptor f903x186480e = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_UpdateAbilityCreatedMovingPlatformNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f904x99eb808c = new GeneratedMessageV3.FieldAccessorTable(f903x186480e, new String[]{"EntityId", "OpType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdateAbilityCreatedMovingPlatformNotifyOuterClass$UpdateAbilityCreatedMovingPlatformNotifyOrBuilder.class */
    public interface UpdateAbilityCreatedMovingPlatformNotifyOrBuilder extends MessageOrBuilder {
        int getEntityId();

        int getOpTypeValue();

        UpdateAbilityCreatedMovingPlatformNotify.OpType getOpType();
    }

    private UpdateAbilityCreatedMovingPlatformNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdateAbilityCreatedMovingPlatformNotifyOuterClass$UpdateAbilityCreatedMovingPlatformNotify.class */
    public static final class UpdateAbilityCreatedMovingPlatformNotify extends GeneratedMessageV3 implements UpdateAbilityCreatedMovingPlatformNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITY_ID_FIELD_NUMBER = 1;
        private int entityId_;
        public static final int OP_TYPE_FIELD_NUMBER = 15;
        private int opType_;
        private byte memoizedIsInitialized;
        private static final UpdateAbilityCreatedMovingPlatformNotify DEFAULT_INSTANCE = new UpdateAbilityCreatedMovingPlatformNotify();
        private static final Parser<UpdateAbilityCreatedMovingPlatformNotify> PARSER = new AbstractParser<UpdateAbilityCreatedMovingPlatformNotify>() { // from class: emu.grasscutter.net.proto.UpdateAbilityCreatedMovingPlatformNotifyOuterClass.UpdateAbilityCreatedMovingPlatformNotify.1
            @Override // com.google.protobuf.Parser
            public UpdateAbilityCreatedMovingPlatformNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new UpdateAbilityCreatedMovingPlatformNotify(input, extensionRegistry);
            }
        };

        private UpdateAbilityCreatedMovingPlatformNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private UpdateAbilityCreatedMovingPlatformNotify() {
            this.memoizedIsInitialized = -1;
            this.opType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UpdateAbilityCreatedMovingPlatformNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpdateAbilityCreatedMovingPlatformNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.entityId_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.opType_ = input.readEnum();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return UpdateAbilityCreatedMovingPlatformNotifyOuterClass.f903x186480e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UpdateAbilityCreatedMovingPlatformNotifyOuterClass.f904x99eb808c.ensureFieldAccessorsInitialized(UpdateAbilityCreatedMovingPlatformNotify.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdateAbilityCreatedMovingPlatformNotifyOuterClass$UpdateAbilityCreatedMovingPlatformNotify$OpType.class */
        public enum OpType implements ProtocolMessageEnum {
            OP_TYPE_NONE(0),
            OP_TYPE_ACTIVATE(1),
            OP_TYPE_DEACTIVATE(2),
            UNRECOGNIZED(-1);
            
            public static final int OP_TYPE_NONE_VALUE = 0;
            public static final int OP_TYPE_ACTIVATE_VALUE = 1;
            public static final int OP_TYPE_DEACTIVATE_VALUE = 2;
            private static final Internal.EnumLiteMap<OpType> internalValueMap = new Internal.EnumLiteMap<OpType>() { // from class: emu.grasscutter.net.proto.UpdateAbilityCreatedMovingPlatformNotifyOuterClass.UpdateAbilityCreatedMovingPlatformNotify.OpType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public OpType findValueByNumber(int number) {
                    return OpType.forNumber(number);
                }
            };
            private static final OpType[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static OpType valueOf(int value) {
                return forNumber(value);
            }

            public static OpType forNumber(int value) {
                switch (value) {
                    case 0:
                        return OP_TYPE_NONE;
                    case 1:
                        return OP_TYPE_ACTIVATE;
                    case 2:
                        return OP_TYPE_DEACTIVATE;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<OpType> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                if (this != UNRECOGNIZED) {
                    return getDescriptor().getValues().get(ordinal());
                }
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return UpdateAbilityCreatedMovingPlatformNotify.getDescriptor().getEnumTypes().get(0);
            }

            public static OpType valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            OpType(int value) {
                this.value = value;
            }
        }

        @Override // emu.grasscutter.net.proto.UpdateAbilityCreatedMovingPlatformNotifyOuterClass.UpdateAbilityCreatedMovingPlatformNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.UpdateAbilityCreatedMovingPlatformNotifyOuterClass.UpdateAbilityCreatedMovingPlatformNotifyOrBuilder
        public int getOpTypeValue() {
            return this.opType_;
        }

        @Override // emu.grasscutter.net.proto.UpdateAbilityCreatedMovingPlatformNotifyOuterClass.UpdateAbilityCreatedMovingPlatformNotifyOrBuilder
        public OpType getOpType() {
            OpType result = OpType.valueOf(this.opType_);
            return result == null ? OpType.UNRECOGNIZED : result;
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
                output.writeUInt32(1, this.entityId_);
            }
            if (this.opType_ != OpType.OP_TYPE_NONE.getNumber()) {
                output.writeEnum(15, this.opType_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.entityId_);
            }
            if (this.opType_ != OpType.OP_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(15, this.opType_);
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
            if (!(obj instanceof UpdateAbilityCreatedMovingPlatformNotify)) {
                return equals(obj);
            }
            UpdateAbilityCreatedMovingPlatformNotify other = (UpdateAbilityCreatedMovingPlatformNotify) obj;
            return getEntityId() == other.getEntityId() && this.opType_ == other.opType_ && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getEntityId())) + 15)) + this.opType_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static UpdateAbilityCreatedMovingPlatformNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UpdateAbilityCreatedMovingPlatformNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpdateAbilityCreatedMovingPlatformNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UpdateAbilityCreatedMovingPlatformNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpdateAbilityCreatedMovingPlatformNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UpdateAbilityCreatedMovingPlatformNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpdateAbilityCreatedMovingPlatformNotify parseFrom(InputStream input) throws IOException {
            return (UpdateAbilityCreatedMovingPlatformNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UpdateAbilityCreatedMovingPlatformNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdateAbilityCreatedMovingPlatformNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UpdateAbilityCreatedMovingPlatformNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (UpdateAbilityCreatedMovingPlatformNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UpdateAbilityCreatedMovingPlatformNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdateAbilityCreatedMovingPlatformNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UpdateAbilityCreatedMovingPlatformNotify parseFrom(CodedInputStream input) throws IOException {
            return (UpdateAbilityCreatedMovingPlatformNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UpdateAbilityCreatedMovingPlatformNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdateAbilityCreatedMovingPlatformNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UpdateAbilityCreatedMovingPlatformNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdateAbilityCreatedMovingPlatformNotifyOuterClass$UpdateAbilityCreatedMovingPlatformNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UpdateAbilityCreatedMovingPlatformNotifyOrBuilder {
            private int entityId_;
            private int opType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return UpdateAbilityCreatedMovingPlatformNotifyOuterClass.f903x186480e;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UpdateAbilityCreatedMovingPlatformNotifyOuterClass.f904x99eb808c.ensureFieldAccessorsInitialized(UpdateAbilityCreatedMovingPlatformNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UpdateAbilityCreatedMovingPlatformNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityId_ = 0;
                this.opType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UpdateAbilityCreatedMovingPlatformNotifyOuterClass.f903x186480e;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UpdateAbilityCreatedMovingPlatformNotify getDefaultInstanceForType() {
                return UpdateAbilityCreatedMovingPlatformNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UpdateAbilityCreatedMovingPlatformNotify build() {
                UpdateAbilityCreatedMovingPlatformNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UpdateAbilityCreatedMovingPlatformNotify buildPartial() {
                UpdateAbilityCreatedMovingPlatformNotify result = new UpdateAbilityCreatedMovingPlatformNotify(this);
                result.entityId_ = this.entityId_;
                result.opType_ = this.opType_;
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
                if (other instanceof UpdateAbilityCreatedMovingPlatformNotify) {
                    return mergeFrom((UpdateAbilityCreatedMovingPlatformNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UpdateAbilityCreatedMovingPlatformNotify other) {
                if (other == UpdateAbilityCreatedMovingPlatformNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.opType_ != 0) {
                    setOpTypeValue(other.getOpTypeValue());
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
                UpdateAbilityCreatedMovingPlatformNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = UpdateAbilityCreatedMovingPlatformNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (UpdateAbilityCreatedMovingPlatformNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.UpdateAbilityCreatedMovingPlatformNotifyOuterClass.UpdateAbilityCreatedMovingPlatformNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.UpdateAbilityCreatedMovingPlatformNotifyOuterClass.UpdateAbilityCreatedMovingPlatformNotifyOrBuilder
            public int getOpTypeValue() {
                return this.opType_;
            }

            public Builder setOpTypeValue(int value) {
                this.opType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UpdateAbilityCreatedMovingPlatformNotifyOuterClass.UpdateAbilityCreatedMovingPlatformNotifyOrBuilder
            public OpType getOpType() {
                OpType result = OpType.valueOf(this.opType_);
                return result == null ? OpType.UNRECOGNIZED : result;
            }

            public Builder setOpType(OpType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.opType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearOpType() {
                this.opType_ = 0;
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

        public static UpdateAbilityCreatedMovingPlatformNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UpdateAbilityCreatedMovingPlatformNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UpdateAbilityCreatedMovingPlatformNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UpdateAbilityCreatedMovingPlatformNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
