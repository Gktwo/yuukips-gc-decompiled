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
import emu.grasscutter.net.proto.WidgetCreateLocationInfoOuterClass;
import emu.grasscutter.net.proto.WidgetCreatorOpTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetCreatorInfoOuterClass.class */
public final class WidgetCreatorInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017WidgetCreatorInfo.proto\u001a\u001eWidgetCreateLocationInfo.proto\u001a\u0019WidgetCreatorOpType.proto\"\n\u0011WidgetCreatorInfo\u0012%\n\u0007op_type\u0018\u000e \u0001(\u000e2\u0014.WidgetCreatorOpType\u0012\u0011\n\tentity_id\u0018\f \u0001(\r\u00120\n\rlocation_info\u0018\t \u0001(\u000b2\u0019.WidgetCreateLocationInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WidgetCreateLocationInfoOuterClass.getDescriptor(), WidgetCreatorOpTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WidgetCreatorInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WidgetCreatorInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WidgetCreatorInfo_descriptor, new String[]{"OpType", "EntityId", "LocationInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetCreatorInfoOuterClass$WidgetCreatorInfoOrBuilder.class */
    public interface WidgetCreatorInfoOrBuilder extends MessageOrBuilder {
        int getOpTypeValue();

        WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType getOpType();

        int getEntityId();

        boolean hasLocationInfo();

        WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo getLocationInfo();

        WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfoOrBuilder getLocationInfoOrBuilder();
    }

    private WidgetCreatorInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetCreatorInfoOuterClass$WidgetCreatorInfo.class */
    public static final class WidgetCreatorInfo extends GeneratedMessageV3 implements WidgetCreatorInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OP_TYPE_FIELD_NUMBER = 14;
        private int opType_;
        public static final int ENTITY_ID_FIELD_NUMBER = 12;
        private int entityId_;
        public static final int LOCATION_INFO_FIELD_NUMBER = 9;
        private WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo locationInfo_;
        private byte memoizedIsInitialized;
        private static final WidgetCreatorInfo DEFAULT_INSTANCE = new WidgetCreatorInfo();
        private static final Parser<WidgetCreatorInfo> PARSER = new AbstractParser<WidgetCreatorInfo>() { // from class: emu.grasscutter.net.proto.WidgetCreatorInfoOuterClass.WidgetCreatorInfo.1
            @Override // com.google.protobuf.Parser
            public WidgetCreatorInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WidgetCreatorInfo(input, extensionRegistry);
            }
        };

        private WidgetCreatorInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WidgetCreatorInfo() {
            this.memoizedIsInitialized = -1;
            this.opType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WidgetCreatorInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WidgetCreatorInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 74:
                                WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo.Builder subBuilder = this.locationInfo_ != null ? this.locationInfo_.toBuilder() : null;
                                this.locationInfo_ = (WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo) input.readMessage(WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.locationInfo_);
                                    this.locationInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 96:
                                this.entityId_ = input.readUInt32();
                                break;
                            case 112:
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
            return WidgetCreatorInfoOuterClass.internal_static_WidgetCreatorInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WidgetCreatorInfoOuterClass.internal_static_WidgetCreatorInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetCreatorInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WidgetCreatorInfoOuterClass.WidgetCreatorInfoOrBuilder
        public int getOpTypeValue() {
            return this.opType_;
        }

        @Override // emu.grasscutter.net.proto.WidgetCreatorInfoOuterClass.WidgetCreatorInfoOrBuilder
        public WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType getOpType() {
            WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType result = WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType.valueOf(this.opType_);
            return result == null ? WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.WidgetCreatorInfoOuterClass.WidgetCreatorInfoOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.WidgetCreatorInfoOuterClass.WidgetCreatorInfoOrBuilder
        public boolean hasLocationInfo() {
            return this.locationInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.WidgetCreatorInfoOuterClass.WidgetCreatorInfoOrBuilder
        public WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo getLocationInfo() {
            return this.locationInfo_ == null ? WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo.getDefaultInstance() : this.locationInfo_;
        }

        @Override // emu.grasscutter.net.proto.WidgetCreatorInfoOuterClass.WidgetCreatorInfoOrBuilder
        public WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfoOrBuilder getLocationInfoOrBuilder() {
            return getLocationInfo();
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
            if (this.locationInfo_ != null) {
                output.writeMessage(9, getLocationInfo());
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(12, this.entityId_);
            }
            if (this.opType_ != WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType.WIDGET_CREATOR_OP_TYPE_NONE.getNumber()) {
                output.writeEnum(14, this.opType_);
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
            if (this.locationInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(9, getLocationInfo());
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.entityId_);
            }
            if (this.opType_ != WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType.WIDGET_CREATOR_OP_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(14, this.opType_);
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
            if (!(obj instanceof WidgetCreatorInfo)) {
                return equals(obj);
            }
            WidgetCreatorInfo other = (WidgetCreatorInfo) obj;
            if (this.opType_ == other.opType_ && getEntityId() == other.getEntityId() && hasLocationInfo() == other.hasLocationInfo()) {
                return (!hasLocationInfo() || getLocationInfo().equals(other.getLocationInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + this.opType_)) + 12)) + getEntityId();
            if (hasLocationInfo()) {
                hash = (53 * ((37 * hash) + 9)) + getLocationInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WidgetCreatorInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetCreatorInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetCreatorInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetCreatorInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetCreatorInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetCreatorInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetCreatorInfo parseFrom(InputStream input) throws IOException {
            return (WidgetCreatorInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetCreatorInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetCreatorInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetCreatorInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (WidgetCreatorInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WidgetCreatorInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetCreatorInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetCreatorInfo parseFrom(CodedInputStream input) throws IOException {
            return (WidgetCreatorInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetCreatorInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetCreatorInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WidgetCreatorInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetCreatorInfoOuterClass$WidgetCreatorInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WidgetCreatorInfoOrBuilder {
            private int opType_ = 0;
            private int entityId_;
            private WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo locationInfo_;
            private SingleFieldBuilderV3<WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo, WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo.Builder, WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfoOrBuilder> locationInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WidgetCreatorInfoOuterClass.internal_static_WidgetCreatorInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WidgetCreatorInfoOuterClass.internal_static_WidgetCreatorInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetCreatorInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WidgetCreatorInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.opType_ = 0;
                this.entityId_ = 0;
                if (this.locationInfoBuilder_ == null) {
                    this.locationInfo_ = null;
                } else {
                    this.locationInfo_ = null;
                    this.locationInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WidgetCreatorInfoOuterClass.internal_static_WidgetCreatorInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WidgetCreatorInfo getDefaultInstanceForType() {
                return WidgetCreatorInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetCreatorInfo build() {
                WidgetCreatorInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetCreatorInfo buildPartial() {
                WidgetCreatorInfo result = new WidgetCreatorInfo(this);
                result.opType_ = this.opType_;
                result.entityId_ = this.entityId_;
                if (this.locationInfoBuilder_ == null) {
                    result.locationInfo_ = this.locationInfo_;
                } else {
                    result.locationInfo_ = this.locationInfoBuilder_.build();
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
                if (other instanceof WidgetCreatorInfo) {
                    return mergeFrom((WidgetCreatorInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WidgetCreatorInfo other) {
                if (other == WidgetCreatorInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.opType_ != 0) {
                    setOpTypeValue(other.getOpTypeValue());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.hasLocationInfo()) {
                    mergeLocationInfo(other.getLocationInfo());
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
                WidgetCreatorInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = WidgetCreatorInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WidgetCreatorInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WidgetCreatorInfoOuterClass.WidgetCreatorInfoOrBuilder
            public int getOpTypeValue() {
                return this.opType_;
            }

            public Builder setOpTypeValue(int value) {
                this.opType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WidgetCreatorInfoOuterClass.WidgetCreatorInfoOrBuilder
            public WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType getOpType() {
                WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType result = WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType.valueOf(this.opType_);
                return result == null ? WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType.UNRECOGNIZED : result;
            }

            public Builder setOpType(WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType value) {
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

            @Override // emu.grasscutter.net.proto.WidgetCreatorInfoOuterClass.WidgetCreatorInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.WidgetCreatorInfoOuterClass.WidgetCreatorInfoOrBuilder
            public boolean hasLocationInfo() {
                return (this.locationInfoBuilder_ == null && this.locationInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.WidgetCreatorInfoOuterClass.WidgetCreatorInfoOrBuilder
            public WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo getLocationInfo() {
                if (this.locationInfoBuilder_ == null) {
                    return this.locationInfo_ == null ? WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo.getDefaultInstance() : this.locationInfo_;
                }
                return this.locationInfoBuilder_.getMessage();
            }

            public Builder setLocationInfo(WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo value) {
                if (this.locationInfoBuilder_ != null) {
                    this.locationInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.locationInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setLocationInfo(WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo.Builder builderForValue) {
                if (this.locationInfoBuilder_ == null) {
                    this.locationInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.locationInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeLocationInfo(WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo value) {
                if (this.locationInfoBuilder_ == null) {
                    if (this.locationInfo_ != null) {
                        this.locationInfo_ = WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo.newBuilder(this.locationInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.locationInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.locationInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearLocationInfo() {
                if (this.locationInfoBuilder_ == null) {
                    this.locationInfo_ = null;
                    onChanged();
                } else {
                    this.locationInfo_ = null;
                    this.locationInfoBuilder_ = null;
                }
                return this;
            }

            public WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo.Builder getLocationInfoBuilder() {
                onChanged();
                return getLocationInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.WidgetCreatorInfoOuterClass.WidgetCreatorInfoOrBuilder
            public WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfoOrBuilder getLocationInfoOrBuilder() {
                if (this.locationInfoBuilder_ != null) {
                    return this.locationInfoBuilder_.getMessageOrBuilder();
                }
                return this.locationInfo_ == null ? WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo.getDefaultInstance() : this.locationInfo_;
            }

            private SingleFieldBuilderV3<WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo, WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfo.Builder, WidgetCreateLocationInfoOuterClass.WidgetCreateLocationInfoOrBuilder> getLocationInfoFieldBuilder() {
                if (this.locationInfoBuilder_ == null) {
                    this.locationInfoBuilder_ = new SingleFieldBuilderV3<>(getLocationInfo(), getParentForChildren(), isClean());
                    this.locationInfo_ = null;
                }
                return this.locationInfoBuilder_;
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

        public static WidgetCreatorInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WidgetCreatorInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WidgetCreatorInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WidgetCreatorInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WidgetCreateLocationInfoOuterClass.getDescriptor();
        WidgetCreatorOpTypeOuterClass.getDescriptor();
    }
}
