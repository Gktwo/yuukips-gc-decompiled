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
import emu.grasscutter.net.proto.LocationInfoOuterClass;
import emu.grasscutter.net.proto.WidgetCreatorOpTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreatorInfoOuterClass.class */
public final class CreatorInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011CreatorInfo.proto\u001a\u0012LocationInfo.proto\u001a\u0019WidgetCreatorOpType.proto\"j\n\u000bCreatorInfo\u0012\u0010\n\bentityId\u0018\t \u0001(\r\u0012#\n\flocationInfo\u0018\f \u0001(\u000b2\r.LocationInfo\u0012$\n\u0006opType\u0018\u0005 \u0001(\u000e2\u0014.WidgetCreatorOpTypeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{LocationInfoOuterClass.getDescriptor(), WidgetCreatorOpTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CreatorInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CreatorInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CreatorInfo_descriptor, new String[]{"EntityId", "LocationInfo", "OpType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreatorInfoOuterClass$CreatorInfoOrBuilder.class */
    public interface CreatorInfoOrBuilder extends MessageOrBuilder {
        int getEntityId();

        boolean hasLocationInfo();

        LocationInfoOuterClass.LocationInfo getLocationInfo();

        LocationInfoOuterClass.LocationInfoOrBuilder getLocationInfoOrBuilder();

        int getOpTypeValue();

        WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType getOpType();
    }

    private CreatorInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreatorInfoOuterClass$CreatorInfo.class */
    public static final class CreatorInfo extends GeneratedMessageV3 implements CreatorInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITYID_FIELD_NUMBER = 9;
        private int entityId_;
        public static final int LOCATIONINFO_FIELD_NUMBER = 12;
        private LocationInfoOuterClass.LocationInfo locationInfo_;
        public static final int OPTYPE_FIELD_NUMBER = 5;
        private int opType_;
        private byte memoizedIsInitialized;
        private static final CreatorInfo DEFAULT_INSTANCE = new CreatorInfo();
        private static final Parser<CreatorInfo> PARSER = new AbstractParser<CreatorInfo>() { // from class: emu.grasscutter.net.proto.CreatorInfoOuterClass.CreatorInfo.1
            @Override // com.google.protobuf.Parser
            public CreatorInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CreatorInfo(input, extensionRegistry);
            }
        };

        private CreatorInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CreatorInfo() {
            this.memoizedIsInitialized = -1;
            this.opType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CreatorInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CreatorInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 40:
                                this.opType_ = input.readEnum();
                                break;
                            case 72:
                                this.entityId_ = input.readUInt32();
                                break;
                            case 98:
                                LocationInfoOuterClass.LocationInfo.Builder subBuilder = this.locationInfo_ != null ? this.locationInfo_.toBuilder() : null;
                                this.locationInfo_ = (LocationInfoOuterClass.LocationInfo) input.readMessage(LocationInfoOuterClass.LocationInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.locationInfo_);
                                    this.locationInfo_ = subBuilder.buildPartial();
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
            return CreatorInfoOuterClass.internal_static_CreatorInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CreatorInfoOuterClass.internal_static_CreatorInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CreatorInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CreatorInfoOuterClass.CreatorInfoOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.CreatorInfoOuterClass.CreatorInfoOrBuilder
        public boolean hasLocationInfo() {
            return this.locationInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.CreatorInfoOuterClass.CreatorInfoOrBuilder
        public LocationInfoOuterClass.LocationInfo getLocationInfo() {
            return this.locationInfo_ == null ? LocationInfoOuterClass.LocationInfo.getDefaultInstance() : this.locationInfo_;
        }

        @Override // emu.grasscutter.net.proto.CreatorInfoOuterClass.CreatorInfoOrBuilder
        public LocationInfoOuterClass.LocationInfoOrBuilder getLocationInfoOrBuilder() {
            return getLocationInfo();
        }

        @Override // emu.grasscutter.net.proto.CreatorInfoOuterClass.CreatorInfoOrBuilder
        public int getOpTypeValue() {
            return this.opType_;
        }

        @Override // emu.grasscutter.net.proto.CreatorInfoOuterClass.CreatorInfoOrBuilder
        public WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType getOpType() {
            WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType result = WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType.valueOf(this.opType_);
            return result == null ? WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType.UNRECOGNIZED : result;
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
            if (this.opType_ != WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType.WIDGET_CREATOR_OP_TYPE_NONE.getNumber()) {
                output.writeEnum(5, this.opType_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(9, this.entityId_);
            }
            if (this.locationInfo_ != null) {
                output.writeMessage(12, getLocationInfo());
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
            if (this.opType_ != WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType.WIDGET_CREATOR_OP_TYPE_NONE.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(5, this.opType_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.entityId_);
            }
            if (this.locationInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getLocationInfo());
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
            if (!(obj instanceof CreatorInfo)) {
                return equals(obj);
            }
            CreatorInfo other = (CreatorInfo) obj;
            if (getEntityId() == other.getEntityId() && hasLocationInfo() == other.hasLocationInfo()) {
                return (!hasLocationInfo() || getLocationInfo().equals(other.getLocationInfo())) && this.opType_ == other.opType_ && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getEntityId();
            if (hasLocationInfo()) {
                hash = (53 * ((37 * hash) + 12)) + getLocationInfo().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 5)) + this.opType_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CreatorInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CreatorInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CreatorInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CreatorInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CreatorInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CreatorInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CreatorInfo parseFrom(InputStream input) throws IOException {
            return (CreatorInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CreatorInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CreatorInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CreatorInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CreatorInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CreatorInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CreatorInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CreatorInfo parseFrom(CodedInputStream input) throws IOException {
            return (CreatorInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CreatorInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CreatorInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CreatorInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreatorInfoOuterClass$CreatorInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CreatorInfoOrBuilder {
            private int entityId_;
            private LocationInfoOuterClass.LocationInfo locationInfo_;
            private SingleFieldBuilderV3<LocationInfoOuterClass.LocationInfo, LocationInfoOuterClass.LocationInfo.Builder, LocationInfoOuterClass.LocationInfoOrBuilder> locationInfoBuilder_;
            private int opType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return CreatorInfoOuterClass.internal_static_CreatorInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CreatorInfoOuterClass.internal_static_CreatorInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CreatorInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CreatorInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityId_ = 0;
                if (this.locationInfoBuilder_ == null) {
                    this.locationInfo_ = null;
                } else {
                    this.locationInfo_ = null;
                    this.locationInfoBuilder_ = null;
                }
                this.opType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CreatorInfoOuterClass.internal_static_CreatorInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CreatorInfo getDefaultInstanceForType() {
                return CreatorInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CreatorInfo build() {
                CreatorInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CreatorInfo buildPartial() {
                CreatorInfo result = new CreatorInfo(this);
                result.entityId_ = this.entityId_;
                if (this.locationInfoBuilder_ == null) {
                    result.locationInfo_ = this.locationInfo_;
                } else {
                    result.locationInfo_ = this.locationInfoBuilder_.build();
                }
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
                if (other instanceof CreatorInfo) {
                    return mergeFrom((CreatorInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CreatorInfo other) {
                if (other == CreatorInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.hasLocationInfo()) {
                    mergeLocationInfo(other.getLocationInfo());
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
                CreatorInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CreatorInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CreatorInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CreatorInfoOuterClass.CreatorInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.CreatorInfoOuterClass.CreatorInfoOrBuilder
            public boolean hasLocationInfo() {
                return (this.locationInfoBuilder_ == null && this.locationInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.CreatorInfoOuterClass.CreatorInfoOrBuilder
            public LocationInfoOuterClass.LocationInfo getLocationInfo() {
                if (this.locationInfoBuilder_ == null) {
                    return this.locationInfo_ == null ? LocationInfoOuterClass.LocationInfo.getDefaultInstance() : this.locationInfo_;
                }
                return this.locationInfoBuilder_.getMessage();
            }

            public Builder setLocationInfo(LocationInfoOuterClass.LocationInfo value) {
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

            public Builder setLocationInfo(LocationInfoOuterClass.LocationInfo.Builder builderForValue) {
                if (this.locationInfoBuilder_ == null) {
                    this.locationInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.locationInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeLocationInfo(LocationInfoOuterClass.LocationInfo value) {
                if (this.locationInfoBuilder_ == null) {
                    if (this.locationInfo_ != null) {
                        this.locationInfo_ = LocationInfoOuterClass.LocationInfo.newBuilder(this.locationInfo_).mergeFrom(value).buildPartial();
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

            public LocationInfoOuterClass.LocationInfo.Builder getLocationInfoBuilder() {
                onChanged();
                return getLocationInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.CreatorInfoOuterClass.CreatorInfoOrBuilder
            public LocationInfoOuterClass.LocationInfoOrBuilder getLocationInfoOrBuilder() {
                if (this.locationInfoBuilder_ != null) {
                    return this.locationInfoBuilder_.getMessageOrBuilder();
                }
                return this.locationInfo_ == null ? LocationInfoOuterClass.LocationInfo.getDefaultInstance() : this.locationInfo_;
            }

            private SingleFieldBuilderV3<LocationInfoOuterClass.LocationInfo, LocationInfoOuterClass.LocationInfo.Builder, LocationInfoOuterClass.LocationInfoOrBuilder> getLocationInfoFieldBuilder() {
                if (this.locationInfoBuilder_ == null) {
                    this.locationInfoBuilder_ = new SingleFieldBuilderV3<>(getLocationInfo(), getParentForChildren(), isClean());
                    this.locationInfo_ = null;
                }
                return this.locationInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.CreatorInfoOuterClass.CreatorInfoOrBuilder
            public int getOpTypeValue() {
                return this.opType_;
            }

            public Builder setOpTypeValue(int value) {
                this.opType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CreatorInfoOuterClass.CreatorInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static CreatorInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CreatorInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CreatorInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CreatorInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        LocationInfoOuterClass.getDescriptor();
        WidgetCreatorOpTypeOuterClass.getDescriptor();
    }
}
