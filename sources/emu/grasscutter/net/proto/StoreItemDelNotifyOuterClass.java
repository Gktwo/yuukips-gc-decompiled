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
import emu.grasscutter.net.proto.StoreTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StoreItemDelNotifyOuterClass.class */
public final class StoreItemDelNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018StoreItemDelNotify.proto\u001a\u000fStoreType.proto\"E\n\u0012StoreItemDelNotify\u0012\u0010\n\bguidList\u0018\u0006 \u0003(\u0004\u0012\u001d\n\tstoreType\u0018\n \u0001(\u000e2\n.StoreTypeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{StoreTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_StoreItemDelNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_StoreItemDelNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_StoreItemDelNotify_descriptor, new String[]{"GuidList", "StoreType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StoreItemDelNotifyOuterClass$StoreItemDelNotifyOrBuilder.class */
    public interface StoreItemDelNotifyOrBuilder extends MessageOrBuilder {
        List<Long> getGuidListList();

        int getGuidListCount();

        long getGuidList(int i);

        int getStoreTypeValue();

        StoreTypeOuterClass.StoreType getStoreType();
    }

    private StoreItemDelNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StoreItemDelNotifyOuterClass$StoreItemDelNotify.class */
    public static final class StoreItemDelNotify extends GeneratedMessageV3 implements StoreItemDelNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GUIDLIST_FIELD_NUMBER = 6;
        private Internal.LongList guidList_;
        private int guidListMemoizedSerializedSize;
        public static final int STORETYPE_FIELD_NUMBER = 10;
        private int storeType_;
        private byte memoizedIsInitialized;
        private static final StoreItemDelNotify DEFAULT_INSTANCE = new StoreItemDelNotify();
        private static final Parser<StoreItemDelNotify> PARSER = new AbstractParser<StoreItemDelNotify>() { // from class: emu.grasscutter.net.proto.StoreItemDelNotifyOuterClass.StoreItemDelNotify.1
            @Override // com.google.protobuf.Parser
            public StoreItemDelNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new StoreItemDelNotify(input, extensionRegistry);
            }
        };

        private StoreItemDelNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.guidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private StoreItemDelNotify() {
            this.guidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.guidList_ = emptyLongList();
            this.storeType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new StoreItemDelNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private StoreItemDelNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.guidList_ = newLongList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.guidList_.addLong(input.readUInt64());
                                break;
                            case 50:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.guidList_ = newLongList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.guidList_.addLong(input.readUInt64());
                                }
                                input.popLimit(limit);
                                break;
                            case 80:
                                this.storeType_ = input.readEnum();
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
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.guidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StoreItemDelNotifyOuterClass.internal_static_StoreItemDelNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StoreItemDelNotifyOuterClass.internal_static_StoreItemDelNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(StoreItemDelNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.StoreItemDelNotifyOuterClass.StoreItemDelNotifyOrBuilder
        public List<Long> getGuidListList() {
            return this.guidList_;
        }

        @Override // emu.grasscutter.net.proto.StoreItemDelNotifyOuterClass.StoreItemDelNotifyOrBuilder
        public int getGuidListCount() {
            return this.guidList_.size();
        }

        @Override // emu.grasscutter.net.proto.StoreItemDelNotifyOuterClass.StoreItemDelNotifyOrBuilder
        public long getGuidList(int index) {
            return this.guidList_.getLong(index);
        }

        @Override // emu.grasscutter.net.proto.StoreItemDelNotifyOuterClass.StoreItemDelNotifyOrBuilder
        public int getStoreTypeValue() {
            return this.storeType_;
        }

        @Override // emu.grasscutter.net.proto.StoreItemDelNotifyOuterClass.StoreItemDelNotifyOrBuilder
        public StoreTypeOuterClass.StoreType getStoreType() {
            StoreTypeOuterClass.StoreType result = StoreTypeOuterClass.StoreType.valueOf(this.storeType_);
            return result == null ? StoreTypeOuterClass.StoreType.UNRECOGNIZED : result;
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
            if (getGuidListList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.guidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.guidList_.size(); i++) {
                output.writeUInt64NoTag(this.guidList_.getLong(i));
            }
            if (this.storeType_ != StoreTypeOuterClass.StoreType.STORE_TYPE_NONE.getNumber()) {
                output.writeEnum(10, this.storeType_);
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
            for (int i = 0; i < this.guidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt64SizeNoTag(this.guidList_.getLong(i));
            }
            int size2 = 0 + dataSize;
            if (!getGuidListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.guidListMemoizedSerializedSize = dataSize;
            if (this.storeType_ != StoreTypeOuterClass.StoreType.STORE_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(10, this.storeType_);
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
            if (!(obj instanceof StoreItemDelNotify)) {
                return equals(obj);
            }
            StoreItemDelNotify other = (StoreItemDelNotify) obj;
            return getGuidListList().equals(other.getGuidListList()) && this.storeType_ == other.storeType_ && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getGuidListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getGuidListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 10)) + this.storeType_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static StoreItemDelNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StoreItemDelNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StoreItemDelNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StoreItemDelNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StoreItemDelNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StoreItemDelNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StoreItemDelNotify parseFrom(InputStream input) throws IOException {
            return (StoreItemDelNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static StoreItemDelNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StoreItemDelNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static StoreItemDelNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (StoreItemDelNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static StoreItemDelNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StoreItemDelNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static StoreItemDelNotify parseFrom(CodedInputStream input) throws IOException {
            return (StoreItemDelNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static StoreItemDelNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StoreItemDelNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(StoreItemDelNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StoreItemDelNotifyOuterClass$StoreItemDelNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StoreItemDelNotifyOrBuilder {
            private int bitField0_;
            private Internal.LongList guidList_ = StoreItemDelNotify.emptyLongList();
            private int storeType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return StoreItemDelNotifyOuterClass.internal_static_StoreItemDelNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StoreItemDelNotifyOuterClass.internal_static_StoreItemDelNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(StoreItemDelNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (StoreItemDelNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.guidList_ = StoreItemDelNotify.emptyLongList();
                this.bitField0_ &= -2;
                this.storeType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return StoreItemDelNotifyOuterClass.internal_static_StoreItemDelNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public StoreItemDelNotify getDefaultInstanceForType() {
                return StoreItemDelNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StoreItemDelNotify build() {
                StoreItemDelNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StoreItemDelNotify buildPartial() {
                StoreItemDelNotify result = new StoreItemDelNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.guidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.guidList_ = this.guidList_;
                result.storeType_ = this.storeType_;
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
                if (other instanceof StoreItemDelNotify) {
                    return mergeFrom((StoreItemDelNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(StoreItemDelNotify other) {
                if (other == StoreItemDelNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.guidList_.isEmpty()) {
                    if (this.guidList_.isEmpty()) {
                        this.guidList_ = other.guidList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureGuidListIsMutable();
                        this.guidList_.addAll(other.guidList_);
                    }
                    onChanged();
                }
                if (other.storeType_ != 0) {
                    setStoreTypeValue(other.getStoreTypeValue());
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
                StoreItemDelNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = StoreItemDelNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (StoreItemDelNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureGuidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.guidList_ = StoreItemDelNotify.mutableCopy(this.guidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.StoreItemDelNotifyOuterClass.StoreItemDelNotifyOrBuilder
            public List<Long> getGuidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.guidList_) : this.guidList_;
            }

            @Override // emu.grasscutter.net.proto.StoreItemDelNotifyOuterClass.StoreItemDelNotifyOrBuilder
            public int getGuidListCount() {
                return this.guidList_.size();
            }

            @Override // emu.grasscutter.net.proto.StoreItemDelNotifyOuterClass.StoreItemDelNotifyOrBuilder
            public long getGuidList(int index) {
                return this.guidList_.getLong(index);
            }

            public Builder setGuidList(int index, long value) {
                ensureGuidListIsMutable();
                this.guidList_.setLong(index, value);
                onChanged();
                return this;
            }

            public Builder addGuidList(long value) {
                ensureGuidListIsMutable();
                this.guidList_.addLong(value);
                onChanged();
                return this;
            }

            public Builder addAllGuidList(Iterable<? extends Long> values) {
                ensureGuidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.guidList_);
                onChanged();
                return this;
            }

            public Builder clearGuidList() {
                this.guidList_ = StoreItemDelNotify.emptyLongList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.StoreItemDelNotifyOuterClass.StoreItemDelNotifyOrBuilder
            public int getStoreTypeValue() {
                return this.storeType_;
            }

            public Builder setStoreTypeValue(int value) {
                this.storeType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.StoreItemDelNotifyOuterClass.StoreItemDelNotifyOrBuilder
            public StoreTypeOuterClass.StoreType getStoreType() {
                StoreTypeOuterClass.StoreType result = StoreTypeOuterClass.StoreType.valueOf(this.storeType_);
                return result == null ? StoreTypeOuterClass.StoreType.UNRECOGNIZED : result;
            }

            public Builder setStoreType(StoreTypeOuterClass.StoreType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.storeType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearStoreType() {
                this.storeType_ = 0;
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

        public static StoreItemDelNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StoreItemDelNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<StoreItemDelNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public StoreItemDelNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        StoreTypeOuterClass.getDescriptor();
    }
}
