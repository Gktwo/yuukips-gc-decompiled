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
import emu.grasscutter.net.proto.CompoundQueueDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetCompoundDataRspOuterClass.class */
public final class GetCompoundDataRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018GetCompoundDataRsp.proto\u001a\u0017CompoundQueueData.proto\"y\n\u0012GetCompoundDataRsp\u00124\n\u0018compound_queue_data_list\u0018\u0004 \u0003(\u000b2\u0012.CompoundQueueData\u0012\u001c\n\u0014unlock_compound_list\u0018\n \u0003(\r\u0012\u000f\n\u0007retcode\u0018\u000f \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CompoundQueueDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetCompoundDataRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetCompoundDataRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetCompoundDataRsp_descriptor, new String[]{"CompoundQueueDataList", "UnlockCompoundList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetCompoundDataRspOuterClass$GetCompoundDataRspOrBuilder.class */
    public interface GetCompoundDataRspOrBuilder extends MessageOrBuilder {
        List<CompoundQueueDataOuterClass.CompoundQueueData> getCompoundQueueDataListList();

        CompoundQueueDataOuterClass.CompoundQueueData getCompoundQueueDataList(int i);

        int getCompoundQueueDataListCount();

        List<? extends CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder> getCompoundQueueDataListOrBuilderList();

        CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder getCompoundQueueDataListOrBuilder(int i);

        List<Integer> getUnlockCompoundListList();

        int getUnlockCompoundListCount();

        int getUnlockCompoundList(int i);

        int getRetcode();
    }

    private GetCompoundDataRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetCompoundDataRspOuterClass$GetCompoundDataRsp.class */
    public static final class GetCompoundDataRsp extends GeneratedMessageV3 implements GetCompoundDataRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COMPOUND_QUEUE_DATA_LIST_FIELD_NUMBER = 4;
        private List<CompoundQueueDataOuterClass.CompoundQueueData> compoundQueueDataList_;
        public static final int UNLOCK_COMPOUND_LIST_FIELD_NUMBER = 10;
        private Internal.IntList unlockCompoundList_;
        private int unlockCompoundListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 15;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final GetCompoundDataRsp DEFAULT_INSTANCE = new GetCompoundDataRsp();
        private static final Parser<GetCompoundDataRsp> PARSER = new AbstractParser<GetCompoundDataRsp>() { // from class: emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRsp.1
            @Override // com.google.protobuf.Parser
            public GetCompoundDataRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetCompoundDataRsp(input, extensionRegistry);
            }
        };

        private GetCompoundDataRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unlockCompoundListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GetCompoundDataRsp() {
            this.unlockCompoundListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.compoundQueueDataList_ = Collections.emptyList();
            this.unlockCompoundList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetCompoundDataRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x010d */
        private GetCompoundDataRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 34:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.compoundQueueDataList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.compoundQueueDataList_.add((CompoundQueueDataOuterClass.CompoundQueueData) input.readMessage(CompoundQueueDataOuterClass.CompoundQueueData.parser(), extensionRegistry));
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unlockCompoundList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unlockCompoundList_.addInt(input.readUInt32());
                                break;
                            case 82:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unlockCompoundList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unlockCompoundList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 120:
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
                    this.compoundQueueDataList_ = Collections.unmodifiableList(this.compoundQueueDataList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unlockCompoundList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetCompoundDataRspOuterClass.internal_static_GetCompoundDataRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetCompoundDataRspOuterClass.internal_static_GetCompoundDataRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetCompoundDataRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
        public List<CompoundQueueDataOuterClass.CompoundQueueData> getCompoundQueueDataListList() {
            return this.compoundQueueDataList_;
        }

        @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
        public List<? extends CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder> getCompoundQueueDataListOrBuilderList() {
            return this.compoundQueueDataList_;
        }

        @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
        public int getCompoundQueueDataListCount() {
            return this.compoundQueueDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
        public CompoundQueueDataOuterClass.CompoundQueueData getCompoundQueueDataList(int index) {
            return this.compoundQueueDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
        public CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder getCompoundQueueDataListOrBuilder(int index) {
            return this.compoundQueueDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
        public List<Integer> getUnlockCompoundListList() {
            return this.unlockCompoundList_;
        }

        @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
        public int getUnlockCompoundListCount() {
            return this.unlockCompoundList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
        public int getUnlockCompoundList(int index) {
            return this.unlockCompoundList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
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
            for (int i = 0; i < this.compoundQueueDataList_.size(); i++) {
                output.writeMessage(4, this.compoundQueueDataList_.get(i));
            }
            if (getUnlockCompoundListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.unlockCompoundListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unlockCompoundList_.size(); i2++) {
                output.writeUInt32NoTag(this.unlockCompoundList_.getInt(i2));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(15, this.retcode_);
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
            for (int i = 0; i < this.compoundQueueDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.compoundQueueDataList_.get(i));
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.unlockCompoundList_.size(); i2++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unlockCompoundList_.getInt(i2));
            }
            int size3 = size2 + dataSize;
            if (!getUnlockCompoundListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unlockCompoundListMemoizedSerializedSize = dataSize;
            if (this.retcode_ != 0) {
                size3 += CodedOutputStream.computeInt32Size(15, this.retcode_);
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
            if (!(obj instanceof GetCompoundDataRsp)) {
                return equals(obj);
            }
            GetCompoundDataRsp other = (GetCompoundDataRsp) obj;
            return getCompoundQueueDataListList().equals(other.getCompoundQueueDataListList()) && getUnlockCompoundListList().equals(other.getUnlockCompoundListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getCompoundQueueDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getCompoundQueueDataListList().hashCode();
            }
            if (getUnlockCompoundListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getUnlockCompoundListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 15)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetCompoundDataRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetCompoundDataRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetCompoundDataRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetCompoundDataRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetCompoundDataRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetCompoundDataRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetCompoundDataRsp parseFrom(InputStream input) throws IOException {
            return (GetCompoundDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetCompoundDataRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetCompoundDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetCompoundDataRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetCompoundDataRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetCompoundDataRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetCompoundDataRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetCompoundDataRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetCompoundDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetCompoundDataRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetCompoundDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetCompoundDataRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetCompoundDataRspOuterClass$GetCompoundDataRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetCompoundDataRspOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<CompoundQueueDataOuterClass.CompoundQueueData, CompoundQueueDataOuterClass.CompoundQueueData.Builder, CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder> compoundQueueDataListBuilder_;
            private int retcode_;
            private List<CompoundQueueDataOuterClass.CompoundQueueData> compoundQueueDataList_ = Collections.emptyList();
            private Internal.IntList unlockCompoundList_ = GetCompoundDataRsp.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GetCompoundDataRspOuterClass.internal_static_GetCompoundDataRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetCompoundDataRspOuterClass.internal_static_GetCompoundDataRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetCompoundDataRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetCompoundDataRsp.alwaysUseFieldBuilders) {
                    getCompoundQueueDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.compoundQueueDataListBuilder_ == null) {
                    this.compoundQueueDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.compoundQueueDataListBuilder_.clear();
                }
                this.unlockCompoundList_ = GetCompoundDataRsp.emptyIntList();
                this.bitField0_ &= -3;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetCompoundDataRspOuterClass.internal_static_GetCompoundDataRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetCompoundDataRsp getDefaultInstanceForType() {
                return GetCompoundDataRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetCompoundDataRsp build() {
                GetCompoundDataRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetCompoundDataRsp buildPartial() {
                GetCompoundDataRsp result = new GetCompoundDataRsp(this);
                int i = this.bitField0_;
                if (this.compoundQueueDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.compoundQueueDataList_ = Collections.unmodifiableList(this.compoundQueueDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.compoundQueueDataList_ = this.compoundQueueDataList_;
                } else {
                    result.compoundQueueDataList_ = this.compoundQueueDataListBuilder_.build();
                }
                if ((this.bitField0_ & 2) != 0) {
                    this.unlockCompoundList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unlockCompoundList_ = this.unlockCompoundList_;
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
                if (other instanceof GetCompoundDataRsp) {
                    return mergeFrom((GetCompoundDataRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetCompoundDataRsp other) {
                if (other == GetCompoundDataRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.compoundQueueDataListBuilder_ == null) {
                    if (!other.compoundQueueDataList_.isEmpty()) {
                        if (this.compoundQueueDataList_.isEmpty()) {
                            this.compoundQueueDataList_ = other.compoundQueueDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureCompoundQueueDataListIsMutable();
                            this.compoundQueueDataList_.addAll(other.compoundQueueDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.compoundQueueDataList_.isEmpty()) {
                    if (this.compoundQueueDataListBuilder_.isEmpty()) {
                        this.compoundQueueDataListBuilder_.dispose();
                        this.compoundQueueDataListBuilder_ = null;
                        this.compoundQueueDataList_ = other.compoundQueueDataList_;
                        this.bitField0_ &= -2;
                        this.compoundQueueDataListBuilder_ = GetCompoundDataRsp.alwaysUseFieldBuilders ? getCompoundQueueDataListFieldBuilder() : null;
                    } else {
                        this.compoundQueueDataListBuilder_.addAllMessages(other.compoundQueueDataList_);
                    }
                }
                if (!other.unlockCompoundList_.isEmpty()) {
                    if (this.unlockCompoundList_.isEmpty()) {
                        this.unlockCompoundList_ = other.unlockCompoundList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnlockCompoundListIsMutable();
                        this.unlockCompoundList_.addAll(other.unlockCompoundList_);
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
                GetCompoundDataRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetCompoundDataRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetCompoundDataRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureCompoundQueueDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.compoundQueueDataList_ = new ArrayList(this.compoundQueueDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
            public List<CompoundQueueDataOuterClass.CompoundQueueData> getCompoundQueueDataListList() {
                if (this.compoundQueueDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.compoundQueueDataList_);
                }
                return this.compoundQueueDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
            public int getCompoundQueueDataListCount() {
                if (this.compoundQueueDataListBuilder_ == null) {
                    return this.compoundQueueDataList_.size();
                }
                return this.compoundQueueDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
            public CompoundQueueDataOuterClass.CompoundQueueData getCompoundQueueDataList(int index) {
                if (this.compoundQueueDataListBuilder_ == null) {
                    return this.compoundQueueDataList_.get(index);
                }
                return this.compoundQueueDataListBuilder_.getMessage(index);
            }

            public Builder setCompoundQueueDataList(int index, CompoundQueueDataOuterClass.CompoundQueueData value) {
                if (this.compoundQueueDataListBuilder_ != null) {
                    this.compoundQueueDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCompoundQueueDataListIsMutable();
                    this.compoundQueueDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setCompoundQueueDataList(int index, CompoundQueueDataOuterClass.CompoundQueueData.Builder builderForValue) {
                if (this.compoundQueueDataListBuilder_ == null) {
                    ensureCompoundQueueDataListIsMutable();
                    this.compoundQueueDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.compoundQueueDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCompoundQueueDataList(CompoundQueueDataOuterClass.CompoundQueueData value) {
                if (this.compoundQueueDataListBuilder_ != null) {
                    this.compoundQueueDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCompoundQueueDataListIsMutable();
                    this.compoundQueueDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addCompoundQueueDataList(int index, CompoundQueueDataOuterClass.CompoundQueueData value) {
                if (this.compoundQueueDataListBuilder_ != null) {
                    this.compoundQueueDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCompoundQueueDataListIsMutable();
                    this.compoundQueueDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addCompoundQueueDataList(CompoundQueueDataOuterClass.CompoundQueueData.Builder builderForValue) {
                if (this.compoundQueueDataListBuilder_ == null) {
                    ensureCompoundQueueDataListIsMutable();
                    this.compoundQueueDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.compoundQueueDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCompoundQueueDataList(int index, CompoundQueueDataOuterClass.CompoundQueueData.Builder builderForValue) {
                if (this.compoundQueueDataListBuilder_ == null) {
                    ensureCompoundQueueDataListIsMutable();
                    this.compoundQueueDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.compoundQueueDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCompoundQueueDataList(Iterable<? extends CompoundQueueDataOuterClass.CompoundQueueData> values) {
                if (this.compoundQueueDataListBuilder_ == null) {
                    ensureCompoundQueueDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.compoundQueueDataList_);
                    onChanged();
                } else {
                    this.compoundQueueDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCompoundQueueDataList() {
                if (this.compoundQueueDataListBuilder_ == null) {
                    this.compoundQueueDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.compoundQueueDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeCompoundQueueDataList(int index) {
                if (this.compoundQueueDataListBuilder_ == null) {
                    ensureCompoundQueueDataListIsMutable();
                    this.compoundQueueDataList_.remove(index);
                    onChanged();
                } else {
                    this.compoundQueueDataListBuilder_.remove(index);
                }
                return this;
            }

            public CompoundQueueDataOuterClass.CompoundQueueData.Builder getCompoundQueueDataListBuilder(int index) {
                return getCompoundQueueDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
            public CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder getCompoundQueueDataListOrBuilder(int index) {
                if (this.compoundQueueDataListBuilder_ == null) {
                    return this.compoundQueueDataList_.get(index);
                }
                return this.compoundQueueDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
            public List<? extends CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder> getCompoundQueueDataListOrBuilderList() {
                if (this.compoundQueueDataListBuilder_ != null) {
                    return this.compoundQueueDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.compoundQueueDataList_);
            }

            public CompoundQueueDataOuterClass.CompoundQueueData.Builder addCompoundQueueDataListBuilder() {
                return getCompoundQueueDataListFieldBuilder().addBuilder(CompoundQueueDataOuterClass.CompoundQueueData.getDefaultInstance());
            }

            public CompoundQueueDataOuterClass.CompoundQueueData.Builder addCompoundQueueDataListBuilder(int index) {
                return getCompoundQueueDataListFieldBuilder().addBuilder(index, CompoundQueueDataOuterClass.CompoundQueueData.getDefaultInstance());
            }

            public List<CompoundQueueDataOuterClass.CompoundQueueData.Builder> getCompoundQueueDataListBuilderList() {
                return getCompoundQueueDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CompoundQueueDataOuterClass.CompoundQueueData, CompoundQueueDataOuterClass.CompoundQueueData.Builder, CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder> getCompoundQueueDataListFieldBuilder() {
                if (this.compoundQueueDataListBuilder_ == null) {
                    this.compoundQueueDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.compoundQueueDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.compoundQueueDataList_ = null;
                }
                return this.compoundQueueDataListBuilder_;
            }

            private void ensureUnlockCompoundListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unlockCompoundList_ = GetCompoundDataRsp.mutableCopy(this.unlockCompoundList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
            public List<Integer> getUnlockCompoundListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unlockCompoundList_) : this.unlockCompoundList_;
            }

            @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
            public int getUnlockCompoundListCount() {
                return this.unlockCompoundList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
            public int getUnlockCompoundList(int index) {
                return this.unlockCompoundList_.getInt(index);
            }

            public Builder setUnlockCompoundList(int index, int value) {
                ensureUnlockCompoundListIsMutable();
                this.unlockCompoundList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnlockCompoundList(int value) {
                ensureUnlockCompoundListIsMutable();
                this.unlockCompoundList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnlockCompoundList(Iterable<? extends Integer> values) {
                ensureUnlockCompoundListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unlockCompoundList_);
                onChanged();
                return this;
            }

            public Builder clearUnlockCompoundList() {
                this.unlockCompoundList_ = GetCompoundDataRsp.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetCompoundDataRspOuterClass.GetCompoundDataRspOrBuilder
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

        public static GetCompoundDataRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetCompoundDataRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetCompoundDataRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetCompoundDataRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CompoundQueueDataOuterClass.getDescriptor();
    }
}
