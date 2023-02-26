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
import emu.grasscutter.net.proto.InterOpTypeOuterClass;
import emu.grasscutter.net.proto.InteractTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetInteractRspOuterClass.class */
public final class GadgetInteractRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017GadgetInteractRsp.proto\u001a\u0012InteractType.proto\u001a\u0011InterOpType.proto\"\u0001\n\u0011GadgetInteractRsp\u0012#\n\finteractType\u0018\u0003 \u0001(\u000e2\r.InteractType\u0012\u000f\n\u0007retcode\u0018\f \u0001(\u0005\u0012\u0010\n\bgadgetId\u0018\n \u0001(\r\u0012\u0016\n\u000egadgetEntityId\u0018\u0002 \u0001(\r\u0012\u001c\n\u0006opType\u0018\u0006 \u0001(\u000e2\f.InterOpTypeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{InteractTypeOuterClass.getDescriptor(), InterOpTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GadgetInteractRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GadgetInteractRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GadgetInteractRsp_descriptor, new String[]{"InteractType", "Retcode", "GadgetId", "GadgetEntityId", "OpType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetInteractRspOuterClass$GadgetInteractRspOrBuilder.class */
    public interface GadgetInteractRspOrBuilder extends MessageOrBuilder {
        int getInteractTypeValue();

        InteractTypeOuterClass.InteractType getInteractType();

        int getRetcode();

        int getGadgetId();

        int getGadgetEntityId();

        int getOpTypeValue();

        InterOpTypeOuterClass.InterOpType getOpType();
    }

    private GadgetInteractRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetInteractRspOuterClass$GadgetInteractRsp.class */
    public static final class GadgetInteractRsp extends GeneratedMessageV3 implements GadgetInteractRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int INTERACTTYPE_FIELD_NUMBER = 3;
        private int interactType_;
        public static final int RETCODE_FIELD_NUMBER = 12;
        private int retcode_;
        public static final int GADGETID_FIELD_NUMBER = 10;
        private int gadgetId_;
        public static final int GADGETENTITYID_FIELD_NUMBER = 2;
        private int gadgetEntityId_;
        public static final int OPTYPE_FIELD_NUMBER = 6;
        private int opType_;
        private byte memoizedIsInitialized;
        private static final GadgetInteractRsp DEFAULT_INSTANCE = new GadgetInteractRsp();
        private static final Parser<GadgetInteractRsp> PARSER = new AbstractParser<GadgetInteractRsp>() { // from class: emu.grasscutter.net.proto.GadgetInteractRspOuterClass.GadgetInteractRsp.1
            @Override // com.google.protobuf.Parser
            public GadgetInteractRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GadgetInteractRsp(input, extensionRegistry);
            }
        };

        private GadgetInteractRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GadgetInteractRsp() {
            this.memoizedIsInitialized = -1;
            this.interactType_ = 0;
            this.opType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GadgetInteractRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GadgetInteractRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.gadgetEntityId_ = input.readUInt32();
                                break;
                            case 24:
                                this.interactType_ = input.readEnum();
                                break;
                            case 48:
                                this.opType_ = input.readEnum();
                                break;
                            case 80:
                                this.gadgetId_ = input.readUInt32();
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
            return GadgetInteractRspOuterClass.internal_static_GadgetInteractRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GadgetInteractRspOuterClass.internal_static_GadgetInteractRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GadgetInteractRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GadgetInteractRspOuterClass.GadgetInteractRspOrBuilder
        public int getInteractTypeValue() {
            return this.interactType_;
        }

        @Override // emu.grasscutter.net.proto.GadgetInteractRspOuterClass.GadgetInteractRspOrBuilder
        public InteractTypeOuterClass.InteractType getInteractType() {
            InteractTypeOuterClass.InteractType result = InteractTypeOuterClass.InteractType.valueOf(this.interactType_);
            return result == null ? InteractTypeOuterClass.InteractType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.GadgetInteractRspOuterClass.GadgetInteractRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GadgetInteractRspOuterClass.GadgetInteractRspOrBuilder
        public int getGadgetId() {
            return this.gadgetId_;
        }

        @Override // emu.grasscutter.net.proto.GadgetInteractRspOuterClass.GadgetInteractRspOrBuilder
        public int getGadgetEntityId() {
            return this.gadgetEntityId_;
        }

        @Override // emu.grasscutter.net.proto.GadgetInteractRspOuterClass.GadgetInteractRspOrBuilder
        public int getOpTypeValue() {
            return this.opType_;
        }

        @Override // emu.grasscutter.net.proto.GadgetInteractRspOuterClass.GadgetInteractRspOrBuilder
        public InterOpTypeOuterClass.InterOpType getOpType() {
            InterOpTypeOuterClass.InterOpType result = InterOpTypeOuterClass.InterOpType.valueOf(this.opType_);
            return result == null ? InterOpTypeOuterClass.InterOpType.UNRECOGNIZED : result;
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
            if (this.gadgetEntityId_ != 0) {
                output.writeUInt32(2, this.gadgetEntityId_);
            }
            if (this.interactType_ != InteractTypeOuterClass.InteractType.INTERACT_TYPE_NONE.getNumber()) {
                output.writeEnum(3, this.interactType_);
            }
            if (this.opType_ != InterOpTypeOuterClass.InterOpType.INTER_OP_TYPE_FINISH.getNumber()) {
                output.writeEnum(6, this.opType_);
            }
            if (this.gadgetId_ != 0) {
                output.writeUInt32(10, this.gadgetId_);
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
            if (this.gadgetEntityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.gadgetEntityId_);
            }
            if (this.interactType_ != InteractTypeOuterClass.InteractType.INTERACT_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(3, this.interactType_);
            }
            if (this.opType_ != InterOpTypeOuterClass.InterOpType.INTER_OP_TYPE_FINISH.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(6, this.opType_);
            }
            if (this.gadgetId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.gadgetId_);
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
            if (!(obj instanceof GadgetInteractRsp)) {
                return equals(obj);
            }
            GadgetInteractRsp other = (GadgetInteractRsp) obj;
            return this.interactType_ == other.interactType_ && getRetcode() == other.getRetcode() && getGadgetId() == other.getGadgetId() && getGadgetEntityId() == other.getGadgetEntityId() && this.opType_ == other.opType_ && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + this.interactType_)) + 12)) + getRetcode())) + 10)) + getGadgetId())) + 2)) + getGadgetEntityId())) + 6)) + this.opType_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static GadgetInteractRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetInteractRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetInteractRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetInteractRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetInteractRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetInteractRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetInteractRsp parseFrom(InputStream input) throws IOException {
            return (GadgetInteractRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GadgetInteractRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetInteractRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GadgetInteractRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GadgetInteractRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GadgetInteractRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetInteractRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GadgetInteractRsp parseFrom(CodedInputStream input) throws IOException {
            return (GadgetInteractRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GadgetInteractRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetInteractRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GadgetInteractRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetInteractRspOuterClass$GadgetInteractRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GadgetInteractRspOrBuilder {
            private int retcode_;
            private int gadgetId_;
            private int gadgetEntityId_;
            private int interactType_ = 0;
            private int opType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return GadgetInteractRspOuterClass.internal_static_GadgetInteractRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GadgetInteractRspOuterClass.internal_static_GadgetInteractRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GadgetInteractRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GadgetInteractRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.interactType_ = 0;
                this.retcode_ = 0;
                this.gadgetId_ = 0;
                this.gadgetEntityId_ = 0;
                this.opType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GadgetInteractRspOuterClass.internal_static_GadgetInteractRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GadgetInteractRsp getDefaultInstanceForType() {
                return GadgetInteractRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GadgetInteractRsp build() {
                GadgetInteractRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GadgetInteractRsp buildPartial() {
                GadgetInteractRsp result = new GadgetInteractRsp(this);
                result.interactType_ = this.interactType_;
                result.retcode_ = this.retcode_;
                result.gadgetId_ = this.gadgetId_;
                result.gadgetEntityId_ = this.gadgetEntityId_;
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
                if (other instanceof GadgetInteractRsp) {
                    return mergeFrom((GadgetInteractRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GadgetInteractRsp other) {
                if (other == GadgetInteractRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.interactType_ != 0) {
                    setInteractTypeValue(other.getInteractTypeValue());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getGadgetId() != 0) {
                    setGadgetId(other.getGadgetId());
                }
                if (other.getGadgetEntityId() != 0) {
                    setGadgetEntityId(other.getGadgetEntityId());
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
                GadgetInteractRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GadgetInteractRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GadgetInteractRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GadgetInteractRspOuterClass.GadgetInteractRspOrBuilder
            public int getInteractTypeValue() {
                return this.interactType_;
            }

            public Builder setInteractTypeValue(int value) {
                this.interactType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetInteractRspOuterClass.GadgetInteractRspOrBuilder
            public InteractTypeOuterClass.InteractType getInteractType() {
                InteractTypeOuterClass.InteractType result = InteractTypeOuterClass.InteractType.valueOf(this.interactType_);
                return result == null ? InteractTypeOuterClass.InteractType.UNRECOGNIZED : result;
            }

            public Builder setInteractType(InteractTypeOuterClass.InteractType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.interactType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearInteractType() {
                this.interactType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetInteractRspOuterClass.GadgetInteractRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GadgetInteractRspOuterClass.GadgetInteractRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GadgetInteractRspOuterClass.GadgetInteractRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GadgetInteractRspOuterClass.GadgetInteractRspOrBuilder
            public int getOpTypeValue() {
                return this.opType_;
            }

            public Builder setOpTypeValue(int value) {
                this.opType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetInteractRspOuterClass.GadgetInteractRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static GadgetInteractRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GadgetInteractRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GadgetInteractRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GadgetInteractRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        InteractTypeOuterClass.getDescriptor();
        InterOpTypeOuterClass.getDescriptor();
    }
}
