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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.EquipParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetMailItemRspOuterClass.class */
public final class GetMailItemRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014GetMailItemRsp.proto\u001a\u0010EquipParam.proto\"T\n\u000eGetMailItemRsp\u0012\u001d\n\bitemList\u0018\t \u0003(\u000b2\u000b.EquipParam\u0012\u0012\n\nmailIdList\u0018\u0006 \u0003(\r\u0012\u000f\n\u0007retcode\u0018\f \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{EquipParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetMailItemRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetMailItemRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetMailItemRsp_descriptor, new String[]{"ItemList", "MailIdList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetMailItemRspOuterClass$GetMailItemRspOrBuilder.class */
    public interface GetMailItemRspOrBuilder extends MessageOrBuilder {
        List<EquipParamOuterClass.EquipParam> getItemListList();

        EquipParamOuterClass.EquipParam getItemList(int i);

        int getItemListCount();

        List<? extends EquipParamOuterClass.EquipParamOrBuilder> getItemListOrBuilderList();

        EquipParamOuterClass.EquipParamOrBuilder getItemListOrBuilder(int i);

        List<Integer> getMailIdListList();

        int getMailIdListCount();

        int getMailIdList(int i);

        int getRetcode();
    }

    private GetMailItemRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetMailItemRspOuterClass$GetMailItemRsp.class */
    public static final class GetMailItemRsp extends GeneratedMessageV3 implements GetMailItemRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ITEMLIST_FIELD_NUMBER = 9;
        private List<EquipParamOuterClass.EquipParam> itemList_;
        public static final int MAILIDLIST_FIELD_NUMBER = 6;
        private Internal.IntList mailIdList_;
        private int mailIdListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 12;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final GetMailItemRsp DEFAULT_INSTANCE = new GetMailItemRsp();
        private static final Parser<GetMailItemRsp> PARSER = new AbstractParser<GetMailItemRsp>() { // from class: emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRsp.1
            @Override // com.google.protobuf.Parser
            public GetMailItemRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetMailItemRsp(input, extensionRegistry);
            }
        };

        private GetMailItemRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.mailIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GetMailItemRsp() {
            this.mailIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.itemList_ = Collections.emptyList();
            this.mailIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetMailItemRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x010d */
        private GetMailItemRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 48:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.mailIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.mailIdList_.addInt(input.readUInt32());
                                break;
                            case 50:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.mailIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.mailIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.itemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.itemList_.add((EquipParamOuterClass.EquipParam) input.readMessage(EquipParamOuterClass.EquipParam.parser(), extensionRegistry));
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
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.mailIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.itemList_ = Collections.unmodifiableList(this.itemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetMailItemRspOuterClass.internal_static_GetMailItemRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetMailItemRspOuterClass.internal_static_GetMailItemRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMailItemRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
        public List<EquipParamOuterClass.EquipParam> getItemListList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
        public List<? extends EquipParamOuterClass.EquipParamOrBuilder> getItemListOrBuilderList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
        public int getItemListCount() {
            return this.itemList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
        public EquipParamOuterClass.EquipParam getItemList(int index) {
            return this.itemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
        public EquipParamOuterClass.EquipParamOrBuilder getItemListOrBuilder(int index) {
            return this.itemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
        public List<Integer> getMailIdListList() {
            return this.mailIdList_;
        }

        @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
        public int getMailIdListCount() {
            return this.mailIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
        public int getMailIdList(int index) {
            return this.mailIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
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
            if (getMailIdListList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.mailIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.mailIdList_.size(); i++) {
                output.writeUInt32NoTag(this.mailIdList_.getInt(i));
            }
            for (int i2 = 0; i2 < this.itemList_.size(); i2++) {
                output.writeMessage(9, this.itemList_.get(i2));
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
            int dataSize = 0;
            for (int i = 0; i < this.mailIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.mailIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getMailIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.mailIdListMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.itemList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.itemList_.get(i2));
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
            if (!(obj instanceof GetMailItemRsp)) {
                return equals(obj);
            }
            GetMailItemRsp other = (GetMailItemRsp) obj;
            return getItemListList().equals(other.getItemListList()) && getMailIdListList().equals(other.getMailIdListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getItemListList().hashCode();
            }
            if (getMailIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getMailIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 12)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetMailItemRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetMailItemRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMailItemRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetMailItemRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMailItemRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetMailItemRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMailItemRsp parseFrom(InputStream input) throws IOException {
            return (GetMailItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetMailItemRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMailItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetMailItemRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMailItemRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetMailItemRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMailItemRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetMailItemRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetMailItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetMailItemRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMailItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetMailItemRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetMailItemRspOuterClass$GetMailItemRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetMailItemRspOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<EquipParamOuterClass.EquipParam, EquipParamOuterClass.EquipParam.Builder, EquipParamOuterClass.EquipParamOrBuilder> itemListBuilder_;
            private int retcode_;
            private List<EquipParamOuterClass.EquipParam> itemList_ = Collections.emptyList();
            private Internal.IntList mailIdList_ = GetMailItemRsp.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GetMailItemRspOuterClass.internal_static_GetMailItemRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetMailItemRspOuterClass.internal_static_GetMailItemRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMailItemRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetMailItemRsp.alwaysUseFieldBuilders) {
                    getItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.itemListBuilder_.clear();
                }
                this.mailIdList_ = GetMailItemRsp.emptyIntList();
                this.bitField0_ &= -3;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetMailItemRspOuterClass.internal_static_GetMailItemRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetMailItemRsp getDefaultInstanceForType() {
                return GetMailItemRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetMailItemRsp build() {
                GetMailItemRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetMailItemRsp buildPartial() {
                GetMailItemRsp result = new GetMailItemRsp(this);
                int i = this.bitField0_;
                if (this.itemListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.itemList_ = Collections.unmodifiableList(this.itemList_);
                        this.bitField0_ &= -2;
                    }
                    result.itemList_ = this.itemList_;
                } else {
                    result.itemList_ = this.itemListBuilder_.build();
                }
                if ((this.bitField0_ & 2) != 0) {
                    this.mailIdList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.mailIdList_ = this.mailIdList_;
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
                if (other instanceof GetMailItemRsp) {
                    return mergeFrom((GetMailItemRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetMailItemRsp other) {
                if (other == GetMailItemRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.itemListBuilder_ == null) {
                    if (!other.itemList_.isEmpty()) {
                        if (this.itemList_.isEmpty()) {
                            this.itemList_ = other.itemList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureItemListIsMutable();
                            this.itemList_.addAll(other.itemList_);
                        }
                        onChanged();
                    }
                } else if (!other.itemList_.isEmpty()) {
                    if (this.itemListBuilder_.isEmpty()) {
                        this.itemListBuilder_.dispose();
                        this.itemListBuilder_ = null;
                        this.itemList_ = other.itemList_;
                        this.bitField0_ &= -2;
                        this.itemListBuilder_ = GetMailItemRsp.alwaysUseFieldBuilders ? getItemListFieldBuilder() : null;
                    } else {
                        this.itemListBuilder_.addAllMessages(other.itemList_);
                    }
                }
                if (!other.mailIdList_.isEmpty()) {
                    if (this.mailIdList_.isEmpty()) {
                        this.mailIdList_ = other.mailIdList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureMailIdListIsMutable();
                        this.mailIdList_.addAll(other.mailIdList_);
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
                GetMailItemRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetMailItemRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetMailItemRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.itemList_ = new ArrayList(this.itemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
            public List<EquipParamOuterClass.EquipParam> getItemListList() {
                if (this.itemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.itemList_);
                }
                return this.itemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
            public int getItemListCount() {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.size();
                }
                return this.itemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
            public EquipParamOuterClass.EquipParam getItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return this.itemListBuilder_.getMessage(index);
            }

            public Builder setItemList(int index, EquipParamOuterClass.EquipParam value) {
                if (this.itemListBuilder_ != null) {
                    this.itemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemListIsMutable();
                    this.itemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setItemList(int index, EquipParamOuterClass.EquipParam.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addItemList(EquipParamOuterClass.EquipParam value) {
                if (this.itemListBuilder_ != null) {
                    this.itemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemListIsMutable();
                    this.itemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addItemList(int index, EquipParamOuterClass.EquipParam value) {
                if (this.itemListBuilder_ != null) {
                    this.itemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemListIsMutable();
                    this.itemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addItemList(EquipParamOuterClass.EquipParam.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addItemList(int index, EquipParamOuterClass.EquipParam.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllItemList(Iterable<? extends EquipParamOuterClass.EquipParam> values) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.itemList_);
                    onChanged();
                } else {
                    this.itemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearItemList() {
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.itemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.remove(index);
                    onChanged();
                } else {
                    this.itemListBuilder_.remove(index);
                }
                return this;
            }

            public EquipParamOuterClass.EquipParam.Builder getItemListBuilder(int index) {
                return getItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
            public EquipParamOuterClass.EquipParamOrBuilder getItemListOrBuilder(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return this.itemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
            public List<? extends EquipParamOuterClass.EquipParamOrBuilder> getItemListOrBuilderList() {
                if (this.itemListBuilder_ != null) {
                    return this.itemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.itemList_);
            }

            public EquipParamOuterClass.EquipParam.Builder addItemListBuilder() {
                return getItemListFieldBuilder().addBuilder(EquipParamOuterClass.EquipParam.getDefaultInstance());
            }

            public EquipParamOuterClass.EquipParam.Builder addItemListBuilder(int index) {
                return getItemListFieldBuilder().addBuilder(index, EquipParamOuterClass.EquipParam.getDefaultInstance());
            }

            public List<EquipParamOuterClass.EquipParam.Builder> getItemListBuilderList() {
                return getItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<EquipParamOuterClass.EquipParam, EquipParamOuterClass.EquipParam.Builder, EquipParamOuterClass.EquipParamOrBuilder> getItemListFieldBuilder() {
                if (this.itemListBuilder_ == null) {
                    this.itemListBuilder_ = new RepeatedFieldBuilderV3<>(this.itemList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.itemList_ = null;
                }
                return this.itemListBuilder_;
            }

            private void ensureMailIdListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.mailIdList_ = GetMailItemRsp.mutableCopy(this.mailIdList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
            public List<Integer> getMailIdListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.mailIdList_) : this.mailIdList_;
            }

            @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
            public int getMailIdListCount() {
                return this.mailIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
            public int getMailIdList(int index) {
                return this.mailIdList_.getInt(index);
            }

            public Builder setMailIdList(int index, int value) {
                ensureMailIdListIsMutable();
                this.mailIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addMailIdList(int value) {
                ensureMailIdListIsMutable();
                this.mailIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllMailIdList(Iterable<? extends Integer> values) {
                ensureMailIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.mailIdList_);
                onChanged();
                return this;
            }

            public Builder clearMailIdList() {
                this.mailIdList_ = GetMailItemRsp.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetMailItemRspOuterClass.GetMailItemRspOrBuilder
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

        public static GetMailItemRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetMailItemRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetMailItemRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetMailItemRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        EquipParamOuterClass.getDescriptor();
    }
}
