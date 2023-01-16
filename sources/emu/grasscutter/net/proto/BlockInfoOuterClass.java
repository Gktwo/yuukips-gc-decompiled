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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlockInfoOuterClass.class */
public final class BlockInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fBlockInfo.proto\"W\n\tBlockInfo\u0012\u0010\n\bblock_id\u0018\u0001 \u0001(\r\u0012\u0014\n\fdata_version\u0018\u0002 \u0001(\r\u0012\u0010\n\bbin_data\u0018\u0003 \u0001(\f\u0012\u0010\n\bis_dirty\u0018\u0004 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BlockInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BlockInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BlockInfo_descriptor, new String[]{"BlockId", "DataVersion", "BinData", "IsDirty"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlockInfoOuterClass$BlockInfoOrBuilder.class */
    public interface BlockInfoOrBuilder extends MessageOrBuilder {
        int getBlockId();

        int getDataVersion();

        ByteString getBinData();

        boolean getIsDirty();
    }

    private BlockInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlockInfoOuterClass$BlockInfo.class */
    public static final class BlockInfo extends GeneratedMessageV3 implements BlockInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BLOCK_ID_FIELD_NUMBER = 1;
        private int blockId_;
        public static final int DATA_VERSION_FIELD_NUMBER = 2;
        private int dataVersion_;
        public static final int BIN_DATA_FIELD_NUMBER = 3;
        private ByteString binData_;
        public static final int IS_DIRTY_FIELD_NUMBER = 4;
        private boolean isDirty_;
        private byte memoizedIsInitialized;
        private static final BlockInfo DEFAULT_INSTANCE = new BlockInfo();
        private static final Parser<BlockInfo> PARSER = new AbstractParser<BlockInfo>() { // from class: emu.grasscutter.net.proto.BlockInfoOuterClass.BlockInfo.1
            @Override // com.google.protobuf.Parser
            public BlockInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BlockInfo(input, extensionRegistry);
            }
        };

        private BlockInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BlockInfo() {
            this.memoizedIsInitialized = -1;
            this.binData_ = ByteString.EMPTY;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BlockInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BlockInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.blockId_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.dataVersion_ = input.readUInt32();
                                    break;
                                case 26:
                                    this.binData_ = input.readBytes();
                                    break;
                                case 32:
                                    this.isDirty_ = input.readBool();
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
            return BlockInfoOuterClass.internal_static_BlockInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BlockInfoOuterClass.internal_static_BlockInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BlockInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BlockInfoOuterClass.BlockInfoOrBuilder
        public int getBlockId() {
            return this.blockId_;
        }

        @Override // emu.grasscutter.net.proto.BlockInfoOuterClass.BlockInfoOrBuilder
        public int getDataVersion() {
            return this.dataVersion_;
        }

        @Override // emu.grasscutter.net.proto.BlockInfoOuterClass.BlockInfoOrBuilder
        public ByteString getBinData() {
            return this.binData_;
        }

        @Override // emu.grasscutter.net.proto.BlockInfoOuterClass.BlockInfoOrBuilder
        public boolean getIsDirty() {
            return this.isDirty_;
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
            if (this.blockId_ != 0) {
                output.writeUInt32(1, this.blockId_);
            }
            if (this.dataVersion_ != 0) {
                output.writeUInt32(2, this.dataVersion_);
            }
            if (!this.binData_.isEmpty()) {
                output.writeBytes(3, this.binData_);
            }
            if (this.isDirty_) {
                output.writeBool(4, this.isDirty_);
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
            if (this.blockId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.blockId_);
            }
            if (this.dataVersion_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.dataVersion_);
            }
            if (!this.binData_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(3, this.binData_);
            }
            if (this.isDirty_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isDirty_);
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
            if (!(obj instanceof BlockInfo)) {
                return equals(obj);
            }
            BlockInfo other = (BlockInfo) obj;
            return getBlockId() == other.getBlockId() && getDataVersion() == other.getDataVersion() && getBinData().equals(other.getBinData()) && getIsDirty() == other.getIsDirty() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getBlockId())) + 2)) + getDataVersion())) + 3)) + getBinData().hashCode())) + 4)) + Internal.hashBoolean(getIsDirty()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static BlockInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BlockInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlockInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BlockInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlockInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BlockInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlockInfo parseFrom(InputStream input) throws IOException {
            return (BlockInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BlockInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlockInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BlockInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BlockInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BlockInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlockInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BlockInfo parseFrom(CodedInputStream input) throws IOException {
            return (BlockInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BlockInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlockInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BlockInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlockInfoOuterClass$BlockInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BlockInfoOrBuilder {
            private int blockId_;
            private int dataVersion_;
            private ByteString binData_ = ByteString.EMPTY;
            private boolean isDirty_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BlockInfoOuterClass.internal_static_BlockInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BlockInfoOuterClass.internal_static_BlockInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BlockInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BlockInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.blockId_ = 0;
                this.dataVersion_ = 0;
                this.binData_ = ByteString.EMPTY;
                this.isDirty_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BlockInfoOuterClass.internal_static_BlockInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BlockInfo getDefaultInstanceForType() {
                return BlockInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BlockInfo build() {
                BlockInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BlockInfo buildPartial() {
                BlockInfo result = new BlockInfo(this);
                result.blockId_ = this.blockId_;
                result.dataVersion_ = this.dataVersion_;
                result.binData_ = this.binData_;
                result.isDirty_ = this.isDirty_;
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
                if (other instanceof BlockInfo) {
                    return mergeFrom((BlockInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BlockInfo other) {
                if (other == BlockInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getBlockId() != 0) {
                    setBlockId(other.getBlockId());
                }
                if (other.getDataVersion() != 0) {
                    setDataVersion(other.getDataVersion());
                }
                if (other.getBinData() != ByteString.EMPTY) {
                    setBinData(other.getBinData());
                }
                if (other.getIsDirty()) {
                    setIsDirty(other.getIsDirty());
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
                BlockInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BlockInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BlockInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BlockInfoOuterClass.BlockInfoOrBuilder
            public int getBlockId() {
                return this.blockId_;
            }

            public Builder setBlockId(int value) {
                this.blockId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBlockId() {
                this.blockId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BlockInfoOuterClass.BlockInfoOrBuilder
            public int getDataVersion() {
                return this.dataVersion_;
            }

            public Builder setDataVersion(int value) {
                this.dataVersion_ = value;
                onChanged();
                return this;
            }

            public Builder clearDataVersion() {
                this.dataVersion_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BlockInfoOuterClass.BlockInfoOrBuilder
            public ByteString getBinData() {
                return this.binData_;
            }

            public Builder setBinData(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.binData_ = value;
                onChanged();
                return this;
            }

            public Builder clearBinData() {
                this.binData_ = BlockInfo.getDefaultInstance().getBinData();
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BlockInfoOuterClass.BlockInfoOrBuilder
            public boolean getIsDirty() {
                return this.isDirty_;
            }

            public Builder setIsDirty(boolean value) {
                this.isDirty_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsDirty() {
                this.isDirty_ = false;
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

        public static BlockInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BlockInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BlockInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BlockInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
