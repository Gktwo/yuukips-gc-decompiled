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
import emu.grasscutter.net.proto.OpTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdateAbilityCreatedMovingPlatformNotifyOuterClass.class */
public final class UpdateAbilityCreatedMovingPlatformNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n.UpdateAbilityCreatedMovingPlatformNotify.proto\u001a\fOpType.proto\"U\n(UpdateAbilityCreatedMovingPlatformNotify\u0012\u0010\n\bentityId\u0018\u0004 \u0001(\r\u0012\u0017\n\u0006opType\u0018\u0006 \u0001(\u000e2\u0007.OpTypeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{OpTypeOuterClass.getDescriptor()});

    /* renamed from: internal_static_UpdateAbilityCreatedMovingPlatformNotify_descriptor */
    private static final Descriptors.Descriptor f872x186480e = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_UpdateAbilityCreatedMovingPlatformNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f873x99eb808c = new GeneratedMessageV3.FieldAccessorTable(f872x186480e, new String[]{"EntityId", "OpType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UpdateAbilityCreatedMovingPlatformNotifyOuterClass$UpdateAbilityCreatedMovingPlatformNotifyOrBuilder.class */
    public interface UpdateAbilityCreatedMovingPlatformNotifyOrBuilder extends MessageOrBuilder {
        int getEntityId();

        int getOpTypeValue();

        OpTypeOuterClass.OpType getOpType();
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
        public static final int ENTITYID_FIELD_NUMBER = 4;
        private int entityId_;
        public static final int OPTYPE_FIELD_NUMBER = 6;
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
                                case 32:
                                    this.entityId_ = input.readUInt32();
                                    break;
                                case 48:
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
            return UpdateAbilityCreatedMovingPlatformNotifyOuterClass.f872x186480e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UpdateAbilityCreatedMovingPlatformNotifyOuterClass.f873x99eb808c.ensureFieldAccessorsInitialized(UpdateAbilityCreatedMovingPlatformNotify.class, Builder.class);
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
        public OpTypeOuterClass.OpType getOpType() {
            OpTypeOuterClass.OpType result = OpTypeOuterClass.OpType.valueOf(this.opType_);
            return result == null ? OpTypeOuterClass.OpType.UNRECOGNIZED : result;
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
                output.writeUInt32(4, this.entityId_);
            }
            if (this.opType_ != OpTypeOuterClass.OpType.OP_TYPE_NONE.getNumber()) {
                output.writeEnum(6, this.opType_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.entityId_);
            }
            if (this.opType_ != OpTypeOuterClass.OpType.OP_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(6, this.opType_);
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
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getEntityId())) + 6)) + this.opType_)) + this.unknownFields.hashCode();
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
                return UpdateAbilityCreatedMovingPlatformNotifyOuterClass.f872x186480e;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UpdateAbilityCreatedMovingPlatformNotifyOuterClass.f873x99eb808c.ensureFieldAccessorsInitialized(UpdateAbilityCreatedMovingPlatformNotify.class, Builder.class);
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
                return UpdateAbilityCreatedMovingPlatformNotifyOuterClass.f872x186480e;
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
            public OpTypeOuterClass.OpType getOpType() {
                OpTypeOuterClass.OpType result = OpTypeOuterClass.OpType.valueOf(this.opType_);
                return result == null ? OpTypeOuterClass.OpType.UNRECOGNIZED : result;
            }

            public Builder setOpType(OpTypeOuterClass.OpType value) {
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

    static {
        OpTypeOuterClass.getDescriptor();
    }
}
