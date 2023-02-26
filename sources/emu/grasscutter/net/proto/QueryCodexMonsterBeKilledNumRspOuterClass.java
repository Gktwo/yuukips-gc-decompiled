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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryCodexMonsterBeKilledNumRspOuterClass.class */
public final class QueryCodexMonsterBeKilledNumRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%QueryCodexMonsterBeKilledNumRsp.proto\"{\n\u001fQueryCodexMonsterBeKilledNumRsp\u0012\u0017\n\u000fbeKilledNumList\u0018\u000e \u0003(\r\u0012\u000f\n\u0007retcode\u0018\u0006 \u0001(\u0005\u0012\u0013\n\u000bcodexIdList\u0018\u0004 \u0003(\r\u0012\u0019\n\u0011beCapturedNumList\u0018\u0005 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_QueryCodexMonsterBeKilledNumRsp_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_QueryCodexMonsterBeKilledNumRsp_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f814xff89a67b = new GeneratedMessageV3.FieldAccessorTable(internal_static_QueryCodexMonsterBeKilledNumRsp_descriptor, new String[]{"BeKilledNumList", "Retcode", "CodexIdList", "BeCapturedNumList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryCodexMonsterBeKilledNumRspOuterClass$QueryCodexMonsterBeKilledNumRspOrBuilder.class */
    public interface QueryCodexMonsterBeKilledNumRspOrBuilder extends MessageOrBuilder {
        List<Integer> getBeKilledNumListList();

        int getBeKilledNumListCount();

        int getBeKilledNumList(int i);

        int getRetcode();

        List<Integer> getCodexIdListList();

        int getCodexIdListCount();

        int getCodexIdList(int i);

        List<Integer> getBeCapturedNumListList();

        int getBeCapturedNumListCount();

        int getBeCapturedNumList(int i);
    }

    private QueryCodexMonsterBeKilledNumRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryCodexMonsterBeKilledNumRspOuterClass$QueryCodexMonsterBeKilledNumRsp.class */
    public static final class QueryCodexMonsterBeKilledNumRsp extends GeneratedMessageV3 implements QueryCodexMonsterBeKilledNumRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BEKILLEDNUMLIST_FIELD_NUMBER = 14;
        private Internal.IntList beKilledNumList_;
        private int beKilledNumListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 6;
        private int retcode_;
        public static final int CODEXIDLIST_FIELD_NUMBER = 4;
        private Internal.IntList codexIdList_;
        private int codexIdListMemoizedSerializedSize;
        public static final int BECAPTUREDNUMLIST_FIELD_NUMBER = 5;
        private Internal.IntList beCapturedNumList_;
        private int beCapturedNumListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final QueryCodexMonsterBeKilledNumRsp DEFAULT_INSTANCE = new QueryCodexMonsterBeKilledNumRsp();
        private static final Parser<QueryCodexMonsterBeKilledNumRsp> PARSER = new AbstractParser<QueryCodexMonsterBeKilledNumRsp>() { // from class: emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRsp.1
            @Override // com.google.protobuf.Parser
            public QueryCodexMonsterBeKilledNumRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QueryCodexMonsterBeKilledNumRsp(input, extensionRegistry);
            }
        };

        private QueryCodexMonsterBeKilledNumRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.beKilledNumListMemoizedSerializedSize = -1;
            this.codexIdListMemoizedSerializedSize = -1;
            this.beCapturedNumListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private QueryCodexMonsterBeKilledNumRsp() {
            this.beKilledNumListMemoizedSerializedSize = -1;
            this.codexIdListMemoizedSerializedSize = -1;
            this.beCapturedNumListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.beKilledNumList_ = emptyIntList();
            this.codexIdList_ = emptyIntList();
            this.beCapturedNumList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QueryCodexMonsterBeKilledNumRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:101:0x01c6 */
        private QueryCodexMonsterBeKilledNumRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.codexIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.codexIdList_.addInt(input.readUInt32());
                                break;
                            case 34:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.codexIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.codexIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 40:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.beCapturedNumList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.beCapturedNumList_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.beCapturedNumList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.beCapturedNumList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 48:
                                this.retcode_ = input.readInt32();
                                break;
                            case 112:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.beKilledNumList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.beKilledNumList_.addInt(input.readUInt32());
                                break;
                            case 114:
                                int limit3 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.beKilledNumList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.beKilledNumList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit3);
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
                    this.codexIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.beCapturedNumList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.beKilledNumList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QueryCodexMonsterBeKilledNumRspOuterClass.internal_static_QueryCodexMonsterBeKilledNumRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QueryCodexMonsterBeKilledNumRspOuterClass.f814xff89a67b.ensureFieldAccessorsInitialized(QueryCodexMonsterBeKilledNumRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
        public List<Integer> getBeKilledNumListList() {
            return this.beKilledNumList_;
        }

        @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
        public int getBeKilledNumListCount() {
            return this.beKilledNumList_.size();
        }

        @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
        public int getBeKilledNumList(int index) {
            return this.beKilledNumList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
        public List<Integer> getCodexIdListList() {
            return this.codexIdList_;
        }

        @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
        public int getCodexIdListCount() {
            return this.codexIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
        public int getCodexIdList(int index) {
            return this.codexIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
        public List<Integer> getBeCapturedNumListList() {
            return this.beCapturedNumList_;
        }

        @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
        public int getBeCapturedNumListCount() {
            return this.beCapturedNumList_.size();
        }

        @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
        public int getBeCapturedNumList(int index) {
            return this.beCapturedNumList_.getInt(index);
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
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.codexIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.codexIdList_.size(); i++) {
                output.writeUInt32NoTag(this.codexIdList_.getInt(i));
            }
            if (getBeCapturedNumListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.beCapturedNumListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.beCapturedNumList_.size(); i2++) {
                output.writeUInt32NoTag(this.beCapturedNumList_.getInt(i2));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(6, this.retcode_);
            }
            if (getBeKilledNumListList().size() > 0) {
                output.writeUInt32NoTag(114);
                output.writeUInt32NoTag(this.beKilledNumListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.beKilledNumList_.size(); i3++) {
                output.writeUInt32NoTag(this.beKilledNumList_.getInt(i3));
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
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.beCapturedNumList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.beCapturedNumList_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getBeCapturedNumListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.beCapturedNumListMemoizedSerializedSize = dataSize2;
            if (this.retcode_ != 0) {
                size3 += CodedOutputStream.computeInt32Size(6, this.retcode_);
            }
            int dataSize3 = 0;
            for (int i3 = 0; i3 < this.beKilledNumList_.size(); i3++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.beKilledNumList_.getInt(i3));
            }
            int size4 = size3 + dataSize3;
            if (!getBeKilledNumListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.beKilledNumListMemoizedSerializedSize = dataSize3;
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof QueryCodexMonsterBeKilledNumRsp)) {
                return equals(obj);
            }
            QueryCodexMonsterBeKilledNumRsp other = (QueryCodexMonsterBeKilledNumRsp) obj;
            return getBeKilledNumListList().equals(other.getBeKilledNumListList()) && getRetcode() == other.getRetcode() && getCodexIdListList().equals(other.getCodexIdListList()) && getBeCapturedNumListList().equals(other.getBeCapturedNumListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getBeKilledNumListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getBeKilledNumListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 6)) + getRetcode();
            if (getCodexIdListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 4)) + getCodexIdListList().hashCode();
            }
            if (getBeCapturedNumListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 5)) + getBeCapturedNumListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static QueryCodexMonsterBeKilledNumRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryCodexMonsterBeKilledNumRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryCodexMonsterBeKilledNumRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryCodexMonsterBeKilledNumRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryCodexMonsterBeKilledNumRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QueryCodexMonsterBeKilledNumRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryCodexMonsterBeKilledNumRsp parseFrom(InputStream input) throws IOException {
            return (QueryCodexMonsterBeKilledNumRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QueryCodexMonsterBeKilledNumRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryCodexMonsterBeKilledNumRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QueryCodexMonsterBeKilledNumRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (QueryCodexMonsterBeKilledNumRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QueryCodexMonsterBeKilledNumRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryCodexMonsterBeKilledNumRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QueryCodexMonsterBeKilledNumRsp parseFrom(CodedInputStream input) throws IOException {
            return (QueryCodexMonsterBeKilledNumRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QueryCodexMonsterBeKilledNumRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryCodexMonsterBeKilledNumRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QueryCodexMonsterBeKilledNumRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QueryCodexMonsterBeKilledNumRspOuterClass$QueryCodexMonsterBeKilledNumRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QueryCodexMonsterBeKilledNumRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private Internal.IntList beKilledNumList_ = QueryCodexMonsterBeKilledNumRsp.emptyIntList();
            private Internal.IntList codexIdList_ = QueryCodexMonsterBeKilledNumRsp.emptyIntList();
            private Internal.IntList beCapturedNumList_ = QueryCodexMonsterBeKilledNumRsp.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return QueryCodexMonsterBeKilledNumRspOuterClass.internal_static_QueryCodexMonsterBeKilledNumRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QueryCodexMonsterBeKilledNumRspOuterClass.f814xff89a67b.ensureFieldAccessorsInitialized(QueryCodexMonsterBeKilledNumRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QueryCodexMonsterBeKilledNumRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.beKilledNumList_ = QueryCodexMonsterBeKilledNumRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.retcode_ = 0;
                this.codexIdList_ = QueryCodexMonsterBeKilledNumRsp.emptyIntList();
                this.bitField0_ &= -3;
                this.beCapturedNumList_ = QueryCodexMonsterBeKilledNumRsp.emptyIntList();
                this.bitField0_ &= -5;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QueryCodexMonsterBeKilledNumRspOuterClass.internal_static_QueryCodexMonsterBeKilledNumRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QueryCodexMonsterBeKilledNumRsp getDefaultInstanceForType() {
                return QueryCodexMonsterBeKilledNumRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QueryCodexMonsterBeKilledNumRsp build() {
                QueryCodexMonsterBeKilledNumRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QueryCodexMonsterBeKilledNumRsp buildPartial() {
                QueryCodexMonsterBeKilledNumRsp result = new QueryCodexMonsterBeKilledNumRsp(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.beKilledNumList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.beKilledNumList_ = this.beKilledNumList_;
                result.retcode_ = this.retcode_;
                if ((this.bitField0_ & 2) != 0) {
                    this.codexIdList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.codexIdList_ = this.codexIdList_;
                if ((this.bitField0_ & 4) != 0) {
                    this.beCapturedNumList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.beCapturedNumList_ = this.beCapturedNumList_;
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
                if (other instanceof QueryCodexMonsterBeKilledNumRsp) {
                    return mergeFrom((QueryCodexMonsterBeKilledNumRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QueryCodexMonsterBeKilledNumRsp other) {
                if (other == QueryCodexMonsterBeKilledNumRsp.getDefaultInstance()) {
                    return this;
                }
                if (!other.beKilledNumList_.isEmpty()) {
                    if (this.beKilledNumList_.isEmpty()) {
                        this.beKilledNumList_ = other.beKilledNumList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureBeKilledNumListIsMutable();
                        this.beKilledNumList_.addAll(other.beKilledNumList_);
                    }
                    onChanged();
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (!other.codexIdList_.isEmpty()) {
                    if (this.codexIdList_.isEmpty()) {
                        this.codexIdList_ = other.codexIdList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureCodexIdListIsMutable();
                        this.codexIdList_.addAll(other.codexIdList_);
                    }
                    onChanged();
                }
                if (!other.beCapturedNumList_.isEmpty()) {
                    if (this.beCapturedNumList_.isEmpty()) {
                        this.beCapturedNumList_ = other.beCapturedNumList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureBeCapturedNumListIsMutable();
                        this.beCapturedNumList_.addAll(other.beCapturedNumList_);
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
                QueryCodexMonsterBeKilledNumRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = QueryCodexMonsterBeKilledNumRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QueryCodexMonsterBeKilledNumRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureBeKilledNumListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.beKilledNumList_ = QueryCodexMonsterBeKilledNumRsp.mutableCopy(this.beKilledNumList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
            public List<Integer> getBeKilledNumListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.beKilledNumList_) : this.beKilledNumList_;
            }

            @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
            public int getBeKilledNumListCount() {
                return this.beKilledNumList_.size();
            }

            @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
            public int getBeKilledNumList(int index) {
                return this.beKilledNumList_.getInt(index);
            }

            public Builder setBeKilledNumList(int index, int value) {
                ensureBeKilledNumListIsMutable();
                this.beKilledNumList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addBeKilledNumList(int value) {
                ensureBeKilledNumListIsMutable();
                this.beKilledNumList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllBeKilledNumList(Iterable<? extends Integer> values) {
                ensureBeKilledNumListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.beKilledNumList_);
                onChanged();
                return this;
            }

            public Builder clearBeKilledNumList() {
                this.beKilledNumList_ = QueryCodexMonsterBeKilledNumRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
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

            private void ensureCodexIdListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.codexIdList_ = QueryCodexMonsterBeKilledNumRsp.mutableCopy(this.codexIdList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
            public List<Integer> getCodexIdListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.codexIdList_) : this.codexIdList_;
            }

            @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
            public int getCodexIdListCount() {
                return this.codexIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
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
                this.codexIdList_ = QueryCodexMonsterBeKilledNumRsp.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureBeCapturedNumListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.beCapturedNumList_ = QueryCodexMonsterBeKilledNumRsp.mutableCopy(this.beCapturedNumList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
            public List<Integer> getBeCapturedNumListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.beCapturedNumList_) : this.beCapturedNumList_;
            }

            @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
            public int getBeCapturedNumListCount() {
                return this.beCapturedNumList_.size();
            }

            @Override // emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumRspOuterClass.QueryCodexMonsterBeKilledNumRspOrBuilder
            public int getBeCapturedNumList(int index) {
                return this.beCapturedNumList_.getInt(index);
            }

            public Builder setBeCapturedNumList(int index, int value) {
                ensureBeCapturedNumListIsMutable();
                this.beCapturedNumList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addBeCapturedNumList(int value) {
                ensureBeCapturedNumListIsMutable();
                this.beCapturedNumList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllBeCapturedNumList(Iterable<? extends Integer> values) {
                ensureBeCapturedNumListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.beCapturedNumList_);
                onChanged();
                return this;
            }

            public Builder clearBeCapturedNumList() {
                this.beCapturedNumList_ = QueryCodexMonsterBeKilledNumRsp.emptyIntList();
                this.bitField0_ &= -5;
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

        public static QueryCodexMonsterBeKilledNumRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QueryCodexMonsterBeKilledNumRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QueryCodexMonsterBeKilledNumRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QueryCodexMonsterBeKilledNumRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
