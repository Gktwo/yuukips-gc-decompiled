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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockedFurnitureFormulaDataNotifyOuterClass.class */
public final class UnlockedFurnitureFormulaDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n(UnlockedFurnitureFormulaDataNotify.proto\"O\n\"UnlockedFurnitureFormulaDataNotify\u0012\u000e\n\u0006is_all\u0018\u0004 \u0001(\b\u0012\u0019\n\u0011furniture_id_list\u0018\u0002 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_UnlockedFurnitureFormulaDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_UnlockedFurnitureFormulaDataNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f901x7050f353 = new GeneratedMessageV3.FieldAccessorTable(internal_static_UnlockedFurnitureFormulaDataNotify_descriptor, new String[]{"IsAll", "FurnitureIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockedFurnitureFormulaDataNotifyOuterClass$UnlockedFurnitureFormulaDataNotifyOrBuilder.class */
    public interface UnlockedFurnitureFormulaDataNotifyOrBuilder extends MessageOrBuilder {
        boolean getIsAll();

        List<Integer> getFurnitureIdListList();

        int getFurnitureIdListCount();

        int getFurnitureIdList(int i);
    }

    private UnlockedFurnitureFormulaDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockedFurnitureFormulaDataNotifyOuterClass$UnlockedFurnitureFormulaDataNotify.class */
    public static final class UnlockedFurnitureFormulaDataNotify extends GeneratedMessageV3 implements UnlockedFurnitureFormulaDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_ALL_FIELD_NUMBER = 4;
        private boolean isAll_;
        public static final int FURNITURE_ID_LIST_FIELD_NUMBER = 2;
        private Internal.IntList furnitureIdList_;
        private int furnitureIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final UnlockedFurnitureFormulaDataNotify DEFAULT_INSTANCE = new UnlockedFurnitureFormulaDataNotify();
        private static final Parser<UnlockedFurnitureFormulaDataNotify> PARSER = new AbstractParser<UnlockedFurnitureFormulaDataNotify>() { // from class: emu.grasscutter.net.proto.UnlockedFurnitureFormulaDataNotifyOuterClass.UnlockedFurnitureFormulaDataNotify.1
            @Override // com.google.protobuf.Parser
            public UnlockedFurnitureFormulaDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new UnlockedFurnitureFormulaDataNotify(input, extensionRegistry);
            }
        };

        private UnlockedFurnitureFormulaDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.furnitureIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private UnlockedFurnitureFormulaDataNotify() {
            this.furnitureIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.furnitureIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UnlockedFurnitureFormulaDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UnlockedFurnitureFormulaDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.furnitureIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.furnitureIdList_.addInt(input.readUInt32());
                                    break;
                                case 18:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.furnitureIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.furnitureIdList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 32:
                                    this.isAll_ = input.readBool();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.furnitureIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return UnlockedFurnitureFormulaDataNotifyOuterClass.internal_static_UnlockedFurnitureFormulaDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UnlockedFurnitureFormulaDataNotifyOuterClass.f901x7050f353.ensureFieldAccessorsInitialized(UnlockedFurnitureFormulaDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.UnlockedFurnitureFormulaDataNotifyOuterClass.UnlockedFurnitureFormulaDataNotifyOrBuilder
        public boolean getIsAll() {
            return this.isAll_;
        }

        @Override // emu.grasscutter.net.proto.UnlockedFurnitureFormulaDataNotifyOuterClass.UnlockedFurnitureFormulaDataNotifyOrBuilder
        public List<Integer> getFurnitureIdListList() {
            return this.furnitureIdList_;
        }

        @Override // emu.grasscutter.net.proto.UnlockedFurnitureFormulaDataNotifyOuterClass.UnlockedFurnitureFormulaDataNotifyOrBuilder
        public int getFurnitureIdListCount() {
            return this.furnitureIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.UnlockedFurnitureFormulaDataNotifyOuterClass.UnlockedFurnitureFormulaDataNotifyOrBuilder
        public int getFurnitureIdList(int index) {
            return this.furnitureIdList_.getInt(index);
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
            if (getFurnitureIdListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.furnitureIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.furnitureIdList_.size(); i++) {
                output.writeUInt32NoTag(this.furnitureIdList_.getInt(i));
            }
            if (this.isAll_) {
                output.writeBool(4, this.isAll_);
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
            for (int i = 0; i < this.furnitureIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.furnitureIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getFurnitureIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.furnitureIdListMemoizedSerializedSize = dataSize;
            if (this.isAll_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isAll_);
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
            if (!(obj instanceof UnlockedFurnitureFormulaDataNotify)) {
                return equals(obj);
            }
            UnlockedFurnitureFormulaDataNotify other = (UnlockedFurnitureFormulaDataNotify) obj;
            return getIsAll() == other.getIsAll() && getFurnitureIdListList().equals(other.getFurnitureIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + Internal.hashBoolean(getIsAll());
            if (getFurnitureIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getFurnitureIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static UnlockedFurnitureFormulaDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnlockedFurnitureFormulaDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnlockedFurnitureFormulaDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnlockedFurnitureFormulaDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnlockedFurnitureFormulaDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnlockedFurnitureFormulaDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnlockedFurnitureFormulaDataNotify parseFrom(InputStream input) throws IOException {
            return (UnlockedFurnitureFormulaDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UnlockedFurnitureFormulaDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnlockedFurnitureFormulaDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UnlockedFurnitureFormulaDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (UnlockedFurnitureFormulaDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UnlockedFurnitureFormulaDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnlockedFurnitureFormulaDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UnlockedFurnitureFormulaDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (UnlockedFurnitureFormulaDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UnlockedFurnitureFormulaDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnlockedFurnitureFormulaDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UnlockedFurnitureFormulaDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockedFurnitureFormulaDataNotifyOuterClass$UnlockedFurnitureFormulaDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UnlockedFurnitureFormulaDataNotifyOrBuilder {
            private int bitField0_;
            private boolean isAll_;
            private Internal.IntList furnitureIdList_ = UnlockedFurnitureFormulaDataNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return UnlockedFurnitureFormulaDataNotifyOuterClass.internal_static_UnlockedFurnitureFormulaDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UnlockedFurnitureFormulaDataNotifyOuterClass.f901x7050f353.ensureFieldAccessorsInitialized(UnlockedFurnitureFormulaDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UnlockedFurnitureFormulaDataNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isAll_ = false;
                this.furnitureIdList_ = UnlockedFurnitureFormulaDataNotify.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UnlockedFurnitureFormulaDataNotifyOuterClass.internal_static_UnlockedFurnitureFormulaDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UnlockedFurnitureFormulaDataNotify getDefaultInstanceForType() {
                return UnlockedFurnitureFormulaDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UnlockedFurnitureFormulaDataNotify build() {
                UnlockedFurnitureFormulaDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UnlockedFurnitureFormulaDataNotify buildPartial() {
                UnlockedFurnitureFormulaDataNotify result = new UnlockedFurnitureFormulaDataNotify(this);
                int i = this.bitField0_;
                result.isAll_ = this.isAll_;
                if ((this.bitField0_ & 1) != 0) {
                    this.furnitureIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.furnitureIdList_ = this.furnitureIdList_;
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
                if (other instanceof UnlockedFurnitureFormulaDataNotify) {
                    return mergeFrom((UnlockedFurnitureFormulaDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UnlockedFurnitureFormulaDataNotify other) {
                if (other == UnlockedFurnitureFormulaDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsAll()) {
                    setIsAll(other.getIsAll());
                }
                if (!other.furnitureIdList_.isEmpty()) {
                    if (this.furnitureIdList_.isEmpty()) {
                        this.furnitureIdList_ = other.furnitureIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFurnitureIdListIsMutable();
                        this.furnitureIdList_.addAll(other.furnitureIdList_);
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
                UnlockedFurnitureFormulaDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = UnlockedFurnitureFormulaDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (UnlockedFurnitureFormulaDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.UnlockedFurnitureFormulaDataNotifyOuterClass.UnlockedFurnitureFormulaDataNotifyOrBuilder
            public boolean getIsAll() {
                return this.isAll_;
            }

            public Builder setIsAll(boolean value) {
                this.isAll_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAll() {
                this.isAll_ = false;
                onChanged();
                return this;
            }

            private void ensureFurnitureIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.furnitureIdList_ = UnlockedFurnitureFormulaDataNotify.mutableCopy(this.furnitureIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.UnlockedFurnitureFormulaDataNotifyOuterClass.UnlockedFurnitureFormulaDataNotifyOrBuilder
            public List<Integer> getFurnitureIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.furnitureIdList_) : this.furnitureIdList_;
            }

            @Override // emu.grasscutter.net.proto.UnlockedFurnitureFormulaDataNotifyOuterClass.UnlockedFurnitureFormulaDataNotifyOrBuilder
            public int getFurnitureIdListCount() {
                return this.furnitureIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.UnlockedFurnitureFormulaDataNotifyOuterClass.UnlockedFurnitureFormulaDataNotifyOrBuilder
            public int getFurnitureIdList(int index) {
                return this.furnitureIdList_.getInt(index);
            }

            public Builder setFurnitureIdList(int index, int value) {
                ensureFurnitureIdListIsMutable();
                this.furnitureIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFurnitureIdList(int value) {
                ensureFurnitureIdListIsMutable();
                this.furnitureIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFurnitureIdList(Iterable<? extends Integer> values) {
                ensureFurnitureIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.furnitureIdList_);
                onChanged();
                return this;
            }

            public Builder clearFurnitureIdList() {
                this.furnitureIdList_ = UnlockedFurnitureFormulaDataNotify.emptyIntList();
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

        public static UnlockedFurnitureFormulaDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UnlockedFurnitureFormulaDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UnlockedFurnitureFormulaDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UnlockedFurnitureFormulaDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
