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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryCodexMonsterBeKilledNumReqOuterClass.class */
public final class QueryCodexMonsterBeKilledNumReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%QueryCodexMonsterBeKilledNumReq.proto\"8\n\u001fQueryCodexMonsterBeKilledNumReq\u0012\u0015\n\rcodex_id_list\u0018\u0003 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_QueryCodexMonsterBeKilledNumReq_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_QueryCodexMonsterBeKilledNumReq_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f835x36ce0fcc = new GeneratedMessageV3.FieldAccessorTable(internal_static_QueryCodexMonsterBeKilledNumReq_descriptor, new String[]{"CodexIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryCodexMonsterBeKilledNumReqOuterClass$QueryCodexMonsterBeKilledNumReqOrBuilder.class */
    public interface QueryCodexMonsterBeKilledNumReqOrBuilder extends MessageOrBuilder {
        List<Integer> getCodexIdListList();

        int getCodexIdListCount();

        int getCodexIdList(int i);
    }

    private QueryCodexMonsterBeKilledNumReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryCodexMonsterBeKilledNumReqOuterClass$QueryCodexMonsterBeKilledNumReq.class */
    public static final class QueryCodexMonsterBeKilledNumReq extends GeneratedMessageV3 implements QueryCodexMonsterBeKilledNumReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CODEX_ID_LIST_FIELD_NUMBER = 3;
        private Internal.IntList codexIdList_;
        private int codexIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final QueryCodexMonsterBeKilledNumReq DEFAULT_INSTANCE = new QueryCodexMonsterBeKilledNumReq();
        private static final Parser<QueryCodexMonsterBeKilledNumReq> PARSER = new AbstractParser<QueryCodexMonsterBeKilledNumReq>() { // from class: emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumReqOuterClass.QueryCodexMonsterBeKilledNumReq.1
            @Override // com.google.protobuf.Parser
            public QueryCodexMonsterBeKilledNumReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QueryCodexMonsterBeKilledNumReq(input, extensionRegistry);
            }
        };

        private QueryCodexMonsterBeKilledNumReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.codexIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private QueryCodexMonsterBeKilledNumReq() {
            this.codexIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.codexIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QueryCodexMonsterBeKilledNumReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QueryCodexMonsterBeKilledNumReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.codexIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.codexIdList_.addInt(input.readUInt32());
                                    break;
                                case 26:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.codexIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.codexIdList_.addInt(input.readUInt32());
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
                    this.codexIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QueryCodexMonsterBeKilledNumReqOuterClass.internal_static_QueryCodexMonsterBeKilledNumReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QueryCodexMonsterBeKilledNumReqOuterClass.f835x36ce0fcc.ensureFieldAccessorsInitialized(QueryCodexMonsterBeKilledNumReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumReqOuterClass.QueryCodexMonsterBeKilledNumReqOrBuilder
        public List<Integer> getCodexIdListList() {
            return this.codexIdList_;
        }

        @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumReqOuterClass.QueryCodexMonsterBeKilledNumReqOrBuilder
        public int getCodexIdListCount() {
            return this.codexIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumReqOuterClass.QueryCodexMonsterBeKilledNumReqOrBuilder
        public int getCodexIdList(int index) {
            return this.codexIdList_.getInt(index);
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
            if (getCodexIdListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.codexIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.codexIdList_.size(); i++) {
                output.writeUInt32NoTag(this.codexIdList_.getInt(i));
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
            for (int i = 0; i < this.codexIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.codexIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getCodexIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.codexIdListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof QueryCodexMonsterBeKilledNumReq)) {
                return equals(obj);
            }
            QueryCodexMonsterBeKilledNumReq other = (QueryCodexMonsterBeKilledNumReq) obj;
            return getCodexIdListList().equals(other.getCodexIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getCodexIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getCodexIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static QueryCodexMonsterBeKilledNumReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryCodexMonsterBeKilledNumReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryCodexMonsterBeKilledNumReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryCodexMonsterBeKilledNumReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryCodexMonsterBeKilledNumReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryCodexMonsterBeKilledNumReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryCodexMonsterBeKilledNumReq parseFrom(InputStream input) throws IOException {
            return (QueryCodexMonsterBeKilledNumReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QueryCodexMonsterBeKilledNumReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryCodexMonsterBeKilledNumReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QueryCodexMonsterBeKilledNumReq parseDelimitedFrom(InputStream input) throws IOException {
            return (QueryCodexMonsterBeKilledNumReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QueryCodexMonsterBeKilledNumReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryCodexMonsterBeKilledNumReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QueryCodexMonsterBeKilledNumReq parseFrom(CodedInputStream input) throws IOException {
            return (QueryCodexMonsterBeKilledNumReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QueryCodexMonsterBeKilledNumReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryCodexMonsterBeKilledNumReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QueryCodexMonsterBeKilledNumReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryCodexMonsterBeKilledNumReqOuterClass$QueryCodexMonsterBeKilledNumReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QueryCodexMonsterBeKilledNumReqOrBuilder {
            private int bitField0_;
            private Internal.IntList codexIdList_ = QueryCodexMonsterBeKilledNumReq.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return QueryCodexMonsterBeKilledNumReqOuterClass.internal_static_QueryCodexMonsterBeKilledNumReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QueryCodexMonsterBeKilledNumReqOuterClass.f835x36ce0fcc.ensureFieldAccessorsInitialized(QueryCodexMonsterBeKilledNumReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QueryCodexMonsterBeKilledNumReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.codexIdList_ = QueryCodexMonsterBeKilledNumReq.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QueryCodexMonsterBeKilledNumReqOuterClass.internal_static_QueryCodexMonsterBeKilledNumReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QueryCodexMonsterBeKilledNumReq getDefaultInstanceForType() {
                return QueryCodexMonsterBeKilledNumReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QueryCodexMonsterBeKilledNumReq build() {
                QueryCodexMonsterBeKilledNumReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QueryCodexMonsterBeKilledNumReq buildPartial() {
                QueryCodexMonsterBeKilledNumReq result = new QueryCodexMonsterBeKilledNumReq(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.codexIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.codexIdList_ = this.codexIdList_;
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
                if (other instanceof QueryCodexMonsterBeKilledNumReq) {
                    return mergeFrom((QueryCodexMonsterBeKilledNumReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QueryCodexMonsterBeKilledNumReq other) {
                if (other == QueryCodexMonsterBeKilledNumReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.codexIdList_.isEmpty()) {
                    if (this.codexIdList_.isEmpty()) {
                        this.codexIdList_ = other.codexIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureCodexIdListIsMutable();
                        this.codexIdList_.addAll(other.codexIdList_);
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
                QueryCodexMonsterBeKilledNumReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = QueryCodexMonsterBeKilledNumReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QueryCodexMonsterBeKilledNumReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureCodexIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.codexIdList_ = QueryCodexMonsterBeKilledNumReq.mutableCopy(this.codexIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumReqOuterClass.QueryCodexMonsterBeKilledNumReqOrBuilder
            public List<Integer> getCodexIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.codexIdList_) : this.codexIdList_;
            }

            @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumReqOuterClass.QueryCodexMonsterBeKilledNumReqOrBuilder
            public int getCodexIdListCount() {
                return this.codexIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumReqOuterClass.QueryCodexMonsterBeKilledNumReqOrBuilder
            public int getCodexIdList(int index) {
                return this.codexIdList_.getInt(index);
            }

            public Builder setCodexIdList(int index, int value) {
                ensureCodexIdListIsMutable();
                this.codexIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addCodexIdList(int value) {
                ensureCodexIdListIsMutable();
                this.codexIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllCodexIdList(Iterable<? extends Integer> values) {
                ensureCodexIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.codexIdList_);
                onChanged();
                return this;
            }

            public Builder clearCodexIdList() {
                this.codexIdList_ = QueryCodexMonsterBeKilledNumReq.emptyIntList();
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

        public static QueryCodexMonsterBeKilledNumReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QueryCodexMonsterBeKilledNumReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QueryCodexMonsterBeKilledNumReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QueryCodexMonsterBeKilledNumReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
