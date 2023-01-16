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
import emu.grasscutter.net.proto.ClientCollectorDataOuterClass;
import emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass;
import emu.grasscutter.net.proto.SkyCrystalDetectorQuickUseResultOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuickUseWidgetRspOuterClass.class */
public final class QuickUseWidgetRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017QuickUseWidgetRsp.proto\u001a\u0019ClientCollectorData.proto\u001a#OneoffGatherPointDetectorData.proto\u001a&SkyCrystalDetectorQuickUseResult.proto\"\u0002\n\u0011QuickUseWidgetRsp\u0012\u0013\n\u000bmaterial_id\u0018\u000b \u0001(\r\u0012\u000f\n\u0007retcode\u0018\f \u0001(\u0005\u00127\n\rdetector_data\u0018\u000e \u0001(\u000b2\u001e.OneoffGatherPointDetectorDataH��\u00125\n\u0015client_collector_data\u0018\n \u0001(\u000b2\u0014.ClientCollectorDataH��\u0012T\n%sky_crystal_detector_quick_use_result\u0018¢Â\n \u0001(\u000b2!.SkyCrystalDetectorQuickUseResultH��B\u0007\n\u0005paramB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ClientCollectorDataOuterClass.getDescriptor(), OneoffGatherPointDetectorDataOuterClass.getDescriptor(), SkyCrystalDetectorQuickUseResultOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_QuickUseWidgetRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QuickUseWidgetRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QuickUseWidgetRsp_descriptor, new String[]{"MaterialId", "Retcode", "DetectorData", "ClientCollectorData", "SkyCrystalDetectorQuickUseResult", "Param"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuickUseWidgetRspOuterClass$QuickUseWidgetRspOrBuilder.class */
    public interface QuickUseWidgetRspOrBuilder extends MessageOrBuilder {
        int getMaterialId();

        int getRetcode();

        boolean hasDetectorData();

        OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData getDetectorData();

        OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder getDetectorDataOrBuilder();

        boolean hasClientCollectorData();

        ClientCollectorDataOuterClass.ClientCollectorData getClientCollectorData();

        ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder getClientCollectorDataOrBuilder();

        boolean hasSkyCrystalDetectorQuickUseResult();

        SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult getSkyCrystalDetectorQuickUseResult();

        SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResultOrBuilder getSkyCrystalDetectorQuickUseResultOrBuilder();

        QuickUseWidgetRsp.ParamCase getParamCase();
    }

    private QuickUseWidgetRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuickUseWidgetRspOuterClass$QuickUseWidgetRsp.class */
    public static final class QuickUseWidgetRsp extends GeneratedMessageV3 implements QuickUseWidgetRspOrBuilder {
        private static final long serialVersionUID = 0;
        private int paramCase_;
        private Object param_;
        public static final int MATERIAL_ID_FIELD_NUMBER = 11;
        private int materialId_;
        public static final int RETCODE_FIELD_NUMBER = 12;
        private int retcode_;
        public static final int DETECTOR_DATA_FIELD_NUMBER = 14;
        public static final int CLIENT_COLLECTOR_DATA_FIELD_NUMBER = 10;
        public static final int SKY_CRYSTAL_DETECTOR_QUICK_USE_RESULT_FIELD_NUMBER = 172322;
        private byte memoizedIsInitialized;
        private static final QuickUseWidgetRsp DEFAULT_INSTANCE = new QuickUseWidgetRsp();
        private static final Parser<QuickUseWidgetRsp> PARSER = new AbstractParser<QuickUseWidgetRsp>() { // from class: emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRsp.1
            @Override // com.google.protobuf.Parser
            public QuickUseWidgetRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QuickUseWidgetRsp(input, extensionRegistry);
            }
        };

        private QuickUseWidgetRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.paramCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private QuickUseWidgetRsp() {
            this.paramCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QuickUseWidgetRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuickUseWidgetRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 82:
                                ClientCollectorDataOuterClass.ClientCollectorData.Builder subBuilder = this.paramCase_ == 10 ? ((ClientCollectorDataOuterClass.ClientCollectorData) this.param_).toBuilder() : null;
                                this.param_ = input.readMessage(ClientCollectorDataOuterClass.ClientCollectorData.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((ClientCollectorDataOuterClass.ClientCollectorData) this.param_);
                                    this.param_ = subBuilder.buildPartial();
                                }
                                this.paramCase_ = 10;
                                break;
                            case 88:
                                this.materialId_ = input.readUInt32();
                                break;
                            case 96:
                                this.retcode_ = input.readInt32();
                                break;
                            case 114:
                                OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.Builder subBuilder2 = this.paramCase_ == 14 ? ((OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData) this.param_).toBuilder() : null;
                                this.param_ = input.readMessage(OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData) this.param_);
                                    this.param_ = subBuilder2.buildPartial();
                                }
                                this.paramCase_ = 14;
                                break;
                            case 1378578:
                                SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult.Builder subBuilder3 = this.paramCase_ == 172322 ? ((SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult) this.param_).toBuilder() : null;
                                this.param_ = input.readMessage(SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult.parser(), extensionRegistry);
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult) this.param_);
                                    this.param_ = subBuilder3.buildPartial();
                                }
                                this.paramCase_ = SKY_CRYSTAL_DETECTOR_QUICK_USE_RESULT_FIELD_NUMBER;
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
            return QuickUseWidgetRspOuterClass.internal_static_QuickUseWidgetRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuickUseWidgetRspOuterClass.internal_static_QuickUseWidgetRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(QuickUseWidgetRsp.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuickUseWidgetRspOuterClass$QuickUseWidgetRsp$ParamCase.class */
        public enum ParamCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            DETECTOR_DATA(14),
            CLIENT_COLLECTOR_DATA(10),
            SKY_CRYSTAL_DETECTOR_QUICK_USE_RESULT(QuickUseWidgetRsp.SKY_CRYSTAL_DETECTOR_QUICK_USE_RESULT_FIELD_NUMBER),
            PARAM_NOT_SET(0);
            
            private final int value;

            ParamCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static ParamCase valueOf(int value) {
                return forNumber(value);
            }

            public static ParamCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return PARAM_NOT_SET;
                    case 10:
                        return CLIENT_COLLECTOR_DATA;
                    case 14:
                        return DETECTOR_DATA;
                    case QuickUseWidgetRsp.SKY_CRYSTAL_DETECTOR_QUICK_USE_RESULT_FIELD_NUMBER /* 172322 */:
                        return SKY_CRYSTAL_DETECTOR_QUICK_USE_RESULT;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
        public ParamCase getParamCase() {
            return ParamCase.forNumber(this.paramCase_);
        }

        @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
        public int getMaterialId() {
            return this.materialId_;
        }

        @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
        public boolean hasDetectorData() {
            return this.paramCase_ == 14;
        }

        @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
        public OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData getDetectorData() {
            if (this.paramCase_ == 14) {
                return (OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData) this.param_;
            }
            return OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
        public OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder getDetectorDataOrBuilder() {
            if (this.paramCase_ == 14) {
                return (OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData) this.param_;
            }
            return OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
        public boolean hasClientCollectorData() {
            return this.paramCase_ == 10;
        }

        @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
        public ClientCollectorDataOuterClass.ClientCollectorData getClientCollectorData() {
            if (this.paramCase_ == 10) {
                return (ClientCollectorDataOuterClass.ClientCollectorData) this.param_;
            }
            return ClientCollectorDataOuterClass.ClientCollectorData.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
        public ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder getClientCollectorDataOrBuilder() {
            if (this.paramCase_ == 10) {
                return (ClientCollectorDataOuterClass.ClientCollectorData) this.param_;
            }
            return ClientCollectorDataOuterClass.ClientCollectorData.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
        public boolean hasSkyCrystalDetectorQuickUseResult() {
            return this.paramCase_ == 172322;
        }

        @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
        public SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult getSkyCrystalDetectorQuickUseResult() {
            if (this.paramCase_ == 172322) {
                return (SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult) this.param_;
            }
            return SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
        public SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResultOrBuilder getSkyCrystalDetectorQuickUseResultOrBuilder() {
            if (this.paramCase_ == 172322) {
                return (SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult) this.param_;
            }
            return SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult.getDefaultInstance();
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
            if (this.paramCase_ == 10) {
                output.writeMessage(10, (ClientCollectorDataOuterClass.ClientCollectorData) this.param_);
            }
            if (this.materialId_ != 0) {
                output.writeUInt32(11, this.materialId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(12, this.retcode_);
            }
            if (this.paramCase_ == 14) {
                output.writeMessage(14, (OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData) this.param_);
            }
            if (this.paramCase_ == 172322) {
                output.writeMessage(SKY_CRYSTAL_DETECTOR_QUICK_USE_RESULT_FIELD_NUMBER, (SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult) this.param_);
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
            if (this.paramCase_ == 10) {
                size2 = 0 + CodedOutputStream.computeMessageSize(10, (ClientCollectorDataOuterClass.ClientCollectorData) this.param_);
            }
            if (this.materialId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.materialId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(12, this.retcode_);
            }
            if (this.paramCase_ == 14) {
                size2 += CodedOutputStream.computeMessageSize(14, (OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData) this.param_);
            }
            if (this.paramCase_ == 172322) {
                size2 += CodedOutputStream.computeMessageSize(SKY_CRYSTAL_DETECTOR_QUICK_USE_RESULT_FIELD_NUMBER, (SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult) this.param_);
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
            if (!(obj instanceof QuickUseWidgetRsp)) {
                return equals(obj);
            }
            QuickUseWidgetRsp other = (QuickUseWidgetRsp) obj;
            if (getMaterialId() != other.getMaterialId() || getRetcode() != other.getRetcode() || !getParamCase().equals(other.getParamCase())) {
                return false;
            }
            switch (this.paramCase_) {
                case 10:
                    if (!getClientCollectorData().equals(other.getClientCollectorData())) {
                        return false;
                    }
                    break;
                case 14:
                    if (!getDetectorData().equals(other.getDetectorData())) {
                        return false;
                    }
                    break;
                case SKY_CRYSTAL_DETECTOR_QUICK_USE_RESULT_FIELD_NUMBER /* 172322 */:
                    if (!getSkyCrystalDetectorQuickUseResult().equals(other.getSkyCrystalDetectorQuickUseResult())) {
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
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getMaterialId())) + 12)) + getRetcode();
            switch (this.paramCase_) {
                case 10:
                    hash = (53 * ((37 * hash) + 10)) + getClientCollectorData().hashCode();
                    break;
                case 14:
                    hash = (53 * ((37 * hash) + 14)) + getDetectorData().hashCode();
                    break;
                case SKY_CRYSTAL_DETECTOR_QUICK_USE_RESULT_FIELD_NUMBER /* 172322 */:
                    hash = (53 * ((37 * hash) + SKY_CRYSTAL_DETECTOR_QUICK_USE_RESULT_FIELD_NUMBER)) + getSkyCrystalDetectorQuickUseResult().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static QuickUseWidgetRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuickUseWidgetRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuickUseWidgetRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuickUseWidgetRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuickUseWidgetRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuickUseWidgetRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuickUseWidgetRsp parseFrom(InputStream input) throws IOException {
            return (QuickUseWidgetRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuickUseWidgetRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuickUseWidgetRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuickUseWidgetRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (QuickUseWidgetRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QuickUseWidgetRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuickUseWidgetRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuickUseWidgetRsp parseFrom(CodedInputStream input) throws IOException {
            return (QuickUseWidgetRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuickUseWidgetRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuickUseWidgetRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QuickUseWidgetRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuickUseWidgetRspOuterClass$QuickUseWidgetRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuickUseWidgetRspOrBuilder {
            private int paramCase_ = 0;
            private Object param_;
            private int materialId_;
            private int retcode_;
            private SingleFieldBuilderV3<OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData, OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.Builder, OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder> detectorDataBuilder_;
            private SingleFieldBuilderV3<ClientCollectorDataOuterClass.ClientCollectorData, ClientCollectorDataOuterClass.ClientCollectorData.Builder, ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder> clientCollectorDataBuilder_;
            private SingleFieldBuilderV3<SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult, SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult.Builder, SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResultOrBuilder> skyCrystalDetectorQuickUseResultBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return QuickUseWidgetRspOuterClass.internal_static_QuickUseWidgetRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QuickUseWidgetRspOuterClass.internal_static_QuickUseWidgetRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(QuickUseWidgetRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QuickUseWidgetRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.materialId_ = 0;
                this.retcode_ = 0;
                this.paramCase_ = 0;
                this.param_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QuickUseWidgetRspOuterClass.internal_static_QuickUseWidgetRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QuickUseWidgetRsp getDefaultInstanceForType() {
                return QuickUseWidgetRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuickUseWidgetRsp build() {
                QuickUseWidgetRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuickUseWidgetRsp buildPartial() {
                QuickUseWidgetRsp result = new QuickUseWidgetRsp(this);
                result.materialId_ = this.materialId_;
                result.retcode_ = this.retcode_;
                if (this.paramCase_ == 14) {
                    if (this.detectorDataBuilder_ == null) {
                        result.param_ = this.param_;
                    } else {
                        result.param_ = this.detectorDataBuilder_.build();
                    }
                }
                if (this.paramCase_ == 10) {
                    if (this.clientCollectorDataBuilder_ == null) {
                        result.param_ = this.param_;
                    } else {
                        result.param_ = this.clientCollectorDataBuilder_.build();
                    }
                }
                if (this.paramCase_ == 172322) {
                    if (this.skyCrystalDetectorQuickUseResultBuilder_ == null) {
                        result.param_ = this.param_;
                    } else {
                        result.param_ = this.skyCrystalDetectorQuickUseResultBuilder_.build();
                    }
                }
                result.paramCase_ = this.paramCase_;
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
                if (other instanceof QuickUseWidgetRsp) {
                    return mergeFrom((QuickUseWidgetRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QuickUseWidgetRsp other) {
                if (other == QuickUseWidgetRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getMaterialId() != 0) {
                    setMaterialId(other.getMaterialId());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                switch (other.getParamCase()) {
                    case DETECTOR_DATA:
                        mergeDetectorData(other.getDetectorData());
                        break;
                    case CLIENT_COLLECTOR_DATA:
                        mergeClientCollectorData(other.getClientCollectorData());
                        break;
                    case SKY_CRYSTAL_DETECTOR_QUICK_USE_RESULT:
                        mergeSkyCrystalDetectorQuickUseResult(other.getSkyCrystalDetectorQuickUseResult());
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
                QuickUseWidgetRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = QuickUseWidgetRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QuickUseWidgetRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
            public ParamCase getParamCase() {
                return ParamCase.forNumber(this.paramCase_);
            }

            public Builder clearParam() {
                this.paramCase_ = 0;
                this.param_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
            public boolean hasDetectorData() {
                return this.paramCase_ == 14;
            }

            @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
            public OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData getDetectorData() {
                if (this.detectorDataBuilder_ == null) {
                    if (this.paramCase_ == 14) {
                        return (OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData) this.param_;
                    }
                    return OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.getDefaultInstance();
                } else if (this.paramCase_ == 14) {
                    return this.detectorDataBuilder_.getMessage();
                } else {
                    return OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.getDefaultInstance();
                }
            }

            public Builder setDetectorData(OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData value) {
                if (this.detectorDataBuilder_ != null) {
                    this.detectorDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.param_ = value;
                    onChanged();
                }
                this.paramCase_ = 14;
                return this;
            }

            public Builder setDetectorData(OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.Builder builderForValue) {
                if (this.detectorDataBuilder_ == null) {
                    this.param_ = builderForValue.build();
                    onChanged();
                } else {
                    this.detectorDataBuilder_.setMessage(builderForValue.build());
                }
                this.paramCase_ = 14;
                return this;
            }

            public Builder mergeDetectorData(OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData value) {
                if (this.detectorDataBuilder_ == null) {
                    if (this.paramCase_ != 14 || this.param_ == OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.getDefaultInstance()) {
                        this.param_ = value;
                    } else {
                        this.param_ = OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.newBuilder((OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData) this.param_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.paramCase_ == 14) {
                        this.detectorDataBuilder_.mergeFrom(value);
                    }
                    this.detectorDataBuilder_.setMessage(value);
                }
                this.paramCase_ = 14;
                return this;
            }

            public Builder clearDetectorData() {
                if (this.detectorDataBuilder_ != null) {
                    if (this.paramCase_ == 14) {
                        this.paramCase_ = 0;
                        this.param_ = null;
                    }
                    this.detectorDataBuilder_.clear();
                } else if (this.paramCase_ == 14) {
                    this.paramCase_ = 0;
                    this.param_ = null;
                    onChanged();
                }
                return this;
            }

            public OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.Builder getDetectorDataBuilder() {
                return getDetectorDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
            public OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder getDetectorDataOrBuilder() {
                if (this.paramCase_ == 14 && this.detectorDataBuilder_ != null) {
                    return this.detectorDataBuilder_.getMessageOrBuilder();
                }
                if (this.paramCase_ == 14) {
                    return (OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData) this.param_;
                }
                return OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.getDefaultInstance();
            }

            private SingleFieldBuilderV3<OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData, OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.Builder, OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder> getDetectorDataFieldBuilder() {
                if (this.detectorDataBuilder_ == null) {
                    if (this.paramCase_ != 14) {
                        this.param_ = OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.getDefaultInstance();
                    }
                    this.detectorDataBuilder_ = new SingleFieldBuilderV3<>((OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData) this.param_, getParentForChildren(), isClean());
                    this.param_ = null;
                }
                this.paramCase_ = 14;
                onChanged();
                return this.detectorDataBuilder_;
            }

            @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
            public boolean hasClientCollectorData() {
                return this.paramCase_ == 10;
            }

            @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
            public ClientCollectorDataOuterClass.ClientCollectorData getClientCollectorData() {
                if (this.clientCollectorDataBuilder_ == null) {
                    if (this.paramCase_ == 10) {
                        return (ClientCollectorDataOuterClass.ClientCollectorData) this.param_;
                    }
                    return ClientCollectorDataOuterClass.ClientCollectorData.getDefaultInstance();
                } else if (this.paramCase_ == 10) {
                    return this.clientCollectorDataBuilder_.getMessage();
                } else {
                    return ClientCollectorDataOuterClass.ClientCollectorData.getDefaultInstance();
                }
            }

            public Builder setClientCollectorData(ClientCollectorDataOuterClass.ClientCollectorData value) {
                if (this.clientCollectorDataBuilder_ != null) {
                    this.clientCollectorDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.param_ = value;
                    onChanged();
                }
                this.paramCase_ = 10;
                return this;
            }

            public Builder setClientCollectorData(ClientCollectorDataOuterClass.ClientCollectorData.Builder builderForValue) {
                if (this.clientCollectorDataBuilder_ == null) {
                    this.param_ = builderForValue.build();
                    onChanged();
                } else {
                    this.clientCollectorDataBuilder_.setMessage(builderForValue.build());
                }
                this.paramCase_ = 10;
                return this;
            }

            public Builder mergeClientCollectorData(ClientCollectorDataOuterClass.ClientCollectorData value) {
                if (this.clientCollectorDataBuilder_ == null) {
                    if (this.paramCase_ != 10 || this.param_ == ClientCollectorDataOuterClass.ClientCollectorData.getDefaultInstance()) {
                        this.param_ = value;
                    } else {
                        this.param_ = ClientCollectorDataOuterClass.ClientCollectorData.newBuilder((ClientCollectorDataOuterClass.ClientCollectorData) this.param_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.paramCase_ == 10) {
                        this.clientCollectorDataBuilder_.mergeFrom(value);
                    }
                    this.clientCollectorDataBuilder_.setMessage(value);
                }
                this.paramCase_ = 10;
                return this;
            }

            public Builder clearClientCollectorData() {
                if (this.clientCollectorDataBuilder_ != null) {
                    if (this.paramCase_ == 10) {
                        this.paramCase_ = 0;
                        this.param_ = null;
                    }
                    this.clientCollectorDataBuilder_.clear();
                } else if (this.paramCase_ == 10) {
                    this.paramCase_ = 0;
                    this.param_ = null;
                    onChanged();
                }
                return this;
            }

            public ClientCollectorDataOuterClass.ClientCollectorData.Builder getClientCollectorDataBuilder() {
                return getClientCollectorDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
            public ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder getClientCollectorDataOrBuilder() {
                if (this.paramCase_ == 10 && this.clientCollectorDataBuilder_ != null) {
                    return this.clientCollectorDataBuilder_.getMessageOrBuilder();
                }
                if (this.paramCase_ == 10) {
                    return (ClientCollectorDataOuterClass.ClientCollectorData) this.param_;
                }
                return ClientCollectorDataOuterClass.ClientCollectorData.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ClientCollectorDataOuterClass.ClientCollectorData, ClientCollectorDataOuterClass.ClientCollectorData.Builder, ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder> getClientCollectorDataFieldBuilder() {
                if (this.clientCollectorDataBuilder_ == null) {
                    if (this.paramCase_ != 10) {
                        this.param_ = ClientCollectorDataOuterClass.ClientCollectorData.getDefaultInstance();
                    }
                    this.clientCollectorDataBuilder_ = new SingleFieldBuilderV3<>((ClientCollectorDataOuterClass.ClientCollectorData) this.param_, getParentForChildren(), isClean());
                    this.param_ = null;
                }
                this.paramCase_ = 10;
                onChanged();
                return this.clientCollectorDataBuilder_;
            }

            @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
            public boolean hasSkyCrystalDetectorQuickUseResult() {
                return this.paramCase_ == 172322;
            }

            @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
            public SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult getSkyCrystalDetectorQuickUseResult() {
                if (this.skyCrystalDetectorQuickUseResultBuilder_ == null) {
                    if (this.paramCase_ == 172322) {
                        return (SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult) this.param_;
                    }
                    return SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult.getDefaultInstance();
                } else if (this.paramCase_ == 172322) {
                    return this.skyCrystalDetectorQuickUseResultBuilder_.getMessage();
                } else {
                    return SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult.getDefaultInstance();
                }
            }

            public Builder setSkyCrystalDetectorQuickUseResult(SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult value) {
                if (this.skyCrystalDetectorQuickUseResultBuilder_ != null) {
                    this.skyCrystalDetectorQuickUseResultBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.param_ = value;
                    onChanged();
                }
                this.paramCase_ = QuickUseWidgetRsp.SKY_CRYSTAL_DETECTOR_QUICK_USE_RESULT_FIELD_NUMBER;
                return this;
            }

            public Builder setSkyCrystalDetectorQuickUseResult(SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult.Builder builderForValue) {
                if (this.skyCrystalDetectorQuickUseResultBuilder_ == null) {
                    this.param_ = builderForValue.build();
                    onChanged();
                } else {
                    this.skyCrystalDetectorQuickUseResultBuilder_.setMessage(builderForValue.build());
                }
                this.paramCase_ = QuickUseWidgetRsp.SKY_CRYSTAL_DETECTOR_QUICK_USE_RESULT_FIELD_NUMBER;
                return this;
            }

            public Builder mergeSkyCrystalDetectorQuickUseResult(SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult value) {
                if (this.skyCrystalDetectorQuickUseResultBuilder_ == null) {
                    if (this.paramCase_ != 172322 || this.param_ == SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult.getDefaultInstance()) {
                        this.param_ = value;
                    } else {
                        this.param_ = SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult.newBuilder((SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult) this.param_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.paramCase_ == 172322) {
                        this.skyCrystalDetectorQuickUseResultBuilder_.mergeFrom(value);
                    }
                    this.skyCrystalDetectorQuickUseResultBuilder_.setMessage(value);
                }
                this.paramCase_ = QuickUseWidgetRsp.SKY_CRYSTAL_DETECTOR_QUICK_USE_RESULT_FIELD_NUMBER;
                return this;
            }

            public Builder clearSkyCrystalDetectorQuickUseResult() {
                if (this.skyCrystalDetectorQuickUseResultBuilder_ != null) {
                    if (this.paramCase_ == 172322) {
                        this.paramCase_ = 0;
                        this.param_ = null;
                    }
                    this.skyCrystalDetectorQuickUseResultBuilder_.clear();
                } else if (this.paramCase_ == 172322) {
                    this.paramCase_ = 0;
                    this.param_ = null;
                    onChanged();
                }
                return this;
            }

            public SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult.Builder getSkyCrystalDetectorQuickUseResultBuilder() {
                return getSkyCrystalDetectorQuickUseResultFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass.QuickUseWidgetRspOrBuilder
            public SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResultOrBuilder getSkyCrystalDetectorQuickUseResultOrBuilder() {
                if (this.paramCase_ == 172322 && this.skyCrystalDetectorQuickUseResultBuilder_ != null) {
                    return this.skyCrystalDetectorQuickUseResultBuilder_.getMessageOrBuilder();
                }
                if (this.paramCase_ == 172322) {
                    return (SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult) this.param_;
                }
                return SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult, SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult.Builder, SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResultOrBuilder> getSkyCrystalDetectorQuickUseResultFieldBuilder() {
                if (this.skyCrystalDetectorQuickUseResultBuilder_ == null) {
                    if (this.paramCase_ != 172322) {
                        this.param_ = SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult.getDefaultInstance();
                    }
                    this.skyCrystalDetectorQuickUseResultBuilder_ = new SingleFieldBuilderV3<>((SkyCrystalDetectorQuickUseResultOuterClass.SkyCrystalDetectorQuickUseResult) this.param_, getParentForChildren(), isClean());
                    this.param_ = null;
                }
                this.paramCase_ = QuickUseWidgetRsp.SKY_CRYSTAL_DETECTOR_QUICK_USE_RESULT_FIELD_NUMBER;
                onChanged();
                return this.skyCrystalDetectorQuickUseResultBuilder_;
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

        public static QuickUseWidgetRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QuickUseWidgetRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QuickUseWidgetRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuickUseWidgetRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ClientCollectorDataOuterClass.getDescriptor();
        OneoffGatherPointDetectorDataOuterClass.getDescriptor();
        SkyCrystalDetectorQuickUseResultOuterClass.getDescriptor();
    }
}
