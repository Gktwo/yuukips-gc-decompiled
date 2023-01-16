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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeAchievementRewardReqOuterClass.class */
public final class TakeAchievementRewardReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eTakeAchievementRewardReq.proto\"+\n\u0018TakeAchievementRewardReq\u0012\u000f\n\u0007id_list\u0018\t \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TakeAchievementRewardReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TakeAchievementRewardReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TakeAchievementRewardReq_descriptor, new String[]{"IdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeAchievementRewardReqOuterClass$TakeAchievementRewardReqOrBuilder.class */
    public interface TakeAchievementRewardReqOrBuilder extends MessageOrBuilder {
        List<Integer> getIdListList();

        int getIdListCount();

        int getIdList(int i);
    }

    private TakeAchievementRewardReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeAchievementRewardReqOuterClass$TakeAchievementRewardReq.class */
    public static final class TakeAchievementRewardReq extends GeneratedMessageV3 implements TakeAchievementRewardReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ID_LIST_FIELD_NUMBER = 9;
        private Internal.IntList idList_;
        private int idListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final TakeAchievementRewardReq DEFAULT_INSTANCE = new TakeAchievementRewardReq();
        private static final Parser<TakeAchievementRewardReq> PARSER = new AbstractParser<TakeAchievementRewardReq>() { // from class: emu.grasscutter.net.proto.TakeAchievementRewardReqOuterClass.TakeAchievementRewardReq.1
            @Override // com.google.protobuf.Parser
            public TakeAchievementRewardReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TakeAchievementRewardReq(input, extensionRegistry);
            }
        };

        private TakeAchievementRewardReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.idListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private TakeAchievementRewardReq() {
            this.idListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.idList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TakeAchievementRewardReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TakeAchievementRewardReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 72:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.idList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.idList_.addInt(input.readUInt32());
                                    break;
                                case 74:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.idList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.idList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.idList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TakeAchievementRewardReqOuterClass.internal_static_TakeAchievementRewardReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TakeAchievementRewardReqOuterClass.internal_static_TakeAchievementRewardReq_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeAchievementRewardReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TakeAchievementRewardReqOuterClass.TakeAchievementRewardReqOrBuilder
        public List<Integer> getIdListList() {
            return this.idList_;
        }

        @Override // emu.grasscutter.net.proto.TakeAchievementRewardReqOuterClass.TakeAchievementRewardReqOrBuilder
        public int getIdListCount() {
            return this.idList_.size();
        }

        @Override // emu.grasscutter.net.proto.TakeAchievementRewardReqOuterClass.TakeAchievementRewardReqOrBuilder
        public int getIdList(int index) {
            return this.idList_.getInt(index);
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
            if (getIdListList().size() > 0) {
                output.writeUInt32NoTag(74);
                output.writeUInt32NoTag(this.idListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.idList_.size(); i++) {
                output.writeUInt32NoTag(this.idList_.getInt(i));
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
            for (int i = 0; i < this.idList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.idList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.idListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TakeAchievementRewardReq)) {
                return equals(obj);
            }
            TakeAchievementRewardReq other = (TakeAchievementRewardReq) obj;
            return getIdListList().equals(other.getIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TakeAchievementRewardReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeAchievementRewardReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeAchievementRewardReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeAchievementRewardReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeAchievementRewardReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeAchievementRewardReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeAchievementRewardReq parseFrom(InputStream input) throws IOException {
            return (TakeAchievementRewardReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeAchievementRewardReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeAchievementRewardReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeAchievementRewardReq parseDelimitedFrom(InputStream input) throws IOException {
            return (TakeAchievementRewardReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TakeAchievementRewardReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeAchievementRewardReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeAchievementRewardReq parseFrom(CodedInputStream input) throws IOException {
            return (TakeAchievementRewardReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeAchievementRewardReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeAchievementRewardReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TakeAchievementRewardReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeAchievementRewardReqOuterClass$TakeAchievementRewardReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TakeAchievementRewardReqOrBuilder {
            private int bitField0_;
            private Internal.IntList idList_ = TakeAchievementRewardReq.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return TakeAchievementRewardReqOuterClass.internal_static_TakeAchievementRewardReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TakeAchievementRewardReqOuterClass.internal_static_TakeAchievementRewardReq_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeAchievementRewardReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TakeAchievementRewardReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.idList_ = TakeAchievementRewardReq.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TakeAchievementRewardReqOuterClass.internal_static_TakeAchievementRewardReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TakeAchievementRewardReq getDefaultInstanceForType() {
                return TakeAchievementRewardReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeAchievementRewardReq build() {
                TakeAchievementRewardReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeAchievementRewardReq buildPartial() {
                TakeAchievementRewardReq result = new TakeAchievementRewardReq(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.idList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.idList_ = this.idList_;
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
                if (other instanceof TakeAchievementRewardReq) {
                    return mergeFrom((TakeAchievementRewardReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TakeAchievementRewardReq other) {
                if (other == TakeAchievementRewardReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.idList_.isEmpty()) {
                    if (this.idList_.isEmpty()) {
                        this.idList_ = other.idList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureIdListIsMutable();
                        this.idList_.addAll(other.idList_);
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
                TakeAchievementRewardReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = TakeAchievementRewardReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TakeAchievementRewardReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.idList_ = TakeAchievementRewardReq.mutableCopy(this.idList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeAchievementRewardReqOuterClass.TakeAchievementRewardReqOrBuilder
            public List<Integer> getIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.idList_) : this.idList_;
            }

            @Override // emu.grasscutter.net.proto.TakeAchievementRewardReqOuterClass.TakeAchievementRewardReqOrBuilder
            public int getIdListCount() {
                return this.idList_.size();
            }

            @Override // emu.grasscutter.net.proto.TakeAchievementRewardReqOuterClass.TakeAchievementRewardReqOrBuilder
            public int getIdList(int index) {
                return this.idList_.getInt(index);
            }

            public Builder setIdList(int index, int value) {
                ensureIdListIsMutable();
                this.idList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addIdList(int value) {
                ensureIdListIsMutable();
                this.idList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllIdList(Iterable<? extends Integer> values) {
                ensureIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.idList_);
                onChanged();
                return this;
            }

            public Builder clearIdList() {
                this.idList_ = TakeAchievementRewardReq.emptyIntList();
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

        public static TakeAchievementRewardReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TakeAchievementRewardReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TakeAchievementRewardReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TakeAchievementRewardReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
