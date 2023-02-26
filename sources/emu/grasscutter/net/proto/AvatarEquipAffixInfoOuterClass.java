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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarEquipAffixInfoOuterClass.class */
public final class AvatarEquipAffixInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aAvatarEquipAffixInfo.proto\"@\n\u0014AvatarEquipAffixInfo\u0012\u0014\n\fequipAffixId\u0018\u0001 \u0001(\r\u0012\u0012\n\nleftCdTime\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarEquipAffixInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarEquipAffixInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarEquipAffixInfo_descriptor, new String[]{"EquipAffixId", "LeftCdTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarEquipAffixInfoOuterClass$AvatarEquipAffixInfoOrBuilder.class */
    public interface AvatarEquipAffixInfoOrBuilder extends MessageOrBuilder {
        int getEquipAffixId();

        int getLeftCdTime();
    }

    private AvatarEquipAffixInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarEquipAffixInfoOuterClass$AvatarEquipAffixInfo.class */
    public static final class AvatarEquipAffixInfo extends GeneratedMessageV3 implements AvatarEquipAffixInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int EQUIPAFFIXID_FIELD_NUMBER = 1;
        private int equipAffixId_;
        public static final int LEFTCDTIME_FIELD_NUMBER = 2;
        private int leftCdTime_;
        private byte memoizedIsInitialized;
        private static final AvatarEquipAffixInfo DEFAULT_INSTANCE = new AvatarEquipAffixInfo();
        private static final Parser<AvatarEquipAffixInfo> PARSER = new AbstractParser<AvatarEquipAffixInfo>() { // from class: emu.grasscutter.net.proto.AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.1
            @Override // com.google.protobuf.Parser
            public AvatarEquipAffixInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarEquipAffixInfo(input, extensionRegistry);
            }
        };

        private AvatarEquipAffixInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarEquipAffixInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarEquipAffixInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarEquipAffixInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.equipAffixId_ = input.readUInt32();
                                break;
                            case 16:
                                this.leftCdTime_ = input.readUInt32();
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
            return AvatarEquipAffixInfoOuterClass.internal_static_AvatarEquipAffixInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarEquipAffixInfoOuterClass.internal_static_AvatarEquipAffixInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarEquipAffixInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder
        public int getEquipAffixId() {
            return this.equipAffixId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder
        public int getLeftCdTime() {
            return this.leftCdTime_;
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
            if (this.equipAffixId_ != 0) {
                output.writeUInt32(1, this.equipAffixId_);
            }
            if (this.leftCdTime_ != 0) {
                output.writeUInt32(2, this.leftCdTime_);
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
            if (this.equipAffixId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.equipAffixId_);
            }
            if (this.leftCdTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.leftCdTime_);
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
            if (!(obj instanceof AvatarEquipAffixInfo)) {
                return equals(obj);
            }
            AvatarEquipAffixInfo other = (AvatarEquipAffixInfo) obj;
            return getEquipAffixId() == other.getEquipAffixId() && getLeftCdTime() == other.getLeftCdTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getEquipAffixId())) + 2)) + getLeftCdTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AvatarEquipAffixInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarEquipAffixInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarEquipAffixInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarEquipAffixInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarEquipAffixInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarEquipAffixInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarEquipAffixInfo parseFrom(InputStream input) throws IOException {
            return (AvatarEquipAffixInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarEquipAffixInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarEquipAffixInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarEquipAffixInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarEquipAffixInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarEquipAffixInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarEquipAffixInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarEquipAffixInfo parseFrom(CodedInputStream input) throws IOException {
            return (AvatarEquipAffixInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarEquipAffixInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarEquipAffixInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarEquipAffixInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarEquipAffixInfoOuterClass$AvatarEquipAffixInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarEquipAffixInfoOrBuilder {
            private int equipAffixId_;
            private int leftCdTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarEquipAffixInfoOuterClass.internal_static_AvatarEquipAffixInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarEquipAffixInfoOuterClass.internal_static_AvatarEquipAffixInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarEquipAffixInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarEquipAffixInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.equipAffixId_ = 0;
                this.leftCdTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarEquipAffixInfoOuterClass.internal_static_AvatarEquipAffixInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarEquipAffixInfo getDefaultInstanceForType() {
                return AvatarEquipAffixInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarEquipAffixInfo build() {
                AvatarEquipAffixInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarEquipAffixInfo buildPartial() {
                AvatarEquipAffixInfo result = new AvatarEquipAffixInfo(this);
                result.equipAffixId_ = this.equipAffixId_;
                result.leftCdTime_ = this.leftCdTime_;
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
                if (other instanceof AvatarEquipAffixInfo) {
                    return mergeFrom((AvatarEquipAffixInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarEquipAffixInfo other) {
                if (other == AvatarEquipAffixInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getEquipAffixId() != 0) {
                    setEquipAffixId(other.getEquipAffixId());
                }
                if (other.getLeftCdTime() != 0) {
                    setLeftCdTime(other.getLeftCdTime());
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
                AvatarEquipAffixInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarEquipAffixInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarEquipAffixInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder
            public int getEquipAffixId() {
                return this.equipAffixId_;
            }

            public Builder setEquipAffixId(int value) {
                this.equipAffixId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEquipAffixId() {
                this.equipAffixId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder
            public int getLeftCdTime() {
                return this.leftCdTime_;
            }

            public Builder setLeftCdTime(int value) {
                this.leftCdTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearLeftCdTime() {
                this.leftCdTime_ = 0;
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

        public static AvatarEquipAffixInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarEquipAffixInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarEquipAffixInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarEquipAffixInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
