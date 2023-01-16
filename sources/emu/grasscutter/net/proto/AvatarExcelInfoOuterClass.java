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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExcelInfoOuterClass.class */
public final class AvatarExcelInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015AvatarExcelInfo.proto\"«\u0001\n\u000fAvatarExcelInfo\u0012\u0018\n\u0010prefab_path_hash\u0018\u0001 \u0001(\u0004\u0012\u001f\n\u0017prefab_path_remote_hash\u0018\u0002 \u0001(\u0004\u0012\u001c\n\u0014controller_path_hash\u0018\u0003 \u0001(\u0004\u0012#\n\u001bcontroller_path_remote_hash\u0018\u0004 \u0001(\u0004\u0012\u001a\n\u0012combat_config_hash\u0018\u0005 \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarExcelInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarExcelInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarExcelInfo_descriptor, new String[]{"PrefabPathHash", "PrefabPathRemoteHash", "ControllerPathHash", "ControllerPathRemoteHash", "CombatConfigHash"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExcelInfoOuterClass$AvatarExcelInfoOrBuilder.class */
    public interface AvatarExcelInfoOrBuilder extends MessageOrBuilder {
        long getPrefabPathHash();

        long getPrefabPathRemoteHash();

        long getControllerPathHash();

        long getControllerPathRemoteHash();

        long getCombatConfigHash();
    }

    private AvatarExcelInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExcelInfoOuterClass$AvatarExcelInfo.class */
    public static final class AvatarExcelInfo extends GeneratedMessageV3 implements AvatarExcelInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PREFAB_PATH_HASH_FIELD_NUMBER = 1;
        private long prefabPathHash_;
        public static final int PREFAB_PATH_REMOTE_HASH_FIELD_NUMBER = 2;
        private long prefabPathRemoteHash_;
        public static final int CONTROLLER_PATH_HASH_FIELD_NUMBER = 3;
        private long controllerPathHash_;
        public static final int CONTROLLER_PATH_REMOTE_HASH_FIELD_NUMBER = 4;
        private long controllerPathRemoteHash_;
        public static final int COMBAT_CONFIG_HASH_FIELD_NUMBER = 5;
        private long combatConfigHash_;
        private byte memoizedIsInitialized;
        private static final AvatarExcelInfo DEFAULT_INSTANCE = new AvatarExcelInfo();
        private static final Parser<AvatarExcelInfo> PARSER = new AbstractParser<AvatarExcelInfo>() { // from class: emu.grasscutter.net.proto.AvatarExcelInfoOuterClass.AvatarExcelInfo.1
            @Override // com.google.protobuf.Parser
            public AvatarExcelInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarExcelInfo(input, extensionRegistry);
            }
        };

        private AvatarExcelInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarExcelInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarExcelInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarExcelInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.prefabPathHash_ = input.readUInt64();
                                break;
                            case 16:
                                this.prefabPathRemoteHash_ = input.readUInt64();
                                break;
                            case 24:
                                this.controllerPathHash_ = input.readUInt64();
                                break;
                            case 32:
                                this.controllerPathRemoteHash_ = input.readUInt64();
                                break;
                            case 40:
                                this.combatConfigHash_ = input.readUInt64();
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
            return AvatarExcelInfoOuterClass.internal_static_AvatarExcelInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarExcelInfoOuterClass.internal_static_AvatarExcelInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarExcelInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder
        public long getPrefabPathHash() {
            return this.prefabPathHash_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder
        public long getPrefabPathRemoteHash() {
            return this.prefabPathRemoteHash_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder
        public long getControllerPathHash() {
            return this.controllerPathHash_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder
        public long getControllerPathRemoteHash() {
            return this.controllerPathRemoteHash_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder
        public long getCombatConfigHash() {
            return this.combatConfigHash_;
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
            if (this.prefabPathHash_ != 0) {
                output.writeUInt64(1, this.prefabPathHash_);
            }
            if (this.prefabPathRemoteHash_ != 0) {
                output.writeUInt64(2, this.prefabPathRemoteHash_);
            }
            if (this.controllerPathHash_ != 0) {
                output.writeUInt64(3, this.controllerPathHash_);
            }
            if (this.controllerPathRemoteHash_ != 0) {
                output.writeUInt64(4, this.controllerPathRemoteHash_);
            }
            if (this.combatConfigHash_ != 0) {
                output.writeUInt64(5, this.combatConfigHash_);
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
            if (this.prefabPathHash_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(1, this.prefabPathHash_);
            }
            if (this.prefabPathRemoteHash_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(2, this.prefabPathRemoteHash_);
            }
            if (this.controllerPathHash_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(3, this.controllerPathHash_);
            }
            if (this.controllerPathRemoteHash_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(4, this.controllerPathRemoteHash_);
            }
            if (this.combatConfigHash_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(5, this.combatConfigHash_);
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
            if (!(obj instanceof AvatarExcelInfo)) {
                return equals(obj);
            }
            AvatarExcelInfo other = (AvatarExcelInfo) obj;
            return getPrefabPathHash() == other.getPrefabPathHash() && getPrefabPathRemoteHash() == other.getPrefabPathRemoteHash() && getControllerPathHash() == other.getControllerPathHash() && getControllerPathRemoteHash() == other.getControllerPathRemoteHash() && getCombatConfigHash() == other.getCombatConfigHash() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Internal.hashLong(getPrefabPathHash()))) + 2)) + Internal.hashLong(getPrefabPathRemoteHash()))) + 3)) + Internal.hashLong(getControllerPathHash()))) + 4)) + Internal.hashLong(getControllerPathRemoteHash()))) + 5)) + Internal.hashLong(getCombatConfigHash()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AvatarExcelInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExcelInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExcelInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExcelInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExcelInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExcelInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExcelInfo parseFrom(InputStream input) throws IOException {
            return (AvatarExcelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarExcelInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExcelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarExcelInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarExcelInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarExcelInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExcelInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarExcelInfo parseFrom(CodedInputStream input) throws IOException {
            return (AvatarExcelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarExcelInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExcelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarExcelInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExcelInfoOuterClass$AvatarExcelInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarExcelInfoOrBuilder {
            private long prefabPathHash_;
            private long prefabPathRemoteHash_;
            private long controllerPathHash_;
            private long controllerPathRemoteHash_;
            private long combatConfigHash_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarExcelInfoOuterClass.internal_static_AvatarExcelInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarExcelInfoOuterClass.internal_static_AvatarExcelInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarExcelInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarExcelInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.prefabPathHash_ = 0;
                this.prefabPathRemoteHash_ = 0;
                this.controllerPathHash_ = 0;
                this.controllerPathRemoteHash_ = 0;
                this.combatConfigHash_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarExcelInfoOuterClass.internal_static_AvatarExcelInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarExcelInfo getDefaultInstanceForType() {
                return AvatarExcelInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarExcelInfo build() {
                AvatarExcelInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarExcelInfo buildPartial() {
                AvatarExcelInfo result = new AvatarExcelInfo(this);
                result.prefabPathHash_ = this.prefabPathHash_;
                result.prefabPathRemoteHash_ = this.prefabPathRemoteHash_;
                result.controllerPathHash_ = this.controllerPathHash_;
                result.controllerPathRemoteHash_ = this.controllerPathRemoteHash_;
                result.combatConfigHash_ = this.combatConfigHash_;
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
                if (other instanceof AvatarExcelInfo) {
                    return mergeFrom((AvatarExcelInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarExcelInfo other) {
                if (other == AvatarExcelInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getPrefabPathHash() != 0) {
                    setPrefabPathHash(other.getPrefabPathHash());
                }
                if (other.getPrefabPathRemoteHash() != 0) {
                    setPrefabPathRemoteHash(other.getPrefabPathRemoteHash());
                }
                if (other.getControllerPathHash() != 0) {
                    setControllerPathHash(other.getControllerPathHash());
                }
                if (other.getControllerPathRemoteHash() != 0) {
                    setControllerPathRemoteHash(other.getControllerPathRemoteHash());
                }
                if (other.getCombatConfigHash() != 0) {
                    setCombatConfigHash(other.getCombatConfigHash());
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
                AvatarExcelInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarExcelInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarExcelInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder
            public long getPrefabPathHash() {
                return this.prefabPathHash_;
            }

            public Builder setPrefabPathHash(long value) {
                this.prefabPathHash_ = value;
                onChanged();
                return this;
            }

            public Builder clearPrefabPathHash() {
                this.prefabPathHash_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder
            public long getPrefabPathRemoteHash() {
                return this.prefabPathRemoteHash_;
            }

            public Builder setPrefabPathRemoteHash(long value) {
                this.prefabPathRemoteHash_ = value;
                onChanged();
                return this;
            }

            public Builder clearPrefabPathRemoteHash() {
                this.prefabPathRemoteHash_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder
            public long getControllerPathHash() {
                return this.controllerPathHash_;
            }

            public Builder setControllerPathHash(long value) {
                this.controllerPathHash_ = value;
                onChanged();
                return this;
            }

            public Builder clearControllerPathHash() {
                this.controllerPathHash_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder
            public long getControllerPathRemoteHash() {
                return this.controllerPathRemoteHash_;
            }

            public Builder setControllerPathRemoteHash(long value) {
                this.controllerPathRemoteHash_ = value;
                onChanged();
                return this;
            }

            public Builder clearControllerPathRemoteHash() {
                this.controllerPathRemoteHash_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarExcelInfoOuterClass.AvatarExcelInfoOrBuilder
            public long getCombatConfigHash() {
                return this.combatConfigHash_;
            }

            public Builder setCombatConfigHash(long value) {
                this.combatConfigHash_ = value;
                onChanged();
                return this;
            }

            public Builder clearCombatConfigHash() {
                this.combatConfigHash_ = 0;
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

        public static AvatarExcelInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarExcelInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarExcelInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarExcelInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
