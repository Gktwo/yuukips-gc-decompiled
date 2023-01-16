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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AiSyncInfoOuterClass.class */
public final class AiSyncInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010AiSyncInfo.proto\"T\n\nAiSyncInfo\u0012\u0011\n\tentity_id\u0018\u0002 \u0001(\r\u0012\u001a\n\u0012has_path_to_target\u0018\u0004 \u0001(\b\u0012\u0017\n\u000fis_self_killing\u0018\u000e \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AiSyncInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AiSyncInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AiSyncInfo_descriptor, new String[]{"EntityId", "HasPathToTarget", "IsSelfKilling"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AiSyncInfoOuterClass$AiSyncInfoOrBuilder.class */
    public interface AiSyncInfoOrBuilder extends MessageOrBuilder {
        int getEntityId();

        boolean getHasPathToTarget();

        boolean getIsSelfKilling();
    }

    private AiSyncInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AiSyncInfoOuterClass$AiSyncInfo.class */
    public static final class AiSyncInfo extends GeneratedMessageV3 implements AiSyncInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITY_ID_FIELD_NUMBER = 2;
        private int entityId_;
        public static final int HAS_PATH_TO_TARGET_FIELD_NUMBER = 4;
        private boolean hasPathToTarget_;
        public static final int IS_SELF_KILLING_FIELD_NUMBER = 14;
        private boolean isSelfKilling_;
        private byte memoizedIsInitialized;
        private static final AiSyncInfo DEFAULT_INSTANCE = new AiSyncInfo();
        private static final Parser<AiSyncInfo> PARSER = new AbstractParser<AiSyncInfo>() { // from class: emu.grasscutter.net.proto.AiSyncInfoOuterClass.AiSyncInfo.1
            @Override // com.google.protobuf.Parser
            public AiSyncInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AiSyncInfo(input, extensionRegistry);
            }
        };

        private AiSyncInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AiSyncInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AiSyncInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AiSyncInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    this.entityId_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.hasPathToTarget_ = input.readBool();
                                    break;
                                case 112:
                                    this.isSelfKilling_ = input.readBool();
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
            return AiSyncInfoOuterClass.internal_static_AiSyncInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AiSyncInfoOuterClass.internal_static_AiSyncInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AiSyncInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AiSyncInfoOuterClass.AiSyncInfoOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.AiSyncInfoOuterClass.AiSyncInfoOrBuilder
        public boolean getHasPathToTarget() {
            return this.hasPathToTarget_;
        }

        @Override // emu.grasscutter.net.proto.AiSyncInfoOuterClass.AiSyncInfoOrBuilder
        public boolean getIsSelfKilling() {
            return this.isSelfKilling_;
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
                output.writeUInt32(2, this.entityId_);
            }
            if (this.hasPathToTarget_) {
                output.writeBool(4, this.hasPathToTarget_);
            }
            if (this.isSelfKilling_) {
                output.writeBool(14, this.isSelfKilling_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.entityId_);
            }
            if (this.hasPathToTarget_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.hasPathToTarget_);
            }
            if (this.isSelfKilling_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.isSelfKilling_);
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
            if (!(obj instanceof AiSyncInfo)) {
                return equals(obj);
            }
            AiSyncInfo other = (AiSyncInfo) obj;
            return getEntityId() == other.getEntityId() && getHasPathToTarget() == other.getHasPathToTarget() && getIsSelfKilling() == other.getIsSelfKilling() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getEntityId())) + 4)) + Internal.hashBoolean(getHasPathToTarget()))) + 14)) + Internal.hashBoolean(getIsSelfKilling()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AiSyncInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AiSyncInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AiSyncInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AiSyncInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AiSyncInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AiSyncInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AiSyncInfo parseFrom(InputStream input) throws IOException {
            return (AiSyncInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AiSyncInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AiSyncInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AiSyncInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AiSyncInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AiSyncInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AiSyncInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AiSyncInfo parseFrom(CodedInputStream input) throws IOException {
            return (AiSyncInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AiSyncInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AiSyncInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AiSyncInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AiSyncInfoOuterClass$AiSyncInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AiSyncInfoOrBuilder {
            private int entityId_;
            private boolean hasPathToTarget_;
            private boolean isSelfKilling_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AiSyncInfoOuterClass.internal_static_AiSyncInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AiSyncInfoOuterClass.internal_static_AiSyncInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AiSyncInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AiSyncInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityId_ = 0;
                this.hasPathToTarget_ = false;
                this.isSelfKilling_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AiSyncInfoOuterClass.internal_static_AiSyncInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AiSyncInfo getDefaultInstanceForType() {
                return AiSyncInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AiSyncInfo build() {
                AiSyncInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AiSyncInfo buildPartial() {
                AiSyncInfo result = new AiSyncInfo(this);
                result.entityId_ = this.entityId_;
                result.hasPathToTarget_ = this.hasPathToTarget_;
                result.isSelfKilling_ = this.isSelfKilling_;
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
                if (other instanceof AiSyncInfo) {
                    return mergeFrom((AiSyncInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AiSyncInfo other) {
                if (other == AiSyncInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getHasPathToTarget()) {
                    setHasPathToTarget(other.getHasPathToTarget());
                }
                if (other.getIsSelfKilling()) {
                    setIsSelfKilling(other.getIsSelfKilling());
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
                AiSyncInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AiSyncInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AiSyncInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AiSyncInfoOuterClass.AiSyncInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AiSyncInfoOuterClass.AiSyncInfoOrBuilder
            public boolean getHasPathToTarget() {
                return this.hasPathToTarget_;
            }

            public Builder setHasPathToTarget(boolean value) {
                this.hasPathToTarget_ = value;
                onChanged();
                return this;
            }

            public Builder clearHasPathToTarget() {
                this.hasPathToTarget_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AiSyncInfoOuterClass.AiSyncInfoOrBuilder
            public boolean getIsSelfKilling() {
                return this.isSelfKilling_;
            }

            public Builder setIsSelfKilling(boolean value) {
                this.isSelfKilling_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsSelfKilling() {
                this.isSelfKilling_ = false;
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

        public static AiSyncInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AiSyncInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AiSyncInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AiSyncInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
