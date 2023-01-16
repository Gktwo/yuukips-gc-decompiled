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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaUpInfoOuterClass.class */
public final class GachaUpInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011GachaUpInfo.proto\"=\n\u000bGachaUpInfo\u0012\u0018\n\u0010item_parent_type\u0018\u000f \u0001(\r\u0012\u0014\n\fitem_id_list\u0018\u0006 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GachaUpInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GachaUpInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GachaUpInfo_descriptor, new String[]{"ItemParentType", "ItemIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaUpInfoOuterClass$GachaUpInfoOrBuilder.class */
    public interface GachaUpInfoOrBuilder extends MessageOrBuilder {
        int getItemParentType();

        List<Integer> getItemIdListList();

        int getItemIdListCount();

        int getItemIdList(int i);
    }

    private GachaUpInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaUpInfoOuterClass$GachaUpInfo.class */
    public static final class GachaUpInfo extends GeneratedMessageV3 implements GachaUpInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ITEM_PARENT_TYPE_FIELD_NUMBER = 15;
        private int itemParentType_;
        public static final int ITEM_ID_LIST_FIELD_NUMBER = 6;
        private Internal.IntList itemIdList_;
        private int itemIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final GachaUpInfo DEFAULT_INSTANCE = new GachaUpInfo();
        private static final Parser<GachaUpInfo> PARSER = new AbstractParser<GachaUpInfo>() { // from class: emu.grasscutter.net.proto.GachaUpInfoOuterClass.GachaUpInfo.1
            @Override // com.google.protobuf.Parser
            public GachaUpInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GachaUpInfo(input, extensionRegistry);
            }
        };

        private GachaUpInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.itemIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GachaUpInfo() {
            this.itemIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.itemIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GachaUpInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GachaUpInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 48:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.itemIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.itemIdList_.addInt(input.readUInt32());
                                    break;
                                case 50:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.itemIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.itemIdList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 120:
                                    this.itemParentType_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.itemIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GachaUpInfoOuterClass.internal_static_GachaUpInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GachaUpInfoOuterClass.internal_static_GachaUpInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GachaUpInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GachaUpInfoOuterClass.GachaUpInfoOrBuilder
        public int getItemParentType() {
            return this.itemParentType_;
        }

        @Override // emu.grasscutter.net.proto.GachaUpInfoOuterClass.GachaUpInfoOrBuilder
        public List<Integer> getItemIdListList() {
            return this.itemIdList_;
        }

        @Override // emu.grasscutter.net.proto.GachaUpInfoOuterClass.GachaUpInfoOrBuilder
        public int getItemIdListCount() {
            return this.itemIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.GachaUpInfoOuterClass.GachaUpInfoOrBuilder
        public int getItemIdList(int index) {
            return this.itemIdList_.getInt(index);
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
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.itemIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.itemIdList_.size(); i++) {
                output.writeUInt32NoTag(this.itemIdList_.getInt(i));
            }
            if (this.itemParentType_ != 0) {
                output.writeUInt32(15, this.itemParentType_);
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
            if (this.itemParentType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.itemParentType_);
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
            if (!(obj instanceof GachaUpInfo)) {
                return equals(obj);
            }
            GachaUpInfo other = (GachaUpInfo) obj;
            return getItemParentType() == other.getItemParentType() && getItemIdListList().equals(other.getItemIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getItemParentType();
            if (getItemIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getItemIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GachaUpInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaUpInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaUpInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaUpInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaUpInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaUpInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaUpInfo parseFrom(InputStream input) throws IOException {
            return (GachaUpInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GachaUpInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaUpInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GachaUpInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GachaUpInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GachaUpInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaUpInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GachaUpInfo parseFrom(CodedInputStream input) throws IOException {
            return (GachaUpInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GachaUpInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaUpInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GachaUpInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaUpInfoOuterClass$GachaUpInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GachaUpInfoOrBuilder {
            private int bitField0_;
            private int itemParentType_;
            private Internal.IntList itemIdList_ = GachaUpInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GachaUpInfoOuterClass.internal_static_GachaUpInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GachaUpInfoOuterClass.internal_static_GachaUpInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GachaUpInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GachaUpInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.itemParentType_ = 0;
                this.itemIdList_ = GachaUpInfo.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GachaUpInfoOuterClass.internal_static_GachaUpInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GachaUpInfo getDefaultInstanceForType() {
                return GachaUpInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GachaUpInfo build() {
                GachaUpInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GachaUpInfo buildPartial() {
                GachaUpInfo result = new GachaUpInfo(this);
                int i = this.bitField0_;
                result.itemParentType_ = this.itemParentType_;
                if ((this.bitField0_ & 1) != 0) {
                    this.itemIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.itemIdList_ = this.itemIdList_;
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
                if (other instanceof GachaUpInfo) {
                    return mergeFrom((GachaUpInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GachaUpInfo other) {
                if (other == GachaUpInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getItemParentType() != 0) {
                    setItemParentType(other.getItemParentType());
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
                GachaUpInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = GachaUpInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GachaUpInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaUpInfoOuterClass.GachaUpInfoOrBuilder
            public int getItemParentType() {
                return this.itemParentType_;
            }

            public Builder setItemParentType(int value) {
                this.itemParentType_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemParentType() {
                this.itemParentType_ = 0;
                onChanged();
                return this;
            }

            private void ensureItemIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.itemIdList_ = GachaUpInfo.mutableCopy(this.itemIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaUpInfoOuterClass.GachaUpInfoOrBuilder
            public List<Integer> getItemIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.itemIdList_) : this.itemIdList_;
            }

            @Override // emu.grasscutter.net.proto.GachaUpInfoOuterClass.GachaUpInfoOrBuilder
            public int getItemIdListCount() {
                return this.itemIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.GachaUpInfoOuterClass.GachaUpInfoOrBuilder
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
                this.itemIdList_ = GachaUpInfo.emptyIntList();
                this.bitField0_ &= -2;
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

        public static GachaUpInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GachaUpInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GachaUpInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GachaUpInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
