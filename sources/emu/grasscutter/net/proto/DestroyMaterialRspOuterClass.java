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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DestroyMaterialRspOuterClass.class */
public final class DestroyMaterialRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018DestroyMaterialRsp.proto\"T\n\u0012DestroyMaterialRsp\u0012\u0014\n\fitem_id_list\u0018\n \u0003(\r\u0012\u0017\n\u000fitem_count_list\u0018\f \u0003(\r\u0012\u000f\n\u0007retcode\u0018\r \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_DestroyMaterialRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DestroyMaterialRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DestroyMaterialRsp_descriptor, new String[]{"ItemIdList", "ItemCountList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DestroyMaterialRspOuterClass$DestroyMaterialRspOrBuilder.class */
    public interface DestroyMaterialRspOrBuilder extends MessageOrBuilder {
        List<Integer> getItemIdListList();

        int getItemIdListCount();

        int getItemIdList(int i);

        List<Integer> getItemCountListList();

        int getItemCountListCount();

        int getItemCountList(int i);

        int getRetcode();
    }

    private DestroyMaterialRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DestroyMaterialRspOuterClass$DestroyMaterialRsp.class */
    public static final class DestroyMaterialRsp extends GeneratedMessageV3 implements DestroyMaterialRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ITEM_ID_LIST_FIELD_NUMBER = 10;
        private Internal.IntList itemIdList_;
        private int itemIdListMemoizedSerializedSize;
        public static final int ITEM_COUNT_LIST_FIELD_NUMBER = 12;
        private Internal.IntList itemCountList_;
        private int itemCountListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 13;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final DestroyMaterialRsp DEFAULT_INSTANCE = new DestroyMaterialRsp();
        private static final Parser<DestroyMaterialRsp> PARSER = new AbstractParser<DestroyMaterialRsp>() { // from class: emu.grasscutter.net.proto.DestroyMaterialRspOuterClass.DestroyMaterialRsp.1
            @Override // com.google.protobuf.Parser
            public DestroyMaterialRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DestroyMaterialRsp(input, extensionRegistry);
            }
        };

        private DestroyMaterialRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.itemIdListMemoizedSerializedSize = -1;
            this.itemCountListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private DestroyMaterialRsp() {
            this.itemIdListMemoizedSerializedSize = -1;
            this.itemCountListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.itemIdList_ = emptyIntList();
            this.itemCountList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DestroyMaterialRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x014f */
        private DestroyMaterialRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.itemIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.itemIdList_.addInt(input.readUInt32());
                                break;
                            case 82:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.itemIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.itemIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 96:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.itemCountList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.itemCountList_.addInt(input.readUInt32());
                                break;
                            case 98:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.itemCountList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.itemCountList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 104:
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
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.itemIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.itemCountList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DestroyMaterialRspOuterClass.internal_static_DestroyMaterialRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DestroyMaterialRspOuterClass.internal_static_DestroyMaterialRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(DestroyMaterialRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DestroyMaterialRspOuterClass.DestroyMaterialRspOrBuilder
        public List<Integer> getItemIdListList() {
            return this.itemIdList_;
        }

        @Override // emu.grasscutter.net.proto.DestroyMaterialRspOuterClass.DestroyMaterialRspOrBuilder
        public int getItemIdListCount() {
            return this.itemIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.DestroyMaterialRspOuterClass.DestroyMaterialRspOrBuilder
        public int getItemIdList(int index) {
            return this.itemIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.DestroyMaterialRspOuterClass.DestroyMaterialRspOrBuilder
        public List<Integer> getItemCountListList() {
            return this.itemCountList_;
        }

        @Override // emu.grasscutter.net.proto.DestroyMaterialRspOuterClass.DestroyMaterialRspOrBuilder
        public int getItemCountListCount() {
            return this.itemCountList_.size();
        }

        @Override // emu.grasscutter.net.proto.DestroyMaterialRspOuterClass.DestroyMaterialRspOrBuilder
        public int getItemCountList(int index) {
            return this.itemCountList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.DestroyMaterialRspOuterClass.DestroyMaterialRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
            getSerializedSize();
            if (getItemIdListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.itemIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.itemIdList_.size(); i++) {
                output.writeUInt32NoTag(this.itemIdList_.getInt(i));
            }
            if (getItemCountListList().size() > 0) {
                output.writeUInt32NoTag(98);
                output.writeUInt32NoTag(this.itemCountListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.itemCountList_.size(); i2++) {
                output.writeUInt32NoTag(this.itemCountList_.getInt(i2));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(13, this.retcode_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.itemIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.itemIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getItemIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.itemIdListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.itemCountList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.itemCountList_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getItemCountListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.itemCountListMemoizedSerializedSize = dataSize2;
            if (this.retcode_ != 0) {
                size3 += CodedOutputStream.computeInt32Size(13, this.retcode_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DestroyMaterialRsp)) {
                return equals(obj);
            }
            DestroyMaterialRsp other = (DestroyMaterialRsp) obj;
            return getItemIdListList().equals(other.getItemIdListList()) && getItemCountListList().equals(other.getItemCountListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getItemIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getItemIdListList().hashCode();
            }
            if (getItemCountListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getItemCountListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 13)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DestroyMaterialRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DestroyMaterialRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DestroyMaterialRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DestroyMaterialRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DestroyMaterialRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DestroyMaterialRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DestroyMaterialRsp parseFrom(InputStream input) throws IOException {
            return (DestroyMaterialRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DestroyMaterialRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DestroyMaterialRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DestroyMaterialRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (DestroyMaterialRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DestroyMaterialRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DestroyMaterialRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DestroyMaterialRsp parseFrom(CodedInputStream input) throws IOException {
            return (DestroyMaterialRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DestroyMaterialRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DestroyMaterialRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DestroyMaterialRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DestroyMaterialRspOuterClass$DestroyMaterialRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DestroyMaterialRspOrBuilder {
            private int bitField0_;
            private Internal.IntList itemIdList_ = DestroyMaterialRsp.emptyIntList();
            private Internal.IntList itemCountList_ = DestroyMaterialRsp.emptyIntList();
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DestroyMaterialRspOuterClass.internal_static_DestroyMaterialRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DestroyMaterialRspOuterClass.internal_static_DestroyMaterialRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(DestroyMaterialRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DestroyMaterialRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.itemIdList_ = DestroyMaterialRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.itemCountList_ = DestroyMaterialRsp.emptyIntList();
                this.bitField0_ &= -3;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DestroyMaterialRspOuterClass.internal_static_DestroyMaterialRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DestroyMaterialRsp getDefaultInstanceForType() {
                return DestroyMaterialRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DestroyMaterialRsp build() {
                DestroyMaterialRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DestroyMaterialRsp buildPartial() {
                DestroyMaterialRsp result = new DestroyMaterialRsp(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.itemIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.itemIdList_ = this.itemIdList_;
                if ((this.bitField0_ & 2) != 0) {
                    this.itemCountList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.itemCountList_ = this.itemCountList_;
                result.retcode_ = this.retcode_;
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
                if (other instanceof DestroyMaterialRsp) {
                    return mergeFrom((DestroyMaterialRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DestroyMaterialRsp other) {
                if (other == DestroyMaterialRsp.getDefaultInstance()) {
                    return this;
                }
                if (!other.itemIdList_.isEmpty()) {
                    if (this.itemIdList_.isEmpty()) {
                        this.itemIdList_ = other.itemIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureItemIdListIsMutable();
                        this.itemIdList_.addAll(other.itemIdList_);
                    }
                    onChanged();
                }
                if (!other.itemCountList_.isEmpty()) {
                    if (this.itemCountList_.isEmpty()) {
                        this.itemCountList_ = other.itemCountList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureItemCountListIsMutable();
                        this.itemCountList_.addAll(other.itemCountList_);
                    }
                    onChanged();
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                DestroyMaterialRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = DestroyMaterialRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DestroyMaterialRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureItemIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.itemIdList_ = DestroyMaterialRsp.mutableCopy(this.itemIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DestroyMaterialRspOuterClass.DestroyMaterialRspOrBuilder
            public List<Integer> getItemIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.itemIdList_) : this.itemIdList_;
            }

            @Override // emu.grasscutter.net.proto.DestroyMaterialRspOuterClass.DestroyMaterialRspOrBuilder
            public int getItemIdListCount() {
                return this.itemIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.DestroyMaterialRspOuterClass.DestroyMaterialRspOrBuilder
            public int getItemIdList(int index) {
                return this.itemIdList_.getInt(index);
            }

            public Builder setItemIdList(int index, int value) {
                ensureItemIdListIsMutable();
                this.itemIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addItemIdList(int value) {
                ensureItemIdListIsMutable();
                this.itemIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllItemIdList(Iterable<? extends Integer> values) {
                ensureItemIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.itemIdList_);
                onChanged();
                return this;
            }

            public Builder clearItemIdList() {
                this.itemIdList_ = DestroyMaterialRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureItemCountListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.itemCountList_ = DestroyMaterialRsp.mutableCopy(this.itemCountList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.DestroyMaterialRspOuterClass.DestroyMaterialRspOrBuilder
            public List<Integer> getItemCountListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.itemCountList_) : this.itemCountList_;
            }

            @Override // emu.grasscutter.net.proto.DestroyMaterialRspOuterClass.DestroyMaterialRspOrBuilder
            public int getItemCountListCount() {
                return this.itemCountList_.size();
            }

            @Override // emu.grasscutter.net.proto.DestroyMaterialRspOuterClass.DestroyMaterialRspOrBuilder
            public int getItemCountList(int index) {
                return this.itemCountList_.getInt(index);
            }

            public Builder setItemCountList(int index, int value) {
                ensureItemCountListIsMutable();
                this.itemCountList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addItemCountList(int value) {
                ensureItemCountListIsMutable();
                this.itemCountList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllItemCountList(Iterable<? extends Integer> values) {
                ensureItemCountListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.itemCountList_);
                onChanged();
                return this;
            }

            public Builder clearItemCountList() {
                this.itemCountList_ = DestroyMaterialRsp.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DestroyMaterialRspOuterClass.DestroyMaterialRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static DestroyMaterialRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DestroyMaterialRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DestroyMaterialRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DestroyMaterialRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
