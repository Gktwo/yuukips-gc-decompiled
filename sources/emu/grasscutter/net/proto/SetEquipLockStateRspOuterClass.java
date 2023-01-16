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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetEquipLockStateRspOuterClass.class */
public final class SetEquipLockStateRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aSetEquipLockStateRsp.proto\"U\n\u0014SetEquipLockStateRsp\u0012\u0019\n\u0011target_equip_guid\u0018\u0001 \u0001(\u0004\u0012\u0011\n\tis_locked\u0018\u0003 \u0001(\b\u0012\u000f\n\u0007retcode\u0018\f \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SetEquipLockStateRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SetEquipLockStateRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SetEquipLockStateRsp_descriptor, new String[]{"TargetEquipGuid", "IsLocked", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetEquipLockStateRspOuterClass$SetEquipLockStateRspOrBuilder.class */
    public interface SetEquipLockStateRspOrBuilder extends MessageOrBuilder {
        long getTargetEquipGuid();

        boolean getIsLocked();

        int getRetcode();
    }

    private SetEquipLockStateRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetEquipLockStateRspOuterClass$SetEquipLockStateRsp.class */
    public static final class SetEquipLockStateRsp extends GeneratedMessageV3 implements SetEquipLockStateRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TARGET_EQUIP_GUID_FIELD_NUMBER = 1;
        private long targetEquipGuid_;
        public static final int IS_LOCKED_FIELD_NUMBER = 3;
        private boolean isLocked_;
        public static final int RETCODE_FIELD_NUMBER = 12;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final SetEquipLockStateRsp DEFAULT_INSTANCE = new SetEquipLockStateRsp();
        private static final Parser<SetEquipLockStateRsp> PARSER = new AbstractParser<SetEquipLockStateRsp>() { // from class: emu.grasscutter.net.proto.SetEquipLockStateRspOuterClass.SetEquipLockStateRsp.1
            @Override // com.google.protobuf.Parser
            public SetEquipLockStateRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SetEquipLockStateRsp(input, extensionRegistry);
            }
        };

        private SetEquipLockStateRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SetEquipLockStateRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SetEquipLockStateRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SetEquipLockStateRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.targetEquipGuid_ = input.readUInt64();
                                    break;
                                case 24:
                                    this.isLocked_ = input.readBool();
                                    break;
                                case 96:
                                    this.retcode_ = input.readInt32();
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
            return SetEquipLockStateRspOuterClass.internal_static_SetEquipLockStateRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SetEquipLockStateRspOuterClass.internal_static_SetEquipLockStateRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SetEquipLockStateRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SetEquipLockStateRspOuterClass.SetEquipLockStateRspOrBuilder
        public long getTargetEquipGuid() {
            return this.targetEquipGuid_;
        }

        @Override // emu.grasscutter.net.proto.SetEquipLockStateRspOuterClass.SetEquipLockStateRspOrBuilder
        public boolean getIsLocked() {
            return this.isLocked_;
        }

        @Override // emu.grasscutter.net.proto.SetEquipLockStateRspOuterClass.SetEquipLockStateRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
            if (this.targetEquipGuid_ != 0) {
                output.writeUInt64(1, this.targetEquipGuid_);
            }
            if (this.isLocked_) {
                output.writeBool(3, this.isLocked_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(12, this.retcode_);
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
            if (this.targetEquipGuid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(1, this.targetEquipGuid_);
            }
            if (this.isLocked_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.isLocked_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(12, this.retcode_);
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
            if (!(obj instanceof SetEquipLockStateRsp)) {
                return equals(obj);
            }
            SetEquipLockStateRsp other = (SetEquipLockStateRsp) obj;
            return getTargetEquipGuid() == other.getTargetEquipGuid() && getIsLocked() == other.getIsLocked() && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Internal.hashLong(getTargetEquipGuid()))) + 3)) + Internal.hashBoolean(getIsLocked()))) + 12)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SetEquipLockStateRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetEquipLockStateRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetEquipLockStateRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetEquipLockStateRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetEquipLockStateRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetEquipLockStateRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetEquipLockStateRsp parseFrom(InputStream input) throws IOException {
            return (SetEquipLockStateRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetEquipLockStateRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetEquipLockStateRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetEquipLockStateRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (SetEquipLockStateRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SetEquipLockStateRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetEquipLockStateRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetEquipLockStateRsp parseFrom(CodedInputStream input) throws IOException {
            return (SetEquipLockStateRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetEquipLockStateRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetEquipLockStateRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SetEquipLockStateRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetEquipLockStateRspOuterClass$SetEquipLockStateRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SetEquipLockStateRspOrBuilder {
            private long targetEquipGuid_;
            private boolean isLocked_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SetEquipLockStateRspOuterClass.internal_static_SetEquipLockStateRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SetEquipLockStateRspOuterClass.internal_static_SetEquipLockStateRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SetEquipLockStateRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SetEquipLockStateRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.targetEquipGuid_ = 0;
                this.isLocked_ = false;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SetEquipLockStateRspOuterClass.internal_static_SetEquipLockStateRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SetEquipLockStateRsp getDefaultInstanceForType() {
                return SetEquipLockStateRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetEquipLockStateRsp build() {
                SetEquipLockStateRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetEquipLockStateRsp buildPartial() {
                SetEquipLockStateRsp result = new SetEquipLockStateRsp(this);
                result.targetEquipGuid_ = this.targetEquipGuid_;
                result.isLocked_ = this.isLocked_;
                result.retcode_ = this.retcode_;
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
                if (other instanceof SetEquipLockStateRsp) {
                    return mergeFrom((SetEquipLockStateRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SetEquipLockStateRsp other) {
                if (other == SetEquipLockStateRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getTargetEquipGuid() != 0) {
                    setTargetEquipGuid(other.getTargetEquipGuid());
                }
                if (other.getIsLocked()) {
                    setIsLocked(other.getIsLocked());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                SetEquipLockStateRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = SetEquipLockStateRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SetEquipLockStateRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SetEquipLockStateRspOuterClass.SetEquipLockStateRspOrBuilder
            public long getTargetEquipGuid() {
                return this.targetEquipGuid_;
            }

            public Builder setTargetEquipGuid(long value) {
                this.targetEquipGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetEquipGuid() {
                this.targetEquipGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SetEquipLockStateRspOuterClass.SetEquipLockStateRspOrBuilder
            public boolean getIsLocked() {
                return this.isLocked_;
            }

            public Builder setIsLocked(boolean value) {
                this.isLocked_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsLocked() {
                this.isLocked_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SetEquipLockStateRspOuterClass.SetEquipLockStateRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
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

        public static SetEquipLockStateRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SetEquipLockStateRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SetEquipLockStateRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SetEquipLockStateRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
