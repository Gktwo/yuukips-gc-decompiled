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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CheckAddItemExceedLimitNotifyOuterClass.class */
public final class CheckAddItemExceedLimitNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#CheckAddItemExceedLimitNotify.proto\"\u0003\n\u001dCheckAddItemExceedLimitNotify\u0012\u001a\n\u0012exceeded_item_list\u0018\u0004 \u0003(\r\u0012\u001f\n\u0017exceeded_item_type_list\u0018\u000b \u0003(\r\u0012\u000e\n\u0006reason\u0018\t \u0001(\r\u0012\u000f\n\u0007is_drop\u0018\u000e \u0001(\b\u0012G\n\bmsg_type\u0018\u0006 \u0001(\u000e25.CheckAddItemExceedLimitNotify.ItemExceedLimitMsgType\"¼\u0001\n\u0016ItemExceedLimitMsgType\u0012&\n\"ITEM_EXCEED_LIMIT_MSG_TYPE_DEFAULT\u0010��\u0012#\n\u001fITEM_EXCEED_LIMIT_MSG_TYPE_TEXT\u0010\u0001\u0012%\n!ITEM_EXCEED_LIMIT_MSG_TYPE_DIALOG\u0010\u0002\u0012.\n*ITEM_EXCEED_LIMIT_MSG_TYPE_DIALOG_NONBLOCK\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CheckAddItemExceedLimitNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CheckAddItemExceedLimitNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CheckAddItemExceedLimitNotify_descriptor, new String[]{"ExceededItemList", "ExceededItemTypeList", "Reason", "IsDrop", "MsgType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CheckAddItemExceedLimitNotifyOuterClass$CheckAddItemExceedLimitNotifyOrBuilder.class */
    public interface CheckAddItemExceedLimitNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getExceededItemListList();

        int getExceededItemListCount();

        int getExceededItemList(int i);

        List<Integer> getExceededItemTypeListList();

        int getExceededItemTypeListCount();

        int getExceededItemTypeList(int i);

        int getReason();

        boolean getIsDrop();

        int getMsgTypeValue();

        CheckAddItemExceedLimitNotify.ItemExceedLimitMsgType getMsgType();
    }

    private CheckAddItemExceedLimitNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CheckAddItemExceedLimitNotifyOuterClass$CheckAddItemExceedLimitNotify.class */
    public static final class CheckAddItemExceedLimitNotify extends GeneratedMessageV3 implements CheckAddItemExceedLimitNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int EXCEEDED_ITEM_LIST_FIELD_NUMBER = 4;
        private Internal.IntList exceededItemList_;
        private int exceededItemListMemoizedSerializedSize;
        public static final int EXCEEDED_ITEM_TYPE_LIST_FIELD_NUMBER = 11;
        private Internal.IntList exceededItemTypeList_;
        private int exceededItemTypeListMemoizedSerializedSize;
        public static final int REASON_FIELD_NUMBER = 9;
        private int reason_;
        public static final int IS_DROP_FIELD_NUMBER = 14;
        private boolean isDrop_;
        public static final int MSG_TYPE_FIELD_NUMBER = 6;
        private int msgType_;
        private byte memoizedIsInitialized;
        private static final CheckAddItemExceedLimitNotify DEFAULT_INSTANCE = new CheckAddItemExceedLimitNotify();
        private static final Parser<CheckAddItemExceedLimitNotify> PARSER = new AbstractParser<CheckAddItemExceedLimitNotify>() { // from class: emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotify.1
            @Override // com.google.protobuf.Parser
            public CheckAddItemExceedLimitNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CheckAddItemExceedLimitNotify(input, extensionRegistry);
            }
        };

        private CheckAddItemExceedLimitNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.exceededItemListMemoizedSerializedSize = -1;
            this.exceededItemTypeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private CheckAddItemExceedLimitNotify() {
            this.exceededItemListMemoizedSerializedSize = -1;
            this.exceededItemTypeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.exceededItemList_ = emptyIntList();
            this.exceededItemTypeList_ = emptyIntList();
            this.msgType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CheckAddItemExceedLimitNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:84:0x0179 */
        private CheckAddItemExceedLimitNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.exceededItemList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.exceededItemList_.addInt(input.readUInt32());
                                    break;
                                case 34:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.exceededItemList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.exceededItemList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 48:
                                    this.msgType_ = input.readEnum();
                                    break;
                                case 72:
                                    this.reason_ = input.readUInt32();
                                    break;
                                case 88:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.exceededItemTypeList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.exceededItemTypeList_.addInt(input.readUInt32());
                                    break;
                                case 90:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.exceededItemTypeList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.exceededItemTypeList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit2);
                                    break;
                                case 112:
                                    this.isDrop_ = input.readBool();
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.exceededItemList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.exceededItemTypeList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CheckAddItemExceedLimitNotifyOuterClass.internal_static_CheckAddItemExceedLimitNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CheckAddItemExceedLimitNotifyOuterClass.internal_static_CheckAddItemExceedLimitNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CheckAddItemExceedLimitNotify.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CheckAddItemExceedLimitNotifyOuterClass$CheckAddItemExceedLimitNotify$ItemExceedLimitMsgType.class */
        public enum ItemExceedLimitMsgType implements ProtocolMessageEnum {
            ITEM_EXCEED_LIMIT_MSG_TYPE_DEFAULT(0),
            ITEM_EXCEED_LIMIT_MSG_TYPE_TEXT(1),
            ITEM_EXCEED_LIMIT_MSG_TYPE_DIALOG(2),
            ITEM_EXCEED_LIMIT_MSG_TYPE_DIALOG_NONBLOCK(3),
            UNRECOGNIZED(-1);
            
            public static final int ITEM_EXCEED_LIMIT_MSG_TYPE_DEFAULT_VALUE = 0;
            public static final int ITEM_EXCEED_LIMIT_MSG_TYPE_TEXT_VALUE = 1;
            public static final int ITEM_EXCEED_LIMIT_MSG_TYPE_DIALOG_VALUE = 2;
            public static final int ITEM_EXCEED_LIMIT_MSG_TYPE_DIALOG_NONBLOCK_VALUE = 3;
            private static final Internal.EnumLiteMap<ItemExceedLimitMsgType> internalValueMap = new Internal.EnumLiteMap<ItemExceedLimitMsgType>() { // from class: emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotify.ItemExceedLimitMsgType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public ItemExceedLimitMsgType findValueByNumber(int number) {
                    return ItemExceedLimitMsgType.forNumber(number);
                }
            };
            private static final ItemExceedLimitMsgType[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static ItemExceedLimitMsgType valueOf(int value) {
                return forNumber(value);
            }

            public static ItemExceedLimitMsgType forNumber(int value) {
                switch (value) {
                    case 0:
                        return ITEM_EXCEED_LIMIT_MSG_TYPE_DEFAULT;
                    case 1:
                        return ITEM_EXCEED_LIMIT_MSG_TYPE_TEXT;
                    case 2:
                        return ITEM_EXCEED_LIMIT_MSG_TYPE_DIALOG;
                    case 3:
                        return ITEM_EXCEED_LIMIT_MSG_TYPE_DIALOG_NONBLOCK;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<ItemExceedLimitMsgType> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                if (this != UNRECOGNIZED) {
                    return getDescriptor().getValues().get(ordinal());
                }
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return CheckAddItemExceedLimitNotify.getDescriptor().getEnumTypes().get(0);
            }

            public static ItemExceedLimitMsgType valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            ItemExceedLimitMsgType(int value) {
                this.value = value;
            }
        }

        @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
        public List<Integer> getExceededItemListList() {
            return this.exceededItemList_;
        }

        @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
        public int getExceededItemListCount() {
            return this.exceededItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
        public int getExceededItemList(int index) {
            return this.exceededItemList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
        public List<Integer> getExceededItemTypeListList() {
            return this.exceededItemTypeList_;
        }

        @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
        public int getExceededItemTypeListCount() {
            return this.exceededItemTypeList_.size();
        }

        @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
        public int getExceededItemTypeList(int index) {
            return this.exceededItemTypeList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
        public int getReason() {
            return this.reason_;
        }

        @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
        public boolean getIsDrop() {
            return this.isDrop_;
        }

        @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
        public int getMsgTypeValue() {
            return this.msgType_;
        }

        @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
        public ItemExceedLimitMsgType getMsgType() {
            ItemExceedLimitMsgType result = ItemExceedLimitMsgType.valueOf(this.msgType_);
            return result == null ? ItemExceedLimitMsgType.UNRECOGNIZED : result;
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
            if (getExceededItemListList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.exceededItemListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.exceededItemList_.size(); i++) {
                output.writeUInt32NoTag(this.exceededItemList_.getInt(i));
            }
            if (this.msgType_ != ItemExceedLimitMsgType.ITEM_EXCEED_LIMIT_MSG_TYPE_DEFAULT.getNumber()) {
                output.writeEnum(6, this.msgType_);
            }
            if (this.reason_ != 0) {
                output.writeUInt32(9, this.reason_);
            }
            if (getExceededItemTypeListList().size() > 0) {
                output.writeUInt32NoTag(90);
                output.writeUInt32NoTag(this.exceededItemTypeListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.exceededItemTypeList_.size(); i2++) {
                output.writeUInt32NoTag(this.exceededItemTypeList_.getInt(i2));
            }
            if (this.isDrop_) {
                output.writeBool(14, this.isDrop_);
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
            for (int i = 0; i < this.exceededItemList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.exceededItemList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getExceededItemListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.exceededItemListMemoizedSerializedSize = dataSize;
            if (this.msgType_ != ItemExceedLimitMsgType.ITEM_EXCEED_LIMIT_MSG_TYPE_DEFAULT.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(6, this.msgType_);
            }
            if (this.reason_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.reason_);
            }
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.exceededItemTypeList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.exceededItemTypeList_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getExceededItemTypeListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.exceededItemTypeListMemoizedSerializedSize = dataSize2;
            if (this.isDrop_) {
                size3 += CodedOutputStream.computeBoolSize(14, this.isDrop_);
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
            if (!(obj instanceof CheckAddItemExceedLimitNotify)) {
                return equals(obj);
            }
            CheckAddItemExceedLimitNotify other = (CheckAddItemExceedLimitNotify) obj;
            return getExceededItemListList().equals(other.getExceededItemListList()) && getExceededItemTypeListList().equals(other.getExceededItemTypeListList()) && getReason() == other.getReason() && getIsDrop() == other.getIsDrop() && this.msgType_ == other.msgType_ && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getExceededItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getExceededItemListList().hashCode();
            }
            if (getExceededItemTypeListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getExceededItemTypeListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 9)) + getReason())) + 14)) + Internal.hashBoolean(getIsDrop()))) + 6)) + this.msgType_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CheckAddItemExceedLimitNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CheckAddItemExceedLimitNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CheckAddItemExceedLimitNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CheckAddItemExceedLimitNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CheckAddItemExceedLimitNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CheckAddItemExceedLimitNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CheckAddItemExceedLimitNotify parseFrom(InputStream input) throws IOException {
            return (CheckAddItemExceedLimitNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CheckAddItemExceedLimitNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CheckAddItemExceedLimitNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CheckAddItemExceedLimitNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (CheckAddItemExceedLimitNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CheckAddItemExceedLimitNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CheckAddItemExceedLimitNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CheckAddItemExceedLimitNotify parseFrom(CodedInputStream input) throws IOException {
            return (CheckAddItemExceedLimitNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CheckAddItemExceedLimitNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CheckAddItemExceedLimitNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CheckAddItemExceedLimitNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CheckAddItemExceedLimitNotifyOuterClass$CheckAddItemExceedLimitNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CheckAddItemExceedLimitNotifyOrBuilder {
            private int bitField0_;
            private int reason_;
            private boolean isDrop_;
            private Internal.IntList exceededItemList_ = CheckAddItemExceedLimitNotify.emptyIntList();
            private Internal.IntList exceededItemTypeList_ = CheckAddItemExceedLimitNotify.emptyIntList();
            private int msgType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return CheckAddItemExceedLimitNotifyOuterClass.internal_static_CheckAddItemExceedLimitNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CheckAddItemExceedLimitNotifyOuterClass.internal_static_CheckAddItemExceedLimitNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CheckAddItemExceedLimitNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CheckAddItemExceedLimitNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.exceededItemList_ = CheckAddItemExceedLimitNotify.emptyIntList();
                this.bitField0_ &= -2;
                this.exceededItemTypeList_ = CheckAddItemExceedLimitNotify.emptyIntList();
                this.bitField0_ &= -3;
                this.reason_ = 0;
                this.isDrop_ = false;
                this.msgType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CheckAddItemExceedLimitNotifyOuterClass.internal_static_CheckAddItemExceedLimitNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CheckAddItemExceedLimitNotify getDefaultInstanceForType() {
                return CheckAddItemExceedLimitNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CheckAddItemExceedLimitNotify build() {
                CheckAddItemExceedLimitNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CheckAddItemExceedLimitNotify buildPartial() {
                CheckAddItemExceedLimitNotify result = new CheckAddItemExceedLimitNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.exceededItemList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.exceededItemList_ = this.exceededItemList_;
                if ((this.bitField0_ & 2) != 0) {
                    this.exceededItemTypeList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.exceededItemTypeList_ = this.exceededItemTypeList_;
                result.reason_ = this.reason_;
                result.isDrop_ = this.isDrop_;
                result.msgType_ = this.msgType_;
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
                if (other instanceof CheckAddItemExceedLimitNotify) {
                    return mergeFrom((CheckAddItemExceedLimitNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CheckAddItemExceedLimitNotify other) {
                if (other == CheckAddItemExceedLimitNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.exceededItemList_.isEmpty()) {
                    if (this.exceededItemList_.isEmpty()) {
                        this.exceededItemList_ = other.exceededItemList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureExceededItemListIsMutable();
                        this.exceededItemList_.addAll(other.exceededItemList_);
                    }
                    onChanged();
                }
                if (!other.exceededItemTypeList_.isEmpty()) {
                    if (this.exceededItemTypeList_.isEmpty()) {
                        this.exceededItemTypeList_ = other.exceededItemTypeList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureExceededItemTypeListIsMutable();
                        this.exceededItemTypeList_.addAll(other.exceededItemTypeList_);
                    }
                    onChanged();
                }
                if (other.getReason() != 0) {
                    setReason(other.getReason());
                }
                if (other.getIsDrop()) {
                    setIsDrop(other.getIsDrop());
                }
                if (other.msgType_ != 0) {
                    setMsgTypeValue(other.getMsgTypeValue());
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
                CheckAddItemExceedLimitNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = CheckAddItemExceedLimitNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CheckAddItemExceedLimitNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureExceededItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.exceededItemList_ = CheckAddItemExceedLimitNotify.mutableCopy(this.exceededItemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
            public List<Integer> getExceededItemListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.exceededItemList_) : this.exceededItemList_;
            }

            @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
            public int getExceededItemListCount() {
                return this.exceededItemList_.size();
            }

            @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
            public int getExceededItemList(int index) {
                return this.exceededItemList_.getInt(index);
            }

            public Builder setExceededItemList(int index, int value) {
                ensureExceededItemListIsMutable();
                this.exceededItemList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addExceededItemList(int value) {
                ensureExceededItemListIsMutable();
                this.exceededItemList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllExceededItemList(Iterable<? extends Integer> values) {
                ensureExceededItemListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.exceededItemList_);
                onChanged();
                return this;
            }

            public Builder clearExceededItemList() {
                this.exceededItemList_ = CheckAddItemExceedLimitNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureExceededItemTypeListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.exceededItemTypeList_ = CheckAddItemExceedLimitNotify.mutableCopy(this.exceededItemTypeList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
            public List<Integer> getExceededItemTypeListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.exceededItemTypeList_) : this.exceededItemTypeList_;
            }

            @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
            public int getExceededItemTypeListCount() {
                return this.exceededItemTypeList_.size();
            }

            @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
            public int getExceededItemTypeList(int index) {
                return this.exceededItemTypeList_.getInt(index);
            }

            public Builder setExceededItemTypeList(int index, int value) {
                ensureExceededItemTypeListIsMutable();
                this.exceededItemTypeList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addExceededItemTypeList(int value) {
                ensureExceededItemTypeListIsMutable();
                this.exceededItemTypeList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllExceededItemTypeList(Iterable<? extends Integer> values) {
                ensureExceededItemTypeListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.exceededItemTypeList_);
                onChanged();
                return this;
            }

            public Builder clearExceededItemTypeList() {
                this.exceededItemTypeList_ = CheckAddItemExceedLimitNotify.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
            public int getReason() {
                return this.reason_;
            }

            public Builder setReason(int value) {
                this.reason_ = value;
                onChanged();
                return this;
            }

            public Builder clearReason() {
                this.reason_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
            public boolean getIsDrop() {
                return this.isDrop_;
            }

            public Builder setIsDrop(boolean value) {
                this.isDrop_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsDrop() {
                this.isDrop_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
            public int getMsgTypeValue() {
                return this.msgType_;
            }

            public Builder setMsgTypeValue(int value) {
                this.msgType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CheckAddItemExceedLimitNotifyOuterClass.CheckAddItemExceedLimitNotifyOrBuilder
            public ItemExceedLimitMsgType getMsgType() {
                ItemExceedLimitMsgType result = ItemExceedLimitMsgType.valueOf(this.msgType_);
                return result == null ? ItemExceedLimitMsgType.UNRECOGNIZED : result;
            }

            public Builder setMsgType(ItemExceedLimitMsgType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.msgType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearMsgType() {
                this.msgType_ = 0;
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

        public static CheckAddItemExceedLimitNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CheckAddItemExceedLimitNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CheckAddItemExceedLimitNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CheckAddItemExceedLimitNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
