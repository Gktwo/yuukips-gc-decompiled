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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombineDataNotifyOuterClass.class */
public final class CombineDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017CombineDataNotify.proto\",\n\u0011CombineDataNotify\u0012\u0017\n\u000fcombine_id_list\u0018\u0007 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CombineDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CombineDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CombineDataNotify_descriptor, new String[]{"CombineIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombineDataNotifyOuterClass$CombineDataNotifyOrBuilder.class */
    public interface CombineDataNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getCombineIdListList();

        int getCombineIdListCount();

        int getCombineIdList(int i);
    }

    private CombineDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombineDataNotifyOuterClass$CombineDataNotify.class */
    public static final class CombineDataNotify extends GeneratedMessageV3 implements CombineDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COMBINE_ID_LIST_FIELD_NUMBER = 7;
        private Internal.IntList combineIdList_;
        private int combineIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final CombineDataNotify DEFAULT_INSTANCE = new CombineDataNotify();
        private static final Parser<CombineDataNotify> PARSER = new AbstractParser<CombineDataNotify>() { // from class: emu.grasscutter.net.proto.CombineDataNotifyOuterClass.CombineDataNotify.1
            @Override // com.google.protobuf.Parser
            public CombineDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CombineDataNotify(input, extensionRegistry);
            }
        };

        private CombineDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.combineIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private CombineDataNotify() {
            this.combineIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.combineIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CombineDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CombineDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 56:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.combineIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.combineIdList_.addInt(input.readUInt32());
                                    break;
                                case 58:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.combineIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.combineIdList_.addInt(input.readUInt32());
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
                    this.combineIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CombineDataNotifyOuterClass.internal_static_CombineDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CombineDataNotifyOuterClass.internal_static_CombineDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CombineDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CombineDataNotifyOuterClass.CombineDataNotifyOrBuilder
        public List<Integer> getCombineIdListList() {
            return this.combineIdList_;
        }

        @Override // emu.grasscutter.net.proto.CombineDataNotifyOuterClass.CombineDataNotifyOrBuilder
        public int getCombineIdListCount() {
            return this.combineIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.CombineDataNotifyOuterClass.CombineDataNotifyOrBuilder
        public int getCombineIdList(int index) {
            return this.combineIdList_.getInt(index);
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
            if (getCombineIdListList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.combineIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.combineIdList_.size(); i++) {
                output.writeUInt32NoTag(this.combineIdList_.getInt(i));
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
            for (int i = 0; i < this.combineIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.combineIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getCombineIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.combineIdListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CombineDataNotify)) {
                return equals(obj);
            }
            CombineDataNotify other = (CombineDataNotify) obj;
            return getCombineIdListList().equals(other.getCombineIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getCombineIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getCombineIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CombineDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombineDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombineDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombineDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombineDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombineDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombineDataNotify parseFrom(InputStream input) throws IOException {
            return (CombineDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CombineDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CombineDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (CombineDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CombineDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CombineDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (CombineDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CombineDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CombineDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombineDataNotifyOuterClass$CombineDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CombineDataNotifyOrBuilder {
            private int bitField0_;
            private Internal.IntList combineIdList_ = CombineDataNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return CombineDataNotifyOuterClass.internal_static_CombineDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CombineDataNotifyOuterClass.internal_static_CombineDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CombineDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CombineDataNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.combineIdList_ = CombineDataNotify.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CombineDataNotifyOuterClass.internal_static_CombineDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CombineDataNotify getDefaultInstanceForType() {
                return CombineDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CombineDataNotify build() {
                CombineDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CombineDataNotify buildPartial() {
                CombineDataNotify result = new CombineDataNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.combineIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.combineIdList_ = this.combineIdList_;
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
                if (other instanceof CombineDataNotify) {
                    return mergeFrom((CombineDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CombineDataNotify other) {
                if (other == CombineDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.combineIdList_.isEmpty()) {
                    if (this.combineIdList_.isEmpty()) {
                        this.combineIdList_ = other.combineIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureCombineIdListIsMutable();
                        this.combineIdList_.addAll(other.combineIdList_);
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
                CombineDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = CombineDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CombineDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureCombineIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.combineIdList_ = CombineDataNotify.mutableCopy(this.combineIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CombineDataNotifyOuterClass.CombineDataNotifyOrBuilder
            public List<Integer> getCombineIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.combineIdList_) : this.combineIdList_;
            }

            @Override // emu.grasscutter.net.proto.CombineDataNotifyOuterClass.CombineDataNotifyOrBuilder
            public int getCombineIdListCount() {
                return this.combineIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.CombineDataNotifyOuterClass.CombineDataNotifyOrBuilder
            public int getCombineIdList(int index) {
                return this.combineIdList_.getInt(index);
            }

            public Builder setCombineIdList(int index, int value) {
                ensureCombineIdListIsMutable();
                this.combineIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addCombineIdList(int value) {
                ensureCombineIdListIsMutable();
                this.combineIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllCombineIdList(Iterable<? extends Integer> values) {
                ensureCombineIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.combineIdList_);
                onChanged();
                return this;
            }

            public Builder clearCombineIdList() {
                this.combineIdList_ = CombineDataNotify.emptyIntList();
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

        public static CombineDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CombineDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CombineDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CombineDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
