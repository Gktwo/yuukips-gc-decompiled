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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeGadgetInfoOuterClass.class */
public final class RoguelikeGadgetInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019RoguelikeGadgetInfo.proto\"e\n\u0013RoguelikeGadgetInfo\u0012\u0016\n\u000ecell_config_id\u0018\u0001 \u0001(\r\u0012\u0011\n\tcell_type\u0018\u0002 \u0001(\r\u0012\u0012\n\ncell_state\u0018\u0003 \u0001(\r\u0012\u000f\n\u0007cell_id\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_RoguelikeGadgetInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RoguelikeGadgetInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RoguelikeGadgetInfo_descriptor, new String[]{"CellConfigId", "CellType", "CellState", "CellId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeGadgetInfoOuterClass$RoguelikeGadgetInfoOrBuilder.class */
    public interface RoguelikeGadgetInfoOrBuilder extends MessageOrBuilder {
        int getCellConfigId();

        int getCellType();

        int getCellState();

        int getCellId();
    }

    private RoguelikeGadgetInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeGadgetInfoOuterClass$RoguelikeGadgetInfo.class */
    public static final class RoguelikeGadgetInfo extends GeneratedMessageV3 implements RoguelikeGadgetInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CELL_CONFIG_ID_FIELD_NUMBER = 1;
        private int cellConfigId_;
        public static final int CELL_TYPE_FIELD_NUMBER = 2;
        private int cellType_;
        public static final int CELL_STATE_FIELD_NUMBER = 3;
        private int cellState_;
        public static final int CELL_ID_FIELD_NUMBER = 4;
        private int cellId_;
        private byte memoizedIsInitialized;
        private static final RoguelikeGadgetInfo DEFAULT_INSTANCE = new RoguelikeGadgetInfo();
        private static final Parser<RoguelikeGadgetInfo> PARSER = new AbstractParser<RoguelikeGadgetInfo>() { // from class: emu.grasscutter.net.proto.RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo.1
            @Override // com.google.protobuf.Parser
            public RoguelikeGadgetInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RoguelikeGadgetInfo(input, extensionRegistry);
            }
        };

        private RoguelikeGadgetInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RoguelikeGadgetInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RoguelikeGadgetInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RoguelikeGadgetInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.cellConfigId_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.cellType_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.cellState_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.cellId_ = input.readUInt32();
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
            return RoguelikeGadgetInfoOuterClass.internal_static_RoguelikeGadgetInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RoguelikeGadgetInfoOuterClass.internal_static_RoguelikeGadgetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RoguelikeGadgetInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfoOrBuilder
        public int getCellConfigId() {
            return this.cellConfigId_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfoOrBuilder
        public int getCellType() {
            return this.cellType_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfoOrBuilder
        public int getCellState() {
            return this.cellState_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfoOrBuilder
        public int getCellId() {
            return this.cellId_;
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
            if (this.cellConfigId_ != 0) {
                output.writeUInt32(1, this.cellConfigId_);
            }
            if (this.cellType_ != 0) {
                output.writeUInt32(2, this.cellType_);
            }
            if (this.cellState_ != 0) {
                output.writeUInt32(3, this.cellState_);
            }
            if (this.cellId_ != 0) {
                output.writeUInt32(4, this.cellId_);
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
            if (this.cellConfigId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.cellConfigId_);
            }
            if (this.cellType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.cellType_);
            }
            if (this.cellState_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.cellState_);
            }
            if (this.cellId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.cellId_);
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
            if (!(obj instanceof RoguelikeGadgetInfo)) {
                return equals(obj);
            }
            RoguelikeGadgetInfo other = (RoguelikeGadgetInfo) obj;
            return getCellConfigId() == other.getCellConfigId() && getCellType() == other.getCellType() && getCellState() == other.getCellState() && getCellId() == other.getCellId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getCellConfigId())) + 2)) + getCellType())) + 3)) + getCellState())) + 4)) + getCellId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static RoguelikeGadgetInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeGadgetInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeGadgetInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeGadgetInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeGadgetInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeGadgetInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeGadgetInfo parseFrom(InputStream input) throws IOException {
            return (RoguelikeGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoguelikeGadgetInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoguelikeGadgetInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (RoguelikeGadgetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RoguelikeGadgetInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeGadgetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoguelikeGadgetInfo parseFrom(CodedInputStream input) throws IOException {
            return (RoguelikeGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoguelikeGadgetInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RoguelikeGadgetInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeGadgetInfoOuterClass$RoguelikeGadgetInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RoguelikeGadgetInfoOrBuilder {
            private int cellConfigId_;
            private int cellType_;
            private int cellState_;
            private int cellId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RoguelikeGadgetInfoOuterClass.internal_static_RoguelikeGadgetInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RoguelikeGadgetInfoOuterClass.internal_static_RoguelikeGadgetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RoguelikeGadgetInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RoguelikeGadgetInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.cellConfigId_ = 0;
                this.cellType_ = 0;
                this.cellState_ = 0;
                this.cellId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RoguelikeGadgetInfoOuterClass.internal_static_RoguelikeGadgetInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RoguelikeGadgetInfo getDefaultInstanceForType() {
                return RoguelikeGadgetInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RoguelikeGadgetInfo build() {
                RoguelikeGadgetInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RoguelikeGadgetInfo buildPartial() {
                RoguelikeGadgetInfo result = new RoguelikeGadgetInfo(this);
                result.cellConfigId_ = this.cellConfigId_;
                result.cellType_ = this.cellType_;
                result.cellState_ = this.cellState_;
                result.cellId_ = this.cellId_;
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
                if (other instanceof RoguelikeGadgetInfo) {
                    return mergeFrom((RoguelikeGadgetInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RoguelikeGadgetInfo other) {
                if (other == RoguelikeGadgetInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getCellConfigId() != 0) {
                    setCellConfigId(other.getCellConfigId());
                }
                if (other.getCellType() != 0) {
                    setCellType(other.getCellType());
                }
                if (other.getCellState() != 0) {
                    setCellState(other.getCellState());
                }
                if (other.getCellId() != 0) {
                    setCellId(other.getCellId());
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
                RoguelikeGadgetInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = RoguelikeGadgetInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RoguelikeGadgetInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfoOrBuilder
            public int getCellConfigId() {
                return this.cellConfigId_;
            }

            public Builder setCellConfigId(int value) {
                this.cellConfigId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCellConfigId() {
                this.cellConfigId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfoOrBuilder
            public int getCellType() {
                return this.cellType_;
            }

            public Builder setCellType(int value) {
                this.cellType_ = value;
                onChanged();
                return this;
            }

            public Builder clearCellType() {
                this.cellType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfoOrBuilder
            public int getCellState() {
                return this.cellState_;
            }

            public Builder setCellState(int value) {
                this.cellState_ = value;
                onChanged();
                return this;
            }

            public Builder clearCellState() {
                this.cellState_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfoOrBuilder
            public int getCellId() {
                return this.cellId_;
            }

            public Builder setCellId(int value) {
                this.cellId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCellId() {
                this.cellId_ = 0;
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

        public static RoguelikeGadgetInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RoguelikeGadgetInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RoguelikeGadgetInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RoguelikeGadgetInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
