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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AvatarEquipAffixInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarEquipAffixStartNotifyOuterClass.class */
public final class AvatarEquipAffixStartNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!AvatarEquipAffixStartNotify.proto\u001a\u001aAvatarEquipAffixInfo.proto\"`\n\u001bAvatarEquipAffixStartNotify\u0012-\n\u000eequipAffixInfo\u0018\u0005 \u0001(\u000b2\u0015.AvatarEquipAffixInfo\u0012\u0012\n\navatarGuid\u0018\u000f \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AvatarEquipAffixInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarEquipAffixStartNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarEquipAffixStartNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarEquipAffixStartNotify_descriptor, new String[]{"EquipAffixInfo", "AvatarGuid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarEquipAffixStartNotifyOuterClass$AvatarEquipAffixStartNotifyOrBuilder.class */
    public interface AvatarEquipAffixStartNotifyOrBuilder extends MessageOrBuilder {
        boolean hasEquipAffixInfo();

        AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo getEquipAffixInfo();

        AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder getEquipAffixInfoOrBuilder();

        long getAvatarGuid();
    }

    private AvatarEquipAffixStartNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarEquipAffixStartNotifyOuterClass$AvatarEquipAffixStartNotify.class */
    public static final class AvatarEquipAffixStartNotify extends GeneratedMessageV3 implements AvatarEquipAffixStartNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int EQUIPAFFIXINFO_FIELD_NUMBER = 5;
        private AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo equipAffixInfo_;
        public static final int AVATARGUID_FIELD_NUMBER = 15;
        private long avatarGuid_;
        private byte memoizedIsInitialized;
        private static final AvatarEquipAffixStartNotify DEFAULT_INSTANCE = new AvatarEquipAffixStartNotify();
        private static final Parser<AvatarEquipAffixStartNotify> PARSER = new AbstractParser<AvatarEquipAffixStartNotify>() { // from class: emu.grasscutter.net.proto.AvatarEquipAffixStartNotifyOuterClass.AvatarEquipAffixStartNotify.1
            @Override // com.google.protobuf.Parser
            public AvatarEquipAffixStartNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarEquipAffixStartNotify(input, extensionRegistry);
            }
        };

        private AvatarEquipAffixStartNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarEquipAffixStartNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarEquipAffixStartNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarEquipAffixStartNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.Builder subBuilder = this.equipAffixInfo_ != null ? this.equipAffixInfo_.toBuilder() : null;
                                    this.equipAffixInfo_ = (AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo) input.readMessage(AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.equipAffixInfo_);
                                        this.equipAffixInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 120:
                                    this.avatarGuid_ = input.readUInt64();
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
            return AvatarEquipAffixStartNotifyOuterClass.internal_static_AvatarEquipAffixStartNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarEquipAffixStartNotifyOuterClass.internal_static_AvatarEquipAffixStartNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarEquipAffixStartNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarEquipAffixStartNotifyOuterClass.AvatarEquipAffixStartNotifyOrBuilder
        public boolean hasEquipAffixInfo() {
            return this.equipAffixInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.AvatarEquipAffixStartNotifyOuterClass.AvatarEquipAffixStartNotifyOrBuilder
        public AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo getEquipAffixInfo() {
            return this.equipAffixInfo_ == null ? AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.getDefaultInstance() : this.equipAffixInfo_;
        }

        @Override // emu.grasscutter.net.proto.AvatarEquipAffixStartNotifyOuterClass.AvatarEquipAffixStartNotifyOrBuilder
        public AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder getEquipAffixInfoOrBuilder() {
            return getEquipAffixInfo();
        }

        @Override // emu.grasscutter.net.proto.AvatarEquipAffixStartNotifyOuterClass.AvatarEquipAffixStartNotifyOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
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
            if (this.equipAffixInfo_ != null) {
                output.writeMessage(5, getEquipAffixInfo());
            }
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(15, this.avatarGuid_);
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
            if (this.equipAffixInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(5, getEquipAffixInfo());
            }
            if (this.avatarGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(15, this.avatarGuid_);
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
            if (!(obj instanceof AvatarEquipAffixStartNotify)) {
                return equals(obj);
            }
            AvatarEquipAffixStartNotify other = (AvatarEquipAffixStartNotify) obj;
            if (hasEquipAffixInfo() != other.hasEquipAffixInfo()) {
                return false;
            }
            return (!hasEquipAffixInfo() || getEquipAffixInfo().equals(other.getEquipAffixInfo())) && getAvatarGuid() == other.getAvatarGuid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasEquipAffixInfo()) {
                hash = (53 * ((37 * hash) + 5)) + getEquipAffixInfo().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 15)) + Internal.hashLong(getAvatarGuid()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarEquipAffixStartNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarEquipAffixStartNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarEquipAffixStartNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarEquipAffixStartNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarEquipAffixStartNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarEquipAffixStartNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarEquipAffixStartNotify parseFrom(InputStream input) throws IOException {
            return (AvatarEquipAffixStartNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarEquipAffixStartNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarEquipAffixStartNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarEquipAffixStartNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarEquipAffixStartNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarEquipAffixStartNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarEquipAffixStartNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarEquipAffixStartNotify parseFrom(CodedInputStream input) throws IOException {
            return (AvatarEquipAffixStartNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarEquipAffixStartNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarEquipAffixStartNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarEquipAffixStartNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarEquipAffixStartNotifyOuterClass$AvatarEquipAffixStartNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarEquipAffixStartNotifyOrBuilder {
            private AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo equipAffixInfo_;
            private SingleFieldBuilderV3<AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo, AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.Builder, AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder> equipAffixInfoBuilder_;
            private long avatarGuid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarEquipAffixStartNotifyOuterClass.internal_static_AvatarEquipAffixStartNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarEquipAffixStartNotifyOuterClass.internal_static_AvatarEquipAffixStartNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarEquipAffixStartNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarEquipAffixStartNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.equipAffixInfoBuilder_ == null) {
                    this.equipAffixInfo_ = null;
                } else {
                    this.equipAffixInfo_ = null;
                    this.equipAffixInfoBuilder_ = null;
                }
                this.avatarGuid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarEquipAffixStartNotifyOuterClass.internal_static_AvatarEquipAffixStartNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarEquipAffixStartNotify getDefaultInstanceForType() {
                return AvatarEquipAffixStartNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarEquipAffixStartNotify build() {
                AvatarEquipAffixStartNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarEquipAffixStartNotify buildPartial() {
                AvatarEquipAffixStartNotify result = new AvatarEquipAffixStartNotify(this);
                if (this.equipAffixInfoBuilder_ == null) {
                    result.equipAffixInfo_ = this.equipAffixInfo_;
                } else {
                    result.equipAffixInfo_ = this.equipAffixInfoBuilder_.build();
                }
                result.avatarGuid_ = this.avatarGuid_;
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
                if (other instanceof AvatarEquipAffixStartNotify) {
                    return mergeFrom((AvatarEquipAffixStartNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarEquipAffixStartNotify other) {
                if (other == AvatarEquipAffixStartNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasEquipAffixInfo()) {
                    mergeEquipAffixInfo(other.getEquipAffixInfo());
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
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
                AvatarEquipAffixStartNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarEquipAffixStartNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarEquipAffixStartNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarEquipAffixStartNotifyOuterClass.AvatarEquipAffixStartNotifyOrBuilder
            public boolean hasEquipAffixInfo() {
                return (this.equipAffixInfoBuilder_ == null && this.equipAffixInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AvatarEquipAffixStartNotifyOuterClass.AvatarEquipAffixStartNotifyOrBuilder
            public AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo getEquipAffixInfo() {
                if (this.equipAffixInfoBuilder_ == null) {
                    return this.equipAffixInfo_ == null ? AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.getDefaultInstance() : this.equipAffixInfo_;
                }
                return this.equipAffixInfoBuilder_.getMessage();
            }

            public Builder setEquipAffixInfo(AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo value) {
                if (this.equipAffixInfoBuilder_ != null) {
                    this.equipAffixInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.equipAffixInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setEquipAffixInfo(AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.Builder builderForValue) {
                if (this.equipAffixInfoBuilder_ == null) {
                    this.equipAffixInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.equipAffixInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeEquipAffixInfo(AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo value) {
                if (this.equipAffixInfoBuilder_ == null) {
                    if (this.equipAffixInfo_ != null) {
                        this.equipAffixInfo_ = AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.newBuilder(this.equipAffixInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.equipAffixInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.equipAffixInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearEquipAffixInfo() {
                if (this.equipAffixInfoBuilder_ == null) {
                    this.equipAffixInfo_ = null;
                    onChanged();
                } else {
                    this.equipAffixInfo_ = null;
                    this.equipAffixInfoBuilder_ = null;
                }
                return this;
            }

            public AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.Builder getEquipAffixInfoBuilder() {
                onChanged();
                return getEquipAffixInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AvatarEquipAffixStartNotifyOuterClass.AvatarEquipAffixStartNotifyOrBuilder
            public AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder getEquipAffixInfoOrBuilder() {
                if (this.equipAffixInfoBuilder_ != null) {
                    return this.equipAffixInfoBuilder_.getMessageOrBuilder();
                }
                return this.equipAffixInfo_ == null ? AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.getDefaultInstance() : this.equipAffixInfo_;
            }

            private SingleFieldBuilderV3<AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo, AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfo.Builder, AvatarEquipAffixInfoOuterClass.AvatarEquipAffixInfoOrBuilder> getEquipAffixInfoFieldBuilder() {
                if (this.equipAffixInfoBuilder_ == null) {
                    this.equipAffixInfoBuilder_ = new SingleFieldBuilderV3<>(getEquipAffixInfo(), getParentForChildren(), isClean());
                    this.equipAffixInfo_ = null;
                }
                return this.equipAffixInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AvatarEquipAffixStartNotifyOuterClass.AvatarEquipAffixStartNotifyOrBuilder
            public long getAvatarGuid() {
                return this.avatarGuid_;
            }

            public Builder setAvatarGuid(long value) {
                this.avatarGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarGuid() {
                this.avatarGuid_ = 0;
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

        public static AvatarEquipAffixStartNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarEquipAffixStartNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarEquipAffixStartNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarEquipAffixStartNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AvatarEquipAffixInfoOuterClass.getDescriptor();
    }
}
