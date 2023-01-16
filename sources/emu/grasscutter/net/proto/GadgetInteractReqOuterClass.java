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
import emu.grasscutter.net.proto.InterOpTypeOuterClass;
import emu.grasscutter.net.proto.ResinCostTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetInteractReqOuterClass.class */
public final class GadgetInteractReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017GadgetInteractReq.proto\u001a\u0011InterOpType.proto\u001a\u0013ResinCostType.proto\"¿\u0001\n\u0011GadgetInteractReq\u0012\u0011\n\tgadget_id\u0018\u0001 \u0001(\r\u0012'\n\u000fresin_cost_type\u0018\r \u0001(\u000e2\u000e.ResinCostType\u0012\u0018\n\u0010gadget_entity_id\u0018\b \u0001(\r\u0012\u001d\n\u0007op_type\u0018\u0002 \u0001(\u000e2\f.InterOpType\u0012\u0016\n\u000eui_interact_id\u0018\u000b \u0001(\r\u0012\u001d\n\u0015is_use_condense_resin\u0018\u0006 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{InterOpTypeOuterClass.getDescriptor(), ResinCostTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GadgetInteractReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GadgetInteractReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GadgetInteractReq_descriptor, new String[]{"GadgetId", "ResinCostType", "GadgetEntityId", "OpType", "UiInteractId", "IsUseCondenseResin"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetInteractReqOuterClass$GadgetInteractReqOrBuilder.class */
    public interface GadgetInteractReqOrBuilder extends MessageOrBuilder {
        int getGadgetId();

        int getResinCostTypeValue();

        ResinCostTypeOuterClass.ResinCostType getResinCostType();

        int getGadgetEntityId();

        int getOpTypeValue();

        InterOpTypeOuterClass.InterOpType getOpType();

        int getUiInteractId();

        boolean getIsUseCondenseResin();
    }

    private GadgetInteractReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetInteractReqOuterClass$GadgetInteractReq.class */
    public static final class GadgetInteractReq extends GeneratedMessageV3 implements GadgetInteractReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GADGET_ID_FIELD_NUMBER = 1;
        private int gadgetId_;
        public static final int RESIN_COST_TYPE_FIELD_NUMBER = 13;
        private int resinCostType_;
        public static final int GADGET_ENTITY_ID_FIELD_NUMBER = 8;
        private int gadgetEntityId_;
        public static final int OP_TYPE_FIELD_NUMBER = 2;
        private int opType_;
        public static final int UI_INTERACT_ID_FIELD_NUMBER = 11;
        private int uiInteractId_;
        public static final int IS_USE_CONDENSE_RESIN_FIELD_NUMBER = 6;
        private boolean isUseCondenseResin_;
        private byte memoizedIsInitialized;
        private static final GadgetInteractReq DEFAULT_INSTANCE = new GadgetInteractReq();
        private static final Parser<GadgetInteractReq> PARSER = new AbstractParser<GadgetInteractReq>() { // from class: emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReq.1
            @Override // com.google.protobuf.Parser
            public GadgetInteractReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GadgetInteractReq(input, extensionRegistry);
            }
        };

        private GadgetInteractReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GadgetInteractReq() {
            this.memoizedIsInitialized = -1;
            this.resinCostType_ = 0;
            this.opType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GadgetInteractReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GadgetInteractReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.gadgetId_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.opType_ = input.readEnum();
                                    break;
                                case 48:
                                    this.isUseCondenseResin_ = input.readBool();
                                    break;
                                case 64:
                                    this.gadgetEntityId_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.uiInteractId_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.resinCostType_ = input.readEnum();
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
            return GadgetInteractReqOuterClass.internal_static_GadgetInteractReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GadgetInteractReqOuterClass.internal_static_GadgetInteractReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GadgetInteractReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReqOrBuilder
        public int getGadgetId() {
            return this.gadgetId_;
        }

        @Override // emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReqOrBuilder
        public int getResinCostTypeValue() {
            return this.resinCostType_;
        }

        @Override // emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReqOrBuilder
        public ResinCostTypeOuterClass.ResinCostType getResinCostType() {
            ResinCostTypeOuterClass.ResinCostType result = ResinCostTypeOuterClass.ResinCostType.valueOf(this.resinCostType_);
            return result == null ? ResinCostTypeOuterClass.ResinCostType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReqOrBuilder
        public int getGadgetEntityId() {
            return this.gadgetEntityId_;
        }

        @Override // emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReqOrBuilder
        public int getOpTypeValue() {
            return this.opType_;
        }

        @Override // emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReqOrBuilder
        public InterOpTypeOuterClass.InterOpType getOpType() {
            InterOpTypeOuterClass.InterOpType result = InterOpTypeOuterClass.InterOpType.valueOf(this.opType_);
            return result == null ? InterOpTypeOuterClass.InterOpType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReqOrBuilder
        public int getUiInteractId() {
            return this.uiInteractId_;
        }

        @Override // emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReqOrBuilder
        public boolean getIsUseCondenseResin() {
            return this.isUseCondenseResin_;
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
            if (this.gadgetId_ != 0) {
                output.writeUInt32(1, this.gadgetId_);
            }
            if (this.opType_ != InterOpTypeOuterClass.InterOpType.INTER_OP_TYPE_FINISH.getNumber()) {
                output.writeEnum(2, this.opType_);
            }
            if (this.isUseCondenseResin_) {
                output.writeBool(6, this.isUseCondenseResin_);
            }
            if (this.gadgetEntityId_ != 0) {
                output.writeUInt32(8, this.gadgetEntityId_);
            }
            if (this.uiInteractId_ != 0) {
                output.writeUInt32(11, this.uiInteractId_);
            }
            if (this.resinCostType_ != ResinCostTypeOuterClass.ResinCostType.RESIN_COST_TYPE_NONE.getNumber()) {
                output.writeEnum(13, this.resinCostType_);
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
            if (this.gadgetId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.gadgetId_);
            }
            if (this.opType_ != InterOpTypeOuterClass.InterOpType.INTER_OP_TYPE_FINISH.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(2, this.opType_);
            }
            if (this.isUseCondenseResin_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isUseCondenseResin_);
            }
            if (this.gadgetEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.gadgetEntityId_);
            }
            if (this.uiInteractId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.uiInteractId_);
            }
            if (this.resinCostType_ != ResinCostTypeOuterClass.ResinCostType.RESIN_COST_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(13, this.resinCostType_);
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
            if (!(obj instanceof GadgetInteractReq)) {
                return equals(obj);
            }
            GadgetInteractReq other = (GadgetInteractReq) obj;
            return getGadgetId() == other.getGadgetId() && this.resinCostType_ == other.resinCostType_ && getGadgetEntityId() == other.getGadgetEntityId() && this.opType_ == other.opType_ && getUiInteractId() == other.getUiInteractId() && getIsUseCondenseResin() == other.getIsUseCondenseResin() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getGadgetId())) + 13)) + this.resinCostType_)) + 8)) + getGadgetEntityId())) + 2)) + this.opType_)) + 11)) + getUiInteractId())) + 6)) + Internal.hashBoolean(getIsUseCondenseResin()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static GadgetInteractReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetInteractReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetInteractReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetInteractReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetInteractReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetInteractReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetInteractReq parseFrom(InputStream input) throws IOException {
            return (GadgetInteractReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GadgetInteractReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetInteractReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GadgetInteractReq parseDelimitedFrom(InputStream input) throws IOException {
            return (GadgetInteractReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GadgetInteractReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetInteractReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GadgetInteractReq parseFrom(CodedInputStream input) throws IOException {
            return (GadgetInteractReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GadgetInteractReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetInteractReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GadgetInteractReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetInteractReqOuterClass$GadgetInteractReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GadgetInteractReqOrBuilder {
            private int gadgetId_;
            private int gadgetEntityId_;
            private int uiInteractId_;
            private boolean isUseCondenseResin_;
            private int resinCostType_ = 0;
            private int opType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return GadgetInteractReqOuterClass.internal_static_GadgetInteractReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GadgetInteractReqOuterClass.internal_static_GadgetInteractReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GadgetInteractReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GadgetInteractReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.gadgetId_ = 0;
                this.resinCostType_ = 0;
                this.gadgetEntityId_ = 0;
                this.opType_ = 0;
                this.uiInteractId_ = 0;
                this.isUseCondenseResin_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GadgetInteractReqOuterClass.internal_static_GadgetInteractReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GadgetInteractReq getDefaultInstanceForType() {
                return GadgetInteractReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GadgetInteractReq build() {
                GadgetInteractReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GadgetInteractReq buildPartial() {
                GadgetInteractReq result = new GadgetInteractReq(this);
                result.gadgetId_ = this.gadgetId_;
                result.resinCostType_ = this.resinCostType_;
                result.gadgetEntityId_ = this.gadgetEntityId_;
                result.opType_ = this.opType_;
                result.uiInteractId_ = this.uiInteractId_;
                result.isUseCondenseResin_ = this.isUseCondenseResin_;
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
                if (other instanceof GadgetInteractReq) {
                    return mergeFrom((GadgetInteractReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GadgetInteractReq other) {
                if (other == GadgetInteractReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getGadgetId() != 0) {
                    setGadgetId(other.getGadgetId());
                }
                if (other.resinCostType_ != 0) {
                    setResinCostTypeValue(other.getResinCostTypeValue());
                }
                if (other.getGadgetEntityId() != 0) {
                    setGadgetEntityId(other.getGadgetEntityId());
                }
                if (other.opType_ != 0) {
                    setOpTypeValue(other.getOpTypeValue());
                }
                if (other.getUiInteractId() != 0) {
                    setUiInteractId(other.getUiInteractId());
                }
                if (other.getIsUseCondenseResin()) {
                    setIsUseCondenseResin(other.getIsUseCondenseResin());
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
                GadgetInteractReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = GadgetInteractReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GadgetInteractReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReqOrBuilder
            public int getGadgetId() {
                return this.gadgetId_;
            }

            public Builder setGadgetId(int value) {
                this.gadgetId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetId() {
                this.gadgetId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReqOrBuilder
            public int getResinCostTypeValue() {
                return this.resinCostType_;
            }

            public Builder setResinCostTypeValue(int value) {
                this.resinCostType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReqOrBuilder
            public ResinCostTypeOuterClass.ResinCostType getResinCostType() {
                ResinCostTypeOuterClass.ResinCostType result = ResinCostTypeOuterClass.ResinCostType.valueOf(this.resinCostType_);
                return result == null ? ResinCostTypeOuterClass.ResinCostType.UNRECOGNIZED : result;
            }

            public Builder setResinCostType(ResinCostTypeOuterClass.ResinCostType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.resinCostType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearResinCostType() {
                this.resinCostType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReqOrBuilder
            public int getGadgetEntityId() {
                return this.gadgetEntityId_;
            }

            public Builder setGadgetEntityId(int value) {
                this.gadgetEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetEntityId() {
                this.gadgetEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReqOrBuilder
            public int getOpTypeValue() {
                return this.opType_;
            }

            public Builder setOpTypeValue(int value) {
                this.opType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReqOrBuilder
            public InterOpTypeOuterClass.InterOpType getOpType() {
                InterOpTypeOuterClass.InterOpType result = InterOpTypeOuterClass.InterOpType.valueOf(this.opType_);
                return result == null ? InterOpTypeOuterClass.InterOpType.UNRECOGNIZED : result;
            }

            public Builder setOpType(InterOpTypeOuterClass.InterOpType value) {
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

            @Override // emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReqOrBuilder
            public int getUiInteractId() {
                return this.uiInteractId_;
            }

            public Builder setUiInteractId(int value) {
                this.uiInteractId_ = value;
                onChanged();
                return this;
            }

            public Builder clearUiInteractId() {
                this.uiInteractId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReqOrBuilder
            public boolean getIsUseCondenseResin() {
                return this.isUseCondenseResin_;
            }

            public Builder setIsUseCondenseResin(boolean value) {
                this.isUseCondenseResin_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsUseCondenseResin() {
                this.isUseCondenseResin_ = false;
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

        public static GadgetInteractReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GadgetInteractReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GadgetInteractReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GadgetInteractReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        InterOpTypeOuterClass.getDescriptor();
        ResinCostTypeOuterClass.getDescriptor();
    }
}
