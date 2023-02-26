package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.CreatorInfoOuterClass;
import emu.grasscutter.net.proto.LocationInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetDoBagReqOuterClass.class */
public final class WidgetDoBagReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014WidgetDoBagReq.proto\u001a\u0012LocationInfo.proto\u001a\u0011CreatorInfo.proto\"\u0001\n\u000eWidgetDoBagReq\u0012\u0012\n\nmaterialId\u0018\f \u0001(\r\u0012'\n\rlocation_info\u0018\u0001 \u0001(\u000b2\r.LocationInfoH��\u0012,\n\u0013widget_creator_info\u0018ê\u0002 \u0001(\u000b2\f.CreatorInfoH��B\t\n\u0007op_infoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{LocationInfoOuterClass.getDescriptor(), CreatorInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WidgetDoBagReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WidgetDoBagReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WidgetDoBagReq_descriptor, new String[]{"MaterialId", "LocationInfo", "WidgetCreatorInfo", "OpInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetDoBagReqOuterClass$WidgetDoBagReqOrBuilder.class */
    public interface WidgetDoBagReqOrBuilder extends MessageOrBuilder {
        int getMaterialId();

        boolean hasLocationInfo();

        LocationInfoOuterClass.LocationInfo getLocationInfo();

        LocationInfoOuterClass.LocationInfoOrBuilder getLocationInfoOrBuilder();

        boolean hasWidgetCreatorInfo();

        CreatorInfoOuterClass.CreatorInfo getWidgetCreatorInfo();

        CreatorInfoOuterClass.CreatorInfoOrBuilder getWidgetCreatorInfoOrBuilder();

        WidgetDoBagReq.OpInfoCase getOpInfoCase();
    }

    private WidgetDoBagReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetDoBagReqOuterClass$WidgetDoBagReq.class */
    public static final class WidgetDoBagReq extends GeneratedMessageV3 implements WidgetDoBagReqOrBuilder {
        private static final long serialVersionUID = 0;
        private int opInfoCase_;
        private Object opInfo_;
        public static final int MATERIALID_FIELD_NUMBER = 12;
        private int materialId_;
        public static final int LOCATION_INFO_FIELD_NUMBER = 135;
        public static final int WIDGET_CREATOR_INFO_FIELD_NUMBER = 362;
        private byte memoizedIsInitialized;
        private static final WidgetDoBagReq DEFAULT_INSTANCE = new WidgetDoBagReq();
        private static final Parser<WidgetDoBagReq> PARSER = new AbstractParser<WidgetDoBagReq>() { // from class: emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReq.1
            @Override // com.google.protobuf.Parser
            public WidgetDoBagReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WidgetDoBagReq(input, extensionRegistry);
            }
        };

        private WidgetDoBagReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.opInfoCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private WidgetDoBagReq() {
            this.opInfoCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WidgetDoBagReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WidgetDoBagReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 96:
                                this.materialId_ = input.readUInt32();
                                break;
                            case 1082:
                                LocationInfoOuterClass.LocationInfo.Builder subBuilder = this.opInfoCase_ == 135 ? ((LocationInfoOuterClass.LocationInfo) this.opInfo_).toBuilder() : null;
                                this.opInfo_ = input.readMessage(LocationInfoOuterClass.LocationInfo.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((LocationInfoOuterClass.LocationInfo) this.opInfo_);
                                    this.opInfo_ = subBuilder.buildPartial();
                                }
                                this.opInfoCase_ = 135;
                                break;
                            case PacketOpcodes.TakeCityReputationLevelRewardRsp:
                                CreatorInfoOuterClass.CreatorInfo.Builder subBuilder2 = this.opInfoCase_ == 362 ? ((CreatorInfoOuterClass.CreatorInfo) this.opInfo_).toBuilder() : null;
                                this.opInfo_ = input.readMessage(CreatorInfoOuterClass.CreatorInfo.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((CreatorInfoOuterClass.CreatorInfo) this.opInfo_);
                                    this.opInfo_ = subBuilder2.buildPartial();
                                }
                                this.opInfoCase_ = 362;
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
            return WidgetDoBagReqOuterClass.internal_static_WidgetDoBagReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WidgetDoBagReqOuterClass.internal_static_WidgetDoBagReq_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetDoBagReq.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetDoBagReqOuterClass$WidgetDoBagReq$OpInfoCase.class */
        public enum OpInfoCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            LOCATION_INFO(135),
            WIDGET_CREATOR_INFO(362),
            OPINFO_NOT_SET(0);
            
            private final int value;

            OpInfoCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static OpInfoCase valueOf(int value) {
                return forNumber(value);
            }

            public static OpInfoCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return OPINFO_NOT_SET;
                    case 135:
                        return LOCATION_INFO;
                    case 362:
                        return WIDGET_CREATOR_INFO;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReqOrBuilder
        public OpInfoCase getOpInfoCase() {
            return OpInfoCase.forNumber(this.opInfoCase_);
        }

        @Override // emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReqOrBuilder
        public int getMaterialId() {
            return this.materialId_;
        }

        @Override // emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReqOrBuilder
        public boolean hasLocationInfo() {
            return this.opInfoCase_ == 135;
        }

        @Override // emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReqOrBuilder
        public LocationInfoOuterClass.LocationInfo getLocationInfo() {
            if (this.opInfoCase_ == 135) {
                return (LocationInfoOuterClass.LocationInfo) this.opInfo_;
            }
            return LocationInfoOuterClass.LocationInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReqOrBuilder
        public LocationInfoOuterClass.LocationInfoOrBuilder getLocationInfoOrBuilder() {
            if (this.opInfoCase_ == 135) {
                return (LocationInfoOuterClass.LocationInfo) this.opInfo_;
            }
            return LocationInfoOuterClass.LocationInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReqOrBuilder
        public boolean hasWidgetCreatorInfo() {
            return this.opInfoCase_ == 362;
        }

        @Override // emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReqOrBuilder
        public CreatorInfoOuterClass.CreatorInfo getWidgetCreatorInfo() {
            if (this.opInfoCase_ == 362) {
                return (CreatorInfoOuterClass.CreatorInfo) this.opInfo_;
            }
            return CreatorInfoOuterClass.CreatorInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReqOrBuilder
        public CreatorInfoOuterClass.CreatorInfoOrBuilder getWidgetCreatorInfoOrBuilder() {
            if (this.opInfoCase_ == 362) {
                return (CreatorInfoOuterClass.CreatorInfo) this.opInfo_;
            }
            return CreatorInfoOuterClass.CreatorInfo.getDefaultInstance();
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
            if (this.materialId_ != 0) {
                output.writeUInt32(12, this.materialId_);
            }
            if (this.opInfoCase_ == 135) {
                output.writeMessage(135, (LocationInfoOuterClass.LocationInfo) this.opInfo_);
            }
            if (this.opInfoCase_ == 362) {
                output.writeMessage(362, (CreatorInfoOuterClass.CreatorInfo) this.opInfo_);
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
            if (this.materialId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(12, this.materialId_);
            }
            if (this.opInfoCase_ == 135) {
                size2 += CodedOutputStream.computeMessageSize(135, (LocationInfoOuterClass.LocationInfo) this.opInfo_);
            }
            if (this.opInfoCase_ == 362) {
                size2 += CodedOutputStream.computeMessageSize(362, (CreatorInfoOuterClass.CreatorInfo) this.opInfo_);
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
            if (!(obj instanceof WidgetDoBagReq)) {
                return equals(obj);
            }
            WidgetDoBagReq other = (WidgetDoBagReq) obj;
            if (getMaterialId() != other.getMaterialId() || !getOpInfoCase().equals(other.getOpInfoCase())) {
                return false;
            }
            switch (this.opInfoCase_) {
                case 135:
                    if (!getLocationInfo().equals(other.getLocationInfo())) {
                        return false;
                    }
                    break;
                case 362:
                    if (!getWidgetCreatorInfo().equals(other.getWidgetCreatorInfo())) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getMaterialId();
            switch (this.opInfoCase_) {
                case 135:
                    hash = (53 * ((37 * hash) + 135)) + getLocationInfo().hashCode();
                    break;
                case 362:
                    hash = (53 * ((37 * hash) + 362)) + getWidgetCreatorInfo().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WidgetDoBagReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetDoBagReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetDoBagReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetDoBagReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetDoBagReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetDoBagReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetDoBagReq parseFrom(InputStream input) throws IOException {
            return (WidgetDoBagReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetDoBagReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetDoBagReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetDoBagReq parseDelimitedFrom(InputStream input) throws IOException {
            return (WidgetDoBagReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WidgetDoBagReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetDoBagReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetDoBagReq parseFrom(CodedInputStream input) throws IOException {
            return (WidgetDoBagReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetDoBagReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetDoBagReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WidgetDoBagReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetDoBagReqOuterClass$WidgetDoBagReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WidgetDoBagReqOrBuilder {
            private int opInfoCase_ = 0;
            private Object opInfo_;
            private int materialId_;
            private SingleFieldBuilderV3<LocationInfoOuterClass.LocationInfo, LocationInfoOuterClass.LocationInfo.Builder, LocationInfoOuterClass.LocationInfoOrBuilder> locationInfoBuilder_;
            private SingleFieldBuilderV3<CreatorInfoOuterClass.CreatorInfo, CreatorInfoOuterClass.CreatorInfo.Builder, CreatorInfoOuterClass.CreatorInfoOrBuilder> widgetCreatorInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WidgetDoBagReqOuterClass.internal_static_WidgetDoBagReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WidgetDoBagReqOuterClass.internal_static_WidgetDoBagReq_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetDoBagReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WidgetDoBagReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.materialId_ = 0;
                this.opInfoCase_ = 0;
                this.opInfo_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WidgetDoBagReqOuterClass.internal_static_WidgetDoBagReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WidgetDoBagReq getDefaultInstanceForType() {
                return WidgetDoBagReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetDoBagReq build() {
                WidgetDoBagReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetDoBagReq buildPartial() {
                WidgetDoBagReq result = new WidgetDoBagReq(this);
                result.materialId_ = this.materialId_;
                if (this.opInfoCase_ == 135) {
                    if (this.locationInfoBuilder_ == null) {
                        result.opInfo_ = this.opInfo_;
                    } else {
                        result.opInfo_ = this.locationInfoBuilder_.build();
                    }
                }
                if (this.opInfoCase_ == 362) {
                    if (this.widgetCreatorInfoBuilder_ == null) {
                        result.opInfo_ = this.opInfo_;
                    } else {
                        result.opInfo_ = this.widgetCreatorInfoBuilder_.build();
                    }
                }
                result.opInfoCase_ = this.opInfoCase_;
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
                if (other instanceof WidgetDoBagReq) {
                    return mergeFrom((WidgetDoBagReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WidgetDoBagReq other) {
                if (other == WidgetDoBagReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getMaterialId() != 0) {
                    setMaterialId(other.getMaterialId());
                }
                switch (other.getOpInfoCase()) {
                    case LOCATION_INFO:
                        mergeLocationInfo(other.getLocationInfo());
                        break;
                    case WIDGET_CREATOR_INFO:
                        mergeWidgetCreatorInfo(other.getWidgetCreatorInfo());
                        break;
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
                WidgetDoBagReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = WidgetDoBagReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WidgetDoBagReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReqOrBuilder
            public OpInfoCase getOpInfoCase() {
                return OpInfoCase.forNumber(this.opInfoCase_);
            }

            public Builder clearOpInfo() {
                this.opInfoCase_ = 0;
                this.opInfo_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReqOrBuilder
            public int getMaterialId() {
                return this.materialId_;
            }

            public Builder setMaterialId(int value) {
                this.materialId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaterialId() {
                this.materialId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReqOrBuilder
            public boolean hasLocationInfo() {
                return this.opInfoCase_ == 135;
            }

            @Override // emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReqOrBuilder
            public LocationInfoOuterClass.LocationInfo getLocationInfo() {
                if (this.locationInfoBuilder_ == null) {
                    if (this.opInfoCase_ == 135) {
                        return (LocationInfoOuterClass.LocationInfo) this.opInfo_;
                    }
                    return LocationInfoOuterClass.LocationInfo.getDefaultInstance();
                } else if (this.opInfoCase_ == 135) {
                    return this.locationInfoBuilder_.getMessage();
                } else {
                    return LocationInfoOuterClass.LocationInfo.getDefaultInstance();
                }
            }

            public Builder setLocationInfo(LocationInfoOuterClass.LocationInfo value) {
                if (this.locationInfoBuilder_ != null) {
                    this.locationInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.opInfo_ = value;
                    onChanged();
                }
                this.opInfoCase_ = 135;
                return this;
            }

            public Builder setLocationInfo(LocationInfoOuterClass.LocationInfo.Builder builderForValue) {
                if (this.locationInfoBuilder_ == null) {
                    this.opInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.locationInfoBuilder_.setMessage(builderForValue.build());
                }
                this.opInfoCase_ = 135;
                return this;
            }

            public Builder mergeLocationInfo(LocationInfoOuterClass.LocationInfo value) {
                if (this.locationInfoBuilder_ == null) {
                    if (this.opInfoCase_ != 135 || this.opInfo_ == LocationInfoOuterClass.LocationInfo.getDefaultInstance()) {
                        this.opInfo_ = value;
                    } else {
                        this.opInfo_ = LocationInfoOuterClass.LocationInfo.newBuilder((LocationInfoOuterClass.LocationInfo) this.opInfo_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.opInfoCase_ == 135) {
                        this.locationInfoBuilder_.mergeFrom(value);
                    }
                    this.locationInfoBuilder_.setMessage(value);
                }
                this.opInfoCase_ = 135;
                return this;
            }

            public Builder clearLocationInfo() {
                if (this.locationInfoBuilder_ != null) {
                    if (this.opInfoCase_ == 135) {
                        this.opInfoCase_ = 0;
                        this.opInfo_ = null;
                    }
                    this.locationInfoBuilder_.clear();
                } else if (this.opInfoCase_ == 135) {
                    this.opInfoCase_ = 0;
                    this.opInfo_ = null;
                    onChanged();
                }
                return this;
            }

            public LocationInfoOuterClass.LocationInfo.Builder getLocationInfoBuilder() {
                return getLocationInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReqOrBuilder
            public LocationInfoOuterClass.LocationInfoOrBuilder getLocationInfoOrBuilder() {
                if (this.opInfoCase_ == 135 && this.locationInfoBuilder_ != null) {
                    return this.locationInfoBuilder_.getMessageOrBuilder();
                }
                if (this.opInfoCase_ == 135) {
                    return (LocationInfoOuterClass.LocationInfo) this.opInfo_;
                }
                return LocationInfoOuterClass.LocationInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<LocationInfoOuterClass.LocationInfo, LocationInfoOuterClass.LocationInfo.Builder, LocationInfoOuterClass.LocationInfoOrBuilder> getLocationInfoFieldBuilder() {
                if (this.locationInfoBuilder_ == null) {
                    if (this.opInfoCase_ != 135) {
                        this.opInfo_ = LocationInfoOuterClass.LocationInfo.getDefaultInstance();
                    }
                    this.locationInfoBuilder_ = new SingleFieldBuilderV3<>((LocationInfoOuterClass.LocationInfo) this.opInfo_, getParentForChildren(), isClean());
                    this.opInfo_ = null;
                }
                this.opInfoCase_ = 135;
                onChanged();
                return this.locationInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReqOrBuilder
            public boolean hasWidgetCreatorInfo() {
                return this.opInfoCase_ == 362;
            }

            @Override // emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReqOrBuilder
            public CreatorInfoOuterClass.CreatorInfo getWidgetCreatorInfo() {
                if (this.widgetCreatorInfoBuilder_ == null) {
                    if (this.opInfoCase_ == 362) {
                        return (CreatorInfoOuterClass.CreatorInfo) this.opInfo_;
                    }
                    return CreatorInfoOuterClass.CreatorInfo.getDefaultInstance();
                } else if (this.opInfoCase_ == 362) {
                    return this.widgetCreatorInfoBuilder_.getMessage();
                } else {
                    return CreatorInfoOuterClass.CreatorInfo.getDefaultInstance();
                }
            }

            public Builder setWidgetCreatorInfo(CreatorInfoOuterClass.CreatorInfo value) {
                if (this.widgetCreatorInfoBuilder_ != null) {
                    this.widgetCreatorInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.opInfo_ = value;
                    onChanged();
                }
                this.opInfoCase_ = 362;
                return this;
            }

            public Builder setWidgetCreatorInfo(CreatorInfoOuterClass.CreatorInfo.Builder builderForValue) {
                if (this.widgetCreatorInfoBuilder_ == null) {
                    this.opInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.widgetCreatorInfoBuilder_.setMessage(builderForValue.build());
                }
                this.opInfoCase_ = 362;
                return this;
            }

            public Builder mergeWidgetCreatorInfo(CreatorInfoOuterClass.CreatorInfo value) {
                if (this.widgetCreatorInfoBuilder_ == null) {
                    if (this.opInfoCase_ != 362 || this.opInfo_ == CreatorInfoOuterClass.CreatorInfo.getDefaultInstance()) {
                        this.opInfo_ = value;
                    } else {
                        this.opInfo_ = CreatorInfoOuterClass.CreatorInfo.newBuilder((CreatorInfoOuterClass.CreatorInfo) this.opInfo_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.opInfoCase_ == 362) {
                        this.widgetCreatorInfoBuilder_.mergeFrom(value);
                    }
                    this.widgetCreatorInfoBuilder_.setMessage(value);
                }
                this.opInfoCase_ = 362;
                return this;
            }

            public Builder clearWidgetCreatorInfo() {
                if (this.widgetCreatorInfoBuilder_ != null) {
                    if (this.opInfoCase_ == 362) {
                        this.opInfoCase_ = 0;
                        this.opInfo_ = null;
                    }
                    this.widgetCreatorInfoBuilder_.clear();
                } else if (this.opInfoCase_ == 362) {
                    this.opInfoCase_ = 0;
                    this.opInfo_ = null;
                    onChanged();
                }
                return this;
            }

            public CreatorInfoOuterClass.CreatorInfo.Builder getWidgetCreatorInfoBuilder() {
                return getWidgetCreatorInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.WidgetDoBagReqOuterClass.WidgetDoBagReqOrBuilder
            public CreatorInfoOuterClass.CreatorInfoOrBuilder getWidgetCreatorInfoOrBuilder() {
                if (this.opInfoCase_ == 362 && this.widgetCreatorInfoBuilder_ != null) {
                    return this.widgetCreatorInfoBuilder_.getMessageOrBuilder();
                }
                if (this.opInfoCase_ == 362) {
                    return (CreatorInfoOuterClass.CreatorInfo) this.opInfo_;
                }
                return CreatorInfoOuterClass.CreatorInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<CreatorInfoOuterClass.CreatorInfo, CreatorInfoOuterClass.CreatorInfo.Builder, CreatorInfoOuterClass.CreatorInfoOrBuilder> getWidgetCreatorInfoFieldBuilder() {
                if (this.widgetCreatorInfoBuilder_ == null) {
                    if (this.opInfoCase_ != 362) {
                        this.opInfo_ = CreatorInfoOuterClass.CreatorInfo.getDefaultInstance();
                    }
                    this.widgetCreatorInfoBuilder_ = new SingleFieldBuilderV3<>((CreatorInfoOuterClass.CreatorInfo) this.opInfo_, getParentForChildren(), isClean());
                    this.opInfo_ = null;
                }
                this.opInfoCase_ = 362;
                onChanged();
                return this.widgetCreatorInfoBuilder_;
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

        public static WidgetDoBagReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WidgetDoBagReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WidgetDoBagReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WidgetDoBagReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        LocationInfoOuterClass.getDescriptor();
        CreatorInfoOuterClass.getDescriptor();
    }
}
