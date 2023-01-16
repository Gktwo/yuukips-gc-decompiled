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
import emu.grasscutter.net.proto.CodexTypeDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CodexDataFullNotifyOuterClass.class */
public final class CodexDataFullNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019CodexDataFullNotify.proto\u001a\u0013CodexTypeData.proto\"«\u0001\n\u0013CodexDataFullNotify\u0012&\n\u000etype_data_list\u0018\u000e \u0003(\u000b2\u000e.CodexTypeData\u0012#\n\u001blast_read_pushtips_codex_id\u0018\u0004 \u0001(\r\u0012\"\n\u001alast_read_pushtips_type_id\u0018\r \u0001(\r\u0012#\n\u001brecent_viewed_pushtips_list\u0018\u0001 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CodexTypeDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CodexDataFullNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CodexDataFullNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CodexDataFullNotify_descriptor, new String[]{"TypeDataList", "LastReadPushtipsCodexId", "LastReadPushtipsTypeId", "RecentViewedPushtipsList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CodexDataFullNotifyOuterClass$CodexDataFullNotifyOrBuilder.class */
    public interface CodexDataFullNotifyOrBuilder extends MessageOrBuilder {
        List<CodexTypeDataOuterClass.CodexTypeData> getTypeDataListList();

        CodexTypeDataOuterClass.CodexTypeData getTypeDataList(int i);

        int getTypeDataListCount();

        List<? extends CodexTypeDataOuterClass.CodexTypeDataOrBuilder> getTypeDataListOrBuilderList();

        CodexTypeDataOuterClass.CodexTypeDataOrBuilder getTypeDataListOrBuilder(int i);

        int getLastReadPushtipsCodexId();

        int getLastReadPushtipsTypeId();

        List<Integer> getRecentViewedPushtipsListList();

        int getRecentViewedPushtipsListCount();

        int getRecentViewedPushtipsList(int i);
    }

    private CodexDataFullNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CodexDataFullNotifyOuterClass$CodexDataFullNotify.class */
    public static final class CodexDataFullNotify extends GeneratedMessageV3 implements CodexDataFullNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TYPE_DATA_LIST_FIELD_NUMBER = 14;
        private List<CodexTypeDataOuterClass.CodexTypeData> typeDataList_;
        public static final int LAST_READ_PUSHTIPS_CODEX_ID_FIELD_NUMBER = 4;
        private int lastReadPushtipsCodexId_;
        public static final int LAST_READ_PUSHTIPS_TYPE_ID_FIELD_NUMBER = 13;
        private int lastReadPushtipsTypeId_;
        public static final int RECENT_VIEWED_PUSHTIPS_LIST_FIELD_NUMBER = 1;
        private Internal.IntList recentViewedPushtipsList_;
        private int recentViewedPushtipsListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final CodexDataFullNotify DEFAULT_INSTANCE = new CodexDataFullNotify();
        private static final Parser<CodexDataFullNotify> PARSER = new AbstractParser<CodexDataFullNotify>() { // from class: emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotify.1
            @Override // com.google.protobuf.Parser
            public CodexDataFullNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CodexDataFullNotify(input, extensionRegistry);
            }
        };

        private CodexDataFullNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.recentViewedPushtipsListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private CodexDataFullNotify() {
            this.recentViewedPushtipsListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.typeDataList_ = Collections.emptyList();
            this.recentViewedPushtipsList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CodexDataFullNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x0120 */
        private CodexDataFullNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.recentViewedPushtipsList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.recentViewedPushtipsList_.addInt(input.readUInt32());
                                break;
                            case 10:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.recentViewedPushtipsList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.recentViewedPushtipsList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 32:
                                this.lastReadPushtipsCodexId_ = input.readUInt32();
                                break;
                            case 104:
                                this.lastReadPushtipsTypeId_ = input.readUInt32();
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.typeDataList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.typeDataList_.add((CodexTypeDataOuterClass.CodexTypeData) input.readMessage(CodexTypeDataOuterClass.CodexTypeData.parser(), extensionRegistry));
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
                    this.recentViewedPushtipsList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.typeDataList_ = Collections.unmodifiableList(this.typeDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CodexDataFullNotifyOuterClass.internal_static_CodexDataFullNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CodexDataFullNotifyOuterClass.internal_static_CodexDataFullNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CodexDataFullNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
        public List<CodexTypeDataOuterClass.CodexTypeData> getTypeDataListList() {
            return this.typeDataList_;
        }

        @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
        public List<? extends CodexTypeDataOuterClass.CodexTypeDataOrBuilder> getTypeDataListOrBuilderList() {
            return this.typeDataList_;
        }

        @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
        public int getTypeDataListCount() {
            return this.typeDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
        public CodexTypeDataOuterClass.CodexTypeData getTypeDataList(int index) {
            return this.typeDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
        public CodexTypeDataOuterClass.CodexTypeDataOrBuilder getTypeDataListOrBuilder(int index) {
            return this.typeDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
        public int getLastReadPushtipsCodexId() {
            return this.lastReadPushtipsCodexId_;
        }

        @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
        public int getLastReadPushtipsTypeId() {
            return this.lastReadPushtipsTypeId_;
        }

        @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
        public List<Integer> getRecentViewedPushtipsListList() {
            return this.recentViewedPushtipsList_;
        }

        @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
        public int getRecentViewedPushtipsListCount() {
            return this.recentViewedPushtipsList_.size();
        }

        @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
        public int getRecentViewedPushtipsList(int index) {
            return this.recentViewedPushtipsList_.getInt(index);
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
            if (getRecentViewedPushtipsListList().size() > 0) {
                output.writeUInt32NoTag(10);
                output.writeUInt32NoTag(this.recentViewedPushtipsListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.recentViewedPushtipsList_.size(); i++) {
                output.writeUInt32NoTag(this.recentViewedPushtipsList_.getInt(i));
            }
            if (this.lastReadPushtipsCodexId_ != 0) {
                output.writeUInt32(4, this.lastReadPushtipsCodexId_);
            }
            if (this.lastReadPushtipsTypeId_ != 0) {
                output.writeUInt32(13, this.lastReadPushtipsTypeId_);
            }
            for (int i2 = 0; i2 < this.typeDataList_.size(); i2++) {
                output.writeMessage(14, this.typeDataList_.get(i2));
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
            for (int i = 0; i < this.recentViewedPushtipsList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.recentViewedPushtipsList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getRecentViewedPushtipsListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.recentViewedPushtipsListMemoizedSerializedSize = dataSize;
            if (this.lastReadPushtipsCodexId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.lastReadPushtipsCodexId_);
            }
            if (this.lastReadPushtipsTypeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.lastReadPushtipsTypeId_);
            }
            for (int i2 = 0; i2 < this.typeDataList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.typeDataList_.get(i2));
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
            if (!(obj instanceof CodexDataFullNotify)) {
                return equals(obj);
            }
            CodexDataFullNotify other = (CodexDataFullNotify) obj;
            return getTypeDataListList().equals(other.getTypeDataListList()) && getLastReadPushtipsCodexId() == other.getLastReadPushtipsCodexId() && getLastReadPushtipsTypeId() == other.getLastReadPushtipsTypeId() && getRecentViewedPushtipsListList().equals(other.getRecentViewedPushtipsListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getTypeDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getTypeDataListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 4)) + getLastReadPushtipsCodexId())) + 13)) + getLastReadPushtipsTypeId();
            if (getRecentViewedPushtipsListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 1)) + getRecentViewedPushtipsListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static CodexDataFullNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CodexDataFullNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CodexDataFullNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CodexDataFullNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CodexDataFullNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CodexDataFullNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CodexDataFullNotify parseFrom(InputStream input) throws IOException {
            return (CodexDataFullNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CodexDataFullNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodexDataFullNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CodexDataFullNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (CodexDataFullNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CodexDataFullNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodexDataFullNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CodexDataFullNotify parseFrom(CodedInputStream input) throws IOException {
            return (CodexDataFullNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CodexDataFullNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodexDataFullNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodexDataFullNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CodexDataFullNotifyOuterClass$CodexDataFullNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CodexDataFullNotifyOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<CodexTypeDataOuterClass.CodexTypeData, CodexTypeDataOuterClass.CodexTypeData.Builder, CodexTypeDataOuterClass.CodexTypeDataOrBuilder> typeDataListBuilder_;
            private int lastReadPushtipsCodexId_;
            private int lastReadPushtipsTypeId_;
            private List<CodexTypeDataOuterClass.CodexTypeData> typeDataList_ = Collections.emptyList();
            private Internal.IntList recentViewedPushtipsList_ = CodexDataFullNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return CodexDataFullNotifyOuterClass.internal_static_CodexDataFullNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CodexDataFullNotifyOuterClass.internal_static_CodexDataFullNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CodexDataFullNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CodexDataFullNotify.alwaysUseFieldBuilders) {
                    getTypeDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.typeDataListBuilder_ == null) {
                    this.typeDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.typeDataListBuilder_.clear();
                }
                this.lastReadPushtipsCodexId_ = 0;
                this.lastReadPushtipsTypeId_ = 0;
                this.recentViewedPushtipsList_ = CodexDataFullNotify.emptyIntList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CodexDataFullNotifyOuterClass.internal_static_CodexDataFullNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CodexDataFullNotify getDefaultInstanceForType() {
                return CodexDataFullNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodexDataFullNotify build() {
                CodexDataFullNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodexDataFullNotify buildPartial() {
                CodexDataFullNotify result = new CodexDataFullNotify(this);
                int i = this.bitField0_;
                if (this.typeDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.typeDataList_ = Collections.unmodifiableList(this.typeDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.typeDataList_ = this.typeDataList_;
                } else {
                    result.typeDataList_ = this.typeDataListBuilder_.build();
                }
                result.lastReadPushtipsCodexId_ = this.lastReadPushtipsCodexId_;
                result.lastReadPushtipsTypeId_ = this.lastReadPushtipsTypeId_;
                if ((this.bitField0_ & 2) != 0) {
                    this.recentViewedPushtipsList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.recentViewedPushtipsList_ = this.recentViewedPushtipsList_;
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
                if (other instanceof CodexDataFullNotify) {
                    return mergeFrom((CodexDataFullNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CodexDataFullNotify other) {
                if (other == CodexDataFullNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.typeDataListBuilder_ == null) {
                    if (!other.typeDataList_.isEmpty()) {
                        if (this.typeDataList_.isEmpty()) {
                            this.typeDataList_ = other.typeDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTypeDataListIsMutable();
                            this.typeDataList_.addAll(other.typeDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.typeDataList_.isEmpty()) {
                    if (this.typeDataListBuilder_.isEmpty()) {
                        this.typeDataListBuilder_.dispose();
                        this.typeDataListBuilder_ = null;
                        this.typeDataList_ = other.typeDataList_;
                        this.bitField0_ &= -2;
                        this.typeDataListBuilder_ = CodexDataFullNotify.alwaysUseFieldBuilders ? getTypeDataListFieldBuilder() : null;
                    } else {
                        this.typeDataListBuilder_.addAllMessages(other.typeDataList_);
                    }
                }
                if (other.getLastReadPushtipsCodexId() != 0) {
                    setLastReadPushtipsCodexId(other.getLastReadPushtipsCodexId());
                }
                if (other.getLastReadPushtipsTypeId() != 0) {
                    setLastReadPushtipsTypeId(other.getLastReadPushtipsTypeId());
                }
                if (!other.recentViewedPushtipsList_.isEmpty()) {
                    if (this.recentViewedPushtipsList_.isEmpty()) {
                        this.recentViewedPushtipsList_ = other.recentViewedPushtipsList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureRecentViewedPushtipsListIsMutable();
                        this.recentViewedPushtipsList_.addAll(other.recentViewedPushtipsList_);
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
                CodexDataFullNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = CodexDataFullNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CodexDataFullNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureTypeDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.typeDataList_ = new ArrayList(this.typeDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
            public List<CodexTypeDataOuterClass.CodexTypeData> getTypeDataListList() {
                if (this.typeDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.typeDataList_);
                }
                return this.typeDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
            public int getTypeDataListCount() {
                if (this.typeDataListBuilder_ == null) {
                    return this.typeDataList_.size();
                }
                return this.typeDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
            public CodexTypeDataOuterClass.CodexTypeData getTypeDataList(int index) {
                if (this.typeDataListBuilder_ == null) {
                    return this.typeDataList_.get(index);
                }
                return this.typeDataListBuilder_.getMessage(index);
            }

            public Builder setTypeDataList(int index, CodexTypeDataOuterClass.CodexTypeData value) {
                if (this.typeDataListBuilder_ != null) {
                    this.typeDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTypeDataListIsMutable();
                    this.typeDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTypeDataList(int index, CodexTypeDataOuterClass.CodexTypeData.Builder builderForValue) {
                if (this.typeDataListBuilder_ == null) {
                    ensureTypeDataListIsMutable();
                    this.typeDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.typeDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTypeDataList(CodexTypeDataOuterClass.CodexTypeData value) {
                if (this.typeDataListBuilder_ != null) {
                    this.typeDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTypeDataListIsMutable();
                    this.typeDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTypeDataList(int index, CodexTypeDataOuterClass.CodexTypeData value) {
                if (this.typeDataListBuilder_ != null) {
                    this.typeDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTypeDataListIsMutable();
                    this.typeDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTypeDataList(CodexTypeDataOuterClass.CodexTypeData.Builder builderForValue) {
                if (this.typeDataListBuilder_ == null) {
                    ensureTypeDataListIsMutable();
                    this.typeDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.typeDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTypeDataList(int index, CodexTypeDataOuterClass.CodexTypeData.Builder builderForValue) {
                if (this.typeDataListBuilder_ == null) {
                    ensureTypeDataListIsMutable();
                    this.typeDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.typeDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTypeDataList(Iterable<? extends CodexTypeDataOuterClass.CodexTypeData> values) {
                if (this.typeDataListBuilder_ == null) {
                    ensureTypeDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.typeDataList_);
                    onChanged();
                } else {
                    this.typeDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTypeDataList() {
                if (this.typeDataListBuilder_ == null) {
                    this.typeDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.typeDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTypeDataList(int index) {
                if (this.typeDataListBuilder_ == null) {
                    ensureTypeDataListIsMutable();
                    this.typeDataList_.remove(index);
                    onChanged();
                } else {
                    this.typeDataListBuilder_.remove(index);
                }
                return this;
            }

            public CodexTypeDataOuterClass.CodexTypeData.Builder getTypeDataListBuilder(int index) {
                return getTypeDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
            public CodexTypeDataOuterClass.CodexTypeDataOrBuilder getTypeDataListOrBuilder(int index) {
                if (this.typeDataListBuilder_ == null) {
                    return this.typeDataList_.get(index);
                }
                return this.typeDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
            public List<? extends CodexTypeDataOuterClass.CodexTypeDataOrBuilder> getTypeDataListOrBuilderList() {
                if (this.typeDataListBuilder_ != null) {
                    return this.typeDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.typeDataList_);
            }

            public CodexTypeDataOuterClass.CodexTypeData.Builder addTypeDataListBuilder() {
                return getTypeDataListFieldBuilder().addBuilder(CodexTypeDataOuterClass.CodexTypeData.getDefaultInstance());
            }

            public CodexTypeDataOuterClass.CodexTypeData.Builder addTypeDataListBuilder(int index) {
                return getTypeDataListFieldBuilder().addBuilder(index, CodexTypeDataOuterClass.CodexTypeData.getDefaultInstance());
            }

            public List<CodexTypeDataOuterClass.CodexTypeData.Builder> getTypeDataListBuilderList() {
                return getTypeDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CodexTypeDataOuterClass.CodexTypeData, CodexTypeDataOuterClass.CodexTypeData.Builder, CodexTypeDataOuterClass.CodexTypeDataOrBuilder> getTypeDataListFieldBuilder() {
                if (this.typeDataListBuilder_ == null) {
                    this.typeDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.typeDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.typeDataList_ = null;
                }
                return this.typeDataListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
            public int getLastReadPushtipsCodexId() {
                return this.lastReadPushtipsCodexId_;
            }

            public Builder setLastReadPushtipsCodexId(int value) {
                this.lastReadPushtipsCodexId_ = value;
                onChanged();
                return this;
            }

            public Builder clearLastReadPushtipsCodexId() {
                this.lastReadPushtipsCodexId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
            public int getLastReadPushtipsTypeId() {
                return this.lastReadPushtipsTypeId_;
            }

            public Builder setLastReadPushtipsTypeId(int value) {
                this.lastReadPushtipsTypeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearLastReadPushtipsTypeId() {
                this.lastReadPushtipsTypeId_ = 0;
                onChanged();
                return this;
            }

            private void ensureRecentViewedPushtipsListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.recentViewedPushtipsList_ = CodexDataFullNotify.mutableCopy(this.recentViewedPushtipsList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
            public List<Integer> getRecentViewedPushtipsListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.recentViewedPushtipsList_) : this.recentViewedPushtipsList_;
            }

            @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
            public int getRecentViewedPushtipsListCount() {
                return this.recentViewedPushtipsList_.size();
            }

            @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
            public int getRecentViewedPushtipsList(int index) {
                return this.recentViewedPushtipsList_.getInt(index);
            }

            public Builder setRecentViewedPushtipsList(int index, int value) {
                ensureRecentViewedPushtipsListIsMutable();
                this.recentViewedPushtipsList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addRecentViewedPushtipsList(int value) {
                ensureRecentViewedPushtipsListIsMutable();
                this.recentViewedPushtipsList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllRecentViewedPushtipsList(Iterable<? extends Integer> values) {
                ensureRecentViewedPushtipsListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.recentViewedPushtipsList_);
                onChanged();
                return this;
            }

            public Builder clearRecentViewedPushtipsList() {
                this.recentViewedPushtipsList_ = CodexDataFullNotify.emptyIntList();
                this.bitField0_ &= -3;
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

        public static CodexDataFullNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CodexDataFullNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CodexDataFullNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CodexDataFullNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CodexTypeDataOuterClass.getDescriptor();
    }
}
