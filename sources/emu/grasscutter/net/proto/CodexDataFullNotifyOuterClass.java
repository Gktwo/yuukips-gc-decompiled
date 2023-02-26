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
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019CodexDataFullNotify.proto\u001a\u0013CodexTypeData.proto\"\u0001\n\u0013CodexDataFullNotify\u0012 \n\u0018recentViewedPushtipsList\u0018\u0001 \u0003(\r\u0012\u001f\n\u0017lastReadPushtipsCodexId\u0018\u000b \u0001(\r\u0012\u001e\n\u0016lastReadPushtipsTypeId\u0018\n \u0001(\r\u0012$\n\ftypeDataList\u0018\b \u0003(\u000b2\u000e.CodexTypeDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CodexTypeDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CodexDataFullNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CodexDataFullNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CodexDataFullNotify_descriptor, new String[]{"RecentViewedPushtipsList", "LastReadPushtipsCodexId", "LastReadPushtipsTypeId", "TypeDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CodexDataFullNotifyOuterClass$CodexDataFullNotifyOrBuilder.class */
    public interface CodexDataFullNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getRecentViewedPushtipsListList();

        int getRecentViewedPushtipsListCount();

        int getRecentViewedPushtipsList(int i);

        int getLastReadPushtipsCodexId();

        int getLastReadPushtipsTypeId();

        List<CodexTypeDataOuterClass.CodexTypeData> getTypeDataListList();

        CodexTypeDataOuterClass.CodexTypeData getTypeDataList(int i);

        int getTypeDataListCount();

        List<? extends CodexTypeDataOuterClass.CodexTypeDataOrBuilder> getTypeDataListOrBuilderList();

        CodexTypeDataOuterClass.CodexTypeDataOrBuilder getTypeDataListOrBuilder(int i);
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
        public static final int RECENTVIEWEDPUSHTIPSLIST_FIELD_NUMBER = 1;
        private Internal.IntList recentViewedPushtipsList_;
        private int recentViewedPushtipsListMemoizedSerializedSize;
        public static final int LASTREADPUSHTIPSCODEXID_FIELD_NUMBER = 11;
        private int lastReadPushtipsCodexId_;
        public static final int LASTREADPUSHTIPSTYPEID_FIELD_NUMBER = 10;
        private int lastReadPushtipsTypeId_;
        public static final int TYPEDATALIST_FIELD_NUMBER = 8;
        private List<CodexTypeDataOuterClass.CodexTypeData> typeDataList_;
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
            this.recentViewedPushtipsList_ = emptyIntList();
            this.typeDataList_ = Collections.emptyList();
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
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.recentViewedPushtipsList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.recentViewedPushtipsList_.addInt(input.readUInt32());
                                break;
                            case 10:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.recentViewedPushtipsList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.recentViewedPushtipsList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 66:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.typeDataList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.typeDataList_.add((CodexTypeDataOuterClass.CodexTypeData) input.readMessage(CodexTypeDataOuterClass.CodexTypeData.parser(), extensionRegistry));
                                break;
                            case 80:
                                this.lastReadPushtipsTypeId_ = input.readUInt32();
                                break;
                            case 88:
                                this.lastReadPushtipsCodexId_ = input.readUInt32();
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
                    this.recentViewedPushtipsList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
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

        @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
        public int getLastReadPushtipsCodexId() {
            return this.lastReadPushtipsCodexId_;
        }

        @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
        public int getLastReadPushtipsTypeId() {
            return this.lastReadPushtipsTypeId_;
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
            for (int i2 = 0; i2 < this.typeDataList_.size(); i2++) {
                output.writeMessage(8, this.typeDataList_.get(i2));
            }
            if (this.lastReadPushtipsTypeId_ != 0) {
                output.writeUInt32(10, this.lastReadPushtipsTypeId_);
            }
            if (this.lastReadPushtipsCodexId_ != 0) {
                output.writeUInt32(11, this.lastReadPushtipsCodexId_);
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
            for (int i2 = 0; i2 < this.typeDataList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(8, this.typeDataList_.get(i2));
            }
            if (this.lastReadPushtipsTypeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.lastReadPushtipsTypeId_);
            }
            if (this.lastReadPushtipsCodexId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.lastReadPushtipsCodexId_);
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
            return getRecentViewedPushtipsListList().equals(other.getRecentViewedPushtipsListList()) && getLastReadPushtipsCodexId() == other.getLastReadPushtipsCodexId() && getLastReadPushtipsTypeId() == other.getLastReadPushtipsTypeId() && getTypeDataListList().equals(other.getTypeDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getRecentViewedPushtipsListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getRecentViewedPushtipsListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 11)) + getLastReadPushtipsCodexId())) + 10)) + getLastReadPushtipsTypeId();
            if (getTypeDataListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 8)) + getTypeDataListList().hashCode();
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
            private int lastReadPushtipsCodexId_;
            private int lastReadPushtipsTypeId_;
            private RepeatedFieldBuilderV3<CodexTypeDataOuterClass.CodexTypeData, CodexTypeDataOuterClass.CodexTypeData.Builder, CodexTypeDataOuterClass.CodexTypeDataOrBuilder> typeDataListBuilder_;
            private Internal.IntList recentViewedPushtipsList_ = CodexDataFullNotify.emptyIntList();
            private List<CodexTypeDataOuterClass.CodexTypeData> typeDataList_ = Collections.emptyList();

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
                this.recentViewedPushtipsList_ = CodexDataFullNotify.emptyIntList();
                this.bitField0_ &= -2;
                this.lastReadPushtipsCodexId_ = 0;
                this.lastReadPushtipsTypeId_ = 0;
                if (this.typeDataListBuilder_ == null) {
                    this.typeDataList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.typeDataListBuilder_.clear();
                }
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
                if ((this.bitField0_ & 1) != 0) {
                    this.recentViewedPushtipsList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.recentViewedPushtipsList_ = this.recentViewedPushtipsList_;
                result.lastReadPushtipsCodexId_ = this.lastReadPushtipsCodexId_;
                result.lastReadPushtipsTypeId_ = this.lastReadPushtipsTypeId_;
                if (this.typeDataListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.typeDataList_ = Collections.unmodifiableList(this.typeDataList_);
                        this.bitField0_ &= -3;
                    }
                    result.typeDataList_ = this.typeDataList_;
                } else {
                    result.typeDataList_ = this.typeDataListBuilder_.build();
                }
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
                if (!other.recentViewedPushtipsList_.isEmpty()) {
                    if (this.recentViewedPushtipsList_.isEmpty()) {
                        this.recentViewedPushtipsList_ = other.recentViewedPushtipsList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRecentViewedPushtipsListIsMutable();
                        this.recentViewedPushtipsList_.addAll(other.recentViewedPushtipsList_);
                    }
                    onChanged();
                }
                if (other.getLastReadPushtipsCodexId() != 0) {
                    setLastReadPushtipsCodexId(other.getLastReadPushtipsCodexId());
                }
                if (other.getLastReadPushtipsTypeId() != 0) {
                    setLastReadPushtipsTypeId(other.getLastReadPushtipsTypeId());
                }
                if (this.typeDataListBuilder_ == null) {
                    if (!other.typeDataList_.isEmpty()) {
                        if (this.typeDataList_.isEmpty()) {
                            this.typeDataList_ = other.typeDataList_;
                            this.bitField0_ &= -3;
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
                        this.bitField0_ &= -3;
                        this.typeDataListBuilder_ = CodexDataFullNotify.alwaysUseFieldBuilders ? getTypeDataListFieldBuilder() : null;
                    } else {
                        this.typeDataListBuilder_.addAllMessages(other.typeDataList_);
                    }
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

            private void ensureRecentViewedPushtipsListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.recentViewedPushtipsList_ = CodexDataFullNotify.mutableCopy(this.recentViewedPushtipsList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass.CodexDataFullNotifyOrBuilder
            public List<Integer> getRecentViewedPushtipsListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.recentViewedPushtipsList_) : this.recentViewedPushtipsList_;
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
                this.bitField0_ &= -2;
                onChanged();
                return this;
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

            private void ensureTypeDataListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.typeDataList_ = new ArrayList(this.typeDataList_);
                    this.bitField0_ |= 2;
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
                    this.bitField0_ &= -3;
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
                    this.typeDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.typeDataList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.typeDataList_ = null;
                }
                return this.typeDataListBuilder_;
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
