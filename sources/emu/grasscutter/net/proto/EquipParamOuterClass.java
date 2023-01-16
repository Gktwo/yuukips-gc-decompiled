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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipParamOuterClass.class */
public final class EquipParamOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010EquipParam.proto\"Z\n\nEquipParam\u0012\u000f\n\u0007item_id\u0018\u0001 \u0001(\r\u0012\u0010\n\bitem_num\u0018\u0002 \u0001(\r\u0012\u0012\n\nitem_level\u0018\u0003 \u0001(\r\u0012\u0015\n\rpromote_level\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_EquipParam_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EquipParam_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EquipParam_descriptor, new String[]{"ItemId", "ItemNum", "ItemLevel", "PromoteLevel"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipParamOuterClass$EquipParamOrBuilder.class */
    public interface EquipParamOrBuilder extends MessageOrBuilder {
        int getItemId();

        int getItemNum();

        int getItemLevel();

        int getPromoteLevel();
    }

    private EquipParamOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipParamOuterClass$EquipParam.class */
    public static final class EquipParam extends GeneratedMessageV3 implements EquipParamOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ITEM_ID_FIELD_NUMBER = 1;
        private int itemId_;
        public static final int ITEM_NUM_FIELD_NUMBER = 2;
        private int itemNum_;
        public static final int ITEM_LEVEL_FIELD_NUMBER = 3;
        private int itemLevel_;
        public static final int PROMOTE_LEVEL_FIELD_NUMBER = 4;
        private int promoteLevel_;
        private byte memoizedIsInitialized;
        private static final EquipParam DEFAULT_INSTANCE = new EquipParam();
        private static final Parser<EquipParam> PARSER = new AbstractParser<EquipParam>() { // from class: emu.grasscutter.net.proto.EquipParamOuterClass.EquipParam.1
            @Override // com.google.protobuf.Parser
            public EquipParam parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EquipParam(input, extensionRegistry);
            }
        };

        private EquipParam(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EquipParam() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EquipParam();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EquipParam(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.itemId_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.itemNum_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.itemLevel_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.promoteLevel_ = input.readUInt32();
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
            return EquipParamOuterClass.internal_static_EquipParam_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EquipParamOuterClass.internal_static_EquipParam_fieldAccessorTable.ensureFieldAccessorsInitialized(EquipParam.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EquipParamOuterClass.EquipParamOrBuilder
        public int getItemId() {
            return this.itemId_;
        }

        @Override // emu.grasscutter.net.proto.EquipParamOuterClass.EquipParamOrBuilder
        public int getItemNum() {
            return this.itemNum_;
        }

        @Override // emu.grasscutter.net.proto.EquipParamOuterClass.EquipParamOrBuilder
        public int getItemLevel() {
            return this.itemLevel_;
        }

        @Override // emu.grasscutter.net.proto.EquipParamOuterClass.EquipParamOrBuilder
        public int getPromoteLevel() {
            return this.promoteLevel_;
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
            if (this.itemId_ != 0) {
                output.writeUInt32(1, this.itemId_);
            }
            if (this.itemNum_ != 0) {
                output.writeUInt32(2, this.itemNum_);
            }
            if (this.itemLevel_ != 0) {
                output.writeUInt32(3, this.itemLevel_);
            }
            if (this.promoteLevel_ != 0) {
                output.writeUInt32(4, this.promoteLevel_);
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
            if (this.itemId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.itemId_);
            }
            if (this.itemNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.itemNum_);
            }
            if (this.itemLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.itemLevel_);
            }
            if (this.promoteLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.promoteLevel_);
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
            if (!(obj instanceof EquipParam)) {
                return equals(obj);
            }
            EquipParam other = (EquipParam) obj;
            return getItemId() == other.getItemId() && getItemNum() == other.getItemNum() && getItemLevel() == other.getItemLevel() && getPromoteLevel() == other.getPromoteLevel() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getItemId())) + 2)) + getItemNum())) + 3)) + getItemLevel())) + 4)) + getPromoteLevel())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static EquipParam parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EquipParam parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EquipParam parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EquipParam parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EquipParam parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EquipParam parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EquipParam parseFrom(InputStream input) throws IOException {
            return (EquipParam) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EquipParam parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EquipParam) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EquipParam parseDelimitedFrom(InputStream input) throws IOException {
            return (EquipParam) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EquipParam parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EquipParam) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EquipParam parseFrom(CodedInputStream input) throws IOException {
            return (EquipParam) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EquipParam parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EquipParam) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EquipParam prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EquipParamOuterClass$EquipParam$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EquipParamOrBuilder {
            private int itemId_;
            private int itemNum_;
            private int itemLevel_;
            private int promoteLevel_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EquipParamOuterClass.internal_static_EquipParam_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EquipParamOuterClass.internal_static_EquipParam_fieldAccessorTable.ensureFieldAccessorsInitialized(EquipParam.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EquipParam.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.itemId_ = 0;
                this.itemNum_ = 0;
                this.itemLevel_ = 0;
                this.promoteLevel_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EquipParamOuterClass.internal_static_EquipParam_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EquipParam getDefaultInstanceForType() {
                return EquipParam.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EquipParam build() {
                EquipParam result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EquipParam buildPartial() {
                EquipParam result = new EquipParam(this);
                result.itemId_ = this.itemId_;
                result.itemNum_ = this.itemNum_;
                result.itemLevel_ = this.itemLevel_;
                result.promoteLevel_ = this.promoteLevel_;
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
                if (other instanceof EquipParam) {
                    return mergeFrom((EquipParam) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EquipParam other) {
                if (other == EquipParam.getDefaultInstance()) {
                    return this;
                }
                if (other.getItemId() != 0) {
                    setItemId(other.getItemId());
                }
                if (other.getItemNum() != 0) {
                    setItemNum(other.getItemNum());
                }
                if (other.getItemLevel() != 0) {
                    setItemLevel(other.getItemLevel());
                }
                if (other.getPromoteLevel() != 0) {
                    setPromoteLevel(other.getPromoteLevel());
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
                EquipParam parsedMessage = null;
                try {
                    try {
                        parsedMessage = EquipParam.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EquipParam) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EquipParamOuterClass.EquipParamOrBuilder
            public int getItemId() {
                return this.itemId_;
            }

            public Builder setItemId(int value) {
                this.itemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemId() {
                this.itemId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EquipParamOuterClass.EquipParamOrBuilder
            public int getItemNum() {
                return this.itemNum_;
            }

            public Builder setItemNum(int value) {
                this.itemNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemNum() {
                this.itemNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EquipParamOuterClass.EquipParamOrBuilder
            public int getItemLevel() {
                return this.itemLevel_;
            }

            public Builder setItemLevel(int value) {
                this.itemLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemLevel() {
                this.itemLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EquipParamOuterClass.EquipParamOrBuilder
            public int getPromoteLevel() {
                return this.promoteLevel_;
            }

            public Builder setPromoteLevel(int value) {
                this.promoteLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearPromoteLevel() {
                this.promoteLevel_ = 0;
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

        public static EquipParam getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EquipParam> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EquipParam> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EquipParam getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
